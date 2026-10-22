package qb2;

import android.text.SpannableString;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.livesdk.interactivity.service.richcontent.LiveRichContentEngine;
import com.bytedance.live.richcontent.engine.SpanRendClient;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f532288a = null;

    static {
        f532288a = new g(0, true, 1.0f);
    }

    public static ak6.a a(a5 r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "callBack");
        g r102 = f532288a;
        return LiveRichContentEngine.a().a().c(mb2.d.a(r100, null, 1.0f), r102, new b(r101));
    }

    public static SpannableString c(tb2.d r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "renderText");
        if (r101 == null) goto L6;
        g r102 = r101.f532290b;
        if (r102 == null) goto L6;
    L7:
        SpanRendClient r103 = LiveRichContentEngine.a().a();
        int r104 = mb2.c.f512775a;
        return r103.e(mb2.c.c(r100, r102.f532291i, "normal"), r102).f4074a;
    L6:
        r102 = f532288a;
        goto L7
    }

    public static void b(tb2.d r100, e r101, f r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, "renderText");
        Intrinsics.checkNotNullParameter(r101, "callBack");
        if (r102 == null) goto L9;
        g r104 = r102.f532290b;
        if (r104 == null) goto L9;
    L10:
        int r105 = mb2.c.f512775a;
        ek6.e r106 = mb2.c.c(r100, r104.f532291i, "normal");
        LiveRichContentEngine.a().a().c(r106, r104, new b(r101));
        return;
    L9:
        r104 = f532288a;
        goto L10
    }
}
