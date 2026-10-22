package a65;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.DocMetaInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public final FragmentActivity a;
    public final boolean b;
    public final DocMetaInfo c;
    public final String d;

    public c(FragmentActivity r2, boolean r3, DocMetaInfo r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r5, "fileId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
