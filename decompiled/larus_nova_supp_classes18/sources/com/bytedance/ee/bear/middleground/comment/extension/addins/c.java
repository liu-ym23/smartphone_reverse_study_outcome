package com.bytedance.ee.bear.middleground.comment.extension.addins;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.ee.bear.middleground.comment.card.p1;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends com.bytedance.ee.bear.middleground.comment.extension.addins.b {

    public final class a extends ff5.a<ef5.h> {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r6) {
            ef5.h r7 = (ef5.h) r6;
            Intrinsics.checkNotNullParameter(r7, "event");
            p1 r0 = this.a.getContext().c();
            if (r0 != null) goto L5;
        L7:
            boolean r2 = false;
        L8:
            if (r2 == true) goto L10;
            return;
        L10:
            if ((r0 instanceof com.bytedance.ee.bear.middleground.comment.bitablediscuss.i) == false) goto L21;
            int r3 = r7.c;
            String r4 = null;
            if (r3 != 1) goto L14;
            String r1 = r7.f;
        L16:
            if (r3 != 2) goto L18;
            r4 = r7.g;
        L18:
            ((com.bytedance.ee.bear.middleground.comment.bitablediscuss.i) r0).mq(r1, r4);
            return;
        L14:
            r1 = null;
            goto L16
        L21:
            return;
        L5:
            if (r0.isShowing() != true) goto L7;
            r2 = true;
            goto L8
        }
    }

    public final class b extends ff5.a<ef5.q> {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r4) {
            Intrinsics.checkNotNullParameter((ef5.q) r4, "event");
            p1 r5 = this.a.getContext().c();
            if (r5 == null) goto L7;
            boolean r2 = true;
            if (r5.isShowing() != true) goto L7;
        L8:
            if (r2 == true) goto L10;
            return;
        L10:
            if ((r5 instanceof com.bytedance.ee.bear.middleground.comment.bitablediscuss.i) == false) goto L14;
            com.bytedance.ee.bear.middleground.comment.bitablediscuss.i r6 = (com.bytedance.ee.bear.middleground.comment.bitablediscuss.i) r5;
            r6.zT(0);
            r6.H50(null, null, 0);
            return;
        L14:
            return;
        L7:
            r2 = false;
            goto L8
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.extension.addins.c$c, reason: collision with other inner class name */
    public final class C0065c extends ff5.a<ef5.r> {
        public final /* synthetic */ c a;

        public C0065c(c r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r5) {
            ef5.r r6 = (ef5.r) r5;
            Intrinsics.checkNotNullParameter(r6, "event");
            p1 r0 = this.a.getContext().c();
            int r1 = r6.a.t();
            if (r0 == null) goto L7;
            boolean r3 = true;
            if (r0.isShowing() != true) goto L7;
        L8:
            if (r3 == true) goto L10;
            return;
        L10:
            if ((r0 instanceof com.bytedance.ee.bear.middleground.comment.bitablediscuss.i) == true) goto L12;
            return;
        L12:
            if (r6.a.isShowing() == false) goto L17;
            ((com.bytedance.ee.bear.middleground.comment.bitablediscuss.i) r0).zT(this.a.getContext().getConfig().r.keyBoardRawHeight() + r1);
            return;
        L17:
            return;
        L7:
            r3 = false;
            goto L8
        }
    }

    public final class d extends ff5.a<ef5.t> {
        public final /* synthetic */ c a;

        public d(c r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r6) {
            ef5.t r7 = (ef5.t) r6;
            Intrinsics.checkNotNullParameter(r7, "event");
            p1 r0 = this.a.getContext().c();
            CommentInputRequest r1 = r7.a.i();
            int r8 = r7.a.t();
            if (r0 != null) goto L5;
        L7:
            boolean r3 = false;
        L8:
            if (r3 == true) goto L10;
            return;
        L10:
            if ((r0 instanceof com.bytedance.ee.bear.middleground.comment.bitablediscuss.i) == false) goto L20;
            ((com.bytedance.ee.bear.middleground.comment.bitablediscuss.i) r0).zT(this.a.getContext().getConfig().r.keyBoardRawHeight() + r8);
            int r9 = r1.type;
            if (r9 == 2) goto L14;
            if (r9 == 1) goto L14;
            return;
        L14:
            if (r9 != 1) goto L16;
            String r10 = r1.reply_id;
        L17:
            new Handler(Looper.getMainLooper()).postDelayed(new com.bytedance.ee.bear.middleground.comment.extension.addins.d(r0, r1, r10), 100);
            return;
        L16:
            r10 = r1.directional_reply_id;
            goto L17
        L20:
            return;
        L5:
            if (r0.isShowing() != true) goto L7;
            r3 = true;
            goto L8
        }
    }

    public c() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void a(cf5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r3, "host");
        this.a = r3;
        r3.b(ef5.h.class, new a(this));
        r3.b(ef5.t.class, new d(this));
        r3.b(ef5.q.class, new b(this));
        r3.b(ef5.r.class, new C0065c(this));
    }
}
