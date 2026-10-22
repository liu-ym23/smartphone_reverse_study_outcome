package com.ss.android.lark.todo.impl.flutterweb;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleon.pluginapi.RouterState;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.todo.impl.flutterweb.bridge.GetInitialRefResourceForChatCreatingHandler;
import com.ss.android.lark.todo.impl.flutterweb.bridge.GetInitialRichSummaryForChatCreatingHandler;
import com.ss.android.lark.todo.impl.flutterweb.bridge.GetIsFoldDisplayHandler;
import com.ss.android.lark.todo.impl.flutterweb.bridge.a0;
import com.ss.android.lark.todo.impl.flutterweb.bridge.b0;
import com.ss.android.lark.todo.impl.flutterweb.bridge.c0;
import com.ss.android.lark.todo.impl.flutterweb.bridge.d;
import com.ss.android.lark.todo.impl.flutterweb.bridge.e;
import com.ss.android.lark.todo.impl.flutterweb.bridge.e0;
import com.ss.android.lark.todo.impl.flutterweb.bridge.f;
import com.ss.android.lark.todo.impl.flutterweb.bridge.f0;
import com.ss.android.lark.todo.impl.flutterweb.bridge.h;
import com.ss.android.lark.todo.impl.flutterweb.bridge.j;
import com.ss.android.lark.todo.impl.flutterweb.bridge.l;
import com.ss.android.lark.todo.impl.flutterweb.bridge.m;
import com.ss.android.lark.todo.impl.flutterweb.bridge.n;
import com.ss.android.lark.todo.impl.flutterweb.bridge.o;
import com.ss.android.lark.todo.impl.flutterweb.bridge.r;
import com.ss.android.lark.todo.impl.flutterweb.bridge.s;
import com.ss.android.lark.todo.impl.flutterweb.bridge.t;
import com.ss.android.lark.todo.impl.flutterweb.bridge.u;
import com.ss.android.lark.todo.impl.flutterweb.bridge.v;
import com.ss.android.lark.todo.impl.flutterweb.bridge.w;
import com.ss.android.lark.todo.impl.flutterweb.bridge.x;
import com.ss.android.lark.todo.impl.flutterweb.bridge.y;
import com.ss.android.lark.todo.impl.flutterweb.bridge.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;
import tb5.i;
import vv4.k;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J \u00103\u001a\u0002042\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030706H\u0016J\u0010\u00108\u001a\u0002042\u0006\u00109\u001a\u00020:H\u0016J\u0006\u0010;\u001a\u000204J\u0012\u0010<\u001a\u0002042\b\u00109\u001a\u0004\u0018\u00010:H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR6\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010)\"\u0004\b2\u0010+¨\u0006="}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/TodoWebPlugin;", "Lcom/ss/android/lark/chameleon/AbsChameleonPlugin;", "todoBiz", "Lcom/ss/android/lark/todo/impl/flutterweb/TodoBiz;", "loadingCallback", "Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader$LoadingCallback;", "renderGoneListener", "Lcom/bytedance/ee/bear/browser/Web$IRenderGoneListener;", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "sourceFragment", "Landroidx/fragment/app/Fragment;", "openTimestamp", "", "canGoBack", "", "<init>", "(Lcom/ss/android/lark/todo/impl/flutterweb/TodoBiz;Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader$LoadingCallback;Lcom/bytedance/ee/bear/browser/Web$IRenderGoneListener;Ljava/util/HashMap;Landroidx/fragment/app/Fragment;JZ)V", "getTodoBiz", "()Lcom/ss/android/lark/todo/impl/flutterweb/TodoBiz;", "getLoadingCallback", "()Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader$LoadingCallback;", "setLoadingCallback", "(Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader$LoadingCallback;)V", "getRenderGoneListener", "()Lcom/bytedance/ee/bear/browser/Web$IRenderGoneListener;", "setRenderGoneListener", "(Lcom/bytedance/ee/bear/browser/Web$IRenderGoneListener;)V", "getParams", "()Ljava/util/HashMap;", "setParams", "(Ljava/util/HashMap;)V", "getSourceFragment", "()Landroidx/fragment/app/Fragment;", "setSourceFragment", "(Landroidx/fragment/app/Fragment;)V", "getOpenTimestamp", "()J", "getCanGoBack", "()Z", "setCanGoBack", "(Z)V", "containerTab", "getContainerTab", "()Ljava/lang/String;", "setContainerTab", "(Ljava/lang/String;)V", "isAttached", "setAttached", "getBridgeHandlers", "", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "changeTaskCenterSelectedTab", "onDetachFromHost", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TodoWebPlugin extends AbsChameleonPlugin {
    private boolean canGoBack;
    private String containerTab;
    private boolean isAttached;
    private IChameleonLoader.LoadingCallback loadingCallback;
    private final long openTimestamp;
    private HashMap<String, String> params;
    private k.a renderGoneListener;
    private Fragment sourceFragment;
    private final TodoBiz todoBiz;

    public static final class a implements View.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TodoWebPlugin f444129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ChameleonPluginHost f444130b;

        public a(TodoWebPlugin r100, ChameleonPluginHost r101) {
            this.f444129a = r100;
            this.f444130b = r101;
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View r100, int r101, KeyEvent r102) {
            if (r102.getAction() == 0) goto L5;
            return false;
        L5:
            if (r101 == 4) goto L7;
            return false;
        L7:
            if (this.f444129a.getCanGoBack() == false) goto L13;
            this.f444130b.getWeb().getWebView().goBack();
            return true;
        L13:
            return false;
        }
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public final void changeTaskCenterSelectedTab() {
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L10
        r100.put("tab", this.containerTab);     // Catch: Throwable -> L10
        k r101 = getHost().getWeb();     // Catch: Throwable -> L10
        if (r101 == null) goto L8;
        WebView r102 = r101.getWebView();     // Catch: Throwable -> L10
        if (r102 == null) goto L8;
        r102.evaluateJavascript("window.callTodoApi(\"taskCenterSelectedTabChangedListener\", " + r100 + ')', null);     // Catch: Throwable -> L10
    L8:
        Log.i("TodoWeb", "task center selected tab changed, tab: " + this.containerTab);     // Catch: Throwable -> L10
        this.containerTab = null;     // Catch: Throwable -> L10
        return;
    L10:
        Log.e("TodoWeb", "task center selected tab changed error");
    }

    public final boolean getCanGoBack() {
        return this.canGoBack;
    }

    public final String getContainerTab() {
        return this.containerTab;
    }

    public final IChameleonLoader.LoadingCallback getLoadingCallback() {
        return this.loadingCallback;
    }

    public final long getOpenTimestamp() {
        return this.openTimestamp;
    }

    public final HashMap<String, String> getParams() {
        return this.params;
    }

    public final k.a getRenderGoneListener() {
        return this.renderGoneListener;
    }

    public final Fragment getSourceFragment() {
        return this.sourceFragment;
    }

    public final TodoBiz getTodoBiz() {
        return this.todoBiz;
    }

    public final boolean isAttached() {
        return this.isAttached;
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        super.getBridgeHandlers(r100);
        Iterator r101 = CollectionsKt.listOf(new AbsChameleonHandler[]{new u(this), new d(this), new v(this), new t(this), new a0(this), new z(this), new y(this), new s(this), new com.ss.android.lark.todo.impl.flutterweb.bridge.c(this), new b0(this), new l(this), new r(this), new h(), new v8c.i(this), new j(), new o(), new e(this), new c0(this), new GetInitialRefResourceForChatCreatingHandler(this), new GetInitialRichSummaryForChatCreatingHandler(this), new w(this), new n(this), new m(this), new e0(), new f0(this), new com.ss.android.lark.todo.impl.flutterweb.bridge.i(), new com.ss.android.lark.todo.impl.flutterweb.bridge.k(this), new GetIsFoldDisplayHandler(this), new f()}).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        AbsChameleonHandler r102 = (AbsChameleonHandler) r101.next();
        r100.put(r102.getName(), r102);
        goto L4
    }

    public void onAttachToHost(ChameleonPluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        this.isAttached = true;
        super.onAttachToHost(r100);
        Log.i("TodoWeb", "onAttachToHost: " + this.todoBiz + ", params: " + this.params);
        IChameleonLoader.LoadingCallback r101 = this.loadingCallback;
        if (r101 == null) goto L5;
        r100.getLoader().addLoadCallback(r101);
    L5:
        k.a r102 = this.renderGoneListener;
        if (r102 == null) goto L10;
        k r103 = r100.getChameleonWeb();
        if (r103 == null) goto L10;
        r103.w(r102);
    L10:
        r100.getWeb().getWebView().getSettings().setTextZoom(100);
        r100.getWeb().getWebView().setOnKeyListener(new a(this, r100));
        if (this.todoBiz == TodoBiz.TaskCenter) goto L14;
        HashMap r104 = new HashMap();
        r104.putAll(this.params);
        r100.getLoader().setRouteState(new RouterState(this.todoBiz.getPath(), r104));
        Log.i("TodoWeb", "setRouteState(path: " + this.todoBiz.getPath() + ", params: " + r104 + ')');
        int r105 = com.ss.android.lark.todo.impl.flutterweb.a.f444131a;
        com.ss.android.lark.todo.impl.flutterweb.a.f(TodoBiz.TaskEmpty);
        return;
    L14:
        if (this.containerTab == null) goto L18;
        changeTaskCenterSelectedTab();
        return;
    }

    public void onDetachFromHost(ChameleonPluginHost r100) {
        Log.i("TodoWeb", "onDetachFromHost " + this.todoBiz.getPath());
        super.onDetachFromHost(r100);
        this.isAttached = false;
        Callback r101 = x.f444217a;
        x.f444217a = null;
        Callback r102 = a0.f444156c;
        a0.f444156c = null;
        Callback r103 = b0.f444162c;
        b0.f444162c = null;
        if (r100 == null) goto L9;
        k r104 = r100.getWeb();
        if (r104 == null) goto L9;
        WebView r105 = r104.getWebView();
        if (r105 == null) goto L9;
        r105.setOnKeyListener(null);
    L9:
        if (r100 == null) goto L18;
        Context r106 = r100.getContext();
        if (r106 != null) goto L13;
        return;
    L13:
        if ((r106 instanceof FragmentActivity) == false) goto L20;
        Fragment r107 = ((FragmentActivity) r106).getSupportFragmentManager().findFragmentByTag("TaskOtherFlutterWebFragment");
        if ((r107 instanceof TaskOtherFlutterWebFragment) == false) goto L21;
        HashMap<String, com.ss.android.lark.todo.impl.flutterweb.bridge.b> r108 = s.f444206c;
        HashMap<String, com.ss.android.lark.todo.impl.flutterweb.bridge.b> r109 = s.f444206c;
        TypeIntrinsics.asMutableMap(r109).remove(((TaskOtherFlutterWebFragment) r107).f444124e);
        return;
    L21:
        return;
    L20:
        return;
    }

    public final void setAttached(boolean r100) {
        this.isAttached = r100;
    }

    public final void setCanGoBack(boolean r100) {
        this.canGoBack = r100;
    }

    public final void setContainerTab(String r100) {
        this.containerTab = r100;
    }

    public final void setLoadingCallback(IChameleonLoader.LoadingCallback r100) {
        this.loadingCallback = r100;
    }

    public final void setParams(HashMap<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.params = r100;
    }

    public final void setRenderGoneListener(k.a r100) {
        this.renderGoneListener = r100;
    }

    public final void setSourceFragment(Fragment r100) {
        this.sourceFragment = r100;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((ChameleonPluginHost) r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r100) {
        onDetachFromHost((ChameleonPluginHost) r100);
    }

    public TodoWebPlugin(TodoBiz r100, IChameleonLoader.LoadingCallback r101, k.a r102, HashMap<String, String> r103, Fragment r104, long r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "todoBiz");
        Intrinsics.checkNotNullParameter(r103, "params");
        this.todoBiz = r100;
        this.loadingCallback = r101;
        this.renderGoneListener = r102;
        this.params = r103;
        this.sourceFragment = r104;
        this.openTimestamp = r105;
        this.canGoBack = r106;
    }

    public /* synthetic */ TodoWebPlugin(TodoBiz r110, IChameleonLoader.LoadingCallback r111, k.a r112, HashMap r113, Fragment r114, long r115, boolean r116, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 32) == 0) goto L5;
        long r100 = System.currentTimeMillis();
    L7:
        if ((r210 & 64) == 0) goto L9;
        boolean r117 = false;
    L10:
        this(r110, r111, r112, r113, r114, r100, r117);
        return;
    L9:
        r117 = r116;
        goto L10
    L5:
        r100 = r115;
        goto L7
    }
}
