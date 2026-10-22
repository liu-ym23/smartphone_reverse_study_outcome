package com.github.alexzhirkevich.customqrgenerator.style;

import com.github.alexzhirkevich.customqrgenerator.encoder.QrCodeMatrix;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public interface i {

    public static final class a implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f274268a = null;

        static {
            f274268a = new a();
        }

        public a() {
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.i
        public final QrCodeMatrix a(QrCodeMatrix r100) {
            Intrinsics.checkNotNullParameter(r100, "matrix");
            return r100;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.i
        public final void b() {
        }
    }

    QrCodeMatrix a(QrCodeMatrix r100);

    void b();
}
