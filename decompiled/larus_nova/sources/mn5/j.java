package mn5;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.sheet.tab.jsdata.SheetTabItem;
import com.bytedance.ee.bear.sheet.tab.view.SheetTabAdapter;
import com.bytedance.ee.bear.sheet.tab.view.SheetTabItemDecoration;
import com.bytedance.ee.bear.sheet.tab.view.SheetTabItemDragAndSwipeCallback;
import com.bytedance.ee.util.ui.RecyclerItemsDiff;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class j implements jn5.c, OnItemDragListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SheetTabAdapter f514551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f514552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f514553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f514554d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RecyclerView f514555e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f514556f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public jn5.c.a f514557g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SheetTabItemDragAndSwipeCallback f514558h;

    public j() {
    }

    @Override // com.chad.library.adapter.base.listener.OnItemDragListener
    public final void onItemDragMoving(RecyclerView.ViewHolder r100, int r101, RecyclerView.ViewHolder r102, int r103) {
    }

    @Override // jn5.c
    public final void c() {
        View r100 = this.f514552b;
        if (r100 == null) goto L6;
        r100.setVisibility(8);
        return;
    }

    @Override // jn5.c
    public final void g() {
        View r100 = this.f514552b;
        if (r100 == null) goto L6;
        r100.setVisibility(0);
        return;
    }

    @Override // jn5.c
    public Context getContext() {
        RecyclerView r100 = this.f514555e;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getContext();
    }

    @Override // jn5.c
    public final void a(boolean r100) {
        SheetTabAdapter r101 = this.f514551a;
        if (r101 == null) goto L6;
        r101.f238389c = r100;
        this.f514552b.post(new g(this));
        return;
    }

    @Override // jn5.c
    public final void b(View r100) {
        this.f514552b = r100;
        Context r101 = r100.getContext();
        RecyclerView r102 = (RecyclerView) this.f514552b.findViewById(R.id.rv_sheet_tab);
        this.f514555e = r102;
        r102.setLayoutManager(new LinearLayoutManager(r101, 0, false));
        this.f514555e.addItemDecoration(new SheetTabItemDecoration(r101));
        DefaultItemAnimator r103 = new DefaultItemAnimator();
        r103.setChangeDuration(0);
        this.f514555e.setItemAnimator(r103);
        SheetTabAdapter r104 = new SheetTabAdapter();
        this.f514551a = r104;
        r104.f238388b = this.f514557g;
        this.f514555e.setAdapter(r104);
        SheetTabItemDragAndSwipeCallback r105 = new SheetTabItemDragAndSwipeCallback(this.f514551a);
        this.f514558h = r105;
        r105.setDragMoveFlags(12);
        this.f514558h.setMoveThreshold(0.0f);
        ItemTouchHelper r106 = new ItemTouchHelper(this.f514558h);
        r106.attachToRecyclerView(this.f514555e);
        this.f514551a.enableDragItem(r106, 0, false);
        this.f514551a.setOnItemDragListener(this);
        View r107 = this.f514552b.findViewById(R.id.fl_add_sheets);
        this.f514553c = r107;
        r107.setOnClickListener(new h(this));
        View r108 = this.f514552b.findViewById(R.id.exit_landscape_btn);
        this.f514554d = r108;
        r108.setOnClickListener(new i(this));
    }

    @Override // jn5.c
    public final void d(ArrayList<SheetTabItem> r100) {
        SheetTabAdapter r101 = this.f514551a;
        if (r101 == null) goto L12;
        if (r100 != null) goto L6;
        r100 = new ArrayList();
    L6:
        r101.getClass();
        DiffUtil.DiffResult r102 = DiffUtil.calculateDiff(new RecyclerItemsDiff(r101.getData(), r100, r101), true);
        r101.setNewData(r100);
        r102.dispatchUpdatesTo(r101);
        List<SheetTabItem> r103 = this.f514551a.getData();
        int r104 = r103.size();
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L16;
        if (((SheetTabItem) ListProtector.get(r103, r105)).getSelected() == true) goto L10;
        r105 = r105 + 1;
        goto L7
    L10:
        this.f514555e.smoothScrollToPosition(r105);
        return;
    L16:
        return;
    }

    @Override // jn5.c
    public final void e(jn5.c.a r100) {
        this.f514557g = r100;
        this.f514551a.f238388b = r100;
    }

    @Override // jn5.c
    public final void f(boolean r100) {
        View r101 = this.f514553c;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        this.f514552b.post(new f(this));
        return;
    L6:
        r102 = 8;
        goto L7
    }

    @Override // jn5.c
    public final void h(boolean r100) {
        View r101 = this.f514554d;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        this.f514554d.post(new e(this));
        return;
    L6:
        r102 = 8;
        goto L7
    }

    @Override // jn5.c
    public final void setDraggable(boolean r100) {
        this.f514558h.f238405a = r100;
        this.f514552b.post(new d(this));
    }

    @Override // com.chad.library.adapter.base.listener.OnItemDragListener
    public final void onItemDragEnd(RecyclerView.ViewHolder r100, int r101) {
        jn5.c.a r102 = this.f514557g;
        boolean r103 = false;
        if (r102 == null) goto L5;
        r102.f(false);
    L5:
        if (r101 >= 0) goto L7;
    L8:
        r103 = true;
    L10:
        if (r103 == false) goto L13;
        r101 = -1;
    L13:
        if (this.f514556f == (-1)) goto L21;
        if (r101 == (-1)) goto L24;
        SheetTabItem r104 = this.f514551a.getItem(r101);
        jn5.c.a r105 = this.f514557g;
        if (r105 == null) goto L22;
        if (r104 == null) goto L23;
        r105.a(this.f514556f, r104, r101);
        return;
    L23:
        return;
    L22:
        return;
    L24:
        return;
    L21:
        return;
    L7:
        if (r101 < this.f514551a.getData().size()) goto L10;
        goto L8
    }

    @Override // com.chad.library.adapter.base.listener.OnItemDragListener
    public final void onItemDragStart(RecyclerView.ViewHolder r100, int r101) {
        jn5.c.a r102 = this.f514557g;
        boolean r103 = true;
        if (r102 == null) goto L5;
        r102.f(true);
    L5:
        if (r101 >= 0) goto L7;
    L10:
        if (r103 == false) goto L12;
        r101 = -1;
    L12:
        this.f514556f = r101;
        return;
    L7:
        if (r101 >= this.f514551a.getData().size()) goto L10;
        r103 = false;
        goto L10
    }
}
