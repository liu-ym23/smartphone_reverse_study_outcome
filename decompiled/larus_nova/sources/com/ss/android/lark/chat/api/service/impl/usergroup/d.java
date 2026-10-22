package com.ss.android.lark.chat.api.service.impl.usergroup;

import com.bytedance.lark.pb.im.v1.PushUserGroupEntitiesRequest;
import com.bytedance.lark.pb.im.v1.UserGroupEntity;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserGroupPush f411685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PushUserGroupEntitiesRequest f411686b;

    public d(UserGroupPush r100, PushUserGroupEntitiesRequest r101) {
        this.f411685a = r100;
        this.f411686b = r101;
    }

    public final void a() {
        UserGroupPush r100 = this.f411685a;
        PushUserGroupEntitiesRequest r101 = this.f411686b;
        r100.getClass();
        Map<Long, UserGroupEntity> r102 = r101.user_groups;
        ArrayList r103 = new ArrayList(r102.size());
        Iterator<Map.Entry<Long, UserGroupEntity>> r104 = r102.entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add(r104.next().getKey());
        goto L4
    L6:
        int r105 = c.f411684a;
        c.b("UserGroupPush", "receive user group push. " + r103);
        r100.f411666b.pe(r101.user_groups);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
