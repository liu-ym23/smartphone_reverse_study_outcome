package y6b;

import com.ss.android.lark.biz.im.api.n0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements y28.b<f>, n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f566547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f566548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f566549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f566550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CharSequence f566551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f566552f;

    public static final class a extends n0.a {
        public a() {
        }
    }

    @Override // com.ss.android.lark.biz.im.api.n0
    public final String a() {
        return this.f566550d;
    }

    @Override // com.ss.android.lark.biz.im.api.n0
    public final int b() {
        return this.f566552f;
    }

    @Override // com.ss.android.lark.biz.im.api.n0
    public final String c() {
        return this.f566548b;
    }

    @Override // com.ss.android.lark.biz.im.api.n0
    public final String d() {
        return this.f566549c;
    }

    @Override // com.ss.android.lark.biz.im.api.n0
    public final CharSequence getMessageContent() {
        return this.f566551e;
    }

    @Override // com.ss.android.lark.biz.im.api.n0
    public final String getMessageId() {
        return this.f566547a;
    }

    public f(a r100) {
        this.f566547a = r100.f410414a;
        this.f566548b = r100.f410415b;
        this.f566549c = r100.f410416c;
        this.f566550d = r100.f410417d;
        this.f566551e = r100.f410418e;
        this.f566552f = r100.f410419f;
    }

    @Override // y28.b
    public final boolean isContentSame(y28.b r100) {
        f r101 = (f) r100;
        String r102 = this.f566547a;
        CharSequence r103 = null;
        if (r101 == null) goto L5;
        String r104 = r101.f566547a;
    L7:
        if (Intrinsics.areEqual(r102, r104) == false) goto L14;
        CharSequence r105 = this.f566551e;
        if (r101 == null) goto L12;
        r103 = r101.f566551e;
    L12:
        if (Intrinsics.areEqual(r105, r103) == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        r104 = null;
        goto L7
    }

    @Override // y28.b
    public final /* bridge */ /* synthetic */ boolean isItemSame(y28.b r100) {
        f r101 = (f) r100;
        return true;
    }
}
