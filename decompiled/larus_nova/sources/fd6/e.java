package fd6;

import c12.h;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.BaseGetResourceException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class e implements b<String>, com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String> f476539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b<String> f476540b;

    public e(h r100) {
        this.f476540b = r100;
    }

    @Override // fd6.b
    public final void a(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r100, com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "consumer");
        this.f476539a = r101;
        b<String> r102 = this.f476540b;
        if (r102 == null) goto L6;
        r102.a(r100, this);
        return;
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a
    public final void l(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r100, BaseGetResourceException r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "error");
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String> r102 = this.f476539a;
        if (r102 == null) goto L6;
        r102.l(r100, r101);
        return;
    }
}
