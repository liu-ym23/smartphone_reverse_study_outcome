package io.reactivex.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.VolatileSizeArrayList;
import io.reactivex.observers.BaseTestConsumer;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes41.dex */
public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> implements Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CountDownLatch f495053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VolatileSizeArrayList f495054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VolatileSizeArrayList f495055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f495056d;

    public static abstract enum TestWaitStrategy extends Enum<TestWaitStrategy> implements Runnable {
        public static final TestWaitStrategy SLEEP_1000MS = null;
        public static final TestWaitStrategy SLEEP_100MS = null;
        public static final TestWaitStrategy SLEEP_10MS = null;
        public static final TestWaitStrategy SLEEP_1MS = null;
        public static final TestWaitStrategy SPIN = null;
        public static final TestWaitStrategy YIELD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TestWaitStrategy[] f495057a = null;

        public TestWaitStrategy() {
            throw null;
        }

        @Override // java.lang.Runnable
        public abstract void run();

        static {
            final String r100 = "SPIN";
            final int r101 = 0;
            TestWaitStrategy r102 = new AnonymousClass1(r100, r101);
            SPIN = r102;
            final String r103 = "YIELD";
            final int r104 = 1;
            TestWaitStrategy r105 = new AnonymousClass2(r103, r104);
            YIELD = r105;
            final String r106 = "SLEEP_1MS";
            final int r107 = 2;
            TestWaitStrategy r108 = new AnonymousClass3(r106, r107);
            SLEEP_1MS = r108;
            final String r109 = "SLEEP_10MS";
            final int r110 = 3;
            TestWaitStrategy r111 = new AnonymousClass4(r109, r110);
            SLEEP_10MS = r111;
            final String r112 = "SLEEP_100MS";
            final int r113 = 4;
            TestWaitStrategy r114 = new AnonymousClass5(r112, r113);
            SLEEP_100MS = r114;
            final String r115 = "SLEEP_1000MS";
            final int r116 = 5;
            TestWaitStrategy r117 = new AnonymousClass6(r115, r116);
            SLEEP_1000MS = r117;
            f495057a = new TestWaitStrategy[]{r102, r105, r108, r111, r114, r117};
        }

        public static TestWaitStrategy[] values() {
            return (TestWaitStrategy[]) f495057a.clone();
        }

        public static void sleep(int r100) {
            Thread.sleep(r100);     // Catch: InterruptedException -> L5
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        public static TestWaitStrategy valueOf(String r100) {
            return (TestWaitStrategy) r27.a.a(TestWaitStrategy.class, r100);
        }

        public TestWaitStrategy(String r100, int r101, a r102) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {
    }

    public BaseTestConsumer() {
        this.f495054b = new VolatileSizeArrayList();
        this.f495055c = new VolatileSizeArrayList();
        this.f495053a = new CountDownLatch(1);
    }
}
