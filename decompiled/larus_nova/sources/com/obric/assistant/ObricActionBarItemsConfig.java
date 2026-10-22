package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J.\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0002\u0010\tR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/ObricActionBarItemsConfig;", "", "isActionBarFilterEnable", "", "obricActionBarWhiteList", "", "Lcom/obric/assistant/ObricActionBarItem;", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getObricActionBarWhiteList", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/util/List;)Lcom/obric/assistant/ObricActionBarItemsConfig;", "equals", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricActionBarItemsConfig {

    @SerializedName("is_action_bar_filter_enable")
    private final Boolean isActionBarFilterEnable;

    @SerializedName("obric_action_bar_white_list")
    private final List<q0> obricActionBarWhiteList;

    /* JADX WARN: Multi-variable type inference failed */
    public ObricActionBarItemsConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricActionBarItemsConfig copy$default(ObricActionBarItemsConfig r100, Boolean r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.isActionBarFilterEnable;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.obricActionBarWhiteList;
    L9:
        return r100.copy(r101, r102);
    }

    public final Boolean component1() {
        return this.isActionBarFilterEnable;
    }

    public final List<q0> component2() {
        return this.obricActionBarWhiteList;
    }

    public final ObricActionBarItemsConfig copy(Boolean r100, List<q0> r101) {
        return new ObricActionBarItemsConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricActionBarItemsConfig) == true) goto L8;
        return false;
    L8:
        ObricActionBarItemsConfig r101 = (ObricActionBarItemsConfig) r100;
        if (Intrinsics.areEqual(this.isActionBarFilterEnable, r101.isActionBarFilterEnable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.obricActionBarWhiteList, r101.obricActionBarWhiteList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.isActionBarFilterEnable;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<q0> r104 = this.obricActionBarWhiteList;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricActionBarItemsConfig(isActionBarFilterEnable=" + this.isActionBarFilterEnable + ", obricActionBarWhiteList=" + this.obricActionBarWhiteList + ')';
    }

    public final List<q0> getObricActionBarWhiteList() {
        return this.obricActionBarWhiteList;
    }

    public final Boolean isActionBarFilterEnable() {
        return this.isActionBarFilterEnable;
    }

    public ObricActionBarItemsConfig(Boolean r100, List<q0> r101) {
        this.isActionBarFilterEnable = r100;
        this.obricActionBarWhiteList = r101;
    }

    public /* synthetic */ ObricActionBarItemsConfig(Boolean r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
