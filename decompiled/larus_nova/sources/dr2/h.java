package dr2;

import android.content.Context;
import android.util.Pair;
import com.bytedance.android.livesdk.revenue.host.RevHostPluginType;

/* JADX INFO: loaded from: classes11.dex */
public interface h extends dy0.a {
    boolean checkPluginLoaded(String r100);

    String getHostPackageName();

    Pair<Boolean, String> loadLibraryV2(int r100, Context r101, String r102, String r103, ClassLoader r104);

    com.bytedance.android.livesdk.revenue.network.g r8(RevHostPluginType r100);
}
