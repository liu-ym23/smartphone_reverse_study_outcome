package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b;\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 ]2\u00020\u0001:\u0001]BÅ\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0007HÆ\u0003J\u0011\u0010>\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0011\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\u0011\u0010A\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0011\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u0011\u0010D\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0011\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\u0011\u0010G\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0011\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\u0011\u0010J\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0011\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0003J\t\u0010L\u001a\u00020\u0019HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\u0011\u0010N\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0011\u0010O\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003JÇ\u0002\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00032\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00032\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00032\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\b\b\u0002\u0010\u001d\u001a\u00020\u0003HÆ\u0001J\u0006\u0010R\u001a\u00020\u0019J\u0013\u0010S\u001a\u00020\u00032\b\u0010T\u001a\u0004\u0018\u00010UHÖ\u0003J\t\u0010V\u001a\u00020\u0019HÖ\u0001J\t\u0010W\u001a\u00020\u0005HÖ\u0001J\u0016\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020\u0019R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010'R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010!R\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010'R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010'R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010'R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010'R\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010!R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010'R\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010'R\u0016\u0010\u0018\u001a\u00020\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0016\u0010\u001a\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010!R\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010'R\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010'R\u0016\u0010\u001d\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010!¨\u0006^"}, d2 = {"Lcom/larus/bmhome/auth/QuotaConfig;", "Landroid/os/Parcelable;", "showQuota", "", "quotaStyle", "", "displayIntervalDays", "", "enabledBotTypeList", "", "", "botIdsBlackListForQuota", "showOgfSwitch", "switchEnabledBotTypeList", "botIdsBlackListForSwitch", "showSearch", "searchEnabledBotTypeList", "botIdsBlackListForSearch", "showRegenByOgf", "regenByOgfEnabledBotTypeList", "botIdsBlackListForRegenByOgf", "haveSpecificPlaceholderAndBubbleForOgf", "placeholderAndBubbleEnabledBotTypeList", "botIdsBlackListForPlaceholderAndBubble", "regenerateType", "", "showExpert", "expertEnabledBotTypeList", "botIdsBlackListForExpert", "regenerateSendNewMsg", "<init>", "(ZLjava/lang/String;DLjava/util/List;Ljava/util/List;ZLjava/util/List;Ljava/util/List;ZLjava/util/List;Ljava/util/List;ZLjava/util/List;Ljava/util/List;ZLjava/util/List;Ljava/util/List;IZLjava/util/List;Ljava/util/List;Z)V", "getShowQuota", "()Z", "getQuotaStyle", "()Ljava/lang/String;", "getDisplayIntervalDays", "()D", "getEnabledBotTypeList", "()Ljava/util/List;", "getBotIdsBlackListForQuota", "getShowOgfSwitch", "getSwitchEnabledBotTypeList", "getBotIdsBlackListForSwitch", "getShowSearch", "getSearchEnabledBotTypeList", "getBotIdsBlackListForSearch", "getShowRegenByOgf", "getRegenByOgfEnabledBotTypeList", "getBotIdsBlackListForRegenByOgf", "getHaveSpecificPlaceholderAndBubbleForOgf", "getPlaceholderAndBubbleEnabledBotTypeList", "getBotIdsBlackListForPlaceholderAndBubble", "getRegenerateType", "()I", "getShowExpert", "getExpertEnabledBotTypeList", "getBotIdsBlackListForExpert", "getRegenerateSendNewMsg", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuotaConfig implements Parcelable {
    public static final Parcelable.Creator<QuotaConfig> CREATOR = null;

    @SerializedName("bot_ids_black_list_for_expert_mode")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> botIdsBlackListForExpert;

    @SerializedName("bot_ids_black_list_for_placeholder_and_bubble")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> botIdsBlackListForPlaceholderAndBubble;

    @SerializedName("bot_ids_black_list_for_quota")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> botIdsBlackListForQuota;

    @SerializedName("bot_ids_black_list_for_regen_by_ogf")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> botIdsBlackListForRegenByOgf;

    @SerializedName("bot_ids_black_list_for_search")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> botIdsBlackListForSearch;

    @SerializedName("bot_ids_black_list_for_switch")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> botIdsBlackListForSwitch;

    @SerializedName("banner_hide_in_days")
    private final double displayIntervalDays;

    @SerializedName("enabled_bot_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<Long> enabledBotTypeList;

    @SerializedName("expert_mode_enabled_bot_type_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<Long> expertEnabledBotTypeList;

    @SerializedName("have_specific_placeholder_and_bubble_for_ogf")
    private final boolean haveSpecificPlaceholderAndBubbleForOgf;

    @SerializedName("placeholder_and_bubble_enabled_bot_type_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<Long> placeholderAndBubbleEnabledBotTypeList;

    @SerializedName("ogf_quota_display_style")
    private final String quotaStyle;

    @SerializedName("regen_by_ogf_enabled_bot_type_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<Long> regenByOgfEnabledBotTypeList;

    @SerializedName("regenerate_send_new_msg")
    private final boolean regenerateSendNewMsg;

    @SerializedName("regenerate_type")
    private final int regenerateType;

    @SerializedName("search_enabled_bot_type_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<Long> searchEnabledBotTypeList;

    @SerializedName("show_expert_mode")
    private final boolean showExpert;

    @SerializedName("show_ogf_switch")
    private final boolean showOgfSwitch;

    @SerializedName("show_ogf_quota")
    private final boolean showQuota;

    @SerializedName("show_regen_by_ogf")
    private final boolean showRegenByOgf;

    @SerializedName("show_search")
    private final boolean showSearch;

    @SerializedName("switch_enabled_bot_type_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<Long> switchEnabledBotTypeList;

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a {
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class b implements Parcelable.Creator<QuotaConfig> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final QuotaConfig createFromParcel(Parcel r210) {
            Intrinsics.checkNotNullParameter(r210, "parcel");
            if (r210.readInt() == 0) goto L5;
            boolean r100 = true;
        L6:
            String r101 = r210.readString();
            double r102 = r210.readDouble();
            if (r210.readInt() != 0) goto L9;
            ArrayList r103 = null;
        L12:
            ArrayList<String> r110 = r210.createStringArrayList();
            if (r210.readInt() == 0) goto L15;
            boolean r111 = true;
        L17:
            if (r210.readInt() != 0) goto L19;
            ArrayList r112 = null;
        L22:
            ArrayList<String> r113 = r210.createStringArrayList();
            if (r210.readInt() == 0) goto L25;
            boolean r114 = true;
        L27:
            if (r210.readInt() != 0) goto L29;
            ArrayList r115 = null;
        L32:
            ArrayList<String> r104 = r210.createStringArrayList();
            if (r210.readInt() == 0) goto L35;
            boolean r116 = true;
        L37:
            if (r210.readInt() != 0) goto L39;
            ArrayList r105 = null;
        L42:
            ArrayList<String> r106 = r210.createStringArrayList();
            if (r210.readInt() == 0) goto L45;
            boolean r211 = true;
        L47:
            if (r210.readInt() != 0) goto L49;
            ArrayList r107 = null;
        L53:
            ArrayList<String> r212 = r210.createStringArrayList();
            int r213 = r210.readInt();
            if (r210.readInt() == 0) goto L56;
            boolean r214 = true;
        L58:
            if (r210.readInt() != 0) goto L60;
            ArrayList r108 = null;
        L64:
            ArrayList<String> r215 = r210.createStringArrayList();
            if (r210.readInt() == 0) goto L67;
            boolean r216 = true;
        L69:
            return new QuotaConfig(r100, r101, r102, r103, r110, r111, r112, r113, r114, r115, r104, r116, r105, r106, r211, r107, r212, r213, r214, r108, r215, r216);
        L67:
            r216 = false;
            goto L69
        L60:
            int r109 = r210.readInt();
            ArrayList r117 = new ArrayList(r109);
            int r118 = 0;
        L61:
            if (r118 == r109) goto L63;
            int r119 = r109;
            r117.add(Long.valueOf(r210.readLong()));
            r118 = r118 + 1;
            r109 = r119;
            goto L61
        L63:
            r108 = r117;
            goto L64
        L56:
            r214 = false;
            goto L58
        L49:
            int r120 = r210.readInt();
            ArrayList r121 = new ArrayList(r120);
            int r122 = 0;
        L50:
            if (r122 == r120) goto L52;
            int r217 = r120;
            r121.add(Long.valueOf(r210.readLong()));
            r122 = r122 + 1;
            r120 = r217;
            goto L50
        L52:
            r107 = r121;
            goto L53
        L45:
            r211 = false;
            goto L47
        L39:
            int r123 = r210.readInt();
            r105 = new ArrayList(r123);
            int r124 = 0;
        L40:
            if (r124 == r123) goto L42;
            r105.add(Long.valueOf(r210.readLong()));
            r124 = r124 + 1;
            goto L40
        L35:
            r116 = false;
            goto L37
        L29:
            int r125 = r210.readInt();
            r115 = new ArrayList(r125);
            int r126 = 0;
        L30:
            if (r126 == r125) goto L32;
            r115.add(Long.valueOf(r210.readLong()));
            r126 = r126 + 1;
            goto L30
        L25:
            r114 = false;
            goto L27
        L19:
            int r127 = r210.readInt();
            r112 = new ArrayList(r127);
            int r128 = 0;
        L20:
            if (r128 == r127) goto L22;
            r112.add(Long.valueOf(r210.readLong()));
            r128 = r128 + 1;
            goto L20
        L15:
            r111 = false;
            goto L17
        L9:
            int r129 = r210.readInt();
            r103 = new ArrayList(r129);
            int r130 = 0;
        L10:
            if (r130 == r129) goto L12;
            r103.add(Long.valueOf(r210.readLong()));
            r130 = r130 + 1;
            goto L10
        L5:
            r100 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final QuotaConfig[] newArray(int r100) {
            return new QuotaConfig[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    public QuotaConfig() {
        this(false, "", AudioStats.AUDIO_AMPLITUDE_NONE, CollectionsKt.emptyList(), CollectionsKt.emptyList(), false, CollectionsKt.emptyList(), CollectionsKt.emptyList(), false, CollectionsKt.emptyList(), CollectionsKt.emptyList(), false, CollectionsKt.emptyList(), CollectionsKt.emptyList(), false, CollectionsKt.emptyList(), CollectionsKt.emptyList(), 0, false, CollectionsKt.emptyList(), CollectionsKt.emptyList(), false);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof QuotaConfig) == true) goto L8;
        return false;
    L8:
        QuotaConfig r101 = (QuotaConfig) r100;
        if (this.showQuota == r101.showQuota) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.quotaStyle, r101.quotaStyle) == true) goto L15;
        return false;
    L15:
        if (Double.compare(this.displayIntervalDays, r101.displayIntervalDays) == 0) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.enabledBotTypeList, r101.enabledBotTypeList) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.botIdsBlackListForQuota, r101.botIdsBlackListForQuota) == true) goto L24;
        return false;
    L24:
        if (this.showOgfSwitch == r101.showOgfSwitch) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.switchEnabledBotTypeList, r101.switchEnabledBotTypeList) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.botIdsBlackListForSwitch, r101.botIdsBlackListForSwitch) == true) goto L33;
        return false;
    L33:
        if (this.showSearch == r101.showSearch) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.searchEnabledBotTypeList, r101.searchEnabledBotTypeList) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.botIdsBlackListForSearch, r101.botIdsBlackListForSearch) == true) goto L42;
        return false;
    L42:
        if (this.showRegenByOgf == r101.showRegenByOgf) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.regenByOgfEnabledBotTypeList, r101.regenByOgfEnabledBotTypeList) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.botIdsBlackListForRegenByOgf, r101.botIdsBlackListForRegenByOgf) == true) goto L51;
        return false;
    L51:
        if (this.haveSpecificPlaceholderAndBubbleForOgf == r101.haveSpecificPlaceholderAndBubbleForOgf) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.placeholderAndBubbleEnabledBotTypeList, r101.placeholderAndBubbleEnabledBotTypeList) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.botIdsBlackListForPlaceholderAndBubble, r101.botIdsBlackListForPlaceholderAndBubble) == true) goto L60;
        return false;
    L60:
        if (this.regenerateType == r101.regenerateType) goto L63;
        return false;
    L63:
        if (this.showExpert == r101.showExpert) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.expertEnabledBotTypeList, r101.expertEnabledBotTypeList) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.botIdsBlackListForExpert, r101.botIdsBlackListForExpert) == true) goto L72;
        return false;
    L72:
        if (this.regenerateSendNewMsg == r101.regenerateSendNewMsg) goto L74;
        return false;
    L74:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.showQuota == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        String r103 = this.quotaStyle;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        long r106 = Double.doubleToLongBits(this.displayIntervalDays);
        int r107 = (((r102 + r105) * 31) + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        List<Long> r108 = this.enabledBotTypeList;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        List<String> r111 = this.botIdsBlackListForQuota;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        if (this.showOgfSwitch == false) goto L21;
        int r114 = 1231;
    L22:
        int r115 = (r113 + r114) * 31;
        List<Long> r116 = this.switchEnabledBotTypeList;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        List<String> r119 = this.botIdsBlackListForSwitch;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        if (this.showSearch == false) goto L33;
        int r122 = 1231;
    L34:
        int r123 = (r121 + r122) * 31;
        List<Long> r124 = this.searchEnabledBotTypeList;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        List<String> r127 = this.botIdsBlackListForSearch;
        if (r127 != null) goto L41;
        int r128 = 0;
    L42:
        int r129 = (r126 + r128) * 31;
        if (this.showRegenByOgf == false) goto L45;
        int r130 = 1231;
    L46:
        int r131 = (r129 + r130) * 31;
        List<Long> r132 = this.regenByOgfEnabledBotTypeList;
        if (r132 != null) goto L49;
        int r133 = 0;
    L50:
        int r134 = (r131 + r133) * 31;
        List<String> r135 = this.botIdsBlackListForRegenByOgf;
        if (r135 != null) goto L53;
        int r136 = 0;
    L54:
        int r137 = (r134 + r136) * 31;
        if (this.haveSpecificPlaceholderAndBubbleForOgf == false) goto L57;
        int r138 = 1231;
    L58:
        int r139 = (r137 + r138) * 31;
        List<Long> r140 = this.placeholderAndBubbleEnabledBotTypeList;
        if (r140 != null) goto L61;
        int r141 = 0;
    L62:
        int r142 = (r139 + r141) * 31;
        List<String> r143 = this.botIdsBlackListForPlaceholderAndBubble;
        if (r143 != null) goto L65;
        int r144 = 0;
    L66:
        int r145 = (((r142 + r144) * 31) + this.regenerateType) * 31;
        if (this.showExpert == false) goto L69;
        int r146 = 1231;
    L70:
        int r147 = (r145 + r146) * 31;
        List<Long> r148 = this.expertEnabledBotTypeList;
        if (r148 != null) goto L73;
        int r149 = 0;
    L74:
        int r150 = (r147 + r149) * 31;
        List<String> r151 = this.botIdsBlackListForExpert;
        if (r151 == null) goto L78;
        r104 = r151.hashCode();
    L78:
        int r152 = (r150 + r104) * 31;
        if (this.regenerateSendNewMsg == true) goto L83;
        r100 = 1237;
    L83:
        return r152 + r100;
    L73:
        r149 = r148.hashCode();
        goto L74
    L69:
        r146 = 1237;
        goto L70
    L65:
        r144 = r143.hashCode();
        goto L66
    L61:
        r141 = r140.hashCode();
        goto L62
    L57:
        r138 = 1237;
        goto L58
    L53:
        r136 = r135.hashCode();
        goto L54
    L49:
        r133 = r132.hashCode();
        goto L50
    L45:
        r130 = 1237;
        goto L46
    L41:
        r128 = r127.hashCode();
        goto L42
    L37:
        r125 = r124.hashCode();
        goto L38
    L33:
        r122 = 1237;
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = 1237;
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "QuotaConfig(showQuota=" + this.showQuota + ", quotaStyle=" + this.quotaStyle + ", displayIntervalDays=" + this.displayIntervalDays + ", enabledBotTypeList=" + this.enabledBotTypeList + ", botIdsBlackListForQuota=" + this.botIdsBlackListForQuota + ", showOgfSwitch=" + this.showOgfSwitch + ", switchEnabledBotTypeList=" + this.switchEnabledBotTypeList + ", botIdsBlackListForSwitch=" + this.botIdsBlackListForSwitch + ", showSearch=" + this.showSearch + ", searchEnabledBotTypeList=" + this.searchEnabledBotTypeList + ", botIdsBlackListForSearch=" + this.botIdsBlackListForSearch + ", showRegenByOgf=" + this.showRegenByOgf + ", regenByOgfEnabledBotTypeList=" + this.regenByOgfEnabledBotTypeList + ", botIdsBlackListForRegenByOgf=" + this.botIdsBlackListForRegenByOgf + ", haveSpecificPlaceholderAndBubbleForOgf=" + this.haveSpecificPlaceholderAndBubbleForOgf + ", placeholderAndBubbleEnabledBotTypeList=" + this.placeholderAndBubbleEnabledBotTypeList + ", botIdsBlackListForPlaceholderAndBubble=" + this.botIdsBlackListForPlaceholderAndBubble + ", regenerateType=" + this.regenerateType + ", showExpert=" + this.showExpert + ", expertEnabledBotTypeList=" + this.expertEnabledBotTypeList + ", botIdsBlackListForExpert=" + this.botIdsBlackListForExpert + ", regenerateSendNewMsg=" + this.regenerateSendNewMsg + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.showQuota ? 1 : 0);
        r100.writeString(this.quotaStyle);
        r100.writeDouble(this.displayIntervalDays);
        List<Long> r102 = this.enabledBotTypeList;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L9:
        r100.writeStringList(this.botIdsBlackListForQuota);
        r100.writeInt(this.showOgfSwitch ? 1 : 0);
        List<Long> r103 = this.switchEnabledBotTypeList;
        if (r103 != null) goto L12;
        r100.writeInt(0);
    L16:
        r100.writeStringList(this.botIdsBlackListForSwitch);
        r100.writeInt(this.showSearch ? 1 : 0);
        List<Long> r104 = this.searchEnabledBotTypeList;
        if (r104 != null) goto L19;
        r100.writeInt(0);
    L23:
        r100.writeStringList(this.botIdsBlackListForSearch);
        r100.writeInt(this.showRegenByOgf ? 1 : 0);
        List<Long> r105 = this.regenByOgfEnabledBotTypeList;
        if (r105 != null) goto L26;
        r100.writeInt(0);
    L30:
        r100.writeStringList(this.botIdsBlackListForRegenByOgf);
        r100.writeInt(this.haveSpecificPlaceholderAndBubbleForOgf ? 1 : 0);
        List<Long> r106 = this.placeholderAndBubbleEnabledBotTypeList;
        if (r106 != null) goto L33;
        r100.writeInt(0);
    L37:
        r100.writeStringList(this.botIdsBlackListForPlaceholderAndBubble);
        r100.writeInt(this.regenerateType);
        r100.writeInt(this.showExpert ? 1 : 0);
        List<Long> r107 = this.expertEnabledBotTypeList;
        if (r107 != null) goto L40;
        r100.writeInt(0);
    L44:
        r100.writeStringList(this.botIdsBlackListForExpert);
        r100.writeInt(this.regenerateSendNewMsg ? 1 : 0);
        return;
    L40:
        r100.writeInt(1);
        r100.writeInt(r107.size());
        Iterator<Long> r108 = r107.iterator();
    L42:
        if (r108.hasNext() == false) goto L44;
        r100.writeLong(r108.next().longValue());
        goto L42
    L33:
        r100.writeInt(1);
        r100.writeInt(r106.size());
        Iterator<Long> r109 = r106.iterator();
    L35:
        if (r109.hasNext() == false) goto L37;
        r100.writeLong(r109.next().longValue());
        goto L35
    L26:
        r100.writeInt(1);
        r100.writeInt(r105.size());
        Iterator<Long> r110 = r105.iterator();
    L28:
        if (r110.hasNext() == false) goto L30;
        r100.writeLong(r110.next().longValue());
        goto L28
    L19:
        r100.writeInt(1);
        r100.writeInt(r104.size());
        Iterator<Long> r111 = r104.iterator();
    L21:
        if (r111.hasNext() == false) goto L23;
        r100.writeLong(r111.next().longValue());
        goto L21
    L12:
        r100.writeInt(1);
        r100.writeInt(r103.size());
        Iterator<Long> r112 = r103.iterator();
    L14:
        if (r112.hasNext() == false) goto L16;
        r100.writeLong(r112.next().longValue());
        goto L14
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<Long> r113 = r102.iterator();
    L7:
        if (r113.hasNext() == false) goto L9;
        r100.writeLong(r113.next().longValue());
        goto L7
    }

    public final List<String> a() {
        return this.botIdsBlackListForPlaceholderAndBubble;
    }

    public final List<String> b() {
        return this.botIdsBlackListForQuota;
    }

    public final double c() {
        return this.displayIntervalDays;
    }

    public final List<Long> d() {
        return this.enabledBotTypeList;
    }

    public final boolean e() {
        return this.haveSpecificPlaceholderAndBubbleForOgf;
    }

    public final List<Long> g() {
        return this.placeholderAndBubbleEnabledBotTypeList;
    }

    public final String h() {
        return this.quotaStyle;
    }

    public final boolean i() {
        return this.showQuota;
    }

    public QuotaConfig(boolean r100, String r101, double r102, List<Long> r103, List<String> r104, boolean r110, List<Long> r111, List<String> r112, boolean r113, List<Long> r114, List<String> r115, boolean r116, List<Long> r117, List<String> r118, boolean r119, List<Long> r210, List<String> r211, int r212, boolean r213, List<Long> r214, List<String> r215, boolean r216) {
        this.showQuota = r100;
        this.quotaStyle = r101;
        this.displayIntervalDays = r102;
        this.enabledBotTypeList = r103;
        this.botIdsBlackListForQuota = r104;
        this.showOgfSwitch = r110;
        this.switchEnabledBotTypeList = r111;
        this.botIdsBlackListForSwitch = r112;
        this.showSearch = r113;
        this.searchEnabledBotTypeList = r114;
        this.botIdsBlackListForSearch = r115;
        this.showRegenByOgf = r116;
        this.regenByOgfEnabledBotTypeList = r117;
        this.botIdsBlackListForRegenByOgf = r118;
        this.haveSpecificPlaceholderAndBubbleForOgf = r119;
        this.placeholderAndBubbleEnabledBotTypeList = r210;
        this.botIdsBlackListForPlaceholderAndBubble = r211;
        this.regenerateType = r212;
        this.showExpert = r213;
        this.expertEnabledBotTypeList = r214;
        this.botIdsBlackListForExpert = r215;
        this.regenerateSendNewMsg = r216;
    }
}
