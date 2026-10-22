package com.bytedance.android.window.shop.search.recyclerview.holder;

import android.view.View;
import com.bytedance.android.ec.window.base.search.recyclerview.vo.WindowSearchResultItemType;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import jp.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vq3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/window/shop/search/recyclerview/holder/WindowSearchResultViewHolder;", "Lcom/bytedance/android/window/shop/search/recyclerview/holder/WindowBaseSearchResultViewHolder;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowSearchResultViewHolder extends WindowBaseSearchResultViewHolder {
    public static final /* synthetic */ int d = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.search.recyclerview.holder.WindowBaseSearchResultViewHolder
    public final void T3(b r3) {
        Intrinsics.checkNotNullParameter(r3, "vo");
        QUIManager r0 = this.a;
        if (r0 == null) goto L6;
        r0.c(d.class, ((jp.a) r3).b);
        return;
    }

    public WindowSearchResultViewHolder(QUIManager r2, View r3, WindowSearchResultItemType r4) {
        Intrinsics.checkNotNullParameter(r2, "uiManager");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "type");
        super(r2, r3, r4);
    }
}
