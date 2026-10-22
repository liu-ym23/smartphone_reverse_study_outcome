package ms.bd.c;

import com.ss.ttm.player.MediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.ByteCompanionObject;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okio.Buffer;

/* JADX INFO: loaded from: classes5.dex */
public abstract class d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f515133a = 0;

    static {
        String r100 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "c1c7b9", new byte[]{70, 7, 62, 70, 73, 12, 111, 20, 43, 74, 125, 55, 25, 69, 84, 43, 114});
    }

    public static String a(RequestBody r100) {
        Buffer r101 = new Buffer();     // Catch: Exception -> L8
        if (r100 == null) goto L6;
        r100.writeTo(r101);     // Catch: Exception -> L8
        return r101.readUtf8();
    L6:
        return "";
    }

    public static RequestBody b(RequestBody r110, HashMap r111) {
        String r100 = a(r110);     // Catch: Exception -> L11
        Iterator r101 = r111.keySet().iterator();     // Catch: Exception -> L11
        FormBody.Builder r102 = new FormBody.Builder();     // Catch: Exception -> L11
    L4:
        if (r101.hasNext() == false) goto L6;
        String r103 = (String) r101.next();     // Catch: Exception -> L11
        r102.add(r103, ((String) r111.get(r103)).replaceAll((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "531ff8", new byte[]{ByteCompanionObject.MAX_VALUE}), (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "d7e4d9", new byte[]{48, 102, 52})));     // Catch: Exception -> L11
        goto L4
    L6:
        FormBody r104 = r102.build();     // Catch: Exception -> L11
        StringBuilder r105 = new StringBuilder(r100);     // Catch: Exception -> L11
        if (r100.length() <= 0) goto L9;
        r105.append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "646373", new byte[]{97}));     // Catch: Exception -> L11
    L9:
        r105.append(a(r104));     // Catch: Exception -> L11
        return RequestBody.create(r110.contentType(), r105.toString());
    L12:
        return r110;
    }
}
