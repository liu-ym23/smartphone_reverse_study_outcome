package com.bytedance.ee.bear.document.print;

import android.app.Application;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.analytic.BatterySceneData;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 `2\u00020\u0001:\u0001`B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0014\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0#J\u0014\u0010$\u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0#J\u0016\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J \u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J \u00101\u001a\u00020!2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'2\u0006\u00102\u001a\u00020)H\u0002J\u001e\u00103\u001a\b\u0012\u0004\u0012\u00020\u001f042\u0006\u00105\u001a\u0002062\u0006\u00102\u001a\u00020)H\u0002J\u001e\u00107\u001a\b\u0012\u0004\u0012\u00020\u001f042\u0006\u00105\u001a\u0002062\u0006\u00102\u001a\u00020)H\u0002J \u00108\u001a\u00020!2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J4\u00109\u001a\u00020!2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010:\u001a\u00020\u001f2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010)H\u0002J(\u0010<\u001a\u00020=2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010>\u001a\u00020)H\u0002J0\u0010?\u001a\u00020!2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010>\u001a\u00020)2\u0006\u0010@\u001a\u00020AH\u0002J2\u0010B\u001a\u00020!2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010C\u001a\u0002062\b\u0010D\u001a\u0004\u0018\u00010EH\u0002J(\u0010F\u001a\u00020!2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010I\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u0013H\u0002J\u0018\u0010J\u001a\u00020!2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010K\u001a\u000206H\u0002J\b\u0010L\u001a\u00020!H\u0002J\u0010\u0010M\u001a\u00020!2\u0006\u0010+\u001a\u00020\u0013H\u0002J\u0010\u0010N\u001a\u00020!2\u0006\u0010+\u001a\u00020\u0013H\u0002J\u0018\u0010O\u001a\u00020!2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010P\u001a\u00020\u001fH\u0002J\u0010\u0010Q\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u0013H\u0002J\b\u0010R\u001a\u00020!H\u0002J\b\u0010S\u001a\u00020!H\u0002J\b\u0010T\u001a\u00020!H\u0002J\b\u0010U\u001a\u00020!H\u0002J\b\u0010V\u001a\u00020\u001fH\u0002J\u0010\u0010W\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010X\u001a\u00020)2\u0006\u0010&\u001a\u00020'H\u0002J\u0018\u0010Y\u001a\u00020!2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010Z\u001a\u0002062\u0006\u0010C\u001a\u000206H\u0003J*\u0010[\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010C\u001a\u0002062\b\u0010D\u001a\u0004\u0018\u00010EH\u0002J\u0010\u0010\\\u001a\u00020\u001f2\u0006\u0010C\u001a\u000206H\u0002J\u0010\u0010]\u001a\u00020\u001f2\u0006\u0010C\u001a\u000206H\u0002J\u0012\u0010^\u001a\u00020!2\b\b\u0003\u0010_\u001a\u000206H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b¨\u0006a"}, d2 = {"Lcom/bytedance/ee/bear/document/print/PrintExportCoordinator;", "Landroidx/lifecycle/LifecycleEventObserver;", "activity", "Landroidx/fragment/app/FragmentActivity;", "pluginHost", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/bytedance/ee/bear/document/DocumentPluginHost;)V", "executor", "Lcom/bytedance/ee/bear/document/export/net/exportV2/DocumentExportExecutorImplV2;", "commentCheckDisposable", "Lio/reactivex/disposables/Disposable;", "minutesOptionSelector", "Lcom/bytedance/ee/bear/document/print/PrintMinutesOptionSelector;", "contentOptionDialog", "Lcom/bytedance/ee/bear/document/print/PrintContentOptionDialogFragment;", "loadingDialog", "Lcom/bytedance/ee/bear/document/print/PrintExportLoadingDialogFragment;", "nextRequestId", "", "activeRequestId", "Ljava/lang/Long;", "flowState", "Lcom/bytedance/ee/bear/document/print/PrintFlowState;", "pageviewServiceExecutor", "Lcom/bytedance/ee/bear/more/pageview2/PageviewServiceExecutor;", "getPageviewServiceExecutor", "()Lcom/bytedance/ee/bear/more/pageview2/PageviewServiceExecutor;", "pageviewServiceExecutor$delegate", "Lkotlin/Lazy;", "isActive", "", "observeFlowState", "", "observer", "Landroidx/lifecycle/Observer;", "removeFlowStateObserver", BatterySceneData.OPT_START, "moreInfo", "Lcom/bytedance/ee/bear/more/export/IMoreInfo;", "exportToken", "", "showMinutesOptions", "requestId", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "checkCommentAvailability", "realToken", "queryCommentState", "Lio/reactivex/Single;", "realType", "", "queryCommentStateFromServer", "showContentOptions", "beginExport", "includeComments", "passback", "createCallback", "Lcom/bytedance/ee/bear/contract/export/DocumentExportCallback;", "printFileName", "preparePrintArtifact", "uri", "Landroid/net/Uri;", "handleExportFailure", "code", "throwable", "", "deliverPrintArtifact", "artifact", "Lcom/bytedance/ee/bear/document/print/PrintArtifact;", "showLoading", "updateProgress", "progress", "cancelCurrentRequest", "cancelRequest", "finishRequest", "endRequest", "cancelExecutor", "isRequestActive", "disposeCommentCheck", "hideMinutesOptions", "hideContentOptions", "hideLoading", "isActivityAvailable", "isThreeInOneMinutesPrintEnabled", "buildFileName", "reportPrintAudit", "resolvePrintFailureMessage", "handlePermissionFailure", "isDlpErrorCode", "isDlpSensitiveErrorCode", "showPrintFailureIfPossible", "messageRes", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PrintExportCoordinator implements LifecycleEventObserver {
    public static final /* synthetic */ int l = 0;
    public final FragmentActivity a;
    public final DocumentPluginHost b;
    public com.bytedance.ee.bear.document.export.net.exportV2.a c;
    public Disposable d;
    public PrintMinutesOptionSelector e;
    public PrintContentOptionDialogFragment f;
    public PrintExportLoadingDialogFragment g;
    public long h;
    public Long i;
    public final PrintFlowState j;
    public final Lazy k;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PrintExportCoordinator a;
        public final /* synthetic */ long b;
        public final /* synthetic */ oj5.c c;
        public final /* synthetic */ String d;

        public b(PrintExportCoordinator r1, long r2, oj5.c r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
        }

        public final void accept(Object r10) {
            Boolean r11 = (Boolean) r10;
            PrintExportCoordinator r0 = this.a;
            r0.d = null;
            if (r0.k(this.b) == true) goto L6;
            return;
        L6:
            if (r11.booleanValue() == false) goto L8;
            PrintExportCoordinator.b(this.a, this.b, this.c, this.d);
            return;
        L8:
            int r12 = com.bytedance.ee.bear.document.print.b.a;
            oj5.c r13 = this.c;
            String r1 = this.d;
            Intrinsics.checkNotNullParameter(r13, "moreInfo");
            Intrinsics.checkNotNullParameter(r1, "exportToken");
            com.bytedance.ee.bear.document.print.b.c("print_context", r13, r1);
            oj5.c r14 = this.c;
            String r2 = this.d;
            Intrinsics.checkNotNullParameter(r14, "moreInfo");
            Intrinsics.checkNotNullParameter(r2, "exportToken");
            com.bytedance.ee.bear.document.print.b.c(TipCallBackData.CONFIRM, r14, r2);
            this.a.d(this.b, this.c, this.d, false, null);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ PrintExportCoordinator a;
        public final /* synthetic */ long b;
        public final /* synthetic */ oj5.c c;
        public final /* synthetic */ String d;

        public c(PrintExportCoordinator r1, long r2, oj5.c r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            PrintExportCoordinator r0 = this.a;
            r0.d = null;
            if (r0.k(this.b) == false) goto L7;
            tt5.a.k("PrintExportCoordinator", "query comment state failed, show content options: ".concat(r6.getClass().getSimpleName()));
            PrintExportCoordinator.b(this.a, this.b, this.c, this.d);
            return;
        }
    }

    static {
    }

    public final void g() {
        PrintContentOptionDialogFragment r0 = this.f;
        this.f = null;
        if (r0 == null) goto L22;
        r0.h = null;     // Catch: RuntimeException -> L13
        r0.i = null;     // Catch: RuntimeException -> L13
        r0.j = null;     // Catch: RuntimeException -> L13
        if (r0.isAdded() == true) goto L19;
    L16:
        return;
    L19:
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: RuntimeException -> L13
        Throwable r1 = DialogFragmentLancet.sLastShowStack;     // Catch: RuntimeException -> L13
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: RuntimeException -> L13
    L13:
        e = move-exception;
        tt5.a.k("PrintExportCoordinator", "dismiss content options failed: ".concat(e.getClass().getSimpleName()));
        return;
    }

    public final void h() {
        PrintExportLoadingDialogFragment r0 = this.g;
        this.g = null;
        if (r0 == null) goto L19;
        r0.i = null;     // Catch: RuntimeException -> L12
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L7
    L21:
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: RuntimeException -> L12
        Throwable r1 = DialogFragmentLancet.sLastShowStack;     // Catch: RuntimeException -> L12
        if (r1 == null) goto L20;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: RuntimeException -> L12
        return;
    L20:
        return;
    L12:
        e = move-exception;
        tt5.a.k("PrintExportCoordinator", "dismiss print loading failed: ".concat(e.getClass().getSimpleName()));
        return;
    }

    public final boolean i() {
        return this.j.isActive();
    }

    public final boolean j() {
        if (this.a.isFinishing() == false) goto L5;
    L11:
        return false;
    L5:
        if (this.a.isDestroyed() == true) goto L11;
        if (this.a.getSupportFragmentManager().isStateSaved() == true) goto L11;
        if (this.a.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L11;
        return true;
    }

    public static boolean l(oj5.c r4) {
        boolean r0 = false;
        if (r4.h() == true) goto L5;
        return false;
    L5:
        com.bytedance.ee.bear.appsetting.c r5 = com.bytedance.ee.bear.appsetting.c.a.a;
        Application r1 = LarkContext.getApplication();
        r5.getClass();
        if (((dn4.a) e0c.k.b(((v) e0c.k.a(r1, v.class)).c(((com.ss.android.lark.passportc.convention.a) e0c.k.a(r1, com.ss.android.lark.passportc.convention.a.class)).b()), dn4.a.class)).a().isCurrentEnable("vc_record_notes_view_three_in_one") == true) goto L9;
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L9;
    L10:
        tt5.a.h("PrintExportCoordinator", "isThreeInOneMinutesPrintEnabled: " + r0);
        return r0;
    L9:
        r0 = true;
        goto L10
    }

    public static void n(PrintExportCoordinator r1) {
        if (r1.j() == false) goto L6;
        Toast.showFailureText(r1.a, 2131889210);
        return;
    }

    public final boolean k(long r4) {
        Long r0 = this.i;
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.longValue() != r4) goto L8;
        return true;
    }

    public PrintExportCoordinator(FragmentActivity r2, DocumentPluginHost r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "pluginHost");
        this.a = r2;
        this.b = r3;
        this.j = (PrintFlowState) ViewModelProviders.of(r2).get(PrintFlowState.class);
        this.k = LazyKt.lazy(LazyThreadSafetyMode.NONE, PrintExportCoordinator$pageviewServiceExecutor$2.INSTANCE);
    }

    public final void f(long r5, boolean r7) {
        if (k(r5) == true) goto L5;
        return;
    L5:
        this.i = null;
        Disposable r6 = this.d;
        if (r6 == null) goto L8;
        r6.dispose();
    L8:
        this.d = null;
        PrintMinutesOptionSelector r8 = this.e;
        this.e = null;
        if (r8 == null) goto L11;
        r8.b++;
        r8.c = true;
        r8.c();
    L11:
        com.bytedance.ee.bear.document.export.net.exportV2.a r9 = this.c;
        this.c = null;
        if (r7 == false) goto L18;
        if (r9 == null) goto L18;
        r9.cancel();     // Catch: RuntimeException -> L16
    L16:
        e = move-exception;
        tt5.a.k("PrintExportCoordinator", "cancel print export failed: ".concat(e.getClass().getSimpleName()));
    L18:
        g();
        h();
        this.a.getLifecycle().removeObserver(this);
        this.j.finish();
    }

    public final void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "event");
        if (r3 != Lifecycle.Event.ON_DESTROY) goto L8;
        Long r4 = this.i;
        if (r4 == null) goto L9;
        f(r4.longValue(), true);
        return;
    L9:
        return;
    }

    public static final void c(PrintExportCoordinator r2, long r3, int r5) {
        r2.a.runOnUiThread(new m(r2, r3, r5));
    }

    public final void e(long r10, oj5.c r12, String r13) {
        Disposable r0 = this.d;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        int r1 = r12.i();
        this.d = Single.create(new i(this.b.getWeb())).timeout(3, TimeUnit.SECONDS).onErrorResumeNext(new j(this, r1, r13)).observeOn(fo5.d.d()).subscribe(new b(this, r10, r12, r13), new c(this, r10, r12, r13));
    }

    public final void m(final long r10, final oj5.c r12, final String r13) {
        PrintMinutesOptionSelector r1 = new PrintMinutesOptionSelector(this.a);
        this.e = r1;
        Function1<String, Unit> r8 = new PrintExportCoordinator$showMinutesOptions$1(this, r10, r12, r13);
        Function0<Unit> r6 = new PrintExportCoordinator$showMinutesOptions$2(this, r10);
        Function0<Unit> r7 = new PrintExportCoordinator$showMinutesOptions$3(this, r10);
        Intrinsics.checkNotNullParameter(r12, "moreInfo");
        Intrinsics.checkNotNullParameter(r8, "onSelected");
        Intrinsics.checkNotNullParameter(r6, "onCancel");
        Intrinsics.checkNotNullParameter(r7, "onFailure");
        r1.b++;
        boolean r11 = true;
        r1.c = true;
        r1.c();
        long r2 = 1 + r1.b;
        r1.b = r2;
        r1.c = false;
        String r14 = r12.N();
        if (r14 != null) goto L5;
    L8:
        if (r11 == false) goto L10;
        tt5.a.k("PrintMinutesOptionSelector", "show print minutes options with empty minutes token");
        r1.h(r2, r12, false, r8, r6, r7);
        return;
    L10:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).i0().a().b(r14, 28, "EXPORT", new o(r1, r2, r12, r8, r6, r7));
        return;
    L5:
        if (StringsKt.isBlank(r14) == true) goto L8;
        r11 = false;
        goto L8
    }

    public static final void b(final PrintExportCoordinator r16, final long r17, final oj5.c r19, final String r20) {
        if (r16.k(r17) == true) goto L5;
    L28:
        r16.f(r17, true);
        return;
    L5:
        if (r16.j() == false) goto L28;
        r16.g();
        PrintContentOptionDialogFragment r13 = new PrintContentOptionDialogFragment();
        Function1<Boolean, Unit> r14 = new PrintExportCoordinator$showContentOptions$1(r19, r20);
        Function1<Boolean, Unit> r18 = new PrintExportCoordinator$showContentOptions$2(r16, r19, r20, r17);
        Function0<Unit> r5 = new PrintExportCoordinator$showContentOptions$3(r16, r19, r20, r17);
        Intrinsics.checkNotNullParameter(r14, "onOptionSelected");
        Intrinsics.checkNotNullParameter(r18, "onConfirm");
        Intrinsics.checkNotNullParameter(r5, "onCancel");
        r13.h = r14;
        r13.i = r18;
        r13.j = r5;
        r16.f = r13;
        FragmentManager r2 = r16.a.getSupportFragmentManager();     // Catch: RuntimeException -> L18
        String r3 = "PrintContentOptionDialog_" + r17;     // Catch: RuntimeException -> L18
        LandscapeRestrictionOperation r4 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;     // Catch: RuntimeException -> L18
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r13, r3, r4);     // Catch: RuntimeException -> L18
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r13, r4) == true) goto L14;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L30
    L12:
        r13.showNow(r2, r3);     // Catch: RuntimeException -> L18
    L14:
        if (r13.isAdded() == true) goto L16;
        r16.f = null;     // Catch: RuntimeException -> L18
        r16.f(r17, true);     // Catch: RuntimeException -> L18
        n(r16);     // Catch: RuntimeException -> L18
        return;
    L16:
        int r6 = com.bytedance.ee.bear.document.print.b.a;     // Catch: RuntimeException -> L18
        Intrinsics.checkNotNullParameter(r19, "moreInfo");     // Catch: RuntimeException -> L18
        Intrinsics.checkNotNullParameter(r20, "exportToken");     // Catch: RuntimeException -> L18
        com.bytedance.ee.bear.document.print.b.b("ccm_space_print_view", r19, r20, MapsKt.emptyMap());     // Catch: RuntimeException -> L18
        return;
    L18:
        e = move-exception;
        tt5.a.k("PrintExportCoordinator", "show content options failed: ".concat(e.getClass().getSimpleName()));
        r16.f = null;
        r13.h = null;
        r13.i = null;
        r13.j = null;
        if (r13.isAdded() == true) goto L32;
    L27:
        r16.f(r17, true);
        n(r16);
        return;
    L32:
        r13.dismissAllowingStateLoss();     // Catch: Exception -> L23
    L23:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L27;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L27
    }

    public final void d(final long r26, oj5.c r28, String r29, boolean r30, String r31) {
        if (k(r26) == true) goto L5;
    L66:
        f(r26, true);
        return;
    L5:
        if (j() == false) goto L66;
        g();
        if (j() == false) goto L26;
        h();
        PrintExportLoadingDialogFragment r1 = new PrintExportLoadingDialogFragment();
        r1.i = new PrintExportCoordinator$showLoading$1(this, r26);
        this.g = r1;     // Catch: RuntimeException -> L17
        FragmentManager r2 = this.a.getSupportFragmentManager();     // Catch: RuntimeException -> L17
        String r0 = "PrintExportLoadingDialog_" + r26;     // Catch: RuntimeException -> L17
        LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;     // Catch: RuntimeException -> L17
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, r0, r3);     // Catch: RuntimeException -> L17
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r1, r3) == false) goto L69;
    L16:
        boolean r4 = true;
    L27:
        if (r4 == true) goto L71;
        f(r26, false);
        n(this);
        return;
    L71:
        String r5 = r28.getTitle();     // Catch: Throwable -> L63
        if (r5 != null) goto L33;
    L36:
        boolean r6 = true;
    L37:
        if (r6 == true) goto L39;
    L38:
        String r7 = r5;
        com.bytedance.ee.bear.document.export.net.exportV2.a r8 = new com.bytedance.ee.bear.document.export.net.exportV2.a(this.a, r7);     // Catch: Throwable -> L63
        this.c = r8;     // Catch: Throwable -> L63
        if (r30 == false) goto L43;
        rw4.n r9 = rw4.n.f;     // Catch: Throwable -> L63
    L44:
        rw4.n r10 = r9;
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L63
        String r11 = sbb.e.d(r28.getType()).getType();     // Catch: Throwable -> L63
        String r12 = en4.a.h();     // Catch: Throwable -> L63
        f r13 = new f(this, r26, r28, r29, r7);     // Catch: Throwable -> L63
        Intrinsics.checkNotNullParameter(r10, "format");     // Catch: Throwable -> L63
        Intrinsics.checkNotNullParameter(r11, "type");     // Catch: Throwable -> L63
        Intrinsics.checkNotNullParameter(r29, "token");     // Catch: Throwable -> L63
        Intrinsics.checkNotNullParameter(r12, "eventSource");     // Catch: Throwable -> L63
        Intrinsics.checkNotNullParameter(r13, "callback");     // Catch: Throwable -> L63
        if (r31 != null) goto L47;
    L50:
        boolean r17 = true;
    L51:
        if (r17 == false) goto L75;
        JSONObject r21 = null;
    L57:
        if (r21 != null) goto L59;
        String r22 = r31;
    L61:
        r8.b(r10, r11, r29, r12, r21, r22, true, r13);     // Catch: Throwable -> L63
        return;
    L59:
        r22 = null;
        goto L61
    L75:
        JSONObject r14 = new JSONObject(r31);     // Catch: JSONException -> L55 Throwable -> L63
    L56:
        r21 = r14;
    L55:
        r14 = null;
        goto L56
    L47:
        if (StringsKt.isBlank(r31) == true) goto L50;
        r17 = false;
        goto L51
    L43:
        r9 = rw4.n.d;     // Catch: Throwable -> L63
        goto L44
    L39:
        r5 = ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).getDocumentDefaultName(this.a, r28.getType());     // Catch: Throwable -> L63
        goto L38
    L33:
        if (StringsKt.isBlank(r5) == true) goto L36;
        r6 = false;
    L63:
        th = move-exception;
        tt5.a.d("PrintExportCoordinator", "start print export failed: ".concat(th.getClass().getSimpleName()));
        f(r26, true);
        n(this);
        return;
    L69:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L68
    L15:
        r1.showNow(r2, r0);     // Catch: RuntimeException -> L17
    L17:
        e = move-exception;
        tt5.a.k("PrintExportCoordinator", "show print loading failed: ".concat(e.getClass().getSimpleName()));
        this.g = null;
        r1.i = null;
        if (r1.isAdded() == false) goto L26;
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L22
    L22:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r16 = DialogFragmentLancet.sLastShowStack;
        if (r16 == null) goto L26;
        com.bytedance.crash.d.d(r16, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L26:
        r4 = false;
        goto L27
    }

    public static final void a(PrintExportCoordinator r12, long r13, oj5.c r16, String r17, int r18, Throwable r19) {
        r12.getClass();
        StringBuilder r0 = new StringBuilder("prepare print artifact failed, code=");
        r0.append(r18);
        r0.append(", type=");
        if (r19 == null) goto L5;
        String r2 = r19.getClass().getSimpleName();
    L6:
        r0.append(r2);
        tt5.a.d("PrintExportCoordinator", r0.toString());
        r12.a.runOnUiThread(new g(r12, r13, r16, r17, r18, r19));
        return;
    L5:
        r2 = null;
        goto L6
    }
}
