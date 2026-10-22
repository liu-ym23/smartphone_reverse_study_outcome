package com.larus.login.api;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LiveData;
import com.larus.platform.model.TriggerLoginScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u000fH&J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&J\u001c\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0003H&J\u001e\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&J\u001a\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H&J\u0010\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%H'J\u001a\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u001dH'J\b\u0010)\u001a\u00020\u000fH&J\b\u0010*\u001a\u00020\u000fH&J\b\u0010+\u001a\u00020\u000fH&J\u0018\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001dH&J\u0017\u00100\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010%H&¢\u0006\u0002\u00101J\u0010\u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u000204H&J\u0010\u00105\u001a\u00020\u000f2\u0006\u00103\u001a\u000204H&J\u0010\u00106\u001a\u00020\u000f2\u0006\u00103\u001a\u000207H&J\u0010\u00108\u001a\u00020\u000f2\u0006\u00103\u001a\u000207H&J\b\u00109\u001a\u00020\u000fH&J\b\u0010:\u001a\u00020\u000fH&R\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n0\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006;"}, d2 = {"Lcom/larus/login/api/ITouristApi;", "", "baseConstrains", "", "needSyncFailedMsgWhenLogin", "launchAndRiskResult", "Landroidx/lifecycle/LiveData;", "getLaunchAndRiskResult", "()Landroidx/lifecycle/LiveData;", "cvsResult", "Lcom/larus/network/http/Async;", "getCvsResult", "isMessageLimited", "isCreateBotLimited", "checkAgeGate", "", "trackerJson", "Lorg/json/JSONObject;", "isHitTouristMode", "revertLimit", "markRisk", "value", "getRisk", "openLogin", "scene", "Lcom/larus/platform/model/TriggerLoginScene;", "forceFullScreenLogin", "openHalfLogin", "deepLinkSchema", "", "checkIfShowRiskDialog", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "fm", "Landroidx/fragment/app/FragmentManager;", "handleLimitedState", "code", "", "handleRiskState", "shark", "msg", "onLoginIn", "onLoginOut", "onLoginFail", "requestLaunch", "scope", "Lkotlinx/coroutines/CoroutineScope;", "source", "markAgeGateError", "(Ljava/lang/Long;)V", "addCallBack", "callBack", "Lcom/larus/login/api/callback/LoginCallBack;", "removeCallBack", "addPanelCallBack", "Lcom/larus/login/api/callback/LoginPanelCallBack;", "removePanelCallBack", "onPanelOpen", "onPanelClose", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ITouristApi {

    /* JADX INFO: loaded from: classes30.dex */
    public static final class a {
        public static /* synthetic */ void a(ITouristApi r100, TriggerLoginScene r101, boolean r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r101 = TriggerLoginScene.TRIGGER_LOGIN_CLICK_OTHERS;
        L6:
            if ((r103 & 2) == 0) goto L8;
            r102 = false;
        L8:
            r100.x(r101, r102);
        }
    }

    boolean a();

    void b();

    boolean c();

    void d(TriggerLoginScene r100, String r101);

    boolean f();

    void g();

    void h();

    boolean i(boolean r100, String r101);

    void j();

    void k(long r100);

    void m(Context r100, FragmentManager r101);

    void n();

    void o(Long r100);

    void p(tj9.a r100);

    void q(JSONObject r100);

    void r(LifecycleCoroutineScope r100, String r101);

    void s(tj9.b r100);

    boolean t();

    boolean u();

    void v(tj9.a r100);

    LiveData<Boolean> w();

    void x(TriggerLoginScene r100, boolean r101);

    LiveData<com.larus.network.http.a<Object>> y();

    void z(tj9.b r100);
}
