package com.bytedance.ee.bear.bitable.homepage.tabchoose;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/tabchoose/BitableTabData;", "Ljava/io/Serializable;", "tab", "Lcom/bytedance/ee/bear/bitable/homepage/tabchoose/BitableDefaultTabData;", "<init>", "(Lcom/bytedance/ee/bear/bitable/homepage/tabchoose/BitableDefaultTabData;)V", "getTab", "()Lcom/bytedance/ee/bear/bitable/homepage/tabchoose/BitableDefaultTabData;", "setTab", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableTabData implements Serializable {

    /* JADX INFO: renamed from: tab, reason: collision with root package name */
    @SerializedName("tab")
    private BitableDefaultTabData f213091tab;

    public static /* synthetic */ BitableTabData copy$default(BitableTabData r100, BitableDefaultTabData r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.f213091tab;
    L6:
        return r100.copy(r101);
    }

    public final BitableDefaultTabData component1() {
        return this.f213091tab;
    }

    public final BitableTabData copy(BitableDefaultTabData r100) {
        return new BitableTabData(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BitableTabData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f213091tab, ((BitableTabData) r100).f213091tab) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        BitableDefaultTabData r100 = this.f213091tab;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "BitableTabData(tab=" + this.f213091tab + ')';
    }

    public final BitableDefaultTabData getTab() {
        return this.f213091tab;
    }

    public BitableTabData(BitableDefaultTabData r100) {
        this.f213091tab = r100;
    }

    public final void setTab(BitableDefaultTabData r100) {
        this.f213091tab = r100;
    }
}
