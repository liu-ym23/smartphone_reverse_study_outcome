package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/ProgressModel;", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/IFiledUIkitModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "progress", "", "color", "", "text", "<init>", "(DLjava/lang/String;Ljava/lang/String;)V", "getProgress", "()D", "getColor", "()Ljava/lang/String;", "getText", "isEmptyValue", "", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProgressModel implements h0, NonProguard {
    private final String color;
    private final double progress;
    private final String text;

    public static /* synthetic */ ProgressModel copy$default(ProgressModel r100, double r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.progress;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.color;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.text;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final double component1() {
        return this.progress;
    }

    public final String component2() {
        return this.color;
    }

    public final String component3() {
        return this.text;
    }

    public final ProgressModel copy(double r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "color");
        return new ProgressModel(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ProgressModel) == true) goto L8;
        return false;
    L8:
        ProgressModel r101 = (ProgressModel) r100;
        if (Double.compare(this.progress, r101.progress) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        long r100 = Double.doubleToLongBits(this.progress);
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.color.hashCode()) * 31;
        String r102 = this.text;
        if (r102 != null) goto L5;
        int r103 = 0;
    L7:
        return r101 + r103;
    L5:
        r103 = r102.hashCode();
        goto L7
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.h0
    public boolean isEmptyValue() {
        return false;
    }

    public String toString() {
        return "ProgressModel(progress=" + this.progress + ", color=" + this.color + ", text=" + this.text + ')';
    }

    public final String getColor() {
        return this.color;
    }

    public final double getProgress() {
        return this.progress;
    }

    public final String getText() {
        return this.text;
    }

    public ProgressModel(double r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "color");
        this.progress = r100;
        this.color = r101;
        this.text = r102;
    }
}
