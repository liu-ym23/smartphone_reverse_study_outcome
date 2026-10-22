package com.bytedance.ee.bear.sheet.actionsheet;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.baidu.platform.comapi.map.MapController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aR\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "active", "Landroidx/lifecycle/MutableLiveData;", "", "getActive", "()Landroidx/lifecycle/MutableLiveData;", "sheetsActionSheetModel", "Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetModel;", "getSheetsActionSheetModel", "delegate", "Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetViewModel$Delegate;", "getDelegate", "()Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetViewModel$Delegate;", "setDelegate", "(Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetViewModel$Delegate;)V", "setActive", "", "onCancel", "onClickItem", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetItem;", "onClickItemRightIcon", "rightIcon", "Lcom/bytedance/ee/bear/sheet/actionsheet/RightIcon;", "Companion", "Delegate", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActionSheetViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String TAG = "SheetsActionSheetViewModel";
    private final MutableLiveData<Boolean> active;
    private b delegate;
    private final MutableLiveData<d> sheetsActionSheetModel;

    public static final class a {
        public a() {
        }
    }

    public interface b {
        void a(c r100);

        void b(c r100, f r101);

        void onCancel();
    }

    static {
        Companion = new a();
    }

    public final void onCancel() {
        tt5.a.b(TAG, "click cancel...");
        b r100 = this.delegate;
        if (r100 == null) goto L6;
        r100.onCancel();
        return;
    }

    public ActionSheetViewModel() {
        this.active = new MutableLiveData();
        this.sheetsActionSheetModel = new MutableLiveData();
    }

    public final MutableLiveData<Boolean> getActive() {
        return this.active;
    }

    public final b getDelegate() {
        return this.delegate;
    }

    public final MutableLiveData<d> getSheetsActionSheetModel() {
        return this.sheetsActionSheetModel;
    }

    public final void onClickItem(c r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        tt5.a.b(TAG, "click item[" + r100.f237301a + "]...");
        b r101 = this.delegate;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public final void setActive(boolean r100) {
        this.active.setValue(Boolean.valueOf(r100));
    }

    public final void setDelegate(b r100) {
        this.delegate = r100;
    }

    public final void onClickItemRightIcon(c r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "rightIcon");
        r101.getClass();
        tt5.a.b(TAG, "click item[" + r100.f237301a + "] icon[null]...");
        b r102 = this.delegate;
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }
}
