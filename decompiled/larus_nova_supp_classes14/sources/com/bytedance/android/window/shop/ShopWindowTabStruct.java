package com.bytedance.android.window.shop;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/window/shop/ShopWindowTabStruct;", "Ljava/io/Serializable;", "type", "", "name", "", "pullShowMsg", "releaseShowMsg", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getPullShowMsg", "getReleaseShowMsg", "getType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopWindowTabStruct implements Serializable {
    private final String name;
    private final String pullShowMsg;
    private final String releaseShowMsg;
    private final int type;

    public static /* synthetic */ ShopWindowTabStruct copy$default(ShopWindowTabStruct r0, int r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.name;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.pullShowMsg;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.releaseShowMsg;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.pullShowMsg;
    }

    public final String component4() {
        return this.releaseShowMsg;
    }

    public final ShopWindowTabStruct copy(int r2, String r3, String r4, String r5) {
        return new ShopWindowTabStruct(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ShopWindowTabStruct) == false) goto L14;
        ShopWindowTabStruct r4 = (ShopWindowTabStruct) r3;
        if (this.type == r4.type) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r4.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.pullShowMsg, r4.pullShowMsg) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.releaseShowMsg, r4.releaseShowMsg) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.type * 31;
        String r1 = this.name;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.pullShowMsg;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.releaseShowMsg;
        if (r8 == null) goto L14;
        r2 = r8.hashCode();
    L14:
        return r7 + r2;
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public String toString() {
        return "ShopWindowTabStruct(type=" + this.type + ", name=" + this.name + ", pullShowMsg=" + this.pullShowMsg + ", releaseShowMsg=" + this.releaseShowMsg + ")";
    }

    public final String getName() {
        return this.name;
    }

    public final String getPullShowMsg() {
        return this.pullShowMsg;
    }

    public final String getReleaseShowMsg() {
        return this.releaseShowMsg;
    }

    public final int getType() {
        return this.type;
    }

    public ShopWindowTabStruct(int r1, String r2, String r3, String r4) {
        this.type = r1;
        this.name = r2;
        this.pullShowMsg = r3;
        this.releaseShowMsg = r4;
    }
}
