package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes35.dex */
public final class GroupMemberLimitInterceptor_Factory implements Factory<GroupMemberLimitInterceptor> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final GroupMemberLimitInterceptor_Factory f420221a = null;

        static {
            f420221a = new GroupMemberLimitInterceptor_Factory();
        }
    }

    public GroupMemberLimitInterceptor_Factory() {
    }

    public static GroupMemberLimitInterceptor newInstance() {
        return new GroupMemberLimitInterceptor();
    }

    @Override // javax.inject.Provider
    public GroupMemberLimitInterceptor get() {
        return newInstance();
    }

    public static GroupMemberLimitInterceptor_Factory create() {
        return a.f420221a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
