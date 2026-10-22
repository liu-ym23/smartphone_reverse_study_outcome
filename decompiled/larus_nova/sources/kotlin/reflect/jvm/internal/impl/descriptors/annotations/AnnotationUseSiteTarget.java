package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum AnnotationUseSiteTarget extends Enum<AnnotationUseSiteTarget> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AnnotationUseSiteTarget[] $VALUES = null;
    public static final AnnotationUseSiteTarget CONSTRUCTOR_PARAMETER = null;
    public static final AnnotationUseSiteTarget FIELD = null;
    public static final AnnotationUseSiteTarget FILE = null;
    public static final AnnotationUseSiteTarget PROPERTY = null;
    public static final AnnotationUseSiteTarget PROPERTY_DELEGATE_FIELD = null;
    public static final AnnotationUseSiteTarget PROPERTY_GETTER = null;
    public static final AnnotationUseSiteTarget PROPERTY_SETTER = null;
    public static final AnnotationUseSiteTarget RECEIVER = null;
    public static final AnnotationUseSiteTarget SETTER_PARAMETER = null;
    private final String renderName;

    private static final /* synthetic */ AnnotationUseSiteTarget[] $values() {
        return new AnnotationUseSiteTarget[]{FIELD, FILE, PROPERTY, PROPERTY_GETTER, PROPERTY_SETTER, RECEIVER, CONSTRUCTOR_PARAMETER, SETTER_PARAMETER, PROPERTY_DELEGATE_FIELD};
    }

    static {
        FIELD = new AnnotationUseSiteTarget("FIELD", 0, null, 1, null);
        FILE = new AnnotationUseSiteTarget("FILE", 1, null, 1, null);
        PROPERTY = new AnnotationUseSiteTarget("PROPERTY", 2, null, 1, null);
        PROPERTY_GETTER = new AnnotationUseSiteTarget("PROPERTY_GETTER", 3, MonitorConstants.CONNECT_TYPE_GET);
        PROPERTY_SETTER = new AnnotationUseSiteTarget("PROPERTY_SETTER", 4, "set");
        RECEIVER = new AnnotationUseSiteTarget("RECEIVER", 5, null, 1, null);
        CONSTRUCTOR_PARAMETER = new AnnotationUseSiteTarget("CONSTRUCTOR_PARAMETER", 6, "param");
        SETTER_PARAMETER = new AnnotationUseSiteTarget("SETTER_PARAMETER", 7, "setparam");
        PROPERTY_DELEGATE_FIELD = new AnnotationUseSiteTarget("PROPERTY_DELEGATE_FIELD", 8, "delegate");
        AnnotationUseSiteTarget[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static AnnotationUseSiteTarget[] values() {
        return (AnnotationUseSiteTarget[]) $VALUES.clone();
    }

    public final String getRenderName() {
        return this.renderName;
    }

    public static AnnotationUseSiteTarget valueOf(String r100) {
        return (AnnotationUseSiteTarget) a.a(AnnotationUseSiteTarget.class, r100);
    }

    private AnnotationUseSiteTarget(String r100, int r101, String r102) {
        super(r100, r101);
        if (r102 != null) goto L5;
        r102 = CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(name());
    L5:
        this.renderName = r102;
    }

    public /* synthetic */ AnnotationUseSiteTarget(String r100, int r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
