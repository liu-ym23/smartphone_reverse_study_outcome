package com.suite.component.logger.interceptor;

import com.bytedance.android.ec.slice.SliceInitService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.component.logger.api.d;
import com.suite.component.logger.c;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements d {

    /* JADX INFO: renamed from: com.suite.component.logger.interceptor.a$a, reason: collision with other inner class name */
    public static final class C5517a extends StringWriter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f460144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f460145b;

        public C5517a() {
        }

        @Override // java.io.StringWriter, java.io.Writer
        public final void write(String r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "str");
            if (this.f460145b == false) goto L5;
            return;
        L5:
            int r103 = this.f460144a;
            if ((r103 + r102) <= 4000) goto L9;
            this.f460145b = true;
            return;
        L9:
            this.f460144a = r103 + r102;
            super.write(r100, r101, r102);
        }
    }

    public a() {
    }

    @Override // com.suite.component.logger.api.d
    public final void a(d.a r110, com.suite.component.logger.b r111, c r112) {
        Intrinsics.checkNotNullParameter(r110, "chain");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "entity");
        int r100 = 0;
        if (r112.f460117c.length() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L18;
        Function0<String> r102 = r112.f460119e;
        if (r102 == null) goto L11;
        String r103 = r102.invoke();
    L12:
        if (r103 != null) goto L14;
    L15:
        r100 = 1;
    L16:
        if (r100 != 0) goto L44;
        r112.b(r103);
    L44:
        Throwable r104 = r112.f460124j;
        if (r104 == null) goto L57;
        StringBuilder r105 = new StringBuilder();
        r105.append(r112.f460117c);
        r105.append('\n');
        Throwable r106 = r104;
    L47:
        if (r106 == null) goto L52;
        if ((r106 instanceof UnknownHostException) == true) goto L50;
        r106 = r106.getCause();
        goto L47
    L50:
        String r107 = "UnknownHostException";
    L55:
        r105.append(r107);
        r112.b(r105.toString());
        goto L57
    L52:
        C5517a r108 = new C5517a();
        PrintWriter r109 = new PrintWriter(r108);
        r104.printStackTrace(r109);     // Catch: Throwable -> L67
    L54:
        r109.flush();
        r107 = r108.toString();
    L57:
        if (r112.f460119e == null) goto L60;
        r112.f460119e = null;
    L60:
        if (r112.f460118d == null) goto L63;
        r112.f460118d = null;
    L63:
        if (r112.f460124j == null) goto L65;
        r112.f460124j = null;
    L65:
        r110.a(r111, r112);
        return;
    L14:
        if (r103.length() != 0) goto L16;
    L11:
        r103 = null;
        goto L12
    L18:
        String[] r113 = r112.f460118d;
        if (r113 != null) goto L21;
    L27:
        boolean r114 = true;
    L28:
        if (r114 == true) goto L44;
        List r115 = StringsKt.split$default(r112.f460117c, new String[]{SliceInitService.DEFAULT_SWITCH}, false, 0, 6, null);
        if (r115.size() == (r113.length + 1)) goto L32;
        r112.b(r112.f460117c + ", " + ArraysKt.joinToString$default(r113, ", ", null, null, 0, null, null, 62, null));
        goto L44
    L32:
        Iterator r116 = r115.iterator();
        String r117 = "";
    L34:
        if (r116.hasNext() == false) goto L43;
        Object r118 = r116.next();
        int r119 = r100 + 1;
        if (r100 >= 0) goto L38;
        CollectionsKt.throwIndexOverflow();
    L38:
        String r120 = (String) r118;
        if (r100 >= r113.length) goto L41;
        String r121 = r117 + r120 + r113[r100];
    L42:
        r117 = r121;
        r100 = r119;
        goto L34
    L41:
        r121 = r117 + r120;
        goto L42
    L43:
        r112.b(r117);
        goto L44
    L21:
        if (r113.length != 0) goto L23;
        boolean r122 = true;
    L24:
        if (r122 == true) goto L27;
        r114 = false;
        goto L28
    L23:
        r122 = false;
        goto L24
    L5:
        r101 = false;
        goto L7
    }
}
