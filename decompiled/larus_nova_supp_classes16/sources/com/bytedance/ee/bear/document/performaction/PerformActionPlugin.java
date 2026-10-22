package com.bytedance.ee.bear.document.performaction;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.c0;
import com.bytedance.ee.bear.contract.f0;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.contract.route.parcelable.f;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.bytedance.ee.bear.route.h;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/document/performaction/PerformActionPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "handleAction", "data", "Lcom/bytedance/ee/bear/document/performaction/ActionData;", "handleMakeCopyAction", "makeCopy", "docViewModel", "Lcom/bytedance/ee/bear/document/DocViewModel;", "handleSubscribeDocUpdateAction", "Companion", "ActionHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PerformActionPlugin extends DocumentPluginV2 {
    public static final b Companion = null;
    private static final String MACK_COPY = "DuplicatePage";
    private static final String SUBSCRIBE_DOC_UPDATE = "FollowPage";
    private static final String TAG = "PerformActionPlugin";

    public final class a implements i<ActionData> {
        public final /* synthetic */ PerformActionPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(PerformActionPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            ActionData r3 = (ActionData) r1;
            if (r3 != null) goto L5;
            tt5.a.d(PerformActionPlugin.TAG, "PerformActionPlugin ActionHandler data = null;");
            return;
        L5:
            PerformActionPlugin.access$handleAction(this.a, r3);
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c implements c0.e {
        public final /* synthetic */ PerformActionPlugin a;

        @Override // com.bytedance.ee.bear.contract.c0.e
        public final void onFail() {
            Toast.showFailureText(PerformActionPlugin.access$getActivity(this.a), PerformActionPlugin.access$getString(this.a, 2131887802), 0);
        }

        @Override // com.bytedance.ee.bear.contract.c0.e
        public final void onSuccess() {
            Toast.showSuccessText(PerformActionPlugin.access$getActivity(this.a), PerformActionPlugin.access$getString(this.a, 2131887837), 0);
        }

        public c(PerformActionPlugin r1) {
            this.a = r1;
        }
    }

    public static final class d implements td5.a {
        public final /* synthetic */ SpaceSelectorBean a;

        public d(SpaceSelectorBean r1) {
            this.a = r1;
        }

        public final boolean a(Document r4) {
            Intrinsics.checkNotNullParameter(r4, "destFolder");
            if (this.a.g == false) goto L8;
            FolderVersion.a r0 = FolderVersion.Companion;
            Integer r2 = Integer.valueOf(r4.L1);
            r0.getClass();
            if (FolderVersion.a.c(r2) == true) goto L8;
            return false;
        L8:
            if (this.a.g == true) goto L12;
            FolderVersion.a r1 = FolderVersion.Companion;
            Integer r5 = Integer.valueOf(r4.L1);
            r1.getClass();
            if (FolderVersion.a.c(r5) == false) goto L14;
            return false;
        L14:
            return true;
        L12:
            return true;
        }

        public final void b(Document r4, Context r5) {
            Intrinsics.checkNotNullParameter(r4, "destFolder");
            String r1 = null;
            if (this.a.g == false) goto L11;
            FolderVersion.a r0 = FolderVersion.Companion;
            Integer r2 = Integer.valueOf(r4.L1);
            r0.getClass();
            if (FolderVersion.a.c(r2) == true) goto L11;
            if (r5 == null) goto L8;
            String r3 = r5.getString(2131887316);
        L9:
            Toast.showText(r5, r3);
            goto L11
        L8:
            r3 = null;
        L11:
            if (this.a.g == true) goto L18;
            FolderVersion.a r6 = FolderVersion.Companion;
            Integer r7 = Integer.valueOf(r4.L1);
            r6.getClass();
            if (FolderVersion.a.c(r7) == false) goto L19;
            if (r5 == null) goto L16;
            r1 = r5.getString(2131887317);
        L16:
            Toast.showText(r5, r1);
            return;
        L19:
            return;
        }
    }

    static {
        Companion = new b();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void handleMakeCopyAction() {
        DocViewModel r0 = getDocViewModel();
        if (r0 != null) goto L7;
        tt5.a.d(TAG, "handleSubscribeDocUpdateAction err: docViewModel null");
        return;
    L7:
        if (r0.isType(e.n) == false) goto L9;
        ((com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.a.class, null, null, 6)).f(getHost(), r0.getDocTitle());
        return;
    L9:
        makeCopy(r0);
    }

    private final void handleSubscribeDocUpdateAction() {
        DocViewModel r0 = getDocViewModel();
        if (r0 != null) goto L5;
        tt5.a.d(TAG, "handleSubscribeDocUpdateAction err: docViewModel null");
        return;
    L5:
        ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).X(new f0(r0.getToken(), r0.getDocumentTypeValue(), true, 0, new c(this)));
    }

    public PerformActionPlugin() {
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(PerformActionPlugin r0) {
        return r0.getActivity();
    }

    private final void handleAction(ActionData r3) {
        if (j.a.a.getNetworkState().a() == true) goto L6;
        Toast.showFailureText(getActivity(), getString(2131887951), 0);
        return;
    L6:
        String r4 = r3.getAction();
        if (Intrinsics.areEqual(r4, MACK_COPY) == false) goto L10;
        handleMakeCopyAction();
        return;
    L10:
        if (Intrinsics.areEqual(r4, SUBSCRIBE_DOC_UPDATE) == false) goto L14;
        handleSubscribeDocUpdateAction();
        return;
    }

    private final void makeCopy(DocViewModel r12) {
        String r0 = r12.getDocTitle();
        boolean r1 = ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).B();
        FolderVersion.a r4 = FolderVersion.Companion;
        DocumentInfo r5 = r12.getDocumentInfoData();
        if (r5 == null) goto L7;
        DocVersion r6 = r5.getVersion();
        if (r6 == null) goto L7;
        Integer r7 = Integer.valueOf(r6.getOwnerType());
    L8:
        r4.getClass();
        boolean r8 = FolderVersion.a.c(r7);
        SpaceSelectorBean r9 = new SpaceSelectorBean();
        r9.a(r12.getToken());
        r9.a = r12.getDocumentTypeValue();
        r9.c = r12.getParentToken();
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r9.e = "";
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r9.f = r0;
        r9.g = r8;
        Intrinsics.checkNotNullParameter("innerpage_more", "<set-?>");
        r9.m = "innerpage_more";
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r9.n = "";
        r9.i = r12.isOwner();
        SelectorConfig r10 = new SelectorConfig();
        r10.c(SelectorType.SPACE_MAKE_COPY_TO);
        if (r1 == false) goto L12;
        if (r8 == false) goto L12;
        SelectorScope r2 = SelectorScope.ALL;
    L13:
        r10.a(r2);
        r10.b(getString(2131889808));
        boolean r3 = false;
        if (r8 == true) goto L16;
    L18:
        boolean r13 = false;
    L19:
        r10.c = r13;
        r10.d = true;
        if (r1 == false) goto L22;
        if (r8 == false) goto L22;
    L23:
        r10.e = r3;
        r10.i = r1;
        r10.g = 3026;
        d r11 = new d(r9);
        SelectorConfig.a r14 = SelectorConfig.CREATOR;
        WeakReference r16 = new WeakReference(r11);
        r14.getClass();
        SelectorConfig.k = r16;
        ((h) org.koin.java.a.c(h.class, null, null, 6)).setActivity(getActivity());
        f r17 = (f) org.koin.java.a.c(f.class, null, null, 6);
        Context r18 = getHost().getContext();
        td5.f r19 = new td5.f();
        r19.a = 4;
        r19.e = 3026;
        Unit r110 = Unit.INSTANCE;
        r17.c(r18, r10, r19, r9, null);
        return;
    L22:
        r3 = true;
        goto L23
    L16:
        if (r12.getParentToken() == null) goto L18;
        r13 = true;
    L12:
        r2 = SelectorScope.SPACE_ONLY;
    L7:
        r7 = null;
        goto L8
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put("biz.util.performAction", new a(this));
    }

    public static final /* synthetic */ String access$getString(PerformActionPlugin r0, int r1) {
        return r0.getString(r1);
    }

    public static final /* synthetic */ void access$handleAction(PerformActionPlugin r0, ActionData r1) {
        r0.handleAction(r1);
    }
}
