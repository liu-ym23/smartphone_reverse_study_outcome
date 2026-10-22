package oa;

import android.net.Uri;
import com.bytedance.android.anniex.lite.flow.base.dispatch.FlowTaskType;
import com.lynx.tasm.TemplateData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlowTaskType f522514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f522515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f522516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Uri f522517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TemplateData f522518e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f522514a == r101.f522514a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f522515b, r101.f522515b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f522516c, r101.f522516c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f522517d, r101.f522517d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f522518e, r101.f522518e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f522514a.hashCode() * 31) + this.f522515b.hashCode()) * 31) + this.f522516c.hashCode()) * 31) + this.f522517d.hashCode()) * 31;
        TemplateData r101 = this.f522518e;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "LoadFlowTask(taskType=" + this.f522514a + ", bid=" + this.f522515b + ", sessionId=" + this.f522516c + ", uri=" + this.f522517d + ", initData=" + this.f522518e + ')';
    }

    public b(FlowTaskType r100, String r101, String r102, Uri r103) {
        Intrinsics.checkNotNullParameter(r100, "taskType");
        Intrinsics.checkNotNullParameter(r101, "bid");
        Intrinsics.checkNotNullParameter(r102, "sessionId");
        Intrinsics.checkNotNullParameter(r103, "uri");
        this.f522514a = r100;
        this.f522515b = r101;
        this.f522516c = r102;
        this.f522517d = r103;
        this.f522518e = null;
    }
}
