package g85;

import com.bytedance.ee.bear.drive.mimetype.MimeTypeCategory;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public final MimeTypeCategory a;
    public final String b;
    public final int c;
    public final int d;
    public final List<Integer> e;

    public e(MimeTypeCategory r1, String r2, int r3, int r4, List r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = Collections.unmodifiableList(r5);
    }
}
