package com.bytedance.ee.bear.middleground.comment.input;

import android.text.TextUtils;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceLog;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.middleground.comment.export.bean.VisibilityBean;
import com.bytedance.ee.bear.middleground.comment.widget.CommentEditText;
import com.bytedance.ee.bear.widget.AtEditText;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d2<T, R> implements Function {
    public final /* synthetic */ b2 a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ AtEditText c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ String e;
    public final /* synthetic */ List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> f;
    public final /* synthetic */ boolean g;

    public d2(b2 r1, boolean r2, CommentEditText r3, boolean r4, String r5, List r6, boolean r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public final Object apply(Object r26) {
        String r6 = (String) r26;
        Intrinsics.checkNotNullParameter(r6, "content");
        CommentInputRequest r2 = this.a.e;
        if (r2.is_whole == true) goto L5;
    L7:
        boolean r13 = false;
    L9:
        if (this.b == false) goto L13;
        AtEditText r3 = this.c;
        if (r3 == null) goto L13;
        r3.setText("");
    L13:
        CommentInputRequest r4 = this.a.e;
        String r7 = r4.comment_id;
        if (r7 != null) goto L16;
        String r15 = "";
    L17:
        String r5 = r4.reply_id;
        if (r5 != null) goto L20;
        String r14 = "";
    L21:
        String r8 = com.larksuite.framework.utils.l0.a().toString();
        if (this.d == true) goto L26;
        if (this.e != null) goto L26;
    L45:
        b2 r1 = this.a;
        gf5.d r9 = r1.c.N;
        if (r1.j() == false) goto L49;
        int r10 = 3;
    L58:
        String r11 = r15;
        String r12 = r14;
        int r16 = r10;
        boolean r17 = r13;
        ef5.h r18 = new ef5.h(r11, r12, r16, r17, this.b);
        r18.f = this.a.e.local_comment_id;
        r18.g = r8;
        r9.a(r18);
        if (this.a.j() == false) goto L67;
        tt5.a.h("Comment#InputViewModel", "editComment");
        af5.b r19 = this.a.c.Q;
        if (r19 == null) goto L65;
        com.bytedance.ee.bear.middleground.comment.performance.d r20 = r19.b();
        if (r20 == null) goto L65;
        r20.e(this.a.e.local_comment_id, "edit");
    L65:
        CommentInputRequest r21 = this.a.e;
        Map<Object, Object> r22 = r21.bizParams;
        int r110 = r21.getCommentType();
        boolean r111 = TextUtils.equals(CommentInputRequest.FROM_ADD_AREA_COMMENT, this.a.e.from);
        String r23 = r15;
        String r24 = r14;
        boolean r25 = r13;
        com.bytedance.ee.bear.rn.d r112 = new com.bytedance.ee.bear.rn.d(r23, r24, r6, this.f, this.d, r25, r22, this.g, r110, r111, 256);
        return this.a.d.G(r112);
    L67:
        if (r15.length() != 0) goto L69;
        boolean r27 = true;
    L70:
        if (r27 == false) goto L72;
    L87:
        boolean r28 = r13;
        tt5.a.h("Comment#InputViewModel", "createComment");
        b2 r29 = this.a;
        if (r29.e.need_loading == false) goto L90;
        Toast.showLoading(r29.c.getActivity(), this.a.c.getActivity().getText(2131887121));
    L90:
        af5.b r30 = this.a.c.Q;
        if (r30 == null) goto L95;
        com.bytedance.ee.bear.middleground.comment.performance.d r31 = r30.b();
        if (r31 == null) goto L95;
        r31.e(this.a.e.local_comment_id, "create");
    L95:
        CommentInputRequest r32 = this.a.e;
        VisibilityBean r33 = r32.visibilityBean;
        String r34 = r32.tmpCommentId;
        if (r34 != null) goto L98;
        String r113 = "";
    L99:
        String r35 = r32.quote;
        if (r35 != null) goto L102;
        r35 = "";
    L102:
        String r36 = r32.parent_type;
        String r114 = r32.parent_token;
        String r37 = r32.comment_id;
        String r115 = r32.reply_id;
        String r116 = r32.local_comment_id;
        String r117 = r32.position;
        Map<Object, Object> r118 = r32.bizParams;
        int r119 = r32.getCommentType();
        String r38 = r113;
        com.bytedance.ee.bear.rn.e r39 = new com.bytedance.ee.bear.rn.e(r35, r6, r37, this.d, r28, this.f, r38, r36, r114, r115, this.g, r116, r117, r118, null, r33, r119, null, 147456);
        return this.a.d.g(r39);
    L98:
        r113 = r34;
        goto L99
    L72:
        if (this.a.e.isCreate() == true) goto L87;
        tt5.a.h("Comment#InputViewModel", "replyComment");
        af5.b r40 = this.a.c.Q;
        if (r40 == null) goto L79;
        com.bytedance.ee.bear.middleground.comment.performance.d r41 = r40.b();
        if (r41 == null) goto L79;
        r41.e(r8, "reply");
    L79:
        CommentInputRequest r42 = this.a.e;
        String r43 = r42.tmpCommentId;
        if (r43 != null) goto L82;
        String r44 = "";
    L83:
        String r45 = r42.quote;
        if (r45 != null) goto L86;
        r45 = "";
    L86:
        String r120 = r42.reply_id;
        String r121 = r42.position;
        Map<Object, Object> r46 = r42.bizParams;
        int r122 = r42.getCommentType();
        SmartReplyDataForInsert r47 = this.a.l;
        boolean r210 = r13;
        String r48 = r45;
        com.bytedance.ee.bear.rn.e r49 = new com.bytedance.ee.bear.rn.e(r48, r6, r15, this.d, r210, this.f, r44, null, null, r120, this.g, null, r121, r46, r8, null, r122, r47, 35200);
        return this.a.d.B(r49);
    L82:
        r44 = r43;
        goto L83
    L69:
        r27 = false;
        goto L70
    L49:
        if (r15.length() != 0) goto L51;
        boolean r50 = true;
    L52:
        if (r50 == false) goto L54;
    L57:
        r10 = 1;
        goto L58
    L54:
        if (this.a.e.isCreate() == true) goto L57;
        r10 = 2;
        goto L58
    L51:
        r50 = false;
    L26:
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L45;
        if (this.a.j() == false) goto L31;
        String r51 = "edit";
    L40:
        StringBuilder r52 = new StringBuilder("[voiceSend] input type=");
        r52.append(r51);
        r52.append(", isAudio=");
        r52.append(this.d);
        r52.append(", contentOverride=");
        if (this.e == null) goto L43;
        boolean r53 = true;
    L44:
        r52.append(r53);
        r52.append(", images=");
        r52.append(this.f.size());
        r52.append(", whole=");
        r52.append(r13);
        r52.append(", shouldAuthorize=");
        r52.append(this.g);
        r52.append(", ");
        CommentVoiceLog.a.getClass();
        r52.append(CommentVoiceLog.d("commentId", r15));
        r52.append(", ");
        r52.append(CommentVoiceLog.d("replyId", r14));
        r52.append(", ");
        r52.append(CommentVoiceLog.i("content", r6));
        tt5.a.h("CommentVoice", r52.toString());
        goto L45
    L43:
        r53 = false;
        goto L44
    L31:
        if (r15.length() != 0) goto L33;
        boolean r54 = true;
    L34:
        if (r54 == false) goto L36;
    L39:
        r51 = "create";
        goto L40
    L36:
        if (this.a.e.isCreate() == true) goto L39;
        r51 = "reply";
        goto L40
    L33:
        r54 = false;
        goto L34
    L20:
        r14 = r5;
        goto L21
    L16:
        r15 = r7;
        goto L17
    L5:
        if (r2.isDrive == true) goto L7;
        r13 = true;
        goto L9
    }
}
