package com.bytedance.bpea.entry.api.ve;

import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    public static final class a {
    }

    static {
    }

    @JvmStatic
    public static final void a(Cert r100, final com.bytedance.bpea.entry.api.ve.a r101) throws BPEAException, Exception {
        BaseAuthEntry.f202194a.a(d.a(r100, new String[]{"video"}, "camera_close"), new VEPrivacyCertCheckEntry$Camera$Companion$close$1(r101));
    }

    @JvmStatic
    public static final <T> T b(Cert r100, final com.bytedance.bpea.entry.api.ve.a<T> r101) throws BPEAException, Exception {
        return (T) BaseAuthEntry.f202194a.a(d.a(r100, new String[]{"video"}, "camera_open"), new VEPrivacyCertCheckEntry$Camera$Companion$open$1(r101));
    }
}
