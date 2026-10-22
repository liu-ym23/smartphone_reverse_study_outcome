package com.bytedance.ee.bear.templates.topic;

import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.mvp.IModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class TopicModel implements IModel {
    public final FragmentActivity a;
    public final Lazy b;

    public final void create() {
    }

    public final void destroy() {
    }

    public final FragmentActivity getActivity() {
        return this.a;
    }

    public TopicModel(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = r2;
        this.b = LazyKt.lazy(TopicModel$netService$2.INSTANCE);
    }
}
