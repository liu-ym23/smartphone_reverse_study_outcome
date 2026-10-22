package yt;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.net.URLDecoder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f569020a = 0;

    static {
    }

    public static void a(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r101, "userId");
        Uri.Builder r103 = UriProtector.parse("aweme://user/profile/" + r101).buildUpon();
        if (TextUtils.isEmpty("promote_detail_account_banner") == true) goto L6;
        r103.appendQueryParameter("enter_from", "promote_detail_account_banner");
    L6:
        if (TextUtils.isEmpty(r102) == true) goto L8;
        r103.appendQueryParameter("mob_report", URLDecoder.decode(r102));
    L8:
        com.bytedance.android.gamecp.host_api.a.b().getHostAction().handleSchema(r100, r103.build().toString(), new Bundle());
    }
}
