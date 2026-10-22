package com.xiaomi.push;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes41.dex */
public final class hq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Comparator f464082a = null;

    /* JADX INFO: renamed from: com.xiaomi.push.hq$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class a implements Comparator {
        private a() {
        }

        public /* synthetic */ a(AnonymousClass1 r100) {
            this();
        }

        @Override // java.util.Comparator
        public int compare(Object r100, Object r101) {
            if (r100 != null) goto L6;
            if (r101 != null) goto L6;
            return 0;
        L6:
            if (r100 != null) goto L9;
            return -1;
        L9:
            if (r101 != null) goto L13;
            return 1;
        L13:
            if ((r100 instanceof List) == false) goto L17;
            return hq.a((List) r100, (List) r101);
        L17:
            if ((r100 instanceof Set) == false) goto L21;
            return hq.a((Set) r100, (Set) r101);
        L21:
            if ((r100 instanceof Map) == false) goto L25;
            return hq.a((Map) r100, (Map) r101);
        L25:
            if ((r100 instanceof byte[]) == false) goto L29;
            return hq.a((byte[]) r100, (byte[]) r101);
        L29:
            return hq.a((Comparable) r100, (Comparable) r101);
        }
    }

    public static int a(byte r100, byte r101) {
        if (r100 >= r101) goto L5;
        return -1;
    L5:
        if (r101 >= r100) goto L8;
        return 1;
    L8:
        return 0;
    }

    public static int a(int r100, int r101) {
        if (r100 >= r101) goto L5;
        return -1;
    L5:
        if (r101 >= r100) goto L8;
        return 1;
    L8:
        return 0;
    }

    public static int a(long r100, long r101) {
        if (r100 >= r101) goto L7;
        return -1;
    L7:
        if (r101 >= r100) goto L10;
        return 1;
    L10:
        return 0;
    }

    public static int a(short r100, short r101) {
        if (r100 >= r101) goto L5;
        return -1;
    L5:
        if (r101 >= r100) goto L8;
        return 1;
    L8:
        return 0;
    }

    static {
        f464082a = new a(null);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m9265a(ByteBuffer r100) {
        if (r100.hasArray() == true) goto L5;
    L11:
        return false;
    L5:
        if (r100.position() != 0) goto L11;
        if (r100.arrayOffset() != 0) goto L11;
        if (r100.remaining() != r100.capacity()) goto L11;
        return true;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static byte[] m9266a(ByteBuffer r100) {
        if (m9265a(r100) == true) goto L5;
        byte[] r101 = new byte[r100.remaining()];
        a(r100, r101, 0);
        return r101;
    L5:
        return r100.array();
    }

    public static String a(byte r100) {
        return Integer.toHexString((r100 | 256) & 511).toUpperCase().substring(1);
    }

    public static ByteBuffer a(ByteBuffer r100) {
        if (m9265a(r100) == false) goto L6;
        return r100;
    L6:
        return ByteBuffer.wrap(m9266a(r100));
    }

    public static int a(Map r100, Map r101) {
        int r102 = a(r100.size(), r101.size());
        if (r102 == 0) goto L5;
        return r102;
    L5:
        Comparator r103 = f464082a;
        TreeMap r104 = new TreeMap(r103);
        r104.putAll(r100);
        Iterator r105 = r104.entrySet().iterator();
        TreeMap r106 = new TreeMap(r103);
        r106.putAll(r101);
        Iterator r107 = r106.entrySet().iterator();
    L7:
        if (r105.hasNext() == false) goto L16;
        if (r107.hasNext() == false) goto L23;
        Map.Entry r108 = (Map.Entry) r105.next();
        Map.Entry r109 = (Map.Entry) r107.next();
        Comparator r110 = f464082a;
        int r111 = r110.compare(r108.getKey(), r109.getKey());
        if (r111 != 0) goto L12;
        int r112 = r110.compare(r108.getValue(), r109.getValue());
        if (r112 == 0) goto L7;
        return r112;
    L12:
        return r111;
    L23:
        return 0;
    L16:
        return 0;
    }

    public static int a(Set r100, Set r101) {
        int r102 = a(r100.size(), r101.size());
        if (r102 == 0) goto L5;
        return r102;
    L5:
        Comparator r103 = f464082a;
        TreeSet r104 = new TreeSet(r103);
        r104.addAll(r100);
        TreeSet r105 = new TreeSet(r103);
        r105.addAll(r101);
        Iterator r106 = r104.iterator();
        Iterator r107 = r105.iterator();
    L7:
        if (r106.hasNext() == false) goto L13;
        if (r107.hasNext() == false) goto L19;
        int r108 = f464082a.compare(r106.next(), r107.next());
        if (r108 == 0) goto L7;
        return r108;
    L19:
        return 0;
    L13:
        return 0;
    }

    public static void a(ByteBuffer r100, StringBuilder r101) {
        byte[] r102 = r100.array();
        int r103 = r100.arrayOffset();
        int r104 = r100.limit();
        if ((r104 - r103) <= 128) goto L5;
        int r105 = r103 + 128;
    L6:
        int r106 = r103;
    L7:
        if (r106 >= r105) goto L11;
        if (r106 <= r103) goto L10;
        r101.append(" ");
    L10:
        r101.append(a(r102[r106]));
        r106 = r106 + 1;
        goto L7
    L11:
        if (r104 == r105) goto L17;
        r101.append("...");
        return;
    L17:
        return;
    L5:
        r105 = r104;
        goto L6
    }

    public static int a(List r100, List r101) {
        int r102 = a(r100.size(), r101.size());
        if (r102 == 0) goto L5;
        return r102;
    L5:
        int r103 = 0;
    L7:
        if (r103 >= r100.size()) goto L12;
        int r104 = f464082a.compare(ListProtector.get(r100, r103), ListProtector.get(r101, r103));
        if (r104 != 0) goto L10;
        r103 = r103 + 1;
        goto L7
    L10:
        return r104;
    L12:
        return 0;
    }

    public static int a(byte[] r100, byte[] r101) {
        int r102 = a(r100.length, r101.length);
        if (r102 == 0) goto L5;
        return r102;
    L5:
        int r103 = 0;
    L7:
        if (r103 >= r100.length) goto L12;
        int r104 = a(r100[r103], r101[r103]);
        if (r104 != 0) goto L10;
        r103 = r103 + 1;
        goto L7
    L10:
        return r104;
    L12:
        return 0;
    }

    public static int a(boolean r100, boolean r101) {
        return Boolean.valueOf(r100).compareTo(Boolean.valueOf(r101));
    }

    public static int a(Comparable r100, Comparable r101) {
        return r100.compareTo(r101);
    }

    public static int a(String r100, String r101) {
        return r100.compareTo(r101);
    }

    public static int a(ByteBuffer r100, byte[] r101, int r102) {
        int r103 = r100.remaining();
        System.arraycopy(r100.array(), r100.arrayOffset() + r100.position(), r101, r102, r103);
        return r103;
    }
}
