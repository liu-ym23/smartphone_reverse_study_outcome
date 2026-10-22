package l4;

import android.app.Activity;
import android.content.Context;
import androidx.core.content.ContextCompat;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import e3.d;
import e3.e;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import r4.i;

/* JADX INFO: loaded from: classes43.dex */
public final class c {
    public static final boolean a(Context r100, String[] r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        if (r101.length != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return true;
    L8:
        int r103 = r101.length;
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L17;
        if (ContextCompat.checkSelfPermission(r100, r101[r104]) != 0) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == false) goto L21;
        r104 = r104 + 1;
        goto L9
    L21:
        return false;
    L13:
        r105 = false;
        goto L14
    L17:
        return true;
    L5:
        r102 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Object, l4.a] */
    public static final void b(d r110, final String r111, String[] r112, final Function1<? super String, Unit> r113, final Function2<? super Context, ? super Activity, Unit> r114) {
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r111, "bridgeName");
        Intrinsics.checkNotNullParameter(r112, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r113, LynxVideoManagerLite.EVENT_ON_ERROR);
        Intrinsics.checkNotNullParameter(r114, "onGranted");
        final Context r100 = e.b(r110);
        if (r100 != null) goto L6;
        r113.invoke("context is null");
        return;
    L6:
        final Activity r101 = e.a(r110);
        if (a(r100, r112) == false) goto L10;
        r114.invoke(r100, r101);
        return;
    L10:
        if (r101 != null) goto L13;
        r113.invoke("activity is null");
        return;
    L13:
        ?? r115 = new a(r114, r100, r101, r113, r111);
        Intrinsics.checkNotNullParameter(r101, "activity");
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r111, "bridgeName");
        Intrinsics.checkNotNullParameter(r112, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r115, "onResult");
        if (a(r101, r112) == false) goto L16;
        r115.invoke(Boolean.TRUE);
        return;
    L16:
        i r102 = r4.a.f535979f;
        if (r102 != null) goto L19;
        r115.invoke(Boolean.FALSE);
        return;
    L19:
        r102.a(r101, r110, r111, (String[]) Arrays.copyOf(r112, r112.length), new b(r115));
    }
}
