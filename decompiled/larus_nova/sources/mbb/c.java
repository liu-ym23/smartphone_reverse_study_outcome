package mbb;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.android.ttcjpaysdk.thirdparty.fingerprint.CJPayFingerprintSharedPrefUtils;
import com.larus.nova.R;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.log.Log;
import io.reactivex.Flowable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.text.DecimalFormat;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f512807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile mbb.f f512808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile mbb.g f512809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile mbb.d f512810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile mbb.e f512811e;

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f512812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f512813b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ obb.a f512814c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f512815d;

        public a(String r100, String r101, obb.a r102, long r103) {
            this.f512812a = r100;
            this.f512813b = r101;
            this.f512814c = r102;
            this.f512815d = r103;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            boolean r100 = c.f512807a;
            String r101 = this.f512812a;
            String r102 = this.f512813b;
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            boolean r103 = c.b("", -1, r101, r102);
            obb.a r104 = this.f512814c;
            if (r104 == null) goto L8;
            IconScene r105 = r104.f522634e;
        L9:
            c.j(r103, r105, true, this.f512815d);
            return;
        L8:
            r105 = null;
            goto L9
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ obb.b f512816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f512817b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ImageView f512818c;

        public b(obb.b r100, String r101, ImageView r102) {
            this.f512816a = r100;
            this.f512817b = r101;
            this.f512818c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            obb.b r102 = this.f512816a;
            if (r102 == null) goto L6;
            String r103 = r102.f522638b;
            if (r103 == null) goto L6;
        L8:
            if (TextUtils.equals(r103, this.f512818c.getTag(R.id.avatar_tag).toString()) == false) goto L11;
            this.f512818c.setImageBitmap(r101);
            return;
        L11:
            return;
        L6:
            r103 = this.f512817b;
            goto L8
        }
    }

    /* JADX INFO: renamed from: mbb.c$c, reason: collision with other inner class name */
    public static final class C6795c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f512819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f512820b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ obb.a f512821c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f512822d;

        public C6795c(String r100, String r101, obb.a r102, long r103) {
            this.f512819a = r100;
            this.f512820b = r101;
            this.f512821c = r102;
            this.f512822d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Throwable r111 = (Throwable) r110;
            Log.e("DOCS_ICON_DocsIconCenter", "loadDocumentIcon only url fail , " + r111);
            boolean r100 = c.f512807a;
            String r101 = this.f512819a;
            String r102 = this.f512820b;
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            boolean r103 = c.b("", -1, r101, r102);
            obb.a r104 = this.f512821c;
            if (r104 == null) goto L8;
            IconScene r105 = r104.f522634e;
        L9:
            c.i(r103, r105, false, this.f512822d, r111.getMessage());
            return;
        L8:
            r105 = null;
            goto L9
        }
    }

    public static final class d implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f512823a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f512824b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f512825c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ obb.a f512826d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f512827e;

        public d(String r100, int r101, String r102, obb.a r103, long r104) {
            this.f512823a = r100;
            this.f512824b = r101;
            this.f512825c = r102;
            this.f512826d = r103;
            this.f512827e = r104;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            boolean r100 = c.f512807a;
            String r101 = this.f512823a;
            int r102 = this.f512824b;
            String r103 = this.f512825c;
            if (r103 != null) goto L5;
            r103 = "";
        L5:
            boolean r104 = c.b(r101, r102, "", r103);
            obb.a r105 = this.f512826d;
            if (r105 == null) goto L8;
            IconScene r106 = r105.f522634e;
        L9:
            c.j(r104, r106, true, this.f512827e);
            return;
        L8:
            r106 = null;
            goto L9
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f512828a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageView f512829b;

        public e(String r100, ImageView r101) {
            this.f512828a = r100;
            this.f512829b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            if (TextUtils.equals(this.f512828a, this.f512829b.getTag(R.id.avatar_tag).toString()) == false) goto L6;
            this.f512829b.setImageBitmap(r101);
            return;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f512830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f512831b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f512832c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ obb.a f512833d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f512834e;

        public f(String r100, int r101, String r102, obb.a r103, long r104) {
            this.f512830a = r100;
            this.f512831b = r101;
            this.f512832c = r102;
            this.f512833d = r103;
            this.f512834e = r104;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Throwable r111 = (Throwable) r110;
            boolean r100 = c.f512807a;
            String r101 = this.f512830a;
            int r102 = this.f512831b;
            String r103 = this.f512832c;
            if (r103 != null) goto L5;
            r103 = "";
        L5:
            boolean r104 = c.b(r101, r102, "", r103);
            obb.a r105 = this.f512833d;
            if (r105 == null) goto L8;
            IconScene r106 = r105.f522634e;
        L9:
            c.i(r104, r106, false, this.f512834e, r111.getMessage());
            return;
        L8:
            r106 = null;
            goto L9
        }
    }

    public static final class g implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f512835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ obb.a f512836b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f512837c;

        public g(String r100, obb.a r101, long r102) {
            this.f512835a = r100;
            this.f512836b = r101;
            this.f512837c = r102;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            boolean r100 = c.f512807a;
            boolean r101 = c.b("", -1, this.f512835a, "");
            obb.a r102 = this.f512836b;
            if (r102 == null) goto L5;
            IconScene r103 = r102.f522634e;
        L6:
            c.j(r101, r103, true, this.f512837c);
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ obb.b f512838a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f512839b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ImageView f512840c;

        public h(obb.b r100, String r101, ImageView r102) {
            this.f512838a = r100;
            this.f512839b = r101;
            this.f512840c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            String r102 = this.f512838a.f522638b;
            if (r102 != null) goto L6;
            r102 = this.f512839b;
        L6:
            if (TextUtils.equals(r102, this.f512840c.getTag(R.id.avatar_tag).toString()) == false) goto L9;
            this.f512840c.setImageBitmap(r101);
            return;
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f512841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ obb.a f512842b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f512843c;

        public i(String r100, obb.a r101, long r102) {
            this.f512841a = r100;
            this.f512842b = r101;
            this.f512843c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Log.e("DOCS_ICON_DocsIconCenter", "loadDocumentIcon only url fail , " + ((Throwable) r100));
            boolean r101 = c.f512807a;
            boolean r102 = c.b("", -1, this.f512841a, "");
            obb.a r103 = this.f512842b;
            if (r103 == null) goto L5;
            IconScene r104 = r103.f522634e;
        L6:
            c.j(r102, r104, false, this.f512843c);
            return;
        L5:
            r104 = null;
            goto L6
        }
    }

    public static final class j implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f512844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f512845b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ obb.a f512846c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f512847d;

        public j(String r100, int r101, obb.a r102, long r103) {
            this.f512844a = r100;
            this.f512845b = r101;
            this.f512846c = r102;
            this.f512847d = r103;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            boolean r100 = c.f512807a;
            boolean r101 = c.b(this.f512844a, this.f512845b, "", "");
            obb.a r102 = this.f512846c;
            if (r102 == null) goto L5;
            IconScene r103 = r102.f522634e;
        L6:
            c.j(r101, r103, true, this.f512847d);
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class k<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f512848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageView f512849b;

        public k(String r100, ImageView r101) {
            this.f512848a = r100;
            this.f512849b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            if (TextUtils.equals(this.f512848a, this.f512849b.getTag(R.id.avatar_tag).toString()) == false) goto L6;
            this.f512849b.setImageBitmap(r101);
            return;
        }
    }

    public static final class l<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f512850a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f512851b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ obb.a f512852c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f512853d;

        public l(String r100, int r101, obb.a r102, long r103) {
            this.f512850a = r100;
            this.f512851b = r101;
            this.f512852c = r102;
            this.f512853d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Log.e("DOCS_ICON_DocsIconCenter", "loadDocumentIcon only url fail , " + ((Throwable) r100));
            boolean r101 = c.f512807a;
            boolean r102 = c.b(this.f512850a, this.f512851b, "", "");
            obb.a r103 = this.f512852c;
            if (r103 == null) goto L5;
            IconScene r104 = r103.f522634e;
        L6:
            c.j(r102, r104, false, this.f512853d);
            return;
        L5:
            r104 = null;
            goto L6
        }
    }

    public static final class m implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ obb.c f512854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f512855b;

        public m(obb.c r100, long r101) {
            this.f512854a = r100;
            this.f512855b = r101;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            boolean r100 = c.f512807a;
            obb.c r101 = this.f512854a;
            String r102 = r101.f522647a;
            String r103 = "";
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            Integer r104 = r101.getType();
            if (r104 == null) goto L8;
            int r105 = r104.intValue();
        L9:
            obb.c r106 = this.f512854a;
            String r107 = r106.f522649c;
            if (r107 != null) goto L12;
            r107 = "";
        L12:
            String r108 = r106.f522651e;
            if (r108 == null) goto L16;
            r103 = r108;
        L16:
            c.j(c.b(r102, r105, r107, r103), this.f512854a.f522660n, true, this.f512855b);
            return;
        L8:
            r105 = -1;
            goto L9
        }
    }

    public static final class n<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ obb.c f512856a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageView f512857b;

        public n(obb.c r100, ImageView r101) {
            this.f512856a = r100;
            this.f512857b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            if (Intrinsics.areEqual(this.f512856a.a(), this.f512857b.getTag(R.id.avatar_tag)) == false) goto L6;
            this.f512857b.setImageBitmap(r101);
            return;
        }
    }

    public static final class o<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ obb.c f512858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f512859b;

        public o(obb.c r100, long r101) {
            this.f512858a = r100;
            this.f512859b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Throwable r111 = (Throwable) r110;
            Log.e("DOCS_ICON_DocsIconCenter", "loadIcon " + r111.getMessage());
            boolean r100 = c.f512807a;
            obb.c r101 = this.f512858a;
            String r102 = r101.f522647a;
            String r103 = "";
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            Integer r104 = r101.getType();
            if (r104 == null) goto L8;
            int r105 = r104.intValue();
        L9:
            obb.c r106 = this.f512858a;
            String r107 = r106.f522649c;
            if (r107 != null) goto L12;
            r107 = "";
        L12:
            String r108 = r106.f522651e;
            if (r108 == null) goto L16;
            r103 = r108;
        L16:
            c.i(c.b(r102, r105, r107, r103), this.f512858a.f522660n, false, this.f512859b, r111.getMessage());
            return;
        L8:
            r105 = -1;
            goto L9
        }
    }

    public c() {
    }

    static {
        f512807a = true;
    }

    @JvmStatic
    public static final void h(ImageView r100, obb.c r101) {
        Intrinsics.checkNotNullParameter(r100, CJPayFingerprintSharedPrefUtils.KEY_IV);
        Intrinsics.checkNotNullParameter(r101, "iconModel");
        long r102 = System.nanoTime();
        r101.f522661o = Long.valueOf(r102);
        r100.setTag(R.id.avatar_tag, r101.a());
        pbb.d.c(r101).doOnComplete(new m(r101, r102)).subscribe(new n(r101, r100), new o(r101, r102));
    }

    public static boolean b(String r100, int r101, String r102, String r103) {
        int r104 = obb.c.f522646p;
        Intrinsics.checkNotNullParameter(r100, "token");
        obb.c.a r105 = new obb.c.a(r100, r101, r103);
        Intrinsics.checkNotNullParameter(r102, "url");
        r105.f522664c = r102;
        obb.c r106 = new obb.c(r105);
        if (TextUtils.isEmpty(r106.f522647a) == false) goto L5;
    L7:
        boolean r107 = false;
    L8:
        if (r107 == false) goto L15;
        Integer r108 = r106.f522652f;
        if (r108 == null) goto L12;
        int r109 = r108.intValue();
    L13:
        if (r109 > 0) goto L15;
        return true;
    L12:
        r109 = 0;
    L15:
        return false;
    L5:
        if (r106.f522648b == null) goto L7;
        r107 = true;
        goto L8
    }

    @JvmStatic
    public static final void e(ImageView r100, String r101, IconShape r102, obb.a r103) {
        Intrinsics.checkNotNullParameter(r100, CJPayFingerprintSharedPrefUtils.KEY_IV);
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "shape");
        long r104 = System.nanoTime();
        Log.i("DOCS_ICON_DocsIconCenter", "loadDocumentIcon ");
        sbb.c.f541290a.getClass();
        obb.b r105 = sbb.c.e(r101);
        if (r105 != null) goto L6;
        Log.e("DOCS_ICON_DocsIconCenter", "loadDocumentIcon url parse error");
        return;
    L6:
        String r106 = r105.f522638b;
        if (r106 != null) goto L9;
        r106 = r101;
    L9:
        r100.setTag(R.id.avatar_tag, r106);
        int r107 = pbb.d.f528455a;
        if (r103 != null) goto L12;
        obb.a r108 = new obb.a();
    L13:
        r108.f522635f = Long.valueOf(r104);
        Unit r109 = Unit.INSTANCE;
        pbb.d.a(r105, r102, r108).doOnComplete(new g(r101, r103, r104)).subscribe(new h(r105, r101, r100), new i(r101, r103, r104));
        return;
    L12:
        r108 = r103;
        goto L13
    }

    public static /* synthetic */ void j(boolean r100, IconScene r101, boolean r102, long r103) {
        i(r100, r101, r102, r103, null);
    }

    @JvmStatic
    public static final Flowable<Bitmap> a(String r100, int r101, String r102, IconShape r103, obb.a r104) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r102, "meta");
        Intrinsics.checkNotNullParameter(r103, "shape");
        long r105 = System.nanoTime();
        Log.i("DOCS_ICON_DocsIconCenter", "getDocumentIcon with meta");
        sbb.c.f541290a.getClass();
        obb.b r106 = sbb.c.a(r100, r101);
        boolean r107 = b(r100, r101, "", r102);
        if (r104 == null) goto L5;
        IconScene r108 = r104.f522634e;
    L6:
        int r109 = pbb.d.f528455a;
        if (r104 != null) goto L9;
        r104 = new obb.a();
    L9:
        r104.f522635f = Long.valueOf(r105);
        Unit r110 = Unit.INSTANCE;
        return pbb.d.b(r106, r102, r103, r104).doOnComplete(new mbb.a(r107, r108, r105)).doOnError(new mbb.b(r107, r108, r105));
    L5:
        r108 = null;
        goto L6
    }

    @JvmStatic
    public static final void c(ImageView r100, String r110, int r111, IconShape r112, obb.a r113) {
        Intrinsics.checkNotNullParameter(r100, CJPayFingerprintSharedPrefUtils.KEY_IV);
        Intrinsics.checkNotNullParameter(r110, "token");
        Intrinsics.checkNotNullParameter(r112, "shape");
        long r101 = System.nanoTime();
        Log.i("DOCS_ICON_DocsIconCenter", "loadDocumentIcon " + r111);
        sbb.c.f541290a.getClass();
        obb.b r102 = sbb.c.a(r110, r111);
        r100.setTag(R.id.avatar_tag, r110);
        int r103 = pbb.d.f528455a;
        if (r113 != null) goto L5;
        obb.a r104 = new obb.a();
    L6:
        r104.f522635f = Long.valueOf(r101);
        Unit r105 = Unit.INSTANCE;
        pbb.d.a(r102, r112, r104).doOnComplete(new j(r110, r111, r113, r101)).subscribe(new k(r110, r100), new l(r110, r111, r113, r101));
        return;
    L5:
        r104 = r113;
        goto L6
    }

    @JvmStatic
    public static final void f(ImageView r110, String r111, String r112, IconShape r113, obb.a r114) {
        Intrinsics.checkNotNullParameter(r110, CJPayFingerprintSharedPrefUtils.KEY_IV);
        Intrinsics.checkNotNullParameter(r111, "url");
        Intrinsics.checkNotNullParameter(r113, "shape");
        long r100 = System.nanoTime();
        Log.i("DOCS_ICON_DocsIconCenter", "loadDocumentIcon with meta");
        sbb.c.f541290a.getClass();
        obb.b r101 = sbb.c.e(r111);
        if (r101 != null) goto L7;
        Log.e("DOCS_ICON_DocsIconCenter", "loadDocumentIcon url parse error");
        if (idb.f.a().isCurrentEnable("ccm.bitable.fix.appicon") == true) goto L7;
        return;
    L7:
        if (r101 == null) goto L10;
        String r102 = r101.f522638b;
        if (r102 == null) goto L10;
    L11:
        r110.setTag(R.id.avatar_tag, r102);
        int r103 = pbb.d.f528455a;
        if (r114 != null) goto L14;
        obb.a r104 = new obb.a();
    L15:
        r104.f522635f = Long.valueOf(r100);
        Unit r105 = Unit.INSTANCE;
        pbb.d.b(r101, r112, r113, r104).doOnComplete(new a(r111, r112, r114, r100)).subscribe(new b(r101, r111, r110), new C6795c(r111, r112, r114, r100));
        return;
    L14:
        r104 = r114;
    L10:
        r102 = r111;
        goto L11
    }

    public static void i(boolean r100, IconScene r101, boolean r102, long r110, String r111) {
        if (r100 == false) goto L10;
        DecimalFormat r103 = vpb.f.f556745a;     // Catch: Exception -> L5
        vpb.f.a("full", r101, 0, r102, System.nanoTime() - r110, r111);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("DOCS_ICON_DocsIconCenter", "reportDocIcon err", e);
        return;
    }

    @JvmStatic
    public static final void d(ImageView r110, String r111, int r112, String r113, IconShape r114, obb.a r115) {
        Intrinsics.checkNotNullParameter(r110, CJPayFingerprintSharedPrefUtils.KEY_IV);
        Intrinsics.checkNotNullParameter(r111, "token");
        Intrinsics.checkNotNullParameter(r114, "shape");
        long r100 = System.nanoTime();
        Log.i("DOCS_ICON_DocsIconCenter", "loadDocumentIcon with meta " + r112);
        sbb.c.f541290a.getClass();
        obb.b r101 = sbb.c.a(r111, r112);
        r110.setTag(R.id.avatar_tag, r111);
        int r102 = pbb.d.f528455a;
        if (r115 != null) goto L5;
        obb.a r103 = new obb.a();
    L6:
        r103.f522635f = Long.valueOf(r100);
        Unit r104 = Unit.INSTANCE;
        pbb.d.b(r101, r113, r114, r103).doOnComplete(new d(r111, r112, r113, r115, r100)).subscribe(new e(r111, r110), new f(r111, r112, r113, r115, r100));
        return;
    L5:
        r103 = r115;
        goto L6
    }

    public static /* synthetic */ void g(ImageView r100, String r101, int r102, String r103, IconShape r110, int r111) {
        if ((r111 & 16) == 0) goto L5;
        r110 = IconShape.SQUARE;
    L5:
        d(r100, r101, r102, r103, r110, null);
    }
}
