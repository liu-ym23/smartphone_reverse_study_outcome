package com.bytedance.android.shopping.widget.ecvideoplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.ss.ttvideoengine.utils.Error;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR$\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR$\u0010!\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001f\u0010\u000b\"\u0004\b \u0010\rR$\u0010%\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\t\u001a\u0004\b#\u0010\u000b\"\u0004\b$\u0010\r¨\u0006."}, d2 = {"Lcom/bytedance/android/shopping/widget/ecvideoplayer/PlayerDebugView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/widget/ecvideoplayer/b;", "Lcom/bytedance/android/shopping/widget/ecvideoplayer/ECVideoPlayer;", "ecVideoPlayer", "", "setPlayer", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "getPlayerExecutorTV", "()Landroid/widget/TextView;", "setPlayerExecutorTV", "(Landroid/widget/TextView;)V", "playerExecutorTV", "b", "getPlayerStatusTV", "setPlayerStatusTV", "playerStatusTV", "c", "Lcom/bytedance/android/shopping/widget/ecvideoplayer/ECVideoPlayer;", "getEcPlayer", "()Lcom/bytedance/android/shopping/widget/ecvideoplayer/ECVideoPlayer;", "setEcPlayer", "(Lcom/bytedance/android/shopping/widget/ecvideoplayer/ECVideoPlayer;)V", "ecPlayer", "d", "getProgressTV", "setProgressTV", "progressTV", "e", "getSurfaceTV", "setSurfaceTV", "surfaceTV", "f", "getEcVideoViewTV", "setEcVideoViewTV", "ecVideoViewTV", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerDebugView extends FrameLayout implements b {
    public TextView a;
    public TextView b;
    public ECVideoPlayer c;
    public TextView d;
    public TextView e;
    public TextView f;

    public static final class a implements View.OnLongClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r1) {
            int r2 = com.bytedance.android.shopping.widget.ecvideoplayer.a.a;
            int r3 = ECVideoView.h;
            return true;
        }
    }

    public PlayerDebugView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PlayerDebugView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void g() {
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onRenderStart() {
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onVideoSizeChanged(int r1, int r2) {
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void E() {
        TextView r0 = this.b;
        if (r0 == null) goto L6;
        r0.setText("PlayerStatus:Preparing");
        return;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onIdle() {
        TextView r0 = this.b;
        if (r0 == null) goto L6;
        r0.setText("PlayerStatus:Idle");
        return;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onPaused() {
        TextView r0 = this.b;
        if (r0 == null) goto L6;
        r0.setText("PlayerStatus:Paused");
        return;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onPlaying() {
        TextView r0 = this.b;
        if (r0 == null) goto L6;
        r0.setText("PlayerStatus:Playing");
        return;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onRelease() {
        TextView r0 = this.b;
        if (r0 == null) goto L6;
        r0.setText("PlayerStatus:Release");
        return;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void w() {
        TextView r0 = this.b;
        if (r0 == null) goto L6;
        r0.setText("PlayerStatus:Buffering");
        return;
    }

    public final ECVideoPlayer getEcPlayer() {
        return this.c;
    }

    public final TextView getEcVideoViewTV() {
        return this.f;
    }

    public final TextView getPlayerExecutorTV() {
        return this.a;
    }

    public final TextView getPlayerStatusTV() {
        return this.b;
    }

    public final TextView getProgressTV() {
        return this.d;
    }

    public final TextView getSurfaceTV() {
        return this.e;
    }

    public final void a(Surface r4) {
        Intrinsics.checkNotNullParameter(r4, "surface");
        TextView r0 = this.e;
        if (r0 == null) goto L6;
        r0.setText("surface:" + r4.hashCode());
        return;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onError(Error r4) {
        TextView r0 = this.b;
        if (r0 == null) goto L10;
        StringBuilder r1 = new StringBuilder("PlayerStatus:ERROR code= ");
        if (r4 == null) goto L7;
        Integer r5 = Integer.valueOf(r4.code);
    L8:
        r1.append(r5);
        r0.setText(r1.toString());
        return;
    L7:
        r5 = null;
        goto L8
    }

    public final void setEcPlayer(ECVideoPlayer r1) {
        this.c = r1;
    }

    public final void setEcVideoViewTV(TextView r1) {
        this.f = r1;
    }

    public final void setPlayer(ECVideoPlayer r4) {
        Intrinsics.checkNotNullParameter(r4, "ecVideoPlayer");
        TextView r0 = this.b;
        if (r0 == null) goto L5;
        r0.setText("PlayerStatus:None");
    L5:
        TextView r1 = this.a;
        if (r1 == null) goto L8;
        r1.setText("PlayerExecutor:" + r4.b.hashCode());
    L8:
        TextView r2 = this.f;
        if (r2 == null) goto L11;
        r2.setText("ECVideoView:" + getParent().hashCode());
    L11:
        this.c = r4;
        if (r4 == null) goto L15;
        r4.a(this);
        return;
    }

    public final void setPlayerExecutorTV(TextView r1) {
        this.a = r1;
    }

    public final void setPlayerStatusTV(TextView r1) {
        this.b = r1;
    }

    public final void setProgressTV(TextView r1) {
        this.d = r1;
    }

    public final void setSurfaceTV(TextView r1) {
        this.e = r1;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void h(int r4, int r5) {
        TextView r0 = this.d;
        if (r0 == null) goto L6;
        r0.setText("Progress:" + r4 + '/' + r5);
        return;
    }

    public PlayerDebugView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131560802, this);
        this.a = (TextView) findViewById(2131382467);
        this.b = (TextView) findViewById(2131382472);
        this.d = (TextView) findViewById(2131383332);
        this.e = (TextView) findViewById(2131387770);
        this.f = (TextView) findViewById(2131371245);
        TextView r5 = this.b;
        if (r5 == null) goto L5;
        r5.setText("PlayerStatus:None");
    L5:
        TextView r6 = this.a;
        if (r6 == null) goto L8;
        r6.setText("PlayerExecutor:None");
    L8:
        TextView r7 = this.d;
        if (r7 == null) goto L11;
        r7.setText("progress:None");
    L11:
        TextView r8 = this.e;
        if (r8 == null) goto L14;
        r8.setText("surface:None");
    L14:
        setOnLongClickListener(a.a);
    }

    public /* synthetic */ PlayerDebugView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
