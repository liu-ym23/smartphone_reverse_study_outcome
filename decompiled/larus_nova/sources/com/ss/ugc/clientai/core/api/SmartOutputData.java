package com.ss.ugc.clientai.core.api;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.alipay.sdk.m.u.i;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\n\b\u0016\u0018\u0000 52\u00020\u0001:\u00016B\u0011\u0012\b\b\u0002\u0010.\u001a\u00020-¢\u0006\u0004\b4\u00103J\u0006\u0010\u0003\u001a\u00020\u0002J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u00002\u0006\u0010\f\u001a\u00020\bJ\"\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0000\u0018\u0001`\u00102\u0006\u0010\u000e\u001a\u00020\bJ\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bJ\u0010\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\b\u0010\u0018\u001a\u00020\bH\u0016R$\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR0\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010)R2\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010 \u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$R\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00067"}, d2 = {"Lcom/ss/ugc/clientai/core/api/SmartOutputData;", "", "", "success", "", "labelScore", "()Ljava/lang/Float;", "", "", "outMap", "key", "getExtData", "taskName", "subTaskOutData", "groupName", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "subGroupTaskOutData", PickerReporterConstants.KEY.TARGET, "subGroupTaskTargetOutData", "Lorg/json/JSONObject;", "outputs", "", "mergeFrom", "toString", "label", "Ljava/lang/String;", "getLabel", "()Ljava/lang/String;", "setLabel", "(Ljava/lang/String;)V", "scoreMap", "Ljava/util/Map;", "getScoreMap", "()Ljava/util/Map;", "setScoreMap", "(Ljava/util/Map;)V", "value", "Ljava/lang/Float;", "getValue", "setValue", "(Ljava/lang/Float;)V", "extOutMap", "getExtOutMap", "setExtOutMap", "", "errorCode", "I", "getErrorCode", "()I", "setErrorCode", "(I)V", "<init>", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "core-api_release"}, k = 1, mv = {1, 4, 1})
public class SmartOutputData {
    public static final a Companion = null;
    private int errorCode;
    private Map<String, Object> extOutMap;
    private String label;
    private Map<String, Float> scoreMap;
    private Float value;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SmartOutputData() {
        int r100 = 0;
        this(r100, 1, null);
    }

    public final Float labelScore() {
        String r100 = this.label;
        if (r100 == null) goto L8;
        Map<String, Float> r101 = this.scoreMap;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    L8:
        return null;
    }

    public final Map<String, Object> outMap() {
        Map<String, Object> r100 = this.extOutMap;
        if (r100 == null) goto L5;
        return r100;
    L5:
        HashMap r101 = new HashMap();
        this.extOutMap = r101;
        return r101;
    }

    public final boolean success() {
        if (this.errorCode != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append("{success:" + success() + ", errorCode:" + this.errorCode);
        if (this.label == null) goto L6;
        r100.append(", label:" + this.label);
    L6:
        if (this.scoreMap == null) goto L9;
        r100.append(", scoreMap=" + this.scoreMap);
    L9:
        if (this.value == null) goto L12;
        r100.append(", value=" + this.value);
    L12:
        if (this.extOutMap == null) goto L14;
        r100.append(", extOutMap=" + this.extOutMap);
    L14:
        r100.append(i.f25855d);
        return r100.toString();
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final Map<String, Object> getExtOutMap() {
        return this.extOutMap;
    }

    public final String getLabel() {
        return this.label;
    }

    public final Map<String, Float> getScoreMap() {
        return this.scoreMap;
    }

    public final Float getValue() {
        return this.value;
    }

    public SmartOutputData(int r100) {
        this.errorCode = r100;
    }

    public final Object getExtData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Map<String, Object> r101 = this.extOutMap;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public final void mergeFrom(JSONObject r100) {
        if (r100 == null) goto L27;
        Object r101 = r100.opt("label");
        if ((r101 instanceof String) == false) goto L6;
        this.label = (String) r101;
    L6:
        Object r102 = r100.opt("score_map");
        if ((r102 instanceof JSONObject) == false) goto L13;
        HashMap r103 = new HashMap();
        JSONObject r104 = (JSONObject) r102;
        Iterator<String> r105 = r104.keys();
    L10:
        if (r105.hasNext() == false) goto L12;
        String r106 = r105.next();
        r103.put(r106, Float.valueOf((float) r104.optDouble(r106, AudioStats.AUDIO_AMPLITUDE_NONE)));
        goto L10
    L12:
        this.scoreMap = r103;
    L13:
        Object r107 = r100.opt("value");
        if ((r107 instanceof Number) == false) goto L16;
        this.value = Float.valueOf(((Number) r107).floatValue());
    L16:
        Object r108 = r100.opt("result");
        if ((r108 instanceof Number) == false) goto L19;
        this.value = Float.valueOf(((Number) r108).floatValue());
    L19:
        Object r109 = r100.opt("binaryValue");
        if ((r109 instanceof Number) == false) goto L22;
        this.value = Float.valueOf(((Number) r109).floatValue());
    L22:
        Map<String, Object> r110 = outMap();
        Iterator<String> r111 = r100.keys();
    L24:
        if (r111.hasNext() == false) goto L26;
        String r112 = r111.next();
        r110.put(r112, r100.opt(r112));
        goto L24
    L26:
        this.errorCode = 0;
        return;
    L27:
        this.errorCode = -5;
    }

    public final void setErrorCode(int r100) {
        this.errorCode = r100;
    }

    public final void setExtOutMap(Map<String, Object> r100) {
        this.extOutMap = r100;
    }

    public final void setLabel(String r100) {
        this.label = r100;
    }

    public final void setScoreMap(Map<String, Float> r100) {
        this.scoreMap = r100;
    }

    public final void setValue(Float r100) {
        this.value = r100;
    }

    public final ArrayList<SmartOutputData> subGroupTaskOutData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "groupName");
        Map<String, Object> r101 = this.extOutMap;
        if (r101 == null) goto L29;
        Iterator<Map.Entry<String, Object>> r102 = r101.entrySet().iterator();
        ArrayList<SmartOutputData> r103 = null;
    L6:
        if (r102.hasNext() == false) goto L21;
        Object r104 = r102.next().getValue();
        if ((r104 instanceof SmartOutputData) == true) goto L10;
        r104 = null;
    L10:
        SmartOutputData r105 = (SmartOutputData) r104;
        if (r105 == null) goto L6;
        Object r106 = r105.getExtData("group");
        if ((r106 instanceof String) == true) goto L16;
        r106 = null;
    L16:
        if (TextUtils.equals(r100, (String) r106) == false) goto L6;
        if (r103 != null) goto L19;
        r103 = new ArrayList();
    L19:
        r103.add(r105);
        goto L6
    L21:
        return r103;
    L29:
        return null;
    }

    public final SmartOutputData subTaskOutData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "taskName");
        Map<String, Object> r101 = this.extOutMap;
        Object r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.get(r100);
    L7:
        if ((r103 instanceof SmartOutputData) == false) goto L11;
        r102 = r103;
    L11:
        return (SmartOutputData) r102;
    L5:
        r103 = null;
        goto L7
    }

    public final SmartOutputData subGroupTaskTargetOutData(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "groupName");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        ArrayList<SmartOutputData> r102 = subGroupTaskOutData(r100);
        if (r102 == null) goto L13;
        Iterator<SmartOutputData> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L13;
        SmartOutputData r104 = r103.next();
        Object r105 = r104.getExtData(PickerReporterConstants.KEY.TARGET);
        if ((r105 instanceof String) == true) goto L11;
        r105 = null;
    L11:
        if (TextUtils.equals(r101, (String) r105) == false) goto L6;
        return r104;
    L13:
        return null;
    }

    public /* synthetic */ SmartOutputData(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = -999;
    L5:
        this(r100);
    }
}
