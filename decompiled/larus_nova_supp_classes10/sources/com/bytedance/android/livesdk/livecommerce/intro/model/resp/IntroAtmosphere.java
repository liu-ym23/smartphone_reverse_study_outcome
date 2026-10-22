package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.google.gson.annotations.SerializedName;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001cR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroAtmosphere;", "", "", "atmosphereType", "I", "a", "()I", "e", "(I)V", "", "enableRefresh", "Z", "c", "()Z", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroNumAtmosphere;", "numAtmosphere", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroNumAtmosphere;", "d", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroNumAtmosphere;", "g", "(Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroNumAtmosphere;)V", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/d;", "auctionAtmosphere", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/d;", "b", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/d;", "f", "(Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/d;)V", "Companion", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroAtmosphere {

    @SerializedName("atmosphere_type")
    private int atmosphereType;

    @SerializedName("auction_atmosphere")
    private d auctionAtmosphere;

    @SerializedName("enable_refresh")
    private final boolean enableRefresh;

    @SerializedName("num_atmosphere")
    private IntroNumAtmosphere numAtmosphere;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroAtmosphere$Companion$IntroAtmosphereType;", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface IntroAtmosphereType {
        }
    }

    static {
    }

    public IntroAtmosphere() {
        this(0, false, null, 15);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof IntroAtmosphere) == false) goto L14;
        IntroAtmosphere r4 = (IntroAtmosphere) r3;
        if (this.atmosphereType == r4.atmosphereType) goto L8;
        return false;
    L8:
        if (this.enableRefresh == r4.enableRefresh) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.numAtmosphere, r4.numAtmosphere) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.auctionAtmosphere, r4.auctionAtmosphere) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        int r0 = this.atmosphereType * 31;
        boolean r1 = this.enableRefresh;
        ?? r2 = r1;
        if (r1 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = (r0 + r2) * 31;
        IntroNumAtmosphere r4 = this.numAtmosphere;
        int r5 = 0;
        if (r4 == null) goto L8;
        int r6 = r4.hashCode();
    L9:
        int r7 = (r3 + r6) * 31;
        d r8 = this.auctionAtmosphere;
        if (r8 == null) goto L13;
        r5 = r8.hashCode();
    L13:
        return r7 + r5;
    L8:
        r6 = 0;
        goto L9
    }

    public final String toString() {
        return "IntroAtmosphere(atmosphereType=" + this.atmosphereType + ", enableRefresh=" + this.enableRefresh + ", numAtmosphere=" + this.numAtmosphere + ", auctionAtmosphere=" + this.auctionAtmosphere + ")";
    }

    public final int a() {
        return this.atmosphereType;
    }

    public final d b() {
        return this.auctionAtmosphere;
    }

    public final boolean c() {
        return this.enableRefresh;
    }

    public final IntroNumAtmosphere d() {
        return this.numAtmosphere;
    }

    public final void e(int r1) {
        this.atmosphereType = r1;
    }

    public final void f(d r1) {
        this.auctionAtmosphere = r1;
    }

    public final void g(IntroNumAtmosphere r1) {
        this.numAtmosphere = r1;
    }

    public IntroAtmosphere(int r3, boolean r4, d r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = null;
    L11:
        this.atmosphereType = r3;
        this.enableRefresh = r4;
        this.numAtmosphere = null;
        this.auctionAtmosphere = r5;
    }
}
