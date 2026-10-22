package com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager;

import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class CmtInputPresenterManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hy3.b f194403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bz3.b f194404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<a<? extends jy3.a>> f194405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ManagerContext f194406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f194407e;

    public CmtInputPresenterManager(hy3.b r100, bz3.b r101) {
        Intrinsics.checkNotNullParameter(r100, "param");
        Intrinsics.checkNotNullParameter(r101, "cmtInputManagerProxy");
        this.f194403a = r100;
        this.f194404b = r101;
        this.f194405c = new ArrayList();
        this.f194407e = LazyKt.lazy(CmtInputPresenterManager$presenterFactory$2.INSTANCE);
    }
}
