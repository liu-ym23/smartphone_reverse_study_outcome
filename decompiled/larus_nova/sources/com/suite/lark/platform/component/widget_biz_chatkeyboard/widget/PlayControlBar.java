package com.suite.lark.platform.component.widget_biz_chatkeyboard.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.utils.UIUtils;
import com.larksuite.framework.utils.e;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.suite.lark.platform.component.AudioSeekBar;
import y9c.d;

/* JADX INFO: loaded from: classes36.dex */
public class PlayControlBar extends LinearLayout implements com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CheckBox f460814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProgressBar f460815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AudioSeekBar f460816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f460817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f460818e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f460819f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a.InterfaceC5531a f460820g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f460821h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f460822i;

    public interface a {
        void a();

        void b();

        void onPause();

        void onPlay();

        void onProgressChanged(int r100);
    }

    public final void c() {
        if (this.f460822i == true) goto L6;
        LKUIToast.show(getContext(), R.string.Lark_Message_AudioMessageWithdrawToast);
        return;
    L6:
        if (this.f460814a.isChecked() == false) goto L8;
        pausePlay();
    L10:
        if (this.f460821h != null) goto L12;
        return;
    L12:
        if (this.f460814a.isChecked() == false) goto L14;
        this.f460821h.onPlay();
        return;
    L14:
        this.f460821h.onPause();
        return;
    L8:
        startPlay();
        goto L10
    }

    public String getDurationText() {
        return this.f460817d.getText().toString();
    }

    public float getProgress() {
        return this.f460816c.getProgress() * 0.1f;
    }

    @Override // com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a
    public final void pausePlay() {
        Log.d("PlayControlBar", "pausePlay");
        this.f460814a.setChecked(false);
        this.f460816c.setHovered(false);
    }

    @Override // com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a
    public final void resumePlay() {
        Log.d("PlayControlBar", "resumePlay");
        this.f460814a.setChecked(true);
        this.f460816c.setHovered(true);
    }

    @Override // com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a
    public final void startPlay() {
        Log.d("PlayControlBar", "startPlay");
        this.f460814a.setChecked(true);
        this.f460816c.setHovered(true);
    }

    @Override // com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a
    public final void stopPlay() {
        Log.d("PlayControlBar", "stopPlay");
        this.f460814a.setChecked(false);
        this.f460816c.setHovered(false);
        setProgress(0.0f);
        post(new apc.a(this));
    }

    public a getDelegate() {
        return this.f460821h;
    }

    public int getDuration() {
        return this.f460818e;
    }

    public com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a.InterfaceC5531a getListener() {
        return this.f460820g;
    }

    public PlayControlBar(Context r100) {
        this(r100, null);
    }

    public static /* synthetic */ void a(PlayControlBar r100) {
        r100.setDurationText(1.0f);
        Log.d("PlayControlBar", "stopPlay:" + r100.f460819f);
    }

    private void setDurationText(float r100) {
        if (r100 >= 0.0f) goto L5;
    L7:
        String r101 = e.f(this.f460818e);
    L8:
        this.f460817d.setText(r101);
        return;
    L5:
        if (r100 >= 1.0f) goto L7;
        r101 = e.f((int) (this.f460818e * this.f460819f));
        goto L8
    }

    public void setDelegate(a r100) {
        this.f460821h = r100;
    }

    public void setDuration(int r100) {
        Log.d("PlayControlBar", "setDuration:" + r100);
        this.f460818e = r100;
        setDurationText(1.0f);
    }

    public void setDurationTvColor(int r100) {
        this.f460817d.setTextColor(r100);
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        this.f460814a.setEnabled(r100);
        this.f460814a.setClickable(r100);
        AudioSeekBar r101 = this.f460816c;
        if (r100 == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        r101.setEnabled(r102);
        return;
    L5:
        if (this.f460822i == false) goto L7;
        r102 = true;
        goto L8
    }

    public void setListener(com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a.InterfaceC5531a r100) {
        this.f460820g = r100;
    }

    public void setLoadingDrawable(Drawable r100) {
        Rect r101 = this.f460815b.getIndeterminateDrawable().getBounds();
        this.f460815b.setIndeterminateDrawable(r100);
        this.f460815b.getIndeterminateDrawable().setBounds(r101);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        super.setOnClickListener(r100);
        this.f460816c.setOnClickListener(r100);
        this.f460817d.setOnClickListener(r100);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r100) {
        super.setOnLongClickListener(r100);
        this.f460814a.setOnLongClickListener(r100);
        this.f460816c.setOnLongClickListener(r100);
        this.f460817d.setOnLongClickListener(r100);
    }

    public void setPlayBtnDrawable(Drawable r100) {
        this.f460814a.setButtonDrawable(r100);
    }

    @Override // com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a
    public void setProgress(float r100) {
        this.f460819f = r100 / 1.0f;
        AudioSeekBar r101 = this.f460816c;
        r101.setProgress((int) (r101.getMax() * this.f460819f));
    }

    public void setProgressBarDrawable(Drawable r100) {
        Rect r101 = this.f460816c.getProgressDrawable().getBounds();
        this.f460816c.setProgressDrawable(r100);
        this.f460816c.getProgressDrawable().setBounds(r101);
    }

    public void setResourceAvailable(boolean r100) {
        this.f460822i = r100;
        AudioSeekBar r101 = this.f460816c;
        if (r100 == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        r101.setEnabled(r102);
        return;
    L5:
        if (isEnabled() == false) goto L7;
        r102 = true;
        goto L8
    }

    public void setThumbDrawable(Drawable r100) {
        r100.setBounds(this.f460816c.getThumb().getBounds());
        this.f460816c.setThumb(r100);
    }

    public PlayControlBar(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static /* synthetic */ void b(PlayControlBar r100, float r101) {
        r100.setDurationText(r101);
    }

    public PlayControlBar(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112, 0);
        this.f460819f = 1.0f;
        this.f460822i = true;
        setOrientation(0);
        setGravity(16);
        FrameLayout r100 = new FrameLayout(r110);
        addView(r100, xbc.b.c(-2, 8388627, 0, 1));
        CheckBox r113 = new CheckBox(r110);
        this.f460814a = r113;
        r113.setId(R.id.play_btn);
        r113.setBackground(null);
        r113.setButtonDrawable(R.drawable.ic_play_selector);
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(xbc.b.e(20.0f), xbc.b.e(20.0f));
        r101.gravity = 17;
        r100.addView(r113, r101);
        ProgressBar r102 = new ProgressBar(r110);
        this.f460815b = r102;
        r102.setId(R.id.loading_progress);
        r102.setInterpolator(new AccelerateDecelerateInterpolator());
        r102.setIndeterminateDrawable(d.e(r110, R.drawable.play_control_loading_bg));
        r102.setVisibility(8);
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(xbc.b.e(20.0f), xbc.b.e(20.0f));
        r103.gravity = 17;
        r100.addView(r102, r103);
        AudioSeekBar r104 = new AudioSeekBar(r110, null, 0, R.style.PlayControlSeekBarDefaultStyle);
        this.f460816c = r104;
        r104.setId(R.id.play_seekbar);
        r104.setMax(1000);
        r104.setBackground(null);
        r104.setPadding(UIUtils.dp2px(r110, 11.0f), 0, UIUtils.dp2px(r110, 8.0f), 0);
        r104.setProgressDrawable(UIUtils.getDrawable(r110, R.drawable.seekbar_progress));
        r104.setThumb(UIUtils.getDrawable(r110, R.drawable.seekbar_thumb_selector));
        r104.setThumbOffset(UIUtils.dp2px(r110, 5.0f));
        r104.setSplitTrack(false);
        LinearLayout.LayoutParams r105 = xbc.b.c(0, 16, 2, 2);
        r105.weight = 1.0f;
        addView(r104, r105);
        TextView r114 = new TextView(r110);
        this.f460817d = r114;
        r114.setTextSize(12.0f);
        r114.setTextColor(UIUtils.getColor(r110, R.color.imtoken_message_voice_text_time_grey));
        float r106 = -2;
        LinearLayout.LayoutParams r115 = new LinearLayout.LayoutParams(xbc.b.e(r106), xbc.b.e(r106));
        r115.gravity = 16;
        addView(r114, r115);
        r104.setOnSeekBarChangeListener(new b(this));
        r113.setOnClickListener(new apc.b(this));
    }
}
