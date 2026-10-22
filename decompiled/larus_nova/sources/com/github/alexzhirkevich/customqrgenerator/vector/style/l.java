package com.github.alexzhirkevich.customqrgenerator.vector.style;

import android.graphics.Path;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public interface l extends m {

    public static final class a implements l, m {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f274305b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f274306a;

        static {
            f274305b = new a();
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.m
        public final Path a(float r100, com.github.alexzhirkevich.customqrgenerator.style.c r101) {
            Intrinsics.checkNotNullParameter(r101, "neighbors");
            return this.f274306a.a(r100, r101);
        }

        public a() {
            this.f274306a = b.f274271a;
        }
    }
}
