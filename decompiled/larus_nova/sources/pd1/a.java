package pd1;

import com.bytedance.android.livesdk.account.impl.DouyinOpenSDKBrickModule_ProvideDouyinOpenSDKServiceFactory;
import com.bytedance.android.livesdk.account.impl.i;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Provider<od1.a> f528641a;

    public a(i r100) {
        this.f528641a = DoubleCheck.provider(DouyinOpenSDKBrickModule_ProvideDouyinOpenSDKServiceFactory.create(r100));
    }
}
