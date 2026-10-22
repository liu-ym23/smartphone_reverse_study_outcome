package com.github.alexzhirkevich.customqrgenerator.style;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public interface a {

    /* JADX INFO: renamed from: com.github.alexzhirkevich.customqrgenerator.style.a$a, reason: collision with other inner class name */
    public static final class C3844a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C3844a f274255a = null;

        static {
            f274255a = new C3844a();
        }

        public C3844a() {
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.a
        public final Bitmap a(Drawable r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "drawable");
            return DrawableKt.toBitmap(r100, r101, r102, Bitmap.Config.ARGB_8888);
        }
    }

    Bitmap a(Drawable r100, int r101, int r102);
}
