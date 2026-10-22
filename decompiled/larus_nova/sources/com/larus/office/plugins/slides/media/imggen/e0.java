package com.larus.office.plugins.slides.media.imggen;

import android.os.Bundle;
import com.larus.office.plugins.slides.media.common.TextRes;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public interface e0 {

    public static final class a implements e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f363360a;

        public a(Bundle r100) {
            Intrinsics.checkNotNullParameter(r100, "bundle");
            this.f363360a = r100;
        }
    }

    public static final class b implements e0 {
    }

    public static final class c implements e0 {
    }

    public static final class d implements e0 {
    }

    public static final class e implements e0 {
    }

    public static final class f implements e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f363361a;

        public f(String r100) {
            this.f363361a = r100;
        }
    }

    public static final class g implements e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextRes f363362a;

        public g(TextRes.PlainText r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            this.f363362a = r100;
        }
    }
}
