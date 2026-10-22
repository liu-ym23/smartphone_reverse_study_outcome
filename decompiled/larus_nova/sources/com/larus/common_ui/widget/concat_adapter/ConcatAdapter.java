package com.larus.common_ui.widget.concat_adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes27.dex */
public final class ConcatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.common_ui.widget.concat_adapter.a f328556a;

    public static final class Config {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Config f328557b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final StableIdMode f328558a;

        public static final enum StableIdMode extends Enum<StableIdMode> {
            public static final StableIdMode ISOLATED_STABLE_IDS = null;
            public static final StableIdMode NO_STABLE_IDS = null;
            public static final StableIdMode SHARED_STABLE_IDS = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ StableIdMode[] f328559a = null;

            static {
                StableIdMode r100 = new StableIdMode("NO_STABLE_IDS", 0);
                NO_STABLE_IDS = r100;
                StableIdMode r101 = new StableIdMode("ISOLATED_STABLE_IDS", 1);
                ISOLATED_STABLE_IDS = r101;
                StableIdMode r102 = new StableIdMode("SHARED_STABLE_IDS", 2);
                SHARED_STABLE_IDS = r102;
                f328559a = new StableIdMode[]{r100, r101, r102};
            }

            public static StableIdMode[] values() {
                return (StableIdMode[]) f328559a.clone();
            }

            public static StableIdMode valueOf(String r100) {
                return (StableIdMode) r27.a.a(StableIdMode.class, r100);
            }

            public StableIdMode(String r100, int r101) {
                super(r100, r101);
            }
        }

        static {
            f328557b = new Config(StableIdMode.NO_STABLE_IDS);
        }

        public Config(StableIdMode r100) {
            this.f328558a = r100;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclerView.Adapter<?> f328560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f328561b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f328562c;

        public a(RecyclerView.Adapter r100, int r101, int r102) {
            this.f328560a = r100;
            this.f328561b = r101;
            this.f328562c = r102;
        }
    }

    @SafeVarargs
    public ConcatAdapter() {
        throw null;
    }

    public final List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> getAdapters() {
        com.larus.common_ui.widget.concat_adapter.a r100 = this.f328556a;
        if (((ArrayList) r100.f328567e).isEmpty() == false) goto L5;
        List r101 = Collections.emptyList();
    L11:
        return Collections.unmodifiableList(r101);
    L5:
        ArrayList r102 = new ArrayList(((ArrayList) r100.f328567e).size());
        Iterator r103 = ((ArrayList) r100.f328567e).iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r102.add(((b) r103.next()).f328576c);
        goto L7
    L9:
        r101 = r102;
        goto L11
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        Iterator r100 = ((ArrayList) this.f328556a.f328567e).iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 + ((b) r100.next()).f328578e;
        goto L4
    L6:
        return r101;
    }

    @SafeVarargs
    public ConcatAdapter(RecyclerView.Adapter<? extends RecyclerView.ViewHolder>... r100) {
        Config r101 = Config.f328557b;
        List r102 = Arrays.asList(r100);
        this.f328556a = new com.larus.common_ui.widget.concat_adapter.a(this, r101);
        Iterator r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        RecyclerView.Adapter<RecyclerView.ViewHolder> r104 = (RecyclerView.Adapter) r103.next();
        com.larus.common_ui.widget.concat_adapter.a r105 = this.f328556a;
        r105.a(((ArrayList) r105.f328567e).size(), r104);
        goto L4
    L7:
        if (this.f328556a.f328569g == Config.StableIdMode.NO_STABLE_IDS) goto L9;
        boolean r106 = true;
    L10:
        super.setHasStableIds(r106);
        return;
    L9:
        r106 = false;
        goto L10
    }

    public static a y2(RecyclerView.ViewHolder r100) {
        if ((r100.itemView.getParent() instanceof RecyclerView) == true) goto L5;
        return null;
    L5:
        RecyclerView r101 = (RecyclerView) r100.itemView.getParent();
        RecyclerView.Adapter r102 = r101.getAdapter();
        if (r102 != null) goto L9;
        return null;
    L9:
        if ((r102 instanceof ConcatAdapter) == true) goto L15;
        int r103 = r100.getAdapterPosition();
        if (r103 != (-1)) goto L14;
        return null;
    L14:
        return new a(r102, r103, r103);
    L15:
        ConcatAdapter r104 = (ConcatAdapter) r102;
        b r105 = r104.f328556a.f328566d.get(r100);
        if (r105 != null) goto L18;
        RecyclerView.Adapter<RecyclerView.ViewHolder> r106 = null;
    L19:
        if (r106 != null) goto L21;
        return null;
    L21:
        Iterator<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r107 = r104.getAdapters().iterator();
        boolean r108 = false;
        int r109 = 0;
    L23:
        if (r107.hasNext() == false) goto L28;
        RecyclerView.Adapter<RecyclerView.ViewHolder> r110 = (RecyclerView.Adapter) r107.next();
        if (r110 == r106) goto L26;
        r109 = r109 + r110.getItemCount();
        goto L23
    L26:
        r108 = true;
    L28:
        if (r108 == true) goto L30;
        return null;
    L30:
        int r111 = r100.getAdapterPosition();
        if (r111 == (-1)) goto L33;
        int r112 = r109 + r111;
    L37:
        if (r111 >= 0) goto L39;
    L46:
        return null;
    L39:
        if (r111 >= r106.getItemCount()) goto L46;
        if (r112 < 0) goto L46;
        if (r112 >= r104.getItemCount()) goto L46;
        return new a(r106, r111, r112);
    L33:
        int r113 = r101.getChildAdapterPosition(r100.itemView);
        if (r113 != (-1)) goto L36;
        return null;
    L36:
        r111 = r113 - r109;
        r112 = r113;
        goto L37
    L18:
        r106 = r105.f328576c;
        goto L19
    }

    public static int z2(RecyclerView.ViewHolder r100) {
        a r101 = y2(r100);
        if (r101 != null) goto L6;
        return -1;
    L6:
        return r101.f328561b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        com.larus.common_ui.widget.concat_adapter.a r101 = this.f328556a;
        com.larus.common_ui.widget.concat_adapter.a.C4190a r102 = r101.c(r100);
        b r103 = r102.f328571a;
        int r104 = r102.f328572b;
        long r105 = r103.f328576c.getItemId(r104);
        long r106 = r103.f328575b.localToGlobal(r105);
        r102.f328573c = false;
        r102.f328571a = null;
        r102.f328572b = -1;
        r101.f328568f = r102;
        return r106;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        com.larus.common_ui.widget.concat_adapter.a r101 = this.f328556a;
        com.larus.common_ui.widget.concat_adapter.a.C4190a r102 = r101.c(r100);
        b r103 = r102.f328571a;
        int r104 = r102.f328572b;
        a29.a.C0007a r105 = r103.f328574a;
        int r106 = r103.f328576c.getItemViewType(r104);
        int r107 = r105.f1439a.indexOfKey(r106);
        if (r107 <= (-1)) goto L5;
        int r108 = r105.f1439a.valueAt(r107);
    L6:
        r102.f328573c = false;
        r102.f328571a = null;
        r102.f328572b = -1;
        r101.f328568f = r102;
        return r108;
    L5:
        a29.a r109 = r105.f1442d;
        b r110 = r105.f1441c;
        int r111 = r109.f1438b;
        r109.f1438b = r111 + 1;
        r109.f1437a.put(r111, r110);
        r105.f1439a.put(r106, r111);
        r105.f1440b.put(r111, r106);
        r108 = r111;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        com.larus.common_ui.widget.concat_adapter.a r101 = this.f328556a;
        Iterator r102 = ((ArrayList) r101.f328565c).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        if (((WeakReference) r102.next()).get() != r100) goto L4;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L15;
        List<WeakReference<RecyclerView>> r104 = r101.f328565c;
        ArrayList r105 = (ArrayList) r104;
        r105.add(new WeakReference(r100));
        Iterator r106 = ((ArrayList) r101.f328567e).iterator();
    L13:
        if (r106.hasNext() == false) goto L20;
        ((b) r106.next()).f328576c.onAttachedToRecyclerView(r100);
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
        com.larus.common_ui.widget.concat_adapter.a r101 = this.f328556a;
        int r102 = ((ArrayList) r101.f328565c).size();
    L3:
        r102 = r102 - 1;
        if (r102 < 0) goto L11;
        WeakReference r103 = (WeakReference) ListProtector.get(r101.f328565c, r102);
        if (r103.get() == null) goto L7;
        if (r103.get() != r100) goto L3;
        ListProtector.remove(r101.f328565c, r102);
        goto L11
    L7:
        ListProtector.remove(r101.f328565c, r102);
    L11:
        Iterator r104 = ((ArrayList) r101.f328567e).iterator();
    L13:
        if (r104.hasNext() == false) goto L15;
        ((b) r104.next()).f328576c.onDetachedFromRecyclerView(r100);
        goto L13
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder r100) {
        com.larus.common_ui.widget.concat_adapter.a r101 = this.f328556a;
        b r102 = r101.f328566d.get(r100);
        if (r102 == null) goto L7;
        boolean r103 = r102.f328576c.onFailedToRecycleView(r100);
        r101.f328566d.remove(r100);
        return r103;
    L7:
        throw new IllegalStateException("Cannot find wrapper for " + r100 + ", seems like it is not bound by this adapter: " + r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        this.f328556a.e(r100).f328576c.onViewAttachedToWindow(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        this.f328556a.e(r100).f328576c.onViewDetachedFromWindow(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        com.larus.common_ui.widget.concat_adapter.a r101 = this.f328556a;
        b r102 = r101.f328566d.get(r100);
        if (r102 == null) goto L7;
        r102.f328576c.onViewRecycled(r100);
        r101.f328566d.remove(r100);
        return;
    L7:
        throw new IllegalStateException("Cannot find wrapper for " + r100 + ", seems like it is not bound by this adapter: " + r101);
    }

    public final boolean removeAdapter(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r100) {
        com.larus.common_ui.widget.concat_adapter.a r101 = this.f328556a;
        int r102 = r101.f(r100);
        if (r102 != (-1)) goto L5;
        return false;
    L5:
        b r103 = (b) ListProtector.get(r101.f328567e, r102);
        int r104 = r101.b(r103);
        ListProtector.remove(r101.f328567e, r102);
        r101.f328563a.notifyItemRangeRemoved(r104, r103.f328578e);
        Iterator r105 = ((ArrayList) r101.f328565c).iterator();
    L7:
        if (r105.hasNext() == false) goto L11;
        RecyclerView r106 = (RecyclerView) ((WeakReference) r105.next()).get();
        if (r106 == null) goto L7;
        r100.onDetachedFromRecyclerView(r106);
        goto L7
    L11:
        r103.f328576c.unregisterAdapterDataObserver(r103.f328579f);
        a29.a.C0007a r107 = r103.f328574a;
        a29.a r108 = r107.f1442d;
        b r109 = r107.f1441c;
        int r110 = r108.f1437a.size();
    L12:
        r110 = r110 - 1;
        if (r110 < 0) goto L17;
        if (r108.f1437a.valueAt(r110) != r109) goto L12;
        r108.f1437a.removeAt(r110);
        goto L12
    L17:
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean r100) {
        throw new UnsupportedOperationException("Calling setHasStableIds is not allowed on the ConcatAdapter. Use the Config object passed in the constructor to control this behavior");
    }

    public final boolean addAdapter(int r100, RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r101) {
        return this.f328556a.a(0, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        com.larus.common_ui.widget.concat_adapter.a r102 = this.f328556a;
        com.larus.common_ui.widget.concat_adapter.a.C4190a r103 = r102.c(r101);
        r102.f328566d.put(r100, r103.f328571a);
        b r104 = r103.f328571a;
        int r105 = r103.f328572b;
        r104.f328576c.bindViewHolder(r100, r105);
        r103.f328573c = false;
        r103.f328571a = null;
        r103.f328572b = -1;
        r102.f328568f = r103;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        b r102 = this.f328556a.f328564b.f1437a.get(r101);
        if (r102 == null) goto L11;
        a29.a.C0007a r103 = r102.f328574a;
        int r104 = r103.f1440b.indexOfKey(r101);
        if (r104 < 0) goto L9;
        return r102.f328576c.onCreateViewHolder(r100, r103.f1440b.valueAt(r104));
    L9:
        throw new IllegalStateException("requested global type " + r101 + " does not belong to the adapter:" + r103.f1441c.f328576c);
    L11:
        throw new IllegalArgumentException("Cannot find the wrapper for global view type " + r101);
    }
}
