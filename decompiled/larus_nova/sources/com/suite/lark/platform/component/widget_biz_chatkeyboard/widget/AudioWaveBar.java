package com.suite.lark.platform.component.widget_biz_chatkeyboard.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes36.dex */
public class AudioWaveBar extends LinearLayout {

    @BindView(7519)
    TextView mDurationTv;

    @BindView(8065)
    AudioWaveView mWaveView;

    public AudioWaveBar(Context r100) {
        this(r100, null);
    }

    public void setDurationText(String r100) {
        this.mDurationTv.setText(r100);
    }

    public void setProgress(int r100) {
        this.mWaveView.setProgress(r100);
    }

    public void setWaveBytes(byte[] r100) {
        this.mWaveView.setWaveformBytes(r100);
    }

    public AudioWaveBar(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public AudioWaveBar(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.audio_wave_bar_layout, this, true);
        ButterKnife.bind(this);
    }
}
