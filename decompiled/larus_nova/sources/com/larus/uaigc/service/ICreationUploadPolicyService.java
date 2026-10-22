package com.larus.uaigc.service;

import android.net.Uri;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J*\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000f"}, d2 = {"Lcom/larus/uaigc/service/ICreationUploadPolicyService;", "", "getCreationImageUploadPolicy", "Lcom/larus/uaigc/utils/ICreationImageUploadPolicy;", "mobDuplicateStatAsync", "", "scene", "", "uri", "Landroid/net/Uri;", "processFileResult", "Lcom/larus/bmhome/chat/bean/ProcessFileResult;", "processTime", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICreationUploadPolicyService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f373937a = null;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J+\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0001¨\u0006\u0010"}, d2 = {"Lcom/larus/uaigc/service/ICreationUploadPolicyService$Companion;", "Lcom/larus/uaigc/service/ICreationUploadPolicyService;", "<init>", "()V", "getCreationImageUploadPolicy", "Lcom/larus/uaigc/utils/ICreationImageUploadPolicy;", "mobDuplicateStatAsync", "", "scene", "", "uri", "Landroid/net/Uri;", "processFileResult", "Lcom/larus/bmhome/chat/bean/ProcessFileResult;", "processTime", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements ICreationUploadPolicyService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f373938c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ICreationUploadPolicyService f373939b;

        static {
            f373938c = new Companion();
        }

        @Override // com.larus.uaigc.service.ICreationUploadPolicyService
        public final void U(String r100, Uri r101, ic8.n0 r110, long r111) {
            Intrinsics.checkNotNullParameter(r101, "uri");
            Intrinsics.checkNotNullParameter(r110, "processFileResult");
            this.f373939b.U(r100, r101, r110, r111);
        }

        @Override // com.larus.uaigc.service.ICreationUploadPolicyService
        public final com.larus.uaigc.utils.a t() {
            return this.f373939b.t();
        }

        private Companion() {
            ICreationUploadPolicyService r100 = (ICreationUploadPolicyService) ServiceManager.get().getService(ICreationUploadPolicyService.class);
            if (r100 != null) goto L5;
            r100 = new ICreationUploadPolicyServiceNoop();
        L5:
            this.f373939b = r100;
        }
    }

    static {
        f373937a = Companion.f373938c;
    }

    void U(String r100, Uri r101, ic8.n0 r102, long r103);

    com.larus.uaigc.utils.a t();
}
