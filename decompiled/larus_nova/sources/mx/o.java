package mx;

import android.graphics.Rect;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f516155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f516156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f516157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f516158d;

    public static final class a {
    }

    static {
        new Rect(16, 6, 16, 6);
    }

    public /* synthetic */ o(String r100, Rect r101) {
        this(r100, 13.0f, r101);
    }

    public o(String r100, float r101, Rect r102) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r102, "marginsDp");
        this.f516155a = r100;
        this.f516156b = R.color.ttlive_white_50;
        this.f516157c = r101;
        this.f516158d = r102;
    }
}
