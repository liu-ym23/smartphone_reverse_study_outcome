package com.obric.assistant.component;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalBizScene;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.view.TitleAvatarImageView;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.GradientMaskView;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import com.larus.network.http.ServiceType;
import com.larus.nova.R;
import com.larus.platform.service.AccountService;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt;
import com.obric.assistant.actionbar.service.ObricActionBarSendServiceExtDelegate;
import com.obric.assistant.actionbar.service.ObricActionBarTrackServiceExtDelegate;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.base.interact.CustomBarAction;
import com.obric.assistant.interaction.base.interact.IObserveToken;
import com.obric.assistant.interaction.base.interact.KeyguardLockedState;
import com.obric.assistant.settings.ReferenceScreenContentConfirmFragment;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import com.obric.assistant.task.skill.ObricOmniModeTag;
import com.obric.assistant.task.skill.ObricOmniModelTag;
import com.obric.assistant.view.ObricIconSwipeUpView;
import com.obric.assistant.window.materials.MaterialSceneType;
import com.obric.oui.material.OMaterialHelper;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
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
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0088\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006*\u0002Ê\u0001\u0018\u0000 ß\u00022\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u00062\u00020\u00072\u00020\b2\u00020\t:\bß\u0002à\u0002á\u0002â\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\n\u0010Á\u0001\u001a\u00030À\u0001H\u0002J\n\u0010Â\u0001\u001a\u00030À\u0001H\u0002J\n\u0010Ú\u0001\u001a\u00030À\u0001H\u0016J\n\u0010Û\u0001\u001a\u00030À\u0001H\u0002J\n\u0010Ü\u0001\u001a\u00030À\u0001H\u0002J\n\u0010Ý\u0001\u001a\u00030À\u0001H\u0002J\n\u0010Þ\u0001\u001a\u00030À\u0001H\u0002J\n\u0010ß\u0001\u001a\u00030À\u0001H\u0002J\u0013\u0010à\u0001\u001a\u00030À\u00012\u0007\u0010á\u0001\u001a\u00020\u000fH\u0002J\u0013\u0010â\u0001\u001a\u00030À\u00012\u0007\u0010á\u0001\u001a\u00020\u000fH\u0002J\n\u0010ã\u0001\u001a\u00030À\u0001H\u0016J\u0013\u0010ä\u0001\u001a\u00030À\u00012\u0007\u0010á\u0001\u001a\u00020\u000fH\u0002J\n\u0010å\u0001\u001a\u00030À\u0001H\u0002J\u0013\u0010æ\u0001\u001a\u00030À\u00012\u0007\u0010á\u0001\u001a\u00020\u000fH\u0002J\u0013\u0010ç\u0001\u001a\u00030À\u00012\u0007\u0010è\u0001\u001a\u00020\u0005H\u0016J\u0013\u0010é\u0001\u001a\u00030À\u00012\u0007\u0010ê\u0001\u001a\u00020\u000fH\u0002J\u0014\u0010ë\u0001\u001a\u00030À\u00012\b\u0010ì\u0001\u001a\u00030¯\u0001H\u0016J\n\u0010í\u0001\u001a\u00030À\u0001H\u0003J\u0014\u0010î\u0001\u001a\u00030À\u00012\b\u0010ï\u0001\u001a\u00030ð\u0001H\u0016J\u0015\u0010ñ\u0001\u001a\u00030À\u00012\t\u0010ò\u0001\u001a\u0004\u0018\u00010\u000fH\u0002J\u0015\u0010ó\u0001\u001a\u00030×\u00012\t\u0010ò\u0001\u001a\u0004\u0018\u00010\u000fH\u0002J\n\u0010ô\u0001\u001a\u00030À\u0001H\u0016J\n\u0010õ\u0001\u001a\u00030À\u0001H\u0016J\n\u0010ö\u0001\u001a\u00030¯\u0001H\u0002J\n\u0010÷\u0001\u001a\u00030À\u0001H\u0016J\n\u0010ø\u0001\u001a\u00030¯\u0001H\u0002J\n\u0010ù\u0001\u001a\u00030¯\u0001H\u0016J\n\u0010ú\u0001\u001a\u00030¯\u0001H\u0016J\u001d\u0010û\u0001\u001a\u00030À\u00012\u0007\u0010ü\u0001\u001a\u00020\r2\b\u0010ý\u0001\u001a\u00030¯\u0001H\u0016J\n\u0010þ\u0001\u001a\u00030À\u0001H\u0016J\n\u0010ÿ\u0001\u001a\u00030¯\u0001H\u0016J\n\u0010\u0080\u0002\u001a\u00030À\u0001H\u0002J\u001d\u0010\u0081\u0002\u001a\u00030À\u00012\u0007\u0010á\u0001\u001a\u00020\u000f2\b\u0010\u0082\u0002\u001a\u00030¯\u0001H\u0002J%\u0010\u0083\u0002\u001a\n\u0012\u0005\u0012\u00030\u0085\u00020\u0084\u00022\b\u0010\u0086\u0002\u001a\u00030¯\u00012\b\u0010\u0082\u0002\u001a\u00030¯\u0001H\u0002J\u001f\u0010\u0087\u0002\u001a\u00030À\u00012\t\u0010ò\u0001\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0088\u0002\u001a\u00030¯\u0001H\u0016J\n\u0010\u0089\u0002\u001a\u00030À\u0001H\u0002J\n\u0010\u008a\u0002\u001a\u00030¯\u0001H\u0002J\u0015\u0010\u008b\u0002\u001a\u00030¯\u00012\t\u0010ò\u0001\u001a\u0004\u0018\u00010\u000fH\u0016J+\u0010\u008c\u0002\u001a\u00030À\u00012\b\u0010\u008d\u0002\u001a\u00030¯\u00012\t\u0010ò\u0001\u001a\u0004\u0018\u00010\u000f2\n\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u008f\u0002H\u0016J)\u0010\u0090\u0002\u001a\u00030À\u00012\t\u0010ò\u0001\u001a\u0004\u0018\u00010\u000f2\f\b\u0002\u0010\u008e\u0002\u001a\u0005\u0018\u00010×\u0001H\u0002¢\u0006\u0003\u0010\u0091\u0002J \u0010\u0092\u0002\u001a\u00030À\u00012\t\u0010ò\u0001\u001a\u0004\u0018\u00010\u000f2\t\u0010\u0093\u0002\u001a\u0004\u0018\u00010\u000fH\u0002J\u0016\u0010\u0094\u0002\u001a\u00030À\u00012\n\b\u0002\u0010\u0095\u0002\u001a\u00030¯\u0001H\u0002J\"\u0010\u0096\u0002\u001a\u0004\u0018\u00010\u000f2\t\u0010ò\u0001\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0097\u0002\u001a\u0005\u0018\u00010\u0098\u0002H\u0002J\u001a\u0010\u0099\u0002\u001a\u00030À\u0001*\u00030\u0098\u00022\t\u0010\u0093\u0002\u001a\u0004\u0018\u00010\u000fH\u0002J\u0013\u0010\u009a\u0002\u001a\u00030À\u00012\u0007\u0010ò\u0001\u001a\u00020\u000fH\u0002J\u0015\u0010\u009b\u0002\u001a\u00030¯\u00012\t\u0010ò\u0001\u001a\u0004\u0018\u00010\u000fH\u0002J\u0013\u0010\u009c\u0002\u001a\u00030À\u00012\u0007\u0010\u009d\u0002\u001a\u00020\u000fH\u0016J>\u0010¢\u0002\u001a\u00030À\u00012\b\u0010£\u0002\u001a\u00030\u008e\u00012\b\u0010¤\u0002\u001a\u00030¥\u00022\b\u0010¾\u0001\u001a\u00030¦\u00022\n\u0010\u0097\u0002\u001a\u0005\u0018\u00010\u0098\u00022\b\u0010§\u0002\u001a\u00030¨\u0002H\u0016J\u0014\u0010©\u0002\u001a\u00030¯\u00012\b\u0010ª\u0002\u001a\u00030«\u0002H\u0002J\u000f\u0010¬\u0002\u001a\u00030À\u0001*\u00030\u0084\u0001H\u0002J\u0014\u0010\u00ad\u0002\u001a\u00030¯\u00012\b\u0010\u0097\u0002\u001a\u00030\u0098\u0002H\u0002J \u0010®\u0002\u001a\u00030À\u00012\n\u0010¯\u0002\u001a\u0005\u0018\u00010¥\u00022\b\u0010°\u0002\u001a\u00030¯\u0001H\u0002J\u001e\u0010±\u0002\u001a\u00030¯\u00012\b\u0010\u0097\u0002\u001a\u00030\u0098\u00022\b\u0010£\u0002\u001a\u00030\u008e\u0001H\u0002J\u001e\u0010²\u0002\u001a\u00030¯\u00012\b\u0010\u0097\u0002\u001a\u00030\u0098\u00022\b\u0010£\u0002\u001a\u00030\u008e\u0001H\u0002J\u001e\u0010³\u0002\u001a\u00030¯\u00012\b\u0010\u0097\u0002\u001a\u00030\u0098\u00022\b\u0010£\u0002\u001a\u00030´\u0002H\u0002J\u0016\u0010µ\u0002\u001a\u00030¯\u00012\n\u0010\u0097\u0002\u001a\u0005\u0018\u00010\u0098\u0002H\u0002J\u0016\u0010¶\u0002\u001a\u00030¯\u00012\n\u0010\u0097\u0002\u001a\u0005\u0018\u00010\u0098\u0002H\u0002J\u0014\u0010·\u0002\u001a\u00030¯\u00012\b\u0010\u0097\u0002\u001a\u00030\u0098\u0002H\u0002J\u001e\u0010¸\u0002\u001a\u00030¯\u00012\b\u0010\u0097\u0002\u001a\u00030\u0098\u00022\b\u0010°\u0002\u001a\u00030«\u0002H\u0002J(\u0010¹\u0002\u001a\u00030À\u00012\b\u0010\u0097\u0002\u001a\u00030\u0098\u00022\b\u0010°\u0002\u001a\u00030«\u00022\b\u0010¤\u0002\u001a\u00030¥\u0002H\u0002J\u0019\u0010º\u0002\u001a\u00030À\u0001*\u00030¦\u00022\b\u0010»\u0002\u001a\u00030¼\u0002H\u0002J\u0019\u0010½\u0002\u001a\u00030À\u0001*\u00030¦\u00022\b\u0010»\u0002\u001a\u00030¼\u0002H\u0002J\u001e\u0010¾\u0002\u001a\u00030¯\u00012\b\u0010\u0097\u0002\u001a\u00030\u0098\u00022\b\u0010£\u0002\u001a\u00030´\u0002H\u0002J\u0016\u0010¿\u0002\u001a\u0005\u0018\u00010À\u00022\b\u0010\u0097\u0002\u001a\u00030\u0098\u0002H\u0002J\u001e\u0010Á\u0002\u001a\u0005\u0018\u00010×\u00012\n\u0010Â\u0002\u001a\u0005\u0018\u00010Ã\u0002H\u0002¢\u0006\u0003\u0010Ä\u0002J(\u0010Å\u0002\u001a\u00030À\u00012\b\u0010\u0097\u0002\u001a\u00030\u0098\u00022\b\u0010£\u0002\u001a\u00030\u008e\u00012\b\u0010Æ\u0002\u001a\u00030¦\u0002H\u0002J\u0014\u0010Ç\u0002\u001a\u00030×\u00012\b\u0010\u0097\u0002\u001a\u00030\u0098\u0002H\u0002J\u0014\u0010È\u0002\u001a\u00030À\u00012\b\u0010£\u0002\u001a\u00030\u008e\u0001H\u0002J6\u0010É\u0002\u001a\u00030À\u00012\b\u0010\u0097\u0002\u001a\u00030\u0098\u00022\n\u0010Ê\u0002\u001a\u0005\u0018\u00010Ë\u00022\b\u0010Ì\u0002\u001a\u00030×\u00012\n\u0010Í\u0002\u001a\u0005\u0018\u00010\u008e\u0001H\u0016J\u001b\u0010Î\u0002\u001a\u00030À\u00012\u000f\u0010Ï\u0002\u001a\n\u0012\u0005\u0012\u00030À\u00010Ð\u0002H\u0002J\n\u0010Ñ\u0002\u001a\u00030À\u0001H\u0002J\u001e\u0010Ò\u0002\u001a\u0005\u0018\u00010×\u00012\n\u0010Í\u0002\u001a\u0005\u0018\u00010\u008e\u0001H\u0002¢\u0006\u0003\u0010Ó\u0002J\u0014\u0010Ô\u0002\u001a\u00030¯\u00012\b\u0010Õ\u0002\u001a\u00030\u0098\u0002H\u0002J\n\u0010Ö\u0002\u001a\u00030À\u0001H\u0002J\u0014\u0010×\u0002\u001a\u00030À\u00012\b\u0010Ø\u0002\u001a\u00030×\u0001H\u0016J\u0013\u0010Ù\u0002\u001a\u00030À\u00012\u0007\u0010Ú\u0002\u001a\u00020\u000fH\u0016J\u001b\u0010Û\u0002\u001a\u0014\u0012\u0007\u0012\u0005\u0018\u00010Ý\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000f0Ü\u0002H\u0016J\u000e\u0010Þ\u0002\u001a\u00030Ý\u0002*\u00020\u000fH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0015\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0015\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0015\u001a\u0004\b,\u0010-R\u001d\u0010/\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0015\u001a\u0004\b1\u00102R\u001d\u00104\u001a\u0004\u0018\u0001058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0015\u001a\u0004\b6\u00107R\u001d\u00109\u001a\u0004\u0018\u00010:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0015\u001a\u0004\b;\u0010<R\u001d\u0010>\u001a\u0004\u0018\u00010?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u0015\u001a\u0004\b@\u0010AR\u001d\u0010C\u001a\u0004\u0018\u00010D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u0015\u001a\u0004\bE\u0010FR\u001d\u0010H\u001a\u0004\u0018\u00010I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\u0015\u001a\u0004\bJ\u0010KR\u001d\u0010M\u001a\u0004\u0018\u00010N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\u0015\u001a\u0004\bO\u0010PR\u001d\u0010R\u001a\u0004\u0018\u00010S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\u0015\u001a\u0004\bT\u0010UR\u001d\u0010W\u001a\u0004\u0018\u00010X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\u0015\u001a\u0004\bY\u0010ZR\u001d\u0010\\\u001a\u0004\u0018\u00010]8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010\u0015\u001a\u0004\b^\u0010_R\u001d\u0010a\u001a\u0004\u0018\u00010b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\be\u0010\u0015\u001a\u0004\bc\u0010dR\u001d\u0010f\u001a\u0004\u0018\u00010g8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bj\u0010\u0015\u001a\u0004\bh\u0010iR\u001d\u0010k\u001a\u0004\u0018\u00010l8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bo\u0010\u0015\u001a\u0004\bm\u0010nR\u001d\u0010p\u001a\u0004\u0018\u00010q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bt\u0010\u0015\u001a\u0004\br\u0010sR\u001d\u0010u\u001a\u0004\u0018\u00010v8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\by\u0010\u0015\u001a\u0004\bw\u0010xR\u001d\u0010z\u001a\u0004\u0018\u00010{8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b~\u0010\u0015\u001a\u0004\b|\u0010}R\u0019\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001a\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001a\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001a\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0088\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u008a\u0001R\"\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0091\u0001\u0010\u0015\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\"\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0096\u0001\u0010\u0015\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001a\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0084\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0098\u0001\u0010\u0086\u0001R\"\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u009d\u0001\u0010\u0015\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\"\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¢\u0001\u0010\u0015\u001a\u0006\b \u0001\u0010¡\u0001R\u0012\u0010£\u0001\u001a\u0005\u0018\u00010\u008e\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010¤\u0001\u001a\u0004\u0018\u00010]8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b¦\u0001\u0010\u0015\u001a\u0005\b¥\u0001\u0010_R\"\u0010§\u0001\u001a\u0005\u0018\u00010¨\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b«\u0001\u0010\u0015\u001a\u0006\b©\u0001\u0010ª\u0001R\u0010\u0010¬\u0001\u001a\u00030\u00ad\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010®\u0001\u001a\u00030¯\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010°\u0001\u001a\u00030¯\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010±\u0001\u001a\u00030¯\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b²\u0001\u0010³\u0001R\u0010\u0010´\u0001\u001a\u00030¯\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010µ\u0001\u001a\u00030¯\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010¶\u0001\u001a\u0005\u0018\u00010·\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bº\u0001\u0010\u0015\u001a\u0006\b¸\u0001\u0010¹\u0001R0\u0010»\u0001\u001a#\u0012\u0017\u0012\u00150¯\u0001¢\u0006\u000f\b½\u0001\u0012\n\b¾\u0001\u0012\u0005\b\b(¿\u0001\u0012\u0005\u0012\u00030À\u00010¼\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010Ã\u0001\u001a#\u0012\u0017\u0012\u00150¯\u0001¢\u0006\u000f\b½\u0001\u0012\n\b¾\u0001\u0012\u0005\b\b(¿\u0001\u0012\u0005\u0012\u00030À\u00010¼\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010Ä\u0001\u001a\u00030Å\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÈ\u0001\u0010\u0015\u001a\u0006\bÆ\u0001\u0010Ç\u0001R\u0013\u0010É\u0001\u001a\u00030Ê\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010Ë\u0001R\u0010\u0010Ì\u0001\u001a\u00030Í\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Î\u0001\u001a\u00030Ï\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Ð\u0001\u001a\u00030Ñ\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Ò\u0001\u001a\u00030¯\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Ó\u0001\u001a\u00030¯\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010Ô\u0001\u001a\u0005\u0018\u00010¯\u0001X\u0082\u000e¢\u0006\u0005\n\u0003\u0010Õ\u0001R\u0015\u0010Ö\u0001\u001a\u0005\u0018\u00010×\u0001X\u0082\u000e¢\u0006\u0005\n\u0003\u0010Ø\u0001R\u0010\u0010Ù\u0001\u001a\u00030¯\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u009e\u0002\u001a\u0011\u0012\u0005\u0012\u00030 \u0002\u0012\u0005\u0012\u00030¡\u00020\u009f\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006ã\u0002"}, d2 = {"Lcom/obric/assistant/component/OrionInstructionComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/obric/assistant/ability/chat/instruction/IObricInstructionAbility;", "Lcom/obric/assistant/ability/IObricInstructionExtAbility;", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility$ChangeListener;", "Lcom/larus/im/bean/conversation/Conversation;", "Lcom/obric/assistant/callback/IChatStyleChangedCallback;", "Lcom/obric/assistant/interaction/base/interact/IObserveToken;", "Lcom/obric/assistant/chat/callback/IOrionCustomActionBarCallback;", "Lcom/larus/bmhome/view/actionbar/CustomActionBarExtCallback;", "<init>", "()V", "actionBarProgress", "", "reportedObricActionPanelShowKey", "", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "Lkotlin/Lazy;", "conversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "conversationAbility$delegate", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "speakerAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "getSpeakerAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "speakerAbility$delegate", "chatBottomAbility", "Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "getChatBottomAbility", "()Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "chatBottomAbility$delegate", "chatBottomSpeakerExtraAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IOChatBottomSpeakerExtraAbility;", "getChatBottomSpeakerExtraAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IOChatBottomSpeakerExtraAbility;", "chatBottomSpeakerExtraAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "chatInputUiCoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUiCoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUiCoreAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "obricPhotoActionAbility", "Lcom/obric/assistant/ability/IObricPhotoActionAbility;", "getObricPhotoActionAbility", "()Lcom/obric/assistant/ability/IObricPhotoActionAbility;", "obricPhotoActionAbility$delegate", "obricSkillAbility", "Lcom/obric/assistant/ability/chat/input/IObricInputSkillAbility;", "getObricSkillAbility", "()Lcom/obric/assistant/ability/chat/input/IObricInputSkillAbility;", "obricSkillAbility$delegate", "clickTalkAbility", "Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "getClickTalkAbility", "()Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "clickTalkAbility$delegate", "continuousTalkCtrlAbility", "Lcom/obric/audio/continuous_talk/IObricContinuousTalkCtrlAbility;", "getContinuousTalkCtrlAbility", "()Lcom/obric/audio/continuous_talk/IObricContinuousTalkCtrlAbility;", "continuousTalkCtrlAbility$delegate", "intercomAbility", "Lcom/obric/assistant/ability/IObricIntercomAbility;", "getIntercomAbility", "()Lcom/obric/assistant/ability/IObricIntercomAbility;", "intercomAbility$delegate", "windowAbility", "Lcom/obric/assistant/ability/IOrionChatWindowAbility;", "getWindowAbility", "()Lcom/obric/assistant/ability/IOrionChatWindowAbility;", "windowAbility$delegate", "obricSpecialInputAbility", "Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "getObricSpecialInputAbility", "()Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "obricSpecialInputAbility$delegate", "obricActionBarAbility", "Lcom/obric/assistant/ability/IObricActionBarAbility;", "getObricActionBarAbility", "()Lcom/obric/assistant/ability/IObricActionBarAbility;", "obricActionBarAbility$delegate", "multimodalAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "getMultimodalAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "multimodalAbility$delegate", "bottomMenuAbility", "Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "getBottomMenuAbility", "()Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "bottomMenuAbility$delegate", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "binding$delegate", "input", "Landroid/widget/FrameLayout;", "getInput", "()Landroid/widget/FrameLayout;", "input$delegate", "inputUiContract", "Lcom/larus/bmhome/ability/ChatInputUiContract;", "getInputUiContract", "()Lcom/larus/bmhome/ability/ChatInputUiContract;", "actionBarContainer", "Landroid/view/ViewGroup;", "getActionBarContainer", "()Landroid/view/ViewGroup;", "actionBar", "Landroidx/recyclerview/widget/RecyclerView;", "getActionBar", "()Landroidx/recyclerview/widget/RecyclerView;", "customActionBarView", "getCustomActionBarView", "borderView", "Landroid/view/View;", "getBorderView", "()Landroid/view/View;", "borderView$delegate", "instructionUiContract", "Lcom/larus/bmhome/instruction/InstructionUiContract;", "getInstructionUiContract", "()Lcom/larus/bmhome/instruction/InstructionUiContract;", "instructionUiContract$delegate", "instructionEditorContainer", "getInstructionEditorContainer", "chatRoot", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getChatRoot", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "chatRoot$delegate", "gestureView", "Lcom/obric/assistant/view/ObricIconSwipeUpView;", "getGestureView", "()Lcom/obric/assistant/view/ObricIconSwipeUpView;", "gestureView$delegate", "deepthinkItemView", "specialInputAbility", "getSpecialInputAbility", "specialInputAbility$delegate", "obricChatInputUiAbility", "Lcom/obric/assistant/chat/bottom/sub/IObricChatInputUIAbility;", "getObricChatInputUiAbility", "()Lcom/obric/assistant/chat/bottom/sub/IObricChatInputUIAbility;", "obricChatInputUiAbility$delegate", "ignoreImeOnce", "Ljava/util/concurrent/atomic/AtomicBoolean;", "speakerVisible", "", "mockSpeakerVisible", "disableActionBarTouch", "getDisableActionBarTouch", "()Z", "isReportActionBarShow", "isMobPhoneOperationActionBarShowWhenFullScreen", "chatDraft", "Lcom/larus/bmhome/chat/model/IChatDraft;", "getChatDraft", "()Lcom/larus/bmhome/chat/model/IChatDraft;", "chatDraft$delegate", "onSpeakerVisibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visible", "", "onSpeakerVisibleChanged", "checkIsMobActionBarShow", "onMockSpeakerVisibleCallback", "avatarView", "Lcom/larus/bmhome/view/TitleAvatarImageView;", "getAvatarView", "()Lcom/larus/bmhome/view/TitleAvatarImageView;", "avatarView$delegate", "actionBarItemTouchListener", "com/obric/assistant/component/OrionInstructionComponent$actionBarItemTouchListener$1", "Lcom/obric/assistant/component/OrionInstructionComponent$actionBarItemTouchListener$1;", "skillSelectionChangeListener", "Lcom/obric/assistant/ability/chat/input/SkillSelectionChangeListener;", "displayedSkillListChangeListener", "Lcom/obric/assistant/ability/chat/input/DisplayedSkillListChangeListener;", "phoneOperationModeChangeListener", "Lcom/obric/assistant/task/skill/ObricTaskSkillModeController$ModeChangeListener;", "phoneOperationModeActiveRefreshScheduled", "skillExtensionSettingObserverStarted", "lastObservedSkillExtensionEnabled", "Ljava/lang/Boolean;", "lastObservedOmniSkillAvailableState", "", "Ljava/lang/Integer;", "fullObricHostCallbacksRegistered", "onParentViewCreated", "observeSkillExtensionSetting", "setupWindowCustomActionBarRefresh", "observeWindowCustomBarActions", "observeActivityCustomBarActions", "observeWindowKeyguardState", "refreshWindowCustomActionBarOnMain", "reason", "refreshWindowCustomActionBar", LiveCommonConstants.REASON_ON_DEDTROY, "refreshPhoneOperationActionBarOnMain", "schedulePhoneOperationActiveRefresh", "refreshPhoneOperationActionBar", "onChange", "new", "setAvatar", "iconUrl", "onChatStyleChanged", "isChatWindow", "onUpdateActionBarView", "onPageStateChanged", "pageState", "Lcom/obric/assistant/data/ObricFloatChatPageState;", "setInputEditorBackground", "actionBarKey", "getInputEditorBackgroundColor", "onResume", WidgetCostModule.TYPE_ON_START, "isMainConversation", "onStop", "isFullObricPageHost", "isInstructionOpen", "showImeWhenOpen", "resetActionBar", "alpha", "half", "ignoreShowImeOnce", "dismissBalloon", "onCustomObricActionChanges", "applyCustomObricActionChanges", "includeScreenPerception", "buildObricActionBarSegments", "", "Lcom/obric/assistant/view/actionbar/custom/ObricBaseSegment;", "isMinorMode", "mobAssistantActionBarShow", "isFromInteractionSession", "mobPhoneOperationActionBarShow", "isShowScreenPerceptionActionBar", "isWebPerceive", "onInstructionVisibleChanged", "instructionOpen", "instructionType", "", "setupInstructionEditorView", "(Ljava/lang/String;Ljava/lang/Integer;)V", "setupPerceptionPanelTitle", "address", "resetPerceptionPanelTitle", "resetTitleWrapper", "getLatestPerceptionAddress", MapController.ITEM_LAYER_TAG, "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "syncPerceptionAddress", "reportObricActionPanelShow", "isObricPerceptionActionPanel", "switchStatus", "inputContent", "styleConfigs", "", "Lcom/obric/assistant/component/OrionInstructionComponent$ActionStyle;", "Lcom/obric/assistant/component/OrionInstructionComponent$StyleConfig;", "updateHolderStyle", RootDescription.ROOT_ELEMENT, "icon", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "callback", "Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;", "isQuickMode", "replyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "addProIcon", "needUpdate", "updateWindowActionBarSuffixArrow", "arrow", "selected", "needRightIcon", "needRemoveRightIcon", "needRightArrow", "Lcom/larus/common_ui/widget/roundlayout/RoundConstraintLayout;", "isObricAction", "isOAutoAction", "isPhoneOperationSkillSelected", "isObricAddedSwitchSelected", "updateDeepThinkPhoneOperationIcon", "applyTextGradient", "colors", "", "doApplyGradient", "isNeedSecondaryMenu", "getRightIconConfig", "Lcom/obric/assistant/component/OrionInstructionComponent$RightIconConfig;", "getRightArrowColor", "taskState", "Lcom/obric/assistant/actionbar/statemanager/state/ObricOAutoTaskState;", "(Lcom/obric/assistant/actionbar/statemanager/state/ObricOAutoTaskState;)Ljava/lang/Integer;", "setupRightIcon", "anchorView", "getSecondaryMenuCloseSwitchView", "removeRightIcon", "onActionBarItemClick", "instructionExtraData", "Lcom/larus/bmhome/instruction/core/model/InstructionExtraData;", "openFrom", "itemView", "ensureReferenceScreenContentEnabled", "onEnabled", "Lkotlin/Function0;", "handleScreenShotActionBarClick", "resolveActionBarClickPosition", "(Landroid/view/View;)Ljava/lang/Integer;", "needCloseClickTalk", "customActionBarItem", "consumeSkillExtensionActionBarNewIfNeeded", "onActionBarScrollStateChanged", "state", "onActionBarHintChanged", "hint", "getConversationIdAndBotId", "Lkotlin/Pair;", "", "atLeastLong", "Companion", "ActionStyle", "StyleConfig", "RightIconConfig", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OrionInstructionComponent extends BaseContentWidget implements qaa.a, laa.e, com.larus.bmhome.chat.component.cvs.y.a<wc9.e>, hca.b, IObserveToken, bda.a, rs8.f {

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public static final int f388336p1 = 0;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final int f388337v1 = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final Lazy H;
    public final c7 H0;
    public final Lazy I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Lazy f388338J;
    public final Lazy K;
    public final Lazy L;
    public final d7 L0;
    public final Lazy M;
    public final Lazy N;
    public View O;
    public final Lazy P;
    public boolean P0;
    public final Lazy Q;
    public final AtomicBoolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean V0;
    public final Lazy W;
    public final h6 X;
    public final i6 Y;
    public final Lazy Z;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public Boolean f388339b1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public Integer f388340g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public boolean f388341h1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final OrionInstructionComponent$actionBarItemTouchListener$1 f388342k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public final Map<ActionStyle, c> f388343k1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f388344m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f388345n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f388346o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f388347p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final b7 f388348p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f388349q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f388350r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f388351s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f388352t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f388353u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f388354v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f388355w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f388356x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f388357y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f388358z;

    /* JADX INFO: loaded from: classes4.dex */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/component/OrionInstructionComponent$ActionStyle;", "", "<init>", "(Ljava/lang/String;I)V", ServiceType.OBRIC, EffectConstants.NORMAL, "SELECTED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ActionStyle extends Enum<ActionStyle> {
        public static final ActionStyle NORMAL = null;
        public static final ActionStyle OBRIC = null;
        public static final ActionStyle SELECTED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ActionStyle[] f388359a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f388360b = null;

        public static EnumEntries<ActionStyle> getEntries() {
            return f388360b;
        }

        static {
            ActionStyle r100 = new ActionStyle(ServiceType.OBRIC, 0);
            OBRIC = r100;
            ActionStyle r101 = new ActionStyle(EffectConstants.NORMAL, 1);
            NORMAL = r101;
            ActionStyle r102 = new ActionStyle("SELECTED", 2);
            SELECTED = r102;
            ActionStyle[] r103 = {r100, r101, r102};
            f388359a = r103;
            f388360b = EnumEntriesKt.enumEntries(r103);
        }

        public static ActionStyle[] values() {
            return (ActionStyle[]) f388359a.clone();
        }

        public static ActionStyle valueOf(String r100) {
            return (ActionStyle) r27.a.a(ActionStyle.class, r100);
        }

        public ActionStyle(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class a {
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f388362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f388363b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f388364c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f388365d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Integer f388366e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f388362a == r101.f388362a) goto L12;
            return false;
        L12:
            if (this.f388363b == r101.f388363b) goto L15;
            return false;
        L15:
            if (this.f388364c == r101.f388364c) goto L18;
            return false;
        L18:
            if (this.f388365d == r101.f388365d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f388366e, r101.f388366e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((this.f388362a * 31) + this.f388363b) * 31) + this.f388364c) * 31) + this.f388365d) * 31;
            Integer r101 = this.f388366e;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "RightIconConfig(iconId=" + this.f388362a + ", iconRes=" + this.f388363b + ", marginStart=" + this.f388364c + ", marginEnd=" + this.f388365d + ", iconColor=" + this.f388366e + ')';
        }

        public b(int r100, int r101) {
            this.f388362a = R.id.obric_custom_action_bar_secondary_menu_button;
            this.f388363b = R.drawable.obric_custom_action_bar_secondary_menu_button_open_icon;
            this.f388364c = r100;
            this.f388365d = r101;
            this.f388366e = null;
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f388367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f388368b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f388369c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f388370d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f388371e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final MaterialSceneType f388372f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f388367a == r101.f388367a) goto L12;
            return false;
        L12:
            if (this.f388368b == r101.f388368b) goto L15;
            return false;
        L15:
            if (this.f388369c == r101.f388369c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f388370d, r101.f388370d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f388371e, r101.f388371e) == true) goto L24;
            return false;
        L24:
            if (this.f388372f == r101.f388372f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f388367a * 31) + this.f388368b) * 31) + this.f388369c) * 31;
            Integer r101 = this.f388370d;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            int[] r105 = this.f388371e;
            if (r105 == null) goto L11;
            r102 = Arrays.hashCode(r105);
        L11:
            return ((r104 + r102) * 31) + this.f388372f.hashCode();
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "StyleConfig(bgColor=" + this.f388367a + ", pressBgColor=" + this.f388368b + ", iconColor=" + this.f388369c + ", textColor=" + this.f388370d + ", gradientColors=" + Arrays.toString(this.f388371e) + ", materialSceneType=" + this.f388372f + ')';
        }

        public c(int r100, int r101, int r102, Integer r103, MaterialSceneType r104, int r105) {
            if ((r105 & 8) == 0) goto L6;
            r103 = null;
        L6:
            if ((r105 & 32) == 0) goto L8;
            r104 = MaterialSceneType.ACTION_BAR;
        L8:
            Intrinsics.checkNotNullParameter(r104, "materialSceneType");
            this.f388367a = r100;
            this.f388368b = r101;
            this.f388369c = r102;
            this.f388370d = r103;
            this.f388371e = null;
            this.f388372f = r104;
        }
    }

    public static final class d implements Function0<paa.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388373a;

        public d(AttachReceiver r100) {
            this.f388373a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [paa.c, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final paa.c invoke() {
            AttachReceiver r100 = this.f388373a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(paa.c.class));
        }
    }

    public static final class e implements Function0<maa.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388374a;

        public e(AttachReceiver r100) {
            this.f388374a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [maa.e, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final maa.e invoke() {
            AttachReceiver r100 = this.f388374a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(maa.e.class));
        }
    }

    public static final class f implements Function0<com.obric.audio.continuous_talk.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388375a;

        public f(AttachReceiver r100) {
            this.f388375a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.audio.continuous_talk.c, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.obric.audio.continuous_talk.c invoke() {
            AttachReceiver r100 = this.f388375a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.obric.audio.continuous_talk.c.class));
        }
    }

    public static final class g implements Function0<laa.f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388376a;

        public g(AttachReceiver r100) {
            this.f388376a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [laa.f, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final laa.f invoke() {
            AttachReceiver r100 = this.f388376a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(laa.f.class));
        }
    }

    public static final class h implements Function0<laa.m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388377a;

        public h(AttachReceiver r100) {
            this.f388377a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [laa.m, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final laa.m invoke() {
            AttachReceiver r100 = this.f388377a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(laa.m.class));
        }
    }

    public static final class i implements Function0<laa.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388378a;

        public i(AttachReceiver r100) {
            this.f388378a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [laa.j, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final laa.j invoke() {
            AttachReceiver r100 = this.f388378a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(laa.j.class));
        }
    }

    public static final class j implements Function0<laa.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388379a;

        public j(AttachReceiver r100) {
            this.f388379a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [laa.b, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final laa.b invoke() {
            AttachReceiver r100 = this.f388379a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(laa.b.class));
        }
    }

    public static final class k implements Function0<com.larus.bmhome.chat.component.bottom.multimodal.g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388380a;

        public k(AttachReceiver r100) {
            this.f388380a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.multimodal.g, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.bmhome.chat.component.bottom.multimodal.g invoke() {
            AttachReceiver r100 = this.f388380a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.multimodal.g.class));
        }
    }

    public static final class l implements Function0<com.larus.bmhome.chat.component.bottom.bottommenu.f1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388381a;

        public l(AttachReceiver r100) {
            this.f388381a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.bottommenu.f1, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.bmhome.chat.component.bottom.bottommenu.f1 invoke() {
            AttachReceiver r100 = this.f388381a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.bottommenu.f1.class));
        }
    }

    public static final class m implements Function0<va8.m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388382a;

        public m(AttachReceiver r100) {
            this.f388382a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.m] */
        @Override // kotlin.jvm.functions.Function0
        public final va8.m invoke() {
            AttachReceiver r100 = this.f388382a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(va8.m.class));
        }
    }

    public static final class n implements Function0<com.larus.bmhome.chat.component.cvs.y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388383a;

        public n(AttachReceiver r100) {
            this.f388383a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.cvs.y, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.bmhome.chat.component.cvs.y invoke() {
            AttachReceiver r100 = this.f388383a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.cvs.y.class));
        }
    }

    public static final class o implements Function0<laa.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388384a;

        public o(AttachReceiver r100) {
            this.f388384a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [laa.j, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final laa.j invoke() {
            AttachReceiver r100 = this.f388384a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(laa.j.class));
        }
    }

    public static final class p implements Function0<ada.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388385a;

        public p(AttachReceiver r100) {
            this.f388385a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [ada.c, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final ada.c invoke() {
            AttachReceiver r100 = this.f388385a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(ada.c.class));
        }
    }

    public static final class q implements Function0<laa.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388386a;

        public q(AttachReceiver r100) {
            this.f388386a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [laa.d, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final laa.d invoke() {
            AttachReceiver r100 = this.f388386a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(laa.d.class));
        }
    }

    public static final class r implements Function0<com.larus.bmhome.chat.component.bottom.core.speaker.l> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388387a;

        public r(AttachReceiver r100) {
            this.f388387a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.core.speaker.l, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.bmhome.chat.component.bottom.core.speaker.l invoke() {
            AttachReceiver r100 = this.f388387a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.core.speaker.l.class));
        }
    }

    public static final class s implements Function0<com.larus.bmhome.chat.component.bottom.p1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388388a;

        public s(AttachReceiver r100) {
            this.f388388a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.p1, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.bmhome.chat.component.bottom.p1 invoke() {
            AttachReceiver r100 = this.f388388a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.p1.class));
        }
    }

    public static final class t implements Function0<com.larus.bmhome.chat.component.bottom.core.speaker.m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388389a;

        public t(AttachReceiver r100) {
            this.f388389a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.core.speaker.m, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.bmhome.chat.component.bottom.core.speaker.m invoke() {
            AttachReceiver r100 = this.f388389a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.core.speaker.m.class));
        }
    }

    public static final class u implements Function0<com.larus.bmhome.instruction.g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388390a;

        public u(AttachReceiver r100) {
            this.f388390a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.instruction.g, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.bmhome.instruction.g invoke() {
            AttachReceiver r100 = this.f388390a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.g.class));
        }
    }

    public static final class v implements Function0<va8.o> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388391a;

        public v(AttachReceiver r100) {
            this.f388391a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.o] */
        @Override // kotlin.jvm.functions.Function0
        public final va8.o invoke() {
            AttachReceiver r100 = this.f388391a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(va8.o.class));
        }
    }

    public static final class w implements Function0<ICoreInputAbility> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388392a;

        public w(AttachReceiver r100) {
            this.f388392a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final ICoreInputAbility invoke() {
            AttachReceiver r100 = this.f388392a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(ICoreInputAbility.class));
        }
    }

    public static final class x implements Function0<laa.h> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388393a;

        public x(AttachReceiver r100) {
            this.f388393a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [laa.h, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final laa.h invoke() {
            AttachReceiver r100 = this.f388393a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(laa.h.class));
        }
    }

    public static final class y implements Function0<de8.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388394a;

        public y(AttachReceiver r100) {
            this.f388394a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [de8.c, t1a.c] */
        @Override // kotlin.jvm.functions.Function0
        public final de8.c invoke() {
            AttachReceiver r100 = this.f388394a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).g(Reflection.getOrCreateKotlinClass(de8.c.class));
        }
    }

    @Override // rs8.f
    public final void q0() {
    }

    @Override // rs8.f
    public final void z1(List<com.larus.bmhome.actionbar.model.z0> r100) {
    }

    static {
        f388336p1 = v19.c7.b(9);
        f388337v1 = v19.c7.b(12);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.obric.assistant.component.h6] */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.obric.assistant.component.OrionInstructionComponent$actionBarItemTouchListener$1] */
    /* JADX WARN: Type inference failed for: r3v7, types: [com.obric.assistant.component.b7] */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.obric.assistant.component.c7] */
    /* JADX WARN: Type inference failed for: r3v9, types: [com.obric.assistant.component.d7] */
    public OrionInstructionComponent() {
        this.f388344m = 1.0f;
        this.f388346o = LazyKt.lazy(new y(this));
        this.f388347p = LazyKt.lazy(new n(this));
        this.f388349q = LazyKt.lazy(new q(this));
        this.f388350r = LazyKt.lazy(new r(this));
        this.f388351s = LazyKt.lazy(new s(this));
        this.f388352t = LazyKt.lazy(new t(this));
        this.f388353u = LazyKt.lazy(new u(this));
        this.f388354v = LazyKt.lazy(new v(this));
        this.f388355w = LazyKt.lazy(new w(this));
        this.f388356x = LazyKt.lazy(new x(this));
        this.f388357y = LazyKt.lazy(new d(this));
        this.f388358z = LazyKt.lazy(new e(this));
        this.A = LazyKt.lazy(new f(this));
        this.B = LazyKt.lazy(new g(this));
        this.C = LazyKt.lazy(new h(this));
        this.D = LazyKt.lazy(new i(this));
        this.E = LazyKt.lazy(new j(this));
        this.F = LazyKt.lazy(new k(this));
        this.G = LazyKt.lazy(new l(this));
        this.H = LazyKt.lazy(new m(this));
        this.I = LazyKt.lazy(new q6(this));
        this.f388338J = LazyKt.lazy(new e7(this));
        this.K = LazyKt.lazy(new f7(this));
        this.L = LazyKt.lazy(new g7(this));
        this.M = LazyKt.lazy(new h7(this));
        this.N = LazyKt.lazy(new i7(this));
        this.P = LazyKt.lazy(new o(this));
        this.Q = LazyKt.lazy(new p(this));
        this.R = new AtomicBoolean(false);
        this.U = true;
        this.V = true;
        this.W = LazyKt.lazy(new g6(this));
        this.X = new h6(this);
        this.Y = new i6(this);
        this.Z = LazyKt.lazy(new j6(this));
        this.f388342k0 = new OrionInstructionComponent$actionBarItemTouchListener$1(this);
        this.f388348p0 = new b7(this);
        this.H0 = new c7(this);
        this.L0 = new d7(this);
        Pair[] r100 = new Pair[3];
        ActionStyle r101 = ActionStyle.OBRIC;
        Integer r110 = Integer.valueOf(R.color.obric_custom_action_bar_text);
        r100[0] = TuplesKt.to(r101, new c(R.color.obric_custom_obric_action_bar_bg, R.color.obric_custom_obric_action_bar_bg_press, R.color.obric_custom_action_bar_text, r110, null, 48));
        r100[1] = TuplesKt.to(ActionStyle.NORMAL, new c(R.color.obric_custom_action_bar_bg, R.color.obric_custom_action_bar_bg_press, R.color.obric_custom_action_bar_text, r110, null, 48));
        ActionStyle r102 = ActionStyle.SELECTED;
        if (OMaterialHelper.f() < 4) goto L5;
        c r103 = new c(R.color.obric_custom_select_action_bar_bg, R.color.obric_custom_select_action_bar_bg_press, R.color.obric_custom_action_bar_selected_text_color, Integer.valueOf(R.color.obric_custom_action_bar_selected_text_color), MaterialSceneType.ACTION_BAR_SELECTED, 16);
    L6:
        r100[2] = TuplesKt.to(r102, r103);
        this.f388343k1 = MapsKt.mapOf(r100);
        return;
    L5:
        r103 = new c(R.color.obric_custom_select_action_bar_bg, R.color.obric_custom_select_action_bar_bg_press, R.color.primary_50, Integer.valueOf(R.color.primary_50), MaterialSceneType.ACTION_BAR_SELECTED, 16);
        goto L6
    }

    public final ICoreInputAbility B3() {
        return (ICoreInputAbility) this.f388355w.getValue();
    }

    public final boolean D3() {
        if (this.S == false) goto L5;
        return true;
    L5:
        if (this.T == false) goto L21;
        IAssistantChatWindow r100 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r100 != null) goto L9;
    L11:
        boolean r101 = false;
    L12:
        if (r101 == true) goto L24;
        laa.f r102 = (laa.f) this.B.getValue();
        if (r102 != null) goto L16;
    L18:
        boolean r103 = false;
    L19:
        if (r103 == false) goto L21;
        return true;
    L16:
        if (r102.kT() != true) goto L18;
        r103 = true;
        goto L19
    L24:
        return true;
    L9:
        if (r100.isWindowMode() != true) goto L11;
        r101 = true;
    L21:
        return false;
    }

    @Override // qaa.a
    public final boolean Fs() {
        return this.R.getAndSet(false);
    }

    public final va8.c G3() {
        va8.o r100 = (va8.o) this.f388354v.getValue();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.Uv();
    }

    public final com.larus.bmhome.instruction.b2 Q3() {
        return (com.larus.bmhome.instruction.b2) this.L.getValue();
    }

    public final com.larus.bmhome.chat.component.bottom.multimodal.g W3() {
        return (com.larus.bmhome.chat.component.bottom.multimodal.g) this.F.getValue();
    }

    public final laa.b X3() {
        return (laa.b) this.E.getValue();
    }

    public final ada.c Z3() {
        return (ada.c) this.Q.getValue();
    }

    public final laa.h a4() {
        return (laa.h) this.f388356x.getValue();
    }

    public final paa.c c4() {
        return (paa.c) this.f388357y.getValue();
    }

    public final laa.d d4() {
        return (laa.d) this.f388349q.getValue();
    }

    public final void l4() {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("onSpeakerVisibleChanged, speakerVisible: ");
        r101.append(this.S);
        r101.append(", mockSpeakerVisible: ");
        r101.append(this.T);
        r101.append(", isMockViewVisible: ");
        laa.f r102 = (laa.f) this.B.getValue();
        GradientMaskView r103 = null;
        if (r102 == null) goto L5;
        Boolean r104 = Boolean.valueOf(r102.kT());
    L6:
        r101.append(r104);
        r101.append(", isWindowMode: ");
        IAssistantChatWindow r105 = IAssistantChatWindowKt.getAssistantChatWindow();
        boolean r106 = true;
        if (r105 != null) goto L9;
    L11:
        boolean r107 = false;
    L12:
        r101.append(r107);
        r100.i("OrionExtraComponent", r101.toString());
        if (s1a.a.d(this) == false) goto L16;
        r100.i("OrionExtraComponent", "speakerVisibleChanged isLandscapeFullWindow, return");
        return;
    L16:
        boolean r108 = D3();
        if (r108 == false) goto L19;
    L30:
        if (r108 == false) goto L32;
        float r109 = 0.0f;
    L33:
        va8.c r110 = G3();
        if (r110 == null) goto L36;
        r103 = ((com.larus.bmhome.chat.component.bottom.core.a) r110).a();
    L36:
        if (r103 == null) goto L38;
        r103.setAlpha(r109);
    L38:
        View r111 = (View) this.K.getValue();
        if (r111 == null) goto L41;
        r111.setAlpha(r109);
    L41:
        laa.h r112 = a4();
        if (r112 == null) goto L44;
        r112.X30();
    L44:
        if (r108 == false) goto L49;
        RecyclerView r113 = C3();
        if (r113 == null) goto L48;
        com.larus.utils.e1.q(r113);
    L48:
        p3().setClickable(false);
    L53:
        if (r108 == false) goto L57;
        r100.i("OrionExtraComponent", "hide gestureView");
        ObricIconSwipeUpView r114 = (ObricIconSwipeUpView) this.N.getValue();
        if (r114 == null) goto L68;
        com.larus.utils.e1.o(r114);
        return;
    L68:
        return;
    L57:
        r100.i("OrionExtraComponent", "check show gestureView");
        ObricIconSwipeUpView r115 = (ObricIconSwipeUpView) this.N.getValue();
        if (r115 != null) goto L60;
    L62:
        r106 = false;
    L63:
        if (r106 == false) goto L70;
        r100.i("OrionExtraComponent", "show gestureView");
        ObricIconSwipeUpView r116 = (ObricIconSwipeUpView) this.N.getValue();
        if (r116 == null) goto L71;
        com.larus.utils.e1.x(r116);
        return;
    L71:
        return;
    L70:
        return;
    L60:
        if (r115.isEnabled() != true) goto L62;
    L49:
        RecyclerView r117 = C3();
        if (r117 == null) goto L52;
        com.larus.utils.e1.x(r117);
    L52:
        p3().setClickable(true);
        goto L53
    L32:
        r109 = 1.0f;
        goto L33
    L19:
        if (s1a.a.e(this) == true) goto L30;
        laa.d r118 = d4();
        if (r118 == null) goto L27;
        ObricFloatChatPageState r119 = r118.getPageState();
        if (r119 == null) goto L27;
        ObricFloatChatPageData.Companion.getClass();
        if ((r119 instanceof vda.b) != true) goto L27;
        boolean r120 = true;
    L28:
        if (r120 == false) goto L30;
        return;
    L27:
        r120 = false;
        goto L28
    L9:
        if (r105.isWindowMode() != true) goto L11;
        r107 = true;
        goto L12
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        if (this.f388341h1 == true) goto L5;
        return;
    L5:
        this.f388341h1 = false;
        laa.d r100 = d4();
        if (r100 == null) goto L8;
        r100.AN(this);
    L8:
        com.larus.bmhome.instruction.g r101 = vc();
        if (r101 == null) goto L11;
        r101.LB(this);
    L11:
        paa.c r102 = c4();
        if (r102 == null) goto L14;
        r102.p70(this.f388348p0);
    L14:
        paa.c r103 = c4();
        if (r103 == null) goto L17;
        r103.N40(this.H0);
    L17:
        CopyOnWriteArraySet<com.obric.assistant.task.skill.f.a> r104 = com.obric.assistant.task.skill.f.f393409a;
        d7 r105 = this.L0;
        Intrinsics.checkNotNullParameter(r105, "listener");
        com.obric.assistant.task.skill.f.f393409a.remove(r105);
        ObricActionBarSendServiceExtDelegate r106 = ObricActionBarSendServiceExtDelegate.f385250b;
        r106.h();
        r106.q();
        IAssistantInteractionServiceKt.getInteractionStateService().unObserveCustomBarActionsState(this);
        IAssistantInteractionServiceKt.getInteractionStateService().unObserveInteractionKeyguardLockedState(this);
        RecyclerView r107 = m3();
        if (r107 == null) goto L20;
        r107.removeOnItemTouchListener(this.f388342k0);
    L20:
        RecyclerView r108 = m3();
        if (r108 == null) goto L23;
        r108.clearOnScrollListeners();
    L23:
        this.V = true;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onResume() {
        if (this.f388341h1 == true) goto L5;
        return;
    L5:
        p4();
    }

    public final TitleAvatarImageView p3() {
        return (TitleAvatarImageView) this.Z.getValue();
    }

    @Override // laa.e
    public final void rg() {
        FLogger.f375446a.i("OrionExtraComponent", "ignoreShowImeOnce");
        this.R.set(true);
    }

    @Override // laa.e
    public final boolean uc() {
        View r100 = this.O;
        this.O = null;
        com.larus.bmhome.view.screenmenu.d r101 = com.larus.bmhome.view.screenmenu.d.f317270a;
        boolean r102 = com.larus.bmhome.view.screenmenu.d.e(r100);
        FLogger.f375446a.i("OrionExtraComponent", "dismissBalloon, showing=" + r102 + ", itemView=" + r100);
        if (r102 == false) goto L7;
        if (r100 == null) goto L9;
        com.larus.bmhome.view.screenmenu.d.b(r100);
        return true;
    L9:
        return false;
    L7:
        return false;
    }

    public final com.larus.bmhome.instruction.g vc() {
        return (com.larus.bmhome.instruction.g) this.f388353u.getValue();
    }

    @Override // bda.a
    public final Pair<Long, String> y1() {
        com.larus.bmhome.chat.component.cvs.y r100 = z3();
        String r101 = null;
        if (r100 == null) goto L12;
        wc9.e r102 = r100.h();
        if (r102 == null) goto L12;
        String r103 = r102.f559198a;
        if (r103 == null) goto L12;
        long r104 = CastLongProtector.parseLong(r103);     // Catch: Throwable -> L10
    L11:
        Long r105 = Long.valueOf(r104);
    L13:
        com.larus.bmhome.chat.component.cvs.y r106 = z3();
        if (r106 == null) goto L17;
        r101 = r106.getBotId();
    L17:
        return new Pair(r105, r101);
    L10:
        r104 = 0;
    L12:
        r105 = null;
        goto L13
    }

    @Override // qaa.a
    public final boolean z0() {
        laa.j r100 = (laa.j) this.P.getValue();
        if (r100 == null) goto L9;
        kotlinx.coroutines.flow.b1 r101 = r100.O4();
        if (r101 == null) goto L9;
        if (((Boolean) r101.getValue()).booleanValue() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final com.larus.bmhome.chat.component.cvs.y z3() {
        return (com.larus.bmhome.chat.component.cvs.y) this.f388347p.getValue();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void B2() {
        if (s1a.a.e(this) == false) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == true) goto L12;
        FLogger.f375446a.i("OrionExtraComponent", "onParentViewCreated: input-only host, skip full O page callbacks");
        return;
    L12:
        this.f388341h1 = true;
        com.larus.bmhome.chat.component.cvs.y r101 = z3();
        if (r101 == null) goto L15;
        com.larus.bmhome.chat.component.cvs.y.b.b(r101, this);
    L15:
        laa.d r102 = d4();
        if (r102 == null) goto L18;
        r102.HU(this);
    L18:
        ObricActionBarSendServiceExtDelegate.f385250b.j(this);
        com.larus.bmhome.instruction.g r103 = vc();
        if (r103 == null) goto L21;
        r103.QX(this);
    L21:
        paa.c r104 = c4();
        if (r104 == null) goto L24;
        r104.hM(this.f388348p0);
    L24:
        paa.c r105 = c4();
        if (r105 == null) goto L27;
        r105.lR(this.H0);
    L27:
        CopyOnWriteArraySet<com.obric.assistant.task.skill.f.a> r106 = com.obric.assistant.task.skill.f.f393409a;
        com.obric.assistant.task.skill.f.a(this.L0);
        if (this.V0 == true) goto L31;
        this.V0 = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new OrionInstructionComponent$observeSkillExtensionSetting$1(this, null), 3, null);
    L31:
        RecyclerView r107 = m3();
        if (r107 == null) goto L35;
        r107.addOnItemTouchListener(this.f388342k0);
    L35:
        if (s1a.a.e(this) == false) goto L38;
        Y2("window_onParentViewCreated");
        IAssistantInteractionServiceKt.getInteractionStateService().observeCustomBarActionsState(this, new f6(this));
        IAssistantInteractionServiceKt.getInteractionStateService().observeInteractionKeyguardLockedState(this, new l6(this));
    L38:
        this.U = true;
        return;
    L5:
        if (d4() != null) goto L8;
        r100 = false;
        goto L9
    }

    public final RecyclerView C3() {
        va8.c r100 = G3();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.d();
    }

    public final ViewGroup H3() {
        com.larus.bmhome.instruction.b2 r100 = Q3();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.g();
    }

    public final void j4() {
        if (com.obric.assistant.task.skill.f.f() == false) goto L5;
    L15:
        this.V = false;
        if (com.obric.assistant.special_input.j.b() == false) goto L18;
        String r100 = "obric_omni_all_skills";
    L19:
        ObricActionBarTrackServiceExtDelegate.f385252b.m(new String[]{"obric_quick_instruction", r100});
        return;
    L18:
        r100 = "obric_all_instruction";
        goto L19
    L5:
        if (this.V == true) goto L7;
        return;
    L7:
        if (com.obric.assistant.task.skill.f.d() == false) goto L22;
        laa.d r101 = d4();
        if (r101 != null) goto L11;
    L13:
        boolean r102 = false;
    L14:
        if (r102 == true) goto L15;
        return;
    L11:
        if (r101.isFullScreen() != true) goto L13;
        r102 = true;
        goto L14
    }

    public final RecyclerView m3() {
        va8.c r100 = G3();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.d();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onStart() {
        if (s1a.a.e(this) == false) goto L6;
        IAssistantInteractionServiceKt.getInteractionStateService().observeCustomBarActionsState(this, new f6(this));
        Y2("window_onStart_before_dialog_show");
        return;
    L6:
        if (s1a.a.e(this) == true) goto L11;
        IAssistantInteractionServiceKt.getInteractionStateService().observeCustomBarActionsState(this, new t6(this));
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onStop() {
        IAssistantInteractionServiceKt.getInteractionStateService().unObserveCustomBarActionsState(this);
    }

    public final void p4() {
        com.larus.bmhome.chat.component.cvs.y r100 = z3();
        if (r100 == null) goto L8;
        String r101 = r100.Y1();
        if (r101 == null) goto L8;
        boolean r102 = com.larus.bmhome.utils.i.g(r101);
    L9:
        if (r102 == true) goto L11;
        return;
    L11:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new OrionInstructionComponent$onCustomObricActionChanges$1(this, null), 3, null);
        RecyclerView r103 = C3();
        if (r103 == null) goto L17;
        RecyclerView.Adapter r104 = r103.getAdapter();
        if (r104 == null) goto L18;
        r104.notifyDataSetChanged();
        return;
    L18:
        return;
    L17:
        return;
    L8:
        r102 = true;
        goto L9
    }

    public static boolean e4(com.larus.bmhome.actionbar.model.z0 r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.f295606b;
    L7:
        if (Intrinsics.areEqual(r102, "obric_screen_qa") == true) goto L49;
        if (r100 == null) goto L10;
        String r103 = r100.f295606b;
    L12:
        if (Intrinsics.areEqual(r103, "obric_document_perception") == true) goto L49;
        if (r100 == null) goto L15;
        String r104 = r100.f295606b;
    L17:
        if (Intrinsics.areEqual(r104, "obric_web_perception") == true) goto L49;
        if (r100 == null) goto L20;
        String r105 = r100.f295606b;
    L22:
        if (Intrinsics.areEqual(r105, "obric_video_perception") == true) goto L49;
        if (r100 == null) goto L25;
        String r106 = r100.f295606b;
    L27:
        if (Intrinsics.areEqual(r106, "obric_photo_perception") == true) goto L49;
        if (r100 == null) goto L30;
        String r107 = r100.f295606b;
    L32:
        if (Intrinsics.areEqual(r107, "obric_im_perception") == true) goto L49;
        if (r100 == null) goto L35;
        String r108 = r100.f295606b;
    L37:
        if (Intrinsics.areEqual(r108, "obric_omni_all_skills") == true) goto L49;
        if (r100 == null) goto L40;
        String r109 = r100.f295606b;
    L42:
        if (Intrinsics.areEqual(r109, "obric_all_instruction") == true) goto L49;
        if (r100 == null) goto L46;
        r101 = r100.f295606b;
    L46:
        if (Intrinsics.areEqual(r101, "obric_quick_instruction") == true) goto L49;
        return false;
    L40:
        r109 = null;
        goto L42
    L35:
        r108 = null;
        goto L37
    L30:
        r107 = null;
        goto L32
    L25:
        r106 = null;
        goto L27
    L20:
        r105 = null;
        goto L22
    L15:
        r104 = null;
        goto L17
    L10:
        r103 = null;
    L49:
        return true;
    L5:
        r102 = null;
        goto L7
    }

    public static boolean i4(String r100) {
        if (Intrinsics.areEqual(r100, "obric_web_perception") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r100, "obric_video_perception") == true) goto L8;
        return false;
    }

    public final void B4(String r100) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L6;
        Y2(r100);
        return;
    L6:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new OrionInstructionComponent$refreshWindowCustomActionBarOnMain$1(this, r100, null), 3, null);
    }

    public final int E3(String r100) {
        boolean r101 = false;
        if (i4(r100) == true) goto L15;
        laa.d r102 = d4();
        if (r102 != null) goto L7;
    L9:
        if (r101 == false) goto L13;
        boolean r103 = v19.h.f552477a;
        if (v19.h.b(getContext()) == false) goto L13;
        return R.color.base_2;
    L13:
        return R.color.base_3;
    L7:
        if (r102.aF() != true) goto L9;
        r101 = true;
        goto L9
    L15:
        laa.d r104 = d4();
        if (r104 != null) goto L18;
    L20:
        if (r101 == false) goto L22;
        return R.color.obric_action_bar_input_bg_color_chat_window;
    L22:
        return R.color.obric_action_bar_input_bg_color;
    L18:
        if (r104.aF() != true) goto L20;
        r101 = true;
        goto L20
    }

    public final void F4(boolean r100) {
        if (H3() != null) goto L5;
        return;
    L5:
        com.larus.bmhome.instruction.b2 r101 = Q3();
        if (r101 == null) goto L59;
        ConstraintLayout r102 = r101.h();
        if (r102 == null) goto L62;
        com.larus.bmhome.instruction.b2 r103 = Q3();
        if (r103 == null) goto L60;
        SimpleDraweeView r104 = r103.k();
        if (r104 == null) goto L63;
        com.larus.bmhome.instruction.b2 r105 = Q3();
        if (r105 == null) goto L61;
        AppCompatTextView r106 = r105.e();
        if (r106 == null) goto L64;
        TextView r107 = (TextView) r102.findViewWithTag("obric_perception_panel_subtitle");
        if (r107 == null) goto L24;
        r102.removeView(r107);
    L24:
        if (r100 == false) goto L34;
        com.larus.bmhome.instruction.b2 r108 = Q3();
        if (r108 == null) goto L34;
        ConstraintLayout r109 = r108.c();
        if (r109 == null) goto L34;
        ViewGroup.LayoutParams r110 = r109.getLayoutParams();
        if (r110 == null) goto L33;
        ConstraintLayout.LayoutParams r111 = (ConstraintLayout.LayoutParams) r110;
        ((ViewGroup.MarginLayoutParams) r111).height = v19.i5.h0();
        r109.setLayoutParams(r111);
        goto L34
    L33:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L34:
        ViewGroup.LayoutParams r112 = r102.getLayoutParams();
        if (r112 == null) goto L58;
        ConstraintLayout.LayoutParams r113 = (ConstraintLayout.LayoutParams) r112;
        ((ViewGroup.MarginLayoutParams) r113).width = -2;
        r113.endToStart = -1;
        r113.endToEnd = -1;
        r113.setMarginEnd(0);
        r102.setLayoutParams(r113);
        if (r100 == false) goto L47;
        com.larus.bmhome.instruction.b2 r114 = Q3();
        if (r114 == null) goto L47;
        AppCompatImageView r115 = r114.i();
        if (r115 == null) goto L47;
        ViewGroup.LayoutParams r116 = r115.getLayoutParams();
        if (r116 == null) goto L46;
        ConstraintLayout.LayoutParams r117 = (ConstraintLayout.LayoutParams) r116;
        r117.topToTop = 0;
        ((ViewGroup.MarginLayoutParams) r117).topMargin = 0;
        r117.bottomToBottom = 0;
        r115.setLayoutParams(r117);
        goto L47
    L46:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L47:
        r106.setMaxLines(1);
        r106.setEllipsize(TextUtils.TruncateAt.END);
        ViewGroup.LayoutParams r118 = r104.getLayoutParams();
        if (r118 == null) goto L56;
        ConstraintLayout.LayoutParams r119 = (ConstraintLayout.LayoutParams) r118;
        r119.topToTop = 0;
        r119.bottomToBottom = 0;
        r104.setLayoutParams(r119);
        ViewGroup.LayoutParams r120 = r106.getLayoutParams();
        if (r120 == null) goto L54;
        ConstraintLayout.LayoutParams r121 = (ConstraintLayout.LayoutParams) r120;
        ((ViewGroup.MarginLayoutParams) r121).width = -2;
        r121.startToEnd = r104.getId();
        r121.endToEnd = -1;
        r121.topToTop = 0;
        ((ViewGroup.MarginLayoutParams) r121).topMargin = 0;
        r121.bottomToTop = -1;
        r121.bottomToBottom = 0;
        r121.verticalChainStyle = 0;
        r106.setLayoutParams(r121);
        return;
    L54:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L56:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L58:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L64:
        return;
    L61:
        return;
    L63:
        return;
    L60:
        return;
    L62:
        return;
    }

    @Override // bda.a
    public final void S(String r100) {
        Intrinsics.checkNotNullParameter(r100, "hint");
        ICoreInputAbility r101 = B3();
        if (r101 == null) goto L6;
        r101.M5(r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y2(String r110) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L30
        List r101 = CollectionsKt.toMutableList(h3(com.larus.platform.service.x1.f365857a.a()));     // Catch: Throwable -> L30
        int r102 = com.obric.assistant.task.skill.e.f393408a;     // Catch: Throwable -> L30
        t1a.b r103 = s1a.d.a(this);     // Catch: Throwable -> L30
        Context r104 = getContext();     // Catch: Throwable -> L30
        Intrinsics.checkNotNullParameter(r103, "vContext");     // Catch: Throwable -> L30
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L30
        List r105 = CollectionsKt.listOf(new qha.j(r103, r104));     // Catch: Throwable -> L30
        r101.addAll(r105);     // Catch: Throwable -> L30
        if (s1a.d.a(this).a(de8.c.class) != null) goto L7;
        FLogger.f375446a.i("OrionExtraComponent", "applyCustomObricActionChanges, chatArgumentData is null, reason=" + r110);     // Catch: Throwable -> L30
        return;
    L7:
        com.larus.bmhome.chat.model.j1 r106 = (com.larus.bmhome.chat.model.j1) this.W.getValue();     // Catch: Throwable -> L30
        if (r106 == null) goto L10;
        r106.b(false);     // Catch: Throwable -> L30
    L10:
        laa.b r107 = X3();     // Catch: Throwable -> L30
        if (r107 == null) goto L13;
        r107.Zw(CollectionsKt.minus(r101, CollectionsKt.toSet(r105)));     // Catch: Throwable -> L30
    L13:
        List r108 = r101;     // Catch: Throwable -> L30
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));     // Catch: Throwable -> L30
        Iterator r111 = r108.iterator();     // Catch: Throwable -> L30
    L15:
        if (r111.hasNext() == false) goto L17;
        r109.add(((qha.e) r111.next()).k());     // Catch: Throwable -> L30
        goto L15
    L17:
        final Set r112 = CollectionsKt.toSet(r109);     // Catch: Throwable -> L30
        com.larus.bmhome.instruction.g r113 = vc();     // Catch: Throwable -> L30
        Unit r114 = null;
        if (r113 == null) goto L28;
        Function1 r115 = new n6(r112);     // Catch: Throwable -> L30
        if (s1a.a.e(this) == false) goto L22;
        o6 r116 = new o6();     // Catch: Throwable -> L30
    L24:
        if (s1a.a.e(this) == false) goto L26;
        p6 r117 = new p6();     // Catch: Throwable -> L30
    L27:
        com.larus.bmhome.instruction.g.a.a(r113, r101, r115, r116, r117, 2);     // Catch: Throwable -> L30
        r114 = Unit.INSTANCE;     // Catch: Throwable -> L30
        goto L28
    L26:
        r117 = 0;
        goto L27
    L22:
        r116 = 0;
    L28:
        Object r118 = Result.m9449constructorimpl(r114);     // Catch: Throwable -> L30
    L32:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);
        if (r119 == null) goto L38;
        FLogger.f375446a.e("OrionExtraComponent", "applyCustomObricActionChanges error, reason=" + r110, r119);
        return;
    L38:
        return;
    L30:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L32
    }

    @Override // com.larus.bmhome.chat.component.cvs.y.a
    public final void c(wc9.e r100) {
        wc9.e r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "new");
        if (ic8.n.v(r101) == false) goto L31;
        IconImage r102 = r101.f559199b;
        if (r102 == null) goto L10;
        ImageObj r103 = r102.imageThumb;
        if (r103 == null) goto L10;
        String r104 = r103.url;
    L11:
        String r105 = "";
        if (r104 != null) goto L15;
        r104 = "";
    L15:
        if (r104.length() != 0) goto L17;
        boolean r106 = true;
    L18:
        if (r106 == false) goto L29;
        IconImage r107 = r101.f559199b;
        if (r107 == null) goto L24;
        ImageObj r108 = r107.imageOri;
        if (r108 == null) goto L24;
        String r109 = r108.url;
    L25:
        if (r109 == null) goto L28;
        r105 = r109;
    L28:
        r104 = r105;
    L24:
        r109 = null;
    L29:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new OrionInstructionComponent$setAvatar$1(this, r104, null), 2, null);
        return;
    L17:
        r106 = false;
    L10:
        r104 = null;
        goto L11
    }

    @Override // rs8.f
    public final void g8(int r100) {
        laa.d r101 = d4();
        if (r101 == null) goto L6;
        r101.g8(r100);
        return;
    }

    public final List h3(boolean r100) {
        if (r100 == true) goto L4;
        boolean r101 = true;
        if (s1a.a.e(this) == true) goto L23;
        laa.d r102 = d4();
        if (r102 != null) goto L10;
    L12:
        boolean r103 = false;
    L13:
        if (r103 == true) goto L23;
        laa.d r104 = d4();
        if (r104 != null) goto L17;
    L19:
        boolean r105 = false;
    L20:
        if (r105 == true) goto L23;
        r101 = false;
        goto L23
    L17:
        if (r104.Xh() != true) goto L19;
        r105 = true;
        goto L20
    L10:
        if (r102.aF() != true) goto L12;
        r103 = true;
    L23:
        if (r101 == true) goto L27;
        return CollectionsKt.emptyList();
    L27:
        if (IAssistantInteractionServiceKt.getInteractionStateService().getInteractionKeyguardLockedState() == KeyguardLockedState.LOCKED) goto L29;
        ArrayList<CustomBarAction> r106 = IAssistantInteractionServiceKt.getInteractionStateService().getCustomBarActions();
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r106.iterator();
    L32:
        if (r108.hasNext() == false) goto L61;
        CustomBarAction r109 = (CustomBarAction) r108.next();
        String r110 = r109.getUri();
        String r111 = r109.getKey();
        switch(r111.hashCode()) {
            case 241623133: goto L56;
            case 295367523: goto L49;
            case 596623375: goto L45;
            case 780021240: goto L41;
            case 1890683158: goto L37;
            default: goto L58;
        };
    L58:
        ss8.e r112 = null;
    L59:
        if (r112 == null) goto L32;
        r107.add(r112);
        goto L32
    L37:
        if (r111.equals("obric_web_perception") == false) goto L58;
        r112 = new qha.s(s1a.d.a(this), getContext(), r110);
        goto L59
    L41:
        if (r111.equals("obric_photo_perception") == false) goto L58;
        r112 = new qha.p(s1a.d.a(this), getContext(), r110);
        goto L59
    L45:
        if (r111.equals("obric_video_perception") == false) goto L58;
        r112 = new qha.r(s1a.d.a(this), getContext(), r110);
        goto L59
    L49:
        if (r111.equals("obric_document_perception") == false) goto L58;
        laa.h r113 = a4();
        if (r113 == null) goto L54;
        r113.hK(r109.getFileSize());
    L54:
        r112 = new qha.h(s1a.d.a(this), getContext(), r110);
        goto L59
    L56:
        if (r111.equals("obric_screen_qa") == false) goto L58;
        r112 = new qha.q(s1a.d.a(this), getContext(), r110);
        goto L59
    L61:
        return r107;
    L29:
        return CollectionsKt.emptyList();
    L4:
        return CollectionsKt.emptyList();
    }

    @Override // qaa.a
    public final boolean k60(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (i4(r100) == false) goto L41;
        String r101 = null;
        G4(r100, null);
        boolean r102 = v19.h.f552477a;
        if (v19.h.b(getContext()) == false) goto L21;
        if (Intrinsics.areEqual(r100, "obric_web_perception") == false) goto L13;
        Integer r103 = Integer.valueOf(R.drawable.obric_custom_action_bar_web_perception_main_icon_dark);
    L16:
        if (r103 == null) goto L21;
        int r104 = r103.intValue();
        com.larus.bmhome.instruction.b2 r105 = Q3();
        if (r105 == null) goto L21;
        r105.b(com.larus.utils.y0.k(UriProtector.parse("res://" + AppHost.f326268a.getApplication().getPackageName() + '/' + r104)), null);
        goto L21
    L13:
        if (Intrinsics.areEqual(r100, "obric_video_perception") == false) goto L15;
        r103 = Integer.valueOf(R.drawable.obric_custom_action_bar_video_perception_main_icon_dark);
        goto L16
    L15:
        r103 = null;
    L21:
        if (i4(r100) == false) goto L41;
        if (Intrinsics.areEqual(this.f388345n, r100) == true) goto L41;
        this.f388345n = r100;
        ObricActionBarTrackServiceExtDelegate r106 = ObricActionBarTrackServiceExtDelegate.f385252b;
        com.larus.bmhome.chat.component.cvs.y r107 = z3();
        if (r107 == null) goto L29;
        r101 = r107.getBotId();
    L29:
        if (r101 != null) goto L31;
        r101 = "";
    L31:
        com.larus.bmhome.chat.component.cvs.y r108 = z3();
        long r109 = 0;
        if (r108 == null) goto L39;
        wc9.e r110 = r108.h();
        if (r110 == null) goto L39;
        String r111 = r110.f559198a;
        if (r111 == null) goto L39;
        r109 = CastLongProtector.parseLong(r111);     // Catch: Throwable -> L59
    L39:
        r106.s(r100, r101, r109);
    L41:
        if (i4(r100) == false) goto L43;
    L57:
        return true;
    L43:
        if (Intrinsics.areEqual(r100, "obric_oauto") == false) goto L62;
        laa.j r112 = (laa.j) this.D.getValue();
        if (r112 == null) goto L55;
        kotlinx.coroutines.flow.b1 r113 = r112.i80();
        if (r113 == null) goto L55;
        laa.v r114 = (laa.v) r113.getValue();
        if (r114 == null) goto L55;
        StateInfo r115 = r114.f508239b;
        if (r115 == null) goto L55;
        if (r115.getRequestType() != 0) goto L55;
        boolean r116 = true;
    L56:
        if (r116 == true) goto L57;
        return false;
    L55:
        r116 = false;
        goto L56
    L62:
        return false;
    }

    public final void q4(String r100) {
        FLogger.f375446a.i("OrionExtraComponent", "refreshPhoneOperationActionBar, reason=" + r100);
        laa.b r101 = X3();
        if (r101 == null) goto L8;
        List<qha.e> r102 = r101.i30();
        if (r102 == null) goto L8;
        List<? extends qha.e> r103 = CollectionsKt.toMutableList(r102);
        if (r103 == null) goto L8;
    L9:
        final List<? extends qha.e> r104 = r103;
        int r105 = com.obric.assistant.task.skill.e.f393408a;
        t1a.b r106 = s1a.d.a(this);
        Context r107 = getContext();
        Intrinsics.checkNotNullParameter(r106, "vContext");
        Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
        List r108 = CollectionsKt.listOf(new qha.j(r106, r107));
        CollectionsKt.removeAll(r104, new r6());
        r104.addAll(r108);
        laa.b r109 = X3();
        if (r109 == null) goto L12;
        r109.Zw(r104);
    L12:
        com.larus.bmhome.instruction.g r110 = vc();
        if (r110 == null) goto L16;
        com.larus.bmhome.instruction.g.a.a(r110, r104, new s6(r104), null, null, 26);
        return;
    L16:
        return;
    L8:
        r103 = new ArrayList();
        goto L9
    }

    @Override // hca.b
    public final void r2(boolean r110) {
        p4();
        ConstraintLayout.LayoutParams r100 = null;
        boolean r101 = false;
        if (r110 == true) goto L5;
        laa.d r102 = d4();
        if (r102 == null) goto L24;
        ObricFloatChatPageState r103 = r102.getPageState();
    L25:
        ObricFloatChatPageData.Companion.getClass();
        boolean r104 = r103 instanceof vda.d;
        if (r104 == false) goto L28;
    L29:
        IAssistantInteractionServiceKt.getInteractionStateService().unObserveCustomBarActionsState(this);
    L30:
        if (r104 == false) goto L35;
        if (s1a.a.e(this) == true) goto L35;
        j4();
    L35:
        if ((r103 instanceof vda.e) == false) goto L40;
        FLogger.f375446a.i("OrionExtraComponent", "onChatStyleChanged is half window, checkIsMobActionBarShow");
        if (this.U == false) goto L39;
        this.U = false;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new OrionInstructionComponent$checkIsMobActionBarShow$1(this, null), 3, null);
    L39:
        j4();
    L40:
        com.larus.bmhome.chat.component.bottom.core.speaker.m r105 = (com.larus.bmhome.chat.component.bottom.core.speaker.m) this.f388352t.getValue();
        if (r105 == null) goto L43;
        r105.T3(this.X);
    L43:
        laa.f r106 = (laa.f) this.B.getValue();
        if (r106 == null) goto L46;
        r106.T3(this.Y);
    L46:
        i6 r107 = this.Y;
        laa.f r108 = (laa.f) this.B.getValue();
        if (r108 != null) goto L49;
    L51:
        boolean r109 = false;
    L52:
        r107.invoke(Boolean.valueOf(r109));
        RecyclerView r111 = C3();
        if (r111 == null) goto L60;
        r111.setFadingEdgeLength(v19.i5.d0());
        if (s1a.a.e(this) == true) goto L57;
        if (r110 == true) goto L57;
    L58:
        r111.setHorizontalFadingEdgeEnabled(r101);
        return;
    L57:
        r101 = true;
        goto L58
    L60:
        return;
    L49:
        if (r108.kT() != true) goto L51;
        r109 = true;
        goto L52
    L28:
        if ((r103 instanceof vda.f) == false) goto L30;
    L24:
        r103 = null;
        goto L25
    L5:
        if ((p3().getParent() instanceof ViewGroup) == false) goto L8;
        ViewParent r112 = p3().getParent();
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r112).removeView(p3());
    L8:
        if (s1a.a.e(this) == true) goto L20;
        RecyclerView r113 = C3();
        if (r113 == null) goto L12;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
    L14:
        if ((r114 instanceof ConstraintLayout.LayoutParams) == false) goto L16;
        r100 = (ConstraintLayout.LayoutParams) r114;
    L16:
        if (r100 == null) goto L20;
        ((ViewGroup.MarginLayoutParams) r100).width = 0;
        r100.endToEnd = 0;
        r100.topToTop = 0;
        r100.bottomToBottom = 0;
        r100.startToStart = 0;
        RecyclerView r115 = C3();
        if (r115 == null) goto L20;
        r115.setLayoutParams(r100);
        goto L20
    L12:
        r114 = null;
    L20:
        com.larus.utils.e1.d(p3(), new m6(this));
        goto L40
    }

    public final void v4(String r100) {
        if (com.obric.assistant.task.skill.f.d() == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L9;
        q4(r100);
        return;
    L9:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new OrionInstructionComponent$refreshPhoneOperationActionBarOnMain$1(this, r100, null), 3, null);
    }

    @Override // hca.b
    public final void x1(ObricFloatChatPageState r100) {
        Intrinsics.checkNotNullParameter(r100, "pageState");
        ObricFloatChatPageData.Companion.getClass();
        if ((r100 instanceof vda.b) == false) goto L8;
        laa.h r101 = a4();
        if (r101 == null) goto L8;
        r101.X30();
    L8:
        if ((r100 instanceof vda.d) == false) goto L10;
    L13:
        com.larus.bmhome.chat.component.bottom.bottommenu.f1 r102 = (com.larus.bmhome.chat.component.bottom.bottommenu.f1) this.G.getValue();
        if (r102 != null) goto L16;
        return;
    L16:
        if (r102.sL() == true) goto L18;
        return;
    L18:
        if (s1a.a.e(this) == true) goto L26;
        com.larus.bmhome.chat.component.bottom.bottommenu.f1 r103 = (com.larus.bmhome.chat.component.bottom.bottommenu.f1) this.G.getValue();
        if (r103 == null) goto L27;
        r103.hP(true);
        return;
    L27:
        return;
    L26:
        return;
    L10:
        if ((r100 instanceof vda.f) == true) goto L13;
        if ((r100 instanceof vda.e) == true) goto L13;
    }

    @Override // qaa.a
    public final void yh(String r100) {
        Intrinsics.checkNotNullParameter(r100, "inputContent");
        if (com.larus.utils.o0.d(StringsKt.trim(r100).toString()) == false) goto L8;
        ICoreInputAbility r101 = B3();
        if (r101 == null) goto L9;
        r101.g2(3, true);
        return;
    L9:
        return;
    }

    public static void R4(com.larus.bmhome.actionbar.model.z0 r100, String r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.length() <= 0) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L10;
        r101 = null;
    L10:
        if (r101 == null) goto L23;
        com.larus.bmhome.actionbar.model.r r103 = r100.f295621q;
        if (r103 == null) goto L17;
        com.larus.bmhome.actionbar.model.h1 r104 = r103.f295410c;
        if (r104 == null) goto L17;
        r104.f295181b = r101;
    L17:
        com.larus.bmhome.actionbar.model.h1 r105 = r100.f295615k;
        if (r105 == null) goto L22;
        r105.f295181b = r101;
        return;
    L22:
        return;
    L23:
        return;
    L6:
        r102 = false;
        goto L7
    }

    public static String V3(String r100, com.larus.bmhome.actionbar.model.z0 r101) {
        if (i4(r100) == true) goto L5;
        return null;
    L5:
        Iterator<T> r102 = IAssistantInteractionServiceKt.getInteractionStateService().getCustomBarActions().iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((CustomBarAction) r103).getKey(), r100) == false) goto L7;
    L12:
        CustomBarAction r104 = (CustomBarAction) r103;
        boolean r105 = false;
        if (r104 == null) goto L22;
        String r106 = r104.getUri();
        if (r106 == null) goto L22;
        if (r106.length() <= 0) goto L19;
        boolean r107 = true;
    L20:
        if (r107 == false) goto L22;
    L23:
        if (r106 != null) goto L33;
        if (r101 == null) goto L37;
        String r108 = qha.f.a(r101);
        if (r108 != null) goto L28;
        return null;
    L28:
        if (r108.length() <= 0) goto L30;
        r105 = true;
    L30:
        if (r105 == true) goto L40;
        return null;
    L40:
        return r108;
    L37:
        return null;
    L33:
        return r106;
    L19:
        r107 = false;
    L22:
        r106 = null;
        goto L23
    L11:
        r103 = null;
        goto L12
    }

    public static boolean h4(com.larus.bmhome.actionbar.model.z0 r100, ReplyOption r101) {
        com.larus.bmhome.actionbar.model.p0 r102 = r100.f295619o;
        if (r102 == null) goto L10;
        Integer r103 = r102.f295366a;
        int r104 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r103 == null) goto L10;
        if (r103.intValue() != r104) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == true) goto L13;
        return false;
    L13:
        if (com.obric.assistant.task.skill.n.b(r101) == false) goto L17;
        return true;
    L17:
        return false;
    L10:
        r105 = false;
        goto L11
    }

    public static boolean k4(com.larus.bmhome.actionbar.model.z0 r100, View r101) {
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.larus.common_ui.widget.roundlayout.RoundConstraintLayout");
        RoundConstraintLayout r102 = (RoundConstraintLayout) r101;
        if (Intrinsics.areEqual(r100.f295606b, "obric_photo_perception") == false) goto L5;
    L9:
        return true;
    L5:
        if (Intrinsics.areEqual(r100.f295606b, "obric_screen_qa") == true) goto L9;
        if (Intrinsics.areEqual(r100.f295606b, "obric_im_perception") == true) goto L9;
        return false;
    }

    @Override // rs8.f
    public final void F(String r100, List<com.larus.bmhome.actionbar.model.b2> r101) {
        Intrinsics.checkNotNullParameter(r101, "menuItems");
    }

    public final void G4(String r110, Integer r111) {
        com.larus.bmhome.instruction.g r100 = vc();
        Boolean r101 = null;
        if (r100 == null) goto L5;
        com.larus.bmhome.actionbar.model.z0 r102 = r100.yF();
    L6:
        boolean r103 = false;
        if (i4(r110) == false) goto L93;
        String r112 = V3(r110, r102);
        if (r102 == null) goto L12;
        R4(r102, r112);
    L12:
        if (H3() == null) goto L74;
        com.larus.bmhome.instruction.b2 r104 = Q3();
        if (r104 == null) goto L74;
        ConstraintLayout r105 = r104.h();
        if (r105 == null) goto L74;
        com.larus.bmhome.instruction.b2 r106 = Q3();
        if (r106 == null) goto L74;
        SimpleDraweeView r107 = r106.k();
        if (r107 == null) goto L74;
        com.larus.bmhome.instruction.b2 r108 = Q3();
        if (r108 == null) goto L74;
        AppCompatImageView r109 = r108.i();
        if (r109 == null) goto L74;
        com.larus.bmhome.instruction.b2 r113 = Q3();
        if (r113 == null) goto L74;
        AppCompatTextView r114 = r113.e();
        if (r114 == null) goto L74;
        TextView r115 = (TextView) r105.findViewWithTag("obric_perception_panel_subtitle");
        if (r115 != null) goto L38;
        r115 = new TextView(r105.getContext());
        r115.setId(View.generateViewId());
        r115.setTag("obric_perception_panel_subtitle");
        r115.setMaxLines(1);
        r115.setEllipsize(TextUtils.TruncateAt.END);
        r115.setTextColor(ContextCompat.getColor(r115.getContext(), R.color.larus_neutral_50));
        r115.setTextSize(0, v19.i5.h());
        r115.setIncludeFontPadding(false);
        r105.addView(r115, new ConstraintLayout.LayoutParams(0, -2));
    L38:
        if (Intrinsics.areEqual(r110, "obric_video_perception") == false) goto L40;
        String r116 = getContext().getString(R.string.obric_action_bar_video_perceive);
    L41:
        r114.setText(r116);
        if (r112 != null) goto L44;
        r112 = "";
    L44:
        r115.setText(r112);
        com.larus.bmhome.instruction.b2 r117 = Q3();
        if (r117 == null) goto L53;
        ConstraintLayout r118 = r117.c();
        if (r118 == null) goto L53;
        ViewGroup.LayoutParams r119 = r118.getLayoutParams();
        if (r119 == null) goto L52;
        ConstraintLayout.LayoutParams r120 = (ConstraintLayout.LayoutParams) r119;
        ((ViewGroup.MarginLayoutParams) r120).height = v19.i5.l0();
        r118.setLayoutParams(r120);
        goto L53
    L52:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L53:
        ViewGroup.LayoutParams r121 = r105.getLayoutParams();
        if (r121 == null) goto L73;
        ConstraintLayout.LayoutParams r122 = (ConstraintLayout.LayoutParams) r121;
        ((ViewGroup.MarginLayoutParams) r122).width = 0;
        r122.endToStart = r109.getId();
        r122.endToEnd = -1;
        r122.setMarginEnd(v19.i5.r0());
        r105.setLayoutParams(r122);
        ViewGroup.LayoutParams r123 = r109.getLayoutParams();
        if (r123 == null) goto L71;
        ConstraintLayout.LayoutParams r124 = (ConstraintLayout.LayoutParams) r123;
        r124.topToTop = 0;
        ((ViewGroup.MarginLayoutParams) r124).topMargin = v19.i5.q();
        r124.bottomToBottom = -1;
        r109.setLayoutParams(r124);
        ViewGroup.LayoutParams r125 = r107.getLayoutParams();
        if (r125 == null) goto L69;
        ConstraintLayout.LayoutParams r126 = (ConstraintLayout.LayoutParams) r125;
        r126.topToTop = r114.getId();
        r126.bottomToBottom = r114.getId();
        r107.setLayoutParams(r126);
        ViewGroup.LayoutParams r127 = r114.getLayoutParams();
        if (r127 == null) goto L67;
        ConstraintLayout.LayoutParams r128 = (ConstraintLayout.LayoutParams) r127;
        ((ViewGroup.MarginLayoutParams) r128).width = 0;
        r128.startToEnd = r107.getId();
        r128.endToEnd = 0;
        r128.topToTop = 0;
        ((ViewGroup.MarginLayoutParams) r128).topMargin = v19.i5.q();
        r128.bottomToTop = -1;
        r128.bottomToBottom = -1;
        r128.verticalChainStyle = 0;
        r114.setLayoutParams(r128);
        ViewGroup.LayoutParams r129 = r115.getLayoutParams();
        if (r129 == null) goto L65;
        ConstraintLayout.LayoutParams r130 = (ConstraintLayout.LayoutParams) r129;
        ((ViewGroup.MarginLayoutParams) r130).width = 0;
        r130.startToStart = r107.getId();
        r130.endToEnd = 0;
        r130.topToBottom = r114.getId();
        r130.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) r130).bottomMargin = v19.i5.h();
        r130.verticalBias = 1.0f;
        r115.setLayoutParams(r130);
        goto L74
    L65:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L67:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L69:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L71:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L73:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L40:
        r116 = getContext().getString(R.string.obric_action_bar_web_perceive);
    L74:
        ada.c r131 = Z3();
        if (r131 == null) goto L77;
        r131.K50();
    L77:
        ada.c r132 = Z3();
        if (r132 == null) goto L80;
        r132.Ep();
    L80:
        ICoreInputAbility r133 = B3();
        if (r133 == null) goto L83;
        r133.p80(false);
    L83:
        ICoreInputAbility r134 = B3();
        if (r134 == null) goto L86;
        r134.qp(false);
    L86:
        ICoreInputAbility r135 = B3();
        if (r135 == null) goto L89;
        r135.g2(2, false);
    L89:
        ViewGroup r136 = H3();
        if (r136 == null) goto L122;
        r136.post(new k6(this));
        return;
    L122:
        return;
    L93:
        if (s1a.a.e(this) == true) goto L111;
        ViewGroup r137 = H3();
        if (r137 == null) goto L98;
        Drawable r138 = r137.getBackground();
    L100:
        if ((r138 instanceof GradientDrawable) == false) goto L102;
        GradientDrawable r139 = (GradientDrawable) r138;
    L103:
        if (r139 == null) goto L105;
        r139.setColor(ContextCompat.getColor(getContext(), E3(r110)));
        goto L111
    L105:
        FLogger r140 = FLogger.f375446a;
        StringBuilder r141 = new StringBuilder("setInputEditorBackground: not found instructionEditorContainer, isChatWindow = ");
        laa.d r142 = d4();
        if (r142 == null) goto L108;
        r101 = Boolean.valueOf(r142.aF());
    L108:
        r141.append(r101);
        r140.w("OrionExtraComponent", r141.toString());
        float[] r143 = {v19.i5.q(), v19.i5.q(), v19.i5.q(), v19.i5.q(), 0.0f, 0.0f, 0.0f, 0.0f};
        int r144 = ContextCompat.getColor(getContext(), E3(r110));
        GradientDrawable r145 = new GradientDrawable();
        r145.setShape(0);
        r145.setCornerRadii(r143);
        r145.setColor(r144);
        ViewGroup r146 = H3();
        if (r146 == null) goto L111;
        r146.setBackground(r145);
        goto L111
    L102:
        r139 = null;
        goto L103
    L98:
        r138 = null;
    L111:
        if (r111 != null) goto L114;
    L117:
        r103 = true;
    L118:
        F4(r103);
        ada.c r147 = Z3();
        if (r147 == null) goto L124;
        r147.jr();
        return;
    L124:
        return;
    L114:
        if (r111.intValue() != 5) goto L117;
        if (AppHost.f326268a.isOversea() == false) goto L118;
    L5:
        r102 = null;
        goto L6
    }

    @Override // qaa.a
    public final void Pp(String r100, boolean r110) {
        List<qha.e> r101 = null;
        if (r110 == false) goto L9;
        FLogger.f375446a.i("OrionExtraComponent", "mobAssistantActionBarShow, isFromInteractionSession after notify AiKey short press");
        if (this.U == false) goto L7;
        this.U = false;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new OrionInstructionComponent$checkIsMobActionBarShow$1(this, null), 3, null);
    L7:
        j4();
        return;
    L9:
        if (r100 == null) goto L29;
        ObricActionBarTrackServiceExtDelegate r111 = ObricActionBarTrackServiceExtDelegate.f385252b;
        if (r111.a(r100) == false) goto L29;
        ObricInteractDelegate r102 = ObricInteractDelegate.f392884b;
        Boolean r103 = r102.isAiKeyPressing();
        Boolean r104 = Boolean.TRUE;
        if (Intrinsics.areEqual(r103, r104) == false) goto L16;
    L27:
        FLogger.f375446a.i("OrionExtraComponent", "mobAssistantActionBarShow, is ai key pressing");
        return;
    L16:
        if (Intrinsics.areEqual(r102.isAiKeyLongPress(), r104) == true) goto L27;
        if (Intrinsics.areEqual(r102.isAiKeyShortPress(), r104) == true) goto L27;
        if (this.U == false) goto L31;
        this.U = false;
        laa.b r105 = X3();
        if (r105 == null) goto L25;
        r101 = r105.i30();
    L25:
        r111.b(r101);
        return;
    L31:
        return;
    L29:
        FLogger.f375446a.i("OrionExtraComponent", "mobAssistantActionBarShow, actionBarKey is null or not assistant action bar");
    }

    @Override // qaa.a
    public final void j00(float r100, boolean r101) {
        if (s1a.a.d(this) == false) goto L6;
        FLogger.f375446a.i("OrionExtraComponent", "resetActionBar isLandscapeFullWindow");
        return;
    L6:
        com.larus.bmhome.chat.component.bottom.core.speaker.m r102 = (com.larus.bmhome.chat.component.bottom.core.speaker.m) this.f388352t.getValue();
        if (r102 == null) goto L9;
        r102.MC(!r101);
    L9:
        float r103 = this.f388344m;
        boolean r104 = false;
        if (r103 != 0.0f) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L15;
    L19:
        if (r103 != 0.0f) goto L21;
        boolean r106 = true;
    L22:
        if (r106 == true) goto L24;
    L33:
        this.f388344m = r100;
        StateFlowImpl r107 = waa.a.f558907c;
        if (Math.abs(r100 - 0.0f) >= 1.0E-6f) goto L36;
        r104 = true;
    L36:
        r107.setValue(Boolean.valueOf(!r104));
        return;
    L24:
        if (r100 != 0.0f) goto L26;
        boolean r108 = true;
    L27:
        if (r108 == true) goto L33;
    L28:
        this.f388344m = r100;
        RecyclerView r109 = m3();
        if (r109 == null) goto L33;
        RecyclerView.Adapter r110 = r109.getAdapter();
        if (r110 == null) goto L33;
        r110.notifyDataSetChanged();
        goto L33
    L26:
        r108 = false;
        goto L27
    L21:
        r106 = false;
        goto L22
    L15:
        if (r100 != 0.0f) goto L17;
        boolean r111 = true;
    L18:
        if (r111 == true) goto L28;
    L17:
        r111 = false;
        goto L18
    L12:
        r105 = false;
        goto L13
    }

    /* JADX WARN: Type inference failed for: r1v37, types: [com.obric.assistant.component.u6] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.obric.assistant.component.z6] */
    @Override // rs8.f
    public final void l0(com.larus.bmhome.actionbar.model.z0 r210, View r211) {
        View r100 = r211;
        Intrinsics.checkNotNullParameter(r210, MapController.ITEM_LAYER_TAG);
        if (com.obric.assistant.util.t0.a(this) == true) goto L9;
        if (s1a.a.e(this) == true) goto L9;
        FLogger.f375446a.i("OrionExtraComponent", "onActionBarItemClick: not top chat page");
        return;
    L9:
        if (r100 == null) goto L11;
        Context r101 = r211.getContext();
    L13:
        if (Intrinsics.areEqual(r101, getContext()) == true) goto L16;
        FLogger.f375446a.i("OrionExtraComponent", "onActionBarItemClick: itemView context not match");
        return;
    L16:
        String r102 = r210.f295606b;
        boolean r110 = true;
        if (r102 != null) goto L19;
    L160:
        Map<String, String> r103 = r210.H;
        if (r103 == null) goto L163;
        String r104 = r103.get("skill_id");
    L164:
        int r105 = com.obric.assistant.task.skill.d.f393407a;
        if (com.obric.assistant.task.skill.d.a(r210.f295606b) == false) goto L176;
        if (r104 != null) goto L168;
    L171:
        boolean r106 = true;
    L172:
        if (r106 == true) goto L176;
        paa.c r107 = c4();
        if (r107 == null) goto L176;
        r107.Dd(r104);
        goto L176
    L168:
        if (StringsKt.isBlank(r104) == true) goto L171;
        r106 = false;
    L176:
        Integer r108 = r210.f295611g;
        int r109 = ActionBarExecutionType.SWITCH_STATUS.getValue();
        if (r108 == null) goto L182;
        if (r108.intValue() != r109) goto L182;
    L188:
        r110 = false;
    L189:
        if (r110 == false) goto L202;
        com.obric.audio.continuous_talk.c r111 = (com.obric.audio.continuous_talk.c) this.A.getValue();
        if (r111 == null) goto L193;
        com.obric.audio.continuous_talk.c.a.a(r111, null, null, false, true, 7);
    L193:
        Intrinsics.areEqual(r210.f295606b, "obric_omni");
        maa.e r112 = (maa.e) this.f388358z.getValue();
        if (r112 == null) goto L203;
        maa.e.a.a(r112, null, null, false, 7);
        return;
    L203:
        return;
    L202:
        return;
    L182:
        if (Intrinsics.areEqual(r210.f295606b, "obric_screen_qa") == true) goto L188;
        if (Intrinsics.areEqual(r210.f295606b, "obric_document_perception") == true) goto L188;
        if (Intrinsics.areEqual(r210.f295606b, "obric_oauto") == true) goto L188;
    L163:
        r104 = null;
        goto L164
    L19:
        switch(r102.hashCode()) {
            case -1832688838: goto L152;
            case -1596197216: goto L94;
            case -761162256: goto L88;
            case 241623133: goto L76;
            case 295367523: goto L58;
            case 548295946: goto L52;
            case 596623375: goto L43;
            case 780021240: goto L37;
            case 1196019926: goto L31;
            case 1890683158: goto L22;
            default: goto L160;
        };
    L22:
        if (r102.equals("obric_web_perception") == false) goto L160;
        laa.d r113 = d4();
        if (r113 == null) goto L27;
        r113.C1(false, false, "web_perceive");
    L27:
        String r114 = V3("obric_web_perception", r210);
        R4(r210, r114);
        Uri r115 = com.larus.utils.y0.j(r114);
        com.larus.bmhome.chat.component.bottom.multimodal.g r116 = W3();
        if (r116 == null) goto L176;
        r116.gx(new com.larus.bmhome.chat.component.bottom.multimodal.n(CollectionsKt.listOf(new com.larus.bmhome.chat.component.bottom.multimodal.a.C4037a(r115, null, 2)), new com.larus.bmhome.chat.component.bottom.multimodal.g1(false, MultimodalBizScene.ObricSpecialType, false), null, MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_method_trace", "obric_web_perception"), TuplesKt.to(ObricActionBarTrackType.KEY_IS_FROM_OBRIC_ACTION_BAR, "obric_web_perception")}), null, 20));
        goto L176
    L31:
        if (r102.equals("obric_quick_instruction") == false) goto L160;
        laa.h r117 = a4();
        if (r117 == null) goto L176;
        r117.Hh(r100, r210);
        goto L176
    L37:
        if (r102.equals("obric_photo_perception") == false) goto L160;
        laa.h r118 = a4();
        if (r118 == null) goto L176;
        r118.zw(r210);
        goto L176
    L43:
        if (r102.equals("obric_video_perception") == false) goto L160;
        laa.d r119 = d4();
        if (r119 == null) goto L48;
        r119.C1(false, false, "video_perceive");
    L48:
        String r120 = V3("obric_video_perception", r210);
        R4(r210, r120);
        Uri r121 = com.larus.utils.y0.j(r120);
        com.larus.bmhome.chat.component.bottom.multimodal.g r122 = W3();
        if (r122 == null) goto L176;
        r122.gx(new com.larus.bmhome.chat.component.bottom.multimodal.n(CollectionsKt.listOf(new com.larus.bmhome.chat.component.bottom.multimodal.a.C4037a(r121, null, 2)), new com.larus.bmhome.chat.component.bottom.multimodal.g1(false, MultimodalBizScene.ObricSpecialType, false), null, MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_method_trace", "obric_video_perception"), TuplesKt.to(ObricActionBarTrackType.KEY_IS_FROM_OBRIC_ACTION_BAR, "obric_video_perception")}), null, 20));
        goto L176
    L52:
        if (r102.equals("obric_all_instruction") == false) goto L160;
        laa.h r123 = a4();
        if (r123 == null) goto L176;
        r123.hx();
        goto L176
    L58:
        if (r102.equals("obric_document_perception") == false) goto L160;
        laa.h r124 = a4();
        if (r124 != null) goto L63;
    L65:
        boolean r125 = false;
    L66:
        if (r125 == false) goto L69;
        t19.s r126 = t19.s.f544207a;
        AppHost.Companion r127 = AppHost.f326268a;
        Application r128 = r127.getApplication();
        String r129 = r127.getApplication().getString(R.string.larus_multi_file_uploading_toast_maximum_size, new Object[]{"100MB"});
        r126.getClass();
        t19.s.t(r128, r129);
        return;
    L69:
        laa.d r130 = d4();
        if (r130 == null) goto L72;
        r130.C1(false, false, "file_perceive");
    L72:
        Uri r131 = com.larus.utils.y0.j(qha.f.a(r210));
        com.larus.bmhome.chat.component.bottom.multimodal.g r132 = W3();
        if (r132 == null) goto L176;
        r132.gx(new com.larus.bmhome.chat.component.bottom.multimodal.n(CollectionsKt.listOf(new com.larus.bmhome.chat.component.bottom.multimodal.a.C4037a(r131, null, 2)), new com.larus.bmhome.chat.component.bottom.multimodal.g1(true, MultimodalBizScene.InstructionDocumentRead, false), null, MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_method_trace", "obric_document_perception"), TuplesKt.to(ObricActionBarTrackType.KEY_IS_FROM_OBRIC_ACTION_BAR, "obric_document_perception")}), null, 20));
        goto L176
    L63:
        if (r124.Vf() != true) goto L65;
        r125 = true;
        goto L66
    L76:
        if (r102.equals("obric_screen_qa") == false) goto L160;
        final ?? r133 = new u6(this);
        if (com.obric.assistant.t1.f393353a.I1() == false) goto L81;
        r133.invoke();
        goto L176
    L81:
        Intrinsics.checkNotNullParameter(this, "<this>");
        final FragmentActivity r134 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r134 != null) goto L84;
        FLogger.f375446a.w("OrionExtraComponent", "ensureReferenceScreenContentEnabled: activity is null");
        goto L176
    L84:
        int r135 = ReferenceScreenContentConfirmFragment.f391759f;
        MutableLiveData r136 = ReferenceScreenContentConfirmFragment.a.a(r134);
        if (r136 == null) goto L176;
        r136.observe(this, new k7(new z6(r134, r133)));
        goto L176
    L88:
        if (r102.equals("obric_phone_operation") == false) goto L160;
        laa.h r137 = a4();
        if (r137 == null) goto L176;
        r137.Hh(r100, r210);
        goto L176
    L94:
        if (r102.equals("obric_omni_all_skills") == false) goto L160;
        if (com.obric.assistant.special_input.j.b() == false) goto L111;
        com.obric.assistant.t1 r138 = com.obric.assistant.t1.f393353a;
        if (r138.c0() == false) goto L111;
        if (r138.G0() == true) goto L111;
        if (System.currentTimeMillis() >= r138.Z0()) goto L111;
        r138.c1(true);
        laa.b r139 = X3();
        if (r139 == null) goto L111;
        r139.dI();
    L111:
        ObricActionBarTrackServiceExtDelegate r140 = ObricActionBarTrackServiceExtDelegate.f385252b;
        ObricActionBarTrackType r141 = ObricActionBarTrackType.OBRIC_OMNI_ALL_SKILLS;
        com.larus.bmhome.chat.component.cvs.y r142 = z3();
        if (r142 == null) goto L114;
        String r143 = r142.getBotId();
    L115:
        com.larus.bmhome.chat.component.cvs.y r144 = z3();
        long r145 = 0;
        if (r144 == null) goto L124;
        wc9.e r146 = r144.h();
        if (r146 == null) goto L124;
        String r147 = r146.f559198a;
        if (r147 == null) goto L124;
        r145 = CastLongProtector.parseLong(r147);     // Catch: Throwable -> L123
    L124:
        long r148 = r145;
        if (r100 == null) goto L144;
        Object r149 = r211.getParent();
    L128:
        if (r149 == null) goto L144;
        if ((r149 instanceof RecyclerView) == true) goto L131;
        if ((r149 instanceof View) == false) goto L140;
        r100 = (View) r149;
    L141:
        if (r100 == null) goto L144;
        r149 = r100.getParent();
        goto L128
    L140:
        r100 = null;
        goto L141
    L131:
        Integer r150 = Integer.valueOf(((RecyclerView) r149).getChildAdapterPosition(r100));
        if (r150.intValue() == (-1)) goto L134;
        boolean r151 = true;
    L135:
        if (r151 == false) goto L144;
    L145:
        if (r150 == null) goto L147;
        int r152 = r150.intValue();
    L148:
        IObricActionBarTrackServiceExt.a.a(r140, null, r141, r210, r143, r148, Integer.valueOf(r152), 1);
        paa.c r153 = c4();
        if (r153 == null) goto L176;
        r153.px();
        goto L176
    L147:
        r152 = 1;
        goto L148
    L134:
        r151 = false;
    L144:
        r150 = null;
        goto L145
    L114:
        r143 = null;
        goto L115
    L152:
        if (r102.equals("obric_im_perception") == false) goto L160;
        laa.d r154 = d4();
        if (r154 == null) goto L157;
        r154.C1(false, false, "im_perceive");
    L157:
        Uri r155 = com.larus.utils.y0.j(qha.f.a(r210));
        com.larus.bmhome.chat.component.bottom.multimodal.g r156 = W3();
        if (r156 == null) goto L176;
        r156.gx(new com.larus.bmhome.chat.component.bottom.multimodal.n(CollectionsKt.listOf(new com.larus.bmhome.chat.component.bottom.multimodal.a.C4037a(r155, null, 2)), new com.larus.bmhome.chat.component.bottom.multimodal.g1(true, MultimodalBizScene.ObricSpecialType, false), null, MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_method_trace", "obric_im_perception"), TuplesKt.to(ObricActionBarTrackType.KEY_IS_FROM_OBRIC_ACTION_BAR, "obric_im_perception")}), null, 20));
        goto L176
    L11:
        r101 = null;
        goto L13
    }

    @Override // rs8.f
    public final void w1(com.larus.bmhome.actionbar.model.z0 r100, ReplyOption r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "targetOption");
    }

    @Override // qaa.a
    public final void Fo(boolean r100, String r101, Object r102) {
        if ((r102 instanceof Integer) == false) goto L5;
        Integer r103 = (Integer) r102;
    L6:
        if (r103 == null) goto L8;
        int r104 = r103.intValue();
    L9:
        FLogger r105 = FLogger.f375446a;
        r105.i("OrionExtraComponent", "onInstructionVisibleChanged, " + r100 + ", actionBarKey: " + r101 + ", finalInstructionType: " + r104 + ", instructionType: " + r102);
        laa.m r106 = (laa.m) this.C.getValue();
        if (r106 == null) goto L12;
        r106.j1(r100);
    L12:
        laa.j r107 = (laa.j) this.D.getValue();
        if (r107 == null) goto L15;
        r107.j1(r100);
    L15:
        laa.d r108 = d4();
        if (r108 == null) goto L19;
        r108.j1(r100);
    L19:
        if (r100 == false) goto L21;
        G4(r101, Integer.valueOf(r104));
    L31:
        if (r100 == false) goto L35;
        if (r104 != 1) goto L35;
        return;
    L35:
        r105.i("OrionExtraComponent", "onInstructionVisibleChanged, override filter");
        ada.c r109 = Z3();
        if (r109 == null) goto L39;
        r109.W00();
        return;
    L39:
        return;
    L21:
        ICoreInputAbility r110 = B3();
        if (r110 == null) goto L24;
        r110.rE();
    L24:
        ICoreInputAbility r111 = B3();
        if (r111 == null) goto L27;
        r111.zM();
    L27:
        F4(true);
        ada.c r112 = Z3();
        if (r112 == null) goto L30;
        r112.jr();
    L30:
        this.f388345n = null;
        ObricActionBarSendServiceExtDelegate.f385250b.q();
        goto L31
    L8:
        r104 = 0;
        goto L9
    L5:
        r103 = null;
        goto L6
    }

    @Override // rs8.f
    public final void R0(List<com.larus.bmhome.actionbar.model.z0> r100, wc9.e r101, BotModel r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "itemList");
    }

    @Override // rs8.f
    public final void t1(List<com.larus.bmhome.actionbar.model.z0> r100, wc9.e r101, BotModel r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "itemList");
    }

    @Override // rs8.f
    public final void D(final View r210, ImageView r211, TextView r212, final com.larus.bmhome.actionbar.model.z0 r213, com.larus.bmhome.view.actionbar.custom.t1 r214) {
        Intrinsics.checkNotNullParameter(r210, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r211, "icon");
        Intrinsics.checkNotNullParameter(r212, "name");
        Intrinsics.checkNotNullParameter(r214, "callback");
        if (Intrinsics.areEqual(r210.getContext(), getContext()) == true) goto L6;
        FLogger.f375446a.i("OrionExtraComponent", "updateHolderStyle: root and component context not match, dont update style");
        return;
    L6:
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (Intrinsics.areEqual(com.larus.ui.arch.component.internal.attach.a.b(this, this).getClass().getSimpleName(), "InjectInputFragment") == false) goto L10;
        FLogger.f375446a.i("OrionExtraComponent", "updateHolderStyle: inject input fragment, dont update style");
        return;
    L10:
        if (r213 == null) goto L19;
        com.larus.bmhome.actionbar.model.p0 r100 = r213.f295619o;
        if (r100 == null) goto L19;
        Integer r101 = r100.f295366a;
        int r102 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r101 == null) goto L19;
        if (r101.intValue() != r102) goto L19;
        boolean r103 = true;
    L20:
        if (r103 == false) goto L22;
        this.O = r210;
    L22:
        if (r213 != null) goto L25;
        return;
    L25:
        if (s1a.a.e(this) == false) goto L27;
    L30:
        boolean r104 = true;
    L31:
        if (r104 == true) goto L34;
        FLogger.f375446a.i("OrionExtraComponent", "updateHolderStyle: non O page, keep default action bar style");
        return;
    L34:
        boolean r105 = r210 instanceof RoundConstraintLayout;
        if (r105 == false) goto L38;
        c29.a r106 = ((RoundConstraintLayout) r210).getDelegate();
    L40:
        c29.a r107 = r106;
    L43:
        if (Intrinsics.areEqual(r213.f295606b, "obric_phone_operation") == true) goto L45;
        LinearLayoutCompat r108 = (LinearLayoutCompat) r210.findViewById(R.id.obric_action_bar_phone_operation_pro_icon_container);
        if ((r210 instanceof ViewGroup) == false) goto L53;
        ViewGroup r109 = (ViewGroup) r210;
    L54:
        if (r109 == null) goto L56;
        r109.removeView(r108);
    L56:
        c29.a r110 = r107;
        if (k4(r213, r210) == false) goto L89;
        ConstraintLayout r111 = (ConstraintLayout) r210.findViewById(R.id.obric_custom_action_bar_secondary_menu_container);
        String r215 = "<this>";
        if (r111 != null) goto L61;
    L66:
        FLogger r112 = FLogger.f375446a;
        r112.i("OrionExtraComponent", "needSecondaryMenu: item = " + r213);
        String r113 = r213.f295606b;
        if (r113 != null) goto L69;
    L82:
        b r114 = null;
    L83:
        if (r114 != null) goto L85;
        com.larus.bmhome.view.actionbar.custom.t1 r115 = r214;
        c29.a r216 = r110;
        boolean r116 = r105;
        Object r117 = "obric_phone_operation";
    L109:
        ReplyOption r118 = r115.g(r213);
        int r119 = be8.g.f18781a;
        boolean r120 = be8.g.a(r213.f295606b);
        if (r120 == true) goto L112;
    L114:
        boolean r121 = false;
    L115:
        int r122 = com.obric.assistant.task.skill.d.f393407a;
        boolean r123 = com.obric.assistant.task.skill.d.a(r213.f295606b);
        if (com.obric.assistant.task.skill.d.a(r213.f295606b) == false) goto L124;
        Map<String, String> r124 = r213.H;
        if (r124 == null) goto L120;
        String r125 = r124.get("selected");
    L122:
        if (Boolean.parseBoolean(r125) == false) goto L124;
        boolean r126 = true;
    L126:
        if (h4(r213, r118) == false) goto L128;
        ImageView r127 = r211;
        r127.setImageResource(R.drawable.obric_deep_think_menu_phone_operation);
    L129:
        if (r126 == false) goto L132;
        ActionStyle r128 = ActionStyle.SELECTED;
    L160:
        c r129 = this.f388343k1.get(r128);
        if (r129 != null) goto L163;
        return;
    L163:
        laa.d r130 = d4();
        if (r130 == null) goto L168;
        Object r217 = r117;
        if (r130.isFullScreen() != true) goto L169;
        boolean r131 = true;
    L170:
        if (r131 == true) goto L172;
    L176:
        Integer r132 = r129.f388370d;
    L177:
        FLogger r133 = FLogger.f375446a;
        StringBuilder r134 = new StringBuilder("pageStateAbility?.isChatWindow(): ");
        laa.d r135 = d4();
        if (r135 == null) goto L180;
        Boolean r136 = Boolean.valueOf(r135.aF());
    L181:
        r134.append(r136);
        r134.append(", change actionBar progress is ");
        r134.append(this.f388344m);
        r133.i("OrionExtraComponent", r134.toString());
        if (s1a.a.e(this) == false) goto L184;
    L225:
        c29.a r137 = r216;
        if (s1a.a.e(this) == false) goto L343;
        r133.i("OrionExtraComponent", "updateHolderStyle, isWindowHost set material drawable");
        if (r116 == false) goto L230;
        RoundConstraintLayout r138 = (RoundConstraintLayout) r210;
    L232:
        if (r138 == null) goto L254;
        r138.setUseMaterial(true);
        com.larus.bmhome.actionbar.model.p0 r139 = r213.f295619o;
        if (r139 == null) goto L241;
        Integer r140 = r139.f295366a;
        int r141 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r140 == null) goto L241;
        if (r140.intValue() != r141) goto L241;
        boolean r142 = true;
    L242:
        if (r142 == false) goto L244;
    L246:
        Integer r143 = null;
    L247:
        if (r143 == null) goto L249;
        r143.intValue();
        r138.setPadding(r138.getPaddingStart(), r138.getPaddingTop(), r143.intValue(), r138.getPaddingBottom());
    L249:
        if (r137 == null) goto L251;
        int r144 = aia.b.f3862a;
        r137.d(10);
    L251:
        ViewGroup.LayoutParams r145 = ((RoundConstraintLayout) r210).getLayoutParams();
        if (r145 == null) goto L254;
        int r146 = aia.b.f3862a;
        r145.height = v19.c7.b(34);
        goto L254
    L244:
        if (k4(r213, r210) == true) goto L246;
        int r147 = aia.b.f3862a;
        r143 = Integer.valueOf(v19.c7.b(14));
    L241:
        r142 = false;
    L254:
        ViewGroup.LayoutParams r148 = r211.getLayoutParams();
        if (r148 == null) goto L268;
        int r149 = aia.b.f3862a;
        int r150 = v19.c7.b(18);
        r148.width = r150;
        r148.height = r150;
        r127.setLayoutParams(r148);
        if (be8.g.a(r213.f295606b) == false) goto L268;
        Object r151 = r211.getParent();
        if ((r151 instanceof View) == false) goto L261;
        View r152 = (View) r151;
    L263:
        if ((r152 instanceof RoundConstraintLayout) == true) goto L268;
        if (r152 == null) goto L268;
        ViewGroup.LayoutParams r153 = r152.getLayoutParams();
        if (r153 == null) goto L268;
        r153.width = r150;
        r153.height = r150;
        r152.setLayoutParams(r153);
        goto L268
    L261:
        r152 = null;
    L268:
        Intrinsics.checkNotNullParameter(r213, r215);
        if (Intrinsics.areEqual(r213.f295606b, "task_connector_entry") == false) goto L271;
        r211.clearColorFilter();
    L272:
        if (r132 == null) goto L274;
        r212.setTextColor(ContextCompat.getColor(r210.getContext(), r132.intValue()));
    L274:
        boolean r154 = r210 instanceof ViewGroup;
        if (r154 == false) goto L277;
        ViewGroup r155 = (ViewGroup) r210;
    L278:
        if (r155 == null) goto L281;
        r155.setClipChildren(false);
        r155.setClipToPadding(false);
    L281:
        if (be8.g.a(r213.f295606b) == false) goto L286;
        if (r128 != ActionStyle.SELECTED) goto L286;
        MaterialSceneType r156 = MaterialSceneType.ACTION_BAR_TASK_SKILL_SELECTED;
    L289:
        Lazy r157 = bia.g.f19194a;
        bia.g.a(r210, s1a.a.e(this), r156);
        r212.setLetterSpacing(0.0f);
        int r158 = aia.b.f3862a;
        r212.setTextSize(0, v19.c7.b(14));
        if (r120 == true) goto L300;
        ViewGroup.LayoutParams r159 = r212.getLayoutParams();
        if ((r159 instanceof ViewGroup.MarginLayoutParams) == false) goto L294;
        ViewGroup.MarginLayoutParams r160 = (ViewGroup.MarginLayoutParams) r159;
    L295:
        if (r160 == null) goto L300;
        if (r123 == false) goto L298;
        int r161 = 0;
    L299:
        r160.setMarginStart(r161);
        r212.setLayoutParams(r160);
        goto L300
    L298:
        r161 = v19.c7.b(22);
        goto L299
    L294:
        r160 = null;
    L300:
        com.larus.bmhome.actionbar.model.p0 r162 = r213.f295619o;
        if (r162 == null) goto L308;
        Integer r163 = r162.f295366a;
        int r164 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r163 == null) goto L308;
        if (r163.intValue() != r164) goto L308;
        boolean r165 = true;
    L309:
        if (r165 == true) goto L311;
        if (r120 == true) goto L311;
        return;
    L311:
        if (r154 == false) goto L313;
        ViewGroup r166 = (ViewGroup) r210;
    L314:
        if (r166 == null) goto L360;
        Sequence<View> r167 = ViewGroupKt.getChildren(r166);
        if (r167 == null) goto L361;
        Iterator<View> r168 = r167.iterator();
    L319:
        if (r168.hasNext() == false) goto L362;
        View r169 = r168.next();
        if (r169.getId() == R.id.iv_left_bold) goto L325;
        if (r169.getId() != R.id.iv_item_arrow) goto L319;
    L325:
        if ((r169 instanceof ImageView) == false) goto L327;
        ImageView r170 = (ImageView) r169;
    L329:
        if (r128 != ActionStyle.SELECTED) goto L331;
        boolean r171 = true;
    L332:
        if (r170 == null) goto L319;
        ViewGroup.LayoutParams r172 = r170.getLayoutParams();
        if (r172 == null) goto L337;
        r172.width = f388336p1;
        r172.height = f388337v1;
        r170.setLayoutParams(r172);
    L337:
        Context r173 = getContext();
        if (r171 == false) goto L340;
        int r174 = R.drawable.obric_deep_think_right_arrow_selected;
    L341:
        r170.setImageDrawable(ContextCompat.getDrawable(r173, r174));
        goto L319
    L340:
        r174 = R.drawable.obric_deep_think_right_arrow;
        goto L341
    L331:
        r171 = false;
        goto L332
    L327:
        r170 = null;
        goto L329
    L362:
        return;
    L361:
        return;
    L360:
        return;
    L313:
        r166 = null;
    L308:
        r165 = false;
    L286:
        if (be8.g.a(r213.f295606b) == false) goto L288;
        r156 = MaterialSceneType.ACTION_BAR_TASK_SKILL;
        goto L289
    L288:
        r156 = r129.f388372f;
        goto L289
    L277:
        r155 = null;
        goto L278
    L271:
        r127.setColorFilter(getContext().getResources().getColor(r129.f388369c));
        goto L272
    L230:
        r138 = null;
        goto L232
    L343:
        if (r137 == null) goto L346;
        r137.g(0);
        r137.h(0);
        r137.f22235q = false;
        r137.c();
        r137.d(12);
        r137.f22237s = true;
        r137.c();
        int r175 = r210.getContext().getResources().getColor(r129.f388367a);
        int r176 = r210.getContext().getResources().getColor(r129.f388368b);
        r137.f22237s = false;
        r137.f22223e = r175;
        r137.f22225g = r176;
        r137.c();
    L346:
        if ((!Intrinsics.areEqual(r213.f295606b, r217)) == false) goto L348;
        r127.setColorFilter(getContext().getResources().getColor(r129.f388369c));
    L348:
        if (r132 == null) goto L363;
        r212.setTextColor(ContextCompat.getColor(r210.getContext(), r132.intValue()));
        return;
    L363:
        return;
    L184:
        if (this.f388344m != 0.0f) goto L186;
        boolean r177 = true;
    L187:
        if (r177 == false) goto L225;
        r133.i("OrionExtraComponent", "updateHolderStyle: " + r213);
        c29.a r178 = r216;
        if (r178 == null) goto L208;
        r178.f22235q = false;
        r178.c();
        r178.d(8);
        r178.f22237s = true;
        r178.c();
        if (e4(r213) == true) goto L205;
        if (r121 == true) goto L205;
        if (h4(r213, r118) == true) goto L205;
        if (r126 == true) goto L205;
        if (Intrinsics.areEqual(r213.f295606b, "obric_omni") == true) goto L205;
        if (Intrinsics.areEqual(r213.f295606b, "obric_oauto") == true) goto L205;
        if (r128 == ActionStyle.SELECTED) goto L208;
        r211.clearColorFilter();
    L205:
        if (r128 == ActionStyle.SELECTED) goto L207;
        r178.g(ContextCompat.getColor(r210.getContext(), R.color.larus_neutral_transparent_2));
    L207:
        r127.setColorFilter(ContextCompat.getColor(r210.getContext(), r129.f388369c));
    L208:
        if (r132 == null) goto L210;
        r212.setTextColor(ContextCompat.getColor(r210.getContext(), r132.intValue()));
    L210:
        if (r178 == null) goto L212;
        r178.b(r210.getContext().getResources().getColor(R.color.press));
    L212:
        boolean r179 = v19.h.f552477a;
        Context r180 = r210.getContext();
        if (r180 != null) goto L216;
        r180 = getContext();
    L216:
        if (v19.h.b(r180) == false) goto L218;
        int r181 = R.color.larus_bg_action_bar_item_night_color;
    L219:
        if (r178 == null) goto L359;
        Context r182 = r210.getContext();
        if (r182 != null) goto L223;
        r182 = getContext();
    L223:
        r178.a(ContextCompat.getColor(r182, r181));
        return;
    L359:
        return;
    L218:
        r181 = R.color.larus_bg_action_bar_item_light_color;
        goto L219
    L186:
        r177 = false;
        goto L187
    L180:
        r136 = null;
        goto L181
    L172:
        if (r128 != ActionStyle.SELECTED) goto L176;
        if (AccountService.f365697a.isEnterpriseAccount() == false) goto L176;
        r132 = Integer.valueOf(R.color.obric_custom_action_bar_text);
    L169:
        r131 = false;
        goto L170
    L168:
        r217 = r117;
        goto L169
    L132:
        if (e4(r213) == false) goto L135;
        r128 = ActionStyle.OBRIC;
        goto L160
    L135:
        AtomicBoolean r183 = com.obric.assistant.task.skill.m.f393417a;
        boolean r184 = com.obric.assistant.task.skill.m.f393418b.get();
        FLogger.f375446a.i("ObricTaskSkillModeHelper", "isUseModeModelList: " + r184);
        String r185 = r118.getModeId();
        ObricOmniModeTag r186 = ObricOmniModeTag.QUICK;
        if (Intrinsics.areEqual(r185, com.obric.assistant.task.skill.m.e(r186)) == true) goto L146;
        String r187 = r118.getModeId();
        if (r187 != null) goto L140;
    L143:
        boolean r188 = true;
    L144:
        if (r188 == true) goto L146;
    L149:
        if (Intrinsics.areEqual(r118.getModeId(), com.obric.assistant.task.skill.m.e(r186)) == false) goto L152;
        if (r184 == false) goto L152;
    L151:
        boolean r189 = true;
    L153:
        if (r189 == false) goto L159;
        if (r121 == true) goto L159;
        if (h4(r213, r118) == true) goto L159;
        r128 = ActionStyle.NORMAL;
    L159:
        r128 = ActionStyle.SELECTED;
    L152:
        r189 = false;
        goto L153
    L140:
        if (r187.length() == 0) goto L143;
        r188 = false;
    L146:
        if (Intrinsics.areEqual(r118.getModel().getKey(), com.obric.assistant.task.skill.m.f(ObricOmniModelTag.QUICK)) == false) goto L149;
        if (r184 == false) goto L151;
    L128:
        r127 = r211;
        goto L129
    L120:
        r125 = null;
    L124:
        r126 = false;
        goto L126
    L112:
        if (r213.f295625u == null) goto L114;
        r121 = true;
        goto L115
    L85:
        final AppCompatImageView r190 = new AppCompatImageView(getContext());
        r190.setId(r114.f388362a);
        ConstraintLayout.LayoutParams r191 = new ConstraintLayout.LayoutParams(-2, -2);
        r191.startToStart = 0;
        r191.topToTop = 0;
        r191.bottomToBottom = 0;
        r191.endToEnd = 0;
        r191.setMarginEnd(r114.f388365d);
        r191.setMarginStart(r114.f388364c);
        r190.setLayoutParams(r191);
        r190.setImageDrawable(AppCompatResources.getDrawable(r190.getContext(), r114.f388363b));
        Integer r192 = r114.f388366e;
        if (r192 == null) goto L88;
        r190.setColorFilter(r192.intValue());
    L88:
        r190.setVisibility(0);
        r190.setBackground(new ColorDrawable(0));
        r190.setTag("secondary_menu_tag");
        final ConstraintLayout r193 = new ConstraintLayout(r210.getContext());
        r193.setId(R.id.obric_custom_action_bar_secondary_menu_container);
        ConstraintLayout.LayoutParams r194 = new ConstraintLayout.LayoutParams(-2, -1);
        r194.startToEnd = r212.getId();
        r194.topToTop = 0;
        r194.bottomToBottom = 0;
        r194.endToEnd = 0;
        r193.setLayoutParams(r194);
        r193.setVisibility(0);
        r193.addView(r190);
        r193.setClickable(true);
        Intrinsics.checkNotNull(r210, "null cannot be cast to non-null type com.larus.common_ui.widget.roundlayout.RoundConstraintLayout");
        RoundConstraintLayout r195 = (RoundConstraintLayout) r210;
        r117 = r3;
        r216 = r110;
        r116 = r105;
        com.larus.utils.e1.d(r193, new v6(r213, this, r193, r210, r190));
        r193.setTag(r213.f295606b);
        r195.setPadding(v19.i5.h(), 0, 0, 0);
        r195.addView(r193);
        r112.i("OrionExtraComponent", "secondaryMenu set done");
    L108:
        r115 = r214;
        goto L109
    L69:
        switch(r113.hashCode()) {
            case -1832688838: goto L79;
            case -761162256: goto L77;
            case 241623133: goto L75;
            case 780021240: goto L72;
            default: goto L82;
        };
    L77:
        r113.equals("obric_phone_operation");
        goto L82
    L72:
        if (r113.equals("obric_photo_perception") == false) goto L82;
    L81:
        r114 = new b((int) getContext().getResources().getDimension(v19.c.b(R.attr.larus_dp_8, getContext(), R.dimen.larus_dp_8)), (int) getContext().getResources().getDimension(v19.c.b(R.attr.larus_dp_4, getContext(), R.dimen.larus_dp_6)));
        goto L83
    L75:
        if (r113.equals("obric_screen_qa") == false) goto L82;
    L79:
        if (r113.equals("obric_im_perception") == true) goto L81;
    L61:
        if ((r210 instanceof ViewGroup) == false) goto L63;
        ViewGroup r196 = (ViewGroup) r210;
    L64:
        if (r196 == null) goto L66;
        r196.removeView(r111);
        goto L66
    L63:
        r196 = null;
        goto L64
    L89:
        r117 = "obric_phone_operation";
        r215 = "<this>";
        r216 = r110;
        r116 = r105;
        if (Intrinsics.areEqual(r213.f295606b, r117) == false) goto L92;
    L103:
        boolean r197 = true;
    L104:
        if (r197 == false) goto L108;
        ConstraintLayout r198 = (ConstraintLayout) r210.findViewById(R.id.obric_custom_action_bar_secondary_menu_container);
        if (r198 == null) goto L108;
        Intrinsics.checkNotNull(r210, "null cannot be cast to non-null type com.larus.common_ui.widget.roundlayout.RoundConstraintLayout");
        RoundConstraintLayout r199 = (RoundConstraintLayout) r210;
        int r200 = v19.i5.h();
        r199.setPadding(r200, 0, r200, 0);
        r198.removeAllViews();
        r199.removeView(r198);
        goto L108
    L92:
        if (Intrinsics.areEqual(r213.f295606b, "obric_im_perception") == false) goto L94;
    L102:
        r197 = false;
        goto L104
    L94:
        if (Intrinsics.areEqual(r213.f295606b, "obric_screen_qa") == true) goto L102;
        if (Intrinsics.areEqual(r213.f295606b, "obric_photo_perception") == true) goto L102;
        if (Intrinsics.areEqual(r213.f295606b, "obric_oauto") == true) goto L102;
        if (Intrinsics.areEqual(r213.f295606b, "obric_omni") == true) goto L102;
    L53:
        r109 = null;
        goto L54
    L45:
        if ((r210 instanceof ViewGroup) == false) goto L47;
        ViewGroup r201 = (ViewGroup) r210;
    L48:
        if (r201 == null) goto L56;
        FLogger.f375446a.i("OrionExtraComponent", "no need show pro icon");
        goto L56
    L47:
        r201 = null;
        goto L48
    L38:
        if ((r210 instanceof RoundFrameLayout) == false) goto L41;
        r106 = ((RoundFrameLayout) r210).getDelegate();
        goto L40
    L41:
        r107 = null;
        goto L43
    L27:
        if (d4() != null) goto L30;
        r104 = false;
    L19:
        r103 = false;
        goto L20
    }
}
