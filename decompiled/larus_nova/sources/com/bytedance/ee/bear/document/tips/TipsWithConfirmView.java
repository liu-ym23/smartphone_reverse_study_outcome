package com.bytedance.ee.bear.document.tips;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.notice.UDNotice;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public class TipsWithConfirmView extends UDNotice {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f222051z = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public e0 f222052y;

    public TipsWithConfirmView(Context r100) {
        this(r100, null);
    }

    private void setItemTips(f0 r100) {
        setText(r100.f222090c);
    }

    public TipsWithConfirmView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void o6(String r110, final tb5.m r111) {
        this.f222052y = new e0(r110);
        int r112 = 0;
        setVisibility(0);
        e0 r100 = this.f222052y;
        if (r100 != null) goto L6;
    L14:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).j0();
        jg5.k r113 = jg5.k.a.f499019a;
        String r114 = com.bytedance.ee.bear.middleground.permission.c.f233147a;
        JSONObject r115 = new JSONObject();
        String r101 = com.bytedance.ee.bear.middleground.permission.c.f233152f;
        int r102 = com.bytedance.ee.bear.middleground.permission.c.f233153g;
        if (com.bytedance.ee.bear.middleground.permission.c.f233149c == false) goto L17;
        String r116 = ThumbGlideUrl.SOURCE_VC;
    L18:
        com.bytedance.ee.bear.middleground.permission.c.a(r115, r101, r102, r116, com.bytedance.ee.bear.middleground.permission.c.f233154h, com.bytedance.ee.bear.middleground.permission.c.f233150d, com.bytedance.ee.bear.middleground.permission.c.f233151e, com.bytedance.ee.bear.middleground.permission.c.f233147a, com.bytedance.ee.bear.middleground.permission.c.f233148b, com.bytedance.ee.bear.middleground.permission.c.f233155i);
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_comment_without_permission_view", r115);
        return;
    L17:
        r116 = "none";
    L6:
        if (r112 >= ((ArrayList) r100.f222087b).size()) goto L14;
        final f0 r103 = (f0) ListProtector.get(r100.f222087b, r112);
        if (r112 != 1) goto L11;
        setItemTips(r103);
    L13:
        r112 = r112 + 1;
        goto L6
    L11:
        if (r112 != 2) goto L13;
        setTextButton(r103.f222090c);
        setTextButtonListener(new h0(r111, r103));
        goto L13
    }

    public TipsWithConfirmView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f222052y = null;
        setTextButtonPosition(UDNotice.TextButtonPosition.AUTO);
    }
}
