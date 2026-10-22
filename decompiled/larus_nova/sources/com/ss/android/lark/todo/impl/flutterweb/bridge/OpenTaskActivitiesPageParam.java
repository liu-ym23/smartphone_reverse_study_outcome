package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.ss.android.lark.diskmanage.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u0003H\u0016J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/bridge/OpenTaskActivitiesPageParam;", "Lcom/ss/android/lark/diskmanage/NonProguard;", "guid", "", "scene", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getGuid", "()Ljava/lang/String;", "getScene", "toString", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenTaskActivitiesPageParam implements NonProguard {
    private final String guid;
    private final String scene;

    public static /* synthetic */ OpenTaskActivitiesPageParam copy$default(OpenTaskActivitiesPageParam r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.guid;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.scene;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.guid;
    }

    public final String component2() {
        return this.scene;
    }

    public final OpenTaskActivitiesPageParam copy(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "guid");
        Intrinsics.checkNotNullParameter(r101, "scene");
        return new OpenTaskActivitiesPageParam(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OpenTaskActivitiesPageParam) == true) goto L8;
        return false;
    L8:
        OpenTaskActivitiesPageParam r101 = (OpenTaskActivitiesPageParam) r100;
        if (Intrinsics.areEqual(this.guid, r101.guid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.guid.hashCode() * 31) + this.scene.hashCode();
    }

    public String toString() {
        return "OpenTaskActivitiesPageParam(guid='" + this.guid + "', scene='" + this.scene + "')";
    }

    public final String getGuid() {
        return this.guid;
    }

    public final String getScene() {
        return this.scene;
    }

    public OpenTaskActivitiesPageParam(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "guid");
        Intrinsics.checkNotNullParameter(r101, "scene");
        this.guid = r100;
        this.scene = r101;
    }
}
