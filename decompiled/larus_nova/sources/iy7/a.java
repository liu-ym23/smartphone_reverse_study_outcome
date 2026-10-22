package iy7;

import com.lark.kmp.containerization.c;
import com.lark.kmp.containerization.d;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import gy7.q;
import gy7.r;
import gy7.s;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f496568a = 0;

    static {
    }

    public static com.lark.kmp.containerization.b a() {
        Map<d<?>, c<?>> r100 = com.lark.kmp.containerization.a.f278584a;
        return com.lark.kmp.containerization.a.a(b.f496569a).a(Unit.INSTANCE);
    }

    public static com.lark.kmp.containerization.b b(q r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Map<d<?>, c<?>> r101 = com.lark.kmp.containerization.a.f278584a;
        d<q> r102 = b.f496570b;
        com.lark.kmp.containerization.b r103 = com.lark.kmp.containerization.a.a(r102).a(r100);
        if (r103 != null) goto L9;
        c r104 = com.lark.kmp.containerization.a.a(r102);
        Map<q, q> r105 = s.f483352a;
        q r106 = s.a(r.f483351a);
        if (r106 == null) goto L8;
        return r104.b(r106, null);
    L8:
        throw new IllegalStateException("can not find absent user session");
    L9:
        return r103;
    }
}
