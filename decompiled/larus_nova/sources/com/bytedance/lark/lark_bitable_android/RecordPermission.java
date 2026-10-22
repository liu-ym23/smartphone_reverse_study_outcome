package com.bytedance.lark.lark_bitable_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/bytedance/lark/lark_bitable_android/RecordPermission;", "", "(Ljava/lang/String;I)V", "into", "Llark_bitable/proto/RecordPermission;", "intoInt", "", "Readable", "Editable", "Companion", "lark_bitable_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum RecordPermission extends Enum<RecordPermission> {
    public static final a Companion = null;
    public static final RecordPermission Editable = null;
    public static final RecordPermission Readable = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RecordPermission[] f252970a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f252971b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f252972a = null;

        static {
            int[] r100 = new int[RecordPermission.values().length];
            r100[RecordPermission.Readable.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[RecordPermission.Editable.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f252972a = r100;
        }
    }

    public static EnumEntries<RecordPermission> getEntries() {
        return f252971b;
    }

    public static RecordPermission valueOf(String r100) {
        return (RecordPermission) r27.a.a(RecordPermission.class, r100);
    }

    public static RecordPermission[] values() {
        return (RecordPermission[]) f252970a.clone();
    }

    static {
        RecordPermission r100 = new RecordPermission("Readable", 0);
        Readable = r100;
        RecordPermission r101 = new RecordPermission("Editable", 1);
        Editable = r101;
        RecordPermission[] r102 = {r100, r101};
        f252970a = r102;
        f252971b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public final lark_bitable.proto.RecordPermission into() {
        int r100 = b.f252972a[ordinal()];
        if (r100 == 1) goto L10;
        if (r100 != 2) goto L8;
        return lark_bitable.proto.RecordPermission.VAR_RECORD_PERMISSION_EDITABLE;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return lark_bitable.proto.RecordPermission.VAR_RECORD_PERMISSION_READABLE;
    }

    public final int intoInt() {
        int r100 = b.f252972a[ordinal()];
        if (r100 != 1) goto L5;
        return 0;
    L5:
        if (r100 != 2) goto L8;
        return 1;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final RecordPermission fromInt(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L10;
        if (r100 != 1) goto L8;
        return Editable;
    L8:
        throw new RuntimeException("Unmatched primitive enum value: RecordPermission with ");
    L10:
        return Readable;
    }

    public RecordPermission(String r100, int r101) {
        super(r100, r101);
    }
}
