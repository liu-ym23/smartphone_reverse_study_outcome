package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.MessageSource;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.basic.v1.TranslateUrlPreviewContext;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.api.service.ITranslateService;
import com.ss.android.lark.chat.entity.translate.TranslateLanguageSetting;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class g2 extends c0c.b implements ITranslateService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ITranslateService f411595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.internal.v f411596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<ITranslateService> f411597d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.chat.api.service.ITranslateService
    public final void L4(String r100, IGetDataCallback<Boolean> r101) {
        this.f411595b.L4(r100, r101);
    }

    @Override // com.ss.android.lark.chat.api.service.ITranslateService
    public final void W4(boolean r100, Map<String, TranslateUrlPreviewContext> r101, Map<String, Map<String, PreviewHangPoint>> r102, IGetDataCallback<Map<String, Map<String, PreviewHangPoint>>> r103) {
        this.f411595b.W4(r100, r101, r102, r103);
    }

    @Override // com.ss.android.lark.chat.api.service.ITranslateService
    public final void cb(boolean r100, IGetDataCallback<Boolean> r101) {
        this.f411595b.cb(r100, r101);
    }

    @Override // com.ss.android.lark.chat.api.service.ITranslateService
    public final void jf(List<String> r110, ITranslateService.TranslateTriggerType r111, String r112, List<MessageSource> r113, String r114, Map<String, Integer> r115, boolean r116, IGetDataCallback<fcb.a> r117) {
        this.f411595b.jf(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    @Override // com.ss.android.lark.chat.api.service.ITranslateService
    public final void s9(SyncDataStrategy r100, IGetDataCallback<TranslateLanguageSetting> r101) {
        this.f411595b.s9(r100, r101);
    }

    @Override // com.ss.android.lark.chat.api.service.ITranslateService
    public final void getTranslateLanguages(IGetDataCallback r100) {
        s9(SyncDataStrategy.FORCE_SERVER, r100);
    }

    public g2(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<ITranslateService> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), ITranslateService.class), ITranslateService.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f411595b = r103.b();
        this.f411596c = r101;
        this.f411597d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        Log.i("TranslateServiceProxy", "preparing ITranslateService");
        com.ss.android.lark.passportc.internal.v r102 = this.f411596c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        ITranslateService r104 = (ITranslateService) e0c.k.b(r102.c(r103), ITranslateService.class);
        this.f411597d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
