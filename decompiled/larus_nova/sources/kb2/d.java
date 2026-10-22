package kb2;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import com.bytedance.live.richcontent.model.style.ImageStyle;
import jb2.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d extends kk6.a<f> {
    public d() {
    }

    @Override // ik6.a
    public final String e(ek6.d r100) {
        f r101 = (f) r100;
        Intrinsics.checkNotNullParameter(r101, "content");
        String r102 = kk6.a.h(r101);
        if (TextUtils.equals(r102, "$") == false) goto L6;
        return "**";
    L6:
        return r102;
    }

    @Override // ik6.a
    public final void a(ik6.b r100, ek6.d r101, ek6.b r102, Drawable r103) {
        f r104 = (f) r101;
        Intrinsics.checkNotNullParameter(r100, "editor");
        Intrinsics.checkNotNullParameter(r104, "content");
        Intrinsics.checkNotNullParameter(r102, "resourceInfo");
        Intrinsics.checkNotNullParameter(r103, "drawable");
        if ((r103 instanceof NinePatchDrawable) == false) goto L5;
        NinePatchDrawable r105 = (NinePatchDrawable) r103;
        pb2.a r106 = new pb2.c(r105, r104.f497999d, r104.f498000e, r105.getMinimumHeight() * r104.f498001f);
    L6:
        ImageStyle r107 = r104.f477653b;
        if (r107 != null) goto L9;
        r107 = kk6.a.f503812a;
    L9:
        r106.g(r107, r103.getIntrinsicWidth(), r103.getIntrinsicHeight());
        r106.f528409m = r104.f498002g;
        r100.a(r104, r106);
        return;
    L5:
        r106 = new pb2.a(r103);
        goto L6
    }
}
