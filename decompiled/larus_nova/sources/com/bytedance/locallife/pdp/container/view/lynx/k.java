package com.bytedance.locallife.pdp.container.view.lynx;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/locallife/pdp/container/view/lynx/k;", "", "", "controlVisibilityByIndex", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "usingMergeApiForUpdateDataAndGlobalProps", "d", "", "threadStrategyForRendering", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "enableMultiAsyncThread", "b", "usingV2LynxView", "e", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class k {

    @SerializedName("controlVisibilityByIndex")
    private final Boolean controlVisibilityByIndex;

    @SerializedName("enableMultiAsyncThread")
    private final Boolean enableMultiAsyncThread;

    @SerializedName("threadStrategyForRendering")
    private final Integer threadStrategyForRendering;

    @SerializedName("usingMergeApiForUpdateDataAndGlobalProps")
    private final Boolean usingMergeApiForUpdateDataAndGlobalProps;

    @SerializedName("usingV2LynxView")
    private final Boolean usingV2LynxView;

    public k() {
        this(null, null, null, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.controlVisibilityByIndex, r101.controlVisibilityByIndex) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.usingMergeApiForUpdateDataAndGlobalProps, r101.usingMergeApiForUpdateDataAndGlobalProps) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.threadStrategyForRendering, r101.threadStrategyForRendering) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.enableMultiAsyncThread, r101.enableMultiAsyncThread) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.usingV2LynxView, r101.usingV2LynxView) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.controlVisibilityByIndex;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.usingMergeApiForUpdateDataAndGlobalProps;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.threadStrategyForRendering;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.enableMultiAsyncThread;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.usingV2LynxView;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LynxLoadConfig(controlVisibilityByIndex=" + this.controlVisibilityByIndex + ", usingMergeApiForUpdateDataAndGlobalProps=" + this.usingMergeApiForUpdateDataAndGlobalProps + ", threadStrategyForRendering=" + this.threadStrategyForRendering + ", enableMultiAsyncThread=" + this.enableMultiAsyncThread + ", usingV2LynxView=" + this.usingV2LynxView + ')';
    }

    public final Boolean a() {
        return this.controlVisibilityByIndex;
    }

    public final Boolean b() {
        return this.enableMultiAsyncThread;
    }

    public final Integer c() {
        return this.threadStrategyForRendering;
    }

    public final Boolean d() {
        return this.usingMergeApiForUpdateDataAndGlobalProps;
    }

    public final Boolean e() {
        return this.usingV2LynxView;
    }

    public /* synthetic */ k(Boolean r100, Boolean r101, Integer r102, Boolean r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        r100 = Boolean.FALSE;
    L5:
        Boolean r103 = r100;
        if ((r111 & 2) == 0) goto L8;
        r101 = Boolean.FALSE;
    L8:
        Boolean r104 = r101;
        if ((r111 & 4) == 0) goto L11;
        Integer r105 = null;
    L13:
        if ((r111 & 8) == 0) goto L15;
        r110 = Boolean.FALSE;
    L15:
        Boolean r106 = r110;
        if ((r111 & 16) == 0) goto L18;
        Boolean r107 = Boolean.FALSE;
    L19:
        this(r103, r104, r105, r106, r107);
        return;
    L18:
        r107 = null;
        goto L19
    L11:
        r105 = r102;
        goto L13
    }

    public k(Boolean r100, Boolean r101, Integer r102, Boolean r103, Boolean r104) {
        this.controlVisibilityByIndex = r100;
        this.usingMergeApiForUpdateDataAndGlobalProps = r101;
        this.threadStrategyForRendering = r102;
        this.enableMultiAsyncThread = r103;
        this.usingV2LynxView = r104;
    }
}
