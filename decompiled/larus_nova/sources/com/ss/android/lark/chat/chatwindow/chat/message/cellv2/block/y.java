package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.utils.f1;
import com.ss.android.lark.dto.chat.ProfileSource;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class y implements f1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MessageDingDescBlock f413296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y6b.a<?> f413297b;

    /* JADX WARN: Type inference failed for: r0v1, types: [v5b.a] */
    @Override // com.ss.android.lark.chat.utils.f1.a
    public final void o1() {
        ArrayList<String> r100 = h7b.l.a(this.f413297b.b());
        ChatCoreModule.a().openReadStateDetailPage(this.f413296a.getContext(), this.f413297b.getChatId(), this.f413297b.getType(), this.f413297b.getId(), r100, true);
    }

    @Override // com.ss.android.lark.chat.utils.f1.a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        w4b.b0 r101 = ChatCoreModule.a().getProfileDependency();
        Context r102 = this.f413296a.getContext();
        ProfileSource.a r103 = new ProfileSource.a();
        r103.f420573e = r100;
        r103.f420570b = 2;
        r103.f420571c = com.ss.android.lark.chat.utils.k.a(this.f413296a.f412673c.getChat());
        r101.e(r102, r103.a());
    }

    public y(MessageDingDescBlock r100, y6b.a<?> r101) {
        this.f413296a = r100;
        this.f413297b = r101;
    }
}
