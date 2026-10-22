package org.bouncycastle.crypto.prng;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes42.dex */
public class ThreadedSeedGenerator {

    /* JADX INFO: renamed from: org.bouncycastle.crypto.prng.ThreadedSeedGenerator$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class SeedGenerator implements Runnable {
        private volatile int counter;
        private volatile boolean stop;
        final /* synthetic */ ThreadedSeedGenerator this$0;

        private SeedGenerator(ThreadedSeedGenerator r100) {
            this.this$0 = r100;
            this.counter = 0;
            this.stop = false;
        }

        public /* synthetic */ SeedGenerator(ThreadedSeedGenerator r100, AnonymousClass1 r101) {
            this(r100);
        }

        public byte[] generateSeed(int r100, boolean r101) {
            PthreadThreadV2 r102 = new PthreadThreadV2(this, "ThreadedSeedGenerator$SeedGenerator");
            byte[] r103 = new byte[r100];
            int r104 = 0;
            this.counter = 0;
            this.stop = false;
            ThreadMethodProxy.start(r102);
            if (r101 == true) goto L6;
            r100 = r100 * 8;
        L6:
            int r105 = 0;
        L8:
            if (r104 >= r100) goto L20;
        L10:
            if (this.counter != r105) goto L15;
            Thread.sleep(1);     // Catch: InterruptedException -> L14
            goto L10
        L15:
            r105 = this.counter;
            if (r101 == false) goto L18;
            r103[r104] = (byte) (r105 & 255);
        L19:
            r104 = r104 + 1;
            goto L8
        L18:
            int r106 = r104 / 8;
            r103[r106] = (byte) ((r103[r106] << 1) | (r105 & 1));
            goto L19
        L20:
            this.stop = true;
            return r103;
        }

        public void org_bouncycastle_crypto_prng_ThreadedSeedGenerator$SeedGenerator__run$___twin___() {
        L3:
            if (this.stop == true) goto L5;
            this.counter++;
            goto L3
        }

        @Override // java.lang.Runnable
        public void run() {
            org_bouncycastle_crypto_prng_ThreadedSeedGenerator$SeedGenerator_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void org_bouncycastle_crypto_prng_ThreadedSeedGenerator$SeedGenerator_com_larus_apm_impl_protector_RunnableLancet_run(SeedGenerator r100) {
            r100.org_bouncycastle_crypto_prng_ThreadedSeedGenerator$SeedGenerator__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ThreadedSeedGenerator() {
    }

    public byte[] generateSeed(int r100, boolean r101) {
        return new SeedGenerator(this, null).generateSeed(r100, r101);
    }
}
