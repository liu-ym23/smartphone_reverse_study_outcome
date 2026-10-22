package com.larus.dora.impl.device.settings.gesture;

import com.larus.dora.impl.model.GestureSettingsKey;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface c0 {

    public static final class a implements c0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f334429a = null;

        static {
            f334429a = new a();
        }

        public a() {
        }
    }

    public static final class b implements c0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f334430a = null;

        static {
            f334430a = new b();
        }

        public b() {
        }
    }

    public static final class c implements c0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<GestureSettingsKey, Byte> f334431a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f334431a, ((c) r100).f334431a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f334431a.hashCode();
        }

        public final String toString() {
            return "Success(map=" + this.f334431a + ')';
        }

        public c(Map<GestureSettingsKey, Byte> r100) {
            Intrinsics.checkNotNullParameter(r100, "map");
            this.f334431a = r100;
        }
    }
}
