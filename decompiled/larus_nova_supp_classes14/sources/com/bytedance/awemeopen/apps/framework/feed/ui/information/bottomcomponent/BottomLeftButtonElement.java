package com.bytedance.awemeopen.apps.framework.feed.ui.information.bottomcomponent;

import android.content.Context;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/information/bottomcomponent/BottomLeftButtonElement;", "Lcom/bytedance/awemeopen/apps/framework/feed/slide/framework/element/BaseElement;", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/information/bottomcomponent/c;", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/information/bottomcomponent/d;", "", "Ljz3/a;", "Landroidx/lifecycle/LifecycleObserver;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class BottomLeftButtonElement extends BaseElement<c, d, Object, jz3.a> implements LifecycleObserver {
    public final LifecycleOwner g;
    public final o h;

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void n() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void o() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a b() {
        return new c();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b c() {
        return new d(new BottomLeftButtonElement$createModel$1(this));
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c d() {
        return new f(getContext(), g(), h());
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void onCreate() {
        Iterator<T> r0 = this.h.getHostExtensionInfo().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((j54.a) r0.next()).getClass();
        goto L4
    L6:
        c r1 = g();
        Observer<Unit> r2 = new a(this);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "observer");
        r1.a.a(r2);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d e() {
        return com.bytedance.awemeopen.apps.framework.feed.ui.information.b.n;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void l(jz3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        j();
    }

    public BottomLeftButtonElement(Context r2, LifecycleOwner r3, o r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "vm");
        super(r2);
        this.g = r3;
        this.h = r4;
    }
}
