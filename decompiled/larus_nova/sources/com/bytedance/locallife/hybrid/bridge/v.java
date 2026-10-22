package com.bytedance.locallife.hybrid.bridge;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.lynx.tasm.eventreport.LynxEventReporter;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.Locale;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class v extends ContentObserver {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f259052e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f259053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f259054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f259055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f259056d;

    public static final class a {
    }

    public static final class b<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f259057a;

        public b(v r100) {
            this.f259057a = r100;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            this.f259057a.f259053a.invoke();
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    static {
        f259052e = new String[]{IHostShare.ShareType.SCREENSHOT, "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};
    }

    public v(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onScreenshot");
        super(null);
        this.f259053a = r100;
        this.f259054b = HostServiceUtilsKt.E().getApplicationContext();
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r210) {
        super.onChange(r210);
        int r100 = Build.VERSION.SDK_INT;
        String r101 = LynxEventReporter.PROP_NAME_RELATIVE_PATH;
        if (r100 < 29) goto L5;
        String[] r102 = {LynxEventReporter.PROP_NAME_RELATIVE_PATH};
    L6:
        String[] r103 = r102;
        Context r104 = this.f259054b;
        if (r104 == null) goto L50;
        ContentResolver r105 = r104.getContentResolver();
        if (r105 == null) goto L51;
        Uri r106 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        f06.c r110 = new f06.c();
        Object[] r107 = {r106, r103, null, null, "date_modified desc"};
        f06.b r211 = new f06.b();
        f06.d r111 = r110.b(240004, "android/content/ContentResolver", "query", r105, r107, "android.database.Cursor", r211);
        if (r111.f474982a == false) goto L13;
        r110.a(240004, "android/content/ContentResolver", "query", r105, r107, null, r211, false);
        Cursor r108 = (Cursor) r111.f474983b;
    L14:
        if (r108 == null) goto L52;
        int r109 = r108.getCount();
        int r112 = this.f259055c;
        if (r112 != 0) goto L19;
        this.f259055c = r109;
    L22:
        this.f259055c = r109;
        if (r108.moveToFirst() == false) goto L46;
        if (r100 >= 29) goto L27;
        r101 = "_data";
    L27:
        String r113 = r108.getString(r108.getColumnIndex(r101));
        Locale r114 = Locale.getDefault();
        if (r113 == null) goto L45;
        String r115 = r113.toLowerCase(r114);
        String[] r116 = f259052e;
        int r117 = r116.length;
        int r118 = 0;
    L30:
        if (r118 >= r117) goto L35;
        if (StringsKt.contains$default(r115, r116[r118], false, 2, null) == true) goto L33;
        r118 = r118 + 1;
        goto L30
    L33:
        boolean r119 = true;
    L36:
        if (r119 == false) goto L46;
        if ((System.currentTimeMillis() - this.f259056d) <= 1000) goto L40;
        boolean r120 = true;
    L41:
        this.f259056d = System.currentTimeMillis();
        if (r120 == false) goto L46;
        Single.fromCallable(new b(this)).subscribeOn(Schedulers.io()).subscribe();
        goto L46
    L40:
        r120 = false;
        goto L41
    L35:
        r119 = false;
        goto L36
    L45:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L46:
        r108.close();
        return;
    L19:
        if (r112 < r109) goto L22;
        r108.close();
        return;
    L52:
        return;
    L13:
        Cursor r121 = r105.query(r106, r103, null, null, "date_modified desc");
        r110.a(240004, "android/content/ContentResolver", "query", r105, r107, r121, r211, true);
        r108 = r121;
        goto L14
    L51:
        return;
    L50:
        return;
    L5:
        r102 = new String[]{"date_added", "_data"};
        goto L6
    }
}
