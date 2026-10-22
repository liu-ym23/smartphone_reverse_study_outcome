package zy9;

import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.im.bean.message.CreationItem;
import com.larus.uaigc.chat.block.correction.CorrectionImageView;
import com.larus.uaigc.chat.block.correction.f;
import com.larus.uaigc.chat.block.correction.n;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f573983a;

    public b(c r100) {
        this.f573983a = r100;
    }

    @Override // com.larus.uaigc.chat.block.correction.n
    public final void b(SimpleDraweeView r100) {
        Intrinsics.checkNotNullParameter(r100, "bindView");
        a r101 = this.f573983a.f573986c;
        if (r101 == null) goto L13;
        List<CreationItem> r102 = r101.f573981b;
        if (r102 == null) goto L14;
        CreationItem r103 = (CreationItem) CollectionsKt.firstOrNull(r102);
        if (r103 == null) goto L16;
        f r104 = this.f573983a.f573985b;
        if (r104 == null) goto L15;
        r104.a(r100, r103);
        return;
    L15:
        return;
    L16:
        return;
    L14:
        return;
    }

    @Override // com.larus.uaigc.chat.block.correction.n
    public final void a(CorrectionImageView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        f r102 = this.f573983a.f573985b;
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }
}
