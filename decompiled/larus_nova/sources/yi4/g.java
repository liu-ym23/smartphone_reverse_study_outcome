package yi4;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.creativex.mediaimport.preview.internal.main.x;
import com.bytedance.creativex.mediaimport.view.internal.MaterialSelectedState;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ti4.m;

/* JADX INFO: loaded from: classes15.dex */
public final class g<DATA> implements ti4.l<DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleOwner f567919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m<DATA> f567920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fi4.c<DATA> f567921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<DATA, DATA, Boolean> f567922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<Pair<Integer, Integer>> f567923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<Triple<Integer, MaterialSelectedState, DATA>> f567924f;

    /* JADX WARN: Multi-variable type inference failed */
    public final DATA d() {
        fi4.c<DATA> r100 = this.f567921c;
        if (r100 == null) goto L7;
        Pair r101 = (Pair) r100.a().getValue();
        if (r101 == null) goto L7;
        return (DATA) r101.getFirst();
    L7:
        return null;
    }

    @Override // ti4.l
    public final void b() {
        DATA r100 = d();
        if (r100 == null) goto L8;
        m<DATA> r101 = this.f567920b;
        if (r101 == null) goto L9;
        r101.changeSelectState(r100, r101.getSelectState(r100));
        return;
    L9:
        return;
    }

    @Override // ti4.l
    public final MutableLiveData c() {
        return this.f567924f;
    }

    @Override // ti4.l
    public final MutableLiveData getSelectionChanged() {
        return this.f567923e;
    }

    @Override // ti4.l
    public final MaterialSelectedState a(DATA r100) {
        if (this.f567922d.invoke(d(), r100).booleanValue() == false) goto L6;
        return MaterialSelectedState.SELECTED;
    L6:
        return MaterialSelectedState.NON_SELECTED;
    }

    public final void e(DATA r100) {
        m<DATA> r101 = this.f567920b;
        int r102 = -1;
        if (r101 == null) goto L5;
        int r103 = r101.getSelectIndex(r100);
    L6:
        Pair<Integer, Integer> r104 = this.f567923e.getValue();
        if (r104 == null) goto L9;
        r102 = r104.getSecond().intValue();
    L9:
        this.f567923e.setValue(TuplesKt.to(Integer.valueOf(r102), Integer.valueOf(r103)));
        m<DATA> r105 = this.f567920b;
        if (r105 == null) goto L13;
        MaterialSelectedState r106 = r105.getSelectState(r100);
        if (r106 == null) goto L13;
    L14:
        this.f567924f.setValue(new Triple(Integer.valueOf(r103), r106, r100));
        return;
    L13:
        r106 = MaterialSelectedState.NON_SELECTED;
        goto L14
    L5:
        r103 = -1;
        goto L6
    }

    public g(LifecycleOwner r100, m r101, fi4.c r102, x r103) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r103, "isCurrentPageSelected");
        this.f567919a = r100;
        this.f567920b = r101;
        this.f567921c = r102;
        this.f567922d = r103;
        this.f567923e = new MutableLiveData();
        this.f567924f = new MutableLiveData();
    }
}
