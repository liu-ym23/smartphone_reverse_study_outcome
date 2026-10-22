package okhttp3;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class Headers {
    private final String[] namesAndValues;

    public static final class Builder {
        final List<String> namesAndValues;

        public Headers build() {
            return new Headers(this);
        }

        public Builder() {
            this.namesAndValues = new ArrayList(20);
        }

        public Builder add(String r100) {
            int r101 = r100.indexOf(":");
            if (r101 == (-1)) goto L7;
            return add(r100.substring(0, r101).trim(), r100.substring(r101 + 1));
        L7:
            throw new IllegalArgumentException("Unexpected header: ".concat(r100));
        }

        public Builder addAll(Headers r100) {
            int r101 = r100.size();
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L5;
            addLenient(r100.name(r102), r100.value(r102));
            r102 = r102 + 1;
            goto L3
        L5:
            return this;
        }

        public Builder addLenient(String r100) {
            int r101 = r100.indexOf(":", 1);
            if (r101 == (-1)) goto L7;
            return addLenient(r100.substring(0, r101), r100.substring(r101 + 1));
        L7:
            if (r100.startsWith(":") == false) goto L11;
            return addLenient("", r100.substring(1));
        L11:
            return addLenient("", r100);
        }

        public String get(String r100) {
            int r101 = this.namesAndValues.size() - 2;
        L3:
            if (r101 < 0) goto L9;
            if (r100.equalsIgnoreCase((String) ListProtector.get(this.namesAndValues, r101)) == true) goto L7;
            r101 = r101 - 2;
            goto L3
        L7:
            return (String) ListProtector.get(this.namesAndValues, r101 + 1);
        L9:
            return null;
        }

        public Builder removeAll(String r100) {
            int r101 = 0;
        L4:
            if (r101 >= this.namesAndValues.size()) goto L9;
            if (r100.equalsIgnoreCase((String) ListProtector.get(this.namesAndValues, r101)) == false) goto L8;
            ListProtector.remove(this.namesAndValues, r101);
            ListProtector.remove(this.namesAndValues, r101);
            r101 = r101 - 2;
        L8:
            r101 = r101 + 2;
            goto L4
        L9:
            return this;
        }

        public Builder add(String r100, Date r101) {
            if (r101 == null) goto L6;
            add(r100, evc.d.f474506a.get().format(r101));
            return this;
        L6:
            throw new NullPointerException("value for name " + r100 + " == null");
        }

        public Builder addLenient(String r100, String r101) {
            this.namesAndValues.add(r100);
            this.namesAndValues.add(r101.trim());
            return this;
        }

        public Builder addUnsafeNonAscii(String r100, String r101) {
            Headers.checkName(r100);
            return addLenient(r100, r101);
        }

        public Builder set(String r100, Date r101) {
            if (r101 == null) goto L6;
            set(r100, evc.d.f474506a.get().format(r101));
            return this;
        L6:
            throw new NullPointerException("value for name " + r100 + " == null");
        }

        public Builder add(String r100, String r101) {
            Headers.checkName(r100);
            Headers.checkValue(r101, r100);
            return addLenient(r100, r101);
        }

        public Builder set(String r100, String r101) {
            Headers.checkName(r100);
            Headers.checkValue(r101, r100);
            removeAll(r100);
            addLenient(r100, r101);
            return this;
        }
    }

    public long byteCount() {
        String[] r100 = this.namesAndValues;
        long r101 = r100.length * 2;
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101 = r101 + ((long) this.namesAndValues[r103].length());
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    public Set<String> names() {
        TreeSet r100 = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int r101 = size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L6;
        r100.add(name(r102));
        r102 = r102 + 1;
        goto L3
    L6:
        return Collections.unmodifiableSet(r100);
    }

    public Builder newBuilder() {
        Builder r100 = new Builder();
        Collections.addAll(r100.namesAndValues, this.namesAndValues);
        return r100;
    }

    public int size() {
        return this.namesAndValues.length / 2;
    }

    public Map<String, List<String>> toMultimap() {
        TreeMap r100 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int r101 = size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        String r103 = name(r102).toLowerCase(Locale.US);
        List r104 = (List) r100.get(r103);
        if (r104 != null) goto L7;
        r104 = new ArrayList(2);
        r100.put(r103, r104);
    L7:
        r104.add(value(r102));
        r102 = r102 + 1;
        goto L3
    L8:
        return r100;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        int r101 = size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L6;
        r100.append(name(r102));
        r100.append(": ");
        r100.append(value(r102));
        r100.append("\n");
        r102 = r102 + 1;
        goto L3
    L6:
        return r100.toString();
    }

    public Headers(Builder r100) {
        List<String> r101 = r100.namesAndValues;
        this.namesAndValues = (String[]) r101.toArray(new String[r101.size()]);
    }

    public static void checkName(String r100) {
        if (r100 == null) goto L18;
        if (r100.isEmpty() == true) goto L16;
        int r101 = r100.length();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L14;
        char r103 = r100.charAt(r102);
        if (r103 <= ' ') goto L13;
        if (r103 >= 127) goto L13;
        r102 = r102 + 1;
    L13:
        throw new IllegalArgumentException(cvc.c.l("Unexpected char %#04x at %d in header name: %s", new Object[]{Integer.valueOf(r103), Integer.valueOf(r102), r100}));
    L14:
        return;
    L16:
        throw new IllegalArgumentException("name is empty");
    L18:
        throw new NullPointerException("name == null");
    }

    public static Headers of(Map<String, String> r100) {
        if (r100 == null) goto L16;
        String[] r101 = new String[r100.size() * 2];
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
        int r103 = 0;
    L5:
        if (r102.hasNext() == false) goto L14;
        Map.Entry<String, String> r104 = r102.next();
        if (r104.getKey() == null) goto L12;
        if (r104.getValue() == null) goto L12;
        String r105 = r104.getKey().trim();
        String r106 = r104.getValue().trim();
        checkName(r105);
        checkValue(r106, r105);
        r101[r103] = r105;
        r101[r103 + 1] = r106;
        r103 = r103 + 2;
    L12:
        throw new IllegalArgumentException("Headers cannot be null");
    L14:
        return new Headers(r101);
    L16:
        throw new NullPointerException("headers == null");
    }

    public boolean equals(@Nullable Object r100) {
        if ((r100 instanceof Headers) == true) goto L5;
    L7:
        return false;
    L5:
        if (Arrays.equals(((Headers) r100).namesAndValues, this.namesAndValues) == false) goto L7;
        return true;
    }

    @Nullable
    public String get(String r100) {
        return get(this.namesAndValues, r100);
    }

    @Nullable
    public Date getDate(String r100) {
        String r101 = get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return evc.d.a(r101);
    }

    public String name(int r100) {
        return this.namesAndValues[r100 * 2];
    }

    public String value(int r100) {
        return this.namesAndValues[(r100 * 2) + 1];
    }

    public List<String> values(String r100) {
        int r101 = size();
        ArrayList r102 = null;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L10;
        if (r100.equalsIgnoreCase(name(r103)) == false) goto L9;
        if (r102 != null) goto L8;
        r102 = new ArrayList(2);
    L8:
        r102.add(value(r103));
    L9:
        r103 = r103 + 1;
        goto L3
    L10:
        if (r102 == null) goto L13;
        return Collections.unmodifiableList(r102);
    L13:
        return Collections.emptyList();
    }

    private Headers(String[] r100) {
        this.namesAndValues = r100;
    }

    public static Headers of(String... r100) {
        if (r100 == null) goto L21;
        if ((r100.length % 2) != 0) goto L19;
        String[] r101 = (String[]) r100.clone();
        int r102 = 0;
        int r103 = 0;
    L7:
        if (r103 >= r101.length) goto L14;
        String r104 = r101[r103];
        if (r104 == null) goto L12;
        r101[r103] = r104.trim();
        r103 = r103 + 1;
        goto L7
    L12:
        throw new IllegalArgumentException("Headers cannot be null");
    L14:
        if (r102 >= r101.length) goto L17;
        String r105 = r101[r102];
        String r106 = r101[r102 + 1];
        checkName(r105);
        checkValue(r106, r105);
        r102 = r102 + 2;
        goto L14
    L17:
        return new Headers(r101);
    L19:
        throw new IllegalArgumentException("Expected alternating header names and values");
    L21:
        throw new NullPointerException("namesAndValues == null");
    }

    public static void checkValue(String r100, String r101) {
        if (r100 == null) goto L16;
        int r102 = r100.length();
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L14;
        char r104 = r100.charAt(r103);
        if (r104 > 31) goto L10;
        if (r104 == '\t') goto L10;
    L13:
        throw new IllegalArgumentException(cvc.c.l("Unexpected char %#04x at %d in %s value: %s", new Object[]{Integer.valueOf(r104), Integer.valueOf(r103), r101, r100}));
    L10:
        if (r104 >= 127) goto L13;
        r103 = r103 + 1;
        goto L4
    L14:
        return;
    L16:
        throw new NullPointerException("value for name " + r101 + " == null");
    }

    private static String get(String[] r100, String r101) {
        int r102 = r100.length - 2;
    L3:
        if (r102 < 0) goto L9;
        if (r101.equalsIgnoreCase(r100[r102]) == true) goto L7;
        r102 = r102 - 2;
        goto L3
    L7:
        return r100[r102 + 1];
    L9:
        return null;
    }
}
