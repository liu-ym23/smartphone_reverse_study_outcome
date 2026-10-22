package dq5;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.CreateSpacePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetMyLibraryPuller;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ ce5.a a;

        public a(ce5.a r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            up5.b r4 = (up5.b) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            if (r4.b() == false) goto L7;
            int r5 = j.a;
            ce5.a r6 = this.a;
            tt5.a.h("HomeLibraryIdFetcher", "pullMyLibrary.");
            return new GetMyLibraryPuller(r6.c).d(new GetMyLibraryPuller.Params()).map(new l(r6)).onErrorResumeNext(m.a);
        L7:
            return Flowable.just(r4);
        }
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ ce5.a a;

        public b(ce5.a r1) {
            this.a = r1;
        }

        public final Object apply(Object r6) {
            up5.b r7 = (up5.b) r6;
            Intrinsics.checkNotNullParameter(r7, "it");
            if (r7.b() == false) goto L7;
            int r8 = j.a;
            ce5.a r9 = this.a;
            tt5.a.h("HomeLibraryIdFetcher", "createMyLibrary.");
            NetService r0 = r9.c;
            new CreateSpacePuller(r0);
            return new CreateSpacePuller.a(r0).a(CreateSpacePuller.Params.myLibParams(), System.currentTimeMillis(), 0).map(new i(r9));
        L7:
            return Flowable.just(r7);
        }
    }

    static {
    }

    public j() {
    }

    @JvmStatic
    public static final String a(ce5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentAbility");
        String r3 = ((by4.d) r2.a(by4.d.class)).b("preference_my_library_info").getString("library_id", "");
        if (r3 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        return null;
    L12:
        return r3;
    L5:
        if (r3.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public static Flowable b(ce5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentAbility");
        tt5.a.h("HomeLibraryIdFetcher", "loadMyLibrary.");
        Flowable r3 = Flowable.fromCallable(new k(r2)).flatMap(new a(r2)).flatMap(new b(r2));
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return r3.map(up5.c.a).observeOn(fo5.d.d());
    }

    @JvmStatic
    public static final boolean c(String r3, ce5.a r4) {
        Intrinsics.checkNotNullParameter(r4, "userComponentAbility");
        if (r3 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
    L13:
        return false;
    L11:
        if (TextUtils.equals(r3, a(r4)) == false) goto L13;
        return true;
    L5:
        if (r3.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
