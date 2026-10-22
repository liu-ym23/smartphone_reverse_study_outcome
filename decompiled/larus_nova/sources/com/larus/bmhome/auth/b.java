package com.larus.bmhome.auth;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.audio.bean.TtsFeedbackItem;
import com.larus.audio.bean.VoiceListTabInfo;
import com.larus.bmhome.auth.feature_config.model.FeatureDetail;
import com.larus.disk.api.CacheHandlerBusiness;
import com.larus.im.bean.bot.IconItem;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bI\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B±\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0014\u0012\u0012\b\u0002\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\u001c\u0012\u001c\b\u0002\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u0005\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0005\u0012\b\b\u0002\u0010\"\u001a\u00020\u0003\u0012\b\b\u0002\u0010#\u001a\u00020\u0003\u0012\u001c\b\u0002\u0010$\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0005\u0018\u00010\u001c\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b,\u0010-J\u0010\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010/J\u0011\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0013\u0010S\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0005HÆ\u0003J\u0011\u0010T\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005HÆ\u0003J\u0011\u0010U\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0005HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0011\u0010W\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0005HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0013\u0010[\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\\\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0005HÆ\u0003J\u0011\u0010]\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0005HÆ\u0003J\u0017\u0010^\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\u001cHÆ\u0003J\u001d\u0010_\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u0005\u0018\u00010\u001cHÆ\u0003J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\u0011\u0010a\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0005HÆ\u0003J\t\u0010b\u001a\u00020\u0003HÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\u001d\u0010d\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0005\u0018\u00010\u001cHÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010&HÆ\u0003J\u0010\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010j\u001a\u0004\u0018\u00010\u0014HÆ\u0003J¸\u0003\u0010k\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00052\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0012\b\u0002\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u00052\u0012\b\u0002\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u00052\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00052\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\u001c2\u001c\b\u0002\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u0005\u0018\u00010\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u00032\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u00052\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\u001c\b\u0002\u0010$\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0005\u0018\u00010\u001c2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010lJ\u0013\u0010m\u001a\u00020\u00032\b\u0010n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010o\u001a\u00020pHÖ\u0001J\t\u0010q\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00102R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00102R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00102R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u00102R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010<R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010<R \u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u00102R \u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u00102R\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u00102R$\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR*\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u0005\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010CR\u0016\u0010\u001f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010ER\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u00102R\u0016\u0010\"\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010ER\u0016\u0010#\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010ER*\u0010$\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0005\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010CR\u0018\u0010%\u001a\u0004\u0018\u00010&8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u001a\u0010'\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00100\u001a\u0004\bL\u0010/R\u001a\u0010(\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00100\u001a\u0004\bM\u0010/R\u001a\u0010)\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00100\u001a\u0004\bN\u0010/R\u001a\u0010*\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00100\u001a\u0004\b*\u0010/R\u0018\u0010+\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010<¨\u0006r"}, d2 = {"Lcom/larus/bmhome/auth/AudioLaunchInfo;", "", "useTestDomain", "", "streamAppDetails", "", "Lcom/larus/bmhome/auth/AudioStreamAppDetail;", "config", "Lcom/larus/bmhome/auth/Config;", "voiceList", "Lcom/larus/im/bean/bot/ModelItem;", "newVoiceList", "Lcom/larus/im/bean/bot/SpeakerVoice;", "callFeedbackMeta", "Lcom/larus/bmhome/auth/FeedbackMeta;", "callFeedbackPlaceholder", "", "speechLanguageList", "Lcom/larus/bmhome/auth/SpeechLanguage;", "answerWithVideo", "Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;", "exclusiveVoice", "activeVoiceConfig", "allowUgcVoice", "enableTtsLanguageCodeList", "ugcVoiceIconList", "Lcom/larus/im/bean/bot/IconItem;", "asrModelMap", "", "tabMap", "Lcom/larus/audio/bean/VoiceListTabInfo;", "isUgcVoiceAuthorized", "ttsFeedbackItemList", "Lcom/larus/audio/bean/TtsFeedbackItem;", "coldStartEnableTts", "hasUgcVoiceRecord", "voiceTalkList", "continueCallConf", "Lcom/larus/bmhome/auth/ContinueCallConf;", "languageSettingIsHidden", "enableMultiLanguage", "disableAutoTts", "isRealtimeNewBackgroundEnabled", "ugcVoice", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;Lcom/larus/bmhome/auth/Config;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;ZLjava/util/List;ZZLjava/util/Map;Lcom/larus/bmhome/auth/ContinueCallConf;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;)V", "getUseTestDomain", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStreamAppDetails", "()Ljava/util/List;", "getConfig", "()Lcom/larus/bmhome/auth/Config;", "getVoiceList", "getNewVoiceList", "getCallFeedbackMeta", "getCallFeedbackPlaceholder", "()Ljava/lang/String;", "getSpeechLanguageList", "getAnswerWithVideo", "()Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;", "getExclusiveVoice", "getActiveVoiceConfig", "getAllowUgcVoice", "getEnableTtsLanguageCodeList", "getUgcVoiceIconList", "getAsrModelMap", "()Ljava/util/Map;", "getTabMap", "()Z", "getTtsFeedbackItemList", "getColdStartEnableTts", "getHasUgcVoiceRecord", "getVoiceTalkList", "getContinueCallConf", "()Lcom/larus/bmhome/auth/ContinueCallConf;", "getLanguageSettingIsHidden", "getEnableMultiLanguage", "getDisableAutoTts", "getUgcVoice", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "copy", "(Ljava/lang/Boolean;Ljava/util/List;Lcom/larus/bmhome/auth/Config;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;ZLjava/util/List;ZZLjava/util/Map;Lcom/larus/bmhome/auth/ContinueCallConf;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;)Lcom/larus/bmhome/auth/AudioLaunchInfo;", "equals", "other", "hashCode", "", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("active_voice_config")
    private final FeatureDetail activeVoiceConfig;

    @SerializedName("allow_ugc_voice")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> allowUgcVoice;

    @SerializedName("answer_with_video")
    private final FeatureDetail answerWithVideo;

    @SerializedName("asr_model_map")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final Map<String, ModelItem> asrModelMap;

    @SerializedName("call_feedback_meta")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<FeedbackMeta> callFeedbackMeta;

    @SerializedName("call_feedback_placeholder")
    private final String callFeedbackPlaceholder;

    @SerializedName("cold_start_enable_tts")
    private final boolean coldStartEnableTts;

    @SerializedName("config")
    private final Config config;

    @SerializedName("client_continue_call_conf")
    private final ContinueCallConf continueCallConf;

    @SerializedName("disable_auto_tts")
    private final Boolean disableAutoTts;

    @SerializedName("enable_multilanguage")
    private final Boolean enableMultiLanguage;

    @SerializedName("enable_tts_language_code_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> enableTtsLanguageCodeList;

    @SerializedName("exclusive_voice")
    private final FeatureDetail exclusiveVoice;

    @SerializedName("has_ugc_voice_record")
    private final boolean hasUgcVoiceRecord;

    @SerializedName("is_realtime_new_background_enabled")
    private final Boolean isRealtimeNewBackgroundEnabled;

    @SerializedName("ugc_voice_authorized")
    private final boolean isUgcVoiceAuthorized;

    @SerializedName("language_setting_is_hidden")
    private final Boolean languageSettingIsHidden;

    @SerializedName("new_voice_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<SpeakerVoice> newVoiceList;

    @SerializedName("speech_language_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<SpeechLanguage> speechLanguageList;

    @SerializedName("stream_app_details")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<c> streamAppDetails;

    @SerializedName("voice_list_tab_info")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final Map<String, List<VoiceListTabInfo>> tabMap;

    @SerializedName("audio_voice_feedback_item_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<TtsFeedbackItem> ttsFeedbackItemList;

    @SerializedName(CacheHandlerBusiness.UGC_VOICE)
    private final FeatureDetail ugcVoice;

    @SerializedName("ugc_voice_icon_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<IconItem> ugcVoiceIconList;

    @SerializedName("use_test_domain")
    private final Boolean useTestDomain;

    @SerializedName("voice_list")
    private final List<ModelItem> voiceList;

    @SerializedName("ugc_voice_freetalk_list_by_language")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final Map<String, List<String>> voiceTalkList;

    public b() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, false, false, null, null, null, null, null, null, null, 134217727);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.useTestDomain, r101.useTestDomain) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.streamAppDetails, r101.streamAppDetails) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.config, r101.config) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.voiceList, r101.voiceList) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.newVoiceList, r101.newVoiceList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.callFeedbackMeta, r101.callFeedbackMeta) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.callFeedbackPlaceholder, r101.callFeedbackPlaceholder) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.speechLanguageList, r101.speechLanguageList) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.answerWithVideo, r101.answerWithVideo) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.exclusiveVoice, r101.exclusiveVoice) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.activeVoiceConfig, r101.activeVoiceConfig) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.allowUgcVoice, r101.allowUgcVoice) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.enableTtsLanguageCodeList, r101.enableTtsLanguageCodeList) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.ugcVoiceIconList, r101.ugcVoiceIconList) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.asrModelMap, r101.asrModelMap) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.tabMap, r101.tabMap) == true) goto L57;
        return false;
    L57:
        if (this.isUgcVoiceAuthorized == r101.isUgcVoiceAuthorized) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.ttsFeedbackItemList, r101.ttsFeedbackItemList) == true) goto L63;
        return false;
    L63:
        if (this.coldStartEnableTts == r101.coldStartEnableTts) goto L66;
        return false;
    L66:
        if (this.hasUgcVoiceRecord == r101.hasUgcVoiceRecord) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.voiceTalkList, r101.voiceTalkList) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.continueCallConf, r101.continueCallConf) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.languageSettingIsHidden, r101.languageSettingIsHidden) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.enableMultiLanguage, r101.enableMultiLanguage) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.disableAutoTts, r101.disableAutoTts) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.isRealtimeNewBackgroundEnabled, r101.isRealtimeNewBackgroundEnabled) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.ugcVoice, r101.ugcVoice) == true) goto L89;
        return false;
    L89:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.useTestDomain;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<c> r104 = this.streamAppDetails;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Config r107 = this.config;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<ModelItem> r110 = this.voiceList;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<SpeakerVoice> r113 = this.newVoiceList;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<FeedbackMeta> r116 = this.callFeedbackMeta;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.callFeedbackPlaceholder;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        List<SpeechLanguage> r122 = this.speechLanguageList;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        FeatureDetail r125 = this.answerWithVideo;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        FeatureDetail r128 = this.exclusiveVoice;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        FeatureDetail r131 = this.activeVoiceConfig;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        List<String> r134 = this.allowUgcVoice;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        List<String> r137 = this.enableTtsLanguageCodeList;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        List<IconItem> r140 = this.ugcVoiceIconList;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        Map<String, ModelItem> r143 = this.asrModelMap;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        Map<String, List<VoiceListTabInfo>> r146 = this.tabMap;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        int r149 = 1231;
        if (this.isUgcVoiceAuthorized == false) goto L69;
        int r150 = 1231;
    L70:
        int r151 = (r148 + r150) * 31;
        List<TtsFeedbackItem> r152 = this.ttsFeedbackItemList;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        if (this.coldStartEnableTts == false) goto L77;
        int r155 = 1231;
    L78:
        int r156 = (r154 + r155) * 31;
        if (this.hasUgcVoiceRecord == true) goto L82;
        r149 = 1237;
    L82:
        int r157 = (r156 + r149) * 31;
        Map<String, List<String>> r158 = this.voiceTalkList;
        if (r158 != null) goto L85;
        int r159 = 0;
    L86:
        int r160 = (r157 + r159) * 31;
        ContinueCallConf r161 = this.continueCallConf;
        if (r161 != null) goto L89;
        int r162 = 0;
    L90:
        int r163 = (r160 + r162) * 31;
        Boolean r164 = this.languageSettingIsHidden;
        if (r164 != null) goto L93;
        int r165 = 0;
    L94:
        int r166 = (r163 + r165) * 31;
        Boolean r167 = this.enableMultiLanguage;
        if (r167 != null) goto L97;
        int r168 = 0;
    L98:
        int r169 = (r166 + r168) * 31;
        Boolean r170 = this.disableAutoTts;
        if (r170 != null) goto L101;
        int r171 = 0;
    L102:
        int r172 = (r169 + r171) * 31;
        Boolean r173 = this.isRealtimeNewBackgroundEnabled;
        if (r173 != null) goto L105;
        int r174 = 0;
    L106:
        int r175 = (r172 + r174) * 31;
        FeatureDetail r176 = this.ugcVoice;
        if (r176 == null) goto L111;
        r101 = r176.hashCode();
    L111:
        return r175 + r101;
    L105:
        r174 = r173.hashCode();
        goto L106
    L101:
        r171 = r170.hashCode();
        goto L102
    L97:
        r168 = r167.hashCode();
        goto L98
    L93:
        r165 = r164.hashCode();
        goto L94
    L89:
        r162 = r161.hashCode();
        goto L90
    L85:
        r159 = r158.hashCode();
        goto L86
    L77:
        r155 = 1237;
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
    L69:
        r150 = 1237;
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
        r138 = r137.hashCode();
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

    public final String toString() {
        return "AudioLaunchInfo(useTestDomain=" + this.useTestDomain + ", streamAppDetails=" + this.streamAppDetails + ", config=" + this.config + ", voiceList=" + this.voiceList + ", newVoiceList=" + this.newVoiceList + ", callFeedbackMeta=" + this.callFeedbackMeta + ", callFeedbackPlaceholder=" + this.callFeedbackPlaceholder + ", speechLanguageList=" + this.speechLanguageList + ", answerWithVideo=" + this.answerWithVideo + ", exclusiveVoice=" + this.exclusiveVoice + ", activeVoiceConfig=" + this.activeVoiceConfig + ", allowUgcVoice=" + this.allowUgcVoice + ", enableTtsLanguageCodeList=" + this.enableTtsLanguageCodeList + ", ugcVoiceIconList=" + this.ugcVoiceIconList + ", asrModelMap=" + this.asrModelMap + ", tabMap=" + this.tabMap + ", isUgcVoiceAuthorized=" + this.isUgcVoiceAuthorized + ", ttsFeedbackItemList=" + this.ttsFeedbackItemList + ", coldStartEnableTts=" + this.coldStartEnableTts + ", hasUgcVoiceRecord=" + this.hasUgcVoiceRecord + ", voiceTalkList=" + this.voiceTalkList + ", continueCallConf=" + this.continueCallConf + ", languageSettingIsHidden=" + this.languageSettingIsHidden + ", enableMultiLanguage=" + this.enableMultiLanguage + ", disableAutoTts=" + this.disableAutoTts + ", isRealtimeNewBackgroundEnabled=" + this.isRealtimeNewBackgroundEnabled + ", ugcVoice=" + this.ugcVoice + ')';
    }

    public final boolean A() {
        return this.isUgcVoiceAuthorized;
    }

    public final FeatureDetail a() {
        return this.activeVoiceConfig;
    }

    public final List<String> b() {
        return this.allowUgcVoice;
    }

    public final FeatureDetail c() {
        return this.answerWithVideo;
    }

    public final Map<String, ModelItem> d() {
        return this.asrModelMap;
    }

    public final List<FeedbackMeta> e() {
        return this.callFeedbackMeta;
    }

    public final String f() {
        return this.callFeedbackPlaceholder;
    }

    public final boolean g() {
        return this.coldStartEnableTts;
    }

    public final Config h() {
        return this.config;
    }

    public final ContinueCallConf i() {
        return this.continueCallConf;
    }

    public final Boolean j() {
        return this.disableAutoTts;
    }

    public final Boolean k() {
        return this.enableMultiLanguage;
    }

    public final List<String> l() {
        return this.enableTtsLanguageCodeList;
    }

    public final FeatureDetail m() {
        return this.exclusiveVoice;
    }

    public final boolean n() {
        return this.hasUgcVoiceRecord;
    }

    public final Boolean o() {
        return this.languageSettingIsHidden;
    }

    public final List<SpeakerVoice> p() {
        return this.newVoiceList;
    }

    public final List<SpeechLanguage> q() {
        return this.speechLanguageList;
    }

    public final List<c> r() {
        return this.streamAppDetails;
    }

    public final Map<String, List<VoiceListTabInfo>> s() {
        return this.tabMap;
    }

    public final List<TtsFeedbackItem> t() {
        return this.ttsFeedbackItemList;
    }

    public final FeatureDetail u() {
        return this.ugcVoice;
    }

    public final List<IconItem> v() {
        return this.ugcVoiceIconList;
    }

    public final Boolean w() {
        return this.useTestDomain;
    }

    public final List<ModelItem> x() {
        return this.voiceList;
    }

    public final Map<String, List<String>> y() {
        return this.voiceTalkList;
    }

    public final Boolean z() {
        return this.isRealtimeNewBackgroundEnabled;
    }

    public b(Config r310, List r311, List r312, List r313, String r314, List r315, FeatureDetail r316, FeatureDetail r317, FeatureDetail r318, List r319, List r410, List r411, Map r412, Map r413, boolean r414, List r415, boolean r416, boolean r417, Map r418, ContinueCallConf r419, Boolean r510, Boolean r511, Boolean r512, Boolean r513, FeatureDetail r514, int r515) {
        if ((r515 & 1) == 0) goto L5;
        Boolean r100 = Boolean.FALSE;
    L7:
        if ((r515 & 4) == 0) goto L9;
        Config r101 = null;
    L11:
        if ((r515 & 8) == 0) goto L13;
        List r102 = null;
    L15:
        if ((r515 & 16) == 0) goto L17;
        List r103 = null;
    L19:
        if ((r515 & 32) == 0) goto L21;
        List r104 = null;
    L23:
        if ((r515 & 64) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r515 & 128) == 0) goto L29;
        List r106 = null;
    L31:
        if ((r515 & 256) == 0) goto L33;
        FeatureDetail r110 = null;
    L35:
        if ((r515 & 512) == 0) goto L37;
        FeatureDetail r111 = null;
    L39:
        if ((r515 & 1024) == 0) goto L41;
        FeatureDetail r112 = null;
    L43:
        if ((r515 & 2048) == 0) goto L45;
        List r113 = CollectionsKt.emptyList();
    L47:
        if ((r515 & 4096) == 0) goto L49;
        List r114 = CollectionsKt.emptyList();
    L51:
        if ((r515 & 8192) == 0) goto L53;
        List r115 = null;
    L55:
        if ((r515 & 16384) == 0) goto L57;
        Map r107 = null;
    L59:
        if ((r515 & 32768) == 0) goto L61;
        Map r116 = null;
    L63:
        if ((r515 & 65536) == 0) goto L65;
        boolean r117 = false;
    L67:
        if ((r515 & 131072) == 0) goto L69;
        List r118 = null;
    L71:
        if ((r515 & 262144) == 0) goto L73;
        boolean r210 = true;
    L75:
        if ((r515 & 524288) == 0) goto L77;
        boolean r211 = true;
    L79:
        if ((r515 & 1048576) == 0) goto L81;
        Map r212 = null;
    L83:
        if ((r515 & 2097152) == 0) goto L85;
        ContinueCallConf r213 = null;
    L87:
        if ((r515 & 4194304) == 0) goto L89;
        Boolean r214 = Boolean.FALSE;
    L91:
        if ((r515 & 8388608) == 0) goto L93;
        Boolean r215 = Boolean.FALSE;
    L95:
        if ((r515 & 16777216) == 0) goto L97;
        Boolean r216 = Boolean.FALSE;
    L99:
        if ((r515 & 33554432) == 0) goto L101;
        Boolean r217 = null;
    L103:
        if ((r515 & 67108864) == 0) goto L105;
        FeatureDetail r108 = null;
    L106:
        this.useTestDomain = r100;
        this.streamAppDetails = null;
        this.config = r101;
        this.voiceList = r102;
        this.newVoiceList = r103;
        this.callFeedbackMeta = r104;
        this.callFeedbackPlaceholder = r105;
        this.speechLanguageList = r106;
        this.answerWithVideo = r110;
        this.exclusiveVoice = r111;
        this.activeVoiceConfig = r112;
        this.allowUgcVoice = r113;
        this.enableTtsLanguageCodeList = r114;
        this.ugcVoiceIconList = r115;
        this.asrModelMap = r107;
        this.tabMap = r116;
        this.isUgcVoiceAuthorized = r117;
        this.ttsFeedbackItemList = r118;
        this.coldStartEnableTts = r210;
        this.hasUgcVoiceRecord = r211;
        this.voiceTalkList = r212;
        this.continueCallConf = r213;
        this.languageSettingIsHidden = r214;
        this.enableMultiLanguage = r215;
        this.disableAutoTts = r216;
        this.isRealtimeNewBackgroundEnabled = r217;
        this.ugcVoice = r108;
        return;
    L105:
        r108 = r514;
        goto L106
    L101:
        r217 = r513;
        goto L103
    L97:
        r216 = r512;
        goto L99
    L93:
        r215 = r511;
        goto L95
    L89:
        r214 = r510;
        goto L91
    L85:
        r213 = r419;
        goto L87
    L81:
        r212 = r418;
        goto L83
    L77:
        r211 = r417;
        goto L79
    L73:
        r210 = r416;
        goto L75
    L69:
        r118 = r415;
        goto L71
    L65:
        r117 = r414;
        goto L67
    L61:
        r116 = r413;
        goto L63
    L57:
        r107 = r412;
        goto L59
    L53:
        r115 = r411;
        goto L55
    L49:
        r114 = r410;
        goto L51
    L45:
        r113 = r319;
        goto L47
    L41:
        r112 = r318;
        goto L43
    L37:
        r111 = r317;
        goto L39
    L33:
        r110 = r316;
        goto L35
    L29:
        r106 = r315;
        goto L31
    L25:
        r105 = r314;
        goto L27
    L21:
        r104 = r313;
        goto L23
    L17:
        r103 = r312;
        goto L19
    L13:
        r102 = r311;
        goto L15
    L9:
        r101 = r310;
        goto L11
    L5:
        r100 = null;
        goto L7
    }
}
