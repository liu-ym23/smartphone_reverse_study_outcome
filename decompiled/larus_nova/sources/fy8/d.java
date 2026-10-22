package fy8;

import com.larus.canvas.feature.ability.CanvasEditorEventType;
import com.larus.canvas.service.bean.InstructionTab;
import com.larus.canvas.service.bean.OptionItem;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CanvasEditorEventType f479298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f479299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InstructionTab f479300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OptionItem f479301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f479302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m f479303f;

    public d() {
        this(null, null, null, null, null, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f479298a == r101.f479298a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f479299b, r101.f479299b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f479300c, r101.f479300c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f479301d, r101.f479301d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f479302e, r101.f479302e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(null, null) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f479303f, r101.f479303f) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f479298a.hashCode() * 31) + this.f479299b.hashCode()) * 31;
        InstructionTab r101 = this.f479300c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        OptionItem r105 = this.f479301d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        a r108 = this.f479302e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((r107 + r109) * 31) + 0) * 31;
        m r111 = this.f479303f;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CanvasEditorEvent(eventType=" + this.f479298a + ", prompt=" + this.f479299b + ", instructionTab=" + this.f479300c + ", optionItem=" + this.f479301d + ", bottomInsetUpdateInfo=" + this.f479302e + ", instructionRenderInfo=null, selectorPanelStatusChangeInfo=" + this.f479303f + ')';
    }

    public d(CanvasEditorEventType r100, String r101, InstructionTab r102, OptionItem r103, a r104, m r105, int r106) {
        if ((r106 & 1) == 0) goto L6;
        r100 = CanvasEditorEventType.NONE;
    L6:
        if ((r106 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r106 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r106 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r106 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r106 & 64) == 0) goto L20;
        r105 = null;
    L20:
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.RETAIN_PROMPT);
        this.f479298a = r100;
        this.f479299b = r101;
        this.f479300c = r102;
        this.f479301d = r103;
        this.f479302e = r104;
        this.f479303f = r105;
    }
}
