package rd7;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.bytedance.sdk.xbridge.cn.calendar.model.CalendarErrorCode;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class m<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b.InterfaceC7466b f537320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ContentResolver f537321b;

    public m(b.InterfaceC7466b r100, ContentResolver r101) {
        this.f537320a = r100;
        this.f537321b = r101;
    }

    @Override // java.util.concurrent.Callable
    public final CalendarErrorCode call() {
        int r100 = com.bytedance.sdk.xbridge.cn.calendar.reducer.c.f269861a;
        b.InterfaceC7466b r101 = this.f537320a;
        ContentResolver r110 = this.f537321b;
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, "contentResolver");
        String[] r111 = {DBDefinition.ID};
        String[] r112 = {r101.getIdentifier()};
        Uri r113 = CalendarContract.Events.CONTENT_URI;
        f06.c r114 = new f06.c();
        Object[] r102 = {r113, r111, "sync_data1=?", r112, null};
        f06.b r115 = new f06.b();
        f06.d r103 = r114.b(240004, "android/content/ContentResolver", "query", r110, r102, "android.database.Cursor", r115);
        if (r103.f474982a == false) goto L5;
        r114.a(240004, "android/content/ContentResolver", "query", r110, r102, null, r115, false);
        Cursor r104 = (Cursor) r103.f474983b;
    L7:
        if (r104 != null) goto L10;
        id7.c.a("delete failed. maybe this identifier " + r101.getIdentifier() + " matches nothing.");
        return CalendarErrorCode.NotFound;
    L10:
        if (r104.moveToNext() == false) goto L15;
        com.bytedance.sdk.xbridge.cn.calendar.reducer.c.a(r110, CalendarContract.Reminders.CONTENT_URI, "event_id=?", new String[]{String.valueOf(r104.getLong(0))});
        if (com.bytedance.sdk.xbridge.cn.calendar.reducer.c.a(r110, CalendarContract.Events.CONTENT_URI, "sync_data1=?", r112) <= 0) goto L19;
        return CalendarErrorCode.Success;
    L19:
        return CalendarErrorCode.Failed;
    L15:
        id7.c.a("delete failed. maybe this identifier " + r101.getIdentifier() + " matches nothing.");
        return CalendarErrorCode.NotFound;
    L5:
        Cursor r116 = r110.query(r113, r111, "sync_data1=?", r112, null);
        r114.a(240004, "android/content/ContentResolver", "query", r110, r102, r116, r115, true);
        r104 = r116;
        goto L7
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
