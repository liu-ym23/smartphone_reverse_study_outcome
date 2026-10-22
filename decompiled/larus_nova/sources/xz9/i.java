package xz9;

import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.larus.common_ui.widget.CircleProgressBar;
import com.larus.nova.R;
import com.larus.uaigc.music.widget.LyricsToSongTemplatePlayerView;
import com.larus.utils.e1;

/* JADX INFO: loaded from: classes31.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LyricsToSongTemplatePlayerView f565553a;

    public /* synthetic */ i(LyricsToSongTemplatePlayerView r100) {
        this.f565553a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LyricsToSongTemplatePlayerView r100 = this.f565553a;
        ImageView r101 = r100.f373818c;
        if (r101 == null) goto L5;
        r101.setImageDrawable(ResourcesCompat.getDrawable(r100.getResources(), R.drawable.larus_music_disable_img, null));
    L5:
        ImageView r102 = r100.f373818c;
        if (r102 == null) goto L8;
        e1.x(r102);
    L8:
        ImageView r103 = r100.f373819d;
        if (r103 == null) goto L11;
        e1.q(r103);
    L11:
        CircleProgressBar r104 = r100.f373817b;
        if (r104 == null) goto L15;
        e1.q(r104);
        return;
    }
}
