package zh8;

import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.chat.model.repo.IUserSettingRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IChatRepoService f572196a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IConversationRepoService f572197b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ISettingRepoService f572198c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final IUserSettingRepoService f572199d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final IBotRepoService f572200e = null;

    static {
        RepoDispatcherDelegate r100 = RepoDispatcherDelegate.f307737b;
        f572196a = r100.e();
        f572197b = r100.f();
        f572198c = r100.c();
        f572199d = r100.h();
        f572200e = r100.b();
    }

    public static ExecutorCoroutineDispatcher a() {
        return RepoDispatcherDelegate.f307737b.g();
    }
}
