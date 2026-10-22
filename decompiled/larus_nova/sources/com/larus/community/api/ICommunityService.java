package com.larus.community.api;

import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.home.impl.sdk.k1;
import com.larus.platform.api.creation.CreationFeedCacheEntity;
import com.larus.platform.api.creation.PublisherCreation;
import com.larus.platform.api.creation.PublisherTrackParams;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.uaigc.avatar.instruction.p;
import com.larus.uaigc.avatar.instruction.q;
import com.larus.uaigc.createpage.component.input.CreationInputComponent$tryShowUpdateDialog$1;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import e29.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;
import q97.a;
import sq9.j;
import sq9.o;
import zp9.m;
import zp9.n;
import zp9.r;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 c2\u00020\u0001:\u0001cJ\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H&J`\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001c\u001a\u00020\r2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&J\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010 \u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\b\u0010!\u001a\u00020\u0003H&J\b\u0010\"\u001a\u00020#H&J\u0012\u0010$\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010&H&J\b\u0010'\u001a\u00020#H&J'\u0010(\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\rH&¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\n\u0018\u00010.j\u0004\u0018\u0001`/H&J\u001c\u00100\u001a\u0004\u0018\u00010\u001a2\u0006\u00101\u001a\u00020\u00052\b\b\u0002\u00102\u001a\u00020\rH&J\u001e\u00103\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH¦@¢\u0006\u0002\u00104JC\u00105\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u00142\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2%\b\u0002\u00106\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\u0003\u0018\u000107H&J\u0018\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0<2\u0006\u00101\u001a\u00020\u0005H&JP\u0010=\u001a\u00020\u00032\b\u0010>\u001a\u0004\u0018\u00010?2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020B0A2\u0006\u0010C\u001a\u00020\u00142\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\u0003072\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000307H&JK\u0010F\u001a\u00020\r2\u0006\u0010G\u001a\u00020\u00142\u0006\u0010>\u001a\u00020?2\u0006\u0010H\u001a\u00020\u00052\b\u0010I\u001a\u0004\u0018\u00010\u00052\u0006\u0010J\u001a\u00020\r2\b\u0010K\u001a\u0004\u0018\u00010\u00142\b\u0010L\u001a\u0004\u0018\u00010MH&¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020\u0003H&J\u0018\u0010P\u001a\u00020\u00032\u0006\u0010>\u001a\u00020?2\u0006\u0010Q\u001a\u00020RH&J\u0018\u0010S\u001a\u0004\u0018\u00010B2\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0018\u0010T\u001a\u00020\u00032\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020XH&J\u0010\u0010Y\u001a\u00020\u00032\u0006\u0010U\u001a\u00020VH&J\u0010\u0010Z\u001a\u00020\u00032\u0006\u0010[\u001a\u00020\\H&J\u0010\u0010]\u001a\u00020\u00032\u0006\u0010[\u001a\u00020\\H&J\u0010\u0010^\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J,\u0010_\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010`\u001a\u0004\u0018\u00010\u00052\b\u0010a\u001a\u0004\u0018\u00010\u0005H¦@¢\u0006\u0002\u0010b¨\u0006d"}, d2 = {"Lcom/larus/community/api/ICommunityService;", "", "updateCount", "", "creationId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportCreativityLauncher", "getCreativityLaunchConfig", "Lcom/larus/platform/model/creation/CreativityLaunchConfig;", "createCommunityCreateFragment", "Landroidx/fragment/app/Fragment;", "isMultiTab", "", "createCreationDetailFragment", "arguments", "Landroid/os/Bundle;", "getCreationFeedDataRepository", "Lcom/larus/platform/api/creation/ICreationFeedDataRepository;", "recommendType", "", "tabItemInfo", "Lcom/larus/platform/api/creation/TabItemInfo;", "scene", "relatedRecommendation", "cacheEntity", "Lcom/larus/platform/api/creation/CreationFeedCacheEntity;", "relatedCreationId", "autoFallbackCache", "requestSource", "Lcom/larus/community/api/spi/CommunityFeedRequestSource;", "getUserAvatarUrl", "userId", "initCreativityConfig", "createCreationDetailRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "isCreationDetailRouter", "uri", "Landroid/net/Uri;", "createCreationHomeRouterInterceptor", "generateTemplateCreationFeedFragment", "creationDoSameInterceptor", "Lcom/larus/platform/api/creation/ICreationFeedActionInterceptor;", "allowKmp", "(Lcom/larus/platform/api/creation/ICreationFeedActionInterceptor;Ljava/lang/Boolean;)Landroidx/fragment/app/Fragment;", "getCreationFeedComponent", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "getCreationListCacheData", "creationRecommendType", "cancelPrefetch", "updateCreationListCacheData", "(Ljava/lang/String;Lcom/larus/platform/api/creation/CreationFeedCacheEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prefetchTemplateCreationFeed", "afterInvokable", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "updateCache", "getFirstScreenDataFlowState", "Lkotlinx/coroutines/flow/StateFlow;", "gotoCreationDetail", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "list", "", "Lcom/larus/platform/api/creation/UserCreation;", "position", "selectCallback", "scrollListener", "tryShowUpdateDialog", "instructionType", "enterMethod", "botId", "hasAvatar", "modelVersion", "clickListener", "Lcom/larus/platform/api/creation/ICreationUpdateDialogListener;", "(ILandroidx/fragment/app/FragmentManager;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Lcom/larus/platform/api/creation/ICreationUpdateDialogListener;)Z", "tryPreloadUpdateDialogBitmap", "showCreationShareDialog", "creationImageShareModel", "Lcom/larus/platform/model/creation/CreationImageShareModel;", "fetchCreationDetail", "gotoPublisher", "publisherCreation", "Lcom/larus/platform/api/creation/PublisherCreation;", "publisherTrackParams", "Lcom/larus/platform/api/creation/PublisherTrackParams;", "preCreateIfAbsent", "registerPublishListener", "listener", "Lcom/larus/platform/api/creation/ICreationListener;", "unRegisterPublishListener", "onRemoveUserCreation", "checkAndSaveContentTaskBinding", DBDefinition.TASK_ID, "messageId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICommunityService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f328743a = null;

    @Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0096A¢\u0006\u0002\u0010\nJ\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0013H\u0096\u0001J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0006\u001a\u00020\u0007H\u0096A¢\u0006\u0002\u0010\u0017J$\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0096\u0001¢\u0006\u0002\u0010\u001cJ\u0011\u0010\u001d\u001a\n\u0018\u00010\u001ej\u0004\u0018\u0001`\u001fH\u0096\u0001JU\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\u00072\b\u0010'\u001a\u0004\u0018\u00010\u00072\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010+\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010-H\u0096\u0001J\u001b\u0010.\u001a\u0004\u0018\u00010)2\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u000eH\u0096\u0001J\t\u00101\u001a\u000202H\u0096\u0001J\u0019\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)042\u0006\u0010/\u001a\u00020\u0007H\u0096\u0001J\u0018\u00105\u001a\u0004\u0018\u00010\u00072\u0006\u00106\u001a\u00020\u0007H\u0096A¢\u0006\u0002\u0010\u0017JQ\u00107\u001a\u00020\u00052\b\u00108\u001a\u0004\u0018\u0001092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00160;2\u0006\u0010<\u001a\u00020#2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050>2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00050>H\u0096\u0001J\u0019\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0096\u0001J\t\u0010E\u001a\u00020\u0005H\u0096\u0001J\u0013\u0010F\u001a\u00020\u000e2\b\u0010G\u001a\u0004\u0018\u00010HH\u0096\u0001J\u0011\u0010I\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010J\u001a\u00020\u00052\u0006\u0010A\u001a\u00020BH\u0096\u0001J@\u0010K\u001a\u00020\u00052\u0006\u0010/\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u00010-2#\u0010L\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\bM\u0012\b\bN\u0012\u0004\b\b(O\u0012\u0004\u0012\u00020\u0005\u0018\u00010>H\u0096\u0001J\u0011\u0010P\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020RH\u0096\u0001J\t\u0010S\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010T\u001a\u00020\u00052\u0006\u00108\u001a\u0002092\u0006\u0010U\u001a\u00020VH\u0096\u0001J\t\u0010W\u001a\u00020\u0005H\u0096\u0001JL\u0010X\u001a\u00020\u000e2\u0006\u0010Y\u001a\u00020#2\u0006\u00108\u001a\u0002092\u0006\u0010Z\u001a\u00020\u00072\b\u0010[\u001a\u0004\u0018\u00010\u00072\u0006\u0010\\\u001a\u00020\u000e2\b\u0010]\u001a\u0004\u0018\u00010#2\b\u0010^\u001a\u0004\u0018\u00010_H\u0096\u0001¢\u0006\u0002\u0010`J\u0011\u0010a\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020RH\u0096\u0001J\u0016\u0010b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096A¢\u0006\u0002\u0010\u0017J\u001e\u0010c\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)H\u0096A¢\u0006\u0002\u0010d¨\u0006e"}, d2 = {"Lcom/larus/community/api/ICommunityService$Companion;", "Lcom/larus/community/api/ICommunityService;", "<init>", "()V", "checkAndSaveContentTaskBinding", "", "creationId", "", DBDefinition.TASK_ID, "messageId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCommunityCreateFragment", "Landroidx/fragment/app/Fragment;", "isMultiTab", "", "createCreationDetailFragment", "arguments", "Landroid/os/Bundle;", "createCreationDetailRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "createCreationHomeRouterInterceptor", "fetchCreationDetail", "Lcom/larus/platform/api/creation/UserCreation;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateTemplateCreationFeedFragment", "creationDoSameInterceptor", "Lcom/larus/platform/api/creation/ICreationFeedActionInterceptor;", "allowKmp", "(Lcom/larus/platform/api/creation/ICreationFeedActionInterceptor;Ljava/lang/Boolean;)Landroidx/fragment/app/Fragment;", "getCreationFeedComponent", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "getCreationFeedDataRepository", "Lcom/larus/platform/api/creation/ICreationFeedDataRepository;", "recommendType", "", "tabItemInfo", "Lcom/larus/platform/api/creation/TabItemInfo;", "scene", "relatedRecommendation", "cacheEntity", "Lcom/larus/platform/api/creation/CreationFeedCacheEntity;", "relatedCreationId", "autoFallbackCache", "requestSource", "Lcom/larus/community/api/spi/CommunityFeedRequestSource;", "getCreationListCacheData", "creationRecommendType", "cancelPrefetch", "getCreativityLaunchConfig", "Lcom/larus/platform/model/creation/CreativityLaunchConfig;", "getFirstScreenDataFlowState", "Lkotlinx/coroutines/flow/StateFlow;", "getUserAvatarUrl", "userId", "gotoCreationDetail", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "list", "", "position", "selectCallback", "Lkotlin/Function1;", "scrollListener", "gotoPublisher", "publisherCreation", "Lcom/larus/platform/api/creation/PublisherCreation;", "publisherTrackParams", "Lcom/larus/platform/api/creation/PublisherTrackParams;", "initCreativityConfig", "isCreationDetailRouter", "uri", "Landroid/net/Uri;", "onRemoveUserCreation", "preCreateIfAbsent", "prefetchTemplateCreationFeed", "afterInvokable", "Lkotlin/ParameterName;", "name", "updateCache", "registerPublishListener", "listener", "Lcom/larus/platform/api/creation/ICreationListener;", "reportCreativityLauncher", "showCreationShareDialog", "creationImageShareModel", "Lcom/larus/platform/model/creation/CreationImageShareModel;", "tryPreloadUpdateDialogBitmap", "tryShowUpdateDialog", "instructionType", "enterMethod", "botId", "hasAvatar", "modelVersion", "clickListener", "Lcom/larus/platform/api/creation/ICreationUpdateDialogListener;", "(ILandroidx/fragment/app/FragmentManager;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Lcom/larus/platform/api/creation/ICreationUpdateDialogListener;)Z", "unRegisterPublishListener", "updateCount", "updateCreationListCacheData", "(Ljava/lang/String;Lcom/larus/platform/api/creation/CreationFeedCacheEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements ICommunityService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f328744c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ICommunityService f328745b;

        static {
            f328744c = new Companion();
        }

        @Override // com.larus.community.api.ICommunityService
        public final void X0(String r100) {
            Intrinsics.checkNotNullParameter(r100, "creationId");
            this.f328745b.X0(r100);
        }

        @Override // com.larus.community.api.ICommunityService
        public final boolean Y0(int r110, FragmentManager r111, String r112, String r113, boolean r114, Integer r115, CreationInputComponent$tryShowUpdateDialog$1.a r116) {
            Intrinsics.checkNotNullParameter(r111, "fragmentManager");
            Intrinsics.checkNotNullParameter(r112, "enterMethod");
            return this.f328745b.Y0(r110, r111, r112, r113, r114, r115, r116);
        }

        @Override // com.larus.community.api.ICommunityService
        public final void Z0(FragmentManager r100, j r101) {
            Intrinsics.checkNotNullParameter(r100, "fragmentManager");
            Intrinsics.checkNotNullParameter(r101, "creationImageShareModel");
            this.f328745b.Z0(r100, r101);
        }

        @Override // com.larus.community.api.ICommunityService
        public final void a1(PublisherCreation r100, PublisherTrackParams r101) {
            Intrinsics.checkNotNullParameter(r100, "publisherCreation");
            Intrinsics.checkNotNullParameter(r101, "publisherTrackParams");
            this.f328745b.a1(r100, r101);
        }

        @Override // com.larus.community.api.ICommunityService
        public final CreationFeedCacheEntity b1(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "creationRecommendType");
            return this.f328745b.b1(r100, r101);
        }

        @Override // com.larus.community.api.ICommunityService
        public final void c1(r r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            this.f328745b.c1(r100);
        }

        @Override // com.larus.community.api.ICommunityService
        public final void d1() {
            this.f328745b.d1();
        }

        @Override // com.larus.community.api.ICommunityService
        public final void e1(r r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            this.f328745b.e1(r100);
        }

        @Override // com.larus.community.api.ICommunityService
        public final o f1() {
            return this.f328745b.f1();
        }

        @Override // com.larus.community.api.ICommunityService
        public final void g1(PublisherCreation r100) {
            Intrinsics.checkNotNullParameter(r100, "publisherCreation");
            this.f328745b.g1(r100);
        }

        @Override // com.larus.community.api.ICommunityService
        public final Object h1(String r100, String r101, String r102, Continuation<? super Unit> r103) {
            return this.f328745b.h1(r100, r101, r102, r103);
        }

        @Override // com.larus.community.api.ICommunityService
        public final i1<CreationFeedCacheEntity> i1(String r100) {
            Intrinsics.checkNotNullParameter(r100, "creationRecommendType");
            return this.f328745b.i1(r100);
        }

        @Override // com.larus.community.api.ICommunityService
        public final Fragment j1(m r100, Boolean r101) {
            return this.f328745b.j1(r100, r101);
        }

        @Override // com.larus.community.api.ICommunityService
        public final boolean k1(Uri r100) {
            return this.f328745b.k1(r100);
        }

        @Override // com.larus.community.api.ICommunityService
        public final Fragment l1(Bundle r100) {
            Intrinsics.checkNotNullParameter(r100, "arguments");
            return this.f328745b.l1(r100);
        }

        @Override // com.larus.community.api.ICommunityService
        public final Fragment m1(boolean r100) {
            return this.f328745b.m1(r100);
        }

        @Override // com.larus.community.api.ICommunityService
        public final void n1(FragmentManager r100, List r101, int r110, p r111, q r112) {
            Intrinsics.checkNotNullParameter(r101, "list");
            Intrinsics.checkNotNullParameter(r111, "selectCallback");
            Intrinsics.checkNotNullParameter(r112, "scrollListener");
            this.f328745b.n1(r100, r101, r110, r111, r112);
        }

        @Override // com.larus.community.api.ICommunityService
        public final Object o1(String r100, Continuation<? super UserCreation> r101) {
            return this.f328745b.o1(r100, r101);
        }

        @Override // com.larus.community.api.ICommunityService
        public final Object p1(String r100, Continuation<? super String> r101) {
            return this.f328745b.p1(r100, r101);
        }

        @Override // com.larus.community.api.ICommunityService
        public final a q1() {
            return this.f328745b.q1();
        }

        @Override // com.larus.community.api.ICommunityService
        public final void r1() {
            this.f328745b.r1();
        }

        @Override // com.larus.community.api.ICommunityService
        public final Object s1(String r100, Continuation<? super Unit> r101) {
            return this.f328745b.s1(r100, r101);
        }

        @Override // com.larus.community.api.ICommunityService
        public final a t1() {
            return this.f328745b.t1();
        }

        @Override // com.larus.community.api.ICommunityService
        public final void u1() {
            this.f328745b.u1();
        }

        @Override // com.larus.community.api.ICommunityService
        public final n v1(int r110, TabItemInfo r111, String r112, String r113, CreationFeedCacheEntity r114, String r115, boolean r116, c r117) {
            return this.f328745b.v1(r110, r111, r112, r113, r114, r115, r116, r117);
        }

        @Override // com.larus.community.api.ICommunityService
        public final BaseContentWidget w1() {
            return this.f328745b.w1();
        }

        @Override // com.larus.community.api.ICommunityService
        public final void x1(int r100, k1.a r101, Function1 r102) {
            this.f328745b.x1(r100, r101, r102);
        }

        private Companion() {
            Object r100 = ServiceManager.get().getService(ICommunityService.class);
            if (r100 == null) goto L7;
            this.f328745b = (ICommunityService) r100;
            return;
        L7:
            throw new IllegalStateException("ICommunityService provider is missing; include FlowSDK Community impl in the app runtime".toString());
        }
    }

    static {
        f328743a = Companion.f328744c;
    }

    void X0(String r100);

    boolean Y0(int r100, FragmentManager r101, String r102, String r103, boolean r104, Integer r105, CreationInputComponent$tryShowUpdateDialog$1.a r106);

    void Z0(FragmentManager r100, j r101);

    void a1(PublisherCreation r100, PublisherTrackParams r101);

    CreationFeedCacheEntity b1(String r100, boolean r101);

    void c1(r r100);

    void d1();

    void e1(r r100);

    o f1();

    void g1(PublisherCreation r100);

    Object h1(String r100, String r101, String r102, Continuation<? super Unit> r103);

    i1<CreationFeedCacheEntity> i1(String r100);

    Fragment j1(m r100, Boolean r101);

    boolean k1(Uri r100);

    Fragment l1(Bundle r100);

    Fragment m1(boolean r100);

    void n1(FragmentManager r100, List r101, int r102, p r103, q r104);

    Object o1(String r100, Continuation<? super UserCreation> r101);

    Object p1(String r100, Continuation<? super String> r101);

    a q1();

    void r1();

    Object s1(String r100, Continuation<? super Unit> r101);

    a t1();

    void u1();

    n v1(int r100, TabItemInfo r101, String r102, String r103, CreationFeedCacheEntity r104, String r105, boolean r106, c r107);

    BaseContentWidget w1();

    void x1(int r100, k1.a r101, Function1 r102);
}
