package com.bytedance.ee.bear.doc.follow.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProviders;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.doc.follow.FollowInvokeResult;
import com.bytedance.ee.bear.doc.follow.PresentationModuleState;
import com.bytedance.ee.bear.doc.follow.event.ContentEvent;
import com.bytedance.ee.bear.doc.follow.event.KeyboardStateChangedEvent;
import com.bytedance.ee.bear.doc.follow.event.LoadStateChangedEvent;
import com.bytedance.ee.bear.doc.follow.event.OpenLinkEvent;
import com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNFollowEvent;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNFollowEventTypes;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ee.util.observer.DiffObserver;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.vfs.VFSPath;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BaseFollowImpl implements py4.d, LifecycleObserver, sa5.d, rcb.d {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String EMPTY_PARAMS = null;
    private static final int INVOKE_TIMEOUT = 5000;
    protected String TAG;
    private sa5.b backPressDispatcher;
    private qy4.a contentEventHandler;
    private Context context;
    private List<sy4.d> docFollowStateObservers;
    private MediatorLiveData<Boolean> docSubKeyboardPanelActive;
    private int docTypeValue;
    protected String documentToken;
    private LiveData<g45.a> editPanelLiveData;
    protected r followApiV2Delegate;
    private Fragment fragment;
    private boolean isAudioMuted;
    private boolean isGuest;
    private MutableLiveData<Boolean> isKeyboardShowing;
    private boolean isPresenter;
    private boolean isReplay;
    private MediatorLiveData<KeyboardStateChangedEvent> keyBoardChangeEventLiveData;
    private ocb.a keyboardHeightObserver;
    private pcb.a keyboardHeightProvider;
    private CompositeDisposable mCompositeDisposable;
    protected py4.j mFollowBridge;
    private com.bytedance.ee.bear.route.d routeInterceptor;
    private List<Runnable> runnables;

    public class a implements com.bytedance.ee.bear.route.d {
        public final /* synthetic */ BaseFollowImpl a;

        public a(BaseFollowImpl r1) {
            this.a = r1;
        }

        public final boolean b(Context r1, BearUrl r2, RouteBean r3) {
            return this.a.processRouterEvent(r2, r3);
        }
    }

    public class b extends DiffObserver<KeyboardStateChangedEvent> {
        public final /* synthetic */ BaseFollowImpl b;

        public b(BaseFollowImpl r1) {
            this.b = r1;
        }

        public final void a(Object r2) {
            KeyboardStateChangedEvent r3 = (KeyboardStateChangedEvent) r2;
            if (r3 == null) goto L6;
            this.b.processContentEvent(r3);
            return;
        }
    }

    public class c extends h {
        @Override // com.bytedance.ee.bear.doc.follow.impl.BaseFollowImpl.h
        public final void c() {
        }

        public c() {
        }
    }

    public class d extends h {
        @Override // com.bytedance.ee.bear.doc.follow.impl.BaseFollowImpl.h
        public final void c() {
        }

        public d() {
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ BaseFollowImpl b;

        @Override // java.lang.Runnable
        public final void run() {
            py4.j r0 = this.b.mFollowBridge;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.c().b(this.a);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public e(BaseFollowImpl r1, String r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static /* synthetic */ class f {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[VcKeyboardChangeEventProducer.OrientationSwitchMode.values().length];
            a = r0;
            r0[VcKeyboardChangeEventProducer.OrientationSwitchMode.NOT_LIMITED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[VcKeyboardChangeEventProducer.OrientationSwitchMode.ALWAYS_PORTRAIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[VcKeyboardChangeEventProducer.OrientationSwitchMode.ADJUST_BY_KEYBOARD_EVENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class g implements LifecycleObserver, bp5.c.a {
        public final String a;
        public FragmentActivity b;

        public final boolean interceptSetStatusBarColor(Activity r1, int r2, boolean r3) {
            return true;
        }

        public final boolean interceptSetSystemUiVisibility(Activity r1, int r2) {
            return true;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        public void onActivityCreate() {
            bp5.c.b(this.b, this);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onActivityDestroy() {
            String r0 = this.a;
            Map<String, Pair<py4.c, r>> r1 = t.a;
            tt5.a.h("CCMFollow_FragHelper", "removeHost:" + r0);
            ((HashMap) t.a).remove(r0);
            this.b.getLifecycle().removeObserver(this);
            bp5.c.c(this.b, this);
            this.b = null;
        }

        public g(Fragment r1, FragmentActivity r2) {
            this.b = r2;
            this.a = t.b(r1);
        }
    }

    public abstract class h implements py4.k<PresentationModuleState> {
        public abstract void c();

        public h() {
        }

        @Override // py4.k
        public final void b(NonProguard r2) {
            if ((r2 instanceof PresentationModuleState) == false) goto L6;
            PresentationModuleState r3 = (PresentationModuleState) r2;
            c();
            return;
        }

        @Override // py4.k
        public final NonProguard a(Set r2, RNFollowEvent r3) {
            return new PresentationModuleState(s.a(r3.dataJson), s.a(r3.metaJson));
        }
    }

    private void bindFollowEvents() {
        updateInterceptRouterDispatch(true);
        sa5.b r0 = this.backPressDispatcher;
        if (r0 == null) goto L5;
        r0.e(this);
    L5:
        pcb.a r1 = this.keyboardHeightProvider;
        if (r1 == null) goto L9;
        r1.c(this.keyboardHeightObserver);
        return;
    }

    public static /* synthetic */ void k(BaseFollowImpl r0, Boolean r1) {
        r0.lambda$new$3(r1);
    }

    public static /* synthetic */ void l(BaseFollowImpl r0, boolean r1, com.bytedance.ee.bear.route.h r2) {
        r0.lambda$updateInterceptRouterDispatch$8(r1, r2);
    }

    public static /* synthetic */ void m(py4.k r0, RNFollowEvent r1) {
        lambda$startRecord$5(r0, r1);
    }

    public static /* synthetic */ VFSPath n(BaseFollowImpl r0, String r1, float[] r2, String r3) {
        return r0.lambda$getImageByDriveToken$10(r1, r2, r3);
    }

    public static /* synthetic */ void o(BaseFollowImpl r0, pcb.a r1, int r2, int r3) {
        r0.lambda$new$0(r1, r2, r3);
    }

    public static /* synthetic */ void p(BaseFollowImpl r1, FollowInvokeResult r2) {
        r1.lambda$getStates$6(null, r2);
    }

    public static /* synthetic */ void q(BaseFollowImpl r0, g45.a r1) {
        r0.lambda$new$1(r1);
    }

    public static /* synthetic */ void r(BaseFollowImpl r0, IGetDataCallback r1, Throwable r2) {
        r0.lambda$getImageByDriveToken$12(r1, r2);
    }

    public static /* synthetic */ void s(py4.k r0, RNFollowEvent r1) {
        lambda$startRecord$4(r0, r1);
    }

    public static /* synthetic */ void t(BaseFollowImpl r0, IGetDataCallback r1, VFSPath r2) {
        r0.lambda$getImageByDriveToken$11(r1, r2);
    }

    public static /* synthetic */ void u(BaseFollowImpl r0, Throwable r1) {
        r0.lambda$updateInterceptRouterDispatch$9(r1);
    }

    private void unbindFollowEvents() {
        updateInterceptRouterDispatch(false);
        sa5.b r0 = this.backPressDispatcher;
        if (r0 == null) goto L5;
        r0.d(this);
    L5:
        pcb.a r1 = this.keyboardHeightProvider;
        if (r1 == null) goto L8;
        r1.a(this.keyboardHeightObserver);
    L8:
        this.isKeyboardShowing.setValue(Boolean.FALSE);
    }

    public static /* synthetic */ void v(BaseFollowImpl r0, String r1, String r2, String r3, py4.f r4) {
        r0.lambda$invoke$7(r1, r2, r3, r4);
    }

    public static /* synthetic */ void w(BaseFollowImpl r0, Boolean r1) {
        r0.lambda$new$2(r1);
    }

    public boolean interceptKeyboardEvent() {
        return false;
    }

    public void registerBaseRNEventHandler() {
    }

    public void startReplay() {
        this.isPresenter = false;
        this.isReplay = true;
        invoke("startReplay");
        notifyDocFollowStateChanged(new sy4.f(false, this.isGuest));
        if (this.context == null) goto L6;
        notifyDocFollowStateChanged(new sy4.e(this.isPresenter, this.isReplay));
        return;
    }

    public void stopRecord() {
        this.isPresenter = false;
        if (this.context == null) goto L5;
        notifyDocFollowStateChanged(new sy4.e(false, this.isReplay));
    L5:
        invoke("stopRecord");
        this.mFollowBridge.i(this.documentToken, "", RNFollowEventTypes.NEW_ACTIONS.name());
        this.mFollowBridge.i(this.documentToken, "", RNFollowEventTypes.NEW_PATCHES.name());
        rcb.c.c(this.context);
    }

    public void stopReplay() {
        this.isPresenter = false;
        this.isReplay = false;
        invoke("stopReplay");
        if (this.context == null) goto L6;
        notifyDocFollowStateChanged(new sy4.f(true, this.isGuest));
        notifyDocFollowStateChanged(new sy4.e(this.isPresenter, this.isReplay));
        return;
    }

    static {
        EMPTY_PARAMS = null;
    }

    private void notifyDocSubKeyboardPanelActiveChanged() {
        g45.a r0 = (g45.a) this.editPanelLiveData.getValue();
        boolean r2 = true;
        if ((r0 instanceof VcKeyboardChangeEventProducer) == false) goto L17;
        VcKeyboardChangeEventProducer.VcBottomBarPolicy r1 = ((VcKeyboardChangeEventProducer) r0).getVcBottomBarPolicy();
        if (r1 != VcKeyboardChangeEventProducer.VcBottomBarPolicy.ALWAYS_SHOW) goto L8;
        this.docSubKeyboardPanelActive.setValue(Boolean.FALSE);
        return;
    L8:
        if (r1 != VcKeyboardChangeEventProducer.VcBottomBarPolicy.ALWAYS_HIDE) goto L11;
        this.docSubKeyboardPanelActive.setValue(Boolean.TRUE);
        return;
    L11:
        if (r1 != VcKeyboardChangeEventProducer.VcBottomBarPolicy.ADJUST_BY_KEYBOARD) goto L25;
        MediatorLiveData<Boolean> r3 = this.docSubKeyboardPanelActive;
        if (this.isKeyboardShowing.getValue() == Boolean.TRUE) goto L16;
        r2 = false;
    L16:
        r3.setValue(Boolean.valueOf(r2));
        return;
    L25:
        return;
    L17:
        MediatorLiveData<Boolean> r4 = this.docSubKeyboardPanelActive;
        if (this.isKeyboardShowing.getValue() == Boolean.TRUE) goto L21;
        r2 = false;
    L21:
        r4.setValue(Boolean.valueOf(r2));
    }

    @Override // sa5.d
    public boolean onBackPressed() {
        sa5.d r0 = this.fragment;
        if ((r0 instanceof sa5.d) == true) goto L5;
        return false;
    L5:
        if (r0.onBackPressed() == false) goto L10;
        tt5.a.h(this.TAG, "Back press consumed by :" + this.fragment);
        return true;
    L10:
        return false;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onFragmentCreate() {
        tt5.a.h(this.TAG, "onFragmentCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onFragmentDestroy() {
        tt5.a.h(this.TAG, "onFragmentDestroy");
        this.fragment = null;
        this.context = null;
        unregisterBaseRNEventHandler();
        this.mFollowBridge.a(this.documentToken);
        r r1 = this.followApiV2Delegate;
        if (r1 == null) goto L16;
        monitor-enter(r1);
    L13:
        th = move-exception;
        throw th;
    L6:
        if (this != r1.b) goto L10;
        tt5.a.h("CCMFollow_FollowApiV2Delegate", "removeFollowApiV2 clearAllFollowImpl");     // Catch: Throwable -> L13
        r1.b = null;     // Catch: Throwable -> L13
        ((CopyOnWriteArrayList) r1.a).clear();     // Catch: Throwable -> L13
        monitor-exit(r1);
    L24:
        goto L16
    L10:
        tt5.a.h("CCMFollow_FollowApiV2Delegate", "removeFollowApiV2 removeChildFollowImpl");     // Catch: Throwable -> L13
        ((CopyOnWriteArrayList) r1.a).remove(this);     // Catch: Throwable -> L13
        monitor-exit(r1);
    L16:
        ((ArrayList) rcb.c.a).remove(this);
        this.mCompositeDisposable.clear();
        Iterator<Runnable> r0 = this.runnables.iterator();
    L18:
        if (r0.hasNext() == false) goto L22;
        Runnable r2 = r0.next();
        if (r2 == null) goto L18;
        com.bytedance.ee.util.ui.j.e(r2);
        goto L18
    L22:
        this.runnables.clear();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onFragmentPause() {
        tt5.a.h(this.TAG, "onFragmentPause");
        unbindFollowEvents();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onFragmentResume() {
        tt5.a.h(this.TAG, "onFragmentResume");
        bindFollowEvents();
    }

    public void unregisterBaseRNEventHandler() {
        this.mFollowBridge.i(this.documentToken, "", RNFollowEventTypes.NEW_ACTIONS.name());
        this.mFollowBridge.i(this.documentToken, "", RNFollowEventTypes.NEW_PATCHES.name());
        this.mFollowBridge.i(this.documentToken, "", RNFollowEventTypes.PRESENTER_FOLLOWER_LOCATION.name());
    }

    @Override // py4.d
    public py4.j getFollowBridge() {
        return this.mFollowBridge;
    }

    @Override // py4.d
    public boolean isAudioMuted() {
        return this.isAudioMuted;
    }

    @Override // py4.d
    public boolean isPresenter() {
        return this.isPresenter;
    }

    public boolean isReplay() {
        return this.isReplay;
    }

    private void invoke(String r3) {
        invoke(r3, EMPTY_PARAMS, null);
    }

    private /* synthetic */ void lambda$new$1(g45.a r3) {
        if (Boolean.TRUE.equals(this.isKeyboardShowing.getValue()) == false) goto L7;
        if (r3 != null) goto L7;
        boolean r4 = false;
    L8:
        if (r4 == false) goto L11;
        notifyDocSubKeyboardPanelActiveChanged();
        return;
    L11:
        return;
    L7:
        r4 = true;
        goto L8
    }

    private /* synthetic */ void lambda$new$2(Boolean r1) {
        notifyDocSubKeyboardPanelActiveChanged();
    }

    private /* synthetic */ void lambda$new$3(Boolean r5) {
        g45.a r0 = (g45.a) this.editPanelLiveData.getValue();
        boolean r2 = false;
        if (r5 != Boolean.TRUE) goto L5;
        boolean r6 = true;
    L7:
        if ((r0 instanceof VcKeyboardChangeEventProducer) == false) goto L9;
        VcKeyboardChangeEventProducer.OrientationSwitchMode r1 = ((VcKeyboardChangeEventProducer) r0).getOrientationSwitchMode();
    L10:
        int r3 = f.a[r1.ordinal()];
        if (r3 != 1) goto L13;
    L16:
        KeyboardStateChangedEvent r4 = new KeyboardStateChangedEvent(r6, r2);
        this.keyBoardChangeEventLiveData.setValue(r4);
        return;
    L13:
        if (r3 == 2) goto L15;
        r2 = r6;
        goto L16
    L15:
        r2 = true;
        goto L16
    L9:
        r1 = VcKeyboardChangeEventProducer.OrientationSwitchMode.ADJUST_BY_KEYBOARD_EVENT;
        goto L10
    L5:
        r6 = false;
        goto L7
    }

    private void lambda$updateInterceptRouterDispatch$9(Throwable r4) throws Exception {
        tt5.a.e(this.TAG, "Get RouteService err resume!", r4, false);
    }

    private String objArrayToJsonArray(String[] r4) {
        StringBuilder r0 = new StringBuilder("[");
        int r1 = 0;
    L4:
        if (r1 >= r4.length) goto L9;
        r0.append(r4[r1]);
        if (r1 == (r4.length - 1)) goto L8;
        r0.append(',');
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        r0.append(']');
        return r0.toString();
    }

    private void updateInterceptRouterDispatch(final boolean r3) {
        Flowable.just((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).subscribe(new com.bytedance.ee.bear.doc.follow.impl.e(this, r3), new i(this));
    }

    public void getStates(py4.d.a r3) {
        invoke("getCurrentStatus", EMPTY_PARAMS, new j(this));
    }

    public void notifyDocFollowStateChanged(sy4.b r4) {
        tt5.a.h(this.TAG, "notifyDocFollowStateChanged:" + r4);
        Iterator<sy4.d> r0 = this.docFollowStateObservers.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().a(r4);
        goto L4
    }

    public void parseVCFollowCallback(String r6) {
        r r0 = this.followApiV2Delegate;
        if (r0 == null) goto L39;
        r0.getClass();
        if (r6 == null) goto L43;
        JSONObject r7 = JSON.parseObject(r6);     // Catch: Exception -> L33
        String r2 = r7.getString(JSEventListener.ACTION);     // Catch: Exception -> L33
        if ("vcfollow.onInvokeResult".equals(r2) == false) goto L21;
        FollowInvokeResult r8 = (FollowInvokeResult) r7.getObject("data", FollowInvokeResult.class);     // Catch: Exception -> L33
        if (TextUtils.isEmpty(r8.callbackId) == false) goto L13;
        tt5.a.k("CCMFollow_FollowApiV2Delegate", "onInvokeResult no callbackId");     // Catch: Exception -> L33
        return;
    L13:
        py4.d r3 = r0.b;     // Catch: Exception -> L33
        if (r3 == null) goto L16;
        r3.getFollowBridge().b(r8);     // Catch: Exception -> L33
    L16:
        Iterator r1 = ((CopyOnWriteArrayList) r0.a).iterator();     // Catch: Exception -> L33
    L18:
        if (r1.hasNext() == false) goto L44;
        ((py4.d) r1.next()).getFollowBridge().b(r8);     // Catch: Exception -> L33
        goto L18
    L44:
        return;
    L21:
        if ("vcfollow.onEvent".equals(r2) == false) goto L41;
        RNFollowEvent r9 = (RNFollowEvent) r7.getObject("data", RNFollowEvent.class);     // Catch: Exception -> L33
        if (r9 != null) goto L25;
        tt5.a.k("CCMFollow_FollowApiV2Delegate", "onEvent no data");     // Catch: Exception -> L33
        return;
    L25:
        py4.d r4 = r0.b;     // Catch: Exception -> L33
        NonProguard r5 = null;
        if (r4 == null) goto L28;
        r5 = r0.k(r4, r9, null);     // Catch: Exception -> L33
    L28:
        Iterator r10 = ((CopyOnWriteArrayList) r0.a).iterator();     // Catch: Exception -> L33
    L30:
        if (r10.hasNext() == false) goto L45;
        r5 = r0.k((py4.d) r10.next(), r9, r5);     // Catch: Exception -> L33
        goto L30
    L45:
        return;
    L41:
        return;
    L33:
        e = move-exception;
        tt5.a.e("CCMFollow_FollowApiV2Delegate", "parseVCFollowCallback", e, false);
        return;
    L43:
        return;
    }

    public boolean processContentEvent(ContentEvent r5) {
        if ((r5 instanceof LoadStateChangedEvent) == true) goto L5;
    L7:
        tt5.a.h(this.TAG, String.format("processContentEvent:%s,processed?%b,hasHandler?%b", new Object[]{r5.toString(), false, false}));
        return false;
    L5:
        if (((LoadStateChangedEvent) r5).getLoadState() != LoadStateChangedEvent.LoadState.LoadSuccess) goto L7;
        registerBaseRNEventHandler();
        goto L7
    }

    public void registerDocFollowStateObserver(sy4.d r2) {
        if (this.docFollowStateObservers.contains(r2) == true) goto L6;
        this.docFollowStateObservers.add(r2);
        return;
    }

    @Override // py4.d
    public void setAudioMute(boolean r4) {
        tt5.a.b(this.TAG, "setAudioMute...: " + r4);
        this.isAudioMuted = r4;
        if (this.context == null) goto L6;
        notifyDocFollowStateChanged(new sy4.a(r4));
        return;
    }

    public void setContentEventHandler(qy4.a r4) {
        tt5.a.h(this.TAG, "setContentEventHandler:" + r4);
    }

    @Override // py4.d
    public void setPresenter(boolean r1) {
        this.isPresenter = r1;
    }

    public void unregisterDocFollowStateObserver(sy4.d r2) {
        this.docFollowStateObservers.remove(r2);
    }

    public void unregisterRNEventHandler(String r4) {
        this.mFollowBridge.i(this.documentToken, "", r4);
    }

    private /* synthetic */ void lambda$getImageByDriveToken$11(IGetDataCallback r3, VFSPath r4) throws Exception {
        tt5.a.h(this.TAG, "getImageByDriveToken success");
        r3.onSuccess(r4);
    }

    private void lambda$getImageByDriveToken$12(IGetDataCallback r3, Throwable r4) throws Exception {
        tt5.a.f(this.TAG, r4, false);
        r3.onError(new ErrorResult(-1));
    }

    private /* synthetic */ void lambda$getStates$6(py4.d.a r1, FollowInvokeResult r2) {
        returnGetStatesResult(r2, r1);
    }

    private static /* synthetic */ void lambda$startRecord$4(py4.k r1, RNFollowEvent r2) {
        r1.b(r1.a(null, r2));
    }

    private static /* synthetic */ void lambda$startRecord$5(py4.k r1, RNFollowEvent r2) {
        r1.b(r1.a(null, r2));
    }

    private /* synthetic */ void lambda$updateInterceptRouterDispatch$8(boolean r1, com.bytedance.ee.bear.route.h r2) throws Exception {
        if (r1 == false) goto L4;
        r2.Td(this.routeInterceptor);
        return;
    L4:
        r2.s5(this.routeInterceptor);
    }

    private void returnGetStatesResult(FollowInvokeResult r3, py4.d.a r4) {
    L10:
        e = move-exception;
        tt5.a.e(this.TAG, "returnGetStatesResult", e, false);
        return;
    L3:
        if (TextUtils.isEmpty(r3.resultJson) == true) goto L6;
        List r0 = JSON.parseArray(r3.resultJson, String.class);     // Catch: Exception -> L10
        String[] r1 = (String[]) r0.toArray(new String[r0.size()]);     // Catch: Exception -> L10
    L6:
        if (TextUtils.isEmpty(r3.metaJson) == true) goto L8;
        List r5 = JSON.parseArray(r3.metaJson, String.class);     // Catch: Exception -> L10
        String[] r6 = (String[]) r5.toArray(new String[r5.size()]);     // Catch: Exception -> L10
    L8:
        r4.a();     // Catch: Exception -> L10
    }

    private boolean shouldIntercept(String r3, RouteBean r4) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return false;
    L6:
        if (r3.startsWith("http:") == true) goto L11;
        if (r3.startsWith("https:") == true) goto L11;
        return false;
    L11:
        if (r3.contains("VideoConference") == false) goto L14;
        return false;
    L14:
        if (r3.endsWith("#history") == false) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == false) goto L19;
        return false;
    L19:
        if (r4 == null) goto L25;
        Bundle r6 = r4.n;
        if (r6 == null) goto L25;
        if (r6.getBoolean("vc_intercept", true) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        r5 = false;
        goto L17
    }

    @Override // py4.b
    public void onCallVCFollow(String r2, NonProguard r3) {
        r r0 = this.followApiV2Delegate;
        if (r0 == null) goto L6;
        r0.onCallVCFollow(r2, r3);
        return;
    }

    public boolean processRouterEvent(String r4, RouteBean r5) {
        boolean r6 = shouldIntercept(r4, r5);
        tt5.a.h(this.TAG, "should intercept url?" + du5.b.g(r4));
        if (r6 == true) goto L5;
    L7:
        return false;
    L5:
        if (processContentEvent(new OpenLinkEvent(r4)) == false) goto L7;
        return true;
    }

    public void registerRNEventHandler(String r7, ry4.a r8) {
        this.mFollowBridge.f(this.documentToken, null, r7, r8, true);
    }

    public void setStates(String[] r3, String r4) {
        tt5.a.b(this.TAG, "setStates...");
        if (r3 != null) goto L5;
    L9:
        tt5.a.b(this.TAG, "setStates Empty !");
        return;
    L5:
        if (r3.length == 0) goto L9;
        invoke("replayActions", objArrayToJsonArray(r3), r4, null);
    }

    public void startRecord(py4.d.a r6, String[] r7) {
        this.isPresenter = true;
        if (r7 != null) goto L5;
    L8:
        tt5.a.b(this.TAG, "startRecord: followStates is empty");
        invoke("startRecord");
    L9:
        final c r8 = new c();
        final d r0 = new d();
        py4.a r1 = new py4.a(this.documentToken, "", RNFollowEventTypes.NEW_ACTIONS.name(), true);
        this.mFollowBridge.j(r8, new o(r8), r1);
        py4.a r9 = new py4.a(this.documentToken, "", RNFollowEventTypes.NEW_PATCHES.name(), true);
        this.mFollowBridge.j(r0, new p(r0), r9);
        Context r10 = this.context;
        if (r10 == null) goto L15;
        if (r10.getResources().getConfiguration().orientation == 2) goto L15;
        notifyDocFollowStateChanged(new sy4.f(true, this.isGuest));
    L15:
        if (this.context == null) goto L17;
        notifyDocFollowStateChanged(new sy4.e(this.isPresenter, this.isReplay));
    L17:
        rcb.c.c(this.context);
        return;
    L5:
        if (r7.length == 0) goto L8;
        invoke("startRecord", objArrayToJsonArray(r7), null);
        goto L9
    }

    public boolean processRouterEvent(BearUrl r1, RouteBean r2) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (processRouterEvent(r1.e, r2) == false) goto L6;
        return true;
    }

    private VFSPath lambda$getImageByDriveToken$10(String r4, float[] r5, String r6) throws Exception {
        ConnectionService.NetworkState r7 = com.bytedance.ee.bear.contract.j.a.a.getNetworkState();
        w85.c r0 = (w85.c) org.koin.java.a.a(w85.c.class);
        w85.a.C0319a r1 = new w85.a.C0319a();
        boolean r2 = false;
        r1.a = false;
        r1.e = r4;
        r1.b = DownloadRequestInfo.DownloadType.IMG;
        if (r7.a() == false) goto L5;
        r2 = true;
    L5:
        r1.c = r2;
        r1.h = this.documentToken;
        r1.i = this.docTypeValue;
        r1.g = ((com.bytedance.ee.bear.f) org.koin.java.a.a(com.bytedance.ee.bear.f.class)).c(this.docTypeValue);
        w85.b r8 = r0.d(new w85.a(r1));
        if (r8.b != null) goto L8;
        VFSPath r9 = null;
    L9:
        if (r9 == null) goto L13;
        return lu5.a.c(r9, ay4.c.b(Biz.DOCS, "imageViewerCache"), r5, 0.0f);
    L13:
        throw new Exception("originImgPath is null");
    L8:
        r9 = ay4.d.a().t(r8.b);
        goto L9
    }

    private /* synthetic */ void lambda$new$0(pcb.a r3, int r4, int r5) {
        tt5.a.h(this.TAG, "BaseFollowImpl keyboardHeightObserver  keyboardHeight: " + r4 + " orientation: " + r5);
        MutableLiveData<Boolean> r6 = this.isKeyboardShowing;
        if (r4 <= 0) goto L5;
        boolean r7 = true;
    L6:
        r6.setValue(Boolean.valueOf(r7));
        return;
    L5:
        r7 = false;
        goto L6
    }

    public void getImageByDriveToken(final String r3, final float[] r4, final IGetDataCallback<VFSPath> r5) {
        tt5.a.h(this.TAG, "getImageByDriveToken...");
        Disposable r6 = Flowable.just("").observeOn(fo5.d.b()).map(new com.bytedance.ee.bear.doc.follow.impl.f(this, r3, r4)).observeOn(fo5.d.d()).subscribe(new com.bytedance.ee.bear.doc.follow.impl.g(this, r5), new com.bytedance.ee.bear.doc.follow.impl.h(this, r5));
        this.mCompositeDisposable.add(r6);
    }

    public void invoke(String r2, String r3, py4.f r4) {
        invoke(r2, r3, null, r4);
    }

    @Override // py4.b
    public void onCallVCFollow(String r2, NonProguard r3, ry4.a r4) {
        r r0 = this.followApiV2Delegate;
        if (r0 == null) goto L6;
        r0.onCallVCFollow(r2, r3, r4);
        return;
    }

    public BaseFollowImpl(Fragment r5, String r6, int r7, py4.j r8) {
        this.TAG = "CCMFollow_impl#" + Integer.toHexString(hashCode());
        this.docTypeValue = sbb.e.e.b;
        this.docFollowStateObservers = new ArrayList();
        this.runnables = new ArrayList();
        this.routeInterceptor = new a(this);
        this.isKeyboardShowing = new MutableLiveData();
        this.keyboardHeightObserver = new k(this);
        this.docSubKeyboardPanelActive = new MediatorLiveData();
        this.keyBoardChangeEventLiveData = new MediatorLiveData();
        this.mCompositeDisposable = new CompositeDisposable();
        tt5.a.h(this.TAG, "constructed");
        this.fragment = r5;
        this.context = r5.getContext();
        this.mFollowBridge = r8;
        this.documentToken = r6;
        this.docTypeValue = r7;
        this.isGuest = ((b0) org.koin.java.a.a(b0.class)).b();
        tt5.a.h(this.TAG, "BaseFollowImpl is guest " + this.isGuest + " process name " + eu5.g.c());
        String r9 = t.b(r5);
        Pair r10 = (Pair) ((HashMap) t.a).get(r9);
        if (r10 != null) goto L5;
        tt5.a.d("CCMFollow_FragHelper", "extractFollowApiHost no host:" + r9);
    L5:
        if (r10 != null) goto L7;
        tt5.a.m(this.TAG, new IllegalStateException("Follow host not found !"));
    L30:
        FragmentActivity r11 = r5.getActivity();
        r11.getLifecycle().addObserver(new g(r5, r11));
        r5.getLifecycle().addObserver(this);
        this.backPressDispatcher = (sa5.b) sa5.m.a.a(r11, sa5.b.class);
        this.keyboardHeightProvider = pcb.a.a.b(r11);
        ArrayList r12 = (ArrayList) rcb.c.a;
        if (r12.contains(this) == true) goto L33;
        r12.add(this);
    L33:
        LiveData<g45.a> r13 = ((EditPanelsManager) ViewModelProviders.of(r11).get(EditPanelsManager.class)).getActiveEditPanel();
        this.editPanelLiveData = r13;
        this.docSubKeyboardPanelActive.addSource(r13, new l(this));
        this.docSubKeyboardPanelActive.addSource(this.isKeyboardShowing, new m(this));
        this.keyBoardChangeEventLiveData.addSource(this.docSubKeyboardPanelActive, new n(this));
        this.keyBoardChangeEventLiveData.observe(r5, new b(this));
        return;
    L7:
        py4.c r14 = (py4.c) r10.first;
        r r16 = (r) r10.second;
        this.followApiV2Delegate = r16;
        monitor-enter(r16);
        boolean r0 = this instanceof AttachmentFollowImpl;     // Catch: Throwable -> L35
        if (r0 == false) goto L24;
        py4.d r1 = r16.b;     // Catch: Throwable -> L35
        boolean r2 = true;
        if (r1 != null) goto L14;
    L16:
        boolean r3 = false;
    L17:
        setPresenter(r3);     // Catch: Throwable -> L35
        py4.d r4 = r16.b;     // Catch: Throwable -> L35
        if (r4 != null) goto L20;
    L22:
        r2 = false;
    L23:
        setAudioMute(r2);     // Catch: Throwable -> L35
        ((CopyOnWriteArrayList) r16.a).add(this);     // Catch: Throwable -> L35
    L25:
        tt5.a.h("CCMFollow_FollowApiV2Delegate", "addFollowApiV2: isFollowApiCreated = " + r0);     // Catch: Throwable -> L35
        monitor-exit(r16);
        if (r0 == true) goto L29;
        r14.a();
    L29:
        tt5.a.h(this.TAG, "Follow host bind ok");
        goto L30
    L20:
        if (r4.isAudioMuted() == false) goto L22;
    L14:
        if (r1.isPresenter() == false) goto L16;
        r3 = true;
        goto L17
    L24:
        r16.b = this;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$invoke$7(String r1, String r2, String r3, py4.f r4) {
        onInvoke(r1, r2, r3, r4);
    }

    public void invoke(final String r8, final String r9, final String r10, final py4.f r11) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        tt5.a.m(this.TAG, new IllegalStateException("invoke with bad funcName"));
        return;
    L5:
        com.bytedance.ee.util.ui.j.f(new q(this, r8, r9, r10, r11));
    }

    public void onInvoke(String r7, String r8, String r9, py4.f r10) {
        e r11 = new e(this, this.mFollowBridge.e(this.documentToken, r7, r8, r9, r10));
        if (r10 == null) goto L6;
        this.runnables.add(r11);
        com.bytedance.ee.util.ui.j.d(r11, 5000);
        return;
    }
}
