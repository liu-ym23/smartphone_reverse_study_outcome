package com.bytedance.ee.bear.templates.topic;

import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.mvp.IModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class TopicModel implements IModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f239429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f239430b;

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    public final FragmentActivity getActivity() {
        return this.f239429a;
    }

    public TopicModel(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f239429a = r100;
        this.f239430b = LazyKt.lazy(TopicModel$netService$2.INSTANCE);
    }
}
