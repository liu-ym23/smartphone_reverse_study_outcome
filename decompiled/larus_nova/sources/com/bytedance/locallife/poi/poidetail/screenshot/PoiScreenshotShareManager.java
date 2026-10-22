package com.bytedance.locallife.poi.poidetail.screenshot;

import at6.c;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.poi.poidetail.screenshot.model.PoiScreenshotMode;
import com.ss.android.ugc.aweme.poi.screenshot.PoiScreenshotType;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class PoiScreenshotShareManager implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zy6.a f264181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PoiScreenshotType f264182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PthreadHandlerThreadV2 f264183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f264184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final at6.b f264185e;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f264186a = null;

        static {
            int[] r100 = new int[PoiScreenshotType.values().length];
            r100[PoiScreenshotType.POI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f264186a = r100;
        }
    }

    static {
    }

    @Override // at6.c
    public final void OZ() {
        Intrinsics.checkNotNullParameter(null, "event");
    }

    @Override // at6.c
    public final void Pd(String r100, JSONObject r101) {
        c.a.a(r100, r101);
    }

    public PoiScreenshotShareManager(zy6.a r100, PoiScreenshotType r101, PoiScreenshotMode r102) {
        Intrinsics.checkNotNullParameter(r100, "env");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "screenMode");
        this.f264181a = r100;
        this.f264182b = r101;
        this.f264183c = new PthreadHandlerThreadV2("delay_get_screenshot");
        if (b.f264186a[r101.ordinal()] != 1) goto L5;
        new az6.b(r100);
    L5:
        this.f264184d = LazyKt.lazy(new PoiScreenshotShareManager$screenshotListener$2(this));
        this.f264185e = HostServiceUtilsKt.x();
    }
}
