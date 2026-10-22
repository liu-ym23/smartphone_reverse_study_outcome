package com.bytedance.ee.bear.document.permissionseetting;

import android.content.Context;
import by4.d;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;
import tb5.i;
import tb5.m;
import uj5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/document/permissionseetting/PermissionSettingPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "kvStorage", "Lcom/bytedance/ee/bear/diskmanager/container/ICCMUserKVStorage;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "getPermissionSettingParams", "Lcom/bytedance/ee/bear/more/permissionsetting/PermissionSettingParams;", "SettingPanelOpenHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermissionSettingPlugin extends DocumentPluginV2 {
    private d kvStorage;

    public final class a implements i<UInt> {
        public final /* synthetic */ PermissionSettingPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(PermissionSettingPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r5, m r6) {
            UInt r7 = (UInt) r5;
            Context r8 = PermissionSettingPlugin.access$getContext(this.a);
            if (r8 == null) goto L12;
            PermissionSettingPlugin r9 = this.a;
            int r0 = uj5.a.a;
            b r1 = PermissionSettingPlugin.access$getPermissionSettingParams(r9);
            WebFragment r3 = null;
            h0 r2 = (h0) org.koin.java.a.c(h0.class, null, null, 6);
            PluginHost r10 = r9.getHost();
            if ((r10 instanceof DocumentPluginHost) == false) goto L7;
            DocumentPluginHost r11 = (DocumentPluginHost) r10;
        L8:
            if (r11 == null) goto L10;
            r3 = r11.c();
        L10:
            uj5.a.a.a(r8, r1, r2, r3, false);
            return;
        L7:
            r11 = null;
            goto L8
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final b getPermissionSettingParams() {
        DocViewModel r1 = getDocViewModel();
        if (r1 == null) goto L39;
        w05.i r2 = ((w05.b) getHostAbility(w05.b.class)).getDocumentInfoProvider();
        DocPermission r3 = (DocPermission) r2.c().getValue();
        if (r3 == null) goto L12;
        IDocUserPermission r4 = r3.a;
        if (r4 == null) goto L12;
        String r5 = r4.getReportJson();
        if (r5 == null) goto L12;
        String r16 = r5;
    L13:
        DocPermission r6 = (DocPermission) r2.c().getValue();
        if (r6 == null) goto L21;
        IDocPublicPermission r7 = r6.b;
        if (r7 == null) goto L21;
        String r8 = r7.getReportJson();
        if (r8 == null) goto L21;
        String r17 = r8;
    L22:
        String r10 = r1.getDocumentInfoData().getDocMetaInfo().getCreatorTenantId();
        String r9 = r1.getToken();
        int r11 = r1.getBearUrl().a();
        boolean r12 = r1.isType(e.n);
        if (r1.getOpenSource() != DocsOpenSource.vc) goto L25;
        boolean r13 = true;
    L26:
        boolean r18 = r1.isOwner();
        d r14 = this.kvStorage;
        if (r14 == null) goto L31;
        com.ss.android.lark.storage.kv.repo.a r19 = r14.b("account");
        if (r19 == null) goto L31;
        boolean r110 = r19.getBoolean("key_has_leader", true);
    L32:
        String r20 = r1.getBearUrl().e;
        if (r20 != null) goto L35;
        String r111 = "";
    L37:
        return new b(r9, r11, false, r12, r10, r13, "", "", "", r16, r17, r18, r110, r111);
    L35:
        r111 = r20;
    L31:
        r110 = true;
        goto L32
    L25:
        r13 = false;
    L21:
        r17 = "";
    L12:
        r16 = "";
        goto L13
    L39:
        return new b(null, 0, false, null, null, null, null, false, null, 16383);
    }

    public PermissionSettingPlugin() {
    }

    public static final /* synthetic */ Context access$getContext(PermissionSettingPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ b access$getPermissionSettingParams(PermissionSettingPlugin r0) {
        return r0.getPermissionSettingParams();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super.getBridgeHandlers(r3);
        r3.put("biz.permission.openSettingPanel", new a(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r2) {
        super.onAttachToHost(r2);
        if (r2 == null) goto L7;
        vo5.a r3 = r2.getUserComponent();
        if (r3 == null) goto L7;
        d r4 = (d) r3.a(d.class);
    L8:
        this.kvStorage = r4;
        return;
    L7:
        r4 = null;
        goto L8
    }
}
