package com.bytedance.ies.sve_core;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b)\u0010*J;\u0010\u000b\u001a\u00020\n\"\b\b\u0000\u0010\u0003*\u00020\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0091\u0001\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\b\b\u0000\u0010\u0003*\u00020\u0002\"\b\b\u0001\u0010\r*\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2L\b\u0002\u0010\u0014\u001aF\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0011\u0012\b\b\u0006\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0011\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010j\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u0001`\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00018\u0000H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u0019\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ3\u0010\u001f\u001a\u00028\u0000\"\b\b\u0000\u0010\u001c*\u00020\u001b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00018\u0000H\u0007¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010!\u001a\u00020\n2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eJ\u0010\u0010\"\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u001c\u0010\"\u001a\u00020\n2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0018\u0010\"\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007J\b\u0010#\u001a\u00020\nH\u0014R,\u0010&\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070%0$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R \u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001b0$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010'¨\u0006-"}, d2 = {"Lcom/bytedance/ies/sve_core/Store;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/ies/sve_core/s;", ExifInterface.LATITUDE_SOUTH, "Lcom/bytedance/ies/sve_core/m;", "", "name", "Lcom/bytedance/ies/sve_core/a;", "action", "data", "", "postValue", "(Lcom/bytedance/ies/sve_core/m;Ljava/lang/String;Lcom/bytedance/ies/sve_core/a;Lcom/bytedance/ies/sve_core/s;)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/bytedance/ies/sve_core/u;", EventConstant.Key.MODULE, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "state", "Lcom/bytedance/ies/sve_core/Reducer;", "reducer", "initialState", "Lcom/bytedance/ies/sve_core/o;", "useState", "(Lcom/bytedance/ies/sve_core/u;Lkotlin/jvm/functions/Function2;Lcom/bytedance/ies/sve_core/s;)Lcom/bytedance/ies/sve_core/o;", "obtainState", "(Lcom/bytedance/ies/sve_core/u;)Lcom/bytedance/ies/sve_core/s;", "Lcom/bytedance/ies/sve_core/e;", "C", "Lcom/bytedance/ies/sve_core/f;", "initialValue", "useConstant", "(Lcom/bytedance/ies/sve_core/f;Lcom/bytedance/ies/sve_core/e;)Lcom/bytedance/ies/sve_core/e;", "removeState", "dispatch", "onCleared", "", "Lcom/bytedance/ies/sve_core/t;", "stateModules", "Ljava/util/Map;", "constantModules", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "sve-core_release"}, k = 1, mv = {1, 4, 0})
public final class Store extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "SVE-Store";
    private final Map<String, e> constantModules;
    private final Map<String, t<s, com.bytedance.ies.sve_core.a>> stateModules;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public Store() {
        this.stateModules = new LinkedHashMap();
        this.constantModules = new LinkedHashMap();
        int r100 = w46.a.f558255a;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.stateModules.clear();
        int r100 = w46.a.f558255a;
    }

    public final void dispatch(com.bytedance.ies.sve_core.a r100) {
        Iterator<T> r101 = this.stateModules.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        dispatch((String) r101.next(), r100);
        goto L4
    }

    public final <S extends s> S obtainState(u<S> r100) {
        t<s, com.bytedance.ies.sve_core.a> r101 = this.stateModules.get(r100.f248702a);
        if (r101 == null) goto L7;
        m<s> r102 = r101.f248701c;
        if (r102 == null) goto L7;
        S r103 = r102.f248697a.getValue();
    L9:
        if ((r103 instanceof s) == true) goto L12;
        return null;
    L12:
        return r103;
    L7:
        r103 = null;
        goto L9
    }

    public final void removeState(u<?> r100) {
        String r101 = r100.f248702a;
        if ((r100 instanceof f) == false) goto L5;
        this.constantModules.remove(r101);
        return;
    L5:
        this.stateModules.remove(r101);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void dispatch(String r100, com.bytedance.ies.sve_core.a r101) {
        Objects.toString(r101);
        t<s, com.bytedance.ies.sve_core.a> r102 = this.stateModules.get(r100);
        if (r102 == null) goto L14;
        s r103 = (s) r102.f248701c.f248697a.getValue();
        if ((r101 instanceof n) == false) goto L7;
        postValue(r102.f248701c, r100, r101, ((n) r101).f248698a);
        return;
    L7:
        if (r103 == null) goto L16;
        Function2<S, A, S> r104 = r102.f248700b;
        if (r104 == 0) goto L17;
        s r105 = (s) r104.invoke((S) r103, (A) r101);
        if (r105 == null) goto L18;
        postValue(r102.f248701c, r100, r101, r105);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public final <C extends e> C useConstant(f<C> r100, C r101) {
        String r102 = r100.f248702a;
        C r103 = (C) this.constantModules.get(r102);
        if (r103 != null) goto L9;
        if (r101 == null) goto L7;
        this.constantModules.put(r102, r101);
        return r101;
    L7:
        throw new RuntimeException("constant has not init");
    L9:
        return r103;
    }

    public final void dispatch(u<?> r100, com.bytedance.ies.sve_core.a r101) {
        dispatch(r100.f248702a, r101);
    }

    public final <S extends s, A extends com.bytedance.ies.sve_core.a> o<S> useState(u<S> r100, Function2<? super S, ? super A, ? extends S> r101, S r102) {
        String r103 = r100.f248702a;
        t<s, com.bytedance.ies.sve_core.a> r104 = this.stateModules.get(r103);
        if (r104 != null) goto L8;
        if (r102 == null) goto L7;
        m<S> r105 = new m();
        postValue(r105, r103, new n(r102), r102);
        t<s, com.bytedance.ies.sve_core.a> r106 = new t(r103, r101, r105);
        this.stateModules.put(r103, r106);
        int r107 = w46.a.f558255a;
        r104 = r106;
        goto L8
    L7:
        throw new RuntimeException("state has not init");
    L8:
        m<s> r108 = r104.f248701c;
        if (r108 == null) goto L12;
        return r108;
    L12:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.ies.sve_core.Observable<S>");
    }

    private final <S extends s> void postValue(m<S> r100, String r101, com.bytedance.ies.sve_core.a r102, S r103) {
        int r104 = w46.a.f558255a;
        r100.f248697a.setValue(r103);
    }

    public static /* synthetic */ e useConstant$default(Store r100, f r101, e r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.useConstant(r101, r102);
    }

    public static /* synthetic */ o useState$default(Store r100, u r101, Function2 r102, s r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = null;
    L9:
        return r100.useState(r101, r102, r103);
    }
}
