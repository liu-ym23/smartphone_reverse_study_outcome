package com.bytedance.android.shopping.anchorv4.voavhs.car;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface f {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(f r12, String r13, Map r14, boolean r15, String r16, PageFinder r17, String r18, String r19, int r20) {
            if ((r20 & 2) == 0) goto L5;
            Map r5 = null;
        L7:
            if ((r20 & 8) == 0) goto L9;
            boolean r7 = true;
        L11:
            if ((r20 & 16) == 0) goto L13;
            String r8 = null;
        L15:
            if ((r20 & 32) == 0) goto L17;
            PageFinder r9 = null;
        L19:
            if ((r20 & 64) == 0) goto L21;
            String r10 = "";
        L23:
            if ((r20 & 128) == 0) goto L25;
            String r11 = null;
        L26:
            r12.g(r13, r5, false, r7, r8, r9, r10, r11);
            return;
        L25:
            r11 = r19;
            goto L26
        L21:
            r10 = r18;
            goto L23
        L17:
            r9 = r17;
            goto L19
        L13:
            r8 = r16;
            goto L15
        L9:
            r7 = r15;
            goto L11
        L5:
            r5 = r14;
            goto L7
        }
    }

    CommonMeta a();

    LinkedTreeMap<String, Object> b();

    String f();

    void g(String r1, Map<String, ? extends Object> r2, boolean r3, boolean r4, String r5, PageFinder r6, String r7, String r8);
}
