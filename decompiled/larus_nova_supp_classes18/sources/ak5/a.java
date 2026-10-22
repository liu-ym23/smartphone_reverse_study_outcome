package ak5;

import android.text.TextUtils;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements FlowableOnSubscribe<k> {
    public final /* synthetic */ k a;
    public final /* synthetic */ b b;

    /* JADX INFO: renamed from: ak5.a$a, reason: collision with other inner class name */
    public class C0001a {
        public final /* synthetic */ FlowableEmitter a;
        public final /* synthetic */ a b;

        public C0001a(a r1, FlowableEmitter r2) {
            this.b = r1;
            this.a = r2;
        }

        public final void a(boolean r3, String r4) {
            if (r3 == false) goto L9;
            tt5.a.b("CheckLoginFun", "onCheckOver: you have login, and supported the token, uid=" + r4);
            if (TextUtils.isEmpty(r4) == true) goto L7;
            this.b.a.getClass();
        L7:
            this.a.onNext(this.b.a);
            this.a.onComplete();
            return;
        L9:
            if (this.a.isCancelled() == true) goto L13;
            tt5.a.d("CheckLoginFun", "onCheckOver, not Login uid=" + r4);
            this.a.onError(new Exception("You are not login, so denied your http request."));
            this.a.onComplete();
            return;
        }
    }

    public final void subscribe(FlowableEmitter<k> r3) throws Exception {
        this.b.a.a(new C0001a(this, r3));
    }

    public a(b r1, k r2) {
        this.b = r1;
        this.a = r2;
    }
}
