package n3b;

import android.content.Context;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import u2b.j;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements o3b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m2b.a f517013a;

    @Override // o3b.a
    public final int a() {
        return 32;
    }

    @Override // o3b.a
    public final int c() {
        return 56;
    }

    public b(m2b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "chatContext");
        this.f517013a = r100;
    }

    @Override // o3b.a
    public final int b(Context r100, Integer r101, boolean r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f517013a.m() == false) goto L6;
        return j.e(r100, r101, r104, r103);
    L6:
        if (this.f517013a.Y() == false) goto L11;
        if (r102 == false) goto L22;
        return j.i(r100, r103, r101, r104);
    L22:
        return j.j(r100, r103, r101, r104);
    L11:
        if (this.f517013a.q() == false) goto L16;
        if (r102 == false) goto L24;
        return j.k(r100, r101);
    L24:
        return j.l(r100, r101);
    L16:
        if (this.f517013a.r() == false) goto L19;
        return j.b(r100, r101);
    L19:
        return j.d(r100, r101);
    }

    @Override // o3b.a
    public final int d(Context r100, Integer r101, boolean r102, boolean r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f517013a.m() == true) goto L13;
        if (this.f517013a.Y() == true) goto L13;
        if (this.f517013a.q() == true) goto L13;
        if (this.f517013a.r() == true) goto L13;
        return j.a(r100, r101) - UIHelper.dp2px(2.0f);
    L13:
        if (this.f517013a.m() == false) goto L15;
    L19:
        boolean r103 = false;
    L21:
        return b(r100, r101, r102, r110, r103);
    L15:
        if (this.f517013a.Y() == false) goto L18;
        if (r102 == true) goto L19;
    L18:
        r103 = r111;
        goto L21
    }
}
