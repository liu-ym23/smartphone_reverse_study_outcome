package com.bytedance.ee.bear.drive.core.thumbnail;

import com.bumptech.glide.load.model.LazyHeaders;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.drive.loader.download.model.drive.DriveImagePreviewResponse;
import com.bytedance.ee.util.glide.BearGlideUrl;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements h75.c {
    public final /* synthetic */ DriveThumbnailImageProvider a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Ref.ObjectRef<h75.a> c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Function1<i, Unit> e;

    @Override // h75.c
    public final void a(DriveImagePreviewResponse r10) {
        Intrinsics.checkNotNullParameter(r10, "info");
        this.a.c(this.b, (h75.a) this.c.element);
        if (this.a.f == false) goto L5;
        return;
    L5:
        String r1 = null;
        if (StringsKt.isBlank(r10.getUrl()) == false) goto L9;
        tt5.a.k("DriveThumbnailImageProvider", "[thumbnail download] result=preview_url_empty token=" + this.d);
        this.e.invoke(null);
        return;
    L9:
        Function1<i, Unit> r0 = this.e;
        DriveThumbnailImageProvider r3 = this.a;
        String r11 = r10.getUrl();
        r3.getClass();
        LazyHeaders.Builder r4 = new LazyHeaders.Builder();
        Map<String, String> r5 = ((com.bytedance.ee.drive.preview.f) r3.b.getValue()).oc(r11);
        if (r5 == null) goto L19;
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L13:
        if (r6.hasNext() == false) goto L19;
        Map.Entry<String, String> r7 = r6.next();
        String r8 = r7.getKey();
        String r9 = r7.getValue();
        if ((!StringsKt.isBlank(r8)) == false) goto L13;
        if ((!StringsKt.isBlank(r9)) == false) goto L13;
        r4.setHeader(r8, r9);
    L19:
        String r12 = ((b0) r3.c.getValue()).getDeviceId();
        if (r12 != null) goto L22;
    L26:
        r0.invoke(new i.b(new BearGlideUrl(r11, r4.build()), DriveThumbnailRemoteSource.PREVIEW));
        return;
    L22:
        if ((!StringsKt.isBlank(r12)) == false) goto L24;
        r1 = r12;
    L24:
        if (r1 == null) goto L26;
        r4.setHeader("doc-device-id", r1);
        goto L26
    }

    @Override // h75.c
    public final void b(Throwable r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "e");
        Intrinsics.checkNotNullParameter(r4, "url");
        this.a.c(this.b, (h75.a) this.c.element);
        tt5.a.l("DriveThumbnailImageProvider", "[thumbnail download] result=preview_url_failed token=" + this.d, r3);
        if (this.a.f == true) goto L6;
        this.e.invoke(null);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(DriveThumbnailImageProvider r1, String r2, Ref.ObjectRef<h75.a> r3, String r4, Function1<? super i, Unit> r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
