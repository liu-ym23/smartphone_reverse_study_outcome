package com.larksuite.component.card.protocol;

import android.content.Context;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.larksuite.component.card.settings.LynxCardCommonConfig;
import com.larksuite.component.card.settings.LynxCardFallbackStyleConfig;
import com.larksuite.component.card.settings.LynxMsgCardTimeFormatConfig;
import com.larksuite.framework.utils.ICUUtils;
import com.larus.nova.R;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.utils.UIHelper;
import ez7.a;
import ez7.b;
import ez7.c;
import idb.f;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J8\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/larksuite/component/card/protocol/CardConfig;", "Ljava/io/Serializable;", "maxWidth", "", "settings", "Lcom/larksuite/component/card/protocol/data/SettingsInfo;", AppConstants.APP_FG, "Lcom/larksuite/component/card/protocol/data/FgInfo;", "i18nText", "Lcom/larksuite/component/card/protocol/data/I18nText;", "<init>", "(Ljava/lang/Integer;Lcom/larksuite/component/card/protocol/data/SettingsInfo;Lcom/larksuite/component/card/protocol/data/FgInfo;Lcom/larksuite/component/card/protocol/data/I18nText;)V", "getMaxWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSettings", "()Lcom/larksuite/component/card/protocol/data/SettingsInfo;", "getFg", "()Lcom/larksuite/component/card/protocol/data/FgInfo;", "getI18nText", "()Lcom/larksuite/component/card/protocol/data/I18nText;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Lcom/larksuite/component/card/protocol/data/SettingsInfo;Lcom/larksuite/component/card/protocol/data/FgInfo;Lcom/larksuite/component/card/protocol/data/I18nText;)Lcom/larksuite/component/card/protocol/CardConfig;", "equals", "", "other", "", "hashCode", "toString", "", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardConfig implements Serializable {

    /* JADX INFO: renamed from: fg, reason: collision with root package name */
    private final a f283860fg;
    private final b i18nText;
    private final Integer maxWidth;
    private final c settings;

    public CardConfig() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CardConfig copy$default(CardConfig r100, Integer r101, c r102, a r103, b r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.maxWidth;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.settings;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.f283860fg;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.i18nText;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Integer component1() {
        return this.maxWidth;
    }

    public final c component2() {
        return this.settings;
    }

    public final a component3() {
        return this.f283860fg;
    }

    public final b component4() {
        return this.i18nText;
    }

    public final CardConfig copy(Integer r100, c r101, a r102, b r103) {
        Intrinsics.checkNotNullParameter(r101, "settings");
        Intrinsics.checkNotNullParameter(r102, AppConstants.APP_FG);
        Intrinsics.checkNotNullParameter(r103, "i18nText");
        return new CardConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CardConfig) == true) goto L8;
        return false;
    L8:
        CardConfig r101 = (CardConfig) r100;
        if (Intrinsics.areEqual(this.maxWidth, r101.maxWidth) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.settings, r101.settings) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f283860fg, r101.f283860fg) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.i18nText, r101.i18nText) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.maxWidth;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((((r101 * 31) + this.settings.hashCode()) * 31) + this.f283860fg.hashCode()) * 31) + this.i18nText.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "CardConfig(maxWidth=" + this.maxWidth + ", settings=" + this.settings + ", fg=" + this.f283860fg + ", i18nText=" + this.i18nText + ')';
    }

    public final a getFg() {
        return this.f283860fg;
    }

    public final b getI18nText() {
        return this.i18nText;
    }

    public final Integer getMaxWidth() {
        return this.maxWidth;
    }

    public final c getSettings() {
        return this.settings;
    }

    public CardConfig(Integer r100, c r101, a r102, b r103) {
        Intrinsics.checkNotNullParameter(r101, "settings");
        Intrinsics.checkNotNullParameter(r102, AppConstants.APP_FG);
        Intrinsics.checkNotNullParameter(r103, "i18nText");
        this.maxWidth = r100;
        this.settings = r101;
        this.f283860fg = r102;
        this.i18nText = r103;
    }

    public CardConfig(Integer r100, c r101, a r102, b r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        int r106 = c.f474900d;
        LynxCardFallbackStyleConfig r107 = (LynxCardFallbackStyleConfig) SettingManager.getInstance().get(LynxCardFallbackStyleConfig.class);
        LynxCardCommonConfig r108 = (LynxCardCommonConfig) SettingManager.getInstance().get(LynxCardCommonConfig.class);
        r101 = new c((LynxMsgCardTimeFormatConfig) SettingManager.getInstance().get(LynxMsgCardTimeFormatConfig.class), r107, r108);
    L9:
        if ((r104 & 4) == 0) goto L16;
        int r109 = a.f474896b;
        Set r110 = SetsKt.setOf(new String[]{"universalcard.chart_offscreen_preview.enable", "universalcard.selectmenu.use.overlay", "universalcard.audio.enable", "universalcard.video.enable"});
        HashMap r111 = new HashMap();
        Iterator r112 = r110.iterator();
    L12:
        if (r112.hasNext() == false) goto L14;
        String r113 = (String) r112.next();
        r111.put(r113, Boolean.valueOf(f.a().isEnable(r113)));
        goto L12
    L14:
        r102 = new a(r111);
    L16:
        if ((r104 & 8) == 0) goto L18;
        int r114 = b.f474898b;
        Context r115 = ty7.a.a().getContext();
        HashMap r116 = new HashMap();
        r116.put("translationText", r115.getString(R.string.Lark_Chat_Translation));
        r116.put("imageTagText", r115.getString(R.string.Lark_Legacy_ImageSummarize));
        r116.put("cancelText", r115.getString(R.string.Lark_Legacy_Cancel));
        r116.put("confirmText", r115.getString(R.string.Lark_Legacy_Confirm));
        r116.put("textLengthError", r115.getString(R.string.Lark_MessageCard_TextLengthErr));
        r116.put("inputPlaceholder", r115.getString(R.string.Lark_MessageCard_PlsEnterPlaceholder));
        r116.put("requiredErrorText", r115.getString(R.string.Lark_MessageCard_RequiredItemLeftEmptyErr));
        r116.put("chartTagText", r115.getString(R.string.Lark_InteractiveChart_ChartComptLabel));
        r116.put("chartLoadError", r115.getString(R.string.Lark_InteractiveChart_ChartLoadingErr));
        r116.put("tableTagText", r115.getString(R.string.Lark_TableComponentInCard_TableInSummary));
        r116.put("codeBlockTagText", r115.getString(R.string.Lark_Message_Codeblock));
        r116.put("tableEmptyText", r115.getString(R.string.Lark_TableComponentInCard_NoData));
        r116.put("tableDetailShowText", r115.getString(R.string.Lark_MsgCardTable_ViewMoreBttn));
        r116.put("unknownUserText", r115.getString(R.string.Lark_CardCompt_UnknownUser));
        r116.put("tableDetailHideText", r115.getString(R.string.Lark_MsgCardTable_CollapseBttn));
        String r117 = UIHelper.getString(R.string.Lark_CardFallback_PlaceholderText);
        ICUUtils.FormatArgsBuilder r118 = new ICUUtils.FormatArgsBuilder();
        r118.b("APP_DISPLAY_NAME", UIHelper.getAppName());
        r116.put("cardFallbackText", ICUUtils.icuFormat(r117, r118.f285892a));
        r116.put("tableViewMore", r115.getString(R.string.Lark_CardTableComponent_ViewMoreDetailsText));
        r116.put("selectPlaceholder", r115.getString(R.string.Lark_Legacy_MsgCard_PickerPlaceholder));
        String r119 = r115.getString(R.string.Lark_CardLoadingOptim_LoadError_Error);
        ICUUtils.FormatArgsBuilder r120 = new ICUUtils.FormatArgsBuilder();
        r120.b("reloadBtn", "");
        r116.put("errorDefault", ICUUtils.icuFormat(r119, r120.f285892a));
        r116.put("errorRetry", r115.getString(R.string.Lark_CardLoadingOptim_Reload_Button));
        r116.put("loading", r115.getString(R.string.Lark_CardLoadingOptim_Loading_Text));
        r116.put("searchPlaceholder", r115.getString(R.string.Lark_Legacy_MsgCardSearch));
        r116.put("searchNoResult", r115.getString(R.string.Lark_Legacy_MsgCardNoresult));
        r116.put("audioTagText", r115.getString(R.string.OpenPlatform_Card_Digest_Audio));
        r103 = new b(r116);
    L18:
        this(r100, r101, r102, r103);
    }
}
