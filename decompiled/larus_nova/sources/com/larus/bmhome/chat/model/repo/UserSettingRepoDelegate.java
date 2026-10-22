package com.larus.bmhome.chat.model.repo;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.y4;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0001J\t\u0010\n\u001a\u00020\tH\u0096\u0001J\u0013\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\u0013\u0010\r\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\u0013\u0010\u000e\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0096\u0001¢\u0006\u0002\u0010\u0012J.\u0010\u0013\u001a\u0004\u0018\u00010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0005H\u0096A¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\tH\u0096A¢\u0006\u0002\u0010\u001bJ\u0011\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0096\u0001J\u001b\u0010\u001d\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\tH\u0096\u0001J\u001b\u0010\"\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u0007H\u0096\u0001J\u0013\u0010#\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¨\u0006$"}, d2 = {"Lcom/larus/bmhome/chat/model/repo/UserSettingRepoDelegate;", "Lcom/larus/bmhome/chat/model/repo/IUserSettingRepoService;", "<init>", "()V", "getCvsId", "", "getGlobalTtsSwitch", "", "getGlobalUserChangedTtsSwitch", "", "getMainBotUserChangedTtsSwitch", "getMainTtsSwitch", "cvsId", "getTtsSwitch", "hasSetTts", "init", "", "isInCvsList", "()Ljava/lang/Boolean;", "requireAllUserConfig", "Lcom/larus/platform/model/UserConfigResponse;", "configTypes", "", "reason", "source", "(Ljava/util/List;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireUpdateDenoiseTrainAuthorizeUserConfig", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveIsInCvsList", "setBotTtsSwitch", "openTts", "setGlobalTtsSwitch", "setGlobalUserChangedTtsSwitch", "switch", "setMainBotTtsSwitch", "setTts", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserSettingRepoDelegate implements IUserSettingRepoService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final UserSettingRepoDelegate f307761b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IUserSettingRepoService f307762a;

    static {
        f307761b = new UserSettingRepoDelegate();
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final String Y1() {
        return this.f307762a.Y1();
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final int a(String r100) {
        return this.f307762a.a(r100);
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final int b() {
        return this.f307762a.b();
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final Boolean c() {
        return this.f307762a.c();
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final int d(String r100) {
        return this.f307762a.d(r100);
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final Object e(List<Integer> r100, int r101, String r102, Continuation<? super y4> r103) {
        return this.f307762a.e(r100, r101, r102, r103);
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final void f(String r100, int r101) {
        this.f307762a.f(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final Object g(Continuation<? super Boolean> r100) {
        return this.f307762a.g(r100);
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final void h(String r100, int r101) {
        this.f307762a.h(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final void i(int r100) {
        this.f307762a.i(r100);
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final void init() {
        this.f307762a.init();
    }

    private UserSettingRepoDelegate() {
        IUserSettingRepoService r100 = (IUserSettingRepoService) ServiceManager.get().getService(IUserSettingRepoService.class);
        if (r100 != null) goto L5;
        r100 = new UserSettingRepoServiceNoop();
    L5:
        this.f307762a = r100;
    }
}
