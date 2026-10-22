package com.bytedance.relax.ttml_profile_edit;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b8\b\u0017\u0018\u00002\u00020\u0001B¹\u0001\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\u0006\u0010\u001a\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010'\"\u0004\b(\u0010)R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010'\"\u0004\b*\u0010)R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001e\"\u0004\b.\u0010 R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001e\"\u0004\b0\u0010 R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001e\"\u0004\b2\u0010 R\u001a\u0010\u000e\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010'\"\u0004\b3\u0010)R\u001a\u0010\u000f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010'\"\u0004\b4\u0010)R\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010'\"\u0004\b6\u0010)R\u001a\u0010\u0011\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010'\"\u0004\b8\u0010)R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010\u0014\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010'\"\u0004\b>\u0010)R\u001a\u0010\u0015\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010'\"\u0004\b@\u0010)R\u001a\u0010\u0016\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010'\"\u0004\bB\u0010)R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001e\"\u0004\bD\u0010 R\u001a\u0010\u0018\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u001e\"\u0004\bF\u0010 R\u001a\u0010\u0019\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010'\"\u0004\bH\u0010)R\u001a\u0010\u001a\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u001e\"\u0004\bJ\u0010 ¨\u0006K"}, d2 = {"Lcom/bytedance/relax/ttml_profile_edit/ProfileEditData;", "", "userId", "", "nickName", "userName", "avatarUrl", "isDefaultAvatar", "", "isEnterpriseAccount", "enterpriseDisplayName", "enterFrom", "scene", "platform", "isOversea", "isDarkMode", "avatarEditable", "dirty", "userNameStatus", "", "nickNameFocused", "userNameFocused", "showNickNameError", "nickNameError", "userNameError", "saving", "saveMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZIZZZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "getNickName", "setNickName", "getUserName", "setUserName", "getAvatarUrl", "setAvatarUrl", "()Z", "setDefaultAvatar", "(Z)V", "setEnterpriseAccount", "getEnterpriseDisplayName", "setEnterpriseDisplayName", "getEnterFrom", "setEnterFrom", "getScene", "setScene", "getPlatform", "setPlatform", "setOversea", "setDarkMode", "getAvatarEditable", "setAvatarEditable", "getDirty", "setDirty", "getUserNameStatus", "()I", "setUserNameStatus", "(I)V", "getNickNameFocused", "setNickNameFocused", "getUserNameFocused", "setUserNameFocused", "getShowNickNameError", "setShowNickNameError", "getNickNameError", "setNickNameError", "getUserNameError", "setUserNameError", "getSaving", "setSaving", "getSaveMessage", "setSaveMessage", "profile_edit_relax_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ProfileEditData {
    public static final int $stable = 8;
    private boolean avatarEditable;
    private String avatarUrl;
    private boolean dirty;
    private String enterFrom;
    private String enterpriseDisplayName;
    private boolean isDarkMode;
    private boolean isDefaultAvatar;
    private boolean isEnterpriseAccount;
    private boolean isOversea;
    private String nickName;
    private String nickNameError;
    private boolean nickNameFocused;
    private String platform;
    private String saveMessage;
    private boolean saving;
    private String scene;
    private boolean showNickNameError;
    private String userId;
    private String userName;
    private String userNameError;
    private boolean userNameFocused;
    private int userNameStatus;

    public final boolean getAvatarEditable() {
        return this.avatarEditable;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final boolean getDirty() {
        return this.dirty;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterpriseDisplayName() {
        return this.enterpriseDisplayName;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getNickNameError() {
        return this.nickNameError;
    }

    public final boolean getNickNameFocused() {
        return this.nickNameFocused;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getSaveMessage() {
        return this.saveMessage;
    }

    public final boolean getSaving() {
        return this.saving;
    }

    public final String getScene() {
        return this.scene;
    }

    public final boolean getShowNickNameError() {
        return this.showNickNameError;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getUserNameError() {
        return this.userNameError;
    }

    public final boolean getUserNameFocused() {
        return this.userNameFocused;
    }

    public final int getUserNameStatus() {
        return this.userNameStatus;
    }

    public final boolean isDarkMode() {
        return this.isDarkMode;
    }

    public final boolean isDefaultAvatar() {
        return this.isDefaultAvatar;
    }

    public final boolean isEnterpriseAccount() {
        return this.isEnterpriseAccount;
    }

    public final boolean isOversea() {
        return this.isOversea;
    }

    public final void setAvatarEditable(boolean r100) {
        this.avatarEditable = r100;
    }

    public final void setAvatarUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.avatarUrl = r100;
    }

    public final void setDarkMode(boolean r100) {
        this.isDarkMode = r100;
    }

    public final void setDefaultAvatar(boolean r100) {
        this.isDefaultAvatar = r100;
    }

    public final void setDirty(boolean r100) {
        this.dirty = r100;
    }

    public final void setEnterFrom(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterFrom = r100;
    }

    public final void setEnterpriseAccount(boolean r100) {
        this.isEnterpriseAccount = r100;
    }

    public final void setEnterpriseDisplayName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterpriseDisplayName = r100;
    }

    public final void setNickName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.nickName = r100;
    }

    public final void setNickNameError(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.nickNameError = r100;
    }

    public final void setNickNameFocused(boolean r100) {
        this.nickNameFocused = r100;
    }

    public final void setOversea(boolean r100) {
        this.isOversea = r100;
    }

    public final void setPlatform(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.platform = r100;
    }

    public final void setSaveMessage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.saveMessage = r100;
    }

    public final void setSaving(boolean r100) {
        this.saving = r100;
    }

    public final void setScene(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.scene = r100;
    }

    public final void setShowNickNameError(boolean r100) {
        this.showNickNameError = r100;
    }

    public final void setUserId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.userId = r100;
    }

    public final void setUserName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.userName = r100;
    }

    public final void setUserNameError(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.userNameError = r100;
    }

    public final void setUserNameFocused(boolean r100) {
        this.userNameFocused = r100;
    }

    public final void setUserNameStatus(int r100) {
        this.userNameStatus = r100;
    }

    public ProfileEditData(String r110, String r111, String r112, String r113, boolean r114, boolean r115, String r210, String r211, String r212, String r213, boolean r214, boolean r215, boolean r216, boolean r217, int r218, boolean r219, boolean r310, boolean r311, String r312, String r313, boolean r314, String r315) {
        Intrinsics.checkNotNullParameter(r110, "userId");
        Intrinsics.checkNotNullParameter(r111, "nickName");
        Intrinsics.checkNotNullParameter(r112, "userName");
        Intrinsics.checkNotNullParameter(r113, "avatarUrl");
        Intrinsics.checkNotNullParameter(r210, "enterpriseDisplayName");
        Intrinsics.checkNotNullParameter(r211, "enterFrom");
        Intrinsics.checkNotNullParameter(r212, "scene");
        Intrinsics.checkNotNullParameter(r213, "platform");
        Intrinsics.checkNotNullParameter(r312, "nickNameError");
        Intrinsics.checkNotNullParameter(r313, "userNameError");
        Intrinsics.checkNotNullParameter(r315, "saveMessage");
        this.userId = r110;
        this.nickName = r111;
        this.userName = r112;
        this.avatarUrl = r113;
        this.isDefaultAvatar = r114;
        this.isEnterpriseAccount = r115;
        this.enterpriseDisplayName = r210;
        this.enterFrom = r211;
        this.scene = r212;
        this.platform = r213;
        this.isOversea = r214;
        this.isDarkMode = r215;
        this.avatarEditable = r216;
        this.dirty = r217;
        this.userNameStatus = r218;
        this.nickNameFocused = r219;
        this.userNameFocused = r310;
        this.showNickNameError = r311;
        this.nickNameError = r312;
        this.userNameError = r313;
        this.saving = r314;
        this.saveMessage = r315;
    }
}
