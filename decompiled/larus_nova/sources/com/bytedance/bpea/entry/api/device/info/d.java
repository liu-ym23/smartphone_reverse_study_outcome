package com.bytedance.bpea.entry.api.device.info;

import android.content.pm.PackageManager;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f202187a = 0;

    public static final class a {
        @JvmStatic
        public static List a(final PackageManager r100, final int r101, TokenCert r102) {
            ArrayList r103 = new ArrayList();
            int r104 = d.f202187a;     // Catch: BPEAException -> L5
            BaseAuthEntry.Companion r105 = BaseAuthEntry.f202194a;     // Catch: BPEAException -> L5
            int r106 = com.bytedance.bpea.entry.api.device.info.a.f202184a;     // Catch: BPEAException -> L5
            return (List) r105.a(com.bytedance.bpea.entry.api.device.info.a.C2918a.a(r102, "deviceInfo_packageManger_getInstalledPackages", 101309), new PackageManagerEntry$Companion$getInstalledPackagesUnsafe$1(r100, r101));
        L5:
            e = move-exception;
            e.printStackTrace();
            return r103;
        }
    }

    static {
    }
}
