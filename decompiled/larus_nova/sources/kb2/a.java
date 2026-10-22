package kb2;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.live.richcontent.model.style.ImageStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends kk6.a<jb2.c> {

    /* JADX INFO: renamed from: kb2.a$a, reason: collision with other inner class name */
    public static final class C6529a {
    }

    static {
    }

    public a() {
    }

    @Override // ik6.a
    public final String e(ek6.d r100) {
        jb2.c r101 = (jb2.c) r100;
        Intrinsics.checkNotNullParameter(r101, "content");
        String r102 = kk6.a.h(r101);
        if (TextUtils.equals(r102, "$") == false) goto L6;
        return "**";
    L6:
        return r102;
    }

    @Override // ik6.a
    public final void a(ik6.b r100, ek6.d r101, ek6.b r102, Drawable r103) {
        jb2.c r104 = (jb2.c) r101;
        Intrinsics.checkNotNullParameter(r100, "editor");
        Intrinsics.checkNotNullParameter(r104, "content");
        Intrinsics.checkNotNullParameter(r102, "resourceInfo");
        Intrinsics.checkNotNullParameter(r103, "drawable");
        pb2.a r105 = new pb2.a(r103);
        ImageStyle r106 = r104.f497988e;
        if (r106 != null) goto L5;
        r106 = kk6.a.f503812a;
    L5:
        r105.g(r106, r103.getIntrinsicWidth(), r103.getIntrinsicHeight());
        r105.f528409m = r104.f497990g;
        r100.b(r104, r105);
    }
}
