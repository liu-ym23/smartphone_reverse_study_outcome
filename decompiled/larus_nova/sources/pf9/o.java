package pf9;

import com.larus.im.service.audio.z0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class o implements z0.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f528951k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f528952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f528953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f528954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f528955d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f528956e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f528957f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f528958g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f528959h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f528960i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f528961j;

    public static final class a {
        public static o a(boolean r110, boolean r111, boolean r112, boolean r113, String r114, String r115, String r116, String r117, String r210, String r211) {
            Intrinsics.checkNotNullParameter(r114, "noticeTitle");
            Intrinsics.checkNotNullParameter(r115, "botId");
            Intrinsics.checkNotNullParameter(r116, "conversationId");
            Intrinsics.checkNotNullParameter(r117, "styleId");
            Intrinsics.checkNotNullParameter(r210, "audioMetrics");
            return new o(r110, r111, r112, r113, r114, r115, r116, r117, r210, r211);
        }
    }

    static {
    }

    public o(boolean r100, boolean r101, boolean r102, boolean r103, String r104, String r105, String r106, String r107, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r104, "noticeTitle");
        Intrinsics.checkNotNullParameter(r105, "botId");
        Intrinsics.checkNotNullParameter(r106, "conversationId");
        Intrinsics.checkNotNullParameter(r107, "styleId");
        Intrinsics.checkNotNullParameter(r110, "audioMetrics");
        this.f528952a = r100;
        this.f528953b = r101;
        this.f528954c = r102;
        this.f528955d = r103;
        this.f528956e = r104;
        this.f528957f = r105;
        this.f528958g = r106;
        this.f528959h = r107;
        this.f528960i = r110;
        this.f528961j = r111;
    }
}
