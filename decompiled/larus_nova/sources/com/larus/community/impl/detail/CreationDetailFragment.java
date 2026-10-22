package com.larus.community.impl.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.community.api.spi.ICommunityHostBehaviorProvider;
import com.larus.community.impl.adapter.LoadingItemDecoration;
import com.larus.community.impl.databinding.LarusCommunityCreationDetailPageBinding;
import com.larus.community.impl.detail.bottomtools.CreationDetailBottomToolsView;
import com.larus.community.impl.detail.bottomtools.CreationDetailBottomToolsViewV2;
import com.larus.community.impl.detail.header.CreationDetailCommentViewHolder;
import com.larus.community.impl.detail.header.CreationDetailHeadInspirationViewHolder;
import com.larus.community.impl.detail.image.CreationDetailImageView;
import com.larus.community.impl.detail.image.CreationFullscreenImageViewer;
import com.larus.community.impl.detail.loading.CreationDetailLoadingView;
import com.larus.community.impl.detail.prompt.CreationDetailPromptView;
import com.larus.community.impl.detail.toptools.CreationDetailTopToolsView;
import com.larus.community.impl.detail.video.CreationDetailVideoView;
import com.larus.community.impl.repository.CommunityCreationRecommendRepository;
import com.larus.community.impl.view.ViewPager2FixScrollableLayout;
import com.larus.nova.R;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.CreationCommunityInfo;
import com.larus.platform.api.creation.CreationLikeInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.model.comment.ICommentService;
import com.larus.platform.model.comment.api.CommentHttpApi$GetCommentListData;
import com.larus.platform.model.comment.api.CommentItemCustomType;
import com.larus.platform.model.comment.api.CommentScrollToIndexType;
import com.larus.platform.model.creation.ResourceExt;
import com.larus.platform.service.e2;
import com.larus.platform.service.z2;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttvideoengine.model.VideoRef;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 x2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001xB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0016J&\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010G\u001a\u00020<H\u0016J\b\u0010H\u001a\u00020<H\u0016J\u0010\u0010I\u001a\u00020<2\u0006\u0010J\u001a\u00020\rH\u0002J\u001a\u0010K\u001a\u00020<2\u0006\u0010L\u001a\u00020@2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0010\u0010M\u001a\u00020<2\b\u0010N\u001a\u0004\u0018\u00010OJ\u0012\u0010P\u001a\u00020<2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J4\u0010Q\u001a\u0016\u0012\f\u0012\n\u0018\u00010Sj\u0004\u0018\u0001`T\u0012\u0004\u0012\u00020\u000b0R2\u0006\u0010U\u001a\u00020\r2\u000e\u0010V\u001a\n\u0018\u00010Sj\u0004\u0018\u0001`TH\u0002J\b\u0010Z\u001a\u00020<H\u0002J\b\u0010[\u001a\u00020<H\u0002J\b\u0010\\\u001a\u00020\u000bH\u0016J\b\u0010]\u001a\u00020\rH\u0016J\u0006\u0010^\u001a\u00020<J\b\u0010_\u001a\u00020<H\u0002J\b\u0010`\u001a\u00020\u000bH\u0016J\b\u0010a\u001a\u00020<H\u0002J\b\u0010g\u001a\u00020<H\u0016J\b\u0010h\u001a\u00020<H\u0016J\b\u0010i\u001a\u00020\u000bH\u0016J\b\u0010j\u001a\u00020\u000bH\u0016J\b\u0010k\u001a\u00020\u000bH\u0016J\b\u0010n\u001a\u00020<H\u0002J\b\u0010t\u001a\u00020<H\u0002J\u0010\u0010v\u001a\u00020<2\u0006\u0010w\u001a\u00020\u000bH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u0004\u0018\u00010\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u001d\u0010+\u001a\u0004\u0018\u00010,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b-\u0010.R\u001d\u00100\u001a\u0004\u0018\u0001018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010*\u001a\u0004\b2\u00103R\u001d\u00105\u001a\u0004\u0018\u0001068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010*\u001a\u0004\b7\u00108R\u000e\u0010:\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Y0XX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010b\u001a\u00020c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u0010*\u001a\u0004\bd\u0010eR\u000e\u0010l\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010o\u001a\u00020p8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bs\u0010*\u001a\u0004\bq\u0010rR\u000e\u0010u\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006y"}, d2 = {"Lcom/larus/community/impl/detail/CreationDetailFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/community/impl/detail/CreationDetailFragmentAbility;", "Lcom/larus/community/api/spi/ICommunityDetailActivityResultHandler;", "<init>", "()V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreationDetailPageBinding;", "trackParams", "Lcom/larus/platform/api/creation/CreationFeedTrackParams;", "canShowInspirationList", "", "anchorCommentId", "", "gson", "Lcom/google/gson/Gson;", "directUseTemplate", "creationFeedAbility", "Lcom/larus/platform/api/creation/ICreationFeedAbility;", "getCreationFeedAbility", "()Lcom/larus/platform/api/creation/ICreationFeedAbility;", "creationDetailBottomToolsAbility", "Lcom/larus/community/impl/detail/bottomtools/CreationDetailBottomToolsAbility;", "getCreationDetailBottomToolsAbility", "()Lcom/larus/community/impl/detail/bottomtools/CreationDetailBottomToolsAbility;", "creationDetailPromptAbility", "Lcom/larus/community/impl/detail/prompt/CreationDetailPromptAbility;", "getCreationDetailPromptAbility", "()Lcom/larus/community/impl/detail/prompt/CreationDetailPromptAbility;", "creationDetailCommentAbility", "Lcom/larus/community/impl/detail/comment/CreationDetailCommentAbility;", "getCreationDetailCommentAbility", "()Lcom/larus/community/impl/detail/comment/CreationDetailCommentAbility;", "creationDetailFullImageAbility", "Lcom/larus/community/impl/detail/image/CreationDetailFullImageAbility;", "getCreationDetailFullImageAbility", "()Lcom/larus/community/impl/detail/image/CreationDetailFullImageAbility;", "creationDetailTopToolsAbility", "Lcom/larus/community/impl/detail/toptools/CreationDetailTopToolsAbility;", "getCreationDetailTopToolsAbility", "()Lcom/larus/community/impl/detail/toptools/CreationDetailTopToolsAbility;", "creationDetailTopToolsAbility$delegate", "Lkotlin/Lazy;", "creationDetailImageAbility", "Lcom/larus/community/impl/detail/image/CreationDetailImageAbility;", "getCreationDetailImageAbility", "()Lcom/larus/community/impl/detail/image/CreationDetailImageAbility;", "creationDetailImageAbility$delegate", "creationDetailVideoAbility", "Lcom/larus/community/impl/detail/video/CreationDetailVideoAbility;", "getCreationDetailVideoAbility", "()Lcom/larus/community/impl/detail/video/CreationDetailVideoAbility;", "creationDetailVideoAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "enableMixSkillIntercept", "onAttach", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "updateRootBottomPadding", "source", "onViewCreated", "view", "handleActivityResult", "data", "Landroid/content/Intent;", "handleCommunityActivityResult", "interceptByMixInstructionItem", "Lkotlin/Pair;", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "Lcom/larus/bmhome/view/actionbar/custom/bean/CustomActionBarItem;", "botId", "defaultInstructionItem", "tvCommentTitleRef", "Ljava/lang/ref/WeakReference;", "Landroid/widget/TextView;", "bindVideoOrImageComponent", "setupViewTreeObserver", "autoLogEnterPage", "getCurrentPageName", "onBackPressed", "bindToVContext", "autoUseTemplate", "attachComponent", "headerCreator", "Lcom/larus/platform/api/creation/ICreationFeedHeaderCreator;", "getHeaderCreator", "()Lcom/larus/platform/api/creation/ICreationFeedHeaderCreator;", "headerCreator$delegate", "quit", "checkPromptToolsViewVisibility", "isShowInspiration", "isShowComment", "hasExtraContentList", "lastScrollTime", "", "updateScrollTimestamp", "screenHalfHeight", "", "getScreenHalfHeight", "()I", "screenHalfHeight$delegate", "setupFeedScrollMonitoring", "hasShownComment", "trackCommentComponentShow", "fromOnResume", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailFragment extends TraceFragment implements c0, e29.f {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f329160u = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LarusCommunityCreationDetailPageBinding f329161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public zp9.g f329162f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f329163g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f329164h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Gson f329165i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f329166j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f329167k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f329168l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f329169m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f329170n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f329171o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public WeakReference<TextView> f329172p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f329173q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f329174r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f329175s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f329176t;

    public static final class a {
    }

    public static final class b implements zs8.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CreationDetailFragment f329177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ z0 f329178b;

        @Override // zs8.a
        public final String Y1() {
            return null;
        }

        @Override // zs8.a
        public final String a() {
            return null;
        }

        @Override // zs8.a
        public final String c() {
            return null;
        }

        @Override // zs8.a
        public final String d() {
            return null;
        }

        @Override // zs8.a
        public final String e() {
            return null;
        }

        @Override // zs8.a
        public final String f() {
            return null;
        }

        @Override // zs8.a
        public final String g() {
            return null;
        }

        @Override // zs8.a
        public final String getTemplateType() {
            return null;
        }

        @Override // zs8.a
        public final String h() {
            return null;
        }

        @Override // zs8.a
        public final String i() {
            return null;
        }

        @Override // zs8.a
        public final String j() {
            return null;
        }

        @Override // zs8.a
        public final String k() {
            return null;
        }

        @Override // zs8.a
        public final boolean l() {
            return false;
        }

        @Override // zs8.a
        public final String m() {
            return null;
        }

        @Override // zs8.a
        public final String n() {
            return null;
        }

        @Override // zs8.a
        public final String o() {
            return null;
        }

        @Override // zs8.a
        public final String p() {
            return null;
        }

        @Override // zs8.a
        public final String b() {
            zp9.g r100 = this.f329177a.f329162f;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.f573254h;
        }

        @Override // zs8.a
        public final String getBotId() {
            zp9.g r100 = this.f329177a.f329162f;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.f573249c;
        }

        @Override // zs8.a
        public final String getChatType() {
            zp9.g r100 = this.f329177a.f329162f;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.f573252f;
        }

        @Override // zs8.a
        public final String getClickFrom() {
            com.larus.bmhome.actionbar.model.r r100 = this.f329178b.f295621q;
            if (r100 != null) goto L7;
            return "";
        L7:
            return r100.b();
        }

        @Override // zs8.a
        public final String getEnterMethod() {
            zp9.g r100 = this.f329177a.f329162f;
            if (r100 == null) goto L6;
            String r101 = r100.f573255i;
            if (r101 == null) goto L6;
            return r101;
        L6:
            return "";
        }

        public b(CreationDetailFragment r100, z0 r101) {
            this.f329177a = r100;
            this.f329178b = r101;
        }
    }

    public static final class c implements zp9.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CreationDetailFragment f329179a;

        public c(CreationDetailFragment r100) {
            this.f329179a = r100;
        }

        @Override // zp9.p
        public final CreationDetailHeadInspirationViewHolder a(ViewGroup r110) {
            Intrinsics.checkNotNullParameter(r110, "parent");
            View r100 = LayoutInflater.from(this.f329179a.getContext()).inflate(R.layout.larus_community_creation_detail_inspiration_header_layout, r110, false);
            CreationDetailFragment r111 = this.f329179a;
            int r101 = CreationDetailFragment.f329160u;
            com.larus.community.impl.detail.prompt.a r102 = r111.X90();
            com.larus.community.impl.detail.image.d r103 = (com.larus.community.impl.detail.image.d) this.f329179a.f329168l.getValue();
            com.larus.community.impl.detail.image.a r104 = this.f329179a.W90();
            com.larus.community.impl.detail.video.a r105 = (com.larus.community.impl.detail.video.a) this.f329179a.f329169m.getValue();
            Intrinsics.checkNotNull(r100);
            return new CreationDetailHeadInspirationViewHolder(r103, r102, r104, r105, r100);
        }
    }

    public static final class d implements rq9.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CreationDetailFragment f329180a;

        public d(CreationDetailFragment r100) {
            this.f329180a = r100;
        }

        @Override // rq9.g
        public final CreationDetailCommentViewHolder a(ViewGroup r110) {
            Intrinsics.checkNotNullParameter(r110, "parent");
            View r100 = LayoutInflater.from(this.f329180a.getContext()).inflate(R.layout.larus_community_creation_detail_comment_header_layout, r110, false);
            CreationDetailFragment r111 = this.f329180a;
            if (r100 == null) goto L5;
            TextView r101 = (TextView) r100.findViewById(R.id.tv_comment_title);
        L6:
            r111.f329172p = new WeakReference(r101);
            com.larus.community.impl.detail.prompt.a r102 = this.f329180a.X90();
            com.larus.community.impl.detail.image.d r103 = (com.larus.community.impl.detail.image.d) this.f329180a.f329168l.getValue();
            com.larus.community.impl.detail.image.a r104 = this.f329180a.W90();
            com.larus.community.impl.detail.video.a r105 = (com.larus.community.impl.detail.video.a) this.f329180a.f329169m.getValue();
            CreationDetailFragment r112 = this.f329180a;
            r112.getClass();
            com.larus.community.impl.detail.comment.a r106 = (com.larus.community.impl.detail.comment.a) s1a.a.g(r112).getAbility(com.larus.community.impl.detail.comment.a.class);
            Intrinsics.checkNotNull(r100);
            return new CreationDetailCommentViewHolder(r103, r102, r104, r105, r106, r100);
        L5:
            r101 = null;
            goto L6
        }
    }

    public static final class e implements rq9.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CreationDetailFragment f329181a;

        @Override // rq9.c
        public final void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "draft");
        }

        public e(CreationDetailFragment r100) {
            this.f329181a = r100;
        }

        @Override // rq9.c
        public final void a(long r100) {
            CreationDetailFragment r101 = this.f329181a;
            int r102 = CreationDetailFragment.f329160u;
            r101.getClass();
            com.larus.community.impl.detail.comment.a r103 = (com.larus.community.impl.detail.comment.a) s1a.a.g(r101).getAbility(com.larus.community.impl.detail.comment.a.class);
            if (r103 == null) goto L5;
            r103.g4(r100);
        L5:
            com.larus.community.impl.detail.bottomtools.a r104 = this.f329181a.V90();
            if (r104 == null) goto L9;
            r104.g4(r100);
            return;
        }

        @Override // rq9.c
        public final void c(RecyclerView r100) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            CreationDetailFragment r101 = this.f329181a;
            int r102 = CreationDetailFragment.f329160u;
            r101.aa0(false);
        }
    }

    public static final class f implements rq9.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CreationDetailFragment f329182a;

        @Override // rq9.d
        public final String b() {
            return "";
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.community.impl.detail.b0] */
        @Override // rq9.d
        public final Map<CommentItemCustomType, rq9.e> d() {
            CommentItemCustomType r100 = CommentItemCustomType.FAIL;
            final CreationDetailFragment r101 = this.f329182a;
            return MapsKt.mapOf(new Pair[]{TuplesKt.to(CommentItemCustomType.EMPTY, new com.larus.community.impl.detail.comment.d()), TuplesKt.to(r100, new com.larus.community.impl.detail.comment.f(new b0(r101)))});
        }

        @Override // rq9.d
        public final boolean e() {
            return false;
        }

        @Override // rq9.d
        public final Integer g() {
            return -1;
        }

        @Override // rq9.d
        public final boolean h() {
            return false;
        }

        @Override // rq9.d
        public final boolean j() {
            return false;
        }

        @Override // rq9.d
        public final CommentHttpApi$GetCommentListData m() {
            return null;
        }

        @Override // rq9.d
        public final int p() {
            return 0;
        }

        @Override // rq9.d
        public final String q() {
            return "PROFILE_CREATION_LIST_PUBLIC";
        }

        @Override // rq9.d
        public final String a() {
            return this.f329182a.f329164h;
        }

        @Override // rq9.d
        public final String c() {
            j29.c r100 = (j29.c) s1a.a.g(this.f329182a).a(j29.c.class);
            if (r100 == null) goto L9;
            UserCreation r101 = r100.f497042a;
            if (r101 == null) goto L9;
            AuthorInfo r102 = r101.f364993g;
            if (r102 == null) goto L9;
            return r102.f364897b;
        L9:
            return null;
        }

        @Override // rq9.d
        public final long f() {
            j29.c r100 = (j29.c) s1a.a.g(this.f329182a).a(j29.c.class);
            if (r100 == null) goto L11;
            UserCreation r101 = r100.f497042a;
            if (r101 == null) goto L11;
            CreationCommunityInfo r102 = r101.f364997k;
            if (r102 == null) goto L11;
            Long r103 = r102.f364908b;
            if (r103 == null) goto L11;
            return r103.longValue();
        L11:
            return 0;
        }

        @Override // rq9.d
        public final String i() {
            j29.c r100 = (j29.c) s1a.a.g(this.f329182a).a(j29.c.class);
            if (r100 == null) goto L9;
            UserCreation r101 = r100.f497042a;
            if (r101 == null) goto L9;
            UserCreationTrackParams r102 = r101.f365000n;
            if (r102 == null) goto L9;
            return r102.f365040a;
        L9:
            return null;
        }

        @Override // rq9.d
        public final String k() {
            zp9.g r100 = this.f329182a.f329162f;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.f573248b;
        }

        @Override // rq9.d
        public final Boolean l() {
            boolean r100 = v19.h.f552477a;
            return Boolean.valueOf(v19.h.a(null));
        }

        @Override // rq9.d
        public final Integer o() {
            return Integer.valueOf(R.color.larus_base_1);
        }

        @Override // rq9.d
        public final CommentScrollToIndexType n() {
            return CommentScrollToIndexType.CURRENT;
        }

        public f(CreationDetailFragment r100) {
            this.f329182a = r100;
        }
    }

    public static final class g implements rq9.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CreationDetailFragment f329183a;

        @Override // rq9.f
        public final Pair<String, JSONObject> b() {
            JSONObject r100 = new JSONObject();
            r100.put("comment_method", "post_comment");
            return new Pair("delete_ai_creation_comment", r100);
        }

        @Override // rq9.f
        public final Pair d() {
            JSONObject r100 = new JSONObject();
            r100.put("comment_method", "post_comment");
            return new Pair("ai_creation_comment_show", r100);
        }

        @Override // rq9.f
        public final Pair<String, JSONObject> e() {
            JSONObject r100 = new JSONObject();
            r100.put("comment_method", "post_comment");
            return new Pair("comment_ai_creation", r100);
        }

        @Override // rq9.f
        public final JSONObject f() {
            j29.c r100 = (j29.c) s1a.a.g(this.f329183a).a(j29.c.class);
            Integer r101 = null;
            if (r100 == null) goto L5;
            UserCreation r102 = r100.f497042a;
        L6:
            JSONObject r103 = new JSONObject();
            CreationDetailFragment r104 = this.f329183a;
            zp9.g r105 = r104.f329162f;
            if (r105 == null) goto L9;
            String r106 = r105.f573249c;
        L10:
            r103.put("bot_id", r106);
            zp9.g r107 = r104.f329162f;
            if (r107 == null) goto L13;
            String r108 = r107.f573256j;
        L14:
            r103.put("recommend_from", r108);
            zp9.g r109 = r104.f329162f;
            if (r109 == null) goto L17;
            String r110 = r109.f573255i;
        L18:
            r103.put("enter_method", r110);
            zp9.g r111 = r104.f329162f;
            if (r111 == null) goto L21;
            String r112 = r111.f573247a;
        L22:
            r103.put("current_page", r112);
            zp9.g r113 = r104.f329162f;
            if (r113 == null) goto L25;
            String r114 = r113.f573254h;
        L26:
            r103.put("previous_page", r114);
            zp9.g r115 = r104.f329162f;
            if (r115 == null) goto L29;
            String r116 = r115.f573252f;
        L30:
            r103.put("chat_type", r116);
            zp9.g r117 = r104.f329162f;
            if (r117 == null) goto L33;
            String r118 = r117.f573250d;
        L34:
            r103.put("conversation_id", r118);
            if (r102 == null) goto L37;
            String r119 = r102.f364987a;
        L38:
            r103.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r119);
            if (r102 == null) goto L41;
            String r120 = zp9.d.c(r102);
        L42:
            r103.put("template_sub_type", r120);
            if (r102 == null) goto L47;
            UserCreationTrackParams r121 = r102.f365000n;
            if (r121 == null) goto L47;
            String r122 = r121.f365040a;
        L48:
            r103.put("template_rec_req_id", r122);
            zp9.g r123 = r104.f329162f;
            if (r123 == null) goto L53;
            String r124 = r123.f573263q;
            if (r124 == null) goto L53;
            r103.put("prompt_type", r124);
        L53:
            zp9.g r125 = r104.f329162f;
            if (r125 == null) goto L58;
            String r126 = r125.f573264r;
            if (r126 == null) goto L58;
            r103.put("prompt_from", r126);
        L58:
            zp9.g r127 = r104.f329162f;
            if (r127 == null) goto L63;
            String r128 = r127.f573265s;
            if (r128 == null) goto L63;
            r103.put("visual_size", r128);
        L63:
            if (r102 == null) goto L65;
            String r129 = zp9.d.b(r102);
        L66:
            if (r129 != null) goto L68;
        L71:
            boolean r130 = true;
        L72:
            if (r130 == false) goto L74;
            r129 = "default";
        L74:
            r103.put("template_source", r129);
            if (r102 == null) goto L79;
            Long r131 = r102.f364992f;
            if (r131 == null) goto L79;
            Integer r132 = Integer.valueOf((int) r131.longValue());
        L80:
            r103.put("use_template_uv", r132);
            if (r102 == null) goto L87;
            CreationCommunityInfo r133 = r102.f364997k;
            if (r133 == null) goto L87;
            CreationLikeInfo r134 = r133.f364907a;
            if (r134 == null) goto L87;
            Long r135 = r134.f364919a;
        L88:
            r103.put("like_template_cnt", r135);
            if (r102 == null) goto L93;
            CreationCommunityInfo r136 = r102.f364997k;
            if (r136 == null) goto L93;
            Long r137 = r136.f364908b;
        L94:
            r103.put("comment_template_cnt", r137);
            if (r102 == null) goto L99;
            AuthorInfo r138 = r102.f364993g;
            if (r138 == null) goto L99;
            String r139 = r138.f364897b;
        L100:
            r103.put("creator_id", r139);
            if (r102 == null) goto L105;
            UserCreationTrackParams r140 = r102.f365000n;
            if (r140 == null) goto L105;
            r101 = r140.f365041b;
        L105:
            r103.put("page_index", r101);
            return r103;
        L99:
            r139 = null;
        L93:
            r137 = null;
        L87:
            r135 = null;
        L79:
            r132 = null;
            goto L80
        L68:
            if (r129.length() == 0) goto L71;
            r130 = false;
            goto L72
        L65:
            r129 = null;
        L47:
            r122 = null;
            goto L48
        L41:
            r120 = null;
            goto L42
        L37:
            r119 = null;
            goto L38
        L33:
            r118 = null;
            goto L34
        L29:
            r116 = null;
            goto L30
        L25:
            r114 = null;
            goto L26
        L21:
            r112 = null;
            goto L22
        L17:
            r110 = null;
            goto L18
        L13:
            r108 = null;
            goto L14
        L9:
            r106 = null;
            goto L10
        L5:
            r102 = null;
            goto L6
        }

        @Override // rq9.f
        public final Pair<String, JSONObject> g() {
            JSONObject r100 = new JSONObject();
            r100.put("comment_method", "post_comment");
            return new Pair("copy_ai_creation_comment", r100);
        }

        @Override // rq9.f
        public final Pair h() {
            return new Pair("comment_ai_creation_board_collapse", new JSONObject());
        }

        @Override // rq9.f
        public final Pair<String, JSONObject> i() {
            JSONObject r100 = new JSONObject();
            r100.put("comment_method", "post_comment");
            return new Pair("confirm_delete_ai_creation_comment", r100);
        }

        @Override // rq9.f
        public final Pair<String, JSONObject> j() {
            JSONObject r100 = new JSONObject();
            r100.put("comment_method", "post_comment");
            return new Pair("like_ai_creation_comment", r100);
        }

        @Override // rq9.f
        public final Pair<String, JSONObject> k() {
            JSONObject r100 = new JSONObject();
            r100.put("comment_method", "post_comment");
            return new Pair("unlike_ai_creation_comment", r100);
        }

        @Override // rq9.f
        public final Pair<String, JSONObject> l() {
            JSONObject r100 = new JSONObject();
            r100.put("comment_method", "post_comment");
            return new Pair("long_press_ai_creation_comment", r100);
        }

        @Override // rq9.f
        public final Pair<String, JSONObject> m() {
            return new Pair("click_comment_ai_creation_input", new JSONObject());
        }

        @Override // rq9.f
        public final Pair<String, JSONObject> n() {
            return new Pair("slide_comment_ai_creation", new JSONObject());
        }

        @Override // rq9.f
        public final Pair<String, JSONObject> o() {
            JSONObject r100 = new JSONObject();
            r100.put("comment_method", "post_comment");
            return new Pair("report_ai_creation_comment", r100);
        }

        public g(CreationDetailFragment r100) {
            this.f329183a = r100;
        }

        @Override // rq9.f
        public final Pair<String, JSONObject> a(long r100) {
            JSONObject r101 = new JSONObject();
            r101.put("total_comment_cnt", (int) r100);
            return new Pair("comment_ai_creation_board_show", r101);
        }

        @Override // rq9.f
        public final void c(Pair<String, ? extends JSONObject> r100) {
            Intrinsics.checkNotNullParameter(r100, "pair");
        }
    }

    static {
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public final boolean S90() {
        return false;
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "template_detail_page";
    }

    public static boolean Z90() {
        if (z2.f365865a.getCreationCommentConfig().a() == true) goto L5;
    L7:
        return false;
    L5:
        if (ServiceManager.get().getService(ICommentService.class) == null) goto L7;
        return true;
    }

    @Override // com.larus.community.impl.detail.c0
    public final void quit() {
        int r100 = e29.d.f470843a;
        Intrinsics.checkNotNullParameter(this, WidgetService.PARAM_FRAGMENT);
        ICommunityHostBehaviorProvider r101 = e29.d.c();
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.f(this) != true) goto L7;
    L8:
        if (r102 == false) goto L10;
        return;
    L10:
        FragmentActivity r103 = getActivity();
        if (r103 == null) goto L14;
        r103.finish();
        return;
    L14:
        return;
    L7:
        r102 = false;
        goto L8
    }

    @Override // com.larus.community.impl.detail.c0
    public final boolean yN() {
        if (z2.f365865a.f1().h() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f329163g == false) goto L7;
        return true;
    }

    public CreationDetailFragment() {
        this.f329163g = true;
        this.f329165i = new Gson();
        this.f329167k = LazyKt.lazy(new t(this));
        this.f329168l = LazyKt.lazy(new u(this));
        this.f329169m = LazyKt.lazy(new v(this));
        this.f329170n = LazyKt.lazy(new w(this));
        this.f329171o = z2.f365865a.getCreationMakeSameConfigV2().a();
        this.f329172p = new WeakReference(null);
        this.f329173q = LazyKt.lazy(new x(this));
        this.f329175s = LazyKt.lazy(new y(this));
    }

    public final void U90() {
        com.larus.community.impl.detail.prompt.a r100 = X90();
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L18;
        com.larus.community.impl.detail.bottomtools.a r103 = V90();
        if (r103 != null) goto L12;
    L14:
        if (r101 == false) goto L31;
        com.larus.community.impl.detail.bottomtools.a r104 = V90();
        if (r104 == null) goto L32;
        r104.Hp();
        return;
    L32:
        return;
    L31:
        return;
    L12:
        if (r103.sO() != true) goto L14;
        r101 = true;
        goto L14
    L18:
        com.larus.community.impl.detail.bottomtools.a r105 = V90();
        if (r105 != null) goto L21;
    L23:
        if (r101 == false) goto L34;
        long r106 = System.currentTimeMillis() - this.f329174r;
        if (r106 <= 30) goto L29;
        com.larus.community.impl.detail.bottomtools.a r107 = V90();
        if (r107 == null) goto L35;
        r107.Cr();
        return;
    L35:
        return;
    L29:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationDetailFragment$checkPromptToolsViewVisibility$1(r106, this, null), 3, null);
        return;
    L34:
        return;
    L21:
        if (r105.sO() == true) goto L23;
        r101 = true;
        goto L23
    L5:
        if (r100.vG() != true) goto L7;
        r102 = true;
        goto L8
    }

    public final com.larus.community.impl.detail.bottomtools.a V90() {
        return (com.larus.community.impl.detail.bottomtools.a) s1a.a.g(this).getAbility(com.larus.community.impl.detail.bottomtools.a.class);
    }

    public final com.larus.community.impl.detail.image.a W90() {
        return (com.larus.community.impl.detail.image.a) s1a.a.g(this).getAbility(com.larus.community.impl.detail.image.a.class);
    }

    public final com.larus.community.impl.detail.prompt.a X90() {
        return (com.larus.community.impl.detail.prompt.a) s1a.a.g(this).getAbility(com.larus.community.impl.detail.prompt.a.class);
    }

    @Override // com.larus.community.impl.detail.c0
    public final boolean ak() {
        if (yN() == false) goto L5;
    L8:
        return true;
    L5:
        if (Z90() == true) goto L8;
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        fnc.a r100 = (fnc.a) s1a.a.g(this).getAbility(fnc.a.class);
        if (r100 == null) goto L6;
        r100.SN();
        return;
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        LarusCommunityCreationDetailPageBinding r100 = this.f329161e;
        if (r100 == null) goto L7;
        ConstraintLayout r101 = r100.f329058j;
        if (r101 == null) goto L7;
        r101.post(new a0(this));
    L7:
        LarusCommunityCreationDetailPageBinding r102 = this.f329161e;
        if (r102 == null) goto L12;
        ConstraintLayout r103 = r102.f329058j;
        if (r103 == null) goto L12;
        i0.f375410a.getClass();
        int r104 = i0.g();
        int r105 = r103.getPaddingStart();
        int r106 = r103.getPaddingEnd();
        int r107 = r103.getPaddingBottom();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r103.getClass().getSimpleName() + ",source:,start:" + r105 + ",top:" + r104 + ",end:" + r106 + ",bottom:" + r107);
        r103.setPaddingRelative(r105, r104, r106, r107);
    L12:
        LarusCommunityCreationDetailPageBinding r108 = this.f329161e;
        if (r108 == null) goto L17;
        ConstraintLayout r109 = r108.f329058j;
        if (r109 == null) goto L17;
        r109.post(new com.larus.community.impl.detail.c(this));
    L17:
        LarusCommunityCreationDetailPageBinding r110 = this.f329161e;
        if (r110 == null) goto L23;
        final ConstraintLayout r111 = r110.f329058j;
        if (r111 == null) goto L24;
        ViewCompat.setOnApplyWindowInsetsListener(r111, new com.larus.community.impl.detail.d(r111, this));
        return;
    L24:
        return;
    }

    @Override // com.larus.community.impl.detail.c0
    public final boolean nk() {
        return this.f329166j;
    }

    public final void Y90(Intent r710) {
        AuthModelDelegate r100 = AuthModelDelegate.f297134b;
        com.larus.bmhome.chat.api.e0 r101 = r100.e().getValue();
        String r102 = "7234781073513644036";
        if (r101 == null) goto L8;
        LaunchInfo r103 = r101.f297186a;
        if (r103 == null) goto L8;
        String r104 = r103.W();
        if (r104 == null) goto L8;
    L9:
        zp9.g r105 = this.f329162f;
        if (r105 == null) goto L15;
        String r106 = r105.f573249c;
        if (r106 == null) goto L15;
        String r107 = r106;
    L16:
        if (r105 == null) goto L18;
        String r108 = r105.f573250d;
    L19:
        if (r710 == null) goto L22;
        String r109 = r710.getStringExtra("ipa_main_url");
        if (r109 == null) goto L22;
    L23:
        boolean r110 = true;
        if (r109.length() != 0) goto L26;
        boolean r111 = true;
    L27:
        if (r111 == false) goto L29;
        return;
    L29:
        if (r710 == null) goto L31;
        Boolean r112 = Boolean.valueOf(r710.getBooleanExtra("key_is_creation_private", false));
    L32:
        Boolean r113 = Boolean.TRUE;
        boolean r114 = Intrinsics.areEqual(r112, r113);
        if (r710 == null) goto L35;
        int r115 = r710.getIntExtra("select_instruction_type", 4);
    L36:
        z0 r116 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(r115);
        if (this.f329171o == true) goto L39;
        Pair r117 = new Pair(r116, r113);
    L54:
        z0 r118 = (z0) r117.getFirst();
        View r119 = getView();
        if (r119 == null) goto L57;
        r119.postDelayed(new com.larus.community.impl.detail.g(this), 200);
    L57:
        if (r710 == null) goto L59;
        String r120 = r710.getStringExtra("key_video_internal_resource");
    L60:
        if (r118 == null) goto L99;
        if (r710 == null) goto L63;
        ArrayList r121 = r710.getParcelableArrayListExtra("avatar_ref_image");
    L64:
        IUgcAIGCService.Companion r122 = IUgcAIGCService.f373945a;
        FragmentActivity r123 = requireActivity();
        ArrayList r124 = r121;
        int r210 = r115;
        ChatParam r211 = new ChatParam(r108, r107, null, null, null, 252);
        List r212 = CollectionsKt.listOf(r109);
        if (r710 == null) goto L67;
        String r125 = r710.getStringExtra("avatar_dosame_default_prompt");
    L68:
        if (r124 == null) goto L83;
        Intrinsics.checkNotNullParameter(r124, "<this>");
        Iterator r126 = r124.iterator();
    L71:
        if (r126.hasNext() == false) goto L81;
        String r127 = sq9.g.e((ResourceExt) r126.next());
        if (r127 != null) goto L75;
    L78:
        boolean r128 = true;
    L79:
        if (r128 == true) goto L71;
        String r213 = r127;
    L82:
        String r214 = r213;
    L84:
        b r129 = new b(this, r118);
        LinkedHashMap r130 = new LinkedHashMap();
        if (r120 != null) goto L87;
    L89:
        r110 = false;
    L90:
        if (r110 == false) goto L92;
        r130.put("internal_resources", r120);
    L92:
        String r215 = r125;
        Boolean r510 = r112;
        r122.W(new ny9.b(true, r123, r118, r211, true, false, null, r215, r214, null, r124, r212, null, Integer.valueOf(r210), null, null, null, null, null, false, false, r129, null, null, false, r130, null, null, false, null, false, null, Boolean.valueOf(r114), r510, Boolean.FALSE, null, null, null, null, null, null, Boolean.TRUE, null, null, null, null, null, null, null, false, -35663264, 261624));
        return;
    L87:
        if (o0.d(r120) != true) goto L89;
    L75:
        if (r127.length() == 0) goto L78;
        r128 = false;
        goto L79
    L81:
        r213 = null;
        goto L82
    L83:
        r214 = null;
        goto L84
    L67:
        r125 = null;
        goto L68
    L63:
        r121 = null;
        goto L64
    L99:
        return;
    L59:
        r120 = null;
        goto L60
    L39:
        com.larus.bmhome.chat.api.e0 r131 = r100.e().getValue();
        if (r131 == null) goto L48;
        LaunchInfo r132 = r131.f297186a;
        if (r132 == null) goto L48;
        String r133 = r132.W();
        if (r133 == null) goto L48;
        r102 = r133;
    L48:
        if (Intrinsics.areEqual(r107, r102) == true) goto L50;
        r117 = new Pair(r116, r113);
        goto L54
    L50:
        z0 r134 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(28);
        if (r134 == null) goto L53;
        r117 = new Pair(r134, Boolean.FALSE);
        goto L54
    L53:
        r117 = new Pair(r116, r113);
        goto L54
    L35:
        r115 = 4;
        goto L36
    L31:
        r112 = null;
        goto L32
    L26:
        r111 = false;
    L22:
        r109 = "";
        goto L23
    L18:
        r108 = null;
    L15:
        r107 = r104;
    L8:
        r104 = "7234781073513644036";
        goto L9
    }

    public final void aa0(boolean r100) {
        if (Z90() == true) goto L5;
        return;
    L5:
        long r101 = 0;
        if (this.f329176t == false) goto L21;
        if (r100 == false) goto L50;
        fnc.a r102 = (fnc.a) s1a.a.g(this).getAbility(fnc.a.class);
        if (r102 == null) goto L51;
        j29.c r103 = (j29.c) s1a.a.g(this).a(j29.c.class);
        if (r103 == null) goto L19;
        UserCreation r104 = r103.f497042a;
        if (r104 == null) goto L19;
        CreationCommunityInfo r105 = r104.f364997k;
        if (r105 == null) goto L19;
        Long r106 = r105.f364908b;
        if (r106 == null) goto L19;
        r101 = r106.longValue();
    L19:
        r102.vz(r101);
        return;
    L51:
        return;
    L50:
        return;
    L21:
        WeakReference<TextView> r107 = this.f329172p;
        if (r107 == null) goto L52;
        TextView r108 = r107.get();
        if (r108 == null) goto L56;
        int[] r109 = new int[2];
        r108.getLocationOnScreen(r109);
        LarusCommunityCreationDetailPageBinding r110 = this.f329161e;
        if (r110 == null) goto L53;
        CreationDetailBottomToolsView r111 = r110.f329051c;
        if (r111 == null) goto L57;
        int[] r112 = new int[2];
        r111.getLocationOnScreen(r112);
        boolean r113 = true;
        if (r109[1] < r112[1]) goto L35;
        r113 = false;
    L35:
        this.f329176t = r113;
        if (r113 == false) goto L54;
        fnc.a r114 = (fnc.a) s1a.a.g(this).getAbility(fnc.a.class);
        if (r114 == null) goto L55;
        j29.c r115 = (j29.c) s1a.a.g(this).a(j29.c.class);
        if (r115 == null) goto L48;
        UserCreation r116 = r115.f497042a;
        if (r116 == null) goto L48;
        CreationCommunityInfo r117 = r116.f364997k;
        if (r117 == null) goto L48;
        Long r118 = r117.f364908b;
        if (r118 == null) goto L48;
        r101 = r118.longValue();
    L48:
        r114.vz(r101);
        return;
    L55:
        return;
    L54:
        return;
    L57:
        return;
    L53:
        return;
    L56:
        return;
    }

    public final void ba0(String r100) {
        LarusCommunityCreationDetailPageBinding r101 = this.f329161e;
        if (r101 == null) goto L18;
        ConstraintLayout r102 = r101.f329058j;
        if (r102 == null) goto L19;
        FragmentActivity r103 = getActivity();
        if ((r103 instanceof FragmentActivity) == true) goto L11;
        r103 = null;
    L11:
        if (r103 != null) goto L13;
        return;
    L13:
        i0.f375410a.getClass();
        int r104 = Math.min(i0.c(r103), i0.e());
        int r105 = e29.d.f470843a;
        Intrinsics.checkNotNullParameter(this, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "rootView");
        ICommunityHostBehaviorProvider r106 = e29.d.c();
        if (r106 == null) goto L16;
        r104 = r106.u(this, r102, r104);
    L16:
        int r107 = r102.getPaddingStart();
        int r108 = r102.getPaddingTop();
        int r109 = r102.getPaddingEnd();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r102.getClass().getSimpleName() + ",source:" + r100 + ",start:" + r107 + ",top:" + r108 + ",end:" + r109 + ",bottom:" + r104);
        r102.setPaddingRelative(r107, r108, r109, r104);
        return;
    L19:
        return;
    }

    @Override // e29.f
    public final void j6(Intent r100) {
        Y90(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r210) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r210);
        Bundle r100 = getArguments();
        boolean r101 = true;
        String r102 = null;
        if (r100 == null) goto L19;
        String r103 = r100.getString("creation");
        if (r103 == null) goto L19;
        if ((!StringsKt.isBlank(r103)) == true) goto L10;
        r103 = null;
    L10:
        if (r103 == null) goto L19;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L13
        Object r105 = Result.m9449constructorimpl((UserCreation) xt7.d.f565073b.c(UserCreation.Companion.serializer(), r103));     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r105) == false) goto L18;
        r105 = null;
    L18:
        UserCreation r106 = (UserCreation) r105;
    L20:
        if (r106 == null) goto L22;
        t1a.b r107 = s1a.a.g(this);
        j29.c r108 = j29.c.f497041c;
        Intrinsics.checkNotNullParameter(r106, "creation");
        r107.n(new j29.c(r106, r106.f364987a), j29.c.class);
    L27:
        Bundle r109 = getArguments();
        if (r109 == null) goto L30;
        String r110 = r109.getString("anchor_comment_id");
    L31:
        this.f329164h = r110;
        Gson r111 = this.f329165i;
        Bundle r112 = getArguments();
        if (r112 == null) goto L34;
        r102 = r112.getString("track_params");
    L34:
        zp9.g r113 = (zp9.g) GsonProtectorUtils.fromJson(r111, r102, zp9.g.class);
        if (r113 == null) goto L37;
        String r114 = r113.f573247a;
        String r115 = r113.f573248b;
        String r116 = r113.f573249c;
        String r117 = r113.f573250d;
        Integer r118 = r113.f573251e;
        String r119 = r113.f573252f;
        String r120 = r113.f573253g;
        String r121 = r113.f573255i;
        String r122 = r113.f573256j;
        Boolean r123 = r113.f573257k;
        String r124 = r113.f573258l;
        String r125 = r113.f573259m;
        String r126 = r113.f573260n;
        String r127 = r113.f573261o;
        Boolean r128 = r113.f573262p;
        String r129 = r113.f573263q;
        String r130 = r113.f573264r;
        String r131 = r113.f573265s;
        String r132 = r113.f573266t;
        String r133 = r113.f573267u;
        String r134 = r113.f573268v;
        Intrinsics.checkNotNullParameter("template_detail_page", "currentPage");
        this.f329162f = new zp9.g("template_detail_page", r115, r116, r117, r118, r119, r120, r114, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134);
        t1a.b r135 = s1a.a.g(this);
        int r136 = j29.a.f497037b;
        r135.n(new j29.a(this.f329162f), j29.a.class);
    L37:
        Bundle r137 = getArguments();
        if (r137 == null) goto L40;
        this.f329163g = r137.getBoolean("can_show_inspiration_list", true);
    L40:
        Bundle r138 = getArguments();
        if (r138 != null) goto L43;
    L47:
        s1a.a.g(this).c(this, c0.class);
        k1a.b.a(this, new z(this));
        return;
    L43:
        if (r138.getInt("direct_use_template") == 1) goto L46;
        r101 = false;
    L46:
        this.f329166j = r101;
        goto L47
    L30:
        r110 = null;
        goto L31
    L22:
        Bundle r139 = getArguments();
        if (r139 == null) goto L27;
        String r140 = r139.getString("creation_id");
        if (r140 == null) goto L27;
        t1a.b r141 = s1a.a.g(this);
        j29.c r142 = j29.c.f497041c;
        Intrinsics.checkNotNullParameter(r140, "creationId");
        r141.n(new j29.c(j29.c.f497041c.f497042a, r140), j29.c.class);
    L13:
        th = move-exception;
        Result.Companion r143 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L19:
        r106 = null;
        goto L20
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r410, Bundle r411) {
        Intrinsics.checkNotNullParameter(r410, "view");
        super.onViewCreated(r410, r411);
        if (e2.f365734a.isPad() == false) goto L12;
        int r100 = m0.f375450a;
        float r101 = RangesKt.coerceAtMost(m0.b(getContext()) * 0.75f, c7.c(600));
        LarusCommunityCreationDetailPageBinding r102 = this.f329161e;
        if (r102 == null) goto L12;
        ViewGroup.LayoutParams r103 = r102.f329059k.getLayoutParams();
        if (r103 == null) goto L9;
        r103.width = (int) r101;
    L9:
        ViewGroup.LayoutParams r104 = r102.f329051c.getLayoutParams();
        if (r104 == null) goto L12;
        r104.width = (int) r101;
    L12:
        String r105 = null;
        if (yN() == false) goto L94;
        k1a.b.a(this, new com.larus.community.impl.detail.b(this));
        zp9.l r106 = (zp9.l) s1a.a.g(this).getAbility(zp9.l.class);
        if (r106 == null) goto L76;
        zp9.g r107 = this.f329162f;
        if (r107 == null) goto L19;
        String r110 = r107.f573254h;
    L20:
        if (r107 == null) goto L22;
        String r108 = r107.f573248b;
    L23:
        if (r107 == null) goto L25;
        String r111 = r107.f573255i;
    L26:
        if (r107 == null) goto L28;
        String r109 = r107.f573250d;
    L29:
        if (r107 == null) goto L31;
        String r112 = r107.f573252f;
    L32:
        if (r107 == null) goto L34;
        String r113 = r107.f573249c;
    L35:
        if (r107 == null) goto L37;
        String r114 = r107.f573256j;
    L38:
        if (r114 == null) goto L58;
        int r115 = r114.hashCode();
        if (r115 == (-493995263)) goto L55;
        if (r115 == (-286312810)) goto L51;
        if (r115 != 1708300943) goto L58;
        if (r114.equals("action_bar_template") == false) goto L58;
        r105 = "action_bar_enter_inspiration_feed";
    L61:
        zp9.g r116 = new zp9.g("template_detail_page", r108, r113, r109, null, r112, null, r110, r111, r105, null, null, null, null, null, null, null, null, null, null, null, null, 4193360);
        int r117 = i5.s0();
        Context r118 = getContext();
        float r119 = 200.0f;
        if (r118 == null) goto L64;
        float r120 = c7.d(Integer.valueOf(com.larus.utils.i.d(r118)));
    L65:
        int r121 = 2;
        if (r120 <= 500.0f) goto L68;
        int r122 = 3;
    L69:
        StaggeredGridItemDecoration r123 = new StaggeredGridItemDecoration(r122, c7.b(5), c7.b(5));
        Context r124 = getContext();
        if (r124 == null) goto L73;
        r119 = c7.d(Integer.valueOf(com.larus.utils.i.d(r124)));
    L73:
        if (r119 <= 500.0f) goto L75;
        r121 = 3;
    L75:
        r106.nh(new zp9.f(false, false, "List_Creation_Detail", true, r116, 4, Integer.valueOf(r117), null, false, null, null, false, null, 0, 0, false, null, false, r123, new LoadingItemDecoration(r121, c7.b(5)), false, false, null, null, null, null, null, null, null, null, 1072930691), new zp9.e(new CommunityCreationRecommendRepository(4, null, null, null, ((j29.c) s1a.a.g(this).f(j29.c.class)).f497043b, null, null, null, VideoRef.VALUE_VIDEO_REF_CATEGORY), null, null, null, 14));
        goto L76
    L68:
        r122 = 2;
        goto L69
    L64:
        r120 = 200.0f;
        goto L65
    L51:
        if (r114.equals("personal_homepage_portfolio") == false) goto L58;
        r105 = "personal_homepage_portfolio_inspiration_feed";
        goto L61
    L55:
        if (r114.equals("create_feed") == false) goto L58;
        r105 = "create_feed_enter_inspiration_feed";
    L58:
        zp9.g r125 = this.f329162f;
        if (r125 == null) goto L61;
        r105 = r125.f573256j;
        goto L61
    L37:
        r114 = null;
        goto L38
    L34:
        r113 = null;
        goto L35
    L31:
        r112 = null;
        goto L32
    L28:
        r109 = null;
        goto L29
    L25:
        r111 = null;
        goto L26
    L22:
        r108 = null;
        goto L23
    L19:
        r110 = null;
    L76:
        zp9.l r126 = (zp9.l) s1a.a.g(this).getAbility(zp9.l.class);
        if (r126 == null) goto L79;
        r126.Eo((zp9.p) this.f329173q.getValue());
    L79:
        LarusCommunityCreationDetailPageBinding r127 = this.f329161e;
        if (r127 == null) goto L85;
        final ConstraintLayout r128 = r127.f329049a;
        if (r128 == null) goto L85;
        r128.getViewTreeObserver().addOnGlobalLayoutListener(new CreationDetailFragment$setupViewTreeObserver$1(r128, this));
    L85:
        zp9.l r129 = (zp9.l) s1a.a.g(this).getAbility(zp9.l.class);
        if (r129 == null) goto L88;
        r129.addOnScrollListener(new CreationDetailFragment$setupFeedScrollMonitoring$1(this));
    L88:
        LarusCommunityCreationDetailPageBinding r130 = this.f329161e;
        if (r130 == null) goto L160;
        ScrollView r131 = r130.f329059k;
        if (r131 == null) goto L161;
        e1.o(r131);
        return;
    L161:
        return;
    L160:
        return;
    L94:
        if (Z90() == false) goto L135;
        final ICommentService r132 = (ICommentService) ServiceManager.get().getService(ICommentService.class);
        if (r132 == null) goto L124;
        f r133 = new f(this);
        j29.c r134 = (j29.c) s1a.a.g(this).a(j29.c.class);
        if (r134 == null) goto L105;
        UserCreation r135 = r134.f497042a;
        if (r135 == null) goto L105;
        String r136 = r135.f364987a;
        if (r136 == null) goto L105;
        r105 = r136;
    L108:
        r132.c(this, new rq9.a(r133, new com.larus.community.impl.detail.comment.g(r105), new g(this), new e(this), new d(this)));
        LarusCommunityCreationDetailPageBinding r137 = this.f329161e;
        if (r137 == null) goto L113;
        View r138 = r137.f329060l;
        if (r138 == null) goto L113;
        e1.x(r138);
    L113:
        LarusCommunityCreationDetailPageBinding r139 = this.f329161e;
        if (r139 == null) goto L118;
        CreationDetailBottomToolsViewV2 r140 = r139.f329052d;
        if (r140 == null) goto L118;
        e1.x(r140);
    L118:
        LarusCommunityCreationDetailPageBinding r141 = this.f329161e;
        if (r141 == null) goto L123;
        CreationDetailBottomToolsViewV2 r142 = r141.f329052d;
        if (r142 == null) goto L123;
        r142.R5(r133.f());
    L123:
        k1a.b.a(this, new m(this, r132));
    L105:
        j29.c r143 = (j29.c) s1a.a.g(this).a(j29.c.class);
        if (r143 == null) goto L108;
        r105 = r143.f497043b;
    L124:
        LarusCommunityCreationDetailPageBinding r144 = this.f329161e;
        if (r144 == null) goto L130;
        final ConstraintLayout r145 = r144.f329049a;
        if (r145 == null) goto L130;
        r145.getViewTreeObserver().addOnGlobalLayoutListener(new CreationDetailFragment$setupViewTreeObserver$1(r145, this));
    L130:
        LarusCommunityCreationDetailPageBinding r146 = this.f329161e;
        if (r146 == null) goto L163;
        ScrollView r147 = r146.f329059k;
        if (r147 == null) goto L164;
        e1.o(r147);
        return;
    L164:
        return;
    L163:
        return;
    L135:
        LarusCommunityCreationDetailPageBinding r148 = this.f329161e;
        if (r148 == null) goto L166;
        ConstraintLayout r149 = r148.f329058j;
        if (r149 == null) goto L140;
        r149.setClipChildren(true);
    L140:
        ConstraintLayout r150 = r148.f329058j;
        if (r150 == null) goto L143;
        r150.setClipToPadding(true);
    L143:
        com.larus.community.impl.detail.prompt.a r151 = X90();
        if (r151 == null) goto L146;
        r151.ut(r148.f329056h);
    L146:
        final LarusCommunityCreationDetailPageBinding r152 = this.f329161e;
        if (r152 == null) goto L152;
        com.larus.community.impl.detail.video.a r153 = (com.larus.community.impl.detail.video.a) this.f329169m.getValue();
        if (r153 == null) goto L151;
        r153.jG(r152.f329057i);
    L151:
        r152.f329059k.post(new r(this, r152));
    L152:
        final LarusCommunityCreationDetailPageBinding r154 = this.f329161e;
        if (r154 == null) goto L158;
        com.larus.community.impl.detail.image.d r155 = (com.larus.community.impl.detail.image.d) this.f329168l.getValue();
        if (r155 == null) goto L157;
        r155.P9(r154.f329055g);
    L157:
        r154.f329059k.post(new s(this, r154));
    L158:
        e1.o(r148.f329054f);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r100 = r110.inflate(R.layout.larus_community_creation_detail_page, r111, false);
        int r101 = R.id.bottom_tools_container;
        FrameLayout r102 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.bottom_tools_container);
        if (r102 == null) goto L35;
        r101 = R.id.bottom_tools_view;
        CreationDetailBottomToolsView r103 = (CreationDetailBottomToolsView) ViewBindings.findChildViewById(r100, R.id.bottom_tools_view);
        if (r103 == null) goto L35;
        r101 = R.id.bottom_tools_view_v2;
        CreationDetailBottomToolsViewV2 r104 = (CreationDetailBottomToolsViewV2) ViewBindings.findChildViewById(r100, R.id.bottom_tools_view_v2);
        if (r104 == null) goto L35;
        r101 = R.id.creation_detail_comment_container;
        FrameLayout r105 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.creation_detail_comment_container);
        if (r105 == null) goto L35;
        r101 = R.id.creation_detail_more_inspiration_container;
        FrameLayout r106 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.creation_detail_more_inspiration_container);
        if (r106 == null) goto L35;
        r101 = R.id.fullscreen_viewer;
        if (((CreationFullscreenImageViewer) ViewBindings.findChildViewById(r100, R.id.fullscreen_viewer)) == null) goto L35;
        r101 = R.id.ll_creation_detail_image_view;
        CreationDetailImageView r113 = (CreationDetailImageView) ViewBindings.findChildViewById(r100, R.id.ll_creation_detail_image_view);
        if (r113 == null) goto L35;
        r101 = R.id.ll_creation_detail_prompt_view;
        CreationDetailPromptView r114 = (CreationDetailPromptView) ViewBindings.findChildViewById(r100, R.id.ll_creation_detail_prompt_view);
        if (r114 == null) goto L35;
        r101 = R.id.ll_creation_detail_video_view;
        CreationDetailVideoView r115 = (CreationDetailVideoView) ViewBindings.findChildViewById(r100, R.id.ll_creation_detail_video_view);
        if (r115 == null) goto L35;
        r101 = R.id.loading_view;
        if (((CreationDetailLoadingView) ViewBindings.findChildViewById(r100, R.id.loading_view)) == null) goto L35;
        r101 = R.id.root_container;
        ConstraintLayout r116 = (ConstraintLayout) ViewBindings.findChildViewById(r100, R.id.root_container);
        if (r116 == null) goto L35;
        r101 = R.id.scroll_view;
        ScrollView r117 = (ScrollView) ViewBindings.findChildViewById(r100, R.id.scroll_view);
        if (r117 == null) goto L35;
        r101 = R.id.top_tools_view;
        if (((CreationDetailTopToolsView) ViewBindings.findChildViewById(r100, R.id.top_tools_view)) == null) goto L35;
        r101 = R.id.v2_divider;
        View r118 = ViewBindings.findChildViewById(r100, R.id.v2_divider);
        if (r118 == null) goto L35;
        ConstraintLayout r107 = (ConstraintLayout) r100;
        this.f329161e = new LarusCommunityCreationDetailPageBinding(r107, r102, r103, r104, r105, r106, r113, r114, r115, r116, r117, r118);
        if (r107 == null) goto L36;
        Intrinsics.checkNotNullParameter(r107, "<this>");
        ViewPager2FixScrollableLayout r108 = new ViewPager2FixScrollableLayout(r107.getContext(), null);
        r108.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r108.addView(r107, new FrameLayout.LayoutParams(-1, -1));
        return r108;
    L36:
        return null;
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }
}
