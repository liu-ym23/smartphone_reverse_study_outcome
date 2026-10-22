package com.larus.bmhome.nestedfile;

import androidx.lifecycle.MutableLiveData;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkFileEntity;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import lr8.d;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u0013\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J#\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\nH\u0096\u0001J\u0019\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0005H\u0096\u0001JA\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0011\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#H\u0096\u0001J!\u0010$\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&H\u0096\u0001J\u0019\u0010'\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010)\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010*\u001a\u00020+H\u0096\u0001¨\u0006,"}, d2 = {"Lcom/larus/bmhome/nestedfile/NestedFileCacheManagerService;", "Lcom/larus/bmhome/nestedfile/INestedFileCacheManagerService;", "<init>", "()V", "getFile", "Lcom/larus/im/bean/message/UplinkFileEntity;", "localMsgID", "", "fileIdentifier", "getNestedFile", "Lcom/larus/im/bean/message/NestedFileContent;", "getOrCreateFileLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "Lcom/larus/bmhome/nestedfile/INestedFileCacheManagerService$FileEvent;", "getOrCreateNestedFileLiveData", "insertFile", "", "content", "insertOrReplaceNestedFile", "insertRemovedFile", "removeFile", "removeNestedFile", "removeRemovedFile", "replaceFile", "updateFileState", "upLinkState", "Lcom/larus/im/bean/message/UpLinkState;", "fileReviewState", "Lcom/larus/im/bean/message/FileReviewState;", "fileParseState", "Lcom/larus/im/bean/message/FileParseState;", "audioDetailUrl", "updateFileStateFromCMD", "info", "Lcom/larus/bmhome/nestedfile/UpdateNestedMessageDownLinkInfo;", "updateFileUpLinkProcess", "process", "", "updateUplinkFileEntity", "updateFileEntity", "updateUplinkFileInfo", "updateFileInfo", "Lcom/larus/bmhome/nestedfile/NestedFileUplinkUpdateInfo;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NestedFileCacheManagerService implements INestedFileCacheManagerService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final NestedFileCacheManagerService f313409b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ INestedFileCacheManagerService f313410a;

    static {
        f313409b = new NestedFileCacheManagerService();
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final UplinkFileEntity a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "localMsgID");
        Intrinsics.checkNotNullParameter(r101, "fileIdentifier");
        return this.f313410a.a(r100, r101);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "localMsgID");
        Intrinsics.checkNotNullParameter(r101, "fileIdentifier");
        this.f313410a.b(r100, r101);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void b2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "localMsgID");
        this.f313410a.b2(r100);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final NestedFileContent b6(String r100) {
        Intrinsics.checkNotNullParameter(r100, "localMsgID");
        return this.f313410a.b6(r100);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void c(String r100, UplinkFileEntity r101) {
        Intrinsics.checkNotNullParameter(r100, "localMsgID");
        Intrinsics.checkNotNullParameter(r101, "content");
        this.f313410a.c(r100, r101);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void d(String r100, String r110, UpLinkState r111, FileReviewState r112, FileParseState r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "localMsgID");
        Intrinsics.checkNotNullParameter(r110, "fileIdentifier");
        this.f313410a.d(r100, r110, r111, r112, r113, r114);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void e(UpdateNestedMessageDownLinkInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        this.f313410a.e(r100);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void f(String r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "localMsgID");
        Intrinsics.checkNotNullParameter(r101, "updateFileInfo");
        this.f313410a.f(r100, r101);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final MutableLiveData<Pair<INestedFileCacheManagerService.FileEvent, UplinkFileEntity>> g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "localMsgID");
        return this.f313410a.g(r100);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void h(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "localMsgID");
        Intrinsics.checkNotNullParameter(r101, "fileIdentifier");
        this.f313410a.h(r100, r101);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void i(String r100, NestedFileContent r101) {
        Intrinsics.checkNotNullParameter(r100, "localMsgID");
        Intrinsics.checkNotNullParameter(r101, "content");
        this.f313410a.i(r100, r101);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final MutableLiveData<NestedFileContent> j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "localMsgID");
        return this.f313410a.j(r100);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void k(String r100, UplinkFileEntity r101) {
        Intrinsics.checkNotNullParameter(r100, "localMsgID");
        Intrinsics.checkNotNullParameter(r101, "content");
        this.f313410a.k(r100, r101);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void l(String r100, UplinkFileEntity r101) {
        Intrinsics.checkNotNullParameter(r100, "localMsgID");
        Intrinsics.checkNotNullParameter(r101, "updateFileEntity");
        this.f313410a.l(r100, r101);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void m(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "localMsgID");
        Intrinsics.checkNotNullParameter(r101, "fileIdentifier");
        this.f313410a.m(r100, r101, r102);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void n(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "localMsgID");
        Intrinsics.checkNotNullParameter(r101, "fileIdentifier");
        this.f313410a.n(r100, r101);
    }

    private NestedFileCacheManagerService() {
        INestedFileCacheManagerService r100 = (INestedFileCacheManagerService) ServiceManager.get().getService(INestedFileCacheManagerService.class);
        if (r100 != null) goto L5;
        r100 = new NestedFileCacheManagerServiceNoop();
    L5:
        this.f313410a = r100;
    }
}
