package ega;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.api.g1;
import com.larus.platform.service.i2;
import com.obric.assistant.settings.VoicePrintScene;
import com.obric.assistant.util.StartActivityForResultHelper;
import com.obric.audio.enroll.vm.EnrollViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import f06.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import t19.s;
import v19.h;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f472616a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f472617a = null;

        static {
            int[] r100 = new int[VoicePrintScene.values().length];
            r100[VoicePrintScene.VOICE_WAKE_UP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[VoicePrintScene.VOICE_AUTHENTICATE_ON_LOCKED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[VoicePrintScene.NOISE_REDUCTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f472617a = r100;
        }
    }

    public static final class b implements g1.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f472618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f472619b;

        @Override // com.larus.platform.api.g1.b
        public final void onGoSettingsDialogDismiss(boolean r100) {
        }

        @Override // com.larus.platform.api.g1.b
        public final void onGoSettingsDialogShow() {
        }

        @Override // com.larus.platform.api.g1.b
        public final void onSettingPageReturn() {
        }

        public b(Function0<Unit> r100, Function0<Unit> r101) {
            this.f472618a = r100;
            this.f472619b = r101;
        }

        @Override // com.larus.platform.api.g1.c
        public final void onResult(boolean r100, List<String> r101, List<String> r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "grantedList");
            Intrinsics.checkNotNullParameter(r102, "deniedList");
            if (r100 == true) goto L5;
        L7:
            this.f472619b.invoke();
            return;
        L5:
            if ((!r101.isEmpty()) == false) goto L7;
            this.f472618a.invoke();
        }
    }

    static {
        f472616a = new c();
    }

    public c() {
    }

    public static void a(Context r210, VoicePrintScene r211, Function0 r212, Function0 r213) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "scene");
        Intrinsics.checkNotNullParameter(r212, "onPermissionGranted");
        Intrinsics.checkNotNullParameter(r213, "onPermissionDenied");
        if ((r210 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r100 = (FragmentActivity) r210;
    L6:
        if (r100 != null) goto L8;
        return;
    L8:
        Application r101 = AppHost.f326268a.getApplication();
        ArrayList r102 = new ArrayList();
        String r110 = "android.permission.RECORD_AUDIO";
        Object[] r111 = {"android.permission.RECORD_AUDIO"};
        f06.b r112 = new f06.b("auto_cert_com_obric_assistant_settings_util_VoicePrintSettingHelper_android_app_Application_checkSelfPermission");
        g06.a r103 = ApiHookConfig.f245611b.get(102608);
        if (r103 == null) goto L11;
        f06.a[] r104 = r103.f479473i;
    L12:
        f06.a[] r113 = r104;
        int r114 = r113.length;
        int r105 = 0;
    L14:
        if (r105 >= r114) goto L21;
        f06.a r106 = r113[r105];
        int r115 = r105;
        int r214 = r114;
        f06.a[] r215 = r113;
        f06.b r216 = r112;
        String r217 = r110;
        d r107 = r106.preInvoke(102608, "android/app/Application", "checkSelfPermission", r101, r111, "int", r216);     // Catch: Exception -> L30
        if (r107.f474982a == true) goto L23;
        r102.add(r106);     // Catch: Exception -> L30
    L23:
        if (r107.f474982a == false) goto L25;
        int r108 = ((Integer) r107.f474983b).intValue();
        String r109 = r217;
    L26:
        if (r108 != 0) goto L28;
        r212.invoke();
        return;
    L28:
        i2 r116 = i2.f365748b;
        g1.a.b(r100, CollectionsKt.mutableListOf(new String[]{r109}), new b(r212, r213), null, null, 56);
        return;
    L25:
        r109 = r217;
        r108 = r101.checkSelfPermission(r109);
    L20:
        r105 = r115 + 1;
        r114 = r214;
        r113 = r215;
        r112 = r216;
        r110 = r217;
        goto L14
    L21:
        r217 = r110;
        r107 = new d(false, null);
        goto L23
    L11:
        r104 = ApiHookConfig.f245613d;
        goto L12
    L5:
        r100 = null;
        goto L6
    }

    public static void b(Context r100, VoicePrintScene r101, final Function0 r102, Function0 r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "onActivityResult");
        Intrinsics.checkNotNullParameter(r103, "onFailed");
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L16
        boolean r105 = h.f552477a;     // Catch: Throwable -> L16
        boolean r106 = h.a(null);     // Catch: Throwable -> L16
        Intent r107 = new Intent("com.obric.sva.sdk.ACTION_START_ENROLL");     // Catch: Throwable -> L16
        r107.setClassName(r100.getPackageName(), "com.obric.audio.enroll.ui.VoicePrintEnrollActivity");     // Catch: Throwable -> L16
        r107.putExtra("IS_DARK_MODE", r106);     // Catch: Throwable -> L16
        int r108 = a.f472617a[r101.ordinal()];     // Catch: Throwable -> L16
        if (r108 != 1) goto L6;
        String r109 = "VoiceWakeup";
    L14:
        r107.putExtra("start_from", r109);     // Catch: Throwable -> L16
        StartActivityForResultHelper.f393652a.startActivityForResult(r107, new ega.b(r102), null);     // Catch: Throwable -> L16
        Object r110 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L19:
        if (Result.m9452exceptionOrNullimpl(r110) == null) goto L23;
        s.j(s.f544207a, r100, r100.getString(R.string.obric_with_no_voice_module), null, false, 28);
        r103.invoke();
        return;
    L23:
        return;
    L6:
        if (r108 != 2) goto L8;
        r109 = "VoiceAuthorization";
        goto L14
    L8:
        if (r108 != 3) goto L11;
        r109 = EnrollViewModel.NOISE_REDUCTION;
        goto L14
    L11:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }
}
