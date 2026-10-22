package com.larus.home.impl.main.side_bar.data;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/larus/home/impl/main/side_bar/data/SideBarLayout;", "", "version", "", UserInfo.UPDATE_TIME, "", "components", "", "Lcom/larus/home/impl/main/side_bar/data/SideBarComponent;", "<init>", "(Ljava/lang/String;JLjava/util/List;)V", "getVersion", "()Ljava/lang/String;", "getUpdateTime", "()J", "getComponents", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k0 {

    @SerializedName("components")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<p> components;

    @SerializedName("update_time")
    private final long updateTime;

    @SerializedName("version")
    private final String version;

    public k0() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r101 = (k0) r100;
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L12;
        return false;
    L12:
        if (this.updateTime == r101.updateTime) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.components, r101.components) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.version;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        long r103 = this.updateTime;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        List<p> r105 = this.components;
        if (r105 == null) goto L11;
        r101 = r105.hashCode();
    L11:
        return r104 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SideBarLayout(version=" + this.version + ", updateTime=" + this.updateTime + ", components=" + this.components + ')';
    }

    public final List<p> b() {
        return this.components;
    }

    public final long c() {
        return this.updateTime;
    }

    public /* synthetic */ k0(List r100, int r101) {
        if ((r101 & 4) == 0) goto L5;
        r100 = null;
    L5:
        this(null, 0, r100);
    }

    public static k0 a(k0 r100, List r101) {
        String r102 = r100.version;
        long r103 = r100.updateTime;
        r100.getClass();
        return new k0(r102, r103, r101);
    }

    public k0(String r100, long r101, List<p> r102) {
        this.version = r100;
        this.updateTime = r101;
        this.components = r102;
    }
}
