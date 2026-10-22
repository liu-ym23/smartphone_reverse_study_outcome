package com.bytedance.ee.bear.document.render.node;

import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public interface q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f221388a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f221389a = null;

        static {
            f221389a = new a();
        }

        public a() {
        }
    }

    public static final class b implements q {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f221390b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Throwable f221391c;

        public final String toString() {
            return "Error(" + this.f221390b + ", " + this.f221391c + ')';
        }

        public b(int r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            this.f221390b = r100;
            this.f221391c = r101;
        }
    }

    public static final class c implements q {
        public c() {
        }

        public final String toString() {
            return "Success";
        }
    }

    static {
        f221388a = a.f221389a;
    }
}
