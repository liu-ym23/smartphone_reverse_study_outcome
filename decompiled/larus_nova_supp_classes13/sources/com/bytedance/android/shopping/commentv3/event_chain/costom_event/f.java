package com.bytedance.android.shopping.commentv3.event_chain.costom_event;

import android.content.Context;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.shopping.commentv3.action.ActionType;
import com.bytedance.android.shopping.commentv3.data.interfaces.ICommentFetchApi;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f extends com.bytedance.android.shopping.commentv3.event_chain.a {
    public Disposable d;
    public final String e;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ f a;
        public final /* synthetic */ Function1 b;

        public a(f r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r9) {
            JSONObject r10 = z1.g((String) r9);
            if (r10 == null) goto L5;
            Integer r11 = Integer.valueOf(r10.optInt("status_code"));
        L6:
            if (r11 != null) goto L9;
        L11:
            Function1 r0 = this.b;
            int r1 = com.bytedance.kmp.ec.yata.chain.event.b.h;
            r0.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "fetch fail, status code: " + r11, null, null, 57));
        L12:
            Disposable r12 = this.a.d;
            if (r12 == null) goto L16;
            r12.dispose();
            return;
        L16:
            return;
        L9:
            if (r11.intValue() != 0) goto L11;
            Function1 r13 = this.b;
            int r2 = com.bytedance.kmp.ec.yata.chain.event.b.h;
            r13.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
            goto L12
        L5:
            r11 = null;
            goto L6
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ f a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ Function1 e;

        public b(f r1, String r2, boolean r3, Map r4, Function1 r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r9) {
            Throwable r10 = (Throwable) r9;
            dm.a.b r0 = dm.a.a;
            dm.a.a(this.a.e).i("fetch fail, url: " + this.b + ", usePost: " + this.c + ", params: " + this.d + ", throwable: " + r10.getMessage());
            Function1 r1 = this.e;
            int r2 = com.bytedance.kmp.ec.yata.chain.event.b.h;
            StringBuilder r3 = new StringBuilder("fetch fail, throwable: ");
            r3.append(r10.getMessage());
            r1.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, r3.toString(), null, null, 57));
            Disposable r11 = this.a.d;
            if (r11 == null) goto L6;
            r11.dispose();
            return;
        }
    }

    public f(Context r2, com.bytedance.android.shopping.commentv3.data.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        super(ActionType.FETCH.getType());
        this.e = "Comment.FetchActionEvent";
    }

    @Override // com.bytedance.android.shopping.commentv3.event_chain.a
    public final void c(EventContext r9, fc3.a r10, fc3.c r11, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r12) {
        Intrinsics.checkNotNullParameter(r9, "eventContext");
        Intrinsics.checkNotNullParameter(r10, "actionContext");
        Intrinsics.checkNotNullParameter(r11, "handleActionParams");
        Intrinsics.checkNotNullParameter(r12, "completion");
        Intrinsics.checkNotNullParameter(r9, "$this$getFieldsString");
        Intrinsics.checkNotNullParameter("url_path", "key");
        Map r0 = r9.k;
        Map<String, Object> r1 = null;
        if (r0 == null) goto L10;
        Object r13 = r0.get("url_path");
        if (r13 == null) goto L10;
        String r14 = r13.toString();
        if (r14 == null) goto L10;
        String r4 = r14;
    L11:
        if (r4 != null) goto L13;
        return;
    L13:
        Intrinsics.checkNotNullParameter(r9, "$this$getFieldsBoolean");
        Intrinsics.checkNotNullParameter("use_post", "key");
        Map r2 = r9.k;
        if (r2 == null) goto L16;
        Object r15 = r2.get("use_post");
    L18:
        if ((r15 instanceof Boolean) == true) goto L20;
        r15 = null;
    L20:
        Boolean r16 = (Boolean) r15;
        if (r16 != null) goto L23;
        r16 = null;
    L23:
        if (r16 == null) goto L44;
        boolean r5 = r16.booleanValue();
        Intrinsics.checkNotNullParameter(r9, "$this$getFieldsMap");
        Intrinsics.checkNotNullParameter("params", "key");
        Map r17 = r9.k;
        if (r17 == null) goto L27;
        Object r18 = r17.get("params");
    L29:
        if ((r18 instanceof Map) == false) goto L34;
        LinkedHashMap r19 = new LinkedHashMap();
        Iterator r20 = ((Map) r18).entrySet().iterator();
    L32:
        if (r20.hasNext() == false) goto L35;
        Map.Entry r110 = (Map.Entry) r20.next();
        r19.put(String.valueOf(r110.getKey()), r110.getValue());
    L35:
        if (r19 == null) goto L37;
        r1 = MapsKt.toMutableMap(r19);
    L37:
        Map<String, Object> r6 = r1;
        int r21 = jc3.a.a;
        boolean r22 = !r5;
        Intrinsics.checkNotNullParameter(r4, "url");
        if (r22 == false) goto L40;
        ICommentFetchApi.a.getClass();
        Observable r23 = ICommentFetchApi.a.a.fetchPost(r4, r6).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    L41:
        this.d = r23.subscribe(new a(this, r12), new b(this, r4, r5, r6, r12));
        return;
    L40:
        ICommentFetchApi.a.getClass();
        r23 = ICommentFetchApi.a.a.fetchGet(r4, r6).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        goto L41
    L34:
        r19 = null;
        goto L35
    L27:
        r18 = null;
        goto L29
    L44:
        return;
    L16:
        r15 = null;
    L10:
        r4 = null;
        goto L11
    }
}
