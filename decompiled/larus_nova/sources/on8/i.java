package on8;

import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.larus.bmhome.video.ItemType;
import com.larus.im.bean.message.block.UgcItem;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i implements pr8.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f524396a;

    public i(j r100) {
        this.f524396a = r100;
    }

    @Override // pr8.f
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        b r101 = this.f524396a.f524398b;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // pr8.f
    public final void b(View r100, int r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        UgcItem r104 = (UgcItem) CollectionsKt.getOrNull(this.f524396a.f524397a.f524374b, r101);
        if (r104 == null) goto L8;
        b r105 = this.f524396a.f524398b;
        if (r105 == null) goto L9;
        r105.b(r100, r101, r102, r104);
        return;
    L9:
        return;
    }

    @Override // pr8.f
    public final void c(View r100, int r101, int r102, pr8.c r103) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        Integer r104 = r103.f530371e;
        int r105 = ItemType.VIDEO.getValue();
        if (r104 != null) goto L6;
    L10:
        b r106 = this.f524396a.f524398b;
        if (r106 == null) goto L16;
        r106.c(r100, r101, r102, r103);
        return;
    L16:
        return;
    L6:
        if (r104.intValue() != r105) goto L10;
        b r107 = this.f524396a.f524398b;
        if (r107 == null) goto L14;
        r107.d(r100, r101, r102, r103);
        return;
    }
}
