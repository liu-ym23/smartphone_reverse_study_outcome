package com.bytedance.ee.bear.sheet.screenshotobserver;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.util.ui.j;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.supervisor.token.Token;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.platform.model.MessageQueryType;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class ScreenshotObserver {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f238306o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<gn5.a> f238307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f238308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f238309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f238310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PthreadHandlerThreadV2 f238311e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f238312f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f238313g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ContentResolver f238314h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LifecycleState f238315i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public gn5.c f238316j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f238317k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final qm5.a f238318l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public WeakReference<Activity> f238319m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f238320n;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/sheet/screenshotobserver/ScreenshotObserver$LifecycleState;", "", "<init>", "(Ljava/lang/String;I)V", "NotInit", "Created", "ObserveStarted", "ObserveStopped", "Destroyed", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LifecycleState extends Enum<LifecycleState> {
        public static final LifecycleState Created = null;
        public static final LifecycleState Destroyed = null;
        public static final LifecycleState NotInit = null;
        public static final LifecycleState ObserveStarted = null;
        public static final LifecycleState ObserveStopped = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LifecycleState[] f238321a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f238322b = null;

        public static EnumEntries<LifecycleState> getEntries() {
            return f238322b;
        }

        static {
            LifecycleState r100 = new LifecycleState("NotInit", 0);
            NotInit = r100;
            LifecycleState r101 = new LifecycleState("Created", 1);
            Created = r101;
            LifecycleState r102 = new LifecycleState("ObserveStarted", 2);
            ObserveStarted = r102;
            LifecycleState r103 = new LifecycleState("ObserveStopped", 3);
            ObserveStopped = r103;
            LifecycleState r104 = new LifecycleState("Destroyed", 4);
            Destroyed = r104;
            LifecycleState[] r105 = {r100, r101, r102, r103, r104};
            f238321a = r105;
            f238322b = EnumEntriesKt.enumEntries(r105);
        }

        public static LifecycleState[] values() {
            return (LifecycleState[]) f238321a.clone();
        }

        public static LifecycleState valueOf(String r100) {
            return (LifecycleState) r27.a.a(LifecycleState.class, r100);
        }

        public LifecycleState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public final class b extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f238323a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f238324b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ScreenshotObserver f238325c;

        @Override // android.database.ContentObserver
        public final void onChange(boolean r100) {
            super.onChange(r100);
            long r101 = System.currentTimeMillis();
            if ((r101 - this.f238324b) < 1000) goto L24;
            this.f238324b = r101;
            int r102 = ScreenshotObserver.f238306o;
            tt5.a.b("ScreenshotObserver", du5.b.g(this.f238323a.toString()));
            ScreenshotObserver r103 = this.f238325c;
            if (r103.f238313g == false) goto L8;
            c r104 = r103.f238320n;
            Uri r105 = this.f238323a;
            r104.getClass();
            Intrinsics.checkNotNullParameter(r105, "contentUri");
            r104.f238326a = r105;
            j.e(this.f238325c.f238320n);
            j.d(this.f238325c.f238320n, 100);
            return;
        L8:
            if (r103.f238317k == true) goto L22;
            tt5.a.h("ScreenshotObserver", "No permission, request read permission.");
            ScreenshotObserver r106 = this.f238325c;
            r106.f238317k = true;
            Uri r107 = this.f238323a;
            if (r106.f238313g == true) goto L31;
            WeakReference<Activity> r108 = r106.f238319m;
            if (r108 == null) goto L27;
            Activity r109 = r108.get();
            if (r109 != null) goto L17;
            return;
        L17:
            if (com.bytedance.ee.util.ui.b.a(r109) == false) goto L29;
            new HashMap();
            int r110 = StoragePermissionUtils.a(r109, StoragePermissionUtils.d(r109, 2));
            StoragePermissionUtils.a(r109, StoragePermissionUtils.d(r109, 4));
            StoragePermissionUtils.d(r109, 8);
            StoragePermissionUtils.e(r109);
            if (r110 == 1) goto L32;
            j.c(new com.bytedance.ee.bear.sheet.screenshotobserver.b(r109, r106, r107));
            return;
        L32:
            return;
        L29:
            return;
        L27:
            return;
        L31:
            return;
        L22:
            tt5.a.h("ScreenshotObserver", "No permission, user rejected to grant read permission.");
            return;
        L24:
            int r111 = ScreenshotObserver.f238306o;
            tt5.a.h("ScreenshotObserver", "frequency limit.");
        }

        public b(ScreenshotObserver r100, Uri r101, Handler r102) {
            Intrinsics.checkNotNullParameter(r101, "mContentUri");
            this.f238325c = r100;
            super(r102);
            this.f238323a = r101;
            this.f238324b = -1;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Uri f238326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ScreenshotObserver f238327b;

        @Override // java.lang.Runnable
        public final void run() {
            Uri r100 = this.f238326a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            ScreenshotObserver.a(this.f238327b, r100);     // Catch: Throwable -> L6
            this.f238326a = null;     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public c(ScreenshotObserver r100) {
            this.f238327b = r100;
        }
    }

    static {
    }

    public static Bundle b() {
        Bundle r100 = new Bundle();
        r100.putInt("android:query-arg-limit", 1);
        r100.putStringArray("android:query-arg-sort-columns", new String[]{"date_added"});
        r100.putInt("android:query-arg-sort-direction", 1);
        return r100;
    }

    public final void d() throws SecurityException {
        tt5.a.b("ScreenshotObserver", "startObserve");
        gn5.c r100 = this.f238316j;
        if (r100 == null) goto L5;
        r100.f481808c = System.currentTimeMillis();
    L5:
        b r101 = this.f238309c;
        boolean r102 = false;
        if (r101 == null) goto L14;
        ContentResolver r103 = this.f238314h;
        if (r103 == null) goto L14;
        Uri r104 = MediaStore.Images.Media.INTERNAL_CONTENT_URI;
        if (Build.VERSION.SDK_INT < 29) goto L12;
        boolean r105 = true;
    L13:
        r103.registerContentObserver(r104, r105, r101);
        goto L14
    L12:
        r105 = false;
    L14:
        b r106 = this.f238310d;
        if (r106 == null) goto L22;
        ContentResolver r107 = this.f238314h;
        if (r107 == null) goto L22;
        Uri r108 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        if (Build.VERSION.SDK_INT < 29) goto L21;
        r102 = true;
    L21:
        r107.registerContentObserver(r108, r102, r106);
    L22:
        this.f238315i = LifecycleState.ObserveStarted;
    }

    public final void e() {
        tt5.a.b("ScreenshotObserver", "stopObserve");
        this.f238315i = LifecycleState.ObserveStopped;
        gn5.c r100 = this.f238316j;
        if (r100 == null) goto L19;
        r100.f481808c = 0;
        ((CopyOnWriteArrayList) r100.f481809d).clear();
    L19:
        b r101 = this.f238309c;     // Catch: Exception -> L16
        if (r101 == null) goto L10;
        ContentResolver r102 = this.f238314h;     // Catch: Exception -> L16
        if (r102 == null) goto L10;
        r102.unregisterContentObserver(r101);     // Catch: Exception -> L16
    L10:
        b r103 = this.f238310d;     // Catch: Exception -> L16
        if (r103 == null) goto L21;
        ContentResolver r104 = this.f238314h;     // Catch: Exception -> L16
        if (r104 == null) goto L22;
        r104.unregisterContentObserver(r103);     // Catch: Exception -> L16
        return;
    L22:
        return;
    L21:
        return;
    L16:
        e = move-exception;
        tt5.a.d("ScreenshotObserver", "unregisterContentObserver error: " + e);
    }

    public ScreenshotObserver() {
        this.f238307a = new CopyOnWriteArrayList();
        this.f238308b = new String[]{"_data", "date_added", "width", "height"};
        this.f238315i = LifecycleState.NotInit;
        this.f238318l = new qm5.a();
        this.f238320n = new c(this);
    }

    public static final void a(ScreenshotObserver r110, Uri r111) {
        r110.getClass();
        Cursor r100 = null;
    L8:
        th = move-exception;
        Cursor r101 = (Cursor) null;
        if (r101 != null) goto L42;
    L44:
        throw th;
    L42:
        if (r101.isClosed() == true) goto L44;
        r101.close();
    L10:
        e = move-exception;
        tt5.a.m("ScreenshotObserver", e);     // Catch: Throwable -> L8
        r100 = (Cursor) null;
        if (r100 != null) goto L36;
        return;
    L36:
        if (r100.isClosed() == true) goto L50;
    L37:
        r100.close();
        return;
    L50:
        return;
    L4:
        if (Build.VERSION.SDK_INT < 26) goto L12;
        ContentResolver r102 = r110.f238314h;     // Catch: Throwable -> L8 Exception -> L10
        if (r102 == null) goto L15;
        r100 = sf7.a.f541727a.query(r102, r111, r110.f238308b, b(), null, new Token("LARK-PSDA-ccm_android_screen_observer_query_media_hight"));     // Catch: Throwable -> L8 Exception -> L10
    L15:
        if (r100 != null) goto L18;
        tt5.a.d("ScreenshotObserver", "Deviant logic.");     // Catch: Throwable -> L8 Exception -> L10
        return;
    L18:
        if (r100.moveToFirst() == true) goto L23;
        tt5.a.b("ScreenshotObserver", "Cursor no data.");     // Catch: Throwable -> L8 Exception -> L10
        if (r100.isClosed() == false) goto L37;
        return;
    L23:
        int r112 = r100.getColumnIndex("_data");     // Catch: Throwable -> L8 Exception -> L10
        int r103 = r100.getColumnIndex("date_added");     // Catch: Throwable -> L8 Exception -> L10
        int r104 = r100.getColumnIndex("width");     // Catch: Throwable -> L8 Exception -> L10
        int r105 = r100.getColumnIndex("height");     // Catch: Throwable -> L8 Exception -> L10
        String r106 = r100.getString(r112);     // Catch: Throwable -> L8 Exception -> L10
        long r107 = r100.getLong(r103);     // Catch: Throwable -> L8 Exception -> L10
        if (r104 < 0) goto L27;
        if (r105 < 0) goto L27;
        int r113 = r100.getInt(r104);     // Catch: Throwable -> L8 Exception -> L10
        int r108 = r113;
        int r114 = r100.getInt(r105);     // Catch: Throwable -> L8 Exception -> L10
    L28:
        Intrinsics.checkNotNull(r106);     // Catch: Throwable -> L8 Exception -> L10
        r110.c(r106, r107, r108, r114);     // Catch: Throwable -> L8 Exception -> L10
        if (r100.isClosed() == false) goto L37;
        return;
    L27:
        r108 = 0;
        r114 = 0;
        goto L28
    L12:
        ContentResolver r109 = r110.f238314h;     // Catch: Throwable -> L8 Exception -> L10
        if (r109 == null) goto L15;
        r100 = sf7.a.f541727a.query(r109, r111, r110.f238308b, null, null, "date_added desc limit 1", new Token("LARK-PSDA-ccm_android_screen_observer_query_media_low"));     // Catch: Throwable -> L8 Exception -> L10
        goto L15
    }

    public final void c(String r110, long r111, int r112, int r113) {
        gn5.c r100 = this.f238316j;
        boolean r101 = false;
        if (r100 == null) goto L43;
        Intrinsics.checkNotNullParameter(r110, "data");
        long r102 = ((long) 1000) * r111;
        if (r102 >= r100.f481808c) goto L7;
    L38:
        tt5.a.b("ScreenshotChecker", "checkScreenShot, date illegal: dateAdded = " + r111 + ", startObserveTime=" + r100.f481808c);
    L39:
        boolean r114 = false;
    L40:
        if (r114 != true) goto L43;
        r101 = true;
        goto L43
    L7:
        if ((System.currentTimeMillis() - r102) > MessageQueryType.MESSAGE_QUERY_TYPE_IMAGE_CREATION) goto L38;
        Point r103 = gn5.c.f481805e;
        if (r103 == null) goto L20;
        int r104 = r103.x;
        if (r112 <= r104) goto L14;
    L15:
        if (r113 <= r104) goto L17;
    L18:
        tt5.a.b("ScreenshotChecker", "checkScreenShot, size illegal");
        goto L39
    L17:
        if (r112 <= r103.y) goto L20;
    L14:
        if (r113 > r103.y) goto L15;
    L20:
        if (TextUtils.isEmpty(r110) == false) goto L22;
        tt5.a.b("ScreenshotChecker", "checkScreenShot, path is empty");
        goto L39
    L22:
        String r115 = r110.toLowerCase(Locale.ROOT);
        Iterator r116 = ((ArrayList) r100.f481807b).iterator();
    L24:
        if (r116.hasNext() == false) goto L39;
        if (StringsKt.contains$default(r115, (String) r116.next(), false, 2, null) == false) goto L24;
        if (((CopyOnWriteArrayList) r100.f481809d).contains(r115) == false) goto L31;
        tt5.a.b("ScreenshotChecker", "ScreenShot: imgPath has done; imagePath = " + r115);
        boolean r117 = true;
    L37:
        r114 = !r117;
        goto L40
    L31:
        if (((CopyOnWriteArrayList) r100.f481809d).size() < 20) goto L36;
        int r118 = 0;
    L34:
        if (r118 >= 5) goto L36;
        ListProtector.remove(r100.f481809d, 0);
        r118 = r118 + 1;
    L36:
        ((CopyOnWriteArrayList) r100.f481809d).add(r115);
        r117 = false;
    L43:
        if (r101 == false) goto L45;
        tt5.a.b("ScreenshotObserver", "handleMediaRowData: is ScreenShot,path: " + r110 + "  dateAdded: " + r111 + ", notify listeners");
        j.c(new com.bytedance.ee.bear.sheet.screenshotobserver.a(this, r110, r111));
        return;
    L45:
        this.f238318l.getClass();
        HashMap r119 = new HashMap();
        r119.put("pic_path", r110);
        tt5.a.b("SheetAnalytic", "report: params = " + r119);
        ((d) org.koin.java.a.a(d.class)).v("dev_performance_sheet_screenshot_illegal_path", r119);
        tt5.a.b("ScreenshotObserver", "Not screenshot event");
    }
}
