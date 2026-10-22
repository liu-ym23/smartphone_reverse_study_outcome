package com.bytedance.locallife.live.goodsshelves.bean;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/MiniCardExtra;", "Ljava/io/Serializable;", "app_id", "", "app_name", "(Ljava/lang/String;Ljava/lang/String;)V", "getApp_id", "()Ljava/lang/String;", "getApp_name", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class MiniCardExtra implements Serializable {
    private final String app_id;
    private final String app_name;

    /* JADX WARN: Multi-variable type inference failed */
    public MiniCardExtra() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ MiniCardExtra copy$default(MiniCardExtra r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.app_id;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.app_name;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.app_id;
    }

    public final String component2() {
        return this.app_name;
    }

    public final MiniCardExtra copy(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "app_id");
        Intrinsics.checkNotNullParameter(r101, "app_name");
        return new MiniCardExtra(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MiniCardExtra) == true) goto L8;
        return false;
    L8:
        MiniCardExtra r101 = (MiniCardExtra) r100;
        if (Intrinsics.areEqual(this.app_id, r101.app_id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.app_name, r101.app_name) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.app_id.hashCode() * 31) + this.app_name.hashCode();
    }

    public String toString() {
        return "MiniCardExtra(app_id=" + this.app_id + ", app_name=" + this.app_name + ')';
    }

    public final String getApp_id() {
        return this.app_id;
    }

    public final String getApp_name() {
        return this.app_name;
    }

    public MiniCardExtra(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "app_id");
        Intrinsics.checkNotNullParameter(r101, "app_name");
        this.app_id = r100;
        this.app_name = r101;
    }

    public /* synthetic */ MiniCardExtra(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}
