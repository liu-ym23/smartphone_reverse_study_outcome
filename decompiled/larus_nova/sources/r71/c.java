package r71;

import com.bytedance.android.live.room.api.messagewindow.list.RecordAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f536394b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f536395a;

    public static final class a {
        public a() {
        }

        public static c a(RecordAction r100, Object r101, v61.a r102, int r103) {
            int r104 = c.f536394b;
            Intrinsics.checkNotNullParameter(r100, "action");
            Intrinsics.checkNotNullParameter(r101, "id");
            return new c(r100, r101);
        }
    }

    static {
        new a();
    }

    public c(RecordAction r100, Object r101) {
        super(r100);
        this.f536395a = r101;
    }
}
