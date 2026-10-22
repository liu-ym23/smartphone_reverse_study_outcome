package com.ss.android.lark.translate.service.impl;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.PushAutoTranslateScopeNotify;
import com.bytedance.lark.pb.im.v1.PushDisableAutoTranslateLanguagesNotice;
import com.bytedance.lark.pb.im.v1.PushImageTranslationInfo;
import com.bytedance.lark.pb.im.v1.PushLanguageAutoTranslateScopeNotify;
import com.bytedance.lark.pb.im.v1.PushLanguagesConfigurationNotice;
import com.bytedance.lark.pb.im.v1.PushLanguagesConfigurationNoticeV2;
import com.bytedance.lark.pb.im.v1.PushTranslateLanguageNotice;
import com.bytedance.lark.rustclient.api.t;
import com.ss.android.lark.chat.service.impl.y0;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.tencent.open.SocialConstants;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@UserScope
public final class o implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f444348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f444349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f444350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f444351d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CompositeDisposable f444352e;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.translate.service.impl.b
    public final void b() {
        Disposable r100 = this.f444351d;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Override // com.ss.android.lark.translate.service.impl.b
    public final void c() {
        CompositeDisposable r100 = this.f444352e;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Override // com.ss.android.lark.translate.service.impl.b
    public final void f() {
        Disposable r100 = this.f444350c;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Inject
    public o(String r100, com.bytedance.lark.rustclient.api.l r101) {
        Intrinsics.checkNotNullParameter(r100, "currentUserId");
        Intrinsics.checkNotNullParameter(r101, "userClient");
        this.f444348a = r100;
        this.f444349b = r101;
    }

    @Override // com.ss.android.lark.translate.service.impl.b
    public final void a(final l r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_RECEIVER);
        Intrinsics.checkNotNullParameter(r101, LynxVideoManagerLite.EVENT_ON_ERROR);
        CompositeDisposable r102 = new CompositeDisposable();
        r102.add(t.g(this.f444349b.i(Command.PUSH_TRANSLATE_LANGUAGES_SETTING, PushTranslateLanguageNotice.ADAPTER), new TranslatePushRepositoryV2$subscribeTranslateSettingPush$1$1(r100), r101));
        r102.add(t.g(this.f444349b.i(Command.PUSH_DISABLE_AUTO_TRANSLATE_LANGUAGE_NOTICE, PushDisableAutoTranslateLanguagesNotice.ADAPTER), new TranslatePushRepositoryV2$subscribeTranslateSettingPush$1$2(r100), r101));
        r102.add(t.g(this.f444349b.i(Command.PUSH_LANGUAGES_CONFIGURATION_NOTICE, PushLanguagesConfigurationNotice.ADAPTER), new TranslatePushRepositoryV2$subscribeTranslateSettingPush$1$3(r100), r101));
        r102.add(t.g(this.f444349b.i(Command.PUSH_AUTO_TRANSLATE_SCOPE_NOTICE, PushAutoTranslateScopeNotify.ADAPTER), new TranslatePushRepositoryV2$subscribeTranslateSettingPush$1$4(r100), r101));
        r102.add(t.g(this.f444349b.i(Command.PUSH_LANGUAGES_CONFIGURATION_NOTICE_V2, PushLanguagesConfigurationNoticeV2.ADAPTER), new TranslatePushRepositoryV2$subscribeTranslateSettingPush$1$5(r100), r101));
        r102.add(t.g(this.f444349b.i(Command.PUSH_LANGUAGE_AUTO_TRANSLATE_SCOPE, PushLanguageAutoTranslateScopeNotify.ADAPTER), new TranslatePushRepositoryV2$subscribeTranslateSettingPush$1$6(r100), r101));
        this.f444352e = r102;
    }

    @Override // com.ss.android.lark.translate.service.impl.b
    public final void d(final j r100, final f r101) {
        Intrinsics.checkNotNullParameter(r100, "onReceive");
        Intrinsics.checkNotNullParameter(r101, LynxVideoManagerLite.EVENT_ON_ERROR);
        this.f444350c = y0.a("TranslatePushRepositoryV2", this.f444348a, new TranslatePushRepositoryV2$subscribeTranslateStatesPush$1(this, r100, r101));
    }

    @Override // com.ss.android.lark.translate.service.impl.b
    public final void e(k r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "onReceive");
        Intrinsics.checkNotNullParameter(r101, LynxVideoManagerLite.EVENT_ON_ERROR);
        this.f444351d = t.g(this.f444349b.i(Command.PUSH_IMAGE_TRANSLATION_INFO, PushImageTranslationInfo.ADAPTER), r100, r101);
    }
}
