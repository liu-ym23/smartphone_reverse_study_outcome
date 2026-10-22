package com.bytedance.awemeopen.apps.framework.feed.ui.bottombar.anchor;

import android.app.Activity;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.awemeopen.apps.framework.utils.e0;
import com.bytedance.awemeopen.collect.serviceapi.AoCameraService;
import com.bytedance.awemeopen.search.serviceapi.AoSearchService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r14.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006:\u0001\rR\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/bottombar/anchor/BottomBarElement;", "Lcom/bytedance/awemeopen/apps/framework/feed/slide/framework/element/BaseElement;", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/bottombar/anchor/j;", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/bottombar/anchor/k;", "", "Ljz3/a;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/app/Activity;", "g", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "activity", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class BottomBarElement extends BaseElement<j, k, Object, jz3.a> implements LifecycleObserver {
    public static final /* synthetic */ int t = 0;
    public final Activity g;
    public final o h;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b i;
    public jz3.a j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public boolean p;
    public String q;
    public Lifecycle r;
    public final com.bytedance.awemeopen.apps.framework.feed.ui.bottombar.anchor.b s;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Lifecycle.Event.values().length];
            r0[Lifecycle.Event.ON_RESUME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void m() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void n() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void o() {
        this.l = null;
        this.m = null;
        this.k = null;
        this.p = false;
        Lifecycle r1 = this.r;
        if (r1 == null) goto L5;
        r1.removeObserver(this.s);
    L5:
        this.r = null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a b() {
        return new j();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b c() {
        return new k();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c d() {
        return new i(getContext(), g(), h());
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void k() {
        if (Intrinsics.areEqual(this.q, "TYPE_SEARCH_ANCHOR") == false) goto L16;
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(new LinkedHashMap());
        jz3.a r2 = this.j;
        int r3 = e0.a;
        if (r2 == null) goto L10;
        r14.c r4 = r2.a;
        if (r4 == null) goto L10;
        String r5 = r4.c();
        if (r5 == null) goto L10;
    L11:
        String r6 = this.m;
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        Intrinsics.checkNotNullParameter(r5, "aid");
        Intrinsics.checkNotNullParameter(r6, "content");
        Intrinsics.checkNotNullParameter("shortvideo_rs", "wordsSource");
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("group_id", r5);
        r8.put("words_content", r6);
        r8.put("is_douyin_sdk", CommentScene.COMMENTSCENE_NO_AWEME);
        r8.put("words_source", "shortvideo_rs");
        r8.put("refresh_reason", "back");
        r8.putAll(r0);
        AosEventReporter.s(AosEventReporter.a, "trending_words_show", r8, null, null, null, 28);
    L10:
        r5 = "";
    L16:
        if (this.p == true) goto L19;
        return;
    L19:
        if (Intrinsics.areEqual(this.q, "TYPE_CAMERA_ANCHOR") == false) goto L38;
        AosEventReporter r1 = AosEventReporter.a;
        o r7 = this.h;
        jz3.a r9 = this.j;
        String r10 = this.l;
        if (r10 != null) goto L23;
        r10 = "";
    L23:
        String r11 = this.k;
        if (r11 != null) goto L26;
        r11 = "";
    L26:
        String r12 = this.m;
        if (r12 != null) goto L30;
        r12 = "";
    L30:
        if (r7.getPageConfig().getHostExtraParams() == null) goto L35;
        JSONObject r13 = this.h.getPageConfig().getHostExtraParams();
        if (r13 == null) goto L34;
        JSONObject r14 = r13.put("host_expand_raw_data", this.n);
    L36:
        r1.getClass();
        AosEventReporter.i(r7, r9, r10, r11, r12, r14);
        return;
    L34:
        r14 = null;
        goto L36
    L35:
        r14 = new JSONObject().put("host_expand_raw_data", this.n);
        goto L36
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void onCreate() {
        j r0 = g();
        Observer<Unit> r1 = new com.bytedance.awemeopen.apps.framework.feed.ui.bottombar.anchor.a(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.a.a(r1);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d e() {
        return wz3.a.b;
    }

    public final Activity getActivity() {
        return this.g;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void l(jz3.a r6) {
        jz3.a r7 = r6;
        Intrinsics.checkNotNullParameter(r7, "data");
        this.j = r7;
        Map r8 = r7.a.w();
        if (r8 == null) goto L5;
        List r9 = (List) r8.get(5);
    L7:
        if (r9 != null) goto L9;
    L25:
        AoSearchService r10 = j64.a.a(AoSearchService.class);
        if (r10 == null) goto L28;
        r10.isAvailable();
    L28:
        String r3 = "TYPE_NONE_ANCHOR";
    L29:
        this.q = r3;
        if (Intrinsics.areEqual(r3, "TYPE_NONE_ANCHOR") == false) goto L33;
        j();
    L33:
        if ((getContext() instanceof LifecycleOwner) == false) goto L38;
        Lifecycle r11 = this.i.d.getLifecycle();
        this.r = r11;
        if (r11 == null) goto L39;
        r11.addObserver(this.s);
        return;
    L39:
        return;
    L38:
        return;
    L9:
        if ((!r9.isEmpty()) == false) goto L25;
        AoCameraService r1 = j64.a.a(AoCameraService.class);
        if (r1 != null) goto L13;
    L15:
        boolean r2 = false;
    L16:
        if (r2 == true) goto L25;
        w r12 = (w) ListProtector.get(r9, 0);
        this.l = r12.i();
        this.k = String.valueOf(r12.b());
        this.m = r12.a();
        this.n = r12.f();
        this.o = r12.d();
        k r4 = h();
        r4.getClass();
        r3 = "TYPE_CAMERA_ANCHOR";
        Intrinsics.checkNotNullParameter("TYPE_CAMERA_ANCHOR", "type");
        r4.e.b("TYPE_CAMERA_ANCHOR");
        p();
        this.p = true;
        k r5 = h();
        String r13 = this.m;
        Intrinsics.checkNotNull(r13);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r13, "name");
        r5.b.b(r13);
        if (TextUtils.isEmpty(this.l) == false) goto L20;
        k r14 = h();
        r14.getClass();
        Intrinsics.checkNotNullParameter("", "name");
        r14.a.b("");
    L21:
        List<String> r15 = r12.c();
        if (r15 == null) goto L24;
        h().c.b(r15);
    L24:
        h().f.b(Boolean.TRUE);
        goto L29
    L20:
        k r16 = h();
        String r17 = String.valueOf(this.l);
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "name");
        r16.a.b(r17);
        goto L21
    L13:
        if (r1.C() == true) goto L15;
        r2 = true;
        goto L16
    L5:
        r9 = null;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.awemeopen.apps.framework.feed.ui.bottombar.anchor.b] */
    public BottomBarElement(Activity r2, o r3, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "vm");
        Intrinsics.checkNotNullParameter(r4, "pageOwner");
        super(r2);
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.q = "TYPE_NONE_ANCHOR";
        this.s = new com.bytedance.awemeopen.apps.framework.feed.ui.bottombar.anchor.b(this);
    }
}
