package com.ss.android.lark.coremd.facade.setspan;

import com.ss.android.lark.coremd.base.parse.q;
import com.ss.android.lark.coremd.facade.bizext.props.IMMediaExtend;
import com.ss.android.lark.coremd.impl.parse.i;
import eab.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements q<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f419815a = 0;

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(final i r100) {
        Intrinsics.checkNotNullParameter(r100, "parseContext");
        return com.ss.android.lark.coremd.ext.i.a(IMMediaExtend.class, new IMMediaSpanProducer$produceSpanImpl$1(this, r100));
    }
}
