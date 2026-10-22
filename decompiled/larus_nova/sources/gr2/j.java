package gr2;

import com.bytedance.android.livesdk.revenue.service.livecore.IConfig;
import com.bytedance.android.livesdk.revenue.service.livecore.IMixStreamTypeEnumParam;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class j implements IConfig.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f482313b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f482314c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j f482315d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f482316e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MixStreamType f482317a;

    public static final class a {
        public a() {
        }

        public static j a(IMixStreamTypeEnumParam r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            int r101 = i.f482312a[r100.ordinal()];
            if (r101 == 1) goto L13;
            if (r101 == 2) goto L15;
            if (r101 != 3) goto L10;
            return j.f482315d;
        L10:
            throw new NoWhenBranchMatchedException();
        L15:
            return j.f482314c;
        L13:
            return j.f482313b;
        }

        public static j b(MixStreamType r100) {
            Intrinsics.checkNotNullParameter(r100, "real");
            if (r100 != MixStreamType.CLIENT_MIX) goto L7;
            return a(IMixStreamTypeEnumParam.CLIENT_MIX);
        L7:
            if (r100 != MixStreamType.SERVER_MIX) goto L11;
            return a(IMixStreamTypeEnumParam.SERVER_MIX);
        L11:
            if (r100 == MixStreamType.RTC_CLIENT_MIX) goto L13;
            return null;
        L13:
            return a(IMixStreamTypeEnumParam.RTC_CLIENT_MIX);
        }
    }

    static {
        f482316e = new a();
        f482313b = new j(MixStreamType.CLIENT_MIX);
        f482314c = new j(MixStreamType.SERVER_MIX);
        f482315d = new j(MixStreamType.RTC_CLIENT_MIX);
    }

    @Override // xh6.c
    public final Object getReal() {
        return this.f482317a;
    }

    public j(MixStreamType r100) {
        this.f482317a = r100;
    }
}
