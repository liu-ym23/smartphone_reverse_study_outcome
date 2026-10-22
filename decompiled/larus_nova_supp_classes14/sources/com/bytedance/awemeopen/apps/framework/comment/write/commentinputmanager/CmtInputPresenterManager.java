package com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager;

import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class CmtInputPresenterManager {
    public final hy3.b a;
    public final bz3.b b;
    public final List<a<? extends jy3.a>> c;
    public ManagerContext d;
    public final Lazy e;

    public CmtInputPresenterManager(hy3.b r2, bz3.b r3) {
        Intrinsics.checkNotNullParameter(r2, "param");
        Intrinsics.checkNotNullParameter(r3, "cmtInputManagerProxy");
        this.a = r2;
        this.b = r3;
        this.c = new ArrayList();
        this.e = LazyKt.lazy(CmtInputPresenterManager$presenterFactory$2.INSTANCE);
    }
}
