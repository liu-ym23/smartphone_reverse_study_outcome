package sl;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\u0016R0\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lsl/k;", "", "", "title", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "Lsl/j;", "content", "Lsl/j;", "c", "()Lsl/j;", "Lsl/i;", "cancelButton", "Lsl/i;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lsl/i;", "confirmButton", "b", "dialogName", "d", "setDialogName", "(Ljava/lang/String;)V", "", "eventParam", "Ljava/util/Map;", "e", "()Ljava/util/Map;", "setEventParam", "(Ljava/util/Map;)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class k {

    @SerializedName("cancel_button")
    private final i cancelButton;

    @SerializedName("confirm_button")
    private final i confirmButton;

    @SerializedName("content")
    private final j content;

    @SerializedName("track_name")
    private String dialogName;

    @SerializedName("event_params")
    private Map<String, String> eventParam;

    @SerializedName("title")
    private final String title;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L18;
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.cancelButton, r101.cancelButton) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.confirmButton, r101.confirmButton) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.dialogName, r101.dialogName) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.eventParam, r101.eventParam) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        j r104 = this.content;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        i r107 = this.cancelButton;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        i r110 = this.confirmButton;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.dialogName;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, String> r116 = this.eventParam;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECDialogData(title=" + this.title + ", content=" + this.content + ", cancelButton=" + this.cancelButton + ", confirmButton=" + this.confirmButton + ", dialogName=" + this.dialogName + ", eventParam=" + this.eventParam + ")";
    }

    public k() {
        this.title = null;
        this.content = null;
        this.cancelButton = null;
        this.confirmButton = null;
        this.dialogName = null;
        this.eventParam = null;
    }

    public final i a() {
        return this.cancelButton;
    }

    public final i b() {
        return this.confirmButton;
    }

    public final j c() {
        return this.content;
    }

    public final String d() {
        return this.dialogName;
    }

    public final Map<String, String> e() {
        return this.eventParam;
    }

    public final String f() {
        return this.title;
    }
}
