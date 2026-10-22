package rub;

import android.content.Context;
import android.graphics.drawable.Drawable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class c {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<Context, Drawable> f539314a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Context, ? extends Drawable> r100) {
            Intrinsics.checkNotNullParameter(r100, "drawableProvider");
            this.f539314a = r100;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f539315a = null;

        static {
            f539315a = new b();
        }

        public b() {
        }
    }

    /* JADX INFO: renamed from: rub.c$c, reason: collision with other inner class name */
    public static final class C7538c extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C7538c f539316a = null;

        static {
            f539316a = new C7538c();
        }

        public C7538c() {
        }
    }

    public c() {
    }
}
