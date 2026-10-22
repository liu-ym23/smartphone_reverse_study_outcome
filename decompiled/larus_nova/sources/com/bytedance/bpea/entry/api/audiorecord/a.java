package com.bytedance.bpea.entry.api.audiorecord;

import android.media.AudioRecord;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.EntryCategory;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import kotlin.jvm.JvmStatic;
import qc4.c;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2916a f202180a = null;

    /* JADX INFO: renamed from: com.bytedance.bpea.entry.api.audiorecord.a$a, reason: collision with other inner class name */
    public static final class C2916a {
        public C2916a() {
        }

        @JvmStatic
        public static void b(final AudioRecord r100, TokenCert r101) throws BPEAException {
            BaseAuthEntry.f202194a.a(a(r101, "audio_release", 100403), new AudioRecordEntry$Companion$release$1(r100));
        }

        @JvmStatic
        public static void c(final AudioRecord r100, TokenCert r101) throws BPEAException, IllegalStateException {
            BaseAuthEntry.f202194a.a(a(r101, "audio_start", 100400), new AudioRecordEntry$Companion$startRecording$1(r100));
        }

        @JvmStatic
        public static void d(final AudioRecord r100, TokenCert r101) throws BPEAException, IllegalStateException {
            BaseAuthEntry.f202194a.a(a(r101, "audio_stop", 100401), new AudioRecordEntry$Companion$stop$1(r100));
        }

        public static c a(TokenCert r100, String r101, int r102) {
            return new c(r100, r101, r102, new String[]{"audio"}, Integer.valueOf(EntryCategory.BPEA_ENTRY.getType()));
        }
    }

    static {
        f202180a = new C2916a();
    }
}
