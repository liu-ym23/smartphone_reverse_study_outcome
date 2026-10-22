package i47;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public interface d {
    Map<String, String> getOptions();

    Map<String, String> getRequestHeaders();

    Uri getUrl();

    boolean isForMainFrame();
}
