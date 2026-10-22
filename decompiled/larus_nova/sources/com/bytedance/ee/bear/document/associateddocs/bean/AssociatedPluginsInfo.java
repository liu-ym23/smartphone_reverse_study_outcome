package com.bytedance.ee.bear.document.associateddocs.bean;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/document/associateddocs/bean/AssociatedPluginsInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "ccmPlugin", "Lcom/bytedance/ee/bear/document/associateddocs/bean/AssociatedCcmPluginInfo;", "urlMetaId", "", "<init>", "(Lcom/bytedance/ee/bear/document/associateddocs/bean/AssociatedCcmPluginInfo;Ljava/lang/String;)V", "getCcmPlugin", "()Lcom/bytedance/ee/bear/document/associateddocs/bean/AssociatedCcmPluginInfo;", "getUrlMetaId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssociatedPluginsInfo implements NonProguard {

    @SerializedName("ccm_plugin")
    private final AssociatedCcmPluginInfo ccmPlugin;

    @SerializedName("url_meta_id")
    private final String urlMetaId;

    public static /* synthetic */ AssociatedPluginsInfo copy$default(AssociatedPluginsInfo r100, AssociatedCcmPluginInfo r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.ccmPlugin;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.urlMetaId;
    L9:
        return r100.copy(r101, r102);
    }

    public final AssociatedCcmPluginInfo component1() {
        return this.ccmPlugin;
    }

    public final String component2() {
        return this.urlMetaId;
    }

    public final AssociatedPluginsInfo copy(AssociatedCcmPluginInfo r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "urlMetaId");
        return new AssociatedPluginsInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AssociatedPluginsInfo) == true) goto L8;
        return false;
    L8:
        AssociatedPluginsInfo r101 = (AssociatedPluginsInfo) r100;
        if (Intrinsics.areEqual(this.ccmPlugin, r101.ccmPlugin) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.urlMetaId, r101.urlMetaId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        AssociatedCcmPluginInfo r100 = this.ccmPlugin;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.urlMetaId.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "AssociatedPluginsInfo(ccmPlugin=" + this.ccmPlugin + ", urlMetaId=" + this.urlMetaId + ')';
    }

    public final AssociatedCcmPluginInfo getCcmPlugin() {
        return this.ccmPlugin;
    }

    public final String getUrlMetaId() {
        return this.urlMetaId;
    }

    public AssociatedPluginsInfo(AssociatedCcmPluginInfo r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "urlMetaId");
        this.ccmPlugin = r100;
        this.urlMetaId = r101;
    }

    public /* synthetic */ AssociatedPluginsInfo(AssociatedCcmPluginInfo r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = "";
    L5:
        this(r100, r101);
    }
}
