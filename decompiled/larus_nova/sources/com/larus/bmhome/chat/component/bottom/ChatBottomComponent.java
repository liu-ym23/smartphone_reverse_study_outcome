package com.larus.bmhome.chat.component.bottom;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.gson.Gson;
import com.larus.asr.e2;
import com.larus.asr.handsfree.AsrInputMode;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IFlowTtsClientService;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.bot.health.IChatBotHealthService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.b4;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.chat.component.bottom.core.g9;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.chat.d4;
import com.larus.bmhome.chat.input.ChatInputService;
import com.larus.bmhome.chat.larkforward.IChatLarkForwardService;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.model.strategy.ChatSendUtils;
import com.larus.bmhome.chat.model.strategy.block.ClientMetaPermissionHelper;
import com.larus.bmhome.chat.trace.ChatRenderTrace;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.upload.ResourceUploader;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.bmhome.view.actionbar.api.ChatUIBlockConfig;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.TouchInterceptingView;
import com.larus.im.bean.bot.BotModel;
import com.larus.nova.R;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.SafeExtKt;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.spi.chat.IObricChatUIService;
import com.obric.assistant.spi.chat.ObricChatUIDelegate;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.tools.CukaieConstants$DataLoadType;
import com.ss.ttvideoengine.DataLoaderHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONArray;
import org.json.JSONObject;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u009c\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0004\u0092\u0001\u0098\u0001\u0018\u0000 \u008f\u00022\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0004\u008f\u0002\u0090\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u009f\u0001\u001a\u0004\u0018\u00010w2\u0007\u0010 \u0001\u001a\u00020wH\u0096@¢\u0006\u0003\u0010¡\u0001J\t\u0010¢\u0001\u001a\u00020wH\u0002J\u000b\u0010£\u0001\u001a\u0004\u0018\u00010rH\u0002J\n\u0010¤\u0001\u001a\u00030\u0096\u0001H\u0016J\n\u0010¥\u0001\u001a\u00030\u0096\u0001H\u0002J\u0014\u0010¦\u0001\u001a\u00030\u0096\u00012\b\u0010§\u0001\u001a\u00030¨\u0001H\u0016J\u000b\u0010©\u0001\u001a\u0004\u0018\u00010gH\u0016J\u000b\u0010ª\u0001\u001a\u0004\u0018\u00010iH\u0016J\t\u0010¬\u0001\u001a\u00020\u0007H\u0016J!\u0010\u00ad\u0001\u001a\u00030\u0096\u00012\n\u0010®\u0001\u001a\u0005\u0018\u00010¨\u00012\t\b\u0002\u0010¯\u0001\u001a\u00020kH\u0002J(\u0010°\u0001\u001a\u00030\u0096\u00012\b\u0010®\u0001\u001a\u00030¨\u00012\u0007\u0010±\u0001\u001a\u00020k2\t\b\u0002\u0010¯\u0001\u001a\u00020kH\u0002J\u001d\u0010²\u0001\u001a\u00020k2\b\u0010³\u0001\u001a\u00030´\u00012\b\u0010®\u0001\u001a\u00030¨\u0001H\u0002J\u001d\u0010µ\u0001\u001a\u00020k2\b\u0010³\u0001\u001a\u00030´\u00012\b\u0010®\u0001\u001a\u00030¨\u0001H\u0002J\n\u0010¶\u0001\u001a\u00030\u0096\u0001H\u0002J\n\u0010·\u0001\u001a\u00030\u0096\u0001H\u0002J\n\u0010¸\u0001\u001a\u00030\u0096\u0001H\u0016J\n\u0010¹\u0001\u001a\u00030\u0096\u0001H\u0016J\n\u0010º\u0001\u001a\u00030\u0096\u0001H\u0016J\n\u0010»\u0001\u001a\u00030\u0096\u0001H\u0016J\n\u0010¼\u0001\u001a\u00030\u0096\u0001H\u0016J\n\u0010½\u0001\u001a\u00030\u0096\u0001H\u0016J\n\u0010¾\u0001\u001a\u00030\u0096\u0001H\u0016J\n\u0010¿\u0001\u001a\u00030\u0096\u0001H\u0002J\n\u0010À\u0001\u001a\u00030\u0096\u0001H\u0002J\n\u0010Á\u0001\u001a\u00030\u0096\u0001H\u0002J\n\u0010Â\u0001\u001a\u00030\u0096\u0001H\u0002J\n\u0010Ã\u0001\u001a\u00030\u0096\u0001H\u0002J\n\u0010Ä\u0001\u001a\u00030\u0096\u0001H\u0002J\n\u0010Å\u0001\u001a\u00030\u0096\u0001H\u0002J\u0012\u0010Æ\u0001\u001a\u00020k2\u0007\u0010Ç\u0001\u001a\u00020wH\u0002J\u0012\u0010È\u0001\u001a\u00020k2\u0007\u0010Ç\u0001\u001a\u00020wH\u0002J\u0013\u0010É\u0001\u001a\u00030\u0096\u00012\u0007\u0010 \u0001\u001a\u00020wH\u0002J\n\u0010Ê\u0001\u001a\u00030\u0096\u0001H\u0002J\n\u0010Ë\u0001\u001a\u00030\u0096\u0001H\u0002J\f\u0010Ì\u0001\u001a\u0005\u0018\u00010Í\u0001H\u0016J\u0014\u0010Î\u0001\u001a\u00030\u0096\u00012\b\u0010Ï\u0001\u001a\u00030Ð\u0001H\u0002J\u0015\u0010Ñ\u0001\u001a\u00030\u0096\u00012\t\b\u0002\u0010Ò\u0001\u001a\u00020kH\u0002J\n\u0010Ó\u0001\u001a\u00030\u0096\u0001H\u0002J\n\u0010Ô\u0001\u001a\u00030\u0096\u0001H\u0002J\u0015\u0010Õ\u0001\u001a\u00030\u0096\u00012\t\b\u0002\u0010Ö\u0001\u001a\u00020kH\u0002J\u000b\u0010×\u0001\u001a\u0004\u0018\u00010zH\u0002J\u001c\u0010Ø\u0001\u001a\u00030\u0096\u00012\u0007\u0010Ù\u0001\u001a\u00020z2\u0007\u0010Ú\u0001\u001a\u00020\u0007H\u0002J\u001c\u0010Û\u0001\u001a\u00030\u0096\u00012\u0007\u0010Ù\u0001\u001a\u00020z2\u0007\u0010Ú\u0001\u001a\u00020\u0007H\u0002J\u0013\u0010Ü\u0001\u001a\u00030Ý\u00012\u0007\u0010Ù\u0001\u001a\u00020zH\u0002J¯\u0001\u0010Þ\u0001\u001a\u009e\u0001\u0012\u0004\u0012\u00020\u0007\u0012C\u0012A\u0012\u0017\u0012\u00150á\u0001¢\u0006\u000f\bâ\u0001\u0012\n\bã\u0001\u0012\u0005\b\b(ä\u0001\u0012\u0017\u0012\u00150å\u0001¢\u0006\u000f\bâ\u0001\u0012\n\bã\u0001\u0012\u0005\b\b(æ\u0001\u0012\u0005\u0012\u00030ç\u00010à\u0001j\u0003`è\u00010ß\u0001jN\u0012\u0004\u0012\u00020\u0007\u0012C\u0012A\u0012\u0017\u0012\u00150á\u0001¢\u0006\u000f\bâ\u0001\u0012\n\bã\u0001\u0012\u0005\b\b(ä\u0001\u0012\u0017\u0012\u00150å\u0001¢\u0006\u000f\bâ\u0001\u0012\n\bã\u0001\u0012\u0005\b\b(æ\u0001\u0012\u0005\u0012\u00030ç\u00010à\u0001j\u0003`è\u0001`é\u00012\u0007\u0010Ù\u0001\u001a\u00020zH\u0002J\u0013\u0010ê\u0001\u001a\u00030¨\u00012\u0007\u0010Ù\u0001\u001a\u00020zH\u0002J\u001b\u0010ë\u0001\u001a\u00020\u00072\u0007\u0010ì\u0001\u001a\u00020\u00072\u0007\u0010í\u0001\u001a\u00020\u0007H\u0002J\u0013\u0010î\u0001\u001a\u00030\u0096\u00012\u0007\u0010Ù\u0001\u001a\u00020zH\u0002J\u0013\u0010ï\u0001\u001a\u00020k2\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0002J4\u0010ò\u0001\u001a\n\u0012\u0005\u0012\u00030ô\u00010ó\u00012\u0007\u0010Ù\u0001\u001a\u00020z2\u000e\u0010õ\u0001\u001a\t\u0012\u0004\u0012\u00020w0ó\u00012\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0002JS\u0010ö\u0001\u001a\u00030\u0096\u00012\b\u0010ð\u0001\u001a\u00030ñ\u00012\u0014\u0010÷\u0001\u001a\u000f\u0012\u0004\u0012\u00020w\u0012\u0004\u0012\u00020w0ø\u00012\u0016\u0010ù\u0001\u001a\u0011\u0012\u0004\u0012\u00020w\u0012\u0004\u0012\u00020w\u0018\u00010ø\u00012\u000f\u0010ú\u0001\u001a\n\u0012\u0005\u0012\u00030ô\u00010û\u0001H\u0002J \u0010ü\u0001\u001a\u000f\u0012\u0004\u0012\u00020w\u0012\u0004\u0012\u00020w0ø\u00012\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0002J4\u0010ý\u0001\u001a\u00030\u0096\u00012\u0007\u0010Ù\u0001\u001a\u00020z2\u000e\u0010õ\u0001\u001a\t\u0012\u0004\u0012\u00020w0ó\u00012\u000f\u0010ú\u0001\u001a\n\u0012\u0005\u0012\u00030ô\u00010ó\u0001H\u0002J\"\u0010þ\u0001\u001a\u0011\u0012\u0004\u0012\u00020w\u0012\u0004\u0012\u00020w\u0018\u00010ø\u00012\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0002J\u0013\u0010ÿ\u0001\u001a\u00030\u0096\u00012\u0007\u0010\u0080\u0002\u001a\u00020kH\u0002J\n\u0010\u0081\u0002\u001a\u00030\u0096\u0001H\u0002J\u0012\u0010\u0082\u0002\u001a\u00020k2\u0007\u0010\u0083\u0002\u001a\u00020kH\u0016J\n\u0010\u0085\u0002\u001a\u00030\u0096\u0001H\u0002J\n\u0010\u0086\u0002\u001a\u00030\u0096\u0001H\u0002J\n\u0010\u0087\u0002\u001a\u00030\u0096\u0001H\u0002J\n\u0010\u0088\u0002\u001a\u00030\u0096\u0001H\u0002J&\u0010\u0089\u0002\u001a\u00030\u0096\u00012\u0011\u0010§\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010¨\u00010\u008a\u00022\u0007\u0010\u008b\u0002\u001a\u00020rH\u0002J\u0013\u0010\u008c\u0002\u001a\u00030\u0096\u00012\u0007\u0010\u008b\u0002\u001a\u00020rH\u0002J\n\u0010\u008d\u0002\u001a\u00030\u0096\u0001H\u0016J\n\u0010\u008e\u0002\u001a\u00030\u0096\u0001H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010!\u001a\u0004\u0018\u00010\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b#\u0010$R\u001d\u0010&\u001a\u0004\u0018\u00010'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u001b\u001a\u0004\b(\u0010)R\u001d\u0010+\u001a\u0004\u0018\u00010,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u001b\u001a\u0004\b-\u0010.R\u001d\u00100\u001a\u0004\u0018\u0001018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u001b\u001a\u0004\b2\u00103R\u001d\u00105\u001a\u0004\u0018\u0001068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u001b\u001a\u0004\b7\u00108R\u001d\u0010:\u001a\u0004\u0018\u00010;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u001b\u001a\u0004\b<\u0010=R\u001d\u0010?\u001a\u0004\u0018\u00010@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u001b\u001a\u0004\bA\u0010BR\u001d\u0010D\u001a\u0004\u0018\u00010E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\u001b\u001a\u0004\bF\u0010GR\u001d\u0010I\u001a\u0004\u0018\u00010J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u001b\u001a\u0004\bK\u0010LR\u0016\u0010N\u001a\u0004\u0018\u00010O8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bP\u0010QR\u001d\u0010R\u001a\u0004\u0018\u00010S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\u001b\u001a\u0004\bT\u0010UR\u001d\u0010W\u001a\u0004\u0018\u00010X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\u001b\u001a\u0004\bY\u0010ZR\u001d\u0010\\\u001a\u0004\u0018\u00010]8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010\u001b\u001a\u0004\b^\u0010_R\u001d\u0010a\u001a\u0004\u0018\u00010b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\be\u0010\u001b\u001a\u0004\bc\u0010dR\u0010\u0010f\u001a\u0004\u0018\u00010gX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010h\u001a\u0004\u0018\u00010iX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020kX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020kX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020kX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010n\u001a\n\u0012\u0004\u0012\u00020p\u0018\u00010oX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010q\u001a\n\u0012\u0004\u0012\u00020r\u0018\u00010oX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020kX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020kX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020kX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010v\u001a\u0004\u0018\u00010wX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020kX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010y\u001a\u0004\u0018\u00010zX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010{\u001a\u0004\u0018\u00010wX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020kX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010}\u001a\u0004\u0018\u00010~X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u007fR\u0011\u0010\u0080\u0001\u001a\u0004\u0018\u00010wX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0085\u0001\u0010\u001b\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\"\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008a\u0001\u0010\u001b\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\"\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008f\u0001\u0010\u001b\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R\u000f\u0010\u0090\u0001\u001a\u00020kX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0091\u0001\u001a\u00030\u0092\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0093\u0001R\u001d\u0010\u0094\u0001\u001a\u0010\u0012\u0004\u0012\u00020k\u0012\u0005\u0012\u00030\u0096\u00010\u0095\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0097\u0001\u001a\u00030\u0098\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0099\u0001R\"\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u009e\u0001\u0010\u001b\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\u000f\u0010«\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0084\u0002\u001a\u0005\u0018\u00010¨\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0091\u0002"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/ChatBottomComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "<init>", "()V", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "binding", "Lcom/larus/bmhome/databinding/LarusPageChatBinding;", "getBinding", "()Lcom/larus/bmhome/databinding/LarusPageChatBinding;", "bottomViewModel", "Lcom/larus/bmhome/chat/component/bottom/ChatBottomComponentViewModel;", "getBottomViewModel", "()Lcom/larus/bmhome/chat/component/bottom/ChatBottomComponentViewModel;", "bottomViewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "fragmentAbility", "Lcom/larus/bmhome/chat/component/IChatFragmentAbility;", "getFragmentAbility", "()Lcom/larus/bmhome/chat/component/IChatFragmentAbility;", "fragmentAbility$delegate", "Lkotlin/Lazy;", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "attachmentPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentPanelAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "instructionLogicAbility", "Lcom/larus/bmhome/instruction/IInstructionLogicAbility;", "getInstructionLogicAbility", "()Lcom/larus/bmhome/instruction/IInstructionLogicAbility;", "instructionLogicAbility$delegate", "referenceMsgAbility", "Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "getReferenceMsgAbility", "()Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "referenceMsgAbility$delegate", "suggestedActionAbility", "Lcom/larus/bmhome/chat/action/ISuggestedActionAbility;", "getSuggestedActionAbility", "()Lcom/larus/bmhome/chat/action/ISuggestedActionAbility;", "suggestedActionAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "chatMessageAbility", "Lcom/larus/bmhome/chat/component/IChatMessageAbility;", "getChatMessageAbility", "()Lcom/larus/bmhome/chat/component/IChatMessageAbility;", "chatMessageAbility$delegate", "collectionAbility", "Lcom/larus/bmhome/chat/component/collection/IChatCollectMessageAbility;", "getCollectionAbility", "()Lcom/larus/bmhome/chat/component/collection/IChatCollectMessageAbility;", "caseAbility", "Lcom/larus/bmhome/chat/component/showcase/IChatCaseMessageAbility;", "getCaseAbility", "()Lcom/larus/bmhome/chat/component/showcase/IChatCaseMessageAbility;", "caseAbility$delegate", "shareAbility", "Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "getShareAbility", "()Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "shareAbility$delegate", "chatAwemeFeedAbility", "Lcom/larus/bmhome/double_post/drag_panel/IChatAwemeFeedAbility;", "getChatAwemeFeedAbility", "()Lcom/larus/bmhome/double_post/drag_panel/IChatAwemeFeedAbility;", "chatAwemeFeedAbility$delegate", "chatBottomCombineAbility", "Lcom/obric/assistant/ability/chat/bottom/IObricChatBottomAbility;", "getChatBottomCombineAbility", "()Lcom/obric/assistant/ability/chat/bottom/IObricChatBottomAbility;", "chatBottomCombineAbility$delegate", "chatDraft", "Lcom/larus/bmhome/chat/model/ChatDraft;", "chatUsuallyConfig", "Lcom/larus/bmhome/chat/model/ChatUsuallyConfig;", "isFirstTime", "", "isFirstTimeSendAutoSearchText", "shouldShowImeOnce", "onConversationOrTypeChanged", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility$ChangeListener;", "Lcom/larus/im/bean/conversation/Conversation;", "onLiveBotChanged", "Lcom/larus/im/bean/bot/BotModel;", "isSendPushQuestion", "isBanHideImeOnEnter", "pendingShowContinueTalkFlag", DBDefinition.TASK_ID, "", "forbiddenContinueTalk", "humanMergeForwardInfo", "Lcom/larus/bmhome/chat/component/bottom/ChatBottomComponent$HumanMergeForwardInfo;", "lastRestoredTaskModeDraftIdentity", "shouldDeferEntryDraftReplacement", "entryDraftReplacementActionTime", "", "Ljava/lang/Long;", "pendingRouteQueryPrefillText", "doubaoForwardService", "Lcom/larus/bmhome/chat/larkforward/IChatLarkForwardService;", "getDoubaoForwardService", "()Lcom/larus/bmhome/chat/larkforward/IChatLarkForwardService;", "doubaoForwardService$delegate", "uiBlockAbility", "Lcom/larus/bmhome/view/actionbar/api/IChatUIBlockAbility;", "getUiBlockAbility", "()Lcom/larus/bmhome/view/actionbar/api/IChatUIBlockAbility;", "uiBlockAbility$delegate", "skillAbility", "Lcom/larus/bmhome/chat/component/skill/ISkillAbility;", "getSkillAbility", "()Lcom/larus/bmhome/chat/component/skill/ISkillAbility;", "skillAbility$delegate", "uiBlockChangeListenerRegistered", "uiBlockChangeListener", "com/larus/bmhome/chat/component/bottom/ChatBottomComponent$uiBlockChangeListener$1", "Lcom/larus/bmhome/chat/component/bottom/ChatBottomComponent$uiBlockChangeListener$1;", "inputFocusChangeListener", "Lkotlin/Function1;", "", "sendParamsPreloadListener", "com/larus/bmhome/chat/component/bottom/ChatBottomComponent$sendParamsPreloadListener$1", "Lcom/larus/bmhome/chat/component/bottom/ChatBottomComponent$sendParamsPreloadListener$1;", "chatDoubleTabAbility", "Lcom/larus/bmhome/chat/component/doubletab/IChatDoubleTabAbility;", "getChatDoubleTabAbility", "()Lcom/larus/bmhome/chat/component/doubletab/IChatDoubleTabAbility;", "chatDoubleTabAbility$delegate", "queryUrl", "text", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConversationId", "currentBot", WidgetCostModule.TYPE_ON_CREATE, "attachComponent", "onViewCreated", "view", "Landroid/view/View;", "getChatDraft", "getChatUsuallyConfig", "isAddedBottomSpace", "getBottomViewSpace", "adjustBottomViewBottomSpace", "bottomView", "smooth", "adjustBottomViewBottomSpaceInternal", "isNavigationBarVisible", "isNoNeedAddBottomSpace", "insets", "Landroid/view/WindowInsets;", "isNavigationBarVisibleFinal", "disableUserInteract", "enableUserInteract", "afterViewBind", "onAttach", "onResume", "onPause", "onStop", "onFragmentViewDestroyed", LiveCommonConstants.REASON_ON_DEDTROY, "cancelAllAttachmentUploadingTask", "registerBubbleBannerInputFocusDismiss", "dismissBubbleBannerOnInputFocus", "trySaveDraft", "tryAttachInputViewToFloatSlot", "trySendAutoSearchText", "handlePushQuestion", "shouldDowngradeRouteQueryAutoSend", "key", "shouldDowngradePushQuestion", "prefillRouteQueryText", "observeConversationChanged", "observerBotChanged", "inputView", "Landroid/widget/FrameLayout;", "setParentTrackNode", "node", "Lcom/ixigua/lib/track/ITrackNode;", "updateForChatDraft", "updateDraftIdentity", "setInputText", "setupHumanMergeForwardAsk", "prepareHumanMergeForwardInput", "showIme", "parseHumanMergeForwardInfo", "showHumanMergeForwardCard", "info", DBDefinition.RETRY_COUNT, "retryShowHumanMergeForwardCard", "buildHumanMergeForwardResourceItem", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "buildHumanMergeForwardResourceRender", "Ljava/util/HashMap;", "Lkotlin/Function2;", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;", "Lkotlin/ParameterName;", "name", "config", "Landroid/view/ViewGroup;", "parent", "Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder;", "Lcom/larus/bmhome/view/resourcebar/bean/CustomResourceViewHolderBuilder;", "Lkotlin/collections/HashMap;", "buildHumanMergeForwardCard", "getThemeColor", "attrResId", "defaultColorResId", "openHumanMergeForwardDetail", "sendHumanMergeForwardIfNeeded", "params", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "buildHumanMergeForwardStrategies", "", "Lcom/larus/bmhome/chat/bean/ISendMessageStrategy;", "msgIds", "collectHumanMergeForwardAttachmentStrategies", "messageExt", "", "messageBizExt", "strategies", "", "buildHumanMergeForwardExt", "registerHumanMergeForwardTrace", "buildHumanMergeForwardBizExt", "clearHumanMergeForwardInfo", "removeCache", "registerKeyBoardEvents", "refreshBottomVisibility", "restoreModeDraft", "inputBarReplacementView", "refreshInputBarReplacementView", "clearInputBarReplacementView", "refreshInputBarOverlayView", "hideInputBarOverlayView", "tryShowBottomHealthDialog", "Ljava/lang/ref/WeakReference;", "newBot", "setupBottomDialog", "updatePendingShowContinueTalkFlag", "refreshContinueTalkBtnVisibility", "Companion", "HumanMergeForwardInfo", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatBottomComponent extends BaseContentWidget implements p1 {
    public static final /* synthetic */ int L0 = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public com.larus.bmhome.chat.model.n D;
    public com.larus.bmhome.chat.model.b0 E;
    public boolean F;
    public boolean G;
    public b1 H;
    public hk9.a H0;
    public c1 I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f297947J;
    public boolean K;
    public boolean L;
    public String M;
    public boolean N;
    public b O;
    public String P;
    public boolean Q;
    public Long R;
    public String S;
    public final Lazy T;
    public final Lazy U;
    public final Lazy V;
    public boolean W;
    public final i X;
    public final com.larus.bmhome.chat.component.bottom.d Y;
    public final d Z;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final Lazy f297948k0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f297949m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.larus.ui.arch.vm.internal.l f297950n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f297951o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f297952p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f297953p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f297954q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f297955r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f297956s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f297957t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f297958u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f297959v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f297960w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f297961x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f297962y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f297963z;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f297964a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f297965b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f297966c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f297967d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f297968e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f297969f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f297964a, r101.f297964a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f297965b, r101.f297965b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f297966c, r101.f297966c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f297967d, r101.f297967d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f297968e, r101.f297968e) == true) goto L24;
            return false;
        L24:
            if (this.f297969f == r101.f297969f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f297964a.hashCode() * 31) + this.f297965b.hashCode()) * 31;
            String r101 = this.f297966c;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f297967d;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return ((((r104 + r102) * 31) + this.f297968e.hashCode()) * 31) + this.f297969f;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "HumanMergeForwardInfo(title=" + this.f297964a + ", subMsgIds=" + this.f297965b + ", messageCacheKey=" + this.f297966c + ", forwardChatId=" + this.f297967d + ", chatType=" + this.f297968e + ", isLarkMsg=" + this.f297969f + ')';
        }

        public b(String r100, List<String> r101, String r102, String r103, String r104, int r105) {
            Intrinsics.checkNotNullParameter(r100, "title");
            Intrinsics.checkNotNullParameter(r101, "subMsgIds");
            Intrinsics.checkNotNullParameter(r104, "chatType");
            this.f297964a = r100;
            this.f297965b = r101;
            this.f297966c = r102;
            this.f297967d = r103;
            this.f297968e = r104;
            this.f297969f = r105;
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f297973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ChatBottomComponent f297974b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f297975c;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            ViewTreeObserver r100 = this.f297973a.getViewTreeObserver();
            if (r100 == null) goto L6;
            r100.removeOnGlobalLayoutListener(this);
        L6:
            if (Build.VERSION.SDK_INT < 23) goto L48;
            WindowInsets r101 = this.f297973a.getRootWindowInsets();
            if (r101 == null) goto L49;
            ChatBottomComponent r102 = this.f297974b;
            View r103 = this.f297973a;
            boolean r104 = this.f297975c;
            FLogger r105 = FLogger.f375446a;
            r105.i("ChatBottomComponent", "rootWindowInsets onApplyWindowInsets called");
            int r106 = ChatBottomComponent.L0;
            r102.getClass();
            boolean r107 = false;
            if (com.larus.utils.m0.d(r101) == false) goto L12;
        L15:
            boolean r108 = true;
        L16:
            IObricChatUIService r109 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
            if (r109 == null) goto L21;
            Boolean r110 = r109.f(r103);
            if (r110 == null) goto L21;
            boolean r111 = r110.booleanValue();
        L22:
            r105.i("ChatBottomComponent", "isNavigationBarVisibleFinal isNavigationBarVisible=" + r108 + " isViewMeetScreenBottom=" + r111);
            if (ObricChatUIDelegate.f392858b.m() == false) goto L26;
            if (r108 == false) goto L26;
        L28:
            boolean r112 = true;
        L30:
            if (r112 == true) goto L45;
            va8.o r113 = r102.C3();
            if (r113 != null) goto L34;
        L36:
            boolean r114 = false;
        L37:
            if (r114 == false) goto L45;
            va8.o r115 = r102.C3();
            if (r115 != null) goto L41;
        L43:
            boolean r116 = false;
        L44:
            if (r116 == true) goto L45;
        L46:
            ChatBottomComponent.Y2(r102, r103, r107, r104);
            return;
        L41:
            if (r115.w() != true) goto L43;
            r116 = true;
            goto L44
        L34:
            if (r113.e60() != 0) goto L36;
            r114 = true;
        L45:
            r107 = true;
        L26:
            if (r108 == false) goto L29;
            if (r111 == false) goto L28;
        L29:
            r112 = false;
        L21:
            r111 = com.larus.utils.m0.e(r103);
            goto L22
        L12:
            if (ObricFeatureServiceDelegate.f387839b.c() == true) goto L15;
            r108 = false;
            goto L16
        L49:
            return;
        }

        public c(View r100, ChatBottomComponent r101, boolean r102) {
            this.f297973a = r100;
            this.f297974b = r101;
            this.f297975c = r102;
        }
    }

    public static final class d implements ICoreInputAbility.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatBottomComponent f297976a;

        @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility.d
        public final void b(ICoreInputAbility.OnSendParams r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
        }

        @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility.d
        public final void a() {
            ClientMetaPermissionHelper.c();
            ChatSendUtils r100 = ChatSendUtils.f307932a;
            ChatBottomComponent r101 = this.f297976a;
            int r102 = ChatBottomComponent.L0;
            String r103 = r101.D3();
            BotModel r104 = this.f297976a.p3();
            if (r104 == null) goto L5;
            String r105 = r104.getBotId();
        L6:
            r100.getClass();
            ChatSendUtils.q(r103, r105, null);
            com.larus.bmhome.chat.model.n r106 = this.f297976a.D;
            if (r106 == null) goto L9;
            String r107 = r106.f307540b;
        L10:
            AccountService r108 = AccountService.f365697a;
            if (r108.isLogin().booleanValue() == true) goto L25;
            z2 r109 = z2.f365865a;
            if (z2.c4() == true) goto L15;
            return;
        L15:
            if (Intrinsics.areEqual(r107, "__mobile_new_session_mode_draft_chat__") == false) goto L17;
        L18:
            com.larus.bmhome.chat.model.n r110 = this.f297976a.D;
            if (r110 == null) goto L21;
            com.larus.bmhome.chat.model.n.A(r110, true, true, null, 12);
        L21:
            com.larus.bmhome.chat.model.x r111 = com.larus.bmhome.chat.model.x.f308167a;
            com.larus.bmhome.chat.model.x.f308170d = r107;
            com.larus.bmhome.chat.model.x.f308171e = r108.getUserId();
            com.larus.bmhome.chat.model.x.f308172f = false;
            com.larus.bmhome.chat.model.n r112 = this.f297976a.D;
            if (r112 == null) goto L28;
            r112.f307550l = true;
            return;
        L28:
            return;
        L17:
            if (Intrinsics.areEqual(r107, "__mobile_new_session_mode_draft_office__") == true) goto L18;
            return;
        L25:
            return;
        L9:
            r107 = null;
            goto L10
        L5:
            r105 = null;
            goto L6
        }

        @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility.d
        public final void c() {
            ClientMetaPermissionHelper.c();
            ChatSendUtils r100 = ChatSendUtils.f307932a;
            ChatBottomComponent r101 = this.f297976a;
            int r102 = ChatBottomComponent.L0;
            String r103 = r101.D3();
            BotModel r104 = this.f297976a.p3();
            if (r104 == null) goto L5;
            String r105 = r104.getBotId();
        L6:
            r100.getClass();
            ChatSendUtils.q(r103, r105, null);
            return;
        L5:
            r105 = null;
            goto L6
        }

        public d(ChatBottomComponent r100) {
            this.f297976a = r100;
        }
    }

    public static final class e implements Function0<oaa.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f297977a;

        public e(AttachReceiver r100) {
            this.f297977a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [oaa.a, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final oaa.a invoke() {
            AttachReceiver r100 = this.f297977a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(oaa.a.class));
        }
    }

    public static final class f implements Function0<LifecycleOwner> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentFeature f297978a;

        public f(ComponentFeature r100) {
            this.f297978a = r100;
        }

        @Override // kotlin.jvm.functions.Function0
        public final LifecycleOwner invoke() {
            return this.f297978a;
        }
    }

    public static final class g implements Function0<ViewModelStoreOwner> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentFeature f297979a;

        public g(ComponentFeature r100) {
            this.f297979a = r100;
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStoreOwner invoke() {
            return s1a.a.c(this.f297979a);
        }
    }

    public static final class h implements Function0<ViewModelProvider.Factory> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f297980a = null;

        static {
            f297980a = new h();
        }

        public h() {
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    public static final class i implements ss8.g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatBottomComponent f297981a;

        @Override // ss8.g.b
        public final void b() {
            p1.a.a(this.f297981a);
        }

        public i(ChatBottomComponent r100) {
            this.f297981a = r100;
        }

        @Override // ss8.g.b
        public final void a(ChatUIBlockConfig r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "config");
            if (r100 != ChatUIBlockConfig.HIDE_INPUT_BAR) goto L6;
            p1.a.a(this.f297981a);
            return;
        }
    }

    static {
    }

    @Override // com.larus.bmhome.chat.component.bottom.p1
    public final void Bc() {
        this.L = true;
        W3();
    }

    public final oaa.a B3() {
        return (oaa.a) this.C.getValue();
    }

    public final va8.o C3() {
        return (va8.o) this.f297961x.getValue();
    }

    public final ICoreInputAbility E3() {
        return (ICoreInputAbility) this.f297960w.getValue();
    }

    public final gd8.f G3() {
        return (gd8.f) this.f297951o.getValue();
    }

    public final ss8.g H3() {
        return (ss8.g) this.U.getValue();
    }

    public final void W3() {
        if (this.L == true) goto L5;
        return;
    L5:
        LarusPageChatBinding r100 = z3();
        if (r100 == null) goto L27;
        TextView r101 = r100.f311092h;
        if (r101 == null) goto L28;
        com.larus.bmhome.chat.component.cvs.y r102 = u0();
        boolean r103 = true;
        int r104 = 0;
        if (r102 == null) goto L16;
        wc9.e r105 = r102.h();
        if (r105 == null) goto L16;
        if (ic8.n.d(r105) != true) goto L16;
        boolean r106 = true;
    L17:
        if (r106 == true) goto L19;
    L21:
        r103 = false;
    L22:
        if (r103 == true) goto L25;
        r104 = 8;
    L25:
        r101.setVisibility(r104);
        return;
    L19:
        if (this.N == true) goto L21;
    L16:
        r106 = false;
        goto L17
    L28:
        return;
    }

    public final void a4() {
        com.larus.bmhome.chat.model.n r100 = this.D;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f307555q == false) goto L10;
        ji8.d r101 = ji8.d.f499226a;
        String r102 = D3();
        Intrinsics.checkNotNullParameter(r102, "conversationId");
        Iterator<T> r103 = ji8.d.f499228c.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        ((ji8.b) r103.next()).a(r102);
    L10:
        com.larus.bmhome.instruction.g r104 = vc();
        if (r104 == null) goto L13;
        z2 r105 = z2.f365865a;
        r104.Lg(r100, z2.c4());
    L13:
        z2 r106 = z2.f365865a;
        if (z2.c4() == false) goto L19;
        com.larus.bmhome.chat.model.n.A(r100, true, true, null, 8);
        return;
    }

    public final de8.c f1() {
        return (de8.c) this.f297952p.getValue();
    }

    public final com.larus.bmhome.chat.component.bottom.attachment.g1 f70() {
        return (com.larus.bmhome.chat.component.bottom.attachment.g1) this.f297955r.getValue();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget, com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onCreate() {
        FLogger r100 = FLogger.f375446a;
        r100.i("ChatBottomComponent", "[onCreate]");
        r100.i("ChatBottomComponent", "[attachComponent]");
        k1a.b.b(this, new h0(this));
        ss8.g r101 = H3();
        if (r101 == null) goto L5;
        r101.ds(this.X);
    L5:
        this.W = true;
        com.larus.bmhome.chat.model.n r102 = ((ChatBottomComponentViewModel) this.f297950n.getValue()).getChatDraft();
        s1a.d.a(this).n(r102, com.larus.bmhome.chat.model.n.class);
        this.D = r102;
        z2 r103 = z2.f365865a;
        boolean r104 = false;
        String r105 = null;
        if (z2.c4() == false) goto L37;
        List r106 = CollectionsKt.listOf(new String[]{"share_to_chat_text", "auto_send_text"});
        if ((r106 instanceof Collection) == true) goto L10;
    L12:
        Iterator r107 = r106.iterator();
    L14:
        if (r107.hasNext() == false) goto L34;
        String r108 = (String) r107.next();
        de8.c r109 = f1();
        if (r109 == null) goto L20;
        Bundle r110 = r109.f468086b;
        if (r110 == null) goto L20;
        String r111 = r110.getString(r108);
    L21:
        if (r111 != null) goto L23;
    L26:
        boolean r112 = true;
    L27:
        if (r112 == false) goto L29;
    L31:
        boolean r113 = false;
    L32:
        if (r113 == false) goto L14;
        boolean r114 = true;
    L35:
        if (r114 == false) goto L37;
        boolean r115 = true;
    L38:
        z2 r116 = z2.f365865a;
        if (z2.c4() == false) goto L119;
        de8.c r117 = f1();
        if (r117 != null) goto L43;
    L45:
        boolean r118 = false;
    L46:
        if (r118 == false) goto L60;
        de8.c r119 = f1();
        if (r119 == null) goto L52;
        Bundle r120 = r119.f468086b;
        if (r120 == null) goto L52;
        String r121 = r120.getString("auto_send_uris");
    L53:
        if (r121 != null) goto L55;
    L58:
        boolean r122 = true;
    L59:
        if (r122 == true) goto L60;
    L118:
        boolean r123 = true;
    L120:
        this.Q = r123;
        if (r123 == false) goto L123;
        Long r124 = Long.valueOf(System.currentTimeMillis());
    L124:
        this.R = r124;
        if (r124 == null) goto L135;
        long r125 = r124.longValue();
        com.larus.bmhome.chat.model.n r126 = this.D;
        if (r126 == null) goto L129;
        String r127 = com.larus.bmhome.chat.model.n.D(r126, "", "entry_replacement_intent_created", null, false, true, Long.valueOf(r125), 28);
    L130:
        de8.c r128 = f1();
        if (r128 == null) goto L135;
        Bundle r129 = r128.f468086b;
        if (r129 == null) goto L135;
        r129.putString("entry_draft_replacement_token", r127);
        goto L135
    L129:
        r127 = null;
    L135:
        com.larus.bmhome.chat.model.b0 r130 = ((ChatBottomComponentViewModel) this.f297950n.getValue()).getChatUsuallyConfig();
        s1a.d.a(this).n(r130, com.larus.bmhome.chat.model.b0.class);
        this.E = r130;
        de8.c r131 = f1();
        if (r131 != null) goto L138;
    L140:
        this.G = r104;
        de8.c r132 = (de8.c) s1a.d.a(this).a(de8.c.class);
        if (r132 == null) goto L146;
        Bundle r133 = r132.f468086b;
        if (r133 == null) goto L146;
        r105 = r133.getString("as_container");
    L146:
        if (Intrinsics.areEqual(r105, "FLOAT_CHAT") == false) goto L154;
        this.N = true;
        return;
    L154:
        return;
    L138:
        if (r131.f468095k != true) goto L140;
        r104 = true;
        goto L140
    L123:
        r124 = null;
        goto L124
    L55:
        if (StringsKt.isBlank(r121) == true) goto L58;
        r122 = false;
    L52:
        r121 = null;
    L60:
        de8.c r134 = f1();
        if (r134 == null) goto L65;
        Bundle r135 = r134.f468086b;
        if (r135 == null) goto L65;
        String r136 = r135.getString("input_text");
    L66:
        if (r136 != null) goto L68;
    L71:
        boolean r137 = true;
    L72:
        if (r137 == false) goto L118;
        de8.c r138 = f1();
        if (r138 == null) goto L78;
        Bundle r139 = r138.f468086b;
        if (r139 == null) goto L78;
        String r140 = r139.getString("selected_skills");
    L79:
        if (r140 != null) goto L81;
    L84:
        boolean r141 = true;
    L85:
        if (r141 == false) goto L118;
        de8.c r142 = f1();
        String r143 = "";
        if (r142 == null) goto L93;
        Bundle r144 = r142.f468086b;
        if (r144 == null) goto L92;
        String r145 = r144.getString("push_question");
        if (r145 == null) goto L92;
    L94:
        if (r145 != null) goto L96;
    L99:
        boolean r146 = true;
    L100:
        if (r146 == false) goto L118;
        de8.c r147 = f1();
        if (r147 == null) goto L109;
        Bundle r148 = r147.f468086b;
        if (r148 == null) goto L110;
        String r149 = r148.getString("qst3");
        if (r149 == null) goto L110;
        r143 = r149;
    L110:
        if (r143 != null) goto L112;
    L115:
        boolean r150 = true;
    L116:
        if (r150 == false) goto L118;
        if (r115 == false) goto L119;
    L112:
        if (StringsKt.isBlank(r143) == true) goto L115;
        r150 = false;
        goto L116
    L109:
        r143 = null;
        goto L110
    L96:
        if (StringsKt.isBlank(r145) == true) goto L99;
        r146 = false;
    L92:
        r145 = "";
        goto L94
    L93:
        r145 = null;
        goto L94
    L81:
        if (StringsKt.isBlank(r140) == true) goto L84;
        r141 = false;
    L78:
        r140 = null;
        goto L79
    L68:
        if (StringsKt.isBlank(r136) == true) goto L71;
        r137 = false;
    L65:
        r136 = null;
        goto L66
    L43:
        if (r117.A() != true) goto L45;
        r118 = true;
    L119:
        r123 = false;
        goto L120
    L29:
        if (X3(r108) == false) goto L31;
        r113 = true;
        goto L32
    L23:
        if (StringsKt.isBlank(r111) == true) goto L26;
        r112 = false;
    L20:
        r111 = null;
    L34:
        r114 = false;
        goto L35
    L10:
        if (r106.isEmpty() == false) goto L12;
    L37:
        r115 = false;
        goto L38
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        IChatBotHealthService r100 = (IChatBotHealthService) ServiceManager.get().getService(IChatBotHealthService.class);
        if (r100 == null) goto L5;
        r100.dismissDialog();
    L5:
        va8.o r101 = C3();
        if (r101 == null) goto L8;
        r101.oR(this.Y);
    L8:
        com.larus.bmhome.chat.component.cvs.y r102 = u0();
        if (r102 == null) goto L11;
        r102.lQ(this.H);
    L11:
        boolean r103 = false;
        if (this.W == false) goto L18;
        ss8.g r104 = H3();
        if (r104 == null) goto L16;
        r104.aZ(this.X);
    L16:
        this.W = false;
    L18:
        if (z2.f365865a.enableChatWithTab() == false) goto L20;
        IFlowTtsClientService.f288300a.getClass();
        IFlowTtsClientService.a.a().f("ChatWithTab onDestroy");
    L20:
        oaa.a r105 = B3();
        if (r105 == null) goto L23;
        r105.MJ();
    L23:
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r106 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r106 != null) goto L26;
    L28:
        boolean r107 = false;
    L29:
        if (r107 == true) goto L39;
        de8.c r108 = f1();
        if (r108 == null) goto L37;
        Bundle r109 = r108.f468086b;
        if (r109 == null) goto L37;
        if (r109.getBoolean("human_merge_forward_keep_cache") != true) goto L37;
        r103 = true;
    L37:
        m3(!r103);
        return;
    L39:
        return;
    L26:
        if (r106.isChangingConfigurations() != true) goto L28;
        r107 = true;
        goto L29
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onPause() {
        FLogger.f375446a.d("ChatBottomComponent", "onPause");
        this.M = AudioServiceDelegate.f288288a.h0().getTaskId();
        a4();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onResume() {
        FLogger.f375446a.d("ChatBottomComponent", "onResume");
        AccountService r100 = AccountService.f365697a;
        String r101 = r100.getUserId();
        z2 r102 = z2.f365865a;
        String r103 = null;
        boolean r104 = true;
        if (z2.c4() == false) goto L11;
        com.larus.bmhome.chat.model.n r105 = this.D;
        if (r105 == null) goto L7;
        String r106 = r105.f307549k;
    L9:
        if (Intrinsics.areEqual(r106, r101) == true) goto L11;
        boolean r107 = true;
    L13:
        if (z2.c4() == true) goto L21;
        com.larus.bmhome.chat.model.n r108 = this.D;
        if (r108 == null) goto L17;
        r108.B(r101);
    L17:
        com.larus.bmhome.chat.model.n r109 = this.D;
        if (r109 == null) goto L52;
        r109.f307550l = false;
    L52:
        com.larus.bmhome.chat.model.n r110 = this.D;
        if (r110 == null) goto L55;
        String r111 = r110.f307540b;
    L57:
        if (z2.c4() == true) goto L59;
    L75:
        boolean r112 = false;
    L76:
        if (r107 == true) goto L78;
        if (r112 == true) goto L78;
    L85:
        SafeExtKt.b(F2(), new q(this), 500);
        if (this.F == false) goto L133;
        this.F = false;
        de8.c r113 = f1();
        if (r113 == null) goto L92;
        Bundle r114 = r113.f468086b;
        if (r114 == null) goto L92;
        String r115 = r114.getString("argAutoSearchText");
    L94:
        if (com.larus.utils.o0.d(r115) == false) goto L133;
        if (X3("argAutoSearchText") == false) goto L100;
        if (r115 != null) goto L99;
        r115 = "";
    L99:
        Q3(r115);
        goto L133
    L100:
        de8.c r116 = f1();
        if (r116 == null) goto L106;
        Bundle r117 = r116.f468086b;
        if (r117 == null) goto L106;
        String r118 = r117.getString("argAutoSearchScene");
        if (r118 == null) goto L106;
    L107:
        String r119 = r118;
        de8.c r120 = f1();
        if (r120 == null) goto L112;
        Bundle r121 = r120.f468086b;
        if (r121 == null) goto L112;
        String r122 = r121.getString("argAutoSearchType");
    L114:
        if (Intrinsics.areEqual(r122, CukaieConstants$DataLoadType.TRENDING) == false) goto L117;
        String r123 = "hot_search";
    L120:
        gd8.f r124 = G3();
        if (r124 == null) goto L127;
        LarusPageChatBinding r125 = r124.e();
        if (r125 == null) goto L127;
        ChatMessageList r126 = r125.f311098n;
        if (r126 == null) goto L127;
        com.larus.bmhome.chat.api.b0.a.a(r126, false, 0, null, null, 0, 31);
    L127:
        gd8.g r127 = (gd8.g) this.f297962y.getValue();
        if (r127 == null) goto L133;
        String r128 = D3();
        Intrinsics.checkNotNull(r115);
        ChatSendUtils r129 = ChatSendUtils.f307932a;
        Pair[] r130 = new Pair[2];
        r130[0] = TuplesKt.to("search_intend", "1");
        if (r123 != null) goto L132;
        r123 = "";
    L132:
        r130[1] = TuplesKt.to("source", r123);
        r129.getClass();
        gd8.g.a.b(r127, r128, r115, r119, ChatSendUtils.p(r130), false, null, null, null, null, null, DataLoaderHelper.DATALOADER_KEY_INT_PRELOAD_INFO_RECORD_MAX_COUNT);
        goto L133
    L117:
        if (Intrinsics.areEqual(r122, "sug") == false) goto L119;
        r123 = "input_sug";
        goto L120
    L119:
        r123 = null;
    L112:
        r122 = null;
    L106:
        r118 = "chat_list_search_bar";
    L92:
        r115 = null;
    L133:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r131 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getParentFragment();
        if (r131 == null) goto L138;
        Bundle r132 = r131.getArguments();
        if (r132 == null) goto L138;
        String r133 = r132.getString("template_show_text");
    L140:
        if (com.larus.utils.o0.d(r133) == false) goto L170;
        ChatRenderTrace r134 = ChatRenderTrace.f310039b;
        String r135 = D3();
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r136 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getParentFragment();
        if (r136 == null) goto L146;
        Bundle r137 = r136.getArguments();
        if (r137 == null) goto L146;
        String r138 = r137.getString("template_show_text");
    L147:
        if (r138 != null) goto L149;
        r138 = "";
    L149:
        r134.g(r135, r138);
        ICoreInputAbility r139 = E3();
        if (r139 == null) goto L161;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r140 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getParentFragment();
        if (r140 == null) goto L156;
        Bundle r141 = r140.getArguments();
        if (r141 == null) goto L156;
        String r142 = r141.getString("template_show_text");
    L157:
        if (r142 != null) goto L159;
        String r143 = "";
    L160:
        ICoreInputAbility.b.d(r139, r143, true, true, null, null, false, 56);
        goto L161
    L159:
        r143 = r142;
    L156:
        r142 = null;
    L161:
        Pair[] r144 = new Pair[3];
        r144[0] = TuplesKt.to("template_show_text", "");
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r145 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getParentFragment();
        if (r145 == null) goto L166;
        Bundle r146 = r145.getArguments();
        if (r146 == null) goto L166;
        r103 = r146.getString("argConversationId");
    L166:
        r144[1] = TuplesKt.to("argConversationId", r103);
        r144[2] = TuplesKt.to("is_create_sub_conversation", Boolean.FALSE);
        Bundle r147 = com.larus.utils.f.c(r144);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r148 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getParentFragment();
        if (r148 == null) goto L169;
        r148.setArguments(r147);
    L169:
        boolean r149 = true;
    L172:
        if (this.G == false) goto L186;
        ICoreInputAbility r150 = E3();
        if (r150 != null) goto L176;
    L178:
        r104 = false;
    L179:
        if (r104 == true) goto L185;
        LarusPageChatBinding r151 = z3();
        if (r151 == null) goto L185;
        ChatMessageList r152 = r151.f311098n;
        if (r152 == null) goto L185;
        r152.postDelayed(new p(this), 200);
    L185:
        this.G = false;
    L206:
        this.K = false;
        return;
    L176:
        if (r150.Rp() != 2) goto L178;
    L186:
        if (r149 == true) goto L206;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r153 = f70();
        if (r153 != null) goto L190;
    L192:
        boolean r154 = false;
    L193:
        com.larus.bmhome.instruction.g r155 = vc();
        if (r155 != null) goto L196;
    L198:
        r104 = false;
    L200:
        if (this.K == true) goto L206;
        if (r154 == true) goto L206;
        if (r104 == true) goto L206;
        ICoreInputAbility r156 = E3();
        if (r156 == null) goto L206;
        r156.qp(false);
        goto L206
    L196:
        if (r155.z0() != true) goto L198;
    L190:
        if (r153.isVisible() != true) goto L192;
        r154 = true;
    L146:
        r138 = null;
        goto L147
    L170:
        r149 = false;
    L138:
        r133 = null;
    L78:
        com.larus.bmhome.chat.model.n r157 = this.D;
        if (r157 == null) goto L81;
        r157.f307540b = "";
    L81:
        com.larus.bmhome.chat.model.n r158 = this.D;
        if (r158 == null) goto L84;
        r158.f307542d = true;
    L84:
        this.P = null;
        cb(false);
        goto L85
    L59:
        if (Intrinsics.areEqual(r111, "__mobile_new_session_mode_draft_chat__") == false) goto L61;
    L62:
        com.larus.bmhome.chat.model.x r159 = com.larus.bmhome.chat.model.x.f308167a;
        com.larus.bmhome.chat.model.n r160 = this.D;
        if (r160 == null) goto L65;
        String r161 = r160.f307549k;
    L66:
        if (r161 != null) goto L68;
        r161 = "";
    L68:
        List r162 = com.larus.bmhome.chat.model.x.e(r159, r111, r161, null, 4);
        com.larus.bmhome.chat.model.n r163 = this.D;
        if (r163 == null) goto L71;
        List<ChatDraftItem> r164 = r163.f307554p;
    L73:
        if (Intrinsics.areEqual(r162, r164) == true) goto L75;
        r112 = true;
        goto L76
    L71:
        r164 = null;
        goto L73
    L65:
        r161 = null;
        goto L66
    L61:
        if (Intrinsics.areEqual(r111, "__mobile_new_session_mode_draft_office__") == false) goto L75;
    L55:
        r111 = null;
        goto L57
    L21:
        if (r100.isLogin().booleanValue() == false) goto L37;
        com.larus.bmhome.chat.model.n r165 = this.D;
        if (r165 != null) goto L25;
    L27:
        boolean r166 = false;
    L28:
        if (r166 == false) goto L37;
        com.larus.bmhome.chat.model.x r167 = com.larus.bmhome.chat.model.x.f308167a;
        if (com.larus.bmhome.chat.model.x.f308170d == null) goto L37;
        if (com.larus.bmhome.chat.model.x.f308171e == null) goto L37;
        com.larus.bmhome.chat.model.n r168 = this.D;
        if (r168 == null) goto L52;
        r168.B(r101);
        goto L52
    L25:
        if (r165.f307550l != true) goto L27;
        r166 = true;
    L37:
        if (r100.isLogin().booleanValue() == false) goto L45;
        com.larus.bmhome.chat.model.n r169 = this.D;
        if (r169 == null) goto L41;
        r169.B(r101);
    L41:
        com.larus.bmhome.chat.model.n r170 = this.D;
        if (r170 == null) goto L52;
        r170.f307550l = false;
        goto L52
    L45:
        if (r100.isLogin().booleanValue() == true) goto L52;
        com.larus.bmhome.chat.model.x r171 = com.larus.bmhome.chat.model.x.f308167a;
        com.larus.bmhome.chat.model.x.f308170d = null;
        com.larus.bmhome.chat.model.x.f308171e = null;
        com.larus.bmhome.chat.model.x.f308172f = false;
        com.larus.bmhome.chat.model.n r172 = this.D;
        if (r172 == null) goto L49;
        r172.B(r101);
    L49:
        com.larus.bmhome.chat.model.n r173 = this.D;
        if (r173 == null) goto L52;
        r173.f307550l = false;
        goto L52
    L7:
        r106 = null;
    L11:
        r107 = false;
        goto L13
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onStop() {
        AudioServiceDelegate r100 = AudioServiceDelegate.f288288a;
        String r101 = r100.h0().getTaskId();
        if (Intrinsics.areEqual(this.M, r101) == true) goto L5;
        return;
    L5:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r102 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) s1a.d.a(this).getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r102 == null) goto L8;
        AsrInputMode r103 = r102.B5();
    L10:
        if (r103 != AsrInputMode.HANDSFREE) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == false) goto L16;
        FLogger.f375446a.d("ChatBottomComponent", "onStop: handsfree active, skip ASR cleanup to keep recording in background");
        return;
    L16:
        com.larus.audio.o0.a.a(r100.h0(), null, null, null, null, null, null, null, 112);
        r100.h0().b();
        r100.h0().f();
        return;
    L12:
        r104 = false;
        goto L13
    L8:
        r103 = null;
        goto L10
    }

    public final com.larus.bmhome.chat.component.cvs.y u0() {
        return (com.larus.bmhome.chat.component.cvs.y) this.f297954q.getValue();
    }

    public final com.larus.bmhome.instruction.g vc() {
        return (com.larus.bmhome.instruction.g) this.f297956s.getValue();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        FLogger.f375446a.i("ChatBottomComponent", "[onAttach]");
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, p1.class);
    }

    /* JADX WARN: Type inference failed for: r0v42, types: [com.larus.bmhome.chat.component.bottom.d] */
    public ChatBottomComponent() {
        this.f297949m = R.id.chat_root;
        this.f297950n = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(ChatBottomComponentViewModel.class), Reflection.getOrCreateKotlinClass(ChatBottomComponentState.class), new f(this), new g(this), h.f297980a);
        this.f297951o = LazyKt.lazy(new s0(this));
        this.f297952p = LazyKt.lazy(new com.larus.bmhome.chat.component.bottom.f(this));
        this.f297954q = LazyKt.lazy(new com.larus.bmhome.chat.component.bottom.g(this));
        this.f297955r = LazyKt.lazy(new com.larus.bmhome.chat.component.bottom.h(this));
        this.f297956s = LazyKt.lazy(new com.larus.bmhome.chat.component.bottom.i(this));
        this.f297957t = LazyKt.lazy(new j(this));
        this.f297958u = LazyKt.lazy(new k(this));
        this.f297959v = LazyKt.lazy(new m(this));
        this.f297960w = LazyKt.lazy(new n(this));
        this.f297961x = LazyKt.lazy(new o(this));
        this.f297962y = LazyKt.lazy(new v0(this));
        this.f297963z = LazyKt.lazy(new w0(this));
        this.A = LazyKt.lazy(new x0(this));
        this.B = LazyKt.lazy(new y0(this));
        this.C = LazyKt.lazy(new e(this));
        this.F = true;
        this.T = LazyKt.lazy(new z0());
        this.U = LazyKt.lazy(new com.larus.bmhome.chat.component.bottom.b(this));
        this.V = LazyKt.lazy(new com.larus.bmhome.chat.component.bottom.c(this));
        this.X = new i(this);
        this.Y = new com.larus.bmhome.chat.component.bottom.d(this);
        this.Z = new d(this);
        this.f297948k0 = LazyKt.lazy(new com.larus.bmhome.chat.component.bottom.e(this));
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void A2() {
        ICoreInputAbility r100 = E3();
        if (r100 == null) goto L5;
        r100.XG(this.Z);
    L5:
        fx9.a r101 = (fx9.a) s1a.d.a(this).getAbility(fx9.a.class);
        String r102 = null;
        if (r101 == null) goto L8;
        r101.q9(null);
    L8:
        e2 r103 = (e2) s1a.d.a(this).getAbility(e2.class);
        if (r103 == null) goto L11;
        r103.q9(null);
    L11:
        com.larus.bmhome.chat.model.n r104 = this.D;
        if (r104 == null) goto L14;
        r102 = r104.f307540b;
    L14:
        z2 r105 = z2.f365865a;
        if (z2.c4() == true) goto L17;
    L21:
        boolean r106 = false;
    L22:
        if (r106 == true) goto L24;
        ResourceUploader r107 = ResourceUploader.f314736a;
        ResourceUploader.a(ResourceUploader.a.C4107a.f314738a);
        ChatInputService.f303327b.g().clear();
    L24:
        a4();
        return;
    L17:
        if (Intrinsics.areEqual(r102, "__mobile_new_session_mode_draft_chat__") == false) goto L19;
    L20:
        r106 = true;
        goto L22
    L19:
        if (Intrinsics.areEqual(r102, "__mobile_new_session_mode_draft_office__") == false) goto L21;
        goto L20
    }

    public final String D3() {
        com.larus.bmhome.chat.component.cvs.y r100 = u0();
        if (r100 == null) goto L5;
        String r101 = r100.Y1();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final void P2() {
        F2().post(new w(this));
    }

    @Override // com.larus.bmhome.chat.component.bottom.p1
    public final View bo() {
        gd8.f r100 = G3();
        if (r100 == null) goto L7;
        LarusPageChatBinding r101 = r100.e();
        if (r101 == null) goto L7;
        return r101.f311093i;
    L7:
        return null;
    }

    public final BotModel p3() {
        com.larus.bmhome.chat.component.cvs.y r100 = u0();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.j0();
    }

    public final LarusPageChatBinding z3() {
        gd8.f r100 = G3();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.e();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final int U2() {
        return this.f297949m;
    }

    @Override // com.larus.bmhome.chat.component.bottom.p1
    public final int Vj() {
        return this.f297953p0;
    }

    @Override // com.larus.bmhome.chat.component.bottom.p1
    public final com.larus.bmhome.chat.model.j1 Y3() {
        return this.D;
    }

    @Override // com.larus.bmhome.chat.component.bottom.p1
    public final com.larus.bmhome.chat.model.b0 u5() {
        return this.E;
    }

    public final void Q3(String r110) {
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        z2 r101 = z2.f365865a;
        if (z2.c4() == false) goto L65;
        com.larus.bmhome.chat.model.n r102 = this.D;
        if (r102 == null) goto L13;
        String r103 = r102.f307539a;
    L14:
        if (r103 != null) goto L16;
    L19:
        boolean r104 = true;
    L20:
        if (r104 == true) goto L33;
        if (r102 == null) goto L23;
        String r105 = r102.f307540b;
    L24:
        if (r105 != null) goto L26;
    L29:
        boolean r106 = true;
    L30:
        if (r106 == true) goto L33;
        boolean r111 = false;
    L34:
        if (r111 == false) goto L36;
        String r107 = r110;
    L37:
        this.S = r107;
        com.larus.bmhome.chat.model.n r108 = this.D;
        if (r108 == null) goto L40;
        r108.f307542d = false;
    L40:
        if (r102 == null) goto L48;
        Long r109 = this.R;
        if (r109 == null) goto L44;
        String r112 = r109.toString();
    L46:
        if (com.larus.bmhome.chat.model.j1.a.c(r102, r110, null, true, null, r112, null, 40) != true) goto L48;
        boolean r113 = true;
    L49:
        if (r113 == true) goto L58;
        if (r111 == true) goto L52;
        this.S = null;
    L52:
        FLogger r114 = FLogger.f375446a;
        if (r111 == false) goto L55;
        String r115 = "defer route-query draft replacement until draft identity is ready";
    L56:
        r114.w("ChatBottomComponent", r115);
        return;
    L55:
        r115 = "ignore stale route-query draft replacement";
        goto L56
    L58:
        this.S = null;
        cb(false);
        ICoreInputAbility r116 = E3();
        if (r116 == null) goto L61;
        r116.g2(3, true);
    L61:
        ICoreInputAbility r117 = E3();
        if (r117 == null) goto L82;
        ICoreInputAbility.b.e(r117, "prefillRouteQueryText", null, false, 6);
        return;
    L82:
        return;
    L44:
        r112 = null;
    L48:
        r113 = false;
        goto L49
    L36:
        r107 = null;
        goto L37
    L26:
        if (StringsKt.isBlank(r105) == true) goto L29;
        r106 = false;
        goto L30
    L23:
        r105 = null;
    L33:
        r111 = true;
        goto L34
    L16:
        if (StringsKt.isBlank(r103) == true) goto L19;
        r104 = false;
        goto L20
    L13:
        r103 = null;
        goto L14
    L65:
        com.larus.bmhome.instruction.g r118 = vc();
        if (r118 == null) goto L68;
        r118.A1();
    L68:
        gd8.f r119 = G3();
        if (r119 == null) goto L75;
        LarusPageChatBinding r120 = r119.e();
        if (r120 == null) goto L75;
        ChatMessageList r121 = r120.f311098n;
        if (r121 == null) goto L75;
        com.larus.bmhome.chat.api.b0.a.a(r121, false, 0, null, null, 0, 31);
    L75:
        ICoreInputAbility r122 = E3();
        if (r122 == null) goto L78;
        r122.g2(3, true);
    L78:
        ICoreInputAbility r123 = E3();
        if (r123 == null) goto L83;
        ICoreInputAbility.b.d(r123, r110, true, true, null, null, false, 56);
        return;
    L83:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final void V3(boolean r100) {
        gd8.f r101 = G3();
        if (r101 == null) goto L9;
        LarusPageChatBinding r102 = r101.e();
        if (r102 == null) goto L9;
        FrameLayout r103 = r102.f311088d;
        if (r103 == null) goto L9;
        r103.setVisibility(0);
    L9:
        va8.o r104 = C3();
        if (r104 == null) goto L12;
        r104.nX();
    L12:
        ICoreInputAbility r105 = E3();
        if (r105 == null) goto L15;
        r105.g2(3, true);
    L15:
        va8.o r106 = C3();
        if (r106 == null) goto L18;
        r106.SB(true);
    L18:
        if (r100 == false) goto L25;
        LarusPageChatBinding r107 = z3();
        if (r107 == null) goto L26;
        ChatConstraintLayout r108 = r107.f311085a;
        if (r108 == null) goto L27;
        r108.postDelayed(new o0(this), 250);
        return;
    L27:
        return;
    L26:
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final void X2(int r100) {
        this.f297949m = r100;
    }

    public final boolean X3(String r100) {
        if (z2.f365865a.getRouterConfig().b() == false) goto L13;
        de8.c r101 = f1();
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r101.u(r100) != true) goto L9;
        r102 = true;
        goto L10
    L13:
        return false;
    }

    public final void c4(boolean r210) {
        gd8.f r100 = G3();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.e() == null) goto L412;
        String r101 = D3();
        de8.c r102 = f1();
        if (r102 != null) goto L9;
    L11:
        boolean r103 = false;
    L12:
        com.larus.bmhome.actionbar.model.z0 r110 = null;
        if (r210 == false) goto L75;
        com.larus.bmhome.chat.model.n r104 = this.D;
        if (r104 == null) goto L67;
        ChatPageContext r105 = (ChatPageContext) s1a.d.a(this).a(ChatPageContext.class);
        if (r105 == null) goto L19;
        String r106 = r105.getConversationMode();
    L20:
        com.larus.bmhome.chat.component.cvs.y r107 = u0();
        if (r107 == null) goto L23;
        wc9.e r108 = r107.h();
    L25:
        if (com.larus.bmhome.utils.i.f(r108) == false) goto L65;
        va8.f0 r109 = (va8.f0) s1a.d.a(this).getAbility(va8.f0.class);
        if (r109 != null) goto L29;
    L31:
        boolean r111 = false;
    L32:
        if (r111 == true) goto L65;
        de8.c r112 = f1();
        if (r112 != null) goto L36;
    L38:
        boolean r113 = false;
    L39:
        if (r113 == true) goto L65;
        de8.c r114 = f1();
        if (r114 == null) goto L43;
        String r115 = r114.o();
    L44:
        if (r115 != null) goto L46;
    L49:
        boolean r116 = true;
    L50:
        if (r116 == false) goto L65;
        de8.c r117 = f1();
        if (r117 == null) goto L56;
        Bundle r118 = r117.f468086b;
        if (r118 == null) goto L56;
        String r119 = r118.getString("human_merge_forward_info");
    L57:
        if (r119 != null) goto L59;
    L62:
        boolean r120 = true;
    L63:
        if (r120 == false) goto L65;
        boolean r121 = true;
    L66:
        String r122 = r104.C(r101, "onConversationChanged", r103, r106, r121, this.Q, this.R);
    L68:
        z2 r123 = z2.f365865a;
        if (z2.c4() == false) goto L75;
        de8.c r124 = f1();
        if (r124 == null) goto L75;
        Bundle r125 = r124.f468086b;
        if (r125 == null) goto L75;
        r125.putString("entry_draft_replacement_token", r122);
        Unit r126 = Unit.INSTANCE;
        goto L75
    L59:
        if (StringsKt.isBlank(r119) == true) goto L62;
        r120 = false;
    L56:
        r119 = null;
        goto L57
    L46:
        if (StringsKt.isBlank(r115) == true) goto L49;
        r116 = false;
        goto L50
    L43:
        r115 = null;
        goto L44
    L36:
        if (r112.n() != true) goto L38;
        r113 = true;
        goto L39
    L29:
        if (r109.R() != true) goto L31;
        r111 = true;
    L65:
        r121 = false;
        goto L66
    L23:
        r108 = null;
        goto L25
    L19:
        r106 = null;
        goto L20
    L67:
        r122 = null;
    L75:
        if (r210 == false) goto L96;
        de8.c r127 = f1();
        if (r127 == null) goto L83;
        Bundle r128 = r127.f468086b;
        if (r128 == null) goto L83;
        if (r128.getBoolean("key_skip_draft_restore", false) != true) goto L83;
        boolean r129 = true;
    L84:
        if (r129 == false) goto L96;
        FLogger.f375446a.i("ChatBottomComponent", "skip chat draft restore by argument, conversationId=".concat(r101));
        z2 r130 = z2.f365865a;
        if (z2.c4() == false) goto L93;
        com.larus.bmhome.chat.model.n r131 = this.D;
        if (r131 == null) goto L90;
        r131.f307542d = false;
        Unit r132 = Unit.INSTANCE;
    L90:
        com.larus.bmhome.chat.model.n r133 = this.D;
        if (r133 == null) goto L93;
        r133.l(null);
        Unit r134 = Unit.INSTANCE;
    L93:
        oaa.a r135 = B3();
        if (r135 == null) goto L413;
        r135.H7();
        Unit r136 = Unit.INSTANCE;
        return;
    L413:
        return;
    L83:
        r129 = false;
    L96:
        if (r210 == false) goto L109;
        oaa.a r137 = B3();
        if (r137 != null) goto L100;
    L102:
        boolean r138 = false;
    L103:
        if (r138 == false) goto L109;
        ji8.d r139 = ji8.d.f499226a;
        String r140 = D3();
        Intrinsics.checkNotNullParameter(r140, "conversationId");
        Iterator<T> r141 = ji8.d.f499228c.iterator();
    L106:
        if (r141.hasNext() == false) goto L108;
        ((ji8.b) r141.next()).a(r140);
        goto L106
    L108:
        boolean r142 = false;
    L111:
        if (r210 == false) goto L160;
        z2 r143 = z2.f365865a;
        if (z2.c4() == false) goto L160;
        com.larus.bmhome.chat.model.n r144 = this.D;
        if (r144 == null) goto L117;
        String r145 = r144.f307540b;
    L119:
        if (Intrinsics.areEqual(r145, "__mobile_new_session_mode_draft_chat__") == true) goto L126;
        com.larus.bmhome.chat.model.n r146 = this.D;
        if (r146 == null) goto L123;
        String r147 = r146.f307540b;
    L125:
        if (Intrinsics.areEqual(r147, "__mobile_new_session_mode_draft_office__") == false) goto L160;
    L123:
        r147 = null;
    L126:
        de8.c r148 = f1();
        if (r148 != null) goto L129;
    L131:
        boolean r149 = false;
    L132:
        if (r149 == false) goto L160;
        de8.c r150 = f1();
        if (r150 == null) goto L138;
        Bundle r151 = r150.f468086b;
        if (r151 == null) goto L138;
        String r152 = r151.getString("auto_send_uris");
    L139:
        if (r152 != null) goto L141;
    L144:
        boolean r153 = true;
    L145:
        if (r153 == true) goto L160;
        de8.c r154 = f1();
        if (r154 == null) goto L151;
        Bundle r155 = r154.f468086b;
        if (r155 == null) goto L151;
        String r156 = r155.getString("entry_draft_replacement_token");
    L152:
        if (r156 != null) goto L154;
    L157:
        boolean r157 = true;
    L158:
        if (r157 == true) goto L160;
        boolean r158 = true;
    L161:
        if (r158 == false) goto L171;
        com.larus.bmhome.chat.model.n r159 = this.D;
        if (r159 == null) goto L165;
        r159.f307542d = true;
        Unit r160 = Unit.INSTANCE;
    L165:
        ICoreInputAbility r161 = E3();
        if (r161 == null) goto L168;
        ICoreInputAbility.b.d(r161, "", false, false, null, null, false, 24);
        Unit r162 = Unit.INSTANCE;
    L168:
        oaa.a r163 = B3();
        if (r163 == null) goto L415;
        r163.H7();
        Unit r164 = Unit.INSTANCE;
        return;
    L415:
        return;
    L171:
        String r165 = "";
        if (r142 == false) goto L267;
        com.larus.bmhome.chat.model.n r166 = this.D;
        if (r166 == null) goto L185;
        List<ChatDraftItem> r167 = r166.f307554p;
        if (r167 == null) goto L185;
        Iterator<T> r168 = r167.iterator();
    L179:
        if (r168.hasNext() == false) goto L183;
        Object r169 = r168.next();
        if (Intrinsics.areEqual(((ChatDraftItem) r169).getType(), ChatDraftItem.TYPE_TASK_MODE_SELECTION) == false) goto L179;
    L184:
        ChatDraftItem r170 = (ChatDraftItem) r169;
    L186:
        com.larus.bmhome.chat.model.n r171 = this.D;
        if (r171 == null) goto L189;
        String r172 = r171.f307540b;
    L190:
        z2 r173 = z2.f365865a;
        if (z2.c4() == false) goto L212;
        com.larus.bmhome.chat.model.n r174 = this.D;
        if (r174 != null) goto L195;
    L197:
        boolean r175 = false;
    L198:
        if (r175 == true) goto L212;
        if (Intrinsics.areEqual(r172, "__mobile_new_session_mode_draft_chat__") == false) goto L202;
    L203:
        com.larus.bmhome.chat.component.cvs.y r176 = u0();
        if (r176 == null) goto L212;
        wc9.e r177 = r176.h();
        if (r177 == null) goto L212;
        String r178 = r177.I;
        if (r178 == null) goto L212;
        if ((!StringsKt.isBlank(r178)) == false) goto L212;
        String r179 = r178;
    L213:
        if (r170 != null) goto L224;
        com.larus.bmhome.chat.model.n r180 = this.D;
        if (r180 != null) goto L217;
    L219:
        boolean r181 = false;
    L220:
        if (r181 == true) goto L224;
        if (r179 != null) goto L224;
        boolean r182 = false;
    L225:
        if (r182 == false) goto L237;
        StringBuilder r183 = new StringBuilder();
        com.larus.bmhome.chat.model.n r184 = this.D;
        if (r184 == null) goto L229;
        String r185 = r184.f307540b;
    L230:
        r183.append(r185);
        r183.append(':');
        if (r170 == null) goto L233;
        String r186 = r170.getContent();
    L234:
        if (r186 != null) goto L236;
        r186 = "";
    L236:
        r183.append(r186);
        String r187 = r183.toString();
    L238:
        if (r187 == null) goto L267;
        if (Intrinsics.areEqual(r187, this.P) == true) goto L267;
        if (r170 == null) goto L259;
        String r188 = r170.getContent();
        if (r188 == null) goto L259;
        if ((!StringsKt.isBlank(r188)) == true) goto L248;
        r188 = null;
    L248:
        if (r188 == null) goto L259;
        Result.Companion r189 = Result.Companion;     // Catch: Throwable -> L251
        Object r190 = Result.m9449constructorimpl((be8.c) new Gson().fromJson(r188, be8.c.class));     // Catch: Throwable -> L251
    L254:
        if (Result.m9455isFailureimpl(r190) == false) goto L256;
        r190 = null;
    L256:
        be8.c r191 = (be8.c) r190;
        if (r191 == null) goto L259;
    L260:
        if (r179 == null) goto L262;
        be8.f r192 = new be8.f(r179, "", true, null, null, null, null, 248);
    L263:
        be8.a r193 = (be8.a) this.V.getValue();
        if (r193 == null) goto L266;
        r193.UF(r192, r191);
        Unit r194 = Unit.INSTANCE;
    L266:
        this.P = r187;
        goto L267
    L262:
        r192 = null;
    L251:
        th = move-exception;
        Result.Companion r195 = Result.Companion;
        r190 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L259:
        r191 = new be8.c(false, null, false, null, null, 1023);
        goto L260
    L233:
        r186 = null;
        goto L234
    L229:
        r185 = null;
        goto L230
    L237:
        r187 = null;
        goto L238
    L217:
        if (r180.f307542d != true) goto L219;
        r181 = true;
    L224:
        r182 = true;
        goto L225
    L202:
        if (Intrinsics.areEqual(r172, "__mobile_new_session_mode_draft_office__") == false) goto L212;
    L195:
        if (r174.f307542d != true) goto L197;
        r175 = true;
    L212:
        r179 = null;
        goto L213
    L189:
        r172 = null;
        goto L190
    L183:
        r169 = null;
    L185:
        r170 = null;
    L267:
        if (r142 == false) goto L351;
        com.larus.bmhome.chat.model.n r196 = this.D;
        if (r196 != null) goto L271;
    L273:
        boolean r197 = false;
    L274:
        if (r197 == false) goto L351;
        BotModel r198 = p3();
        if (r198 == null) goto L283;
        Integer r199 = r198.getBotStatus();
        if (r199 == null) goto L283;
        if (r199.intValue() != (-40)) goto L283;
        boolean r200 = true;
    L284:
        if (r200 == true) goto L351;
        com.larus.bmhome.chat.model.n r201 = this.D;
        if (r201 == null) goto L310;
        Iterator<T> r202 = r201.f307554p.iterator();
    L289:
        if (r202.hasNext() == false) goto L293;
        Object r203 = r202.next();
        if (Intrinsics.areEqual(((ChatDraftItem) r203).getType(), ChatDraftItem.TYPE_MSG_EXT) == false) goto L289;
    L294:
        ChatDraftItem r204 = (ChatDraftItem) r203;
        FLogger.f375446a.d("ChatDraft", "getMsgExtDraft actionBarInstructionDraftItem:" + r204);
        if (r204 == null) goto L297;
        String r205 = r204.getContent();
    L298:
        if (r205 == null) goto L310;
        if (r205.length() <= 0) goto L302;
        boolean r206 = true;
    L303:
        if (r206 == true) goto L306;
        r205 = null;
    L306:
        if (r205 == null) goto L310;
        com.larus.bmhome.instruction.h r207 = (com.larus.bmhome.instruction.h) this.f297957t.getValue();
        if (r207 == null) goto L310;
        r207.qz(com.larus.bmhome.chat.trace.appreciable.z.a(r205, "updateForChatDraft"), "updateForChatDraft");
        Unit r208 = Unit.INSTANCE;
        goto L310
    L302:
        r206 = false;
        goto L303
    L297:
        r205 = null;
        goto L298
    L293:
        r203 = null;
    L310:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r209 = f70();
        if (r209 == null) goto L313;
        r209.dm();
        Unit r211 = Unit.INSTANCE;
    L313:
        com.larus.bmhome.chat.model.n r212 = this.D;
        if (r212 == null) goto L351;
        Iterator<T> r213 = r212.f307554p.iterator();
    L317:
        if (r213.hasNext() == false) goto L321;
        Object r214 = r213.next();
        if (Intrinsics.areEqual(((ChatDraftItem) r214).getType(), "text") == false) goto L317;
    L322:
        ChatDraftItem r215 = (ChatDraftItem) r214;
        if (r215 == null) goto L329;
        String r216 = r215.getContent();
        if (r216 == null) goto L329;
        r165 = r216;
    L329:
        if (r165.length() <= 1000) goto L331;
        FLogger.f375446a.i("ChatDraft", "getTextTypeDraftContent textTypeChatDraftItem super long text:" + r165.length());
    L333:
        if (r165.length() <= 0) goto L335;
        boolean r217 = true;
    L336:
        if (r217 == false) goto L338;
        String r1100 = r165;
    L339:
        if (r1100 == null) goto L351;
        oaa.a r218 = B3();
        if (r218 == null) goto L343;
        CharSequence r219 = r218.x9(r1100);
    L344:
        if (r219 == null) goto L348;
        ICoreInputAbility r220 = E3();
        if (r220 == null) goto L351;
        z2 r221 = z2.f365865a;
        r220.qB(r219, false, false, !z2.c4());
        Unit r222 = Unit.INSTANCE;
        goto L351
    L348:
        ICoreInputAbility r1101 = E3();
        if (r1101 == null) goto L351;
        z2 r223 = z2.f365865a;
        ICoreInputAbility.b.d(r1101, r1100, false, false, null, null, !z2.c4(), 24);
        Unit r224 = Unit.INSTANCE;
        goto L351
    L343:
        r219 = null;
        goto L344
    L338:
        r1100 = null;
        goto L339
    L335:
        r217 = false;
        goto L336
    L331:
        FLogger.f375446a.i("ChatDraft", "getTextTypeDraftContent textTypeChatDraftItem:" + r215);
        goto L333
    L321:
        r214 = null;
    L283:
        r200 = false;
        goto L284
    L271:
        if (r196.p() != true) goto L273;
        r197 = true;
    L351:
        if (r142 == false) goto L387;
        z2 r225 = z2.f365865a;
        if (z2.c4() == false) goto L387;
        com.larus.bmhome.chat.model.n r226 = this.D;
        if (r226 == null) goto L384;
        List<ChatDraftItem> r227 = r226.f307554p;
        if (r227 == null) goto L384;
        Iterator<T> r228 = r227.iterator();
    L360:
        if (r228.hasNext() == false) goto L364;
        Object r229 = r228.next();
        if (Intrinsics.areEqual(((ChatDraftItem) r229).getType(), ChatDraftItem.TYPE_ACTION_BAR_SELECTION) == false) goto L360;
    L365:
        ChatDraftItem r230 = (ChatDraftItem) r229;
        if (r230 == null) goto L384;
        String r231 = r230.getContent();
        if (r231 == null) goto L384;
        Result.Companion r232 = Result.Companion;     // Catch: Throwable -> L371
        Object r233 = Result.m9449constructorimpl((ReplyOption) new Gson().fromJson(r231, ReplyOption.class));     // Catch: Throwable -> L371
    L374:
        if (Result.m9455isFailureimpl(r233) == false) goto L376;
        r233 = null;
    L376:
        ReplyOption r234 = (ReplyOption) r233;
        if (r234 == null) goto L384;
        Object r235 = com.larus.bmhome.view.actionbar.custom.cache.e.f315871a;
        ReplyOption r236 = com.larus.bmhome.view.actionbar.custom.cache.e.a(r234);
        com.larus.bmhome.instruction.g r237 = vc();
        if (r237 == null) goto L384;
        com.larus.bmhome.instruction.g r238 = vc();
        if (r238 == null) goto L383;
        r110 = r238.un(ActiveSwitchType.DEEPTHINK, null);
    L383:
        r237.QW(r110, r236, false);
        Unit r239 = Unit.INSTANCE;
    L371:
        th = move-exception;
        Result.Companion r240 = Result.Companion;
        r233 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L374
    L364:
        r229 = null;
    L384:
        com.larus.bmhome.instruction.g r241 = vc();
        if (r241 == null) goto L387;
        r241.K90();
        Unit r242 = Unit.INSTANCE;
    L387:
        com.larus.bmhome.chat.model.n r243 = this.D;
        if (r243 == null) goto L390;
        r243.f307542d = false;
        Unit r244 = Unit.INSTANCE;
    L390:
        oaa.a r245 = B3();
        if (r245 == null) goto L417;
        r245.H7();
        Unit r246 = Unit.INSTANCE;
        return;
    L417:
        return;
    L154:
        if (StringsKt.isBlank(r156) == true) goto L157;
        r157 = false;
    L151:
        r156 = null;
        goto L152
    L141:
        if (StringsKt.isBlank(r152) == true) goto L144;
        r153 = false;
    L138:
        r152 = null;
        goto L139
    L129:
        if (r148.A() != true) goto L131;
        r149 = true;
        goto L132
    L117:
        r145 = null;
    L160:
        r158 = false;
        goto L161
    L100:
        if (r137.MJ() != true) goto L102;
        r138 = true;
    L109:
        r142 = true;
        goto L111
    L9:
        if (r102.A() != true) goto L11;
        r103 = true;
        goto L12
    }

    @Override // com.larus.bmhome.chat.component.bottom.p1
    public final void cb(boolean r110) {
        boolean r100 = true;
        if (r110 == false) goto L7;
        com.larus.bmhome.chat.model.n r111 = this.D;
        if (r111 == null) goto L7;
        r111.f307542d = true;
    L7:
        com.larus.bmhome.chat.model.n r112 = this.D;
        if (r112 != null) goto L10;
    L12:
        boolean r113 = false;
    L13:
        wc9.e r101 = null;
        if (r113 == false) goto L54;
        ICoreInputAbility r102 = E3();
        if (r102 == null) goto L18;
        ICoreInputAbility.b.d(r102, "", false, false, null, null, false, 56);
    L18:
        com.larus.bmhome.instruction.g r114 = vc();
        if (r114 == null) goto L21;
        r114.A1();
    L21:
        com.larus.bmhome.chat.component.bottom.reference.a r115 = (com.larus.bmhome.chat.component.bottom.reference.a) this.f297958u.getValue();
        if (r115 == null) goto L24;
        r115.sZ();
    L24:
        bc8.a r116 = (bc8.a) this.f297959v.getValue();
        if (r116 == null) goto L27;
        r116.mX();
    L27:
        com.larus.bmhome.instruction.h r117 = (com.larus.bmhome.instruction.h) this.f297957t.getValue();
        if (r117 == null) goto L30;
        r117.qz(null, "mode_draft_restore");
    L30:
        com.larus.bmhome.chat.model.n r118 = this.D;
        if (r118 == null) goto L33;
        ChatDraftItem r119 = r118.d();
    L34:
        if (r119 != null) goto L38;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r120 = f70();
        if (r120 == null) goto L38;
        r120.dm();
    L38:
        com.larus.bmhome.chat.model.n r121 = this.D;
        if (r121 == null) goto L41;
        String r122 = r121.f307540b;
    L42:
        if (r122 != null) goto L44;
    L47:
        boolean r123 = true;
    L48:
        c4(r123);
        com.larus.bmhome.chat.component.bottom.reference.a r124 = (com.larus.bmhome.chat.component.bottom.reference.a) this.f297958u.getValue();
        if (r124 == null) goto L51;
        r124.OW(p3());
    L51:
        com.larus.bmhome.chat.model.n r125 = this.D;
        if (r125 == null) goto L54;
        r125.f307542d = false;
        goto L54
    L44:
        if (StringsKt.isBlank(r122) == true) goto L47;
        r123 = false;
        goto L48
    L41:
        r122 = null;
        goto L42
    L33:
        r119 = null;
    L54:
        ss8.g r126 = H3();
        if (r126 != null) goto L57;
    L59:
        boolean r127 = false;
    L61:
        if (r127 == false) goto L147;
        ICoreInputAbility r128 = E3();
        if (r128 == null) goto L65;
        r128.qp(false);
    L65:
        va8.o r129 = C3();
        if (r129 == null) goto L68;
        r129.RQ();
    L68:
        gd8.f r130 = G3();
        if (r130 == null) goto L75;
        LarusPageChatBinding r131 = r130.e();
        if (r131 == null) goto L75;
        FrameLayout r132 = r131.f311088d;
        if (r132 == null) goto L75;
        r132.setVisibility(8);
    L75:
        IChatMessageShareAbility r133 = (IChatMessageShareAbility) this.A.getValue();
        if (r133 != null) goto L78;
    L80:
        boolean r134 = false;
    L81:
        if (r134 == true) goto L103;
        com.larus.bmhome.chat.component.collection.o r135 = (com.larus.bmhome.chat.component.collection.o) s1a.d.a(this).getAbility(com.larus.bmhome.chat.component.collection.o.class);
        if (r135 != null) goto L85;
    L87:
        boolean r136 = false;
    L88:
        if (r136 == true) goto L103;
        com.larus.bmhome.chat.component.showcase.x r137 = (com.larus.bmhome.chat.component.showcase.x) this.f297963z.getValue();
        if (r137 != null) goto L92;
    L94:
        boolean r138 = false;
    L95:
        if (r138 == true) goto L103;
        com.larus.bmhome.chat.component.cvs.y r139 = u0();
        if (r139 == null) goto L99;
        wc9.e r140 = r139.h();
    L101:
        if (ic8.n.d(r140) == true) goto L103;
    L105:
        boolean r141 = false;
    L106:
        ss8.g r103 = H3();
        if (r103 == null) goto L109;
        ss8.g.a r104 = r103.TI();
    L110:
        if (r104 != null) goto L113;
        r100 = false;
    L113:
        ss8.g r105 = H3();
        if (r105 == null) goto L116;
        r105.bA();
    L116:
        if (r100 == false) goto L139;
        if (r141 == true) goto L139;
        gd8.f r142 = G3();
        if (r142 == null) goto L224;
        LarusPageChatBinding r143 = r142.e();
        if (r143 == null) goto L225;
        FrameLayout r144 = r143.f311093i;
        if (r144 == null) goto L231;
        ss8.g r106 = H3();
        if (r106 == null) goto L226;
        ss8.g.a r107 = r106.TI();
        if (r107 == null) goto L232;
        hk9.a r108 = this.H0;
        if (r108 == null) goto L138;
        ViewParent r109 = r108.getParent();
        if ((r109 instanceof ViewGroup) == false) goto L135;
        ViewGroup r145 = (ViewGroup) r109;
    L136:
        if (r145 == null) goto L138;
        r145.removeView(r108);
        goto L138
    L135:
        r145 = null;
    L138:
        this.H0 = null;
        r144.setVisibility(0);
        hk9.a r146 = ((tp8.d) r107).a(r144);
        r144.addView(r146);
        this.H0 = r146;
        return;
    L232:
        return;
    L226:
        return;
    L231:
        return;
    L225:
        return;
    L224:
        return;
    L139:
        gd8.f r147 = G3();
        if (r147 == null) goto L228;
        LarusPageChatBinding r148 = r147.e();
        if (r148 == null) goto L229;
        FrameLayout r149 = r148.f311093i;
        if (r149 == null) goto L230;
        r149.setVisibility(8);
        return;
    L230:
        return;
    L229:
        return;
    L228:
        return;
    L109:
        r104 = null;
        goto L110
    L99:
        r140 = null;
        goto L101
    L92:
        if (r137.e6() != true) goto L94;
        r138 = true;
        goto L95
    L85:
        if (r135.i0() != true) goto L87;
        r136 = true;
    L103:
        if (this.N == true) goto L105;
        r141 = true;
        goto L106
    L78:
        if (r133.H1() != true) goto L80;
        r134 = true;
        goto L81
    L147:
        hk9.a r150 = this.H0;
        if (r150 == null) goto L155;
        ViewParent r151 = r150.getParent();
        if ((r151 instanceof ViewGroup) == false) goto L152;
        ViewGroup r152 = (ViewGroup) r151;
    L153:
        if (r152 == null) goto L155;
        r152.removeView(r150);
        goto L155
    L152:
        r152 = null;
    L155:
        this.H0 = null;
        gd8.f r153 = G3();
        if (r153 == null) goto L163;
        LarusPageChatBinding r154 = r153.e();
        if (r154 == null) goto L163;
        FrameLayout r155 = r154.f311094j;
        if (r155 == null) goto L163;
        r155.removeAllViews();
        r155.setVisibility(8);
    L163:
        gd8.f r156 = G3();
        if (r156 == null) goto L170;
        LarusPageChatBinding r157 = r156.e();
        if (r157 == null) goto L170;
        FrameLayout r158 = r157.f311093i;
        if (r158 == null) goto L170;
        r158.setVisibility(0);
        ViewGroup.LayoutParams r159 = r158.getLayoutParams();
        r159.height = -2;
        r158.setLayoutParams(r159);
    L170:
        IChatMessageShareAbility r160 = (IChatMessageShareAbility) this.A.getValue();
        if (r160 != null) goto L173;
    L175:
        boolean r161 = false;
    L176:
        if (r161 == true) goto L197;
        com.larus.bmhome.chat.component.collection.o r162 = (com.larus.bmhome.chat.component.collection.o) s1a.d.a(this).getAbility(com.larus.bmhome.chat.component.collection.o.class);
        if (r162 != null) goto L180;
    L182:
        boolean r163 = false;
    L183:
        if (r163 == true) goto L197;
        com.larus.bmhome.chat.component.showcase.x r164 = (com.larus.bmhome.chat.component.showcase.x) this.f297963z.getValue();
        if (r164 != null) goto L187;
    L189:
        r100 = false;
    L190:
        if (r100 == true) goto L197;
        com.larus.bmhome.chat.component.cvs.y r165 = u0();
        if (r165 == null) goto L195;
        r101 = r165.h();
    L195:
        if (ic8.n.d(r101) == true) goto L197;
    L212:
        if (ce8.c.a() == true) goto L216;
        va8.o r166 = C3();
        if (r166 == null) goto L216;
        r166.nX();
    L216:
        gd8.f r167 = G3();
        if (r167 == null) goto L237;
        LarusPageChatBinding r168 = r167.e();
        if (r168 == null) goto L238;
        FrameLayout r169 = r168.f311088d;
        if (r169 == null) goto L239;
        r169.setVisibility(0);
        return;
    L239:
        return;
    L238:
        return;
    L237:
        return;
    L187:
        if (r164.e6() != true) goto L189;
    L180:
        if (r162.i0() != true) goto L182;
        r163 = true;
    L197:
        if (this.N == true) goto L212;
        ICoreInputAbility r170 = E3();
        if (r170 == null) goto L201;
        r170.qp(false);
    L201:
        va8.o r171 = C3();
        if (r171 == null) goto L204;
        r171.RQ();
    L204:
        gd8.f r172 = G3();
        if (r172 == null) goto L233;
        LarusPageChatBinding r173 = r172.e();
        if (r173 == null) goto L234;
        FrameLayout r174 = r173.f311088d;
        if (r174 == null) goto L235;
        r174.setVisibility(8);
        return;
    L235:
        return;
    L234:
        return;
    L233:
        return;
    L173:
        if (r160.H1() != true) goto L175;
        r161 = true;
        goto L176
    L57:
        if (r126.bc(ChatUIBlockConfig.HIDE_INPUT_BAR) != true) goto L59;
        r127 = true;
        goto L61
    L10:
        if (r112.f307542d != true) goto L12;
        r113 = true;
        goto L13
    }

    public final void m3(boolean r100) {
        b r101 = this.O;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.f297966c;
    L6:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r104 = f70();
        if (r104 == null) goto L9;
        r104.dP();
    L9:
        this.O = null;
        de8.c r105 = f1();
        if (r105 == null) goto L14;
        Bundle r106 = r105.f468086b;
        if (r106 == null) goto L14;
        r106.remove("human_merge_forward_info");
    L14:
        de8.c r107 = f1();
        if (r107 == null) goto L19;
        Bundle r108 = r107.f468086b;
        if (r108 == null) goto L19;
        r108.remove("human_merge_forward_keep_cache");
    L19:
        if (r100 == false) goto L33;
        ConcurrentHashMap<String, String> r109 = b4.f297384a;
        if (r103 != null) goto L23;
    L28:
        if (r102 == null) goto L34;
        IChatLarkForwardService r110 = (IChatLarkForwardService) this.T.getValue();
        if (r110 == null) goto L35;
        r110.D(r102);
        return;
    L35:
        return;
    L34:
        return;
    L23:
        if ((!StringsKt.isBlank(r103)) == true) goto L26;
        r103 = null;
    L26:
        if (r103 == null) goto L28;
        r102 = b4.f297384a.remove(r103);
        goto L28
    L33:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r110) {
        Intrinsics.checkNotNullParameter(r110, "view");
        FLogger r111 = FLogger.f375446a;
        r111.d("ChatBottomComponent", "onViewCreated");
        LarusPageChatBinding r100 = z3();
        if (r100 == null) goto L5;
        h3(r100.f311093i, true);
    L5:
        Intrinsics.checkNotNullParameter(this, "<this>");
        ActivityResultCaller r101 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.ixigua.lib.track.ITrackNode");
        by7.e r102 = (by7.e) r101;
        gd8.f r103 = G3();
        if (r103 == null) goto L12;
        LarusPageChatBinding r104 = r103.e();
        if (r104 == null) goto L12;
        FrameLayout r105 = r104.f311093i;
        if (r105 == null) goto L12;
        r105.setTag(R.id.lib_track_tag_parent_track_node, r102);
    L12:
        ChatConstraintLayout r106 = null;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatBottomComponent$registerKeyBoardEvents$1(this, null), 3, null);
        va8.o r107 = C3();
        if (r107 == null) goto L15;
        r107.GM(this.Y);
    L15:
        ICoreInputAbility r108 = E3();
        if (r108 == null) goto L18;
        r108.Jm(this.Z);
    L18:
        fx9.a r109 = (fx9.a) s1a.d.a(this).getAbility(fx9.a.class);
        if (r109 == null) goto L21;
        r109.q9(new com.larus.bmhome.chat.component.bottom.a(this));
    L21:
        e2 r112 = (e2) s1a.d.a(this).getAbility(e2.class);
        if (r112 == null) goto L24;
        r112.q9(new l());
    L24:
        r111.d("ChatBottomComponent", "observeConversationChanged");
        this.H = new b1(this);
        com.larus.bmhome.chat.component.cvs.y r113 = u0();
        if (r113 == null) goto L27;
        r113.rh(new z(), this.H);
    L27:
        this.I = new c1(this);
        com.larus.bmhome.chat.component.cvs.y r114 = u0();
        if (r114 == null) goto L30;
        r114.ll(new r(), this.I);
    L30:
        wc9.e r115 = AuthModelDelegate.f297134b.y().getValue();
        if (r115 == null) goto L33;
        String r116 = r115.f559198a;
    L34:
        if (r116 != null) goto L37;
        r116 = "";
    L37:
        if (z2.f365865a.enableNewAddLocalMessageStrategy() == false) goto L46;
        com.larus.bmhome.chat.component.cvs.y r117 = u0();
        if (r117 == null) goto L41;
        String r118 = r117.Y1();
    L43:
        if (Intrinsics.areEqual(r118, r116) == false) goto L46;
        boolean r119 = false;
    L48:
        if (AppHost.f326268a.isPlugin() == true) goto L56;
        if (r119 == false) goto L56;
        r111.i("ChatBottomComponent", "disableUserInteract");
        LarusPageChatBinding r120 = z3();
        if (r120 == null) goto L55;
        TouchInterceptingView r121 = r120.f311096l;
        if (r121 == null) goto L55;
        com.larus.utils.e1.x(r121);
    L55:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatBottomComponent$enableUserInteract$1(this, null), 3, null);
    L57:
        va8.o r122 = C3();
        if (r122 != null) goto L60;
    L62:
        boolean r123 = false;
    L63:
        this.K = r123;
        InputViewCreatorDelegate r124 = InputViewCreatorDelegate.f298409b;
        LarusPageChatBinding r125 = z3();
        if (r125 == null) goto L66;
        FrameLayout r126 = r125.f311093i;
    L67:
        g9 r127 = r124.f(r126);
        de8.c r128 = f1();
        if (r128 != null) goto L70;
    L72:
        boolean r129 = false;
    L73:
        r124.c(r127, r129);
        de8.c r130 = f1();
        if (r130 == null) goto L127;
        Bundle r131 = r130.f468086b;
        if (r131 == null) goto L127;
        String r132 = r131.getString("human_merge_forward_info");
        if (r132 == null) goto L127;
        if ((!StringsKt.isBlank(r132)) == true) goto L83;
        r132 = null;
    L83:
        if (r132 == null) goto L127;
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L118
        JSONObject r134 = new JSONObject(r132);     // Catch: Throwable -> L118
        JSONArray r135 = r134.optJSONArray("subMsgIds");     // Catch: Throwable -> L118
        ArrayList r136 = new ArrayList();     // Catch: Throwable -> L118
        if (r135 == null) goto L95;
        int r137 = r135.length();     // Catch: Throwable -> L118
        int r138 = 0;
    L87:
        if (r138 >= r137) goto L95;
        String r139 = r135.optString(r138);     // Catch: Throwable -> L118
        Intrinsics.checkNotNull(r139);     // Catch: Throwable -> L118
        if ((!StringsKt.isBlank(r139)) == true) goto L92;
        r139 = null;
    L92:
        if (r139 == null) goto L94;
        r136.add(r139);     // Catch: Throwable -> L118
    L94:
        r138 = r138 + 1;     // Catch: Throwable -> L118
    L95:
        String r140 = r134.optString("messageCacheKey");     // Catch: Throwable -> L118
        Intrinsics.checkNotNull(r140);     // Catch: Throwable -> L118
        if ((!StringsKt.isBlank(r140)) == false) goto L98;
        String r141 = r140;
    L99:
        String r142 = r134.optString("forwardChatId");     // Catch: Throwable -> L118
        Intrinsics.checkNotNull(r142);     // Catch: Throwable -> L118
        if ((!StringsKt.isBlank(r142)) == false) goto L102;
        String r143 = r142;
    L103:
        ConcurrentHashMap<String, tx9.v0.c> r144 = tx9.v0.f547891a;     // Catch: Throwable -> L118
        String r145 = tx9.v0.e(r134.optString("chatType"));     // Catch: Throwable -> L118
        int r146 = r134.optInt("isLarkMsg", 1);     // Catch: Throwable -> L118
        if (r136.isEmpty() == false) goto L106;
        FLogger.f375446a.w("ChatBottomComponent", "parse human merge forward info with empty subMsgIds");     // Catch: Throwable -> L118
    L106:
        FLogger r147 = FLogger.f375446a;     // Catch: Throwable -> L118
        StringBuilder r148 = new StringBuilder();     // Catch: Throwable -> L118
        r148.append("parse human merge forward info success, msgCount=");     // Catch: Throwable -> L118
        r148.append(r136.size());     // Catch: Throwable -> L118
        r148.append(", hasCacheKey=");     // Catch: Throwable -> L118
        if (r141 == null) goto L109;
        boolean r149 = true;
    L110:
        r148.append(r149);     // Catch: Throwable -> L118
        r147.i("ChatBottomComponent", r148.toString());     // Catch: Throwable -> L118
        String r150 = r134.optString("title");     // Catch: Throwable -> L118
        Intrinsics.checkNotNull(r150);     // Catch: Throwable -> L118
        if ((true ^ StringsKt.isBlank(r150)) == true) goto L114;
        r150 = null;
    L114:
        if (r150 != null) goto L116;
        r150 = getContext().getString(R.string.larus_bot_chatHistory_entrance);     // Catch: Throwable -> L118
    L116:
        Object r151 = Result.m9449constructorimpl(new b(r150, r136, r141, r143, r145, r146));     // Catch: Throwable -> L118
    L120:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r151);
        if (r152 == null) goto L124;
        FLogger.f375446a.w("ChatBottomComponent", "parse human merge forward info failed, error=" + r152.getMessage());
    L124:
        if (Result.m9455isFailureimpl(r151) == false) goto L126;
        r151 = null;
    L126:
        final b r153 = (b) r151;
    L128:
        if (r153 == null) goto L146;
        this.O = r153;
        LarusPageChatBinding r154 = z3();
        if (r154 == null) goto L133;
        r106 = r154.f311085a;
    L133:
        if (r106 == null) goto L135;
        r106.post(new x(this, r153));
    L136:
        V3(false);
        ICoreInputAbility r155 = E3();
        if (r155 == null) goto L145;
        r155.tr(new y(this));
        return;
    L145:
        return;
    L135:
        Z3(r153, 0);
        goto L136
    L146:
        return;
    L109:
        r149 = false;
        goto L110
    L102:
        r143 = null;
        goto L103
    L98:
        r141 = null;
    L118:
        th = move-exception;
        Result.Companion r156 = Result.Companion;
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L127:
        r153 = null;
        goto L128
    L70:
        if (r128.D() != true) goto L72;
        r129 = true;
        goto L73
    L66:
        r126 = null;
        goto L67
    L60:
        if (r122.xM() != true) goto L62;
        r123 = true;
    L56:
        r111.i("ChatBottomComponent", "not need to disableUserInteract and enableUserInteract");
        goto L57
    L41:
        r118 = null;
    L46:
        r119 = true;
        goto L48
    L33:
        r116 = null;
        goto L34
    }

    public final void Z3(final b r310, final int r311) {
        com.larus.bmhome.chat.component.bottom.attachment.g1 r100 = f70();
        boolean r101 = false;
        if (r100 == null) goto L7;
        ResourceType r312 = ResourceType.CUSTOM;
        if (r100.eY(CollectionsKt.listOf(new ResourceItemBean("human_merge_forward_card", r310.f297964a, null, null, null, null, 0, null, false, r312, i5.y(), i5.f(), 0, 0, false, false, false, false, 0, null, 1044988, null)), MapsKt.hashMapOf(new Pair[]{TuplesKt.to(Integer.valueOf(r312.getValue()), new r0(this, r310))})) != true) goto L7;
        r101 = true;
    L7:
        if (r101 == false) goto L9;
        V3(true);
        return;
    L9:
        if (r311 < 20) goto L11;
        FLogger.f375446a.w("ChatBottomComponent", "show human merge forward card skipped, attachment holder not ready");
        return;
    L11:
        LarusPageChatBinding r102 = z3();
        if (r102 == null) goto L20;
        ChatConstraintLayout r103 = r102.f311085a;
        if (r103 == null) goto L21;
        r103.postDelayed(new u0(this, r310, r311), 50);
        return;
    L21:
        return;
    }

    public final void h3(View r100, boolean r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (z2.f365865a.adjustPageBottomSpaceOnlyAndroid() == true) goto L8;
        FLogger.f375446a.i("ChatBottomComponent", "adjustBottomViewBottomSpace setting false");
        return;
    L8:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r102 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        if (r102 == null) goto L16;
        t1a.b r103 = s1a.a.g(r102);
        if (r103 == null) goto L16;
        va8.f0 r104 = (va8.f0) r103.getAbility(va8.f0.class);
        if (r104 == null) goto L16;
        r104.R();
    L16:
        if ((s1a.a.getActivity(this) instanceof d4) == true) goto L20;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (com.larus.bmhome.b0.b(com.larus.ui.arch.component.internal.attach.a.b(this, this)) == true) goto L20;
        return;
    L20:
        ViewTreeObserver r105 = r100.getViewTreeObserver();
        if (r105 == null) goto L24;
        r105.addOnGlobalLayoutListener(new c(r100, this, r101));
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.q1
    public final Object o(String r100, Continuation<? super String> r101) {
        return com.larus.platform.service.q.f365787a.o(r100, r101);
    }

    public static final void Y2(ChatBottomComponent r100, final View r101, boolean r102, boolean r103) {
        r100.getClass();
        FLogger.f375446a.i("ChatBottomComponent", "adjustBottomViewBottomSpaceInternal isNavigationBarVisible=" + r102 + " isAddedBottomSpace=" + r100.f297953p0);
        if (r102 == true) goto L11;
        if (r100.f297953p0 != 0) goto L16;
        r100.f297953p0 = c7.b(12);
        if (r103 == false) goto L9;
        r101.setVisibility(4);
    L9:
        ViewGroup.LayoutParams r104 = r101.getLayoutParams();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r105 = (ConstraintLayout.LayoutParams) r104;
        ((ViewGroup.MarginLayoutParams) r105).bottomMargin += r100.f297953p0;
        r101.setLayoutParams(r105);
        r101.post(new t(r101));
        return;
    L16:
        return;
    L11:
        if (r100.f297953p0 <= 0) goto L18;
        if (r103 == false) goto L14;
        r101.setVisibility(4);
    L14:
        ViewGroup.LayoutParams r106 = r101.getLayoutParams();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r107 = (ConstraintLayout.LayoutParams) r106;
        ((ViewGroup.MarginLayoutParams) r107).bottomMargin -= r100.f297953p0;
        r101.setLayoutParams(r107);
        r100.f297953p0 = 0;
        r101.post(new u(r101));
        return;
    }
}
