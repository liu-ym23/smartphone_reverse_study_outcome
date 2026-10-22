package jp;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.ec.window.base.search.recyclerview.vo.WindowSearchResultItemType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e extends a {
    public e(WindowV2ProductItemVO r100) {
        Intrinsics.checkNotNullParameter(r100, "storeV2ProductItemVO");
        super(WindowSearchResultItemType.SEARCH_RESULT, r100);
    }
}
