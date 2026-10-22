package xi2;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b4\u00105R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R*\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010\tR$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010.\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00066"}, d2 = {"Lxi2/v;", "Lcom/bytedance/android/ec/model/g;", "", "Lxi2/k0;", "itemList", "Ljava/util/List;", "d", "()Ljava/util/List;", "setItemList", "(Ljava/util/List;)V", "", "nickName", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setNickName", "(Ljava/lang/String;)V", "", "stockMaxNum", "I", "g", "()I", "setStockMaxNum", "(I)V", "stockReduction", "h", "setStockReduction", "Lxi2/d;", "depositFindGoodsRule", "Lxi2/d;", "c", "()Lxi2/d;", "setDepositFindGoodsRule", "(Lxi2/d;)V", "Lxi2/j0;", "privileges", "f", "setPrivileges", "Lxi2/a;", "afterSaleService", "Lxi2/a;", "a", "()Lxi2/a;", "setAfterSaleService", "(Lxi2/a;)V", "Lxi2/c;", "deliveryDelayRule", "Lxi2/c;", "b", "()Lxi2/c;", "setDeliveryDelayRule", "(Lxi2/c;)V", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v extends com.bytedance.android.ec.model.g {

    @SerializedName("after_sale_service")
    private a afterSaleService;

    @SerializedName("delivery_delay_time_rule")
    private c deliveryDelayRule;

    @SerializedName("deposit_find_goods_rule")
    private d depositFindGoodsRule;

    @SerializedName("item_list")
    private List<k0> itemList;

    @SerializedName("nick_name")
    private String nickName;

    @SerializedName("privileges")
    private List<j0> privileges;

    @SerializedName("max_num")
    private int stockMaxNum;

    @SerializedName("stock_reduction")
    private int stockReduction;

    public v() {
        this.stockMaxNum = 1000000;
    }

    public final a a() {
        return this.afterSaleService;
    }

    public final c b() {
        return this.deliveryDelayRule;
    }

    public final d c() {
        return this.depositFindGoodsRule;
    }

    public final List<k0> d() {
        return this.itemList;
    }

    public final String e() {
        return this.nickName;
    }

    public final List<j0> f() {
        return this.privileges;
    }

    public final int g() {
        return this.stockMaxNum;
    }

    public final int h() {
        return this.stockReduction;
    }
}
