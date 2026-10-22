package com.ss.android.lark.coremd.facade.setspan;

import com.ss.android.lark.coremd.base.parse.q;
import com.ss.android.lark.coremd.facade.bizext.IMThemeExtend;
import com.ss.android.lark.coremd.facade.bizext.props.IMImageExtend;
import com.ss.android.lark.coremd.facade.bizext.theme.IMImageThemeData;
import com.ss.android.lark.coremd.impl.parse.i;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import v7b.l;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements q<l> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f419813b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, String> f419814a;

    /* JADX INFO: renamed from: com.ss.android.lark.coremd.facade.setspan.a$a, reason: collision with other inner class name */
    public static final class C4947a {
    }

    static {
    }

    public a() {
        this.f419814a = new HashMap();
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(final i r100) {
        Intrinsics.checkNotNullParameter(r100, "parseContext");
        final IMImageThemeData r101 = (IMImageThemeData) IMThemeExtend.f419630s.b(new IMImageSpanProducer$produceSpanImpl$themeData$1(r100));
        return com.ss.android.lark.coremd.ext.i.a(IMImageExtend.class, new IMImageSpanProducer$produceSpanImpl$1(this, r100, r101));
    }
}
