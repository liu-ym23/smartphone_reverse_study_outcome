package com.bytedance.ee.bear.bitable.celleditor.model;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.bitable.itemview.record.ItemViewRecordEditorScrollManager;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\rJ\b\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u0004\u0018\u00010\tJ \u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u0010H\u0002J\u0006\u0010\u001a\u001a\u00020\u0010J\b\u0010\u001b\u001a\u00020\u0010H\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/model/BitableEditorViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "editorPanelHeight", "Landroidx/lifecycle/MutableLiveData;", "", "clickCellView", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "clickRenderId", "", "editorScrollManager", "Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordEditorScrollManager;", "getEditorPanelHeight", "updateEditorScrollManager", "", "editorPanelManager", "clearEditorScrollManager", "getClickRenderCellView", "updateClickRenderCellView", "renderId", "view", "checkSameRenderId", "", "cleanClickCellView", "dismissPanel", "onCleared", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableEditorViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "BitableEditorViewModel";
    private WeakReference<View> clickCellView;
    private String clickRenderId;
    private MutableLiveData<Integer> editorPanelHeight;
    private ItemViewRecordEditorScrollManager editorScrollManager;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private final void cleanClickCellView() {
        WeakReference<View> r100 = this.clickCellView;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        this.clickCellView = null;
        this.clickRenderId = null;
    }

    private final void clearEditorScrollManager() {
        ItemViewRecordEditorScrollManager r100 = this.editorScrollManager;
        if (r100 == null) goto L12;
        tt5.a.h("ItemViewRecordEditorPanelManager", VideoEventOneOutSync.END_TYPE_FINISH);
        MutableLiveData<Integer> r101 = r100.f214015b;
        if (r101 == null) goto L7;
        r101.removeObserver(r100.f214019f);
    L7:
        com.bytedance.ee.bear.bitable.card.view.record.a r102 = r100.f214017d;
        BitableEditorViewModel r103 = r100.f214014a;
        if (r103 == null) goto L10;
        View r104 = r103.getClickRenderCellView();
    L11:
        r102.f(r104, r100.f214018e);
        goto L12
    L10:
        r104 = null;
    L12:
        this.editorScrollManager = null;
    }

    public final void dismissPanel() {
        tt5.a.h(TAG, "dismissPanel");
        this.editorPanelHeight.postValue(0);
        clearEditorScrollManager();
        cleanClickCellView();
    }

    public final View getClickRenderCellView() {
        tt5.a.h(TAG, "getClickRenderCellView renderId:" + this.clickRenderId);
        WeakReference<View> r100 = this.clickCellView;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        tt5.a.h(TAG, "onCleared");
        super.onCleared();
        clearEditorScrollManager();
        cleanClickCellView();
    }

    public BitableEditorViewModel() {
        this.editorPanelHeight = new MutableLiveData();
    }

    public final MutableLiveData<Integer> getEditorPanelHeight() {
        return this.editorPanelHeight;
    }

    public final void updateEditorScrollManager(ItemViewRecordEditorScrollManager r100) {
        tt5.a.h(TAG, "updateEditorPanelManager");
        if (this.editorScrollManager == null) goto L5;
        clearEditorScrollManager();
    L5:
        this.editorScrollManager = r100;
        if (r100 == null) goto L11;
        tt5.a.h("ItemViewRecordEditorPanelManager", "start");
        MutableLiveData<Integer> r101 = r100.f214015b;
        if (r101 == null) goto L12;
        r101.observeForever(r100.f214019f);
        return;
    L12:
        return;
    }

    public final void updateClickRenderCellView(String r100, View r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "view");
        if (r102 == true) goto L5;
    L8:
        WeakReference<View> r103 = this.clickCellView;
        if (r103 == null) goto L11;
        View r104 = r103.get();
    L12:
        tt5.a.h(TAG, "updateClickRenderCellView renderId:" + r100 + ", newView:$" + r101.hashCode() + ", isSameView:" + Intrinsics.areEqual(r104, r101) + ", checkSameRenderId:" + r102);
        cleanClickCellView();
        this.clickRenderId = r100;
        this.clickCellView = new WeakReference(r101);
        return;
    L11:
        r104 = null;
        goto L12
    L5:
        if (TextUtils.equals(this.clickRenderId, r100) == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r100) == false) goto L8;
    }
}
