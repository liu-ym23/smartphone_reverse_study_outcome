package com.larus.bmhome.chat.component.list.pipeline.direct_add;

import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.utils.p0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import td8.c;
import td8.d;
import wc9.e;
import xc8.b;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f301199a;

    @Override // td8.c
    public final boolean a(int r100, b r101, b r102, List<? extends b> r103) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r103, "input");
        return true;
    }

    public a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContext");
        this.f301199a = r100;
    }

    @Override // td8.c
    public final List<b> b(int r510, b r511, b r512, List<b> r513) {
        Intrinsics.checkNotNullParameter(r512, "current");
        Intrinsics.checkNotNullParameter(r513, "input");
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = r513.iterator();
    L3:
        boolean r102 = true;
        if (r101.hasNext() == false) goto L14;
        Object r103 = r101.next();
        Integer r104 = b0.c(((b) r103).getMessage());
        if (r104 != null) goto L9;
    L11:
        r102 = false;
    L12:
        if (r102 == true) goto L3;
        r100.add(r103);
        goto L3
    L9:
        if (r104.intValue() != 14) goto L11;
    L14:
        ArrayList r105 = new ArrayList();
        int r106 = UserActiveDeleteTipHelper.f301196a;
        int r107 = ra9.a.f536860a;
        String r108 = ga9.a.e("delete_msg_tip_display", "0");
        String r109 = null;
        if (Intrinsics.areEqual(r108, "0") == false) goto L18;
        UserActiveDeleteTipHelper.DeleteMsgTipDisplay r110 = null;
    L21:
        if (r110 == null) goto L23;
        LinkedHashSet r111 = new LinkedHashSet();
        Iterator r112 = r100.iterator();
    L26:
        if (r112.hasNext() == false) goto L38;
        b r113 = (b) r112.next();
        int r114 = UserActiveDeleteTipHelper.f301196a;
        List r115 = UserActiveDeleteTipHelper.e(r113.getMessage());
        ArrayList r116 = new ArrayList();
        Iterator r117 = r115.iterator();
    L29:
        if (r117.hasNext() == false) goto L34;
        Object r118 = r117.next();
        if (r111.add((String) r118) == false) goto L29;
        r116.add(r118);
        goto L29
    L34:
        if ((!r116.isEmpty()) == false) goto L36;
        r105.add(new cg8.c(UserActiveDeleteTipHelper.a(r113.getMessage(), r116, r110)));
    L36:
        r105.add(r113);
        goto L26
    L38:
        if (this.f301199a.e() == false) goto L67;
        int r119 = UserActiveDeleteTipHelper.f301196a;
        int r120 = p0.f375454a;
        e r121 = this.f301199a.g();
        if (r121 == null) goto L42;
        String r122 = r121.f559215r;
    L43:
        JSONObject r123 = p0.b(r122);
        if (r123 != null) goto L46;
        List r124 = CollectionsKt.emptyList();
    L50:
        b r125 = (b) CollectionsKt.lastOrNull(r100);
        if (r125 == null) goto L54;
        Message r126 = r125.getMessage();
        if (r126 == null) goto L54;
    L58:
        ArrayList r127 = new ArrayList();
        Iterator r128 = r124.iterator();
    L60:
        if (r128.hasNext() == false) goto L65;
        Object r129 = r128.next();
        if (r111.add((String) r129) == false) goto L60;
        r127.add(r129);
        goto L60
    L65:
        if ((true ^ r127.isEmpty()) == false) goto L67;
        r105.add(new cg8.c(UserActiveDeleteTipHelper.a(r126, r127, r110)));
    L54:
        e r130 = this.f301199a.g();
        if (r130 == null) goto L57;
        r109 = r130.f559198a;
    L57:
        r126 = new Message(r109, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -2, 31, null);
        goto L58
    L46:
        String r131 = r123.optString("suffix_active_delete_message_id_list");
        if (StringsKt.isBlank(r131) == false) goto L49;
        r131 = r123.optString("sub_active_msg_id_list");
    L49:
        r124 = UserActiveDeleteTipHelper.b(r131);
        goto L50
    L42:
        r122 = null;
    L67:
        return r105;
    L23:
        return CollectionsKt.toMutableList(r100);
    L18:
        if (Intrinsics.areEqual(r108, "2") == false) goto L20;
        r110 = UserActiveDeleteTipHelper.DeleteMsgTipDisplay.RECALL;
        goto L21
    L20:
        r110 = UserActiveDeleteTipHelper.DeleteMsgTipDisplay.DELETE;
        goto L21
    }
}
