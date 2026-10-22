package uq3;

import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class s implements QModel {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f551283c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f551284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f551285b;

    public static final class a {
        public static s a(com.bytedance.android.window.shop.repository.dto.g r100) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            String r101 = r100.b();
            if (r101 != null) goto L5;
        L8:
            boolean r102 = true;
        L9:
            if (r102 == false) goto L12;
            return null;
        L12:
            String r103 = r100.b();
            if (r103 != null) goto L15;
            r103 = "";
        L15:
            Long r104 = r100.a();
            if (r104 == null) goto L18;
            long r105 = r104.longValue();
        L20:
            return new s(r103, r105);
        L18:
            r105 = 0;
            goto L20
        L5:
            if (StringsKt.isBlank(r101) == true) goto L8;
            r102 = false;
            goto L9
        }
    }

    static {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.model.QModel
    public final int modelType() {
        return 0;
    }

    public s(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "replaySchema");
        this.f551284a = r100;
        this.f551285b = r101;
    }
}
