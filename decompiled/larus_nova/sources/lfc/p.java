package lfc;

import android.content.AsyncQueryHandler;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class p implements kfc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f509110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f509111b;

    /* JADX INFO: loaded from: classes38.dex */
    public class a extends b {
        public a(ContentResolver r100) {
            super(r100);
        }
    }

    /* JADX INFO: loaded from: classes38.dex */
    public static class b extends AsyncQueryHandler {

        public class a extends AsyncQueryHandler.WorkerHandler {
            @Override // android.content.AsyncQueryHandler.WorkerHandler, android.os.Handler
            public final void handleMessage(Message r100) {
                super.handleMessage(r100);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                th.printStackTrace();
            }

            public a(b r100, Looper r101) {
                super(r100, r101);
            }
        }

        public b(ContentResolver r100) {
            super(r100);
        }

        @Override // android.content.AsyncQueryHandler
        public final Handler createHandler(Looper r100) {
            return new a(this, r100);
        }
    }

    @Override // kfc.a
    public final List<String> b() {
        return Arrays.asList(new String[]{"com.sonyericsson.home", "com.sonymobile.home"});
    }

    public p() {
        this.f509110a = UriProtector.parse("content://com.sonymobile.home.resourceprovider/badge");
    }

    public static void c(Context r100, ComponentName r101, int r102) {
        Intent r103 = new Intent("com.sonyericsson.home.action.UPDATE_BADGE");
        r103.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", r101.getPackageName());
        r103.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", r101.getClassName());
        r103.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String.valueOf(r102));
        if (r102 <= 0) goto L5;
        boolean r104 = true;
    L6:
        r103.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", r104);
        r100.sendBroadcast(r103);
        return;
    L5:
        r104 = false;
        goto L6
    }

    @Override // kfc.a
    public final void a(Context r100, ComponentName r101, int r102) throws RedBadgerException {
        if (r100 == null) goto L18;
        if (r101 == null) goto L21;
        boolean r103 = false;
        if (r102 >= 0) goto L19;
        r102 = 0;
    L19:
    L15:
        th = move-exception;
        th.printStackTrace();
        throw new RedBadgerException(th.getMessage());
    L9:
        if (r100.getPackageManager().resolveContentProvider("com.sonymobile.home.resourceprovider", 0) == null) goto L11;
        r103 = true;
    L11:
        if (r103 == false) goto L13;
        d(r100, r101, r102);     // Catch: Throwable -> L15
        return;
    L13:
        c(r100, r101, r102);     // Catch: Throwable -> L15
        return;
    L21:
        return;
    }

    public final void d(Context r100, ComponentName r101, int r102) {
        if (r102 >= 0) goto L5;
        return;
    L5:
        if (this.f509111b != null) goto L7;
        this.f509111b = new a(r100.getApplicationContext().getContentResolver());
    L7:
        String r103 = r101.getPackageName();
        String r104 = r101.getClassName();
        ContentValues r105 = new ContentValues();
        r105.put("badge_count", Integer.valueOf(r102));
        r105.put("package_name", r103);
        r105.put("activity_name", r104);
        this.f509111b.startInsert(0, null, this.f509110a, r105);
    }
}
