package com.larus.calendar;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.amap.api.services.cloud.CloudSearch;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.common.apphost.AppHost;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import f06.c;
import f06.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes26.dex */
public final class CalendarManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Context f321312a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f321313b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f321314c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f321315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f321316b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f321317c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f321318d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f321319e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f321320f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f321321g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f321315a == r101.f321315a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f321316b, r101.f321316b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f321317c, r101.f321317c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f321318d, r101.f321318d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f321319e, r101.f321319e) == true) goto L24;
            return false;
        L24:
            if (this.f321320f == r101.f321320f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f321321g, r101.f321321g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f321315a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            String r102 = this.f321316b;
            int r103 = 0;
            if (r102 != null) goto L5;
            int r104 = 0;
        L6:
            int r105 = (r101 + r104) * 31;
            String r106 = this.f321317c;
            if (r106 != null) goto L9;
            int r107 = 0;
        L10:
            int r108 = (r105 + r107) * 31;
            String r109 = this.f321318d;
            if (r109 != null) goto L13;
            int r110 = 0;
        L14:
            int r111 = (r108 + r110) * 31;
            String r112 = this.f321319e;
            if (r112 != null) goto L17;
            int r113 = 0;
        L18:
            int r114 = (((r111 + r113) * 31) + this.f321320f) * 31;
            String r115 = this.f321321g;
            if (r115 == null) goto L23;
            r103 = r115.hashCode();
        L23:
            return r114 + r103;
        L17:
            r113 = r112.hashCode();
            goto L18
        L13:
            r110 = r109.hashCode();
            goto L14
        L9:
            r107 = r106.hashCode();
            goto L10
        L5:
            r104 = r102.hashCode();
            goto L6
        }

        public final String toString() {
            return "Calendar(id=" + this.f321315a + ", name=" + this.f321316b + ", displayName=" + this.f321317c + ", accountType=" + this.f321318d + ", accountName=" + this.f321319e + ", visible=" + this.f321320f + ", ownerAccount=" + this.f321321g + ')';
        }

        public a() {
            this(0, null, null, null, null, 0, null);
        }

        public a(long r100, String r101, String r102, String r103, String r104, int r105, String r106) {
            this.f321315a = r100;
            this.f321316b = r101;
            this.f321317c = r102;
            this.f321318d = r103;
            this.f321319e = r104;
            this.f321320f = r105;
            this.f321321g = r106;
        }
    }

    static {
        f321312a = AppHost.f326268a.getApplication();
        f321313b = new String[]{AccountType.LOCAL, "com.android.huawei.phone", "com.xiaomi", "com.android.hihonor.phone"};
        f321314c = "豆包事件提醒";
    }

    public static List e() {
        Uri r100 = CalendarContract.Calendars.CONTENT_URI;
        String[] r101 = {DBDefinition.ID, "name", "calendar_displayName", "account_name", "account_type", "visible", "ownerAccount"};
        Cursor r102 = d(f(), r100, r101, null, null);
        if (r102 == null) goto L15;
        Cursor r103 = r102;
        List r104 = SequencesKt.toList(SequencesKt.sequence(new CalendarManager$getCalendars$1$1(r103, null)));     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r103, null);
        if (r104 == null) goto L15;
        return r104;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);
        throw th;
    L15:
        return CollectionsKt.emptyList();
    }

    public static ContentResolver f() {
        return f321312a.getContentResolver();
    }

    public static a g() {
        List r100 = e();
        Iterator r101 = r100.iterator();
    L3:
        Object r102 = null;
        if (r101.hasNext() == false) goto L8;
        Object r103 = r101.next();
        if (ArraysKt.contains(f321313b, ((a) r103).f321318d) == false) goto L3;
    L9:
        a r104 = (a) r103;
        if (r104 != null) goto L48;
        Iterator r105 = r100.iterator();
    L13:
        if (r105.hasNext() == false) goto L46;
        Object r106 = r105.next();
        a r107 = (a) r106;
        String r108 = r107.f321318d;
        if (r108 == null) goto L43;
        int r109 = r108.hashCode();
        if (r109 == (-1116924142)) goto L36;
        if (r109 == 879034182) goto L28;
        if (r109 != 1664859374) goto L43;
        if (r108.equals("com.smartisan.localcalendar") == false) goto L43;
        boolean r110 = Intrinsics.areEqual(r107.f321321g, CloudSearch.SearchBound.LOCAL_SHAPE);
    L44:
        if (r110 == false) goto L13;
    L47:
        r104 = (a) r106;
        goto L48
    L28:
        if (r108.equals("com.google") == false) goto L43;
        String r111 = r107.f321319e;
        if (r111 == null) goto L43;
        if (Intrinsics.areEqual(r111, r107.f321321g) == false) goto L43;
    L42:
        r110 = true;
        goto L44
    L36:
        if (r108.equals("My calendar") == false) goto L43;
        if (Intrinsics.areEqual(r107.f321319e, "My calendar") == false) goto L43;
        if (Intrinsics.areEqual(r107.f321321g, "My calendar") == true) goto L42;
    L43:
        r110 = false;
        goto L44
    L46:
        r106 = null;
    L48:
        if (r104 != null) goto L57;
        ContentValues r112 = new ContentValues();
        String r113 = f321314c;
        r112.put("account_name", r113);
        r112.put("account_type", AccountType.LOCAL);
        r112.put("name", "DoubaoMemberCalendar");
        r112.put("calendar_displayName", AppHost.f326268a.getAppStringName());
        r112.put("calendar_access_level", 700);
        r112.put("ownerAccount", r113);
        r112.put("visible", 1);
        r112.put("sync_events", 1);
        c(f(), a(CalendarContract.Events.CONTENT_URI, r113), r112);
        Iterator r114 = e().iterator();
    L51:
        if (r114.hasNext() == false) goto L56;
        Object r115 = r114.next();
        if (Intrinsics.areEqual(((a) r115).f321319e, f321314c) == false) goto L51;
        r102 = r115;
    L56:
        return (a) r102;
    L57:
        return r104;
    L8:
        r103 = null;
        goto L9
    }

    public final Context getContext() {
        return f321312a;
    }

    public static boolean h(String r100) {
        boolean r101 = true;
        Cursor r102 = d(f(), CalendarContract.Events.CONTENT_URI, new String[0], "sync_data1=? and (deleted != 1)", new String[]{r100});
        if (r102 == null) goto L16;
        Cursor r103 = r102;
        if (r103.getCount() > 0) goto L9;
        r101 = false;
    L9:
        CloseableKt.closeFinally(r103, null);
        return r101;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);
        throw th;
    L16:
        return false;
    }

    public static Uri a(Uri r100, String r101) {
        return r100.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", r101).appendQueryParameter("account_type", AccountType.LOCAL).build();
    }

    public static int b(ContentResolver r210, Uri r211, String[] r212) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r211, "sync_data1=?", r212};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240019);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r112 = r111.length;
        int r104 = 0;
    L8:
        if (r104 >= r112) goto L15;
        f06.a r105 = r111[r104];
        int r113 = r104;
        int r114 = r112;
        f06.a[] r213 = r111;
        d r106 = r105.preInvoke(240019, "android/content/ContentResolver", "delete", r210, r101, "int", r110);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return ((Integer) r106.f474983b).intValue();
    L21:
        return r210.delete(r211, "sync_data1=?", r212);
    L14:
        r104 = r113 + 1;
        r112 = r114;
        r111 = r213;
        goto L8
    L15:
        r106 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Uri c(ContentResolver r110, Uri r111, ContentValues r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240017);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(240017, "android/content/ContentResolver", "insert", r110, r101, "android.net.Uri", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (Uri) r107.f474983b;
    L21:
        return r110.insert(r111, r210);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Cursor d(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114) {
        c r100 = new c();
        Object[] r101 = {r111, r112, r113, r114, null};
        f06.b r115 = new f06.b();
        d r116 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r115);
        if (r116.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r115, false);
        return (Cursor) r116.f474983b;
    L6:
        Cursor r117 = r110.query(r111, r112, r113, r114, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r117, r115, true);
        return r117;
    }
}
