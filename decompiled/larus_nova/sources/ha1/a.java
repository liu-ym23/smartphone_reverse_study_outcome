package ha1;

import android.text.TextUtils;
import com.bytedance.android.live.schema.api.WebcastRedirectReportInfo;
import com.bytedance.android.live.schema.api.c;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements c {
    public a() {
    }

    @Override // com.bytedance.android.live.schema.api.c
    public final void c(com.bytedance.android.live.schema.api.b r100, WebcastRedirectReportInfo r101, Function1<? super com.bytedance.android.live.schema.api.a, Unit> r102, Function3<? super Integer, ? super String, ? super Boolean, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r101, "reportInfo");
        Intrinsics.checkNotNullParameter(r102, "success");
        Intrinsics.checkNotNullParameter(r103, "fail");
        r101.a("schema_source", "default");
        String r104 = r100.f100498f;
        if (r104 == null) goto L10;
        String r105 = UriProtector.parse(r104).getHost();
        if (TextUtils.equals(r105, "webcast_lynxview") == false) goto L7;
    L8:
        r101.a("get_type", "default");
        r102.invoke(new com.bytedance.android.live.schema.api.a(r104));
        return;
    L7:
        if (TextUtils.equals(r105, "webcast_webview") == true) goto L8;
    L10:
        r103.invoke(1001, "default schema " + r100.f100498f, Boolean.FALSE);
    }
}
