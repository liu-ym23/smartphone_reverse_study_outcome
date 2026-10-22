package lq8;

import com.larus.bmhome.interactionpanel.InteractionPanelType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InteractionPanelType f510326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Block f510327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Message f510328c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f510326a == r101.f510326a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f510327b, r101.f510327b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f510328c, r101.f510328c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f510326a.hashCode() * 31) + this.f510327b.hashCode()) * 31) + this.f510328c.hashCode();
    }

    public final String toString() {
        return "ResolvedInteractionPanelBlock(type=" + this.f510326a + ", block=" + this.f510327b + ", message=" + this.f510328c + ')';
    }

    public final InteractionPanelType getType() {
        return this.f510326a;
    }

    public e(InteractionPanelType r100, Block r101, Message r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "block");
        Intrinsics.checkNotNullParameter(r102, "message");
        this.f510326a = r100;
        this.f510327b = r101;
        this.f510328c = r102;
    }
}
