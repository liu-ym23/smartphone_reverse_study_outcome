package pv2;

import android.graphics.Paint;
import androidx.camera.video.AudioStats;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.livesdk.widget.rollingTextView.Direction;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Character, Float> f530805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<pv2.a> f530806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f530807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f530808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f530809e;

    public static final class a {
    }

    static {
    }

    public final char[] a() {
        int r100 = ((ArrayList) this.f530806b).size();
        char[] r101 = new char[r100];
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r101[r102] = ((pv2.a) ListProtector.get(this.f530806b, r102)).f530797b;
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    public final float b() {
        List<pv2.a> r100 = this.f530806b;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(Float.valueOf(((pv2.a) r102.next()).f530796a));
        goto L4
    L6:
        Iterator r103 = r101.iterator();
        float r104 = 0.0f;
    L8:
        if (r103.hasNext() == false) goto L10;
        r104 = r104 + ((Number) r103.next()).floatValue();
        goto L8
    L10:
        return r104;
    }

    public final void c() {
        Iterator<T> r100 = this.f530806b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        pv2.a r101 = (pv2.a) r100.next();
        r101.f530797b = r101.f530798c;
        r101.f530801f = AudioStats.AUDIO_AMPLITUDE_NONE;
        r101.f530800e = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L4
    }

    public final void e() {
        this.f530805a.clear();
        Paint.FontMetrics r100 = this.f530809e.getFontMetrics();
        float r101 = r100.bottom;
        float r102 = r100.top;
        this.f530807c = r101 - r102;
        this.f530808d = -r102;
        Iterator<T> r103 = this.f530806b.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((pv2.a) r103.next()).a();
        goto L4
    }

    public b(Paint r100) {
        Intrinsics.checkNotNullParameter(r100, "textPaint");
        this.f530809e = r100;
        this.f530805a = new LinkedHashMap();
        this.f530806b = new ArrayList();
        e();
    }

    public final void d(CharSequence r110) {
        Intrinsics.checkNotNullParameter(r110, "targetText");
        String r100 = new String(a());
        int r101 = RangesKt.coerceAtLeast(r100.length(), r110.length());
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L13;
        if (r102 >= r110.length()) goto L7;
        char r103 = r110.charAt(r102);
    L8:
        Direction r104 = Direction.SCROLL_UP;
        if (r102 >= r100.length()) goto L11;
        pv2.a r105 = (pv2.a) ListProtector.get(this.f530806b, r102);
        r105.getClass();
        Intrinsics.checkNotNullParameter(r104, MapBundleKey.MapObjKey.OBJ_DIR);
        r105.f530798c = r103;
        r105.f530804i = r104;
        r105.a();
        r105.f530800e = r105.f530801f;
        r105.f530801f = AudioStats.AUDIO_AMPLITUDE_NONE;
    L12:
        r102 = r102 + 1;
        goto L3
    L11:
        ListProtector.add(this.f530806b, r102, new pv2.a(this, this.f530809e, r104));
        pv2.a r106 = (pv2.a) ListProtector.get(this.f530806b, r102);
        r106.getClass();
        Intrinsics.checkNotNullParameter(r104, MapBundleKey.MapObjKey.OBJ_DIR);
        r106.f530798c = r103;
        r106.f530804i = r104;
        r106.a();
        r106.f530800e = r106.f530801f;
        r106.f530801f = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L12
    L7:
        r103 = 0;
        goto L8
    }
}
