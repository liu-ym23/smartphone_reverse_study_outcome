package org.bouncycastle.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Vector;
import kotlin.UByte;
import org.bouncycastle.util.encoders.UTF8;

/* JADX INFO: loaded from: classes42.dex */
public final class Strings {
    private static String LINE_SEPARATOR;

    public static class StringListImpl extends ArrayList<String> implements StringList {
        private StringListImpl() {
        }

        public /* synthetic */ StringListImpl(AnonymousClass1 r100) {
            this();
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ void add(int r100, Object r101) {
            add(r100, (String) r101);
        }

        public void add(int r100, String r101) {
            super.add(r100, r101);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public /* bridge */ /* synthetic */ boolean add(Object r100) {
            return add((String) r100);
        }

        @Override // org.bouncycastle.util.StringList
        public boolean add(String r100) {
            return super.add(r100);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List, org.bouncycastle.util.StringList
        public /* bridge */ /* synthetic */ String get(int r100) {
            return (String) super.get(r100);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object set(int r100, Object r101) {
            return set(r100, (String) r101);
        }

        public String set(int r100, String r101) {
            return (String) super.set(r100, r101);
        }

        @Override // org.bouncycastle.util.StringList
        public String[] toStringArray() {
            int r100 = size();
            String[] r101 = new String[r100];
            int r102 = 0;
        L3:
            if (r102 == r100) goto L5;
            r101[r102] = get(r102);
            r102 = r102 + 1;
            goto L3
        L5:
            return r101;
        }

        @Override // org.bouncycastle.util.StringList
        public String[] toStringArray(int r100, int r101) {
            String[] r102 = new String[r101 - r100];
            int r103 = r100;
        L4:
            if (r103 == size()) goto L7;
            if (r103 == r101) goto L7;
            r102[r103 - r100] = get(r103);
            r103 = r103 + 1;
        L7:
            return r102;
        }
    }

    static {
        LINE_SEPARATOR = (String) AccessController.doPrivileged(new AnonymousClass1());     // Catch: Exception -> L4
        return;
    L4:
        LINE_SEPARATOR = String.format("%n", new Object[0]);     // Catch: Exception -> L6
        return;
    L6:
        LINE_SEPARATOR = "\n";
    }

    public Strings() {
    }

    public static char[] asCharArray(byte[] r100) {
        int r101 = r100.length;
        char[] r102 = new char[r101];
        int r103 = 0;
    L3:
        if (r103 == r101) goto L5;
        r102[r103] = (char) (r100[r103] & UByte.MAX_VALUE);
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public static String fromByteArray(byte[] r100) {
        return new String(asCharArray(r100));
    }

    public static String fromUTF8ByteArray(byte[] r100) {
        char[] r101 = new char[r100.length];
        int r102 = UTF8.transcodeToUTF16(r100, r101);
        if (r102 < 0) goto L7;
        return new String(r101, 0, r102);
    L7:
        throw new IllegalArgumentException("Invalid UTF-8 input");
    }

    public static String lineSeparator() {
        return LINE_SEPARATOR;
    }

    public static StringList newList() {
        return new StringListImpl(null);
    }

    public static String[] split(String r100, char r101) {
        Vector r102 = new Vector();
        boolean r103 = true;
    L3:
        int r104 = 0;
        if (r103 == false) goto L9;
        int r105 = r100.indexOf(r101);
        if (r105 > 0) goto L7;
        r102.addElement(r100);
        r103 = false;
        goto L3
    L7:
        r102.addElement(r100.substring(0, r105));
        r100 = r100.substring(r105 + 1);
        goto L3
    L9:
        int r106 = r102.size();
        String[] r107 = new String[r106];
    L10:
        if (r104 == r106) goto L12;
        r107[r104] = (String) r102.elementAt(r104);
        r104 = r104 + 1;
        goto L10
    L12:
        return r107;
    }

    public static int toByteArray(String r100, byte[] r101, int r102) {
        int r103 = r100.length();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r101[r102 + r104] = (byte) r100.charAt(r104);
        r104 = r104 + 1;
        goto L3
    L5:
        return r103;
    }

    public static byte[] toByteArray(String r100) {
        int r101 = r100.length();
        byte[] r102 = new byte[r101];
        int r103 = 0;
    L3:
        if (r103 == r101) goto L5;
        r102[r103] = (byte) r100.charAt(r103);
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public static byte[] toByteArray(char[] r100) {
        int r101 = r100.length;
        byte[] r102 = new byte[r101];
        int r103 = 0;
    L3:
        if (r103 == r101) goto L5;
        r102[r103] = (byte) r100[r103];
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public static String toLowerCase(String r100) {
        char[] r101 = r100.toCharArray();
        int r102 = 0;
        boolean r103 = false;
    L4:
        if (r102 == r101.length) goto L11;
        char r104 = r101[r102];
        if ('A' > r104) goto L10;
        if ('Z' < r104) goto L10;
        r101[r102] = (char) ((r104 - 'A') + 97);
        r103 = true;
    L10:
        r102 = r102 + 1;
        goto L4
    L11:
        if (r103 == true) goto L13;
        return r100;
    L13:
        return new String(r101);
    }

    public static void toUTF8ByteArray(char[] r100, OutputStream r101) throws IOException {
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L29;
        char r103 = r100[r102];
        int r104 = r103;
        if (r103 >= 128) goto L9;
    L22:
        r101.write(r104);
        r102 = r102 + 1;
        goto L4
    L9:
        if (r103 >= 2048) goto L13;
        int r105 = (r103 >> 6) | 192;
    L11:
        r101.write(r105);
        int r106 = r103;
    L21:
        r104 = (r106 & 63) | 128;
        goto L22
    L13:
        if (r103 >= 55296) goto L15;
    L27:
        r101.write((r103 >> '\f') | 224);
        r105 = ((r103 >> 6) & 63) | 128;
        goto L11
    L15:
        if (r103 > 57343) goto L27;
        r102 = r102 + 1;
        if (r102 >= r100.length) goto L26;
        char r107 = r100[r102];
        if (r103 > 56319) goto L24;
        int r108 = (((r103 & 1023) << 10) | (r107 & 1023)) + 65536;
        r101.write((r108 >> 18) | 240);
        r101.write(((r108 >> 12) & 63) | 128);
        r101.write(((r108 >> 6) & 63) | 128);
        r106 = r108;
        goto L21
    L24:
        throw new IllegalStateException("invalid UTF-16 codepoint");
    L26:
        throw new IllegalStateException("invalid UTF-16 codepoint");
    }

    public static byte[] toUTF8ByteArray(String r100) {
        return toUTF8ByteArray(r100.toCharArray());
    }

    public static byte[] toUTF8ByteArray(char[] r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        toUTF8ByteArray(r100, r101);     // Catch: IOException -> L6
        return r101.toByteArray();
    L7:
        throw new IllegalStateException("cannot encode string to byte array!");
    }

    public static String toUpperCase(String r100) {
        char[] r101 = r100.toCharArray();
        int r102 = 0;
        boolean r103 = false;
    L4:
        if (r102 == r101.length) goto L11;
        char r104 = r101[r102];
        if ('a' > r104) goto L10;
        if ('z' < r104) goto L10;
        r101[r102] = (char) ((r104 - 'a') + 65);
        r103 = true;
    L10:
        r102 = r102 + 1;
        goto L4
    L11:
        if (r103 == true) goto L13;
        return r100;
    L13:
        return new String(r101);
    }
}
