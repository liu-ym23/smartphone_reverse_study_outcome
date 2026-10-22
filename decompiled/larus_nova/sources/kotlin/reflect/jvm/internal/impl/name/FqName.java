package kotlin.reflect.jvm.internal.impl.name;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class FqName {
    public static final FqName ROOT = null;
    private final FqNameUnsafe fqName;
    private transient FqName parent;

    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        switch(r100) {
            case 4: goto L4;
            case 5: goto L4;
            case 6: goto L4;
            case 7: goto L4;
            case 8: goto L3;
            case 9: goto L4;
            case 10: goto L4;
            case 11: goto L4;
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
            case 8: goto L7;
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L8;
            default: goto L7;
        };
    L7:
        int r102 = 3;
    L9:
        Object[] r103 = new Object[r102];
        switch(r100) {
            case 1: goto L17;
            case 2: goto L17;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L16;
            case 6: goto L16;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L16;
            case 10: goto L16;
            case 11: goto L16;
            case 12: goto L14;
            case 13: goto L13;
            case 14: goto L12;
            default: goto L11;
        };
    L11:
        r103[0] = "names";
    L19:
        switch(r100) {
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L24;
            case 8: goto L20;
            case 9: goto L23;
            case 10: goto L22;
            case 11: goto L21;
            default: goto L20;
        };
    L20:
        r103[1] = "kotlin/reflect/jvm/internal/impl/name/FqName";
    L27:
        switch(r100) {
            case 1: goto L32;
            case 2: goto L32;
            case 3: goto L32;
            case 4: goto L33;
            case 5: goto L33;
            case 6: goto L33;
            case 7: goto L33;
            case 8: goto L31;
            case 9: goto L33;
            case 10: goto L33;
            case 11: goto L33;
            case 12: goto L30;
            case 13: goto L30;
            case 14: goto L29;
            default: goto L28;
        };
    L28:
        r103[2] = "fromSegments";
        goto L33
    L29:
        r103[2] = "topLevel";
        goto L33
    L30:
        r103[2] = "startsWith";
        goto L33
    L31:
        r103[2] = MapBundleKey.OfflineMapKey.OFFLINE_CHILD;
        goto L33
    L32:
        r103[2] = "<init>";
    L33:
        String r104 = String.format(r101, r103);
        switch(r100) {
            case 4: goto L37;
            case 5: goto L37;
            case 6: goto L37;
            case 7: goto L37;
            case 8: goto L38;
            case 9: goto L37;
            case 10: goto L37;
            case 11: goto L37;
            default: goto L38;
        };
    L38:
        throw new IllegalArgumentException(r104);
    L37:
        throw new IllegalStateException(r104);
    L21:
        r103[1] = "pathSegments";
        goto L27
    L22:
        r103[1] = "shortNameOrSpecial";
        goto L27
    L23:
        r103[1] = "shortName";
        goto L27
    L24:
        r103[1] = "parent";
        goto L27
    L25:
        r103[1] = "toUnsafe";
        goto L27
    L26:
        r103[1] = "asString";
        goto L27
    L12:
        r103[0] = "shortName";
        goto L19
    L13:
        r103[0] = "other";
        goto L19
    L14:
        r103[0] = MonitorConstants.SEGMENT;
        goto L19
    L15:
        r103[0] = "name";
        goto L19
    L16:
        r103[0] = "kotlin/reflect/jvm/internal/impl/name/FqName";
        goto L19
    L17:
        r103[0] = "fqName";
        goto L19
    L8:
        r102 = 2;
        goto L9
    L4:
        r101 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    static {
        ROOT = new FqName("");
    }

    public String asString() {
        String r100 = this.fqName.asString();
        if (r100 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r100;
    }

    public int hashCode() {
        return this.fqName.hashCode();
    }

    public boolean isRoot() {
        return this.fqName.isRoot();
    }

    public FqName parent() {
        FqName r100 = this.parent;
        if (r100 == null) goto L8;
        if (r100 != null) goto L6;
        $$$reportNull$$$0(6);
    L6:
        return r100;
    L8:
        if (isRoot() == true) goto L12;
        FqName r101 = new FqName(this.fqName.parent());
        this.parent = r101;
        return r101;
    L12:
        throw new IllegalStateException(RootDescription.ROOT_ELEMENT);
    }

    public List<Name> pathSegments() {
        List<Name> r100 = this.fqName.pathSegments();
        if (r100 != null) goto L5;
        $$$reportNull$$$0(11);
    L5:
        return r100;
    }

    public Name shortName() {
        Name r100 = this.fqName.shortName();
        if (r100 != null) goto L5;
        $$$reportNull$$$0(9);
    L5:
        return r100;
    }

    public Name shortNameOrSpecial() {
        Name r100 = this.fqName.shortNameOrSpecial();
        if (r100 != null) goto L5;
        $$$reportNull$$$0(10);
    L5:
        return r100;
    }

    public String toString() {
        return this.fqName.toString();
    }

    public FqNameUnsafe toUnsafe() {
        FqNameUnsafe r100 = this.fqName;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r100;
    }

    public FqName(String r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(1);
    L4:
        this.fqName = new FqNameUnsafe(r100, this);
    }

    public static FqName topLevel(Name r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(14);
    L5:
        return new FqName(FqNameUnsafe.topLevel(r100));
    }

    public FqName child(Name r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        return new FqName(this.fqName.child(r100), this);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FqName) == true) goto L9;
        return false;
    L9:
        if (this.fqName.equals(((FqName) r100).fqName) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public boolean startsWith(Name r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(12);
    L5:
        return this.fqName.startsWith(r100);
    }

    public FqName(FqNameUnsafe r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        this.fqName = r100;
    }

    private FqName(FqNameUnsafe r100, FqName r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        this.fqName = r100;
        this.parent = r101;
    }
}
