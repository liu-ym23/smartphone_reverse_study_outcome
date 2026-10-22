package com.bytedance.ee.bear.drive.biz.docplugin;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.attachment.filereader.FileClickData;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.s;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceAttachmentOpenEntity;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.desktop.resultmodel.FileClickModel;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.drive.core.fragment.UserContainerDriveMainFragment;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.ui.h;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import java.util.ArrayList;
import java.util.Map;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class AttachmentOpenPlugin extends DocumentPlugin {
    private static final String BIZ_UTIL_EXIT_FILE = "biz.util.exitFile";
    private static final String BIZ_UTIL_FILE_CLICK = "biz.util.fileClick";
    private static final String BIZ_UTIL_ON_EXIT_FILE = "biz.util.onFileExit";
    private static final String TAG = "drive_in_doc_attachment_AttachmentOpenPlugin";
    private static final int TYPE_TOS = 1;
    private static final String VC_MEETING_ID = "vc_meeting_id";
    private com.bytedance.ee.bear.drive.biz.docplugin.c mAttachmentFollowManager;
    private m mFileExitCallback;
    private String mLastOpenEntityKey;

    public class a extends com.bytedance.ee.bear.drive.biz.docplugin.d {
        public final /* synthetic */ AttachmentOpenPlugin a;

        public a(AttachmentOpenPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.drive.biz.docplugin.d
        public final void b(com.bytedance.ee.bear.drive.biz.docplugin.d.a r4) {
            tt5.a.h(AttachmentOpenPlugin.TAG, "DriveOpenPlugin onCallback, native return data . result=" + r4.toString());
            AttachmentOpenPlugin.access$202(this.a, "");
            if (r4.a != 100) goto L9;
            AttachmentOpenPlugin.access$300(this.a).d(this.a);
            if (AttachmentOpenPlugin.access$400(this.a) == null) goto L7;
            tt5.a.h(AttachmentOpenPlugin.TAG, "DriveOpenPlugin onCallback: ");
            AttachmentOpenPlugin.access$400(this.a).b(new JSONObject());
            return;
        L7:
            tt5.a.h(AttachmentOpenPlugin.TAG, "DriveOpenPlugin onCallback: mFileExitCallback is null");
            AttachmentOpenPlugin.access$500(this.a, "javascript:window.lark.biz.util.onFileExit", new JSONObject());
            return;
        }
    }

    public class b implements i<FileClickModel> {
        public final boolean a;
        public final /* synthetic */ AttachmentOpenPlugin b;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(AttachmentOpenPlugin r1, boolean r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            FileClickModel r4 = (FileClickModel) r2;
            tt5.a.h(AttachmentOpenPlugin.TAG, "FileClickHandler, enableFollow = " + this.a + ", Open file : " + r4);
            AttachmentOpenPlugin.access$600(this.b, r4, this.a);
        }
    }

    public class c implements i<String> {
        public final /* synthetic */ AttachmentOpenPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(AttachmentOpenPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            tt5.a.h(AttachmentOpenPlugin.TAG, "FileExitHandler, exit file from js : " + ((String) r2));
            AttachmentOpenPlugin.access$700(this.a);
        }
    }

    public class d implements i<String> {
        public final /* synthetic */ AttachmentOpenPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(AttachmentOpenPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, m r4) {
            tt5.a.h(AttachmentOpenPlugin.TAG, "FileOnExitHandler, exit file from native : " + ((String) r3));
            AttachmentOpenPlugin.access$402(this.a, r4);
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void exitFile() {
        tt5.a.h(TAG, "exitFile()...");
        this.mLastOpenEntityKey = "";
        getUIContainer().d(this);
    }

    public AttachmentOpenPlugin() {
    }

    public static /* synthetic */ t access$300(AttachmentOpenPlugin r0) throws IllegalStateException {
        return r0.getUIContainer();
    }

    public static /* synthetic */ m access$400(AttachmentOpenPlugin r0) {
        return r0.mFileExitCallback;
    }

    public static /* synthetic */ void access$700(AttachmentOpenPlugin r0) {
        r0.exitFile();
    }

    private String encryptedMeetingId(String r3) {
        tt5.a.h(TAG, "encryptedMeetingId: " + du5.b.g(r3));
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return "";
    L5:
        String r4 = UriProtector.getQueryParameter(UriProtector.parse(r3), VC_MEETING_ID);
        if (r4 != null) goto L9;
        return "";
    L9:
        return du5.b.e(r4);
    }

    private String generateEntityKey(SpaceAttachmentOpenEntity r3) {
        if (r3 != null) goto L5;
        return "";
    L5:
        return r3.getMountNodeToken() + OfflineDoc.DASH_DELIMITER + r3.getFileId();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        if (getDocViewModel().getOpenSource() != DocsOpenSource.vc) goto L5;
        boolean r0 = true;
    L6:
        r3.put(BIZ_UTIL_FILE_CLICK, new b(this, r0));
        r3.put(BIZ_UTIL_EXIT_FILE, new c(this));
        r3.put(BIZ_UTIL_ON_EXIT_FILE, new d(this));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void onDetachFromHost(DocumentPluginHost r1) {
        super.onDetachFromHost(r1);
        com.bytedance.ee.bear.drive.biz.docplugin.c r2 = this.mAttachmentFollowManager;
        if (r2 == null) goto L6;
        r2.d();
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    public static /* synthetic */ String access$202(AttachmentOpenPlugin r0, String r1) {
        r0.mLastOpenEntityKey = r1;
        return r1;
    }

    public static /* synthetic */ m access$402(AttachmentOpenPlugin r0, m r1) {
        r0.mFileExitCallback = r1;
        return r1;
    }

    private void openFile(FileClickModel r19, boolean r20) {
        if (r19 != null) goto L7;
        tt5.a.d(TAG, "openFile()... data is null");
        return;
    L7:
        if (r20 == true) goto L19;
        if (h.a(800) == true) goto L12;
        tt5.a.k(TAG, "is not ValidClick");
        return;
    L12:
        String r5 = getDocViewModel().getToken();
        FileClickData r16 = new FileClickData(r19.getFile_id(), r19.getDrive_file_key(), r19.getFile_name(), r19.getFile_mime_type(), r19.getFile_size(), r19.getType(), r19.getMount_node_token(), r19.getMount_point(), r19.getDownLoadPath(), r19.getPreview_from());
        r16.setHostDocumentInfo(((DocumentInfo) getDocViewModel().getDocumentInfoProvider().g().getValue()).convertToHostDocumentInfo());     // Catch: Exception -> L15
    L17:
        ((com.bytedance.ee.bear.attachment.filereader.a) org.koin.java.a.a(com.bytedance.ee.bear.attachment.filereader.a.class)).c(r5, r16);
        return;
    L15:
        e = move-exception;
        tt5.a.e(TAG, "AttachmentOpenPlugin openFile: setPreviewFrom error", e, false);
        goto L17
    L19:
        if (r19.getType() == 1) goto L23;
        tt5.a.d(TAG, "DriveOpenPlugin openFile: type is invalid data=" + r19.toString());
        return;
    L23:
        if ("sheet_attach".equalsIgnoreCase(r19.getPreview_from()) == false) goto L25;
        String r0 = "45";
    L26:
        SpaceAttachmentOpenEntity r6 = new SpaceAttachmentOpenEntity(r0, r19.getDrive_file_key(), r19.getFile_name());
        r6.setBusinessId(r19.getPreview_from());
        r6.setMountNodeToken(r19.getMount_node_token());
        r6.setMountPoint(r19.getMount_point());
        r6.setPreviewFrom(r19.getPreview_from());
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == false) goto L41;
        r6.setUseLarkPreview(true);
    L41:
        r6.setHostDocumentInfo(((DocumentInfo) getDocViewModel().getDocumentInfoProvider().g().getValue()).convertToHostDocumentInfo());     // Catch: Exception -> L31
    L33:
        String r1 = generateEntityKey(r6);
        if (TextUtils.equals(this.mLastOpenEntityKey, r1) == false) goto L37;
        tt5.a.h(TAG, "openFile() open same entity key");
        return;
    L37:
        this.mLastOpenEntityKey = r1;
        com.bytedance.ee.bear.drive.biz.docplugin.c r2 = new com.bytedance.ee.bear.drive.biz.docplugin.c(this, getActivity(), getLifecycleOwner(), new a(this));
        this.mAttachmentFollowManager = r2;
        String r3 = encryptedMeetingId(getUrl());
        ArrayList r4 = new ArrayList();
        r4.add(r6);
        UserContainerDriveMainFragment r7 = r2.b(r4, 0, r3, null);
        s r8 = new s();
        r8.e = true;
        getUIContainer().e(this, r7, r8);
        return;
    L31:
        e = move-exception;
        tt5.a.e(TAG, "AttachmentOpenPlugin openFile: setPreviewFrom error", e, false);
        goto L33
    L25:
        r0 = "19";
        goto L26
    }

    public static /* synthetic */ void access$500(AttachmentOpenPlugin r0, String r1, JSONObject r2) {
        r0.execJS(r1, r2);
    }

    public static /* synthetic */ void access$600(AttachmentOpenPlugin r0, FileClickModel r1, boolean r2) {
        r0.openFile(r1, r2);
    }
}
