package com.bytedance.bpea.entry.api.appjump;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.basics.EntryCategory;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import com.mammon.audiosdk.SAMICoreCode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import qc4.c;
import qc4.d;

/* JADX INFO: loaded from: classes8.dex */
public final class AppJumpEntry {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f202179a = 0;

        static {
        }
    }

    static {
    }

    public static void b(TokenCert r100, final Function1 r101) {
        final d r102 = null;
        c r103 = a(r100, "customize_start_activity", -1, null);     // Catch: BPEAException -> L4
        BaseAuthEntry.Companion r104 = BaseAuthEntry.f202194a;     // Catch: BPEAException -> L4
        r104.getClass();     // Catch: BPEAException -> L4
        com.bytedance.bpea.entry.common.d.b(r103);     // Catch: BPEAException -> L4
        r104.call(r103, null, new AppJumpEntry$checkStartActivityAuthUnsafe$1(r101, r102));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void c(final Context r100, final Intent r101, Cert r102) throws BPEAException {
        BaseAuthEntry.f202194a.a(a(r102, "ctx_start_activity", SAMICoreCode.SAMI_MDSP_CONTEXT_INVALID_PATH, r101), new AppJumpEntry$startActivityUnsafe$5(r100, r101));
    }

    @JvmStatic
    public static final void startActivity(final Activity r100, final Intent r101, Cert r102) {
        BaseAuthEntry.f202194a.a(a(r102, "act_start_activity", SAMICoreCode.SAMI_MSDP_CONTEXT_NOT_PREPARED, r101), new AppJumpEntry$startActivityUnsafe$1(r100, r101));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void startActivity(final Fragment r100, final Intent r101, Cert r102) {
        BaseAuthEntry.f202194a.a(a(r102, "frg_start_activity", SAMICoreCode.SAMI_MDSP_CONTEXT_INPUT_CONTEXT_IS_NULL, r101), new AppJumpEntry$startActivityUnsafe$3(r100, r101));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void startActivity(final androidx.fragment.app.Fragment r100, final Intent r101, Cert r102) {
        BaseAuthEntry.f202194a.a(a(r102, "compat_fragment_start_activity", 130006, r101), new AppJumpEntry$startActivityUnsafe$7(r100, r101));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void startActivity(Context r100, Intent r101, Cert r102) {
        c(r100, r101, r102);     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static c a(Cert r100, String r101, int r110, Intent r111) {
        int r102 = a.f202179a;
        if (r100 == null) goto L9;
        String r103 = r100.certToken();
        if (TextUtils.isEmpty(r103) == true) goto L9;
        if (r111 == null) goto L9;
        r111.putExtra("__security_bpea_auth_through__", r103);
    L9:
        return new c(r100, r101, new String[]{"appjump"}, Integer.valueOf(EntryCategory.BPEA_ENTRY.getType()), r110);
    }

    @JvmStatic
    public static final void startActivity(final Activity r100, final Intent r101, final Bundle r102, Cert r103) {
        BaseAuthEntry.f202194a.a(a(r103, "act_start_activity", SAMICoreCode.SAMI_MSDP_CONTEXT_NOT_PREPARED, r101), new AppJumpEntry$startActivityUnsafe$2(r100, r101, r102));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void startActivityForResult(final Activity r100, final Intent r101, final int r102, Cert r103) {
        BaseAuthEntry.f202194a.a(a(r103, "act_start_activity_for_result", SAMICoreCode.SAMI_MDSP_CONTEXT_INVALID_JSON, r101), new AppJumpEntry$startActivityForResultUnsafe$1(r100, r101, r102));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void startActivity(final Fragment r100, final Intent r101, final Bundle r102, Cert r103) {
        BaseAuthEntry.f202194a.a(a(r103, "frg_start_activity", SAMICoreCode.SAMI_MDSP_CONTEXT_INPUT_CONTEXT_IS_NULL, r101), new AppJumpEntry$startActivityUnsafe$4(r100, r101, r102));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void startActivityForResult(final Fragment r100, final Intent r101, final int r102, Cert r103) {
        BaseAuthEntry.f202194a.a(a(r103, "frg_start_activity_for_result", 130005, r101), new AppJumpEntry$startActivityForResultUnsafe$3(r100, r101, r102));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void startActivity(final Context r100, final Intent r101, final Bundle r102, Cert r103) {
        BaseAuthEntry.f202194a.a(a(r103, "ctx_start_activity", SAMICoreCode.SAMI_MDSP_CONTEXT_INVALID_PATH, r101), new AppJumpEntry$startActivityUnsafe$6(r100, r101, r102));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void startActivityForResult(final androidx.fragment.app.Fragment r100, final Intent r101, final int r102, Cert r103) {
        BaseAuthEntry.f202194a.a(a(r103, "compat_fragment_start_activity_for_result", 130007, r101), new AppJumpEntry$startActivityForResultUnsafe$5(r100, r101, r102));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void startActivity(final androidx.fragment.app.Fragment r100, final Intent r101, final Bundle r102, Cert r103) {
        BaseAuthEntry.f202194a.a(a(r103, "compat_fragment_start_activity", 130006, r101), new AppJumpEntry$startActivityUnsafe$8(r100, r101, r102));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void startActivityForResult(final Activity r100, final Intent r101, final int r102, final Bundle r103, Cert r104) {
        BaseAuthEntry.f202194a.a(a(r104, "act_start_activity_for_result", SAMICoreCode.SAMI_MDSP_CONTEXT_INVALID_JSON, r101), new AppJumpEntry$startActivityForResultUnsafe$2(r100, r101, r102, r103));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void startActivityForResult(final Fragment r100, final Intent r101, final int r102, final Bundle r103, Cert r104) {
        BaseAuthEntry.f202194a.a(a(r104, "frg_start_activity_for_result", 130005, r101), new AppJumpEntry$startActivityForResultUnsafe$4(r100, r101, r102, r103));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void startActivityForResult(final androidx.fragment.app.Fragment r100, final Intent r101, final int r102, final Bundle r103, Cert r104) {
        BaseAuthEntry.f202194a.a(a(r104, "compat_fragment_start_activity_for_result", 130007, r101), new AppJumpEntry$startActivityForResultUnsafe$6(r100, r101, r102, r103));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
