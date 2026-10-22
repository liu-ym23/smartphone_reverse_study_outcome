package com.bytedance.ee.bear.share.newshare.extension;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.share.export.f;
import com.bytedance.ee.bear.share.newshare.ShareItemList;
import com.bytedance.ee.bear.share.newshare.d0;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class BaseShareProvider extends d {

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseShareProvider f237212a;

        public b(BaseShareProvider r100) {
            this.f237212a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            f r101 = (f) r100;
            Intrinsics.checkNotNullParameter(r101, "shareInfo");
            BaseShareProvider r102 = this.f237212a;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r101, "shareInfo");
            r102.f237202g = r101;
            ShareItemList r103 = r102.f237198c;
            if (r103 == null) goto L7;
            tt5.a.h("ShareProvider", "invalidate.");
            d0 r104 = r103.a();
            r102.f237199d.setValue(r104);
            return;
        }
    }

    static {
    }

    public BaseShareProvider() {
    }

    public final <S extends f, V extends com.bytedance.ee.bear.share.newshare.extension.a<S>> void k(final V r100) {
        Intrinsics.checkNotNullParameter(r100, "behavior");
        final b r101 = new b(this);
        Function0<Unit> r102 = new BaseShareProvider$bindShareInfo$1(r100, r101);
        Function0<Unit> r103 = new BaseShareProvider$bindShareInfo$2(r100, r101);
        int r104 = this.f237218h;
        if (r104 < 2) goto L6;
        return;
    L6:
        if (r104 < 1) goto L8;
        r102.invoke();
    L9:
        ((ArrayList) this.f237220j).add(r103);
        return;
    L8:
        ((ArrayList) this.f237219i).add(r102);
        goto L9
    }
}
