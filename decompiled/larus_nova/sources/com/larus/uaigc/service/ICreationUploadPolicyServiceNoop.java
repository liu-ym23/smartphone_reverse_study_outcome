package com.larus.uaigc.service;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/larus/uaigc/service/ICreationUploadPolicyServiceNoop;", "Lcom/larus/uaigc/service/ICreationUploadPolicyService;", "<init>", "()V", "getCreationImageUploadPolicy", "Lcom/larus/uaigc/utils/ICreationImageUploadPolicy;", "mobDuplicateStatAsync", "", "scene", "", "uri", "Landroid/net/Uri;", "processFileResult", "Lcom/larus/bmhome/chat/bean/ProcessFileResult;", "processTime", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ICreationUploadPolicyServiceNoop implements ICreationUploadPolicyService {
    public ICreationUploadPolicyServiceNoop() {
    }

    @Override // com.larus.uaigc.service.ICreationUploadPolicyService
    public final void U(String r100, Uri r101, ic8.n0 r102, long r103) {
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r102, "processFileResult");
    }

    @Override // com.larus.uaigc.service.ICreationUploadPolicyService
    public final com.larus.uaigc.utils.a t() {
        return null;
    }
}
