package com.bytedance.ee.bear.document.timepicker.view;

import android.text.TextUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class TimeAdapter implements e18.a<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TimeType f222011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f222012b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/document/timepicker/view/TimeAdapter$TimeType;", "", "<init>", "(Ljava/lang/String;I)V", "Hours", "Minutes", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TimeType extends Enum<TimeType> {
        public static final TimeType Hours = null;
        public static final TimeType Minutes = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TimeType[] f222013a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f222014b = null;

        public static EnumEntries<TimeType> getEntries() {
            return f222014b;
        }

        static {
            TimeType r100 = new TimeType("Hours", 0);
            Hours = r100;
            TimeType r101 = new TimeType("Minutes", 1);
            Minutes = r101;
            TimeType[] r102 = {r100, r101};
            f222013a = r102;
            f222014b = EnumEntriesKt.enumEntries(r102);
        }

        public static TimeType[] values() {
            return (TimeType[]) f222013a.clone();
        }

        public static TimeType valueOf(String r100) {
            return (TimeType) r27.a.a(TimeType.class, r100);
        }

        public TimeType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f222015a = null;

        static {
            int[] r100 = new int[TimeType.values().length];
            r100[TimeType.Hours.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[TimeType.Minutes.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f222015a = r100;
        }
    }

    @Override // e18.a
    public final int getItemsCount() {
        if (this.f222011a != TimeType.Hours) goto L5;
        return 24;
    L5:
        return 60;
    }

    public final TimeType getType() {
        return this.f222011a;
    }

    public TimeAdapter(TimeType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f222011a = r100;
        int r101 = a.f222015a[r100.ordinal()];
        if (r101 != 1) goto L5;
        String r102 = LarkContext.getApplication().getString(R.string.LarkCCM_Docs_MeetingAgenda_TimeH_Placeholder);
    L10:
        this.f222012b = r102;
        return;
    L5:
        if (r101 != 2) goto L8;
        r102 = LarkContext.getApplication().getString(R.string.LarkCCM_Docs_MeetingAgenda_TimeMin_Placeholder);
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @Override // e18.a
    public final int a(Object r100) {
        return e18.a.C5729a.a(this, r100);
    }

    @Override // e18.a
    public final String getItem(int r100) {
        if (r100 >= 0) goto L4;
    L6:
        boolean r101 = false;
    L7:
        if (r101 == false) goto L10;
        return r100 + ' ' + this.f222012b;
    L10:
        return "0 " + this.f222012b;
    L4:
        if (r100 >= getItemsCount()) goto L6;
        r101 = true;
        goto L7
    }

    @Override // e18.a
    public final int indexOf(String r100) {
        String r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "o");
        int r102 = getItemsCount();
        if (r102 < 0) goto L10;
        int r103 = 0;
    L6:
        if (TextUtils.equals(r101, r103 + ' ' + this.f222012b) == true) goto L13;
        if (r103 == r102) goto L14;
        r103 = r103 + 1;
        goto L6
    L14:
        return 0;
    L13:
        return r103;
    L10:
        return 0;
    }
}
