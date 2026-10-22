package te;

import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import kotlin.jvm.internal.Intrinsics;
import vd.b;
import wd.d;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ToolbarMatchInterface f545551a;

    @Override // vd.b
    public final String getComponentExtra() {
        return this.f545551a.getComponentExtra();
    }

    public a(ToolbarMatchInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "realHandler");
        this.f545551a = r100;
    }

    @Override // vd.b
    public final void a(ak2.a r100) {
        if ((r100 instanceof d) == false) goto L5;
        this.f545551a.setExtraDataAfterCheck(com.bytedance.android.ec.adapter.impl.converter.b.a(r100));
        return;
    L5:
        this.f545551a.setExtraDataAfterCheck(r100);
    }
}
