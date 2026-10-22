package evc;

import javax.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes42.dex */
public final class g extends ResponseBody {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f474511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f474512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BufferedSource f474513c;

    @Override // okhttp3.ResponseBody
    public final MediaType contentType() {
        String r100 = this.f474511a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return MediaType.parse(r100);
    }

    @Override // okhttp3.ResponseBody
    public final long contentLength() {
        return this.f474512b;
    }

    @Override // okhttp3.ResponseBody
    public final BufferedSource source() {
        return this.f474513c;
    }

    public g(@Nullable String r100, long r101, BufferedSource r102) {
        this.f474511a = r100;
        this.f474512b = r101;
        this.f474513c = r102;
    }
}
