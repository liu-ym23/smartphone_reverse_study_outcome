package e4b;

import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.select.MessageListMultiSelectFeature$initMultiSelector$multiSelector$1;
import com.ss.android.lark.widget.recyclerview.MultiSelector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements MultiSelector.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f471034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MessageListMultiSelectFeature$initMultiSelector$multiSelector$1 f471035b;

    @Override // com.ss.android.lark.widget.recyclerview.MultiSelector.a
    public final void onStatusChanged(boolean r100) {
    }

    @Override // com.ss.android.lark.widget.recyclerview.MultiSelector.a
    public final void a() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r100 = this.f471034a.f471028a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r100 = null;
    L5:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r101 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a) r100.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a.class);
        if (r101 == null) goto L9;
        r101.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.c0(this.f471035b.f448173b.size()));
        return;
    }

    public c(b r100, MessageListMultiSelectFeature$initMultiSelector$multiSelector$1 r101) {
        this.f471034a = r100;
        this.f471035b = r101;
    }
}
