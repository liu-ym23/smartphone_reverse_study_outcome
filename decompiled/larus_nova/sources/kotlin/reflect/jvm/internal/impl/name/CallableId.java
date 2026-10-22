package kotlin.reflect.jvm.internal.impl.name;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class CallableId {
    public static final Companion Companion = null;
    private static final Name LOCAL_NAME = null;
    private static final FqName PACKAGE_FQ_NAME_FOR_LOCAL = null;
    private final Name callableName;
    private final ClassId classId;
    private final FqName className;
    private final FqName packageName;
    private final FqName pathToLocal;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        Name r100 = SpecialNames.LOCAL;
        LOCAL_NAME = r100;
        PACKAGE_FQ_NAME_FOR_LOCAL = FqName.topLevel(r100);
    }

    public int hashCode() {
        int r100 = (TTVideoEngineInterface.PLAYER_OPTION_ABR_STALL_PENALTY_PARAMETER + this.packageName.hashCode()) * 31;
        FqName r101 = this.className;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return ((r100 + r102) * 31) + this.callableName.hashCode();
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(StringsKt.replace$default(this.packageName.asString(), '.', '/', false, 4, null));
        r100.append(HTTP.URL_DEFAULT);
        FqName r101 = this.className;
        if (r101 == null) goto L5;
        r100.append(r101);
        r100.append(".");
    L5:
        r100.append(this.callableName);
        return r100.toString();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CallableId) == true) goto L8;
    L7:
        return false;
    L8:
        CallableId r101 = (CallableId) r100;
        if (Intrinsics.areEqual(this.packageName, r101.packageName) == false) goto L7;
        if (Intrinsics.areEqual(this.className, r101.className) == false) goto L7;
        if (Intrinsics.areEqual(this.callableName, r101.callableName) == false) goto L7;
        return true;
    }

    public CallableId(FqName r100, Name r101) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        Intrinsics.checkNotNullParameter(r101, "callableName");
        this(r100, null, r101, null, null);
    }

    private CallableId(FqName r100, FqName r101, Name r102, ClassId r103, FqName r104) {
        this.packageName = r100;
        this.className = r101;
        this.callableName = r102;
        this.classId = r103;
        this.pathToLocal = r104;
    }
}
