package ho8;

import com.larus.im.bean.message.Message;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f486264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Message f486265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f486266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f486267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f486268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f486269g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f486263a == r101.f486263a) goto L12;
        return false;
    L12:
        if (this.f486264b == r101.f486264b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f486265c, r101.f486265c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f486266d, r101.f486266d) == true) goto L21;
        return false;
    L21:
        if (Float.compare(this.f486267e, r101.f486267e) == 0) goto L24;
        return false;
    L24:
        if (this.f486268f == r101.f486268f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f486269g, r101.f486269g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f486263a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((((((r101 * 31) + this.f486264b) * 31) + this.f486265c.hashCode()) * 31) + this.f486266d.hashCode()) * 31) + Float.floatToIntBits(this.f486267e)) * 31;
        if (this.f486268f == true) goto L11;
        r100 = 1237;
    L11:
        return ((r102 + r100) * 31) + this.f486269g.hashCode();
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "WidgetVMData(needAdjustCorner=" + this.f486263a + ", maxWidth=" + this.f486264b + ", message=" + this.f486265c + ", renderData=" + this.f486266d + ", radius=" + this.f486267e + ", enableCache=" + this.f486268f + ", extraData=" + this.f486269g + ')';
    }

    public a(boolean r100, int r101, Message r102, String r103, float r104, boolean r105, Map<String, ? extends Object> r106) {
        Intrinsics.checkNotNullParameter(r102, "message");
        Intrinsics.checkNotNullParameter(r103, "renderData");
        Intrinsics.checkNotNullParameter(r106, ControlRule.KEY_EXTRA_DATA);
        this.f486263a = r100;
        this.f486264b = r101;
        this.f486265c = r102;
        this.f486266d = r103;
        this.f486267e = r104;
        this.f486268f = r105;
        this.f486269g = r106;
    }
}
