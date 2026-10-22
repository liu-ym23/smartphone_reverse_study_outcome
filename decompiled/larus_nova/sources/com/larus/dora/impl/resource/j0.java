package com.larus.dora.impl.resource;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.core.content.ContextCompat;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dtf.face.config.IConstValues;
import com.facebook.common.util.UriUtil;
import com.larus.dora.api.DoraServerDeviceType;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j0 f337886a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f337887b = null;

    /* JADX INFO: loaded from: classes27.dex */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f337888a = null;

        static {
            int[] r100 = new int[DoraResourceDeviceType.values().length];
            r100[DoraResourceDeviceType.G1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[DoraResourceDeviceType.G2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[DoraResourceDeviceType.G_SERIES.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[DoraResourceDeviceType.LITE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[DoraResourceDeviceType.H.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f337888a = r100;
        }
    }

    public j0() {
    }

    static {
        f337886a = new j0();
        f337887b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new i0());
    }

    public static boolean b(DoraResourceDeviceType r100) {
        Intrinsics.checkNotNullParameter(r100, IConstValues.DEVICE_TYPE);
        if (c(r100) == false) goto L18;
        x r101 = (x) f337887b.getValue();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, IConstValues.DEVICE_TYPE);
        if (r101.f337926d == false) goto L14;
        File r102 = r101.f337924b;
        if (r102 != null) goto L9;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == false) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == false) goto L19;
        return true;
    L19:
        return false;
    L9:
        if (x.d(r102, r100) != true) goto L11;
        r103 = true;
    L14:
        r104 = false;
        goto L15
    L18:
        return false;
    }

    public static boolean c(DoraResourceDeviceType r100) {
        int r101 = a.f337888a[r100.ordinal()];
        if (r101 != 1) goto L5;
        int r102 = y.f337927a;
        return y.a(DoraServerDeviceType.G1);
    L5:
        if (r101 != 2) goto L7;
        int r103 = y.f337927a;
        return y.a(DoraServerDeviceType.G2);
    L7:
        if (r101 != 3) goto L9;
        int r104 = y.f337927a;
        if (y.a(DoraServerDeviceType.G1) == false) goto L18;
        return true;
    L18:
        if (y.a(DoraServerDeviceType.G2) == true) goto L29;
        return false;
    L29:
        return true;
    L9:
        if (r101 != 4) goto L11;
        return true;
    L11:
        if (r101 != 5) goto L14;
        return true;
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public static DoraResourceTheme h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r100.getResources().getConfiguration().uiMode & 48) != 32) goto L6;
        return DoraResourceTheme.NIGHT;
    L6:
        return DoraResourceTheme.LIGHT;
    }

    public static PolarisFileWrapper a(j0 r100, DoraResourceDeviceType r101, DoraResourceType r102, DoraResourceTheme r103) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, IConstValues.DEVICE_TYPE);
        Intrinsics.checkNotNullParameter(r102, "resourceType");
        Intrinsics.checkNotNullParameter(r103, "theme");
        x r104 = (x) f337887b.getValue();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r101, IConstValues.DEVICE_TYPE);
        Intrinsics.checkNotNullParameter(r102, "resourceType");
        Intrinsics.checkNotNullParameter(r103, "theme");
        return x.e(r104.f337925c, r101, r103, r102, false);
    }

    public static PolarisFileWrapper d(j0 r100, DoraResourceDeviceType r101, DoraResourceType r102, DoraResourceTheme r103) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, IConstValues.DEVICE_TYPE);
        Intrinsics.checkNotNullParameter(r102, "resourceType");
        Intrinsics.checkNotNullParameter(r103, "theme");
        x r104 = (x) f337887b.getValue();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r101, IConstValues.DEVICE_TYPE);
        Intrinsics.checkNotNullParameter(r102, "resourceType");
        Intrinsics.checkNotNullParameter(r103, "theme");
        if (r104.f337926d == false) goto L8;
        File r105 = r104.f337924b;
        if (r105 == null) goto L8;
        return x.e(r105, r101, r103, r102, false);
    L8:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.larus.dora.impl.resource.k] */
    public static k e(DoraResourceDeviceType r110, DoraResourceType r111, String r210, DoraResourceTheme r211) {
        Intrinsics.checkNotNullParameter(r110, IConstValues.DEVICE_TYPE);
        Intrinsics.checkNotNullParameter(r111, "resourceType");
        Intrinsics.checkNotNullParameter(r210, "resourceName");
        Intrinsics.checkNotNullParameter(r211, "theme");
        x r112 = (x) f337887b.getValue();
        boolean r113 = c(r110);
        r112.getClass();
        Intrinsics.checkNotNullParameter(r110, IConstValues.DEVICE_TYPE);
        Intrinsics.checkNotNullParameter(r111, "resourceType");
        Intrinsics.checkNotNullParameter(r210, "resourceName");
        Intrinsics.checkNotNullParameter(r211, "theme");
        int r114 = 0;
        if (StringsKt.isBlank(r210) == false) goto L5;
    L28:
        String r115 = null;
        char r100 = '/';
    L29:
        boolean r101 = false;
    L30:
        if (r101 == false) goto L64;
        String r102 = r111.getAndroidResourceType();
        if (r102 != null) goto L35;
    L52:
        if (r114 <= 0) goto L55;
        return new k.a(r114);
    L55:
        if (r112.f337926d == false) goto L60;
        if (r113 == false) goto L60;
        File r103 = r112.c(r112.f337924b, r110, r211, r111, r210);
        if (r103 == null) goto L60;
        return new k.b(r103, DoraResourceSource.LOCAL);
    L60:
        File r104 = r112.c(r112.f337925c, r110, r211, r111, r210);
        if (r104 == null) goto L64;
        return new k.b(r104, DoraResourceSource.CLOUD);
    L35:
        if (StringsKt.contains$default(r210, r100, false, 2, r115) == false) goto L37;
    L39:
        boolean r116 = false;
    L40:
        if (r116 == true) goto L43;
        r102 = r115;
    L43:
        if (r102 == null) goto L52;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L46
        Object r106 = Result.m9449constructorimpl(Integer.valueOf(r112.f337923a.invoke(r210, r102).intValue()));     // Catch: Throwable -> L46
    L49:
        if (Result.m9455isFailureimpl(r106) == false) goto L51;
        r106 = 0;
    L51:
        r114 = ((Number) r106).intValue();
    L46:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L49
    L37:
        if (StringsKt.contains$default(r210, '.', false, 2, r115) == true) goto L39;
        r116 = true;
    L64:
        return r115;
    L5:
        if (new PolarisFileWrapper(r210).isAbsolute() == true) goto L28;
        if (StringsKt.contains$default(r210, '\\', false, 2, null) == true) goto L28;
        r115 = null;
        r100 = '/';
        List r108 = StringsKt.split$default(r210, new char[]{'/'}, false, 0, 6, null);
        if ((r108 instanceof Collection) == true) goto L12;
    L14:
        Iterator r109 = r108.iterator();
    L16:
        if (r109.hasNext() == false) goto L27;
        String r117 = (String) r109.next();
        if (Intrinsics.areEqual(r117, ".") == false) goto L20;
    L24:
        boolean r118 = false;
    L25:
        if (r118 == true) goto L16;
    L20:
        if (Intrinsics.areEqual(r117, DownloadConstants.VULNERABILITY_PATH) == true) goto L24;
        if (x.f337922e.matches(r117) == false) goto L24;
        r118 = true;
    L27:
        r101 = true;
        goto L30
    L12:
        if (r108.isEmpty() == false) goto L14;
        goto L14
    }

    public static Uri g(j0 r100, Context r101, DoraResourceDeviceType r102, DoraResourceType r103, String r104) {
        r100.getClass();
        DoraResourceTheme r105 = h(r101);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, IConstValues.DEVICE_TYPE);
        Intrinsics.checkNotNullParameter(r103, "resourceType");
        Intrinsics.checkNotNullParameter(r104, "resourceName");
        Intrinsics.checkNotNullParameter(r105, "theme");
        k r106 = e(r102, r103, r104, r105);
        if ((r106 instanceof k.a) == false) goto L6;
        k.a r107 = (k.a) r106;
        return new Uri.Builder().scheme(UriUtil.QUALIFIED_RESOURCE_SCHEME).authority(r101.getResources().getResourcePackageName(r107.f337889a)).appendPath(String.valueOf(r107.f337889a)).build();
    L6:
        if ((r106 instanceof k.b) == true) goto L14;
        if (r106 != null) goto L12;
        return null;
    L12:
        throw new NoWhenBranchMatchedException();
    L14:
        return Uri.fromFile(((k.b) r106).f337890a);
    }

    public static Drawable f(j0 r100, Context r101, DoraResourceDeviceType r102, String r103, DoraDrawableDensity r104, int r105) {
        Object r106 = null;
        if ((r105 & 8) == 0) goto L5;
        r100.getClass();
        DoraResourceTheme r107 = h(r101);
    L7:
        if ((r105 & 16) == 0) goto L9;
        r104 = DoraDrawableDensity.NONE;
    L9:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, IConstValues.DEVICE_TYPE);
        Intrinsics.checkNotNullParameter(r103, "resourceName");
        Intrinsics.checkNotNullParameter(r107, "theme");
        Intrinsics.checkNotNullParameter(r104, "sourceDensity");
        k r108 = e(r102, DoraResourceType.DRAWABLE, r103, r107);
        if ((r108 instanceof k.a) == false) goto L13;
        return ContextCompat.getDrawable(r101, ((k.a) r108).f337889a);
    L13:
        if ((r108 instanceof k.b) == true) goto L34;
        if (r108 != null) goto L33;
        return null;
    L33:
        throw new NoWhenBranchMatchedException();
    L34:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L23
        Bitmap r110 = BitmapFactory.decodeFile(((k.b) r108).f337890a.getAbsolutePath());     // Catch: Throwable -> L23
        if (r110 == null) goto L20;
        Integer r111 = r104.getDensityDpi$impl_mainlandRelease();     // Catch: Throwable -> L23
        if (r111 == null) goto L19;
        r110.setDensity(r111.intValue());     // Catch: Throwable -> L23
    L19:
        BitmapDrawable r112 = new BitmapDrawable(r101.getResources(), r110);     // Catch: Throwable -> L23
    L21:
        Object r113 = Result.m9449constructorimpl(r112);     // Catch: Throwable -> L23
    L26:
        if (Result.m9455isFailureimpl(r113) == true) goto L36;
        r106 = r113;
    L36:
        return (Drawable) r106;
    L20:
        r112 = null;
    L23:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L5:
        r107 = null;
        goto L7
    }
}
