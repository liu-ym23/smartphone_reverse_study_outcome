package of;

import android.content.Context;
import androidx.fragment.app.DialogFragment;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f523060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f523061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f523062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DialogFragment f523063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final JSONObject f523064e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L16;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f523060a, r101.f523060a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f523061b, r101.f523061b) == true) goto L10;
        return false;
    L10:
        if (this.f523062c == r101.f523062c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f523063d, r101.f523063d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f523064e, r101.f523064e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    public final int hashCode() {
        Context r100 = this.f523060a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f523061b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f523062c;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        int r109 = (r106 + r108) * 31;
        DialogFragment r110 = this.f523063d;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        JSONObject r113 = this.f523064e;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        return r112 + r101;
    L16:
        r111 = 0;
        goto L17
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "UserTrackerContext(context=" + this.f523060a + ", pageId=" + this.f523061b + ", canShowPendant=" + this.f523062c + ", pendantDialogFragment=" + this.f523063d + ", pendantMargin=" + this.f523064e + ")";
    }

    public final Context getContext() {
        return this.f523060a;
    }

    public b(Context r100, String r101, boolean r102, DialogFragment r103, JSONObject r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pageId");
        this.f523060a = r100;
        this.f523061b = r101;
        this.f523062c = r102;
        this.f523063d = r103;
        this.f523064e = r104;
    }

    public /* synthetic */ b(Context r100, String r101, boolean r102, DialogFragment r110, int r111) {
        if ((r111 & 4) == 0) goto L5;
        boolean r103 = false;
    L7:
        if ((r111 & 8) == 0) goto L9;
        r110 = null;
    L9:
        this(r100, r101, r103, r110, null);
        return;
    L5:
        r103 = r102;
        goto L7
    }
}
