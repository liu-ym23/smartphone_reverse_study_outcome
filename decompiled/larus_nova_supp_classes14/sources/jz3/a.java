package jz3;

import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.f;
import kotlin.jvm.internal.Intrinsics;
import r14.c;
import s14.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public final c a;
    public final f b;
    public final d c;
    public int d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;

    public a(c r2, f r3, d r4) {
        Intrinsics.checkNotNullParameter(r2, "aweme");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = -1;
    }

    public /* synthetic */ a(c r2, f r3, int r4) {
        if ((r4 & 2) == 0) goto L5;
        r3 = null;
    L5:
        this(r2, r3, null);
    }
}
