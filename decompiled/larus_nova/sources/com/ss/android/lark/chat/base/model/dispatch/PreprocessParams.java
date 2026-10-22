package com.ss.android.lark.chat.base.model.dispatch;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class PreprocessParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResourceType f411719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f411720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f411721c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ResourceType f411722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f411723b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f411724c;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.base.model.dispatch.PreprocessParams$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C4790a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f411725a = null;

            static {
                int[] r100 = new int[ResourceType.values().length];
                r100[ResourceType.FILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                f411725a = r100;
            }
        }

        public a() {
            f r100 = f.f411770f;
        }
    }

    public static final class b {
    }

    static {
    }

    public abstract boolean a();

    public abstract String b();

    public final ResourceType getType() {
        return this.f411719a;
    }

    public PreprocessParams(ResourceType r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "preUploadParams");
        this.f411719a = r100;
        this.f411720b = r101;
        this.f411721c = LazyKt.lazy(new PreprocessParams$hashedPath$2(this));
    }
}
