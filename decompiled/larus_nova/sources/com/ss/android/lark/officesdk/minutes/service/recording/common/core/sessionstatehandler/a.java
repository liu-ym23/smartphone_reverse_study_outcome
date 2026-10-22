package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import android.app.Application;
import android.media.AudioManager;
import android.os.Build;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f434578h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Boolean, Unit> f434579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f434580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Application f434581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TelephonyManager f434582d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f434583e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f434584f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f434585g;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.a$a, reason: collision with other inner class name */
    public static final class C5173a {
        public static boolean a() {
            Application r100 = LarkContext.getApplication();
            Intrinsics.checkNotNull(r100);
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (ContextCompat.checkSelfPermission(r100, "android.permission.READ_PHONE_STATE") != 0) goto L5;
            boolean r101 = true;
        L7:
            if (r101 == true) goto L22;
            Object r102 = r100.getSystemService("audio");
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.media.AudioManager");
            int r103 = ((AudioManager) r102).getMode();
            if (r103 == 1) goto L20;
            if (r103 == 2) goto L20;
            return false;
        L20:
            return true;
        L22:
            Object r104 = r100.getSystemService("phone");     // Catch: Exception -> L14
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.telephony.TelephonyManager");     // Catch: Exception -> L14
            TelephonyManager r105 = (TelephonyManager) r104;     // Catch: Exception -> L14
            if (2 == r105.getCallState()) goto L12;
            if (1 == r105.getCallState()) goto L12;
            return false;
        L12:
            return true;
        L14:
            e = move-exception;
            lvb.a.b("MmPhoneStateListener", "[isCalling] error: " + e);
            return false;
        L5:
            r101 = false;
            goto L7
        }

        public static boolean b() {
            Application r100 = LarkContext.getApplication();
            boolean r101 = a();
            Object r102 = r100.getSystemService("audio");
            Integer r103 = null;
            if ((r102 instanceof AudioManager) == false) goto L5;
            AudioManager r104 = (AudioManager) r102;
        L6:
            if (r104 == null) goto L8;
            r103 = Integer.valueOf(r104.getMode());
        L8:
            boolean r105 = false;
            if (r103 != null) goto L12;
        L13:
            if (r103 != null) goto L16;
        L18:
            boolean r106 = false;
        L20:
            if (r101 == true) goto L22;
            if (r106 == true) goto L22;
        L23:
            lvb.a.e("MmPhoneStateListener", "[isSystemCallActiveWithAudioFallback] telephonyCalling=" + r101 + ", audioMode=" + r103 + ", audioCalling=" + r106 + ", result=" + r105);
            return r105;
        L22:
            r105 = true;
            goto L23
        L16:
            if (r103.intValue() != 2) goto L18;
        L19:
            r106 = true;
            goto L20
        L12:
            if (r103.intValue() == 1) goto L19;
        L5:
            r104 = null;
            goto L6
        }
    }

    static {
    }

    public final void b() {
        if (this.f434583e == false) goto L6;
        return;
    L6:
        if (this.f434582d != null) goto L8;
        return;
    L8:
        Application r100 = this.f434581c;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (ContextCompat.checkSelfPermission(r100, "android.permission.READ_PHONE_STATE") != 0) goto L11;
        boolean r101 = true;
    L12:
        if (r101 == true) goto L29;
        lvb.a.e(this.f434580b, "No READ_PHONE_STATE permission");
        return;
    L29:
        int r102 = Build.VERSION.SDK_INT;     // Catch: Exception -> L26
        if (r102 < 31) goto L21;
        if (r102 < 31) goto L24;
        c r103 = new c(this);     // Catch: Exception -> L26
        this.f434584f = r103;     // Catch: Exception -> L26
        TelephonyManager r104 = this.f434582d;     // Catch: Exception -> L26
        if (r104 == null) goto L24;
        r104.registerTelephonyCallback(this.f434581c.getMainExecutor(), r103);     // Catch: Exception -> L26
    L24:
        this.f434583e = true;     // Catch: Exception -> L26
        lvb.a.e(this.f434580b, "startListening success");     // Catch: Exception -> L26
        return;
    L21:
        b r105 = new b(this);     // Catch: Exception -> L26
        this.f434585g = r105;     // Catch: Exception -> L26
        TelephonyManager r106 = this.f434582d;     // Catch: Exception -> L26
        if (r106 == null) goto L24;
        r106.listen(r105, 32);     // Catch: Exception -> L26
    L26:
        e = move-exception;
        lvb.a.b(this.f434580b, "startListening failed: " + e);
        return;
    L11:
        r101 = false;
        goto L12
    }

    public final void c() {
        if (this.f434583e == true) goto L5;
        return;
    L5:
        TelephonyManager r100 = this.f434582d;
        if (r100 != null) goto L26;
        return;
    L26:
        int r101 = Build.VERSION.SDK_INT;     // Catch: Exception -> L23
        if (r101 < 31) goto L18;
        if (r101 < 31) goto L21;
        c r102 = this.f434584f;     // Catch: Exception -> L23
        if ((r102 instanceof TelephonyCallback) == true) goto L15;
        r102 = null;
    L15:
        if (r102 == null) goto L17;
        r100.unregisterTelephonyCallback(r102);     // Catch: Exception -> L23
    L17:
        this.f434584f = null;     // Catch: Exception -> L23
    L21:
        this.f434583e = false;     // Catch: Exception -> L23
        lvb.a.e(this.f434580b, "stopListening success");     // Catch: Exception -> L23
        return;
    L18:
        b r103 = this.f434585g;     // Catch: Exception -> L23
        if (r103 == null) goto L21;
        r100.listen(r103, 0);     // Catch: Exception -> L23
        this.f434585g = null;     // Catch: Exception -> L23
    L23:
        e = move-exception;
        lvb.a.b(this.f434580b, "stopListening failed: " + e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function1<? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onPhoneStateChange");
        this.f434579a = r100;
        this.f434580b = "MmPhoneStateHelper";
        Application r101 = LarkContext.getApplication();
        this.f434581c = r101;
        Object r102 = r101.getSystemService("phone");
        if ((r102 instanceof TelephonyManager) == false) goto L5;
        TelephonyManager r103 = (TelephonyManager) r102;
    L6:
        this.f434582d = r103;
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static final void a(a r100, int r101) {
        lvb.a.e(r100.f434580b, "onCallStateChanged: " + r101);
        if (r101 != 0) goto L5;
        r100.f434579a.invoke(Boolean.FALSE);
        return;
    L5:
        if (r101 != 1) goto L7;
    L9:
        r100.f434579a.invoke(Boolean.TRUE);
        return;
    L7:
        if (r101 == 2) goto L9;
    }
}
