package com.bytedance.ee.bear.drive.module.nativepreview.component.embed;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.WikiNavInfo;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceThirdPartyOpenEntity;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.SaveToLocalMenuV2;
import com.bytedance.ee.bear.middleground_permission_export.model.audit.HostDocumentInfo;
import com.bytedance.ee.bear.secret.PermissionControl;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.bear.widgets.universedesign.SpaceLoadingImage;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larksuite.component.universe_design.progress.UDProgress;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveEmbedNativeRenderComponent extends js5.a implements k85.a {
    public static final /* synthetic */ int o = 0;
    public final WeakReference<FragmentActivity> b;
    public final pxb.a c;
    public final e d;
    public String e;
    public boolean f;
    public String g;
    public UDProgress h;
    public boolean i;
    public SpaceLoadingImage j;
    public SpaceThirdPartyOpenEntity k;
    public final EmbedComponentInnerFrameLayout l;
    public final boolean m;
    public final Lazy n;

    public static final class a {
    }

    static {
    }

    private final FragmentActivity getActivity() {
        return this.b.get();
    }

    public final void a() {
        tt5.a.b("DriveEmbedNativeRenderComponent", "onUpdateView DriveEmbedNativeRenderComponent - " + hashCode());
    }

    public final String f() {
        StringBuilder r0 = new StringBuilder();
        ks5.b r1 = getContext();
        String r3 = null;
        if ((r1 instanceof ks5.b) == false) goto L5;
        ks5.b r2 = r1;
    L6:
        if (r2 == null) goto L8;
        r3 = r2.c;
    L8:
        r0.append(r3);
        r0.append('_');
        r0.append(String.valueOf(this.c.getView().hashCode()));
        r0.append('_');
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public final String i() {
        if (this.f == true) goto L7;
        tt5.a.h("DriveEmbedNativeRenderComponent", "getKey=" + f() + du5.b.g(this.e) + du5.b.g(this.g));
        return f() + this.e + this.g;
    L7:
        return String.valueOf(this.c.getView().hashCode()) + '_' + this.g + '_' + this.e;
    }

    public final void onRemove() {
        StringBuilder r0 = new StringBuilder("onRemove ");
        r0.append(f());
        r0.append(" - ");
        r0.append(hashCode());
        r0.append(" - ");
        SpaceThirdPartyOpenEntity r1 = this.k;
        d r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getFileExt();
    L6:
        r0.append(r3);
        tt5.a.h("DriveEmbedNativeRenderComponent", r0.toString());
        if (TextUtils.isEmpty(this.e) == false) goto L9;
        return;
    L9:
        e r4 = this.d;
        if (r4 == null) goto L12;
        r4.a(i(), false);
    L12:
        com.bytedance.ee.bear.drive.module.nativepreview.component.embed.a r5 = (com.bytedance.ee.bear.drive.module.nativepreview.component.embed.a) this.n.getValue();
        if ((r5 instanceof d) == false) goto L15;
        r2 = (d) r5;
    L15:
        if (r2 == null) goto L18;
        tt5.a.h("EmbedSurfaceViewHolder", "callbackDestroy called");
        return;
    L18:
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // k85.a
    public final boolean getNeedRelease() {
        return this.m;
    }

    public static HostDocumentInfo h(JSONObject r47) {
        if (r47 != null) goto L6;
        tt5.a.k("DriveEmbedNativeRenderComponent", "getDocumentInfo: data is null");     // Catch: Exception -> L15
        return null;
    L6:
        JSONObject r0 = JSONObjectProtectorUtils.getJSONObject(r47, "document");     // Catch: Exception -> L15
        if (r0 != null) goto L10;
        tt5.a.k("DriveEmbedNativeRenderComponent", "getDocumentInfo: docJson is null");     // Catch: Exception -> L15
        return null;
    L10:
        tt5.a.h("DriveEmbedNativeRenderComponent", "getDocumentInfo: docJson = " + r0);     // Catch: Exception -> L15
        HostDocumentInfo r1 = new HostDocumentInfo();     // Catch: Exception -> L15
        DocMetaInfo r4 = new DocMetaInfo(null, false, null, null, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -1, 63, null);     // Catch: Exception -> L15
        String r5 = r0.optString("ID");     // Catch: Exception -> L15
        int r6 = r0.optInt("Type");     // Catch: Exception -> L15
        String r7 = r0.optString("Title");     // Catch: Exception -> L15
        JSONObject r8 = JSONObjectProtectorUtils.getJSONObject(r0, "Owner");     // Catch: Exception -> L15
        String r9 = r8.optString("UserID");     // Catch: Exception -> L15
        r8.optString("UserName");     // Catch: Exception -> L15
        String r10 = r0.optString("TenantID");     // Catch: Exception -> L15
        JSONObject r11 = JSONObjectProtectorUtils.getJSONObject(r0, "DocSecLabel");     // Catch: Exception -> L15
        String r12 = r11.optString("LabelID");     // Catch: Exception -> L15
        String r13 = r11.optString("LabelNameCN");     // Catch: Exception -> L15
        r1.setDocToken(r5);     // Catch: Exception -> L15
        Intrinsics.checkNotNull(r5);     // Catch: Exception -> L15
        r1.setObjToken(r5);     // Catch: Exception -> L15
        r1.setEntityType(Integer.valueOf(r6));     // Catch: Exception -> L15
        r1.setOwnerUid(r9);     // Catch: Exception -> L15
        r1.setTenantID(r10);     // Catch: Exception -> L15
        r1.setTitle(r7);     // Catch: Exception -> L15
        Intrinsics.checkNotNull(r7);     // Catch: Exception -> L15
        r4.setTitle(r7);     // Catch: Exception -> L15
        Intrinsics.checkNotNull(r12);     // Catch: Exception -> L15
        Intrinsics.checkNotNull(r13);     // Catch: Exception -> L15
        r4.setSecretLevel(new SecretLevel(r12, r13, "", 0, false, "", "", new PermissionControl(0, 0, 0, 0, false, 0, 0, false, 0, 0, 0, 0, 4095, null), false, true, null, null, null, null, null, null, null, 130048, null));     // Catch: Exception -> L15
        String r2 = r0.optString("WikiToken");     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r2) == true) goto L13;
        Intrinsics.checkNotNull(r2);     // Catch: Exception -> L15
        r1.setWikiInfo(new WikiNavInfo(true, r2));     // Catch: Exception -> L15
    L13:
        r1.setDocMetaInfo(r4);     // Catch: Exception -> L15
        return r1;
    L15:
        e = move-exception;
        tt5.a.e("DriveEmbedNativeRenderComponent", "get document error", e, false);
        return null;
    }

    public final EmbedComponentInnerFrameLayout d(JSONObject r8) {
        tt5.a.h("DriveEmbedNativeRenderComponent", "onCreateView " + f());
        SpaceThirdPartyOpenEntity r9 = g(r8, "samerender");
        if (r9 == null) goto L5;
        this.k = r9;
    L5:
        com.bytedance.ee.bear.drive.report.a r0 = o75.b.a().Tb();
        ks5.b r10 = getContext();
        String r3 = null;
        if ((r10 instanceof ks5.b) == false) goto L8;
        ks5.b r11 = r10;
    L9:
        if (r11 == null) goto L11;
        String r2 = r11.c;
    L12:
        ks5.b r12 = getContext();
        if ((r12 instanceof ks5.b) == false) goto L15;
        ks5.b r13 = r12;
    L16:
        if (r13 == null) goto L18;
        r3 = r13.d;
    L18:
        r0.p("render_view_on_create", r2, r3, "DEC0", null, null);
        return this.l;
    L15:
        r13 = null;
        goto L16
    L11:
        r2 = null;
        goto L12
    L8:
        r11 = null;
        goto L9
    }

    public final void j(boolean r3) {
        tt5.a.h("DriveEmbedNativeRenderComponent", f() + " -- performAction handleBlockShow: " + r3);
        EmbedComponentInnerFrameLayout r0 = this.l;
        if (r3 == false) goto L5;
        int r4 = 0;
    L6:
        r0.setVisibility(r4);
        return;
    L5:
        r4 = 4;
        goto L6
    }

    public DriveEmbedNativeRenderComponent(WeakReference<FragmentActivity> r4, pxb.a r5) {
        Intrinsics.checkNotNullParameter(r4, "mActivity");
        Intrinsics.checkNotNullParameter(r5, "webView");
        this.b = r4;
        this.c = r5;
        Integer.toHexString(hashCode());
        this.m = true;
        this.n = LazyKt.lazy(new DriveEmbedNativeRenderComponent$coreSurfaceViewHolder$2(this));
        this.d = new e();
        tt5.a.h("DriveEmbedNativeRenderComponent", "init function: DriveEmbedNativeRenderComponent - " + hashCode() + ", " + f());
        Context r6 = r4.get();
        Intrinsics.checkNotNull(r6);
        EmbedComponentInnerFrameLayout r0 = new EmbedComponentInnerFrameLayout(r6);
        r0.setRoundPath((float) y9c.d.a(6));
        this.l = r0;
        n85.b r7 = n85.b.a.a;
        String r8 = String.valueOf(r5.getView().hashCode());
        String r1 = String.valueOf(hashCode());
        CopyOnWriteArraySet r2 = (CopyOnWriteArraySet) ((ConcurrentHashMap) r7.k).get(r8);
        if (r2 == null) goto L5;
    L13:
        r2.add(r1);
        return;
    L5:
        monitor-enter(n85.b.class);
        if (r2 == null) goto L15;
    L8:
        monitor-exit(n85.b.class);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L15:
        r2 = new CopyOnWriteArraySet();     // Catch: Throwable -> L10
        ((ConcurrentHashMap) r7.k).put(r8, r2);     // Catch: Throwable -> L10
        goto L8
    }

    public final SpaceThirdPartyOpenEntity g(JSONObject r10, String r11) {
        if (r10 != null) goto L21;
        String r4 = null;
    L8:
        if (r10 != null) goto L10;
    L17:
        tt5.a.b("DriveEmbedNativeRenderComponent", "getData fileId is null");     // Catch: Throwable -> L5
        return null;
    L10:
        if (TextUtils.isEmpty(r4) == true) goto L17;
        this.e = r4;     // Catch: Throwable -> L5
        this.f = Intrinsics.areEqual(DiagramData$RESULT.SUCCESS, r10.optString("in-vc"));     // Catch: Throwable -> L5
        this.g = r10.optString("mount-node-token");     // Catch: Throwable -> L5
        SpaceThirdPartyOpenEntity r7 = new SpaceThirdPartyOpenEntity(r10.optString("app-id"), r4, r10.optString("file-name"));     // Catch: Throwable -> L5
        r7.setMountNodeToken(this.g);     // Catch: Throwable -> L5
        r7.setInVc(this.f);     // Catch: Throwable -> L5
        r7.setApiExtra(r10.optString("auth-extra"));     // Catch: Throwable -> L5
        r7.setMountPoint(r10.optString("mount-point"));     // Catch: Throwable -> L5
        r7.setPreviewFrom(r10.optString("preview-from"));     // Catch: Throwable -> L5
        r7.setFileExt(r10.optString("file-type"));     // Catch: Throwable -> L5
        r7.setPreviewType(3);     // Catch: Throwable -> L5
        r7.setDownloadFrom("from_docs_attachment_download");     // Catch: Throwable -> L5
        r7.setDocToken(r10.optString("doc-token"));     // Catch: Throwable -> L5
        String r5 = r10.optString("src-obj-token");     // Catch: Throwable -> L5
        String r6 = r10.optString("encrypt-id");     // Catch: Throwable -> L5
        if (TextUtils.isEmpty(r5) == true) goto L15;
        r7.setDocToken(r5);     // Catch: Throwable -> L5
        r7.setEncryptId(r6);     // Catch: Throwable -> L5
        r7.setInBlock(true);     // Catch: Throwable -> L5
    L15:
        r7.setHostType(r10.optInt("host-type"));     // Catch: Throwable -> L5
        ArrayList<BaseMoreMenuAction> r8 = new ArrayList();     // Catch: Throwable -> L5
        r8.add(new SaveToLocalMenuV2());     // Catch: Throwable -> L5
        r7.setMoreMenuActions(r8);     // Catch: Throwable -> L5
        r7.setHostDocumentInfo(h(r10));     // Catch: Throwable -> L5
        tt5.a.h("DriveEmbedNativeRenderComponent", "really create " + f() + ", " + du5.b.g(this.g) + ", " + r11 + ", " + du5.b.g(r4));     // Catch: Throwable -> L5
        return r7;
    L21:
        r4 = r10.optString("file-id");     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        tt5.a.d("DriveEmbedNativeRenderComponent", "getData fail: " + th);
        return null;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void c(String r20, JSONObject r21, js5.c r22) {
        Intrinsics.checkNotNullParameter(r20, "eventName");
        Intrinsics.checkNotNullParameter(r22, "callback");
        tt5.a.h("DriveEmbedNativeRenderComponent", f() + " -- performAction eventName=" + r20);
        int r3 = 0;
        r3 = 0;
        boolean r4 = false;
        r4 = false;
        String r11 = null;
        switch(r20.hashCode()) {
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
        if (r20.equals("performPreload") == false) goto L133;
        StringBuilder r0 = new StringBuilder();
        r0.append(f());
        r0.append(" -- performAction PERFORM_PRELOAD ");
        SpaceThirdPartyOpenEntity r2 = this.k;
        if (r2 == null) goto L11;
        String r5 = r2.getFileExt();
    L12:
        r0.append(r5);
        tt5.a.b("DriveEmbedNativeRenderComponent", r0.toString());
        j(true);
        EmbedComponentInnerFrameLayout r1 = this.l;
        FragmentActivity r6 = getActivity();
        if (r6 != null) goto L16;
        tt5.a.d("DriveEmbedNativeRenderComponent", "handleLoadingUi activity is null");
    L28:
        HashMap r7 = new HashMap();
        SpaceThirdPartyOpenEntity r8 = this.k;
        if (r8 != null) goto L31;
        r8 = g(r21, "PERFORM_PRELOAD");
    L31:
        if (r8 == null) goto L33;
        this.k = r8;
        r7.put("file_token", du5.b.g(r8.getFileId()));
        r7.put("file_type", r8.getFileExt());
    L33:
        com.bytedance.ee.bear.drive.report.a r12 = o75.b.a().Tb();
        ks5.b r9 = getContext();
        if ((r9 instanceof ks5.b) == false) goto L36;
        ks5.b r10 = r9;
    L37:
        if (r10 == null) goto L39;
        String r14 = r10.c;
    L40:
        ks5.b r13 = getContext();
        if ((r13 instanceof ks5.b) == false) goto L43;
        ks5.b r16 = r13;
    L44:
        if (r16 == null) goto L46;
        r11 = r16.d;
    L46:
        r12.p("drive_preload", r14, r11, "DEC0", null, r7);
        js5.c.a.a(r22);
        return;
    L43:
        r16 = null;
        goto L44
    L39:
        r14 = null;
        goto L40
    L36:
        r10 = null;
        goto L37
    L16:
        if (r1 == null) goto L23;
        int r17 = r1.getChildCount();
        int r18 = 0;
    L18:
        if (r18 >= r17) goto L23;
        if (Intrinsics.areEqual("loading", r1.getChildAt(r18).getTag()) == true) goto L21;
        r18 = r18 + 1;
        goto L18
    L21:
        r4 = true;
    L23:
        tt5.a.h("DriveEmbedNativeRenderComponent", f() + " -- handleLoadingUi " + r4);
        if (r4 == true) goto L28;
        FrameLayout r19 = new FrameLayout(r6);
        LayoutInflater.from(r6).inflate(2131560207, r19);
        r19.setTag("loadingRoot");
        r19.setBackgroundDrawable(r6.getResources().getDrawable(2131234010));
        this.j = r19.findViewById(2131375019);
        this.h = r19.findViewById(2131383286);
        r19.setTag("loading");
        if (r1 == null) goto L28;
        r1.addView(r19, new FrameLayout.LayoutParams(-1, -1));
        goto L28
    L11:
        r5 = null;
        goto L12
    L133:
        return;
    L48:
        if (r20.equals("onCreateView") == false) goto L134;
        SpaceThirdPartyOpenEntity r23 = this.k;     // Catch: Throwable -> L57
        if (r23 != null) goto L53;
        r23 = g(r21, "perforam_action");     // Catch: Throwable -> L57
    L53:
        if (r23 == null) goto L55;
        r23.setHostDocumentInfo(h(r21));     // Catch: Throwable -> L57
        this.k = r23;     // Catch: Throwable -> L57
        tt5.a.b("DriveEmbedNativeRenderComponent", f() + " -- performAction ON_CREATE " + r23.getFileExt());     // Catch: Throwable -> L57
    L55:
        js5.c.a.a(r22);     // Catch: Throwable -> L57
        return;
    L57:
        th = move-exception;
        tt5.a.d("DriveEmbedNativeRenderComponent", f() + " -- performAction ON_CREATE failed: " + th);
        return;
    L134:
        return;
    L60:
        if (r20.equals("performRender") == false) goto L136;
        j(true);
        if (this.k != null) goto L65;
        this.k = g(r21, "PERFORM_RENDER");
    L65:
        e r24 = this.d;
        if (r24 == null) goto L68;
        r24.b(getActivity(), this.l, this.k, i(), this);
    L68:
        UDProgress r26 = this.h;
        if (r26 == null) goto L72;
        r26.setVisibility(8);
    L72:
        if (TextUtils.isEmpty(this.e) == true) goto L76;
        SpaceLoadingImage r27 = this.j;
        if (r27 == null) goto L76;
        r27.stop();
        r27.setVisibility(8);
    L76:
        StringBuilder r28 = new StringBuilder();
        r28.append(f());
        r28.append(" -- performAction PERFORM_RENDER ");
        SpaceThirdPartyOpenEntity r29 = this.k;
        if (r29 == null) goto L79;
        r11 = r29.getFileExt();
    L79:
        r28.append(r11);
        tt5.a.b("DriveEmbedNativeRenderComponent", r28.toString());
        if (TextUtils.isEmpty(this.e) == true) goto L87;
        n85.b r30 = n85.b.a.a;
        String r31 = this.e;
        String r32 = i();
        r30.getClass();
        if (TextUtils.isEmpty(r31) == true) goto L87;
        if (TextUtils.isEmpty(r32) == true) goto L87;
        ((ConcurrentHashMap) r30.j).put(r31, r32);
    L87:
        js5.c.a.a(r22);
        return;
    L136:
        return;
    L89:
        if (r20.equals("progressUpdate") == true) goto L92;
        return;
    L92:
        if (this.i == true) goto L100;
        UDProgress r33 = this.h;
        if (r33 == null) goto L96;
        r33.setVisibility(0);
    L96:
        SpaceLoadingImage r34 = this.j;
        if (r34 == null) goto L99;
        r34.setVisibility(8);
    L99:
        this.i = true;
    L100:
        UDProgress r36 = this.h;
        if (r36 == null) goto L107;
        if (r21 != null) goto L124;
    L106:
        r36.setProgress(r3);
        goto L107
    L124:
        r3 = JSONObjectProtectorUtils.getInt(r21, "progress");     // Catch: Exception -> L105
    L105:
        tt5.a.d("DriveEmbedNativeRenderComponent", "get progress error");
    L107:
        StringBuilder r37 = new StringBuilder();
        r37.append(f());
        r37.append(" -- performAction PROGRESS_UPDATE ");
        SpaceThirdPartyOpenEntity r38 = this.k;
        if (r38 == null) goto L110;
        r11 = r38.getFileExt();
    L110:
        r37.append(r11);
        tt5.a.b("DriveEmbedNativeRenderComponent", r37.toString());
        js5.c.a.a(r22);
        return;
    L112:
        if (r20.equals("performMoveOut") == false) goto L138;
        j(false);
        e r39 = this.d;
        if (r39 == null) goto L117;
        r39.a(i(), true);
    L117:
        StringBuilder r40 = new StringBuilder();
        r40.append(f());
        r40.append(" -- performAction MOVE_OUT ");
        SpaceThirdPartyOpenEntity r41 = this.k;
        if (r41 == null) goto L120;
        r11 = r41.getFileExt();
    L120:
        r40.append(r11);
        tt5.a.b("DriveEmbedNativeRenderComponent", r40.toString());
        js5.c.a.a(r22);
        return;
    }
}
