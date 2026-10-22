package com.bytedance.ee.bear.drive.module.nativepreview.component.sandwich;

import android.content.Context;
import android.graphics.Outline;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.WikiNavInfo;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceThirdPartyOpenEntity;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.SaveToLocalMenuV2;
import com.bytedance.ee.bear.middleground_permission_export.model.audit.HostDocumentInfo;
import com.bytedance.ee.bear.secret.PermissionControl;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.bear.widgets.universedesign.SpaceLoadingImage;
import com.bytedance.ee.lark.component.AbstractNativeComponent;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import com.larksuite.component.universe_design.progress.UDProgress;
import du5.b;
import j85.e;
import j85.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DriveNativeRenderComponent extends AbstractNativeComponent implements k85.a {
    private static final String TAG = "DriveNativeRenderComponent";
    private String containerTag;
    private g fileBlockWrapper;
    private String fileToken;
    private WeakReference<AppCompatActivity> fragmentRef;
    private boolean isInVC;
    private boolean isProgress;
    private String mountNodeToken;
    private FrameLayout root;
    private SpaceLoadingImage spaceLoadingImage;
    private SpaceThirdPartyOpenEntity thirdPartyOpenEntity;
    private UDProgress uploadProgress;
    private String webViewHashCode;

    public class a extends ViewOutlineProvider {
        public final /* synthetic */ int a;
        public final /* synthetic */ DriveNativeRenderComponent b;

        public a(DriveNativeRenderComponent r1, int r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r7, Outline r8) {
            r8.setRoundRect(1, 1, DriveNativeRenderComponent.access$000(this.b).getWidth() - 1, DriveNativeRenderComponent.access$000(this.b).getHeight() - 1, this.a);
        }
    }

    public String getComponentViewType() {
        return "drive_file_block";
    }

    public com.bytedance.ee.bear.drive.module.nativepreview.component.embed.a getCoreSurfaceViewHolder() {
        return null;
    }

    @Override // k85.a
    public boolean getNeedRelease() {
        return false;
    }

    private AppCompatActivity getActivity() {
        WeakReference<AppCompatActivity> r0 = this.fragmentRef;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.get();
    }

    private String getKey() {
        if (this.isInVC == true) goto L7;
        tt5.a.h(TAG, "getKey=" + this.containerTag + b.g(this.fileToken) + b.g(this.mountNodeToken));
        return this.containerTag + this.fileToken + this.mountNodeToken;
    L7:
        return this.webViewHashCode + OfflineDoc.DASH_DELIMITER + this.mountNodeToken + OfflineDoc.DASH_DELIMITER + this.fileToken;
    }

    private void handleProgressUi() {
        if (this.uploadProgress == null) goto L8;
        SpaceLoadingImage r0 = this.spaceLoadingImage;
        if (r0 == null) goto L9;
        r0.setVisibility(8);
        this.uploadProgress.setVisibility(0);
        return;
    L9:
        return;
    }

    private void hideLoading() {
        UDProgress r0 = this.uploadProgress;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
    L6:
        if (TextUtils.isEmpty(this.fileToken) == true) goto L11;
        SpaceLoadingImage r1 = this.spaceLoadingImage;
        if (r1 == null) goto L12;
        r1.stop();
        this.spaceLoadingImage.setVisibility(8);
        return;
    L12:
        return;
    }

    public void onRemove() {
        tt5.a.h(TAG, "onRemove " + this.containerTag);
        if (TextUtils.isEmpty(this.fileToken) == false) goto L5;
        return;
    L5:
        this.fileBlockWrapper.a(getKey(), false);
    }

    public static /* synthetic */ FrameLayout access$000(DriveNativeRenderComponent r0) {
        return r0.root;
    }

    private HostDocumentInfo getDocumentInfo(JSONObject r33) {
        if (r33 != null) goto L6;
        tt5.a.k(TAG, "getDocumentInfo: data is null");     // Catch: Exception -> L28
        return null;
    L6:
        JSONObject r0 = r33.getJSONObject("document");     // Catch: Exception -> L28
        if (r0 != null) goto L10;
        tt5.a.k(TAG, "getDocumentInfo: docJson is null");     // Catch: Exception -> L28
        return null;
    L10:
        HostDocumentInfo r5 = new HostDocumentInfo();     // Catch: Exception -> L28
        DocMetaInfo r6 = new DocMetaInfo();     // Catch: Exception -> L28
        String r7 = r0.getString("ID");     // Catch: Exception -> L28
        int r8 = r0.getInteger("Type").intValue();     // Catch: Exception -> L28
        String r9 = r0.getString("Title");     // Catch: Exception -> L28
        tt5.a.h(TAG, "getDocumentInfo: type = " + r8);     // Catch: Exception -> L28
        JSONObject r1 = r0.getJSONObject("Owner");     // Catch: Exception -> L28
        String r10 = "";
        if (r1 == null) goto L14;
        String r11 = r1.getString("UserID");     // Catch: Exception -> L28
    L15:
        if (r1 == null) goto L17;
        r1.getString("UserName");     // Catch: Exception -> L28
    L17:
        String r2 = r0.getString("TenantID");     // Catch: Exception -> L28
        JSONObject r12 = r0.getJSONObject("DocSecLabel");     // Catch: Exception -> L28
        if (r12 == null) goto L20;
        String r16 = r12.getString("LabelID");     // Catch: Exception -> L28
    L21:
        if (r12 == null) goto L23;
        r10 = r12.getString("LabelNameCN");     // Catch: Exception -> L28
    L23:
        r5.setDocToken(r7);     // Catch: Exception -> L28
        r5.setObjToken(r7);     // Catch: Exception -> L28
        r5.setEntityType(Integer.valueOf(r8));     // Catch: Exception -> L28
        r5.setOwnerUid(r11);     // Catch: Exception -> L28
        r5.setTenantID(r2);     // Catch: Exception -> L28
        r5.setTitle(r9);     // Catch: Exception -> L28
        r6.setTitle(r9);     // Catch: Exception -> L28
        r6.setSecretLevel(new SecretLevel(r16, r10, "", 0, false, "", "", new PermissionControl(), false, true, "", "", "", "", null, null, 0));     // Catch: Exception -> L28
        String r3 = r0.getString("WikiToken");     // Catch: Exception -> L28
        if (TextUtils.isEmpty(r3) == true) goto L26;
        r5.setWikiInfo(new WikiNavInfo(true, r3));     // Catch: Exception -> L28
    L26:
        r5.setDocMetaInfo(r6);     // Catch: Exception -> L28
        return r5;
    L20:
        r16 = "";
        goto L21
    L14:
        r11 = "";
    L28:
        e = move-exception;
        tt5.a.e(TAG, "get document error", e, false);
        return null;
    }

    private int getProgress(JSONObject r2) {
        return r2.getInteger("progress").intValue();
    L4:
        tt5.a.d(TAG, "get progress error");
        return 0;
    }

    private void handleBlockShow(boolean r3) {
        tt5.a.h(TAG, this.containerTag + " -- performAction handleBlockShow: " + r3);
        if (r3 == false) goto L5;
        this.root.setVisibility(0);
        return;
    L5:
        this.root.setVisibility(4);
    }

    private SpaceThirdPartyOpenEntity getData(JSONObject r7, String r8) {
    L15:
        th = move-exception;
        tt5.a.f("onCreateView", th, false);
        return null;
    L4:
        if (r7.containsKey("file-id") == false) goto L21;
        String r1 = r7.getString("file-id");     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r1) == true) goto L22;
        SpaceThirdPartyOpenEntity r5 = new SpaceThirdPartyOpenEntity(r7.getString("app-id"), r1, r7.getString("file-name"));     // Catch: Throwable -> L15
        this.thirdPartyOpenEntity = r5;     // Catch: Throwable -> L15
        r5.setApiExtra(r7.getString("auth-extra"));     // Catch: Throwable -> L15
        this.thirdPartyOpenEntity.setMountPoint(r7.getString("mount-point"));     // Catch: Throwable -> L15
        this.thirdPartyOpenEntity.setMountNodeToken(r7.getString("mount-node-token"));     // Catch: Throwable -> L15
        this.thirdPartyOpenEntity.setPreviewFrom(r7.getString("preview-from"));     // Catch: Throwable -> L15
        this.thirdPartyOpenEntity.setFileExt(r7.getString("file-type"));     // Catch: Throwable -> L15
        this.thirdPartyOpenEntity.setInVc(DiagramData$RESULT.SUCCESS.equals(r7.getString("in-vc")));     // Catch: Throwable -> L15
        this.thirdPartyOpenEntity.setPreviewType(3);     // Catch: Throwable -> L15
        this.thirdPartyOpenEntity.setDocToken(r7.getString("doc-token"));     // Catch: Throwable -> L15
        String r2 = r7.getString("src-obj-token");     // Catch: Throwable -> L15
        String r3 = r7.getString("encrypt-id");     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r2) == true) goto L10;
        this.thirdPartyOpenEntity.setDocToken(r2);     // Catch: Throwable -> L15
        this.thirdPartyOpenEntity.setEncryptId(r3);     // Catch: Throwable -> L15
        this.thirdPartyOpenEntity.setInBlock(true);     // Catch: Throwable -> L15
    L10:
        this.thirdPartyOpenEntity.setHostType(r7.getIntValue("host-type"));     // Catch: Throwable -> L15
        this.thirdPartyOpenEntity.setDownloadFrom("from_docs_attachment_download");     // Catch: Throwable -> L15
        ArrayList<BaseMoreMenuAction> r4 = new ArrayList();     // Catch: Throwable -> L15
        r4.add(new SaveToLocalMenuV2());     // Catch: Throwable -> L15
        this.thirdPartyOpenEntity.setMoreMenuActions(r4);     // Catch: Throwable -> L15
        this.fileToken = this.thirdPartyOpenEntity.getFileId();     // Catch: Throwable -> L15
        this.isInVC = this.thirdPartyOpenEntity.isInVc();     // Catch: Throwable -> L15
        this.mountNodeToken = this.thirdPartyOpenEntity.getMountNodeToken();     // Catch: Throwable -> L15
        tt5.a.h(TAG, "really create " + this.containerTag + "，" + b.g(this.thirdPartyOpenEntity.getMountNodeToken()) + "," + r8 + "," + b.g(this.thirdPartyOpenEntity.getFileId()));     // Catch: Throwable -> L15
        if (c.a.a.h("admin.watermark.filewatermark.remaining") == false) goto L13;
        this.thirdPartyOpenEntity.setBizScene(DriveBizScene.DriveBizScene_CCM);     // Catch: Throwable -> L15
        this.thirdPartyOpenEntity.setWatermarkScene(DriveWatermarkScene.DriveWatermarkScene_CCM_ATTACHMENT_DOWNLOAD);     // Catch: Throwable -> L15
    L13:
        this.thirdPartyOpenEntity.setHostDocumentInfo(getDocumentInfo(r7));     // Catch: Throwable -> L15
        return this.thirdPartyOpenEntity;
    L22:
        return null;
    L21:
        return null;
    }

    public void handleLoadingUi(ViewGroup r4, boolean r5) {
        boolean r6 = false;
        int r0 = 0;
    L4:
        if (r0 >= r4.getChildCount()) goto L9;
        if ("loading".equals(r4.getChildAt(r0).getTag()) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        r6 = true;
    L9:
        if (r6 == true) goto L14;
        FrameLayout r7 = new FrameLayout(getActivity());
        LayoutInflater.from(r4.getContext()).inflate(2131560207, r7);
        r7.setTag("loadingRoot");
        r7.setBackgroundDrawable(getActivity().getResources().getDrawable(2131234010));
        this.spaceLoadingImage = r7.findViewById(2131375019);
        this.uploadProgress = r7.findViewById(2131383286);
        r7.setTag("loading");
        r4.addView(r7, new FrameLayout.LayoutParams(-1, -1));
        return;
    }

    public View onCreateView(Context r8, JSONObject r9) {
        this.root = new FrameLayout(r8);
        this.root.setOutlineProvider(new a(this, d.a(6)));
        this.root.setClipToOutline(true);
        tt5.a.h(TAG, "onCreateView " + this.containerTag);
        SpaceThirdPartyOpenEntity r10 = getData(r9, "samerender");
        if (r10 == null) goto L5;
        this.thirdPartyOpenEntity = r10;
    L5:
        o75.b.a().Tb().p("render_view_on_create", getViewId(), getViewType(), "DEC0", null, null);
        return this.root;
    }

    public void onUpdateView(View r1, JSONObject r2) {
        tt5.a.b(TAG, "onUpdateView " + getClass().getSimpleName() + " - " + hashCode());
    }

    public void performAction(String r8, JSONObject r9) {
        tt5.a.h(TAG, this.containerTag + " -- performAction eventName=" + r8);
        r8.getClass();
        switch(r8.hashCode()) {
            case -2055344356: goto L22;
            case -1843867306: goto L18;
            case -1456650153: goto L14;
            case 414896384: goto L10;
            case 677592936: goto L6;
            default: goto L25;
        };
    L25:
        byte r10 = -1;
    L26:
        String r0 = "null";
        if (r10 == 0) goto L76;
        if (r10 == 1) goto L71;
        if (r10 == 2) goto L55;
        if (r10 == 3) goto L82;
        if (r10 != 4) goto L91;
        StringBuilder r11 = new StringBuilder();
        r11.append(this.containerTag);
        r11.append(" -- performAction PERFORM_PRELOAD ");
        SpaceThirdPartyOpenEntity r2 = this.thirdPartyOpenEntity;
        if (r2 == null) goto L37;
        r0 = r2.getFileExt();
    L37:
        r11.append(r0);
        tt5.a.b(TAG, r11.toString());
        handleBlockShow(true);
        handleLoadingUi(this.root, true);
        if (this.thirdPartyOpenEntity != null) goto L40;
        this.thirdPartyOpenEntity = getData(r9, "PERFORM_PRELOAD");
    L40:
        HashMap r6 = new HashMap();
        SpaceThirdPartyOpenEntity r12 = this.thirdPartyOpenEntity;
        if (r12 == null) goto L43;
        r6.put("file_token", b.g(r12.getFileId()));
        r6.put("file_type", this.thirdPartyOpenEntity.getFileExt());
    L43:
        o75.b.a().Tb().p("drive_preload", getViewId(), getViewType(), "DEC0", null, r6);
        return;
    L91:
        return;
    L82:
    L53:
        th = move-exception;
        tt5.a.d(TAG, this.containerTag + " -- performAction ON_CREATE failed: " + th);
        return;
    L45:
        if (this.thirdPartyOpenEntity != null) goto L47;
        this.thirdPartyOpenEntity = getData(r9, "perforam_action");     // Catch: Throwable -> L53
    L47:
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L53
        r13.append(this.containerTag);     // Catch: Throwable -> L53
        r13.append(" -- performAction ON_CREATE ");     // Catch: Throwable -> L53
        SpaceThirdPartyOpenEntity r14 = this.thirdPartyOpenEntity;     // Catch: Throwable -> L53
        if (r14 == null) goto L51;
        r0 = r14.getFileExt();     // Catch: Throwable -> L53
    L51:
        r13.append(r0);     // Catch: Throwable -> L53
        tt5.a.b(TAG, r13.toString());     // Catch: Throwable -> L53
        return;
    L55:
        handleBlockShow(true);
        StringBuilder r16 = new StringBuilder();
        r16.append(this.containerTag);
        r16.append(" -- performAction PERFORM_RENDER ");
        SpaceThirdPartyOpenEntity r3 = this.thirdPartyOpenEntity;
        if (r3 == null) goto L59;
        r0 = r3.getFileExt();
    L59:
        r16.append(r0);
        tt5.a.b(TAG, r16.toString());
        if (this.thirdPartyOpenEntity != null) goto L62;
        this.thirdPartyOpenEntity = getData(r9, "PERFORM_RENDER");
    L62:
        this.fileBlockWrapper.b(getActivity(), this.root, this.thirdPartyOpenEntity, getKey(), this);
        hideLoading();
        if (TextUtils.isEmpty(this.fileToken) == true) goto L86;
        n85.b r17 = n85.b.a.a;
        String r18 = this.fileToken;
        String r1 = getKey();
        r17.getClass();
        if (TextUtils.isEmpty(r18) == false) goto L67;
        return;
    L67:
        if (TextUtils.isEmpty(r1) == true) goto L93;
        ((ConcurrentHashMap) r17.j).put(r18, r1);
        return;
    L93:
        return;
    L86:
        return;
    L71:
        if (this.isProgress == true) goto L73;
        handleProgressUi();
        this.isProgress = true;
    L73:
        int r19 = getProgress(r9);
        UDProgress r20 = this.uploadProgress;
        if (r20 == null) goto L89;
        r20.setProgress(r19);
        return;
    L89:
        return;
    L76:
        StringBuilder r21 = new StringBuilder();
        r21.append(this.containerTag);
        r21.append(" -- performAction MOVE_OUT ");
        SpaceThirdPartyOpenEntity r22 = this.thirdPartyOpenEntity;
        if (r22 == null) goto L80;
        r0 = r22.getFileExt();
    L80:
        r21.append(r0);
        tt5.a.b(TAG, r21.toString());
        handleBlockShow(false);
        this.fileBlockWrapper.a(getKey(), true);
        return;
    L6:
        if (r8.equals("performPreload") == false) goto L25;
        r10 = 4;
        goto L26
    L10:
        if (r8.equals("onCreateView") == false) goto L25;
        r10 = 3;
        goto L26
    L14:
        if (r8.equals("performRender") == false) goto L25;
        r10 = 2;
        goto L26
    L18:
        if (r8.equals("progressUpdate") == false) goto L25;
        r10 = 1;
        goto L26
    L22:
        if (r8.equals("performMoveOut") == false) goto L25;
        r10 = 0;
        goto L26
    }

    public DriveNativeRenderComponent(ur5.a r3, String r4, String r5) {
        super(r3, r4, r5);
        String r6 = "";
        this.containerTag = "";
        this.isProgress = false;
        this.fragmentRef = new WeakReference(null);
        this.fileBlockWrapper = new e();
        this.fragmentRef = new WeakReference(r3.getContext());
        pxb.a r7 = r3.b;
        if (r7 == null) goto L5;
        r6 = Integer.toString(r7.hashCode());
    L5:
        this.webViewHashCode = r6;
        this.containerTag = r4 + OfflineDoc.DASH_DELIMITER + this.webViewHashCode + OfflineDoc.DASH_DELIMITER;
        tt5.a.h(TAG, "DriveNativeRenderComponent init " + getClass().getSimpleName() + " - " + hashCode() + "," + this.containerTag);
    }
}
