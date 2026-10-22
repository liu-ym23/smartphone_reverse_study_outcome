package com.larus.bmhome;

import android.animation.ArgbEvaluator;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.router.SmartRouter;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.audio.ttsV2.TtsGuideDelegate;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.FeedbackMeta;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.bot.CommonSettingFragment;
import com.larus.bmhome.bot.dialog.BotAvatarViewerDialog;
import com.larus.bmhome.chat.MarkdownResolver;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.bean.PageType;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.ext.ChatFragmentDelegateDialogExtKt;
import com.larus.bmhome.chat.layout.holder.helper.LongClickSource;
import com.larus.bmhome.chat.layout.holder.helper.PopMenuPanelTrigger;
import com.larus.bmhome.chat.layout.holder.helper.ServiceBotCardHelper;
import com.larus.bmhome.chat.layout.holder.helper.q1;
import com.larus.bmhome.chat.layout.holder.helper.s1;
import com.larus.bmhome.chat.layout.holder.helper.t0;
import com.larus.bmhome.chat.layout.holder.helper.u2;
import com.larus.bmhome.chat.layout.holder.helper.v0;
import com.larus.bmhome.chat.layout.holder.helper.w0;
import com.larus.bmhome.chat.layout.holder.helper.x2;
import com.larus.bmhome.chat.layout.holder.menu.item.d1;
import com.larus.bmhome.chat.layout.holder.progressloading.LoadingType;
import com.larus.bmhome.chat.list.cell.music.MusicCell;
import com.larus.bmhome.chat.manager.ExpertSwitchManager;
import com.larus.bmhome.chat.manager.Gpt4SwitchManager;
import com.larus.bmhome.chat.manager.PromptCacheManager;
import com.larus.bmhome.chat.model.repo.ChatSender;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.model.strategy.AnswerAnchorTopStrategy;
import com.larus.bmhome.chat.model.strategy.ChatSendUtils;
import com.larus.bmhome.chat.require.IMainBotService;
import com.larus.bmhome.chat.require.MainBotServiceDelegate;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.chat.trace.appreciable.ChatMessageCostTrace;
import com.larus.bmhome.chat.trace.appreciable.CommonParamManager;
import com.larus.bmhome.chat.z4;
import com.larus.bmhome.tipoff.BaseTipOffDialog;
import com.larus.bmhome.tipoff.TipOffDialogFragment;
import com.larus.bmhome.tipoff.TipOffDialogParams;
import com.larus.bmhome.utils.c4;
import com.larus.bmhome.utils.w2;
import com.larus.bmhome.utils.x3;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.common.apphost.AppHost;
import com.larus.feedback.api.FlowFeedbackServiceDelegate;
import com.larus.feedback.api.model.FlowDislikePanelConfig;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.BizMergeForwardBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.mainbot.api.IFlowMainBot;
import com.larus.media.MediaResourceManager;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.TplType;
import com.larus.platform.model.EditPos;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.m3;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatService;
import com.larus.platform.spi.MarkdownDataHandlersProvider;
import com.larus.utils.SafeExtKt;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.IVoiceCallService;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import p2a.r;
import v19.c7;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0096\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0004à\u0001ã\u0001\b\u0007\u0018\u0000 ¶\u00022\u00020\u0001:\u0002¶\u0002B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J*\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0016J\u001e\u0010\u0012\u001a\u00020\t2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J@\u0010\u001a\u001a\u00020\u00162\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\u0016H\u0016J4\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u00052\u0006\u0010 \u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u0005H\u0016J8\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u00052\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010/H\u0016J\b\u00100\u001a\u00020\u0016H\u0016J\b\u00101\u001a\u00020\u0016H\u0016J\b\u00102\u001a\u00020\u0010H\u0016J&\u00103\u001a\u00020\u00162\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u00010\u0005H\u0016J&\u00109\u001a\u00020\u00162\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u00010\u0005H\u0016JT\u0010:\u001a\u0004\u0018\u00010;2\u0006\u00104\u001a\u0002052\u0006\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u00162\u0006\u0010>\u001a\u00020\u00162\b\u0010?\u001a\u0004\u0018\u00010\u00052\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010/2\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010/H\u0016J \u0010B\u001a\u00020\u00102\u0006\u0010C\u001a\u00020\u00102\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020EH\u0016J\b\u0010G\u001a\u00020HH\u0016J\b\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020LH\u0016J\b\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020PH\u0016J\b\u0010Q\u001a\u00020RH\u0016J\u0010\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0016J6\u0010W\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010X\u001a\u0004\u0018\u00010Y2\b\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010\\\u001a\u00020\u00162\u0006\u0010]\u001a\u00020\u0016H\u0016J@\u0010^\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010X\u001a\u0004\u0018\u00010Y2\b\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010\\\u001a\u00020\u00162\b\u0010_\u001a\u0004\u0018\u00010`2\u0006\u0010]\u001a\u00020\u0016H\u0016J\u0014\u0010a\u001a\u0004\u0018\u00010\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J \u0010b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010c2\b\u0010d\u001a\u0004\u0018\u00010\u0007H\u0096@¢\u0006\u0002\u0010eJ\u0010\u0010f\u001a\u00020\t2\u0006\u0010g\u001a\u00020\u0005H\u0016J\b\u0010h\u001a\u00020\tH\u0016J\b\u0010i\u001a\u00020\tH\u0016J\u0013\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00050kH\u0016¢\u0006\u0002\u0010lJ\u000e\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00050cH\u0016J\u0010\u0010n\u001a\u00020\t2\u0006\u0010o\u001a\u00020\u0005H\u0016J\u0019\u0010p\u001a\u0004\u0018\u00010\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010qJ\u0014\u0010r\u001a\u0004\u0018\u00010s2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J)\u0010t\u001a\u00020\u00052\b\u0010u\u001a\u0004\u0018\u00010\u00102\b\u0010v\u001a\u0004\u0018\u00010\u00102\u0006\u0010w\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010xJL\u0010y\u001a\u00020\u00162\u0006\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u00020}2\u0006\u0010~\u001a\u00020\u007f2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0005H\u0016J~\u0010\u0086\u0001\u001a\u00020\t2\u0006\u0010(\u001a\u00020)2\u0007\u0010\u0087\u0001\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0007\u0010\u0088\u0001\u001a\u00020\u00102\u0007\u0010\u0089\u0001\u001a\u00020\u00052\r\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050c29\u0010\u008b\u0001\u001a4\u0012)\u0012'\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u008d\u00010c¢\u0006\u000f\b\u008e\u0001\u0012\n\b\u008f\u0001\u0012\u0005\b\b(\u0090\u0001\u0012\u0004\u0012\u00020\t0\u008c\u0001H\u0016J\u0010\u0010\u0091\u0001\u001a\t\u0012\u0005\u0012\u00030\u0092\u00010cH\u0016J\n\u0010\u0093\u0001\u001a\u00030\u0094\u0001H\u0016J\n\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0016J\f\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0098\u0001H\u0016J \u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009b\u00012\u0007\u0010\u009d\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u009e\u0001\u001a\u00020EH\u0002J\u001d\u0010\u009f\u0001\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0016J\u0013\u0010 \u0001\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0016J\u001d\u0010¡\u0001\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0016J\u001b\u0010¢\u0001\u001a\u00020\t2\b\u0010£\u0001\u001a\u00030¤\u00012\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J,\u0010¥\u0001\u001a\u00020\t2\b\u0010£\u0001\u001a\u00030¤\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\t\u0010¦\u0001\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0003\u0010§\u0001J\u001f\u0010¨\u0001\u001a\u00020\t2\b\u0010©\u0001\u001a\u00030¤\u00012\n\u0010ª\u0001\u001a\u0005\u0018\u00010«\u0001H\u0016J\u0014\u0010¬\u0001\u001a\u0005\u0018\u00010\u00ad\u00012\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\t\u0010®\u0001\u001a\u00020\tH\u0016J\u0080\u0001\u0010¯\u0001\u001a\u00020\t2\b\u0010£\u0001\u001a\u00030¤\u00012\u0007\u0010°\u0001\u001a\u00020\u001e2\n\u0010\u0083\u0001\u001a\u0005\u0018\u00010±\u00012\t\u0010²\u0001\u001a\u0004\u0018\u00010\u00052\u0007\u0010³\u0001\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u00052\u0007\u0010´\u0001\u001a\u00020\u00052\t\u0010µ\u0001\u001a\u0004\u0018\u00010\u00052\n\u0010¶\u0001\u001a\u0005\u0018\u00010·\u00012\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0003\u0010º\u0001J+\u0010»\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00142\u0014\u0010¼\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u008d\u0001H\u0016J\t\u0010½\u0001\u001a\u00020\u0016H\u0016J*\u0010¾\u0001\u001a\u00020\t2\u0007\u0010¿\u0001\u001a\u00020\u00162\u0016\u0010\u0084\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u008c\u0001H\u0016J\u0014\u0010À\u0001\u001a\u00020\t2\t\u0010Á\u0001\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010Â\u0001\u001a\u00020\t2\t\u0010Á\u0001\u001a\u0004\u0018\u00010\u0005H\u0016J\u0011\u0010Ã\u0001\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010Ä\u0001\u001a\u00020\t2\u0007\u0010Å\u0001\u001a\u00020\u001eH\u0016J\u0012\u0010Æ\u0001\u001a\u00020\t2\u0007\u0010°\u0001\u001a\u00020\u001eH\u0016J\u001b\u0010Ç\u0001\u001a\u00020\t2\u0006\u0010(\u001a\u00020)2\b\u0010ª\u0001\u001a\u00030«\u0001H\u0016J\u001b\u0010È\u0001\u001a\u00020\t2\u0006\u0010(\u001a\u00020)2\b\u0010¼\u0001\u001a\u00030É\u0001H\u0016J\u0012\u0010Ê\u0001\u001a\u00020\t2\u0007\u0010°\u0001\u001a\u00020\u001eH\u0016J&\u0010Ë\u0001\u001a\u00020\t2\t\u0010Ì\u0001\u001a\u0004\u0018\u00010\u00052\u0007\u0010Í\u0001\u001a\u00020\u00052\u0007\u0010Î\u0001\u001a\u00020\rH\u0016J4\u0010Ï\u0001\u001a\u0005\u0018\u00010Ð\u00012\r\u0010Ñ\u0001\u001a\b\u0012\u0004\u0012\u00020\u00100c2\u0007\u0010Ò\u0001\u001a\u00020\u00102\u0007\u0010Ó\u0001\u001a\u00020\u0005H\u0096@¢\u0006\u0003\u0010Ô\u0001J\"\u0010Õ\u0001\u001a\u00020\t2\u0007\u0010Ö\u0001\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0016J\u0013\u0010×\u0001\u001a\u00020\t2\b\u0010Ø\u0001\u001a\u00030Ù\u0001H\u0016J\u0013\u0010Ú\u0001\u001a\u00020\t2\b\u0010Ø\u0001\u001a\u00030Ù\u0001H\u0016J/\u0010Û\u0001\u001a\u00020\t2\u0007\u0010°\u0001\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010\u00052\u0007\u0010Ü\u0001\u001a\u00020\u00162\b\u0010d\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010Ý\u0001\u001a\u00020\t2\u0007\u0010Þ\u0001\u001a\u00020\u0016H\u0016J\u0012\u0010å\u0001\u001a\u00020\t2\u0007\u0010æ\u0001\u001a\u00020\u0005H\u0016J9\u0010ç\u0001\u001a\u00020\t2\u0007\u0010è\u0001\u001a\u00020}2\b\u0010é\u0001\u001a\u00030ê\u00012\b\u0010ë\u0001\u001a\u00030ì\u00012\u0007\u0010í\u0001\u001a\u00020\u001e2\b\u0010î\u0001\u001a\u00030ï\u0001H\u0016Jx\u0010ð\u0001\u001a\u00030ñ\u00012\u0007\u0010í\u0001\u001a\u00020\u001e2\n\u0010ò\u0001\u001a\u0005\u0018\u00010ó\u00012\n\u0010ô\u0001\u001a\u0005\u0018\u00010õ\u00012\u0007\u0010ö\u0001\u001a\u00020\u00162\u000f\u0010÷\u0001\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010/2\u000f\u0010ø\u0001\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010/2\u000f\u0010ù\u0001\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010/2\u000f\u0010ú\u0001\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010/H\u0016J\u001c\u0010û\u0001\u001a\u00030ü\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010d\u001a\u0004\u0018\u00010\u0007H\u0016J\r\u0010ý\u0001\u001a\u00020\u0016*\u00020\u001eH\u0002J\u0082\u0001\u0010þ\u0001\u001a\u00030ÿ\u00012\u0007\u0010è\u0001\u001a\u00020}2\b\u0010\u0080\u0002\u001a\u00030\u0081\u00022\b\u0010ò\u0001\u001a\u00030ó\u00012\n\u0010\u0082\u0002\u001a\u0005\u0018\u00010\u0083\u00022\n\u0010\u0084\u0002\u001a\u0005\u0018\u00010ì\u00012\n\u0010ô\u0001\u001a\u0005\u0018\u00010õ\u00012\u0007\u0010í\u0001\u001a\u00020\u001e2\r\u0010\u0085\u0002\u001a\b\u0012\u0004\u0012\u00020\u001e0/2\u0007\u0010µ\u0001\u001a\u00020\u00162\n\u0010\u0086\u0002\u001a\u0005\u0018\u00010\u0087\u00022\b\u0010\u0088\u0002\u001a\u00030\u0089\u0002H\u0016J(\u0010\u008a\u0002\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\t\u0010è\u0001\u001a\u0004\u0018\u00010}2\b\u0010\u0088\u0002\u001a\u00030\u0089\u0002H\u0016J\t\u0010\u008b\u0002\u001a\u00020\u0016H\u0016J\u0013\u0010\u008c\u0002\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J0\u0010\u008d\u0002\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)2\t\u0010è\u0001\u001a\u0004\u0018\u00010}2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0088\u0002\u001a\u00030\u0089\u0002H\u0016JB\u0010\u008e\u0002\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)2\t\u0010è\u0001\u001a\u0004\u0018\u00010}2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u00106\u001a\u0002072\b\u0010\u0088\u0002\u001a\u00030\u0089\u00022\b\u00108\u001a\u0004\u0018\u00010\u0005H\u0016JF\u0010\u008f\u0002\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)2\t\u0010è\u0001\u001a\u0004\u0018\u00010}2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0088\u0002\u001a\u00030\u0089\u00022\b\u00106\u001a\u0004\u0018\u0001072\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0005H\u0002J(\u0010\u0090\u0002\u001a\u00020\t2\t\u0010è\u0001\u001a\u0004\u0018\u00010}2\u0006\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u00106\u001a\u0004\u0018\u000107H\u0002J(\u0010\u0091\u0002\u001a\u00020\t2\t\u0010è\u0001\u001a\u0004\u0018\u00010}2\u0006\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u00106\u001a\u0004\u0018\u000107H\u0002J<\u0010\u0092\u0002\u001a\u00020\t2\t\u0010è\u0001\u001a\u0004\u0018\u00010}2 \u0010\u0093\u0002\u001a\u001b\b\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\t0\u0094\u0002\u0012\u0007\u0012\u0005\u0018\u00010\u0083\u00020\u008c\u0001H\u0002¢\u0006\u0003\u0010\u0095\u0002J:\u0010\u0096\u0002\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0007\u0010\u0097\u0002\u001a\u00020\u00052\u0007\u0010\u0098\u0002\u001a\u00020\u00052\t\u0010è\u0001\u001a\u0004\u0018\u00010}2\n\b\u0002\u00106\u001a\u0004\u0018\u000107H\u0002J\u001c\u0010\u0099\u0002\u001a\u0002072\t\u0010è\u0001\u001a\u0004\u0018\u00010}2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001f\u0010\u009a\u0002\u001a\u00020\u00052\t\u0010è\u0001\u001a\u0004\u0018\u00010}2\t\u0010\u009b\u0002\u001a\u0004\u0018\u000107H\u0002J)\u0010\u009c\u0002\u001a\u00020\u001e2\t\u0010è\u0001\u001a\u0004\u0018\u00010}2\u0006\u0010\u001d\u001a\u00020\u001e2\u000b\b\u0002\u0010\u009d\u0002\u001a\u0004\u0018\u00010\u0005H\u0002J\u0016\u0010\u009e\u0002\u001a\u0004\u0018\u00010\u00052\t\u0010è\u0001\u001a\u0004\u0018\u00010}H\u0002J\u0017\u0010\u009f\u0002\u001a\u0005\u0018\u00010 \u00022\t\u0010è\u0001\u001a\u0004\u0018\u00010}H\u0002J\u0011\u0010¡\u0002\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\n\u0010¢\u0002\u001a\u00030£\u0002H\u0016J\u0014\u0010¤\u0002\u001a\u0005\u0018\u00010¥\u00022\u0006\u0010\u001d\u001a\u00020\u001eH\u0016JB\u0010¦\u0002\u001a\u00030§\u00022\u001f\u0010¨\u0002\u001a\u001a\u0012\u0005\u0012\u00030ª\u0002\u0018\u00010©\u0002j\f\u0012\u0005\u0012\u00030ª\u0002\u0018\u0001`«\u00022\t\u0010¬\u0002\u001a\u0004\u0018\u00010\u00052\n\u0010\u00ad\u0002\u001a\u0005\u0018\u00010«\u0001H\u0016J\t\u0010®\u0002\u001a\u00020}H\u0016J\n\u0010¯\u0002\u001a\u00030°\u0002H\u0016J'\u0010±\u0002\u001a\u00020\t2\b\u0010©\u0001\u001a\u00030¤\u00012\b\u0010²\u0002\u001a\u00030³\u00022\b\u0010´\u0002\u001a\u00030µ\u0002H\u0016R\u0012\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0099\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0005\u0012\u00030\u009b\u00010\u009a\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010ß\u0001\u001a\u00030à\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010á\u0001R\u0013\u0010â\u0001\u001a\u00030ã\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010ä\u0001¨\u0006·\u0002"}, d2 = {"Lcom/larus/bmhome/AIChatServiceImpl;", "Lcom/larus/platform/spi/IAIChatService;", "<init>", "()V", "getSocialChatType", "", "cov", "Lcom/larus/im/bean/conversation/Conversation;", "onAsrRecError", "", DBDefinition.TASK_ID, "path", "audioDuration", "", "vid", "getSelectIndex", "", RemoteMessageConst.MSGID, "getDeepResearchParamsToSend", "map", "", "hasSubBenefitsFromStore", "", "onUpdateMessage", "convId", "tryBreakMusic", "insertMultiQuestionReference", "extra", "", "message", "Lcom/larus/im/bean/message/Message;", "searchIndex", "scene", "isReferenceAction", "sendTextOnClickMsgLink", "content", "cvsId", "botId", "extras", "callMapSelectDialog", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "latitude", "", "longitude", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "clickCallBack", "Lkotlin/Function0;", "shouldSwitchToSpeakState", "shouldDisableAudioInput", "inputStatusByExperiment", "enableActionSpeech", "activity", "Landroidx/fragment/app/FragmentActivity;", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "conversationId", "showOnSpeakText", "createBotAvatarViewerDialog", "Landroid/app/Dialog;", "avatarUrl", "canEditAvatar", "autoLogEnterPage", "from", "uploadPicClickListener", "autoGenBtnClickListener", "convertColorBySL", "color", "valueS", "", "valueL", "getBotSettingTrace", "Lcom/larus/bmhome/setting/IBotSettingTrace;", "createUgcVoiceUtils", "Lcom/larus/voice_setting/ICreateUgcVoiceUtils;", "getMixTracer", "Lcom/larus/voice_setting/voice/mix/IMixTracer;", "getChatImmerseUtil", "Lcom/larus/bmhome/chat/immerse/IChatImmerseUtil;", "getMessageShowRecord", "Lcom/larus/bmhome/chat/adapter/IMessageShowRecord;", "getGlobalNickNameHelper", "Lcom/larus/bmhome/bot/utils/IGlobalNickNameHelper;", "createTipOffDialog", "Lcom/larus/bmhome/tipoff/BaseTipOffDialog;", "params", "Lcom/larus/bmhome/tipoff/TipOffDialogParams;", "refreshValidVoiceItemText", "voiceItem", "Lcom/larus/bmhome/view/item/ItemTextArrow;", "speakerVoice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "muted", "isRefreshByVoiceOnly", "refreshVoiceItemText", "botEditPos", "Lcom/larus/platform/model/EditPos;", "getContentWithTextTagInfo", "getBotIdList", "", "conversation", "(Lcom/larus/im/bean/conversation/Conversation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveAsrMainBotLanguage", "language", "initMarkdownResolver", "clearCachedTopic", "loadTccPromptTopic", "", "()[Ljava/lang/String;", "getAllCachedPromptTopic", "setNeedShowChangeIconBtn", "value", "isWelcomeBackMsg", "(Lcom/larus/im/bean/message/Message;)Ljava/lang/Boolean;", "toPromptContent", "Lcom/larus/bmhome/chat/bean/PromptContent;", "getChatType", "botConversationType", "botSourceType", "isOwnBot", "(Ljava/lang/Integer;Ljava/lang/Integer;Z)Ljava/lang/String;", "showSideNavConversationMenu", "anchor", "Landroid/view/View;", "hostFragment", "Landroidx/fragment/app/Fragment;", "conversationData", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "clickFrom", "currentPage", "previousPage", "recommendFrom", "listener", "Lcom/larus/ivykit/xbridge/choosemedia/ActivityResultListener;", "selectMsgIdsFromChatPage", "schema", "pageMode", "enterMethod", "selectedMsgIds", "callback", "Lkotlin/Function1;", "Lkotlin/Pair;", "Lkotlin/ParameterName;", "name", "msgInfoList", "getCustomDataHandlers", "Lcom/larus/business/markdown/api/depend/ICustomDataHandler;", "getCustomImgHandler", "Lcom/larus/business/markdown/api/extplugin/image/ICustomImgHandler;", "getCustomCodeHandler", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeHandler;", "getCitationHandler", "Lcom/larus/business/markdown/api/citation/ICitationHandler;", "bitmapCache", "Landroid/util/LruCache;", "Landroid/graphics/Bitmap;", "drawableToBitmap", "drawableId", "alpha", "setUserBreakMsgId", "getUserBreakMsgId", "isUserBreakMsgId", "showDislikeFeedbackDialog", "fm", "Landroidx/fragment/app/FragmentManager;", "showDislikeFeedbackDialogAndReport", "conversationType", "(Landroidx/fragment/app/FragmentManager;Lcom/larus/im/bean/message/Message;Ljava/lang/Integer;)V", "showTtsFeedbackDialog", "fragmentManager", "bundle", "Landroid/os/Bundle;", "createStandaloneTtsMenuItem", "Lcom/larus/bmhome/view/screenmenu/abs/IMenuItem;", "dismissMessageMenu", "showTipOffDialog", "msg", "Lcom/larus/platform/model/RecommendFrom;", "fromPage", "reportSource", "severIndex", "isImmersive", "searchMobSource", "Lcom/larus/platform/model/SearchMobParam;", "commonMobParam", "reportType", "(Landroidx/fragment/app/FragmentManager;Lcom/larus/im/bean/message/Message;Lcom/larus/platform/model/RecommendFrom;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/model/SearchMobParam;Ljava/lang/String;Ljava/lang/Integer;)V", "messageSendExt", "param", "isExpertCardAutoCollapse", "updateExpertSwitchState", "switch", "waitAnswerReceiving", com.bytedance.android.ec.core.event.a.VALUE_QUESTION, "endAnswerReceiving", "checkIfAuthMessage", "replaceLatestMessage", "chatMessage", "broadcast", "openMainBot", "routeImportedImageToMainBot", "Lcom/larus/bmhome/chat/model/ImportedImageRouteParam;", "onReceiveMsg", "onUpdateReceiveMsgTimeline", "localMsgId", "point", "curTime", "requireAllUserConfig", "Lcom/larus/platform/model/UserConfigResponse;", "configTypes", "reason", "source", "(Ljava/util/List;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onStartSendMsg", "localSendMsgId", "observeRedDotCount", "observer", "Lcom/larus/bmhome/chat/reddot/ConversationRedDotListenerWrapper;", "unObserveRedDotCount", "onMsgShowRedDot", "isSocial", "setIsInDoraCall", "inCall", "customImgHandler", "com/larus/bmhome/AIChatServiceImpl$customImgHandler$1", "Lcom/larus/bmhome/AIChatServiceImpl$customImgHandler$1;", "citationHandler", "com/larus/bmhome/AIChatServiceImpl$citationHandler$1", "Lcom/larus/bmhome/AIChatServiceImpl$citationHandler$1;", "markImageShown", "uriString", "showMessageMenuBalloon", WidgetService.PARAM_FRAGMENT, "recyclerView", "Lcom/larus/bmhome/chat/api/IMessageList;", "menuAnchor", "Lcom/larus/bmhome/view/textview/api/selector/IGestureTextView;", "data", TplType.MENU, "Lcom/larus/bmhome/view/screenmenu/CommonMenu;", "createCodeRenderLongClickHelper", "Landroid/view/View$OnLongClickListener;", "adapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "modelProvider", "Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "isFromLynx", "onSaveCodeImage", "onFullscreen", "onCopyCode", "onCopyCodeImage", "textCellPopMenuGenerator", "Lcom/larus/bmhome/chat/layout/holder/helper/IPopMenuGroupCreator;", "isBizMergeForwardMessage", "createMenuTrigger", "Lcom/larus/platform/spi/TextCellMenuTrigger;", "hostView", "Landroidx/recyclerview/widget/RecyclerView;", "markdownView", "", "anchorView", "childMsgGetter", "markdownContent", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "longClickSource", "Lcom/larus/bmhome/chat/layout/holder/helper/LongClickSource;", "shouldShowDoubaoMessageTtsAction", "isDoubaoMessageTtsActionEnabled", "isDoubaoMessageTtsReading", "handleDoubaoMessageTtsAction", "handleStandaloneMessageTtsAction", "handleMessageTtsAction", "stopDoubaoMessageTts", "startDoubaoMessageTts", "launchDoubaoMessageTts", "block", "Lkotlin/coroutines/Continuation;", "(Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function1;)V", "mobDoubaoMessageTts", "toStatus", "ttsSwitchEnterMethod", "resolveDoubaoMessageBot", "resolveDoubaoChatType", "bot", "resolveDoubaoMessageForTts", "externalConversationId", "resolveDoubaoConversationId", "resolveDoubaoConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "resolveDoubaoMessageTtsContent", "getServiceBotCardHelper", "Lcom/larus/bmhome/chat/layout/holder/helper/api/IServiceBotCardHelper;", "getLoadingType", "Lcom/larus/bmhome/chat/layout/holder/progressloading/LoadingType;", "newFeedbackDialogFragmentInstance", "Landroidx/fragment/app/DialogFragment;", "metaList", "Ljava/util/ArrayList;", "Lcom/larus/bmhome/auth/FeedbackMeta;", "Lkotlin/collections/ArrayList;", GXTemplateKey.GAIAX_PLACEHOLDER, "extraBundle", "createSettingFragment", "chatCameraCache", "Lcom/larus/platform/spi/IChatCameraCache;", "launchVideoDetail", "videoPlayData", "Lcom/larus/platform/model/video/VideoPlayData;", "eventParam", "Lcom/larus/bmhome/utils/VideoDetailEventParams;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIChatServiceImpl implements IAIChatService {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f294881f = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.larus.bmhome.a f294882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LruCache<Integer, Bitmap> f294883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f294884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f294885e;

    public static final class a {
    }

    public static final class b implements hw8.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f294886a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f294887b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f294888c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f294889d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f294890e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f294891f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f294892g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f294893h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f294894i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f294895j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f294896k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f294897l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Lazy f294898m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final Lazy f294899n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Lazy f294900o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final float[] f294901p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final RectF f294902q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final Path f294903r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final /* synthetic */ AIChatServiceImpl f294904s;

        public b(AIChatServiceImpl r100) {
            this.f294904s = r100;
            this.f294886a = c7.b(10);
            this.f294887b = c7.b(3);
            this.f294888c = c7.b(3);
            this.f294889d = c7.b(22);
            this.f294890e = c7.b(5);
            this.f294891f = c7.b(3);
            this.f294892g = c7.b(3);
            this.f294893h = c7.b(3);
            this.f294894i = c7.b(6);
            this.f294895j = c7.b(6);
            Double r101 = Double.valueOf(3.5d);
            this.f294896k = c7.b(r101);
            this.f294897l = c7.b(r101);
            this.f294898m = LazyKt.lazy(new com.larus.bmhome.b());
            this.f294899n = LazyKt.lazy(new com.larus.bmhome.c());
            this.f294900o = LazyKt.lazy(new com.larus.bmhome.d());
            this.f294901p = new float[]{c7.c(6), c7.c(6), c7.c(6), c7.c(6), c7.c(6), c7.c(6), c7.c(6), c7.c(6)};
            this.f294902q = new RectF(50.0f, 50.0f, 300.0f, 200.0f);
            this.f294903r = new Path();
        }

        public static boolean d(String r100) {
            Object r101 = null;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L19
            int r103 = r100.length();     // Catch: Throwable -> L19
            if (3 <= r103) goto L6;
        L8:
            boolean r104 = false;
        L9:
            if (r104 == true) goto L12;
            return false;
        L12:
            if (StringsKt.startsWith$default(r100, "[", false, 2, null) == true) goto L14;
        L18:
            return false;
        L14:
            if (StringsKt.endsWith$default(r100, "]", false, 2, null) == false) goto L18;
            Object r105 = Result.m9449constructorimpl(Boolean.valueOf(TextUtils.isDigitsOnly(r100.substring(1, r100.length() - 1))));     // Catch: Throwable -> L19
        L22:
            if (Result.m9455isFailureimpl(r105) == true) goto L25;
            r101 = r105;
        L25:
            Boolean r106 = (Boolean) r101;
            if (r106 != null) goto L28;
            return false;
        L28:
            return r106.booleanValue();
        L6:
            if (r103 >= 5) goto L8;
            r104 = true;
        L19:
            th = move-exception;
            Result.Companion r107 = Result.Companion;
            r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L22
        }

        @Override // hw8.b
        public final boolean c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "linkTitle");
            return new Regex("^\\[.+\\]$").matches(r100);
        }

        @Override // hw8.b
        public final int b(Paint r100, hw8.a r101) {
            Intrinsics.checkNotNullParameter(r100, "paint");
            Intrinsics.checkNotNullParameter(r101, "info");
            if (d(r101.f487428a) == false) goto L6;
            int r102 = ((this.f294886a * 2) + this.f294887b) + this.f294888c;
            int r103 = c7.b(2);
        L10:
            return r102 + r103;
        L6:
            if (Intrinsics.areEqual(r101.f487428a, "[__LINK_ICON]") == false) goto L8;
            r102 = this.f294889d + this.f294890e;
            r103 = this.f294891f;
            goto L10
        L8:
            r100.setTypeface(Typeface.DEFAULT_BOLD);
            r100.setTextSize(c7.c(10));
            r100.setFakeBoldText(false);
            r102 = ((((int) r100.measureText(StringsKt.trim(StringsKt.trim(r101.f487428a, new char[]{'[', ']'}), new char[]{'(', ')'}))) + this.f294892g) + this.f294893h) + this.f294894i;
            r103 = this.f294895j;
            goto L10
        }

        @Override // hw8.b
        public final void a(Canvas r100, float r101, int r102, int r103, int r110, Paint r111, Paint r112, msc.s r113, hw8.a r114, float r115) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            Intrinsics.checkNotNullParameter(r111, GXTemplateKey.GAIAX_PT);
            Intrinsics.checkNotNullParameter(r112, "paint");
            Intrinsics.checkNotNullParameter(r113, "theme");
            Intrinsics.checkNotNullParameter(r114, "info");
            if (d(r114.f487428a) == false) goto L5;
            int r104 = ((this.f294886a * 2) + this.f294887b) + this.f294888c;
            r112.setTypeface(Typeface.DEFAULT_BOLD);
            r112.setTextSize(c7.c(12));
            String r116 = StringsKt.trim(r114.f487428a, new char[]{'[', ']'});
            float r105 = r104;
            float r117 = 2;
            float r106 = r103;
            float r118 = 3;
            r100.drawText(r116, ((r105 - r112.measureText(r116)) / r117) + r101, r106 - r118, r112);
            r113.c(r112);
            Paint.FontMetrics r119 = r112.getFontMetrics();
            float r120 = r119.descent;
            r100.drawCircle(r101 + (r105 / 2.0f), (r106 - (((r120 - r119.ascent) / r117) - r120)) - r118, this.f294886a, r112);
            return;
        L5:
            Object r107 = null;
            if (Intrinsics.areEqual(r114.f487428a, "[__LINK_ICON]") == false) goto L14;
            Paint.FontMetrics r108 = r112.getFontMetrics();
            Bitmap r121 = AIChatServiceImpl.i(this.f294904s, v19.c.b(R.attr.larus_icon_citation_link, null, R.drawable.larus_icon_citation_link), 1.0f - r115);
            if (r121 != null) goto L10;
            return;
        L10:
            float r109 = r101 + this.f294890e;
            float r122 = r108.descent;
            float r123 = (r103 - (((r122 - r108.ascent) / 2) - r122)) - (r121.getHeight() / 2);
            RectF r124 = new RectF(r109, r123, r121.getWidth() + r109, r121.getHeight() + r123);
            r100.drawBitmap(r121, null, r124, r112);
            Bitmap r125 = AIChatServiceImpl.i(this.f294904s, v19.c.b(R.attr.larus_icon_citation_link_pressed, null, R.drawable.larus_icon_citation_link_pressed), r115);
            if (r125 != null) goto L13;
            return;
        L13:
            r100.drawBitmap(r125, null, r124, r112);
            return;
        L14:
            r112.setTypeface(Typeface.DEFAULT_BOLD);
            r112.setTextSize(c7.c(10));
            r112.setFakeBoldText(false);
            String r126 = StringsKt.trim(StringsKt.trim(r114.f487428a, new char[]{'[', ']'}), new char[]{'(', ')'});
            float r127 = 2;
            float r128 = (r112.getFontMetrics().descent - r112.getFontMetrics().ascent) / r127;
            float r129 = (r112.measureText(r126) + this.f294894i) + this.f294895j;
            float r130 = this.f294892g + r101;
            float r131 = r129 + r130;
            float r132 = (r102 + r110) / 2.0f;
            float r133 = ((r132 - r128) - this.f294896k) - (r112.getFontMetrics().descent / r127);
            float r134 = ((r132 + r128) + this.f294897l) - (r112.getFontMetrics().descent / r127);
            r113.c(r112);
            Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L21
            Object r136 = new ArgbEvaluator().evaluate(RangesKt.coerceIn(r115, 0.0f, 1.0f), (Integer) this.f294899n.getValue(), (Integer) this.f294900o.getValue());     // Catch: Throwable -> L21
            if ((r136 instanceof Integer) == false) goto L18;
            Integer r137 = (Integer) r136;     // Catch: Throwable -> L21
        L19:
            Object r138 = Result.m9449constructorimpl(r137);     // Catch: Throwable -> L21
        L24:
            if (Result.m9455isFailureimpl(r138) == true) goto L27;
            r107 = r138;
        L27:
            Integer r139 = (Integer) r107;
            if (r139 == null) goto L30;
            r112.setColor(r139.intValue());
        L30:
            this.f294902q.set(r130, r133, r131, r134);
            this.f294903r.reset();
            this.f294903r.addRoundRect(this.f294902q, this.f294901p, Path.Direction.CW);
            r100.drawPath(this.f294903r, r112);
            Integer r140 = (Integer) this.f294898m.getValue();
            if (r140 == null) goto L33;
            r112.setColor(r140.intValue());
        L33:
            r100.drawText(r126, (r101 + this.f294892g) + this.f294894i, (((r133 + r134) / r127) + r128) - r112.getFontMetrics().descent, r112);
            return;
        L18:
            r137 = null;
        L21:
            th = move-exception;
            Result.Companion r141 = Result.Companion;
            r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L24
        }
    }

    public static final class c implements com.larus.business.markdown.api.extplugin.image.a {
        public c() {
        }

        @Override // com.larus.business.markdown.api.extplugin.image.a
        public final com.larus.business.markdown.api.extplugin.image.b b() {
            return IFlowMainBot.f358419a.b();
        }

        @Override // com.larus.business.markdown.api.extplugin.image.a
        public final void c(FrameLayout r100, TextView r101, Spanned r102, com.larus.business.markdown.api.extplugin.image.c r103) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            Intrinsics.checkNotNullParameter(r101, "textView");
            Intrinsics.checkNotNullParameter(r102, "text");
            Intrinsics.checkNotNullParameter(r103, "span");
        }
    }

    public static final class d implements jw8.a {
        public d() {
        }

        @Override // jw8.a
        public final jw8.c a(FrameLayout r100, TextView r101, Spanned r102, jw8.b r103, lw8.d r104) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            Intrinsics.checkNotNullParameter(r101, "textView");
            Intrinsics.checkNotNullParameter(r102, "text");
            Intrinsics.checkNotNullParameter(r103, "span");
            return IFlowMainBot.f358419a.n8(r100.getContext(), r104);
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e extends TypeToken<HashMap<String, String>> {
        public e() {
        }
    }

    static {
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final boolean J7() {
        return !AudioServiceDelegate.f288288a.P().isRecording();
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final Fragment R7() {
        CommonSettingFragment r100 = new CommonSettingFragment();
        r100.f296455J = true;
        return r100;
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final boolean V7() {
        CoroutineScope r100 = ExpertSwitchManager.f306663a;
        return FeatureKitDelegate.f295792b.e0().b();
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void X7() {
        Gson r100 = PromptCacheManager.f306675a;
        FLogger.f375446a.d("PromptCacheManager", "hit risk check, clear cache topics");
        PromptCacheManager.f306676b.erase(PromptCacheManager.c());
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final List<com.larus.business.markdown.api.depend.a> a() {
        MarkdownDataHandlersProvider.f365911a.getClass();
        ArrayList r100 = new ArrayList();
        Iterator r101 = ServiceManager.get().getServices(MarkdownDataHandlersProvider.class, true).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.addAll(((MarkdownDataHandlersProvider) r101.next()).a());
        goto L4
    L6:
        return r100;
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final String[] a8() {
        return PromptCacheManager.f306676b.getStringArray("key_cached_tcc_prompt", new String[0]);
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void d8() {
        WeakReference<ef8.o> r100 = ef8.o.f472556v;
        ef8.o.a.a();
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final jw8.a e() {
        return new d();
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final v2a.b f7() {
        return r.f527492b.f7();
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void j7() {
        MarkdownResolver.f296963a.getClass();
        gw8.c.f483071a.getClass();
        gw8.c r100 = gw8.c.a.b();
        if (r100 == null) goto L6;
        r100.registerLinkResolver(new z4());
        return;
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final com.larus.bmhome.setting.b k8() {
        return new com.larus.bmhome.bot.b();
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void n4() {
        int r100 = MusicCell.f305405g;
        MusicCell.a.a();
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final boolean n8() {
        boolean r100 = com.larus.bmhome.utils.e.f315003a;
        return z2.f365865a.disableVoiceInput();
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final List<String> p7() {
        String r100 = PromptCacheManager.f306676b.getString(PromptCacheManager.c(), "");
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L30;
        LinkedHashSet r102 = new LinkedHashSet();
        List r103 = (List) GsonProtectorUtils.fromJson(PromptCacheManager.f306675a, r100, new com.larus.bmhome.chat.manager.p0().getType());     // Catch: JsonSyntaxException -> L14
    L15:
        Intrinsics.checkNotNull(r103);
        Iterator r104 = r103.iterator();
    L17:
        if (r104.hasNext() == false) goto L22;
        List<String> r105 = ((PromptCacheManager.a) r104.next()).b();
        if (r105 == null) goto L17;
        r102.addAll(r105);
        goto L17
    L22:
        return CollectionsKt.toList(r102);
    L14:
        r103 = CollectionsKt.emptyList();
        goto L15
    L30:
        return CollectionsKt.emptyList();
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final boolean q8() {
        CoroutineScope r100 = Gpt4SwitchManager.f306667a;
        return Gpt4SwitchManager.c();
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final p2a.a u7() {
        return r.f527492b.l2();
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final int w7() {
        ICoreInputAbility.A1.getClass();
        if (z2.f365865a.chatInputType() != 2) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L10;
        return 1;
    L10:
        return 2;
    L5:
        r100 = false;
        goto L6
    }

    public AIChatServiceImpl() {
        this.f294883c = new LruCache(10);
        this.f294884d = new c();
        this.f294885e = new b(this);
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final boolean h7() {
        return com.larus.bmhome.utils.e.b();
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final com.larus.bmhome.chat.adapter.j Y7() {
        return com.larus.bmhome.chat.adapter.p0.f297111a;
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final hw8.b b() {
        return this.f294885e;
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final com.larus.business.markdown.api.extplugin.image.a h() {
        return this.f294884d;
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final com.larus.bmhome.chat.immerse.j0 j8() {
        return com.larus.bmhome.chat.immerse.i0.f303282a;
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final com.larus.bmhome.bot.utils.c l7() {
        return com.larus.bmhome.bot.utils.b.f296782a;
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final cf8.a o7() {
        return ServiceBotCardHelper.f303565a;
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final sr9.d v7() {
        return od8.d.f522863a;
    }

    public static com.larus.bmhome.chat.component.cvs.y n(Fragment r100) {
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L15
        if (r100 == null) goto L12;
        FragmentManager r103 = r100.getChildFragmentManager();     // Catch: Throwable -> L15
        if (r103 == null) goto L12;
        Fragment r104 = r103.findFragmentByTag("ComponentAdapterFragment");     // Catch: Throwable -> L15
        if (r104 == null) goto L12;
        t1a.b r105 = s1a.a.g(r104);     // Catch: Throwable -> L15
        if (r105 == null) goto L12;
        com.larus.bmhome.chat.component.cvs.y r106 = (com.larus.bmhome.chat.component.cvs.y) r105.getAbility(com.larus.bmhome.chat.component.cvs.y.class);     // Catch: Throwable -> L15
    L13:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L15
    L18:
        if (Result.m9455isFailureimpl(r107) == true) goto L22;
        r101 = r107;
    L22:
        return (com.larus.bmhome.chat.component.cvs.y) r101;
    L12:
        r106 = null;
    L15:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    public static String p(Message r100) {
        if (m99.a.f(r100) == false) goto L8;
        String r101 = m99.a.a(r100);
        if (r101 != null) goto L24;
    L22:
        return "";
    L24:
        return r101;
    L8:
        if (com.larus.bmhome.chat.bean.d.z0(r100) == false) goto L20;
        String r102 = com.larus.bmhome.chat.bean.d.r(r100);
        if (r102 != null) goto L12;
    L15:
        boolean r103 = true;
    L16:
        if (r103 == false) goto L20;
        String r104 = r100.getContent();
        if (r104 == null) goto L22;
        return r104;
    L12:
        if (StringsKt.isBlank(r102) == true) goto L15;
        r103 = false;
    L20:
        String r105 = com.larus.bmhome.chat.bean.d.r(r100);
        if (r105 == null) goto L22;
        return r105;
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final Map<String, String> A7(Pair<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        Pair[] r101 = {r100};
        ChatSendUtils.f307932a.getClass();
        return ChatSendUtils.p(r101);
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final LoadingType B7(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        return com.larus.bmhome.chat.layout.holder.progressloading.h.a(r100);
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void D7(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (com.larus.media.o.a() == false) goto L5;
        MediaResourceManager.a r101 = new MediaResourceManager.a();
        r101.f358958b = r100.getMessageId();
        r101.f358959c = MediaResourceManager.FlowAudioBroadcastEvent.asrWaitReplyEnd;
        Lazy r102 = MediaResourceManager.f358950a;
        MediaResourceManager.d(r101);
    L5:
        com.larus.bmhome.view.actionbar.deepresearch.b r103 = com.larus.bmhome.view.actionbar.deepresearch.b.f316025a;
        Intrinsics.checkNotNullParameter(r100, "msg");
        Map<String, String> r104 = r100.getExt();
        String r105 = null;
        if (r104 == null) goto L8;
        String r106 = r104.get("deep_research_phase");
    L9:
        FLogger r107 = FLogger.f375446a;
        r107.i("DeepResearchBarManager", "onReceiveMessage, cvsId[" + r100.getConversationId() + "], deepResearchPhase[" + r106 + ']');
        String r108 = "";
        if (r106 == null) goto L73;
        switch(r106.hashCode()) {
            case -1274442605: goto L62;
            case -1268958287: goto L26;
            case -934521548: goto L23;
            case 1676279000: goto L15;
            default: goto L73;
        };
    L15:
        if (r106.equals("start_research") == false) goto L73;
        String r109 = r100.getConversationId();
        if (r109 == null) goto L21;
        r108 = r109;
    L21:
        com.larus.bmhome.view.actionbar.deepresearch.b.e(r108, null);
        return;
    L23:
        if (r106.equals("report") == false) goto L73;
        return;
    L26:
        if (r106.equals("follow") == false) goto L73;
        Map<String, String> r110 = r100.getExt();
        if (r110 == null) goto L60;
        String r111 = r110.get("deep_research_id");
        if (r111 == null) goto L60;
        String r112 = r100.getConversationId();
        if (r112 == null) goto L37;
        r108 = r112;
    L37:
        if (com.larus.bmhome.view.actionbar.deepresearch.b.f316027c == null) goto L87;
        r107.i("DeepResearchBarManager", "enterExplain, sourceMsgId[" + r111 + "], cvsId[" + r108 + ']');
        boolean r113 = true;
        com.larus.bmhome.view.actionbar.deepresearch.b.c().put(r108, new com.larus.bmhome.view.actionbar.deepresearch.c(r111, r108, true));
        z0 r114 = com.larus.bmhome.view.actionbar.deepresearch.b.f316027c;
        if (r114 != null) goto L43;
    L50:
        if (r105 != null) goto L52;
    L55:
        if (r113 == true) goto L88;
        com.larus.bmhome.instruction.g r115 = com.larus.bmhome.view.actionbar.deepresearch.b.f316028d;
        if (r115 == null) goto L83;
        r115.onInputHintChanged(r105, "DeepResearchBarManager#setHint");
        return;
    L83:
        return;
    L88:
        return;
    L52:
        if (StringsKt.isBlank(r105) == true) goto L55;
        r113 = false;
        goto L55
    L43:
        if (com.larus.bmhome.view.actionbar.deepresearch.b.d() == false) goto L47;
        com.larus.bmhome.actionbar.model.m0 r116 = r114.f295625u;
        if (r116 == null) goto L50;
        r105 = r116.f295311t;
        goto L50
    L47:
        com.larus.bmhome.actionbar.model.m0 r117 = r114.f295625u;
        if (r117 == null) goto L50;
        r105 = r117.f295310s;
        goto L50
    L87:
        return;
    L60:
        r107.i("DeepResearchBarManager", "enter explain without source msg id");
        return;
    L62:
        if (r106.equals(VideoEventOneOutSync.END_TYPE_FINISH) == false) goto L73;
        Map<String, String> r118 = r100.getExt();
        if (r118 == null) goto L67;
        r105 = r118.get("deep_research_end_reason");
    L67:
        String r119 = r100.getConversationId();
        if (r119 == null) goto L71;
        r108 = r119;
    L71:
        com.larus.bmhome.view.actionbar.deepresearch.b.e(r108, r105);
        return;
    L73:
        if (com.larus.bmhome.view.actionbar.deepresearch.b.f316027c == null) goto L89;
        String r120 = r100.getConversationId();
        if (r120 == null) goto L79;
        r108 = r120;
    L79:
        com.larus.bmhome.view.actionbar.deepresearch.b.e(r108, "auto");
        return;
    L89:
        return;
    L8:
        r106 = null;
        goto L9
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final Boolean E7(Message r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return Boolean.valueOf(com.larus.bmhome.chat.bean.d.W0(r100));
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final PromptContent L7(Message r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return com.larus.bmhome.chat.bean.d.i1(r100, null, 3);
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final String T7(Message r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return com.larus.bmhome.chat.bean.d.s(r100);
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final String U7(wc9.e r100) {
        if (r100 == null) goto L4;
        String r101 = ic8.n.i(r100);
    L5:
        if (r101 != null) goto L8;
        return "";
    L8:
        return r101;
    L4:
        r101 = null;
        goto L5
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void b8(String r100) {
        Set<String> r101 = AnswerAnchorTopStrategy.f307884a;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L24;
        Set<String> r103 = AnswerAnchorTopStrategy.f307884a;
        if (r103.contains(r100) == true) goto L25;
        FLogger.f375446a.d("AnswerAnchorTopStrategy", "waitAnswerReceiving called, reply_for: " + r100);
        Object r104 = AnswerAnchorTopStrategy.f307887d;
        monitor-enter(r104);
        r103.add(r100);     // Catch: Throwable -> L19
        AnswerAnchorTopStrategy.f307886c = true;     // Catch: Throwable -> L19
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r104);
        return;
    L19:
        th = move-exception;
        throw th;
    L25:
        return;
    L24:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final int d(String r100) {
        com.larus.bmhome.chat.helper.n0.f303117a.getClass();
        return w2.a(r100);
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final String e7(String r100) {
        String r101 = x3.f315151a;
        if (r100 != null) goto L6;
        return "";
    L6:
        return ((Keva) x3.f315152b.getValue()).getString(r100, "");
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void f(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        IAiChatOpenDouyinAuthService r101 = (IAiChatOpenDouyinAuthService) ServiceManager.get().getService(IAiChatOpenDouyinAuthService.class);
        if (r101 == null) goto L6;
        r101.f(r100);
        return;
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final ot8.a f8(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r100, "data");
        return d1.b(r100, true);
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final BaseTipOffDialog g8(TipOffDialogParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        TipOffDialogFragment.a r101 = new TipOffDialogFragment.a();
        Intrinsics.checkNotNullParameter(r100, "builder");
        r101.f314692a = r100;
        return r101.a();
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void h8(boolean r100) {
        boolean r101 = vc8.a.f554128a;
        vc8.a.f554128a = r100;
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void i7(Map<String, String> r100) {
        com.larus.bmhome.view.actionbar.deepresearch.b r101 = com.larus.bmhome.view.actionbar.deepresearch.b.f316025a;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>");
        com.larus.bmhome.view.actionbar.deepresearch.b.b(TypeIntrinsics.asMutableMap(r100));
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void i8(String r100) {
        AnswerAnchorTopStrategy.a(r100);
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void n7(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uriString");
        CopyOnWriteArraySet<String> r101 = com.larus.bmhome.chat.component.bottom.multimodal.latest.c0.f299862a;
        Intrinsics.checkNotNullParameter(r100, "uriString");
        com.larus.bmhome.chat.component.bottom.multimodal.latest.c0.f299862a.add(r100);
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void o4(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        com.larus.bmhome.chat.trace.appreciable.f.f310120a.getClass();
        Intrinsics.checkNotNullParameter(r100, "msg");
        ChatMessageCostTrace.f310093a.getClass();
        Intrinsics.checkNotNullParameter(r100, "msg");
        String r101 = r100.getReplyId();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        androidx.collection.LruCache<String, CommonParamManager.CommonParam> r102 = CommonParamManager.f310103a;
        Map<String, String> r103 = com.larus.im.bean.message.a.U(r100);
        Intrinsics.checkNotNullParameter(r103, "commonTags");
        int r104 = 0;
        Integer r105 = null;
        if (r103.isEmpty() == true) goto L37;
        CommonParamManager.CommonParam r106 = CommonParamManager.c(r101);
        if (r106 == null) goto L37;
        Map r107 = MapsKt.createMapBuilder();
        String r108 = r106.getCTraceId();
        boolean r109 = true;
        if (r108 != null) goto L13;
    L21:
        String r110 = r106.getScene();
        if (r110 != null) goto L24;
    L32:
        Integer r111 = r106.getAgentMode();
        if (r111 == null) goto L35;
        r107.put("agent_mode", String.valueOf(r111.intValue()));
    L35:
        r106.setMessageTrackCommonTags(MapsKt.plus(MapsKt.plus(r106.getMessageTrackCommonTags(), r103), MapsKt.build(r107)));
        goto L37
    L24:
        if (r110.length() > 0) goto L27;
        r109 = false;
    L27:
        if (r109 == true) goto L30;
        r110 = null;
    L30:
        if (r110 == null) goto L32;
        String r112 = (String) r107.put("scene", r110);
        goto L32
    L13:
        if (r108.length() <= 0) goto L15;
        boolean r113 = true;
    L16:
        if (r113 == true) goto L19;
        r108 = null;
    L19:
        if (r108 == null) goto L21;
        String r114 = (String) r107.put("c_trace_id", r108);
        goto L21
    L15:
        r113 = false;
    L37:
        if (com.larus.im.bean.message.a.r0(r100) == true) goto L87;
        CommonParamManager.CommonParam r115 = CommonParamManager.c(r100.getReplyId());
        if (r115 == null) goto L42;
        String r116 = r115.getGeneralAgent();
    L43:
        String r117 = "1";
        if (Intrinsics.areEqual(r116, "1") == true) goto L55;
        if (r115 == null) goto L55;
        Map<String, String> r118 = r100.getExt();
        if (r118 == null) goto L49;
        String r119 = r118.get("general_agent");
    L51:
        if (Intrinsics.areEqual(r119, "1") == false) goto L53;
        String r120 = "1";
    L54:
        r115.setGeneralAgent(r120);
        goto L55
    L53:
        r120 = "0";
        goto L54
    L49:
        r119 = null;
    L55:
        if (r115 == null) goto L57;
        String r121 = r115.isAsyncTask();
    L59:
        if (Intrinsics.areEqual(r121, "1") == true) goto L70;
        if (r115 == null) goto L70;
        Map<String, String> r122 = r100.getExt();
        if (r122 == null) goto L64;
        String r123 = r122.get("is_async_task");
    L66:
        if (Intrinsics.areEqual(r123, "1") == true) goto L69;
        r117 = "0";
    L69:
        r115.setAsyncTask(r117);
        goto L70
    L64:
        r123 = null;
    L70:
        if (r115 != null) goto L72;
    L73:
        FLogger r124 = FLogger.f375446a;
        StringBuilder r125 = new StringBuilder("receiveSdkReply replyId=");
        r125.append(r100.getReplyId());
        r125.append(" param.hashCode=");
        if (r115 == null) goto L76;
        r104 = r115.hashCode();
    L76:
        r125.append(r104);
        r125.append(" callbackTime=");
        if (r115 == null) goto L79;
        Long r126 = r115.getBusinessReceiveMsgCallbackTime();
    L80:
        r125.append(r126);
        r125.append(" messageLength=");
        String r127 = r100.getContent();
        if (r127 == null) goto L83;
        r105 = Integer.valueOf(r127.length());
    L83:
        r125.append(r105);
        r125.append(' ');
        r124.i("ChatMessageCostTrace", r125.toString());
        if (r115 == null) goto L86;
        r115.setBusinessReceiveMsgCallbackTime(Long.valueOf(SystemClock.elapsedRealtime()));
    L86:
        Unit r128 = Unit.INSTANCE;
        goto L87
    L79:
        r126 = null;
        goto L80
    L72:
        if (r115.getBusinessReceiveMsgCallbackTime() != null) goto L87;
    L57:
        r121 = null;
        goto L59
    L42:
        r116 = null;
    L87:
        nq9.f r129 = m3.f365766a.o();
        if (r129 == null) goto L91;
        r129.o4(r100);
        return;
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void q7(final Message r100) {
        Intrinsics.checkNotNullParameter(r100, "chatMessage");
        yh8.c r101 = yh8.c.f567618a;
        monitor-enter(r101);
        Intrinsics.checkNotNullParameter(r100, "chatMessage");     // Catch: Throwable -> L19
        if (TextUtils.equals(yh8.c.f567620c, r100.getMessageId()) == false) goto L9;
        FLogger.f375446a.i("MediaMessageWatcher", "equal id remove ");     // Catch: Throwable -> L19
        monitor-exit(r101);
        return;
    L9:
        FLogger.f375446a.i("MediaMessageWatcher", "auto play replaced " + r100.getMessageId());     // Catch: Throwable -> L19
        String r102 = r100.getMessageId();     // Catch: Throwable -> L19
        if (r102 != null) goto L12;
        r102 = "";
    L12:
        yh8.c.f567620c = r102;     // Catch: Throwable -> L19
        yh8.c.f567619b = r100;     // Catch: Throwable -> L19
        Iterator<yh8.c.a> r103 = yh8.c.f567621d.iterator();     // Catch: Throwable -> L19
    L14:
        if (r103.hasNext() == false) goto L17;
        final yh8.c.a r104 = r103.next();     // Catch: Throwable -> L19
        com.larus.utils.y.c(new yh8.b(r104, r100));     // Catch: Throwable -> L19
        goto L14
    L17:
        monitor-exit(r101);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final boolean r7(Message r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return com.larus.bmhome.chat.model.a0.b(r100);
    }

    public static void l(Fragment r110, Function1 r111) {
        if (r110 == null) goto L9;
        LiveData<LifecycleOwner> r112 = r110.getViewLifecycleOwnerLiveData();
        if (r112 == null) goto L9;
        LifecycleOwner r113 = r112.getValue();
        if (r113 == null) goto L9;
        LifecycleCoroutineScope r100 = LifecycleOwnerKt.getLifecycleScope(r113);
    L10:
        if (r100 == null) goto L13;
        RepoDispatcher.f307729a.getClass();
        BuildersKt.launch$default(r100, RepoDispatcher.f307730b, null, new AIChatServiceImpl$launchDoubaoMessageTts$1(r111, null), 2, null);
        return;
    L13:
        GlobalScope r101 = GlobalScope.INSTANCE;
        RepoDispatcher.f307729a.getClass();
        BuildersKt.launch$default(r101, RepoDispatcher.f307730b, null, new AIChatServiceImpl$launchDoubaoMessageTts$2(r111, null), 2, null);
        return;
    L9:
        r100 = null;
        goto L10
    }

    public static String m(Fragment r100, BotModel r101) {
        com.larus.bmhome.chat.component.cvs.y r102 = n(r100);
        String r103 = null;
        if (r102 == null) goto L5;
        wc9.e r104 = r102.h();
    L6:
        ChatControlTrace r105 = ChatControlTrace.f309996b;
        if (r104 == null) goto L9;
        Integer r106 = r104.f559219v;
    L10:
        if (r101 == null) goto L12;
        Integer r107 = r101.getBotType();
    L13:
        if (r101 == null) goto L18;
        BotCreatorInfo r108 = r101.getBotCreatorInfo();
        if (r108 == null) goto L18;
        r103 = r108.getId();
    L18:
        return r105.g(r106, r107, Intrinsics.areEqual(r103, AccountService.f365697a.getUserId()));
    L12:
        r107 = null;
        goto L13
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    public static BotModel o(Fragment r610, Message r710) {
        com.larus.bmhome.chat.component.cvs.y r100 = n(r610);
        if (r100 == null) goto L7;
        BotModel r101 = r100.j0();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new BotModel(r710.getSenderId(), null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void H7(FragmentManager r100, Message r101) {
        Intrinsics.checkNotNullParameter(r100, "fm");
        Intrinsics.checkNotNullParameter(r101, "message");
        ChatFragmentDelegateDialogExtKt.b(r100, r101, null, 28);
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void M7(Context r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "bundle");
        ILaunchCacheService r100 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r100 == null) goto L7;
        wc9.e r101 = r100.b();
        if (r101 == null) goto L7;
        ConversationPage r102 = r101.f559204g;
    L8:
        FLogger.f375446a.i("AIChatServiceImpl", "openMainBot, isChatVideoDoubleTab:" + r102);
        MainBotServiceDelegate r103 = MainBotServiceDelegate.f308544b;
        if (r102 == null) goto L13;
        Integer r104 = r102.getDefaultStatus();
        if (r104 == null) goto L13;
        int r105 = r104.intValue();
    L14:
        int r106 = r105;
        if (r102 == null) goto L18;
        List<Integer> r107 = r102.getPageList();
        if (r107 == null) goto L18;
    L19:
        List<Integer> r108 = r107;
        if (r102 == null) goto L24;
        Integer r109 = r102.getPagePosition();
        if (r109 == null) goto L24;
        int r112 = r109.intValue();
    L25:
        r103.c(r110, new IMainBotService.a(r111, r106, r108, r112, R.anim.larus_fade_in, R.anim.larus_fade_out, 67108864));
        return;
    L24:
        r112 = 0;
    L18:
        r107 = CollectionsKt.emptyList();
    L13:
        r105 = PageType.Chat.getType();
    L7:
        r102 = null;
        goto L8
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final t0 O7(Message r100, wc9.e r110) {
        Intrinsics.checkNotNullParameter(r100, "message");
        List<Block> r101 = r100.getContentBlock();
        if (r101 != null) goto L5;
        r101 = CollectionsKt.emptyList();
    L5:
        List<Block> r102 = r101;
        if (r102.isEmpty() == false) goto L8;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r102 = vd9.r.a(r100);
    L8:
        List<Block> r103 = r102;
        boolean r104 = false;
        if ((r103 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r105 = r103.iterator();
    L15:
        if (r105.hasNext() == false) goto L28;
        Block r106 = (Block) r105.next();
        if (r106.getBlockType() == BlockType.BLOCK_TYPE_BIZ_MERGE_FORWARD.getValue()) goto L25;
        BlockContent r107 = r106.getContent();
        if (r107 == null) goto L21;
        BizMergeForwardBlock r108 = r107.getBizMergeForwardBlock();
    L22:
        if (r108 != null) goto L25;
        boolean r109 = false;
    L26:
        if (r109 == false) goto L15;
        boolean r111 = true;
    L29:
        if (r111 == false) goto L33;
        return new x2();
    L33:
        if (com.larus.bmhome.chat.bean.d.z0(r100) == false) goto L40;
        if (com.larus.bmhome.chat.bean.d.Q0(r100) == false) goto L38;
        return new q1();
    L38:
        return new com.larus.bmhome.chat.layout.holder.helper.m0(null);
    L40:
        if (com.larus.bmhome.chat.bean.d.G0(r100) == false) goto L43;
        return new u2();
    L43:
        if (com.larus.bmhome.chat.bean.d.d(r100) == true) goto L90;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (com.larus.im.bean.message.a.b0(r100) == false) goto L57;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (vd9.r.a(r100).size() != 1) goto L57;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Block r112 = (Block) CollectionsKt.getOrNull(vd9.r.a(r100), 0);
        if (r112 != null) goto L52;
    L54:
        boolean r113 = false;
    L55:
        if (r113 == false) goto L57;
        boolean r114 = true;
    L58:
        if (r114 == false) goto L61;
        return new s1();
    L61:
        if (com.larus.bmhome.chat.bean.d.Q0(r100) == false) goto L64;
        return new q1();
    L64:
        if (Intrinsics.areEqual(r100.getBizContentType(), "deep_search_card") == false) goto L67;
        return new v0();
    L67:
        if (com.larus.bmhome.chat.bean.d.y0(r100) == false) goto L70;
        return new com.larus.bmhome.chat.layout.holder.helper.t();
    L70:
        if (com.larus.bmhome.chat.bean.d.E0(r100) == true) goto L95;
        IFlowSdkDepend r115 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r115 == null) goto L79;
        FlowAppletServiceImpl r116 = r115.g0();
        if (r116 == null) goto L79;
        if (r116.m(r110) != true) goto L79;
        r104 = true;
    L79:
        if (r104 == false) goto L82;
        return new com.larus.bmhome.chat.layout.holder.helper.h();
    L82:
        return new com.larus.bmhome.chat.layout.holder.helper.m0(null);
    L95:
        return new com.larus.bmhome.chat.layout.holder.helper.z2();
    L52:
        if (r112.getBlockType() != BlockType.BLOCK_TYPE_PERMISSION_APPLY.getValue()) goto L54;
        r113 = true;
    L57:
        r114 = false;
        goto L58
    L90:
        return new com.larus.bmhome.chat.layout.holder.helper.m0(null);
    L21:
        r108 = null;
    L25:
        r109 = true;
    L28:
        r111 = false;
        goto L29
    L11:
        if (r103.isEmpty() == false) goto L13;
        goto L13
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "convId");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        ji8.d.f499226a.c(r100, r101);
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void m4(String r100, String r101) {
        String r102 = x3.f315151a;
        if (r100 == null) goto L9;
        if (r101 == null) goto L10;
        ((Keva) x3.f315152b.getValue()).storeString(r100, r101);
        return;
    L10:
        return;
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void m8(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r111, "cvsId");
        Intrinsics.checkNotNullParameter(ObricActionBarTrackType.SPEAK, "scene");
        com.larus.bmhome.chat.trace.appreciable.f.l(com.larus.bmhome.chat.trace.appreciable.f.f310120a, r110, r111, ObricActionBarTrackType.SPEAK, 0, null, null, null, null, 248);
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final Object s7(wc9.e r100, Continuation<? super List<String>> r101) {
        if (r100 == null) goto L7;
        Object r102 = ic8.n.c(r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r102;
    L9:
        return (List) r102;
    L7:
        return null;
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void t7(boolean r100, Function1<? super Boolean, Unit> r101) {
        CoroutineScope r102 = ExpertSwitchManager.f306663a;
        ExpertSwitchManager.b(r100, r101);
    }

    public static final Bitmap i(AIChatServiceImpl r100, int r101, float r102) {
        r100.getClass();
        boolean r103 = true;
        if (r102 != 1.0f) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L10;
        Bitmap r105 = r100.f294883c.get(Integer.valueOf(r101));
        if (r105 == null) goto L10;
        return r105;
    L10:
        AppHost.Companion r106 = AppHost.f326268a;
        Context r107 = r106.a().getCurrentActivity();
        if (r107 != null) goto L13;
        r107 = r106.getApplication();
    L13:
        Drawable r108 = ContextCompat.getDrawable(r107, r101);
        if (r108 == null) goto L16;
        r108.setAlpha((int) (r102 * 255));
    L16:
        if (r108 != null) goto L18;
        return null;
    L18:
        if ((r108 instanceof BitmapDrawable) == false) goto L25;
        if (r102 == 1.0f) goto L22;
        r103 = false;
    L22:
        if (r103 == false) goto L34;
        r100.f294883c.put(Integer.valueOf(r101), ((BitmapDrawable) r108).getBitmap());
    L34:
        return ((BitmapDrawable) r108).getBitmap();
    L25:
        Bitmap r109 = Bitmap.createBitmap(r108.getIntrinsicWidth(), r108.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas r110 = new Canvas(r109);
        r108.setBounds(0, 0, r110.getWidth(), r110.getHeight());
        r108.draw(r110);
        if (r102 == 1.0f) goto L29;
        r103 = false;
    L29:
        if (r103 == false) goto L35;
        r100.f294883c.put(Integer.valueOf(r101), r109);
    L35:
        return r109;
    L5:
        r104 = false;
        goto L6
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void K7(FragmentManager r100, nr9.g r101, c4 r102) {
        Intrinsics.checkNotNullParameter(r100, "fragmentManager");
        Intrinsics.checkNotNullParameter(r101, "videoPlayData");
        Intrinsics.checkNotNullParameter(r102, "eventParam");
        com.larus.bmhome.video.fragment.b0 r103 = com.larus.bmhome.video.fragment.b0.f315293a;
        os8.b.c r104 = new os8.b.c(r101, r102, true);
        r103.getClass();
        com.larus.bmhome.video.fragment.b0.a(r100, r104);
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final boolean N7(FragmentActivity r100, BotModel r101, String r102) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r101 != null) goto L7;
        return false;
    L7:
        t1a.b r103 = s1a.a.h(r100);
        if (com.larus.bmhome.utils.r.a(r103).f510337c == false) goto L23;
        VoiceCallServiceDelegate r104 = VoiceCallServiceDelegate.f377087a;
        if (r102 != null) goto L13;
        r102 = "";
    L13:
        if (IVoiceCallService.a.a(r104, r101, r102, true, 8) == false) goto L24;
        com.larus.bmhome.instruction.g r105 = (com.larus.bmhome.instruction.g) r103.getAbility(com.larus.bmhome.instruction.g.class);
        if (r105 != null) goto L17;
    L19:
        boolean r106 = false;
    L20:
        if (r106 == true) goto L25;
        return true;
    L25:
        return false;
    L17:
        if (r105.z0() != true) goto L19;
        r106 = true;
        goto L20
    L24:
        return false;
    L23:
        return false;
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final boolean P7(Message r100, Fragment r101, LongClickSource r102) {
        Intrinsics.checkNotNullParameter(r102, "longClickSource");
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r102 != LongClickSource.Thinking) goto L11;
        if (com.larus.bmhome.chat.bean.d.Q0(r100) == false) goto L11;
        return false;
    L11:
        if (z2.f365865a.m3() == true) goto L14;
        return false;
    L14:
        if (StringsKt.isBlank(p(r100)) == false) goto L17;
        return false;
    L17:
        if (com.larus.bmhome.chat.bean.d.G0(r100) == false) goto L19;
    L27:
        boolean r103 = false;
    L28:
        if (r103 == true) goto L34;
        if (com.larus.bmhome.chat.bean.d.z0(r100) == true) goto L34;
        if (m99.a.f(r100) == true) goto L34;
        return false;
    L34:
        if (ve8.c.c(o(r101, r100)) == false) goto L38;
        return true;
    L38:
        return false;
    L19:
        if (com.larus.bmhome.chat.bean.d.k(r100) == false) goto L21;
    L26:
        r103 = true;
        goto L28
    L21:
        if (com.larus.bmhome.chat.bean.d.N(r100) == true) goto L26;
        if (com.larus.bmhome.chat.bean.d.x0(r100) == true) goto L26;
        if (dp8.a.b(r100) == false) goto L27;
        goto L26
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final boolean Q7(FragmentActivity r100, BotModel r101, String r102) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r101 != null) goto L7;
        return false;
    L7:
        t1a.b r103 = s1a.a.h(r100);
        if (com.larus.bmhome.utils.r.a(r103).f510338d == false) goto L23;
        VoiceCallServiceDelegate r104 = VoiceCallServiceDelegate.f377087a;
        if (r102 != null) goto L13;
        r102 = "";
    L13:
        if (IVoiceCallService.a.a(r104, r101, r102, true, 8) == false) goto L24;
        com.larus.bmhome.instruction.g r105 = (com.larus.bmhome.instruction.g) r103.getAbility(com.larus.bmhome.instruction.g.class);
        if (r105 != null) goto L17;
    L19:
        boolean r106 = false;
    L20:
        if (r106 == true) goto L25;
        return true;
    L25:
        return false;
    L17:
        if (r105.z0() != true) goto L19;
        r106 = true;
        goto L20
    L24:
        return false;
    L23:
        return false;
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void c8(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r101, "point");
        ChatMessageCostTrace r103 = ChatMessageCostTrace.f310093a;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r103.getClass();
        ChatMessageCostTrace.h(r100, r101, r102);
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final String g(Integer r100, Integer r101, boolean r102) {
        return ChatControlTrace.f309996b.g(r100, r101, r102);
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final DialogFragment k7(ArrayList<FeedbackMeta> r110, String r111, Bundle r112) {
        FlowFeedbackServiceDelegate r100 = FlowFeedbackServiceDelegate.f343027a;
        String r101 = r112.getString("feedback_request_key");
        if (r101 != null) goto L6;
        r101 = "dislikeDialogClose";
    L6:
        return r100.d(new FlowDislikePanelConfig(r101, r110, r111, r112, Integer.valueOf(r112.getInt("conversation_type")), r112.getBoolean("direct_report_reason", false), true));
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final boolean e8(Context r100, Fragment r110, Message r111, LongClickSource r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "longClickSource");
        return k(r100, r110, r111, r112, null, null);
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void g7(Context r100, ItemTextArrow r101, SpeakerVoice r102, boolean r103) {
        xb8.a.a(r100, r101, r102, false, r103);
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void m7(String r100, String r101, long r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r111, "vid");
        Lazy r102 = com.larus.bmhome.chat.trace.appreciable.y.f310143a;
        Intrinsics.checkNotNullParameter(r100, "localMsgId");
        Lazy r103 = com.larus.bmhome.chat.trace.appreciable.y.f310145c;
        ((Queue) r103.getValue()).add(r100);
        if (((Queue) r103.getValue()).size() <= 50) goto L5;
        ((Queue) r103.getValue()).poll();
    L5:
        com.larus.bmhome.chat.trace.appreciable.f.f310120a.getClass();
        Intrinsics.checkNotNullParameter(r100, "localMessageId");
        Intrinsics.checkNotNullParameter(r101, "path");
        Intrinsics.checkNotNullParameter(r111, "vid");
        if (r100.length() != 0) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        EnsureManager.ensureNotReachHere("task_id is null! path=" + r101 + " vid=" + r111);
        return;
    L11:
        com.larus.bmhome.chat.trace.appreciable.g r105 = new com.larus.bmhome.chat.trace.appreciable.g(r100, r101, r110, r111);
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L14
        com.larus.bmhome.chat.trace.appreciable.f.f310127h.put(r100, r105);     // Catch: Throwable -> L14
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L24;
        ((LinkedHashMap) com.larus.bmhome.chat.trace.appreciable.f.f310127h).clear();
        EnsureManager.ensureNotReachHere("onAsrFailed failed! err=" + r107.getMessage() + " path=" + r101 + " duration=" + r110);
        return;
    L24:
        return;
    L14:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L8:
        r104 = false;
        goto L9
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final boolean F7(Map<String, String> r100, Message r101, int r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        com.larus.bmhome.chat.helper.n0.f303117a.getClass();
        return com.larus.bmhome.chat.helper.n0.c(r100, r101, r102, r103, r104);
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void I7(Fragment r110, com.larus.bmhome.chat.api.b0 r111, st8.a r112, Message r210, final CommonMenu r211) {
        Intrinsics.checkNotNullParameter(r110, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r111, "recyclerView");
        Intrinsics.checkNotNullParameter(r112, "menuAnchor");
        Intrinsics.checkNotNullParameter(r210, "data");
        Intrinsics.checkNotNullParameter(r211, TplType.MENU);
        final ef8.o r100 = new ef8.o(r110, r111, r112);
        Intrinsics.checkNotNullParameter(r210, "data");
        Intrinsics.checkNotNullParameter(r211, "commonMenu");
        z2.f365865a.w3();
        if (r100.f472561d == null) goto L19;
        r100.f472575r = false;
        final ji8.f r101 = new ji8.f(r211, r210);
        r100.f472562e = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.f317270a, r100.f472559b.m(), r211.i(), false, null, new ef8.g(), null, new ef8.h(r100, r101), 44);
        ef8.o.f472557w.add(new WeakReference(r100.f472562e));
        AudioServiceDelegate.f288288a.r0().m(r101);
        r100.f472559b.setBottomReached(false);
        ICoreInputAbility r102 = (ICoreInputAbility) s1a.a.g(r100.f472558a).getAbility(ICoreInputAbility.class);
        va8.o r103 = (va8.o) s1a.a.g(r100.f472558a).getAbility(va8.o.class);
        if (r103 == null) goto L10;
        boolean r104 = true;
        if (r103.w() != true) goto L10;
    L11:
        if (r102 == null) goto L13;
        r102.qp(false);
    L13:
        ef8.o.f472556v = new WeakReference(r100);
        final Ref.IntRef r105 = new Ref.IntRef();
        r105.element = ((int) r100.f472560c.getClickX()) - (r100.f472561d.getWidth() / 2);
        r211.measure(0, 0);
        int r106 = r211.getMeasuredHeight();
        final Ref.IntRef r107 = new Ref.IntRef();
        r107.element = ((int) r100.f472560c.getClickY()) + (r106 / 2);
        View r108 = r100.f472561d;
        Function0 r109 = new ef8.i(r100, r105, r107, r211);
        if (r104 == false) goto L16;
        long r113 = 200;
    L17:
        SafeExtKt.b(r108, r109, r113);
        return;
    L16:
        r113 = 0;
    L10:
        r104 = false;
        goto L11
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void l8(String r100, String r101, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "cvsId");
        Intrinsics.checkNotNullParameter(r111, "scene");
        RepoDispatcher.f307729a.getClass();
        ChatSender r102 = RepoDispatcher.f307732d.f307633e;
        boolean r103 = false;
        if (r111.length() != 0) goto L5;
        boolean r113 = true;
    L6:
        if (r113 == false) goto L8;
        r111 = BrowserDependency.UrlClickType.CARD;
    L8:
        String r104 = r111;
        zd9.h r114 = zd9.h.f571481a;
        if (r112 != null) goto L11;
    L12:
        r103 = true;
    L13:
        if (r103 == false) goto L27;
    L24:
        Object r115 = null;
    L25:
        r102.M(r100, r101, r104, (Map) r115, false, null);
        return;
    L27:
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L17
        r114.getClass();     // Catch: Throwable -> L17
        r115 = Result.m9449constructorimpl(zd9.h.f571482b.fromJson(r112, new e().getType()));     // Catch: Throwable -> L17
    L19:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r115);
        if (r117 == null) goto L23;
        com.larus.im.internal.delegate.c0 r118 = com.larus.im.internal.delegate.c0.f348199b;
        StringBuilder r105 = new StringBuilder("fromJson failed, stack: ");
        Intrinsics.checkNotNullParameter(r117, "<this>");
        r105.append(ExceptionsKt.stackTraceToString(r117));
        r118.e("GsonHolder", r105.toString());
    L23:
        if (Result.m9455isFailureimpl(r115) == false) goto L25;
    L17:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L11:
        if (StringsKt.isBlank(r112) == false) goto L13;
    L5:
        r113 = false;
        goto L6
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void y7(Context r100, double r101, double r102, String r103, Function0<Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        com.larus.bmhome.chat.map.k.f306889a.getClass();
        com.larus.bmhome.chat.map.k.a(r100, r101, r102, r103, r104);
    }

    public static final void j(AIChatServiceImpl r110, Message r111, String r210, String r211, Fragment r212, BotModel r213) {
        if (r213 != null) goto L5;
        r110.getClass();
        BotModel r100 = o(r212, r111);
    L6:
        String r101 = r100.getBotId();
        String r102 = r111.getConversationId();
        if (r102 == null) goto L9;
        Long r103 = StringsKt.toLongOrNull(r102);
    L10:
        Long r104 = r103;
        if (com.larus.bmhome.chat.bean.d.z0(r111) == false) goto L13;
        long r105 = 1;
    L14:
        String r106 = r111.getMessageId();
        r110.getClass();
        String r107 = m(r212, r100);
        boolean r108 = com.larus.bmhome.chat.bean.d.Q0(r111);
        boolean r109 = com.larus.bmhome.chat.bean.d.f0(r111);
        boolean r112 = com.larus.bmhome.chat.bean.d.K0(r111);
        tx9.c0.G(r101, r107, "long_press_answer", r104, Long.valueOf(r105), r106, r210, null, Boolean.valueOf(r108), r211, null, Boolean.valueOf(r109), Boolean.valueOf(r112), null, 821856);
        return;
    L13:
        r105 = 0;
        goto L14
    L9:
        r103 = null;
        goto L10
    L5:
        r110.getClass();
        r100 = r213;
        goto L6
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final boolean S7(Context r100, Fragment r101, Message r110, BotModel r111, LongClickSource r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "botModel");
        Intrinsics.checkNotNullParameter(r112, "longClickSource");
        return k(r100, r101, r110, r112, r111, r113);
    }

    public final boolean k(Context r510, Fragment r511, Message r512, LongClickSource r513, BotModel r514, String r610) {
        Message r100 = r512;
        boolean r101 = false;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (P7(r100, r511, r513) == true) goto L8;
        return false;
    L8:
        IFlowSdkDepend r102 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r102 == null) goto L11;
        r102.a0();
        com.larus.home.impl.sdk.g r103 = com.larus.home.impl.sdk.g.f346177a;
    L11:
        AudioServiceDelegate r104 = AudioServiceDelegate.f288288a;
        if (r104.F().b() == false) goto L16;
        c68.b.d("AIChatServiceImpl", "[TTS][DORA_IS_WAKE_UP] Dora is wake up, return");
        t19.s r105 = t19.s.f544207a;
        AppHost.Companion r106 = AppHost.f326268a;
        Application r107 = r106.getApplication();
        String r108 = r106.getApplication().getString(R.string.larus_disable_voice_limit);
        r105.getClass();
        t19.s.t(r107, r108);
        return true;
    L16:
        if (NetworkUtils.isNetworkAvailable(r510) == true) goto L19;
        FLogger.f375446a.e("AIChatServiceImpl", "[TTS_FAIL][NO_NETWORK][2][msgId:" + r512.getMessageId() + "][localIndex:" + r512.getLocalIndex() + "][status:" + r512.getMessageStatus() + "][statusLocal:" + r512.getMessageStatusLocal() + ']');
        t19.s.f544207a.getClass();
        t19.s.s(r510, R.string.larus_tts_loading_failed_toast);
        return true;
    L19:
        PlayStateEnum r109 = r104.r0().l();
        if (r109 == null) goto L22;
        int r110 = r109.getState();
    L23:
        String r111 = null;
        if (r610 != null) goto L26;
    L32:
        com.larus.bmhome.chat.component.cvs.y r112 = n(r511);
        if (r112 == null) goto L45;
        wc9.e r113 = r112.h();
        if (r113 == null) goto L45;
        String r114 = r113.f559198a;
        if (r114 == null) goto L45;
        if ((!StringsKt.isBlank(r114)) == true) goto L42;
        r114 = null;
    L42:
        if (r114 == null) goto L45;
        r111 = r114;
    L51:
        String r115 = r111;
    L52:
        if (r115 != null) goto L54;
    L55:
        r101 = true;
    L56:
        if (r101 == false) goto L58;
    L60:
        Message r116 = r100;
        if (r110 != PlayStateEnum.PLAY_STATE_PLAYING.getState()) goto L63;
    L64:
        RepoDispatcher.f307729a.getClass();
        if (Intrinsics.areEqual(RepoDispatcher.f307732d.f307632d.f307840d.o6(), r116.getMessageId()) == false) goto L67;
        l(r511, new AIChatServiceImpl$stopDoubaoMessageTts$1(this, r116, r511, r514, null));
    L77:
        return true;
    L67:
        if (r514 != null) goto L69;
        BotModel r117 = o(r511, r116);
    L70:
        String r118 = p(r116);
        if (ve8.c.c(r117) == false) goto L77;
        if (StringsKt.isBlank(r118) == false) goto L76;
        FLogger.f375446a.i("AIChatServiceImpl", "[TTS] skip Doubao Lark message tts: empty content, msgId=" + r116.getMessageId() + '.');
        goto L77
    L76:
        TtsGuideDelegate.f289898b.a("long_press_play");
        l(r511, new AIChatServiceImpl$startDoubaoMessageTts$1(this, r116, r511, r117, r118, null));
        goto L77
    L69:
        r117 = r514;
        goto L70
    L63:
        if (r110 != PlayStateEnum.PLAY_STATE_PREPARE.getState()) goto L67;
    L58:
        if (Intrinsics.areEqual(r115, r512.getConversationId()) == true) goto L60;
        r100 = Message.copy$default(r512, r115, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -2, 31, null);
        goto L60
    L54:
        if (StringsKt.isBlank(r115) == false) goto L56;
    L45:
        if (r112 == null) goto L51;
        String r119 = r112.Y1();
        if (r119 == null) goto L51;
        if ((!StringsKt.isBlank(r119)) == false) goto L51;
        r111 = r119;
        goto L51
    L26:
        if ((!StringsKt.isBlank(r610)) == false) goto L28;
        String r120 = r610;
    L29:
        if (r120 == null) goto L32;
        r115 = r120;
        goto L52
    L28:
        r120 = null;
        goto L29
    L22:
        r110 = 0;
        goto L23
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final Dialog x7(FragmentActivity r110, String r111, boolean r112, String r113, Function0 r114, Function0 r115) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "avatarUrl");
        return new BotAvatarViewerDialog(r110, r111, true, r112, r113, r114, r115);
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void z7(Context r100, ItemTextArrow r101, SpeakerVoice r102, boolean r103, EditPos r104, boolean r105) {
        xb8.a.b(r100, r101, r102, r103, r104, r105);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.larus.bmhome.a, ug9.a] */
    @Override // com.larus.platform.spi.IAIChatService
    public final void Z7(final Context r100, String r101, String r102, int r103, String r104, List r105, final com.larus.xbridge.custom.v r106) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "schema");
        Intrinsics.checkNotNullParameter(r102, "cvsId");
        Intrinsics.checkNotNullParameter(r104, "enterMethod");
        Intrinsics.checkNotNullParameter(r105, "selectedMsgIds");
        Intrinsics.checkNotNullParameter(r106, "callback");
        if (com.larus.utils.o0.d(r102) == false) goto L12;
        ?? r107 = new com.larus.bmhome.a(r106, this, r100);
        if ((r100 instanceof ug9.b) == false) goto L7;
        ug9.b r108 = (ug9.b) r100;
    L8:
        if (r108 == 0) goto L10;
        r108.I0(r107);
    L10:
        this.f294882b = r107;
        com.bytedance.router.i r109 = SmartRouter.buildRoute(r100, r101);
        r109.f267554c.putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("argConversationId", r102), TuplesKt.to("enter_method", r104), TuplesKt.to("argChatPageMode", Integer.valueOf(r103))}));
        r109.f267554c.putStringArrayListExtra("argChatMsgIds", new ArrayList(r105));
        r109.e(100);
        return;
    L7:
        r108 = 0;
        goto L8
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final View.OnLongClickListener C7(Message r110, q0 r111, q0.a r112, boolean r113, com.larus.bmhome.chat.markdown.code.f r114, com.larus.bmhome.chat.markdown.code.g r115, com.larus.bmhome.chat.markdown.code.h r116, com.larus.bmhome.chat.markdown.code.i r117) {
        Intrinsics.checkNotNullParameter(r110, "data");
        return new w0(new com.larus.bmhome.chat.layout.holder.helper.j(r110, r111, r112, r113, r115, r116, r114, r117));
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final sr9.e0 G7(Fragment r110, RecyclerView r111, q0 r112, Object r113, st8.a r114, q0.a r210, Message r211, Function0<Message> r212, boolean r213, lw8.l r214, LongClickSource r215) {
        Intrinsics.checkNotNullParameter(r110, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r111, "hostView");
        Intrinsics.checkNotNullParameter(r112, "adapter");
        Intrinsics.checkNotNullParameter(r211, "data");
        Intrinsics.checkNotNullParameter(r212, "childMsgGetter");
        Intrinsics.checkNotNullParameter(r215, "longClickSource");
        if ((r113 instanceof CustomMarkdownTextView) == false) goto L5;
        CustomMarkdownTextView r100 = (CustomMarkdownTextView) r113;
    L7:
        return new PopMenuPanelTrigger(r110, r111, r112, r100, r114, r210, r211, r212, r213, r214, r215);
    L5:
        r100 = null;
        goto L7
    }

    @Override // com.larus.platform.spi.IAIChatService
    public final void W7(FragmentManager r110, Message r111, RecommendFrom r112, String r113, int r114, String r115, String r210, String r211, SearchMobParam r212, String r213, Integer r214) {
        Intrinsics.checkNotNullParameter(r110, "fm");
        Intrinsics.checkNotNullParameter(r111, "msg");
        Intrinsics.checkNotNullParameter(r115, "conversationId");
        Intrinsics.checkNotNullParameter(r210, "severIndex");
        ChatFragmentDelegateDialogExtKt.d(r110, CollectionsKt.mutableListOf(new Message[]{r111}), r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }
}
