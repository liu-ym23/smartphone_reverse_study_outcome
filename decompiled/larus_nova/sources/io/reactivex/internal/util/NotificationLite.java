package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.io.Serializable;

/* JADX INFO: loaded from: classes41.dex */
public final enum NotificationLite extends Enum<NotificationLite> {
    public static final NotificationLite COMPLETE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NotificationLite[] f495044a = null;

    public static final class DisposableNotification implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        final Disposable upstream;

        public String toString() {
            return "NotificationLite.Disposable[" + this.upstream + "]";
        }

        public DisposableNotification(Disposable r100) {
            this.upstream = r100;
        }
    }

    public static final class ErrorNotification implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final Throwable f495045e;

        public int hashCode() {
            return this.f495045e.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f495045e + "]";
        }

        public ErrorNotification(Throwable r100) {
            this.f495045e = r100;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof ErrorNotification) == true) goto L5;
            return false;
        L5:
            return ObjectHelper.equals(this.f495045e, ((ErrorNotification) r100).f495045e);
        }
    }

    public static final class SubscriptionNotification implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        final wwc.c upstream;

        public String toString() {
            return "NotificationLite.Subscription[" + this.upstream + "]";
        }

        public SubscriptionNotification(wwc.c r100) {
            this.upstream = r100;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object r100) {
        return r100;
    }

    public static <T> Object next(T r100) {
        return r100;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    static {
        NotificationLite r100 = new NotificationLite();
        COMPLETE = r100;
        f495044a = new NotificationLite[]{r100};
    }

    public NotificationLite() {
        super("COMPLETE", 0);
    }

    public static NotificationLite[] values() {
        return (NotificationLite[]) f495044a.clone();
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(Disposable r100) {
        return new DisposableNotification(r100);
    }

    public static Object error(Throwable r100) {
        return new ErrorNotification(r100);
    }

    public static Disposable getDisposable(Object r100) {
        return ((DisposableNotification) r100).upstream;
    }

    public static Throwable getError(Object r100) {
        return ((ErrorNotification) r100).f495045e;
    }

    public static wwc.c getSubscription(Object r100) {
        return ((SubscriptionNotification) r100).upstream;
    }

    public static boolean isComplete(Object r100) {
        if (r100 != COMPLETE) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isDisposable(Object r100) {
        return r100 instanceof DisposableNotification;
    }

    public static boolean isError(Object r100) {
        return r100 instanceof ErrorNotification;
    }

    public static boolean isSubscription(Object r100) {
        return r100 instanceof SubscriptionNotification;
    }

    public static Object subscription(wwc.c r100) {
        return new SubscriptionNotification(r100);
    }

    public static NotificationLite valueOf(String r100) {
        return (NotificationLite) r27.a.a(NotificationLite.class, r100);
    }

    public static <T> boolean accept(Object r100, Observer<? super T> r101) {
        if (r100 != COMPLETE) goto L7;
        r101.onComplete();
        return true;
    L7:
        if ((r100 instanceof ErrorNotification) == false) goto L10;
        r101.onError(((ErrorNotification) r100).f495045e);
        return true;
    L10:
        r101.onNext(r100);
        return false;
    }

    public static <T> boolean acceptFull(Object r100, Observer<? super T> r101) {
        if (r100 != COMPLETE) goto L7;
        r101.onComplete();
        return true;
    L7:
        if ((r100 instanceof ErrorNotification) == false) goto L11;
        r101.onError(((ErrorNotification) r100).f495045e);
        return true;
    L11:
        if ((r100 instanceof DisposableNotification) == false) goto L14;
        r101.onSubscribe(((DisposableNotification) r100).upstream);
        return false;
    L14:
        r101.onNext(r100);
        return false;
    }

    public static <T> boolean accept(Object r100, wwc.b<? super T> r101) {
        if (r100 != COMPLETE) goto L7;
        r101.onComplete();
        return true;
    L7:
        if ((r100 instanceof ErrorNotification) == false) goto L10;
        r101.onError(((ErrorNotification) r100).f495045e);
        return true;
    L10:
        r101.onNext(r100);
        return false;
    }

    public static <T> boolean acceptFull(Object r100, wwc.b<? super T> r101) {
        if (r100 != COMPLETE) goto L7;
        r101.onComplete();
        return true;
    L7:
        if ((r100 instanceof ErrorNotification) == false) goto L11;
        r101.onError(((ErrorNotification) r100).f495045e);
        return true;
    L11:
        if ((r100 instanceof SubscriptionNotification) == false) goto L14;
        r101.onSubscribe(((SubscriptionNotification) r100).upstream);
        return false;
    L14:
        r101.onNext(r100);
        return false;
    }
}
