package com.bytedance.ee.bear.middleground.comment.extension.addins;

import com.bytedance.ee.bear.middleground.comment.card.p1;
import com.bytedance.ee.bear.middleground.comment.draft.DraftStoreManager;
import com.bytedance.ee.bear.middleground.comment.export.CommentStyle;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.middleground.comment.export.draft.DraftEntity;
import com.bytedance.ee.bear.middleground.comment.input.b2;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q extends com.bytedance.ee.bear.middleground.comment.extension.addins.b {
    public ze5.b b;
    public String c;
    public String d;

    public final class a extends ff5.a<ef5.h> {
        public final /* synthetic */ q a;

        public a(q r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r9) {
            ef5.h r10 = (ef5.h) r9;
            Intrinsics.checkNotNullParameter(r10, "event");
            if (r10.e == false) goto L44;
            int r0 = r10.c;
            SmartReplyDataForInsert r2 = null;
            if (r0 != 1) goto L8;
            ze5.b r1 = this.a.b;
            if (r1 != null) goto L37;
            Intrinsics.throwUninitializedPropertyAccessException("draftStore");
            r1 = null;
        L37:
            int r3 = com.bytedance.ee.bear.middleground.comment.draft.c.a;
            r1.e(com.bytedance.ee.bear.middleground.comment.draft.c.b(null, null, r10.d, 3), null);
            return;
        L8:
            if (r0 == 2) goto L28;
            if (r0 == 3) goto L11;
            tt5.a.k("Comment#DraftAddin", "unknown send type: " + r10.c);
            return;
        L11:
            ze5.b r4 = this.a.b;
            if (r4 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("draftStore");
            r4 = null;
        L14:
            int r5 = com.bytedance.ee.bear.middleground.comment.draft.c.a;
            r4.e(com.bytedance.ee.bear.middleground.comment.draft.c.b(r10.a, r10.b, false, 4), null);
            ze5.b r6 = this.a.b;
            if (r6 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("draftStore");
            r6 = null;
        L17:
            DraftEntity r11 = r6.a(com.bytedance.ee.bear.middleground.comment.draft.c.b(r10.a, null, false, 6));
            p1 r7 = this.a.getContext().c();
            if (r7 == null) goto L40;
            if (r11 == null) goto L21;
            String r8 = r11.getContent();
        L22:
            if (r11 == null) goto L24;
            List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r12 = r11.getImgList();
        L25:
            if (r11 == null) goto L27;
            r2 = r11.getSmartReplyDataForInsert();
        L27:
            r7.bG(r8, r12, r2);
            return;
        L24:
            r12 = null;
            goto L25
        L21:
            r8 = null;
            goto L22
        L40:
            return;
        L28:
            ze5.b r13 = this.a.b;
            if (r13 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("draftStore");
            r13 = null;
        L31:
            int r14 = com.bytedance.ee.bear.middleground.comment.draft.c.a;
            r13.e(com.bytedance.ee.bear.middleground.comment.draft.c.b(r10.a, null, false, 6), null);
            p1 r15 = this.a.getContext().c();
            if (r15 == null) goto L42;
            r15.bG(null, null, null);
            return;
        L42:
            return;
        }
    }

    public final class b extends ff5.a<ef5.i> {
        public final /* synthetic */ q a;

        public b(q r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r6) {
            ef5.i r7 = (ef5.i) r6;
            Intrinsics.checkNotNullParameter(r7, "event");
            if (r7.a == null) goto L20;
            ze5.b r0 = this.a.b;
            SmartReplyDataForInsert r1 = null;
            if (r0 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("draftStore");
            r0 = null;
        L7:
            int r2 = com.bytedance.ee.bear.middleground.comment.draft.c.a;
            DraftEntity r3 = r0.a(com.bytedance.ee.bear.middleground.comment.draft.c.b(r7.a, null, false, 6));
            p1 r4 = this.a.getContext().c();
            if (r4 == null) goto L18;
            if (r3 == null) goto L11;
            String r5 = r3.getContent();
        L12:
            if (r3 == null) goto L14;
            List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r8 = r3.getImgList();
        L15:
            if (r3 == null) goto L17;
            r1 = r3.getSmartReplyDataForInsert();
        L17:
            r4.bG(r5, r8, r1);
            goto L18
        L14:
            r8 = null;
            goto L15
        L11:
            r5 = null;
        L18:
            this.a.d = r7.a;
            return;
        }
    }

    public final class c extends ff5.a<ef5.j> {
        public final /* synthetic */ q a;

        public c(q r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r6) {
            ef5.j r7 = (ef5.j) r6;
            Intrinsics.checkNotNullParameter(r7, "event");
            ze5.b r0 = this.a.b;
            SmartReplyDataForInsert r1 = null;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("draftStore");
            r0 = null;
        L5:
            int r2 = com.bytedance.ee.bear.middleground.comment.draft.c.a;
            DraftEntity r3 = r0.a(com.bytedance.ee.bear.middleground.comment.draft.c.b(r7.c, null, false, 6));
            p1 r4 = this.a.getContext().c();
            if (r4 == null) goto L16;
            if (r3 == null) goto L9;
            String r5 = r3.getContent();
        L10:
            if (r3 == null) goto L12;
            List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r8 = r3.getImgList();
        L13:
            if (r3 == null) goto L15;
            r1 = r3.getSmartReplyDataForInsert();
        L15:
            r4.bG(r5, r8, r1);
            goto L16
        L12:
            r8 = null;
            goto L13
        L9:
            r5 = null;
        L16:
            this.a.d = r7.c;
        }
    }

    public static final class d {
    }

    public final class e extends ff5.a<ef5.m> {
        public final /* synthetic */ q a;

        public e(q r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r7) {
            ef5.m r8 = (ef5.m) r7;
            Intrinsics.checkNotNullParameter(r8, "event");
            Integer r0 = r8.b;
            if (r0 != null) goto L5;
            this.a.d = "";
            return;
        L5:
            CommentBean r1 = (CommentBean) CollectionsKt.getOrNull(r8.a, r0.intValue());
            SmartReplyDataForInsert r2 = null;
            if (r1 == null) goto L8;
            String r3 = r1.getComment_id();
        L9:
            if (r3 != null) goto L11;
            tt5.a.k("Comment#DraftAddin", "DataUpdatedEvent with empty commentId at position: " + r8.b + ", event.data.length = " + r8.a);
            return;
        L11:
            String r4 = this.a.d;
            boolean r5 = true;
            if (r4 != null) goto L14;
        L17:
            boolean r6 = true;
        L18:
            if (r6 == false) goto L20;
        L24:
            r5 = false;
        L26:
            if (this.a.getContext().getConfig().n != CommentStyle.HALF_SCREEN) goto L28;
            if (r5 == true) goto L28;
        L46:
            this.a.d = r3;
            return;
        L28:
            ze5.b r9 = this.a.b;
            if (r9 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("draftStore");
            r9 = null;
        L31:
            int r10 = com.bytedance.ee.bear.middleground.comment.draft.c.a;
            CommentBean r11 = (CommentBean) CollectionsKt.getOrNull(r8.a, r8.b.intValue());
            if (r11 == null) goto L34;
            String r12 = r11.getComment_id();
        L35:
            DraftEntity r13 = r9.a(com.bytedance.ee.bear.middleground.comment.draft.c.b(r12, null, false, 6));
            p1 r14 = this.a.getContext().c();
            if (r14 == null) goto L46;
            if (r13 == null) goto L39;
            String r15 = r13.getContent();
        L40:
            if (r13 == null) goto L42;
            List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r16 = r13.getImgList();
        L43:
            if (r13 == null) goto L45;
            r2 = r13.getSmartReplyDataForInsert();
        L45:
            r14.bG(r15, r16, r2);
            goto L46
        L42:
            r16 = null;
            goto L43
        L39:
            r15 = null;
            goto L40
        L34:
            r12 = null;
            goto L35
        L20:
            if (Intrinsics.areEqual(r8.b, r8.c) == false) goto L24;
            if (Intrinsics.areEqual(this.a.d, r3) == true) goto L24;
        L14:
            if (r4.length() == 0) goto L17;
            r6 = false;
            goto L18
        L8:
            r3 = null;
            goto L9
        }
    }

    public final class f extends ff5.a<ef5.q> {
        public final /* synthetic */ q a;

        public f(q r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r6) {
            ef5.q r7 = (ef5.q) r6;
            Intrinsics.checkNotNullParameter(r7, "event");
            SmartReplyDataForInsert r2 = null;
            if (r7.c == false) goto L9;
            ze5.b r0 = this.a.b;
            if (r0 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("draftStore");
            r0 = null;
        L7:
            q r3 = this.a;
            kf5.b r8 = r7.d;
            r3.getClass();
            r0.e(q.d(r8), null);
        L14:
            p1 r9 = this.a.getContext().c();
            if (r9 == null) goto L33;
            String r10 = r9.UT();
            if (r10 == null) goto L34;
            q r1 = this.a;
            ze5.b r4 = r1.b;
            if (r4 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("draftStore");
            r4 = null;
        L21:
            DraftEntity r11 = r4.a(com.bytedance.ee.bear.middleground.comment.draft.c.b(r10, null, false, 6));
            p1 r5 = r1.getContext().c();
            if (r5 == null) goto L35;
            if (r11 == null) goto L25;
            String r12 = r11.getContent();
        L26:
            if (r11 == null) goto L28;
            List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r13 = r11.getImgList();
        L29:
            if (r11 == null) goto L31;
            r2 = r11.getSmartReplyDataForInsert();
        L31:
            r5.bG(r12, r13, r2);
            return;
        L28:
            r13 = null;
            goto L29
        L25:
            r12 = null;
            goto L26
        L35:
            return;
        L34:
            return;
        L33:
            return;
        L9:
            if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.doc.sent_image_comment_region_add") == true) goto L14;
            ze5.b r14 = this.a.b;
            if (r14 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("draftStore");
            r14 = null;
        L13:
            q r15 = this.a;
            kf5.b r16 = r7.d;
            r15.getClass();
            r14.d(q.d(r16), r7.a);
            goto L14
        }
    }

    public final class g extends ff5.a<ef5.s> {
        public final /* synthetic */ q a;

        public g(q r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r9) {
            ef5.s r10 = (ef5.s) r9;
            Intrinsics.checkNotNullParameter(r10, "event");
            kf5.b r0 = r10.c;
            int r1 = 0;
            if (r0 == null) goto L5;
            this.a.getClass();
            String r2 = q.d(r0);
        L14:
            ze5.b r4 = this.a.b;
            ze5.b r5 = null;
            if (r4 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("draftStore");
            r4 = null;
        L17:
            DraftEntity r6 = r4.a(r2);
            int r7 = r10.a;
            if (r7 == 0) goto L26;
            if (r7 == 1) goto L21;
            tt5.a.k("Comment#DraftAddin", "unknown type: " + r10.a);
            return;
        L21:
            ze5.b r3 = this.a.b;
            if (r3 != null) goto L24;
            Intrinsics.throwUninitializedPropertyAccessException("draftStore");
        L25:
            r5.c(r2, r10.b);
            return;
        L24:
            r5 = r3;
            goto L25
        L26:
            if (r6 == null) goto L31;
            List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r8 = r6.getImgList();
            if (r8 == null) goto L31;
            r1 = r8.size();
        L31:
            if ((r1 + r10.b.size()) <= 9) goto L35;
            tt5.a.h("Comment#DraftAddin", "InputImageChangedEvent with imageList size > 9");
            ze5.c r11 = r10.e;
            if (r11 == null) goto L46;
            r11.b();
            return;
        L46:
            return;
        L35:
            ze5.b r12 = this.a.b;
            if (r12 != null) goto L38;
            Intrinsics.throwUninitializedPropertyAccessException("draftStore");
        L39:
            r5.b(r2, r10.b);
            ze5.c r13 = r10.e;
            if (r13 == null) goto L48;
            r13.a();
            return;
        L48:
            return;
        L38:
            r5 = r12;
            goto L39
        L5:
            CommentInputRequest r14 = r10.d;
            if (r14 == null) goto L42;
            this.a.getClass();
            int r15 = com.bytedance.ee.bear.middleground.comment.draft.c.a;
            String r16 = r14.comment_id;
            String r17 = r14.reply_id;
            if (r14.is_whole == true) goto L10;
        L12:
            boolean r18 = false;
        L13:
            r2 = com.bytedance.ee.bear.middleground.comment.draft.c.a(r16, r17, r18);
            goto L14
        L10:
            if (r14.isDrive == true) goto L12;
            r18 = true;
            goto L13
        L42:
            tt5.a.k("Comment#DraftAddin", "InputImageChangedEvent with empty inputComment and inputRequest");
        }
    }

    public final class h extends ff5.a<ef5.t> {
        public final /* synthetic */ q a;

        public h(q r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r2) {
            ef5.t r3 = (ef5.t) r2;
            Intrinsics.checkNotNullParameter(r3, "event");
            q.c(this.a, r3.a);
        }
    }

    public final class i extends ff5.a<ef5.u> {
        public final /* synthetic */ q a;

        public i(q r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r6) {
            ef5.u r7 = (ef5.u) r6;
            Intrinsics.checkNotNullParameter(r7, "event");
            if (r7.b.getRootView().isAttachedToWindow() == false) goto L19;
            q r0 = this.a;
            kf5.b r1 = r7.b;
            r0.getClass();
            String r2 = q.d(r1);
            ze5.b r3 = this.a.b;
            if (r3 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("draftStore");
            r3 = null;
        L7:
            r3.d(r2, r7.a);
            if (r7.a.length() != 0) goto L10;
            boolean r8 = true;
        L11:
            if (r8 == false) goto L20;
            tt5.a.h("Comment#DraftAddin", "draft has been cleared");
            ze5.b r9 = this.a.b;
            if (r9 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("draftStore");
            r9 = null;
        L15:
            DraftEntity r10 = r9.a(r2);
            if (r10 == null) goto L21;
            r10.setSmartReplyDataForInsert(null);
            return;
        L21:
            return;
        L20:
            return;
        L10:
            r8 = false;
            goto L11
        }
    }

    public final class j extends ff5.a<ef5.p> {
        public final /* synthetic */ q a;

        public j(q r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r2) {
            ef5.p r3 = (ef5.p) r2;
            Intrinsics.checkNotNullParameter(r3, "event");
            q.c(this.a, r3.a);
        }
    }

    public final class k extends ff5.a<ef5.v> {
        public final /* synthetic */ q a;

        public k(q r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r11) {
            ef5.v r12 = (ef5.v) r11;
            Intrinsics.checkNotNullParameter(r12, "event");
            if (r12.d.length() != 0) goto L5;
            boolean r0 = true;
        L7:
            if (r0 == false) goto L9;
            tt5.a.h("Comment#DraftAddin", "InsertContentToDraftEvent ignored: empty content");
            return;
        L9:
            int r1 = com.bytedance.ee.bear.middleground.comment.draft.c.a;
            String r2 = com.bytedance.ee.bear.middleground.comment.draft.c.a(r12.a, r12.b, r12.c);
            ze5.b r3 = this.a.b;
            ze5.b r5 = null;
            if (r3 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("draftStore");
            r3 = null;
        L12:
            DraftEntity r4 = r3.a(r2);
            if (r4 != null) goto L15;
            r4 = new DraftEntity(null, null, 3, null);
        L15:
            String r6 = r4.getContent();
            if (r6 != null) goto L19;
            r6 = "";
        L19:
            if (r12.f == false) goto L35;
            boolean r7 = StringsKt.startsWith$default(r6, r12.d, false, 2, null);
            boolean r8 = StringsKt.endsWith$default(r6, r12.d, false, 2, null);
            boolean r9 = r12.e;
            if (r9 == false) goto L23;
            if (r7 == false) goto L23;
        L26:
            if (r9 == false) goto L28;
            String r13 = "prefix";
        L29:
            tt5.a.h("Comment#DraftAddin", "InsertContentToDraftEvent skipped: duplicate by ".concat(r13));
            ze5.b r14 = this.a.b;
            if (r14 != null) goto L32;
            Intrinsics.throwUninitializedPropertyAccessException("draftStore");
        L33:
            r5.e(r2, r4);
            return;
        L32:
            r5 = r14;
            goto L33
        L28:
            r13 = "suffix";
        L23:
            if (r9 == true) goto L35;
            if (r8 == true) goto L26;
        L35:
            if (r12.e == false) goto L37;
            String r15 = r12.d + r6;
        L38:
            r4.setContent(r15);
            ze5.b r16 = this.a.b;
            if (r16 != null) goto L41;
            Intrinsics.throwUninitializedPropertyAccessException("draftStore");
        L42:
            r5.e(r2, r4);
            return;
        L41:
            r5 = r16;
            goto L42
        L37:
            r15 = r6 + r12.d;
            goto L38
        L5:
            r0 = false;
            goto L7
        }
    }

    public final class l extends ff5.a<ef5.w> {
        public final /* synthetic */ q a;

        public l(q r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r7) {
            ef5.w r8 = (ef5.w) r7;
            Intrinsics.checkNotNullParameter(r8, "event");
            int r0 = com.bytedance.ee.bear.middleground.comment.draft.c.a;
            ze5.b r3 = null;
            String r1 = com.bytedance.ee.bear.middleground.comment.draft.c.b(r8.a.getCommentId(), null, false, 6);
            ze5.b r2 = this.a.b;
            if (r2 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("draftStore");
            r2 = null;
        L5:
            DraftEntity r4 = r2.a(r1);
            if (r4 == null) goto L11;
            r4.setSmartReplyDataForInsert(r8.a);
            StringBuilder r5 = new StringBuilder();
            String r6 = r4.getContent();
            if (r6 != null) goto L10;
            r6 = "";
        L10:
            r5.append(r6);
            r5.append(r8.a.getText());
            r4.setContent(r5.toString());
        L12:
            ze5.b r9 = this.a.b;
            if (r9 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("draftStore");
        L16:
            r3.e(r1, r4);
            return;
        L15:
            r3 = r9;
            goto L16
        L11:
            r4 = new DraftEntity(r8.a.getText(), null, r8.a);
            goto L12
        }
    }

    public final class m extends ff5.a<ef5.g0> {
        public final /* synthetic */ q a;

        public m(q r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r6) {
            ef5.g0 r7 = (ef5.g0) r6;
            Intrinsics.checkNotNullParameter(r7, "event");
            ze5.b r0 = this.a.b;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("draftStore");
            r0 = null;
        L5:
            int r2 = com.bytedance.ee.bear.middleground.comment.draft.c.a;
            r0.d(com.bytedance.ee.bear.middleground.comment.draft.c.b(r7.b, null, false, 6), r7.a);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void onDestroy() {
        String r0 = getContext().getConfig().i;
        if (r0.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        DraftStoreManager.d.c(r0);
        return;
    L8:
        String r2 = this.c;
        if (r2 == null) goto L13;
        DraftStoreManager.d.c(r2);
        ((ze5.a) org.koin.java.a.c(ze5.a.class, null, null, 6)).b(CollectionsKt.listOf(r2));
        return;
    L13:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public q() {
    }

    public static String d(kf5.b r3) {
        int r0 = com.bytedance.ee.bear.middleground.comment.draft.c.a;
        String r1 = r3.i().comment_id;
        String r2 = r3.i().reply_id;
        if (r3.i().is_whole == true) goto L5;
    L7:
        boolean r4 = false;
    L9:
        return com.bytedance.ee.bear.middleground.comment.draft.c.a(r1, r2, r4);
    L5:
        if (r3.i().isDrive == true) goto L7;
        r4 = true;
        goto L9
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void a(cf5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r3, "host");
        this.a = r3;
        r3.b(ef5.q.class, new f(this));
        r3.b(ef5.t.class, new h(this));
        r3.b(ef5.p.class, new j(this));
        r3.b(ef5.u.class, new i(this));
        r3.b(ef5.s.class, new g(this));
        r3.b(ef5.j.class, new c(this));
        r3.b(ef5.h.class, new a(this));
        r3.b(ef5.m.class, new e(this));
        r3.b(ef5.g0.class, new m(this));
        r3.b(ef5.w.class, new l(this));
        r3.b(ef5.v.class, new k(this));
        r3.b(ef5.i.class, new b(this));
        String r4 = getContext().getConfig().i;
        if (r4.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        ze5.b r5 = DraftStoreManager.d.d(r4);
    L9:
        this.b = r5;
        return;
    L8:
        String r6 = "fake-" + com.larksuite.framework.utils.l0.a();
        this.c = r6;
        tt5.a.h("Comment#DraftAddin", "token is empty, so generate fake token: " + r6);
        r5 = DraftStoreManager.d.d(r6);
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    public static final void c(q r14, kf5.b r15) {
        com.bytedance.ee.bear.middleground.comment.uitls.p r0 = r14.getContext().getConfig();
        ze5.b r1 = r14.b;
        SmartReplyDataForInsert r3 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("draftStore");
        r1 = null;
    L5:
        DraftEntity r2 = r1.a(d(r15));
        com.bytedance.ee.bear.middleground.comment.uitls.h r4 = r0.d0;
        String r5 = r0.k.getType();
        String r6 = r0.i;
        String r7 = r15.i().comment_id;
        String r8 = r15.i().reply_id;
        boolean r9 = true;
        if (r2 != null) goto L8;
    L10:
        boolean r10 = false;
    L11:
        if (r2 == null) goto L15;
        String r11 = r2.getContent();
        if (r11 == null) goto L15;
        int r12 = r11.length();
    L16:
        if (r2 == null) goto L20;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r13 = r2.getImgList();
        if (r13 == null) goto L20;
        int r16 = r13.size();
    L21:
        r4.getClass();
        HashMap r17 = new HashMap();
        r17.put("file_type", r5);
        r17.put("file_id", du5.b.g(r6));
        if (r7 != null) goto L25;
        r7 = "";
    L25:
        r17.put("comment_id", r7);
        if (r8 != null) goto L29;
        r8 = "";
    L29:
        r17.put("reply_id", r8);
        r17.put("comment_style", r4.f);
        r17.put("has_draft", Boolean.toString(r10));
        r17.put("content_length", Integer.valueOf(r12));
        r17.put("image_count", Integer.valueOf(r16));
        tt5.a.b("Comment#CommentAnalytic", "reportDraftInputShow params = " + r17);
        r4.g.a("comment_draft_input_show_dev", r17);
        ze5.b r18 = r14.b;
        if (r18 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("draftStore");
        r18 = null;
    L32:
        DraftEntity r19 = r18.a(d(r15));
        if (r15.f().j() == false) goto L43;
        if (r19 != null) goto L43;
        String r20 = r15.f().e.content;
        CommentBean.CommentDetail.ExtraEntity r21 = r15.f().e.extra;
        if (r21 == null) goto L38;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r22 = r21.getImage_list();
    L39:
        r19 = new DraftEntity(r20, r22);
        ze5.b r23 = r14.b;
        if (r23 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("draftStore");
        r23 = null;
    L42:
        r23.e(d(r15), r19);
        goto L43
    L38:
        r22 = null;
    L43:
        if (r19 == null) goto L46;
        String r24 = r19.getContent();
        if (r24 == null) goto L46;
    L48:
        if (r15.f().j() == true) goto L77;
        String r25 = r15.f().e.directional_reply_id;
        if (r25 != null) goto L52;
    L55:
        boolean r26 = true;
    L56:
        if (r26 == true) goto L77;
        String r27 = r15.f().e.content;
        if (r27 != null) goto L60;
    L63:
        boolean r28 = true;
    L64:
        if (r28 == true) goto L77;
        if (StringsKt.startsWith$default(r24, r15.f().e.content, false, 2, null) == true) goto L77;
        if (StringsKt.endsWith$default(r15.f().e.content, r24, false, 2, null) == false) goto L70;
        r24 = r15.f().e.content;
        Intrinsics.checkNotNull(r24);
    L71:
        if (r19 != null) goto L73;
        r19 = new DraftEntity(null, null, 3, null);
    L73:
        r19.setContent(r24);
        ze5.b r29 = r14.b;
        if (r29 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("draftStore");
        r29 = null;
    L76:
        r29.e(d(r15), r19);
        goto L77
    L70:
        r24 = r15.f().e.content + r24;
        goto L71
    L60:
        if (r27.length() == 0) goto L63;
        r28 = false;
        goto L64
    L52:
        if (r25.length() == 0) goto L55;
        r26 = false;
    L77:
        b2 r30 = r15.f();
        if (r30 == null) goto L82;
        CommentInputRequest r31 = r30.e;
        if (r31 == null) goto L82;
        SmartReplyDataForInsert r32 = r31.smartReplyDataForInsert;
    L83:
        if (r32 == null) goto L102;
        b2 r33 = r15.f();
        if (r33 == null) goto L89;
        CommentInputRequest r34 = r33.e;
        if (r34 == null) goto L89;
        SmartReplyDataForInsert r35 = r34.smartReplyDataForInsert;
    L90:
        if (r19 == null) goto L92;
        SmartReplyDataForInsert r36 = r19.getSmartReplyDataForInsert();
    L94:
        if (Intrinsics.areEqual(r35, r36) == true) goto L102;
        r24 = r24 + r15.f().e.content;
        if (r19 != null) goto L98;
        r19 = new DraftEntity(null, null, 3, null);
    L98:
        r19.setContent(r24);
        r19.setSmartReplyDataForInsert(r15.f().e.smartReplyDataForInsert);
        ze5.b r110 = r14.b;
        if (r110 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("draftStore");
        r110 = null;
    L101:
        r110.e(d(r15), r19);
        goto L102
    L92:
        r36 = null;
    L89:
        r35 = null;
    L102:
        if (r19 == null) goto L104;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r111 = r19.getImgList();
    L106:
        if (r24.length() != 0) goto L108;
        boolean r37 = true;
    L109:
        if (r111 == null) goto L111;
        boolean r38 = r111.isEmpty();
    L112:
        boolean r39 = r15.f().c.F;
        if (r39 == true) goto L116;
        if (r37 == false) goto L116;
        boolean r40 = true;
    L117:
        if (r39 == false) goto L121;
        if (r37 == false) goto L121;
        if (r38 == false) goto L121;
    L122:
        if (r40 == true) goto L132;
        if (r9 == true) goto L132;
        r15.r(r24);
        if (r19 == null) goto L128;
        r3 = r19.getSmartReplyDataForInsert();
    L128:
        r15.n(r3);
        if (r39 == false) goto L131;
        r15.o(r111);
        return;
    L131:
        r15.s();
        return;
    L132:
        r15.e().setText("");
        r15.s();
        return;
    L121:
        r9 = false;
    L116:
        r40 = false;
        goto L117
    L111:
        r38 = true;
        goto L112
    L108:
        r37 = false;
        goto L109
    L104:
        r111 = null;
    L82:
        r32 = null;
    L46:
        r24 = "";
    L20:
        r16 = 0;
    L15:
        r12 = 0;
        goto L16
    L8:
        if (r2.isDraftEmpty() == true) goto L10;
        r10 = true;
        goto L11
    }
}
