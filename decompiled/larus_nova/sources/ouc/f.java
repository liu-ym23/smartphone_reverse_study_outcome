package ouc;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.ClassDiscriminatorMode;

/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f526832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f526833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f526834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f526835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f526836e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f526837f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f526838g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f526839h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f526840i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f526841j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f526842k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f526843l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f526844m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f526845n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f526846o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ClassDiscriminatorMode f526847p;

    public final String toString() {
        return "JsonConfiguration(encodeDefaults=" + this.f526832a + ", ignoreUnknownKeys=" + this.f526833b + ", isLenient=" + this.f526834c + ", allowStructuredMapKeys=" + this.f526835d + ", prettyPrint=" + this.f526836e + ", explicitNulls=" + this.f526837f + ", prettyPrintIndent='" + this.f526838g + "', coerceInputValues=" + this.f526839h + ", useArrayPolymorphism=" + this.f526840i + ", classDiscriminator='" + this.f526841j + "', allowSpecialFloatingPointValues=" + this.f526842k + ", useAlternativeNames=" + this.f526843l + ", namingStrategy=null, decodeEnumsCaseInsensitive=" + this.f526844m + ", allowTrailingComma=" + this.f526845n + ", allowComments=" + this.f526846o + ", classDiscriminatorMode=" + this.f526847p + ')';
    }

    public f(boolean r100, boolean r101, boolean r102, boolean r103, boolean r110, boolean r111, String r112, boolean r113, boolean r114, String r115, boolean r116, boolean r117, boolean r118, boolean r119, boolean r210, ClassDiscriminatorMode r211) {
        Intrinsics.checkNotNullParameter(r112, "prettyPrintIndent");
        Intrinsics.checkNotNullParameter(r115, "classDiscriminator");
        Intrinsics.checkNotNullParameter(r211, "classDiscriminatorMode");
        this.f526832a = r100;
        this.f526833b = r101;
        this.f526834c = r102;
        this.f526835d = r103;
        this.f526836e = r110;
        this.f526837f = r111;
        this.f526838g = r112;
        this.f526839h = r113;
        this.f526840i = r114;
        this.f526841j = r115;
        this.f526842k = r116;
        this.f526843l = r117;
        this.f526844m = r118;
        this.f526845n = r119;
        this.f526846o = r210;
        this.f526847p = r211;
    }
}
