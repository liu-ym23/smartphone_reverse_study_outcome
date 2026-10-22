package com.ss.android.lark.todo.impl.features.detail.dependent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/dependent/DependentValue$EnterSearchScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEPENDENT_DIALOG", "MORE_MENU", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DependentValue$EnterSearchScene extends Enum<DependentValue$EnterSearchScene> {
    public static final a Companion = null;
    public static final DependentValue$EnterSearchScene DEPENDENT_DIALOG = null;
    public static final DependentValue$EnterSearchScene MORE_MENU = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DependentValue$EnterSearchScene[] f443046a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f443047b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<DependentValue$EnterSearchScene> getEntries() {
        return f443047b;
    }

    static {
        DependentValue$EnterSearchScene r100 = new DependentValue$EnterSearchScene("DEPENDENT_DIALOG", 0, 1);
        DEPENDENT_DIALOG = r100;
        DependentValue$EnterSearchScene r101 = new DependentValue$EnterSearchScene("MORE_MENU", 1, 2);
        MORE_MENU = r101;
        DependentValue$EnterSearchScene[] r102 = {r100, r101};
        f443046a = r102;
        f443047b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static DependentValue$EnterSearchScene[] values() {
        return (DependentValue$EnterSearchScene[]) f443046a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DependentValue$EnterSearchScene valueOf(String r100) {
        return (DependentValue$EnterSearchScene) r27.a.a(DependentValue$EnterSearchScene.class, r100);
    }

    public DependentValue$EnterSearchScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
