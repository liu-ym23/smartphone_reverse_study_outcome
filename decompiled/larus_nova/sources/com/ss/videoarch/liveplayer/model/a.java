package com.ss.videoarch.liveplayer.model;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c[] f459546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LiveStreamInfo f459547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String[] f459548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f459549d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f459550e;

    public a() {
    }

    public void reset() {
        this.f459550e = 0;
        this.f459548c = null;
        this.f459547b = null;
        this.f459546a = null;
    }

    public JSONObject getAbrInfo() {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.getAbrInfo();
    L9:
        return null;
    }

    public String getAppId() {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.E;
    L9:
        return null;
    }

    public String getBusinessType() {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.I;
    L9:
        return null;
    }

    public String getCommonNeptuneTrace() {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.H;
    L9:
        return null;
    }

    public String getDefaultResolution() {
        if (this.f459549d == 2) goto L5;
        return null;
    L5:
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L9;
        return null;
    L9:
        return r100.getDefaultResolution();
    }

    public String getDrmSecretKey() {
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getDrmSecretKey();
    }

    public String getFastFirstFrameProtocol() {
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L7;
        com.ss.videoarch.liveplayer.log.c.i("LiveIonfo", "stream data is null");
        return "h2q";
    L7:
        return r100.getFastFirstFrameProtocol();
    }

    public Map<String, String> getHTTPHeaders() {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.getHTTPHeaders();
    L9:
        return null;
    }

    public int getIsColdStart() {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L8;
        return -1;
    L8:
        return r100.L;
    L9:
        return -1;
    }

    public int getIsHorizontalScreen() {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L8;
        return -1;
    L8:
        return r100.isHorizontalScreen();
    L9:
        return -1;
    }

    public HashMap<String, String> getLineMap() {
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLineMap();
    }

    public String getMajorAnchorLevel() {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.f459463J;
    L9:
        return null;
    }

    public long getMpdUrlCost() {
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L5;
        return -1;
    L5:
        return r100.getMpdUrlCost();
    }

    public String getNextURL() {
        this.f459550e++;
        return getPlayURL();
    }

    public JSONObject getP2pParams() {
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getP2pParams();
    }

    public c getPlayLiveURL() {
        c[] r100 = this.f459546a;
        if (r100 != null) goto L5;
    L13:
        return null;
    L5:
        if (r100.length == 0) goto L13;
        int r101 = r100.length;
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L13;
        c r103 = r100[r102];
        if (r103.f459554a != null) goto L11;
        r102 = r102 + 1;
        goto L8
    L11:
        return r103;
    }

    public String getPlayURL() {
        String[] r100 = this.f459548c;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.length == 0) goto L15;
        int r101 = this.f459550e;
        if (r101 < r100.length) goto L12;
        r101 = 0;
    L12:
        return r100[r101];
    L15:
        return null;
    }

    public JSONObject getPreNodeSelection() {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.K;
    L9:
        return null;
    }

    public String getRuleIds() {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.getRuleIds();
    L9:
        return null;
    }

    public JSONObject getSceneTags() {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.M;
    L9:
        return null;
    }

    public String getSessionID() {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.getSessionID();
    L9:
        return null;
    }

    public long getSessionTimestamp() {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L8;
        return 0;
    L8:
        return r100.getSessionTimestamp();
    L9:
        return 0;
    }

    public String getStreamId() {
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getStreamId();
    }

    public LiveStreamInfo getStreamInfo() {
        if (this.f459549d != 2) goto L8;
        LiveStreamInfo r100 = this.f459547b;
        if (r100 == null) goto L10;
        return r100;
    L10:
        return null;
    L8:
        return null;
    }

    public String getStreamMode() {
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getStreamMode();
    }

    public String getStreamName() {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.getStreamName();
    L9:
        return null;
    }

    public long getStreamVersion() {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L8;
        return -1;
    L8:
        return r100.getStreamVersion();
    L9:
        return -1;
    }

    public JSONObject getTemplateJson() {
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTemplateJson();
    }

    public boolean isDisableQuicOnFaultFormat() {
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L7;
        com.ss.videoarch.liveplayer.log.c.i("LiveIonfo", "stream data is null");
        return false;
    L7:
        if (r100.isEnableQuicDegradeInFaultFormat() != 1) goto L10;
        return true;
    L10:
        return false;
    }

    public boolean isDisableQuicOnFreeFlow() {
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L7;
        com.ss.videoarch.liveplayer.log.c.i("LiveIonfo", "stream data is null");
        return false;
    L7:
        if (r100.isDisableQuicOnFreeFlow() != 1) goto L10;
        return true;
    L10:
        return false;
    }

    public boolean isDisableQuicOnNonPreview() {
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L7;
        com.ss.videoarch.liveplayer.log.c.i("LiveIonfo", "stream data is null");
        return false;
    L7:
        if (r100.isEnableQuicDegradeInNonPreivew() != 1) goto L10;
        return true;
    L10:
        return false;
    }

    public boolean isDrmLive() {
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isDrmLive();
    }

    public boolean isEnableBMFSharpen() {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L8;
        return false;
    L8:
        return r100.isEnableBMFSharpen();
    L9:
        return false;
    }

    public boolean isEnableLSSSuggestProtocol() {
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L7;
        com.ss.videoarch.liveplayer.log.c.i("LiveIonfo", "stream data is null");
        return false;
    L7:
        if (r100.isEnableLSSSuggestProtocol() != 1) goto L10;
        return true;
    L10:
        return false;
    }

    public boolean isEnablePanoBMFSharpen() {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L8;
        return false;
    L8:
        return r100.isEnablePanoBMFSharpen();
    L9:
        return false;
    }

    public boolean isEnableQuicByUserSetQosConstraint() {
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L7;
        com.ss.videoarch.liveplayer.log.c.i("LiveIonfo", "stream data is null");
        return false;
    L7:
        if (r100.isEnableQuicByUserSetQosConstraint() != 1) goto L10;
        return true;
    L10:
        return false;
    }

    public boolean isEnableSDR2HDR() {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r100 = this.f459547b;
        if (r100 != null) goto L8;
        return false;
    L8:
        return r100.isEnableSDR2HDR();
    L9:
        return false;
    }

    public boolean hasBackupURL() {
        HashMap<String, String> r100 = getLineMap();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L7;
        return true;
    }

    public int getSourceType() {
        return this.f459549d;
    }

    public LiveStreamInfo.a getABRDefaultPlayURL(String r100) {
        if (this.f459549d != 2) goto L10;
        LiveStreamInfo r101 = this.f459547b;
        if (r101 == null) goto L12;
        if (r100 != null) goto L9;
        return null;
    L9:
        return r101.getABRDefaultPlayURL(r100);
    L12:
        return null;
    L10:
        return null;
    }

    public JSONObject getBitrateList(String r100) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r101 = this.f459547b;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.getBitrateList(r100);
    L9:
        return null;
    }

    public long getLowerResBitrate(String r100) {
        LiveStreamInfo r101 = this.f459547b;
        if (r101 != null) goto L7;
        return -1;
    L7:
        return r101.getLowerResBitrate(r100);
    }

    public String getNeptuneName(String r100) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r101 = this.f459547b;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.getNeptuneName(r100);
    L9:
        return null;
    }

    public c getPlayURLByCodec(String r100) {
        if (r100 == null) goto L17;
        c[] r101 = this.f459546a;
        if (r101 == null) goto L17;
        if (r101.length == 0) goto L17;
        int r102 = r101.length;
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L17;
        c r104 = r101[r103];
        if (r100.equals(r104.getVCodec()) == false) goto L16;
        if (r104.f459554a == null) goto L16;
        return r104;
    L16:
        r103 = r103 + 1;
    L17:
        return null;
    }

    public int getPushId(String r100) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r101 = this.f459547b;
        if (r101 != null) goto L8;
        return 0;
    L8:
        return r101.getPushId(r100);
    L9:
        return 0;
    }

    public JSONObject getPushStreamInfo(String r100) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r101 = this.f459547b;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.getPushStreamInfo(r100);
    L9:
        return null;
    }

    public ArrayList<String> getResolutionList(String r100) {
        ArrayList<String> r101 = new ArrayList();
        JSONObject r102 = getResolutionMap(r100);
        if (r102 == null) goto L8;
        Iterator<String> r103 = r102.keys();
    L6:
        if (r103.hasNext() == false) goto L8;
        r101.add(r103.next());
    L8:
        return r101;
    }

    public JSONObject getResolutionMap(String r100) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r101 = this.f459547b;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.getResolutionList(r100);
    L9:
        return null;
    }

    public int getShortEdgeForResolution(String r100) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r101 = this.f459547b;
        if (r101 != null) goto L8;
        return -1;
    L8:
        return r101.getShortEdgeForResolution(r100);
    L9:
        return -1;
    }

    public JSONObject getStartupBitrateList(String r100) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r101 = this.f459547b;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.getStartupBitrateList(r100);
    L9:
        return null;
    }

    public JSONObject getTemplateList(String r100) {
        LiveStreamInfo r101 = this.f459547b;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getTemplateList(r100);
    }

    public boolean isCodecSame(String r100) {
        LiveStreamInfo r101 = this.f459547b;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isCodecSame(r100);
    }

    public boolean isDisableQuicOnLowPlugin(int r100) {
        if (this.f459547b != null) goto L7;
        com.ss.videoarch.liveplayer.log.c.i("LiveIonfo", "stream data is null");
        return false;
    L7:
        if (r100 != 1) goto L12;
        com.ss.videoarch.live.b r101 = com.ss.videoarch.live.b.f.f458578a;
        if (r101.f() == false) goto L11;
        String r102 = r101.f458556b.c();
    L14:
        if (this.f459547b.isEnableQuicPluginVersionCheck() == 1) goto L16;
    L18:
        return false;
    L16:
        if (cnc.c.compareVersion(this.f459547b.getQuicPluginMinVersion(), r102) == false) goto L18;
        return true;
    L11:
        r102 = null;
        goto L14
    L12:
        r102 = "";
        goto L14
    }

    public boolean isFpsSupportSDR2HDR(float r100) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r101 = this.f459547b;
        if (r101 != null) goto L8;
        return false;
    L8:
        return r101.isFpsSupportSDR2HDR(r100);
    L9:
        return false;
    }

    public boolean isFpsSupportSR(float r100) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r101 = this.f459547b;
        if (r101 != null) goto L8;
        return false;
    L8:
        return r101.isFpsSupportSR(r100);
    L9:
        return false;
    }

    public boolean isFpsSupportSharpen(float r100) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r101 = this.f459547b;
        if (r101 != null) goto L8;
        return false;
    L8:
        return r101.isFpsSupportSharpen(r100);
    L9:
        return false;
    }

    public boolean isInErrorSet(String r100) {
        LiveStreamInfo r101 = this.f459547b;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isInErrorSet(r100);
    }

    public boolean isSupportResolution(String r100) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r101 = this.f459547b;
        if (r101 != null) goto L8;
        return false;
    L8:
        return r101.isSupport(r100);
    L9:
        return false;
    }

    public void removeErrorRes(HashSet<String> r100) {
        LiveStreamInfo r101 = this.f459547b;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.removeErrorRes(r100);
    }

    public void setCmafDegrade(int r100) {
        LiveStreamInfo r101 = this.f459547b;
        if (r101 == null) goto L6;
        r101.setCmafDegrade(r100);
        return;
    }

    public void setDefaultResolution(String r100) {
        if (this.f459549d == 2) goto L5;
        return;
    L5:
        LiveStreamInfo r101 = this.f459547b;
        if (r101 != null) goto L8;
        return;
    L8:
        r101.setDefaultResolution(r100);
    }

    public void setEnableGetMpdUrlOpt(int r100) {
        LiveStreamInfo r101 = this.f459547b;
        if (r101 == null) goto L6;
        r101.setEnableGetMpdUrlOpt(r100);
        return;
    }

    public void setEnableOriginResolution(boolean r100) {
        LiveStreamInfo r101 = this.f459547b;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setEnableOriginResolution(r100);
    }

    public void setFastOpenDuration(int r100) {
        LiveStreamInfo r101 = this.f459547b;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setFastOpenDuration(r100);
    }

    public void setForceTSL(boolean r100) {
        LiveStreamInfo r101 = this.f459547b;
        if (r101 == null) goto L6;
        r101.setForceTSL(r100);
        return;
    }

    public void setPlayURLs(c[] r100) {
        this.f459546a = r100;
        int r101 = 0;
        this.f459550e = 0;
        this.f459549d = 1;
        ArrayList r102 = new ArrayList();
        int r103 = r100.length;
    L3:
        if (r101 >= r103) goto L11;
        c r104 = r100[r101];
        String r105 = r104.f459554a;
        if (r105 == null) goto L7;
        r102.add(r105);
    L7:
        String r106 = r104.f459555b;
        if (r106 == null) goto L10;
        r102.add(r106);
    L10:
        r101 = r101 + 1;
        goto L3
    L11:
        String[] r107 = new String[r102.size()];
        this.f459548c = r107;
        r102.toArray(r107);
    }

    public void setRequestParams(String r100) {
        LiveStreamInfo r101 = this.f459547b;
        if (r101 == null) goto L6;
        r101.setRequestParams(r100);
        return;
    }

    public void setRtcFallback(int r100) {
        LiveStreamInfo r101 = this.f459547b;
        if (r101 == null) goto L6;
        r101.setRtcFallback(r100);
        return;
    }

    public void setSourceType(int r100) {
        this.f459549d = r100;
    }

    public void setStartPlayResolution(String r100) {
        this.f459547b.setStartPlayResolution(r100);
    }

    public void setStartupResListStr(String r100) {
        LiveStreamInfo r101 = this.f459547b;
        if (r101 == null) goto L6;
        r101.setStartupResListStr(r100);
        return;
    }

    public void setStreamInfo(LiveStreamInfo r100) {
        this.f459547b = r100;
        this.f459550e = 0;
        this.f459549d = 2;
    }

    public boolean setStreamInfoFlag(int r100) {
        LiveStreamInfo r101 = this.f459547b;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.setFlag(r100);
    }

    public JSONObject getABRTags(String r100, String r101) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r102 = this.f459547b;
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.getABRTags(r100, r101);
    L9:
        return null;
    }

    public String getAvLinesParams(String r100, String r101) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r102 = this.f459547b;
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.getAvLinesParams(r100, r101);
    L9:
        return null;
    }

    public long getBitrate(String r100, String r101) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r102 = this.f459547b;
        if (r102 != null) goto L8;
        return 0;
    L8:
        return r102.getBitrate(r100, r101);
    L9:
        return 0;
    }

    public JSONObject getCMAFParams(String r100, String r101) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r102 = this.f459547b;
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.getCMAFParams(r100, r101);
    L9:
        return null;
    }

    public int getCheckSilenceInterval(String r100, String r101) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r102 = this.f459547b;
        if (r102 != null) goto L8;
        return -1;
    L8:
        return r102.getCheckSilenceInterval(r100, r101);
    L9:
        return -1;
    }

    public String getDRType(String r100, String r101) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r102 = this.f459547b;
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.getDRType(r100, r101);
    L9:
        return null;
    }

    public JSONObject getMKRLParams(String r100, String r101) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r102 = this.f459547b;
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.getMkRenderParams(r100, r101);
    L9:
        return null;
    }

    public JSONObject getSDKParamsJson(String r100, String r101) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r102 = this.f459547b;
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.getSDKParamsJson(r100, r101);
    L9:
        return null;
    }

    public JSONObject getSDR2HDRParams(String r100, String r101) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r102 = this.f459547b;
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.getSDR2HDRParams(r100, r101);
    L9:
        return null;
    }

    public JSONObject getSRParams(String r100, String r101) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r102 = this.f459547b;
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.getSRParams(r100, r101);
    L9:
        return null;
    }

    public Rect getStreamResolution(String r100, String r101) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r102 = this.f459547b;
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.getStreamResolution(r100, r101);
    L9:
        return null;
    }

    public String getSuggestAccessCode(String r100, String r101) {
        LiveStreamInfo r102 = this.f459547b;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.getSuggestAccessCode(r100, r101);
    }

    public String getSuggestFormat(String r100, String r101) {
        LiveStreamInfo r102 = this.f459547b;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.getSuggestFormat(r100, r101);
    }

    public String getSuggestProtocol(String r100, String r101) {
        LiveStreamInfo r102 = this.f459547b;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.getSuggestProtocol(r100, r101);
    }

    public String getTemplateName(String r100, int r101) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r102 = this.f459547b;
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.getTemplateName(r100, r101);
    L9:
        return null;
    }

    public long getTemplateNominalBitrate(String r100, String r101) {
        LiveStreamInfo r102 = this.f459547b;
        if (r102 != null) goto L7;
        return -1;
    L7:
        return r102.getTemplateNominalBitrate(r100, r101);
    }

    public String getVCodec(String r100, String r101) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r102 = this.f459547b;
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.getVCodec(r100, r101);
    L9:
        return null;
    }

    public int getVResolution(String r100, String r101) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r102 = this.f459547b;
        if (r102 != null) goto L8;
        return -1;
    L8:
        return r102.getVResolution(r100, r101);
    L9:
        return -1;
    }

    public String getVideoSize(String r100, String r101) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r102 = this.f459547b;
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.getVideoSize(r100, r101);
    L9:
        return null;
    }

    public boolean isEnableAdaptive(String r100, String r101) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r102 = this.f459547b;
        if (r102 != null) goto L8;
        return false;
    L8:
        return r102.isEnableAdaptive(r100, r101);
    L9:
        return false;
    }

    public boolean isResSupportSDR2HDR(String r100, String r101) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r102 = this.f459547b;
        if (r102 != null) goto L8;
        return false;
    L8:
        return r102.isResSupportSDR2HDR(r100, r101);
    L9:
        return false;
    }

    public boolean isResSupportSharpen(String r100, String r101) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r102 = this.f459547b;
        if (r102 != null) goto L8;
        return false;
    L8:
        return r102.isResSupportSharpen(r100, r101);
    L9:
        return false;
    }

    public void setTransportProtocol(String r100, String r101) {
        LiveStreamInfo r102 = this.f459547b;
        if (r102 == null) goto L6;
        r102.setTransportProtocol(r100, r101);
        return;
    }

    public boolean compareRes(String r100, String r101, String r102) {
        LiveStreamInfo r103 = this.f459547b;
        if (r103 != null) goto L7;
        return false;
    L7:
        return r103.compareRes(r100, r101, r102);
    }

    public JSONObject getAbrBitrateMap(String r100, int r101, String r102) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r103 = this.f459547b;
        if (r103 != null) goto L8;
        return null;
    L8:
        return r103.getAbrBitrateMap(r100, r101, r102);
    L9:
        return null;
    }

    public JSONObject getAbrResolutionMap(String r100, int r101, String r102) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r103 = this.f459547b;
        if (r103 != null) goto L8;
        return null;
    L8:
        return r103.getAbrResolutionMap(r100, r101, r102);
    L9:
        return null;
    }

    public String getLabelfromBitrate(long r100, String r101, String r102) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r103 = this.f459547b;
        if (r103 != null) goto L8;
        return null;
    L8:
        return r103.getLabelfromBitrate(r100, r101, r102);
    L9:
        return null;
    }

    public String getPlayURLForInputFormat(String r100, String r101, String r102) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r103 = this.f459547b;
        if (r103 != null) goto L8;
        return null;
    L8:
        return r103.getStreamUrlForInputFormat(r100, r101, r102);
    L9:
        return null;
    }

    public String getPlayURLForResolution(String r100, String r101, String r102) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r103 = this.f459547b;
        if (r103 != null) goto L8;
        return null;
    L8:
        return r103.getStreamUrlForResolution(r100, r101, r102);
    L9:
        return null;
    }

    public String getPortNum(String r100, String r101, String r102) {
        if (this.f459547b != null) goto L6;
        return null;
    L6:
        if ("udpsdp".equals(r102) == true) goto L10;
        if ("quicsdp".equals(r102) == true) goto L10;
    L13:
        return this.f459547b.getPortNum(r100, r101, r102);
    L10:
        if ("lls".equals(r100) == true) goto L13;
        return null;
    }

    public JSONObject getSharpenParams(String r100, String r101, boolean r102) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r103 = this.f459547b;
        if (r103 != null) goto L8;
        return null;
    L8:
        return r103.getSharpenParams(r100, r101, r102);
    L9:
        return null;
    }

    public boolean isBitrateAbnormal(String r100, String r101, long r102) {
        LiveStreamInfo r103 = this.f459547b;
        if (r103 != null) goto L7;
        return false;
    L7:
        return r103.isBitrateAbnormal(r100, r101, r102);
    }

    public boolean isResSupportSR(int r100, int r101, boolean r102) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r103 = this.f459547b;
        if (r103 != null) goto L8;
        return false;
    L8:
        return r103.isResSupportSR(r100, r101, r102);
    L9:
        return false;
    }

    public boolean isResSupportSharpen(int r100, int r101, boolean r102) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r103 = this.f459547b;
        if (r103 != null) goto L8;
        return false;
    L8:
        return r103.isResSupportSharpen(r100, r101, r102);
    L9:
        return false;
    }

    public void setRequestParamsWithDNSIp(String r100, String r101, String r102) {
        LiveStreamInfo r103 = this.f459547b;
        if (r103 == null) goto L6;
        r103.setRequestParamsWithDNSIp(r100, r101, r102);
        return;
    }

    public void setSdkParamsJson(String r100, String r101, JSONObject r102) {
        LiveStreamInfo r103 = this.f459547b;
        if (r103 != null) goto L5;
        return;
    L5:
        r103.setSdkParamsJson(r100, r101, r102);
    }

    public boolean isResSupportSR(String r100, String r101, boolean r102) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r103 = this.f459547b;
        if (r103 != null) goto L8;
        return false;
    L8:
        return r103.isResSupportSR(r100, r101, r102);
    L9:
        return false;
    }

    public String getMPDForFormat(String r100, String r101, String r102, String r103) {
        if (this.f459549d != 2) goto L9;
        LiveStreamInfo r104 = this.f459547b;
        if (r104 != null) goto L8;
        return null;
    L8:
        return r104.getMPDForFormat(r100, r101, r102, r103);
    L9:
        return null;
    }
}
