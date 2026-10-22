package nr3;

import android.content.Context;
import android.content.res.Resources;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.rts.foundation.j;
import com.bytedance.rts.foundation.r;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated(message = "请使用 com.bytedance.salamander:core 中提供的 RelaxImageRedirectListener")
public final class a implements kpa.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f520170a;

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f520170a = r100;
    }

    @Override // kpa.a
    public final String a(String r100) {
        if (r100 != null) goto L5;
        return r100;
    L5:
        if (r.g(r100, "sl://") == false) goto L21;
        ArrayList<String> r101 = r.f(r.e(r100, 5, r100.length()), HTTP.URL_DEFAULT, -1);
        if (j.d(r101) != 2) goto L22;
        String r102 = (String) ListProtector.get(r101, 0);
        String r103 = (String) ListProtector.get(r101, 1);
        Context r104 = this.f520170a;
        Integer r105 = null;
        Context r106 = null;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
        r104 = null;
    L12:
        Resources r107 = r104.getResources();
        if (r107 == null) goto L20;
        Context r108 = this.f520170a;
        if (r108 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L18:
        r105 = Integer.valueOf(r107.getIdentifier(r103, r102, r106.getPackageName()));
        goto L20
    L17:
        r106 = r108;
    L20:
        return "res:///" + r105;
    L22:
        return r100;
    L21:
        return r100;
    }
}
