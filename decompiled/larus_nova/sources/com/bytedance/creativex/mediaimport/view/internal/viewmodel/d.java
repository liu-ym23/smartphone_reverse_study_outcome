package com.bytedance.creativex.mediaimport.view.internal.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.creativex.mediaimport.repository.api.BuiltInMaterialType;
import com.bytedance.creativex.mediaimport.repository.api.IFolderItem;
import com.bytedance.creativex.mediaimport.view.internal.MaterialSelectedState;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ki4.a0;
import ki4.z;
import kotlin.Function;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
import ti4.e0;

/* JADX INFO: loaded from: classes15.dex */
public abstract class d<DATA, FOLDER> implements ti4.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ti4.v<DATA, FOLDER> f204120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<FOLDER, a0, Boolean> f204121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<Boolean> f204122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<Boolean> f204123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<FOLDER, Map<a0, Boolean>> f204124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<FOLDER, int[]> f204125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PublishSubject<e0> f204126g;

    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f204127a;

        public a(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f204127a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f204127a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f204127a.invoke(r100);
        }
    }

    public abstract List<DATA> g(FOLDER r100, a0 r101);

    @Override // ti4.q
    public final Observable<e0> f() {
        return this.f204126g.hide();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final a0 i() {
        ti4.v<DATA, FOLDER> r100 = this.f204120a;
        if (r100 == null) goto L11;
        ti4.t<z> r101 = r100.d();
        if (r101 == null) goto L11;
        MutableLiveData r102 = r101.a();
        if (r102 == null) goto L11;
        Pair r103 = (Pair) r102.getValue();
        if (r103 == null) goto L11;
        return ((z) r103.component1()).a();
    L11:
        return null;
    }

    public final FOLDER j() {
        ti4.v<DATA, FOLDER> r100 = this.f204120a;
        if (r100 == null) goto L11;
        ti4.p<FOLDER> r101 = r100.f();
        if (r101 == null) goto L11;
        LiveData<Pair<FOLDER, Integer>> r102 = r101.getSelectedFolder();
        if (r102 == null) goto L11;
        Pair<FOLDER, Integer> r103 = r102.getValue();
        if (r103 == null) goto L11;
        return r103.getFirst();
    L11:
        return null;
    }

    @Override // ti4.q
    public final FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 a() {
        a0 r100 = i();
        FOLDER r101 = j();
        if (r100 == null) goto L16;
        if (r101 == null) goto L17;
        List<DATA> r102 = g(r101, r100);
        if (r102.isEmpty() == true) goto L21;
        this.f204126g.onNext(new e0.b(r100));
        ti4.v<DATA, FOLDER> r103 = this.f204120a;
        if (r103 == null) goto L18;
        ti4.m<DATA> r104 = r103.b();
        if (r104 == null) goto L19;
        Flow<Integer> r105 = r104.cancelMultiple(r102);
        if (r105 != null) goto L15;
        return null;
    L15:
        return new FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(r105, new BaseMediaSelectAllViewModel$cancelAll$1$1(this, r100, null));
    L19:
        return null;
    L18:
        return null;
    L21:
        return null;
    L17:
        return null;
    L16:
        return null;
    }

    @Override // ti4.q
    public final FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 d() {
        a0 r100 = i();
        FOLDER r101 = j();
        if (r100 == null) goto L16;
        if (r101 == null) goto L17;
        List<DATA> r102 = g(r101, r100);
        if (r102.isEmpty() == true) goto L21;
        this.f204126g.onNext(new e0.e(r100));
        ti4.v<DATA, FOLDER> r103 = this.f204120a;
        if (r103 == null) goto L18;
        ti4.m<DATA> r104 = r103.b();
        if (r104 == null) goto L19;
        Flow<Integer> r105 = r104.selectMultiple(r102);
        if (r105 != null) goto L15;
        return null;
    L15:
        return new FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(r105, new BaseMediaSelectAllViewModel$selectAll$1$1(this, r100, null));
    L19:
        return null;
    L18:
        return null;
    L21:
        return null;
    L17:
        return null;
    L16:
        return null;
    }

    @Override // ti4.q
    public final MutableLiveData b() {
        return this.f204123d;
    }

    @Override // ti4.q
    public final MutableLiveData c() {
        return this.f204122c;
    }

    @Override // ti4.q
    public final void e(boolean r100) {
        if (r100 == false) goto L13;
        FOLDER r101 = j();
        if (r101 != null) goto L6;
        return;
    L6:
        a0 r102 = i();
        if (r102 != null) goto L10;
        return;
    L10:
        if (k(r101, r102) == true) goto L12;
        return;
    L12:
        this.f204123d.setValue(Boolean.TRUE);
        return;
    L13:
        this.f204123d.setValue(Boolean.FALSE);
    }

    public final Map<a0, Boolean> m(FOLDER r100) {
        LinkedHashMap r101 = (LinkedHashMap) this.f204124e;
        Object r102 = r101.get(r100);
        if (r102 != null) goto L6;
        r102 = new LinkedHashMap();
        r101.put(r100, r102);
    L6:
        return (Map) r102;
    }

    public final int[] n(FOLDER r100) {
        LinkedHashMap r101 = (LinkedHashMap) this.f204125f;
        Object r102 = r101.get(r100);
        Object r103 = r102;
        if (r102 != null) goto L6;
        int[] r104 = {0, 0};
        r101.put(r100, r104);
        r103 = r104;
    L6:
        return (int[]) r103;
    }

    public final void o(FOLDER r100) {
        BuiltInMaterialType r101 = BuiltInMaterialType.VIDEO;
        boolean r102 = l(r100, r101);
        BuiltInMaterialType r103 = BuiltInMaterialType.IMAGE;
        boolean r104 = l(r100, r103);
        m(r100).put(r101, Boolean.valueOf(!r102));
        m(r100).put(r103, Boolean.valueOf(!r104));
        Map<a0, Boolean> r105 = m(r100);
        BuiltInMaterialType r106 = BuiltInMaterialType.ALL;
        if (r102 == false) goto L7;
        if (r104 == false) goto L7;
        boolean r107 = false;
    L8:
        r105.put(r106, Boolean.valueOf(r107));
        return;
    L7:
        r107 = true;
        goto L8
    }

    public final void h(FOLDER r100, a0 r101) {
        Boolean r102 = m(r100).get(r101);
        if (r102 == null) goto L5;
        boolean r103 = r102.booleanValue();
    L6:
        this.f204122c.setValue(Boolean.valueOf(r103));
        return;
    L5:
        r103 = true;
        goto L6
    }

    public final boolean k(FOLDER r100, a0 r101) {
        if (g(r100, r101).isEmpty() == true) goto L10;
        Function2<FOLDER, a0, Boolean> r102 = this.f204121b;
        if (r102 == null) goto L7;
        boolean r103 = r102.invoke(r100, r101).booleanValue();
    L8:
        if (r103 == false) goto L10;
        return true;
    L7:
        r103 = true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean l(Object r100, BuiltInMaterialType r101) {
        int[] r102 = n(r100);
        int r103 = r102[0];
        int r104 = r102[1];
        List<DATA> r105 = g(r100, r101);
        if (r101 != BuiltInMaterialType.VIDEO) goto L8;
        if (r105.size() != r103) goto L20;
    L16:
        return true;
    L20:
        return false;
    L8:
        if (r101 != BuiltInMaterialType.IMAGE) goto L13;
        if (r105.size() == r104) goto L16;
        return false;
    L13:
        if (r101 != BuiltInMaterialType.ALL) goto L19;
        if (r105.size() == (r103 + r104)) goto L16;
        return false;
    L19:
        throw new NotImplementedError("An operation is not implemented: XXY");
    }

    public d(LifecycleOwner r100, x r101, Function2 r102) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        this.f204120a = r101;
        this.f204121b = r102;
        this.f204122c = new MutableLiveData();
        this.f204123d = new MutableLiveData();
        this.f204124e = new LinkedHashMap();
        this.f204125f = new LinkedHashMap();
        this.f204126g = PublishSubject.create();
        ti4.m<ki4.r> r103 = r101.f204159f;
        if (r103 == null) goto L7;
        LiveData<Pair<List<ki4.r>, MaterialSelectedState>> r104 = r103.getSelectionChanged();
        if (r104 == null) goto L7;
        r104.observe(r100, new a(new com.bytedance.creativex.mediaimport.view.internal.viewmodel.a(this)));
    L7:
        ti4.t<z> r105 = r101.f204160g;
        if (r105 == null) goto L12;
        MutableLiveData r106 = r105.a();
        if (r106 == null) goto L12;
        r106.observe(r100, new a(new b(this)));
    L12:
        ti4.p<IFolderItem> r107 = r101.f204158e;
        if (r107 == null) goto L18;
        LiveData<Pair<IFolderItem, Integer>> r108 = r107.getSelectedFolder();
        if (r108 == null) goto L19;
        r108.observe(r100, new a(new c(this)));
        return;
    L19:
        return;
    }
}
