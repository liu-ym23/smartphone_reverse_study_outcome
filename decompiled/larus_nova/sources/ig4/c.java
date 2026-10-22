package ig4;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f489728f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f489729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f489730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<Float> f489731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f489732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f489733e;

    public static final class a {
        public static c a(Paint.Align r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "alig");
            int r102 = r100.ordinal();
            if (r102 != Paint.Align.LEFT.ordinal()) goto L6;
            c r103 = new b();
        L11:
            r103.f489729a = r101;
            return r103;
        L6:
            if (r102 != Paint.Align.RIGHT.ordinal()) goto L9;
            r103 = new e();
            goto L11
        L9:
            if (r102 != Paint.Align.CENTER.ordinal()) goto L14;
            r103 = new ig4.a();
            goto L11
        L14:
            throw new Exception("error Paint.Align");
        }
    }

    static {
    }

    public abstract void a(RectF r100, int r101, int r102, float r103, float r104, boolean r105);

    public abstract float c(int r100);

    public c() {
        this.f489729a = 1;
        this.f489730b = t6.a(jc1.a.b(), 10.0f);
        Float r100 = Float.valueOf(0.0f);
        this.f489731c = CollectionsKt.arrayListOf(new Float[]{r100, r100, r100});
        this.f489732d = t6.a(jc1.a.b(), 3.0f);
        this.f489733e = t6.a(jc1.a.b(), 5.5f);
    }

    public ArrayList<Float> e(float r100) {
        ListProtector.set(this.f489731c, 1, Float.valueOf(r100));
        float r101 = 2;
        ListProtector.set(this.f489731c, 0, Float.valueOf(r100 - ((this.f489732d * r101) + this.f489733e)));
        ListProtector.set(this.f489731c, 2, Float.valueOf((r100 + (this.f489732d * r101)) + this.f489733e));
        return this.f489731c;
    }

    public float d(int r100, int r101, Rect r102) {
        Intrinsics.checkNotNullParameter(r102, "lyricsRect");
        if (this.f489729a <= 1) goto L5;
        float r103 = this.f489730b;
    L7:
        return (((r100 + r102.height()) / 2.0f) - r101) - r103;
    L5:
        r103 = 0.0f;
        goto L7
    }

    public static /* synthetic */ void b(c r100, RectF r101, int r102, int r110, float r111, float r112) {
        r100.a(r101, r102, r110, r111, r112, true);
    }
}
