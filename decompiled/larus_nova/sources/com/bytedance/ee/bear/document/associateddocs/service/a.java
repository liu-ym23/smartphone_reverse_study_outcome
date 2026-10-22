package com.bytedance.ee.bear.document.associateddocs.service;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.ee.bear.document.associateddocs.AssociatedAppUrlListViewModel;
import com.ss.android.lark.export.e;
import com.ss.android.lark.export.entity.preview.Url;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UrlInlinePreviewEntity f219013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AssociatedPreviewService f219014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList<com.bytedance.ee.bear.document.associateddocs.view.a> f219015c;

    @Override // com.ss.android.lark.export.e.a
    public final void a(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        if (TextUtils.isEmpty(this.f219013a.getTitle()) == false) goto L9;
        Url r101 = this.f219013a.getUrl();
        if (r101 == null) goto L11;
        String r102 = r101.getUrl();
        if (r102 == null) goto L11;
    L12:
        String r103 = r102;
    L13:
        String r104 = this.f219013a.getPreviewId();
        Url r105 = this.f219013a.getUrl();
        if (r105 == null) goto L19;
        String r106 = r105.getUrl();
        if (r106 == null) goto L19;
        String r107 = r106;
    L20:
        String r108 = this.f219014b.f219012b.get(r104);
        if (r108 != null) goto L23;
        String r109 = "";
    L24:
        com.bytedance.ee.bear.document.associateddocs.view.a r110 = new com.bytedance.ee.bear.document.associateddocs.view.a(r104, r103, r107, r100, r109);
        this.f219015c.add(r110);
        AssociatedAppUrlListViewModel.a r111 = this.f219014b.f219011a;
        if (r111 == null) goto L28;
        r111.a(this.f219015c);
        return;
    L28:
        return;
    L23:
        r109 = r108;
    L19:
        r107 = "";
    L11:
        r103 = "";
        goto L13
    L9:
        r102 = this.f219013a.getTitle();
        if (r102 != null) goto L12;
        goto L11
    }

    public a(UrlInlinePreviewEntity r100, AssociatedPreviewService r101, ArrayList<com.bytedance.ee.bear.document.associateddocs.view.a> r102) {
        this.f219013a = r100;
        this.f219014b = r101;
        this.f219015c = r102;
    }
}
