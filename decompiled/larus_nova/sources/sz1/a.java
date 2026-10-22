package sz1;

import android.text.TextUtils;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.gift.model.ComboHintInfo;
import com.bytedance.android.livesdk.gift.model.b2;
import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import gz1.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jy0.b;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import py.k;
import vh7.e;
import w20.u7;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u009c\u00012\u00020\u0001:\u0002\u009d\u0001B\t¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J7\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ-\u0010\u000e\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0010\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0015\u001a\u00020\u0011J\n\u0010\u0017\u001a\u00020\u0007*\u00020\u0016J\n\u0010\u0017\u001a\u00020\u0007*\u00020\u0018J\u0012\u0010\u001a\u001a\u00020\u0013*\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0007J\u0012\u0010\u001a\u001a\u00020\u0013*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007R$\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010'\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b.\u00100\"\u0004\b1\u00102R\"\u00103\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010/\u001a\u0004\b3\u00100\"\u0004\b4\u00102R\"\u00105\u001a\u00020\u00118\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b5\u0010\u001c\u001a\u0004\b6\u0010\u001e\"\u0004\b7\u0010 R\"\u00108\u001a\u00020\u00118\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b8\u0010\u001c\u001a\u0004\b9\u0010\u001e\"\u0004\b:\u0010 R$\u0010<\u001a\u0004\u0018\u00010;8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010B\u001a\u0004\u0018\u00010;8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bB\u0010=\u001a\u0004\bC\u0010?\"\u0004\bD\u0010AR(\u0010G\u001a\b\u0012\u0004\u0012\u00020F0E8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010N\u001a\u00020M8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010T\u001a\u0004\u0018\u00010;8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bT\u0010=\u001a\u0004\bU\u0010?\"\u0004\bV\u0010AR$\u0010W\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bW\u0010\u001c\u001a\u0004\bX\u0010\u001e\"\u0004\bY\u0010 R$\u0010Z\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bZ\u0010\u001c\u001a\u0004\b[\u0010\u001e\"\u0004\b\\\u0010 R\"\u0010]\u001a\u00020M8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b]\u0010O\u001a\u0004\b^\u0010Q\"\u0004\b_\u0010SR\"\u0010`\u001a\u00020M8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b`\u0010O\u001a\u0004\ba\u0010Q\"\u0004\bb\u0010SR\"\u0010c\u001a\u00020M8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bc\u0010O\u001a\u0004\bd\u0010Q\"\u0004\be\u0010SR$\u0010g\u001a\u0004\u0018\u00010f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR$\u0010m\u001a\u0004\u0018\u00010;8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bm\u0010=\u001a\u0004\bn\u0010?\"\u0004\bo\u0010AR$\u0010p\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bp\u0010\u001c\u001a\u0004\bq\u0010\u001e\"\u0004\br\u0010 R\"\u0010s\u001a\u00020-8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bs\u0010/\u001a\u0004\bt\u00100\"\u0004\bu\u00102R\"\u0010v\u001a\u00020M8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bv\u0010O\u001a\u0004\bw\u0010Q\"\u0004\bx\u0010SR/\u0010{\u001a\u000e\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020M0y8\u0016@\u0016X\u0096\u000e¢\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R\u001f\u0010\u0081\u0001\u001a\u00020z8\u0016X\u0096D¢\u0006\u0010\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001d\u0010\u0085\u0001\u001a\u00020-8\u0016X\u0096D¢\u0006\u000e\n\u0005\b\u0085\u0001\u0010/\u001a\u0005\b\u0086\u0001\u00100R(\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010\u001c\u001a\u0005\b\u0088\u0001\u0010\u001e\"\u0005\b\u0089\u0001\u0010 R\"\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001f\u0010\u008f\u0001\u001a\u00020z8\u0016X\u0096D¢\u0006\u0010\n\u0006\b\u008f\u0001\u0010\u0082\u0001\u001a\u0006\b\u0090\u0001\u0010\u0084\u0001R\u001d\u0010\u0091\u0001\u001a\u00020\u00118\u0016X\u0096D¢\u0006\u000e\n\u0005\b\u0091\u0001\u0010\u001c\u001a\u0005\b\u0092\u0001\u0010\u001eR&\u0010\u0094\u0001\u001a\u000b\u0018\u00010;j\u0005\u0018\u0001`\u0093\u00018\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\b\u0094\u0001\u0010=\u001a\u0005\b\u0095\u0001\u0010?R@\u0010\u0098\u0001\u001a%\u0012\u0004\u0012\u00020z\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010yj\u0012\u0012\u0004\u0012\u00020z\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u0001`\u0097\u00018\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\b\u0098\u0001\u0010|\u001a\u0005\b\u0099\u0001\u0010~¨\u0006\u009e\u0001"}, d2 = {"Lsz1/a;", "Lcom/bytedance/android/livesdk/gift/model/n;", "", "x", "y", "width", "height", "Lorg/json/JSONObject;", "convertFrame", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)Lorg/json/JSONObject;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "string", "", "convertFromString", "convertToString", "Lw20/u7$b;", "convertToJSONObject", "Lw20/u7$a;", "source", "convertToFrame", "localIconBitmap", "Ljava/lang/String;", "getLocalIconBitmap", "()Ljava/lang/String;", "setLocalIconBitmap", "(Ljava/lang/String;)V", "giftToolbarFrame", "Lw20/u7$b;", "getGiftToolbarFrame", "()Lw20/u7$b;", "setGiftToolbarFrame", "(Lw20/u7$b;)V", "giftCellFrame", "Lw20/u7$a;", "getGiftCellFrame", "()Lw20/u7$a;", "setGiftCellFrame", "(Lw20/u7$a;)V", "", "isRecommend", "Z", "()Z", "setRecommend", "(Z)V", "isNewCard", "setNewCard", n.KEY_MAIN_TEXT, "getMainText", "setMainText", n.KEY_SUB_TEXT, "getSubText", "setSubText", "Lpy/k;", n.KEY_ICON_IMG, "Lpy/k;", "getIconImg", "()Lpy/k;", "setIconImg", "(Lpy/k;)V", n.KEY_GIFT_DESCRIBE_IMG, "getGiftDescribeImg", "setGiftDescribeImg", "", "Lcom/bytedance/android/livesdk/gift/model/e3;", "pluginsFlex", "Ljava/util/List;", "getPluginsFlex", "()Ljava/util/List;", "setPluginsFlex", "(Ljava/util/List;)V", "", n.KEY_TOTAL_DIAMONDS, "J", "getTotalDiamonds", "()J", "setTotalDiamonds", "(J)V", "giftCellIcon", "getGiftCellIcon", "setGiftCellIcon", n.KEY_MAIN_TEXT_AFTER_SEND, "getMainTextAfterSend", "setMainTextAfterSend", "cardName", "getCardName", "setCardName", DyPayConstant.KEY_START_TIME, "getStartTime", "setStartTime", "endTime", "getEndTime", "setEndTime", "configId", "getConfigId", "setConfigId", "Lcom/bytedance/android/livesdk/gift/model/CardLockInfo;", "lockInfo", "Lcom/bytedance/android/livesdk/gift/model/CardLockInfo;", "getLockInfo", "()Lcom/bytedance/android/livesdk/gift/model/CardLockInfo;", "setLockInfo", "(Lcom/bytedance/android/livesdk/gift/model/CardLockInfo;)V", "statusIconImg", "getStatusIconImg", "setStatusIconImg", "labelText", "getLabelText", "setLabelText", "showRemindDot", "getShowRemindDot", "setShowRemindDot", UserInfo.UPDATE_TIME, "getUpdateTime", "setUpdateTime", "", "", "pageTypeToDefaultChoseActionMap", "Ljava/util/Map;", "getPageTypeToDefaultChoseActionMap", "()Ljava/util/Map;", "setPageTypeToDefaultChoseActionMap", "(Ljava/util/Map;)V", "cardType", "I", "getCardType", "()I", "notCache", "getNotCache", "configIdStr", "getConfigIdStr", "setConfigIdStr", "Lcom/bytedance/android/livesdk/gift/model/ComboHintInfo;", "comboHintInfo", "Lcom/bytedance/android/livesdk/gift/model/ComboHintInfo;", "getComboHintInfo", "()Lcom/bytedance/android/livesdk/gift/model/ComboHintInfo;", "giftSelectedStyle", "getGiftSelectedStyle", "sendButtonText", "getSendButtonText", "Lcom/bytedance/android/live/api/IImageModelKt;", "dynamicGiftIcon", "getDynamicGiftIcon", "Lcom/bytedance/android/livesdk/gift/model/b2;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "defaultGiftTextMap", "getDefaultGiftTextMap", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements n {
    public static final C7671a Companion = null;
    public static final String KEY_GIFT_CELL_FRAME = "gift_cell_frame";
    public static final String KEY_GIFT_TOOLBAR_FRAME = "gift_toolbar_frame";
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_IS_RECOMMEND = "is_recommend";
    public static final String KEY_LAST_SEND_TIME = "lastSendTime";
    public static final String KEY_LOCAL_ICON_BITMAP = "image_url";
    public static final String KEY_WIDTH = "width";
    public static final String KEY_X = "x";
    public static final String KEY_Y = "y";
    public static final String TAG = "DIYGiftCardLocalInfo";
    private String cardName;
    private final int cardType;
    private final ComboHintInfo comboHintInfo;
    private long configId;
    private String configIdStr;
    private final Map<Integer, b2> defaultGiftTextMap;
    private final k dynamicGiftIcon;
    private long endTime;

    @SerializedName(KEY_GIFT_CELL_FRAME)
    private u7.a giftCellFrame;
    private k giftCellIcon;
    private k giftDescribeImg;
    private final int giftSelectedStyle;

    @SerializedName(KEY_GIFT_TOOLBAR_FRAME)
    private u7.b giftToolbarFrame;
    private k iconImg;
    private boolean isNewCard;

    @SerializedName(KEY_IS_RECOMMEND)
    private boolean isRecommend;
    private String labelText;

    @SerializedName("image_url")
    private String localIconBitmap;
    private CardLockInfo lockInfo;
    private String mainText;
    private String mainTextAfterSend;
    private final boolean notCache;
    private Map<Integer, Long> pageTypeToDefaultChoseActionMap;
    private List<? extends e3> pluginsFlex;
    private final String sendButtonText;
    private boolean showRemindDot;
    private long startTime;
    private k statusIconImg;
    private String subText;
    private long totalDiamonds;
    private long updateTime;

    /* JADX INFO: renamed from: sz1.a$a, reason: collision with other inner class name */
    public static final class C7671a {
        public C7671a() {
        }
    }

    static {
        Companion = new C7671a();
    }

    @Override // com.bytedance.android.livesdk.gift.model.n, vh7.c
    public <R extends e<n>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return null;
    }

    public final String convertToString() {
        JSONObject r100 = new JSONObject();
        r100.put("main_text", getMainText());
        r100.put("sub_text", getSubText());
        r100.put(n.KEY_PLUGINS, c.a(c.g(this), 1));
        r100.put("total_diamonds", getTotalDiamonds());
        r100.put("image_url", this.localIconBitmap);
        u7.b r101 = this.giftToolbarFrame;
        if (r101 == null) goto L6;
        JSONObject r102 = convertToJSONObject(r101);
        if (r102 == null) goto L6;
    L7:
        r100.put(KEY_GIFT_TOOLBAR_FRAME, r102);
        u7.a r103 = this.giftCellFrame;
        if (r103 == null) goto L11;
        JSONObject r104 = convertToJSONObject(r103);
        if (r104 == null) goto L11;
    L12:
        r100.put(KEY_GIFT_CELL_FRAME, r104);
        r100.put(KEY_IS_RECOMMEND, this.isRecommend ? 1 : 0);
        r100.put("main_text_after_send", getMainTextAfterSend());
        r100.put("is_new_card", this.isNewCard);
        return r100.toString();
    L11:
        r104 = new JSONObject();
    L6:
        r102 = new JSONObject();
        goto L7
    }

    public a() {
        this.localIconBitmap = "";
        this.mainText = "";
        this.subText = "";
        this.pluginsFlex = new ArrayList();
        this.mainTextAfterSend = "";
        this.cardName = "";
        this.pageTypeToDefaultChoseActionMap = MapsKt.emptyMap();
        this.configIdStr = "0";
        this.sendButtonText = "";
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public String getCardName() {
        return this.cardName;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public int getCardType() {
        return this.cardType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public ComboHintInfo getComboHintInfo() {
        return this.comboHintInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public long getConfigId() {
        return this.configId;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public String getConfigIdStr() {
        return this.configIdStr;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public Map<Integer, b2> getDefaultGiftTextMap() {
        return this.defaultGiftTextMap;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public k getDynamicGiftIcon() {
        return this.dynamicGiftIcon;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public long getEndTime() {
        return this.endTime;
    }

    public final u7.a getGiftCellFrame() {
        return this.giftCellFrame;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public k getGiftCellIcon() {
        return this.giftCellIcon;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public k getGiftDescribeImg() {
        return this.giftDescribeImg;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public int getGiftSelectedStyle() {
        return this.giftSelectedStyle;
    }

    public final u7.b getGiftToolbarFrame() {
        return this.giftToolbarFrame;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public k getIconImg() {
        return this.iconImg;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public String getLabelText() {
        return this.labelText;
    }

    public final String getLocalIconBitmap() {
        return this.localIconBitmap;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public CardLockInfo getLockInfo() {
        return this.lockInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public String getMainText() {
        return this.mainText;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public String getMainTextAfterSend() {
        return this.mainTextAfterSend;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public boolean getNotCache() {
        return this.notCache;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public Map<Integer, Long> getPageTypeToDefaultChoseActionMap() {
        return this.pageTypeToDefaultChoseActionMap;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public List<e3> getPluginsFlex() {
        return this.pluginsFlex;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public String getSendButtonText() {
        return this.sendButtonText;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public boolean getShowRemindDot() {
        return this.showRemindDot;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public long getStartTime() {
        return this.startTime;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public k getStatusIconImg() {
        return this.statusIconImg;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public String getSubText() {
        return this.subText;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public long getTotalDiamonds() {
        return this.totalDiamonds;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public long getUpdateTime() {
        return this.updateTime;
    }

    public final boolean isNewCard() {
        return this.isNewCard;
    }

    public final boolean isRecommend() {
        return this.isRecommend;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n, vh7.c
    public <R extends e<n>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        throw new NotImplementedError(null, 1, null);
    }

    public final void convertFromString(String r100) {
        if (r100 == null) goto L26;
        boolean r101 = true;
        if ((!TextUtils.isEmpty(r100)) == false) goto L7;
        String r102 = r100;
    L8:
        if (r102 != null) goto L24;
        return;
    L24:
        JSONObject r103 = new JSONObject(r100);     // Catch: Exception -> L19
        setMainText(JSONObjectProtectorUtils.getString(r103, "main_text"));     // Catch: Exception -> L19
        setSubText(JSONObjectProtectorUtils.getString(r103, "sub_text"));     // Catch: Exception -> L19
        setPluginsFlex(CollectionsKt.toList(c.d(new JSONArray(JSONObjectProtectorUtils.getString(r103, n.KEY_PLUGINS)))));     // Catch: Exception -> L19
        setTotalDiamonds(JSONObjectProtectorUtils.getLong(r103, "total_diamonds"));     // Catch: Exception -> L19
        this.localIconBitmap = JSONObjectProtectorUtils.getString(r103, "image_url");     // Catch: Exception -> L19
        u7.b r104 = new u7.b();     // Catch: Exception -> L19
        this.giftToolbarFrame = r104;     // Catch: Exception -> L19
        convertToFrame(r104, JSONObjectProtectorUtils.getJSONObject(r103, KEY_GIFT_TOOLBAR_FRAME));     // Catch: Exception -> L19
        u7.a r105 = new u7.a();     // Catch: Exception -> L19
        this.giftCellFrame = r105;     // Catch: Exception -> L19
        convertToFrame(r105, JSONObjectProtectorUtils.getJSONObject(r103, KEY_GIFT_CELL_FRAME));     // Catch: Exception -> L19
        if (JSONObjectProtectorUtils.getInt(r103, KEY_IS_RECOMMEND) > 0) goto L14;
        r101 = false;
    L14:
        this.isRecommend = r101;     // Catch: Exception -> L19
        setMainTextAfterSend(JSONObjectProtectorUtils.getString(r103, "main_text_after_send"));     // Catch: Exception -> L19
        this.isNewCard = JSONObjectProtectorUtils.getBoolean(r103, "is_new_card");     // Catch: Exception -> L17
    L28:
        return;
    L17:
        this.isNewCard = false;     // Catch: Exception -> L19
        b.c(TAG, "isOldCard", null, 4);     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        b.c(TAG, "convertFromString exception: " + e.getMessage() + " string: " + r100, null, 4);
        return;
    L7:
        r102 = null;
        goto L8
    }

    public final JSONObject convertToJSONObject(u7.a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$convertToJSONObject");
        return convertFrame(r100.c(), r100.d(), r100.b(), r100.a());
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public void setCardName(String r100) {
        this.cardName = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public void setConfigId(long r100) {
        this.configId = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public void setConfigIdStr(String r100) {
        this.configIdStr = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public void setEndTime(long r100) {
        this.endTime = r100;
    }

    public final void setGiftCellFrame(u7.a r100) {
        this.giftCellFrame = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public void setGiftCellIcon(k r100) {
        this.giftCellIcon = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public void setGiftDescribeImg(k r100) {
        this.giftDescribeImg = r100;
    }

    public final void setGiftToolbarFrame(u7.b r100) {
        this.giftToolbarFrame = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public void setIconImg(k r100) {
        this.iconImg = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public void setLabelText(String r100) {
        this.labelText = r100;
    }

    public final void setLocalIconBitmap(String r100) {
        this.localIconBitmap = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public void setLockInfo(CardLockInfo r100) {
        this.lockInfo = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public void setMainText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mainText = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public void setMainTextAfterSend(String r100) {
        this.mainTextAfterSend = r100;
    }

    public final void setNewCard(boolean r100) {
        this.isNewCard = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public void setPageTypeToDefaultChoseActionMap(Map<Integer, Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pageTypeToDefaultChoseActionMap = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public void setPluginsFlex(List<? extends e3> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pluginsFlex = r100;
    }

    public final void setRecommend(boolean r100) {
        this.isRecommend = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public void setShowRemindDot(boolean r100) {
        this.showRemindDot = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public void setStartTime(long r100) {
        this.startTime = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public void setStatusIconImg(k r100) {
        this.statusIconImg = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public void setSubText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.subText = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public void setTotalDiamonds(long r100) {
        this.totalDiamonds = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public void setUpdateTime(long r100) {
        this.updateTime = r100;
    }

    public final JSONObject convertToJSONObject(u7.b r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$convertToJSONObject");
        return convertFrame(r100.c(), r100.d(), r100.b(), r100.a());
    }

    public final void convertToFrame(u7.a r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$convertToFrame");
        Intrinsics.checkNotNullParameter(r101, "source");
        r100.g(Float.valueOf((float) JSONObjectProtectorUtils.getDouble(r101, "x")));     // Catch: Exception -> L5
        r100.h(Float.valueOf((float) JSONObjectProtectorUtils.getDouble(r101, "y")));     // Catch: Exception -> L5
        r100.f(Float.valueOf((float) JSONObjectProtectorUtils.getDouble(r101, "width")));     // Catch: Exception -> L5
        r100.e(Float.valueOf((float) JSONObjectProtectorUtils.getDouble(r101, "height")));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        b.c(TAG, "cell frame convertToFrame exception: " + e.getMessage() + " source: " + r101, null, 4);
    }

    public final void convertToFrame(u7.b r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$convertToFrame");
        Intrinsics.checkNotNullParameter(r101, "source");
        r100.g(Float.valueOf((float) JSONObjectProtectorUtils.getDouble(r101, "x")));     // Catch: Exception -> L5
        r100.h(Float.valueOf((float) JSONObjectProtectorUtils.getDouble(r101, "y")));     // Catch: Exception -> L5
        r100.f(Float.valueOf((float) JSONObjectProtectorUtils.getDouble(r101, "width")));     // Catch: Exception -> L5
        r100.e(Float.valueOf((float) JSONObjectProtectorUtils.getDouble(r101, "height")));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        b.c(TAG, "toolbar frame convertToFrame exception: " + e.getMessage() + " source: " + r101, null, 4);
    }

    private final JSONObject convertFrame(Float r100, Float r101, Float r102, Float r103) {
        JSONObject r104 = new JSONObject();
        float r105 = 0.0f;
        if (r100 == null) goto L5;
        float r106 = r100.floatValue();
    L6:
        r104.put("x", Float.valueOf(r106));
        if (r101 == null) goto L9;
        float r107 = r101.floatValue();
    L10:
        r104.put("y", Float.valueOf(r107));
        if (r102 == null) goto L13;
        float r108 = r102.floatValue();
    L14:
        r104.put("width", Float.valueOf(r108));
        if (r103 == null) goto L17;
        r105 = r103.floatValue();
    L17:
        r104.put("height", Float.valueOf(r105));
        return r104;
    L13:
        r108 = 0.0f;
        goto L14
    L9:
        r107 = 0.0f;
        goto L10
    L5:
        r106 = 0.0f;
        goto L6
    }
}
