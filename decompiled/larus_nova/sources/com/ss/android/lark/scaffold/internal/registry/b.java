package com.ss.android.lark.scaffold.internal.registry;

import androidx.lifecycle.LifecycleOwner;
import com.ss.android.lark.scaffold.PagePlugin;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import l3c.f;
import l3c.h;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleOwner f439769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<f> f439770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<a> f439771c;

    public interface a {

        /* JADX INFO: renamed from: com.ss.android.lark.scaffold.internal.registry.b$a$a, reason: collision with other inner class name */
        public static final class C5279a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Function1<h, List<PagePlugin>> f439772a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C5279a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f439772a, ((C5279a) r100).f439772a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f439772a.hashCode();
            }

            public final String toString() {
                return "Multiple(block=" + this.f439772a + ')';
            }

            /* JADX WARN: Multi-variable type inference failed */
            public C5279a(Function1<? super h, ? extends List<? extends PagePlugin>> r100) {
                Intrinsics.checkNotNullParameter(r100, "block");
                this.f439772a = r100;
            }

            @Override // com.ss.android.lark.scaffold.internal.registry.b.a
            public final List a(b r100) {
                Intrinsics.checkNotNullParameter(r100, "scope");
                return this.f439772a.invoke(r100);
            }
        }

        List a(b r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(LifecycleOwner r100, Function0<? extends f> r101) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "runtimeProvider");
        this.f439769a = r100;
        this.f439770b = r101;
        this.f439771c = new ArrayList();
    }
}
