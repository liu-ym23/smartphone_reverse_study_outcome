package qd2;

import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends BaseJsBridgeMethodFactory {
    public final o a;

    public static final class a implements f.b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final f<Object, Object> a() {
            return new qd2.a();
        }
    }

    public b(o r2) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        this.a = r2;
    }

    public final Map<String, f.b> provideStatefulMethods(IJsBridgeManager r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        return MapsKt.mapOf(TuplesKt.to("addSong", a.a));
    }

    public final Map<String, g<?, ?>> provideStatelessMethods(IJsBridgeManager r3) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("orderSongSuccess", new d(this.a)), TuplesKt.to("openSongDialog", new c(this.a))});
    }
}
