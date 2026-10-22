package com.bytedance.ee.bear.doc.structure.pad.livedata;

import android.view.View;
import androidx.lifecycle.LiveData;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/doc/structure/pad/livedata/ActivityWidthChangeLiveData;", "Landroidx/lifecycle/LiveData;", "", "contentViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "<init>", "(Ljava/lang/ref/WeakReference;)V", "contentView", "getContentView", "()Landroid/view/View;", "height", "getHeight", "()I", "setHeight", "(I)V", "onWidthChangedListener", "Landroid/view/View$OnLayoutChangeListener;", "onActive", "", "onInactive", "Companion", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActivityWidthChangeLiveData extends LiveData<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<View> f218254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f218255b;

    public static final class a {
    }

    public static final class b implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActivityWidthChangeLiveData f218256a;

        public b(ActivityWidthChangeLiveData r100) {
            this.f218256a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            this.f218256a.getClass();
            int r109 = r103 - r101;
            int r110 = r107 - r105;
            if (r109 == r110) goto L6;
            tt5.a.h("ActivityWidthChangeLiveData", "width changed, cur is: " + r109 + ", pre is: " + r110);
            this.f218256a.postValue(Integer.valueOf(r109));
            return;
        }
    }

    static {
    }

    @Override // androidx.lifecycle.LiveData
    public final void onActive() {
        super.onActive();
        View r100 = this.f218254a.get();
        if (r100 == null) goto L6;
        postValue(Integer.valueOf(r100.getWidth()));
        r100.addOnLayoutChangeListener(this.f218255b);
        return;
    }

    @Override // androidx.lifecycle.LiveData
    public final void onInactive() {
        super.onInactive();
        View r100 = this.f218254a.get();
        if (r100 == null) goto L6;
        r100.removeOnLayoutChangeListener(this.f218255b);
        return;
    }

    public ActivityWidthChangeLiveData(WeakReference<View> r100) {
        Intrinsics.checkNotNullParameter(r100, "contentViewRef");
        this.f218254a = r100;
        this.f218255b = new b(this);
    }
}
