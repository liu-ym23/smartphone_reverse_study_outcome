package my1;

import com.bytedance.android.livesdk.gift.model.h1;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lmy1/a;", "", "", "speedyGift", "Ljava/lang/String;", "delay", "personalGiftStr", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f516361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h1 f516362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f516363c;

    @SerializedName("delay")
    public String delay;

    @SerializedName("personal_gift")
    public String personalGiftStr;

    @SerializedName("speedy_gift")
    public String speedyGift;

    public a() {
        this.speedyGift = "";
        this.delay = "";
        this.personalGiftStr = "";
        this.f516363c = 0L;
    }
}
