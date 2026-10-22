package mx4;

import android.app.Activity;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f516217a;

    public c(a r100) {
        this.f516217a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((Long) r100, "it");
        tt5.a.h("DocAutoTestImpl2", "openDoc timeout, next. ");
        a r101 = this.f516217a;
        r101.f516207c.e(r101);
        Activity r102 = this.f516217a.f516206b.getCurrentActivity();
        if (r102 == null) goto L5;
        r102.onBackPressed();
        return Unit.INSTANCE;
    L5:
        return null;
    }
}
