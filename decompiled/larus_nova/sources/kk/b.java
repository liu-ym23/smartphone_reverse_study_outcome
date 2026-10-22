package kk;

import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f503735a;

    public b(Function0 r100) {
        this.f503735a = r100;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        return this.f503735a.invoke();
    }
}
