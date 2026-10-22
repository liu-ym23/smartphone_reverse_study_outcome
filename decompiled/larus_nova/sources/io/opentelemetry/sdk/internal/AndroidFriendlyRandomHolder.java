package io.opentelemetry.sdk.internal;

import java.util.Random;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes41.dex */
final enum AndroidFriendlyRandomHolder extends Enum<AndroidFriendlyRandomHolder> implements Supplier<Random> {
    public static final AndroidFriendlyRandomHolder INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Random f492705a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AndroidFriendlyRandomHolder[] f492706b = null;

    static {
        AndroidFriendlyRandomHolder r100 = new AndroidFriendlyRandomHolder();
        INSTANCE = r100;
        f492706b = new AndroidFriendlyRandomHolder[]{r100};
        f492705a = new Random();
    }

    public AndroidFriendlyRandomHolder() {
        super("INSTANCE", 0);
    }

    public static AndroidFriendlyRandomHolder[] values() {
        return (AndroidFriendlyRandomHolder[]) f492706b.clone();
    }

    @Override // java.util.function.Supplier
    public /* bridge */ /* synthetic */ Random get() {
        return get2();
    }

    @Override // java.util.function.Supplier
    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public Random get2() {
        return f492705a;
    }

    public static AndroidFriendlyRandomHolder valueOf(String r100) {
        return (AndroidFriendlyRandomHolder) r27.a.a(AndroidFriendlyRandomHolder.class, r100);
    }
}
