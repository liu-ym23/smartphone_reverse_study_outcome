package com.ss.android.lark.chameleon.api;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chameleon/api/WebViewPoolConfig;", "Ljava/io/Serializable;", "initialSize", "", "coreSize", "maxSize", "maxUseCount", "(IIII)V", "getCoreSize", "()I", "setCoreSize", "(I)V", "getInitialSize", "setInitialSize", "getMaxSize", "setMaxSize", "getMaxUseCount", "setMaxUseCount", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WebViewPoolConfig implements Serializable {
    private int coreSize;
    private int initialSize;
    private int maxSize;
    private int maxUseCount;

    public WebViewPoolConfig() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ WebViewPoolConfig copy$default(WebViewPoolConfig r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.initialSize;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.coreSize;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.maxSize;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.maxUseCount;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.initialSize;
    }

    public final int component2() {
        return this.coreSize;
    }

    public final int component3() {
        return this.maxSize;
    }

    public final int component4() {
        return this.maxUseCount;
    }

    public final WebViewPoolConfig copy(int r100, int r101, int r102, int r103) {
        return new WebViewPoolConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WebViewPoolConfig) == true) goto L8;
        return false;
    L8:
        WebViewPoolConfig r101 = (WebViewPoolConfig) r100;
        if (this.initialSize == r101.initialSize) goto L12;
        return false;
    L12:
        if (this.coreSize == r101.coreSize) goto L15;
        return false;
    L15:
        if (this.maxSize == r101.maxSize) goto L18;
        return false;
    L18:
        if (this.maxUseCount == r101.maxUseCount) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.initialSize * 31) + this.coreSize) * 31) + this.maxSize) * 31) + this.maxUseCount;
    }

    public String toString() {
        return "WebViewPoolConfig{initialSize=" + this.initialSize + ", coreSize=" + this.coreSize + ", maxSize=" + this.maxSize + ", maxUseCount=" + this.maxUseCount + '}';
    }

    public final int getCoreSize() {
        return this.coreSize;
    }

    public final int getInitialSize() {
        return this.initialSize;
    }

    public final int getMaxSize() {
        return this.maxSize;
    }

    public final int getMaxUseCount() {
        return this.maxUseCount;
    }

    public final void setCoreSize(int r100) {
        this.coreSize = r100;
    }

    public final void setInitialSize(int r100) {
        this.initialSize = r100;
    }

    public final void setMaxSize(int r100) {
        this.maxSize = r100;
    }

    public final void setMaxUseCount(int r100) {
        this.maxUseCount = r100;
    }

    public WebViewPoolConfig(int r100, int r101, int r102, int r103) {
        this.initialSize = r100;
        this.coreSize = r101;
        this.maxSize = r102;
        this.maxUseCount = r103;
    }

    public /* synthetic */ WebViewPoolConfig(int r100, int r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 1;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 1;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 1;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 100;
    L14:
        this(r100, r101, r102, r103);
    }
}
