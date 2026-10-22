package ke2;

import android.content.Context;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.midi.e;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentMidiViewModel;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import qh0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a implements qh0.d<rh0.a> {
        public final /* synthetic */ Function2 a;

        public a(Function2 r1) {
            this.a = r1;
        }

        public final void b(BaseCheckException r3) {
            Intrinsics.checkNotNullParameter(r3, "exception");
            Function2 r0 = this.a;
            if (r0 == null) goto L6;
            Unit r4 = (Unit) r0.invoke(Boolean.FALSE, r3);
            return;
        }

        public final void onResult(Object r2) {
            rh0.a r3 = (rh0.a) r2;
            int r4 = c.a;
            ILiveWrappedLivePusher.Companion.getClass();     // Catch: Throwable -> L7
            ILiveWrappedLivePusher r5 = ILiveWrappedLivePusher.a.b();     // Catch: Throwable -> L7
            if (r5 == null) goto L11;
            r5.getMediaEngineFactory();     // Catch: Throwable -> L7
            return;
        L11:
            return;
        L7:
            e.b(KtvComponentMidiViewModel.TAG, "MediaEngineFactory.loadLibrary tryLoadLibraryNormal fail");
        }
    }

    static {
    }

    public static void a(Function2 r5) {
        ArrayList r0 = new ArrayList();
        Context r2 = s1.getContext();
        OperateType r3 = OperateType.MIDI;
        r0.add(new f.d(r2, r3, 0, false));
        r0.add(new f.f(s1.getContext(), r3, 0, false));
        f.a(r0).a(new a(r5));
    }

    public static void b(Function2 r2) {
        a(r2);     // Catch: Throwable -> L4
        return;
    L4:
        e.b(KtvComponentMidiViewModel.TAG, "MediaEngineFactory.loadLibrary tryLoadLibrary fail");
        a(r2);
    }
}
