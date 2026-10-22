package com.bytedance.awemeopen.apps.framework.feed.ui.information.leftcomponent;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.profile.AosUserProfileFeedFragmentViewModel;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.FeedSeekBarHelper;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.domain.base.repo.GsonHolder;
import com.bytedance.awemeopen.export.api.AosConfigService;
import com.bytedance.awemeopen.servicesapi.log.AoLogService;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r14.a0;
import r14.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006:\u0001\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/information/leftcomponent/LeftComponentElement;", "Lcom/bytedance/awemeopen/apps/framework/feed/slide/framework/element/BaseElement;", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/information/leftcomponent/i;", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/information/leftcomponent/l;", "", "Ljz3/a;", "Landroidx/lifecycle/LifecycleObserver;", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class LeftComponentElement extends BaseElement<i, l, Object, jz3.a> implements LifecycleObserver {
    public static final /* synthetic */ int y = 0;
    public final LifecycleOwner g;
    public final o h;
    public r14.c i;
    public jz3.a j;
    public final String k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public List<w> s;
    public boolean t;
    public boolean u;
    public final List<Integer> v;
    public final Lazy w;
    public final b x;

    public static final class a {
    }

    public static final class b implements FeedSeekBarHelper.c {
        public final /* synthetic */ LeftComponentElement a;

        public b(LeftComponentElement r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.FeedSeekBarHelper.c
        public final void a(float r8) {
            LeftComponentElement r0 = this.a;
            if (r0.q == false) goto L5;
        L7:
            LeftComponentElement r1 = this.a;
            if (r1.r == false) goto L10;
            return;
        L10:
            if (r8 <= (((Number) r1.m.getValue()).doubleValue() * ((double) 100))) goto L47;
            LeftComponentElement r9 = this.a;
            r9.getClass();
            AoLogService r2 = j64.a.a(AoLogService.class);
            if (r2 == null) goto L15;
            r2.e(r9.k, "showStrongCard + this = " + r9);
        L15:
            if (r9.p == true) goto L17;
            return;
        L17:
            if (r9.t == false) goto L19;
            return;
        L19:
            if (r9.u == true) goto L50;
            List<w> r3 = r9.s;
            if (r3 != null) goto L23;
        L26:
            boolean r4 = true;
        L27:
            if (r4 == false) goto L30;
            return;
        L30:
            if (((Number) r9.n.getValue()).intValue() != 1) goto L34;
            r9.h().d.b(Boolean.TRUE);
            AoLogService r5 = j64.a.a(AoLogService.class);
            if (r5 == null) goto L34;
            r5.e(r9.k, "showStrongCard mode = " + r9.h());
        L34:
            List<w> r6 = r9.s;
            if (r6 == null) goto L40;
            Iterator<T> r7 = r6.iterator();
        L38:
            if (r7.hasNext() == false) goto L40;
            ((w) r7.next()).k(((Number) r9.n.getValue()).intValue());
        L40:
            List<w> r10 = r9.s;
            if (r10 == null) goto L43;
            l r11 = r9.h();
            r11.getClass();
            Intrinsics.checkNotNullParameter(r10, "hostExpands");
            r11.a.b(r10);
        L43:
            r9.r = true;
            return;
        L23:
            if (r3.isEmpty() == true) goto L26;
            r4 = false;
            goto L27
        L50:
            return;
        L47:
            return;
        L5:
            if (r8 <= (((Number) r0.l.getValue()).doubleValue() * ((double) 100))) goto L7;
            this.a.t();
            goto L7
        }
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void n() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a b() {
        return new i();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b c() {
        return new l();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c d() {
        Context r1 = getContext();
        i r2 = g();
        l r3 = h();
        String r4 = this.h.getContentScene();
        if (r4 != null) goto L6;
        r4 = "";
    L6:
        return new h(r1, r2, r3, r4);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void k() {
        AoLogService r0 = j64.a.a(AoLogService.class);
        if (r0 == null) goto L5;
        r0.e(this.k, "onAttach");
    L5:
        boolean r1 = true;
        this.o = true;
        h().getClass();
        List<w> r2 = this.s;
        if (r2 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L14;
        return;
    L14:
        boolean r4 = q();
        if (1.0E-4d > ((Number) this.l.getValue()).doubleValue()) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == false) goto L20;
    L21:
        t();
        if (r4 == true) goto L24;
    L36:
        if (this.p == true) goto L38;
        return;
    L38:
        if (this.o == false) goto L51;
        List<w> r6 = this.s;
        if (r6 != null) goto L42;
    L45:
        if (r1 == true) goto L52;
        this.h.addPlayDurationChangeListener(this.x);
        return;
    L52:
        return;
    L42:
        if (r6.isEmpty() == true) goto L45;
        r1 = false;
        goto L45
    L51:
        return;
    L24:
        if (Intrinsics.areEqual(this.h.getCommerceClickType(), "book_anchor") == false) goto L33;
        List<w> r7 = this.s;
        if (r7 == null) goto L31;
        Iterator<T> r8 = r7.iterator();
    L29:
        if (r8.hasNext() == false) goto L31;
        ((w) r8.next()).j(0);
    L31:
        String r9 = GsonProtectorUtils.toJson(GsonHolder.a(), this.s);
        AosConfigService.a.a(AosExtConfig.b, getContext(), r9, false, new LeftComponentElement$justShowBookWithScaling$2(this), 4);
        s(true);
        this.h.setCommerceClickType("");
        goto L36
    L33:
        if (Intrinsics.areEqual(this.h.getCommerceClickType(), "book_normal") == false) goto L36;
        s(false);
        this.h.setCommerceClickType("");
        goto L36
    L20:
        if (q() == false) goto L36;
    L17:
        r5 = false;
        goto L18
    L8:
        if (r2.isEmpty() == true) goto L11;
        r3 = false;
        goto L12
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void m() {
        AoLogService r0 = j64.a.a(AoLogService.class);
        if (r0 == null) goto L5;
        r0.e(this.k, "onDetach");
    L5:
        h().getClass();
        this.o = false;
        this.q = false;
        this.r = false;
        this.t = false;
        this.u = false;
        List<w> r1 = this.s;
        if (r1 == null) goto L11;
        Iterator<T> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        ((w) r2.next()).k(0);
    L11:
        List<w> r3 = this.s;
        if (r3 == null) goto L14;
        l r4 = h();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r3, "hostExpands");
        r4.a.b(r3);
    L14:
        h().d.b(Boolean.FALSE);
        j();
        this.h.removePlayDurationChangeListener(this.x);
        ((ArrayList) this.v).clear();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void o() {
        AoLogService r0 = j64.a.a(AoLogService.class);
        if (r0 == null) goto L5;
        r0.e(this.k, "onUnBind");
    L5:
        this.i = null;
        this.j = null;
        this.p = false;
        this.s = null;
    }

    public final boolean q() {
        d14.a r0 = b14.a.a;
        if (b14.a.a(t24.a.class).k() == true) goto L5;
        return false;
    L5:
        r14.c r1 = this.i;
        if (r1 == null) goto L15;
        String r2 = r1.c();
        if (r2 == null) goto L15;
        if (Intrinsics.areEqual(r2, this.h.getPageConfig().getEnterAid()) == true) goto L13;
        return false;
    L13:
        return true;
    L15:
        return false;
    }

    public final pz3.d r() {
        return (pz3.d) this.w.getValue();
    }

    public final void t() {
        List<w> r0 = this.s;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return;
    L12:
        if (this.q == false) goto L14;
        return;
    L14:
        p();
        List<w> r2 = this.s;
        if (r2 == null) goto L20;
        Iterator<T> r3 = r2.iterator();
    L18:
        if (r3.hasNext() == false) goto L20;
        ((w) r3.next()).k(0);
    L20:
        List<w> r4 = this.s;
        if (r4 == null) goto L23;
        l r5 = h();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r4, "hostExpands");
        r5.a.b(r4);
    L23:
        this.q = true;
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void onCreate() {
        i r0 = g();
        Observer<w> r1 = new com.bytedance.awemeopen.apps.framework.feed.ui.information.leftcomponent.a(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.a.a(r1);
        i r2 = g();
        Observer<w> r3 = new com.bytedance.awemeopen.apps.framework.feed.ui.information.leftcomponent.b(this);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "observer");
        r2.b.a(r3);
        l r4 = h();
        Observer<Integer> r5 = new c(this);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "observer");
        r4.b.a(r5);
        l r6 = h();
        Observer<Integer> r7 = new d(this);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "observer");
        r6.c.a(r7);
        l r8 = h();
        Observer<Boolean> r9 = new e(this);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "observer");
        r8.d.a(r9);
        if ((getContext() instanceof LifecycleOwner) == false) goto L8;
        Lifecycle r10 = this.g.getLifecycle();
        if (r10 == null) goto L9;
        r10.addObserver(this);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d e() {
        return com.bytedance.awemeopen.apps.framework.feed.ui.information.b.f;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void l(jz3.a r2) {
        jz3.a r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "data");
        this.j = r3;
        r14.c r4 = r3.a;
        this.i = r4;
        if (r4 == null) goto L7;
        Map r5 = r4.w();
        if (r5 == null) goto L7;
        List<w> r6 = (List) r5.get(2);
    L8:
        this.s = r6;
        List<w> r7 = r6;
        if (r7 != null) goto L11;
    L14:
        boolean r8 = true;
    L15:
        if (r8 == false) goto L17;
        j();
    L17:
        this.p = true;
        return;
    L11:
        if (r7.isEmpty() == true) goto L14;
        r8 = false;
    L7:
        r6 = null;
        goto L8
    }

    public final void s(boolean r12) {
        o r0 = this.h;
        String r1 = "";
        if (r0 == null) goto L6;
        String r2 = r0.sceneId();
        if (r2 == null) goto L6;
    L7:
        String r3 = null;
        if (Intrinsics.areEqual(r2, "others_homepage") == false) goto L15;
        o r4 = this.h;
        if ((r4 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L12;
        AosUserProfileFeedFragmentViewModel r5 = (AosUserProfileFeedFragmentViewModel) r4;
    L13:
        if (r5 == null) goto L15;
        String r6 = r5.getFromGroupId();
    L16:
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("enter_from", r2);
        r14.c r8 = this.i;
        if (r8 == null) goto L22;
        User r9 = r8.f();
        if (r9 == null) goto L22;
        String r10 = r9.u();
        if (r10 == null) goto L22;
    L23:
        r7.put("author_id", r10);
        r14.c r11 = this.i;
        if (r11 == null) goto L27;
        String r13 = r11.c();
        if (r13 == null) goto L27;
    L28:
        r7.put("group_id", r13);
        r7.put("duration", "");
        r14.c r14 = this.i;
        if (r14 == null) goto L33;
        a0 r15 = r14.d;
        if (r15 == null) goto L33;
        r3 = r15.a();
    L33:
        if (r3 == null) goto L36;
        r1 = r3;
    L36:
        r7.put("impr_id", r1);
        r7.put("from_group_id", r6);
        if (r12 == false) goto L39;
        String r16 = "auto";
    L40:
        r7.put("transfer_mode", r16);
        r7.put("type", "book");
        AosEventReporter.s(AosEventReporter.a, "video_outer_play_click", r7, null, null, null, 28);
        return;
    L39:
        r16 = "manual";
    L27:
        r13 = "";
    L22:
        r10 = "";
        goto L23
    L12:
        r5 = null;
    L15:
        r6 = "";
    L6:
        r2 = "";
        goto L7
    }

    public LeftComponentElement(Context r2, LifecycleOwner r3, o r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "vm");
        super(r2);
        this.g = r3;
        this.h = r4;
        this.k = "LeftComponentElement";
        this.l = LazyKt.lazy(LeftComponentElement$weakCardPercent$2.INSTANCE);
        this.m = LazyKt.lazy(LeftComponentElement$strongCardPercent$2.INSTANCE);
        this.n = LazyKt.lazy(LeftComponentElement$strongCardStyle$2.INSTANCE);
        this.v = new ArrayList();
        this.w = LazyKt.lazy(LeftComponentElement$videoScalingParams$2.INSTANCE);
        this.x = new b(this);
    }
}
