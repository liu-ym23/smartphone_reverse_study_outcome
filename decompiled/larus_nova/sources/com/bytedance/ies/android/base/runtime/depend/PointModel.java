package com.bytedance.ies.android.base.runtime.depend;

import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "已废弃", replaceWith = @ReplaceWith(expression = "com.bytedance.android.ad.sdk.api.location.IAdLocationDepend", imports = {}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/android/base/runtime/depend/PointModel;", "", GXTemplateKey.GAIAX_PX, "", "py", "(DD)V", "getPx", "()D", "getPy", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "runtime-api_release"}, k = 1, mv = {1, 1, 16})
public final class PointModel {

    /* JADX INFO: renamed from: px, reason: collision with root package name */
    private final double f245616px;

    /* JADX INFO: renamed from: py, reason: collision with root package name */
    private final double f245617py;

    public static /* synthetic */ PointModel copy$default(PointModel r100, double r101, double r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f245616px;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.f245617py;
    L9:
        return r100.copy(r101, r102);
    }

    public final double component1() {
        return this.f245616px;
    }

    public final double component2() {
        return this.f245617py;
    }

    public final PointModel copy(double r100, double r101) {
        return new PointModel(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PointModel) == false) goto L10;
        PointModel r101 = (PointModel) r100;
        if (Double.compare(this.f245616px, r101.f245616px) == 0) goto L8;
        return false;
    L8:
        if (Double.compare(this.f245617py, r101.f245617py) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        long r100 = Double.doubleToLongBits(this.f245616px);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f245617py);
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public String toString() {
        return "PointModel(px=" + this.f245616px + ", py=" + this.f245617py + ")";
    }

    public final double getPx() {
        return this.f245616px;
    }

    public final double getPy() {
        return this.f245617py;
    }

    public PointModel(double r100, double r101) {
        this.f245616px = r100;
        this.f245617py = r101;
    }
}
