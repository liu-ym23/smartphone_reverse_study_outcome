package com.ss.android.lark.auditsdk.v2.receivecheck.entity;

import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/auditsdk/v2/receivecheck/entity/IMFileResult;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "TO_CHECK", "ALLOW", "DENY", "ORIGIN", "Companion", "audit-wrapper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IMFileResult extends Enum<IMFileResult> {
    public static final IMFileResult ALLOW = null;
    public static final a Companion = null;
    public static final IMFileResult DENY = null;
    public static final IMFileResult ORIGIN = null;
    public static final IMFileResult TO_CHECK = null;
    public static final IMFileResult UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IMFileResult[] f409680a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f409681b = null;
    private final int value;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C4762a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f409682a = null;

            static {
                int[] r100 = new int[ResultType.values().length];
                r100[ResultType.DENY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[ResultType.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f409682a = r100;
            }
        }

        public a() {
        }

        public static IMFileResult a(ResultType r100) {
            int r101 = C4762a.f409682a[r100.ordinal()];
            if (r101 == 1) goto L8;
            if (r101 == 2) goto L8;
            return IMFileResult.ALLOW;
        L8:
            return IMFileResult.DENY;
        }

        @JvmStatic
        public static IMFileResult b(ResultType r100, ValidateIMFileResult.b r101, boolean r102, AuthorityParam.AuthorityExtraParam r103) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Intrinsics.checkNotNullParameter(r101, "judge");
            Intrinsics.checkNotNullParameter(r103, "authorityExtraParam");
            if (r101.f409683a == true) goto L5;
            if (r102 == false) goto L9;
            return a(r100);
        L9:
            if (r101.f409684b == false) goto L12;
            return a(r100);
        L12:
            if (r103.isFromMe() == false) goto L15;
            return a(r100);
        L15:
            return IMFileResult.TO_CHECK;
        L5:
            return a(r100);
        }
    }

    public static EnumEntries<IMFileResult> getEntries() {
        return f409681b;
    }

    @JvmStatic
    public static final IMFileResult toIMResult(ResultType r100, ValidateIMFileResult.b r101, boolean r102, AuthorityParam.AuthorityExtraParam r103) {
        Companion.getClass();
        return a.b(r100, r101, r102, r103);
    }

    static {
        IMFileResult r100 = new IMFileResult("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        IMFileResult r101 = new IMFileResult("TO_CHECK", 1, 1);
        TO_CHECK = r101;
        IMFileResult r102 = new IMFileResult("ALLOW", 2, 2);
        ALLOW = r102;
        IMFileResult r103 = new IMFileResult("DENY", 3, 3);
        DENY = r103;
        IMFileResult r104 = new IMFileResult("ORIGIN", 4, 4);
        ORIGIN = r104;
        IMFileResult[] r105 = {r100, r101, r102, r103, r104};
        f409680a = r105;
        f409681b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static IMFileResult[] values() {
        return (IMFileResult[]) f409680a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static IMFileResult valueOf(String r100) {
        return (IMFileResult) r27.a.a(IMFileResult.class, r100);
    }

    public IMFileResult(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
