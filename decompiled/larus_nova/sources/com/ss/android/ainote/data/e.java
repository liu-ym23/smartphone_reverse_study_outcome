package com.ss.android.ainote.data;

import com.ss.android.ainote.model.AINoteContentState;
import com.ss.android.ainote.model.AINoteCreateSource;
import com.ss.android.ainote.model.AINoteType;
import com.ss.android.lark.pb.entities.RichText;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f406715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f406716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f406717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AINoteType f406718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f406719e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AINoteContentState f406720f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AINoteCreateSource f406721g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f406722h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f406723i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f406724j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f406725k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f406726l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f406727m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final RichText f406728n;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f406715a == r101.f406715a) goto L12;
        return false;
    L12:
        if (this.f406716b == r101.f406716b) goto L15;
        return false;
    L15:
        if (this.f406717c == r101.f406717c) goto L18;
        return false;
    L18:
        if (this.f406718d == r101.f406718d) goto L21;
        return false;
    L21:
        if (this.f406719e == r101.f406719e) goto L24;
        return false;
    L24:
        if (this.f406720f == r101.f406720f) goto L27;
        return false;
    L27:
        if (this.f406721g == r101.f406721g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f406722h, r101.f406722h) == true) goto L33;
        return false;
    L33:
        if (this.f406723i == r101.f406723i) goto L36;
        return false;
    L36:
        if (this.f406724j == r101.f406724j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f406725k, r101.f406725k) == true) goto L42;
        return false;
    L42:
        if (this.f406726l == r101.f406726l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f406727m, r101.f406727m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f406728n, r101.f406728n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f406715a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f406716b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f406717c;
        int r105 = (((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.f406718d.hashCode()) * 31;
        if (this.f406719e == false) goto L5;
        int r106 = 1231;
    L6:
        int r107 = (r105 + r106) * 31;
        AINoteContentState r108 = this.f406720f;
        int r109 = 0;
        if (r108 != null) goto L9;
        int r110 = 0;
    L10:
        int r111 = (r107 + r110) * 31;
        AINoteCreateSource r112 = this.f406721g;
        if (r112 != null) goto L13;
        int r113 = 0;
    L14:
        int r114 = (((r111 + r113) * 31) + this.f406722h.hashCode()) * 31;
        long r115 = this.f406723i;
        int r116 = (r114 + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        long r117 = this.f406724j;
        int r118 = (r116 + ((int) (r117 ^ (r117 >>> 32)))) * 31;
        String r119 = this.f406725k;
        if (r119 != null) goto L17;
        int r120 = 0;
    L18:
        long r121 = this.f406726l;
        int r122 = (((r118 + r120) * 31) + ((int) (r121 ^ (r121 >>> 32)))) * 31;
        String r123 = this.f406727m;
        if (r123 == null) goto L23;
        r109 = r123.hashCode();
    L23:
        return ((r122 + r109) * 31) + this.f406728n.hashCode();
    L17:
        r120 = r119.hashCode();
        goto L18
    L13:
        r113 = r112.hashCode();
        goto L14
    L9:
        r110 = r108.hashCode();
        goto L10
    L5:
        r106 = 1237;
        goto L6
    }

    public final String toString() {
        return "CreateNoteParam(cid=" + this.f406715a + ", cTime=" + this.f406716b + ", version=" + this.f406717c + ", noteType=" + this.f406718d + ", liveRewritingEnabled=" + this.f406719e + ", contentState=" + this.f406720f + ", createSource=" + this.f406721g + ", imageTokens=" + this.f406722h + ", createRelMeetingTime=" + this.f406723i + ", createRelAudioTime=" + this.f406724j + ", markId=" + this.f406725k + ", audioLocationTime=" + this.f406726l + ", inputMarkdown=" + this.f406727m + ", inputRichText=" + this.f406728n + ')';
    }

    public e(long r100, long r101, long r110, AINoteType r111, boolean r112, AINoteContentState r113, AINoteCreateSource r114, List<String> r115, long r116, long r210, String r211, long r212, String r213, RichText r214) {
        Intrinsics.checkNotNullParameter(r111, "noteType");
        Intrinsics.checkNotNullParameter(r115, "imageTokens");
        Intrinsics.checkNotNullParameter(r214, "inputRichText");
        this.f406715a = r100;
        this.f406716b = r101;
        this.f406717c = r110;
        this.f406718d = r111;
        this.f406719e = r112;
        this.f406720f = r113;
        this.f406721g = r114;
        this.f406722h = r115;
        this.f406723i = r116;
        this.f406724j = r210;
        this.f406725k = r211;
        this.f406726l = r212;
        this.f406727m = r213;
        this.f406728n = r214;
    }
}
