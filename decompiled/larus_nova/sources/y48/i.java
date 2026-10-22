package y48;

import android.content.Context;
import com.larus.asr.config.builder.ChatSpeakerElementKey;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f566101j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChatSpeakerElementKey f566102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f566103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f566104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<y, Boolean, Boolean> f566105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<Context, y, o> f566106e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<k, s> f566107f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m f566108g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final n f566109h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c0 f566110i;

    public static final class a {
        public static i a(ChatSpeakerElementKey r110) {
            Intrinsics.checkNotNullParameter(r110, "key");
            return new i(r110, true, 0, null, null, null, null, null, null);
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(ChatSpeakerElementKey r100, boolean r101, int r102, Function2<? super y, ? super Boolean, Boolean> r103, Function2<? super Context, ? super y, ? extends o> r104, Function1<? super k, ? extends s> r105, m r106, n r107, c0 r110) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f566102a = r100;
        this.f566103b = r101;
        this.f566104c = r102;
        this.f566105d = r103;
        this.f566106e = r104;
        this.f566107f = r105;
        this.f566108g = r106;
        this.f566109h = r107;
        this.f566110i = r110;
    }
}
