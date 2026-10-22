package ux1;

import com.bytedance.android.live.room.api.panel.PanelName;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f551963a = 0;

    /* JADX INFO: renamed from: ux1.a$a, reason: collision with other inner class name */
    public static final class C7941a implements com.bytedance.android.live.room.api.panel.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f551964a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f551965b;

        @Override // com.bytedance.android.live.room.api.panel.b
        public final PanelName getPanelName() {
            return PanelName.GameCp;
        }

        @Override // com.bytedance.android.live.room.api.panel.b
        public final int getUnionId() {
            return this.f551965b;
        }

        public C7941a(int r100, int r101) {
            this.f551964a = r100;
            this.f551965b = r101;
        }

        @Override // com.bytedance.android.live.room.api.panel.b
        public final void a(Function1<? super Integer, Unit> r100, Function1<? super String, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "continueAction");
            Intrinsics.checkNotNullParameter(r101, "stopAction");
            r100.invoke(Integer.valueOf(this.f551964a));
        }
    }

    static {
    }
}
