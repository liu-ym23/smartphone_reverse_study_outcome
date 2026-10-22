package com.ss.android.lark.coremdbiz.facade.image;

import com.ss.android.lark.coremd.impl.parse.i;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkContextExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkImageExtend;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements com.ss.android.lark.coremd.base.parse.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f420078b = null;

    static {
        f420078b = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.a
    public final com.ss.android.lark.coremd.base.parse.a.b a(final i r100, final int r101, final int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r103 = ((Number) LarkContextExtend.f419979s.b(new LarkImageSizeProvider$provideSizeForLoadImage$maxMarkdownWidth$1(r100))).intValue();
        final Ref.FloatRef r104 = new Ref.FloatRef();
        r104.element = 1.0f;
        if (r103 <= 0) goto L9;
        if (r103 == Integer.MAX_VALUE) goto L9;
        if (r103 >= r101) goto L9;
        r104.element = r103 / r102;
    L9:
        return (com.ss.android.lark.coremd.base.parse.a.b) LarkImageExtend.f420017g.b(new LarkImageSizeProvider$provideSizeForLoadImage$1(r101, r104, r102));
    }
}
