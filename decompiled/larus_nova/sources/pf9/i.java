package pf9;

import com.larus.im.service.audio.cmd.ReplyStage;
import com.larus.im.service.audio.cmd.ReplyType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap<String, Boolean> f528921a = null;

    static {
        f528921a = new LinkedHashMap();
    }

    public static final String a(f0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = f(r100);
        if ((!StringsKt.isBlank(r101)) == true) goto L6;
        r101 = null;
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        return k(r100);
    }

    public static final boolean b(f0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getType() != ReplyType.Sentence) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean c(f0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getType() != ReplyType.Text) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean d(f0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (c(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.f528910d != ReplyStage.Update) goto L7;
        return true;
    }

    public static final boolean e(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return false;
    L12:
        if (f528921a.get(r100) != null) goto L16;
        return false;
    L16:
        return true;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    public static final String f(f0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        k0 r101 = r100.f528908b;
        if (r101 == null) goto L5;
        String r102 = r101.f528927f;
    L7:
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        if (StringsKt.isBlank(r102) == false) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
    L18:
        return "";
    L15:
        if (Intrinsics.areEqual(r102, "0") == true) goto L18;
        return r102;
    L12:
        r103 = false;
        goto L13
    L5:
        r102 = null;
        goto L7
    }

    public static final void g(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        LinkedHashMap<String, Boolean> r102 = f528921a;
        if (r102.containsKey(r100) == false) goto L13;
    L15:
        r102.put(r100, Boolean.TRUE);
        return;
    L13:
        if (r102.size() < 10) goto L15;
        r102.remove(CollectionsKt.first(r102.keySet()));
        goto L15
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L8
    }

    public static final String h(f0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        k0 r101 = r100.f528908b;
        if (r101 == null) goto L5;
        String r102 = r101.f528936o;
    L7:
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        if (StringsKt.isBlank(r102) == false) goto L12;
    L15:
        return "";
    L12:
        if (Intrinsics.areEqual(r102, "0") == true) goto L15;
        return r102;
    L5:
        r102 = null;
        goto L7
    }

    public static final boolean i(f0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (b(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.f528910d != ReplyStage.Begin) goto L7;
        return true;
    }

    public static final boolean j(f0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (b(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.f528910d != ReplyStage.Update) goto L7;
        return true;
    }

    public static final String k(f0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        k0 r101 = r100.f528908b;
        String r102 = null;
        if (r101 == null) goto L7;
        Map<String, String> r103 = r101.f528935n;
        if (r103 == null) goto L7;
        String r104 = r103.get("tts_task_id");
    L8:
        boolean r105 = false;
        if (r104 != null) goto L11;
    L14:
        boolean r106 = true;
    L15:
        if (r106 == true) goto L17;
        return r104;
    L17:
        m r107 = r100.f528909c;
        if (r107 == null) goto L22;
        Map<String, String> r108 = r107.f528940a;
        if (r108 == null) goto L22;
        r102 = r108.get("tts_task_id");
    L22:
        if (r102 != null) goto L24;
    L25:
        r105 = true;
    L26:
        if (r105 == true) goto L28;
        return r102;
    L28:
        return "";
    L24:
        if (r102.length() != 0) goto L26;
    L11:
        if (r104.length() == 0) goto L14;
        r106 = false;
    L7:
        r104 = null;
        goto L8
    }
}
