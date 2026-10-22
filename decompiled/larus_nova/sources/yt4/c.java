package yt4;

import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSONObject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import vv4.k;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends wt4.a implements xt4.c {

    public static final class a {
    }

    public static final class b<T> implements ValueCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f569136a;

        public b(Function0<Unit> r100) {
            this.f569136a = r100;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r100) {
            String r101 = (String) r100;
            this.f569136a.invoke();
        }
    }

    static {
    }

    public c(k r100) {
        super(r100);
    }

    @Override // xt4.c
    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        JSONObject r101 = new JSONObject();
        r101.put("commentId", r100);
        l("javascript:window.lark.biz.bitable.deleteComment", r101);
    }

    @Override // xt4.c
    public final void h(boolean r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        JSONObject r102 = new JSONObject();
        r102.put("commentable", Boolean.valueOf(r100));
        m("javascript:window.lark.biz.bitable.updatePermission", r102, new b(r101));
    }

    @Override // xt4.c
    public final void g(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "tableId");
        Intrinsics.checkNotNullParameter(r102, "recordId");
        JSONObject r103 = new JSONObject();
        r103.put("tableId", r100);
        r103.put("viewId", r101);
        r103.put("recordId", r102);
        l("javascript:window.lark.biz.bitable.openCommentInput", r103);
    }

    @Override // xt4.c
    public final void f(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "recordId");
        JSONObject r104 = new JSONObject();
        r104.put("tableId", r101);
        r104.put("recordId", r100);
        if (r102 == null) goto L5;
        r104.put("commentId", r102);
    L5:
        if (r103 == null) goto L7;
        r104.put("replyId", r103);
    L7:
        l("javascript:window.lark.biz.bitable.openRecordComment", r104);
    }
}
