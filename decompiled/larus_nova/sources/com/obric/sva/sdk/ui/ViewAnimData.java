package com.obric.sva.sdk.ui;

import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/obric/sva/sdk/ui/ViewAnimData;", "", "view", "Landroid/view/View;", "propertyName", "", "startValue", "", "endValue", "clipBounds", "", "interpolator", "Landroid/view/animation/Interpolator;", "<init>", "(Landroid/view/View;Ljava/lang/String;FFZLandroid/view/animation/Interpolator;)V", "getView", "()Landroid/view/View;", "getPropertyName", "()Ljava/lang/String;", "getStartValue", "()F", "getEndValue", "getClipBounds", "()Z", "getInterpolator", "()Landroid/view/animation/Interpolator;", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ViewAnimData {
    private final boolean clipBounds;
    private final float endValue;
    private final Interpolator interpolator;
    private final String propertyName;
    private final float startValue;
    private final View view;

    public boolean getClipBounds() {
        return this.clipBounds;
    }

    public float getEndValue() {
        return this.endValue;
    }

    public Interpolator getInterpolator() {
        return this.interpolator;
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public float getStartValue() {
        return this.startValue;
    }

    public View getView() {
        return this.view;
    }

    public ViewAnimData(View r100, String r101, float r102, float r103, boolean r104, Interpolator r105) {
        Intrinsics.checkNotNullParameter(r101, "propertyName");
        Intrinsics.checkNotNullParameter(r105, "interpolator");
        this.view = r100;
        this.propertyName = r101;
        this.startValue = r102;
        this.endValue = r103;
        this.clipBounds = r104;
        this.interpolator = r105;
    }

    public /* synthetic */ ViewAnimData(View r100, String r101, float r110, float r111, boolean r112, Interpolator r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 32) == 0) goto L5;
        r113 = new LinearInterpolator();
    L5:
        this(r100, r101, r110, r111, r112, r113);
    }
}
