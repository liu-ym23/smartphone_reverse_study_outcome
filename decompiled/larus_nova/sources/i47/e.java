package i47;

import com.bytedance.pia.core.api.resource.LoadFrom;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public interface e {
    LoadFrom a();

    InputStream getData();

    String getEncoding();

    Map<String, String> getHeaders();

    String getMimeType();

    String getReasonPhrase();

    int getStatusCode();
}
