package org.threeten.bp.zone;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StreamCorruptedException;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes41.dex */
public final class a extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<String> f526477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentNavigableMap<String, C7102a> f526478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f526479e;

    /* JADX INFO: renamed from: org.threeten.bp.zone.a$a, reason: collision with other inner class name */
    public static class C7102a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f526480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String[] f526481b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final short[] f526482c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReferenceArray<Object> f526483d;

        public final String toString() {
            return this.f526480a;
        }

        public C7102a(String r100, String[] r101, short[] r102, AtomicReferenceArray<Object> r103) {
            this.f526483d = r103;
            this.f526480a = r100;
            this.f526481b = r101;
            this.f526482c = r102;
        }
    }

    public final String toString() {
        return "TZDB";
    }

    @Override // org.threeten.bp.zone.d
    public Set<String> c() {
        return new HashSet(this.f526477c);
    }

    public a() {
        this.f526478d = new ConcurrentSkipListMap();
        this.f526479e = new CopyOnWriteArraySet();
        Object r100 = null;
        InputStream r101 = null;
        Enumeration<URL> r102 = d.class.getClassLoader().getResources("org/threeten/bp/TZDB.dat");     // Catch: Exception -> L31
        Object r103 = null;
        boolean r104 = false;
    L42:
    L29:
        e = e;
        r100 = r103;
    L33:
        throw new ZoneRulesException("Unable to load TZDB time-zone rules: " + r100, e);
    L6:
        if (r102.hasMoreElements() == false) goto L25;
        URL r105 = r102.nextElement();     // Catch: Exception -> L29
    L23:
        e = e;
        r100 = r105;
        goto L33
    L9:
        if (this.f526479e.add(r105.toExternalForm()) == true) goto L40;
        boolean r106 = false;
    L22:
        r104 = r104 | r106;
        r103 = r105;
        goto L42
    L40:
        InputStream r107 = r105.openStream();     // Catch: Throwable -> L17
        r106 = e(r107) | false;
        if (r107 == null) goto L22;
        r107.close();     // Catch: Exception -> L23
    L15:
        th = th;
        r101 = r107;
    L18:
        if (r101 == null) goto L20;
        r101.close();     // Catch: Exception -> L23
    L20:
        throw th;     // Catch: Exception -> L23
    L17:
        th = th;
        goto L18
    L25:
        if (r104 == false) goto L28;
        return;
    L28:
        throw new ZoneRulesException("No time-zone rules found for 'TZDB'");
    L31:
        e = e;
        goto L33
    }

    public a(InputStream r100) {
        this.f526478d = new ConcurrentSkipListMap();
        this.f526479e = new CopyOnWriteArraySet();
        e(r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        throw new ZoneRulesException("Unable to load TZDB time-zone rules", e);
    }

    public final boolean e(InputStream r110) throws IOException, StreamCorruptedException {
        DataInputStream r100 = new DataInputStream(r110);
        if (r100.readByte() != 1) goto L36;
        if ("TZDB".equals(r100.readUTF()) == false) goto L34;
        int r111 = r100.readShort();
        String[] r101 = new String[r111];
        boolean r102 = false;
        int r103 = 0;
    L7:
        if (r103 >= r111) goto L9;
        r101[r103] = r100.readUTF();
        r103 = r103 + 1;
        goto L7
    L9:
        int r104 = r100.readShort();
        String[] r105 = new String[r104];
        int r106 = 0;
    L10:
        if (r106 >= r104) goto L12;
        r105[r106] = r100.readUTF();
        r106 = r106 + 1;
        goto L10
    L12:
        this.f526477c = Arrays.asList(r105);
        int r107 = r100.readShort();
        Object[] r108 = new Object[r107];
        int r109 = 0;
    L13:
        if (r109 >= r107) goto L15;
        byte[] r112 = new byte[r100.readShort()];
        r100.readFully(r112);
        r108[r109] = r112;
        r109 = r109 + 1;
        goto L13
    L15:
        AtomicReferenceArray r113 = new AtomicReferenceArray(r108);
        HashSet r114 = new HashSet(r111);
        int r115 = 0;
    L16:
        if (r115 >= r111) goto L21;
        int r116 = r100.readShort();
        String[] r117 = new String[r116];
        short[] r118 = new short[r116];
        int r119 = 0;
    L18:
        if (r119 >= r116) goto L20;
        r117[r119] = r105[r100.readShort()];
        r118[r119] = r100.readShort();
        r119 = r119 + 1;
        goto L18
    L20:
        r114.add(new C7102a(r101[r115], r117, r118, r113));
        r115 = r115 + 1;
        goto L16
    L21:
        Iterator r120 = r114.iterator();
    L23:
        if (r120.hasNext() == false) goto L32;
        C7102a r121 = (C7102a) r120.next();
        C7102a r122 = this.f526478d.putIfAbsent(r121.f526480a, r121);
        if (r122 == null) goto L31;
        if (r122.f526480a.equals(r121.f526480a) == true) goto L31;
        throw new ZoneRulesException("Data already loaded for TZDB time-zone rules version: " + r121.f526480a);
    L31:
        r102 = true;
        goto L23
    L32:
        return r102;
    L34:
        throw new StreamCorruptedException("File format not recognised");
    L36:
        throw new StreamCorruptedException("File format not recognised");
    }

    @Override // org.threeten.bp.zone.d
    public ZoneRules b(String r100, boolean r101) {
        zwc.d.d(r100, "zoneId");
        C7102a r102 = (C7102a) ((ConcurrentSkipListMap) this.f526478d).lastEntry().getValue();
        int r103 = Arrays.binarySearch(r102.f526481b, r100);
        if (r103 >= 0) goto L17;
        ZoneRules r104 = null;
    L10:
        if (r104 == null) goto L13;
        return r104;
    L13:
        throw new ZoneRulesException("Unknown time-zone ID: ".concat(r100));
    L17:
        short r105 = r102.f526482c[r103];     // Catch: Exception -> L14
        Object r106 = r102.f526483d.get(r105);     // Catch: Exception -> L14
        if ((r106 instanceof byte[]) == false) goto L8;
        r106 = Ser.read(new DataInputStream(new ByteArrayInputStream((byte[]) r106)));     // Catch: Exception -> L14
        r102.f526483d.set(r105, r106);     // Catch: Exception -> L14
    L8:
        r104 = (ZoneRules) r106;     // Catch: Exception -> L14
    L14:
        e = move-exception;
        throw new ZoneRulesException("Invalid binary time-zone data: TZDB:" + r100 + ", version: " + r102.f526480a, e);
    }
}
