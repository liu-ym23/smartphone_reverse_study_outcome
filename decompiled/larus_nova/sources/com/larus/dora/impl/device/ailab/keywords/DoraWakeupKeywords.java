package com.larus.dora.impl.device.ailab.keywords;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0013\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0003JF\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/larus/dora/impl/device/ailab/keywords/DoraWakeupKeywords;", "", "errCode", "", "sn", "", "ability", "Lcom/larus/dora/impl/device/ailab/keywords/DoraWakeupKeywordsAbility;", "wakeupKeywords", "", "Lcom/larus/dora/impl/device/ailab/keywords/DoraWakeupKeyword;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/dora/impl/device/ailab/keywords/DoraWakeupKeywordsAbility;Ljava/util/List;)V", "getErrCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSn", "()Ljava/lang/String;", "getAbility", "()Lcom/larus/dora/impl/device/ailab/keywords/DoraWakeupKeywordsAbility;", "getWakeupKeywords", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/dora/impl/device/ailab/keywords/DoraWakeupKeywordsAbility;Ljava/util/List;)Lcom/larus/dora/impl/device/ailab/keywords/DoraWakeupKeywords;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraWakeupKeywords {

    @SerializedName("abilities")
    private final DoraWakeupKeywordsAbility ability;

    @SerializedName("err_code")
    private final Integer errCode;

    /* JADX INFO: renamed from: sn, reason: collision with root package name */
    @SerializedName("device_sn")
    private final String f333549sn;

    @SerializedName("wakeup_keywords")
    private final List<DoraWakeupKeyword> wakeupKeywords;

    public DoraWakeupKeywords() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DoraWakeupKeywords copy$default(DoraWakeupKeywords r100, Integer r101, String r102, DoraWakeupKeywordsAbility r103, List r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.errCode;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.f333549sn;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.ability;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.wakeupKeywords;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Integer component1() {
        return this.errCode;
    }

    public final String component2() {
        return this.f333549sn;
    }

    public final DoraWakeupKeywordsAbility component3() {
        return this.ability;
    }

    public final List<DoraWakeupKeyword> component4() {
        return this.wakeupKeywords;
    }

    public final DoraWakeupKeywords copy(Integer r100, String r101, DoraWakeupKeywordsAbility r102, List<DoraWakeupKeyword> r103) {
        return new DoraWakeupKeywords(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DoraWakeupKeywords) == true) goto L8;
        return false;
    L8:
        DoraWakeupKeywords r101 = (DoraWakeupKeywords) r100;
        if (Intrinsics.areEqual(this.errCode, r101.errCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f333549sn, r101.f333549sn) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ability, r101.ability) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.wakeupKeywords, r101.wakeupKeywords) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.errCode;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f333549sn;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        DoraWakeupKeywordsAbility r107 = this.ability;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<DoraWakeupKeyword> r110 = this.wakeupKeywords;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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

    public String toString() {
        return "DoraWakeupKeywords(errCode=" + this.errCode + ", sn=" + this.f333549sn + ", ability=" + this.ability + ", wakeupKeywords=" + this.wakeupKeywords + ')';
    }

    public final DoraWakeupKeywordsAbility getAbility() {
        return this.ability;
    }

    public final Integer getErrCode() {
        return this.errCode;
    }

    public final String getSn() {
        return this.f333549sn;
    }

    public final List<DoraWakeupKeyword> getWakeupKeywords() {
        return this.wakeupKeywords;
    }

    public DoraWakeupKeywords(Integer r100, String r101, DoraWakeupKeywordsAbility r102, List<DoraWakeupKeyword> r103) {
        this.errCode = r100;
        this.f333549sn = r101;
        this.ability = r102;
        this.wakeupKeywords = r103;
    }

    public /* synthetic */ DoraWakeupKeywords(Integer r100, String r101, DoraWakeupKeywordsAbility r102, List r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
