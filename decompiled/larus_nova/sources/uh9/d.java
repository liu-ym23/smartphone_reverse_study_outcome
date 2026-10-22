package uh9;

import com.bytedance.keva.Keva;
import com.larus.platform.service.AccountService;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes30.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f550114a = null;

    static {
        f550114a = LazyKt.lazy(new c());
    }

    public static String b() {
        return "key_doubao_feed_migrate_finished_".concat(AccountService.f365697a.getUserId());
    }

    public static boolean a() {
        String r100 = b();
        return ((Keva) f550114a.getValue()).getBoolean(r100, false);
    }
}
