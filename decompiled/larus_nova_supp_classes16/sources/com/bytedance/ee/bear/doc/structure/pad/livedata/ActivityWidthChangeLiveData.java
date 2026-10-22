package com.bytedance.ee.bear.doc.structure.pad.livedata;

import android.view.View;
import androidx.lifecycle.LiveData;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/doc/structure/pad/livedata/ActivityWidthChangeLiveData;", "Landroidx/lifecycle/LiveData;", "", "contentViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "<init>", "(Ljava/lang/ref/WeakReference;)V", "contentView", "getContentView", "()Landroid/view/View;", "height", "getHeight", "()I", "setHeight", "(I)V", "onWidthChangedListener", "Landroid/view/View$OnLayoutChangeListener;", "onActive", "", "onInactive", "Companion", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActivityWidthChangeLiveData extends LiveData<Integer> {
    public final WeakReference<View> a;
    public final b b;

    public static final class a {
    }

    public static final class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ ActivityWidthChangeLiveData a;

        public b(ActivityWidthChangeLiveData r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            this.a.getClass();
            int r10 = r4 - r2;
            int r11 = r8 - r6;
            if (r10 == r11) goto L6;
            tt5.a.h("ActivityWidthChangeLiveData", "width changed, cur is: " + r10 + ", pre is: " + r11);
            this.a.postValue(Integer.valueOf(r10));
            return;
        }
    }

    static {
    }

    public final void onActive() {
        super.onActive();
        View r0 = this.a.get();
        if (r0 == null) goto L6;
        postValue(Integer.valueOf(r0.getWidth()));
        r0.addOnLayoutChangeListener(this.b);
        return;
    }

    public final void onInactive() {
        super.onInactive();
        View r0 = this.a.get();
        if (r0 == null) goto L6;
        r0.removeOnLayoutChangeListener(this.b);
        return;
    }

    public ActivityWidthChangeLiveData(WeakReference<View> r2) {
        Intrinsics.checkNotNullParameter(r2, "contentViewRef");
        this.a = r2;
        this.b = new b(this);
    }
}
