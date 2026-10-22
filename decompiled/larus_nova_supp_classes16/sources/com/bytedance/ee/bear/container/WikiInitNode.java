package com.bytedance.ee.bear.container;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.wikiv2.browser.plugin.p0;
import com.bytedance.ee.bear.wikiv2.route.WikiRouteTable;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.component.universe_design.toast.UDToast;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class WikiInitNode implements bk5.b {

    public static final class a {
    }

    public static final class b {
        public final WikiInfo a;
        public final WikiInfo b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            WikiInfo r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "WikiLoadResult(wikiInfo=" + this.a + ", loadedInfoBefore=" + this.b + ')';
        }

        public b(WikiInfo r2, WikiInfo r3) {
            Intrinsics.checkNotNullParameter(r2, "wikiInfo");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public WikiInitNode() {
    }

    public final String toString() {
        return "MockWikiInitNode";
    }

    public static WikiInfo c(bk5.a r2) {
        Serializable r0 = r2.h9().getSerializable("wiki_info");
        if ((r0 instanceof WikiInfo) == true) goto L9;
        if (r0 == null) goto L7;
        tt5.a.k("MockWikiInitNode", r2.getTAG() + ", wiki info argument type invalid: " + r0.getClass().getName());
    L7:
        return null;
    L9:
        return (WikiInfo) r0;
    }

    public final boolean b(BearUrl r2, bk5.e r3, bk5.a r4) {
        Intrinsics.checkNotNullParameter(r2, "bearUrl");
        Intrinsics.checkNotNullParameter(r3, "loaderTypeBefore");
        Intrinsics.checkNotNullParameter(r4, "container");
        return fx4.a.g(r2);
    }

    public final Object a(BearUrl r21, bk5.e r22, bk5.a r23, Continuation<? super bk5.e> r24) {
        BearUrl r0 = r21;
        if ((r24 instanceof WikiInitNode$run$1) == false) goto L7;
        WikiInitNode$run$1 r3 = (WikiInitNode$run$1) r24;
        int r4 = r3.label;
        if ((r4 & ShareItemModel.SRC_TINT_UNDEFINED) == 0) goto L7;
        r3.label = r4 - ShareItemModel.SRC_TINT_UNDEFINED;
    L8:
        WikiInitNode$run$1 r10 = r3;
        Object r2 = r10.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r10.label;
        String r7 = "MockWikiInitNode";
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        WikiInfo r1 = (WikiInfo) r10.L$6;
        ce5.a r6 = (ce5.a) r10.L$5;
        String r8 = (String) r10.L$4;
        Bundle r9 = (Bundle) r10.L$3;
        bk5.a r12 = (bk5.a) r10.L$2;
        bk5.e r13 = (bk5.e) r10.L$1;
        BearUrl r14 = (BearUrl) r10.L$0;
        ResultKt.throwOnFailure(r2);
        WikiInfo r16 = r1;
        r0 = r14;
    L60:
        b r17 = (b) r2;
        Bundle r18 = r9;
        ce5.a r19 = r6;
        BearUrl r20 = r0;
        String r26 = r8;
        WikiInfo r27 = r16;
    L61:
        if (r27 == null) goto L63;
        String r28 = r27.getObjToken();
    L64:
        d25.d.j(r20, r28);
        d25.d.l(r20);
        if (r17 == null) goto L150;
        WikiInfo r29 = r17.a;
        if (r29 == null) goto L150;
        String r30 = r29.getWikiToken();
        if (r30 != null) goto L71;
    L74:
        boolean r31 = true;
    L75:
        if (r31 == false) goto L78;
        r29.setWikiToken(r26);
    L78:
        if (r29.isValidObjInfo() == true) goto L81;
        r29 = null;
    L81:
        if (r29 == null) goto L150;
        AtomicBoolean r32 = a05.c.r;
        a05.c.w = System.currentTimeMillis();
        d25.d.h = sbb.e.f(r29.getObjType());
        if (r29.getObjType() != 12) goto L86;
    L87:
        p0.b(r29.getWikiToken(), r19);
    L88:
        r18.putString(DocViewModel.EXTRA_SPACE_ID, r29.getSpaceId());
        WikiInfo r33 = r17.b;
        if (r33 == null) goto L93;
        if (r33.getInSpace() == false) goto L93;
    L95:
        boolean r34 = false;
    L96:
        tt5.a.h(r7, "checkMovToSpace: isMovToSpace:" + r34);
        if (r34 == false) goto L114;
        tt5.a.h(r7, "This wiki has been moved to space. objToken: " + du5.b.i(r29.getObjToken()));
        Activity r36 = r12.getActivity();
        if (r36 == null) goto L102;
        UDToast.a r37 = UDToast.build(r36);
        r37.b.e(2131887477);
        r37.h();
    L102:
        WikiRouteTable.c(yq5.a0.a(r29), !TextUtils.isEmpty(r18.getString("redirect")));
        BearUrl r38 = s45.p.a().Z(s45.p.a().Fd(r20.e, r29.getObjTypeString(), r29.getObjToken(), r20.d));
        r18.putParcelable("bear_url", r38);
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L109
        String r40 = r29.getWikiToken();     // Catch: Throwable -> L109
        String r110 = r38.b;     // Catch: Throwable -> L109
        if (r110 == null) goto L106;
        int r111 = com.bytedance.ee.bear.route.c.a;     // Catch: Throwable -> L109
        com.bytedance.ee.bear.route.c.c(r110, r38.e, com.bytedance.ee.bear.route.c.b(r40), com.bytedance.ee.bear.route.c.a(r110));     // Catch: Throwable -> L109
        r12.h9().putString("url", r38.e);     // Catch: Throwable -> L109
        r12.h9().putParcelable("url", r38);     // Catch: Throwable -> L109
        r12.o0(r12.h9());     // Catch: Throwable -> L109
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L109
    L107:
        Object r41 = Result.constructor-impl(r112);     // Catch: Throwable -> L109
    L111:
        Throwable r42 = Result.exceptionOrNull-impl(r41);
        if (r42 == null) goto L114;
        tt5.a.e(r7, "redirectInNavigationIfNeeded failed", r42, false);
        goto L114
    L106:
        r112 = null;
    L109:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        r41 = Result.constructor-impl(ResultKt.createFailure(th));
    L114:
        r18.putSerializable("wiki_info", r29);
        tt5.a.h(r7, r12.getTAG() + ", wiki info loaded, objType=" + r29.getObjType() + ", fromCache=" + r29.from_cache);
        String r44 = r20.e;
        if (fx4.a.c(r29.getObjType()) == true) goto L117;
        sbb.e r46 = sbb.e.d(r29.getObjType());
        if (r46 != null) goto L144;
    L146:
        boolean r113 = false;
    L147:
        if (r113 == true) goto L149;
        return r13;
    L149:
        return bk5.e.c.b;
    L144:
        if (TextUtils.equals(r46.getType(), sbb.e.l.getType()) == false) goto L146;
        r113 = true;
        goto L147
    L117:
        if (AppInfoUtils.f().booleanValue() == false) goto L157;
        if (fx4.a.e(r29.getObjType()) == true) goto L157;
        tt5.a.h(r7, "not support type");
        int r47 = com.ss.android.lark.router.c.a;
        Activity r48 = r12.getActivity();
        int r49 = r29.getObjType();
        Result.Companion r50 = Result.Companion;     // Catch: Throwable -> L130
        Uri r51 = UriProtector.parse(r44);     // Catch: Throwable -> L130
        if (TextUtils.equals(UriProtector.getQueryParameter(r51, "ccm_skip_officesdk_route"), DiagramData$RESULT.SUCCESS) == false) goto L124;
        String r52 = r44;
    L125:
        String r53 = ((t45.c) LarkContext.spiByDwarf(t45.c.class)).T6(r52, Integer.valueOf(r49));     // Catch: Throwable -> L130
        if (r53 != null) goto L128;
        r53 = "";
    L128:
        Object r54 = Result.constructor-impl(r53);     // Catch: Throwable -> L130
    L132:
        Throwable r56 = Result.exceptionOrNull-impl(r54);
        if (r56 == null) goto L135;
        tt5.a.e(r7, "buildUnsupportedTypeUrl failed", r56, false);
    L135:
        Object r57 = r44;
        if (Result.isFailure-impl(r54) == true) goto L139;
        r57 = r54;
    L139:
        com.ss.android.lark.router.c.b(r48, (String) r57);
        com.bytedance.ee.util.ui.j.d(new b0(r12), 500);
        return r13;
    L124:
        String r58 = r51.buildUpon().appendQueryParameter("ccm_skip_officesdk_route", DiagramData$RESULT.SUCCESS).build().toString();     // Catch: Throwable -> L130
        Intrinsics.checkNotNull(r58);     // Catch: Throwable -> L130
        r52 = r58;
    L130:
        th = move-exception;
        Result.Companion r59 = Result.Companion;
        r54 = Result.constructor-impl(ResultKt.createFailure(th));
    L157:
        return bk5.e.b.b;
    L93:
        if (r29.getInSpace() == false) goto L95;
        r34 = true;
        goto L96
    L86:
        if (r29.getObjType() != 111) goto L88;
    L71:
        if (StringsKt.isBlank(r30) == true) goto L74;
        r31 = false;
    L150:
        tt5.a.d(r7, r12.getTAG() + ", pull wiki info failed, wikiToken=" + r26);
        return r13;
    L63:
        r28 = null;
        goto L64
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        Bundle r60 = r23.h9();
        String r61 = r0.b;
        if (r61 != null) goto L17;
    L19:
        String r62 = null;
    L20:
        if (r62 != null) goto L22;
    L25:
        boolean r63 = true;
    L26:
        if (r63 == false) goto L29;
        tt5.a.d("MockWikiInitNode", r23.getTAG() + ", wiki token is empty");
        return r22;
    L29:
        AtomicBoolean r64 = a05.c.r;
        a05.c.v = System.currentTimeMillis();
        r19 = new ce5.a(r23.j9());
        r27 = c(r23);
        if (r27 == null) goto L46;
        String r66 = r27.getWikiToken();
        if (r66 != null) goto L34;
    L37:
        boolean r67 = true;
    L38:
        if (r67 == false) goto L41;
        r27.setWikiToken(r62);
    L41:
        if (r27.isValidObjInfo() == false) goto L43;
        WikiInfo r68 = r27;
    L44:
        if (r68 == null) goto L46;
        r17 = new b(r68, null);
        r18 = r60;
        r7 = "MockWikiInitNode";
        r13 = r22;
        r20 = r0;
        r26 = r62;
        r12 = r23;
        goto L61
    L43:
        r68 = null;
        goto L44
    L34:
        if (StringsKt.isBlank(r66) == true) goto L37;
        r67 = false;
    L46:
        r10.L$0 = r0;
        r10.L$1 = r22;
        r10.L$2 = r23;
        r10.L$3 = r60;
        r10.L$4 = r62;
        r10.L$5 = r19;
        r10.L$6 = r27;
        r10.label = 1;
        kotlinx.coroutines.j r69 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r10), 1);
        r69.C();
        AtomicReference r114 = new AtomicReference();
        Ref.ObjectRef r115 = new Ref.ObjectRef();
        WikiInfo r116 = c(r23);
        if (((dn4.a) r19.a(dn4.a.class)).a().isCurrentEnable("ccm.mobile.doc_upgrade_to_docx_v2") == true) goto L49;
    L53:
        boolean r70 = false;
    L54:
        r16 = r27;
        String r117 = r62;
        final Disposable r71 = p0.d(r62, r116, r19, r70).subscribe(new x(r23, r69, r114, this, r115), new y(r23, r69), new z(r115, r23, r69), a0.a);
        r69.i(new WikiInitNode$pullWikiInfo$2$1(r71));
        r2 = r69.B();
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L57;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L57:
        if (r2 != r11) goto L59;
        return r11;
    L59:
        r13 = r22;
        r12 = r23;
        r9 = r60;
        r6 = r19;
        r8 = r117;
        goto L60
    L49:
        if (fx4.a.f(r0.e) == false) goto L53;
        if (Intrinsics.areEqual(r0.d.get("is_docx_wiki"), DiagramData$RESULT.SUCCESS) == true) goto L53;
        r70 = true;
        goto L54
    L22:
        if (StringsKt.isBlank(r62) == true) goto L25;
        r63 = false;
        goto L26
    L17:
        if ((!StringsKt.isBlank(r61)) == false) goto L19;
        r62 = r61;
    L7:
        r3 = new WikiInitNode$run$1(this, r24);
        goto L8
    }
}
