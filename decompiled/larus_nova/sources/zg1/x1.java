package zg1;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;

/* JADX INFO: loaded from: classes7.dex */
public final class x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBaseUser f571979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f571980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f571981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f571982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f571983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public py.k f571984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f571985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f571986h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f571987i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.android.livesdk.gift.model.h2 f571988j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.android.live.base.model.message.m0 f571989k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f571990l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public IPublicAreaCommon f571991m;

    public final String toString() {
        return "NormalGiftEndEvent{fromUserId=" + this.f571979a.getIdString() + ", giftId=" + this.f571981c + ", messageId=" + this.f571989k.getMessageId() + '}';
    }

    public x1(IBaseUser r100, String r101, long r102) {
        this.f571990l = false;
        this.f571979a = r100;
        this.f571980b = r101;
        this.f571981c = r102;
    }
}
