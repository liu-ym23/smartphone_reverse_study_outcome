package w62;

import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f558400b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IMiddlewareHostBusiness.AwemeCustomPureVideoPlayerView f558401a;

    /* JADX INFO: renamed from: w62.a$a, reason: collision with other inner class name */
    public static final class C8074a {
        public static a a() {
            if (a.f558400b != null) goto L5;
            a.f558400b = new a();
        L5:
            a r100 = a.f558400b;
            if (r100 == null) goto L9;
            return r100;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.comment.input.view.AwemeCustomPureVideoPlayerManager");
        }
    }

    static {
    }

    public a() {
    }
}
