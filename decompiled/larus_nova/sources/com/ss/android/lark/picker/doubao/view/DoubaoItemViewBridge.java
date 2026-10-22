package com.ss.android.lark.picker.doubao.view;

import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge;
import com.ss.android.lark.picker.base.view.binder.bridge.LeadingContent;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import w3c.b;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u0007H\u0016J\u0010\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u0017H\u0016J\u0010\u0010'\u001a\u00020\t2\u0006\u0010!\u001a\u00020\"H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/ss/android/lark/picker/doubao/view/DoubaoItemViewBridge;", "Lcom/ss/android/lark/picker/base/view/binder/bridge/IItemViewBridge;", "holder", "Lcom/ss/android/lark/picker/doubao/view/DoubaoCustomBinderViewHolder;", "<init>", "(Lcom/ss/android/lark/picker/doubao/view/DoubaoCustomBinderViewHolder;)V", "checkBoxModel", "Lcom/ss/android/lark/search/dto/bindermodel/CheckBoxModel;", BasicTestActionHandler.TEST_ACTION_RESET, "", "setPrimaryText", "text", "", "setSecondaryText", "setLeadingContent", "content", "Lcom/ss/android/lark/picker/base/view/binder/bridge/LeadingContent;", "setDynamicTag", "tag", "setExtraInfoSummary", "summary", "showMask", "show", "", "setOnItemClickListener", "listener", "Landroid/view/View$OnClickListener;", "setOnItemLongClickListener", "Landroid/view/View$OnLongClickListener;", "attachRightSideView", "view", "Landroid/view/View;", "setAvatar", "info", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "checkState", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "updateCheckState", "isChecked", "bindData", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class DoubaoItemViewBridge implements IItemViewBridge {
    private b checkBoxModel;
    private final DoubaoCustomBinderViewHolder holder;

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void attachRightSideView(View r100) {
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setDynamicTag(CharSequence r100) {
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setExtraInfoSummary(CharSequence r100) {
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void reset() {
        this.holder.getTvTitle().setText("");
        this.holder.getTvSubtitle().setText("");
        this.holder.itemView.setEnabled(true);
        this.holder.itemView.setAlpha(1.0f);
    }

    public DoubaoItemViewBridge(DoubaoCustomBinderViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        this.holder = r100;
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void bindData(SearchBaseInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        this.holder.bindTitle(r100);
        this.holder.bindAvatar(r100);
        this.holder.bindSummary(r100);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void checkState(b r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        ImageView r101 = this.holder.getIvDoubaoCheckbox();
        if (r100.f558225c == false) goto L9;
        this.holder.getCheckboxContainer().setVisibility(0);
        r101.setVisibility(0);
        if (r100.f558223a == false) goto L7;
        int r102 = R.drawable.ic_doubao_checkbox_checked;
    L8:
        r101.setImageResource(r102);
    L10:
        this.checkBoxModel = r100;
        return;
    L7:
        r102 = R.drawable.ic_doubao_checkbox_unchecked;
        goto L8
    L9:
        this.holder.getCheckboxContainer().setVisibility(8);
        r101.setVisibility(8);
        goto L10
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setAvatar(SearchBaseInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        this.holder.bindAvatar(r100);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setLeadingContent(LeadingContent r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        if ((r100 instanceof LeadingContent.Avatar) == false) goto L5;
        return;
    L5:
        if ((r100 instanceof LeadingContent.Icon) == false) goto L7;
        return;
    L7:
        if ((r100 instanceof LeadingContent.Initial) == false) goto L10;
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setOnItemClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.holder.itemView.setOnClickListener(r100);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setOnItemLongClickListener(View.OnLongClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.holder.itemView.setOnLongClickListener(r100);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setPrimaryText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.holder.getTvTitle().setText(r100);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setSecondaryText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.holder.getTvSubtitle().setText(r100);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void showMask(boolean r100) {
        if (r100 == false) goto L4;
        this.holder.itemView.setAlpha(0.15f);
        return;
    L4:
        this.holder.itemView.setAlpha(1.0f);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void updateCheckState(boolean r100) {
        b r101 = this.checkBoxModel;
        if (r101 == null) goto L5;
        r101.f558223a = r100;
    L5:
        if (r101 == null) goto L8;
        checkState(r101);
        return;
    }
}
