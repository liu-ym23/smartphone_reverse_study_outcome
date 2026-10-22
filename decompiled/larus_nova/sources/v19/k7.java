package v19;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.graphics.Insets;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes27.dex */
public final class k7 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f552579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f552580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function2<Insets, Boolean, Unit> f552581c;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Rect r100 = new Rect();
        boolean r101 = z5.f552640a;
        if (z5.c(this.f552579a, r100) == true) goto L5;
        return;
    L5:
        int r102 = Math.abs(this.f552580b.getBottom() - r100.bottom);
        if (r102 <= 0) goto L8;
        boolean r103 = true;
    L9:
        Insets r104 = Insets.of(0, 0, 0, r102);
        Function2<Insets, Boolean, Unit> r105 = this.f552581c;
        if (r105 == null) goto L13;
        r105.invoke(r104, Boolean.valueOf(r103));
        return;
    L13:
        return;
    L8:
        r103 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k7(View r100, View r101, Function2<? super Insets, ? super Boolean, Unit> r102) {
        this.f552579a = r100;
        this.f552580b = r101;
        this.f552581c = r102;
    }
}
