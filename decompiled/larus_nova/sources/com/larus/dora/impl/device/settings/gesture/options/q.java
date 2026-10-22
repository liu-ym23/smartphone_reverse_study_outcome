package com.larus.dora.impl.device.settings.gesture.options;

import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettings;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class q {

    public static final class a extends q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f334483a = null;

        static {
            f334483a = new a();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            a r101 = (a) r100;
            return true;
        }

        public final int hashCode() {
            return -84984259;
        }

        public final String toString() {
            return "Idle";
        }

        public a() {
        }
    }

    public static final class b extends q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DoraGGestureSettings f334484a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f334484a, ((b) r100).f334484a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f334484a.hashCode();
        }

        public final String toString() {
            return "Success(selectedGesture=" + this.f334484a + ')';
        }

        public b(DoraGGestureSettings r100) {
            Intrinsics.checkNotNullParameter(r100, "selectedGesture");
            this.f334484a = r100;
        }
    }

    public q() {
    }
}
