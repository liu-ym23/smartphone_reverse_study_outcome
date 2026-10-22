package com.bytedance.awemeopen.apps.framework.feed.ui.information.camera;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.awemeopen.collect.serviceapi.AoCameraService;
import com.bytedance.awemeopen.servicesapi.log.AoLogService;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r14.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/information/camera/CameraAnchorElement;", "Lcom/bytedance/awemeopen/apps/framework/feed/slide/framework/element/BaseElement;", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/information/camera/g;", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/information/camera/h;", "", "Ljz3/a;", "Landroidx/lifecycle/LifecycleObserver;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CameraAnchorElement extends BaseElement<g, h, Object, jz3.a> implements LifecycleObserver {
    public final LifecycleOwner g;
    public final o h;
    public final Lazy i;
    public jz3.a j;
    public final String k;
    public List<w> l;

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void n() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a b() {
        return new g();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b c() {
        return new h();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c d() {
        Context r1 = getContext();
        g r2 = g();
        h r3 = h();
        String r4 = this.h.getContentScene();
        if (r4 != null) goto L6;
        r4 = "";
    L6:
        return new f(r1, r2, r3, r4);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void k() {
        AoLogService r0 = j64.a.a(AoLogService.class);
        if (r0 == null) goto L5;
        r0.e(this.k, "onAttach");
    L5:
        h().getClass();
        List<w> r1 = this.l;
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        return;
    L14:
        h r3 = h();
        List<w> r4 = this.l;
        Intrinsics.checkNotNull(r4);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "hostExpands");
        r3.a.b(r4);
        p();
        return;
    L8:
        if (r1.isEmpty() == true) goto L11;
        r2 = false;
        goto L12
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void m() {
        AoLogService r0 = j64.a.a(AoLogService.class);
        if (r0 == null) goto L5;
        r0.e(this.k, "onDetach");
    L5:
        h().getClass();
        j();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void o() {
        AoLogService r0 = j64.a.a(AoLogService.class);
        if (r0 == null) goto L5;
        r0.e(this.k, "onUnBind");
    L5:
        this.j = null;
        this.l = null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void onCreate() {
        g r0 = g();
        Observer<w> r1 = new a(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.a.a(r1);
        g r2 = g();
        Observer<w> r3 = new b(this);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "observer");
        r2.b.a(r3);
        h r4 = h();
        Observer<w> r5 = new c(this);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "observer");
        r4.b.a(r5);
        if ((getContext() instanceof LifecycleOwner) == false) goto L8;
        Lifecycle r6 = this.g.getLifecycle();
        if (r6 == null) goto L9;
        r6.addObserver(this);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d e() {
        return com.bytedance.awemeopen.apps.framework.feed.ui.information.b.g;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void l(jz3.a r3) {
        jz3.a r4 = r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        this.j = r4;
        r14.c r5 = r4.a;
        if (r5 == null) goto L7;
        Map r6 = r5.w();
        if (r6 == null) goto L7;
        List<w> r7 = (List) r6.get(4);
    L8:
        this.l = r7;
        AoCameraService r8 = (AoCameraService) this.i.getValue();
        boolean r1 = true;
        if (r8 == null) goto L11;
        boolean r9 = r8.C();
    L12:
        if (r9 == true) goto L14;
        this.l = null;
    L14:
        List<w> r10 = this.l;
        if (r10 != null) goto L17;
    L20:
        if (r1 == false) goto L23;
        j();
        return;
    L23:
        return;
    L17:
        if (r10.isEmpty() == true) goto L20;
        r1 = false;
        goto L20
    L11:
        r9 = true;
    L7:
        r7 = null;
        goto L8
    }

    public CameraAnchorElement(Context r2, LifecycleOwner r3, o r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "vm");
        super(r2);
        this.g = r3;
        this.h = r4;
        this.i = LazyKt.lazy(CameraAnchorElement$bdpCameraService$2.INSTANCE);
        this.k = "CameraAnchorElement";
    }
}
