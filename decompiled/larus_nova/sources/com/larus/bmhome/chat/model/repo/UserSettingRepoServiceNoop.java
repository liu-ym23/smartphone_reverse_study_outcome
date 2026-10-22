package com.larus.bmhome.chat.model.repo;

import hq9.y4;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0017\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0016J.\u0010\u0014\u001a\u0004\u0018\u00010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u001cJ\u001a\u0010\u001d\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\u0012\u0010\u001f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\u001a\u0010!\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\u0012\u0010#\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010$\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010%\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010&\u001a\u00020\u0007H\u0016J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u0007H\u0016J\b\u0010)\u001a\u00020\u0007H\u0016J\u0010\u0010*\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u000f\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010+J\n\u0010,\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00050\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00050\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/larus/bmhome/chat/model/repo/UserSettingRepoServiceNoop;", "Lcom/larus/bmhome/chat/model/repo/IUserSettingRepoService;", "<init>", "()V", "globalTtsSwitch", "", "mainBotUserChangedTtsSwitch", "", "globalUserChangedTtsSwitch", "isInCvsList", "Ljava/lang/Boolean;", "cvsId", "", "mainBotTtsSwitch", "", "botTtsSwitch", "ttsSet", "", "init", "", "requireAllUserConfig", "Lcom/larus/platform/model/UserConfigResponse;", "configTypes", "", "reason", "source", "(Ljava/util/List;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireUpdateDenoiseTrainAuthorizeUserConfig", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setMainBotTtsSwitch", "openTts", "getMainTtsSwitch", "setGlobalTtsSwitch", "setBotTtsSwitch", "getGlobalTtsSwitch", "getTtsSwitch", "hasSetTts", "setTts", "getMainBotUserChangedTtsSwitch", "setGlobalUserChangedTtsSwitch", "switch", "getGlobalUserChangedTtsSwitch", "saveIsInCvsList", "()Ljava/lang/Boolean;", "getCvsId", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserSettingRepoServiceNoop implements IUserSettingRepoService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f307763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Integer> f307764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Integer> f307765c;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final String Y1() {
        return null;
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final Boolean c() {
        return null;
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final Object e(List<Integer> r100, int r101, String r102, Continuation<? super y4> r103) {
        return null;
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final void init() {
    }

    public UserSettingRepoServiceNoop() {
        this.f307763a = -1;
        this.f307764b = new LinkedHashMap();
        this.f307765c = new LinkedHashMap();
        new LinkedHashSet();
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final int b() {
        return this.f307763a;
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final int a(String r100) {
        Integer r101 = (Integer) ((LinkedHashMap) this.f307764b).get(r100);
        if (r101 != null) goto L7;
        return -1;
    L7:
        return r101.intValue();
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final int d(String r100) {
        Integer r101 = (Integer) ((LinkedHashMap) this.f307765c).get(r100);
        if (r101 != null) goto L7;
        return -1;
    L7:
        return r101.intValue();
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final Object g(Continuation<? super Boolean> r100) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final void i(int r100) {
        this.f307763a = r100;
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final void f(String r100, int r101) {
        if (r100 == null) goto L5;
        Integer r102 = Integer.valueOf(r101);
        this.f307764b.put(r100, r102);
        return;
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final void h(String r100, int r101) {
        if (r100 == null) goto L5;
        Integer r102 = Integer.valueOf(r101);
        this.f307765c.put(r100, r102);
        return;
    }
}
