package com.bytedance.locallife.groupon.struct;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/HalfCloseAction;", "", "closeAnimation", "Lcom/bytedance/locallife/groupon/struct/CloseAnimationConfig;", "refreshConfig", "Lcom/bytedance/locallife/groupon/struct/RefreshConfig;", "(Lcom/bytedance/locallife/groupon/struct/CloseAnimationConfig;Lcom/bytedance/locallife/groupon/struct/RefreshConfig;)V", "getCloseAnimation", "()Lcom/bytedance/locallife/groupon/struct/CloseAnimationConfig;", "getRefreshConfig", "()Lcom/bytedance/locallife/groupon/struct/RefreshConfig;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class HalfCloseAction {

    @SerializedName("close_animation")
    private final CloseAnimationConfig closeAnimation;

    @SerializedName("refresh_config")
    private final RefreshConfig refreshConfig;

    /* JADX WARN: Multi-variable type inference failed */
    public HalfCloseAction() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ HalfCloseAction copy$default(HalfCloseAction r100, CloseAnimationConfig r101, RefreshConfig r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.closeAnimation;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.refreshConfig;
    L9:
        return r100.copy(r101, r102);
    }

    public final CloseAnimationConfig component1() {
        return this.closeAnimation;
    }

    public final RefreshConfig component2() {
        return this.refreshConfig;
    }

    public final HalfCloseAction copy(CloseAnimationConfig r100, RefreshConfig r101) {
        return new HalfCloseAction(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof HalfCloseAction) == true) goto L8;
        return false;
    L8:
        HalfCloseAction r101 = (HalfCloseAction) r100;
        if (Intrinsics.areEqual(this.closeAnimation, r101.closeAnimation) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.refreshConfig, r101.refreshConfig) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        CloseAnimationConfig r100 = this.closeAnimation;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        RefreshConfig r104 = this.refreshConfig;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "HalfCloseAction(closeAnimation=" + this.closeAnimation + ", refreshConfig=" + this.refreshConfig + ')';
    }

    public final CloseAnimationConfig getCloseAnimation() {
        return this.closeAnimation;
    }

    public final RefreshConfig getRefreshConfig() {
        return this.refreshConfig;
    }

    public HalfCloseAction(CloseAnimationConfig r100, RefreshConfig r101) {
        this.closeAnimation = r100;
        this.refreshConfig = r101;
    }

    public /* synthetic */ HalfCloseAction(CloseAnimationConfig r100, RefreshConfig r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
