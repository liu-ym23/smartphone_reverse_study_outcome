package com.bytedance.helios.sdk;

import android.app.Application;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityLifecycle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedList<Application.ActivityLifecycleCallbacks> f245456a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c f245457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f245458c = null;

    static {
        f245456a = new LinkedList();
        f245458c = LazyKt.lazy(ActivityLifecycle$internalActivityLifecycleCallbacks$2.INSTANCE);
    }
}
