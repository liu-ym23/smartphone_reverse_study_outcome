package y36;

import com.bytedance.ies.bullet.service.sdk.param.PopupType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class l extends i<PopupType> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // t36.c
    public final String a() {
        PopupType r100 = (PopupType) this.f565862b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getValue();
    }

    public static PopupType e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "string");
        PopupType[] r101 = PopupType.values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        PopupType r104 = r101[r103];
        if (Intrinsics.areEqual(r100, r104.getValue()) == true) goto L10;
        if (Intrinsics.areEqual(r100, r104.getAliasValue()) == true) goto L10;
        r103 = r103 + 1;
    L10:
        return r104;
    L11:
        return null;
    }

    @Override // y36.i
    public final PopupType c(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if ((r100 instanceof Integer) == false) goto L5;
        Integer r101 = (Integer) r100;
    L6:
        if (r101 == null) goto L10;
        PopupType r102 = e(String.valueOf(r101.intValue()));
        if (r102 == null) goto L10;
        return r102;
    L10:
        return (PopupType) super.c(r100);
    L5:
        r101 = null;
        goto L6
    }

    @Override // y36.i
    public final /* bridge */ /* synthetic */ PopupType d(String r100) {
        return e(r100);
    }

    public l(t36.d r100, String r101, PopupType r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "key");
        super(null);
        b(r100, r101, r102);
    }
}
