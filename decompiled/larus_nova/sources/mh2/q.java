package mh2;

import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.w0;
import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.tencent.qqmusic.third.api.contract.CommonCmd;
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

/* JADX INFO: loaded from: classes10.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, WeakReference<Bitmap>> f513935a = null;

    static {
        f513935a = new HashMap();
    }

    public static /* synthetic */ Disposable b(List r100, String r101, float r102, TextView r110, boolean r111, int r112) {
        if ((r112 & 32) == 0) goto L5;
        boolean r103 = false;
    L7:
        return a(r100, r101, 4.0f, r102, r110, r103, false);
    L5:
        r103 = r111;
        goto L7
    }

    public static SpannableStringBuilder c(List r100, String r101, float r102, float r103, TextView r110, boolean r111) {
        SpannableStringBuilder r104 = new SpannableStringBuilder();
        Iterator r105 = r100.iterator();
    L4:
        if (r105.hasNext() == false) goto L12;
        Bitmap r106 = (Bitmap) r105.next();
        if (r106.isRecycled() == true) goto L4;
        int r107 = w0.a(r103);
        Bitmap r108 = Bitmap.createScaledBitmap(r106, (int) Math.ceil(((r107 * 1.0f) / r106.getHeight()) * r106.getWidth()), r107, true);
        SpannableString r109 = new SpannableString(" ");
        if (r111 == false) goto L10;
        b r112 = new b(r110.getContext(), r108);
        r112.f513901a = w0.a(r102);
        Object r113 = r112;
    L11:
        r109.setSpan(r113, 0, 1, 17);
        r104.append(r109);
        goto L4
    L10:
        a r114 = new a(r110.getContext(), r108);
        r114.f513900a = w0.a(r102);
        r113 = r114;
        goto L11
    L12:
        if (r101 == null) goto L15;
        r104.append(r101);
    L15:
        if (ECLiveABUtils.INSTANCE.getLIST_FPS_OPT_CONFIG().getEnableOpt() == true) goto L17;
        r110.setText(r104);
    L17:
        return r104;
    }

    @JvmStatic
    public static final Disposable a(List<? extends ECUrlModel> r110, String r111, float r112, float r113, TextView r114, boolean r115, boolean r116) {
        Intrinsics.checkNotNullParameter(r110, NoticeInfo.KEY_PICTURES);
        Intrinsics.checkNotNullParameter(r114, CommonCmd.AIDL_PLATFORM_TYPE_TV);
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = r110.iterator();
    L3:
        String r102 = null;
        if (r101.hasNext() == false) goto L10;
        List<String> r103 = ((ECUrlModel) r101.next()).getUrlList();
        if (r103 == null) goto L8;
        r102 = (String) CollectionsKt.firstOrNull(r103);
    L8:
        if (r102 == null) goto L3;
        r100.add(r102);
        goto L3
    L10:
        Intrinsics.checkNotNullParameter(r100, NoticeInfo.KEY_PICTURES);
        Intrinsics.checkNotNullParameter(r114, CommonCmd.AIDL_PLATFORM_TYPE_TV);
        if (r100.isEmpty() == true) goto L13;
        ArrayList r104 = new ArrayList();
        Iterator r105 = r100.iterator();
    L18:
        if (r105.hasNext() == false) goto L26;
        WeakReference<Bitmap> r106 = f513935a.get((String) r105.next());
        if (r106 == null) goto L22;
        Bitmap r107 = r106.get();
    L23:
        if (r107 == null) goto L25;
        r104.add(r107);
        goto L18
    L25:
        r104 = new ArrayList();
        goto L26
    L22:
        r107 = null;
    L26:
        ArrayList r108 = r104;
        if (r108.size() == r100.size()) goto L29;
        if (r115 == true) goto L34;
        r114.postDelayed(new j(r114, r111), 250);
    L37:
        boolean r109 = ECLiveABUtils.INSTANCE.getLIST_FPS_OPT_CONFIG().getEnableOpt();
        p r117 = p.f513934a;
        int r118 = 0;
        if (r109 == false) goto L47;
        ArrayList r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r120 = r100.iterator();
    L41:
        if (r120.hasNext() == false) goto L73;
        Object r121 = r120.next();
        int r122 = r118 + 1;
        if (r118 >= 0) goto L45;
        CollectionsKt.throwIndexOverflow();
    L45:
        r119.add(Observable.create(new o((String) r121, r118)).onErrorReturn(r117));
        r118 = r122;
        goto L41
    L73:
        return bg4.b.b(Observable.zip(r119, new l(r108, r111, r112, r113, r114, r116))).subscribe(new m(r114), new n(r114, r111));
    L47:
        ArrayList r123 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r124 = r100.iterator();
    L49:
        if (r124.hasNext() == false) goto L55;
        Object r125 = r124.next();
        int r126 = r118 + 1;
        if (r118 >= 0) goto L53;
        CollectionsKt.throwIndexOverflow();
    L53:
        r123.add(Observable.create(new o((String) r125, r118)).onErrorReturn(r117));
        r118 = r126;
        goto L49
    L55:
        return bg4.b.b(Observable.zip(r123, new d(r108))).subscribe(new e(r108, r111, r112, r113, r114, r116), new f(r114, r111));
    L34:
        if (TextUtils.isEmpty(r114.getText().toString()) == false) goto L37;
        r114.setText(r111);
        goto L37
    L29:
        if (ECLiveABUtils.INSTANCE.getLIST_FPS_OPT_CONFIG().getEnableOpt() == false) goto L31;
        Single.fromCallable(new g(r108, r111, r112, r113, r114, r116)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(r114), i.f513918a);
        return null;
    L31:
        c(r108, r111, r112, r113, r114, r116);
        return null;
    L13:
        if (ECLiveABUtils.INSTANCE.getLIST_FPS_OPT_CONFIG().getEnableOpt() == false) goto L15;
        r114.setText(r111);
        return null;
    L15:
        c(CollectionsKt.emptyList(), r111, r112, r113, r114, r116);
        return null;
    }
}
