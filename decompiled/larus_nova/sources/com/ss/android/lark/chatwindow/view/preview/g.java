package com.ss.android.lark.chatwindow.view.preview;

import b3b.t;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class g implements vcb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h2b.c f417066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UrlPreviewBinder f417067b;

    public g(h2b.c r100, UrlPreviewBinder r101) {
        this.f417066a = r100;
        this.f417067b = r101;
    }

    @Override // vcb.a
    public final void a(String r100, String r101) {
        if (this.f417066a == null) goto L31;
        if (r101 != null) goto L6;
    L9:
        boolean r102 = true;
    L10:
        if (r102 == true) goto L31;
        Map<String, PreviewHangPoint> r103 = this.f417066a.f483636a;
        if (r103 == null) goto L21;
        Collection<PreviewHangPoint> r104 = r103.values();
        if (r104 == null) goto L21;
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L17:
        if (r106.hasNext() == false) goto L22;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((PreviewHangPoint) r107).getPreviewId(), r100) == false) goto L17;
        r105.add(r107);
    L22:
        if (r105 == null) goto L31;
        Iterator r108 = r105.iterator();
    L25:
        if (r108.hasNext() == false) goto L31;
        UrlCardPreviewEntity r109 = ((PreviewHangPoint) r108.next()).getUrlCardPreviewEntity();
        if (r109 == null) goto L25;
        UrlPreviewBody r110 = r109.getPreviewBody();
        if (r110 == null) goto L25;
        r110.setCurrentStateId(r101);
    L21:
        r105 = null;
        goto L22
    L6:
        if (r101.length() == 0) goto L9;
        r102 = false;
    L31:
        UrlPreviewBinder r111 = this.f417067b;
        t r112 = r111.f417001e;
        if (r112 == null) goto L47;
        r112.E(r111.f416999c.getMessageId());
        return;
    }
}
