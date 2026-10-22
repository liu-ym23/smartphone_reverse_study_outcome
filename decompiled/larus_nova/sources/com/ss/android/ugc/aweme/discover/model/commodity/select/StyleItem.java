package com.ss.android.ugc.aweme.discover.model.commodity.select;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.SubInfo;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\bJ\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\bb\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R \u0010\u001b\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R \u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR \u0010!\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R \u0010$\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R \u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR \u0010*\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017R \u0010-\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0015\"\u0004\b/\u0010\u0017R \u00100\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR \u00103\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0015\"\u0004\b5\u0010\u0017R \u00106\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0015\"\u0004\b8\u0010\u0017R \u00109\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0015\"\u0004\b;\u0010\u0017R \u0010<\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR \u0010?\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0015\"\u0004\bA\u0010\u0017R \u0010B\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0015\"\u0004\bD\u0010\u0017R \u0010E\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0015\"\u0004\bG\u0010\u0017R \u0010H\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\bR \u0010K\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0015\"\u0004\bM\u0010\u0017R \u0010N\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0015\"\u0004\bP\u0010\u0017R \u0010Q\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0006\"\u0004\bS\u0010\bR \u0010T\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0006\"\u0004\bV\u0010\bR \u0010W\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u0015\"\u0004\bY\u0010\u0017R \u0010Z\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0015\"\u0004\b\\\u0010\u0017R\u001e\u0010]\u001a\u00020^8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010_\"\u0004\b`\u0010aR&\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR \u0010h\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u0015\"\u0004\bj\u0010\u0017R \u0010k\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\u0015\"\u0004\bm\u0010\u0017R \u0010n\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\u0015\"\u0004\bp\u0010\u0017R \u0010q\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010\u0006\"\u0004\bs\u0010\bR \u0010t\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\u0015\"\u0004\bv\u0010\u0017R \u0010w\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\u0006\"\u0004\by\u0010\bR \u0010z\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u0015\"\u0004\b|\u0010\u0017R \u0010}\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u0015\"\u0004\b\u007f\u0010\u0017R#\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010\u0006\"\u0005\b\u0082\u0001\u0010\bR#\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010\u0015\"\u0005\b\u0085\u0001\u0010\u0017R#\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010\u0015\"\u0005\b\u0088\u0001\u0010\u0017R#\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010\u0015\"\u0005\b\u008b\u0001\u0010\u0017R#\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010\u0006\"\u0005\b\u008e\u0001\u0010\bR#\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010\u0015\"\u0005\b\u0091\u0001\u0010\u0017R#\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010\u0015\"\u0005\b\u0094\u0001\u0010\u0017R#\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010\u0015\"\u0005\b\u0097\u0001\u0010\u0017R#\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010\u0006\"\u0005\b\u009a\u0001\u0010\bR#\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010\u0015\"\u0005\b\u009d\u0001\u0010\u0017R#\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0001\u0010\u0015\"\u0005\b \u0001\u0010\u0017R#\u0010¡\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¢\u0001\u0010\u0006\"\u0005\b£\u0001\u0010\bR#\u0010¤\u0001\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0001\u0010\u0015\"\u0005\b¦\u0001\u0010\u0017R#\u0010§\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¨\u0001\u0010\u0006\"\u0005\b©\u0001\u0010\bR#\u0010ª\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b«\u0001\u0010\u0006\"\u0005\b¬\u0001\u0010\bR#\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b®\u0001\u0010\u0015\"\u0005\b¯\u0001\u0010\u0017R#\u0010°\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0001\u0010\u0006\"\u0005\b²\u0001\u0010\bR#\u0010³\u0001\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b´\u0001\u0010\u0015\"\u0005\bµ\u0001\u0010\u0017R#\u0010¶\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b·\u0001\u0010\u0006\"\u0005\b¸\u0001\u0010\bR#\u0010¹\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bº\u0001\u0010\u0006\"\u0005\b»\u0001\u0010\bR(\u0010¼\u0001\u001a\u0004\u0018\u00010^8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0003\u0010Á\u0001\u001a\u0006\b½\u0001\u0010¾\u0001\"\u0006\b¿\u0001\u0010À\u0001R#\u0010Â\u0001\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÃ\u0001\u0010\u0015\"\u0005\bÄ\u0001\u0010\u0017¨\u0006Å\u0001"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/StyleItem;", "Ljava/io/Serializable;", "()V", "ascendingTailIcon", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/IconStruct;", "getAscendingTailIcon", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/select/IconStruct;", "setAscendingTailIcon", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/select/IconStruct;)V", "cityDefaultHeadIcon", "getCityDefaultHeadIcon", "setCityDefaultHeadIcon", "citySelectedHeadIcon", "getCitySelectedHeadIcon", "setCitySelectedHeadIcon", "citySelectingHeadIcon", "getCitySelectingHeadIcon", "setCitySelectingHeadIcon", "dateColor", "", "getDateColor", "()Ljava/lang/String;", "setDateColor", "(Ljava/lang/String;)V", "defaultBgColor", "getDefaultBgColor", "setDefaultBgColor", "defaultBorderColor", "getDefaultBorderColor", "setDefaultBorderColor", "defaultComponentImage", "getDefaultComponentImage", "setDefaultComponentImage", "defaultDateColor", "getDefaultDateColor", "setDefaultDateColor", "defaultEndTimeBgColor", "getDefaultEndTimeBgColor", "setDefaultEndTimeBgColor", "defaultHeadIcon", "getDefaultHeadIcon", "setDefaultHeadIcon", "defaultHeadTextColor", "getDefaultHeadTextColor", "setDefaultHeadTextColor", "defaultHintColor", "getDefaultHintColor", "setDefaultHintColor", "defaultLeftBgIcon", "getDefaultLeftBgIcon", "setDefaultLeftBgIcon", "defaultLeftPostscriptTextColor", "getDefaultLeftPostscriptTextColor", "setDefaultLeftPostscriptTextColor", "defaultLeftTextColor", "getDefaultLeftTextColor", "setDefaultLeftTextColor", "defaultPostscriptTextColor", "getDefaultPostscriptTextColor", "setDefaultPostscriptTextColor", "defaultRightBgIcon", "getDefaultRightBgIcon", "setDefaultRightBgIcon", "defaultRightPostscriptTextColor", "getDefaultRightPostscriptTextColor", "setDefaultRightPostscriptTextColor", "defaultRightTextColor", "getDefaultRightTextColor", "setDefaultRightTextColor", "defaultSubTextColor", "getDefaultSubTextColor", "setDefaultSubTextColor", "defaultTailIcon", "getDefaultTailIcon", "setDefaultTailIcon", "defaultTailTextColor", "getDefaultTailTextColor", "setDefaultTailTextColor", "defaultTextColor", "getDefaultTextColor", "setDefaultTextColor", "defaultTextIcon", "getDefaultTextIcon", "setDefaultTextIcon", "descendingTailIcon", "getDescendingTailIcon", "setDescendingTailIcon", SubInfo.KEY_FORMAT, "getFormat", "setFormat", "hintColor", "getHintColor", "setHintColor", "isAlwaysBold", "", "()I", "setAlwaysBold", "(I)V", "listBgColor", "", "getListBgColor", "()Ljava/util/List;", "setListBgColor", "(Ljava/util/List;)V", "pattern", "getPattern", "setPattern", "selectedBgColor", "getSelectedBgColor", "setSelectedBgColor", "selectedBorderColor", "getSelectedBorderColor", "setSelectedBorderColor", "selectedComponentImage", "getSelectedComponentImage", "setSelectedComponentImage", "selectedEndTimeBgColor", "getSelectedEndTimeBgColor", "setSelectedEndTimeBgColor", "selectedHeadIcon", "getSelectedHeadIcon", "setSelectedHeadIcon", "selectedHeadLineColor", "getSelectedHeadLineColor", "setSelectedHeadLineColor", "selectedHeadTextColor", "getSelectedHeadTextColor", "setSelectedHeadTextColor", "selectedLeftBgIcon", "getSelectedLeftBgIcon", "setSelectedLeftBgIcon", "selectedLeftPostscriptTextColor", "getSelectedLeftPostscriptTextColor", "setSelectedLeftPostscriptTextColor", "selectedLeftTextColor", "getSelectedLeftTextColor", "setSelectedLeftTextColor", "selectedPostscriptTextColor", "getSelectedPostscriptTextColor", "setSelectedPostscriptTextColor", "selectedRightBgIcon", "getSelectedRightBgIcon", "setSelectedRightBgIcon", "selectedRightPostscriptTextColor", "getSelectedRightPostscriptTextColor", "setSelectedRightPostscriptTextColor", "selectedRightTextColor", "getSelectedRightTextColor", "setSelectedRightTextColor", "selectedSubTextColor", "getSelectedSubTextColor", "setSelectedSubTextColor", "selectedTailIcon", "getSelectedTailIcon", "setSelectedTailIcon", "selectedTailTextColor", "getSelectedTailTextColor", "setSelectedTailTextColor", "selectedTextColor", "getSelectedTextColor", "setSelectedTextColor", "selectedTextIcon", "getSelectedTextIcon", "setSelectedTextIcon", "selectingBgColor", "getSelectingBgColor", "setSelectingBgColor", "selectingComponentImage", "getSelectingComponentImage", "setSelectingComponentImage", "selectingHeadIcon", "getSelectingHeadIcon", "setSelectingHeadIcon", "selectingSubTextColor", "getSelectingSubTextColor", "setSelectingSubTextColor", "selectingTailIcon", "getSelectingTailIcon", "setSelectingTailIcon", "selectingTextColor", "getSelectingTextColor", "setSelectingTextColor", "switchImage", "getSwitchImage", "setSwitchImage", "switchToImage", "getSwitchToImage", "setSwitchToImage", "tailIconLeftMargin", "getTailIconLeftMargin", "()Ljava/lang/Integer;", "setTailIconLeftMargin", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "textSize", "getTextSize", "setTextSize", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StyleItem implements Serializable {

    @SerializedName("ascending_tail_icon")
    private IconStruct ascendingTailIcon;

    @SerializedName("city_default_head_icon")
    private IconStruct cityDefaultHeadIcon;

    @SerializedName("city_selected_head_icon")
    private IconStruct citySelectedHeadIcon;

    @SerializedName("city_selecting_head_icon")
    private IconStruct citySelectingHeadIcon;

    @SerializedName("date_color")
    private String dateColor;

    @SerializedName("default_bg_color")
    private String defaultBgColor;

    @SerializedName("default_border_color")
    private String defaultBorderColor;

    @SerializedName("default_component_image")
    private IconStruct defaultComponentImage;

    @SerializedName("default_date_color")
    private String defaultDateColor;

    @SerializedName("default_end_time_bg_color")
    private String defaultEndTimeBgColor;

    @SerializedName("default_head_icon")
    private IconStruct defaultHeadIcon;

    @SerializedName("default_head_text_color")
    private String defaultHeadTextColor;

    @SerializedName("default_hint_color")
    private String defaultHintColor;

    @SerializedName("default_left_bg_icon")
    private IconStruct defaultLeftBgIcon;

    @SerializedName("default_left_postscript_text_color")
    private String defaultLeftPostscriptTextColor;

    @SerializedName("default_left_text_color")
    private String defaultLeftTextColor;

    @SerializedName("default_postscript_text_color")
    private String defaultPostscriptTextColor;

    @SerializedName("default_right_bg_icon")
    private IconStruct defaultRightBgIcon;

    @SerializedName("default_right_postscript_text_color")
    private String defaultRightPostscriptTextColor;

    @SerializedName("default_right_text_color")
    private String defaultRightTextColor;

    @SerializedName("default_sub_text_color")
    private String defaultSubTextColor;

    @SerializedName("default_tail_icon")
    private IconStruct defaultTailIcon;

    @SerializedName("default_tail_text_color")
    private String defaultTailTextColor;

    @SerializedName("default_text_color")
    private String defaultTextColor;

    @SerializedName("default_text_icon")
    private IconStruct defaultTextIcon;

    @SerializedName("descending_tail_icon")
    private IconStruct descendingTailIcon;

    @SerializedName(SubInfo.KEY_FORMAT)
    private String format;

    @SerializedName("hint_color")
    private String hintColor;

    @SerializedName("is_always_bold")
    private int isAlwaysBold;

    @SerializedName("list_bg_color")
    private List<String> listBgColor;

    @SerializedName("pattern")
    private String pattern;

    @SerializedName("selected_bg_color")
    private String selectedBgColor;

    @SerializedName("selected_border_color")
    private String selectedBorderColor;

    @SerializedName("selected_component_image")
    private IconStruct selectedComponentImage;

    @SerializedName("selected_end_time_bg_color")
    private String selectedEndTimeBgColor;

    @SerializedName("selected_head_icon")
    private IconStruct selectedHeadIcon;

    @SerializedName("selected_head_line_color")
    private String selectedHeadLineColor;

    @SerializedName("selected_head_text_color")
    private String selectedHeadTextColor;

    @SerializedName("selected_left_bg_icon")
    private IconStruct selectedLeftBgIcon;

    @SerializedName("selected_left_postscript_text_color")
    private String selectedLeftPostscriptTextColor;

    @SerializedName("selected_left_text_color")
    private String selectedLeftTextColor;

    @SerializedName("selected_postscript_text_color")
    private String selectedPostscriptTextColor;

    @SerializedName("selected_right_bg_icon")
    private IconStruct selectedRightBgIcon;

    @SerializedName("selected_right_postscript_text_color")
    private String selectedRightPostscriptTextColor;

    @SerializedName("selected_right_text_color")
    private String selectedRightTextColor;

    @SerializedName("selected_sub_text_color")
    private String selectedSubTextColor;

    @SerializedName("selected_tail_icon")
    private IconStruct selectedTailIcon;

    @SerializedName("selected_tail_text_color")
    private String selectedTailTextColor;

    @SerializedName("selected_text_color")
    private String selectedTextColor;

    @SerializedName("selected_text_icon")
    private IconStruct selectedTextIcon;

    @SerializedName("selecting_bg_color")
    private String selectingBgColor;

    @SerializedName("selecting_component_image")
    private IconStruct selectingComponentImage;

    @SerializedName("selecting_head_icon")
    private IconStruct selectingHeadIcon;

    @SerializedName("selecting_sub_text_color")
    private String selectingSubTextColor;

    @SerializedName("selecting_tail_icon")
    private IconStruct selectingTailIcon;

    @SerializedName("selecting_text_color")
    private String selectingTextColor;

    @SerializedName("image")
    private IconStruct switchImage;

    @SerializedName("to_image")
    private IconStruct switchToImage;

    @SerializedName("tail_icon_left_margin")
    private Integer tailIconLeftMargin;

    @SerializedName("text_size")
    private String textSize;

    public StyleItem() {
    }

    public final IconStruct getAscendingTailIcon() {
        return this.ascendingTailIcon;
    }

    public final IconStruct getCityDefaultHeadIcon() {
        return this.cityDefaultHeadIcon;
    }

    public final IconStruct getCitySelectedHeadIcon() {
        return this.citySelectedHeadIcon;
    }

    public final IconStruct getCitySelectingHeadIcon() {
        return this.citySelectingHeadIcon;
    }

    public final String getDateColor() {
        return this.dateColor;
    }

    public final String getDefaultBgColor() {
        return this.defaultBgColor;
    }

    public final String getDefaultBorderColor() {
        return this.defaultBorderColor;
    }

    public final IconStruct getDefaultComponentImage() {
        return this.defaultComponentImage;
    }

    public final String getDefaultDateColor() {
        return this.defaultDateColor;
    }

    public final String getDefaultEndTimeBgColor() {
        return this.defaultEndTimeBgColor;
    }

    public final IconStruct getDefaultHeadIcon() {
        return this.defaultHeadIcon;
    }

    public final String getDefaultHeadTextColor() {
        return this.defaultHeadTextColor;
    }

    public final String getDefaultHintColor() {
        return this.defaultHintColor;
    }

    public final IconStruct getDefaultLeftBgIcon() {
        return this.defaultLeftBgIcon;
    }

    public final String getDefaultLeftPostscriptTextColor() {
        return this.defaultLeftPostscriptTextColor;
    }

    public final String getDefaultLeftTextColor() {
        return this.defaultLeftTextColor;
    }

    public final String getDefaultPostscriptTextColor() {
        return this.defaultPostscriptTextColor;
    }

    public final IconStruct getDefaultRightBgIcon() {
        return this.defaultRightBgIcon;
    }

    public final String getDefaultRightPostscriptTextColor() {
        return this.defaultRightPostscriptTextColor;
    }

    public final String getDefaultRightTextColor() {
        return this.defaultRightTextColor;
    }

    public final String getDefaultSubTextColor() {
        return this.defaultSubTextColor;
    }

    public final IconStruct getDefaultTailIcon() {
        return this.defaultTailIcon;
    }

    public final String getDefaultTailTextColor() {
        return this.defaultTailTextColor;
    }

    public final String getDefaultTextColor() {
        return this.defaultTextColor;
    }

    public final IconStruct getDefaultTextIcon() {
        return this.defaultTextIcon;
    }

    public final IconStruct getDescendingTailIcon() {
        return this.descendingTailIcon;
    }

    public final String getFormat() {
        return this.format;
    }

    public final String getHintColor() {
        return this.hintColor;
    }

    public final List<String> getListBgColor() {
        return this.listBgColor;
    }

    public final String getPattern() {
        return this.pattern;
    }

    public final String getSelectedBgColor() {
        return this.selectedBgColor;
    }

    public final String getSelectedBorderColor() {
        return this.selectedBorderColor;
    }

    public final IconStruct getSelectedComponentImage() {
        return this.selectedComponentImage;
    }

    public final String getSelectedEndTimeBgColor() {
        return this.selectedEndTimeBgColor;
    }

    public final IconStruct getSelectedHeadIcon() {
        return this.selectedHeadIcon;
    }

    public final String getSelectedHeadLineColor() {
        return this.selectedHeadLineColor;
    }

    public final String getSelectedHeadTextColor() {
        return this.selectedHeadTextColor;
    }

    public final IconStruct getSelectedLeftBgIcon() {
        return this.selectedLeftBgIcon;
    }

    public final String getSelectedLeftPostscriptTextColor() {
        return this.selectedLeftPostscriptTextColor;
    }

    public final String getSelectedLeftTextColor() {
        return this.selectedLeftTextColor;
    }

    public final String getSelectedPostscriptTextColor() {
        return this.selectedPostscriptTextColor;
    }

    public final IconStruct getSelectedRightBgIcon() {
        return this.selectedRightBgIcon;
    }

    public final String getSelectedRightPostscriptTextColor() {
        return this.selectedRightPostscriptTextColor;
    }

    public final String getSelectedRightTextColor() {
        return this.selectedRightTextColor;
    }

    public final String getSelectedSubTextColor() {
        return this.selectedSubTextColor;
    }

    public final IconStruct getSelectedTailIcon() {
        return this.selectedTailIcon;
    }

    public final String getSelectedTailTextColor() {
        return this.selectedTailTextColor;
    }

    public final String getSelectedTextColor() {
        return this.selectedTextColor;
    }

    public final IconStruct getSelectedTextIcon() {
        return this.selectedTextIcon;
    }

    public final String getSelectingBgColor() {
        return this.selectingBgColor;
    }

    public final IconStruct getSelectingComponentImage() {
        return this.selectingComponentImage;
    }

    public final IconStruct getSelectingHeadIcon() {
        return this.selectingHeadIcon;
    }

    public final String getSelectingSubTextColor() {
        return this.selectingSubTextColor;
    }

    public final IconStruct getSelectingTailIcon() {
        return this.selectingTailIcon;
    }

    public final String getSelectingTextColor() {
        return this.selectingTextColor;
    }

    public final IconStruct getSwitchImage() {
        return this.switchImage;
    }

    public final IconStruct getSwitchToImage() {
        return this.switchToImage;
    }

    public final Integer getTailIconLeftMargin() {
        return this.tailIconLeftMargin;
    }

    public final String getTextSize() {
        return this.textSize;
    }

    public final int isAlwaysBold() {
        return this.isAlwaysBold;
    }

    public final void setAlwaysBold(int r100) {
        this.isAlwaysBold = r100;
    }

    public final void setAscendingTailIcon(IconStruct r100) {
        this.ascendingTailIcon = r100;
    }

    public final void setCityDefaultHeadIcon(IconStruct r100) {
        this.cityDefaultHeadIcon = r100;
    }

    public final void setCitySelectedHeadIcon(IconStruct r100) {
        this.citySelectedHeadIcon = r100;
    }

    public final void setCitySelectingHeadIcon(IconStruct r100) {
        this.citySelectingHeadIcon = r100;
    }

    public final void setDateColor(String r100) {
        this.dateColor = r100;
    }

    public final void setDefaultBgColor(String r100) {
        this.defaultBgColor = r100;
    }

    public final void setDefaultBorderColor(String r100) {
        this.defaultBorderColor = r100;
    }

    public final void setDefaultComponentImage(IconStruct r100) {
        this.defaultComponentImage = r100;
    }

    public final void setDefaultDateColor(String r100) {
        this.defaultDateColor = r100;
    }

    public final void setDefaultEndTimeBgColor(String r100) {
        this.defaultEndTimeBgColor = r100;
    }

    public final void setDefaultHeadIcon(IconStruct r100) {
        this.defaultHeadIcon = r100;
    }

    public final void setDefaultHeadTextColor(String r100) {
        this.defaultHeadTextColor = r100;
    }

    public final void setDefaultHintColor(String r100) {
        this.defaultHintColor = r100;
    }

    public final void setDefaultLeftBgIcon(IconStruct r100) {
        this.defaultLeftBgIcon = r100;
    }

    public final void setDefaultLeftPostscriptTextColor(String r100) {
        this.defaultLeftPostscriptTextColor = r100;
    }

    public final void setDefaultLeftTextColor(String r100) {
        this.defaultLeftTextColor = r100;
    }

    public final void setDefaultPostscriptTextColor(String r100) {
        this.defaultPostscriptTextColor = r100;
    }

    public final void setDefaultRightBgIcon(IconStruct r100) {
        this.defaultRightBgIcon = r100;
    }

    public final void setDefaultRightPostscriptTextColor(String r100) {
        this.defaultRightPostscriptTextColor = r100;
    }

    public final void setDefaultRightTextColor(String r100) {
        this.defaultRightTextColor = r100;
    }

    public final void setDefaultSubTextColor(String r100) {
        this.defaultSubTextColor = r100;
    }

    public final void setDefaultTailIcon(IconStruct r100) {
        this.defaultTailIcon = r100;
    }

    public final void setDefaultTailTextColor(String r100) {
        this.defaultTailTextColor = r100;
    }

    public final void setDefaultTextColor(String r100) {
        this.defaultTextColor = r100;
    }

    public final void setDefaultTextIcon(IconStruct r100) {
        this.defaultTextIcon = r100;
    }

    public final void setDescendingTailIcon(IconStruct r100) {
        this.descendingTailIcon = r100;
    }

    public final void setFormat(String r100) {
        this.format = r100;
    }

    public final void setHintColor(String r100) {
        this.hintColor = r100;
    }

    public final void setListBgColor(List<String> r100) {
        this.listBgColor = r100;
    }

    public final void setPattern(String r100) {
        this.pattern = r100;
    }

    public final void setSelectedBgColor(String r100) {
        this.selectedBgColor = r100;
    }

    public final void setSelectedBorderColor(String r100) {
        this.selectedBorderColor = r100;
    }

    public final void setSelectedComponentImage(IconStruct r100) {
        this.selectedComponentImage = r100;
    }

    public final void setSelectedEndTimeBgColor(String r100) {
        this.selectedEndTimeBgColor = r100;
    }

    public final void setSelectedHeadIcon(IconStruct r100) {
        this.selectedHeadIcon = r100;
    }

    public final void setSelectedHeadLineColor(String r100) {
        this.selectedHeadLineColor = r100;
    }

    public final void setSelectedHeadTextColor(String r100) {
        this.selectedHeadTextColor = r100;
    }

    public final void setSelectedLeftBgIcon(IconStruct r100) {
        this.selectedLeftBgIcon = r100;
    }

    public final void setSelectedLeftPostscriptTextColor(String r100) {
        this.selectedLeftPostscriptTextColor = r100;
    }

    public final void setSelectedLeftTextColor(String r100) {
        this.selectedLeftTextColor = r100;
    }

    public final void setSelectedPostscriptTextColor(String r100) {
        this.selectedPostscriptTextColor = r100;
    }

    public final void setSelectedRightBgIcon(IconStruct r100) {
        this.selectedRightBgIcon = r100;
    }

    public final void setSelectedRightPostscriptTextColor(String r100) {
        this.selectedRightPostscriptTextColor = r100;
    }

    public final void setSelectedRightTextColor(String r100) {
        this.selectedRightTextColor = r100;
    }

    public final void setSelectedSubTextColor(String r100) {
        this.selectedSubTextColor = r100;
    }

    public final void setSelectedTailIcon(IconStruct r100) {
        this.selectedTailIcon = r100;
    }

    public final void setSelectedTailTextColor(String r100) {
        this.selectedTailTextColor = r100;
    }

    public final void setSelectedTextColor(String r100) {
        this.selectedTextColor = r100;
    }

    public final void setSelectedTextIcon(IconStruct r100) {
        this.selectedTextIcon = r100;
    }

    public final void setSelectingBgColor(String r100) {
        this.selectingBgColor = r100;
    }

    public final void setSelectingComponentImage(IconStruct r100) {
        this.selectingComponentImage = r100;
    }

    public final void setSelectingHeadIcon(IconStruct r100) {
        this.selectingHeadIcon = r100;
    }

    public final void setSelectingSubTextColor(String r100) {
        this.selectingSubTextColor = r100;
    }

    public final void setSelectingTailIcon(IconStruct r100) {
        this.selectingTailIcon = r100;
    }

    public final void setSelectingTextColor(String r100) {
        this.selectingTextColor = r100;
    }

    public final void setSwitchImage(IconStruct r100) {
        this.switchImage = r100;
    }

    public final void setSwitchToImage(IconStruct r100) {
        this.switchToImage = r100;
    }

    public final void setTailIconLeftMargin(Integer r100) {
        this.tailIconLeftMargin = r100;
    }

    public final void setTextSize(String r100) {
        this.textSize = r100;
    }
}
