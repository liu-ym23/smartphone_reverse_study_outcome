package com.larus.chat.gallery.impl.preview.provider;

import android.app.Application;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.ViewGroup;
import androidx.camera.video.AudioStats;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.camera.api.IFlowCamera;
import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.ImageParam;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.api.params.InputParamExtra;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.api.params.VideoParam;
import com.larus.chat.gallery.api.PreviewMediaType;
import com.larus.chat.gallery.impl.preview.data.LocalMediaType;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.chat.gallery.impl.preview.input.ChildResultMode;
import com.larus.chat.gallery.impl.preview.input.PreviewCameraParamProvider;
import com.larus.chat.gallery.impl.preview.input.PreviewInputCallback;
import com.larus.chat.gallery.providers.input.GalleryInputFragment;
import com.larus.common.apphost.AppHost;
import com.larus.gallery.api.GalleryType;
import com.larus.nova.R;
import com.larus.platform.AlbumHelper;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionData;
import com.larus.platform.model.action.SuggestedActionScene;
import com.larus.platform.model.album.AlbumInputState;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.platform.model.preview.AttachmentEditType;
import com.larus.platform.model.preview.AttachmentMediaType;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.model.preview.InputDraftSnapshot;
import com.larus.platform.model.preview.MediaEntry;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class PreviewBottomProvider extends com.larus.gallery.api.t<xy8.d> implements com.larus.chat.gallery.impl.preview.input.m {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f324464x = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.chat.gallery.impl.preview.input.e0 f324465f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f324466g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PreviewCameraParamProvider f324467h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.larus.chat.gallery.impl.preview.c f324468i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.larus.chat.gallery.impl.preview.input.d0 f324469j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final r f324470k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f324471l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.larus.chat.gallery.api.z f324472m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f324473n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AlbumHelper f324474o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f324475p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f324476q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Boolean f324477r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f324478s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f324479t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f324480u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f324481v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f324482w;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f324483a = null;

        static {
            int[] r100 = new int[GalleryType.values().length];
            r100[GalleryType.Image.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[GalleryType.Video.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f324483a = r100;
        }
    }

    public static final class c implements zy8.u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PreviewBottomProvider f324484a;

        public c(PreviewBottomProvider r100) {
            this.f324484a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // zy8.u
        public final boolean b(String r100, zy8.s r101) {
            Intrinsics.checkNotNullParameter(r100, "text");
            PreviewBottomProvider r102 = this.f324484a;
            xy8.d r103 = (xy8.d) r102.f343898d;
            if (r103 == null) goto L5;
            GalleryType r104 = r103.f565430e;
        L7:
            if (r104 == GalleryType.Image) goto L10;
            FLogger.f375446a.w("PreviewBottomProvider", "sendTextWithCurrentImage skipped: current is not image");
            return false;
        L10:
            r102.C().f(r100, r101);
            return true;
        L5:
            r104 = null;
            goto L7
        }
    }

    static {
    }

    @Override // com.larus.gallery.api.t
    public final boolean m() {
        return false;
    }

    public final void B() {
        if (this.f324476q == true) goto L5;
        return;
    L5:
        t19.s.f544207a.a();
        this.f324476q = false;
    }

    public final PreviewInputCallback C() {
        return (PreviewInputCallback) this.f324479t.getValue();
    }

    public final GalleryInputFragment D() {
        return (GalleryInputFragment) this.f324480u.getValue();
    }

    public final com.larus.chat.gallery.api.q E() {
        return this.f324469j.getSession();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void I() {
        xy8.d r100 = (xy8.d) this.f343898d;
        AlbumInputState r101 = null;
        if (r100 == null) goto L76;
        xy8.e r102 = r100.f565438m;
        if (r102 == null) goto L9;
        String r103 = r102.f565447e;
        if (r103 == null) goto L9;
    L12:
        if (r102 == null) goto L15;
        String r104 = r102.f565445c;
        if (r104 == null) goto L15;
    L20:
        if (r100.f565426a != SourceType.USER_SEND) goto L22;
        String r105 = "user";
    L24:
        if (b.f324483a[r100.f565430e.ordinal()] != 2) goto L26;
        String r106 = "video_detail";
    L27:
        String r107 = this.f324467h.f324313b.invoke();
        wc9.e r110 = AuthModelDelegate.f297134b.y().getValue();
        if (r110 == null) goto L30;
        String r111 = r110.f559198a;
    L31:
        if (r107 != null) goto L33;
    L36:
        boolean r112 = true;
    L37:
        if (r112 == true) goto L48;
        if (r111 != null) goto L40;
    L43:
        boolean r113 = true;
    L44:
        if (r113 == true) goto L48;
        if (Intrinsics.areEqual(r107, r111) == false) goto L48;
        String r108 = "default";
    L49:
        Object r114 = r100.f565431f.get("enter_method");
        if ((r114 instanceof String) == false) goto L52;
        String r115 = (String) r114;
    L53:
        if (r115 != null) goto L55;
        r115 = "";
    L55:
        JSONObject r116 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r109 = r100.f565431f.entrySet().iterator();
    L57:
        if (r109.hasNext() == false) goto L59;
        Map.Entry<String, Object> r117 = r109.next();
        r116.put(r117.getKey(), r117.getValue());
        goto L57
    L59:
        if (r103 != null) goto L61;
    L64:
        boolean r118 = true;
    L65:
        if (r118 == true) goto L67;
        r116.put("creation_task_id", r103);
    L67:
        if (r104 != null) goto L69;
    L72:
        boolean r119 = true;
    L73:
        if (r119 == true) goto L75;
        r116.put(MusicAppletPage.KEY_MESSAGE_ID, r104);
    L75:
        r116.put("click_from", "click_input_plus_icon");
        r116.put("current_page", r106);
        r116.put("chat_type", r108);
        r116.put("enter_method", r115);
        r116.put("user_type", r105);
        com.larus.platform.service.o.f365780a.reportEvent("click_upload_entrance", r116);
        goto L76
    L69:
        if (r104.length() == 0) goto L72;
        r119 = false;
        goto L73
    L61:
        if (r103.length() == 0) goto L64;
        r118 = false;
        goto L65
    L52:
        r115 = null;
        goto L53
    L40:
        if (r111.length() == 0) goto L43;
        r113 = false;
    L48:
        r108 = "default_new";
        goto L49
    L33:
        if (r107.length() == 0) goto L36;
        r112 = false;
        goto L37
    L30:
        r111 = null;
        goto L31
    L26:
        r106 = "picture_detail";
        goto L27
    L22:
        r105 = "bot";
    L15:
        xy8.f r120 = r100.f565437l;
        if (r120 == null) goto L18;
        r104 = r120.f565454a;
        goto L20
    L18:
        r104 = null;
    L9:
        if (r102 == null) goto L11;
        r103 = r102.f565443a;
        goto L12
    L11:
        r103 = null;
    L76:
        com.larus.chat.gallery.api.q r121 = E();
        if (r121 == null) goto L88;
        List<AttachmentSnapshot> r122 = r121.Qa();
        if (r122 == null) goto L88;
        HashSet r123 = new HashSet();
        ArrayList r124 = new ArrayList();
        Iterator<T> r125 = r122.iterator();
    L82:
        if (r125.hasNext() == false) goto L86;
        Object r126 = r125.next();
        if (r123.add(((AttachmentSnapshot) r126).getStableId()) == false) goto L82;
        r124.add(r126);
        goto L82
    L86:
        int r127 = r124.size();
    L97:
        int r128 = RangesKt.coerceAtLeast(20 - r127, 0);
        if (r128 != 0) goto L102;
        t19.s r129 = t19.s.f544207a;
        AppHost.Companion r130 = AppHost.f326268a;
        Application r131 = r130.getApplication();
        String r132 = r130.getApplication().getString(R.string.larus_videoSum_select_errToast_limit, new Object[]{"20"});
        r129.getClass();
        t19.s.t(r131, r132);
        return;
    L102:
        if (this.f324468i.f324224g == false) goto L109;
        xy8.d r133 = (xy8.d) this.f343898d;
        if (r133 == null) goto L109;
        PreviewCameraParamProvider r134 = this.f324467h;
        com.larus.chat.gallery.api.q r135 = E();
        r134.getClass();
        Intrinsics.checkNotNullParameter(r133, "data");
        if (r134.s(r135) == false) goto L109;
        int r136 = com.larus.chat.gallery.impl.preview.input.y.f324402a;
        InputDraftSnapshot r137 = com.larus.chat.gallery.impl.preview.input.y.b(r135, r134.f324325n, r133, true, SetsKt.emptySet());
        String r138 = r134.l(r137);
        Intrinsics.checkNotNullParameter(r137, "snapshot");
        Intrinsics.checkNotNullParameter(r138, "snapshotId");
        r101 = new AlbumInputState(r137.getText(), r137.getAttachments(), r137.getSourceNodeId(), r138, null, 16, null);
    L109:
        AlbumSettingConfig.a r139 = new AlbumSettingConfig.a();
        r139.f365529o = Boolean.valueOf(this.f324467h.f324319h);
        r139.f365517c = true;
        r139.f365518d = r128;
        r139.f365520f = "preview_gallery_plus";
        r139.f365528n = true;
        r139.c(MediaEntry.PREVIEW_PLUS);
        Boolean r140 = this.f324468i.f324223f;
        if (r140 == null) goto L112;
        r139.f365523i = r140.booleanValue();
    L112:
        Boolean r141 = this.f324468i.f324225h;
        if (r141 == null) goto L116;
        r139.f365527m = r141.booleanValue();
    L116:
        if (this.f324468i.f324224g == false) goto L119;
        if (r101 == null) goto L119;
        r139.f365525k = true;
        r139.b(r101);
        r139.f365531q = true;
    L119:
        AlbumSettingConfig r142 = r139.a();
        J();
        AlbumHelper.f(this.f324474o, D(), r142, new z(), new k0(this), this.f324467h.f324312a.invoke(), null, 0, null, "preview_gallery", null, null, null, 3584);
        return;
    L88:
        if (this.f324468i.f324219b == false) goto L96;
        xy8.d r143 = (xy8.d) this.f343898d;
        if (r143 == null) goto L92;
        GalleryType r144 = r143.f565430e;
    L94:
        if (r144 != GalleryType.Image) goto L96;
        r127 = 1;
        goto L97
    L92:
        r144 = null;
    L96:
        r127 = 0;
        goto L97
    }

    public final void J() {
        if (this.f324468i.f324224g == false) goto L6;
        G(new b0());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [com.larus.chat.gallery.impl.preview.provider.w0] */
    /* JADX WARN: Type inference failed for: r1v12, types: [com.larus.chat.gallery.impl.preview.provider.a0] */
    /* JADX WARN: Type inference failed for: r1v20, types: [com.larus.chat.gallery.impl.preview.provider.y0] */
    /* JADX WARN: Type inference failed for: r1v22, types: [com.larus.chat.gallery.impl.preview.provider.x0] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.larus.chat.gallery.impl.preview.input.o, ex8.b] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.larus.gallery.api.t
    public final void t() {
        com.larus.gallery.api.w r100 = this.f343899e;
        if (r100 == null) goto L5;
        r100.Op(Reflection.getOrCreateKotlinClass(com.larus.chat.gallery.impl.preview.input.m.class), this);
    L5:
        com.larus.gallery.api.w r101 = this.f343899e;
        if (r101 == null) goto L8;
        r101.Op(Reflection.getOrCreateKotlinClass(zy8.u.class), new c(this));
    L8:
        PreviewCameraParamProvider r102 = this.f324467h;
        r102.f324321j = new t0(this);
        if (E() == null) goto L11;
        L(D());
    L11:
        PreviewCameraParamProvider r103 = this.f324467h;
        String r104 = this.f324469j.a();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "text");
        r103.f324325n = r104;
        PreviewCameraParamProvider r105 = this.f324467h;
        r105.f324316e.f324377d = new u0(this);
        PreviewCameraParamProvider r106 = this.f324467h;
        r106.f324322k = new v0(this);
        r106.f324323l = new PreviewBottomProvider$onAttach$5(this.f324469j);
        final PreviewCameraParamProvider r107 = this.f324467h;
        r107.getClass();
        IFlowCamera r108 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r108 != 0) goto L15;
        FLogger.f375446a.e("PreviewCameraParamProvider", "setupCommandListener: IFlowCamera service not found");
    L18:
        this.f324469j.j(new w0(this));
        com.larus.chat.gallery.api.z r109 = this.f324472m;
        if (r109 == 0) goto L21;
        r109.e(new x0(this));
    L21:
        com.larus.chat.gallery.api.z r110 = this.f324472m;
        if (r110 == null) goto L24;
        r110.g(new PreviewBottomProvider$onAttach$8(C()));
    L24:
        com.larus.chat.gallery.api.z r111 = this.f324472m;
        if (r111 == 0) goto L27;
        r111.f(new y0(this));
    L27:
        com.larus.chat.gallery.api.z r112 = this.f324472m;
        if (r112 == null) goto L30;
        r112.c(new PreviewBottomProvider$onAttach$10(C()));
    L30:
        com.larus.chat.gallery.api.z r113 = this.f324472m;
        if (r113 != null) goto L33;
    L37:
        this.f324465f.a(new a0(this));
        FLogger.f375446a.i("PreviewBottomProvider", "onAttach: registered IPreviewInputCapability & ISendTextWithImageCapability");
        return;
    L33:
        if (this.f324468i.f324218a == false) goto L35;
        PreviewBottomProvider$onAttach$11 r114 = new PreviewBottomProvider$onAttach$11(this);
    L36:
        r113.b(r114);
        goto L37
    L35:
        r114 = null;
        goto L36
    L15:
        if (r107.f324328q != null) goto L18;
        ?? r115 = new com.larus.chat.gallery.impl.preview.input.o(r107);
        r107.f324327p = r108.t();
        r107.f324328q = r115;
        r108.f(r115);
        FLogger.f375446a.i("PreviewCameraParamProvider", "setupCommandListener: done");
        goto L18
    }

    @Override // com.larus.gallery.api.t
    public final void u() {
        B();
        this.f324465f.a(null);
        this.f324465f.c(true);
        PreviewCameraParamProvider r100 = this.f324467h;
        r100.f324321j = null;
        r100.f324316e.f324377d = null;
        PreviewCameraParamProvider r101 = this.f324467h;
        r101.f324322k = null;
        r101.f324323l = null;
        IFlowCamera r102 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        com.larus.chat.gallery.impl.preview.input.o r103 = r101.f324328q;
        ex8.b r104 = r101.f324327p;
        if (r103 == null) goto L9;
        if (r102 == null) goto L6;
        ex8.b r105 = r102.t();
    L7:
        if (r105 != r103) goto L9;
        r102.f(r104);
        goto L9
    L6:
        r105 = null;
    L9:
        r101.f324328q = null;
        r101.f324327p = null;
        this.f324467h.k();
        com.larus.chat.gallery.impl.preview.p r106 = this.f324467h.f324315d;
        if ((r106 instanceof com.larus.chat.gallery.impl.preview.p.a) == false) goto L12;
        com.larus.chat.gallery.impl.preview.p.a r107 = (com.larus.chat.gallery.impl.preview.p.a) r106;
    L13:
        if (r107 == null) goto L21;
        com.larus.bmhome.chat.api.q0 r108 = r107.f324418e;
        if (r108 == null) goto L21;
        com.larus.bmhome.chat.api.q0.a r109 = r108.getProvider();
        if (r109 == null) goto L21;
        zb8.e r110 = r109.P8();
        if (r110 == null) goto L21;
        r110.MI();
    L21:
        this.f324469j.detach();
        com.larus.chat.gallery.api.z r111 = this.f324472m;
        if (r111 == null) goto L24;
        r111.e(null);
    L24:
        com.larus.chat.gallery.api.z r112 = this.f324472m;
        if (r112 == null) goto L27;
        r112.g(null);
    L27:
        com.larus.chat.gallery.api.z r113 = this.f324472m;
        if (r113 == null) goto L30;
        r113.f(null);
    L30:
        com.larus.chat.gallery.api.z r114 = this.f324472m;
        if (r114 == null) goto L33;
        r114.c(null);
    L33:
        com.larus.chat.gallery.api.z r115 = this.f324472m;
        if (r115 == null) goto L37;
        r115.b(null);
    L37:
        if (this.f324471l == false) goto L43;
        com.larus.chat.gallery.providers.input.a r116 = (com.larus.chat.gallery.providers.input.a) s1a.a.g(D()).getAbility(com.larus.chat.gallery.providers.input.a.class);
        if (r116 == null) goto L41;
        Intrinsics.checkNotNullParameter(r116, "$this$inputAbility");
        r116.g();
        Unit r117 = Unit.INSTANCE;
        return;
    L41:
        FLogger.f375446a.e("PreviewBottomProvider", "[inputAbility] failed, cannot get GalleryInputAbility");
        return;
    L43:
        return;
    L12:
        r107 = null;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean A(CameraOutputContext r100) {
        if (this.f324469j.h(r100, (xy8.d) this.f343898d) == true) goto L6;
        return false;
    L6:
        xy8.d r101 = (xy8.d) this.f343898d;
        if (r101 == null) goto L9;
        SourceType r102 = r101.f565426a;
    L10:
        List<com.larus.chat.gallery.api.o> r103 = this.f324469j.l();
        if (r102 != null) goto L13;
    L21:
        com.larus.chat.gallery.api.o r104 = this.f324469j.b();
        if (r104 != null) goto L24;
        return true;
    L24:
        M(r104);
        return true;
    L13:
        if ((!r103.isEmpty()) == false) goto L21;
        com.larus.gallery.api.w r105 = this.f343899e;
        if (r105 == null) goto L21;
        List<com.larus.chat.gallery.api.o> r106 = r103;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L18:
        if (r108.hasNext() == false) goto L20;
        r107.add(com.larus.chat.gallery.impl.preview.datasource.m.a((com.larus.chat.gallery.api.o) r108.next(), r102));
        goto L18
    L20:
        r105.Rf(new com.larus.gallery.api.p.a(r107));
        goto L21
    L9:
        r102 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F(String r100) {
        xy8.d r101 = (xy8.d) this.f343898d;
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.f324465f.e(r100, r101, null) == false) goto L11;
        com.larus.gallery.api.w r102 = this.f343899e;
        if (r102 == null) goto L12;
        r102.Rf(com.larus.gallery.api.p.c.f343878a);
        return;
    L12:
        return;
    }

    public final void G(Function1<? super com.larus.chat.gallery.providers.input.a, Unit> r100) {
        com.larus.chat.gallery.providers.input.a r101 = (com.larus.chat.gallery.providers.input.a) s1a.a.g(D()).getAbility(com.larus.chat.gallery.providers.input.a.class);
        if (r101 == null) goto L5;
        r100.invoke(r101);
        return;
    L5:
        FLogger.f375446a.e("PreviewBottomProvider", "[inputAbility] failed, cannot get GalleryInputAbility");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void H(xp9.i r110) {
        if (this.f324475p == false) goto L6;
        FLogger.f375446a.i("PreviewBottomProvider", "launchMarkPageWithAlbumResult ignored: mark page is launching");
        return;
    L6:
        FragmentActivity r100 = D().getActivity();
        String r101 = null;
        if ((r100 instanceof FragmentActivity) == false) goto L9;
        FragmentActivity r102 = r100;
    L10:
        if (r102 != null) goto L13;
        FLogger.f375446a.e("PreviewBottomProvider", "launchMarkPageWithAlbumResult: activity is null");
        return;
    L13:
        IFlowCamera r103 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r103 != null) goto L17;
        FLogger.f375446a.e("PreviewBottomProvider", "launchMarkPageWithAlbumResult: IFlowCamera service not found");
        return;
    L17:
        xy8.d r104 = (xy8.d) this.f343898d;
        boolean r105 = false;
        if (this.f324468i.f324222e == false) goto L34;
        if (r104 == null) goto L21;
        GalleryType r106 = r104.f565430e;
    L23:
        if (r106 != GalleryType.Image) goto L34;
        xy8.b r107 = r104.f565428c;
        if (r107 == null) goto L34;
        String r108 = r107.f565416d;
        if (r108 == null) goto L34;
        if (r108.length() <= 0) goto L31;
        boolean r109 = true;
    L32:
        if (r109 == false) goto L34;
        String r111 = r108;
    L35:
        com.larus.chat.gallery.impl.preview.c r112 = this.f324468i;
        if (r112.f324219b == false) goto L54;
        if (r104 == null) goto L39;
        GalleryType r113 = r104.f565430e;
    L41:
        if (r113 != GalleryType.Image) goto L54;
        xy8.b r114 = r104.f565428c;
        if (r114 == null) goto L46;
        String r115 = r114.f565413a;
        if (r115 == null) goto L46;
    L55:
        if (r115 != null) goto L57;
    L58:
        r105 = true;
    L59:
        if (r105 == true) goto L61;
        this.f324475p = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(D()), null, null, new PreviewBottomProvider$launchMarkPageWithAlbumResult$1(r111, this, r102, r103, r104, r115, r110, null), 3, null);
        return;
    L61:
        y(r102, r103, r104, r115, null, r110);
        return;
    L57:
        if (r115.length() != 0) goto L59;
    L46:
        if (r114 == null) goto L52;
        String r116 = r114.f565415c;
        if (r116 == null) goto L52;
        if (r112.f324221d == false) goto L52;
        r101 = r116;
    L52:
        if (r101 != null) goto L54;
        r115 = r111;
        goto L55
    L39:
        r113 = null;
    L54:
        r115 = r101;
        goto L55
    L31:
        r109 = false;
        goto L32
    L21:
        r106 = null;
    L34:
        r111 = null;
        goto L35
    L9:
        r102 = null;
        goto L10
    }

    public final void K(xy8.d r100) {
        final List r101 = null;
        if (this.f324468i.f324224g == true) goto L5;
    L55:
        final SuggestedActionScene r102 = null;
    L56:
        if (r102 != null) goto L62;
        com.larus.chat.gallery.providers.input.a r103 = (com.larus.chat.gallery.providers.input.a) s1a.a.g(D()).getAbility(com.larus.chat.gallery.providers.input.a.class);
        if (r103 == null) goto L60;
        Intrinsics.checkNotNullParameter(r103, "$this$inputAbility");
        r103.qC();
        Unit r104 = Unit.INSTANCE;
        return;
    L60:
        FLogger.f375446a.e("PreviewBottomProvider", "[inputAbility] failed, cannot get GalleryInputAbility");
        return;
    L62:
        String r105 = this.f324467h.f324312a.invoke();
        if (r105 != null) goto L65;
        r105 = "";
    L65:
        SuggestedActionData r106 = com.larus.bmhome.chat.camera.command.v.a(r105);
        if (r106 != null) goto L68;
        r106 = bc8.e.f18592a.b(r105);
    L68:
        if (r106 == null) goto L72;
        List<SuggestedAction> r107 = r106.get(r102);
        if (r107 == null) goto L72;
        r101 = CollectionsKt.filterNotNull(r107);
    L72:
        if (r101 != null) goto L74;
        r101 = CollectionsKt.emptyList();
    L74:
        G(new r0(r101, r102, this));
        return;
    L5:
        if (this.f324471l == false) goto L55;
        if (r100 == null) goto L55;
        SourceType r108 = r100.f565426a;
        if (r108 == SourceType.ALBUM) goto L14;
        if (r108 != SourceType.ATTACHMENT) goto L55;
    L14:
        if (com.larus.bmhome.chat.camera.command.q.b(this.f324467h.f324316e.f324378e) == false) goto L55;
        if (r100.f565430e != GalleryType.Image) goto L55;
        com.larus.chat.gallery.api.q r109 = E();
        if (r109 == null) goto L22;
        List<AttachmentSnapshot> r110 = r109.Qa();
    L23:
        if (r110 != null) goto L25;
        r110 = CollectionsKt.emptyList();
    L25:
        com.larus.chat.gallery.api.q r111 = E();
        if (r111 == null) goto L28;
        List<AttachmentSnapshot> r112 = r111.Qa();
    L29:
        if (r112 != null) goto L31;
        r112 = CollectionsKt.emptyList();
    L31:
        List<AttachmentSnapshot> r113 = r112;
        int r114 = 0;
        if ((r113 instanceof Collection) == true) goto L34;
    L36:
        Iterator<T> r115 = r113.iterator();
        int r116 = 0;
    L38:
        if (r115.hasNext() == false) goto L47;
        if (((AttachmentSnapshot) r115.next()).getMediaType() != AttachmentMediaType.IMAGE) goto L42;
        boolean r117 = true;
    L43:
        if (r117 == false) goto L38;
        r116 = r116 + 1;
        if (r116 >= 0) goto L38;
        CollectionsKt.throwCountOverflow();
        goto L38
    L42:
        r117 = false;
        goto L43
    L47:
        r114 = r116;
    L48:
        if (r114 == 0) goto L50;
    L52:
        if (r114 <= 1) goto L54;
        r102 = SuggestedActionScene.AttachmentAreaMultiImg;
        goto L56
    L54:
        r102 = SuggestedActionScene.AttachmentAreaSingleImg;
        goto L56
    L50:
        if ((!r110.isEmpty()) == false) goto L52;
    L34:
        if (r113.isEmpty() == false) goto L36;
    L28:
        r112 = null;
        goto L29
    L22:
        r110 = null;
        goto L23
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.larus.chat.gallery.impl.preview.provider.e0, java.lang.Object, kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.larus.chat.gallery.impl.preview.input.s] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.chat.gallery.impl.preview.provider.f0, java.lang.Object, kotlin.jvm.functions.Function0] */
    public final void L(GalleryInputFragment r100) {
        final IFlowCamera r101 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r101 != 0) goto L6;
        FLogger.f375446a.e("PreviewBottomProvider", "registerCameraResult: IFlowCamera service not found");
        return;
    L6:
        final ?? r102 = new e0(this, r101);
        final ?? r103 = new f0(this);
        r101.m(r100, r102, r103);
        PreviewCameraParamProvider r104 = this.f324467h;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r102, "onSuccess");
        Intrinsics.checkNotNullParameter(r103, "onFail");
        com.larus.chat.gallery.impl.preview.p r105 = r104.f324315d;
        if ((r105 instanceof com.larus.chat.gallery.impl.preview.p.a) == false) goto L9;
        com.larus.chat.gallery.impl.preview.p.a r106 = (com.larus.chat.gallery.impl.preview.p.a) r105;
    L10:
        if (r106 == null) goto L18;
        com.larus.bmhome.chat.api.q0 r107 = r106.f324418e;
        if (r107 == null) goto L18;
        com.larus.bmhome.chat.api.q0.a r108 = r107.getProvider();
        if (r108 == null) goto L18;
        zb8.e r109 = r108.P8();
        if (r109 == null) goto L18;
        zb8.e.a.a(r109, new com.larus.chat.gallery.impl.preview.input.r(r102), new com.larus.chat.gallery.impl.preview.input.s(r103), 4);
    L18:
        r101.p(r100, new g0(this));
        return;
    L9:
        r106 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void M(com.larus.chat.gallery.api.o r310) {
        xy8.d r100 = (xy8.d) this.f343898d;
        if (r100 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r100.f565427b, r310.f324170a) == true) goto L8;
        return;
    L8:
        com.larus.chat.gallery.impl.preview.datasource.n r101 = com.larus.chat.gallery.impl.preview.datasource.n.f324277a;
        String r102 = r310.f324171b;
        r101.getClass();
        String r103 = com.larus.chat.gallery.impl.preview.datasource.n.a(r102);
        if (r310.getType() != PreviewMediaType.VIDEO) goto L15;
        String r104 = r310.f324170a;
        String r110 = com.larus.chat.gallery.impl.preview.datasource.n.d(r310.f324171b);
        String r210 = com.larus.chat.gallery.impl.preview.datasource.n.c(r310.f324171b);
        String r105 = com.larus.chat.gallery.impl.preview.datasource.n.a(r310.f324171b);
        if (StringsKt.startsWith(r105, "content://", true) == true) goto L14;
        r105 = null;
    L14:
        xy8.d r106 = xy8.d.a(r100, null, new xy8.g(r104, r110, null, com.larus.chat.gallery.impl.preview.datasource.n.b(r310.f324173d), null, r210, null, null, null, r310.f324174e, r310.f324175f, r310.f324176g / 1000.0d, null, null, r105, 29140), GalleryType.Video, null, null, null, null, null, new xy8.c(LocalMediaType.VIDEO, r103, com.larus.chat.gallery.impl.preview.datasource.n.c(r310.f324171b)), 0, 98275);
    L16:
        com.larus.gallery.api.w r107 = this.f343899e;
        if (r107 != null) goto L19;
        return;
    L19:
        if (E() == null) goto L21;
        boolean r111 = true;
    L22:
        r107.Rf(new com.larus.gallery.api.p.j(r106, r111));
        return;
    L21:
        r111 = false;
        goto L22
    L15:
        r106 = xy8.d.a(r100, new xy8.b(r103, com.larus.chat.gallery.impl.preview.datasource.n.b(r310.f324173d), r103, null, null, false, null, r310.f324174e, r310.f324175f, 248), null, GalleryType.Image, null, null, null, null, null, new xy8.c(LocalMediaType.IMAGE, r103, com.larus.chat.gallery.impl.preview.datasource.n.c(r310.f324171b)), 0, 98275);
        goto L16
    }

    public final void N(boolean r100) {
        if (Intrinsics.areEqual(this.f324477r, Boolean.valueOf(r100)) == false) goto L5;
        return;
    L5:
        this.f324477r = Boolean.valueOf(r100);
        com.larus.gallery.api.w r101 = this.f343899e;
        if (r101 == null) goto L11;
        com.larus.gallery.api.s r102 = (com.larus.gallery.api.s) r101.AQ(Reflection.getOrCreateKotlinClass(com.larus.gallery.api.s.class));
        if (r102 == null) goto L12;
        r102.c();
        return;
    L12:
        return;
    }

    @Override // com.larus.gallery.api.t
    public final Fragment o(ViewGroup r100) {
        FLogger.f375446a.i("PreviewBottomProvider", "createFragment");
        return (Fragment) this.f324482w.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<String, String> z(CameraOutputContext r100) {
        xy8.d r101 = (xy8.d) this.f343898d;
        if (r101 != null) goto L5;
        return null;
    L5:
        List<OutputParam> r102 = r100.getOutputParamList();
        boolean r103 = false;
        if (r102 == null) goto L25;
        List<OutputParam> r104 = r102;
        if ((r104 instanceof Collection) == true) goto L10;
    L12:
        Iterator<T> r105 = r104.iterator();
    L14:
        if (r105.hasNext() == false) goto L11;
        OutputParam r106 = (OutputParam) r105.next();
        if (r106 != null) goto L18;
    L20:
        boolean r107 = false;
    L21:
        if (r107 == false) goto L14;
        boolean r108 = true;
    L23:
        if (r108 != true) goto L25;
        boolean r109 = true;
    L26:
        if (r109 == true) goto L28;
        return null;
    L28:
        LinkedHashMap r110 = new LinkedHashMap();
        if (r101.f565430e != GalleryType.Image) goto L31;
        r110.put("content_source_to_record", "chat_upload");
        r110.put("content_source_entrance_to_record", "chat");
    L31:
        SourceType r111 = r101.f565426a;
        if (r111 != SourceType.CREATION_CARD) goto L34;
    L35:
        xy8.e r112 = r101.f565438m;
        if (r112 == null) goto L39;
        String r113 = r112.f565445c;
        if (r113 == null) goto L39;
    L43:
        if (r112 == null) goto L46;
        String r114 = r112.f565447e;
        if (r114 == null) goto L46;
    L49:
        if (r113 != null) goto L51;
    L54:
        boolean r115 = true;
    L55:
        if (r115 == true) goto L57;
        r110.put("pic_source_message_id", r113);
    L57:
        if (r114 != null) goto L59;
    L60:
        r103 = true;
    L61:
        if (r103 == true) goto L64;
        r110.put("source_creation_task_id", r114);
    L64:
        if ((!r110.isEmpty()) == true) goto L66;
        return null;
    L66:
        return r110;
    L59:
        if (r114.length() != 0) goto L61;
    L51:
        if (r113.length() == 0) goto L54;
        r115 = false;
    L46:
        if (r112 == null) goto L48;
        r114 = r112.f565443a;
        goto L49
    L48:
        r114 = null;
    L39:
        xy8.f r116 = r101.f565437l;
        if (r116 == null) goto L42;
        r113 = r116.f565454a;
        goto L43
    L42:
        r113 = null;
        goto L43
    L34:
        if (r111 != SourceType.CREATION_RECORD) goto L64;
    L18:
        if (r106.isFromAlbum() == true) goto L20;
        r107 = true;
    L11:
        r108 = false;
        goto L23
    L10:
        if (r104.isEmpty() == false) goto L12;
    L25:
        r109 = false;
        goto L26
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [T, java.lang.Object, xy8.d] */
    @Override // com.larus.gallery.api.t
    public final void w(xy8.d r110, int r111) {
        final xy8.d r112 = r110;
        Intrinsics.checkNotNullParameter(r112, "data");
        this.f343898d = r112;
        this.f324470k.a(r112.f565427b);
        com.larus.chat.gallery.api.z r100 = this.f324472m;
        if (r100 == null) goto L5;
        r100.d(r112.f565427b);
    L5:
        SourceType r101 = r112.f565426a;
        if (r101 != SourceType.ALBUM) goto L8;
    L15:
        boolean r102 = true;
    L17:
        if (r102 == true) goto L45;
        final com.larus.chat.gallery.impl.preview.provider.c r103 = (com.larus.chat.gallery.impl.preview.provider.c) this.f324481v.getValue();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r112, "data");
        if (r112.f565441p != null) goto L21;
        boolean r113 = false;
    L40:
        if (r113 == false) goto L45;
        com.larus.chat.gallery.providers.input.a r114 = (com.larus.chat.gallery.providers.input.a) s1a.a.g(D()).getAbility(com.larus.chat.gallery.providers.input.a.class);
        if (r114 == null) goto L44;
        Intrinsics.checkNotNullParameter(r114, "$this$inputAbility");
        r114.qC();
        Unit r115 = Unit.INSTANCE;
        return;
    L44:
        FLogger.f375446a.e("PreviewBottomProvider", "[inputAbility] failed, cannot get GalleryInputAbility");
        return;
    L21:
        GalleryInputFragment r104 = r103.f324493a;
        com.larus.chat.gallery.impl.preview.toolbar.action.r.f324784a.getClass();
        Intrinsics.checkNotNullParameter(r112, "data");
        Intrinsics.checkNotNullParameter(r112, "data");
        xy8.c r116 = r112.f565441p;
        if (r116 != null) goto L24;
        boolean r117 = false;
    L39:
        r104.ga0(true, r117, new com.larus.chat.gallery.impl.preview.provider.b(r103, r112));
        r103.f324494b.invoke();
        r113 = true;
        goto L40
    L24:
        String r105 = r116.f565425c;
        if (r105 != null) goto L27;
    L31:
        r105 = com.larus.chat.gallery.impl.preview.toolbar.action.r.a(r116.f565424b);
    L32:
        if (r105 != null) goto L34;
    L37:
        boolean r118 = true;
    L38:
        r117 = !r118;
        goto L39
    L34:
        if (StringsKt.isBlank(r105) == true) goto L37;
        r118 = false;
        goto L38
    L27:
        if ((!StringsKt.isBlank(r105)) == true) goto L30;
        r105 = null;
    L30:
        if (r105 != null) goto L32;
    L45:
        GalleryInputFragment r119 = ((com.larus.chat.gallery.impl.preview.provider.c) this.f324481v.getValue()).f324493a;
        int r106 = GalleryInputFragment.D;
        r119.ga0(false, true, null);
        if (this.f324471l == true) goto L51;
        com.larus.chat.gallery.providers.input.a r120 = (com.larus.chat.gallery.providers.input.a) s1a.a.g(D()).getAbility(com.larus.chat.gallery.providers.input.a.class);
        if (r120 == null) goto L50;
        Intrinsics.checkNotNullParameter(r120, "$this$inputAbility");
        r120.qC();
        Unit r121 = Unit.INSTANCE;
        return;
    L50:
        FLogger.f375446a.e("PreviewBottomProvider", "[inputAbility] failed, cannot get GalleryInputAbility");
        return;
    L51:
        G(new s0(r112, this));
        K(r112);
        N(false);
        return;
    L8:
        if (r101 == SourceType.ATTACHMENT) goto L15;
        if (r101 == SourceType.CAMERA_RESULT) goto L15;
        if (r101 == SourceType.CLOUD_DRIVE) goto L15;
        r102 = false;
        goto L17
    }

    public final void y(FragmentActivity r110, IFlowCamera r111, xy8.d r112, String r113, Bitmap r114, xp9.i r210) {
        ArrayList r100 = new ArrayList();
        String r101 = null;
        if (r112 == null) goto L5;
        GalleryType r102 = r112.f565430e;
    L7:
        if (r102 != GalleryType.Image) goto L23;
        if (r113 != null) goto L10;
    L13:
        boolean r103 = true;
    L14:
        if (r103 == true) goto L23;
        OutputParam r104 = new OutputParam();
        r104.setResultType(OutputParam.ResultType.PHOTO);
        ImageParam r105 = new ImageParam();
        r105.setPath(r113);
        r105.setBitmap(r114);
        if (r112 == null) goto L20;
        xy8.b r106 = r112.f565428c;
        if (r106 == null) goto L20;
        boolean r107 = Intrinsics.areEqual(r106.f565417e, Boolean.TRUE);
    L21:
        r105.setAiCreation(r107);
        r104.setImageParam(r105);
        r104.setSelected(true);
        r104.setFromAlbum(false);
        r100.add(r104);
    L56:
        Iterator<Uri> r108 = r210.f564765a.iterator();
    L58:
        if (r108.hasNext() == false) goto L61;
        Uri r109 = r108.next();
        OutputParam r115 = new OutputParam();
        r115.setResultType(OutputParam.ResultType.PHOTO);
        ImageParam r116 = new ImageParam();
        r116.setPath(r109.toString());
        r115.setImageParam(r116);
        r115.setSelected(true);
        r115.setFromAlbum(true);
        r100.add(r115);
        goto L58
    L61:
        if (r100.isEmpty() == false) goto L64;
        FLogger.f375446a.e("PreviewBottomProvider", "launchMarkPageWithAlbumResult: outputParamList is empty");
        return;
    L64:
        PreviewCameraParamProvider r117 = this.f324467h;
        if (r112 == null) goto L69;
        r117.getClass();
        xy8.b r118 = r112.f565428c;
        if (r118 == null) goto L69;
        boolean r119 = Intrinsics.areEqual(r118.f565417e, Boolean.TRUE);
    L70:
        r117.f324320i = r119;
        PreviewCameraParamProvider r120 = this.f324467h;
        com.larus.chat.gallery.api.q r121 = E();
        if (r121 == null) goto L73;
        String r122 = r121.j();
    L74:
        AttachmentEditType r123 = AttachmentEditType.OTHER;
        if (r123 == AttachmentEditType.MARK) goto L77;
        boolean r124 = true;
    L78:
        InputParam r125 = r120.e(r123, r124, r122);
        if (this.f324468i.f324224g == false) goto L88;
        PreviewCameraParamProvider r126 = this.f324467h;
        com.larus.chat.gallery.api.q r127 = E();
        if (r112 != null) goto L83;
        return;
    L83:
        String r128 = r112.f565434i;
        if (r128 != null) goto L86;
        r128 = r112.f565427b;
    L86:
        r126.b(r125, r127, r112, SetsKt.setOf(r128));
    L88:
        if (this.f324468i.f324222e == false) goto L104;
        if (r112 == null) goto L91;
        GalleryType r129 = r112.f565430e;
    L93:
        if (r129 != GalleryType.Image) goto L104;
        xy8.b r130 = r112.f565428c;
        if (r130 == null) goto L104;
        String r131 = r130.f565416d;
        if (r131 == null) goto L104;
        if (r131.length() <= 0) goto L101;
        boolean r132 = true;
    L102:
        if (r132 == false) goto L104;
        r101 = r131;
        goto L104
    L101:
        r132 = false;
        goto L102
    L91:
        r129 = null;
    L104:
        if (r101 != null) goto L106;
    L109:
        boolean r133 = true;
    L110:
        if (r133 == true) goto L115;
        InputParamExtra r134 = r125.getExtra();
        if (r134 != null) goto L114;
        r134 = new InputParamExtra();
        r125.setExtra(r134);
    L114:
        r134.put(InputParamExtra.KEY_RAW_IMAGE_URI, r101);
        r125.setEnableOriginalImageDeferredEdit(true);
    L115:
        CameraOutputContext r135 = new CameraOutputContext();
        r135.setOutputParamList(r100);
        FLogger r136 = FLogger.f375446a;
        StringBuilder r137 = new StringBuilder("launchMarkPageWithAlbumResult: totalCount=");
        r137.append(r100.size());
        r137.append(", hasCurrentMedia=");
        OutputParam r138 = (OutputParam) CollectionsKt.firstOrNull(r100);
        if (r138 != null) goto L118;
    L120:
        boolean r139 = false;
    L121:
        r137.append(r139);
        r137.append(", albumCount=");
        r137.append(r210.f564765a.size());
        r136.i("PreviewBottomProvider", r137.toString());
        if (this.f324469j.c(ChildResultMode.ALBUM_APPEND) == true) goto L125;
        this.f324467h.k();
        r136.e("PreviewBottomProvider", "launchMarkPageWithAlbumResult: pending result unavailable");
        return;
    L125:
        J();
        this.f324465f.c(false);
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L128
        r111.j(r110, r125, r135);     // Catch: Throwable -> L128
        Object r141 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L128
    L130:
        Throwable r142 = Result.m9452exceptionOrNullimpl(r141);
        if (r142 == null) goto L137;
        this.f324465f.c(true);
        this.f324467h.k();
        this.f324469j.g();
        FLogger.f375446a.e("PreviewBottomProvider", "launchMarkPageWithAlbumResult: result page launch failed", r142);
        return;
    L137:
        return;
    L128:
        th = move-exception;
        Result.Companion r143 = Result.Companion;
        r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L130
    L118:
        if (r138.isFromAlbum() == true) goto L120;
        r139 = true;
        goto L121
    L106:
        if (r101.length() == 0) goto L109;
        r133 = false;
        goto L110
    L77:
        r124 = false;
        goto L78
    L73:
        r122 = null;
    L69:
        r119 = false;
    L20:
        r107 = false;
        goto L21
    L10:
        if (r113.length() == 0) goto L13;
        r103 = false;
    L23:
        if (this.f324468i.f324220c == false) goto L56;
        if (r112 == null) goto L26;
        GalleryType r144 = r112.f565430e;
    L28:
        if (r144 != GalleryType.Video) goto L56;
        xy8.g r145 = r112.f565429d;
        if (r145 == null) goto L33;
        String r146 = r145.f565465f;
        if (r146 == null) goto L33;
    L36:
        if (r146 != null) goto L38;
    L41:
        boolean r147 = true;
    L42:
        if (r147 == true) goto L56;
        OutputParam r148 = new OutputParam();
        r148.setResultType(OutputParam.ResultType.VIDEO);
        VideoParam r149 = new VideoParam();
        r149.setPath(r146);
        xy8.g r150 = r112.f565429d;
        if (r150 == null) goto L46;
        int r151 = r150.f565469j;
    L47:
        r149.setWidth(r151);
        xy8.g r152 = r112.f565429d;
        if (r152 == null) goto L50;
        int r153 = r152.f565470k;
    L51:
        r149.setHeight(r153);
        xy8.g r154 = r112.f565429d;
        if (r154 == null) goto L54;
        double r155 = r154.f565471l;
    L55:
        r149.setDuration((long) (r155 * ((double) 1000)));
        r148.setVideoParam(r149);
        r148.setSelected(true);
        r148.setFromAlbum(false);
        r100.add(r148);
        goto L56
    L54:
        r155 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L55
    L50:
        r153 = 0;
        goto L51
    L46:
        r151 = 0;
        goto L47
    L38:
        if (r146.length() == 0) goto L41;
        r147 = false;
    L33:
        if (r145 == null) goto L35;
        r146 = r145.f565461b;
        goto L36
    L35:
        r146 = null;
        goto L36
    L26:
        r144 = null;
        goto L28
    L5:
        r102 = null;
        goto L7
    }

    public PreviewBottomProvider(com.larus.chat.gallery.impl.preview.input.e0 r100, Long r101, PreviewCameraParamProvider r102, com.larus.chat.gallery.impl.preview.c r103, com.larus.chat.gallery.impl.preview.input.d0 r104, r r105, boolean r106, com.larus.chat.gallery.api.z r110, boolean r111, int r112) {
        if ((r112 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r112 & 64) == 0) goto L9;
        r106 = true;
    L9:
        if ((r112 & 128) == 0) goto L12;
        r110 = null;
    L12:
        if ((r112 & 256) == 0) goto L14;
        r111 = false;
    L14:
        Intrinsics.checkNotNullParameter(r100, "sendStrategy");
        Intrinsics.checkNotNullParameter(r102, "paramProvider");
        Intrinsics.checkNotNullParameter(r103, "albumFlowPolicy");
        Intrinsics.checkNotNullParameter(r104, "sessionController");
        Intrinsics.checkNotNullParameter(r105, "bottomChrome");
        this.f324465f = r100;
        this.f324466g = r101;
        this.f324467h = r102;
        this.f324468i = r103;
        this.f324469j = r104;
        this.f324470k = r105;
        this.f324471l = r106;
        this.f324472m = r110;
        this.f324473n = r111;
        this.f324474o = new AlbumHelper();
        this.f324479t = LazyKt.lazy(new h0(this));
        this.f324480u = LazyKt.lazy(new i0(this));
        this.f324481v = LazyKt.lazy(LazyThreadSafetyMode.NONE, new j0(this));
        this.f324482w = LazyKt.lazy(new l0(this));
    }
}
