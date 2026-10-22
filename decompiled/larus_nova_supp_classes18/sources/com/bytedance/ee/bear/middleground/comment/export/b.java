package com.bytedance.ee.bear.middleground.comment.export;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.ErrorBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.Reaction;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyData;
import com.bytedance.ee.util.ui.RecyclerItemsDiff;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T> implements RecyclerItemsDiff.a {
    public final /* synthetic */ ICardAdapter a;
    public final /* synthetic */ i b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ String d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ boolean f;

    public b(CardAdapter2 r1, com.bytedance.ee.bear.middleground.comment.uitls.p r2, boolean r3, String r4, boolean r5, boolean r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final Object a(Object r19, Object r20) {
        int r3 = CommentDiffUtils.a;
        ICardAdapter r4 = this.a;
        i r5 = this.b;
        if ((r19 instanceof CommentBean.CommentDetail) == false) goto L5;
        CommentBean.CommentDetail r1 = (CommentBean.CommentDetail) r19;
    L7:
        if ((r20 instanceof CommentBean.CommentDetail) == false) goto L9;
        CommentBean.CommentDetail r2 = (CommentBean.CommentDetail) r20;
    L10:
        boolean r6 = this.c;
        String r7 = this.d;
        boolean r8 = this.e;
        boolean r9 = this.f;
        Bundle r10 = new Bundle();
        if (r2 != null) goto L13;
    L15:
        boolean r14 = false;
    L17:
        if (r14 == false) goto L19;
        r10.putInt("QUOTE_MENU", 1);
    L19:
        if (r1 == null) goto L21;
        String r15 = r1.getContent();
    L22:
        if (r2 == null) goto L24;
        String r11 = r2.getContent();
    L26:
        if (TextUtils.equals(r15, r11) == false) goto L41;
        if (r2 != null) goto L29;
    L31:
        boolean r12 = false;
    L32:
        if (r12 == false) goto L42;
        if (r1 == null) goto L35;
        Integer r13 = Integer.valueOf(r1.getUpdate_timestamp());
    L36:
        if (r2 == null) goto L38;
        Integer r16 = Integer.valueOf(r2.getUpdate_timestamp());
    L40:
        if (Intrinsics.areEqual(r13, r16) == true) goto L42;
    L38:
        r16 = null;
        goto L40
    L35:
        r13 = null;
    L42:
        if (r2 != null) goto L44;
    L46:
        boolean r17 = false;
    L47:
        if (r17 == false) goto L50;
        if (r8 == true) goto L50;
        r10.putInt(CardAdapter.TEXT, 1);
    L50:
        if (r1 == null) goto L52;
        List<Reaction> r18 = r1.getReaction();
    L53:
        if (r2 == null) goto L55;
        List<Reaction> r21 = r2.getReaction();
    L57:
        if (Objects.equals(r18, r21) == false) goto L65;
        if (r2 == null) goto L60;
        List<Reaction> r22 = r2.getOriginalReaction();
    L61:
        if (r2 == null) goto L63;
        List<Reaction> r23 = r2.getReaction();
    L64:
        if (r22 != r23) goto L65;
    L66:
        if (r1 == null) goto L68;
        Boolean r24 = Boolean.valueOf(r1.isEditStatus());
    L69:
        if (r2 == null) goto L71;
        Boolean r25 = Boolean.valueOf(r2.isEditStatus());
    L73:
        if (Objects.equals(r24, r25) == true) goto L81;
        if (r2 == null) goto L79;
        if (r1 == null) goto L77;
        boolean r26 = r1.isEditStatus();
    L78:
        r2.setEditStatus(r26);
        goto L79
    L77:
        r26 = false;
    L79:
        r10.putInt("EDITSTATUS", 1);
    L81:
        if (CommentDiffUtils.c(r4, r2) == false) goto L83;
        r10.putInt("EDITSTATUS", 1);
    L83:
        if (r1 == null) goto L85;
        Boolean r27 = Boolean.valueOf(r1.isSending());
    L86:
        if (r2 == null) goto L88;
        Boolean r28 = Boolean.valueOf(r2.isSending());
    L90:
        if (Objects.equals(r27, r28) == false) goto L103;
        if (r1 == null) goto L95;
        ErrorBean r29 = r1.getError();
        if (r29 == null) goto L95;
        Integer r30 = Integer.valueOf(r29.code);
    L96:
        if (r2 == null) goto L100;
        ErrorBean r31 = r2.getError();
        if (r31 == null) goto L100;
        Integer r32 = Integer.valueOf(r31.code);
    L102:
        if (Intrinsics.areEqual(r30, r32) == false) goto L103;
    L104:
        if (r1 == null) goto L106;
        String r33 = r1.getName();
    L107:
        if (r2 == null) goto L109;
        String r34 = r2.getName();
    L111:
        if (Objects.equals(r33, r34) == true) goto L113;
        r10.putInt("NAME", 1);
    L113:
        if (r1 == null) goto L115;
        String r35 = r1.getTranslate_status();
    L116:
        if (r2 == null) goto L118;
        String r36 = r2.getTranslate_status();
    L120:
        if (Objects.equals(r35, r36) == false) goto L129;
        if (r1 == null) goto L123;
        String r37 = r1.getTranslate_content();
    L124:
        if (r2 == null) goto L126;
        String r38 = r2.getTranslate_content();
    L128:
        if (Objects.equals(r37, r38) == false) goto L129;
    L130:
        if (r1 == null) goto L134;
        CommentBean.CommentDetail.ExtraEntity r39 = r1.getExtra();
        if (r39 == null) goto L134;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r40 = r39.getImage_list();
    L135:
        if (r2 == null) goto L139;
        CommentBean.CommentDetail.ExtraEntity r41 = r2.getExtra();
        if (r41 == null) goto L139;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r42 = r41.getImage_list();
    L140:
        if (r40 == null) goto L176;
        if (r42 == null) goto L176;
        if (r40.size() != r42.size()) goto L180;
        int r110 = r42.size();
        int r111 = 0;
    L147:
        if (r111 >= r110) goto L179;
        CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r112 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) ListProtector.get(r40, r111);
        CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r113 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) ListProtector.get(r42, r111);
        String r0 = r112.getUuid();
        if (TextUtils.isEmpty(r0) == true) goto L159;
        int r114 = r110;
        if (TextUtils.equals(r0, r113.getUuid()) == true) goto L163;
        Map<String, String> r115 = u.a;
        if (TextUtils.isEmpty(r0) == false) goto L155;
        String r43 = null;
    L157:
        if (TextUtils.equals(r43, r113.getToken()) == true) goto L163;
    L155:
        r43 = (String) ((ConcurrentHashMap) u.a).get(r0);
    L163:
        if (r112.getSrc() == null) goto L170;
        if (r113.getSrc() == null) goto L170;
        if (r112.getSrc().equals(r113.getSrc()) == false) goto L180;
    L170:
        if (r112.getLoadFail() == r113.getLoadFail()) goto L173;
        r113.setLoadFail(r112.getLoadFail());
    L173:
        if (r112.getAreaMark().equals(r113.getAreaMark()) == false) goto L180;
        r111 = r111 + 1;
        r110 = r114;
        goto L147
    L159:
        r114 = r110;
        if (TextUtils.equals(r112.getToken(), r113.getToken()) == true) goto L163;
    L179:
        boolean r44 = false;
    L181:
        if (r44 == false) goto L183;
        int r45 = 1;
        r10.putInt("IMAGE", 1);
    L184:
        if (r6 == false) goto L186;
        r10.putInt("ACTIVITY_CONFIGURATION", r45);
    L186:
        if (r2 == null) goto L188;
        String r46 = r2.getReply_id();
    L190:
        if (StringsKt.equals$default(r46, r7, false, 2, null) == false) goto L192;
        r10.putInt("ANIMSTATUS", r45);
    L192:
        if (r1 == null) goto L196;
        CommentBean.CommentDetail.BitableExtraEntity r47 = r1.getBitableExtra();
        if (r47 == null) goto L196;
        Boolean r48 = Boolean.valueOf(r47.isMainComment());
    L197:
        if (r2 == null) goto L201;
        CommentBean.CommentDetail.BitableExtraEntity r49 = r2.getBitableExtra();
        if (r49 == null) goto L201;
        Boolean r50 = Boolean.valueOf(r49.isMainComment());
    L203:
        if (Intrinsics.areEqual(r48, r50) == true) goto L205;
        r10.putInt("IS_MAIN_DISCUSS", 1);
    L205:
        if (r1 == null) goto L207;
        SmartReplyData r51 = r1.getSmartReplyData();
    L208:
        if (r2 == null) goto L210;
        SmartReplyData r52 = r2.getSmartReplyData();
    L212:
        if (Objects.equals(r51, r52) == false) goto L221;
        if (r1 == null) goto L215;
        Boolean r53 = Boolean.valueOf(r1.isPerSmartReplyPreview());
    L216:
        if (r2 == null) goto L218;
        Boolean r54 = Boolean.valueOf(r2.isPerSmartReplyPreview());
    L220:
        if (Objects.equals(r53, r54) == false) goto L221;
    L222:
        w r55 = r4.getUiState();
        if (r55 != null) goto L225;
    L227:
        boolean r56 = false;
    L228:
        if (r56 == true) goto L236;
        if (r2 != null) goto L231;
    L233:
        boolean r57 = false;
    L234:
        if (r57 == false) goto L236;
        int r58 = 1;
        r10.putInt("QUOTE_MENU", 1);
    L237:
        if (r9 == false) goto L239;
        r10.putInt("QUOTE_MENU", r58);
    L239:
        w r59 = r4.getUiState();
        if (r59 != null) goto L242;
    L244:
        boolean r60 = false;
    L245:
        if (r60 == false) goto L253;
        w r61 = r4.getUiState();
        if (r61 != null) goto L249;
    L251:
        boolean r116 = false;
    L252:
        if (r116 == false) goto L253;
    L254:
        if (r1 == null) goto L256;
        Integer r62 = Integer.valueOf(r1.getModify());
    L257:
        if (r2 == null) goto L259;
        Integer r63 = Integer.valueOf(r2.getModify());
    L261:
        if (Intrinsics.areEqual(r62, r63) == true) goto L263;
        r10.putInt("MORE", 1);
    L263:
        return r10;
    L259:
        r63 = null;
        goto L261
    L256:
        r62 = null;
        goto L257
    L249:
        if (r61.e != r5.c().a()) goto L251;
        r116 = true;
    L253:
        r10.putInt("QUOTE_MENU", 1);
        goto L254
    L242:
        if (r59.d != r5.c().getComment()) goto L244;
        r60 = true;
        goto L245
    L231:
        if (r2.getCommentType() != 2) goto L233;
        r57 = true;
    L236:
        r58 = 1;
        goto L237
    L225:
        if (r55.c != r5.c().f()) goto L227;
        r56 = true;
        goto L228
    L218:
        r54 = null;
        goto L220
    L215:
        r53 = null;
    L221:
        r10.putInt("SMART_REPLY", 1);
        goto L222
    L210:
        r52 = null;
        goto L212
    L207:
        r51 = null;
    L201:
        r50 = null;
    L196:
        r48 = null;
        goto L197
    L188:
        r46 = null;
        goto L190
    L183:
        r45 = 1;
    L180:
        r44 = true;
    L176:
        if (r42 != null) goto L180;
        if (r40 == null) goto L179;
    L139:
        r42 = null;
    L134:
        r40 = null;
        goto L135
    L126:
        r38 = null;
        goto L128
    L123:
        r37 = null;
    L129:
        r10.putInt("TRANSLATE", 1);
        goto L130
    L118:
        r36 = null;
        goto L120
    L115:
        r35 = null;
        goto L116
    L109:
        r34 = null;
        goto L111
    L106:
        r33 = null;
    L100:
        r32 = null;
    L95:
        r30 = null;
    L103:
        r10.putInt(CardAdapter.SENDINGSTATUS, 1);
        goto L104
    L88:
        r28 = null;
        goto L90
    L85:
        r27 = null;
        goto L86
    L71:
        r25 = null;
        goto L73
    L68:
        r24 = null;
        goto L69
    L63:
        r23 = null;
        goto L64
    L60:
        r22 = null;
    L65:
        r10.putInt(CardAdapter.REACTION, 1);
        goto L66
    L55:
        r21 = null;
        goto L57
    L52:
        r18 = null;
        goto L53
    L44:
        if (r2.getReplyType() != (-1)) goto L46;
        r17 = true;
        goto L47
    L29:
        if (r2.getModify() != 1) goto L31;
        r12 = true;
    L41:
        r10.putInt(CardAdapter.TEXT, 1);
        goto L42
    L24:
        r11 = null;
        goto L26
    L21:
        r15 = null;
        goto L22
    L13:
        if (r2.getReplyType() != (-1)) goto L15;
        r14 = true;
        goto L17
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L7
    }
}
