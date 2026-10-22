package gwa;

import android.util.Base64;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.security_event.Event;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes34.dex */
public final class c {
    public static final Event a(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L17;
    L15:
        return null;
    L17:
        return Event.ADAPTER.decode(Base64.decode(r100.getBytes(Charsets.UTF_8), 0));
    L13:
        e = move-exception;
        Log.e("AUDIT_AuditRecordParser", "deserializeEvent error, e=" + ExceptionsKt.stackTraceToString(e));
        nwa.d.a(String.valueOf(e.getMessage()));
        goto L15
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public static final String b(Event r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new String(Base64.encode(r100.encode(), 0), Charsets.UTF_8);
    L5:
        e = move-exception;
        Log.e("AUDIT_AuditRecordParser", "serializeEvent error, e=" + ExceptionsKt.stackTraceToString(e));
        nwa.d.a(String.valueOf(e.getMessage()));
        return "";
    }
}
