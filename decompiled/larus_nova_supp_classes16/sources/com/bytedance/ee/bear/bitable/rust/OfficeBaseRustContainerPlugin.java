package com.bytedance.ee.bear.bitable.rust;

import com.bytedance.ee.bear.bitable.chameleon.BitableSubType;
import com.bytedance.ee.bear.bitable.chameleon.i;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.lark.pb.bitable.v1.BitableDocumentType;
import com.bytedance.lark.pb.bitable.v1.BitableSetDocumentContainerRequest;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0002\u001c\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\f\u0010\u0017\u001a\u00020\b*\u00020\u0018H\u0002J\u000e\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\u00020\u001bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/rust/OfficeBaseRustContainerPlugin;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "Lcom/bytedance/ee/bear/bitable/rust/BaseRustContainerAbility;", "<init>", "()V", "session", "Lcom/bytedance/ee/bear/bitable/rust/OfficeBaseRustContainerPlugin$RustDocumentSession;", "currentBlockId", "", "currentViewId", "getPluginId", "getContainerId", "updateMainScene", "", "blockId", "viewId", "onAttachToHost", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onDetachFromHost", "setDocumentStatus", JSEventListener.ACTION, "Lcom/bytedance/lark/pb/bitable/v1/BitableSetDocumentContainerRequest$Action;", "resolveRustToken", "Lcom/bytedance/ee/bear/document/DocumentMetadata;", "toRustDocumentType", "Lcom/bytedance/lark/pb/bitable/v1/BitableDocumentType;", "Lcom/bytedance/ee/bear/bitable/chameleon/BitableSubType;", "RustDocumentSession", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeBaseRustContainerPlugin extends OfficeDocumentPlugin implements com.bytedance.ee.bear.bitable.rust.a {
    public static final a Companion = null;
    public static final String PLUGIN_ID = "OfficeBaseRustContainerPlugin";
    private static final String TAG = "OfficeBaseRustContainerPlugin";
    private String currentBlockId;
    private String currentViewId;
    private b session;

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;
        public final BitableDocumentType d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "RustDocumentSession(token=" + this.a + ", url=" + this.b + ", containerId=" + this.c + ", documentType=" + this.d + ')';
        }

        public b(String r2, String r3, String r4, BitableDocumentType r5) {
            Intrinsics.checkNotNullParameter(r2, "token");
            Intrinsics.checkNotNullParameter(r3, "url");
            Intrinsics.checkNotNullParameter(r4, "containerId");
            Intrinsics.checkNotNullParameter(r5, "documentType");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BitableSubType.values().length];
            r0[BitableSubType.BaseMain.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[BitableSubType.BaseAdd.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[BitableSubType.BaseRecord.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[BitableSubType.BaseApp.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[BitableSubType.Unknown.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    static {
        Companion = new a();
    }

    public String getPluginId() {
        return "OfficeBaseRustContainerPlugin";
    }

    @Override // com.bytedance.ee.bear.document.OfficeDocumentPlugin
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.bitable.rust.a
    public String getContainerId() {
        b r0 = this.session;
        if (r0 == null) goto L5;
        String r1 = r0.c;
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public OfficeBaseRustContainerPlugin() {
    }

    private final String resolveRustToken(y3 r3) {
        WikiInfo r0 = r3.getWikiInfo();
        if (r0 == null) goto L5;
        String r1 = r0.getObjToken();
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L17;
        if (Intrinsics.areEqual(r1, r3.getToken()) == true) goto L17;
        return r1;
    L17:
        return r3.getToken();
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    private final BitableDocumentType toRustDocumentType(BitableSubType r2) {
        int r3 = c.a[r2.ordinal()];
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L22;
        if (r3 == 3) goto L21;
        if (r3 != 4) goto L11;
    L15:
        return null;
    L11:
        if (r3 == 5) goto L15;
        throw new NoWhenBranchMatchedException();
    L21:
        return BitableDocumentType.RECORD;
    L22:
        return BitableDocumentType.ADD_RECORD;
    L19:
        return BitableDocumentType.MAIN;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(ChameleonPluginHost r6) {
        Intrinsics.checkNotNullParameter(r6, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r6);
        i.a.getClass();
        BitableDocumentType r0 = toRustDocumentType(i.a(r6));
        if (r0 != null) goto L6;
        tt5.a.k("OfficeBaseRustContainerPlugin", "skip unsupported Base scene");
        return;
    L6:
        y3 r1 = (y3) r6.getHostAbility(y3.class);
        b r2 = new b(resolveRustToken(r1), r1.getUrl(), UUID.randomUUID().toString(), r0);
        this.currentBlockId = null;
        this.currentViewId = null;
        this.session = r2;
        r6.registerHostAbility(this);
        setDocumentStatus(r2, BitableSetDocumentContainerRequest.Action.ENTER_DOCUMENT);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromHost(ChameleonPluginHost r3) {
        b r0 = this.session;
        if (r0 == null) goto L5;
        setDocumentStatus(r0, BitableSetDocumentContainerRequest.Action.EXIT_DOCUMENT);
    L5:
        this.session = null;
        this.currentBlockId = null;
        this.currentViewId = null;
        if (r3 == null) goto L8;
        r3.unregisterHostAbility(this);
    L8:
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r3);
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }

    private final void setDocumentStatus(b r7, final BitableSetDocumentContainerRequest.Action r8) {
        g.b(r7.a, r7.b, r7.c, r7.d, r8, new AnonymousClass1(r8));
    }

    @Override // com.bytedance.ee.bear.bitable.rust.a
    public void updateMainScene(final String r6, final String r7) {
        b r0 = this.session;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.d == BitableDocumentType.MAIN) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(this.currentBlockId, r6) == true) goto L11;
    L13:
        String r1 = r0.a;
        String r2 = r0.c;
        String r3 = "";
        if (r6 != null) goto L16;
        String r4 = "";
    L17:
        if (r7 == null) goto L20;
        r3 = r7;
    L20:
        g.c(r1, r2, r4, r3, new C03361(r6, r7));
        this.currentBlockId = r6;
        this.currentViewId = r7;
        return;
    L16:
        r4 = r6;
        goto L17
    L11:
        if (Intrinsics.areEqual(this.currentViewId, r7) == false) goto L13;
    }
}
