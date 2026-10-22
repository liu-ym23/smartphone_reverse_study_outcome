package k5b;

import com.bytedance.lark.pb.basic.v1.File;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public final class k extends f {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final RichText f501934v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List<File> f501935w;

    public k(RichText r100, List<File> r101) {
        this.f501934v = r100;
        if (r101 != null) goto L5;
        r101 = Collections.emptyList();
    L5:
        this.f501935w = r101;
    }
}
