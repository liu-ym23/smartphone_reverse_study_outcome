package k17;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import java.util.Locale;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f501380a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f501381b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f501382c = null;

    static {
        Locale r100 = Locale.US;
        String r101 = String.format(r100, "%04d", new Object[]{22});
        String r102 = String.format(r100, "%03d", new Object[]{9});
        f501380a = "062114" + r101;
        f501381b = BDLocationException.ERROR_TMAP_WGS84 + r101 + r102;
        f501382c = "062114" + r101 + AdBaseConstants.InfoErrorCode.WEB_URL_NULL;
    }
}
