package com.bytedance.android.shopping.orderlist.common.freq;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\rHÆ\u0003J`\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020\u0007HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/freq/FreqFields;", "Ljava/io/Serializable;", "skipAppFrequency", "", "maxStoreNum", "", "freqLimitID", "", "freqLimitStrategy", "", "Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStrategy;", "freqScene", "freqServerStore", "Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStorage;", "(Ljava/lang/Boolean;ILjava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStorage;)V", "getFreqLimitID", "()Ljava/lang/String;", "getFreqLimitStrategy", "()Ljava/util/List;", "getFreqScene", "getFreqServerStore", "()Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStorage;", "getMaxStoreNum", "()I", "getSkipAppFrequency", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Boolean;ILjava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStorage;)Lcom/bytedance/android/shopping/orderlist/common/freq/FreqFields;", "equals", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FreqFields implements Serializable {

    @SerializedName("freq_limit_id")
    private final String freqLimitID;

    @SerializedName("freq_limit_strategy")
    private final List<FreqStrategy> freqLimitStrategy;

    @SerializedName("freq_scene")
    private final List<String> freqScene;

    @SerializedName("freq_server_store")
    private final FreqStorage freqServerStore;

    @SerializedName("max_store_num")
    private final int maxStoreNum;

    @SerializedName("skip_app_frequency")
    private final Boolean skipAppFrequency;

    public FreqFields() {
        this(null, 0, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FreqFields copy$default(FreqFields r4, Boolean r5, int r6, String r7, List r8, List r9, FreqStorage r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.skipAppFrequency;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.maxStoreNum;
    L8:
        int r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.freqLimitID;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.freqLimitStrategy;
    L14:
        List r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.freqScene;
    L17:
        List r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.freqServerStore;
    L20:
        Boolean r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final Boolean component1() {
        return this.skipAppFrequency;
    }

    public final int component2() {
        return this.maxStoreNum;
    }

    public final String component3() {
        return this.freqLimitID;
    }

    public final List<FreqStrategy> component4() {
        return this.freqLimitStrategy;
    }

    public final List<String> component5() {
        return this.freqScene;
    }

    public final FreqStorage component6() {
        return this.freqServerStore;
    }

    public final FreqFields copy(Boolean r9, int r10, String r11, List<FreqStrategy> r12, List<String> r13, FreqStorage r14) {
        return new FreqFields(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof FreqFields) == false) goto L18;
        FreqFields r4 = (FreqFields) r3;
        if (Intrinsics.areEqual(this.skipAppFrequency, r4.skipAppFrequency) == true) goto L8;
        return false;
    L8:
        if (this.maxStoreNum == r4.maxStoreNum) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.freqLimitID, r4.freqLimitID) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.freqLimitStrategy, r4.freqLimitStrategy) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.freqScene, r4.freqScene) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.freqServerStore, r4.freqServerStore) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        Boolean r0 = this.skipAppFrequency;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + this.maxStoreNum) * 31;
        String r4 = this.freqLimitID;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<FreqStrategy> r7 = this.freqLimitStrategy;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<String> r10 = this.freqScene;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        FreqStorage r13 = this.freqServerStore;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "FreqFields(skipAppFrequency=" + this.skipAppFrequency + ", maxStoreNum=" + this.maxStoreNum + ", freqLimitID=" + this.freqLimitID + ", freqLimitStrategy=" + this.freqLimitStrategy + ", freqScene=" + this.freqScene + ", freqServerStore=" + this.freqServerStore + ")";
    }

    public final String getFreqLimitID() {
        return this.freqLimitID;
    }

    public final List<FreqStrategy> getFreqLimitStrategy() {
        return this.freqLimitStrategy;
    }

    public final List<String> getFreqScene() {
        return this.freqScene;
    }

    public final FreqStorage getFreqServerStore() {
        return this.freqServerStore;
    }

    public final int getMaxStoreNum() {
        return this.maxStoreNum;
    }

    public final Boolean getSkipAppFrequency() {
        return this.skipAppFrequency;
    }

    public FreqFields(Boolean r1, int r2, String r3, List<FreqStrategy> r4, List<String> r5, FreqStorage r6) {
        this.skipAppFrequency = r1;
        this.maxStoreNum = r2;
        this.freqLimitID = r3;
        this.freqLimitStrategy = r4;
        this.freqScene = r5;
        this.freqServerStore = r6;
    }

    public /* synthetic */ FreqFields(Boolean r6, int r7, String r8, List r9, List r10, FreqStorage r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        Boolean r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        int r1 = 100;
    L11:
        if ((r12 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r12 & 8) == 0) goto L17;
        List r3 = null;
    L19:
        if ((r12 & 16) == 0) goto L21;
        List r4 = null;
    L23:
        if ((r12 & 32) == 0) goto L25;
        FreqStorage r15 = null;
    L26:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L25:
        r15 = r11;
        goto L26
    L21:
        r4 = r10;
        goto L23
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L7
    }
}
