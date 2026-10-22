package gr2;

import com.bytedance.android.livesdk.revenue.service.livecore.IConfig;
import com.bytedance.live.livelink.kmp.api.base.config.Character;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements IConfig.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f482297b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f482298c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Character f482299a;

    /* JADX INFO: renamed from: gr2.a$a, reason: collision with other inner class name */
    public static final class C6056a {
    }

    static {
        f482297b = new a(Character.ANCHOR);
        f482298c = new a(Character.GUEST);
    }

    @Override // xh6.c
    public final Object getReal() {
        return this.f482299a;
    }

    public a(Character r100) {
        this.f482299a = r100;
    }
}
