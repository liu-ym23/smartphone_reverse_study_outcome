package org.threeten.bp.format;

import java.text.DateFormatSymbols;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;

/* JADX INFO: loaded from: classes41.dex */
public final class h extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f526434c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentMap<Map.Entry<org.threeten.bp.temporal.f, Locale>, Object> f526435b;

    public static class a implements Comparator<Map.Entry<String, Long>> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Map.Entry<String, Long> r100, Map.Entry<String, Long> r101) {
            return r101.getKey().length() - r100.getKey().length();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<TextStyle, Map<Long, String>> f526436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<TextStyle, List<Map.Entry<String, Long>>> f526437b;

        public b(Map<TextStyle, Map<Long, String>> r110) {
            this.f526436a = r110;
            HashMap r100 = new HashMap();
            ArrayList r101 = new ArrayList();
            Iterator<TextStyle> r102 = r110.keySet().iterator();
        L4:
            if (r102.hasNext() == false) goto L10;
            TextStyle r103 = r102.next();
            HashMap r104 = new HashMap();
            Iterator<Map.Entry<Long, String>> r105 = r110.get(r103).entrySet().iterator();
        L7:
            if (r105.hasNext() == false) goto L9;
            Map.Entry<Long, String> r106 = r105.next();
            String r107 = r106.getValue();
            String r108 = r106.getValue();
            Long r109 = r106.getKey();
            a r111 = h.f526434c;
            r104.put(r107, new AbstractMap.SimpleImmutableEntry(r108, r109));
            goto L7
        L9:
            ArrayList r112 = new ArrayList(r104.values());
            Collections.sort(r112, h.f526434c);
            r100.put(r103, r112);
            r101.addAll(r112);
            r100.put(null, r101);
            goto L4
        L10:
            Collections.sort(r101, h.f526434c);
            this.f526437b = r100;
        }
    }

    static {
        f526434c = new a();
    }

    public h() {
        this.f526435b = new ConcurrentHashMap(16, 0.75f, 2);
    }

    public static b c(Map<TextStyle, Map<Long, String>> r100) {
        HashMap r101 = (HashMap) r100;
        r101.put(TextStyle.FULL_STANDALONE, r101.get(TextStyle.FULL));
        r101.put(TextStyle.SHORT_STANDALONE, r101.get(TextStyle.SHORT));
        TextStyle r102 = TextStyle.NARROW;
        if (r101.containsKey(r102) == false) goto L8;
        TextStyle r103 = TextStyle.NARROW_STANDALONE;
        if (r101.containsKey(r103) == true) goto L8;
        r101.put(r103, r101.get(r102));
    L8:
        return new b(r100);
    }

    public final Object d(org.threeten.bp.temporal.f r210, Locale r211) {
        AbstractMap.SimpleImmutableEntry r100 = new AbstractMap.SimpleImmutableEntry(r210, r211);
        Object r101 = ((ConcurrentHashMap) this.f526435b).get(r100);
        if (r101 != null) goto L26;
        if (r210 != ChronoField.MONTH_OF_YEAR) goto L7;
        DateFormatSymbols r102 = DateFormatSymbols.getInstance(r211);
        HashMap r103 = new HashMap();
        String[] r110 = r102.getMonths();
        AbstractMap.SimpleImmutableEntry r111 = r100;
        HashMap r104 = new HashMap();
        r104.put(1L, r110[0]);
        r104.put(2L, r110[1]);
        r104.put(3L, r110[2]);
        r104.put(4L, r110[3]);
        r104.put(5L, r110[4]);
        r104.put(6L, r110[5]);
        r104.put(7L, r110[6]);
        r104.put(8L, r110[7]);
        r104.put(9L, r110[8]);
        r104.put(10L, r110[9]);
        r104.put(11L, r110[10]);
        r104.put(12L, r110[11]);
        r103.put(TextStyle.FULL, r104);
        HashMap r105 = new HashMap();
        r105.put(1L, r110[0].substring(0, 1));
        r105.put(2L, r110[1].substring(0, 1));
        r105.put(3L, r110[2].substring(0, 1));
        r105.put(4L, r110[3].substring(0, 1));
        r105.put(5L, r110[4].substring(0, 1));
        r105.put(6L, r110[5].substring(0, 1));
        r105.put(7L, r110[6].substring(0, 1));
        r105.put(8L, r110[7].substring(0, 1));
        r105.put(9L, r110[8].substring(0, 1));
        r105.put(10L, r110[9].substring(0, 1));
        r105.put(11L, r110[10].substring(0, 1));
        r105.put(12L, r110[11].substring(0, 1));
        r103.put(TextStyle.NARROW, r105);
        String[] r106 = r102.getShortMonths();
        HashMap r107 = new HashMap();
        r107.put(1L, r106[0]);
        r107.put(2L, r106[1]);
        r107.put(3L, r106[2]);
        r107.put(4L, r106[3]);
        r107.put(5L, r106[4]);
        r107.put(6L, r106[5]);
        r107.put(7L, r106[6]);
        r107.put(8L, r106[7]);
        r107.put(9L, r106[8]);
        r107.put(10L, r106[9]);
        r107.put(11L, r106[10]);
        r107.put(12L, r106[11]);
        r103.put(TextStyle.SHORT, r107);
        Object r108 = c(r103);
    L24:
        AbstractMap.SimpleImmutableEntry r109 = r111;
        ((ConcurrentHashMap) this.f526435b).putIfAbsent(r109, r108);
        return ((ConcurrentHashMap) this.f526435b).get(r109);
    L7:
        r111 = r100;
        if (r210 != ChronoField.DAY_OF_WEEK) goto L11;
        DateFormatSymbols r112 = DateFormatSymbols.getInstance(r211);
        HashMap r113 = new HashMap();
        String[] r114 = r112.getWeekdays();
        HashMap r115 = new HashMap();
        r115.put(1L, r114[2]);
        r115.put(2L, r114[3]);
        r115.put(3L, r114[4]);
        r115.put(4L, r114[5]);
        r115.put(5L, r114[6]);
        r115.put(6L, r114[7]);
        r115.put(7L, r114[1]);
        r113.put(TextStyle.FULL, r115);
        HashMap r116 = new HashMap();
        r116.put(1L, r114[2].substring(0, 1));
        r116.put(2L, r114[3].substring(0, 1));
        r116.put(3L, r114[4].substring(0, 1));
        r116.put(4L, r114[5].substring(0, 1));
        r116.put(5L, r114[6].substring(0, 1));
        r116.put(6L, r114[7].substring(0, 1));
        r116.put(7L, r114[1].substring(0, 1));
        r113.put(TextStyle.NARROW, r116);
        String[] r117 = r112.getShortWeekdays();
        HashMap r118 = new HashMap();
        r118.put(1L, r117[2]);
        r118.put(2L, r117[3]);
        r118.put(3L, r117[4]);
        r118.put(4L, r117[5]);
        r118.put(5L, r117[6]);
        r118.put(6L, r117[7]);
        r118.put(7L, r117[1]);
        r113.put(TextStyle.SHORT, r118);
        r108 = c(r113);
        goto L24
    L11:
        if (r210 != ChronoField.AMPM_OF_DAY) goto L14;
        DateFormatSymbols r119 = DateFormatSymbols.getInstance(r211);
        HashMap r120 = new HashMap();
        String[] r121 = r119.getAmPmStrings();
        HashMap r122 = new HashMap();
        r122.put(0L, r121[0]);
        r122.put(1L, r121[1]);
        r120.put(TextStyle.FULL, r122);
        r120.put(TextStyle.SHORT, r122);
        r108 = c(r120);
        goto L24
    L14:
        if (r210 != ChronoField.ERA) goto L21;
        DateFormatSymbols r123 = DateFormatSymbols.getInstance(r211);
        HashMap r124 = new HashMap();
        String[] r125 = r123.getEras();
        HashMap r126 = new HashMap();
        r126.put(0L, r125[0]);
        r126.put(1L, r125[1]);
        r124.put(TextStyle.SHORT, r126);
        if (r211.getLanguage().equals(Locale.ENGLISH.getLanguage()) == false) goto L18;
        HashMap r127 = new HashMap();
        r127.put(0L, "Before Christ");
        r127.put(1L, "Anno Domini");
        r124.put(TextStyle.FULL, r127);
    L19:
        HashMap r128 = new HashMap();
        r128.put(0L, r125[0].substring(0, 1));
        r128.put(1L, r125[1].substring(0, 1));
        r124.put(TextStyle.NARROW, r128);
        r108 = c(r124);
        goto L24
    L18:
        r124.put(TextStyle.FULL, r126);
        goto L19
    L21:
        if (r210 != IsoFields.f526440a) goto L23;
        HashMap r129 = new HashMap();
        HashMap r130 = new HashMap();
        r130.put(1L, "Q1");
        r130.put(2L, "Q2");
        r130.put(3L, "Q3");
        r130.put(4L, "Q4");
        r129.put(TextStyle.SHORT, r130);
        HashMap r131 = new HashMap();
        r131.put(1L, "1st quarter");
        r131.put(2L, "2nd quarter");
        r131.put(3L, "3rd quarter");
        r131.put(4L, "4th quarter");
        r129.put(TextStyle.FULL, r131);
        r108 = c(r129);
        goto L24
    L23:
        r108 = "";
        goto L24
    L26:
        return r101;
    }

    @Override // org.threeten.bp.format.f
    public final Iterator<Map.Entry<String, Long>> b(org.threeten.bp.temporal.f r100, TextStyle r101, Locale r102) {
        Object r103 = d(r100, r102);
        if ((r103 instanceof b) == false) goto L8;
        List r104 = (List) ((HashMap) ((b) r103).f526437b).get(r101);
        if (r104 != null) goto L7;
        return null;
    L7:
        return r104.iterator();
    L8:
        return null;
    }

    @Override // org.threeten.bp.format.f
    public final String a(org.threeten.bp.temporal.f r100, long r101, TextStyle r102, Locale r103) {
        Object r104 = d(r100, r103);
        if ((r104 instanceof b) == false) goto L8;
        Map<Long, String> r105 = ((b) r104).f526436a.get(r102);
        if (r105 != null) goto L7;
        return null;
    L7:
        return r105.get(Long.valueOf(r101));
    L8:
        return null;
    }
}
