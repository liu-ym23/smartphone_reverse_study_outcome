package com.ss.bytertc.audio.device.hwearback.ovm;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import com.ss.bytertc.audio.device.base.ManufacturerChecker;
import com.ss.ttvideoengine.model.SubInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class DefaultHardwareParamsParser implements IHardwareParamsParser {
    public DefaultHardwareParamsParser() {
    }

    private int parseFlags(String r100) {
        String[] r101 = r100.split("\\|");
        int r102 = r101.length;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r102) goto L29;
        String r105 = r101[r103];
        r105.getClass();
        byte r106 = -1;
        switch(r105.hashCode()) {
            case -1849380614: goto L20;
            case -1126076303: goto L16;
            case -313407739: goto L12;
            case -311213931: goto L8;
            default: goto L23;
        };
    L23:
        switch(r106) {
            case 0: goto L27;
            case 1: goto L26;
            case 2: goto L27;
            case 3: goto L25;
            default: goto L28;
        };
    L25:
        r104 = r104 | 8;
        goto L28
    L26:
        r104 = r104 | 1;
        goto L28
    L27:
        r104 = r104 | 4;
    L28:
        r103 = r103 + 1;
        goto L3
    L8:
        if (r105.equals("AUDIO_OUTPUT_FLAG_DEEP_BUFFER") == false) goto L23;
        r106 = 3;
        goto L23
    L12:
        if (r105.equals("AUDIO_INPUT_FLAG_ROW") == false) goto L23;
        r106 = 2;
        goto L23
    L16:
        if (r105.equals("AUDIO_INPUT_FLAG_FAST") == false) goto L23;
        r106 = 1;
        goto L23
    L20:
        if (r105.equals("AUDIO_OUTPUT_FLAG_FAST") == false) goto L23;
        r106 = 0;
        goto L23
    L29:
        return r104;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.ovm.IHardwareParamsParser
    public HardwareEarbackParams parse(String r110) {
        JSONObject r100 = new JSONObject(r110);     // Catch: JSONException -> L40
        HardwareEarbackParams r101 = new HardwareEarbackParams();
        r101.playParamsList = new ArrayList();
        r101.recordParamsList = new ArrayList();
        if (r100.has("audioTrackParam") == false) goto L20;
        JSONArray r102 = JSONObjectProtectorUtils.getJSONArray(r100, "audioTrackParam");     // Catch: Exception -> L18
        int r103 = 0;
    L7:
        if (r103 >= r102.length()) goto L20;
        HardwareEarbackParams.Play r111 = new HardwareEarbackParams.Play();     // Catch: Exception -> L18
        JSONObject r104 = JSONArrayProtectorUtils.getJSONObject(r102, r103);     // Catch: Exception -> L18
        String r112 = JSONObjectProtectorUtils.getString(r104, "streamType");     // Catch: Exception -> L18
        String r113 = JSONObjectProtectorUtils.getString(r104, "sampleRate");     // Catch: Exception -> L18
        String r114 = JSONObjectProtectorUtils.getString(r104, SubInfo.KEY_FORMAT);     // Catch: Exception -> L18
        String r105 = JSONObjectProtectorUtils.getString(r104, ForwardDependency$ForwardLocation.FLAG);     // Catch: Exception -> L18
        r111.streamType = parseInt(r112, 3);     // Catch: Exception -> L18
        r111.sampleRate = parseInt(r113, 48000);     // Catch: Exception -> L18
        r111.format = parseInt(r114, 2);     // Catch: Exception -> L18
        r111.version = 0;     // Catch: Exception -> L18
        if (r105.contains(HiAnalyticsConstant.REPORT_VAL_SEPARATOR) == false) goto L13;
        r111.flags = parseFlags(r105);     // Catch: Exception -> L18
        r111.version = 1;     // Catch: Exception -> L18
    L16:
        r101.playParamsList.add(r111);     // Catch: Exception -> L18
        r103 = r103 + 1;
        goto L7
    L13:
        if (r105.startsWith("0x") == false) goto L15;
        r111.flags = CastIntegerProtector.parseInt(r105.substring(2), 16);     // Catch: Exception -> L18
        goto L16
    L15:
        r111.flags = parseInt(r105, -1);     // Catch: Exception -> L18
    L20:
        if (r100.has("audioRecordParam") == true) goto L43;
    L39:
        return r101;
    L43:
        JSONArray r106 = JSONObjectProtectorUtils.getJSONArray(r100, "audioRecordParam");     // Catch: Exception -> L42
        int r107 = 0;
    L22:
        if (r107 >= r106.length()) goto L39;
        HardwareEarbackParams.Record r108 = new HardwareEarbackParams.Record();     // Catch: Exception -> L42
        JSONObject r109 = JSONArrayProtectorUtils.getJSONObject(r106, r107);     // Catch: Exception -> L42
        String r115 = JSONObjectProtectorUtils.getString(r109, "sampleRate");     // Catch: Exception -> L42
        String r116 = JSONObjectProtectorUtils.getString(r109, SubInfo.KEY_FORMAT);     // Catch: Exception -> L42
        String r117 = JSONObjectProtectorUtils.getString(r109, ForwardDependency$ForwardLocation.FLAG);     // Catch: Exception -> L42
        String r118 = JSONObjectProtectorUtils.getString(r109, "source");     // Catch: Exception -> L42
        r108.sampleRate = parseInt(r115, 48000);     // Catch: Exception -> L42
        r108.format = parseInt(r116, 2);     // Catch: Exception -> L42
        r108.version = 0;     // Catch: Exception -> L42
        if (r117.contains(HiAnalyticsConstant.REPORT_VAL_SEPARATOR) == false) goto L28;
        r108.flags = parseFlags(r117);     // Catch: Exception -> L42
        r108.version = 1;     // Catch: Exception -> L42
        int r119 = 0;
    L37:
        r108.source = parseInt(r118, r119);     // Catch: Exception -> L42
        r101.recordParamsList.add(r108);     // Catch: Exception -> L42
        r107 = r107 + 1;
        goto L22
    L28:
        if (r117.startsWith("0x") == false) goto L32;
        r108.flags = CastIntegerProtector.parseInt(r117.substring(2), 16);     // Catch: Exception -> L42
    L30:
        r119 = 0;
        goto L37
    L32:
        if (ManufacturerChecker.getManufacturerType() == ManufacturerChecker.Type.OP) goto L34;
    L36:
        r108.flags = parseInt(r117, -1);     // Catch: Exception -> L42
        goto L30
    L34:
        if ("8".equals(r117) == false) goto L36;
        r108.flags = -1;     // Catch: Exception -> L42
    L40:
        return null;
    }

    private int parseInt(String r100, int r101) {
        if (r100.equals("default") == false) goto L6;
        return r101;
    L6:
        return CastIntegerProtector.parseInt(r100);
    }
}
