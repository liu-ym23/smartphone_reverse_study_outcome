package u7;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.container.fragment.flavor.fail.FailSubFragmentProxy;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f549026a = 0;

    static {
    }

    @JvmStatic
    public static final FailSubFragmentProxy a(ViewGroup r100, Context r101, Map<String, String> r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "bizKey");
        ((ba.b) Annie.getService(ba.b.class, r103)).I(r101, r100);
        String r104 = r102.get("theme");
        if (Intrinsics.areEqual(r104, "sjb") == false) goto L6;
        return new com.bytedance.android.annie.container.fragment.flavor.fail.c(r101, r100);
    L6:
        if (Intrinsics.areEqual(r104, "dark") == false) goto L8;
        FailSubFragmentProxy r105 = new com.bytedance.android.annie.container.fragment.flavor.fail.a(r101, r100);
        Intrinsics.checkNotNullParameter(r102, "paramsOut");
        ((HashMap) r105.f39353g).clear();
        ((HashMap) r105.f39353g).putAll(r102);
    L10:
        return r105;
    L8:
        r105 = new com.bytedance.android.annie.container.fragment.flavor.fail.b(r101, r100);
        Intrinsics.checkNotNullParameter(r102, "paramsOut");
        ((HashMap) r105.f39353g).clear();
        ((HashMap) r105.f39353g).putAll(r102);
        goto L10
    }

    @JvmStatic
    public static final v7.b b(c r100, ViewGroup r101, Context r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "configModel");
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "bizKey");
        ((ba.b) Annie.getService(ba.b.class, r103)).q0(r102, r101);
        return new v7.a(r102, r101);
    }
}
