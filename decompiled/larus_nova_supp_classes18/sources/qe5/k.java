package qe5;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.secret.PermissionControl;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.ies.xbridge.u;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k extends XCoreBridgeMethod implements fj5.b {
    public String a;
    public int b;
    public XBridgeMethod.Callback c;
    public final String d;
    public final XBridgeMethod.Access e;

    public static final class a {
    }

    static {
    }

    public k() {
        this.a = "";
        this.d = "ccm.permission.updateSecretLevel";
        this.e = XBridgeMethod.Access.PROTECT;
    }

    public final void release() {
        super.release();
        tt5.a.h("ccm-lynx: CCMUpdateSecretMethod", "release()...");
        if (TextUtils.isEmpty(this.a) == true) goto L6;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().q(this.a, this);
        return;
    }

    public final XBridgeMethod.Access getAccess() {
        return this.e;
    }

    public final String getName() {
        return this.d;
    }

    @Override // fj5.b
    public final String getRetryToken() {
        return this.a;
    }

    public static String e(String r7, XReadableMap r8) {
        String r0 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a();
        DisplayName r1 = new DisplayName();
        if (r8 == null) goto L12;
        r1.setValue(s.f(r8, "value", ""));
        XReadableMap r9 = s.e(r8, "i18n_value");
        if (r9 == null) goto L12;
        HashMap r2 = new HashMap();
        u r4 = r9.keyIterator();
    L8:
        if (r4.hasNextKey() == false) goto L10;
        String r5 = r4.nextKey();
        r2.put(r5, s.f(r9, r5, ""));
        goto L8
    L10:
        r1.setI18n_value(r2);
    L12:
        return ou5.a.a(r0, r1, r7, r7);
    }

    @Override // fj5.b
    public final void onSecretLevelChange(String r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "name");
        tt5.a.h("ccm-lynx: CCMUpdateSecretMethod", "onSecretLevelChange()...level = " + r8 + ", callback = " + this.c);
        XBridgeMethod.Callback r1 = this.c;
        if (r1 == null) goto L6;
        XCoreBridgeMethod.onSuccess$default(this, r1, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("didChanged", Boolean.TRUE)}), null, 4, null);
        return;
    }

    public final void handle(XReadableMap r85, XBridgeMethod.Callback r86, XBridgePlatformType r87) {
        Intrinsics.checkNotNullParameter(r85, "params");
        Intrinsics.checkNotNullParameter(r86, "callback");
        Intrinsics.checkNotNullParameter(r87, "platformType");
        tt5.a.h("ccm-lynx: CCMUpdateSecretMethod", "handle()...callback = " + r86);
        this.c = r86;
        FragmentActivity r2 = (Context) provideContext(Context.class);
        Fragment r13 = (Fragment) provideContext(Fragment.class);
        if ((r2 instanceof FragmentActivity) == false) goto L63;
        XReadableMap r3 = r85.getMap("meta");
        if (r3 != null) goto L8;
        tt5.a.d("ccm-lynx: CCMUpdateSecretMethod", "metaInfoObject is null, return");
        return;
    L8:
        boolean r6 = false;
        int r5 = s.d(r3, "real_sub_type", 0);
        if (r5 != 0) goto L11;
        r5 = s.d(r3, "sub_type", 0);
    L11:
        int r31 = r5;
        String r15 = r3.getString("title");
        boolean r16 = r3.getBoolean("title_secure_key_deleted");
        String r17 = s.f(r3, "create_uid", "");
        String r18 = e(s.f(r3, "create_user_name", ""), s.e(r3, "create_user_display_name"));
        String r19 = s.f(r3, "tenant_id", "");
        String r20 = s.f(r3, "owner_id", "");
        String r21 = e(s.f(r3, "owner_user_name", ""), s.e(r3, "owner_user_display_name"));
        String r22 = s.f(r3, "create_time", "");
        String r23 = s.f(r3, "sub_type", "");
        boolean r24 = r3.getBoolean("is_pined");
        boolean r25 = r3.getBoolean("is_stared");
        String r26 = s.f(r3, "app_id", "");
        String r27 = s.f(r3, "app_link", "");
        boolean r28 = r3.getBoolean("support_mobile");
        String r29 = s.f(r3, "icon", "");
        int r30 = r3.getInt(ResourceData.KEY_TYPE);
        DocMetaInfo.Companion.getClass();
        int r32 = s.d(r3, "get_sec_label_code", 3);
        int r33 = s.d(r3, "can_set_sec_label", 0);
        XReadableMap r7 = r3.getMap("sec_label");
        if (r7 != null) goto L14;
        tt5.a.h("ccm-lynx: CCMUpdateSecretMethod", "parseSecLabel()...secMap is null");
        SecretLevel r34 = new SecretLevel(null, null, null, 0, false, null, null, null, false, false, null, null, null, null, null, null, null, 131071, null);
    L55:
        DocMetaInfo r9 = new DocMetaInfo(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, s.d(r3, "template_type", 0), s.d(r3, "sec_label_type", -99999), false, s.b(r3, "double_check_default_label", false), s.b(r3, "must_set_label", false), s.f(r3, "default_label_id", ""), s.f(r3, "server_time", ""), 0, null, null, 0, null, 0, null, null, null, null, 0, -130023424, 63, null);
        r9.setUrl(s.f(r3, ResourceData.KEY_URL, ""));
        String r4 = r85.getString("realToken");
        int r8 = r85.getInt("realType");
        if (r4.length() <= 0) goto L58;
        r6 = true;
    L58:
        if (r6 == false) goto L61;
        if (r8 < 0) goto L61;
        this.a = r4;
        this.b = r8;
    L62:
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).k6(r2, this.a, this.b, r9, "", "from_permission_setting", true, r13, false);
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().o(this.a, this);
        return;
    L61:
        this.a = r85.getString(ResourceData.KEY_TOKEN);
        this.b = r85.getInt(ResourceData.KEY_TYPE);
        goto L62
    L14:
        XReadableMap r10 = r7.getMap("permission_control");
        if (r10 != null) goto L17;
        PermissionControl r11 = new PermissionControl(0, 0, 0, 0, false, 0, 0, false, 0, 0, 0, 0, 4095, null);
    L54:
        String r65 = s.f(r7, ResourceData.KEY_ID, "");
        boolean r69 = s.b(r7, "enable_protect", false);
        r34 = new SecretLevel(r65, s.f(r7, "name", ""), s.f(r7, "description", ""), r7.getInt("level"), r69, s.f(r7, "tips", ""), s.f(r7, "apply_tips", ""), r11, false, false, null, null, null, null, null, null, null, 130816, null);
        goto L55
    L17:
        if (r10.hasKey("share_entity") == false) goto L19;
        int r35 = r10.getInt("share_entity");
    L21:
        if (r10.hasKey("security_entity") == false) goto L23;
        int r36 = r10.getInt("security_entity");
    L25:
        if (r10.hasKey("comment_entity") == false) goto L27;
        int r37 = r10.getInt("comment_entity");
    L29:
        if (r10.hasKey("link_share_entity") == false) goto L31;
        int r38 = r10.getInt("link_share_entity");
    L32:
        boolean r39 = s.b(r10, "external_access_switch", false);
        if (r10.hasKey("share_external_entity") == false) goto L35;
        int r40 = r10.getInt("share_external_entity");
    L37:
        if (r10.hasKey("manage_collaborator_entity") == false) goto L39;
        int r41 = r10.getInt("manage_collaborator_entity");
    L40:
        boolean r42 = s.b(r10, "link_password_switch", false);
        if (r10.hasKey("external_access_entity") == false) goto L43;
        int r44 = r10.getInt("external_access_entity");
    L45:
        if (r10.hasKey("search_entity") == false) goto L47;
        int r45 = r10.getInt("share_entity");
    L49:
        if (r10.hasKey("disable_ai_search_entity") == false) goto L51;
        int r46 = r10.getInt("share_entity");
    L52:
        r11 = new PermissionControl(r35, r36, r37, r38, r39, r40, r41, r42, 0, r44, r45, r46, 256, null);
        goto L54
    L51:
        r46 = -1;
        goto L52
    L47:
        r45 = -1;
        goto L49
    L43:
        r44 = -1;
        goto L45
    L39:
        r41 = -1;
        goto L40
    L35:
        r40 = -1;
        goto L37
    L31:
        r38 = -1;
        goto L32
    L27:
        r37 = -1;
        goto L29
    L23:
        r36 = -1;
        goto L25
    L19:
        r35 = -1;
        goto L21
    L63:
        tt5.a.d("ccm-lynx: CCMUpdateSecretMethod", "context is not FragmentActivity, return");
    }
}
