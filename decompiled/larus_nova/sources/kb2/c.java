package kb2;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.live.richcontent.model.style.ImageStyle;
import jb2.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends kk6.a<e> {
    public c() {
    }

    @Override // ik6.a
    public final String e(ek6.d r100) {
        e r101 = (e) r100;
        Intrinsics.checkNotNullParameter(r101, "content");
        String r102 = kk6.a.h(r101);
        if (TextUtils.equals(r102, "$") == false) goto L6;
        return "**";
    L6:
        return r102;
    }

    @Override // ik6.a
    public final void a(ik6.b r110, ek6.d r111, ek6.b r112, Drawable r113) {
        e r100 = (e) r111;
        Intrinsics.checkNotNullParameter(r110, "editor");
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r112, "resourceInfo");
        Intrinsics.checkNotNullParameter(r113, "drawable");
        int r101 = r100.getType();
        float r102 = 0.5f;
        if (r101 != 1) goto L5;
        float r103 = 0.57f;
        float r104 = 0.5f;
        float r105 = 0.5f;
        boolean r114 = true;
        int r115 = 4;
    L16:
        pb2.b r106 = new pb2.b(r113, r100.f497996e, r100.f497997f, r103, r104, r105, r114, r115);
        ImageStyle r107 = r100.f477653b;
        if (r107 != null) goto L19;
        r107 = kk6.a.f503812a;
    L19:
        r106.g(r107, r113.getIntrinsicWidth(), r113.getIntrinsicHeight());
        r106.f528409m = r100.f497998g;
        r110.a(r100, r106);
        return;
    L5:
        if (r101 != 2) goto L7;
        r102 = 0.47f;
        float r108 = 0.47f;
        float r109 = 0.6f;
    L14:
        r103 = r108;
        r105 = r109;
        r104 = r102;
        r114 = false;
        r115 = 0;
        goto L16
    L7:
        if (r101 == 3) goto L11;
        if (r101 != 4) goto L11;
        r108 = 0.54f;
    L12:
        r109 = 0.5f;
    L11:
        r108 = 0.5f;
        goto L12
    }
}
