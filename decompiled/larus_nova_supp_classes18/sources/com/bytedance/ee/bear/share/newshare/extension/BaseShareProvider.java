package com.bytedance.ee.bear.share.newshare.extension;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.share.export.f;
import com.bytedance.ee.bear.share.newshare.ShareItemList;
import com.bytedance.ee.bear.share.newshare.d0;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class BaseShareProvider extends d {

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ BaseShareProvider a;

        public b(BaseShareProvider r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            f r5 = (f) r4;
            Intrinsics.checkNotNullParameter(r5, "shareInfo");
            BaseShareProvider r1 = this.a;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r5, "shareInfo");
            r1.g = r5;
            ShareItemList r6 = r1.c;
            if (r6 == null) goto L7;
            tt5.a.h("ShareProvider", "invalidate.");
            d0 r7 = r6.a();
            r1.d.setValue(r7);
            return;
        }
    }

    static {
    }

    public BaseShareProvider() {
    }

    public final <S extends f, V extends com.bytedance.ee.bear.share.newshare.extension.a<S>> void k(final V r4) {
        Intrinsics.checkNotNullParameter(r4, "behavior");
        final b r0 = new b(this);
        Function0<Unit> r1 = new BaseShareProvider$bindShareInfo$1(r4, r0);
        Function0<Unit> r2 = new BaseShareProvider$bindShareInfo$2(r4, r0);
        int r5 = this.h;
        if (r5 < 2) goto L6;
        return;
    L6:
        if (r5 < 1) goto L8;
        r1.invoke();
    L9:
        ((ArrayList) this.j).add(r2);
        return;
    L8:
        ((ArrayList) this.i).add(r1);
        goto L9
    }
}
