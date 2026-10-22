package com.ss.android.lark.profile.core.service;

import com.larksuite.rucket.impl.serverimpl.annotation.ServerCall;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.pb.users.PatchUserMemoRequest;
import com.ss.android.lark.pb.users.PatchUserMemoResponse;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes37.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C5250a f438829a = null;

    /* JADX INFO: renamed from: com.ss.android.lark.profile.core.service.a$a, reason: collision with other inner class name */
    public static final class C5250a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C5250a f438830a = null;

        static {
            f438830a = new C5250a();
        }

        public C5250a() {
        }

        public static a a() {
            return (a) ((com.ss.android.lark.profile.core.di.a) LazyKt.lazy(ProfileCoreServiceModel$profileNetClientGetter$2.INSTANCE).getValue()).Q4().create(a.class);
        }
    }

    static {
        f438829a = C5250a.f438830a;
    }

    @ServerCall(5036)
    RucketJob<PatchUserMemoResponse> saveAlias(PatchUserMemoRequest r100);
}
