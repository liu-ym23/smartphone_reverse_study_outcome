package w3c;

import com.larus.nova.R;
import com.ss.android.lark.search.dto.info.TagContent;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f558235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f558236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f558237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f558238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<TagContent> f558239e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f558240f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f558241g;

    public g() {
        this(null, false, 15);
    }

    public g(CharSequence r100, boolean r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = true;
    L9:
        if ((r102 & 8) == 0) goto L11;
        int r103 = R.color.primary_fill_default;
    L12:
        this.f558235a = r100;
        this.f558236b = r101;
        this.f558237c = null;
        this.f558238d = r103;
        this.f558240f = true;
        return;
    L11:
        r103 = 0;
        goto L12
    }
}
