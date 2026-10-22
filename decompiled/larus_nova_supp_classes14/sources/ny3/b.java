package ny3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements p24.b {
    public final /* synthetic */ c a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;

    public final void b() {
    }

    public final void a() {
        com.bytedance.awemeopen.apps.framework.comment.view.c r0 = (com.bytedance.awemeopen.apps.framework.comment.view.c) this.a.b;
        if (r0 == null) goto L6;
        r0.h(this.b, this.c);
        return;
    }

    public final void onSuccess() {
        com.bytedance.awemeopen.apps.framework.comment.view.c r0 = (com.bytedance.awemeopen.apps.framework.comment.view.c) this.a.b;
        if (r0 == null) goto L6;
        r0.b(this.b, this.c);
        return;
    }

    public final void onFail(Exception r3) {
        com.bytedance.awemeopen.apps.framework.comment.view.c r4 = (com.bytedance.awemeopen.apps.framework.comment.view.c) this.a.b;
        if (r4 == null) goto L6;
        r4.h(this.b, this.c);
        return;
    }

    public b(c r1, String r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
