package com.larus.login.api;

import com.amap.api.services.district.DistrictSearchQuery;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.larus.login.impl.impl.AccountTrace;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b'\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u001f\u0010\n\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH&¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J5\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\fH&¢\u0006\u0002\u0010\u0015JE\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\fH&¢\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\fH&J\u001a\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\fH&J\b\u0010\u001e\u001a\u00020\u0003H&JD\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\fH&J\u0018\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\fH&Jn\u0010)\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010,\u001a\u00020\fH&J\b\u0010-\u001a\u00020\u0003H&J,\u0010.\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010*\u001a\u0004\u0018\u00010\f2\u0006\u0010/\u001a\u00020\fH&J\b\u00100\u001a\u00020\u0003H&J\b\u00101\u001a\u00020\u0003H&J\u0018\u00102\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\f2\u0006\u00103\u001a\u000204H&J\u0018\u00105\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\f2\u0006\u00103\u001a\u000204H&J\b\u00106\u001a\u00020\u0003H&J\u0010\u00107\u001a\u00020\u00032\u0006\u00103\u001a\u000204H&J)\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u0001042\b\u0010:\u001a\u0004\u0018\u00010\fH&¢\u0006\u0002\u0010;J\u001f\u0010<\u001a\u00020\u00032\u0006\u00109\u001a\u00020\f2\b\u0010=\u001a\u0004\u0018\u000104H&¢\u0006\u0002\u0010>J\u0010\u0010?\u001a\u00020\u00032\u0006\u00109\u001a\u00020\fH&J*\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\f2\u0006\u0010B\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\b\b\u0002\u0010#\u001a\u00020\fH&J2\u0010C\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\u0006\u0010D\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\b\b\u0002\u0010#\u001a\u00020\fH&J \u0010E\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\fH&J \u0010G\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\fH&J(\u0010H\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\f2\u0006\u0010I\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\fH&JA\u0010J\u001a\u00020\u00032\u0006\u0010K\u001a\u00020L2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010M\u001a\u00020\f2\u0006\u0010/\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\u0010*\u001a\u0004\u0018\u00010\fH&¢\u0006\u0002\u0010NJ\n\u0010O\u001a\u0004\u0018\u00010PH&¨\u0006Q"}, d2 = {"Lcom/larus/login/api/IAccountTrackApi;", "", "clickLoginHomeProtocol", "", "clickLoginHomePrivacy", "clickPhoneLoginBack", "clickPhoneLoginSkip", "clickPhoneLoginRegion", "code", "", "phoneLoginRegionResult", DistrictSearchQuery.KEYWORDS_COUNTRY, "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "clickVerifyCodeBack", "clickVerifyCodeResend", "loginSendCodeResult", "success", "resend", "errorCode", "errorMessage", "(IILjava/lang/Integer;Ljava/lang/String;)V", "loginSendVoiceCodeResult", "originErrorCode", "originErrorMsg", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "privacyWindowShow", "actionTimestamp", "privacyWindowClick", "status", "privacyAcceptException", "clickLogin", "loginType", "position", "currentPage", "previousPage", "enterMethod", "clickFrom", "triggerAppId", "loginRequest", "type", "loginResult", "errorMsg", "originErrorMessage", "accountType", "clickSettingLogout", "logoutResult", "scene", "clickLogoutConfirm", "clickLogoutCancel", "thirdLoginSuccessTime", "duration", "", "thirdLoginInitTime", "startFillVerifyCode", "fillVerifyCodeTime", "reportAppealResult", "secUserId", "tips", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "reportRiskLogout", "statusCode", "(Ljava/lang/String;Ljava/lang/Long;)V", "reportAppealPopupShow", "showModule", TextureRenderKeys.KEY_MODULE_NAME, "showFrom", "clickModule", "clickResult", "showButton", "buttonName", "clickButton", "userLoginAction", "pageStep", "onLogoutResult", "isForce", "", "platform", "(ZILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getLoginInfo", "Lorg/json/JSONObject;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAccountTrackApi {

    public static final class a {
        public static /* synthetic */ void d(AccountTrackService r100, int r101) {
            r100.o(1, r101, null, null);
        }

        public static /* synthetic */ void e(IAccountTrackApi r100, String r101, String r102) {
            r100.j(r101, r102, "landing");
        }

        public static /* synthetic */ void b(IAccountTrackApi r100, String r101, String r102, String r103) {
            r100.m(r101, r102, r103, "landing");
        }

        public static /* synthetic */ void a(AccountTrace r100, String r101, int r110, String r111, String r112, String r113, String r114) {
            r100.r(r101, r110, r111, r112, r113, r114, null);
        }

        public static /* synthetic */ void c(IAccountTrackApi r110, String r111, int r112, String r113, String r114, String r115, String r210, String r211, String r212, String r213, String r214, int r215) {
            if ((r215 & 16) == 0) goto L5;
            String r100 = null;
        L7:
            if ((r215 & 32) == 0) goto L9;
            String r101 = null;
        L11:
            if ((r215 & 64) == 0) goto L13;
            String r116 = null;
        L15:
            if ((r215 & 128) == 0) goto L17;
            String r117 = null;
        L19:
            if ((r215 & 256) == 0) goto L21;
            String r118 = null;
        L23:
            if ((r215 & 512) == 0) goto L25;
            String r119 = WikiSpaceType.PERSONAL;
        L26:
            r110.k(r111, r112, r113, r114, r100, r101, r116, r117, r118, r119);
            return;
        L25:
            r119 = r214;
            goto L26
        L21:
            r118 = r213;
            goto L23
        L17:
            r117 = r212;
            goto L19
        L13:
            r116 = r211;
            goto L15
        L9:
            r101 = r210;
            goto L11
        L5:
            r100 = r115;
            goto L7
        }
    }

    void a(String r100, long r101);

    void b(String r100, Long r101);

    void c(String r100, String r101);

    void d(String r100, String r101, String r102, String r103);

    void e();

    void f(int r100, String r101);

    void g(boolean r100, int r101, String r102, String r103, Integer r104, String r105);

    JSONObject getLoginInfo();

    void h(String r100, String r101, String r102);

    void i(int r100, Integer r101, String r102, Integer r103, String r104);

    void j(String r100, String r101, String r102);

    void k(String r100, int r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110);

    void l();

    void m(String r100, String r101, String r102, String r103);

    void n(int r100, String r101, String r102, String r103);

    void o(int r100, int r101, Integer r102, String r103);

    void p(String r100, String r101, String r102);

    void q(String r100);
}
