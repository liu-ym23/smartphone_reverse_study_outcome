package com.ss.ugc.live.sdk.msg.unify.business;

import com.ss.ugc.live.sdk.message.data.PayloadItemType;
import com.ss.ugc.live.sdk.msg.data.SdkMessage;
import com.ss.ugc.live.sdk.msg.data.SdkResponse;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWCustomData;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWEventData;
import imc.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import tlc.f;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f458350a;

    public b(a r100) {
        this.f458350a = r100;
    }

    public final void b(Object r100) {
        if ((r100 instanceof d) == true) goto L5;
        return;
    L5:
        d r101 = (d) r100;
        com.ss.ugc.live.sdk.msg.data.c r102 = r101.f458354c;
        SdkResponse r103 = r101.f458355d;
        UMGWEventData r104 = r101.f458352a;
        this.f458350a.f458340a = r102;
        String r105 = com.ss.ugc.live.sdk.msg.utils.c.b(r104.params);
        if (r105 != null) goto L9;
        r105 = r103.internal_ext;
    L9:
        if (r105 == null) goto L11;
        this.f458350a.f458341b = r105;
    L11:
        List<UMGWCustomData> r106 = r104.params;
        String r107 = null;
        if (r106 == null) goto L23;
        Iterator<T> r108 = r106.iterator();
    L15:
        if (r108.hasNext() == false) goto L19;
        Object r109 = r108.next();
        if (StringsKt.equals("im-cursor", ((UMGWCustomData) r109).key, true) == false) goto L15;
    L20:
        UMGWCustomData r110 = (UMGWCustomData) r109;
        if (r110 == null) goto L23;
        String r111 = r110.value;
    L24:
        if (r111 != null) goto L27;
        r111 = r103.cursor;
    L27:
        if (r111 == null) goto L29;
        this.f458350a.f458342c = r111;
    L29:
        List<UMGWCustomData> r112 = r104.params;
        if (r112 == null) goto L41;
        Iterator<T> r113 = r112.iterator();
    L33:
        if (r113.hasNext() == false) goto L37;
        Object r114 = r113.next();
        if (StringsKt.equals("im-live_cursor", ((UMGWCustomData) r114).key, true) == false) goto L33;
    L38:
        UMGWCustomData r115 = (UMGWCustomData) r114;
        if (r115 == null) goto L41;
        String r116 = r115.value;
    L42:
        if (r116 != null) goto L45;
        r116 = r103.live_cursor;
    L45:
        if (r116 == null) goto L47;
        a.f458338k = r116;
    L47:
        List<UMGWCustomData> r117 = r104.params;
        if (r117 == null) goto L59;
        Iterator<T> r118 = r117.iterator();
    L51:
        if (r118.hasNext() == false) goto L55;
        Object r119 = r118.next();
        if (StringsKt.equals("im-wrds_preload_ext", ((UMGWCustomData) r119).key, true) == false) goto L51;
    L56:
        UMGWCustomData r120 = (UMGWCustomData) r119;
        if (r120 == null) goto L59;
        r107 = r120.value;
        goto L59
    L55:
        r119 = null;
    L59:
        if (r107 == null) goto L71;
        a.f458339l = r107;
        return;
    L71:
        return;
    L37:
        r114 = null;
    L41:
        r116 = null;
        goto L42
    L19:
        r109 = null;
    L23:
        r111 = null;
        goto L24
    }

    @Override // imc.e
    public final d a(UMGWEventData r210, boolean r211, long r212) {
        long r100 = System.currentTimeMillis();
        if (r211 == false) goto L15;
        a r101 = this.f458350a;
        if (r101.f458349j == null) goto L15;
        int r102 = r101.f458345f;
        int r110 = r101.f458346g;
        String r111 = PayloadItemType.PAYLOAD_TYPE_UMGW.getType();
        byte[] r112 = r210.payload.toByteArray();
        List<UMGWCustomData> r103 = r210.params;
        if (r103 == null) goto L13;
        List<UMGWCustomData> r104 = r103;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L10:
        if (r106.hasNext() == false) goto L12;
        UMGWCustomData r107 = (UMGWCustomData) r106.next();
        r105.add(new com.ss.ugc.live.sdk.msg.network.d(r107.key, r107.value));
        goto L10
    L12:
        List r113 = r105;
    L14:
        SdkResponse r108 = SdkResponse.ADAPTER.decode(this.f458350a.f458349j.b(new f(r102, r110, r111, "pb", r112, r113, 0, 0)));
    L16:
        ArrayList r109 = new ArrayList();
        com.ss.ugc.live.sdk.msg.data.c r114 = new com.ss.ugc.live.sdk.msg.data.c();
        List<SdkMessage> r115 = r108.messages;
        if (r115 != null) goto L19;
    L22:
        boolean r116 = true;
    L23:
        if (r116 == true) goto L66;
        long r117 = System.currentTimeMillis();
        r114.f458240e = r108.messages.size();
        Iterator r118 = r108.messages.iterator();
    L26:
        if (r118.hasNext() == false) goto L62;
        SdkMessage r119 = (SdkMessage) r118.next();
        Long r120 = r108.now;
        if (r120 == null) goto L30;
        long r121 = r120.longValue();
    L31:
        List<UMGWCustomData> r122 = r210.params;
        int r123 = com.ss.ugc.live.sdk.msg.utils.c.f458473a;
        Long r124 = null;
        if (r122 == null) goto L46;
        Iterator r125 = r122.iterator();
    L35:
        if (r125.hasNext() == false) goto L40;
        Object r126 = r125.next();
        Iterator r127 = r118;
        Iterator r128 = r125;
        long r213 = r121;
        if (StringsKt.equals("im-now", ((UMGWCustomData) r126).key, true) == true) goto L41;
        r118 = r127;
        r125 = r128;
        r121 = r213;
    L41:
        UMGWCustomData r129 = (UMGWCustomData) r126;
        if (r129 == null) goto L47;
        String r130 = r129.value;
        if (r130 == null) goto L47;
        r124 = StringsKt.toLongOrNull(r130);
    L47:
        if (r124 == null) goto L49;
        long r131 = r124.longValue();
    L50:
        r119.timestamp = r131;
        tlc.d r132 = this.f458350a.f458348i.a(r119);
        if (r132 == null) goto L56;
        r132.setMessageMethod(r119.method);
        r132.setReceiveTime(r212);
        if ((r132 instanceof xlc.b) == false) goto L55;
        xlc.b r133 = (xlc.b) r132;
        r133.setWRDSMessage(r119.need_wrds_store.booleanValue());
        r133.setWRDSVersion(r119.wrds_version.longValue());
        r133.setWRDSSubKey(r119.wrds_sub_key);
    L55:
        r109.add(r132);
    L61:
        r118 = r127;
        goto L26
    L56:
        Long r134 = r119.msg_id;
        LinkedHashSet<Long> r135 = r114.f458241f;
        if (r134 == null) goto L59;
        long r136 = r134.longValue();
    L60:
        r135.add(Long.valueOf(r136));
        goto L61
    L59:
        r136 = -1;
        goto L60
    L49:
        r131 = r213;
        goto L50
    L40:
        r127 = r118;
        r213 = r121;
        r126 = null;
        goto L41
    L46:
        r127 = r118;
        r213 = r121;
        goto L47
    L30:
        r121 = System.currentTimeMillis();
        goto L31
    L62:
        long r137 = System.currentTimeMillis();
        Iterator r138 = r109.iterator();
    L64:
        if (r138.hasNext() == false) goto L66;
        tlc.d r139 = (tlc.d) r138.next();
        r139.setDecodeStartTime(r117);
        r139.setDecodeEndTime(r137);
    L66:
        r114.f458236a = r212;
        r114.f458237b = r100;
        r114.f458238c = System.currentTimeMillis();
        return new d(r210, r109, r114, r108);
    L19:
        if (r115.isEmpty() == true) goto L22;
        r116 = false;
        goto L23
    L13:
        r113 = CollectionsKt.emptyList();
    L15:
        r108 = SdkResponse.ADAPTER.decode(r210.payload);
        goto L16
    }
}
