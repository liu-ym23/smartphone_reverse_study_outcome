package xi2;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0018\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b-\u0010.R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\"\u0010!\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR*\u0010$\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0012\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u0016R$\u0010'\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u000b\u001a\u0004\b(\u0010\r\"\u0004\b)\u0010\u000fR\"\u0010*\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0019\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001d¨\u0006/"}, d2 = {"Lxi2/k0;", "", "", "propertyId", "J", "c", "()J", "setPropertyId", "(J)V", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "", "properties", "Ljava/util/List;", "b", "()Ljava/util/List;", "l", "(Ljava/util/List;)V", "", "isRequired", "Z", "g", "()Z", "m", "(Z)V", "titleRequired", "d", "setTitleRequired", "isSelect", "h", "n", "valueIds", "e", "o", "extra", "a", "setExtra", "isMultiSelected", "f", "setMultiSelected", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k0 implements Comparable<k0> {

    @SerializedName("extra")
    private String extra;

    @SerializedName("is_multi_selected")
    private boolean isMultiSelected;

    @SerializedName("is_required")
    private boolean isRequired;

    @SerializedName("is_selected")
    private boolean isSelect;

    @SerializedName("name")
    private String name;

    @SerializedName("properties")
    private List<String> properties;

    @SerializedName("property_id")
    private long propertyId;

    @SerializedName("title_required")
    private boolean titleRequired;

    @SerializedName("value_ids")
    private List<String> valueIds;

    public k0() {
    }

    public final void m() {
        this.isRequired = true;
    }

    public final void n() {
        this.isSelect = true;
    }

    public final String a() {
        return this.extra;
    }

    public final List<String> b() {
        return this.properties;
    }

    public final long c() {
        return this.propertyId;
    }

    public final boolean d() {
        return this.titleRequired;
    }

    public final List<String> e() {
        return this.valueIds;
    }

    public final boolean f() {
        return this.isMultiSelected;
    }

    public final boolean g() {
        return this.isRequired;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean h() {
        return this.isSelect;
    }

    @Override // java.lang.Comparable
    public final int compareTo(k0 r7) {
        k0 r8 = r7;
        Intrinsics.checkNotNullParameter(r8, "other");
        if (this.propertyId != 1687) goto L5;
        return 0;
    L5:
        if (r8.propertyId != 1687) goto L8;
        return 0;
    L8:
        if (this.titleRequired == false) goto L18;
        if (this.isRequired == false) goto L18;
        if (r8.titleRequired == true) goto L14;
    L16:
        return -1;
    L14:
        if (r8.isRequired == false) goto L16;
        return 0;
    L18:
        if (this.isRequired == false) goto L28;
        if (r8.titleRequired == false) goto L25;
        if (r8.isRequired == false) goto L25;
        return 1;
    L25:
        if (r8.isRequired == false) goto L16;
        return 0;
    L28:
        return r8.isRequired ? 1 : 0;
    }

    public final void i(String r1) {
        this.name = r1;
    }

    public final void l(List<String> r1) {
        this.properties = r1;
    }

    public final void o(List<String> r1) {
        this.valueIds = r1;
    }
}
