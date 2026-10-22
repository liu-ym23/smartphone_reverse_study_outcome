package com.bytedance.timon_monitor_impl.settings;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007JH\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r`\u000e2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\"\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r`\u000eJ\b\u0010\u001a\u001a\u00020\fH\u0016R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR2\u0010\n\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/bytedance/timon_monitor_impl/settings/CustomSampleRateConfig;", "Ljava/io/Serializable;", "monitorNormal", "Lcom/google/gson/JsonObject;", "monitorError", "interceptError", "normalRate", "(Lcom/google/gson/JsonObject;Lcom/google/gson/JsonObject;Lcom/google/gson/JsonObject;Lcom/google/gson/JsonObject;)V", "getInterceptError", "()Lcom/google/gson/JsonObject;", "linesFormat", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getMonitorError", "getMonitorNormal", "getNormalRate", "parseLineFormat", "", "valueIndex", "", "jsonEntry", "", "Lcom/google/gson/JsonElement;", "toLineFormat", "toString", "timon-monitor-impl_release"}, k = 1, mv = {1, 1, 16})
public class CustomSampleRateConfig implements Serializable {

    @SerializedName("intercept_error")
    private final JsonObject interceptError;

    @Expose(deserialize = false, serialize = false)
    private HashMap<String, double[]> linesFormat;

    @SerializedName("monitor_error")
    private final JsonObject monitorError;

    @SerializedName("monitor_normal")
    private final JsonObject monitorNormal;

    @SerializedName("normal_rate")
    private final JsonObject normalRate;

    public CustomSampleRateConfig() {
        this(null, null, null, null, 15, null);
    }

    public final HashMap<String, double[]> toLineFormat() {
        HashMap<String, double[]> r100 = this.linesFormat;
        if (r100 == null) goto L7;
        if (r100 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return r100;
    L7:
        this.linesFormat = new HashMap();
        Iterator<T> r101 = this.monitorNormal.entrySet().iterator();
    L9:
        if (r101.hasNext() == false) goto L14;
        Map.Entry<String, JsonElement> r102 = (Map.Entry) r101.next();
        HashMap<String, double[]> r103 = this.linesFormat;
        if (r103 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        parseLineFormat(0, r103, r102);
        goto L9
    L14:
        Iterator<T> r104 = this.monitorError.entrySet().iterator();
    L16:
        if (r104.hasNext() == false) goto L21;
        Map.Entry<String, JsonElement> r105 = (Map.Entry) r104.next();
        HashMap<String, double[]> r106 = this.linesFormat;
        if (r106 != null) goto L20;
        Intrinsics.throwNpe();
    L20:
        parseLineFormat(1, r106, r105);
        goto L16
    L21:
        Iterator<T> r107 = this.interceptError.entrySet().iterator();
    L23:
        if (r107.hasNext() == false) goto L28;
        Map.Entry<String, JsonElement> r108 = (Map.Entry) r107.next();
        HashMap<String, double[]> r109 = this.linesFormat;
        if (r109 != null) goto L27;
        Intrinsics.throwNpe();
    L27:
        parseLineFormat(2, r109, r108);
        goto L23
    L28:
        Iterator<T> r110 = this.normalRate.entrySet().iterator();
    L30:
        if (r110.hasNext() == false) goto L35;
        Map.Entry<String, JsonElement> r111 = (Map.Entry) r110.next();
        HashMap<String, double[]> r112 = this.linesFormat;
        if (r112 != null) goto L34;
        Intrinsics.throwNpe();
    L34:
        parseLineFormat(3, r112, r111);
        goto L30
    L35:
        HashMap<String, double[]> r113 = this.linesFormat;
        if (r113 != null) goto L38;
        Intrinsics.throwNpe();
    L38:
        return r113;
    }

    public String toString() {
        return "CustomSampleRateConfig(monitorError='" + this.monitorError + "',interceptError='" + this.interceptError + "',normalRate='" + this.normalRate + "')";
    }

    public final JsonObject getInterceptError() {
        return this.interceptError;
    }

    public final JsonObject getMonitorError() {
        return this.monitorError;
    }

    public final JsonObject getMonitorNormal() {
        return this.monitorNormal;
    }

    public final JsonObject getNormalRate() {
        return this.normalRate;
    }

    private final void parseLineFormat(int r100, HashMap<String, double[]> r101, Map.Entry<String, JsonElement> r102) {
        double[] r103 = r101.get(r102.getKey());     // Catch: Exception -> L7
        if (r103 != null) goto L5;
        r103 = new double[10];     // Catch: Exception -> L7
    L5:
        r103[r100] = r102.getValue().getAsDouble();     // Catch: Exception -> L7
        r101.put(r102.getKey(), r103);     // Catch: Exception -> L7
        return;
    }

    public CustomSampleRateConfig(JsonObject r100, JsonObject r101, JsonObject r102, JsonObject r103) {
        this.monitorNormal = r100;
        this.monitorError = r101;
        this.interceptError = r102;
        this.normalRate = r103;
    }

    public /* synthetic */ CustomSampleRateConfig(JsonObject r100, JsonObject r101, JsonObject r102, JsonObject r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = new JsonObject();
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = new JsonObject();
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = new JsonObject();
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = new JsonObject();
    L14:
        this(r100, r101, r102, r103);
    }
}
