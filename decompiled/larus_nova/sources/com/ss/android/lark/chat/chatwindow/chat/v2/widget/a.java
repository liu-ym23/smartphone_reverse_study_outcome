package com.ss.android.lark.chat.chatwindow.chat.v2.widget;

import com.larksuite.framework.utils.AndroidThrottle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a<T> implements AndroidThrottle.d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c.b<T> f414668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, T> f414669b;

    @Override // com.larksuite.framework.utils.AndroidThrottle.d
    public final Collection<T> a() {
        ArrayList r100 = new ArrayList(((HashMap) this.f414669b).values());
        ((HashMap) this.f414669b).clear();
        return r100;
    }

    @Override // com.larksuite.framework.utils.AndroidThrottle.d
    public final void clear() {
        ((HashMap) this.f414669b).clear();
    }

    @Override // com.larksuite.framework.utils.AndroidThrottle.d
    public final int size() {
        return ((HashMap) this.f414669b).size();
    }

    public a(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.e r100) {
        Intrinsics.checkNotNullParameter(r100, "mDataProvider");
        this.f414668a = r100;
        this.f414669b = new HashMap();
    }

    @Override // com.larksuite.framework.utils.AndroidThrottle.d
    public final void put(T r100) {
        if (r100 == null) goto L10;
        String r101 = this.f414668a.a(r100);
        if (r101 != null) goto L7;
        return;
    L7:
        if (((HashMap) this.f414669b).containsKey(r101) == true) goto L11;
        ((HashMap) this.f414669b).put(r101, r100);
        return;
    L11:
        return;
    }
}
