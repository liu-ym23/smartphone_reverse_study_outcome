package f1c;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.preload.v2.api.IPrimaryTabService;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class a implements IPrimaryTabService {
    @Inject
    public a() {
    }

    @Override // com.ss.android.lark.preload.v2.api.IPrimaryTabService
    public final String getDefaultTabName() {
        Log.i("DefaultPrimaryTabService", "getDefaultTabName return empty");
        return "";
    }
}
