package com.bytedance.ee.bear.document.at;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.at.AtObject;
import com.bytedance.ee.bear.atfinder.AtFinderResultList;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.utils.AtUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements NetService.c<AtFinderNetServiceResult> {
    public final String a;
    public final Context b;

    public final AtFinderNetServiceResult c(String r3) {
        AtFinderNetServiceResult r0 = new AtFinderNetServiceResult();
        r0.originJson = r3;     // Catch: Exception -> L5
        r0.list = d((AtFinderResultList) JSON.parseObject(r3, AtFinderResultList.class));     // Catch: Exception -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        tt5.a.j("AtFinderResultParser", e);
        goto L7
    }

    public final List<AtObject> d(AtFinderResultList r12) {
        ArrayList r0 = new ArrayList();
        if (r12 != null) goto L40;
        tt5.a.b("AtFinderResultParser", "reBuildResult: params is null");
        return r0;
    L40:
        List r2 = r12.getData().getResult_list();     // Catch: Exception -> L37
        Map r3 = r12.getData().getEntities().getUsers();     // Catch: Exception -> L37
        Map<String, AtObject> r4 = r12.getData().getEntities().getNotes();     // Catch: Exception -> L37
        Map<String, AtObject> r5 = r12.getData().getEntities().getChats();     // Catch: Exception -> L37
        Map<String, AtObject> r13 = r12.getData().getEntities().getGroups();     // Catch: Exception -> L37
        int r6 = 0;
    L7:
        if (r6 >= r2.size()) goto L39;
        int r7 = ((AtObject) ListProtector.get(r2, r6)).getType();     // Catch: Exception -> L37
        if (AtUtils.c().contains(r7 + "") == true) goto L12;
        if (r7 != 0) goto L17;
        String r8 = ((AtObject) ListProtector.get(r2, r6)).getToken();     // Catch: Exception -> L37
        if (r3 != null) goto L26;
    L32:
        AtObject r9 = null;
    L33:
        if (r9 != null) goto L35;
        tt5.a.h("AtFinderResultParser", "reBuildResult: value is null");     // Catch: Exception -> L37
    L36:
        r6 = r6 + 1;
        goto L7
    L35:
        r0.add(r9);     // Catch: Exception -> L37
        goto L36
    L26:
        if (r3.size() == 0) goto L32;
        AtObject r10 = (AtObject) r3.get(r8);     // Catch: Exception -> L37
        if (r10 == null) goto L32;
        r10.setToken(r8);     // Catch: Exception -> L37
        r10.setContent(ou5.a.b(this.a, r10.getCn_name(), r10.getEn_name()));     // Catch: Exception -> L37
        r10.setUrl(r10.getAvatar_url());     // Catch: Exception -> L37
        r10.setLanguage(this.a);     // Catch: Exception -> L37
        r9 = r10;
        goto L33
    L17:
        if (r7 != 5) goto L19;
        r9 = a(r5, ((AtObject) ListProtector.get(r2, r6)).getToken());     // Catch: Exception -> L37
        goto L33
    L19:
        if (r7 != 6) goto L32;
        r9 = a(r13, ((AtObject) ListProtector.get(r2, r6)).getToken());     // Catch: Exception -> L37
        goto L33
    L12:
        if (((a4) org.koin.java.a.a(a4.class)).a(r7) == true) goto L36;
        r9 = b(r4, ((AtObject) ListProtector.get(r2, r6)).getToken());     // Catch: Exception -> L37
    L39:
        return r0;
    L37:
        e = move-exception;
        tt5.a.l("AtFinderResultParser", "reBuildResult: ", e);
        goto L39
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final /* bridge */ /* synthetic */ Result parse(String r1) throws NetService.ParseException {
        return c(r1);
    }

    public f(Context r1, i0 r2) {
        this.b = r1;
        this.a = r2.a();
    }

    public final AtObject a(Map<String, AtObject> r3, String r4) {
        if (r3 != null) goto L5;
    L12:
        return null;
    L5:
        if (r3.size() == 0) goto L12;
        AtObject r5 = r3.get(r4);
        if (r5 != null) goto L10;
        return null;
    L10:
        r5.setToken(r4);
        r5.setContent(r5.getName());
        r5.setUrl(r5.getAvatar_url());
        r5.setLanguage(this.a);
        return r5;
    }

    public final AtObject b(Map<String, AtObject> r3, String r4) {
        if (r3 != null) goto L5;
    L16:
        return null;
    L5:
        if (r3.size() == 0) goto L16;
        AtObject r5 = r3.get(r4);
        if (r5 != null) goto L10;
        return null;
    L10:
        r5.setToken(r4);
        if (TextUtils.isEmpty(r5.getTitle()) == false) goto L13;
        String r6 = kn4.f.b().c().getDocumentDefaultName(this.b, r5.getType());
    L14:
        r5.setContent(r6);
        r5.setLanguage(this.a);
        return r5;
    L13:
        r6 = r5.getTitle();
        goto L14
    }
}
