package com.larus.bmhome.chat.model.repo;

import hq9.y4;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J.\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u000fJ\u001a\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\bH&J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\bH&J\u001a\u0010\u0015\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\bH&J\b\u0010\u0016\u001a\u00020\bH&J\u0012\u0010\u0017\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\u001a\u001a\u00020\u000eH&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u000eH&J\b\u0010\u001d\u001a\u00020\u000eH&J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u000eH&J\u000f\u0010\u001f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0002\u0010 J\n\u0010!\u001a\u0004\u0018\u00010\u000bH&¨\u0006\""}, d2 = {"Lcom/larus/bmhome/chat/model/repo/IUserSettingRepoService;", "", "init", "", "requireAllUserConfig", "Lcom/larus/platform/model/UserConfigResponse;", "configTypes", "", "", "reason", "source", "", "(Ljava/util/List;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireUpdateDenoiseTrainAuthorizeUserConfig", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setMainBotTtsSwitch", "cvsId", "openTts", "getMainTtsSwitch", "setGlobalTtsSwitch", "setBotTtsSwitch", "getGlobalTtsSwitch", "getTtsSwitch", "hasSetTts", "setTts", "getMainBotUserChangedTtsSwitch", "setGlobalUserChangedTtsSwitch", "switch", "getGlobalUserChangedTtsSwitch", "saveIsInCvsList", "isInCvsList", "()Ljava/lang/Boolean;", "getCvsId", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IUserSettingRepoService {
    String Y1();

    int a(String r100);

    int b();

    Boolean c();

    int d(String r100);

    Object e(List<Integer> r100, int r101, String r102, Continuation<? super y4> r103);

    void f(String r100, int r101);

    Object g(Continuation<? super Boolean> r100);

    void h(String r100, int r101);

    void i(int r100);

    void init();
}
