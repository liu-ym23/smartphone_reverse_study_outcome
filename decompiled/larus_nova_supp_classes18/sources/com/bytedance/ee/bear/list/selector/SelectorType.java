package com.bytedance.ee.bear.list.selector;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00182\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0018B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0006\u0010\u0016\u001a\u00020\u0017j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/list/selector/SelectorType;", "Landroid/os/Parcelable;", "", "<init>", "(Ljava/lang/String;I)V", "SPACE_ADD_TO", "SPACE_MOVE_TO", "SPACE_MAKE_COPY_TO", "SPACE_ADD_SHORTCUT", "SPACE_SELECT_FOLDER", "SPACE_SAVE_TEMPLATE", "WIKI_MOVE_TO", "WIKI_SHORTCUT_TO", "WIKI_MAKE_COPY_TO", "WIKI_CREATE_TO", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "describeContents", "getAction", "", "CREATOR", "contentmanager-list-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SelectorType extends Enum<SelectorType> implements Parcelable {
    public static final a CREATOR = null;
    public static final SelectorType SPACE_ADD_SHORTCUT = null;
    public static final SelectorType SPACE_ADD_TO = null;
    public static final SelectorType SPACE_MAKE_COPY_TO = null;
    public static final SelectorType SPACE_MOVE_TO = null;
    public static final SelectorType SPACE_SAVE_TEMPLATE = null;
    public static final SelectorType SPACE_SELECT_FOLDER = null;
    public static final SelectorType WIKI_CREATE_TO = null;
    public static final SelectorType WIKI_MAKE_COPY_TO = null;
    public static final SelectorType WIKI_MOVE_TO = null;
    public static final SelectorType WIKI_SHORTCUT_TO = null;
    public static final /* synthetic */ SelectorType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SelectorType.values().length];
            r0[SelectorType.WIKI_CREATE_TO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[SelectorType.WIKI_SHORTCUT_TO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[SelectorType.SPACE_ADD_SHORTCUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[SelectorType.WIKI_MOVE_TO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[SelectorType.SPACE_MOVE_TO.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[SelectorType.WIKI_MAKE_COPY_TO.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    public static EnumEntries<SelectorType> getEntries() {
        return b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.bytedance.ee.bear.list.selector.SelectorType$a] */
    static {
        SelectorType r0 = new SelectorType("SPACE_ADD_TO", 0);
        SPACE_ADD_TO = r0;
        SelectorType r1 = new SelectorType("SPACE_MOVE_TO", 1);
        SPACE_MOVE_TO = r1;
        SelectorType r3 = new SelectorType("SPACE_MAKE_COPY_TO", 2);
        SPACE_MAKE_COPY_TO = r3;
        SelectorType r5 = new SelectorType("SPACE_ADD_SHORTCUT", 3);
        SPACE_ADD_SHORTCUT = r5;
        SelectorType r7 = new SelectorType("SPACE_SELECT_FOLDER", 4);
        SPACE_SELECT_FOLDER = r7;
        SelectorType r9 = new SelectorType("SPACE_SAVE_TEMPLATE", 5);
        SPACE_SAVE_TEMPLATE = r9;
        SelectorType r11 = new SelectorType("WIKI_MOVE_TO", 6);
        WIKI_MOVE_TO = r11;
        SelectorType r13 = new SelectorType("WIKI_SHORTCUT_TO", 7);
        WIKI_SHORTCUT_TO = r13;
        SelectorType r15 = new SelectorType("WIKI_MAKE_COPY_TO", 8);
        WIKI_MAKE_COPY_TO = r15;
        SelectorType r14 = new SelectorType("WIKI_CREATE_TO", 9);
        WIKI_CREATE_TO = r14;
        SelectorType[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
        CREATOR = new a();
    }

    public static SelectorType[] values() {
        return (SelectorType[]) a.clone();
    }

    public final String getAction() {
        switch(b.a[ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        return "space_copy";
    L5:
        return "wiki_copy";
    L6:
        return "space_move";
    L7:
        return "wiki_move";
    L8:
        return "space_create_shortcut";
    L9:
        return "wiki_create_shortcut";
    L10:
        return "create";
    }

    public static SelectorType valueOf(String r1) {
        return (SelectorType) r27.a.a(SelectorType.class, r1);
    }

    public SelectorType(String r1, int r2) {
        super(r1, r2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeInt(ordinal());
    }
}
