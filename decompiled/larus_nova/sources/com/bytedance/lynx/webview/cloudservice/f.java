package com.bytedance.lynx.webview.cloudservice;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import l17.l;

/* JADX INFO: loaded from: classes21.dex */
public final class f implements o07.a {

    public class a implements o17.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f265094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o07.d f265095b;

        @Override // o17.f.a
        public final void a(o17.f r100) {
            c(r100);
            this.f265094a.countDown();
        }

        @Override // o17.f.a
        public final void b(o17.f r100) {
            c(r100);
            this.f265094a.countDown();
        }

        public final void c(o17.f r100) {
            o07.d r101 = this.f265095b;
            r101.f521639a = CastIntegerProtector.parseInt(r100.f521719a);
            o07.d r102 = this.f265095b;
            r102.f521642d = r100.f521723e;
            r102.f521641c = r100.f521722d;
            r102.f521640b = r100.f521720b;
        }

        public a(CountDownLatch r100, o07.d r101) {
            this.f265094a = r100;
            this.f265095b = r101;
        }
    }

    public f() {
    }

    @Override // o07.a
    public final o07.d a(o07.c r100, boolean r101) {
        CountDownLatch r102 = new CountDownLatch(1);
        o17.e r103 = new o17.e(r100.f521635b);
        r103.f521716c = r100.f521636c;
        r103.f521717d = r100.f521637d;
        r103.f521714a = r100.f521634a;
        r103.f521718e = r100.f521638e;
        o17.c r104 = new o17.c();
        o07.d r105 = new o07.d();
        r104.f521712a = new a(r102, r105);
        ((o17.b) l.a()).d(r103, r104);
        r102.await(r100.f521638e, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L5
    L4:
        return r105;
    }
}
