package com.ss.android.lark.chat.component;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.chat.chatwindow.biz.component.ChatBaseComponent;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/chat/component/ChatInitErrorComponent;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/ChatBaseComponent;", "chatId", "", "initErrorInfo", "Landroidx/lifecycle/LiveData;", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "<init>", "(Ljava/lang/String;Landroidx/lifecycle/LiveData;)V", "hasView", "", WidgetCostModule.TYPE_ON_CREATE, "", "showOpenChatError", "errorResult", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatInitErrorComponent extends ChatBaseComponent {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f414704n = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f414705l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LiveData<ErrorResult> f414706m;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatInitErrorComponent f414707a;

        public b(ChatInitErrorComponent r100) {
            this.f414707a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            final ErrorResult r101 = (ErrorResult) r100;
            if (r101 == null) goto L11;
            final ChatInitErrorComponent r102 = this.f414707a;
            int r103 = ChatInitErrorComponent.f414704n;
            r102.getClass();
            Function0<Unit> r104 = new ChatInitErrorComponent$showOpenChatError$1(r102, r101);
            Intrinsics.checkNotNullParameter(r104, "block");
            if (r102.f425738c == false) goto L12;
            Thread r105 = ThreadMethodProxy.currentThread();
            Intrinsics.checkNotNullParameter(r105, "<this>");
            if (Intrinsics.areEqual(r105, ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == false) goto L9;
            r104.invoke();
            return;
        L9:
            com.ss.android.lark.framework.larkwidget.a r106 = new com.ss.android.lark.framework.larkwidget.a(r102, r104);
            Intrinsics.checkNotNullParameter(r106, "runnable");
            ((Handler) r102.f425737b.getValue()).post(r106);
            return;
        L12:
            return;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.framework.larkwidget.Widget
    public final boolean v0() {
        return false;
    }

    @Override // com.ss.android.lark.framework.larkwidget.Widget
    public final void onCreate() {
        super.onCreate();
        this.f414706m.observe(this, new b(this));
    }

    public ChatInitErrorComponent(String r100, MutableLiveData r101) {
        Intrinsics.checkNotNullParameter(r101, "initErrorInfo");
        this.f414705l = r100;
        this.f414706m = r101;
    }
}
