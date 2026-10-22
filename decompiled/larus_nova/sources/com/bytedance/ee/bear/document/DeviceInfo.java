package com.bytedance.ee.bear.document;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/document/DeviceInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "statusBarHeight", "", "titleBarHeight", "<init>", "(II)V", "getStatusBarHeight", "()I", "setStatusBarHeight", "(I)V", "getTitleBarHeight", "setTitleBarHeight", "toString", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceInfo implements NonProguard {
    private int statusBarHeight;
    private int titleBarHeight;

    public DeviceInfo() {
        int r100 = 0;
        this(r100, r100, 3, null);
    }

    public String toString() {
        return "DeviceInfo(statusBarHeight=" + this.statusBarHeight + ", titleBarHeight=" + this.titleBarHeight + ')';
    }

    public final int getStatusBarHeight() {
        return this.statusBarHeight;
    }

    public final int getTitleBarHeight() {
        return this.titleBarHeight;
    }

    public final void setStatusBarHeight(int r100) {
        this.statusBarHeight = r100;
    }

    public final void setTitleBarHeight(int r100) {
        this.titleBarHeight = r100;
    }

    public DeviceInfo(int r100, int r101) {
        this.statusBarHeight = r100;
        this.titleBarHeight = r101;
    }

    public /* synthetic */ DeviceInfo(int r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
