package uy8;

import com.larus.platform.model.SlashMentionConfig;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f552156a = 0;

    static {
    }

    public static a a() {
        int r100 = la9.a.f508225a;
        AtomicReference<ga9.a.C5998a> r101 = ga9.a.f480591a;
        return new a(c.a(ga9.a.a("enabled_quick_input_entries", new JSONArray("[]"))), ga9.a.b("quick_input_attachment_add_enable", false), ga9.a.b("quick_input_data_protocol_enable", false));
    }

    public static boolean c() {
        return a().f552155c;
    }

    public static boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        int r101 = la9.a.f508225a;
        AtomicReference<ga9.a.C5998a> r102 = ga9.a.f480591a;
        Set<String> r103 = c.a(ga9.a.a("enabled_preview_scenes", new JSONArray("[]")));
        boolean r104 = c();
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r103, "enabledScenes");
        if (r103.contains(r100) == false) goto L24;
        int r105 = r100.hashCode();
        if (r105 == (-1963501277)) goto L19;
        if (r105 == (-1176625545)) goto L15;
        if (r105 == 92896879) goto L12;
    L20:
        r104 = false;
    L21:
        if (r104 == false) goto L25;
        return true;
    L25:
        return false;
    L12:
        if (r100.equals("album") == true) goto L21;
    L15:
        if (r100.equals("camera_result") == false) goto L20;
        r104 = true;
        goto L21
    L19:
        if (r100.equals(SlashMentionConfig.MENTION_CONTENT_ATTACHMENT) == true) goto L21;
    L24:
        return false;
    }
}
