package sg2;

import android.content.Context;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public interface x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f541829a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C7607a f541830a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f541831b = null;

        /* JADX INFO: renamed from: sg2.x$a$a, reason: collision with other inner class name */
        public static final class C7607a implements x {
            public C7607a() {
            }

            @Override // sg2.x
            public final void a() {
            }

            @Override // sg2.x
            public final void b(Context r100, Function2 r101) {
                Intrinsics.checkNotNullParameter(r101, "callback");
                Boolean r102 = Boolean.FALSE;
                r101.invoke(r102, r102);
            }
        }

        public a() {
        }

        static {
            f541831b = new a();
            f541830a = new C7607a();
        }
    }

    static {
        f541829a = a.f541831b;
    }

    void a();

    void b(Context r100, Function2 r101);
}
