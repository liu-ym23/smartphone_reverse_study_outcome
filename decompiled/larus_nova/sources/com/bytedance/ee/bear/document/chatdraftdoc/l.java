package com.bytedance.ee.bear.document.chatdraftdoc;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f219215a;

    public static final class a {
    }

    public final class b implements NetService.c<Result<String>> {
        public b() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<String> parse(String r100) {
            Result<String> r101 = new Result();
            r101.data = r100;
            return r101;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k05.b f219216a;

        public c(k05.b r100) {
            this.f219216a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Result r101 = (Result) r100;
            tt5.a.h("DeleteChatDraftDocNetExecutor", "deleteChatDraftDoc response, code = " + r101.code + ", msg = " + r101.msg);
            this.f219216a.a(r101.code);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k05.b f219217a;

        public d(k05.b r100) {
            this.f219217a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f219217a.a(-1);
            tt5.a.e("DeleteChatDraftDocNetExecutor", "deleteChatDraftDoc error!", (Throwable) r100, false);
        }
    }

    static {
    }

    public l() {
        this.f219215a = new CompositeDisposable();
    }

    public final void a(NetService r100, String r101, k05.b r102) {
        Intrinsics.checkNotNullParameter(r100, "netService");
        Intrinsics.checkNotNullParameter(r101, "chatId");
        Intrinsics.checkNotNullParameter(r102, "callback");
        NetService.d r103 = r100.Vc(new b());
        NetService.e r104 = new NetService.f("/space/api/chat_relation/obj/delete");
        r104.f216906c = 1;
        JSONObject r105 = new JSONObject();
        r105.put("chat_id", r101);
        r104.f216913j = r105.toString();
        HashMap r106 = new HashMap();
        r106.put("Content-Type", "application/x-www-form-urlencoded");
        r104.c(r106);
        Disposable r107 = r103.a(r104).subscribeOn(fo5.d.e()).observeOn(fo5.d.d()).subscribe(new c(r102), new d(r102));
        this.f219215a.add(r107);
    }
}
