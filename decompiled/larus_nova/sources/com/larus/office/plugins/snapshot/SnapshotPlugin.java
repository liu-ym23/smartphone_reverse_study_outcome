package com.larus.office.plugins.snapshot;

import android.graphics.drawable.Drawable;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.larus.home.impl.sdk.x1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import uo9.e;
import uo9.f;
import uo9.g;
import uo9.h;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J+\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0002\u0010\u0016J+\u0010\u0017\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/office/plugins/snapshot/SnapshotPlugin;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "Lcom/larus/office/snapshot/IFlowSnapShotService;", "<init>", "()V", "mFragment", "Lcom/larus/office/plugins/snapshot/DocShotFragment;", "cancelSnapShotListener", "", "Lkotlin/Function0;", "", "onAttachToHost", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onDetachFromHost", "startDocSnapshot", "inputViewHeight", "", "drawable", "Landroid/graphics/drawable/Drawable;", "listener", "Lcom/larus/office/snapshot/IFlowDocSnapshotResultListener;", "(Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Lcom/larus/office/snapshot/IFlowDocSnapshotResultListener;)V", "realStartDocSnapshot", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SnapshotPlugin extends OfficeDocumentPlugin implements yo9.b {
    public static final a Companion = null;
    public static final String TAG = "SnapshotPlugin";
    private final List<Function0<Unit>> cancelSnapShotListener;
    private DocShotFragment mFragment;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements wz4.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SnapshotPlugin f363477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ yo9.a f363478b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Integer f363479c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Drawable f363480d;

        public static void a(DocShotFragment r100) {
            r100.dismissAllowingStateLoss();     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L11;
            d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        @Override // wz4.c
        public final void onSnapshotFailed(String r100) {
            FLogger.f375446a.i("SnapshotPlugin", "onSnapshotFailed , errorInfo = " + r100);
            DocShotFragment r101 = SnapshotPlugin.access$getMFragment$p(this.f363477a);
            if (r101 == null) goto L5;
            a(r101);
        L5:
            yo9.a r102 = this.f363478b;
            if (r102 == null) goto L11;
            if (r100 != null) goto L9;
            r100 = "";
        L9:
            r102.onSnapshotFail(r100);
            return;
        }

        @Override // wz4.c
        public final void onStartShot(wz4.c.a r110) {
            Intrinsics.checkNotNullParameter(r110, "params");
            FLogger.f375446a.i("SnapshotPlugin", "onStartShot");
            DocShotFragment r111 = SnapshotPlugin.access$getMFragment$p(this.f363477a);
            if (r111 == null) goto L5;
            a(r111);
        L5:
            SnapshotPlugin.access$setMFragment$p(this.f363477a, new DocShotFragment());
            WebView r100 = this.f363477a.getHost().getWeb().getWebView();
            String r101 = this.f363477a.getHost().getChameleonConfig().getLoadUrl();
            Integer r102 = this.f363479c;
            Drawable r103 = this.f363480d;
            yo9.a r112 = this.f363478b;
            uo9.b r113 = new uo9.b(r100, r101, r102, r103, r112);
            DocShotFragment r104 = SnapshotPlugin.access$getMFragment$p(this.f363477a);
            if (r104 == null) goto L8;
            SnapshotPlugin.access$getActivity(this.f363477a);
            Intrinsics.checkNotNullParameter(r113, "params");
            r104.f363472f = r100;
            r104.getClass();
            r104.f363473g = r112;
            r104.f363474h = r103;
            r104.f363475i = true;
        L8:
            DocShotFragment r114 = SnapshotPlugin.access$getMFragment$p(this.f363477a);
            if (r114 == null) goto L11;
            final SnapshotPlugin r105 = this.f363477a;
            Function0<Unit> r106 = new e(r105);
            Intrinsics.checkNotNullParameter(r106, "listener");
            r114.f363476j = r106;
        L11:
            DocShotFragment r115 = SnapshotPlugin.access$getMFragment$p(this.f363477a);
            if (r115 == null) goto L18;
            FragmentManager r107 = SnapshotPlugin.access$getActivity(this.f363477a).getSupportFragmentManager();
            LandscapeRestrictionOperation r108 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r115, "SnapshotPlugin", r108);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r107, r115, r108) == true) goto L18;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
        L17:
            r115.show(r107, "SnapshotPlugin");
        L18:
            List r116 = SnapshotPlugin.access$getCancelSnapShotListener$p(this.f363477a);
            final yo9.a r109 = this.f363478b;
            r116.add(new f(r109));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v2, types: [uo9.h] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // wz4.c
        public final void onSnapshotSuccess(String r100, float r101) {
            FLogger.f375446a.i("SnapshotPlugin", "onSnapshotSuccess, path = " + r100 + ", scale = " + r101);
            if (r100 != null) goto L6;
            final SnapshotPlugin r102 = this.f363477a;
            final yo9.a r103 = this.f363478b;
            y.c(new g(r102, r103));
            return;
        L6:
            IFlowSdkDepend r104 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r104 == null) goto L10;
            r104.D();
            x1 r105 = x1.f346268a;
            final SnapshotPlugin r106 = this.f363477a;
            final yo9.a r107 = this.f363478b;
            r105.h(r100, new h(r106, r107));
            return;
        }

        public b(SnapshotPlugin r100, yo9.a r101, Integer r102, Drawable r103) {
            this.f363477a = r100;
            this.f363478b = r101;
            this.f363479c = r102;
            this.f363480d = r103;
        }
    }

    public static final class c implements wz4.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SnapshotPlugin f363481a;

        @Override // wz4.a
        public final void dismiss() {
        }

        @Override // wz4.a
        public final void onHideShotView() {
        }

        @Override // wz4.a
        public final void setOnBackPressListener(Function0<Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
        }

        @Override // wz4.a
        public final void setSnapState(boolean r100) {
        }

        public c(SnapshotPlugin r100) {
            this.f363481a = r100;
        }

        @Override // wz4.a
        public final void setDismissListener(Function0<Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            SnapshotPlugin.access$getCancelSnapShotListener$p(this.f363481a).add(r100);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.OfficeDocumentPlugin, com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public SnapshotPlugin() {
        this.cancelSnapShotListener = new ArrayList();
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(SnapshotPlugin r100) {
        return r100.getActivity();
    }

    public static final /* synthetic */ List access$getCancelSnapShotListener$p(SnapshotPlugin r100) {
        return r100.cancelSnapShotListener;
    }

    public static final /* synthetic */ DocShotFragment access$getMFragment$p(SnapshotPlugin r100) {
        return r100.mFragment;
    }

    public void onAttachToHost(ChameleonPluginHost r100) {
        super.onAttachToHost(r100);
        yo9.b r101 = uo9.c.f550949a;
        uo9.c.f550949a = this;
    }

    public void onDetachFromHost(ChameleonPluginHost r100) {
        super.onDetachFromHost(r100);
        yo9.b r101 = uo9.c.f550949a;
        uo9.c.f550949a = null;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((ChameleonPluginHost) r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r100) {
        onDetachFromHost((ChameleonPluginHost) r100);
    }

    public static final /* synthetic */ void access$setMFragment$p(SnapshotPlugin r100, DocShotFragment r101) {
        r100.mFragment = r101;
    }

    private final void realStartDocSnapshot(Integer r100, Drawable r101, yo9.a r102) {
        ((wz4.b) getHost().getHostAbility(wz4.b.class)).requestSnapshot("", new b(this, r102, r100, r101), new c(this));
    }

    @Override // yo9.b
    public void startDocSnapshot(Integer r100, Drawable r101, yo9.a r102) {
        if (getActivity().getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) goto L7;
        FLogger.f375446a.w("SnapshotPlugin", "onRequestSnapshot, activity is not RESUMED");
        return;
    L7:
        if (getUIContainer() != null) goto L10;
        FLogger.f375446a.w("SnapshotPlugin", "onRequestSnapshot After ui detach");
        return;
    L10:
        realStartDocSnapshot(r100, r101, r102);
    }
}
