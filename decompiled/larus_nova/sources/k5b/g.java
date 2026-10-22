package k5b;

import com.bytedance.lark.pb.basic.v1.File;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public final class g extends f {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f501924v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final RichText f501925w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f501926x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List<File> f501927y;

    public g(String r100, RichText r101, boolean r102, List<File> r103) {
        this.f501924v = r100;
        this.f501925w = r101;
        this.f501926x = r102;
        if (r103 != null) goto L5;
        r103 = Collections.emptyList();
    L5:
        this.f501927y = r103;
    }
}
