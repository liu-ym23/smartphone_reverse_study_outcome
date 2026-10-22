package com.ss.android.lark.keyboard.base;

import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.entity.message.content.AtAIKnowledgeSourceClient;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f428249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f428250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RichText f428251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PartialReplyInfo f428252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f428253e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f428254f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final s5c.d f428255g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<k> f428256h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtAIKnowledgeSourceClient f428257i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public r f428258j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f428249a, r101.f428249a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f428250b, r101.f428250b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f428251c, r101.f428251c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f428252d, r101.f428252d) == true) goto L21;
        return false;
    L21:
        if (this.f428253e == r101.f428253e) goto L24;
        return false;
    L24:
        if (this.f428254f == r101.f428254f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f428255g, r101.f428255g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f428256h, r101.f428256h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f428257i, r101.f428257i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f428258j, r101.f428258j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f428249a.hashCode() * 31) + this.f428250b.hashCode()) * 31) + this.f428251c.hashCode()) * 31;
        PartialReplyInfo r101 = this.f428252d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        int r105 = 1231;
        if (this.f428253e == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r104 + r106) * 31;
        if (this.f428254f == true) goto L14;
        r105 = 1237;
    L14:
        int r108 = (r107 + r105) * 31;
        s5c.d r109 = this.f428255g;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        List<k> r112 = this.f428256h;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        AtAIKnowledgeSourceClient r115 = this.f428257i;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        r r118 = this.f428258j;
        if (r118 == null) goto L31;
        r102 = r118.hashCode();
    L31:
        return r117 + r102;
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "SendInfo(title=" + this.f428249a + ", content=" + this.f428250b + ", richText=" + this.f428251c + ", partialReplyInfo=" + this.f428252d + ", hasSmartReply=" + this.f428253e + ", isAIQuery=" + this.f428254f + ", extras=" + this.f428255g + ", hitPointHandlers=" + this.f428256h + ", source=" + this.f428257i + ", sendInfoExtraParam=" + this.f428258j + ')';
    }

    public static q a(q r110, String r111, RichText r112, int r113) {
        r r100 = null;
        if ((r113 & 1) == 0) goto L5;
        String r101 = r110.f428249a;
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r102 = r110.f428250b;
    L11:
        if ((r113 & 4) == 0) goto L13;
        RichText r103 = r110.f428251c;
    L15:
        if ((r113 & 8) == 0) goto L17;
        PartialReplyInfo r104 = r110.f428252d;
    L19:
        if ((r113 & 16) == 0) goto L21;
        boolean r105 = r110.f428253e;
    L23:
        if ((r113 & 32) == 0) goto L25;
        boolean r114 = r110.f428254f;
    L27:
        if ((r113 & 64) == 0) goto L29;
        s5c.d r115 = r110.f428255g;
    L31:
        if ((r113 & 128) == 0) goto L33;
        List<k> r116 = r110.f428256h;
    L35:
        if ((r113 & 256) == 0) goto L37;
        AtAIKnowledgeSourceClient r117 = r110.f428257i;
    L39:
        if ((r113 & 512) == 0) goto L41;
        r100 = r110.f428258j;
    L41:
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "content");
        Intrinsics.checkNotNullParameter(r103, "richText");
        return new q(r101, r102, r103, r104, r105, r114, r115, r116, r117, r100);
    L37:
        r117 = null;
        goto L39
    L33:
        r116 = null;
        goto L35
    L29:
        r115 = null;
        goto L31
    L25:
        r114 = false;
        goto L27
    L21:
        r105 = false;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public /* synthetic */ q(String r110, String r111, RichText r112, PartialReplyInfo r113, boolean r114, s5c.d r115, List r116) {
        this(r110, r111, r112, r113, false, r114, r115, r116, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q(String r100, String r101, RichText r102, PartialReplyInfo r103, boolean r104, boolean r105, s5c.d r106, List<? extends k> r107, AtAIKnowledgeSourceClient r110, r r111) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, "richText");
        this.f428249a = r100;
        this.f428250b = r101;
        this.f428251c = r102;
        this.f428252d = r103;
        this.f428253e = r104;
        this.f428254f = r105;
        this.f428255g = r106;
        this.f428256h = r107;
        this.f428257i = r110;
        this.f428258j = r111;
    }
}
