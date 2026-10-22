package com.bytedance.ee.bear.document.associateddocs.service;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.ee.bear.document.associateddocs.AssociatedAppUrlListViewModel;
import com.ss.android.lark.export.e;
import com.ss.android.lark.export.entity.preview.Url;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements e.a {
    public final /* synthetic */ UrlInlinePreviewEntity a;
    public final /* synthetic */ AssociatedPreviewService b;
    public final /* synthetic */ ArrayList<com.bytedance.ee.bear.document.associateddocs.view.a> c;

    public final void a(Drawable r9) {
        Intrinsics.checkNotNullParameter(r9, "drawable");
        if (TextUtils.isEmpty(this.a.getTitle()) == false) goto L9;
        Url r0 = this.a.getUrl();
        if (r0 == null) goto L11;
        String r1 = r0.getUrl();
        if (r1 == null) goto L11;
    L12:
        String r4 = r1;
    L13:
        String r3 = this.a.getPreviewId();
        Url r2 = this.a.getUrl();
        if (r2 == null) goto L19;
        String r5 = r2.getUrl();
        if (r5 == null) goto L19;
        String r6 = r5;
    L20:
        String r7 = this.b.b.get(r3);
        if (r7 != null) goto L23;
        String r8 = "";
    L24:
        com.bytedance.ee.bear.document.associateddocs.view.a r10 = new com.bytedance.ee.bear.document.associateddocs.view.a(r3, r4, r6, r9, r8);
        this.c.add(r10);
        AssociatedAppUrlListViewModel.a r11 = this.b.a;
        if (r11 == null) goto L28;
        r11.a(this.c);
        return;
    L28:
        return;
    L23:
        r8 = r7;
    L19:
        r6 = "";
    L11:
        r4 = "";
        goto L13
    L9:
        r1 = this.a.getTitle();
        if (r1 != null) goto L12;
        goto L11
    }

    public a(UrlInlinePreviewEntity r1, AssociatedPreviewService r2, ArrayList<com.bytedance.ee.bear.document.associateddocs.view.a> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
