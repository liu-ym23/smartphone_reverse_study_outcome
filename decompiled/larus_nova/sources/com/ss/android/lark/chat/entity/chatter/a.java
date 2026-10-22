package com.ss.android.lark.chat.entity.chatter;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Chatter> f415194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Map<String, ChatChatter>> f415195b;

    public final Map<String, ChatChatter> c() {
        HashMap r100 = new HashMap();
        Iterator r101 = ((HashMap) this.f415195b).values().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.putAll((Map) r101.next());
        goto L4
    L6:
        return r100;
    }

    public a() {
        this.f415194a = new HashMap();
        this.f415195b = new HashMap();
    }

    public final Map<String, ChatChatter> a() {
        Map<String, ChatChatter> r100 = c();
        Iterator r101 = ((HashMap) this.f415194a).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Map.Entry r102 = (Map.Entry) r101.next();
        HashMap r103 = (HashMap) r100;
        if (((ChatChatter) r103.get(r102.getKey())) != null) goto L4;
        r103.put((String) r102.getKey(), new ChatChatter((Chatter) r102.getValue()));
        goto L4
    L8:
        return r100;
    }

    public final void d(Chatter r100) {
        String r101 = r100.getId();
        if ((r100 instanceof ChatChatter) == false) goto L10;
        ChatChatter r102 = (ChatChatter) r100;
        Map<String, Chatter> r103 = this.f415194a;
        HashMap r104 = (HashMap) r103;
        r104.put(r101, r102.chatter);
        String r105 = r102.getChatId();
        if (TextUtils.isEmpty(r105) == true) goto L12;
        Map r106 = (Map) ((HashMap) this.f415195b).get(r105);
        if (r106 != null) goto L9;
        r106 = new HashMap();
        ((HashMap) this.f415195b).put(r105, r106);
    L9:
        r106.put(r101, r102);
        return;
    L12:
        return;
    L10:
        ((HashMap) this.f415194a).put(r101, r100);
    }

    public final ChatChatter b(String r100, String r101) {
        Map r102 = (Map) ((HashMap) this.f415195b).get(r100);
        if (r102 != null) goto L5;
    L8:
        Chatter r103 = (Chatter) ((HashMap) this.f415194a).get(r101);
        if (r103 == null) goto L12;
        ChatChatter r104 = new ChatChatter(r103);
        r104.setChatId(r100);
        return r104;
    L12:
        return null;
    L5:
        if (r102.containsKey(r101) == false) goto L8;
        return (ChatChatter) r102.get(r101);
    }
}
