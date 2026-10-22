package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.bytedance.geckox.model.LocalPackageModel;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECPreloadGeckoChannelUtil {
    public static boolean a;
    public static int b;

    public static final class a extends GeckoUpdateListener {
        public a() {
        }

        public final void onLocalNewestVersion(LocalPackageModel r2) {
            super.onLocalNewestVersion(r2);
            if (r2 == null) goto L6;
            r2.getChannel();
            return;
        }

        public final void onUpdateFailed(UpdatePackage r1, Throwable r2) {
            super.onUpdateFailed(r1, r2);
            if (r1 == null) goto L6;
            r1.getChannel();
            return;
        }

        public final void onUpdateSuccess(UpdatePackage r1, long r2) {
            super.onUpdateSuccess(r1, r2);
            if (r1 == null) goto L6;
            r1.getChannel();
            return;
        }
    }

    public ECPreloadGeckoChannelUtil() {
    }

    public static void a() {
        hh2.g r0 = hh2.f.a.a;
        if (r0 == null) goto L7;
        Boolean r1 = r0.o();
        if (r1 == null) goto L7;
        boolean r2 = r1.booleanValue();
    L8:
        if (r2 == true) goto L11;
        return;
    L11:
        if (a == false) goto L13;
        return;
    L13:
        a = true;
        int r3 = LiveSettingKeys.getEC_ANNIE_PRELOAD_ACCESS_RESOURCE_ENABLE_TYPE();
        b = r3;
        if (r3 != 0) goto L16;
        return;
    L16:
        List<String> r4 = LiveSettingKeys.getEC_ANNIE_PRELOAD_ACCESS_RESOURCE_CHANNELS_LIST();
        Objects.toString(r4);
        if (r4.isEmpty() == false) goto L19;
        return;
    L19:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ECPreloadGeckoChannelUtil$startPreload$1(r4, null), 3, null);
        return;
    L7:
        r2 = false;
        goto L8
    }

    static {
    }

    public static boolean b(List r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "channels");
        if (ECAppInfoService.e.i() == false) goto L5;
        String r0 = "36723dc3e85a23e701d1697d57de07ed";
    L6:
        GeckoClient r1 = com.bytedance.geckox.a.a(r0);
        if (r1 != null) goto L9;
        return false;
    L9:
        ArrayList r3 = new ArrayList();
        Iterator r10 = r8.iterator();
    L10:
        String r6 = null;
        if (r10.hasNext() == false) goto L35;
        String r4 = (String) r10.next();
        Intrinsics.checkNotNullParameter(r0, "accessKey");
        Intrinsics.checkNotNullParameter(r4, "channel");
        com.bytedance.geckox.b r7 = com.bytedance.geckox.b.a.a;
        Map r11 = GlobalManager.d;
        if (r11 == null) goto L15;
        r6 = (String) ((ConcurrentHashMap) r11).get(r0);
    L15:
        if (r6 != null) goto L17;
    L20:
        boolean r12 = true;
    L21:
        if (r12 == false) goto L23;
        boolean r5 = false;
    L32:
        if (r5 == true) goto L10;
        r3.add(r4);
        goto L10
    L23:
        String r13 = ResLoadUtils.getChannelPath(new PolarisFileWrapper(r6), r0, r4);
        if (r13 != null) goto L26;
    L29:
        boolean r14 = true;
    L30:
        r5 = true ^ r14;
        goto L32
    L26:
        if (StringsKt.isBlank(r13) == true) goto L29;
        r14 = false;
        goto L30
    L17:
        if (StringsKt.isBlank(r6) == true) goto L20;
        r12 = false;
        goto L21
    L35:
        if ((!r3.isEmpty()) == true) goto L37;
    L43:
        return true;
    L37:
        if (r9 != 2) goto L43;
        OptionCheckUpdateParams r15 = new OptionCheckUpdateParams().setListener(new a());
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r2 = r3.iterator();
    L40:
        if (r2.hasNext() == false) goto L42;
        r16.add(new CheckRequestBodyModel.TargetChannel((String) r2.next()));
        goto L40
    L42:
        r1.checkUpdateMulti(null, MapsKt.mapOf(TuplesKt.to(r0, r16)), r15);
        goto L43
    L5:
        r0 = "5fb33cde3ebff01c8433ddc22aac0816";
        goto L6
    }
}
