package io.reactivex.internal.subscriptions;

import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.b;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import r27.a;
import wwc.c;

/* JADX INFO: loaded from: classes41.dex */
public final enum SubscriptionHelper extends Enum<SubscriptionHelper> implements c {
    public static final SubscriptionHelper CANCELLED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SubscriptionHelper[] f495037a = null;

    @Override // wwc.c
    public void cancel() {
    }

    @Override // wwc.c
    public void request(long r100) {
    }

    static {
        SubscriptionHelper r100 = new SubscriptionHelper();
        CANCELLED = r100;
        f495037a = new SubscriptionHelper[]{r100};
    }

    public SubscriptionHelper() {
        super("CANCELLED", 0);
    }

    public static void reportSubscriptionSet() {
        RxJavaPlugins.onError(new ProtocolViolationException("Subscription already set!"));
    }

    public static SubscriptionHelper[] values() {
        return (SubscriptionHelper[]) f495037a.clone();
    }

    public static boolean cancel(AtomicReference<c> r100) {
        c r101 = r100.get();
        SubscriptionHelper r102 = CANCELLED;
        if (r101 == r102) goto L10;
        c r103 = r100.getAndSet(r102);
        if (r103 == r102) goto L13;
        if (r103 == null) goto L12;
        r103.cancel();
        return true;
    L12:
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public static void reportMoreProduced(long r100) {
        RxJavaPlugins.onError(new ProtocolViolationException("More produced than requested: " + r100));
    }

    public static boolean validate(long r100) {
        if (r100 > 0) goto L6;
        RxJavaPlugins.onError(new IllegalArgumentException("n > 0 required but it was " + r100));
        return false;
    L6:
        return true;
    }

    public static SubscriptionHelper valueOf(String r100) {
        return (SubscriptionHelper) a.a(SubscriptionHelper.class, r100);
    }

    public static boolean replace(AtomicReference<c> r100, c r101) {
    L2:
        c r102 = r100.get();
        boolean r103 = false;
        if (r102 == CANCELLED) goto L4;
    L8:
        if (r100.compareAndSet(r102, r101) == true) goto L9;
        if (r100.get() == r102) goto L8;
    L12:
        if (r103 == false) goto L2;
        return true;
    L9:
        r103 = true;
        goto L12
    L4:
        if (r101 == null) goto L6;
        r101.cancel();
    L6:
        return false;
    }

    public static boolean set(AtomicReference<c> r100, c r101) {
    L2:
        c r102 = r100.get();
        boolean r103 = false;
        if (r102 == CANCELLED) goto L4;
    L8:
        if (r100.compareAndSet(r102, r101) == true) goto L9;
        if (r100.get() == r102) goto L8;
    L12:
        if (r103 == false) goto L2;
        if (r102 == null) goto L15;
        r102.cancel();
    L15:
        return true;
    L9:
        r103 = true;
        goto L12
    L4:
        if (r101 == null) goto L6;
        r101.cancel();
    L6:
        return false;
    }

    public static boolean setOnce(AtomicReference<c> r100, c r101) {
        ObjectHelper.requireNonNull(r101, "s is null");
    L4:
        if (r100.compareAndSet(null, r101) == true) goto L5;
        if (r100.get() == null) goto L4;
        boolean r102 = false;
    L9:
        if (r102 == true) goto L14;
        r101.cancel();
        if (r100.get() == CANCELLED) goto L13;
        reportSubscriptionSet();
    L13:
        return false;
    L14:
        return true;
    L5:
        r102 = true;
        goto L9
    }

    public static boolean validate(c r100, c r101) {
        if (r101 != null) goto L6;
        RxJavaPlugins.onError(new NullPointerException("next is null"));
        return false;
    L6:
        if (r100 == null) goto L9;
        r101.cancel();
        reportSubscriptionSet();
        return false;
    L9:
        return true;
    }

    public static void deferredRequest(AtomicReference<c> r100, AtomicLong r101, long r102) {
        c r103 = r100.get();
        if (r103 == null) goto L6;
        r103.request(r102);
        return;
    L6:
        if (validate(r102) == false) goto L14;
        b.a(r101, r102);
        c r104 = r100.get();
        if (r104 == null) goto L15;
        long r105 = r101.getAndSet(0);
        if (r105 == 0) goto L16;
        r104.request(r105);
        return;
    L16:
        return;
    L15:
        return;
    }

    public static boolean deferredSetOnce(AtomicReference<c> r100, AtomicLong r101, c r102) {
        if (setOnce(r100, r102) == false) goto L9;
        long r103 = r101.getAndSet(0);
        if (r103 == 0) goto L11;
        r102.request(r103);
        return true;
    L11:
        return true;
    L9:
        return false;
    }

    public static boolean setOnce(AtomicReference<c> r100, c r101, long r102) {
        if (setOnce(r100, r101) == false) goto L6;
        r101.request(r102);
        return true;
    L6:
        return false;
    }
}
