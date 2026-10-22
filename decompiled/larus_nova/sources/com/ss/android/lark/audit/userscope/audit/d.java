package com.ss.android.lark.audit.userscope.audit;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.audit.db.AuditDBData;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.pb.security_event.OperationType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@UserScope
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f409472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public iwa.a f409473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public iwa.a f409474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f409475d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f409476a;

        public a(d r100) {
            this.f409476a = r100;
        }

        public final void a() {
            d r100 = this.f409476a;
            LarkAppContext.a r101 = LarkAppContext.Companion;
            r101.getClass();
            r100.f409473b = new iwa.a(LarkAppContext.access$getInstance$cp().getContext(), "audit_sdk_" + this.f409476a.f409472a.hashCode(), CollectionsKt.listOf("audit_table"));
            d r102 = this.f409476a;
            r101.getClass();
            r102.f409474c = new iwa.a(LarkAppContext.access$getInstance$cp().getContext(), "audit_sdk}", CollectionsKt.listOf("audit_table"));
            this.f409476a.f409475d = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b {
    }

    static {
    }

    @Inject
    public d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f409472a = r100;
        ScheduledExecutorService r101 = com.ss.android.lark.audit.userscope.audit.a.f409464d;
        com.ss.android.lark.audit.userscope.audit.a.f409464d.execute(new a(this));
    }

    public static List b(SQLiteDatabase r110) {
        Cursor r111 = r110.query("audit_table", new String[]{"time", "data"}, null, null, null, null, "time", "50");
        ArrayList r100 = new ArrayList();
    L4:
        if (r111.moveToNext() == false) goto L10;
        int r101 = r111.getColumnIndex("time");
        int r102 = r111.getColumnIndex("data");
        if (r101 <= (-1)) goto L9;
        if (r102 <= (-1)) goto L9;
        r100.add(new AuditDBData(r111.getLong(r101), r111.getString(r102)));
    L9:
        nwa.d.a("");
        goto L4
    L10:
        r111.close();
        return r100;
    }

    public final void delete(List<? extends AuditDBData> r100) {
        Intrinsics.checkNotNullParameter(r100, "dataList");
        if (this.f409475d == true) goto L5;
        return;
    L5:
        Log.i("AUDIT_AuditEventStorage", "[delete data]: delete count = " + r100.size());
        iwa.a r101 = this.f409473b;
        iwa.a r102 = null;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("userDBHelper");
        r101 = null;
    L8:
        a(r101.getWritableDatabase(), r100);
        iwa.a r103 = this.f409474c;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("globalDBHelper");
    L12:
        SQLiteDatabase r104 = r102.getWritableDatabase();
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r100.iterator();
    L14:
        if (r106.hasNext() == false) goto L21;
        Object r107 = r106.next();
        if (((AuditDBData) r107).f409451c.mOperation != OperationType.OperationPassportChangeAccount) goto L18;
        boolean r108 = true;
    L19:
        if (r108 == false) goto L14;
        r105.add(r107);
        goto L14
    L18:
        r108 = false;
        goto L19
    L21:
        a(r104, r105);
        return;
    L11:
        r102 = r103;
        goto L12
    }

    public static void a(SQLiteDatabase r100, List r101) {
        if (r101.isEmpty() == false) goto L5;
        return;
    L5:
        StringBuilder r102 = new StringBuilder();
        Iterator r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r102.append(((AuditDBData) r103.next()).f409449a);
        r102.append(",");
        goto L7
    L9:
        String r104 = r102.toString();
        if ((!r101.isEmpty()) == false) goto L12;
        r104 = r104.substring(0, r104.length() - 1);
    L12:
        r100.execSQL("delete from audit_table where time in(" + r104 + ')');
    }
}
