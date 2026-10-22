package com.larus.folder;

import com.larus.im.callback.IIMError;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public abstract class m {

    public static final class a extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IIMError f343638a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f343638a, ((a) r100).f343638a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f343638a.hashCode();
        }

        public final String toString() {
            return "Failure(error=" + this.f343638a + ')';
        }

        public a(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f343638a = r100;
        }
    }

    public static final class b extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f343639a = null;

        static {
            f343639a = new b();
        }

        public b() {
        }
    }

    public static final class c extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<j> f343640a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f343640a, ((c) r100).f343640a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f343640a.hashCode();
        }

        public final String toString() {
            return "Success(items=" + this.f343640a + ')';
        }

        public c(List<j> r100) {
            Intrinsics.checkNotNullParameter(r100, "items");
            this.f343640a = r100;
        }
    }

    public m() {
    }
}
