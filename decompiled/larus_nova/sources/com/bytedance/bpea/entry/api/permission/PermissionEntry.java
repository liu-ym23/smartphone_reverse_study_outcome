package com.bytedance.bpea.entry.api.permission;

import android.app.Activity;
import android.app.Fragment;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.basics.EntryCategory;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import kotlin.jvm.JvmStatic;
import qc4.c;

/* JADX INFO: loaded from: classes8.dex */
public final class PermissionEntry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f202193a = null;

    public static final class Companion {
        public Companion() {
        }

        public static c a(String[] r100, Cert r101, int r110) {
            c r102 = new c(r101, "permission_request", r110, new String[]{"permission"}, Integer.valueOf(EntryCategory.BPEA_ENTRY.getType()));
            r102.f532471f.put("permission", r100);
            return r102;
        }

        @JvmStatic
        public final void requestPermissions(final Activity r100, final String[] r101, final int r102, Cert r103) throws BPEAException {
            BaseAuthEntry.f202194a.a(a(r101, r103, 102600), new PermissionEntry$Companion$requestPermissions$1(r100, r101, r102));
        }

        @JvmStatic
        public final void requestPermissions(final Fragment r100, final String[] r101, final int r102, Cert r103) throws BPEAException {
            BaseAuthEntry.f202194a.a(a(r101, r103, 102601), new PermissionEntry$Companion$requestPermissions$2(r100, r101, r102));
        }

        @JvmStatic
        public final void requestPermissions(final androidx.fragment.app.Fragment r100, final String[] r101, final int r102, Cert r103) throws BPEAException {
            BaseAuthEntry.f202194a.a(a(r101, r103, 102600), new PermissionEntry$Companion$requestPermissions$3(r100, r101, r102));
        }
    }

    @JvmStatic
    public static final void requestPermissions(Activity r100, String[] r101, int r102, Cert r103) throws BPEAException {
        f202193a.requestPermissions(r100, r101, r102, r103);
    }

    @JvmStatic
    public static final void requestPermissions(Fragment r100, String[] r101, int r102, Cert r103) throws BPEAException {
        f202193a.requestPermissions(r100, r101, r102, r103);
    }

    @JvmStatic
    public static final void requestPermissions(androidx.fragment.app.Fragment r100, String[] r101, int r102, Cert r103) throws BPEAException {
        f202193a.requestPermissions(r100, r101, r102, r103);
    }

    static {
        f202193a = new Companion();
    }

    @JvmStatic
    public static final void a(final Activity r100, final String[] r101, final int r102, TokenCert r103) throws BPEAException {
        f202193a.getClass();
        BaseAuthEntry.f202194a.a(Companion.a(r101, r103, 102600), new PermissionEntry$Companion$requestPermissionsByActivityCompat$1(r100, r101, r102));
    }
}
