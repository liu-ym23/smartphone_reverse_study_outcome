package com.larus.paging.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes29.dex */
public final class ConcatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f363751a;

    public static final class Config {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Config f363752b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final StableIdMode f363753a;

        public static final enum StableIdMode extends Enum<StableIdMode> {
            public static final StableIdMode ISOLATED_STABLE_IDS = null;
            public static final StableIdMode NO_STABLE_IDS = null;
            public static final StableIdMode SHARED_STABLE_IDS = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ StableIdMode[] f363754a = null;

            static {
                StableIdMode r100 = new StableIdMode("NO_STABLE_IDS", 0);
                NO_STABLE_IDS = r100;
                StableIdMode r101 = new StableIdMode("ISOLATED_STABLE_IDS", 1);
                ISOLATED_STABLE_IDS = r101;
                StableIdMode r102 = new StableIdMode("SHARED_STABLE_IDS", 2);
                SHARED_STABLE_IDS = r102;
                f363754a = new StableIdMode[]{r100, r101, r102};
            }

            public static StableIdMode[] values() {
                return (StableIdMode[]) f363754a.clone();
            }

            public static StableIdMode valueOf(String r100) {
                return (StableIdMode) r27.a.a(StableIdMode.class, r100);
            }

            public StableIdMode(String r100, int r101) {
                super(r100, r101);
            }
        }

        static {
            f363752b = new Config(StableIdMode.NO_STABLE_IDS);
        }

        public Config(StableIdMode r100) {
            this.f363753a = r100;
        }
    }

    @SafeVarargs
    public ConcatAdapter() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        Iterator r100 = ((ArrayList) this.f363751a.f363759e).iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 + ((b) r100.next()).f363770e;
        goto L4
    L6:
        return r101;
    }

    @SafeVarargs
    public ConcatAdapter(RecyclerView.Adapter<? extends RecyclerView.ViewHolder>... r100) {
        Config r101 = Config.f363752b;
        List r102 = Arrays.asList(r100);
        this.f363751a = new a(this, r101);
        Iterator r103 = r102.iterator();
    L3:
        boolean r104 = true;
        int r105 = 0;
        if (r103.hasNext() == false) goto L41;
        RecyclerView.Adapter<RecyclerView.ViewHolder> r106 = (RecyclerView.Adapter) r103.next();
        a r107 = this.f363751a;
        int r108 = ((ArrayList) r107.f363759e).size();
        if (r108 < 0) goto L39;
        if (r108 > ((ArrayList) r107.f363759e).size()) goto L39;
        if (r107.f363761g != Config.StableIdMode.NO_STABLE_IDS) goto L13;
        r104 = false;
    L13:
        if (r104 == false) goto L15;
        r106.hasStableIds();
    L16:
        int r109 = ((ArrayList) r107.f363759e).size();
    L18:
        if (r105 >= r109) goto L23;
        if (((b) ListProtector.get(r107.f363759e, r105)).f363768c == r106) goto L24;
        r105 = r105 + 1;
    L24:
        if (r105 != (-1)) goto L26;
        b r110 = null;
    L27:
        if (r110 != null) goto L3;
        b r111 = new b(r106, r107, r107.f363756b, r107.f363762h.createStableIdLookup());
        ListProtector.add(r107.f363759e, r108, r111);
        Iterator r112 = ((ArrayList) r107.f363757c).iterator();
    L31:
        if (r112.hasNext() == false) goto L36;
        RecyclerView r113 = (RecyclerView) ((WeakReference) r112.next()).get();
        if (r113 == null) goto L31;
        r106.onAttachedToRecyclerView(r113);
        goto L31
    L36:
        if (r111.f363770e <= 0) goto L3;
        r107.f363755a.notifyItemRangeInserted(r107.a(r111), r111.f363770e);
        goto L3
    L26:
        r110 = (b) ListProtector.get(r107.f363759e, r105);
        goto L27
    L23:
        r105 = -1;
        goto L24
    L15:
        r106.hasStableIds();
    L39:
        throw new IndexOutOfBoundsException("Index must be between 0 and " + ((ArrayList) r107.f363759e).size() + ". Given:" + r108);
    L41:
        if (this.f363751a.f363761g != Config.StableIdMode.NO_STABLE_IDS) goto L44;
        r104 = false;
    L44:
        super.setHasStableIds(r104);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        a r101 = this.f363751a;
        a.C4458a r102 = r101.b(r100);
        b r103 = r102.f363763a;
        int r104 = r102.f363764b;
        long r105 = r103.f363768c.getItemId(r104);
        long r106 = r103.f363767b.localToGlobal(r105);
        r102.f363765c = false;
        r102.f363763a = null;
        r102.f363764b = -1;
        r101.f363760f = r102;
        return r106;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        a r101 = this.f363751a;
        a.C4458a r102 = r101.b(r100);
        b r103 = r102.f363763a;
        int r104 = r102.f363764b;
        zo9.a.C8483a r105 = r103.f363766a;
        int r106 = r103.f363768c.getItemViewType(r104);
        int r107 = r105.f573159a.indexOfKey(r106);
        if (r107 <= (-1)) goto L5;
        int r108 = r105.f573159a.valueAt(r107);
    L6:
        r102.f363765c = false;
        r102.f363763a = null;
        r102.f363764b = -1;
        r101.f363760f = r102;
        return r108;
    L5:
        zo9.a r109 = r105.f573162d;
        b r110 = r105.f573161c;
        int r111 = r109.f573158b;
        r109.f573158b = r111 + 1;
        r109.f573157a.put(r111, r110);
        r105.f573159a.put(r106, r111);
        r105.f573160b.put(r111, r106);
        r108 = r111;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        a r101 = this.f363751a;
        Iterator r102 = ((ArrayList) r101.f363757c).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        if (((WeakReference) r102.next()).get() != r100) goto L4;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L15;
        List<WeakReference<RecyclerView>> r104 = r101.f363757c;
        ArrayList r105 = (ArrayList) r104;
        r105.add(new WeakReference(r100));
        Iterator r106 = ((ArrayList) r101.f363759e).iterator();
    L13:
        if (r106.hasNext() == false) goto L20;
        ((b) r106.next()).f363768c.onAttachedToRecyclerView(r100);
        goto L13
    L20:
        return;
    L15:
        return;
    L8:
        r103 = false;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView r100) {
        a r101 = this.f363751a;
        int r102 = ((ArrayList) r101.f363757c).size();
    L3:
        r102 = r102 - 1;
        if (r102 < 0) goto L11;
        WeakReference r103 = (WeakReference) ListProtector.get(r101.f363757c, r102);
        if (r103.get() == null) goto L7;
        if (r103.get() != r100) goto L3;
        ListProtector.remove(r101.f363757c, r102);
        goto L11
    L7:
        ListProtector.remove(r101.f363757c, r102);
    L11:
        Iterator r104 = ((ArrayList) r101.f363759e).iterator();
    L13:
        if (r104.hasNext() == false) goto L15;
        ((b) r104.next()).f363768c.onDetachedFromRecyclerView(r100);
        goto L13
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder r100) {
        a r101 = this.f363751a;
        b r102 = r101.f363758d.get(r100);
        if (r102 == null) goto L7;
        boolean r103 = r102.f363768c.onFailedToRecycleView(r100);
        r101.f363758d.remove(r100);
        return r103;
    L7:
        throw new IllegalStateException("Cannot find wrapper for " + r100 + ", seems like it is not bound by this adapter: " + r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        this.f363751a.c(r100).f363768c.onViewAttachedToWindow(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        this.f363751a.c(r100).f363768c.onViewDetachedFromWindow(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        a r101 = this.f363751a;
        b r102 = r101.f363758d.get(r100);
        if (r102 == null) goto L7;
        r102.f363768c.onViewRecycled(r100);
        r101.f363758d.remove(r100);
        return;
    L7:
        throw new IllegalStateException("Cannot find wrapper for " + r100 + ", seems like it is not bound by this adapter: " + r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean r100) {
        throw new UnsupportedOperationException("Calling setHasStableIds is not allowed on the ConcatAdapter. Use the Config object passed in the constructor to control this behavior");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        a r102 = this.f363751a;
        a.C4458a r103 = r102.b(r101);
        r102.f363758d.put(r100, r103.f363763a);
        b r104 = r103.f363763a;
        int r105 = r103.f363764b;
        r104.f363768c.bindViewHolder(r100, r105);
        r103.f363765c = false;
        r103.f363763a = null;
        r103.f363764b = -1;
        r102.f363760f = r103;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        b r102 = this.f363751a.f363756b.f573157a.get(r101);
        if (r102 == null) goto L11;
        zo9.a.C8483a r103 = r102.f363766a;
        int r104 = r103.f573160b.indexOfKey(r101);
        if (r104 < 0) goto L9;
        return r102.f363768c.onCreateViewHolder(r100, r103.f573160b.valueAt(r104));
    L9:
        throw new IllegalStateException("requested global type " + r101 + " does not belong to the adapter:" + r103.f573161c.f363768c);
    L11:
        throw new IllegalArgumentException("Cannot find the wrapper for global view type " + r101);
    }
}
