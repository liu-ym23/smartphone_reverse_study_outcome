package vha;

import com.obric.assistant.wakeup.co_wakeup.dora.model.DoraConnectState;
import com.obric.assistant.wakeup.co_wakeup.dora.model.DoraSwitchState;
import com.obric.assistant.wakeup.co_wakeup.dora.model.DoraWearState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: vha.a$a, reason: collision with other inner class name */
    public static final class C8007a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DoraSwitchState f554988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DoraConnectState f554989b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final DoraWearState f554990c;

        public C8007a(DoraSwitchState r100, DoraConnectState r101, DoraWearState r102) {
            Intrinsics.checkNotNullParameter(r100, "switchState");
            Intrinsics.checkNotNullParameter(r101, "connectState");
            Intrinsics.checkNotNullParameter(r102, "wearState");
            this.f554988a = r100;
            this.f554989b = r101;
            this.f554990c = r102;
        }
    }

    public a() {
    }
}
