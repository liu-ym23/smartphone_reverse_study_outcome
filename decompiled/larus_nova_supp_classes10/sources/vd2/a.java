package vd2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public final int a;
    public final int b;
    public LyricsDisplayConfig c;
    public final Map<String, vd2.b> d;
    public Disposable e;
    public int f;
    public int g;
    public float h;
    public float i;
    public float j;
    public boolean k;
    public int l;

    /* JADX INFO: renamed from: vd2.a$a, reason: collision with other inner class name */
    public static final class C0181a<T> implements ObservableOnSubscribe {
        public final /* synthetic */ a a;
        public final /* synthetic */ List b;
        public final /* synthetic */ float c;
        public final /* synthetic */ float d;
        public final /* synthetic */ float e;
        public final /* synthetic */ int f;

        public C0181a(a r1, List r2, float r3, float r4, float r5, int r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public final void subscribe(ObservableEmitter<List<Pair<String, vd2.b>>> r20) {
            C0181a<T> r0 = this;
            Intrinsics.checkNotNullParameter(r20, "emitter");
            System.currentTimeMillis();
            ArrayList r2 = new ArrayList();
            List r3 = r0.b;
            LyricsDisplayConfig r4 = r0.a.c;
            if (r3 == null) goto L27;
            if (r4 == null) goto L27;
            float r5 = (r4.k.getFontMetrics().bottom - r4.k.getFontMetrics().top) + r4.k.getFontMetrics().leading;
            float r6 = (r4.l.getFontMetrics().bottom - r4.l.getFontMetrics().top) + r4.l.getFontMetrics().leading;
            float r7 = (r4.i.getFontMetrics().bottom - r4.i.getFontMetrics().top) + r4.i.getFontMetrics().leading;
            float r9 = (r5 / 2.0f) + r0.c;
            float r10 = (r6 / 2.0f) + r0.d;
            float r11 = (r7 / 2.0f) + r0.e;
            Iterator<T> r8 = r3.iterator();
            int r13 = 0;
        L7:
            if (r8.hasNext() == false) goto L27;
            T r14 = r8.next();
            int r15 = r13 + 1;
            if (r13 >= 0) goto L11;
            CollectionsKt.throwIndexOverflow();
        L11:
            com.bytedance.component.lyric.model.b r16 = (com.bytedance.component.lyric.model.b) r14;
            int r12 = r0.f;
            if (r13 < r12) goto L26;
            a r17 = r0.a;
            if (r13 >= (r12 + r17.a)) goto L26;
            String r1 = r16.d;
            if (r1 == null) goto L26;
            if (r17.d.containsKey(r1) == true) goto L26;
            float r18 = r4.k.measureText(r1);
            float r19 = 0;
            if (r18 <= r19) goto L26;
            if (r5 <= r19) goto L26;
            Bitmap r21 = Bitmap.createBitmap((int) r18, (int) r5, Bitmap.Config.ARGB_8888);
            Canvas r110 = new Canvas(r21);
            r4.k.setStrokeWidth(0.0f);
            r110.drawText(r1, 0.0f, r9, r4.k);
            Bitmap r111 = Bitmap.createBitmap((int) r4.l.measureText(r1), (int) r6, Bitmap.Config.ARGB_8888);
            Canvas r112 = new Canvas(r111);
            r4.k.setStrokeWidth(UtilityKotlinExtentionsKt.h(2.0f));
            r112.drawText(r1, 0.0f, r10, r4.k);
            r112.drawText(r1, 0.0f, r10, r4.l);
            r4.k.setStrokeWidth(0.0f);
            Bitmap r22 = Bitmap.createBitmap((int) r4.i.measureText(r1), (int) r7, Bitmap.Config.ARGB_8888);
            new Canvas(r22).drawText(r1, 0.0f, r11, r4.i);
            vd2.b r23 = new vd2.b();
            r23.b = r111;
            r23.a = r21;
            r23.c = r22;
            r2.add(new Pair(r1, r23));
        L26:
            r0 = this;
            r13 = r15;
            r8 = r8;
            r4 = r4;
        L27:
            r20.onNext(r2);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ int b;

        public b(a r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            this.a.k = false;
            Iterator<T> r5 = ((List) r4).iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            Pair r0 = (Pair) r5.next();
            this.a.d.put((String) r0.getFirst(), (vd2.b) r0.getSecond());
            goto L4
        L6:
            a r6 = this.a;
            r6.l = (this.b + r6.a) - 1;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.getClass();
            ALogger.e("KtvMvLyricsBitmapCache", "load cache error, " + Log.getStackTraceString((Throwable) r3));
        }
    }

    public final void b() {
        this.k = false;
        this.l = 0;
        Disposable r0 = this.e;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Iterator r1 = ((LinkedHashMap) this.d).entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L17;
        Map.Entry r2 = (Map.Entry) r1.next();
        Bitmap r3 = ((vd2.b) r2.getValue()).a;
        if (r3 == null) goto L11;
        r3.recycle();
    L11:
        Bitmap r4 = ((vd2.b) r2.getValue()).c;
        if (r4 == null) goto L14;
        r4.recycle();
    L14:
        Bitmap r5 = ((vd2.b) r2.getValue()).b;
        if (r5 == null) goto L7;
        r5.recycle();
        goto L7
    L17:
        ((LinkedHashMap) this.d).clear();
    }

    public a() {
        this.a = ((Number) KtvSettingHelper.e0.getValue()).intValue();
        this.b = ((Number) KtvSettingHelper.g0.getValue()).intValue();
        this.d = new LinkedHashMap();
    }

    public final void a(List<com.bytedance.component.lyric.model.b> r10, int r11) {
        int r0 = this.l;
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (r11 >= (r0 - this.b)) goto L7;
        return;
    L7:
        if (this.k == true) goto L12;
        c(r10, r0 + 1, this.f, this.g, this.h, this.i, this.j);
        return;
    }

    public final void c(List<com.bytedance.component.lyric.model.b> r8, int r9, int r10, int r11, float r12, float r13, float r14) {
        this.f = r10;
        this.g = r11;
        this.h = r12;
        this.i = r13;
        this.j = r14;
        if ((r9 % 2) == 0) goto L5;
        int r6 = r9 - 1;
    L6:
        this.k = true;
        this.e = Observable.create(new C0181a(this, r8, r12, r14, r13, r6)).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r9), new c(this));
        return;
    L5:
        r6 = r9;
        goto L6
    }
}
