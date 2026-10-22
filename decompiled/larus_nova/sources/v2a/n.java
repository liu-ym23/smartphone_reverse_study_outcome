package v2a;

import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.voice_setting.impl.databinding.LarusLayoutVoiceEditAreaNewBinding;
import com.larus.voice_setting.voice.mix.VoiceMixedView;
import com.larus.voice_setting.voice.mix.VoiceSingleView;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: classes32.dex */
public final class n implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarusLayoutVoiceEditAreaNewBinding f552758a;

    @Override // v2a.a
    public final VoiceMixedView d() {
        return null;
    }

    @Override // v2a.a
    public final View e() {
        return null;
    }

    @Override // v2a.a
    public final ConstraintLayout a() {
        return this.f552758a.f376149b;
    }

    @Override // v2a.a
    public final TextView b() {
        return this.f552758a.f376152e;
    }

    @Override // v2a.a
    public final AppCompatTextView c() {
        return this.f552758a.f376154g;
    }

    @Override // v2a.a
    public final View f() {
        return this.f552758a.f376156i;
    }

    @Override // v2a.a
    public final SeekBar g() {
        return this.f552758a.f376150c;
    }

    @Override // v2a.a
    public final ImageView getPlayIcon() {
        VoiceSingleView r100 = this.f552758a.f376157j;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPlayIcon();
    }

    @Override // v2a.a
    public final View getRoot() {
        return this.f552758a.f376148a;
    }

    @Override // v2a.a
    public final LottieAdapterView h() {
        VoiceSingleView r100 = this.f552758a.f376157j;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPlayLottie();
    }

    @Override // v2a.a
    public final SeekBar i() {
        return this.f552758a.f376153f;
    }

    @Override // v2a.a
    public final AppCompatTextView j() {
        return this.f552758a.f376151d;
    }

    @Override // v2a.a
    public final VoiceSingleView k() {
        return this.f552758a.f376157j;
    }

    @Override // v2a.a
    public final TextView l() {
        return this.f552758a.f376155h;
    }

    public n(LarusLayoutVoiceEditAreaNewBinding r100) {
        this.f552758a = r100;
    }
}
