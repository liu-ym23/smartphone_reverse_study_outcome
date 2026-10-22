package com.larus.dora.impl.network;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/larus/dora/impl/network/ActivityStatus;", "", "type", "", "isShow", "", "<init>", "(IZ)V", "getType", "()I", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_IS_SHOW)
    private final boolean isShow;

    @SerializedName("type")
    private final int type;

    /* JADX INFO: renamed from: com.larus.dora.impl.network.a$a, reason: collision with other inner class name */
    public static final class C4268a {
    }

    static {
    }

    public a() {
        this(0, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (this.isShow == r101.isShow) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.type * 31;
        if (this.isShow == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ActivityStatus(type=" + this.type + ", isShow=" + this.isShow + ')';
    }

    public final boolean a() {
        return this.isShow;
    }

    public final int getType() {
        return this.type;
    }

    public a(int r100, boolean r101) {
        this.type = r100;
        this.isShow = r101;
    }
}
