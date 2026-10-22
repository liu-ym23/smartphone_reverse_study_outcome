package r74;

import android.content.Context;
import com.bytedance.bdinstall.dtrait.constant.DTraitEnum;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f536457a = null;

        static {
            int[] r100 = new int[DTraitEnum.values().length];
            f536457a = r100;
            r100[DTraitEnum.COLLECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f536457a[DTraitEnum.FACTOR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static s74.a a(DTraitEnum r100, Context r101, p74.b r102, v74.a r103, v74.d r110, boolean r111) {
        int r104 = a.f536457a[r100.ordinal()];
        if (r104 == 1) goto L11;
        if (r104 == 2) goto L9;
        return null;
    L9:
        return new g(r101, r102, r103, r110, r111);
    L11:
        return new c(r101, r102, r103, r111);
    }
}
