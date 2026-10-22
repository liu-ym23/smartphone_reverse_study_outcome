package com.bytedance.ee.lark.infra.foundation.utils;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FileNotFoundException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f242800a = 0;

    static {
    }

    @JvmStatic
    public static final PolarisFileWrapper a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pathname");
        return new PolarisFileWrapper(r100);
    }

    @JvmStatic
    public static final PolarisFileOutputStreamWrapper b(File r100) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(r100, "file");
        Intrinsics.checkNotNullParameter(r100, "file");
        return new PolarisFileOutputStreamWrapper(r100, false);
    }
}
