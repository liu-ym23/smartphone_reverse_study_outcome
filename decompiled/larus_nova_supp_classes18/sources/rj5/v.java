package rj5;

import android.os.Bundle;
import android.view.View;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v extends com.bytedance.ee.bear.more.protocol3.g {
    public final com.bytedance.ee.bear.more.a c;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ v a;

        public b(v r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r19) {
            v r1 = this.a;
            r1.getHost().a();
            r1.c.b();
            oj5.c r2 = r1.c();
            if (r2 == null) goto L6;
            ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).c(new com.bytedance.ee.bear.more.i(new Bundle(), r2.getToken(), r2.getType(), r2.isShareFolder(), r2.b(), "My_AI", "none", "", "", r2 instanceof oj5.f, r2.m(), r2.H(), r2.isOwner(), r2.L()));
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final com.bytedance.ee.bear.more.protocol3.k a() {
        return com.bytedance.ee.bear.more.protocol3.g.i(this, new com.bytedance.ee.bear.more.protocol3.f.x(new com.bytedance.ee.bear.more.protocol3.d(2131889572, 2131255192, 2131103546, e(2131889042))), new com.bytedance.ee.bear.more.protocol3.e.f(false, false, false), CollectionsKt.listOf(new w(this)), null, new b(this), 8);
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g, com.bytedance.ee.bear.more.protocol3.b, com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem, com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public final void create() {
        oj5.c r0 = c();
        if (r0 == null) goto L6;
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).K(new com.bytedance.ee.bear.more.j(r0.getToken(), r0.getType(), r0.b(), r0 instanceof oj5.f, r0.m(), r0.isOwner(), r0.L()));
        return;
    }

    public v(com.bytedance.ee.bear.more.a r2) {
        Intrinsics.checkNotNullParameter(r2, "aiItemAbility");
        this.c = r2;
    }
}
