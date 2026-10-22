package ha6;

import android.view.View;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {
    public static ba6.d a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = r100.getTag(R.id.android_yata_view_node);
        if ((r101 instanceof ba6.d) == false) goto L5;
        ba6.d r102 = (ba6.d) r101;
    L6:
        if (r102 != null) goto L8;
        YaTaLog.b("YataViewTagExt", "yataTagGetNode result is null");
    L8:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public static final String b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = r100.getTag(R.id.android_yata_view_key);
        if ((r101 instanceof String) == false) goto L5;
        String r102 = (String) r101;
    L6:
        if (r102 != null) goto L8;
        YaTaLog.b("YataViewTagExt", "yataTagGetNodeKey result is null");
    L8:
        return r102;
    L5:
        r102 = null;
        goto L6
    }
}
