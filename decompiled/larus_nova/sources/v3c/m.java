package v3c;

import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.Content;
import com.ss.android.lark.search.dto.info.TagContent;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes38.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Integer> f552981a = null;

    static {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("grey", Integer.valueOf(R.color.text_placeholder));
        f552981a = r100;
    }

    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new Regex("\\p{C}").replace(r100, "");
    }

    public static final l b(String r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r100 = "";
        ArrayList r101 = new ArrayList();
        String r102 = "<wrapper>" + r110 + "</wrapper>";     // Catch: Exception -> L52
        if (r110.length() <= 500) goto L6;
        r102 = "<wrapper>" + r110.substring(0, 500) + "</wrapper>";     // Catch: Exception -> L52
    L6:
        Log.d("Tool-MetaParser", "origin: " + r102);     // Catch: Exception -> L52
        LinkedHashMap r112 = new LinkedHashMap();     // Catch: Exception -> L52
        XmlPullParser r103 = XmlPullParserFactory.newInstance().newPullParser();     // Catch: Exception -> L52
        r103.setInput(new StringReader(r102));     // Catch: Exception -> L52
        int r104 = r103.getEventType();     // Catch: Exception -> L52
        int r105 = -1;
        String r106 = "";
        String r107 = r106;
        String r113 = r107;
        boolean r108 = false;
    L8:
        boolean r114 = true;
        if (r104 == 1) goto L54;
        if (r104 != 0) goto L12;
        Log.d("Tool-MetaParser", "Start document");     // Catch: Exception -> L50
    L48:
        r104 = r103.next();     // Catch: Exception -> L50
        goto L8
    L12:
        if (r104 != 2) goto L14;
        Log.d("Tool-MetaParser", "Start tag " + r103.getName());     // Catch: Exception -> L50
        if (c(r103.getName(), r111) == false) goto L48;
        if (r108 == true) goto L46;
        int r109 = r106.length();     // Catch: Exception -> L50
        Log.d("Tool-MetaParser", "start index: " + r109);     // Catch: Exception -> L50
        r107 = r103.getName();     // Catch: Exception -> L50
        r112.clear();     // Catch: Exception -> L50
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L50
        int r115 = r103.getAttributeCount();     // Catch: Exception -> L50
        LinkedHashMap r116 = new LinkedHashMap();     // Catch: Exception -> L50
    L42:
        if (r115 <= 0) goto L44;
        r115 = r115 - 1;     // Catch: Exception -> L50
        r116.put(r103.getAttributeName(r115), r103.getAttributeValue(r115));     // Catch: Exception -> L50
        goto L42
    L44:
        r112.putAll(r116);     // Catch: Exception -> L50
        r105 = r109;
        r108 = true;
        goto L48
    L46:
        throw new RuntimeException(r103.getName() + ", start status err!");     // Catch: Exception -> L50
    L14:
        if (r104 != 3) goto L16;
        Log.d("Tool-MetaParser", "End tag " + r103.getName());     // Catch: Exception -> L50
        if (c(r103.getName(), r111) == false) goto L48;
        if (r108 == false) goto L37;
        if (Intrinsics.areEqual(r107, r103.getName()) == true) goto L27;
    L35:
        r108 = false;
        goto L48
    L27:
        if (Intrinsics.areEqual(r107, "pi") == true) goto L29;
    L34:
        String r117 = r103.getName();     // Catch: Exception -> L50
        Content r118 = new Content(r113, r105);     // Catch: Exception -> L50
        Map r119 = MapsKt.toMutableMap(r112);     // Catch: Exception -> L50
        Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");     // Catch: Exception -> L50
        r101.add(new TagContent(r117, r118, (HashMap) r119));     // Catch: Exception -> L50
        r113 = "";
        goto L35
    L29:
        if (r113.length() == 0) goto L32;
        r114 = false;
    L32:
        if (r114 == false) goto L34;
        r113 = "   ";
        r106 = r106 + "   ";     // Catch: Exception -> L50
        goto L34
    L37:
        throw new RuntimeException(r103.getName() + ", start status err when end!");     // Catch: Exception -> L50
    L16:
        if (r104 != 4) goto L48;
        Log.d("Tool-MetaParser", "Text " + r103.getText());     // Catch: Exception -> L50
        r106 = r106 + r103.getText();     // Catch: Exception -> L50
        if (r108 == false) goto L48;
        r113 = r103.getText();     // Catch: Exception -> L50
    L50:
        e = e;
        r100 = r106;
    L53:
        Log.e("Tool-MetaParser", "parse err, " + e.getMessage());
        r106 = r100;
    L54:
        Log.d("Tool-MetaParser", "End document");
        Log.d("Tool-MetaParser", "contentWithoutTag: " + r106);
        Log.d("Tool-MetaParser", "tagContentList: " + r101);
        return new l(r106, r101);
    L52:
        e = e;
        goto L53
    }

    public static final boolean c(String r100, boolean r101) {
        if (Intrinsics.areEqual(r100, "h") == false) goto L5;
    L17:
        return true;
    L5:
        if (Intrinsics.areEqual(r100, "di") == true) goto L17;
        if (Intrinsics.areEqual(r100, "asl-style") == true) goto L17;
        if (Intrinsics.areEqual(r100, "b") == true) goto L17;
        if (Intrinsics.areEqual(r100, "hb") == true) goto L17;
        if (Intrinsics.areEqual(r100, "pi") == false) goto L16;
        if (r101 == true) goto L17;
    L16:
        return false;
    }
}
