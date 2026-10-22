package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.chat.api.service.request.PullUrlPreviewRequest;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.ss.android.lark.chat.preview.entity.UrlPreviewResponse;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c1 extends c0c.b implements a2b.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a2b.f f411576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.internal.v f411577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<a2b.f> f411578d;

    public static final class a {
    }

    static {
    }

    @Override // a2b.f
    public final void Fa(PullUrlPreviewRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        this.f411576b.Fa(r100);
    }

    @Override // a2b.f
    public final void ba(a2b.b r100, IGetDataCallback<a2b.b> r101) {
        Intrinsics.checkNotNullParameter(r100, "urlPreview");
        Intrinsics.checkNotNullParameter(r101, "uiCallback");
        this.f411576b.ba(r100, r101);
    }

    @Override // a2b.f
    public final void getUrlInlineFromContent(String r100, IGetDataCallback<UrlInlinePreviewEntity> r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f411576b.getUrlInlineFromContent(r100, r101);
    }

    @Override // a2b.f
    public final void lc(List<String> r100, Map<String, ? extends Map<String, UrlCardPreviewEntity>> r101) {
        Intrinsics.checkNotNullParameter(r100, "templateIdList");
        Intrinsics.checkNotNullParameter(r101, "messagePreviewMap");
        this.f411576b.lc(r100, r101);
    }

    @Override // a2b.f
    public final void r4(List<String> r100, List<String> r110, SyncDataStrategy r111, UrlPreViewEntries.UrlPreViewSourceType r112, List<Long> r113, UIGetDataCallback<UrlPreviewResponse> r114) {
        Intrinsics.checkNotNullParameter(r100, "sourceIdList");
        Intrinsics.checkNotNullParameter(r110, "sourceTextMD5List");
        Intrinsics.checkNotNullParameter(r111, "syncDataStrategy");
        Intrinsics.checkNotNullParameter(r112, "sourceType");
        Intrinsics.checkNotNullParameter(r114, "callback");
        this.f411576b.r4(r100, r110, r111, r112, r113, r114);
    }

    public c1(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<a2b.f> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), a2b.f.class), a2b.f.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f411576b = r103.b();
        this.f411577c = r101;
        this.f411578d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        Log.i("PreviewServiceProxy", "preparing IPreviewService");
        com.ss.android.lark.passportc.internal.v r102 = this.f411577c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        a2b.f r104 = (a2b.f) e0c.k.b(r102.c(r103), a2b.f.class);
        this.f411578d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
