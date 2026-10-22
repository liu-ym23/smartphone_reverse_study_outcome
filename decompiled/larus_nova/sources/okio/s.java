package okio;

import com.byted.cast.common.Constants;
import java.io.IOException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class s extends ForwardingSource {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f524104c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MessageDigest f524105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Mac f524106b;

    public static final class a {
    }

    static {
    }

    public s(Source r100, MessageDigest r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "digest");
        super(r100);
        this.f524105a = r101;
        this.f524106b = null;
    }

    @Override // okio.ForwardingSource, okio.Source
    public final long read(Buffer r100, long r110) throws IOException {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        long r111 = super.read(r100, r110);
        if (r111 == (-1)) goto L15;
        long r101 = r100.size() - r111;
        long r102 = r100.size();
        g0 r103 = r100.head;
        Intrinsics.checkNotNull(r103);
    L6:
        if (r102 <= r101) goto L9;
        r103 = r103.f524023g;
        Intrinsics.checkNotNull(r103);
        r102 = r102 - ((long) (r103.f524019c - r103.f524018b));
    L9:
        if (r102 >= r100.size()) goto L15;
        int r104 = (int) ((((long) r103.f524018b) + r101) - r102);
        MessageDigest r105 = this.f524105a;
        if (r105 == null) goto L13;
        r105.update(r103.f524017a, r104, r103.f524019c - r104);
    L14:
        r102 = r102 + ((long) (r103.f524019c - r103.f524018b));
        r103 = r103.f524022f;
        Intrinsics.checkNotNull(r103);
        r101 = r102;
        goto L9
    L13:
        Mac r106 = this.f524106b;
        Intrinsics.checkNotNull(r106);
        r106.update(r103.f524017a, r104, r103.f524019c - r104);
    L15:
        return r111;
    }

    public s(Source r100, Mac r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "mac");
        super(r100);
        this.f524106b = r101;
        this.f524105a = null;
    }
}
