package gvb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public interface a {
    Map<String, String> a();

    ByteString b();

    String c();

    boolean d();

    Map<String, String> e();

    Map<String, String> f();

    MmRecordingSource getClientSource();

    MmHttpContentType getContentType();

    MmHttpMethod getMethod();

    String getPath();
}
