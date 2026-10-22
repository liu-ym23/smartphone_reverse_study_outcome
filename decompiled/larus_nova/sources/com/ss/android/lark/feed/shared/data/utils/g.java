package com.ss.android.lark.feed.shared.data.utils;

import com.bytedance.lark.pb.basic.v1.Urgent;
import com.ss.android.lark.biz.im.api.UrgentInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public final class g {
    public static List<UrgentInfo> a(List<Urgent> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<Urgent> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L26;
        Urgent r103 = r102.next();
        if (r103 != null) goto L11;
        UrgentInfo r104 = null;
    L23:
        if (r104 == null) goto L7;
        r101.add(r104);
        goto L7
    L11:
        r104 = new UrgentInfo();
        r104.setId(r103.f253593id);
        r104.setMessageId(r103.message_id);
        r104.setSendTime(r103.send_time.longValue());
        Boolean r105 = r103.is_closed;
        boolean r106 = false;
        if (r105 != null) goto L14;
    L16:
        boolean r107 = false;
    L17:
        r104.setClosed(r107);
        Boolean r108 = r103.is_muted;
        if (r108 != null) goto L20;
    L22:
        r104.setMuted(r106);
        goto L23
    L20:
        if (r108.booleanValue() == false) goto L22;
        r106 = true;
        goto L22
    L14:
        if (r105.booleanValue() == false) goto L16;
        r107 = true;
        goto L17
    L26:
        return r101;
    }
}
