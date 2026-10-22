package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.ss.android.lark.diskmanage.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u0003H\u0016J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/bridge/TodoContactPickers;", "Lcom/ss/android/lark/diskmanage/NonProguard;", "id", "", "name", "avatarKey", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getAvatarKey", "getType", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TodoContactPickers implements NonProguard {
    public static final a Companion = null;
    private final String avatarKey;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f444148id;
    private final String name;
    private final String type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ TodoContactPickers copy$default(TodoContactPickers r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f444148id;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.name;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.avatarKey;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.type;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.f444148id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.avatarKey;
    }

    public final String component4() {
        return this.type;
    }

    public final TodoContactPickers copy(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "avatarKey");
        Intrinsics.checkNotNullParameter(r103, "type");
        return new TodoContactPickers(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TodoContactPickers) == true) goto L8;
        return false;
    L8:
        TodoContactPickers r101 = (TodoContactPickers) r100;
        if (Intrinsics.areEqual(this.f444148id, r101.f444148id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.avatarKey, r101.avatarKey) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f444148id.hashCode() * 31) + this.name.hashCode()) * 31) + this.avatarKey.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "TodoContactPickerResult(id='" + this.f444148id + "', name='" + this.name + "', avatarKey='" + this.avatarKey + "', type='" + this.type + "')";
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final String getId() {
        return this.f444148id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public TodoContactPickers(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "avatarKey");
        Intrinsics.checkNotNullParameter(r103, "type");
        this.f444148id = r100;
        this.name = r101;
        this.avatarKey = r102;
        this.type = r103;
    }
}
