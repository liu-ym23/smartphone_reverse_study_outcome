package com.larus.avlink.e.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Integer> f291817a;

    public static final class a {
    }

    static {
    }

    public i(c r100) {
        Intrinsics.checkNotNullParameter(r100, "fileManager");
        this.f291817a = new ArrayList();
        new AtomicInteger(0);
        new AtomicBoolean(false);
    }
}
