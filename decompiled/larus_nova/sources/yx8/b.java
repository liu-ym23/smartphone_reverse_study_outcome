package yx8;

import com.larus.camera.impl.ui.component.result.general.ResultConfirmControlStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f569429a = null;

        static {
            f569429a = new a();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: yx8.b$b, reason: collision with other inner class name */
    public static final class C8399b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C8399b f569430a = null;

        static {
            f569430a = new C8399b();
        }

        public C8399b() {
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ResultConfirmControlStyle f569431a;

        public c() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f569431a == ((c) r100).f569431a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f569431a.hashCode();
        }

        public final String toString() {
            return "ResultTab(confirmControlStyle=" + this.f569431a + ')';
        }

        public c(ResultConfirmControlStyle r100) {
            Intrinsics.checkNotNullParameter(r100, "confirmControlStyle");
            this.f569431a = r100;
        }

        public /* synthetic */ c(int r100) {
            this(ResultConfirmControlStyle.GENERAL);
        }
    }

    public b() {
    }
}
