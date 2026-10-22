package com.larus.bmhome.chat.component.bottom.multimodal;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.platform.model.action.SuggestedAction;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wc9.e f299797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ic8.n0 f299798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f299799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f299800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f299801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f299802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<Message, Function1<mr9.k, Unit>> f299803g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, String> f299804h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SuggestedAction f299805i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Pair<String, Integer> f299806j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ReferenceInfo f299807k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ChatPageContext f299808l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j1) == true) goto L8;
        return false;
    L8:
        j1 r101 = (j1) r100;
        if (Intrinsics.areEqual(this.f299797a, r101.f299797a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f299798b, r101.f299798b) == true) goto L15;
        return false;
    L15:
        if (this.f299799c == r101.f299799c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f299800d, r101.f299800d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f299801e, r101.f299801e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f299802f, r101.f299802f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f299803g, r101.f299803g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f299804h, r101.f299804h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f299805i, r101.f299805i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f299806j, r101.f299806j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f299807k, r101.f299807k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f299808l, r101.f299808l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f299797a.hashCode() * 31) + this.f299798b.hashCode()) * 31;
        if (this.f299799c == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (((r100 + r101) * 31) + this.f299800d.hashCode()) * 31;
        String r103 = this.f299801e;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((r102 + r105) * 31) + this.f299802f.hashCode()) * 31) + this.f299803g.hashCode()) * 31;
        Map<String, String> r107 = this.f299804h;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        SuggestedAction r110 = this.f299805i;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Pair<String, Integer> r113 = this.f299806j;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        ReferenceInfo r116 = this.f299807k;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        ChatPageContext r119 = this.f299808l;
        if (r119 == null) goto L31;
        r104 = r119.hashCode();
    L31:
        return r118 + r104;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "TryUploadFileOrImgParam(conversation=" + this.f299797a + ", uploadResult=" + this.f299798b + ", isImage=" + this.f299799c + ", fromScene=" + this.f299800d + ", botId=" + this.f299801e + ", fileIdentifier=" + this.f299802f + ", processCallback=" + this.f299803g + ", ext=" + this.f299804h + ", suggestedAction=" + this.f299805i + ", inputContent=" + this.f299806j + ", referenceInfo=" + this.f299807k + ", chatPageContext=" + this.f299808l + ')';
    }

    public j1(wc9.e r100, ic8.n0 r101, String r102, String r103, String r104, Function1 r105, Map r106, SuggestedAction r107, Pair r110, ReferenceInfo r111, ChatPageContext r112) {
        Intrinsics.checkNotNullParameter(r100, "conversation");
        Intrinsics.checkNotNullParameter(r101, "uploadResult");
        Intrinsics.checkNotNullParameter(r102, "fromScene");
        Intrinsics.checkNotNullParameter(r104, "fileIdentifier");
        Intrinsics.checkNotNullParameter(r105, "processCallback");
        this.f299797a = r100;
        this.f299798b = r101;
        this.f299799c = true;
        this.f299800d = r102;
        this.f299801e = r103;
        this.f299802f = r104;
        this.f299803g = r105;
        this.f299804h = r106;
        this.f299805i = r107;
        this.f299806j = r110;
        this.f299807k = r111;
        this.f299808l = r112;
    }
}
