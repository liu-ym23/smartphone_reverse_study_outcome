package com.ss.android.lark.officesdk.minutes.assembly.fileupload;

import android.content.Context;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import eub.a;
import eub.f;
import eub.h;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes37.dex */
@OfficeSDKUserScope
public final class MmMinutesFileUploadCapacityImpl implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Inject
    public com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f433582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f433583b;

    @Inject
    public MmMinutesFileUploadCapacityImpl() {
        this.f433583b = LazyKt.lazy(new MmMinutesFileUploadCapacityImpl$manager$2(this));
    }

    @Override // eub.a
    public final z0 O9(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        MmMinutesFileUploadSessionManager r101 = (MmMinutesFileUploadSessionManager) this.f433583b.getValue();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        MmMinutesFileUploadSessionManager.e r102 = r101.f433708p.get(r100);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.f433730b;
    }

    @Override // eub.a
    public final void setContext(Context r100) {
        MmMinutesFileUploadSessionManager r101 = (MmMinutesFileUploadSessionManager) this.f433583b.getValue();
        String r102 = r101.f433696d;
        StringBuilder r103 = new StringBuilder("setContext: context=");
        if (r100 == null) goto L5;
        String r104 = r100.getClass().getSimpleName();
    L6:
        r103.append(r104);
        r103.append(", isNull=");
        if (r100 != null) goto L9;
        boolean r105 = true;
    L10:
        r103.append(r105);
        lvb.a.e(r102, r103.toString());
        r101.f433712t = r100;
        return;
    L9:
        r105 = false;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    @Override // eub.a
    public final Object c4(f r100, Continuation<? super String> r101) {
        return ((MmMinutesFileUploadSessionManager) this.f433583b.getValue()).H(r100, r101);
    }

    @Override // eub.a
    public final Object jb(h r100, Continuation<? super String> r101) {
        return ((MmMinutesFileUploadSessionManager) this.f433583b.getValue()).G(r100, r101);
    }
}
