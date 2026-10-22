package com.larus.bmhome.chat.markdown.reference;

import com.larus.im.bean.message.Reference;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class r {
    public static final boolean a(SearchReferenceData r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        String r101 = r100.getTitle();
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L62;
        List<Reference> r103 = r100.getReference();
        if (r103 != null) goto L16;
    L19:
        boolean r104 = true;
    L20:
        if (r104 == false) goto L62;
        List<String> r105 = r100.getQueries();
        if (r105 != null) goto L24;
    L27:
        boolean r106 = true;
    L28:
        if (r106 == false) goto L62;
        String r107 = r100.getSearchLoadingText();
        if (r107 != null) goto L32;
    L35:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L62;
        String r109 = r100.getIcon();
        if (r109 != null) goto L40;
    L43:
        boolean r110 = true;
    L44:
        if (r110 == false) goto L62;
        String r111 = r100.getIconDark();
        if (r111 != null) goto L48;
    L51:
        boolean r112 = true;
    L52:
        if (r112 == false) goto L62;
        String r113 = r100.getToolType();
        if (r113 != null) goto L56;
    L59:
        boolean r114 = true;
    L60:
        if (r114 == false) goto L62;
        return true;
    L56:
        if (r113.length() == 0) goto L59;
        r114 = false;
        goto L60
    L48:
        if (r111.length() == 0) goto L51;
        r112 = false;
        goto L52
    L40:
        if (r109.length() == 0) goto L43;
        r110 = false;
        goto L44
    L32:
        if (r107.length() == 0) goto L35;
        r108 = false;
        goto L36
    L24:
        if (r105.isEmpty() == true) goto L27;
        r106 = false;
        goto L28
    L16:
        if (r103.isEmpty() == true) goto L19;
        r104 = false;
    L62:
        return false;
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
        goto L12
    }

    public static final boolean b(SearchReferenceData r100) {
        if (r100 == null) goto L11;
        Integer r101 = r100.getStage();
        int r102 = Stage.Searched.getValue();
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.intValue() != r102) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    public static final boolean c(SearchReferenceData r100) {
        if (r100 == null) goto L11;
        Integer r101 = r100.getStage();
        int r102 = Stage.Searching.getValue();
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.intValue() != r102) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    public static final boolean d(ToolType r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100 != ToolType.SearchPlugin) goto L5;
    L18:
        return true;
    L5:
        if (r100 == ToolType.ScholarSearch) goto L18;
        if (r100 == ToolType.ImageAnalysis) goto L18;
        if (r100 == ToolType.SearchImage) goto L18;
        if (r100 == ToolType.TextSearchImage) goto L18;
        if (r100 == ToolType.CodeRunning) goto L18;
        if (r100 == ToolType.BrowserControl) goto L18;
        return false;
    }
}
