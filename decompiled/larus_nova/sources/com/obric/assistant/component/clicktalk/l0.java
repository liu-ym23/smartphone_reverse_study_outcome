package com.obric.assistant.component.clicktalk;

import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes33.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f388541a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f388542b = null;

    static {
        f388541a = LazyKt.lazy(new j0());
        f388542b = LazyKt.lazy(new k0());
    }

    public static ISettingRepoService a() {
        return (ISettingRepoService) f388541a.getValue();
    }
}
