package i45;

import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.toolbar.media.impl.SelectedMediaItem;
import io.reactivex.disposables.Disposable;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public interface a {
    Disposable a(List<SelectedMediaItem> r100);

    boolean b();

    void c(JSONObject r100);

    FragmentActivity getActivity();
}
