package com.larksuite.component.universe_design.emptystate.compose;

import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public abstract class e {

    public static final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Painter f285015a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f285015a, ((a) r100).f285015a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f285015a.hashCode();
        }

        public final String toString() {
            return "PainterImage(painter=" + this.f285015a + ')';
        }

        public a(Painter r100) {
            Intrinsics.checkNotNullParameter(r100, "painter");
            this.f285015a = r100;
        }
    }

    public static final class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageVector f285016a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f285016a, ((b) r100).f285016a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f285016a.hashCode();
        }

        public final String toString() {
            return "VectorImage(imageVector=" + this.f285016a + ')';
        }

        public b(ImageVector r100) {
            Intrinsics.checkNotNullParameter(r100, "imageVector");
            this.f285016a = r100;
        }
    }

    public e() {
    }
}
