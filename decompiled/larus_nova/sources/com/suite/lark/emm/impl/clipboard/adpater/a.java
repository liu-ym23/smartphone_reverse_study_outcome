package com.suite.lark.emm.impl.clipboard.adpater;

import android.content.ClipData;
import coc.f;
import doc.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class a implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f460440b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SystemMethodGlobalImpl f460441a;

    static {
        f460440b = new a();
    }

    @Override // doc.b
    public final boolean E6() {
        return this.f460441a.E6();
    }

    @Override // doc.b
    public final void L3() {
        this.f460441a.L3();
    }

    @Override // doc.b
    public final ClipData Ma() {
        return this.f460441a.Ma();
    }

    @Override // doc.b
    public final void Sd() {
        this.f460441a.Sd();
    }

    @Override // doc.b
    public final int Ua() {
        return this.f460441a.Ua();
    }

    @Override // doc.b
    public final void Ze(ClipData r100) {
        Intrinsics.checkNotNullParameter(r100, "clipData");
        this.f460441a.Ze(r100);
    }

    @Override // doc.b
    public final void wa() {
        this.f460441a.wa();
    }

    @Override // doc.b
    public final int xb(ClipData r100) {
        return this.f460441a.xb(r100);
    }

    public a() {
        this.f460441a = new SystemMethodGlobalImpl();
    }

    public final boolean a(ClipData r100) {
        this.f460441a.getClass();
        if (r100 == null) goto L18;
        f.f24672a.f24669b.a();
        if (com.suite.lark.emm.impl.clipboard.utils.a.c(r100).length() <= 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
    L15:
        return true;
    L11:
        if (com.suite.lark.emm.impl.clipboard.utils.a.b(r100).length() <= 0) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == true) goto L15;
        return false;
    L13:
        r102 = false;
        goto L14
    L8:
        r101 = false;
        goto L9
    L18:
        return false;
    }

    public final boolean b(ClipData r100) {
        this.f460441a.getClass();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getItemCount() == 0) goto L39;
        int r101 = r100.getItemCount();
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L40;
        ClipData.Item r103 = r100.getItemAt(r102);
        CharSequence r104 = r103.getText();
        if (r104 != null) goto L12;
    L15:
        boolean r105 = true;
    L16:
        if (r105 == false) goto L31;
        String r106 = r103.getHtmlText();
        if (r106 != null) goto L20;
    L23:
        boolean r107 = true;
    L24:
        if (r107 == false) goto L31;
        if (r103.getIntent() != null) goto L31;
        if (r103.getUri() != null) goto L31;
        r102 = r102 + 1;
        goto L8
    L20:
        if (r106.length() == 0) goto L23;
        r107 = false;
    L31:
        return true;
    L12:
        if (r104.length() == 0) goto L15;
        r105 = false;
        goto L16
    L40:
        return false;
    L39:
        return false;
    }
}
