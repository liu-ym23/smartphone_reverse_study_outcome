package com.bytedance.ee.bear.document.associateddocs.bean;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/document/associateddocs/bean/AssociatedUrlInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "pluginsInfo", "Lcom/bytedance/ee/bear/document/associateddocs/bean/AssociatedPluginsInfo;", "<init>", "(Lcom/bytedance/ee/bear/document/associateddocs/bean/AssociatedPluginsInfo;)V", "getPluginsInfo", "()Lcom/bytedance/ee/bear/document/associateddocs/bean/AssociatedPluginsInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssociatedUrlInfo implements NonProguard {

    @SerializedName("plugins_info")
    private final AssociatedPluginsInfo pluginsInfo;

    public static /* synthetic */ AssociatedUrlInfo copy$default(AssociatedUrlInfo r0, AssociatedPluginsInfo r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.pluginsInfo;
    L6:
        return r0.copy(r1);
    }

    public final AssociatedPluginsInfo component1() {
        return this.pluginsInfo;
    }

    public final AssociatedUrlInfo copy(AssociatedPluginsInfo r2) {
        return new AssociatedUrlInfo(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof AssociatedUrlInfo) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.pluginsInfo, ((AssociatedUrlInfo) r4).pluginsInfo) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        AssociatedPluginsInfo r0 = this.pluginsInfo;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "AssociatedUrlInfo(pluginsInfo=" + this.pluginsInfo + ')';
    }

    public final AssociatedPluginsInfo getPluginsInfo() {
        return this.pluginsInfo;
    }

    public AssociatedUrlInfo(AssociatedPluginsInfo r1) {
        this.pluginsInfo = r1;
    }
}
