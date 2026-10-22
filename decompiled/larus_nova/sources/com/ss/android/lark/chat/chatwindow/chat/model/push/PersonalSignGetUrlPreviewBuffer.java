package com.ss.android.lark.chat.chatwindow.chat.model.push;

import com.larksuite.framework.utils.AndroidThrottle;
import com.ss.android.lark.chat.utils.UserStatusParseUrlPreViewUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes35.dex */
public final class PersonalSignGetUrlPreviewBuffer implements AndroidThrottle.d<UserStatusParseUrlPreViewUtils.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f413426a;

    @Override // com.larksuite.framework.utils.AndroidThrottle.d
    public final void clear() {
    }

    @Override // com.larksuite.framework.utils.AndroidThrottle.d
    public final Collection<UserStatusParseUrlPreViewUtils.b> a() {
        ArrayList r100 = new ArrayList(((HashMap) this.f413426a.getValue()).values());
        ((HashMap) this.f413426a.getValue()).clear();
        return r100;
    }

    @Override // com.larksuite.framework.utils.AndroidThrottle.d
    public final int size() {
        return ((HashMap) this.f413426a.getValue()).size();
    }

    public PersonalSignGetUrlPreviewBuffer() {
        this.f413426a = LazyKt.lazy(PersonalSignGetUrlPreviewBuffer$requestMap$2.INSTANCE);
    }

    @Override // com.larksuite.framework.utils.AndroidThrottle.d
    public final void put(UserStatusParseUrlPreViewUtils.b r100) {
        UserStatusParseUrlPreViewUtils.b r101 = r100;
        if (r101 == null) goto L6;
        ((HashMap) this.f413426a.getValue()).put(r101.f416640b + '_' + r101.f416641c + '_' + r101.f416642d, r101);
        return;
    }
}
