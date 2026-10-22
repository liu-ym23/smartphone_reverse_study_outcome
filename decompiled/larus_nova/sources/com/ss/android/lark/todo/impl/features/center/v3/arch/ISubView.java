package com.ss.android.lark.todo.impl.features.center.v3.arch;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.larksuite.arch.jack.JackView;
import com.larksuite.arch.jack.JackViewModel;
import com.larksuite.arch.jack.j;
import com.larksuite.arch.jack.l;
import com.larksuite.arch.jack.n;
import com.larksuite.arch.jack.o;
import com.larksuite.arch.jack.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH&J\b\u0010\u000f\u001a\u00020\rH&J\b\u0010\u0010\u001a\u00020\rH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\"\u0010\u0006\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\b\u0012\u0006\b\u0001\u0012\u00020\t0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/arch/ISubView;", "Lcom/larksuite/arch/jack/JackView;", "viewLifecycle", "Landroidx/lifecycle/Lifecycle;", "getViewLifecycle", "()Landroidx/lifecycle/Lifecycle;", "viewModel", "Lcom/ss/android/lark/todo/impl/features/center/v3/arch/SubViewModel;", "Lcom/larksuite/arch/jack/State;", "Lcom/ss/android/lark/todo/impl/features/center/v3/arch/ISubViewAction;", "getViewModel", "()Lcom/ss/android/lark/todo/impl/features/center/v3/arch/SubViewModel;", "initView", "", "initViewAction", "initViewObserver", "initViewState", NewBroadcastMonitor.STAGE.LIFECYCLE, "getLifecycle", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ISubView extends JackView {

    public static final class a {
        public static void a(ISubView r100) {
            r100.oM();
            r100.S10();
            r100.MD();
        }

        public static <S extends j> com.larksuite.arch.jack.c e(ISubView r100, JackViewModel<S> r101, l<S> r102, Function1<? super S, Unit> r103) {
            Intrinsics.checkNotNullParameter(r101, "$receiver");
            Intrinsics.checkNotNullParameter(r102, "config");
            Intrinsics.checkNotNullParameter(r103, "subscriber");
            return JackView.a.d(r100, r101, r102, r103);
        }

        public static <S extends j, A> com.larksuite.arch.jack.c b(ISubView r100, JackViewModel<S> r101, KProperty1<S, ? extends A> r102, l<n<A>> r103, Function1<? super S, Unit> r104) {
            Intrinsics.checkNotNullParameter(r101, "$receiver");
            Intrinsics.checkNotNullParameter(r102, "prop1");
            Intrinsics.checkNotNullParameter(r103, "config");
            Intrinsics.checkNotNullParameter(r104, "subscriber");
            return JackView.a.a(r100, r101, r102, r103, r104);
        }

        public static <S extends j, A, B> com.larksuite.arch.jack.c c(ISubView r100, JackViewModel<S> r101, KProperty1<S, ? extends A> r102, KProperty1<S, ? extends B> r103, l<o<A, B>> r104, Function1<? super S, Unit> r105) {
            Intrinsics.checkNotNullParameter(r101, "$receiver");
            Intrinsics.checkNotNullParameter(r102, "prop1");
            Intrinsics.checkNotNullParameter(r103, "prop2");
            Intrinsics.checkNotNullParameter(r104, "config");
            Intrinsics.checkNotNullParameter(r105, "subscriber");
            return JackView.a.b(r100, r101, r102, r103, r104, r105);
        }

        public static <S extends j, A, B, C> com.larksuite.arch.jack.c d(ISubView r100, JackViewModel<S> r101, KProperty1<S, ? extends A> r102, KProperty1<S, ? extends B> r103, KProperty1<S, ? extends C> r104, l<p<A, B, C>> r105, Function1<? super S, Unit> r106) {
            Intrinsics.checkNotNullParameter(r101, "$receiver");
            Intrinsics.checkNotNullParameter(r102, "prop1");
            Intrinsics.checkNotNullParameter(r103, "prop2");
            Intrinsics.checkNotNullParameter(r104, "prop3");
            Intrinsics.checkNotNullParameter(r105, "config");
            Intrinsics.checkNotNullParameter(r106, "subscriber");
            return JackView.a.c(r100, r101, r102, r103, r104, r105, r106);
        }
    }

    void MD();

    void S10();

    void oM();
}
