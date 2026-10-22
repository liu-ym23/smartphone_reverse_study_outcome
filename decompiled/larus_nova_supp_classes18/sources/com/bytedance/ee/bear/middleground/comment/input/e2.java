package com.bytedance.ee.bear.middleground.comment.input;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentArea;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.bean.DataEntity;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e2<T, R> implements Function {
    public final /* synthetic */ b2 a;
    public final /* synthetic */ List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CommentArea.Type.values().length];
            r0[CommentArea.Type.CONTENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CommentArea.Type.AREA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e2(b2 r1, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r15) {
        String r16 = (String) r15;
        String r0 = "";
        Intrinsics.checkNotNullParameter(r16, "res");
        int r1 = com.bytedance.ee.bear.middleground.comment.uitls.n.a;
        Intrinsics.checkNotNullParameter(r16, WikiFolderPushPlugin.DATA);
        CommentArea.Type r2 = null;
        DataEntity r3 = (DataEntity) JSON.parseObject(r16, DataEntity.class);     // Catch: Exception -> L14
        if (r3 == null) goto L11;
        DataEntity.Entity r4 = r3.getData();     // Catch: Exception -> L14
        if (r4 == null) goto L11;
        DataEntity.Entity.BodyEntity r5 = r4.getBody();     // Catch: Exception -> L14
        if (r5 == null) goto L11;
        String r6 = r5.getData();     // Catch: Exception -> L14
        if (r6 == null) goto L11;
    L12:
        DataEntity.Entity.BodyEntity.ResultEntity r7 = (DataEntity.Entity.BodyEntity.ResultEntity) JSON.parseObject(r6, DataEntity.Entity.BodyEntity.ResultEntity.class);     // Catch: Exception -> L14
    L15:
        if (r7 == null) goto L75;
        b2 r8 = this.a;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r9 = this.b;
        if (sbb.e.l.getType().equals(r8.c.k.getType()) == false) goto L75;
        CommentBean r10 = r7.getComment();
        if (r10 == null) goto L22;
        String r11 = r10.getComment_id();
        if (r11 == null) goto L22;
    L24:
        if (TextUtils.isEmpty(r11) == true) goto L75;
        CommentBean r12 = r7.getComment();
        boolean r13 = false;
        if (r12 == null) goto L30;
        List<CommentBean.CommentDetail> r14 = r12.getComment_list();
        if (r14 == null) goto L30;
        int r17 = r14.size();
    L31:
        if (r17 <= 0) goto L75;
        String r18 = "discussion";
        if (r8.j() == false) goto L45;
        com.bytedance.ee.bear.middleground.comment.uitls.p r19 = r8.c;
        com.bytedance.ee.bear.middleground.comment.uitls.h r20 = r19.d0;
        CommentInputRequest r21 = r8.e;
        String r110 = r21.comment_id;
        if (r110 != null) goto L37;
        r110 = "";
    L37:
        String r22 = r21.reply_id;
        if (r22 != null) goto L40;
        r22 = "";
    L40:
        Pair[] r23 = new Pair[2];
        if (r19.V == true) goto L44;
        r18 = "comment";
    L44:
        r23[0] = TuplesKt.to(ResourceData.KEY_TYPE, r18);
        r23[1] = TuplesKt.to("comment_visible_range", r8.e.visibilityBean.getReportVisibility());
        r20.g("edit_confirm", r110, r22, MapsKt.mapOf(r23));
        goto L75
    L45:
        Pair[] r24 = new Pair[1];
        if (r8.c.V == true) goto L49;
        r18 = "comment";
    L49:
        r24[0] = TuplesKt.to(ResourceData.KEY_TYPE, r18);
        Map<String, String> r25 = MapsKt.mutableMapOf(r24);
        if (r7.getComment().getComment_list().size() != 1) goto L52;
        boolean r111 = true;
    L53:
        r25.put("is_first_flag", String.valueOf(r111));
        r25.put("is_content_image_flag", String.valueOf(!r9.isEmpty()));
        CommentArea r26 = r8.c.g0;
        if (r26.a == true) goto L56;
    L58:
        boolean r27 = false;
    L59:
        r25.put("is_part_image_flag", String.valueOf(r27));
        r25.put("comment_visible_range", r8.e.visibilityBean.getReportVisibility());
        CommentArea.Type r28 = r8.c.g0.getType();
        if (r28 != CommentArea.Type.NONE) goto L62;
    L64:
        if (r13 == false) goto L66;
        r2 = r28;
    L66:
        if (r2 == null) goto L74;
        int r29 = a.a[r2.ordinal()];
        if (r29 == 1) goto L72;
        if (r29 == 2) goto L71;
        String r30 = "";
    L73:
        r25.put("comment_add_type", r30);
        goto L74
    L71:
        r30 = "frame_select";
        goto L73
    L72:
        r30 = "line_select";
    L74:
        r8.c.d0.g("add_comment", r7.getComment().getComment_id(), ((CommentBean.CommentDetail) ListProtector.get(r7.getComment().getComment_list(), CollectionsKt.getLastIndex(r7.getComment().getComment_list()))).getReply_id(), r25);
        goto L75
    L62:
        if (r28 == CommentArea.Type.WHOLE_PAGE) goto L64;
        r13 = true;
        goto L64
    L56:
        if (r26.b == false) goto L58;
        r27 = true;
        goto L59
    L52:
        r111 = false;
    L30:
        r17 = 0;
    L22:
        r11 = "";
    L75:
        b2 r31 = this.a;
        if (r7 == null) goto L83;
        CommentBean r32 = r7.getComment();
        if (r32 == null) goto L83;
        String r33 = r32.getComment_id();
        if (r33 == null) goto L83;
        r0 = r33;
    L83:
        r31.j = r0;
        return r16;
    L11:
        r6 = "";
    L14:
        tt5.a.d("CommentTo", "data format error: " + r16);
        r7 = null;
        goto L15
    }
}
