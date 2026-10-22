package jp;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.ec.window.base.search.recyclerview.vo.WindowSearchResultItemType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public class a extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WindowV2ProductItemVO f499927b;

    public a(WindowSearchResultItemType r100, WindowV2ProductItemVO r101) {
        Intrinsics.checkNotNullParameter(r100, "itemType");
        Intrinsics.checkNotNullParameter(r101, "storeV2ProductItemVO");
        super(r100);
        this.f499927b = r101;
    }
}
