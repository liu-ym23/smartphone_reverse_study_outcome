package com.larus.bmhome.chat.markdown.reference;

import com.larus.im.bean.message.Reference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class a {
    public static final String a(SearchReferenceData r100) {
        if (r100 != null) goto L27;
        String r101 = null;
    L6:
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        int r102 = StringsKt.split$default(r101, new String[]{"%s"}, false, 0, 6, null).size() - 1;     // Catch: Exception -> L26
        if (r100 == null) goto L13;
        List<String> r103 = r100.getQueries();     // Catch: Exception -> L26
        if (r103 == null) goto L13;
        int r104 = r103.size();     // Catch: Exception -> L26
    L14:
        if (r100 == null) goto L18;
        List<Reference> r105 = r100.getReference();     // Catch: Exception -> L26
        if (r105 == null) goto L18;
        int r106 = r105.size();     // Catch: Exception -> L26
    L19:
        if (r102 != 1) goto L21;
        StringCompanionObject r107 = StringCompanionObject.INSTANCE;     // Catch: Exception -> L26
        return String.format(r101, Arrays.copyOf(new Object[]{String.valueOf(r106)}, 1));
    L21:
        if (r102 != 2) goto L28;
        StringCompanionObject r108 = StringCompanionObject.INSTANCE;     // Catch: Exception -> L26
        return String.format(r101, Arrays.copyOf(new Object[]{String.valueOf(r104), Integer.valueOf(r106)}, 2));
    L28:
        return r101;
    L18:
        r106 = 0;
    L13:
        r104 = 0;
        goto L14
    L27:
        r101 = r100.getTitle();     // Catch: Exception -> L26
    L26:
        return "";
    }

    public static final List<String> b(SearchReferenceData r110) {
        String r100 = null;
        if (r110 == null) goto L15;
        List<String> r101 = r110.getQueries();
        if (r101 == null) goto L15;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L16;
        String r104 = (String) r103.next();
        String r105 = r110.getSearchLoadingText();
        if (r105 == null) goto L12;
        String r106 = StringsKt.replace$default(r105, "%s", r104, false, 4, null);
    L13:
        if (r106 == null) goto L8;
        r102.add(r106);
        goto L8
    L12:
        r106 = null;
    L16:
        ArrayList r107 = r102;
        if (r107 != null) goto L19;
    L22:
        boolean r108 = true;
    L23:
        if (r108 == false) goto L35;
        if (r110 == null) goto L26;
        r100 = r110.getSearchLoadingText();
    L26:
        if (r100 != null) goto L29;
        r100 = "";
    L29:
        return CollectionsKt.listOf(r100);
    L35:
        return r102;
    L19:
        if (r107.isEmpty() == true) goto L22;
        r108 = false;
    L15:
        r102 = null;
        goto L16
    }
}
