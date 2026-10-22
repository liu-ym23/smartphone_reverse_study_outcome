package com.larus.dora.impl.dynamic;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.impl.dynamic.dsl.DslTemplateType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 52\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u00015B\u0013\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0015\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0014\u0010\u0017\u001a\u00020\f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019J\u0010\u0010\u001a\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u001c\u0010\u001b\u001a\u00020\f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\u0006\u0010\u000f\u001a\u00020\u0010J\u0014\u0010\u001c\u001a\u00020\f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019J\u000e\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0003J\u0006\u0010\u001f\u001a\u00020\fJ\u000e\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\u0012J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\"\u001a\u00020\fJ\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u001e\u0010(\u001a\u00020\f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010*\u001a\u00020'H\u0016J\u0016\u0010+\u001a\u00020\f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0016\u0010,\u001a\u00020\f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010-\u001a\u00020'H\u0016J\u0010\u0010.\u001a\u00020'2\u0006\u0010*\u001a\u00020'H\u0016J\u000e\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u000201J\u000e\u00102\u001a\u00020\f2\u0006\u00103\u001a\u000204R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/larus/dora/impl/dynamic/DslCardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/dora/impl/dynamic/BaseViewHolder;", "Lcom/larus/dora/impl/dynamic/dsl/DslCard;", "actionHandler", "Lcom/larus/dora/impl/dynamic/event/ActionHandler;", "<init>", "(Lcom/larus/dora/impl/dynamic/event/ActionHandler;)V", "items", "", "loadMoreListener", "Lkotlin/Function0;", "", "isLoading", "", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "handler", "Landroid/os/Handler;", "setLoadMoreListener", "listener", "setCards", "newItems", "", "setCardContext", "setData", "addData", "removeData", "data", "onLoadMoreComplete", "updateConnectionState", "newState", "updateDeviceInfoState", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "onViewDetachedFromWindow", "onViewRecycled", "getItemCount", "getItemViewType", "enableLoadMore", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "handleEvent", "event", "Lcom/larus/dora/impl/dynamic/DslCardAdapter$Companion$DslCardAdapterEvent;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DslCardAdapter extends RecyclerView.Adapter<BaseViewHolder<c59.i>> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f335120g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e59.a f335121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c59.i> f335122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f335123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d59.b f335124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile e59.b f335125e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f335126f;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.DslCardAdapter$a$a, reason: collision with other inner class name */
        public interface InterfaceC4244a {

            /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.DslCardAdapter$a$a$a, reason: collision with other inner class name */
            public static final class C4245a implements InterfaceC4244a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final C4245a f335127a = null;

                static {
                    f335127a = new C4245a();
                }

                public C4245a() {
                }
            }

            /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.DslCardAdapter$a$a$b */
            public static final class b implements InterfaceC4244a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final b f335128a = null;

                static {
                    f335128a = new b();
                }

                public b() {
                }
            }

            /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.DslCardAdapter$a$a$c */
            public static final class c implements InterfaceC4244a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final c f335129a = null;

                static {
                    f335129a = new c();
                }

                public c() {
                }
            }

            /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.DslCardAdapter$a$a$d */
            public static final class d implements InterfaceC4244a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final d f335130a = null;

                static {
                    f335130a = new d();
                }

                public d() {
                }
            }
        }
    }

    static {
    }

    public DslCardAdapter() {
        this(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f335122b).size();
    }

    public final void E2() {
        int r100 = getItemCount();
        final int r101 = 0;
    L3:
        if (r101 >= r100) goto L10;
        int r102 = getItemViewType(r101);
        if (DslTemplateType.PRODUCT_DISPLAY.ordinal() != r102) goto L7;
    L8:
        this.f335126f.post(new j1(this, r101));
    L9:
        r101 = r101 + 1;
        goto L3
    L7:
        if (DslTemplateType.SINGLE_DEVICE_PRODUCT_DISPLAY.ordinal() != r102) goto L9;
    }

    public DslCardAdapter(e59.a r100) {
        this.f335121a = r100;
        this.f335122b = new ArrayList();
        this.f335125e = e59.b.d.f471064a;
        this.f335126f = new Handler(Looper.getMainLooper());
    }

    public final void A2(d59.b r100) {
        this.f335124d = r100;
        g49.d.d("DslNodeAdapter", "setCardContext, cardContext: " + r100);
    }

    public final void B2(List<c59.i> r100) {
        Intrinsics.checkNotNullParameter(r100, "newItems");
        g49.d.d("DslNodeAdapter", "setCards, newItems: " + r100.size());
        ((ArrayList) this.f335122b).clear();
        ((ArrayList) this.f335122b).addAll(r100);
        this.f335126f.post(new i1(this));
    }

    public final void D2(e59.b r100) {
        Intrinsics.checkNotNullParameter(r100, "newState");
        if (Intrinsics.areEqual(this.f335125e, r100) == false) goto L5;
        return;
    L5:
        this.f335125e = r100;
        this.f335126f.post(new k1(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (((ArrayList) this.f335122b).isEmpty() == false) goto L5;
        return 0;
    L5:
        if (((c59.i) ListProtector.get(this.f335122b, r100)).f22513b == null) goto L13;
        DslTemplateType r101 = ((c59.i) ListProtector.get(this.f335122b, r100)).f22512a;
        if (r101 != null) goto L10;
        return 0;
    L10:
        return r101.ordinal();
    L13:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        BaseViewHolder r101 = (BaseViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewDetachedFromWindow(r101);
        r101.V3();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        BaseViewHolder r101 = (BaseViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewRecycled(r101);
        r101.onViewRecycled();
    }

    public final void y2(a.InterfaceC4244a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (Intrinsics.areEqual(r100, a.InterfaceC4244a.c.f335129a) == false) goto L6;
        this.f335126f.post(new e1(this));
        return;
    L6:
        if (Intrinsics.areEqual(r100, a.InterfaceC4244a.C4245a.f335127a) == false) goto L9;
        this.f335126f.post(new f1(this));
        return;
    L9:
        if (Intrinsics.areEqual(r100, a.InterfaceC4244a.d.f335130a) == false) goto L12;
        this.f335126f.post(new g1(this));
        return;
    L12:
        if (Intrinsics.areEqual(r100, a.InterfaceC4244a.b.f335128a) == false) goto L16;
        this.f335126f.post(new h1(this));
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public final void z2(c59.i r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        final int r101 = ((ArrayList) this.f335122b).indexOf(r100);
        if (r101 == (-1)) goto L6;
        ListProtector.remove(this.f335122b, r101);
        this.f335126f.post(new m1(this, r101));
        return;
    }

    public final void C2(List<c59.i> r100, d59.b r101) {
        Intrinsics.checkNotNullParameter(r100, "newItems");
        Intrinsics.checkNotNullParameter(r101, "cardContext");
        this.f335124d = r101;
        ((ArrayList) this.f335122b).clear();
        ArrayList r102 = (ArrayList) this.f335122b;
        r102.addAll(r100);
        this.f335126f.post(new l1(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        BaseViewHolder r102 = (BaseViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        r102.U3();
        r102.T3(ListProtector.get(this.f335122b, r101), this.f335125e, this.f335124d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        BaseViewHolder r102 = com.larus.dora.impl.dynamic.viewholder.n.a(r100, r101);
        e59.a r103 = this.f335121a;
        if (r103 == null) goto L5;
        Intrinsics.checkNotNullParameter(r103, "handler");
        r102.f335049a = r103;
    L5:
        return r102;
    }
}
