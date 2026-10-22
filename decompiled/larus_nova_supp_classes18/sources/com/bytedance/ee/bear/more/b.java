package com.bytedance.ee.bear.more;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.more.DocFreshNessPlugin;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.more.export.PageviewUIHolder;
import com.bytedance.ee.bear.more.itemv2.CopyLinkItemV2;
import com.bytedance.ee.bear.more.itemv2.MakeCopyItemV2;
import com.bytedance.ee.bear.more.itemv2.MultiTaskMoreItem;
import com.bytedance.ee.bear.more.itemv2.SecretMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem;
import com.bytedance.ee.bear.more.protocol3.extension.BaseMoreProvider;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import io.reactivex.Flowable;
import java.util.Map;
import rj5.h0;
import rj5.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface b {
    CopyLinkItemV2 A(String r1, String r2);

    Boolean B(oj5.c r1, ShareFolderUserPermission r2, String r3);

    void C(FragmentActivity r1, BaseMoreProvider r2, Fragment r3, View r4, int r5);

    h0 D();

    void E(m r1);

    MultiTaskMoreItem F(sj5.c r1);

    rj5.l G();

    Map<String, Boolean> H(int r1, boolean r2, boolean r3, BenefitStore r4, BenefitStore r5);

    void I(l r1);

    void J(FragmentActivity r1, BaseMoreProvider r2, Fragment r3);

    void K(j r1);

    void L(String r1, String r2, DocFreshNessPlugin r3);

    PermissionResponse M(String r1, int r2, String r3, String r4, BizDomain r5, String r6);

    SecretMoreItem N();

    void O(FragmentActivity r1, com.bytedance.ee.bear.more.protocol3.h r2);

    v P(a r1);

    IBaseMoreItem a(FragmentActivity r1);

    void b(String r1);

    void c(i r1);

    com.bytedance.ee.bear.more.itemv2.mainnav.b d(wb5.d r1);

    void e(FragmentActivity r1, com.bytedance.ee.bear.more.protocol3.h r2, Fragment r3, int r4);

    PermissionResponse f(oj5.c r1, String r2);

    BaseMoreItem g(FragmentActivity r1, CommonMoreItemId r2, jdb.g r3, by4.d r4, String r5);

    void h();

    Flowable<Boolean> i(String r1);

    void j(PageviewUIHolder r1);

    void k(p r1);

    boolean l(String r1);

    Map<String, Boolean> m(int r1, boolean r2, boolean r3, BenefitStore r4);

    void n(String r1, qj5.b r2);

    PermissionResponse o(oj5.c r1, String r2, Object r3);

    void p(String r1, qj5.b r2);

    BaseMoreItem q(FragmentActivity r1, CommonMoreItemId r2, jdb.g r3, by4.d r4);

    rj5.k r();

    void s(oj5.c r1, String r2);

    PermissionResponse t(String r1, oj5.c r2, BizDomain r3, String r4, Object r5);

    Boolean u(ShareFolderUserPermission r1, String r2);

    Boolean v(oj5.c r1, IDocUserPermission r2, String r3);

    MakeCopyItemV2 w(FragmentActivity r1, String r2);

    rj5.a x(PluginHost r1);

    void y();

    void z(FragmentActivity r1, com.bytedance.ee.bear.more.protocol3.h r2, Fragment r3, View r4, int r5, ForsetiNavOptions.DestinationStyle r6, boolean r7);
}
