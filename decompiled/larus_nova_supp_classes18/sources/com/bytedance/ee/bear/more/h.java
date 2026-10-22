package com.bytedance.ee.bear.more;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.more.DocFreshNessPlugin;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UniBaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.more.export.PageviewUIHolder;
import com.bytedance.ee.bear.more.itemv2.AddShortCutItemV2;
import com.bytedance.ee.bear.more.itemv2.ApplyPermMoreItemV2;
import com.bytedance.ee.bear.more.itemv2.ContactServiceItemV2;
import com.bytedance.ee.bear.more.itemv2.CopyLinkItemV2;
import com.bytedance.ee.bear.more.itemv2.DeleteItemV2;
import com.bytedance.ee.bear.more.itemv2.MakeCopyItemV2;
import com.bytedance.ee.bear.more.itemv2.ManualCacheItemV2;
import com.bytedance.ee.bear.more.itemv2.MultiTaskMoreItem;
import com.bytedance.ee.bear.more.itemv2.PermissionItemV2;
import com.bytedance.ee.bear.more.itemv2.PinItemV2;
import com.bytedance.ee.bear.more.itemv2.RenameItemV2;
import com.bytedance.ee.bear.more.itemv2.ReportItemV2;
import com.bytedance.ee.bear.more.itemv2.RetentionItemV2;
import com.bytedance.ee.bear.more.itemv2.SecretMoreItem;
import com.bytedance.ee.bear.more.itemv2.ShortcutItemV2;
import com.bytedance.ee.bear.more.itemv2.StarItemV2;
import com.bytedance.ee.bear.more.itemv2.SubscribeCommentItemV2;
import com.bytedance.ee.bear.more.itemv2.SubscribeItemV2;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem;
import com.bytedance.ee.bear.more.pageview2.PageViewFragment;
import com.bytedance.ee.bear.more.protocol3.extension.BaseMoreProvider;
import com.bytedance.ee.bear.more.view3.MoreFragmentV3;
import com.bytedance.ee.bear.more.view3.MoreViewModelV3;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.framework.utils.CollectionUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import io.reactivex.Flowable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import rj5.h0;
import rj5.u;
import rj5.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements b {
    public PageViewFragment a;

    public h() {
    }

    @Override // com.bytedance.ee.bear.more.b
    public final h0 D() {
        return new h0();
    }

    @Override // com.bytedance.ee.bear.more.b
    public final rj5.l G() {
        return new rj5.l();
    }

    @Override // com.bytedance.ee.bear.more.b
    public final SecretMoreItem N() {
        return new SecretMoreItem();
    }

    @Override // com.bytedance.ee.bear.more.b
    public final rj5.k r() {
        return new rj5.k();
    }

    @Override // com.bytedance.ee.bear.more.b
    public final void y() {
        PageViewFragment r0 = this.a;
        if (r0 != null) goto L12;
        tt5.a.h("MoreImpl", "dismissPageViewFragment(): dialogFragment is null");
        return;
    L12:
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L14;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.ee.bear.more.b
    public final void h() {
        y();
    }

    @Override // com.bytedance.ee.bear.more.b
    public final void E(m r17) {
        Bundle r1 = r17.b;
        JSONObject r15 = new JSONObject();
        if (r1 != null) goto L43;
    L7:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L15;
        String r3 = r1.getString("module", "null");     // Catch: JSONException -> L18
        String r5 = r1.getString("sub_module", "null");     // Catch: JSONException -> L18
        String r4 = r1.getString("container_id", "");     // Catch: JSONException -> L18
        if (TextUtils.isEmpty(r4) == true) goto L13;
        String r6 = du5.b.g(r4);     // Catch: JSONException -> L18
    L14:
        String r12 = r1.getString("container_type", "null");     // Catch: JSONException -> L18
        String r7 = r3;
        String r11 = r6;
        String r8 = r5;
    L22:
        c.a(new o(r15, r17.k, r17.m, r7, r8, r17.c, r17.getType(), r17.e, r11, r12, null, r17.g));     // Catch: JSONException -> L18
        r15.put("is_version", String.valueOf(r17.l));     // Catch: JSONException -> L18
        if (TextUtils.isEmpty(r17.h) == true) goto L26;
        r15.put("click", r17.h);     // Catch: JSONException -> L18
    L26:
        if (TextUtils.isEmpty(r17.i) == true) goto L29;
        r15.put("target", r17.i);     // Catch: JSONException -> L18
    L29:
        if (TextUtils.isEmpty(r17.j) == true) goto L31;
        r15.put("module_type", r17.j);     // Catch: JSONException -> L18
    L31:
        Map<String, Object> r9 = r17.n;     // Catch: JSONException -> L18
        if (r9 == null) goto L39;
        Iterator<Map.Entry<String, Object>> r10 = r9.entrySet().iterator();     // Catch: JSONException -> L18
    L35:
        if (r10.hasNext() == false) goto L39;
        Map.Entry<String, Object> r13 = r10.next();     // Catch: JSONException -> L18
        if (TextUtils.isEmpty(r13.getKey()) == true) goto L35;
        r15.put(r13.getKey(), r13.getValue());     // Catch: JSONException -> L18
    L39:
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).i(r17.a, r15);     // Catch: JSONException -> L18
        return;
    L18:
        e = move-exception;
        tt5.a.d("MoreAnalytic", "reportSpaceMoreItemClick()...error = " + e);
        return;
    L13:
        r6 = "null";
        goto L14
    L15:
        int r14 = r17.getType();     // Catch: JSONException -> L18
        if (r17.f == false) goto L20;
        String r16 = DocumentType.WIKI_NAME;
    L21:
        r7 = r16;
        r8 = "null";
        r11 = r8;
        r12 = r11;
        goto L22
    L20:
        r16 = sbb.e.c(r14);     // Catch: JSONException -> L18
        goto L21
    L43:
        if (r1.getInt("more_scene", -1) != 0) goto L7;
        r2 = true;
        goto L9
    }

    @Override // com.bytedance.ee.bear.more.b
    public final MultiTaskMoreItem F(sj5.c r2) {
        return new MultiTaskMoreItem(r2);
    }

    @Override // com.bytedance.ee.bear.more.b
    public final void I(l r17) {
        Bundle r0 = r17.b;
        JSONObject r15 = new JSONObject();
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L15;
        String r3 = r0.getString("module", "null");
        String r4 = r0.getString("sub_module", "null");
        String r5 = r0.getString("container_id", "");
        if (TextUtils.isEmpty(r5) == true) goto L13;
        String r6 = du5.b.g(r5);
    L14:
        String r12 = r0.getString("container_type", "null");
        String r7 = r3;
        String r8 = r4;
        String r11 = r6;
    L33:
        r15.put("is_version", String.valueOf(r17.i));     // Catch: JSONException -> L29
        Map<String, Object> r1 = r17.k;     // Catch: JSONException -> L29
        if (r1 == null) goto L31;
        Iterator<Map.Entry<String, Object>> r9 = r1.entrySet().iterator();     // Catch: JSONException -> L29
    L24:
        if (r9.hasNext() == false) goto L31;
        Map.Entry<String, Object> r10 = r9.next();     // Catch: JSONException -> L29
        if (TextUtils.isEmpty(r10.getKey()) == true) goto L24;
        r15.put(r10.getKey(), r10.getValue());     // Catch: JSONException -> L29
    L31:
        c.a(new o(r15, r17.h, r17.j, r7, r8, r17.c, r17.getType(), r17.e, r11, r12, null, r17.g));
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).i(r17.a, r15);
        return;
    L29:
        e = move-exception;
        tt5.a.d("MoreAnalytic", "reportMoreSubMenuView:" + e);
        goto L31
    L13:
        r6 = "null";
        goto L14
    L15:
        int r13 = r17.getType();
        if (r17.f == false) goto L18;
        String r14 = DocumentType.WIKI_NAME;
    L19:
        r7 = r14;
        r8 = "null";
        r11 = r8;
        r12 = r11;
        goto L33
    L18:
        r14 = sbb.e.c(r13);
        goto L19
    L5:
        if (r0.getInt("more_scene", -1) != 0) goto L7;
        r2 = true;
        goto L9
    }

    @Override // com.bytedance.ee.bear.more.b
    public final void K(j r17) {
        JSONObject r14 = new JSONObject();
        boolean r3 = r17.h;     // Catch: JSONException -> L9
        String r4 = r17.i;     // Catch: JSONException -> L9
        int r1 = r17.getType();     // Catch: JSONException -> L9
        if (r17.f == false) goto L6;
        String r2 = DocumentType.WIKI_NAME;
    L7:
        c.a(new o(r14, r3, r4, r2, "", r17.a, r17.getType(), r17.c, "", "", null, r17.g));     // Catch: JSONException -> L9
        r14.put("is_follow_update", String.valueOf(r17.d));     // Catch: JSONException -> L9
        r14.put("is_follow_comment", String.valueOf(r17.e));     // Catch: JSONException -> L9
        r14.put("is_have_ai_button", r17.j);     // Catch: JSONException -> L9
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).i("ccm_space_docs_more_menu_view", r14);     // Catch: JSONException -> L9
        return;
    L6:
        r2 = sbb.e.c(r1);     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        tt5.a.d("MoreAnalytic", "reportSpaceMoreItemClick()...error = " + e);
    }

    @Override // com.bytedance.ee.bear.more.b
    public final v P(a r2) {
        return new v(r2);
    }

    @Override // com.bytedance.ee.bear.more.b
    public final IBaseMoreItem a(FragmentActivity r2) {
        return ((com.bytedance.ee.bear.d) org.koin.java.a.a(com.bytedance.ee.bear.d.class)).a(r2);
    }

    @Override // com.bytedance.ee.bear.more.b
    public final void b(String r3) {
        new ml5.b("moreNewItems").b(r3, Boolean.FALSE);
    }

    @Override // com.bytedance.ee.bear.more.b
    public final void c(i r1) {
        c.c(r1);
    }

    @Override // com.bytedance.ee.bear.more.b
    public final com.bytedance.ee.bear.more.itemv2.mainnav.b d(wb5.d r2) {
        return new com.bytedance.ee.bear.more.itemv2.mainnav.b(r2);
    }

    @Override // com.bytedance.ee.bear.more.b
    public final Flowable<Boolean> i(final String r3) {
        return Flowable.just("").subscribeOn(fo5.d.b()).map(new d()).map(new e(r3));
    }

    @Override // com.bytedance.ee.bear.more.b
    public final void j(PageviewUIHolder r2) {
        PageViewFragment r0 = this.a;
        if (r0 == null) goto L5;
        r0.da0(r2);
        return;
    L5:
        tt5.a.h("MoreImpl", "updatePageViewUI(): pageview is null");
    }

    @Override // com.bytedance.ee.bear.more.b
    public final void k(final p r20) {
        FragmentActivity r12 = r20.getActivity();
        if (r12 != null) goto L6;
        tt5.a.d("MoreImpl", "activity is null!");
        return;
    L6:
        int r0 = r20.b;
        String r14 = r20.c;
        boolean r15 = r20.d;
        boolean r11 = r20.e;
        String r10 = r20.f;
        PageviewUIHolder r9 = r20.g;
        HashMap<String, Serializable> r8 = r20.j;
        n r13 = new n(r12, r0, r14, r15, r11, r10, r9, r8);
        int r3 = PageViewFragment.B;
        Bundle r4 = new Bundle();
        r4.putInt("documentType", r0);
        r4.putString(ResourceData.KEY_TOKEN, r14);
        r4.putBoolean("isDocV2", r15);
        r4.putBoolean("isShowViewHistory", r11);
        r4.putParcelable("titleHolder", r9);
        r4.putString("docName", r10);
        if (r8 != null) goto L30;
        tt5.a.h("PageViewFragment", "newInstance, extraParams doesn't exist.");
    L13:
        PageViewFragment r1 = Fragment.instantiate(r13.getContext(), PageViewFragment.class.getName(), r4);
        this.a = r1;
        r1.n = new f(this, r20);
        if (ForsetiHelper.s(r20.h) == false) goto L17;
        PageViewFragment r2 = this.a;
        Fragment r5 = r20.h;
        ForsetiNavOptions.DestinationStyle r6 = ForsetiNavOptions.DestinationStyle.HALF_FLOAT;
        boolean r7 = r20.i;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r6, "style");
        if (com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f.e(r2, r5, r6, r7, 0, false, 56) == false) goto L17;
        return;
    L17:
        Fragment r16 = this.a;
        FragmentManager r17 = r12.getSupportFragmentManager();
        if ((r16 instanceof Fragment) == false) goto L20;
        Fragment r18 = r16;
    L21:
        LandscapeRestrictionOperation r19 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r18, null, r19);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r17, r18, r19) == true) goto L33;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
    L25:
        r16.show(r17, null);
        return;
    L33:
        return;
    L20:
        r18 = null;
        goto L21
    L30:
        r4.putSerializable("extraParams", r8);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        tt5.a.i("PageViewFragment", "newInstance, serialize extraParams error, extraParams: " + r8, e);
        goto L13
    }

    @Override // com.bytedance.ee.bear.more.b
    public final boolean l(String r1) {
        return k.b(r1);
    }

    @Override // com.bytedance.ee.bear.more.b
    public final rj5.a x(PluginHost r2) {
        return new rj5.a(r2);
    }

    public static UserPermissionEntity R(oj5.c r2, Object r3) {
        if ((r2 instanceof oj5.b) == false) goto L5;
        HashMap r0 = new HashMap();
        r0.put(UserPermissionEntity.IS_OWNER, Boolean.valueOf(r2.isOwner()));
    L7:
        return new UserPermissionEntity(r3, r0);
    L5:
        r0 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.more.b
    public final CopyLinkItemV2 A(String r2, String r3) {
        return new CopyLinkItemV2(r2, r3);
    }

    @Override // com.bytedance.ee.bear.more.b
    public final void O(FragmentActivity r3, com.bytedance.ee.bear.more.protocol3.h r4) {
        e(r3, r4, null, -1);
    }

    @Override // com.bytedance.ee.bear.more.b
    public final PermissionResponse f(oj5.c r9, String r10) {
        if (r9 != null) goto L5;
        PermissionResponse.Companion.getClass();
        return PermissionResponse.a.a();
    L5:
        UniBaseEntity r7 = new UniBaseEntity(r9.getToken(), sbb.e.d(r9.getType()), BizDomain.FileBizDomainCCM, r9.a(), r9.d(), null);
        return ((ph5.b) org.koin.java.a.a(ph5.b.class)).f(new PermissionRequest(r7, r10), null);
    }

    @Override // com.bytedance.ee.bear.more.b
    public final void n(String r3, qj5.b r4) {
        if (r3 != null) goto L4;
        ConcurrentHashMap<String, ArrayList<qj5.b>> r5 = pj5.m.a;
        return;
    L4:
        ConcurrentHashMap<String, ArrayList<qj5.b>> r0 = pj5.m.a;
        ArrayList<qj5.b> r1 = r0.get(r3);
        if (r1 != null) goto L11;
        ArrayList<qj5.b> r2 = new ArrayList();
        if (r4 == null) goto L9;
        r2.add(r4);
    L9:
        ArrayList<qj5.b> r6 = r0.put(r3, r2);
        return;
    L11:
        if (CollectionsKt.contains(r1, r4) == true) goto L17;
        if (r4 == null) goto L18;
        r1.add(r4);
        return;
    L18:
        return;
    }

    @Override // com.bytedance.ee.bear.more.b
    public final void p(String r4, qj5.b r5) {
        ConcurrentHashMap<String, ArrayList<qj5.b>> r0 = pj5.m.a;
        if (r4 == null) goto L24;
        if (r5 == null) goto L29;
        ConcurrentHashMap<String, ArrayList<qj5.b>> r1 = pj5.m.a;
        ArrayList<qj5.b> r2 = r1.get(r4);
        if (CollectionUtils.isEmpty(r2) == false) goto L18;
        String r3 = r5.getRetryToken();
        if (TextUtils.isEmpty(r3) == true) goto L25;
        ArrayList<qj5.b> r6 = r1.get(r3);
        if (CollectionUtils.isEmpty(r6) == true) goto L30;
        if (r6 == null) goto L16;
        r6.remove(r5);
    L16:
        if (CollectionUtils.isEmpty(r6) == false) goto L26;
        r1.remove(r4);
        return;
    L26:
        return;
    L30:
        return;
    L25:
        return;
    L18:
        if (r2 == null) goto L21;
        r2.remove(r5);
    L21:
        if (CollectionUtils.isEmpty(r2) == false) goto L28;
        r1.remove(r4);
        return;
    L28:
        return;
    L29:
        return;
    }

    @Override // com.bytedance.ee.bear.more.b
    public final void s(oj5.c r1, String r2) {
        c.b(r1, r2);
    }

    @Override // com.bytedance.ee.bear.more.b
    public final Boolean u(ShareFolderUserPermission r5, String r6) {
        if (TextUtils.isEmpty(r6) == true) goto L27;
        if (r5 == null) goto L27;
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == false) goto L9;
    L24:
        BaseEntity r0 = new BaseEntity("", sbb.e.e, BizDomain.FileBizDomainCCM, "");
        PermissionRequest r7 = ((ph5.b) org.koin.java.a.a(ph5.b.class)).d(r0, r6);
        return Boolean.valueOf(((ph5.b) org.koin.java.a.a(ph5.b.class)).f(r7, new UserPermissionEntity(r5, null)).getAllow());
    L9:
        if ("MOVE_THIS_NODE".equals(r6) == false) goto L13;
        return Boolean.valueOf(r5.canBeMoved());
    L13:
        if ("MOVE_SUB_NODE".equals(r6) == false) goto L17;
        return Boolean.valueOf(r5.canMoveSubNode());
    L17:
        if ("MOVE_TO_HERE".equals(r6) == false) goto L21;
        return Boolean.valueOf(r5.canMoveToHere());
    L21:
        if ("CREATE_SUB_NODE".equals(r6) == false) goto L24;
        return Boolean.valueOf(r5.canCreateSubNode());
    L27:
        return Boolean.FALSE;
    }

    @Override // com.bytedance.ee.bear.more.b
    public final MakeCopyItemV2 w(FragmentActivity r2, String r3) {
        return new MakeCopyItemV2(r2, r3);
    }

    public static void Q(DialogFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        DialogFragment r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.more.b
    public final Boolean B(oj5.c r2, ShareFolderUserPermission r3, String r4) {
        if (r2 == null) goto L36;
        if (TextUtils.isEmpty(r4) == true) goto L36;
        if (r3 == null) goto L36;
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == true) goto L34;
        if ("EDIT".equals(r4) == false) goto L14;
        return Boolean.valueOf(r3.canEdit());
    L14:
        if ("MOVE_THIS_NODE".equals(r4) == false) goto L18;
        return Boolean.valueOf(r3.canBeMoved());
    L18:
        if ("VIEW".equals(r4) == false) goto L22;
        return Boolean.valueOf(r3.canView());
    L22:
        if ("MOVE_TO_HERE".equals(r4) == false) goto L26;
        return Boolean.valueOf(r3.canMoveToHere());
    L26:
        if ("CREATE_SUB_NODE".equals(r4) == false) goto L30;
        return Boolean.valueOf(r3.canCreateSubNode());
    L30:
        if ("MOVE_SUB_NODE".equals(r4) == false) goto L34;
        return Boolean.valueOf(r3.canMoveSubNode());
    L34:
        return Boolean.valueOf(o(r2, r4, r3).getAllow());
    L36:
        return Boolean.FALSE;
    }

    @Override // com.bytedance.ee.bear.more.b
    public final void J(FragmentActivity r2, BaseMoreProvider r3, Fragment r4) {
        e(r2, r3, r4, -1);
    }

    @Override // com.bytedance.ee.bear.more.b
    public final void L(String r3, String r4, DocFreshNessPlugin r5) {
        ConcurrentHashMap<String, ArrayList<qj5.b>> r0 = pj5.m.a;
        if (r3 == null) goto L12;
        if (r4 == null) goto L13;
        if (r5 == null) goto L16;
        ConcurrentHashMap<String, ArrayList<qj5.b>> r6 = pj5.m.a;
        ArrayList<qj5.b> r1 = r6.get(r4);
        if (CollectionUtils.isEmpty(r1) == true) goto L14;
        if (r1 == null) goto L15;
        r6.remove(r4);
        r6.put(r3, r1);
        return;
    L15:
        return;
    L14:
        return;
    L16:
        return;
    L13:
        return;
    }

    @Override // com.bytedance.ee.bear.more.b
    public final PermissionResponse o(oj5.c r6, String r7, Object r8) {
        if (r6 == null) goto L5;
        BaseEntity r0 = new BaseEntity(r6.getToken(), sbb.e.d(r6.getType()), BizDomain.FileBizDomainCCM, r6.a());
        PermissionRequest r9 = ((ph5.b) org.koin.java.a.a(ph5.b.class)).d(r0, r7);
        return ((ph5.b) org.koin.java.a.a(ph5.b.class)).f(r9, R(r6, r8));
    L5:
        PermissionResponse.Companion.getClass();
        return PermissionResponse.a.a();
    }

    @Override // com.bytedance.ee.bear.more.b
    public final Boolean v(oj5.c r2, IDocUserPermission r3, String r4) {
        if (r2 == null) goto L32;
        if (TextUtils.isEmpty(r4) == true) goto L32;
        if (r3 == null) goto L32;
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == true) goto L30;
        if ("EDIT".equals(r4) == false) goto L14;
        return Boolean.valueOf(r3.canEdit());
    L14:
        if ("MOVE_THIS_NODE".equals(r4) == false) goto L18;
        return Boolean.valueOf(r3.canMoveThisNode());
    L18:
        if ("VIEW".equals(r4) == false) goto L22;
        return Boolean.valueOf(r3.canRead());
    L22:
        if ("PERCEIVE_CONTROL".equals(r4) == false) goto L26;
        return Boolean.valueOf(r3.matchPerceiveControl());
    L26:
        if ("DELETE_ENTITY".equals(r4) == false) goto L30;
        return Boolean.valueOf(r3.canOperateEntity());
    L30:
        return Boolean.valueOf(o(r2, r4, r3).getAllow());
    L32:
        return Boolean.FALSE;
    }

    @Override // com.bytedance.ee.bear.more.b
    public final void e(FragmentActivity r10, com.bytedance.ee.bear.more.protocol3.h r11, Fragment r12, int r13) {
        if (com.bytedance.ee.util.ui.b.a(r10) == true) goto L6;
        return;
    L6:
        if (r10.getSupportFragmentManager().findFragmentByTag(MoreFragmentV3.class.getName()) == null) goto L8;
        boolean r0 = true;
    L9:
        tt5.a.h("MoreImpl", "showMoreV3. isMoreShowing: " + r0 + " sourceFragment:" + r12);
        if (r0 == false) goto L12;
        return;
    L12:
        ((MoreViewModelV3) ViewModelProviders.of(r10).get(MoreViewModelV3.class)).init(r11);
        String r1 = MoreFragmentV3.class.getName();
        FragmentManager r2 = r10.getSupportFragmentManager();
        DialogFragment r14 = Fragment.instantiate(r10, r1);
        r14.setArguments(r11.c);
        if (ForsetiHelper.s(r12) == false) goto L16;
        ForsetiNavOptions.DestinationStyle r4 = ForsetiNavOptions.DestinationStyle.HALF_FLOAT;
        Intrinsics.checkNotNullParameter(r14, "<this>");
        Intrinsics.checkNotNullParameter(r4, "style");
        if (com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f.e(r14, r12, r4, false, r13, false, 32) == false) goto L16;
        return;
    L16:
        Q(r14, r2, r1);
        return;
    L8:
        r0 = false;
        goto L9
    }

    @Override // com.bytedance.ee.bear.more.b
    public final Map<String, Boolean> m(int r4, boolean r5, boolean r6, BenefitStore r7) {
        HashMap r0 = new HashMap();
        if (r4 != 22) goto L5;
    L17:
        r0.put(CommonMoreItemId.MAKE_COPY.getId(), Boolean.valueOf(r7.hasBenefit("common_make_doc_copy")));
        r0.put(com.bytedance.ee.bear.more.protocol3.f.m0.c.a, Boolean.valueOf(r7.hasBenefit("common_make_doc_copy")));
        r0.put(CommonMoreItemId.TEMPLATE.getId(), Boolean.valueOf(r7.hasBenefit("common_save_doc_as_my_template")));
    L18:
        if (r5 == false) goto L23;
        boolean r8 = r7.hasBenefit("common_wiki_node_management");
        if (r6 == false) goto L22;
        r0.put(CommonMoreItemId.RENAME.getId(), Boolean.valueOf(r8));
    L22:
        r0.put(CommonMoreItemId.MOVE.getId(), Boolean.valueOf(r8));
        r0.put(com.bytedance.ee.bear.more.protocol3.f.v.c.a, Boolean.valueOf(r8));
        r0.put(com.bytedance.ee.bear.more.protocol3.f.c0.c.a, Boolean.valueOf(r8));
        r0.put(com.bytedance.ee.bear.more.protocol3.f.j.c.a, Boolean.valueOf(r8));
        r0.put(CommonMoreItemId.DELETE.getId(), Boolean.valueOf(r8));
        r0.put(com.bytedance.ee.bear.more.protocol3.f.l0.c.a, Boolean.valueOf(r8));
        r0.put(com.bytedance.ee.bear.more.protocol3.f.k.c.a, Boolean.valueOf(r8));
    L23:
        return r0;
    L5:
        if (r4 == 3) goto L17;
        if (r4 == 11) goto L17;
        if (r4 == 30) goto L17;
        if (r4 != 8) goto L15;
        r0.put(CommonMoreItemId.MAKE_COPY.getId(), Boolean.valueOf(r7.hasBenefit("common_make_base_copy")));
        r0.put(com.bytedance.ee.bear.more.protocol3.f.m0.c.a, Boolean.valueOf(r7.hasBenefit("common_make_base_copy")));
        r0.put(CommonMoreItemId.TEMPLATE.getId(), Boolean.valueOf(r7.hasBenefit("common_save_base_as_my_template")));
        goto L18
    L15:
        if (r4 != 12) goto L18;
        r0.put("import_as", Boolean.valueOf(r7.hasBenefit("ccm_convert_to_doc")));
        r0.put(com.bytedance.ee.bear.more.protocol3.f.o.c.a, Boolean.valueOf(r7.hasBenefit("ccm_convert_to_doc")));
        goto L18
    }

    @Override // com.bytedance.ee.bear.more.b
    public final BaseMoreItem q(FragmentActivity r3, CommonMoreItemId r4, jdb.g r5, by4.d r6) {
        switch(u.a[r4.ordinal()]) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L28;
            case 9: goto L12;
            case 10: goto L27;
            case 11: goto L26;
            case 12: goto L25;
            case 13: goto L24;
            case 14: goto L7;
            case 15: goto L23;
            default: goto L5;
        };
    L7:
        BaseMoreItem r7 = new ApplyPermMoreItemV2(r3);
    L22:
        return r7;
    L12:
        r7 = new MakeCopyItemV2(r3);
        goto L22
    L14:
        r7 = new DeleteItemV2(r3);
        goto L22
    L15:
        r7 = new AddShortCutItemV2(r3);
        goto L22
    L16:
        r7 = new ManualCacheItemV2(r3);
        goto L22
    L19:
        r7 = new ShortcutItemV2(r3);
        goto L22
    L20:
        r7 = new RenameItemV2(r3);
        goto L22
    L5:
        throw new IllegalArgumentException("more item is not exists: id = " + r4.getId());
    L23:
        return new RetentionItemV2();
    L24:
        return new SubscribeCommentItemV2();
    L25:
        return new SubscribeItemV2();
    L26:
        return new ReportItemV2();
    L27:
        return new ContactServiceItemV2();
    L28:
        return new PermissionItemV2(r6);
    L29:
        return new PinItemV2(r5);
    L30:
        return new StarItemV2();
    }

    @Override // com.bytedance.ee.bear.more.b
    public final void C(FragmentActivity r9, BaseMoreProvider r10, Fragment r11, View r12, int r13) {
        z(r9, r10, r11, r12, r13, ForsetiNavOptions.DestinationStyle.HALF_FLOAT, false);
    }

    @Override // com.bytedance.ee.bear.more.b
    public final Map<String, Boolean> H(int r4, boolean r5, boolean r6, BenefitStore r7, BenefitStore r8) {
        Map<String, Boolean> r0 = m(r4, r5, r6, r8);
        if (r4 != 22) goto L5;
    L14:
        HashMap r2 = (HashMap) r0;
        r2.put(CommonMoreItemId.APPLY_EDIT_PERMISSION.getId(), Boolean.valueOf(r7.hasBenefit("common_apply_doc_edit_permission")));
        r2.put(CommonMoreItemId.RENAME.getId(), Boolean.valueOf(r7.hasBenefit("common_doc_rename")));
        r2.put(CommonMoreItemId.TEMPLATE_SWITCH.getId(), Boolean.valueOf(r7.hasBenefit("common_convert_doc_to_template")));
        r2.put(com.bytedance.ee.bear.more.protocol3.f.z.c.a, Boolean.valueOf(r7.hasBenefit("ccm_page_settings_edit")));
    L15:
        if (r5 == false) goto L18;
        if (r6 == false) goto L18;
        HashMap r9 = (HashMap) r0;
        r9.put(CommonMoreItemId.RENAME.getId(), Boolean.valueOf(r8.hasBenefit("common_wiki_node_management")));
    L18:
        return r0;
    L5:
        if (r4 == 3) goto L14;
        if (r4 == 11) goto L14;
        if (r4 == 30) goto L14;
        if (r4 != 8) goto L15;
        HashMap r3 = (HashMap) r0;
        r3.put(CommonMoreItemId.APPLY_EDIT_PERMISSION.getId(), Boolean.valueOf(r7.hasBenefit("common_apply_base_edit_permission")));
        r3.put(CommonMoreItemId.RENAME.getId(), Boolean.valueOf(r7.hasBenefit("common_base_rename")));
        r3.put(CommonMoreItemId.TEMPLATE_SWITCH.getId(), Boolean.valueOf(r7.hasBenefit("common_convert_base_to_template")));
        goto L15
    }

    @Override // com.bytedance.ee.bear.more.b
    public final BaseMoreItem g(FragmentActivity r2, CommonMoreItemId r3, jdb.g r4, by4.d r5, String r6) {
        if (r3 != CommonMoreItemId.MAKE_COPY) goto L8;
        if (r6 == null) goto L8;
        return new MakeCopyItemV2(r2, r6);
    L8:
        return q(r2, r3, r4, r5);
    }

    @Override // com.bytedance.ee.bear.more.b
    public final PermissionResponse t(String r9, oj5.c r10, BizDomain r11, String r12, Object r13) {
        if (r10 == null) goto L5;
        UniBaseEntity r7 = new UniBaseEntity(r9, sbb.e.d(r10.getType()), r11, r10.a(), r10.d(), null);
        return ((ph5.b) org.koin.java.a.a(ph5.b.class)).f(new PermissionRequest(r7, r12), R(r10, r13));
    L5:
        PermissionResponse.Companion.getClass();
        return PermissionResponse.a.a();
    }

    @Override // com.bytedance.ee.bear.more.b
    public final PermissionResponse M(String r9, int r10, String r11, String r12, BizDomain r13, String r14) {
        UniBaseEntity r7 = new UniBaseEntity(r9, sbb.e.d(r10), r13, r11, r12, sbb.e.e);
        return ((ph5.b) org.koin.java.a.a(ph5.b.class)).f(new PermissionRequest(r7, r14), null);
    }

    @Override // com.bytedance.ee.bear.more.b
    public final void z(FragmentActivity r15, com.bytedance.ee.bear.more.protocol3.h r16, Fragment r17, View r18, int r19, ForsetiNavOptions.DestinationStyle r20, boolean r21) {
        if (com.bytedance.ee.util.ui.b.a(r15) == true) goto L6;
        return;
    L6:
        if (r15.getSupportFragmentManager().findFragmentByTag(MoreFragmentV3.class.getName()) == null) goto L8;
        boolean r1 = true;
    L9:
        tt5.a.h("MoreImpl", "showMoreV3PopOver. isMoreShowing: " + r1 + " sourceFragment:" + r17);
        if (r1 == false) goto L12;
        return;
    L12:
        ((MoreViewModelV3) ViewModelProviders.of(r15).get(MoreViewModelV3.class)).init(r16);
        final String r10 = MoreFragmentV3.class.getName();
        final FragmentManager r2 = r15.getSupportFragmentManager();
        final DialogFragment r4 = Fragment.instantiate(r15, r10);
        r4.setArguments(r16.c);
        if (ForsetiHelper.s(r17) == false) goto L15;
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f.f(r4, r15, r20, false, r18, r19, r10, r17, r21, new g(r4, r2, r10));
        return;
    L15:
        Q(r4, r2, r10);
        return;
    L8:
        r1 = false;
        goto L9
    }
}
