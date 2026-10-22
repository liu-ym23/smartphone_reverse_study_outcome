package com.ss.android.lark.todo.impl.flutterweb.bridge.dialog;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/bridge/dialog/DialogType;", "", "<init>", "(Ljava/lang/String;I)V", "Input", "Normal", "BizDeleteTaskList", "BizTaskComplete", "path", "", "getPath", "()Ljava/lang/String;", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DialogType extends Enum<DialogType> {
    public static final DialogType BizDeleteTaskList = null;
    public static final DialogType BizTaskComplete = null;
    public static final DialogType Input = null;
    public static final DialogType Normal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DialogType[] f444176a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f444177b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f444178a = null;

        static {
            int[] r100 = new int[DialogType.values().length];
            r100[DialogType.Input.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[DialogType.Normal.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[DialogType.BizDeleteTaskList.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[DialogType.BizTaskComplete.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f444178a = r100;
        }
    }

    public static EnumEntries<DialogType> getEntries() {
        return f444177b;
    }

    static {
        DialogType r100 = new DialogType("Input", 0);
        Input = r100;
        DialogType r101 = new DialogType("Normal", 1);
        Normal = r101;
        DialogType r102 = new DialogType("BizDeleteTaskList", 2);
        BizDeleteTaskList = r102;
        DialogType r103 = new DialogType("BizTaskComplete", 3);
        BizTaskComplete = r103;
        DialogType[] r104 = {r100, r101, r102, r103};
        f444176a = r104;
        f444177b = EnumEntriesKt.enumEntries(r104);
    }

    public static DialogType[] values() {
        return (DialogType[]) f444176a.clone();
    }

    public final String getPath() {
        int r100 = a.f444178a[ordinal()];
        if (r100 != 1) goto L5;
        return "input";
    L5:
        if (r100 != 2) goto L7;
        return "normal";
    L7:
        if (r100 != 3) goto L9;
        return "bizDeleteTaskList";
    L9:
        if (r100 != 4) goto L12;
        return "bizTaskComplete";
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public static DialogType valueOf(String r100) {
        return (DialogType) r27.a.a(DialogType.class, r100);
    }

    public DialogType(String r100, int r101) {
        super(r100, r101);
    }
}
