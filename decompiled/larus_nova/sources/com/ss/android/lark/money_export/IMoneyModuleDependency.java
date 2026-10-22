package com.ss.android.lark.money_export;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.api.IChatParser;
import com.ss.android.lark.chat.api.IChatterParser;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes36.dex */
public interface IMoneyModuleDependency {

    public interface IAuditDependency {
        int getLoginUserAuthorityDeniedCode();

        int getOtherUserAuthorityDeniedCode();

        String getUserAuthorityControledTip();

        void onUserAuthorityDenied(Context r100, String r101);
    }

    public interface IChatDependency {
        IChatParser getChatParser();

        IChatterParser getChatterParser();

        String getDisplayNameByName(Chatter r100);

        Chatter getLoginChatter();

        void getLoginChatter(IGetDataCallback<Chatter> r100);

        boolean isGooglePlay();

        boolean isOverseaTenant();
    }

    public interface IContactDependency {
        void showApplyCollabDialog(Context r100, String r101, String r102, String r103, IDialogCallback r104);
    }

    public interface IDialogCallback {
        void onCancel();

        void onConfirm(boolean r100, String r101);

        void onDismiss();
    }

    public interface IDynamicConfigDependency {
        String getDomain();
    }

    public interface IFeatureGatingDependency {
        boolean isEnable(String r100);

        boolean isEnable(String r100, boolean r101);
    }

    public interface IGroupMemberManageDependency {
        List<SelectChatterDTO> getSelectedMemberFromIntent(Intent r100);

        void selectDesignatedRedPacketReceiver(Activity r100, Fragment r101, String r102, List<String> r103, int r104);
    }

    public interface IImageDependency {
        void loadAvatarImage(Context r100, String r101, String r102, ImageView r103, int r104, int r105);
    }

    public interface ILanguageDependency {
        Locale getCacheLanguageSetting();

        Locale getLanguageSetting();
    }

    public interface ILoginDependency {
        String getLoginUserId();

        boolean isPrimaryHost();
    }

    public interface IMoneyDependency {
        void onWebViewCreate(WebView r100);
    }

    public interface a {
    }

    public interface b {
    }

    a getAppConfigDependency();

    String getAppId();

    IAuditDependency getAuditDependency();

    b getBrowserDependency();

    String getCaijingHost();

    IChatDependency getChatDependency();

    IContactDependency getContactDependency();

    Context getContext();

    String getDeviceId();

    IDynamicConfigDependency getDynamicConfigDependency();

    IFeatureGatingDependency getFeatureGatingDependency();

    IGroupMemberManageDependency getGroupMemberManageDependency();

    IImageDependency getImageDependency();

    String getInstallId();

    ILanguageDependency getLanguageDependency();

    ILoginDependency getLoginDependency();

    IMoneyDependency getMoneyDependency();

    String getUserId();

    void initBytecertSdk();

    void initDefaultNetworkClient();

    boolean isBoe();

    boolean isTtp();

    void openBulletSchema(Context r100, String r101);
}
