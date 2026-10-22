package com.ss.android.lark.forwardv2.impl.model;

import com.larksuite.framework.callback.CallbackManager;
import com.larksuite.framework.mvp.BaseModel;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public abstract class a extends BaseModel implements iib.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, SearchBaseInfo> f424927a;

    @Override // iib.a
    public final void a3() {
        ((LinkedHashMap) this.f424927a).clear();
    }

    @Override // iib.a
    public final List<SearchBaseInfo> z7() {
        return new ArrayList(((LinkedHashMap) this.f424927a).values());
    }

    public a() {
        this.f424927a = new LinkedHashMap();
    }

    @Override // iib.a
    public final CallbackManager m3() {
        return getCallbackManager();
    }

    @Override // com.larksuite.framework.mvp.BaseModel, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
    }

    @Override // iib.a
    public final void Y4(SearchBaseInfo r100, boolean r101) {
        String r102 = r100.getId();
        if (r101 == true) goto L5;
    L7:
        if (r101 == false) goto L9;
        return;
    L9:
        if (this.f424927a.containsKey(r102) == false) goto L14;
        this.f424927a.remove(r102);
        return;
    L14:
        return;
    L5:
        if (this.f424927a.containsKey(r102) == true) goto L7;
        this.f424927a.put(r102, r100);
    }
}
