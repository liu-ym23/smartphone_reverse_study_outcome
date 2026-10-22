package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentPublishScene;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotConfItem;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotStatistic;
import com.larus.im.bean.bot.BotSwitchConfInfo;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.im.bean.bot.FirstMet;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.ShareInfo;
import com.larus.im.bean.bot.ShowTagInfo;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.internal.protocol.model.BotCommentInfo;
import com.larus.im.internal.protocol.model.LikeInfo;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000Ó\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0003\b\u008a\u0001\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u0097\u00022\u00020\u00012\u00020\u0002:\u0002\u0097\u0002B\u009d\u0004\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010%\u001a\u00020\u0011\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u000100\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000102\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000104\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000109\u0012\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010)\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?\u0012\b\b\u0002\u0010@\u001a\u00020\u0011\u0012\b\b\u0002\u0010A\u001a\u00020\u0007\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010C\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010E\u0012\b\b\u0002\u0010F\u001a\u00020\u0011¢\u0006\u0004\bG\u0010HJ\t\u0010×\u0001\u001a\u0004\u0018\u00010\u0004J\t\u0010Ø\u0001\u001a\u00020\u0004H\u0016J\t\u0010Ù\u0001\u001a\u00020\u0004H\u0016J\u0011\u0010Ú\u0001\u001a\u00030Û\u00012\u0007\u0010Ü\u0001\u001a\u00020\u0004J\f\u0010Ý\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010Þ\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010ß\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010PJ\f\u0010à\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010á\u0001\u001a\u00020\u0007HÆ\u0003J\f\u0010â\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\n\u0010ã\u0001\u001a\u00020\rHÆ\u0003J\n\u0010ä\u0001\u001a\u00020\rHÆ\u0003J\n\u0010å\u0001\u001a\u00020\rHÆ\u0003J\n\u0010æ\u0001\u001a\u00020\u0011HÆ\u0003J\f\u0010ç\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010è\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\f\u0010é\u0001\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\f\u0010ê\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\f\u0010ë\u0001\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u0011\u0010ì\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010{J\f\u0010í\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010î\u0001\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\f\u0010ï\u0001\u001a\u0004\u0018\u00010 HÆ\u0003J\f\u0010ð\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010ñ\u0001\u001a\u0004\u0018\u00010#HÆ\u0003J\u0011\u0010ò\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010PJ\n\u0010ó\u0001\u001a\u00020\u0011HÆ\u0003J\f\u0010ô\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010õ\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010ö\u0001\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)HÆ\u0003J\f\u0010÷\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010ø\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010ù\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010ú\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010û\u0001\u001a\u0004\u0018\u000100HÆ\u0003J\f\u0010ü\u0001\u001a\u0004\u0018\u000102HÆ\u0003J\f\u0010ý\u0001\u001a\u0004\u0018\u000104HÆ\u0003J\u0011\u0010þ\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010PJ\f\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u0080\u0002\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010{J\f\u0010\u0081\u0002\u001a\u0004\u0018\u000109HÆ\u0003J\u0012\u0010\u0082\u0002\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010)HÆ\u0003J\f\u0010\u0083\u0002\u001a\u0004\u0018\u00010=HÆ\u0003J\f\u0010\u0084\u0002\u001a\u0004\u0018\u00010?HÆ\u0003J\n\u0010\u0085\u0002\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0086\u0002\u001a\u00020\u0007HÆ\u0003J\f\u0010\u0087\u0002\u001a\u0004\u0018\u00010CHÆ\u0003J\f\u0010\u0088\u0002\u001a\u0004\u0018\u00010EHÆ\u0003J\n\u0010\u0089\u0002\u001a\u00020\u0011HÆ\u0003J¦\u0004\u0010\u008a\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010%\u001a\u00020\u00112\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010)2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2\b\b\u0002\u0010@\u001a\u00020\u00112\b\b\u0002\u0010A\u001a\u00020\u00072\n\b\u0002\u0010B\u001a\u0004\u0018\u00010C2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010E2\b\b\u0002\u0010F\u001a\u00020\u0011HÆ\u0001¢\u0006\u0003\u0010\u008b\u0002J\u0007\u0010\u008c\u0002\u001a\u00020\u0007J\u0016\u0010\u008d\u0002\u001a\u00020\u00112\n\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u008f\u0002HÖ\u0003J\n\u0010\u0090\u0002\u001a\u00020\u0007HÖ\u0001J\n\u0010\u0091\u0002\u001a\u00020\u0004HÖ\u0001J\u001b\u0010\u0092\u0002\u001a\u00030\u0093\u00022\b\u0010\u0094\u0002\u001a\u00030\u0095\u00022\u0007\u0010\u0096\u0002\u001a\u00020\u0007R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR \u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010J\"\u0004\bN\u0010LR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR \u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010J\"\u0004\bU\u0010LR\u001e\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001e\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010_\"\u0004\bc\u0010aR\u001e\u0010\u000f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010_\"\u0004\be\u0010aR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010J\"\u0004\bk\u0010LR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR \u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\"\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010~\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R!\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010J\"\u0005\b\u0080\u0001\u0010LR$\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R$\u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R\"\u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010J\"\u0005\b\u008a\u0001\u0010LR$\u0010\"\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R$\u0010$\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010S\u001a\u0005\b\u008f\u0001\u0010P\"\u0005\b\u0090\u0001\u0010RR \u0010%\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010g\"\u0005\b\u0092\u0001\u0010iR\"\u0010&\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010J\"\u0005\b\u0094\u0001\u0010LR\"\u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010J\"\u0005\b\u0096\u0001\u0010LR*\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R\"\u0010+\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0001\u0010J\"\u0005\b\u009c\u0001\u0010LR\"\u0010,\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009d\u0001\u0010J\"\u0005\b\u009e\u0001\u0010LR\"\u0010-\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0001\u0010J\"\u0005\b \u0001\u0010LR\"\u0010.\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¡\u0001\u0010J\"\u0005\b¢\u0001\u0010LR$\u0010/\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R$\u00101\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001R$\u00103\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R$\u00105\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010S\u001a\u0005\b¯\u0001\u0010P\"\u0005\b°\u0001\u0010RR\"\u00106\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0001\u0010J\"\u0005\b²\u0001\u0010LR$\u00107\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010~\u001a\u0005\b³\u0001\u0010{\"\u0005\b´\u0001\u0010}R$\u00108\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bµ\u0001\u0010¶\u0001\"\u0006\b·\u0001\u0010¸\u0001R*\u0010:\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¹\u0001\u0010\u0098\u0001\"\u0006\bº\u0001\u0010\u009a\u0001R$\u0010<\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b»\u0001\u0010¼\u0001\"\u0006\b½\u0001\u0010¾\u0001R$\u0010>\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¿\u0001\u0010À\u0001\"\u0006\bÁ\u0001\u0010Â\u0001R\u001f\u0010@\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b@\u0010g\"\u0005\bÃ\u0001\u0010iR \u0010A\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÄ\u0001\u0010W\"\u0005\bÅ\u0001\u0010YR \u0010B\u001a\u0004\u0018\u00010CX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÆ\u0001\u0010Ç\u0001\"\u0006\bÈ\u0001\u0010É\u0001R \u0010D\u001a\u0004\u0018\u00010EX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÊ\u0001\u0010Ë\u0001\"\u0006\bÌ\u0001\u0010Í\u0001R\u001b\u0010F\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\bF\u0010g\"\u0005\bÎ\u0001\u0010iR\u001a\u0010Ï\u0001\u001a\u0005\u0018\u00010Ð\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bÑ\u0001\u0010Ò\u0001R\u0013\u0010Ó\u0001\u001a\u00020\u00118F¢\u0006\u0007\u001a\u0005\bÓ\u0001\u0010gR\u0013\u0010Ô\u0001\u001a\u00020\u00118F¢\u0006\u0007\u001a\u0005\bÔ\u0001\u0010gR\u0013\u0010Õ\u0001\u001a\u00020\u00118F¢\u0006\u0007\u001a\u0005\bÖ\u0001\u0010g¨\u0006\u0098\u0002"}, d2 = {"Lcom/larus/bmhome/chat/bean/RecommendBot;", "Lcom/larus/im/bean/conversation/ActionbarBaseData;", "Landroid/os/Parcelable;", "botId", "", "name", "botType", "", "botFeatureLabel", "botMode", "iconImage", "Lcom/larus/im/bean/bot/BotIconImage;", "createTime", "", UserInfo.UPDATE_TIME, "recommendIndex", "hasConversation", "", "conversationId", "onboarding", "Lcom/larus/bmhome/chat/bean/BotOnBoarding;", "botAction", "Lcom/larus/bmhome/chat/bean/BotAction;", "botCreatorInfo", "Lcom/larus/im/bean/bot/BotCreatorInfo;", "botStatus", "Lcom/larus/im/bean/bot/BotStatistic;", "muted", "humanDescription", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/im/bean/bot/ModelItem;", "voice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "editPos", "shareInfo", "Lcom/larus/im/bean/bot/ShareInfo;", "privateStatus", "disabled", "disabledTag", "bio", "botConf", "", "Lcom/larus/im/bean/bot/BotConfItem;", "bgImgUrl", "bgImgColor", "bgVideoModel", "bgImgUri", "bgImgInfo", "Lcom/larus/im/bean/bot/BgImageInfo;", "conversationPage", "Lcom/larus/im/bean/bot/ConversationPage;", "switchConfInfo", "Lcom/larus/im/bean/bot/BotSwitchConfInfo;", "contentDistType", "callerName", "callerNameSetting", "firstMet", "Lcom/larus/im/bean/bot/FirstMet;", "tagList", "Lcom/larus/im/bean/bot/ShowTagInfo;", "likeInfo", "Lcom/larus/im/internal/protocol/model/LikeInfo;", "commentInfo", "Lcom/larus/im/internal/protocol/model/BotCommentInfo;", "isPlaceHolder", "loadMoreStatus", "from", "Lcom/larus/platform/model/RecommendFrom;", "searchMobParam", "Lcom/larus/platform/model/SearchMobParam;", "isFromCache", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ILcom/larus/im/bean/bot/BotIconImage;JJJZLjava/lang/String;Lcom/larus/bmhome/chat/bean/BotOnBoarding;Lcom/larus/bmhome/chat/bean/BotAction;Lcom/larus/im/bean/bot/BotCreatorInfo;Lcom/larus/im/bean/bot/BotStatistic;Ljava/lang/Boolean;Ljava/lang/String;Lcom/larus/im/bean/bot/ModelItem;Lcom/larus/im/bean/bot/SpeakerVoice;Ljava/lang/String;Lcom/larus/im/bean/bot/ShareInfo;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BgImageInfo;Lcom/larus/im/bean/bot/ConversationPage;Lcom/larus/im/bean/bot/BotSwitchConfInfo;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/FirstMet;Ljava/util/List;Lcom/larus/im/internal/protocol/model/LikeInfo;Lcom/larus/im/internal/protocol/model/BotCommentInfo;ZILcom/larus/platform/model/RecommendFrom;Lcom/larus/platform/model/SearchMobParam;Z)V", "getBotId", "()Ljava/lang/String;", "setBotId", "(Ljava/lang/String;)V", "getName", "setName", "getBotType", "()Ljava/lang/Integer;", "setBotType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getBotFeatureLabel", "setBotFeatureLabel", "getBotMode", "()I", "setBotMode", "(I)V", "getIconImage", "()Lcom/larus/im/bean/bot/BotIconImage;", "setIconImage", "(Lcom/larus/im/bean/bot/BotIconImage;)V", "getCreateTime", "()J", "setCreateTime", "(J)V", "getUpdateTime", "setUpdateTime", "getRecommendIndex", "setRecommendIndex", "getHasConversation", "()Z", "setHasConversation", "(Z)V", "getConversationId", "setConversationId", "getOnboarding", "()Lcom/larus/bmhome/chat/bean/BotOnBoarding;", "getBotAction", "()Lcom/larus/bmhome/chat/bean/BotAction;", "setBotAction", "(Lcom/larus/bmhome/chat/bean/BotAction;)V", "getBotCreatorInfo", "()Lcom/larus/im/bean/bot/BotCreatorInfo;", "setBotCreatorInfo", "(Lcom/larus/im/bean/bot/BotCreatorInfo;)V", "getBotStatus", "()Lcom/larus/im/bean/bot/BotStatistic;", "setBotStatus", "(Lcom/larus/im/bean/bot/BotStatistic;)V", "getMuted", "()Ljava/lang/Boolean;", "setMuted", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getHumanDescription", "setHumanDescription", "getModel", "()Lcom/larus/im/bean/bot/ModelItem;", "setModel", "(Lcom/larus/im/bean/bot/ModelItem;)V", "getVoice", "()Lcom/larus/im/bean/bot/SpeakerVoice;", "setVoice", "(Lcom/larus/im/bean/bot/SpeakerVoice;)V", "getEditPos", "setEditPos", "getShareInfo", "()Lcom/larus/im/bean/bot/ShareInfo;", "setShareInfo", "(Lcom/larus/im/bean/bot/ShareInfo;)V", "getPrivateStatus", "setPrivateStatus", "getDisabled", "setDisabled", "getDisabledTag", "setDisabledTag", "getBio", "setBio", "getBotConf", "()Ljava/util/List;", "setBotConf", "(Ljava/util/List;)V", "getBgImgUrl", "setBgImgUrl", "getBgImgColor", "setBgImgColor", "getBgVideoModel", "setBgVideoModel", "getBgImgUri", "setBgImgUri", "getBgImgInfo", "()Lcom/larus/im/bean/bot/BgImageInfo;", "setBgImgInfo", "(Lcom/larus/im/bean/bot/BgImageInfo;)V", "getConversationPage", "()Lcom/larus/im/bean/bot/ConversationPage;", "setConversationPage", "(Lcom/larus/im/bean/bot/ConversationPage;)V", "getSwitchConfInfo", "()Lcom/larus/im/bean/bot/BotSwitchConfInfo;", "setSwitchConfInfo", "(Lcom/larus/im/bean/bot/BotSwitchConfInfo;)V", "getContentDistType", "setContentDistType", "getCallerName", "setCallerName", "getCallerNameSetting", "setCallerNameSetting", "getFirstMet", "()Lcom/larus/im/bean/bot/FirstMet;", "setFirstMet", "(Lcom/larus/im/bean/bot/FirstMet;)V", "getTagList", "setTagList", "getLikeInfo", "()Lcom/larus/im/internal/protocol/model/LikeInfo;", "setLikeInfo", "(Lcom/larus/im/internal/protocol/model/LikeInfo;)V", "getCommentInfo", "()Lcom/larus/im/internal/protocol/model/BotCommentInfo;", "setCommentInfo", "(Lcom/larus/im/internal/protocol/model/BotCommentInfo;)V", "setPlaceHolder", "getLoadMoreStatus", "setLoadMoreStatus", "getFrom", "()Lcom/larus/platform/model/RecommendFrom;", "setFrom", "(Lcom/larus/platform/model/RecommendFrom;)V", "getSearchMobParam", "()Lcom/larus/platform/model/SearchMobParam;", "setSearchMobParam", "(Lcom/larus/platform/model/SearchMobParam;)V", "setFromCache", "chatService", "Lcom/larus/platform/api/IChatService;", "getChatService", "()Lcom/larus/platform/api/IChatService;", "isAdded", "isChatOnly", "bgImgOpen", "getBgImgOpen", "language", "uniqueIdInType", "getContentFlag", "toRecommendMobInfo", "Lcom/larus/bmhome/chat/bean/BotRecommendMobInfo;", "tabId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ILcom/larus/im/bean/bot/BotIconImage;JJJZLjava/lang/String;Lcom/larus/bmhome/chat/bean/BotOnBoarding;Lcom/larus/bmhome/chat/bean/BotAction;Lcom/larus/im/bean/bot/BotCreatorInfo;Lcom/larus/im/bean/bot/BotStatistic;Ljava/lang/Boolean;Ljava/lang/String;Lcom/larus/im/bean/bot/ModelItem;Lcom/larus/im/bean/bot/SpeakerVoice;Ljava/lang/String;Lcom/larus/im/bean/bot/ShareInfo;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BgImageInfo;Lcom/larus/im/bean/bot/ConversationPage;Lcom/larus/im/bean/bot/BotSwitchConfInfo;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/FirstMet;Ljava/util/List;Lcom/larus/im/internal/protocol/model/LikeInfo;Lcom/larus/im/internal/protocol/model/BotCommentInfo;ZILcom/larus/platform/model/RecommendFrom;Lcom/larus/platform/model/SearchMobParam;Z)Lcom/larus/bmhome/chat/bean/RecommendBot;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecommendBot implements Parcelable {
    public static final Parcelable.Creator<RecommendBot> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient RecommendFrom f297431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient SearchMobParam f297432b;

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
    private String bio;

    @SerializedName("action")
    private BotAction botAction;

    @SerializedName("bot_conf")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<BotConfItem> botConf;

    @SerializedName("creator_info")
    private BotCreatorInfo botCreatorInfo;

    @SerializedName("bot_feature_label")
    private String botFeatureLabel;

    @SerializedName("bot_id")
    private String botId;

    @SerializedName("bot_mode")
    private int botMode;

    @SerializedName("bot_stats")
    private BotStatistic botStatus;

    @SerializedName("bot_type")
    private Integer botType;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient boolean f297433c;

    @SerializedName(Constant.KEY_CALL_NAME)
    private String callerName;

    @SerializedName("caller_name_setting")
    private Boolean callerNameSetting;

    @SerializedName("comment_info")
    private BotCommentInfo commentInfo;

    @SerializedName("content_dist_type")
    private Integer contentDistType;

    @SerializedName("conversation_id")
    private String conversationId;

    @SerializedName(CommentPublishScene.CONVERSATION_PAGE)
    private ConversationPage conversationPage;

    @SerializedName("create_time")
    private long createTime;

    @SerializedName("disabled")
    private boolean disabled;

    @SerializedName("disabled_tag")
    private String disabledTag;

    @SerializedName("edit_pos")
    private String editPos;

    @SerializedName("first_met")
    private FirstMet firstMet;

    @SerializedName("has_conversation")
    private boolean hasConversation;

    @SerializedName("description_for_human")
    private String humanDescription;

    @SerializedName("icon_image")
    private BotIconImage iconImage;

    @Expose(deserialize = false, serialize = false)
    private boolean isPlaceHolder;

    @SerializedName("like_info")
    private LikeInfo likeInfo;

    @Expose(deserialize = false, serialize = false)
    private int loadMoreStatus;

    @SerializedName(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL)
    private ModelItem model;

    @SerializedName("muted")
    private Boolean muted;

    @SerializedName("name")
    private String name;

    @SerializedName("onboarding")
    private final BotOnBoarding onboarding;

    @SerializedName("private_status")
    private Integer privateStatus;

    @SerializedName("recommend_index")
    private long recommendIndex;

    @SerializedName("share_info")
    private ShareInfo shareInfo;

    @SerializedName("switch_conf")
    private BotSwitchConfInfo switchConfInfo;

    @SerializedName("show_tag_info_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<ShowTagInfo> tagList;

    @SerializedName("update_time")
    private long updateTime;

    @SerializedName("voice_type")
    private SpeakerVoice voice;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<RecommendBot> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final RecommendBot createFromParcel(Parcel r510) {
            Intrinsics.checkNotNullParameter(r510, "parcel");
            String r100 = r510.readString();
            String r101 = r510.readString();
            if (r510.readInt() != 0) goto L5;
            Integer r102 = null;
        L6:
            String r103 = r510.readString();
            int r104 = r510.readInt();
            BotIconImage r105 = (BotIconImage) r510.readSerializable();
            long r106 = r510.readLong();
            long r110 = r510.readLong();
            long r111 = r510.readLong();
            if (r510.readInt() == 0) goto L9;
            boolean r107 = true;
        L10:
            String r112 = r510.readString();
            if (r510.readInt() != 0) goto L13;
            BotOnBoarding r108 = null;
        L14:
            BotOnBoarding r113 = r108;
            if (r510.readInt() != 0) goto L17;
            BotAction r109 = null;
        L18:
            BotAction r210 = r109;
            BotCreatorInfo r211 = (BotCreatorInfo) r510.readSerializable();
            BotStatistic r212 = (BotStatistic) r510.readSerializable();
            if (r510.readInt() != 0) goto L22;
            Boolean r213 = null;
        L26:
            String r214 = r510.readString();
            ModelItem r215 = (ModelItem) r510.readSerializable();
            SpeakerVoice r216 = (SpeakerVoice) r510.readSerializable();
            String r217 = r510.readString();
            ShareInfo r218 = (ShareInfo) r510.readSerializable();
            if (r510.readInt() != 0) goto L29;
            Integer r219 = null;
        L31:
            if (r510.readInt() == 0) goto L33;
            boolean r310 = true;
        L34:
            String r311 = r510.readString();
            String r312 = r510.readString();
            if (r510.readInt() != 0) goto L37;
            ArrayList r114 = null;
        L41:
            String r313 = r510.readString();
            String r314 = r510.readString();
            String r315 = r510.readString();
            String r316 = r510.readString();
            BgImageInfo r317 = (BgImageInfo) r510.readSerializable();
            ConversationPage r410 = (ConversationPage) r510.readSerializable();
            BotSwitchConfInfo r411 = (BotSwitchConfInfo) r510.readSerializable();
            if (r510.readInt() != 0) goto L44;
            Integer r412 = null;
        L45:
            String r413 = r510.readString();
            if (r510.readInt() != 0) goto L49;
            Boolean r414 = null;
        L53:
            FirstMet r415 = (FirstMet) r510.readSerializable();
            if (r510.readInt() != 0) goto L56;
            ArrayList r115 = null;
        L60:
            LikeInfo r416 = (LikeInfo) r510.readSerializable();
            BotCommentInfo r417 = (BotCommentInfo) r510.readSerializable();
            if (r510.readInt() == 0) goto L63;
            boolean r418 = true;
        L64:
            int r511 = r510.readInt();
            RecommendFrom r512 = (RecommendFrom) r510.readParcelable(RecommendBot.class.getClassLoader());
            SearchMobParam r513 = (SearchMobParam) r510.readParcelable(RecommendBot.class.getClassLoader());
            if (r510.readInt() == 0) goto L67;
            boolean r116 = true;
        L69:
            return new RecommendBot(r100, r101, r102, r103, r104, r105, r106, r110, r111, r107, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r114, r313, r314, r315, r316, r317, r410, r411, r412, r413, r414, r415, r115, r416, r417, r418, r511, r512, r513, r116);
        L67:
            r116 = false;
            goto L69
        L63:
            r418 = false;
            goto L64
        L56:
            int r117 = r510.readInt();
            ArrayList r118 = new ArrayList(r117);
            int r119 = 0;
        L57:
            if (r119 == r117) goto L59;
            int r120 = r117;
            r118.add(r510.readSerializable());
            r119 = r119 + 1;
            r117 = r120;
            goto L57
        L59:
            r115 = r118;
            goto L60
        L49:
            if (r510.readInt() == 0) goto L51;
            boolean r121 = true;
        L52:
            r414 = Boolean.valueOf(r121);
            goto L53
        L51:
            r121 = false;
            goto L52
        L44:
            r412 = Integer.valueOf(r510.readInt());
            goto L45
        L37:
            int r122 = r510.readInt();
            ArrayList r123 = new ArrayList(r122);
            int r124 = 0;
        L38:
            if (r124 == r122) goto L40;
            int r318 = r122;
            r123.add(r510.readSerializable());
            r124 = r124 + 1;
            r122 = r318;
            goto L38
        L40:
            r114 = r123;
            goto L41
        L33:
            r310 = false;
            goto L34
        L29:
            r219 = Integer.valueOf(r510.readInt());
            goto L31
        L22:
            if (r510.readInt() == 0) goto L24;
            boolean r125 = true;
        L25:
            r213 = Boolean.valueOf(r125);
            goto L26
        L24:
            r125 = false;
            goto L25
        L17:
            r109 = BotAction.CREATOR.createFromParcel(r510);
            goto L18
        L13:
            r108 = BotOnBoarding.CREATOR.createFromParcel(r510);
            goto L14
        L9:
            r107 = false;
            goto L10
        L5:
            r102 = Integer.valueOf(r510.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final RecommendBot[] newArray(int r100) {
            return new RecommendBot[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    public RecommendBot() {
        this(null, null, null, null, null, 0, 0, 0, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, -1, 8191);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RecommendBot) == true) goto L8;
        return false;
    L8:
        RecommendBot r101 = (RecommendBot) r100;
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.botType, r101.botType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.botFeatureLabel, r101.botFeatureLabel) == true) goto L21;
        return false;
    L21:
        if (this.botMode == r101.botMode) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.iconImage, r101.iconImage) == true) goto L27;
        return false;
    L27:
        if (this.createTime == r101.createTime) goto L30;
        return false;
    L30:
        if (this.updateTime == r101.updateTime) goto L33;
        return false;
    L33:
        if (this.recommendIndex == r101.recommendIndex) goto L36;
        return false;
    L36:
        if (this.hasConversation == r101.hasConversation) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.onboarding, r101.onboarding) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.botAction, r101.botAction) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.botCreatorInfo, r101.botCreatorInfo) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.botStatus, r101.botStatus) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.muted, r101.muted) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.humanDescription, r101.humanDescription) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.model, r101.model) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.voice, r101.voice) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.editPos, r101.editPos) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.shareInfo, r101.shareInfo) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.privateStatus, r101.privateStatus) == true) goto L75;
        return false;
    L75:
        if (this.disabled == r101.disabled) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.disabledTag, r101.disabledTag) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.bio, r101.bio) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.botConf, r101.botConf) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.bgImgUrl, r101.bgImgUrl) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.bgImgColor, r101.bgImgColor) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.bgVideoModel, r101.bgVideoModel) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.bgImgUri, r101.bgImgUri) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.bgImgInfo, r101.bgImgInfo) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.conversationPage, r101.conversationPage) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.switchConfInfo, r101.switchConfInfo) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.contentDistType, r101.contentDistType) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.callerName, r101.callerName) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.callerNameSetting, r101.callerNameSetting) == true) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.firstMet, r101.firstMet) == true) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.tagList, r101.tagList) == true) goto L123;
        return false;
    L123:
        if (Intrinsics.areEqual(this.likeInfo, r101.likeInfo) == true) goto L126;
        return false;
    L126:
        if (Intrinsics.areEqual(this.commentInfo, r101.commentInfo) == true) goto L129;
        return false;
    L129:
        if (this.isPlaceHolder == r101.isPlaceHolder) goto L132;
        return false;
    L132:
        if (this.loadMoreStatus == r101.loadMoreStatus) goto L135;
        return false;
    L135:
        if (Intrinsics.areEqual(this.f297431a, r101.f297431a) == true) goto L138;
        return false;
    L138:
        if (Intrinsics.areEqual(this.f297432b, r101.f297432b) == true) goto L141;
        return false;
    L141:
        if (this.f297433c == r101.f297433c) goto L143;
        return false;
    L143:
        return true;
    }

    public final int hashCode() {
        String r100 = this.botId;
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
        Integer r107 = this.botType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.botFeatureLabel;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((r109 + r111) * 31) + this.botMode) * 31;
        BotIconImage r113 = this.iconImage;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        long r116 = this.createTime;
        int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        long r118 = this.updateTime;
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        long r120 = this.recommendIndex;
        int r121 = (r119 + ((int) (r120 ^ (r120 >>> 32)))) * 31;
        int r122 = 1231;
        if (this.hasConversation == false) goto L25;
        int r123 = 1231;
    L26:
        int r124 = (r121 + r123) * 31;
        String r125 = this.conversationId;
        if (r125 != null) goto L29;
        int r126 = 0;
    L30:
        int r127 = (r124 + r126) * 31;
        BotOnBoarding r128 = this.onboarding;
        if (r128 != null) goto L33;
        int r129 = 0;
    L34:
        int r130 = (r127 + r129) * 31;
        BotAction r131 = this.botAction;
        if (r131 != null) goto L37;
        int r132 = 0;
    L38:
        int r133 = (r130 + r132) * 31;
        BotCreatorInfo r134 = this.botCreatorInfo;
        if (r134 != null) goto L41;
        int r135 = 0;
    L42:
        int r136 = (r133 + r135) * 31;
        BotStatistic r137 = this.botStatus;
        if (r137 != null) goto L45;
        int r138 = 0;
    L46:
        int r139 = (r136 + r138) * 31;
        Boolean r140 = this.muted;
        if (r140 != null) goto L49;
        int r141 = 0;
    L50:
        int r142 = (r139 + r141) * 31;
        String r143 = this.humanDescription;
        if (r143 != null) goto L53;
        int r144 = 0;
    L54:
        int r145 = (r142 + r144) * 31;
        ModelItem r146 = this.model;
        if (r146 != null) goto L57;
        int r147 = 0;
    L58:
        int r148 = (r145 + r147) * 31;
        SpeakerVoice r149 = this.voice;
        if (r149 != null) goto L61;
        int r150 = 0;
    L62:
        int r151 = (r148 + r150) * 31;
        String r152 = this.editPos;
        if (r152 != null) goto L65;
        int r153 = 0;
    L66:
        int r154 = (r151 + r153) * 31;
        ShareInfo r155 = this.shareInfo;
        if (r155 != null) goto L69;
        int r156 = 0;
    L70:
        int r157 = (r154 + r156) * 31;
        Integer r158 = this.privateStatus;
        if (r158 != null) goto L73;
        int r159 = 0;
    L74:
        int r160 = (r157 + r159) * 31;
        if (this.disabled == false) goto L77;
        int r161 = 1231;
    L78:
        int r162 = (r160 + r161) * 31;
        String r163 = this.disabledTag;
        if (r163 != null) goto L81;
        int r164 = 0;
    L82:
        int r165 = (r162 + r164) * 31;
        String r166 = this.bio;
        if (r166 != null) goto L85;
        int r167 = 0;
    L86:
        int r168 = (r165 + r167) * 31;
        List<BotConfItem> r169 = this.botConf;
        if (r169 != null) goto L89;
        int r170 = 0;
    L90:
        int r171 = (r168 + r170) * 31;
        String r172 = this.bgImgUrl;
        if (r172 != null) goto L93;
        int r173 = 0;
    L94:
        int r174 = (r171 + r173) * 31;
        String r175 = this.bgImgColor;
        if (r175 != null) goto L97;
        int r176 = 0;
    L98:
        int r177 = (r174 + r176) * 31;
        String r178 = this.bgVideoModel;
        if (r178 != null) goto L101;
        int r179 = 0;
    L102:
        int r180 = (r177 + r179) * 31;
        String r181 = this.bgImgUri;
        if (r181 != null) goto L105;
        int r182 = 0;
    L106:
        int r183 = (r180 + r182) * 31;
        BgImageInfo r184 = this.bgImgInfo;
        if (r184 != null) goto L109;
        int r185 = 0;
    L110:
        int r186 = (r183 + r185) * 31;
        ConversationPage r187 = this.conversationPage;
        if (r187 != null) goto L113;
        int r188 = 0;
    L114:
        int r189 = (r186 + r188) * 31;
        BotSwitchConfInfo r190 = this.switchConfInfo;
        if (r190 != null) goto L117;
        int r191 = 0;
    L118:
        int r192 = (r189 + r191) * 31;
        Integer r193 = this.contentDistType;
        if (r193 != null) goto L121;
        int r194 = 0;
    L122:
        int r195 = (r192 + r194) * 31;
        String r196 = this.callerName;
        if (r196 != null) goto L125;
        int r197 = 0;
    L126:
        int r198 = (r195 + r197) * 31;
        Boolean r199 = this.callerNameSetting;
        if (r199 != null) goto L129;
        int r200 = 0;
    L130:
        int r201 = (r198 + r200) * 31;
        FirstMet r202 = this.firstMet;
        if (r202 != null) goto L133;
        int r203 = 0;
    L134:
        int r204 = (r201 + r203) * 31;
        List<ShowTagInfo> r205 = this.tagList;
        if (r205 != null) goto L137;
        int r206 = 0;
    L138:
        int r207 = (r204 + r206) * 31;
        LikeInfo r208 = this.likeInfo;
        if (r208 != null) goto L141;
        int r209 = 0;
    L142:
        int r210 = (r207 + r209) * 31;
        BotCommentInfo r211 = this.commentInfo;
        if (r211 != null) goto L145;
        int r212 = 0;
    L146:
        int r213 = (r210 + r212) * 31;
        if (this.isPlaceHolder == false) goto L149;
        int r214 = 1231;
    L150:
        int r215 = (((r213 + r214) * 31) + this.loadMoreStatus) * 31;
        RecommendFrom r216 = this.f297431a;
        if (r216 != null) goto L153;
        int r217 = 0;
    L154:
        int r218 = (r215 + r217) * 31;
        SearchMobParam r219 = this.f297432b;
        if (r219 == null) goto L158;
        r101 = r219.hashCode();
    L158:
        int r220 = (r218 + r101) * 31;
        if (this.f297433c == true) goto L163;
        r122 = 1237;
    L163:
        return r220 + r122;
    L153:
        r217 = r216.hashCode();
        goto L154
    L149:
        r214 = 1237;
        goto L150
    L145:
        r212 = r211.hashCode();
        goto L146
    L141:
        r209 = r208.hashCode();
        goto L142
    L137:
        r206 = r205.hashCode();
        goto L138
    L133:
        r203 = r202.hashCode();
        goto L134
    L129:
        r200 = r199.hashCode();
        goto L130
    L125:
        r197 = r196.hashCode();
        goto L126
    L121:
        r194 = r193.hashCode();
        goto L122
    L117:
        r191 = r190.hashCode();
        goto L118
    L113:
        r188 = r187.hashCode();
        goto L114
    L109:
        r185 = r184.hashCode();
        goto L110
    L105:
        r182 = r181.hashCode();
        goto L106
    L101:
        r179 = r178.hashCode();
        goto L102
    L97:
        r176 = r175.hashCode();
        goto L98
    L93:
        r173 = r172.hashCode();
        goto L94
    L89:
        r170 = r169.hashCode();
        goto L90
    L85:
        r167 = r166.hashCode();
        goto L86
    L81:
        r164 = r163.hashCode();
        goto L82
    L77:
        r161 = 1237;
        goto L78
    L73:
        r159 = r158.hashCode();
        goto L74
    L69:
        r156 = r155.hashCode();
        goto L70
    L65:
        r153 = r152.hashCode();
        goto L66
    L61:
        r150 = r149.hashCode();
        goto L62
    L57:
        r147 = r146.hashCode();
        goto L58
    L53:
        r144 = r143.hashCode();
        goto L54
    L49:
        r141 = r140.hashCode();
        goto L50
    L45:
        r138 = r137.hashCode();
        goto L46
    L41:
        r135 = r134.hashCode();
        goto L42
    L37:
        r132 = r131.hashCode();
        goto L38
    L33:
        r129 = r128.hashCode();
        goto L34
    L29:
        r126 = r125.hashCode();
        goto L30
    L25:
        r123 = 1237;
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
        return "RecommendBot(botId=" + this.botId + ", name=" + this.name + ", botType=" + this.botType + ", botFeatureLabel=" + this.botFeatureLabel + ", botMode=" + this.botMode + ", iconImage=" + this.iconImage + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", recommendIndex=" + this.recommendIndex + ", hasConversation=" + this.hasConversation + ", conversationId=" + this.conversationId + ", onboarding=" + this.onboarding + ", botAction=" + this.botAction + ", botCreatorInfo=" + this.botCreatorInfo + ", botStatus=" + this.botStatus + ", muted=" + this.muted + ", humanDescription=" + this.humanDescription + ", model=" + this.model + ", voice=" + this.voice + ", editPos=" + this.editPos + ", shareInfo=" + this.shareInfo + ", privateStatus=" + this.privateStatus + ", disabled=" + this.disabled + ", disabledTag=" + this.disabledTag + ", bio=" + this.bio + ", botConf=" + this.botConf + ", bgImgUrl=" + this.bgImgUrl + ", bgImgColor=" + this.bgImgColor + ", bgVideoModel=" + this.bgVideoModel + ", bgImgUri=" + this.bgImgUri + ", bgImgInfo=" + this.bgImgInfo + ", conversationPage=" + this.conversationPage + ", switchConfInfo=" + this.switchConfInfo + ", contentDistType=" + this.contentDistType + ", callerName=" + this.callerName + ", callerNameSetting=" + this.callerNameSetting + ", firstMet=" + this.firstMet + ", tagList=" + this.tagList + ", likeInfo=" + this.likeInfo + ", commentInfo=" + this.commentInfo + ", isPlaceHolder=" + this.isPlaceHolder + ", loadMoreStatus=" + this.loadMoreStatus + ", from=" + this.f297431a + ", searchMobParam=" + this.f297432b + ", isFromCache=" + this.f297433c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.botId);
        r100.writeString(this.name);
        Integer r102 = this.botType;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeString(this.botFeatureLabel);
        r100.writeInt(this.botMode);
        r100.writeSerializable(this.iconImage);
        r100.writeLong(this.createTime);
        r100.writeLong(this.updateTime);
        r100.writeLong(this.recommendIndex);
        r100.writeInt(this.hasConversation ? 1 : 0);
        r100.writeString(this.conversationId);
        BotOnBoarding r103 = this.onboarding;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        BotAction r104 = this.botAction;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        r100.writeSerializable(this.botCreatorInfo);
        r100.writeSerializable(this.botStatus);
        Boolean r105 = this.muted;
        if (r105 != null) goto L17;
        r100.writeInt(0);
    L18:
        r100.writeString(this.humanDescription);
        r100.writeSerializable(this.model);
        r100.writeSerializable(this.voice);
        r100.writeString(this.editPos);
        r100.writeSerializable(this.shareInfo);
        Integer r106 = this.privateStatus;
        if (r106 != null) goto L21;
        r100.writeInt(0);
    L22:
        r100.writeInt(this.disabled ? 1 : 0);
        r100.writeString(this.disabledTag);
        r100.writeString(this.bio);
        List<BotConfItem> r107 = this.botConf;
        if (r107 != null) goto L25;
        r100.writeInt(0);
    L29:
        r100.writeString(this.bgImgUrl);
        r100.writeString(this.bgImgColor);
        r100.writeString(this.bgVideoModel);
        r100.writeString(this.bgImgUri);
        r100.writeSerializable(this.bgImgInfo);
        r100.writeSerializable(this.conversationPage);
        r100.writeSerializable(this.switchConfInfo);
        Integer r108 = this.contentDistType;
        if (r108 != null) goto L32;
        r100.writeInt(0);
    L33:
        r100.writeString(this.callerName);
        Boolean r109 = this.callerNameSetting;
        if (r109 != null) goto L36;
        r100.writeInt(0);
    L37:
        r100.writeSerializable(this.firstMet);
        List<ShowTagInfo> r110 = this.tagList;
        if (r110 != null) goto L40;
        r100.writeInt(0);
    L44:
        r100.writeSerializable(this.likeInfo);
        r100.writeSerializable(this.commentInfo);
        r100.writeInt(this.isPlaceHolder ? 1 : 0);
        r100.writeInt(this.loadMoreStatus);
        r100.writeParcelable(this.f297431a, r101);
        r100.writeParcelable(this.f297432b, r101);
        r100.writeInt(this.f297433c ? 1 : 0);
        return;
    L40:
        r100.writeInt(1);
        r100.writeInt(r110.size());
        Iterator<ShowTagInfo> r111 = r110.iterator();
    L42:
        if (r111.hasNext() == false) goto L44;
        r100.writeSerializable(r111.next());
        goto L42
    L36:
        r100.writeInt(1);
        r100.writeInt(r109.booleanValue() ? 1 : 0);
        goto L37
    L32:
        r100.writeInt(1);
        r100.writeInt(r108.intValue());
        goto L33
    L25:
        r100.writeInt(1);
        r100.writeInt(r107.size());
        Iterator<BotConfItem> r112 = r107.iterator();
    L27:
        if (r112.hasNext() == false) goto L29;
        r100.writeSerializable(r112.next());
        goto L27
    L21:
        r100.writeInt(1);
        r100.writeInt(r106.intValue());
        goto L22
    L17:
        r100.writeInt(1);
        r100.writeInt(r105.booleanValue() ? 1 : 0);
        goto L18
    L13:
        r100.writeInt(1);
        r104.writeToParcel(r100, r101);
        goto L14
    L9:
        r100.writeInt(1);
        r103.writeToParcel(r100, r101);
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.intValue());
        goto L6
    }

    public final boolean c() {
        BgImageInfo r100 = this.bgImgInfo;
        if (r100 == null) goto L7;
        Boolean r101 = r100.getBgImgOpen();
        if (r101 == null) goto L7;
        return r101.booleanValue();
    L7:
        return true;
    }

    public final boolean j0() {
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L5;
        r100.P();
        ChatServiceImpl r101 = ChatServiceImpl.f346124a;
    L6:
        if (r101 == null) goto L13;
        String r102 = this.botId;
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        Boolean r103 = r101.e(r102);
        if (r103 == null) goto L13;
        return r103.booleanValue();
    L13:
        BotAction r104 = this.botAction;
        if (r104 == null) goto L21;
        Integer r105 = r104.a();
        if (r105 == null) goto L21;
        if (r105.intValue() != 2) goto L21;
        return true;
    L21:
        return false;
    L5:
        r101 = null;
        goto L6
    }

    public final boolean o0() {
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L5;
        r100.P();
        ChatServiceImpl r101 = ChatServiceImpl.f346124a;
    L6:
        if (r101 == null) goto L13;
        String r102 = this.botId;
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        Boolean r103 = r101.h(r102);
        if (r103 == null) goto L13;
        return r103.booleanValue();
    L13:
        return false;
    L5:
        r101 = null;
        goto L6
    }

    public final Integer D() {
        return this.contentDistType;
    }

    public final String E() {
        return this.conversationId;
    }

    public final ConversationPage F() {
        return this.conversationPage;
    }

    public final long I() {
        return this.createTime;
    }

    public final boolean J() {
        return this.disabled;
    }

    public final String K() {
        return this.disabledTag;
    }

    public final String L() {
        return this.editPos;
    }

    public final boolean M() {
        return this.hasConversation;
    }

    public final String N() {
        return this.humanDescription;
    }

    public final BotIconImage O() {
        return this.iconImage;
    }

    public final LikeInfo R() {
        return this.likeInfo;
    }

    public final int S() {
        return this.loadMoreStatus;
    }

    public final ModelItem U() {
        return this.model;
    }

    public final Boolean W() {
        return this.muted;
    }

    public final BotOnBoarding Y() {
        return this.onboarding;
    }

    public final Integer Z() {
        return this.privateStatus;
    }

    public final String a() {
        return this.bgImgColor;
    }

    public final long a0() {
        return this.recommendIndex;
    }

    public final BgImageInfo b() {
        return this.bgImgInfo;
    }

    public final ShareInfo b0() {
        return this.shareInfo;
    }

    public final List<ShowTagInfo> c0() {
        return this.tagList;
    }

    public final String d() {
        return this.bgImgUri;
    }

    public final String e() {
        return this.bgImgUrl;
    }

    public final long f0() {
        return this.updateTime;
    }

    public final String g() {
        return this.bgVideoModel;
    }

    public final String getName() {
        return this.name;
    }

    public final String h() {
        return this.bio;
    }

    public final List<BotConfItem> i() {
        return this.botConf;
    }

    public final SpeakerVoice i0() {
        return this.voice;
    }

    public final BotCreatorInfo j() {
        return this.botCreatorInfo;
    }

    public final String k() {
        return this.botFeatureLabel;
    }

    public final String o() {
        return this.botId;
    }

    public final boolean p0() {
        return this.isPlaceHolder;
    }

    public final BotStatistic q() {
        return this.botStatus;
    }

    public final Integer r() {
        return this.botType;
    }

    public final String s() {
        return this.callerName;
    }

    public final Boolean t() {
        return this.callerNameSetting;
    }

    public final BotCommentInfo z() {
        return this.commentInfo;
    }

    public final void C0(String r100) {
        this.bgImgUrl = r100;
    }

    public final void F0(BotAction r100) {
        this.botAction = r100;
    }

    public final void G0(String r100) {
        this.conversationId = r100;
    }

    public final void H0(int r100) {
        this.loadMoreStatus = r100;
    }

    public final BotRecommendMobInfo I0(String r110) {
        Intrinsics.checkNotNullParameter(r110, "tabId");
        List<ShowTagInfo> r100 = this.tagList;
        if (r100 != null) goto L5;
        r100 = CollectionsKt.emptyList();
    L5:
        List<ShowTagInfo> r101 = r100;
        Iterator<T> r102 = r101.iterator();
    L6:
        String r103 = null;
        if (r102.hasNext() == false) goto L11;
        Object r104 = r102.next();
        ShowTagInfo.Companion.getClass();
        if (ShowTagInfo.access$getCertificationLabels$cp().contains(Integer.valueOf(((ShowTagInfo) r104).getType())) == false) goto L6;
    L12:
        ShowTagInfo r105 = (ShowTagInfo) r104;
        if (r105 == null) goto L25;
        int r106 = r105.getType();
        if (r106 != 1) goto L17;
        String r107 = "selected";
    L24:
        r103 = r107;
        goto L25
    L17:
        if (r106 != 2) goto L19;
        r107 = "corporate";
        goto L24
    L19:
        if (r106 != 3) goto L25;
        r107 = "official";
    L25:
        String r108 = r103;
        int r109 = 0;
        if ((r101 instanceof Collection) == true) goto L28;
    L30:
        Iterator<T> r111 = r101.iterator();
    L32:
        if (r111.hasNext() == false) goto L38;
        ShowTagInfo r112 = (ShowTagInfo) r111.next();
        ShowTagInfo.Companion.getClass();
        if (ShowTagInfo.access$getCapabilityLabels$cp().contains(Integer.valueOf(r112.getType())) == false) goto L32;
        r109 = r109 + 1;
        if (r109 >= 0) goto L32;
        CollectionsKt.throwCountOverflow();
    L38:
        Iterator<T> r113 = r101.iterator();
        String r114 = "";
    L40:
        if (r113.hasNext() == false) goto L42;
        r114 = r114 + ((ShowTagInfo) r113.next()).getTagId() + ',';
        goto L40
    L42:
        String r115 = StringsKt.removeSuffix(r114, ",");
        String r116 = this.botId;
        if (r108 == null) goto L45;
        String r117 = "1";
    L46:
        if (r109 == 0) goto L48;
        String r118 = "1";
    L50:
        return new BotRecommendMobInfo(r116, r117, r108, r115, r118, String.valueOf(r109), r110);
    L48:
        r118 = "0";
        goto L50
    L45:
        r117 = "0";
        goto L46
    L28:
        if (r101.isEmpty() == false) goto L30;
    L11:
        r104 = null;
        goto L12
    }

    public final void v0(String r100) {
        this.bgImgColor = r100;
    }

    public final void w0(BgImageInfo r100) {
        this.bgImgInfo = r100;
    }

    public final void y0(String r100) {
        this.bgImgUri = r100;
    }

    public /* synthetic */ RecommendBot(String r510, String r511, Integer r512, String r513, BotIconImage r514, long r515, long r610, long r611, boolean r612, String r613, BotOnBoarding r614, BotCreatorInfo r615, BotStatistic r616, Boolean r710, String r711, ModelItem r712, SpeakerVoice r713, String r714, ShareInfo r715, Integer r716, String r717, String r718, List r719, String r810, String r811, String r812, String r813, BgImageInfo r814, ConversationPage r815, String r816, Boolean r817, List r818, LikeInfo r819, BotCommentInfo r910, boolean r911, RecommendFrom r912, int r913, int r914) {
        String r100 = "";
        if ((r913 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r913 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r913 & 4) == 0) goto L13;
        Integer r103 = null;
    L15:
        if ((r913 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r913 & 16) == 0) goto L21;
        int r105 = -1;
    L23:
        if ((r913 & 32) == 0) goto L25;
        BotIconImage r110 = null;
    L27:
        if ((r913 & 64) == 0) goto L29;
        long r111 = 0;
    L31:
        if ((r913 & 128) == 0) goto L33;
        long r112 = 0;
    L35:
        if ((r913 & 256) == 0) goto L37;
        long r113 = 0;
    L39:
        if ((r913 & 512) == 0) goto L41;
        boolean r210 = false;
    L43:
        if ((r913 & 1024) == 0) goto L45;
        String r211 = "";
    L47:
        if ((r913 & 2048) == 0) goto L49;
        BotOnBoarding r212 = null;
    L51:
        if ((r913 & 8192) == 0) goto L53;
        BotCreatorInfo r213 = null;
    L55:
        if ((r913 & 16384) == 0) goto L57;
        BotStatistic r214 = null;
    L59:
        if ((32768 & r913) == 0) goto L61;
        Boolean r215 = Boolean.FALSE;
    L63:
        if ((65536 & r913) == 0) goto L65;
        String r216 = "";
    L67:
        if ((131072 & r913) == 0) goto L69;
        ModelItem r217 = null;
    L71:
        if ((262144 & r913) == 0) goto L73;
        SpeakerVoice r218 = null;
    L75:
        if ((524288 & r913) == 0) goto L77;
        String r310 = "";
    L79:
        if ((1048576 & r913) == 0) goto L81;
        ShareInfo r311 = null;
    L83:
        if ((2097152 & r913) == 0) goto L85;
        Integer r312 = null;
    L87:
        if ((8388608 & r913) == 0) goto L89;
        String r313 = "";
    L91:
        if ((16777216 & r913) != 0) goto L95;
        r100 = r718;
    L95:
        if ((33554432 & r913) == 0) goto L97;
        List r314 = null;
    L99:
        if ((67108864 & r913) == 0) goto L101;
        String r315 = null;
    L103:
        if ((134217728 & r913) == 0) goto L105;
        String r316 = null;
    L107:
        if ((268435456 & r913) == 0) goto L109;
        String r317 = null;
    L111:
        if ((536870912 & r913) == 0) goto L113;
        String r318 = null;
    L115:
        if ((1073741824 & r913) == 0) goto L117;
        BgImageInfo r410 = null;
    L119:
        if ((r913 & Integer.MIN_VALUE) == 0) goto L121;
        ConversationPage r106 = null;
    L123:
        if ((r914 & 2) == 0) goto L125;
        Integer r411 = 0;
    L127:
        if ((r914 & 4) == 0) goto L129;
        String r412 = null;
    L131:
        if ((r914 & 8) == 0) goto L133;
        Boolean r413 = Boolean.FALSE;
    L135:
        if ((r914 & 32) == 0) goto L137;
        List r414 = null;
    L139:
        if ((r914 & 64) == 0) goto L141;
        LikeInfo r415 = null;
    L143:
        if ((r914 & 128) == 0) goto L145;
        BotCommentInfo r416 = null;
    L147:
        if ((r914 & 256) == 0) goto L149;
        boolean r417 = false;
    L151:
        if ((r914 & 1024) == 0) goto L153;
        RecommendFrom r107 = null;
    L154:
        this(r101, r102, r103, r104, r105, r110, r111, r112, r113, r210, r211, r212, null, r213, r214, r215, r216, r217, r218, r310, r311, r312, false, r313, r100, r314, r315, r316, r317, r318, r410, r106, null, r411, r412, r413, null, r414, r415, r416, r417, 0, r107, null, false);
        return;
    L153:
        r107 = r912;
        goto L154
    L149:
        r417 = r911;
        goto L151
    L145:
        r416 = r910;
        goto L147
    L141:
        r415 = r819;
        goto L143
    L137:
        r414 = r818;
        goto L139
    L133:
        r413 = r817;
        goto L135
    L129:
        r412 = r816;
        goto L131
    L125:
        r411 = null;
        goto L127
    L121:
        r106 = r815;
        goto L123
    L117:
        r410 = r814;
        goto L119
    L113:
        r318 = r813;
        goto L115
    L109:
        r317 = r812;
        goto L111
    L105:
        r316 = r811;
        goto L107
    L101:
        r315 = r810;
        goto L103
    L97:
        r314 = r719;
        goto L99
    L89:
        r313 = r717;
        goto L91
    L85:
        r312 = r716;
        goto L87
    L81:
        r311 = r715;
        goto L83
    L77:
        r310 = r714;
        goto L79
    L73:
        r218 = r713;
        goto L75
    L69:
        r217 = r712;
        goto L71
    L65:
        r216 = r711;
        goto L67
    L61:
        r215 = r710;
        goto L63
    L57:
        r214 = r616;
        goto L59
    L53:
        r213 = r615;
        goto L55
    L49:
        r212 = r614;
        goto L51
    L45:
        r211 = r613;
        goto L47
    L41:
        r210 = r612;
        goto L43
    L37:
        r113 = r611;
        goto L39
    L33:
        r112 = r610;
        goto L35
    L29:
        r111 = r515;
        goto L31
    L25:
        r110 = r514;
        goto L27
    L21:
        r105 = 0;
        goto L23
    L17:
        r104 = r513;
        goto L19
    L13:
        r103 = r512;
        goto L15
    L9:
        r102 = r511;
        goto L11
    L5:
        r101 = r510;
        goto L7
    }

    public RecommendBot(String r100, String r101, Integer r102, String r103, int r104, BotIconImage r105, long r110, long r111, long r112, boolean r113, String r114, BotOnBoarding r115, BotAction r116, BotCreatorInfo r210, BotStatistic r211, Boolean r212, String r213, ModelItem r214, SpeakerVoice r215, String r216, ShareInfo r217, Integer r218, boolean r219, String r310, String r311, List<BotConfItem> r312, String r313, String r314, String r315, String r316, BgImageInfo r317, ConversationPage r318, BotSwitchConfInfo r319, Integer r410, String r411, Boolean r412, FirstMet r413, List<ShowTagInfo> r414, LikeInfo r415, BotCommentInfo r416, boolean r417, int r418, RecommendFrom r419, SearchMobParam r510, boolean r511) {
        this.botId = r100;
        this.name = r101;
        this.botType = r102;
        this.botFeatureLabel = r103;
        this.botMode = r104;
        this.iconImage = r105;
        this.createTime = r110;
        this.updateTime = r111;
        this.recommendIndex = r112;
        this.hasConversation = r113;
        this.conversationId = r114;
        this.onboarding = r115;
        this.botAction = r116;
        this.botCreatorInfo = r210;
        this.botStatus = r211;
        this.muted = r212;
        this.humanDescription = r213;
        this.model = r214;
        this.voice = r215;
        this.editPos = r216;
        this.shareInfo = r217;
        this.privateStatus = r218;
        this.disabled = r219;
        this.disabledTag = r310;
        this.bio = r311;
        this.botConf = r312;
        this.bgImgUrl = r313;
        this.bgImgColor = r314;
        this.bgVideoModel = r315;
        this.bgImgUri = r316;
        this.bgImgInfo = r317;
        this.conversationPage = r318;
        this.switchConfInfo = r319;
        this.contentDistType = r410;
        this.callerName = r411;
        this.callerNameSetting = r412;
        this.firstMet = r413;
        this.tagList = r414;
        this.likeInfo = r415;
        this.commentInfo = r416;
        this.isPlaceHolder = r417;
        this.loadMoreStatus = r418;
        this.f297431a = r419;
        this.f297432b = r510;
        this.f297433c = r511;
    }
}
