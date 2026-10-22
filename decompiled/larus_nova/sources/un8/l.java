package un8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.TaskCardBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f550877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f550878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Message f550879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TaskCardBlock f550880d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f550877a == r101.f550877a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f550878b, r101.f550878b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f550879c, r101.f550879c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f550880d, r101.f550880d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f550877a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f550878b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        Message r106 = this.f550879c;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        TaskCardBlock r109 = this.f550880d;
        if (r109 == null) goto L19;
        r103 = r109.hashCode();
    L19:
        return r108 + r103;
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "TaskCardViewInput(isFinished=" + this.f550877a + ", botId=" + this.f550878b + ", message=" + this.f550879c + ", taskCardBlock=" + this.f550880d + ')';
    }

    public l(boolean r100, String r101, Message r102, TaskCardBlock r103) {
        this.f550877a = r100;
        this.f550878b = r101;
        this.f550879c = r102;
        this.f550880d = r103;
    }
}
