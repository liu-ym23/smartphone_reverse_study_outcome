package hq8;

import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.google.android.material.tabs.TabLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f486515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TabLayout f486516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f486517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f486518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f486519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f486520f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f486515a, r101.f486515a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486516b, r101.f486516b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f486517c, r101.f486517c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f486518d, r101.f486518d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f486519e, r101.f486519e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f486520f, r101.f486520f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f486515a.hashCode() * 31) + this.f486516b.hashCode()) * 31) + this.f486517c.hashCode()) * 31) + this.f486518d.hashCode()) * 31) + this.f486519e.hashCode()) * 31) + this.f486520f.hashCode();
    }

    public final String toString() {
        return "MultiTabViewCollector(root=" + this.f486515a + ", tlSwitchTab=" + this.f486516b + ", tvEditorTitle=" + this.f486517c + ", btnEditorClose=" + this.f486518d + ", flAttachmentArea=" + this.f486519e + ", flEditorInstruction=" + this.f486520f + ')';
    }

    public a(ConstraintLayout r100, TabLayout r101, AppCompatTextView r102, AppCompatImageView r103, FrameLayout r104, FrameLayout r105) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, "tlSwitchTab");
        Intrinsics.checkNotNullParameter(r102, "tvEditorTitle");
        Intrinsics.checkNotNullParameter(r103, "btnEditorClose");
        Intrinsics.checkNotNullParameter(r104, "flAttachmentArea");
        Intrinsics.checkNotNullParameter(r105, "flEditorInstruction");
        this.f486515a = r100;
        this.f486516b = r101;
        this.f486517c = r102;
        this.f486518d = r103;
        this.f486519e = r104;
        this.f486520f = r105;
    }
}
