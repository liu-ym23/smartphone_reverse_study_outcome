package fz7;

import com.bytedance.ee.bear.bitable.msgcenter.UniversalCardWrapper;
import com.bytedance.ee.bear.bitable.msgcenter.UniversalCardWrapper$render$1$getOpenUrlService$1;
import com.larksuite.component.card.protocol.context.CardStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f479390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f479391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f479392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC5971a f479393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CardStyle f479394e;

    /* JADX INFO: renamed from: fz7.a$a, reason: collision with other inner class name */
    public interface InterfaceC5971a {
        UniversalCardWrapper$render$1$getOpenUrlService$1 getOpenUrlService();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f479390a, r101.f479390a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f479391b, r101.f479391b) == true) goto L15;
        return false;
    L15:
        if (this.f479392c == r101.f479392c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f479393d, r101.f479393d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f479394e, r101.f479394e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f479390a.hashCode() * 31) + this.f479391b.hashCode()) * 31;
        if (this.f479392c == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        InterfaceC5971a r103 = this.f479393d;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return ((r102 + r104) * 31) + this.f479394e.hashCode();
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "CardRenderEntityConfig(businessType=" + this.f479390a + ", scene=" + this.f479391b + ", asyncRender=" + this.f479392c + ", dependency=" + this.f479393d + ", cardStyle=" + this.f479394e + ')';
    }

    public a(UniversalCardWrapper.a r100, CardStyle r101) {
        Intrinsics.checkNotNullParameter("base", "businessType");
        Intrinsics.checkNotNullParameter("message_center", "scene");
        Intrinsics.checkNotNullParameter(r101, "cardStyle");
        this.f479390a = "base";
        this.f479391b = "message_center";
        this.f479392c = false;
        this.f479393d = r100;
        this.f479394e = r101;
    }
}
