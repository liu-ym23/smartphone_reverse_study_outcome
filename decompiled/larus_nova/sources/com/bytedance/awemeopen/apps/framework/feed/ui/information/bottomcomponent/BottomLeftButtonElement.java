package com.bytedance.awemeopen.apps.framework.feed.ui.information.bottomcomponent;

import android.content.Context;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/information/bottomcomponent/BottomLeftButtonElement;", "Lcom/bytedance/awemeopen/apps/framework/feed/slide/framework/element/BaseElement;", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/information/bottomcomponent/c;", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/information/bottomcomponent/d;", "", "Ljz3/a;", "Landroidx/lifecycle/LifecycleObserver;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class BottomLeftButtonElement extends BaseElement<c, d, Object, jz3.a> implements LifecycleObserver {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LifecycleOwner f196031g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o f196032h;

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
        Iterator<T> r100 = this.f196032h.getHostExtensionInfo().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((j54.a) r100.next()).getClass();
        goto L4
    L6:
        c r101 = g();
        Observer<Unit> r102 = new a(this);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "observer");
        r101.f196034a.a(r102);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d e() {
        return com.bytedance.awemeopen.apps.framework.feed.ui.information.b.f196030n;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void l(jz3.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        j();
    }

    public BottomLeftButtonElement(Context r100, LifecycleOwner r101, o r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "vm");
        super(r100);
        this.f196031g = r101;
        this.f196032h = r102;
    }
}
