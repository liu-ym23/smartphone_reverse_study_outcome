package com.bytedance.awemeopen.apps.photo.view;

import android.app.Activity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.awemeopen.apps.framework.comment.CommentListView;
import com.bytedance.awemeopen.apps.framework.comment.api.statistics.CommentMobParameters;
import com.bytedance.awemeopen.apps.framework.comment.write.viewmodel.CommentCommonDataViewModel;
import com.bytedance.awemeopen.apps.framework.comment.write.viewmodel.CommentInputContentViewModel;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.utils.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WriteCommentEntranceViewForPicture extends com.bytedance.awemeopen.apps.framework.comment.write.b {
    public final ViewGroup e;
    public final com.bytedance.awemeopen.apps.framework.comment.write.e f;
    public TextView g;
    public com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.b h;

    public static final class a extends o {
        public final /* synthetic */ WriteCommentEntranceViewForPicture d;

        @Override // com.bytedance.awemeopen.apps.framework.utils.o
        public final void a() {
            if (this.d.a() == true) goto L5;
            return;
        L5:
            Activity r0 = this.d.b;
            Intrinsics.checkNotNull(r0);
            int r1 = com.bytedance.awemeopen.bizmodels.user.a.a;
            final WriteCommentEntranceViewForPicture r2 = this.d;
            com.bytedance.awemeopen.apps.framework.comment.util.e.a(r0, "comment", new WriteCommentEntranceViewForPicture$init$1$doClick$1(r2), "doNeedLogin");
        }

        public a(WriteCommentEntranceViewForPicture r1) {
            this.d = r1;
        }
    }

    public static final class b extends hy3.c {
        public final r14.c a;
        public final /* synthetic */ WriteCommentEntranceViewForPicture b;

        @Override // hy3.c
        public final Integer b() {
            return 1;
        }

        @Override // hy3.c
        public final r14.c a() {
            this.a.d0(String.valueOf(this.b.a));
            return this.a;
        }

        public b(WriteCommentEntranceViewForPicture r1) {
            this.b = r1;
            this.a = new r14.c();
        }

        @Override // hy3.c
        public final void c(CommentMobParameters r11, o14.b r12) {
            Intrinsics.checkNotNullParameter(r12, "result");
            this.b.f.c(r12);
            WriteCommentEntranceViewForPicture r0 = this.b;
            CommentInputContentViewModel r1 = r0.c;
            if (r1 == null) goto L5;
            r1.removeRecord(r0.a, true);
        L5:
            LinkedHashMap r5 = new LinkedHashMap();
            String r2 = r11.getEnterFrom();
            String r3 = "";
            if (r2 != null) goto L8;
            r2 = "";
        L8:
            r5.put("enter_from", r2);
            String r4 = r11.getAuthorOpenId();
            if (r4 != null) goto L11;
            r4 = "";
        L11:
            r5.put("author_openid", r4);
            String r6 = r11.getGroupId();
            if (r6 != null) goto L14;
            r6 = "";
        L14:
            r5.put("group_id", r6);
            String r7 = r11.getClickType();
            if (r7 != null) goto L17;
            r7 = "";
        L17:
            r5.put("enter_method", r7);
            String r8 = r11.getImprId();
            if (r8 != null) goto L20;
            r8 = "";
        L20:
            r5.put("impr_id", r8);
            r5.put("emoji_times", Integer.valueOf(r11.getEmojiTimes()));
            String r9 = r11.getPreviousPage();
            if (r9 != null) goto L23;
            r9 = "";
        L23:
            r5.put(BaseFollowStoreViewModel.KEY_PREVIOUS_PAGE, r9);
            o14.c r13 = r12.e();
            if (r13 == null) goto L26;
            o14.a r14 = r13.a();
        L27:
            if (r14 == null) goto L30;
            r5.put("comment_id", r14.cid);
            r5.put("content", r14.l());
            r5.put("to_reply_comment_id", r14.i());
            int r10 = o14.a.c;
            r5.put("comment_category", o14.a.a.a(r14));
        L30:
            if (TextUtils.isEmpty(r11.getReplyToOpenId()) == true) goto L36;
            String r15 = r11.getReplyToOpenId();
            if (r15 == null) goto L35;
            r3 = r15;
        L35:
            r5.put("comment_user_id", r3);
        L36:
            Map<String, Object> r16 = r11.getExtraParams();
            if (r16 == null) goto L42;
            Iterator<Map.Entry<String, Object>> r17 = r16.entrySet().iterator();
        L40:
            if (r17.hasNext() == false) goto L42;
            Map.Entry<String, Object> r18 = r17.next();
            r5.put(r18.getKey(), r18.getValue());
        L42:
            AosEventReporter.s(AosEventReporter.a, "post_comment", r5, null, r11.getHostExtraParams(), null, 20);
            return;
        L26:
            r14 = null;
            goto L27
        }
    }

    public static final class c extends jy3.d {
        public final /* synthetic */ WriteCommentEntranceViewForPicture a;

        public c(WriteCommentEntranceViewForPicture r1) {
            this.a = r1;
        }

        @Override // jy3.d
        public final void c(CommentMobParameters r9) {
            String r0 = null;
            if (r9 == null) goto L5;
            String r1 = r9.getCloseMethod();
        L7:
            if (Intrinsics.areEqual(r1, "click_space") == true) goto L12;
            if (r9 == null) goto L11;
            r0 = r9.getCloseMethod();
        L11:
            if (Intrinsics.areEqual(r0, "post_comment") == true) goto L12;
            return;
        L12:
            LinkedHashMap r3 = new LinkedHashMap();
            String r2 = r9.getEnterFrom();
            String r4 = "";
            if (r2 != null) goto L15;
            r2 = "";
        L15:
            r3.put("enter_from", r2);
            String r5 = r9.getAuthorOpenId();
            if (r5 != null) goto L18;
            r5 = "";
        L18:
            r3.put("author_openid", r5);
            String r6 = r9.getGroupId();
            if (r6 != null) goto L21;
            r6 = "";
        L21:
            r3.put("group_id", r6);
            String r7 = r9.getEmojiToKeyboardMethod();
            if (r7 != null) goto L24;
        L27:
            boolean r8 = true;
        L28:
            if (r8 == true) goto L30;
            String r10 = r9.getEmojiToKeyboardMethod();
            Intrinsics.checkNotNull(r10);
        L31:
            r3.put("enter_method", r10);
            String r11 = r9.getCloseMethod();
            if (r11 != null) goto L34;
            r11 = "";
        L34:
            r3.put("close_method", r11);
            String r12 = r9.getImprId();
            if (r12 != null) goto L37;
            r12 = "";
        L37:
            r3.put("impr_id", r12);
            String r13 = r9.getCommentCategory();
            if (r13 != null) goto L40;
            r13 = "original";
        L40:
            r3.put("comment_category", r13);
            String r14 = r9.getPreviousPage();
            if (r14 == null) goto L44;
            r4 = r14;
        L44:
            r3.put(BaseFollowStoreViewModel.KEY_PREVIOUS_PAGE, r4);
            AosEventReporter.s(AosEventReporter.a, "close_text", r3, null, null, null, 28);
            return;
        L30:
            r10 = r9.getClickType();
            goto L31
        L24:
            if (r7.length() == 0) goto L27;
            r8 = false;
            goto L28
        L5:
            r1 = null;
            goto L7
        }

        @Override // jy3.d
        public final void d(CommentMobParameters r15) {
            String r0 = null;
            if (r15 == null) goto L5;
            String r1 = r15.getClickType();
        L6:
            String r2 = "original";
            String r6 = "";
            if (Intrinsics.areEqual(r1, "click_text_bar") == false) goto L29;
            LinkedHashMap r9 = new LinkedHashMap();
            String r3 = r15.getEnterFrom();
            if (r3 != null) goto L11;
            r3 = "";
        L11:
            r9.put("enter_from", r3);
            String r4 = r15.getAuthorOpenId();
            if (r4 != null) goto L14;
            r4 = "";
        L14:
            r9.put("author_openid", r4);
            String r5 = r15.getGroupId();
            if (r5 != null) goto L17;
            r5 = "";
        L17:
            r9.put("group_id", r5);
            r9.put("enter_method", r15.getClickType());
            String r7 = r15.getImprId();
            if (r7 != null) goto L20;
            r7 = "";
        L20:
            r9.put("impr_id", r7);
            String r8 = r15.getCommentCategory();
            if (r8 == null) goto L24;
            r2 = r8;
        L24:
            r9.put("comment_category", r2);
            String r10 = r15.getPreviousPage();
            if (r10 == null) goto L28;
            r6 = r10;
        L28:
            r9.put(BaseFollowStoreViewModel.KEY_PREVIOUS_PAGE, r6);
            AosEventReporter.s(AosEventReporter.a, "enter_text", r9, null, r15.getHostExtraParams(), null, 20);
            return;
        L29:
            if (r15 == null) goto L32;
            r0 = r15.getClickType();
        L32:
            if (Intrinsics.areEqual(r0, "click_outer_comment") == false) goto L53;
            LinkedHashMap r11 = new LinkedHashMap();
            r11.put("current_action", "input_keyboard_show");
            String r12 = r15.getCommentId();
            if (r12 != null) goto L36;
            r12 = "";
        L36:
            r11.put("comment_id", r12);
            String r13 = r15.getAuthorOpenId();
            if (r13 != null) goto L39;
            r13 = "";
        L39:
            r11.put("author_openid", r13);
            String r14 = r15.getGroupId();
            if (r14 != null) goto L42;
            r14 = "";
        L42:
            r11.put("group_id", r14);
            String r16 = r15.getEnterFrom();
            if (r16 == null) goto L46;
            r6 = r16;
        L46:
            r11.put("enter_from_cmt", r6);
            String r17 = r15.getCommentCategory();
            if (r17 == null) goto L50;
            r2 = r17;
        L50:
            r11.put("comment_category", r2);
            AosEventReporter.s(AosEventReporter.a, "comment_action", r11, null, r15.getHostExtraParams(), null, 20);
            return;
        L53:
            return;
        L5:
            r1 = null;
            goto L6
        }

        @Override // jy3.d
        public final void e(CommentMobParameters r8) {
            LinkedHashMap r2 = new LinkedHashMap();
            String r0 = r8.getEnterFrom();
            String r1 = "";
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            r2.put("enter_from", r0);
            String r3 = r8.getAuthorOpenId();
            if (r3 != null) goto L8;
            r3 = "";
        L8:
            r2.put("author_openid", r3);
            String r4 = r8.getGroupId();
            if (r4 != null) goto L11;
            r4 = "";
        L11:
            r2.put("group_id", r4);
            String r5 = r8.getEmojiToKeyboardMethod();
            if (r5 != null) goto L14;
            r5 = "";
        L14:
            r2.put("enter_method", r5);
            String r6 = r8.getImprId();
            if (r6 != null) goto L17;
            r6 = "";
        L17:
            r2.put("impr_id", r6);
            String r7 = r8.getCommentCategory();
            if (r7 != null) goto L20;
            r7 = "original";
        L20:
            r2.put("comment_category", r7);
            String r9 = r8.getPreviousPage();
            if (r9 == null) goto L24;
            r1 = r9;
        L24:
            r2.put(BaseFollowStoreViewModel.KEY_PREVIOUS_PAGE, r1);
            AosEventReporter.s(AosEventReporter.a, "show_emoji_board", r2, null, null, null, 28);
        }

        @Override // jy3.d
        public final void b(CommentMobParameters r24, String r25) {
            LinkedHashMap r7 = new LinkedHashMap();
            if (r24 == null) goto L6;
            String r0 = r24.getEnterFrom();
            if (r0 == null) goto L6;
        L7:
            r7.put("enter_from", r0);
            if (r24 == null) goto L11;
            String r1 = r24.getAuthorOpenId();
            if (r1 == null) goto L11;
        L12:
            r7.put("author_openid", r1);
            if (r24 == null) goto L16;
            String r2 = r24.getGroupId();
            if (r2 == null) goto L16;
        L17:
            r7.put("group_id", r2);
            if (r24 == null) goto L21;
            String r3 = r24.getEmojiToKeyboardMethod();
            if (r3 == null) goto L21;
        L22:
            r7.put("enter_method", r3);
            if (r24 == null) goto L26;
            String r4 = r24.getImprId();
            if (r4 == null) goto L26;
        L27:
            r7.put("impr_id", r4);
            String r14 = "original";
            if (r24 == null) goto L31;
            String r5 = r24.getCommentCategory();
            if (r5 == null) goto L31;
        L32:
            r7.put("comment_category", r5);
            if (r24 == null) goto L36;
            String r6 = r24.getPreviousPage();
            if (r6 == null) goto L36;
        L37:
            r7.put(BaseFollowStoreViewModel.KEY_PREVIOUS_PAGE, r6);
            AosEventReporter r16 = AosEventReporter.a;
            AosEventReporter.s(r16, "enter_text", r7, null, null, null, 28);
            LinkedHashMap r8 = new LinkedHashMap();
            CommentCommonDataViewModel r9 = this.a.d;
            if (r9 == null) goto L41;
            String r10 = r9.getSceneId();
            if (r10 == null) goto L41;
        L42:
            r8.put("enter_from", r10);
            if (r24 == null) goto L46;
            String r11 = r24.getAuthorOpenId();
            if (r11 == null) goto L46;
        L47:
            r8.put("author_openid", r11);
            if (r24 == null) goto L51;
            String r12 = r24.getGroupId();
            if (r12 == null) goto L51;
        L52:
            r8.put("group_id", r12);
            if (r24 == null) goto L56;
            String r13 = r24.getEmojiToKeyboardMethod();
            if (r13 == null) goto L56;
        L57:
            r8.put("enter_method", r13);
            if (r24 == null) goto L61;
            String r15 = r24.getImprId();
            if (r15 == null) goto L61;
        L62:
            r8.put("impr_id", r15);
            if (r24 == null) goto L68;
            String r17 = r24.getCommentCategory();
            if (r17 == null) goto L68;
            r14 = r17;
        L68:
            r7.put("comment_category", r14);
            r8.put("return_method", r25);
            if (r24 == null) goto L72;
            String r18 = r24.getPreviousPage();
            if (r18 == null) goto L72;
        L73:
            r8.put(BaseFollowStoreViewModel.KEY_PREVIOUS_PAGE, r18);
            AosEventReporter.s(r16, "emoji_to_keyboard", r8, null, null, null, 28);
            return;
        L72:
            r18 = "";
        L61:
            r15 = "";
        L56:
            r13 = "";
        L51:
            r12 = "";
        L46:
            r11 = "";
        L41:
            r10 = "";
        L36:
            r6 = "";
        L31:
            r5 = "original";
        L26:
            r4 = "";
        L21:
            r3 = "";
        L16:
            r2 = "";
        L11:
            r1 = "";
        L6:
            r0 = "";
            goto L7
        }
    }

    public static final class d extends jy3.c {
        public d() {
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.b
    public final void d() {
        TextView r0 = (TextView) this.e.findViewById(2131371800);
        this.g = r0;
        if (r0 == null) goto L6;
        r0.setOnClickListener(new a(this));
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.b
    public final void e() {
        CommentInputContentViewModel r0 = this.c;
        r14.c r1 = null;
        if (r0 == null) goto L11;
        CommentCommonDataViewModel r2 = this.d;
        if (r2 == null) goto L9;
        r14.c r3 = r2.getCurrentAweme();
        if (r3 == null) goto L9;
        String r4 = r3.c();
    L10:
        Editable r5 = r0.getContent(r4);
    L12:
        g(r5);
        CommentCommonDataViewModel r6 = this.d;
        boolean r7 = false;
        if (r6 == null) goto L19;
        r14.c r8 = r6.getCurrentAweme();
        if (r8 == null) goto L19;
        if (r8.a() == true) goto L19;
        boolean r9 = true;
    L20:
        if (r9 == false) goto L24;
        TextView r10 = this.g;
        if (r10 == null) goto L71;
        r10.setText(2131894302);
        return;
    L71:
        return;
    L24:
        CommentCommonDataViewModel r11 = this.d;
        if (r11 == null) goto L33;
        r14.c r12 = r11.getCurrentAweme();
        if (r12 == null) goto L33;
        r14.e r13 = r12.m();
        if (r13 == null) goto L33;
        if (r13.a() != 1) goto L33;
        boolean r14 = true;
    L34:
        if (r14 == false) goto L45;
        y24.d r15 = com.bytedance.awemeopen.apps.framework.comment.write.b.c();
        CommentCommonDataViewModel r16 = this.d;
        if (r16 == null) goto L38;
        r14.c r17 = r16.getCurrentAweme();
    L39:
        Intrinsics.checkNotNull(r17);
        if (r15.E1(r17) == true) goto L45;
        TextView r18 = this.g;
        if (r18 == null) goto L69;
        r18.setText(2131894301);
        return;
    L69:
        return;
    L38:
        r17 = null;
    L45:
        CommentCommonDataViewModel r19 = this.d;
        if (r19 == null) goto L54;
        r14.c r20 = r19.getCurrentAweme();
        if (r20 == null) goto L54;
        r14.e r21 = r20.m();
        if (r21 == null) goto L54;
        if (r21.a() != 2) goto L54;
        r7 = true;
    L54:
        if (r7 == false) goto L64;
        y24.d r22 = com.bytedance.awemeopen.apps.framework.comment.write.b.c();
        CommentCommonDataViewModel r23 = this.d;
        if (r23 == null) goto L58;
        r1 = r23.getCurrentAweme();
    L58:
        Intrinsics.checkNotNull(r1);
        if (r22.M(r1) == true) goto L64;
        TextView r24 = this.g;
        if (r24 == null) goto L70;
        r24.setText(2131894303);
        return;
    L70:
        return;
    L64:
        TextView r25 = this.g;
        if (r25 == null) goto L73;
        r25.setText(this.e.getContext().getResources().getString(2131914109));
        return;
    L73:
        return;
    L33:
        r14 = false;
    L19:
        r9 = false;
    L9:
        r4 = null;
        goto L10
    L11:
        r5 = null;
        goto L12
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.b
    public final com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.b b() {
        return this.h;
    }

    public final void g(Editable r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L14;
        TextView r1 = this.g;
        if (r1 == null) goto L13;
        r1.setText(r3.toString());
    L13:
        v04.b.a(this.g);
        return;
    L14:
        TextView r4 = this.g;
        if (r4 == null) goto L20;
        r4.setText(this.e.getContext().getResources().getString(2131914109));
        return;
    L20:
        return;
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public WriteCommentEntranceViewForPicture(ViewGroup r2, CommentListView.d r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r3, "commentInterface");
        this.e = r2;
        this.f = r3;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.b
    public final void f(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "pageOwner");
        super.f(r3, false);
        int r5 = bz3.a.a;
        com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.b r6 = bz3.a.a(r3, new b(this));
        this.h = r6;
        r6.i(new c(this));
        com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.b r7 = this.h;
        if (r7 == null) goto L5;
        r7.i(new d());
    L5:
        CommentInputContentViewModel r8 = this.c;
        if (r8 == null) goto L11;
        MutableLiveData<Editable> r9 = r8.getContentLiveData();
        if (r9 == null) goto L12;
        LifecycleOwner r10 = r3.d;
        final Function1<Editable, Unit> r0 = new WriteCommentEntranceViewForPicture$setPageOwner$4(this);
        r9.observe(r10, new e(r0));
        return;
    L12:
        return;
    }
}
