package io.reactivex.internal.subscriptions;

import r27.a;
import vtc.g;
import wwc.b;

/* JADX INFO: loaded from: classes41.dex */
public final enum EmptySubscription extends Enum<EmptySubscription> implements g<Object> {
    public static final EmptySubscription INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EmptySubscription[] f495036a = null;

    @Override // wwc.c
    public void cancel() {
    }

    @Override // vtc.j
    public void clear() {
    }

    @Override // vtc.j
    public boolean isEmpty() {
        return true;
    }

    @Override // vtc.j
    public Object poll() {
        return null;
    }

    @Override // vtc.f
    public int requestFusion(int r100) {
        return r100 & 2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }

    static {
        EmptySubscription r100 = new EmptySubscription();
        INSTANCE = r100;
        f495036a = new EmptySubscription[]{r100};
    }

    public EmptySubscription() {
        super("INSTANCE", 0);
    }

    public static EmptySubscription[] values() {
        return (EmptySubscription[]) f495036a.clone();
    }

    public static void complete(b<?> r100) {
        r100.onSubscribe(INSTANCE);
        r100.onComplete();
    }

    public static EmptySubscription valueOf(String r100) {
        return (EmptySubscription) a.a(EmptySubscription.class, r100);
    }

    @Override // vtc.j
    public boolean offer(Object r100) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // wwc.c
    public void request(long r100) {
        SubscriptionHelper.validate(r100);
    }

    public static void error(Throwable r100, b<?> r101) {
        r101.onSubscribe(INSTANCE);
        r101.onError(r100);
    }

    public boolean offer(Object r100, Object r101) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
