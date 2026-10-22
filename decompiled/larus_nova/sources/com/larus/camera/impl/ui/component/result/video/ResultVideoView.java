package com.larus.camera.impl.ui.component.result.video;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaMetadataRetriever;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.camera.impl.databinding.LarusLayoutResultVideoViewBinding;
import com.larus.camera.impl.ui.component.result.general.viewpager.e;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.common_ui.video.progress.PlayerProgressView;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.common.result.recycler.ECSaasScrollViewController;
import f06.b;
import f06.d;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import wx8.f;
import wx8.g;
import wx8.h;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0001,B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J,\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u000bJ\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0013J\u0006\u0010\u001f\u001a\u00020\u0013J\u0006\u0010 \u001a\u00020\u0013J\u000e\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u000bJ\b\u0010#\u001a\u00020\u0013H\u0002J\b\u0010$\u001a\u00020\u0013H\u0002J\b\u0010%\u001a\u00020\u0013H\u0002J\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\u0013H\u0002J\b\u0010)\u001a\u00020\tH\u0002J\b\u0010*\u001a\u00020\tH\u0002J\u0010\u0010+\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/camera/impl/ui/component/result/video/ResultVideoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/camera/impl/databinding/LarusLayoutResultVideoViewBinding;", ECSaasScrollViewController.SEARCH_SCROLL_STATE_DRAGGING, "", "latestDragSeekTime", "", "totalDuration", "callback", "Lcom/larus/camera/impl/ui/component/result/general/viewpager/IResultVideoOperation;", "unifiedControlsEnabled", "setData", "", "path", "", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "key", "enableVideoClick", "enable", "dispatchEventToPlayerProgress", "event", "Landroid/view/MotionEvent;", "startVideo", "stopVideo", "pauseVideo", "setUnifiedControlsEnabled", "enabled", "initUnifiedControls", "refreshUnifiedPlayState", "refreshUnifiedMutedState", "unifiedControlBackground", "Landroid/graphics/drawable/GradientDrawable;", "initVideoView", "initRetryView", "initSeekbar", "getVideoDuration", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResultVideoView extends ConstraintLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f322527g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusLayoutResultVideoViewBinding f322528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f322529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f322530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f322531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f322532e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f322533f;

    public static final class a {
    }

    static {
    }

    public final void S5() {
        if (this.f322533f == true) goto L5;
        return;
    L5:
        LarusLayoutResultVideoViewBinding r100 = this.f322528a;
        boolean r101 = r100.f321511f.f327998s;
        if (r101 == false) goto L8;
        int r102 = R.attr.larus_ic_voice_mute_v2;
    L9:
        if (r101 == false) goto L11;
        int r103 = R.drawable.larus_ic_voice_mute_v2;
    L12:
        r100.f321507b.setImageResource(c.b(r102, getContext(), r103));
        return;
    L11:
        r103 = R.drawable.larus_ic_voice_unmute;
        goto L12
    L8:
        r102 = R.attr.larus_ic_voice_unmute;
        goto L9
    }

    public final void T5() {
        if (this.f322533f == true) goto L5;
        return;
    L5:
        LarusLayoutResultVideoViewBinding r100 = this.f322528a;
        ImageView r101 = r100.f321508c;
        if (r100.f321511f.r() == false) goto L8;
        int r102 = android.R.drawable.ic_media_pause;
    L9:
        r101.setImageResource(r102);
        return;
    L8:
        r102 = android.R.drawable.ic_media_play;
        goto L9
    }

    public ResultVideoView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static String R5(MediaMetadataRetriever r110) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {9};
        b r111 = new b();
        g06.a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE));
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r104 = r103;
        int r105 = r104.length;
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L15;
        f06.a r107 = r104[r106];
        int r112 = r106;
        int r113 = r105;
        f06.a[] r114 = r104;
        d r108 = r107.preInvoke(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE, "android/media/MediaMetadataRetriever", "extractMetadata", r110, r101, "java.lang.String", r111);     // Catch: Exception -> L22
        if (r108.f474982a == true) goto L17;
        r100.add(r107);     // Catch: Exception -> L22
    L17:
        if (r108.f474982a == false) goto L21;
        return (String) r108.f474983b;
    L21:
        return r110.extractMetadata(9);
    L14:
        r106 = r112 + 1;
        r105 = r113;
        r104 = r114;
        goto L8
    L15:
        r108 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public final void setUnifiedControlsEnabled(boolean r100) {
        this.f322533f = r100;
        ImageView r101 = this.f322528a.f321508c;
        int r102 = 0;
        if (r100 == false) goto L5;
        int r103 = 0;
    L6:
        r101.setVisibility(r103);
        ImageView r104 = this.f322528a.f321507b;
        if (r100 == true) goto L10;
        r102 = 8;
    L10:
        r104.setVisibility(r102);
        if (r100 == false) goto L14;
        T5();
        S5();
        return;
    L14:
        return;
    L5:
        r103 = 8;
        goto L6
    }

    public ResultVideoView(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        LayoutInflater.from(r110).inflate(R.layout.larus_layout_result_video_view, this);
        int r112 = R.id.big_image_blank_icon;
        if (((ImageView) ViewBindings.findChildViewById(this, R.id.big_image_blank_icon)) == null) goto L17;
        r112 = R.id.explicit_audio_control;
        ImageView r113 = (ImageView) ViewBindings.findChildViewById(this, R.id.explicit_audio_control);
        if (r113 == null) goto L17;
        r112 = R.id.explicit_play_control;
        ImageView r100 = (ImageView) ViewBindings.findChildViewById(this, R.id.explicit_play_control);
        if (r100 == null) goto L17;
        r112 = R.id.player_progress;
        PlayerProgressView r101 = (PlayerProgressView) ViewBindings.findChildViewById(this, R.id.player_progress);
        if (r101 == null) goto L17;
        r112 = R.id.retry_view;
        RelativeLayout r102 = (RelativeLayout) ViewBindings.findChildViewById(this, R.id.retry_view);
        if (r102 == null) goto L17;
        r112 = R.id.video_view;
        VideoPlayView r114 = (VideoPlayView) ViewBindings.findChildViewById(this, R.id.video_view);
        if (r114 == null) goto L17;
        final LarusLayoutResultVideoViewBinding r115 = new LarusLayoutResultVideoViewBinding(this, r113, r100, r101, r102, r114);
        this.f322528a = r115;
        r114.setForceUpdateProgress(true);
        r114.i(false);
        r114.w(new wx8.d(this));
        r114.f327977d = new wx8.e(this);
        r114.setAfterClickCallBack(new h(this));
        r101.setSeekBarAlignToBottom(true);
        r101.k6(2000);
        r101.Y5(new f(), new g(r115, r101, this), 2);
        r102.setOnClickListener(new wx8.a(r115));
        GradientDrawable r116 = new GradientDrawable();
        r116.setShape(1);
        r116.setColor(ColorProtector.parseColor("#664E4E4E"));
        r100.setBackground(r116);
        GradientDrawable r117 = new GradientDrawable();
        r117.setShape(1);
        r117.setColor(ColorProtector.parseColor("#664E4E4E"));
        r113.setBackground(r117);
        e1.d(r100, new wx8.b(this));
        e1.d(r113, new wx8.c(this));
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r112)));
    }
}
