package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/ObricSettingsListConfig;", "", "ObricSettingsWhiteList", "", "", "ObricSettingsBlackList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getObricSettingsWhiteList", "()Ljava/util/List;", "getObricSettingsBlackList", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSettingsListConfig {

    @SerializedName("obric_settings_black_list")
    private final List<String> ObricSettingsBlackList;

    @SerializedName("obric_settings_white_list")
    private final List<String> ObricSettingsWhiteList;

    /* JADX WARN: Multi-variable type inference failed */
    public ObricSettingsListConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricSettingsListConfig copy$default(ObricSettingsListConfig r100, List r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.ObricSettingsWhiteList;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.ObricSettingsBlackList;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<String> component1() {
        return this.ObricSettingsWhiteList;
    }

    public final List<String> component2() {
        return this.ObricSettingsBlackList;
    }

    public final ObricSettingsListConfig copy(List<String> r100, List<String> r101) {
        return new ObricSettingsListConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricSettingsListConfig) == true) goto L8;
        return false;
    L8:
        ObricSettingsListConfig r101 = (ObricSettingsListConfig) r100;
        if (Intrinsics.areEqual(this.ObricSettingsWhiteList, r101.ObricSettingsWhiteList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ObricSettingsBlackList, r101.ObricSettingsBlackList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<String> r100 = this.ObricSettingsWhiteList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.ObricSettingsBlackList;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricSettingsListConfig(ObricSettingsWhiteList=" + this.ObricSettingsWhiteList + ", ObricSettingsBlackList=" + this.ObricSettingsBlackList + ')';
    }

    public final List<String> getObricSettingsBlackList() {
        return this.ObricSettingsBlackList;
    }

    public final List<String> getObricSettingsWhiteList() {
        return this.ObricSettingsWhiteList;
    }

    public ObricSettingsListConfig(List<String> r100, List<String> r101) {
        this.ObricSettingsWhiteList = r100;
        this.ObricSettingsBlackList = r101;
    }

    public /* synthetic */ ObricSettingsListConfig(List r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
