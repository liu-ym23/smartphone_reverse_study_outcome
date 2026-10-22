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

/* JADX INFO: loaded from: classes16.dex */
public final class f implements NetService.c<AtFinderNetServiceResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f219108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f219109b;

    public final AtFinderNetServiceResult c(String r100) {
        AtFinderNetServiceResult r101 = new AtFinderNetServiceResult();
        r101.originJson = r100;     // Catch: Exception -> L5
        r101.list = d((AtFinderResultList) JSON.parseObject(r100, AtFinderResultList.class));     // Catch: Exception -> L5
    L7:
        return r101;
    L5:
        e = move-exception;
        tt5.a.j("AtFinderResultParser", e);
        goto L7
    }

    public final List<AtObject> d(AtFinderResultList r110) {
        ArrayList r100 = new ArrayList();
        if (r110 != null) goto L40;
        tt5.a.b("AtFinderResultParser", "reBuildResult: params is null");
        return r100;
    L40:
        List<AtObject> r101 = r110.getData().getResult_list();     // Catch: Exception -> L37
        Map<String, AtObject> r102 = r110.getData().getEntities().getUsers();     // Catch: Exception -> L37
        Map<String, AtObject> r103 = r110.getData().getEntities().getNotes();     // Catch: Exception -> L37
        Map<String, AtObject> r104 = r110.getData().getEntities().getChats();     // Catch: Exception -> L37
        Map<String, AtObject> r111 = r110.getData().getEntities().getGroups();     // Catch: Exception -> L37
        int r105 = 0;
    L7:
        if (r105 >= r101.size()) goto L39;
        int r106 = ((AtObject) ListProtector.get(r101, r105)).getType();     // Catch: Exception -> L37
        if (AtUtils.c().contains(r106 + "") == true) goto L12;
        if (r106 != 0) goto L17;
        String r107 = ((AtObject) ListProtector.get(r101, r105)).getToken();     // Catch: Exception -> L37
        if (r102 != null) goto L26;
    L32:
        AtObject r108 = null;
    L33:
        if (r108 != null) goto L35;
        tt5.a.h("AtFinderResultParser", "reBuildResult: value is null");     // Catch: Exception -> L37
    L36:
        r105 = r105 + 1;
        goto L7
    L35:
        r100.add(r108);     // Catch: Exception -> L37
        goto L36
    L26:
        if (r102.size() == 0) goto L32;
        AtObject r109 = r102.get(r107);     // Catch: Exception -> L37
        if (r109 == null) goto L32;
        r109.setToken(r107);     // Catch: Exception -> L37
        r109.setContent(ou5.a.b(this.f219108a, r109.getCn_name(), r109.getEn_name()));     // Catch: Exception -> L37
        r109.setUrl(r109.getAvatar_url());     // Catch: Exception -> L37
        r109.setLanguage(this.f219108a);     // Catch: Exception -> L37
        r108 = r109;
        goto L33
    L17:
        if (r106 != 5) goto L19;
        r108 = a(r104, ((AtObject) ListProtector.get(r101, r105)).getToken());     // Catch: Exception -> L37
        goto L33
    L19:
        if (r106 != 6) goto L32;
        r108 = a(r111, ((AtObject) ListProtector.get(r101, r105)).getToken());     // Catch: Exception -> L37
        goto L33
    L12:
        if (((a4) org.koin.java.a.a(a4.class)).a(r106) == true) goto L36;
        r108 = b(r103, ((AtObject) ListProtector.get(r101, r105)).getToken());     // Catch: Exception -> L37
    L39:
        return r100;
    L37:
        e = move-exception;
        tt5.a.l("AtFinderResultParser", "reBuildResult: ", e);
        goto L39
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final /* bridge */ /* synthetic */ Result parse(String r100) throws NetService.ParseException {
        return c(r100);
    }

    public f(Context r100, i0 r101) {
        this.f219109b = r100;
        this.f219108a = r101.a();
    }

    public final AtObject a(Map<String, AtObject> r100, String r101) {
        if (r100 != null) goto L5;
    L12:
        return null;
    L5:
        if (r100.size() == 0) goto L12;
        AtObject r102 = r100.get(r101);
        if (r102 != null) goto L10;
        return null;
    L10:
        r102.setToken(r101);
        r102.setContent(r102.getName());
        r102.setUrl(r102.getAvatar_url());
        r102.setLanguage(this.f219108a);
        return r102;
    }

    public final AtObject b(Map<String, AtObject> r100, String r101) {
        if (r100 != null) goto L5;
    L16:
        return null;
    L5:
        if (r100.size() == 0) goto L16;
        AtObject r102 = r100.get(r101);
        if (r102 != null) goto L10;
        return null;
    L10:
        r102.setToken(r101);
        if (TextUtils.isEmpty(r102.getTitle()) == false) goto L13;
        String r103 = kn4.f.b().c().getDocumentDefaultName(this.f219109b, r102.getType());
    L14:
        r102.setContent(r103);
        r102.setLanguage(this.f219108a);
        return r102;
    L13:
        r103 = r102.getTitle();
        goto L14
    }
}
