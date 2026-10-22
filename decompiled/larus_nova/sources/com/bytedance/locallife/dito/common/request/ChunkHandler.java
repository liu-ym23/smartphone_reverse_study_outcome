package com.bytedance.locallife.dito.common.request;

import com.bytedance.retrofit2.mime.TypedInput;
import java.io.InputStream;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes21.dex */
public interface ChunkHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f257654a = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f257655a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy<ChunkHandler> f257656b = null;

        public Companion() {
        }

        static {
            f257655a = new Companion();
            f257656b = LazyKt.lazy(ChunkHandler$Companion$instance$2.INSTANCE);
        }
    }

    static {
        f257654a = Companion.f257655a;
    }

    e a(TypedInput r100);

    DitoChunkData b(int r100, InputStream r101, String r102, Map r103);
}
