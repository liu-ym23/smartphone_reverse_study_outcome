package s53;

import com.bytedance.android.ec.core.widget.flow.TagFlowLayout;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductSkuStruct;
import com.bytedance.android.shopping.anchorv3.comment.sku.viewmodel.CommentSkuViewModel;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class j implements TagFlowLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PromotionProductSkuStruct f540728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f540729b;

    public j(PromotionProductSkuStruct r100, h r101) {
        this.f540728a = r100;
        this.f540729b = r101;
    }

    @Override // com.bytedance.android.ec.core.widget.flow.TagFlowLayout.b
    public final void a(int r100) {
        h r101 = this.f540729b;
        String r102 = this.f540728a.getSpecKey();
        List<String> r103 = this.f540728a.getSpecNameList();
        if (r103 == null) goto L5;
        String r104 = (String) CollectionsKt.getOrNull(r103, r100);
    L6:
        if (r102 != null) goto L8;
        r101.getClass();
        return;
    L8:
        if (r101.f540723j.containsKey(r102) == true) goto L10;
        if (r104 == null) goto L16;
        r101.e0(r102, null, r104);
        String r105 = r101.f540723j.put(r102, r104);
    L16:
        CommentSkuViewModel r106 = r101.f540719f;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L19:
        r106.getSkuRequestInfo().e(r101.f540723j);
        return;
    L10:
        if (Intrinsics.areEqual((String) ((LinkedHashMap) r101.f540723j).get(r102), r104) == false) goto L12;
        r101.f540723j.remove(r102);
        r101.e0(r102, r104, r104);
        goto L16
    L12:
        if (r104 == null) goto L16;
        r101.e0(r102, (String) ((LinkedHashMap) r101.f540723j).get(r102), r104);
        String r107 = r101.f540723j.put(r102, r104);
        goto L16
    L5:
        r104 = null;
        goto L6
    }
}
