package com.bytedance.sdk.xbridge.cn.protocol;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.exception.IllegalInputParamException;
import com.bytedance.sdk.xbridge.cn.registry.core.exception.IllegalOperationException;
import com.bytedance.sdk.xbridge.cn.registry.core.exception.IllegalOutputParamException;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public abstract class c<INPUT, OUTPUT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f270063a;

    public static final class a implements IDLXBridgeMethod.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ le7.a<INPUT> f270064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d<OUTPUT> f270065b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c<INPUT, OUTPUT> f270066c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ IDLXBridgeMethod f270067d;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod.a
        public final void invoke(Map<String, ? extends Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Object r101 = r100.get("code");
            String r102 = null;
            if ((r101 instanceof Integer) == false) goto L5;
            Integer r103 = (Integer) r101;
        L6:
            boolean r104 = true;
            if (r103 == null) goto L9;
            int r105 = r103.intValue();
        L10:
            le7.a<INPUT> r106 = this.f270064a;
            r106.f508953k = r105;
            Object r107 = r100.get("msg");
            if ((r107 instanceof String) == false) goto L13;
            String r108 = (String) r107;
        L14:
            if (r108 != null) goto L21;
            Object r109 = r100.get("message");
            if ((r109 instanceof String) == false) goto L18;
            r102 = (String) r109;
        L18:
            if (r102 != null) goto L20;
            r108 = "unknown error 1";
            goto L21
        L20:
            r108 = r102;
        L21:
            r106.getClass();
            Intrinsics.checkNotNullParameter(r108, "<set-?>");
            r106.f508954l = r108;
            le7.a<INPUT> r110 = this.f270064a;
            if (r105 == 1) goto L25;
            r104 = false;
        L25:
            r110.f508955m = r104;
            this.f270065b.c((OUTPUT) this.f270066c.c().a(r100, this.f270067d.getClass(), this.f270064a));
            return;
        L13:
            r108 = null;
            goto L14
        L9:
            r105 = 1;
            goto L10
        L5:
            r103 = null;
            goto L6
        }

        public a(le7.a<INPUT> r100, d<OUTPUT> r101, c<INPUT, OUTPUT> r102, IDLXBridgeMethod r103) {
            this.f270064a = r100;
            this.f270065b = r101;
            this.f270066c = r102;
            this.f270067d = r103;
        }
    }

    public static final class b implements IDLXBridgeMethod.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<IBDXBridgeContext> f270068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBDXBridgeContext f270069b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ le7.a<INPUT> f270070c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d<OUTPUT> f270071d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ c<INPUT, OUTPUT> f270072e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ IDLXBridgeMethod f270073f;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod.a
        public final void invoke(Map<String, ? extends Object> r110) {
            Intrinsics.checkNotNullParameter(r110, "data");
            Object r100 = r110.get("__jsb2__data__");
            boolean r101 = false;
            String r102 = null;
            if (r100 == null) goto L64;
            if ((r100 instanceof JSONObject) == false) goto L64;
            Object r103 = ((JSONObject) r100).opt("code");
            if ((r103 instanceof Integer) == false) goto L9;
            Integer r104 = (Integer) r103;
        L10:
            if (r104 == null) goto L12;
            int r105 = r104.intValue();
        L13:
            this.f270070c.f508953k = r105;
            Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L48
            Object r112 = ((JSONObject) r100).opt("msg");     // Catch: Throwable -> L48
            if ((r112 instanceof String) == false) goto L17;
            String r113 = (String) r112;     // Catch: Throwable -> L48
        L18:
            if (r113 == null) goto L20;
            Object r106 = ((JSONObject) r100).opt("msg");     // Catch: Throwable -> L48
        L46:
            Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L48
        L51:
            if (Result.m9452exceptionOrNullimpl(r107) == null) goto L54;
            r107 = "wrap2 data: " + r100;
        L54:
            le7.a<INPUT> r108 = this.f270070c;
            if ((r107 instanceof String) == false) goto L57;
            r102 = (String) r107;
        L57:
            if (r102 != null) goto L59;
            r102 = "wrap3 data: " + r100;
        L59:
            r108.getClass();
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            r108.f508954l = r102;
            le7.a<INPUT> r109 = this.f270070c;
            if (r105 != 1) goto L62;
            r101 = true;
        L62:
            r109.f508955m = r101;
            this.f270071d.c((OUTPUT) this.f270072e.c().a(r110, this.f270073f.getClass(), this.f270070c));
            return;
        L20:
            Object r114 = ((JSONObject) r100).opt("message");     // Catch: Throwable -> L48
            if ((r114 instanceof String) == false) goto L23;
            String r115 = (String) r114;     // Catch: Throwable -> L48
        L24:
            if (r115 == null) goto L26;
            r106 = ((JSONObject) r100).opt("message");     // Catch: Throwable -> L48
            goto L46
        L26:
            Object r116 = ((JSONObject) r100).opt("data");     // Catch: Throwable -> L48
            if ((r116 instanceof JSONObject) == false) goto L29;
            JSONObject r117 = (JSONObject) r116;     // Catch: Throwable -> L48
        L30:
            if (r117 == null) goto L32;
            Object r118 = r117.opt("msg");     // Catch: Throwable -> L48
        L34:
            if ((r118 instanceof String) == false) goto L36;
            String r119 = (String) r118;     // Catch: Throwable -> L48
        L37:
            if (r119 == null) goto L45;
            Object r120 = ((JSONObject) r100).opt("data");     // Catch: Throwable -> L48
            if ((r120 instanceof JSONObject) == false) goto L41;
            JSONObject r121 = (JSONObject) r120;     // Catch: Throwable -> L48
        L42:
            if (r121 == null) goto L44;
            r106 = r121.opt("msg");     // Catch: Throwable -> L48
            goto L46
        L44:
            r106 = null;
            goto L46
        L41:
            r121 = null;
            goto L42
        L45:
            r106 = "wrap1 data: " + r100;     // Catch: Throwable -> L48
            goto L46
        L36:
            r119 = null;
            goto L37
        L32:
            r118 = null;
            goto L34
        L29:
            r117 = null;
            goto L30
        L23:
            r115 = null;
            goto L24
        L17:
            r113 = null;
        L48:
            th = move-exception;
            Result.Companion r122 = Result.Companion;
            r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L51
        L12:
            r105 = 1;
            goto L13
        L9:
            r104 = null;
        L64:
            if (com.bytedance.ies.bullet.base.settings.c.a().f() == 1) goto L66;
        L68:
            IBDXBridgeContext r123 = this.f270069b;
        L69:
            Map<String, Boolean> r124 = be7.a.f18743a;
            Map r125 = be7.a.a(this.f270070c.f508943a, r123, r110);
            Object r126 = r125.get("code");
            if ((r126 instanceof Integer) == false) goto L72;
            Integer r127 = (Integer) r126;
        L73:
            if (r127 == null) goto L75;
            int r128 = r127.intValue();
        L76:
            le7.a<INPUT> r129 = this.f270070c;
            r129.f508953k = r128;
            Object r130 = r125.get("msg");
            if ((r130 instanceof String) == false) goto L79;
            String r131 = (String) r130;
        L80:
            if (r131 != null) goto L87;
            Object r132 = r125.get("message");
            if ((r132 instanceof String) == false) goto L84;
            r102 = (String) r132;
        L84:
            if (r102 != null) goto L86;
            r131 = "unknown error 2";
            goto L87
        L86:
            r131 = r102;
        L87:
            Intrinsics.checkNotNullParameter(r131, "<set-?>");
            r129.f508954l = r131;
            le7.a<INPUT> r133 = this.f270070c;
            if (r128 != 1) goto L90;
            r101 = true;
        L90:
            r133.f508955m = r101;
            this.f270071d.c((OUTPUT) this.f270072e.c().a(r125, this.f270073f.getClass(), this.f270070c));
            return;
        L79:
            r131 = null;
            goto L80
        L75:
            r128 = 1;
            goto L76
        L72:
            r127 = null;
            goto L73
        L66:
            if (this.f270068a.get() == null) goto L68;
            IBDXBridgeContext r134 = this.f270068a.get();
            Intrinsics.checkNotNull(r134);
            r123 = r134;
            goto L69
        }

        public b(IBDXBridgeContext r100, le7.a<INPUT> r101, d<OUTPUT> r102, c<INPUT, OUTPUT> r103, IDLXBridgeMethod r104) {
            this.f270069b = r100;
            this.f270070c = r101;
            this.f270071d = r102;
            this.f270072e = r103;
            this.f270073f = r104;
            this.f270068a = new WeakReference(r100);
        }
    }

    public abstract OUTPUT b(int r100, String r101);

    public abstract g<INPUT, OUTPUT> c();

    public c() {
        this.f270063a = "__test_register";
    }

    public final OUTPUT a(le7.a<INPUT> r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r102, "message");
        r100.f508953k = r101;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r100.f508954l = r102;
        r100.f508955m = false;
        return b(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(le7.a<INPUT> r110, INPUT r111, IDLXBridgeMethod r112, IBDXBridgeContext r113, d<OUTPUT> r114) {
        Intrinsics.checkNotNullParameter(r110, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r112, "bridge");
        Intrinsics.checkNotNullParameter(r113, "bridgeContext");
        Intrinsics.checkNotNullParameter(r114, "callback");
        a r100 = new a(r110, r114, this, r112);     // Catch: Throwable -> L30 IllegalOperationException -> L32 IllegalOutputParamException -> L34 IllegalInputParamException -> L36
        b r101 = new b(r113, r110, r114, this, r112);     // Catch: Throwable -> L30 IllegalOperationException -> L32 IllegalOutputParamException -> L34 IllegalInputParamException -> L36
        if (r112.getCompatibility().getValue() == false) goto L15;
        Map<String, ? extends Object> r115 = c().d(r111);     // Catch: Throwable -> L30 IllegalOperationException -> L32 IllegalOutputParamException -> L34 IllegalInputParamException -> L36
        if (Intrinsics.areEqual(r115.get(this.f270063a), 1) == false) goto L11;
        r114.c(a(r110, 0, "bridge已注册"));     // Catch: Throwable -> L30 IllegalOperationException -> L32 IllegalOutputParamException -> L34 IllegalInputParamException -> L36
        return;
    L11:
        if (Intrinsics.areEqual(r110.f508946d, "webcast") == false) goto L13;
        r112.realHandle(r113, r115, r101);     // Catch: Throwable -> L30 IllegalOperationException -> L32 IllegalOutputParamException -> L34 IllegalInputParamException -> L36
        return;
    L13:
        r112.realHandle(r113, r115, r100);     // Catch: Throwable -> L30 IllegalOperationException -> L32 IllegalOutputParamException -> L34 IllegalInputParamException -> L36
        return;
    L15:
        if (Intrinsics.areEqual(r110.f508946d, "webcast") == false) goto L17;
        Map<String, ? extends Object> r116 = c().c(r111, r112.getClass(), r110.f508946d);     // Catch: Throwable -> L30 IllegalOperationException -> L32 IllegalOutputParamException -> L34 IllegalInputParamException -> L36
    L18:
        if (r116 != null) goto L22;
        r114.c(a(r110, -10, "XBridge IDL 数据转换失败"));     // Catch: Throwable -> L30 IllegalOperationException -> L32 IllegalOutputParamException -> L34 IllegalInputParamException -> L36
        return;
    L22:
        if (Intrinsics.areEqual(r116.get(this.f270063a), 1) == false) goto L26;
        r114.c(a(r110, 0, "bridge已注册"));     // Catch: Throwable -> L30 IllegalOperationException -> L32 IllegalOutputParamException -> L34 IllegalInputParamException -> L36
        return;
    L26:
        if (Intrinsics.areEqual(r110.f508946d, "webcast") == false) goto L28;
        r112.realHandle(r113, r116, r101);     // Catch: Throwable -> L30 IllegalOperationException -> L32 IllegalOutputParamException -> L34 IllegalInputParamException -> L36
        return;
    L28:
        r112.realHandle(r113, r116, r100);     // Catch: Throwable -> L30 IllegalOperationException -> L32 IllegalOutputParamException -> L34 IllegalInputParamException -> L36
        return;
    L17:
        r116 = c().b(r111, r112.getClass());     // Catch: Throwable -> L30 IllegalOperationException -> L32 IllegalOutputParamException -> L34 IllegalInputParamException -> L36
    L36:
        e = move-exception;
        OUTPUT r117 = a(r110, -3, e.toString());
        Intrinsics.checkNotNull(r117);
        r114.c(r117);
        return;
    L32:
        e = move-exception;
        OUTPUT r118 = a(r110, -10, e.toString());
        Intrinsics.checkNotNull(r118);
        r114.c(r118);
        return;
    L34:
        e = move-exception;
        OUTPUT r119 = a(r110, -5, e.toString());
        Intrinsics.checkNotNull(r119);
        r114.c(r119);
        return;
    L30:
        th = move-exception;
        OUTPUT r120 = a(r110, -11, th.toString());
        Intrinsics.checkNotNull(r120);
        r114.c(r120);
    }
}
