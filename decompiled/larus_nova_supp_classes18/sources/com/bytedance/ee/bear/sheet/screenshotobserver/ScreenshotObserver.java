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
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.ui.j;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.supervisor.token.Token;
import com.larus.apm.impl.protector.RunnableProtector;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class ScreenshotObserver {
    public static final /* synthetic */ int o = 0;
    public final List<gn5.a> a;
    public final String[] b;
    public b c;
    public b d;
    public PthreadHandlerThreadV2 e;
    public Handler f;
    public boolean g;
    public ContentResolver h;
    public LifecycleState i;
    public gn5.c j;
    public boolean k;
    public final qm5.a l;
    public WeakReference<Activity> m;
    public final c n;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/sheet/screenshotobserver/ScreenshotObserver$LifecycleState;", "", "<init>", "(Ljava/lang/String;I)V", "NotInit", "Created", "ObserveStarted", "ObserveStopped", "Destroyed", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LifecycleState extends Enum<LifecycleState> {
        public static final LifecycleState Created = null;
        public static final LifecycleState Destroyed = null;
        public static final LifecycleState NotInit = null;
        public static final LifecycleState ObserveStarted = null;
        public static final LifecycleState ObserveStopped = null;
        public static final /* synthetic */ LifecycleState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<LifecycleState> getEntries() {
            return b;
        }

        static {
            LifecycleState r0 = new LifecycleState("NotInit", 0);
            NotInit = r0;
            LifecycleState r1 = new LifecycleState("Created", 1);
            Created = r1;
            LifecycleState r3 = new LifecycleState("ObserveStarted", 2);
            ObserveStarted = r3;
            LifecycleState r5 = new LifecycleState("ObserveStopped", 3);
            ObserveStopped = r5;
            LifecycleState r7 = new LifecycleState("Destroyed", 4);
            Destroyed = r7;
            LifecycleState[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
        }

        public static LifecycleState[] values() {
            return (LifecycleState[]) a.clone();
        }

        public static LifecycleState valueOf(String r1) {
            return (LifecycleState) r27.a.a(LifecycleState.class, r1);
        }

        public LifecycleState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public final class b extends ContentObserver {
        public final Uri a;
        public long b;
        public final /* synthetic */ ScreenshotObserver c;

        @Override // android.database.ContentObserver
        public final void onChange(boolean r8) {
            super.onChange(r8);
            long r0 = System.currentTimeMillis();
            if ((r0 - this.b) < 1000) goto L24;
            this.b = r0;
            int r1 = ScreenshotObserver.o;
            tt5.a.b("ScreenshotObserver", du5.b.g(this.a.toString()));
            ScreenshotObserver r2 = this.c;
            if (r2.g == false) goto L8;
            c r9 = r2.n;
            Uri r3 = this.a;
            r9.getClass();
            Intrinsics.checkNotNullParameter(r3, "contentUri");
            r9.a = r3;
            j.e(this.c.n);
            j.d(this.c.n, 100);
            return;
        L8:
            if (r2.k == true) goto L22;
            tt5.a.h("ScreenshotObserver", "No permission, request read permission.");
            ScreenshotObserver r10 = this.c;
            r10.k = true;
            Uri r4 = this.a;
            if (r10.g == true) goto L31;
            WeakReference<Activity> r5 = r10.m;
            if (r5 == null) goto L27;
            Activity r6 = r5.get();
            if (r6 != null) goto L17;
            return;
        L17:
            if (com.bytedance.ee.util.ui.b.a(r6) == false) goto L29;
            new HashMap();
            int r7 = StoragePermissionUtils.a(r6, StoragePermissionUtils.d(r6, 2));
            StoragePermissionUtils.a(r6, StoragePermissionUtils.d(r6, 4));
            StoragePermissionUtils.d(r6, 8);
            StoragePermissionUtils.e(r6);
            if (r7 == 1) goto L32;
            j.c(new com.bytedance.ee.bear.sheet.screenshotobserver.b(r6, r10, r4));
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
            int r11 = ScreenshotObserver.o;
            tt5.a.h("ScreenshotObserver", "frequency limit.");
        }

        public b(ScreenshotObserver r2, Uri r3, Handler r4) {
            Intrinsics.checkNotNullParameter(r3, "mContentUri");
            this.c = r2;
            super(r4);
            this.a = r3;
            this.b = -1;
        }
    }

    public static final class c implements Runnable {
        public Uri a;
        public final /* synthetic */ ScreenshotObserver b;

        @Override // java.lang.Runnable
        public final void run() {
            Uri r0 = this.a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            ScreenshotObserver.a(this.b, r0);     // Catch: Throwable -> L6
            this.a = null;     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public c(ScreenshotObserver r1) {
            this.b = r1;
        }
    }

    static {
    }

    public static Bundle b() {
        Bundle r0 = new Bundle();
        r0.putInt("android:query-arg-limit", 1);
        r0.putStringArray("android:query-arg-sort-columns", new String[]{"date_added"});
        r0.putInt("android:query-arg-sort-direction", 1);
        return r0;
    }

    public final void d() throws SecurityException {
        tt5.a.b("ScreenshotObserver", "startObserve");
        gn5.c r0 = this.j;
        if (r0 == null) goto L5;
        r0.c = System.currentTimeMillis();
    L5:
        b r1 = this.c;
        boolean r2 = false;
        if (r1 == null) goto L14;
        ContentResolver r4 = this.h;
        if (r4 == null) goto L14;
        Uri r5 = MediaStore.Images.Media.INTERNAL_CONTENT_URI;
        if (Build.VERSION.SDK_INT < 29) goto L12;
        boolean r6 = true;
    L13:
        r4.registerContentObserver(r5, r6, r1);
        goto L14
    L12:
        r6 = false;
    L14:
        b r3 = this.d;
        if (r3 == null) goto L22;
        ContentResolver r7 = this.h;
        if (r7 == null) goto L22;
        Uri r8 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        if (Build.VERSION.SDK_INT < 29) goto L21;
        r2 = true;
    L21:
        r7.registerContentObserver(r8, r2, r3);
    L22:
        this.i = LifecycleState.ObserveStarted;
    }

    public final void e() {
        tt5.a.b("ScreenshotObserver", "stopObserve");
        this.i = LifecycleState.ObserveStopped;
        gn5.c r1 = this.j;
        if (r1 == null) goto L19;
        r1.c = 0;
        ((CopyOnWriteArrayList) r1.d).clear();
    L19:
        b r2 = this.c;     // Catch: Exception -> L16
        if (r2 == null) goto L10;
        ContentResolver r3 = this.h;     // Catch: Exception -> L16
        if (r3 == null) goto L10;
        r3.unregisterContentObserver(r2);     // Catch: Exception -> L16
    L10:
        b r4 = this.d;     // Catch: Exception -> L16
        if (r4 == null) goto L21;
        ContentResolver r5 = this.h;     // Catch: Exception -> L16
        if (r5 == null) goto L22;
        r5.unregisterContentObserver(r4);     // Catch: Exception -> L16
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
        this.a = new CopyOnWriteArrayList();
        this.b = new String[]{"_data", "date_added", "width", "height"};
        this.i = LifecycleState.NotInit;
        this.l = new qm5.a();
        this.n = new c(this);
    }

    public static final void a(ScreenshotObserver r11, Uri r12) {
        r11.getClass();
        Cursor r1 = null;
    L8:
        th = move-exception;
        Cursor r2 = (Cursor) null;
        if (r2 != null) goto L42;
    L44:
        throw th;
    L42:
        if (r2.isClosed() == true) goto L44;
        r2.close();
    L10:
        e = move-exception;
        tt5.a.m("ScreenshotObserver", e);     // Catch: Throwable -> L8
        r1 = (Cursor) null;
        if (r1 != null) goto L36;
        return;
    L36:
        if (r1.isClosed() == true) goto L50;
    L37:
        r1.close();
        return;
    L50:
        return;
    L4:
        if (Build.VERSION.SDK_INT < 26) goto L12;
        ContentResolver r5 = r11.h;     // Catch: Throwable -> L8 Exception -> L10
        if (r5 == null) goto L15;
        r1 = sf7.a.a.query(r5, r12, r11.b, b(), null, new Token("LARK-PSDA-ccm_android_screen_observer_query_media_hight"));     // Catch: Throwable -> L8 Exception -> L10
    L15:
        if (r1 != null) goto L18;
        tt5.a.d("ScreenshotObserver", "Deviant logic.");     // Catch: Throwable -> L8 Exception -> L10
        return;
    L18:
        if (r1.moveToFirst() == true) goto L23;
        tt5.a.b("ScreenshotObserver", "Cursor no data.");     // Catch: Throwable -> L8 Exception -> L10
        if (r1.isClosed() == false) goto L37;
        return;
    L23:
        int r13 = r1.getColumnIndex("_data");     // Catch: Throwable -> L8 Exception -> L10
        int r3 = r1.getColumnIndex("date_added");     // Catch: Throwable -> L8 Exception -> L10
        int r4 = r1.getColumnIndex("width");     // Catch: Throwable -> L8 Exception -> L10
        int r6 = r1.getColumnIndex("height");     // Catch: Throwable -> L8 Exception -> L10
        String r7 = r1.getString(r13);     // Catch: Throwable -> L8 Exception -> L10
        long r8 = r1.getLong(r3);     // Catch: Throwable -> L8 Exception -> L10
        if (r4 < 0) goto L27;
        if (r6 < 0) goto L27;
        int r14 = r1.getInt(r4);     // Catch: Throwable -> L8 Exception -> L10
        int r9 = r14;
        int r10 = r1.getInt(r6);     // Catch: Throwable -> L8 Exception -> L10
    L28:
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L8 Exception -> L10
        r11.c(r7, r8, r9, r10);     // Catch: Throwable -> L8 Exception -> L10
        if (r1.isClosed() == false) goto L37;
        return;
    L27:
        r9 = 0;
        r10 = 0;
        goto L28
    L12:
        ContentResolver r15 = r11.h;     // Catch: Throwable -> L8 Exception -> L10
        if (r15 == null) goto L15;
        r1 = sf7.a.a.query(r15, r12, r11.b, null, null, "date_added desc limit 1", new Token("LARK-PSDA-ccm_android_screen_observer_query_media_low"));     // Catch: Throwable -> L8 Exception -> L10
        goto L15
    }

    public final void c(String r10, long r11, int r13, int r14) {
        gn5.c r0 = this.j;
        boolean r1 = false;
        if (r0 == null) goto L43;
        Intrinsics.checkNotNullParameter(r10, WikiFolderPushPlugin.DATA);
        long r2 = ((long) CCMLynxCardView.ViewType.BANNER) * r11;
        if (r2 >= r0.c) goto L7;
    L38:
        tt5.a.b("ScreenshotChecker", "checkScreenShot, date illegal: dateAdded = " + r11 + ", startObserveTime=" + r0.c);
    L39:
        boolean r15 = false;
    L40:
        if (r15 != true) goto L43;
        r1 = true;
        goto L43
    L7:
        if ((System.currentTimeMillis() - r2) > 10100) goto L38;
        Point r3 = gn5.c.e;
        if (r3 == null) goto L20;
        int r4 = r3.x;
        if (r13 <= r4) goto L14;
    L15:
        if (r14 <= r4) goto L17;
    L18:
        tt5.a.b("ScreenshotChecker", "checkScreenShot, size illegal");
        goto L39
    L17:
        if (r13 <= r3.y) goto L20;
    L14:
        if (r14 > r3.y) goto L15;
    L20:
        if (TextUtils.isEmpty(r10) == false) goto L22;
        tt5.a.b("ScreenshotChecker", "checkScreenShot, path is empty");
        goto L39
    L22:
        String r16 = r10.toLowerCase(Locale.ROOT);
        Iterator r17 = ((ArrayList) r0.b).iterator();
    L24:
        if (r17.hasNext() == false) goto L39;
        if (StringsKt.contains$default(r16, (String) r17.next(), false, 2, null) == false) goto L24;
        if (((CopyOnWriteArrayList) r0.d).contains(r16) == false) goto L31;
        tt5.a.b("ScreenshotChecker", "ScreenShot: imgPath has done; imagePath = " + r16);
        boolean r18 = true;
    L37:
        r15 = !r18;
        goto L40
    L31:
        if (((CopyOnWriteArrayList) r0.d).size() < 20) goto L36;
        int r19 = 0;
    L34:
        if (r19 >= 5) goto L36;
        ListProtector.remove(r0.d, 0);
        r19 = r19 + 1;
    L36:
        ((CopyOnWriteArrayList) r0.d).add(r16);
        r18 = false;
    L43:
        if (r1 == false) goto L45;
        tt5.a.b("ScreenshotObserver", "handleMediaRowData: is ScreenShot,path: " + r10 + "  dateAdded: " + r11 + ", notify listeners");
        j.c(new com.bytedance.ee.bear.sheet.screenshotobserver.a(this, r10, r11));
        return;
    L45:
        this.l.getClass();
        HashMap r12 = new HashMap();
        r12.put("pic_path", r10);
        tt5.a.b("SheetAnalytic", "report: params = " + r12);
        ((d) org.koin.java.a.a(d.class)).v("dev_performance_sheet_screenshot_illegal_path", r12);
        tt5.a.b("ScreenshotObserver", "Not screenshot event");
    }
}
