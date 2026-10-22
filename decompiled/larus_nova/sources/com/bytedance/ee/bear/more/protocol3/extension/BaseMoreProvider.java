package com.bytedance.ee.bear.more.protocol3.extension;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class BaseMoreProvider extends v {

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseMoreProvider f234815a;

        public b(BaseMoreProvider r100) {
            this.f234815a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            oj5.c r101 = (oj5.c) r100;
            Intrinsics.checkNotNullParameter(r101, "moreInfo");
            BaseMoreProvider r102 = this.f234815a;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r101, "moreInfo");
            r102.f234889d = r101;
            r102.g();
        }
    }

    static {
    }

    public BaseMoreProvider() {
    }

    public final <S extends oj5.c, V extends u<S>> void k(final V r100) {
        Intrinsics.checkNotNullParameter(r100, "behavior");
        final b r101 = new b(this);
        j(new BaseMoreProvider$bindMoreInfo$1(r100, r101), new BaseMoreProvider$bindMoreInfo$2(r100, r101));
    }

    public final void l(final oj5.f r100) {
        Intrinsics.checkNotNullParameter(r100, "moreInfo");
        j(new BaseMoreProvider$bindMoreInfo$3(this, r100), null);
    }
}
