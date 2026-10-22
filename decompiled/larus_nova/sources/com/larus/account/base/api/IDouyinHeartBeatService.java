package com.larus.account.base.api;

import com.larus.account.base.model.GetOauthTokenTriggerScene;
import com.larus.login.impl.douyinconversationauth.DouyinConversationAuthServiceImpl$tryShow$1;
import com.larus.music.c0;
import kotlin.Metadata;
import n38.f;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J2\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\b\u0010\r\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"Lcom/larus/account/base/api/IDouyinHeartBeatService;", "", "isImplemented", "", "tryHeartBeatRequest", "", "delay", "", "immediate", "triggerScene", "Lcom/larus/account/base/model/GetOauthTokenTriggerScene;", "callback", "Lcom/larus/account/base/api/HeartBeatResultCallback;", "clearTokenCache", "hasActUpdateSuccess", "requestConversationAuthPopupEligibility", "updateScene", "Lcom/larus/account/base/api/ConversationAuthUpdateScene;", "Lcom/larus/account/base/api/ConversationAuthPopupEligibilityCallback;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDouyinHeartBeatService {

    public static final class a {
        public static /* synthetic */ void a(IDouyinHeartBeatService r100, long r101, boolean r102, GetOauthTokenTriggerScene r110, c0 r111, int r112) {
            if ((r112 & 1) == 0) goto L5;
            r101 = 0;
        L5:
            long r103 = r101;
            if ((r112 & 2) == 0) goto L8;
            boolean r104 = false;
        L10:
            if ((r112 & 4) == 0) goto L12;
            r110 = GetOauthTokenTriggerScene.Request;
        L12:
            GetOauthTokenTriggerScene r105 = r110;
            if ((r112 & 8) == 0) goto L15;
            r111 = null;
        L15:
            r100.e(r103, r104, r105, r111);
            return;
        L8:
            r104 = r102;
            goto L10
        }
    }

    void a();

    void b(ConversationAuthUpdateScene r100, DouyinConversationAuthServiceImpl$tryShow$1 r101);

    boolean c();

    void d();

    void e(long r100, boolean r101, GetOauthTokenTriggerScene r102, f r103);
}
