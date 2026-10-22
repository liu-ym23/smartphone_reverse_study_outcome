package com.ss.android.lark.chameleonv2.debug;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ss.android.lark.chameleon.ChameleonBizType;
import com.ss.android.lark.officesdk.utils.di.ThreadUtil;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f411381b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, String> f411382c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, String> f411383d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, String> f411384e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w0b.a f411385a;

    public static final class a {
    }

    public f() {
    }

    static {
        f411381b = CollectionsKt.mutableListOf(new String[]{"doubao", "lark"});
        ChameleonBizType r100 = ChameleonBizType.BIZ_DOCS;
        f411382c = MapsKt.mapOf(TuplesKt.to(r100.getType(), "https://tosv.byted.org/obj/bytedance-oss-bear-web-test/scm_zip/%s/android/docs_channel.zip"));
        f411383d = MapsKt.mapOf(new Pair[]{TuplesKt.to(r100.getType(), "https://luban-source.byted.org/repository/scm/flow.mobile.office_%s.tar.gz"), TuplesKt.to(ChameleonBizType.BIZ_SLIDES.getType(), "https://luban-source.byted.org/repository/scm/flow.mobile.slides_%s.tar.gz")});
        f411384e = MapsKt.mapOf(TuplesKt.to(r100.getType(), "https://tosv.byted.org/obj/bytedance-oss-bear-web-test/flow-mobile-office/scm_zip/%s/offline_pkg.zip"));
    }

    public static String b(String r110) {
        Intrinsics.checkNotNullParameter(r110, "url");
        MatchResult r111 = Regex.find$default(new Regex("\\b\\d+(?:[._]\\d+){3}\\b"), r110, 0, 2, null);
        if (r111 == null) goto L8;
        String r100 = r111.getValue();
        if (r100 != null) goto L7;
        return null;
    L7:
        return StringsKt.replace$default(r100, '_', '.', false, 4, null);
    L8:
        return null;
    }

    public static final void a(f r100, Context r101, String r102) {
        r100.getClass();
        Lazy<Handler> r103 = ThreadUtil.f437211a;
        ThreadUtil.a.g(new q(r101, r102));
    }

    public final void d(ChameleonDebugActivity r110, boolean r111, Function0 r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        LinearLayout r100 = new LinearLayout(r110);
        boolean r101 = true;
        r100.setOrientation(1);
        r100.setPadding(32, 16, 32, 16);
        String r102 = CmlDebugSettingUtil.a("chameleon_specific_bizname", "");
        if (r111 == false) goto L5;
        String r103 = "chameleon_specific_download_url_tos";
    L6:
        String r104 = CmlDebugSettingUtil.a(r103, "");
        TextView r105 = c(r110, CmlDebugSettingUtil.a("chameleon_app_name", ""), "请选择app", f411381b, true);
        TextView r106 = new TextView(r110);
        r106.setText("bizName");
        ChameleonBizType[] r107 = ChameleonBizType.values();
        ArrayList r108 = new ArrayList(r107.length);
        int r113 = r107.length;
        int r114 = 0;
    L7:
        if (r114 >= r113) goto L9;
        r108.add(r107[r114].getType());
        r114 = r114 + 1;
        goto L7
    L9:
        TextView r109 = c(r110, r102, "请输入bizName", r108, false);
        TextView r115 = new TextView(r110);
        r115.setText("资源版本或URL");
        EditText r116 = new EditText(r110);
        if (r104.length() > 0) goto L13;
        r101 = false;
    L13:
        if (r101 == false) goto L15;
        r116.setText(r104);
        r116.setSelection(r104.length());
    L16:
        r116.setPadding(16, 16, 16, 16);
        r100.addView(r105);
        r100.addView(r106);
        r100.addView(r109);
        r100.addView(r115);
        r100.addView(r116);
        new AlertDialog.Builder(r110).setTitle("下载并设置离线资源").setView(r100).setPositiveButton("保存", new m(r105, r109, r116, r111, this, r110, r112)).setNegativeButton("取消", null).show();
        return;
    L15:
        r116.setHint("请输入版本号或下载地址");
        goto L16
    L5:
        r103 = "chameleon_specific_download_url_scm";
        goto L6
    }

    public static TextView c(ChameleonDebugActivity r100, String r101, String r102, List r103, boolean r104) {
        ArrayAdapter r105 = new ArrayAdapter(r100, R.layout.simple_dropdown_item_1line, r103);
        AutoCompleteTextView r106 = new AutoCompleteTextView(r100);
        if (r104 == false) goto L6;
        r106.setKeyListener(null);
        r106.setFocusable(false);
        r106.setFocusableInTouchMode(false);
    L6:
        if (r101.length() != 0) goto L8;
        boolean r107 = true;
    L9:
        if (r107 == true) goto L11;
        r106.setText(r101);
        r106.setSelection(r101.length());
    L12:
        r106.setPadding(16, 16, 16, 16);
        r106.setAdapter(r105);
        r106.setOnFocusChangeListener(new h(r106));
        r106.setOnClickListener(new i(r106));
        r106.setThreshold(0);
        return r106;
    L11:
        r106.setHint(r102);
        goto L12
    L8:
        r107 = false;
        goto L9
    }
}
