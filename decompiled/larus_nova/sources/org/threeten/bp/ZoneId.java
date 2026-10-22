package org.threeten.bp;

import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Marker;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.f;
import org.threeten.bp.temporal.g;
import org.threeten.bp.temporal.h;
import org.threeten.bp.zone.ZoneRules;
import org.threeten.bp.zone.ZoneRulesException;
import org.threeten.bp.zone.d;
import zwc.c;

/* JADX INFO: loaded from: classes41.dex */
public abstract class ZoneId implements Serializable {
    public static final h<ZoneId> FROM = null;
    public static final Map<String, String> SHORT_IDS = null;
    private static final long serialVersionUID = 8352817235686L;

    public static class a implements h<ZoneId> {
        public a() {
        }

        @Override // org.threeten.bp.temporal.h
        public final ZoneId a(org.threeten.bp.temporal.b r100) {
            return ZoneId.from(r100);
        }
    }

    public class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ZoneId f526265a;

        @Override // org.threeten.bp.temporal.b
        public final boolean isSupported(f r100) {
            return false;
        }

        public b(ZoneId r100) {
            this.f526265a = r100;
        }

        @Override // org.threeten.bp.temporal.b
        public final long getLong(f r100) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + r100);
        }

        @Override // zwc.c, org.threeten.bp.temporal.b
        public <R> R query(h<R> r100) {
            if (r100 != g.f526468a) goto L7;
            return (R) this.f526265a;
        L7:
            return (R) super.query(r100);
        }
    }

    public abstract String getId();

    public abstract ZoneRules getRules();

    abstract void write(DataOutput r100) throws IOException;

    static {
        FROM = new a();
        HashMap r100 = new HashMap();
        r100.put("ACT", "Australia/Darwin");
        r100.put("AET", "Australia/Sydney");
        r100.put("AGT", "America/Argentina/Buenos_Aires");
        r100.put("ART", "Africa/Cairo");
        r100.put("AST", "America/Anchorage");
        r100.put("BET", "America/Sao_Paulo");
        r100.put("BST", "Asia/Dhaka");
        r100.put("CAT", "Africa/Harare");
        r100.put("CNT", "America/St_Johns");
        r100.put("CST", "America/Chicago");
        r100.put("CTT", "Asia/Shanghai");
        r100.put("EAT", "Africa/Addis_Ababa");
        r100.put("ECT", "Europe/Paris");
        r100.put("IET", "America/Indiana/Indianapolis");
        r100.put("IST", "Asia/Kolkata");
        r100.put("JST", "Asia/Tokyo");
        r100.put("MIT", "Pacific/Apia");
        r100.put("NET", "Asia/Yerevan");
        r100.put("NST", "Pacific/Auckland");
        r100.put("PLT", "Asia/Karachi");
        r100.put("PNT", "America/Phoenix");
        r100.put("PRT", "America/Puerto_Rico");
        r100.put("PST", "America/Los_Angeles");
        r100.put("SST", "Pacific/Guadalcanal");
        r100.put("VST", "Asia/Ho_Chi_Minh");
        r100.put("EST", "-05:00");
        r100.put("MST", "-07:00");
        r100.put("HST", "-10:00");
        SHORT_IDS = Collections.unmodifiableMap(r100);
    }

    public static Set<String> getAvailableZoneIds() {
        return new HashSet(Collections.unmodifiableSet(((ConcurrentHashMap) d.f526487b).keySet()));
    }

    public ZoneId() {
        if (getClass() != ZoneOffset.class) goto L5;
        return;
    L5:
        if (getClass() != ZoneRegion.class) goto L8;
        return;
    L8:
        throw new AssertionError("Invalid subclass");
    }

    public static ZoneId systemDefault() {
        return of(TimeZone.getDefault().getID(), SHORT_IDS);
    }

    public int hashCode() {
        return getId().hashCode();
    }

    public ZoneId normalized() {
        ZoneRules r100 = getRules();     // Catch: ZoneRulesException -> L7
        if (r100.isFixedOffset() == false) goto L6;
        return r100.getOffset(Instant.EPOCH);
    L6:
        return this;
    }

    public String toString() {
        return getId();
    }

    public static ZoneId from(org.threeten.bp.temporal.b r100) {
        ZoneId r101 = (ZoneId) r100.query(g.f526471d);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new DateTimeException("Unable to obtain ZoneId from TemporalAccessor: " + r100 + ", type " + r100.getClass().getName());
    }

    public static ZoneId of(String r100) {
        zwc.d.d(r100, "zoneId");
        if (r100.equals("Z") == false) goto L7;
        return ZoneOffset.UTC;
    L7:
        if (r100.length() == 1) goto L53;
        if (r100.startsWith(Marker.ANY_NON_NULL_MARKER) == true) goto L51;
        if (r100.startsWith("-") == true) goto L51;
        if (r100.equals("UTC") == true) goto L49;
        if (r100.equals("GMT") == true) goto L49;
        if (r100.equals("UT") == true) goto L49;
        if (r100.startsWith("UTC+") == false) goto L23;
    L42:
        ZoneOffset r101 = ZoneOffset.of(r100.substring(3));
        if (r101.getTotalSeconds() != 0) goto L47;
        return new ZoneRegion(r100.substring(0, 3), r101.getRules());
    L47:
        return new ZoneRegion(r100.substring(0, 3) + r101.getId(), r101.getRules());
    L23:
        if (r100.startsWith("GMT+") == true) goto L42;
        if (r100.startsWith("UTC-") == true) goto L42;
        if (r100.startsWith("GMT-") == true) goto L42;
        if (r100.startsWith("UT+") == false) goto L32;
    L36:
        ZoneOffset r102 = ZoneOffset.of(r100.substring(2));
        if (r102.getTotalSeconds() != 0) goto L41;
        return new ZoneRegion("UT", r102.getRules());
    L41:
        return new ZoneRegion("UT" + r102.getId(), r102.getRules());
    L32:
        if (r100.startsWith("UT-") == true) goto L36;
        return ZoneRegion.ofId(r100, true);
    L49:
        return new ZoneRegion(r100, ZoneOffset.UTC.getRules());
    L51:
        return ZoneOffset.of(r100);
    L53:
        throw new DateTimeException("Invalid zone: ".concat(r100));
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ZoneId) == true) goto L8;
        return false;
    L8:
        return getId().equals(((ZoneId) r100).getId());
    }

    public static ZoneId of(String r100, Map<String, String> r101) {
        zwc.d.d(r100, "zoneId");
        zwc.d.d(r101, "aliasMap");
        String r102 = r101.get(r100);
        if (r102 == null) goto L6;
        r100 = r102;
    L6:
        return of(r100);
    }

    public static ZoneId ofOffset(String r100, ZoneOffset r101) {
        zwc.d.d(r100, "prefix");
        zwc.d.d(r101, "offset");
        if (r100.length() != 0) goto L6;
        return r101;
    L6:
        if (r100.equals("GMT") == true) goto L15;
        if (r100.equals("UTC") == true) goto L15;
        if (r100.equals("UT") == true) goto L15;
        throw new IllegalArgumentException("Invalid prefix, must be GMT, UTC or UT: ".concat(r100));
    L15:
        if (r101.getTotalSeconds() != 0) goto L19;
        return new ZoneRegion(r100, r101.getRules());
    L19:
        return new ZoneRegion(r100 + r101.getId(), r101.getRules());
    }

    public String getDisplayName(TextStyle r100, Locale r101) {
        DateTimeFormatterBuilder r102 = new DateTimeFormatterBuilder();
        r102.b(new DateTimeFormatterBuilder.s(r100));
        return r102.q(r101).a(new b(this));
    }
}
