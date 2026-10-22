package com.bytedance.ee.bear.document.timepicker.view;

import android.text.TextUtils;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class TimeAdapter implements e18.a<String> {
    public final TimeType a;
    public final String b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/document/timepicker/view/TimeAdapter$TimeType;", "", "<init>", "(Ljava/lang/String;I)V", "Hours", "Minutes", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TimeType extends Enum<TimeType> {
        public static final TimeType Hours = null;
        public static final TimeType Minutes = null;
        public static final /* synthetic */ TimeType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<TimeType> getEntries() {
            return b;
        }

        static {
            TimeType r0 = new TimeType("Hours", 0);
            Hours = r0;
            TimeType r1 = new TimeType("Minutes", 1);
            Minutes = r1;
            TimeType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static TimeType[] values() {
            return (TimeType[]) a.clone();
        }

        public static TimeType valueOf(String r1) {
            return (TimeType) r27.a.a(TimeType.class, r1);
        }

        public TimeType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TimeType.values().length];
            r0[TimeType.Hours.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[TimeType.Minutes.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public final int getItemsCount() {
        if (this.a != TimeType.Hours) goto L5;
        return 24;
    L5:
        return 60;
    }

    public final TimeType getType() {
        return this.a;
    }

    public TimeAdapter(TimeType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.a = r2;
        int r3 = a.a[r2.ordinal()];
        if (r3 != 1) goto L5;
        String r4 = LarkContext.getApplication().getString(2131889119);
    L10:
        this.b = r4;
        return;
    L5:
        if (r3 != 2) goto L8;
        r4 = LarkContext.getApplication().getString(2131889120);
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final int a(Object r1) {
        return e18.a.a.a(this, r1);
    }

    public final Object getItem(int r2) {
        if (r2 >= 0) goto L4;
    L6:
        boolean r0 = false;
    L7:
        if (r0 == false) goto L10;
        return r2 + ' ' + this.b;
    L10:
        return "0 " + this.b;
    L4:
        if (r2 >= getItemsCount()) goto L6;
        r0 = true;
        goto L7
    }

    public final int indexOf(Object r6) {
        String r7 = (String) r6;
        Intrinsics.checkNotNullParameter(r7, "o");
        int r0 = getItemsCount();
        if (r0 < 0) goto L10;
        int r2 = 0;
    L6:
        if (TextUtils.equals(r7, r2 + ' ' + this.b) == true) goto L13;
        if (r2 == r0) goto L14;
        r2 = r2 + 1;
        goto L6
    L14:
        return 0;
    L13:
        return r2;
    L10:
        return 0;
    }
}
