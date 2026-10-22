package ex2;

import android.app.Activity;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.marketing.sdk.impl.utils.CommonUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class c {
    public static final String a(com.bytedance.android.marketing.sdk.api.c r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getBizId");
        Object r101 = r100.f162681l.get(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID);
        if (r101 == null) goto L6;
        String r102 = r101.toString();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public static final String b(com.bytedance.android.marketing.sdk.api.c r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getEnterFrom");
        Object r101 = r100.f162681l.get("enter_from");
        if (r101 == null) goto L6;
        String r102 = r101.toString();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public static final String c(com.bytedance.android.marketing.sdk.api.c r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getPageClassName");
        Fragment r101 = r100.f162685p;
        if (r101 == null) goto L6;
        return r101.getClass().getSimpleName();
    L6:
        if (r100.getActivity() == null) goto L10;
        Activity r102 = r100.getActivity();
        if (r102 != null) goto L16;
    L13:
        return "";
    L16:
        return r102.getClass().getSimpleName();
    L10:
        CommonUtils.f162812a.getClass();
        Activity r103 = CommonUtils.c();
        if (r103 == null) goto L13;
        return r103.getClass().getSimpleName();
    }

    public static final String d(com.bytedance.android.marketing.sdk.api.c r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getPageId");
        Fragment r101 = r100.f162685p;
        if (r101 == null) goto L10;
        String r102 = String.valueOf(r101.hashCode());
        if (r102 != null) goto L8;
        return "";
    L8:
        return r102;
    L10:
        if (r100.getActivity() == null) goto L18;
        Activity r103 = r100.getActivity();
        if (r103 == null) goto L26;
        String r104 = String.valueOf(r103.hashCode());
        if (r104 != null) goto L17;
        return "";
    L17:
        return r104;
    L26:
        return "";
    L18:
        CommonUtils.f162812a.getClass();
        Activity r105 = CommonUtils.c();
        if (r105 == null) goto L28;
        String r106 = String.valueOf(r105.hashCode());
        if (r106 != null) goto L24;
        return "";
    L24:
        return r106;
    L28:
        return "";
    }

    public static final String e(com.bytedance.android.marketing.sdk.api.c r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getPageName");
        Object r101 = r100.f162681l.get("page_name");
        if (r101 == null) goto L6;
        String r102 = r101.toString();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public static final String f(com.bytedance.android.marketing.sdk.api.c r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getServicePageName");
        String r102 = null;
        if (r101 != null) goto L5;
    L9:
        r101 = e(r100);
        if ((!StringsKt.isBlank(r101)) == true) goto L13;
        r101 = null;
    L13:
        if (r101 != null) goto L18;
        Activity r103 = r100.getActivity();
        if (r103 == null) goto L17;
        r101 = r103.getClass().getSimpleName();
        goto L18
    L17:
        r101 = null;
    L18:
        if (r101 != null) goto L23;
        Fragment r104 = r100.f162685p;
        if (r104 == null) goto L22;
        r101 = r104.getClass().getSimpleName();
        goto L23
    L22:
        r101 = null;
    L23:
        if (r101 != null) goto L27;
        FrameLayout r105 = r100.f162671b;
        if (r105 == null) goto L28;
        r102 = r105.getClass().getSimpleName();
    L28:
        if (r102 != null) goto L31;
        return "";
    L31:
        return r102;
    L27:
        r102 = r101;
        goto L28
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 != null) goto L13;
        goto L9
    }
}
