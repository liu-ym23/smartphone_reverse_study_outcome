package com.bytedance.ug.sdk.share.impl.manager;

import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import oo7.l;
import oo7.q;
import oo7.r;
import oo7.s;
import oo7.v;
import oo7.x;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f272346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f272347b;

    public class a implements co7.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f272348a;

        public a(j r100) {
            this.f272348a = r100;
        }
    }

    public class b implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f272349a;

        public final void a() {
            j r100 = this.f272349a;
            r100.getClass();
            long r101 = System.currentTimeMillis();
            h r102 = h.g.f272345a;
            Context r103 = r102.f272326a;
            boolean r104 = false;
            if (r102.f272343r != (-1)) goto L10;
            SharedPreferences r105 = bo7.a.C0322a.f19870a.f19869a.f524630a;
            if (r105 == null) goto L7;
            int r106 = r105.getInt("use_timon", 0);
        L8:
            r102.f272343r = r106;
            goto L10
        L7:
            r106 = 0;
        L10:
            if (r102.f272343r != 1) goto L12;
            boolean r107 = true;
        L13:
            StringBuilder r108 = new StringBuilder("tryGetClipBoardText() Build.VERSION.SDK_INT = ");
            int r110 = Build.VERSION.SDK_INT;
            r108.append(r110);
            r108.append("， useTimon = ");
            r108.append(r107);
            oo7.k.e("ClipboardCompat", r108.toString());
            if (r110 < 31) goto L128;
            if (r107 == true) goto L128;
            oo7.k.e("ClipboardCompat", "tryGetClipBoardText() 系统版本大于等于12，且use_timon开关没开，走sdk内部的规则pattern校验");
            ClipboardManager r109 = ho7.a.f(r103);
            if (r109 == null) goto L127;
            ArrayList r111 = new ArrayList();
            Object[] r112 = new Object[0];
            f06.b r210 = new f06.b();
            g06.a r113 = ApiHookConfig.f245611b.get(101809);
            if (r113 == null) goto L22;
            f06.a[] r114 = r113.f479473i;
        L23:
            f06.a[] r115 = r114;
            int r116 = r115.length;
            int r117 = 0;
        L25:
            if (r117 >= r116) goto L32;
            f06.a r118 = r115[r117];
            int r211 = r117;
            int r212 = r116;
            f06.a[] r213 = r115;
            f06.d r119 = r118.preInvoke(101809, "android/content/ClipboardManager", "getPrimaryClipDescription", r109, r112, "android.content.ClipDescription", r210);     // Catch: Exception -> L140
            if (r119.f474982a == true) goto L34;
            r111.add(r118);     // Catch: Exception -> L140
        L34:
            if (r119.f474982a == false) goto L36;
            ClipDescription r120 = (ClipDescription) r119.f474983b;
        L37:
            if (r120 != null) goto L40;
            oo7.k.e("ClipboardCompat", "clipDescription 为空");
            goto L127
        L40:
            if (oo7.d.f524619a != r120.getTimestamp()) goto L42;
            oo7.k.e("ClipboardCompat", "剪切板内容没有发生变化");
            goto L127
        L42:
            oo7.d.f524619a = r120.getTimestamp();
            if (r120.getClassificationStatus() != 1) goto L45;
        L126:
            oo7.k.e("ClipboardCompat", "分类未进行或未结束");
            goto L127
        L45:
            if (r120.getClassificationStatus() == 2) goto L126;
            List<List<String>> r121 = h.g.f272345a.b();
            if (r121 != null) goto L50;
        L125:
            oo7.k.e("ClipboardCompat", "未下发口令检测策略");
            go7.b.c(2);
            goto L127
        L50:
            if (r121.isEmpty() == true) goto L125;
            Iterator<List<String>> r122 = r121.iterator();
            boolean r123 = true;
        L54:
            if (r122.hasNext() == false) goto L122;
            Iterator<String> r124 = r122.next().iterator();
            boolean r125 = true;
        L57:
            if (r124.hasNext() == false) goto L118;
            String r126 = r124.next();
            r126.getClass();
            switch(r126.hashCode()) {
                case 96417: goto L86;
                case 114715: goto L82;
                case 116079: goto L78;
                case 3076014: goto L74;
                case 3148128: goto L70;
                case 3343799: goto L66;
                case 3560141: goto L62;
                default: goto L89;
            };
        L89:
            byte r127 = -1;
        L91:
            switch(r127) {
                case 0: goto L112;
                case 1: goto L109;
                case 2: goto L106;
                case 3: goto L103;
                case 4: goto L100;
                case 5: goto L97;
                case 6: goto L94;
                default: goto L114;
            };
        L114:
            r125 = false;
        L115:
            if (r125 == true) goto L57;
        L94:
            if (r120.getConfidenceScore(SheetInputData.InputData.DateType.DATETIME) != 1.0f) goto L114;
        L113:
            r125 = true;
            goto L115
        L97:
            if (r120.getConfidenceScore("email") != 1.0f) goto L114;
        L100:
            if (r120.getConfidenceScore("flight") != 1.0f) goto L114;
        L103:
            if (r120.getConfidenceScore("date") != 1.0f) goto L114;
        L106:
            if (r120.getConfidenceScore("url") != 1.0f) goto L114;
        L109:
            if (r120.getConfidenceScore("phone") != 1.0f) goto L114;
        L112:
            if (r120.getConfidenceScore("address") != 1.0f) goto L114;
        L62:
            if (r126.equals("time") == false) goto L89;
            r127 = 6;
            goto L91
        L66:
            if (r126.equals(IOfflineExtraParser.ParserType.MAIL) == false) goto L89;
            r127 = 5;
            goto L91
        L70:
            if (r126.equals("fnum") == false) goto L89;
            r127 = 4;
            goto L91
        L74:
            if (r126.equals("date") == false) goto L89;
            r127 = 3;
            goto L91
        L78:
            if (r126.equals("url") == false) goto L89;
            r127 = 2;
            goto L91
        L82:
            if (r126.equals("tel") == false) goto L89;
            r127 = 1;
            goto L91
        L86:
            if (r126.equals("add") == false) goto L89;
            r127 = 0;
        L118:
            r123 = r125;
            if (r123 == false) goto L54;
        L122:
            if (r123 == false) goto L124;
            oo7.k.e("ClipboardCompat", "剪切板内容匹配检测成功");
            go7.b.c(0);
            String r128 = oo7.d.b(r103);
        L129:
            oo7.k.e("TokenCheckerManager", "get clipboard spent = " + (System.currentTimeMillis() - r101));
            if (TextUtils.isEmpty(r128) == false) goto L138;
            s r129 = new s();
            Handler r130 = l.f524628a;
            if (Looper.myLooper() != Looper.getMainLooper()) goto L134;
            r104 = true;
        L134:
            if (r104 == false) goto L136;
            r129.run();
        L137:
            oo7.k.e("TokenCheckerManager", "clipboard text is null");
            oo7.d.c(1, "剪切板内容为空");
            goto L138
        L136:
            l.f524628a.post(r129);
        L138:
            eo7.a r131 = eo7.a.b.f473353a;
            jo7.c.a(new k(r100, true, r128));
            return;
        L124:
            oo7.k.e("ClipboardCompat", "剪切板内容匹配检测失败");
            go7.b.c(1);
            goto L127
        L36:
            r120 = r109.getPrimaryClipDescription();
        L31:
            r117 = r211 + 1;
            r116 = r212;
            r115 = r213;
            goto L25
        L32:
            r119 = new f06.d(false, null);
            goto L34
        L22:
            r114 = ApiHookConfig.f245613d;
        L127:
            r128 = "";
        L128:
            oo7.k.e("ClipboardCompat", "tryGetClipBoardText() 系统版本小于12，或者use_timon开关为true，走宿主读取剪切板");
            r128 = oo7.d.b(r103);
            goto L129
        L12:
            r107 = false;
            goto L13
        }

        public b(j r100) {
            this.f272349a = r100;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f272350a = null;

        static {
            f272350a = new j();
        }
    }

    public final void a() {
        if (eo7.a.b.f473353a.f473348v == true) goto L11;
        h r100 = h.g.f272345a;
        if (r100.f272331f == true) goto L8;
        oo7.k.e("TokenCheckerManager", "share init did not complete");
        r100.f272332g = this.f272347b;
        return;
    L8:
        b();
        return;
    }

    public final void b() {
        oo7.k.e("TokenCheckerManager", "handleToken() is called");
        r.a r100 = new r.a();
        r.f524639a = r100;
        eo7.a r101 = eo7.a.b.f473353a;
        jo7.c.a(new q("reflow", "handleToken start", null, r100));
        eo7.a r102 = eo7.a.b.f473353a;
        boolean r103 = true;
        if (r102.f473345s == true) goto L5;
    L7:
        boolean r104 = false;
    L8:
        oo7.k.e("TokenCheckerManager", "text token parse enable status is " + r104);
        JSONObject r105 = new JSONObject();
        if (r104 == false) goto L12;
        int r106 = 1;
    L26:
        r105.put("token_parse_switch", r106);     // Catch: JSONException -> L15
        r105.put("brand", Build.BRAND);     // Catch: JSONException -> L15
        r105.put("system_version", Build.VERSION.SDK_INT);     // Catch: JSONException -> L15
        r.c("check text token parse enable status", "reflow", r105, r.f524639a);     // Catch: JSONException -> L15
    L16:
        if (r104 == false) goto L24;
        v r107 = new v(new b(this));
        Handler r108 = l.f524628a;
        if (Looper.myLooper() == Looper.getMainLooper()) goto L21;
        r103 = false;
    L21:
        if (r103 == false) goto L23;
        r107.run();
        return;
    L23:
        l.f524628a.post(r107);
        return;
    L24:
        eo7.a r109 = eo7.a.b.f473353a;
        jo7.c.a(new k(this, false, ""));
        return;
    L12:
        r106 = 0;
        goto L26
    L5:
        if (((Boolean) r102.c("enable_text_token", Boolean.TRUE)).booleanValue() == false) goto L7;
        r104 = true;
        goto L8
    }

    public j() {
        this.f272346a = false;
        this.f272347b = new a(this);
    }
}
