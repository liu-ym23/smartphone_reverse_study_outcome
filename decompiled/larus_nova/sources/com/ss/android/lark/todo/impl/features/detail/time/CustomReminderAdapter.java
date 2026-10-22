package com.ss.android.lark.todo.impl.features.detail.time;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class CustomReminderAdapter implements e18.a<String> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<ArrayList<String>> f443485c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<ArrayList<String>> f443486d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy<ArrayList<String>> f443487e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f443488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<String> f443489b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/time/CustomReminderAdapter$CustomReminderType;", "", "<init>", "(Ljava/lang/String;I)V", "DATE", "HOUR", "MINUTE", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CustomReminderType extends Enum<CustomReminderType> {
        public static final CustomReminderType DATE = null;
        public static final CustomReminderType HOUR = null;
        public static final CustomReminderType MINUTE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CustomReminderType[] f443490a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f443491b = null;

        public static EnumEntries<CustomReminderType> getEntries() {
            return f443491b;
        }

        static {
            CustomReminderType r100 = new CustomReminderType("DATE", 0);
            DATE = r100;
            CustomReminderType r101 = new CustomReminderType("HOUR", 1);
            HOUR = r101;
            CustomReminderType r102 = new CustomReminderType("MINUTE", 2);
            MINUTE = r102;
            CustomReminderType[] r103 = {r100, r101, r102};
            f443490a = r103;
            f443491b = EnumEntriesKt.enumEntries(r103);
        }

        public static CustomReminderType[] values() {
            return (CustomReminderType[]) f443490a.clone();
        }

        public static CustomReminderType valueOf(String r100) {
            return (CustomReminderType) r27.a.a(CustomReminderType.class, r100);
        }

        public CustomReminderType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public static String b(int r100) {
            if (r100 >= 10) goto L6;
            return "0" + r100;
        L6:
            return String.valueOf(r100);
        }

        public static ArrayList a(int r100, int r101) {
            ArrayList r102 = new ArrayList();
            if (r100 <= 0) goto L11;
            int r103 = 0;
            int r104 = ProgressionUtilKt.getProgressionLastElement(0, r101, r100);
            if (r104 < 0) goto L9;
        L6:
            r102.add(b(r103));
            if (r103 == r104) goto L9;
            r103 = r103 + r100;
        L9:
            return r102;
        L11:
            throw new IllegalArgumentException("Step must be positive, was: " + r100 + '.');
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f443492a = null;

        static {
            int[] r100 = new int[CustomReminderType.values().length];
            r100[CustomReminderType.DATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[CustomReminderType.HOUR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f443492a = r100;
        }
    }

    static {
        f443485c = LazyKt.lazy(CustomReminderAdapter$Companion$dateCustomReminders$2.INSTANCE);
        f443486d = LazyKt.lazy(CustomReminderAdapter$Companion$hourCustomReminders$2.INSTANCE);
        f443487e = LazyKt.lazy(CustomReminderAdapter$Companion$minutesCustomReminders$2.INSTANCE);
    }

    @Override // e18.a
    public final int getItemsCount() {
        return this.f443489b.size();
    }

    public CustomReminderAdapter() {
        CustomReminderType r100 = CustomReminderType.DATE;
        this.f443488a = "";
        this.f443489b = new ArrayList();
    }

    @Override // e18.a
    public final int a(Object r100) {
        return e18.a.C5729a.a(this, r100);
    }

    public final String b(int r100) {
        if (r100 < this.f443489b.size()) goto L7;
        return "";
    L7:
        return (String) ListProtector.get(this.f443489b, r100);
    }

    public final void c(CustomReminderType r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        int r101 = b.f443492a[r100.ordinal()];
        if (r101 != 1) goto L5;
        ArrayList<String> r102 = f443485c.getValue();
    L9:
        this.f443489b = new ArrayList(r102);
        return;
    L5:
        if (r101 == 2) goto L7;
        r102 = f443487e.getValue();
        goto L9
    L7:
        r102 = f443486d.getValue();
        goto L9
    }

    @Override // e18.a
    public final /* bridge */ /* synthetic */ String getItem(int r100) {
        return b(r100);
    }

    @Override // e18.a
    public final int indexOf(String r100) {
        String r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "o");
        return this.f443489b.indexOf(r101);
    }
}
