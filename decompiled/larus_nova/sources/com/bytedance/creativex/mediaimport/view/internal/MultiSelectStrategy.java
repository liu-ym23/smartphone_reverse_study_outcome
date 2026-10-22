package com.bytedance.creativex.mediaimport.view.internal;

import com.obric.miniapp.alarm.AccountType;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/creativex/mediaimport/view/internal/MultiSelectStrategy;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", AccountType.ALL, "VIDEO", "IMAGE", "NON", "findChange", "other", "contains", "", PickerReporterConstants.KEY.TARGET, "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MultiSelectStrategy extends Enum<MultiSelectStrategy> {
    public static final MultiSelectStrategy ALL = null;
    public static final MultiSelectStrategy IMAGE = null;
    public static final MultiSelectStrategy NON = null;
    public static final MultiSelectStrategy VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultiSelectStrategy[] f203684a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f203685b = null;
    private final int value;

    public static EnumEntries<MultiSelectStrategy> getEntries() {
        return f203685b;
    }

    static {
        MultiSelectStrategy r100 = new MultiSelectStrategy(AccountType.ALL, 0, 17);
        ALL = r100;
        MultiSelectStrategy r101 = new MultiSelectStrategy("VIDEO", 1, 16);
        VIDEO = r101;
        MultiSelectStrategy r102 = new MultiSelectStrategy("IMAGE", 2, 1);
        IMAGE = r102;
        MultiSelectStrategy r103 = new MultiSelectStrategy("NON", 3, 0);
        NON = r103;
        MultiSelectStrategy[] r104 = {r100, r101, r102, r103};
        f203684a = r104;
        f203685b = EnumEntriesKt.enumEntries(r104);
    }

    public static MultiSelectStrategy[] values() {
        return (MultiSelectStrategy[]) f203684a.clone();
    }

    public static MultiSelectStrategy valueOf(String r100) {
        return (MultiSelectStrategy) a.a(MultiSelectStrategy.class, r100);
    }

    public final boolean contains(MultiSelectStrategy r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        MultiSelectStrategy r101 = NON;
        if (r100 == r101) goto L17;
        if (this != r101) goto L7;
        return false;
    L7:
        if (this != r100) goto L10;
        return true;
    L10:
        if (this == ALL) goto L12;
        return false;
    L12:
        if (r100 != VIDEO) goto L14;
    L15:
        return true;
    L14:
        if (r100 == IMAGE) goto L15;
        return false;
    L17:
        return false;
    }

    public final MultiSelectStrategy findChange(MultiSelectStrategy r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        if (this == r100) goto L5;
        int r101 = this.value;
        int r102 = r100.value ^ r101;
        MultiSelectStrategy[] r103 = values();
        int r104 = r103.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L16;
        MultiSelectStrategy r106 = r103[r105];
        if (r106.value != r102) goto L11;
        boolean r107 = true;
    L12:
        if (r107 == true) goto L13;
        r105 = r105 + 1;
        goto L7
    L13:
        return r106;
    L11:
        r107 = false;
        goto L12
    L16:
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    L5:
        return NON;
    }

    public MultiSelectStrategy(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
