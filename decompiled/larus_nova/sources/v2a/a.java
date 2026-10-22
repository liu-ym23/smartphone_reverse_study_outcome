package v2a;

import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.voice_setting.voice.mix.VoiceMixedView;
import com.larus.voice_setting.voice.mix.VoiceSingleView;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: classes32.dex */
public interface a {
    ConstraintLayout a();

    TextView b();

    AppCompatTextView c();

    VoiceMixedView d();

    View e();

    View f();

    SeekBar g();

    ImageView getPlayIcon();

    View getRoot();

    LottieAdapterView h();

    SeekBar i();

    AppCompatTextView j();

    VoiceSingleView k();

    TextView l();
}
