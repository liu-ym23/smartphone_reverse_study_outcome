package si2;

import com.bytedance.android.ec.core.apt.ActionType;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016X\u0097D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lsi2/f;", "Llg/d;", "", "name", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "btmId", "a", "promotionId", "getPromotionId", "setPromotionId", "(Ljava/lang/String;)V", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f extends lg.d {

    @SerializedName("btmId")
    private final String btmId;

    @SerializedName("name")
    private final String name;

    @SerializedName("promotion_id")
    private String promotionId;

    public f() {
        this(null);
    }

    public final String a() {
        return this.btmId;
    }

    public final String b() {
        return this.name;
    }

    public f(ql.a r3) {
        super(ActionType.ClickProduct);
        ActionType r0 = getType();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.name();
    L6:
        this.name = r2;
        this.btmId = "a1128.b3295";
        if (r3 == null) goto L9;
        r1 = r3.getPromotionId();
    L9:
        this.promotionId = r1;
        return;
    L5:
        r2 = null;
        goto L6
    }
}
