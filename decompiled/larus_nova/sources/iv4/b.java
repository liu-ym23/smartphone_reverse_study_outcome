package iv4;

import android.content.Context;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f495938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f495939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f495940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f495941d;

    public final void a(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (this.f495938a == false) goto L5;
        int r101 = e.f483540a;
        r100.setTypeface(e.b(r100.getContext(), 1));
        return;
    L5:
        int r102 = e.f483540a;
        r100.setTypeface(e.b(r100.getContext(), 0));
    }

    public final Integer c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return Integer.valueOf(ContextCompat.getColor(r100, this.f495941d));
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof b) == true) goto L5;
        return false;
    L5:
        b r101 = (b) r100;
        if (this.f495938a == r101.f495938a) goto L8;
        return false;
    L8:
        if (this.f495939b != r101.f495939b) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L13;
        return false;
    L13:
        if (this.f495940c == r101.f495940c) goto L15;
        return false;
    L15:
        if (this.f495941d != r101.f495941d) goto L21;
        return true;
    L21:
        return false;
    L10:
        r102 = false;
        goto L11
    }

    public final void b(TextView r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        float r102 = this.f495939b;
        if (r101 == false) goto L5;
        int r103 = -2;
    L6:
        r100.setTextSize(r102 + r103);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public b(boolean r100, float r101, int r102, int r103) {
        this.f495938a = r100;
        this.f495939b = r101;
        this.f495940c = r102;
        this.f495941d = r103;
    }

    public /* synthetic */ b(boolean r100, float r101, int r102, int r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 14.0f;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 1;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = R.color.text_title;
    L14:
        this(r100, r101, r102, r103);
    }
}
