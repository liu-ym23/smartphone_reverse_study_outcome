package com.larus.security.api;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.im.bean.message.Message;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.platform.service.z2;
import com.larus.utils.p0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes31.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f367857a = 0;

    static {
    }

    public static Object b(List r110, int r111, Continuation r112) {
        AzerothUtils r100 = AzerothUtils.f367839a;
        if (z2.f365865a.L1() == true) goto L8;
        if (r111 != 1) goto L6;
    L7:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        Object r102 = Unit.INSTANCE;
    L66:
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L69;
        return r102;
    L69:
        return Unit.INSTANCE;
    L11:
        ArrayList r103 = new ArrayList();
        Iterator r104 = r110.iterator();
    L13:
        if (r104.hasNext() == false) goto L60;
        Message r105 = (Message) r104.next();
        String r106 = r105.getMessageId();
        String r107 = r105.getSectionId();
        if (r106 != null) goto L17;
    L20:
        boolean r108 = true;
    L21:
        if (r108 == true) goto L13;
        if (r107 != null) goto L24;
    L27:
        boolean r109 = true;
    L28:
        if (r109 == true) goto L13;
        Iterator r113 = CollectionsKt.listOf(new String[]{"inner_log_id", "asr_log_id"}).iterator();
    L31:
        if (r113.hasNext() == false) goto L13;
        String r114 = (String) r113.next();
        Map<String, String> r115 = r105.getExt();
        AzerothUtils.BatchTokenItem r116 = null;
        if (r115 == null) goto L35;
        String r117 = r115.get(r114);
    L36:
        if (r117 != null) goto L38;
    L41:
        boolean r118 = true;
    L42:
        if (r118 == true) goto L31;
        AzerothUtils r119 = AzerothUtils.f367839a;
        String r120 = AzerothUtils.b(r117, r107, r106);
        if (r120 != null) goto L46;
    L49:
        boolean r121 = true;
    L50:
        if (r121 == true) goto L31;
        AzerothUtils.BatchTokenItem r122 = new AzerothUtils.BatchTokenItem(r117, r120);
        if (r122.getToken().length() <= 0) goto L54;
        boolean r123 = true;
    L56:
        if (Boxing.boxBoolean(r123).booleanValue() == false) goto L58;
        r116 = r122;
    L58:
        r103.add(r116);
        goto L31
    L54:
        r123 = false;
        goto L56
    L46:
        if (r120.length() == 0) goto L49;
        r121 = false;
        goto L50
    L38:
        if (r117.length() == 0) goto L41;
        r118 = false;
        goto L42
    L35:
        r117 = null;
        goto L36
    L24:
        if (r107.length() == 0) goto L27;
        r109 = false;
        goto L28
    L17:
        if (r106.length() == 0) goto L20;
        r108 = false;
        goto L21
    L60:
        if ((!r103.isEmpty()) == false) goto L64;
        int r124 = p0.f375454a;
        r102 = HttpExtKt.k(ServiceType.BASIC_SERVICE, AzerothUtils.SaveTokenObject.class, "/alice/debug/save_token", p0.b(GsonProtectorUtils.toJson(new Gson(), new AzerothUtils.SaveTokenObject(null, null, r103, "", Boxing.boxInt(r111), Boxing.boxInt(0), 3, null))), null, null, false, null, null, null, r112, 1008);
        if (r102 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L66;
    L64:
        r102 = Unit.INSTANCE;
        goto L66
    L6:
        if (r111 == 3) goto L7;
    L8:
        r101 = false;
        goto L9
    }

    public static Object a(Message r100, int r101, Integer r102, String r103, Continuation r110) {
        Object r104 = AzerothUtils.f367839a.a(r100, r101, r102, r103, r110);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r104;
    L6:
        return Unit.INSTANCE;
    }
}
