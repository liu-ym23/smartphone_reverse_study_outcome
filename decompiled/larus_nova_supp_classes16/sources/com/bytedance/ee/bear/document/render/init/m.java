package com.bytedance.ee.bear.document.render.init;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentFragment;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.z5;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m implements z5 {
    public final DocViewModel a;
    public final Fragment b;
    public final DocumentPluginHost c;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.content.Intent] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.Serializable, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r4v7 */
    @Override // com.bytedance.ee.bear.document.z5
    public final void reloadDocumentFragment(String r9, Map<String, String> r10) {
        if (r9 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r9) == false) goto L9;
        tt5.a.k("DocumentReloadAbilityImpl", "the documentFragment or its origin url is null");
        return;
    L9:
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == false) goto L24;
        Bundle r0 = this.b.getArguments();
        if (r0 != null) goto L13;
        r0 = new Bundle();
    L13:
        r0.putString("url", r9);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L16
        Object r3 = Result.constructor-impl(p.a().Z(p.a().v8(r9)));     // Catch: Throwable -> L16
    L19:
        if (Result.isSuccess-impl(r3) == false) goto L21;
        r0.putParcelable("bear_url", (BearUrl) r3);
    L21:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L25;
        tt5.a.l("DocumentReloadAbilityImpl", "parse reload url failed", r4);
    L25:
        FragmentManager r5 = this.b.getFragmentManager();
        ?? r6 = 0;
        if (r5 == null) goto L83;
        WikiInfo r7 = this.a.getWikiInfo();
        if (fx4.a.g(this.a.getOriginBearUrl()) == false) goto L56;
        if (r7 == null) goto L56;
        if (r7.getObjType() != 8) goto L56;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L34
        Object r11 = Result.constructor-impl(((dn4.a) this.c.getUserComponent().a(dn4.a.class)).a());     // Catch: Throwable -> L34
    L37:
        if (Result.isFailure-impl(r11) == false) goto L39;
        r11 = null;
    L39:
        jdb.g r12 = (jdb.g) r11;
        if (r12 == null) goto L44;
        boolean r13 = true;
        if (r12.isCurrentEnable("ccm.bitable.wiki.fix_reload") != true) goto L44;
    L45:
        if (r13 == false) goto L56;
        String r14 = r7.getObjTypeString();
        Object r16 = Result.constructor-impl(this.c.getUserComponent().b());     // Catch: Throwable -> L49
    L52:
        if (Result.exceptionOrNull-impl(r16) == null) goto L55;
        r16 = PassportcConvention.b(this.b);
    L55:
        BaseFragment r17 = DocumentFragment.la0(r14, r9, r0, (UserSession) r16);
    L57:
        FragmentTransaction r1 = r5.beginTransaction();
        int r18 = this.b.getId();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r17, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r18) == true) goto L61;
        r1 = r1.replace(r18, r17);
    L61:
        r1.commitAllowingStateLoss();
    L49:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L44:
        r13 = false;
    L34:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L56:
        r17 = DocumentFragment.ka0(r9, r0);
    L83:
        FragmentActivity r21 = this.b.getActivity();     // Catch: Throwable -> L76
        if (r21 == null) goto L87;
        ?? r22 = r21.getIntent();     // Catch: Throwable -> L76
        if (r22 == 0) goto L88;
        Serializable r23 = r22.getSerializableExtra("extra_data_map");     // Catch: Throwable -> L76
        if (TypeIntrinsics.isMutableMap(r23) == false) goto L71;
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String?, kotlin.String?>");     // Catch: Throwable -> L76
        r6 = TypeIntrinsics.asMutableMap(r23);     // Catch: Throwable -> L76
    L71:
        if (r6 != 0) goto L73;
        r6 = new HashMap();     // Catch: Throwable -> L76
        r22.putExtra("extra_data_map", r6);     // Catch: Throwable -> L76
    L73:
        if (r10 == null) goto L89;
        ((Map) r6).putAll(r10);     // Catch: Throwable -> L76
        return;
    L89:
        return;
    L88:
        return;
    L87:
        return;
    L76:
        th = move-exception;
        tt5.a.e("DocumentReloadAbilityImpl", "parse route extra data error!", th, false);
        return;
    L16:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L24:
        r0 = this.b.getArguments();
        goto L25
    }

    public m(DocViewModel r2, Fragment r3, DocumentPluginHost r4) {
        Intrinsics.checkNotNullParameter(r2, "docViewModel");
        Intrinsics.checkNotNullParameter(r3, "documentFragment");
        Intrinsics.checkNotNullParameter(r4, "pluginHost");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
