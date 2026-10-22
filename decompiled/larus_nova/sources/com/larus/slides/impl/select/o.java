package com.larus.slides.impl.select;

import android.os.Bundle;
import com.larus.slides.impl.select.common.TextRes;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public interface o {

    public static final class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f369654a;

        public a(Bundle r100) {
            Intrinsics.checkNotNullParameter(r100, "bundle");
            this.f369654a = r100;
        }
    }

    public static final class b implements o {
    }

    public static final class c implements o {
    }

    public static final class d implements o {
    }

    public static final class e implements o {
    }

    public static final class f implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f369655a;

        public f(String r100) {
            this.f369655a = r100;
        }
    }

    public static final class g implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextRes f369656a;

        public g(TextRes.PlainText r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            this.f369656a = r100;
        }
    }
}
