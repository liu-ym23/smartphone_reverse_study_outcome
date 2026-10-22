package com.larus.bmhome.notification;

import android.os.Handler;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.chat.model.repo.INotifyRedDotLifecycleObserver;
import com.larus.bmhome.chat.model.repo.b2;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007*\u0002\u0010\u0013\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010 \u001a\u00020\u0016H\u0016J\b\u0010!\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006#"}, d2 = {"Lcom/larus/bmhome/notification/NotifyRedDotLifecycleObserver;", "Lcom/larus/bmhome/chat/model/repo/INotifyRedDotLifecycleObserver;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "repo", "Lcom/larus/bmhome/chat/model/repo/NotificationRepo;", "handler", "Landroid/os/Handler;", "unreadTask", "Ljava/lang/Runnable;", "newNotificationCMDObserver", "Landroidx/lifecycle/Observer;", "", "appBackGroundListener", "com/larus/bmhome/notification/NotifyRedDotLifecycleObserver$appBackGroundListener$1", "Lcom/larus/bmhome/notification/NotifyRedDotLifecycleObserver$appBackGroundListener$1;", "accountStatusCallback", "com/larus/bmhome/notification/NotifyRedDotLifecycleObserver$accountStatusCallback$1", "Lcom/larus/bmhome/notification/NotifyRedDotLifecycleObserver$accountStatusCallback$1;", WidgetCostModule.TYPE_ON_CREATE, "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "getUnreadCount", "Lkotlinx/coroutines/Job;", "source", "", "startUnreadPollingTask", "stopUnreadPollingTask", LiveCommonConstants.REASON_ON_DEDTROY, "onCleared", "clear", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotifyRedDotLifecycleObserver implements INotifyRedDotLifecycleObserver {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f313416h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f313417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b2 f313418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f313419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.larus.bmhome.notification.a f313420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f313421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f313422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f313423g;

    public static final class a {
    }

    static {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onPause(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onPause(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onResume(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onResume(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onStart(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onStart(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onStop(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onStop(this, r100);
    }

    public final void b() {
        long r100 = ((long) z2.f365865a.y2()) * 1000;
        if (r100 <= 0) goto L6;
        FLogger.f375446a.i("NotifyRedDotLifecycleObserver", "startUnreadPollingTask: interval = " + r100 + " ms");
        this.f313419c.removeCallbacks(this.f313420d);
        this.f313419c.postDelayed(this.f313420d, r100);
        return;
    }

    public final void clear() {
        this.f313418b.getClass();
        b2.f307776c.removeObserver(this.f313421e);
        FLogger.f375446a.i("NotifyRedDotLifecycleObserver", "stopUnreadPollingTask");
        this.f313419c.removeCallbacks(this.f313420d);
        AppHost.f326268a.a().c(this.f313422f);
        AccountService.f365697a.D(this.f313423g);
    }

    @Override // com.larus.bmhome.chat.model.repo.INotifyRedDotLifecycleObserver
    public final void onCleared() {
        clear();
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.bmhome.notification.a] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.bmhome.notification.b] */
    public NotifyRedDotLifecycleObserver(LifecycleCoroutineScope r100) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleScope");
        this.f313417a = r100;
        this.f313418b = b2.f307774a;
        this.f313419c = new Handler();
        this.f313420d = new com.larus.bmhome.notification.a(this);
        this.f313421e = new b(this);
        this.f313422f = new d(this);
        this.f313423g = new c(this);
    }

    public final void a(String r100) {
        BuildersKt.launch$default(this.f313417a, null, null, new NotifyRedDotLifecycleObserver$getUnreadCount$1(this, r100, null), 3, null);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onCreate(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        DefaultLifecycleObserver.CC.$default$onCreate(this, r100);
        a(DowngradeSource.ENTER_CONVERSATION_LIST.getValue());
        this.f313418b.getClass();
        b2.f307776c.observeForever(this.f313421e);
        b();
        AppHost.f326268a.a().j(this.f313422f);
        AccountService.f365697a.E(this.f313423g);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onDestroy(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        DefaultLifecycleObserver.CC.$default$onDestroy(this, r100);
        clear();
    }
}
