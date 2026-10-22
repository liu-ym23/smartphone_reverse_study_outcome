package com.larus.video.impl.widget;

import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common.apphost.AppHost;
import com.larus.flow.video.bean.CommonVideoModel;
import com.larus.network.http.AsyncThrowable;
import com.larus.nova.R;
import com.larus.platform.api.IVideoController;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.video.impl.TikTokVideoViewHolder;
import com.ss.ttvideoengine.TTVideoEngine;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import v19.i5;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\t\n\u0002\b\u0004\b\u0016\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0001QB#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u00108\u001a\u000205H\u0002J\b\u00109\u001a\u000205H\u0002J\b\u0010:\u001a\u000205H\u0002J\b\u0010;\u001a\u000205H\u0002J`\u0010<\u001a\u0002052\b\u0010=\u001a\u0004\u0018\u00010\u00102\u0006\u0010>\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142:\b\u0002\u0010?\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(>\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(4\u0012\u0004\u0012\u000205\u0018\u000100H\u0016J\b\u0010@\u001a\u000205H\u0016J\b\u0010A\u001a\u000205H\u0016J\b\u0010B\u001a\u000205H\u0002J\b\u0010C\u001a\u000205H\u0002J\b\u0010D\u001a\u000205H\u0002J\b\u0010E\u001a\u000205H\u0002J\b\u0010F\u001a\u000205H\u0014J\u0006\u0010G\u001a\u000205J\u0006\u0010H\u001a\u000205J\u0010\u0010I\u001a\u0002052\b\u0010=\u001a\u0004\u0018\u00010\u0010J\b\u0010J\u001a\u000205H\u0014J\b\u0010K\u001a\u000205H\u0014J\u0010\u0010L\u001a\u0002052\u0006\u0010M\u001a\u00020NH\u0016J\u0006\u0010O\u001a\u000205J\u0006\u0010P\u001a\u000205R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b!\u0010\"R\u000e\u0010$\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010/\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(4\u0012\u0004\u0012\u000205\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/larus/video/impl/widget/VideoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/video/impl/ActionDataSyncListener;", "itemView", "Landroid/view/View;", "mCommonVideoModel", "Lcom/larus/flow/video/bean/CommonVideoModel;", "videoController", "Lcom/larus/platform/api/IVideoController;", "<init>", "(Landroid/view/View;Lcom/larus/flow/video/bean/CommonVideoModel;Lcom/larus/platform/api/IVideoController;)V", "getMCommonVideoModel", "()Lcom/larus/flow/video/bean/CommonVideoModel;", "getVideoController", "()Lcom/larus/platform/api/IVideoController;", "mMediaEntity", "Lcom/larus/platform/uimodel/MediaEntity;", "mPosition", "", "itemListener", "Lcom/larus/video/impl/ITikTokItemListener;", "mIsLoadingDataFinished", "", "mNeedRetry", "mBottomBarHeight", "mVideoView", "Lcom/larus/video/impl/widget/VideoView;", "getMVideoView", "()Lcom/larus/video/impl/widget/VideoView;", "mVideoView$delegate", "Lkotlin/Lazy;", "mProgressView", "Landroid/widget/SeekBar;", "getMProgressView", "()Landroid/widget/SeekBar;", "mProgressView$delegate", "mLoadMoreIndicator", "mSyncFromLayout", "mSyncFromIconView", "Landroid/widget/ImageView;", "mVideoInfoView", "mVideoAccountView", "Landroid/widget/TextView;", "mVideoDescView", "mBottomStatusContentView", "mLoadStatusView", "mLoadTextView", "mOnItemDataUpdate", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "positionFrom", "positionTo", "", "mMediaDataCallback", "Lcom/larus/flow/video/bean/CommonVideoModel$MediaDataCallback;", "showSlipToSeeMore", "showLoadMore", "hideLodeMore", "showNoMore", "onBind", "entity", "position", "onItemDataUpdate", "onAttached", "onDetached", "initView", "initItemView", "initVideoView", "bindEvent", "bindVideoEvent", "onUnselected", "onSelected", "onUpdate", "playVideo", "stopVideo", "onActionDataChange", "id", "", "refreshBottomStatus", "loadMoreData", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class VideoViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f375979r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CommonVideoModel f375980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IVideoController f375981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MediaEntity f375982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l2a.e f375983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f375984e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f375985f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f375986g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f375987h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f375988i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f375989j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f375990k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f375991l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f375992m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ImageView f375993n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final TextView f375994o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function2<? super Integer, ? super Integer, Unit> f375995p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b f375996q;

    public static final class a {
    }

    public static final class b implements CommonVideoModel.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoViewHolder f375997a;

        public b(VideoViewHolder r100) {
            this.f375997a = r100;
        }

        @Override // com.larus.flow.video.bean.CommonVideoModel.b
        public final void a(MediaEntityContainer r100) {
            VideoViewHolder r101 = this.f375997a;
            r101.f375984e = true;
            r101.getClass();
            this.f375997a.U3();
            VideoViewHolder r102 = this.f375997a;
            Function2<? super Integer, ? super Integer, Unit> r103 = r102.f375995p;
            if (r103 == null) goto L6;
            CommonVideoModel r104 = r102.f375980a;
            Intrinsics.checkNotNull(r104);
            MediaEntityContainer r105 = r104.getLoadMoreContainer();
            Intrinsics.checkNotNull(r105);
            ArrayList<MediaEntity> r106 = r105.mediaList();
            Intrinsics.checkNotNull(r106);
            Integer r107 = Integer.valueOf(r106.size() - r102.f375980a.getOffset());
            MediaEntityContainer r108 = r102.f375980a.getLoadMoreContainer();
            Intrinsics.checkNotNull(r108);
            ArrayList<MediaEntity> r109 = r108.mediaList();
            Intrinsics.checkNotNull(r109);
            r103.invoke(r107, Integer.valueOf(r109.size()));
            return;
        }

        @Override // com.larus.flow.video.bean.CommonVideoModel.b
        public final void b(AsyncThrowable r100) {
            VideoViewHolder r101 = this.f375997a;
            int r102 = VideoViewHolder.f375979r;
            r101.getClass();
            this.f375997a.U3();
        }
    }

    static {
    }

    public void D() {
    }

    public void W3() {
    }

    public final VideoView T3() {
        return (VideoView) this.f375985f.getValue();
    }

    public final void U3() {
        e1.q(this.f375992m);
        e1.o(this.f375987h);
    }

    public VideoViewHolder(final View r100, CommonVideoModel r101, IVideoController r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f375980a = r101;
        this.f375981b = r102;
        this.f375984e = true;
        this.f375985f = LazyKt.lazy(new w(r100));
        this.f375986g = LazyKt.lazy(new x(r100));
        this.f375987h = r100.findViewById(R.id.load_more_indicator);
        this.f375988i = r100.findViewById(R.id.sync_from_layout);
        ImageView r103 = (ImageView) r100.findViewById(R.id.sync_from_icon);
        this.f375989j = r100.findViewById(R.id.video_info);
        this.f375990k = (TextView) r100.findViewById(R.id.video_account);
        this.f375991l = (TextView) r100.findViewById(R.id.video_desc);
        this.f375992m = r100.findViewById(R.id.bottom_view);
        this.f375993n = (ImageView) r100.findViewById(R.id.status_image);
        this.f375994o = (TextView) r100.findViewById(R.id.load_text);
        this.f375996q = new b(this);
    }

    public final void V3(MediaEntity r100, int r110, l2a.e r111, l2a.q r112) {
        this.f375983d = r111;
        this.f375995p = r112;
        this.f375982c = r100;
        CommonVideoModel r101 = this.f375980a;
        boolean r102 = true;
        if (r101 == null) goto L29;
        ArrayList<MediaEntity> r103 = r101.getItems();
        if (r103 != null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == true) goto L29;
        ArrayList<MediaEntity> r105 = r101.getItems();
        if (r105 == null) goto L15;
        int r106 = r105.size();
    L17:
        if (r110 >= (r106 - 1)) goto L29;
        ArrayList<MediaEntity> r107 = this.f375980a.getItems();
        Intrinsics.checkNotNull(r107);
        MediaEntity r108 = (MediaEntity) ListProtector.get(r107, r110 + 1);
        if (r108 == null) goto L23;
        String r113 = r108.getMedia_cover_image();
        if (r113 == null) goto L23;
        FLogger.f375446a.d("VideoViewHolder", "Preload image ");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), null, null, new VideoViewHolder$onBind$1$1$1(r113, null), 3, null);
    L23:
        IVideoController r114 = this.f375981b;
        if (r114 == null) goto L29;
        if (r108 == null) goto L27;
        String r109 = r108.getVideo_model();
    L28:
        r114.f(r109, new b0(r108, (TikTokVideoViewHolder) this));
        goto L29
    L27:
        r109 = null;
        goto L28
    L15:
        r106 = 0;
        goto L17
    L7:
        if (r103.isEmpty() == true) goto L10;
        r104 = false;
    L29:
        AppHost.Companion r115 = AppHost.f326268a;
        int r116 = com.larus.utils.i.d(r115.getApplication());
        int r117 = i5.B();
        MediaEntity r118 = this.f375982c;
        if (r118 == null) goto L42;
        Integer r119 = r118.getMedia_width();
        if (r119 != null) goto L35;
    L36:
        Integer r120 = r118.getMedia_height();
        if (r120 != null) goto L40;
    L41:
        r116 = com.larus.utils.i.d(r115.getApplication());
        Integer r121 = r118.getMedia_height();
        Intrinsics.checkNotNull(r121);
        r117 = (r121.intValue() * com.larus.utils.i.c(r115.getApplication())) / r116;
        goto L42
    L40:
        if (r120.intValue() == 0) goto L42;
    L35:
        if (r119.intValue() != 0) goto L36;
    L42:
        VideoView r122 = T3();
        if (r122 == null) goto L47;
        if (r116 == 0) goto L47;
        if (r117 == 0) goto L47;
        r122.f375947i = r116 / r117;
    L47:
        TextView r123 = this.f375991l;
        MediaEntity r124 = this.f375982c;
        if (r124 == null) goto L50;
        String r125 = r124.getMedia_des();
    L51:
        r123.setText(r125);
        TextView r126 = this.f375990k;
        MediaEntity r127 = this.f375982c;
        if (r127 == null) goto L54;
        String r128 = r127.getMedia_account_name();
    L55:
        r126.setText(r128);
        VideoView r129 = T3();
        if (r129 == null) goto L58;
        r129.setAllowGesture(true);
    L58:
        VideoView r130 = T3();
        if (r130 == null) goto L61;
        r130.setPlayButtonVisible(8);
    L61:
        VideoView r131 = T3();
        if (r131 == null) goto L64;
        final TikTokVideoViewHolder r132 = (TikTokVideoViewHolder) this;
        Function1<? super Integer, Unit> r133 = new y(r132);
        Intrinsics.checkNotNullParameter(r133, "block");
        r131.f375940b = r133;
    L64:
        VideoView r134 = T3();
        if (r134 == null) goto L67;
        final TikTokVideoViewHolder r135 = (TikTokVideoViewHolder) this;
        Function1<? super Integer, Unit> r136 = new z(r135);
        Intrinsics.checkNotNullParameter(r136, "block");
        r134.f375939a = r136;
    L67:
        MediaEntity r137 = this.f375982c;
        if (r137 == null) goto L70;
        String r138 = r137.getVideo_model();
    L71:
        if (r138 != null) goto L73;
    L76:
        float r139 = 0.0f;
        if (r102 == true) goto L101;
        VideoView r140 = T3();
        if (r140 == null) goto L119;
        IVideoController r141 = this.f375981b;
        if ((r141 instanceof com.larus.video.impl.sdk.o) == false) goto L83;
        com.larus.video.impl.sdk.o r142 = (com.larus.video.impl.sdk.o) r141;
    L84:
        if (r142 == null) goto L86;
        TTVideoEngine r143 = r142.f375814d;
    L87:
        MediaEntity r144 = this.f375982c;
        boolean r145 = VideoView.G;
        Intrinsics.checkNotNullParameter(this, "videoViewHolder");
        r140.f375954p = r144;
        r140.f375955q = this;
        r140.f375946h = 0.0f;
        r140.f375942d.setVisibility(0);
        r140.f375943e.setVisibility(8);
        if (r141 == null) goto L90;
        r140.f375957s = r141;
    L90:
        if (r143 == null) goto L92;
        r140.f375958t = r143;
    L92:
        if (r144 == null) goto L119;
        Integer r146 = r144.getMedia_height();
        if (r146 != null) goto L97;
    L99:
        Integer r147 = r144.getMedia_width();
        Intrinsics.checkNotNull(r147);
        float r148 = r147.intValue();
        Integer r149 = r144.getMedia_height();
        Intrinsics.checkNotNull(r149);
        r139 = r148 / r149.intValue();
    L100:
        r140.f375947i = r139;
        r140.f375948j = new VideoView.f(null);
        r140.f375952n = String.valueOf(r144.getMedia_cover_image());
        r140.f375950l = r144.getMedia_cover_image();
        r140.e();
        goto L119
    L97:
        if (r146.intValue() != 0) goto L99;
    L86:
        r143 = null;
        goto L87
    L83:
        r142 = null;
    L119:
        SeekBar r150 = (SeekBar) this.f375986g.getValue();
        if (r150 == null) goto L122;
        r150.setOnSeekBarChangeListener(new a0((TikTokVideoViewHolder) this));
    L122:
        final TikTokVideoViewHolder r151 = (TikTokVideoViewHolder) this;
        e1.d(this.f375992m, new v(r151));
        return;
    L101:
        VideoView r152 = T3();
        if (r152 == null) goto L119;
        IVideoController r153 = this.f375981b;
        if ((r153 instanceof com.larus.video.impl.sdk.o) == false) goto L106;
        com.larus.video.impl.sdk.o r154 = (com.larus.video.impl.sdk.o) r153;
    L107:
        if (r154 == null) goto L109;
        TTVideoEngine r155 = r154.f375814d;
    L110:
        MediaEntity r156 = this.f375982c;
        boolean r157 = VideoView.G;
        Intrinsics.checkNotNullParameter(this, "videoViewHolder");
        r152.f375954p = r156;
        r152.f375955q = this;
        r152.f375946h = 0.0f;
        r152.f375942d.setVisibility(0);
        r152.f375943e.setVisibility(8);
        if (r153 == null) goto L113;
        r152.f375957s = r153;
    L113:
        if (r155 == null) goto L115;
        r152.f375958t = r155;
    L115:
        if (r156 == null) goto L119;
        Integer r158 = r156.getMedia_width();     // Catch: Throwable -> L124
        Intrinsics.checkNotNull(r158);     // Catch: Throwable -> L124
        float r159 = r158.intValue();     // Catch: Throwable -> L124
        Integer r160 = r156.getMedia_height();     // Catch: Throwable -> L124
        Intrinsics.checkNotNull(r160);     // Catch: Throwable -> L124
        r139 = r159 / r160.intValue();
    L118:
        r152.f375947i = r139;
        r152.f375948j = new VideoView.f(null);
        r152.f375951m = r156.getMedia_url();
        r152.f375952n = String.valueOf(r156.getMedia_cover_image());
        r152.f375950l = r156.getMedia_cover_image();
        r152.e();
        goto L119
    L109:
        r155 = null;
        goto L110
    L106:
        r154 = null;
        goto L107
    L73:
        if (r138.length() == 0) goto L76;
        r102 = false;
        goto L76
    L70:
        r138 = null;
        goto L71
    L54:
        r128 = null;
        goto L55
    L50:
        r125 = null;
        goto L51
    }
}
