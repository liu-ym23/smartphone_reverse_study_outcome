package lv1;

import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.livesdkapi.feature.IFeatureOuterService;
import jc1.k;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements IFeatureOuterService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f510885a = null;

    public a() {
    }

    static {
        f510885a = new a();
    }

    @Override // com.bytedance.android.livesdkapi.feature.IFeatureOuterService
    public final IFeatureService getFeatureService() {
        return (IFeatureService) k.f(IFeatureService.class);
    }
}
