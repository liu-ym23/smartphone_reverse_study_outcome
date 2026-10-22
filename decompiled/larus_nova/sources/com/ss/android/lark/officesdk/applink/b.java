package com.ss.android.lark.officesdk.applink;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.log.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f433098a = null;

    static {
        f433098a = SetsKt.setOf(new String[]{"http", "https", "lark", "feishu"});
    }

    public static Uri a(String r100) {
        Uri r101 = UriProtector.parse(r100);     // Catch: Exception -> L35
        if (r101.isHierarchical() == false) goto L34;
        String r102 = r101.getHost();     // Catch: Exception -> L35
        boolean r103 = false;
        if (r102 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == true) goto L34;
        Set<String> r105 = f433098a;     // Catch: Exception -> L35
        if ((r105 instanceof Collection) == true) goto L17;
    L19:
        Iterator<T> r106 = r105.iterator();     // Catch: Exception -> L35
    L21:
        if (r106.hasNext() == false) goto L25;
        if (StringsKt.equals((String) r106.next(), r101.getScheme(), true) == false) goto L21;
    L26:
        if (r103 == false) goto L29;
        return null;
    L29:
        if (Intrinsics.areEqual(r101.getPath(), "/client/chat/chatter/add_by_link") == true) goto L42;
        if (Intrinsics.areEqual(r101.getPath(), "/client/chat/chatter/add_by_link/") == true) goto L42;
        return null;
    L42:
        return r101;
    L25:
        r103 = true;
        goto L26
    L17:
        if (r105.isEmpty() == false) goto L19;
    L8:
        if (StringsKt.isBlank(r102) == true) goto L11;
        r104 = false;
    L34:
        return null;
    L35:
        Log.w("OfficeSDKGroupInviteLink", "parse group invite link failed");
        return null;
    }
}
