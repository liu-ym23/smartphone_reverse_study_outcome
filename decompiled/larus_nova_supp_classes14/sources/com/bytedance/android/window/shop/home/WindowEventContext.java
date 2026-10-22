package com.bytedance.android.window.shop.home;

import com.bytedance.android.ec.core.event.BaseEventContext;
import com.bytedance.android.ec.core.event.eventdumper.EventParamProvider;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\t\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/window/shop/home/WindowEventContext;", "Lcom/bytedance/android/ec/core/event/BaseEventContext;", "viewModel", "Lcom/bytedance/android/window/shop/home/viewmodel/ECWindowViewModel;", "(Lcom/bytedance/android/window/shop/home/viewmodel/ECWindowViewModel;)V", "followStatus", "", "getFollowStatus", "()Ljava/lang/String;", "init", "", "newParams", "", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowEventContext extends BaseEventContext {
    private final ECWindowViewModel viewModel;

    @EventParamProvider("follow_status")
    public final String getFollowStatus() {
        return String.valueOf(com.bytedance.android.shopping.extensions.k.g(this.viewModel.getShopParam().getFollowStatus(), 0));
    }

    public WindowEventContext(ECWindowViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.viewModel = r2;
    }

    public final void init(Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "newParams");
        Iterator<Map.Entry<String, String>> r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        Map.Entry<String, String> r0 = r5.next();
        String r1 = r0.getKey();
        String r2 = r0.getValue();
        if (r2 == null) goto L4;
        getExtraParams().put(r1, r2);
        goto L4
    }
}
