package com.bytedance.locallife.cube.mob;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006$"}, d2 = {"Lcom/bytedance/locallife/cube/mob/PoiLynxKitReportInfo;", "", "eventName", "", "url", "metrics", "Lorg/json/JSONObject;", "category", "enterFrom", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;)V", "getCategory", "()Lorg/json/JSONObject;", "setCategory", "(Lorg/json/JSONObject;)V", "getEnterFrom", "()Ljava/lang/String;", "setEnterFrom", "(Ljava/lang/String;)V", "getEventName", "setEventName", "getMetrics", "setMetrics", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "cube-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiLynxKitReportInfo {
    private JSONObject category;
    private String enterFrom;
    private String eventName;
    private JSONObject metrics;
    private String url;

    public PoiLynxKitReportInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ PoiLynxKitReportInfo copy$default(PoiLynxKitReportInfo r100, String r101, String r102, JSONObject r103, JSONObject r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.eventName;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.url;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.metrics;
    L11:
        JSONObject r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.category;
    L14:
        JSONObject r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.enterFrom;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.eventName;
    }

    public final String component2() {
        return this.url;
    }

    public final JSONObject component3() {
        return this.metrics;
    }

    public final JSONObject component4() {
        return this.category;
    }

    public final String component5() {
        return this.enterFrom;
    }

    public final PoiLynxKitReportInfo copy(String r100, String r101, JSONObject r110, JSONObject r111, String r112) {
        return new PoiLynxKitReportInfo(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiLynxKitReportInfo) == true) goto L8;
        return false;
    L8:
        PoiLynxKitReportInfo r101 = (PoiLynxKitReportInfo) r100;
        if (Intrinsics.areEqual(this.eventName, r101.eventName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.metrics, r101.metrics) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.category, r101.category) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.enterFrom, r101.enterFrom) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.eventName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.url;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        JSONObject r107 = this.metrics;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        JSONObject r110 = this.category;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.enterFrom;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PoiLynxKitReportInfo(eventName=" + this.eventName + ", url=" + this.url + ", metrics=" + this.metrics + ", category=" + this.category + ", enterFrom=" + this.enterFrom + ')';
    }

    public final JSONObject getCategory() {
        return this.category;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final JSONObject getMetrics() {
        return this.metrics;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setCategory(JSONObject r100) {
        this.category = r100;
    }

    public final void setEnterFrom(String r100) {
        this.enterFrom = r100;
    }

    public final void setEventName(String r100) {
        this.eventName = r100;
    }

    public final void setMetrics(JSONObject r100) {
        this.metrics = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }

    public PoiLynxKitReportInfo(String r100, String r101, JSONObject r102, JSONObject r103, String r104) {
        this.eventName = r100;
        this.url = r101;
        this.metrics = r102;
        this.category = r103;
        this.enterFrom = r104;
    }

    public /* synthetic */ PoiLynxKitReportInfo(String r100, String r101, JSONObject r102, JSONObject r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        JSONObject r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        JSONObject r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
