package com.bytedance.mobsec.metasec.ml;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.ttm.player.MediaPlayer;
import java.util.Map;
import kotlin.io.encoding.Base64;
import ms.bd.c.k2;
import ms.bd.c.m2;
import ms.bd.c.p2;
import ms.bd.c.v2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class MSManager implements m2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m2 f265558a;

    @Override // ms.bd.c.m2
    public Map<String, String> frameSign(String r100, int r101) {
        return this.f265558a.frameSign(r100, r101);
    }

    @Override // ms.bd.c.m2
    public Map<String, String> getFeatureHash(String r100, byte[] r101) {
        return this.f265558a.getFeatureHash(r100, r101);
    }

    @Override // ms.bd.c.m2
    public Map<String, String> getReportRaw(String r100, int r101, Map<String, String> r102) {
        return this.f265558a.getReportRaw(r100, r101, r102);
    }

    @Override // ms.bd.c.m2
    public String getToken() {
        return this.f265558a.getToken();
    }

    @Override // ms.bd.c.m2
    public void postEventMessage(MSManagerUtils.MSBusinessHelper r100) {
        this.f265558a.postEventMessage(r100);
    }

    @Override // ms.bd.c.m2
    public void qurryMsRiskInfo(String r100, MSManagerUtils.IMsBundleCallback r101) {
        this.f265558a.qurryMsRiskInfo(r100, r101);
    }

    @Override // ms.bd.c.m2
    public void setBDDeviceID(String r100) {
        this.f265558a.setBDDeviceID(r100);
    }

    @Override // ms.bd.c.m2
    public void setCollectMode(int r100) {
        this.f265558a.setCollectMode(r100);
    }

    @Override // ms.bd.c.m2
    public void setCustomInfo(Map<String, String> r100, boolean r101) {
        this.f265558a.setCustomInfo(r100, r101);
    }

    @Override // ms.bd.c.m2
    public void setDeviceID(String r100) {
        this.f265558a.setDeviceID(r100);
    }

    @Override // ms.bd.c.m2
    public void setInstallID(String r100) {
        this.f265558a.setInstallID(r100);
    }

    @Override // ms.bd.c.m2
    public void setMsSettingConfig(String r100) {
        this.f265558a.setMsSettingConfig(r100);
    }

    @Override // ms.bd.c.m2
    public void setSessionID(String r100) {
        this.f265558a.setSessionID(r100);
    }

    public MSManager(k2 r100) {
        this.f265558a = r100;
    }

    public void report(String r100) {
        report(r100, "");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0096 -> B:17:0x0097). Please report as a decompilation issue!!! */
    @Override // ms.bd.c.m2
    public void report(String r210, String r211) {
        MSConfig.Builder.IMsSettingConfig r100 = v2.f515403b.f515405a;
        if (r100 != null) goto L5;
    L16:
        String r101 = null;
    L17:
        if (TextUtils.isEmpty(r101) == true) goto L20;
        this.f265558a.setMsSettingConfig(r101);
    L20:
        this.f265558a.report(r210, r211);
        return;
    L5:
        if (v2.f515404c == true) goto L16;
        v2.f515404c = true;     // Catch: Exception -> L22
        String r102 = r100.settingConfig();     // Catch: Exception -> L22
        if (TextUtils.isEmpty(r102) == true) goto L16;
        if (r102.trim().length() <= 3) goto L16;
        if (r102.contains((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "c7679e", new byte[]{113, 58, 75, 87, 3, 124, 116})) == false) goto L14;
        r101 = JSONObjectProtectorUtils.getString(new JSONObject(r102), (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "404e20", new byte[]{38, Base64.padSymbol, 73, 5, 8, 41, 35}));     // Catch: Exception -> L22
        goto L17
    L14:
        r101 = r102.trim();     // Catch: Exception -> L22
        goto L17
    }
}
