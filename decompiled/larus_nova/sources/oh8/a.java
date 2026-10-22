package oh8;

import android.util.LruCache;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.layout.item.LynxBox;
import java.util.List;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<String, List<LynxBox>> f523314a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Keva f523315b = null;

    static {
        f523314a = new LruCache(5);
        f523315b = Keva.getRepo("MARKDOWN_LYNX_HEIGHT");
    }
}
