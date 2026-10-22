package com.ss.android.lark.framework.assembly.emoji_office;

import a6c.a;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.utils.ApiUtils;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import com.suite.lark.platform.service.resourcerepository.api.ResourceRequestBaseSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import qpc.e;

/* JADX INFO: loaded from: classes36.dex */
public final class StickerCoreDependencyImpl$resourceDependency$1 implements a {
    public StickerCoreDependencyImpl$resourceDependency$1() {
    }

    public final Map<String, c6c.a> b(Map<String, ? extends Resource> r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        if (r100 == null) goto L14;
        Iterator r102 = CollectionsKt.filterNotNull(r100.keySet()).iterator();
    L6:
        if (r102.hasNext() == false) goto L14;
        String r103 = (String) r102.next();
        Resource r104 = r100.get(r103);
        if (r104 == null) goto L10;
        c6c.a r105 = new c6c.a(r104.f461376a, r104.f461377b);
    L11:
        if (r105 == null) goto L6;
        r101.put(r103, r105);
        goto L6
    L10:
        r105 = null;
    L14:
        return r101;
    }

    @Override // a6c.a
    public final Map<String, c6c.a> a(String r100, List<String> r101) {
        ArrayList r102 = new ArrayList();
        if (r101 != null) goto L5;
        r101 = CollectionsKt.emptyList();
    L5:
        Iterator<String> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L14;
        String r104 = r103.next();
        if (r100 != null) goto L11;
        String r105 = "";
    L12:
        r102.add(new ResourceRequestBaseSet(r104, r105, null, null));
        goto L7
    L11:
        r105 = r100;
        goto L12
    L14:
        return b(((e) ApiUtils.getApi(e.class)).synGetResources(r102));
    }

    @Override // a6c.a
    public Map<String, c6c.a> getResources(String r100, List<String> r101) {
        ArrayList r102 = new ArrayList();
        if (r101 != null) goto L5;
        r101 = CollectionsKt.emptyList();
    L5:
        Iterator<String> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L14;
        String r104 = r103.next();
        if (r100 != null) goto L11;
        String r105 = "";
    L12:
        r102.add(new ResourceRequestBaseSet(r104, r105, null, null));
        goto L7
    L11:
        r105 = r100;
        goto L12
    L14:
        return b(((e) ApiUtils.getApi(e.class)).getResources(r102));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a6c.a
    public void getResources(String r100, List<String> r101, final IGetDataCallback<Map<String, c6c.a>> r102) {
        ArrayList r103 = new ArrayList();
        if (r101 != null) goto L5;
        r101 = CollectionsKt.emptyList();
    L5:
        Iterator<String> r104 = r101.iterator();
    L7:
        if (r104.hasNext() == false) goto L13;
        String r105 = r104.next();
        if (r100 != null) goto L11;
        String r106 = "";
    L12:
        r103.add(new ResourceRequestBaseSet(r105, r106, null, null));
        goto L7
    L11:
        r106 = r100;
        goto L12
    L13:
        ((e) ApiUtils.getApi(e.class)).getResources(r103, -99, new StickerCoreDependencyImpl$resourceDependency$1$getResources$1(r102, this));
    }
}
