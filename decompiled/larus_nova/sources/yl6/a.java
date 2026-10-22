package yl6;

import com.bytedance.locallife.host.growth.ILifeUserGrowthService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a implements ILifeUserGrowthService {
    public a() {
    }

    @Override // com.bytedance.locallife.host.growth.ILifeUserGrowthService
    public final Map<String, String> a(ILifeUserGrowthService.SaaSTraceBizTag r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return new LinkedHashMap();
    }
}
