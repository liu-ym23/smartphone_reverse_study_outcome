package g38;

import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes24.dex */
public final class c<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class<T> f479870a;

    public c(Class<T> r100) {
        this.f479870a = r100;
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final T parse(byte[] r100) {
        return (T) ProtoAdapter.get(this.f479870a).decode(r100);
    }
}
