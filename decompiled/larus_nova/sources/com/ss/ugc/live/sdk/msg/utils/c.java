package com.ss.ugc.live.sdk.msg.utils;

import android.text.TextUtils;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import com.ss.ugc.live.sdk.msg.data.SdkMessage;
import com.ss.ugc.live.sdk.msg.data.SdkResponse;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWCustomData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f458473a = 0;

    static {
    }

    @JvmStatic
    public static final String a(List<com.ss.ugc.live.sdk.msg.network.d> r100) {
        if (r100 == null) goto L18;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        Object r102 = r101.next();
        if (StringsKt.equals("im-internal_ext", ((com.ss.ugc.live.sdk.msg.network.d) r102).f458296a, true) == false) goto L6;
    L11:
        com.ss.ugc.live.sdk.msg.network.d r103 = (com.ss.ugc.live.sdk.msg.network.d) r102;
        if (r103 != null) goto L14;
        return null;
    L14:
        return r103.f458297b;
    L10:
        r102 = null;
        goto L11
    L18:
        return null;
    }

    @JvmStatic
    public static final String b(List<UMGWCustomData> r100) {
        if (r100 == null) goto L26;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L15;
        Object r102 = r101.next();
        UMGWCustomData r103 = (UMGWCustomData) r102;
        boolean r104 = true;
        if (StringsKt.equals("im-internal_ext", r103.key, true) == true) goto L13;
        if (StringsKt.equals("internal_ext", r103.key, true) == true) goto L13;
        r104 = false;
    L13:
        if (r104 == false) goto L6;
    L16:
        UMGWCustomData r105 = (UMGWCustomData) r102;
        if (r105 != null) goto L19;
        return null;
    L19:
        return r105.value;
    L15:
        r102 = null;
        goto L16
    L26:
        return null;
    }

    @JvmStatic
    public static final String c(com.ss.ugc.live.sdk.msg.network.g r100) {
        if (r100 == null) goto L17;
        List<com.ss.ugc.live.sdk.msg.network.d> r101 = r100.f458313c;
        if (r101 == null) goto L17;
        Iterator<T> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if (StringsKt.equals(NetResponse.HEADER_KEY_LOG_ID, ((com.ss.ugc.live.sdk.msg.network.d) r103).f458296a, true) == false) goto L7;
    L12:
        com.ss.ugc.live.sdk.msg.network.d r104 = (com.ss.ugc.live.sdk.msg.network.d) r103;
        if (r104 == null) goto L17;
        String r105 = r104.f458297b;
        if (r105 == null) goto L17;
        return r105;
    L11:
        r103 = null;
    L17:
        return "";
    }

    @JvmStatic
    public static final String d(SdkResponse r100) {
        if (r100 == null) goto L9;
        List<SdkMessage> r101 = r100.messages;
        if (r101 == null) goto L9;
        List<SdkMessage> r102 = r101;
        Collection r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L7:
        if (r104.hasNext() == false) goto L11;
        SdkMessage r105 = (SdkMessage) r104.next();
        r103.add(r105.method + ':' + r105.msg_type + ':' + r105.msg_id);
    L11:
        return TextUtils.join(",", r103);
    L9:
        r103 = CollectionsKt.emptyList();
        goto L11
    }

    @JvmStatic
    public static final Long e(List<com.ss.ugc.live.sdk.msg.network.d> r100) {
        if (r100 == null) goto L20;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        Object r102 = r101.next();
        if (StringsKt.equals("im-now", ((com.ss.ugc.live.sdk.msg.network.d) r102).f458296a, true) == false) goto L6;
    L11:
        com.ss.ugc.live.sdk.msg.network.d r103 = (com.ss.ugc.live.sdk.msg.network.d) r102;
        if (r103 == null) goto L21;
        String r104 = r103.f458297b;
        if (r104 != null) goto L16;
        return null;
    L16:
        return StringsKt.toLongOrNull(r104);
    L21:
        return null;
    L10:
        r102 = null;
        goto L11
    L20:
        return null;
    }
}
