package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface q {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(q r13, String r14, Map r15, boolean r16, String r17, View r18, String r19, Integer r20, Integer r21, int r22) {
            if ((r22 & 2) == 0) goto L5;
            Map r5 = null;
        L7:
            if ((r22 & 4) == 0) goto L9;
            boolean r6 = false;
        L11:
            if ((r22 & 8) == 0) goto L13;
            boolean r7 = true;
        L15:
            if ((r22 & 16) == 0) goto L17;
            String r8 = "";
        L19:
            if ((r22 & 32) == 0) goto L21;
            View r9 = null;
        L23:
            if ((r22 & 64) == 0) goto L25;
            String r10 = null;
        L27:
            if ((r22 & 128) == 0) goto L29;
            Integer r11 = null;
        L31:
            if ((r22 & 256) == 0) goto L33;
            Integer r12 = null;
        L34:
            r13.a(r14, r5, r6, r7, r8, r9, r10, r11, r12);
            return;
        L33:
            r12 = r21;
            goto L34
        L29:
            r11 = r20;
            goto L31
        L25:
            r10 = r19;
            goto L27
        L21:
            r9 = r18;
            goto L23
        L17:
            r8 = r17;
            goto L19
        L13:
            r7 = false;
            goto L15
        L9:
            r6 = r16;
            goto L11
        L5:
            r5 = r15;
            goto L7
        }
    }

    void a(String r1, Map<String, ? extends Object> r2, boolean r3, boolean r4, String r5, View r6, String r7, Integer r8, Integer r9);
}
