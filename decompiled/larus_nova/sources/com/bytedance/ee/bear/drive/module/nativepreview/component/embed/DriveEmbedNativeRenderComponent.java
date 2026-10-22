package com.bytedance.ee.bear.drive.module.nativepreview.component.embed;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.WikiNavInfo;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceThirdPartyOpenEntity;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.SaveToLocalMenuV2;
import com.bytedance.ee.bear.middleground_permission_export.model.audit.HostDocumentInfo;
import com.bytedance.ee.bear.secret.PermissionControl;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.bear.widgets.universedesign.SpaceLoadingImage;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larksuite.component.universe_design.progress.UDProgress;
import com.larus.nova.R;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import j85.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class DriveEmbedNativeRenderComponent extends js5.a implements k85.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f224489o = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<FragmentActivity> f224490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pxb.a f224491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f224492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f224493e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f224494f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f224495g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public UDProgress f224496h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f224497i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SpaceLoadingImage f224498j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SpaceThirdPartyOpenEntity f224499k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final EmbedComponentInnerFrameLayout f224500l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f224501m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f224502n;

    public static final class a {
    }

    static {
    }

    private final FragmentActivity getActivity() {
        return this.f224490b.get();
    }

    @Override // js5.b
    public final void a() {
        tt5.a.b("DriveEmbedNativeRenderComponent", "onUpdateView DriveEmbedNativeRenderComponent - " + hashCode());
    }

    public final String f() {
        StringBuilder r100 = new StringBuilder();
        js5.e r101 = getContext();
        String r102 = null;
        if ((r101 instanceof ks5.b) == false) goto L5;
        ks5.b r103 = (ks5.b) r101;
    L6:
        if (r103 == null) goto L8;
        r102 = r103.f505918c;
    L8:
        r100.append(r102);
        r100.append('_');
        r100.append(String.valueOf(this.f224491c.getView().hashCode()));
        r100.append('_');
        return r100.toString();
    L5:
        r103 = null;
        goto L6
    }

    public final String i() {
        if (this.f224494f == true) goto L7;
        tt5.a.h("DriveEmbedNativeRenderComponent", "getKey=" + f() + du5.b.g(this.f224493e) + du5.b.g(this.f224495g));
        return f() + this.f224493e + this.f224495g;
    L7:
        return String.valueOf(this.f224491c.getView().hashCode()) + '_' + this.f224495g + '_' + this.f224493e;
    }

    @Override // js5.b
    public final void onRemove() {
        StringBuilder r100 = new StringBuilder("onRemove ");
        r100.append(f());
        r100.append(" - ");
        r100.append(hashCode());
        r100.append(" - ");
        SpaceThirdPartyOpenEntity r101 = this.f224499k;
        d r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getFileExt();
    L6:
        r100.append(r103);
        tt5.a.h("DriveEmbedNativeRenderComponent", r100.toString());
        if (TextUtils.isEmpty(this.f224493e) == false) goto L9;
        return;
    L9:
        e r104 = this.f224492d;
        if (r104 == null) goto L12;
        r104.a(i(), false);
    L12:
        com.bytedance.ee.bear.drive.module.nativepreview.component.embed.a r105 = (com.bytedance.ee.bear.drive.module.nativepreview.component.embed.a) this.f224502n.getValue();
        if ((r105 instanceof d) == false) goto L15;
        r102 = (d) r105;
    L15:
        if (r102 == null) goto L18;
        tt5.a.h("EmbedSurfaceViewHolder", "callbackDestroy called");
        return;
    L18:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // k85.a
    public final boolean getNeedRelease() {
        return this.f224501m;
    }

    public static HostDocumentInfo h(JSONObject r410) {
        if (r410 != null) goto L6;
        tt5.a.k("DriveEmbedNativeRenderComponent", "getDocumentInfo: data is null");     // Catch: Exception -> L15
        return null;
    L6:
        JSONObject r100 = JSONObjectProtectorUtils.getJSONObject(r410, "document");     // Catch: Exception -> L15
        if (r100 != null) goto L10;
        tt5.a.k("DriveEmbedNativeRenderComponent", "getDocumentInfo: docJson is null");     // Catch: Exception -> L15
        return null;
    L10:
        tt5.a.h("DriveEmbedNativeRenderComponent", "getDocumentInfo: docJson = " + r100);     // Catch: Exception -> L15
        HostDocumentInfo r101 = new HostDocumentInfo();     // Catch: Exception -> L15
        DocMetaInfo r102 = new DocMetaInfo(null, false, null, null, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -1, 63, null);     // Catch: Exception -> L15
        String r103 = r100.optString("ID");     // Catch: Exception -> L15
        int r104 = r100.optInt("Type");     // Catch: Exception -> L15
        String r105 = r100.optString("Title");     // Catch: Exception -> L15
        JSONObject r106 = JSONObjectProtectorUtils.getJSONObject(r100, "Owner");     // Catch: Exception -> L15
        String r107 = r106.optString("UserID");     // Catch: Exception -> L15
        r106.optString("UserName");     // Catch: Exception -> L15
        String r108 = r100.optString("TenantID");     // Catch: Exception -> L15
        JSONObject r109 = JSONObjectProtectorUtils.getJSONObject(r100, "DocSecLabel");     // Catch: Exception -> L15
        String r110 = r109.optString("LabelID");     // Catch: Exception -> L15
        String r111 = r109.optString("LabelNameCN");     // Catch: Exception -> L15
        r101.setDocToken(r103);     // Catch: Exception -> L15
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L15
        r101.setObjToken(r103);     // Catch: Exception -> L15
        r101.setEntityType(Integer.valueOf(r104));     // Catch: Exception -> L15
        r101.setOwnerUid(r107);     // Catch: Exception -> L15
        r101.setTenantID(r108);     // Catch: Exception -> L15
        r101.setTitle(r105);     // Catch: Exception -> L15
        Intrinsics.checkNotNull(r105);     // Catch: Exception -> L15
        r102.setTitle(r105);     // Catch: Exception -> L15
        Intrinsics.checkNotNull(r110);     // Catch: Exception -> L15
        Intrinsics.checkNotNull(r111);     // Catch: Exception -> L15
        r102.setSecretLevel(new SecretLevel(r110, r111, "", 0, false, "", "", new PermissionControl(0, 0, 0, 0, false, 0, 0, false, 0, 0, 0, 0, UnixStat.PERM_MASK, null), false, true, null, null, null, null, null, null, null, 130048, null));     // Catch: Exception -> L15
        String r112 = r100.optString("WikiToken");     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r112) == true) goto L13;
        Intrinsics.checkNotNull(r112);     // Catch: Exception -> L15
        r101.setWikiInfo(new WikiNavInfo(true, r112));     // Catch: Exception -> L15
    L13:
        r101.setDocMetaInfo(r102);     // Catch: Exception -> L15
        return r101;
    L15:
        e = move-exception;
        tt5.a.e("DriveEmbedNativeRenderComponent", "get document error", e, false);
        return null;
    }

    @Override // js5.b
    public final EmbedComponentInnerFrameLayout d(JSONObject r100) {
        tt5.a.h("DriveEmbedNativeRenderComponent", "onCreateView " + f());
        SpaceThirdPartyOpenEntity r101 = g(r100, "samerender");
        if (r101 == null) goto L5;
        this.f224499k = r101;
    L5:
        com.bytedance.ee.bear.drive.report.a r102 = o75.b.a().Tb();
        js5.e r103 = getContext();
        String r104 = null;
        if ((r103 instanceof ks5.b) == false) goto L8;
        ks5.b r105 = (ks5.b) r103;
    L9:
        if (r105 == null) goto L11;
        String r106 = r105.f505918c;
    L12:
        js5.e r107 = getContext();
        if ((r107 instanceof ks5.b) == false) goto L15;
        ks5.b r108 = (ks5.b) r107;
    L16:
        if (r108 == null) goto L18;
        r104 = r108.f505919d;
    L18:
        r102.p("render_view_on_create", r106, r104, "DEC0", null, null);
        return this.f224500l;
    L15:
        r108 = null;
        goto L16
    L11:
        r106 = null;
        goto L12
    L8:
        r105 = null;
        goto L9
    }

    public final void j(boolean r100) {
        tt5.a.h("DriveEmbedNativeRenderComponent", f() + " -- performAction handleBlockShow: " + r100);
        EmbedComponentInnerFrameLayout r101 = this.f224500l;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 4;
        goto L6
    }

    public DriveEmbedNativeRenderComponent(WeakReference<FragmentActivity> r100, pxb.a r101) {
        Intrinsics.checkNotNullParameter(r100, "mActivity");
        Intrinsics.checkNotNullParameter(r101, "webView");
        this.f224490b = r100;
        this.f224491c = r101;
        Integer.toHexString(hashCode());
        this.f224501m = true;
        this.f224502n = LazyKt.lazy(new DriveEmbedNativeRenderComponent$coreSurfaceViewHolder$2(this));
        this.f224492d = new e();
        tt5.a.h("DriveEmbedNativeRenderComponent", "init function: DriveEmbedNativeRenderComponent - " + hashCode() + ", " + f());
        FragmentActivity r102 = r100.get();
        Intrinsics.checkNotNull(r102);
        EmbedComponentInnerFrameLayout r103 = new EmbedComponentInnerFrameLayout(r102);
        r103.setRoundPath((float) y9c.d.a(6));
        this.f224500l = r103;
        n85.b r104 = n85.b.a.f518330a;
        String r105 = String.valueOf(r101.getView().hashCode());
        String r106 = String.valueOf(hashCode());
        CopyOnWriteArraySet r107 = (CopyOnWriteArraySet) ((ConcurrentHashMap) r104.f518329k).get(r105);
        if (r107 == null) goto L5;
    L13:
        r107.add(r106);
        return;
    L5:
        monitor-enter(n85.b.class);
        if (r107 == null) goto L15;
    L8:
        monitor-exit(n85.b.class);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L15:
        r107 = new CopyOnWriteArraySet();     // Catch: Throwable -> L10
        ((ConcurrentHashMap) r104.f518329k).put(r105, r107);     // Catch: Throwable -> L10
        goto L8
    }

    public final SpaceThirdPartyOpenEntity g(JSONObject r110, String r111) {
        if (r110 != null) goto L21;
        String r100 = null;
    L8:
        if (r110 != null) goto L10;
    L17:
        tt5.a.b("DriveEmbedNativeRenderComponent", "getData fileId is null");     // Catch: Throwable -> L5
        return null;
    L10:
        if (TextUtils.isEmpty(r100) == true) goto L17;
        this.f224493e = r100;     // Catch: Throwable -> L5
        this.f224494f = Intrinsics.areEqual("1", r110.optString("in-vc"));     // Catch: Throwable -> L5
        this.f224495g = r110.optString("mount-node-token");     // Catch: Throwable -> L5
        SpaceThirdPartyOpenEntity r101 = new SpaceThirdPartyOpenEntity(r110.optString("app-id"), r100, r110.optString("file-name"));     // Catch: Throwable -> L5
        r101.setMountNodeToken(this.f224495g);     // Catch: Throwable -> L5
        r101.setInVc(this.f224494f);     // Catch: Throwable -> L5
        r101.setApiExtra(r110.optString("auth-extra"));     // Catch: Throwable -> L5
        r101.setMountPoint(r110.optString("mount-point"));     // Catch: Throwable -> L5
        r101.setPreviewFrom(r110.optString("preview-from"));     // Catch: Throwable -> L5
        r101.setFileExt(r110.optString("file-type"));     // Catch: Throwable -> L5
        r101.setPreviewType(3);     // Catch: Throwable -> L5
        r101.setDownloadFrom("from_docs_attachment_download");     // Catch: Throwable -> L5
        r101.setDocToken(r110.optString("doc-token"));     // Catch: Throwable -> L5
        String r102 = r110.optString("src-obj-token");     // Catch: Throwable -> L5
        String r103 = r110.optString("encrypt-id");     // Catch: Throwable -> L5
        if (TextUtils.isEmpty(r102) == true) goto L15;
        r101.setDocToken(r102);     // Catch: Throwable -> L5
        r101.setEncryptId(r103);     // Catch: Throwable -> L5
        r101.setInBlock(true);     // Catch: Throwable -> L5
    L15:
        r101.setHostType(r110.optInt("host-type"));     // Catch: Throwable -> L5
        ArrayList<BaseMoreMenuAction> r104 = new ArrayList();     // Catch: Throwable -> L5
        r104.add(new SaveToLocalMenuV2());     // Catch: Throwable -> L5
        r101.setMoreMenuActions(r104);     // Catch: Throwable -> L5
        r101.setHostDocumentInfo(h(r110));     // Catch: Throwable -> L5
        tt5.a.h("DriveEmbedNativeRenderComponent", "really create " + f() + ", " + du5.b.g(this.f224495g) + ", " + r111 + ", " + du5.b.g(r100));     // Catch: Throwable -> L5
        return r101;
    L21:
        r100 = r110.optString("file-id");     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        tt5.a.d("DriveEmbedNativeRenderComponent", "getData fail: " + th);
        return null;
    }

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
    @Override // js5.b
    public final void c(String r210, JSONObject r211, js5.c r212) {
        Intrinsics.checkNotNullParameter(r210, "eventName");
        Intrinsics.checkNotNullParameter(r212, "callback");
        tt5.a.h("DriveEmbedNativeRenderComponent", f() + " -- performAction eventName=" + r210);
        int r100 = 0;
        r100 = 0;
        boolean r101 = false;
        r101 = false;
        String r110 = null;
        switch(r210.hashCode()) {
            case -2055344356: goto L112;
            case -1843867306: goto L89;
            case -1456650153: goto L60;
            case 414896384: goto L48;
            case 677592936: goto L6;
            default: goto L132;
        };
    L132:
        return;
    L6:
        if (r210.equals("performPreload") == false) goto L133;
        StringBuilder r102 = new StringBuilder();
        r102.append(f());
        r102.append(" -- performAction PERFORM_PRELOAD ");
        SpaceThirdPartyOpenEntity r103 = this.f224499k;
        if (r103 == null) goto L11;
        String r104 = r103.getFileExt();
    L12:
        r102.append(r104);
        tt5.a.b("DriveEmbedNativeRenderComponent", r102.toString());
        j(true);
        EmbedComponentInnerFrameLayout r105 = this.f224500l;
        FragmentActivity r106 = getActivity();
        if (r106 != null) goto L16;
        tt5.a.d("DriveEmbedNativeRenderComponent", "handleLoadingUi activity is null");
    L28:
        HashMap r107 = new HashMap();
        SpaceThirdPartyOpenEntity r108 = this.f224499k;
        if (r108 != null) goto L31;
        r108 = g(r211, "PERFORM_PRELOAD");
    L31:
        if (r108 == null) goto L33;
        this.f224499k = r108;
        r107.put("file_token", du5.b.g(r108.getFileId()));
        r107.put("file_type", r108.getFileExt());
    L33:
        com.bytedance.ee.bear.drive.report.a r111 = o75.b.a().Tb();
        js5.e r109 = getContext();
        if ((r109 instanceof ks5.b) == false) goto L36;
        ks5.b r112 = (ks5.b) r109;
    L37:
        if (r112 == null) goto L39;
        String r113 = r112.f505918c;
    L40:
        js5.e r114 = getContext();
        if ((r114 instanceof ks5.b) == false) goto L43;
        ks5.b r115 = (ks5.b) r114;
    L44:
        if (r115 == null) goto L46;
        r110 = r115.f505919d;
    L46:
        r111.p("drive_preload", r113, r110, "DEC0", null, r107);
        js5.c.a.a(r212);
        return;
    L43:
        r115 = null;
        goto L44
    L39:
        r113 = null;
        goto L40
    L36:
        r112 = null;
        goto L37
    L16:
        if (r105 == null) goto L23;
        int r116 = r105.getChildCount();
        int r117 = 0;
    L18:
        if (r117 >= r116) goto L23;
        if (Intrinsics.areEqual("loading", r105.getChildAt(r117).getTag()) == true) goto L21;
        r117 = r117 + 1;
        goto L18
    L21:
        r101 = true;
    L23:
        tt5.a.h("DriveEmbedNativeRenderComponent", f() + " -- handleLoadingUi " + r101);
        if (r101 == true) goto L28;
        FrameLayout r118 = new FrameLayout(r106);
        LayoutInflater.from(r106).inflate(R.layout.drive_loading_progress, r118);
        r118.setTag("loadingRoot");
        r118.setBackgroundDrawable(r106.getResources().getDrawable(R.drawable.drive_bg_file_block_loading_bg));
        this.f224498j = (SpaceLoadingImage) r118.findViewById(R.id.image_loading);
        this.f224496h = (UDProgress) r118.findViewById(R.id.progress);
        r118.setTag("loading");
        if (r105 == null) goto L28;
        r105.addView(r118, new FrameLayout.LayoutParams(-1, -1));
        goto L28
    L11:
        r104 = null;
        goto L12
    L133:
        return;
    L48:
        if (r210.equals("onCreateView") == false) goto L134;
        SpaceThirdPartyOpenEntity r119 = this.f224499k;     // Catch: Throwable -> L57
        if (r119 != null) goto L53;
        r119 = g(r211, "perforam_action");     // Catch: Throwable -> L57
    L53:
        if (r119 == null) goto L55;
        r119.setHostDocumentInfo(h(r211));     // Catch: Throwable -> L57
        this.f224499k = r119;     // Catch: Throwable -> L57
        tt5.a.b("DriveEmbedNativeRenderComponent", f() + " -- performAction ON_CREATE " + r119.getFileExt());     // Catch: Throwable -> L57
    L55:
        js5.c.a.a(r212);     // Catch: Throwable -> L57
        return;
    L57:
        th = move-exception;
        tt5.a.d("DriveEmbedNativeRenderComponent", f() + " -- performAction ON_CREATE failed: " + th);
        return;
    L134:
        return;
    L60:
        if (r210.equals("performRender") == false) goto L136;
        j(true);
        if (this.f224499k != null) goto L65;
        this.f224499k = g(r211, "PERFORM_RENDER");
    L65:
        e r120 = this.f224492d;
        if (r120 == null) goto L68;
        r120.b(getActivity(), this.f224500l, this.f224499k, i(), this);
    L68:
        UDProgress r121 = this.f224496h;
        if (r121 == null) goto L72;
        r121.setVisibility(8);
    L72:
        if (TextUtils.isEmpty(this.f224493e) == true) goto L76;
        SpaceLoadingImage r122 = this.f224498j;
        if (r122 == null) goto L76;
        r122.stop();
        r122.setVisibility(8);
    L76:
        StringBuilder r123 = new StringBuilder();
        r123.append(f());
        r123.append(" -- performAction PERFORM_RENDER ");
        SpaceThirdPartyOpenEntity r124 = this.f224499k;
        if (r124 == null) goto L79;
        r110 = r124.getFileExt();
    L79:
        r123.append(r110);
        tt5.a.b("DriveEmbedNativeRenderComponent", r123.toString());
        if (TextUtils.isEmpty(this.f224493e) == true) goto L87;
        n85.b r125 = n85.b.a.f518330a;
        String r126 = this.f224493e;
        String r127 = i();
        r125.getClass();
        if (TextUtils.isEmpty(r126) == true) goto L87;
        if (TextUtils.isEmpty(r127) == true) goto L87;
        ((ConcurrentHashMap) r125.f518328j).put(r126, r127);
    L87:
        js5.c.a.a(r212);
        return;
    L136:
        return;
    L89:
        if (r210.equals("progressUpdate") == true) goto L92;
        return;
    L92:
        if (this.f224497i == true) goto L100;
        UDProgress r128 = this.f224496h;
        if (r128 == null) goto L96;
        r128.setVisibility(0);
    L96:
        SpaceLoadingImage r129 = this.f224498j;
        if (r129 == null) goto L99;
        r129.setVisibility(8);
    L99:
        this.f224497i = true;
    L100:
        UDProgress r130 = this.f224496h;
        if (r130 == null) goto L107;
        if (r211 != null) goto L124;
    L106:
        r130.setProgress(r100);
        goto L107
    L124:
        r100 = JSONObjectProtectorUtils.getInt(r211, "progress");     // Catch: Exception -> L105
    L105:
        tt5.a.d("DriveEmbedNativeRenderComponent", "get progress error");
    L107:
        StringBuilder r131 = new StringBuilder();
        r131.append(f());
        r131.append(" -- performAction PROGRESS_UPDATE ");
        SpaceThirdPartyOpenEntity r132 = this.f224499k;
        if (r132 == null) goto L110;
        r110 = r132.getFileExt();
    L110:
        r131.append(r110);
        tt5.a.b("DriveEmbedNativeRenderComponent", r131.toString());
        js5.c.a.a(r212);
        return;
    L112:
        if (r210.equals("performMoveOut") == false) goto L138;
        j(false);
        e r133 = this.f224492d;
        if (r133 == null) goto L117;
        r133.a(i(), true);
    L117:
        StringBuilder r134 = new StringBuilder();
        r134.append(f());
        r134.append(" -- performAction MOVE_OUT ");
        SpaceThirdPartyOpenEntity r135 = this.f224499k;
        if (r135 == null) goto L120;
        r110 = r135.getFileExt();
    L120:
        r134.append(r110);
        tt5.a.b("DriveEmbedNativeRenderComponent", r134.toString());
        js5.c.a.a(r212);
        return;
    }
}
