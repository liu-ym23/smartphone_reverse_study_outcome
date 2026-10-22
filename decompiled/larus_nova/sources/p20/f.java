package p20;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class f<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f527370a = null;

    static {
        f527370a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<e.a> r110) {
        Intrinsics.checkNotNullParameter(r110, "it");
        a(Runtime.getRuntime(), "logcat -c");
        Reader r100 = new InputStreamReader(a(Runtime.getRuntime(), "logcat").getInputStream(), Charsets.UTF_8);
        if ((r100 instanceof BufferedReader) == false) goto L5;
        BufferedReader r101 = (BufferedReader) r100;
    L48:
        Iterator<String> r102 = TextStreamsKt.lineSequence(r101).iterator();     // Catch: Throwable -> L43
    L8:
        if (r102.hasNext() == false) goto L40;
        String r103 = r102.next();     // Catch: Throwable -> L43
        if (StringsKt.contains$default(r103, "JsBridge2: Received call:", false, 2, null) == false) goto L8;
        int r104 = r103.length();     // Catch: Throwable -> L43
        int r105 = 0;
    L12:
        int r106 = -1;
        if (r105 >= r104) goto L21;
        if (r103.charAt(r105) != '{') goto L17;
        boolean r107 = true;
    L18:
        if (r107 == true) goto L22;
        r105 = r105 + 1;     // Catch: Throwable -> L43
    L22:
        int r108 = r103.length() - 1;     // Catch: Throwable -> L43
    L23:
        if (r108 < 0) goto L31;
        if (r103.charAt(r108) != '}') goto L27;
        boolean r109 = true;
    L28:
        if (r109 == true) goto L29;
        r108 = r108 - 1;     // Catch: Throwable -> L43
        goto L23
    L29:
        r106 = r108;
        goto L31
    L27:
        r109 = false;
    L31:
        JSONObject r111 = new JSONObject(r103.substring(r105, r106 + 1));     // Catch: Throwable -> L43
        Object r112 = r111.get("func");     // Catch: Throwable -> L43
        if (r112 == null) goto L39;
        String r113 = (String) r112;     // Catch: Throwable -> L43
        Object r114 = r111.get("params");     // Catch: Throwable -> L43
        if (r114 == null) goto L37;
        r110.onNext(new e.a(r113, r111.optString("__callback_id"), ((JSONObject) r114).toString(), null, 18));     // Catch: Throwable -> L43
        goto L8
    L37:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");     // Catch: Throwable -> L43
    L39:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L43
    L17:
        r107 = false;
        goto L18
    L21:
        r105 = -1;
        goto L22
    L40:
        r110.onComplete();     // Catch: Throwable -> L43
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L43
        CloseableKt.closeFinally(r101, null);
        return;
    L43:
        th = move-exception;
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        CloseableKt.closeFinally(r101, th);
        throw th;
    L5:
        r101 = new BufferedReader(r100, 8192);
        goto L48
    }

    public static Process a(Runtime r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r112, false);
        return (Process) r113.f474983b;
    L6:
        Process r114 = r110.exec(r111);
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r114, r112, true);
        return r114;
    }
}
