package com.ss.android.lark.chat.chatwindow.chat.v2.component.tab;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.ss.android.lark.chat.entity.chat.ChatTab;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/TabViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "chatTabListLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/ss/android/lark/chat/entity/chat/ChatTab;", "getChatTabListLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setChatTabListLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabViewModel extends ViewModel {
    private MutableLiveData<List<ChatTab>> chatTabListLiveData;

    public TabViewModel() {
        this.chatTabListLiveData = new MutableLiveData();
    }

    public final MutableLiveData<List<ChatTab>> getChatTabListLiveData() {
        return this.chatTabListLiveData;
    }

    public final void setChatTabListLiveData(MutableLiveData<List<ChatTab>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.chatTabListLiveData = r100;
    }
}
