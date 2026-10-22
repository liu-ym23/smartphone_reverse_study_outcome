package com.lynx.tasm.behavior.ui.list;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.g;
import com.lynx.tasm.l;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.tasm.utils.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public class UIListAdapter extends RecyclerView.Adapter<ListViewHolder> {
    public final b A;
    public final ArrayList<HashMap<Integer, Integer>> B;
    public final HashMap<String, Integer> C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Integer> f382672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Long, ListViewHolder> f382673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UIList f382674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f382675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f382676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f382677f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f382678g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JavaOnlyArray f382679h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public JavaOnlyArray f382680i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public JavaOnlyArray f382681j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public JavaOnlyArray f382682k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public JavaOnlyArray f382683l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public JavaOnlyArray f382684m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public JavaOnlyArray f382685n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public JavaOnlyArray f382686o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public JavaOnlyArray f382687p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final d f382688q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f382689r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final e7a.a f382690s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public JavaOnlyArray f382691t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public HashMap<String, Integer> f382692u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f382693v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f382694w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f382695x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f382696y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final a f382697z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UIListAdapter f382698a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f382698a.f382688q.a();     // Catch: Throwable -> L4 IllegalStateException -> L6
        L13:
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L6:
            e = move-exception;
            LLog.e("UIList", "operationDispatcher.dispatch() leads to the IllegalStateException : " + e.getMessage());     // Catch: Throwable -> L4
            goto L13
        }

        public a(UIListAdapter r100) {
            this.f382698a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UIListAdapter f382699a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f382699a.notifyDataSetChanged();     // Catch: Throwable -> L4 IllegalStateException -> L6
        L13:
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L6:
            e = move-exception;
            LLog.e("UIList", "notifyDataSetChanged leads to the IllegalStateException : " + e.getMessage());     // Catch: Throwable -> L4
            goto L13
        }

        public b(UIListAdapter r100) {
            this.f382699a = r100;
        }
    }

    public class c implements UIComponent.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UIListAdapter f382700a;

        public c(UIListAdapter r100) {
            this.f382700a = r100;
        }

        @Override // com.lynx.tasm.behavior.ui.view.UIComponent.b
        public final void a(UIComponent r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (r100.f383173b == null) goto L8;
            this.f382700a.O2(r100);
            return;
        }
    }

    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ReadableArray f382701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ReadableArray f382702b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ReadableArray f382703c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ReadableArray f382704d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ReadableArray f382705e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ReadableArray f382706f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ UIListAdapter f382707g;

        public final void a() {
            int r100 = 0;
            if (this.f382703c == null) goto L9;
            int r101 = 0;
        L6:
            if (r101 >= this.f382703c.size()) goto L9;
            this.f382707g.notifyItemChanged(this.f382703c.getInt(r101), Integer.valueOf(this.f382704d.getInt(r101)));
            r101 = r101 + 1;
        L9:
            if (this.f382705e == null) goto L14;
            int r102 = 0;
        L12:
            if (r102 >= this.f382705e.size()) goto L14;
            this.f382707g.notifyItemMoved(this.f382705e.getInt(r102), this.f382706f.getInt(r102));
            r102 = r102 + 1;
        L14:
            ReadableArray r103 = this.f382702b;
            if (r103 == null) goto L20;
            int r104 = r103.size() - 1;
        L17:
            if (r104 < 0) goto L20;
            this.f382707g.notifyItemRemoved(this.f382702b.getInt(r104));
            r104 = r104 - 1;
        L20:
            if (this.f382701a != null) goto L22;
            return;
        L22:
            if (r100 >= this.f382701a.size()) goto L29;
            this.f382707g.notifyItemInserted(this.f382701a.getInt(r100));
            r100 = r100 + 1;
            goto L22
        }

        public d(UIListAdapter r100) {
            this.f382707g = r100;
        }

        public static boolean b(ReadableArray r100) {
            if (r100 != null) goto L4;
            return false;
        L4:
            if (r100.size() <= 0) goto L9;
            return true;
        L9:
            return false;
        }

        public void update(ReadableMap r100) {
            this.f382701a = r100.getArray("insertions");
            this.f382702b = r100.getArray("removals");
            this.f382703c = r100.getArray("updateFrom");
            this.f382704d = r100.getArray("updateTo");
            this.f382705e = r100.getArray("moveFrom");
            this.f382706f = r100.getArray("moveTo");
            if (b(this.f382701a) == false) goto L5;
        L14:
            this.f382707g.f382676e = false;
            return;
        L5:
            if (b(this.f382702b) == true) goto L14;
            if (b(this.f382703c) == true) goto L14;
            if (b(this.f382704d) == true) goto L14;
            if (b(this.f382705e) == true) goto L14;
            if (b(this.f382706f) == true) goto L14;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean L2() {
        if (this.f382675d == false) goto L11;
        UIList r100 = this.f382674c;
        if (r100 == null) goto L11;
        if (r100.getView() == 0) goto L11;
        if (((RecyclerView) this.f382674c.getView()).isComputingLayout() == false) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        JavaOnlyArray r100 = this.f382679h;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public final long z2() {
        long r100 = ((long) this.f382674c.getSign()) << 32;
        int r101 = this.f382689r;
        this.f382689r = r101 + 1;
        return r100 + ((long) r101);
    }

    public final int A2(int r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.f382680i.size()) goto L10;
        Integer r102 = (Integer) this.f382680i.get(r101);
        if (r102.intValue() >= r100) goto L8;
        r101 = r101 + 1;
        goto L4
    L8:
        return r102.intValue();
    L10:
        return -1;
    }

    public final int B2(int r100) {
        int r101 = this.f382680i.size() - 1;
    L3:
        if (r101 < 0) goto L9;
        Integer r102 = (Integer) this.f382680i.get(r101);
        if (r102.intValue() <= r100) goto L7;
        r101 = r101 - 1;
        goto L3
    L7:
        return r102.intValue();
    L9:
        return -1;
    }

    public final int C2(int r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.f382680i.size()) goto L12;
        Integer r102 = (Integer) this.f382680i.get(r101);
        if (r102.intValue() < r100) goto L11;
        int r103 = r102.intValue();
        if (this.f382682k.contains(Integer.valueOf(r103)) == false) goto L11;
        return r102.intValue();
    L11:
        r101 = r101 + 1;
        goto L4
    L12:
        return -1;
    }

    public final int D2(int r100) {
        int r101 = this.f382680i.size() - 1;
    L3:
        if (r101 < 0) goto L11;
        Integer r102 = (Integer) this.f382680i.get(r101);
        if (r102.intValue() > r100) goto L10;
        if (this.f382681j.contains(Integer.valueOf(r102.intValue())) == false) goto L10;
        return r102.intValue();
    L10:
        r101 = r101 - 1;
        goto L3
    L11:
        return -1;
    }

    public final boolean E2(UIComponent r100) {
        UIList r101 = this.f382674c;
        if (r101 == null) goto L20;
        RecyclerView r102 = r101.V();
        if (r102 == null) goto L20;
        int r103 = 0;
    L8:
        if (r103 >= r102.getChildCount()) goto L20;
        View r104 = r102.getChildAt(r103);
        if ((r104 instanceof ListViewHolder.b) == false) goto L19;
        UIComponent r105 = ((ListViewHolder.b) r104).f382623b;
        if (r105 == null) goto L19;
        String r106 = r105.f383173b;
        if (r106 == null) goto L19;
        if (r106.equals(r100.f383173b) == false) goto L19;
        return true;
    L19:
        r103 = r103 + 1;
    L20:
        return false;
    }

    public final boolean F2(int r100) {
        return this.f382680i.contains(Integer.valueOf(r100));
    }

    public final void H2(ListViewHolder r100) {
        UIComponent r101 = r100.f382620a.f382623b;
        if (r101 == null) goto L22;
        r100.T3();
        if (this.f382674c.P == null) goto L18;
        if (E2(r101) == true) goto L15;
        com.lynx.tasm.behavior.ui.list.a r102 = this.f382674c.P;
        if (r102 != null) goto L11;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == false) goto L18;
    L11:
        if (r102.b(r101.f383173b) == false) goto L13;
        r103 = true;
    L15:
        LLog.i("UIList", "when recycling the child asynchronously,if the view of the component is used, you cannot recycle the component. the itemKey is :" + r101.f383173b + " position:" + r100.getAdapterPosition());
        return;
    L18:
        if (this.f382678g == false) goto L20;
        UIList r104 = this.f382674c;
        ((l) r104.f382571a).f(r104.getSign(), r101.getSign());
        r100.f382620a.f382622a = 0;
        return;
    L20:
        this.f382674c.N(r101);
        return;
    }

    public final void I2(UIComponent r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f382674c.P == null) goto L17;
        if (E2(r100) == true) goto L14;
        com.lynx.tasm.behavior.ui.list.a r101 = this.f382674c.P;
        if (r101 != null) goto L10;
    L12:
        boolean r102 = false;
    L13:
        if (r102 == false) goto L17;
    L10:
        if (r101.b(r100.f383173b) == false) goto L12;
        r102 = true;
    L14:
        LLog.i("UIList", "recycleHolderComponent the component is used. itemKey :" + r100.f383173b);
        return;
    L17:
        if (this.f382678g == false) goto L19;
        UIList r103 = this.f382674c;
        ((l) r103.f382571a).f(r103.getSign(), r100.getSign());
        return;
    L19:
        this.f382674c.N(r100);
    }

    public final void M2(JavaOnlyMap r100) {
        JavaOnlyArray r101 = this.f382679h;
        int r102 = 0;
        if (r101 != null) goto L5;
    L9:
        boolean r103 = false;
    L10:
        if (r100 != null) goto L12;
        return;
    L12:
        if (r100.isEmpty() == true) goto L72;
        ReadableArray r104 = r100.getArray("itemkeys");
        if ((r104 instanceof JavaOnlyArray) == false) goto L17;
        this.f382691t = (JavaOnlyArray) r104;
    L17:
        this.f382692u = new HashMap();
        int r105 = 0;
    L19:
        if (r105 >= this.f382691t.size()) goto L21;
        this.f382692u.put(this.f382691t.getString(r105), Integer.valueOf(r105));
        r105 = r105 + 1;
        goto L19
    L21:
        ReadableArray r106 = r100.getArray("fullspan");
        if ((r106 instanceof JavaOnlyArray) == false) goto L24;
        this.f382680i = (JavaOnlyArray) r106;
    L24:
        ReadableArray r107 = r100.getArray("viewTypes");
        if ((r107 instanceof JavaOnlyArray) == false) goto L27;
        this.f382679h = (JavaOnlyArray) r107;
    L27:
        ReadableArray r108 = r100.getArray("stickyTop");
        if ((r108 instanceof JavaOnlyArray) == false) goto L30;
        this.f382681j = (JavaOnlyArray) r108;
    L30:
        ReadableArray r109 = r100.getArray("stickyBottom");
        if ((r109 instanceof JavaOnlyArray) == false) goto L33;
        this.f382682k = (JavaOnlyArray) r109;
    L33:
        ReadableArray r110 = r100.getArray("estimatedHeight");
        if ((r110 instanceof JavaOnlyArray) == false) goto L36;
        this.f382683l = (JavaOnlyArray) r110;
    L36:
        ReadableArray r111 = r100.getArray("estimatedHeightPx");
        if ((r111 instanceof JavaOnlyArray) == false) goto L39;
        this.f382684m = (JavaOnlyArray) r111;
    L39:
        boolean r112 = r100.getBoolean("diffable");
        this.f382675d = r100.getBoolean("newarch");
    L41:
        if (r102 >= this.f382679h.size()) goto L46;
        String r113 = this.f382679h.getString(r102);
        if (this.f382672a.containsKey(r113) == true) goto L45;
        HashMap<String, Integer> r114 = this.f382672a;
        r114.put(r113, Integer.valueOf(r114.size()));
    L45:
        r102 = r102 + 1;
        goto L41
    L46:
        if (r103 == true) goto L59;
        if (r112 == false) goto L59;
        if (this.f382676e == false) goto L59;
        ReadableMap r115 = r100.getMap("diffResult");
        if (r115 != null) goto L53;
    L55:
        this.f382688q.update(r115);
        if (L2() == false) goto L58;
        UIThreadUtils.runOnUiThread(this.f382697z);
        return;
    L58:
        this.f382697z.run();
        return;
    L53:
        if (r115.size() <= 0) goto L55;
        this.f382696y = true;
    L59:
        this.f382696y = true;
        this.C.clear();
        if (L2() == false) goto L62;
        UIThreadUtils.runOnUiThread(this.A);
        return;
    L62:
        this.A.run();
        return;
    L72:
        return;
    L5:
        if (this.f382680i == null) goto L9;
        if (r101.size() != this.f382680i.size()) goto L9;
        r103 = true;
        goto L10
    }

    public final void O2(UIComponent r100) {
        if (this.f382674c.O == false) goto L14;
        if (r100 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r100.f383173b) == false) goto L9;
        return;
    L9:
        if (this.f382674c.f382655x == false) goto L11;
        int r101 = r100.getHeight();
    L12:
        int r102 = UIList.L0;
        this.C.put(r100.f383173b, Integer.valueOf(r101));
        return;
    L11:
        r101 = r100.getWidth();
        goto L12
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        if (hasStableIds() == true) goto L5;
        return -1;
    L5:
        return r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        Integer r101 = this.f382672a.get(this.f382679h.getString(r100));
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        ListViewHolder r101 = (ListViewHolder) r100;
        if (r101.f382620a.f382623b != null) goto L13;
        if (this.f382678g == false) goto L9;
        if (this.f382673b.containsValue(r101) == true) goto L13;
    L9:
        if (this.f382675d == false) goto L11;
        y2(r101, r101.getAdapterPosition());
        goto L13
    L11:
        G2(r101, r101.getAdapterPosition());
    L13:
        if (this.f382678g == true) goto L16;
        this.f382690s.c(r101);
    L16:
        if (this.f382675d == false) goto L22;
        ListViewHolder.b r102 = r101.f382620a;
        if (r102.f382623b == null) goto L22;
        if (this.f382693v == false) goto L22;
        UIComponent r103 = r102.f382623b;
        r103.onListCellAppear(r103.f383173b, this.f382674c);
    L22:
        int r104 = r101.getAdapterPosition();
        int r105 = getItemCount() - r101.getAdapterPosition();
        boolean r106 = true;
        int r107 = r105 - 1;
        int r108 = 0;
        if (r107 != 0) goto L25;
    L30:
        if (r106 == true) goto L36;
        ListViewHolder.b r109 = r101.f382620a;
        UIList r110 = this.f382674c;
        if (r110.R == false) goto L34;
        int r111 = 0;
    L35:
        r109.f382628g = r111;
    L37:
        RecyclerView.LayoutParams r112 = (RecyclerView.LayoutParams) r101.itemView.getLayoutParams();
        if ((r112 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L41;
        ((StaggeredGridLayoutManager.LayoutParams) r112).setFullSpan(F2(r104));
    L41:
        if (this.B.isEmpty() == true) goto L87;
        UIComponent r113 = r101.f382620a.f382623b;
        if (r113 != null) goto L46;
        int r114 = 0;
    L48:
        if ((((RecyclerView) this.f382674c.getView()).getLayoutManager() instanceof ListLayoutManager.ListLinearLayoutManager) == false) goto L51;
        ((HashMap) ListProtector.get(this.B, 0)).put(Integer.valueOf(r104), Integer.valueOf(r114));
        return;
    L51:
        if ((((RecyclerView) this.f382674c.getView()).getLayoutManager() instanceof ListLayoutManager.b) == false) goto L65;
        StaggeredGridLayoutManager.LayoutParams r115 = (StaggeredGridLayoutManager.LayoutParams) r101.itemView.getLayoutParams();
        if (F2(r104) == false) goto L58;
    L55:
        if (r108 >= this.B.size()) goto L88;
        ((HashMap) ListProtector.get(this.B, r108)).put(Integer.valueOf(r104), Integer.valueOf(r114));
        r108 = r108 + 1;
        goto L55
    L88:
        return;
    L58:
        if (r108 >= this.B.size()) goto L89;
        if (r115.getSpanIndex() != r108) goto L62;
        ((HashMap) ListProtector.get(this.B, r108)).put(Integer.valueOf(r104), Integer.valueOf(r114));
    L63:
        r108 = r108 + 1;
        goto L58
    L62:
        ((HashMap) ListProtector.get(this.B, r108)).remove(Integer.valueOf(r104));
        goto L63
    L89:
        return;
    L65:
        if ((((RecyclerView) this.f382674c.getView()).getLayoutManager() instanceof GridLayoutManager) == false) goto L86;
        GridLayoutManager r116 = (GridLayoutManager) ((RecyclerView) this.f382674c.getView()).getLayoutManager();
        int r117 = r116.getSpanSizeLookup().getSpanIndex(r104, r116.getSpanCount());
        if (F2(r104) == false) goto L72;
    L69:
        if (r108 >= this.B.size()) goto L90;
        ((HashMap) ListProtector.get(this.B, r108)).put(Integer.valueOf(r104), Integer.valueOf(r114));
        r108 = r108 + 1;
        goto L69
    L90:
        return;
    L72:
        if (r108 >= this.B.size()) goto L91;
        if (r117 != r108) goto L75;
        ((HashMap) ListProtector.get(this.B, r108)).put(Integer.valueOf(r104), Integer.valueOf(r114));
    L76:
        r108 = r108 + 1;
        goto L72
    L75:
        ((HashMap) ListProtector.get(this.B, r108)).remove(Integer.valueOf(r104));
        goto L76
    L91:
        return;
    L86:
        return;
    L46:
        r114 = r113.getHeight();
        goto L48
    L87:
        return;
    L34:
        r111 = r110.f382634e;
        goto L35
    L36:
        r101.f382620a.f382628g = 0;
        goto L37
    L25:
        if (r107 < this.f382674c.f382633d) goto L27;
    L29:
        r106 = false;
        goto L30
    L27:
        if (A2(r104) != (-1)) goto L29;
        goto L29
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        ListViewHolder r101 = (ListViewHolder) r100;
        this.f382690s.a(r101);
        if (this.f382675d == false) goto L17;
        UIComponent r102 = r101.f382620a.f382623b;
        if (r102 == null) goto L14;
        if (this.f382694w == false) goto L14;
        JavaOnlyArray r103 = this.f382691t;
        if (r103 != null) goto L11;
        boolean r104 = false;
    L12:
        UIComponent r105 = r101.f382620a.f382623b;
        r105.onListCellDisAppear(r105.f383173b, this.f382674c, r104);
        goto L14
    L11:
        r104 = r103.contains(r102.f383173b);
    L14:
        if (this.f382678g == true) goto L18;
        H2(r101);
        return;
    L18:
        return;
    }

    public UIListAdapter(UIList r100, e7a.a r101) {
        this.f382675d = false;
        this.f382676e = false;
        this.f382677f = false;
        this.f382678g = false;
        this.f382689r = 0;
        this.f382693v = false;
        this.f382694w = false;
        this.f382695x = false;
        this.f382696y = false;
        this.f382697z = new a(this);
        this.A = new b(this);
        this.B = new ArrayList();
        this.C = new HashMap();
        this.f382672a = new HashMap();
        this.f382673b = new HashMap();
        this.f382688q = new d(this);
        this.f382674c = r100;
        this.f382690s = r101;
    }

    public final void G2(ListViewHolder r100, int r101) {
        if (r100 == null) goto L8;
        ListViewHolder.b r102 = r100.f382620a;
        if (r102 == null) goto L8;
        if (r102.f382629h != null) goto L8;
        r102.f382629h = new com.lynx.tasm.behavior.ui.list.c(this);
    L8:
        int r103 = UIList.L0;
        if (this.f382675d == false) goto L12;
        y2(r100, r101);
        return;
    L12:
        long r104 = z2();
        this.f382673b.put(Long.valueOf(r104), r100);
        ListViewHolder.b r105 = r100.f382620a;
        UIComponent r106 = r105.f382623b;
        if (r106 != null) goto L18;
        UIList r107 = this.f382674c;
        ((l) r107.f382571a).h(r107.getSign(), r101, r104);
        LynxUI r108 = (LynxUI) r107.f382572b;
        r107.f382572b = null;
        UIComponent r109 = (UIComponent) r108;
        if (r109 == null) goto L17;
        r100.U3(r109);
        this.f382690s.d(r100);
    L19:
        JavaOnlyArray r110 = this.f382684m;
        if (r110 != null) goto L22;
    L26:
        JavaOnlyArray r111 = this.f382683l;
        if (r111 != null) goto L29;
        return;
    L29:
        if (r111.size() <= r101) goto L35;
        int r112 = this.f382683l.getInt(r101);
        if (r112 <= 0) goto L36;
        r100.f382620a.f382625d = r112;
        return;
    L36:
        return;
    L35:
        return;
    L22:
        if (r110.size() <= r101) goto L26;
        int r113 = (int) i.b(this.f382684m.getInt(r101), 0.0f);
        if (r113 <= 0) goto L26;
        r100.f382620a.f382625d = r113;
        goto L26
    L17:
        LLog.i("UIList", "Adapter onBindViewHolder " + r101 + "child null");
        goto L19
    L18:
        r105.f382622a = 1;
        UIList r114 = this.f382674c;
        g r115 = r114.f382571a;
        ((l) r115).i(r114.getSign(), r106.getSign(), r101, r104);
        goto L19
    }

    public final void J2(ListViewHolder r100, int r101) {
        JavaOnlyArray r102 = this.f382684m;
        if (r102 != null) goto L5;
    L7:
        JavaOnlyArray r103 = this.f382683l;
        if (r103 != null) goto L10;
        return;
    L10:
        if (r103.size() <= r101) goto L14;
        K2(r100, this.f382683l.getInt(r101));
        return;
    L14:
        return;
    L5:
        if (r102.size() <= r101) goto L7;
        K2(r100, (int) i.b(this.f382684m.getInt(r101), 0.0f));
        goto L7
    }

    public final void K2(ListViewHolder r100, int r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f382674c.f382655x == false) goto L8;
        if (r101 <= 0) goto L11;
        r100.f382620a.f382625d = r101;
        return;
    L11:
        return;
    L8:
        if (r101 <= 0) goto L13;
        r100.f382620a.f382626e = r101;
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        G2((ListViewHolder) r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        int r102 = UIList.L0;
        ViewGroup.LayoutParams r103 = new ViewGroup.LayoutParams(-1, -2);
        ListViewHolder.b r104 = new ListViewHolder.b(r100.getContext());
        r104.setLayoutParams(r103);
        r104.f382627f = this.f382677f;
        r104.f382630i = ((RecyclerView) this.f382674c.getView()).getLayoutDirection();
        return new ListViewHolder(r104);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v37, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v16, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.view.View] */
    public final void y2(ListViewHolder r110, int r111) {
        int r100 = UIList.L0;
        com.lynx.tasm.behavior.ui.list.a r101 = this.f382674c.P;
        boolean r102 = false;
        if (r101 == null) goto L25;
        String r103 = this.f382691t.getString(r111);
        if (TextUtils.isEmpty(r103) == true) goto L25;
        int r104 = 0;
    L9:
        if (r104 >= r101.f382710c.size()) goto L16;
        UIComponent r105 = (UIComponent) ListProtector.get(r101.f382710c, r104);
        if (r105 == null) goto L15;
        if (r103.equals(r105.f383173b) == false) goto L15;
        r101.f382710c.remove(r105);
    L27:
        if (r105 != null) goto L66;
        long r106 = z2();
        int r107 = UIList.L0;
        this.f382673b.put(Long.valueOf(r106), r110);
        if (this.f382678g == false) goto L50;
        int r108 = this.f382674c.T;
        if (r108 == 1) goto L39;
        if (r108 != 0) goto L40;
        UIComponent r109 = r110.f382620a.f382623b;
        if (r109 == null) goto L40;
        if (TextUtils.isEmpty(r109.f383173b) == true) goto L40;
        if (r110.f382620a.f382623b.f383173b.equals(this.f382691t.getString(r111)) == false) goto L39;
    L40:
        r110.f382621b = r106;
        UIList r112 = this.f382674c;
        g r113 = r112.f382571a;
        l r114 = (l) r113;
        r114.d(r112.getSign(), r111, r106);
        ViewGroup.LayoutParams r115 = r110.itemView.getLayoutParams();
        if ((r115 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L43;
        ((StaggeredGridLayoutManager.LayoutParams) r115).setFullSpan(F2(r111));
    L43:
        String r116 = (String) this.f382691t.get(r111);
        r110.f382620a.f382622a = 0;
        if (this.f382674c.O == true) goto L46;
    L48:
        J2(r110, r111);
        return;
    L46:
        if (this.C.containsKey(r116) == false) goto L48;
        K2(r110, this.C.get(r116).intValue());
        return;
    L39:
        r110.T3();
        goto L40
    L50:
        r105 = this.f382674c.M(r111, r106, this.f382695x);
        if (r105 != null) goto L55;
        this.f382673b.remove(Long.valueOf(r106));
        return;
    L55:
        if (this.f382674c.L == true) goto L61;
        if (ViewCompat.isAttachedToWindow(r105.getView()) == false) goto L61;
        this.f382673b.remove(Long.valueOf(r106));
        return;
    L61:
        if (r105 != r110.f382620a.f382623b) goto L63;
    L107:
        UIList r117 = this.f382674c;
        if (r117.O == true) goto L110;
    L112:
        ViewGroup.LayoutParams r118 = r110.itemView.getLayoutParams();
        if ((r118 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L115;
        ((StaggeredGridLayoutManager.LayoutParams) r118).setFullSpan(F2(r111));
    L115:
        UIList r119 = this.f382674c;
        if (r119.O == true) goto L118;
    L133:
        J2(r110, r111);
        return;
    L118:
        if (r119.X() == false) goto L133;
        UIComponent r120 = r110.f382620a.f382623b;
        if (r120 == null) goto L133;
        if (this.C.containsKey(r120.f383173b) == false) goto L133;
        int r121 = this.C.get(r120.f383173b).intValue();
        if (this.f382674c.f382655x == false) goto L129;
        if (r121 == r120.getHeight()) goto L129;
        r120.setHeight(r121);
    L129:
        if (this.f382674c.f382655x == true) goto L133;
        if (r121 == r120.getWidth()) goto L133;
        r120.setWidth(r121);
        goto L133
    L110:
        if (r117.X() == false) goto L112;
        r105.f383172a = new c(this);
        goto L112
    L63:
        if (((com.lynx.tasm.behavior.ui.view.a) r105.getView()).getParent() == null) goto L65;
        ((ViewGroup) ((com.lynx.tasm.behavior.ui.view.a) r105.getView()).getParent()).removeView(r105.getView());
    L65:
        H2(r110);
        r110.U3(r105);
        this.f382690s.d(r110);
        goto L107
    L66:
        int r122 = UIList.L0;
        ListViewHolder.b r123 = r110.f382620a;
        r123.f382622a = 2;
        if (r105 != r123.f382623b) goto L69;
        r110.itemView.requestLayout();
    L75:
        com.lynx.tasm.behavior.ui.list.a r124 = this.f382674c.P;
        if (r124 == null) goto L107;
        UIList r125 = r124.f382708a;
        if (r125 == null) goto L107;
        UIListAdapter r126 = r125.f382632c;
        if (r126 == null) goto L107;
        if (r126.f382691t == null) goto L107;
        int r127 = r125.T();
        int r128 = r124.f382708a.U();
        if (r110.f382620a.f382623b == null) goto L107;
        if (r127 != (-1)) goto L88;
    L96:
        if (r128 == (-1)) goto L107;
        if (r110.getAdapterPosition() < r128) goto L107;
        if (r124.d(r124.f382709b + r128) == false) goto L107;
        JavaOnlyArray r129 = r126.f382691t;
        if (r129 == null) goto L105;
        r102 = true;
    L105:
        if (((true ^ r124.b(r129.getString(r124.f382709b + r128))) & r102) == false) goto L107;
        r124.e(r128 + r124.f382709b);
        goto L107
    L88:
        if (r110.getAdapterPosition() >= r127) goto L96;
        if (r124.d(r127 - r124.f382709b) == false) goto L107;
        JavaOnlyArray r130 = r126.f382691t;
        if (r130 == null) goto L107;
        if (r124.b(r130.getString(r127 - r124.f382709b)) == true) goto L107;
        r124.e(r127 - r124.f382709b);
        goto L107
    L69:
        if (r105.getView() != 0) goto L71;
    L73:
        H2(r110);
        r110.f382620a.f382622a = 2;
        r110.U3(r105);
        r105.requestLayout();
        r110.itemView.forceLayout();
        this.f382690s.d(r110);
        goto L75
    L71:
        if (((com.lynx.tasm.behavior.ui.view.a) r105.getView()).getParent() == null) goto L73;
        ((ViewGroup) ((com.lynx.tasm.behavior.ui.view.a) r105.getView()).getParent()).removeView(r105.getView());
    L15:
        r104 = r104 + 1;
        goto L9
    L16:
        int r131 = 0;
    L18:
        if (r131 >= r101.f382711d.size()) goto L25;
        r105 = (UIComponent) ListProtector.get(r101.f382711d, r131);
        if (r105 == null) goto L24;
        if (r103.equals(r105.f383173b) == false) goto L24;
        r101.f382711d.remove(r105);
    L24:
        r131 = r131 + 1;
    L25:
        r105 = null;
        goto L27
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r110, List r111) {
        ListViewHolder r101 = (ListViewHolder) r100;
        if (r101 == null) goto L10;
        ListViewHolder.b r102 = r101.f382620a;
        if (r102 == null) goto L10;
        if (r102.f382629h != null) goto L10;
        r102.f382629h = new com.lynx.tasm.behavior.ui.list.c(this);
    L10:
        if (this.f382675d == false) goto L17;
        if (r111.isEmpty() == true) goto L15;
        r110 = ((Integer) ListProtector.get(r111, r111.size() - 1)).intValue();
    L15:
        y2(r101, Integer.valueOf(r110).intValue());
        return;
    L17:
        if (r111.isEmpty() == false) goto L20;
        G2(r101, r110);
        return;
    L20:
        if (r101.f382620a.f382623b == null) goto L26;
        long r103 = z2();
        Integer r112 = (Integer) ListProtector.get(r111, r111.size() - 1);
        this.f382673b.put(Long.valueOf(r103), r101);
        this.f382690s.a(r101);
        ListViewHolder.b r104 = r101.f382620a;
        r104.f382622a = 1;
        UIList r105 = this.f382674c;
        UIComponent r106 = r104.f382623b;
        int r107 = r112.intValue();
        g r113 = r105.f382571a;
        l r108 = (l) r113;
        r108.i(r105.getSign(), r106.getSign(), r107, r103);
        this.f382690s.c(r101);
        J2(r101, r110);
        return;
    }
}
