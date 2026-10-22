package com.larus.network;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012X\b\u0002\u0010\u0004\u001aR\u0012\u0004\u0012\u00020\u0006\u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\b\u0018\u00010\u0005j(\u0012\u0004\u0012\u00020\u0006\u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\b\u0018\u0001`\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJY\u0010\u0012\u001aR\u0012\u0004\u0012\u00020\u0006\u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\b\u0018\u00010\u0005j(\u0012\u0004\u0012\u00020\u0006\u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\b\u0018\u0001`\tHÆ\u0003Jt\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032X\b\u0002\u0010\u0004\u001aR\u0012\u0004\u0012\u00020\u0006\u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\b\u0018\u00010\u0005j(\u0012\u0004\u0012\u00020\u0006\u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\b\u0018\u0001`\tHÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rRf\u0010\u0004\u001aR\u0012\u0004\u0012\u00020\u0006\u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\b\u0018\u00010\u0005j(\u0012\u0004\u0012\u00020\u0006\u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\b\u0018\u0001`\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/larus/network/FlowAccessControlConfig;", "", "enable", "", "blockMap", "Ljava/util/HashMap;", "", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/lang/Boolean;Ljava/util/HashMap;)V", "getEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBlockMap", "()Ljava/util/HashMap;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/util/HashMap;)Lcom/larus/network/FlowAccessControlConfig;", "equals", "other", "hashCode", "", "toString", "ttnet_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class h {

    @SerializedName("block_map")
    private final HashMap<String, HashSet<String>> blockMap;

    @SerializedName("enable")
    private final Boolean enable;

    public h() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.enable, r101.enable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.blockMap, r101.blockMap) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.enable;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        HashMap<String, HashSet<String>> r104 = this.blockMap;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowAccessControlConfig(enable=" + this.enable + ", blockMap=" + this.blockMap + ')';
    }

    public final HashMap<String, HashSet<String>> a() {
        return this.blockMap;
    }

    public final Boolean b() {
        return this.enable;
    }

    public h(Object r100) {
        Boolean r101 = Boolean.TRUE;
        HashMap<String, HashSet<String>> r102 = new HashMap();
        this.enable = r101;
        this.blockMap = r102;
    }
}
