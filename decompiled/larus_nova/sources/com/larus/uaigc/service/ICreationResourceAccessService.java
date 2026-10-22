package com.larus.uaigc.service;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.bmhome.resource.access.ResourceCancelReason;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH&J8\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\tH&J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\tH&J8\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\tH&J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\u0019"}, d2 = {"Lcom/larus/uaigc/service/ICreationResourceAccessService;", "", LocationMonitorConst.SUBMIT, "Lcom/larus/bmhome/resource/access/ResourceAccessTask;", "request", "Lcom/larus/uaigc/service/ResourceAccessSubmitRequest;", "cancel", "", "fileIdentifier", "", "reason", "Lcom/larus/bmhome/resource/access/ResourceCancelReason;", "observe", "scene", "Lcom/larus/bmhome/resource/access/ResourceAccessScene;", "mediaType", "Lcom/larus/bmhome/resource/access/ResourceMediaType;", "bizScope", "query", "Lcom/larus/bmhome/resource/access/ResourceAccessSnapshot;", DBDefinition.TASK_ID, "queryByFileIdentifier", "getArtifact", "Lcom/larus/bmhome/resource/access/ResourceArtifact;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICreationResourceAccessService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f373925a = null;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J3\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J3\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0011\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0096\u0001¨\u0006\u001a"}, d2 = {"Lcom/larus/uaigc/service/ICreationResourceAccessService$Companion;", "Lcom/larus/uaigc/service/ICreationResourceAccessService;", "<init>", "()V", "cancel", "", "fileIdentifier", "", "reason", "Lcom/larus/bmhome/resource/access/ResourceCancelReason;", "getArtifact", "Lcom/larus/bmhome/resource/access/ResourceArtifact;", "observe", "Lcom/larus/bmhome/resource/access/ResourceAccessTask;", "scene", "Lcom/larus/bmhome/resource/access/ResourceAccessScene;", "mediaType", "Lcom/larus/bmhome/resource/access/ResourceMediaType;", "bizScope", "query", "Lcom/larus/bmhome/resource/access/ResourceAccessSnapshot;", DBDefinition.TASK_ID, "queryByFileIdentifier", LocationMonitorConst.SUBMIT, "request", "Lcom/larus/uaigc/service/ResourceAccessSubmitRequest;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements ICreationResourceAccessService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f373926c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ICreationResourceAccessService f373927b;

        static {
            f373926c = new Companion();
        }

        @Override // com.larus.uaigc.service.ICreationResourceAccessService
        public final boolean a(String r100, ResourceCancelReason r101) {
            Intrinsics.checkNotNullParameter(r101, "reason");
            return this.f373927b.a(r100, r101);
        }

        @Override // com.larus.uaigc.service.ICreationResourceAccessService
        public final com.larus.bmhome.resource.access.b0 b(p0 r100) {
            Intrinsics.checkNotNullParameter(r100, "request");
            return this.f373927b.b(r100);
        }

        @Override // com.larus.uaigc.service.ICreationResourceAccessService
        public final com.larus.bmhome.resource.access.f0 c(String r100) {
            return this.f373927b.c(r100);
        }

        @Override // com.larus.uaigc.service.ICreationResourceAccessService
        public final com.larus.bmhome.resource.access.z d(String r100, com.larus.bmhome.resource.access.x r101, ResourceMediaType r102, String r103) {
            return this.f373927b.d(r100, r101, r102, r103);
        }

        @Override // com.larus.uaigc.service.ICreationResourceAccessService
        public final com.larus.bmhome.resource.access.b0 e(String r100, com.larus.bmhome.resource.access.x r101, ResourceMediaType r102, String r103) {
            return this.f373927b.e(r100, r101, r102, r103);
        }

        @Override // com.larus.uaigc.service.ICreationResourceAccessService
        public com.larus.bmhome.resource.access.z query(String r100) {
            return this.f373927b.query(r100);
        }

        private Companion() {
            ICreationResourceAccessService r100 = (ICreationResourceAccessService) ServiceManager.get().getService(ICreationResourceAccessService.class);
            if (r100 != null) goto L5;
            r100 = new ICreationResourceAccessServiceNoop();
        L5:
            this.f373927b = r100;
        }
    }

    public static final class a {
        public static /* synthetic */ void a(Companion r100, String r101) {
            r100.a(r101, ResourceCancelReason.UNKNOWN);
        }

        public static /* synthetic */ com.larus.bmhome.resource.access.b0 b(Companion r100, String r101, com.larus.bmhome.resource.access.x r102, ResourceMediaType r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r102 = null;
        L6:
            if ((r104 & 4) == 0) goto L9;
            r103 = null;
        L9:
            return r100.e(r101, r102, r103, null);
        }

        public static /* synthetic */ com.larus.bmhome.resource.access.z c(Companion r100, String r101, com.larus.bmhome.resource.access.x r102, ResourceMediaType r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r102 = null;
        L6:
            if ((r104 & 4) == 0) goto L9;
            r103 = null;
        L9:
            return r100.d(r101, r102, r103, null);
        }
    }

    static {
        f373925a = Companion.f373926c;
    }

    boolean a(String r100, ResourceCancelReason r101);

    com.larus.bmhome.resource.access.b0 b(p0 r100);

    com.larus.bmhome.resource.access.f0 c(String r100);

    com.larus.bmhome.resource.access.z d(String r100, com.larus.bmhome.resource.access.x r101, ResourceMediaType r102, String r103);

    com.larus.bmhome.resource.access.b0 e(String r100, com.larus.bmhome.resource.access.x r101, ResourceMediaType r102, String r103);

    com.larus.bmhome.resource.access.z query(String r100);
}
