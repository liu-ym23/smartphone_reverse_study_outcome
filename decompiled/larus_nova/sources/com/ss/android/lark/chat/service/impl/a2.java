package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.im.v1.SubscribeChatEventRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes35.dex */
public final class a2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Integer> f416449b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f416450a;

    public interface a {
    }

    static {
        f416449b = new ConcurrentHashMap();
    }

    public a2(i.a r100) {
        this.f416450a = r100;
    }

    public final void a(SubscribeChatEventRequest.SubscriptionKey r100) {
        ArrayList r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        Iterator r103 = ((ConcurrentHashMap) f416449b).entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L18;
        Map.Entry r104 = (Map.Entry) r103.next();
        if (r104 == null) goto L4;
        String r105 = (String) r104.getKey();
        if (r105 == null) goto L4;
        if (r104.getValue() == null) goto L17;
        if (((Integer) r104.getValue()).intValue() <= 0) goto L17;
        r101.add(r105);
    L17:
        r102.add(r105);
        r103.remove();
        goto L4
    L18:
        ((i.a) this.f416450a).f416510a.u2(r101, r102, r100);
    }
}
