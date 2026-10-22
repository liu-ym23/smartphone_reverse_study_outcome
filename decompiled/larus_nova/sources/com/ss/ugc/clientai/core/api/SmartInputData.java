package com.ss.ugc.clientai.core.api;

import com.alipay.sdk.m.u.i;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\n\b\u0016\u0018\u0000 <2\u00020\u0001:\u0001=B\u0011\u0012\b\b\u0002\u00105\u001a\u000204¢\u0006\u0004\b;\u0010:J\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002J\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0016R$\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R2\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR2\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/ss/ugc/clientai/core/api/SmartInputData;", "", "", "", "inputMap", "importantMap", "toString", "runKey", "Ljava/lang/String;", "getRunKey", "()Ljava/lang/String;", "setRunKey", "(Ljava/lang/String;)V", "enterType", "getEnterType", "setEnterType", "", "forTrack", "Z", "getForTrack", "()Z", "setForTrack", "(Z)V", "inputFeaturesMap", "Ljava/util/Map;", "getInputFeaturesMap", "()Ljava/util/Map;", "setInputFeaturesMap", "(Ljava/util/Map;)V", "importantExtFeaturesMap", "getImportantExtFeaturesMap", "setImportantExtFeaturesMap", "", "inputFloatArray", "[F", "getInputFloatArray", "()[F", "setInputFloatArray", "([F)V", "", "inputByteArray", "[B", "getInputByteArray", "()[B", "setInputByteArray", "([B)V", "inputExtObj", "Ljava/lang/Object;", "getInputExtObj", "()Ljava/lang/Object;", "setInputExtObj", "(Ljava/lang/Object;)V", "", "capacity", "I", "getCapacity", "()I", "setCapacity", "(I)V", "<init>", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "core-api_release"}, k = 1, mv = {1, 4, 1})
public class SmartInputData {
    public static final a Companion = null;
    private int capacity;
    private String enterType;
    private boolean forTrack;
    private Map<String, Object> importantExtFeaturesMap;
    private byte[] inputByteArray;
    private Object inputExtObj;
    private Map<String, Object> inputFeaturesMap;
    private float[] inputFloatArray;
    private String runKey;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SmartInputData() {
        int r100 = 0;
        this(r100, 1, null);
    }

    public final Map<String, Object> importantMap() {
        Map<String, Object> r100 = this.importantExtFeaturesMap;
        if (r100 == null) goto L5;
        return r100;
    L5:
        HashMap r101 = new HashMap();
        this.importantExtFeaturesMap = r101;
        return r101;
    }

    public final Map<String, Object> inputMap() {
        Map<String, Object> r100 = this.inputFeaturesMap;
        if (r100 == null) goto L5;
        return r100;
    L5:
        HashMap r101 = new HashMap(this.capacity);
        this.inputFeaturesMap = r101;
        return r101;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("{");
        if (this.runKey == null) goto L6;
        r100.append("runKey:" + this.runKey);
    L6:
        if (this.enterType == null) goto L8;
        r100.append(", enterType:" + this.enterType + '}');
    L8:
        String r101 = null;
        if (this.inputFloatArray == null) goto L16;
        StringBuilder r102 = new StringBuilder(", inputFloatArray.size:");
        float[] r103 = this.inputFloatArray;
        if (r103 == null) goto L13;
        Integer r104 = Integer.valueOf(r103.length);
    L14:
        r102.append(r104);
        r100.append(r102.toString());
        goto L16
    L13:
        r104 = null;
    L16:
        if (this.inputByteArray == null) goto L23;
        StringBuilder r105 = new StringBuilder(", inputByteArray.size:");
        byte[] r106 = this.inputByteArray;
        if (r106 == null) goto L20;
        Integer r107 = Integer.valueOf(r106.length);
    L21:
        r105.append(r107);
        r100.append(r105.toString());
        goto L23
    L20:
        r107 = null;
    L23:
        if (this.inputExtObj == null) goto L28;
        StringBuilder r108 = new StringBuilder(", inputExtObj:");
        Object r109 = this.inputExtObj;
        if (r109 == null) goto L27;
        r101 = r109.getClass().getSimpleName();
    L27:
        r108.append(r101);
        r100.append(r108.toString());
    L28:
        int r110 = 0;
        if (this.importantExtFeaturesMap == null) goto L36;
        StringBuilder r111 = new StringBuilder(", importantExtFeaturesMap:");
        Map<String, Object> r112 = this.importantExtFeaturesMap;
        if (r112 == null) goto L33;
        int r113 = r112.size();
    L34:
        r111.append(r113);
        r111.append('-');
        r111.append(this.importantExtFeaturesMap);
        r100.append(r111.toString());
        goto L36
    L33:
        r113 = 0;
    L36:
        if (this.inputFeaturesMap == null) goto L41;
        StringBuilder r114 = new StringBuilder(", inputFeaturesMap:");
        Map<String, Object> r115 = this.inputFeaturesMap;
        if (r115 == null) goto L40;
        r110 = r115.size();
    L40:
        r114.append(r110);
        r114.append('-');
        r114.append(this.inputFeaturesMap);
        r100.append(r114.toString());
    L41:
        r100.append(i.f25855d);
        return r100.toString();
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public final String getEnterType() {
        return this.enterType;
    }

    public final boolean getForTrack() {
        return this.forTrack;
    }

    public final Map<String, Object> getImportantExtFeaturesMap() {
        return this.importantExtFeaturesMap;
    }

    public final byte[] getInputByteArray() {
        return this.inputByteArray;
    }

    public final Object getInputExtObj() {
        return this.inputExtObj;
    }

    public final Map<String, Object> getInputFeaturesMap() {
        return this.inputFeaturesMap;
    }

    public final float[] getInputFloatArray() {
        return this.inputFloatArray;
    }

    public final String getRunKey() {
        return this.runKey;
    }

    public SmartInputData(int r100) {
        this.capacity = r100;
    }

    public final void setCapacity(int r100) {
        this.capacity = r100;
    }

    public final void setEnterType(String r100) {
        this.enterType = r100;
    }

    public final void setForTrack(boolean r100) {
        this.forTrack = r100;
    }

    public final void setImportantExtFeaturesMap(Map<String, Object> r100) {
        this.importantExtFeaturesMap = r100;
    }

    public final void setInputByteArray(byte[] r100) {
        this.inputByteArray = r100;
    }

    public final void setInputExtObj(Object r100) {
        this.inputExtObj = r100;
    }

    public final void setInputFeaturesMap(Map<String, Object> r100) {
        this.inputFeaturesMap = r100;
    }

    public final void setInputFloatArray(float[] r100) {
        this.inputFloatArray = r100;
    }

    public final void setRunKey(String r100) {
        this.runKey = r100;
    }

    public /* synthetic */ SmartInputData(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 128;
    L5:
        this(r100);
    }
}
