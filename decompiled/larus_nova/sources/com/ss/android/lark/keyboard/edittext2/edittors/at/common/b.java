package com.ss.android.lark.keyboard.edittext2.edittors.at.common;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.keyboard.edittext2.edittors.at.c;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.widget.richtext.RichTextElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class b implements c<hob.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<hob.c> f429042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.android.lark.keyboard.edittext2.base.b f429043b;

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void d() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final com.ss.android.lark.keyboard.edittext2.base.b getTarget() {
        com.ss.android.lark.keyboard.edittext2.base.b r100 = this.f429043b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(PickerReporterConstants.KEY.TARGET);
        return null;
    }

    public b() {
        this.f429042a = hob.c.class;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.c
    public Class<hob.c> getType() {
        return this.f429042a;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void A(com.ss.android.lark.keyboard.edittext2.base.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f429043b = r100;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void G(com.ss.android.lark.keyboard.edittext2.base.a r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.c
    public com.ss.android.lark.keyboard.edittext2.edittors.at.a<hob.c> c(com.ss.android.lark.keyboard.edittext2.edittors.a r100, hob.c r101) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        Intrinsics.checkNotNullParameter(r101, "data");
        return new InitCommonAtSpanHolder(r100, r101);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.c
    public fob.c.a<hob.c> k(com.ss.android.lark.keyboard.edittext2.edittors.a r100, RichTextElement.AtProperty r101) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        int r102 = hob.c.f486307k;
        return new fob.c.a(true, hob.c.a.a(r101));
    }
}
