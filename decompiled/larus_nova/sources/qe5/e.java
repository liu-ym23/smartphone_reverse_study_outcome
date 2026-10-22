package qe5;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.permission.external.SceneType;
import com.bytedance.ee.bear.middleground.permission.secret.SecretApprovalDefModel;
import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;
import com.bytedance.ee.bear.secret.SecretLevel;
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

/* JADX INFO: loaded from: classes18.dex */
public final class e extends d {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f532659l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public SecretApprovalInstanceModel f532660m;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f532661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f532662b;

        public b(e r100, XBridgeMethod.Callback r101) {
            this.f532661a = r100;
            this.f532662b = r101;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            tt5.a.h("ccm-lynx: CCMSecLabelRepeatApprovalMethod", "click cancel.");
            XCoreBridgeMethod.onSuccess$default(this.f532661a, this.f532662b, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("actionID", "cancel")}), null, 4, null);
        }
    }

    public static final class c implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f532663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f532664b;

        public c(e r100, XBridgeMethod.Callback r101) {
            this.f532663a = r100;
            this.f532664b = r101;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            tt5.a.h("ccm-lynx: CCMSecLabelRepeatApprovalMethod", "click confirm.");
            XCoreBridgeMethod.onSuccess$default(this.f532663a, this.f532664b, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("actionID", "confirm")}), null, 4, null);
        }
    }

    static {
    }

    public e() {
        this.f532659l = "ccm.permission.repeatedApprovalDialog";
    }

    @Override // qe5.d, com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f532659l;
    }

    @Override // qe5.d
    public final void g(XReadableMap r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        super.g(r100);
        String r101 = r100.getString("secLabelApprovalList");
        SecretApprovalInstanceModel r102 = null;
        if (TextUtils.isEmpty(r101) == false) goto L16;
        tt5.a.h("ccm-lynx: CCMSecLabelRepeatApprovalMethod", "parseSecretApprovalInstanceModel()...instanceModelStr is null.");
    L14:
        this.f532660m = r102;
        return;
    L16:
        SecretApprovalInstanceModel r103 = (SecretApprovalInstanceModel) new Gson().fromJson(r101, SecretApprovalInstanceModel.class);     // Catch: Exception -> L11
        r103.setSuccess(true);     // Catch: Exception -> L9
        tt5.a.h("ccm-lynx: CCMSecLabelRepeatApprovalMethod", "result = " + r103);     // Catch: Exception -> L9
        r102 = r103;
    L9:
        Exception e100 = e;
        r102 = r103;
    L13:
        tt5.a.d("ccm-lynx: CCMSecLabelRepeatApprovalMethod", "parseSecretApprovalInstanceModel()...error = " + e100);
    L11:
        e = move-exception;
        e100 = e;
        goto L13
    }

    @Override // qe5.d, com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r110, XBridgeMethod.Callback r111, XBridgePlatformType r112) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        g(r110);
        if (this.f532653f != null) goto L5;
    L39:
        tt5.a.h("ccm-lynx: CCMSecLabelRepeatApprovalMethod", "originSecLabel、targetSecLabel、secLabelApprovalDef or secretApprovalInstanceModel is null, return.");
        return;
    L5:
        if (this.f532654g == null) goto L39;
        if (this.f532655h == null) goto L39;
        if (this.f532660m == null) goto L39;
        c r100 = new c(this, r111);
        b r101 = new b(this, r111);
        Context r113 = (Context) provideContext(Context.class);
        Fragment r102 = (Fragment) provideContext(Fragment.class);
        cj5.c r114 = (cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6);
        boolean r103 = false;
        if (com.bytedance.ee.bear.middleground.permission.b.m() == true) goto L14;
    L16:
        boolean r104 = false;
    L17:
        if (r104 == false) goto L24;
        if (r102 != null) goto L20;
    L22:
        if (r103 == false) goto L24;
        r114.hb(r102, this.f532650c, r100, r101, this.f532660m, this.f532655h, this.f532654g, this.f532653f);
        return;
    L20:
        if (r102.isAdded() != true) goto L22;
        r103 = true;
    L24:
        if (r104 == true) goto L26;
    L28:
        int r105 = th5.b.f545938l;
        if (th5.b.a.a(this.f532649b) == false) goto L36;
        jg5.j r115 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        SecretApprovalInstanceModel r116 = this.f532660m;
        SecretApprovalDefModel r117 = this.f532655h;
        SecretLevel r106 = this.f532654g;
        SecretLevel r107 = this.f532653f;
        r115.getClass();
        WeakReference<th5.a> r118 = jg5.j.f499016j;
        if (r118 != null) goto L33;
        return;
    L33:
        if (r118.get() == null) goto L44;
        jg5.j.f499016j.get().QQ(r100, r101, r116, r117, r106, r107);
        return;
    L44:
        return;
    L36:
        if ((r113 instanceof FragmentActivity) == false) goto L46;
        r114.l5((FragmentActivity) r113, this.f532650c, r100, r101, this.f532660m, this.f532655h, this.f532654g, this.f532653f);
        return;
    L46:
        return;
    L26:
        if ((r113 instanceof FragmentActivity) == false) goto L28;
        r114.l5((FragmentActivity) r113, this.f532650c, r100, r101, this.f532660m, this.f532655h, this.f532654g, this.f532653f);
        return;
    L14:
        if (this.f532649b != SceneType.PASSWORD_SHARE.getValue()) goto L16;
        r104 = true;
        goto L17
    }
}
