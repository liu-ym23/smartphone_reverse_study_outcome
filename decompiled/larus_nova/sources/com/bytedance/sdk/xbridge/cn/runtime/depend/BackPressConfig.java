package com.bytedance.sdk.xbridge.cn.runtime.depend;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/BackPressConfig;", "", "disableBackPress", "", "(Ljava/lang/Integer;)V", "getDisableBackPress", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/bytedance/sdk/xbridge/cn/runtime/depend/BackPressConfig;", "equals", "", "other", "hashCode", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class BackPressConfig {
    private final Integer disableBackPress;

    /* JADX WARN: Multi-variable type inference failed */
    public BackPressConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BackPressConfig copy$default(BackPressConfig r100, Integer r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.disableBackPress;
    L6:
        return r100.copy(r101);
    }

    public final Integer component1() {
        return this.disableBackPress;
    }

    public final BackPressConfig copy(Integer r100) {
        return new BackPressConfig(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BackPressConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.disableBackPress, ((BackPressConfig) r100).disableBackPress) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.disableBackPress;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "BackPressConfig(disableBackPress=" + this.disableBackPress + ')';
    }

    public final Integer getDisableBackPress() {
        return this.disableBackPress;
    }

    public BackPressConfig(Integer r100) {
        this.disableBackPress = r100;
    }

    public /* synthetic */ BackPressConfig(Integer r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
