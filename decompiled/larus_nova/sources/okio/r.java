package okio;

import com.byted.cast.common.Constants;
import java.io.IOException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class r extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MessageDigest f524102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Mac f524103c;

    public static final class a {
    }

    static {
    }

    public r(Sink r100, MessageDigest r101) {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        Intrinsics.checkNotNullParameter(r101, "digest");
        super(r100);
        this.f524102b = r101;
        this.f524103c = null;
    }

    @Override // okio.n, okio.Sink
    public final void write(Buffer r100, long r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "source");
        b.b(r100.size(), 0, r101);
        g0 r102 = r100.head;
        Intrinsics.checkNotNull(r102);
        long r103 = 0;
    L4:
        if (r103 >= r101) goto L10;
        int r104 = (int) Math.min(r101 - r103, r102.f524019c - r102.f524018b);
        MessageDigest r105 = this.f524102b;
        if (r105 == null) goto L8;
        r105.update(r102.f524017a, r102.f524018b, r104);
    L9:
        r103 = r103 + ((long) r104);
        r102 = r102.f524022f;
        Intrinsics.checkNotNull(r102);
        goto L4
    L8:
        Mac r106 = this.f524103c;
        Intrinsics.checkNotNull(r106);
        r106.update(r102.f524017a, r102.f524018b, r104);
        goto L9
    L10:
        super.write(r100, r101);
    }

    public r(Sink r100, Mac r101) {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        Intrinsics.checkNotNullParameter(r101, "mac");
        super(r100);
        this.f524103c = r101;
        this.f524102b = null;
    }
}
