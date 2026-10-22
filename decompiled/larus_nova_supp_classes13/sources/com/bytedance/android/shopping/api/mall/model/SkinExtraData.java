package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0005J\u001a\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SkinExtraData;", "", "isDarkMode", "", "(Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/bytedance/android/shopping/api/mall/model/SkinExtraData;", "equals", "other", "hashCode", "", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkinExtraData {

    @SerializedName("is_dark_mode")
    private final Boolean isDarkMode;

    public SkinExtraData() {
        Boolean r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ SkinExtraData copy$default(SkinExtraData r0, Boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.isDarkMode;
    L6:
        return r0.copy(r1);
    }

    public final Boolean component1() {
        return this.isDarkMode;
    }

    public final SkinExtraData copy(Boolean r2) {
        return new SkinExtraData(r2);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof SkinExtraData) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.isDarkMode, ((SkinExtraData) r2).isDarkMode) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.isDarkMode;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "SkinExtraData(isDarkMode=" + this.isDarkMode + ")";
    }

    public final Boolean isDarkMode() {
        return this.isDarkMode;
    }

    public SkinExtraData(Boolean r1) {
        this.isDarkMode = r1;
    }

    public /* synthetic */ SkinExtraData(Boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
