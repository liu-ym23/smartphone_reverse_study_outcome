package com.bytedance.ee.bear.document.tips;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.notice.UDNotice;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class TipsWithConfirmView extends UDNotice {
    public static final /* synthetic */ int z = 0;
    public e0 y;

    public TipsWithConfirmView(Context r2) {
        this(r2, null);
    }

    private void setItemTips(f0 r1) {
        setText(r1.c);
    }

    public TipsWithConfirmView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o6(String r11, final tb5.m r12) {
        this.y = new e0(r11);
        int r13 = 0;
        setVisibility(0);
        e0 r0 = this.y;
        if (r0 != null) goto L6;
    L14:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).j0();
        jg5.k r14 = jg5.k.a.a;
        String r16 = com.bytedance.ee.bear.middleground.permission.c.a;
        JSONObject r17 = new JSONObject();
        String r1 = com.bytedance.ee.bear.middleground.permission.c.f;
        int r2 = com.bytedance.ee.bear.middleground.permission.c.g;
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L17;
        String r18 = "vc";
    L18:
        com.bytedance.ee.bear.middleground.permission.c.a(r17, r1, r2, r18, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_comment_without_permission_view", r17);
        return;
    L17:
        r18 = "none";
    L6:
        if (r13 >= ((ArrayList) r0.b).size()) goto L14;
        final f0 r3 = (f0) ListProtector.get(r0.b, r13);
        if (r13 != 1) goto L11;
        setItemTips(r3);
    L13:
        r13 = r13 + 1;
        goto L6
    L11:
        if (r13 != 2) goto L13;
        setTextButton(r3.c);
        setTextButtonListener(new h0(r12, r3));
        goto L13
    }

    public TipsWithConfirmView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.y = null;
        setTextButtonPosition(UDNotice.TextButtonPosition.AUTO);
    }
}
