package com.bytedance.bpea.entry.api.mediarecorder;

import android.media.MediaRecorder;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.EntryCategory;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import kotlin.jvm.JvmStatic;
import qc4.c;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2919a f202192a = null;

    /* JADX INFO: renamed from: com.bytedance.bpea.entry.api.mediarecorder.a$a, reason: collision with other inner class name */
    public static final class C2919a {
        public C2919a() {
        }

        @JvmStatic
        public static void b(final MediaRecorder r100, TokenCert r101) throws BPEAException {
            BaseAuthEntry.f202194a.a(a(r101, "mediaRecord_release", 100501), new MediaRecorderEntry$Companion$release$1(r100));
        }

        @JvmStatic
        public static void c(final MediaRecorder r100, TokenCert r101) throws BPEAException, IllegalStateException {
            BaseAuthEntry.f202194a.a(a(r101, "mediaRecord_start", 100502), new MediaRecorderEntry$Companion$start$1(r100));
        }

        @JvmStatic
        public static void d(final MediaRecorder r100, TokenCert r101) throws BPEAException, IllegalStateException {
            BaseAuthEntry.f202194a.a(a(r101, "mediaRecord_stop", 100503), new MediaRecorderEntry$Companion$stop$1(r100));
        }

        public static c a(TokenCert r100, String r101, int r102) {
            return new c(r100, r101, r102, new String[]{"audio", "video"}, Integer.valueOf(EntryCategory.BPEA_ENTRY.getType()));
        }
    }

    static {
        f202192a = new C2919a();
    }
}
