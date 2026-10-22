package h64;

import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements TypedOutput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q64.d f483918a;

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final String md5Stub() {
        return null;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final String fileName() {
        return this.f483918a.b();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final long length() {
        return this.f483918a.c();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final String mimeType() {
        return this.f483918a.a();
    }

    public d(q64.d r100) {
        Intrinsics.checkNotNullParameter(r100, "requestBody");
        this.f483918a = r100;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final void writeTo(OutputStream r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        this.f483918a.d(r100);
    }
}
