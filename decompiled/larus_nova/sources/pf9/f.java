package pf9;

import com.larus.im.service.audio.z0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Regex f528902a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Regex f528903b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Regex f528904c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Regex f528905d = null;

    static {
        f528902a = new Regex("(FlowLLMTextContent\\(content=)(.*?)(, blockContent=)");
        f528903b = new Regex("(AsrResult\\(text=)(.*?)(, isInterim=)");
        f528904c = new Regex("(\\baudioExtra=\\{.*?\\btext=)(.*?)(, [A-Za-z0-9_]+=|\\})");
        f528905d = new Regex("(\\baudioContent=.*?\"text\"\\s*:\\s*\")(.*?)(\")");
    }

    public static final String b(String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return r100;
    L9:
        return StringsKt.first(r100) + "[erase-" + (r100.length() - 1) + ']';
    L5:
        r101 = false;
        goto L6
    }

    public static final String a(z0.a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == true) goto L5;
        String r102 = r100.toString();
        String r103 = f528902a.replace(r102, new b());
        String r104 = f528903b.replace(r103, new c());
        String r105 = f528904c.replace(r104, new d());
        return f528905d.replace(r105, new e());
    L5:
        return r100.toString();
    }
}
