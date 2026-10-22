package kotlinx.datetime.internal.format;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.OffsetFields$sign$1;

/* JADX INFO: loaded from: classes42.dex */
public final class w<Target> extends a<Target, Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b<Target, Integer> f505359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f505360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f505361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f505362d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f505363e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l<Target> f505364f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f505365g;

    @Override // kotlinx.datetime.internal.format.m
    public final b<Target, Integer> a() {
        return this.f505359a;
    }

    @Override // kotlinx.datetime.internal.format.m
    public final Object getDefaultValue() {
        return this.f505363e;
    }

    @Override // kotlinx.datetime.internal.format.m
    public final String getName() {
        return this.f505362d;
    }

    @Override // kotlinx.datetime.internal.format.m
    public final l<Target> getSign() {
        return this.f505364f;
    }

    public w(t r100, int r101, int r102, Integer r103, OffsetFields$sign$1 r104, int r105) {
        if ((r105 & 8) == 0) goto L5;
        String r106 = r100.getName();
    L7:
        if ((r105 & 16) == 0) goto L10;
        r103 = null;
    L10:
        if ((r105 & 32) == 0) goto L12;
        r104 = null;
    L12:
        Intrinsics.checkNotNullParameter(r100, "accessor");
        Intrinsics.checkNotNullParameter(r106, "name");
        this.f505359a = r100;
        this.f505360b = r101;
        this.f505361c = r102;
        this.f505362d = r106;
        this.f505363e = r103;
        this.f505364f = r104;
        if (r102 >= 10) goto L16;
        int r107 = 1;
    L21:
        this.f505365g = r107;
        return;
    L16:
        if (r102 >= 100) goto L19;
        r107 = 2;
        goto L21
    L19:
        if (r102 >= 1000) goto L24;
        r107 = 3;
        goto L21
    L24:
        throw new IllegalArgumentException("Max value " + r102 + " is too large");
    L5:
        r106 = null;
        goto L7
    }
}
