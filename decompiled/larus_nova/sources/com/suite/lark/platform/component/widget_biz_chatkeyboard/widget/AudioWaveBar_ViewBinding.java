package com.suite.lark.platform.component.widget_biz_chatkeyboard.widget;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes36.dex */
public class AudioWaveBar_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AudioWaveBar f460798a;

    @Override // butterknife.Unbinder
    public final void unbind() {
        AudioWaveBar r100 = this.f460798a;
        if (r100 == null) goto L7;
        this.f460798a = null;
        r100.mWaveView = null;
        r100.mDurationTv = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public AudioWaveBar_ViewBinding(AudioWaveBar r100, View r101) {
        this.f460798a = r100;
        r100.mWaveView = (AudioWaveView) Utils.findRequiredViewAsType(r101, R.id.wave_view, "field 'mWaveView'", AudioWaveView.class);
        r100.mDurationTv = (TextView) Utils.findRequiredViewAsType(r101, R.id.duration_tv, "field 'mDurationTv'", TextView.class);
    }
}
