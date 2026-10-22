package qe5;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.middleground.permission.external.SceneType;
import com.bytedance.ee.bear.middleground.permission.secret.SecretApprovalDefModel;
import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.google.gson.Gson;
import java.lang.ref.WeakReference;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends d {
    public final String l;
    public SecretApprovalInstanceModel m;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ e a;
        public final /* synthetic */ XBridgeMethod.Callback b;

        public b(e r1, XBridgeMethod.Callback r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r7, int r8) {
            tt5.a.h("ccm-lynx: CCMSecLabelRepeatApprovalMethod", "click cancel.");
            XCoreBridgeMethod.onSuccess$default(this.a, this.b, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("actionID", DocFeed$Value$Result.CANCEL)}), null, 4, null);
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ e a;
        public final /* synthetic */ XBridgeMethod.Callback b;

        public c(e r1, XBridgeMethod.Callback r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r7, int r8) {
            tt5.a.h("ccm-lynx: CCMSecLabelRepeatApprovalMethod", "click confirm.");
            XCoreBridgeMethod.onSuccess$default(this.a, this.b, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("actionID", "confirm")}), null, 4, null);
        }
    }

    static {
    }

    public e() {
        this.l = "ccm.permission.repeatedApprovalDialog";
    }

    @Override // qe5.d
    public final String getName() {
        return this.l;
    }

    @Override // qe5.d
    public final void g(XReadableMap r6) {
        Intrinsics.checkNotNullParameter(r6, "params");
        super.g(r6);
        String r7 = r6.getString("secLabelApprovalList");
        SecretApprovalInstanceModel r2 = null;
        if (TextUtils.isEmpty(r7) == false) goto L16;
        tt5.a.h("ccm-lynx: CCMSecLabelRepeatApprovalMethod", "parseSecretApprovalInstanceModel()...instanceModelStr is null.");
    L14:
        this.m = r2;
        return;
    L16:
        SecretApprovalInstanceModel r8 = (SecretApprovalInstanceModel) new Gson().fromJson(r7, SecretApprovalInstanceModel.class);     // Catch: Exception -> L11
        r8.setSuccess(true);     // Catch: Exception -> L9
        tt5.a.h("ccm-lynx: CCMSecLabelRepeatApprovalMethod", "result = " + r8);     // Catch: Exception -> L9
        r2 = r8;
    L9:
        Exception e = e;
        r2 = r8;
    L13:
        tt5.a.d("ccm-lynx: CCMSecLabelRepeatApprovalMethod", "parseSecretApprovalInstanceModel()...error = " + e);
    L11:
        e = move-exception;
        e = e;
        goto L13
    }

    @Override // qe5.d
    public final void handle(XReadableMap r10, XBridgeMethod.Callback r11, XBridgePlatformType r12) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "callback");
        Intrinsics.checkNotNullParameter(r12, ResourceData.KEY_TYPE);
        g(r10);
        if (this.f != null) goto L5;
    L39:
        tt5.a.h("ccm-lynx: CCMSecLabelRepeatApprovalMethod", "originSecLabel、targetSecLabel、secLabelApprovalDef or secretApprovalInstanceModel is null, return.");
        return;
    L5:
        if (this.g == null) goto L39;
        if (this.h == null) goto L39;
        if (this.m == null) goto L39;
        c r3 = new c(this, r11);
        b r4 = new b(this, r11);
        FragmentActivity r13 = (Context) provideContext(Context.class);
        Fragment r1 = (Fragment) provideContext(Fragment.class);
        cj5.c r14 = (cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6);
        boolean r5 = false;
        if (com.bytedance.ee.bear.middleground.permission.b.m() == true) goto L14;
    L16:
        boolean r2 = false;
    L17:
        if (r2 == false) goto L24;
        if (r1 != null) goto L20;
    L22:
        if (r5 == false) goto L24;
        r14.hb(r1, this.c, r3, r4, this.m, this.h, this.g, this.f);
        return;
    L20:
        if (r1.isAdded() != true) goto L22;
        r5 = true;
    L24:
        if (r2 == true) goto L26;
    L28:
        int r6 = th5.b.l;
        if (th5.b.a.a(this.b) == false) goto L36;
        jg5.j r15 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        SecretApprovalInstanceModel r16 = this.m;
        SecretApprovalDefModel r17 = this.h;
        SecretLevel r7 = this.g;
        SecretLevel r8 = this.f;
        r15.getClass();
        WeakReference<th5.a> r18 = jg5.j.j;
        if (r18 != null) goto L33;
        return;
    L33:
        if (r18.get() == null) goto L44;
        jg5.j.j.get().QQ(r3, r4, r16, r17, r7, r8);
        return;
    L44:
        return;
    L36:
        if ((r13 instanceof FragmentActivity) == false) goto L46;
        r14.l5(r13, this.c, r3, r4, this.m, this.h, this.g, this.f);
        return;
    L46:
        return;
    L26:
        if ((r13 instanceof FragmentActivity) == false) goto L28;
        r14.l5(r13, this.c, r3, r4, this.m, this.h, this.g, this.f);
        return;
    L14:
        if (this.b != SceneType.PASSWORD_SHARE.getValue()) goto L16;
        r2 = true;
        goto L17
    }
}
