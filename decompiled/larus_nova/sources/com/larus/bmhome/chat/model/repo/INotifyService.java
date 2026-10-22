package com.larus.bmhome.chat.model.repo;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.n3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J,\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH&J\u0014\u0010\u0013\u001a\u00020\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\b\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH&¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/chat/model/repo/INotifyService;", "", "createNotifyFragment", "Landroidx/fragment/app/Fragment;", "createNotifyRedDotLifecycleObserver", "Lcom/larus/bmhome/chat/model/repo/INotifyRedDotLifecycleObserver;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "repo", "Lcom/larus/bmhome/chat/model/repo/INotificationRepoService;", "handleSchema", "", "bannerSchema", "", "parent", "Lcom/ixigua/lib/track/ITrackNode;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "enterMethod", "pushInnerNotification", "request", "Lcom/larus/platform/model/NotificationRequest;", "dismissNotification", "", "addInnerNotificationSlotIdleListener", "listener", "Lcom/larus/platform/model/OnInnerNotificationSlotIdleListener;", "removeInnerNotificationSlotIdleListener", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface INotifyService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f307709a = null;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0001J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096\u0001J\t\u0010\u000e\u001a\u00020\u0005H\u0096\u0001J-\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012H\u0096\u0001J\u0013\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u001c\u001a\u00020\u001dH\u0096\u0001¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/chat/model/repo/INotifyService$Companion;", "Lcom/larus/bmhome/chat/model/repo/INotifyService;", "<init>", "()V", "addInnerNotificationSlotIdleListener", "", "listener", "Lcom/larus/platform/model/OnInnerNotificationSlotIdleListener;", "createNotifyFragment", "Landroidx/fragment/app/Fragment;", "createNotifyRedDotLifecycleObserver", "Lcom/larus/bmhome/chat/model/repo/INotifyRedDotLifecycleObserver;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "dismissNotification", "handleSchema", "", "bannerSchema", "", "parent", "Lcom/ixigua/lib/track/ITrackNode;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "enterMethod", "pushInnerNotification", "request", "Lcom/larus/platform/model/NotificationRequest;", "removeInnerNotificationSlotIdleListener", "repo", "Lcom/larus/bmhome/chat/model/repo/INotificationRepoService;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements INotifyService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f307710c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ INotifyService f307711b;

        static {
            f307710c = new Companion();
        }

        @Override // com.larus.bmhome.chat.model.repo.INotifyService
        public final void a(com.larus.commercemembership.impl.component.d r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            this.f307711b.a(r100);
        }

        @Override // com.larus.bmhome.chat.model.repo.INotifyService
        public final void b(com.larus.commercemembership.impl.component.d r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            this.f307711b.b(r100);
        }

        @Override // com.larus.bmhome.chat.model.repo.INotifyService
        public final boolean c(n3 r100) {
            return this.f307711b.c(r100);
        }

        @Override // com.larus.bmhome.chat.model.repo.INotifyService
        public final void d() {
            this.f307711b.d();
        }

        @Override // com.larus.bmhome.chat.model.repo.INotifyService
        public final w1 e() {
            return this.f307711b.e();
        }

        @Override // com.larus.bmhome.chat.model.repo.INotifyService
        public final boolean f(String r100, by7.e r101, Context r102, String r103) {
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r103, "enterMethod");
            return this.f307711b.f(r100, r101, r102, r103);
        }

        @Override // com.larus.bmhome.chat.model.repo.INotifyService
        public final INotifyRedDotLifecycleObserver g(LifecycleCoroutineScope r100) {
            Intrinsics.checkNotNullParameter(r100, "lifecycleScope");
            return this.f307711b.g(r100);
        }

        @Override // com.larus.bmhome.chat.model.repo.INotifyService
        public final Fragment h() {
            return this.f307711b.h();
        }

        private Companion() {
            Object r100 = ServiceManager.get().getService(INotifyService.class);
            Intrinsics.checkNotNull(r100);
            this.f307711b = (INotifyService) r100;
        }
    }

    static {
        f307709a = Companion.f307710c;
    }

    void a(com.larus.commercemembership.impl.component.d r100);

    void b(com.larus.commercemembership.impl.component.d r100);

    boolean c(n3 r100);

    void d();

    w1 e();

    boolean f(String r100, by7.e r101, Context r102, String r103);

    INotifyRedDotLifecycleObserver g(LifecycleCoroutineScope r100);

    Fragment h();
}
