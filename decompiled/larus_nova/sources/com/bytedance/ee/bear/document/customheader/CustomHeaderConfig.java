package com.bytedance.ee.bear.document.customheader;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.alipay.sdk.m.x.d;
import com.bytedance.ee.util.io.NonProguard;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 62\u00020\u0001:\u00043456B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010+\u001a\u00020\u000bJ\b\u0010,\u001a\u00020\u0005H\u0016J\u001f\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u000201H\u0016¢\u0006\u0002\u00102R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010%\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R\u001a\u0010(\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000f¨\u00067"}, d2 = {"Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "shouldHandleBackPress", "", "getShouldHandleBackPress", "()Z", "setShouldHandleBackPress", "(Z)V", "titleConfig", "Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig$TitleConfig;", "getTitleConfig", "()Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig$TitleConfig;", "setTitleConfig", "(Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig$TitleConfig;)V", "items", "Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig$MenuItems;", "getItems", "()Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig$MenuItems;", "setItems", "(Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig$MenuItems;)V", "themeColor", "getThemeColor", "setThemeColor", "shouldShowDivider", "getShouldShowDivider", "()Ljava/lang/Boolean;", "setShouldShowDivider", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "hideCustomHeaderInLandscape", "getHideCustomHeaderInLandscape", "setHideCustomHeaderInLandscape", "keepShowingInVcFollow", "getKeepShowingInVcFollow", "setKeepShowingInVcFollow", "isEmpty", "toString", "getTitleIcon", "", "titleIconId", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/Integer;", "TitleConfig", "MenuItems", "Menu", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CustomHeaderConfig implements NonProguard {
    public static final String COLOR_DARK = "#000000";
    public static final String COLOR_LIGHT = "#FFFFFF";
    public static final a Companion = null;
    public static final String EXIT_MENU_ID = "exit";
    private static final Map<String, Integer> TITLE_ICON_MAP = null;
    private Boolean hideCustomHeaderInLandscape;
    private MenuItems items;
    private boolean keepShowingInVcFollow;
    private String key;
    private boolean shouldHandleBackPress;
    private Boolean shouldShowDivider;
    private String themeColor;
    private TitleConfig titleConfig;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\tR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\tR$\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001cX\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001c\u0010%\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\t¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig$Menu;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "onboardingKey", "getOnboardingKey", "setOnboardingKey", "enable", "", "getEnable", "()Ljava/lang/Boolean;", "setEnable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "style", "getStyle$annotations", "getStyle", "setStyle", "text", "getText", "setText", "customColor", "", "getCustomColor", "()[Ljava/lang/String;", "setCustomColor", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "extraId", "getExtraId", "setExtraId", "iconKey", "getIconKey", "setIconKey", "Style", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Menu implements NonProguard {
        private String[] customColor;
        private Boolean enable;
        private String extraId;
        private String iconKey;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f219401id;
        private String onboardingKey;
        private String style;
        private String text;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig$Menu$Style;", "", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface Style {
            public static final a Companion = null;
            public static final String ICON_STYLE = "icon";
            public static final String TEXT_STYLE = "text";

            public static final class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ a f219402a = null;

                static {
                    f219402a = new a();
                }

                public a() {
                }
            }

            static {
                Companion = a.f219402a;
            }
        }

        public static /* synthetic */ void getStyle$annotations() {
        }

        public Menu() {
            this.style = "icon";
        }

        public final String[] getCustomColor() {
            return this.customColor;
        }

        public final Boolean getEnable() {
            return this.enable;
        }

        public final String getExtraId() {
            return this.extraId;
        }

        public final String getIconKey() {
            return this.iconKey;
        }

        public final String getId() {
            return this.f219401id;
        }

        public final String getOnboardingKey() {
            return this.onboardingKey;
        }

        public final String getStyle() {
            return this.style;
        }

        public final String getText() {
            return this.text;
        }

        public final void setCustomColor(String[] r100) {
            this.customColor = r100;
        }

        public final void setEnable(Boolean r100) {
            this.enable = r100;
        }

        public final void setExtraId(String r100) {
            this.extraId = r100;
        }

        public final void setIconKey(String r100) {
            this.iconKey = r100;
        }

        public final void setId(String r100) {
            this.f219401id = r100;
        }

        public final void setOnboardingKey(String r100) {
            this.onboardingKey = r100;
        }

        public final void setStyle(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.style = r100;
        }

        public final void setText(String r100) {
            this.text = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig$MenuItems;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "left", "", "Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig$Menu;", "getLeft", "()[Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig$Menu;", "setLeft", "([Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig$Menu;)V", "[Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig$Menu;", "right", "getRight", "setRight", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MenuItems implements NonProguard {
        private Menu[] left;
        private Menu[] right;

        public MenuItems() {
        }

        public final Menu[] getLeft() {
            return this.left;
        }

        public final Menu[] getRight() {
            return this.right;
        }

        public final void setLeft(Menu[] r100) {
            this.left = r100;
        }

        public final void setRight(Menu[] r100) {
            this.right = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0016\u0018\u00002\u00020\u0001:\u0002+,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR \u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001d\u0010\u0003\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR\u001c\u0010 \u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR\u001a\u0010#\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001a\u0010%\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018R\u001a\u0010(\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018¨\u0006-"}, d2 = {"Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig$TitleConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "position", "getPosition$annotations", "getPosition", "setPosition", "isLoading", "", "()Ljava/lang/Boolean;", "setLoading", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "showFoldBtn", "getShowFoldBtn", "()Z", "setShowFoldBtn", "(Z)V", "onboardingKey", "getOnboardingKey", "setOnboardingKey", "titleIcon", "getTitleIcon$annotations", "getTitleIcon", "setTitleIcon", "id", "getId", "setId", "isBold", "setBold", "hasBorder", "getHasBorder", "setHasBorder", "enable", "getEnable", "setEnable", "Position", "TitleIcon", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class TitleConfig implements NonProguard {
        private boolean enable;
        private boolean hasBorder;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f219403id;
        private boolean isBold;
        private Boolean isLoading;
        private String onboardingKey;
        private String position;
        private boolean showFoldBtn;
        private String title;
        private String titleIcon;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig$TitleConfig$Position;", "", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface Position {
            public static final String CENTER = "center";
            public static final a Companion = null;
            public static final String LEFT = "left";

            public static final class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ a f219404a = null;

                static {
                    f219404a = new a();
                }

                public a() {
                }
            }

            static {
                Companion = a.f219404a;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig$TitleConfig$TitleIcon;", "", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface TitleIcon {
            public static final a Companion = null;
            public static final String EMPTY = "empty";
            public static final String TRANSLATE = "translate";

            public static final class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ a f219405a = null;

                static {
                    f219405a = new a();
                }

                public a() {
                }
            }

            static {
                Companion = a.f219405a;
            }
        }

        public static /* synthetic */ void getPosition$annotations() {
        }

        public static /* synthetic */ void getTitleIcon$annotations() {
        }

        public TitleConfig() {
            this.titleIcon = "empty";
            this.isBold = true;
            this.enable = true;
        }

        public final boolean getEnable() {
            return this.enable;
        }

        public final boolean getHasBorder() {
            return this.hasBorder;
        }

        public final String getId() {
            return this.f219403id;
        }

        public final String getOnboardingKey() {
            return this.onboardingKey;
        }

        public final String getPosition() {
            return this.position;
        }

        public final boolean getShowFoldBtn() {
            return this.showFoldBtn;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getTitleIcon() {
            return this.titleIcon;
        }

        public final boolean isBold() {
            return this.isBold;
        }

        public final Boolean isLoading() {
            return this.isLoading;
        }

        public final void setBold(boolean r100) {
            this.isBold = r100;
        }

        public final void setEnable(boolean r100) {
            this.enable = r100;
        }

        public final void setHasBorder(boolean r100) {
            this.hasBorder = r100;
        }

        public final void setId(String r100) {
            this.f219403id = r100;
        }

        public final void setLoading(Boolean r100) {
            this.isLoading = r100;
        }

        public final void setOnboardingKey(String r100) {
            this.onboardingKey = r100;
        }

        public final void setPosition(String r100) {
            this.position = r100;
        }

        public final void setShowFoldBtn(boolean r100) {
            this.showFoldBtn = r100;
        }

        public final void setTitle(String r100) {
            this.title = r100;
        }

        public final void setTitleIcon(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.titleIcon = r100;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        TITLE_ICON_MAP = MapsKt.mapOf(new Pair[]{TuplesKt.to("empty", null), TuplesKt.to("translate", Integer.valueOf(R.drawable.ud_icon_translate_outlined))});
    }

    public String toString() {
        return "titleConfig = " + JSON.toJSONString(getTitleConfig()) + " key = " + this.key + " items = " + JSON.toJSONString(this.items) + " themeColor = " + this.themeColor + " shouldShowDivider = " + this.shouldShowDivider + " hideCustomHeaderInLandscape = " + this.hideCustomHeaderInLandscape + " keepShowingInVcFollow = " + this.keepShowingInVcFollow;
    }

    public CustomHeaderConfig() {
        this.shouldHandleBackPress = true;
    }

    public final boolean isEmpty() {
        if (getTitleConfig() == null) goto L5;
    L11:
        return false;
    L5:
        if (this.items != null) goto L11;
        if (this.themeColor != null) goto L11;
        if (this.shouldShowDivider != null) goto L11;
        return true;
    }

    public static final /* synthetic */ Map access$getTITLE_ICON_MAP$cp() {
        return TITLE_ICON_MAP;
    }

    public final Boolean getHideCustomHeaderInLandscape() {
        return this.hideCustomHeaderInLandscape;
    }

    public final MenuItems getItems() {
        return this.items;
    }

    public final boolean getKeepShowingInVcFollow() {
        return this.keepShowingInVcFollow;
    }

    public final String getKey() {
        return this.key;
    }

    public final boolean getShouldHandleBackPress() {
        return this.shouldHandleBackPress;
    }

    public final Boolean getShouldShowDivider() {
        return this.shouldShowDivider;
    }

    public final String getThemeColor() {
        return this.themeColor;
    }

    public TitleConfig getTitleConfig() {
        return this.titleConfig;
    }

    public final void setHideCustomHeaderInLandscape(Boolean r100) {
        this.hideCustomHeaderInLandscape = r100;
    }

    public final void setItems(MenuItems r100) {
        this.items = r100;
    }

    public final void setKeepShowingInVcFollow(boolean r100) {
        this.keepShowingInVcFollow = r100;
    }

    public final void setKey(String r100) {
        this.key = r100;
    }

    public final void setShouldHandleBackPress(boolean r100) {
        this.shouldHandleBackPress = r100;
    }

    public final void setShouldShowDivider(Boolean r100) {
        this.shouldShowDivider = r100;
    }

    public final void setThemeColor(String r100) {
        this.themeColor = r100;
    }

    public void setTitleConfig(TitleConfig r100) {
        this.titleConfig = r100;
    }

    public Integer getTitleIcon(String r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "titleIconId");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return TITLE_ICON_MAP.get(r100);
    }
}
