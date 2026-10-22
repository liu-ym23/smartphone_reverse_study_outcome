package oo7;

import android.content.Context;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;

/* JADX INFO: loaded from: classes22.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f524633a;

    public static void a(Context r100, ShareContent r101, int r102, int r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        jn7.l r104 = eo7.a.b.f473353a.f473336j;
        if (r104 == null) goto L7;
        r104.e(r100, r101, r103);
        return;
    L7:
        jn7.l r105 = com.bytedance.ug.sdk.share.impl.manager.b.c();
        if (r105 == null) goto L12;
        r105.e(r100, r101, r103);
        return;
    }

    public static void b(Context r100, ShareContent r101, int r102, int r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        jn7.l r104 = eo7.a.b.f473353a.f473336j;
        if (r104 == null) goto L7;
        r104.h(r100, r103);
        return;
    L7:
        jn7.l r105 = com.bytedance.ug.sdk.share.impl.manager.b.c();
        if (r105 == null) goto L12;
        r105.h(r100, r103);
        return;
    }
}
