package wvb;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.CloseReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {
    public static final void a(uub.a r100, FragmentActivity r101, CloseReason r102) {
        Intrinsics.checkNotNullParameter(r102, "reason");
        if (r100 != null) goto L9;
        if (r101 == null) goto L6;
        r101.finish();
    L6:
        lvb.a.e("MmRecordPageRouter", "[closePageOnErrorOrNativeFallback] navigator is null, finish activity, reason=" + r102);
        return;
    L9:
        if (r102.unexpectedError() == false) goto L16;
        boolean r103 = r100.n0();
        if (r103 == true) goto L14;
        if (r101 == null) goto L14;
        r101.finish();
    L14:
        lvb.a.e("MmRecordPageRouter", "[closePageOnErrorOrNativeFallback] unexpectedError, closeApplet=" + r103 + ", reason=" + r102);
        return;
    L16:
        lvb.a.e("MmRecordPageRouter", "[closePageOnErrorOrNativeFallback] skip normal close, reason=" + r102);
    }
}
