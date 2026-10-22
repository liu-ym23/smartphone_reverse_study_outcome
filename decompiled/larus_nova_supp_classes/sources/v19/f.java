package v19;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.ContextThemeWrapper;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.larus.platform.service.z2;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import uq9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class f {
    public static final String[] a = null;

    static {
        a = new String[]{"com.bytedance.android.shopping.", "com.bytedance.android.ec.", "com.larus.live.impl.ttlivesdk.DefaultLivePlayerActivity", "com.ss.android.ugc.aweme.search.common.activity.ECSearchSaaSActivity"};
    }

    public static final void a(Resources.Theme r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L10:
        r4.applyStyle(2131953683, false);
    L12:
        if (z2.a.enableSwDpOffline() == false) goto L15;
        r4.applyStyle(2131953685, true);
        return;
    L15:
        return;
    L8:
        if (z2.a.enableChatInputIconCompat() == false) goto L10;
        r4.applyStyle(2131953684, false);
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    public static final void b(Resources.Theme r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L10:
        r3.applyStyle(2131953689, true);
        return;
    L8:
        if (z2.a.enableChatInputIconCompat() == false) goto L10;
        r3.applyStyle(2131953690, true);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static final void c(Resources.Theme r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L10:
        r3.applyStyle(2131953697, true);
        return;
    L8:
        if (z2.a.enableChatInputIconCompat() == false) goto L10;
        r3.applyStyle(2131953698, true);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static final Context d(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L10:
        int r1 = 2131953683;
    L11:
        ContextThemeWrapper r2 = new ContextThemeWrapper(r3, r1);
        if (z2.a.enableSwDpOffline() == false) goto L14;
        r2.getTheme().applyStyle(2131953685, true);
    L14:
        return r2;
    L8:
        if (z2.a.enableChatInputIconCompat() == false) goto L10;
        r1 = 2131953684;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public static final boolean f(Activity r4) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        String r5 = r4.getClass().getName();
        b r0 = z2.a.ecActivityThemeConfig();
        if (r0 != null) goto L5;
    L7:
        if (r0 != null) goto L9;
    L13:
        boolean r2 = false;
    L14:
        if (r2 == true) goto L17;
        Intrinsics.checkNotNull(r5);
        return e(r5, ArraysKt.toList(a));
    L17:
        Intrinsics.checkNotNull(r5);
        List r3 = null;
        if (r0 == null) goto L20;
        List r6 = r0.b();
    L22:
        if (e(r5, r6) == false) goto L24;
        return false;
    L24:
        if (r0 == null) goto L27;
        r3 = r0.a();
    L27:
        return e(r5, r3);
    L20:
        r6 = null;
        goto L22
    L9:
        if (CollectionUtils.isEmpty(r0.a()) == true) goto L11;
    L12:
        r2 = true;
        goto L14
    L11:
        if (CollectionUtils.isEmpty(r0.b()) == true) goto L13;
    L5:
        if (r0.c() == true) goto L7;
        return false;
    }

    public static final boolean e(String r6, List<String> r7) {
        Intrinsics.checkNotNullParameter(r6, "cn");
        if (CollectionUtils.isEmpty(r7) == false) goto L5;
        return false;
    L5:
        if (r7 == null) goto L23;
        Iterator<T> r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L23;
        String r0 = (String) r8.next();
        if (r0 != null) goto L12;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == true) goto L8;
        if (StringsKt.endsWith$default(r0, ".", false, 2, null) == false) goto L20;
        boolean r1 = StringsKt.startsWith$default(r6, r0, false, 2, null);
    L21:
        if (r1 == false) goto L8;
        return true;
    L20:
        r1 = Intrinsics.areEqual(r6, r0);
        goto L21
    L12:
        if (r0.length() == 0) goto L15;
        r3 = false;
    L23:
        return false;
    }

    public static final Context g(Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 == false) goto L5;
        int r4 = 32;
    L6:
        Configuration r0 = new Configuration(r2.getResources().getConfiguration());
        r0.uiMode = r4 | (r0.uiMode & (-49));
        Context r5 = r2.createConfigurationContext(r0);
        NewMiraResourcesManager.getInstance().install(r5);
        return d(r5);
    L5:
        r4 = 16;
        goto L6
    }
}
