package com.bytedance.bpea.entry.common;

import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.basics.EntryCategory;
import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
@Deprecated(message = "remove")
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2920a f202195a = null;

    /* JADX INFO: renamed from: com.bytedance.bpea.entry.common.a$a, reason: collision with other inner class name */
    public static final class C2920a {
        public C2920a() {
        }

        @JvmStatic
        public static void a(Cert r100, String[] r101, String r102, String r103) throws BPEAException {
            qc4.c r104 = new qc4.c(r100, r102 + '_' + r103, r101, Integer.valueOf(EntryCategory.DIRECT_AUTH.getType()));
            r104.f532471f.put("sdkName", r102);
            r104.f532471f.put("methodName", r103);
            d.b(r104);
        }
    }

    static {
        f202195a = new C2920a();
    }
}
