package dq5;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.CreateSpacePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetMyLibraryPuller;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f469673a = 0;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ce5.a f469674a;

        public a(ce5.a r100) {
            this.f469674a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            up5.b r101 = (up5.b) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if (r101.b() == false) goto L7;
            int r102 = j.f469673a;
            ce5.a r103 = this.f469674a;
            tt5.a.h("HomeLibraryIdFetcher", "pullMyLibrary.");
            return new GetMyLibraryPuller(r103.f23448c).d(new GetMyLibraryPuller.Params()).map(new l(r103)).onErrorResumeNext(m.f469678a);
        L7:
            return Flowable.just(r101);
        }
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ce5.a f469675a;

        public b(ce5.a r100) {
            this.f469675a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            up5.b r101 = (up5.b) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if (r101.b() == false) goto L7;
            int r102 = j.f469673a;
            ce5.a r103 = this.f469675a;
            tt5.a.h("HomeLibraryIdFetcher", "createMyLibrary.");
            NetService r104 = r103.f23448c;
            new CreateSpacePuller(r104);
            return new CreateSpacePuller.a(r104).a(CreateSpacePuller.Params.myLibParams(), System.currentTimeMillis(), 0).map(new i(r103));
        L7:
            return Flowable.just(r101);
        }
    }

    static {
    }

    public j() {
    }

    @JvmStatic
    public static final String a(ce5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "userComponentAbility");
        String r101 = ((by4.d) r100.a(by4.d.class)).b("preference_my_library_info").getString("library_id", "");
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return null;
    L12:
        return r101;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static Flowable b(ce5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "userComponentAbility");
        tt5.a.h("HomeLibraryIdFetcher", "loadMyLibrary.");
        Flowable r101 = Flowable.fromCallable(new k(r100)).flatMap(new a(r100)).flatMap(new b(r100));
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.map(up5.c.f551049a).observeOn(fo5.d.d());
    }

    @JvmStatic
    public static final boolean c(String r100, ce5.a r101) {
        Intrinsics.checkNotNullParameter(r101, "userComponentAbility");
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
    L13:
        return false;
    L11:
        if (TextUtils.equals(r100, a(r101)) == false) goto L13;
        return true;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
