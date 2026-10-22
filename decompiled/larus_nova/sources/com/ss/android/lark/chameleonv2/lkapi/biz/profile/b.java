package com.ss.android.lark.chameleonv2.lkapi.biz.profile;

import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.LKAPIError;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.profile.utils.IProfileLauncherV2;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;

/* JADX INFO: loaded from: classes35.dex */
public final class b<T> implements RxScheduledExecutor.Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Callback f411431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BizProfile.b f411432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IBizProfile$OpenProfileRequest f411433c;

    public b(Callback r100, BizProfile.b r101, IBizProfile$OpenProfileRequest r102) {
        this.f411431a = r100;
        this.f411432b = r101;
        this.f411433c = r102;
    }

    @Override // com.ss.android.lark.utils.rxjava.RxScheduledExecutor.Consumer
    public final void consume(Object r110) {
        Chatter r111 = (Chatter) r110;
        if (r111 != null) goto L6;
        this.f411431a.error(new LKAPIError(-1, "chatter is null"));
        j.b(this.f411432b.f411427a, "chatter is null");
        return;
    L6:
        if (r111.isBot() == false) goto L8;
        this.f411431a.error(new LKAPIError(-1, "chatter is bot"));
        j.b(this.f411432b.f411427a, "chatter is bot");
        return;
    L8:
        ContactSource r100 = new ContactSource();
        r100.setSourceType(4);
        IProfileLauncherV2.f438837a.getClass();
        IProfileLauncherV2.a.a(IProfileLauncherV2.Companion.a(), LarkContext.getApplication(), this.f411433c.getUserId(), null, r100, 186);
    }
}
