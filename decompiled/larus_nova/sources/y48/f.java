package y48;

import com.larus.asr.config.builder.ChatSpeakerElementKey;
import com.larus.asr.config.builder.ChatSpeakerScene;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class f {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f566092h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ChatSpeakerScene f566093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z48.a f566094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f566095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<ChatSpeakerElementKey, i> f566096d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f566097e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f566098f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f566099g;

    public static final class a {
        public static f a() {
            f r100 = new f();
            r100.f566093a = ChatSpeakerScene.Default;
            r100.f566094b = null;
            r100.f566095c = d.f566078e;
            int r101 = p.f566127b;
            r100.f566096d = MapsKt.toMutableMap(p.a.a().f566128a);
            r100.f566097e = false;
            r100.f566098f = false;
            r100.f566099g = false;
            return r100;
        }
    }

    static {
    }

    public final v a() {
        return new v(this.f566093a, this.f566094b, this.f566095c, new p(MapsKt.toMap(this.f566096d)));
    }

    public f() {
        this.f566093a = ChatSpeakerScene.Default;
        this.f566095c = d.f566078e;
        int r100 = p.f566127b;
        this.f566096d = MapsKt.toMutableMap(p.a.a().f566128a);
    }

    public final void b(x48.b r100) {
        if (this.f566097e == true) goto L9;
        if (r100 == null) goto L6;
        z48.a r101 = r100.f562448a;
    L7:
        this.f566094b = r101;
        goto L9
    L6:
        r101 = null;
    L9:
        if (this.f566098f == false) goto L11;
        return;
    L11:
        if (this.f566099g == true) goto L21;
        d r102 = this.f566095c;
        if (r100 == null) goto L17;
        boolean r103 = true;
        if (r100.f562449b != true) goto L17;
    L18:
        this.f566095c = d.a(r102, r103, false, false, 14);
        return;
    L17:
        r103 = false;
        goto L18
    }
}
