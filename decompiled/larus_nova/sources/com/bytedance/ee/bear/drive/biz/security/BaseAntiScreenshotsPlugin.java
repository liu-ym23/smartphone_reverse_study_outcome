package com.bytedance.ee.bear.drive.biz.security;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.AntiScreenshotsViewModel;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.biz.extra_info.meta.DriveMetaInfoVM;
import com.bytedance.ee.bear.drive.biz.permission.DrivePermissionViewModel;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.lark.dependency.i0;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b*\u0002),\b&\u0018\u0000 >2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000bH\u0002J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u000bH\u0002J\b\u0010&\u001a\u00020\u0006H\u0002J\b\u0010'\u001a\u00020\u0006H\u0002J\b\u0010.\u001a\u00020\"H\u0002J\u0010\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020\u000bH\u0002J\u0012\u00101\u001a\u00020\u000b2\b\b\u0002\u00102\u001a\u00020\u000bH\u0002J\u0012\u00103\u001a\u00020\"2\b\u00104\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u00105\u001a\u00020\"2\b\u00104\u001a\u0004\u0018\u00010\u00022\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u001c\u00108\u001a\u00020\"2\b\u00104\u001a\u0004\u0018\u00010\u00022\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0012\u00109\u001a\u00020\"2\b\u00104\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010:\u001a\u00020\u000bH\u0002J\b\u0010;\u001a\u00020\"H\u0002J\b\u0010<\u001a\u00020\"H\u0002J\u0012\u0010=\u001a\u00020\"2\b\u00104\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0004\n\u0002\u0010*R\u0010\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0004\n\u0002\u0010-¨\u0006?"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/security/BaseAntiScreenshotsPlugin;", "Lcom/bytedance/ee/bear/browser/plugin/BasePlugin;", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "driveCopyPerm", "Landroidx/lifecycle/MutableLiveData;", "", "getDriveCopyPerm", "()Landroidx/lifecycle/MutableLiveData;", "escapePerm", "getEscapePerm", "isOfflinePermissionScreenshot", "()Z", "canCopy", "attached", "isShown", "contentContainer", "Landroid/view/ViewGroup;", "enableScreenshotsLivaData", "", "windowFocused", "viewTreeObserverRef", "Ljava/lang/ref/WeakReference;", "Landroid/view/ViewTreeObserver;", "driveCopyPermObserver", "Landroidx/lifecycle/Observer;", "escapeObserver", "dlpPermObserver", "onPermissionCheck", "", "it", "setCopyState", "newCanCopy", "getTenantId", "getUserId", "onGlobalLayoutListener", "com/bytedance/ee/bear/drive/biz/security/BaseAntiScreenshotsPlugin$onGlobalLayoutListener$1", "Lcom/bytedance/ee/bear/drive/biz/security/BaseAntiScreenshotsPlugin$onGlobalLayoutListener$1;", "loadListener", "com/bytedance/ee/bear/drive/biz/security/BaseAntiScreenshotsPlugin$loadListener$1", "Lcom/bytedance/ee/bear/drive/biz/security/BaseAntiScreenshotsPlugin$loadListener$1;", "updateScreenshotsEnable", "setScreenshotsEnable", "enable", "checkWindowFocus", "log", "onAttachToHost", "host", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "onDetachFromHost", "getCurrentActivityEnable", "recordStateWhenAttach", "restoreStateWhenDetach", WidgetCostModule.TYPE_ON_START, "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseAntiScreenshotsPlugin extends BasePlugin<DrivePluginHost> {
    public static final a Companion = null;
    private static final int FLAG_STATE_NONE = -1;
    private static final int FLAG_STATE_ORIGINAL = 0;
    private static final String SCS_FLAG_STATE = "SCS_FLAG_STATE";
    private static final Map<Integer, Integer> attachedPluginCountMap = null;
    private static final Map<Integer, Integer> originScsFlagStateMap = null;
    private final String TAG;
    private boolean attached;
    private boolean canCopy;
    private ViewGroup contentContainer;
    private final Observer<Boolean> dlpPermObserver;
    private final MutableLiveData<Boolean> driveCopyPerm;
    private final Observer<Boolean> driveCopyPermObserver;
    private MutableLiveData<Integer> enableScreenshotsLivaData;
    private final Observer<Boolean> escapeObserver;
    private final MutableLiveData<Boolean> escapePerm;
    private final boolean isOfflinePermissionScreenshot;
    private boolean isShown;
    private final e loadListener;
    private final g onGlobalLayoutListener;
    private WeakReference<ViewTreeObserver> viewTreeObserverRef;
    private boolean windowFocused;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseAntiScreenshotsPlugin f223823a;

        public b(BaseAntiScreenshotsPlugin r100) {
            this.f223823a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            boolean r101 = ((Boolean) r100).booleanValue();
            tt5.a.h(this.f223823a.getTAG(), "dlpPermObserver");
            BaseAntiScreenshotsPlugin.access$onPermissionCheck(this.f223823a, r101);
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseAntiScreenshotsPlugin f223824a;

        public c(BaseAntiScreenshotsPlugin r100) {
            this.f223824a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            boolean r101 = ((Boolean) r100).booleanValue();
            tt5.a.h(this.f223824a.getTAG(), "driveCopyPermObserver");
            BaseAntiScreenshotsPlugin.access$onPermissionCheck(this.f223824a, r101);
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseAntiScreenshotsPlugin f223825a;

        public d(BaseAntiScreenshotsPlugin r100) {
            this.f223825a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            boolean r101 = ((Boolean) r100).booleanValue();
            if (r101 == false) goto L6;
            BaseAntiScreenshotsPlugin.access$setCopyState(this.f223825a, r101);
            return;
        }
    }

    public static final class e extends u75.b.C7844b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseAntiScreenshotsPlugin f223826a;

        public e(BaseAntiScreenshotsPlugin r100) {
            this.f223826a = r100;
        }

        @Override // u75.b.C7844b, u75.b.a
        public final <T> void a(InfoCode r100, T r101) {
            Intrinsics.checkNotNullParameter(r100, "code");
            if (r100 != InfoCode.OnAttach) goto L15;
            tt5.a.h(this.f223826a.getTAG(), "onInfo()... OnAttach ");
            BaseAntiScreenshotsPlugin.access$setAttached$p(this.f223826a, true);
            ViewGroup r102 = BaseAntiScreenshotsPlugin.access$getContentContainer$p(this.f223826a);
            if (r102 == null) goto L9;
            ViewTreeObserver r103 = r102.getViewTreeObserver();
            if (r103 == null) goto L9;
            r103.addOnGlobalLayoutListener(BaseAntiScreenshotsPlugin.access$getOnGlobalLayoutListener$p(this.f223826a));
        L9:
            BaseAntiScreenshotsPlugin r104 = this.f223826a;
            ViewGroup r105 = BaseAntiScreenshotsPlugin.access$getContentContainer$p(this.f223826a);
            if (r105 == null) goto L12;
            ViewTreeObserver r106 = r105.getViewTreeObserver();
        L13:
            BaseAntiScreenshotsPlugin.access$setViewTreeObserverRef$p(r104, new WeakReference(r106));
            BaseAntiScreenshotsPlugin.access$updateScreenshotsEnable(this.f223826a);
            return;
        L12:
            r106 = null;
            goto L13
        L15:
            if (r100 != InfoCode.OnDetach) goto L30;
            tt5.a.h(this.f223826a.getTAG(), "onInfo()... OnDetach ");
            BaseAntiScreenshotsPlugin.access$setAttached$p(this.f223826a, false);
            ViewGroup r107 = BaseAntiScreenshotsPlugin.access$getContentContainer$p(this.f223826a);
            if (r107 == null) goto L21;
            ViewTreeObserver r108 = r107.getViewTreeObserver();
            if (r108 == null) goto L21;
            r108.removeOnGlobalLayoutListener(BaseAntiScreenshotsPlugin.access$getOnGlobalLayoutListener$p(this.f223826a));
        L21:
            WeakReference r109 = BaseAntiScreenshotsPlugin.access$getViewTreeObserverRef$p(this.f223826a);
            if (r109 == null) goto L31;
            ViewTreeObserver r110 = (ViewTreeObserver) r109.get();
            if (r110 == null) goto L32;
            BaseAntiScreenshotsPlugin r111 = this.f223826a;
            if (r110.isAlive() == false) goto L33;
            r110.removeOnGlobalLayoutListener(BaseAntiScreenshotsPlugin.access$getOnGlobalLayoutListener$p(r111));
            return;
        L33:
            return;
        L32:
            return;
        L31:
            return;
        }
    }

    public static final class f implements ViewTreeObserver.OnWindowFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseAntiScreenshotsPlugin f223827a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t f223828b;

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public final void onWindowFocusChanged(boolean r100) {
            if (r100 == false) goto L5;
            tt5.a.h(this.f223827a.getTAG(), "onWindowFocusChanged true");
            BaseAntiScreenshotsPlugin.access$setWindowFocused$p(this.f223827a, true);
            this.f223828b.getContentView().getViewTreeObserver().removeOnWindowFocusChangeListener(this);
            BaseAntiScreenshotsPlugin.access$updateScreenshotsEnable(this.f223827a);
            return;
        }

        public f(BaseAntiScreenshotsPlugin r100, t r101) {
            this.f223827a = r100;
            this.f223828b = r101;
        }
    }

    public static final class g implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseAntiScreenshotsPlugin f223829a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (BaseAntiScreenshotsPlugin.access$getContentContainer$p(this.f223829a) != null) goto L6;
            tt5.a.k(this.f223829a.getTAG(), "onGlobalLayoutListener()... contentContainer is null!");
            return;
        L6:
            ViewGroup r100 = BaseAntiScreenshotsPlugin.access$getContentContainer$p(this.f223829a);
            Intrinsics.checkNotNull(r100);
            if (r100.isShown() == false) goto L11;
            ViewGroup r101 = BaseAntiScreenshotsPlugin.access$getContentContainer$p(this.f223829a);
            Intrinsics.checkNotNull(r101);
            if (r101.getChildCount() <= 0) goto L11;
            boolean r102 = true;
        L13:
            if (r102 == BaseAntiScreenshotsPlugin.access$isShown$p(this.f223829a)) goto L16;
            BaseAntiScreenshotsPlugin.access$setShown$p(this.f223829a, r102);
            tt5.a.h(this.f223829a.getTAG(), "isShown changed " + BaseAntiScreenshotsPlugin.access$isShown$p(this.f223829a));
            BaseAntiScreenshotsPlugin.access$updateScreenshotsEnable(this.f223829a);
            return;
        L16:
            return;
        L11:
            r102 = false;
            goto L13
        }

        public g(BaseAntiScreenshotsPlugin r100) {
            this.f223829a = r100;
        }
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    static {
        Companion = new a();
        attachedPluginCountMap = new LinkedHashMap();
        originScsFlagStateMap = new LinkedHashMap();
    }

    private final String getTenantId() {
        w75.c r100 = getHost().f224125c.getIFileModel();     // Catch: Throwable -> L10
        if (r100 == null) goto L14;
        String r101 = r100.a();     // Catch: Throwable -> L10
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L14:
        return "";
    L10:
        tt5.a.d(getTAG(), "get tenantId");
        return "";
    }

    private final String getUserId() {
        u55.a r100 = ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).getLiveMetaInfo().getValue();     // Catch: Throwable -> L10
        if (r100 == null) goto L8;
        DocMetaInfo r101 = r100.f548839b;     // Catch: Throwable -> L10
        if (r101 == null) goto L8;
        String r102 = r101.getOwnerUid();     // Catch: Throwable -> L10
        if (r102 == null) goto L8;
        return r102;
    L8:
        return "0";
    L10:
        tt5.a.d(getTAG(), "get tenantId");
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateScreenshotsEnable() {
        boolean r100 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).getSwitchStatusFromCurrentApp();
        String r101 = getTAG();
        StringBuilder r102 = new StringBuilder("updateScreenshotsEnable()... canCopy = ");
        r102.append(this.canCopy);
        r102.append(", attached = ");
        r102.append(this.attached);
        r102.append(", isShown = ");
        r102.append(this.isShown);
        r102.append(", checkWindowFocus() = ");
        boolean r103 = 0;
        r103 = 0;
        r102.append(checkWindowFocus$default(this, false, 1, null));
        r102.append(", windowFocused = ");
        r102.append(this.windowFocused);
        r102.append(", globalProtectionOn = ");
        r102.append(r100);
        tt5.a.h(r101, r102.toString());
        if (r100 == false) goto L9;
        setScreenshotsEnable(false);
        MutableLiveData<Integer> r104 = this.enableScreenshotsLivaData;
        if (r104 == null) goto L24;
        r104.postValue(2);
        return;
    L24:
        return;
    L9:
        if (this.attached == true) goto L12;
        return;
    L12:
        if (this.canCopy == false) goto L14;
    L19:
        r103 = 1;
    L20:
        setScreenshotsEnable(r103);
        MutableLiveData<Integer> r105 = this.enableScreenshotsLivaData;
        if (r105 == null) goto L25;
        r105.postValue(Integer.valueOf(!r103));
        return;
    L25:
        return;
    L14:
        if (this.isShown == false) goto L19;
        if (checkWindowFocus$default(this, false, 1, null) == false) goto L20;
        if (this.windowFocused == true) goto L20;
        goto L19
    }

    public BaseAntiScreenshotsPlugin() {
        this.TAG = "BaseAntiScreenshotsPlugin@" + Integer.toHexString(hashCode());
        Boolean r100 = Boolean.FALSE;
        this.driveCopyPerm = new MutableLiveData(r100);
        this.escapePerm = new MutableLiveData(r100);
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        this.isOfflinePermissionScreenshot = jg5.e.a.f499003a.f();
        this.driveCopyPermObserver = new c(this);
        this.escapeObserver = new d(this);
        this.dlpPermObserver = new b(this);
        this.onGlobalLayoutListener = new g(this);
        this.loadListener = new e(this);
    }

    private final boolean getCurrentActivityEnable() {
        if ((getActivity().getWindow().getAttributes().flags & 8192) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final void recordStateWhenAttach() {
        int r100 = getActivity().hashCode();
        Map<Integer, Integer> r101 = attachedPluginCountMap;
        Integer r102 = Integer.valueOf(r100);
        Integer r103 = r101.get(Integer.valueOf(r100));
        if (r103 == null) goto L5;
        int r104 = r103.intValue();
    L6:
        r101.put(r102, Integer.valueOf(r104 + 1));
        Map<Integer, Integer> r105 = originScsFlagStateMap;
        if (r105.get(Integer.valueOf(r100)) != null) goto L15;
        Integer r106 = Integer.valueOf(r100);
        Intent r107 = getActivity().getIntent();
        int r108 = -1;
        if (r107 == null) goto L11;
        r108 = r107.getIntExtra(SCS_FLAG_STATE, -1);
    L11:
        r105.put(r106, Integer.valueOf(r108));
        if (getActivity().getIntent() != null) goto L14;
        getActivity().setIntent(new Intent());
    L14:
        getActivity().getIntent().putExtra(SCS_FLAG_STATE, 0);
    L15:
        tt5.a.h(getTAG(), "recordStateWhenAttach()... attachedPluginCount = " + r101.get(Integer.valueOf(r100)) + ", originScsFlagState = " + r105.get(Integer.valueOf(r100)));
        return;
    L5:
        r104 = 0;
        goto L6
    }

    private final void restoreStateWhenDetach() {
        int r100 = getActivity().hashCode();
        if (getActivity().isFinishing() == false) goto L5;
    L25:
        tt5.a.h(getTAG(), "activity is finishing or destroyed, no need to restore");
        attachedPluginCountMap.remove(Integer.valueOf(r100));
        originScsFlagStateMap.remove(Integer.valueOf(r100));
        return;
    L5:
        if (getActivity().isDestroyed() == true) goto L25;
        Map<Integer, Integer> r101 = attachedPluginCountMap;
        Integer r102 = Integer.valueOf(r100);
        Integer r103 = r101.get(Integer.valueOf(r100));
        int r104 = 0;
        if (r103 == null) goto L10;
        int r105 = r103.intValue();
    L11:
        r101.put(r102, Integer.valueOf(r105 - 1));
        boolean r106 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).getSwitchStatusFromCurrentApp();
        String r107 = getTAG();
        StringBuilder r108 = new StringBuilder("restoreStateWhenDetach()... attachedPluginCount = ");
        r108.append(r101.get(Integer.valueOf(r100)));
        r108.append(", originScsFlagState = ");
        Map<Integer, Integer> r109 = originScsFlagStateMap;
        r108.append(r109.get(Integer.valueOf(r100)));
        r108.append(", switchStatusFromCurrentApp = ");
        r108.append(r106);
        tt5.a.h(r107, r108.toString());
        Integer r110 = r101.get(Integer.valueOf(r100));
        if (r110 == null) goto L14;
        r104 = r110.intValue();
    L14:
        if (r104 > 0) goto L27;
        setScreenshotsEnable(!r106);
        Integer r111 = r109.get(Integer.valueOf(r100));
        if (r111 == null) goto L18;
        int r112 = r111.intValue();
    L20:
        if (r112 != (-1)) goto L22;
        getActivity().getIntent().removeExtra(SCS_FLAG_STATE);
    L23:
        r101.remove(Integer.valueOf(r100));
        r109.remove(Integer.valueOf(r100));
        return;
    L22:
        Intrinsics.checkNotNull(getActivity().getIntent().putExtra(SCS_FLAG_STATE, r112));
        goto L23
    L18:
        r112 = -1;
        goto L20
    L27:
        return;
    L10:
        r105 = 0;
        goto L11
    }

    public final MutableLiveData<Boolean> getDriveCopyPerm() {
        return this.driveCopyPerm;
    }

    public final MutableLiveData<Boolean> getEscapePerm() {
        return this.escapePerm;
    }

    public String getTAG() {
        return this.TAG;
    }

    public final boolean isOfflinePermissionScreenshot() {
        return this.isOfflinePermissionScreenshot;
    }

    public static boolean INVOKEVIRTUAL_com_bytedance_ee_bear_drive_biz_security_BaseAntiScreenshotsPlugin_com_larus_home_impl_utils_DecorViewLancet_hasWindowFocus(FragmentActivity r100) {
        boolean r101 = r100.hasWindowFocus();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "hasWindowFocus");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "hasWindowFocus");
    L7:
        return r101;
    }

    public static final /* synthetic */ ViewGroup access$getContentContainer$p(BaseAntiScreenshotsPlugin r100) {
        return r100.contentContainer;
    }

    public static final /* synthetic */ g access$getOnGlobalLayoutListener$p(BaseAntiScreenshotsPlugin r100) {
        return r100.onGlobalLayoutListener;
    }

    public static final /* synthetic */ WeakReference access$getViewTreeObserverRef$p(BaseAntiScreenshotsPlugin r100) {
        return r100.viewTreeObserverRef;
    }

    public static final /* synthetic */ boolean access$isShown$p(BaseAntiScreenshotsPlugin r100) {
        return r100.isShown;
    }

    public static final /* synthetic */ void access$updateScreenshotsEnable(BaseAntiScreenshotsPlugin r100) {
        r100.updateScreenshotsEnable();
    }

    private final boolean checkWindowFocus(boolean r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 31) goto L5;
        boolean r102 = true;
    L6:
        if (r100 == false) goto L8;
        tt5.a.h(getTAG(), "checkWindowFocus()... sdk = " + r101 + ", res = " + r102);
    L8:
        return r102;
    L5:
        r102 = false;
        goto L6
    }

    private final void onPermissionCheck(boolean r110) {
        DrivePluginHost r100 = getHost();
        String r101 = null;
        if (r100 == null) goto L9;
        DriveViewModel r102 = r100.f224125c;
        if (r102 == null) goto L9;
        BaseOpenEntity r103 = r102.getOpenEntity();
        if (r103 == null) goto L9;
        String r104 = r103.getMountPoint();
    L10:
        String r105 = getHost().f224125c.getFileId();
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        boolean r111 = true;
        if (jg5.e.a.f499003a.g() == false) goto L13;
        boolean r106 = s55.a.h(s55.a.f540731a, "CONTENT_COPY", r104, r105, getTenantId(), getUserId(), null, null, null, null, 480).getAllow();
        boolean r107 = true;
    L21:
        tt5.a.h(getTAG(), "drive copy permission changed. driveCanCopy = " + r110 + ", adminCanCopy = " + r106 + ", dlpCanCopy = " + r107 + ", old canCopy = " + this.canCopy);
        if (r110 == false) goto L26;
        if (r106 == false) goto L26;
        if (r107 == false) goto L26;
        boolean r112 = true;
    L28:
        if (this.escapePerm.getValue() != null) goto L30;
    L32:
        r111 = r112;
    L33:
        setCopyState(r111);
        return;
    L30:
        if (Intrinsics.areEqual(this.escapePerm.getValue(), Boolean.TRUE) == false) goto L32;
        tt5.a.h(getTAG(), "escape it");
    L26:
        r112 = false;
        goto L28
    L13:
        r106 = ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g(pw4.b.b(r104), pw4.b.d(r104), pw4.b.f(r104), r105).f481503a;
        com.bytedance.ee.bear.middleground_permission_export.model.d r108 = (com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.d.class, null, null, 6);
        DrivePluginHost r109 = getHost();
        if (r109 == null) goto L20;
        DriveViewModel r113 = r109.f224125c;
        if (r113 == null) goto L20;
        BaseOpenEntity r114 = r113.getOpenEntity();
        if (r114 == null) goto L20;
        r101 = r114.getFileId();
    L20:
        r107 = TextUtils.isEmpty(r108.a(r101, 12, "CCM_CONTENT_COPY", "", getTenantId()));
    L9:
        r104 = null;
        goto L10
    }

    private final void setCopyState(boolean r100) {
        if (r100 == this.canCopy) goto L6;
        this.canCopy = r100;
        updateScreenshotsEnable();
        return;
    }

    private final void setScreenshotsEnable(boolean r100) {
        boolean r101 = getCurrentActivityEnable();
        tt5.a.h(getTAG(), "setScreenshotsEnable()... enable = " + r100 + ", currentActivityEnable = " + r101);
        if (getCurrentActivityEnable() != r100) goto L6;
        return;
    L6:
        if (r100 == false) goto L8;
        getHost().getActivity().getWindow().clearFlags(8192);
        return;
    L8:
        getHost().getActivity().getWindow().addFlags(8192);
    }

    public void onAttachToHost(DrivePluginHost r100) {
        super.onAttachToHost(r100);
        tt5.a.h(getTAG(), "onAttachToHost()...");
        recordStateWhenAttach();
        Intrinsics.checkNotNull(r100);
        r100.c().c(this.loadListener);
        this.driveCopyPerm.observe(getLifecycleOwner(), this.driveCopyPermObserver);
        this.escapePerm.observe(getLifecycleOwner(), this.escapeObserver);
        ((DrivePermissionViewModel) viewModel(DrivePermissionViewModel.class)).getLiveCopyPerm().observe(getLifecycleOwner(), this.dlpPermObserver);
        updateScreenshotsEnable();
    }

    public void onDetachFromHost(DrivePluginHost r100) {
        super.onDetachFromHost(r100);
        tt5.a.h(getTAG(), "onDetachFromHost()...");
        Intrinsics.checkNotNull(r100);
        r100.c().g(this.loadListener);
        this.driveCopyPerm.removeObserver(this.driveCopyPermObserver);
        this.escapePerm.removeObserver(this.escapeObserver);
        ((DrivePermissionViewModel) viewModel(DrivePermissionViewModel.class)).getLiveCopyPerm().removeObserver(this.dlpPermObserver);
        restoreStateWhenDetach();
    }

    public void onStart(DrivePluginHost r100) {
        tt5.a.h(getTAG(), "onStart()...");
        updateScreenshotsEnable();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((DrivePluginHost) r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r100) {
        onDetachFromHost((DrivePluginHost) r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onStart(PluginHost r100) {
        onStart((DrivePluginHost) r100);
    }

    public static final /* synthetic */ void access$onPermissionCheck(BaseAntiScreenshotsPlugin r100, boolean r101) {
        r100.onPermissionCheck(r101);
    }

    public static final /* synthetic */ void access$setAttached$p(BaseAntiScreenshotsPlugin r100, boolean r101) {
        r100.attached = r101;
    }

    public static final /* synthetic */ void access$setCopyState(BaseAntiScreenshotsPlugin r100, boolean r101) {
        r100.setCopyState(r101);
    }

    public static final /* synthetic */ void access$setShown$p(BaseAntiScreenshotsPlugin r100, boolean r101) {
        r100.isShown = r101;
    }

    public static final /* synthetic */ void access$setViewTreeObserverRef$p(BaseAntiScreenshotsPlugin r100, WeakReference r101) {
        r100.viewTreeObserverRef = r101;
    }

    public static final /* synthetic */ void access$setWindowFocused$p(BaseAntiScreenshotsPlugin r100, boolean r101) {
        r100.windowFocused = r101;
    }

    public void onAttachToUIContainer(DrivePluginHost r100, t r101) {
        super.onAttachToUIContainer(r100, r101);
        Intrinsics.checkNotNull(r100);
        this.enableScreenshotsLivaData = ((AntiScreenshotsViewModel) new ViewModelProvider(r100.getActivity()).get(AntiScreenshotsViewModel.class)).getEnableScreenshotsLivaData();
        if (checkWindowFocus(true) == false) goto L17;
        FragmentActivity r102 = r100.getActivity();
        boolean r103 = false;
        if (r102 != null) goto L7;
    L9:
        if (r103 == false) goto L11;
        tt5.a.h(getTAG(), "activity window focus is already true");
        this.windowFocused = true;
        updateScreenshotsEnable();
        goto L17
    L11:
        if (r101 == null) goto L17;
        View r104 = r101.getContentView();
        if (r104 == null) goto L17;
        ViewTreeObserver r105 = r104.getViewTreeObserver();
        if (r105 == null) goto L17;
        r105.addOnWindowFocusChangeListener(new f(this, r101));
        goto L17
    L7:
        if (INVOKEVIRTUAL_com_bytedance_ee_bear_drive_biz_security_BaseAntiScreenshotsPlugin_com_larus_home_impl_utils_DecorViewLancet_hasWindowFocus(r102) != true) goto L9;
        r103 = true;
    L17:
        if (r101 == null) goto L19;
        View r106 = r101.findView(R.id.drive_preview_container);
    L20:
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r107 = (ViewGroup) r106;
        this.contentContainer = r107;
        if (r107 != null) goto L24;
        tt5.a.d(getTAG(), "contentContainer is null!");
        return;
    L24:
        return;
    L19:
        r106 = null;
        goto L20
    }

    public void onDetachFromUIContainer(DrivePluginHost r100, t r101) {
        ViewGroup r102 = this.contentContainer;
        if (r102 == null) goto L7;
        ViewTreeObserver r103 = r102.getViewTreeObserver();
        if (r103 == null) goto L7;
        r103.removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
    L7:
        WeakReference<ViewTreeObserver> r104 = this.viewTreeObserverRef;
        if (r104 == null) goto L14;
        ViewTreeObserver r105 = r104.get();
        if (r105 == null) goto L14;
        if (r105.isAlive() == false) goto L14;
        r105.removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
    L14:
        this.contentContainer = null;
        this.viewTreeObserverRef = null;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r100, t r101) {
        onAttachToUIContainer((DrivePluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r100, t r101) {
        onDetachFromUIContainer((DrivePluginHost) r100, r101);
    }

    public static /* synthetic */ boolean checkWindowFocus$default(BaseAntiScreenshotsPlugin r100, boolean r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L7;
        r101 = false;
    L7:
        return r100.checkWindowFocus(r101);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkWindowFocus");
    }
}
