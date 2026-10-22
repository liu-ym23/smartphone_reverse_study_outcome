package com.bytedance.ee.bear.office.list.adapter;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.listitem.ListIconTransformation;
import com.bytedance.ee.bear.list.thumbnail.OfficeThumbnailUrlRepository;
import com.bytedance.ee.bear.thumbnail.LeftCrop;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j0 {
    public final Function0<Boolean> a;
    public final OfficeThumbnailUrlRepository b;

    public static final class a {
    }

    public static final class b implements RequestListener<Bitmap> {
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ String b;
        public final /* synthetic */ j0 c;
        public final /* synthetic */ Document d;
        public final /* synthetic */ int e;
        public final /* synthetic */ Function0<Unit> f;
        public final /* synthetic */ ThumbGlideUrl g;

        public final boolean onLoadFailed(GlideException r8, Object r9, Target<Bitmap> r10, boolean r11) {
            if (Intrinsics.areEqual(this.a.getTag(2131363734), this.b) == true) goto L5;
            return true;
        L5:
            j0 r3 = this.c;
            ImageView r12 = this.a;
            Document r13 = this.d;
            int r5 = this.e;
            String r2 = this.b;
            Function0<Unit> r6 = this.f;
            ThumbGlideUrl r4 = r3.d(r12, r13);
            if (r4 != null) goto L8;
            r6.invoke();
            return false;
        L8:
            r12.post(new o0(r12, r2, r3, r4, r5, r6));
            return true;
        }

        public final boolean onResourceReady(Object r8, Object r9, Target r10, DataSource r11, boolean r12) {
            Bitmap r13 = (Bitmap) r8;
            if (Intrinsics.areEqual(this.a.getTag(2131363734), this.b) == true) goto L6;
            return true;
        L6:
            if (this.g.isIcon() == false) goto L11;
            j0 r3 = this.c;
            ImageView r14 = this.a;
            Document r15 = this.d;
            int r5 = this.e;
            String r2 = this.b;
            Function0<Unit> r6 = this.f;
            ThumbGlideUrl r4 = r3.d(r14, r15);
            if (r4 != null) goto L10;
            r6.invoke();
            goto L11
        L10:
            r14.post(new o0(r14, r2, r3, r4, r5, r6));
            return true;
        L11:
            return false;
        }

        public b(ImageView r1, String r2, j0 r3, Document r4, int r5, Function0<Unit> r6, ThumbGlideUrl r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    static {
    }

    public static boolean g() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Boolean.valueOf(((ya5.b) org.koin.java.a.c(ya5.b.class, null, null, 6)).a()));     // Catch: Throwable -> L4
    L6:
        Boolean r2 = Boolean.FALSE;
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = r2;
    L10:
        return ((Boolean) r1).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public j0(Function0 r3) {
        OfficeThumbnailUrlRepository r0 = new OfficeThumbnailUrlRepository();
        Intrinsics.checkNotNullParameter(r3, "isConnectProvider");
        Intrinsics.checkNotNullParameter(r0, "thumbnailUrlRepository");
        this.a = r3;
        this.b = r0;
    }

    public static String e(Document r9) {
        String[] r0 = new String[7];
        String r1 = r9.d;
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0[0] = r1;
        r0[1] = String.valueOf(r9.getType());
        String r3 = r9.q;
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r0[2] = r3;
        String r4 = r9.V0;
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        r0[3] = r4;
        r0[4] = String.valueOf(r9.h1);
        String r5 = r9.b1;
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        r0[5] = r5;
        String r10 = r9.g1;
        if (r10 == null) goto L18;
        r2 = r10;
    L18:
        r0[6] = r2;
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(r0), "#", null, null, 0, null, null, 62, null);
    }

    public static void f(ImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "imageView");
        Glide.with(r2.getContext()).clear(r2);
        r2.setTag(2131363734, null);
    }

    public static void i(ImageView r2, int r3) {
        f(r2);
        r2.setTag(2131363734, null);
        r2.setImageResource(r3);
    }

    public final ThumbGlideUrl d(ImageView r18, Document r19) {
        OfficeThumbnailUrlRepository r2 = this.b;
        int r3 = r18.getWidth();
        int r4 = r18.getHeight();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r19, "document");
        if (com.bytedance.ee.bear.list.thumbnail.b.a(r19) == true) goto L5;
        OfficeThumbnailUrlRepository.ThumbnailUrlInfo r5 = null;
    L6:
        if (r5 != null) goto L8;
        return null;
    L8:
        String r6 = r19.V0;
        if (r6 != null) goto L11;
    L14:
        boolean r7 = true;
    L16:
        if ((true ^ r7) == true) goto L19;
        r6 = null;
    L19:
        if (r6 != null) goto L24;
        r6 = r19.q;
        if (r6 != null) goto L24;
        r6 = "";
    L24:
        if (StringsKt.contains$default(r6, "/space/api/box/stream/download/v2/cover/", false, 2, null) == false) goto L26;
    L30:
        return null;
    L26:
        if (Intrinsics.areEqual(r6, r5.getUrl()) == true) goto L30;
        ThumbGlideUrl r8 = new ThumbGlideUrl(r5.getUrl(), "", r19.getType(), 0, null, null, ThumbGlideUrl.SOURCE_SPACE_LIST, false, r18);
        r8.setIsConnect((Boolean) this.a.invoke());
        r8.setExtra(r19.O);
        return r8;
    L11:
        if (StringsKt.isBlank(r6) == true) goto L14;
        r7 = false;
        goto L16
    L5:
        r5 = r2.b(r19, r3, r4);
        goto L6
    }

    public static void h(ImageView r6, Document r7, ce5.a r8) {
        UserSession r2 = null;
        obb.a r5 = new obb.a(Boolean.FALSE, Boolean.valueOf(h0.b(r7)), null);
        r5.b(IconScene.HOME_PAGE);
        if (r8 == null) goto L5;
        r2 = r8.b;
    L5:
        r5.g = r2;
        String r9 = r7.F2;
        if (r9 != null) goto L8;
        r9 = "";
    L8:
        String r3 = r9;
        int r10 = r7.getType();
        sbb.e r0 = sbb.e.n;
        if (r10 != r0.b) goto L11;
        int r11 = r7.y1;
    L12:
        int r4 = r11;
        if (r7.getType() != r0.b) goto L15;
        String r12 = r7.G1;
    L16:
        String r1 = r12;
        boolean r13 = true;
        if (r1 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == true) goto L25;
        mbb.c.d(r6, r1, r4, r3, IconShape.SQUARE, r5);
        return;
    L25:
        String r15 = r7.p;
        if (r15 != null) goto L28;
    L31:
        if (r13 == true) goto L35;
        mbb.c.f(r6, r7.p, r3, IconShape.SQUARE, r5);
        return;
    L35:
        return;
    L28:
        if (r15.length() == 0) goto L31;
        r13 = false;
        goto L31
    L19:
        if (r1.length() == 0) goto L22;
        r14 = false;
        goto L23
    L15:
        r12 = r7.d;
        goto L16
    L11:
        r11 = r7.getType();
        goto L12
    }

    public final void a(AppCompatImageView r16, AppCompatImageView r17, Document r18) {
        Intrinsics.checkNotNullParameter(r16, "thumbnail");
        Intrinsics.checkNotNullParameter(r17, "folderThumbnail");
        Intrinsics.checkNotNullParameter(r18, "document");
        String r13 = e(r18);
        if (TextUtils.isEmpty(r18.q) == true) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L14;
        r16.setVisibility(8);
        r17.setVisibility(0);
        m.a.getClass();
        Intrinsics.checkNotNullParameter(r18, "document");
        i(r17, m.a(r18));
        return;
    L14:
        if (r18.getType() != sbb.e.l.b) goto L17;
        g();
    L17:
        if (r16.getVisibility() == 0) goto L19;
    L22:
        f(r16);
        r16.setImageDrawable(null);
        r16.setVisibility(4);
        r17.setVisibility(0);
        m.a.getClass();
        Intrinsics.checkNotNullParameter(r18, "document");
        i(r17, m.a(r18));
        r16.setTag(2131363734, r13);
        ThumbGlideUrl r14 = new ThumbGlideUrl(r18.q, r18.V0, r18.getType(), r18.h1, r18.b1, r18.g1, ThumbGlideUrl.SOURCE_SPACE_LIST, false, r16);
        r14.setIsConnect((Boolean) this.a.invoke());
        r14.setExtra(r18.O);
        Glide.with(r16.getContext()).asBitmap().load(r14).skipMemoryCache(r14.needUpdate(r14.getUrl())).diskCacheStrategy(DiskCacheStrategy.NONE).transform(new LeftCrop()).listener(new l0(r16, r13, this, r17, r18, r14)).into(r16);
        return;
    L19:
        if (Intrinsics.areEqual(r16.getTag(2131363734), r13) == false) goto L22;
        r17.setVisibility(8);
        return;
    L5:
        if (TextUtils.isEmpty(r18.V0) == false) goto L8;
        r1 = false;
        goto L10
    }

    public static void b(ImageView r17, Document r18, int r19, ce5.a r20) {
        Intrinsics.checkNotNullParameter(r17, "imageView");
        Intrinsics.checkNotNullParameter(r18, "document");
        String r14 = r18.H;
        boolean r2 = g();
        String r0 = r18.F2;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L59;
        boolean r1 = true;
    L23:
        if (r1 == true) goto L25;
    L54:
        i(r17, r19);
        m.a.getClass();
        Intrinsics.checkNotNullParameter(r18, "document");
        if (h0.b(r18) == false) goto L57;
        return;
    L57:
        h(r17, r18, r20);
        return;
    L25:
        if (r18.getType() != sbb.e.l.b) goto L54;
        if (r14 != null) goto L28;
    L31:
        boolean r4 = true;
    L32:
        if (r4 == true) goto L54;
        if (r2 == false) goto L54;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L39
        String r6 = r18.O;     // Catch: Throwable -> L39
        if (r6 != null) goto L37;
        r6 = "";
    L37:
        Object r7 = Result.constructor-impl(Boolean.valueOf(new JSONObject(r6).optBoolean("icon_has_perm", true)));     // Catch: Throwable -> L39
    L41:
        Boolean r8 = Boolean.TRUE;
        if (Result.isFailure-impl(r7) == false) goto L45;
        r7 = r8;
    L45:
        if (((Boolean) r7).booleanValue() == false) goto L54;
        r17.setTag(2131363734, r14);
        ThumbGlideUrl r9 = new ThumbGlideUrl(r18.q, r14, r18.getType(), r18.K, r18.I, r18.J, ThumbGlideUrl.SOURCE_SPACE_LIST_ICON, true, r17);
        r9.setSubType(r18.F);
        r9.setExtra(r18.O);
        if (r9.isFileIconUseDefault() == false) goto L49;
    L52:
        i(r17, r19);
        return;
    L49:
        if (Intrinsics.areEqual(r17.getTag(2131363734), r14) == false) goto L52;
        Glide.with(r17.getContext()).asBitmap().load(r9).diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(r19).transform(new Transformation[]{new ListIconTransformation(), new CenterCrop(), new RoundedCorners(com.bytedance.ee.util.ui.n.d(8))}).error(r19).into(r17);
        return;
    L39:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    L28:
        if (r14.length() == 0) goto L31;
        r4 = false;
        goto L32
    L59:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L16
        if (new JSONObject(r0).optString("key").length() != 0) goto L13;
        boolean r12 = true;
    L14:
        Object r13 = Result.constructor-impl(Boolean.valueOf(r12));     // Catch: Throwable -> L16
    L18:
        Boolean r15 = Boolean.TRUE;
        if (Result.isFailure-impl(r13) == false) goto L21;
        r13 = r15;
    L21:
        r1 = ((Boolean) r13).booleanValue();
        goto L23
    L13:
        r12 = false;
    L16:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L5:
        if (r0.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public final void c(ImageView r18, Document r19, int r20, ce5.a r21, Function0<Unit> r22) {
        Intrinsics.checkNotNullParameter(r18, "imageView");
        Intrinsics.checkNotNullParameter(r19, "document");
        Intrinsics.checkNotNullParameter(r22, "onFallbackToListIcon");
        if (TextUtils.isEmpty(r19.q) == true) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L12;
        r22.invoke();
        b(r18, r19, r20, r21);
        return;
    L12:
        String r9 = e(r19);
        r18.setTag(2131363734, r9);
        ThumbGlideUrl r8 = new ThumbGlideUrl(r19.q, r19.V0, r19.getType(), r19.h1, r19.b1, r19.g1, ThumbGlideUrl.SOURCE_SPACE_LIST, false, r18);
        r8.setIsConnect((Boolean) this.a.invoke());
        r8.setExtra(r19.O);
        Glide.with(r18.getContext()).asBitmap().load(r8).skipMemoryCache(r8.needUpdate(r8.getUrl())).diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(r20).transform(new Transformation[]{new ListIconTransformation(), new CenterCrop(), new RoundedCorners(com.bytedance.ee.util.ui.n.d(8))}).error(r20).listener(new b(r18, r9, this, r19, r20, r22, r8)).into(r18);
        return;
    L5:
        if (TextUtils.isEmpty(r19.V0) == false) goto L8;
        r0 = false;
        goto L9
    }
}
