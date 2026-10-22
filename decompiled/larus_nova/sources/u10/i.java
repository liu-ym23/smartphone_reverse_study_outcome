package u10;

import com.byted.cast.common.Constants;
import com.bytedance.retrofit2.mime.TypedOutput;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes45.dex */
public final class i extends RequestBody {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f548281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TypedOutput f548282b;

    @Override // okhttp3.RequestBody
    public final long contentLength() {
        return this.f548282b.length();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // okhttp3.RequestBody
    public final MediaType contentType() {
        return (MediaType) this.f548281a.element;
    }

    @Override // okhttp3.RequestBody
    public final void writeTo(BufferedSink r100) {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        this.f548282b.writeTo(r100.outputStream());
    }

    public i(Ref.ObjectRef r100, TypedOutput r101) {
        this.f548281a = r100;
        this.f548282b = r101;
    }
}
