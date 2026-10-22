package w4b;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Range;
import androidx.fragment.app.Fragment;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.UniversalUserSetting;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.chat.core.dependency.ChatSettingDependency;
import com.ss.android.lark.chat.core.dependency.StickerDependency;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes35.dex */
public interface c {

    public interface a {
    }

    public interface b {
        Dialog a(Context r100, String r101, String r102, String r103, String r104, String r105, Map<String, String> r106);
    }

    /* JADX INFO: renamed from: w4b.c$c, reason: collision with other inner class name */
    public interface InterfaceC8067c {
        UniversalUserSetting a();

        void isOn();
    }

    public interface d {
    }

    public interface e {
        l a();
    }

    public interface f {
        void a(psb.a r100);

        void b();

        void c(psb.a r100);

        void d();

        Range<Integer> e();
    }

    public interface g {
        void a(Chat r100);
    }

    public interface h {
        void a(Context r100, String r101);
    }

    public interface i {
    }

    public interface j {
        void a();

        void b(String r100, String r101, String[] r102, IGetDataCallback<List<String>> r103);
    }

    public interface k {
        boolean a(int r100);

        void isInMeeting();
    }

    public interface l {
    }

    public interface m {
    }

    public interface n {
        void isPluginInstalled(String r100);

        void isPluginLoaded(String r100);
    }

    public interface o {
        String Fc();

        String fe();

        String userId();
    }

    public static class p {
    }

    boolean canShowSingleUrlCard(y6b.a<?> r100, m2b.a r101, g3b.v r102);

    b getAiDependency();

    InterfaceC8067c getAppConfigDependency();

    w4b.a getAuditDependency();

    BrowserDependency getBrowserDependency();

    w4b.b getCcmDependency();

    w4b.g getChatDependency();

    ChatSettingDependency getChatSettingDependency();

    Context getContext();

    String getDeviceId();

    w4b.i getDingDependency();

    w4b.j getDownloadDependency();

    d getEnterpriseTopicDependency();

    w4b.d getExtensionDependency();

    w4b.k getFeatureConfigDependency();

    w4b.l getFeatureGatingDependency();

    w4b.m getFeedDependency();

    vab.b getFileDetailDependency();

    w4b.o getGroupMemberManageDependency();

    w4b.p getGuideDependency();

    i getIRecommendEventAiDependency();

    s getImageDependency();

    t getLanguageDependency();

    m getLeanModeDependency();

    u getLoginDependency();

    v getMainDependency();

    w getMergeForwardDependnecy();

    n getMiraDependency();

    x getMoneyDependency();

    e getMultiTaskDependency();

    f getMyAIDependency();

    g getOpenPlatformDependency();

    Chatter.ChatterCustomStatus getOpenedUserStatus(List<Chatter.ChatterCustomStatus> r100);

    Drawable getOpenedUserStatusSmallDrawable(Context r100, List<Chatter.ChatterCustomStatus> r101, boolean r102);

    o getPassportDependency();

    x1b.c getPerfEnterChatMonitor();

    h getPhoneDependency();

    p getProfile();

    b0 getProfileDependency();

    c0 getPushDependency();

    void getResource(Set<String> r100, String r101, String r102, String r103, IGetDataCallback<Map<String, String>> r104);

    r getSecurityComplianceDependency();

    d0 getSettingDependency();

    StickerDependency getStickerDependency();

    w4b.e getTeamDependency();

    e0 getThreadDependency();

    f0 getTimeFormatDependency();

    j getTranslateDependency();

    w4b.f getUrlPreviewDependency();

    k getVcDependency();

    g0 getWschannelDependency();

    boolean isAutoTranslateEnableViaBilling();

    boolean isHideRichTextView(y6b.a<?> r100, m2b.a r101, v4b.d r102);

    boolean isLarkPkg();

    void launchMainWindow(Context r100, String r101, Bundle r102);

    boolean openAppLinkUrl(Context r100, String r101);

    void openReadStateDetailPage(Context r100, String r101, Message.Type r102, String r103, ArrayList<String> r104, boolean r105);

    void registerSourceMessageRecalledEventListener(aqb.i r100);

    void startPhotoEditorActivityFromPreview(Context r100, Fragment r101, int r102, String r103, String r104, boolean r105, boolean r106, String r107, String r108, String r110);

    void unRegisterSourceMessageRecalledEventListener(aqb.i r100);
}
