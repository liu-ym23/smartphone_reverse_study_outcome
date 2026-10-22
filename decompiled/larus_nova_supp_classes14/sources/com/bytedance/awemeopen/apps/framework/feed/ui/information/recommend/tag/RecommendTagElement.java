package com.bytedance.awemeopen.apps.framework.feed.ui.information.recommend.tag;

import android.app.Activity;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.profile.AosUserProfileFeedFragmentViewModel;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import r14.a0;
import r14.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class RecommendTagElement extends BaseElement<f, g, tz3.a, jz3.a> {
    public final Activity g;
    public final o h;
    public jz3.a i;
    public final Lazy j;

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void o() {
        this.i = null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a b() {
        return new f();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b c() {
        return new g();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<f, g> d() {
        return new e(getContext(), g(), h());
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void n() {
        AosEventReporter r0 = AosEventReporter.a;
        o r1 = this.h;
        jz3.a r2 = this.i;
        String r10 = r1.getPageConfig().getHostEnterFrom();
        r0.getClass();
        Intrinsics.checkNotNullParameter(CommentScene.COMMENTSCENE_NO_AWEME, "isRecommendTag");
        Intrinsics.checkNotNullParameter(r10, "hostEnterFrom");
        String r3 = r1.sceneId();
        if (r3 != null) goto L5;
        String r5 = "";
    L7:
        if (Intrinsics.areEqual(r5, "others_homepage") == true) goto L9;
    L14:
        String r9 = "";
    L15:
        if (r2 == null) goto L34;
        r14.c r4 = r2.a;
        if (r4 == null) goto L35;
        d14.a r6 = b14.a.a;
        t24.a r7 = b14.a.a(t24.a.class);
        User r8 = r4.f();
        if (r8 == null) goto L24;
        String r11 = r8.u();
        if (r11 == null) goto L24;
        String r12 = r11;
    L25:
        String r13 = r4.c();
        a0 r14 = r4.d;
        if (r14 == null) goto L31;
        String r15 = r14.a();
        if (r15 == null) goto L31;
        String r16 = r15;
    L32:
        r7.n1(r5, r13, r16, r12, r9, r10);
        return;
    L31:
        r16 = "";
    L24:
        r12 = "";
        goto L25
    L35:
        return;
    L34:
        return;
    L9:
        if ((r1 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L11;
        AosUserProfileFeedFragmentViewModel r17 = (AosUserProfileFeedFragmentViewModel) r1;
    L12:
        if (r17 == null) goto L14;
        r9 = r17.getFromGroupId();
        goto L15
    L11:
        r17 = null;
        goto L12
    L5:
        r5 = r3;
        goto L7
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void onCreate() {
        f r0 = g();
        Observer<Unit> r1 = new b(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.a.a(r1);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d e() {
        return com.bytedance.awemeopen.apps.framework.feed.ui.information.b.b;
    }

    public final Activity getActivity() {
        return this.g;
    }

    public static int q(String r7) {
        String r0 = a.c;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        r0 = "[a-zA-Z]";
    L11:
        Regex r4 = new Regex(r0);
        String r2 = a.d;
        if (r2 != null) goto L14;
    L17:
        boolean r5 = true;
    L18:
        if (r5 == false) goto L20;
        r2 = "\\d";
    L20:
        Regex r6 = new Regex(r2);
        String r8 = a.e;
        if (r8 != null) goto L23;
    L26:
        boolean r9 = true;
    L27:
        if (r9 == false) goto L29;
        r8 = "[!\"#$%&'()*+,-./:;<=>?@\\[\\\\\\]^_`{|}~]";
    L29:
        Regex r10 = new Regex(r8);
        String r11 = a.f;
        if (r11 != null) goto L32;
    L35:
        if (r1 == false) goto L37;
        r11 = "\\s+";
    L37:
        Regex r12 = new Regex(r11);
        int r13 = SequencesKt.count(Regex.findAll$default(r4, r7, 0, 2, null));
        int r14 = SequencesKt.count(Regex.findAll$default(r6, r7, 0, 2, null));
        int r15 = SequencesKt.count(Regex.findAll$default(r10, r7, 0, 2, null));
        int r16 = (r13 + r14) + r15;
        return r16 + SequencesKt.count(Regex.findAll$default(r12, r7, 0, 2, null));
    L32:
        if (StringsKt.isBlank(r11) == true) goto L35;
        r1 = false;
        goto L35
    L23:
        if (StringsKt.isBlank(r8) == true) goto L26;
        r9 = false;
        goto L27
    L14:
        if (StringsKt.isBlank(r2) == true) goto L17;
        r5 = false;
        goto L18
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r3 = false;
        goto L9
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void l(jz3.a r9) {
        jz3.a r10 = r9;
        Intrinsics.checkNotNullParameter(r10, "data");
        this.i = r10;
        JSONArray r0 = a.a;
        int r1 = r0.length();
        boolean r2 = false;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L12;
        String r5 = r0.optString(r3);
        if (Intrinsics.areEqual(this.h.getPageConfig().getHostEnterFrom(), r5) == true) goto L10;
        if (Intrinsics.areEqual(r5, "any") == true) goto L10;
        r3 = r3 + 1;
    L10:
        boolean r4 = true;
    L13:
        String r6 = null;
        String r7 = "";
        if (r4 == false) goto L54;
        f0 r8 = r10.a.I();
        if (r8 == null) goto L19;
        String r11 = r8.a();
        if (r11 == null) goto L19;
    L21:
        if (StringsKt.isBlank(r11) == true) goto L30;
        int r12 = ((Number) this.j.getValue()).intValue();
        int r13 = q(r11);     // Catch: Throwable -> L25
        int r14 = r13 + ((r11.length() - r13) * 2);
    L27:
        if (1 > r14) goto L30;
        if (r14 > r12) goto L30;
        boolean r15 = true;
    L31:
        if (r15 == true) goto L53;
        JSONObject r16 = this.h.getPageConfig().getRecommendTagText();
        if (r16 == null) goto L38;
        String r17 = r10.a.c();
        if (r17 != null) goto L37;
        r17 = "";
    L37:
        String r18 = r16.optString(r17);
    L39:
        if (r18 != null) goto L42;
        r18 = "";
    L42:
        if (StringsKt.isBlank(r18) == true) goto L51;
        int r19 = ((Number) this.j.getValue()).intValue();
        int r20 = q(r18);     // Catch: Throwable -> L46
        int r21 = r20 + ((r18.length() - r20) * 2);
    L48:
        if (1 > r21) goto L51;
        if (r21 > r19) goto L51;
        boolean r22 = true;
    L52:
        if (r22 == false) goto L54;
    L46:
        th = move-exception;
        AoLogger.c("calculate recommend tag text length error", new Object[]{th});
        r21 = 0;
    L51:
        r22 = false;
        goto L52
    L38:
        r18 = null;
    L53:
        boolean r23 = true;
    L55:
        if (r23 == false) goto L90;
        p();
        f0 r24 = r10.a.I();
        if (r24 == null) goto L59;
        String r25 = r24.a();
    L60:
        JSONObject r26 = this.h.getPageConfig().getRecommendTagText();
        if (r26 == null) goto L66;
        String r27 = r10.a.c();
        if (r27 != null) goto L65;
        r27 = "";
    L65:
        r6 = r26.optString(r27);
    L66:
        if (r25 != null) goto L68;
    L71:
        boolean r28 = true;
    L73:
        if (r28 == true) goto L79;
        g r29 = h();
        if (r25 == null) goto L78;
        r7 = r25;
    L78:
        r29.getClass();
        Intrinsics.checkNotNullParameter(r7, "recommendTagText");
        r29.a.b(r7);
        return;
    L79:
        if (r6 != null) goto L81;
    L82:
        r2 = true;
    L83:
        if (r2 == true) goto L89;
        g r30 = h();
        if (r6 == null) goto L88;
        r7 = r6;
    L88:
        r30.getClass();
        Intrinsics.checkNotNullParameter(r7, "recommendTagText");
        r30.a.b(r7);
        return;
    L89:
        g r31 = h();
        r31.getClass();
        Intrinsics.checkNotNullParameter("", "recommendTagText");
        r31.a.b("");
        return;
    L81:
        if (StringsKt.isBlank(r6) == false) goto L83;
    L68:
        if (StringsKt.isBlank(r25) == true) goto L71;
        r28 = false;
        goto L73
    L59:
        r25 = null;
        goto L60
    L90:
        j();
        return;
    L25:
        th = move-exception;
        AoLogger.c("calculate recommend tag text length error", new Object[]{th});
        r14 = 0;
    L30:
        r15 = false;
    L19:
        r11 = "";
    L54:
        r23 = false;
        goto L55
    L12:
        r4 = false;
        goto L13
    }

    public RecommendTagElement(Activity r2, o r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "vm");
        super(r2);
        this.g = r2;
        this.h = r3;
        this.j = LazyKt.lazy(RecommendTagElement$maxRecommendTagLength$2.INSTANCE);
    }
}
