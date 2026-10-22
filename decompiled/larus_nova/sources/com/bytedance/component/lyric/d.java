package com.bytedance.component.lyric;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;
import jg4.g;
import jg4.h;
import jg4.j;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements h {
    public d() {
    }

    @Override // jg4.h
    public final void a(j r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "callback");
        kg4.a.b("开始解析");
        r100.getClass();
        String r102 = r100.f498995k + r100.f498996l;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102);
        if (r103.exists() == false) goto L33;
        List<com.bytedance.component.lyric.model.b> r104 = null;
        if (StringsKt.endsWith$default(r102, ".lrc", false, 2, null) == false) goto L8;
        int r105 = 2;
    L11:
        r100.f498988d = r105;
        if (r105 == 2) goto L16;
        if (r105 == 3) goto L15;
        lg4.c r106 = null;
    L17:
        if (r106 == null) goto L27;
        Intrinsics.checkNotNullParameter(r103, "file");     // Catch: Exception -> L26
        com.bytedance.component.lyric.model.a r107 = r106.a(new PolarisFileInputStreamWrapper(r103));     // Catch: Exception -> L26
        if (r107 == null) goto L27;
        TreeMap<Integer, com.bytedance.component.lyric.model.b> r108 = r107.f203026a;     // Catch: Exception -> L26
        if (r108 == null) goto L27;
        Collection<com.bytedance.component.lyric.model.b> r109 = r108.values();     // Catch: Exception -> L26
        if (r109 == null) goto L27;
        r104 = CollectionsKt.toList(r109);     // Catch: Exception -> L26
        goto L27
    L15:
        r106 = new lg4.a();     // Catch: Exception -> L26
        goto L17
    L16:
        r106 = new lg4.b();     // Catch: Exception -> L26
    L27:
        if (r104 != null) goto L29;
    L32:
        r101.i(r100, "parse result is null or empty");
        return;
    L29:
        if ((!r104.isEmpty()) != true) goto L32;
        r100.f498987c = r104;
        r101.b(r100);
        return;
    L8:
        if (StringsKt.endsWith$default(r102, ".krc", false, 2, null) == false) goto L10;
        r105 = 3;
        goto L11
    L10:
        r105 = r100.f498988d;
        goto L11
    L33:
        r101.i(r100, "lyric file not exist");
    }
}
