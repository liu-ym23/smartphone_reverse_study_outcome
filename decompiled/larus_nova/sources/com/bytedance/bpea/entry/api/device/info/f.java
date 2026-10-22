package com.bytedance.bpea.entry.api.device.info;

import android.content.Context;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f202189a = 0;

    public static final class a {
        @JvmStatic
        public static String a(final Context r100, TokenCert r101) {
            int r102 = f.f202189a;     // Catch: BPEAException -> L4
            BaseAuthEntry.Companion r103 = BaseAuthEntry.f202194a;     // Catch: BPEAException -> L4
            int r104 = com.bytedance.bpea.entry.api.device.info.a.f202184a;     // Catch: BPEAException -> L4
            return (String) r103.a(com.bytedance.bpea.entry.api.device.info.a.C2918a.a(r101, "deviceInfo_settings_getAndroidId", 102003), new SettingsEntry$Companion$getAndroidIdUnsafe$1(r100));
        L4:
            e = move-exception;
            e.printStackTrace();
            return "";
        }
    }

    static {
    }
}
