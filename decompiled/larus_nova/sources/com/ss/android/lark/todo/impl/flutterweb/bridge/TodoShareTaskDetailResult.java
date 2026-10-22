package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.ss.android.lark.diskmanage.NonProguard;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u0003H\u0016J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/bridge/TodoShareTaskDetailResult;", "Lcom/ss/android/lark/diskmanage/NonProguard;", "note", "", "chats", "", "Lcom/ss/android/lark/todo/impl/flutterweb/bridge/TodoShareTaskDetailChat;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getNote", "()Ljava/lang/String;", "getChats", "()Ljava/util/List;", "toString", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TodoShareTaskDetailResult implements NonProguard {
    private final List<d0> chats;
    private final String note;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TodoShareTaskDetailResult copy$default(TodoShareTaskDetailResult r100, String r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.note;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.chats;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.note;
    }

    public final List<d0> component2() {
        return this.chats;
    }

    public final TodoShareTaskDetailResult copy(String r100, List<d0> r101) {
        Intrinsics.checkNotNullParameter(r100, "note");
        Intrinsics.checkNotNullParameter(r101, "chats");
        return new TodoShareTaskDetailResult(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TodoShareTaskDetailResult) == true) goto L8;
        return false;
    L8:
        TodoShareTaskDetailResult r101 = (TodoShareTaskDetailResult) r100;
        if (Intrinsics.areEqual(this.note, r101.note) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.chats, r101.chats) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.note.hashCode() * 31) + this.chats.hashCode();
    }

    public String toString() {
        return "TodoShareTaskDetailResult(note='" + this.note + "', chats=" + this.chats + ')';
    }

    public final List<d0> getChats() {
        return this.chats;
    }

    public final String getNote() {
        return this.note;
    }

    public TodoShareTaskDetailResult(String r100, List<d0> r101) {
        Intrinsics.checkNotNullParameter(r100, "note");
        Intrinsics.checkNotNullParameter(r101, "chats");
        this.note = r100;
        this.chats = r101;
    }
}
