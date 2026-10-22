package com.bytedance.locallife.biz.screenshot;

import android.database.ContentObserver;
import android.net.Uri;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public class b extends ContentObserver {

    public static final class a {
    }

    static {
    }

    public b(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r100) {
        super.onChange(r100);
        HostServiceUtilsKt.E();
        au6.a r101 = HostServiceUtilsKt.d0();
        r101.b();
        r101.isAppBackground();
        r101.isUserAgreePrivacyPolicy();
        HostServiceUtilsKt.c().log(5, "ScreenShotObserver", "onChange: do nothing because u didn't agree to the privacy policy");
    }
}
