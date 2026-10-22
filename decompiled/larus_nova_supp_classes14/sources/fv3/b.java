package fv3;

import com.bytedance.applet.aibridge.calendar.ResultInfo;
import com.larus.platform.api.SdkCalendarErrorCode;
import com.larus.platform.api.b5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static final ResultInfo a(b5 r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "id");
        String r0 = r2.a;
        if (r2.b != SdkCalendarErrorCode.Success) goto L5;
        boolean r4 = true;
    L7:
        return new ResultInfo(r3, r4, r0);
    L5:
        r4 = false;
        goto L7
    }
}
