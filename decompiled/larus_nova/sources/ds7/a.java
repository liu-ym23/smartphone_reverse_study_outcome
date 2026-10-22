package ds7;

import com.ss.android.downloadlib.constants.MimeType;
import org.nanohttpd.protocols.http.response.Response;
import org.nanohttpd.protocols.http.response.Status;

/* JADX INFO: loaded from: classes22.dex */
public final class a extends Response {
    public a() {
        super(Status.OK, MimeType.MP4, null, 0);
    }
}
