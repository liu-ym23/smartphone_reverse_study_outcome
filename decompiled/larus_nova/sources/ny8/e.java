package ny8;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.larus.canvas.service.bean.IImageInfo;
import com.larus.canvas.service.bean.InstructionTabInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f521214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f521215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f521216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IImageInfo f521217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InstructionTabInfo f521218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f521219f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f521220g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f521221h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f521214a, r101.f521214a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f521215b, r101.f521215b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f521216c, r101.f521216c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f521217d, r101.f521217d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f521218e, r101.f521218e) == true) goto L24;
        return false;
    L24:
        if (this.f521219f == r101.f521219f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f521220g, r101.f521220g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f521221h, r101.f521221h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f521214a.hashCode() * 31;
        String r101 = this.f521215b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f521216c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        IImageInfo r108 = this.f521217d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        InstructionTabInfo r111 = this.f521218e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        if (this.f521219f == false) goto L21;
        int r114 = 1231;
    L22:
        int r115 = (r113 + r114) * 31;
        Bundle r116 = this.f521220g;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f521221h;
        if (r119 == null) goto L31;
        r102 = r119.hashCode();
    L31:
        return r118 + r102;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = 1237;
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
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
        return "GenImageConfig(context=" + this.f521214a + ", prompt=" + this.f521215b + ", title=" + this.f521216c + ", imageInfo=" + this.f521217d + ", instructionTabInfo=" + this.f521218e + ", requireImage=" + this.f521219f + ", extraParams=" + this.f521220g + ", conversationId=" + this.f521221h + ')';
    }

    public final Context getContext() {
        return this.f521214a;
    }

    public e(FragmentActivity r100, String r101, IImageInfo r102, Bundle r103, String r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r101 = null;
    L6:
        if ((r105 & 8) == 0) goto L9;
        r102 = null;
    L9:
        if ((r105 & 64) == 0) goto L12;
        r103 = null;
    L12:
        if ((r105 & 128) == 0) goto L14;
        r104 = null;
    L14:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f521214a = r100;
        this.f521215b = null;
        this.f521216c = r101;
        this.f521217d = r102;
        this.f521218e = null;
        this.f521219f = false;
        this.f521220g = r103;
        this.f521221h = r104;
    }
}
