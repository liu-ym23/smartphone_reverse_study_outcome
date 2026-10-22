package com.bytedance.ee.bear.bitable.itemview.record;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.celleditor.model.BitableEditorViewModel;
import com.bytedance.ee.bear.bitable.itemview.record.list.ItemViewRenderItemAdapter;
import com.bytedance.ee.bear.bitable.itemview.util.l;
import hp4.u;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class ItemViewRecordEditorScrollManager {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f214013g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitableEditorViewModel f214014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<Integer> f214015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference<RecyclerView> f214016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.card.view.record.a f214017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f214018e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ItemViewRecordEditorScrollManager$observer$1 f214019f;

    public static final class a {
    }

    public static final class b implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ItemViewRecordEditorScrollManager f214020a;

        @Override // hp4.u
        public final boolean r2() {
            return true;
        }

        public b(ItemViewRecordEditorScrollManager r100) {
            this.f214020a = r100;
        }

        @Override // hp4.u
        public final int getPanelHeight(Context r100) {
            MutableLiveData<Integer> r101 = this.f214020a.f214015b;
            if (r101 == null) goto L7;
            Integer r102 = r101.getValue();
            if (r102 == null) goto L7;
            return r102.intValue();
        L7:
            return 0;
        }
    }

    public static final class c implements com.bytedance.ee.bear.bitable.card.view.record.a.InterfaceC3009a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ItemViewRecordEditorScrollManager f214021a;

        public c(ItemViewRecordEditorScrollManager r100) {
            this.f214021a = r100;
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.record.a.InterfaceC3009a
        public final void b(int r100) {
            RecyclerView r101 = this.f214021a.f214016c.get();
            if (r101 != null) goto L5;
            return;
        L5:
            RecyclerView.Adapter r102 = r101.getAdapter();
            if ((r102 instanceof ItemViewRenderItemAdapter) == false) goto L8;
            ItemViewRenderItemAdapter r103 = (ItemViewRenderItemAdapter) r102;
        L9:
            if (r103 != null) goto L11;
            return;
        L11:
            RecyclerView.LayoutManager r104 = r101.getLayoutManager();
            if ((r104 instanceof LinearLayoutManager) == false) goto L14;
            LinearLayoutManager r105 = (LinearLayoutManager) r104;
        L15:
            if (r105 != null) goto L17;
            return;
        L17:
            boolean r106 = true;
            if (r105.findLastVisibleItemPosition() == (r103.getItemCount() - 1)) goto L21;
            r106 = false;
        L21:
            l.a("updateBottomSpaceHeight " + r106, null, null, null, 14);
            if (r106 == false) goto L25;
            r103.notifyDataSetChanged();
            return;
        L25:
            return;
        L14:
            r105 = null;
            goto L15
        L8:
            r103 = null;
            goto L9
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [com.bytedance.ee.bear.bitable.itemview.record.ItemViewRecordEditorScrollManager$observer$1] */
    public ItemViewRecordEditorScrollManager(RecyclerView r100, com.bytedance.ee.bear.bitable.itemview.b r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        MutableLiveData<Integer> r102 = null;
        if (r101 == null) goto L5;
        BitableEditorViewModel r103 = r101.HV();
    L6:
        this.f214014a = r103;
        if (r103 == null) goto L9;
        r102 = r103.getEditorPanelHeight();
    L9:
        this.f214015b = r102;
        this.f214016c = new WeakReference(r100);
        int r104 = com.bytedance.ee.bear.bitable.c.f207079a;
        com.bytedance.ee.bear.bitable.card.view.record.a r105 = new com.bytedance.ee.bear.bitable.card.view.record.a(r100, true, com.bytedance.ee.bear.bitable.core.usercomponent.b.c("base.itemview.fix_editor_navigation_error"));
        r105.f208663d = new c(this);
        this.f214017d = r105;
        this.f214018e = new b(this);
        this.f214019f = new ItemViewRecordEditorScrollManager$observer$1(this);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
