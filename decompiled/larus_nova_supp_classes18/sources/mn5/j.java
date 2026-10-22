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
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements jn5.c, OnItemDragListener {
    public SheetTabAdapter a;
    public View b;
    public View c;
    public View d;
    public RecyclerView e;
    public int f;
    public jn5.c.a g;
    public SheetTabItemDragAndSwipeCallback h;

    public j() {
    }

    public final void onItemDragMoving(RecyclerView.ViewHolder r1, int r2, RecyclerView.ViewHolder r3, int r4) {
    }

    @Override // jn5.c
    public final void c() {
        View r0 = this.b;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        return;
    }

    @Override // jn5.c
    public final void g() {
        View r0 = this.b;
        if (r0 == null) goto L6;
        r0.setVisibility(0);
        return;
    }

    @Override // jn5.c
    public Context getContext() {
        RecyclerView r0 = this.e;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getContext();
    }

    @Override // jn5.c
    public final void a(boolean r2) {
        SheetTabAdapter r0 = this.a;
        if (r0 == null) goto L6;
        r0.c = r2;
        this.b.post(new g(this));
        return;
    }

    @Override // jn5.c
    public final void b(View r4) {
        this.b = r4;
        Context r5 = r4.getContext();
        RecyclerView r0 = this.b.findViewById(2131385009);
        this.e = r0;
        r0.setLayoutManager(new LinearLayoutManager(r5, 0, false));
        this.e.addItemDecoration(new SheetTabItemDecoration(r5));
        DefaultItemAnimator r6 = new DefaultItemAnimator();
        r6.setChangeDuration(0);
        this.e.setItemAnimator(r6);
        SheetTabAdapter r7 = new SheetTabAdapter();
        this.a = r7;
        r7.b = this.g;
        this.e.setAdapter(r7);
        SheetTabItemDragAndSwipeCallback r8 = new SheetTabItemDragAndSwipeCallback(this.a);
        this.h = r8;
        r8.setDragMoveFlags(12);
        this.h.setMoveThreshold(0.0f);
        ItemTouchHelper r9 = new ItemTouchHelper(this.h);
        r9.attachToRecyclerView(this.e);
        this.a.enableDragItem(r9, 0, false);
        this.a.setOnItemDragListener(this);
        View r10 = this.b.findViewById(2131372663);
        this.c = r10;
        r10.setOnClickListener(new h(this));
        View r11 = this.b.findViewById(2131371864);
        this.d = r11;
        r11.setOnClickListener(new i(this));
    }

    @Override // jn5.c
    public final void d(ArrayList<SheetTabItem> r4) {
        SheetTabAdapter r0 = this.a;
        if (r0 == null) goto L12;
        if (r4 != null) goto L6;
        r4 = new ArrayList();
    L6:
        r0.getClass();
        DiffUtil.DiffResult r1 = DiffUtil.calculateDiff(new RecyclerItemsDiff(r0.getData(), r4, r0), true);
        r0.setNewData(r4);
        r1.dispatchUpdatesTo(r0);
        List r5 = this.a.getData();
        int r2 = r5.size();
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L16;
        if (((SheetTabItem) ListProtector.get(r5, r3)).getSelected() == true) goto L10;
        r3 = r3 + 1;
        goto L7
    L10:
        this.e.smoothScrollToPosition(r3);
        return;
    L16:
        return;
    }

    @Override // jn5.c
    public final void e(jn5.c.a r2) {
        this.g = r2;
        this.a.b = r2;
    }

    @Override // jn5.c
    public final void f(boolean r2) {
        View r0 = this.c;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        this.b.post(new f(this));
        return;
    L6:
        r3 = 8;
        goto L7
    }

    @Override // jn5.c
    public final void h(boolean r2) {
        View r0 = this.d;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        this.d.post(new e(this));
        return;
    L6:
        r3 = 8;
        goto L7
    }

    @Override // jn5.c
    public final void setDraggable(boolean r2) {
        this.h.a = r2;
        this.b.post(new d(this));
    }

    public final void onItemDragEnd(RecyclerView.ViewHolder r3, int r4) {
        jn5.c.a r5 = this.g;
        boolean r0 = false;
        if (r5 == null) goto L5;
        r5.f(false);
    L5:
        if (r4 >= 0) goto L7;
    L8:
        r0 = true;
    L10:
        if (r0 == false) goto L13;
        r4 = -1;
    L13:
        if (this.f == (-1)) goto L21;
        if (r4 == (-1)) goto L24;
        SheetTabItem r6 = (SheetTabItem) this.a.getItem(r4);
        jn5.c.a r1 = this.g;
        if (r1 == null) goto L22;
        if (r6 == null) goto L23;
        r1.a(this.f, r6, r4);
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
        if (r4 < this.a.getData().size()) goto L10;
        goto L8
    }

    public final void onItemDragStart(RecyclerView.ViewHolder r2, int r3) {
        jn5.c.a r4 = this.g;
        boolean r0 = true;
        if (r4 == null) goto L5;
        r4.f(true);
    L5:
        if (r3 >= 0) goto L7;
    L10:
        if (r0 == false) goto L12;
        r3 = -1;
    L12:
        this.f = r3;
        return;
    L7:
        if (r3 >= this.a.getData().size()) goto L10;
        r0 = false;
        goto L10
    }
}
