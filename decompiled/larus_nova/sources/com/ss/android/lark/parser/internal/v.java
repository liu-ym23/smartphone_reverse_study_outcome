package com.ss.android.lark.parser.internal;

import android.util.Pair;
import com.bytedance.lark.pb.basic.v1.PickEntities;
import com.ss.android.lark.chat.entity.chat.PickChatEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f437635a = 0;

    static {
    }

    @JvmStatic
    public static final List<PickEntities> a(Collection<? extends PickChatEntity> r100) {
        Intrinsics.checkNotNullParameter(r100, "sourcePickEntities");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<? extends PickChatEntity> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L29;
        PickChatEntity r103 = r102.next();
        Integer r104 = Integer.valueOf(r103.f415165a);
        if (r104 != null) goto L9;
    L11:
        if (r104 != null) goto L14;
    L16:
        if (r104 != null) goto L19;
    L21:
        PickEntities.PickType r105 = PickEntities.PickType.UNKNOWN;
    L22:
        Pair r106 = (Pair) r101.get(r105);
        if (r106 != null) goto L25;
        PickEntities.Builder r107 = new PickEntities.Builder().pick_type(r105);
        Pair r108 = new Pair(new ArrayList(), r107);
        r101.put(r105, r108);
        r106 = r108;
    L25:
        List r109 = (List) r106.first;
        String r110 = r103.f415166b;
        if (r110 != null) goto L28;
        r110 = "";
    L28:
        r109.add(r110);
        goto L4
    L19:
        if (r104.intValue() != 3) goto L21;
        r105 = PickEntities.PickType.DEPT;
        goto L22
    L14:
        if (r104.intValue() != 1) goto L16;
        r105 = PickEntities.PickType.USER;
        goto L22
    L9:
        if (r104.intValue() != 2) goto L11;
        r105 = PickEntities.PickType.CHAT;
        goto L22
    L29:
        ArrayList r111 = new ArrayList(r101.values().size());
        Iterator r112 = r101.values().iterator();
    L31:
        if (r112.hasNext() == false) goto L33;
        Pair r113 = (Pair) r112.next();
        PickEntities.Builder r114 = (PickEntities.Builder) r113.second;
        r114.pick_ids((List) r113.first);
        r111.add(r114.build());
        goto L31
    L33:
        return r111;
    }
}
