package mh2;

import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.w0;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q {
    public static final HashMap<String, WeakReference<Bitmap>> a = null;

    static {
        a = new HashMap();
    }

    public static /* synthetic */ Disposable b(List r7, String r8, float r9, TextView r10, boolean r11, int r12) {
        if ((r12 & 32) == 0) goto L5;
        boolean r5 = false;
    L7:
        return a(r7, r8, 4.0f, r9, r10, r5, false);
    L5:
        r5 = r11;
        goto L7
    }

    public static SpannableStringBuilder c(List r6, String r7, float r8, float r9, TextView r10, boolean r11) {
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        Iterator r12 = r6.iterator();
    L4:
        if (r12.hasNext() == false) goto L12;
        Bitmap r1 = (Bitmap) r12.next();
        if (r1.isRecycled() == true) goto L4;
        int r2 = w0.a(r9);
        Bitmap r3 = Bitmap.createScaledBitmap(r1, (int) Math.ceil(((r2 * 1.0f) / r1.getHeight()) * r1.getWidth()), r2, true);
        SpannableString r4 = new SpannableString(" ");
        if (r11 == false) goto L10;
        b r5 = new b(r10.getContext(), r3);
        r5.a = w0.a(r8);
        Object r13 = r5;
    L11:
        r4.setSpan(r13, 0, 1, 17);
        r0.append(r4);
        goto L4
    L10:
        a r14 = new a(r10.getContext(), r3);
        r14.a = w0.a(r8);
        r13 = r14;
        goto L11
    L12:
        if (r7 == null) goto L15;
        r0.append(r7);
    L15:
        if (ECLiveABUtils.INSTANCE.getLIST_FPS_OPT_CONFIG().getEnableOpt() == true) goto L17;
        r10.setText(r0);
    L17:
        return r0;
    }

    @JvmStatic
    public static final Disposable a(List<? extends ECUrlModel> r11, String r12, float r13, float r14, TextView r15, boolean r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r11, "pictures");
        Intrinsics.checkNotNullParameter(r15, "tv");
        ArrayList r3 = new ArrayList();
        Iterator<T> r0 = r11.iterator();
    L3:
        String r9 = null;
        if (r0.hasNext() == false) goto L10;
        List r4 = ((ECUrlModel) r0.next()).getUrlList();
        if (r4 == null) goto L8;
        r9 = (String) CollectionsKt.firstOrNull(r4);
    L8:
        if (r9 == null) goto L3;
        r3.add(r9);
        goto L3
    L10:
        Intrinsics.checkNotNullParameter(r3, "pictures");
        Intrinsics.checkNotNullParameter(r15, "tv");
        if (r3.isEmpty() == true) goto L13;
        ArrayList r1 = new ArrayList();
        Iterator r2 = r3.iterator();
    L18:
        if (r2.hasNext() == false) goto L26;
        WeakReference<Bitmap> r5 = a.get((String) r2.next());
        if (r5 == null) goto L22;
        Bitmap r6 = r5.get();
    L23:
        if (r6 == null) goto L25;
        r1.add(r6);
        goto L18
    L25:
        r1 = new ArrayList();
        goto L26
    L22:
        r6 = null;
    L26:
        ArrayList r7 = r1;
        if (r7.size() == r3.size()) goto L29;
        if (r16 == true) goto L34;
        r15.postDelayed(new j(r15, r12), 250);
    L37:
        boolean r8 = ECLiveABUtils.INSTANCE.getLIST_FPS_OPT_CONFIG().getEnableOpt();
        p r10 = p.a;
        int r18 = 0;
        if (r8 == false) goto L47;
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r20 = r3.iterator();
    L41:
        if (r20.hasNext() == false) goto L73;
        Object r21 = r20.next();
        int r22 = r18 + 1;
        if (r18 >= 0) goto L45;
        CollectionsKt.throwIndexOverflow();
    L45:
        r19.add(Observable.create(new o((String) r21, r18)).onErrorReturn(r10));
        r18 = r22;
        goto L41
    L73:
        return bg4.b.b(Observable.zip(r19, new l(r7, r12, r13, r14, r15, r17))).subscribe(new m(r15), new n(r15, r12));
    L47:
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r24 = r3.iterator();
    L49:
        if (r24.hasNext() == false) goto L55;
        Object r25 = r24.next();
        int r26 = r18 + 1;
        if (r18 >= 0) goto L53;
        CollectionsKt.throwIndexOverflow();
    L53:
        r23.add(Observable.create(new o((String) r25, r18)).onErrorReturn(r10));
        r18 = r26;
        goto L49
    L55:
        return bg4.b.b(Observable.zip(r23, new d(r7))).subscribe(new e(r7, r12, r13, r14, r15, r17), new f(r15, r12));
    L34:
        if (TextUtils.isEmpty(r15.getText().toString()) == false) goto L37;
        r15.setText(r12);
        goto L37
    L29:
        if (ECLiveABUtils.INSTANCE.getLIST_FPS_OPT_CONFIG().getEnableOpt() == false) goto L31;
        Single.fromCallable(new g(r7, r12, r13, r14, r15, r17)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(r15), i.a);
        return null;
    L31:
        c(r7, r12, r13, r14, r15, r17);
        return null;
    L13:
        if (ECLiveABUtils.INSTANCE.getLIST_FPS_OPT_CONFIG().getEnableOpt() == false) goto L15;
        r15.setText(r12);
        return null;
    L15:
        c(CollectionsKt.emptyList(), r12, r13, r14, r15, r17);
        return null;
    }
}
