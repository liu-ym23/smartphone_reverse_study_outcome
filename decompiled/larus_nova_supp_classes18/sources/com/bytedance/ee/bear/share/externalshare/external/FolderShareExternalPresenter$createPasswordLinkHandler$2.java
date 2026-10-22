package com.bytedance.ee.bear.share.externalshare.external;

import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class FolderShareExternalPresenter$createPasswordLinkHandler$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public FolderShareExternalPresenter$createPasswordLinkHandler$2(Object r8) {
        super(0, r8, FolderShareExternalPresenter.class, "refreshFolderPermission", "refreshFolderPermission()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m510invoke() {
        FolderShareExternalPresenter r0 = (FolderShareExternalPresenter) ((CallableReference) this).receiver;
        Disposable r1 = r0.m;
        if (r1 == null) goto L6;
        r1.dispose();
    L6:
        if (r0.i.getFolderVersion().isShareFolderV2() == false) goto L8;
        String r2 = r0.i.getToken();
    L9:
        r0.m = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().e(r2, r0.i.getFolderVersion(), r0.i.isShareRoot()).map(new d(r0)).observeOn(fo5.d.d()).subscribe(new e(r0), f.a);
        return;
    L8:
        r2 = r0.i.getSpaceId();
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m510invoke();
        return Unit.INSTANCE;
    }
}
