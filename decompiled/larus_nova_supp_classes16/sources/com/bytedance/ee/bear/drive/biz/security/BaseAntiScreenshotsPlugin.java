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
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.drive.biz.extra_info.meta.DriveMetaInfoVM;
import com.bytedance.ee.bear.drive.biz.permission.DrivePermissionViewModel;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.lark.dependency.i0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b*\u0002),\b&\u0018\u0000 >2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000bH\u0002J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u000bH\u0002J\b\u0010&\u001a\u00020\u0006H\u0002J\b\u0010'\u001a\u00020\u0006H\u0002J\b\u0010.\u001a\u00020\"H\u0002J\u0010\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020\u000bH\u0002J\u0012\u00101\u001a\u00020\u000b2\b\b\u0002\u00102\u001a\u00020\u000bH\u0002J\u0012\u00103\u001a\u00020\"2\b\u00104\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u00105\u001a\u00020\"2\b\u00104\u001a\u0004\u0018\u00010\u00022\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u001c\u00108\u001a\u00020\"2\b\u00104\u001a\u0004\u0018\u00010\u00022\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0012\u00109\u001a\u00020\"2\b\u00104\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010:\u001a\u00020\u000bH\u0002J\b\u0010;\u001a\u00020\"H\u0002J\b\u0010<\u001a\u00020\"H\u0002J\u0012\u0010=\u001a\u00020\"2\b\u00104\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0004\n\u0002\u0010*R\u0010\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0004\n\u0002\u0010-¨\u0006?"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/security/BaseAntiScreenshotsPlugin;", "Lcom/bytedance/ee/bear/browser/plugin/BasePlugin;", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "driveCopyPerm", "Landroidx/lifecycle/MutableLiveData;", "", "getDriveCopyPerm", "()Landroidx/lifecycle/MutableLiveData;", "escapePerm", "getEscapePerm", "isOfflinePermissionScreenshot", "()Z", "canCopy", "attached", "isShown", "contentContainer", "Landroid/view/ViewGroup;", "enableScreenshotsLivaData", "", "windowFocused", "viewTreeObserverRef", "Ljava/lang/ref/WeakReference;", "Landroid/view/ViewTreeObserver;", "driveCopyPermObserver", "Landroidx/lifecycle/Observer;", "escapeObserver", "dlpPermObserver", "onPermissionCheck", "", "it", "setCopyState", "newCanCopy", "getTenantId", "getUserId", "onGlobalLayoutListener", "com/bytedance/ee/bear/drive/biz/security/BaseAntiScreenshotsPlugin$onGlobalLayoutListener$1", "Lcom/bytedance/ee/bear/drive/biz/security/BaseAntiScreenshotsPlugin$onGlobalLayoutListener$1;", "loadListener", "com/bytedance/ee/bear/drive/biz/security/BaseAntiScreenshotsPlugin$loadListener$1", "Lcom/bytedance/ee/bear/drive/biz/security/BaseAntiScreenshotsPlugin$loadListener$1;", "updateScreenshotsEnable", "setScreenshotsEnable", "enable", "checkWindowFocus", "log", "onAttachToHost", "host", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "onDetachFromHost", "getCurrentActivityEnable", "recordStateWhenAttach", "restoreStateWhenDetach", "onStart", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        public final /* synthetic */ BaseAntiScreenshotsPlugin a;

        public b(BaseAntiScreenshotsPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            boolean r4 = ((Boolean) r3).booleanValue();
            tt5.a.h(this.a.getTAG(), "dlpPermObserver");
            BaseAntiScreenshotsPlugin.access$onPermissionCheck(this.a, r4);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ BaseAntiScreenshotsPlugin a;

        public c(BaseAntiScreenshotsPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            boolean r4 = ((Boolean) r3).booleanValue();
            tt5.a.h(this.a.getTAG(), "driveCopyPermObserver");
            BaseAntiScreenshotsPlugin.access$onPermissionCheck(this.a, r4);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ BaseAntiScreenshotsPlugin a;

        public d(BaseAntiScreenshotsPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            boolean r3 = ((Boolean) r2).booleanValue();
            if (r3 == false) goto L6;
            BaseAntiScreenshotsPlugin.access$setCopyState(this.a, r3);
            return;
        }
    }

    public static final class e extends u75.b.C0306b {
        public final /* synthetic */ BaseAntiScreenshotsPlugin a;

        public e(BaseAntiScreenshotsPlugin r1) {
            this.a = r1;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final <T> void a(InfoCode r2, T r3) {
            Intrinsics.checkNotNullParameter(r2, "code");
            if (r2 != InfoCode.OnAttach) goto L15;
            tt5.a.h(this.a.getTAG(), "onInfo()... OnAttach ");
            BaseAntiScreenshotsPlugin.access$setAttached$p(this.a, true);
            ViewGroup r4 = BaseAntiScreenshotsPlugin.access$getContentContainer$p(this.a);
            if (r4 == null) goto L9;
            ViewTreeObserver r5 = r4.getViewTreeObserver();
            if (r5 == null) goto L9;
            r5.addOnGlobalLayoutListener(BaseAntiScreenshotsPlugin.access$getOnGlobalLayoutListener$p(this.a));
        L9:
            BaseAntiScreenshotsPlugin r6 = this.a;
            ViewGroup r0 = BaseAntiScreenshotsPlugin.access$getContentContainer$p(this.a);
            if (r0 == null) goto L12;
            ViewTreeObserver r1 = r0.getViewTreeObserver();
        L13:
            BaseAntiScreenshotsPlugin.access$setViewTreeObserverRef$p(r6, new WeakReference(r1));
            BaseAntiScreenshotsPlugin.access$updateScreenshotsEnable(this.a);
            return;
        L12:
            r1 = null;
            goto L13
        L15:
            if (r2 != InfoCode.OnDetach) goto L30;
            tt5.a.h(this.a.getTAG(), "onInfo()... OnDetach ");
            BaseAntiScreenshotsPlugin.access$setAttached$p(this.a, false);
            ViewGroup r7 = BaseAntiScreenshotsPlugin.access$getContentContainer$p(this.a);
            if (r7 == null) goto L21;
            ViewTreeObserver r8 = r7.getViewTreeObserver();
            if (r8 == null) goto L21;
            r8.removeOnGlobalLayoutListener(BaseAntiScreenshotsPlugin.access$getOnGlobalLayoutListener$p(this.a));
        L21:
            WeakReference r9 = BaseAntiScreenshotsPlugin.access$getViewTreeObserverRef$p(this.a);
            if (r9 == null) goto L31;
            ViewTreeObserver r10 = (ViewTreeObserver) r9.get();
            if (r10 == null) goto L32;
            BaseAntiScreenshotsPlugin r11 = this.a;
            if (r10.isAlive() == false) goto L33;
            r10.removeOnGlobalLayoutListener(BaseAntiScreenshotsPlugin.access$getOnGlobalLayoutListener$p(r11));
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
        public final /* synthetic */ BaseAntiScreenshotsPlugin a;
        public final /* synthetic */ t b;

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public final void onWindowFocusChanged(boolean r2) {
            if (r2 == false) goto L5;
            tt5.a.h(this.a.getTAG(), "onWindowFocusChanged true");
            BaseAntiScreenshotsPlugin.access$setWindowFocused$p(this.a, true);
            this.b.getContentView().getViewTreeObserver().removeOnWindowFocusChangeListener(this);
            BaseAntiScreenshotsPlugin.access$updateScreenshotsEnable(this.a);
            return;
        }

        public f(BaseAntiScreenshotsPlugin r1, t r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class g implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ BaseAntiScreenshotsPlugin a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (BaseAntiScreenshotsPlugin.access$getContentContainer$p(this.a) != null) goto L6;
            tt5.a.k(this.a.getTAG(), "onGlobalLayoutListener()... contentContainer is null!");
            return;
        L6:
            ViewGroup r0 = BaseAntiScreenshotsPlugin.access$getContentContainer$p(this.a);
            Intrinsics.checkNotNull(r0);
            if (r0.isShown() == false) goto L11;
            ViewGroup r1 = BaseAntiScreenshotsPlugin.access$getContentContainer$p(this.a);
            Intrinsics.checkNotNull(r1);
            if (r1.getChildCount() <= 0) goto L11;
            boolean r2 = true;
        L13:
            if (r2 == BaseAntiScreenshotsPlugin.access$isShown$p(this.a)) goto L16;
            BaseAntiScreenshotsPlugin.access$setShown$p(this.a, r2);
            tt5.a.h(this.a.getTAG(), "isShown changed " + BaseAntiScreenshotsPlugin.access$isShown$p(this.a));
            BaseAntiScreenshotsPlugin.access$updateScreenshotsEnable(this.a);
            return;
        L16:
            return;
        L11:
            r2 = false;
            goto L13
        }

        public g(BaseAntiScreenshotsPlugin r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    static {
        Companion = new a();
        attachedPluginCountMap = new LinkedHashMap();
        originScsFlagStateMap = new LinkedHashMap();
    }

    private final String getTenantId() {
        w75.c r1 = getHost().c.getIFileModel();     // Catch: Throwable -> L10
        if (r1 == null) goto L14;
        String r2 = r1.a();     // Catch: Throwable -> L10
        if (r2 != null) goto L9;
        return "";
    L9:
        return r2;
    L14:
        return "";
    L10:
        tt5.a.d(getTAG(), "get tenantId");
        return "";
    }

    private final String getUserId() {
        u55.a r0 = (u55.a) ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).getLiveMetaInfo().getValue();     // Catch: Throwable -> L10
        if (r0 == null) goto L8;
        DocMetaInfo r1 = r0.b;     // Catch: Throwable -> L10
        if (r1 == null) goto L8;
        String r2 = r1.getOwnerUid();     // Catch: Throwable -> L10
        if (r2 == null) goto L8;
        return r2;
    L8:
        return DiagramData$RESULT.FAIL;
    L10:
        tt5.a.d(getTAG(), "get tenantId");
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateScreenshotsEnable() {
        boolean r0 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).getSwitchStatusFromCurrentApp();
        String r2 = getTAG();
        StringBuilder r3 = new StringBuilder("updateScreenshotsEnable()... canCopy = ");
        r3.append(this.canCopy);
        r3.append(", attached = ");
        r3.append(this.attached);
        r3.append(", isShown = ");
        r3.append(this.isShown);
        r3.append(", checkWindowFocus() = ");
        boolean r4 = 0;
        r4 = 0;
        r3.append(checkWindowFocus$default(this, false, 1, null));
        r3.append(", windowFocused = ");
        r3.append(this.windowFocused);
        r3.append(", globalProtectionOn = ");
        r3.append(r0);
        tt5.a.h(r2, r3.toString());
        if (r0 == false) goto L9;
        setScreenshotsEnable(false);
        MutableLiveData<Integer> r1 = this.enableScreenshotsLivaData;
        if (r1 == null) goto L24;
        r1.postValue(2);
        return;
    L24:
        return;
    L9:
        if (this.attached == true) goto L12;
        return;
    L12:
        if (this.canCopy == false) goto L14;
    L19:
        r4 = 1;
    L20:
        setScreenshotsEnable(r4);
        MutableLiveData<Integer> r5 = this.enableScreenshotsLivaData;
        if (r5 == null) goto L25;
        r5.postValue(Integer.valueOf(!r4));
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
        Boolean r1 = Boolean.FALSE;
        this.driveCopyPerm = new MutableLiveData(r1);
        this.escapePerm = new MutableLiveData(r1);
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        this.isOfflinePermissionScreenshot = jg5.e.a.a.f();
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
        int r0 = getActivity().hashCode();
        Map<Integer, Integer> r1 = attachedPluginCountMap;
        Integer r2 = Integer.valueOf(r0);
        Integer r3 = r1.get(Integer.valueOf(r0));
        if (r3 == null) goto L5;
        int r4 = r3.intValue();
    L6:
        r1.put(r2, Integer.valueOf(r4 + 1));
        Map<Integer, Integer> r5 = originScsFlagStateMap;
        if (r5.get(Integer.valueOf(r0)) != null) goto L15;
        Integer r6 = Integer.valueOf(r0);
        Intent r7 = getActivity().getIntent();
        int r8 = -1;
        if (r7 == null) goto L11;
        r8 = r7.getIntExtra(SCS_FLAG_STATE, -1);
    L11:
        r5.put(r6, Integer.valueOf(r8));
        if (getActivity().getIntent() != null) goto L14;
        getActivity().setIntent(new Intent());
    L14:
        getActivity().getIntent().putExtra(SCS_FLAG_STATE, 0);
    L15:
        tt5.a.h(getTAG(), "recordStateWhenAttach()... attachedPluginCount = " + r1.get(Integer.valueOf(r0)) + ", originScsFlagState = " + r5.get(Integer.valueOf(r0)));
        return;
    L5:
        r4 = 0;
        goto L6
    }

    private final void restoreStateWhenDetach() {
        int r0 = getActivity().hashCode();
        if (getActivity().isFinishing() == false) goto L5;
    L25:
        tt5.a.h(getTAG(), "activity is finishing or destroyed, no need to restore");
        attachedPluginCountMap.remove(Integer.valueOf(r0));
        originScsFlagStateMap.remove(Integer.valueOf(r0));
        return;
    L5:
        if (getActivity().isDestroyed() == true) goto L25;
        Map<Integer, Integer> r1 = attachedPluginCountMap;
        Integer r2 = Integer.valueOf(r0);
        Integer r3 = r1.get(Integer.valueOf(r0));
        int r4 = 0;
        if (r3 == null) goto L10;
        int r5 = r3.intValue();
    L11:
        r1.put(r2, Integer.valueOf(r5 - 1));
        boolean r6 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).getSwitchStatusFromCurrentApp();
        String r7 = getTAG();
        StringBuilder r8 = new StringBuilder("restoreStateWhenDetach()... attachedPluginCount = ");
        r8.append(r1.get(Integer.valueOf(r0)));
        r8.append(", originScsFlagState = ");
        Map<Integer, Integer> r9 = originScsFlagStateMap;
        r8.append(r9.get(Integer.valueOf(r0)));
        r8.append(", switchStatusFromCurrentApp = ");
        r8.append(r6);
        tt5.a.h(r7, r8.toString());
        Integer r10 = r1.get(Integer.valueOf(r0));
        if (r10 == null) goto L14;
        r4 = r10.intValue();
    L14:
        if (r4 > 0) goto L27;
        setScreenshotsEnable(!r6);
        Integer r11 = r9.get(Integer.valueOf(r0));
        if (r11 == null) goto L18;
        int r12 = r11.intValue();
    L20:
        if (r12 != (-1)) goto L22;
        getActivity().getIntent().removeExtra(SCS_FLAG_STATE);
    L23:
        r1.remove(Integer.valueOf(r0));
        r9.remove(Integer.valueOf(r0));
        return;
    L22:
        Intrinsics.checkNotNull(getActivity().getIntent().putExtra(SCS_FLAG_STATE, r12));
        goto L23
    L18:
        r12 = -1;
        goto L20
    L27:
        return;
    L10:
        r5 = 0;
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

    public static boolean INVOKEVIRTUAL_com_bytedance_ee_bear_drive_biz_security_BaseAntiScreenshotsPlugin_com_larus_home_impl_utils_DecorViewLancet_hasWindowFocus(FragmentActivity r3) {
        boolean r4 = r3.hasWindowFocus();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "hasWindowFocus");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "hasWindowFocus");
    L7:
        return r4;
    }

    public static final /* synthetic */ ViewGroup access$getContentContainer$p(BaseAntiScreenshotsPlugin r0) {
        return r0.contentContainer;
    }

    public static final /* synthetic */ g access$getOnGlobalLayoutListener$p(BaseAntiScreenshotsPlugin r0) {
        return r0.onGlobalLayoutListener;
    }

    public static final /* synthetic */ WeakReference access$getViewTreeObserverRef$p(BaseAntiScreenshotsPlugin r0) {
        return r0.viewTreeObserverRef;
    }

    public static final /* synthetic */ boolean access$isShown$p(BaseAntiScreenshotsPlugin r0) {
        return r0.isShown;
    }

    public static final /* synthetic */ void access$updateScreenshotsEnable(BaseAntiScreenshotsPlugin r0) {
        r0.updateScreenshotsEnable();
    }

    private final boolean checkWindowFocus(boolean r5) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 31) goto L5;
        boolean r1 = true;
    L6:
        if (r5 == false) goto L8;
        tt5.a.h(getTAG(), "checkWindowFocus()... sdk = " + r0 + ", res = " + r1);
    L8:
        return r1;
    L5:
        r1 = false;
        goto L6
    }

    private final void onPermissionCheck(boolean r16) {
        DrivePluginHost r0 = getHost();
        String r1 = null;
        if (r0 == null) goto L9;
        DriveViewModel r2 = r0.c;
        if (r2 == null) goto L9;
        BaseOpenEntity r3 = r2.getOpenEntity();
        if (r3 == null) goto L9;
        String r4 = r3.getMountPoint();
    L10:
        String r5 = getHost().c.getFileId();
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        boolean r13 = true;
        if (jg5.e.a.a.g() == false) goto L13;
        boolean r6 = s55.a.h(s55.a.a, "CONTENT_COPY", r4, r5, getTenantId(), getUserId(), null, null, null, null, 480).getAllow();
        boolean r7 = true;
    L21:
        tt5.a.h(getTAG(), "drive copy permission changed. driveCanCopy = " + r16 + ", adminCanCopy = " + r6 + ", dlpCanCopy = " + r7 + ", old canCopy = " + this.canCopy);
        if (r16 == false) goto L26;
        if (r6 == false) goto L26;
        if (r7 == false) goto L26;
        boolean r17 = true;
    L28:
        if (this.escapePerm.getValue() != null) goto L30;
    L32:
        r13 = r17;
    L33:
        setCopyState(r13);
        return;
    L30:
        if (Intrinsics.areEqual(this.escapePerm.getValue(), Boolean.TRUE) == false) goto L32;
        tt5.a.h(getTAG(), "escape it");
    L26:
        r17 = false;
        goto L28
    L13:
        r6 = ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g(pw4.b.b(r4), pw4.b.d(r4), pw4.b.f(r4), r5).a;
        com.bytedance.ee.bear.middleground_permission_export.model.d r8 = (com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.d.class, null, null, 6);
        DrivePluginHost r9 = getHost();
        if (r9 == null) goto L20;
        DriveViewModel r10 = r9.c;
        if (r10 == null) goto L20;
        BaseOpenEntity r11 = r10.getOpenEntity();
        if (r11 == null) goto L20;
        r1 = r11.getFileId();
    L20:
        r7 = TextUtils.isEmpty(r8.a(r1, 12, "CCM_CONTENT_COPY", "", getTenantId()));
    L9:
        r4 = null;
        goto L10
    }

    private final void setCopyState(boolean r2) {
        if (r2 == this.canCopy) goto L6;
        this.canCopy = r2;
        updateScreenshotsEnable();
        return;
    }

    private final void setScreenshotsEnable(boolean r5) {
        boolean r0 = getCurrentActivityEnable();
        tt5.a.h(getTAG(), "setScreenshotsEnable()... enable = " + r5 + ", currentActivityEnable = " + r0);
        if (getCurrentActivityEnable() != r5) goto L6;
        return;
    L6:
        if (r5 == false) goto L8;
        getHost().getActivity().getWindow().clearFlags(8192);
        return;
    L8:
        getHost().getActivity().getWindow().addFlags(8192);
    }

    public void onAttachToHost(DrivePluginHost r3) {
        super.onAttachToHost(r3);
        tt5.a.h(getTAG(), "onAttachToHost()...");
        recordStateWhenAttach();
        Intrinsics.checkNotNull(r3);
        r3.c().c(this.loadListener);
        this.driveCopyPerm.observe(getLifecycleOwner(), this.driveCopyPermObserver);
        this.escapePerm.observe(getLifecycleOwner(), this.escapeObserver);
        ((DrivePermissionViewModel) viewModel(DrivePermissionViewModel.class)).getLiveCopyPerm().observe(getLifecycleOwner(), this.dlpPermObserver);
        updateScreenshotsEnable();
    }

    public void onDetachFromHost(DrivePluginHost r3) {
        super.onDetachFromHost(r3);
        tt5.a.h(getTAG(), "onDetachFromHost()...");
        Intrinsics.checkNotNull(r3);
        r3.c().g(this.loadListener);
        this.driveCopyPerm.removeObserver(this.driveCopyPermObserver);
        this.escapePerm.removeObserver(this.escapeObserver);
        ((DrivePermissionViewModel) viewModel(DrivePermissionViewModel.class)).getLiveCopyPerm().removeObserver(this.dlpPermObserver);
        restoreStateWhenDetach();
    }

    public void onStart(DrivePluginHost r2) {
        tt5.a.h(getTAG(), "onStart()...");
        updateScreenshotsEnable();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onStart(PluginHost r1) {
        onStart((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$onPermissionCheck(BaseAntiScreenshotsPlugin r0, boolean r1) {
        r0.onPermissionCheck(r1);
    }

    public static final /* synthetic */ void access$setAttached$p(BaseAntiScreenshotsPlugin r0, boolean r1) {
        r0.attached = r1;
    }

    public static final /* synthetic */ void access$setCopyState(BaseAntiScreenshotsPlugin r0, boolean r1) {
        r0.setCopyState(r1);
    }

    public static final /* synthetic */ void access$setShown$p(BaseAntiScreenshotsPlugin r0, boolean r1) {
        r0.isShown = r1;
    }

    public static final /* synthetic */ void access$setViewTreeObserverRef$p(BaseAntiScreenshotsPlugin r0, WeakReference r1) {
        r0.viewTreeObserverRef = r1;
    }

    public static final /* synthetic */ void access$setWindowFocused$p(BaseAntiScreenshotsPlugin r0, boolean r1) {
        r0.windowFocused = r1;
    }

    public void onAttachToUIContainer(DrivePluginHost r3, t r4) {
        super.onAttachToUIContainer(r3, r4);
        Intrinsics.checkNotNull(r3);
        this.enableScreenshotsLivaData = ((AntiScreenshotsViewModel) new ViewModelProvider(r3.getActivity()).get(AntiScreenshotsViewModel.class)).getEnableScreenshotsLivaData();
        if (checkWindowFocus(true) == false) goto L17;
        FragmentActivity r5 = r3.getActivity();
        boolean r1 = false;
        if (r5 != null) goto L7;
    L9:
        if (r1 == false) goto L11;
        tt5.a.h(getTAG(), "activity window focus is already true");
        this.windowFocused = true;
        updateScreenshotsEnable();
        goto L17
    L11:
        if (r4 == null) goto L17;
        View r6 = r4.getContentView();
        if (r6 == null) goto L17;
        ViewTreeObserver r7 = r6.getViewTreeObserver();
        if (r7 == null) goto L17;
        r7.addOnWindowFocusChangeListener(new f(this, r4));
        goto L17
    L7:
        if (INVOKEVIRTUAL_com_bytedance_ee_bear_drive_biz_security_BaseAntiScreenshotsPlugin_com_larus_home_impl_utils_DecorViewLancet_hasWindowFocus(r5) != true) goto L9;
        r1 = true;
    L17:
        if (r4 == null) goto L19;
        View r8 = r4.findView(2131370305);
    L20:
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r9 = (ViewGroup) r8;
        this.contentContainer = r9;
        if (r9 != null) goto L24;
        tt5.a.d(getTAG(), "contentContainer is null!");
        return;
    L24:
        return;
    L19:
        r8 = null;
        goto L20
    }

    public void onDetachFromUIContainer(DrivePluginHost r1, t r2) {
        ViewGroup r3 = this.contentContainer;
        if (r3 == null) goto L7;
        ViewTreeObserver r4 = r3.getViewTreeObserver();
        if (r4 == null) goto L7;
        r4.removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
    L7:
        WeakReference<ViewTreeObserver> r5 = this.viewTreeObserverRef;
        if (r5 == null) goto L14;
        ViewTreeObserver r6 = r5.get();
        if (r6 == null) goto L14;
        if (r6.isAlive() == false) goto L14;
        r6.removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
    L14:
        this.contentContainer = null;
        this.viewTreeObserverRef = null;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DrivePluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DrivePluginHost) r1, r2);
    }

    public static /* synthetic */ boolean checkWindowFocus$default(BaseAntiScreenshotsPlugin r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = false;
    L7:
        return r0.checkWindowFocus(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkWindowFocus");
    }
}
