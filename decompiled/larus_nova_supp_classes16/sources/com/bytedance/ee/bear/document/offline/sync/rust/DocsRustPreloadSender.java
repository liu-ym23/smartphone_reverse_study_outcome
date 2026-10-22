package com.bytedance.ee.bear.document.offline.sync.rust;

import com.bytedance.ee.bear.contract.offline.OfflineCacheConfig;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.offline.sync.h0;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.space.doc.v1.CCMPreloadDocDataRequest;
import com.bytedance.lark.pb.space.doc.v1.CCMPreloadDocDataResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DocsRustPreloadSender {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements SdkSender.IParser {
        public static final a<T> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object parse(byte[] r2) {
            return (CCMPreloadDocDataResponse) CCMPreloadDocDataResponse.ADAPTER.decode(r2);
        }
    }

    static {
    }

    public static void a(final OfflineDoc r19, String r20, final Function2 r21) {
        Intrinsics.checkNotNullParameter(r19, "offlineDoc");
        Intrinsics.checkNotNullParameter(r21, "onRequestRejected");
        d.a.getClass();
        Intrinsics.checkNotNullParameter(r19, "offlineDoc");
        OfflineCacheConfig r3 = h0.l;
        boolean r4 = false;
        int r5 = 1;
        String r6 = null;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
        LarkAppContext.Companion.getClass();     // Catch: Throwable -> L14
        boolean r1 = LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK();     // Catch: Throwable -> L14
        if (r1 == false) goto L6;
    L8:
        boolean r7 = false;
    L9:
        if (r7 == false) goto L11;
        String r8 = ((t45.c) k.a(LarkContext.getApplication(), t45.c.class)).f9();     // Catch: Throwable -> L14
    L12:
        Object r2 = Result.constructor-impl(d.f(r1, p.t, r8, r7, DocsRustPreloadRequestFactory$resolveSsrDomain$1$1.INSTANCE));     // Catch: Throwable -> L14
    L16:
        Throwable r9 = Result.exceptionOrNull-impl(r2);
        if (r9 == null) goto L20;
        tt5.a.l("DocsRustPreloadRequestFactory", "[rust_preload] resolve ssr domain failed", r9);
        r2 = null;
    L20:
        String r10 = (String) r2;
        String r11 = swb.b.a(LarkContext.getApplication());     // Catch: Throwable -> L34
        if (r11 == null) goto L31;
        String r12 = StringsKt.trim(r11).toString();     // Catch: Throwable -> L34
        if (r12 == null) goto L31;
        if (r12.length() <= 0) goto L28;
        boolean r13 = true;
    L29:
        if (r13 == false) goto L31;
    L32:
        Object r14 = Result.constructor-impl(r12);     // Catch: Throwable -> L34
    L36:
        Throwable r16 = Result.exceptionOrNull-impl(r14);
        if (r16 == null) goto L40;
        tt5.a.l("DocsRustPreloadRequestFactory", "[rust_preload] resolve app version failed", r16);
        r14 = null;
    L40:
        String r17 = (String) r14;
        if (r17 != null) goto L43;
        r17 = "1.0.0";
    L43:
        String r18 = r17;
        if (r20 != null) goto L46;
    L65:
        d.a r22 = new d.a(0);
    L66:
        if (r10 == null) goto L75;
        String r23 = StringsKt.trim(r10).toString();
        if (r23 == null) goto L75;
        if (r23.length() <= 0) goto L72;
        boolean r110 = true;
    L73:
        if (r110 == false) goto L75;
    L76:
        String r24 = StringsKt.trim(r18).toString();
        if (r24 != null) goto L79;
    L83:
        tt5.a.h("DocsRustPreloadRequestFactory", "[rust_preload] resolved ssr domain=" + r23 + " app_version=" + r6);
        String r26 = r22.a;
        if (r26 == null) goto L86;
    L89:
        CCMPreloadDocDataRequest.Builder r27 = new CCMPreloadDocDataRequest.Builder().docx_token(r19.getObj_token()).type(Integer.valueOf(r19.getType()));
        Integer r28 = r22.e;
        if (r28 == null) goto L92;
        r5 = r28.intValue();
    L92:
        CCMPreloadDocDataRequest.Builder r29 = r27.open_type(Integer.valueOf(r5)).event_type(r26);
        Integer r30 = r22.f;
        if (r30 == null) goto L95;
        int r31 = r30.intValue();
    L96:
        CCMPreloadDocDataRequest.Builder r32 = r29.resource_limit(Integer.valueOf(r31));
        Integer r33 = r22.g;
        if (r33 == null) goto L99;
        int r34 = r33.intValue();
    L100:
        CCMPreloadDocDataRequest r36 = r32.embed_doc_limit(Integer.valueOf(r34)).fetch_types(r22.b).doc_token(r22.c).sheet_id(r22.d).ssr_domain(r23).app_version(r6).build();
        tt5.a.h("DocsRustPreloadSender", "[rust_preload] request preload token=" + du5.b.g(r19.getObj_token()));
        SdkSender.asynSendRequestNonWrap(Command.CCM_PRELOAD_DOC_DATA, r36.newBuilder(), new DocsRustPreloadSender$requestPreload$1(r21, r19), a.a);
        return;
    L99:
        r34 = r3.getDocxMentionDocblockPreloadNumber();
        goto L100
    L95:
        r31 = r3.getDocxBlockPreloadNumber();
        goto L96
    L86:
        if (Intrinsics.areEqual(r19.getFrom_source(), "tab_manual_offline") == false) goto L88;
        r26 = "offline";
        goto L89
    L88:
        r26 = "preload";
        goto L89
    L79:
        if (r24.length() <= 0) goto L81;
        r4 = true;
    L81:
        if (r4 == false) goto L83;
        r6 = r24;
        goto L83
    L72:
        r110 = false;
    L75:
        r23 = null;
        goto L76
    L46:
        if ((!StringsKt.isBlank(r20)) == false) goto L48;
        String r37 = r20;
    L49:
        if (r37 == null) goto L65;
        JsonObject r38 = d.a(JsonParser.parseString(r37));     // Catch: JsonSyntaxException -> L63
        if (r38 != null) goto L54;
        r22 = new d.a(0);     // Catch: JsonSyntaxException -> L63
        goto L66
    L54:
        JsonObject r111 = d.a(r38.get("body"));     // Catch: JsonSyntaxException -> L63
        if (r111 == null) goto L58;
        r38 = r111;
    L58:
        String r112 = d.d(r38, "eventType");     // Catch: JsonSyntaxException -> L63
        List r113 = d.e(r38);     // Catch: JsonSyntaxException -> L63
        String r114 = d.d(r38, "docToken");     // Catch: JsonSyntaxException -> L63
        String r115 = d.d(r38, "sheetId");     // Catch: JsonSyntaxException -> L63
        if (r115 != null) goto L62;
        r115 = d.d(r38, "sheetID");     // Catch: JsonSyntaxException -> L63
    L62:
        r22 = new d.a(r112, r113, r114, r115, d.c(r38, "openType"), d.c(r38, "resourceLimit"), d.c(r38, "embedDocLimit"));     // Catch: JsonSyntaxException -> L63
    L63:
        e = move-exception;
        tt5.a.l("DocsRustPreloadRequestFactory", "[rust_preload] parse preload params failed", e);
        r22 = new d.a(0);
        goto L66
    L48:
        r37 = null;
        goto L49
    L28:
        r13 = false;
    L31:
        r12 = null;
    L34:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    L11:
        r8 = null;
        goto L12
    L6:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.ark_domain") == false) goto L8;
        r7 = true;
    L14:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }
}
