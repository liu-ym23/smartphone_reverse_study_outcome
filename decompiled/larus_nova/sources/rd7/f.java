package rd7;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import java.util.concurrent.Callable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes22.dex */
public final class f<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f537302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a.b f537303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ContentResolver f537304c;

    public f(l r100, a.b r101, ContentResolver r102) {
        this.f537302a = r100;
        this.f537303b = r101;
        this.f537304c = r102;
    }

    @Override // java.util.concurrent.Callable
    public final Boolean call() {
        l r100 = this.f537302a;
        a.b r101 = this.f537303b;
        ContentResolver r110 = this.f537304c;
        int r102 = l.f537318e;
        r100.getClass();
        String[] r103 = {"sync_data1"};
        boolean r111 = false;
        String[] r112 = {r101.getIdentifier()};
        Uri r104 = CalendarContract.Events.CONTENT_URI;
        f06.c r113 = new f06.c();
        Object[] r114 = {r104, r103, "sync_data1=?", r112, null};
        f06.b r115 = new f06.b();
        f06.d r116 = r113.b(240004, "android/content/ContentResolver", "query", r110, r114, "android.database.Cursor", r115);
        if (r116.f474982a == false) goto L5;
        r113.a(240004, "android/content/ContentResolver", "query", r110, r114, null, r115, false);
        Cursor r105 = (Cursor) r116.f474983b;
    L6:
        if (r105 == null) goto L19;
        Cursor r106 = r105;
        if (r106.getCount() <= 0) goto L11;
        r111 = true;
    L11:
        CloseableKt.closeFinally(r106, null);
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r106, th);
        throw th;
    L19:
        return Boolean.valueOf(r111);
    L5:
        r105 = r110.query(r104, r103, "sync_data1=?", r112, null);
        r113.a(240004, "android/content/ContentResolver", "query", r110, r114, r105, r115, true);
        goto L6
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
