package com.bytedance.ee.bear.document;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/document/DeviceInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "statusBarHeight", "", "titleBarHeight", "<init>", "(II)V", "getStatusBarHeight", "()I", "setStatusBarHeight", "(I)V", "getTitleBarHeight", "setTitleBarHeight", "toString", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceInfo implements NonProguard {
    private int statusBarHeight;
    private int titleBarHeight;

    public DeviceInfo() {
        int r2 = 0;
        this(r2, r2, 3, null);
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

    public final void setStatusBarHeight(int r1) {
        this.statusBarHeight = r1;
    }

    public final void setTitleBarHeight(int r1) {
        this.titleBarHeight = r1;
    }

    public DeviceInfo(int r1, int r2) {
        this.statusBarHeight = r1;
        this.titleBarHeight = r2;
    }

    public /* synthetic */ DeviceInfo(int r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 0;
    L8:
        this(r2, r3);
    }
}
