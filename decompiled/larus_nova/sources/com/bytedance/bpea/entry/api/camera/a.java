package com.bytedance.bpea.entry.api.camera;

import android.hardware.Camera;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f202181a = 0;

    /* JADX INFO: renamed from: com.bytedance.bpea.entry.api.camera.a$a, reason: collision with other inner class name */
    public static final class C2917a {
        @JvmStatic
        public static Camera b(TokenCert r100) throws BPEAException {
            return (Camera) BaseAuthEntry.f202194a.a(b.a(r100, "camera_open1", 100100), Camera1Entry$Companion$open$1.INSTANCE);
        }

        @JvmStatic
        public static Camera a(final int r100, TokenCert r101) throws BPEAException {
            return (Camera) BaseAuthEntry.f202194a.a(b.a(r101, "camera_open1", 100100), new Camera1Entry$Companion$open$2(r100));
        }

        @JvmStatic
        public static void c(final Camera r100, TokenCert r101) throws BPEAException {
            BaseAuthEntry.f202194a.a(b.a(r101, "camera_close1", 100101), new Camera1Entry$Companion$release$1(r100));
        }
    }

    static {
    }
}
