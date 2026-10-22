package f52;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.CleanStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ConflictStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.DiscardReason;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.PSTopContainer;
import com.bytedance.android.livesdkapi.message.HighlightAreaPriorityConfig;

/* JADX INFO: loaded from: classes9.dex */
public interface c {
    void a(DiscardReason r100);

    CleanStrategy b(b r100, c r101);

    HighlightAreaPriorityConfig c();

    ConflictStrategy d();

    void e(c r100, PSTopContainer r101);

    ConflictStrategy f();

    boolean g();

    int getDelayTime();

    int getDuration();

    long getEndTimestamp();

    String getId();

    long getStartTimestamp();

    f getType();

    void h(b r100);

    CleanStrategy i(b r100);

    boolean j(c r100);

    ConflictStrategy k();

    int l();
}
