package com.bytedance.ee.bear.list.move;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeoutException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ j a;
    public final /* synthetic */ Ref.ObjectRef<ApplyMoveViewModel> b;
    public final /* synthetic */ Context c;

    public m(j r1, Ref.ObjectRef<ApplyMoveViewModel> r2, Context r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        Intrinsics.checkNotNullParameter(r4, "throwable");
        int r0 = j.k;
        StringBuilder r1 = new StringBuilder("moveToWiki()...failed, error = ");
        r4.printStackTrace();
        r1.append(Unit.INSTANCE);
        tt5.a.d("SpaceMoveToWikiCommand", r1.toString());
        Toast.cancelLoading();
        j.c(this.a, (ApplyMoveViewModel) this.b.element);
        if ((r4 instanceof TimeoutException) == false) goto L6;
        Context r5 = this.c;
        Toast.showFailureText(r5, r5.getString(2131887484));
        return;
    L6:
        if (tp5.b.a(r4) != 90003088) goto L8;
        Toast.showFailureText(this.c, 2131889781);
        return;
    L8:
        Context r6 = this.c;
        Toast.showFailureText(r6, r6.getString(2131887932));
    }
}
