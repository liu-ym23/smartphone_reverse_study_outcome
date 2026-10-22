package com.larus.login.api;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.router.SmartRouter;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.l1;
import com.larus.common_ui.dialog.p0;
import com.larus.nova.R;
import com.larus.platform.api.ISdkDouyinAuth;
import com.larus.platform.api.SdkOauthTokenTriggerScene;
import com.larus.platform.api.g5;
import com.larus.platform.api.y4;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class CommonDouYinLoginUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CommonDouYinLoginUtil f356945a = null;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/larus/login/api/CommonDouYinLoginUtil$AccountTokenUpdateFailedException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorMsg", "", "errorCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getErrorMsg", "()Ljava/lang/String;", "getErrorCode", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AccountTokenUpdateFailedException extends Exception {
        private final String errorCode;
        private final String errorMsg;

        public final String getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorMsg() {
            return this.errorMsg;
        }

        public AccountTokenUpdateFailedException(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "errorMsg");
            super(r100);
            this.errorMsg = r100;
            this.errorCode = r101;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/larus/login/api/CommonDouYinLoginUtil$BindPlatformFailedException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorCode", "", "errorMsg", "", "authToken", "profileKey", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getErrorCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "getAuthToken", "getProfileKey", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BindPlatformFailedException extends Exception {
        private final String authToken;
        private final int errorCode;
        private final String errorMsg;
        private final String profileKey;

        public final String getAuthToken() {
            return this.authToken;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorMsg() {
            return this.errorMsg;
        }

        public final String getProfileKey() {
            return this.profileKey;
        }

        public BindPlatformFailedException(int r100, String r101, String r102, String r103) {
            super(r101);
            this.errorCode = r100;
            this.errorMsg = r101;
            this.authToken = r102;
            this.profileKey = r103;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/larus/login/api/CommonDouYinLoginUtil$DouYinAccessTokenFailedException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorCode", "", "<init>", "(I)V", "getErrorCode", "()I", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DouYinAccessTokenFailedException extends Exception {
        private final int errorCode;

        public final int getErrorCode() {
            return this.errorCode;
        }

        public DouYinAccessTokenFailedException(int r100) {
            super(String.valueOf(r100));
            this.errorCode = r100;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f356946a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bundle f356947b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f356946a, r101.f356946a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f356947b, r101.f356947b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f356946a.hashCode() * 31;
            Bundle r101 = this.f356947b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "AccountTokenUpdateResult(token=" + this.f356946a + ", bundle=" + this.f356947b + ')';
        }

        public final String a() {
            return this.f356946a;
        }

        public a(String r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "token");
            this.f356946a = r100;
            this.f356947b = r101;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f356948a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f356949b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f356950c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f356951d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f356952e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f356953f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f356954g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final com.larus.login.api.d f356955h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Map<String, Object> f356956i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final AtomicBoolean f356957j;

        public b() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f356948a, r101.f356948a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f356949b, r101.f356949b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f356950c, r101.f356950c) == true) goto L18;
            return false;
        L18:
            if (this.f356951d == r101.f356951d) goto L21;
            return false;
        L21:
            if (this.f356952e == r101.f356952e) goto L24;
            return false;
        L24:
            if (this.f356953f == r101.f356953f) goto L27;
            return false;
        L27:
            if (this.f356954g == r101.f356954g) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f356955h, r101.f356955h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f356956i, r101.f356956i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.f356957j, r101.f356957j) == true) goto L38;
            return false;
        L38:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f356948a.hashCode() * 31) + this.f356949b.hashCode()) * 31) + this.f356950c.hashCode()) * 31;
            int r101 = 1231;
            if (this.f356951d == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f356952e == false) goto L9;
            int r104 = 1231;
        L10:
            int r105 = (r103 + r104) * 31;
            if (this.f356953f == false) goto L13;
            int r106 = 1231;
        L14:
            int r107 = (r105 + r106) * 31;
            if (this.f356954g == true) goto L19;
            r101 = 1237;
        L19:
            return ((((((r107 + r101) * 31) + this.f356955h.hashCode()) * 31) + this.f356956i.hashCode()) * 31) + this.f356957j.hashCode();
        L13:
            r106 = 1237;
            goto L14
        L9:
            r104 = 1237;
            goto L10
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "DouYinTrackerContext(sourcePage=" + this.f356948a + ", sourceMethod=" + this.f356949b + ", popUpType=" + this.f356950c + ", forceRequestServer=" + this.f356951d + ", hasGuidePanel=" + this.f356952e + ", hasNotifyPanel=" + this.f356953f + ", goMarket=" + this.f356954g + ", bindResultToastConfig=" + this.f356955h + ", extraEventParams=" + this.f356956i + ", hasReportedResult=" + this.f356957j + ')';
        }

        public b(String r100, String r101, String r102, boolean r103, boolean r104, boolean r105, boolean r106, com.larus.login.api.d r110, Map r111) {
            AtomicBoolean r107 = new AtomicBoolean(false);
            Intrinsics.checkNotNullParameter(r100, "sourcePage");
            Intrinsics.checkNotNullParameter(r101, "sourceMethod");
            Intrinsics.checkNotNullParameter(r102, "popUpType");
            Intrinsics.checkNotNullParameter(r110, "bindResultToastConfig");
            Intrinsics.checkNotNullParameter(r111, "extraEventParams");
            Intrinsics.checkNotNullParameter(r107, "hasReportedResult");
            this.f356948a = r100;
            this.f356949b = r101;
            this.f356950c = r102;
            this.f356951d = r103;
            this.f356952e = r104;
            this.f356953f = r105;
            this.f356954g = r106;
            this.f356955h = r110;
            this.f356956i = r111;
            this.f356957j = r107;
        }
    }

    public static abstract class c {

        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f356958a = null;

            static {
                f356958a = new a();
            }

            public a() {
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f356959a = null;

            static {
                f356959a = new b();
            }

            public b() {
            }
        }

        public c() {
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FragmentActivity f356960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Handler f356961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f356962c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f356963d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public com.larus.common_ui.dialog.l0 f356964e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public w f356965f;

        public final void b() {
            boolean r100 = true;
            this.f356963d = true;
            w r101 = this.f356965f;
            if (r101 == null) goto L5;
            this.f356961b.removeCallbacks(r101);
        L5:
            Unit r102 = null;
            this.f356965f = null;
            com.larus.common_ui.dialog.l0 r103 = this.f356964e;
            if (r103 != null) goto L8;
        L10:
            r100 = false;
        L11:
            if (r100 == false) goto L26;
            FLogger.f375446a.i("DouYinAuthUtil", "LoadingDialog dismiss");
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L18
            com.larus.common_ui.dialog.l0 r105 = this.f356964e;     // Catch: Throwable -> L18
            if (r105 == null) goto L16;
            a(r105);     // Catch: Throwable -> L18
            r102 = Unit.INSTANCE;     // Catch: Throwable -> L18
        L16:
            Object r106 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L18
        L20:
            Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
            if (r107 == null) goto L27;
            FLogger.f375446a.e("DouYinAuthUtil", "LoadingDialog dismiss error: " + r107.getMessage());
            return;
        L27:
            return;
        L18:
            th = move-exception;
            Result.Companion r108 = Result.Companion;
            r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L20
        L26:
            return;
        L8:
            if (r103.isShowing() != true) goto L10;
            goto L10
        }

        public d(FragmentActivity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            this.f356960a = r100;
            this.f356961b = new Handler(Looper.getMainLooper());
        }

        public static void a(Dialog r100) {
            Handler r101 = DialogLancet.resolveDialogHandler(r100);
            if (r101 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r100);
            r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L17:
            DialogLancet.afterDialogDismiss(r100);
            return;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r102 == null) goto L17;
            com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r100);
            throw th;
        L5:
            if (Looper.myLooper() == r101.getLooper()) goto L8;
            r101.post(DialogLancet.createDismissRunnable(r100));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.login.api.w, java.lang.Runnable] */
        public final void c(long r100, final Function0<Unit> r101) {
            Intrinsics.checkNotNullParameter(r101, "onCancel");
            if (r100 > 0) goto L5;
            return;
        L5:
            FLogger.f375446a.i("DouYinAuthUtil", "LoadingDialogController scheduleDelay interval=" + r100);
            ?? r102 = new w(this, r101);
            this.f356965f = r102;
            this.f356961b.postDelayed(r102, r100);
        }
    }

    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f356966a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f356967b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f356968c = null;

        static {
            int[] r100 = new int[DouYinBindStatus.values().length];
            r100[DouYinBindStatus.ALREADY_BOUND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L30
        L74:
            r100[DouYinBindStatus.GO_MARKET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L31
        L82:
            r100[DouYinBindStatus.GO_ACCOUNT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L32
        L54:
            r100[DouYinBindStatus.SUCCESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L33
        L56:
            r100[DouYinBindStatus.CANCEL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L34
        L66:
            r100[DouYinBindStatus.FAILURE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L35
        L14:
            f356966a = r100;
            int[] r101 = new int[DismissReason.values().length];
            r101[DismissReason.Cancel.ordinal()] = 1;     // Catch: NoSuchFieldError -> L36
        L58:
            r101[DismissReason.Close.ordinal()] = 2;     // Catch: NoSuchFieldError -> L37
        L68:
            r101[DismissReason.Unknown.ordinal()] = 3;     // Catch: NoSuchFieldError -> L38
        L76:
            r101[DismissReason.NOT_HANDLED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L39
        L48:
            r101[DismissReason.Confirm.ordinal()] = 5;     // Catch: NoSuchFieldError -> L40
        L20:
            f356967b = r101;
            int[] r102 = new int[CommonDouYinLoginTracker.ResultStage.values().length];
            r102[CommonDouYinLoginTracker.ResultStage.SWITCH_BIND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L41
        L80:
            r102[CommonDouYinLoginTracker.ResultStage.CHANGE_BIND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L42
        L52:
            r102[CommonDouYinLoginTracker.ResultStage.DOUYIN_AUTH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L43
        L60:
            r102[CommonDouYinLoginTracker.ResultStage.BIND_TOKEN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L44
        L70:
            r102[CommonDouYinLoginTracker.ResultStage.REFRESH_AFTER_SWITCH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L45
        L78:
            r102[CommonDouYinLoginTracker.ResultStage.REFRESH_AFTER_CHANGE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L46
        L62:
            r102[CommonDouYinLoginTracker.ResultStage.REFRESH_AFTER_BIND.ordinal()] = 7;     // Catch: NoSuchFieldError -> L47
        L28:
            f356968c = r102;
        }
    }

    public static final class f implements Function2<Boolean, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<Pair<Boolean, Integer>> f356969a;

        public f(kotlinx.coroutines.j r100) {
            this.f356969a = r100;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Boolean r100, Integer r101) {
            boolean r102 = r100.booleanValue();
            Integer r103 = r101;
            if (this.f356969a.isActive() == false) goto L7;
            FLogger.f375446a.i("DouYinAuthUtil", "awaitGoToChangeBind callback, success=" + r102 + ", errorCode=" + r103);
            kotlinx.coroutines.i<Pair<Boolean, Integer>> r104 = this.f356969a;
            Result.Companion r105 = Result.Companion;
            r104.resumeWith(Result.m9449constructorimpl(TuplesKt.to(Boolean.valueOf(r102), r103)));
        L7:
            return Unit.INSTANCE;
        }
    }

    public static final class g implements Function2<Boolean, String, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<Pair<Boolean, String>> f356970a;

        public g(kotlinx.coroutines.j r100) {
            this.f356970a = r100;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Boolean r100, String r101) {
            boolean r102 = r100.booleanValue();
            String r103 = r101;
            if (this.f356970a.isActive() == false) goto L7;
            FLogger.f375446a.i("DouYinAuthUtil", "awaitGoToSwitchBind callback, success=" + r102 + ", latestError=" + r103);
            kotlinx.coroutines.i<Pair<Boolean, String>> r104 = this.f356970a;
            Result.Companion r105 = Result.Companion;
            r104.resumeWith(Result.m9449constructorimpl(TuplesKt.to(Boolean.valueOf(r102), r103)));
        L7:
            return Unit.INSTANCE;
        }
    }

    public static final class h implements p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f356971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CompletableDeferred<Boolean> f356972b;

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
            FLogger.f375446a.i("DouYinAuthUtil", "goToChangeBind confirm");
            SmartRouter.buildRoute(this.f356971a, "//flow/setting_account_info").d();
            this.f356972b.complete(Boolean.TRUE);
        }

        public h(FragmentActivity r100, CompletableDeferred<Boolean> r101) {
            this.f356971a = r100;
            this.f356972b = r101;
        }
    }

    public static final class i implements com.larus.common_ui.dialog.u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompletableDeferred<Boolean> f356973a;

        @Override // com.larus.common_ui.dialog.u
        public final void cancel() {
            FLogger.f375446a.i("DouYinAuthUtil", "goToChangeBind cancel via cancelButton");
            this.f356973a.complete(Boolean.FALSE);
        }

        public i(CompletableDeferred<Boolean> r100) {
            this.f356973a = r100;
        }
    }

    public static final class j implements l1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompletableDeferred<Boolean> f356974a;

        @Override // com.larus.common_ui.dialog.l1
        public final void a() {
            FLogger.f375446a.i("DouYinAuthUtil", "goToChangeBind cancel via whiteClick");
            this.f356974a.complete(Boolean.FALSE);
        }

        public j(CompletableDeferred<Boolean> r100) {
            this.f356974a = r100;
        }
    }

    public static final class k implements y4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<a> f356975a;

        public k(kotlinx.coroutines.j r100) {
            this.f356975a = r100;
        }

        @Override // com.larus.platform.api.y4
        public final void a(String r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "token");
            if (this.f356975a.isActive() == true) goto L5;
            return;
        L5:
            FLogger.f375446a.i("DouYinAuthUtil", "awaitUpdateAccountToken callback success, authCode received (masked)");
            kotlinx.coroutines.i<a> r102 = this.f356975a;
            Result.Companion r103 = Result.Companion;
            r102.resumeWith(Result.m9449constructorimpl(new a(r100, r101)));
        }

        @Override // com.larus.platform.api.y4
        public final void onFailure(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "errorMessage");
            if (this.f356975a.isActive() == true) goto L5;
            return;
        L5:
            FLogger.f375446a.e("DouYinAuthUtil", "awaitUpdateAccountToken callback failed, errorCode=" + r101 + ", msg=" + r100);
            kotlinx.coroutines.i<a> r102 = this.f356975a;
            Result.Companion r103 = Result.Companion;
            r102.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(new AccountTokenUpdateFailedException(r100, r101))));
        }
    }

    static {
        f356945a = new CommonDouYinLoginUtil();
    }

    public CommonDouYinLoginUtil() {
    }

    public static void p() {
        AppHost.Companion r100 = AppHost.f326268a;
        String r101 = ContextCompat.getString(r100.getApplication(), R.string.larus_auth_douyin_toast_success_cn);
        t19.s r102 = t19.s.f544207a;
        Context r103 = v19.f.d(r100.getApplication());
        r102.getClass();
        t19.s.p(r103, r101);
    }

    public static Bundle r(Map r100) {
        if (r100.isEmpty() == true) goto L5;
        Bundle r101 = new Bundle();
        Iterator r102 = r100.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L30;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();
        Object r105 = r103.getValue();
        if (r105 == null) goto L8;
        if ((r105 instanceof String) == true) goto L13;
        if ((r105 instanceof Integer) == true) goto L16;
        if ((r105 instanceof Long) == true) goto L19;
        if ((r105 instanceof Boolean) == true) goto L22;
        if ((r105 instanceof Double) == true) goto L25;
        if ((r105 instanceof Float) == true) goto L28;
        r101.putString(r104, r105.toString());
        goto L8
    L28:
        r101.putFloat(r104, ((Number) r105).floatValue());
        goto L8
    L25:
        r101.putDouble(r104, ((Number) r105).doubleValue());
        goto L8
    L22:
        r101.putBoolean(r104, ((Boolean) r105).booleanValue());
        goto L8
    L19:
        r101.putLong(r104, ((Number) r105).longValue());
        goto L8
    L16:
        r101.putInt(r104, ((Number) r105).intValue());
        goto L8
    L13:
        r101.putString(r104, (String) r105);
        goto L8
    L30:
        return r101;
    L5:
        return new Bundle();
    }

    public static Job s(k0 r110) {
        Intrinsics.checkNotNullParameter(r110, "info");
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("tryToBindDouYin start, page=");
        r101.append(r110.f357062b);
        r101.append(", method=");
        r101.append(r110.f357063c);
        r101.append(", forceRequestServer=");
        r101.append(r110.f357066f);
        r101.append(", goMarket=");
        r101.append(r110.f357065e);
        r101.append(", hasGuidePanel=");
        if (r110.f357071k == null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        r101.append(", hasNotifyPanel=");
        if (r110.f357070j == null) goto L9;
        boolean r103 = true;
    L10:
        r101.append(r103);
        r101.append(", loadingStartDelay=");
        r101.append(r110.f357072l);
        r100.i("DouYinAuthUtil", r101.toString());
        LoginService r104 = LoginService.f356989a;
        ISdkDouyinAuth r105 = com.larus.platform.service.i0.a();
        if (r105 != null) goto L14;
        r100.e("DouYinAuthUtil", "tryToBindDouYin failed: LoginService is null");
        r110.f357067g.a(DouYinBindStatus.FAILURE, 0, "LoginService is null.");
        return null;
    L14:
        CoroutineScope r106 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        r100.i("DouYinAuthUtil", "tryToBindDouYin launch coroutine with SupervisorJob");
        return BuildersKt.launch$default(r106, null, null, new CommonDouYinLoginUtil$tryToBindDouYin$1(r104, r105, r110, r106, null), 3, null);
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public final Object k(Continuation<? super Boolean> r100) {
        if ((r100 instanceof CommonDouYinLoginUtil$checkDouYinAuth$1) == false) goto L7;
        CommonDouYinLoginUtil$checkDouYinAuth$1 r101 = (CommonDouYinLoginUtil$checkDouYinAuth$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L14;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L22
    L26:
    L25:
        return Boxing.boxBoolean(r106);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
        ISdkDouyinAuth r107 = com.larus.platform.service.i0.a();
        if (r107 != null) goto L19;
        FLogger.f375446a.e("DouYinAuthUtil", "checkDouYinAuth failed: LoginService is null");
        return null;
    L19:
        SdkOauthTokenTriggerScene r108 = SdkOauthTokenTriggerScene.Request;     // Catch: Throwable -> L22
        r101.label = 1;     // Catch: Throwable -> L22
        if (d(r107, false, r108, r101) != r104) goto L26;
        return r104;
    L22:
        th = move-exception;
        FLogger.f375446a.i("DouYinAuthUtil", "not bound or token fetch failed, " + th.getMessage());
        r106 = false;
    L7:
        r101 = new CommonDouYinLoginUtil$checkDouYinAuth$1(this, r100);
        goto L8
    }

    public static void b(b0 r100, b r101, CommonDouYinLoginTracker.ResultStage r102) {
        FLogger.f375446a.i("DouYinAuthUtil", "callback ALREADY_BOUND, stage=" + r102 + ", code=0, msg=The current account is already linked to Douyin.");
        o(r100, r101, CommonDouYinLoginTracker.AuthResult.SUCCESS, r102, DouYinBindStatus.ALREADY_BOUND, 0, "The current account is already linked to Douyin.");
    }

    public static Object c(ISdkDouyinAuth r100, String r101, Continuation r102) {
        kotlinx.coroutines.j r103 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);
        r103.C();
        r100.g(r101, new y(r103));
        Object r104 = r103.B();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L5:
        return r104;
    }

    public static Object g(FragmentActivity r100, String r101, Continuation r102) {
        if (r101 != null) goto L7;
        return Boxing.boxBoolean(false);
    L7:
        if (r100.getSupportFragmentManager().isStateSaved() == false) goto L10;
        FLogger.f375446a.w("DouYinAuthUtil", "awaitPromptGoToAccount: FragmentManager is already in saved state, abort showing dialog.");
        return Boxing.boxBoolean(false);
    L10:
        final CompletableDeferred r103 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        String r104 = ContextCompat.getString(r100, R.string.larus_auth_douyin_popUp_title_conflict_cn);
        String r105 = ContextCompat.getString(r100, R.string.larus_auth_douyin_popUp_btn_setUp_cn);
        CommonDialog.a r106 = new CommonDialog.a();
        r106.i(r104);
        Intrinsics.checkNotNullParameter(r101, "message");
        r106.f327180i = r101;
        CommonDialog.a.f(r106, new h(r100, r103), r105, false, 12);
        CommonDialog.a.e(r106, new i(r103), r100.getString(R.string.larus_rebind_douyin_confirmWindow_cancel_cn), 4);
        j r107 = new j(r103);
        Intrinsics.checkNotNullParameter(r107, "listener");
        r106.f327193v = r107;
        Function0<Boolean> r108 = new s(r103);
        Intrinsics.checkNotNullParameter(r108, "callback");
        r106.B = r108;
        CommonDialog r109 = r106.a();
        FragmentManager r110 = r100.getSupportFragmentManager();
        LandscapeRestrictionOperation r111 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r109, null, r111);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r110, r109, r111) == false) goto L27;
    L15:
        Window r112 = r100.getWindow();
        if (r112 == null) goto L25;
        View r113 = r112.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L22;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r114 = ThreadMethodProxy.currentThread();
        if (r114 == com.larus.home.impl.utils.c.f346341a) goto L22;
        com.larus.home.impl.utils.c.a(r114, "getDecorView");
    L22:
        if (r113 == null) goto L25;
        r113.announceForAccessibility(r104);
    L25:
        return r103.await(r102);
    L27:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L26
    L14:
        r109.show(r110, null);
        goto L15
    }

    public static Object h(ISdkDouyinAuth r100, Bundle r101, Continuation r102) {
        kotlinx.coroutines.j r103 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);
        r103.C();
        r100.h(new k(r103), "", false, r101);
        Object r104 = r103.B();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L5:
        return r104;
    }

    public static Object d(ISdkDouyinAuth r100, boolean r101, SdkOauthTokenTriggerScene r102, ContinuationImpl r103) {
        kotlinx.coroutines.j r104 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r103), 1);
        r104.C();
        r100.a(r101, r102, new z(r104));
        Object r105 = r104.B();
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r103);
    L5:
        return r105;
    }

    public static Object f(ILoginApi r100, FragmentActivity r101, SwitchBindParam r102, Continuation r103) {
        kotlinx.coroutines.j r104 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r103), 1);
        r104.C();
        r100.F(r101, r102, new g(r104));
        Object r105 = r104.B();
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r103);
    L5:
        return r105;
    }

    public static void n(b0 r100, b r101, CommonDouYinLoginTracker.ResultStage r102, int r110) {
        FLogger.f375446a.i("DouYinAuthUtil", "callback GO_MARKET, stage=" + r102 + ", code=" + r110 + ", msg=Bind Douyin failed. Please download Douyin first.");
        o(r100, r101, CommonDouYinLoginTracker.AuthResult.GO_MARKET, r102, DouYinBindStatus.GO_MARKET, r110, "Bind Douyin failed. Please download Douyin first.");
    }

    public static void j(b0 r110, b r111, CommonDouYinLoginTracker.ResultStage r112, int r113, String r114) {
        FLogger.f375446a.w("DouYinAuthUtil", "callback CANCEL, stage=" + r112 + ", code=" + r113 + ", msg=" + r114);
        o(r110, r111, CommonDouYinLoginTracker.AuthResult.CANCEL, r112, DouYinBindStatus.CANCEL, r113, r114);
    }

    public static void l(b0 r110, b r111, CommonDouYinLoginTracker.ResultStage r112, int r113, String r114) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "trackerContext");
        Intrinsics.checkNotNullParameter(r112, "stage");
        FLogger.f375446a.e("DouYinAuthUtil", "callback FAILURE, stage=" + r112 + ", code=" + r113 + ", msg=" + r114);
        o(r110, r111, CommonDouYinLoginTracker.AuthResult.FAIL, r112, DouYinBindStatus.FAILURE, r113, r114);
    }

    public static void m(b0 r110, b r111, CommonDouYinLoginTracker.ResultStage r112, int r113, String r114) {
        FLogger.f375446a.i("DouYinAuthUtil", "callback GO_ACCOUNT, stage=" + r112 + ", code=" + r113 + ", msg=" + r114);
        o(r110, r111, CommonDouYinLoginTracker.AuthResult.GO_ACCOUNT, r112, DouYinBindStatus.GO_ACCOUNT, r113, r114);
    }

    public static void q(b0 r110, b r111, CommonDouYinLoginTracker.ResultStage r112, int r113, String r114) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "trackerContext");
        Intrinsics.checkNotNullParameter(r112, "stage");
        FLogger.f375446a.i("DouYinAuthUtil", "callback SUCCESS, stage=" + r112 + ", code=" + r113 + ", msg=" + r114);
        o(r110, r111, CommonDouYinLoginTracker.AuthResult.SUCCESS, r112, DouYinBindStatus.SUCCESS, r113, r114);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v107 */
    /* JADX WARN: Type inference failed for: r0v108 */
    /* JADX WARN: Type inference failed for: r0v53, types: [T] */
    /* JADX WARN: Type inference failed for: r0v70, types: [T, com.larus.login.api.CommonDouYinLoginTracker$ResultStage] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r15v1, types: [com.larus.login.api.o] */
    /* JADX WARN: Type inference failed for: r42v0, types: [com.larus.login.api.CommonDouYinLoginUtil, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v21, types: [com.larus.login.api.n] */
    /* JADX WARN: Type inference failed for: r7v23, types: [com.larus.login.api.u] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v5, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [com.larus.login.api.CommonDouYinLoginTracker$ResultStage] */
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
    public static final Object a(CommonDouYinLoginUtil r410, LoginService r411, ISdkDouyinAuth r412, k0 r413, CoroutineScope r414, Continuation r415) {
        ILoginApi r100 = r411;
        final k0 r101 = r413;
        r410.getClass();
        if ((r415 instanceof CommonDouYinLoginUtil$tryToBindDouYinInternal$1) == false) goto L7;
        CommonDouYinLoginUtil$tryToBindDouYinInternal$1 r102 = (CommonDouYinLoginUtil$tryToBindDouYinInternal$1) r415;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        CommonDouYinLoginUtil$tryToBindDouYinInternal$1 r110 = r102;
        Object r104 = r110.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r110.label;
        if (r106 == 0) goto L26;
        if (r106 == 1) goto L17;
        if (r106 == 2) goto L16;
        if (r106 != 3) goto L15;
        ResultKt.throwOnFailure(r104);
    L247:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        final Ref.ObjectRef r107 = (Ref.ObjectRef) r110.L$2;
        b r108 = (b) r110.L$1;
        k0 r109 = (k0) r110.L$0;
        ResultKt.throwOnFailure(r104);
    L213:
        c r111 = (c) r104;
        if (Intrinsics.areEqual(r111, c.b.f356959a) == false) goto L220;
        FLogger.f375446a.i("DouYinAuthUtil", "goMarket confirm, launching market");
        int r112 = CommonDouYinLoginTracker.f356940a;
        CommonDouYinLoginTracker.b(r109.f357062b, r109.f357063c, r109.f357064d, "download", "confirm", r109.f357068h);
        com.larus.login.api.b r113 = r109.f357074n;
        if (r113 == null) goto L218;
        r113.b(r109.f357062b, r109.f357071k, r109.f357068h);
    L218:
        e0.a();
        n(r109.f357067g, r108, (CommonDouYinLoginTracker.ResultStage) r107.element, -10011);
    L281:
        return Unit.INSTANCE;
    L220:
        if (Intrinsics.areEqual(r111, c.a.f356958a) == false) goto L222;
        FLogger.f375446a.i("DouYinAuthUtil", "goMarket cancel by user");
        int r114 = CommonDouYinLoginTracker.f356940a;
        CommonDouYinLoginTracker.b(r109.f357062b, r109.f357063c, r109.f357064d, "download", "cancel", r109.f357068h);
        j(r109.f357067g, r108, (CommonDouYinLoginTracker.ResultStage) r107.element, -10013, "The user cancel to bind Douyin in check need dialog.");
        goto L281
    L222:
        if (r111 == null) goto L281;
        throw new NoWhenBranchMatchedException();
    L17:
        int r115 = r110.I$0;
        Set<String> r116 = (Set) r110.L$9;
        Ref.BooleanRef r117 = (Ref.BooleanRef) r110.L$8;
        Ref.ObjectRef r118 = (Ref.ObjectRef) r110.L$7;
        CommonDouYinLoginTracker.ResultStage r119 = (CommonDouYinLoginTracker.ResultStage) r110.L$6;
        d r120 = (d) r110.L$5;
        b r121 = (b) r110.L$4;
        CoroutineScope r122 = (CoroutineScope) r110.L$3;
        k0 r123 = (k0) r110.L$2;
        ISdkDouyinAuth r124 = (ISdkDouyinAuth) r110.L$1;
        r100 = (ILoginApi) r110.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L20 CancellationException -> L22 DouYinAccessTokenFailedException -> L24
        String r210 = "cancelled during token check, stage=";
        String r211 = "not bound or token fetch failed, ";
        final b r125 = r121;
        String r310 = "token check finished, loading dismissed";
        CoroutineScope r126 = r122;
        ?? r127 = r115;
        Ref.BooleanRef r128 = r117;
        final Ref.ObjectRef r129 = r118;
        Object r130 = r105;
        d r131 = r120;
        r101 = r123;
        ISdkDouyinAuth r132 = r124;
        ?? r133 = r119;
    L261:
        g5 r134 = (g5) r104;     // Catch: DouYinAccessTokenFailedException -> L72 Throwable -> L77 CancellationException -> L80
        DouYinLoginScopeUpgradeHelper r135 = DouYinLoginScopeUpgradeHelper.f356980a;     // Catch: DouYinAccessTokenFailedException -> L72 Throwable -> L77 CancellationException -> L80
    L74:
        e = e;
        String r136 = r310;
        r118 = r129;
        r120 = r131;
    L76:
        r121 = r125;
    L259:
        FLogger r137 = FLogger.f375446a;     // Catch: Throwable -> L97
        r137.w("DouYinAuthUtil", r210 + r118.element + ", " + e.getMessage());     // Catch: Throwable -> L97
        j(r101.f357067g, r121, (CommonDouYinLoginTracker.ResultStage) r118.element, -10001, "The user cancel to bind Douyin externally.");     // Catch: Throwable -> L97
        Unit r138 = Unit.INSTANCE;     // Catch: Throwable -> L97
        r120.b();
        r137.i("DouYinAuthUtil", r136);
        return r138;
    L97:
        th = th;
    L250:
        r120.b();
        FLogger.f375446a.i("DouYinAuthUtil", r136);
        throw th;
    L67:
        DouYinLoginScopeUpgradeHelper.a r139 = DouYinLoginScopeUpgradeHelper.a(r134, r101.f357076p);     // Catch: DouYinAccessTokenFailedException -> L72 Throwable -> L77 CancellationException -> L80
        r128.element = r139.f356982b;     // Catch: DouYinAccessTokenFailedException -> L72 Throwable -> L77 CancellationException -> L80
        r116 = r139.f356983c;     // Catch: DouYinAccessTokenFailedException -> L72 CancellationException -> L74 Throwable -> L77
        boolean r140 = r139.f356981a;     // Catch: DouYinAccessTokenFailedException -> L72 CancellationException -> L74 Throwable -> L77
        r131.b();
        FLogger.f375446a.i("DouYinAuthUtil", r310);
        ISdkDouyinAuth r141 = r132;
        final k0 r142 = r101;
        Ref.BooleanRef r143 = r128;
        CoroutineScope r144 = r126;
        ILoginApi r145 = r100;
        r107 = r129;
        final ?? r146 = r133;
        ?? r147 = r127;
    L104:
        DouYinLoginScopeUpgradeHelper r148 = DouYinLoginScopeUpgradeHelper.f356980a;
        boolean r149 = r143.element;
        Intrinsics.checkNotNullParameter(r142, "info");
        Intrinsics.checkNotNullParameter(r116, CommonConstant.KEY_GRANTED_SCOPES);
        final Ref.BooleanRef r150 = r143;
        if (r149 == true) goto L107;
    L164:
        r130 = r130;
        r144 = r144;
        ISdkDouyinAuth r416 = r141;
        CommonDouYinLoginUtil$tryToBindDouYinInternal$1 r151 = r110;
        String r152 = r142.f357076p;
        if (r152 != null) goto L167;
    L170:
        boolean r153 = true;
    L171:
        if (r153 == true) goto L173;
        r142.f357069i.putString("required_scopes", r142.f357076p);
    L173:
        String r154 = r142.f357077q;
        if (r154 != null) goto L176;
    L179:
        boolean r155 = true;
    L180:
        if (r155 == true) goto L183;
        r142.f357069i.putString("optional_scopes", r142.f357077q);
    L183:
        if (r140 == false) goto L194;
        FLogger r156 = FLogger.f375446a;
        r156.i("DouYinAuthUtil", "flow: already bound, maybe show notify dialog");
        FragmentActivity r157 = r142.getActivity();
        com.larus.login.api.i r158 = r142.f357070j;
        final ?? r159 = new n(r142, r125, r146);
        if (r158 == null) goto L187;
        g0 r160 = r145.M(r157.getSupportFragmentManager(), new com.larus.login.api.h(r158, null, new v(r159), 14), NotifyBinderDialogType.NotifyBinder);
    L188:
        if (r160 != null) goto L190;
        r156.i("DouYinAuthUtil", "no notify dialog configured, callback alreadyBound directly");
        b(r142.f357067g, r125, r146);
    L280:
        return Unit.INSTANCE;
    L190:
        r156.i("DouYinAuthUtil", "notify dialog shown");
        int r161 = CommonDouYinLoginTracker.f356940a;
        String r162 = r142.f357062b;
        String r163 = r142.f357063c;
        Intrinsics.checkNotNullParameter(r162, "currentPage");
        Intrinsics.checkNotNullParameter(r163, "source");
        com.larus.platform.service.o r164 = com.larus.platform.service.o.f365780a;
        JSONObject r165 = new JSONObject();
        r165.put("scene", r163);
        Unit r166 = Unit.INSTANCE;
        r164.reportEvent("bind_douyin_confirm_show", r165);
        Function3<String, String, NotifyBinderDialogType, Unit> r167 = r142.f357075o;
        if (r167 == null) goto L280;
        r167.invoke(r142.f357062b, r142.f357063c, NotifyBinderDialogType.NotifyBinder);
        goto L280
    L187:
        r160 = null;
        goto L188
    L194:
        if (r147 != 0) goto L196;
        CommonDouYinLoginUtil$tryToBindDouYinInternal$1 r168 = r151;
        Object r169 = r130;
        if (r145.I(r142.getActivity()) == false) goto L231;
        ?? r170 = CommonDouYinLoginTracker.ResultStage.AUTH_GUIDE;
    L232:
        r107.element = r170;
        FLogger r171 = FLogger.f375446a;
        r171.i("DouYinAuthUtil", "flow: " + ((CommonDouYinLoginTracker.ResultStage) r107.element).name() + ", showing guide dialog if configured");
        FragmentActivity r172 = r142.getActivity();
        com.larus.login.api.i r173 = r142.f357071k;
        final CoroutineScope r174 = r144;
        final k0 r175 = r142;
        final b r176 = r125;
        final ILoginApi r177 = r145;
        final ISdkDouyinAuth r178 = r416;
        final k0 r179 = r142;
        final ?? r180 = new o(r174, r175, r177, r178, r176, r150);
        Function1 r181 = new p(r179, r176, r107);
        if (r173 != null) goto L235;
        g0 r182 = null;
    L236:
        if (r182 == null) goto L243;
        r171.i("DouYinAuthUtil", "AUTH_GUIDE dialog shown");
        int r183 = CommonDouYinLoginTracker.f356940a;
        CommonDouYinLoginTracker.c(r179.f357062b, r179.f357063c, r179.f357064d, "bind", r179.f357068h);
        com.larus.login.api.b r184 = r179.f357074n;
        if (r184 == null) goto L240;
        r184.a(r179.f357062b, r179.f357071k, r179.f357068h);
    L240:
        Function3<String, String, NotifyBinderDialogType, Unit> r185 = r179.f357075o;
        if (r185 == null) goto L247;
        r185.invoke(r179.f357062b, r179.f357063c, NotifyBinderDialogType.CheckNeedBinder);
        goto L247
    L243:
        r171.i("DouYinAuthUtil", "no guide dialog configured, proceed bindAndGetToken directly");
        boolean r186 = r150.element;
        r168.L$0 = null;
        r168.L$1 = null;
        r168.L$2 = null;
        r168.L$3 = null;
        r168.L$4 = null;
        r168.L$5 = null;
        r168.L$6 = null;
        r168.L$7 = null;
        r168.L$8 = null;
        r168.L$9 = null;
        r168.label = 3;
        Object r187 = r169;
        if (r410.i(r145, r416, r179, null, r176, r186, r168) != r187) goto L247;
    L282:
        return r187;
    L235:
        r182 = r145.M(r172.getSupportFragmentManager(), new com.larus.login.api.h(r173, new u(r180), r181, 12), NotifyBinderDialogType.CheckNeedBinder);
        goto L236
    L231:
        r170 = CommonDouYinLoginTracker.ResultStage.INNER_WEB;
        goto L232
    L196:
        if (r142.f357071k == null) goto L226;
        FLogger.f375446a.i("DouYinAuthUtil", "flow: shouldGoMarket=true, showing confirm dialog");
        int r188 = CommonDouYinLoginTracker.f356940a;
        CommonDouYinLoginTracker.c(r142.f357062b, r142.f357063c, r142.f357064d, "download", r142.f357068h);
        com.larus.login.api.b r189 = r142.f357074n;
        if (r189 == null) goto L200;
        r189.a(r142.f357062b, r142.f357071k, r142.f357068h);
    L200:
        Function3<String, String, NotifyBinderDialogType, Unit> r190 = r142.f357075o;
        if (r190 == null) goto L203;
        r190.invoke(r142.f357062b, r142.f357063c, NotifyBinderDialogType.CheckNeedBinder);
    L203:
        r107.element = CommonDouYinLoginTracker.ResultStage.GO_MARKET;
        FragmentActivity r191 = r142.getActivity();
        com.larus.login.api.i r192 = r142.f357071k;
        CommonDouYinLoginUtil$tryToBindDouYinInternal$1 r193 = r151;
        r193.L$0 = r142;
        r193.L$1 = r125;
        r193.L$2 = r107;
        r193.L$3 = null;
        r193.L$4 = null;
        r193.L$5 = null;
        r193.L$6 = null;
        r193.L$7 = null;
        r193.L$8 = null;
        r193.L$9 = null;
        r193.label = 2;
        if (r192 != null) goto L206;
        r104 = null;
    L210:
        if (r104 != r130) goto L212;
    L211:
        r187 = r130;
        goto L282
    L212:
        r108 = r125;
        r109 = r142;
        goto L213
    L206:
        kotlinx.coroutines.j r194 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r193), 1);
        r194.C();
        r145.M(r191.getSupportFragmentManager(), new com.larus.login.api.h(r192, null, new a0(r194), 14), NotifyBinderDialogType.CheckNeedBinder);
        r104 = r194.B();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L210;
        DebugProbesKt.probeCoroutineSuspended(r193);
        goto L210
    L226:
        FLogger.f375446a.i("DouYinAuthUtil", "goMarket directly, launching market");
        e0.a();
        n(r142.f357067g, r125, (CommonDouYinLoginTracker.ResultStage) r107.element, -10012);
        goto L281
    L176:
        if (StringsKt.isBlank(r154) == true) goto L179;
        r155 = false;
        goto L180
    L167:
        if (StringsKt.isBlank(r152) == true) goto L170;
        r153 = false;
        goto L171
    L107:
        if ((!r116.isEmpty()) == false) goto L164;
        String r195 = r142.f357076p;
        r416 = r141;
        if (r195 == null) goto L132;
        List r196 = StringsKt.split$default(r195, new String[]{","}, false, 0, 6, null);
        if (r196 == null) goto L132;
        List r197 = r196;
        ArrayList r198 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r197, 10));
        Iterator r199 = r197.iterator();
    L114:
        if (r199.hasNext() == false) goto L116;
        r198.add(StringsKt.trim((String) r199.next()).toString());
        goto L114
    L116:
        ArrayList r200 = new ArrayList();
        Iterator r201 = r198.iterator();
    L118:
        if (r201.hasNext() == false) goto L131;
        Object r202 = r201.next();
        String r1100 = (String) r202;
        if (r1100.length() <= 0) goto L122;
        boolean r1101 = true;
    L123:
        if (r1101 == true) goto L125;
    L127:
        boolean r1102 = false;
    L128:
        if (r1102 == false) goto L118;
        r200.add(r202);
        goto L118
    L125:
        if (r116.contains(r1100) == true) goto L127;
        r1102 = true;
        goto L128
    L122:
        r1101 = false;
        goto L123
    L131:
        String r203 = CollectionsKt.joinToString$default(r200, ",", null, null, 0, null, null, 62, null);
    L134:
        if (r203 != null) goto L136;
        r203 = "";
    L136:
        String r204 = r142.f357077q;
        if (r204 == null) goto L160;
        List r205 = StringsKt.split$default(r204, new String[]{","}, false, 0, 6, null);
        if (r205 == null) goto L160;
        List r206 = r205;
        ArrayList r1103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r206, 10));
        Iterator r207 = r206.iterator();
    L142:
        if (r207.hasNext() == false) goto L144;
        r1103.add(StringsKt.trim((String) r207.next()).toString());
        goto L142
    L144:
        ArrayList r208 = new ArrayList();
        Iterator r209 = r1103.iterator();
    L146:
        if (r209.hasNext() == false) goto L159;
        Object r1104 = r209.next();
        Iterator r417 = r209;
        String r212 = (String) r1104;
        if (r212.length() <= 0) goto L150;
        boolean r1105 = true;
    L151:
        if (r1105 == true) goto L153;
    L155:
        boolean r213 = false;
    L156:
        if (r213 == false) goto L158;
        r208.add(r1104);
    L158:
        r209 = r417;
        goto L146
    L153:
        if (r116.contains(r212) == true) goto L155;
        r213 = true;
        goto L156
    L150:
        r1105 = false;
        goto L151
    L159:
        String r214 = CollectionsKt.joinToString$default(r208, ",", null, null, 0, null, null, 62, null);
    L161:
        if (r214 != null) goto L163;
        r214 = "";
    L163:
        r151 = r110;
        FLogger.f375446a.i("DouYinAuthUtil", "scope upgrade: filtering granted scopes, required=[" + r203 + "], optional=[" + r214 + "], granted=" + r116);
        r142.f357069i.putString("required_scopes", r203);
        r142.f357069i.putString("optional_scopes", r214);
    L160:
        r214 = null;
    L132:
        r203 = null;
        goto L134
    L80:
        e = e;
        r136 = r310;
        r118 = r129;
        d r215 = r131;
    L82:
        r121 = r125;
        r120 = r215;
    L72:
        e = e;
        r136 = r310;
        ILoginApi r418 = r100;
        ?? r216 = r133;
        ?? r1106 = r127;
    L264:
        FLogger r217 = FLogger.f375446a;     // Catch: Throwable -> L248
        Set<String> r419 = r116;
        k0 r420 = r101;
        r217.i("DouYinAuthUtil", r211 + e.getMessage());     // Catch: Throwable -> L248
        r131.b();
        r217.i("DouYinAuthUtil", r136);
        r116 = r419;
        r107 = r129;
        r143 = r128;
        r141 = r132;
        r144 = r126;
        r140 = false;
        r145 = r418;
        r142 = r420;
        r146 = r216;
        r147 = r1106;
    L248:
        th = th;
    L79:
        r120 = r131;
    L77:
        th = th;
        r136 = r310;
        goto L79
    L24:
        e = e;
        r129 = r118;
        r211 = "not bound or token fetch failed, ";
        r130 = r105;
        r125 = r121;
        r131 = r120;
        r1106 = r115;
        r132 = r124;
        r418 = r100;
        r128 = r117;
        r101 = r123;
        r136 = "token check finished, loading dismissed";
        r126 = r122;
        r216 = r119;
    L22:
        e = e;
        r101 = r123;
        r210 = "cancelled during token check, stage=";
        r136 = "token check finished, loading dismissed";
    L20:
        th = th;
        r136 = "token check finished, loading dismissed";
        goto L250
    L26:
        ResultKt.throwOnFailure(r104);
        com.larus.login.api.ecommerce.h.a("user_trigger");
        if (r101.f357071k == null) goto L29;
        boolean r218 = true;
    L31:
        if (r101.f357070j == null) goto L33;
        boolean r219 = true;
    L35:
        if (r101.f357065e == true) goto L37;
    L39:
        boolean r1107 = false;
    L40:
        FLogger r1108 = FLogger.f375446a;
        r1108.i("DouYinAuthUtil", "tryToBindDouYinInternal start, hasGuidePanel=" + r218 + ", hasNotifyPanel=" + r219 + ", shouldGoMarket=" + r1107);
        r211 = "not bound or token fetch failed, ";
        r210 = "cancelled during token check, stage=";
        r310 = "token check finished, loading dismissed";
        r125 = new b(r101.f357062b, r101.f357063c, r101.f357064d, r101.f357066f, r218, r219, r1107 ? 1 : 0, r101.f357073m, r101.f357068h);
        int r220 = CommonDouYinLoginTracker.f356940a;
        String r221 = r125.f356948a;
        String r222 = r125.f356949b;
        boolean r223 = r125.f356951d;
        boolean r224 = r125.f356952e;
        boolean r225 = r125.f356953f;
        boolean r226 = r125.f356954g;
        Intrinsics.checkNotNullParameter(r221, "sourcePage");
        Intrinsics.checkNotNullParameter(r222, "sourceMethod");
        JSONObject r1109 = new JSONObject();
        r1109.put("source_page", r221);
        r1109.put(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, r222);
        r1109.put("force_request_server", r223 ? 1 : 0);
        r1109.put("has_guide_panel", r224 ? 1 : 0);
        r1109.put("has_notify_panel", r225 ? 1 : 0);
        r1109.put("go_market", r226 ? 1 : 0);
        com.larus.platform.service.o.f365780a.reportEvent("flow_douyin_auth_start", r1109);
        com.larus.platform.service.g.f365738a.monitorEventForSlardar("flow_douyin_auth_start", r1109, null, null);
        if (TouristManager.f357001a.f() == false) goto L43;
        l(r101.f357067g, r125, CommonDouYinLoginTracker.ResultStage.USER_NOT_LOGIN, -10016, ContextCompat.getString(AppHost.f326268a.getApplication(), R.string.larus_web_search_login_suggest));
        return Unit.INSTANCE;
    L43:
        r215 = new d(r413.getActivity());
        final Job r227 = (Job) r110.getContext().get(Job.Key);
        g5 r228 = r412.b();
        if (r228 == null) goto L46;
        long r229 = r228.f365139f;
    L48:
        if (System.currentTimeMillis() <= r229) goto L50;
        CommonDouYinLoginTracker.ResultStage r230 = CommonDouYinLoginTracker.ResultStage.SERVER_TOKEN;
    L51:
        ?? r231 = r230;
        r1108.i("DouYinAuthUtil", "initialStage=" + r231 + ", accessTokenExpireAt=" + r229);
        r129 = new Ref.ObjectRef();
        r129.element = r231;
        if (r227 == null) goto L54;
        r227.invokeOnCompletion(new l(r129, r101, r125));
    L54:
        r215.c(r101.f357072l, new m(r129, r227));
        r128 = new Ref.BooleanRef();
        Set<String> r232 = SetsKt.emptySet();
        r1108.i("DouYinAuthUtil", "checking if already bound, forceRequestServer=" + r101.f357066f);     // Catch: Throwable -> L91 CancellationException -> L93 DouYinAccessTokenFailedException -> L99
        boolean r233 = r101.f357066f;     // Catch: Throwable -> L91 CancellationException -> L93 DouYinAccessTokenFailedException -> L99
        SdkOauthTokenTriggerScene r234 = SdkOauthTokenTriggerScene.Request;     // Catch: Throwable -> L91 CancellationException -> L93 DouYinAccessTokenFailedException -> L99
        r110.L$0 = r100;     // Catch: Throwable -> L91 CancellationException -> L93 DouYinAccessTokenFailedException -> L99
        r132 = r412;
        r110.L$1 = r132;     // Catch: DouYinAccessTokenFailedException -> L89 Throwable -> L91 CancellationException -> L93
        r110.L$2 = r101;     // Catch: DouYinAccessTokenFailedException -> L89 Throwable -> L91 CancellationException -> L93
        r126 = r414;
        r110.L$3 = r126;     // Catch: DouYinAccessTokenFailedException -> L87 Throwable -> L91 CancellationException -> L93
        r110.L$4 = r125;     // Catch: DouYinAccessTokenFailedException -> L87 Throwable -> L91 CancellationException -> L93
        r110.L$5 = r215;     // Catch: DouYinAccessTokenFailedException -> L87 Throwable -> L91 CancellationException -> L93
        r110.L$6 = r231;     // Catch: DouYinAccessTokenFailedException -> L87 Throwable -> L91 CancellationException -> L93
        r110.L$7 = r129;     // Catch: DouYinAccessTokenFailedException -> L87 Throwable -> L91 CancellationException -> L93
        r110.L$8 = r128;     // Catch: DouYinAccessTokenFailedException -> L87 Throwable -> L91 CancellationException -> L93
        r110.L$9 = r232;     // Catch: DouYinAccessTokenFailedException -> L87 Throwable -> L91 CancellationException -> L93
        r110.I$0 = r1107 ? 1 : 0;     // Catch: DouYinAccessTokenFailedException -> L87 Throwable -> L91 CancellationException -> L93
        r110.label = 1;     // Catch: DouYinAccessTokenFailedException -> L87 Throwable -> L91 CancellationException -> L93
        r104 = d(r132, r233, r234, r110);     // Catch: CancellationException -> L84 DouYinAccessTokenFailedException -> L87 Throwable -> L91
        r130 = r105;
        if (r104 != r130) goto L64;
        r130 = r130;
        goto L211
    L64:
        r131 = r215;
        r116 = r232;
        r133 = r231;
        r127 = r1107;
        goto L261
    L84:
        e = e;
        r136 = r310;
        r118 = r129;
    L87:
        e = e;
    L88:
        r136 = r310;
        r130 = r105;
        r418 = r100;
        r131 = r215;
        r116 = r232;
        r216 = r231;
        r1106 = r1107;
    L89:
        e = e;
    L90:
        r126 = r414;
    L91:
        th = th;
        r136 = r310;
        r120 = r215;
    L99:
        e = e;
        r132 = r412;
    L93:
        e = e;
        r136 = r310;
        r120 = r215;
        r118 = r129;
        goto L76
    L50:
        r230 = CommonDouYinLoginTracker.ResultStage.LOCAL_TOKEN;
        goto L51
    L46:
        r229 = -1;
        goto L48
    L37:
        if (r100.I(r413.getActivity()) == true) goto L39;
        r1107 = true;
        goto L40
    L33:
        r219 = false;
        goto L35
    L29:
        r218 = false;
    L7:
        r102 = new CommonDouYinLoginUtil$tryToBindDouYinInternal$1(r410, r415);
        goto L8
    }

    public static Object e(ILoginApi r110, FragmentActivity r111, String r112, String r113, String r114, Continuation r115) {
        kotlinx.coroutines.j r100 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r115), 1);
        r100.C();
        if (r111.isFinishing() == true) goto L13;
        if (r111.isDestroyed() == true) goto L13;
        if (r110.r(r111, r112, r113, r114, new f(r100)) == false) goto L10;
    L15:
        Object r101 = r100.B();
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        DebugProbesKt.probeCoroutineSuspended(r115);
    L18:
        return r101;
    L10:
        if (r100.isActive() == false) goto L15;
        FLogger.f375446a.w("DouYinAuthUtil", "awaitGoToChangeBind aborted by invalid Activity state");
        Result.Companion r102 = Result.Companion;
        r100.resumeWith(Result.m9449constructorimpl(TuplesKt.to(Boxing.boxBoolean(false), null)));
    L13:
        if (r100.isActive() == false) goto L15;
        FLogger.f375446a.w("DouYinAuthUtil", "awaitGoToChangeBind aborted by invalid Activity state");
        Result.Companion r103 = Result.Companion;
        r100.resumeWith(Result.m9449constructorimpl(TuplesKt.to(Boxing.boxBoolean(false), null)));
        goto L15
    }

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
    public static void o(b0 r110, final b r111, final CommonDouYinLoginTracker.AuthResult r112, final CommonDouYinLoginTracker.ResultStage r113, final DouYinBindStatus r210, final int r211, final String r212) {
        Runnable r114 = new t(r112, r113, r210, r211, r212, r111);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
        new Handler(Looper.getMainLooper()).post(r114);
    L6:
        if (r212 != null) goto L8;
        String r100 = "";
    L9:
        r111.getClass();
        Intrinsics.checkNotNullParameter(r112, "result");
        Intrinsics.checkNotNullParameter(r113, "resultStage");
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        if (r111.f356957j.compareAndSet(false, true) == false) goto L29;
        int r101 = CommonDouYinLoginTracker.f356940a;
        String r102 = r111.f356948a;
        String r115 = r111.f356949b;
        boolean r116 = r111.f356951d;
        boolean r117 = r111.f356952e;
        boolean r118 = r111.f356953f;
        boolean r103 = r111.f356954g;
        Intrinsics.checkNotNullParameter(r102, "sourcePage");
        Intrinsics.checkNotNullParameter(r115, "sourceMethod");
        Intrinsics.checkNotNullParameter(r112, "result");
        Intrinsics.checkNotNullParameter(r113, "resultStage");
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        JSONObject r104 = new JSONObject();
        r104.put("source_page", r102);
        r104.put(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, r115);
        r104.put("force_request_server", r116 ? 1 : 0);
        r104.put("has_guide_panel", r117 ? 1 : 0);
        r104.put("has_notify_panel", r118 ? 1 : 0);
        r104.put("go_market", r103 ? 1 : 0);
        r104.put("result", r112.getValue());
        r104.put("result_stage", r113.getValue());
        r104.put("error_code", r211);
        r104.put("error_msg", r100);
        com.larus.platform.service.o r105 = com.larus.platform.service.o.f365780a;
        r105.reportEvent("flow_douyin_auth_result", r104);
        com.larus.platform.service.g.f365738a.monitorEventForSlardar("flow_douyin_auth_result", r104, null, null);
        int r106 = 1;
        if (SetsKt.setOf(new CommonDouYinLoginTracker.ResultStage[]{CommonDouYinLoginTracker.ResultStage.LOCAL_TOKEN, CommonDouYinLoginTracker.ResultStage.SERVER_TOKEN}).contains(r113) == true) goto L29;
        String r107 = r111.f356949b;
        String r108 = r111.f356950c;
        if (r112 != CommonDouYinLoginTracker.AuthResult.SUCCESS) goto L17;
        boolean r109 = true;
    L19:
        if (r112 != CommonDouYinLoginTracker.AuthResult.GO_MARKET) goto L21;
        boolean r119 = true;
    L22:
        String r120 = r113.getValue();
        Map<String, Object> r121 = r111.f356956i;
        Intrinsics.checkNotNullParameter(r107, "source");
        Intrinsics.checkNotNullParameter(r108, "popUpType");
        Intrinsics.checkNotNullParameter(r121, "extraParams");
        JSONObject r122 = new JSONObject();
        r122.put("scene", r107);
        r122.put("type", "douyin");
        r122.put("pop_up_type", r108);
        if (r109 == true) goto L28;
        if (r119 == false) goto L27;
        r106 = 2;
        goto L28
    L27:
        r106 = 0;
    L28:
        r122.put("success", r106);
        r122.put("bind_fail_step", r120);
        CommonDouYinLoginTracker.a(r122, r121);
        Unit r123 = Unit.INSTANCE;
        r105.reportEvent("bind_with_account_token", r122);
        goto L29
    L21:
        r119 = false;
        goto L22
    L17:
        r109 = false;
    L29:
        r110.a(r210, r211, r212);
        return;
    L8:
        r100 = r212;
        goto L9
    L5:
        r114.run();
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [int] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v25 */
    /* JADX WARN: Type inference failed for: r16v27, types: [com.larus.login.api.CommonDouYinLoginUtil$d] */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v32 */
    /* JADX WARN: Type inference failed for: r16v33 */
    /* JADX WARN: Type inference failed for: r16v37 */
    /* JADX WARN: Type inference failed for: r16v4, types: [com.larus.login.api.CommonDouYinLoginUtil$d] */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v33, types: [T, com.larus.login.api.CommonDouYinLoginTracker$ResultStage] */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v64 */
    /* JADX WARN: Type inference failed for: r1v65 */
    /* JADX WARN: Type inference failed for: r1v66 */
    /* JADX WARN: Type inference failed for: r1v67 */
    /* JADX WARN: Type inference failed for: r1v68 */
    /* JADX WARN: Type inference failed for: r3v17, types: [T, com.larus.login.api.CommonDouYinLoginTracker$ResultStage] */
    /* JADX WARN: Type inference failed for: r3v20, types: [T, com.larus.login.api.CommonDouYinLoginTracker$ResultStage] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v58 */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.larus.login.api.k0] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v37 */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v23, types: [T, com.larus.login.api.CommonDouYinLoginTracker$ResultStage] */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v44 */
    /* JADX WARN: Type inference failed for: r5v49, types: [java.lang.Object, kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r5v56 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v64, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r5v65 */
    /* JADX WARN: Type inference failed for: r5v66, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r5v68, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r5v69 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v70 */
    /* JADX WARN: Type inference failed for: r5v71 */
    /* JADX WARN: Type inference failed for: r5v72 */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r6v37 */
    /* JADX WARN: Type inference failed for: r6v39 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v41 */
    /* JADX WARN: Type inference failed for: r6v47, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v49 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v50 */
    /* JADX WARN: Type inference failed for: r6v54 */
    /* JADX WARN: Type inference failed for: r6v55 */
    /* JADX WARN: Type inference failed for: r6v56 */
    /* JADX WARN: Type inference failed for: r6v57 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v60 */
    /* JADX WARN: Type inference failed for: r6v61, types: [com.larus.login.api.CommonDouYinLoginUtil$d] */
    /* JADX WARN: Type inference failed for: r6v62 */
    /* JADX WARN: Type inference failed for: r6v64, types: [com.larus.login.api.CommonDouYinLoginUtil$d] */
    /* JADX WARN: Type inference failed for: r6v65 */
    /* JADX WARN: Type inference failed for: r6v66 */
    /* JADX WARN: Type inference failed for: r6v67 */
    /* JADX WARN: Type inference failed for: r6v68 */
    /* JADX WARN: Type inference failed for: r6v69 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v70 */
    /* JADX WARN: Type inference failed for: r6v71 */
    /* JADX WARN: Type inference failed for: r6v72 */
    /* JADX WARN: Type inference failed for: r6v73 */
    /* JADX WARN: Type inference failed for: r6v74 */
    /* JADX WARN: Type inference failed for: r6v75 */
    /* JADX WARN: Type inference failed for: r6v76 */
    /* JADX WARN: Type inference failed for: r6v77 */
    /* JADX WARN: Type inference failed for: r6v78 */
    /* JADX WARN: Type inference failed for: r6v79 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v80 */
    /* JADX WARN: Type inference failed for: r6v81 */
    /* JADX WARN: Type inference failed for: r6v82 */
    /* JADX WARN: Type inference failed for: r6v83 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v1, types: [T, com.larus.login.api.CommonDouYinLoginTracker$ResultStage] */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v37, types: [T] */
    /* JADX WARN: Type inference failed for: r7v44 */
    /* JADX WARN: Type inference failed for: r7v45 */
    /* JADX WARN: Type inference failed for: r7v46 */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v3, types: [com.larus.login.api.CommonDouYinLoginUtil$d] */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v34 */
    /* JADX WARN: Type inference failed for: r8v35 */
    /* JADX WARN: Type inference failed for: r8v38 */
    /* JADX WARN: Type inference failed for: r8v39, types: [com.larus.login.api.CommonDouYinLoginUtil$b] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v40 */
    /* JADX WARN: Type inference failed for: r8v41, types: [com.larus.login.api.CommonDouYinLoginUtil$b] */
    /* JADX WARN: Type inference failed for: r8v43, types: [com.larus.login.api.CommonDouYinLoginUtil$b] */
    /* JADX WARN: Type inference failed for: r8v44 */
    /* JADX WARN: Type inference failed for: r8v45 */
    /* JADX WARN: Type inference failed for: r8v46 */
    /* JADX WARN: Type inference failed for: r8v47 */
    /* JADX WARN: Type inference failed for: r8v48 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v37 */
    /* JADX WARN: Type inference failed for: r9v38 */
    /* JADX WARN: Type inference failed for: r9v4, types: [com.larus.login.api.CommonDouYinLoginUtil$b] */
    /* JADX WARN: Type inference failed for: r9v45 */
    /* JADX WARN: Type inference failed for: r9v47, types: [com.larus.login.api.k0] */
    /* JADX WARN: Type inference failed for: r9v48 */
    /* JADX WARN: Type inference failed for: r9v49, types: [com.larus.login.api.k0] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v51, types: [com.larus.login.api.k0] */
    /* JADX WARN: Type inference failed for: r9v52 */
    /* JADX WARN: Type inference failed for: r9v53 */
    /* JADX WARN: Type inference failed for: r9v54 */
    /* JADX WARN: Type inference failed for: r9v55 */
    /* JADX WARN: Type inference failed for: r9v56 */
    /* JADX WARN: Type inference failed for: r9v57 */
    /* JADX WARN: Type inference failed for: r9v58 */
    /* JADX WARN: Type inference failed for: r9v59 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
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
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object i(ILoginApi r310, ISdkDouyinAuth r311, k0 r312, g0 r313, b r314, boolean r315, Continuation<? super Unit> r316) {
        String r100 = "refresh token stage=";
        ?? r101 = "changeBind result=";
        ?? r102 = "switchBind result=";
        String r103 = "refresh token failed after bind/change, code=";
        ?? r104 = "awaitBindPlatform failed, code=";
        ?? r105 = "awaitUpdateAccountToken failed, code=";
        if ((r316 instanceof CommonDouYinLoginUtil$bindAndGetToken$1) == false) goto L7;
        CommonDouYinLoginUtil$bindAndGetToken$1 r110 = (CommonDouYinLoginUtil$bindAndGetToken$1) r316;
        int r111 = r110.label;
        if ((r111 & Integer.MIN_VALUE) == 0) goto L7;
        r110.label = r111 - Integer.MIN_VALUE;
    L8:
        Object r106 = r110.result;
        Object r112 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r113 = r110.label;
        String r114 = "bindAndGetToken finished, dismiss loading if showing";
        switch(r113) {
            case 0: goto L53;
            case 1: goto L45;
            case 2: goto L40;
            case 3: goto L32;
            case 4: goto L24;
            case 5: goto L21;
            case 6: goto L17;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        int r107 = r110.I$0;
        String r108 = (String) r110.L$5;
        String r109 = (String) r110.L$4;
        r101 = (Ref.ObjectRef) r110.L$3;
        r102 = (d) r110.L$2;
        r104 = (b) r110.L$1;
        r105 = (k0) r110.L$0;
        ResultKt.throwOnFailure(r106);     // Catch: DouYinAccessTokenFailedException -> L15 CancellationException -> L247 Throwable -> L175
        String r115 = "bindAndGetToken cancelled, stage=";
        r103 = "refresh token failed after bind/change, code=";
        r101 = r101;
        r102 = r102;
        r104 = r104;
        r105 = r105;
    L273:
        FLogger.f375446a.i("DouYinAuthUtil", "refresh token success, final success callback");     // Catch: CancellationException -> L246 Throwable -> L175 DouYinAccessTokenFailedException -> L177
        q(r105.a(), r104, (CommonDouYinLoginTracker.ResultStage) r101.element, r107, r109);     // Catch: CancellationException -> L246 Throwable -> L175 DouYinAccessTokenFailedException -> L177
        r101 = r101;
        r102 = r102;
        r104 = r104;
        r105 = r105;
    L182:
        FLogger.f375446a.i("DouYinAuthUtil", r114);
        r102.b();
        return Unit.INSTANCE;
    L177:
        e = e;
    L181:
        FLogger.f375446a.e("DouYinAuthUtil", r103 + e.getErrorCode());     // Catch: CancellationException -> L246 Throwable -> L175
        l(r105.a(), r104, (CommonDouYinLoginTracker.ResultStage) r101.element, e.getErrorCode(), r108);     // Catch: CancellationException -> L246 Throwable -> L175
        r101 = r101;
        r102 = r102;
        r104 = r104;
        r105 = r105;
        goto L182
    L15:
        e = e;
        r115 = "bindAndGetToken cancelled, stage=";
        r103 = "refresh token failed after bind/change, code=";
    L30:
        r115 = "bindAndGetToken cancelled, stage=";
        goto L31
    L17:
        e = (BindPlatformFailedException) r110.L$4;
        Ref.ObjectRef r116 = (Ref.ObjectRef) r110.L$3;
        d r117 = (d) r110.L$2;
        b r118 = (b) r110.L$1;
        k0 r119 = (k0) r110.L$0;
        ResultKt.throwOnFailure(r106);     // Catch: CancellationException -> L20 Throwable -> L175
        b r120 = r118;
        r115 = "bindAndGetToken cancelled, stage=";
        k0 r121 = r119;
        r114 = "bindAndGetToken finished, dismiss loading if showing";
        Ref.ObjectRef r122 = r116;
        ?? r123 = r117;
    L270:
        if (((Boolean) r106).booleanValue() == false) goto L105;
        m(r121.a(), r120, (CommonDouYinLoginTracker.ResultStage) r122.element, e.getErrorCode(), e.getErrorMsg());     // Catch: Throwable -> L73 CancellationException -> L248
    L106:
        Unit r124 = Unit.INSTANCE;     // Catch: Throwable -> L73 CancellationException -> L248
        ?? r125 = r123;
    L107:
        FLogger r126 = FLogger.f375446a;
        ?? r127 = r125;
    L108:
        r114 = r114;
        ?? r128 = r127;
    L241:
        r126.i("DouYinAuthUtil", r114);
        ?? r129 = r128;
    L242:
        r129.b();
        return r124;
    L105:
        j(r121.a(), r120, (CommonDouYinLoginTracker.ResultStage) r122.element, e.getErrorCode(), e.getErrorMsg());     // Catch: Throwable -> L73 CancellationException -> L248
    L137:
        r114 = r114;
        ?? r130 = r122;
        ?? r131 = r121;
        ?? r132 = r123;
        ?? r133 = r120;
    L231:
        switch(e.f356968c[((CommonDouYinLoginTracker.ResultStage) r130.element).ordinal()]) {
            case 1: goto L239;
            case 2: goto L238;
            case 3: goto L237;
            case 4: goto L236;
            case 5: goto L235;
            case 6: goto L234;
            case 7: goto L233;
            default: goto L232;
        };     // Catch: Throwable -> L175
    L232:
        int r134 = -10010;
    L240:
        r126 = FLogger.f375446a;     // Catch: Throwable -> L175
        r126.w("DouYinAuthUtil", r115 + r130.element + ", errorCode=" + r134);     // Catch: Throwable -> L175
        j(r131.a(), r133, (CommonDouYinLoginTracker.ResultStage) r130.element, r134, "The user cancel to bind Douyin externally.");     // Catch: Throwable -> L175
        r124 = Unit.INSTANCE;     // Catch: Throwable -> L175
        r128 = r132;
        goto L241
    L233:
        r134 = -10007;
        goto L240
    L234:
        r134 = -10009;
        goto L240
    L235:
        r134 = -10008;
        goto L240
    L236:
        r134 = -10004;
        goto L240
    L237:
        r134 = -10003;
        goto L240
    L238:
        r134 = -10006;
        goto L240
    L239:
        r134 = -10005;
    L20:
        r133 = r118;
        r115 = "bindAndGetToken cancelled, stage=";
        r131 = r119;
        r130 = r116;
        r132 = r117;
        goto L231
    L21:
        int r135 = r110.I$0;
        BindPlatformFailedException r136 = (BindPlatformFailedException) r110.L$6;
        String r137 = (String) r110.L$5;
        Ref.ObjectRef r138 = (Ref.ObjectRef) r110.L$4;
        d r139 = (d) r110.L$3;
        b r140 = (b) r110.L$2;
        k0 r141 = (k0) r110.L$1;
        ISdkDouyinAuth r142 = (ISdkDouyinAuth) r110.L$0;
        ResultKt.throwOnFailure(r106);     // Catch: Throwable -> L27 CancellationException -> L29
        r100 = "refresh token stage=";
        r115 = "bindAndGetToken cancelled, stage=";
        String r210 = "changeBind result=";
        r103 = "refresh token failed after bind/change, code=";
        String r143 = ", msg=";
        r114 = "bindAndGetToken finished, dismiss loading if showing";
        int r144 = r135;
        r121 = r141;
        Object r145 = r106;
        BindPlatformFailedException r146 = r136;
        r122 = r138;
        ?? r147 = r139;
        r120 = r140;
    L283:
        Pair r148 = (Pair) r145;     // Catch: Throwable -> L134 CancellationException -> L136
        FLogger r149 = FLogger.f375446a;     // Catch: Throwable -> L134 CancellationException -> L136
        r149.i("DouYinAuthUtil", r210 + ((Boolean) r148.getFirst()).booleanValue() + r143 + r148.getSecond());     // Catch: Throwable -> L134 CancellationException -> L136
        if (((Boolean) r148.getFirst()).booleanValue() == true) goto L133;
        b0 r150 = r121.a();     // Catch: Throwable -> L134 CancellationException -> L136
        CommonDouYinLoginTracker.ResultStage r151 = (CommonDouYinLoginTracker.ResultStage) r122.element;     // Catch: Throwable -> L134 CancellationException -> L136
        int r152 = r146.getErrorCode();     // Catch: Throwable -> L134 CancellationException -> L136
        Integer r153 = (Integer) r148.getSecond();     // Catch: Throwable -> L134 CancellationException -> L136
        if (r153 == null) goto L129;
        String r154 = r153.toString();     // Catch: Throwable -> L134 CancellationException -> L136
        if (r154 == null) goto L129;
    L130:
        l(r150, r120, r151, r152, r154);     // Catch: Throwable -> L134 CancellationException -> L136
        r124 = Unit.INSTANCE;     // Catch: Throwable -> L134 CancellationException -> L136
        ?? r155 = r147;
    L157:
        r149.i("DouYinAuthUtil", r114);
        r129 = r155;
    L129:
        r154 = r146.getErrorMsg();     // Catch: Throwable -> L134 CancellationException -> L136
        goto L130
    L133:
        r101 = r122;
        r108 = "Again bind Douyin successfully.Get Douyin token failed.";
        r109 = r137;
        r102 = r147;
        r114 = r114;
        ISdkDouyinAuth r156 = r142;
        r107 = r144;
        k0 r157 = r121;
        b r158 = r120;
    L260:
        int r159 = e.f356968c[((CommonDouYinLoginTracker.ResultStage) r101.element).ordinal()];     // Catch: Throwable -> L175 CancellationException -> L184
        if (r159 != 1) goto L164;
        ?? r160 = CommonDouYinLoginTracker.ResultStage.REFRESH_AFTER_SWITCH;     // Catch: Throwable -> L175 CancellationException -> L184
    L168:
        r101.element = r160;     // Catch: Throwable -> L175 CancellationException -> L184
        FLogger.f375446a.i("DouYinAuthUtil", r100 + r101.element + ", requesting server token");     // Catch: Throwable -> L175 CancellationException -> L184
        SdkOauthTokenTriggerScene r161 = SdkOauthTokenTriggerScene.Request;     // Catch: Throwable -> L175 DouYinAccessTokenFailedException -> L179 CancellationException -> L184
        r110.L$0 = r157;     // Catch: Throwable -> L175 DouYinAccessTokenFailedException -> L179 CancellationException -> L184
        r110.L$1 = r158;     // Catch: Throwable -> L175 DouYinAccessTokenFailedException -> L179 CancellationException -> L184
        r110.L$2 = r102;     // Catch: Throwable -> L175 DouYinAccessTokenFailedException -> L179 CancellationException -> L184
        r110.L$3 = r101;     // Catch: Throwable -> L175 DouYinAccessTokenFailedException -> L179 CancellationException -> L184
        r110.L$4 = r109;     // Catch: Throwable -> L175 DouYinAccessTokenFailedException -> L179 CancellationException -> L184
        r110.L$5 = r108;     // Catch: Throwable -> L175 DouYinAccessTokenFailedException -> L179 CancellationException -> L184
        r110.L$6 = null;     // Catch: Throwable -> L175 DouYinAccessTokenFailedException -> L179 CancellationException -> L184
        r110.L$7 = null;     // Catch: Throwable -> L175 DouYinAccessTokenFailedException -> L179 CancellationException -> L184
        r110.I$0 = r107;     // Catch: Throwable -> L175 DouYinAccessTokenFailedException -> L179 CancellationException -> L184
        r110.label = 7;     // Catch: Throwable -> L175 DouYinAccessTokenFailedException -> L179 CancellationException -> L184
        if (d(r156, true, r161, r110) != r112) goto L172;
        return r112;
    L172:
        r104 = r158;
        r105 = r157;
        r101 = r101;
        r102 = r102;
        goto L273
    L179:
        e = e;
        r104 = r158;
        r105 = r157;
        goto L181
    L164:
        if (r159 == 2) goto L166;
        r160 = CommonDouYinLoginTracker.ResultStage.REFRESH_AFTER_BIND;     // Catch: Throwable -> L175 CancellationException -> L184
        goto L168
    L166:
        r160 = CommonDouYinLoginTracker.ResultStage.REFRESH_AFTER_CHANGE;     // Catch: Throwable -> L175 CancellationException -> L184
    L184:
        r130 = r101;
        r131 = r157;
        r132 = r102;
        r133 = r158;
    L136:
        r123 = r147;
    L134:
        th = th;
        ?? r162 = r147;
    L75:
        r114 = r114;
    L244:
        FLogger.f375446a.i("DouYinAuthUtil", r114);
        r162.b();
        throw th;
    L24:
        int r163 = r110.I$0;
        BindPlatformFailedException r164 = (BindPlatformFailedException) r110.L$6;
        String r165 = (String) r110.L$5;
        Ref.ObjectRef r166 = (Ref.ObjectRef) r110.L$4;
        d r167 = (d) r110.L$3;
        b r168 = (b) r110.L$2;
        k0 r169 = (k0) r110.L$1;
        ISdkDouyinAuth r170 = (ISdkDouyinAuth) r110.L$0;
        ResultKt.throwOnFailure(r106);     // Catch: Throwable -> L27 CancellationException -> L29
        r100 = "refresh token stage=";
        r115 = "bindAndGetToken cancelled, stage=";
        String r211 = "switchBind result=";
        r103 = "refresh token failed after bind/change, code=";
        ?? r171 = r167;
        b r172 = r168;
        r114 = "bindAndGetToken finished, dismiss loading if showing";
        k0 r173 = r169;
        BindPlatformFailedException r174 = r164;
        Object r175 = r106;
        Ref.ObjectRef r176 = r166;
        r156 = r170;
        r107 = r163;
        String r177 = r165;
        r143 = ", msg=";
    L256:
        Pair r178 = (Pair) r175;     // Catch: Throwable -> L187 CancellationException -> L190
        r149 = FLogger.f375446a;     // Catch: Throwable -> L187 CancellationException -> L190
        r149.i("DouYinAuthUtil", r211 + ((Boolean) r178.getFirst()).booleanValue() + r143 + ((String) r178.getSecond()));     // Catch: Throwable -> L187 CancellationException -> L190
        if (((Boolean) r178.getFirst()).booleanValue() == true) goto L158;
        b0 r179 = r173.a();     // Catch: Throwable -> L187 CancellationException -> L190
        CommonDouYinLoginTracker.ResultStage r180 = (CommonDouYinLoginTracker.ResultStage) r176.element;     // Catch: Throwable -> L187 CancellationException -> L190
        int r181 = r174.getErrorCode();     // Catch: Throwable -> L187 CancellationException -> L190
        String r182 = (String) r178.getSecond();     // Catch: Throwable -> L187 CancellationException -> L190
        if (r182 == null) goto L252;
    L155:
        j(r179, r172, r180, r181, r182);     // Catch: Throwable -> L187 CancellationException -> L190
        r124 = Unit.INSTANCE;     // Catch: Throwable -> L187 CancellationException -> L190
        r155 = r171;
        goto L157
    L252:
        r182 = r174.getErrorMsg();     // Catch: Throwable -> L153 CancellationException -> L190
    L153:
        th = th;
        r162 = r171;
        goto L75
    L158:
        r114 = r114;
        r101 = r176;
        r108 = "Switch bind Douyin successfully.Get Douyin token failed.";
        r102 = r171;
        r109 = r177;
        r157 = r173;
        r158 = r172;
    L187:
        th = th;
        r114 = r114;
        r162 = r171;
    L190:
        r114 = r114;
        r132 = r171;
        r130 = r176;
        r131 = r173;
        r133 = r172;
        goto L231
    L32:
        int r183 = r110.I$0;
        r108 = (String) r110.L$7;
        String r184 = (String) r110.L$6;
        Ref.ObjectRef r185 = (Ref.ObjectRef) r110.L$5;
        r162 = (d) r110.L$4;
        b r186 = (b) r110.L$3;
        k0 r187 = (k0) r110.L$2;
        ISdkDouyinAuth r188 = (ISdkDouyinAuth) r110.L$1;
        ILoginApi r212 = (ILoginApi) r110.L$0;
        ResultKt.throwOnFailure(r106);     // Catch: Throwable -> L35 CancellationException -> L37 BindPlatformFailedException -> L38
        r107 = r183;
        r210 = "changeBind result=";
        r211 = "switchBind result=";
        String r189 = "awaitBindPlatform failed, code=";
        String r213 = ", msg=";
        r114 = "bindAndGetToken finished, dismiss loading if showing";
        ILoginApi r190 = r212;
        r100 = "refresh token stage=";
        ?? r191 = r162;
        r115 = "bindAndGetToken cancelled, stage=";
        r121 = r187;
        r103 = "refresh token failed after bind/change, code=";
        Ref.ObjectRef r192 = r185;
        b r193 = r186;
    L291:
        FLogger.f375446a.i("DouYinAuthUtil", "awaitBindPlatform success");     // Catch: Throwable -> L83 CancellationException -> L85 BindPlatformFailedException -> L86
        r102 = r191;
        r109 = r184;
        r101 = r192;
        r158 = r193;
        r156 = r188;
        r114 = r114;
        r157 = r121;
        goto L260
    L86:
        e = e;
        ILoginApi r194 = r190;
        r102 = r191;
        b r195 = r193;
        r156 = r188;
        k0 r196 = r121;
        Ref.ObjectRef r197 = r192;
    L268:
        r126 = FLogger.f375446a;     // Catch: CancellationException -> L192 Throwable -> L193
        StringBuilder r198 = new StringBuilder(r189);     // Catch: CancellationException -> L192 Throwable -> L193
        r198.append(e.getErrorCode());     // Catch: CancellationException -> L192 Throwable -> L193
        r143 = r213;
        r198.append(r143);     // Catch: CancellationException -> L192 Throwable -> L193
        r198.append(e.getErrorMsg());     // Catch: CancellationException -> L192 Throwable -> L193
        r126.e("DouYinAuthUtil", r198.toString());     // Catch: CancellationException -> L192 Throwable -> L193
        r144 = e.getErrorCode();     // Catch: CancellationException -> L192 Throwable -> L193
        String r199 = e.getErrorMsg();     // Catch: CancellationException -> L192 Throwable -> L193
        int r1100 = e.getErrorCode();     // Catch: CancellationException -> L192 Throwable -> L193
        String r1101 = "";
        if (r1100 == 1030) goto L139;
        if (r1100 != 1041) goto L96;
        r126.i("DouYinAuthUtil", "enter changeBind flow");     // Catch: Throwable -> L73 CancellationException -> L192
        r197.element = CommonDouYinLoginTracker.ResultStage.CHANGE_BIND;     // Catch: Throwable -> L73 CancellationException -> L192
        FragmentActivity r200 = r196.getActivity();     // Catch: Throwable -> L73 CancellationException -> L192
        String r1102 = e.getErrorMsg();     // Catch: Throwable -> L73 CancellationException -> L192
        if (r1102 != null) goto L112;
        r1102 = "";
    L112:
        String r1103 = e.getAuthToken();     // Catch: Throwable -> L73 CancellationException -> L192
        if (r1103 != null) goto L115;
        r1103 = "";
    L115:
        String r1104 = e.getProfileKey();     // Catch: Throwable -> L73 CancellationException -> L192
        if (r1104 == null) goto L119;
        r1101 = r1104;
    L119:
        r110.L$0 = r156;     // Catch: Throwable -> L73 CancellationException -> L192
        r110.L$1 = r196;     // Catch: Throwable -> L73 CancellationException -> L192
        r110.L$2 = r195;     // Catch: Throwable -> L73 CancellationException -> L192
        r110.L$3 = r102;     // Catch: Throwable -> L73 CancellationException -> L192
        r110.L$4 = r197;     // Catch: Throwable -> L73 CancellationException -> L192
        r110.L$5 = r199;     // Catch: Throwable -> L73 CancellationException -> L192
        r110.L$6 = e;     // Catch: Throwable -> L73 CancellationException -> L192
        r110.L$7 = null;     // Catch: Throwable -> L73 CancellationException -> L192
        r110.I$0 = r144;     // Catch: Throwable -> L73 CancellationException -> L192
        r110.label = 5;     // Catch: Throwable -> L73 CancellationException -> L192
        Object r201 = e(r194, r200, r1102, r1103, r1101, r110);     // Catch: Throwable -> L73 CancellationException -> L192
        if (r201 != r112) goto L122;
        return r112;
    L122:
        r145 = r201;
        r147 = r102;
        r122 = r197;
        r137 = r199;
        ISdkDouyinAuth r317 = r156;
        r146 = e;
        r142 = r317;
        r121 = r196;
        r120 = r195;
        goto L283
    L96:
        if (r1100 == 1907) goto L98;
        l(r196.a(), r195, (CommonDouYinLoginTracker.ResultStage) r197.element, e.getErrorCode(), e.getErrorMsg());     // Catch: Throwable -> L73 CancellationException -> L192
        r124 = Unit.INSTANCE;     // Catch: Throwable -> L73 CancellationException -> L192
        r127 = r102;
        goto L108
    L98:
        r197.element = CommonDouYinLoginTracker.ResultStage.GO_ACCOUNT;     // Catch: Throwable -> L73 CancellationException -> L192
        FragmentActivity r202 = r196.getActivity();     // Catch: Throwable -> L73 CancellationException -> L192
        String r203 = e.getErrorMsg();     // Catch: Throwable -> L73 CancellationException -> L192
        r110.L$0 = r196;     // Catch: Throwable -> L73 CancellationException -> L192
        r110.L$1 = r195;     // Catch: Throwable -> L73 CancellationException -> L192
        r110.L$2 = r102;     // Catch: Throwable -> L73 CancellationException -> L192
        r110.L$3 = r197;     // Catch: Throwable -> L73 CancellationException -> L192
        r110.L$4 = e;     // Catch: Throwable -> L73 CancellationException -> L192
        r110.L$5 = null;     // Catch: Throwable -> L73 CancellationException -> L192
        r110.L$6 = null;     // Catch: Throwable -> L73 CancellationException -> L192
        r110.L$7 = null;     // Catch: Throwable -> L73 CancellationException -> L192
        r110.label = 6;     // Catch: Throwable -> L73 CancellationException -> L192
        r106 = g(r202, r203, r110);     // Catch: Throwable -> L73 CancellationException -> L192
        if (r106 != r112) goto L101;
        return r112;
    L101:
        r122 = r197;
        r121 = r196;
        r123 = r102;
        r120 = r195;
        goto L270
    L139:
        r126.i("DouYinAuthUtil", "enter switchBind flow");     // Catch: CancellationException -> L192 Throwable -> L193
        r197.element = CommonDouYinLoginTracker.ResultStage.SWITCH_BIND;     // Catch: CancellationException -> L192 Throwable -> L193
        String r204 = e.getProfileKey();     // Catch: CancellationException -> L192 Throwable -> L193
        if (r204 != null) goto L142;
        String r214 = "";
    L143:
        List<Integer> r205 = i0.f357057a;     // Catch: CancellationException -> L192 Throwable -> L193
        SwitchBindParam r206 = new SwitchBindParam(r214, "8943", "aweme_v2", r196.d(), r196.e(), r196.d(), r(r196.b()));     // Catch: CancellationException -> L192 Throwable -> L193
        FragmentActivity r207 = r196.getActivity();     // Catch: CancellationException -> L192 Throwable -> L193
        r110.L$0 = r156;     // Catch: CancellationException -> L192 Throwable -> L193
        r110.L$1 = r196;     // Catch: CancellationException -> L192 Throwable -> L193
        r110.L$2 = r195;     // Catch: CancellationException -> L192 Throwable -> L193
        r110.L$3 = r102;     // Catch: CancellationException -> L192 Throwable -> L193
        r110.L$4 = r197;     // Catch: CancellationException -> L192 Throwable -> L193
        r177 = r199;
        r110.L$5 = r177;     // Catch: CancellationException -> L192 Throwable -> L193
        r110.L$6 = e;     // Catch: CancellationException -> L192 Throwable -> L193
        r110.L$7 = null;     // Catch: CancellationException -> L192 Throwable -> L193
        r110.I$0 = r144;     // Catch: CancellationException -> L192 Throwable -> L193
        r110.label = 4;     // Catch: CancellationException -> L192 Throwable -> L193
        Object r208 = f(r194, r207, r206, r110);     // Catch: CancellationException -> L192 Throwable -> L193
        if (r208 != r112) goto L146;
        return r112;
    L146:
        r174 = e;
        r107 = r144;
        r171 = r102;
        r175 = r208;
        r176 = r197;
        r173 = r196;
        r172 = r195;
        goto L256
    L142:
        r214 = r204;
    L192:
        r114 = r114;
        k0 r209 = r196;
        ?? r215 = r102;
        b r216 = r195;
        Ref.ObjectRef r1105 = r197;
    L199:
        r130 = r1105;
        r131 = r209;
        r132 = r215;
        r133 = r216;
    L193:
        th = th;
        r114 = r114;
    L43:
        r162 = r102;
    L85:
        r123 = r191;
        r122 = r192;
        r120 = r193;
    L83:
        th = th;
        r162 = r191;
        goto L75
    L38:
        e = e;
        r210 = "changeBind result=";
        r211 = "switchBind result=";
        r189 = "awaitBindPlatform failed, code=";
        r213 = ", msg=";
        r114 = "bindAndGetToken finished, dismiss loading if showing";
        r102 = r162;
        r195 = r186;
        r156 = r188;
        r194 = r212;
        r100 = "refresh token stage=";
        r115 = "bindAndGetToken cancelled, stage=";
        r196 = r187;
        r103 = "refresh token failed after bind/change, code=";
        r197 = r185;
    L37:
        r130 = r185;
        r132 = r162;
        r133 = r186;
        r115 = "bindAndGetToken cancelled, stage=";
        r131 = r187;
    L35:
        th = th;
        goto L244
    L40:
        Ref.ObjectRef r217 = (Ref.ObjectRef) r110.L$3;
        d r218 = (d) r110.L$2;
        b r219 = (b) r110.L$1;
        k0 r220 = (k0) r110.L$0;
        ResultKt.throwOnFailure(r106);     // Catch: CancellationException -> L44 Throwable -> L175
        r115 = "bindAndGetToken cancelled, stage=";
        r114 = "bindAndGetToken finished, dismiss loading if showing";
        r217 = r217;
        r219 = r219;
        r220 = r220;
        r218 = r218;
    L266:
        r124 = Unit.INSTANCE;     // Catch: Throwable -> L73 CancellationException -> L250
        r125 = r218;
    L76:
        r133 = r219;
        r131 = r220;
        r114 = r114;
        r130 = r217;
        r132 = r218;
    L44:
        r115 = "bindAndGetToken cancelled, stage=";
        r114 = "bindAndGetToken finished, dismiss loading if showing";
        goto L76
    L45:
        boolean r221 = r110.Z$0;
        Ref.ObjectRef r222 = (Ref.ObjectRef) r110.L$7;
        Job r1106 = (Job) r110.L$6;
        d r1107 = (d) r110.L$5;
        b r1108 = (b) r110.L$4;
        g0 r1109 = (g0) r110.L$3;
        k0 r223 = (k0) r110.L$2;
        ISdkDouyinAuth r224 = (ISdkDouyinAuth) r110.L$1;
        ILoginApi r225 = (ILoginApi) r110.L$0;
        ResultKt.throwOnFailure(r106);     // Catch: Throwable -> L48 CancellationException -> L50 AccountTokenUpdateFailedException -> L51
        final Job r1110 = r1106;
        final Ref.ObjectRef r1111 = r222;
        r194 = r225;
        boolean r226 = r221;
        r115 = "bindAndGetToken cancelled, stage=";
        k0 r227 = r223;
        d r228 = r1107;
        String r1112 = "awaitUpdateAccountToken failed, code=";
        b r229 = r1108;
        g0 r230 = r1109;
        Object r1113 = r106;
        r156 = r224;
    L264:
        a r1114 = (a) r1113;     // Catch: Throwable -> L195 CancellationException -> L198 AccountTokenUpdateFailedException -> L200
        r211 = "switchBind result=";
        FLogger r231 = FLogger.f375446a;     // Catch: Throwable -> L195 CancellationException -> L198
        r210 = "changeBind result=";
        r231.i("DouYinAuthUtil", "awaitUpdateAccountToken success, authCode received (masked)");     // Catch: Throwable -> L195 CancellationException -> L198
        if (r230 == null) goto L65;
        r230.g70(DismissReason.NOT_HANDLED);     // Catch: Throwable -> L195 CancellationException -> L198
        Unit r232 = Unit.INSTANCE;     // Catch: Throwable -> L195 CancellationException -> L198
    L65:
        r1111.element = CommonDouYinLoginTracker.ResultStage.BIND_TOKEN;     // Catch: Throwable -> L195 CancellationException -> L198
        r189 = "awaitBindPlatform failed, code=";
        r213 = ", msg=";
        r228.c(r227.c(), new q(r1111, r1110));     // Catch: Throwable -> L195 CancellationException -> L198
        if (r226 == false) goto L258;
        DouYinLoginScopeUpgradeHelper r233 = DouYinLoginScopeUpgradeHelper.f356980a;     // Catch: Throwable -> L195 CancellationException -> L198
        CommonDouYinLoginTracker.ResultStage r234 = (CommonDouYinLoginTracker.ResultStage) r1111.element;     // Catch: Throwable -> L195 CancellationException -> L198
        String r235 = r1114.a();     // Catch: Throwable -> L195 CancellationException -> L198
        r110.L$0 = r227;     // Catch: Throwable -> L195 CancellationException -> L198
        r110.L$1 = r229;     // Catch: Throwable -> L195 CancellationException -> L198
        r110.L$2 = r228;     // Catch: Throwable -> L195 CancellationException -> L198
        r110.L$3 = r1111;     // Catch: Throwable -> L195 CancellationException -> L198
        r110.L$4 = null;     // Catch: Throwable -> L195 CancellationException -> L198
        r110.L$5 = null;     // Catch: Throwable -> L195 CancellationException -> L198
        r110.L$6 = null;     // Catch: Throwable -> L195 CancellationException -> L198
        r110.L$7 = null;     // Catch: Throwable -> L195 CancellationException -> L198
        r110.label = 2;     // Catch: Throwable -> L195 CancellationException -> L198
        if (r233.b(r156, r227, r229, r234, r235, r110) != r112) goto L70;
        return r112;
    L70:
        r218 = r228;
        r220 = r227;
        r219 = r229;
        r217 = r1111;
        goto L266
    L258:
        List<Integer> r236 = i0.f357057a;     // Catch: BindPlatformFailedException -> L88 Throwable -> L195 CancellationException -> L198
        r231.i("DouYinAuthUtil", "awaitBindPlatform start, platformAppId=8943, platform=aweme_v2");     // Catch: BindPlatformFailedException -> L88 Throwable -> L195 CancellationException -> L198
        String r237 = r1114.a();     // Catch: BindPlatformFailedException -> L88 Throwable -> L195 CancellationException -> L198
        r110.L$0 = r194;     // Catch: BindPlatformFailedException -> L88 Throwable -> L195 CancellationException -> L198
        r110.L$1 = r156;     // Catch: BindPlatformFailedException -> L88 Throwable -> L195 CancellationException -> L198
        r110.L$2 = r227;     // Catch: BindPlatformFailedException -> L88 Throwable -> L195 CancellationException -> L198
        r110.L$3 = r229;     // Catch: BindPlatformFailedException -> L88 Throwable -> L195 CancellationException -> L198
        r110.L$4 = r228;     // Catch: BindPlatformFailedException -> L88 Throwable -> L195 CancellationException -> L198
        r110.L$5 = r1111;     // Catch: BindPlatformFailedException -> L88 Throwable -> L195 CancellationException -> L198
        r110.L$6 = "Bind Douyin successfully.";     // Catch: BindPlatformFailedException -> L88 Throwable -> L195 CancellationException -> L198
        r110.L$7 = "Bind Douyin successfully.Get Douyin token failed.";     // Catch: BindPlatformFailedException -> L88 Throwable -> L195 CancellationException -> L198
        r110.I$0 = 0;     // Catch: BindPlatformFailedException -> L88 Throwable -> L195 CancellationException -> L198
        r110.label = 3;     // Catch: BindPlatformFailedException -> L88 Throwable -> L195 CancellationException -> L198
        if (c(r156, r237, r110) != r112) goto L80;
        return r112;
    L80:
        r188 = r156;
        r193 = r229;
        r107 = 0;
        r190 = r194;
        r184 = "Bind Douyin successfully.";
        r108 = "Bind Douyin successfully.Get Douyin token failed.";
        r191 = r228;
        r121 = r227;
        r192 = r1111;
    L88:
        e = e;
        r102 = r228;
        r196 = r227;
        r195 = r229;
        r197 = r1111;
    L200:
        e = e;
        r114 = r114;
        Ref.ObjectRef r238 = r1111;
        r228 = r228;
        k0 r239 = r227;
        b r240 = r229;
    L279:
        FLogger r241 = FLogger.f375446a;     // Catch: Throwable -> L227 CancellationException -> L229
        r241.e("DouYinAuthUtil", r1112 + e.getErrorCode() + ", msg=" + e.getErrorMsg() + ", stage=" + r238.element);     // Catch: Throwable -> L227 CancellationException -> L229
        if (r230 == null) goto L216;
        r230.g70(DismissReason.NOT_HANDLED);     // Catch: Throwable -> L227 CancellationException -> L229
        Unit r242 = Unit.INSTANCE;     // Catch: Throwable -> L227 CancellationException -> L229
    L216:
        if (Intrinsics.areEqual(e.getErrorCode(), "-2") == false) goto L218;
        j(r239.a(), r240, (CommonDouYinLoginTracker.ResultStage) r238.element, -2, "[-2]:The user cancel to bind Douyin.");     // Catch: Throwable -> L227 CancellationException -> L229
    L225:
        r124 = Unit.INSTANCE;     // Catch: Throwable -> L227 CancellationException -> L229
        r128 = r228;
        r126 = r241;
        goto L241
    L218:
        b0 r243 = r239.a();     // Catch: Throwable -> L227 CancellationException -> L229
        CommonDouYinLoginTracker.ResultStage r244 = (CommonDouYinLoginTracker.ResultStage) r238.element;     // Catch: Throwable -> L227 CancellationException -> L229
        String r245 = e.getErrorCode();     // Catch: Throwable -> L227 CancellationException -> L229
        if (r245 == null) goto L223;
        Integer r246 = StringsKt.toIntOrNull(r245);     // Catch: Throwable -> L227 CancellationException -> L229
        if (r246 == null) goto L223;
        int r247 = r246.intValue();     // Catch: Throwable -> L227 CancellationException -> L229
    L224:
        l(r243, r240, r244, r247, e.getErrorMsg());     // Catch: Throwable -> L227 CancellationException -> L229
    L223:
        r247 = -10014;
    L229:
        r132 = r228;
        r130 = r238;
        r131 = r239;
        r133 = r240;
    L227:
        th = th;
    L197:
        r162 = r228;
    L198:
        r114 = r114;
        r215 = r228;
        r209 = r227;
        r216 = r229;
        r1105 = r1111;
    L195:
        th = th;
        r114 = r114;
        goto L197
    L51:
        e = e;
        r115 = "bindAndGetToken cancelled, stage=";
        r228 = r1107;
        r230 = r1109;
        r239 = r223;
        r1112 = "awaitUpdateAccountToken failed, code=";
        r240 = r1108;
        r238 = r222;
    L50:
        r115 = "bindAndGetToken cancelled, stage=";
        r132 = r1107;
        r133 = r1108;
        r131 = r223;
        r130 = r222;
    L48:
        th = th;
        r162 = r1107;
        goto L244
    L53:
        ResultKt.throwOnFailure(r106);
        FLogger r248 = FLogger.f375446a;
        r115 = "bindAndGetToken cancelled, stage=";
        r248.i("DouYinAuthUtil", "bindAndGetToken start, isScopeUpgrade=" + r315);
        d r249 = new d(r312.getActivity());
        r1112 = "awaitUpdateAccountToken failed, code=";
        Job r1115 = (Job) r110.getContext().get(Job.Key);
        Ref.ObjectRef r250 = new Ref.ObjectRef();
        r250.element = CommonDouYinLoginTracker.ResultStage.DOUYIN_AUTH;
        r248.i("DouYinAuthUtil", "awaitUpdateAccountToken requesting");     // Catch: Throwable -> L204 CancellationException -> L207 AccountTokenUpdateFailedException -> L209
        Bundle r251 = r312.f();     // Catch: Throwable -> L204 CancellationException -> L207 AccountTokenUpdateFailedException -> L209
        r110.L$0 = r310;     // Catch: Throwable -> L204 CancellationException -> L207 AccountTokenUpdateFailedException -> L209
        r110.L$1 = r311;     // Catch: Throwable -> L204 CancellationException -> L207 AccountTokenUpdateFailedException -> L209
        r110.L$2 = r312;     // Catch: Throwable -> L204 CancellationException -> L207 AccountTokenUpdateFailedException -> L209
        r110.L$3 = r313;     // Catch: Throwable -> L204 CancellationException -> L207 AccountTokenUpdateFailedException -> L209
        b r252 = r314;
        r110.L$4 = r252;     // Catch: AccountTokenUpdateFailedException -> L202 Throwable -> L204 CancellationException -> L251
        r110.L$5 = r249;     // Catch: AccountTokenUpdateFailedException -> L202 Throwable -> L204 CancellationException -> L251
        r110.L$6 = r1115;     // Catch: AccountTokenUpdateFailedException -> L202 Throwable -> L204 CancellationException -> L251
        r110.L$7 = r250;     // Catch: AccountTokenUpdateFailedException -> L202 Throwable -> L204 CancellationException -> L251
        r110.Z$0 = r315;     // Catch: AccountTokenUpdateFailedException -> L202 Throwable -> L204 CancellationException -> L251
        r110.label = 1;     // Catch: AccountTokenUpdateFailedException -> L202 Throwable -> L204 CancellationException -> L251
        Object r253 = h(r311, r251, r110);     // Catch: AccountTokenUpdateFailedException -> L202 Throwable -> L204 CancellationException -> L251
        if (r253 != r112) goto L59;
        return r112;
    L59:
        r194 = r310;
        r1113 = r253;
        r228 = r249;
        r227 = r312;
        r156 = r311;
        r1110 = r1115;
        r226 = r315;
        r1111 = r250;
        r229 = r252;
        r230 = r313;
        goto L264
    L202:
        e = e;
    L211:
        r228 = r249;
        r238 = r250;
        r239 = r312;
        r240 = r252;
        r230 = r313;
    L208:
        r132 = r249;
        r130 = r250;
        r131 = r312;
        r133 = r252;
        goto L231
    L204:
        th = th;
        r105 = r249;
    L206:
        r162 = r105;
    L209:
        e = e;
        r252 = r314;
    L207:
        r252 = r314;
        goto L208
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L175:
        th = th;
    L73:
        th = th;
        r162 = "switchBind result=";
    L29:
        r101 = "awaitBindPlatform failed, code=";
        r102 = "awaitUpdateAccountToken failed, code=";
        r105 = r311;
        r104 = r113;
    L27:
        th = th;
    L31:
        r130 = r101;
        r131 = r105;
        r133 = r104;
        r132 = r102;
    L7:
        r110 = new CommonDouYinLoginUtil$bindAndGetToken$1(this, r316);
        goto L8
    }
}
