package com.larus.chat.gallery.impl.preview.toolbar.action;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.larus.chat.gallery.impl.preview.toolbar.PreviewToolbarView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xy8.d f324766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f324767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FragmentManager f324768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f324769d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.larus.gallery.api.w f324770e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PreviewToolbarView f324771f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f324772g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final xy8.a f324773h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f324774i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f324775j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r101 = (l0) r100;
        if (Intrinsics.areEqual(this.f324766a, r101.f324766a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f324767b, r101.f324767b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f324768c, r101.f324768c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f324769d, r101.f324769d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f324770e, r101.f324770e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f324771f, r101.f324771f) == true) goto L27;
        return false;
    L27:
        if (this.f324772g == r101.f324772g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f324773h, r101.f324773h) == true) goto L33;
        return false;
    L33:
        if (this.f324774i == r101.f324774i) goto L36;
        return false;
    L36:
        if (this.f324775j == r101.f324775j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f324766a.hashCode() * 31) + this.f324767b.hashCode()) * 31) + this.f324768c.hashCode()) * 31) + this.f324769d.hashCode()) * 31) + this.f324770e.hashCode()) * 31;
        PreviewToolbarView r101 = this.f324771f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        int r105 = 1231;
        if (this.f324772g == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r104 + r106) * 31;
        xy8.a r108 = this.f324773h;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        int r109 = (r107 + r102) * 31;
        if (this.f324774i == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        if (this.f324775j == true) goto L23;
        r105 = 1237;
    L23:
        return r111 + r105;
    L17:
        r110 = 1237;
        goto L18
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ToolbarActionContext(data=" + this.f324766a + ", lifecycleScope=" + this.f324767b + ", fragmentManager=" + this.f324768c + ", context=" + this.f324769d + ", mediator=" + this.f324770e + ", toolbarView=" + this.f324771f + ", publishInSharePanel=" + this.f324772g + ", toolbarCapability=" + this.f324773h + ", isFromOverflow=" + this.f324774i + ", isFromSharePanel=" + this.f324775j + ')';
    }

    public final Context getContext() {
        return this.f324769d;
    }

    public l0(xy8.d r100, CoroutineScope r101, FragmentManager r102, Context r103, com.larus.gallery.api.w r104, PreviewToolbarView r105, boolean r106, xy8.a r107, boolean r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "lifecycleScope");
        Intrinsics.checkNotNullParameter(r102, "fragmentManager");
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "mediator");
        this.f324766a = r100;
        this.f324767b = r101;
        this.f324768c = r102;
        this.f324769d = r103;
        this.f324770e = r104;
        this.f324771f = r105;
        this.f324772g = r106;
        this.f324773h = r107;
        this.f324774i = r110;
        this.f324775j = r111;
    }
}
