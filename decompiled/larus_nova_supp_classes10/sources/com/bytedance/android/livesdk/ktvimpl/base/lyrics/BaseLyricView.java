package com.bytedance.android.livesdk.ktvimpl.base.lyrics;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdkapi.util.IMultiScenePreviewStatistics;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0005\u001a\u00020\u0004H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0014\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/BaseLyricView;", "Landroid/view/View;", "Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/a;", "", "Lcom/bytedance/component/lyric/model/LyricsDisplayConfig;", "getDisplayConfig", "Lcom/bytedance/android/livesdkapi/util/IMultiScenePreviewStatistics;", "a", "Lcom/bytedance/android/livesdkapi/util/IMultiScenePreviewStatistics;", "getMultiScenePreviewStatistics", "()Lcom/bytedance/android/livesdkapi/util/IMultiScenePreviewStatistics;", "setMultiScenePreviewStatistics", "(Lcom/bytedance/android/livesdkapi/util/IMultiScenePreviewStatistics;)V", "multiScenePreviewStatistics", "b", "Lcom/bytedance/component/lyric/model/LyricsDisplayConfig;", "getConfig", "()Lcom/bytedance/component/lyric/model/LyricsDisplayConfig;", "setConfig", "(Lcom/bytedance/component/lyric/model/LyricsDisplayConfig;)V", "config", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseLyricView extends View implements a {
    public IMultiScenePreviewStatistics a;
    public LyricsDisplayConfig b;

    public BaseLyricView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BaseLyricView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public abstract /* synthetic */ int getCurrentIndex();

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public abstract /* synthetic */ ArrayList<com.bytedance.component.lyric.model.b> getCurrentLyrics();

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public abstract /* synthetic */ Paint.Align getTextAlign();

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void resetCurrMusicProcess() {
    }

    public void setHideFirstLineLyric(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public void setLyricOneLineMaxWidth(float r1) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public void setLyricVisible(int r1) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void updateCurrentState(KtvRoomLyricsStateMachineConfig.d r1) {
    }

    public final LyricsDisplayConfig getConfig() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public LyricsDisplayConfig getDisplayConfig() {
        return this.b;
    }

    public final IMultiScenePreviewStatistics getMultiScenePreviewStatistics() {
        return this.a;
    }

    public final float a(Paint.FontMetrics r3) {
        Intrinsics.checkNotNullParameter(r3, "fontMetrics");
        float r0 = r3.descent;
        return ((r0 - r3.ascent) / 2) - r0;
    }

    public final void setConfig(LyricsDisplayConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public void setLyricAlignStyle(Paint.Align r2) {
        Intrinsics.checkNotNullParameter(r2, "align");
        Intrinsics.checkNotNullParameter(r2, "align");
    }

    public final void setMultiScenePreviewStatistics(IMultiScenePreviewStatistics r1) {
        this.a = r1;
    }

    public BaseLyricView(Context r1, AttributeSet r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        super(r1, r2);
        this.b = new LyricsDisplayConfig();
    }

    public /* synthetic */ BaseLyricView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        LyricsDisplayConfig r5 = this.b;
        if (r5.d != 0.0f) goto L5;
        r5.f(r1 - r5.k.measureText("   "));
    L5:
        LyricsDisplayConfig r6 = this.b;
        if (r6.d > 0) goto L9;
        float r7 = LyricsDisplayConfig.u;
        r6.f(LyricsDisplayConfig.u);
        return;
    }
}
