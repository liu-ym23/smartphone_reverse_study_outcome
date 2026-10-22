package com.ss.android.lark.contact.impl.group.manage;

import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.mvp.BaseModel;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public final class d extends BaseModel implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f419514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f419515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f419516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Chat> f419517d;

    public d() {
        this.f419514a = true;
        this.f419515b = false;
        this.f419516c = 0;
        this.f419517d = new ArrayList();
    }

    @Override // com.ss.android.lark.contact.impl.group.manage.a
    public final boolean isHasMore() {
        return this.f419514a;
    }

    @Override // com.ss.android.lark.contact.impl.group.manage.a
    public final void U1(final UIGetDataCallback r100) {
        if (this.f419515b == false) goto L5;
        return;
    L5:
        this.f419515b = true;
        ContactBaseModuleDependency.f418857b.getClass();
        ContactBaseModuleDependency.a().g(this.f419516c, (IGetDataCallback) getCallbackManager().wrapAndAddCallback(new MyManageGroupModel$2(this, r100)));
    }

    public final void h(List<Chat> r100) {
        if (this.f419516c != 0) goto L6;
        ((ArrayList) this.f419517d).clear();
        ((ArrayList) this.f419517d).addAll(r100);
        return;
    L6:
        HashSet r101 = new HashSet();
        Iterator<Chat> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r101.add(r102.next().getId());
        goto L8
    L10:
        Iterator r103 = ((ArrayList) this.f419517d).iterator();
    L12:
        if (r103.hasNext() == false) goto L16;
        if (r101.contains(((Chat) r103.next()).getId()) == false) goto L12;
        r103.remove();
        goto L12
    L16:
        ((ArrayList) this.f419517d).addAll(r100);
    }
}
