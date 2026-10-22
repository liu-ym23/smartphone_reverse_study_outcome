package com.larus.bot.api;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import ou8.a;
import zp9.u;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ\b\u0010\u0006\u001a\u00020\u0007H&J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\f\u001a\u00020\rH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/larus/bot/api/IBotDiscoverService;", "", "botDiscoverRouterUrl", "", "getBotDiscoverRouterUrl", "()Ljava/lang/String;", "createBotDiscoverFragment", "Lcom/larus/bot/api/model/discover/IBotDiscoverFragment;", "createTabListLayout", "Lcom/larus/platform/api/creation/ITabListLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getMaskIconRes", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBotDiscoverService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f317641a = null;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0001J\t\u0010\n\u001a\u00020\u000bH\u0096\u0001R\u0012\u0010\f\u001a\u00020\rX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/bot/api/IBotDiscoverService$Companion;", "Lcom/larus/bot/api/IBotDiscoverService;", "<init>", "()V", "createBotDiscoverFragment", "Lcom/larus/bot/api/model/discover/IBotDiscoverFragment;", "createTabListLayout", "Lcom/larus/platform/api/creation/ITabListLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getMaskIconRes", "", "botDiscoverRouterUrl", "", "getBotDiscoverRouterUrl", "()Ljava/lang/String;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IBotDiscoverService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f317642c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBotDiscoverService f317643b;

        static {
            f317642c = new Companion();
        }

        @Override // com.larus.bot.api.IBotDiscoverService
        public final String a() {
            return this.f317643b.a();
        }

        @Override // com.larus.bot.api.IBotDiscoverService
        public final a b() {
            return this.f317643b.b();
        }

        @Override // com.larus.bot.api.IBotDiscoverService
        public final int c() {
            return this.f317643b.c();
        }

        @Override // com.larus.bot.api.IBotDiscoverService
        public final u d(Context r100) {
            return this.f317643b.d(r100);
        }

        private Companion() {
            this.f317643b = (IBotDiscoverService) ServiceManager.get().getService(IBotDiscoverService.class);
        }
    }

    static {
        f317641a = Companion.f317642c;
    }

    String a();

    a b();

    int c();

    u d(Context r100);
}
