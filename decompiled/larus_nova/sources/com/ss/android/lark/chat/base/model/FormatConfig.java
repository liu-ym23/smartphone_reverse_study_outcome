package com.ss.android.lark.chat.base.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/chat/base/model/FormatConfig;", "", "limitSize", "", "limitResolution", "Lcom/ss/android/lark/chat/base/model/ResolutionSize;", "<init>", "(JLcom/ss/android/lark/chat/base/model/ResolutionSize;)V", "getLimitSize", "()J", "getLimitResolution", "()Lcom/ss/android/lark/chat/base/model/ResolutionSize;", "getLimitResolutionSize", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "im-sdk-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FormatConfig {

    @SerializedName("limit_image_size")
    private final ResolutionSize limitResolution;

    @SerializedName("limit_file_size")
    private final long limitSize;

    public FormatConfig() {
        this(0, null, 3, null);
    }

    public static /* synthetic */ FormatConfig copy$default(FormatConfig r100, long r101, ResolutionSize r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.limitSize;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.limitResolution;
    L9:
        return r100.copy(r101, r102);
    }

    public final long component1() {
        return this.limitSize;
    }

    public final ResolutionSize component2() {
        return this.limitResolution;
    }

    public final FormatConfig copy(long r100, ResolutionSize r101) {
        Intrinsics.checkNotNullParameter(r101, "limitResolution");
        return new FormatConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FormatConfig) == true) goto L8;
        return false;
    L8:
        FormatConfig r101 = (FormatConfig) r100;
        if (this.limitSize == r101.limitSize) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.limitResolution, r101.limitResolution) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        long r100 = this.limitSize;
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.limitResolution.hashCode();
    }

    public String toString() {
        return "FormatConfig(limitSize=" + this.limitSize + ", limitResolution=" + this.limitResolution + ')';
    }

    public final long getLimitResolutionSize() {
        return this.limitResolution.getWidth() * this.limitResolution.getHeight();
    }

    public final ResolutionSize getLimitResolution() {
        return this.limitResolution;
    }

    public final long getLimitSize() {
        return this.limitSize;
    }

    public FormatConfig(long r100, ResolutionSize r101) {
        Intrinsics.checkNotNullParameter(r101, "limitResolution");
        this.limitSize = r100;
        this.limitResolution = r101;
    }

    public /* synthetic */ FormatConfig(long r100, ResolutionSize r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 26214400;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = new ResolutionSize(0, 0, 3, null);
    L8:
        this(r100, r101);
    }
}
