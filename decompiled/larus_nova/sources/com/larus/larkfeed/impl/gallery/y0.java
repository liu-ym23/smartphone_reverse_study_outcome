package com.larus.larkfeed.impl.gallery;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBindings;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.chat.service.IMainBotCommonService;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.SearchImageInfo;
import com.larus.larkfeed.impl.databinding.LarusSocialGalleryTopLayoutBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryImageType;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryItemType;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryType;
import com.ss.android.lark.biz.officesdk.im.mediapreview.OpenFeishuGalleryPermissionState;
import com.ss.android.lark.biz.officesdk.im.mediapreview.OpenFeishuMediaSecurityAction;
import com.ttnet.org.chromium.net.NetError;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import v19.i5;

/* JADX INFO: loaded from: classes30.dex */
public final class y0 extends com.larus.larkfeed.impl.gallery.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f355309k = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LarusSocialGalleryTopLayoutBinding f355310h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<com.larus.bmhome.view.screenmenu.l0> f355311i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function3<? super FragmentActivity, ? super String, ? super String, Unit> f355312j;

    public static final class a {
    }

    public static final class b implements com.larus.bmhome.share.panel.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f355313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f355314b;

        @Override // com.larus.bmhome.share.panel.d
        public final boolean d(String r100, String r101, Boolean r102) {
            return true;
        }

        @Override // com.larus.bmhome.share.panel.d
        public final void f() {
        }

        @Override // com.larus.bmhome.share.panel.d
        public final void onDismiss() {
        }

        @Override // com.larus.bmhome.share.panel.d
        public final void e(Function0<Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
        }

        public b(String r100, Function0<Unit> r101) {
            this.f355313a = r100;
            this.f355314b = r101;
        }

        @Override // com.larus.bmhome.share.panel.d
        public final boolean b(Context r100, DialogFragment r101, View r102, jr9.a r103) {
            Intrinsics.checkNotNullParameter(r103, "shareItemConfig");
            if (Intrinsics.areEqual(r103.b(), this.f355313a) == false) goto L6;
            this.f355314b.invoke();
            return true;
        L6:
            return false;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String G() {
        T r100 = this.f343898d;
        kza.m r101 = (kza.m) r100;
        if (r101 == null) goto L7;
        kza.l r102 = r101.f506778b;
        if (r102 == null) goto L7;
        Object r103 = r102.f506776h;
    L9:
        if ((r103 instanceof Message) == false) goto L11;
        Message r104 = (Message) r103;
    L12:
        if (r104 != null) goto L14;
        return null;
    L14:
        kza.m r105 = (kza.m) r100;
        if (r105 == null) goto L20;
        SearchImageInfo r106 = (SearchImageInfo) CollectionsKt.getOrNull(IMainBotCommonService.f308723a.a(r104), r105.f506782f);
        if (r106 != null) goto L19;
        return null;
    L19:
        return r106.getMainSiteUrl();
    L20:
        return null;
    L11:
        r104 = null;
    L7:
        r103 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void I() {
        ArrayList r100 = new ArrayList();
        boolean r101 = B();
        Integer r102 = Integer.valueOf(R.color.larus_neutral_100_night);
        if (r101 == false) goto L6;
        r100.add(new com.larus.bmhome.view.screenmenu.l0(1, R.string.larus_IM_share_cta_forward, null, null, null, r102, null, Integer.valueOf(R.drawable.larus_ic_share_arrow), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, NetError.ERR_SSL_CLIENT_AUTH_CERT_BAD_FORMAT, 127));
    L6:
        if (H((kza.m) this.f343898d) == false) goto L8;
        r100.add(new com.larus.bmhome.view.screenmenu.l0(4, R.string.larus_LarkIM_Msg_Copy_Button, null, null, null, r102, null, Integer.valueOf(R.drawable.larus_ic_screen_menu_copy_night), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, NetError.ERR_SSL_CLIENT_AUTH_CERT_BAD_FORMAT, 127));
    L8:
        LarkImageView r103 = z();
        if (r103 != null) goto L11;
    L13:
        boolean r104 = false;
    L14:
        if (r104 == false) goto L18;
        r100.add(new com.larus.bmhome.view.screenmenu.l0(2, R.string.larus_LarkIM_Msg_Photos_ViewOriginal_Button, null, null, null, r102, null, Integer.valueOf(R.drawable.larus_ic_original_image), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, NetError.ERR_SSL_CLIENT_AUTH_CERT_BAD_FORMAT, 127));
    L18:
        if (G() == null) goto L20;
        r100.add(new com.larus.bmhome.view.screenmenu.l0(3, R.string.larus_imagePreviewEnhance_menuOption_viewSource, null, null, null, r102, null, Integer.valueOf(R.drawable.larus_layout_big_image_extra_link), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, NetError.ERR_SSL_CLIENT_AUTH_CERT_BAD_FORMAT, 127));
    L20:
        this.f355311i = r100;
        LarusSocialGalleryTopLayoutBinding r105 = this.f355310h;
        if (r105 == null) goto L30;
        ImageView r106 = r105.f355160c;
        if (r106 != null) goto L25;
        return;
    L25:
        if ((!r100.isEmpty()) == false) goto L27;
        int r107 = 0;
    L28:
        r106.setVisibility(r107);
        return;
    L27:
        r107 = 8;
        goto L28
    L30:
        return;
    L11:
        if (r103.f() != true) goto L13;
        r104 = true;
        goto L14
    }

    @Override // com.larus.gallery.api.t
    public final ViewGroup.LayoutParams q() {
        return new ViewGroup.LayoutParams(-1, i5.c0());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void J() {
        if (B() == true) goto L5;
        return;
    L5:
        T r100 = this.f343898d;
        kza.m r101 = (kza.m) r100;
        final FragmentActivity r102 = null;
        if (r101 == null) goto L8;
        GalleryItemType r103 = r101.f506781e;
    L9:
        GalleryItemType r104 = GalleryItemType.Lark;
        if (r103 != r104) goto L26;
        kza.m r105 = (kza.m) r100;
        if (r105 == null) goto L14;
        GalleryType r106 = r105.getType();
    L16:
        if (r106 != GalleryType.Image) goto L26;
        Context r107 = getContext();
        if ((r107 instanceof FragmentActivity) == false) goto L20;
        r102 = (FragmentActivity) r107;
    L20:
        if (r102 == null) goto L99;
        final kza.m r108 = (kza.m) this.f343898d;
        if (r108 == null) goto L100;
        y(r108, OpenFeishuMediaSecurityAction.SHARE, new w0(this, r108, r102));
        return;
    L100:
        return;
    L99:
        return;
    L14:
        r106 = null;
    L26:
        T r109 = this.f343898d;
        kza.m r110 = (kza.m) r109;
        if (r110 == null) goto L29;
        GalleryItemType r111 = r110.f506781e;
    L30:
        if (r111 != r104) goto L46;
        kza.m r112 = (kza.m) r109;
        if (r112 == null) goto L34;
        GalleryType r113 = r112.getType();
    L36:
        if (r113 != GalleryType.Video) goto L46;
        Context r114 = getContext();
        if ((r114 instanceof FragmentActivity) == false) goto L40;
        r102 = (FragmentActivity) r114;
    L40:
        if (r102 == null) goto L101;
        final kza.m r115 = (kza.m) this.f343898d;
        if (r115 == null) goto L102;
        y(r115, OpenFeishuMediaSecurityAction.SHARE, new v0(this, r115, r102));
        return;
    L102:
        return;
    L101:
        return;
    L34:
        r113 = null;
    L46:
        T r116 = this.f343898d;
        kza.m r117 = (kza.m) r116;
        if (r117 == null) goto L49;
        GalleryItemType r118 = r117.f506781e;
    L50:
        GalleryItemType r119 = GalleryItemType.Doubao;
        if (r118 != r119) goto L71;
        kza.m r120 = (kza.m) r116;
        if (r120 == null) goto L55;
        GalleryType r121 = r120.getType();
    L57:
        if (r121 != GalleryType.Image) goto L71;
        Context r122 = getContext();
        if ((r122 instanceof FragmentActivity) == false) goto L61;
        r102 = (FragmentActivity) r122;
    L61:
        if (r102 == null) goto L103;
        final kza.m r123 = (kza.m) this.f343898d;
        if (r123 == null) goto L104;
        kza.l r124 = r123.f506778b;
        if (r124 == null) goto L94;
        final String r125 = r124.f506771c;
        if (r125 == null) goto L95;
        y(r123, OpenFeishuMediaSecurityAction.SHARE, new u0(this, r123, r102, r125));
        return;
    L95:
        return;
    L94:
        return;
    L104:
        return;
    L103:
        return;
    L55:
        r121 = null;
    L71:
        T r126 = this.f343898d;
        kza.m r127 = (kza.m) r126;
        if (r127 == null) goto L74;
        GalleryItemType r128 = r127.f506781e;
    L75:
        if (r128 != r119) goto L97;
        kza.m r129 = (kza.m) r126;
        if (r129 == null) goto L79;
        GalleryType r130 = r129.getType();
    L81:
        if (r130 != GalleryType.Video) goto L98;
        Context r131 = getContext();
        if ((r131 instanceof FragmentActivity) == false) goto L85;
        r102 = (FragmentActivity) r131;
    L85:
        if (r102 == null) goto L105;
        final kza.m r132 = (kza.m) this.f343898d;
        if (r132 == null) goto L106;
        y(r132, OpenFeishuMediaSecurityAction.SHARE, new x0(this, r132, r102));
        return;
    L106:
        return;
    L105:
        return;
    L98:
        return;
    L79:
        r130 = null;
        goto L81
    L97:
        return;
    L74:
        r128 = null;
        goto L75
    L49:
        r118 = null;
        goto L50
    L29:
        r111 = null;
        goto L30
    L8:
        r103 = null;
        goto L9
    }

    public y0(b0 r100) {
        Intrinsics.checkNotNullParameter(r100, "mediaSecurityGuard");
        super(r100);
        this.f355311i = new ArrayList();
    }

    public static boolean H(kza.m r100) {
        if (r100 == null) goto L4;
        GalleryType r101 = r100.getType();
    L6:
        if (r101 == GalleryType.Image) goto L8;
        return false;
    L8:
        kza.o r102 = r100.f506783g;
        if (r102 != null) goto L11;
        return true;
    L11:
        OpenFeishuGalleryPermissionState.a r103 = OpenFeishuGalleryPermissionState.Companion;
        int r104 = r102.f506790a;
        r103.getClass();
        OpenFeishuGalleryPermissionState r105 = OpenFeishuGalleryPermissionState.a.a(r104);
        if (r105 != OpenFeishuGalleryPermissionState.MIDDLE_AUTHORIZATION_STATE) goto L14;
        return false;
    L14:
        if (r105 != OpenFeishuGalleryPermissionState.FINAL_AUTHORIZATION_STATE_DENY) goto L16;
        return false;
    L16:
        if (r102.f506791b == true) goto L18;
        return false;
    L18:
        if (r102.f506792c == false) goto L20;
        return false;
    L20:
        if (r102.f506793d == false) goto L22;
        return false;
    L22:
        if (r102.f506794e == true) goto L30;
        return true;
    L30:
        return false;
    L4:
        r101 = null;
        goto L6
    }

    @Override // com.larus.gallery.api.t
    public final View p(ViewGroup r100) {
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.larus_social_gallery_top_layout, r100, false);
        int r102 = R.id.close;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(r101, R.id.close);
        if (r103 == null) goto L19;
        r102 = R.id.edit;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r101, R.id.edit);
        if (r104 == null) goto L19;
        r102 = R.id.more;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(r101, R.id.more);
        if (r105 == null) goto L19;
        this.f355310h = new LarusSocialGalleryTopLayoutBinding((ConstraintLayout) r101, r103, r104, r105);
        e1.d(r103, new r0(this));
        LarusSocialGalleryTopLayoutBinding r106 = this.f355310h;
        if (r106 == null) goto L13;
        ImageView r107 = r106.f355160c;
        if (r107 == null) goto L13;
        e1.d(r107, new s0(this));
    L13:
        LarusSocialGalleryTopLayoutBinding r108 = this.f355310h;
        if (r108 != null) goto L20;
        return null;
    L20:
        return r108.f355158a;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    }

    @Override // com.larus.gallery.api.t
    public final void x(com.larus.gallery.api.p r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof com.larus.gallery.api.p.e) == false) goto L6;
        J();
        return;
    }

    public static final String F(y0 r100, PolarisFileWrapper r101) {
        r100.getClass();
        BitmapFactory.Options r102 = new BitmapFactory.Options();
        boolean r103 = true;
        r102.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r101.getPath(), r102);
        String r104 = r102.outMimeType;
        if (r104 != null) goto L5;
    L7:
        r104 = null;
    L8:
        if (r104 == null) goto L14;
        String r105 = MimeTypeMap.getSingleton().getExtensionFromMimeType(r104);
        if (r105 != null) goto L12;
        return null;
    L12:
        if ((!StringsKt.isBlank(r105)) == true) goto L30;
        return null;
    L30:
        return r105;
    L14:
        r105 = FilesKt.getExtension(r101);
        if ((!StringsKt.isBlank(r105)) == true) goto L18;
        r105 = null;
    L18:
        if (r105 == null) goto L32;
        String r106 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r105);
        if (r106 != null) goto L23;
    L25:
        r103 = false;
    L26:
        if (r103 == true) goto L30;
        return null;
    L23:
        if (StringsKt.startsWith$default(r106, "image/", false, 2, null) != true) goto L25;
    L32:
        return null;
    L5:
        if (StringsKt.startsWith$default(r104, "image/", false, 2, null) == false) goto L7;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, kotlin.jvm.functions.Function3<? super androidx.fragment.app.FragmentActivity, ? super java.lang.String, ? super java.lang.String, kotlin.Unit>] */
    @Override // com.larus.larkfeed.impl.gallery.a
    public final void C(final kza.m r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        super.C(r100, r101);
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        ?? r103 = this.f355312j;
        r102.element = r103;
        if (r103 != 0) goto L10;
        LarusSocialGalleryTopLayoutBinding r104 = this.f355310h;
        if (r104 == null) goto L45;
        ImageView r105 = r104.f355159b;
        if (r105 == null) goto L45;
        e1.o(r105);
    L45:
        I();
        return;
    L10:
        if (r100.f506781e != GalleryItemType.Lark) goto L26;
        if (r100.getType() != GalleryType.Image) goto L26;
        kza.l r106 = r100.f506778b;
        if (r106 == null) goto L18;
        kza.e r107 = r106.f506774f;
        if (r107 == null) goto L18;
        getContext();
        r107.c();
        boolean r108 = true;
    L19:
        if (r108 == false) goto L26;
        LarusSocialGalleryTopLayoutBinding r109 = this.f355310h;
        if (r109 == null) goto L45;
        final ImageView r110 = r109.f355159b;
        if (r110 == null) goto L45;
        r110.setOnClickListener(new e0(this, r110));
        e1.x(r110);
    L18:
        r108 = false;
    L26:
        if (r100.f506781e == GalleryItemType.Doubao) goto L28;
    L40:
        LarusSocialGalleryTopLayoutBinding r111 = this.f355310h;
        if (r111 == null) goto L45;
        ImageView r112 = r111.f355159b;
        if (r112 == null) goto L45;
        e1.o(r112);
        goto L45
    L28:
        if (r100.getType() != GalleryType.Image) goto L40;
        kza.l r113 = r100.f506778b;
        if (r113 == null) goto L32;
        String r114 = r113.f506771c;
    L34:
        if (com.larus.utils.o0.d(r114) != true) goto L40;
        LarusSocialGalleryTopLayoutBinding r115 = this.f355310h;
        if (r115 == null) goto L45;
        final ImageView r116 = r115.f355159b;
        if (r116 == null) goto L45;
        r116.setOnClickListener(new p0(this, r116, r100, r102));
        e1.x(r116);
        goto L45
    L32:
        r114 = null;
        goto L34
    }

    @Override // com.larus.larkfeed.impl.gallery.a, com.larus.gallery.api.t
    public final /* bridge */ /* synthetic */ void w(kza.m r100, int r101) {
        C(r100, r101);
    }

    public static final Object D(y0 r210, kza.m r310, Continuation r311) {
        r210.getClass();
        if ((r311 instanceof SocialGalleryTopProvider$getLarkImageShareContent$1) == false) goto L7;
        SocialGalleryTopProvider$getLarkImageShareContent$1 r100 = (SocialGalleryTopProvider$getLarkImageShareContent$1) r311;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L30:
        String r105 = (String) r102;
    L31:
        String r106 = r105;
        return new com.larus.bmhome.share.panel.b(r106, null, r106, r106, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, false, false, null, false, null, null, 67108850);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        LarkImageView r107 = r210.z();
        if (r107 != null) goto L17;
    L19:
        boolean r108 = false;
    L20:
        if (r108 == false) goto L22;
        GalleryImageType r109 = GalleryImageType.Middle;
    L23:
        kza.l r110 = r310.f506778b;
        if (r110 == null) goto L32;
        kza.e r111 = r110.f506774f;
        if (r111 == null) goto L32;
        r100.label = 1;
        r102 = r111.b(r109, false, r100);
        if (r102 != r103) goto L30;
        return r103;
    L32:
        r105 = null;
        goto L31
    L22:
        r109 = GalleryImageType.Origin;
        goto L23
    L17:
        if (r107.f() != true) goto L19;
        r108 = true;
    L7:
        r100 = new SocialGalleryTopProvider$getLarkImageShareContent$1(r210, r311);
        goto L8
    }

    public static final Object E(y0 r100, Context r101, kza.m r102, boolean r110, Continuation r111) {
        r100.getClass();
        if ((r111 instanceof SocialGalleryTopProvider$resolveCopyImageUri$1) == false) goto L7;
        SocialGalleryTopProvider$resolveCopyImageUri$1 r103 = (SocialGalleryTopProvider$resolveCopyImageUri$1) r111;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r112 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L18;
        if (r106 == 1) goto L17;
        if (r106 == 2) goto L16;
        if (r106 == 3) goto L16;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r112);
    L56:
        return r112;
    L17:
        r101 = (Context) r103.L$0;
        ResultKt.throwOnFailure(r112);
    L30:
        String r113 = (String) r112;
        if (r113 == null) goto L55;
        if ((!StringsKt.isBlank(r113)) == true) goto L36;
        r113 = null;
    L36:
        if (r113 == null) goto L55;
        r103.L$0 = null;
        r103.label = 2;
        r112 = BuildersKt.withContext(Dispatchers.getIO(), new SocialGalleryTopProvider$prepareLarkImageCopyUri$2(r113, r101, r100, null), r103);
        if (r112 != r105) goto L56;
        return r105;
    L55:
        return null;
    L18:
        ResultKt.throwOnFailure(r112);
        if (r102.f506781e != GalleryItemType.Lark) goto L40;
        if (r110 == false) goto L22;
        GalleryImageType r114 = GalleryImageType.Origin;
    L23:
        kza.l r107 = r102.f506778b;
        if (r107 == null) goto L55;
        kza.e r108 = r107.f506774f;
        if (r108 == null) goto L55;
        r103.L$0 = r101;
        r103.label = 1;
        r112 = r108.a(r101, r114, r103);
        if (r112 != r105) goto L30;
        return r105;
    L22:
        r114 = GalleryImageType.Middle;
        goto L23
    L40:
        kza.l r109 = r102.f506778b;
        if (r109 == null) goto L55;
        String r115 = r109.f506771c;
        if (r115 == null) goto L55;
        if ((!StringsKt.isBlank(r115)) == true) goto L48;
        r115 = null;
    L48:
        if (r115 == null) goto L55;
        ImageSave r116 = ImageSave.f295932a;
        r103.label = 3;
        r112 = r116.y(r101, r115, null, r103);
        if (r112 != r105) goto L56;
        return r105;
    L7:
        r103 = new SocialGalleryTopProvider$resolveCopyImageUri$1(r100, r111);
        goto L8
    }

    public static void K(FragmentActivity r100, ShareScene r110, com.larus.bmhome.share.panel.b r111, String r112, Function0 r113) {
        IShareService.a.g(ShareServiceDelegate.f313831b, r100, r110, r111, null, new b(r112, r113), null, false, 104);
    }
}
