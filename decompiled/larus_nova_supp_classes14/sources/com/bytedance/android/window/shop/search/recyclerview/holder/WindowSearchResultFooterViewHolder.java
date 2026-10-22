package com.bytedance.android.window.shop.search.recyclerview.holder;

import android.widget.TextView;
import com.bytedance.android.ec.window.base.search.recyclerview.vo.WindowSearchResultFooterNoticeVO;
import com.bytedance.android.ec.window.base.search.recyclerview.vo.WindowSearchResultItemType;
import jp.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/window/shop/search/recyclerview/holder/WindowSearchResultFooterViewHolder;", "Lcom/bytedance/android/window/shop/search/recyclerview/holder/WindowBaseSearchResultViewHolder;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowSearchResultFooterViewHolder extends WindowBaseSearchResultViewHolder {
    public static final /* synthetic */ int e = 0;
    public final TextView d;

    public static final class a {
    }

    static {
    }

    public WindowSearchResultFooterViewHolder(TextView r3) {
        Intrinsics.checkNotNullParameter(r3, "footerView");
        super(null, r3, WindowSearchResultItemType.FOOTER_VIEW);
        this.d = r3;
    }

    @Override // com.bytedance.android.window.shop.search.recyclerview.holder.WindowBaseSearchResultViewHolder
    public final void T3(b r2) {
        Intrinsics.checkNotNullParameter(r2, "vo");
        this.d.setText(((WindowSearchResultFooterNoticeVO) r2).b.getDescription());
    }
}
