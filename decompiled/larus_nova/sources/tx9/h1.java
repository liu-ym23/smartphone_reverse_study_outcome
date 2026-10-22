package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class h1 {
    public static final String b(String r100) {
        if (r100 == null) goto L9;
        String r101 = StringsKt.trim(r100).toString();
        if (r101 == null) goto L9;
        String r102 = StringsKt.trimStart(r101, new char[]{'.'});
        if (r102 == null) goto L9;
        String r103 = r102.toLowerCase(Locale.ROOT);
    L10:
        if (r103 == null) goto L35;
        int r104 = r103.hashCode();
        if (r104 == 3479) goto L31;
        if (r104 == 103649) goto L27;
        if (r104 == 3213227) goto L24;
        if (r104 == 246938863) goto L21;
        return null;
    L21:
        if (r103.equals("markdown") == true) goto L34;
        return null;
    L34:
        return "md";
    L24:
        if (r103.equals("html") == true) goto L37;
        return null;
    L37:
        return "html";
    L27:
        if (r103.equals("htm") == true) goto L37;
        return null;
    L31:
        if (r103.equals("md") == true) goto L34;
        return null;
    L35:
        return null;
    L9:
        r103 = null;
        goto L10
    }

    public static final void a(String r100, String r101, String r102, String r103, String r104, by7.e r105) {
        String r106 = b(r104);
        if (r106 != null) goto L5;
        return;
    L5:
        by7.a r107 = new by7.a(r100);
        if (r105 == null) goto L8;
        r107.f21464b = r105;
    L8:
        TrackParams r108 = new TrackParams();
        Intrinsics.checkNotNullParameter(r106, "contentSecType");
        JSONObject r109 = new JSONObject();
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        r109.put("chat_id", r103);
        if (r101 != null) goto L14;
        r101 = "";
    L14:
        r109.put(MusicAppletPage.KEY_MESSAGE_ID, r101);
        if (r102 != null) goto L17;
        r102 = "";
    L17:
        r109.put("conversation_id", r102);
        r109.put("content_sec_type", r106);
        r109.put("content_type", "code");
        TrackParams r110 = r108.merge(r109);
        r107.f21463a.merge(r110);
        r107.b();
    }
}
