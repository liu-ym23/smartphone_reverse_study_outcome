package com.larus.livetutor.api.idl;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/larus/livetutor/api/idl/FixedQueryTab;", "Ljava/io/Serializable;", "tabId", "", "tabName", "", "<init>", "(Ljava/lang/Long;Ljava/lang/String;)V", "getTabId", "()Ljava/lang/Long;", "setTabId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getTabName", "()Ljava/lang/String;", "setTabName", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/String;)Lcom/larus/livetutor/api/idl/FixedQueryTab;", "equals", "", "other", "", "hashCode", "", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FixedQueryTab implements Serializable {

    @SerializedName("tab_id")
    private Long tabId;

    @SerializedName(a.KEY_TAB_NAME)
    private String tabName;

    /* JADX WARN: Multi-variable type inference failed */
    public FixedQueryTab() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ FixedQueryTab copy$default(FixedQueryTab r100, Long r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.tabId;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.tabName;
    L9:
        return r100.copy(r101, r102);
    }

    public final Long component1() {
        return this.tabId;
    }

    public final String component2() {
        return this.tabName;
    }

    public final FixedQueryTab copy(Long r100, String r101) {
        return new FixedQueryTab(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FixedQueryTab) == true) goto L8;
        return false;
    L8:
        FixedQueryTab r101 = (FixedQueryTab) r100;
        if (Intrinsics.areEqual(this.tabId, r101.tabId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tabName, r101.tabName) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Long r100 = this.tabId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.tabName;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "FixedQueryTab(tabId=" + this.tabId + ", tabName=" + this.tabName + ')';
    }

    public final Long getTabId() {
        return this.tabId;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final void setTabId(Long r100) {
        this.tabId = r100;
    }

    public final void setTabName(String r100) {
        this.tabName = r100;
    }

    public FixedQueryTab(Long r100, String r101) {
        this.tabId = r100;
        this.tabName = r101;
    }

    public /* synthetic */ FixedQueryTab(Long r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
