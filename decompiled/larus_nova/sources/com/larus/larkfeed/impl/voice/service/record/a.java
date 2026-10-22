package com.larus.larkfeed.impl.voice.service.record;

import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import kotlin.jvm.internal.Intrinsics;
import y58.d;

/* JADX INFO: loaded from: classes30.dex */
public final class a {
    public a() {
    }

    public static y58.a a(xac.a r210, abc.b r310) {
        Intrinsics.checkNotNullParameter(r210, "voiceContext");
        Intrinsics.checkNotNullParameter(r310, "recordDetail");
        String r100 = r310.f2524a;
        String r101 = r210.b("conversation_id");
        String r102 = "";
        if (r101 != null) goto L5;
        String r103 = "";
    L6:
        String r104 = r310.f2525b;
        String r211 = r210.b("bot_id");
        String r110 = r210.b(BindCardPayConfirmConstants.Key.TRACE_ID);
        if (r110 != null) goto L9;
        r110 = "";
    L9:
        String r105 = r210.b("enter_from");
        if (r105 == null) goto L13;
        r102 = r105;
    L13:
        d r106 = new d(r110, r102);
        return new y58.a(null, r100, r103, null, r104, false, false, null, null, 0, 0, null, 0, 0, false, 0, 0, null, null, r211, r106, 0, null, 218103785);
    L5:
        r103 = r101;
        goto L6
    }
}
