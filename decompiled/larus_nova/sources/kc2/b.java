package kc2;

import ca0.j;
import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.core.util.h;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import vh7.f;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends c implements u3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBaseUser f502380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f502381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f502382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h2 f502383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f502384e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f502385f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IPublicAreaCommon f502386g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f502387h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f502388i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f502389j;

    @Override // kc2.c, com.bytedance.android.live.base.model.message.t
    public final boolean canText() {
        return true;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public final byte[] getRawPayload() {
        return null;
    }

    public final h2 d() {
        h2 r100 = this.f502383d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        boolean r101 = h.f91037a;
        return ((j) h.d(j.class)).findLiteGiftById(this.f502381b);
    }

    @Override // com.bytedance.android.live.base.model.message.u3
    public final IPublicAreaCommon getOrInitPublicAreaCommon() {
        if (this.f502386g != null) goto L6;
        this.f502386g = (IPublicAreaCommon) f.c(IPublicAreaCommon.class);
    L6:
        return this.f502386g;
    }

    public b() {
        this.f502389j = false;
        setMessageMethod("GiftGroupMessage");
    }

    @Override // kc2.c, com.bytedance.android.live.base.model.message.t
    public final boolean supportDisplayText() {
        if (getBaseMessage() != null) goto L5;
    L7:
        return false;
    L5:
        if (getBaseMessage().supportDisplayText() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.base.model.message.u3
    public final IBaseUser getUserInMessage() {
        return this.f502380a;
    }

    @Override // kc2.c, com.bytedance.android.live.base.model.message.t
    public final boolean isCurrentRoom(long r100) {
        if (this.f502388i != r100) goto L5;
        return true;
    L5:
        return false;
    }
}
