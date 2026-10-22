package com.bytedance.sync.v2.process.flag;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sync.model.DataType;
import com.bytedance.sync.v2.protocal.BsyncHeader;
import com.bytedance.sync.v2.protocal.BsyncPacket;
import com.bytedance.sync.v2.protocal.BsyncTopic;
import com.bytedance.sync.v2.protocal.Flag;
import com.bytedance.sync.v2.protocal.TopicType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import xf7.m;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends a implements com.bytedance.sync.v2.process.e<Flag> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f270525e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final xf7.g f270526f;

    public static String e(mg7.d r100) {
        String r101 = r100.f513776m;     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r101) == true) goto L13;
        List<String> r102 = new Regex(":").split(r101, 0);     // Catch: Throwable -> L15
        if (r102 == null) goto L12;
        Object[] r103 = r102.toArray(new String[0]);     // Catch: Throwable -> L15
        if (r103 == null) goto L10;
        String[] r104 = (String[]) r103;     // Catch: Throwable -> L15
        return r104[r104.length - 1];
    L10:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L15
    L12:
        throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");     // Catch: Throwable -> L15
    L13:
        return null;
    }

    @Override // com.bytedance.sync.v2.process.e
    public final boolean a(Flag r100) {
        if (r100 != Flag.Data) goto L5;
        return true;
    L5:
        return false;
    }

    public final void g(ArrayList<mg7.d> r110) {
        mg7.d r100 = (mg7.d) ListProtector.get(r110, 0);     // Catch: Throwable -> L19
        f(r100.f513770g, r100.f513777n, e(r100));     // Catch: Throwable -> L19
        int r101 = RangesKt.coerceAtMost(0, cg7.b.c(this.f270525e).b().g());     // Catch: Throwable -> L19
        if (r101 > 0) goto L6;
        return;
    L6:
        d().G(r110);     // Catch: Throwable -> L19
        String r102 = e(r100);     // Catch: Throwable -> L19
        List<mg7.d> r111 = d().I(r100.f513777n, r100.f513770g, r102, r101);     // Catch: Throwable -> L19
        if (r111 != null) goto L9;
        return;
    L9:
        if (r111.isEmpty() == true) goto L27;
        d().v0(r111);     // Catch: Throwable -> L19
        yf7.d r103 = (yf7.d) rgc.b.a(yf7.d.class);     // Catch: Throwable -> L19
        Iterator<mg7.d> r112 = r111.iterator();     // Catch: Throwable -> L19
    L13:
        if (r112.hasNext() == false) goto L29;
        mg7.d r104 = r112.next();     // Catch: Throwable -> L19
        if (r104.f513772i != DataType.FILE_PATH) goto L13;
        r103.g(new String(r104.f513768e, Charsets.UTF_8));     // Catch: Throwable -> L19
    L29:
        return;
    L27:
        return;
    }

    public i(Context r100, xf7.g r101) {
        super(r100);
        this.f270525e = r100;
        this.f270526f = r101;
    }

    @Override // com.bytedance.sync.v2.process.e
    public final void b(int r210, BsyncHeader r211, List<BsyncTopic> r212) {
        LinkedHashMap r100 = new LinkedHashMap();
        Iterator<T> r101 = r212.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Object r102 = r101.next();
        Long r103 = ((BsyncTopic) r102).sync_id;
        Object r104 = r100.get(r103);
        if (r104 != null) goto L8;
        r104 = new ArrayList();
        r100.put(r103, r104);
    L8:
        ((List) r104).add(r102);
        goto L4
    L9:
        Iterator r105 = r100.entrySet().iterator();
    L11:
        if (r105.hasNext() == false) goto L85;
        Map.Entry r106 = (Map.Entry) r105.next();
        long r107 = ((Number) r106.getKey()).longValue();
        List r108 = (List) r106.getValue();
        mg7.c r109 = d().A(r107);     // Catch: Exception -> L83
        if (r109 == null) goto L15;
        if (a.c(r107, r211, r109) == false) goto L18;
        zf7.b.d("local cursor info -> " + r109);
        List r110 = CollectionsKt.sortedWith(r108, new g());
        ArrayList r111 = new ArrayList();
        Iterator r112 = CollectionsKt.sortedWith(r110, new h()).iterator();
    L21:
        if (r112.hasNext() == false) goto L26;
        BsyncTopic r113 = (BsyncTopic) r112.next();
        if (r113.ref_cursor.longValue() <= r109.f513762f) goto L24;
        zf7.b.b(r113.ref_cursor + " > " + r109.f513762f + ", server cursor > db cursor when patch syncId = " + r107);
        goto L21
    L24:
        r111.addAll(r113.packets);
        goto L21
    L26:
        ArrayList r114 = new ArrayList();
        Iterator r115 = r111.iterator();
    L28:
        if (r115.hasNext() == false) goto L35;
        Object r116 = r115.next();
        if (((BsyncPacket) r116).cursor.cursor.longValue() <= r109.f513762f) goto L32;
        boolean r117 = true;
    L33:
        if (r117 == false) goto L28;
        r114.add(r116);
        goto L28
    L32:
        r117 = false;
        goto L33
    L35:
        LinkedHashMap r118 = new LinkedHashMap();
        Iterator r119 = r114.iterator();
    L37:
        if (r119.hasNext() == false) goto L42;
        Object r120 = r119.next();
        Integer r121 = ((BsyncPacket) r120).payload.business;
        Object r122 = r118.get(r121);
        if (r122 != null) goto L41;
        r122 = new ArrayList();
        r118.put(r121, r122);
    L41:
        ((List) r122).add(r120);
        goto L37
    L42:
        Iterator r123 = r118.values().iterator();
    L44:
        if (r123.hasNext() == false) goto L11;
        List r124 = (List) r123.next();
        BsyncTopic r125 = (BsyncTopic) CollectionsKt.first(r110);
        ArrayList<mg7.d> r126 = new ArrayList();
        TopicType r127 = r125.topic_type;
        d().n(String.valueOf(r107), ((BsyncPacket) CollectionsKt.first(r124)).payload.business.intValue());
        ArrayList r128 = new ArrayList();
        Iterator r129 = r124.iterator();
    L47:
        if (r129.hasNext() == false) goto L55;
        Object r130 = r129.next();
        List r131 = r110;
        if (((BsyncPacket) r130).cursor.cursor.longValue() <= r109.f513762f) goto L51;
        boolean r132 = true;
    L52:
        if (r132 == false) goto L54;
        r128.add(r130);
    L54:
        r110 = r131;
        goto L47
    L51:
        r132 = false;
        goto L52
    L55:
        List r133 = r110;
        List r134 = CollectionsKt.toMutableList(r128);
        if (r134.size() <= 1) goto L58;
        CollectionsKt.sortWith(r134, new e());
    L58:
        Iterator r135 = r134.iterator();
    L60:
        if (r135.hasNext() == false) goto L74;
        long r136 = ((BsyncPacket) r135.next()).payload.business.intValue();     // Catch: Throwable -> L73
        TopicType r137 = r125.topic_type;     // Catch: Throwable -> L73
        String r138 = r125.req_id;     // Catch: Throwable -> L73
        if (TextUtils.isEmpty(r138) == true) goto L70;
        if (r138 == null) goto L70;
        List r139 = StringsKt.split$default(r138, new String[]{":"}, false, 0, 6, null);     // Catch: Throwable -> L86
        if (r139 == null) goto L70;
        String r140 = (String) CollectionsKt.last(r139);     // Catch: Throwable -> L86
    L71:
        f(r136, r137, r140);     // Catch: Throwable -> L73
    L70:
        r140 = null;
        goto L71
    L74:
        mg7.c r141 = new mg7.c(r109);
        r141.f513762f = r125.new_cursor.longValue();
        if (r126.isEmpty() == false) goto L91;
        zf7.b.a("history sync logs is empty,throw it ,syncId = " + r107);
    L82:
        r110 = r133;
        goto L44
    L91:
        zf7.b.a("save history_sync_logs to db : " + r141 + " + " + r126);     // Catch: Exception -> L80
        d().G(r126);     // Catch: Exception -> L80
        g(r126);     // Catch: Exception -> L80
    L80:
        e = move-exception;
        m.c().ensureNotReachHere(e, "execute sql failed when handler history database");
        e.printStackTrace();
        goto L82
    L18:
        zf7.b.b("info not match when handle " + r107 + '.');
        goto L11
    L15:
        zf7.b.b(r107 + " can't be found in local db");
    L83:
        e = move-exception;
        e.printStackTrace();
        m.c().ensureNotReachHere(e, "execute sql failed when queryLocalSyncCursorInfo when receive data");
        goto L11
    }

    public final void f(long r100, TopicType r101, String r102) {
        int r103 = f.f270524a[r101.ordinal()];     // Catch: Throwable -> L26
        if (r103 != 1) goto L6;
        Object r104 = ((HashMap) this.f270526f.f563464k).get(String.valueOf(r101.getValue()) + ":" + r100);     // Catch: Throwable -> L26
        if (r104 != null) goto L24;
        Intrinsics.throwNpe();     // Catch: Throwable -> L26
    L24:
        ((gg7.d) r104).getClass();     // Catch: Throwable -> L26
        return;
    L6:
        if (r103 == 2) goto L15;
        if (r103 != 3) goto L30;
        Object r105 = ((HashMap) this.f270526f.f563464k).get(String.valueOf(r101.getValue()) + ":" + r100);     // Catch: Throwable -> L26
        if (r105 != null) goto L13;
        Intrinsics.throwNpe();     // Catch: Throwable -> L26
    L13:
        ((gg7.d) r105).getClass();     // Catch: Throwable -> L26
        return;
    L30:
        return;
    L15:
        if (TextUtils.isEmpty(r102) == false) goto L17;
        return;
    L17:
        Object r106 = ((HashMap) this.f270526f.f563464k).get(String.valueOf(r101.getValue()) + ":" + r100 + ":" + r102);     // Catch: Throwable -> L26
        if (r106 != null) goto L20;
        Intrinsics.throwNpe();     // Catch: Throwable -> L26
    L20:
        ((gg7.d) r106).getClass();     // Catch: Throwable -> L26
        return;
    }
}
