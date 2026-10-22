package qub;

import android.app.Activity;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public interface b extends IOfficeSDKProtocol {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f534852a = null;

        static {
            f534852a = new a();
        }

        public a() {
        }

        @Override // qub.b
        public final qub.a L(Activity r100, rub.a r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "config");
            return qub.a.C7394a.f534851a;
        }
    }

    qub.a L(Activity r100, rub.a r101);
}
