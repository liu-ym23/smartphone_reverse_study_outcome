package com.larus.business.debug.api;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.larus.im.bean.message.Message;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import org.json.JSONObject;
import q97.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\bg\u0018\u0000 K2\u00020\u0001:\u0001KJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH&J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0014H&J\b\u0010\u0016\u001a\u00020\u0014H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u0019H&J\b\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u0019H&J\b\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!H&J7\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\n2%\u0010%\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u0003\u0018\u00010&H&J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\n\u0010+\u001a\u0004\u0018\u00010,H&J\b\u0010-\u001a\u00020\u001fH&J(\u0010.\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\n2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000302H&J\n\u00103\u001a\u0004\u0018\u000104H&J\n\u00105\u001a\u0004\u0018\u00010\nH&J\u0012\u00106\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u000f\u00107\u001a\u0004\u0018\u00010\u0019H&¢\u0006\u0002\u00108J\b\u00109\u001a\u00020\u0019H&J\b\u0010:\u001a\u00020;H&J\u0012\u0010<\u001a\u00020\u00192\b\u0010=\u001a\u0004\u0018\u00010>H&J\b\u0010?\u001a\u00020\nH&J\u000f\u0010@\u001a\u0004\u0018\u00010\u0019H&¢\u0006\u0002\u00108J\b\u0010A\u001a\u00020\u001fH&J\b\u0010B\u001a\u00020\u0019H&J\u0010\u0010C\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020/H&J\b\u0010D\u001a\u00020\u001cH&J\b\u0010E\u001a\u00020\u0003H&J\b\u0010F\u001a\u00020\u0019H&J\u000f\u0010G\u001a\u0004\u0018\u00010\u001fH&¢\u0006\u0002\u0010HJ\b\u0010I\u001a\u00020\u0019H&J\b\u0010J\u001a\u00020\u0019H&¨\u0006L"}, d2 = {"Lcom/larus/business/debug/api/IDebugService;", "", "init", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "initNewUserMode", "initCalidge", "setSettingHost", "host", "", "getSettingHost", "initSaitamaHelper", "activity", "Landroid/app/Activity;", "initDebugInterceptors", "reportDebugToolUse", "toolTypeStr", "toolName", "getDevelopFragment", "Landroidx/fragment/app/Fragment;", "getAICreationDebugFragment", "getCanvasDebugFragment", "updateUIToolsShowState", "newState", "", "currentUIToolsShowState", "getDebugInfo", "Lorg/json/JSONObject;", "forceAllowSmartReplyLongClickMenu", "getWxMiniProgramType", "", "getMarkdownDebugMessage", "Landroidx/lifecycle/LiveData;", "Lcom/larus/im/bean/message/Message;", "createDebugConversation", "schema", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "conversationId", "debugStarlingKey", "getFakeLocMgr", "Lcom/larus/business/debug/api/livenavi/IFakeLocationMgr;", "getCutTextCellType", "showRebootDialog", "Landroidx/fragment/app/FragmentActivity;", "text", "action", "Lkotlin/Function0;", "getFeatureListInterceptor", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "getSelectFeatureKey", "openFeatureListActivity", "getDebugCreationFeedDownGrade", "()Ljava/lang/Boolean;", "enableShowAICreationDebug", "createFastLoginInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "isFastLogin", "uri", "Landroid/net/Uri;", "getDebugSideBarEnable", "getDebugSideBarPredictiveBackEnable", "getDebugSideBarScrollDuration", "isIMToastEnable", "showPnSDebugTools", "getBlockDebugInfo", "initAlogDlp", "isMockMembershipPurchaseErrorCodeEnabled", "getMockMembershipPurchaseErrorCode", "()Ljava/lang/Integer;", "isAppLogAlignOnline", "isExposureManagerDebugOpen", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDebugService {
    void A();

    String B();

    void C();

    a D();

    Fragment E();

    void F();

    JSONObject c();

    qv8.a d();

    boolean e();

    boolean f();

    LiveData<Message> g();

    JSONObject h();

    void i();

    void init();

    int j();

    void k();

    boolean l();

    int m();

    Interceptor n();

    Integer o();

    boolean p();

    Fragment q();

    boolean r();

    int s();

    void t();

    boolean u();

    String v();

    void w();

    boolean x();

    Fragment y();

    Boolean z();
}
