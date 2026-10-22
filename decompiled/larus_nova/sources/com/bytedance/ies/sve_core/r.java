package com.bytedance.ies.sve_core;

import com.bytedance.ies.sve_core.p;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes19.dex */
public interface r<P extends p> {

    public static final class a {
        public static /* synthetic */ r a(r r100, w r101) {
            return r100.X8(r101, PureViewExtraInterface$bindEffect$1.INSTANCE);
        }

        public static /* synthetic */ r b(r r100, u r101, Function1 r102) {
            return r100.Yk(r101, r102, PureViewExtraInterface$connectStore$2.INSTANCE);
        }

        public static /* synthetic */ void c(r r100, Object r101, Function1 r102, Function1 r103) {
            r100.lc(r101, r102, PureViewExtraInterface$diff$1.INSTANCE, r103);
        }
    }

    void Wo(i r100);

    PureViewImplDelegate X8(w r100, Function1 r101);

    <S extends s> r<P> Yk(u<S> r100, Function1<? super i, ? extends com.bytedance.ies.sve_core.a> r101, Function2<? super S, ? super P, ? extends P> r102);

    void Zm();

    /* JADX INFO: renamed from: if */
    void mo8366if(i r100);

    void ki(i r100);

    <P, T> void lc(P r100, Function1<? super P, ? extends T> r101, Function2<? super T, ? super T, Boolean> r102, Function1<? super T, Unit> r103);

    void update(P r100);
}
