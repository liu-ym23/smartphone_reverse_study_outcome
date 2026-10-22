package hd6;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f484606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f484607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f484608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<e3> f484609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f484610e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f484611f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SendGiftSource f484612g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f484613h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f484614i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final IBaseUser f484615j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<String> f484616k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<? extends IBaseUser> f484617l;

    public static final class a {
    }

    static {
    }

    public final String a() {
        String r100 = this.f484607b;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L15;
        String r102 = this.f484614i;
        if (r102 != null) goto L13;
        r102 = null;
    L13:
        if (r102 != null) goto L17;
        return "";
    L17:
        return r102;
    L15:
        String r103 = this.f484607b;
        Intrinsics.checkNotNull(r103);
        return r103;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public c(int r100, String r101, int r102, List r103, long r104, String r105, IBaseUser r106, List r110) {
        Intrinsics.checkNotNullParameter(r105, "cardName");
        this.f484606a = r100;
        this.f484607b = r101;
        this.f484608c = r102;
        this.f484609d = r103;
        this.f484610e = r104;
        this.f484611f = r105;
        this.f484612g = null;
        this.f484613h = 0;
        this.f484614i = null;
        this.f484615j = r106;
        this.f484616k = null;
        this.f484617l = r110;
    }
}
