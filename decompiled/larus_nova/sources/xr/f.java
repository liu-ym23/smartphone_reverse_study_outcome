package xr;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.gamecp.base.core.service.depend.GameRelatePackageSource;
import com.bytedance.android.gamecp.base.core.service.depend.PlatformSupportPkg;
import com.bytedance.android.gamecp.base.core.service.depend.t;
import com.bytedance.android.gamecp.base.core.service.depend.w;
import com.bytedance.android.gamecp.business.GameCPLiveSettingsMap;
import com.bytedance.android.gamecp.business.card.GamePromoteCardV2;
import com.bytedance.android.gamecp.business.downloadview.DownloadUIView;
import com.bytedance.android.gamecp.business.gamedetail.AudienceGamePromoteDialogV2;
import com.bytedance.android.gamecp.host_api.model.Room;
import com.bytedance.android.gamecp.hybrid_impl.jsb.f1;
import com.bytedance.android.livesdk.gamecp.GameCpServiceImpl;
import com.bytedance.android.livesdk.gamecp.impl.LiveHostGameCP;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public interface f extends o {
    void C(String r100, String r101, String r102);

    int C1(JsonObject r100, com.bytedance.android.gamecp.base.core.service.depend.n r101);

    com.bytedance.android.gamecp.host_api.model.c D1();

    @Deprecated(message = "主播推荐列表已经禁用")
    void E1(Context r100, Room r101, Map<String, String> r102);

    void G(long r100, String r101);

    void H(long r100, String r101, String r102);

    List<PlatformSupportPkg> I(String r100);

    boolean L(LiveHostGameCP.C100301 r100);

    String L0();

    void N0(JsonObject r100);

    void O1(Context r100, String r101, String r102, String r103, JSONObject r104, com.bytedance.android.gamecp.base.core.service.depend.q r105);

    void P0(String r100, HashMap<String, String> r101);

    JSONObject Q1();

    void R1(Context r100, JSONObject r101, com.bytedance.android.gamecp.base.core.service.depend.i r102);

    int T(JsonObject r100, com.bytedance.android.gamecp.base.core.service.depend.s r101);

    void U(Context r100, GameRelatePackageSource r101, String r102, List<String> r103, Map<String, String> r104);

    Disposable V0(JSONObject r100, Function1 r101, Function2 r102);

    void W1(Context r100, JSONObject r101, com.bytedance.android.gamecp.base.core.service.depend.f r102);

    String Y1();

    void Z(String r100, com.bytedance.android.gamecp.base.core.service.depend.r r101);

    AudienceGamePromoteDialogV2 a2(com.bytedance.android.gamecp.base.core.service.depend.a r100, JsonObject r101, GameCpServiceImpl.b r102);

    long c1();

    void cancelDownloadGame(Context r100, JsonObject r101);

    void checkInstallFailPushTips();

    void clearLivePromoteIconShowStatus();

    DownloadUIView createGameCPDownload();

    void d1(Context r100, String r101, com.bytedance.android.gamecp.base.core.service.depend.r r102);

    void dataChannelLinkEvent(String r100, Map<String, String> r101);

    GameCPLiveSettingsMap f2();

    void g2(Context r100, String r101, t r102);

    int genDownloadToken();

    List<Object> getBehaviorList();

    g getCloudGameService();

    String getDownloadedGameIconUri();

    Set<String> getDownloadingGames();

    d getGameCPFmpMonitorService();

    j getGameCpLiveService();

    String getGameCpSdkVersion();

    Number getGameReserveStatus(String r100);

    h getGameService();

    RecyclerView getLynxNestRecyclerView(Context r100);

    p getTrackService();

    q getWhiteBoxTestService();

    String h(String r100);

    void i1(String r100);

    void inDegradeScene(boolean r100);

    void initJsBridge();

    boolean interceptLiveFloatWindow();

    boolean isRestoreFailed(String r100);

    boolean isSupportAirCompress(String r100);

    void j0();

    void k0(Context r100, Map r101, f1 r102);

    void k1(String r100, String r101, String r102);

    FrameLayout k2(Context r100);

    void l2(Context r100, long r101, String r102, String r103, boolean r104);

    void livePromoteIconShowChange(boolean r100);

    void logMonitorLinkEvent(int r100, String r101, Map<String, String> r102, boolean r103);

    void m0(Context r100, String r101, String r102, String r103);

    void n(Context r100, int r101, String r102, LiveHostGameCP.C100381 r103);

    void n0(long r100);

    GamePromoteCardV2 n1(Context r100, String r101, String r102, String r103);

    void o(boolean r100, String r101, String r102, int r103, long r104, Map<String, Object> r105);

    void onAnchorExitRoom();

    void onLoadAiPredictor(Context r100, long r101, String r102, String r103);

    void onRoomEnter(Context r100, long r101, String r102, String r103, String r104);

    void onRoomExit(long r100, String r101, String r102);

    void onUnloadAiPredictor(long r100);

    void openGameCPPlayerRankInstruction(Context r100);

    void openLiveMiniPlay(Context r100, String r101, Map<String, ? extends Object> r102, Function0<Unit> r103, Function0<Unit> r104);

    boolean p0();

    b p1();

    void q0(Context r100, JsonObject r101, com.bytedance.android.gamecp.base.core.service.depend.e r102);

    void q2(String r100, Context r101, Function0<Unit> r102);

    void r0(Context r100, String r101, String r102, JSONObject r103, com.bytedance.android.gamecp.base.core.service.depend.k r104);

    void r2(String r100, com.bytedance.android.gamecp.base.core.service.depend.c r101);

    void s0(Context r100);

    Observable<List<w>> selectImages(Context r100, List<? extends w> r101, int r102);

    void sendAdLog(String r100, String r101, long r102, JSONObject r103);

    void showGameOrderDetailDialog(Context r100, Bundle r101, Boolean r102);

    void showGamePromoteDetailDialog(Context r100, Bundle r101, Boolean r102);

    void showIntroDialog(Context r100, Map<String, String> r101);

    void showPropsDetailDialog(Context r100, Map<String, Object> r101);

    void stopAiPredictorTimer();

    void t2(String r100, int r101, LiveHostGameCP.C100361 r102);

    void u(hw.d r100);

    void u0(Context r100, List<? extends JSONObject> r101, com.bytedance.android.gamecp.base.core.service.depend.j r102);

    void unregisterAirCompressListener(String r100);

    void v2(JsonObject r100);

    void w1(Context r100, int r101, List r102, List r103, Function3 r104);

    List<PlatformSupportPkg> w2(Context r100, List<PlatformSupportPkg> r101);

    void y2(String r100, String r101, com.bytedance.android.gamecp.base.core.service.depend.b r102);

    k z0();

    void z1(String r100, String r101);
}
