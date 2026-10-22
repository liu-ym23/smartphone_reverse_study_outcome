package pxa;

import com.ss.android.lark.biz.im.api.n0;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f530962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f530963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f530964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f530965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CharSequence f530966e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f530967f;

    public static final class a extends n0.a {
        public a() {
        }
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f530962a, this.f530966e});
    }

    @Override // com.ss.android.lark.biz.im.api.n0
    public final String a() {
        return this.f530965d;
    }

    @Override // com.ss.android.lark.biz.im.api.n0
    public final int b() {
        return this.f530967f;
    }

    @Override // com.ss.android.lark.biz.im.api.n0
    public final String c() {
        return this.f530963b;
    }

    @Override // com.ss.android.lark.biz.im.api.n0
    public final String d() {
        return this.f530964c;
    }

    @Override // com.ss.android.lark.biz.im.api.n0
    public final CharSequence getMessageContent() {
        return this.f530966e;
    }

    @Override // com.ss.android.lark.biz.im.api.n0
    public final String getMessageId() {
        return this.f530962a;
    }

    public b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f530962a = r100.f410414a;
        this.f530963b = r100.f410415b;
        this.f530964c = r100.f410416c;
        this.f530965d = r100.f410417d;
        this.f530966e = r100.f410418e;
        this.f530967f = r100.f410419f;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof b) == true) goto L5;
        return false;
    L5:
        b r101 = (b) r100;
        if (Objects.equals(this.f530962a, r101.f530962a) == true) goto L8;
        return false;
    L8:
        if (Objects.equals(this.f530966e, r101.f530966e) == false) goto L12;
        return true;
    L12:
        return false;
    }
}
