package com.larus.home.impl.main.side_bar.view;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.router.SmartRouter;
import com.larus.account.base.api.IMultiAccountProfileService;
import com.larus.bmhome.ConversationChangeModel;
import com.larus.bmhome.SideBarPage;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.manager.ChatListScreenMenuManager;
import com.larus.bmhome.chat.model.ConversationListModel;
import com.larus.bmhome.chat.model.ConversationModel;
import com.larus.bmhome.chat.model.api.DefaultActiveModeSettingValue;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuConfigV2;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuDataV2;
import com.larus.bmhome.chat.model.api.DefaultReplySwitchMenuMode;
import com.larus.bmhome.chat.model.api.DefaultReplySwitchModeConfig;
import com.larus.bmhome.chat.model.repo.INotifyRedDotLifecycleObserver;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.setting.UserSettingDelegate;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.bmhome.setting.UserSettingCacheManager;
import com.larus.bmhome.taskskill.service.IProjectCreatePanelService;
import com.larus.bmhome.taskskill.service.IProjectListDataSource;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.bot.api.IUgcBotRepoService;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.RedDotTextView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.home.impl.databinding.LarusFragmentSideBarContentBinding;
import com.larus.home.impl.main.side_bar.data.ComponentTypeEnum;
import com.larus.home.impl.main.side_bar.data.DividerPositionEnum;
import com.larus.home.impl.main.side_bar.data.SideBarConfigModel;
import com.larus.home.impl.main.side_bar.data.SideBarItemType;
import com.larus.home.impl.main.side_bar.data.SideBarRepo;
import com.larus.home.impl.main.side_bar.feed.arch.VisibilityAdapter;
import com.larus.home.impl.main.side_bar.view.adapter.BaseSideBarAdapter;
import com.larus.home.impl.main.side_bar.view.adapter.SideBarBottomSpaceAdapter;
import com.larus.home.impl.main.side_bar.view.adapter.SideBarCaseAdapter;
import com.larus.home.impl.main.side_bar.view.adapter.SideBarComponentAdapter;
import com.larus.home.impl.main.side_bar.view.adapter.SideBarConversationAdapter;
import com.larus.home.impl.main.side_bar.view.adapter.SideBarDividerAdapter;
import com.larus.home.impl.main.side_bar.view.adapter.arch.ReorderableConcatAdapterHost;
import com.larus.home.impl.main.side_bar.view.flat.FlatConversationContainer;
import com.larus.home.impl.main.side_bar.view.group.assembly.GroupController;
import com.larus.home.impl.main.side_bar.view.group.datasource.GroupSortPolicy;
import com.larus.home.impl.main.side_bar.view.group.datasource.im.ImSdkConversationQueryService;
import com.larus.home.impl.main.side_bar.view.group.policy.ConversationArchiveFilter;
import com.larus.home.impl.main.side_bar.view.group.policy.ConversationGroupPolicy;
import com.larus.home.impl.main.side_bar.view.group.render.GroupHeaderAdapter;
import com.larus.home.impl.main.side_bar.view.project.SideBarProjectActionHandler;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.internal.core.conversation.ConversationLocalManager;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.model.UserConfigItem;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.profile.api.IProfileApi;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttm.player.MediaPlayer;
import hq9.m2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;
import org.json.JSONObject;
import tx9.i3;
import tx9.n3;
import tx9.p3;
import v19.i5;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000Ò\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002Ó\u0001\u0018\u0000 £\u00032\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0002£\u0003B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0083\u0001\u001a\u00020g2\b\u0010\u0084\u0001\u001a\u00030\u0080\u0001H\u0002J\u0013\u0010\u0085\u0001\u001a\u00020g2\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0002J\n\u0010¶\u0001\u001a\u00030³\u0001H\u0002J\u0016\u0010·\u0001\u001a\u00030³\u00012\n\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u0001H\u0016J\n\u0010º\u0001\u001a\u00030³\u0001H\u0016J\u0014\u0010»\u0001\u001a\u00030³\u00012\b\u0010¼\u0001\u001a\u00030½\u0001H\u0016J\n\u0010¾\u0001\u001a\u00030³\u0001H\u0016J\n\u0010¿\u0001\u001a\u00030³\u0001H\u0002J.\u0010À\u0001\u001a\u0005\u0018\u00010Á\u00012\b\u0010Â\u0001\u001a\u00030Ã\u00012\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u00012\n\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u0001H\u0016J \u0010Æ\u0001\u001a\u00030³\u00012\b\u0010Ç\u0001\u001a\u00030Á\u00012\n\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u0001H\u0016J\n\u0010È\u0001\u001a\u00030³\u0001H\u0002J\u001b\u0010É\u0001\u001a\u00030³\u00012\u000f\u0010Ê\u0001\u001a\n\u0012\u0005\u0012\u00030\u0080\u00010Ë\u0001H\u0002J\u0013\u0010Ì\u0001\u001a\u00030³\u00012\u0007\u0010Í\u0001\u001a\u00020gH\u0002J\n\u0010Õ\u0001\u001a\u00030³\u0001H\u0002J\n\u0010Ö\u0001\u001a\u00030³\u0001H\u0002J\n\u0010Ú\u0001\u001a\u00030³\u0001H\u0002J\n\u0010Û\u0001\u001a\u00030³\u0001H\u0002J\n\u0010Ü\u0001\u001a\u00030³\u0001H\u0002J\n\u0010Ý\u0001\u001a\u00030³\u0001H\u0002J\t\u0010Þ\u0001\u001a\u00020gH\u0002J\n\u0010ß\u0001\u001a\u00030³\u0001H\u0002J\n\u0010à\u0001\u001a\u00030³\u0001H\u0002J\n\u0010á\u0001\u001a\u00030³\u0001H\u0002J\t\u0010â\u0001\u001a\u00020\rH\u0002J\t\u0010ã\u0001\u001a\u00020\rH\u0002J%\u0010ä\u0001\u001a\u00020\r2\u0007\u0010å\u0001\u001a\u00020\u00112\b\u0010æ\u0001\u001a\u00030ç\u00012\u0007\u0010è\u0001\u001a\u00020\rH\u0002J\n\u0010é\u0001\u001a\u00030³\u0001H\u0016J\n\u0010ê\u0001\u001a\u00030³\u0001H\u0016J\u0015\u0010ë\u0001\u001a\u00030³\u00012\t\u0010ì\u0001\u001a\u0004\u0018\u00010*H\u0016J\u0015\u0010í\u0001\u001a\u00030³\u00012\t\u0010î\u0001\u001a\u0004\u0018\u00010*H\u0016J\u001b\u0010ï\u0001\u001a\u0002032\u0007\u0010ð\u0001\u001a\u00020\r2\u0007\u0010ñ\u0001\u001a\u00020*H\u0002J(\u0010ò\u0001\u001a\u0004\u0018\u0001032\u0007\u0010ð\u0001\u001a\u00020\r2\u0007\u0010ñ\u0001\u001a\u00020*2\t\b\u0002\u0010ó\u0001\u001a\u00020\rH\u0002J(\u0010ô\u0001\u001a\u000e\u0012\u0007\b\u0001\u0012\u00030ö\u0001\u0018\u00010õ\u00012\u0007\u0010ñ\u0001\u001a\u00020*2\b\u0010÷\u0001\u001a\u00030ø\u0001H\u0002J\u0013\u0010ù\u0001\u001a\u00030³\u00012\u0007\u0010ú\u0001\u001a\u00020gH\u0002J\n\u0010û\u0001\u001a\u00030³\u0001H\u0002J\u0014\u0010ü\u0001\u001a\u00030³\u00012\b\u0010ý\u0001\u001a\u00030\u0080\u0001H\u0002J\u0014\u0010þ\u0001\u001a\u00030³\u00012\b\u0010ý\u0001\u001a\u00030\u0080\u0001H\u0002Jl\u0010ÿ\u0001\u001a\u00030\u0080\u00022\u0007\u0010ð\u0001\u001a\u00020\r2\u0007\u0010ñ\u0001\u001a\u00020*2\t\b\u0002\u0010\u0081\u0002\u001a\u00020g2(\b\u0002\u0010\u0082\u0002\u001a!\u0012\u0005\u0012\u00030\u0080\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u0080\u00010\u0084\u0002\u0012\u0005\u0012\u00030³\u0001\u0018\u00010\u0083\u00022\u0019\b\u0002\u0010\u0085\u0002\u001a\u0012\u0012\u0004\u0012\u00020g\u0012\u0005\u0012\u00030³\u0001\u0018\u00010\u0086\u0002H\u0002J\u001e\u0010\u0087\u0002\u001a\u00030³\u00012\u0012\u0010\u0088\u0002\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010*\u0018\u00010\u0084\u0002H\u0016J%\u0010\u0089\u0002\u001a\u00030³\u00012\b\u0010\u008a\u0002\u001a\u00030\u0080\u00012\u000f\u0010\u008b\u0002\u001a\n\u0012\u0005\u0012\u00030\u0080\u00010\u0084\u0002H\u0002J\t\u0010\u008c\u0002\u001a\u00020\u0011H\u0002J6\u0010\u008d\u0002\u001a\u00030³\u00012\u0007\u0010ð\u0001\u001a\u00020\r2\u0007\u0010ñ\u0001\u001a\u00020*2\b\u0010\u008e\u0002\u001a\u00030\u008f\u00022\u0007\u0010\u0090\u0002\u001a\u00020gH\u0082@¢\u0006\u0003\u0010\u0091\u0002Jj\u0010\u0092\u0002\u001a\u00020!2\b\u0010\u008e\u0002\u001a\u00030\u008f\u00022\u001c\b\u0002\u0010\u0093\u0002\u001a\u0015\u0012\u0005\u0012\u00030\u0080\u0001\u0012\t\u0012\u0007\u0012\u0002\b\u00030\u0095\u00020\u0094\u00022\u0007\u0010ð\u0001\u001a\u00020\r2\u0007\u0010ñ\u0001\u001a\u00020*2\b\u0010\u0096\u0002\u001a\u00030\u0097\u00022\t\b\u0002\u0010\u0090\u0002\u001a\u00020g2\t\b\u0002\u0010\u0098\u0002\u001a\u00020gH\u0082@¢\u0006\u0003\u0010\u0099\u0002J \u0010\u009a\u0002\u001a\u00020\r2\f\u0010\u009b\u0002\u001a\u0007\u0012\u0002\b\u00030õ\u00012\u0007\u0010\u009c\u0002\u001a\u00020\u0019H\u0002J&\u0010\u009d\u0002\u001a\u00030³\u00012\b\u0010\u008e\u0002\u001a\u00030\u008f\u00022\t\b\u0002\u0010\u009e\u0002\u001a\u00020gH\u0082@¢\u0006\u0003\u0010\u009f\u0002J\u001d\u0010 \u0002\u001a\u00030³\u00012\b\u0010¡\u0002\u001a\u00030\u0080\u00012\u0007\u0010¢\u0002\u001a\u00020!H\u0002J;\u0010£\u0002\u001a\u00030³\u00012\t\u0010\u009b\u0002\u001a\u0004\u0018\u0001032\u0011\u0010¤\u0002\u001a\f\u0012\u0005\u0012\u00030¥\u0002\u0018\u00010\u0084\u00022\u0011\u0010¦\u0002\u001a\f\u0012\u0005\u0012\u00030¥\u0002\u0018\u00010\u0084\u0002H\u0002J!\u0010§\u0002\u001a\f\u0012\u0005\u0012\u00030¥\u0002\u0018\u00010\u0084\u0002*\f\u0012\u0005\u0012\u00030¥\u0002\u0018\u00010\u0084\u0002H\u0002J\u0012\u0010¨\u0002\u001a\u00020\r2\u0007\u0010ð\u0001\u001a\u00020\rH\u0002J0\u0010©\u0002\u001a\u00030³\u00012\u0011\u0010ª\u0002\u001a\f\u0012\u0005\u0012\u00030¥\u0002\u0018\u00010\u0084\u00022\u0011\u0010«\u0002\u001a\f\u0012\u0005\u0012\u00030¥\u0002\u0018\u00010\u0084\u0002H\u0016J\n\u0010¬\u0002\u001a\u00030³\u0001H\u0016J\u001d\u0010\u00ad\u0002\u001a\u00030³\u00012\u0011\u0010®\u0002\u001a\f\u0012\u0005\u0012\u00030¥\u0002\u0018\u00010\u0084\u0002H\u0016J\u001c\u0010¯\u0002\u001a\u00030³\u00012\u0010\u0010\u0088\u0002\u001a\u000b\u0012\u0004\u0012\u00020*\u0018\u00010\u0084\u0002H\u0016J\u001c\u0010°\u0002\u001a\u00030³\u00012\u0010\u0010±\u0002\u001a\u000b\u0012\u0004\u0012\u00020*\u0018\u00010\u0084\u0002H\u0016J\u0016\u0010²\u0002\u001a\u00030³\u00012\n\u0010³\u0002\u001a\u0005\u0018\u00010´\u0002H\u0016J\u0016\u0010²\u0002\u001a\u00030³\u00012\n\u0010µ\u0002\u001a\u0005\u0018\u00010\u0080\u0001H\u0016J\u0011\u0010¶\u0002\u001a\u00030³\u00012\u0007\u0010·\u0002\u001a\u00020gJ\n\u0010¸\u0002\u001a\u00030³\u0001H\u0002J\u0011\u0010¹\u0002\u001a\u00030³\u00012\u0007\u0010·\u0002\u001a\u00020gJ\n\u0010º\u0002\u001a\u00030³\u0001H\u0002J\n\u0010»\u0002\u001a\u00030³\u0001H\u0002J\t\u0010¼\u0002\u001a\u00020\rH\u0002J\u000e\u0010½\u0002\u001a\u00020g*\u00030¥\u0002H\u0002J\n\u0010¾\u0002\u001a\u00030³\u0001H\u0002J\n\u0010¿\u0002\u001a\u00030³\u0001H\u0002J\n\u0010À\u0002\u001a\u00030³\u0001H\u0002J\n\u0010Á\u0002\u001a\u00030³\u0001H\u0002J\u001d\u0010Â\u0002\u001a\u00030³\u00012\b\u0010Ç\u0001\u001a\u00030Á\u00012\u0007\u0010ð\u0001\u001a\u00020\rH\u0002J\u0012\u0010Ã\u0002\u001a\u00020\r2\u0007\u0010ð\u0001\u001a\u00020\rH\u0002J%\u0010Ä\u0002\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0007\u0012\u0005\u0018\u00010\u0080\u00010Å\u00022\b\u0010Ç\u0001\u001a\u00030Á\u0001H\u0002J\t\u0010Æ\u0002\u001a\u00020\rH\u0002J\n\u0010Ç\u0002\u001a\u00030³\u0001H\u0002J\u001d\u0010È\u0002\u001a\u00030³\u00012\u0007\u0010É\u0002\u001a\u00020\r2\b\u0010Ê\u0002\u001a\u00030ö\u0001H\u0002J\b\u0010Ë\u0002\u001a\u00030³\u0001J\u0014\u0010Ì\u0002\u001a\u00030³\u00012\b\u0010Í\u0002\u001a\u00030ª\u0001H\u0002J7\u0010Î\u0002\u001a\u00030³\u00012\u0007\u0010Ï\u0002\u001a\u00020\r2\n\u0010Ð\u0002\u001a\u0005\u0018\u00010\u0080\u00012\n\u0010Ñ\u0002\u001a\u0005\u0018\u00010\u0080\u00012\f\b\u0002\u0010Ò\u0002\u001a\u0005\u0018\u00010\u0080\u0001J,\u0010Ó\u0002\u001a\u0004\u0018\u00010\u00192\u0007\u0010Ï\u0002\u001a\u00020\r2\n\u0010Ñ\u0002\u001a\u0005\u0018\u00010\u0080\u00012\n\u0010Ò\u0002\u001a\u0005\u0018\u00010\u0080\u0001H\u0002J\n\u0010Õ\u0002\u001a\u00030³\u0001H\u0002J\n\u0010Ö\u0002\u001a\u00030³\u0001H\u0002J\n\u0010Ü\u0002\u001a\u00030³\u0001H\u0002J\u0015\u0010Ý\u0002\u001a\u00030³\u00012\t\u0010ñ\u0001\u001a\u0004\u0018\u00010*H\u0002J\n\u0010Þ\u0002\u001a\u00030³\u0001H\u0002J\u0013\u0010ß\u0002\u001a\u00030³\u00012\u0007\u0010à\u0002\u001a\u00020*H\u0002J\n\u0010á\u0002\u001a\u00030³\u0001H\u0002J\u0014\u0010â\u0002\u001a\u00030\u0080\u00012\b\u0010ã\u0002\u001a\u00030\u0080\u0001H\u0002J\u0014\u0010ä\u0002\u001a\u00030³\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0015\u0010å\u0002\u001a\u00030³\u00012\t\u0010ñ\u0001\u001a\u0004\u0018\u00010*H\u0002J\u0016\u0010æ\u0002\u001a\u00030³\u00012\n\u0010ç\u0002\u001a\u0005\u0018\u00010è\u0002H\u0002J\n\u0010ì\u0002\u001a\u00030³\u0001H\u0002J\u0016\u0010í\u0002\u001a\u00030³\u00012\n\u0010î\u0002\u001a\u0005\u0018\u00010\u0080\u0001H\u0002J\n\u0010ï\u0002\u001a\u00030³\u0001H\u0002J\n\u0010ô\u0002\u001a\u00030³\u0001H\u0002J\t\u0010õ\u0002\u001a\u00020\rH\u0002J\n\u0010ö\u0002\u001a\u00030³\u0001H\u0002J\n\u0010÷\u0002\u001a\u00030³\u0001H\u0002J\n\u0010ø\u0002\u001a\u00030³\u0001H\u0002J\t\u0010û\u0002\u001a\u00020\u0001H\u0016J\u000b\u0010ü\u0002\u001a\u0004\u0018\u00010\u0011H\u0016J\f\u0010ý\u0002\u001a\u0005\u0018\u00010þ\u0002H\u0016J\t\u0010ÿ\u0002\u001a\u00020=H\u0016J\t\u0010\u0080\u0003\u001a\u00020BH\u0016J\t\u0010\u0081\u0003\u001a\u00020GH\u0016J\n\u0010\u0082\u0003\u001a\u00030³\u0001H\u0016J\n\u0010\u0083\u0003\u001a\u00030\u0080\u0001H\u0016J\n\u0010\u0084\u0003\u001a\u00030\u0080\u0001H\u0016J\n\u0010\u0085\u0003\u001a\u00030\u0080\u0001H\u0016J\u001d\u0010\u0086\u0003\u001a\u0004\u0018\u00010\r2\n\u0010\u0087\u0003\u001a\u0005\u0018\u00010\u0088\u0003H\u0016¢\u0006\u0003\u0010\u0089\u0003J%\u0010\u008a\u0003\u001a\u00030³\u00012\b\u0010\u008b\u0003\u001a\u00030\u008c\u00032\u000f\u0010\u008d\u0003\u001a\n\u0012\u0005\u0012\u00030³\u00010²\u0001H\u0016J\u0014\u0010\u008e\u0003\u001a\u00030³\u00012\b\u0010\u008b\u0003\u001a\u00030\u008c\u0003H\u0016J\u0018\u0010\u008f\u0003\u001a\u00030³\u00012\f\u0010\u0090\u0003\u001a\u0007\u0012\u0002\b\u00030\u0091\u0003H\u0016J\n\u0010\u0092\u0003\u001a\u00030³\u0001H\u0016J\t\u0010\u0093\u0003\u001a\u00020gH\u0016J\u0014\u0010\u0094\u0003\u001a\u00030³\u00012\b\u0010\u0095\u0003\u001a\u00030\u0096\u0003H\u0016J\u0013\u0010\u0097\u0003\u001a\u00020g2\b\u0010\u0098\u0003\u001a\u00030\u0080\u0001H\u0016J\u001e\u0010\u0099\u0003\u001a\u00030³\u00012\b\u0010\u009a\u0003\u001a\u00030\u0080\u00012\b\u0010\u0098\u0003\u001a\u00030\u0080\u0001H\u0016J+\u0010\u009b\u0003\u001a$\u0012\u0005\u0012\u00030\u0080\u0001\u0012\u0005\u0012\u00030\u0080\u00010\u009c\u0003j\u0011\u0012\u0005\u0012\u00030\u0080\u0001\u0012\u0005\u0012\u00030\u0080\u0001`\u009d\u0003H\u0016J\u001e\u0010\u009e\u0003\u001a\u00030³\u00012\b\u0010\u009a\u0003\u001a\u00030\u0080\u00012\b\u0010\u0098\u0003\u001a\u00030\u0080\u0001H\u0016J\u001e\u0010\u009f\u0003\u001a\u00030³\u00012\b\u0010 \u0003\u001a\u00030Á\u00012\b\u0010\u0095\u0003\u001a\u00030\u0096\u0003H\u0016J\t\u0010¡\u0003\u001a\u00020gH\u0016J\u0018\u0010¢\u0003\u001a\u0011\u0012\u0005\u0012\u00030\u0080\u0001\u0012\u0005\u0012\u00030\u0080\u00010\u0094\u0002H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0017\u001a\u0004\b$\u0010%R\u000e\u0010'\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0017\u001a\u0004\b/\u00100R\u0016\u00102\u001a\u0004\u0018\u0001038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0016\u00106\u001a\u0004\u0018\u0001038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00105R\u0016\u00108\u001a\u0004\u0018\u0001098BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u001b\u0010<\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u0017\u001a\u0004\b>\u0010?R\u001b\u0010A\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0017\u001a\u0004\bC\u0010DR\u001b\u0010F\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u0017\u001a\u0004\bH\u0010IR\u001b\u0010K\u001a\u00020L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010\u0017\u001a\u0004\bM\u0010NR\u000e\u0010P\u001a\u00020QX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010R\u001a\u00020S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\u0017\u001a\u0004\bT\u0010UR\u001b\u0010W\u001a\u00020X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\u0017\u001a\u0004\bY\u0010ZR\u001d\u0010\\\u001a\u0004\u0018\u00010]8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010\u0017\u001a\u0004\b^\u0010_R\u001b\u0010a\u001a\u00020b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\be\u0010\u0017\u001a\u0004\bc\u0010dR\u000e\u0010f\u001a\u00020gX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010h\u001a\u00020g8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bh\u0010iR\u0010\u0010j\u001a\u0004\u0018\u00010kX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020gX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010m\u001a\u00020n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bq\u0010\u0017\u001a\u0004\bo\u0010pR\u0010\u0010r\u001a\u0004\u0018\u00010sX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020gX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010u\u001a\u00020g8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bw\u0010\u0017\u001a\u0004\bv\u0010iR\u001b\u0010x\u001a\u00020y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b|\u0010\u0017\u001a\u0004\bz\u0010{R\u0014\u0010}\u001a\u00020g8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b~\u0010iR\u0017\u0010\u007f\u001a\u00030\u0080\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u000f\u0010\u0088\u0001\u001a\u00020gX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020gX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008e\u0001\u0010\u0017\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0016\u0010\u008f\u0001\u001a\u00020g8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u008f\u0001\u0010iR%\u0010\u0090\u0001\u001a\b0\u0091\u0001j\u0003`\u0092\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0095\u0001\u0010\u0017\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001e\u0010\u0096\u0001\u001a\u00020g8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0098\u0001\u0010\u0017\u001a\u0005\b\u0097\u0001\u0010iR\u001e\u0010\u0099\u0001\u001a\u00020g8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u009b\u0001\u0010\u0017\u001a\u0005\b\u009a\u0001\u0010iR\u001e\u0010\u009c\u0001\u001a\u00020g8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u009e\u0001\u0010\u0017\u001a\u0005\b\u009d\u0001\u0010iR\u0016\u0010\u009f\u0001\u001a\u00020g8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b \u0001\u0010iR\u0016\u0010¡\u0001\u001a\u00020g8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b¢\u0001\u0010iR\u0018\u0010£\u0001\u001a\u00030¤\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b¥\u0001\u0010¦\u0001R\u0012\u0010§\u0001\u001a\u0005\u0018\u00010¨\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010©\u0001\u001a\u00030ª\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b«\u0001\u0010¬\u0001R\u000f\u0010\u00ad\u0001\u001a\u00020gX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010®\u0001\u001a\u00020gX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¯\u0001\u001a\u00030°\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010±\u0001\u001a\n\u0012\u0005\u0012\u00030³\u00010²\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010´\u0001\u001a\u0005\u0018\u00010µ\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Î\u0001\u001a\u00030Ï\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Ð\u0001\u001a\u00030Ñ\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010Ò\u0001\u001a\u00030Ó\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010Ô\u0001R\u0012\u0010×\u0001\u001a\u0005\u0018\u00010Ø\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ù\u0001\u001a\u0005\u0018\u00010Ø\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ô\u0002\u001a\u00020gX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010×\u0002\u001a\t\u0012\u0004\u0012\u00020g0Ø\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010Ù\u0002\u001a\t\u0012\u0004\u0012\u00020g0Ø\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010Ú\u0002\u001a\n\u0012\u0005\u0012\u00030\u0080\u00010Ø\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010Û\u0002\u001a\n\u0012\u0005\u0012\u00030\u0080\u00010Ø\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010é\u0002\u001a\u0005\u0018\u00010ê\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010ë\u0002\u001a\u0005\u0018\u00010\u0080\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010ð\u0002\u001a\u00030\u0080\u0001X\u0082D¢\u0006\u0002\n\u0000R\u000f\u0010ñ\u0002\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010ò\u0002\u001a\u0005\u0018\u00010ó\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010ù\u0002\u001a\u00030ú\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¤\u0003"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/SideBarContentFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/home/impl/main/side_bar/view/OnSideBarChangedListener;", "Lcom/larus/home/impl/main/side_bar/view/ISideBarContentBridge;", "Lcom/larus/home/impl/main/side_bar/view/ISideBarConversationBridge;", "Lcom/larus/home/impl/main/side_bar/view/ISideBarCaseBridge;", "Lcom/larus/larkfeed/IMixedFeedSideBarCallBackDelegate;", "Lcom/larus/home/api/feed/IFlowFeedHostCallback;", "<init>", "()V", "binding", "Lcom/larus/home/impl/databinding/LarusFragmentSideBarContentBinding;", "middleAdapterBuildGeneration", "", "middleComponentsAdapterHost", "Lcom/larus/home/impl/main/side_bar/view/adapter/arch/ReorderableConcatAdapterHost;", "middleComponentsAdapter", "Landroidx/recyclerview/widget/ConcatAdapter;", "selectionScroller", "Lcom/larus/home/impl/main/side_bar/view/SideBarSelectionScroller;", "getSelectionScroller", "()Lcom/larus/home/impl/main/side_bar/view/SideBarSelectionScroller;", "selectionScroller$delegate", "Lkotlin/Lazy;", "currentFlowFeedSelectionKey", "Lcom/larus/home/api/feed/FlowFeedSelectionKey;", "getCurrentFlowFeedSelectionKey", "()Lcom/larus/home/api/feed/FlowFeedSelectionKey;", "adapterItemShowResult", "Lcom/larus/home/impl/main/side_bar/view/ItemShowResult;", "larkBadgeManager", "Lcom/larus/bmhome/SideBarLarkBadgeManager;", "conversationGroupController", "Lcom/larus/home/impl/main/side_bar/view/group/assembly/GroupController;", "deviceListDataSource", "Lcom/larus/home/impl/main/side_bar/view/group/datasource/im/DeviceListRepository;", "getDeviceListDataSource", "()Lcom/larus/home/impl/main/side_bar/view/group/datasource/im/DeviceListRepository;", "deviceListDataSource$delegate", "conversationGroupComponentIndex", "conversationContainerAdapterIndex", "conversationGroupComponent", "Lcom/larus/home/impl/main/side_bar/data/SideBarComponent;", "conversationGroupBuildJob", "Lkotlinx/coroutines/Job;", "flatContainer", "Lcom/larus/home/impl/main/side_bar/view/flat/FlatConversationContainer;", "getFlatContainer", "()Lcom/larus/home/impl/main/side_bar/view/flat/FlatConversationContainer;", "flatContainer$delegate", "conversationAdapter", "Lcom/larus/home/impl/main/side_bar/view/adapter/SideBarConversationAdapter;", "getConversationAdapter", "()Lcom/larus/home/impl/main/side_bar/view/adapter/SideBarConversationAdapter;", "mainBotAdapter", "getMainBotAdapter", "caseAdapter", "Lcom/larus/home/impl/main/side_bar/view/adapter/SideBarCaseAdapter;", "getCaseAdapter", "()Lcom/larus/home/impl/main/side_bar/view/adapter/SideBarCaseAdapter;", "internalConversationModel", "Lcom/larus/bmhome/chat/model/ConversationModel;", "getInternalConversationModel", "()Lcom/larus/bmhome/chat/model/ConversationModel;", "internalConversationModel$delegate", "internalConversationChangeModel", "Lcom/larus/bmhome/ConversationChangeModel;", "getInternalConversationChangeModel", "()Lcom/larus/bmhome/ConversationChangeModel;", "internalConversationChangeModel$delegate", "internalScreenMenu", "Lcom/larus/bmhome/view/screenmenu/ScreenMenu;", "getInternalScreenMenu", "()Lcom/larus/bmhome/view/screenmenu/ScreenMenu;", "internalScreenMenu$delegate", "projectActionHandler", "Lcom/larus/home/impl/main/side_bar/view/project/SideBarProjectActionHandler;", "getProjectActionHandler", "()Lcom/larus/home/impl/main/side_bar/view/project/SideBarProjectActionHandler;", "projectActionHandler$delegate", "pendingDeleteObserver", "Lcom/larus/bmhome/chat/helper/ConversationDeleteUndoHelper$Observer;", "groupMenuPresenter", "Lcom/larus/home/impl/main/side_bar/view/menu/GroupScreenMenuPresenter;", "getGroupMenuPresenter", "()Lcom/larus/home/impl/main/side_bar/view/menu/GroupScreenMenuPresenter;", "groupMenuPresenter$delegate", "sideBarContentLogUtils", "Lcom/larus/home/impl/main/side_bar/view/utils/SideBarContentLogUtils;", "getSideBarContentLogUtils", "()Lcom/larus/home/impl/main/side_bar/view/utils/SideBarContentLogUtils;", "sideBarContentLogUtils$delegate", "conversationFragmentAbility", "Lcom/larus/bmhome/chat/api/IConversationFragmentAbility;", "getConversationFragmentAbility", "()Lcom/larus/bmhome/chat/api/IConversationFragmentAbility;", "conversationFragmentAbility$delegate", "doubaoFeedMonitor", "Lcom/larus/bmhome/chat/api/DouBaoConversationFeedMonitor;", "getDoubaoFeedMonitor", "()Lcom/larus/bmhome/chat/api/DouBaoConversationFeedMonitor;", "doubaoFeedMonitor$delegate", "isOpenByClick", "", "isSideBarOpen", "()Z", "leadingTopDividerAdapter", "Lcom/larus/home/impl/main/side_bar/feed/arch/VisibilityAdapter;", "isLeadingSectionCollapsed", "dayChangeWatcher", "Lcom/larus/home/impl/main/side_bar/view/SideBarDayChangeWatcher;", "getDayChangeWatcher", "()Lcom/larus/home/impl/main/side_bar/view/SideBarDayChangeWatcher;", "dayChangeWatcher$delegate", "pcAvatarController", "Lcom/larus/home/impl/main/side_bar/view/SideBarPcAvatarController;", "isSideBarConfigModelFromPreload", "sideBarStartupOptimize", "getSideBarStartupOptimize", "sideBarStartupOptimize$delegate", "sideBarConfigModel", "Lcom/larus/home/impl/main/side_bar/data/SideBarConfigModel;", "getSideBarConfigModel", "()Lcom/larus/home/impl/main/side_bar/data/SideBarConfigModel;", "sideBarConfigModel$delegate", "useNewWorkTaskButton", "getUseNewWorkTaskButton", "defaultNewConversationMode", "", "getDefaultNewConversationMode", "()Ljava/lang/String;", "isSupportedNewConversationMode", "mode", "shouldRefreshNewConversationEntry", "userConfigKey", "Lcom/larus/bmhome/chat/setting/bean/UserConfigKey;", "isMainConversationOutScreen", "hasReportSLO", "multiAccountProfileService", "Lcom/larus/account/base/api/IMultiAccountProfileService;", "getMultiAccountProfileService", "()Lcom/larus/account/base/api/IMultiAccountProfileService;", "multiAccountProfileService$delegate", "isLarkSocialEnabled", "conversationGroupExperimentConfig", "Lcom/larus/settings/provider/home/ConversationGroupExperimentConfig;", "Lcom/larus/home/impl/main/side_bar/ConversationGroupExperimentConfig;", "getConversationGroupExperimentConfig", "()Lcom/larus/settings/provider/home/ConversationGroupExperimentConfig;", "conversationGroupExperimentConfig$delegate", "conversationGroupEnabled", "getConversationGroupEnabled", "conversationGroupEnabled$delegate", "conversationArchiveAvailable", "getConversationArchiveAvailable", "conversationArchiveAvailable$delegate", "mergeMainConversationEnabled", "getMergeMainConversationEnabled", "mergeMainConversationEnabled$delegate", "mixedPinnedEnabled", "getMixedPinnedEnabled", "sortWithPinTime", "getSortWithPinTime", "effectiveConversationGroupSortPolicy", "Lcom/larus/home/impl/main/side_bar/view/group/datasource/GroupSortPolicy;", "getEffectiveConversationGroupSortPolicy", "()Lcom/larus/home/impl/main/side_bar/view/group/datasource/GroupSortPolicy;", "mainConversationSource", "Lcom/larus/home/impl/main/side_bar/view/group/datasource/im/SideBarMainConversationDataSource;", "effectiveConversationArchiveFilter", "Lcom/larus/home/impl/main/side_bar/view/group/policy/ConversationArchiveFilter;", "getEffectiveConversationArchiveFilter", "()Lcom/larus/home/impl/main/side_bar/view/group/policy/ConversationArchiveFilter;", "appliedMixedPinnedEnabled", "appliedSortWithPinTime", "multiTaskEntranceUpdatePending", "Ljava/util/concurrent/atomic/AtomicBoolean;", "multiTaskEntranceConfigListener", "Lkotlin/Function0;", "", "feedTabInfo", "Lcom/larus/home/impl/main/side_bar/data/SideBarTabInfo;", "onLarkApiReady", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onPause", "syncDayChangeWatcher", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "observePendingConfirmations", "notifyPendingConfirmationChanged", "changedConversationIds", "", "syncLarkBadgeManager", "activeEnabled", "humanFeedPorts", "Lcom/larus/home/impl/main/side_bar/view/group/datasource/lark/SideBarHumanFeedPortHolder;", "listBrowseStates", "Lcom/larus/home/impl/main/side_bar/view/group/render/SideBarListBrowseStateHolder;", "humanFeedPortAccountCallback", "com/larus/home/impl/main/side_bar/view/SideBarContentFragment$humanFeedPortAccountCallback$1", "Lcom/larus/home/impl/main/side_bar/view/SideBarContentFragment$humanFeedPortAccountCallback$1;", "attachFpsTracer", "observeSidebarScrolled", "showBackDoubaoAnimator", "Landroid/animation/ObjectAnimator;", "hideBackDoubaoAnimator", "showOrHideBackDoubao", "showBackDoubao", "hideBackDoubao", "showOrHideNewWorkTask", "isNewWorkTaskEntryOutOfScreen", "bindNewWorkTaskButton", "updateBackDoubaoStyle", "initEvents", "getMainConversationGlobalPosition", "getNewWorkTaskGlobalPosition", "getGlobalPosition", "concatAdapter", "targetAdapter", "Lcom/larus/home/impl/main/side_bar/view/adapter/BaseSideBarAdapter;", "localPosition", "onDestroyView", LiveCommonConstants.REASON_ON_DEDTROY, "onTopChanged", "topComponent", "onBottomChanged", "bottomComponent", "buildConversationAdapter", "index", "component", "createConversationAdapter", "insertionIndex", "dividerAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "Lcom/larus/home/impl/main/side_bar/data/DividerPositionEnum;", "updateLeadingSectionCollapsed", "collapsed", "applyLeadingTopDividerVisibility", "resetMiddleAdapterStateAfterStructureChange", "reason", "logMiddleAdapterState", "createComponentAdapter", "Lcom/larus/home/impl/main/side_bar/view/adapter/SideBarComponentAdapter;", "enableDragAndDrop", "onOrderChanged", "Lkotlin/Function2;", "", "onCollapsedStateChanged", "Lkotlin/Function1;", "onMiddleAllChanged", "middleComponentContainerList", "updateSideBarComponentOrder", "componentId", "orderedIdentifiers", "createMiddleComponentsAdapter", "createConversationGroups", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "includeMainConversation", "(ILcom/larus/home/impl/main/side_bar/data/SideBarComponent;Lkotlinx/coroutines/CoroutineScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildConversationGroupController", "reusableContent", "", "Lcom/larus/home/impl/main/side_bar/view/group/render/GroupContent;", "policy", "Lcom/larus/home/impl/main/side_bar/view/group/policy/ConversationGroupPolicy;", "showSkeleton", "(Lkotlinx/coroutines/CoroutineScope;Ljava/util/Map;ILcom/larus/home/impl/main/side_bar/data/SideBarComponent;Lcom/larus/home/impl/main/side_bar/view/group/policy/ConversationGroupPolicy;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findSelectionLocalAdapterPosition", "adapter", "selectionKey", "rebuildConversationContainer", "reusePinnedContent", "(Lkotlinx/coroutines/CoroutineScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logConversationGroupController", "action", "controller", "adapterNotifyConversationList", "foldConfigList", "Lcom/larus/home/impl/main/side_bar/data/SideBarItemConfig;", "unfoldConfigList", "checkNoCvsItem", "getAdapterTabPosition", "onMiddleConversationListChanged", "foldConversationConfigList", "unfoldConversationConfigList", "onGroupConfigChanged", "onMiddleCaseListChanged", "caseConfigList", "onMiddleContainerListChanged", "onMiddleContainerChildrenChanged", "changedMiddleContainers", "onBackDoubaoChanged", "iconImage", "Lcom/larus/im/bean/conversation/IconImage;", "text", "onSideBarOpen", "isClick", "resetDisplaySize", "onSideBarClose", "reportConvListSLO", "onSearchShowMob", "getSideBarConversationSize", "isValidConversationItem", "onSearchClickMob", "onProfileShowMob", "onProfileClickMob", "onBottomActionShowMob", "onBottomActionClickMob", "getBottomActionCellPosition", "getBottomActionNoticeInfo", "Lkotlin/Pair;", "getBottomTabPosition", "onMiddleShowAction", "onAdapterItemShowMob", "globalPosition", "viewHolder", "showArchivedConversations", "updateConversationArchiveFilter", "filter", "selectComponent", "page", "tab", "itemId", "source", "createFlowFeedSelectionKey", "relatedVideoEnabled", "notifyFoldComponents", "observeUserSettingChanged", "creationUpdateObserver", "Landroidx/lifecycle/Observer;", "collectionUpdateObserver", "botCreateObserver", "botDeleteObserver", "observeProfileChanged", "buildTopElements", "updateCreateConversationEntryVisibility", "openSideBarSearch", "searchComponent", "startCreateConversation", "buildSchemaWithCommonParams", "schema", "applyReverseSidebarAvatarLayout", "buildBottomElements", "applyReverseActionItemLayout", "actionBinding", "Lcom/larus/home/impl/databinding/LarusLayoutSideBarBottomActionBinding;", "cachedUserInfo", "Lcom/larus/account/base/model/profile/UserInfo;", "latestTenantName", "observeSubscriptionEntryConfig", "updateProfileIdentityLine", "tenantName", "observeUserInfo", "VIEW_TAG_NOTICE_RED_DOT", "noticeCount", "noticeObserver", "Lcom/larus/bmhome/chat/model/repo/INotifyRedDotLifecycleObserver;", "addNoticeObserver", "getCurrentSideBarPage", "removeNoticeObserver", "reportMsgNoticeShow", "reportMsgNoticeChange", "groupHost", "Lcom/larus/home/impl/main/side_bar/view/group/assembly/GroupHost;", "getFragment", "getParentAdapter", "getSideBarRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getConversationModel", "getConversationChangeModel", "getScreenMenu", "tryLoadMoreConversation", "getCurrentPage", "getPreviousPage", "getEnterMethod", "getPcConversationAvatarRes", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "(Lcom/larus/im/bean/conversation/Conversation;)Ljava/lang/Integer;", "registerPcAvatarRefreshCallback", "owner", "", "callback", "unregisterPcAvatarRefreshCallback", "onFlowFeedCardSelected", BrowserDependency.UrlClickType.CARD, "Lcom/larus/home/api/feed/FlowUIFeedCard;", "onCreateProjectRequested", "isConversationArchiveEnabled", "onArchiveConversationRequested", "conversationData", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "isConversationPendingDelete", "conversationId", "onDouBaoMixedFeedConversationClicked", "feedId", "getFlowHitpointParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "onConversationClicked", "onConversationLongPressed", "anchor", "getSocialIndependentGroup", "getHitPointParams", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SideBarContentFragment extends Fragment implements f, com.larus.home.impl.main.side_bar.view.b, c, com.larus.home.impl.main.side_bar.view.a, nh9.b, eb9.y {

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final /* synthetic */ int f344768k1 = 0;
    public boolean A;
    public VisibilityAdapter B;
    public boolean C;
    public final Lazy D;
    public SideBarPcAvatarController E;
    public boolean F;
    public final Lazy G;
    public final Lazy H;
    public final u H0;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f344769J;
    public final Lazy K;
    public final Lazy L;
    public r38.b L0;
    public final Lazy M;
    public final Lazy N;
    public final Lazy O;
    public com.larus.home.impl.main.side_bar.view.group.datasource.im.s0 P;
    public String P0;
    public boolean Q;
    public boolean R;
    public final AtomicBoolean S;
    public final o T;
    public com.larus.home.impl.main.side_bar.data.d1 U;
    public final com.larus.home.impl.main.side_bar.view.group.datasource.lark.u V;
    public final String V0;
    public final com.larus.home.impl.main.side_bar.view.group.render.o0 W;
    public final SideBarContentFragment$humanFeedPortAccountCallback$1 X;
    public boolean Y;
    public final p Z;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public int f344770b1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusFragmentSideBarContentBinding f344771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f344772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReorderableConcatAdapterHost f344773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ConcatAdapter f344774g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public INotifyRedDotLifecycleObserver f344775g1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f344776h;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public final b f344777h1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f344778i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.larus.bmhome.l0 f344779j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public GroupController f344780k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final s f344781k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f344782l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f344783m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f344784n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.larus.home.impl.main.side_bar.data.p f344785o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Job f344786p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final t f344787p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f344788q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f344789r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f344790s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f344791t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f344792u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final y f344793v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f344794w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f344795x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f344796y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f344797z;

    public static final class a {
    }

    public static final class b implements com.larus.home.impl.main.side_bar.view.group.assembly.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SideBarContentFragment f344798a;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f344799a = null;

            static {
                int[] r100 = new int[ConversationArchiveFilter.values().length];
                r100[ConversationArchiveFilter.Active.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[ConversationArchiveFilter.Archived.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f344799a = r100;
            }
        }

        @Override // com.larus.home.impl.main.side_bar.view.group.assembly.n
        public final com.larus.home.impl.main.side_bar.view.group.datasource.lark.u a() {
            return this.f344798a.V;
        }

        @Override // com.larus.home.impl.main.side_bar.view.group.assembly.n
        public final SideBarProjectActionHandler c() {
            SideBarContentFragment r100 = this.f344798a;
            int r101 = SideBarContentFragment.f344768k1;
            return (SideBarProjectActionHandler) r100.f344792u.getValue();
        }

        @Override // com.larus.home.impl.main.side_bar.view.group.assembly.n
        public final ac9.c0 d() {
            return (ac9.c0) this.f344798a.f344794w.getValue();
        }

        @Override // com.larus.home.impl.main.side_bar.view.group.assembly.n
        public final SideBarConfigModel h() {
            SideBarContentFragment r100 = this.f344798a;
            int r101 = SideBarContentFragment.f344768k1;
            return r100.sa0();
        }

        @Override // com.larus.home.impl.main.side_bar.view.group.assembly.n
        public final com.larus.home.impl.main.side_bar.view.group.render.o0 i() {
            return this.f344798a.W;
        }

        @Override // com.larus.home.impl.main.side_bar.view.group.assembly.n
        public final GroupController j() {
            return this.f344798a.f344780k;
        }

        @Override // com.larus.home.impl.main.side_bar.view.group.assembly.n
        public final SideBarContentFragment f() {
            return this.f344798a;
        }

        @Override // com.larus.home.impl.main.side_bar.view.group.assembly.n
        public final SideBarContentFragment g() {
            return this.f344798a;
        }

        @Override // com.larus.home.impl.main.side_bar.view.group.assembly.n
        public final SideBarContentFragment getFragment() {
            return this.f344798a;
        }

        public b(SideBarContentFragment r100) {
            this.f344798a = r100;
        }

        @Override // com.larus.home.impl.main.side_bar.view.group.assembly.n
        public final void b(ConversationGroupPolicy r100) {
            Intrinsics.checkNotNullParameter(r100, "policy");
            p3.h(this.f344798a.getCurrentPage(), "group", com.larus.home.impl.main.side_bar.view.group.assembly.a.b(r100), null, null, 56);
            SideBarConfigModel r101 = this.f344798a.sa0();
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, "policy");
            r101.c(r100, SideBarConfigModel.g(), true, true);
        }

        @Override // com.larus.home.impl.main.side_bar.view.group.assembly.n
        public final void e(boolean r100) {
            SideBarContentFragment r101 = this.f344798a;
            int r102 = SideBarContentFragment.f344768k1;
            SideBarConfigModel r103 = r101.sa0();
            r103.getClass();
            SideBarRepo.f344467a.getClass();
            com.larus.home.impl.main.side_bar.data.e r104 = SideBarRepo.c();
            if (r104.f344496d == r100) goto L10;
            SideBarRepo.l(r104.f344493a, r104.f344494b, r104.f344495c, r100, true);
            f r105 = r103.f344431b;
            if (r105 == null) goto L9;
            r105.L20();
            return;
        L9:
            return;
        }

        @Override // com.larus.home.impl.main.side_bar.view.group.assembly.n
        public final void k(GroupSortPolicy r100) {
            Intrinsics.checkNotNullParameter(r100, "policy");
            p3.h(this.f344798a.getCurrentPage(), "sort", null, com.larus.home.impl.main.side_bar.view.group.assembly.a.a(r100), null, 52);
            SideBarConfigModel r101 = this.f344798a.sa0();
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, "policy");
            r101.c(SideBarConfigModel.f(), r100, false, true);
            GroupController r102 = this.f344798a.f344780k;
            if (r102 == null) goto L9;
            Intrinsics.checkNotNullParameter(r100, "policy");
            if (r102.f345121c == r100) goto L10;
            r102.f345121c = r100;
            int r103 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
            com.larus.home.impl.main.side_bar.feed.arch.t.c("controller_sort", r102.n() + " policy=" + r100);
            r102.f345125g.i(r100);
            return;
        L10:
            return;
        }

        @Override // com.larus.home.impl.main.side_bar.view.group.assembly.n
        public final void l(ConversationArchiveFilter r100) {
            Intrinsics.checkNotNullParameter(r100, "filter");
            SideBarContentFragment r101 = this.f344798a;
            int r102 = SideBarContentFragment.f344768k1;
            if (r101.fa0() == true) goto L5;
            return;
        L5:
            if (this.f344798a.ka0() == r100) goto L18;
            String r103 = this.f344798a.getCurrentPage();
            this.f344798a.sa0().getClass();
            String r104 = com.larus.home.impl.main.side_bar.view.group.assembly.a.b(SideBarConfigModel.f());
            this.f344798a.sa0().getClass();
            String r105 = com.larus.home.impl.main.side_bar.view.group.assembly.a.a(SideBarConfigModel.g());
            int r106 = a.f344799a[r100.ordinal()];
            if (r106 != 1) goto L10;
            String r107 = "active";
        L15:
            p3.h(r103, "conversation_filter", r104, r105, r107, 32);
            this.f344798a.Ka0(r100);
            return;
        L10:
            if (r106 != 2) goto L13;
            r107 = "archive";
            goto L15
        L13:
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: com.larus.home.impl.main.side_bar.view.SideBarContentFragment$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.home.impl.main.side_bar.view.SideBarContentFragment$onCreate$1", f = "SideBarContentFragment.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_TERMINATED_DTS}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SideBarContentFragment this$0;

        /* JADX INFO: renamed from: com.larus.home.impl.main.side_bar.view.SideBarContentFragment$onCreate$1$a */
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f344808a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f344809b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ SideBarContentFragment f344810c;

            public a(Ref.BooleanRef r100, Ref.BooleanRef r101, SideBarContentFragment r102) {
                this.f344808a = r100;
                this.f344809b = r101;
                this.f344810c = r102;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r100, Continuation r101) {
                m2 r102 = (m2) r100;
                boolean r103 = r102.f486674c;
                Ref.BooleanRef r104 = this.f344808a;
                boolean r105 = false;
                if (r103 == r104.element) goto L5;
                boolean r106 = true;
            L6:
                boolean r107 = r102.f486675d;
                Ref.BooleanRef r108 = this.f344809b;
                if (r107 == r108.element) goto L9;
                boolean r109 = true;
            L10:
                if (r106 == true) goto L13;
                if (r109 == true) goto L13;
                return Unit.INSTANCE;
            L13:
                r104.element = r103;
                r108.element = r107;
                FLogger r110 = FLogger.f375446a;
                r110.i("SideBarContentFragment", "lark capability changed bizEnabled=" + this.f344808a.element + " activeEnabled=" + this.f344809b.element + ", rebuild container");
                SideBarContentFragment r111 = this.f344810c;
                boolean r112 = r102.f486675d;
                int r113 = SideBarContentFragment.f344768k1;
                r111.Ia0(r112);
                boolean r114 = this.f344810c.ga0();
                this.f344810c.getClass();
                boolean r115 = SideBarContentFragment.qa0();
                if (r114 == true) goto L18;
                if (r115 == true) goto L18;
                boolean r116 = false;
            L19:
                if (r109 == false) goto L26;
                FlatConversationContainer r117 = this.f344810c.la0();
                boolean r118 = r102.f486675d;
                if (r117.f345101j != r118) goto L23;
                boolean r119 = false;
            L24:
                if (r119 == false) goto L26;
                r105 = true;
                goto L26
            L23:
                r110.i("FlatConversationContainer", "updateLarkWholeFeed " + r117.f345101j + "->" + r118);
                r117.f345101j = r118;
                r117.i();
                r119 = true;
            L26:
                if (r106 == false) goto L31;
                SideBarConfigModel r120 = this.f344810c.sa0();
                f r121 = r120.f344431b;
                if (r121 == null) goto L30;
                r121.v70(r120.f344433d);
            L30:
                r120.v(true);
            L35:
                return Unit.INSTANCE;
            L31:
                if (r105 == true) goto L33;
                if (r116 == false) goto L35;
            L33:
                this.f344810c.sa0().t();
            L18:
                r116 = true;
                goto L19
            L9:
                r109 = false;
                goto L10
            L5:
                r106 = false;
                goto L6
            }
        }

        public AnonymousClass1(SideBarContentFragment r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L6;
            ResultKt.throwOnFailure(r100);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            Ref.BooleanRef r103 = new Ref.BooleanRef();
            LarkSocialExp.f365340a.getClass();
            r103.element = LarkSocialExp.f();
            Ref.BooleanRef r104 = new Ref.BooleanRef();
            r104.element = LarkSocialExp.e();
            StateFlowImpl r105 = LarkSocialExp.f365344e;
            a r106 = new a(r103, r104, this.this$0);
            this.label = 1;
            if (r105.collect(r106, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.home.impl.main.side_bar.view.SideBarContentFragment$onViewCreated$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.home.impl.main.side_bar.view.SideBarContentFragment$onViewCreated$4", f = "SideBarContentFragment.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAYER_REQ_OFFSET}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SideBarConfigModel $configModel;
        int label;
        final /* synthetic */ SideBarContentFragment this$0;

        public AnonymousClass4(SideBarConfigModel r100, SideBarContentFragment r101, Continuation<? super AnonymousClass4> r102) {
            this.$configModel = r100;
            this.this$0 = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass4(this.$configModel, this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass4) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L9;
            if (r102 != 1) goto L8;
            ResultKt.throwOnFailure(r100);     // Catch: Exception -> L13 CancellationException -> L15
        L21:
        L19:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r100);
            SideBarConfigModel r103 = this.$configModel;     // Catch: Exception -> L13 CancellationException -> L15
            SideBarContentFragment r104 = this.this$0;     // Catch: Exception -> L13 CancellationException -> L15
            this.label = 1;     // Catch: Exception -> L13 CancellationException -> L15
            if (r103.i(r104, this) != r101) goto L21;
            return r101;
        L15:
            e = move-exception;
            throw e;
        L13:
            e = move-exception;
            com.larus.platform.service.g.f365738a.ensureNotReachHere(e);
            goto L19
        }
    }

    static {
    }

    @Override // com.larus.home.impl.main.side_bar.view.b
    public final Fragment getFragment() {
        return this;
    }

    public static String ia0() {
        UserSettingCacheManager.f313814a.getClass();
        DefaultActiveModeSettingValue r100 = UserSettingCacheManager.d();
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getCurrentSelectMode();
    L6:
        boolean r103 = true;
        if (r102 != null) goto L9;
    L31:
        DefaultReplySwitchMenuMode r104 = null;
    L33:
        if (r102 != null) goto L35;
    L46:
        if (r104 == null) goto L57;
        String r105 = r104.getDefaultConversationMode();
        if (r105 == null) goto L57;
        if (Intrinsics.areEqual(r105, "chat") == false) goto L52;
    L55:
        if (r103 == false) goto L57;
        r101 = r105;
        goto L57
    L52:
        if (Intrinsics.areEqual(r105, "office") == true) goto L55;
        r103 = false;
    L57:
        if (r101 != null) goto L60;
        return z2.f365865a.getDefaultNewConversationMode();
    L60:
        return r101;
    L35:
        if (Intrinsics.areEqual(r102, "chat") == false) goto L37;
    L40:
        boolean r106 = true;
    L41:
        if (r106 == true) goto L44;
        r102 = null;
    L44:
        if (r102 == null) goto L46;
        return r102;
    L37:
        if (Intrinsics.areEqual(r102, "office") == true) goto L40;
        r106 = false;
        goto L41
    L9:
        if ((!StringsKt.isBlank(r102)) == false) goto L11;
        String r107 = r102;
    L12:
        if (r107 == null) goto L31;
        DefaultReplyMenuDataV2 r108 = UserSettingCacheManager.e();
        if (r108 == null) goto L20;
        DefaultReplyMenuConfigV2 r109 = r108.getMenuConfV2();
        if (r109 == null) goto L20;
        DefaultReplySwitchModeConfig r110 = r109.getModeList();
        if (r110 == null) goto L20;
        List<DefaultReplySwitchMenuMode> r111 = r110.getItemList();
    L21:
        if (r111 != null) goto L23;
        r111 = CollectionsKt.emptyList();
    L23:
        Iterator r112 = CollectionsKt.filterNotNull(r111).iterator();
    L25:
        if (r112.hasNext() == false) goto L29;
        Object r113 = r112.next();
        if (Intrinsics.areEqual(((DefaultReplySwitchMenuMode) r113).getModeId(), r107) == false) goto L25;
    L30:
        r104 = (DefaultReplySwitchMenuMode) r113;
        goto L33
    L29:
        r113 = null;
    L20:
        r111 = null;
        goto L21
    L11:
        r107 = null;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public static boolean qa0() {
        return z2.f365865a.getMultiTaskEntranceConfig().e();
    }

    public static boolean va0() {
        Object r100 = com.larus.home.impl.main.side_bar.p.f344760a;
        hq9.a0 r101 = z2.f365865a.getBasicExperienceFeatureConfig();
        if (com.larus.platform.service.n0.f365775a.b() == true) goto L19;
        com.larus.bmhome.auth.e0 r102 = AuthModelDelegate.f297134b.D();
        String r103 = null;
        if (r102 == null) goto L8;
        String r104 = r102.V();
    L10:
        if (Intrinsics.areEqual(r104, "1") == false) goto L17;
        UserConfigItem r105 = UserSettingDelegate.f308901b.b(UserConfigKey.STARTUP_OPEN_NEW_CHAT);
        if (r105 == null) goto L15;
        r103 = r105.c();
    L15:
        if (Intrinsics.areEqual(r103, "1") == false) goto L17;
        return true;
    L17:
        return false;
    L8:
        r104 = null;
        goto L10
    L19:
        return r101.f486523a;
    }

    public final void Ea0() {
        GroupController r100 = this.f344780k;
        if (r100 == null) goto L20;
        Triple<Integer, String, String> r101 = sa0().A;
        if (r101 == null) goto L7;
        Integer r102 = r101.getFirst();
    L8:
        Iterator<com.larus.home.impl.main.side_bar.feed.arch.s.a> r103 = r100.f345125g.f344634d.iterator();
    L10:
        if (r103.hasNext() == false) goto L31;
        List<fb9.a> r104 = r103.next().f344635a.getAbilities();
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L13:
        if (r106.hasNext() == false) goto L17;
        Object r107 = r106.next();
        if ((r107 instanceof fb9.e) == false) goto L13;
        r105.add(r107);
        goto L13
    L17:
        fb9.e r108 = (fb9.e) ((fb9.a) CollectionsKt.firstOrNull(r105));
        if (r108 == null) goto L10;
        r108.j(r102);
        goto L10
    L31:
        return;
    L7:
        r102 = null;
        goto L8
    }

    @Override // com.larus.home.impl.main.side_bar.view.c
    public final ConversationModel HC() {
        return (ConversationModel) this.f344789r.getValue();
    }

    @Override // nh9.b
    public final HashMap<String, String> J0() {
        Pair[] r100 = new Pair[8];
        r100[0] = TuplesKt.to("current_page", getCurrentPage());
        r100[1] = TuplesKt.to("previous_page", b());
        r100[2] = TuplesKt.to("enter_method", getEnterMethod());
        com.larus.home.impl.main.side_bar.data.d1 r101 = this.U;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.f344490a;
    L6:
        String r104 = "";
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        r100[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r103);
        com.larus.home.impl.main.side_bar.data.d1 r105 = this.U;
        if (r105 == null) goto L14;
        Integer r106 = r105.f344491b;
        if (r106 == null) goto L14;
        r102 = r106.toString();
    L14:
        if (r102 == null) goto L17;
        r104 = r102;
    L17:
        r100[4] = TuplesKt.to("tab_position", r104);
        r100[5] = TuplesKt.to("is_navigation_sidebar", "1");
        sa0().getClass();
        r100[6] = TuplesKt.to("group_by", com.larus.home.impl.main.side_bar.view.group.assembly.a.b(SideBarConfigModel.f()));
        sa0().getClass();
        r100[7] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SORD_TYPE, com.larus.home.impl.main.side_bar.view.group.assembly.a.a(SideBarConfigModel.g()));
        return MapsKt.hashMapOf(r100);
    L5:
        r103 = null;
        goto L6
    }

    public final void Ja0() {
        LarusFragmentSideBarContentBinding r100 = this.f344771d;
        if (r100 == null) goto L13;
        SideBarFloatingButtonView r101 = r100.f344256d;
        if (r101 != null) goto L8;
        return;
    L8:
        if (va0() == true) goto L11;
        r101.f344833g = SideBarFloatingButtonView.Presentation.LEGACY;
        r101.f344834h = false;
        r101.c();
        return;
    L11:
        r101.f344834h = z2.f365865a.getBasicExperienceFeatureConfig().f486525c;
        r101.a();
        return;
    }

    @Override // com.larus.home.impl.main.side_bar.view.f
    public final void L20() {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("onGroupConfigChanged policy=");
        sa0().getClass();
        r101.append(SideBarConfigModel.f());
        r100.i("SideBarContentFragment", r101.toString());
        Job r102 = this.f344786p;
        if (r102 == null) goto L5;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L5:
        LifecycleOwner r103 = getViewLifecycleOwnerLiveData().getValue();
        if (r103 == null) goto L12;
        LifecycleCoroutineScope r104 = LifecycleOwnerKt.getLifecycleScope(r103);
        if (r104 == null) goto L13;
        this.f344786p = BuildersKt.launch$default(r104, Dispatchers.getMain(), null, new SideBarContentFragment$onGroupConfigChanged$1(this, r104, null), 2, null);
        return;
    L13:
        return;
    }

    public final void La0() {
        LarusFragmentSideBarContentBinding r100 = this.f344771d;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.f344257e.getVisibility() != 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L17;
        int r102 = lc9.c.f508615a;
        final ConstraintLayout r103 = r100.f344253a;
        final ImageView r104 = r100.f344265m;
        final LinearLayout r105 = r100.f344257e;
        if (r103 == null) goto L16;
        if (r104 == null) goto L16;
        r103.post(new lc9.a(r105, r104, r103));
    L16:
        com.larus.utils.e1.x(r100.f344265m);
        return;
    L17:
        com.larus.bmhome.view.screenmenu.d r106 = com.larus.bmhome.view.screenmenu.d.f317270a;
        com.larus.bmhome.view.screenmenu.d.b(r100.f344265m);
        int r107 = lc9.c.f508615a;
        ConstraintLayout r108 = r100.f344253a;
        if (r108 == null) goto L20;
        r108.setTouchDelegate(null);
    L20:
        com.larus.utils.e1.o(r100.f344265m);
        return;
    L8:
        r101 = false;
        goto L9
    }

    @Override // com.larus.home.impl.main.side_bar.view.c
    public final ConversationChangeModel Na() {
        return (ConversationChangeModel) this.f344790s.getValue();
    }

    @Override // com.larus.home.impl.main.side_bar.view.c
    public final com.larus.bmhome.view.screenmenu.x0 VZ() {
        return (com.larus.bmhome.view.screenmenu.x0) this.f344791t.getValue();
    }

    @Override // com.larus.home.impl.main.side_bar.view.b
    public final RecyclerView W50() {
        LarusFragmentSideBarContentBinding r100 = this.f344771d;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f344259g;
    }

    public final int da0() {
        ConcatAdapter r100 = this.f344774g;
        if (r100 == null) goto L12;
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r101 = r100.getAdapters();
        if (r101 == null) goto L12;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L13;
        Object r104 = r103.next();
        if ((!(((RecyclerView.Adapter) r104) instanceof SideBarBottomSpaceAdapter)) == false) goto L8;
        r102.add(r104);
    L13:
        if (r102 == null) goto L15;
        int r105 = r102.size();
    L17:
        return r105 + 1;
    L15:
        r105 = 0;
    L12:
        r102 = null;
        goto L13
    }

    public final SideBarCaseAdapter ea0() {
        ConcatAdapter r100 = this.f344774g;
        if (r100 == null) goto L14;
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r101 = r100.getAdapters();
        if (r101 == null) goto L14;
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        Object r103 = r102.next();
        if ((((RecyclerView.Adapter) r103) instanceof SideBarCaseAdapter) == false) goto L8;
    L13:
        RecyclerView.Adapter r104 = (RecyclerView.Adapter) r103;
    L16:
        if ((r104 instanceof SideBarCaseAdapter) == true) goto L18;
        return null;
    L18:
        return (SideBarCaseAdapter) r104;
    L12:
        r103 = null;
    L14:
        r104 = null;
        goto L16
    }

    public final boolean fa0() {
        return ((Boolean) this.N.getValue()).booleanValue();
    }

    public final boolean ga0() {
        return ((Boolean) this.M.getValue()).booleanValue();
    }

    @Override // com.larus.home.impl.main.side_bar.view.b
    public final String getEnterMethod() {
        if (this.A == false) goto L5;
        return DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON;
    L5:
        return "slide";
    }

    public final uu9.a ha0() {
        return (uu9.a) this.L.getValue();
    }

    public final com.larus.bmhome.chat.api.o ja0() {
        return (com.larus.bmhome.chat.api.o) this.f344797z.getValue();
    }

    public final FlatConversationContainer la0() {
        return (FlatConversationContainer) this.f344788q.getValue();
    }

    @Override // com.larus.home.impl.main.side_bar.view.b
    public final void mU() {
        ((SideBarProjectActionHandler) this.f344792u.getValue()).e(false);
    }

    public final SideBarConversationAdapter na0() {
        ConcatAdapter r100 = this.f344774g;
        if (r100 == null) goto L19;
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r101 = r100.getAdapters();
        if (r101 == null) goto L19;
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L17;
        Object r103 = r102.next();
        RecyclerView.Adapter r104 = (RecyclerView.Adapter) r103;
        if ((r104 instanceof SideBarConversationAdapter) == true) goto L12;
    L14:
        boolean r105 = false;
    L15:
        if (r105 == false) goto L8;
    L18:
        RecyclerView.Adapter r106 = (RecyclerView.Adapter) r103;
    L21:
        if ((r106 instanceof SideBarConversationAdapter) == true) goto L23;
        return null;
    L23:
        return (SideBarConversationAdapter) r106;
    L12:
        if (((SideBarConversationAdapter) r104).getType() != ComponentTypeEnum.MAIN_BOT.getType()) goto L14;
        r105 = true;
        goto L15
    L17:
        r103 = null;
    L19:
        r106 = null;
        goto L21
    }

    public final int oa0() {
        ConcatAdapter r100 = this.f344774g;
        if (r100 != null) goto L5;
        return -1;
    L5:
        SideBarConversationAdapter r101 = na0();
        if (r101 != null) goto L8;
        r101 = la0().f345103l;
    L8:
        int r102 = 0;
        if (r101 == null) goto L29;
        Iterator<T> r103 = r101.getCurrentList().iterator();
    L12:
        if (r103.hasNext() == false) goto L24;
        Object r104 = r103.next();
        int r105 = r102 + 1;
        if (r102 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        wh8.a r106 = ((com.larus.home.impl.main.side_bar.data.j0) r104).f344507b;
        if (r106 == null) goto L19;
        wc9.e r107 = r106.f559708a;
    L21:
        if (ic8.n.v(r107) == true) goto L25;
        r102 = r105;
    L25:
        if (r102 != (-1)) goto L28;
        return -1;
    L28:
        return ma0(r100, r101, r102);
    L19:
        r107 = null;
        goto L21
    L24:
        r102 = -1;
        goto L25
    L29:
        final GroupController r108 = this.f344780k;
        if (r108 != null) goto L33;
        return -1;
    L33:
        return com.larus.home.impl.main.side_bar.feed.arch.g.a(r100, 0, new t0(r108));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        CoroutineScope r100 = com.larus.bmhome.chat.helper.f0.f303099a;
        y r101 = this.f344793v;
        Intrinsics.checkNotNullParameter(r101, "observer");
        com.larus.bmhome.chat.helper.f0.f303100b.remove(r101);
        ((w1) this.D.getValue()).a();
        Job r102 = this.f344786p;
        if (r102 == null) goto L5;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L5:
        this.f344786p = null;
        SideBarPcAvatarController r103 = this.E;
        if (r103 == null) goto L8;
        r103.f344844e = false;
        r103.e();
        r103.f344847h.clear();
    L8:
        this.E = null;
        d2.f345077b.clear();
        super.onDestroyView();
        FLogger.f375446a.i("SideBarContentFragment", "onDestroyView " + this);
        IProfileApi.Companion r104 = IProfileApi.f365981a;
        r104.h().removeObserver(this.Z);
        r104.j().removeObserver(this.f344781k0);
        IUgcBotRepoService.Impl.f317653b.b().removeObserver(this.f344787p0);
        RepoDispatcherDelegate.f307737b.b().r1().removeObserver(this.H0);
        sa0().d();
        this.F = false;
        ReorderableConcatAdapterHost r105 = this.f344773f;
        if (r105 == null) goto L11;
        r105.d();
    L11:
        this.f344773f = null;
        LarusFragmentSideBarContentBinding r106 = this.f344771d;
        if (r106 == null) goto L16;
        RecyclerView r107 = r106.f344259g;
        if (r107 == null) goto L16;
        r107.setAdapter(null);
    L16:
        this.f344774g = null;
        this.B = null;
        this.f344778i = null;
        k2 r108 = ra0();
        r108.f345757f = false;
        r108.f345758g = false;
        GroupController r109 = this.f344780k;
        if (r109 == null) goto L19;
        r109.l();
    L19:
        this.f344780k = null;
        AccountService.f365697a.D(this.X);
        this.V.a("view_destroyed");
        this.P = null;
        this.f344783m = -1;
        this.f344784n = -1;
        this.f344785o = null;
        la0().a();
        this.f344771d = null;
        com.larus.bmhome.l0 r110 = this.f344779j;
        if (r110 == null) goto L22;
        r110.c();
    L22:
        this.f344779j = null;
    }

    public final boolean pa0() {
        return ((Boolean) this.O.getValue()).booleanValue();
    }

    public final k2 ra0() {
        return (k2) this.f344776h.getValue();
    }

    public final SideBarConfigModel sa0() {
        return (SideBarConfigModel) this.H.getValue();
    }

    public final cc9.a ta0() {
        return (cc9.a) this.f344795x.getValue();
    }

    public final int ua0() {
        GroupController r100 = this.f344780k;
        int r101 = 0;
        if (r100 == null) goto L22;
        Iterator r102 = ((ArrayList) r100.h()).iterator();
        int r103 = 0;
    L6:
        if (r102.hasNext() == false) goto L21;
        List<com.larus.home.impl.main.side_bar.data.j0> r104 = ((com.larus.home.impl.main.side_bar.view.group.render.g) r102.next()).f345627y;
        if ((r104 instanceof Collection) == true) goto L10;
    L12:
        Iterator<T> r105 = r104.iterator();
        int r106 = 0;
    L14:
        if (r105.hasNext() == false) goto L20;
        if (wa0((com.larus.home.impl.main.side_bar.data.j0) r105.next()) == false) goto L14;
        r106 = r106 + 1;
        if (r106 >= 0) goto L14;
        CollectionsKt.throwCountOverflow();
    L20:
        r103 = r103 + r106;
        goto L6
    L10:
        if (r104.isEmpty() == false) goto L12;
        r106 = 0;
        goto L20
    L21:
        Integer r107 = Integer.valueOf(r103);
    L23:
        if (r107 == null) goto L25;
        int r108 = r107.intValue();
    L44:
        SideBarConversationAdapter r109 = na0();
        if (r109 == null) goto L62;
        List<com.larus.home.impl.main.side_bar.data.j0> r110 = r109.getCurrentList();
        if (r110 == null) goto L62;
        List<com.larus.home.impl.main.side_bar.data.j0> r111 = r110;
        if ((r111 instanceof Collection) == true) goto L51;
    L53:
        Iterator<T> r112 = r111.iterator();
    L55:
        if (r112.hasNext() == false) goto L62;
        com.larus.home.impl.main.side_bar.data.j0 r113 = (com.larus.home.impl.main.side_bar.data.j0) r112.next();
        Intrinsics.checkNotNull(r113);
        if (wa0(r113) == false) goto L55;
        r101 = r101 + 1;
        if (r101 >= 0) goto L55;
        CollectionsKt.throwCountOverflow();
        goto L55
    L51:
        if (r111.isEmpty() == false) goto L53;
    L62:
        return r108 + r101;
    L25:
        SideBarConversationAdapter r114 = la0().f345103l;
        if (r114 == null) goto L43;
        List<com.larus.home.impl.main.side_bar.data.j0> r115 = r114.getCurrentList();
        if (r115 == null) goto L43;
        List<com.larus.home.impl.main.side_bar.data.j0> r116 = r115;
        if ((r116 instanceof Collection) == true) goto L32;
    L34:
        Iterator<T> r117 = r116.iterator();
        int r118 = 0;
    L36:
        if (r117.hasNext() == false) goto L42;
        com.larus.home.impl.main.side_bar.data.j0 r119 = (com.larus.home.impl.main.side_bar.data.j0) r117.next();
        Intrinsics.checkNotNull(r119);
        if (wa0(r119) == false) goto L36;
        r118 = r118 + 1;
        if (r118 >= 0) goto L36;
        CollectionsKt.throwCountOverflow();
        goto L36
    L42:
        r108 = r118;
        goto L44
    L32:
        if (r116.isEmpty() == false) goto L34;
    L43:
        r108 = 0;
        goto L44
    L22:
        r107 = null;
        goto L23
    }

    public final void ya0() {
        LarusFragmentSideBarContentBinding r100 = this.f344771d;
        String r101 = null;
        if (r100 == null) goto L7;
        LinearLayout r102 = r100.f344263k;
        if (r102 == null) goto L7;
        Object r103 = r102.getTag();
    L9:
        if ((r103 instanceof com.larus.home.impl.main.side_bar.data.l0) == false) goto L11;
        com.larus.home.impl.main.side_bar.data.l0 r104 = (com.larus.home.impl.main.side_bar.data.l0) r103;
    L12:
        cc9.a r105 = ta0();
        int r106 = da0();
        String r107 = r105.f23321a.getCurrentPage();
        String r108 = r105.f23321a.b();
        String r110 = r105.f23321a.getEnterMethod();
        if (r104 == null) goto L15;
        String r111 = r104.f344520a;
    L16:
        if (r104 == null) goto L18;
        r101 = r104.f344521b;
    L18:
        tx9.m2.b(null, null, r107, r108, r110, "direct_show", r111, Integer.valueOf(r106), r101, 0, "click_cell", null, null, null, null, null, null, null, null, null, false, false, null, null, null, 33552387);
        return;
    L15:
        r111 = null;
        goto L16
    L11:
        r104 = null;
    L7:
        r103 = null;
        goto L9
    }

    public final void za0() {
        LarusFragmentSideBarContentBinding r100 = this.f344771d;
        String r101 = null;
        if (r100 == null) goto L7;
        TextView r102 = r100.f344264l;
        if (r102 == null) goto L7;
        Object r103 = r102.getTag();
    L9:
        if ((r103 instanceof com.larus.home.impl.main.side_bar.data.l0) == false) goto L11;
        com.larus.home.impl.main.side_bar.data.l0 r104 = (com.larus.home.impl.main.side_bar.data.l0) r103;
    L12:
        cc9.a r105 = ta0();
        String r106 = r105.f23321a.getCurrentPage();
        String r107 = r105.f23321a.b();
        String r108 = r105.f23321a.getEnterMethod();
        if (r104 == null) goto L15;
        String r110 = r104.f344520a;
    L16:
        if (r104 == null) goto L18;
        r101 = r104.f344521b;
    L18:
        tx9.m2.b(null, null, r106, r107, r108, "direct_show", r110, 0, r101, 0, "click_cell", null, null, null, null, null, null, null, null, null, false, false, null, null, null, 33552387);
        i3.a(r105.f23321a.getCurrentPage(), r105.f23321a.b(), "navigation_sidebar_top", null, null, null, 114);
        return;
    L15:
        r110 = null;
        goto L16
    L11:
        r104 = null;
    L7:
        r103 = null;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r0v46, types: [com.larus.home.impl.main.side_bar.view.o] */
    /* JADX WARN: Type inference failed for: r0v51, types: [com.larus.home.impl.main.side_bar.view.SideBarContentFragment$humanFeedPortAccountCallback$1] */
    /* JADX WARN: Type inference failed for: r0v54, types: [com.larus.home.impl.main.side_bar.view.p] */
    /* JADX WARN: Type inference failed for: r0v55, types: [com.larus.home.impl.main.side_bar.view.s] */
    /* JADX WARN: Type inference failed for: r0v56, types: [com.larus.home.impl.main.side_bar.view.t] */
    /* JADX WARN: Type inference failed for: r0v57, types: [com.larus.home.impl.main.side_bar.view.u] */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.larus.home.impl.main.side_bar.view.group.datasource.lark.s] */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.larus.home.impl.main.side_bar.view.group.render.n0] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.home.impl.main.side_bar.view.group.datasource.lark.t] */
    public SideBarContentFragment() {
        this.f344776h = LazyKt.lazy(new q1(this));
        this.f344782l = LazyKt.lazy(new q());
        this.f344783m = -1;
        this.f344784n = -1;
        this.f344788q = LazyKt.lazy(new v(this));
        final Function0<Fragment> r100 = new SideBarContentFragment$special$$inlined$viewModels$default$1(this);
        this.f344789r = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ConversationModel.class), new SideBarContentFragment$special$$inlined$viewModels$default$2(r100), new SideBarContentFragment$special$$inlined$viewModels$default$3(r100, this));
        this.f344790s = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ConversationChangeModel.class), new SideBarContentFragment$special$$inlined$activityViewModels$default$1(this), new SideBarContentFragment$special$$inlined$activityViewModels$default$2(this));
        this.f344791t = LazyKt.lazy(new w(this));
        this.f344792u = LazyKt.lazy(new x(this));
        this.f344793v = new y(this);
        this.f344794w = LazyKt.lazy(new z(this));
        this.f344795x = LazyKt.lazy(new a0(this));
        this.f344796y = LazyKt.lazy(new b0());
        this.f344797z = LazyKt.lazy(new d0(this));
        this.D = LazyKt.lazy(new r1(this));
        this.G = LazyKt.lazy(new h());
        this.H = LazyKt.lazy(new i(this));
        this.K = LazyKt.lazy(new j());
        this.L = LazyKt.lazy(new k());
        this.M = LazyKt.lazy(new l(this));
        this.N = LazyKt.lazy(new m(this));
        this.O = LazyKt.lazy(new n(this));
        this.Q = qa0();
        this.R = z2.f365865a.getMultiTaskEntranceConfig().c();
        this.S = new AtomicBoolean(false);
        this.T = new o(this);
        int r101 = com.larus.home.impl.main.side_bar.view.group.datasource.lark.u.f345445f;
        Intrinsics.checkNotNullParameter(this, "host");
        this.V = new com.larus.home.impl.main.side_bar.view.group.datasource.lark.u(new com.larus.home.impl.main.side_bar.view.group.datasource.lark.s(this), new com.larus.home.impl.main.side_bar.view.group.datasource.lark.t());
        this.W = new com.larus.home.impl.main.side_bar.view.group.render.o0(new com.larus.home.impl.main.side_bar.view.group.render.n0());
        this.X = new SideBarContentFragment$humanFeedPortAccountCallback$1(this);
        UserSettingCacheManager.f313814a.getClass();
        this.Y = UserSettingCacheManager.i();
        this.Z = new p(this);
        this.f344781k0 = new s(this);
        this.f344787p0 = new t(this);
        this.H0 = new u(this);
        this.V0 = "notice_red_dot";
        this.f344777h1 = new b(this);
    }

    public final void Da0() {
        cc9.a r100 = ta0();
        int r101 = this.f344770b1;
        r100.getClass();
        if (r101 <= 0) goto L7;
        tx9.f2.b("notify", "number_dot", String.valueOf(r101), 24);
        return;
    }

    public final boolean Ga() {
        ActivityResultCaller r100 = getParentFragment();
        if ((r100 instanceof com.larus.bmhome.a0) == false) goto L5;
        com.larus.bmhome.a0 r101 = (com.larus.bmhome.a0) r100;
    L7:
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.Ga() != true) goto L13;
        return true;
    L13:
        return false;
    L5:
        r101 = null;
        goto L7
    }

    public final void Ga0() {
        Object r100 = null;
        boolean r101 = true;
        if (va0() == false) goto L104;
        SideBarConfigModel r102 = sa0();
        Triple<Integer, String, String> r103 = r102.A;
        if (r103 != null) goto L7;
    L9:
        boolean r104 = false;
    L10:
        if (r104 == false) goto L21;
        Triple<Integer, String, String> r105 = r102.A;
        if (r105 == null) goto L18;
        String r106 = r105.getThird();
        if (r106 == null) goto L18;
        Lazy r107 = ic8.n.f489237a;
        Intrinsics.checkNotNullParameter(r106, "<this>");
        if (com.larus.im.j.f(r106) != true) goto L18;
        boolean r108 = true;
    L19:
        if (r108 == false) goto L21;
        boolean r109 = true;
    L22:
        if (r109 == false) goto L76;
        LarusFragmentSideBarContentBinding r110 = this.f344771d;
        if (r110 == null) goto L72;
        RecyclerView r111 = r110.f344259g;
        if (r111 == null) goto L72;
        RecyclerView.LayoutManager r112 = r111.getLayoutManager();
        if ((r112 instanceof LinearLayoutManager) == false) goto L31;
        LinearLayoutManager r113 = (LinearLayoutManager) r112;
    L32:
        if (r113 == null) goto L72;
        ConcatAdapter r114 = this.f344774g;
        if (r114 != null) goto L38;
    L61:
        int r115 = -1;
    L63:
        if (r115 == (-1)) goto L72;
        int r116 = r113.findFirstVisibleItemPosition();
        int r117 = r113.findLastVisibleItemPosition();
        if (r116 == (-1)) goto L72;
        if (r117 == (-1)) goto L72;
        if (r115 < r116) goto L72;
        if (r115 > r117) goto L72;
        boolean r118 = false;
    L73:
        if (r118 == true) goto L76;
        boolean r119 = false;
    L77:
        LarusFragmentSideBarContentBinding r120 = this.f344771d;
        if (r120 == null) goto L87;
        SideBarFloatingButtonView r121 = r120.f344256d;
        if (r121 == null) goto L87;
        if (r121.getVisibility() != 0) goto L84;
        boolean r122 = true;
    L85:
        if (r122 != r119) goto L87;
    L88:
        if (r101 == true) goto L177;
        if (r119 == false) goto L97;
        LarusFragmentSideBarContentBinding r123 = this.f344771d;
        if (r123 == null) goto L96;
        SideBarFloatingButtonView r124 = r123.f344256d;
        if (r124 == null) goto L96;
        com.larus.utils.e1.x(r124);
    L96:
        n3.a("back_to_doubao", ta0().f23321a.getCurrentPage(), null, null, null, null, null, null, null, 2044);
        return;
    L97:
        LarusFragmentSideBarContentBinding r125 = this.f344771d;
        if (r125 == null) goto L175;
        SideBarFloatingButtonView r126 = r125.f344256d;
        if (r126 == null) goto L176;
        com.larus.utils.e1.o(r126);
        return;
    L176:
        return;
    L175:
        return;
    L177:
        return;
    L84:
        r122 = false;
    L87:
        r101 = false;
        goto L88
    L38:
        if (Intrinsics.areEqual(ia0(), "office") == false) goto L40;
        int r127 = ComponentTypeEnum.CONVERSATION_NEW_CONVERSATION_OFFICE.getType();
    L41:
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r128 = r114.getAdapters();
        ArrayList r129 = new ArrayList();
        Iterator<T> r130 = r128.iterator();
    L43:
        if (r130.hasNext() == false) goto L47;
        Object r131 = r130.next();
        if ((r131 instanceof SideBarComponentAdapter) == false) goto L43;
        r129.add(r131);
        goto L43
    L47:
        Iterator r132 = r129.iterator();
    L49:
        if (r132.hasNext() == false) goto L56;
        Object r133 = r132.next();
        if (((SideBarComponentAdapter) r133).getType() != r127) goto L53;
        boolean r134 = true;
    L54:
        if (r134 == false) goto L49;
        r100 = r133;
        goto L56
    L53:
        r134 = false;
    L56:
        SideBarComponentAdapter r135 = (SideBarComponentAdapter) r100;
        if (r135 == null) goto L61;
        if (r135.getItemCount() == 0) goto L61;
        r115 = ma0(r114, r135, 0);
        goto L63
    L40:
        r127 = ComponentTypeEnum.CONVERSATION_NEW_CONVERSATION_CHAT.getType();
        goto L41
    L31:
        r113 = null;
    L72:
        r118 = true;
    L76:
        r119 = true;
    L18:
        r108 = false;
    L21:
        r109 = false;
        goto L22
    L7:
        if (r103.getFirst().intValue() != 1) goto L9;
        r104 = true;
        goto L10
    L104:
        if (pa0() == true) goto L106;
    L108:
        boolean r136 = false;
    L109:
        if (r136 == false) goto L111;
    L138:
        boolean r137 = true;
    L139:
        LarusFragmentSideBarContentBinding r138 = this.f344771d;
        if (r138 == null) goto L149;
        SideBarFloatingButtonView r139 = r138.f344256d;
        if (r139 == null) goto L149;
        if (r139.getVisibility() != 0) goto L146;
        boolean r140 = true;
    L147:
        if (r140 != r137) goto L149;
    L150:
        if (r101 == true) goto L178;
        if (r137 == false) goto L158;
        LarusFragmentSideBarContentBinding r141 = this.f344771d;
        if (r141 == null) goto L157;
        SideBarFloatingButtonView r142 = r141.f344256d;
        if (r142 == null) goto L157;
        com.larus.utils.e1.x(r142);
    L157:
        n3.a("back_to_doubao", ta0().f23321a.getCurrentPage(), null, null, null, null, null, null, null, 2044);
        return;
    L158:
        LarusFragmentSideBarContentBinding r143 = this.f344771d;
        if (r143 == null) goto L180;
        SideBarFloatingButtonView r144 = r143.f344256d;
        if (r144 == null) goto L181;
        com.larus.utils.e1.o(r144);
        return;
    L181:
        return;
    L180:
        return;
    L178:
        return;
    L146:
        r140 = false;
    L149:
        r101 = false;
        goto L150
    L111:
        if (this.I == true) goto L138;
        SideBarConfigModel r145 = sa0();
        Triple<Integer, String, String> r146 = r145.A;
        if (r146 != null) goto L115;
    L117:
        boolean r147 = false;
    L118:
        if (r147 == false) goto L134;
        Triple<Integer, String, String> r148 = r145.A;
        if (r148 == null) goto L122;
        String r149 = r148.getThird();
    L123:
        if (r149 == null) goto L134;
        Triple<Integer, String, String> r150 = r145.A;
        if (r150 == null) goto L127;
        String r151 = r150.getThird();
    L128:
        wc9.e r152 = AuthModelDelegate.f297134b.y().getValue();
        if (r152 == null) goto L132;
        r100 = r152.f559198a;
    L132:
        if (Intrinsics.areEqual(r151, r100) == false) goto L134;
        boolean r153 = true;
    L135:
        if (r153 == false) goto L138;
        r137 = false;
        goto L139
    L127:
        r151 = null;
        goto L128
    L122:
        r149 = null;
    L134:
        r153 = false;
        goto L135
    L115:
        if (r146.getFirst().intValue() != 1) goto L117;
        r147 = true;
        goto L118
    L106:
        if (ka0() != ConversationArchiveFilter.Archived) goto L108;
        r136 = true;
        goto L109
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [android.content.BroadcastReceiver, com.larus.home.impl.main.side_bar.view.SideBarDayChangeWatcher$start$newReceiver$1] */
    public final void Ha0() {
        if (Ga() == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == false) goto L17;
        final w1 r101 = (w1) this.D.getValue();
        if (r101.f345826c != null) goto L22;
        ?? r102 = new SideBarDayChangeWatcher$start$newReceiver$1(r101);
        IntentFilter r103 = new IntentFilter();
        r103.addAction("android.intent.action.TIME_TICK");
        r103.addAction("android.intent.action.TIME_SET");
        r103.addAction("android.intent.action.TIMEZONE_CHANGED");
        ContextCompat.registerReceiver(r101.f345824a, r102, r103, "android.permission.WRITE_SETTINGS", null, 4);     // Catch: Exception -> L15
        r101.f345826c = r102;     // Catch: Exception -> L15
        FLogger.f375446a.i("SideBarDayChangeWatcher", "started");     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        FLogger.f375446a.e("SideBarDayChangeWatcher", "registerReceiver failed", e);
        return;
    L22:
        return;
    L17:
        ((w1) this.D.getValue()).a();
        return;
    L5:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L7;
        r100 = true;
        goto L8
    }

    @Override // eb9.y
    public final boolean Hz() {
        sa0().getClass();
        SideBarRepo.f344467a.getClass();
        return SideBarRepo.c().f344496d;
    }

    public final void PU() {
        ChatFragment r100 = com.larus.home.impl.utils.b.b(getActivity());
        com.larus.bmhome.a0 r101 = null;
        if (r100 == null) goto L5;
        com.larus.bmhome.chat.mode.e r102 = (com.larus.bmhome.chat.mode.e) s1a.a.g(r100).getAbility(com.larus.bmhome.chat.mode.e.class);
    L6:
        if (r100 == null) goto L8;
        com.larus.bmhome.chat.component.trace.z r103 = (com.larus.bmhome.chat.component.trace.z) s1a.a.g(r100).getAbility(com.larus.bmhome.chat.component.trace.z.class);
    L10:
        if (r102 != null) goto L12;
    L14:
        boolean r104 = false;
    L15:
        if (r104 == false) goto L29;
        wc9.e r105 = AuthModelDelegate.f297134b.y().getValue();
        if (r105 == null) goto L23;
        LifecycleOwner r106 = getViewLifecycleOwnerLiveData().getValue();
        if (r106 == null) goto L23;
        LifecycleCoroutineScope r107 = LifecycleOwnerKt.getLifecycleScope(r106);
        if (r107 == null) goto L23;
        BuildersKt.launch$default(r107, null, null, new SideBarContentFragment$startCreateConversation$1$1(r105, r103, null), 3, null);
    L23:
        ActivityResultCaller r108 = getParentFragment();
        if ((r108 instanceof com.larus.bmhome.a0) == false) goto L26;
        r101 = (com.larus.bmhome.a0) r108;
    L26:
        if (r101 == null) goto L37;
        r101.v7(true);
        return;
    L37:
        return;
    L29:
        wc9.e r109 = AuthModelDelegate.f297134b.y().getValue();
        if (r109 == null) goto L38;
        String r110 = r109.f559198a;
        LifecycleOwner r111 = getViewLifecycleOwnerLiveData().getValue();
        if (r111 == null) goto L39;
        LifecycleCoroutineScope r112 = LifecycleOwnerKt.getLifecycleScope(r111);
        if (r112 == null) goto L40;
        BuildersKt.launch$default(r112, null, null, new SideBarContentFragment$startCreateConversation$2$1$1(r110, this, r109, null), 3, null);
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L12:
        if (r102.Xf(null) != true) goto L14;
        r104 = true;
        goto L15
    L8:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // eb9.y
    public final Map<String, String> R4() {
        return J0();
    }

    public final void W90() {
        boolean r100 = Intrinsics.areEqual(ia0(), "office");
        hq9.a0 r101 = z2.f365865a.getBasicExperienceFeatureConfig();
        LarusFragmentSideBarContentBinding r102 = this.f344771d;
        if (r102 == null) goto L12;
        SideBarFloatingButtonView r103 = r102.f344256d;
        if (r103 == null) goto L13;
        int r104 = com.larus.bmhome.utils.t.a();
        if (r100 == false) goto L9;
        int r105 = R.string.larus_infra_sidebar_button_newWorkTask;
    L10:
        boolean r106 = r101.f486525c;
        ImageLoaderKt.b(r103.f344831e);
        r103.f344831e.setActualImageResource(r104);
        r103.f344832f.setText(r105);
        r103.f344833g = SideBarFloatingButtonView.Presentation.NEW_CONVERSATION;
        r103.f344834h = r106;
        r103.c();
        return;
    L9:
        r105 = R.string.larus_new_chat_button;
        goto L10
    L13:
        return;
    }

    @Override // com.larus.home.impl.main.side_bar.view.b
    public final String b() {
        ActivityResultCaller r100 = getParentFragment();
        if ((r100 instanceof com.larus.bmhome.a0) == false) goto L5;
        com.larus.bmhome.a0 r101 = (com.larus.bmhome.a0) r100;
    L6:
        if (r101 == null) goto L9;
        String r102 = r101.L1();
        if (r102 == null) goto L9;
        return r102;
    L9:
        return "";
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.home.impl.main.side_bar.view.b
    public final boolean bH() {
        return fa0();
    }

    @Override // com.larus.home.impl.main.side_bar.view.b
    public final String getCurrentPage() {
        ActivityResultCaller r100 = getParentFragment();
        if ((r100 instanceof com.larus.bmhome.a0) == false) goto L5;
        com.larus.bmhome.a0 r101 = (com.larus.bmhome.a0) r100;
    L6:
        if (r101 == null) goto L9;
        String r102 = r101.k();
        if (r102 == null) goto L9;
        return r102;
    L9:
        return "";
    L5:
        r101 = null;
        goto L6
    }

    public final ConversationArchiveFilter ka0() {
        if (fa0() == false) goto L6;
        sa0().getClass();
        SideBarRepo.f344467a.getClass();
        return SideBarRepo.c().f344495c;
    L6:
        return ConversationArchiveFilter.Active;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        com.larus.bmhome.l0 r100 = this.f344779j;
        if (r100 == null) goto L5;
        r100.c();
    L5:
        this.f344779j = null;
        z2.f365865a.p3(this.T);
        FLogger.f375446a.i("SideBarContentFragment", "onDestroy " + this);
        ja0().b();
        FlatConversationContainer r101 = la0();
        r101.f345109r = false;
        if (r101.f345110s == false) goto L9;
        r101.c();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        Ha0();
        FLogger.f375446a.i("SideBarContentFragment", "onPause " + this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (va0() == false) goto L5;
        W90();
    L8:
        Ga0();
        if (la0().f345101j == true) goto L11;
        ja0().g(ua0());
    L11:
        GroupController r100 = this.f344780k;
        if (r100 == null) goto L14;
        r100.k();
    L14:
        Ha0();
        FLogger.f375446a.i("SideBarContentFragment", "onResume " + this);
        return;
    L5:
        Ja0();
        wc9.e r101 = AuthModelDelegate.f297134b.y().getValue();
        if (r101 == null) goto L8;
        t10(r101.f559199b);
        mL(tr8.b.a(r101));
        goto L8
    }

    @Override // com.larus.home.impl.main.side_bar.view.c
    public final void qI() {
        if (sa0().B == true) goto L6;
        FLogger.f375446a.i("SideBarConfigModel", "load more conversation");
        ConversationListModel.f307444a.d("SideBarLoadMore");
        return;
    }

    public static List Z90(List r100) {
        boolean r101 = true;
        if (((ArrayList) r100).size() == 1) goto L6;
        r101 = false;
    L6:
        if (r101 == true) goto L8;
        return r100;
    L8:
        if (((com.larus.home.impl.main.side_bar.data.j0) ListProtector.get(r100, 0)).f344506a != SideBarItemType.CONVERSATION) goto L10;
        return r100;
    L10:
        return CollectionsKt.emptyList();
    }

    public static boolean wa0(com.larus.home.impl.main.side_bar.data.j0 r100) {
        wh8.a r101 = r100.f344507b;
        if (r101 == null) goto L9;
        wc9.e r102 = r101.f559708a;
        if (r102 != null) goto L8;
        return false;
    L8:
        return !ic8.n.r(r102);
    L9:
        return false;
    }

    public final void Aa0(boolean r410) {
        FLogger.f375446a.i("SideBarContentFragment", "onSideBarOpen " + this + " isClick=" + r410);
        Ja0();
        this.A = r410;
        SideBarPcAvatarController r100 = this.E;
        if (r100 == null) goto L5;
        r100.b();
    L5:
        GroupController r101 = this.f344780k;
        if (r101 == null) goto L8;
        r101.k();
    L8:
        Ha0();
        GroupController r102 = this.f344780k;
        if (r102 == null) goto L11;
        r102.d();
    L11:
        cc9.a r103 = ta0();
        long r104 = sa0().f344438i;
        tx9.m2.c(r103.f23321a.getCurrentPage(), r103.f23321a.getEnterMethod(), "navigation_sidebar", 24);
        gx8.b r105 = a2.f344858b.f483123a;
        a2.a r106 = (a2.a) a2.f344859c.getValue();
        JSONObject r107 = new JSONObject();
        r107.put("update_time", r104);
        Unit r108 = Unit.INSTANCE;
        r105.b(r106, r107);
        LarusFragmentSideBarContentBinding r109 = this.f344771d;
        if (r109 == null) goto L16;
        ConstraintLayout r110 = r109.f344253a;
        if (r110 == null) goto L16;
        r110.postDelayed(new g1(this), 1000);
    L16:
        LarusFragmentSideBarContentBinding r111 = this.f344771d;
        if (r111 == null) goto L26;
        TextView r112 = r111.f344264l;
        if (r112 == null) goto L26;
        if (r112.getVisibility() != 0) goto L23;
        boolean r113 = true;
    L24:
        if (r113 != true) goto L26;
        boolean r114 = true;
    L28:
        if (r114 == false) goto L47;
        LarusFragmentSideBarContentBinding r115 = this.f344771d;
        if (r115 == null) goto L34;
        TextView r116 = r115.f344264l;
        if (r116 == null) goto L34;
        Object r117 = r116.getTag();
    L36:
        if ((r117 instanceof com.larus.home.impl.main.side_bar.data.l0) == false) goto L38;
        com.larus.home.impl.main.side_bar.data.l0 r118 = (com.larus.home.impl.main.side_bar.data.l0) r117;
    L39:
        cc9.a r119 = ta0();
        String r120 = r119.f23321a.getCurrentPage();
        String r121 = r119.f23321a.b();
        String r122 = r119.f23321a.getEnterMethod();
        if (r118 == null) goto L42;
        String r123 = r118.f344520a;
    L43:
        if (r118 == null) goto L45;
        String r124 = r118.f344521b;
    L46:
        tx9.m2.a(r120, r121, r122, "direct_show", r123, 0, r124, 0, null, null, null, null, null, null, null, null, false, false, null, 4194048);
        i3.b(r119.f23321a.getCurrentPage(), null, r119.f23321a.b(), "default", "chat_search", "all", null, null, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY);
        goto L47
    L45:
        r124 = null;
        goto L46
    L42:
        r123 = null;
        goto L43
    L38:
        r118 = null;
    L34:
        r117 = null;
    L47:
        LarusFragmentSideBarContentBinding r125 = this.f344771d;
        if (r125 == null) goto L57;
        LinearLayout r126 = r125.f344263k;
        if (r126 == null) goto L57;
        if (r126.getVisibility() != 0) goto L54;
        boolean r127 = true;
        boolean r128 = true;
    L55:
        if (r128 != r127) goto L58;
        boolean r129 = true;
    L59:
        if (r129 == false) goto L79;
        LarusFragmentSideBarContentBinding r130 = this.f344771d;
        if (r130 == null) goto L65;
        LinearLayout r131 = r130.f344263k;
        if (r131 == null) goto L65;
        Object r132 = r131.getTag();
    L67:
        if ((r132 instanceof com.larus.home.impl.main.side_bar.data.l0) == false) goto L69;
        com.larus.home.impl.main.side_bar.data.l0 r133 = (com.larus.home.impl.main.side_bar.data.l0) r132;
    L70:
        cc9.a r134 = ta0();
        int r135 = da0();
        String r210 = r134.f23321a.getCurrentPage();
        String r211 = r134.f23321a.b();
        String r212 = r134.f23321a.getEnterMethod();
        if (r133 == null) goto L73;
        String r213 = r133.f344520a;
    L74:
        Integer r214 = Integer.valueOf(r135);
        if (r133 == null) goto L77;
        String r310 = r133.f344521b;
    L78:
        tx9.m2.a(r210, r211, r212, "direct_show", r213, r214, r310, 0, null, null, null, null, null, null, null, null, false, false, null, 4194048);
        goto L79
    L77:
        r310 = null;
        goto L78
    L73:
        r213 = null;
        goto L74
    L69:
        r133 = null;
    L65:
        r132 = null;
    L79:
        LarusFragmentSideBarContentBinding r136 = this.f344771d;
        if (r136 == null) goto L89;
        LinearLayout r137 = r136.f344254b;
        if (r137 == null) goto L89;
        if (r137.getVisibility() != 0) goto L86;
        boolean r138 = true;
    L87:
        if (r138 != r127) goto L89;
        boolean r139 = true;
    L90:
        if (r139 == false) goto L124;
        LarusFragmentSideBarContentBinding r140 = this.f344771d;
        if (r140 == null) goto L124;
        LinearLayout r141 = r140.f344254b;
        if (r141 == null) goto L124;
        int r142 = r141.getChildCount();
        int r143 = 0;
    L96:
        if (r143 >= r142) goto L124;
        View r144 = r141.getChildAt(r143);
        Object r145 = r144.getTag();
        if ((r145 instanceof com.larus.home.impl.main.side_bar.data.l0) == false) goto L100;
        com.larus.home.impl.main.side_bar.data.l0 r146 = (com.larus.home.impl.main.side_bar.data.l0) r145;
    L101:
        Pair<Integer, String> r147 = ca0(r144);
        String r311 = r147.getSecond();
        Integer r312 = r147.getFirst();
        cc9.a r148 = ta0();
        int r149 = da0();
        LarusFragmentSideBarContentBinding r150 = this.f344771d;
        if (r150 == null) goto L111;
        LinearLayout r151 = r150.f344263k;
        if (r151 == null) goto L111;
        if (r151.getVisibility() != 0) goto L108;
        boolean r152 = true;
    L109:
        if (r152 != r127) goto L111;
        boolean r153 = true;
    L112:
        if (r153 == false) goto L114;
        int r154 = r143 + 1;
    L115:
        String r215 = r148.f23321a.getCurrentPage();
        String r216 = r148.f23321a.b();
        String r217 = r148.f23321a.getEnterMethod();
        if (r146 == null) goto L118;
        String r218 = r146.f344520a;
    L119:
        Integer r219 = Integer.valueOf(r149);
        if (r146 == null) goto L122;
        String r313 = r146.f344521b;
    L123:
        tx9.m2.a(r215, r216, r217, "direct_show", r218, r219, r313, Integer.valueOf(r154), null, null, null, r312, r311, null, null, null, false, false, null, 4169472);
        r143 = r143 + 1;
        goto L96
    L122:
        r313 = null;
        goto L123
    L118:
        r218 = null;
        goto L119
    L114:
        r154 = r143;
        goto L115
    L108:
        r152 = false;
    L111:
        r153 = false;
        goto L112
    L100:
        r146 = null;
    L124:
        d r155 = this.f344778i;
        if (r155 == null) goto L129;
        Function0<Unit> r156 = r155.f345073b;
        if (r156 == null) goto L129;
        r156.invoke();
    L129:
        GroupController r157 = this.f344780k;
        if (r157 == null) goto L137;
        Iterator<T> r158 = r157.f345123e.iterator();
    L133:
        if (r158.hasNext() == false) goto L137;
        GroupHeaderAdapter r159 = ((com.larus.home.impl.main.side_bar.view.group.module.y) r158.next()).f345552b;
        r159.f345585g = false;
        if (r159.f345586h <= 0) goto L133;
        r159.f345585g = r127;
        r159.f345580b.f345735f.invoke();
    L137:
        LarusFragmentSideBarContentBinding r160 = this.f344771d;
        if (r160 == null) goto L147;
        RecyclerView r161 = r160.f344259g;
        if (r161 == null) goto L147;
        if (r161.getVisibility() != 0) goto L144;
        boolean r162 = true;
    L145:
        if (r162 != r127) goto L147;
        boolean r163 = true;
    L148:
        if (r163 == false) goto L159;
        ConcatAdapter r164 = this.f344774g;
        if (r164 == null) goto L152;
        int r165 = r164.getItemCount();
    L153:
        if (r165 <= 0) goto L159;
        d r166 = this.f344778i;
        if (r166 == null) goto L159;
        Function0<Unit> r167 = r166.f345072a;
        if (r167 == null) goto L159;
        r167.invoke();
        goto L159
    L152:
        r165 = 0;
    L159:
        Da0();
        int r168 = jo8.d.f499918a;
        buc.a r169 = com.larus.im.internal.delegate.u0.f348263d;
        if (r169.c() == false) goto L163;
    L170:
        boolean r170 = false;
    L172:
        if (r170 == false) goto L183;
        FLogger.f375446a.i("RePullRecentTip", "show recent cvs warning");
        Application r171 = AppHost.f326268a.getApplication();
        String r172 = r171.getResources().getString(R.string.larus_trafficDegradation_chatListLoading_cn);
        t19.s.f544207a.getClass();
        t19.s.t(r171, r172);
        return;
    L183:
        return;
    L163:
        if (com.larus.im.internal.delegate.u0.f348262c.c() == false) goto L170;
        if (ConversationLocalManager.INSTANCE.getConversationVersion() != 0) goto L170;
        if (Intrinsics.areEqual(com.larus.im.internal.delegate.c1.f348202a.a(com.larus.im.internal.delegate.b.f348193b.getUserId() + "_imsdk_is_new_user", "", "omni_im_default_repo"), "0") == false) goto L170;
        com.larus.im.internal.delegate.a.f348188b.i("FlowRePullRecentHandler", "show recent cvs warning");
        r169.d(r127);
        r170 = true;
        goto L172
    L144:
        r162 = false;
    L147:
        r163 = false;
        goto L148
    L86:
        r138 = false;
    L89:
        r139 = false;
    L58:
        r129 = false;
        goto L59
    L54:
        r127 = true;
        r128 = false;
    L57:
        r127 = true;
        goto L58
    L23:
        r113 = false;
    L26:
        r114 = false;
        goto L28
    }

    public final void Ba0(com.larus.home.impl.main.side_bar.data.p r100) {
        LarkSocialExp.f365340a.getClass();
        if (LarkSocialExp.f() == false) goto L5;
        com.bytedance.router.i r101 = SmartRouter.buildRoute(getContext(), "//flow/aggregate_search");
        r101.f267554c.putExtra("enter_method", "click_navigation_cell");
        String r102 = getCurrentPage();
        r101.f267554c.putExtra("previous_page", r102);
        r101.f267554c.putExtra("enable_fade_transition", true);
        r101.f267555d = R.anim.larus_fade_in;
        r101.f267556e = R.anim.larus_router_no_anim;
        r101.d();
        za0();
        return;
    L5:
        String r103 = com.larus.home.impl.main.side_bar.data.q.f(r100);
        if (r103 == null) goto L10;
        SmartRouter.buildRoute(getContext(), com.larus.utils.y0.b(com.larus.utils.y0.c(r103, "enter_method", "click_navigation_cell"), "previous_page", getCurrentPage()).toString()).d();
        za0();
        return;
    }

    @Override // com.larus.home.impl.main.side_bar.view.f
    public final void FR(List<com.larus.home.impl.main.side_bar.data.p> r110) {
        int r100 = this.f344772e + 1;
        this.f344772e = r100;
        ConcatAdapter r101 = this.f344774g;
        GroupController r102 = this.f344780k;
        int r103 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        StringBuilder r104 = new StringBuilder("fragment=");
        r104.append(com.larus.home.impl.main.side_bar.feed.arch.t.e(this));
        r104.append(" gen=");
        r104.append(r100);
        r104.append(" components=");
        if (r110 == null) goto L5;
        int r105 = r110.size();
    L6:
        r104.append(r105);
        r104.append(" oldRoot=");
        r104.append(com.larus.home.impl.main.side_bar.feed.arch.t.e(r101));
        r104.append(" oldController=");
        r104.append(com.larus.home.impl.main.side_bar.feed.arch.t.e(r102));
        r104.append(" drawerOpen=");
        r104.append(Ga());
        com.larus.home.impl.main.side_bar.feed.arch.t.c("root_rebuild_request", r104.toString());
        Job r106 = this.f344786p;
        if (r106 == null) goto L9;
        Job.DefaultImpls.cancel$default(r106, null, 1, null);
    L9:
        LifecycleOwner r107 = getViewLifecycleOwnerLiveData().getValue();
        if (r107 == null) goto L16;
        LifecycleCoroutineScope r108 = LifecycleOwnerKt.getLifecycleScope(r107);
        if (r108 == null) goto L16;
        this.f344786p = BuildersKt.launch$default(r108, Dispatchers.getMain(), null, new SideBarContentFragment$onMiddleAllChanged$1(this, r100, r110, r108, null), 2, null);
        return;
    L16:
        com.larus.home.impl.main.side_bar.feed.arch.t.c("root_rebuild_skip", "fragment=" + com.larus.home.impl.main.side_bar.feed.arch.t.e(this) + " gen=" + r100 + " reason=no_view_lifecycle");
        return;
    L5:
        r105 = 0;
        goto L6
    }

    public final void Fa0(String r100) {
        LarusFragmentSideBarContentBinding r101 = this.f344771d;
        if (r101 == null) goto L14;
        RecyclerView r102 = r101.f344259g;
        if (r102 == null) goto L16;
        ConcatAdapter r103 = this.f344774g;
        if (r103 != null) goto L11;
        return;
    L11:
        if (r102.getAdapter() != r103) goto L15;
        com.larus.home.impl.main.side_bar.feed.arch.j.a(r102, r100);
        return;
    L15:
        return;
    L16:
        return;
    }

    @Override // com.larus.home.impl.main.side_bar.view.b
    public final void IO(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        SideBarPcAvatarController r101 = this.E;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "owner");
        r101.f344847h.remove(r100);
        return;
    }

    public final void Ia0(boolean r100) {
        LifecycleOwner r101 = getViewLifecycleOwnerLiveData().getValue();
        if (r101 == null) goto L7;
        Lifecycle r102 = r101.getLifecycle();
        if (r102 == null) goto L7;
        Lifecycle.State r103 = r102.getCurrentState();
    L8:
        if (r103 == null) goto L12;
        boolean r104 = true;
        if (r103.isAtLeast(Lifecycle.State.INITIALIZED) != true) goto L12;
    L13:
        if (r104 == true) goto L19;
        com.larus.bmhome.l0 r105 = this.f344779j;
        if (r105 == null) goto L17;
        r105.c();
    L17:
        this.f344779j = null;
        return;
    L19:
        if (r100 == true) goto L21;
        com.larus.bmhome.l0 r106 = this.f344779j;
        if (r106 == null) goto L26;
        r106.c();
    L26:
        this.f344779j = null;
        return;
    L21:
        if (this.f344779j != null) goto L28;
        com.larus.bmhome.l0 r107 = new com.larus.bmhome.l0(this);
        Object r108 = xp9.o.f564776a;
        xp9.o.a(r107.f312461f);
        this.f344779j = r107;
        return;
    L28:
        return;
    L12:
        r104 = false;
    L7:
        r103 = null;
        goto L8
    }

    public final void Ka0(ConversationArchiveFilter r100) {
        if (fa0() == true) goto L5;
        return;
    L5:
        if (ka0() == r100) goto L16;
        int r101 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.c("archive_filter_change", "fragment=" + com.larus.home.impl.main.side_bar.feed.arch.t.e(this) + " from=" + ka0() + " to=" + r100);
        SideBarConfigModel r102 = sa0();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "filter");
        SideBarRepo.f344467a.getClass();
        com.larus.home.impl.main.side_bar.data.e r103 = SideBarRepo.c();
        if (r103.f344495c == r100) goto L13;
        SideBarRepo.l(r103.f344493a, r103.f344494b, r100, r103.f344496d, true);
        f r104 = r102.f344431b;
        if (r104 == null) goto L13;
        r104.L20();
    L13:
        Ga0();
        return;
    }

    @Override // com.larus.home.impl.main.side_bar.view.f
    public final void Lt(com.larus.home.impl.main.side_bar.data.p r100) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new SideBarContentFragment$onBottomChanged$1(this, r100, null), 2, null);
    }

    public final void Ma0(String r100) {
        this.P0 = r100;
        LarusFragmentSideBarContentBinding r101 = this.f344771d;
        if (r101 != null) goto L5;
        return;
    L5:
        ICommerceMembershipService.f325827a.getClass();
        ICommerceMembershipService r102 = ICommerceMembershipService.a.a();
        String r103 = null;
        if (r102 == null) goto L8;
        uz8.f r104 = r102.y();
    L9:
        boolean r105 = false;
        if (r104 == null) goto L12;
        boolean r106 = Intrinsics.areEqual(r104.showMembershipName, Boolean.TRUE);
    L14:
        if (r100 != null) goto L16;
    L19:
        boolean r107 = true;
    L20:
        if (r107 == true) goto L24;
        e10 r108 = e10.f368561a;
        if (e10.l0().b() == true) goto L24;
        r105 = true;
    L24:
        IMultiAccountProfileService r109 = (IMultiAccountProfileService) this.K.getValue();
        if (r109 == null) goto L34;
        if (r105 == true) goto L29;
        r100 = null;
    L29:
        Boolean r110 = Boolean.valueOf(r106);
        if (r104 == null) goto L32;
        r103 = r104.membershipDisplayName;
    L32:
        r103 = r109.a(r100, r110, r103, 2);
    L34:
        if (com.larus.utils.o0.d(r103) == false) goto L36;
        r101.f344269q.setText(r103);
        com.larus.utils.e1.x(r101.f344269q);
        return;
    L36:
        com.larus.utils.e1.o(r101.f344269q);
        return;
    L16:
        if (StringsKt.isBlank(r100) == true) goto L19;
        r107 = false;
        goto L20
    L12:
        r106 = false;
        goto L14
    L8:
        r104 = null;
        goto L9
    }

    @Override // com.larus.home.impl.main.side_bar.view.f
    public final void P10(List<com.larus.home.impl.main.side_bar.data.p> r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        ConcatAdapter r100 = this.f344774g;
        if (r100 == null) goto L53;
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r101 = r100.getAdapters();
        if (r101 == null) goto L53;
        Iterator<T> r102 = r101.iterator();
        int r103 = 0;
    L10:
        if (r102.hasNext() == false) goto L53;
        Object r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        RecyclerView.Adapter r106 = (RecyclerView.Adapter) r104;
        if ((r106 instanceof SideBarComponentAdapter) == false) goto L51;
        SideBarComponentAdapter r107 = (SideBarComponentAdapter) r106;
        String r108 = r107.f344891j;
        Object r109 = null;
        if (r108 != null) goto L19;
    L33:
        Iterator<T> r111 = r110.iterator();
        Object r112 = null;
        boolean r113 = false;
    L35:
        if (r111.hasNext() == false) goto L44;
        Object r114 = r111.next();
        if (((com.larus.home.impl.main.side_bar.data.p) r114).getType() != r107.getType()) goto L39;
        boolean r115 = true;
    L40:
        if (r115 == false) goto L35;
        if (r113 == true) goto L47;
        r112 = r114;
        r113 = true;
    L47:
        com.larus.home.impl.main.side_bar.data.p r116 = (com.larus.home.impl.main.side_bar.data.p) r109;
        if (r116 == null) goto L51;
    L50:
        r107.F2(sa0().o(r116, true), sa0().o(r116, false));
        goto L51
    L39:
        r115 = false;
        goto L40
    L44:
        if (r113 == false) goto L47;
        r109 = r112;
        goto L47
    L19:
        if ((!StringsKt.isBlank(r108)) == true) goto L22;
        r108 = null;
    L22:
        if (r108 == null) goto L33;
        Iterator<T> r117 = r110.iterator();
    L25:
        if (r117.hasNext() == false) goto L29;
        Object r118 = r117.next();
        if (Intrinsics.areEqual(((com.larus.home.impl.main.side_bar.data.p) r118).h(), r108) == false) goto L25;
    L30:
        r116 = (com.larus.home.impl.main.side_bar.data.p) r118;
        if (r116 == null) goto L33;
    L29:
        r118 = null;
    L51:
        r103 = r105;
    L53:
        if (va0() == false) goto L69;
        Ga0();
        return;
    }

    @Override // com.larus.home.impl.main.side_bar.view.f
    public final void Uz(List<com.larus.home.impl.main.side_bar.data.j0> r100) {
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("onMiddleCaseListChanged foldSize=");
        Integer r103 = null;
        if (r100 == null) goto L5;
        Integer r104 = Integer.valueOf(r100.size());
    L6:
        r102.append(r104);
        r102.append(" unfoldSize=");
        if (r100 == null) goto L9;
        Integer r105 = Integer.valueOf(r100.size());
    L10:
        r102.append(r105);
        r102.append(" caseAdapter=");
        SideBarCaseAdapter r106 = ea0();
        if (r106 == null) goto L13;
        r103 = Integer.valueOf(r106.hashCode());
    L13:
        r102.append(r103);
        r101.i("SideBarContentFragment", r102.toString());
        SideBarCaseAdapter r107 = ea0();
        if (r107 == null) goto L17;
        r107.F2(r100, r100);
        return;
    L17:
        return;
    L9:
        r105 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.larus.home.impl.main.side_bar.view.b
    public final Integer Xg(wc9.e r100) {
        SideBarPcAvatarController r101 = this.E;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.a(r100);
    }

    @Override // com.larus.home.impl.main.side_bar.view.b
    public final void Zq(eb9.o<?> r100) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        eb9.n r101 = r100.f471910d;
        if (r101 != null) goto L5;
        return;
    L5:
        Integer r102 = r101.f471905c;
        if (r102 == null) goto L8;
        int r103 = r102.intValue();
    L11:
        String r104 = r101.f471904b;
        String r105 = r101.f471906d;
        if (r105 != null) goto L14;
        r105 = "unknown";
    L14:
        J90(r103, null, r104, r105);
        return;
    L8:
        int r106 = qb9.a.f532418a;
        Intrinsics.checkNotNullParameter(r101, "selectionKey");
        if (Intrinsics.areEqual(r101.f471903a, "side_bar_conversation") == false) goto L16;
        r103 = 1;
        goto L11
    L16:
        FLogger.f375446a.w("SideBarContentFragment", "ignore Feed selection without page selectionKey=" + r101);
    }

    public final int ba0(int r100) {
        LarusFragmentSideBarContentBinding r101 = this.f344771d;
        boolean r102 = false;
        if (r101 == null) goto L12;
        TextView r103 = r101.f344264l;
        if (r103 == null) goto L12;
        if (r103.getVisibility() != 0) goto L9;
        boolean r104 = true;
    L10:
        if (r104 != true) goto L12;
        r102 = true;
        goto L12
    L9:
        r104 = false;
    L12:
        if (r102 == true) goto L14;
        return r100;
    L14:
        return r100 + 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Pair<Integer, String> ca0(View r100) {
        ta0().getClass();
        Intrinsics.checkNotNullParameter(r100, "view");
        Object r101 = null;
        RedDotTextView r102 = (RedDotTextView) r100.findViewById(R.id.red_dot);     // Catch: Exception -> L16
        Intrinsics.checkNotNull(r102);     // Catch: Exception -> L16
        if (r102.getVisibility() != 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == true) goto L9;
    L15:
        Object r104 = null;
    L21:
        return new Pair(r101, r104);
    L9:
        if ((!StringsKt.isBlank(r102.getText())) == false) goto L15;
        Integer r105 = Integer.valueOf(CastIntegerProtector.parseInt(r102.getText().toString()));     // Catch: Exception -> L16
        r101 = "number_dot";
    L19:
        Object r106 = r101;
        r101 = r105;
        r104 = r106;
        goto L21
    L6:
        r103 = false;
    L16:
        e = move-exception;
        r105 = null;
        FLogger.f375446a.e("SideBarContentFragment", "onBottomActionShowMob unwrap notice e=" + e.getMessage());
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e);
        goto L19
    }

    @Override // com.larus.home.impl.main.side_bar.view.b
    public final boolean dw(String r100) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        CoroutineScope r101 = com.larus.bmhome.chat.helper.f0.f303099a;
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        return com.larus.bmhome.chat.helper.f0.f303101c.contains(r100);
    }

    @Override // com.larus.home.impl.main.side_bar.view.b
    public final void m50(wh8.a r110) {
        Intrinsics.checkNotNullParameter(r110, "conversationData");
        final wc9.e r100 = r110.f559708a;
        if (r100 == null) goto L10;
        com.larus.bmhome.chat.helper.d0 r101 = com.larus.bmhome.chat.helper.d0.f303086a;
        Context r102 = getContext();
        String r103 = getCurrentPage();
        BotModel r104 = r110.f559709b;
        if (r104 == null) goto L7;
        String r105 = r104.getBotId();
    L8:
        String r106 = r105;
        int r107 = ChatListScreenMenuManager.f306626a;
        r101.a(r102, r100, r103, "context_menu", r106, ChatListScreenMenuManager.g(r110), null, new n1(this, r100));
        return;
    L7:
        r105 = null;
        goto L8
    }

    @Override // com.larus.home.impl.main.side_bar.view.f
    public final void mL(String r100) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new SideBarContentFragment$onBackDoubaoChanged$2(this, r100, null), 2, null);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        if (va0() == false) goto L6;
        Ja0();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        FLogger.f375446a.i("SideBarContentFragment", "onCreate " + this);
        z2.f365865a.i2(this.T);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new AnonymousClass1(this, null), 2, null);
        ja0().d(LifecycleOwnerKt.getLifecycleScope(this));
        FlatConversationContainer r101 = la0();
        r101.f345109r = true;
        r101.i();
    }

    @Override // com.larus.home.impl.main.side_bar.view.f
    public final void pO(List<com.larus.home.impl.main.side_bar.data.p> r100) {
        if (r100.isEmpty() == false) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new SideBarContentFragment$onMiddleContainerChildrenChanged$1(this, r100, null), 2, null);
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.larus.home.impl.main.side_bar.view.f
    public final void t10(IconImage r100) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new SideBarContentFragment$onBackDoubaoChanged$1(this, r100, null), 2, null);
    }

    @Override // com.larus.home.impl.main.side_bar.view.f
    public final void v70(com.larus.home.impl.main.side_bar.data.p r100) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new SideBarContentFragment$onTopChanged$1(this, r100, null), 2, null);
    }

    public static final void U90(SideBarContentFragment r110, String r111) {
        ConcatAdapter r100 = r110.f344774g;
        if (r100 == null) goto L7;
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r101 = r100.getAdapters();
        if (r101 == null) goto L7;
        String r102 = CollectionsKt.joinToString$default(r101, " -> ", null, null, 0, null, new f0(), 30, null);
    L8:
        int r103 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        StringBuilder r104 = new StringBuilder("fragment=");
        r104.append(com.larus.home.impl.main.side_bar.feed.arch.t.e(r110));
        r104.append(" root=");
        r104.append(com.larus.home.impl.main.side_bar.feed.arch.t.e(r100));
        r104.append(" reason=");
        r104.append(r111);
        r104.append(" children=");
        int r112 = 0;
        if (r100 == null) goto L13;
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r113 = r100.getAdapters();
        if (r113 == null) goto L13;
        int r114 = r113.size();
    L14:
        r104.append(r114);
        r104.append(" items=");
        if (r100 == null) goto L17;
        r112 = r100.getItemCount();
    L17:
        r104.append(r112);
        r104.append(", middleAdapterOrder=");
        r104.append(r102);
        com.larus.home.impl.main.side_bar.feed.arch.t.c("root_state", r104.toString());
        return;
    L13:
        r114 = 0;
    L7:
        r102 = null;
        goto L8
    }

    @Override // nh9.b
    public final void EU(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "feedId");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        FlatConversationContainer r102 = la0();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "feedId");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        if (r102.f345101j == false) goto L13;
        FLogger.f375446a.i("FlatConversationContainer", "onDouBaoConversationClicked feedId=" + r100 + " conversationId=" + r101);
        if (StringsKt.isBlank(r100) == false) goto L8;
        return;
    L8:
        if (StringsKt.isBlank(r101) == true) goto L14;
        r102.f345107p = r101;
        return;
    L14:
        return;
    }

    @Override // eb9.y
    public final void GQ(View r100, wh8.a r101) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        Intrinsics.checkNotNullParameter(r101, "conversationData");
        com.larus.home.impl.main.side_bar.view.adapter.k0.a(r100, r101, this, this);
    }

    @Override // eb9.y
    public final void Vi(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "feedId");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        EU(r100, r101);
    }

    public final SideBarConversationAdapter X90(int r100, com.larus.home.impl.main.side_bar.data.p r110) {
        int r101 = ba0(r100);
        com.larus.home.impl.main.side_bar.data.o r102 = r110.j();
        if (r102 == null) goto L5;
        int r103 = r102.a();
    L6:
        com.larus.home.impl.main.side_bar.data.d1 r104 = new com.larus.home.impl.main.side_bar.data.d1(r110.h(), Integer.valueOf(r101), Integer.valueOf(r103));
        int r105 = r110.getType();
        String r106 = r110.h();
        com.larus.home.impl.main.side_bar.data.b r107 = r110.c();
        if (r107 != null) goto L9;
    L11:
        boolean r108 = false;
    L12:
        if (r108 == true) goto L14;
    L21:
        boolean r109 = true;
    L22:
        SideBarConversationAdapter r111 = new SideBarConversationAdapter(this, this, r104, r105, r106, r109);
        SideBarConfigModel r112 = sa0();
        r112.getClass();
        V90(r111, r112.f344439j, r112.f344440k);
        return r111;
    L14:
        if (pa0() == true) goto L16;
    L20:
        r109 = false;
        goto L22
    L16:
        if (ga0() == true) goto L20;
        if (r110.getType() != ComponentTypeEnum.CONVERSATION_CONTAINER.getType()) goto L20;
    L9:
        if (r107.c() == true) goto L11;
        r108 = true;
        goto L12
    L5:
        r103 = Integer.MAX_VALUE;
        goto L6
    }

    @Override // com.larus.home.impl.main.side_bar.view.b
    public final void YX(Object r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "callback");
        SideBarPcAvatarController r102 = this.E;
        if (r102 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "callback");
        r102.f344847h.put(r100, r101);
        r102.c();
        return;
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [com.larus.home.impl.main.side_bar.view.l0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.home.impl.main.side_bar.view.f2, kotlin.jvm.functions.Function0] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        this.E = new SideBarPcAvatarController(getViewLifecycleOwner(), LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()));
        if (Ga() == false) goto L7;
        SideBarPcAvatarController r112 = this.E;
        if (r112 == null) goto L7;
        r112.b();
    L7:
        com.larus.utils.i0.f375410a.getClass();
        int r113 = com.larus.utils.i0.g();
        FragmentActivity r114 = getActivity();
        if (r114 == null) goto L10;
        int r115 = Math.min(com.larus.utils.i0.c(r114), com.larus.utils.i0.e());
    L12:
        if (AppHost.f326268a.isOversea() == true) goto L15;
        if (r115 != 0) goto L15;
        int r100 = i5.h();
    L16:
        LarusFragmentSideBarContentBinding r101 = this.f344771d;
        if (r101 == null) goto L21;
        ConstraintLayout r102 = r101.f344261i;
        if (r102 == null) goto L21;
        int r116 = r115 + r100;
        int r103 = r102.getPaddingStart();
        int r104 = r102.getPaddingEnd();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r102.getClass().getSimpleName() + ",source:SideBarContentFragment adapt,start:" + r103 + ",top:" + r113 + ",end:" + r104 + ",bottom:" + r116);
        r102.setPaddingRelative(r103, r113, r104, r116);
    L21:
        LarusFragmentSideBarContentBinding r117 = this.f344771d;
        if (r117 == null) goto L26;
        ConstraintLayout r118 = r117.f344261i;
        if (r118 == null) goto L26;
        nda.d.a().qa(r118, getViewLifecycleOwner());
    L26:
        LarusFragmentSideBarContentBinding r119 = this.f344771d;
        if (r119 == null) goto L36;
        RecyclerView r120 = r119.f344259g;
        if (r120 == null) goto L36;
        r120.setItemAnimator(null);
        r120.setLayoutManager(new LinearLayoutManager(r120.getContext()));
        if (pa0() == false) goto L33;
        int r105 = i5.Y();
    L34:
        int r106 = r120.getPaddingStart();
        int r107 = r120.getPaddingEnd();
        int r108 = r120.getPaddingBottom();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r120.getClass().getSimpleName() + ",source:,start:" + r106 + ",top:" + r105 + ",end:" + r107 + ",bottom:" + r108);
        r120.setPaddingRelative(r106, r105, r107, r108);
        goto L36
    L33:
        r105 = i5.r0();
    L36:
        if (pa0() == false) goto L45;
        LarusFragmentSideBarContentBinding r121 = this.f344771d;
        if (r121 == null) goto L45;
        LinearLayout r109 = r121.f344258f;
        if (r109 == null) goto L45;
        ImageView r122 = r121.f344267o;
        if (r122 == null) goto L45;
        xb9.a r123 = new xb9.a(r109);
        r123.a(r122, i5.c(), i5.c(), i5.c(), i5.c());
        r109.setTouchDelegate(r123);
    L45:
        com.larus.bmhome.chat.api.v r124 = (com.larus.bmhome.chat.api.v) this.f344796y.getValue();
        if (r124 == null) goto L52;
        LarusFragmentSideBarContentBinding r125 = this.f344771d;
        if (r125 == null) goto L50;
        RecyclerView r126 = r125.f344259g;
    L51:
        r124.b(r126, "SideBarFeed");
        goto L52
    L50:
        r126 = null;
    L52:
        SideBarConfigModel r127 = sa0();
        if (this.F == true) goto L55;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass4(r127, this, null), 2, null);
    L55:
        LarusFragmentSideBarContentBinding r128 = this.f344771d;
        if (r128 == null) goto L60;
        RecyclerView r129 = r128.f344259g;
        if (r129 == null) goto L60;
        r129.addOnScrollListener(new SideBarContentFragment$observeSidebarScrolled$1(this));
    L60:
        LarusFragmentSideBarContentBinding r130 = this.f344771d;
        if (r130 == null) goto L65;
        final RecyclerView r131 = r130.f344259g;
        if (r131 == null) goto L65;
        final Function2 r132 = new k0(this);
        final ?? r133 = new l0(this);
        final Function2 r134 = null;
        Intrinsics.checkNotNullParameter(r131, "<this>");
        Intrinsics.checkNotNullParameter(r133, "callBack");
        final com.larus.utils.n0 r135 = new com.larus.utils.n0(new e2());
        final LinkedHashSet r136 = new LinkedHashSet();
        r131.setTag(R.id.recycler_report_tag, r136);
        final ?? r137 = new f2(r131, r135, r134, r132, r136, r133);
        r131.addOnScrollListener(new SideBarRecyclerViewKt$onSideBarItemShow$1(r137));
        r131.addOnLayoutChangeListener(new g2(r137));
        d r138 = new d(r137, new h2(r136));
    L66:
        this.f344778i = r138;
        IProfileApi.Companion r139 = IProfileApi.f365981a;
        r139.h().observeForever(this.Z);
        r139.j().observeForever(this.f344781k0);
        IUgcBotRepoService.Impl.f317653b.b().observeForever(this.f344787p0);
        RepoDispatcherDelegate.f307737b.b().r1().observeForever(this.H0);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new SideBarContentFragment$observeUserInfo$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new SideBarContentFragment$observeSubscriptionEntryConfig$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new SideBarContentFragment$observeUserSettingChanged$1(this, null), 3, null);
        if (va0() == false) goto L69;
        W90();
    L69:
        LarusFragmentSideBarContentBinding r140 = this.f344771d;
        if (r140 == null) goto L74;
        SideBarFloatingButtonView r141 = r140.f344256d;
        if (r141 == null) goto L74;
        com.larus.utils.e1.d(r141, new e0(this));
    L74:
        CoroutineScope r142 = com.larus.bmhome.chat.helper.f0.f303099a;
        y r143 = this.f344793v;
        Intrinsics.checkNotNullParameter(r143, "observer");
        com.larus.bmhome.chat.helper.f0.f303100b.put(r143, Unit.INSTANCE);
        r143.a(com.larus.bmhome.chat.helper.f0.f303101c);
        LarkSocialExp.f365340a.getClass();
        Ia0(LarkSocialExp.e());
        AccountService.f365697a.E(this.X);
        SideBarProjectActionHandler r144 = (SideBarProjectActionHandler) this.f344792u.getValue();
        r144.getClass();
        IProjectCreatePanelService r145 = (IProjectCreatePanelService) ServiceManager.get().getService(IProjectCreatePanelService.class);
        if (r145 == null) goto L78;
        Fragment r146 = r144.f345781a;
        r145.b(r146, r146.getViewLifecycleOwner(), "side_bar_create_project_result", null, new com.larus.home.impl.main.side_bar.view.project.b(r144, r144.f345782b.invoke(), false));
    L78:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new SideBarContentFragment$observePendingConfirmations$1(this, null), 3, null);
        return;
    L65:
        r138 = null;
    L15:
        r100 = 0;
        goto L16
    L10:
        r115 = 0;
        goto L12
    }

    @Override // com.larus.home.impl.main.side_bar.view.f
    public final void xY(List<com.larus.home.impl.main.side_bar.data.j0> r110, List<com.larus.home.impl.main.side_bar.data.j0> r111) {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("onMiddleConversationListChanged foldSize=");
        if (r110 == null) goto L5;
        Integer r102 = Integer.valueOf(r110.size());
    L6:
        r101.append(r102);
        r101.append(" unfoldSize=");
        if (r111 == null) goto L9;
        Integer r103 = Integer.valueOf(r111.size());
    L10:
        r101.append(r103);
        r100.i("SideBarContentFragment", r101.toString());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new SideBarContentFragment$onMiddleConversationListChanged$1(this, r110, r111, null), 2, null);
        return;
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final void xa0(String r100, GroupController r101) {
        int r102 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        StringBuilder r103 = new StringBuilder("fragment=");
        r103.append(com.larus.home.impl.main.side_bar.feed.arch.t.e(this));
        r103.append(" action=");
        r103.append(r100);
        r103.append(" controller=");
        r103.append(com.larus.home.impl.main.side_bar.feed.arch.t.e(r101));
        r103.append(" policy=");
        sa0().getClass();
        r103.append(SideBarConfigModel.f());
        r103.append(" filter=");
        r103.append(ka0());
        r103.append(" root=");
        r103.append(com.larus.home.impl.main.side_bar.feed.arch.t.e(this.f344774g));
        r103.append(" querySources=");
        r103.append(((ArrayList) r101.h()).size());
        r103.append(" drawerOpen=");
        r103.append(Ga());
        com.larus.home.impl.main.side_bar.feed.arch.t.c("fragment_controller", r103.toString());
    }

    public static final RecyclerView.Adapter T90(SideBarContentFragment r100, com.larus.home.impl.main.side_bar.data.p r101, DividerPositionEnum r102) {
        r100.getClass();
        com.larus.home.impl.main.side_bar.data.f r103 = r101.f();
        if (r103 != null) goto L5;
        return null;
    L5:
        if (r103.b() != r102.getPosition()) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L11;
        r103 = null;
    L11:
        if (r103 == null) goto L19;
        SideBarDividerAdapter r105 = new SideBarDividerAdapter(r103);
        if (r102 != DividerPositionEnum.TOP) goto L20;
        VisibilityAdapter r106 = new VisibilityAdapter(r105, r100.C);
        r100.B = r106;
        return r106;
    L20:
        return r105;
    L19:
        return null;
    L7:
        r104 = false;
        goto L8
    }

    public static void V90(SideBarConversationAdapter r100, List r101, List r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        List r103 = null;
        if (r100.getType() != ComponentTypeEnum.MAIN_BOT.getType()) goto L13;
        if (r101 == null) goto L8;
        List r104 = com.larus.utils.h.i(r101, new g0());
    L9:
        if (r102 == null) goto L11;
        r103 = com.larus.utils.h.i(r102, new h0());
    L11:
        Pair r105 = TuplesKt.to(r104, r103);
    L21:
        r100.F2((List) r105.getFirst(), (List) r105.getSecond());
        return;
    L8:
        r104 = null;
        goto L9
    L13:
        if (r100.f344917l == true) goto L20;
        if (r101 == null) goto L16;
        List r106 = Z90(com.larus.utils.h.b(r101, new i0()));
    L17:
        if (r102 == null) goto L19;
        r103 = Z90(com.larus.utils.h.b(r102, new j0()));
    L19:
        r105 = TuplesKt.to(r106, r103);
        goto L21
    L16:
        r106 = null;
        goto L17
    L20:
        r105 = TuplesKt.to(r101, r102);
        goto L21
    }

    public static int ma0(ConcatAdapter r100, BaseSideBarAdapter r101, int r102) {
        Iterator<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r103 = r100.getAdapters().iterator();
        int r104 = 0;
    L4:
        if (r103.hasNext() == false) goto L10;
        RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r105 = r103.next();
        if (Intrinsics.areEqual(r105, r101) == true) goto L8;
        r104 = r104 + r105.getItemCount();
        goto L4
    L8:
        return r104 + r102;
    L10:
        return -1;
    }

    public final Object Ca0(LifecycleCoroutineScope r210, boolean r211, Continuation r212) {
        if ((r212 instanceof SideBarContentFragment$rebuildConversationContainer$1) == false) goto L7;
        SideBarContentFragment$rebuildConversationContainer$1 r100 = (SideBarContentFragment$rebuildConversationContainer$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        SideBarContentFragment$rebuildConversationContainer$1 r102 = r100;
        Object r103 = r102.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        int r105 = r102.I$0;
        GroupController r106 = (GroupController) r102.L$1;
        ConcatAdapter r107 = (ConcatAdapter) r102.L$0;
        ResultKt.throwOnFailure(r103);
    L107:
        GroupController r108 = (GroupController) r103;
        if (this.f344780k == r106) goto L111;
        r108.l();
        return Unit.INSTANCE;
    L111:
        eb9.n r109 = ra0().f345756e;
        if (r109 == null) goto L114;
        r108.o(r109);
    L114:
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "concatAdapter");
        boolean r111 = r107.removeAdapter(r106.f345125g.f344633c);
        int r112 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.c("controller_remove", r106.n() + " root=" + com.larus.home.impl.main.side_bar.feed.arch.t.e(r107) + " removed=" + r111 + " rootChildren=" + r107.getAdapters().size());
        r106.l();
        r108.getClass();
        Intrinsics.checkNotNullParameter(r107, "concatAdapter");
        if ((!r108.f345123e.isEmpty()) == true) goto L117;
    L119:
        boolean r113 = false;
    L120:
        com.larus.home.impl.main.side_bar.feed.arch.t.c("controller_insert", r108.n() + " root=" + com.larus.home.impl.main.side_bar.feed.arch.t.e(r107) + " index=" + r105 + " inserted=" + r113 + " rootChildren=" + r107.getAdapters().size());
        Fa0("conversation_group_controller_replace");
        ra0().b();
        if (Ga() == false) goto L123;
        r108.d();
    L123:
        this.f344780k = r108;
        Ea0();
        xa0("replace", r108);
        return Unit.INSTANCE;
    L117:
        if (CollectionsKt.contains(r107.getAdapters(), r108.f345125g.f344633c) == true) goto L119;
        r113 = r107.addAdapter(RangesKt.coerceIn(r105, 0, r107.getAdapters().size()), r108.f345125g.f344633c);
        goto L120
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r114 = r102.I$1;
        int r115 = r102.I$0;
        boolean r116 = r102.Z$0;
        ConversationGroupPolicy r117 = (ConversationGroupPolicy) r102.L$4;
        GroupController r118 = (GroupController) r102.L$3;
        com.larus.home.impl.main.side_bar.data.p r119 = (com.larus.home.impl.main.side_bar.data.p) r102.L$2;
        ConcatAdapter r120 = (ConcatAdapter) r102.L$1;
        CoroutineScope r121 = (CoroutineScope) r102.L$0;
        ResultKt.throwOnFailure(r103);
    L64:
        com.larus.home.impl.main.side_bar.data.p r122 = r119;
        int r123 = r114;
        CoroutineScope r124 = r121;
        boolean r125 = r116;
    L65:
        com.larus.home.impl.main.side_bar.data.p r126 = r122;
        ConcatAdapter r127 = r120;
        GroupController r128 = r118;
        com.larus.home.impl.main.side_bar.view.group.datasource.lark.u r129 = this.V;
        if (r129.f345450e == r128.f345130l) goto L70;
    L77:
        boolean r130 = false;
    L78:
        if (r130 == true) goto L80;
        FLogger.f375446a.i("SideBarContentFragment", "rebuild without pinned reuse, human port generation changed");
    L80:
        if (r125 == false) goto L102;
        if (r130 == false) goto L102;
        if (r128.f345120b != ka0()) goto L102;
        Set r131 = SetsKt.setOf("pinned");
        Intrinsics.checkNotNullParameter(r131, "ids");
        List<com.larus.home.impl.main.side_bar.view.group.module.y> r132 = r128.f345123e;
        ArrayList r133 = new ArrayList();
        Iterator<T> r134 = r132.iterator();
    L86:
        if (r134.hasNext() == false) goto L90;
        Object r135 = r134.next();
        if (r131.contains(((com.larus.home.impl.main.side_bar.view.group.module.y) r135).f345551a) == false) goto L86;
        r133.add(r135);
        goto L86
    L90:
        Iterator r136 = r133.iterator();
    L92:
        if (r136.hasNext() == false) goto L94;
        r128.b((com.larus.home.impl.main.side_bar.view.group.module.y) r136.next());
        goto L92
    L94:
        Set<String> r137 = r128.f345129k;
        ArrayList r138 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r133, 10));
        Iterator r139 = r133.iterator();
    L96:
        if (r139.hasNext() == false) goto L98;
        r138.add(((com.larus.home.impl.main.side_bar.view.group.module.y) r139.next()).f345551a);
        goto L96
    L98:
        CollectionsKt.addAll(r137, r138);
        int r140 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.c("controller_detach_reusable", r128.n() + " requested=" + r131.size() + " detached=" + r133.size());
        Map r141 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r133, 10)), 16));
        Iterator r142 = r133.iterator();
    L100:
        if (r142.hasNext() == false) goto L103;
        com.larus.home.impl.main.side_bar.view.group.module.y r143 = (com.larus.home.impl.main.side_bar.view.group.module.y) r142.next();
        Pair r144 = TuplesKt.to(r143.f345551a, r143.f345553c);
        r141.put(r144.getFirst(), r144.getSecond());
    L103:
        r102.L$0 = r127;
        r102.L$1 = r128;
        r102.L$2 = null;
        r102.L$3 = null;
        r102.L$4 = null;
        r102.I$0 = r123;
        r102.label = 2;
        r103 = Y90(this, r124, r141, r115, r126, r117, false, r102, 32);
        if (r103 != r110) goto L106;
        return r110;
    L106:
        r107 = r127;
        r105 = r123;
        r106 = r128;
    L102:
        r141 = MapsKt.emptyMap();
        goto L103
    L70:
        if (r129.f345448c != null) goto L72;
    L74:
        boolean r145 = false;
    L75:
        if (r145 == true) goto L77;
        r130 = true;
        goto L78
    L72:
        if (Intrinsics.areEqual(r129.f345449d, r129.f345447b.invoke()) == true) goto L74;
        r145 = true;
        goto L75
    L16:
        ResultKt.throwOnFailure(r103);
        JobKt.ensureActive(r102.getContext());
        JobKt.ensureActive(r210.getCoroutineContext());
        r120 = this.f344774g;
        if (r120 == null) goto L19;
        r119 = this.f344785o;
        if (r119 == null) goto L23;
        Integer r146 = Boxing.boxInt(this.f344783m);
        if (r146.intValue() == (-1)) goto L27;
        boolean r147 = true;
    L28:
        if (r147 == true) goto L31;
        r146 = null;
    L31:
        if (r146 == null) goto L128;
        int r148 = r146.intValue();
        r118 = this.f344780k;
        if (r118 != null) goto L37;
        return Unit.INSTANCE;
    L37:
        if (r118.f345123e.isEmpty() == false) goto L39;
        List r149 = CollectionsKt.emptyList();
    L40:
        Integer r150 = (Integer) SequencesKt.minOrNull(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(r149), new SideBarContentFragment$rebuildConversationContainer$insertionIndex$1(r120.getAdapters())), new m0()));
        if (r150 != null) goto L54;
        Integer r151 = Boxing.boxInt(this.f344784n);
        if (r151.intValue() == (-1)) goto L46;
        boolean r152 = true;
    L47:
        if (r152 == true) goto L50;
        r151 = null;
    L50:
        if (r151 == null) goto L52;
        r150 = Boxing.boxInt(RangesKt.coerceIn(r151.intValue(), 0, r120.getAdapters().size()));
    L53:
        if (r150 != null) goto L54;
        return Unit.INSTANCE;
    L52:
        r150 = null;
        goto L53
    L46:
        r152 = false;
    L54:
        r114 = r150.intValue();
        this.f344784n = r114;
        sa0().getClass();
        r117 = SideBarConfigModel.f();
        if (r118.f345120b == ConversationArchiveFilter.Archived) goto L57;
    L66:
        r125 = r211;
        r115 = r148;
        r122 = r119;
        r123 = r114;
        r124 = r210;
        goto L65
    L57:
        if (ka0() != ConversationArchiveFilter.Active) goto L66;
        Reflection.getOrCreateKotlinClass(IProjectListDataSource.class);
        IProjectListDataSource r153 = (IProjectListDataSource) ServiceManager.get().getService(IProjectListDataSource.class);
        if (r153 == null) goto L66;
        r102.L$0 = r210;
        r102.L$1 = r120;
        r102.L$2 = r119;
        r102.L$3 = r118;
        r102.L$4 = r117;
        r102.Z$0 = r211;
        r102.I$0 = r148;
        r102.I$1 = r114;
        r102.label = 1;
        if (r153.a(r102) != r110) goto L63;
        return r110;
    L63:
        r115 = r148;
        r121 = r210;
        r116 = r211;
        goto L64
    L39:
        r149 = CollectionsKt.listOf(r118.f345125g.f344633c);
        goto L40
    L128:
        return Unit.INSTANCE;
    L27:
        r147 = false;
        goto L28
    L23:
        return Unit.INSTANCE;
    L19:
        return Unit.INSTANCE;
    L7:
        r100 = new SideBarContentFragment$rebuildConversationContainer$1(this, r212);
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r210, ViewGroup r211, Bundle r212) {
        Intrinsics.checkNotNullParameter(r210, "inflater");
        View r100 = r210.inflate(R.layout.larus_fragment_side_bar_content, r211, false);
        int r101 = R.id.action_container;
        LinearLayout r102 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.action_container);
        if (r102 == null) goto L45;
        r101 = R.id.iv_avatar;
        RoundAvatarImageView r103 = (RoundAvatarImageView) ViewBindings.findChildViewById(r100, R.id.iv_avatar);
        if (r103 == null) goto L45;
        r101 = R.id.layout_back_doubao;
        SideBarFloatingButtonView r104 = (SideBarFloatingButtonView) ViewBindings.findChildViewById(r100, R.id.layout_back_doubao);
        if (r104 == null) goto L45;
        r101 = R.id.layout_bottom_range;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r100, R.id.layout_bottom_range)) == null) goto L45;
        r101 = R.id.layout_legacy_top_range;
        LinearLayout r105 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.layout_legacy_top_range);
        if (r105 == null) goto L45;
        r101 = R.id.layout_merged_top_range;
        LinearLayout r106 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.layout_merged_top_range);
        if (r106 == null) goto L45;
        r101 = R.id.layout_middle_range;
        RecyclerView r110 = (RecyclerView) ViewBindings.findChildViewById(r100, R.id.layout_middle_range);
        if (r110 == null) goto L45;
        r101 = R.id.layout_search;
        LinearLayout r111 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.layout_search);
        if (r111 == null) goto L45;
        ConstraintLayout r107 = (ConstraintLayout) r100;
        int r108 = R.id.layout_top_range;
        FrameLayout r112 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.layout_top_range);
        if (r112 == null) goto L47;
        r108 = R.id.profile_container;
        LinearLayout r113 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.profile_container);
        if (r113 == null) goto L47;
        r108 = R.id.search_edit;
        TextView r114 = (TextView) ViewBindings.findChildViewById(r100, R.id.search_edit);
        if (r114 == null) goto L47;
        r108 = R.id.side_bar_create_conversation;
        ImageView r115 = (ImageView) ViewBindings.findChildViewById(r100, R.id.side_bar_create_conversation);
        if (r115 == null) goto L47;
        r108 = R.id.side_bar_merged_main_title;
        TextView r116 = (TextView) ViewBindings.findChildViewById(r100, R.id.side_bar_merged_main_title);
        if (r116 == null) goto L47;
        r108 = R.id.side_bar_merged_search;
        ImageView r117 = (ImageView) ViewBindings.findChildViewById(r100, R.id.side_bar_merged_search);
        if (r117 == null) goto L47;
        r108 = R.id.side_bar_merged_work_title;
        TextView r118 = (TextView) ViewBindings.findChildViewById(r100, R.id.side_bar_merged_work_title);
        if (r118 == null) goto L47;
        r108 = R.id.tv_tenant_name;
        TextView r213 = (TextView) ViewBindings.findChildViewById(r100, R.id.tv_tenant_name);
        if (r213 == null) goto L47;
        r108 = R.id.tv_username;
        TextView r214 = (TextView) ViewBindings.findChildViewById(r100, R.id.tv_username);
        if (r214 == null) goto L47;
        r108 = R.id.username_chevron;
        ImageView r215 = (ImageView) ViewBindings.findChildViewById(r100, R.id.username_chevron);
        if (r215 == null) goto L47;
        r108 = R.id.username_container;
        ConstraintLayout r216 = (ConstraintLayout) ViewBindings.findChildViewById(r100, R.id.username_container);
        if (r216 == null) goto L47;
        r108 = R.id.view_bottom_divider;
        View r217 = ViewBindings.findChildViewById(r100, R.id.view_bottom_divider);
        if (r217 == null) goto L47;
        this.f344771d = new LarusFragmentSideBarContentBinding(r107, r102, r103, r104, r105, r106, r110, r111, r107, r112, r113, r114, r115, r116, r117, r118, r213, r214, r215, r216, r217);
        return r107;
    L47:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r108)));
    L45:
        r108 = r101;
        goto L47
    }

    public final void J90(int r210, String r211, String r212, String r213) {
        FLogger r110 = FLogger.f375446a;
        r110.i("SideBarContentFragment", "selectComponent enter page=" + r210 + " tab=" + r211 + " itemId=" + r212 + " source=" + r213 + " isLarkWholeFeed=" + la0().f345101j);
        FlatConversationContainer r100 = la0();
        r100.getClass();
        if (Intrinsics.areEqual(r213, "chat_conversation") == false) goto L19;
        ActivityResultCaller r101 = r100.f345092a.getParentFragment();
        if ((r101 instanceof com.larus.bmhome.a0) == false) goto L8;
        com.larus.bmhome.a0 r102 = (com.larus.bmhome.a0) r101;
    L9:
        if (r102 == null) goto L11;
        Integer r103 = Integer.valueOf(r102.ub());
    L12:
        SideBarPage.a r104 = SideBarPage.Companion;
        Integer r105 = Integer.valueOf(r210);
        r104.getClass();
        if (SideBarPage.a.c(r105) == false) goto L19;
        if (r103 == null) goto L19;
        if (r103.intValue() != 19) goto L19;
        boolean r106 = true;
    L20:
        if (r106 == false) goto L23;
        r110.i("SideBarContentFragment", "ignore chat selection from LARK_CHAT page itemId=" + r212);
        return;
    L23:
        SideBarConfigModel r107 = sa0();
        Triple<Integer, String, String> r108 = r107.A;
        if (r108 == null) goto L26;
        Triple r111 = Triple.copy$default(r108, null, null, null, 7, null);
    L27:
        r110.i("SideBarConfigModel", "selectComponent source=" + r213 + " page=" + r210 + " tab=" + r211 + " itemId=" + r212);
        r107.A = new Triple(Integer.valueOf(r210), r211, r212);
        SideBarPage.a r109 = SideBarPage.Companion;
        if (r111 == null) goto L30;
        Integer r112 = (Integer) r111.getFirst();
    L31:
        r109.getClass();
        if (SideBarPage.a.c(r112) == false) goto L34;
    L35:
        r110.i("SideBarConfigModel", "select conversation: " + r212);
        r107.p(r107.f344441l);
    L37:
        if (SideBarPage.a.c(Integer.valueOf(r210)) == false) goto L70;
        if (r212 != null) goto L40;
    L43:
        boolean r113 = true;
    L44:
        if (r113 == true) goto L70;
        if (r111 == null) goto L47;
        String r114 = (String) r111.getThird();
    L49:
        if (Intrinsics.areEqual(r212, r114) == true) goto L70;
        wc9.e r115 = AuthModelDelegate.f297134b.y().getValue();
        if (r115 != null) goto L53;
    L69:
        int r116 = 19;
        com.larus.im.service.r.a.c(com.larus.im.d.d(), r212, true, new com.larus.home.impl.main.side_bar.data.g0(), null, null, 24);
    L71:
        if (r111 == null) goto L73;
        Integer r117 = (Integer) r111.getFirst();
    L75:
        if (SideBarPage.a.a(r117) == false) goto L77;
    L78:
        r110.i(r6, "select case: page(" + r210 + "), case(" + r212 + ')');
        r107.n(r107.f344454y);
    L79:
        if (r111 == null) goto L81;
        Integer r118 = (Integer) r111.getFirst();
    L82:
        if (r118 != null) goto L84;
    L90:
        boolean r119 = false;
    L91:
        if (r119 == true) goto L103;
        Integer r120 = Integer.valueOf(r210);
        if (r120 != null) goto L95;
    L101:
        boolean r121 = false;
    L102:
        if (r121 == true) goto L103;
    L111:
        if (SideBarPage.a.c(Integer.valueOf(r210)) == false) goto L121;
        if (r212 != null) goto L114;
    L117:
        boolean r122 = true;
    L118:
        if (r122 == true) goto L121;
        int r123 = qb9.a.f532418a;
        Integer r124 = Integer.valueOf(r210);
        Intrinsics.checkNotNullParameter(r212, "conversationId");
        eb9.n r125 = new eb9.n("side_bar_conversation", r212, r124, r213);
    L139:
        GroupController r126 = this.f344780k;
        if (r126 == null) goto L143;
        if (r125 == null) goto L184;
        r126.o(r125);
    L184:
        if (r125 == null) goto L189;
        k2 r127 = ra0();
        r127.getClass();
        Intrinsics.checkNotNullParameter(r125, "selectionKey");
        if (r127.f345754c.invoke().booleanValue() == false) goto L188;
        r127.f345756e = r125;
        r127.f345759h = true;
        r127.f345757f = false;
    L191:
        if (SideBarPage.a.c(Integer.valueOf(r210)) == false) goto L193;
        if (r212 != null) goto L193;
    L195:
        if (SideBarPage.a.c(Integer.valueOf(r210)) == false) goto L207;
        if (r212 == null) goto L207;
        ConcatAdapter r128 = this.f344774g;
        if (r128 == null) goto L207;
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r129 = r128.getAdapters();
        if (r129 == null) goto L207;
        Iterator<T> r130 = r129.iterator();
    L203:
        if (r130.hasNext() == false) goto L207;
        RecyclerView.Adapter r131 = (RecyclerView.Adapter) r130.next();
        if ((r131 instanceof SideBarComponentAdapter) == false) goto L203;
        ((SideBarComponentAdapter) r131).G2(true);
    L207:
        Ga0();
        return;
    L193:
        la0().h(sa0().f344440k, sa0().h());
        goto L195
    L188:
        Intrinsics.checkNotNullParameter(r125, "selectionKey");
        r127.f345756e = r125;
        r127.f345759h = false;
        r127.f345757f = true;
        r127.c();
        goto L191
    L189:
        k2 r132 = ra0();
        r132.f345756e = null;
        r132.f345759h = false;
        r132.f345757f = false;
        goto L191
    L143:
        FlatConversationContainer r133 = la0();
        if (r133.f345101j == false) goto L184;
        if (r210 != r116) goto L165;
        if (Intrinsics.areEqual(r213, "lark_chat_page_service") == false) goto L165;
        if (r212 != null) goto L151;
    L154:
        boolean r134 = true;
    L155:
        if (r134 == true) goto L165;
        int r135 = bc9.a.f18595a;
        eb9.s r136 = r133.f345104m;
        Intrinsics.checkNotNullParameter(r212, "feedId");
        if (StringsKt.isBlank(r212) == false) goto L159;
        r110.i("SideBarLarkWholeFeedDelegate", "skip setFlowClickHint, feedId is blank");
        goto L184
    L159:
        if (r136 != null) goto L161;
        r110.i("SideBarLarkWholeFeedDelegate", "skip setFlowClickHint, source is null");
        goto L184
    L161:
        r110.i("SideBarLarkWholeFeedDelegate", "setFlowClickHint feedId=" + r212);
        fb9.i r137 = bc9.a.c(r136);
        if (r137 == null) goto L184;
        r137.l(new eb9.n(r136.getId(), r212, null, null));
        goto L184
    L151:
        if (StringsKt.isBlank(r212) == true) goto L154;
        r134 = false;
    L165:
        if (r210 != r116) goto L168;
        r110.i("FlatConversationContainer", "skip syncSelection for LARK_CHAT source=" + r213 + " itemId=" + r212);
        goto L184
    L168:
        if (SideBarPage.a.c(Integer.valueOf(r210)) == false) goto L181;
        if (r212 != null) goto L171;
    L174:
        boolean r138 = true;
    L175:
        if (r138 == true) goto L181;
        if (Intrinsics.areEqual(r133.f345107p, r212) == false) goto L179;
        r110.i("FlatConversationContainer", "keep lark feed click hint for doubao conversationId=" + r212);
        goto L184
    L179:
        r133.b("chat page selected");
        goto L184
    L171:
        if (StringsKt.isBlank(r212) == true) goto L174;
        r138 = false;
    L181:
        if (SideBarPage.a.c(Integer.valueOf(r210)) == false) goto L183;
        r110.i("FlatConversationContainer", "skip clear lark feed selection for chat page source=" + r213 + " itemId=" + r212);
        goto L184
    L183:
        r133.b("non chat page selected");
        goto L184
    L114:
        if (StringsKt.isBlank(r212) == true) goto L117;
        r122 = false;
    L121:
        if (SideBarPage.a.c(Integer.valueOf(r210)) == false) goto L123;
        r125 = null;
        goto L139
    L123:
        if (r210 == r116) goto L125;
    L134:
        int r139 = qb9.a.f532418a;
        if (r212 != null) goto L137;
        String r140 = "";
    L138:
        r125 = new eb9.n("side_bar_page", r140, Integer.valueOf(r210), r213);
        goto L139
    L137:
        r140 = r212;
        goto L138
    L125:
        if (Intrinsics.areEqual(r213, "lark_chat_page_service") == false) goto L134;
        if (r212 != null) goto L128;
    L131:
        boolean r141 = true;
    L132:
        if (r141 == true) goto L134;
        int r142 = qb9.a.f532418a;
        Integer r143 = Integer.valueOf(r210);
        Intrinsics.checkNotNullParameter(r212, "id");
        r125 = new eb9.n("side_bar_human_feed", r212, r143, r213);
        goto L139
    L128:
        if (StringsKt.isBlank(r212) == true) goto L131;
        r141 = false;
        goto L132
    L95:
        if (r120.intValue() == 0) goto L101;
        if (SideBarPage.a.c(r120) == true) goto L101;
        if (SideBarPage.a.a(r120) == true) goto L101;
        r121 = true;
    L103:
        r110.i("SideBarConfigModel", "select page: " + r210);
        f r144 = r107.f344431b;
        if (r144 == null) goto L111;
        com.larus.home.impl.main.side_bar.data.p r145 = r107.f344436g;
        if (r145 == null) goto L108;
        List<com.larus.home.impl.main.side_bar.data.p> r146 = r145.e();
    L109:
        r144.P10(r146);
        goto L111
    L108:
        r146 = null;
        goto L109
    L84:
        if (r118.intValue() == 0) goto L90;
        if (SideBarPage.a.c(r118) == true) goto L90;
        if (SideBarPage.a.a(r118) == true) goto L90;
        r119 = true;
        goto L91
    L81:
        r118 = null;
        goto L82
    L77:
        if (SideBarPage.a.a(Integer.valueOf(r210)) == false) goto L79;
    L73:
        r117 = null;
        goto L75
    L53:
        if (com.larus.utils.o0.d(r212) == false) goto L69;
        if (Intrinsics.areEqual(r115.f559198a, r212) == false) goto L69;
        String r147 = r115.I;
        if (r147 != null) goto L59;
    L62:
        boolean r148 = true;
    L63:
        if (r148 == false) goto L69;
        if (com.larus.platform.service.n0.f365775a.b() == true) goto L69;
        if (com.larus.platform.exp.c.f365375e == false) goto L69;
    L59:
        if (r147.length() == 0) goto L62;
        r148 = false;
        goto L63
    L47:
        r114 = null;
        goto L49
    L40:
        if (r212.length() == 0) goto L43;
        r113 = false;
    L70:
        r116 = 19;
        goto L71
    L34:
        if (SideBarPage.a.c(Integer.valueOf(r210)) == false) goto L37;
    L30:
        r112 = null;
        goto L31
    L26:
        r111 = null;
        goto L27
    L11:
        r103 = null;
        goto L12
    L8:
        r102 = null;
    L19:
        r106 = false;
        goto L20
    }

    public final SideBarComponentAdapter aa0(int r110, com.larus.home.impl.main.side_bar.data.p r111, boolean r112, Function2<? super String, ? super List<String>, Unit> r113, Function1<? super Boolean, Unit> r114) {
        int r115 = ba0(r110);
        int r100 = r111.getType();
        if (r100 != ComponentTypeEnum.CONTAINER.getType()) goto L5;
    L8:
        com.larus.home.impl.main.side_bar.data.o r101 = r111.j();
        if (r101 == null) goto L11;
        int r102 = r101.a();
    L12:
        Integer r103 = Integer.valueOf(r102);
    L13:
        SideBarComponentAdapter r104 = new SideBarComponentAdapter(this, new com.larus.home.impl.main.side_bar.data.d1(r111.h(), Integer.valueOf(r115), r103), r111.getType(), r111.h(), r112, r113, r114);
        Function0<Integer> r116 = new b1(this);
        Intrinsics.checkNotNullParameter(r116, AbsMethodDelegate.TAG_INVOKE);
        r104.f344895n = r116;
        return r104;
    L11:
        r102 = Integer.MAX_VALUE;
        goto L12
    L5:
        if (r100 == ComponentTypeEnum.ASSET_CONTAINER.getType()) goto L8;
        r103 = null;
        goto L13
    }

    public static final Object S90(SideBarContentFragment r110, int r111, com.larus.home.impl.main.side_bar.data.p r112, LifecycleCoroutineScope r113, boolean r114, Continuation r115) {
        r110.getClass();
        if ((r115 instanceof SideBarContentFragment$createConversationGroups$1) == false) goto L7;
        SideBarContentFragment$createConversationGroups$1 r100 = (SideBarContentFragment$createConversationGroups$1) r115;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        SideBarContentFragment$createConversationGroups$1 r102 = r100;
        Object r116 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r116);
    L17:
        GroupController r117 = (GroupController) r116;
        eb9.n r118 = r110.ra0().f345756e;
        if (r118 == null) goto L20;
        r117.o(r118);
    L20:
        ConcatAdapter r119 = r110.f344774g;
        if (r119 == null) goto L26;
        r117.getClass();
        Intrinsics.checkNotNullParameter(r119, "concatAdapter");
        boolean r120 = CollectionsKt.contains(r119.getAdapters(), r117.f345125g.f344633c);
        if (CollectionsKt.contains(r119.getAdapters(), r117.f345125g.f344633c) == true) goto L25;
        r119.addAdapter(r117.f345125g.f344633c);
    L25:
        int r121 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.c("controller_append", r117.n() + " root=" + com.larus.home.impl.main.side_bar.feed.arch.t.e(r119) + " attached=" + r120 + "->" + CollectionsKt.contains(r119.getAdapters(), r117.f345125g.f344633c) + " rootChildren=" + r119.getAdapters().size());
    L26:
        r110.f344780k = r117;
        r110.ja0().g(r117.e());
        if (r110.Ga() == false) goto L29;
        r117.d();
    L29:
        r110.Ea0();
        r110.xa0("create", r117);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r116);
        r110.sa0().getClass();
        ConversationGroupPolicy r105 = SideBarConfigModel.f();
        r102.label = 1;
        r116 = Y90(r110, r113, null, r111, r112, r105, r114, r102, 66);
        if (r116 != r103) goto L17;
        return r103;
    L7:
        r100 = new SideBarContentFragment$createConversationGroups$1(r110, r115);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.larus.home.impl.main.side_bar.view.j1] */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.larus.home.impl.main.side_bar.view.o1] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.larus.home.impl.main.side_bar.view.p1] */
    public static Object Y90(final SideBarContentFragment r310, CoroutineScope r311, Map r312, int r313, com.larus.home.impl.main.side_bar.data.p r314, ConversationGroupPolicy r315, boolean r316, ContinuationImpl r317, int r410) {
        if ((r410 & 2) == 0) goto L5;
        Map r210 = MapsKt.emptyMap();
    L7:
        if ((r410 & 32) == 0) goto L12;
        ImSdkConversationQueryService r100 = ImSdkConversationQueryService.f345305a;
        boolean r101 = com.larus.platform.exp.o.a();
        if (r101 == false) goto L11;
        com.larus.home.impl.main.side_bar.feed.arch.t.c("main_conversation_request_bypassed", "source=sidebar_conversation_repository");
    L11:
        boolean r110 = r101;
    L14:
        if ((r410 & 64) == 0) goto L16;
        boolean r102 = true;
    L17:
        r310.getClass();
        CoroutineContext r103 = r317.getContext();
        JobKt.ensureActive(r103);
        JobKt.ensureActive(r311.getCoroutineContext());
        int r104 = r310.ba0(r313);
        com.larus.home.impl.main.side_bar.data.o r105 = r314.j();
        if (r105 == null) goto L20;
        int r106 = r105.a();
    L21:
        com.larus.home.impl.main.side_bar.data.d1 r107 = new com.larus.home.impl.main.side_bar.data.d1(r314.h(), Boxing.boxInt(r104), Boxing.boxInt(r106));
        r310.U = r107;
        b r108 = r310.f344777h1;
        ConversationArchiveFilter r109 = r310.ka0();
        boolean r111 = r310.fa0();
        LarkSocialExp r112 = LarkSocialExp.f365340a;
        r112.getClass();
        boolean r113 = LarkSocialExp.f();
        r310.sa0().getClass();
        SideBarRepo.f344467a.getClass();
        boolean r114 = SideBarRepo.c().f344496d;
        int r115 = com.larus.home.impl.main.side_bar.view.group.module.o0.f345515h;
        uu9.a r116 = r310.ha0();
        Intrinsics.checkNotNullParameter(r116, "config");
        uu9.a r117 = uu9.a.f551781a;
        com.larus.home.impl.main.side_bar.view.group.module.o0 r118 = new com.larus.home.impl.main.side_bar.view.group.module.o0(com.larus.home.impl.main.side_bar.a.a(r116.l(), r117.l()), com.larus.home.impl.main.side_bar.a.a(r116.q(), r117.q()), com.larus.home.impl.main.side_bar.a.a(r116.o(), r117.o()), com.larus.home.impl.main.side_bar.a.a(r116.m(), r117.m()), com.larus.home.impl.main.side_bar.a.a(r116.f(), r117.f()), com.larus.home.impl.main.side_bar.a.a(r116.b(), r117.b()), com.larus.home.impl.main.side_bar.a.a(r116.a(), r117.a()));
        ac9.n r211 = com.larus.home.impl.main.side_bar.view.group.assembly.y.a(r310.f344777h1, r315, r314, r107);
        r112.getClass();
        if (LarkSocialExp.f() == true) goto L24;
    L26:
        boolean r212 = false;
    L27:
        boolean r119 = qa0();
        boolean r120 = r310.pa0();
        com.larus.home.impl.main.side_bar.view.group.module.n0 r121 = new com.larus.home.impl.main.side_bar.view.group.module.n0();
        boolean r122 = r212;
        com.larus.home.impl.main.side_bar.view.group.module.c0 r123 = new com.larus.home.impl.main.side_bar.view.group.module.c0(r108, r311, r103, r315, r314, r107, r109, r111, r113, r114, r122, r119, r120, r110, new j1(r310), new o1(r310), r118, new p1(r310), r211, r210, r121);
        return GroupController.f345118w.a(r123, (com.larus.home.impl.main.side_bar.view.group.datasource.im.h) r310.f344782l.getValue(), r102, r317);
    L24:
        if (r310.pa0() == false) goto L26;
        r212 = true;
        goto L27
    L20:
        r106 = Integer.MAX_VALUE;
        goto L21
    L16:
        r102 = false;
        goto L17
    L12:
        r110 = r316;
        goto L14
    L5:
        r210 = r312;
        goto L7
    }
}
