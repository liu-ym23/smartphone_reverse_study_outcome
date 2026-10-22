package yj3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends QUIModule {
    public final ViewGroup l;

    public final QIPresenter h() {
        return null;
    }

    public final List<QUIModule> i() {
        return CollectionsKt.listOf(new QUIModule[]{new a(this.l.findViewById(2131381795)), new c(this.l.findViewById(2131386878)), new d(this.l.findViewById(2131374649))});
    }

    public b(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        super(0);
        this.l = r2;
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }
}
