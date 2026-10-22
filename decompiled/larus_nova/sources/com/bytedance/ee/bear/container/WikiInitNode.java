package com.bytedance.ee.bear.container;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.wikiv2.browser.plugin.p0;
import com.bytedance.ee.bear.wikiv2.route.WikiRouteTable;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class WikiInitNode implements bk5.b {

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WikiInfo f216740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WikiInfo f216741b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f216740a, r101.f216740a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f216741b, r101.f216741b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f216740a.hashCode() * 31;
            WikiInfo r101 = this.f216741b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "WikiLoadResult(wikiInfo=" + this.f216740a + ", loadedInfoBefore=" + this.f216741b + ')';
        }

        public b(WikiInfo r100, WikiInfo r101) {
            Intrinsics.checkNotNullParameter(r100, "wikiInfo");
            this.f216740a = r100;
            this.f216741b = r101;
        }
    }

    static {
    }

    public WikiInitNode() {
    }

    public final String toString() {
        return "MockWikiInitNode";
    }

    public static WikiInfo c(bk5.a r100) {
        Serializable r101 = r100.h9().getSerializable("wiki_info");
        if ((r101 instanceof WikiInfo) == true) goto L9;
        if (r101 == null) goto L7;
        tt5.a.k("MockWikiInitNode", r100.getTAG() + ", wiki info argument type invalid: " + r101.getClass().getName());
    L7:
        return null;
    L9:
        return (WikiInfo) r101;
    }

    @Override // bk5.b
    public final boolean b(BearUrl r100, bk5.e r101, bk5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bearUrl");
        Intrinsics.checkNotNullParameter(r101, "loaderTypeBefore");
        Intrinsics.checkNotNullParameter(r102, KtvSubElement.CONTAINER);
        return fx4.a.g(r100);
    }

    @Override // bk5.b
    public final Object a(BearUrl r210, bk5.e r211, bk5.a r212, Continuation<? super bk5.e> r213) {
        BearUrl r100 = r210;
        if ((r213 instanceof WikiInitNode$run$1) == false) goto L7;
        WikiInitNode$run$1 r101 = (WikiInitNode$run$1) r213;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        WikiInitNode$run$1 r110 = r101;
        Object r103 = r110.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r110.label;
        String r105 = "MockWikiInitNode";
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        WikiInfo r106 = (WikiInfo) r110.L$6;
        ce5.a r107 = (ce5.a) r110.L$5;
        String r108 = (String) r110.L$4;
        Bundle r109 = (Bundle) r110.L$3;
        bk5.a r112 = (bk5.a) r110.L$2;
        bk5.e r113 = (bk5.e) r110.L$1;
        BearUrl r114 = (BearUrl) r110.L$0;
        ResultKt.throwOnFailure(r103);
        WikiInfo r115 = r106;
        r100 = r114;
    L60:
        b r116 = (b) r103;
        Bundle r117 = r109;
        ce5.a r118 = r107;
        BearUrl r119 = r100;
        String r120 = r108;
        WikiInfo r121 = r115;
    L61:
        if (r121 == null) goto L63;
        String r122 = r121.getObjToken();
    L64:
        d25.d.j(r119, r122);
        d25.d.l(r119);
        if (r116 == null) goto L150;
        WikiInfo r123 = r116.f216740a;
        if (r123 == null) goto L150;
        String r124 = r123.getWikiToken();
        if (r124 != null) goto L71;
    L74:
        boolean r125 = true;
    L75:
        if (r125 == false) goto L78;
        r123.setWikiToken(r120);
    L78:
        if (r123.isValidObjInfo() == true) goto L81;
        r123 = null;
    L81:
        if (r123 == null) goto L150;
        AtomicBoolean r126 = a05.c.f1283r;
        a05.c.f1288w = System.currentTimeMillis();
        d25.d.f466521h = sbb.e.f(r123.getObjType());
        if (r123.getObjType() != 12) goto L86;
    L87:
        p0.b(r123.getWikiToken(), r118);
    L88:
        r117.putString(DocViewModel.EXTRA_SPACE_ID, r123.getSpaceId());
        WikiInfo r127 = r116.f216741b;
        if (r127 == null) goto L93;
        if (r127.getInSpace() == false) goto L93;
    L95:
        boolean r128 = false;
    L96:
        tt5.a.h(r105, "checkMovToSpace: isMovToSpace:" + r128);
        if (r128 == false) goto L114;
        tt5.a.h(r105, "This wiki has been moved to space. objToken: " + du5.b.i(r123.getObjToken()));
        Activity r129 = r112.getActivity();
        if (r129 == null) goto L102;
        UDToast.a r130 = UDToast.build(r129);
        r130.f285429b.e(R.string.CreationMobile_Wiki_GoingToDocs);
        r130.h();
    L102:
        WikiRouteTable.c(yq5.a0.a(r123), !TextUtils.isEmpty(r117.getString("redirect")));
        BearUrl r131 = s45.p.a().Z(s45.p.a().Fd(r119.f222564e, r123.getObjTypeString(), r123.getObjToken(), r119.f222563d));
        r117.putParcelable("bear_url", r131);
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L109
        String r133 = r123.getWikiToken();     // Catch: Throwable -> L109
        String r134 = r131.f222561b;     // Catch: Throwable -> L109
        if (r134 == null) goto L106;
        int r135 = com.bytedance.ee.bear.route.c.f236659a;     // Catch: Throwable -> L109
        com.bytedance.ee.bear.route.c.c(r134, r131.f222564e, com.bytedance.ee.bear.route.c.b(r133), com.bytedance.ee.bear.route.c.a(r134));     // Catch: Throwable -> L109
        r112.h9().putString("url", r131.f222564e);     // Catch: Throwable -> L109
        r112.h9().putParcelable("url", r131);     // Catch: Throwable -> L109
        r112.o0(r112.h9());     // Catch: Throwable -> L109
        Unit r136 = Unit.INSTANCE;     // Catch: Throwable -> L109
    L107:
        Object r137 = Result.m9449constructorimpl(r136);     // Catch: Throwable -> L109
    L111:
        Throwable r138 = Result.m9452exceptionOrNullimpl(r137);
        if (r138 == null) goto L114;
        tt5.a.e(r105, "redirectInNavigationIfNeeded failed", r138, false);
        goto L114
    L106:
        r136 = null;
    L109:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L114:
        r117.putSerializable("wiki_info", r123);
        tt5.a.h(r105, r112.getTAG() + ", wiki info loaded, objType=" + r123.getObjType() + ", fromCache=" + r123.from_cache);
        String r140 = r119.f222564e;
        if (fx4.a.c(r123.getObjType()) == true) goto L117;
        sbb.e r141 = sbb.e.d(r123.getObjType());
        if (r141 != null) goto L144;
    L146:
        boolean r142 = false;
    L147:
        if (r142 == true) goto L149;
        return r113;
    L149:
        return bk5.e.c.f19367b;
    L144:
        if (TextUtils.equals(r141.getType(), sbb.e.f541301l.getType()) == false) goto L146;
        r142 = true;
        goto L147
    L117:
        if (AppInfoUtils.f().booleanValue() == false) goto L157;
        if (fx4.a.e(r123.getObjType()) == true) goto L157;
        tt5.a.h(r105, "not support type");
        int r143 = com.ss.android.lark.router.c.f439675a;
        Activity r144 = r112.getActivity();
        int r145 = r123.getObjType();
        Result.Companion r146 = Result.Companion;     // Catch: Throwable -> L130
        Uri r147 = UriProtector.parse(r140);     // Catch: Throwable -> L130
        if (TextUtils.equals(UriProtector.getQueryParameter(r147, "ccm_skip_officesdk_route"), "1") == false) goto L124;
        String r148 = r140;
    L125:
        String r149 = ((t45.c) LarkContext.spiByDwarf(t45.c.class)).T6(r148, Integer.valueOf(r145));     // Catch: Throwable -> L130
        if (r149 != null) goto L128;
        r149 = "";
    L128:
        Object r150 = Result.m9449constructorimpl(r149);     // Catch: Throwable -> L130
    L132:
        Throwable r151 = Result.m9452exceptionOrNullimpl(r150);
        if (r151 == null) goto L135;
        tt5.a.e(r105, "buildUnsupportedTypeUrl failed", r151, false);
    L135:
        Object r152 = r140;
        if (Result.m9455isFailureimpl(r150) == true) goto L139;
        r152 = r150;
    L139:
        com.ss.android.lark.router.c.b(r144, (String) r152);
        com.bytedance.ee.util.ui.j.d(new b0(r112), 500);
        return r113;
    L124:
        String r153 = r147.buildUpon().appendQueryParameter("ccm_skip_officesdk_route", "1").build().toString();     // Catch: Throwable -> L130
        Intrinsics.checkNotNull(r153);     // Catch: Throwable -> L130
        r148 = r153;
    L130:
        th = move-exception;
        Result.Companion r154 = Result.Companion;
        r150 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L157:
        return bk5.e.b.f19366b;
    L93:
        if (r123.getInSpace() == false) goto L95;
        r128 = true;
        goto L96
    L86:
        if (r123.getObjType() != 111) goto L88;
    L71:
        if (StringsKt.isBlank(r124) == true) goto L74;
        r125 = false;
    L150:
        tt5.a.d(r105, r112.getTAG() + ", pull wiki info failed, wikiToken=" + r120);
        return r113;
    L63:
        r122 = null;
        goto L64
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        Bundle r155 = r212.h9();
        String r156 = r100.f222561b;
        if (r156 != null) goto L17;
    L19:
        String r157 = null;
    L20:
        if (r157 != null) goto L22;
    L25:
        boolean r158 = true;
    L26:
        if (r158 == false) goto L29;
        tt5.a.d("MockWikiInitNode", r212.getTAG() + ", wiki token is empty");
        return r211;
    L29:
        AtomicBoolean r159 = a05.c.f1283r;
        a05.c.f1287v = System.currentTimeMillis();
        r118 = new ce5.a(r212.j9());
        r121 = c(r212);
        if (r121 == null) goto L46;
        String r160 = r121.getWikiToken();
        if (r160 != null) goto L34;
    L37:
        boolean r161 = true;
    L38:
        if (r161 == false) goto L41;
        r121.setWikiToken(r157);
    L41:
        if (r121.isValidObjInfo() == false) goto L43;
        WikiInfo r162 = r121;
    L44:
        if (r162 == null) goto L46;
        r116 = new b(r162, null);
        r117 = r155;
        r105 = "MockWikiInitNode";
        r113 = r211;
        r119 = r100;
        r120 = r157;
        r112 = r212;
        goto L61
    L43:
        r162 = null;
        goto L44
    L34:
        if (StringsKt.isBlank(r160) == true) goto L37;
        r161 = false;
    L46:
        r110.L$0 = r100;
        r110.L$1 = r211;
        r110.L$2 = r212;
        r110.L$3 = r155;
        r110.L$4 = r157;
        r110.L$5 = r118;
        r110.L$6 = r121;
        r110.label = 1;
        kotlinx.coroutines.j r163 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r110), 1);
        r163.C();
        AtomicReference r164 = new AtomicReference();
        Ref.ObjectRef r165 = new Ref.ObjectRef();
        WikiInfo r166 = c(r212);
        if (((dn4.a) r118.a(dn4.a.class)).a().isCurrentEnable("ccm.mobile.doc_upgrade_to_docx_v2") == true) goto L49;
    L53:
        boolean r167 = false;
    L54:
        r115 = r121;
        String r168 = r157;
        final Disposable r169 = p0.d(r157, r166, r118, r167).subscribe(new x(r212, r163, r164, this, r165), new y(r212, r163), new z(r165, r212, r163), a0.f216743a);
        r163.i(new WikiInitNode$pullWikiInfo$2$1(r169));
        r103 = r163.B();
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L57;
        DebugProbesKt.probeCoroutineSuspended(r110);
    L57:
        if (r103 != r111) goto L59;
        return r111;
    L59:
        r113 = r211;
        r112 = r212;
        r109 = r155;
        r107 = r118;
        r108 = r168;
        goto L60
    L49:
        if (fx4.a.f(r100.f222564e) == false) goto L53;
        if (Intrinsics.areEqual(r100.f222563d.get("is_docx_wiki"), "1") == true) goto L53;
        r167 = true;
        goto L54
    L22:
        if (StringsKt.isBlank(r157) == true) goto L25;
        r158 = false;
        goto L26
    L17:
        if ((!StringsKt.isBlank(r156)) == false) goto L19;
        r157 = r156;
    L7:
        r101 = new WikiInitNode$run$1(this, r213);
        goto L8
    }
}
