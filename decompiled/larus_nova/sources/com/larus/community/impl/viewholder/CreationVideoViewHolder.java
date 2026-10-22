package com.larus.community.impl.viewholder;

import android.os.SystemClock;
import android.util.Range;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.common_ui.widget.CommonAuthorInfoLayout;
import com.larus.community.api.ICommunityService;
import com.larus.media.focus.CardContextState;
import com.larus.nova.R;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.CreationPublishExtra;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.api.creation.VideoContentFromChat;
import com.larus.platform.api.creation.VideoUserContent;
import com.larus.utils.logger.FLogger;
import com.larus.utils.w0;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tx9.a4;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 Q2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001QB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018H\u0002J^\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020\u00182\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010+\u001a\u00020\u00182\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0001\u0010#\u001a\u00020\u00182\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u00100\u001a\u0004\u0018\u00010\u0011H\u0007J\u0010\u00101\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0002J\u001a\u00102\u001a\u00020\"2\u0006\u0010$\u001a\u00020%2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u00103\u001a\u00020\u00132\b\b\u0001\u0010#\u001a\u00020\u0018H\u0002J\b\u00104\u001a\u00020\"H\u0016J\b\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u000206H\u0016J\u0018\u00108\u001a\u00020\"2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010=\u001a\u00020\"2\b\u0010>\u001a\u0004\u0018\u00010?J\u0006\u0010@\u001a\u00020\"J\u0006\u0010A\u001a\u00020\"J\u0006\u0010B\u001a\u00020\"J\b\u0010C\u001a\u00020\"H\u0002J\b\u0010D\u001a\u00020\"H\u0002J\b\u0010E\u001a\u00020\"H\u0002J\b\u0010F\u001a\u00020\"H\u0002J\u0010\u0010G\u001a\u00020\"2\u0006\u00109\u001a\u00020:H\u0016J\b\u0010H\u001a\u00020IH\u0016J\b\u0010M\u001a\u00020\"H\u0002J\b\u0010N\u001a\u00020\"H\u0002J\u0014\u0010O\u001a\u0004\u0018\u00010I2\b\u0010P\u001a\u0004\u0018\u00010%H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/larus/community/impl/viewholder/CreationVideoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/platform/api/creation/ICreationFeedViewHolder;", "Lcom/larus/media/focus/OIDisplayListener;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "downloadIcon", "Lcom/larus/bmhome/bigimg/download/CommonDownLoadLayout;", "waterMarkIcon", "Landroid/widget/ImageView;", "lifeCycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "focusHelper", "Lcom/larus/community/impl/component/focus/CreationFeedRVFocusHelper;", "creationFeedVideoReportHelper", "Lcom/larus/community/impl/tracker/CreationFeedVideoReportHelper;", "playSessionActive", "", "segmentStartTs", "", "accumulatedDuration", "playCompleteCount", "", "hasReportedThisSession", "videoView", "Lcom/larus/common_ui/video/VideoPlayView;", "iconTemplate", "textView", "Landroid/widget/TextView;", "authorInfoLayout", "Lcom/larus/common_ui/widget/CommonAuthorInfoLayout;", "resetTemplateIcon", "", "creationFeedType", "creation", "Lcom/larus/platform/api/creation/UserCreation;", "creationFeedTrackParams", "Lcom/larus/platform/api/creation/CreationFeedTrackParams;", "useProfileSelfNoWatermarkCover", "bindData", "position", "itemWidth", "creationClickCallBack", "Lcom/larus/community/impl/adapter/ICreationClickCallBack;", "initParams", "Lcom/larus/platform/api/creation/CreationFeedInitParams;", "feedVideoReportHelper", "handleIconTemplate", "handleDownLoadIcon", "shouldUseProfileSelfNoWatermark", "onViewRecycled", "getVisiblePercentThrottle", "", "getInvisiblePercentThrottle", "onCardDisplay", "contextState", "Lcom/larus/media/focus/CardContextState;", "cardCallback", "Lcom/larus/media/focus/OICardActionCallback;", "bindVideoController", "videoController", "Lcom/larus/platform/api/IVideoController;", "startVideo", "stopVideo", "stopVideoIfPlaying", "stopVideoInner", "resetPlaySessionIfNeeded", "reportPlayTimeIfNeeded", "reportAiVideoPlay", "onCardGone", "getDisplayItemKey", "", "job", "Lkotlinx/coroutines/Job;", "prefetchSuccess", "prefetchRefImageIfNeed", "cancelPrefetchRefImage", "getRefImageUrl", "userCreation", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationVideoViewHolder extends RecyclerView.ViewHolder implements zp9.q, nk9.d {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f330008r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CommonDownLoadLayout f330009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f330010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i29.c f330011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p29.b f330012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f330013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f330014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f330015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f330016h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f330017i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final VideoPlayView f330018j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f330019k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f330020l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CommonAuthorInfoLayout f330021m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public UserCreation f330022n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public zp9.g f330023o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f330024p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f330025q;

    public static final class a {
    }

    static {
    }

    @Override // nk9.d
    public final float C0() {
        return 0.99f;
    }

    @Override // nk9.d
    public final float E2() {
        return 1.0f;
    }

    @Override // nk9.d
    public final float F2() {
        return 0.0f;
    }

    @Override // nk9.d
    public final float X1() {
        return 0.0f;
    }

    @Override // nk9.d
    public final float h2() {
        return 1.0f;
    }

    @Override // nk9.d
    public final float h3() {
        return 1.0f;
    }

    @Override // nk9.d
    public final View I0() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.ViewHolder");
        return this.itemView;
    }

    @Override // nk9.d
    public final String S0() {
        UserCreation r100 = this.f330022n;
        if (r100 == null) goto L6;
        String r101 = r100.f364987a;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final void U3() {
        if (this.f330013e == true) goto L5;
        return;
    L5:
        if (this.f330017i == true) goto L75;
        this.f330015g += SystemClock.elapsedRealtime() - this.f330014f;
        UserCreation r100 = this.f330022n;
        if (r100 != null) goto L10;
        return;
    L10:
        zp9.g r101 = this.f330023o;
        UserCreationContent r102 = r100.f364991e;
        if (r102 == null) goto L15;
        VideoUserContent r103 = r102.f365010e;
        if (r103 == null) goto L15;
        nr9.g r104 = os8.c.d(r103);
    L16:
        if (r104 == null) goto L18;
        String r105 = r104.f520257a;
    L19:
        p29.b r106 = this.f330012d;
        if (r106 == null) goto L72;
        if (r101 == null) goto L24;
        String r107 = r101.f573249c;
        if (r107 == null) goto L24;
    L28:
        Boolean r108 = Boolean.TRUE;
        if (r101 == null) goto L31;
        String r110 = r101.f573254h;
    L32:
        Long r111 = Long.valueOf(this.f330015g);
        if (this.f330016h <= 0) goto L35;
        boolean r112 = true;
    L36:
        Boolean r113 = Boolean.valueOf(r112);
        if (r101 == null) goto L39;
        String r114 = r101.f573247a;
    L40:
        UserCreationContent r115 = r100.f364991e;
        if (r115 == null) goto L45;
        VideoContentFromChat r116 = r115.f365011f;
        if (r116 == null) goto L45;
        String r117 = r116.f365057a;
    L46:
        if (r104 == null) goto L48;
        String r109 = r104.f520258b;
    L49:
        Boolean r118 = Boolean.valueOf(a4.a(r109));
        Boolean r119 = Boolean.valueOf(a4.b(AppHost.f326268a.getApplication(), Boolean.valueOf(this.f330018j.f327998s)));
        UserCreationTrackParams r120 = r100.f365000n;
        if (r120 == null) goto L52;
        String r121 = r120.f365043d;
    L53:
        if (r120 == null) goto L55;
        String r122 = r120.f365044e;
    L56:
        if (r101 == null) goto L58;
        String r123 = r101.f573255i;
    L59:
        if (r101 == null) goto L64;
        String r124 = r101.f573256j;
        if (r124 == null) goto L64;
        String r210 = r124;
    L67:
        String r211 = zp9.d.b(r100);
        String r212 = zp9.d.c(r100);
        String r213 = zp9.d.d(r100);
        String r125 = r100.f364987a;
        String r126 = r100.f364995i;
        UserCreationTrackParams r127 = r100.f365000n;
        if (r127 == null) goto L70;
        String r214 = r127.f365040a;
    L71:
        p29.b.b(r106, r105, r107, r108, r110, r111, r113, r114, r117, r118, r119, r121, r122, r123, r210, r211, r212, r213, r125, r126, r214);
        goto L72
    L70:
        r214 = null;
    L64:
        if (r101 == null) goto L66;
        r210 = r101.f573248b;
        goto L67
    L66:
        r210 = null;
        goto L67
    L58:
        r123 = null;
        goto L59
    L55:
        r122 = null;
        goto L56
    L52:
        r121 = null;
        goto L53
    L48:
        r109 = null;
    L45:
        r117 = null;
        goto L46
    L39:
        r114 = null;
        goto L40
    L35:
        r112 = false;
        goto L36
    L31:
        r110 = null;
    L24:
        UserCreationTrackParams r128 = r100.f365000n;
        if (r128 == null) goto L27;
        r107 = r128.f365046g;
        goto L28
    L27:
        r107 = null;
    L72:
        this.f330017i = true;
        this.f330013e = false;
        FLogger.f375446a.i("CreationVideoViewHolder", "playCompleteCount: " + this.f330016h);
        return;
    L18:
        r105 = null;
    L15:
        r104 = null;
        goto L16
    }

    @Override // zp9.q
    public final void onViewRecycled() {
        U3();
        this.f330009a.onDestroy();
    }

    public CreationVideoViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f330009a = (CommonDownLoadLayout) r100.findViewById(R.id.download_icon);
        this.f330010b = (ImageView) r100.findViewById(R.id.water_mark_icon);
        VideoPlayView r101 = (VideoPlayView) r100.findViewById(R.id.item_video);
        boolean r102 = r0.f330105a;
        if (r0.f330105a == false) goto L5;
        r101.K();
    L5:
        this.f330018j = r101;
        View r103 = r100.findViewById(R.id.icon_do_same_style);
        ICommunityService.Companion r104 = ICommunityService.f328743a;
        if (r104.f1().e() != 0) goto L8;
        r103.setBackgroundResource(R.drawable.larus_bg_same_template_button);
    L9:
        this.f330019k = r103;
        TextView r105 = (TextView) r100.findViewById(R.id.do_same_style_text);
        if (r104.f1().e() != 0) goto L12;
        r105.setTextColor(ContextCompat.getColor(r100.getContext(), R.color.larus_static_white));
    L13:
        this.f330020l = r105;
        this.f330021m = (CommonAuthorInfoLayout) r100.findViewById(R.id.layout_author_info);
        w0.e(r100, i5.Y());
        return;
    L12:
        r105.setTextColor(ContextCompat.getColor(r100.getContext(), R.color.larus_static_black));
        goto L13
    L8:
        r103.setBackgroundResource(R.drawable.larus_bg_same_template_new_button);
        goto L9
    }

    @Override // nk9.d
    public final void A0(CardContextState r100) {
        Intrinsics.checkNotNullParameter(r100, "contextState");
        Intrinsics.checkNotNullParameter(r100, "contextState");
        i29.c r101 = this.f330011c;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(this, BrowserDependency.UrlClickType.CARD);
        i29.f r102 = r101.f488064b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(this, BrowserDependency.UrlClickType.CARD);
        r102.f488070d.remove(new WeakReference(this));
        CollectionsKt.removeAll(r102.f488070d, new i29.e(this));
        com.larus.utils.y.c(new m0(this));
        return;
    }

    public static final String T3(CreationVideoViewHolder r100, UserCreation r101) {
        r100.getClass();
        String r102 = null;
        if (r101 == null) goto L32;
        CreationPublishExtra r103 = r101.f365002p;
        if (r103 == null) goto L8;
        boolean r104 = Intrinsics.areEqual(r103.f364924b, Boolean.FALSE);
    L9:
        if (r104 == false) goto L19;
        UserCreationRefContent r105 = r101.f365001o;
        if (r105 == null) goto L28;
        List<ImageInfo> r106 = r105.a();
        if (r106 == null) goto L28;
        ImageInfo r107 = (ImageInfo) CollectionsKt.getOrNull(r106, 0);
        if (r107 == null) goto L28;
        Image r108 = r107.f364805h;
        if (r108 == null) goto L28;
        r102 = r108.f364791a;
    L28:
        if (r102 != null) goto L31;
        return "";
    L31:
        return r102;
    L19:
        UserCreationRefContent r109 = r101.f365001o;
        if (r109 == null) goto L28;
        List<ImageInfo> r110 = r109.a();
        if (r110 == null) goto L28;
        ImageInfo r111 = (ImageInfo) CollectionsKt.getOrNull(r110, 0);
        if (r111 == null) goto L28;
        Image r112 = r111.f364800c;
        if (r112 == null) goto L28;
        r102 = r112.f364791a;
        goto L28
    L8:
        r104 = false;
        goto L9
    L32:
        return null;
    }

    @Override // nk9.d
    public final void A3(CardContextState r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "contextState");
    }

    @Override // nk9.d
    public final void F3(CardContextState r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "contextState");
    }

    @Override // nk9.d
    public final void c2(CardContextState r100, go2.g r101) {
        Intrinsics.checkNotNullParameter(r100, "contextState");
        Intrinsics.checkNotNullParameter(r101, "cardCallback");
        Intrinsics.checkNotNullParameter(r100, "contextState");
        Intrinsics.checkNotNullParameter(r101, "cardCallback");
        i29.c r102 = this.f330011c;
        if (r102 == null) goto L6;
        Intrinsics.checkNotNullParameter(this, BrowserDependency.UrlClickType.CARD);
        i29.f r103 = r102.f488064b;
        r103.getClass();
        Intrinsics.checkNotNullParameter(this, BrowserDependency.UrlClickType.CARD);
        CollectionsKt.removeAll(r103.f488070d, new i29.d(this));
        r103.f488070d.add(new WeakReference(this));
        return;
    }

    @Override // nk9.d
    public final void q2(CardContextState r100, Range<Float> r101) {
        Intrinsics.checkNotNullParameter(r100, "contextState");
        Intrinsics.checkNotNullParameter(r101, FilterData.FilterOptionItem.Type.RANGE);
    }
}
