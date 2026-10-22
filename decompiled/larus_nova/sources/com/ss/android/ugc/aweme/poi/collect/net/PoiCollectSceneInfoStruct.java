package com.ss.android.ugc.aweme.poi.collect.net;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/collect/net/PoiCollectSceneInfoStruct;", "Ljava/io/Serializable;", "statusCode", "", "taskCounter", "schema", "", "(IILjava/lang/String;)V", "getSchema", "()Ljava/lang/String;", "getStatusCode", "()I", "getTaskCounter", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiCollectSceneInfoStruct implements Serializable {

    @SerializedName("schema")
    private final String schema;

    @SerializedName("status_code")
    private final int statusCode;

    @SerializedName("pend_task_counter")
    private final int taskCounter;

    public PoiCollectSceneInfoStruct() {
        this(0, 0, null, 7, null);
    }

    public static /* synthetic */ PoiCollectSceneInfoStruct copy$default(PoiCollectSceneInfoStruct r100, int r101, int r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.statusCode;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.taskCounter;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.schema;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.statusCode;
    }

    public final int component2() {
        return this.taskCounter;
    }

    public final String component3() {
        return this.schema;
    }

    public final PoiCollectSceneInfoStruct copy(int r100, int r101, String r102) {
        return new PoiCollectSceneInfoStruct(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiCollectSceneInfoStruct) == true) goto L8;
        return false;
    L8:
        PoiCollectSceneInfoStruct r101 = (PoiCollectSceneInfoStruct) r100;
        if (this.statusCode == r101.statusCode) goto L12;
        return false;
    L12:
        if (this.taskCounter == r101.taskCounter) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.statusCode * 31) + this.taskCounter) * 31;
        String r101 = this.schema;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "PoiCollectSceneInfoStruct(statusCode=" + this.statusCode + ", taskCounter=" + this.taskCounter + ", schema=" + this.schema + ')';
    }

    public final String getSchema() {
        return this.schema;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final int getTaskCounter() {
        return this.taskCounter;
    }

    public PoiCollectSceneInfoStruct(int r100, int r101, String r102) {
        this.statusCode = r100;
        this.taskCounter = r101;
        this.schema = r102;
    }

    public /* synthetic */ PoiCollectSceneInfoStruct(int r100, int r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
