package we9;

import com.larus.im.service.audio.ModalType;
import com.larus.im.service.audio.cmd.TargetVideoSourceType;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class i implements xe9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ve9.d f559432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ModalType f559433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TargetVideoSourceType f559434c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f559432a, r101.f559432a) == true) goto L12;
        return false;
    L12:
        if (this.f559433b == r101.f559433b) goto L15;
        return false;
    L15:
        if (this.f559434c == r101.f559434c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f559432a.hashCode() * 31) + this.f559433b.hashCode()) * 31) + this.f559434c.hashCode();
    }

    public final String toString() {
        return "SwitchModal(chatConfig=" + this.f559432a + ", target=" + this.f559433b + ", sourceType=" + this.f559434c + ')';
    }

    public i(ve9.d r100, ModalType r101, TargetVideoSourceType r102) {
        Intrinsics.checkNotNullParameter(r100, "chatConfig");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r102, "sourceType");
        this.f559432a = r100;
        this.f559433b = r101;
        this.f559434c = r102;
    }
}
