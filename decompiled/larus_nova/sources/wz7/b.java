package wz7;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import sz7.v;

/* JADX INFO: loaded from: classes24.dex */
public final class b extends c<a> {
    public b() {
    }

    @Override // wz7.c
    public final Drawable a(Context r100, d r101) {
        a r102 = (a) r101;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r103 = v.f544033a;
        if (v.a.a() == false) goto L8;
        if (r102 == null) goto L9;
        rz7.a.f539978a.getDocIconProvider().b();
        return null;
    L9:
        return null;
    L8:
        return null;
    }
}
