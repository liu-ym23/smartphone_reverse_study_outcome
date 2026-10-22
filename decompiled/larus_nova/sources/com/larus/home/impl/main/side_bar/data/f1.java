package com.larus.home.impl.main.side_bar.data;

import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0015\u001a\u00020\u0016J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J=\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\nHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/larus/home/impl/main/side_bar/data/UpdateSideBarOrderRequest;", "", "componentId", "", "components", "", "Lcom/larus/home/impl/main/side_bar/data/SideBarComponentMeta;", "lastUpdateTime", "", "sideBarViewVersion", "", "<init>", "(Ljava/lang/String;Ljava/util/List;JI)V", "getComponentId", "()Ljava/lang/String;", "getComponents", "()Ljava/util/List;", "getLastUpdateTime", "()J", "getSideBarViewVersion", "()I", "toJSONObject", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f1 {

    @SerializedName("component_id")
    private final String componentId;

    @SerializedName("components")
    private final List<s> components;

    @SerializedName("last_update_time")
    private final long lastUpdateTime;

    @SerializedName("sidebar_view_version")
    private final int sideBarViewVersion;

    public f1() {
        this(null, null, 0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f1) == true) goto L8;
        return false;
    L8:
        f1 r101 = (f1) r100;
        if (Intrinsics.areEqual(this.componentId, r101.componentId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.components, r101.components) == true) goto L15;
        return false;
    L15:
        if (this.lastUpdateTime == r101.lastUpdateTime) goto L18;
        return false;
    L18:
        if (this.sideBarViewVersion == r101.sideBarViewVersion) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.componentId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<s> r104 = this.components;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        long r106 = this.lastUpdateTime;
        return ((r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31) + this.sideBarViewVersion;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "UpdateSideBarOrderRequest(componentId=" + this.componentId + ", components=" + this.components + ", lastUpdateTime=" + this.lastUpdateTime + ", sideBarViewVersion=" + this.sideBarViewVersion + ')';
    }

    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.put("component_id", this.componentId);
        List<s> r101 = this.components;
        if (r101 != null) goto L5;
        r101 = CollectionsKt.emptyList();
    L5:
        List r102 = CollectionsKt.filterNotNull(r101);
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r104 = r102.iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        s r105 = (s) r104.next();
        JSONObject r106 = new JSONObject();
        r106.put("id", r105.b());
        r106.put(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, r105.a());
        r106.put("is_collapsed", r105.c());
        r106.put("is_sticky", r105.d());
        r103.add(r106);
        goto L7
    L9:
        r100.put("components", new JSONArray(r103));
        r100.put("last_update_time", this.lastUpdateTime);
        r100.put("sidebar_view_version", this.sideBarViewVersion);
        return r100;
    }

    public f1(String r100, List<s> r101, long r102, int r103) {
        this.componentId = r100;
        this.components = r101;
        this.lastUpdateTime = r102;
        this.sideBarViewVersion = r103;
    }
}
