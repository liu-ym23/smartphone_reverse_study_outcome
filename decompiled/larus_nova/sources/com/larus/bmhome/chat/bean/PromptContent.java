package com.larus.bmhome.chat.bean;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentPublishScene;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.hihonor.honorid.core.data.UserInfo;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotConfItem;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotSourceType;
import com.larus.im.bean.bot.BotStatistic;
import com.larus.im.bean.bot.BotSwitchConfInfo;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.im.bean.bot.FirstMet;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.SceneModelList;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lw8.l;
import v19.h;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b=\b\u0007\u0018\u0000 G2\u00020\u0001:\r@ABCDEFGHIJKLB¥\u0001\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u00108\u001a\u00020\nJ\u0006\u00109\u001a\u00020\nJ\u0006\u0010:\u001a\u00020\fJ\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003J\u0013\u0010<\u001a\u00020\n2\b\u0010=\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010>\u001a\u00020\fH\u0016J\b\u0010?\u001a\u0004\u0018\u00010\u0004R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R&\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R&\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R \u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(R,\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010&\"\u0004\b0\u0010(R \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010&\"\u0004\b2\u0010(R\"\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006M"}, d2 = {"Lcom/larus/bmhome/chat/bean/PromptContent;", "", "suggest", "", "", "suggestV2", "Lcom/larus/bmhome/chat/bean/PromptContent$SuggestV2;", "suggestItems", "Lcom/larus/bmhome/chat/bean/PromptContent$SuggestItem;", "isNoDisappear", "", "suggestActionCardCnt", "", "onboardingDisplayStyle", "sugType", "businessExt", "", "wcbRenderStatus", "wcbTitle", "wcbTitleStyle", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;ZILjava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getSuggest", "()Ljava/util/List;", "setSuggest", "(Ljava/util/List;)V", "getSuggestV2", "setSuggestV2", "getSuggestItems", "setSuggestItems", "()Z", "setNoDisappear", "(Z)V", "getSuggestActionCardCnt", "()I", "setSuggestActionCardCnt", "(I)V", "getOnboardingDisplayStyle", "()Ljava/lang/String;", "setOnboardingDisplayStyle", "(Ljava/lang/String;)V", "getSugType", "setSugType", "getBusinessExt", "()Ljava/util/Map;", "setBusinessExt", "(Ljava/util/Map;)V", "getWcbRenderStatus", "setWcbRenderStatus", "getWcbTitle", "setWcbTitle", "getWcbTitleStyle", "()Ljava/lang/Integer;", "setWcbTitleStyle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "isEmpty", "isPlaceholder", "size", "suggestTxt", "equals", "other", "hashCode", "toJson", "SuggestItem", "SuggestImageItem", "SuggestItemType", "SuggestV2", "SuggestPromptType", "TravelSuggestType", "SuggestV2Extra", "Companion", "SuggestV2ExtraForMultiAction", "SuggestV2Style", "CursorPosition", "DefaultOptionItem", "BotInfo", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromptContent {
    public static final a Companion = null;

    @SerializedName("business_ext")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private Map<String, String> businessExt;

    @SerializedName("no_disappear")
    private boolean isNoDisappear;

    @SerializedName("onboarding_display_style")
    private String onboardingDisplayStyle;

    @SerializedName("sug_type")
    private String sugType;

    @SerializedName("suggest")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<String> suggest;

    @SerializedName("skill_card_cnt")
    private int suggestActionCardCnt;

    @SerializedName("suggest_items")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<SuggestItem> suggestItems;

    @SerializedName("suggest_v2")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<SuggestV2> suggestV2;

    @SerializedName("wcb_render_status")
    private String wcbRenderStatus;

    @SerializedName("wcb_title")
    private String wcbTitle;

    @SerializedName("wcb_title_style")
    private Integer wcbTitleStyle;

    @Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b|\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BÃ\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\n\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010+\u001a\u00020\u0017\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u000100\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u000107¢\u0006\u0004\b8\u00109J\u0011\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010;J\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010;J\u0011\u0010\u0090\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010CJ\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0011\u0010\u0092\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010CJ\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0017HÆ\u0003J\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u0012\u0010\u009c\u0001\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dHÆ\u0003J\n\u0010\u009d\u0001\u001a\u00020\nHÆ\u0003J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010 \u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010¡\u0001\u001a\u0004\u0018\u00010$HÆ\u0003J\f\u0010¢\u0001\u001a\u0004\u0018\u00010&HÆ\u0003J\f\u0010£\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010¤\u0001\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u0010mJ\f\u0010¥\u0001\u001a\u0004\u0018\u00010*HÆ\u0003J\n\u0010¦\u0001\u001a\u00020\u0017HÆ\u0003J\f\u0010§\u0001\u001a\u0004\u0018\u00010-HÆ\u0003J\f\u0010¨\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010©\u0001\u001a\u0004\u0018\u000100HÆ\u0003J\f\u0010ª\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010«\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010¬\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010®\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0018\u0010¯\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u000107HÆ\u0003JÌ\u0003\u0010°\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\n2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010+\u001a\u00020\u00172\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u000107HÆ\u0001¢\u0006\u0003\u0010±\u0001J\u0016\u0010²\u0001\u001a\u00020\u00172\n\u0010³\u0001\u001a\u0005\u0018\u00010´\u0001HÖ\u0003J\n\u0010µ\u0001\u001a\u00020\nHÖ\u0001J\n\u0010¶\u0001\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010<\u001a\u0004\b:\u0010;R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010<\u001a\u0004\bA\u0010;R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010D\u001a\u0004\bB\u0010CR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u001a\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010D\u001a\u0004\bG\u0010CR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010>R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010>R\u0016\u0010\u0016\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010>R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010>R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR&\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001e\u0010\u001f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R \u0010 \u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010>\"\u0004\b_\u0010`R \u0010!\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010>\"\u0004\bb\u0010`R \u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010>\"\u0004\bd\u0010`R \u0010#\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u0018\u0010%\u001a\u0004\u0018\u00010&8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010jR\u0018\u0010'\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010>R\u001a\u0010(\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010n\u001a\u0004\bl\u0010mR \u0010)\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u001e\u0010+\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010Q\"\u0004\bt\u0010uR \u0010,\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR \u0010.\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010>\"\u0004\b{\u0010`R \u0010/\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR\"\u00101\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010>\"\u0005\b\u0081\u0001\u0010`R\"\u00102\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010>\"\u0005\b\u0083\u0001\u0010`R\"\u00103\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010>\"\u0005\b\u0085\u0001\u0010`R\"\u00104\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010>\"\u0005\b\u0087\u0001\u0010`R\"\u00105\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010>\"\u0005\b\u0089\u0001\u0010`R&\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001078\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001¨\u0006·\u0001"}, d2 = {"Lcom/larus/bmhome/chat/bean/PromptContent$BotInfo;", "Ljava/io/Serializable;", "botId", "", "name", "", "iconImage", "Lcom/larus/im/bean/bot/BotIconImage;", UserInfo.UPDATE_TIME, "botType", "", "botCreatorInfo", "Lcom/larus/im/bean/bot/BotCreatorInfo;", "privateStatus", "conversationPage", "Lcom/larus/im/bean/bot/ConversationPage;", "descriptionForHuman", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/im/bean/bot/ModelItem;", "voiceType", "Lcom/larus/im/bean/bot/SpeakerVoice;", "editPos", "muted", "", "bioEdit", "bio", "botStatic", "Lcom/larus/im/bean/bot/BotStatistic;", "botConf", "", "Lcom/larus/im/bean/bot/BotConfItem;", "botMode", "bgImgUrl", "bgImgColor", "bgVideoModel", "switchConfInfo", "Lcom/larus/im/bean/bot/BotSwitchConfInfo;", "onBoarding", "Lcom/larus/bmhome/chat/bean/BotOnBoarding;", "callerName", "callerNameSetting", "sceneModelList", "Lcom/larus/im/bean/bot/SceneModelList;", "disabled", "firstMet", "Lcom/larus/im/bean/bot/FirstMet;", "bgImgUri", "bgImgInfo", "Lcom/larus/im/bean/bot/BgImageInfo;", "userBotGender", "userBotType", "dynamicImgUri", "dynamicImgUrl", "botIconMappedAppIcon", "extra", "", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Lcom/larus/im/bean/bot/BotIconImage;Ljava/lang/Long;Ljava/lang/Integer;Lcom/larus/im/bean/bot/BotCreatorInfo;Ljava/lang/Integer;Lcom/larus/im/bean/bot/ConversationPage;Ljava/lang/String;Lcom/larus/im/bean/bot/ModelItem;Lcom/larus/im/bean/bot/SpeakerVoice;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BotStatistic;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BotSwitchConfInfo;Lcom/larus/bmhome/chat/bean/BotOnBoarding;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/SceneModelList;ZLcom/larus/im/bean/bot/FirstMet;Ljava/lang/String;Lcom/larus/im/bean/bot/BgImageInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getBotId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getName", "()Ljava/lang/String;", "getIconImage", "()Lcom/larus/im/bean/bot/BotIconImage;", "getUpdateTime", "getBotType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBotCreatorInfo", "()Lcom/larus/im/bean/bot/BotCreatorInfo;", "getPrivateStatus", "getConversationPage", "()Lcom/larus/im/bean/bot/ConversationPage;", "getDescriptionForHuman", "getModel", "()Lcom/larus/im/bean/bot/ModelItem;", "getVoiceType", "()Lcom/larus/im/bean/bot/SpeakerVoice;", "getEditPos", "getMuted", "()Z", "getBioEdit", "getBio", "getBotStatic", "()Lcom/larus/im/bean/bot/BotStatistic;", "getBotConf", "()Ljava/util/List;", "setBotConf", "(Ljava/util/List;)V", "getBotMode", "()I", "setBotMode", "(I)V", "getBgImgUrl", "setBgImgUrl", "(Ljava/lang/String;)V", "getBgImgColor", "setBgImgColor", "getBgVideoModel", "setBgVideoModel", "getSwitchConfInfo", "()Lcom/larus/im/bean/bot/BotSwitchConfInfo;", "setSwitchConfInfo", "(Lcom/larus/im/bean/bot/BotSwitchConfInfo;)V", "getOnBoarding", "()Lcom/larus/bmhome/chat/bean/BotOnBoarding;", "getCallerName", "getCallerNameSetting", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSceneModelList", "()Lcom/larus/im/bean/bot/SceneModelList;", "setSceneModelList", "(Lcom/larus/im/bean/bot/SceneModelList;)V", "getDisabled", "setDisabled", "(Z)V", "getFirstMet", "()Lcom/larus/im/bean/bot/FirstMet;", "setFirstMet", "(Lcom/larus/im/bean/bot/FirstMet;)V", "getBgImgUri", "setBgImgUri", "getBgImgInfo", "()Lcom/larus/im/bean/bot/BgImageInfo;", "setBgImgInfo", "(Lcom/larus/im/bean/bot/BgImageInfo;)V", "getUserBotGender", "setUserBotGender", "getUserBotType", "setUserBotType", "getDynamicImgUri", "setDynamicImgUri", "getDynamicImgUrl", "setDynamicImgUrl", "getBotIconMappedAppIcon", "setBotIconMappedAppIcon", "getExtra", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "copy", "(Ljava/lang/Long;Ljava/lang/String;Lcom/larus/im/bean/bot/BotIconImage;Ljava/lang/Long;Ljava/lang/Integer;Lcom/larus/im/bean/bot/BotCreatorInfo;Ljava/lang/Integer;Lcom/larus/im/bean/bot/ConversationPage;Ljava/lang/String;Lcom/larus/im/bean/bot/ModelItem;Lcom/larus/im/bean/bot/SpeakerVoice;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BotStatistic;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BotSwitchConfInfo;Lcom/larus/bmhome/chat/bean/BotOnBoarding;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/SceneModelList;ZLcom/larus/im/bean/bot/FirstMet;Ljava/lang/String;Lcom/larus/im/bean/bot/BgImageInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/larus/bmhome/chat/bean/PromptContent$BotInfo;", "equals", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BotInfo implements Serializable {

        @SerializedName("bg_img_avg_hue")
        private String bgImgColor;

        @SerializedName("bg_img_info")
        private BgImageInfo bgImgInfo;

        @SerializedName("bg_img_uri")
        private String bgImgUri;

        @SerializedName("bg_img_url")
        private String bgImgUrl;

        @SerializedName("bg_video_model")
        private String bgVideoModel;

        @SerializedName("bio")
        private final String bio;

        @SerializedName("user_edit_bio")
        private final String bioEdit;

        @SerializedName("bot_conf")
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private List<BotConfItem> botConf;

        @SerializedName("creator_info")
        private final BotCreatorInfo botCreatorInfo;

        @SerializedName("bot_icon_mapped_app_icon")
        private String botIconMappedAppIcon;

        @SerializedName("id")
        private final Long botId;

        @SerializedName("bot_mode")
        private int botMode;

        @SerializedName("bot_stats")
        private final BotStatistic botStatic;

        @SerializedName("bot_type")
        private final Integer botType;

        @SerializedName(Constant.KEY_CALL_NAME)
        private final String callerName;

        @SerializedName("caller_name_setting")
        private final Boolean callerNameSetting;

        @SerializedName(CommentPublishScene.CONVERSATION_PAGE)
        private final ConversationPage conversationPage;

        @SerializedName("description_for_human")
        private final String descriptionForHuman;

        @SerializedName("disabled")
        private boolean disabled;

        @SerializedName("dynamic_img_uri")
        private String dynamicImgUri;

        @SerializedName("dynamic_img_url")
        private String dynamicImgUrl;

        @SerializedName("edit_pos")
        private final String editPos;

        @SerializedName("extra")
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private final Map<String, String> extra;

        @SerializedName("first_meet")
        private FirstMet firstMet;

        @SerializedName("icon_image")
        private final BotIconImage iconImage;

        @SerializedName(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL)
        private final ModelItem model;

        @SerializedName("muted")
        private final boolean muted;

        @SerializedName("name")
        private final String name;

        @SerializedName("onboarding")
        private final BotOnBoarding onBoarding;

        @SerializedName("private_status")
        private final Integer privateStatus;

        @SerializedName("call_model_list")
        private SceneModelList sceneModelList;

        @SerializedName("switch_conf")
        private BotSwitchConfInfo switchConfInfo;

        @SerializedName("update_time")
        private final Long updateTime;

        @SerializedName("user_bot_gender_starling_key")
        private String userBotGender;

        @SerializedName("user_bot_type_starling_key")
        private String userBotType;

        @SerializedName("voice_type")
        private final SpeakerVoice voiceType;

        public BotInfo() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, 0, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, -1, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BotInfo copy$default(BotInfo r110, Long r111, String r112, BotIconImage r210, Long r211, Integer r212, BotCreatorInfo r213, Integer r214, ConversationPage r215, String r216, ModelItem r217, SpeakerVoice r218, String r219, boolean r310, String r311, String r312, BotStatistic r313, List r314, int r315, String r316, String r317, String r318, BotSwitchConfInfo r319, BotOnBoarding r410, String r411, Boolean r412, SceneModelList r413, boolean r414, FirstMet r415, String r416, BgImageInfo r417, String r418, String r419, String r510, String r511, String r512, Map r513, int r514, int r515, Object r516) {
            if ((r514 & 1) == 0) goto L5;
            Long r100 = r110.botId;
        L7:
            if ((r514 & 2) == 0) goto L9;
            String r101 = r110.name;
        L11:
            if ((r514 & 4) == 0) goto L13;
            BotIconImage r102 = r110.iconImage;
        L15:
            if ((r514 & 8) == 0) goto L17;
            Long r103 = r110.updateTime;
        L19:
            if ((r514 & 16) == 0) goto L21;
            Integer r104 = r110.botType;
        L23:
            if ((r514 & 32) == 0) goto L25;
            BotCreatorInfo r105 = r110.botCreatorInfo;
        L27:
            if ((r514 & 64) == 0) goto L29;
            Integer r106 = r110.privateStatus;
        L31:
            if ((r514 & 128) == 0) goto L33;
            ConversationPage r107 = r110.conversationPage;
        L35:
            if ((r514 & 256) == 0) goto L37;
            String r113 = r110.descriptionForHuman;
        L39:
            if ((r514 & 512) == 0) goto L41;
            ModelItem r114 = r110.model;
        L43:
            if ((r514 & 1024) == 0) goto L45;
            SpeakerVoice r115 = r110.voiceType;
        L47:
            if ((r514 & 2048) == 0) goto L49;
            String r116 = r110.editPos;
        L51:
            if ((r514 & 4096) == 0) goto L53;
            boolean r117 = r110.muted;
        L55:
            if ((r514 & 8192) == 0) goto L57;
            String r118 = r110.bioEdit;
        L58:
            String r320 = r118;
            if ((r514 & 16384) == 0) goto L61;
            String r119 = r110.bio;
        L62:
            String r321 = r119;
            if ((r514 & 32768) == 0) goto L65;
            BotStatistic r120 = r110.botStatic;
        L66:
            BotStatistic r322 = r120;
            if ((r514 & 65536) == 0) goto L69;
            List r121 = r110.botConf;
        L70:
            List r323 = r121;
            if ((r514 & 131072) == 0) goto L73;
            int r122 = r110.botMode;
        L74:
            int r324 = r122;
            if ((r514 & 262144) == 0) goto L77;
            String r123 = r110.bgImgUrl;
        L78:
            String r325 = r123;
            if ((r514 & 524288) == 0) goto L81;
            String r124 = r110.bgImgColor;
        L82:
            String r326 = r124;
            if ((r514 & 1048576) == 0) goto L85;
            String r125 = r110.bgVideoModel;
        L86:
            String r327 = r125;
            if ((r514 & 2097152) == 0) goto L89;
            BotSwitchConfInfo r126 = r110.switchConfInfo;
        L90:
            BotSwitchConfInfo r328 = r126;
            if ((r514 & 4194304) == 0) goto L93;
            BotOnBoarding r127 = r110.onBoarding;
        L94:
            BotOnBoarding r420 = r127;
            if ((r514 & 8388608) == 0) goto L97;
            String r128 = r110.callerName;
        L98:
            String r421 = r128;
            if ((r514 & 16777216) == 0) goto L101;
            Boolean r129 = r110.callerNameSetting;
        L102:
            Boolean r422 = r129;
            if ((r514 & 33554432) == 0) goto L105;
            SceneModelList r130 = r110.sceneModelList;
        L106:
            SceneModelList r423 = r130;
            if ((r514 & 67108864) == 0) goto L109;
            boolean r131 = r110.disabled;
        L110:
            boolean r424 = r131;
            if ((r514 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
            FirstMet r132 = r110.firstMet;
        L114:
            FirstMet r425 = r132;
            if ((r514 & 268435456) == 0) goto L117;
            String r133 = r110.bgImgUri;
        L118:
            String r426 = r133;
            if ((r514 & 536870912) == 0) goto L121;
            BgImageInfo r134 = r110.bgImgInfo;
        L122:
            BgImageInfo r427 = r134;
            if ((r514 & 1073741824) == 0) goto L125;
            String r135 = r110.userBotGender;
        L127:
            if ((r514 & Integer.MIN_VALUE) == 0) goto L129;
            String r108 = r110.userBotType;
        L130:
            String r428 = r108;
            if ((r515 & 1) == 0) goto L133;
            String r109 = r110.dynamicImgUri;
        L134:
            String r517 = r109;
            if ((r515 & 2) == 0) goto L137;
            String r136 = r110.dynamicImgUrl;
        L138:
            String r518 = r136;
            if ((r515 & 4) == 0) goto L141;
            String r137 = r110.botIconMappedAppIcon;
        L142:
            String r519 = r137;
            if ((r515 & 8) == 0) goto L145;
            Map r138 = r110.extra;
        L147:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r420, r421, r422, r423, r424, r425, r426, r427, r135, r428, r517, r518, r519, r138);
        L145:
            r138 = r513;
            goto L147
        L141:
            r137 = r512;
            goto L142
        L137:
            r136 = r511;
            goto L138
        L133:
            r109 = r510;
            goto L134
        L129:
            r108 = r419;
            goto L130
        L125:
            r135 = r418;
            goto L127
        L121:
            r134 = r417;
            goto L122
        L117:
            r133 = r416;
            goto L118
        L113:
            r132 = r415;
            goto L114
        L109:
            r131 = r414;
            goto L110
        L105:
            r130 = r413;
            goto L106
        L101:
            r129 = r412;
            goto L102
        L97:
            r128 = r411;
            goto L98
        L93:
            r127 = r410;
            goto L94
        L89:
            r126 = r319;
            goto L90
        L85:
            r125 = r318;
            goto L86
        L81:
            r124 = r317;
            goto L82
        L77:
            r123 = r316;
            goto L78
        L73:
            r122 = r315;
            goto L74
        L69:
            r121 = r314;
            goto L70
        L65:
            r120 = r313;
            goto L66
        L61:
            r119 = r312;
            goto L62
        L57:
            r118 = r311;
            goto L58
        L53:
            r117 = r310;
            goto L55
        L49:
            r116 = r219;
            goto L51
        L45:
            r115 = r218;
            goto L47
        L41:
            r114 = r217;
            goto L43
        L37:
            r113 = r216;
            goto L39
        L33:
            r107 = r215;
            goto L35
        L29:
            r106 = r214;
            goto L31
        L25:
            r105 = r213;
            goto L27
        L21:
            r104 = r212;
            goto L23
        L17:
            r103 = r211;
            goto L19
        L13:
            r102 = r210;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }

        public final Long component1() {
            return this.botId;
        }

        public final ModelItem component10() {
            return this.model;
        }

        public final SpeakerVoice component11() {
            return this.voiceType;
        }

        public final String component12() {
            return this.editPos;
        }

        public final boolean component13() {
            return this.muted;
        }

        public final String component14() {
            return this.bioEdit;
        }

        public final String component15() {
            return this.bio;
        }

        public final BotStatistic component16() {
            return this.botStatic;
        }

        public final List<BotConfItem> component17() {
            return this.botConf;
        }

        public final int component18() {
            return this.botMode;
        }

        public final String component19() {
            return this.bgImgUrl;
        }

        public final String component2() {
            return this.name;
        }

        public final String component20() {
            return this.bgImgColor;
        }

        public final String component21() {
            return this.bgVideoModel;
        }

        public final BotSwitchConfInfo component22() {
            return this.switchConfInfo;
        }

        public final BotOnBoarding component23() {
            return this.onBoarding;
        }

        public final String component24() {
            return this.callerName;
        }

        public final Boolean component25() {
            return this.callerNameSetting;
        }

        public final SceneModelList component26() {
            return this.sceneModelList;
        }

        public final boolean component27() {
            return this.disabled;
        }

        public final FirstMet component28() {
            return this.firstMet;
        }

        public final String component29() {
            return this.bgImgUri;
        }

        public final BotIconImage component3() {
            return this.iconImage;
        }

        public final BgImageInfo component30() {
            return this.bgImgInfo;
        }

        public final String component31() {
            return this.userBotGender;
        }

        public final String component32() {
            return this.userBotType;
        }

        public final String component33() {
            return this.dynamicImgUri;
        }

        public final String component34() {
            return this.dynamicImgUrl;
        }

        public final String component35() {
            return this.botIconMappedAppIcon;
        }

        public final Map<String, String> component36() {
            return this.extra;
        }

        public final Long component4() {
            return this.updateTime;
        }

        public final Integer component5() {
            return this.botType;
        }

        public final BotCreatorInfo component6() {
            return this.botCreatorInfo;
        }

        public final Integer component7() {
            return this.privateStatus;
        }

        public final ConversationPage component8() {
            return this.conversationPage;
        }

        public final String component9() {
            return this.descriptionForHuman;
        }

        public final BotInfo copy(Long r310, String r410, BotIconImage r411, Long r412, @BotSourceType Integer r413, BotCreatorInfo r414, Integer r415, ConversationPage r416, String r417, ModelItem r418, SpeakerVoice r419, String r510, boolean r511, String r512, String r513, BotStatistic r514, List<BotConfItem> r515, int r516, String r517, String r518, String r519, BotSwitchConfInfo r610, BotOnBoarding r611, String r612, Boolean r613, SceneModelList r614, boolean r615, FirstMet r616, String r617, BgImageInfo r618, String r619, String r710, String r711, String r712, String r713, Map<String, String> r714) {
            return new BotInfo(r310, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof BotInfo) == true) goto L8;
            return false;
        L8:
            BotInfo r101 = (BotInfo) r100;
            if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.iconImage, r101.iconImage) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.updateTime, r101.updateTime) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.botType, r101.botType) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.botCreatorInfo, r101.botCreatorInfo) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.privateStatus, r101.privateStatus) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.conversationPage, r101.conversationPage) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.descriptionForHuman, r101.descriptionForHuman) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.model, r101.model) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.voiceType, r101.voiceType) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.editPos, r101.editPos) == true) goto L45;
            return false;
        L45:
            if (this.muted == r101.muted) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.bioEdit, r101.bioEdit) == true) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.bio, r101.bio) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.botStatic, r101.botStatic) == true) goto L57;
            return false;
        L57:
            if (Intrinsics.areEqual(this.botConf, r101.botConf) == true) goto L60;
            return false;
        L60:
            if (this.botMode == r101.botMode) goto L63;
            return false;
        L63:
            if (Intrinsics.areEqual(this.bgImgUrl, r101.bgImgUrl) == true) goto L66;
            return false;
        L66:
            if (Intrinsics.areEqual(this.bgImgColor, r101.bgImgColor) == true) goto L69;
            return false;
        L69:
            if (Intrinsics.areEqual(this.bgVideoModel, r101.bgVideoModel) == true) goto L72;
            return false;
        L72:
            if (Intrinsics.areEqual(this.switchConfInfo, r101.switchConfInfo) == true) goto L75;
            return false;
        L75:
            if (Intrinsics.areEqual(this.onBoarding, r101.onBoarding) == true) goto L78;
            return false;
        L78:
            if (Intrinsics.areEqual(this.callerName, r101.callerName) == true) goto L81;
            return false;
        L81:
            if (Intrinsics.areEqual(this.callerNameSetting, r101.callerNameSetting) == true) goto L84;
            return false;
        L84:
            if (Intrinsics.areEqual(this.sceneModelList, r101.sceneModelList) == true) goto L87;
            return false;
        L87:
            if (this.disabled == r101.disabled) goto L90;
            return false;
        L90:
            if (Intrinsics.areEqual(this.firstMet, r101.firstMet) == true) goto L93;
            return false;
        L93:
            if (Intrinsics.areEqual(this.bgImgUri, r101.bgImgUri) == true) goto L96;
            return false;
        L96:
            if (Intrinsics.areEqual(this.bgImgInfo, r101.bgImgInfo) == true) goto L99;
            return false;
        L99:
            if (Intrinsics.areEqual(this.userBotGender, r101.userBotGender) == true) goto L102;
            return false;
        L102:
            if (Intrinsics.areEqual(this.userBotType, r101.userBotType) == true) goto L105;
            return false;
        L105:
            if (Intrinsics.areEqual(this.dynamicImgUri, r101.dynamicImgUri) == true) goto L108;
            return false;
        L108:
            if (Intrinsics.areEqual(this.dynamicImgUrl, r101.dynamicImgUrl) == true) goto L111;
            return false;
        L111:
            if (Intrinsics.areEqual(this.botIconMappedAppIcon, r101.botIconMappedAppIcon) == true) goto L114;
            return false;
        L114:
            if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L116;
            return false;
        L116:
            return true;
        }

        public int hashCode() {
            Long r100 = this.botId;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.name;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            BotIconImage r107 = this.iconImage;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            Long r110 = this.updateTime;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            Integer r113 = this.botType;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            BotCreatorInfo r116 = this.botCreatorInfo;
            if (r116 != null) goto L25;
            int r117 = 0;
        L26:
            int r118 = (r115 + r117) * 31;
            Integer r119 = this.privateStatus;
            if (r119 != null) goto L29;
            int r120 = 0;
        L30:
            int r121 = (r118 + r120) * 31;
            ConversationPage r122 = this.conversationPage;
            if (r122 != null) goto L33;
            int r123 = 0;
        L34:
            int r124 = (r121 + r123) * 31;
            String r125 = this.descriptionForHuman;
            if (r125 != null) goto L37;
            int r126 = 0;
        L38:
            int r127 = (r124 + r126) * 31;
            ModelItem r128 = this.model;
            if (r128 != null) goto L41;
            int r129 = 0;
        L42:
            int r130 = (r127 + r129) * 31;
            SpeakerVoice r131 = this.voiceType;
            if (r131 != null) goto L45;
            int r132 = 0;
        L46:
            int r133 = (r130 + r132) * 31;
            String r134 = this.editPos;
            if (r134 != null) goto L49;
            int r135 = 0;
        L50:
            int r136 = (r133 + r135) * 31;
            int r137 = 1231;
            if (this.muted == false) goto L53;
            int r138 = 1231;
        L54:
            int r139 = (r136 + r138) * 31;
            String r140 = this.bioEdit;
            if (r140 != null) goto L57;
            int r141 = 0;
        L58:
            int r142 = (r139 + r141) * 31;
            String r143 = this.bio;
            if (r143 != null) goto L61;
            int r144 = 0;
        L62:
            int r145 = (r142 + r144) * 31;
            BotStatistic r146 = this.botStatic;
            if (r146 != null) goto L65;
            int r147 = 0;
        L66:
            int r148 = (r145 + r147) * 31;
            List<BotConfItem> r149 = this.botConf;
            if (r149 != null) goto L69;
            int r150 = 0;
        L70:
            int r151 = (((r148 + r150) * 31) + this.botMode) * 31;
            String r152 = this.bgImgUrl;
            if (r152 != null) goto L73;
            int r153 = 0;
        L74:
            int r154 = (r151 + r153) * 31;
            String r155 = this.bgImgColor;
            if (r155 != null) goto L77;
            int r156 = 0;
        L78:
            int r157 = (r154 + r156) * 31;
            String r158 = this.bgVideoModel;
            if (r158 != null) goto L81;
            int r159 = 0;
        L82:
            int r160 = (r157 + r159) * 31;
            BotSwitchConfInfo r161 = this.switchConfInfo;
            if (r161 != null) goto L85;
            int r162 = 0;
        L86:
            int r163 = (r160 + r162) * 31;
            BotOnBoarding r164 = this.onBoarding;
            if (r164 != null) goto L89;
            int r165 = 0;
        L90:
            int r166 = (r163 + r165) * 31;
            String r167 = this.callerName;
            if (r167 != null) goto L93;
            int r168 = 0;
        L94:
            int r169 = (r166 + r168) * 31;
            Boolean r170 = this.callerNameSetting;
            if (r170 != null) goto L97;
            int r171 = 0;
        L98:
            int r172 = (r169 + r171) * 31;
            SceneModelList r173 = this.sceneModelList;
            if (r173 != null) goto L101;
            int r174 = 0;
        L102:
            int r175 = (r172 + r174) * 31;
            if (this.disabled == true) goto L106;
            r137 = 1237;
        L106:
            int r176 = (r175 + r137) * 31;
            FirstMet r177 = this.firstMet;
            if (r177 != null) goto L109;
            int r178 = 0;
        L110:
            int r179 = (r176 + r178) * 31;
            String r180 = this.bgImgUri;
            if (r180 != null) goto L113;
            int r181 = 0;
        L114:
            int r182 = (r179 + r181) * 31;
            BgImageInfo r183 = this.bgImgInfo;
            if (r183 != null) goto L117;
            int r184 = 0;
        L118:
            int r185 = (r182 + r184) * 31;
            String r186 = this.userBotGender;
            if (r186 != null) goto L121;
            int r187 = 0;
        L122:
            int r188 = (r185 + r187) * 31;
            String r189 = this.userBotType;
            if (r189 != null) goto L125;
            int r190 = 0;
        L126:
            int r191 = (r188 + r190) * 31;
            String r192 = this.dynamicImgUri;
            if (r192 != null) goto L129;
            int r193 = 0;
        L130:
            int r194 = (r191 + r193) * 31;
            String r195 = this.dynamicImgUrl;
            if (r195 != null) goto L133;
            int r196 = 0;
        L134:
            int r197 = (r194 + r196) * 31;
            String r198 = this.botIconMappedAppIcon;
            if (r198 != null) goto L137;
            int r199 = 0;
        L138:
            int r200 = (r197 + r199) * 31;
            Map<String, String> r201 = this.extra;
            if (r201 == null) goto L143;
            r101 = r201.hashCode();
        L143:
            return r200 + r101;
        L137:
            r199 = r198.hashCode();
            goto L138
        L133:
            r196 = r195.hashCode();
            goto L134
        L129:
            r193 = r192.hashCode();
            goto L130
        L125:
            r190 = r189.hashCode();
            goto L126
        L121:
            r187 = r186.hashCode();
            goto L122
        L117:
            r184 = r183.hashCode();
            goto L118
        L113:
            r181 = r180.hashCode();
            goto L114
        L109:
            r178 = r177.hashCode();
            goto L110
        L101:
            r174 = r173.hashCode();
            goto L102
        L97:
            r171 = r170.hashCode();
            goto L98
        L93:
            r168 = r167.hashCode();
            goto L94
        L89:
            r165 = r164.hashCode();
            goto L90
        L85:
            r162 = r161.hashCode();
            goto L86
        L81:
            r159 = r158.hashCode();
            goto L82
        L77:
            r156 = r155.hashCode();
            goto L78
        L73:
            r153 = r152.hashCode();
            goto L74
        L69:
            r150 = r149.hashCode();
            goto L70
        L65:
            r147 = r146.hashCode();
            goto L66
        L61:
            r144 = r143.hashCode();
            goto L62
        L57:
            r141 = r140.hashCode();
            goto L58
        L53:
            r138 = 1237;
            goto L54
        L49:
            r135 = r134.hashCode();
            goto L50
        L45:
            r132 = r131.hashCode();
            goto L46
        L41:
            r129 = r128.hashCode();
            goto L42
        L37:
            r126 = r125.hashCode();
            goto L38
        L33:
            r123 = r122.hashCode();
            goto L34
        L29:
            r120 = r119.hashCode();
            goto L30
        L25:
            r117 = r116.hashCode();
            goto L26
        L21:
            r114 = r113.hashCode();
            goto L22
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "BotInfo(botId=" + this.botId + ", name=" + this.name + ", iconImage=" + this.iconImage + ", updateTime=" + this.updateTime + ", botType=" + this.botType + ", botCreatorInfo=" + this.botCreatorInfo + ", privateStatus=" + this.privateStatus + ", conversationPage=" + this.conversationPage + ", descriptionForHuman=" + this.descriptionForHuman + ", model=" + this.model + ", voiceType=" + this.voiceType + ", editPos=" + this.editPos + ", muted=" + this.muted + ", bioEdit=" + this.bioEdit + ", bio=" + this.bio + ", botStatic=" + this.botStatic + ", botConf=" + this.botConf + ", botMode=" + this.botMode + ", bgImgUrl=" + this.bgImgUrl + ", bgImgColor=" + this.bgImgColor + ", bgVideoModel=" + this.bgVideoModel + ", switchConfInfo=" + this.switchConfInfo + ", onBoarding=" + this.onBoarding + ", callerName=" + this.callerName + ", callerNameSetting=" + this.callerNameSetting + ", sceneModelList=" + this.sceneModelList + ", disabled=" + this.disabled + ", firstMet=" + this.firstMet + ", bgImgUri=" + this.bgImgUri + ", bgImgInfo=" + this.bgImgInfo + ", userBotGender=" + this.userBotGender + ", userBotType=" + this.userBotType + ", dynamicImgUri=" + this.dynamicImgUri + ", dynamicImgUrl=" + this.dynamicImgUrl + ", botIconMappedAppIcon=" + this.botIconMappedAppIcon + ", extra=" + this.extra + ')';
        }

        public final String getBgImgColor() {
            return this.bgImgColor;
        }

        public final BgImageInfo getBgImgInfo() {
            return this.bgImgInfo;
        }

        public final String getBgImgUri() {
            return this.bgImgUri;
        }

        public final String getBgImgUrl() {
            return this.bgImgUrl;
        }

        public final String getBgVideoModel() {
            return this.bgVideoModel;
        }

        public final String getBio() {
            return this.bio;
        }

        public final String getBioEdit() {
            return this.bioEdit;
        }

        public final List<BotConfItem> getBotConf() {
            return this.botConf;
        }

        public final BotCreatorInfo getBotCreatorInfo() {
            return this.botCreatorInfo;
        }

        public final String getBotIconMappedAppIcon() {
            return this.botIconMappedAppIcon;
        }

        public final Long getBotId() {
            return this.botId;
        }

        public final int getBotMode() {
            return this.botMode;
        }

        public final BotStatistic getBotStatic() {
            return this.botStatic;
        }

        public final Integer getBotType() {
            return this.botType;
        }

        public final String getCallerName() {
            return this.callerName;
        }

        public final Boolean getCallerNameSetting() {
            return this.callerNameSetting;
        }

        public final ConversationPage getConversationPage() {
            return this.conversationPage;
        }

        public final String getDescriptionForHuman() {
            return this.descriptionForHuman;
        }

        public final boolean getDisabled() {
            return this.disabled;
        }

        public final String getDynamicImgUri() {
            return this.dynamicImgUri;
        }

        public final String getDynamicImgUrl() {
            return this.dynamicImgUrl;
        }

        public final String getEditPos() {
            return this.editPos;
        }

        public final Map<String, String> getExtra() {
            return this.extra;
        }

        public final FirstMet getFirstMet() {
            return this.firstMet;
        }

        public final BotIconImage getIconImage() {
            return this.iconImage;
        }

        public final ModelItem getModel() {
            return this.model;
        }

        public final boolean getMuted() {
            return this.muted;
        }

        public final String getName() {
            return this.name;
        }

        public final BotOnBoarding getOnBoarding() {
            return this.onBoarding;
        }

        public final Integer getPrivateStatus() {
            return this.privateStatus;
        }

        public final SceneModelList getSceneModelList() {
            return this.sceneModelList;
        }

        public final BotSwitchConfInfo getSwitchConfInfo() {
            return this.switchConfInfo;
        }

        public final Long getUpdateTime() {
            return this.updateTime;
        }

        public final String getUserBotGender() {
            return this.userBotGender;
        }

        public final String getUserBotType() {
            return this.userBotType;
        }

        public final SpeakerVoice getVoiceType() {
            return this.voiceType;
        }

        public final void setBgImgColor(String r100) {
            this.bgImgColor = r100;
        }

        public final void setBgImgInfo(BgImageInfo r100) {
            this.bgImgInfo = r100;
        }

        public final void setBgImgUri(String r100) {
            this.bgImgUri = r100;
        }

        public final void setBgImgUrl(String r100) {
            this.bgImgUrl = r100;
        }

        public final void setBgVideoModel(String r100) {
            this.bgVideoModel = r100;
        }

        public final void setBotConf(List<BotConfItem> r100) {
            this.botConf = r100;
        }

        public final void setBotIconMappedAppIcon(String r100) {
            this.botIconMappedAppIcon = r100;
        }

        public final void setBotMode(int r100) {
            this.botMode = r100;
        }

        public final void setDisabled(boolean r100) {
            this.disabled = r100;
        }

        public final void setDynamicImgUri(String r100) {
            this.dynamicImgUri = r100;
        }

        public final void setDynamicImgUrl(String r100) {
            this.dynamicImgUrl = r100;
        }

        public final void setFirstMet(FirstMet r100) {
            this.firstMet = r100;
        }

        public final void setSceneModelList(SceneModelList r100) {
            this.sceneModelList = r100;
        }

        public final void setSwitchConfInfo(BotSwitchConfInfo r100) {
            this.switchConfInfo = r100;
        }

        public final void setUserBotGender(String r100) {
            this.userBotGender = r100;
        }

        public final void setUserBotType(String r100) {
            this.userBotType = r100;
        }

        public BotInfo(Long r100, String r101, BotIconImage r102, Long r103, @BotSourceType Integer r104, BotCreatorInfo r105, Integer r106, ConversationPage r110, String r111, ModelItem r112, SpeakerVoice r113, String r114, boolean r115, String r116, String r117, BotStatistic r118, List<BotConfItem> r119, int r210, String r211, String r212, String r213, BotSwitchConfInfo r214, BotOnBoarding r215, String r216, Boolean r217, SceneModelList r218, boolean r219, FirstMet r310, String r311, BgImageInfo r312, String r313, String r314, String r315, String r316, String r317, Map<String, String> r318) {
            this.botId = r100;
            this.name = r101;
            this.iconImage = r102;
            this.updateTime = r103;
            this.botType = r104;
            this.botCreatorInfo = r105;
            this.privateStatus = r106;
            this.conversationPage = r110;
            this.descriptionForHuman = r111;
            this.model = r112;
            this.voiceType = r113;
            this.editPos = r114;
            this.muted = r115;
            this.bioEdit = r116;
            this.bio = r117;
            this.botStatic = r118;
            this.botConf = r119;
            this.botMode = r210;
            this.bgImgUrl = r211;
            this.bgImgColor = r212;
            this.bgVideoModel = r213;
            this.switchConfInfo = r214;
            this.onBoarding = r215;
            this.callerName = r216;
            this.callerNameSetting = r217;
            this.sceneModelList = r218;
            this.disabled = r219;
            this.firstMet = r310;
            this.bgImgUri = r311;
            this.bgImgInfo = r312;
            this.userBotGender = r313;
            this.userBotType = r314;
            this.dynamicImgUri = r315;
            this.dynamicImgUrl = r316;
            this.botIconMappedAppIcon = r317;
            this.extra = r318;
        }

        public /* synthetic */ BotInfo(Long r310, String r311, BotIconImage r312, Long r410, Integer r411, BotCreatorInfo r412, Integer r413, ConversationPage r414, String r415, ModelItem r416, SpeakerVoice r417, String r418, boolean r419, String r510, String r511, BotStatistic r512, List r513, int r514, String r515, String r516, String r517, BotSwitchConfInfo r518, BotOnBoarding r519, String r610, Boolean r611, SceneModelList r612, boolean r613, FirstMet r614, String r615, BgImageInfo r616, String r617, String r618, String r619, String r710, String r711, Map r712, int r713, int r714, DefaultConstructorMarker r715) {
            if ((r713 & 1) == 0) goto L5;
            Long r100 = null;
        L7:
            if ((r713 & 2) == 0) goto L9;
            String r101 = null;
        L11:
            if ((r713 & 4) == 0) goto L13;
            BotIconImage r102 = null;
        L15:
            if ((r713 & 8) == 0) goto L17;
            Long r103 = null;
        L19:
            if ((r713 & 16) == 0) goto L21;
            Integer r104 = null;
        L23:
            if ((r713 & 32) == 0) goto L25;
            BotCreatorInfo r105 = null;
        L27:
            if ((r713 & 64) == 0) goto L29;
            Integer r106 = null;
        L31:
            if ((r713 & 128) == 0) goto L33;
            ConversationPage r107 = null;
        L35:
            if ((r713 & 256) == 0) goto L37;
            String r110 = null;
        L39:
            if ((r713 & 512) == 0) goto L41;
            ModelItem r111 = null;
        L43:
            if ((r713 & 1024) == 0) goto L45;
            SpeakerVoice r112 = null;
        L47:
            if ((r713 & 2048) == 0) goto L49;
            String r113 = null;
        L51:
            if ((r713 & 4096) == 0) goto L53;
            boolean r114 = false;
        L55:
            if ((r713 & 8192) == 0) goto L57;
            String r108 = null;
        L59:
            if ((r713 & 16384) == 0) goto L61;
            String r115 = null;
        L63:
            if ((r713 & 32768) == 0) goto L65;
            BotStatistic r116 = null;
        L67:
            if ((r713 & 65536) == 0) goto L69;
            List r117 = null;
        L71:
            if ((r713 & 131072) == 0) goto L73;
            int r118 = -1;
        L75:
            if ((r713 & 262144) == 0) goto L77;
            String r119 = null;
        L79:
            if ((r713 & 524288) == 0) goto L81;
            String r210 = null;
        L83:
            if ((r713 & 1048576) == 0) goto L85;
            String r211 = null;
        L87:
            if ((r713 & 2097152) == 0) goto L89;
            BotSwitchConfInfo r212 = null;
        L91:
            if ((r713 & 4194304) == 0) goto L93;
            BotOnBoarding r213 = null;
        L95:
            if ((r713 & 8388608) == 0) goto L97;
            String r214 = null;
        L99:
            if ((r713 & 16777216) == 0) goto L101;
            Boolean r215 = Boolean.FALSE;
        L103:
            if ((r713 & 33554432) == 0) goto L105;
            SceneModelList r216 = null;
        L107:
            if ((r713 & 67108864) == 0) goto L109;
            boolean r217 = false;
        L111:
            if ((r713 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
            FirstMet r218 = null;
        L115:
            if ((r713 & 268435456) == 0) goto L117;
            String r219 = null;
        L119:
            if ((r713 & 536870912) == 0) goto L121;
            BgImageInfo r313 = null;
        L123:
            if ((r713 & 1073741824) == 0) goto L125;
            String r314 = null;
        L127:
            if ((r713 & Integer.MIN_VALUE) == 0) goto L129;
            String r109 = null;
        L131:
            if ((r714 & 1) == 0) goto L133;
            String r315 = null;
        L135:
            if ((r714 & 2) == 0) goto L137;
            String r316 = null;
        L139:
            if ((r714 & 4) == 0) goto L141;
            String r317 = null;
        L143:
            if ((r714 & 8) == 0) goto L145;
            Map r318 = null;
        L146:
            this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r108, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r313, r314, r109, r315, r316, r317, r318);
            return;
        L145:
            r318 = r712;
            goto L146
        L141:
            r317 = r711;
            goto L143
        L137:
            r316 = r710;
            goto L139
        L133:
            r315 = r619;
            goto L135
        L129:
            r109 = r618;
            goto L131
        L125:
            r314 = r617;
            goto L127
        L121:
            r313 = r616;
            goto L123
        L117:
            r219 = r615;
            goto L119
        L113:
            r218 = r614;
            goto L115
        L109:
            r217 = r613;
            goto L111
        L105:
            r216 = r612;
            goto L107
        L101:
            r215 = r611;
            goto L103
        L97:
            r214 = r610;
            goto L99
        L93:
            r213 = r519;
            goto L95
        L89:
            r212 = r518;
            goto L91
        L85:
            r211 = r517;
            goto L87
        L81:
            r210 = r516;
            goto L83
        L77:
            r119 = r515;
            goto L79
        L73:
            r118 = r514;
            goto L75
        L69:
            r117 = r513;
            goto L71
        L65:
            r116 = r512;
            goto L67
        L61:
            r115 = r511;
            goto L63
        L57:
            r108 = r510;
            goto L59
        L53:
            r114 = r419;
            goto L55
        L49:
            r113 = r418;
            goto L51
        L45:
            r112 = r417;
            goto L47
        L41:
            r111 = r416;
            goto L43
        L37:
            r110 = r415;
            goto L39
        L33:
            r107 = r414;
            goto L35
        L29:
            r106 = r413;
            goto L31
        L25:
            r105 = r412;
            goto L27
        L21:
            r104 = r411;
            goto L23
        L17:
            r103 = r410;
            goto L19
        L13:
            r102 = r312;
            goto L15
        L9:
            r101 = r311;
            goto L11
        L5:
            r100 = r310;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/chat/bean/PromptContent$CursorPosition;", "Ljava/io/Serializable;", "startPos", "", "endPos", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getStartPos", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEndPos", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/bean/PromptContent$CursorPosition;", "equals", "", "other", "", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CursorPosition implements Serializable {

        @SerializedName(IVideoEventLogger.LOG_CALLBACK_END_POS)
        private final Integer endPos;

        @SerializedName("start_pos")
        private final Integer startPos;

        /* JADX WARN: Multi-variable type inference failed */
        public CursorPosition() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ CursorPosition copy$default(CursorPosition r100, Integer r101, Integer r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.startPos;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.endPos;
        L9:
            return r100.copy(r101, r102);
        }

        public final Integer component1() {
            return this.startPos;
        }

        public final Integer component2() {
            return this.endPos;
        }

        public final CursorPosition copy(Integer r100, Integer r101) {
            return new CursorPosition(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof CursorPosition) == true) goto L8;
            return false;
        L8:
            CursorPosition r101 = (CursorPosition) r100;
            if (Intrinsics.areEqual(this.startPos, r101.startPos) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.endPos, r101.endPos) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            Integer r100 = this.startPos;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.endPos;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "CursorPosition(startPos=" + this.startPos + ", endPos=" + this.endPos + ')';
        }

        public final Integer getEndPos() {
            return this.endPos;
        }

        public final Integer getStartPos() {
            return this.startPos;
        }

        public CursorPosition(Integer r100, Integer r101) {
            this.startPos = r100;
            this.endPos = r101;
        }

        public /* synthetic */ CursorPosition(Integer r100, Integer r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/chat/bean/PromptContent$DefaultOptionItem;", "Ljava/io/Serializable;", "label", "", "defaultSelectionId", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getLabel", "()Ljava/lang/String;", "getDefaultSelectionId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/bean/PromptContent$DefaultOptionItem;", "equals", "", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultOptionItem implements Serializable {

        @SerializedName("default_selection_id")
        private final Integer defaultSelectionId;

        @SerializedName("label")
        private final String label;

        /* JADX WARN: Multi-variable type inference failed */
        public DefaultOptionItem() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ DefaultOptionItem copy$default(DefaultOptionItem r100, String r101, Integer r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.label;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.defaultSelectionId;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.label;
        }

        public final Integer component2() {
            return this.defaultSelectionId;
        }

        public final DefaultOptionItem copy(String r100, Integer r101) {
            return new DefaultOptionItem(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof DefaultOptionItem) == true) goto L8;
            return false;
        L8:
            DefaultOptionItem r101 = (DefaultOptionItem) r100;
            if (Intrinsics.areEqual(this.label, r101.label) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.defaultSelectionId, r101.defaultSelectionId) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            String r100 = this.label;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.defaultSelectionId;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "DefaultOptionItem(label=" + this.label + ", defaultSelectionId=" + this.defaultSelectionId + ')';
        }

        public final Integer getDefaultSelectionId() {
            return this.defaultSelectionId;
        }

        public final String getLabel() {
            return this.label;
        }

        public DefaultOptionItem(String r100, Integer r101) {
            this.label = r100;
            this.defaultSelectionId = r101;
        }

        public /* synthetic */ DefaultOptionItem(String r100, Integer r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/chat/bean/PromptContent$SuggestImageItem;", "Ljava/io/Serializable;", "uri", "", "url", "width", "", "height", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getUri", "()Ljava/lang/String;", "getUrl", "getWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/bean/PromptContent$SuggestImageItem;", "equals", "", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SuggestImageItem implements Serializable {

        @SerializedName("height")
        private final Integer height;

        @SerializedName("uri")
        private final String uri;

        @SerializedName("url")
        private final String url;

        @SerializedName("width")
        private final Integer width;

        public SuggestImageItem() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ SuggestImageItem copy$default(SuggestImageItem r100, String r101, String r102, Integer r103, Integer r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.uri;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.url;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.width;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.height;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final String component1() {
            return this.uri;
        }

        public final String component2() {
            return this.url;
        }

        public final Integer component3() {
            return this.width;
        }

        public final Integer component4() {
            return this.height;
        }

        public final SuggestImageItem copy(String r100, String r101, Integer r102, Integer r103) {
            return new SuggestImageItem(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof SuggestImageItem) == true) goto L8;
            return false;
        L8:
            SuggestImageItem r101 = (SuggestImageItem) r100;
            if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.url, r101.url) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.width, r101.width) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.height, r101.height) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            String r100 = this.uri;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.url;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Integer r107 = this.width;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            Integer r110 = this.height;
            if (r110 == null) goto L19;
            r101 = r110.hashCode();
        L19:
            return r109 + r101;
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "SuggestImageItem(uri=" + this.uri + ", url=" + this.url + ", width=" + this.width + ", height=" + this.height + ')';
        }

        public final Integer getHeight() {
            return this.height;
        }

        public final String getUri() {
            return this.uri;
        }

        public final String getUrl() {
            return this.url;
        }

        public final Integer getWidth() {
            return this.width;
        }

        public SuggestImageItem(String r100, String r101, Integer r102, Integer r103) {
            this.uri = r100;
            this.url = r101;
            this.width = r102;
            this.height = r103;
        }

        public /* synthetic */ SuggestImageItem(String r100, String r101, Integer r102, Integer r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = null;
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = null;
        L14:
            this(r100, r101, r102, r103);
        }
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\bT\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u009d\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001b\u0012\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\u0012\b\u0002\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010'\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b)\u0010*J\u0007\u0010\u0081\u0001\u001a\u00020\u000bJ\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001J\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0003J\u0016\u0010\u0092\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0093\u0001J\u0013\u0010\u0094\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001bJ\u0017\u0010\u0095\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001bJ\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0003R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010,\"\u0004\b4\u0010.R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010,\"\u0004\b6\u0010.R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010,\"\u0004\b8\u0010.R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010,\"\u0004\b:\u0010.R\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\b\n\u0010;\"\u0004\b<\u0010=R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010,\"\u0004\b@\u0010.R \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010,\"\u0004\bB\u0010.R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010,\"\u0004\bD\u0010.R \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010,\"\u0004\bF\u0010.R&\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bG\u0010H\u001a\u0004\bI\u0010,\"\u0004\bJ\u0010.R&\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bK\u0010H\u001a\u0004\bL\u0010,\"\u0004\bM\u0010.R \u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR \u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010O\"\u0004\bS\u0010QR \u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010O\"\u0004\bU\u0010QR \u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010O\"\u0004\bW\u0010QR\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010Z\u001a\u0004\bX\u0010YR \u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010,\"\u0004\b\\\u0010.R.\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R.\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010^\"\u0004\bb\u0010`R\u001e\u0010\u001d\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010c\"\u0004\bd\u0010eR\"\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010j\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\"\u0010 \u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\b \u0010;\"\u0004\bk\u0010=R\"\u0010!\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010j\u001a\u0004\bl\u0010g\"\u0004\bm\u0010iR\"\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010j\u001a\u0004\bn\u0010g\"\u0004\bo\u0010iR \u0010#\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR \u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010q\"\u0004\bu\u0010sR(\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\"\u0010(\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\b(\u0010;\"\u0004\bz\u0010=R\u001d\u0010{\u001a\u0004\u0018\u00010|X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001¨\u0006\u0097\u0001"}, d2 = {"Lcom/larus/bmhome/chat/bean/PromptContent$SuggestItem;", "", "suggest", "", "bgColor", "darkBgColor", "fontColorLight", "fontColorDark", "strokeColorLight", "strokeColorDark", "isHighlightPush", "", "itemId", "itemType", "sendingContent", "schema", "iconUrl", "darkIconUrl", "lightUrlItem", "Lcom/larus/bmhome/chat/bean/PromptContent$SuggestImageItem;", "darkUrlItem", "frontLightUrlItem", "frontDarkUrlItem", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "", "wcbItem", "extra", "", "queryPassExtra", "isRichText", "candidateType", "", "isContinueAsk", "textIcon", "position", "displayRichTextContent", "Lcom/google/gson/JsonObject;", "sendRichTextContent", "childCandidates", "", "isCategoryCandidate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/bean/PromptContent$SuggestImageItem;Lcom/larus/bmhome/chat/bean/PromptContent$SuggestImageItem;Lcom/larus/bmhome/chat/bean/PromptContent$SuggestImageItem;Lcom/larus/bmhome/chat/bean/PromptContent$SuggestImageItem;Ljava/lang/Long;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;ZLjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/google/gson/JsonObject;Lcom/google/gson/JsonObject;Ljava/util/List;Ljava/lang/Boolean;)V", "getSuggest", "()Ljava/lang/String;", "setSuggest", "(Ljava/lang/String;)V", "getBgColor", "setBgColor", "getDarkBgColor", "setDarkBgColor", "getFontColorLight", "setFontColorLight", "getFontColorDark", "setFontColorDark", "getStrokeColorLight", "setStrokeColorLight", "getStrokeColorDark", "setStrokeColorDark", "()Ljava/lang/Boolean;", "setHighlightPush", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getItemId", "setItemId", "getItemType", "setItemType", "getSendingContent", "setSendingContent", "getSchema", "setSchema", "getIconUrl$annotations", "()V", "getIconUrl", "setIconUrl", "getDarkIconUrl$annotations", "getDarkIconUrl", "setDarkIconUrl", "getLightUrlItem", "()Lcom/larus/bmhome/chat/bean/PromptContent$SuggestImageItem;", "setLightUrlItem", "(Lcom/larus/bmhome/chat/bean/PromptContent$SuggestImageItem;)V", "getDarkUrlItem", "setDarkUrlItem", "getFrontLightUrlItem", "setFrontLightUrlItem", "getFrontDarkUrlItem", "setFrontDarkUrlItem", "getExpireTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getWcbItem", "setWcbItem", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "getQueryPassExtra", "setQueryPassExtra", "()Z", "setRichText", "(Z)V", "getCandidateType", "()Ljava/lang/Integer;", "setCandidateType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "setContinueAsk", "getTextIcon", "setTextIcon", "getPosition", "setPosition", "getDisplayRichTextContent", "()Lcom/google/gson/JsonObject;", "setDisplayRichTextContent", "(Lcom/google/gson/JsonObject;)V", "getSendRichTextContent", "setSendRichTextContent", "getChildCandidates", "()Ljava/util/List;", "setChildCandidates", "(Ljava/util/List;)V", "setCategoryCandidate", "markdownContent", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "getMarkdownContent", "()Lcom/larus/business/markdown/api/model/MarkdownContent;", "setMarkdownContent", "(Lcom/larus/business/markdown/api/model/MarkdownContent;)V", "isFontBold", "getSuggestV2ExtraForMultiAction", "Lcom/larus/bmhome/chat/bean/PromptContent$SuggestV2ExtraForMultiAction;", "getSuggestedType", "getShowFrom", "getPromptFrom", "getActivityId", "getActionBarTemplateId", "getTemplateSubType", "getTemplateId", "getTemplateVersion", "getTemplateRecExtra", "getTagCode", "getSugBizType", "getRawWcbCandidateType", "getCategoryId", "getRichTextType", "getSelectionPos", "Lkotlin/Pair;", "getSendMsgExtra", "getOMsgExtra", "getImageUrl", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SuggestItem {

        @SerializedName("background_color")
        private String bgColor;

        @SerializedName("candidate_type")
        private Integer candidateType;

        @SerializedName("child_candidates")
        private List<SuggestItem> childCandidates;

        @SerializedName("dark_background_color")
        private String darkBgColor;

        @SerializedName("dark_icon_url")
        private String darkIconUrl;

        @SerializedName("dark_url_item")
        private SuggestImageItem darkUrlItem;

        @SerializedName("display_rich_text_content")
        private JsonObject displayRichTextContent;

        @SerializedName("expire_time")
        private final Long expireTime;

        @SerializedName("extra")
        private Map<String, String> extra;

        @SerializedName("font_color_dark")
        private String fontColorDark;

        @SerializedName("font_color_light")
        private String fontColorLight;

        @SerializedName("front_dark_url_item")
        private SuggestImageItem frontDarkUrlItem;

        @SerializedName("front_light_url_item")
        private SuggestImageItem frontLightUrlItem;

        @SerializedName("icon_url")
        private String iconUrl;

        @SerializedName("is_category_candidate")
        private Boolean isCategoryCandidate;

        @SerializedName("is_continue_ask")
        private Boolean isContinueAsk;

        @SerializedName("is_highlight_push")
        private Boolean isHighlightPush;

        @SerializedName("is_rich_text")
        private boolean isRichText;

        @SerializedName("item_id")
        private String itemId;

        @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
        private String itemType;

        @SerializedName("light_url_item")
        private SuggestImageItem lightUrlItem;
        private transient l markdownContent;

        @SerializedName("position")
        private Integer position;

        @SerializedName("query_pass_extra")
        private Map<String, String> queryPassExtra;

        @SerializedName("schema")
        private String schema;

        @SerializedName("send_rich_text_content")
        private JsonObject sendRichTextContent;

        @SerializedName("sending_content")
        private String sendingContent;

        @SerializedName("border_color_dark")
        private String strokeColorDark;

        @SerializedName("border_color_light")
        private String strokeColorLight;

        @SerializedName("suggest")
        private String suggest;

        @SerializedName("text_icon")
        private Integer textIcon;

        @SerializedName("wcb_item")
        private String wcbItem;

        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/bmhome/chat/bean/PromptContent$SuggestItem$getOMsgExtra$1$1$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a extends TypeToken<Map<String, ? extends String>> {
            public a() {
            }
        }

        public SuggestItem() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, Integer.MAX_VALUE, null);
        }

        @Deprecated(message = "use dark_url_item instead")
        public static /* synthetic */ void getDarkIconUrl$annotations() {
        }

        @Deprecated(message = "use light_url_item instead")
        public static /* synthetic */ void getIconUrl$annotations() {
        }

        public final String getActionBarTemplateId() {
            Map<String, String> r100 = this.extra;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.get(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID);
        }

        public final String getActivityId() {
            Map<String, String> r100 = this.extra;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.get("activity_id");
        }

        public final String getCategoryId() {
            Map<String, String> r100 = this.extra;
            if (r100 == null) goto L10;
            String r101 = r100.get("category_id");
            if (r101 != null) goto L7;
            return null;
        L7:
            if ((!StringsKt.isBlank(r101)) == true) goto L9;
            return null;
        L9:
            return r101;
        L10:
            return null;
        }

        public final String getImageUrl() {
            SuggestImageItem r100 = this.lightUrlItem;
            if (r100 == null) goto L6;
            String r101 = r100.getUrl();
            if (r101 == null) goto L6;
        L7:
            SuggestImageItem r102 = this.darkUrlItem;
            if (r102 == null) goto L11;
            String r103 = r102.getUrl();
            if (r103 == null) goto L11;
        L12:
            boolean r104 = h.f552477a;
            if (h.a(null) == false) goto L18;
            if (r103 != null) goto L17;
            return r101;
        L17:
            return r103;
        L18:
            return r101;
        L11:
            r103 = this.darkIconUrl;
        L6:
            r101 = this.iconUrl;
            goto L7
        }

        public final Map<String, String> getOMsgExtra() {
            Map<String, String> r100 = this.extra;
            Object r101 = null;
            if (r100 == null) goto L25;
            String r102 = r100.get("o_msg_extra");
            if (r102 == null) goto L26;
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
            if (o0.d(r102) == false) goto L9;
            Map r104 = (Map) new Gson().fromJson(r102, new a().getType());     // Catch: Throwable -> L12
        L10:
            Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L12
        L14:
            Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
            if (r106 == null) goto L18;
            FLogger.f375446a.w("SuggestItem", "getOMsgExtra failed, oMsgExtraStr: ".concat(r102), r106);
        L18:
            if (Result.m9455isFailureimpl(r105) == true) goto L22;
            r101 = r105;
        L22:
            return (Map) r101;
        L9:
            r104 = null;
        L12:
            th = move-exception;
            Result.Companion r107 = Result.Companion;
            r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L14
        L26:
            return null;
        L25:
            return null;
        }

        public final String getPromptFrom() {
            Map<String, String> r100 = this.extra;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.get("prompt_from");
        }

        public final String getRawWcbCandidateType() {
            Map<String, String> r100 = this.extra;
            if (r100 == null) goto L10;
            String r101 = r100.get("candidate_type");
            if (r101 != null) goto L7;
            return null;
        L7:
            if ((!StringsKt.isBlank(r101)) == true) goto L9;
            return null;
        L9:
            return r101;
        L10:
            return null;
        }

        public final String getRichTextType() {
            JsonObject r100 = this.displayRichTextContent;
            boolean r101 = true;
            if (r100 == null) goto L9;
            JsonElement r102 = r100.get("is_rich_text");
            if (r102 == null) goto L9;
            if (r102.getAsBoolean() != true) goto L9;
            boolean r103 = true;
        L10:
            if (r103 == false) goto L12;
            return "display";
        L12:
            JsonObject r104 = this.sendRichTextContent;
            if (r104 == null) goto L19;
            JsonElement r105 = r104.get("is_rich_text");
            if (r105 == null) goto L19;
            if (r105.getAsBoolean() != true) goto L19;
        L20:
            if (r101 == false) goto L23;
            return "send";
        L23:
            if (this.isRichText == false) goto L25;
            return "legacy";
        L25:
            return null;
        L19:
            r101 = false;
        L9:
            r103 = false;
            goto L10
        }

        public final Pair<Integer, Integer> getSelectionPos() {
            Map<String, String> r100 = this.extra;
            if (r100 == null) goto L7;
            String r101 = r100.get("select_start_pos");
            if (r101 == null) goto L7;
            Integer r102 = StringsKt.toIntOrNull(r101);
        L8:
            Map<String, String> r103 = this.extra;
            if (r103 == null) goto L13;
            String r104 = r103.get("select_end_pos");
            if (r104 == null) goto L13;
            Integer r105 = StringsKt.toIntOrNull(r104);
        L14:
            if (r102 == null) goto L18;
            if (r105 == null) goto L18;
            return TuplesKt.to(r102, r105);
        L18:
            return null;
        L13:
            r105 = null;
        L7:
            r102 = null;
            goto L8
        }

        public final Map<String, String> getSendMsgExtra() {
            Map<String, String> r100 = this.queryPassExtra;
            if (r100 == null) goto L18;
            LinkedHashMap r101 = new LinkedHashMap();
            Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
        L6:
            if (r102.hasNext() == false) goto L13;
            Map.Entry<String, String> r103 = r102.next();
            if (r103.getValue() == null) goto L10;
            boolean r104 = true;
        L11:
            if (r104 == false) goto L6;
            r101.put(r103.getKey(), r103.getValue());
            goto L6
        L10:
            r104 = false;
            goto L11
        L13:
            LinkedHashMap r105 = new LinkedHashMap(MapsKt.mapCapacity(r101.size()));
            Iterator r106 = r101.entrySet().iterator();
        L15:
            if (r106.hasNext() == false) goto L25;
            Map.Entry r107 = (Map.Entry) r106.next();
            Object r108 = r107.getKey();
            Object r109 = r107.getValue();
            Intrinsics.checkNotNull(r109);
            r105.put(r108, (String) r109);
            goto L15
        L25:
            return r105;
        L18:
            return MapsKt.emptyMap();
        }

        public final String getShowFrom() {
            Map<String, String> r100 = this.extra;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.get("show_from");
        }

        public final String getSugBizType() {
            Map<String, String> r100 = this.extra;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.get("sug_biz_type");
        }

        public final SuggestV2ExtraForMultiAction getSuggestV2ExtraForMultiAction() {
            if (Intrinsics.areEqual(this.itemType, SuggestItemType.FestivalWelcomeBack.getValue()) == true) goto L5;
            return null;
        L5:
            return g.a(this);
        }

        public final String getSuggestedType() {
            Map<String, String> r100 = this.extra;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.get("suggested_type");
        }

        public final String getTagCode() {
            Map<String, String> r100 = this.extra;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.get("tag_enum_mapping");
        }

        public final String getTemplateId() {
            Map<String, String> r100 = this.extra;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.get(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID);
        }

        public final String getTemplateRecExtra() {
            Map<String, String> r100 = this.extra;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.get("template_rec_extra");
        }

        public final String getTemplateSubType() {
            Map<String, String> r100 = this.extra;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.get("template_sub_type");
        }

        public final String getTemplateVersion() {
            Map<String, String> r100 = this.extra;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.get("template_version");
        }

        public final boolean isFontBold() {
            Map<String, String> r100 = this.extra;
            if (r100 == null) goto L5;
            String r101 = r100.get("is_font_bold");
        L7:
            return Intrinsics.areEqual(r101, "true");
        L5:
            r101 = null;
            goto L7
        }

        public final String getBgColor() {
            return this.bgColor;
        }

        public final Integer getCandidateType() {
            return this.candidateType;
        }

        public final List<SuggestItem> getChildCandidates() {
            return this.childCandidates;
        }

        public final String getDarkBgColor() {
            return this.darkBgColor;
        }

        public final String getDarkIconUrl() {
            return this.darkIconUrl;
        }

        public final SuggestImageItem getDarkUrlItem() {
            return this.darkUrlItem;
        }

        public final JsonObject getDisplayRichTextContent() {
            return this.displayRichTextContent;
        }

        public final Long getExpireTime() {
            return this.expireTime;
        }

        public final Map<String, String> getExtra() {
            return this.extra;
        }

        public final String getFontColorDark() {
            return this.fontColorDark;
        }

        public final String getFontColorLight() {
            return this.fontColorLight;
        }

        public final SuggestImageItem getFrontDarkUrlItem() {
            return this.frontDarkUrlItem;
        }

        public final SuggestImageItem getFrontLightUrlItem() {
            return this.frontLightUrlItem;
        }

        public final String getIconUrl() {
            return this.iconUrl;
        }

        public final String getItemId() {
            return this.itemId;
        }

        public final String getItemType() {
            return this.itemType;
        }

        public final SuggestImageItem getLightUrlItem() {
            return this.lightUrlItem;
        }

        public final l getMarkdownContent() {
            return this.markdownContent;
        }

        public final Integer getPosition() {
            return this.position;
        }

        public final Map<String, String> getQueryPassExtra() {
            return this.queryPassExtra;
        }

        public final String getSchema() {
            return this.schema;
        }

        public final JsonObject getSendRichTextContent() {
            return this.sendRichTextContent;
        }

        public final String getSendingContent() {
            return this.sendingContent;
        }

        public final String getStrokeColorDark() {
            return this.strokeColorDark;
        }

        public final String getStrokeColorLight() {
            return this.strokeColorLight;
        }

        public final String getSuggest() {
            return this.suggest;
        }

        public final Integer getTextIcon() {
            return this.textIcon;
        }

        public final String getWcbItem() {
            return this.wcbItem;
        }

        public final Boolean isCategoryCandidate() {
            return this.isCategoryCandidate;
        }

        public final Boolean isContinueAsk() {
            return this.isContinueAsk;
        }

        public final Boolean isHighlightPush() {
            return this.isHighlightPush;
        }

        public final boolean isRichText() {
            return this.isRichText;
        }

        public final void setBgColor(String r100) {
            this.bgColor = r100;
        }

        public final void setCandidateType(Integer r100) {
            this.candidateType = r100;
        }

        public final void setCategoryCandidate(Boolean r100) {
            this.isCategoryCandidate = r100;
        }

        public final void setChildCandidates(List<SuggestItem> r100) {
            this.childCandidates = r100;
        }

        public final void setContinueAsk(Boolean r100) {
            this.isContinueAsk = r100;
        }

        public final void setDarkBgColor(String r100) {
            this.darkBgColor = r100;
        }

        public final void setDarkIconUrl(String r100) {
            this.darkIconUrl = r100;
        }

        public final void setDarkUrlItem(SuggestImageItem r100) {
            this.darkUrlItem = r100;
        }

        public final void setDisplayRichTextContent(JsonObject r100) {
            this.displayRichTextContent = r100;
        }

        public final void setExtra(Map<String, String> r100) {
            this.extra = r100;
        }

        public final void setFontColorDark(String r100) {
            this.fontColorDark = r100;
        }

        public final void setFontColorLight(String r100) {
            this.fontColorLight = r100;
        }

        public final void setFrontDarkUrlItem(SuggestImageItem r100) {
            this.frontDarkUrlItem = r100;
        }

        public final void setFrontLightUrlItem(SuggestImageItem r100) {
            this.frontLightUrlItem = r100;
        }

        public final void setHighlightPush(Boolean r100) {
            this.isHighlightPush = r100;
        }

        public final void setIconUrl(String r100) {
            this.iconUrl = r100;
        }

        public final void setItemId(String r100) {
            this.itemId = r100;
        }

        public final void setItemType(String r100) {
            this.itemType = r100;
        }

        public final void setLightUrlItem(SuggestImageItem r100) {
            this.lightUrlItem = r100;
        }

        public final void setMarkdownContent(l r100) {
            this.markdownContent = r100;
        }

        public final void setPosition(Integer r100) {
            this.position = r100;
        }

        public final void setQueryPassExtra(Map<String, String> r100) {
            this.queryPassExtra = r100;
        }

        public final void setRichText(boolean r100) {
            this.isRichText = r100;
        }

        public final void setSchema(String r100) {
            this.schema = r100;
        }

        public final void setSendRichTextContent(JsonObject r100) {
            this.sendRichTextContent = r100;
        }

        public final void setSendingContent(String r100) {
            this.sendingContent = r100;
        }

        public final void setStrokeColorDark(String r100) {
            this.strokeColorDark = r100;
        }

        public final void setStrokeColorLight(String r100) {
            this.strokeColorLight = r100;
        }

        public final void setSuggest(String r100) {
            this.suggest = r100;
        }

        public final void setTextIcon(Integer r100) {
            this.textIcon = r100;
        }

        public final void setWcbItem(String r100) {
            this.wcbItem = r100;
        }

        public SuggestItem(String r100, String r101, String r102, String r103, String r104, String r105, String r106, Boolean r110, String r111, String r112, String r113, String r114, String r115, String r116, SuggestImageItem r117, SuggestImageItem r118, SuggestImageItem r119, SuggestImageItem r210, Long r211, String r212, Map<String, String> r213, Map<String, String> r214, boolean r215, Integer r216, Boolean r217, Integer r218, Integer r219, JsonObject r310, JsonObject r311, List<SuggestItem> r312, Boolean r313) {
            this.suggest = r100;
            this.bgColor = r101;
            this.darkBgColor = r102;
            this.fontColorLight = r103;
            this.fontColorDark = r104;
            this.strokeColorLight = r105;
            this.strokeColorDark = r106;
            this.isHighlightPush = r110;
            this.itemId = r111;
            this.itemType = r112;
            this.sendingContent = r113;
            this.schema = r114;
            this.iconUrl = r115;
            this.darkIconUrl = r116;
            this.lightUrlItem = r117;
            this.darkUrlItem = r118;
            this.frontLightUrlItem = r119;
            this.frontDarkUrlItem = r210;
            this.expireTime = r211;
            this.wcbItem = r212;
            this.extra = r213;
            this.queryPassExtra = r214;
            this.isRichText = r215;
            this.candidateType = r216;
            this.isContinueAsk = r217;
            this.textIcon = r218;
            this.position = r219;
            this.displayRichTextContent = r310;
            this.sendRichTextContent = r311;
            this.childCandidates = r312;
            this.isCategoryCandidate = r313;
        }

        public /* synthetic */ SuggestItem(String r310, String r311, String r312, String r313, String r314, String r315, String r316, Boolean r410, String r411, String r412, String r413, String r414, String r415, String r416, SuggestImageItem r417, SuggestImageItem r418, SuggestImageItem r419, SuggestImageItem r510, Long r511, String r512, Map r513, Map r514, boolean r515, Integer r516, Boolean r517, Integer r518, Integer r519, JsonObject r610, JsonObject r611, List r612, Boolean r613, int r614, DefaultConstructorMarker r615) {
            if ((r614 & 1) == 0) goto L5;
            String r100 = null;
        L7:
            if ((r614 & 2) == 0) goto L9;
            String r101 = null;
        L11:
            if ((r614 & 4) == 0) goto L13;
            String r102 = null;
        L15:
            if ((r614 & 8) == 0) goto L17;
            String r103 = null;
        L19:
            if ((r614 & 16) == 0) goto L21;
            String r104 = null;
        L23:
            if ((r614 & 32) == 0) goto L25;
            String r105 = null;
        L27:
            if ((r614 & 64) == 0) goto L29;
            String r106 = null;
        L31:
            if ((r614 & 128) == 0) goto L33;
            Boolean r107 = Boolean.FALSE;
        L35:
            if ((r614 & 256) == 0) goto L37;
            String r110 = null;
        L39:
            if ((r614 & 512) == 0) goto L41;
            String r111 = null;
        L43:
            if ((r614 & 1024) == 0) goto L45;
            String r112 = null;
        L47:
            if ((r614 & 2048) == 0) goto L49;
            String r113 = null;
        L51:
            if ((r614 & 4096) == 0) goto L53;
            String r114 = null;
        L55:
            if ((r614 & 8192) == 0) goto L57;
            String r115 = null;
        L59:
            if ((r614 & 16384) == 0) goto L61;
            SuggestImageItem r108 = null;
        L63:
            if ((r614 & 32768) == 0) goto L65;
            SuggestImageItem r116 = null;
        L67:
            if ((r614 & 65536) == 0) goto L69;
            SuggestImageItem r117 = null;
        L71:
            if ((r614 & 131072) == 0) goto L73;
            SuggestImageItem r118 = null;
        L75:
            if ((r614 & 262144) == 0) goto L77;
            Long r119 = null;
        L79:
            if ((r614 & 524288) == 0) goto L81;
            String r210 = null;
        L83:
            if ((r614 & 1048576) == 0) goto L85;
            Map r211 = null;
        L87:
            if ((r614 & 2097152) == 0) goto L89;
            Map r212 = null;
        L91:
            if ((r614 & 4194304) == 0) goto L93;
            boolean r213 = false;
        L95:
            if ((r614 & 8388608) == 0) goto L97;
            Integer r214 = null;
        L99:
            if ((r614 & 16777216) == 0) goto L101;
            Boolean r215 = null;
        L103:
            if ((r614 & 33554432) == 0) goto L105;
            Integer r216 = null;
        L107:
            if ((r614 & 67108864) == 0) goto L109;
            Integer r217 = null;
        L111:
            if ((r614 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
            JsonObject r218 = null;
        L115:
            if ((r614 & 268435456) == 0) goto L117;
            JsonObject r219 = null;
        L119:
            if ((r614 & 536870912) == 0) goto L121;
            List r317 = null;
        L123:
            if ((r614 & 1073741824) == 0) goto L125;
            Boolean r109 = null;
        L126:
            this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r317, r109);
            return;
        L125:
            r109 = r613;
            goto L126
        L121:
            r317 = r612;
            goto L123
        L117:
            r219 = r611;
            goto L119
        L113:
            r218 = r610;
            goto L115
        L109:
            r217 = r519;
            goto L111
        L105:
            r216 = r518;
            goto L107
        L101:
            r215 = r517;
            goto L103
        L97:
            r214 = r516;
            goto L99
        L93:
            r213 = r515;
            goto L95
        L89:
            r212 = r514;
            goto L91
        L85:
            r211 = r513;
            goto L87
        L81:
            r210 = r512;
            goto L83
        L77:
            r119 = r511;
            goto L79
        L73:
            r118 = r510;
            goto L75
        L69:
            r117 = r419;
            goto L71
        L65:
            r116 = r418;
            goto L67
        L61:
            r108 = r417;
            goto L63
        L57:
            r115 = r416;
            goto L59
        L53:
            r114 = r415;
            goto L55
        L49:
            r113 = r414;
            goto L51
        L45:
            r112 = r413;
            goto L47
        L41:
            r111 = r412;
            goto L43
        L37:
            r110 = r411;
            goto L39
        L33:
            r107 = r410;
            goto L35
        L29:
            r106 = r316;
            goto L31
        L25:
            r105 = r315;
            goto L27
        L21:
            r104 = r314;
            goto L23
        L17:
            r103 = r313;
            goto L19
        L13:
            r102 = r312;
            goto L15
        L9:
            r101 = r311;
            goto L11
        L5:
            r100 = r310;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/chat/bean/PromptContent$SuggestItemType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Bot", "Text", "HotNews", "TextToImg", "TelUGCBot", "Camera", "TelMainBot", "Album", "VLM", "FestivalWelcomeBack", "WcbCreation", "WcbCreationAlbum", "WcbCreationSameStyle", "WcbCreationAlbumMulti", "JumpSchema", "FillInput", "CameraNew", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SuggestItemType extends Enum<SuggestItemType> {
        public static final SuggestItemType Album = null;
        public static final SuggestItemType Bot = null;
        public static final SuggestItemType Camera = null;
        public static final SuggestItemType CameraNew = null;
        public static final SuggestItemType FestivalWelcomeBack = null;
        public static final SuggestItemType FillInput = null;
        public static final SuggestItemType HotNews = null;
        public static final SuggestItemType JumpSchema = null;
        public static final SuggestItemType TelMainBot = null;
        public static final SuggestItemType TelUGCBot = null;
        public static final SuggestItemType Text = null;
        public static final SuggestItemType TextToImg = null;
        public static final SuggestItemType VLM = null;
        public static final SuggestItemType WcbCreation = null;
        public static final SuggestItemType WcbCreationAlbum = null;
        public static final SuggestItemType WcbCreationAlbumMulti = null;
        public static final SuggestItemType WcbCreationSameStyle = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SuggestItemType[] f297424a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f297425b = null;
        private final String value;

        public static EnumEntries<SuggestItemType> getEntries() {
            return f297425b;
        }

        static {
            SuggestItemType r100 = new SuggestItemType("Bot", 0, "101");
            Bot = r100;
            SuggestItemType r101 = new SuggestItemType("Text", 1, IInteractGameMonitorService.FAILURE_CODE_LINK_MIC_MUTEX);
            Text = r101;
            SuggestItemType r102 = new SuggestItemType("HotNews", 2, "108");
            HotNews = r102;
            SuggestItemType r103 = new SuggestItemType("TextToImg", 3, "111");
            TextToImg = r103;
            SuggestItemType r104 = new SuggestItemType("TelUGCBot", 4, BDLocationException.ERROR_LIGHT_LOCATION_UPLOAD_LOCATION_INFO);
            TelUGCBot = r104;
            SuggestItemType r105 = new SuggestItemType("Camera", 5, BDLocationException.ERROR_TMAP_BAD_JSON);
            Camera = r105;
            SuggestItemType r110 = new SuggestItemType("TelMainBot", 6, "113");
            TelMainBot = r110;
            SuggestItemType r111 = new SuggestItemType("Album", 7, BDLocationException.ERROR_TMAP_WGS84);
            Album = r111;
            SuggestItemType r112 = new SuggestItemType("VLM", 8, "115");
            VLM = r112;
            SuggestItemType r113 = new SuggestItemType("FestivalWelcomeBack", 9, "200");
            FestivalWelcomeBack = r113;
            SuggestItemType r114 = new SuggestItemType("WcbCreation", 10, "201");
            WcbCreation = r114;
            SuggestItemType r106 = new SuggestItemType("WcbCreationAlbum", 11, "202");
            WcbCreationAlbum = r106;
            SuggestItemType r107 = new SuggestItemType("WcbCreationSameStyle", 12, "211");
            WcbCreationSameStyle = r107;
            SuggestItemType r108 = new SuggestItemType("WcbCreationAlbumMulti", 13, "212");
            WcbCreationAlbumMulti = r108;
            SuggestItemType r109 = new SuggestItemType("JumpSchema", 14, "301");
            JumpSchema = r109;
            SuggestItemType r115 = new SuggestItemType("FillInput", 15, "501");
            FillInput = r115;
            SuggestItemType r116 = new SuggestItemType("CameraNew", 16, "502");
            CameraNew = r116;
            SuggestItemType[] r117 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116};
            f297424a = r117;
            f297425b = EnumEntriesKt.enumEntries(r117);
        }

        public static SuggestItemType[] values() {
            return (SuggestItemType[]) f297424a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static SuggestItemType valueOf(String r100) {
            return (SuggestItemType) r27.a.a(SuggestItemType.class, r100);
        }

        public SuggestItemType(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bmhome/chat/bean/PromptContent$SuggestPromptType;", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SuggestPromptType {
        public static final int BOT = 2;
        public static final int COMMUNITY_CREATION = 5;
        public static final a Companion = null;
        public static final int ENTRY = 3;
        public static final int PODCAST = 4;
        public static final int TEXT = 1;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f297426a = null;

            static {
                f297426a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f297426a;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\b\u00103\u001a\u0004\u0018\u000100J\b\u00105\u001a\u0004\u0018\u000102R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR \u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR \u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0018\"\u0004\b(\u0010\u001aR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR \u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010\u001aR \u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0018\"\u0004\b.\u0010\u001aR\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/larus/bmhome/chat/bean/PromptContent$SuggestV2;", "Ljava/io/Serializable;", "suggestType", "", "content", "", "iconUrl", "darkIconUrl", "iconUri", "fontColorLight", "fontColorDark", "strokeColorLight", "strokeColorDark", "clickUrl", "botId", "extra", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSuggestType", "()Ljava/lang/Integer;", "setSuggestType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getIconUrl", "setIconUrl", "getDarkIconUrl", "setDarkIconUrl", "getIconUri", "setIconUri", "getFontColorLight", "setFontColorLight", "getFontColorDark", "setFontColorDark", "getStrokeColorLight", "setStrokeColorLight", "getStrokeColorDark", "setStrokeColorDark", "getClickUrl", "setClickUrl", "getBotId", "setBotId", "getExtra", "setExtra", "_suggestV2ExtraForMultiAction", "Lcom/larus/bmhome/chat/bean/PromptContent$SuggestV2ExtraForMultiAction;", "suggestV2Extra", "Lcom/larus/bmhome/chat/bean/PromptContent$SuggestV2Extra;", "getSuggestV2ExtForMultiAction", "_suggestV2Extra", "getSuggestV2Extra", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SuggestV2 implements Serializable {
        private SuggestV2Extra _suggestV2Extra;
        private SuggestV2ExtraForMultiAction _suggestV2ExtraForMultiAction;

        @SerializedName("bot_id")
        private String botId;

        @SerializedName("click_url")
        private String clickUrl;

        @SerializedName("content")
        private String content;

        @SerializedName("dark_icon_url")
        private String darkIconUrl;

        @SerializedName("extra")
        private String extra;

        @SerializedName("font_color_dark")
        private String fontColorDark;

        @SerializedName("font_color_light")
        private String fontColorLight;

        @SerializedName("icon_uri")
        private String iconUri;

        @SerializedName("icon_url")
        private String iconUrl;

        @SerializedName("border_color_dark")
        private String strokeColorDark;

        @SerializedName("border_color_light")
        private String strokeColorLight;

        @SerializedName("suggest_type")
        private Integer suggestType;
        private SuggestV2Extra suggestV2Extra;

        public SuggestV2() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK, null);
        }

        public final SuggestV2ExtraForMultiAction getSuggestV2ExtForMultiAction() {
            SuggestV2ExtraForMultiAction r100 = this._suggestV2ExtraForMultiAction;
            if (r100 == null) goto L25;
            return r100;
        L25:
        L21:
            e = move-exception;
            FLogger.f375446a.e("PromptContent", "getSuggestPromptExtra error >>> " + e);
        L24:
            return this._suggestV2ExtraForMultiAction;
        L6:
            if (o0.d(this.extra) == false) goto L24;
            SuggestV2ExtraForMultiAction r101 = (SuggestV2ExtraForMultiAction) new Gson().fromJson(this.extra, SuggestV2ExtraForMultiAction.class);     // Catch: Exception -> L21
            this._suggestV2ExtraForMultiAction = r101;     // Catch: Exception -> L21
            if (r101 == null) goto L10;
            r101.setBotId(this.botId);     // Catch: Exception -> L21
        L10:
            SuggestV2ExtraForMultiAction r102 = this._suggestV2ExtraForMultiAction;     // Catch: Exception -> L21
            if (r102 == null) goto L24;
            Integer r103 = this.suggestType;     // Catch: Exception -> L21
            if (r103 != null) goto L16;
        L18:
            String r104 = "spring_suggest";
        L19:
            r102.setSuggestType(r104);     // Catch: Exception -> L21
            goto L24
        L16:
            if (r103.intValue() != 5) goto L18;
            r104 = "ai_generate_suggest";
            goto L19
        }

        public final SuggestV2Extra getSuggestV2Extra() {
            SuggestV2Extra r100 = this._suggestV2Extra;
            if (r100 == null) goto L5;
            return r100;
        L5:
            a r101 = PromptContent.Companion;
            String r102 = this.extra;
            r101.getClass();
            SuggestV2Extra r103 = a.a(r102);
            if (r103 != null) goto L8;
            r103 = new SuggestV2Extra(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
        L8:
            this._suggestV2Extra = r103;
            return r103;
        }

        public final String getBotId() {
            return this.botId;
        }

        public final String getClickUrl() {
            return this.clickUrl;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getDarkIconUrl() {
            return this.darkIconUrl;
        }

        public final String getExtra() {
            return this.extra;
        }

        public final String getFontColorDark() {
            return this.fontColorDark;
        }

        public final String getFontColorLight() {
            return this.fontColorLight;
        }

        public final String getIconUri() {
            return this.iconUri;
        }

        public final String getIconUrl() {
            return this.iconUrl;
        }

        public final String getStrokeColorDark() {
            return this.strokeColorDark;
        }

        public final String getStrokeColorLight() {
            return this.strokeColorLight;
        }

        public final Integer getSuggestType() {
            return this.suggestType;
        }

        public final void setBotId(String r100) {
            this.botId = r100;
        }

        public final void setClickUrl(String r100) {
            this.clickUrl = r100;
        }

        public final void setContent(String r100) {
            this.content = r100;
        }

        public final void setDarkIconUrl(String r100) {
            this.darkIconUrl = r100;
        }

        public final void setExtra(String r100) {
            this.extra = r100;
        }

        public final void setFontColorDark(String r100) {
            this.fontColorDark = r100;
        }

        public final void setFontColorLight(String r100) {
            this.fontColorLight = r100;
        }

        public final void setIconUri(String r100) {
            this.iconUri = r100;
        }

        public final void setIconUrl(String r100) {
            this.iconUrl = r100;
        }

        public final void setStrokeColorDark(String r100) {
            this.strokeColorDark = r100;
        }

        public final void setStrokeColorLight(String r100) {
            this.strokeColorLight = r100;
        }

        public final void setSuggestType(Integer r100) {
            this.suggestType = r100;
        }

        public SuggestV2(Integer r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111, String r112) {
            this.suggestType = r100;
            this.content = r101;
            this.iconUrl = r102;
            this.darkIconUrl = r103;
            this.iconUri = r104;
            this.fontColorLight = r105;
            this.fontColorDark = r106;
            this.strokeColorLight = r107;
            this.strokeColorDark = r108;
            this.clickUrl = r110;
            this.botId = r111;
            this.extra = r112;
        }

        public /* synthetic */ SuggestV2(Integer r110, String r111, String r112, String r113, String r114, String r115, String r210, String r211, String r212, String r213, String r214, String r215, int r216, DefaultConstructorMarker r217) {
            if ((r216 & 1) == 0) goto L5;
            Integer r100 = 1;
        L6:
            String r101 = null;
            if ((r216 & 2) == 0) goto L9;
            String r102 = null;
        L11:
            if ((r216 & 4) == 0) goto L13;
            String r103 = null;
        L15:
            if ((r216 & 8) == 0) goto L17;
            String r104 = null;
        L19:
            if ((r216 & 16) == 0) goto L21;
            String r105 = null;
        L23:
            if ((r216 & 32) == 0) goto L25;
            String r106 = null;
        L27:
            if ((r216 & 64) == 0) goto L29;
            String r107 = null;
        L31:
            if ((r216 & 128) == 0) goto L33;
            String r108 = null;
        L35:
            if ((r216 & 256) == 0) goto L37;
            String r116 = null;
        L39:
            if ((r216 & 512) == 0) goto L41;
            String r117 = null;
        L43:
            if ((r216 & 1024) == 0) goto L45;
            String r118 = null;
        L47:
            if ((r216 & 2048) != 0) goto L50;
            r101 = r215;
        L50:
            this(r100, r102, r103, r104, r105, r106, r107, r108, r116, r117, r118, r101);
            return;
        L45:
            r118 = r214;
            goto L47
        L41:
            r117 = r213;
            goto L43
        L37:
            r116 = r212;
            goto L39
        L33:
            r108 = r211;
            goto L35
        L29:
            r107 = r210;
            goto L31
        L25:
            r106 = r115;
            goto L27
        L21:
            r105 = r114;
            goto L23
        L17:
            r104 = r113;
            goto L19
        L13:
            r103 = r112;
            goto L15
        L9:
            r102 = r111;
            goto L11
        L5:
            r100 = r110;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b#\b\u0007\u0018\u00002\u00020\u0001B£\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0014\"\u0004\b'\u0010\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0014R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0014R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0014R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0014¨\u0006-"}, d2 = {"Lcom/larus/bmhome/chat/bean/PromptContent$SuggestV2Extra;", "Ljava/io/Serializable;", "requestId", "", "recommendBot1StType", "recommendBot2ndType", "recommendBot3StType", "bgImgUrl", "bgImgColor", "rsItemId", "", "rsRequestId", "deepResearchPhase", "deepResearchEntrance", "deepResearchId", "needDeepThink", "sendPrompt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRequestId", "()Ljava/lang/String;", "setRequestId", "(Ljava/lang/String;)V", "getRecommendBot1StType", "setRecommendBot1StType", "getRecommendBot2ndType", "setRecommendBot2ndType", "getRecommendBot3StType", "setRecommendBot3StType", "getBgImgUrl", "setBgImgUrl", "getBgImgColor", "setBgImgColor", "getRsItemId", "()Ljava/lang/Long;", "setRsItemId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getRsRequestId", "setRsRequestId", "getDeepResearchPhase", "getDeepResearchEntrance", "getDeepResearchId", "getNeedDeepThink", "getSendPrompt", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SuggestV2Extra implements Serializable {

        @SerializedName("bg_img_avg_hue")
        private String bgImgColor;

        @SerializedName("bg_img_url")
        private String bgImgUrl;

        @SerializedName("deep_research_entrance")
        private final String deepResearchEntrance;

        @SerializedName("deep_research_id")
        private final String deepResearchId;

        @SerializedName("deep_research_phase")
        private final String deepResearchPhase;

        @SerializedName("need_deep_think")
        private final String needDeepThink;

        @SerializedName("recommend_bot_1st_type")
        private String recommendBot1StType;

        @SerializedName("recommend_bot_2nd_type")
        private String recommendBot2ndType;

        @SerializedName("recommend_bot_3rd_type")
        private String recommendBot3StType;

        @SerializedName("request_id")
        private String requestId;

        @SerializedName("rs_item_id")
        private Long rsItemId;

        @SerializedName("rs_req_id")
        private String rsRequestId;

        @SerializedName("send_prompt")
        private final String sendPrompt;

        public SuggestV2Extra() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
        }

        public final String getBgImgColor() {
            return this.bgImgColor;
        }

        public final String getBgImgUrl() {
            return this.bgImgUrl;
        }

        public final String getDeepResearchEntrance() {
            return this.deepResearchEntrance;
        }

        public final String getDeepResearchId() {
            return this.deepResearchId;
        }

        public final String getDeepResearchPhase() {
            return this.deepResearchPhase;
        }

        public final String getNeedDeepThink() {
            return this.needDeepThink;
        }

        public final String getRecommendBot1StType() {
            return this.recommendBot1StType;
        }

        public final String getRecommendBot2ndType() {
            return this.recommendBot2ndType;
        }

        public final String getRecommendBot3StType() {
            return this.recommendBot3StType;
        }

        public final String getRequestId() {
            return this.requestId;
        }

        public final Long getRsItemId() {
            return this.rsItemId;
        }

        public final String getRsRequestId() {
            return this.rsRequestId;
        }

        public final String getSendPrompt() {
            return this.sendPrompt;
        }

        public final void setBgImgColor(String r100) {
            this.bgImgColor = r100;
        }

        public final void setBgImgUrl(String r100) {
            this.bgImgUrl = r100;
        }

        public final void setRecommendBot1StType(String r100) {
            this.recommendBot1StType = r100;
        }

        public final void setRecommendBot2ndType(String r100) {
            this.recommendBot2ndType = r100;
        }

        public final void setRecommendBot3StType(String r100) {
            this.recommendBot3StType = r100;
        }

        public final void setRequestId(String r100) {
            this.requestId = r100;
        }

        public final void setRsItemId(Long r100) {
            this.rsItemId = r100;
        }

        public final void setRsRequestId(String r100) {
            this.rsRequestId = r100;
        }

        public SuggestV2Extra(String r100, String r101, String r102, String r103, String r104, String r105, Long r106, String r107, String r108, String r110, String r111, String r112, String r113) {
            this.requestId = r100;
            this.recommendBot1StType = r101;
            this.recommendBot2ndType = r102;
            this.recommendBot3StType = r103;
            this.bgImgUrl = r104;
            this.bgImgColor = r105;
            this.rsItemId = r106;
            this.rsRequestId = r107;
            this.deepResearchPhase = r108;
            this.deepResearchEntrance = r110;
            this.deepResearchId = r111;
            this.needDeepThink = r112;
            this.sendPrompt = r113;
        }

        public /* synthetic */ SuggestV2Extra(String r110, String r111, String r112, String r113, String r114, String r210, Long r211, String r212, String r213, String r214, String r215, String r216, String r217, int r218, DefaultConstructorMarker r219) {
            String r100 = null;
            if ((r218 & 1) == 0) goto L5;
            String r101 = null;
        L7:
            if ((r218 & 2) == 0) goto L9;
            String r102 = null;
        L11:
            if ((r218 & 4) == 0) goto L13;
            String r103 = null;
        L15:
            if ((r218 & 8) == 0) goto L17;
            String r104 = null;
        L19:
            if ((r218 & 16) == 0) goto L21;
            String r105 = null;
        L23:
            if ((r218 & 32) == 0) goto L25;
            String r106 = null;
        L27:
            if ((r218 & 64) == 0) goto L29;
            Long r107 = null;
        L31:
            if ((r218 & 128) == 0) goto L33;
            String r108 = null;
        L35:
            if ((r218 & 256) == 0) goto L37;
            String r115 = null;
        L39:
            if ((r218 & 512) == 0) goto L41;
            String r116 = null;
        L43:
            if ((r218 & 1024) == 0) goto L45;
            String r117 = null;
        L47:
            if ((r218 & 2048) == 0) goto L49;
            String r118 = null;
        L51:
            if ((r218 & 4096) != 0) goto L54;
            r100 = r217;
        L54:
            this(r101, r102, r103, r104, r105, r106, r107, r108, r115, r116, r117, r118, r100);
            return;
        L49:
            r118 = r216;
            goto L51
        L45:
            r117 = r215;
            goto L47
        L41:
            r116 = r214;
            goto L43
        L37:
            r115 = r213;
            goto L39
        L33:
            r108 = r212;
            goto L35
        L29:
            r107 = r211;
            goto L31
        L25:
            r106 = r210;
            goto L27
        L21:
            r105 = r114;
            goto L23
        L17:
            r104 = r113;
            goto L19
        L13:
            r103 = r112;
            goto L15
        L9:
            r102 = r111;
            goto L11
        L5:
            r101 = r110;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b/\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 <2\u00020\u0001:\u0001<B»\u0001\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\b\u00109\u001a\u0004\u0018\u000103J\u0010\u0010:\u001a\f\u0012\u0006\u0012\u0004\u0018\u000106\u0018\u000105J\b\u0010;\u001a\u0004\u0018\u000108R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0015\"\u0004\b\u0019\u0010\u001aR \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u001aR \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u001aR \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u001aR \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u001aR \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u001aR \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u001aR \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0015\"\u0004\b(\u0010\u001aR \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0015\"\u0004\b*\u0010\u001aR \u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u001aR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0015\"\u0004\b.\u0010\u001aR\u001c\u0010/\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0015\"\u0004\b1\u0010\u001aR\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u000106\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/larus/bmhome/chat/bean/PromptContent$SuggestV2ExtraForMultiAction;", "Ljava/io/Serializable;", "suggestActionType", "", "actionBarItemId", "actionBarTemplateId", "actionBarKey", "isFontBold", "msgExt", "cursorPos", "userPrompt", "schemaUrl", "speechKey", "actionBarDefaultSelectionCfg", "botInfo", "showFrom", "suggestStyle", "botId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSuggestActionType", "()Ljava/lang/String;", "getActionBarItemId", "getActionBarTemplateId", "getActionBarKey", "setFontBold", "(Ljava/lang/String;)V", "getMsgExt", "setMsgExt", "getCursorPos", "setCursorPos", "getUserPrompt", "setUserPrompt", "getSchemaUrl", "setSchemaUrl", "getSpeechKey", "setSpeechKey", "getActionBarDefaultSelectionCfg", "setActionBarDefaultSelectionCfg", "getBotInfo", "setBotInfo", "getShowFrom", "setShowFrom", "getSuggestStyle", "setSuggestStyle", "getBotId", "setBotId", "suggestType", "getSuggestType", "setSuggestType", "_cursorPosition", "Lcom/larus/bmhome/chat/bean/PromptContent$CursorPosition;", "_defaultOptionList", "", "Lcom/larus/bmhome/chat/bean/PromptContent$DefaultOptionItem;", "_botInfo", "Lcom/larus/bmhome/chat/bean/PromptContent$BotInfo;", "getCursorPosition", "getDefaultOptionList", "getBotInfoModel", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SuggestV2ExtraForMultiAction implements Serializable {
        public static final a Companion = null;
        public static final String KEY_IMAGE_ASPECT_RATIO = "image_gen_aspect_ratio";
        public static final String KEY_IMAGE_GEN_STYLE_BTN = "image_gen_style_btn";
        public static final String KEY_MUSIC_GENRE = "music_genre";
        public static final String KEY_MUSIC_MOOD = "music_mood";
        public static final String KEY_MUSIC_VOCAL = "music_vocal";
        private BotInfo _botInfo;
        private CursorPosition _cursorPosition;
        private List<DefaultOptionItem> _defaultOptionList;

        @SerializedName("actionbar_default_selection_cfg")
        private String actionBarDefaultSelectionCfg;

        @SerializedName("actionbar_item_id")
        private final String actionBarItemId;

        @SerializedName("actionbar_key")
        private final String actionBarKey;

        @SerializedName("actionbar_template_id")
        private final String actionBarTemplateId;
        private transient String botId;

        @SerializedName("bot_info")
        private String botInfo;

        @SerializedName("cursor_pos")
        private String cursorPos;

        @SerializedName("is_font_bold")
        private String isFontBold;

        @SerializedName(ChatDraftItem.TYPE_MSG_EXT)
        private String msgExt;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL)
        private String schemaUrl;

        @SerializedName("show_from")
        private String showFrom;

        @SerializedName("speech_key")
        private String speechKey;

        @SerializedName("suggest_action_type")
        private final String suggestActionType;

        @SerializedName("suggest_style")
        private String suggestStyle;
        private String suggestType;

        @SerializedName("user_prompt")
        private String userPrompt;

        public static final class a {
            public a() {
            }
        }

        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/bmhome/chat/bean/PromptContent$SuggestV2ExtraForMultiAction$getDefaultOptionList$type$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/bmhome/chat/bean/PromptContent$DefaultOptionItem;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class b extends TypeToken<List<? extends DefaultOptionItem>> {
            public b() {
            }
        }

        static {
            Companion = new a();
        }

        public SuggestV2ExtraForMultiAction() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
        }

        public final BotInfo getBotInfoModel() {
            BotInfo r100 = this._botInfo;
            if (r100 == null) goto L11;
            return r100;
        L11:
            BotInfo r101 = (BotInfo) new Gson().fromJson(this.botInfo, BotInfo.class);     // Catch: Exception -> L7
        L9:
            this._botInfo = r101;
            return r101;
        L7:
            e = move-exception;
            FLogger.f375446a.e("PromptContent", "getBotInfo error >>> " + e);
            r101 = null;
            goto L9
        }

        public final CursorPosition getCursorPosition() {
            CursorPosition r100 = this._cursorPosition;
            if (r100 == null) goto L11;
            return r100;
        L11:
            CursorPosition r101 = (CursorPosition) new Gson().fromJson(this.cursorPos, CursorPosition.class);     // Catch: Exception -> L7
        L9:
            this._cursorPosition = r101;
            return r101;
        L7:
            e = move-exception;
            FLogger.f375446a.e("PromptContent", "getCursorPosition error >>> " + e);
            r101 = null;
            goto L9
        }

        public final List<DefaultOptionItem> getDefaultOptionList() {
            List<DefaultOptionItem> r100 = this._defaultOptionList;
            if (r100 == null) goto L5;
            return r100;
        L5:
            Type r101 = new b().getType();
            FLogger.f375446a.i("PromptContent", "instructionDefaultParams, actionBarDefaultSelectionCfg " + this.actionBarDefaultSelectionCfg);
            List<DefaultOptionItem> r102 = (List) new Gson().fromJson(this.actionBarDefaultSelectionCfg, r101);     // Catch: Exception -> L8
        L10:
            this._defaultOptionList = r102;
            return r102;
        L8:
            e = move-exception;
            FLogger.f375446a.e("PromptContent", "getDefaultOptionList error >>> " + e);
            r102 = null;
            goto L10
        }

        public final String getActionBarDefaultSelectionCfg() {
            return this.actionBarDefaultSelectionCfg;
        }

        public final String getActionBarItemId() {
            return this.actionBarItemId;
        }

        public final String getActionBarKey() {
            return this.actionBarKey;
        }

        public final String getActionBarTemplateId() {
            return this.actionBarTemplateId;
        }

        public final String getBotId() {
            return this.botId;
        }

        public final String getBotInfo() {
            return this.botInfo;
        }

        public final String getCursorPos() {
            return this.cursorPos;
        }

        public final String getMsgExt() {
            return this.msgExt;
        }

        public final String getSchemaUrl() {
            return this.schemaUrl;
        }

        public final String getShowFrom() {
            return this.showFrom;
        }

        public final String getSpeechKey() {
            return this.speechKey;
        }

        public final String getSuggestActionType() {
            return this.suggestActionType;
        }

        public final String getSuggestStyle() {
            return this.suggestStyle;
        }

        public final String getSuggestType() {
            return this.suggestType;
        }

        public final String getUserPrompt() {
            return this.userPrompt;
        }

        public final String isFontBold() {
            return this.isFontBold;
        }

        public final void setActionBarDefaultSelectionCfg(String r100) {
            this.actionBarDefaultSelectionCfg = r100;
        }

        public final void setBotId(String r100) {
            this.botId = r100;
        }

        public final void setBotInfo(String r100) {
            this.botInfo = r100;
        }

        public final void setCursorPos(String r100) {
            this.cursorPos = r100;
        }

        public final void setFontBold(String r100) {
            this.isFontBold = r100;
        }

        public final void setMsgExt(String r100) {
            this.msgExt = r100;
        }

        public final void setSchemaUrl(String r100) {
            this.schemaUrl = r100;
        }

        public final void setShowFrom(String r100) {
            this.showFrom = r100;
        }

        public final void setSpeechKey(String r100) {
            this.speechKey = r100;
        }

        public final void setSuggestStyle(String r100) {
            this.suggestStyle = r100;
        }

        public final void setSuggestType(String r100) {
            this.suggestType = r100;
        }

        public final void setUserPrompt(String r100) {
            this.userPrompt = r100;
        }

        public SuggestV2ExtraForMultiAction(@SuggestActionType String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111, String r112, String r113, String r114, String r115) {
            this.suggestActionType = r100;
            this.actionBarItemId = r101;
            this.actionBarTemplateId = r102;
            this.actionBarKey = r103;
            this.isFontBold = r104;
            this.msgExt = r105;
            this.cursorPos = r106;
            this.userPrompt = r107;
            this.schemaUrl = r108;
            this.speechKey = r110;
            this.actionBarDefaultSelectionCfg = r111;
            this.botInfo = r112;
            this.showFrom = r113;
            this.suggestStyle = r114;
            this.botId = r115;
        }

        public /* synthetic */ SuggestV2ExtraForMultiAction(String r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, int r312, DefaultConstructorMarker r313) {
            String r100 = null;
            if ((r312 & 1) == 0) goto L5;
            String r101 = null;
        L7:
            if ((r312 & 2) == 0) goto L9;
            String r102 = null;
        L11:
            if ((r312 & 4) == 0) goto L13;
            String r103 = null;
        L15:
            if ((r312 & 8) == 0) goto L17;
            String r104 = null;
        L19:
            if ((r312 & 16) == 0) goto L21;
            String r105 = null;
        L23:
            if ((r312 & 32) == 0) goto L25;
            String r106 = null;
        L27:
            if ((r312 & 64) == 0) goto L29;
            String r107 = null;
        L31:
            if ((r312 & 128) == 0) goto L33;
            String r108 = null;
        L35:
            if ((r312 & 256) == 0) goto L37;
            String r113 = null;
        L39:
            if ((r312 & 512) == 0) goto L41;
            String r114 = null;
        L43:
            if ((r312 & 1024) == 0) goto L45;
            String r115 = null;
        L47:
            if ((r312 & 2048) == 0) goto L49;
            String r116 = null;
        L51:
            if ((r312 & 4096) == 0) goto L53;
            String r117 = null;
        L55:
            if ((r312 & 8192) == 0) goto L57;
            String r118 = SuggestV2Style.DEFAULT.getValue();
        L59:
            if ((r312 & 16384) != 0) goto L62;
            r100 = r311;
        L62:
            this(r101, r102, r103, r104, r105, r106, r107, r108, r113, r114, r115, r116, r117, r118, r100);
            return;
        L57:
            r118 = r310;
            goto L59
        L53:
            r117 = r219;
            goto L55
        L49:
            r116 = r218;
            goto L51
        L45:
            r115 = r217;
            goto L47
        L41:
            r114 = r216;
            goto L43
        L37:
            r113 = r215;
            goto L39
        L33:
            r108 = r214;
            goto L35
        L29:
            r107 = r213;
            goto L31
        L25:
            r106 = r212;
            goto L27
        L21:
            r105 = r211;
            goto L23
        L17:
            r104 = r210;
            goto L19
        L13:
            r103 = r112;
            goto L15
        L9:
            r102 = r111;
            goto L11
        L5:
            r101 = r110;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/bean/PromptContent$SuggestV2Style;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DEFAULT", "COLORFUL", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SuggestV2Style extends Enum<SuggestV2Style> {
        public static final SuggestV2Style COLORFUL = null;
        public static final SuggestV2Style DEFAULT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SuggestV2Style[] f297427a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f297428b = null;
        private final String value;

        public static EnumEntries<SuggestV2Style> getEntries() {
            return f297428b;
        }

        static {
            SuggestV2Style r100 = new SuggestV2Style("DEFAULT", 0, "default");
            DEFAULT = r100;
            SuggestV2Style r101 = new SuggestV2Style("COLORFUL", 1, "colorful");
            COLORFUL = r101;
            SuggestV2Style[] r102 = {r100, r101};
            f297427a = r102;
            f297428b = EnumEntriesKt.enumEntries(r102);
        }

        public static SuggestV2Style[] values() {
            return (SuggestV2Style[]) f297427a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static SuggestV2Style valueOf(String r100) {
            return (SuggestV2Style) r27.a.a(SuggestV2Style.class, r100);
        }

        public SuggestV2Style(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/bean/PromptContent$TravelSuggestType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "SEARCH", "CALL", "IMAGE4", "GREET", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TravelSuggestType extends Enum<TravelSuggestType> {

        @SerializedName("2")
        public static final TravelSuggestType CALL = null;
        public static final a Companion = null;

        @SerializedName("4")
        public static final TravelSuggestType GREET = null;

        @SerializedName("3")
        public static final TravelSuggestType IMAGE4 = null;

        @SerializedName("1")
        public static final TravelSuggestType SEARCH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TravelSuggestType[] f297429a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f297430b = null;
        public final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<TravelSuggestType> getEntries() {
            return f297430b;
        }

        static {
            TravelSuggestType r100 = new TravelSuggestType("SEARCH", 0, 1);
            SEARCH = r100;
            TravelSuggestType r101 = new TravelSuggestType("CALL", 1, 2);
            CALL = r101;
            TravelSuggestType r102 = new TravelSuggestType("IMAGE4", 2, 3);
            IMAGE4 = r102;
            TravelSuggestType r103 = new TravelSuggestType("GREET", 3, 4);
            GREET = r103;
            TravelSuggestType[] r104 = {r100, r101, r102, r103};
            f297429a = r104;
            f297430b = EnumEntriesKt.enumEntries(r104);
            Companion = new a();
        }

        public static TravelSuggestType[] values() {
            return (TravelSuggestType[]) f297429a.clone();
        }

        public static TravelSuggestType valueOf(String r100) {
            return (TravelSuggestType) r27.a.a(TravelSuggestType.class, r100);
        }

        public TravelSuggestType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
        public a() {
        }

        public static SuggestV2Extra a(String r100) {
        L6:
            e = move-exception;
            FLogger.f375446a.e("PromptContent", "getSuggestPromptExtra error >>> " + e);
            return null;
        L3:
            if (o0.d(r100) == false) goto L12;
            return (SuggestV2Extra) new Gson().fromJson(r100, SuggestV2Extra.class);
        L12:
            return null;
        }
    }

    static {
        Companion = new a();
    }

    public PromptContent() {
        this(null, null, null, false, 0, null, null, null, null, null, null, 2047, null);
    }

    public final boolean isEmpty() {
        List<SuggestItem> r100 = this.suggestItems;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L32;
        List<String> r102 = this.suggest;
        if (r102 != null) goto L13;
    L16:
        boolean r103 = true;
    L17:
        if (r103 == false) goto L33;
        List<SuggestV2> r104 = this.suggestV2;
        if (r104 != null) goto L21;
    L24:
        boolean r105 = true;
    L25:
        if (r105 == true) goto L27;
        return false;
    L27:
        if (this.suggestActionCardCnt == 0) goto L29;
        return false;
    L29:
        if (isPlaceholder() == true) goto L36;
        return true;
    L36:
        return false;
    L21:
        if (r104.isEmpty() == true) goto L24;
        r105 = false;
        goto L25
    L33:
        return false;
    L13:
        if (r102.isEmpty() == true) goto L16;
        r103 = false;
        goto L17
    L32:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public final boolean isPlaceholder() {
        Map<String, String> r100 = this.businessExt;
        if (r100 == null) goto L5;
        String r101 = r100.get("is_placeholder");
    L7:
        return Intrinsics.areEqual(r101, "1");
    L5:
        r101 = null;
        goto L7
    }

    public final int size() {
        int r100 = this.suggestActionCardCnt;
        if (r100 == 0) goto L5;
        return r100;
    L5:
        List<SuggestV2> r101 = this.suggestV2;
        boolean r102 = true;
        if (r101 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == true) goto L17;
        List<SuggestV2> r104 = this.suggestV2;
        if (r104 != null) goto L16;
        return 0;
    L16:
        return r104.size();
    L17:
        List<SuggestItem> r105 = this.suggestItems;
        if (r105 != null) goto L20;
    L23:
        boolean r106 = true;
    L24:
        if (r106 == true) goto L29;
        List<SuggestItem> r107 = this.suggestItems;
        if (r107 != null) goto L28;
        return 0;
    L28:
        return r107.size();
    L29:
        List<String> r108 = this.suggest;
        if (r108 != null) goto L32;
    L35:
        if (r102 == true) goto L42;
        List<String> r109 = this.suggest;
        if (r109 != null) goto L39;
        return 0;
    L39:
        return r109.size();
    L42:
        return 0;
    L32:
        if (r108.isEmpty() == true) goto L35;
        r102 = false;
        goto L35
    L20:
        if (r105.isEmpty() == true) goto L23;
        r106 = false;
        goto L24
    L8:
        if (r101.isEmpty() == true) goto L11;
        r103 = false;
        goto L12
    }

    public final List<String> suggestTxt() {
        List<SuggestV2> r100 = this.suggestV2;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        ArrayList r103 = null;
        if (r102 == true) goto L21;
        List<SuggestV2> r104 = this.suggestV2;
        if (r104 == null) goto L20;
        List<SuggestV2> r105 = r104;
        r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<T> r106 = r105.iterator();
    L15:
        if (r106.hasNext() == false) goto L20;
        String r107 = ((SuggestV2) r106.next()).getContent();
        if (r107 != null) goto L19;
        r107 = "";
    L19:
        r103.add(r107);
    L20:
        return r103;
    L21:
        List<SuggestItem> r108 = this.suggestItems;
        if (r108 != null) goto L24;
    L27:
        boolean r109 = true;
    L28:
        if (r109 == true) goto L39;
        List<SuggestItem> r110 = this.suggestItems;
        if (r110 == null) goto L38;
        List<SuggestItem> r111 = r110;
        r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator<T> r112 = r111.iterator();
    L33:
        if (r112.hasNext() == false) goto L38;
        String r113 = ((SuggestItem) r112.next()).getSuggest();
        if (r113 != null) goto L37;
        r113 = "";
    L37:
        r103.add(r113);
    L38:
        return r103;
    L39:
        List<String> r114 = this.suggest;
        if (r114 != null) goto L42;
    L43:
        r101 = true;
    L44:
        if (r101 == true) goto L48;
        return this.suggest;
    L48:
        return CollectionsKt.emptyList();
    L42:
        if (r114.isEmpty() == false) goto L44;
    L24:
        if (r108.isEmpty() == true) goto L27;
        r109 = false;
        goto L28
    L5:
        if (r100.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public final String toJson() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(new Gson().toJson(this));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = null;
    L10:
        return (String) r101;
    L4:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public int hashCode() {
        String r100 = toJson();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final Map<String, String> getBusinessExt() {
        return this.businessExt;
    }

    public final String getOnboardingDisplayStyle() {
        return this.onboardingDisplayStyle;
    }

    public final String getSugType() {
        return this.sugType;
    }

    public final List<String> getSuggest() {
        return this.suggest;
    }

    public final int getSuggestActionCardCnt() {
        return this.suggestActionCardCnt;
    }

    public final List<SuggestItem> getSuggestItems() {
        return this.suggestItems;
    }

    public final List<SuggestV2> getSuggestV2() {
        return this.suggestV2;
    }

    public final String getWcbRenderStatus() {
        return this.wcbRenderStatus;
    }

    public final String getWcbTitle() {
        return this.wcbTitle;
    }

    public final Integer getWcbTitleStyle() {
        return this.wcbTitleStyle;
    }

    public final boolean isNoDisappear() {
        return this.isNoDisappear;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof PromptContent) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(toJson(), ((PromptContent) r100).toJson());
    }

    public final void setBusinessExt(Map<String, String> r100) {
        this.businessExt = r100;
    }

    public final void setNoDisappear(boolean r100) {
        this.isNoDisappear = r100;
    }

    public final void setOnboardingDisplayStyle(String r100) {
        this.onboardingDisplayStyle = r100;
    }

    public final void setSugType(String r100) {
        this.sugType = r100;
    }

    public final void setSuggest(List<String> r100) {
        this.suggest = r100;
    }

    public final void setSuggestActionCardCnt(int r100) {
        this.suggestActionCardCnt = r100;
    }

    public final void setSuggestItems(List<SuggestItem> r100) {
        this.suggestItems = r100;
    }

    public final void setSuggestV2(List<SuggestV2> r100) {
        this.suggestV2 = r100;
    }

    public final void setWcbRenderStatus(String r100) {
        this.wcbRenderStatus = r100;
    }

    public final void setWcbTitle(String r100) {
        this.wcbTitle = r100;
    }

    public final void setWcbTitleStyle(Integer r100) {
        this.wcbTitleStyle = r100;
    }

    public PromptContent(List<String> r100, List<SuggestV2> r101, List<SuggestItem> r102, boolean r103, int r104, String r105, String r106, Map<String, String> r107, @WcbRenderStatus String r108, String r110, Integer r111) {
        this.suggest = r100;
        this.suggestV2 = r101;
        this.suggestItems = r102;
        this.isNoDisappear = r103;
        this.suggestActionCardCnt = r104;
        this.onboardingDisplayStyle = r105;
        this.sugType = r106;
        this.businessExt = r107;
        this.wcbRenderStatus = r108;
        this.wcbTitle = r110;
        this.wcbTitleStyle = r111;
    }

    public /* synthetic */ PromptContent(List r110, List r111, List r112, boolean r113, int r114, String r115, String r116, Map r210, String r211, String r212, Integer r213, int r214, DefaultConstructorMarker r215) {
        if ((r214 & 1) == 0) goto L5;
        List r100 = CollectionsKt.emptyList();
    L7:
        if ((r214 & 2) == 0) goto L9;
        List r101 = CollectionsKt.emptyList();
    L11:
        if ((r214 & 4) == 0) goto L13;
        List r102 = CollectionsKt.emptyList();
    L15:
        if ((r214 & 8) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r214 & 16) == 0) goto L21;
        int r104 = 0;
    L22:
        String r105 = "";
        if ((r214 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r214 & 64) != 0) goto L31;
        r105 = r116;
    L31:
        if ((r214 & 128) == 0) goto L33;
        Map r107 = MapsKt.emptyMap();
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r117 = "DEFAULT";
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r118 = null;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        Integer r108 = 0;
    L46:
        this(r100, r101, r102, r103, r104, r106, r105, r107, r117, r118, r108);
        return;
    L45:
        r108 = r213;
        goto L46
    L41:
        r118 = r212;
        goto L43
    L37:
        r117 = r211;
        goto L39
    L33:
        r107 = r210;
        goto L35
    L25:
        r106 = r115;
        goto L27
    L21:
        r104 = r114;
        goto L22
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
