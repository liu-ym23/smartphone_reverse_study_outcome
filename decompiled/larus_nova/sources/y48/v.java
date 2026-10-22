package y48;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.larus.asr.config.builder.ChatSpeakerScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class v {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f566138e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChatSpeakerScene f566139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z48.a f566140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f566141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p f566142d;

    public static final class a {
        public static v a() {
            return new v(0);
        }
    }

    static {
    }

    public v() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (this.f566139a == r101.f566139a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f566140b, r101.f566140b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(null, null) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f566141c, r101.f566141c) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f566142d, r101.f566142d) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f566139a.hashCode() * 31;
        z48.a r101 = this.f566140b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((((r100 + r102) * 31) + 0) * 31) + this.f566141c.hashCode()) * 31) + this.f566142d.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ChatSpeakerSpec(scene=" + this.f566139a + ", uiConfig=" + this.f566140b + ", styleConfig=null, behavior=" + this.f566141c + ", elements=" + this.f566142d + ')';
    }

    public v(int r100) {
        ChatSpeakerScene r101 = ChatSpeakerScene.Default;
        d r102 = d.f566078e;
        int r103 = p.f566127b;
        this(r101, null, r102, p.a.a());
    }

    public v(ChatSpeakerScene r100, z48.a r101, d r102, p r103) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r102, "behavior");
        Intrinsics.checkNotNullParameter(r103, SlcElement.KEY_ELEMENTS);
        this.f566139a = r100;
        this.f566140b = r101;
        this.f566141c = r102;
        this.f566142d = r103;
    }
}
