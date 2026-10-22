package com.bytedance.ee.bear.list;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.DocObjInfo;
import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.WikiNavInfo;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.dto.ObjBizType;
import com.bytedance.ee.bear.list.folder.complaint.FolderComplaintActivity;
import com.bytedance.ee.bear.list.more.itemv2.ShareItemV2;
import com.bytedance.ee.bear.list.offlinecache.ManualOfflineConfig;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.framework.utils.DeviceUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t0 {
    public static final String[] a = null;

    public static String o(boolean r0) {
        if (r0 == false) goto L4;
        return "grid_more";
    L4:
        return "left_slide";
    }

    static {
        a = new String[]{ShareItemV2.SHARE_ID, "moveV2", "rename", "copy_link", "permission", "transfer_apply"};
    }

    public static List<String> l() {
        ArrayList r0 = new ArrayList();
        r0.add(String.valueOf(sbb.e.f.b));
        r0.add(String.valueOf(sbb.e.g.b));
        r0.add(String.valueOf(sbb.e.h.b));
        r0.add(String.valueOf(sbb.e.i.b));
        r0.add(String.valueOf(sbb.e.k.b));
        r0.add(String.valueOf(sbb.e.l.b));
        r0.add(String.valueOf(sbb.e.m.b));
        r0.add(String.valueOf(sbb.e.o.b));
        r0.add(String.valueOf(sbb.e.t.b));
        r0.add(String.valueOf(sbb.e.u.b));
        return r0;
    }

    public static boolean s() {
        if ((!((com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.b.class)).isFeishuBrand()) == true) goto L5;
        return true;
    L5:
        return com.bytedance.ee.bear.appsetting.c.a.a.i("mindnote_enabled", false);
    }

    public static String d() {
        return eu5.b.a().getString(2131889467);
    }

    public static uc5.p1 A(Throwable r6) {
        if ((r6 instanceof NetService.ServerErrorException) == true) goto L9;
    L8:
        return null;
    L9:
        tt5.a.h("DocumentUtils", "throwable:" + r6);     // Catch: JSONException -> L6
        uc5.p1 r1 = new uc5.p1();     // Catch: JSONException -> L6
        JSONObject r2 = new JSONObject(new JSONObject(new JSONObject(((NetService.ServerErrorException) r6).getJson()).optString("meta")).optString("owner"));     // Catch: JSONException -> L6
        r2.optString("tenant_id");     // Catch: JSONException -> L6
        String r7 = r2.optString("name", "");     // Catch: JSONException -> L6
        r1.a = ou5.a.d(((com.bytedance.ee.bear.contract.i0) org.koin.java.a.a(com.bytedance.ee.bear.contract.i0.class)).a(), r2.optString("display_name"), r7, r7);     // Catch: JSONException -> L6
        r1.b = r2.optBoolean("can_apply_perm");     // Catch: JSONException -> L6
        return r1;
    L6:
        e = move-exception;
        tt5.a.d("DocumentUtils", "parse name form throwable error, error msg:" + e.getMessage());
        goto L8
    }

    public static void B(Bitmap r9) {
        if (r9 != null) goto L5;
        tt5.a.d("DocumentUtils", "putViewSnapshot()...failed for bitmap  is null");
        return;
    L5:
        float r1 = (500 * 1024.0f) / r9.getAllocationByteCount();
        Matrix r7 = new Matrix();
        r7.setScale(r1, r1);
        com.larksuite.framework.utils.h0.a.a.b("search_title_bitmap", Bitmap.createBitmap(r9, 0, 0, r9.getWidth(), r9.getHeight(), r7, true));
    }

    public static void K(com.bytedance.ee.bear.route.h r3) {
        String r0 = jcb.b.c().a("applink");
        if (TextUtils.isEmpty(r0) == true) goto L6;
        r3.u5(String.format("https://%s/TdSgr1y9", new Object[]{r0}));
        return;
    }

    public static boolean c(Document r3) {
        if (r3.getType() != sbb.e.f.b) goto L5;
        return true;
    L5:
        if (TextUtils.isEmpty(r3.u) == true) goto L8;
        return true;
    L8:
        if (r3.b2 == false) goto L10;
    L22:
        return false;
    L10:
        if (r3.w == false) goto L18;
        if (r3.getType() == sbb.e.n.b) goto L18;
        if (r3.getType() == sbb.e.i.b) goto L18;
        if (r3.getType() == sbb.e.m.b) goto L18;
        return true;
    L18:
        if (r3.getType() != sbb.e.n.b) goto L22;
        if (r3.x2 == false) goto L22;
        return true;
    }

    public static String i(Document r3) {
        if (NodeType.isShortcut(r3.M1) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L14;
        if (TextUtils.isEmpty(r3.p2) == true) goto L14;
        return UriProtector.parse(r3.p).buildUpon().path(s45.p.a().a9(sbb.e.n.getType(), r3.p2)).build().toString();
    L14:
        if (TextUtils.isEmpty(r3.p) == false) goto L16;
        t45.c r1 = s45.p.a();
        String r2 = sbb.e.f(r3.getType());
        if (TextUtils.isEmpty(r3.d) == true) goto L20;
        String r4 = r3.d;
    L22:
        return r1.ua(r2, r4, null);
    L20:
        r4 = r3.u;
        goto L22
    L16:
        return r3.p;
    L5:
        if (r3.h2 != ObjBizType.WIKI.getType()) goto L7;
        r0 = true;
        goto L8
    }

    public static String m(Document r1) {
        if (NodeType.isShortcut(r1.M1) == true) goto L5;
        return "";
    L5:
        return r1.c;
    }

    public static Bitmap q(View r5) {
        if (r5 != null) goto L6;
        tt5.a.d("DocumentUtils", "getViewSnapshot()...failed for view is null");
        return null;
    L6:
        r5.invalidate();
        r5.setDrawingCacheEnabled(true);
        Bitmap r2 = r5.getDrawingCache();
        if (r2 != null) goto L9;
        r5.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        r5.layout(0, 0, r5.getMeasuredWidth(), r5.getMeasuredHeight());
        r5.buildDrawingCache();
        Bitmap r3 = Bitmap.createBitmap(r5.getDrawingCache());
    L10:
        r5.setDrawingCacheEnabled(false);
        if (r3 != null) goto L14;
        tt5.a.d("DocumentUtils", "getViewSnapshot()...failed for getBitmapFromView");
        return null;
    L14:
        return r3;
    L9:
        r3 = Bitmap.createBitmap(r2);
        goto L10
    }

    public static boolean v(Document r9) {
        if (r9.getType() == sbb.e.l.b) goto L5;
        return false;
    L5:
        long r0 = yu5.c.g(r9.l, 0);
        long r5 = yu5.c.g(r9.j, 0);
        long r7 = r0 - r5;
        if (r0 != 0) goto L8;
        return false;
    L8:
        if (r5 != 0) goto L10;
        return false;
    L10:
        if (r7 >= 0) goto L12;
        return false;
    L12:
        if (r7 >= 3) goto L18;
        return true;
    L18:
        return false;
    }

    public static void x(com.bytedance.ee.bear.route.h r2) {
        r2.w2("/list/template4/activity").i("MODULE", "home").i("ROOT_TOKEN", "").i("openTemplateCenter", null).i("templateCategory", null).i("enterSource", "space_icon").i("template_source", "space_template").e();
    }

    public static void y(com.bytedance.ee.bear.contract.p0 r14) {
        FragmentActivity r0 = r14.getActivity();
        Document r5 = r14.b;
        if (b(r0, r5, "share") == false) goto L5;
        return;
    L5:
        com.bytedance.ee.bear.contract.d r2 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        boolean r3 = false;
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L9;
        Toast.showFailureText(r0, r0.getString(2131887951), 0);
        return;
    L9:
        r5.p = a(r5, r14.d, "");
        AccountService.Account r1 = r14.c;
        if (r1 == null) goto L16;
        String r4 = r1.uid;
        if (r4 == null) goto L16;
        if (TextUtils.equals(r5.e, r4) == false) goto L16;
        boolean r6 = true;
    L17:
        boolean r7 = TextUtils.equals(r14.f, "grid_more");
        String r8 = ou5.a.b(((com.bytedance.ee.bear.contract.i0) org.koin.java.a.a(com.bytedance.ee.bear.contract.i0.class)).a(), r5.r, r5.s);
        String r9 = r5.G1;
        int r10 = r5.y1;
        if (TextUtils.isEmpty(r9) == false) goto L21;
        r9 = r5.d;
        r10 = r5.getType();
    L21:
        if (TextUtils.isEmpty(r9) == false) goto L24;
        r9 = r5.c;
        r10 = r5.getType();
    L24:
        if (r5.getType() != sbb.e.f.b) goto L29;
        ShareParams r11 = new ShareParams.ShareParamsBuilder(r0).source(r7 ? 1 : 0).type(r5.getType()).docName(g(r0, r5)).token(r5.d).realToken(r9).realType(r10).url(i(r5)).originUrl(r5.p).isOwner(r6).createTime(r5.j).ownerUid(r5.e).ownerName(r8).module(r14.d).subModule(r14.e).spaceId(r5.m).isShareRoot(r5.n).ownerTenantId(r5.f).folderVersion(new FolderVersion(r5.L1, r5.T, r5.P1)).build();
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.b(r5.getType()) == false) goto L28;
        ((cj5.c) org.koin.java.a.a(cj5.c.class)).fa(r11);
    L59:
        lc5.f.l(new lc5.n(r2, r14.c, "share", r5, r14.d, r14.f));
        return;
    L28:
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).Z9(r11);
        goto L59
    L29:
        int r12 = r5.getType();
        long r13 = r5.G;
        if (r10 <= 0) goto L33;
        r12 = r10;
    L33:
        if (r12 != 113) goto L35;
        boolean r15 = true;
    L36:
        if (r15 == true) goto L38;
    L40:
        boolean r16 = false;
    L41:
        ShareParams.ShareParamsBuilder r17 = new ShareParams.ShareParamsBuilder(r0, r14.g).source(r7 ? 1 : 0).type(r5.getType()).passwordSharingEnable(!r16).docName(g(r0, r5)).token(r5.d).realToken(r9).realType(r10).url(i(r5)).originUrl(r5.p).isOwner(r6).createTime(r5.j).ownerUid(r5.e).module(r14.d).subModule(r14.e);
        if (r5.getType() != sbb.e.n.b) goto L44;
        boolean r18 = true;
    L45:
        ShareParams.ShareParamsBuilder r19 = r17.isWiki(r18).subType(r5.F).isAtVC(false);
        if (NodeType.isShortcut(r5.M1) == true) goto L48;
    L50:
        boolean r20 = false;
    L51:
        if (r20 == true) goto L53;
    L55:
        ShareParams r21 = r19.wikiShortcutInSpace(r3).build();
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.b(r5.getType()) == false) goto L58;
        ((cj5.c) org.koin.java.a.a(cj5.c.class)).id(r21, null);
        goto L59
    L58:
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).aa(r21, null, null);
        goto L59
    L53:
        if (TextUtils.isEmpty(r5.p2) == true) goto L55;
        r3 = true;
        goto L55
    L48:
        if (r5.h2 != ObjBizType.WIKI.getType()) goto L50;
        r20 = true;
        goto L51
    L44:
        r18 = false;
        goto L45
    L38:
        if (r13 != 147) goto L40;
        r16 = true;
        goto L41
    L35:
        r15 = false;
    L16:
        r6 = false;
        goto L17
    }

    public static String C(Context r4, Document r5) {
        return xo5.a.c(r4, 2131887885, SheetInputData.InputData.DateType.TIME, zu5.a.e(r4, yu5.c.g(r5.j, 0) * 1000));
    }

    public static String D(Context r4, Document r5) {
        return xo5.a.c(r4, 2131889604, SheetInputData.InputData.DateType.TIME, zu5.a.e(r4, yu5.c.g(r5.i, 0) * 1000));
    }

    public static String E(Context r5, Document r6) {
        long r3 = yu5.c.g(r6.M, 0);
        if (r3 != 0) goto L6;
        r3 = yu5.c.g(r6.N, 0);
    L6:
        return xo5.a.c(r5, 2131889604, SheetInputData.InputData.DateType.TIME, zu5.a.e(r5, r3 * 1000));
    }

    public static String G(Context r4, Document r5) {
        return xo5.a.c(r4, 2131888011, SheetInputData.InputData.DateType.TIME, zu5.a.e(r4, yu5.c.g(r5.l, 0) * 1000));
    }

    public static String H(Context r4, Document r5) {
        return xo5.a.c(r4, 2131889605, SheetInputData.InputData.DateType.TIME, zu5.a.e(r4, yu5.c.g(r5.l, 0) * 1000));
    }

    public static void J(Document r3, Fragment r4) {
        Intent r0 = new Intent(r4.getContext(), FolderComplaintActivity.class);
        r0.putExtra(ResourceData.KEY_TOKEN, r3.d);
        r0.putExtra(ResourceData.KEY_TYPE, r3.getType());
        r0.putExtra("title", r3.a);
        r0.putExtra("desc", r3.S1);
        r4.startActivityForResult(r0, 1);
    }

    public static String e(Context r2, int r3) {
        if (r2 != null) goto L6;
        tt5.a.h("DocumentUtils", "context is null");
        return "";
    L6:
        if (r3 != sbb.e.g.b) goto L10;
        return r2.getResources().getString(2131888007);
    L10:
        if (r3 != sbb.e.h.b) goto L14;
        return r2.getResources().getString(2131888010);
    L14:
        if (r3 != sbb.e.i.b) goto L18;
        return r2.getResources().getString(2131888006);
    L18:
        if (r3 != sbb.e.k.b) goto L22;
        return r2.getResources().getString(2131888009);
    L22:
        if (r3 != sbb.e.l.b) goto L26;
        return r2.getResources().getString(2131888008);
    L26:
        if (r3 != sbb.e.m.b) goto L30;
        return r2.getResources().getString(2131889771);
    L30:
        if (r3 == sbb.e.f.b) goto L37;
        if (r3 == 111) goto L37;
        return r2.getResources().getString(2131888007);
    L37:
        return r2.getResources().getString(2131887142);
    }

    public static String g(Context r3, Document r4) {
        if (r3 != null) goto L6;
        tt5.a.h("DocumentUtils", "context is null");
        return "";
    L6:
        if (r4.b() == false) goto L10;
        return j(r3, r4.a, r4.G);
    L10:
        if (r4.b2 == false) goto L18;
        if (r4.getType() == sbb.e.f.b) goto L18;
        if (r4.getType() == 111) goto L18;
        return r3.getResources().getString(2131887103);
    L18:
        if (TextUtils.isEmpty(r4.a) == false) goto L25;
        int r0 = r4.getType();
        if (r0 != 16) goto L23;
        r0 = r4.y1;
    L23:
        return f(r3, r0, r4.p);
    L25:
        return r4.a;
    }

    public static oj5.b k(Document r21, String r22) {
        String r1 = ((com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class)).getUid();
        String r2 = ou5.a.b(((com.bytedance.ee.bear.contract.i0) org.koin.java.a.a(com.bytedance.ee.bear.contract.i0.class)).a(), r21.r, r21.s);
        String r3 = ((com.bytedance.ee.bear.search.b) org.koin.java.a.a(com.bytedance.ee.bear.search.b.class)).d(r21.a);
        int r5 = r21.getType();
        String r4 = r21.p;
        if (r4 != null) goto L5;
        String r7 = "";
    L6:
        String r6 = r21.d;
        if (r6 != null) goto L9;
        String r8 = "";
    L10:
        if (r3 != null) goto L12;
        r3 = "";
    L12:
        String r9 = r21.e;
        if (r9 != null) goto L15;
        String r10 = "";
    L16:
        if (r9 != null) goto L18;
        String r11 = "";
    L19:
        if (r2 != null) goto L21;
        String r12 = "";
    L22:
        String r13 = r21.f;
        if (r13 != null) goto L25;
        String r14 = "";
    L26:
        String r15 = r21.j;
        if (r15 != null) goto L29;
        String r16 = "";
    L30:
        String r17 = r21.m;
        if (r17 != null) goto L33;
        String r18 = "";
    L34:
        String r19 = r7;
        String r20 = r8;
        String r23 = r3;
        oj5.b r110 = new oj5.b(r5, r19, r20, r23, r10, r11, r12, r14, r16, r18, r22, TextUtils.equals(r1, r9), r21.L, r21.z, new FolderVersion(r21.L1, r21.T, r21.P1), FolderVersion.isShareFolder(r21.L1, r21.P1));
        if (NodeType.isShortcut(r21.M1) == false) goto L38;
        r110.q = true;
        r110.r = true;
        r110.s = r21.c;
    L38:
        if (r21.b() == false) goto L43;
        HashMap r0 = new HashMap();
        String[] r24 = a;
        int r25 = r24.length;
        int r26 = 0;
    L40:
        if (r26 >= r25) goto L42;
        r0.put(r24[r26], d());
        r26 = r26 + 1;
        goto L40
    L42:
        r110.v = (String[]) r24.clone();
        r110.w = r0;
    L43:
        return r110;
    L33:
        r18 = r17;
        goto L34
    L29:
        r16 = r15;
        goto L30
    L25:
        r14 = r13;
        goto L26
    L21:
        r12 = r2;
        goto L22
    L18:
        r11 = r9;
        goto L19
    L15:
        r10 = r9;
        goto L16
    L9:
        r8 = r6;
        goto L10
    L5:
        r7 = r4;
        goto L6
    }

    public static String n(Context r1, int r2) {
        if (r1 != null) goto L6;
        tt5.a.h("DocumentUtils", "context is null");
        return "";
    L6:
        if (r2 != sbb.e.f.b) goto L10;
        return r1.getString(2131888004);
    L10:
        if (r2 != sbb.e.q.b) goto L14;
        return r1.getString(2131887343);
    L14:
        if (r2 != sbb.e.l.b) goto L18;
        return r1.getString(2131887779);
    L18:
        if (sbb.g.b(r2) == false) goto L22;
        return r1.getString(2131888912);
    L22:
        if (r2 != 125) goto L26;
        return r1.getString(2131888863);
    L26:
        return r1.getString(2131888003);
    }

    public static String p(FragmentActivity r2, int r3) {
        if (r2 != null) goto L6;
        tt5.a.h("DocumentUtils", "context is null");
        return "";
    L6:
        if (r3 != sbb.e.g.b) goto L10;
        return r2.getString(2131887894);
    L10:
        if (r3 != sbb.e.i.b) goto L14;
        return r2.getString(2131887893);
    L14:
        if (r3 != sbb.e.l.b) goto L18;
        return r2.getString(2131887895);
    L18:
        if (r3 != sbb.e.f.b) goto L22;
        return r2.getString(2131887896);
    L22:
        if (r3 != sbb.e.k.b) goto L26;
        return r2.getString(2131887897);
    L26:
        if (r3 != sbb.e.h.b) goto L30;
        return r2.getString(2131887898);
    L30:
        if (r3 != sbb.e.m.b) goto L34;
        return r2.getString(2131889767);
    L34:
        if (r3 != sbb.e.n.b) goto L38;
        return r2.getString(2131887899);
    L38:
        if (r3 != 125) goto L42;
        return r2.getString(2131888865);
    L42:
        return r2.getString(2131887894);
    }

    public static void r(v0 r12, ce5.a r13) {
        final Document r6 = r12.b;
        final Activity r0 = r12.getActivity();
        if (r6 != null) goto L5;
        return;
    L5:
        boolean r8 = false;
        if (r12.c == false) goto L8;
    L31:
        String r1 = a(r6, r12.e, r12.g);
        com.bytedance.ee.bear.route.h r4 = (com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class);
        r4.X8(r0);
        if (idb.f.a().isEnable("apaas.miaoda.migrate_to_ccm") == true) goto L34;
        boolean r5 = false;
    L38:
        if (r5 == false) goto L40;
        tt5.a.h("DocumentUtils", "open miaoda document by host webview, type = " + r6.getType());
        ((com.bytedance.ee.bear.lark.dependency.f) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.f.class)).a(r0, r1, null);
    L41:
        com.bytedance.ee.bear.contract.d r2 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        int r3 = r6.getType();
        lc5.f.a r7 = lc5.f.a;
        Intrinsics.checkNotNullParameter(r2, "analyticService");
        r2.h("open_file");
        lc5.f.a.c(r2, "open_file", "start_time", String.valueOf(SystemClock.uptimeMillis()));
        lc5.f.a.c(r2, "open_file", "file_type", sbb.e.c(r3));
        r2.h("openDoc");
        lc5.f.a.c(r2, "openDoc", "start_time", String.valueOf(SystemClock.uptimeMillis()));
        lc5.m r11 = new lc5.m((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r12.e, r12.f, r12.h, r12.i, r6, r12.j);
        Intrinsics.checkNotNullParameter(r11, "param");
        Intrinsics.checkNotNullParameter(r13, "userComponentAbility");
        HashMap r14 = new HashMap();
        r14.put("file_id", du5.b.g(r11.f.d));
        r14.put("module", r11.b);
        if (TextUtils.isEmpty(r11.c) == true) goto L44;
        r14.put("sub_module", r11.c);
    L44:
        r14.put("location", String.valueOf(r11.d + 1));
        r14.put("sequence_num", String.valueOf(r11.d));
        r14.put("folder_level", String.valueOf(r11.g));
        Document r9 = r11.f;
        String r10 = "";
        if (r9 != null) goto L48;
    L56:
        String r15 = "";
    L57:
        r14.put("group", r15);
        r14.put("file_type", sbb.e.c(r11.f.getType()));
        if (r11.f.getType() != sbb.e.l.b) goto L67;
        String r16 = r11.f.F;
        if (r16 != null) goto L62;
    L63:
        r8 = true;
    L64:
        if (r8 == true) goto L67;
        r14.put("sub_type", r11.f.F);
        goto L67
    L62:
        if (r16.length() != 0) goto L64;
    L67:
        if (r11.e == false) goto L69;
        String r17 = "grid";
    L70:
        r14.put("view", r17);
        String r18 = r11.f.x1;
        if (r18 == null) goto L74;
        r10 = r18;
    L74:
        r14.put("appid", r10);
        if (qc5.a.g(r13) == false) goto L77;
        String r19 = "new_format";
    L78:
        r14.put("space_version", r19);
        lc5.f.a.D(r11.a, "click_list_item", r14);
        return;
    L77:
        r19 = "original";
        goto L78
    L69:
        r17 = "list";
        goto L70
    L48:
        if (TextUtils.isEmpty(r9.l) == true) goto L56;
        long r20 = CastLongProtector.parseLong(r9.l);
        if ((((long) CCMLynxCardView.ViewType.BANNER) * r20) <= lc5.f.a.j()) goto L52;
        r15 = "today";
        goto L57
    L52:
        long r21 = r20 * ((long) 100);
        Calendar r22 = Calendar.getInstance();
        r22.setTimeInMillis(lc5.f.a.j() - ((long) 86400000));
        if (r21 <= r22.getTime().getTime()) goto L55;
        r15 = "yesterday";
        goto L57
    L55:
        r15 = "earlier";
        goto L57
    L40:
        r4.m9(r1, r12.d);
        goto L41
    L34:
        int r23 = r6.getType();
        int r24 = r6.y1;
        if (r24 <= 0) goto L37;
        r23 = r24;
    L37:
        r5 = sbb.g.b(r23);
        goto L38
    L8:
        if (c(r6) == true) goto L31;
        tt5.a.h("DocumentUtils", "onItemClick()...can not open offline");
        if (r6.b2 == false) goto L13;
        Toast.showText(r0, r0.getString(2131887939), 0);
        return;
    L13:
        int r110 = r6.getType();
        if (16 != r6.getType()) goto L17;
        r110 = r6.y1;
    L17:
        if (r6.p0 == false) goto L19;
    L29:
        Toast.showText(r0, r0.getString(2131887939), 0);
        return;
    L19:
        if (ManualOfflineConfig.isEnable(r110) == false) goto L29;
        final boolean r111 = r12.i;
        final String r112 = r12.e;
        String r25 = r0.getString(2131887948);
        String r26 = r0.getString(2131887942);
        Intrinsics.checkNotNullParameter(r0, "context");
        UDDialogBuilder r27 = new UDDialogBuilder(r0);
        r27.autoDismiss(true);
        Intrinsics.checkNotNullParameter(r25, "value");
        r27.title(r25);
        Intrinsics.checkNotNullParameter(r26, "value");
        r27.message(r26);
        r27.messageGravity(8388611);
        BearUDDialogBuilder.ActionBottomOrientation r28 = BearUDDialogBuilder.ActionBottomOrientation.VERTICAL;
        Intrinsics.checkNotNullParameter(r28, "value");
        if (r28 != BearUDDialogBuilder.ActionBottomOrientation.HORIZONTAL) goto L23;
        UDBaseDialogBuilder.ActionBottomOrientation r29 = UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL;
    L24:
        r27.actionButtonOrientation(r29);
        r27.addActionButton(2131391777, 2131887795, new w(r0, r6, r111, r112));
        r27.addActionButton(2131391778, 2131887944, null);
        UDDialog r113 = r27.build();
        if (DialogLancet.shouldBlockDialogShow(r113) == false) goto L81;
        DialogLancet.handleBlockedDialogShow(r113);
        return;
    L81:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L80
    L28:
        DialogLancet.beforeDialogShow(r113);
        r113.show();
        DialogLancet.afterDialogShow(r113);
        return;
    L23:
        r29 = UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL;
        goto L24
    }

    public static boolean t(Document r2, oj5.c r3) {
        if (r2.getType() == sbb.e.l.b) goto L5;
        return false;
    L5:
        if (((ya5.b) org.koin.java.a.a(ya5.b.class)).a() == true) goto L7;
        return false;
    L7:
        if ((r3 instanceof oj5.a) == false) goto L10;
        tt5.a.h("DocumentUtils", "isOpenFileInOtherAppEnable() is DocMoreInfo canExport=" + r3.p());
        return r3.p();
    L10:
        tt5.a.h("DocumentUtils", "isOpenFileInOtherAppEnable() not DocMoreInfo isCopiable=" + r2.S);
        return r2.S;
    }

    public static boolean u(Document r1, ce5.a r2) {
        boolean r3 = r1.H2;
        boolean r4 = r2.d.isCurrentEnable("ccm.workspace.wiki_root_custom_homepage");
        if (r3 == false) goto L6;
        if (r4 == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean w(Document r0, AccountService.Account r1) {
        if (r0 == null) goto L7;
        if (r1 == null) goto L7;
        if (TextUtils.equals(r0.e, r1.uid) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public static String F(Context r3, Document r4, String r5) {
        HashMap r0 = new HashMap();
        r0.put("ownerName", ou5.a.b(r5, r4.X, r4.Y));
        r0.put(SheetInputData.InputData.DateType.TIME, zu5.a.e(r3, yu5.c.g(r4.o, 0) * 1000));
        return xo5.a.d(r3, 2131887975, r0);
    }

    public static String a(Document r3, String r4, String r5) {
        String r6 = i(r3);
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return r6;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L17;
        Uri.Builder r7 = UriProtector.parse(r6).buildUpon();
        if (TextUtils.equals(r4, "base_workspace") == false) goto L10;
        r7.appendQueryParameter("from", r4);
    L12:
        if (TextUtils.isEmpty(r5) == true) goto L15;
        r7.appendQueryParameter("ccm_open_type", r5);
    L15:
        return r7.build().toString();
    L10:
        r7.appendQueryParameter("from", "tab_" + r4);
        goto L12
    L17:
        return r6;
    }

    public static boolean b(Context r2, Document r3, String r4) {
        if (r3 != null) goto L5;
    L12:
        return false;
    L5:
        if (r3.b() == false) goto L12;
        tt5.a.h("DocumentUtils", "block ai artifact folder operation. operation=" + r4 + ", isAIArtifactFolder=true");
        if (r2 == null) goto L13;
        Toast.showFailureText(r2, r2.getString(2131889467), 0);
        return true;
    L13:
        return true;
    }

    public static String f(Context r3, int r4, String r5) {
        if (r3 != null) goto L6;
        tt5.a.h("DocumentUtils", "context is null");
        return "";
    L6:
        if (r4 != sbb.e.g.b) goto L10;
        return r3.getResources().getString(2131888007);
    L10:
        if (r4 == sbb.e.h.b) goto L12;
        sbb.e r0 = sbb.e.i;
        if (r4 != r0.b) goto L23;
        if (r5 == null) goto L21;
        if (((bn4.a) org.koin.java.a.a(bn4.a.class)).i(r0.getType(), r5) == false) goto L21;
        return r3.getResources().getString(2131886253);
    L21:
        return r3.getResources().getString(2131888006);
    L23:
        if (r4 != sbb.e.k.b) goto L27;
        return r3.getResources().getString(2131888009);
    L27:
        if (r4 != sbb.e.l.b) goto L31;
        return r3.getResources().getString(2131888008);
    L31:
        if (r4 != sbb.e.m.b) goto L35;
        return r3.getResources().getString(2131889771);
    L35:
        if (r4 == sbb.e.f.b) goto L42;
        if (r4 == 111) goto L42;
        return r3.getResources().getString(2131888007);
    L42:
        return r3.getResources().getString(2131887142);
    L12:
        return r3.getResources().getString(2131888010);
    }

    public static oj5.a h(final Document r28, String r29, ShareFolderUserPermission r30) {
        String r1 = ou5.a.b(((com.bytedance.ee.bear.contract.i0) org.koin.java.a.a(com.bytedance.ee.bear.contract.i0.class)).a(), r28.r, r28.s);
        String r2 = ((com.bytedance.ee.bear.search.b) org.koin.java.a.a(com.bytedance.ee.bear.search.b.class)).d(r28.a);
        if (r2 != null) goto L5;
        String r4 = "";
    L6:
        boolean r5 = r28.b2;
        String r3 = r28.e;
        if (r3 != null) goto L9;
        String r6 = "";
    L10:
        if (r1 != null) goto L12;
        String r7 = "";
    L13:
        String r8 = r28.f;
        if (r8 != null) goto L16;
        r8 = "";
    L16:
        if (r3 != null) goto L18;
        String r9 = "";
    L19:
        if (r1 != null) goto L21;
        String r10 = "";
    L22:
        String r11 = r28.j;
        if (r11 != null) goto L25;
        String r12 = "";
    L26:
        String r13 = r28.F;
        if (r13 != null) goto L29;
        String r14 = "";
    L30:
        boolean r15 = r28.L;
        boolean r16 = r28.z;
        String r17 = r28.x1;
        if (r17 != null) goto L33;
        String r18 = "";
    L34:
        String r19 = r28.H;
        if (r19 != null) goto L37;
        String r24 = "";
    L38:
        DocMetaInfo r110 = new DocMetaInfo(r4, r5, r6, r7, r8, r9, r10, r12, r14, r15, r16, r18, "", false, r24, r28.y1, -1, 0, 0, new SecretLevel());
        r110.setIcon_info(r28.F2);
        r110.setWikiHomePage(r28.H2);
        if (r28.getType() == 16) goto L50;
        int r20 = oj5.d.b;
        if (oj5.d.a.a(r28.P) == null) goto L43;
        boolean r21 = true;
    L44:
        if (r21 == false) goto L46;
        boolean r22 = true;
    L47:
        if (r22 == true) goto L50;
        boolean r23 = false;
    L51:
        String r25 = r28.O;
        int r26 = oj5.d.b;
        if (oj5.d.a.a(r25) == null) goto L54;
        oj5.d r27 = oj5.d.a.a(r28.O);
    L55:
        oj5.d r111 = r27;
        if (r23 == false) goto L69;
        int r31 = r28.getType();
        String r32 = i(r28);
        if (r32 != null) goto L60;
        String r33 = "";
    L61:
        String r34 = r28.d;
        if (r34 != null) goto L64;
        String r35 = "";
    L65:
        oj5.f r112 = new oj5.f(r31, r33, r35, r29, false, r28.p0, r110, new DocObjInfo(r28.L, r28.z, r28.A, r28.B, new WikiNavInfo(), "", 0), new DocPermission(new DocumentUtils$2(r28), new DocumentUtils$3(r28)), new DocVersion(r28.L1), r28.d, false, null);
        r112.S(((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).m(r28.y1, true, false, ((BenefitManagerAPI) org.koin.java.a.a(BenefitManagerAPI.class)).n1()));
        if (r111 == null) goto L68;
        r111.a = r28.d;
    L68:
        oj5.a r113 = r112;
        oj5.d r36 = r111;
    L78:
        r113.H = r36;
        if (NodeType.isShortcut(r28.M1) == false) goto L82;
        r113.p = true;
        r113.q = true;
        r113.r = r28.c;
    L82:
        String r37 = r28.G1 + "";
        Intrinsics.checkNotNullParameter(r37, ResourceData.KEY_TOKEN);
        r113.o = r37;
        r113.u = r28.R;
        r113.I = r28.i;
        r113.F = r2;
        if (r28.v2 == 0) goto L85;
        boolean r114 = true;
    L86:
        r113.G = Boolean.valueOf(r114);
        r113.t = r30;
        BearUrl r0 = com.bytedance.ee.bear.list.more.more3.t.b(r28);
        String r115 = r0.e;
        if (r115 != null) goto L89;
        r115 = "";
    L89:
        r113.b = r115;
        Integer r38 = Integer.valueOf(r0.a());
        if (r38 == null) goto L92;
        int r39 = r38.intValue();
    L93:
        r113.a = r39;
        String r116 = r0.b;
        if (r116 != null) goto L96;
        r116 = "";
    L96:
        r113.c = r116;
        String r40 = r0.m;
        if (TextUtils.isEmpty(r40) == true) goto L99;
        r113.E = r40;
    L99:
        return r113;
    L92:
        r39 = -1;
        goto L93
    L85:
        r114 = false;
        goto L86
    L64:
        r35 = r34;
        goto L65
    L60:
        r33 = r32;
        goto L61
    L69:
        int r41 = r28.getType();
        String r42 = i(r28);
        if (r42 != null) goto L72;
        String r43 = "";
    L73:
        String r44 = r28.d;
        if (r44 != null) goto L76;
        String r45 = "";
    L77:
        oj5.a r117 = new oj5.a(r41, r43, r45, r29, false, r28.p0, r110, new DocObjInfo(r28.L, r28.z, r28.A, r28.B, new WikiNavInfo(), "", 0), new DocPermission(new DocumentUtils$4(r28), new DocumentUtils$5(r28)), new DocVersion(r28.L1), false, false, false, null);
        r117.S(((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).m(r28.getType(), false, false, ((BenefitManagerAPI) org.koin.java.a.a(BenefitManagerAPI.class)).n1()));
        r113 = r117;
        r36 = r111;
        goto L78
    L76:
        r45 = r44;
        goto L77
    L72:
        r43 = r42;
        goto L73
    L54:
        r27 = new oj5.d();
        goto L55
    L46:
        r22 = false;
        goto L47
    L43:
        r21 = false;
    L50:
        r23 = true;
        goto L51
    L37:
        r24 = r19;
        goto L38
    L33:
        r18 = r17;
        goto L34
    L29:
        r14 = r13;
        goto L30
    L25:
        r12 = r11;
        goto L26
    L21:
        r10 = r1;
        goto L22
    L18:
        r9 = r3;
        goto L19
    L12:
        r7 = r1;
        goto L13
    L9:
        r6 = r3;
        goto L10
    L5:
        r4 = r2;
        goto L6
    }

    public static String j(Context r3, String r4, long r5) {
        if (r3 != null) goto L4;
    L11:
        return r4;
    L4:
        if (r5 != 140) goto L8;
        return r3.getString(2131889460);
    L8:
        if (r5 != 141) goto L11;
        return r3.getString(2131889463);
    }

    public static void z(final FragmentActivity r7, final Document r8, String r9, String r10) {
        lc5.f.a(new lc5.a((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r10, r9, "star", r8));
        Flowable.just("").subscribeOn(fo5.d.b()).map(new v()).map(new g0(r7, r8)).subscribe(new i0(), new j0());
    }

    public static void I(Context r11, final String r12, final String r13, final String r14, final gp5.a.InterfaceC0236a r15) {
        gp5.a r16 = (gp5.a) new gp5.a(r11).title(2131887732);
        r16.f(2131887764);
        r16.a(2131887729);
        gp5.a.InterfaceC0236a r0 = new l0(r15, r12, r13, r14);
        Intrinsics.checkNotNullParameter(r0, "value");
        r16.r = r0;
        r16.c();
        gp5.a.InterfaceC0236a r1 = new m0(r12, r13, r14);
        Intrinsics.checkNotNullParameter(r1, "value");
        r16.s = r1;
        if (DeviceUtils.isPad() == false) goto L5;
        r16.maxWidth(new UDDimension.Dp(300));
    L5:
        Dialog r17 = r16.show();
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).s(r17);
        lc5.f.a r18 = lc5.f.a;
        Intrinsics.checkNotNullParameter(r12, "module");
        JSONObject r19 = new JSONObject();
        lc5.f.a.b(r18, new lc5.g(r19, r12, r13, "", sbb.e.f.b, "", r14, DocumentType.FOLDER_NAME, null));
        r19.put("is_shared_folder", "false");
        com.bytedance.ee.bear.contract.d r110 = lc5.f.a.d();
        if (r110 == null) goto L9;
        r110.i("ccm_space_create_new_folder_view", r19);
        return;
    }
}
