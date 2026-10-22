package com.ss.android.lark.profile_office.applink;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.applink.AppLink;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.profile.utils.IProfileLauncherV2;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import ova.d;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeAddFriendAppLinkHandler extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<Pattern> f438862a = null;

    public static final class a {
    }

    @Override // ova.p
    public final boolean b(Context r100, AppLink r101) {
        return true;
    }

    static {
        f438862a = LazyKt.lazy(OfficeAddFriendAppLinkHandler$Companion$CONTACT_URL_PATTERN$2.INSTANCE);
    }

    public OfficeAddFriendAppLinkHandler() {
    }

    @Override // ova.p
    public final boolean a(Context r110, AppLink r111) {
        boolean r100 = false;
        if (r110 != null) goto L5;
    L32:
        return false;
    L5:
        if (r111.f408912a.length() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L32;
        String r102 = r111.f408912a;
        if (f438862a.getValue().matcher(r102).matches() == false) goto L13;
    L15:
        String r103 = UriProtector.getQueryParameter(UriProtector.parse(r102), "token");
    L16:
        String r104 = r103;
        if (r104 != null) goto L19;
    L22:
        boolean r105 = true;
    L24:
        if (r105 == false) goto L27;
        Log.w("OfficeAddFriendAppLink", "token is empty, url=" + r111.f408912a);
        return false;
    L27:
        StringBuilder r112 = new StringBuilder("handle add friend appLink, hasToken=");
        if (r104.length() <= 0) goto L30;
        r100 = true;
    L30:
        r112.append(r100);
        Log.i("OfficeAddFriendAppLink", r112.toString());
        ContactSource r113 = new ContactSource();
        r113.setSourceType(1);
        IProfileLauncherV2.f438837a.getClass();
        IProfileLauncherV2.Companion.a().openUserProfileV2(r110, null, null, r104, Chatter.Type.USER, "", r113, -1);
        return true;
    L19:
        if (r104.length() == 0) goto L22;
        r105 = false;
        goto L24
    L13:
        if (Intrinsics.areEqual(UriProtector.parse(r102).getPath(), "/invitation/page/add_contact/") == true) goto L15;
        r103 = null;
        goto L16
    L7:
        r101 = false;
        goto L8
    }
}
