package com.ss.android.lark.utils;

import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes38.dex */
public final class k0 implements InvocationHandler {
    public k0() {
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r100, Method r101, Object[] r102) throws Throwable {
        String r103 = r101.getReturnType().getSimpleName();
        if (r103.equals("String") == false) goto L5;
        return "";
    L5:
        if (r103.equals(ItemStyle.ITEM_STYLE_DOUBLE) == true) goto L43;
        if (r103.equals("Integer") == true) goto L43;
        if (r103.equals("Map") == true) goto L41;
        if (r103.equals("Set") == true) goto L39;
        if (r103.equals("int") == true) goto L43;
        if (r103.equals("List") == true) goto L37;
        if (r103.equals("Long") == true) goto L43;
        if (r103.equals("long") == true) goto L43;
        if (r103.equals("boolean") == true) goto L35;
        if (r103.equals("Float") == true) goto L43;
        if (r103.equals("float") == true) goto L43;
        if (r103.equals("Collection") == true) goto L37;
        if (r103.equals("Boolean") == true) goto L35;
        if (r103.equals("Double") == true) goto L43;
        return null;
    L35:
        return Boolean.FALSE;
    L37:
        return new ArrayList();
    L39:
        return new HashSet();
    L41:
        return new HashMap();
    L43:
        return 0;
    }
}
