package com.bytedance.ee.bear.middleground.comment.uitls;

import android.text.TextUtils;
import com.bytedance.ee.bear.at.AtConstant$Zone;
import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.bytedance.ee.bear.document.analytic.AnalyticPlugin;
import com.bytedance.ee.bear.middleground.comment.export.bean.RevisionExtra;
import com.bytedance.ee.bear.middleground.comment.export.v;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import io.reactivex.Flowable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f232203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f232204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f232205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v f232206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f232207e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f232208f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.ee.bear.middleground.comment.o f232209g;

    public final Flowable<Map<String, String>> a() {
        HashMap r100 = new HashMap();
        if (this.f232205c == false) goto L5;
        String r101 = AtConstant$Zone.FULL_COMMENT;
    L6:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_COMMENT_TYPE, r101);
        r100.put("file_type", this.f232204b + "");
        r100.put("file_id", du5.b.g(this.f232203a));
        r100.put(EventConstant.Key.MODULE, this.f232204b + "");
        r100.put("comment_style", this.f232208f);
        v r102 = this.f232206d;
        if (r102 == null) goto L9;
        r100.put("is_owner", String.valueOf(r102.isOwner()));
    L9:
        r100.put("is_audiocomnent", "false");
        return Flowable.just(r100);
    L5:
        r101 = AtConstant$Zone.PART_COMMENT;
        goto L6
    }

    public final Map<String, Object> b() {
        HashMap r100 = new HashMap();
        r100.putAll(((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).m(AnalyticPlugin.BIZ_COMMON_PARAMS));
        HashMap<String, Object> r101 = ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).m("docCommonParams");
        if (r101.isEmpty() == true) goto L5;
        r100.putAll(r101);
    L6:
        r100.put(PickerReporterConstants.KEY.TARGET, "none");
        r100.put("comment_style", this.f232208f);
        return r100;
    L5:
        r100.putAll(((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).m("driveCommonParams"));
        goto L6
    }

    public final void i(String r100) {
        Map<String, Object> r101 = b();
        if (TextUtils.isEmpty(r100) == true) goto L5;
        ((HashMap) r101).put("comment_id", r100);
    L6:
        tt5.a.b("Comment#CommentAnalytic", "reportCommentImageView params = " + r101);
        this.f232209g.a("ccm_comment_image_view", r101);
        return;
    L5:
        tt5.a.h("Comment#CommentAnalytic", "reportCommentImageView replyId is empty");
        goto L6
    }

    public final void j(String r100) {
        Map<String, Object> r101 = b();
        if (this.f232205c == false) goto L5;
        String r102 = AtConstant$Zone.FULL_COMMENT;
    L6:
        HashMap r103 = (HashMap) r101;
        r103.put("sub_view", r102);
        r103.put("type", r100);
        tt5.a.b("Comment#CommentAnalytic", "reportCommentView params = " + r101);
        this.f232209g.a("ccm_comment_view", r101);
        return;
    L5:
        r102 = AtConstant$Zone.PART_COMMENT;
        goto L6
    }

    public final void k(String r100) {
        Map<String, Object> r101 = b();
        HashMap r102 = (HashMap) r101;
        r102.put("file_type", this.f232204b);
        r102.put("file_id", du5.b.g(this.f232203a));
        r102.put("click", "change_to_voice_input");
        r102.put("location", r100);
        int r103 = AudioAsrLanguageSwitcher.f429841i;     // Catch: Exception -> L5
        String r104 = AudioAsrLanguageSwitcher.a.a();     // Catch: Exception -> L5
    L7:
        r102.put("user_lng", r104);
        tt5.a.b("Comment#CommentAnalytic", "reportCommentVoiceInputClick params = " + r101);
        this.f232209g.a("ccm_comment_voice_input_click", r101);
        return;
    L5:
        e = move-exception;
        tt5.a.d("Comment#CommentAnalytic", "getLastVoiceInputLanguage error: " + e);
        r104 = "un_auto";
        goto L7
    }

    public final void l(String r100) {
        HashMap r101 = new HashMap();
        r101.put("forbidden_location", r100);
        r101.put("is_history", "false");
        r101.put("comment_style", this.f232208f);
        tt5.a.h("Comment#CommentAnalytic", "permission_copy_forbidden_toast, params = " + r101);
        this.f232209g.a("ccm_permission_copy_forbidden_toast_view", r101);
    }

    public final void m(final String r100) {
        a().subscribeOn(fo5.d.a()).map(new a(this, r100)).subscribe(new b(), new c());
    }

    public final void n(boolean r100) {
        HashMap r101 = new HashMap();
        r101.put("is_audiocomnent", "true");
        if (r100 == false) goto L5;
        String r102 = "press";
    L6:
        r101.put("mode", r102);
        d("create_audiocomment", r101, "", "", false);
        return;
    L5:
        r102 = "click";
        goto L6
    }

    public final void q(String r100) {
        d("show_reaction_page", null, null, r100, true);
    }

    public final void e(String r100, String r101) {
        Map<String, Object> r102 = b();
        HashMap r103 = (HashMap) r102;
        r103.put("card_id", r100);
        r103.put("comment_visible_range", r101);
        tt5.a.b("Comment#CommentAnalytic", "reportCommentCardView params = " + r102);
        this.f232209g.a("ccm_comment_card_view", r102);
    }

    public final void h(String r100, String r101) {
        Map<String, Object> r102 = b();
        HashMap r103 = (HashMap) r102;
        r103.put("click", r100);
        if (TextUtils.isEmpty(r101) == true) goto L5;
        r103.put("comment_id", r101);
    L6:
        tt5.a.b("Comment#CommentAnalytic", "reportCommentImageClick params = " + r102);
        this.f232209g.a("ccm_comment_image_click", r102);
        return;
    L5:
        tt5.a.h("Comment#CommentAnalytic", "reportCommentImageClick replyId is empty");
        goto L6
    }

    public final void o(String r100, String r101, Map<String, String> r102) {
        Map<String, Object> r103 = b();
        HashMap r104 = (HashMap) r103;
        r104.put("click", r100);
        if (r101 == null) goto L6;
        r104.put("reaction_card_id", r101);
    L6:
        if (r100.equals(ITwitterService.ResponseConstants.USER_NAME) == false) goto L8;
        r104.put(PickerReporterConstants.KEY.TARGET, "ccm_reaction_detail_page_view");
    L9:
        if (r102 != null) goto L11;
    L13:
        tt5.a.b("Comment#CommentAnalytic", "reportReactionClick params = " + r103);
        this.f232209g.a("ccm_reaction_click", r103);
        return;
    L11:
        if (((HashMap) r102).isEmpty() == true) goto L13;
        r104.putAll(r102);
        goto L13
    L8:
        r104.put(PickerReporterConstants.KEY.TARGET, "none");
        goto L9
    }

    public final void p(String r100, String r101, Map<String, String> r102) {
        Map<String, Object> r103 = b();
        HashMap r104 = (HashMap) r103;
        r104.put("click", r100);
        if (r101 == null) goto L5;
        r104.put("reaction_card_id", r101);
    L5:
        r104.put(PickerReporterConstants.KEY.TARGET, "none");
        if (r102 != null) goto L8;
    L10:
        tt5.a.b("Comment#CommentAnalytic", "reportReactionDetailClick params = " + r103);
        this.f232209g.a("ccm_reaction_detail_page_click", r103);
        return;
    L8:
        if (((HashMap) r102).isEmpty() == true) goto L10;
        r104.putAll(r102);
        goto L10
    }

    public final void g(String r100, String r101, String r102, Map<String, String> r103) {
        Map<String, Object> r104 = b();
        HashMap r105 = (HashMap) r104;
        r105.put("click", r100);
        if (r101 == null) goto L5;
        r105.put("comment_card_id", r101);
    L5:
        if (r102 == null) goto L8;
        r105.put("comment_id", r102);
    L8:
        if ("cancel_click".equals(r100) == true) goto L10;
        r105.put("is_full_comment_flag", String.valueOf(this.f232205c));
    L10:
        if (r103 != null) goto L12;
    L14:
        tt5.a.b("Comment#CommentAnalytic", "reportCommentClick params = " + r104);
        this.f232209g.a("ccm_comment_click", r104);
        return;
    L12:
        if (r103.isEmpty() == true) goto L14;
        r105.putAll(r103);
        goto L14
    }

    public final void c(String r100, String r101, String r102, String r103, String r104) {
        Map<String, Object> r105 = b();
        HashMap r106 = (HashMap) r105;
        r106.put("click", r100);
        r106.put("ai_comment_id", r101);
        r106.put("comment_card_id", r102);
        r106.put(NoticeInfo.KEY_REPLY_ID, r103);
        r106.put("ai_reply_user_type", r104);
        tt5.a.b("Comment#CommentAnalytic", "reportAIReplyClick params = " + r105);
        this.f232209g.a("ccm_comment_box_ai_reply_click", r105);
    }

    public final void d(final String r100, final Map<String, String> r110, final String r111, final String r112, final boolean r113) {
        a().subscribeOn(fo5.d.a()).map(new d(r100, r110, r111, r112, r113)).map(new e(this)).subscribe(new f(), new g());
    }

    public final void f(String r100, String r101, boolean r102, boolean r103, String r104) {
        Map<String, Object> r105 = b();
        ((HashMap) r105).put("card_id", r100);
        ((HashMap) r105).put("comment_id", r101);
        HashMap r106 = (HashMap) r105;
        r106.put("is_presenter", String.valueOf(r102));
        r106.put("is_magic_share", String.valueOf(r103));
        r106.put("comment_visible_range", r104);
        tt5.a.b("Comment#CommentAnalytic", "reportCommentCheckboxView params = " + r105);
        this.f232209g.a("ccm_comment_check_box_view", r105);
    }

    public final void r(String r100, String r101, String r102, RevisionExtra.RevisionTypes r103, Map<String, String> r104) {
        Map<String, Object> r105 = b();
        HashMap r106 = (HashMap) r105;
        r106.put("click", r100);
        if (r101 == null) goto L5;
        r106.put("suggestion_card_id", r101);
    L5:
        if (r102 == null) goto L7;
        r106.put("suggestion_id", r102);
    L7:
        if (r103 == null) goto L9;
        r106.put("suggestion_card_type", r103);
    L9:
        r106.put(PickerReporterConstants.KEY.TARGET, "none");
        if (r104 != null) goto L12;
    L14:
        tt5.a.b("Comment#CommentAnalytic", "reportSuggestionClick params = " + r105);
        this.f232209g.a("ccm_doc_suggestion_card_click", r105);
        return;
    L12:
        if (r104.isEmpty() == true) goto L14;
        r106.putAll(r104);
        goto L14
    }

    public h(com.bytedance.ee.bear.middleground.comment.p r100, String r101, String r102, boolean r103, String r104, v r105, boolean r106) {
        this.f232203a = r101;
        this.f232204b = r102;
        if (sbb.e.f541301l.getType().equals(r102) == true) goto L7;
        if (r103 == true) goto L7;
        boolean r107 = false;
    L8:
        this.f232205c = r107;
        this.f232208f = r104;
        this.f232206d = r105;
        this.f232207e = r106;
        this.f232209g = new com.bytedance.ee.bear.middleground.comment.o(r100);
        return;
    L7:
        r107 = true;
        goto L8
    }
}
