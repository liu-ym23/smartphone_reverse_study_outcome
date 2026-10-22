package com.larus.home.impl.route;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.utils.ReferenceMessage;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class u {
    public static final void a(Bundle r100, Uri r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r102 == null) goto L6;
        r100.putString("auto_send_text", r102.getString("auto_send_text"));
        r100.putString(ReferenceMessage.KEY_REFERENCE_TEXT, r102.getString(ReferenceMessage.KEY_REFERENCE_TEXT));
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        Iterator<T> r103 = UriProtector.getQueryParameterNames(r101).iterator();
    L10:
        if (r103.hasNext() == false) goto L12;
        String r104 = (String) r103.next();
        r100.putString(r104, UriProtector.getQueryParameter(r101, r104));
        goto L10
    }
}
