package com.larus.home.impl.reddot;

import androidx.lifecycle.Observer;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.auth.c1;
import com.larus.bmhome.auth.e0;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.INotifyService;
import com.larus.bmhome.chat.reddot.f;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.main.tab.config.BottomTabConfigManager;
import com.larus.home.impl.reddot.api.RedDotAction;
import com.larus.home.impl.reddot.api.RedDotType;
import com.larus.minor.api.IMinorService;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.i3;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import nf9.e;

/* JADX INFO: loaded from: classes29.dex */
public final class UpdateRedDotManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f346019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f346020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f346021c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f346022d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.larus.bmhome.chat.reddot.a f346023e = null;

    public static final class a implements f09.a.b {
        public a() {
        }

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
        }

        @Override // f09.a.b
        public final void onAppForeground() {
        }

        @Override // f09.a.b
        public final void onAppBackground() {
            FLogger.f375446a.i("UpdateRedDotManager", "onAppBackground...");
            int r100 = UpdateRedDotManager.f346019a;
            UpdateRedDotManager.c();
            String r101 = DowngradeSource.ENTER_BACKGROUND.getValue();
            AccountService r102 = AccountService.f365697a;
            if (r102.isLogin().booleanValue() == false) goto L10;
            String r103 = r102.getUserId();
            if (r103.length() != 0) goto L8;
            boolean r104 = true;
        L9:
            if (r104 == true) goto L10;
        L11:
            ArrayList r105 = new ArrayList();
            int r106 = UpdateRedDotManager.a();
            RedDotAction r107 = RedDotAction.Set;
            r105.add(new fc9.a(r107.getIndex(), r106, RedDotType.Notice.getIndex()));
            r105.add(new fc9.a(r107.getIndex(), UpdateRedDotManager.f346019a, RedDotType.Conversation.getIndex()));
            int r108 = UpdateRedDotManager.f346019a + r106;
            fc9.b r109 = new fc9.b(r103, new fc9.a(r107.getIndex(), r108, RedDotType.All.getIndex()), r105);
            BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new UpdateRedDotManager$tryRequestUpdateRedDot$1(r109, r101, null), 2, null);
            return;
        L8:
            r104 = false;
        L10:
            r103 = "0";
            goto L11
        }
    }

    public static final class b implements e {
        public b() {
        }

        @Override // nf9.e
        public final String a() {
            return null;
        }

        @Override // nf9.e
        public final void onUpdate(int r100) {
            FLogger.f375446a.i("UpdateRedDotManager", "OnUnReadBadgeCountObserver: count = " + r100);
            UpdateRedDotManager.f346019a = r100;
        }
    }

    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f346024a;

        public c(com.larus.home.impl.reddot.b r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f346024a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f346024a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f346024a.invoke(r100);
        }
    }

    public UpdateRedDotManager() {
    }

    static {
        f346021c = LazyKt.lazy(new com.larus.home.impl.reddot.a());
        f346022d = new a();
        f346023e = new com.larus.bmhome.chat.reddot.a(new b());
    }

    public static int a() {
        BottomTabConfigManager r100 = BottomTabConfigManager.f345968a;
        if (r100.j() == false) goto L5;
    L6:
        Integer r101 = INotifyService.f307709a.e().a().getValue();
        if (r101 != null) goto L11;
    L9:
        return 0;
    L11:
        return r101.intValue();
    L5:
        if (r100.a() == false) goto L9;
        goto L6
    }

    public static void b() {
        f r100 = f.f308497a;
        f.d(f346023e);
    }

    public static void c() {
        c1<e0> r100 = AuthModelDelegate.f297134b.c().getValue();
        if (r100 == null) goto L5;
        e0 r101 = r100.f295753d;
    L6:
        int r102 = 0;
        if (r101 == null) goto L9;
        boolean r103 = r101.D();
    L10:
        if (r101 == null) goto L12;
        boolean r104 = r101.d();
    L14:
        if (AppHost.f326268a.a().isAppBackground() == true) goto L16;
        return;
    L16:
        if (r104 == true) goto L27;
        int r105 = f346019a;
        int r106 = a();
        if (IMinorService.f359156a.a() == false) goto L22;
        r102 = r105;
    L26:
        r102 = RangesKt.coerceAtMost(r102, 99);
        goto L27
    L22:
        if (AccountService.f365697a.isLogin().booleanValue() == false) goto L24;
    L25:
        r102 = r105 + r106;
        goto L26
    L24:
        if (i3.f365750a.f() == false) goto L26;
    L27:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new UpdateRedDotManager$updateRedBadge$1(r102, r103, r104, null), 2, null);
        return;
    L12:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r101 = null;
        goto L6
    }
}
