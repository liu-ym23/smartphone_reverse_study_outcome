package com.larus.bmhome.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d2 implements s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f314999a;

    @Override // com.larus.bmhome.utils.s0
    public final void a() {
    }

    public d2(boolean r100) {
        this.f314999a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.utils.s0
    public final List<xc8.b> filter(List<? extends xc8.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        int r101 = 0;
    L4:
        if (r101 >= r100.size()) goto L9;
        if (com.larus.bmhome.chat.bean.d.G0(((xc8.b) ListProtector.get(r100, r101)).getMessage()) == true) goto L9;
        r101 = r101 + 1;
    L9:
        if (r101 >= r100.size()) goto L25;
        int r102 = r101 + 1;
        if (r102 >= r100.size()) goto L25;
        if (com.larus.bmhome.chat.bean.d.G0(((xc8.b) ListProtector.get(r100, r102)).getMessage()) == false) goto L25;
        Map<String, String> r103 = ((xc8.b) ListProtector.get(r100, r101)).getMessage().getBusinessExt();
        String r104 = null;
        if (r103 == null) goto L17;
        String r105 = r103.get("message_group_id");
    L18:
        Map<String, String> r106 = ((xc8.b) ListProtector.get(r100, r102)).getMessage().getBusinessExt();
        if (r106 == null) goto L22;
        r104 = r106.get("message_group_id");
    L22:
        if (Intrinsics.areEqual(r105, r104) == false) goto L25;
        r101 = r102;
        goto L9
    L17:
        r105 = null;
    L25:
        if (this.f314999a == false) goto L39;
        if (r101 >= r100.size()) goto L36;
        int r107 = r101 + 1;
        if (r107 >= r100.size()) goto L36;
        Message r108 = ((xc8.b) ListProtector.get(r100, r101)).getMessage();
        Message r109 = ((xc8.b) ListProtector.get(r100, r107)).getMessage();
        if (Intrinsics.areEqual(r108.getSectionId(), r109.getSectionId()) == true) goto L34;
    L35:
        boolean r110 = true;
    L37:
        if (r110 == false) goto L39;
    L40:
        ArrayList r111 = new ArrayList();
        Iterator r112 = r100.iterator();
        int r113 = 0;
    L42:
        if (r112.hasNext() == false) goto L54;
        Object r114 = r112.next();
        int r115 = r113 + 1;
        if (r113 >= 0) goto L46;
        CollectionsKt.throwIndexOverflow();
    L46:
        xc8.b r116 = (xc8.b) r114;
        if (r113 > r101) goto L49;
        boolean r117 = true;
    L50:
        if (r117 == false) goto L52;
        r111.add(r114);
    L52:
        r113 = r115;
        goto L42
    L49:
        r117 = false;
        goto L50
    L54:
        return r111;
    L34:
        if (com.larus.bmhome.chat.bean.d.z0(r109) == true) goto L35;
    L36:
        r110 = false;
    L39:
        if (this.f314999a == false) goto L40;
        return r100;
    }
}
