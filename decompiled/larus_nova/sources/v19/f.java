package v19;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.ContextThemeWrapper;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f552472a = null;

    static {
        f552472a = new String[]{"com.bytedance.android.shopping.", "com.bytedance.android.ec.", "com.larus.live.impl.ttlivesdk.DefaultLivePlayerActivity", "com.ss.android.ugc.aweme.search.common.activity.ECSearchSaaSActivity"};
    }

    public static final void a(Resources.Theme r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
    L10:
        r100.applyStyle(R.style.Theme_OApp_BaseAttr, false);
    L12:
        if (com.larus.platform.service.z2.f365865a.enableSwDpOffline() == false) goto L15;
        r100.applyStyle(R.style.Theme_OApp_BaseDimenAttr, true);
        return;
    L15:
        return;
    L8:
        if (com.larus.platform.service.z2.f365865a.enableChatInputIconCompat() == false) goto L10;
        r100.applyStyle(R.style.Theme_OApp_BaseAttrCompat, false);
        goto L12
    L5:
        r101 = false;
        goto L6
    }

    public static final void b(Resources.Theme r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
    L10:
        r100.applyStyle(R.style.Theme_OApp_Dark, true);
        return;
    L8:
        if (com.larus.platform.service.z2.f365865a.enableChatInputIconCompat() == false) goto L10;
        r100.applyStyle(R.style.Theme_OApp_DarkCompat, true);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static final void c(Resources.Theme r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
    L10:
        r100.applyStyle(R.style.Theme_OApp_Light, true);
        return;
    L8:
        if (com.larus.platform.service.z2.f365865a.enableChatInputIconCompat() == false) goto L10;
        r100.applyStyle(R.style.Theme_OApp_LightCompat, true);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static final Context d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
    L10:
        int r102 = R.style.Theme_OApp_BaseAttr;
    L11:
        ContextThemeWrapper r103 = new ContextThemeWrapper(r100, r102);
        if (com.larus.platform.service.z2.f365865a.enableSwDpOffline() == false) goto L14;
        r103.getTheme().applyStyle(R.style.Theme_OApp_BaseDimenAttr, true);
    L14:
        return r103;
    L8:
        if (com.larus.platform.service.z2.f365865a.enableChatInputIconCompat() == false) goto L10;
        r102 = R.style.Theme_OApp_BaseAttrCompat;
        goto L11
    L5:
        r101 = false;
        goto L6
    }

    public static final boolean f(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        String r101 = r100.getClass().getName();
        uq9.b r102 = com.larus.platform.service.z2.f365865a.ecActivityThemeConfig();
        if (r102 != null) goto L5;
    L7:
        if (r102 != null) goto L9;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == true) goto L17;
        Intrinsics.checkNotNull(r101);
        return e(r101, ArraysKt.toList(f552472a));
    L17:
        Intrinsics.checkNotNull(r101);
        List<String> r104 = null;
        if (r102 == null) goto L20;
        List<String> r105 = r102.b();
    L22:
        if (e(r101, r105) == false) goto L24;
        return false;
    L24:
        if (r102 == null) goto L27;
        r104 = r102.a();
    L27:
        return e(r101, r104);
    L20:
        r105 = null;
        goto L22
    L9:
        if (CollectionUtils.isEmpty(r102.a()) == true) goto L11;
    L12:
        r103 = true;
        goto L14
    L11:
        if (CollectionUtils.isEmpty(r102.b()) == true) goto L13;
    L5:
        if (r102.c() == true) goto L7;
        return false;
    }

    public static final boolean e(String r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "cn");
        if (CollectionUtils.isEmpty(r101) == false) goto L5;
        return false;
    L5:
        if (r101 == null) goto L23;
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L23;
        String r103 = (String) r102.next();
        if (r103 != null) goto L12;
    L15:
        boolean r104 = true;
    L16:
        if (r104 == true) goto L8;
        if (StringsKt.endsWith$default(r103, ".", false, 2, null) == false) goto L20;
        boolean r105 = StringsKt.startsWith$default(r100, r103, false, 2, null);
    L21:
        if (r105 == false) goto L8;
        return true;
    L20:
        r105 = Intrinsics.areEqual(r100, r103);
        goto L21
    L12:
        if (r103.length() == 0) goto L15;
        r104 = false;
    L23:
        return false;
    }

    public static final Context g(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == false) goto L5;
        int r102 = 32;
    L6:
        Configuration r103 = new Configuration(r100.getResources().getConfiguration());
        r103.uiMode = r102 | (r103.uiMode & (-49));
        Context r104 = r100.createConfigurationContext(r103);
        NewMiraResourcesManager.getInstance().install(r104);
        return d(r104);
    L5:
        r102 = 16;
        goto L6
    }
}
