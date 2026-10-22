package com.ss.android.lark.picker.base.view.binder.bridge;

import android.view.View;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w3c.b;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0016H&J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0011H&¨\u0006#"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/bridge/IItemViewBridge;", "", BasicTestActionHandler.TEST_ACTION_RESET, "", "setPrimaryText", "text", "", "setSecondaryText", "setLeadingContent", "content", "Lcom/ss/android/lark/picker/base/view/binder/bridge/LeadingContent;", "setDynamicTag", "tag", "setExtraInfoSummary", "summary", "showMask", "show", "", "setOnItemClickListener", "listener", "Landroid/view/View$OnClickListener;", "setOnItemLongClickListener", "Landroid/view/View$OnLongClickListener;", "attachRightSideView", "view", "Landroid/view/View;", "setAvatar", "info", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "bindData", "checkState", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/ss/android/lark/search/dto/bindermodel/CheckBoxModel;", "updateCheckState", "isChecked", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IItemViewBridge {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void bindData(IItemViewBridge r100, SearchBaseInfo r101) {
            Intrinsics.checkNotNullParameter(r101, "info");
        }
    }

    void attachRightSideView(View r100);

    void bindData(SearchBaseInfo r100);

    void checkState(b r100);

    void reset();

    void setAvatar(SearchBaseInfo r100);

    void setDynamicTag(CharSequence r100);

    void setExtraInfoSummary(CharSequence r100);

    void setLeadingContent(LeadingContent r100);

    void setOnItemClickListener(View.OnClickListener r100);

    void setOnItemLongClickListener(View.OnLongClickListener r100);

    void setPrimaryText(CharSequence r100);

    void setSecondaryText(CharSequence r100);

    void showMask(boolean r100);

    void updateCheckState(boolean r100);
}
