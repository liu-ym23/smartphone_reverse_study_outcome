package com.ss.android.lark.contact.impl.group.join;

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
public final class c extends BaseModel implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f419491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f419492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f419493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Chat> f419494d;

    public c() {
        this.f419491a = true;
        this.f419492b = false;
        this.f419493c = 0;
        this.f419494d = new ArrayList();
    }

    @Override // com.ss.android.lark.contact.impl.group.join.a
    public final boolean isHasMore() {
        return this.f419491a;
    }

    @Override // com.ss.android.lark.contact.impl.group.join.a
    public final void N0(final UIGetDataCallback r100) {
        if (this.f419492b == false) goto L5;
        return;
    L5:
        this.f419492b = true;
        ContactBaseModuleDependency.f418857b.getClass();
        ContactBaseModuleDependency.a().h(this.f419493c, (IGetDataCallback) getCallbackManager().wrapAndAddCallback(new MyJoinGroupModel$2(this, r100)));
    }

    public final void h(List<Chat> r100) {
        if (this.f419493c != 0) goto L6;
        ((ArrayList) this.f419494d).clear();
        ((ArrayList) this.f419494d).addAll(r100);
        return;
    L6:
        HashSet r101 = new HashSet();
        Iterator<Chat> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r101.add(r102.next().getId());
        goto L8
    L10:
        Iterator r103 = ((ArrayList) this.f419494d).iterator();
    L12:
        if (r103.hasNext() == false) goto L16;
        if (r101.contains(((Chat) r103.next()).getId()) == false) goto L12;
        r103.remove();
        goto L12
    L16:
        ((ArrayList) this.f419494d).addAll(r100);
    }

    @Override // com.ss.android.lark.contact.impl.group.join.a
    public final void t5(final UIGetDataCallback r100) {
        ContactBaseModuleDependency.f418857b.getClass();
        ContactBaseModuleDependency.a().i((IGetDataCallback) getCallbackManager().wrapAndAddCallback(new MyJoinGroupModel$1(this, r100)));
    }
}
