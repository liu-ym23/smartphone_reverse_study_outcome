package ei;

import android.view.View;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes43.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<T> f472755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<Integer> f472756b;

    public abstract View a(Object r100);

    public a(List<T> r100) {
        this.f472756b = new HashSet();
        this.f472755a = r100;
    }
}
