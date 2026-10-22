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
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.listitem.ListIconTransformation;
import com.bytedance.ee.bear.list.thumbnail.OfficeThumbnailUrlRepository;
import com.bytedance.ee.bear.thumbnail.LeftCrop;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes18.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Boolean> f235785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OfficeThumbnailUrlRepository f235786b;

    public static final class a {
    }

    public static final class b implements RequestListener<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f235787a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f235788b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j0 f235789c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Document f235790d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f235791e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f235792f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ ThumbGlideUrl f235793g;

        @Override // com.bumptech.glide.request.RequestListener
        public final boolean onLoadFailed(GlideException r100, Object r101, Target<Bitmap> r110, boolean r111) {
            if (Intrinsics.areEqual(this.f235787a.getTag(R.id.avatar_tag), this.f235788b) == true) goto L5;
            return true;
        L5:
            j0 r102 = this.f235789c;
            ImageView r103 = this.f235787a;
            Document r112 = this.f235790d;
            int r104 = this.f235791e;
            String r105 = this.f235788b;
            Function0<Unit> r106 = this.f235792f;
            ThumbGlideUrl r107 = r102.d(r103, r112);
            if (r107 != null) goto L8;
            r106.invoke();
            return false;
        L8:
            r103.post(new o0(r103, r105, r102, r107, r104, r106));
            return true;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public final boolean onResourceReady(Bitmap r100, Object r101, Target<Bitmap> r110, DataSource r111, boolean r112) {
            if (Intrinsics.areEqual(this.f235787a.getTag(R.id.avatar_tag), this.f235788b) == true) goto L6;
            return true;
        L6:
            if (this.f235793g.isIcon() == false) goto L11;
            j0 r102 = this.f235789c;
            ImageView r103 = this.f235787a;
            Document r113 = this.f235790d;
            int r104 = this.f235791e;
            String r105 = this.f235788b;
            Function0<Unit> r106 = this.f235792f;
            ThumbGlideUrl r107 = r102.d(r103, r113);
            if (r107 != null) goto L10;
            r106.invoke();
            goto L11
        L10:
            r103.post(new o0(r103, r105, r102, r107, r104, r106));
            return true;
        L11:
            return false;
        }

        public b(ImageView r100, String r101, j0 r102, Document r103, int r104, Function0<Unit> r105, ThumbGlideUrl r106) {
            this.f235787a = r100;
            this.f235788b = r101;
            this.f235789c = r102;
            this.f235790d = r103;
            this.f235791e = r104;
            this.f235792f = r105;
            this.f235793g = r106;
        }
    }

    static {
    }

    public static boolean g() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(Boolean.valueOf(((ya5.b) org.koin.java.a.c(ya5.b.class, null, null, 6)).a()));     // Catch: Throwable -> L4
    L6:
        Boolean r102 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = r102;
    L10:
        return ((Boolean) r101).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public j0(Function0 r100) {
        OfficeThumbnailUrlRepository r101 = new OfficeThumbnailUrlRepository();
        Intrinsics.checkNotNullParameter(r100, "isConnectProvider");
        Intrinsics.checkNotNullParameter(r101, "thumbnailUrlRepository");
        this.f235785a = r100;
        this.f235786b = r101;
    }

    public static String e(Document r100) {
        String[] r101 = new String[7];
        String r102 = r100.f227873d;
        String r103 = "";
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101[0] = r102;
        r101[1] = String.valueOf(r100.getType());
        String r104 = r100.f227895q;
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        r101[2] = r104;
        String r105 = r100.V0;
        if (r105 != null) goto L11;
        r105 = "";
    L11:
        r101[3] = r105;
        r101[4] = String.valueOf(r100.f227880h1);
        String r106 = r100.f227870b1;
        if (r106 != null) goto L14;
        r106 = "";
    L14:
        r101[5] = r106;
        String r107 = r100.f227877g1;
        if (r107 == null) goto L18;
        r103 = r107;
    L18:
        r101[6] = r103;
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(r101), "#", null, null, 0, null, null, 62, null);
    }

    public static void f(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "imageView");
        Glide.with(r100.getContext()).clear(r100);
        r100.setTag(R.id.avatar_tag, null);
    }

    public static void i(ImageView r100, int r101) {
        f(r100);
        r100.setTag(R.id.avatar_tag, null);
        r100.setImageResource(r101);
    }

    public final ThumbGlideUrl d(ImageView r110, Document r111) {
        OfficeThumbnailUrlRepository r100 = this.f235786b;
        int r101 = r110.getWidth();
        int r102 = r110.getHeight();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r111, "document");
        if (com.bytedance.ee.bear.list.thumbnail.b.a(r111) == true) goto L5;
        OfficeThumbnailUrlRepository.ThumbnailUrlInfo r103 = null;
    L6:
        if (r103 != null) goto L8;
        return null;
    L8:
        String r104 = r111.V0;
        if (r104 != null) goto L11;
    L14:
        boolean r105 = true;
    L16:
        if ((true ^ r105) == true) goto L19;
        r104 = null;
    L19:
        if (r104 != null) goto L24;
        r104 = r111.f227895q;
        if (r104 != null) goto L24;
        r104 = "";
    L24:
        if (StringsKt.contains$default(r104, "/space/api/box/stream/download/v2/cover/", false, 2, null) == false) goto L26;
    L30:
        return null;
    L26:
        if (Intrinsics.areEqual(r104, r103.getUrl()) == true) goto L30;
        ThumbGlideUrl r106 = new ThumbGlideUrl(r103.getUrl(), "", r111.getType(), 0, null, null, ThumbGlideUrl.SOURCE_SPACE_LIST, false, r110);
        r106.setIsConnect(this.f235785a.invoke());
        r106.setExtra(r111.O);
        return r106;
    L11:
        if (StringsKt.isBlank(r104) == true) goto L14;
        r105 = false;
        goto L16
    L5:
        r103 = r100.b(r111, r101, r102);
        goto L6
    }

    public static void h(ImageView r100, Document r101, ce5.a r102) {
        UserSession r103 = null;
        obb.a r104 = new obb.a(Boolean.FALSE, Boolean.valueOf(h0.b(r101)), null);
        r104.b(IconScene.HOME_PAGE);
        if (r102 == null) goto L5;
        r103 = r102.f23447b;
    L5:
        r104.f522636g = r103;
        String r105 = r101.F2;
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        String r106 = r105;
        int r107 = r101.getType();
        sbb.e r108 = sbb.e.f541303n;
        if (r107 != r108.f541317b) goto L11;
        int r109 = r101.f227908y1;
    L12:
        int r110 = r109;
        if (r101.getType() != r108.f541317b) goto L15;
        String r111 = r101.G1;
    L16:
        String r112 = r111;
        boolean r113 = true;
        if (r112 != null) goto L19;
    L22:
        boolean r114 = true;
    L23:
        if (r114 == true) goto L25;
        mbb.c.d(r100, r112, r110, r106, IconShape.SQUARE, r104);
        return;
    L25:
        String r115 = r101.f227891p;
        if (r115 != null) goto L28;
    L31:
        if (r113 == true) goto L35;
        mbb.c.f(r100, r101.f227891p, r106, IconShape.SQUARE, r104);
        return;
    L35:
        return;
    L28:
        if (r115.length() == 0) goto L31;
        r113 = false;
        goto L31
    L19:
        if (r112.length() == 0) goto L22;
        r114 = false;
        goto L23
    L15:
        r111 = r101.f227873d;
        goto L16
    L11:
        r109 = r101.getType();
        goto L12
    }

    public final void a(AppCompatImageView r110, AppCompatImageView r111, Document r112) {
        Intrinsics.checkNotNullParameter(r110, DocCallbackImpl.KEY_THUMBNAIL);
        Intrinsics.checkNotNullParameter(r111, "folderThumbnail");
        Intrinsics.checkNotNullParameter(r112, "document");
        String r113 = e(r112);
        if (TextUtils.isEmpty(r112.f227895q) == true) goto L5;
    L8:
        boolean r100 = true;
    L10:
        if (r100 == true) goto L14;
        r110.setVisibility(8);
        r111.setVisibility(0);
        m.f235806a.getClass();
        Intrinsics.checkNotNullParameter(r112, "document");
        i(r111, m.a(r112));
        return;
    L14:
        if (r112.getType() != sbb.e.f541301l.f541317b) goto L17;
        g();
    L17:
        if (r110.getVisibility() == 0) goto L19;
    L22:
        f(r110);
        r110.setImageDrawable(null);
        r110.setVisibility(4);
        r111.setVisibility(0);
        m.f235806a.getClass();
        Intrinsics.checkNotNullParameter(r112, "document");
        i(r111, m.a(r112));
        r110.setTag(R.id.avatar_tag, r113);
        ThumbGlideUrl r114 = new ThumbGlideUrl(r112.f227895q, r112.V0, r112.getType(), r112.f227880h1, r112.f227870b1, r112.f227877g1, ThumbGlideUrl.SOURCE_SPACE_LIST, false, r110);
        r114.setIsConnect(this.f235785a.invoke());
        r114.setExtra(r112.O);
        Glide.with(r110.getContext()).asBitmap().load(r114).skipMemoryCache(r114.needUpdate(r114.getUrl())).diskCacheStrategy(DiskCacheStrategy.NONE).transform(new LeftCrop()).listener(new l0(r110, r113, this, r111, r112, r114)).into(r110);
        return;
    L19:
        if (Intrinsics.areEqual(r110.getTag(R.id.avatar_tag), r113) == false) goto L22;
        r111.setVisibility(8);
        return;
    L5:
        if (TextUtils.isEmpty(r112.V0) == false) goto L8;
        r100 = false;
        goto L10
    }

    public static void b(ImageView r110, Document r111, int r112, ce5.a r210) {
        Intrinsics.checkNotNullParameter(r110, "imageView");
        Intrinsics.checkNotNullParameter(r111, "document");
        String r113 = r111.H;
        boolean r100 = g();
        String r101 = r111.F2;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L59;
        boolean r103 = true;
    L23:
        if (r103 == true) goto L25;
    L54:
        i(r110, r112);
        m.f235806a.getClass();
        Intrinsics.checkNotNullParameter(r111, "document");
        if (h0.b(r111) == false) goto L57;
        return;
    L57:
        h(r110, r111, r210);
        return;
    L25:
        if (r111.getType() != sbb.e.f541301l.f541317b) goto L54;
        if (r113 != null) goto L28;
    L31:
        boolean r104 = true;
    L32:
        if (r104 == true) goto L54;
        if (r100 == false) goto L54;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L39
        String r106 = r111.O;     // Catch: Throwable -> L39
        if (r106 != null) goto L37;
        r106 = "";
    L37:
        Object r107 = Result.m9449constructorimpl(Boolean.valueOf(new JSONObject(r106).optBoolean("icon_has_perm", true)));     // Catch: Throwable -> L39
    L41:
        Boolean r108 = Boolean.TRUE;
        if (Result.m9455isFailureimpl(r107) == false) goto L45;
        r107 = r108;
    L45:
        if (((Boolean) r107).booleanValue() == false) goto L54;
        r110.setTag(R.id.avatar_tag, r113);
        ThumbGlideUrl r109 = new ThumbGlideUrl(r111.f227895q, r113, r111.getType(), r111.K, r111.I, r111.f227867J, ThumbGlideUrl.SOURCE_SPACE_LIST_ICON, true, r110);
        r109.setSubType(r111.F);
        r109.setExtra(r111.O);
        if (r109.isFileIconUseDefault() == false) goto L49;
    L52:
        i(r110, r112);
        return;
    L49:
        if (Intrinsics.areEqual(r110.getTag(R.id.avatar_tag), r113) == false) goto L52;
        Glide.with(r110.getContext()).asBitmap().load(r109).diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(r112).transform(new Transformation[]{new ListIconTransformation(), new CenterCrop(), new RoundedCorners(com.bytedance.ee.util.ui.n.d(8))}).error(r112).into(r110);
        return;
    L39:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L41
    L28:
        if (r113.length() == 0) goto L31;
        r104 = false;
        goto L32
    L59:
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L16
        if (new JSONObject(r101).optString("key").length() != 0) goto L13;
        boolean r116 = true;
    L14:
        Object r117 = Result.m9449constructorimpl(Boolean.valueOf(r116));     // Catch: Throwable -> L16
    L18:
        Boolean r118 = Boolean.TRUE;
        if (Result.m9455isFailureimpl(r117) == false) goto L21;
        r117 = r118;
    L21:
        r103 = ((Boolean) r117).booleanValue();
        goto L23
    L13:
        r116 = false;
    L16:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final void c(ImageView r110, Document r111, int r210, ce5.a r211, Function0<Unit> r212) {
        Intrinsics.checkNotNullParameter(r110, "imageView");
        Intrinsics.checkNotNullParameter(r111, "document");
        Intrinsics.checkNotNullParameter(r212, "onFallbackToListIcon");
        if (TextUtils.isEmpty(r111.f227895q) == true) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == true) goto L12;
        r212.invoke();
        b(r110, r111, r210, r211);
        return;
    L12:
        String r101 = e(r111);
        r110.setTag(R.id.avatar_tag, r101);
        ThumbGlideUrl r102 = new ThumbGlideUrl(r111.f227895q, r111.V0, r111.getType(), r111.f227880h1, r111.f227870b1, r111.f227877g1, ThumbGlideUrl.SOURCE_SPACE_LIST, false, r110);
        r102.setIsConnect(this.f235785a.invoke());
        r102.setExtra(r111.O);
        Glide.with(r110.getContext()).asBitmap().load(r102).skipMemoryCache(r102.needUpdate(r102.getUrl())).diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(r210).transform(new Transformation[]{new ListIconTransformation(), new CenterCrop(), new RoundedCorners(com.bytedance.ee.util.ui.n.d(8))}).error(r210).listener(new b(r110, r101, this, r111, r210, r212, r102)).into(r110);
        return;
    L5:
        if (TextUtils.isEmpty(r111.V0) == false) goto L8;
        r100 = false;
        goto L9
    }
}
