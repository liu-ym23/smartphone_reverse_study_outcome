package ec4;

import com.bytedance.retrofit2.mime.DigestUtil;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements TypedOutput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ byte[] f472079a;

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final String fileName() {
        return null;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final String mimeType() {
        return null;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final long length() {
        return this.f472079a.length;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final String md5Stub() {
        byte[] r100 = this.f472079a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return DigestUtil.md5Hex(r100);
    }

    public d(byte[] r100) {
        this.f472079a = r100;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final void writeTo(OutputStream r100) throws IOException {
        r100.write(this.f472079a);
    }
}
