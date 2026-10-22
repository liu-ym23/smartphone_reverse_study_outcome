package pea;

import android.content.Intent;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.google.gson.JsonObject;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.live.gr.island.island.template.GRExpandedDialogueTemplate;
import com.obric.assistant.live.gr.island.island.template.GRExpandedNormalTemplate;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f528827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f528828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f528829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JsonObject f528830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f528831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Intent f528832f;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f528827a, r101.f528827a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528828b, r101.f528828b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f528829c, r101.f528829c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f528830d, r101.f528830d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f528831e, r101.f528831e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f528832f, r101.f528832f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f528827a.hashCode() * 31) + this.f528828b.hashCode()) * 31;
        Boolean r101 = this.f528829c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        JsonObject r105 = this.f528830d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.f528831e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Intent r111 = this.f528832f;
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
        return "GRIslandWidget(templateId=" + this.f528827a + ", templateData=" + this.f528828b + ", isDefault=" + this.f528829c + ", ext=" + this.f528830d + ", intentType=" + this.f528831e + ", intent=" + this.f528832f + ')';
    }

    public final void a(String r100, Intent r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "intent");
        l r102 = this.f528828b;
        if ((r102 instanceof GRExpandedNormalTemplate) == false) goto L11;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.obric.assistant.live.gr.island.island.template.GRExpandedNormalTemplate");
        Iterator<T> r103 = ((GRExpandedNormalTemplate) r102).m8580getActions().iterator();
    L6:
        if (r103.hasNext() == false) goto L29;
        h r104 = (h) r103.next();
        if (Intrinsics.areEqual(r104.f528785c, r100) == false) goto L6;
        r104.f528786d = r101;
        FLogger.f375446a.d("XiaomiIslandWidget", "setActionIntent: XiaomiExpandedTemplate16 " + r100 + ", " + r101);
        goto L6
    L29:
        return;
    L11:
        if ((r102 instanceof GRExpandedDialogueTemplate) == false) goto L18;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.obric.assistant.live.gr.island.island.template.GRExpandedDialogueTemplate");
        Iterator<T> r105 = ((GRExpandedDialogueTemplate) r102).getTextButton().iterator();
    L14:
        if (r105.hasNext() == false) goto L30;
        e r106 = (e) r105.next();
        if (Intrinsics.areEqual(r106.f528755b, r100) == false) goto L14;
        r106.f528756c = r101;
        FLogger.f375446a.d("XiaomiIslandWidget", "setActionIntent: XiaomiExpandedTemplate17 " + r100 + ", " + r101);
        goto L14
    L30:
        return;
    }

    public k(String r100, l r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TEMPLATE_ID);
        Intrinsics.checkNotNullParameter(r101, "templateData");
        this.f528827a = r100;
        this.f528828b = r101;
        this.f528829c = r102;
        this.f528830d = null;
        this.f528831e = null;
        this.f528832f = null;
    }
}
