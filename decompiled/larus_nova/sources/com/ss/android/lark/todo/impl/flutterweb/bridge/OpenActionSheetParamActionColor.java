package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.ss.android.lark.diskmanage.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/bridge/OpenActionSheetParamActionColor;", "Lcom/ss/android/lark/diskmanage/NonProguard;", "alpha", "", "blue", "green", "red", "<init>", "(DDDD)V", "getAlpha", "()D", "getBlue", "getGreen", "getRed", "toString", "", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenActionSheetParamActionColor implements NonProguard {
    private final double alpha;
    private final double blue;
    private final double green;
    private final double red;

    public static /* synthetic */ OpenActionSheetParamActionColor copy$default(OpenActionSheetParamActionColor r100, double r110, double r111, double r112, double r113, int r114, Object r115) {
        if ((r114 & 1) == 0) goto L5;
        double r101 = r100.alpha;
    L7:
        if ((r114 & 2) == 0) goto L9;
        double r102 = r100.blue;
    L11:
        if ((r114 & 4) == 0) goto L13;
        double r103 = r100.green;
    L15:
        if ((r114 & 8) == 0) goto L17;
        double r104 = r100.red;
    L19:
        return r100.copy(r101, r102, r103, r104);
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final double component1() {
        return this.alpha;
    }

    public final double component2() {
        return this.blue;
    }

    public final double component3() {
        return this.green;
    }

    public final double component4() {
        return this.red;
    }

    public final OpenActionSheetParamActionColor copy(double r110, double r111, double r112, double r113) {
        return new OpenActionSheetParamActionColor(r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OpenActionSheetParamActionColor) == true) goto L8;
        return false;
    L8:
        OpenActionSheetParamActionColor r101 = (OpenActionSheetParamActionColor) r100;
        if (Double.compare(this.alpha, r101.alpha) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.blue, r101.blue) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.green, r101.green) == 0) goto L18;
        return false;
    L18:
        if (Double.compare(this.red, r101.red) == 0) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        long r100 = Double.doubleToLongBits(this.alpha);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.blue);
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = Double.doubleToLongBits(this.green);
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = Double.doubleToLongBits(this.red);
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    }

    public String toString() {
        return "OpenActionSheetParamActionColor(alpha='" + this.alpha + "', blue='" + this.blue + "', green='" + this.green + "', red='" + this.red + "')";
    }

    public final double getAlpha() {
        return this.alpha;
    }

    public final double getBlue() {
        return this.blue;
    }

    public final double getGreen() {
        return this.green;
    }

    public final double getRed() {
        return this.red;
    }

    public OpenActionSheetParamActionColor(double r100, double r101, double r102, double r103) {
        this.alpha = r100;
        this.blue = r101;
        this.green = r102;
        this.red = r103;
    }
}
