package gl8;

import com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.g;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.ThinkingBlock;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f481599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Block f481600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThinkingBlock f481601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f481602d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f481603e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<jc8.a> f481604f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g f481605g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f481599a, r101.f481599a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f481600b, r101.f481600b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f481601c, r101.f481601c) == true) goto L18;
        return false;
    L18:
        if (this.f481602d == r101.f481602d) goto L21;
        return false;
    L21:
        if (this.f481603e == r101.f481603e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f481604f, r101.f481604f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f481605g, r101.f481605g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        Message r100 = this.f481599a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Block r104 = this.f481600b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        ThinkingBlock r107 = this.f481601c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        int r110 = 1231;
        if (this.f481602d == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.f481603e == true) goto L22;
        r110 = 1237;
    L22:
        int r113 = (((r112 + r110) * 31) + this.f481604f.hashCode()) * 31;
        g r114 = this.f481605g;
        if (r114 == null) goto L27;
        r101 = r114.hashCode();
    L27:
        return r113 + r101;
    L17:
        r111 = 1237;
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FloatingThinkVMData(message=" + this.f481599a + ", block=" + this.f481600b + ", thinkingBlock=" + this.f481601c + ", isDeepThinkTyping=" + this.f481602d + ", isLoadingFullMessage=" + this.f481603e + ", childrenBlocks=" + this.f481604f + ", blockBizModel=" + this.f481605g + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Message r100, Block r101, ThinkingBlock r102, boolean r103, boolean r104, List<? extends jc8.a> r105, g r106) {
        Intrinsics.checkNotNullParameter(r105, "childrenBlocks");
        this.f481599a = r100;
        this.f481600b = r101;
        this.f481601c = r102;
        this.f481602d = r103;
        this.f481603e = r104;
        this.f481604f = r105;
        this.f481605g = r106;
    }
}
