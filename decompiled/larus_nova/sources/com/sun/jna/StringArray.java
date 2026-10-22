package com.sun.jna;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class StringArray extends Memory implements Function.PostCallRead {
    private String encoding;
    private List<NativeString> natives;
    private Object[] original;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object[]] */
    @Override // com.sun.jna.Function.PostCallRead
    public void read() {
        boolean r100 = this.original instanceof WString[];
        boolean r101 = "--WIDE-STRING--".equals(this.encoding);
        int r102 = 0;
    L4:
        if (r102 >= this.original.length) goto L15;
        Pointer r103 = getPointer(Native.POINTER_SIZE * r102);
        if (r103 != null) goto L8;
        ?? r104 = 0;
    L14:
        this.original[r102] = r104;
        r102 = r102 + 1;
        goto L4
    L8:
        if (r101 == false) goto L10;
        r104 = r103.getWideString(0);
    L11:
        if (r100 == false) goto L14;
        r104 = new WString(r104);
        goto L14
    L10:
        r104 = r103.getString(0, this.encoding);
        goto L11
    }

    @Override // com.sun.jna.Memory, com.sun.jna.Pointer
    public String toString() {
        if ("--WIDE-STRING--".equals(this.encoding) == false) goto L5;
        String r100 = "const wchar_t*[]";
    L7:
        return r100 + Arrays.asList(this.original);
    L5:
        r100 = "const char*[]";
        goto L7
    }

    public StringArray(WString[] r100) {
        this(r100, "--WIDE-STRING--");
    }

    public StringArray(String[] r100) {
        this(r100, false);
    }

    private StringArray(Object[] r100, String r101) {
        super((r100.length + 1) * Native.POINTER_SIZE);
        this.natives = new ArrayList();
        this.original = r100;
        this.encoding = r101;
        int r102 = 0;
    L3:
        Pointer r103 = null;
        if (r102 >= r100.length) goto L9;
        Object r104 = r100[r102];
        if (r104 == null) goto L8;
        NativeString r105 = new NativeString(r104.toString(), r101);
        this.natives.add(r105);
        r103 = r105.getPointer();
    L8:
        setPointer(Native.POINTER_SIZE * r102, r103);
        r102 = r102 + 1;
        goto L3
    L9:
        setPointer(Native.POINTER_SIZE * r100.length, null);
    }

    public StringArray(String[] r100, boolean r101) {
        if (r101 == false) goto L4;
        String r102 = "--WIDE-STRING--";
    L5:
        this(r100, r102);
        return;
    L4:
        r102 = Native.getDefaultStringEncoding();
        goto L5
    }

    public StringArray(String[] r100, String r101) {
        this(r100, r101);
    }
}
