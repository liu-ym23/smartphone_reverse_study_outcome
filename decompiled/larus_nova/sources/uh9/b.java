package uh9;

import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.reddot.IConversationRedDotService;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f550110a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile OfficeSDKUserApi f550111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f550112c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final uh9.a f550113d = null;

    public static final class a implements hza.a {
        public a() {
        }

        @Override // hza.a
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "userId");
            FLogger r101 = FLogger.f375446a;
            r101.e("DouBaoFeedMigrationListener", "doubao feed migration finished, larkUid=" + r100 + " uid=" + AccountService.f365697a.getUserId());
            String r102 = d.b();
            ((Keva) d.f550114a.getValue()).storeBoolean(r102, true);
            r101.w("DouBaoFeedMigrationState", "markMigrateFinished cacheKey=" + r102);
            IConversationRedDotService r103 = (IConversationRedDotService) ServiceManager.get().getService(IConversationRedDotService.class);
            if (r103 == null) goto L6;
            r103.a();
            return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [uh9.a] */
    static {
        f550110a = new AtomicBoolean(false);
        f550112c = new a();
        f550113d = new uh9.a();
    }
}
