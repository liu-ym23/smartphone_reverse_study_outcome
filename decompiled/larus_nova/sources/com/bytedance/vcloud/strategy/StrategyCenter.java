package com.bytedance.vcloud.strategy;

import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ugc.clientai.core.api.SmartService;
import com.ss.ugc.clientai.core.api.SmartServiceConfig;
import com.ss.ugc.clientai.core.api.SmartServiceManager;
import java.util.Map;
import mp7.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class StrategyCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f272479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f272480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f272481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IStrategyEventListener f272482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final mp7.a f272483e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f272484f;

    public class a implements ISmartServiceSupplier {
        public a() {
        }
    }

    private native void _addInterimMedia(long r100, String r101, ISelectBitrateListener r102, String r103, boolean r104, boolean r105);

    private native void _addMedia(long r100, String r101, ISelectBitrateListener r102, String r103, boolean r104);

    private native void _addMediaWithCallback(long r100, String r101, ISelectBitrateListener r102, IPreloadTaskCallbackListener r103, String r104, boolean r105, boolean r106);

    private native void _addPriorityTask(long r100, String r101, ISelectBitrateListener r102, IPreloadTaskCallbackListener r103);

    private native void _businessEvent(long r100, int r101, int r102);

    private native void _businessEvent(long r100, int r101, int r102, int r103);

    private native void _businessEvent(long r100, int r101, int r102, String r103);

    private native void _businessEvent(long r100, int r101, String r102);

    private native long _create(IStrategyEventListener r100);

    private native void _createPlayer(long r100, long r101, String r102, String r103);

    private native void _createPlayerWithTag(long r100, long r101, String r102, String r103, String r104);

    private native void _createScene(long r100, String r101);

    private native void _destroyScene(long r100, String r101);

    private native String _ensureQualityEnhancement(long r100, Object r101, String r102);

    private native void _focusMedia(long r100, String r101, int r102);

    private native float _getFloatValue(long r100, int r101, float r102);

    private native Object _getImageSelectBitrateResult(long r100, String r101, String r102);

    private native String _getImageStrategyResult(long r100, String r101, String r102);

    private native int _getIntValue(long r100, int r101, int r102);

    private native long _getLongValue(long r100, int r101, long r102);

    private native long _getLongValue(long r100, int r101, String r102, long r103);

    private native String _getStrValue(long r100, int r101, String r102);

    private native int _iPlayerVersion(long r100);

    private native void _insertMedia(long r100, String r101, ISelectBitrateListener r102, IPreloadTaskCallbackListener r103, String r104, int r105);

    private native boolean _isIOManagerVersionMatch(long r100);

    private native boolean _isMediaExist(long r100, String r101, String r102);

    private native void _makeCurrentPlayer(long r100, String r101);

    private native void _moveMedia(long r100, String r101, int r102, int r103);

    private native void _moveToScene(long r100, String r101);

    private native void _playSelection(long r100, String r101, int r102, int r103);

    private native String _popLogData(long r100, int r101, String r102);

    private native Map<Integer, Object[]> _popOptionLog(long r100, String r101);

    private native void _relatePlaySessionRef(long r100, String r101, String r102, IPlaySessionRef r103, IPlayStrategyRef r104);

    private native void _release(long r100);

    private native void _releasePlayer(long r100, String r101, String r102);

    private native void _removeAllMedia(long r100, String r101, int r102);

    private native void _removeMedia(long r100, String r101, int r102, int r103);

    private native void _removeMedia(long r100, String r101, String r102);

    private native void _removePriorityTask(long r100, String r101);

    private native String _selectBitrate(long r100, String r101, int r102, String r103, Object r104);

    private native String _selectBitrateStringMap(long r100, String r101, int r102, String r103, Object r104);

    private native String _selectBitrateStringMapWithObject(long r100, Object r101, int r102, String r103, Object r104);

    private native void _setAlgorithmJson(long r100, int r101, String r102);

    private native void _setAppInfo(long r100, String r101);

    private native void _setAppServer(long r100, IAppService r101);

    private native void _setEventListener(long r100, IStrategyEventListener r101);

    private native void _setFloatValue(long r100, int r101, float r102);

    private native void _setIOManager(long r100, long r101, long r102);

    private native void _setIntValue(long r100, int r101, int r102);

    private native void _setIntervalMS(long r100, int r101);

    private native void _setLogCallback(long r100, ILogCallback r101);

    private native void _setLongValue(long r100, int r101, long r102);

    private native void _setPlayDoubleConfig(long r100, String r101, int r102, double r103);

    private native void _setPlayIntConfig(long r100, String r101, int r102, int r103);

    private native void _setPlayLongConfig(long r100, String r101, int r102, long r103);

    private native void _setPlayStringConfig(long r100, String r101, int r102, String r103);

    private native void _setPlayTaskProgress(long r100, float r101);

    private native void _setProbeType(long r100, int r101);

    private native void _setSettingsInfo(long r100, String r101, String r102);

    private native void _setSmartServiceSupplier(long r100, ISmartServiceSupplier r101);

    private native void _setStateSupplier(long r100, IStrategyStateSupplier r101);

    private native void _setStrValue(long r100, int r101, String r102);

    private native void _start(long r100);

    private native void _stop(long r100);

    private native void _updateMedia(long r100, String r101, String r102, String r103);

    public final float n() {
        long r100 = this.f272479a;
        if (r100 != 0) goto L11;
        return -1.0f;
    L11:
        return _getFloatValue(r100, 20401, -1.0f);
    L8:
        th = move-exception;
        th.toString();
        return -1.0f;
    }

    public final int q() {
        long r100 = this.f272479a;
        if (r100 != 0) goto L7;
        return -1;
    L7:
        return _iPlayerVersion(r100);
    }

    public final boolean r() {
        long r100 = this.f272479a;
        if (r100 != 0) goto L7;
        return false;
    L7:
        return _isIOManagerVersionMatch(r100);
    }

    public final boolean s() {
        if (this.f272479a == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public StrategyCenter(IStrategyEventListener r100) {
        this.f272479a = 0;
        this.f272480b = false;
        this.f272481c = 3;
        this.f272482d = null;
        this.f272483e = new mp7.a();
        this.f272484f = new a();
        this.f272482d = r100;
    }

    public final void C(String r100) {
        long r101 = this.f272479a;
        if (r101 != 0) goto L5;
        return;
    L5:
        _setAppInfo(r101, r100);
    }

    public final void D(IAppService r100) {
        long r101 = this.f272479a;
        if (r101 != 0) goto L10;
        return;
    L10:
        _setAppServer(r101, r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.toString();
    }

    public final void G(ILogCallback r100) {
        long r101 = this.f272479a;
        if (r101 != 0) goto L5;
        return;
    L5:
        _setLogCallback(r101, r100);
    }

    public final void J(IStrategyStateSupplier r100) {
        long r101 = this.f272479a;
        if (r101 != 0) goto L5;
        return;
    L5:
        _setStateSupplier(r101, r100);
    }

    public final void L(boolean r100) {
        if (this.f272480b == false) goto L5;
        return;
    L5:
        i(r100);
        if (this.f272479a != 0) goto L8;
        return;
    L8:
        F(10000, this.f272481c);
        _start(this.f272479a);
        if (o(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME) == 0) goto L24;
        String r101 = p(TTVideoEngineInterface.ALGO_CONFIG_STRING_SMART_SERVICE_PACKAGE_URL, "");
        if (r101 == null) goto L24;
        if (r101.isEmpty() == true) goto L24;
        mp7.a r102 = this.f272483e;
        r102.getClass();
        SmartService r103 = SmartServiceManager.instance().getCommonService("vod_smart_speed");
        r102.f514721a = r103;
        if (r103 == null) goto L17;
        SmartServiceConfig r104 = new SmartServiceConfig("vod_smart_speed");
        Map<String, Object> r105 = r104.configMap();
        r105.put("engineType", "mlsdk");
        r105.put("outputType", "regression");
        r105.put("packageUrl", r101);
        r102.f514721a.configService(r104);
    L17:
        a r106 = this.f272484f;
        long r107 = this.f272479a;
        if (r107 == 0) goto L24;
        _setSmartServiceSupplier(r107, r106);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.toString();
    L24:
        this.f272480b = true;
    }

    public final void M(String r100) {
        long r101 = this.f272479a;
        if (r101 != 0) goto L5;
        return;
    L5:
        _moveToScene(r101, r100);
    }

    public final void a(String r110) {
        long r100 = this.f272479a;
        if (r100 != 0) goto L5;
        return;
    L5:
        _addMedia(r100, r110, null, null, false);
    }

    public final void c(String r110) {
        long r100 = this.f272479a;
        if (r100 != 0) goto L11;
        return;
    L11:
        _addInterimMedia(r100, r110, null, null, false, true);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        th.toString();
    }

    public final void i(boolean r100) {
        if (s() == true) goto L27;
        if (r100 == true) goto L6;
    L22:
        this.f272479a = _create(this.f272482d);
        return;
    L6:
        monitor-enter(b.class);
    L19:
        th = move-exception;
        throw th;
    L8:
        if (b.f514722a == false) goto L25;
        monitor-exit(b.class);
    L17:
        if (b.f514722a == true) goto L22;
        return;
    L25:
        b.a();     // Catch: Throwable -> L13
        b.f514722a = true;     // Catch: Throwable -> L13
    L15:
        monitor-exit(b.class);
        goto L17
    L13:
        th = move-exception;
        th.toString();     // Catch: Throwable -> L19
        goto L15
    }

    public final void k(String r100) {
        long r101 = this.f272479a;
        if (r101 == 0) goto L8;
        if (r100 == null) goto L9;
        _createScene(r101, r100);
        return;
    L9:
        return;
    }

    public final void l(String r100) {
        long r101 = this.f272479a;
        if (r101 != 0) goto L5;
        return;
    L5:
        _destroyScene(r101, r100);
    }

    public final int o(int r100) {
        long r101 = this.f272479a;
        if (r101 != 0) goto L10;
        return 0;
    L10:
        return _getIntValue(r101, r100, 0);
    L7:
        th = move-exception;
        th.toString();
        return 0;
    }

    public final void t(String r100) {
        long r101 = this.f272479a;
        if (r101 != 0) goto L5;
        return;
    L5:
        _makeCurrentPlayer(r101, r100);
    }

    public final void x(String r100) {
        long r101 = this.f272479a;
        if (r101 != 0) goto L10;
        return;
    L10:
        _removePriorityTask(r101, r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.toString();
    }

    public final void B(int r100, String r101) {
        long r102 = this.f272479a;
        if (r102 != 0) goto L5;
        return;
    L5:
        _setAlgorithmJson(r102, r100, r101);
    }

    public final void E(long r100, long r110) {
        long r101 = this.f272479a;
        if (r101 != 0) goto L5;
        return;
    L5:
        _setIOManager(r101, r100, r110);
    }

    public final void F(int r100, int r101) {
        if (r100 != 10000) goto L5;
        this.f272481c = r101;
    L5:
        long r102 = this.f272479a;
        if (r102 != 0) goto L8;
        return;
    L8:
        _setIntValue(r102, r100, r101);
    }

    public final void I(String r100, String r101) {
        long r102 = this.f272479a;
        if (r102 != 0) goto L5;
        return;
    L5:
        _setSettingsInfo(r102, r100, r101);
    }

    public final void K(int r100, String r101) {
        long r102 = this.f272479a;
        if (r102 != 0) goto L10;
        return;
    L10:
        _setStrValue(r102, r100, r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.toString();
    }

    public final void N(String r100, String r101) {
        long r102 = this.f272479a;
        if (r102 != 0) goto L11;
        return;
    L11:
        _updateMedia(r102, r100, "", r101);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        th.toString();
    }

    public final void e(int r100, int r101) {
        long r102 = this.f272479a;
        if (r102 != 0) goto L10;
        return;
    L10:
        _businessEvent(r102, r100, r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.toString();
    }

    public final void h(int r100, String r101) {
        long r102 = this.f272479a;
        if (r102 != 0) goto L10;
        return;
    L10:
        _businessEvent(r102, r100, r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.toString();
    }

    public final void m(String r100, int r101) {
        long r102 = this.f272479a;
        if (r102 != 0) goto L5;
        return;
    L5:
        _focusMedia(r102, r100, r101);
    }

    public final String p(int r100, String r101) {
        long r102 = this.f272479a;
        if (r102 != 0) goto L10;
        return r101;
    L10:
        return _getStrValue(r102, r100, r101);
    L7:
        th = move-exception;
        th.toString();
        return r101;
    }

    public final String u(int r100, String r101) {
        long r102 = this.f272479a;
        if (r102 != 0) goto L7;
        return "";
    L7:
        return _popLogData(r102, r100, r101);
    }

    public final void v(String r100, int r101) {
        long r102 = this.f272479a;
        if (r102 != 0) goto L5;
        return;
    L5:
        _removeAllMedia(r102, r100, r101);
    }

    public final void w(String r100, String r101) {
        long r102 = this.f272479a;
        if (r102 != 0) goto L5;
        return;
    L5:
        _removeMedia(r102, r100, r101);
    }

    public final void H(String r100, int r101, String r102) {
        long r103 = this.f272479a;
        if (r103 != 0) goto L11;
        return;
    L11:
        _setPlayStringConfig(r103, r100, r101, r102);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        th.toString();
    }

    public final void d(String r100, ISelectBitrateListener r101, IPreloadTaskCallbackListener r102) {
        long r103 = this.f272479a;
        if (r103 != 0) goto L11;
        return;
    L11:
        _addPriorityTask(r103, r100, r101, r102);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        th.toString();
    }

    public final void f(int r100, int r101, int r102) {
        long r103 = this.f272479a;
        if (r103 != 0) goto L11;
        return;
    L11:
        _businessEvent(r103, r100, r101, r102);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        th.toString();
    }

    public final void g(int r100, int r101, String r102) {
        long r103 = this.f272479a;
        if (r103 != 0) goto L11;
        return;
    L11:
        _businessEvent(r103, r100, r101, r102);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        th.toString();
    }

    public final String A(JSONObject r100, int r110, String r111, Object r112) {
        long r101 = this.f272479a;
        if (r101 != 0) goto L11;
        return null;
    L11:
        return _selectBitrateStringMapWithObject(r101, r100, r110, r111, r112);
    L8:
        th = move-exception;
        th.toString();
        return null;
    }

    public final void j(long r100, String r110, String r111, String r112) {
        long r101 = this.f272479a;
        if (r101 != 0) goto L11;
        return;
    L11:
        _createPlayerWithTag(r101, r100, r110, r111, r112);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        th.toString();
        _createPlayer(this.f272479a, r100, r110, r111);
    }

    public final String y(String r100, int r110, String r111, Object r112) {
        long r101 = this.f272479a;
        if (r101 != 0) goto L11;
        return null;
    L11:
        return _selectBitrate(r101, r100, r110, r111, r112);
    L8:
        th = move-exception;
        th.toString();
        return null;
    }

    public final String z(String r100, int r110, String r111, Object r112) {
        long r101 = this.f272479a;
        if (r101 != 0) goto L11;
        return null;
    L11:
        return _selectBitrateStringMap(r101, r100, r110, r111, r112);
    L8:
        th = move-exception;
        th.toString();
        return null;
    }

    public final void b(String r110, ISelectBitrateListener r111, IPreloadTaskCallbackListener r112, String r113, boolean r114) {
        long r100 = this.f272479a;
        if (r100 != 0) goto L15;
        return;
    L15:
        _addMediaWithCallback(r100, r110, r111, r112, r113, r114, false);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        th.toString();
        _addInterimMedia(this.f272479a, r110, r111, r113, r114, false);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        th.toString();
    }
}
