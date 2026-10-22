package com.bytedance.ee.bear.bitable.celleditor.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/bean/EditorOperation;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "Open", "Close", "UpdatePatch", "UpdateAll", "NativeAction", "ShowMenu", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EditorOperation extends Enum<EditorOperation> {
    public static final EditorOperation Close = null;
    public static final a Companion = null;
    public static final EditorOperation NativeAction = null;
    public static final EditorOperation Open = null;
    public static final EditorOperation ShowMenu = null;
    public static final EditorOperation UNKNOWN = null;
    public static final EditorOperation UpdateAll = null;
    public static final EditorOperation UpdatePatch = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EditorOperation[] f209320a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f209321b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<EditorOperation> getEntries() {
        return f209321b;
    }

    static {
        EditorOperation r100 = new EditorOperation("UNKNOWN", 0, -1);
        UNKNOWN = r100;
        EditorOperation r101 = new EditorOperation("Open", 1, 1);
        Open = r101;
        EditorOperation r102 = new EditorOperation("Close", 2, 2);
        Close = r102;
        EditorOperation r103 = new EditorOperation("UpdatePatch", 3, 3);
        UpdatePatch = r103;
        EditorOperation r104 = new EditorOperation("UpdateAll", 4, 4);
        UpdateAll = r104;
        EditorOperation r105 = new EditorOperation("NativeAction", 5, 5);
        NativeAction = r105;
        EditorOperation r110 = new EditorOperation("ShowMenu", 6, 6);
        ShowMenu = r110;
        EditorOperation[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f209320a = r111;
        f209321b = EnumEntriesKt.enumEntries(r111);
        Companion = new a();
    }

    public static EditorOperation[] values() {
        return (EditorOperation[]) f209320a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static EditorOperation valueOf(String r100) {
        return (EditorOperation) r27.a.a(EditorOperation.class, r100);
    }

    public EditorOperation(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
