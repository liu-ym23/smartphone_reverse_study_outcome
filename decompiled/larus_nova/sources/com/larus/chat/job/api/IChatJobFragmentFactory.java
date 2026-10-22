package com.larus.chat.job.api;

import android.os.Bundle;
import com.larus.chat.job.impl.page.ChatJobFragment;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016¨\u0006\r"}, d2 = {"Lcom/larus/chat/job/api/IChatJobFragmentFactory;", "", "create", "Landroidx/fragment/app/Fragment;", "arguments", "Landroid/os/Bundle;", "createEdit", "setEditorViewTasksMenuVisible", "", "visible", "", "addEditorRouterInterceptor", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IChatJobFragmentFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f324940a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f324941a = null;

        static {
            f324941a = new a();
        }

        public a() {
        }
    }

    static {
        f324940a = a.f324941a;
    }

    ChatJobFragment a(Bundle r100);

    void b();
}
