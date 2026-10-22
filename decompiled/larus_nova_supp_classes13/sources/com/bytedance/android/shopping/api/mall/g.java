package com.bytedance.android.shopping.api.mall;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface g extends d {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(g r7, Map r8, boolean r9, boolean r10, Function1 r11, int r12) {
            if ((r12 & 1) == 0) goto L5;
            r8 = new LinkedHashMap();
        L5:
            Map r1 = r8;
            if ((r12 & 2) == 0) goto L8;
            boolean r2 = true;
        L10:
            if ((r12 & 16) == 0) goto L12;
            boolean r5 = false;
        L14:
            if ((r12 & 32) == 0) goto L16;
            r11 = null;
        L16:
            r7.TK(r1, r2, false, false, r5, r11);
            return;
        L12:
            r5 = r10;
            goto L14
        L8:
            r2 = r9;
            goto L10
        }
    }

    void TK(Map<String, ? extends Object> r1, boolean r2, boolean r3, boolean r4, boolean r5, Function1<? super Boolean, Unit> r6);
}
