package com.ss.android.lark;

import android.content.Context;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatAppContainerV1;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import w4b.u;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/MessageTenantConfTask;", "Lcom/larksuite/framework/launch/task/AsyncLaunchTask;", "", "<init>", "()V", "execute", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageTenantConfTask extends AsyncLaunchTask<Object> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f408534a = null;

        static {
            f408534a = new a();
        }

        public a() {
        }
    }

    public MessageTenantConfTask() {
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        ChatAppContainerV1.f414510a.f0().jd(false);
        u r101 = ChatCoreModule.a().getLoginDependency();
        a r102 = a.f408534a;
        r101.b();
    }
}
