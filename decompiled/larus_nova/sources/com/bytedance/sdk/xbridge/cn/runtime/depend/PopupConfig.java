package com.bytedance.sdk.xbridge.cn.runtime.depend;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ2\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/PopupConfig;", "", "disableMaskClickClose", "", "enablePullDownClose", "enableInterceptTouchEvent", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getDisableMaskClickClose", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEnableInterceptTouchEvent", "getEnablePullDownClose", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/sdk/xbridge/cn/runtime/depend/PopupConfig;", "equals", "", "other", "hashCode", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PopupConfig {
    private final Integer disableMaskClickClose;
    private final Integer enableInterceptTouchEvent;
    private final Integer enablePullDownClose;

    public PopupConfig() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PopupConfig copy$default(PopupConfig r100, Integer r101, Integer r102, Integer r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.disableMaskClickClose;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.enablePullDownClose;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.enableInterceptTouchEvent;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Integer component1() {
        return this.disableMaskClickClose;
    }

    public final Integer component2() {
        return this.enablePullDownClose;
    }

    public final Integer component3() {
        return this.enableInterceptTouchEvent;
    }

    public final PopupConfig copy(Integer r100, Integer r101, Integer r102) {
        return new PopupConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PopupConfig) == true) goto L8;
        return false;
    L8:
        PopupConfig r101 = (PopupConfig) r100;
        if (Intrinsics.areEqual(this.disableMaskClickClose, r101.disableMaskClickClose) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enablePullDownClose, r101.enablePullDownClose) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.enableInterceptTouchEvent, r101.enableInterceptTouchEvent) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.disableMaskClickClose;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.enablePullDownClose;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.enableInterceptTouchEvent;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PopupConfig(disableMaskClickClose=" + this.disableMaskClickClose + ", enablePullDownClose=" + this.enablePullDownClose + ", enableInterceptTouchEvent=" + this.enableInterceptTouchEvent + ')';
    }

    public final Integer getDisableMaskClickClose() {
        return this.disableMaskClickClose;
    }

    public final Integer getEnableInterceptTouchEvent() {
        return this.enableInterceptTouchEvent;
    }

    public final Integer getEnablePullDownClose() {
        return this.enablePullDownClose;
    }

    public PopupConfig(Integer r100, Integer r101, Integer r102) {
        this.disableMaskClickClose = r100;
        this.enablePullDownClose = r101;
        this.enableInterceptTouchEvent = r102;
    }

    public /* synthetic */ PopupConfig(Integer r100, Integer r101, Integer r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
