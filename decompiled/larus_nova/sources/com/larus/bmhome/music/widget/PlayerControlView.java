package com.larus.bmhome.music.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import com.larus.bmhome.music.databinding.LarusViewMusicPlayerControlBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0016\u001a\u00020\u0017H\u0014J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0017J\u001e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000b2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u001dJ\u001e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000b2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u001dJ\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020 J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$H\u0002J\u0006\u0010%\u001a\u00020\u0017J\u0006\u0010&\u001a\u00020\u0017J\u0012\u0010'\u001a\u00020\u00172\b\b\u0002\u0010(\u001a\u00020\u000eH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006)"}, d2 = {"Lcom/larus/bmhome/music/widget/PlayerControlView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "canPlayPrevious", "", "canPlayNext", "themeResource", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "binding", "Lcom/larus/bmhome/music/databinding/LarusViewMusicPlayerControlBinding;", "getBinding", "()Lcom/larus/bmhome/music/databinding/LarusViewMusicPlayerControlBinding;", "binding$delegate", "Lkotlin/Lazy;", "onAttachedToWindow", "", "setPlay", "setPause", "applyCanPlayPrevious", "can", "onClickListener", "Lkotlin/Function0;", "applyCanPlayNext", "setStartClickListener", "Landroid/view/View$OnClickListener;", "setPauseClickListener", "expandTouchDelegate", "delegate", "Landroid/view/View;", "setUIToDark", "setUIToLight", "setUIWithResource", "resource", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlayerControlView extends ConstraintLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f313288b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f313289a;

    public PlayerControlView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PlayerControlView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final LarusViewMusicPlayerControlBinding getBinding() {
        return (LarusViewMusicPlayerControlBinding) this.f313289a.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        final AppCompatImageView r100 = getBinding().f312767d;
        Object r101 = r100.getParent();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.View");
        final View r102 = (View) r101;
        r102.post(new o2(r100, r102));
        final AppCompatImageView r103 = getBinding().f312766c;
        Object r104 = r103.getParent();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.view.View");
        final View r105 = (View) r104;
        r105.post(new o2(r103, r105));
    }

    private final void setUIWithResource(Resources r100) {
        getBinding().f312767d.setImageDrawable(ResourcesCompat.getDrawable(r100, R.drawable.larus_ic_music_player_detail_play, null));
        getBinding().f312766c.setImageDrawable(ResourcesCompat.getDrawable(r100, R.drawable.larus_ic_music_player_detail_pause, null));
        getBinding().f312768e.setImageDrawable(ResourcesCompat.getDrawable(r100, v19.c.b(R.attr.larus_ic_music_player_detail_previous_song_disable, null, R.drawable.larus_ic_music_player_detail_previous_song_disable), null));
        getBinding().f312765b.setImageDrawable(ResourcesCompat.getDrawable(r100, v19.c.b(R.attr.larus_ic_music_player_detail_next_song_disable, null, R.drawable.larus_ic_music_player_detail_next_song_disable), null));
    }

    public final void setPauseClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "onClickListener");
        com.larus.utils.e1.c(getBinding().f312766c, r100);
    }

    public final void setStartClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "onClickListener");
        com.larus.utils.e1.c(getBinding().f312767d, r100);
    }

    public PlayerControlView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Context r103 = m2.f313352a;
        m2.f313352a.getResources();
        this.f313289a = LazyKt.lazy(new p2(r100, this));
    }

    public /* synthetic */ PlayerControlView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
