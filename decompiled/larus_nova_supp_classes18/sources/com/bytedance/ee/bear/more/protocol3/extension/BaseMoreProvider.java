package com.bytedance.ee.bear.more.protocol3.extension;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class BaseMoreProvider extends v {

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ BaseMoreProvider a;

        public b(BaseMoreProvider r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            oj5.c r4 = (oj5.c) r3;
            Intrinsics.checkNotNullParameter(r4, "moreInfo");
            BaseMoreProvider r1 = this.a;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r4, "moreInfo");
            r1.d = r4;
            r1.g();
        }
    }

    static {
    }

    public BaseMoreProvider() {
    }

    public final <S extends oj5.c, V extends u<S>> void k(final V r4) {
        Intrinsics.checkNotNullParameter(r4, "behavior");
        final b r0 = new b(this);
        j(new BaseMoreProvider$bindMoreInfo$1(r4, r0), new BaseMoreProvider$bindMoreInfo$2(r4, r0));
    }

    public final void l(final oj5.f r2) {
        Intrinsics.checkNotNullParameter(r2, "moreInfo");
        j(new BaseMoreProvider$bindMoreInfo$3(this, r2), null);
    }
}
