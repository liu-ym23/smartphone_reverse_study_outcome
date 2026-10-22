package com.larus.luckydog.impl;

import android.app.Activity;
import android.content.ComponentName;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class j {
    public static final boolean a() {
        List<Activity> r100 = AppHost.f326268a.a().g();
        boolean r101 = false;
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L20;
        ComponentName r103 = ((Activity) r102.next()).getComponentName();
        if (r103 == null) goto L17;
        String r104 = r103.getClassName();
        if (r104 == null) goto L17;
        if (StringsKt.contains$default(r104, "ChatActivity", false, 2, null) != true) goto L17;
        boolean r105 = true;
    L18:
        if (r105 == false) goto L9;
        r101 = true;
    L17:
        r105 = false;
    L20:
        FLogger.f375446a.i("LuckyDogUtil", "hasChatActivity: " + r101);
        return r101;
    L5:
        if (r100.isEmpty() == false) goto L7;
        goto L7
    }

    public static final boolean b(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = String.valueOf(UriProtector.getQueryParameter(r100, "luckydog_cross_ack_time"));     // Catch: Exception -> L10
        if (Intrinsics.areEqual(r101, "1") == true) goto L13;
        if (Intrinsics.areEqual(r101, "2") == false) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L15:
        return false;
    }

    public static final boolean c(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = String.valueOf(UriProtector.getQueryParameter(r100, "luckydog_cross_reack_install"));     // Catch: Exception -> L8
        if (Intrinsics.areEqual(r101, "1") == true) goto L11;
        Intrinsics.areEqual(r101, "2");     // Catch: Exception -> L8
        return false;
    L11:
        return true;
    L12:
        return false;
    }
}
