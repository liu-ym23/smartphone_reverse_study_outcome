package com.bytedance.ee.bear.document.chatdraftdoc;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l {
    public final CompositeDisposable a;

    public static final class a {
    }

    public final class b implements NetService.c<Result<String>> {
        public b() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<String> parse(String r2) {
            Result<String> r0 = new Result();
            r0.data = r2;
            return r0;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ k05.b a;

        public c(k05.b r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Result r4 = (Result) r3;
            tt5.a.h("DeleteChatDraftDocNetExecutor", "deleteChatDraftDoc response, code = " + r4.code + ", msg = " + r4.msg);
            this.a.a(r4.code);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ k05.b a;

        public d(k05.b r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            this.a.a(-1);
            tt5.a.e("DeleteChatDraftDocNetExecutor", "deleteChatDraftDoc error!", (Throwable) r4, false);
        }
    }

    static {
    }

    public l() {
        this.a = new CompositeDisposable();
    }

    public final void a(NetService r4, String r5, k05.b r6) {
        Intrinsics.checkNotNullParameter(r4, "netService");
        Intrinsics.checkNotNullParameter(r5, "chatId");
        Intrinsics.checkNotNullParameter(r6, "callback");
        NetService.d r7 = r4.Vc(new b());
        NetService.e r0 = new NetService.f("/space/api/chat_relation/obj/delete");
        r0.c = 1;
        JSONObject r1 = new JSONObject();
        r1.put("chat_id", r5);
        r0.j = r1.toString();
        HashMap r8 = new HashMap();
        r8.put("Content-Type", "application/x-www-form-urlencoded");
        r0.c(r8);
        Disposable r9 = r7.a(r0).subscribeOn(fo5.d.e()).observeOn(fo5.d.d()).subscribe(new c(r6), new d(r6));
        this.a.add(r9);
    }
}
