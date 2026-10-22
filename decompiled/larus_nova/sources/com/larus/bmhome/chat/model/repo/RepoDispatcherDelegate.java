package com.larus.bmhome.chat.model.repo;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0001J\t\u0010\n\u001a\u00020\u000bH\u0096\u0001JC\u0010\f\u001a\u0002H\r\"\n\b\u0000\u0010\r*\u0004\u0018\u00010\u000e2'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0010¢\u0006\u0002\b\u0013H\u0096A¢\u0006\u0002\u0010\u0014J\u0090\u0001\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u001cj\b\u0012\u0004\u0012\u00020\u0018`\u001d2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u00182\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010#2\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u00010%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t0'H\u0096A¢\u0006\u0002\u0010(J\t\u0010)\u001a\u00020*H\u0096\u0001J\t\u0010+\u001a\u00020,H\u0096\u0001J8\u0010-\u001a\u0002H.\"\n\b\u0000\u0010.*\u0004\u0018\u00010\u000e2\u001c\u0010\u000f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H.0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e0'H\u0096A¢\u0006\u0002\u0010/R\u0012\u00100\u001a\u000201X\u0096\u0005¢\u0006\u0006\u001a\u0004\b2\u00103¨\u00064"}, d2 = {"Lcom/larus/bmhome/chat/model/repo/RepoDispatcherDelegate;", "Lcom/larus/bmhome/chat/model/repo/IRepoDispatcherService;", "<init>", "()V", "botRepo", "Lcom/larus/bmhome/chat/model/repo/IBotRepoService;", "chatRepo", "Lcom/larus/bmhome/chat/model/repo/IChatRepoService;", "clearAllRepo", "", "conversationRepo", "Lcom/larus/bmhome/chat/model/repo/IConversationRepoService;", "dispatch", ExifInterface.GPS_DIRECTION_TRUE, "", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireTipOff", "", "reportType", "", "entityId", "", "reasonIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reasonDetail", "serverIndex", "conversationId", "reportSource", "batchIds", "", "extra", "", "callback", "Lkotlin/Function1;", "(ILjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "settingRepo", "Lcom/larus/bmhome/chat/model/repo/ISettingRepoService;", "userSettingRepo", "Lcom/larus/bmhome/chat/model/repo/IUserSettingRepoService;", "withTransaction", "R", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "messageDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "getMessageDispatcher", "()Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RepoDispatcherDelegate implements IRepoDispatcherService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final RepoDispatcherDelegate f307737b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IRepoDispatcherService f307738a;

    static {
        f307737b = new RepoDispatcherDelegate();
    }

    @Override // com.larus.bmhome.chat.model.repo.IRepoDispatcherService
    public final Object a(int r110, String r111, ArrayList<Integer> r112, String r113, String r114, String r115, int r210, List<String> r211, Map<String, String> r212, Function1<? super Integer, Unit> r213, Continuation<? super Boolean> r214) {
        return this.f307738a.a(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    @Override // com.larus.bmhome.chat.model.repo.IRepoDispatcherService
    public final IBotRepoService b() {
        return this.f307738a.b();
    }

    @Override // com.larus.bmhome.chat.model.repo.IRepoDispatcherService
    public final ISettingRepoService c() {
        return this.f307738a.c();
    }

    @Override // com.larus.bmhome.chat.model.repo.IRepoDispatcherService
    public final <T> Object d(Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r100, Continuation<? super T> r101) {
        return this.f307738a.d(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.IRepoDispatcherService
    public final IChatRepoService e() {
        return this.f307738a.e();
    }

    @Override // com.larus.bmhome.chat.model.repo.IRepoDispatcherService
    public final IConversationRepoService f() {
        return this.f307738a.f();
    }

    @Override // com.larus.bmhome.chat.model.repo.IRepoDispatcherService
    public final ExecutorCoroutineDispatcher g() {
        return this.f307738a.g();
    }

    @Override // com.larus.bmhome.chat.model.repo.IRepoDispatcherService
    public final IUserSettingRepoService h() {
        return this.f307738a.h();
    }

    private RepoDispatcherDelegate() {
        IRepoDispatcherService r100 = (IRepoDispatcherService) ServiceManager.get().getService(IRepoDispatcherService.class);
        if (r100 != null) goto L5;
        r100 = new RepoDispatcherServiceNoop();
    L5:
        this.f307738a = r100;
    }
}
