package com.larus.im.internal.utils;

import androidx.lifecycle.LifecycleObserver;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/im/internal/utils/LifecycleManager;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/flow/kmp/common/lifecycle/LifecycleObserver;", "<init>", "()V", "TAG", "", "isForeground", "", "()Z", "observers", "Lcom/flow/kmp/common/collections/CopyOnWriteArraySet;", "Lcom/larus/im/internal/utils/LifecycleManager$Observer;", "addObserver", "", "observer", "removeObserver", "initObListener", "Observer", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LifecycleManager implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LifecycleManager f350518a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f350519b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final vt7.b<a> f350520c = null;

    public interface a {
        void a(boolean r100);
    }

    private LifecycleManager() {
    }

    static {
        f350518a = new LifecycleManager();
        f350519b = "LifecycleManager";
        f350520c = new vt7.b();
    }
}
