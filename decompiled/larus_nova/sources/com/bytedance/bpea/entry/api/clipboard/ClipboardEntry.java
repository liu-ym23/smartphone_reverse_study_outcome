package com.bytedance.bpea.entry.api.clipboard;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.basics.EntryCategory;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import com.bytedance.bpea.entry.common.DataType;
import kotlin.jvm.JvmStatic;
import qc4.c;

/* JADX INFO: loaded from: classes8.dex */
public final class ClipboardEntry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f202182a = null;

    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        public static ClipData b(final ClipboardManager r100, TokenCert r101) throws BPEAException {
            return (ClipData) BaseAuthEntry.f202194a.a(a(r101, "clipboard_getClip", 101803), new ClipboardEntry$Companion$getPrimaryClip$1(r100));
        }

        public static c a(Cert r100, String r101, int r102) {
            return new c(r100, r101, r102, new String[]{DataType.CLIPBOARD}, Integer.valueOf(EntryCategory.BPEA_ENTRY.getType()));
        }

        @JvmStatic
        public static void c(final ClipboardManager r100, final ClipData r101, Cert r102) throws BPEAException {
            BaseAuthEntry.f202194a.a(a(r102, "clipboard_setClip", 101807), new ClipboardEntry$Companion$setPrimaryClip$1(r100, r101));
        }

        @JvmStatic
        public static void d(final ClipboardManager r100, final CharSequence r101, TokenCert r102) throws BPEAException {
            BaseAuthEntry.f202194a.a(a(r102, "clipboard_setText", 101808), new ClipboardEntry$Companion$setText$1(r100, r101));
        }
    }

    static {
        f202182a = new Companion();
    }
}
