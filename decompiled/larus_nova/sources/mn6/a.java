package mn6;

import android.net.Uri;
import com.bytedance.locallife.rate.LifeServiceRateListLynxFragment;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    public static final boolean a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return "1".equals(UriProtector.getQueryParameter(r100, LifeServiceRateListLynxFragment.IS_LIFE_POI));
    }
}
