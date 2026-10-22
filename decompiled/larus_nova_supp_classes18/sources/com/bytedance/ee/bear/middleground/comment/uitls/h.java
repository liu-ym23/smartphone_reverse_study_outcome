package com.bytedance.ee.bear.middleground.comment.uitls;

import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.comment.export.bean.RevisionExtra;
import com.bytedance.ee.bear.middleground.comment.export.v;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher;
import io.reactivex.Flowable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h {
    public final String a;
    public final String b;
    public boolean c;
    public final v d;
    public final boolean e;
    public final String f;
    public final com.bytedance.ee.bear.middleground.comment.o g;

    public final Flowable<Map<String, String>> a() {
        HashMap r0 = new HashMap();
        if (this.c == false) goto L5;
        String r1 = "full_comment";
    L6:
        r0.put("comment_type", r1);
        r0.put("file_type", this.b + "");
        r0.put("file_id", du5.b.g(this.a));
        r0.put("module", this.b + "");
        r0.put("comment_style", this.f);
        v r2 = this.d;
        if (r2 == null) goto L9;
        r0.put("is_owner", String.valueOf(r2.isOwner()));
    L9:
        r0.put("is_audiocomnent", "false");
        return Flowable.just(r0);
    L5:
        r1 = "part_comment";
        goto L6
    }

    public final Map<String, Object> b() {
        HashMap r0 = new HashMap();
        r0.putAll(((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).m("bizCommonParams"));
        HashMap r1 = ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).m("docCommonParams");
        if (r1.isEmpty() == true) goto L5;
        r0.putAll(r1);
    L6:
        r0.put("target", "none");
        r0.put("comment_style", this.f);
        return r0;
    L5:
        r0.putAll(((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).m("driveCommonParams"));
        goto L6
    }

    public final void i(String r5) {
        Map<String, Object> r0 = b();
        if (TextUtils.isEmpty(r5) == true) goto L5;
        ((HashMap) r0).put("comment_id", r5);
    L6:
        tt5.a.b("Comment#CommentAnalytic", "reportCommentImageView params = " + r0);
        this.g.a("ccm_comment_image_view", r0);
        return;
    L5:
        tt5.a.h("Comment#CommentAnalytic", "reportCommentImageView replyId is empty");
        goto L6
    }

    public final void j(String r5) {
        Map<String, Object> r0 = b();
        if (this.c == false) goto L5;
        String r1 = "full_comment";
    L6:
        HashMap r2 = (HashMap) r0;
        r2.put("sub_view", r1);
        r2.put(ResourceData.KEY_TYPE, r5);
        tt5.a.b("Comment#CommentAnalytic", "reportCommentView params = " + r0);
        this.g.a("ccm_comment_view", r0);
        return;
    L5:
        r1 = "part_comment";
        goto L6
    }

    public final void k(String r6) {
        Map<String, Object> r1 = b();
        HashMap r3 = (HashMap) r1;
        r3.put("file_type", this.b);
        r3.put("file_id", du5.b.g(this.a));
        r3.put("click", "change_to_voice_input");
        r3.put("location", r6);
        int r7 = AudioAsrLanguageSwitcher.i;     // Catch: Exception -> L5
        String r8 = AudioAsrLanguageSwitcher.a.a();     // Catch: Exception -> L5
    L7:
        r3.put("user_lng", r8);
        tt5.a.b("Comment#CommentAnalytic", "reportCommentVoiceInputClick params = " + r1);
        this.g.a("ccm_comment_voice_input_click", r1);
        return;
    L5:
        e = move-exception;
        tt5.a.d("Comment#CommentAnalytic", "getLastVoiceInputLanguage error: " + e);
        r8 = "un_auto";
        goto L7
    }

    public final void l(String r3) {
        HashMap r0 = new HashMap();
        r0.put("forbidden_location", r3);
        r0.put("is_history", "false");
        r0.put("comment_style", this.f);
        tt5.a.h("Comment#CommentAnalytic", "permission_copy_forbidden_toast, params = " + r0);
        this.g.a("ccm_permission_copy_forbidden_toast_view", r0);
    }

    public final void m(final String r3) {
        a().subscribeOn(fo5.d.a()).map(new a(this, r3)).subscribe(new b(), new c());
    }

    public final void n(boolean r7) {
        HashMap r2 = new HashMap();
        r2.put("is_audiocomnent", "true");
        if (r7 == false) goto L5;
        String r8 = "press";
    L6:
        r2.put("mode", r8);
        d("create_audiocomment", r2, "", "", false);
        return;
    L5:
        r8 = "click";
        goto L6
    }

    public final void q(String r7) {
        d("show_reaction_page", null, null, r7, true);
    }

    public final void e(String r4, String r5) {
        Map<String, Object> r0 = b();
        HashMap r1 = (HashMap) r0;
        r1.put("card_id", r4);
        r1.put("comment_visible_range", r5);
        tt5.a.b("Comment#CommentAnalytic", "reportCommentCardView params = " + r0);
        this.g.a("ccm_comment_card_view", r0);
    }

    public final void h(String r4, String r5) {
        Map<String, Object> r0 = b();
        HashMap r1 = (HashMap) r0;
        r1.put("click", r4);
        if (TextUtils.isEmpty(r5) == true) goto L5;
        r1.put("comment_id", r5);
    L6:
        tt5.a.b("Comment#CommentAnalytic", "reportCommentImageClick params = " + r0);
        this.g.a("ccm_comment_image_click", r0);
        return;
    L5:
        tt5.a.h("Comment#CommentAnalytic", "reportCommentImageClick replyId is empty");
        goto L6
    }

    public final void o(String r4, String r5, Map<String, String> r6) {
        Map<String, Object> r0 = b();
        HashMap r1 = (HashMap) r0;
        r1.put("click", r4);
        if (r5 == null) goto L6;
        r1.put("reaction_card_id", r5);
    L6:
        if (r4.equals("user_name") == false) goto L8;
        r1.put("target", "ccm_reaction_detail_page_view");
    L9:
        if (r6 != null) goto L11;
    L13:
        tt5.a.b("Comment#CommentAnalytic", "reportReactionClick params = " + r0);
        this.g.a("ccm_reaction_click", r0);
        return;
    L11:
        if (((HashMap) r6).isEmpty() == true) goto L13;
        r1.putAll(r6);
        goto L13
    L8:
        r1.put("target", "none");
        goto L9
    }

    public final void p(String r4, String r5, Map<String, String> r6) {
        Map<String, Object> r0 = b();
        HashMap r1 = (HashMap) r0;
        r1.put("click", r4);
        if (r5 == null) goto L5;
        r1.put("reaction_card_id", r5);
    L5:
        r1.put("target", "none");
        if (r6 != null) goto L8;
    L10:
        tt5.a.b("Comment#CommentAnalytic", "reportReactionDetailClick params = " + r0);
        this.g.a("ccm_reaction_detail_page_click", r0);
        return;
    L8:
        if (((HashMap) r6).isEmpty() == true) goto L10;
        r1.putAll(r6);
        goto L10
    }

    public final void g(String r4, String r5, String r6, Map<String, String> r7) {
        Map<String, Object> r0 = b();
        HashMap r1 = (HashMap) r0;
        r1.put("click", r4);
        if (r5 == null) goto L5;
        r1.put("comment_card_id", r5);
    L5:
        if (r6 == null) goto L8;
        r1.put("comment_id", r6);
    L8:
        if ("cancel_click".equals(r4) == true) goto L10;
        r1.put("is_full_comment_flag", String.valueOf(this.c));
    L10:
        if (r7 != null) goto L12;
    L14:
        tt5.a.b("Comment#CommentAnalytic", "reportCommentClick params = " + r0);
        this.g.a("ccm_comment_click", r0);
        return;
    L12:
        if (r7.isEmpty() == true) goto L14;
        r1.putAll(r7);
        goto L14
    }

    public final void c(String r4, String r5, String r6, String r7, String r8) {
        Map<String, Object> r0 = b();
        HashMap r1 = (HashMap) r0;
        r1.put("click", r4);
        r1.put("ai_comment_id", r5);
        r1.put("comment_card_id", r6);
        r1.put("reply_id", r7);
        r1.put("ai_reply_user_type", r8);
        tt5.a.b("Comment#CommentAnalytic", "reportAIReplyClick params = " + r0);
        this.g.a("ccm_comment_box_ai_reply_click", r0);
    }

    public final void d(final String r9, final Map<String, String> r10, final String r11, final String r12, final boolean r13) {
        a().subscribeOn(fo5.d.a()).map(new d(r9, r10, r11, r12, r13)).map(new e(this)).subscribe(new f(), new g());
    }

    public final void f(String r4, String r5, boolean r6, boolean r7, String r8) {
        Map<String, Object> r0 = b();
        ((HashMap) r0).put("card_id", r4);
        ((HashMap) r0).put("comment_id", r5);
        HashMap r9 = (HashMap) r0;
        r9.put("is_presenter", String.valueOf(r6));
        r9.put("is_magic_share", String.valueOf(r7));
        r9.put("comment_visible_range", r8);
        tt5.a.b("Comment#CommentAnalytic", "reportCommentCheckboxView params = " + r0);
        this.g.a("ccm_comment_check_box_view", r0);
    }

    public final void r(String r4, String r5, String r6, RevisionExtra.RevisionTypes r7, Map<String, String> r8) {
        Map<String, Object> r0 = b();
        HashMap r1 = (HashMap) r0;
        r1.put("click", r4);
        if (r5 == null) goto L5;
        r1.put("suggestion_card_id", r5);
    L5:
        if (r6 == null) goto L7;
        r1.put("suggestion_id", r6);
    L7:
        if (r7 == null) goto L9;
        r1.put("suggestion_card_type", r7);
    L9:
        r1.put("target", "none");
        if (r8 != null) goto L12;
    L14:
        tt5.a.b("Comment#CommentAnalytic", "reportSuggestionClick params = " + r0);
        this.g.a("ccm_doc_suggestion_card_click", r0);
        return;
    L12:
        if (r8.isEmpty() == true) goto L14;
        r1.putAll(r8);
        goto L14
    }

    public h(com.bytedance.ee.bear.middleground.comment.p r1, String r2, String r3, boolean r4, String r5, v r6, boolean r7) {
        this.a = r2;
        this.b = r3;
        if (sbb.e.l.getType().equals(r3) == true) goto L7;
        if (r4 == true) goto L7;
        boolean r8 = false;
    L8:
        this.c = r8;
        this.f = r5;
        this.d = r6;
        this.e = r7;
        this.g = new com.bytedance.ee.bear.middleground.comment.o(r1);
        return;
    L7:
        r8 = true;
        goto L8
    }
}
