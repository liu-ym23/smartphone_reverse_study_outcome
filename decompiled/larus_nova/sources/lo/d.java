package lo;

import android.content.res.Resources;
import android.graphics.Rect;
import android.util.TypedValue;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ec.window.base.dynamicview.virtualview.j;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Llo/d;", "", "", "width", "Ljava/lang/Integer;", "getWidth", "()Ljava/lang/Integer;", "height", "getHeight", "", "radius", "Ljava/lang/Float;", "getRadius", "()Ljava/lang/Float;", "alpha", "getAlpha", "Llo/c;", "margins", "Llo/c;", "getMargins", "()Llo/c;", "", RemoteMessageConst.Notification.VISIBILITY, "Ljava/lang/String;", "getVisibility", "()Ljava/lang/String;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("alpha")
    private final Float alpha;

    @SerializedName("height")
    private final Integer height;

    @SerializedName("margins")
    private final c margins;

    @SerializedName("radius")
    private final Float radius;

    @SerializedName(RemoteMessageConst.Notification.VISIBILITY)
    private final String visibility;

    @SerializedName("width")
    private final Integer width;

    public final j b() {
        Integer r100 = this.width;
        int r101 = -2;
        if (r100 == null) goto L5;
        int r102 = r100.intValue();
    L6:
        int r103 = a(r102);
        Integer r104 = this.height;
        if (r104 == null) goto L9;
        r101 = r104.intValue();
    L9:
        int r105 = a(r101);
        Float r106 = this.radius;
        if (r106 == null) goto L12;
        float r107 = q.a(r106);
    L13:
        Float r108 = this.alpha;
        float r109 = 1.0f;
        if (r108 == null) goto L16;
        r109 = RangesKt.coerceIn(r108.floatValue(), 0.0f, 1.0f);
    L16:
        String r110 = this.visibility;
        if (r110 == null) goto L30;
        int r111 = r110.hashCode();
        if (r111 == (-1901805651)) goto L28;
        if (r111 != 3178655) goto L30;
        if (r110.equals("gone") == false) goto L30;
        int r112 = 8;
    L31:
        c r113 = this.margins;
        if (r113 == null) goto L34;
        Rect r114 = r113.a();
    L35:
        float r115 = r107;
        float r116 = r109;
        int r117 = r112;
        return new j(r103, r105, r115, r116, r117, r114);
    L34:
        r114 = new Rect();
        goto L35
    L28:
        if (r110.equals("invisible") == false) goto L30;
        r112 = 4;
    L30:
        r112 = 0;
        goto L31
    L12:
        r107 = 0.0f;
        goto L13
    L5:
        r102 = -2;
        goto L6
    }

    public d() {
        this.width = null;
        this.height = null;
        this.radius = null;
        this.alpha = null;
        this.margins = null;
        this.visibility = null;
    }

    public static int a(int r100) {
        if (r100 <= 0) goto L6;
        float r101 = Integer.valueOf(r100).floatValue();
        Resources r102 = th.a.f(uf4.a.a());
        return (int) Math.ceil(TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics())));
    L6:
        return r100;
    }
}
