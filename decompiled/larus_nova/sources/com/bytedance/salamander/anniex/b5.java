package com.bytedance.salamander.anniex;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class b5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f267980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f267981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<b5> f267982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONObject f267983d;

    public final z4 a(y4 r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.c("AnnieXRedirectTag", "try match redirect rule: curRuleDetail: " + this.f267983d);
        h5 r101 = e1.f268043a;
        int r102 = this.f267980a;
        g5 r103 = (g5) ((LinkedHashMap) r101.f268100a).get(Integer.valueOf(r102));
        if (r103 != null) goto L6;
        r103 = new g8();
    L6:
        if (r103.a(this) == true) goto L8;
        return null;
    L8:
        a5 r104 = r100.f268528f;
        if (r104 == null) goto L13;
        q2 r105 = r104.f267953a;
        if (r105 == null) goto L13;
        JSONArray r106 = r105.f268313i;
    L14:
        if (r106 == null) goto L16;
        Intrinsics.checkNotNull(r104);
        JSONArray r107 = r104.f267953a.f268313i;
        Integer r108 = Integer.valueOf(this.f267980a);
        Intrinsics.checkNotNullParameter(r107, "jsonArr");
        Intrinsics.checkNotNullParameter(r108, "value");
        int r109 = or3.a.f524932a;
        Intrinsics.checkNotNullParameter(r107, "jsonArr");
        Intrinsics.checkNotNullParameter(r108, "value");
        r107.put(r108);
    L16:
        String r110 = this.f267981b;
        if (r110 == null) goto L20;
        Intrinsics.checkNotNull(r110);
        return new z4(r110);
    L20:
        if (this.f267982c == null) goto L31;
        int r111 = 0;
    L22:
        ArrayList<b5> r112 = this.f267982c;
        Intrinsics.checkNotNull(r112);
        if (r111 >= com.bytedance.rts.foundation.j.d(r112)) goto L33;
        ArrayList<b5> r113 = this.f267982c;
        Intrinsics.checkNotNull(r113);
        z4 r114 = ((b5) ListProtector.get(r113, r111)).a(r100);
        if (r114 != null) goto L32;
        r111 = r111 + 1;
        goto L22
    L32:
        return r114;
    L33:
        return null;
    L31:
        return null;
    L13:
        r106 = null;
        goto L14
    }

    public b5(int r100, String r101, ArrayList<b5> r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r103, "curRuleJSONObject");
        int r104 = g5.f268083b;
        this.f267980a = -1;
        this.f267983d = com.bytedance.anniex.bd.foundation.impl.o.c();
        this.f267980a = r100;
        this.f267981b = r101;
        this.f267982c = r102;
        this.f267983d = r103;
    }
}
