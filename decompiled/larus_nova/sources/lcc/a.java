package lcc;

import android.text.TextPaint;
import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TextPaint f508641a = null;

    /* JADX INFO: renamed from: lcc.a$a, reason: collision with other inner class name */
    public static final class C6677a {
        public static CharSequence a(CharSequence r100, float r101, float r102, TextUtils.TruncateAt r103) {
            Intrinsics.checkNotNullParameter(r100, "content");
            Intrinsics.checkNotNullParameter(r103, "where");
            TextPaint r104 = a.f508641a;
            r104.setTextSize(r102);
            return TextUtils.ellipsize(r100, r104, r101, r103);
        }
    }

    static {
        f508641a = new TextPaint();
    }
}
