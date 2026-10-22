package aq3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class a extends QUIModule {
    public final View l;
    public final yp3.e<?> m;

    public final int j(QModel r2) {
        if ((r2 instanceof yp3.f) == true) goto L5;
        return 0;
    L5:
        if (((yp3.f) r2).b(this.m) != null) goto L10;
        return 8;
    L10:
        return 0;
    }

    public a(View r2, yp3.e<?> r3) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "elementKey");
        super(0);
        this.l = r2;
        this.m = r3;
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }
}
