package xm;

import android.view.View;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<? extends T> f564522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<Integer> f564523b;

    public abstract View a(Object r100);

    public a(List<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f564523b = new HashSet();
        this.f564522a = r100;
    }
}
