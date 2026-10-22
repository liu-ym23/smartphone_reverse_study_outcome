package com.ss.android.lark.chat.chatwindow.chat.v2.component.tab;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/ChatTabFragment;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/CommonTabDependency;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/TabLazyLoadFragment;", "<init>", "()V", "contentShowCallback", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/IChatTabPageSpec$ContentViewCreatedCallback;", "getContentShowCallback", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/IChatTabPageSpec$ContentViewCreatedCallback;", "setContentShowCallback", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/IChatTabPageSpec$ContentViewCreatedCallback;)V", "dependency", "getDependency", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/CommonTabDependency;", "setDependency", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/CommonTabDependency;)V", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/CommonTabDependency;", "chatId", "", "getChatId", "()Ljava/lang/String;", "setChatId", "(Ljava/lang/String;)V", "inputModeLifecycleHelper", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/util/InputModeLifecycleHelper;", "getInputModeLifecycleHelper", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/util/InputModeLifecycleHelper;", "inputModeLifecycleHelper$delegate", "Lkotlin/Lazy;", "onPageSelect", "", "onPageUnSelect", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ChatTabFragment<T> extends TabLazyLoadFragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f414349i;

    public ChatTabFragment() {
        this.f414349i = LazyKt.lazy(new ChatTabFragment$inputModeLifecycleHelper$2(this));
    }
}
