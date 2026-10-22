package com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboardtop;

import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboardtop.BaseKeyboardTopExtendComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/keyboardtop/KeyboardTopExtendComponent;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboardtop/BaseKeyboardTopExtendComponent;", "<init>", "()V", WidgetCostModule.TYPE_ON_CREATE, "", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardTopExtendComponent extends BaseKeyboardTopExtendComponent {
    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardtop.BaseKeyboardTopExtendComponent, com.ss.android.lark.framework.larkwidget.Widget
    public final void onCreate() {
        super.onCreate();
        Log.i(TitlebarViewModel.LOG_TAG, "launch in chat keyboard top component");
    }

    public KeyboardTopExtendComponent() {
    }
}
