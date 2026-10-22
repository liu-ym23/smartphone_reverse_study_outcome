package com.ss.android.lark.component.appcontext.model;

import com.ss.android.lark.lynxkit.xbridge.BuildConfig;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$GEO;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/component/appcontext/model/Flavor;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "REGION_CHINA", "REGION_US", "ENV_DEVELOPMENT", "ENV_PRODUCTION", "Companion", "appcontext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Flavor extends Enum<Flavor> {
    public static final a Companion = null;
    public static final Flavor ENV_DEVELOPMENT = null;
    public static final Flavor ENV_PRODUCTION = null;
    public static final Flavor REGION_CHINA = null;
    public static final Flavor REGION_US = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Flavor> f417280a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ Flavor[] f417281b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f417282c = null;
    private final String value;

    public static final class a {
        public a() {
        }

        public static Flavor a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            Flavor r101 = (Flavor) Flavor.access$getValuesMap$cp().get(r100);
            if (r101 == null) goto L6;
            return r101;
        L6:
            throw new IllegalArgumentException("flavor " + r100 + " not found");
        }
    }

    public static EnumEntries<Flavor> getEntries() {
        return f417282c;
    }

    static {
        int r100 = 0;
        Flavor r101 = new Flavor("REGION_CHINA", 0, BuildConfig.FLAVOR);
        REGION_CHINA = r101;
        Flavor r102 = new Flavor("REGION_US", 1, EnvConst$GEO.US);
        REGION_US = r102;
        Flavor r103 = new Flavor("ENV_DEVELOPMENT", 2, "development");
        ENV_DEVELOPMENT = r103;
        Flavor r104 = new Flavor("ENV_PRODUCTION", 3, "production");
        ENV_PRODUCTION = r104;
        Flavor[] r105 = {r101, r102, r103, r104};
        f417281b = r105;
        f417282c = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
        Flavor[] r106 = values();
        LinkedHashMap r107 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r106.length), 16));
        int r108 = r106.length;
    L3:
        if (r100 >= r108) goto L5;
        Flavor r109 = r106[r100];
        r107.put(r109.value, r109);
        r100 = r100 + 1;
        goto L3
    L5:
        f417280a = r107;
    }

    public static Flavor[] values() {
        return (Flavor[]) f417281b.clone();
    }

    public static final /* synthetic */ Map access$getValuesMap$cp() {
        return f417280a;
    }

    public final String getValue() {
        return this.value;
    }

    public static Flavor valueOf(String r100) {
        return (Flavor) r27.a.a(Flavor.class, r100);
    }

    public Flavor(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
