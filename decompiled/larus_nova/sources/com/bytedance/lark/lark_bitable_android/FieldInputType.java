package com.bytedance.lark.lark_bitable_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/bytedance/lark/lark_bitable_android/FieldInputType;", "", "(Ljava/lang/String;I)V", "into", "Llark_bitable/proto/FieldInputType;", "intoInt", "", "NoLimit", "Mobile", "Companion", "lark_bitable_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum FieldInputType extends Enum<FieldInputType> {
    public static final a Companion = null;
    public static final FieldInputType Mobile = null;
    public static final FieldInputType NoLimit = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FieldInputType[] f252955a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f252956b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f252957a = null;

        static {
            int[] r100 = new int[FieldInputType.values().length];
            r100[FieldInputType.NoLimit.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[FieldInputType.Mobile.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f252957a = r100;
        }
    }

    public static EnumEntries<FieldInputType> getEntries() {
        return f252956b;
    }

    public static FieldInputType valueOf(String r100) {
        return (FieldInputType) r27.a.a(FieldInputType.class, r100);
    }

    public static FieldInputType[] values() {
        return (FieldInputType[]) f252955a.clone();
    }

    static {
        FieldInputType r100 = new FieldInputType("NoLimit", 0);
        NoLimit = r100;
        FieldInputType r101 = new FieldInputType("Mobile", 1);
        Mobile = r101;
        FieldInputType[] r102 = {r100, r101};
        f252955a = r102;
        f252956b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public final lark_bitable.proto.FieldInputType into() {
        int r100 = b.f252957a[ordinal()];
        if (r100 == 1) goto L10;
        if (r100 != 2) goto L8;
        return lark_bitable.proto.FieldInputType.VAR_FIELD_INPUT_TYPE_MOBILE;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return lark_bitable.proto.FieldInputType.VAR_FIELD_INPUT_TYPE_NO_LIMIT;
    }

    public final int intoInt() {
        int r100 = b.f252957a[ordinal()];
        if (r100 != 1) goto L5;
        return 0;
    L5:
        if (r100 != 2) goto L8;
        return 1;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final FieldInputType fromInt(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L10;
        if (r100 != 1) goto L8;
        return Mobile;
    L8:
        throw new RuntimeException("Unmatched primitive enum value: FieldInputType with ");
    L10:
        return NoLimit;
    }

    public FieldInputType(String r100, int r101) {
        super(r100, r101);
    }
}
