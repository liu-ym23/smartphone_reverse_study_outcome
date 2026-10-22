package ed4;

import android.net.Uri;
import com.bytedance.caijing.sdk.infra.base.api.env.CJHostService;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f472204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, ? extends Object> f472205b;

    public final Uri a() {
        Uri r100 = UriProtector.parse(this.f472204a);
        Uri.Builder r101 = r100.buildUpon();
        if (r101 == null) goto L10;
        r101.appendQueryParameter("ignore_wait_reused_request", "1");
        if (Intrinsics.areEqual("1", UriProtector.getQueryParameter(r100, "enable_font_scale")) == false) goto L12;
        ve4.a.f554342a.getClass();
        CJHostService r102 = (CJHostService) ve4.a.a(CJHostService.class);
        if (r102 == null) goto L12;
        r101.appendQueryParameter("font_scale", String.valueOf(r102.getFontScale()));
    L12:
        return r101.build();
    L10:
        return null;
    }

    public d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        this.f472204a = r100;
    }
}
