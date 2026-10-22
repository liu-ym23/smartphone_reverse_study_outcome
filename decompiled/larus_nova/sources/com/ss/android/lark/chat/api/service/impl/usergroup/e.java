package com.ss.android.lark.chat.api.service.impl.usergroup;

import com.bytedance.lark.pb.im.v1.UserGroupEntity;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserGroupService f411687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map<Long, UserGroupEntity> f411688b;

    public e(UserGroupService r100, Map<Long, UserGroupEntity> r101) {
        this.f411687a = r100;
        this.f411688b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<Map.Entry<com.ss.android.lark.biz.im.api.usergroup.a, Object>> r100 = this.f411687a.f411680e.entrySet().iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        r100.next().getKey().a(this.f411688b);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
