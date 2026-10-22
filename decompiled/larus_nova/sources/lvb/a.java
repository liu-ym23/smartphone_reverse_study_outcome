package lvb;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kub.e;

/* JADX INFO: loaded from: classes37.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final String d(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L13;
        return "";
    L13:
        if (r100.length() > 8) goto L17;
        return "***";
    L17:
        return r100.substring(0, 4) + '_' + r100.substring(r100.length() - 6);
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @JvmStatic
    public static final String f(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return "";
    L12:
        int r102 = StringsKt.indexOf$default(r100, '?', 0, false, 6, null);
        if (r102 < 0) goto L16;
        r100 = r100.substring(0, r102);
    L16:
        if (r100.length() > 32) goto L19;
        return r100;
    L19:
        return StringsKt.take(r100, 16) + "..." + StringsKt.takeLast(r100, 8);
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    @JvmStatic
    public static final void g(String r100) {
        Intrinsics.checkNotNullParameter("AudioRecordExtSource", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (Intrinsics.areEqual(OfficeSDKManager.isDebug(), Boolean.TRUE) == false) goto L7;
        e r101 = (e) OfficeSDKManager.getHostGlobalService(e.class);
        if (r101 == null) goto L7;
        r101.v("minutes_AudioRecordExtSource", r100);
    L7:
        Log.v("minutes_AudioRecordExtSource", r100);
    }

    @JvmStatic
    public static final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (Intrinsics.areEqual(OfficeSDKManager.isDebug(), Boolean.TRUE) == false) goto L8;
        Log.d("minutes_" + r100, r101);
        e r102 = (e) OfficeSDKManager.getHostGlobalService(e.class);
        if (r102 == null) goto L9;
        r102.d("minutes_" + r100, r101);
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Log.e("minutes_" + r100, r101, null, false);
        if (Intrinsics.areEqual(OfficeSDKManager.isDebug(), Boolean.TRUE) == false) goto L8;
        e r102 = (e) OfficeSDKManager.getHostGlobalService(e.class);
        if (r102 == null) goto L9;
        r102.e("minutes_" + r100, r101);
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Log.e("minutes_" + r100, r101, null, true);
    }

    @JvmStatic
    public static final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Log.i("minutes_" + r100, r101);
        if (Intrinsics.areEqual(OfficeSDKManager.isDebug(), Boolean.TRUE) == false) goto L8;
        e r102 = (e) OfficeSDKManager.getHostGlobalService(e.class);
        if (r102 == null) goto L9;
        r102.i("minutes_" + r100, r101);
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final void h(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Log.w("minutes_" + r100, r101);
        if (Intrinsics.areEqual(OfficeSDKManager.isDebug(), Boolean.TRUE) == false) goto L8;
        e r102 = (e) OfficeSDKManager.getHostGlobalService(e.class);
        if (r102 == null) goto L9;
        r102.w("minutes_" + r100, r101);
        return;
    L9:
        return;
    }
}
