package com.obric.activeness;

import java.util.Set;
import k9a.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0016\u0010\u0010\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0012H&J\u001e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0012H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\"\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0018H&¨\u0006\u001a"}, d2 = {"Lcom/obric/activeness/IObricActivenessMonitorService;", "", "init", "", "initialized", "", "isActive", "activeReasons", "", "Lcom/obric/activeness/ObricActiveReason;", "getSingleReasonState", "reasonType", "registerActivenessStateObserverLock", "observer", "Lcom/obric/activeness/ObricActivenessStateObserver;", "removeActivenessStateObserverLock", "isActiveCustomized", "ignoreSet", "", "registerCustomizedActivenessStateObserverLock", "removeCustomizedActivenessStateObserverLock", "setActiveState", "reason", "activeTimeOut", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricActivenessMonitorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f384390a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f384391a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy<IObricActivenessMonitorService> f384392b = null;

        public a() {
        }

        static {
            f384391a = new a();
            f384392b = LazyKt.lazy(new k9a.a());
        }
    }

    static {
        f384390a = a.f384391a;
    }

    boolean a(Set<? extends ObricActiveReason> r100);

    void b(b r100, Set<? extends ObricActiveReason> r101);

    boolean c(ObricActiveReason r100, boolean r101, long r102);

    void init();

    boolean isActive();
}
