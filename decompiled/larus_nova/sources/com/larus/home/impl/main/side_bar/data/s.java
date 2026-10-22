package com.larus.home.impl.main.side_bar.data;

import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J:\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/larus/home/impl/main/side_bar/data/SideBarComponentMeta;", "", "id", "", "bizId", "", "isCollapsed", "", "isSticky", "<init>", "(Ljava/lang/String;Ljava/lang/Long;ZZ)V", "getId", "()Ljava/lang/String;", "getBizId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "()Z", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Long;ZZ)Lcom/larus/home/impl/main/side_bar/data/SideBarComponentMeta;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class s {

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID)
    private final Long bizId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f344535id;

    @SerializedName("is_collapsed")
    private final boolean isCollapsed;

    @SerializedName("is_sticky")
    private final boolean isSticky;

    public s() {
        this(null, null, false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f344535id, r101.f344535id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bizId, r101.bizId) == true) goto L15;
        return false;
    L15:
        if (this.isCollapsed == r101.isCollapsed) goto L18;
        return false;
    L18:
        if (this.isSticky == r101.isSticky) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f344535id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.bizId;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        int r106 = 1231;
        if (this.isCollapsed == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r105 + r107) * 31;
        if (this.isSticky == true) goto L19;
        r106 = 1237;
    L19:
        return r108 + r106;
    L13:
        r107 = 1237;
        goto L14
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SideBarComponentMeta(id=" + this.f344535id + ", bizId=" + this.bizId + ", isCollapsed=" + this.isCollapsed + ", isSticky=" + this.isSticky + ')';
    }

    public final Long a() {
        return this.bizId;
    }

    public final String b() {
        return this.f344535id;
    }

    public final boolean c() {
        return this.isCollapsed;
    }

    public final boolean d() {
        return this.isSticky;
    }

    public s(String r100, Long r101, boolean r102, boolean r103) {
        this.f344535id = r100;
        this.bizId = r101;
        this.isCollapsed = r102;
        this.isSticky = r103;
    }
}
