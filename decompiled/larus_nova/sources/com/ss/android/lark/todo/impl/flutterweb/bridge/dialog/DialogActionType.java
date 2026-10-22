package com.ss.android.lark.todo.impl.flutterweb.bridge.dialog;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/bridge/dialog/DialogActionType;", "", "<init>", "(Ljava/lang/String;I)V", "Primary", "Secondary", "Error", "path", "", "getPath", "()Ljava/lang/String;", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DialogActionType extends Enum<DialogActionType> {
    public static final DialogActionType Error = null;
    public static final DialogActionType Primary = null;
    public static final DialogActionType Secondary = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DialogActionType[] f444173a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f444174b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f444175a = null;

        static {
            int[] r100 = new int[DialogActionType.values().length];
            r100[DialogActionType.Primary.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[DialogActionType.Secondary.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[DialogActionType.Error.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f444175a = r100;
        }
    }

    public static EnumEntries<DialogActionType> getEntries() {
        return f444174b;
    }

    static {
        DialogActionType r100 = new DialogActionType("Primary", 0);
        Primary = r100;
        DialogActionType r101 = new DialogActionType("Secondary", 1);
        Secondary = r101;
        DialogActionType r102 = new DialogActionType("Error", 2);
        Error = r102;
        DialogActionType[] r103 = {r100, r101, r102};
        f444173a = r103;
        f444174b = EnumEntriesKt.enumEntries(r103);
    }

    public static DialogActionType[] values() {
        return (DialogActionType[]) f444173a.clone();
    }

    public final String getPath() {
        int r100 = a.f444175a[ordinal()];
        if (r100 != 1) goto L5;
        return "primary";
    L5:
        if (r100 != 2) goto L7;
        return "secondary";
    L7:
        if (r100 != 3) goto L10;
        return "error";
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static DialogActionType valueOf(String r100) {
        return (DialogActionType) r27.a.a(DialogActionType.class, r100);
    }

    public DialogActionType(String r100, int r101) {
        super(r100, r101);
    }
}
