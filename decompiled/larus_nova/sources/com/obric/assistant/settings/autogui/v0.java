package com.obric.assistant.settings.autogui;

import com.baidu.platform.comapi.map.MapController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public interface v0 {

    public static final class a implements v0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f391967a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f391967a, ((a) r100).f391967a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f391967a.hashCode();
        }

        public final String toString() {
            return "BottomHint(text=" + this.f391967a + ')';
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f391967a = r100;
        }
    }

    public static final class b implements v0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u0 f391968a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f391968a, ((b) r100).f391968a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f391968a.hashCode();
        }

        public final String toString() {
            return "Option(item=" + this.f391968a + ')';
        }

        public b(u0 r100) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            this.f391968a = r100;
        }
    }
}
