package com.obric.assistant.obric_action.handler.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.IObricActionService;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import com.obric.assistant.utils.e;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001b\u001cB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/obric_action/handler/activity/FinishCurrentPageHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/activity/FinishCurrentPageHandler$Params;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/activity/FinishCurrentPageHandler$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scheduleDispatchAfterStopped", PickerReporterConstants.KEY.TARGET, "Landroid/app/Activity;", "flowIntent", "", "dispatchFlowIntent", "", "Companion", "Params", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FinishCurrentPageHandler implements IObricActionHandler<b, Unit> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f390450c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<b> f390451b;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/obric_action/handler/activity/FinishCurrentPageHandler$Params;", "", "flowIntent", "", "<init>", "(Ljava/lang/String;)V", "getFlowIntent", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("flow_intent")
        private final String flowIntent;

        public b() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.flowIntent, ((b) r100).flowIntent) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.flowIntent;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Params(flowIntent=" + this.flowIntent + ')';
        }

        public final String a() {
            return this.flowIntent;
        }

        public b(int r100) {
            this.flowIntent = null;
        }
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r100 = d.a.f390405a;
        return d.a.f390405a;
    }

    public FinishCurrentPageHandler() {
        this.f390451b = b.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<b> b() {
        return this.f390451b;
    }

    public static boolean e(Context r100, String r101) {
        boolean r102 = false;
        if (r101.length() != 0) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L25;
        FLogger.f375446a.i("FinishCurrentPageHandler", "dispatchFlowIntent: flowIntent is empty, skip");
        return true;
    L25:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L15
        FLogger.f375446a.i("FinishCurrentPageHandler", "dispatchFlowIntent: dispatch flowIntent = ".concat(r101));     // Catch: Throwable -> L15
        IObricActionService r105 = (IObricActionService) ServiceManager.get().getService(IObricActionService.class);     // Catch: Throwable -> L15
        if (r105 == null) goto L13;
        r105.d(r100, r101, "always_pass");     // Catch: Throwable -> L15
        r102 = true;
    L13:
        Object r106 = Result.m9449constructorimpl(Boolean.valueOf(r102));     // Catch: Throwable -> L15
    L17:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L20;
        FLogger.f375446a.w("FinishCurrentPageHandler", "dispatchFlowIntent: dispatch failed. " + r107.getMessage(), r107);
    L20:
        Boolean r108 = Boolean.TRUE;
        if (Result.m9455isFailureimpl(r106) == false) goto L24;
        r106 = r108;
    L24:
        return ((Boolean) r106).booleanValue();
    L15:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    L5:
        r103 = false;
        goto L7
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final b a(Context r100, String r101) {
        return (b) IObricActionHandler.b.a(this, r100, r101);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(final Context r100, b r101, Continuation<? super h<? extends Unit>> r102) {
        b r103 = r101;
        boolean r104 = false;
        if (r103 != null) goto L5;
        r103 = new b(0);
    L5:
        FLogger r105 = FLogger.f375446a;
        r105.i("FinishCurrentPageHandler", "handle: params = " + r103);
        final String r106 = r103.a();
        if (r106 != null) goto L9;
        r106 = "";
    L9:
        if ((r100 instanceof Activity) == false) goto L11;
        Activity r107 = (Activity) r100;
    L13:
        if (r107 != null) goto L20;
        int r108 = e.f393874a;
        r107 = (Activity) e.a(Activity.class);
        if (r107 != null) goto L17;
    L19:
        r107 = null;
        goto L20
    L17:
        if ((!r107.isFinishing()) == false) goto L19;
    L20:
        if (r107 != null) goto L23;
        r105.w("FinishCurrentPageHandler", "handle: no available activity to finish, dispatch flowIntent immediately");
        return h.f390443d.b(e(r100, r106));
    L23:
        if (r106.length() <= 0) goto L25;
        r104 = true;
    L25:
        if (r104 == false) goto L35;
        final Handler r109 = new Handler(Looper.getMainLooper());
        if ((r107 instanceof LifecycleOwner) == false) goto L29;
        LifecycleOwner r110 = (LifecycleOwner) r107;
    L30:
        if (r110 == null) goto L35;
        Lifecycle r111 = r110.getLifecycle();
        if (r111 == null) goto L35;
        r111.addObserver(new FinishCurrentPageHandler$scheduleDispatchAfterStopped$1(r109, this, r100, r106));
        goto L35
    L29:
        r110 = null;
    L35:
        if (r107.isFinishing() == false) goto L37;
    L39:
        r105.i("FinishCurrentPageHandler", "handle: activity already finishing/destroyed, skip finish call");
    L41:
        return h.a.c(h.f390443d, null, null, 3);
    L37:
        if (r107.isDestroyed() == true) goto L39;
        r105.i("FinishCurrentPageHandler", "handle: finish activity " + r107);
        r107.finish();
        goto L41
    L11:
        r107 = null;
        goto L13
    }
}
