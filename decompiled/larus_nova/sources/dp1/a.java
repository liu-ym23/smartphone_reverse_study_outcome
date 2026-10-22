package dp1;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.anniex.utils.k;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.livesdk.config.bc;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f469571a = 0;

    static {
    }

    public static String b(String r100, String r101, boolean r102) {
        Uri r103 = UriProtector.parse(r100);
        Uri.Builder r104 = r103.buildUpon().clearQuery();
        Iterator<String> r105 = UriProtector.getQueryParameterNames(r103).iterator();
    L4:
        if (r105.hasNext() == false) goto L20;
        String r106 = r105.next();
        boolean r107 = true;
        if ((!Intrinsics.areEqual(r106, "url")) == false) goto L4;
        String r108 = UriProtector.getQueryParameter(r103, r106);
        if (Intrinsics.areEqual(r106, "height") == false) goto L19;
        if (r102 == true) goto L19;
        Integer r109 = bc.f119855a.getValue();
        if (r109 != null) goto L14;
    L16:
        r107 = false;
    L17:
        if (r107 == false) goto L19;
        r104.appendQueryParameter(ECFindSimilarConfig.HEIGHT_PERCENT, BDLocationException.ERROR_NETWORK_REQUEST);
        goto L4
    L14:
        if (r109.intValue() != 2) goto L16;
    L19:
        r104.appendQueryParameter(r106, r108);
        goto L4
    L20:
        r104.appendQueryParameter("url", r101);
        return r104.build().toString();
    }

    public static void a(View r100, String r101, Map r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r102, "params");
        boolean r104 = true;
        if (r101 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L11;
        return;
    L11:
        if (r101 != null) goto L13;
    L16:
        String r106 = "";
        if (r104 == true) goto L27;
        if (r101 == null) goto L30;
        r106 = r101;
    L30:
        Uri.Builder r107 = UriProtector.parse(k.c(UriProtector.parse(r101))).buildUpon();     // Catch: Exception -> L29
        Iterator r108 = r102.entrySet().iterator();     // Catch: Exception -> L29
    L24:
        if (r108.hasNext() == false) goto L26;
        Map.Entry r109 = (Map.Entry) r108.next();     // Catch: Exception -> L29
        String r110 = (String) r109.getKey();     // Catch: Exception -> L29
        String r111 = (String) r109.getValue();     // Catch: Exception -> L29
        r107.appendQueryParameter(Uri.encode(r110), Uri.encode(r111));     // Catch: Exception -> L29
        goto L24
    L26:
        r106 = b(r101, r107.build().toString(), r103);     // Catch: Exception -> L29
    L27:
        ((ILiveActionHandler) jc1.k.n(ILiveActionHandler.class)).handle(r100.getContext(), r106);
        return;
    L13:
        if (r101.length() == 0) goto L16;
        r104 = false;
        goto L16
    L5:
        if (r101.length() == 0) goto L8;
        r105 = false;
        goto L9
    }
}
