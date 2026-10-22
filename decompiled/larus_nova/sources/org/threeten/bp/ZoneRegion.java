package org.threeten.bp;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.util.regex.Pattern;
import org.slf4j.Marker;
import org.threeten.bp.zone.ZoneRules;
import org.threeten.bp.zone.ZoneRulesException;
import org.threeten.bp.zone.d;

/* JADX INFO: loaded from: classes41.dex */
final class ZoneRegion extends ZoneId {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f526269b = null;
    private static final long serialVersionUID = 8386373296231747096L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient ZoneRules f526270a;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f526271id;

    static {
        f526269b = PatternProtector.compile("[A-Za-z][A-Za-z0-9~/._+-]+");
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 7, this);
    }

    @Override // org.threeten.bp.ZoneId
    public ZoneRules getRules() {
        ZoneRules r100 = this.f526270a;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return d.a(this.f526271id, false);
    }

    @Override // org.threeten.bp.ZoneId
    public String getId() {
        return this.f526271id;
    }

    public static ZoneId readExternal(DataInput r100) throws IOException {
        String r101 = r100.readUTF();
        if (r101.equals("Z") == true) goto L43;
        if (r101.startsWith(Marker.ANY_NON_NULL_MARKER) == true) goto L43;
        if (r101.startsWith("-") == true) goto L43;
        if (r101.equals("UTC") == true) goto L41;
        if (r101.equals("GMT") == true) goto L41;
        if (r101.equals("UT") == true) goto L41;
        if (r101.startsWith("UTC+") == false) goto L18;
    L35:
        ZoneOffset r102 = ZoneOffset.of(r101.substring(3));
        if (r102.getTotalSeconds() != 0) goto L38;
        ZoneRegion r103 = new ZoneRegion(r101.substring(0, 3), r102.getRules());
    L46:
        return r103;
    L38:
        r103 = new ZoneRegion(r101.substring(0, 3) + r102.getId(), r102.getRules());
        goto L46
    L18:
        if (r101.startsWith("GMT+") == true) goto L35;
        if (r101.startsWith("UTC-") == true) goto L35;
        if (r101.startsWith("GMT-") == true) goto L35;
        if (r101.startsWith("UT+") == false) goto L27;
    L30:
        ZoneOffset r104 = ZoneOffset.of(r101.substring(2));
        if (r104.getTotalSeconds() != 0) goto L33;
        ZoneRegion r105 = new ZoneRegion("UT", r104.getRules());
    L45:
        return r105;
    L33:
        r105 = new ZoneRegion("UT" + r104.getId(), r104.getRules());
        goto L45
    L27:
        if (r101.startsWith("UT-") == true) goto L30;
        return ofId(r101, false);
    L41:
        return new ZoneRegion(r101, ZoneOffset.UTC.getRules());
    L43:
        throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: ".concat(r101));
    }

    @Override // org.threeten.bp.ZoneId
    public void write(DataOutput r100) throws IOException {
        r100.writeByte(7);
        writeExternal(r100);
    }

    public void writeExternal(DataOutput r100) throws IOException {
        r100.writeUTF(this.f526271id);
    }

    public ZoneRegion(String r100, ZoneRules r101) {
        this.f526271id = r100;
        this.f526270a = r101;
    }

    public static ZoneRegion ofId(String r100, boolean r101) {
        zwc.d.d(r100, "zoneId");
        if (r100.length() < 2) goto L19;
        if (f526269b.matcher(r100).matches() == false) goto L19;
        ZoneRules r102 = d.a(r100, true);     // Catch: ZoneRulesException -> L9
    L16:
        return new ZoneRegion(r100, r102);
    L9:
        e = move-exception;
        if (r100.equals("GMT0") == false) goto L13;
        r102 = ZoneOffset.UTC.getRules();
        goto L16
    L13:
        if (r101 == true) goto L17;
        r102 = null;
        goto L16
    L17:
        throw e;
    L19:
        throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: ".concat(r100));
    }
}
