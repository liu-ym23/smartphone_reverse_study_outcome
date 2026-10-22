package rd7;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.CalendarContract;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.concurrent.Callable;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
public final class s<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.b f537334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ContentResolver f537335b;

    public s(c.b r100, ContentResolver r101) {
        this.f537334a = r100;
        this.f537335b = r101;
    }

    @Override // java.util.concurrent.Callable
    public final c.InterfaceC7467c call() {
        int r100 = com.bytedance.sdk.xbridge.cn.calendar.reducer.b.f269860a;
        c.b r101 = this.f537334a;
        ContentResolver r102 = this.f537335b;
        Intrinsics.checkNotNullParameter(r101, "param");
        Intrinsics.checkNotNullParameter(r102, "contentResolver");
        Cursor r103 = com.bytedance.sdk.xbridge.cn.calendar.reducer.b.a(r102, CalendarContract.Events.CONTENT_URI, new String[]{DBDefinition.ID, "sync_data1", "dtstart", "dtend", "title", "description", "eventLocation", "sync_data3", "lastDate"}, "sync_data1=?", new String[]{r101.getIdentifier()});
        if (r103 == null) goto L30;
        Cursor r104 = r103;
        Cursor r105 = r104;     // Catch: Throwable -> L25
        if (r105.getCount() > 0) goto L10;
        id7.c.a("read calendar but with this identifier = " + r101.getIdentifier() + ", got a null.");     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r104, null);
        return null;
    L10:
        if (r105.moveToNext() == false) goto L23;
        XBaseModel r106 = ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC7467c.class));     // Catch: Throwable -> L25
        c.InterfaceC7467c r107 = (c.InterfaceC7467c) r106;     // Catch: Throwable -> L25
        Integer r108 = com.bytedance.sdk.xbridge.cn.calendar.reducer.b.b(r105.getLong(0), r102);     // Catch: Throwable -> L25
        if (r108 == null) goto L14;
        r107.setAlarmOffset(Integer.valueOf(r108.intValue() * 60000));     // Catch: Throwable -> L25
    L14:
        r107.setStartDate(Long.valueOf(r105.getLong(2)));     // Catch: Throwable -> L25
        long r109 = r105.getLong(3);     // Catch: Throwable -> L25
        long r110 = r105.getLong(8);     // Catch: Throwable -> L25
        if (r109 == 0) goto L18;
    L21:
        r107.setEndDate(Long.valueOf(r109));     // Catch: Throwable -> L25
        r107.setTitle(r105.getString(4));     // Catch: Throwable -> L25
        r107.setNotes(r105.getString(5));     // Catch: Throwable -> L25
        r107.setLocation(r105.getString(6));     // Catch: Throwable -> L25
        r107.setUrl(r105.getString(7));     // Catch: Throwable -> L25
        c.InterfaceC7467c r111 = (c.InterfaceC7467c) r106;     // Catch: Throwable -> L25
    L24:
        CloseableKt.closeFinally(r104, null);
        return r111;
    L18:
        if (r110 == 0) goto L20;
        r109 = r110;
        goto L21
    L20:
        r109 = 0;
        goto L21
    L23:
        r111 = null;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);
        throw th;
    L30:
        id7.c.a("read calendar but meet an error. Please check.");
        return null;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
