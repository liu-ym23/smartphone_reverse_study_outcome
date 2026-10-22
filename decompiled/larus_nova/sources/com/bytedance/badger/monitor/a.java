package com.bytedance.badger.monitor;

import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
final class a extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f199040a = null;

    static {
        f199040a = new a();
    }

    public a() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return ThreadLocalRandom.current();
    }
}
