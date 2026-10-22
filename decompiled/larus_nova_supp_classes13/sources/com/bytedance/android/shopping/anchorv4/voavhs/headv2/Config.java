package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/Config;", "Ljava/io/Serializable;", "enableMediaAsyncScroll", "", "enableSliceAsyncScroll", "(ZZ)V", "getEnableMediaAsyncScroll", "()Z", "getEnableSliceAsyncScroll", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Config implements Serializable {

    @SerializedName("enable_media_async_scroll")
    private final boolean enableMediaAsyncScroll;

    @SerializedName("enable_slice_async_scroll")
    private final boolean enableSliceAsyncScroll;

    public Config() {
        boolean r2 = false;
        this(r2, r2, 3, null);
    }

    public static /* synthetic */ Config copy$default(Config r0, boolean r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.enableMediaAsyncScroll;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.enableSliceAsyncScroll;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.enableMediaAsyncScroll;
    }

    public final boolean component2() {
        return this.enableSliceAsyncScroll;
    }

    public final Config copy(boolean r2, boolean r3) {
        return new Config(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof Config) == false) goto L10;
        Config r4 = (Config) r3;
        if (this.enableMediaAsyncScroll == r4.enableMediaAsyncScroll) goto L8;
        return false;
    L8:
        if (this.enableSliceAsyncScroll == r4.enableSliceAsyncScroll) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean r0 = this.enableMediaAsyncScroll;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.enableSliceAsyncScroll;
        if (r4 == true) goto L10;
        r1 = r4;
    L10:
        return r3 + r1;
    }

    public String toString() {
        return "Config(enableMediaAsyncScroll=" + this.enableMediaAsyncScroll + ", enableSliceAsyncScroll=" + this.enableSliceAsyncScroll + ")";
    }

    public final boolean getEnableMediaAsyncScroll() {
        return this.enableMediaAsyncScroll;
    }

    public final boolean getEnableSliceAsyncScroll() {
        return this.enableSliceAsyncScroll;
    }

    public Config(boolean r1, boolean r2) {
        this.enableMediaAsyncScroll = r1;
        this.enableSliceAsyncScroll = r2;
    }

    public /* synthetic */ Config(boolean r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = false;
    L8:
        this(r2, r3);
    }
}
