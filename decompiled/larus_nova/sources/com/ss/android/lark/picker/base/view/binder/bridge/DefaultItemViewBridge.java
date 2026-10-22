package com.ss.android.lark.picker.base.view.binder.bridge;

import android.view.View;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.picker.base.view.ChatterChatViewHolder;
import com.ss.android.lark.picker.base.view.avataritem.AvatarItemView;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import uz7.a;
import w3c.b;
import w3c.f;
import w3c.g;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020'H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/bridge/DefaultItemViewBridge;", "Lcom/ss/android/lark/picker/base/view/binder/bridge/IItemViewBridge;", "holder", "Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;", "<init>", "(Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;)V", "avatarItemView", "Lcom/ss/android/lark/picker/base/view/avataritem/AvatarItemView;", BasicTestActionHandler.TEST_ACTION_RESET, "", "setPrimaryText", "text", "", "setSecondaryText", "setLeadingContent", "content", "Lcom/ss/android/lark/picker/base/view/binder/bridge/LeadingContent;", "setDynamicTag", "tag", "setExtraInfoSummary", "summary", "showMask", "show", "", "checkState", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/ss/android/lark/search/dto/bindermodel/CheckBoxModel;", "updateCheckState", "isChecked", "setOnItemClickListener", "listener", "Landroid/view/View$OnClickListener;", "setOnItemLongClickListener", "Landroid/view/View$OnLongClickListener;", "attachRightSideView", "view", "Landroid/view/View;", "setAvatar", "info", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class DefaultItemViewBridge implements IItemViewBridge {
    private final AvatarItemView avatarItemView;
    private final ChatterChatViewHolder holder;

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setDynamicTag(CharSequence r100) {
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setExtraInfoSummary(CharSequence r100) {
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void reset() {
        this.avatarItemView.resetAllViews();
    }

    public DefaultItemViewBridge(ChatterChatViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        this.holder = r100;
        this.avatarItemView = r100.getAvatarItemView().getItem();
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void attachRightSideView(View r100) {
        if (r100 != null) goto L4;
        this.avatarItemView.removeRightView();
        return;
    L4:
        AvatarItemView.attachRightView$default(this.avatarItemView, r100, false, false, 6, null);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void bindData(SearchBaseInfo r100) {
        IItemViewBridge.DefaultImpls.bindData(this, r100);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void checkState(b r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this.avatarItemView.checkState(r100);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setAvatar(SearchBaseInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        AvatarItemView r101 = this.avatarItemView;
        a.C7948a r102 = new a.C7948a();
        r102.b(r100.getAvatarKey());
        r102.f(r100.getId());
        r101.avatar(new a(r102));
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setLeadingContent(LeadingContent r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        if ((r100 instanceof LeadingContent.Avatar) == false) goto L6;
        AvatarItemView r101 = this.avatarItemView;
        a.C7948a r102 = new a.C7948a();
        LeadingContent.Avatar r103 = (LeadingContent.Avatar) r100;
        r102.b(r103.getKey());
        r102.f(r103.getId());
        r101.avatar(new a(r102));
        return;
    L6:
        if ((r100 instanceof LeadingContent.Icon) == false) goto L8;
        return;
    L8:
        if ((r100 instanceof LeadingContent.Initial) == false) goto L11;
        return;
    L11:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setOnItemClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.holder.itemView.setOnClickListener(r100);
        this.holder.getAvatarItemView().setOnClickListener(r100);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setOnItemLongClickListener(View.OnLongClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.holder.itemView.setOnLongClickListener(r100);
        this.holder.getAvatarItemView().setOnLongClickListener(r100);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setPrimaryText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.avatarItemView.title(new g(r100.toString(), false, 14));
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setSecondaryText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.avatarItemView.subTitle(new f(r100.toString()));
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void showMask(boolean r100) {
        if (r100 == false) goto L4;
        this.holder.getAvatarItemView().showShadow();
        return;
    L4:
        this.holder.getAvatarItemView().hideShadow();
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void updateCheckState(boolean r100) {
        this.avatarItemView.updateCheckState(r100);
    }
}
