package com.ss.android.lark.chat.video;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatAppContainerV1;
import com.ss.android.lark.chat.preview.entity.component.property.VideoProperty;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.player.player.s;
import com.ss.android.lark.player.player.v;
import com.ss.android.lark.player.widget.VideoView;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 S2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001SB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J&\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010(2\b\u0010<\u001a\u0004\u0018\u00010=H\u0017J\u0010\u0010C\u001a\u00020;2\u0006\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020\"H\u0016J\b\u0010G\u001a\u00020;H\u0016J\b\u0010H\u001a\u00020;H\u0016J\b\u0010I\u001a\u00020JH\u0002J\u0010\u0010K\u001a\u00020;2\u0006\u0010L\u001a\u00020\"H\u0002J\b\u0010M\u001a\u00020;H\u0002J\u0010\u0010N\u001a\u00020;2\u0006\u0010O\u001a\u00020PH\u0016J\b\u0010Q\u001a\u00020;H\u0016J\b\u0010R\u001a\u00020;H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u000e\u00103\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006T"}, d2 = {"Lcom/ss/android/lark/chat/video/InnerVideoPreviewFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/lark/chat/video/SharedElementListener;", "Lcom/ss/android/lark/chat/video/BackListener;", "<init>", "()V", "mVideoOriginUrl", "", "getMVideoOriginUrl", "()Ljava/lang/String;", "setMVideoOriginUrl", "(Ljava/lang/String;)V", "mVideoCover", "Lcom/ss/android/lark/image/entity/Image;", "getMVideoCover", "()Lcom/ss/android/lark/image/entity/Image;", "setMVideoCover", "(Lcom/ss/android/lark/image/entity/Image;)V", "mVideoPlayUrl", "listener", "Lcom/ss/android/lark/chat/video/OnFragmentInteractListener;", "mVideoView", "Lcom/ss/android/lark/player/widget/VideoView;", "getMVideoView", "()Lcom/ss/android/lark/player/widget/VideoView;", "setMVideoView", "(Lcom/ss/android/lark/player/widget/VideoView;)V", "mControllerCover", "Lcom/ss/android/lark/chat/video/PreviewControllerCover;", "getMControllerCover", "()Lcom/ss/android/lark/chat/video/PreviewControllerCover;", "setMControllerCover", "(Lcom/ss/android/lark/chat/video/PreviewControllerCover;)V", "mInflated", "", "getMInflated", "()Z", "setMInflated", "(Z)V", "mRootView", "Landroid/view/ViewGroup;", "getMRootView", "()Landroid/view/ViewGroup;", "setMRootView", "(Landroid/view/ViewGroup;)V", "mAnimationCoverIV", "Landroid/widget/ImageView;", "getMAnimationCoverIV", "()Landroid/widget/ImageView;", "setMAnimationCoverIV", "(Landroid/widget/ImageView;)V", "isPortrait", "site", "Lcom/ss/android/lark/chat/preview/entity/component/property/VideoProperty$Site;", "getSite", "()Lcom/ss/android/lark/chat/preview/entity/component/property/VideoProperty$Site;", "setSite", "(Lcom/ss/android/lark/chat/preview/entity/component/property/VideoProperty$Site;)V", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onBackPressed", "onSharedElementEnd", "onPause", "setupCovers", "Lcom/ss/android/lark/player/cover/ReceiverGroup;", "playVideo", "useNet", "playInner", "onAttach", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onDestroyView", "onDetach", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InnerVideoPreviewFragment extends Fragment implements p, com.ss.android.lark.chat.video.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f416753o = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f416754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Image f416755e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f416756f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g f416757g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public VideoView f416758h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h f416759i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f416760j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewGroup f416761k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ImageView f416762l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f416763m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public VideoProperty.Site f416764n;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InnerVideoPreviewFragment f416765a;

        public b(InnerVideoPreviewFragment r100) {
            this.f416765a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VideoView r100 = this.f416765a.f416758h;     // Catch: Throwable -> L17
            if (r100 == null) goto L5;
            r100.i();     // Catch: Throwable -> L17
        L5:
            InnerVideoPreviewFragment r101 = this.f416765a;     // Catch: Throwable -> L17
            ViewGroup r102 = r101.f416761k;     // Catch: Throwable -> L17
            if (r102 == null) goto L8;
            r102.removeView(r101.f416758h);     // Catch: Throwable -> L17
        L8:
            InnerVideoPreviewFragment r103 = this.f416765a;     // Catch: Throwable -> L17
            if (r103.f416763m == false) goto L13;
            FragmentActivity r104 = r103.getActivity();     // Catch: Throwable -> L17
            if (r104 == null) goto L20;
            r104.finishAfterTransition();     // Catch: Throwable -> L17
            return;
        L20:
            return;
        L13:
            FragmentActivity r105 = r103.getActivity();     // Catch: Throwable -> L17
            if (r105 == null) goto L24;
            r105.finish();     // Catch: Throwable -> L17
            return;
        L24:
            return;
        L17:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L25;
            throw th;
        }
    }

    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InnerVideoPreviewFragment f416766a;

        public c(InnerVideoPreviewFragment r100) {
            this.f416766a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            InnerVideoPreviewFragment r100 = this.f416766a;
            if (r100.f416760j == true) goto L12;
            VideoView r101 = r100.f416758h;
            if (r101 == null) goto L7;
            r101.setVisibility(8);
        L7:
            g r102 = this.f416766a.f416757g;
            if (r102 == null) goto L10;
            r102.j();
        L10:
            this.f416766a.f416760j = true;
            return;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chat.video.a
    public final boolean onBackPressed() {
        ImageView r100 = this.f416762l;
        if (r100 == null) goto L5;
        ViewParent r101 = r100.getParent();
    L6:
        if (r101 != null) goto L10;
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-1, -1);
        ViewGroup r103 = this.f416761k;
        if (r103 == null) goto L10;
        r103.addView(this.f416762l, r102);
    L10:
        UICallbackExecutor.post(new b(this));
        return true;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.video.p
    public final void tD() {
        if (this.f416758h == null) goto L12;
        ViewGroup r100 = this.f416761k;
        if (r100 == null) goto L7;
        r100.removeView(this.f416762l);
    L7:
        VideoView r101 = this.f416758h;
        if (r101 == null) goto L10;
        r101.setVisibility(0);
    L10:
        S90(false);
        return;
    }

    public InnerVideoPreviewFragment() {
        this.f416763m = true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        VideoView r100 = this.f416758h;
        if (r100 == null) goto L5;
        r100.i();
    L5:
        this.f416758h = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
        this.f416757g = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        VideoView r100 = this.f416758h;
        if (r100 == null) goto L19;
        v r101 = r100.f438748a;
        boolean r102 = false;
        if (r101.f() == false) goto L16;
        s r103 = r101.f438710a;
        if (r103.b() == true) goto L9;
    L13:
        boolean r104 = false;
    L14:
        if (r104 == false) goto L16;
        r102 = true;
        goto L16
    L9:
        if (r103.f438663a == (-1)) goto L13;
        if (r103.f438689g.getPlaybackState() != 1) goto L13;
        r104 = true;
    L16:
        if (r102 == false) goto L20;
        r100.f();
        return;
    L20:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.ss.android.lark.chat.video.InnerVideoPreviewFragment$playVideo$1] */
    public final void S90(boolean r100) {
        VideoProperty.Site r101 = this.f416764n;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        String r103 = null;
        if (r102 == false) goto L19;
        String r104 = this.f416754d;
        if (r104 == null) goto L13;
        r103 = r104;
    L14:
        this.f416756f = r103;
        VideoView r105 = this.f416758h;
        if (r105 == null) goto L25;
        UICallbackExecutor.execute(new com.ss.android.lark.chat.video.b(this, r105));
        return;
    L25:
        return;
    L13:
        Intrinsics.throwUninitializedPropertyAccessException("mVideoOriginUrl");
        goto L14
    L19:
        ChatAppContainerV1 r106 = ChatAppContainerV1.f414510a;
        m6b.n r107 = (m6b.n) e0c.k.a(LarkContext.getApplication(), m6b.n.class);
        String r108 = this.f416754d;
        if (r108 == null) goto L22;
        r103 = r108;
    L23:
        r107.Z2(r103, r100, new InnerVideoPreviewFragment$playVideo$1(this));
        return;
    L22:
        Intrinsics.throwUninitializedPropertyAccessException("mVideoOriginUrl");
        goto L23
    L5:
        if (r101.getValue() != 0) goto L7;
        r102 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        if ((r100 instanceof g) == false) goto L6;
        this.f416757g = (g) r100;
        return;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        boolean r101 = true;
        if (r100.orientation == 1) goto L6;
        r101 = false;
    L6:
        this.f416763m = r101;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L11;
        this.f416764n = (VideoProperty.Site) r101.getSerializable("video_site");
        String r102 = r101.getString("video_origin_url");
        this.f416755e = (Image) r101.getSerializable("video_cover");
        if (r102 == null) goto L7;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f416754d = r102;
        return;
    L7:
        FragmentActivity r103 = getActivity();
        if (r103 == null) goto L13;
        r103.finishAfterTransition();
        return;
    L13:
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        FrameLayout r103 = new FrameLayout(r100.getContext());
        this.f416761k = r103;
        r103.setTransitionName("show_video_share_element");
        FragmentActivity r104 = getActivity();
        if (r104 == null) goto L21;
        if (r104.isFinishing() == true) goto L7;
        v0c.s r105 = new v0c.s();
        h r106 = new h(getActivity(), this.f416755e);
        this.f416759i = r106;
        r106.f416810v = new com.ss.android.lark.chat.video.c(this);
        r106.f416811w = new d(this);
        n r107 = new n(getActivity());
        r107.f416828f = new e(this);
        r107.f416829g = new f(this);
        o r108 = new o(getActivity());
        r105.e("controller", this.f416759i);
        r105.e("error", r107);
        r105.e("loading", r108);
        this.f416758h = new VideoView(r100.getContext());
        FrameLayout.LayoutParams r109 = new FrameLayout.LayoutParams(-1, -1);
        VideoView r110 = this.f416758h;
        if (r110 == null) goto L21;
        ViewGroup r111 = this.f416761k;
        if (r111 == null) goto L13;
        r111.addView(r110, r109);
    L13:
        ImageView r112 = new ImageView(r100.getContext());
        this.f416762l = r112;
        r112.setBackgroundColor(-16777216);
        ViewGroup r113 = this.f416761k;
        if (r113 == null) goto L16;
        r113.addView(this.f416762l, r109);
    L16:
        Image r114 = this.f416755e;
        if (r114 == null) goto L19;
        EncryptImage r115 = new EncryptImage(r114);
        ImageLoader.with(getContext()).load(r115).error(R.drawable.__picker_ic_broken_image_black_48dp).into(this.f416762l);
    L19:
        r110.setReceiverGroup(r105);
        r110.getViewTreeObserver().addOnGlobalLayoutListener(new c(this));
        goto L21
    L7:
        return this.f416761k;
    L21:
        return this.f416761k;
    }
}
