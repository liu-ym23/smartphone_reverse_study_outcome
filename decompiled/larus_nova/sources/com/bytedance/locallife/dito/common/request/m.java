package com.bytedance.locallife.dito.common.request;

import com.bytedance.retrofit2.mime.TypedInput;
import java.io.InputStream;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class m implements ChunkHandler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f257683b = null;

    static {
        f257683b = new m();
    }

    public m() {
    }

    @Override // com.bytedance.locallife.dito.common.request.ChunkHandler
    public final e a(TypedInput r100) {
        return new e(r100);
    }

    @Override // com.bytedance.locallife.dito.common.request.ChunkHandler
    public final DitoChunkData b(int r100, InputStream r101, String r102, Map r103) {
        Intrinsics.checkNotNullParameter(r101, "originStream");
        Intrinsics.checkNotNullParameter(r103, "extraMap");
        return new DitoChunkData(r100, r101, r102, r103);
    }
}
