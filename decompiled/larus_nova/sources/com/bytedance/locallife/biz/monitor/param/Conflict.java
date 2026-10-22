package com.bytedance.locallife.biz.monitor.param;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/locallife/biz/monitor/param/Conflict;", "", "key", "", "value1", "value2", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/String;", "getValue1", "()Ljava/lang/Object;", "getValue2", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class Conflict {
    private final String key;
    private final Object value1;
    private final Object value2;

    public static /* synthetic */ Conflict copy$default(Conflict r100, String r101, Object r102, Object r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.key;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.value1;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.value2;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.key;
    }

    public final Object component2() {
        return this.value1;
    }

    public final Object component3() {
        return this.value2;
    }

    public final Conflict copy(String r100, Object r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return new Conflict(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Conflict) == true) goto L8;
        return false;
    L8:
        Conflict r101 = (Conflict) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.value1, r101.value1) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.value2, r101.value2) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.key.hashCode() * 31;
        Object r101 = this.value1;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Object r105 = this.value2;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "Conflict(key=" + this.key + ", value1=" + this.value1 + ", value2=" + this.value2 + ')';
    }

    public final String getKey() {
        return this.key;
    }

    public final Object getValue1() {
        return this.value1;
    }

    public final Object getValue2() {
        return this.value2;
    }

    public Conflict(String r100, Object r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.key = r100;
        this.value1 = r101;
        this.value2 = r102;
    }
}
