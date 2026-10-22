package w3c;

import android.text.TextUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f558242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f558243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextUtils.TruncateAt f558244c;

    public h() {
        this(null, 0, 7);
    }

    public h(String r100, int r101, int r102) {
        TextUtils.TruncateAt r103 = null;
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = R.color.text_placeholder;
    L9:
        if ((r102 & 4) == 0) goto L11;
        r103 = TextUtils.TruncateAt.END;
    L11:
        this.f558242a = r100;
        this.f558243b = r101;
        this.f558244c = r103;
    }
}
