package com.bytedance.timon.permission.storage.manager;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.bytedance.timon.permission.storage.TimonMedia;
import com.bytedance.timon.permission.storage.constant.MediaPickType;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import yg7.e;

/* JADX INFO: loaded from: classes22.dex */
public final class TimonMediaInternal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f270655a = null;

    public static final class a<T> implements xg7.a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xg7.a<T> f270656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TimonMedia.ExtraInfo f270657b;

        public a(xg7.a<T> r100, TimonMedia.ExtraInfo r101) {
            Intrinsics.checkNotNullParameter(r100, "impl");
            Intrinsics.checkNotNullParameter(r101, "extra");
            this.f270656a = r100;
            this.f270657b = r101;
            TimonMediaManager.f270660b.a(MapsKt.mapOf(TuplesKt.to("method_id", String.valueOf(r101.f270648j))));
        }

        @Override // xg7.a
        public final void a(int r100, T r101, String r102) {
            this.f270657b.f270649k.put("result_code", String.valueOf(r100));
            zg7.a r103 = TimonMediaManager.f270660b;
            TimonMedia.ExtraInfo r104 = this.f270657b;
            int r105 = r104.f270648j;
            r103.a(r104.f270649k);
            this.f270656a.a(r100, r101, r102);
        }
    }

    public static final class b implements xg7.a<Unit> {
        public b() {
        }

        @Override // xg7.a
        public final /* bridge */ /* synthetic */ void a(int r100, Unit r101, String r102) {
        }
    }

    static {
        f270655a = new b();
    }

    public static void b(final Activity r100, final TimonMedia.ExtraInfo r101, xg7.a r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        final ah7.a r103 = null;
        Intrinsics.checkNotNullParameter(null, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "info");
        Intrinsics.checkNotNullParameter(r102, "callback");
        r101.f270648j = 310002;
        final a r104 = new a(r102, r101);
        int r105 = com.bytedance.timon.permission.storage.util.b.f270669a;
        if (com.bytedance.timon.permission.storage.util.b.e(r100) == true) goto L6;
        com.bytedance.timon.permission.storage.util.b.b(r100, r101, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, r104, new TimonMediaInternal$insertAlbum$1(r100, r103, r101, r104));
        return;
    L6:
        bh7.b.a(r100, r101, r104);
        throw null;
    }

    public static void g(final Activity r100, TimonMedia.ExtraInfo r101, xg7.a r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "info");
        Intrinsics.checkNotNullParameter(r102, "callback");
        r101.f270648j = 310006;
        final a r103 = new a(r102, r101);
        int r104 = com.bytedance.timon.permission.storage.util.b.f270669a;
        com.bytedance.timon.permission.storage.util.b.b(r100, r101, new String[]{"android.permission.RECORD_AUDIO"}, r103, new TimonMediaInternal$takeAudio$1(r100, r103));
    }

    public static void h(final Activity r100, final Intent r101, TimonMedia.ExtraInfo r102, xg7.a r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r102, "info");
        Intrinsics.checkNotNullParameter(r103, "callback");
        r102.f270648j = 310004;
        final a r104 = new a(r103, r102);
        int r105 = com.bytedance.timon.permission.storage.util.b.f270669a;
        com.bytedance.timon.permission.storage.util.b.b(r100, r102, new String[]{"android.permission.CAMERA"}, r104, new TimonMediaInternal$takePhoto$1(r100, r101, r104));
    }

    public static void i(final Activity r100, final Intent r101, TimonMedia.ExtraInfo r102, xg7.a r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r102, "info");
        Intrinsics.checkNotNullParameter(r103, "callback");
        r102.f270648j = 310005;
        final a r104 = new a(r103, r102);
        int r105 = com.bytedance.timon.permission.storage.util.b.f270669a;
        com.bytedance.timon.permission.storage.util.b.b(r100, r102, new String[]{"android.permission.CAMERA"}, r104, new TimonMediaInternal$takeVideo$1(r100, r101, r104));
    }

    public static void c(Activity r100, MediaPickType r101, boolean r102, TimonMedia.ExtraInfo r103, xg7.a r104) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r103, "info");
        Intrinsics.checkNotNullParameter(r104, "callback");
        r103.f270648j = 310003;
        Map<String, String> r105 = r103.f270649k;
        if (r102 == false) goto L5;
        String r106 = "1";
    L6:
        r105.put(PriorityModule.SCENE_MULTI, r106);
        r103.f270649k.put(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE, String.valueOf(r101.ordinal()));
        r103.f270649k.put("custom_intent", "0");
        a r107 = new a(r104, r103);
        bh7.a.C0304a r108 = new bh7.a.C0304a();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r108.f19046a = r100;
        Intrinsics.checkNotNullParameter(r101, "mediaPickType");
        r108.f19047b = r101;
        r108.f19048c = r102;
        r108.f19049d = null;
        Intrinsics.checkNotNullParameter(r107, "callback");
        r108.f19050e = r107;
        new bh7.a(r108).a();
        return;
    L5:
        r106 = "0";
        goto L6
    }

    public static void a(final Activity r100, final File r101, final int r110, final boolean r111, TimonMedia.ExtraInfo r112, final xg7.a r113) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r112, "info");
        Intrinsics.checkNotNullParameter(r113, "callback");
        int r102 = com.bytedance.timon.permission.storage.util.b.f270669a;
        com.bytedance.timon.permission.storage.util.b.b(r100, r112, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, r113, new TimonMediaInternal$getNewFiles$1(r101, r100, r110, r111, r113));
    }

    public static void d(final Activity r110, final Uri r111, final String[] r112, final Bundle r113, final CancellationSignal r114, final TimonMedia.ExtraInfo r115, xg7.a r116) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r113, "queryArgs");
        Intrinsics.checkNotNullParameter(r115, "info");
        Intrinsics.checkNotNullParameter(r116, "callback");
        r115.f270648j = 310007;
        Map<String, String> r100 = r115.f270649k;
        String r101 = r111.getAuthority();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.put("authority", r101);
        final a r117 = new a(r116, r115);
        MediaPickType r102 = e.a(r111);
        int r103 = com.bytedance.timon.permission.storage.util.b.f270669a;
        com.bytedance.timon.permission.storage.util.b.b(r110, r115, com.bytedance.timon.permission.storage.util.b.c(r110, r102), r117, new TimonMediaInternal$query$2(r110, r111, r112, r113, r114, r115, r117));
    }

    public static void f(final Activity r110, final MediaPickType r111, final String r112, final String[] r113, final String r114, final int r115, final int r210, TimonMedia.ExtraInfo r211, xg7.a r212) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r211, "info");
        Intrinsics.checkNotNullParameter(r212, "callback");
        r211.f270648j = 310009;
        r211.f270649k.put(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE, String.valueOf(r111.ordinal()));
        final a r116 = new a(r212, r211);
        int r100 = com.bytedance.timon.permission.storage.util.b.f270669a;
        com.bytedance.timon.permission.storage.util.b.b(r110, r211, com.bytedance.timon.permission.storage.util.b.c(r110, r111), r116, new TimonMediaInternal$queryMedia$1(r111, r110, r112, r113, r114, r115, r210, r116));
    }

    public static void e(final Activity r110, final Uri r111, final String[] r112, final String r210, final String[] r211, final String r212, final int r213, final int r214, final CancellationSignal r215, final TimonMedia.ExtraInfo r216, xg7.a r217) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r216, "info");
        Intrinsics.checkNotNullParameter(r217, "callback");
        r216.f270648j = 310007;
        Map<String, String> r100 = r216.f270649k;
        String r101 = r111.getAuthority();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.put("authority", r101);
        final a r113 = new a(r217, r216);
        MediaPickType r102 = e.a(r111);
        int r103 = com.bytedance.timon.permission.storage.util.b.f270669a;
        com.bytedance.timon.permission.storage.util.b.b(r110, r216, com.bytedance.timon.permission.storage.util.b.c(r110, r102), r113, new TimonMediaInternal$query$1(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r113));
    }
}
