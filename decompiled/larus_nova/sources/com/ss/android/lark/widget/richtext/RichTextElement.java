package com.ss.android.lark.widget.richtext;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.lark.pb.basic.v1.CalendarEntityMeta;
import com.bytedance.lark.pb.im.v1.MyAIExtensionBasicInfo;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import com.ss.android.lark.widget.richtext.preprocess.ElementExtra;
import com.ss.android.lark.widget.table.entity.Column;
import com.ss.android.lark.widget.table.entity.HorizontalAlign;
import com.ss.android.lark.widget.table.entity.VerticalAlign;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import okio.ByteString;

/* JADX INFO: loaded from: classes38.dex */
public class RichTextElement implements Serializable {
    public static final String TAG = "RichTextElement";
    private RichTextProperty calendarAiProperty;
    private List<String> childIds;
    private ElementExtra elementExtra;
    private RichTextProperty property;
    private Map<String, String> style;
    private List<String> styleKeys;
    private RichTextTag tag;

    @JSONType(ignores = {"version"}, typeName = "AnchorProperty")
    public static class AnchorProperty extends RichTextProperty {
        private String androidHref;
        private boolean closeCardPreview;
        private String content;
        private String displayTitle;
        private String faviconUrl;
        private String href;
        private String i18nKey;
        private int iconColor;
        private String iconKey;
        private boolean isColorIcon;
        private boolean isCustom;
        private boolean isUrlPreview;
        private int localGrayIconRes;
        private int localIconRes;
        private Scene scene;
        private SpecialURL specialURL;
        private String unicode;
        private String urlPreviewId;
        private int version;

        public static final enum Scene extends Enum<Scene> {
            public static final Scene COPY_PASTE_ANCHOR = null;
            public static final Scene COPY_PASTE_TEXT = null;
            public static final Scene CUSTOM_EDIT = null;
            public static final Scene SEVER_PARSE = null;
            public static final Scene UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Scene[] f448192a = null;
            public int value;

            static {
                Scene r100 = new Scene("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Scene r101 = new Scene("COPY_PASTE_ANCHOR", 1, 1);
                COPY_PASTE_ANCHOR = r101;
                Scene r102 = new Scene("COPY_PASTE_TEXT", 2, 2);
                COPY_PASTE_TEXT = r102;
                Scene r103 = new Scene("CUSTOM_EDIT", 3, 3);
                CUSTOM_EDIT = r103;
                Scene r104 = new Scene("SEVER_PARSE", 4, 4);
                SEVER_PARSE = r104;
                f448192a = new Scene[]{r100, r101, r102, r103, r104};
            }

            public static Scene[] values() {
                return (Scene[]) f448192a.clone();
            }

            public static Scene valueOf(int r100) {
                if (r100 == 1) goto L19;
                if (r100 == 2) goto L17;
                if (r100 == 3) goto L15;
                if (r100 == 4) goto L13;
                return UNKNOWN;
            L13:
                return SEVER_PARSE;
            L15:
                return CUSTOM_EDIT;
            L17:
                return COPY_PASTE_TEXT;
            L19:
                return COPY_PASTE_ANCHOR;
            }

            public static Scene valueOf(String r100) {
                return (Scene) r27.a.a(Scene.class, r100);
            }

            public Scene(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final enum SpecialURL extends Enum<SpecialURL> {
            public static final SpecialURL BEAR = null;
            public static final SpecialURL ENTITY_NUM = null;
            public static final SpecialURL UNKNOWN_URL = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ SpecialURL[] f448193a = null;
            public final int value;

            static {
                SpecialURL r100 = new SpecialURL("UNKNOWN_URL", 0, 0);
                UNKNOWN_URL = r100;
                SpecialURL r101 = new SpecialURL("BEAR", 1, 1);
                BEAR = r101;
                SpecialURL r102 = new SpecialURL("ENTITY_NUM", 2, 2);
                ENTITY_NUM = r102;
                f448193a = new SpecialURL[]{r100, r101, r102};
            }

            public static SpecialURL[] values() {
                return (SpecialURL[]) f448193a.clone();
            }

            public static SpecialURL valueOf(int r100) {
                if (r100 != 1) goto L7;
                return BEAR;
            L7:
                if (r100 != 2) goto L11;
                return ENTITY_NUM;
            L11:
                return UNKNOWN_URL;
            }

            public static SpecialURL valueOf(String r100) {
                return (SpecialURL) r27.a.a(SpecialURL.class, r100);
            }

            public SpecialURL(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public int hashCode() {
            return Objects.hash(new Object[]{this.href, this.content, this.androidHref, this.i18nKey, Integer.valueOf(this.localIconRes), this.displayTitle, Boolean.valueOf(this.isUrlPreview), Integer.valueOf(this.iconColor), Integer.valueOf(this.scene.value), this.urlPreviewId, Integer.valueOf(this.specialURL.value)});
        }

        public String toString() {
            return "AnchorProperty{href='" + this.href + "', content='" + this.content + "', androidHref='" + this.androidHref + "', i18nKey='" + this.i18nKey + "', localIconRes=" + this.localIconRes + ", localGrayIconRes=" + this.localGrayIconRes + ", iconKey='" + this.iconKey + "', displayTitle='" + this.displayTitle + "', isUrlPreview=" + this.isUrlPreview + ", disableUrlPreview=" + this.closeCardPreview + ", version=" + this.version + ", scene=" + this.scene + ", iconColor=" + this.iconColor + ", urlPreviewId=" + this.urlPreviewId + ", specialURL=" + this.specialURL + '}';
        }

        public AnchorProperty() {
            this.isColorIcon = false;
            this.closeCardPreview = false;
            this.version = -1;
            this.urlPreviewId = null;
            this.specialURL = SpecialURL.UNKNOWN_URL;
            this.scene = Scene.UNKNOWN;
        }

        public String getAndroidHref() {
            return this.androidHref;
        }

        public String getContent() {
            return this.content;
        }

        public String getDisplayTitle() {
            return this.displayTitle;
        }

        public String getFaviconUrl() {
            return this.faviconUrl;
        }

        public String getHref() {
            return this.href;
        }

        public String getI18nKey() {
            return this.i18nKey;
        }

        public int getIconColor() {
            return this.iconColor;
        }

        public String getIconKey() {
            return this.iconKey;
        }

        public int getLocalGrayIconRes() {
            return this.localGrayIconRes;
        }

        public int getLocalIconRes() {
            return this.localIconRes;
        }

        public Scene getScene() {
            return this.scene;
        }

        public SpecialURL getSpecialURL() {
            return this.specialURL;
        }

        public String getUnicode() {
            return this.unicode;
        }

        public String getUrlPreviewId() {
            return this.urlPreviewId;
        }

        public int getVersion() {
            return this.version;
        }

        public boolean isCloseCardPreview() {
            return this.closeCardPreview;
        }

        public boolean isColorIcon() {
            return this.isColorIcon;
        }

        public boolean isCustom() {
            return this.isCustom;
        }

        public boolean isUrlPreview() {
            return this.isUrlPreview;
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public boolean equals(Object r100) {
            if (r100 != this) goto L6;
            return true;
        L6:
            if (r100 != null) goto L9;
            return false;
        L9:
            if (getClass() == r100.getClass()) goto L11;
            return false;
        L11:
            AnchorProperty r101 = (AnchorProperty) r100;
        L37:
            e = move-exception;
            e.printStackTrace();
            return false;
        L13:
            if (this.href.equals(r101.href) == true) goto L15;
        L35:
            return false;
        L15:
            if (this.content.equals(r101.content) == false) goto L35;
            if (this.localIconRes != r101.localIconRes) goto L35;
            if (this.isUrlPreview != r101.isUrlPreview) goto L35;
            if (this.closeCardPreview != r101.closeCardPreview) goto L35;
            if (TextUtils.equals(this.displayTitle, r101.displayTitle) == false) goto L35;
            if (this.version != r101.version) goto L35;
            if (this.scene != r101.scene) goto L35;
            if (this.iconColor != r101.iconColor) goto L35;
            if (TextUtils.equals(this.urlPreviewId, r101.urlPreviewId) == false) goto L35;
            if (this.specialURL != r101.specialURL) goto L35;
            return true;
        }

        public void setAndroidHref(String r100) {
            this.androidHref = r100;
        }

        public void setCloseCardPreview(boolean r100) {
            this.closeCardPreview = r100;
        }

        public void setColorIcon(boolean r100) {
            this.isColorIcon = r100;
        }

        public void setContent(String r100) {
            this.content = r100;
        }

        public void setCustom(boolean r100) {
            this.isCustom = r100;
        }

        public void setDisplayTitle(String r100) {
            this.displayTitle = r100;
        }

        public void setFaviconUrl(String r100) {
            this.faviconUrl = r100;
        }

        public void setHref(String r100) {
            this.href = r100;
        }

        public void setI18nKey(String r100) {
            this.i18nKey = r100;
        }

        public void setIconColor(int r100) {
            this.iconColor = r100;
        }

        public void setIconKey(String r100) {
            this.iconKey = r100;
        }

        public void setLocalGrayIconRes(int r100) {
            this.localGrayIconRes = r100;
        }

        public void setLocalIconRes(int r100) {
            this.localIconRes = r100;
        }

        public void setScene(Scene r100) {
            this.scene = r100;
        }

        public void setSpecialURL(SpecialURL r100) {
            this.specialURL = r100;
        }

        public void setUnicode(String r100) {
            this.unicode = r100;
        }

        public void setUrlPreview(boolean r100) {
            this.isUrlPreview = r100;
        }

        public void setUrlPreviewId(String r100) {
            this.urlPreviewId = r100;
        }

        public void setVersion(int r100) {
            this.version = r100;
        }
    }

    @JSONType(typeName = "AtProperty")
    public static class AtProperty extends RichTextProperty {
        private String content;
        private boolean isAnonymous;
        private boolean isHighLight;
        private boolean isOutChatUser;
        private String originUserName;
        private String userId;

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public int hashCode() {
            return Objects.hash(new Object[]{this.userId, this.content, Boolean.valueOf(this.isOutChatUser), Boolean.valueOf(this.isAnonymous)});
        }

        public String getAtContent() {
            String r100 = this.content;
            if (r100 != null) goto L7;
            Log.e(RichTextElement.TAG, "At content is null");
            return "@";
        L7:
            if (r100.startsWith("@") == false) goto L9;
            return r100;
        L9:
            return "@".concat(r100);
        }

        public String getAtContentForPB() {
            String r100 = this.originUserName;
            if (TextUtils.isEmpty(r100) == false) goto L7;
            Log.i(RichTextElement.TAG, "getAtContentForPB: originName is null");
            return getAtContent();
        L7:
            if (r100.startsWith("@") == false) goto L9;
            return r100;
        L9:
            return "@".concat(r100);
        }

        public String getContent() {
            String r100 = this.content;
            if (r100 == null) goto L9;
            if (r100.startsWith("@") == true) goto L9;
            return "@" + this.content;
        L9:
            return this.content;
        }

        public String getContentWithoutAt() {
            if (this.content.startsWith("@") == false) goto L7;
            return this.content.substring(1);
        L7:
            return this.content;
        }

        public AtProperty() {
        }

        public String getOriginUserName() {
            return this.originUserName;
        }

        public String getUserId() {
            return this.userId;
        }

        public boolean isAnonymous() {
            return this.isAnonymous;
        }

        public boolean isHighLight() {
            return this.isHighLight;
        }

        public boolean isOutChatUser() {
            return this.isOutChatUser;
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public boolean equals(Object r100) {
            if (r100 != this) goto L6;
            return true;
        L6:
            if (r100 != null) goto L9;
            return false;
        L9:
            if (getClass() == r100.getClass()) goto L11;
            return false;
        L11:
            AtProperty r101 = (AtProperty) r100;
            if (this.isAnonymous == r101.isAnonymous) goto L24;
            return false;
        L24:
        L21:
            e = move-exception;
            e.printStackTrace();
            return false;
        L15:
            if (this.userId.equals(r101.userId) == false) goto L19;
            if (getContent().equals(r101.getContent()) == false) goto L19;
            return true;
        L19:
            return false;
        }

        public void setAnonymous(boolean r100) {
            this.isAnonymous = r100;
        }

        public void setContent(String r100) {
            if (r100.startsWith("@") == true) goto L5;
            this.content = "@".concat(r100);
            return;
        L5:
            this.content = r100;
        }

        public void setContentWithoutLimit(String r100) {
            this.content = r100;
        }

        public void setHighLight(boolean r100) {
            this.isHighLight = r100;
        }

        public void setOriginUserName(String r100) {
            this.originUserName = r100;
        }

        public void setOutChatUser(boolean r100) {
            this.isOutChatUser = r100;
        }

        public void setUserId(String r100) {
            this.userId = r100;
        }
    }

    @JSONType(typeName = "AtUserGroupProperty")
    public static class AtUserGroupProperty extends RichTextProperty {
        private String defaultGroupName;
        private String displayName;
        private HashMap<String, String> i18nGroupName;
        private String pbDisplayName;
        private int permissionStatus;
        private long userGroupId;

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Long.valueOf(this.userGroupId), this.pbDisplayName, this.displayName, Integer.valueOf(this.permissionStatus)});
        }

        public String getContentDisplayName() {
            String r100 = this.displayName;
            if (TextUtils.isEmpty(r100) == true) goto L5;
            return r100;
        L5:
            return this.pbDisplayName;
        }

        public final void a() {
            if (getI18nGroupName() == null) goto L15;
            yob.e.a().getClass();
            int r100 = com.ss.android.lark.language.service.impl.a.f431092f;
            Locale r101 = com.ss.android.lark.language.service.impl.a.b.f431098a.getCacheLanguageSetting();
            if (TextUtils.isEmpty(r101.getCountry()) == true) goto L7;
            String r102 = r101.getLanguage() + "_" + r101.getCountry();
        L11:
            String r103 = getI18nGroupName().get(r102);
            if (TextUtils.isEmpty(r103) == false) goto L16;
            Log.w(RichTextElement.TAG, "user group name not found, languageKey: " + r102);
            return;
        L16:
            if (r103 != null) goto L19;
            r103 = getDefaultGroupName();
        L19:
            if (TextUtils.isEmpty(r103) == false) goto L22;
            Log.e(RichTextElement.TAG, "user group name not found");
            return;
        L22:
            this.pbDisplayName = r103;
            return;
        L7:
            if (TextUtils.isEmpty(r101.getLanguage()) == false) goto L9;
            r102 = "";
            goto L11
        L9:
            r102 = r101.getLanguage();
            goto L11
        L15:
            r103 = null;
            goto L16
        }

        public String getAtContent() {
            String r100 = getContentDisplayName();
            if (TextUtils.isEmpty(r100) == false) goto L6;
            return "@";
        L6:
            return "@" + r100;
        }

        public AtUserGroupProperty() {
        }

        public String getDefaultGroupName() {
            return this.defaultGroupName;
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public Map<String, String> getI18nGroupName() {
            return this.i18nGroupName;
        }

        public int getPermissionStatus() {
            return this.permissionStatus;
        }

        public long getUserGroupId() {
            return this.userGroupId;
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L24:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L24;
            if (super.equals(r100) == true) goto L13;
            return false;
        L13:
            AtUserGroupProperty r101 = (AtUserGroupProperty) r100;
            if (this.userGroupId == r101.userGroupId) goto L16;
        L22:
            return false;
        L16:
            if (this.permissionStatus != r101.permissionStatus) goto L22;
            if (Objects.equals(this.pbDisplayName, r101.pbDisplayName) == false) goto L22;
            if (Objects.equals(this.displayName, r101.displayName) == false) goto L22;
            return true;
        }

        public void setDefaultGroupName(String r100) {
            this.defaultGroupName = r100;
            a();
        }

        public void setDisplayName(String r100) {
            this.displayName = r100;
        }

        public void setI18nGroupName(Map<String, String> r100) {
            this.i18nGroupName = new HashMap(r100);
            a();
        }

        public void setPermissionStatus(int r100) {
            this.permissionStatus = r100;
        }

        public void setUserGroupId(long r100) {
            this.userGroupId = r100;
        }
    }

    @JSONType(typeName = "BoldProperty")
    public static class BoldProperty extends TextProperty {
        public BoldProperty() {
        }
    }

    @JSONType(typeName = "ButtonProperty")
    public static class ButtonProperty extends RichTextProperty {
        private String actionId;
        private boolean active;
        private ConfirmProperty confirm;
        private boolean disable;
        private boolean isShowLoadingIcon;
        private ButtonLoadingProperty loading;
        private String mode;

        public static class ButtonLoadingProperty implements Serializable {
            private String begin;
            private String beginI18NKey;
            private String fail;
            private String failI18NKey;
            private String success;
            private String successI18NKey;

            public ButtonLoadingProperty() {
            }

            public int hashCode() {
                String r100 = this.begin;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                String r104 = this.success;
                if (r104 == null) goto L9;
                int r105 = r104.hashCode();
            L10:
                int r106 = (r103 + r105) * 31;
                String r107 = this.fail;
                if (r107 == null) goto L13;
                int r108 = r107.hashCode();
            L14:
                int r109 = (r106 + r108) * 31;
                String r110 = this.beginI18NKey;
                if (r110 == null) goto L17;
                int r111 = r110.hashCode();
            L18:
                int r112 = (r109 + r111) * 31;
                String r113 = this.successI18NKey;
                if (r113 == null) goto L21;
                int r114 = r113.hashCode();
            L22:
                int r115 = (r112 + r114) * 31;
                String r116 = this.failI18NKey;
                if (r116 == null) goto L26;
                r101 = r116.hashCode();
            L26:
                return r115 + r101;
            L21:
                r114 = 0;
                goto L22
            L17:
                r111 = 0;
                goto L18
            L13:
                r108 = 0;
                goto L14
            L9:
                r105 = 0;
                goto L10
            L5:
                r102 = 0;
                goto L6
            }

            public String getBegin() {
                return this.begin;
            }

            public String getBeginI18NKey() {
                return this.beginI18NKey;
            }

            public String getFail() {
                return this.fail;
            }

            public String getFailI18NKey() {
                return this.failI18NKey;
            }

            public String getSuccess() {
                return this.success;
            }

            public String getSuccessI18NKey() {
                return this.successI18NKey;
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if (r100 != null) goto L8;
            L27:
                return false;
            L8:
                if (getClass() != r100.getClass()) goto L27;
                ButtonLoadingProperty r101 = (ButtonLoadingProperty) r100;
                if (Objects.equals(this.begin, r101.begin) == true) goto L14;
                return false;
            L14:
                if (Objects.equals(this.success, r101.success) == true) goto L17;
                return false;
            L17:
                if (Objects.equals(this.fail, r101.fail) == true) goto L20;
                return false;
            L20:
                if (Objects.equals(this.beginI18NKey, r101.beginI18NKey) == true) goto L23;
                return false;
            L23:
                if (Objects.equals(this.successI18NKey, r101.successI18NKey) == true) goto L26;
                return false;
            L26:
                return Objects.equals(this.failI18NKey, r101.failI18NKey);
            }

            public void setBegin(String r100) {
                this.begin = r100;
            }

            public void setBeginI18NKey(String r100) {
                this.beginI18NKey = r100;
            }

            public void setFail(String r100) {
                this.fail = r100;
            }

            public void setFailI18NKey(String r100) {
                this.failI18NKey = r100;
            }

            public void setSuccess(String r100) {
                this.success = r100;
            }

            public void setSuccessI18NKey(String r100) {
                this.successI18NKey = r100;
            }
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.actionId, Boolean.valueOf(this.disable), Boolean.valueOf(this.active), this.confirm, this.loading, Boolean.valueOf(this.isShowLoadingIcon), this.mode});
        }

        public ButtonProperty() {
        }

        public String getActionId() {
            return this.actionId;
        }

        public ConfirmProperty getConfirm() {
            return this.confirm;
        }

        public ButtonLoadingProperty getLoading() {
            return this.loading;
        }

        public String getMode() {
            return this.mode;
        }

        public boolean isActive() {
            return this.active;
        }

        public boolean isDisable() {
            return this.disable;
        }

        public boolean isShowLoadingIcon() {
            return this.isShowLoadingIcon;
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L30:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L30;
            if (super.equals(r100) == true) goto L13;
            return false;
        L13:
            ButtonProperty r101 = (ButtonProperty) r100;
            if (this.disable == r101.disable) goto L16;
        L28:
            return false;
        L16:
            if (this.active != r101.active) goto L28;
            if (this.isShowLoadingIcon != r101.isShowLoadingIcon) goto L28;
            if (Objects.equals(this.actionId, r101.actionId) == false) goto L28;
            if (Objects.equals(this.confirm, r101.confirm) == false) goto L28;
            if (Objects.equals(this.loading, r101.loading) == false) goto L28;
            if (Objects.equals(this.mode, r101.mode) == false) goto L28;
            return true;
        }

        public void setActionId(String r100) {
            this.actionId = r100;
        }

        public void setActive(boolean r100) {
            this.active = r100;
        }

        public void setConfirm(ConfirmProperty r100) {
            this.confirm = r100;
        }

        public void setDisable(boolean r100) {
            this.disable = r100;
        }

        public void setLoading(ButtonLoadingProperty r100) {
            this.loading = r100;
        }

        public void setMode(String r100) {
            this.mode = r100;
        }

        public void setShowLoadingIcon(boolean r100) {
            this.isShowLoadingIcon = r100;
        }
    }

    @JSONType(typeName = "CalendarDashedProperty")
    public static class CalendarDashedProperty extends TextProperty {
        public String chatId;
        public int intervalOff;
        public int intervalOn;
        public boolean isOver24HourAndDisableDash;
        public String messageId;
        public ArrayList<Property> propertyV2List;

        public static class Property implements Serializable {
            public int end;
            public CalendarEntityMeta extra;

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            public String f448194id;
            public String name;
            public int start;

            public Property() {
            }
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.TextProperty, com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.messageId, this.chatId, Integer.valueOf(this.intervalOn), Integer.valueOf(this.intervalOff), Boolean.valueOf(this.isOver24HourAndDisableDash), this.propertyV2List});
        }

        public CalendarDashedProperty() {
            this.propertyV2List = new ArrayList();
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.TextProperty, com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L28:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L28;
            if (super.equals(r100) == true) goto L13;
            return false;
        L13:
            CalendarDashedProperty r101 = (CalendarDashedProperty) r100;
            if (this.intervalOn == r101.intervalOn) goto L16;
        L26:
            return false;
        L16:
            if (this.intervalOff != r101.intervalOff) goto L26;
            if (this.isOver24HourAndDisableDash != r101.isOver24HourAndDisableDash) goto L26;
            if (Objects.equals(this.messageId, r101.messageId) == false) goto L26;
            if (Objects.equals(this.chatId, r101.chatId) == false) goto L26;
            if (Objects.equals(this.propertyV2List, r101.propertyV2List) == false) goto L26;
            return true;
        }
    }

    @JSONType(typeName = "CodeBlockProperty")
    public static class CodeBlockProperty extends RichTextProperty {
        private static final long serialVersionUID = 1423823212701200062L;
        private String content;
        private Language language;
        private List<Style> styleList;
        private List<StyleRef> styleRefList;

        public static final enum Language extends Enum<Language> {
            public static final Language APACHE = null;
            public static final Language BASH = null;
            public static final Language COFFE_SCRIPT = null;
            public static final Language CPLUSPLUS = null;
            public static final Language CS = null;
            public static final Language DJANGO = null;
            public static final Language GO = null;
            public static final Language HTML = null;
            public static final Language HTTP = null;
            public static final Language JAVA = null;
            public static final Language JS = null;
            public static final Language JSON = null;
            public static final Language KOTLIN = null;
            public static final Language LUA = null;
            public static final Language MAKEFILE = null;
            public static final Language MARKDOWN = null;
            public static final Language NGINX = null;
            public static final Language OBJC = null;
            public static final Language PERL = null;
            public static final Language PHP = null;
            public static final Language PYTHON = null;
            public static final Language RUBY = null;
            public static final Language SCSS = null;
            public static final Language SHELL = null;
            public static final Language SQL = null;
            public static final Language XML = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Language[] f448195a = null;
            private final int value;

            static {
                Language r100 = new Language("JS", 0, 0);
                JS = r100;
                Language r101 = new Language("APACHE", 1, 1);
                APACHE = r101;
                Language r102 = new Language("BASH", 2, 2);
                BASH = r102;
                Language r103 = new Language("CS", 3, 3);
                CS = r103;
                Language r104 = new Language("CPLUSPLUS", 4, 4);
                CPLUSPLUS = r104;
                Language r105 = new Language("COFFE_SCRIPT", 5, 5);
                COFFE_SCRIPT = r105;
                Language r110 = new Language("HTML", 6, 6);
                HTML = r110;
                Language r111 = new Language("XML", 7, 7);
                XML = r111;
                Language r112 = new Language("HTTP", 8, 8);
                HTTP = r112;
                Language r113 = new Language("JSON", 9, 9);
                JSON = r113;
                Language r114 = new Language("JAVA", 10, 10);
                JAVA = r114;
                Language r115 = new Language("MAKEFILE", 11, 11);
                MAKEFILE = r115;
                Language r106 = new Language("MARKDOWN", 12, 12);
                MARKDOWN = r106;
                Language r107 = new Language("NGINX", 13, 13);
                NGINX = r107;
                Language r108 = new Language("OBJC", 14, 14);
                OBJC = r108;
                Language r109 = new Language("PHP", 15, 15);
                PHP = r109;
                Language r116 = new Language("PERL", 16, 16);
                PERL = r116;
                Language r117 = new Language("PYTHON", 17, 17);
                PYTHON = r117;
                Language r118 = new Language("RUBY", 18, 18);
                RUBY = r118;
                Language r119 = new Language("SQL", 19, 19);
                SQL = r119;
                Language r120 = new Language("SHELL", 20, 20);
                SHELL = r120;
                Language r121 = new Language("GO", 21, 21);
                GO = r121;
                Language r122 = new Language("SCSS", 22, 22);
                SCSS = r122;
                Language r123 = new Language("LUA", 23, 23);
                LUA = r123;
                Language r124 = new Language("DJANGO", 24, 24);
                DJANGO = r124;
                Language r125 = new Language("KOTLIN", 25, 25);
                KOTLIN = r125;
                f448195a = new Language[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125};
            }

            public static Language[] values() {
                return (Language[]) f448195a.clone();
            }

            public int getType() {
                return this.value;
            }

            public static Language forType(int r100) {
                switch(r100) {
                    case 0: goto L56;
                    case 1: goto L54;
                    case 2: goto L52;
                    case 3: goto L50;
                    case 4: goto L48;
                    case 5: goto L46;
                    case 6: goto L44;
                    case 7: goto L42;
                    case 8: goto L40;
                    case 9: goto L38;
                    case 10: goto L36;
                    case 11: goto L34;
                    case 12: goto L32;
                    case 13: goto L30;
                    case 14: goto L28;
                    case 15: goto L26;
                    case 16: goto L24;
                    case 17: goto L22;
                    case 18: goto L20;
                    case 19: goto L18;
                    case 20: goto L16;
                    case 21: goto L14;
                    case 22: goto L12;
                    case 23: goto L10;
                    case 24: goto L8;
                    case 25: goto L6;
                    default: goto L4;
                };
            L4:
                return JS;
            L6:
                return KOTLIN;
            L8:
                return DJANGO;
            L10:
                return LUA;
            L12:
                return SCSS;
            L14:
                return GO;
            L16:
                return SHELL;
            L18:
                return SQL;
            L20:
                return RUBY;
            L22:
                return PYTHON;
            L24:
                return PERL;
            L26:
                return PHP;
            L28:
                return OBJC;
            L30:
                return NGINX;
            L32:
                return MAKEFILE;
            L34:
                return MAKEFILE;
            L36:
                return JAVA;
            L38:
                return JSON;
            L40:
                return HTTP;
            L42:
                return XML;
            L44:
                return HTML;
            L46:
                return COFFE_SCRIPT;
            L48:
                return CPLUSPLUS;
            L50:
                return CS;
            L52:
                return BASH;
            L54:
                return APACHE;
            L56:
                return JS;
            }

            public static Language valueOf(String r100) {
                return (Language) r27.a.a(Language.class, r100);
            }

            public static Language valueOf(int r100) {
                return forType(r100);
            }

            public Language(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static class Style implements Serializable {
            private static final long serialVersionUID = 6642406954507876859L;
            public String name;
            public StyleType type;
            public String value;

            public Style() {
            }
        }

        public static class StyleRef implements Serializable {
            private static final long serialVersionUID = 6197924159960077625L;
            public int length;
            public int location;
            public List<Integer> styleIds;

            public StyleRef() {
            }
        }

        public static final enum StyleType extends Enum<StyleType> {
            public static final StyleType CUSTOMIZE = null;
            public static final StyleType GRAMMAR = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ StyleType[] f448196a = null;
            private final int value;

            static {
                StyleType r100 = new StyleType("CUSTOMIZE", 0, 0);
                CUSTOMIZE = r100;
                StyleType r101 = new StyleType("GRAMMAR", 1, 1);
                GRAMMAR = r101;
                f448196a = new StyleType[]{r100, r101};
            }

            public static StyleType[] values() {
                return (StyleType[]) f448196a.clone();
            }

            public static StyleType forType(int r100) {
                if (r100 == 0) goto L10;
                if (r100 == 1) goto L8;
                return CUSTOMIZE;
            L8:
                return GRAMMAR;
            L10:
                return CUSTOMIZE;
            }

            public static StyleType valueOf(String r100) {
                return (StyleType) r27.a.a(StyleType.class, r100);
            }

            public static StyleType valueOf(int r100) {
                return forType(r100);
            }

            public StyleType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.language, this.content, this.styleRefList, this.styleList});
        }

        public CodeBlockProperty() {
            this.styleRefList = new ArrayList();
            this.styleList = new ArrayList();
        }

        public String getContent() {
            return this.content;
        }

        public Language getLanguage() {
            return this.language;
        }

        public List<Style> getStyleList() {
            return this.styleList;
        }

        public List<StyleRef> getStyleRefList() {
            return this.styleRefList;
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L24:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L24;
            if (super.equals(r100) == true) goto L13;
            return false;
        L13:
            CodeBlockProperty r101 = (CodeBlockProperty) r100;
            if (this.language == r101.language) goto L16;
        L22:
            return false;
        L16:
            if (Objects.equals(this.content, r101.content) == false) goto L22;
            if (Objects.equals(this.styleRefList, r101.styleRefList) == false) goto L22;
            if (Objects.equals(this.styleList, r101.styleList) == false) goto L22;
            return true;
        }

        public void setContent(String r100) {
            this.content = r100;
        }

        public void setLanguage(Language r100) {
            this.language = r100;
        }

        public void setStyleList(List<Style> r100) {
            this.styleList = r100;
        }

        public void setStyleRefList(List<StyleRef> r100) {
            this.styleRefList = r100;
        }
    }

    @JSONType(typeName = "CodeBlockV2Property")
    public static class CodeBlockV2Property extends RichTextProperty {
        private Language language;
        private List<LineContent> lineContents;
        private int version;
        private boolean wordWrap;

        public static final enum Language extends Enum<Language> {
            public static final Language ABAP = null;
            public static final Language ADA = null;
            public static final Language APACHE = null;
            public static final Language APEX = null;
            public static final Language ASSEMBLY = null;
            public static final Language BASH = null;
            public static final Language C = null;
            public static final Language CMAKE = null;
            public static final Language COBOL = null;
            public static final Language COFFEE_SCRIPT = null;
            public static final Language CPP = null;
            public static final Language CSS = null;
            public static final Language C_SHARP = null;
            public static final Language D = null;
            public static final Language DART = null;
            public static final Language DELPHI = null;
            public static final Language DIFF = null;
            public static final Language DJANGO = null;
            public static final Language DOCKER_FILE = null;
            public static final Language ERLANG = null;
            public static final Language FORTRAN = null;
            public static final Language GHERKIN = null;
            public static final Language GO = null;
            public static final Language GRAPHQL = null;
            public static final Language GROOVY = null;
            public static final Language HASKELL = null;
            public static final Language HTML = null;
            public static final Language HTMLBARS = null;
            public static final Language HTTP = null;
            public static final Language JAVA = null;
            public static final Language JAVASCRIPT = null;
            public static final Language JSON = null;
            public static final Language JULIA = null;
            public static final Language KOTLIN = null;
            public static final Language LATEX = null;
            public static final Language LISP = null;
            public static final Language LUA = null;
            public static final Language MAKEFILE = null;
            public static final Language MARKDOWN = null;
            public static final Language MATLAB = null;
            public static final Language NGINX = null;
            public static final Language OBJECTIVE_C = null;
            public static final Language OPENGL_SHADING_LANGUAGE = null;
            public static final Language PERL = null;
            public static final Language PHP = null;
            public static final Language PLAIN_TEXT = null;
            public static final Language POWERSHELL = null;
            public static final Language PROLOG = null;
            public static final Language PROPERTIES = null;
            public static final Language PROTOBUF = null;
            public static final Language PYTHON = null;
            public static final Language R = null;
            public static final Language RUBY = null;
            public static final Language RUST = null;
            public static final Language SAS = null;
            public static final Language SCALA = null;
            public static final Language SCHEME = null;
            public static final Language SCSS = null;
            public static final Language SHELL = null;
            public static final Language SOLIDITY = null;
            public static final Language SQL = null;
            public static final Language SWIFT = null;
            public static final Language THRIFT = null;
            public static final Language TOML = null;
            public static final Language TYPESCRIPT = null;
            public static final Language VBSCRIPT = null;
            public static final Language VISUAL_BASIC = null;
            public static final Language XML = null;
            public static final Language YAML = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Language[] f448197a = null;
            private final int value;

            static {
                Language r100 = new Language("PLAIN_TEXT", 0, 0);
                PLAIN_TEXT = r100;
                Language r101 = new Language("ABAP", 1, 1);
                ABAP = r101;
                Language r102 = new Language("ADA", 2, 2);
                ADA = r102;
                Language r103 = new Language("APACHE", 3, 3);
                APACHE = r103;
                Language r104 = new Language("APEX", 4, 4);
                APEX = r104;
                Language r105 = new Language("ASSEMBLY", 5, 5);
                ASSEMBLY = r105;
                Language r110 = new Language("BASH", 6, 6);
                BASH = r110;
                Language r111 = new Language("C_SHARP", 7, 7);
                C_SHARP = r111;
                Language r112 = new Language("CPP", 8, 8);
                CPP = r112;
                Language r113 = new Language("C", 9, 9);
                C = r113;
                Language r114 = new Language("CMAKE", 10, 10);
                CMAKE = r114;
                Language r115 = new Language("COBOL", 11, 11);
                COBOL = r115;
                Language r106 = new Language("CSS", 12, 12);
                CSS = r106;
                Language r107 = new Language("COFFEE_SCRIPT", 13, 13);
                COFFEE_SCRIPT = r107;
                Language r108 = new Language("D", 14, 14);
                D = r108;
                Language r109 = new Language("DART", 15, 15);
                DART = r109;
                Language r116 = new Language("DELPHI", 16, 16);
                DELPHI = r116;
                Language r117 = new Language("DIFF", 17, 17);
                DIFF = r117;
                Language r118 = new Language("DJANGO", 18, 18);
                DJANGO = r118;
                Language r119 = new Language("DOCKER_FILE", 19, 19);
                DOCKER_FILE = r119;
                Language r120 = new Language("ERLANG", 20, 20);
                ERLANG = r120;
                Language r121 = new Language("FORTRAN", 21, 21);
                FORTRAN = r121;
                Language r122 = new Language("GHERKIN", 22, 22);
                GHERKIN = r122;
                Language r123 = new Language("GO", 23, 23);
                GO = r123;
                Language r124 = new Language("GRAPHQL", 24, 24);
                GRAPHQL = r124;
                Language r125 = new Language("GROOVY", 25, 25);
                GROOVY = r125;
                Language r126 = new Language("HTML", 26, 26);
                HTML = r126;
                Language r127 = new Language("HTMLBARS", 27, 27);
                HTMLBARS = r127;
                Language r128 = new Language("HTTP", 28, 28);
                HTTP = r128;
                Language r129 = new Language("HASKELL", 29, 29);
                HASKELL = r129;
                Language r130 = new Language("JSON", 30, 30);
                JSON = r130;
                Language r131 = new Language("JAVA", 31, 31);
                JAVA = r131;
                Language r132 = new Language("JAVASCRIPT", 32, 32);
                JAVASCRIPT = r132;
                Language r133 = new Language("JULIA", 33, 33);
                JULIA = r133;
                Language r134 = new Language("KOTLIN", 34, 34);
                KOTLIN = r134;
                Language r135 = new Language("LATEX", 35, 35);
                LATEX = r135;
                Language r136 = new Language("LISP", 36, 36);
                LISP = r136;
                Language r137 = new Language("LUA", 37, 37);
                LUA = r137;
                Language r138 = new Language("MATLAB", 38, 38);
                MATLAB = r138;
                Language r139 = new Language("MAKEFILE", 39, 39);
                MAKEFILE = r139;
                Language r140 = new Language("MARKDOWN", 40, 40);
                MARKDOWN = r140;
                Language r141 = new Language("NGINX", 41, 41);
                NGINX = r141;
                Language r142 = new Language("OBJECTIVE_C", 42, 42);
                OBJECTIVE_C = r142;
                Language r143 = new Language("OPENGL_SHADING_LANGUAGE", 43, 43);
                OPENGL_SHADING_LANGUAGE = r143;
                Language r144 = new Language("PHP", 44, 44);
                PHP = r144;
                Language r145 = new Language("PERL", 45, 45);
                PERL = r145;
                Language r146 = new Language("POWERSHELL", 46, 46);
                POWERSHELL = r146;
                Language r147 = new Language("PROLOG", 47, 47);
                PROLOG = r147;
                Language r148 = new Language("PROPERTIES", 48, 48);
                PROPERTIES = r148;
                Language r149 = new Language("PROTOBUF", 49, 49);
                PROTOBUF = r149;
                Language r150 = new Language("PYTHON", 50, 50);
                PYTHON = r150;
                Language r151 = new Language("R", 51, 51);
                R = r151;
                Language r152 = new Language("RUBY", 52, 52);
                RUBY = r152;
                Language r153 = new Language("RUST", 53, 53);
                RUST = r153;
                Language r154 = new Language("SAS", 54, 54);
                SAS = r154;
                Language r155 = new Language("SCSS", 55, 55);
                SCSS = r155;
                Language r156 = new Language("SQL", 56, 56);
                SQL = r156;
                Language r157 = new Language("SCALA", 57, 57);
                SCALA = r157;
                Language r158 = new Language("SCHEME", 58, 58);
                SCHEME = r158;
                Language r159 = new Language("SHELL", 59, 59);
                SHELL = r159;
                Language r160 = new Language("SOLIDITY", 60, 60);
                SOLIDITY = r160;
                Language r161 = new Language("SWIFT", 61, 61);
                SWIFT = r161;
                Language r162 = new Language("TOML", 62, 62);
                TOML = r162;
                Language r163 = new Language("THRIFT", 63, 63);
                THRIFT = r163;
                Language r164 = new Language("TYPESCRIPT", 64, 64);
                TYPESCRIPT = r164;
                Language r165 = new Language("VBSCRIPT", 65, 65);
                VBSCRIPT = r165;
                Language r166 = new Language("VISUAL_BASIC", 66, 66);
                VISUAL_BASIC = r166;
                Language r167 = new Language("XML", 67, 67);
                XML = r167;
                Language r168 = new Language("YAML", 68, 68);
                YAML = r168;
                f448197a = new Language[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168};
            }

            public static Language[] values() {
                return (Language[]) f448197a.clone();
            }

            public int getNumber() {
                return this.value;
            }

            public static Language forType(int r100) {
                Language[] r101 = values();
                int r102 = r101.length;
                int r103 = 0;
            L3:
                if (r103 >= r102) goto L9;
                Language r104 = r101[r103];
                if (r104.value == r100) goto L6;
                r103 = r103 + 1;
                goto L3
            L6:
                return r104;
            L9:
                return PLAIN_TEXT;
            }

            public static Language fromValue(int r100) {
                return forType(r100);
            }

            public static Language valueOf(String r100) {
                return (Language) r27.a.a(Language.class, r100);
            }

            public Language(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public int hashCode() {
            return Objects.hash(new Object[]{this.language, this.lineContents, Boolean.valueOf(this.wordWrap), Integer.valueOf(this.version)});
        }

        public CodeBlockV2Property() {
        }

        public Language getLanguage() {
            return this.language;
        }

        public List<LineContent> getLineContents() {
            return this.lineContents;
        }

        public int getVersion() {
            return this.version;
        }

        public boolean isWordWrap() {
            return this.wordWrap;
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof CodeBlockV2Property) == true) goto L9;
            return false;
        L9:
            if (super.equals(r100) == true) goto L11;
            return false;
        L11:
            CodeBlockV2Property r101 = (CodeBlockV2Property) r100;
            if (Objects.equals(this.language, r101.language) == true) goto L14;
        L20:
            return false;
        L14:
            if (Objects.equals(this.lineContents, r101.lineContents) == false) goto L20;
            if (this.wordWrap != r101.wordWrap) goto L20;
            if (this.version != r101.version) goto L20;
            return true;
        }

        public void setLanguage(Language r100) {
            this.language = r100;
        }

        public void setLineContents(List<LineContent> r100) {
            if (r100 != null) goto L4;
            ArrayList r101 = null;
        L5:
            this.lineContents = r101;
            return;
        L4:
            r101 = new ArrayList(r100);
            goto L5
        }

        public void setVersion(int r100) {
            this.version = r100;
        }

        public void setWordWrap(boolean r100) {
            this.wordWrap = r100;
        }
    }

    @JSONType(typeName = "CodeProperty")
    public static class CodeProperty extends RichTextProperty {
        private static final long serialVersionUID = 7115342752232691940L;

        public CodeProperty() {
        }
    }

    @JSONType(typeName = "ColumnProperty")
    public static class ColumnProperty extends RichTextProperty {
        private int width;

        public ColumnProperty() {
        }

        public int getWidth() {
            return this.width;
        }

        public void setWidth(int r100) {
            this.width = r100;
        }
    }

    @JSONType(typeName = "ColumnsProperty")
    public static class ColumnsProperty extends RichTextProperty {
        public ColumnsProperty() {
        }
    }

    public static class ConfirmProperty implements Serializable {
        private String confirm;
        private String confirmI18NKey;
        private String dismiss;
        private String dismissI18NKey;
        private String text;
        private String textI18NKey;
        private String title;
        private String titleI18NKey;

        public ConfirmProperty() {
        }

        public int hashCode() {
            String r100 = this.title;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.text;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.confirm;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.dismiss;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.titleI18NKey;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.textI18NKey;
            if (r116 == null) goto L25;
            int r117 = r116.hashCode();
        L26:
            int r118 = (r115 + r117) * 31;
            String r119 = this.confirmI18NKey;
            if (r119 == null) goto L29;
            int r120 = r119.hashCode();
        L30:
            int r121 = (r118 + r120) * 31;
            String r122 = this.dismissI18NKey;
            if (r122 == null) goto L34;
            r101 = r122.hashCode();
        L34:
            return r121 + r101;
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public String getConfirm() {
            return this.confirm;
        }

        public String getConfirmI18NKey() {
            return this.confirmI18NKey;
        }

        public String getDismiss() {
            return this.dismiss;
        }

        public String getDismissI18NKey() {
            return this.dismissI18NKey;
        }

        public String getText() {
            return this.text;
        }

        public String getTextI18NKey() {
            return this.textI18NKey;
        }

        public String getTitle() {
            return this.title;
        }

        public String getTitleI18NKey() {
            return this.titleI18NKey;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L33:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L33;
            ConfirmProperty r101 = (ConfirmProperty) r100;
            if (Objects.equals(this.title, r101.title) == true) goto L14;
            return false;
        L14:
            if (Objects.equals(this.text, r101.text) == true) goto L17;
            return false;
        L17:
            if (Objects.equals(this.confirm, r101.confirm) == true) goto L20;
            return false;
        L20:
            if (Objects.equals(this.dismiss, r101.dismiss) == true) goto L23;
            return false;
        L23:
            if (Objects.equals(this.titleI18NKey, r101.titleI18NKey) == true) goto L26;
            return false;
        L26:
            if (Objects.equals(this.textI18NKey, r101.textI18NKey) == true) goto L29;
            return false;
        L29:
            if (Objects.equals(this.confirmI18NKey, r101.confirmI18NKey) == true) goto L32;
            return false;
        L32:
            return Objects.equals(this.dismissI18NKey, r101.dismissI18NKey);
        }

        public void setConfirm(String r100) {
            this.confirm = r100;
        }

        public void setConfirmI18NKey(String r100) {
            this.confirmI18NKey = r100;
        }

        public void setDismiss(String r100) {
            this.dismiss = r100;
        }

        public void setDismissI18NKey(String r100) {
            this.dismissI18NKey = r100;
        }

        public void setText(String r100) {
            this.text = r100;
        }

        public void setTextI18NKey(String r100) {
            this.textI18NKey = r100;
        }

        public void setTitle(String r100) {
            this.title = r100;
        }

        public void setTitleI18NKey(String r100) {
            this.titleI18NKey = r100;
        }
    }

    @JSONType(typeName = "DashedProperty")
    public static class DashedProperty extends TextProperty {
        public String chatId;
        public String fullName;
        public String i18nDesc;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f448198id;
        public int intervalOff;
        public int intervalOn;
        public String messageId;
        public String name;
        public int version;

        public DashedProperty() {
        }
    }

    @JSONType(typeName = "DashedPropertyV2")
    public static class DashedPropertyV2 extends TextProperty {
        public String chatId;
        public int intervalOff;
        public int intervalOn;
        public String messageId;
        public List<PropertyV2> propertyV2List;

        public static class PropertyV2 implements Serializable {
            public int end;

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            public String f448199id;
            public String name;
            public int start;

            public PropertyV2() {
            }

            public int hashCode() {
                return Objects.hash(new Object[]{this.f448199id, Integer.valueOf(this.start), Integer.valueOf(this.end), this.name});
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if (r100 != null) goto L8;
            L21:
                return false;
            L8:
                if (getClass() != r100.getClass()) goto L21;
                PropertyV2 r101 = (PropertyV2) r100;
                if (this.start == r101.start) goto L13;
            L19:
                return false;
            L13:
                if (this.end != r101.end) goto L19;
                if (Objects.equals(this.f448199id, r101.f448199id) == false) goto L19;
                if (Objects.equals(this.name, r101.name) == false) goto L19;
                return true;
            }
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.TextProperty, com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.messageId, this.chatId, Integer.valueOf(this.intervalOn), Integer.valueOf(this.intervalOff), this.propertyV2List});
        }

        public DashedPropertyV2() {
            this.propertyV2List = new ArrayList();
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.TextProperty, com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L26:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L26;
            if (super.equals(r100) == true) goto L13;
            return false;
        L13:
            DashedPropertyV2 r101 = (DashedPropertyV2) r100;
            if (this.intervalOn == r101.intervalOn) goto L16;
        L24:
            return false;
        L16:
            if (this.intervalOff != r101.intervalOff) goto L24;
            if (Objects.equals(this.messageId, r101.messageId) == false) goto L24;
            if (Objects.equals(this.chatId, r101.chatId) == false) goto L24;
            if (Objects.equals(this.propertyV2List, r101.propertyV2List) == false) goto L24;
            return true;
        }
    }

    @JSONType(typeName = "DatePickerProperty")
    public static class DatePickerProperty extends RichTextProperty {
        private String actionId;
        private ConfirmProperty confirm;
        private boolean disable;
        private String initialDate;
        private boolean isLoading;
        private String placeHolder;
        private String placeHolderI18nKey;

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public int hashCode() {
            return Objects.hash(new Object[]{this.actionId, this.placeHolder, this.placeHolderI18nKey, this.initialDate, this.confirm, Boolean.valueOf(this.disable), Boolean.valueOf(this.isLoading)});
        }

        public DatePickerProperty() {
        }

        public String getActionId() {
            return this.actionId;
        }

        public ConfirmProperty getConfirm() {
            return this.confirm;
        }

        public String getInitialDate() {
            return this.initialDate;
        }

        public String getPlaceHolder() {
            return this.placeHolder;
        }

        public String getPlaceHolderI18nKey() {
            return this.placeHolderI18nKey;
        }

        public boolean isDisable() {
            return this.disable;
        }

        public boolean isLoading() {
            return this.isLoading;
        }

        public static /* synthetic */ boolean access$000(DatePickerProperty r100) {
            return r100.disable;
        }

        public static /* synthetic */ boolean access$100(DatePickerProperty r100) {
            return r100.isLoading;
        }

        public static /* synthetic */ String access$200(DatePickerProperty r100) {
            return r100.actionId;
        }

        public static /* synthetic */ String access$300(DatePickerProperty r100) {
            return r100.placeHolder;
        }

        public static /* synthetic */ String access$400(DatePickerProperty r100) {
            return r100.placeHolderI18nKey;
        }

        public static /* synthetic */ String access$500(DatePickerProperty r100) {
            return r100.initialDate;
        }

        public static /* synthetic */ ConfirmProperty access$600(DatePickerProperty r100) {
            return r100.confirm;
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L30:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L30;
            if (super.equals(r100) == true) goto L13;
            return false;
        L13:
            DatePickerProperty r101 = (DatePickerProperty) r100;
            if (this.disable == r101.disable) goto L16;
        L28:
            return false;
        L16:
            if (this.isLoading != r101.isLoading) goto L28;
            if (Objects.equals(this.actionId, r101.actionId) == false) goto L28;
            if (Objects.equals(this.placeHolder, r101.placeHolder) == false) goto L28;
            if (Objects.equals(this.placeHolderI18nKey, r101.placeHolderI18nKey) == false) goto L28;
            if (Objects.equals(this.initialDate, r101.initialDate) == false) goto L28;
            if (Objects.equals(this.confirm, r101.confirm) == false) goto L28;
            return true;
        }

        public void setActionId(String r100) {
            this.actionId = r100;
        }

        public void setConfirm(ConfirmProperty r100) {
            this.confirm = r100;
        }

        public void setDisable(boolean r100) {
            this.disable = r100;
        }

        public void setInitialDate(String r100) {
            this.initialDate = r100;
        }

        public void setLoading(boolean r100) {
            this.isLoading = r100;
        }

        public void setPlaceHolder(String r100) {
            this.placeHolder = r100;
        }

        public void setPlaceHolderI18nKey(String r100) {
            this.placeHolderI18nKey = r100;
        }
    }

    @JSONType(typeName = "DateTimePickerProperty")
    public static class DateTimePickerProperty extends RichTextProperty {
        private String actionId;
        private ConfirmProperty confirm;
        private boolean disable;
        private String initialDateTime;
        private boolean isLoading;
        private String placeHolder;
        private String placeHolderI18nKey;

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public int hashCode() {
            return Objects.hash(new Object[]{this.actionId, this.placeHolder, this.placeHolderI18nKey, this.initialDateTime, this.confirm, Boolean.valueOf(this.disable), Boolean.valueOf(this.isLoading)});
        }

        public DateTimePickerProperty() {
        }

        public String getActionId() {
            return this.actionId;
        }

        public ConfirmProperty getConfirm() {
            return this.confirm;
        }

        public String getInitialDateTime() {
            return this.initialDateTime;
        }

        public String getPlaceHolder() {
            return this.placeHolder;
        }

        public String getPlaceHolderI18nKey() {
            return this.placeHolderI18nKey;
        }

        public boolean isDisable() {
            return this.disable;
        }

        public boolean isLoading() {
            return this.isLoading;
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L30:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L30;
            if (super.equals(r100) == true) goto L13;
            return false;
        L13:
            DatePickerProperty r101 = (DatePickerProperty) r100;
            if (this.disable == DatePickerProperty.access$000(r101)) goto L16;
        L28:
            return false;
        L16:
            if (this.isLoading != DatePickerProperty.access$100(r101)) goto L28;
            if (Objects.equals(this.actionId, DatePickerProperty.access$200(r101)) == false) goto L28;
            if (Objects.equals(this.placeHolder, DatePickerProperty.access$300(r101)) == false) goto L28;
            if (Objects.equals(this.placeHolderI18nKey, DatePickerProperty.access$400(r101)) == false) goto L28;
            if (Objects.equals(this.initialDateTime, DatePickerProperty.access$500(r101)) == false) goto L28;
            if (Objects.equals(this.confirm, DatePickerProperty.access$600(r101)) == false) goto L28;
            return true;
        }

        public void setActionId(String r100) {
            this.actionId = r100;
        }

        public void setConfirm(ConfirmProperty r100) {
            this.confirm = r100;
        }

        public void setDisable(boolean r100) {
            this.disable = r100;
        }

        public void setInitialDateTime(String r100) {
            this.initialDateTime = r100;
        }

        public void setLoading(boolean r100) {
            this.isLoading = r100;
        }

        public void setPlaceHolder(String r100) {
            this.placeHolder = r100;
        }

        public void setPlaceHolderI18nKey(String r100) {
            this.placeHolderI18nKey = r100;
        }
    }

    @JSONType(typeName = "DivProperty")
    public static class DivProperty extends RichTextProperty {
        public DivProperty() {
        }
    }

    @JSONType(typeName = "DocsProperty")
    public static class DocsProperty extends RichTextProperty {
        private static final long serialVersionUID = -4610601462567735579L;

        public DocsProperty() {
        }
    }

    @JSONType(typeName = "EmotionProperty")
    public static class EmotionProperty extends RichTextProperty {
        private String key;

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public int hashCode() {
            String r100 = this.key;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public EmotionProperty() {
        }

        public String getKey() {
            return this.key;
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L20:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L20;
            if (super.equals(r100) == true) goto L13;
            return false;
        L13:
            String r101 = this.key;
            String r102 = ((EmotionProperty) r100).key;
            if (r101 != null) goto L21;
            if (r102 == null) goto L22;
            return false;
        L22:
            return true;
        L21:
            return r101.equals(r102);
        }

        public void setKey(String r100) {
            this.key = r100;
        }
    }

    @JSONType(typeName = "FigureProperty")
    public static class FigureProperty extends RichTextProperty {
        public FigureProperty() {
        }
    }

    @JSONType(typeName = "H1Property")
    public static class H1Property extends RichTextProperty {
        private static final long serialVersionUID = -7221270240730274325L;

        public H1Property() {
        }
    }

    @JSONType(typeName = "H2Property")
    public static class H2Property extends RichTextProperty {
        private static final long serialVersionUID = 5320596073649453277L;

        public H2Property() {
        }
    }

    @JSONType(typeName = "H3Property")
    public static class H3Property extends RichTextProperty {
        private static final long serialVersionUID = -4119339019463435961L;

        public H3Property() {
        }
    }

    @JSONType(typeName = "H4Property")
    public static class H4Property extends RichTextProperty {
        private static final long serialVersionUID = -3129389019463435997L;

        public H4Property() {
        }
    }

    @JSONType(typeName = "H5Property")
    public static class H5Property extends RichTextProperty {
        private static final long serialVersionUID = 6670596073649456993L;

        public H5Property() {
        }
    }

    @JSONType(typeName = "H6Property")
    public static class H6Property extends RichTextProperty {
        private static final long serialVersionUID = 5597906073671370397L;

        public H6Property() {
        }
    }

    @JSONType(typeName = "HRProperty")
    public static class HRProperty extends RichTextProperty {
        private static final long serialVersionUID = -2289408225683192912L;

        public HRProperty() {
        }
    }

    public static class ImageGalleryProperty extends RichTextProperty {
        public ImageGalleryProperty() {
        }
    }

    @JSONType(typeName = "ImageProperty")
    public static class ImageProperty extends RichTextProperty {
        private String alt;
        private String altI18nKey;

        @JSONField(serialize = false)
        private ByteString crypto;
        private int customWidth;
        private String fsUnit;
        private int height;
        private boolean imgCanPreview;

        @JSONField(serialize = false)
        private ByteString inlinePreview;
        private String intactKey;
        private boolean isOriginSource;
        private Image middleImage;
        private String middleKey;
        private boolean needCopy;
        private int originHeight;
        private String originKey;
        private long originSize;
        private int originWidth;
        private ResourceCleanScene resourceCleanScene;
        private String resourceMsgLinkToken;
        private String resourcePreviewToken;
        private int showMode;
        private Image thumbImage;
        private String thumbKey;
        private String token;
        private List<String> urls;
        private int width;

        public ByteString getCrypto() {
            ByteString r100 = this.crypto;
            if (r100 == null) goto L5;
            return r100;
        L5:
            Image r101 = this.middleImage;
            if (r101 != null) goto L8;
        L11:
            Image r102 = this.thumbImage;
            if (r102 == null) goto L17;
            if (r102.getCrypto() == null) goto L17;
            this.crypto = this.thumbImage.getCrypto();
        L17:
            return this.crypto;
        L8:
            if (r101.getCrypto() == null) goto L11;
            ByteString r103 = this.middleImage.getCrypto();
            this.crypto = r103;
            return r103;
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public int hashCode() {
            List<String> r100 = this.urls;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.token;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.originKey;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (((((r106 + r108) * 31) + this.originWidth) * 31) + this.originHeight) * 31;
            String r110 = this.resourcePreviewToken;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            ResourceCleanScene r113 = this.resourceCleanScene;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.resourceMsgLinkToken;
            if (r116 == null) goto L26;
            r101 = r116.hashCode();
        L26:
            return r115 + r101;
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public ImageProperty() {
            this.needCopy = false;
            this.resourceCleanScene = null;
        }

        public String getAlt() {
            return this.alt;
        }

        public String getAltI18nKey() {
            return this.altI18nKey;
        }

        public int getCustomWidth() {
            return this.customWidth;
        }

        public String getFsUnit() {
            return this.fsUnit;
        }

        public int getHeight() {
            return this.height;
        }

        public ByteString getInlinePreview() {
            return this.inlinePreview;
        }

        public String getIntactKey() {
            return this.intactKey;
        }

        public Image getMiddleImage() {
            return this.middleImage;
        }

        public String getMiddleKey() {
            return this.middleKey;
        }

        public int getOriginHeight() {
            return this.originHeight;
        }

        public String getOriginKey() {
            return this.originKey;
        }

        public long getOriginSize() {
            return this.originSize;
        }

        public int getOriginWidth() {
            return this.originWidth;
        }

        public ResourceCleanScene getResourceCleanScene() {
            return this.resourceCleanScene;
        }

        public String getResourceMsgLinkToken() {
            return this.resourceMsgLinkToken;
        }

        public String getResourcePreviewToken() {
            return this.resourcePreviewToken;
        }

        public int getShowMode() {
            return this.showMode;
        }

        public Image getThumbImage() {
            return this.thumbImage;
        }

        public String getThumbKey() {
            return this.thumbKey;
        }

        public String getToken() {
            return this.token;
        }

        public List<String> getUrls() {
            return this.urls;
        }

        public int getWidth() {
            return this.width;
        }

        public boolean isImgCanPreview() {
            return this.imgCanPreview;
        }

        public boolean isNeedCopy() {
            return this.needCopy;
        }

        public boolean isOriginSource() {
            return this.isOriginSource;
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ImageProperty) == true) goto L9;
            return false;
        L9:
            if (super.equals(r100) == true) goto L11;
            return false;
        L11:
            ImageProperty r101 = (ImageProperty) r100;
            if (this.originWidth == r101.originWidth) goto L15;
            return false;
        L15:
            if (this.originHeight == r101.originHeight) goto L17;
            return false;
        L17:
            List<String> r102 = this.urls;
            if (r102 == null) goto L23;
            if (r102.equals(r101.urls) == false) goto L24;
        L25:
            String r103 = this.token;
            if (r103 == null) goto L31;
            if (r103.equals(r101.token) == true) goto L34;
        L32:
            return false;
        L34:
            if (Objects.equals(this.resourcePreviewToken, r101.resourcePreviewToken) == true) goto L37;
            return false;
        L37:
            if (Objects.equals(this.resourceCleanScene, r101.resourceCleanScene) == true) goto L40;
            return false;
        L40:
            if (Objects.equals(this.resourceMsgLinkToken, r101.resourceMsgLinkToken) == true) goto L42;
            return false;
        L42:
            String r104 = this.originKey;
            String r105 = r101.originKey;
            if (r104 != null) goto L49;
            if (r105 == null) goto L50;
            return false;
        L50:
            return true;
        L49:
            return r104.equals(r105);
        L31:
            if (r101.token == null) goto L34;
        L24:
            return false;
        L23:
            if (r101.urls == null) goto L25;
            goto L24
        }

        public void setAlt(String r100) {
            this.alt = r100;
        }

        public void setAltI18nKey(String r100) {
            this.altI18nKey = r100;
        }

        public void setCrypto(ByteString r100) {
            this.crypto = r100;
        }

        public void setCustomWidth(int r100) {
            this.customWidth = r100;
        }

        public void setFsUnit(String r100) {
            this.fsUnit = r100;
        }

        public void setHeight(int r100) {
            this.height = r100;
        }

        public void setImgCanPreview(boolean r100) {
            this.imgCanPreview = r100;
        }

        public void setInlinePreview(ByteString r100) {
            this.inlinePreview = r100;
        }

        public void setIntactKey(String r100) {
            this.intactKey = r100;
        }

        public void setMiddleImage(Image r100) {
            this.middleImage = r100;
        }

        public void setMiddleKey(String r100) {
            this.middleKey = r100;
        }

        public void setNeedCopy(boolean r100) {
            this.needCopy = r100;
        }

        public void setOriginHeight(int r100) {
            this.originHeight = r100;
        }

        public void setOriginKey(String r100) {
            this.originKey = r100;
        }

        public void setOriginSize(long r100) {
            this.originSize = r100;
        }

        public void setOriginSource(boolean r100) {
            this.isOriginSource = r100;
        }

        public void setOriginWidth(int r100) {
            this.originWidth = r100;
        }

        public void setResourceCleanScene(ResourceCleanScene r100) {
            this.resourceCleanScene = r100;
        }

        public void setResourceMsgLinkToken(String r100) {
            this.resourceMsgLinkToken = r100;
        }

        public void setResourcePreviewToken(String r100) {
            this.resourcePreviewToken = r100;
        }

        public void setShowMode(int r100) {
            this.showMode = r100;
        }

        public void setThumbImage(Image r100) {
            this.thumbImage = r100;
        }

        public void setThumbKey(String r100) {
            this.thumbKey = r100;
        }

        public void setToken(String r100) {
            this.token = r100;
        }

        public void setUrls(List<String> r100) {
            this.urls = new ArrayList(r100);
        }

        public void setWidth(int r100) {
            this.width = r100;
        }
    }

    @JSONType(typeName = "IntentionDashedProperty")
    public static class IntentionDashedProperty extends TextProperty {
        public String chatId;
        public List<String> chatterIds;
        public long duration;
        public long endTime;
        public boolean isAtAll;
        public boolean isMetting;
        public String messageId;
        public long startTime;
        public String title;

        public IntentionDashedProperty() {
        }
    }

    @JSONType(typeName = "ItalicProperty")
    public static class ItalicProperty extends TextProperty {
        public ItalicProperty() {
        }
    }

    @JSONType(typeName = "LIProperty")
    public static class LIProperty extends RichTextProperty {
        private static final long serialVersionUID = 560963231881508837L;
        private int floor;
        private String listNum;

        public LIProperty() {
            this.listNum = "";
            this.floor = 0;
        }

        public int getFloor() {
            return this.floor;
        }

        public String getListNum() {
            return this.listNum;
        }

        public void setFloor(int r100) {
            this.floor = r100;
        }

        public void setListNum(String r100) {
            this.listNum = r100;
        }
    }

    @JSONType(typeName = "LinkProperty")
    public static class LinkProperty extends RichTextProperty {
        private String androidUrl;
        private Source source;
        private String url;

        public static final enum Source extends Enum<Source> {
            public static final Source CARD_LINK = null;
            public static final Source CONTENT_LINK = null;
            public static final Source FOOTER_LINK = null;
            public static final Source UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Source[] f448200a = null;
            private final int value;

            static {
                Source r100 = new Source("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Source r101 = new Source("CARD_LINK", 1, 1);
                CARD_LINK = r101;
                Source r102 = new Source("CONTENT_LINK", 2, 2);
                CONTENT_LINK = r102;
                Source r103 = new Source("FOOTER_LINK", 3, 3);
                FOOTER_LINK = r103;
                f448200a = new Source[]{r100, r101, r102, r103};
            }

            public static Source[] values() {
                return (Source[]) f448200a.clone();
            }

            public int getNumber() {
                return this.value;
            }

            public static Source valueOf(int r100) {
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L13;
                if (r100 == 3) goto L11;
                return UNKNOWN;
            L11:
                return FOOTER_LINK;
            L13:
                return CONTENT_LINK;
            L15:
                return CARD_LINK;
            }

            public static Source valueOf(String r100) {
                return (Source) r27.a.a(Source.class, r100);
            }

            public Source(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public int hashCode() {
            String r100 = this.url;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.androidUrl;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public LinkProperty() {
        }

        public String getAndroidUrl() {
            return this.androidUrl;
        }

        public Source getSource() {
            return this.source;
        }

        public String getUrl() {
            return this.url;
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L31:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L31;
            if (super.equals(r100) == true) goto L13;
            return false;
        L13:
            LinkProperty r101 = (LinkProperty) r100;
            if (Objects.equals(this.source, r101.source) == true) goto L16;
            return false;
        L16:
            String r102 = this.url;
            if (r102 == null) goto L22;
            if (r102.equals(r101.url) == false) goto L23;
        L24:
            String r103 = this.androidUrl;
            String r104 = r101.androidUrl;
            if (r103 != null) goto L32;
            if (r104 == null) goto L33;
            return false;
        L33:
            return true;
        L32:
            return r103.equals(r104);
        L23:
            return false;
        L22:
            if (r101.url == null) goto L24;
            goto L23
        }

        public void setAndroidUrl(String r100) {
            this.androidUrl = r100;
        }

        public void setSource(Source r100) {
            this.source = r100;
        }

        public void setUrl(String r100) {
            this.url = r100;
        }
    }

    @JSONType(typeName = "MarkdownProperty")
    public static class MarkdownProperty extends RichTextProperty {
        private ArrayList<Long> atUserIds;
        private HashMap<String, AtProperty> atUsers;
        private String content;
        private HashMap<String, MarkdownImageSet> images;
        private boolean isAtAll;

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public int hashCode() {
            return Objects.hash(new Object[]{this.content, this.images, this.atUserIds, Boolean.valueOf(this.isAtAll), this.atUsers});
        }

        public MarkdownProperty() {
        }

        public List<Long> getAtUserIds() {
            return this.atUserIds;
        }

        public Map<String, AtProperty> getAtUsers() {
            return this.atUsers;
        }

        public String getContent() {
            return this.content;
        }

        public Map<String, MarkdownImageSet> getImages() {
            return this.images;
        }

        public boolean isAtAll() {
            return this.isAtAll;
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L23:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L23;
            MarkdownProperty r101 = (MarkdownProperty) r100;
            if (this.isAtAll == r101.isAtAll) goto L13;
        L21:
            return false;
        L13:
            if (Objects.equals(this.content, r101.content) == false) goto L21;
            if (Objects.equals(this.images, r101.images) == false) goto L21;
            if (Objects.equals(this.atUserIds, r101.atUserIds) == false) goto L21;
            if (Objects.equals(this.atUsers, r101.atUsers) == false) goto L21;
            return true;
        }

        public void setAtAll(boolean r100) {
            this.isAtAll = r100;
        }

        public void setAtUserIds(List<Long> r100) {
            if (r100 != null) goto L4;
            ArrayList<Long> r101 = null;
        L5:
            this.atUserIds = r101;
            return;
        L4:
            r101 = new ArrayList(r100);
            goto L5
        }

        public void setAtUsers(Map<String, AtProperty> r100) {
            if (r100 != null) goto L4;
            HashMap<String, AtProperty> r101 = null;
        L5:
            this.atUsers = r101;
            return;
        L4:
            r101 = new HashMap(r100);
            goto L5
        }

        public void setContent(String r100) {
            this.content = r100;
        }

        public void setImages(Map<String, MarkdownImageSet> r100) {
            if (r100 != null) goto L4;
            HashMap<String, MarkdownImageSet> r101 = null;
        L5:
            this.images = r101;
            return;
        L4:
            r101 = new HashMap(r100);
            goto L5
        }
    }

    @JSONType(typeName = "MediaProperty")
    public static class MediaProperty extends RichTextProperty {
        private String compressPath;
        private String coverPath;

        @JSONField(serialize = false)
        private ByteString crypto;
        private String cryptoToken;
        private int duration;
        private String fsUnit;
        private int height;
        private String imageSetKey;
        private String imageUploadId;
        private String key;
        private String mediaUploadId;
        private String mime;
        private String name;
        private boolean needCopy;
        private Image originImage;
        private String originPath;
        private ResourceCleanScene resourceCleanScene;
        private String resourceMsgLinkToken;
        private String resourcePreviewToken;
        private long size;
        private Source source;
        private Image thumbImage;
        private String url;
        private int width;

        public static final enum Source extends Enum<Source> {
            public static final Source LARK = null;
            public static final Source UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Source[] f448201a = null;
            private final int value;

            static {
                Source r100 = new Source("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Source r101 = new Source(AccountType.LARK, 1, 1);
                LARK = r101;
                f448201a = new Source[]{r100, r101};
            }

            public static Source[] values() {
                return (Source[]) f448201a.clone();
            }

            public int getNumber() {
                return this.value;
            }

            public static Source forNumber(int r100) {
                if (r100 == 0) goto L10;
                if (r100 == 1) goto L8;
                return UNKNOWN;
            L8:
                return LARK;
            L10:
                return UNKNOWN;
            }

            public static Source valueOf(String r100) {
                return (Source) r27.a.a(Source.class, r100);
            }

            public static Source valueOf(int r100) {
                return forNumber(r100);
            }

            public Source(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public MediaProperty copyInstance() {
            MediaProperty r100 = new MediaProperty();
            r100.key = this.key;
            r100.name = this.name;
            r100.size = this.size;
            r100.mime = this.mime;
            r100.source = this.source;
            r100.originImage = this.originImage;
            r100.thumbImage = this.thumbImage;
            r100.duration = this.duration;
            r100.url = this.url;
            r100.originPath = this.originPath;
            r100.compressPath = this.compressPath;
            r100.mediaUploadId = this.mediaUploadId;
            r100.imageUploadId = this.imageUploadId;
            r100.cryptoToken = this.cryptoToken;
            r100.width = this.width;
            r100.height = this.height;
            r100.coverPath = this.coverPath;
            r100.imageSetKey = this.imageSetKey;
            r100.fsUnit = this.fsUnit;
            r100.crypto = this.crypto;
            r100.resourcePreviewToken = this.resourcePreviewToken;
            r100.resourceCleanScene = this.resourceCleanScene;
            r100.resourceMsgLinkToken = this.resourceMsgLinkToken;
            return r100;
        }

        public ByteString getCrypto() {
            ByteString r100 = this.crypto;
            if (r100 == null) goto L5;
            return r100;
        L5:
            Image r101 = this.originImage;
            if (r101 != null) goto L8;
        L11:
            Image r102 = this.thumbImage;
            if (r102 == null) goto L17;
            if (r102.getCrypto() == null) goto L17;
            this.crypto = this.thumbImage.getCrypto();
        L17:
            return this.crypto;
        L8:
            if (r101.getCrypto() == null) goto L11;
            ByteString r103 = this.originImage.getCrypto();
            this.crypto = r103;
            return r103;
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public int hashCode() {
            return Objects.hash(new Object[]{this.key, this.name, Long.valueOf(this.size), this.mime, this.source, this.originImage, Integer.valueOf(this.duration), this.url, this.originPath, this.compressPath, this.mediaUploadId, this.imageUploadId, this.resourcePreviewToken, this.resourceCleanScene, this.resourceMsgLinkToken});
        }

        public MediaProperty() {
            this.imageSetKey = "";
            this.needCopy = false;
        }

        public String getCompressPath() {
            return this.compressPath;
        }

        public String getCoverPath() {
            return this.coverPath;
        }

        public String getCryptoToken() {
            return this.cryptoToken;
        }

        public int getDuration() {
            return this.duration;
        }

        public String getFsUnit() {
            return this.fsUnit;
        }

        public int getHeight() {
            return this.height;
        }

        public String getImageSetKey() {
            return this.imageSetKey;
        }

        public String getImageUploadId() {
            return this.imageUploadId;
        }

        public String getKey() {
            return this.key;
        }

        public String getMediaUploadId() {
            return this.mediaUploadId;
        }

        public String getMime() {
            return this.mime;
        }

        public String getName() {
            return this.name;
        }

        public Image getOriginImage() {
            return this.originImage;
        }

        public String getOriginPath() {
            return this.originPath;
        }

        public ResourceCleanScene getResourceCleanScene() {
            return this.resourceCleanScene;
        }

        public String getResourceMsgLinkToken() {
            return this.resourceMsgLinkToken;
        }

        public String getResourcePreviewToken() {
            return this.resourcePreviewToken;
        }

        public long getSize() {
            return this.size;
        }

        public Source getSource() {
            return this.source;
        }

        public Image getThumbImage() {
            return this.thumbImage;
        }

        public String getUrl() {
            return this.url;
        }

        public int getWidth() {
            return this.width;
        }

        public boolean isNeedCopy() {
            return this.needCopy;
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof MediaProperty) == true) goto L9;
            return false;
        L9:
            if (super.equals(r100) == true) goto L11;
            return false;
        L11:
            MediaProperty r101 = (MediaProperty) r100;
            if (this.size == r101.size) goto L14;
        L63:
            return false;
        L14:
            if (this.duration != r101.duration) goto L63;
            if (Objects.equals(this.key, r101.key) == false) goto L63;
            if (Objects.equals(this.name, r101.name) == false) goto L63;
            if (Objects.equals(this.mime, r101.mime) == false) goto L63;
            if (this.source != r101.source) goto L63;
            Image r102 = this.originImage;
            Image r103 = r101.originImage;
            if (r102 != null) goto L27;
            if (r103 != null) goto L27;
        L41:
            boolean r104 = true;
        L43:
            if (r104 == false) goto L63;
            if (Objects.equals(this.url, r101.url) == false) goto L63;
            if (Objects.equals(this.originPath, r101.originPath) == false) goto L63;
            if (Objects.equals(this.compressPath, r101.compressPath) == false) goto L63;
            if (Objects.equals(this.mediaUploadId, r101.mediaUploadId) == false) goto L63;
            if (Objects.equals(this.imageUploadId, r101.imageUploadId) == false) goto L63;
            if (Objects.equals(this.cryptoToken, r101.cryptoToken) == false) goto L63;
            if (Objects.equals(this.resourcePreviewToken, r101.resourcePreviewToken) == false) goto L63;
            if (Objects.equals(this.resourceCleanScene, r101.resourceCleanScene) == false) goto L63;
            if (Objects.equals(this.resourceMsgLinkToken, r101.resourceMsgLinkToken) == false) goto L63;
            return true;
        L27:
            if (r102 == null) goto L42;
            if (r103 == null) goto L42;
            if (Objects.equals(r102.getKey(), r103.getKey()) == false) goto L42;
            if (Objects.equals(r102.getUrls(), r103.getUrls()) == false) goto L42;
            if (r102.getWidth() != r103.getWidth()) goto L42;
            if (r102.getHeight() != r103.getHeight()) goto L42;
            if (Objects.equals(r102.getToken(), r103.getToken()) == false) goto L42;
            if (r102.getType() == r103.getType()) goto L41;
        L42:
            r104 = false;
            goto L43
        }

        public void setCompressPath(String r100) {
            this.compressPath = r100;
        }

        public void setCoverPath(String r100) {
            this.coverPath = r100;
        }

        public void setCrypto(ByteString r100) {
            this.crypto = r100;
        }

        public void setCryptoToken(String r100) {
            this.cryptoToken = r100;
        }

        public void setDuration(int r100) {
            this.duration = r100;
        }

        public void setFsUnit(String r100) {
            this.fsUnit = r100;
        }

        public void setHeight(int r100) {
            this.height = r100;
        }

        public void setImageSetKey(String r100) {
            this.imageSetKey = r100;
        }

        public void setImageUploadId(String r100) {
            this.imageUploadId = r100;
        }

        public void setKey(String r100) {
            this.key = r100;
        }

        public void setMediaUploadId(String r100) {
            this.mediaUploadId = r100;
        }

        public void setMime(String r100) {
            this.mime = r100;
        }

        public void setName(String r100) {
            this.name = r100;
        }

        public void setNeedCopy(boolean r100) {
            this.needCopy = r100;
        }

        public void setOriginImage(Image r100) {
            this.originImage = r100;
        }

        public void setOriginPath(String r100) {
            this.originPath = r100;
        }

        public void setResourceCleanScene(ResourceCleanScene r100) {
            this.resourceCleanScene = r100;
        }

        public void setResourceMsgLinkToken(String r100) {
            this.resourceMsgLinkToken = r100;
        }

        public void setResourcePreviewToken(String r100) {
            this.resourcePreviewToken = r100;
        }

        public void setSize(long r100) {
            this.size = r100;
        }

        public void setSource(Source r100) {
            this.source = r100;
        }

        public void setThumbImage(Image r100) {
            this.thumbImage = r100;
        }

        public void setUrl(String r100) {
            this.url = r100;
        }

        public void setWidth(int r100) {
            this.width = r100;
        }
    }

    public static class MentionItem implements Serializable {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f448202id;
        private MentionType type;

        public static final enum MentionType extends Enum<MentionType> {
            public static final MentionType HASH_TAG = null;
            public static final MentionType UNKNOWN_MENTION_TYPE = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ MentionType[] f448203a = null;
            private final int value;

            static {
                MentionType r100 = new MentionType("UNKNOWN_MENTION_TYPE", 0, 0);
                UNKNOWN_MENTION_TYPE = r100;
                MentionType r101 = new MentionType("HASH_TAG", 1, 1);
                HASH_TAG = r101;
                f448203a = new MentionType[]{r100, r101};
            }

            public static MentionType[] values() {
                return (MentionType[]) f448203a.clone();
            }

            public int getNumber() {
                return this.value;
            }

            public static MentionType valueOf(int r100) {
                if (r100 == 1) goto L7;
                return UNKNOWN_MENTION_TYPE;
            L7:
                return HASH_TAG;
            }

            public static MentionType valueOf(String r100) {
                return (MentionType) r27.a.a(MentionType.class, r100);
            }

            public MentionType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public MentionItem() {
        }

        public int hashCode() {
            String r100 = this.f448202id;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            MentionType r104 = this.type;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public String getId() {
            return this.f448202id;
        }

        public MentionType getType() {
            return this.type;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof MentionItem) == true) goto L8;
            return false;
        L8:
            MentionItem r101 = (MentionItem) r100;
            if (Objects.equals(this.f448202id, r101.f448202id) == true) goto L12;
            return false;
        L12:
            if (this.type == r101.type) goto L16;
            return false;
        L16:
            return true;
        }

        public void setId(String r100) {
            this.f448202id = r100;
        }

        public void setType(MentionType r100) {
            this.type = r100;
        }
    }

    @JSONType(typeName = "MentionProperty")
    public static class MentionProperty extends RichTextProperty {
        private String content;
        private boolean isAuthorized;
        private MentionItem mentionItem;
        private String redirectUrl;

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public int hashCode() {
            int r100 = super.hashCode() * 31;
            MentionItem r101 = this.mentionItem;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.content;
            if (r105 == null) goto L9;
            int r106 = r105.hashCode();
        L10:
            int r107 = (((r104 + r106) * 31) + (this.isAuthorized ? 1 : 0)) * 31;
            String r108 = this.redirectUrl;
            if (r108 == null) goto L14;
            r102 = r108.hashCode();
        L14:
            return r107 + r102;
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        public MentionProperty() {
        }

        public String getContent() {
            return this.content;
        }

        public MentionItem getMentionItem() {
            return this.mentionItem;
        }

        public String getRedirectUrl() {
            return this.redirectUrl;
        }

        public boolean isAuthorized() {
            return this.isAuthorized;
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof MentionProperty) == true) goto L9;
            return false;
        L9:
            if (super.equals(r100) == true) goto L11;
            return false;
        L11:
            MentionProperty r101 = (MentionProperty) r100;
            if (this.isAuthorized == r101.isAuthorized) goto L15;
            return false;
        L15:
            if (Objects.equals(this.mentionItem, r101.mentionItem) == true) goto L18;
            return false;
        L18:
            if (Objects.equals(this.content, r101.content) == true) goto L21;
            return false;
        L21:
            return Objects.equals(this.redirectUrl, r101.redirectUrl);
        }

        public void setAuthorized(boolean r100) {
            this.isAuthorized = r100;
        }

        public void setContent(String r100) {
            this.content = r100;
        }

        public void setMentionItem(MentionItem r100) {
            this.mentionItem = r100;
        }

        public void setRedirectUrl(String r100) {
            this.redirectUrl = r100;
        }
    }

    public static class MenuOption implements Serializable {
        private String i18Key;
        private String optionActionId;
        private String text;
        private String value;

        public MenuOption() {
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.text, this.i18Key, this.value, this.optionActionId});
        }

        public String getI18Key() {
            return this.i18Key;
        }

        public String getOptionActionId() {
            return this.optionActionId;
        }

        public String getText() {
            return this.text;
        }

        public String getValue() {
            return this.value;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L21:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L21;
            MenuOption r101 = (MenuOption) r100;
            if (Objects.equals(this.text, r101.text) == true) goto L13;
        L19:
            return false;
        L13:
            if (Objects.equals(this.i18Key, r101.i18Key) == false) goto L19;
            if (Objects.equals(this.value, r101.value) == false) goto L19;
            if (Objects.equals(this.optionActionId, r101.optionActionId) == false) goto L19;
            return true;
        }

        public void setI18Key(String r100) {
            this.i18Key = r100;
        }

        public void setOptionActionId(String r100) {
            this.optionActionId = r100;
        }

        public void setText(String r100) {
            this.text = r100;
        }

        public void setValue(String r100) {
            this.value = r100;
        }
    }

    @JSONType(typeName = "MyAIToolProperty")
    public static class MyAIToolProperty extends RichTextProperty {
        private Map<String, String> i18n_name;
        private com.bytedance.lark.pb.basic.v1.RichTextElement.MyAIToolProperty.Icon icon;
        private Status status;
        private String text;
        private MyAIExtensionBasicInfo toolInfo;
        private String tool_id;
        private String tool_runtime_id;

        public static final enum Status extends Enum<Status> {
            public static final Status FAILED = null;
            public static final Status RUNING = null;
            public static final Status SUCCESS = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Status[] f448204a = null;
            private final int value;

            static {
                Status r100 = new Status("RUNING", 0, 0);
                RUNING = r100;
                Status r101 = new Status("SUCCESS", 1, 1);
                SUCCESS = r101;
                Status r102 = new Status("FAILED", 2, 2);
                FAILED = r102;
                f448204a = new Status[]{r100, r101, r102};
            }

            public static Status[] values() {
                return (Status[]) f448204a.clone();
            }

            public int getNumber() {
                return this.value;
            }

            public static Status forType(int r100) {
                Status[] r101 = values();
                int r102 = r101.length;
                int r103 = 0;
            L3:
                if (r103 >= r102) goto L9;
                Status r104 = r101[r103];
                if (r104.value == r100) goto L6;
                r103 = r103 + 1;
                goto L3
            L6:
                return r104;
            L9:
                return FAILED;
            }

            public static Status fromValue(int r100) {
                return forType(r100);
            }

            public static Status valueOf(String r100) {
                return (Status) r27.a.a(Status.class, r100);
            }

            public Status(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.tool_id, this.tool_runtime_id, this.status, this.i18n_name, this.toolInfo, this.text, this.icon});
        }

        public MyAIToolProperty() {
        }

        public Map<String, String> getI18n_name() {
            return this.i18n_name;
        }

        public com.bytedance.lark.pb.basic.v1.RichTextElement.MyAIToolProperty.Icon getIcon() {
            return this.icon;
        }

        public Status getStatus() {
            return this.status;
        }

        public String getText() {
            return this.text;
        }

        public MyAIExtensionBasicInfo getToolInfo() {
            return this.toolInfo;
        }

        public String getTool_id() {
            return this.tool_id;
        }

        public String getTool_runtime_id() {
            return this.tool_runtime_id;
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L30:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L30;
            if (super.equals(r100) == true) goto L13;
            return false;
        L13:
            MyAIToolProperty r101 = (MyAIToolProperty) r100;
            if (Objects.equals(this.tool_id, r101.tool_id) == true) goto L16;
        L28:
            return false;
        L16:
            if (Objects.equals(this.tool_runtime_id, r101.tool_runtime_id) == false) goto L28;
            if (this.status != r101.status) goto L28;
            if (Objects.equals(this.i18n_name, r101.i18n_name) == false) goto L28;
            if (Objects.equals(this.toolInfo, r101.toolInfo) == false) goto L28;
            if (Objects.equals(this.text, r101.text) == false) goto L28;
            if (Objects.equals(this.icon, r101.icon) == false) goto L28;
            return true;
        }

        public void setI18n_name(Map<String, String> r100) {
            this.i18n_name = r100;
        }

        public void setIcon(com.bytedance.lark.pb.basic.v1.RichTextElement.MyAIToolProperty.Icon r100) {
            this.icon = r100;
        }

        public void setStatus(Status r100) {
            this.status = r100;
        }

        public void setText(String r100) {
            this.text = r100;
        }

        public void setToolInfo(MyAIExtensionBasicInfo r100) {
            this.toolInfo = r100;
        }

        public void setTool_id(String r100) {
            this.tool_id = r100;
        }

        public void setTool_runtime_id(String r100) {
            this.tool_runtime_id = r100;
        }
    }

    @JSONType(typeName = "OLProperty")
    public static class OLProperty extends RichTextProperty {
        private static final long serialVersionUID = 1600401076925651470L;
        private int start;
        private Type type;

        public static final enum Type extends Enum<Type> {
            public static final Type LOWERCASE_A = null;
            public static final Type LOWERCASE_ROMAN = null;
            public static final Type NONE = null;
            public static final Type NUMBER = null;
            public static final Type UPPERCASE_A = null;
            public static final Type UPPERCASE_ROMAN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Type[] f448205a = null;
            private final int value;

            static {
                Type r100 = new Type("NUMBER", 0, 0);
                NUMBER = r100;
                Type r101 = new Type("LOWERCASE_A", 1, 1);
                LOWERCASE_A = r101;
                Type r102 = new Type("UPPERCASE_A", 2, 2);
                UPPERCASE_A = r102;
                Type r103 = new Type("LOWERCASE_ROMAN", 3, 3);
                LOWERCASE_ROMAN = r103;
                Type r104 = new Type("UPPERCASE_ROMAN", 4, 4);
                UPPERCASE_ROMAN = r104;
                Type r105 = new Type(UserProfileEvent.POSITION_NONE, 5, 5);
                NONE = r105;
                f448205a = new Type[]{r100, r101, r102, r103, r104, r105};
            }

            public static Type[] values() {
                return (Type[]) f448205a.clone();
            }

            public int getType() {
                return this.value;
            }

            public static Type forType(int r100) {
                if (r100 == 0) goto L26;
                if (r100 == 1) goto L24;
                if (r100 == 2) goto L22;
                if (r100 == 3) goto L20;
                if (r100 == 4) goto L18;
                if (r100 == 5) goto L16;
                return NUMBER;
            L16:
                return NONE;
            L18:
                return UPPERCASE_ROMAN;
            L20:
                return LOWERCASE_ROMAN;
            L22:
                return UPPERCASE_A;
            L24:
                return LOWERCASE_A;
            L26:
                return NUMBER;
            }

            public static Type valueOf(String r100) {
                return (Type) r27.a.a(Type.class, r100);
            }

            public static Type valueOf(int r100) {
                return forType(r100);
            }

            public Type(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.type, Integer.valueOf(this.start)});
        }

        public OLProperty() {
            this.start = 1;
        }

        public int getStart() {
            return this.start;
        }

        public Type getType() {
            return this.type;
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L20:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L20;
            if (super.equals(r100) == true) goto L13;
            return false;
        L13:
            OLProperty r101 = (OLProperty) r100;
            if (this.start == r101.start) goto L16;
        L18:
            return false;
        L16:
            if (this.type != r101.type) goto L18;
            return true;
        }

        public void setStart(int r100) {
            this.start = r100;
        }

        public void setType(Type r100) {
            this.type = r100;
        }
    }

    @JSONType(typeName = "OverflowMenuProperty")
    public static class OverflowMenuProperty extends RichTextProperty {
        private String actionId;
        private ConfirmProperty confirm;
        private boolean disable;
        private boolean isLoading;
        private List<MenuOption> options;

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public int hashCode() {
            return Objects.hash(new Object[]{this.actionId, this.options, this.confirm, Boolean.valueOf(this.disable), Boolean.valueOf(this.isLoading)});
        }

        public OverflowMenuProperty() {
        }

        public String getActionId() {
            return this.actionId;
        }

        public ConfirmProperty getConfirm() {
            return this.confirm;
        }

        public List<MenuOption> getOptions() {
            return this.options;
        }

        public boolean isDisable() {
            return this.disable;
        }

        public boolean isLoading() {
            return this.isLoading;
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L26:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L26;
            if (super.equals(r100) == true) goto L13;
            return false;
        L13:
            OverflowMenuProperty r101 = (OverflowMenuProperty) r100;
            if (this.disable == r101.disable) goto L16;
        L24:
            return false;
        L16:
            if (this.isLoading != r101.isLoading) goto L24;
            if (Objects.equals(this.actionId, r101.actionId) == false) goto L24;
            if (Objects.equals(this.options, r101.options) == false) goto L24;
            if (Objects.equals(this.confirm, r101.confirm) == false) goto L24;
            return true;
        }

        public void setActionId(String r100) {
            this.actionId = r100;
        }

        public void setConfirm(ConfirmProperty r100) {
            this.confirm = r100;
        }

        public void setDisable(boolean r100) {
            this.disable = r100;
        }

        public void setLoading(boolean r100) {
            this.isLoading = r100;
        }

        public void setOptions(List<MenuOption> r100) {
            this.options = r100;
        }
    }

    @JSONType(typeName = "ParagraphProperty")
    public static class ParagraphProperty extends RichTextProperty {
        private boolean isNeedEnter;

        public ParagraphProperty() {
            this.isNeedEnter = true;
        }

        public boolean getIsNeedEnter() {
            return this.isNeedEnter;
        }

        public void setIsNeedEnter(boolean r100) {
            this.isNeedEnter = r100;
        }
    }

    @JSONType(typeName = "ProgressSelectOptionProperty")
    public static class ProgressSelectOptionProperty extends RichTextProperty {
        String actionId;
        String actionParamName;
        String actionParamValue;
        String content;
        boolean disable;
        int numberOfSelected;
        int numberOfTotal;
        String optionCase;
        boolean selected;

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public int hashCode() {
            String r100 = this.actionId;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.actionParamName;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.actionParamValue;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (((((r106 + r108) * 31) + (this.disable ? 1 : 0)) * 31) + (this.selected ? 1 : 0)) * 31;
            String r110 = this.optionCase;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.content;
            if (r113 == null) goto L22;
            r101 = r113.hashCode();
        L22:
            return ((((r112 + r101) * 31) + this.numberOfSelected) * 31) + this.numberOfTotal;
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public ProgressSelectOptionProperty() {
            this.disable = false;
            this.selected = false;
        }

        public String getActionId() {
            return this.actionId;
        }

        public String getActionParamName() {
            return this.actionParamName;
        }

        public String getActionParamValue() {
            return this.actionParamValue;
        }

        public String getContent() {
            return this.content;
        }

        public int getNumberOfSelected() {
            return this.numberOfSelected;
        }

        public int getNumberOfTotal() {
            return this.numberOfTotal;
        }

        public String getOptionCase() {
            return this.optionCase;
        }

        public boolean isDisable() {
            return this.disable;
        }

        public boolean isSelected() {
            return this.selected;
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L64:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L64;
            if (super.equals(r100) == true) goto L13;
            return false;
        L13:
            ProgressSelectOptionProperty r101 = (ProgressSelectOptionProperty) r100;
            if (this.disable == r101.disable) goto L17;
            return false;
        L17:
            if (this.selected == r101.selected) goto L20;
            return false;
        L20:
            if (this.numberOfSelected == r101.numberOfSelected) goto L23;
            return false;
        L23:
            if (this.numberOfTotal == r101.numberOfTotal) goto L25;
            return false;
        L25:
            String r102 = this.actionId;
            if (r102 == null) goto L31;
            if (r102.equals(r101.actionId) == false) goto L32;
        L33:
            String r103 = this.actionParamName;
            if (r103 == null) goto L39;
            if (r103.equals(r101.actionParamName) == false) goto L40;
        L41:
            String r104 = this.actionParamValue;
            if (r104 == null) goto L47;
            if (r104.equals(r101.actionParamValue) == false) goto L48;
        L49:
            String r105 = this.optionCase;
            if (r105 == null) goto L55;
            if (r105.equals(r101.optionCase) == false) goto L56;
        L57:
            String r106 = this.content;
            String r107 = r101.content;
            if (r106 != null) goto L65;
            if (r107 == null) goto L66;
            return false;
        L66:
            return true;
        L65:
            return r106.equals(r107);
        L56:
            return false;
        L55:
            if (r101.optionCase == null) goto L57;
        L48:
            return false;
        L47:
            if (r101.actionParamValue == null) goto L49;
        L40:
            return false;
        L39:
            if (r101.actionParamName == null) goto L41;
        L32:
            return false;
        L31:
            if (r101.actionId == null) goto L33;
            goto L32
        }

        public void setActionId(String r100) {
            this.actionId = r100;
        }

        public void setActionParamName(String r100) {
            this.actionParamName = r100;
        }

        public void setActionParamValue(String r100) {
            this.actionParamValue = r100;
        }

        public void setContent(String r100) {
            this.content = r100;
        }

        public void setDisable(boolean r100) {
            this.disable = r100;
        }

        public void setNumberOfSelected(int r100) {
            this.numberOfSelected = r100;
        }

        public void setNumberOfTotal(int r100) {
            this.numberOfTotal = r100;
        }

        public void setOptionCase(String r100) {
            this.optionCase = r100;
        }

        public void setSelected(boolean r100) {
            this.selected = r100;
        }
    }

    @JSONType(typeName = "QuoteProperty")
    public static class QuoteProperty extends RichTextProperty {
        private static final long serialVersionUID = 5110524811160634106L;

        public QuoteProperty() {
        }
    }

    @JSONType(seeAlso = {ParagraphProperty.class, FigureProperty.class, TextProperty.class, ItalicProperty.class, BoldProperty.class, UnderlineProperty.class, AnchorProperty.class, AtProperty.class, ImageProperty.class, EmotionProperty.class, ButtonProperty.class, SelectProperty.class, ProgressSelectOptionProperty.class, DivProperty.class, TimeProperty.class, LinkProperty.class, MediaProperty.class, SelectMenuProperty.class, OverflowMenuProperty.class, DatePickerProperty.class, DocsProperty.class, H1Property.class, H2Property.class, H3Property.class, H4Property.class, H5Property.class, H6Property.class, ULProperty.class, OLProperty.class, LIProperty.class, QuoteProperty.class, CodeProperty.class, CodeBlockProperty.class, HRProperty.class, TimePickerProperty.class, DateTimePickerProperty.class, CodeBlockV2Property.class, MyAIToolProperty.class, TableProperty.class, TableRowProperty.class, TableCellProperty.class, ColumnsProperty.class, ColumnProperty.class, AtUserGroupProperty.class, ImageGalleryProperty.class, MarkdownProperty.class})
    public static abstract class RichTextProperty implements Serializable {
        public RichTextProperty() {
        }

        public boolean equals(Object r100) {
            return true;
        }

        public int hashCode() {
            return super.hashCode();
        }
    }

    public static final enum RichTextTag extends Enum<RichTextTag> {
        public static final RichTextTag ANCHOR = null;
        public static final RichTextTag AT = null;
        public static final RichTextTag AT_USER_GROUP = null;
        public static final RichTextTag BOLD = null;
        public static final RichTextTag BUTTON = null;
        public static final RichTextTag CODE = null;
        public static final RichTextTag CODE_BLOCK = null;
        public static final RichTextTag CODE_BLOCK_V2 = null;
        public static final RichTextTag COLUMN = null;
        public static final RichTextTag COLUMNS = null;
        public static final RichTextTag DATEPICKER = null;
        public static final RichTextTag DATETIMEPICKER = null;
        public static final RichTextTag DIV = null;
        public static final RichTextTag DOCS = null;
        public static final RichTextTag EMOTION = null;
        public static final RichTextTag FIGURE = null;
        public static final RichTextTag H1 = null;
        public static final RichTextTag H2 = null;
        public static final RichTextTag H3 = null;
        public static final RichTextTag H4 = null;
        public static final RichTextTag H5 = null;
        public static final RichTextTag H6 = null;
        public static final RichTextTag HR = null;
        public static final RichTextTag IMAGE_GALLERY = null;
        public static final RichTextTag IMG = null;
        public static final RichTextTag ITALIC = null;
        public static final RichTextTag LI = null;
        public static final RichTextTag LINK = null;
        public static final RichTextTag MARKDOWN = null;
        public static final RichTextTag MEDIA = null;
        public static final RichTextTag MENTION = null;
        public static final RichTextTag MY_AI_TOOL = null;
        public static final RichTextTag OL = null;
        public static final RichTextTag OVERFLOWMENU = null;
        public static final RichTextTag PARAGRAPH = null;
        public static final RichTextTag PROGRESS_SELECT_OPTION = null;
        public static final RichTextTag QUOTE = null;
        public static final RichTextTag SELECT = null;
        public static final RichTextTag SELECTMENU = null;
        public static final RichTextTag TABLE = null;
        public static final RichTextTag TABLE_CELL = null;
        public static final RichTextTag TABLE_ROW = null;
        public static final RichTextTag TEXT = null;
        public static final RichTextTag TEXTABLEAREA = null;
        public static final RichTextTag TIME = null;
        public static final RichTextTag TIMEPICKER = null;
        public static final RichTextTag UL = null;
        public static final RichTextTag UNDERLINE = null;
        public static final RichTextTag UNKNOWN_TAG = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RichTextTag[] f448206a = null;
        private final int value;

        static {
            RichTextTag r100 = new RichTextTag("UNKNOWN_TAG", 0, 0);
            UNKNOWN_TAG = r100;
            RichTextTag r101 = new RichTextTag(CardAdapter.TEXT, 1, 1);
            TEXT = r101;
            RichTextTag r102 = new RichTextTag("IMG", 2, 2);
            IMG = r102;
            RichTextTag r103 = new RichTextTag("PARAGRAPH", 3, 3);
            PARAGRAPH = r103;
            RichTextTag r104 = new RichTextTag("FIGURE", 4, 4);
            FIGURE = r104;
            RichTextTag r105 = new RichTextTag("AT", 5, 5);
            AT = r105;
            RichTextTag r110 = new RichTextTag(FeatureConfigInfo.ANCHOR_PROFILE_FEATURE_TYPE_ID, 6, 6);
            ANCHOR = r110;
            RichTextTag r111 = new RichTextTag("BOLD", 7, 7);
            BOLD = r111;
            RichTextTag r112 = new RichTextTag("ITALIC", 8, 8);
            ITALIC = r112;
            RichTextTag r113 = new RichTextTag("UNDERLINE", 9, 9);
            UNDERLINE = r113;
            RichTextTag r114 = new RichTextTag("EMOTION", 10, 10);
            EMOTION = r114;
            RichTextTag r115 = new RichTextTag("BUTTON", 11, 11);
            BUTTON = r115;
            RichTextTag r106 = new RichTextTag("SELECT", 12, 12);
            SELECT = r106;
            RichTextTag r107 = new RichTextTag("PROGRESS_SELECT_OPTION", 13, 13);
            PROGRESS_SELECT_OPTION = r107;
            RichTextTag r108 = new RichTextTag("DIV", 14, 14);
            DIV = r108;
            RichTextTag r109 = new RichTextTag("TEXTABLEAREA", 15, 15);
            TEXTABLEAREA = r109;
            RichTextTag r116 = new RichTextTag("TIME", 16, 16);
            TIME = r116;
            RichTextTag r117 = new RichTextTag("LINK", 17, 17);
            LINK = r117;
            RichTextTag r118 = new RichTextTag("MEDIA", 18, 18);
            MEDIA = r118;
            RichTextTag r119 = new RichTextTag("SELECTMENU", 19, 19);
            SELECTMENU = r119;
            RichTextTag r120 = new RichTextTag("OVERFLOWMENU", 20, 20);
            OVERFLOWMENU = r120;
            RichTextTag r121 = new RichTextTag("DATEPICKER", 21, 21);
            DATEPICKER = r121;
            RichTextTag r122 = new RichTextTag("DOCS", 22, 22);
            DOCS = r122;
            RichTextTag r123 = new RichTextTag("H1", 23, 23);
            H1 = r123;
            RichTextTag r124 = new RichTextTag("H2", 24, 24);
            H2 = r124;
            RichTextTag r125 = new RichTextTag("H3", 25, 25);
            H3 = r125;
            RichTextTag r126 = new RichTextTag("UL", 26, 26);
            UL = r126;
            RichTextTag r127 = new RichTextTag("OL", 27, 27);
            OL = r127;
            RichTextTag r128 = new RichTextTag("LI", 28, 28);
            LI = r128;
            RichTextTag r129 = new RichTextTag("QUOTE", 29, 29);
            QUOTE = r129;
            RichTextTag r130 = new RichTextTag("CODE", 30, 30);
            CODE = r130;
            RichTextTag r131 = new RichTextTag("CODE_BLOCK", 31, 31);
            CODE_BLOCK = r131;
            RichTextTag r132 = new RichTextTag("HR", 32, 32);
            HR = r132;
            RichTextTag r133 = new RichTextTag("TIMEPICKER", 33, 33);
            TIMEPICKER = r133;
            RichTextTag r134 = new RichTextTag("DATETIMEPICKER", 34, 34);
            DATETIMEPICKER = r134;
            RichTextTag r135 = new RichTextTag("MENTION", 35, 36);
            MENTION = r135;
            RichTextTag r136 = new RichTextTag("CODE_BLOCK_V2", 36, 37);
            CODE_BLOCK_V2 = r136;
            RichTextTag r137 = new RichTextTag("MY_AI_TOOL", 37, 38);
            MY_AI_TOOL = r137;
            RichTextTag r138 = new RichTextTag("TABLE", 38, 39);
            TABLE = r138;
            RichTextTag r139 = new RichTextTag("TABLE_ROW", 39, 40);
            TABLE_ROW = r139;
            RichTextTag r140 = new RichTextTag("TABLE_CELL", 40, 41);
            TABLE_CELL = r140;
            RichTextTag r141 = new RichTextTag("COLUMNS", 41, 42);
            COLUMNS = r141;
            RichTextTag r142 = new RichTextTag("COLUMN", 42, 43);
            COLUMN = r142;
            RichTextTag r143 = new RichTextTag("H4", 43, 44);
            H4 = r143;
            RichTextTag r144 = new RichTextTag("H5", 44, 45);
            H5 = r144;
            RichTextTag r145 = new RichTextTag("H6", 45, 46);
            H6 = r145;
            RichTextTag r146 = new RichTextTag("AT_USER_GROUP", 46, 47);
            AT_USER_GROUP = r146;
            RichTextTag r147 = new RichTextTag("IMAGE_GALLERY", 47, 48);
            IMAGE_GALLERY = r147;
            RichTextTag r148 = new RichTextTag("MARKDOWN", 48, 49);
            MARKDOWN = r148;
            f448206a = new RichTextTag[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148};
        }

        public static RichTextTag[] values() {
            return (RichTextTag[]) f448206a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static RichTextTag forNumber(int r100) {
            switch(r100) {
                case 0: goto L102;
                case 1: goto L100;
                case 2: goto L98;
                case 3: goto L96;
                case 4: goto L94;
                case 5: goto L92;
                case 6: goto L90;
                case 7: goto L88;
                case 8: goto L86;
                case 9: goto L84;
                case 10: goto L82;
                case 11: goto L80;
                case 12: goto L78;
                case 13: goto L76;
                case 14: goto L74;
                case 15: goto L72;
                case 16: goto L70;
                case 17: goto L68;
                case 18: goto L66;
                case 19: goto L64;
                case 20: goto L62;
                case 21: goto L60;
                case 22: goto L58;
                case 23: goto L56;
                case 24: goto L54;
                case 25: goto L52;
                case 26: goto L50;
                case 27: goto L48;
                case 28: goto L46;
                case 29: goto L44;
                case 30: goto L42;
                case 31: goto L40;
                case 32: goto L38;
                case 33: goto L36;
                case 34: goto L34;
                case 35: goto L4;
                case 36: goto L32;
                case 37: goto L30;
                case 38: goto L28;
                case 39: goto L26;
                case 40: goto L24;
                case 41: goto L22;
                case 42: goto L20;
                case 43: goto L18;
                case 44: goto L16;
                case 45: goto L14;
                case 46: goto L12;
                case 47: goto L10;
                case 48: goto L8;
                case 49: goto L6;
                default: goto L4;
            };
        L4:
            return UNKNOWN_TAG;
        L6:
            return MARKDOWN;
        L8:
            return IMAGE_GALLERY;
        L10:
            return AT_USER_GROUP;
        L12:
            return H6;
        L14:
            return H5;
        L16:
            return H4;
        L18:
            return COLUMN;
        L20:
            return COLUMNS;
        L22:
            return TABLE_CELL;
        L24:
            return TABLE_ROW;
        L26:
            return TABLE;
        L28:
            return MY_AI_TOOL;
        L30:
            return CODE_BLOCK_V2;
        L32:
            return MENTION;
        L34:
            return DATETIMEPICKER;
        L36:
            return TIMEPICKER;
        L38:
            return HR;
        L40:
            return CODE_BLOCK;
        L42:
            return CODE;
        L44:
            return QUOTE;
        L46:
            return LI;
        L48:
            return OL;
        L50:
            return UL;
        L52:
            return H3;
        L54:
            return H2;
        L56:
            return H1;
        L58:
            return DOCS;
        L60:
            return DATEPICKER;
        L62:
            return OVERFLOWMENU;
        L64:
            return SELECTMENU;
        L66:
            return MEDIA;
        L68:
            return LINK;
        L70:
            return TIME;
        L72:
            return TEXTABLEAREA;
        L74:
            return DIV;
        L76:
            return PROGRESS_SELECT_OPTION;
        L78:
            return SELECT;
        L80:
            return BUTTON;
        L82:
            return EMOTION;
        L84:
            return UNDERLINE;
        L86:
            return ITALIC;
        L88:
            return BOLD;
        L90:
            return ANCHOR;
        L92:
            return AT;
        L94:
            return FIGURE;
        L96:
            return PARAGRAPH;
        L98:
            return IMG;
        L100:
            return TEXT;
        L102:
            return UNKNOWN_TAG;
        }

        public static RichTextTag valueOf(String r100) {
            return (RichTextTag) r27.a.a(RichTextTag.class, r100);
        }

        public static RichTextTag valueOf(int r100) {
            return forNumber(r100);
        }

        public RichTextTag(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @JSONType(typeName = "SelectMenuProperty")
    public static class SelectMenuProperty extends RichTextProperty {
        private String actionId;
        private ConfirmProperty confirm;
        private boolean disable;
        private String initialOption;
        private boolean isLoading;
        private List<MenuOption> options;
        private String placeHolder;
        private String placeHolderI18nKey;
        private Type type;

        public static final enum Type extends Enum<Type> {
            public static final Type PERSON = null;
            public static final Type STATIC = null;
            public static final Type UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Type[] f448207a = null;
            private final int value;

            static {
                Type r100 = new Type("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Type r101 = new Type("STATIC", 1, 1);
                STATIC = r101;
                Type r102 = new Type("PERSON", 2, 2);
                PERSON = r102;
                f448207a = new Type[]{r100, r101, r102};
            }

            public static Type[] values() {
                return (Type[]) f448207a.clone();
            }

            public int getType() {
                return this.value;
            }

            public static Type forType(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return UNKNOWN;
            L10:
                return PERSON;
            L12:
                return STATIC;
            L14:
                return UNKNOWN;
            }

            public static Type valueOf(String r100) {
                return (Type) r27.a.a(Type.class, r100);
            }

            public static Type valueOf(int r100) {
                return forType(r100);
            }

            public Type(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public int hashCode() {
            return Objects.hash(new Object[]{this.type, this.actionId, this.placeHolder, this.placeHolderI18nKey, this.initialOption, this.options, this.confirm, Boolean.valueOf(this.disable), Boolean.valueOf(this.isLoading)});
        }

        public SelectMenuProperty() {
        }

        public String getActionId() {
            return this.actionId;
        }

        public ConfirmProperty getConfirm() {
            return this.confirm;
        }

        public String getInitialOption() {
            return this.initialOption;
        }

        public List<MenuOption> getOptions() {
            return this.options;
        }

        public String getPlaceHolder() {
            return this.placeHolder;
        }

        public String getPlaceHolderI18nKey() {
            return this.placeHolderI18nKey;
        }

        public Type getType() {
            return this.type;
        }

        public boolean isDisable() {
            return this.disable;
        }

        public boolean isLoading() {
            return this.isLoading;
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L34:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L34;
            if (super.equals(r100) == true) goto L13;
            return false;
        L13:
            SelectMenuProperty r101 = (SelectMenuProperty) r100;
            if (this.disable == r101.disable) goto L16;
        L32:
            return false;
        L16:
            if (this.isLoading != r101.isLoading) goto L32;
            if (this.type != r101.type) goto L32;
            if (Objects.equals(this.actionId, r101.actionId) == false) goto L32;
            if (Objects.equals(this.placeHolder, r101.placeHolder) == false) goto L32;
            if (Objects.equals(this.placeHolderI18nKey, r101.placeHolderI18nKey) == false) goto L32;
            if (Objects.equals(this.initialOption, r101.initialOption) == false) goto L32;
            if (Objects.equals(this.options, r101.options) == false) goto L32;
            if (Objects.equals(this.confirm, r101.confirm) == false) goto L32;
            return true;
        }

        public void setActionId(String r100) {
            this.actionId = r100;
        }

        public void setConfirm(ConfirmProperty r100) {
            this.confirm = r100;
        }

        public void setDisable(boolean r100) {
            this.disable = r100;
        }

        public void setInitialOption(String r100) {
            this.initialOption = r100;
        }

        public void setLoading(boolean r100) {
            this.isLoading = r100;
        }

        public void setOptions(List<MenuOption> r100) {
            this.options = r100;
        }

        public void setPlaceHolder(String r100) {
            this.placeHolder = r100;
        }

        public void setPlaceHolderI18nKey(String r100) {
            this.placeHolderI18nKey = r100;
        }

        public void setType(Type r100) {
            this.type = r100;
        }
    }

    @JSONType(typeName = "SelectProperty")
    public static class SelectProperty extends RichTextProperty {
        private int mMaxPickNum;
        private int mMinPickNum;

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public int hashCode() {
            return (this.mMinPickNum * 31) + this.mMaxPickNum;
        }

        public SelectProperty() {
        }

        public int getMaxPickNum() {
            return this.mMaxPickNum;
        }

        public int getMinPickNum() {
            return this.mMinPickNum;
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L21:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L21;
            if (super.equals(r100) == true) goto L13;
            return false;
        L13:
            SelectProperty r101 = (SelectProperty) r100;
            if (this.mMinPickNum == r101.mMinPickNum) goto L17;
            return false;
        L17:
            if (this.mMaxPickNum == r101.mMaxPickNum) goto L22;
            return false;
        L22:
            return true;
        }

        public void setMaxPickNum(int r100) {
            this.mMaxPickNum = r100;
        }

        public void setMinPickNum(int r100) {
            this.mMinPickNum = r100;
        }
    }

    @JSONType(typeName = "TableCellProperty")
    public static class TableCellProperty extends RichTextProperty {
        private int columnSpan;
        private HorizontalAlign horizontalAlign;
        private boolean isMerged;
        private int rowSpan;
        private VerticalAlign verticalAlign;

        public TableCellProperty() {
        }

        public int getColumnSpan() {
            return this.columnSpan;
        }

        public HorizontalAlign getHorizontalAlign() {
            return this.horizontalAlign;
        }

        public int getRowSpan() {
            return this.rowSpan;
        }

        public VerticalAlign getVerticalAlign() {
            return this.verticalAlign;
        }

        public boolean isMerged() {
            return this.isMerged;
        }

        public void setColumnSpan(int r100) {
            this.columnSpan = r100;
        }

        public void setHorizontalAlign(HorizontalAlign r100) {
            this.horizontalAlign = r100;
        }

        public void setMerged(boolean r100) {
            this.isMerged = r100;
        }

        public void setRowSpan(int r100) {
            this.rowSpan = r100;
        }

        public void setVerticalAlign(VerticalAlign r100) {
            this.verticalAlign = r100;
        }
    }

    @JSONType(typeName = "TableProperty")
    public static class TableProperty extends RichTextProperty {
        private LinkedList<Column> columns;

        public TableProperty() {
        }

        public LinkedList<Column> getColumns() {
            return this.columns;
        }

        public void setColumns(LinkedList<Column> r100) {
            this.columns = r100;
        }
    }

    @JSONType(typeName = "TableRowProperty")
    public static class TableRowProperty extends RichTextProperty {
        private HorizontalAlign horizontalAlign;
        private boolean isHeader;
        private VerticalAlign verticalAlign;

        public TableRowProperty() {
        }

        public HorizontalAlign getHorizontalAlign() {
            return this.horizontalAlign;
        }

        public VerticalAlign getVerticalAlign() {
            return this.verticalAlign;
        }

        public boolean isHeader() {
            return this.isHeader;
        }

        public void setHeader(boolean r100) {
            this.isHeader = r100;
        }

        public void setHorizontalAlign(HorizontalAlign r100) {
            this.horizontalAlign = r100;
        }

        public void setVerticalAlign(VerticalAlign r100) {
            this.verticalAlign = r100;
        }
    }

    @JSONType(typeName = "TextProperty")
    public static class TextProperty extends RichTextProperty {
        protected String content;
        protected String i18nKey;
        protected int numberOfLines;

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public int hashCode() {
            return Objects.hash(new Object[]{this.content, this.i18nKey, Integer.valueOf(this.numberOfLines)});
        }

        public TextProperty() {
        }

        public String getContent() {
            return this.content;
        }

        public String getI18nKey() {
            return this.i18nKey;
        }

        public int getNumberOfLines() {
            return this.numberOfLines;
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L9;
            return false;
        L9:
            if (getClass() == r100.getClass()) goto L11;
            return false;
        L11:
            TextProperty r101 = (TextProperty) r100;
            String r102 = this.content;
            if (r102 != null) goto L19;
            if (r101.content == null) goto L20;
            return false;
        L20:
            return true;
        L19:
            return r102.equals(r101.content);
        }

        public void setContent(String r100) {
            this.content = r100;
        }

        public void setI18nKey(String r100) {
            this.i18nKey = r100;
        }

        public void setNumberOfLines(int r100) {
            this.numberOfLines = r100;
        }
    }

    @JSONType(typeName = "TextableAreaProperty")
    public static class TextableAreaProperty extends RichTextProperty {
        private int numberOfLines;

        public TextableAreaProperty() {
        }

        public int getNumberOfLines() {
            return this.numberOfLines;
        }

        public void setNumberOfLines(int r100) {
            this.numberOfLines = r100;
        }
    }

    @JSONType(typeName = "TimePickerProperty")
    public static class TimePickerProperty extends RichTextProperty {
        private String actionId;
        private ConfirmProperty confirm;
        private boolean disable;
        private String initialTime;
        private boolean isLoading;
        private String placeHolder;
        private String placeHolderI18nKey;

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public int hashCode() {
            return Objects.hash(new Object[]{this.actionId, this.placeHolder, this.placeHolderI18nKey, this.initialTime, this.confirm, Boolean.valueOf(this.disable), Boolean.valueOf(this.isLoading)});
        }

        public TimePickerProperty() {
        }

        public String getActionId() {
            return this.actionId;
        }

        public ConfirmProperty getConfirm() {
            return this.confirm;
        }

        public String getInitialTime() {
            return this.initialTime;
        }

        public String getPlaceHolder() {
            return this.placeHolder;
        }

        public String getPlaceHolderI18nKey() {
            return this.placeHolderI18nKey;
        }

        public boolean isDisable() {
            return this.disable;
        }

        public boolean isLoading() {
            return this.isLoading;
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L30:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L30;
            if (super.equals(r100) == true) goto L13;
            return false;
        L13:
            DatePickerProperty r101 = (DatePickerProperty) r100;
            if (this.disable == DatePickerProperty.access$000(r101)) goto L16;
        L28:
            return false;
        L16:
            if (this.isLoading != DatePickerProperty.access$100(r101)) goto L28;
            if (Objects.equals(this.actionId, DatePickerProperty.access$200(r101)) == false) goto L28;
            if (Objects.equals(this.placeHolder, DatePickerProperty.access$300(r101)) == false) goto L28;
            if (Objects.equals(this.placeHolderI18nKey, DatePickerProperty.access$400(r101)) == false) goto L28;
            if (Objects.equals(this.initialTime, DatePickerProperty.access$500(r101)) == false) goto L28;
            if (Objects.equals(this.confirm, DatePickerProperty.access$600(r101)) == false) goto L28;
            return true;
        }

        public void setActionId(String r100) {
            this.actionId = r100;
        }

        public void setConfirm(ConfirmProperty r100) {
            this.confirm = r100;
        }

        public void setDisable(boolean r100) {
            this.disable = r100;
        }

        public void setInitialTime(String r100) {
            this.initialTime = r100;
        }

        public void setLoading(boolean r100) {
            this.isLoading = r100;
        }

        public void setPlaceHolder(String r100) {
            this.placeHolder = r100;
        }

        public void setPlaceHolderI18nKey(String r100) {
            this.placeHolderI18nKey = r100;
        }
    }

    @JSONType(typeName = "TimeProperty")
    public static class TimeProperty extends RichTextProperty {
        private String format;
        public String format_type;
        public String link;
        private long millisecondSince1970;

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public int hashCode() {
            long r100 = this.millisecondSince1970;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            String r102 = this.format;
            if (r102 == null) goto L5;
            int r103 = r102.hashCode();
        L7:
            return r101 + r103;
        L5:
            r103 = 0;
            goto L7
        }

        public TimeProperty() {
            this.format = "YYYY.MM.DD(dddd) HH:mm (GMT)";
        }

        public String getFormat() {
            return this.format;
        }

        public String getFormat_type() {
            return this.format_type;
        }

        public String getLink() {
            return this.link;
        }

        public long getMillisecondSince1970() {
            return this.millisecondSince1970;
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L33:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L33;
            if (super.equals(r100) == true) goto L13;
            return false;
        L13:
            TimeProperty r101 = (TimeProperty) r100;
            if (this.millisecondSince1970 == r101.millisecondSince1970) goto L17;
            return false;
        L17:
            if (TextUtils.isEmpty(this.format_type) == true) goto L22;
            if (this.format_type.equals(r101.format) == true) goto L22;
            return false;
        L22:
            if (TextUtils.isEmpty(this.link) == false) goto L24;
        L26:
            String r102 = this.format;
            String r103 = r101.format;
            if (r102 != null) goto L34;
            if (r103 == null) goto L35;
            return false;
        L35:
            return true;
        L34:
            return r102.equals(r103);
        L24:
            if (this.link.equals(r101.link) == true) goto L26;
            return false;
        }

        public void setFormat(String r100) {
            this.format = r100;
        }

        public void setFormat_type(String r100) {
            this.format_type = r100;
        }

        public void setLink(String r100) {
            this.link = r100;
        }

        public void setMillisecondSince1970(long r100) {
            this.millisecondSince1970 = r100;
        }
    }

    @JSONType(typeName = "ULProperty")
    public static class ULProperty extends RichTextProperty {
        private static final long serialVersionUID = 7660246273726402517L;
        private Type type;

        public static final enum Type extends Enum<Type> {
            public static final Type CIRCLE = null;
            public static final Type DISC = null;
            public static final Type NONE = null;
            public static final Type SQUARE = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Type[] f448208a = null;
            private final int value;

            static {
                Type r100 = new Type("DISC", 0, 0);
                DISC = r100;
                Type r101 = new Type("CIRCLE", 1, 1);
                CIRCLE = r101;
                Type r102 = new Type("SQUARE", 2, 2);
                SQUARE = r102;
                Type r103 = new Type(UserProfileEvent.POSITION_NONE, 3, 3);
                NONE = r103;
                f448208a = new Type[]{r100, r101, r102, r103};
            }

            public static Type[] values() {
                return (Type[]) f448208a.clone();
            }

            public int getType() {
                return this.value;
            }

            public static Type forType(int r100) {
                if (r100 == 0) goto L18;
                if (r100 == 1) goto L16;
                if (r100 == 2) goto L14;
                if (r100 == 3) goto L12;
                return DISC;
            L12:
                return NONE;
            L14:
                return SQUARE;
            L16:
                return CIRCLE;
            L18:
                return DISC;
            }

            public static Type valueOf(String r100) {
                return (Type) r27.a.a(Type.class, r100);
            }

            public static Type valueOf(int r100) {
                return forType(r100);
            }

            public Type(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.type});
        }

        public ULProperty() {
        }

        public Type getType() {
            return this.type;
        }

        @Override // com.ss.android.lark.widget.richtext.RichTextElement.RichTextProperty
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L18:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L18;
            if (super.equals(r100) == true) goto L14;
            return false;
        L14:
            if (this.type == ((ULProperty) r100).type) goto L19;
            return false;
        L19:
            return true;
        }

        public void setType(Type r100) {
            this.type = r100;
        }
    }

    @JSONType(typeName = "UnderlineProperty")
    public static class UnderlineProperty extends TextProperty {
        public UnderlineProperty() {
        }
    }

    public RichTextElement() {
    }

    public void clearElementExtra() {
        this.elementExtra = null;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.tag, this.style, this.property, this.childIds, this.calendarAiProperty});
    }

    public ElementExtra getElementExtra() {
        if (this.elementExtra != null) goto L6;
        this.elementExtra = new ElementExtra();
    L6:
        return this.elementExtra;
    }

    public RichTextProperty getCalendarAiProperty() {
        return this.calendarAiProperty;
    }

    public List<String> getChildIds() {
        return this.childIds;
    }

    public <T extends RichTextProperty> T getProperty() {
        return (T) this.property;
    }

    public Map<String, String> getStyle() {
        return this.style;
    }

    public List<String> getStyleKeys() {
        return this.styleKeys;
    }

    public RichTextTag getTag() {
        return this.tag;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L39:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L39;
        RichTextElement r101 = (RichTextElement) r100;
        if (this.tag == r101.tag) goto L13;
        return false;
    L13:
        RichTextProperty r102 = this.property;
        if (r102 == null) goto L19;
        if (r102.equals(r101.property) == false) goto L20;
    L21:
        Map<String, String> r103 = this.style;
        if (r103 == null) goto L27;
        if (r103.equals(r101.style) == true) goto L30;
    L28:
        return false;
    L30:
        if (Objects.equals(this.calendarAiProperty, r101.calendarAiProperty) == true) goto L32;
        return false;
    L32:
        List<String> r104 = this.childIds;
        List<String> r105 = r101.childIds;
        if (r104 != null) goto L40;
        if (r105 == null) goto L41;
        return false;
    L41:
        return true;
    L40:
        return r104.equals(r105);
    L27:
        if (r101.style == null) goto L30;
    L20:
        return false;
    L19:
        if (r101.property == null) goto L21;
        goto L20
    }

    public void setCalendarAiProperty(RichTextProperty r100) {
        this.calendarAiProperty = r100;
    }

    public void setChildIds(List<String> r100) {
        this.childIds = new ArrayList(r100);
    }

    public void setProperty(RichTextProperty r100) {
        this.property = r100;
    }

    public void setStyle(Map<String, String> r100) {
        this.style = new HashMap(r100);
    }

    public void setStyleKeys(List<String> r100) {
        this.styleKeys = r100;
    }

    public void setTag(RichTextTag r100) {
        this.tag = r100;
    }
}
