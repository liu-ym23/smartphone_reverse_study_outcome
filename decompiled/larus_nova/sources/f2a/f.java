package f2a;

import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f475232b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f475233c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f475234d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f f475235e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f475236f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f475237g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final f f475238h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final f f475239i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final f f475240j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final f f475241k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final f f475242l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final f f475243m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final f f475244n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final f f475245o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final f f475246p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final f f475247q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final f f475248r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final f f475249s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final f f475250t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final f f475251u = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f475252a;

    public static final class a {
        public a() {
        }

        public static f a() {
            return f.f475238h;
        }

        public static f b() {
            return f.f475239i;
        }

        public static f c() {
            return f.f475233c;
        }

        public final f getType() {
            return f.f475248r;
        }
    }

    static {
        f475232b = new a();
        new f("call_id");
        f475233c = new f("task_id");
        new f("session_id");
        new f("log_id");
        new f("style_id");
        new f("audio_scene");
        new f("session_category");
        new f("session_mode");
        new f("session_options");
        f475234d = new f("result");
        f475235e = new f("bot_id");
        f475236f = new f("bot_name");
        f475237g = new f("content_type");
        f475238h = new f("conversation_id");
        f475239i = new f(MusicAppletPage.KEY_MESSAGE_ID);
        f475240j = new f("voice_id");
        f475241k = new f("text");
        f475242l = new f("error_msg");
        f475243m = new f("last_call_tts_task_id");
        f475244n = new f("is_interrupt");
        f475245o = new f("tts_subtitle_data");
        f475246p = new f("sectionId");
        f475247q = new f("queryRound");
        f475248r = new f("type");
        f475249s = new f("updateKey");
        f475250t = new f("action");
        f475251u = new f("enter_method");
    }

    public final int hashCode() {
        return this.f475252a.hashCode();
    }

    public f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rawValue");
        this.f475252a = r100;
    }

    public final boolean equals(Object r100) {
        String r101 = null;
        if ((r100 instanceof f) == false) goto L5;
        f r102 = (f) r100;
    L6:
        if (r102 == null) goto L9;
        r101 = r102.f475252a;
    L9:
        return Intrinsics.areEqual(r101, this.f475252a);
    L5:
        r102 = null;
        goto L6
    }
}
