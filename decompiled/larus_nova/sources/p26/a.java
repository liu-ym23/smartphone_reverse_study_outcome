package p26;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ies.bullet.schema.param.GravityType;
import kotlin.jvm.internal.Intrinsics;
import t36.d;
import y36.i;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends i<GravityType> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // t36.c
    public final String a() {
        GravityType r100 = (GravityType) this.f565862b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getValue();
    }

    @Override // y36.i
    public final GravityType d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "string");
        GravityType[] r101 = GravityType.values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        GravityType r104 = r101[r103];
        if (Intrinsics.areEqual(r100, r104.getValue()) == true) goto L12;
        r103 = r103 + 1;
        goto L3
    L12:
        return r104;
    L8:
        return null;
    }

    public a(d r100, GravityType r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(GXTemplateKey.GAIAX_LAYER_GRAVITY, "key");
        super(null);
        b(r100, GXTemplateKey.GAIAX_LAYER_GRAVITY, r101);
    }
}
