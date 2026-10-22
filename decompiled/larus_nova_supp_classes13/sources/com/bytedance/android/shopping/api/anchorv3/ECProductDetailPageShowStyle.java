package com.bytedance.android.shopping.api.anchorv3;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\n\"\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/api/anchorv3/ECProductDetailPageShowStyle;", "Ljava/io/Serializable;", "fullMode", "", "wrappedWithActivity", "showSkuPanel", "", "asyncInflate", "(ZZIZ)V", "getAsyncInflate", "()Z", "getFullMode", "setFullMode", "(Z)V", "getShowSkuPanel", "()I", "getWrappedWithActivity", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final class ECProductDetailPageShowStyle implements Serializable {
    private final boolean asyncInflate;
    private boolean fullMode;
    private final int showSkuPanel;
    private final boolean wrappedWithActivity;

    public ECProductDetailPageShowStyle() {
        this(false, false, 0, false, 15, null);
    }

    public final boolean getAsyncInflate() {
        return this.asyncInflate;
    }

    public final boolean getFullMode() {
        return this.fullMode;
    }

    public final int getShowSkuPanel() {
        return this.showSkuPanel;
    }

    public final boolean getWrappedWithActivity() {
        return this.wrappedWithActivity;
    }

    public final void setFullMode(boolean r1) {
        this.fullMode = r1;
    }

    public ECProductDetailPageShowStyle(boolean r1, boolean r2, int r3, boolean r4) {
        this.fullMode = r1;
        this.wrappedWithActivity = r2;
        this.showSkuPanel = r3;
        this.asyncInflate = r4;
    }

    public /* synthetic */ ECProductDetailPageShowStyle(boolean r2, boolean r3, int r4, boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = 0;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = true;
    L14:
        this(r2, r3, r4, r5);
    }
}
