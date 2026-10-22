package fv3;

import com.bytedance.applet.aibridge.calendar.ResultInfo;
import com.larus.platform.api.SdkCalendarErrorCode;
import com.larus.platform.api.b5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b {
    public static final ResultInfo a(b5 r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "id");
        String r102 = r100.f364873a;
        if (r100.f364874b != SdkCalendarErrorCode.Success) goto L5;
        boolean r103 = true;
    L7:
        return new ResultInfo(r101, r103, r102);
    L5:
        r103 = false;
        goto L7
    }
}
