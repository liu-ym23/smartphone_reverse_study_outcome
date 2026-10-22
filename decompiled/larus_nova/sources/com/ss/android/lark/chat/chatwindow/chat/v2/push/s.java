package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.bytedance.lark.pb.im.v1.UserGroupEntity;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class s implements c0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a2b.n f414659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a2b.o f414660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference<b> f414661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f414662d;

    public static final class a {
    }

    public interface b {
        void onPushUserGroup(Map<Long, UserGroupEntity> r100);
    }

    public static final class c implements com.ss.android.lark.biz.im.api.usergroup.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f414663a;

        public c(s r100) {
            this.f414663a = r100;
        }

        @Override // com.ss.android.lark.biz.im.api.usergroup.a
        public final void a(Map<Long, UserGroupEntity> r100) {
            Intrinsics.checkNotNullParameter(r100, "userGroups");
            b r101 = this.f414663a.f414661c.get();
            if (r101 == null) goto L6;
            r101.onPushUserGroup(r100);
            return;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void register() {
        this.f414660b.w9(this.f414662d);
        this.f414659a.C3(this.f414662d);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void unRegister() {
        this.f414660b.z1(this.f414662d);
        this.f414659a.vc(this.f414662d);
    }

    public s(a2b.n r100, a2b.o r101, b r102) {
        Intrinsics.checkNotNullParameter(r100, "userGroupPush");
        Intrinsics.checkNotNullParameter(r101, "userGroupService");
        Intrinsics.checkNotNullParameter(r102, "listener");
        this.f414659a = r100;
        this.f414660b = r101;
        this.f414661c = new WeakReference(r102);
        this.f414662d = new c(this);
    }
}
