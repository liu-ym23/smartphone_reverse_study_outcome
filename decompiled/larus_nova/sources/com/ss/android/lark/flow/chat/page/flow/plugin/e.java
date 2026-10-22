package com.ss.android.lark.flow.chat.page.flow.plugin;

import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.log.Log;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f422776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IMessageListComponent f422777b;

    public e(int r100, IMessageListComponent r101) {
        this.f422776a = r100;
        this.f422777b = r101;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        Log.i("FlowChatReadablePlugin", "update message readable is true, chat readable is " + this.f422776a);
        IMessageListComponent r100 = this.f422777b;
        if (r100 == null) goto L6;
        r100.z6(true);
    L6:
        return Unit.INSTANCE;
    }
}
