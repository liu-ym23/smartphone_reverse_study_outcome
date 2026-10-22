package xx4;

import com.ss.android.lark.jsruntime.vmsdk.h;
import com.ss.android.lark.jsruntime.vmsdk.i;
import com.ss.android.lark.jsruntime.vmsdk.module.e;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements Callback {
    public final /* synthetic */ h a;
    public final /* synthetic */ com.ss.android.lark.jsruntime.vmsdk.b<i> b;
    public final /* synthetic */ b c;
    public final /* synthetic */ com.ss.android.lark.jsruntime.vmsdk.b<Throwable> d;

    public final void onFailure(Call r2, IOException r3) {
        Intrinsics.checkNotNullParameter(r2, "call");
        Intrinsics.checkNotNullParameter(r3, "e");
        tt5.a.d("JSRuntimeRequestDelegate", "fetch onFailure url:" + du5.b.k(this.a.a) + " , reason is :" + r3);
        this.d.a(r3);
    }

    public final void onResponse(Call r10, Response r11) {
        Intrinsics.checkNotNullParameter(r10, "call");
        Intrinsics.checkNotNullParameter(r11, "response");
        int r12 = r11.code();
        String r2 = r11.request().url().toString();
        ResponseBody r1 = r11.body();
        if (r1 == null) goto L5;
        MediaType r3 = r1.contentType();
    L6:
        if (r3 == null) goto L9;
        String r4 = r3.type() + '/' + r3.subtype();
        if (r4 == null) goto L9;
    L10:
        String r6 = r4;
        ResponseBody r5 = r11.body();     // Catch: IOException -> L16
        if (r5 == null) goto L15;
        InputStream r7 = r5.byteStream();     // Catch: IOException -> L16
    L18:
        if (r7 != null) goto L57;
        byte[] r8 = null;
    L27:
        CloseableKt.closeFinally(r7, null);
        LinkedHashMap r9 = new LinkedHashMap();
        Iterator r13 = r11.headers().names().iterator();
    L29:
        if (r13.hasNext() == false) goto L33;
        String r14 = (String) r13.next();
        String r16 = r11.headers().get(r14);
        if (r16 == null) goto L29;
        r9.put(r14, r16);
        goto L29
    L33:
        if (r8 == null) goto L45;
        b r17 = this.c;
        Charset r18 = Charsets.UTF_8;
        Reader r19 = new InputStreamReader(new ByteArrayInputStream(new String(r8, r18).getBytes(r18)), r18);
        if ((r19 instanceof BufferedReader) == false) goto L37;
        BufferedReader r20 = (BufferedReader) r19;
    L53:
        b.a(r17, r2, TextStreamsKt.readText(r20));     // Catch: Throwable -> L40
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L40
        CloseableKt.closeFinally(r20, null);
    L40:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        CloseableKt.closeFinally(r20, th);
        throw th;
    L37:
        r20 = new BufferedReader(r19, 8192);
    L45:
        i r111 = new i(r2, r12, r9, new ByteArrayInputStream(r8), r6);
        StringBuilder r21 = new StringBuilder("fetch success url: ");
        r21.append(du5.b.k(this.a.a));
        r21.append(" status:");
        r21.append(r12);
        r21.append(" byteArray.size:");
        if (r8 == null) goto L48;
        int r112 = r8.length;
    L49:
        r21.append(r112);
        r21.append(" headersMap:");
        r21.append(r9.isEmpty());
        r21.append(' ');
        tt5.a.h("JSRuntimeRequestDelegate", r21.toString());
        this.b.a(r111);
        return;
    L48:
        r112 = -1;
        goto L49
    L57:
        r8 = ByteStreamsKt.readBytes(r7);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    L15:
        r7 = null;
    L16:
        e = move-exception;
        tt5.a.d("JSRuntimeRequestDelegate", "onResponse: error:" + e);
    L9:
        r4 = "unknown";
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public c(h r1, com.ss.android.lark.jsruntime.vmsdk.module.d r2, b r3, e r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
