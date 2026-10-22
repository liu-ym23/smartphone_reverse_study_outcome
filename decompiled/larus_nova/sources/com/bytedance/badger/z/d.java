package com.bytedance.badger.z;

import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class d extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f199456a = null;

    static {
        f199456a = new d();
    }

    public d() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object r100) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(((Number) r100).byteValue())}, 1));
    }
}
