package com.larus.dora.impl.feedback;

import com.larus.platform.model.upload.ResourceUploadError;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class f implements Function1<ResourceUploadError, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f335615a = null;

    static {
        f335615a = new f();
    }

    public f() {
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ResourceUploadError r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return Unit.INSTANCE;
    }
}
