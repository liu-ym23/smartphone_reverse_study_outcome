package rn;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.ec.store.window.popup.ShopPopupWindowManager;
import com.bytedance.android.ec.store.window.popup.entity.PopupActionType;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d extends c<tn.a.d, tn.a.c, ViewGroup> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f538641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<c<?, ?, ?>> f538642d;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f538643a;

        public a(ShopPopupWindowManager.d r100) {
            this.f538643a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            this.f538643a.run();
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f538644a = null;

        static {
            f538644a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    @Override // rn.c, io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f538641c.dispose();
    }

    @Override // rn.c, io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f538641c.isDisposed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rn.c
    public final View b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LinearLayout r101 = new LinearLayout(r100);
        r101.setOrientation(0);
        r101.setGravity(16);
        int r102 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        r101.setPadding(0, com.bytedance.android.ec.hybrid.list.util.c.d(Integer.valueOf(((tn.a.d) ((tn.a.c) this.f538637b).f546839e).f546845a)), 0, com.bytedance.android.ec.hybrid.list.util.c.d(Integer.valueOf(((tn.a.d) ((tn.a.c) this.f538637b).f546839e).f546845a)));
        return r101;
    }

    @Override // rn.c
    public final /* bridge */ /* synthetic */ View d(Context r100, Runnable r101) {
        return e(r100, r101);
    }

    public final ViewGroup e(Context r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "closeDelegate");
        ViewGroup r102 = (ViewGroup) super.d(r100, r101);
        Iterator<T> r103 = this.f538642d.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        c r104 = (c) r103.next();
        View r105 = r104.d(r100, r101);
        int r106 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        r102.addView(r105, com.bytedance.android.ec.hybrid.list.util.c.d(Integer.valueOf(r104.f538637b.f546835a)), com.bytedance.android.ec.hybrid.list.util.c.d(Integer.valueOf(r104.f538637b.f546836b)));
        goto L4
    L6:
        Iterator<T> r107 = this.f538636a.iterator();
    L7:
        Object r108 = null;
        if (r107.hasNext() == false) goto L15;
        Object r109 = r107.next();
        if (((sn.d) r109).f542616a != PopupActionType.DELAYED_CLOSE_SELF) goto L12;
        boolean r110 = true;
    L13:
        if (r110 == false) goto L7;
    L17:
        if ((r109 instanceof sn.d.c) == false) goto L20;
        r108 = r109;
    L20:
        sn.d.c r111 = (sn.d.c) r108;
        if (r111 == null) goto L23;
        this.f538641c.add(bg4.b.b(Observable.timer(r111.f542617b, TimeUnit.MILLISECONDS)).subscribe(new a((ShopPopupWindowManager.d) r101), b.f538644a));
    L23:
        return r102;
    L12:
        r110 = false;
        goto L13
    L15:
        r109 = null;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(List<? extends sn.d> r100, tn.a.c r101, List<? extends c<?, ?, ?>> r102) {
        Intrinsics.checkNotNullParameter(r100, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r101, "uiConfig");
        Intrinsics.checkNotNullParameter(r102, SlcElement.KEY_ELEMENTS);
        super(r100, r101);
        this.f538642d = r102;
        this.f538641c = new CompositeDisposable();
    }
}
