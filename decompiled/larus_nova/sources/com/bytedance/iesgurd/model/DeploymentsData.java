package com.bytedance.iesgurd.model;

import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0081\b\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0013\u001a\u00020\u0004J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J \u0010\u0016\u001a\u00020\u00112\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R&\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/bytedance/iesgurd/model/DeploymentsData;", "", "groups", "", "", "channels", "(Ljava/util/List;Ljava/util/List;)V", "getChannels", "()Ljava/util/List;", "setChannels", "(Ljava/util/List;)V", "getGroups", "setGroups", "component1", "component2", "copy", "equals", "", "other", "getSortString", "hashCode", "", "isHit", "group", "channel", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final class DeploymentsData {

    @SerializedName("target_channels")
    private List<String> channels;

    @SerializedName("group_names")
    private List<String> groups;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeploymentsData copy$default(DeploymentsData r100, List r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.groups;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.channels;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<String> component1() {
        return this.groups;
    }

    public final List<String> component2() {
        return this.channels;
    }

    public final DeploymentsData copy(List<String> r100, List<String> r101) {
        return new DeploymentsData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof DeploymentsData) == false) goto L10;
        DeploymentsData r101 = (DeploymentsData) r100;
        if (Intrinsics.areEqual(this.groups, r101.groups) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.channels, r101.channels) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<String> r100 = this.groups;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.channels;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "DeploymentsData(groups=" + this.groups + ", channels=" + this.channels + ")";
    }

    public final String getSortString() {
        StringBuilder r100 = new StringBuilder();
        List<String> r101 = this.groups;
        if (r101 == null) goto L5;
        r100.append(CollectionsKt.sorted(r101).toString());
    L5:
        List<String> r102 = this.channels;
        if (r102 == null) goto L9;
        r100.append(CollectionsKt.sorted(r102).toString());
    L9:
        return r100.toString();
    }

    public final List<String> getChannels() {
        return this.channels;
    }

    public final List<String> getGroups() {
        return this.groups;
    }

    public final void setChannels(List<String> r100) {
        this.channels = r100;
    }

    public final void setGroups(List<String> r100) {
        this.groups = r100;
    }

    public DeploymentsData(List<String> r100, List<String> r101) {
        this.groups = r100;
        this.channels = r101;
    }

    public final boolean isHit(List<String> r100, String r101) {
        List<String> r102 = this.groups;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L19;
        List<String> r104 = this.channels;
        if (r104 != null) goto L13;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == false) goto L19;
    L18:
        return true;
    L13:
        if (r104.isEmpty() == true) goto L16;
        r105 = false;
    L19:
        if (r101 == null) goto L34;
        List<String> r106 = this.channels;
        if (r106 != null) goto L23;
    L26:
        boolean r107 = true;
    L27:
        if (r107 == true) goto L34;
        List<String> r108 = this.channels;
        if (r108 != null) goto L32;
        Intrinsics.throwNpe();
    L32:
        if (r108.contains(r101) == false) goto L34;
    L23:
        if (r106.isEmpty() == true) goto L26;
        r107 = false;
    L34:
        if (r100 == null) goto L66;
        List<String> r109 = this.groups;
        if (r109 != null) goto L38;
    L41:
        boolean r110 = true;
    L42:
        if (r110 == true) goto L67;
        List<String> r111 = this.groups;
        if (r111 != null) goto L46;
        Intrinsics.throwNpe();
    L46:
        Iterator<T> r112 = r111.iterator();
    L48:
        if (r112.hasNext() == false) goto L52;
        Object r113 = r112.next();
        if (r100.contains((String) r113) == false) goto L48;
    L53:
        CharSequence r114 = (CharSequence) r113;
        if (r114 != null) goto L56;
    L59:
        boolean r115 = true;
    L60:
        if (r115 == false) goto L18;
        return false;
    L56:
        if (r114.length() == 0) goto L59;
        r115 = false;
        goto L60
    L52:
        r113 = null;
        goto L53
    L67:
        return false;
    L38:
        if (r109.isEmpty() == true) goto L41;
        r110 = false;
        goto L42
    L66:
        return false;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }
}
