package k32;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.platform.business.effect.giftview.i;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends a {
    public final Map<String, String> A;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AtomicBoolean f501705t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f501706u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a5 f501707v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Map<String, c5> f501708w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final IBaseUser f501709x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f501710y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final IPlayerActionListener f501711z;

    public c(String r100, a5 r101, Map r102, IBaseUser r103, String r110, i r111, Map r112) {
        Intrinsics.checkNotNullParameter(r100, "dressId");
        Intrinsics.checkNotNullParameter(r103, "user");
        Intrinsics.checkNotNullParameter(r110, "finishSelfSchema");
        Intrinsics.checkNotNullParameter(r111, "playListener");
        String r104 = r103.getIdString();
        String r105 = r103.getNickName();
        String r106 = "";
        if (r105 != null) goto L5;
        r105 = "";
    L5:
        k r107 = r103.getAvatarThumbKt();
        if (r107 == null) goto L13;
        List<String> r108 = r107.getUrls();
        if (r108 == null) goto L13;
        String r109 = (String) CollectionsKt.getOrNull(r108, 0);
        if (r109 == null) goto L13;
        r106 = r109;
    L13:
        super(r104, r105, r106);
        this.f501706u = r100;
        this.f501707v = r101;
        this.f501708w = r102;
        this.f501709x = r103;
        this.f501710y = r110;
        this.f501711z = r111;
        this.A = r112;
        this.f501699p = 90000;
        this.f501705t = new AtomicBoolean(false);
    }
}
