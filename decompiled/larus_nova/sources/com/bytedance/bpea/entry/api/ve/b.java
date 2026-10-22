package com.bytedance.bpea.entry.api.ve;

import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import com.ss.android.vesdk.h;
import com.ss.android.vesdk.i;
import com.ss.android.vesdk.j;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    public static final class a {
    }

    static {
    }

    @JvmStatic
    public static final void a(Cert r100, final j r101) throws BPEAException, Exception {
        BaseAuthEntry.f202194a.a(d.a(r100, new String[]{"audio"}, "audio_release"), new VEPrivacyCertCheckEntry$AudioRecord$Companion$release$1(r101));
    }

    @JvmStatic
    public static final void b(Cert r100, final h r101) throws BPEAException, Exception {
        BaseAuthEntry.f202194a.a(d.a(r100, new String[]{"audio"}, "audio_start"), new VEPrivacyCertCheckEntry$AudioRecord$Companion$start$1(r101));
    }

    @JvmStatic
    public static final void c(Cert r100, final i r101) throws BPEAException, Exception {
        BaseAuthEntry.f202194a.a(d.a(r100, new String[]{"audio"}, "audio_stop"), new VEPrivacyCertCheckEntry$AudioRecord$Companion$stop$1(r101));
    }
}
