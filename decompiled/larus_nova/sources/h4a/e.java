package h4a;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.platform.api.g3;
import com.larus.platform.service.i2;
import com.larus.platform.service.k2;
import com.larus.xbridge.impl.choosemedia.BDXFileSelectionMethodHelper;
import com.larus.xbridge.impl.choosemedia.features.BDXPickPhotosAndVideosFeature;
import com.larus.xbridge.impl.choosemedia.features.BDXPickVideosFeature;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class e implements hx7.c {
    public e() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.larus.xbridge.impl.choosemedia.features.i] */
    @Override // hx7.c
    public final void a(Context r110, final hx7.j r111, tx7.d.a r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        j4a.g r100 = j4a.g.f497386a;
        Activity r101 = r100.getActivity(r110);
        final d r102 = new d(r101, r112, new WeakReference(r101));
        Intrinsics.checkNotNullParameter(r111, "params");
        ComponentCallbacks2 r103 = r100.getActivity(r102.f379825a);
        boolean r104 = false;
        if ((r103 instanceof ug9.b) == false) goto L6;
        ((ug9.b) r103).I0(r102);
        i4a.a r105 = 0;
    L8:
        WeakReference r106 = new WeakReference(r103);
        List<String> r107 = r111.f487510a;
        String r108 = r111.f487511b;
        BDXFileSelectionMethodHelper.FeatureType.Companion.getClass();
        Intrinsics.checkNotNullParameter(r108, "sourceType");
        List<String> r109 = r107;
        if (r109 != null) goto L11;
    L14:
        boolean r113 = true;
    L15:
        if (r113 == false) goto L18;
        BDXFileSelectionMethodHelper.FeatureType r114 = BDXFileSelectionMethodHelper.FeatureType.UNSUPPORTED;
    L73:
        if (r114 != BDXFileSelectionMethodHelper.FeatureType.UNSUPPORTED) goto L75;
        r102.onFailed(-3, "Invalid fileType and sourceType in params");
        return;
    L75:
        int r115 = BDXFileSelectionMethodHelper.b.f379829a[r114.ordinal()];
        if (r115 != 1) goto L78;
        final BDXPickVideosFeature r116 = new BDXPickVideosFeature(r106, r102, r105);
        r102.f379826b = r116;
        Intrinsics.checkNotNullParameter(r111, "params");
        Activity r117 = r116.f379838b.get();
        Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type android.app.Activity");
        final Activity r118 = r117;
        if ((r118 instanceof FragmentActivity) == false) goto L195;
        k2 r119 = k2.f365755a;
        g3.a.b((FragmentActivity) r118, new com.larus.xbridge.impl.choosemedia.features.f(r116, r118));
        return;
    L195:
        return;
    L78:
        if (r115 != 2) goto L80;
        final com.larus.xbridge.impl.choosemedia.features.k r120 = new com.larus.xbridge.impl.choosemedia.features.k(r106, r102, r105);
        r102.f379826b = r120;
        Intrinsics.checkNotNullParameter(r111, "params");
        r120.f379892d = Intrinsics.areEqual(r111.f487514e, Boolean.TRUE);
        final ?? r121 = new com.larus.xbridge.impl.choosemedia.features.i(r120, r111);
        Activity r122 = r120.f379890b.get();
        if (r122 != null) goto L151;
        return;
    L151:
        if (r120.f379892d == false) goto L158;
        if (ContextCompat.checkSelfPermission(r122, "android.permission.CAMERA") != 0) goto L158;
        if (ContextCompat.checkSelfPermission(r122, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) goto L158;
        r121.invoke();
        return;
    L158:
        if (r120.f379892d == false) goto L160;
    L162:
        List<String> r123 = CollectionsKt.mutableListOf(new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"});
        if ((r122 instanceof FragmentActivity) == false) goto L194;
        i2.f365748b.a((FragmentActivity) r122, r123, new com.larus.xbridge.impl.choosemedia.features.j(r121, r120));
        return;
    L194:
        return;
    L160:
        if (ContextCompat.checkSelfPermission(r122.getApplication(), "android.permission.CAMERA") != 0) goto L162;
        r121.invoke();
        return;
    L80:
        if (r115 != 3) goto L82;
        final com.larus.xbridge.impl.choosemedia.features.h r124 = new com.larus.xbridge.impl.choosemedia.features.h(r106, r102, r105);
        r102.f379826b = r124;
        Intrinsics.checkNotNullParameter(r111, "params");
        final Activity r125 = r124.f379868b.get();
        if (r125 != null) goto L112;
        r124.f379869c.onFailed(0, "Activity not found");
        return;
    L112:
        if (r125.getPackageManager().hasSystemFeature("android.hardware.camera.any") == true) goto L115;
        r124.f379869c.onFailed(0, "Camera feature not found");
        return;
    L115:
        if (new Intent("android.media.action.IMAGE_CAPTURE").resolveActivity(r125.getPackageManager()) != null) goto L117;
        r124.f379869c.onFailed(0, "Camera app not found");
        return;
    L117:
        r124.f379875i = r111.f487515f;
        Boolean r126 = r111.f487513d;
        Boolean r127 = Boolean.TRUE;
        if (Intrinsics.areEqual(r126, r127) == false) goto L120;
    L123:
        boolean r128 = true;
    L124:
        r124.f379876j = r128;
        r124.f379877k = r111.f487516g;
        r124.f379878l = Intrinsics.areEqual(r111.f487514e, r127);
        if (ContextCompat.checkSelfPermission(r125, "android.permission.CAMERA") != 0) goto L127;
        boolean r129 = true;
    L129:
        if (r124.f379878l == false) goto L135;
        if (r129 == true) goto L132;
    L134:
        r129 = false;
        goto L135
    L132:
        if (ContextCompat.checkSelfPermission(r125, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) goto L134;
        r129 = true;
    L135:
        if (r129 == false) goto L141;
        com.larus.xbridge.impl.choosemedia.features.h.c r130 = r124.f379874h;
        if (r130 == null) goto L139;
        r130.cancel(false);
    L139:
        com.larus.xbridge.impl.choosemedia.features.h.c r131 = new com.larus.xbridge.impl.choosemedia.features.h.c(r125, r124, r124.f379867a);
        r131.executeOnExecutor(r124.f379870d, new Unit[0]);
        r124.f379874h = r131;
        return;
    L141:
        if (r124.f379878l == false) goto L143;
        ArrayList r132 = CollectionsKt.arrayListOf(new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"});
    L145:
        if ((r125 instanceof FragmentActivity) == false) goto L193;
        i2.f365748b.a((FragmentActivity) r125, r132, new com.larus.xbridge.impl.choosemedia.features.g(r124, r125));
        return;
    L193:
        return;
    L143:
        r132 = CollectionsKt.arrayListOf(new String[]{"android.permission.CAMERA"});
        goto L145
    L127:
        r129 = false;
        goto L129
    L120:
        if (r111.f487516g == true) goto L123;
        r128 = false;
        goto L124
    L82:
        if (r115 != 4) goto L84;
        final com.larus.xbridge.impl.choosemedia.features.e r133 = new com.larus.xbridge.impl.choosemedia.features.e(r106, r102, r105);
        r102.f379826b = r133;
        Intrinsics.checkNotNullParameter(r111, "params");
        r133.f379852d = r111.f487512c;
        Boolean r134 = r111.f487513d;
        Boolean r135 = Boolean.TRUE;
        if (Intrinsics.areEqual(r134, r135) == false) goto L93;
    L96:
        boolean r136 = true;
    L97:
        r133.f379853e = r136;
        if (r133.f379852d <= 1) goto L100;
        boolean r137 = true;
    L101:
        if (r137 == true) goto L104;
        r104 = r111.f487516g;
    L104:
        r133.f379854f = r104;
        Intrinsics.areEqual(r111.f487514e, r135);
        r133.f379855g = -1;
        Activity r138 = r133.f379850b.get();
        Intrinsics.checkNotNull(r138, "null cannot be cast to non-null type android.app.Activity");
        final Activity r139 = r138;
        if ((r139 instanceof FragmentActivity) == false) goto L192;
        k2 r140 = k2.f365755a;
        g3.a.a(null, (FragmentActivity) r139, false, null, false, new com.larus.xbridge.impl.choosemedia.features.b(r133, r139), 29);
        return;
    L192:
        return;
    L100:
        r137 = false;
        goto L101
    L93:
        if (r111.f487516g == true) goto L96;
        r136 = false;
        goto L97
    L84:
        if (r115 != 5) goto L190;
        final BDXPickPhotosAndVideosFeature r141 = new BDXPickPhotosAndVideosFeature(r106, r102, r105);
        r102.f379826b = r141;
        Intrinsics.checkNotNullParameter(r111, "params");
        r141.f379834d = r111.f487516g;
        Activity r142 = r141.f379832b.get();
        Intrinsics.checkNotNull(r142, "null cannot be cast to non-null type android.app.Activity");
        final Activity r143 = r142;
        if ((r143 instanceof FragmentActivity) == false) goto L191;
        k2 r144 = k2.f365755a;
        g3.a.b((FragmentActivity) r143, new com.larus.xbridge.impl.choosemedia.features.a(r141, r143));
        return;
    L191:
        return;
    L190:
        return;
    L18:
        if (r107.size() <= 1) goto L48;
        List<String> r145 = r107;
        boolean r146 = r145 instanceof Collection;
        if (r146 == true) goto L22;
    L24:
        Iterator<T> r147 = r145.iterator();
    L26:
        if (r147.hasNext() == false) goto L31;
        if (Intrinsics.areEqual(((String) r147.next()).toLowerCase(Locale.getDefault()), "image") == false) goto L26;
        boolean r148 = true;
    L32:
        if (r148 == false) goto L48;
        if (r146 == true) goto L35;
    L37:
        Iterator<T> r149 = r145.iterator();
    L39:
        if (r149.hasNext() == false) goto L43;
        if (Intrinsics.areEqual(((String) r149.next()).toLowerCase(Locale.getDefault()), "video") == false) goto L39;
        boolean r150 = true;
    L44:
        if (r150 == false) goto L48;
        if (Intrinsics.areEqual(r108.toLowerCase(Locale.getDefault()), "album") == false) goto L48;
        r114 = BDXFileSelectionMethodHelper.FeatureType.PICK_PHOTO_AND_VIDEO_FROM_ALBUM;
    L43:
        r150 = false;
        goto L44
    L35:
        if (r145.isEmpty() == false) goto L37;
    L31:
        r148 = false;
        goto L32
    L22:
        if (r145.isEmpty() == false) goto L24;
    L48:
        String r151 = (String) ListProtector.get(r107, 0);
        if (r151 != null) goto L51;
        r114 = BDXFileSelectionMethodHelper.FeatureType.UNSUPPORTED;
        goto L73
    L51:
        if (Intrinsics.areEqual(r151.toLowerCase(Locale.getDefault()), "image") == false) goto L56;
        if (Intrinsics.areEqual(r108.toLowerCase(Locale.getDefault()), "camera") == false) goto L56;
        r114 = BDXFileSelectionMethodHelper.FeatureType.TAKE_PHOTO;
    L56:
        if (Intrinsics.areEqual(r151.toLowerCase(Locale.getDefault()), "image") == false) goto L61;
        if (Intrinsics.areEqual(r108.toLowerCase(Locale.getDefault()), "album") == false) goto L61;
        r114 = BDXFileSelectionMethodHelper.FeatureType.PICK_PHOTO_FROM_ALBUM;
    L61:
        if (Intrinsics.areEqual(r151.toLowerCase(Locale.getDefault()), "video") == false) goto L66;
        if (Intrinsics.areEqual(r108.toLowerCase(Locale.getDefault()), "camera") == false) goto L66;
        r114 = BDXFileSelectionMethodHelper.FeatureType.TAKE_VIDEO;
    L66:
        if (Intrinsics.areEqual(r151.toLowerCase(Locale.getDefault()), "video") == true) goto L68;
    L70:
        r114 = BDXFileSelectionMethodHelper.FeatureType.UNSUPPORTED;
        goto L73
    L68:
        if (Intrinsics.areEqual(r108.toLowerCase(Locale.getDefault()), "album") == false) goto L70;
        r114 = BDXFileSelectionMethodHelper.FeatureType.PICK_VIDEO_FROM_ALBUM;
        goto L73
    L11:
        if (r109.isEmpty() == true) goto L14;
        r113 = false;
        goto L15
    L6:
        if ((r103 instanceof FragmentActivity) == false) goto L170;
        r105 = new i4a.a(r102);
        goto L8
    L170:
        r102.onFailed(0, "Failed to find proper activity");
    }
}
