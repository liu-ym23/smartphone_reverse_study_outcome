package com.larus.uaigc.music.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.bmhome.chat.component.doubletab.IChatDoubleTabAbility;
import com.larus.bmhome.chat.e4;
import com.larus.bmhome.music.player.VideoEngineMusicPlayerViewImpl;
import com.larus.bmhome.music.player.a;
import com.larus.bmhome.music.player.j;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.CircleProgressBar;
import com.larus.home.impl.sdk.i;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.media.MediaScene;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.lynx.lottieadapter.LottieAdapterView;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kr8.o;
import xz9.b;
import xz9.c;
import xz9.d;
import xz9.e;
import xz9.f;
import xz9.g;
import xz9.h;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000*\u0001C\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020'J\u000e\u0010)\u001a\u00020'2\u0006\u0010\"\u001a\u00020!J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\tH\u0002J:\u00101\u001a\u00020'2\b\u00102\u001a\u0004\u0018\u00010\u00182\u0006\u00103\u001a\u00020\t2\b\b\u0002\u00104\u001a\u00020.2\n\b\u0002\u00105\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010/\u001a\u0004\u0018\u000100J\u0006\u00106\u001a\u00020'J\b\u00107\u001a\u00020'H\u0016J\b\u00108\u001a\u00020'H\u0016J\b\u00109\u001a\u00020'H\u0016J\b\u0010:\u001a\u00020'H\u0016J\b\u0010;\u001a\u00020'H\u0016J\b\u0010<\u001a\u00020'H\u0016J\b\u0010=\u001a\u00020'H\u0016J\b\u0010>\u001a\u00020'H\u0016J\b\u0010@\u001a\u00020'H\u0014J\b\u0010A\u001a\u00020'H\u0014J\n\u0010E\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010F\u001a\u00020\u001bH\u0016J\u0018\u0010G\u001a\u00020'2\u0006\u0010H\u001a\u00020\t2\u0006\u0010I\u001a\u00020!H\u0016J\b\u0010J\u001a\u00020'H\u0016J\b\u0010K\u001a\u00020'H\u0016J\u0006\u0010L\u001a\u00020\tJ\b\u0010M\u001a\u00020'H\u0002J\n\u0010N\u001a\u0004\u0018\u00010OH\u0002R\u0014\u0010\f\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0004\n\u0002\u0010D¨\u0006P"}, d2 = {"Lcom/larus/uaigc/music/widget/LyricsToSongTemplatePlayerView;", "Landroid/widget/FrameLayout;", "Lcom/larus/bmhome/music/player/BoxMusicPlayer$PlayerView;", "Lcom/larus/bmhome/creative/api/IMusicPlayerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewContext", "getViewContext", "()Landroid/content/Context;", "mProgressBar", "Lcom/larus/common_ui/widget/CircleProgressBar;", "mLoadingView", "Lcom/lynx/lottieadapter/LottieAdapterView;", "mPlayIcon", "Landroid/widget/ImageView;", "mPauseIcon", "showingProgress", "mMusicContent", "Lcom/larus/im/bean/message/block/MusicCreationContent;", "mIndex", "scope", "Lkotlinx/coroutines/CoroutineScope;", "mPlayer", "Lcom/larus/bmhome/music/player/BoxMusicPlayer;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "destroyed", "", "useFragmentLifecycleOwner", "autoPauseWhenSwitchTab", "getAutoPauseWhenSwitchTab", "()Z", "createSmall", "", "createMedium", "setUseFragmentLifecycleOwner", "create", "Landroid/view/View;", "layout", "mCurrentPage", "", "musicAppletMobContext", "Lcom/larus/bmhome/music/mob/MusicAppletMobContext;", "bindData", "musicCreationContent", "index", "currentPage", "showFrom", "rebind", "showReadyState", "showPlayingState", "hideLoadingView", "showLoadingView", "hidePlayIcon", "showPlayIcon", "hideProgressBarView", "showProgressBarView", "attached", "onAttachedToWindow", "onDetachedFromWindow", "lifecycleObserver", "com/larus/uaigc/music/widget/LyricsToSongTemplatePlayerView$lifecycleObserver$1", "Lcom/larus/uaigc/music/widget/LyricsToSongTemplatePlayerView$lifecycleObserver$1;", "resolveLifecycleOwner", "getScope", "setProgress", "progress", "smooth", "forceStop", MapMonitorConst.EVENT_DESTROY, "getViewProgress", "showMusicLoadingState", "getCurBottomTabFrag", "Landroidx/fragment/app/Fragment;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LyricsToSongTemplatePlayerView extends FrameLayout implements a.InterfaceC4089a, bp8.a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f373815p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f373816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CircleProgressBar f373817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f373818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f373819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MusicCreationContent f373820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f373821f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final GlobalScope f373822g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public VideoEngineMusicPlayerViewImpl f373823h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LifecycleOwner f373824i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f373825j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f373826k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f373827l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public o f373828m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f373829n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LyricsToSongTemplatePlayerView$lifecycleObserver$1 f373830o;

    public LyricsToSongTemplatePlayerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LyricsToSongTemplatePlayerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void Pe(float r100, boolean r101) {
    }

    private final boolean getAutoPauseWhenSwitchTab() {
        if ((AppHost.f326268a.a().getCurrentActivity() instanceof e4) == false) goto L5;
    L8:
        return true;
    L5:
        if ((getCurBottomTabFrag() instanceof IChatDoubleTabAbility) == true) goto L8;
        return false;
    }

    private final Fragment getCurBottomTabFrag() {
        if (z2.f365865a.enableChatWithTab() == true) goto L5;
        return null;
    L5:
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L9;
        r100.f0();
        return i.f346186a.a();
    L9:
        return null;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void Lf() {
        CircleProgressBar r100 = this.f373817b;
        if (r100 == null) goto L6;
        r100.post(new h(this));
        return;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void Lr() {
        ImageView r100 = this.f373818c;
        if (r100 == null) goto L6;
        r100.post(new xz9.a(this));
        return;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void OK() {
        ImageView r100 = this.f373818c;
        if (r100 == null) goto L6;
        r100.post(new b(this));
        return;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void UY() {
        CircleProgressBar r100 = this.f373817b;
        if (r100 == null) goto L6;
        r100.post(new e(this));
        return;
    }

    @Override // bp8.a
    public final void a() {
        VideoEngineMusicPlayerViewImpl r100 = this.f373823h;
        if (r100 == null) goto L5;
        r100.k(true);
    L5:
        VideoEngineMusicPlayerViewImpl r101 = this.f373823h;
        if (r101 == null) goto L9;
        r101.onPaused();
        return;
    }

    @Override // bp8.a
    public final void destroy() {
        if (this.f373825j == false) goto L5;
        return;
    L5:
        this.f373825j = true;
        LifecycleOwner r100 = this.f373824i;
        if (r100 == null) goto L10;
        Lifecycle r101 = r100.getLifecycle();
        if (r101 == null) goto L10;
        r101.removeObserver(this.f373830o);
    L10:
        this.f373824i = null;
        this.f373829n = false;
        VideoEngineMusicPlayerViewImpl r102 = this.f373823h;
        if (r102 == null) goto L13;
        r102.onDetachedFromWindow();
    L13:
        VideoEngineMusicPlayerViewImpl r103 = this.f373823h;
        if (r103 == null) goto L17;
        r103.onDestroyed();
        return;
    }

    public final LifecycleOwner e() {
        if (this.f373826k == false) goto L5;
    L8:
        Intrinsics.checkNotNullParameter(this, "<this>");
        return FragmentManager.findFragment(this).getViewLifecycleOwner();
    L5:
        if (getAutoPauseWhenSwitchTab() == true) goto L8;
        Intrinsics.checkNotNullParameter(this, "<this>");
        return FragmentManager.findFragment(this).getActivity();
    }

    public final int getViewProgress() {
        CircleProgressBar r100 = this.f373817b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getProgress();
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void hideLoadingView() {
        CircleProgressBar r100 = this.f373817b;
        if (r100 == null) goto L6;
        r100.post(new f(this));
        return;
    }

    public final void d() {
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.larus_music_create_player_view_medium, this);
        com.larus.bmhome.music.player.f r101 = com.larus.bmhome.music.player.f.f312961a;
        Intrinsics.checkNotNullParameter(this, "parent");
        this.f373823h = new VideoEngineMusicPlayerViewImpl(this, null);
        Intrinsics.checkNotNull(r100);
        this.f373817b = (CircleProgressBar) r100.findViewById(R.id.progress_bar);
        LottieAdapterView r102 = (LottieAdapterView) r100.findViewById(R.id.loading_view);
        this.f373818c = (ImageView) r100.findViewById(R.id.play_image);
        this.f373819d = (ImageView) r100.findViewById(R.id.pause_image);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f373825j = false;
        VideoEngineMusicPlayerViewImpl r100 = this.f373823h;
        if (r100 == null) goto L6;
        r100.onAttachedToWindow();
    L6:
        if (this.f373829n == true) goto L14;
        LifecycleOwner r101 = e();
        if (r101 == null) goto L12;
        Lifecycle r102 = r101.getLifecycle();
        if (r102 == null) goto L12;
        r102.addObserver(this.f373830o);
    L12:
        this.f373824i = r101;
        this.f373829n = true;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        VideoEngineMusicPlayerViewImpl r100 = this.f373823h;
        if (r100 == null) goto L6;
        r100.onDetachedFromWindow();
        return;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void showLoadingView() {
        OK();
        CircleProgressBar r100 = this.f373817b;
        if (r100 == null) goto L6;
        r100.post(new d(this));
        return;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void F6() {
        a.InterfaceC4089a.C4090a.b();
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void FK() {
        Lr();
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void f20() {
        OK();
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public CoroutineScope getScope() {
        return this.f373822g;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public Context getViewContext() {
        return this.f373816a;
    }

    public static final /* synthetic */ boolean b(LyricsToSongTemplatePlayerView r100) {
        return r100.getAutoPauseWhenSwitchTab();
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void GP(Map<String, String> r100) {
        a.InterfaceC4089a.C4090a.d(r100);
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void Ij(Map<String, String> r100) {
        a.InterfaceC4089a.C4090a.c(r100);
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void eb(Map<String, String> r100) {
        a.InterfaceC4089a.C4090a.a(r100);
    }

    public final void setUseFragmentLifecycleOwner(boolean r100) {
        if (this.f373826k != r100) goto L5;
        return;
    L5:
        this.f373826k = r100;
        if (this.f373829n == false) goto L18;
        LifecycleOwner r101 = this.f373824i;
        if (r101 == null) goto L12;
        Lifecycle r102 = r101.getLifecycle();
        if (r102 == null) goto L12;
        r102.removeObserver(this.f373830o);
    L12:
        LifecycleOwner r103 = e();
        this.f373824i = r103;
        if (r103 == null) goto L19;
        Lifecycle r104 = r103.getLifecycle();
        if (r104 == null) goto L20;
        r104.addObserver(this.f373830o);
        return;
    L20:
        return;
    L19:
        return;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void mP(final int r100, boolean r101) {
        CircleProgressBar r102 = this.f373817b;
        if (r102 == null) goto L6;
        r102.post(new g(this, r100));
        return;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void r30(String r100, Map<String, String> r101) {
        a.InterfaceC4089a.C4090a.e(r100, r101);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.uaigc.music.widget.LyricsToSongTemplatePlayerView$lifecycleObserver$1] */
    public LyricsToSongTemplatePlayerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f373816a = r100;
        this.f373822g = GlobalScope.INSTANCE;
        this.f373827l = "";
        this.f373830o = new LyricsToSongTemplatePlayerView$lifecycleObserver$1(this);
    }

    public /* synthetic */ LyricsToSongTemplatePlayerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static void c(final LyricsToSongTemplatePlayerView r310, MusicCreationContent r311, int r312, String r313, String r314, o r315, int r410) {
        if ((r410 & 4) == 0) goto L5;
        String r100 = "chat";
    L7:
        if ((r410 & 8) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r410 & 16) == 0) goto L13;
        o r110 = null;
    L14:
        r310.getClass();
        Intrinsics.checkNotNullParameter(r100, "currentPage");
        r310.f373825j = false;
        r310.f373820e = r311;
        r310.f373821f = r312;
        r310.f373827l = r100;
        r310.f373828m = r110;
        if (r311 == null) goto L46;
        if (r101 != null) goto L18;
        String r102 = "";
    L19:
        GlobalScope r111 = r310.f373822g;
        if (r110 == null) goto L22;
        Lazy r103 = com.larus.bmhome.music.player.i.f312969a;
        Context r104 = r310.getContext();
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r112 = "music_applet:" + r104;
    L23:
        String r113 = r311.getVid();
        String r105 = r311.getVideoModel();
        if (r105 != null) goto L26;
        String r114 = "";
    L27:
        if (r312 == 0) goto L29;
    L31:
        boolean r106 = false;
    L32:
        LruCache<String, wc9.e> r107 = ko8.a.f504531a;
        String r210 = ko8.a.e(ko8.a.f504535e);
        String r108 = r311.getTitle();
        if (r108 != null) goto L35;
        String r211 = "";
    L36:
        String r109 = r311.getChunkUrl();
        if (r109 != null) goto L39;
        String r212 = "";
    L40:
        String r115 = null;
        String r116 = null;
        String r117 = null;
        String r118 = "";
        int r119 = -1;
        boolean r120 = false;
        long r121 = 0;
        boolean r213 = false;
        boolean r122 = r106;
        o r123 = r110;
        String r214 = r100;
        j r124 = new j(r115, r116, r117, r102, r118, r119, r114, r113, r122, r120, r111, r121, r112, r123, r214, r213, r210, r211, r212, r311 instanceof bq8.a, false, r311.getPlayList(), false, false, null, MediaScene.MUSIC_GEN, 30411271);
        VideoEngineMusicPlayerViewImpl r125 = r310.f373823h;
        if (r125 == null) goto L44;
        r125.d(r124);
    L44:
        if (com.larus.bmhome.music.protocol.a.a(r311) == false) goto L50;
        e1.d(r310, new c(r310));
        return;
    L50:
        return;
    L39:
        r212 = r109;
        goto L40
    L35:
        r211 = r108;
        goto L36
    L29:
        if (Intrinsics.areEqual(r311.getPlayList().getItemId(), "0") == false) goto L31;
        r106 = true;
        goto L32
    L26:
        r114 = r105;
        goto L27
    L22:
        r112 = null;
        goto L23
    L18:
        r102 = r101;
        goto L19
    L46:
        ImageView r126 = r310.f373818c;
        if (r126 == null) goto L52;
        r126.post(new xz9.i(r310));
        return;
    L52:
        return;
    L13:
        r110 = r315;
        goto L14
    L9:
        r101 = r314;
        goto L11
    L5:
        r100 = r313;
        goto L7
    }
}
