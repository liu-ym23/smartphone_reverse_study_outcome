package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/group/datasource/im/ListDevicesRequest;", "", "appIds", "", "", "<init>", "(Ljava/util/List;)V", "getAppIds", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ListDevicesRequest {

    @SerializedName("app_ids")
    private final List<Long> appIds;

    /* JADX WARN: Multi-variable type inference failed */
    public ListDevicesRequest() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ListDevicesRequest copy$default(ListDevicesRequest r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.appIds;
    L6:
        return r100.copy(r101);
    }

    public final List<Long> component1() {
        return this.appIds;
    }

    public final ListDevicesRequest copy(List<Long> r100) {
        return new ListDevicesRequest(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ListDevicesRequest) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.appIds, ((ListDevicesRequest) r100).appIds) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<Long> r100 = this.appIds;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "ListDevicesRequest(appIds=" + this.appIds + ')';
    }

    public final List<Long> getAppIds() {
        return this.appIds;
    }

    public ListDevicesRequest(List<Long> r100) {
        this.appIds = r100;
    }

    public /* synthetic */ ListDevicesRequest(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
