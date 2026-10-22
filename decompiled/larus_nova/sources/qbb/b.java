package qbb;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SendHttpRequest;
import com.bytedance.lark.pb.basic.v1.SendHttpResponse;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.t;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.ApiUtils;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class b implements qbb.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f532419b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f532420a;

    public static final class a {
    }

    /* JADX INFO: renamed from: qbb.b$b, reason: collision with other inner class name */
    public static final class C7308b<T> implements FlowableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ obb.b f532421a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f532422b;

        /* JADX INFO: renamed from: qbb.b$b$a */
        public static final class a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f532423a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FlowableEmitter<obb.b> f532424b;

            public a(b r100, FlowableEmitter<obb.b> r101) {
                this.f532423a = r100;
                this.f532424b = r101;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r210) {
                s r100 = (s) r210;
                String r101 = "";
                Intrinsics.checkNotNull(r100);
                String r102 = null;
                SendHttpResponse r103 = (SendHttpResponse) t.c(r100, null);
                Log.i("DOCS_ICON_RustMetaFetcher", "fetchMetaInfo success");
            L34:
                e = move-exception;
                Log.e("DOCS_ICON_RustMetaFetcher", "parse fail " + e.getMessage());
                this.f532424b.onError(new Exception("parse fail " + e));
                return;
            L4:
                if (r103 == null) goto L6;
                String r104 = r103.json_body;     // Catch: Exception -> L34
            L7:
                JSONObject r105 = new JSONObject(r104).optJSONObject("data");     // Catch: Exception -> L34
                String r106 = r105.optString("title");     // Catch: Exception -> L34
                String r107 = r105.optString("icon_info", "");     // Catch: Exception -> L34
                sbb.c.f541290a.getClass();     // Catch: Exception -> L34
                obb.b r108 = sbb.c.c(null, r107);     // Catch: Exception -> L34
                if (r108 == null) goto L10;
                r108.f522644h = r106;     // Catch: Exception -> L34
            L10:
                if (r108 != null) goto L22;
                if (TextUtils.isEmpty(r105.optString("token")) == true) goto L22;
                b r109 = this.f532423a;     // Catch: Exception -> L34
                Intrinsics.checkNotNull(r106);     // Catch: Exception -> L34
                int r110 = b.f532419b;     // Catch: Exception -> L34
                r109.getClass();     // Catch: Exception -> L34
                if (TextUtils.isEmpty(r106) == true) goto L20;
                int r111 = StringsKt.lastIndexOf$default(r106, '.', 0, false, 6, null);     // Catch: Exception -> L34
                if (r111 <= (-1)) goto L20;
                r101 = r106.substring(r111 + 1);     // Catch: Exception -> L34
            L20:
                r108 = new obb.b(r105.optInt("obj_type", -1), r105.optString("token"), r101, null, null, Integer.valueOf(r105.optInt("version")), r106, null, 256);     // Catch: Exception -> L34
            L22:
                if (this.f532424b.isCancelled() == true) goto L38;
                if (r108 == null) goto L25;
                this.f532424b.onNext(r108);     // Catch: Exception -> L34
                return;
            L25:
                StringBuilder r112 = new StringBuilder("parse fail ");     // Catch: Exception -> L34
                if (r103 == null) goto L28;
                String r113 = r103.json_body;     // Catch: Exception -> L34
            L29:
                r112.append(r113);     // Catch: Exception -> L34
                Log.i("DOCS_ICON_RustMetaFetcher", r112.toString());     // Catch: Exception -> L34
                FlowableEmitter<obb.b> r114 = this.f532424b;     // Catch: Exception -> L34
                StringBuilder r115 = new StringBuilder("parse fail ");     // Catch: Exception -> L34
                if (r103 == null) goto L32;
                r102 = r103.json_body;     // Catch: Exception -> L34
            L32:
                r115.append(r102);     // Catch: Exception -> L34
                r114.onError(new Exception(r115.toString()));     // Catch: Exception -> L34
                return;
            L28:
                r113 = null;
                goto L29
            L38:
                return;
            L6:
                r104 = null;
                goto L7
            }
        }

        /* JADX INFO: renamed from: qbb.b$b$b, reason: collision with other inner class name */
        public static final class C7309b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FlowableEmitter<obb.b> f532425a;

            public C7309b(FlowableEmitter<obb.b> r100) {
                this.f532425a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Throwable r101 = (Throwable) r100;
                this.f532425a.onError(r101);
                Log.i("DOCS_ICON_RustMetaFetcher", "fetchMetaInfo fail " + r101);
            }
        }

        public C7308b(obb.b r100, b r101) {
            this.f532421a = r100;
            this.f532422b = r101;
        }

        @Override // io.reactivex.FlowableOnSubscribe
        public final void subscribe(FlowableEmitter<obb.b> r110) {
            Intrinsics.checkNotNullParameter(r110, "emit");
            String r100 = "https://" + jcb.b.c().a("docs_api") + "/space/api/icon/pack/?token=" + this.f532421a.f522638b + "&type=" + this.f532421a.getType();
            HashMap r101 = new HashMap();
            r101.put("Cookie", "session=" + ((xzb.a) ApiUtils.getApi(xzb.a.class)).getSession());
            SendHttpRequest.Builder r102 = new SendHttpRequest.Builder().method(SendHttpRequest.Method.GET).url(r100).headers(r101);
            l r103 = this.f532422b.f532420a;
            Command r104 = Command.SEND_HTTP;
            Intrinsics.checkNotNull(r102);
            r103.h(new com.bytedance.lark.rustclient.api.d(r102, SendHttpResponse.ADAPTER, r104, null, null, null, null, 248)).a().subscribe(new a(this.f532422b, r110), new C7309b(r110));
        }
    }

    static {
    }

    @Inject
    public b(l r100) {
        Intrinsics.checkNotNullParameter(r100, "userClient");
        this.f532420a = r100;
    }

    @Override // qbb.a
    public final Flowable<obb.b> a(obb.b r100) {
        Intrinsics.checkNotNullParameter(r100, "meta");
        if (TextUtils.isEmpty(r100.f522638b) == true) goto L20;
        if (r100.getType() == 0) goto L20;
        if (r100.getType() == 12) goto L20;
        String r101 = r100.f522638b;
        boolean r102 = false;
        if (r101 != null) goto L11;
    L15:
        if (r102 == true) goto L20;
        return Flowable.create(new C7308b(r100, this), BackpressureStrategy.BUFFER);
    L11:
        if (TextUtils.isEmpty(r101) == true) goto L15;
        if (StringsKt.startsWith$default(r101.toLowerCase(Locale.getDefault()), "fake_", false, 2, null) == false) goto L15;
        r102 = true;
    L20:
        return Flowable.empty();
    }
}
