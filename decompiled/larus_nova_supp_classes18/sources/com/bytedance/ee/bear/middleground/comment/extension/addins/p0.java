package com.bytedance.ee.bear.middleground.comment.extension.addins;

import android.text.TextUtils;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p0 extends com.bytedance.ee.bear.middleground.comment.extension.addins.b {
    public final CompositeDisposable b;
    public boolean c;
    public boolean d;

    public final class a extends ff5.a<ef5.h> {
        public final /* synthetic */ p0 a;

        public a(p0 r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r2) {
            Intrinsics.checkNotNullParameter((ef5.h) r2, "event");
            this.a.d = true;
        }
    }

    public static final class b {
    }

    public final class c extends ff5.a<ef5.q> {
        public final /* synthetic */ p0 a;

        public c(p0 r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r2) {
            Intrinsics.checkNotNullParameter((ef5.q) r2, "event");
            this.a.c = false;
        }
    }

    public final class d extends ff5.a<ef5.u> {
        public final /* synthetic */ p0 a;

        public d(p0 r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r5) {
            ef5.u r6 = (ef5.u) r5;
            Intrinsics.checkNotNullParameter(r6, "event");
            p0 r0 = this.a;
            if (r0.c == true) goto L5;
        L14:
            r0.c = true;
            r0.d = false;
            return;
        L5:
            if (r0.d == true) goto L14;
            if (TextUtils.isEmpty(r6.a) == false) goto L16;
            tt5.a.h("SmartReplayAddin", "smart reply data is empty");
            Disposable r1 = null;
            r6.b.n(null);
            com.bytedance.ee.bear.rn.a r3 = new com.bytedance.ee.bear.rn.a(r6.b.i().comment_id, com.larksuite.framework.utils.l0.a().toString(), r6.b.i().smartReplyDataForInsert);
            this.a.getContext().a();
            Flowable<String> r7 = com.bytedance.ee.bear.middleground.comment.uitls.o.a(this.a.getContext().b().D(r3), null);
            if (r7 == null) goto L12;
            r1 = r7.subscribe();
        L12:
            if (r1 == null) goto L17;
            this.a.b.add(r1);
            return;
        L17:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void onDestroy() {
        this.b.clear();
    }

    public p0() {
        this.b = new CompositeDisposable();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void a(cf5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r3, "host");
        this.a = r3;
        r3.b(ef5.u.class, new d(this));
        r3.b(ef5.q.class, new c(this));
        r3.b(ef5.h.class, new a(this));
    }
}
