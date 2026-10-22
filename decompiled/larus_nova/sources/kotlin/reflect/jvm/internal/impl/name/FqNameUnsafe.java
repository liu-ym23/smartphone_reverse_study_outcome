package kotlin.reflect.jvm.internal.impl.name;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.miui.easygo.constant.EasyGoConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes5.dex */
public final class FqNameUnsafe {
    private static final Name ROOT_NAME = null;
    private static final Pattern SPLIT_BY_DOTS = null;
    private static final Function1<String, Name> STRING_TO_NAME = null;
    private final String fqName;
    private transient FqNameUnsafe parent;
    private transient FqName safe;
    private transient Name shortName;

    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        switch(r100) {
            case 4: goto L4;
            case 5: goto L4;
            case 6: goto L4;
            case 7: goto L4;
            case 8: goto L4;
            case 9: goto L3;
            case 10: goto L4;
            case 11: goto L4;
            case 12: goto L4;
            case 13: goto L4;
            case 14: goto L4;
            case 15: goto L3;
            case 16: goto L3;
            case 17: goto L3;
            case 18: goto L4;
            default: goto L3;
        };
    L3:
        String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r100) {
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L8;
            case 11: goto L8;
            case 12: goto L8;
            case 13: goto L8;
            case 14: goto L8;
            case 15: goto L7;
            case 16: goto L7;
            case 17: goto L7;
            case 18: goto L8;
            default: goto L7;
        };
    L7:
        int r102 = 3;
    L9:
        Object[] r103 = new Object[r102];
        if (r100 == 1) goto L18;
        switch(r100) {
            case 4: goto L17;
            case 5: goto L17;
            case 6: goto L17;
            case 7: goto L17;
            case 8: goto L17;
            case 9: goto L16;
            case 10: goto L17;
            case 11: goto L17;
            case 12: goto L17;
            case 13: goto L17;
            case 14: goto L17;
            case 15: goto L15;
            case 16: goto L14;
            case 17: goto L13;
            case 18: goto L17;
            default: goto L12;
        };
    L12:
        r103[0] = "fqName";
    L19:
        switch(r100) {
            case 4: goto L27;
            case 5: goto L26;
            case 6: goto L26;
            case 7: goto L25;
            case 8: goto L25;
            case 9: goto L20;
            case 10: goto L24;
            case 11: goto L24;
            case 12: goto L23;
            case 13: goto L23;
            case 14: goto L22;
            case 15: goto L20;
            case 16: goto L20;
            case 17: goto L20;
            case 18: goto L21;
            default: goto L20;
        };
    L20:
        r103[1] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
    L28:
        switch(r100) {
            case 4: goto L33;
            case 5: goto L33;
            case 6: goto L33;
            case 7: goto L33;
            case 8: goto L33;
            case 9: goto L32;
            case 10: goto L33;
            case 11: goto L33;
            case 12: goto L33;
            case 13: goto L33;
            case 14: goto L33;
            case 15: goto L31;
            case 16: goto L31;
            case 17: goto L30;
            case 18: goto L33;
            default: goto L29;
        };
    L29:
        r103[2] = "<init>";
        goto L33
    L30:
        r103[2] = "topLevel";
        goto L33
    L31:
        r103[2] = "startsWith";
        goto L33
    L32:
        r103[2] = MapBundleKey.OfflineMapKey.OFFLINE_CHILD;
    L33:
        String r104 = String.format(r101, r103);
        switch(r100) {
            case 4: goto L37;
            case 5: goto L37;
            case 6: goto L37;
            case 7: goto L37;
            case 8: goto L37;
            case 9: goto L38;
            case 10: goto L37;
            case 11: goto L37;
            case 12: goto L37;
            case 13: goto L37;
            case 14: goto L37;
            case 15: goto L38;
            case 16: goto L38;
            case 17: goto L38;
            case 18: goto L37;
            default: goto L38;
        };
    L38:
        throw new IllegalArgumentException(r104);
    L37:
        throw new IllegalStateException(r104);
    L21:
        r103[1] = "toString";
        goto L28
    L22:
        r103[1] = "pathSegments";
        goto L28
    L23:
        r103[1] = "shortNameOrSpecial";
        goto L28
    L24:
        r103[1] = "shortName";
        goto L28
    L25:
        r103[1] = "parent";
        goto L28
    L26:
        r103[1] = "toSafe";
        goto L28
    L27:
        r103[1] = "asString";
        goto L28
    L13:
        r103[0] = "shortName";
        goto L19
    L14:
        r103[0] = "other";
        goto L19
    L15:
        r103[0] = MonitorConstants.SEGMENT;
        goto L19
    L16:
        r103[0] = "name";
        goto L19
    L17:
        r103[0] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
        goto L19
    L18:
        r103[0] = "safe";
        goto L19
    L8:
        r102 = 2;
        goto L9
    L4:
        r101 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    static {
        ROOT_NAME = Name.special("<root>");
        SPLIT_BY_DOTS = PatternProtector.compile(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        STRING_TO_NAME = new AnonymousClass1();
    }

    private void compute() {
        int r100 = this.fqName.lastIndexOf(46);
        if (r100 < 0) goto L5;
        this.shortName = Name.guessByFirstCharacter(this.fqName.substring(r100 + 1));
        this.parent = new FqNameUnsafe(this.fqName.substring(0, r100));
        return;
    L5:
        this.shortName = Name.guessByFirstCharacter(this.fqName);
        this.parent = FqName.ROOT.toUnsafe();
    }

    public String asString() {
        String r100 = this.fqName;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r100;
    }

    public int hashCode() {
        return this.fqName.hashCode();
    }

    public boolean isRoot() {
        return this.fqName.isEmpty();
    }

    public boolean isSafe() {
        if (this.safe == null) goto L5;
    L8:
        return true;
    L5:
        if (asString().indexOf(60) < 0) goto L8;
        return false;
    }

    public FqNameUnsafe parent() {
        FqNameUnsafe r100 = this.parent;
        if (r100 == null) goto L8;
        if (r100 != null) goto L6;
        $$$reportNull$$$0(7);
    L6:
        return r100;
    L8:
        if (isRoot() == true) goto L14;
        compute();
        FqNameUnsafe r101 = this.parent;
        if (r101 != null) goto L12;
        $$$reportNull$$$0(8);
    L12:
        return r101;
    L14:
        throw new IllegalStateException(RootDescription.ROOT_ELEMENT);
    }

    public Name shortName() {
        Name r100 = this.shortName;
        if (r100 == null) goto L8;
        if (r100 != null) goto L6;
        $$$reportNull$$$0(10);
    L6:
        return r100;
    L8:
        if (isRoot() == true) goto L14;
        compute();
        Name r101 = this.shortName;
        if (r101 != null) goto L12;
        $$$reportNull$$$0(11);
    L12:
        return r101;
    L14:
        throw new IllegalStateException(RootDescription.ROOT_ELEMENT);
    }

    public FqName toSafe() {
        FqName r100 = this.safe;
        if (r100 == null) goto L7;
        if (r100 != null) goto L6;
        $$$reportNull$$$0(5);
    L6:
        return r100;
    L7:
        FqName r101 = new FqName(this);
        this.safe = r101;
        return r101;
    }

    public List<Name> pathSegments() {
        if (isRoot() == false) goto L5;
        List<Name> r100 = Collections.emptyList();
    L6:
        if (r100 != null) goto L8;
        $$$reportNull$$$0(14);
    L8:
        return r100;
    L5:
        r100 = ArraysKt.map(SPLIT_BY_DOTS.split(this.fqName), STRING_TO_NAME);
        goto L6
    }

    public Name shortNameOrSpecial() {
        if (isRoot() == false) goto L8;
        Name r100 = ROOT_NAME;
        if (r100 != null) goto L7;
        $$$reportNull$$$0(12);
    L7:
        return r100;
    L8:
        Name r101 = shortName();
        if (r101 != null) goto L11;
        $$$reportNull$$$0(13);
    L11:
        return r101;
    }

    public String toString() {
        if (isRoot() == false) goto L5;
        String r100 = ROOT_NAME.asString();
    L6:
        if (r100 != null) goto L8;
        $$$reportNull$$$0(18);
    L8:
        return r100;
    L5:
        r100 = this.fqName;
        goto L6
    }

    public FqNameUnsafe(String r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        this.fqName = r100;
    }

    public static FqNameUnsafe topLevel(Name r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(17);
    L5:
        return new FqNameUnsafe(r100.asString(), FqName.ROOT.toUnsafe(), r100);
    }

    public FqNameUnsafe child(Name r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(9);
    L5:
        if (isRoot() == false) goto L7;
        String r101 = r100.asString();
    L9:
        return new FqNameUnsafe(r101, this, r100);
    L7:
        r101 = this.fqName + "." + r100.asString();
        goto L9
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FqNameUnsafe) == true) goto L9;
        return false;
    L9:
        if (this.fqName.equals(((FqNameUnsafe) r100).fqName) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public boolean startsWith(Name r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(15);
    L5:
        if (isRoot() == false) goto L7;
        return false;
    L7:
        int r101 = this.fqName.indexOf(46);
        if (r101 != (-1)) goto L10;
        r101 = this.fqName.length();
    L10:
        String r102 = r100.asString();
        if (r101 == r102.length()) goto L13;
        return false;
    L13:
        if (this.fqName.regionMatches(0, r102, 0, r101) == false) goto L17;
        return true;
    L17:
        return false;
    }

    public FqNameUnsafe(String r100, FqName r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        this.fqName = r100;
        this.safe = r101;
    }

    private FqNameUnsafe(String r100, FqNameUnsafe r101, Name r102) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        this.fqName = r100;
        this.parent = r101;
        this.shortName = r102;
    }
}
