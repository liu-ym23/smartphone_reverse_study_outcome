package l38;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0013\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003JI\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/larus/abtest/test/model/AbSdkTestConfig;", "", "boolean", "", "int", "", "string", "", "stringList", "", "testModel", "Lcom/larus/abtest/test/model/TestModel;", "<init>", "(ZILjava/lang/String;Ljava/util/List;Lcom/larus/abtest/test/model/TestModel;)V", "getBoolean", "()Z", "getInt", "()I", "getString", "()Ljava/lang/String;", "getStringList", "()Ljava/util/List;", "getTestModel", "()Lcom/larus/abtest/test/model/TestModel;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: boolean, reason: not valid java name */
    @SerializedName("boolean")
    private final boolean f1165boolean;

    /* JADX INFO: renamed from: int, reason: not valid java name */
    @SerializedName("int")
    private final int f1166int;

    @SerializedName("string")
    private final String string;

    @SerializedName("string_list")
    private final List<String> stringList;

    @SerializedName("test_model")
    private final b testModel;

    public a() {
        this(false, 0, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f1165boolean == r101.f1165boolean) goto L12;
        return false;
    L12:
        if (this.f1166int == r101.f1166int) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.string, r101.string) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.stringList, r101.stringList) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.testModel, r101.testModel) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.f1165boolean == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.f1166int) * 31;
        String r102 = this.string;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        List<String> r106 = this.stringList;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        b r109 = this.testModel;
        if (r109 == null) goto L19;
        r103 = r109.hashCode();
    L19:
        return r108 + r103;
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "AbSdkTestConfig(boolean=" + this.f1165boolean + ", int=" + this.f1166int + ", string=" + this.string + ", stringList=" + this.stringList + ", testModel=" + this.testModel + ')';
    }

    public a(boolean r100, int r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "default strings";
    L11:
        b r104 = null;
        if ((r103 & 8) == 0) goto L14;
        List<String> r105 = CollectionsKt.listOf(new String[]{"aa", "bb", "cc"});
    L16:
        if ((r103 & 16) == 0) goto L18;
        r104 = new b(0);
    L18:
        this.f1165boolean = r100;
        this.f1166int = r101;
        this.string = r102;
        this.stringList = r105;
        this.testModel = r104;
        return;
    L14:
        r105 = null;
        goto L16
    }
}
