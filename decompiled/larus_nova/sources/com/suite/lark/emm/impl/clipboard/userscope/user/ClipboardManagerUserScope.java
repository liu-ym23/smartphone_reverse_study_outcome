package com.suite.lark.emm.impl.clipboard.userscope.user;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.text.Annotation;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import coc.f;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.google.gson.Gson;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.nova.R;
import com.ss.android.lark.audit.userscope.auth.j;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.security.protocol.clipboard.api.IClipboardProtectionApi;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.e0;
import com.suite.lark.emm.impl.clipboard.SCClipboardScene;
import com.suite.lark.emm.impl.clipboard.model.InnerClipDataModel;
import com.suite.lark.emm.impl.clipboard.model.OpenAppDataModel;
import com.suite.lark.emm.impl.clipboard.utils.d;
import doc.e;
import doc.k;
import doc.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import jdb.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes40.dex */
@UserScope
public final class ClipboardManagerUserScope implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f460446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f460447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f460448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f460449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList<ClipboardManager.OnPrimaryClipChangedListener> f460450e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.ss.android.lark.storage.kv.repo.a f460451f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.ss.android.lark.storage.kv.repo.a f460452g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f460453h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SCClipboardScene f460454i;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f460455a = null;

        static {
            int[] r100 = new int[SCClipboardScene.values().length];
            r100[SCClipboardScene.SCENE_ENCRYPT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[SCClipboardScene.SCENE_SYSTEM_ONCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[SCClipboardScene.SCENE_SYSTEM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[SCClipboardScene.SCENE_DISABLE_COPY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f460455a = r100;
        }
    }

    static {
    }

    @Override // doc.b
    public final void L3() {
        Log.i("ClipboardManagerUserScope", "clearSavedSystemClip");
        this.f460451f.putString("SP_CLIPBOARD_SYSTEM_TEXT", "");
    }

    @Override // doc.b
    public final ClipData Ma() {
        SCClipboardScene r100 = this.f460454i;
        String r101 = null;
        if (r100 != SCClipboardScene.SCENE_ENCRYPT) goto L14;
        if (r100 == null) goto L6;
        Object r102 = r100.getParam();
    L8:
        if ((r102 instanceof String) == false) goto L10;
        String r103 = (String) r102;
    L11:
        if (r103 == null) goto L23;
    L24:
        String r104 = a();
        Log.i("ClipboardManagerUserScope", "start getInnerClipData: " + r104);
        InnerClipDataModel r105 = (InnerClipDataModel) this.f460452g.getJSONObject(r104, InnerClipDataModel.class);
        if (r105 != null) goto L27;
        return null;
    L27:
        String r106 = r105.getPureText();
        String r107 = r105.getRichText();
        String r108 = r105.getHtmlText();
        String r110 = r105.getEncryptId();
        Gson r111 = e0.f444707a;
        OpenAppDataModel r112 = (OpenAppDataModel) e0.a(r103, OpenAppDataModel.class);
        boolean r113 = true;
        if (Q7() == false) goto L55;
        OpenAppDataModel r114 = r105.getOpenAppModel();
        if (r114 == null) goto L32;
        String r115 = r114.getAppID();
    L33:
        if (r115 != null) goto L35;
        if (r112 == null) goto L55;
    L35:
        OpenAppDataModel r109 = r105.getOpenAppModel();
        if (r109 == null) goto L38;
        String r116 = r109.getAppID();
    L39:
        if (r112 == null) goto L41;
        String r117 = r112.getAppID();
    L42:
        if (r112 == null) goto L44;
        r101 = r112.getUrl();
    L44:
        Iterator r118 = ClaymoreServiceLoader.loadAll(IClipboardProtectionApi.class);
    L46:
        if (r118.hasNext() == false) goto L50;
        boolean r119 = ((IClipboardProtectionApi) r118.next()).canPaste(r116, r117, r101);
        Log.i("ClipboardManagerUserScope", "can paste: " + r119 + ", data_app_id: " + r116 + ", current_app_id: " + r117);
        if (r119 == true) goto L46;
        boolean r120 = false;
    L51:
        if (r120 == true) goto L63;
        Log.i("ClipboardManagerUserScope", "show unable toast");
        return ClipData.newPlainText("larkInner", UIHelper.getString(R.string.Lark_CustomAppStratifiedMgmt_UnableToPaste_Toast));
    L63:
        Log.d("ClipboardManagerUserScope", "getInnerClipData: " + r104 + ", pureText: " + r106);
        if (r105.getRichTextType() != 3) goto L76;
        if (r107 != null) goto L67;
    L72:
        boolean r121 = false;
    L73:
        if (r121 == false) goto L76;
        String r122 = r105.getPureText();
        String r123 = r105.getRichText();
        SpannableStringBuilder r124 = new SpannableStringBuilder(r122);
        r124.setSpan(new Annotation("com.lartsuite.im.RichTextCopyUtils", r123), 0, r122.length(), 33);
        return ClipData.newPlainText("larkInner", r124);
    L67:
        if (r107.length() <= 0) goto L69;
        boolean r125 = true;
    L70:
        if (r125 != true) goto L72;
        r121 = true;
        goto L73
    L69:
        r125 = false;
    L76:
        if (r105.getRichTextType() != 5) goto L88;
        if (r108 != null) goto L79;
    L84:
        boolean r126 = false;
    L85:
        if (r126 == false) goto L88;
        String r127 = r105.getPureText();
        SpannableStringBuilder r128 = new SpannableStringBuilder(r127);
        r128.setSpan(new Annotation("com.lartsuite.im.RichTextCopyUtils", "com.lartsuite.normalText"), 0, r127.length(), 33);
        return ClipData.newHtmlText("larkInner", r128, r105.getHtmlText());
    L79:
        if (r108.length() <= 0) goto L81;
        boolean r129 = true;
    L82:
        if (r129 != true) goto L84;
        r126 = true;
        goto L85
    L81:
        r129 = false;
    L88:
        if (r105.getRichTextType() != 7) goto L108;
        if (r107 != null) goto L91;
    L96:
        boolean r130 = false;
    L97:
        if (r130 == false) goto L108;
        if (r108 != null) goto L100;
    L105:
        r113 = false;
    L106:
        if (r113 == false) goto L108;
        String r131 = r105.getPureText();
        String r132 = r105.getRichText();
        SpannableStringBuilder r133 = new SpannableStringBuilder(r131);
        r133.setSpan(new Annotation("com.lartsuite.im.RichTextCopyUtils", r132), 0, r131.length(), 33);
        return new ClipData(new ClipDescription("larkInner", new String[]{"text/plain", "text/html"}), new ClipData.Item(r133, r105.getHtmlText()));
    L100:
        if (r108.length() <= 0) goto L102;
        boolean r134 = true;
    L103:
        if (r134 != true) goto L105;
    L102:
        r134 = false;
        goto L103
    L91:
        if (r107.length() <= 0) goto L93;
        boolean r135 = true;
    L94:
        if (r135 != true) goto L96;
        r130 = true;
        goto L97
    L93:
        r135 = false;
    L108:
        String r136 = r105.getPureText();
        SpannableStringBuilder r137 = new SpannableStringBuilder(r136);
        r137.setSpan(new Annotation("com.lartsuite.im.RichTextCopyUtils", "com.lartsuite.normalText"), 0, r136.length(), 33);
        return ClipData.newPlainText("larkInner", r137);
    L50:
        r120 = true;
        goto L51
    L41:
        r117 = null;
        goto L42
    L38:
        r116 = null;
        goto L39
    L32:
        r115 = null;
    L55:
        if (r110.length() <= 0) goto L57;
        boolean r138 = true;
    L58:
        if (r138 == false) goto L63;
        if (Intrinsics.areEqual(r110, r103) == true) goto L63;
        Log.i("ClipboardManagerUserScope", "encryptId not same, return null clip data");
        return ClipData.newPlainText("larkInner", "");
    L57:
        r138 = false;
    L23:
        r103 = "";
        goto L24
    L10:
        r103 = null;
        goto L11
    L6:
        r102 = null;
        goto L8
    L14:
        if (r100 != SCClipboardScene.SCENE_OPEN_APP) goto L23;
        if (r100 == null) goto L17;
        Object r139 = r100.getParam();
    L19:
        if ((r139 instanceof String) == false) goto L21;
        r103 = (String) r139;
    L22:
        if (r103 != null) goto L24;
    L21:
        r103 = null;
        goto L22
    L17:
        r139 = null;
        goto L19
    }

    @Override // doc.e
    public final boolean Q7() {
        return this.f460448c.isEnable("lark.security.open_app_paste_protection");
    }

    @Override // doc.b
    public final void Sd() {
        SCClipboardScene r100 = this.f460454i;
        if (r100 != SCClipboardScene.SCENE_ENCRYPT) goto L24;
        Ob(SCClipboardScene.SCENE_DEFAULT);
    L24:
        ClipData r101 = qf7.a.f532746a.d((ClipboardManager) this.f460449d.getValue(), new Token("LARK-PSDA-scs_internal_save_system_clip"));     // Catch: SensitiveAPIException -> L7
    L8:
        Ob(r100);
        if (r101 != null) goto L11;
        return;
    L11:
        Intrinsics.checkNotNullParameter(r101, "clipData");
        Log.i("ClipboardManagerUserScope", "maySaveSystemClip");
        if (r101.getDescription() != null) goto L14;
        return;
    L14:
        if (r101.getDescription().getLabel() != null) goto L16;
    L17:
        CharSequence r102 = com.suite.lark.emm.impl.clipboard.utils.a.c(r101);
        if (r102.length() <= 0) goto L20;
        boolean r103 = true;
    L21:
        if (r103 == false) goto L28;
        Log.d("ClipboardManagerUserScope", "saveSystemClip: " + r102);
        this.f460451f.putString("SP_CLIPBOARD_SYSTEM_TEXT", r102.toString());
        return;
    L28:
        return;
    L20:
        r103 = false;
        goto L21
    L16:
        if (Intrinsics.areEqual("larkInner", r101.getDescription().getLabel().toString()) == false) goto L17;
        return;
    L7:
        r101 = null;
        goto L8
    }

    @Override // doc.b
    public final int Ua() {
        Log.i("ClipboardManagerUserScope", "setTo: " + this.f460454i);
        f.f24672a.f24670c.a();
        SCClipboardScene r100 = this.f460454i;
        if (r100 != null) goto L5;
        int r101 = -1;
    L6:
        int r102 = 1;
        if (r101 != 1) goto L9;
    L19:
        StringBuilder r103 = new StringBuilder("setTo: ");
        r103.append(r102);
        r103.append(", ");
        SCClipboardScene r104 = this.f460454i;
        if (r104 == null) goto L22;
        Object r105 = r104.getParam();
    L23:
        r103.append(r105);
        Log.i("ClipboardManagerUserScope", r103.toString());
        return r102;
    L22:
        r105 = null;
        goto L23
    L9:
        if (r101 != 2) goto L11;
    L18:
        r102 = 0;
        goto L19
    L11:
        if (r101 == 3) goto L18;
        if (r101 != 4) goto L15;
        r102 = 2;
        goto L19
    L15:
        if (X4() == false) goto L18;
    L5:
        r101 = b.f460455a[r100.ordinal()];
        goto L6
    }

    public final boolean X4() {
        f.f24672a.f24670c.a();
        if (this.f460447b.isInit() == true) goto L6;
        Log.i("ClipboardManagerUserScope", "AuditManager not init");
        return false;
    L6:
        int r100 = this.f460447b.c(21);
        Log.i("ClipboardManagerUserScope", "auditPermission: " + r100);
        if (o3(r100) != 1) goto L11;
        return true;
    L11:
        return false;
    }

    public final String a() {
        return "SP_CLIPBOARD_INNER_" + this.f460453h;
    }

    @Override // doc.b
    public final void wa() {
        Log.i("ClipboardManagerUserScope", "resetCustomScene");
        this.f460454i = null;
    }

    @Override // doc.b
    public final boolean E6() {
        if (this.f460452g.getJSONObject(a(), InnerClipDataModel.class) == null) goto L5;
        boolean r100 = true;
    L6:
        Log.i("ClipboardManagerUserScope", "hasInnerClipData: " + r100);
        return r100;
    L5:
        r100 = false;
        goto L6
    }

    @Override // doc.e
    public final void Ob(SCClipboardScene r100) {
        StringBuilder r101 = new StringBuilder("setCustomScene ");
        r101.append(r100);
        r101.append(", ");
        if (r100 == null) goto L5;
        Object r102 = r100.getParam();
    L6:
        r101.append(r102);
        Log.i("ClipboardManagerUserScope", r101.toString());
        this.f460454i = r100;
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // doc.b
    public final void Ze(ClipData r110) {
        Intrinsics.checkNotNullParameter(r110, "clipData");
        SCClipboardScene r100 = this.f460454i;
        if (r100 != SCClipboardScene.SCENE_DISABLE_COPY) goto L7;
        Log.i("ClipboardManagerUserScope", "saveClipDataToInner but copy disabled");
        return;
    L7:
        if (r100 != SCClipboardScene.SCENE_ENCRYPT) goto L18;
        if (r100 == null) goto L10;
        Object r101 = r100.getParam();
    L12:
        if ((r101 instanceof String) == false) goto L14;
        String r102 = (String) r101;
    L15:
        if (r102 == null) goto L27;
    L28:
        CharSequence r103 = com.suite.lark.emm.impl.clipboard.utils.a.c(r110);
        String r111 = com.suite.lark.emm.impl.clipboard.utils.a.b(r110);
        boolean r104 = false;
        if (r103.length() != 0) goto L31;
        boolean r105 = true;
    L32:
        if (r105 == true) goto L34;
    L39:
        l r106 = this.f460446a;
        SCClipboardScene r112 = this.f460454i;
        r106.getClass();
        UICallbackExecutor.post(new k(r106, r112));
        String r113 = a();
        boolean r107 = r103 instanceof Spanned;
        if (r107 == false) goto L42;
        Spanned r114 = (Spanned) r103;
    L44:
        if (r114 == null) goto L63;
        Object[] r115 = ((Spanned) r103).getSpans(0, r103.length(), Annotation.class);
        int r116 = r115.length;
        int r117 = 0;
    L46:
        if (r117 >= r116) goto L51;
        Object r118 = r115[r117];
        if (Intrinsics.areEqual(((Annotation) r118).getKey(), "com.lartsuite.im.RichTextCopyUtils") == true) goto L52;
        r117 = r117 + 1;
    L52:
        Annotation r119 = (Annotation) r118;
        if (r119 == null) goto L55;
        String r108 = r119.getValue();
    L56:
        if (r108 != null) goto L58;
    L61:
        boolean r109 = true;
    L62:
        boolean r120 = !r109;
    L64:
        if (r120 == false) goto L66;
        int r121 = 3;
    L68:
        if (r110.getDescription().hasMimeType("text/html") == true) goto L70;
    L75:
        int r122 = r121;
    L76:
        if (r107 == false) goto L78;
        Spanned r123 = (Spanned) r103;
    L79:
        if (r123 == null) goto L92;
        Object[] r124 = ((Spanned) r103).getSpans(0, r103.length(), Annotation.class);
        int r125 = r124.length;
        int r126 = 0;
    L81:
        if (r126 >= r125) goto L86;
        Object r127 = r124[r126];
        if (Intrinsics.areEqual(((Annotation) r127).getKey(), "com.lartsuite.im.RichTextCopyUtils") == true) goto L87;
        r126 = r126 + 1;
    L87:
        Annotation r128 = (Annotation) r127;
        if (r128 == null) goto L90;
        String r129 = r128.getValue();
    L91:
        String r130 = r129;
    L94:
        if (this.f460454i != SCClipboardScene.SCENE_OPEN_APP) goto L97;
        r104 = true;
    L97:
        if (Q7() == false) goto L100;
        if (r104 == false) goto L100;
        Gson r131 = e0.f444707a;
        OpenAppDataModel r132 = (OpenAppDataModel) e0.a(r102, OpenAppDataModel.class);
    L101:
        com.ss.android.lark.storage.kv.repo.a r133 = this.f460452g;
        String r134 = r103.toString();
        if (r104 == false) goto L104;
        String r135 = "";
    L105:
        r133.putJSONObject(r113, new InnerClipDataModel(r134, r122, r130, r111, r135, r132));
        Iterator<ClipboardManager.OnPrimaryClipChangedListener> r136 = this.f460450e.iterator();
    L107:
        if (r136.hasNext() == false) goto L109;
        r136.next().onPrimaryClipChanged();
        goto L107
    L109:
        d.a((ClipboardManager) this.f460449d.getValue());
        Log.d("ClipboardManagerUserScope", "saveClipDataToInner: " + r103);
        return;
    L104:
        r135 = r102;
    L100:
        r132 = null;
        goto L101
    L90:
        r129 = null;
        goto L91
    L86:
        r127 = null;
        goto L87
    L92:
        r130 = null;
        goto L94
    L78:
        r123 = null;
        goto L79
    L70:
        if (r111.length() <= 0) goto L72;
        boolean r137 = true;
    L73:
        if (r137 == false) goto L75;
        r122 = r121 | 4;
        goto L76
    L72:
        r137 = false;
        goto L73
    L66:
        r121 = 1;
        goto L68
    L58:
        if (r108.length() == 0) goto L61;
        r109 = false;
        goto L62
    L55:
        r108 = null;
        goto L56
    L51:
        r118 = null;
        goto L52
    L63:
        r120 = false;
        goto L64
    L42:
        r114 = null;
        goto L44
    L34:
        if (r111.length() != 0) goto L36;
        boolean r138 = true;
    L37:
        if (r138 == false) goto L39;
        return;
    L36:
        r138 = false;
        goto L37
    L31:
        r105 = false;
    L27:
        r102 = "";
        goto L28
    L14:
        r102 = null;
        goto L15
    L10:
        r101 = null;
        goto L12
    L18:
        if (r100 != SCClipboardScene.SCENE_OPEN_APP) goto L27;
        if (r100 == null) goto L21;
        Object r139 = r100.getParam();
    L23:
        if ((r139 instanceof String) == false) goto L25;
        r102 = (String) r139;
    L26:
        if (r102 != null) goto L28;
    L25:
        r102 = null;
        goto L26
    L21:
        r139 = null;
        goto L23
    }

    public final boolean b(ClipData r100) {
        if (r100 == null) goto L14;
        CharSequence r101 = com.suite.lark.emm.impl.clipboard.utils.a.c(r100);
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.length() <= 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L15;
        String r103 = this.f460451f.getString("SP_CLIPBOARD_SYSTEM_TEXT", "");
        boolean r104 = !StringsKt.equals$default(r103, r101.toString(), false, 2, null);
        Log.i("ClipboardManagerUserScope", "isNewOutClipData: " + r104);
        Log.d("ClipboardManagerUserScope", "localSysClip: " + r103 + ", sysClip: " + r101);
        return r104;
    L15:
        return false;
    L10:
        r102 = false;
        goto L11
    L14:
        return false;
    }

    @Override // doc.e
    public final void d(ClipboardManager.OnPrimaryClipChangedListener r210) {
        if (r210 != null) goto L5;
    L7:
        ClipboardManager r100 = (ClipboardManager) this.f460449d.getValue();
        ArrayList r110 = new ArrayList();
        Object[] r111 = {r210};
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101802);
        if (r101 == null) goto L10;
        f06.a[] r102 = r101.f479473i;
    L11:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L13:
        if (r104 >= r103) goto L20;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        f06.a[] r211 = r113;
        f06.d r106 = r105.preInvoke(101802, "android/content/ClipboardManager", "removePrimaryClipChangedListener", r100, r111, "void", r112);     // Catch: Exception -> L26
        if (r106.f474982a == true) goto L22;
        r110.add(r105);     // Catch: Exception -> L26
    L22:
        if (r106.f474982a == true) goto L32;
        r100.removePrimaryClipChangedListener(r210);
        return;
    L32:
        return;
    L19:
        r104 = r114 + 1;
        r103 = r115;
        r113 = r211;
        goto L13
    L20:
        r106 = new f06.d(false, null);
        goto L22
    L10:
        r102 = ApiHookConfig.f245613d;
        goto L11
    L5:
        if (this.f460450e.contains(r210) == false) goto L7;
        this.f460450e.remove(r210);
        goto L7
    }

    @Override // doc.e
    public final void e(ClipboardManager.OnPrimaryClipChangedListener r210) {
        if (this.f460450e.contains(r210) == true) goto L5;
        this.f460450e.add(r210);
    L5:
        ClipboardManager r100 = (ClipboardManager) this.f460449d.getValue();
        ArrayList r110 = new ArrayList();
        Object[] r111 = {r210};
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101801);
        if (r101 == null) goto L8;
        f06.a[] r102 = r101.f479473i;
    L9:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L18;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        f06.a[] r211 = r113;
        f06.d r106 = r105.preInvoke(101801, "android/content/ClipboardManager", "addPrimaryClipChangedListener", r100, r111, "void", r112);     // Catch: Exception -> L24
        if (r106.f474982a == true) goto L20;
        r110.add(r105);     // Catch: Exception -> L24
    L20:
        if (r106.f474982a == true) goto L30;
        r100.addPrimaryClipChangedListener(r210);
        return;
    L30:
        return;
    L17:
        r104 = r114 + 1;
        r103 = r115;
        r113 = r211;
        goto L11
    L18:
        r106 = new f06.d(false, null);
        goto L20
    L8:
        r102 = ApiHookConfig.f245613d;
        goto L9
    }

    @Override // doc.e
    public final int o3(int r100) {
        int r101 = this.f460452g.getInt("emm_sc_audit_permission_" + this.f460453h, 0);
        if (r100 != 4) goto L5;
        return r101;
    L5:
        String r102 = "emm_sc_audit_permission_" + this.f460453h;
        if (r100 != 1) goto L9;
        if (r101 == 1) goto L9;
        l r103 = this.f460446a;
        r103.getClass();
        Log.i("SCClipboardManager", "resetTipsMark");
        r103.f469547c.putInt("sc_clipboard_dialog_play_times", 0);
        r103.f469547c.putBoolean("sc_clipboard_dialog_blocked", false);
    L9:
        if (r101 == r100) goto L11;
        this.f460452g.putInt(r102, r100);
    L11:
        return r100;
    }

    @Override // doc.b
    public final int xb(ClipData r100) {
        Log.i("ClipboardManagerUserScope", "getFrom: " + this.f460454i);
        f.f24672a.f24670c.a();
        SCClipboardScene r101 = this.f460454i;
        if (r101 != null) goto L5;
        int r102 = -1;
    L6:
        int r103 = 1;
        if (r102 == 1) goto L21;
        if (r102 == 2) goto L18;
        if (r102 == 3) goto L18;
        if (X4() == true) goto L15;
    L22:
        r103 = 0;
    L23:
        StringBuilder r104 = new StringBuilder("getFrom: ");
        r104.append(r103);
        r104.append(", ");
        SCClipboardScene r105 = this.f460454i;
        if (r105 == null) goto L26;
        Object r106 = r105.getParam();
    L27:
        r104.append(r106);
        Log.i("ClipboardManagerUserScope", r104.toString());
        return r103;
    L26:
        r106 = null;
        goto L27
    L15:
        if (b(r100) == true) goto L22;
    L18:
        if (b(r100) == false) goto L23;
    L21:
        if (b(r100) == false) goto L23;
    L5:
        r102 = b.f460455a[r101.ordinal()];
        goto L6
    }

    @Inject
    public ClipboardManagerUserScope(com.ss.android.lark.storage.kv.storage.a r100, com.ss.android.lark.storage.kv.storage.a r101, l r102, yzb.a r103, j r104, g r105) {
        Intrinsics.checkNotNullParameter(r100, "globalKV");
        Intrinsics.checkNotNullParameter(r101, "userKV");
        Intrinsics.checkNotNullParameter(r102, "tipsHelper");
        Intrinsics.checkNotNullParameter(r103, "userApi");
        Intrinsics.checkNotNullParameter(r104, "authorizationManager");
        Intrinsics.checkNotNullParameter(r105, "userFG");
        this.f460446a = r102;
        this.f460447b = r104;
        this.f460448c = r105;
        this.f460449d = LazyKt.lazy(ClipboardManagerUserScope$clipboardManager$2.INSTANCE);
        this.f460450e = new CopyOnWriteArrayList();
        com.ss.android.lark.storage.a r106 = com.suite.lark.emm.impl.clipboard.utils.b.f460469a;
        Intrinsics.checkNotNullParameter(r100, "global");
        LarkKVStorage r107 = LarkKVStorage.f440926a;
        com.ss.android.lark.storage.a r108 = com.suite.lark.emm.impl.clipboard.utils.b.f460469a;
        r107.getClass();
        this.f460451f = LarkKVStorage.k(r100, r108, "common");
        Intrinsics.checkNotNullParameter(r101, "user");
        r107.getClass();
        this.f460452g = LarkKVStorage.l(r101, r108, "common");
        this.f460453h = r103.getTenantInfo().getTenantId();
    }
}
