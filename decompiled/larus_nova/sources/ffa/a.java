package ffa;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.obric_action.h;
import com.ss.android.lark.chat.constant.ChatFromType;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f476780a;

    /* JADX INFO: renamed from: ffa.a$a, reason: collision with other inner class name */
    public static final class C5895a {
    }

    static {
    }

    public a(Set<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "supportedHosts");
        this.f476780a = r100;
    }

    public final b a(Uri r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "uri");
        String r100 = r110.getScheme();
        boolean r101 = false;
        if (Intrinsics.areEqual(r100, "obric_action") == false) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == true) goto L14;
        FLogger.f375446a.w("ObricActionIntentResolver", "schema " + r100 + " not support!");
        return new b(null, h.a.a(h.f390443d, "schema " + r100 + " not support", 2), 1);
    L14:
        if (r110.isHierarchical() == true) goto L17;
        FLogger.f375446a.w("ObricActionIntentResolver", "uri is not hierarchical!");
        return new b(null, h.a.a(h.f390443d, "uri is not hierarchical", 2), 1);
    L17:
        String r103 = r110.getHost();
        String r104 = "";
        if (r103 != null) goto L21;
        r103 = "";
    L21:
        if (this.f476780a.contains(r103) == true) goto L24;
        FLogger.f375446a.w("ObricActionIntentResolver", "host " + r103 + " not support!");
        return new b(null, h.a.a(h.f390443d, "host " + r103 + " not support", 2), 1);
    L24:
        String r105 = UriProtector.getQueryParameter(r110, "key");
        if (r105 != null) goto L27;
    L30:
        boolean r106 = true;
    L31:
        if (r106 == false) goto L34;
        FLogger.f375446a.w("ObricActionIntentResolver", "key is empty!");
        return new b(null, h.a.a(h.f390443d, "key is empty", 2), 1);
    L34:
        if (r111 != null) goto L36;
    L39:
        boolean r107 = true;
    L40:
        if (r107 == false) goto L44;
        FLogger.f375446a.w("ObricActionIntentResolver", "expectKey is empty!");
        return new b(null, h.a.a(h.f390443d, "expectKey is empty", 2), 1);
    L44:
        if (StringsKt.equals(r105, r111, true) == true) goto L69;
        FLogger.f375446a.w("ObricActionIntentResolver", "key " + r105 + " not match expectKey " + r111);
        return new b(null, h.a.a(h.f390443d, "key not match expectKey", 2), 1);
    L69:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L52
        String r113 = UriProtector.getQueryParameter(r110, "data");     // Catch: Throwable -> L52
        if (r113 != null) goto L50;
        r113 = "";
    L50:
        Object r114 = Result.m9449constructorimpl(new b(new efa.a(r103, r113), null, 2));     // Catch: Throwable -> L52
    L54:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L68;
        FLogger.f375446a.w("ObricActionIntentResolver", "parse obric action uri failed. " + r115.getMessage(), r115);
        h.a r116 = h.f390443d;
        String r117 = r115.getMessage();
        if (r117 == null) goto L62;
        r104 = r117;
    L62:
        if (r104.length() != 0) goto L64;
        r101 = true;
    L64:
        if (r101 == false) goto L66;
        r104 = "parse obric action uri failed";
    L66:
        r114 = new b(null, h.a.a(r116, r104, 2), 1);
    L68:
        return (b) r114;
    L52:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L54
    L36:
        if (r111.length() == 0) goto L39;
        r107 = false;
        goto L40
    L27:
        if (r105.length() == 0) goto L30;
        r106 = false;
        goto L31
    L5:
        if (Intrinsics.areEqual(r100, ChatFromType.OBRIC_INTENT) == true) goto L8;
        r102 = false;
        goto L10
    }
}
