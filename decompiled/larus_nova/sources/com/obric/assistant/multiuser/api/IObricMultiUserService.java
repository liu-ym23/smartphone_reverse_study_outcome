package com.obric.assistant.multiuser.api;

import android.os.UserHandle;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/obric/assistant/multiuser/api/IObricMultiUserService;", "", "isMainUser", "", "myUserId", "", "myUserHandle", "Landroid/os/UserHandle;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricMultiUserService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f390298a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f390299a = null;

        static {
            f390299a = new a();
        }

        public a() {
        }

        public static IObricMultiUserService a() {
            return (IObricMultiUserService) ServiceManager.get().getService(IObricMultiUserService.class);
        }
    }

    static {
        f390298a = a.f390299a;
    }

    boolean a();

    UserHandle b();

    int c();
}
