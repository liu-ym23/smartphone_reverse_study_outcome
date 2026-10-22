package com.ss.android.lark.officesdk.minutes.service.foundation.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
public final class MmStringCheckUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f434025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public StringCheckoutErrorType f434026b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/MmStringCheckUtil$StringCheckoutErrorType;", "", "<init>", "(Ljava/lang/String;I)V", "SAME", "NULL_OR_EMPTY", "NULL", "NOT_DEFINE", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum StringCheckoutErrorType extends Enum<StringCheckoutErrorType> {
        public static final StringCheckoutErrorType NOT_DEFINE = null;
        public static final StringCheckoutErrorType NULL = null;
        public static final StringCheckoutErrorType NULL_OR_EMPTY = null;
        public static final StringCheckoutErrorType SAME = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StringCheckoutErrorType[] f434027a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f434028b = null;

        public static EnumEntries<StringCheckoutErrorType> getEntries() {
            return f434028b;
        }

        static {
            StringCheckoutErrorType r100 = new StringCheckoutErrorType("SAME", 0);
            SAME = r100;
            StringCheckoutErrorType r101 = new StringCheckoutErrorType("NULL_OR_EMPTY", 1);
            NULL_OR_EMPTY = r101;
            StringCheckoutErrorType r102 = new StringCheckoutErrorType("NULL", 2);
            NULL = r102;
            StringCheckoutErrorType r103 = new StringCheckoutErrorType("NOT_DEFINE", 3);
            NOT_DEFINE = r103;
            StringCheckoutErrorType[] r104 = {r100, r101, r102, r103};
            f434027a = r104;
            f434028b = EnumEntriesKt.enumEntries(r104);
        }

        public static StringCheckoutErrorType[] values() {
            return (StringCheckoutErrorType[]) f434027a.clone();
        }

        public static StringCheckoutErrorType valueOf(String r100) {
            return (StringCheckoutErrorType) r27.a.a(StringCheckoutErrorType.class, r100);
        }

        public StringCheckoutErrorType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public MmStringCheckUtil(String r100) {
    }
}
