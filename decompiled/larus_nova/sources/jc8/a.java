package jc8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes25.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Block f498145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Message f498146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f498147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f498148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ra8.b f498149e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f498150f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f498151g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<a> f498152h;

    public final List<a> i() {
        return CollectionsKt.toList(this.f498152h);
    }

    public final Message j() {
        Message r100 = this.f498146b;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("This Block model was created without a legacy Message".toString());
    }

    public final a k() {
        f r100 = this.f498148d;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f498160a;
    }

    public final boolean m() {
        f r100 = this.f498148d;
        if (r100 == null) goto L5;
        a r101 = r100.f498160a;
    L6:
        if (r101 != null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r101 = null;
        goto L6
    }

    public final boolean n() {
        f r100 = this.f498148d;
        if (r100 == null) goto L5;
        a r101 = r100.f498161b;
    L6:
        if (r101 != null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r101 = null;
        goto L6
    }

    public String g() {
        String r100 = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public String h() {
        return this.f498151g;
    }

    public int l() {
        return this.f498150f;
    }

    public boolean e(a r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.f498145a.hashCode() != r100.f498145a.hashCode()) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean f(a r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        long r101 = this.f498147c;
        if (r101 <= 0) goto L11;
        if (r100.f498147c > 0) goto L11;
        r100.f498147c = r101;
    L11:
        if (getClass() == r100.getClass()) goto L13;
        return false;
    L13:
        if (l() == r100.l()) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f498145a.getBlockId(), r100.f498145a.getBlockId()) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public a(Block r110, Message r111) {
        Intrinsics.checkNotNullParameter(r110, "block");
        this.f498145a = r110;
        this.f498146b = r111;
        this.f498149e = new ra8.b(null, null, null, false, null, null, 127);
        this.f498150f = r110.getBlockType();
        String r112 = r110.getBlockId();
        if (r112 != null) goto L5;
        r112 = "";
    L5:
        this.f498151g = r112;
        this.f498152h = new ArrayList();
    }

    public a(Message r100, Block r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "block");
        this(r101, r100);
    }
}
