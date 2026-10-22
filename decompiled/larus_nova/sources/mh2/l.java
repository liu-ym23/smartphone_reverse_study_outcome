package mh2;

import android.graphics.Bitmap;
import android.widget.TextView;
import io.reactivex.functions.Function;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class l<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f513921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f513922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f513923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f513924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ TextView f513925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f513926f;

    public l(List r100, String r101, float r102, float r103, TextView r104, boolean r105) {
        this.f513921a = r100;
        this.f513922b = r101;
        this.f513923c = r102;
        this.f513924d = r103;
        this.f513925e = r104;
        this.f513926f = r105;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Object[] r101 = (Object[]) r100;
        Intrinsics.checkNotNullParameter(r101, "rets");
        Iterator<T> r102 = CollectionsKt.sortedWith(ArraysKt.filterIsInstance(r101, r.b.class), new k()).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r.b r103 = (r.b) r102.next();
        this.f513921a.add(r103.f513938b);
        goto L4
    L6:
        HashMap<String, WeakReference<Bitmap>> r104 = q.f513935a;
        return q.c(this.f513921a, this.f513922b, this.f513923c, this.f513924d, this.f513925e, this.f513926f);
    }
}
