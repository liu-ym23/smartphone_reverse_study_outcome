package dx1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;

/* JADX INFO: loaded from: classes8.dex */
public interface a {
    View a(LayoutInflater r100, ViewGroup r101);

    void b();

    void c(FeedbackCard r100);

    void onDestroy();

    void onSlide();

    void onViewCreated(View r100);

    void startRoom();

    void stopRoom();
}
