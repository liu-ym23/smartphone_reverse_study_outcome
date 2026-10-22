package vt6;

import android.net.Uri;
import com.bytedance.locallife.adapter.impl.host.poi.LifePoiService;
import com.larus.utils.y0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends LifePoiService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f557228b = null;

    static {
        f557228b = new a();
    }

    public a() {
    }

    @Override // com.bytedance.locallife.adapter.impl.host.poi.LifePoiService, vt6.d
    public final Uri interceptSchema(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "originSchemaUri");
        return y0.l(super.interceptSchema(r100), "dynamic", "3");
    }
}
