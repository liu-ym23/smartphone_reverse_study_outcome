package com.bytedance.ee.bear.middleground.comment;

import com.bytedance.ee.bear.middleground.comment.card.p1;
import com.bytedance.ee.bear.middleground.comment.control.t;
import com.bytedance.ee.bear.middleground.comment.control.y;
import com.bytedance.ee.bear.middleground.comment.control.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements gf5.a {
    public final /* synthetic */ Comment a;

    @Override // gf5.a
    public final y a() {
        return this.a.y;
    }

    @Override // gf5.a
    public final t b() {
        return this.a.w;
    }

    @Override // gf5.a
    public final p1 c() {
        return this.a.o;
    }

    @Override // gf5.a
    public final kf5.b d() {
        return this.a.p;
    }

    @Override // gf5.a
    public final z e() {
        return this.a.x;
    }

    @Override // gf5.a
    public final com.bytedance.ee.bear.middleground.comment.uitls.p getConfig() {
        return this.a.r;
    }

    @Override // gf5.a
    public final com.bytedance.ee.bear.middleground.comment.card.d z7() {
        p1 r0 = this.a.o;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.z7();
    }

    public a(Comment r1) {
        this.a = r1;
    }
}
