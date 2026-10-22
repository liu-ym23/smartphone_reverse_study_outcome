package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiAction;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f242400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WikiAction f242401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f242402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f242403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f242404e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f242405f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f242406g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f242400a, r101.f242400a) == true) goto L12;
        return false;
    L12:
        if (this.f242401b == r101.f242401b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f242402c, r101.f242402c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f242403d, r101.f242403d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f242404e, r101.f242404e) == true) goto L24;
        return false;
    L24:
        if (this.f242405f == r101.f242405f) goto L27;
        return false;
    L27:
        if (this.f242406g == r101.f242406g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        FragmentActivity r100 = this.f242400a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((((((((r101 * 31) + this.f242401b.hashCode()) * 31) + this.f242402c.hashCode()) * 31) + this.f242403d.hashCode()) * 31) + this.f242404e.hashCode()) * 31;
        if (this.f242405f == false) goto L9;
        int r103 = 1231;
    L11:
        return ((r102 + r103) * 31) + this.f242406g;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DelErrorInfo(context=" + this.f242400a + ", wikiAction=" + this.f242401b + ", throwable=" + this.f242402c + ", wikiToken=" + this.f242403d + ", spaceId=" + this.f242404e + ", isDeleteWithSub=" + this.f242405f + ", defaultErrRes=" + this.f242406g + ')';
    }

    public final FragmentActivity getContext() {
        return this.f242400a;
    }

    public a(FragmentActivity r110, WikiAction r111, Throwable r112, String r113, String r114, boolean r115) {
        Intrinsics.checkNotNullParameter(r111, "wikiAction");
        Intrinsics.checkNotNullParameter(r112, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r113, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r114, "spaceId");
        this(r110, r111, r112, r113, r114, r115, R.string.CreationMobile_Wiki_CannotRemove_Toast);
    }

    public a(FragmentActivity r100, WikiAction r101, Throwable r102, String r103, String r104, boolean r105, int r106) {
        Intrinsics.checkNotNullParameter(r101, "wikiAction");
        Intrinsics.checkNotNullParameter(r102, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r103, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r104, "spaceId");
        this.f242400a = r100;
        this.f242401b = r101;
        this.f242402c = r102;
        this.f242403d = r103;
        this.f242404e = r104;
        this.f242405f = r105;
        this.f242406g = r106;
    }
}
