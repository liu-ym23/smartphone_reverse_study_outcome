package k31;

import com.bytedance.android.livesdk.model.n0;
import com.bytedance.android.livesdk.model.p0;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n0 f501645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p0 f501646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f501647c;

    public f() {
    }

    public final long a() {
        p0 r100 = this.f501646b;
        if (r100 == null) goto L11;
        String r101 = r100.getChannelId();
        if (r101 == null) goto L13;
        Long r102 = StringsKt.toLongOrNull(r101);
        if (r102 != null) goto L10;
        return 0;
    L10:
        return r102.longValue();
    L13:
        return 0;
    L11:
        return 0;
    }
}
