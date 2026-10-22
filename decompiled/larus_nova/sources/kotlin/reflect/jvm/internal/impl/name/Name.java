package kotlin.reflect.jvm.internal.impl.name;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;

/* JADX INFO: loaded from: classes5.dex */
public final class Name implements Comparable<Name> {
    private final String name;
    private final boolean special;

    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        if (r100 == 1) goto L8;
        if (r100 == 2) goto L8;
        if (r100 == 3) goto L8;
        if (r100 == 4) goto L8;
        String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r100 == 1) goto L14;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L14;
        if (r100 == 4) goto L14;
        int r102 = 3;
    L15:
        Object[] r103 = new Object[r102];
        if (r100 == 1) goto L21;
        if (r100 == 2) goto L21;
        if (r100 == 3) goto L21;
        if (r100 == 4) goto L21;
        r103[0] = "name";
    L22:
        if (r100 == 1) goto L29;
        if (r100 == 2) goto L28;
        if (r100 == 3) goto L27;
        if (r100 == 4) goto L27;
        r103[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
    L30:
        switch(r100) {
            case 1: goto L37;
            case 2: goto L37;
            case 3: goto L37;
            case 4: goto L37;
            case 5: goto L36;
            case 6: goto L35;
            case 7: goto L34;
            case 8: goto L33;
            case 9: goto L32;
            default: goto L31;
        };
    L31:
        r103[2] = "<init>";
        goto L37
    L32:
        r103[2] = "guessByFirstCharacter";
        goto L37
    L33:
        r103[2] = "special";
        goto L37
    L34:
        r103[2] = "identifierIfValid";
        goto L37
    L35:
        r103[2] = "isValidIdentifier";
        goto L37
    L36:
        r103[2] = LocationMonitorConst.IDENTIFIER;
    L37:
        String r104 = String.format(r101, r103);
        if (r100 == 1) goto L44;
        if (r100 == 2) goto L44;
        if (r100 == 3) goto L44;
        if (r100 == 4) goto L44;
        throw new IllegalArgumentException(r104);
    L44:
        throw new IllegalStateException(r104);
    L27:
        r103[1] = "asStringStripSpecialMarkers";
        goto L30
    L28:
        r103[1] = "getIdentifier";
        goto L30
    L29:
        r103[1] = "asString";
    L21:
        r103[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
    L14:
        r102 = 2;
    L8:
        r101 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    public String asString() {
        String r100 = this.name;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        return r100;
    }

    public String getIdentifier() {
        if (this.special == true) goto L9;
        String r100 = asString();
        if (r100 != null) goto L7;
        $$$reportNull$$$0(2);
    L7:
        return r100;
    L9:
        throw new IllegalStateException("not identifier: " + this);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + (this.special ? 1 : 0);
    }

    public boolean isSpecial() {
        return this.special;
    }

    public String toString() {
        return this.name;
    }

    public static Name guessByFirstCharacter(String r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(9);
    L5:
        if (r100.startsWith("<") == false) goto L9;
        return special(r100);
    L9:
        return identifier(r100);
    }

    public static Name identifier(String r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return new Name(r100, false);
    }

    public static boolean isValidIdentifier(String r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        if (r100.isEmpty() == false) goto L7;
    L23:
        return false;
    L7:
        if (r100.startsWith("<") == true) goto L23;
        int r101 = 0;
    L11:
        if (r101 >= r100.length()) goto L21;
        char r102 = r100.charAt(r101);
        if (r102 == '.') goto L20;
        if (r102 == '/') goto L20;
        if (r102 == '\\') goto L20;
        r101 = r101 + 1;
    L20:
        return false;
    L21:
        return true;
    }

    public static Name special(String r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        if (r100.startsWith("<") == false) goto L9;
        return new Name(r100, true);
    L9:
        throw new IllegalArgumentException("special name must start with '<': ".concat(r100));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Name r100) {
        return this.name.compareTo(r100.name);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Name) == true) goto L8;
        return false;
    L8:
        Name r101 = (Name) r100;
        if (this.special == r101.special) goto L12;
        return false;
    L12:
        if (this.name.equals(r101.name) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Name r100) {
        return compareTo2(r100);
    }

    private Name(String r100, boolean r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        this.name = r100;
        this.special = r101;
    }
}
