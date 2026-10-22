package com.larus.livetutor.api;

import android.app.Activity;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import q97.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\n"}, d2 = {"Lcom/larus/livetutor/api/ILiveTutorService;", "", "checkLiveTutorLoginRouteInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "isInLiveTutor", "", "isLiveTutorPage", "page", "Landroid/app/Activity;", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILiveTutorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f355865a = null;

    /* JADX INFO: loaded from: classes30.dex */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0001¨\u0006\u000b"}, d2 = {"Lcom/larus/livetutor/api/ILiveTutorService$Companion;", "Lcom/larus/livetutor/api/ILiveTutorService;", "<init>", "()V", "checkLiveTutorLoginRouteInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "isInLiveTutor", "", "isLiveTutorPage", "page", "Landroid/app/Activity;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements ILiveTutorService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f355866c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ILiveTutorService f355867b;

        static {
            f355866c = new Companion();
        }

        @Override // com.larus.livetutor.api.ILiveTutorService
        public final a a() {
            return this.f355867b.a();
        }

        @Override // com.larus.livetutor.api.ILiveTutorService
        public final boolean b(Activity r100) {
            return this.f355867b.b(r100);
        }

        @Override // com.larus.livetutor.api.ILiveTutorService
        public final boolean c() {
            return this.f355867b.c();
        }

        private Companion() {
            this.f355867b = (ILiveTutorService) ServiceManager.get().getService(ILiveTutorService.class);
        }
    }

    static {
        f355865a = Companion.f355866c;
    }

    a a();

    boolean b(Activity r100);

    boolean c();
}
