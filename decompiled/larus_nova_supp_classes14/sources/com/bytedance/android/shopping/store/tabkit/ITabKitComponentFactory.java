package com.bytedance.android.shopping.store.tabkit;

import android.content.Context;
import com.bytedance.android.shopping.store.tabkit.view.BottomTabItemView;
import com.bytedance.android.shopping.store.tabkit.view.TopTabItemView;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u0012\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/ITabKitComponentFactory;", "", "Lcom/bytedance/android/shopping/store/tabkit/model/k;", "tab", "", "isSubTab", "Lcom/bytedance/android/shopping/store/tabkit/TabKitAbilityConfig;", "config", "Lcom/bytedance/android/shopping/store/tabkit/TabKitTabFragment;", "createTab", "Landroid/content/Context;", "context", "Lcom/bytedance/android/shopping/store/tabkit/view/TopTabItemView;", "createTopTabItemView", "Lcom/bytedance/android/shopping/store/tabkit/view/BottomTabItemView;", "createBottomTabItemView", "getDisableBottomBar", "()Z", "disableBottomBar", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ITabKitComponentFactory {
    BottomTabItemView createBottomTabItemView(Context r1);

    TabKitTabFragment createTab(com.bytedance.android.shopping.store.tabkit.model.k r1, boolean r2, TabKitAbilityConfig r3);

    TopTabItemView createTopTabItemView(Context r1);

    boolean getDisableBottomBar();
}
