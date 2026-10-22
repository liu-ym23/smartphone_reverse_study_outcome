package s43;

import com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b;

/* JADX INFO: loaded from: classes12.dex */
public final class a {
    public static /* synthetic */ void a(String r100, String r101, int r102) {
        b r103 = b.f164354a;
        if ((r102 & 2) == 0) goto L6;
        r101 = "";
    L6:
        if ((r102 & 4) == 0) goto L8;
        long r104 = System.currentTimeMillis();
    L9:
        r103.a(r100, r101, r104);
        return;
    L8:
        r104 = 0;
        goto L9
    }
}
