package sf7;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.supervisor.token.AtomicInfoDef;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import f06.c;
import f06.d;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import of7.b;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f541727a = null;

    static {
        f541727a = new a();
    }

    public a() {
    }

    public static String a(Uri r100) {
        String r101 = r100.getAuthority();
        if (r101 == null) goto L17;
        int r102 = r101.hashCode();
        if (r102 == (-456066902)) goto L14;
        if (r102 != 103772132) goto L17;
        if (r101.equals("media") == false) goto L17;
        return AtomicInfoDef.CONTENT_RESOLVER_DELETE_MEDIA;
    L14:
        if (r101.equals("com.android.calendar") == false) goto L17;
        return AtomicInfoDef.CONTENT_RESOLVER_DELETE_CALENDAR;
    L17:
        return null;
    }

    public static String b(Uri r100) {
        String r101 = r100.getAuthority();
        if (r101 == null) goto L23;
        int r102 = r101.hashCode();
        if (r102 == (-845193793)) goto L20;
        if (r102 == (-456066902)) goto L16;
        if (r102 != 103772132) goto L23;
        if (r101.equals("media") == false) goto L23;
        return AtomicInfoDef.CONTENT_RESOLVER_INSERT_MEDIA;
    L16:
        if (r101.equals("com.android.calendar") == false) goto L23;
        return AtomicInfoDef.CONTENT_RESOLVER_INSERT_CALENDAR;
    L20:
        if (r101.equals("com.android.contacts") == false) goto L23;
        return AtomicInfoDef.CONTENT_RESOLVER_INSERT_CONTACTS;
    L23:
        return null;
    }

    public static String c(Uri r100) {
        String r101 = r100.getAuthority();
        if (r101 != null) goto L5;
    L43:
        return null;
    L5:
        switch(r101.hashCode()) {
            case -845193793: goto L40;
            case -456066902: goto L36;
            case -172298781: goto L32;
            case -110932274: goto L28;
            case 108243: goto L24;
            case 114009: goto L20;
            case 103772132: goto L16;
            case 384442326: goto L12;
            case 1181890399: goto L8;
            default: goto L43;
        };
    L8:
        if (r101.equals("mms-sms") == false) goto L43;
        return AtomicInfoDef.CONTENT_RESOLVER_QUERY_MMS_SMS;
    L12:
        if (r101.equals("browser/bookmarks") == false) goto L43;
        return AtomicInfoDef.CONTENT_RESOLVER_QUERY_BROWSER_BOOKMARKS;
    L16:
        if (r101.equals("media") == false) goto L43;
        return AtomicInfoDef.CONTENT_RESOLVER_QUERY_MEDIA;
    L20:
        if (r101.equals("sms") == false) goto L43;
        return AtomicInfoDef.CONTENT_RESOLVER_QUERY_SMS;
    L24:
        if (r101.equals("mms") == false) goto L43;
        return AtomicInfoDef.CONTENT_RESOLVER_QUERY_MMS;
    L28:
        if (r101.equals("com.android.chrome.browser/bookmarks") == false) goto L43;
        return AtomicInfoDef.CONTENT_RESOLVER_QUERY_CHROME_BROWSER_BOOKMARKS;
    L32:
        if (r101.equals("call_log") == false) goto L43;
        return AtomicInfoDef.CONTENT_RESOLVER_QUERY_CALL_LOG;
    L36:
        if (r101.equals("com.android.calendar") == false) goto L43;
        return AtomicInfoDef.CONTENT_RESOLVER_QUERY_CALENDAR;
    L40:
        if (r101.equals("com.android.contacts") == false) goto L43;
        return AtomicInfoDef.CONTENT_RESOLVER_QUERY_CONTACTS;
    }

    public static String d(Uri r100) {
        String r101 = r100.getAuthority();
        if (r101 == null) goto L17;
        int r102 = r101.hashCode();
        if (r102 == (-456066902)) goto L14;
        if (r102 != 103772132) goto L17;
        if (r101.equals("media") == false) goto L17;
        return AtomicInfoDef.CONTENT_RESOLVER_UPDATE_MEDIA;
    L14:
        if (r101.equals("com.android.calendar") == false) goto L17;
        return AtomicInfoDef.CONTENT_RESOLVER_UPDATE_CALENDAR;
    L17:
        return null;
    }

    public final int delete(ContentResolver r210, Uri r211, Bundle r212, Token r213) throws SensitiveAPIException {
        Intrinsics.checkNotNullParameter(r210, SRStrategy.KEY_CURRENT_RESOLUTION);
        Intrinsics.checkNotNullParameter(r211, "uri");
        Intrinsics.checkNotNullParameter(r213, "token");
        ArrayList r100 = new ArrayList();
        String r101 = a(r211);
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        rf7.a.a(r213, new b(r100, new String[]{r211.toString()}));
        ArrayList r102 = new ArrayList();
        Object[] r103 = {r211, r212};
        f06.b r110 = new f06.b();
        g06.a r104 = ApiHookConfig.f245611b.get(240019);
        if (r104 == null) goto L9;
        f06.a[] r105 = r104.f479473i;
    L10:
        f06.a[] r111 = r105;
        int r106 = r111.length;
        int r107 = 0;
    L12:
        if (r107 >= r106) goto L19;
        f06.a r108 = r111[r107];
        int r112 = r107;
        int r113 = r106;
        f06.a[] r114 = r111;
        d r109 = r108.preInvoke(240019, "android/content/ContentResolver", "delete", r210, r103, "int", r110);     // Catch: Exception -> L25
        if (r109.f474982a == true) goto L21;
        r102.add(r108);     // Catch: Exception -> L25
    L21:
        if (r109.f474982a == false) goto L24;
        return ((Integer) r109.f474983b).intValue();
    L24:
        return r210.delete(r211, r212);
    L18:
        r107 = r112 + 1;
        r106 = r113;
        r111 = r114;
        goto L12
    L19:
        r109 = new d(false, null);
        goto L21
    L9:
        r105 = ApiHookConfig.f245613d;
        goto L10
    }

    public final Uri insert(ContentResolver r210, Uri r211, ContentValues r212, Token r213) throws SensitiveAPIException {
        Intrinsics.checkNotNullParameter(r210, SRStrategy.KEY_CURRENT_RESOLUTION);
        Intrinsics.checkNotNullParameter(r211, "uri");
        Intrinsics.checkNotNullParameter(r213, "token");
        ArrayList r100 = new ArrayList();
        String r101 = b(r211);
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        rf7.a.a(r213, new b(r100, new String[]{r211.toString()}));
        ArrayList r102 = new ArrayList();
        Object[] r103 = {r211, r212};
        f06.b r110 = new f06.b();
        g06.a r104 = ApiHookConfig.f245611b.get(240017);
        if (r104 == null) goto L9;
        f06.a[] r105 = r104.f479473i;
    L10:
        f06.a[] r111 = r105;
        int r106 = r111.length;
        int r107 = 0;
    L12:
        if (r107 >= r106) goto L19;
        f06.a r108 = r111[r107];
        int r112 = r107;
        int r113 = r106;
        f06.a[] r114 = r111;
        d r109 = r108.preInvoke(240017, "android/content/ContentResolver", "insert", r210, r103, "android.net.Uri", r110);     // Catch: Exception -> L25
        if (r109.f474982a == true) goto L21;
        r102.add(r108);     // Catch: Exception -> L25
    L21:
        if (r109.f474982a == false) goto L24;
        return (Uri) r109.f474983b;
    L24:
        return r210.insert(r211, r212);
    L18:
        r107 = r112 + 1;
        r106 = r113;
        r111 = r114;
        goto L12
    L19:
        r109 = new d(false, null);
        goto L21
    L9:
        r105 = ApiHookConfig.f245613d;
        goto L10
    }

    public final int delete(ContentResolver r210, Uri r211, String r212, String[] r213, Token r214) throws SensitiveAPIException {
        Intrinsics.checkNotNullParameter(r210, SRStrategy.KEY_CURRENT_RESOLUTION);
        Intrinsics.checkNotNullParameter(r211, "uri");
        Intrinsics.checkNotNullParameter(r214, "token");
        ArrayList r100 = new ArrayList();
        String r101 = a(r211);
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        rf7.a.a(r214, new b(r100, new String[]{r211.toString()}));
        ArrayList r102 = new ArrayList();
        Object[] r103 = {r211, r212, r213};
        f06.b r110 = new f06.b();
        g06.a r104 = ApiHookConfig.f245611b.get(240019);
        if (r104 == null) goto L9;
        f06.a[] r105 = r104.f479473i;
    L10:
        f06.a[] r111 = r105;
        int r106 = r111.length;
        int r107 = 0;
    L12:
        if (r107 >= r106) goto L19;
        f06.a r108 = r111[r107];
        int r112 = r107;
        int r113 = r106;
        f06.a[] r114 = r111;
        d r109 = r108.preInvoke(240019, "android/content/ContentResolver", "delete", r210, r103, "int", r110);     // Catch: Exception -> L25
        if (r109.f474982a == true) goto L21;
        r102.add(r108);     // Catch: Exception -> L25
    L21:
        if (r109.f474982a == false) goto L24;
        return ((Integer) r109.f474983b).intValue();
    L24:
        return r210.delete(r211, r212, r213);
    L18:
        r107 = r112 + 1;
        r106 = r113;
        r111 = r114;
        goto L12
    L19:
        r109 = new d(false, null);
        goto L21
    L9:
        r105 = ApiHookConfig.f245613d;
        goto L10
    }

    public final Uri insert(ContentResolver r210, Uri r211, ContentValues r212, Bundle r213, Token r214) throws SensitiveAPIException {
        Intrinsics.checkNotNullParameter(r210, SRStrategy.KEY_CURRENT_RESOLUTION);
        Intrinsics.checkNotNullParameter(r211, "uri");
        Intrinsics.checkNotNullParameter(r214, "token");
        ArrayList r100 = new ArrayList();
        String r101 = b(r211);
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        rf7.a.a(r214, new b(r100, new String[]{r211.toString()}));
        ArrayList r102 = new ArrayList();
        Object[] r103 = {r211, r212, r213};
        f06.b r110 = new f06.b();
        g06.a r104 = ApiHookConfig.f245611b.get(240017);
        if (r104 == null) goto L9;
        f06.a[] r105 = r104.f479473i;
    L10:
        f06.a[] r111 = r105;
        int r106 = r111.length;
        int r107 = 0;
    L12:
        if (r107 >= r106) goto L19;
        f06.a r108 = r111[r107];
        int r112 = r107;
        int r113 = r106;
        f06.a[] r114 = r111;
        d r109 = r108.preInvoke(240017, "android/content/ContentResolver", "insert", r210, r103, "android.net.Uri", r110);     // Catch: Exception -> L25
        if (r109.f474982a == true) goto L21;
        r102.add(r108);     // Catch: Exception -> L25
    L21:
        if (r109.f474982a == false) goto L24;
        return (Uri) r109.f474983b;
    L24:
        return r210.insert(r211, r212, r213);
    L18:
        r107 = r112 + 1;
        r106 = r113;
        r111 = r114;
        goto L12
    L19:
        r109 = new d(false, null);
        goto L21
    L9:
        r105 = ApiHookConfig.f245613d;
        goto L10
    }

    public final int update(ContentResolver r210, Uri r211, ContentValues r212, Bundle r213, Token r214) throws SensitiveAPIException {
        Intrinsics.checkNotNullParameter(r210, SRStrategy.KEY_CURRENT_RESOLUTION);
        Intrinsics.checkNotNullParameter(r211, "uri");
        Intrinsics.checkNotNullParameter(r214, "token");
        ArrayList r100 = new ArrayList();
        String r101 = d(r211);
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        rf7.a.a(r214, new b(r100, new String[]{r211.toString()}));
        ArrayList r102 = new ArrayList();
        Object[] r103 = {r211, r212, r213};
        f06.b r110 = new f06.b();
        g06.a r104 = ApiHookConfig.f245611b.get(240018);
        if (r104 == null) goto L9;
        f06.a[] r105 = r104.f479473i;
    L10:
        f06.a[] r111 = r105;
        int r106 = r111.length;
        int r107 = 0;
    L12:
        if (r107 >= r106) goto L19;
        f06.a r108 = r111[r107];
        int r112 = r107;
        int r113 = r106;
        f06.a[] r114 = r111;
        d r109 = r108.preInvoke(240018, "android/content/ContentResolver", "update", r210, r103, "int", r110);     // Catch: Exception -> L25
        if (r109.f474982a == true) goto L21;
        r102.add(r108);     // Catch: Exception -> L25
    L21:
        if (r109.f474982a == false) goto L24;
        return ((Integer) r109.f474983b).intValue();
    L24:
        return r210.update(r211, r212, r213);
    L18:
        r107 = r112 + 1;
        r106 = r113;
        r111 = r114;
        goto L12
    L19:
        r109 = new d(false, null);
        goto L21
    L9:
        r105 = ApiHookConfig.f245613d;
        goto L10
    }

    public final Cursor query(ContentResolver r110, Uri r111, String[] r112, Bundle r113, CancellationSignal r114, Token r210) throws SensitiveAPIException {
        Intrinsics.checkNotNullParameter(r110, SRStrategy.KEY_CURRENT_RESOLUTION);
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r210, "token");
        ArrayList r100 = new ArrayList();
        String r101 = c(r111);
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        rf7.a.a(r210, new b(r100, new String[]{r111.toString()}));
        c r102 = new c();
        Object[] r103 = {r111, r112, r113, r114};
        f06.b r115 = new f06.b();
        d r116 = r102.b(240004, "android/content/ContentResolver", "query", r110, r103, "android.database.Cursor", r115);
        if (r116.f474982a == false) goto L9;
        r102.a(240004, "android/content/ContentResolver", "query", r110, r103, null, r115, false);
        return (Cursor) r116.f474983b;
    L9:
        Cursor r104 = r110.query(r111, r112, r113, r114);
        r102.a(240004, "android/content/ContentResolver", "query", r110, r103, r104, r115, true);
        return r104;
    }

    public final int update(ContentResolver r210, Uri r211, ContentValues r212, String r213, String[] r214, Token r215) throws SensitiveAPIException {
        Intrinsics.checkNotNullParameter(r210, SRStrategy.KEY_CURRENT_RESOLUTION);
        Intrinsics.checkNotNullParameter(r211, "uri");
        Intrinsics.checkNotNullParameter(r215, "token");
        ArrayList r100 = new ArrayList();
        String r101 = d(r211);
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        rf7.a.a(r215, new b(r100, new String[]{r211.toString()}));
        ArrayList r102 = new ArrayList();
        Object[] r103 = {r211, r212, r213, r214};
        f06.b r110 = new f06.b();
        g06.a r104 = ApiHookConfig.f245611b.get(240018);
        if (r104 == null) goto L9;
        f06.a[] r105 = r104.f479473i;
    L10:
        f06.a[] r111 = r105;
        int r106 = r111.length;
        int r107 = 0;
    L12:
        if (r107 >= r106) goto L19;
        f06.a r108 = r111[r107];
        int r112 = r107;
        int r113 = r106;
        f06.a[] r114 = r111;
        d r109 = r108.preInvoke(240018, "android/content/ContentResolver", "update", r210, r103, "int", r110);     // Catch: Exception -> L25
        if (r109.f474982a == true) goto L21;
        r102.add(r108);     // Catch: Exception -> L25
    L21:
        if (r109.f474982a == false) goto L24;
        return ((Integer) r109.f474983b).intValue();
    L24:
        return r210.update(r211, r212, r213, r214);
    L18:
        r107 = r112 + 1;
        r106 = r113;
        r111 = r114;
        goto L12
    L19:
        r109 = new d(false, null);
        goto L21
    L9:
        r105 = ApiHookConfig.f245613d;
        goto L10
    }

    public final Cursor query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r210, Token r211) throws SensitiveAPIException {
        Intrinsics.checkNotNullParameter(r110, SRStrategy.KEY_CURRENT_RESOLUTION);
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r211, "token");
        ArrayList r100 = new ArrayList();
        String r101 = c(r111);
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        rf7.a.a(r211, new b(r100, new String[]{r111.toString()}));
        c r102 = new c();
        Object[] r103 = {r111, r112, r113, r114, r210};
        f06.b r115 = new f06.b();
        d r116 = r102.b(240004, "android/content/ContentResolver", "query", r110, r103, "android.database.Cursor", r115);
        if (r116.f474982a == false) goto L9;
        r102.a(240004, "android/content/ContentResolver", "query", r110, r103, null, r115, false);
        return (Cursor) r116.f474983b;
    L9:
        Cursor r104 = r110.query(r111, r112, r113, r114, r210);
        r102.a(240004, "android/content/ContentResolver", "query", r110, r103, r104, r115, true);
        return r104;
    }

    public final Cursor query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r210, CancellationSignal r211, Token r212) throws SensitiveAPIException {
        Intrinsics.checkNotNullParameter(r110, SRStrategy.KEY_CURRENT_RESOLUTION);
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r212, "token");
        ArrayList r100 = new ArrayList();
        String r101 = c(r111);
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        rf7.a.a(r212, new b(r100, new String[]{r111.toString()}));
        c r102 = new c();
        Object[] r103 = {r111, r112, r113, r114, r210, r211};
        f06.b r115 = new f06.b();
        d r116 = r102.b(240004, "android/content/ContentResolver", "query", r110, r103, "android.database.Cursor", r115);
        if (r116.f474982a == false) goto L9;
        r102.a(240004, "android/content/ContentResolver", "query", r110, r103, null, r115, false);
        return (Cursor) r116.f474983b;
    L9:
        Cursor r104 = r110.query(r111, r112, r113, r114, r210, r211);
        r102.a(240004, "android/content/ContentResolver", "query", r110, r103, r104, r115, true);
        return r104;
    }
}
