package com.bytedance.ee.bear.docs;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.bitable.preload.k;
import com.bytedance.ee.bear.container.ContainerFragment;
import com.bytedance.ee.bear.contract.n;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.document.b4;
import com.bytedance.ee.bear.document.container.DocumentImpl;
import com.bytedance.ee.bear.document.export.net.exportV2.MinutesExportExecutorImpl;
import com.bytedance.ee.bear.document.s2;
import com.bytedance.ee.bear.document.ssr.h;
import com.bytedance.ee.bear.document.ssr.j;
import com.bytedance.ee.bear.document.v4;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.list.cover.CoverLoader;
import com.bytedance.ee.bear.list.create.i;
import com.bytedance.ee.bear.list.create.r0;
import com.bytedance.ee.bear.list.delete.DeleteExecutor;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.recent.f;
import com.larus.office.base.service.OfficeSdkServiceV2;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleonv2.Chameleon;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t45.c;
import y15.d;
import y15.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@UserScope
public final class UserDocsSdkImpl implements ik5.a {
    public final m a;
    public final com.bytedance.ee.bear.init.a b;
    public final com.bytedance.ee.bear.init.b c;
    public final c d;
    public final x05.a e;
    public final b f;

    public static final class a {
    }

    public static final class b implements jk5.a {
        public b() {
        }

        public final void a() {
            Intrinsics.checkNotNullParameter("TTS_PLAYING", "menuId");
            Integer r0 = 2131820618;
            Map<String, e> r2 = d.a;
            e r3 = new e(0, 0, r0.intValue());
            ((HashMap) d.a).put("TTS_PLAYING", r3);
        }

        public final void b(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "menuId");
            d.e(r2, r3, 2131103136);
        }
    }

    static {
    }

    public final String J9() {
        String r0 = this.a.getUser().userId;
        long r1 = System.currentTimeMillis();
        FolderVersion.Companion.getClass();
        return bx4.b.a(r0, r1, false, true, String.valueOf(5));
    }

    public final qd5.a A4() {
        return new qd5.b();
    }

    public final com.bytedance.ee.bear.list.recent.b Bb() {
        return new f();
    }

    public final com.bytedance.ee.bear.list.move.e D2() {
        return new com.bytedance.ee.bear.list.move.f();
    }

    public final com.bytedance.ee.bear.list.cover.a F9() {
        return new CoverLoader();
    }

    public final r0 Q3() {
        return new i();
    }

    public final com.bytedance.ee.bear.list.delete.f R() {
        return new DeleteExecutor();
    }

    public final nd5.a T2() {
        return new nd5.d();
    }

    public final void ga() {
        Map<sbb.e, v4> r0 = b4.a;
        UserSession r1 = this.a.getSession();
        Intrinsics.checkNotNullParameter(r1, "userSession");
        Log.i("DocumentSdk", "==openDocs==preload== preload srart");
        if (com.bytedance.ee.bear.document.forecast.a.e() == true) goto L5;
        Log.i("DocumentSdk", "==openDocs==preload== preload shouldPreloadWebView: false");
        return;
    L5:
        v4 r2 = b4.a(sbb.e.o);
        ChameleonConfig r3 = DocumentImpl.b(r1);
        Log.i("DocumentSdk", "==openDocs==preload== preload ssr preloadWebview");
        Intrinsics.checkNotNullParameter(r3, "ssrConfig");
        u35.a.e = true;
        u35.a.c(r3);
        ChameleonConfig r4 = DocumentImpl.a(r2, r1, null);
        Log.i("DocumentSdk", "==openDocs==preload== preload csr preloadWebview");
        Chameleon.c(Chameleon.a, r4);
    }

    public final rd5.a t2() {
        return new rd5.b();
    }

    public final jk5.a ff() {
        return this.f;
    }

    public final void Qd(String r4) {
        Intrinsics.checkNotNullParameter(r4, "url");
        int r1 = j.a;
        Intrinsics.checkNotNullParameter(r4, "url");
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.c()).subscribe(new h(r4), com.bytedance.ee.bear.document.ssr.i.a);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        ((k) org.koin.java.a.c(k.class, null, null, 6)).preload(r4);     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L13;
        tt5.a.l("UserDocsSdkImpl", "preload Bitable data failed", r6);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final void Ta(OfficeSdkServiceV2.d r3) {
        Intrinsics.checkNotNullParameter(r3, "dependency");
        yx4.a r1 = yx4.b.a;
        Intrinsics.checkNotNullParameter(r3, "dependency");
        yx4.b.a = r3;
    }

    public final v4 a5(sbb.e r2) {
        Intrinsics.checkNotNullParameter(r2, "documentType");
        return b4.a(r2);
    }

    public final void z2(s2 r3) {
        Intrinsics.checkNotNullParameter(r3, "resInfo");
        Map<sbb.e, v4> r1 = b4.a;
        Intrinsics.checkNotNullParameter(r3, "resInfo");
        s2.c = r3;
    }

    public final void Ka(sbb.e r2, v4 r3) {
        Intrinsics.checkNotNullParameter(r2, "documentType");
        Intrinsics.checkNotNullParameter(r3, "strategy");
        b4.b(r2, r3);
    }

    public final j15.a R4(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "fileName");
        return new com.bytedance.ee.bear.document.export.net.exportV2.a(r2, r3);
    }

    public final void r2(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r12, DocRedirectToDocxPlugin.FROM);
        if (StringsKt.isBlank(r11) == false) goto L44;
        tt5.a.k("UserDocsSdkImpl", "tryPrefetchData skip, url is blank");
        return;
    L44:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L38
        if (StringsKt.isBlank(r12) == false) goto L9;
        String r3 = r11;
    L10:
        String r4 = this.d.v8(r3);     // Catch: Throwable -> L38
        String r5 = "";
        if (r4 != null) goto L15;
        r4 = "";
    L15:
        if (StringsKt.isBlank(r4) == false) goto L18;
        tt5.a.k("UserDocsSdkImpl", "tryPrefetchData skip, productUrl is blank");     // Catch: Throwable -> L38
        return;
    L18:
        BearUrl r6 = this.d.Z(r4);     // Catch: Throwable -> L38
        String r7 = r6.b;     // Catch: Throwable -> L38
        if (r7 != null) goto L21;
        r7 = "";
    L21:
        int r8 = sbb.e.g(r6.a);     // Catch: Throwable -> L38
        if (StringsKt.isBlank(r7) == false) goto L25;
    L36:
        tt5.a.k("UserDocsSdkImpl", "tryPrefetchData skip, token=" + du5.b.g(r7) + ", type=" + r8);     // Catch: Throwable -> L38
        return;
    L25:
        if (ow4.a.b(r8) == false) goto L36;
        String r1 = r6.h;     // Catch: Throwable -> L38
        if (r1 == null) goto L32;
        r5 = r1;
    L32:
        if (StringsKt.isBlank(r5) == true) goto L35;
        r12 = r5;
    L35:
        ((n) org.koin.java.a.c(n.class, null, null, 6)).g(CollectionsKt.listOf(new OfflineDoc(r7, r4, r8, r12)));     // Catch: Throwable -> L38
        tt5.a.h("UserDocsSdkImpl", "tryPrefetchData success, token=" + du5.b.g(r7) + ", type=" + r8 + ", from=" + r12);     // Catch: Throwable -> L38
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L38
    L40:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L45;
        tt5.a.e("UserDocsSdkImpl", "tryPrefetchData failed, url=" + du5.b.h(r11), r14, false);
        return;
    L45:
        return;
    L9:
        r3 = ow4.a.a(r11, r12);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L40
    }

    public final j15.b y4(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "fileName");
        return new MinutesExportExecutorImpl(r2, r3);
    }

    public final Fragment C6(String r8, Long r9, String r10, hk5.a r11, com.bytedance.ee.bear.container.f r12) {
        Intrinsics.checkNotNullParameter(r8, "url");
        int r1 = com.bytedance.ee.bear.document.render.node.perf.e.h;
        com.bytedance.ee.bear.document.render.node.perf.e.a.a(r9);
        StringBuilder r2 = new StringBuilder("==openDocs== openDocumentFragment, url: ");
        r2.append(du5.b.h(r8));
        r2.append(", markdown.size: ");
        if (r10 == null) goto L5;
        Integer r3 = Integer.valueOf(r10.length());
    L6:
        r2.append(r3);
        tt5.a.h("UserDocsSdkImpl", r2.toString());
        com.bytedance.ee.bear.contract.d r4 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        long r5 = System.currentTimeMillis();
        r4.h("start_open");
        r4.j("start_open", "start_time", String.valueOf(r5));
        r4.j("start_open", "click_timestamp", r9);
        Bundle r13 = new Bundle();
        r13.putString("url", r8);
        r13.putLong("open_file_start_time", r5);
        r13.putString("offline_create_markdown", r10);
        PassportcConvention.f(r13, LarkContext.getApplication());
        ContainerFragment r14 = new ContainerFragment();
        r14.s = r12;
        final String r16 = UUID.randomUUID().toString();
        r13.putString("plugin_host_callback_key", r16);
        if (r11 == null) goto L9;
        hk5.b.b(r16, r11);
    L9:
        r14.getLifecycle().addObserver(new UserDocsSdkImpl$openDocumentFragment$2(r16));
        r14.setArguments(r13);
        return r14;
    L5:
        r3 = null;
        goto L6
    }

    @Inject
    public UserDocsSdkImpl(m r2, com.bytedance.ee.bear.init.a r3, com.bytedance.ee.bear.init.b r4, s45.f r5, c r6, x05.a r7) {
        Intrinsics.checkNotNullParameter(r2, "passportUserService");
        Intrinsics.checkNotNullParameter(r3, "officeCCMGlobalInit");
        Intrinsics.checkNotNullParameter(r4, "officeCCMUserInit");
        Intrinsics.checkNotNullParameter(r5, "domainConfigParser");
        Intrinsics.checkNotNullParameter(r6, "spaceKitUrlHelper");
        Intrinsics.checkNotNullParameter(r7, "docsHistoryDomainDependency");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = new b();
        List<String> r8 = r7.s0();
        r6.F6(r8);
        r6.I9((String[]) r8.toArray(new String[0]), sbb.f.c);
    }
}
