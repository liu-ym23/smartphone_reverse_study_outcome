package ql;

import android.text.TextUtils;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.ec.model.promotion.ECUIActivity;
import com.bytedance.android.ec.model.promotion.ECUIAskExplainInfo;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUILotteryInfo;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.promotion.ECUIPromotionLiveListConfig;
import com.bytedance.android.ec.model.response.ECAtmosphere;
import com.bytedance.android.ec.model.response.ECAtmosphereItem;
import com.bytedance.android.ec.model.response.ECAuctionAtmosphere;
import com.bytedance.android.ec.model.response.ECAuctionInfo;
import com.bytedance.android.ec.model.response.ECCategoryData;
import com.bytedance.android.ec.model.response.ECCombination;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ec.model.response.ECJumpDestination;
import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.PrefetchOrder;
import com.bytedance.android.ec.model.response.StandardEventTrack;
import com.bytedance.android.ec.model.response.v;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0094\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u0000 ô\u00022\u00020\u0001:\u0002õ\u0002B\t¢\u0006\u0006\bò\u0002\u0010ó\u0002J\u0006\u0010\u0003\u001a\u00020\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\tJ\b\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\tH\u0016J\u0016\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tJ\u001a\u0010\u0011\u001a\u00020\r2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0012J\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\tJ\u0006\u0010\u0018\u001a\u00020\u0002J\u0006\u0010\u0019\u001a\u00020\u0002J\u0006\u0010\u001a\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\tJ\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\b\u0010\u001e\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u001f\u001a\u00020\u0002J\b\u0010 \u001a\u00020\tH\u0016J\b\u0010!\u001a\u00020\tH\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010$\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010'\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010*\u001a\u00020\r2\u0006\u0010)\u001a\u00020(H\u0016J\u0010\u0010-\u001a\u00020\r2\u0006\u0010,\u001a\u00020+H\u0016J\b\u0010/\u001a\u0004\u0018\u00010.J\u0006\u00101\u001a\u000200J\u000e\u00101\u001a\u0002002\u0006\u00102\u001a\u00020\u0002J\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0012J\u0006\u00104\u001a\u00020\tJ\u0006\u00105\u001a\u00020\tJ\b\u00106\u001a\u00020\u0002H\u0016J\b\u00107\u001a\u00020\u0002H\u0016J\u0006\u00108\u001a\u00020\u0002J\u0006\u00109\u001a\u00020\u0002J\b\u0010:\u001a\u00020\u0002H\u0016J\b\u0010;\u001a\u00020\u0002H\u0016J\n\u0010=\u001a\u0004\u0018\u00010<H\u0016J\n\u0010>\u001a\u0004\u0018\u00010(H\u0016J\n\u0010?\u001a\u0004\u0018\u00010+H\u0016J\b\u0010@\u001a\u00020\u0002H\u0016J\b\u0010A\u001a\u00020\u0002H\u0016J\b\u0010B\u001a\u0004\u0018\u00010\tJ\b\u0010C\u001a\u0004\u0018\u00010\tJ\u001c\u0010G\u001a\u00020\r2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\t0D2\u0006\u0010F\u001a\u00020\tJ\u0016\u0010J\u001a\u00020\t2\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010HJ\b\u0010K\u001a\u00020\u0002H\u0016J\u0010\u0010M\u001a\u00020\r2\u0006\u0010L\u001a\u00020\u0000H\u0016J\u0010\u0010O\u001a\u00020\u00022\u0006\u0010N\u001a\u00020\tH\u0016J\u0011\u0010P\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\bP\u0010QJ\b\u0010R\u001a\u00020\u0015H\u0016R$\u0010T\u001a\u0004\u0018\u00010S8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010Z\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010`\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010[\u001a\u0004\ba\u0010]\"\u0004\bb\u0010_R\"\u0010c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\"\u0010i\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010d\u001a\u0004\bj\u0010f\"\u0004\bk\u0010hR\"\u0010l\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010d\u001a\u0004\bm\u0010f\"\u0004\bn\u0010hR0\u0010p\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010o8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR$\u0010w\u001a\u0004\u0018\u00010v8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\"\u0010}\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b}\u0010[\u001a\u0004\b~\u0010]\"\u0004\b\u007f\u0010_R(\u0010\u0080\u0001\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0080\u0001\u0010[\u001a\u0005\b\u0081\u0001\u0010]\"\u0005\b\u0082\u0001\u0010_R*\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0005\b\u0085\u0001\u0010Q\"\u0006\b\u0086\u0001\u0010\u0087\u0001R(\u0010\u0088\u0001\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0088\u0001\u0010[\u001a\u0005\b\u0089\u0001\u0010]\"\u0005\b\u008a\u0001\u0010_R&\u0010\u008b\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008b\u0001\u0010[\u001a\u0005\b\u008c\u0001\u0010]\"\u0005\b\u008d\u0001\u0010_R&\u0010\u008e\u0001\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008e\u0001\u0010d\u001a\u0005\b\u008f\u0001\u0010f\"\u0005\b\u0090\u0001\u0010hR(\u0010\u0091\u0001\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0091\u0001\u0010[\u001a\u0005\b\u0092\u0001\u0010]\"\u0005\b\u0093\u0001\u0010_R,\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R,\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009b\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009c\u0001\u0010\u009d\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001\"\u0006\b \u0001\u0010¡\u0001R\u001d\u0010£\u0001\u001a\u00030¢\u00018\u0006¢\u0006\u0010\n\u0006\b£\u0001\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001R&\u0010§\u0001\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b§\u0001\u0010d\u001a\u0005\b¨\u0001\u0010f\"\u0005\b©\u0001\u0010hR)\u0010ª\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bª\u0001\u0010«\u0001\u001a\u0006\bª\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R&\u0010¯\u0001\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¯\u0001\u0010d\u001a\u0005\b°\u0001\u0010f\"\u0005\b±\u0001\u0010hR(\u0010²\u0001\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b²\u0001\u0010[\u001a\u0005\b³\u0001\u0010]\"\u0005\b´\u0001\u0010_R(\u0010µ\u0001\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bµ\u0001\u0010[\u001a\u0005\b¶\u0001\u0010]\"\u0005\b·\u0001\u0010_R(\u0010¸\u0001\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¸\u0001\u0010[\u001a\u0005\b¹\u0001\u0010]\"\u0005\bº\u0001\u0010_R)\u0010»\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b»\u0001\u0010«\u0001\u001a\u0006\b»\u0001\u0010¬\u0001\"\u0006\b¼\u0001\u0010®\u0001R&\u0010½\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b½\u0001\u0010[\u001a\u0005\b¾\u0001\u0010]\"\u0005\b¿\u0001\u0010_R&\u0010À\u0001\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÀ\u0001\u0010d\u001a\u0005\bÁ\u0001\u0010f\"\u0005\bÂ\u0001\u0010hR4\u0010Ã\u0001\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010o8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÃ\u0001\u0010q\u001a\u0005\bÄ\u0001\u0010s\"\u0005\bÅ\u0001\u0010uR)\u0010Æ\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÆ\u0001\u0010«\u0001\u001a\u0006\bÇ\u0001\u0010¬\u0001\"\u0006\bÈ\u0001\u0010®\u0001R2\u0010Ê\u0001\u001a\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010É\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÊ\u0001\u0010Ë\u0001\u001a\u0006\bÌ\u0001\u0010Í\u0001\"\u0006\bÎ\u0001\u0010Ï\u0001R(\u0010Ð\u0001\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÐ\u0001\u0010[\u001a\u0005\bÑ\u0001\u0010]\"\u0005\bÒ\u0001\u0010_R)\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b&\u0010Ó\u0001\u001a\u0006\bÔ\u0001\u0010Õ\u0001\"\u0006\bÖ\u0001\u0010×\u0001R*\u0010,\u001a\u0005\u0018\u00010Ø\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b,\u0010Ù\u0001\u001a\u0006\bÚ\u0001\u0010Û\u0001\"\u0006\bÜ\u0001\u0010Ý\u0001R(\u0010Þ\u0001\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÞ\u0001\u0010[\u001a\u0005\bß\u0001\u0010]\"\u0005\bà\u0001\u0010_R;\u0010á\u0001\u001a\u0017\u0012\u0004\u0012\u00020\t\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u001c0É\u0001\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bá\u0001\u0010q\u001a\u0005\bâ\u0001\u0010s\"\u0005\bã\u0001\u0010uR3\u0010å\u0001\u001a\f\u0012\u0005\u0012\u00030ä\u0001\u0018\u00010É\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bå\u0001\u0010Ë\u0001\u001a\u0006\bæ\u0001\u0010Í\u0001\"\u0006\bç\u0001\u0010Ï\u0001R,\u0010é\u0001\u001a\u0005\u0018\u00010è\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bé\u0001\u0010ê\u0001\u001a\u0006\bë\u0001\u0010ì\u0001\"\u0006\bí\u0001\u0010î\u0001R,\u0010ð\u0001\u001a\u0005\u0018\u00010ï\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bð\u0001\u0010ñ\u0001\u001a\u0006\bò\u0001\u0010ó\u0001\"\u0006\bô\u0001\u0010õ\u0001R&\u0010ö\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bö\u0001\u0010[\u001a\u0005\b÷\u0001\u0010]\"\u0005\bø\u0001\u0010_R+\u0010ù\u0001\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bù\u0001\u0010ú\u0001\u001a\u0006\bû\u0001\u0010ü\u0001\"\u0006\bý\u0001\u0010þ\u0001R,\u0010\u0080\u0002\u001a\u0005\u0018\u00010ÿ\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0080\u0002\u0010\u0081\u0002\u001a\u0006\b\u0082\u0002\u0010\u0083\u0002\"\u0006\b\u0084\u0002\u0010\u0085\u0002R)\u0010\u0086\u0002\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0086\u0002\u0010«\u0001\u001a\u0006\b\u0087\u0002\u0010¬\u0001\"\u0006\b\u0088\u0002\u0010®\u0001R+\u0010\u0089\u0002\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0089\u0002\u0010\u008a\u0002\u001a\u0006\b\u008b\u0002\u0010\u008c\u0002\"\u0006\b\u008d\u0002\u0010\u008e\u0002R)\u0010\u008f\u0002\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008f\u0002\u0010«\u0001\u001a\u0006\b\u0090\u0002\u0010¬\u0001\"\u0006\b\u0091\u0002\u0010®\u0001R)\u0010\u0092\u0002\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0092\u0002\u0010«\u0001\u001a\u0006\b\u0093\u0002\u0010¬\u0001\"\u0006\b\u0094\u0002\u0010®\u0001R)\u0010\u0095\u0002\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0095\u0002\u0010«\u0001\u001a\u0006\b\u0095\u0002\u0010¬\u0001\"\u0006\b\u0096\u0002\u0010®\u0001R)\u0010\u0097\u0002\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0097\u0002\u0010«\u0001\u001a\u0006\b\u0097\u0002\u0010¬\u0001\"\u0006\b\u0098\u0002\u0010®\u0001R,\u0010\u009a\u0002\u001a\u0005\u0018\u00010\u0099\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009a\u0002\u0010\u009b\u0002\u001a\u0006\b\u009c\u0002\u0010\u009d\u0002\"\u0006\b\u009e\u0002\u0010\u009f\u0002R(\u0010 \u0002\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b \u0002\u0010[\u001a\u0005\b¡\u0002\u0010]\"\u0005\b¢\u0002\u0010_R(\u0010£\u0002\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b£\u0002\u0010[\u001a\u0005\b¤\u0002\u0010]\"\u0005\b¥\u0002\u0010_R&\u0010¦\u0002\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¦\u0002\u0010d\u001a\u0005\b§\u0002\u0010f\"\u0005\b¨\u0002\u0010hR(\u0010©\u0002\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b©\u0002\u0010[\u001a\u0005\bª\u0002\u0010]\"\u0005\b«\u0002\u0010_R(\u0010¬\u0002\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¬\u0002\u0010[\u001a\u0005\b\u00ad\u0002\u0010]\"\u0005\b®\u0002\u0010_R)\u0010¯\u0002\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¯\u0002\u0010«\u0001\u001a\u0006\b°\u0002\u0010¬\u0001\"\u0006\b±\u0002\u0010®\u0001R,\u0010³\u0002\u001a\u0005\u0018\u00010²\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b³\u0002\u0010´\u0002\u001a\u0006\bµ\u0002\u0010¶\u0002\"\u0006\b·\u0002\u0010¸\u0002R)\u0010¹\u0002\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¹\u0002\u0010«\u0001\u001a\u0006\bº\u0002\u0010¬\u0001\"\u0006\b»\u0002\u0010®\u0001R&\u0010¼\u0002\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¼\u0002\u0010d\u001a\u0005\b½\u0002\u0010f\"\u0005\b¾\u0002\u0010hR)\u0010¿\u0002\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¿\u0002\u0010«\u0001\u001a\u0006\b¿\u0002\u0010¬\u0001\"\u0006\bÀ\u0002\u0010®\u0001R,\u0010Â\u0002\u001a\u0005\u0018\u00010Á\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÂ\u0002\u0010Ã\u0002\u001a\u0006\bÄ\u0002\u0010Å\u0002\"\u0006\bÆ\u0002\u0010Ç\u0002R,\u0010É\u0002\u001a\u0005\u0018\u00010È\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÉ\u0002\u0010Ê\u0002\u001a\u0006\bË\u0002\u0010Ì\u0002\"\u0006\bÍ\u0002\u0010Î\u0002R(\u0010Ï\u0002\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÏ\u0002\u0010[\u001a\u0005\bÐ\u0002\u0010]\"\u0005\bÑ\u0002\u0010_R(\u0010Ò\u0002\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÒ\u0002\u0010[\u001a\u0005\bÓ\u0002\u0010]\"\u0005\bÔ\u0002\u0010_R,\u0010Ö\u0002\u001a\u0005\u0018\u00010Õ\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÖ\u0002\u0010×\u0002\u001a\u0006\bØ\u0002\u0010Ù\u0002\"\u0006\bÚ\u0002\u0010Û\u0002R,\u0010Ý\u0002\u001a\u0005\u0018\u00010Ü\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÝ\u0002\u0010Þ\u0002\u001a\u0006\bß\u0002\u0010à\u0002\"\u0006\bá\u0002\u0010â\u0002R,\u0010ä\u0002\u001a\u0005\u0018\u00010ã\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bä\u0002\u0010å\u0002\u001a\u0006\bæ\u0002\u0010ç\u0002\"\u0006\bè\u0002\u0010é\u0002R(\u0010ê\u0002\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bê\u0002\u0010[\u001a\u0005\bë\u0002\u0010]\"\u0005\bì\u0002\u0010_R(\u0010í\u0002\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bí\u0002\u0010[\u001a\u0005\bî\u0002\u0010]\"\u0005\bï\u0002\u0010_R)\u0010ð\u0002\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bð\u0002\u0010«\u0001\u001a\u0006\bð\u0002\u0010¬\u0001\"\u0006\bñ\u0002\u0010®\u0001¨\u0006ö\u0002"}, d2 = {"Lql/a;", "", "", "isDynamicRecommended", "Lcom/bytedance/android/ec/model/response/v;", "getStepperInfo", "shouldShowStepper", "isOnExplaining", "isOnTopExplaining", "", "getUniTag", "getCover", "cover", "", "setCover", "key", "value", "appendExtraEventParams", "", "map", "processEventParams", "", "getHotAtmosphereSaleNum", "getHotSaleTypeStr", "canShowHotAtmosphere", "canShowOtherAtmosphere", "isDiscountPrice", "getTrackLabelName", "Lcom/bytedance/android/ec/model/response/ECRitTag;", "getBaseSelection", "getBaseVerifiedCategory", "shouldShowFindSimilar", "getPrice", "getLabelNameLive", "getTitle", "title", com.alipay.sdk.m.x.d.f25925o, "Lcom/bytedance/android/ec/model/response/ECHotAtmosphere;", "hotAtmosphere", "updateHotAtmosphere", "Lcom/bytedance/android/ec/model/response/ECAuctionInfo;", "auction", "updateV2AuctionInfo", "Lcom/bytedance/android/ec/model/response/ECAuctionAtmosphere;", "atmosphere", "updateV2AuctionAtmosphere", "Lcom/bytedance/android/ec/model/promotion/ECUIPromotion$AtmosphereTopState;", "getAtmosphereHeaderStateOrDefault", "Lorg/json/JSONObject;", "getTransmissibleJson", "needHotSaleNumber", "getNewUserActivity", "getInventoryStatus", "getIsGroupBuying", "isPreSale", "isCrossborderProduct", "isOnSale", "isAutoApplyCoupon", "canShowAddCart", "isFlash", "Lcom/bytedance/android/ec/model/promotion/ECUICampaign;", "getCampaign", "getAuctionV2", "getAuctionAtmosphere", "isAuction", "isAuctionV2", "getLiveProductType", "getGroupId", "", "set", "tagStr", "addTagToSet", "", "tagSet", "tagSetToString", "isLottery", "promotion", "copyIconDataFromPromotion", "tag", "containsIconTag", "getCampainExtraType", "()Ljava/lang/Integer;", "getEcomGoodsStatus", "Lrl/a;", "dynamicSlot", "Lrl/a;", "getDynamicSlot", "()Lrl/a;", "setDynamicSlot", "(Lrl/a;)V", "eventItemType", "Ljava/lang/String;", "getEventItemType", "()Ljava/lang/String;", "setEventItemType", "(Ljava/lang/String;)V", "promotionId", "getPromotionId", "setPromotionId", "status", "I", "getStatus", "()I", "setStatus", "(I)V", "ironIndex", "getIronIndex", "setIronIndex", "realIndex", "getRealIndex", "setRealIndex", "", "eventParams", "Ljava/util/Map;", "getEventParams", "()Ljava/util/Map;", "setEventParams", "(Ljava/util/Map;)V", "Lcom/bytedance/android/ec/model/response/StandardEventTrack;", "standardEventTrack", "Lcom/bytedance/android/ec/model/response/StandardEventTrack;", "getStandardEventTrack", "()Lcom/bytedance/android/ec/model/response/StandardEventTrack;", "setStandardEventTrack", "(Lcom/bytedance/android/ec/model/response/StandardEventTrack;)V", "productId", "getProductId", "setProductId", RemoteMessageConst.Notification.CHANNEL_ID, "getChannelId", "setChannelId", "channelType", "Ljava/lang/Integer;", "getChannelType", "setChannelType", "(Ljava/lang/Integer;)V", "scheme", "getScheme", "setScheme", "shopId", "getShopId", "setShopId", "dynamicRecommendIndex", "getDynamicRecommendIndex", "setDynamicRecommendIndex", "leafCategory", "getLeafCategory", "setLeafCategory", "Lcom/bytedance/android/ec/model/ECUrlModel;", "detailCover", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getDetailCover", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setDetailCover", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "Lcom/bytedance/android/ec/model/response/PrefetchOrder;", "prefetchOrder", "Lcom/bytedance/android/ec/model/response/PrefetchOrder;", "getPrefetchOrder", "()Lcom/bytedance/android/ec/model/response/PrefetchOrder;", "setPrefetchOrder", "(Lcom/bytedance/android/ec/model/response/PrefetchOrder;)V", "Lql/b;", "clientData", "Lql/b;", "getClientData", "()Lql/b;", "localNum", "getLocalNum", "setLocalNum", "isRelatedInfo", "Z", "()Z", "setRelatedInfo", "(Z)V", "explainType", "getExplainType", "setExplainType", CronetDataStorageAccess.LOGID, "getLogid", "setLogid", "originId", "getOriginId", "setOriginId", "originType", "getOriginType", "setOriginType", "isMultiGroupBuy", "setMultiGroupBuy", "trackExtra", "getTrackExtra", "setTrackExtra", "ultimateBuyType", "getUltimateBuyType", "setUltimateBuyType", "extraEventParams", "getExtraEventParams", "setExtraEventParams", "hasFlagShopTag", "getHasFlagShopTag", "setHasFlagShopTag", "", "promotionListHeaderLabelNames", "Ljava/util/List;", "getPromotionListHeaderLabelNames", "()Ljava/util/List;", "setPromotionListHeaderLabelNames", "(Ljava/util/List;)V", "liveLabelNameFromEventParams", "getLiveLabelNameFromEventParams", "setLiveLabelNameFromEventParams", "Lcom/bytedance/android/ec/model/response/ECHotAtmosphere;", "getHotAtmosphere", "()Lcom/bytedance/android/ec/model/response/ECHotAtmosphere;", "setHotAtmosphere", "(Lcom/bytedance/android/ec/model/response/ECHotAtmosphere;)V", "Lcom/bytedance/android/ec/model/response/ECAtmosphere;", "Lcom/bytedance/android/ec/model/response/ECAtmosphere;", "getAtmosphere", "()Lcom/bytedance/android/ec/model/response/ECAtmosphere;", "setAtmosphere", "(Lcom/bytedance/android/ec/model/response/ECAtmosphere;)V", "hasDiscountPrice", "getHasDiscountPrice", "setHasDiscountPrice", "ritTag", "getRitTag", "setRitTag", "Lcom/bytedance/android/ec/model/PromotionBenefitLabel;", "benefitLabels", "getBenefitLabels", "setBenefitLabels", "Lcom/bytedance/android/ec/model/RitTagTrack;", "upIconTagTrack", "Lcom/bytedance/android/ec/model/RitTagTrack;", "getUpIconTagTrack", "()Lcom/bytedance/android/ec/model/RitTagTrack;", "setUpIconTagTrack", "(Lcom/bytedance/android/ec/model/RitTagTrack;)V", "Lcom/bytedance/android/ec/model/response/ECCurrentPromotion$PopBackground;", "background", "Lcom/bytedance/android/ec/model/response/ECCurrentPromotion$PopBackground;", "getBackground", "()Lcom/bytedance/android/ec/model/response/ECCurrentPromotion$PopBackground;", "setBackground", "(Lcom/bytedance/android/ec/model/response/ECCurrentPromotion$PopBackground;)V", "currentLabel", "getCurrentLabel", "setCurrentLabel", "extraTransmissibleLogParams", "Lorg/json/JSONObject;", "getExtraTransmissibleLogParams", "()Lorg/json/JSONObject;", "setExtraTransmissibleLogParams", "(Lorg/json/JSONObject;)V", "Lll/a;", "promotionBottom", "Lll/a;", "getPromotionBottom", "()Lll/a;", "setPromotionBottom", "(Lll/a;)V", "hasPreferredCouponEffect", "getHasPreferredCouponEffect", "setHasPreferredCouponEffect", "atmosphereHeaderState", "Lcom/bytedance/android/ec/model/promotion/ECUIPromotion$AtmosphereTopState;", "getAtmosphereHeaderState", "()Lcom/bytedance/android/ec/model/promotion/ECUIPromotion$AtmosphereTopState;", "setAtmosphereHeaderState", "(Lcom/bytedance/android/ec/model/promotion/ECUIPromotion$AtmosphereTopState;)V", "hasPriceModule", "getHasPriceModule", "setHasPriceModule", "forcePriceModule", "getForcePriceModule", "setForcePriceModule", "isPopCard", "setPopCard", "isShowCombination", "setShowCombination", "Lcom/bytedance/android/ec/model/response/ECCombination;", "combination", "Lcom/bytedance/android/ec/model/response/ECCombination;", "getCombination", "()Lcom/bytedance/android/ec/model/response/ECCombination;", "setCombination", "(Lcom/bytedance/android/ec/model/response/ECCombination;)V", "realPrice", "getRealPrice", "setRealPrice", "costPrice", "getCostPrice", "setCostPrice", "applyCoupon", "getApplyCoupon", "setApplyCoupon", "couponMinPrice", "getCouponMinPrice", "setCouponMinPrice", "showNotice", "getShowNotice", "setShowNotice", "canAddShopCart", "getCanAddShopCart", "setCanAddShopCart", "Lcom/bytedance/android/ec/model/promotion/ECUIAskExplainInfo;", "askExplainInfo", "Lcom/bytedance/android/ec/model/promotion/ECUIAskExplainInfo;", "getAskExplainInfo", "()Lcom/bytedance/android/ec/model/promotion/ECUIAskExplainInfo;", "setAskExplainInfo", "(Lcom/bytedance/android/ec/model/promotion/ECUIAskExplainInfo;)V", "singleSku", "getSingleSku", "setSingleSku", "flashType", "getFlashType", "setFlashType", "isInsuranceProduct", "setInsuranceProduct", "Lcom/bytedance/android/ec/model/response/ECCategoryData;", "categoryData", "Lcom/bytedance/android/ec/model/response/ECCategoryData;", "getCategoryData", "()Lcom/bytedance/android/ec/model/response/ECCategoryData;", "setCategoryData", "(Lcom/bytedance/android/ec/model/response/ECCategoryData;)V", "Lcom/bytedance/android/ec/model/response/ECJumpDestination;", "jumpDestination", "Lcom/bytedance/android/ec/model/response/ECJumpDestination;", "getJumpDestination", "()Lcom/bytedance/android/ec/model/response/ECJumpDestination;", "setJumpDestination", "(Lcom/bytedance/android/ec/model/response/ECJumpDestination;)V", "ecomGroupType", "getEcomGroupType", "setEcomGroupType", "eventLabel", "getEventLabel", "setEventLabel", "Lcom/bytedance/android/ec/model/promotion/ECUIActivity;", "activity", "Lcom/bytedance/android/ec/model/promotion/ECUIActivity;", "getActivity", "()Lcom/bytedance/android/ec/model/promotion/ECUIActivity;", "setActivity", "(Lcom/bytedance/android/ec/model/promotion/ECUIActivity;)V", "Lcom/bytedance/android/ec/model/promotion/ECUILotteryInfo;", "lotteryInfo", "Lcom/bytedance/android/ec/model/promotion/ECUILotteryInfo;", "getLotteryInfo", "()Lcom/bytedance/android/ec/model/promotion/ECUILotteryInfo;", "setLotteryInfo", "(Lcom/bytedance/android/ec/model/promotion/ECUILotteryInfo;)V", "Lcom/bytedance/android/ec/model/response/ECPromotionAuctionInfo;", "auctionInfo", "Lcom/bytedance/android/ec/model/response/ECPromotionAuctionInfo;", "getAuctionInfo", "()Lcom/bytedance/android/ec/model/response/ECPromotionAuctionInfo;", "setAuctionInfo", "(Lcom/bytedance/android/ec/model/response/ECPromotionAuctionInfo;)V", "bizIdentity", "getBizIdentity", "setBizIdentity", "checkCallback", "getCheckCallback", "setCheckCallback", "isWithinFirstScreenLimit", "setWithinFirstScreenLimit", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public class a {
    public static final C7354a Companion = null;
    public static final int HAS_DISCOUNT_PRICE = 1;
    public static final int PRODUCT_TYPE_CROSSBORDER = 2;
    private ECUIActivity activity;
    private int applyCoupon;
    private ECUIAskExplainInfo askExplainInfo;
    private ECAtmosphere atmosphere;
    private ECUIPromotion.AtmosphereTopState atmosphereHeaderState;
    private ECPromotionAuctionInfo auctionInfo;

    @SerializedName("background")
    private ECCurrentPromotion.PopBackground background;
    private List<PromotionBenefitLabel> benefitLabels;
    private String bizIdentity;
    private boolean canAddShopCart;
    private ECCategoryData categoryData;
    private String channelId;
    private Integer channelType;
    private String checkCallback;
    private final b clientData;
    private ECCombination combination;
    private String costPrice;
    private String couponMinPrice;
    private String currentLabel;
    private ECUrlModel detailCover;
    private int dynamicRecommendIndex;
    private rl.a dynamicSlot;
    private String ecomGroupType;
    private String eventItemType;
    private String eventLabel;
    private Map<String, String> eventParams;
    private int explainType;
    private volatile Map<String, String> extraEventParams;
    private JSONObject extraTransmissibleLogParams;
    private int flashType;
    private boolean forcePriceModule;
    private String hasDiscountPrice;
    private boolean hasFlagShopTag;
    private boolean hasPreferredCouponEffect;
    private boolean hasPriceModule;
    private ECHotAtmosphere hotAtmosphere;
    private int ironIndex;
    private boolean isInsuranceProduct;
    private boolean isMultiGroupBuy;
    private boolean isPopCard;
    private boolean isRelatedInfo;
    private boolean isShowCombination;
    private boolean isWithinFirstScreenLimit;
    private ECJumpDestination jumpDestination;
    private String leafCategory;
    private String liveLabelNameFromEventParams;
    private int localNum;
    private String logid;
    private ECUILotteryInfo lotteryInfo;
    private String originId;
    private String originType;
    private PrefetchOrder prefetchOrder;
    private String productId;
    private ll.a promotionBottom;
    private String promotionId;
    private List<String> promotionListHeaderLabelNames;
    private int realIndex;
    private String realPrice;
    private Map<String, ? extends List<ECRitTag>> ritTag;
    private String scheme;
    private String shopId;
    private String showNotice;
    private boolean singleSku;
    private StandardEventTrack standardEventTrack;
    private int status;
    private String trackExtra;
    private int ultimateBuyType;

    @SerializedName("up_icon_tag_track")
    private RitTagTrack upIconTagTrack;

    /* JADX INFO: renamed from: ql.a$a, reason: collision with other inner class name */
    public static final class C7354a {
        public C7354a() {
        }
    }

    static {
        Companion = new C7354a();
    }

    public boolean canShowAddCart() {
        return false;
    }

    public boolean containsIconTag(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        return false;
    }

    public void copyIconDataFromPromotion(a r100) {
        Intrinsics.checkNotNullParameter(r100, "promotion");
    }

    public ECAuctionAtmosphere getAuctionAtmosphere() {
        return null;
    }

    public ECAuctionInfo getAuctionV2() {
        return null;
    }

    public ECUICampaign getCampaign() {
        return null;
    }

    public Integer getCampainExtraType() {
        return null;
    }

    public String getCover() {
        return "";
    }

    public int getEcomGoodsStatus() {
        return 0;
    }

    public String getLabelNameLive() {
        return "";
    }

    /* JADX INFO: renamed from: getPrice */
    public String mo8153getPrice() {
        return "";
    }

    public v getStepperInfo() {
        return null;
    }

    /* JADX INFO: renamed from: getTitle */
    public String mo8154getTitle() {
        return null;
    }

    public final JSONObject getTransmissibleJson() {
        return getTransmissibleJson(true);
    }

    public boolean isAuction() {
        return false;
    }

    public boolean isAuctionV2() {
        return false;
    }

    public final boolean isAutoApplyCoupon() {
        String r100 = this.couponMinPrice;     // Catch: Exception -> L13
        if (r100 != null) goto L7;
        r100 = "0";
    L7:
        if ((CastIntegerProtector.parseInt(r100) / 100) > CastFloatProtector.parseFloat(mo8153getPrice())) goto L15;
        if (1 != this.applyCoupon) goto L18;
        return true;
    L18:
        return false;
    L15:
        return false;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public boolean isCrossborderProduct() {
        return false;
    }

    public boolean isFlash() {
        return false;
    }

    public boolean isLottery() {
        return false;
    }

    public boolean isPreSale() {
        return false;
    }

    public void setCover(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cover");
    }

    public void setTitle(String r100) {
    }

    public void updateHotAtmosphere(ECHotAtmosphere r100) {
    }

    public void updateV2AuctionAtmosphere(ECAuctionAtmosphere r100) {
        Intrinsics.checkNotNullParameter(r100, "atmosphere");
    }

    public void updateV2AuctionInfo(ECAuctionInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "auction");
    }

    public final ECUIPromotion.AtmosphereTopState getAtmosphereHeaderStateOrDefault() {
        if (this.atmosphereHeaderState != null) goto L6;
        this.atmosphereHeaderState = new ECUIPromotion.AtmosphereTopState();
    L6:
        return this.atmosphereHeaderState;
    }

    public final ECRitTag getBaseSelection() {
        Map<String, ? extends List<ECRitTag>> r100 = this.ritTag;
        if (r100 == null) goto L14;
        List<ECRitTag> r101 = r100.get("live_room_product_title_before");
        if (r101 == null) goto L22;
        Iterator<ECRitTag> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L23;
        ECRitTag r103 = r102.next();
        if (r103.getTagId() == null) goto L8;
        if (Intrinsics.areEqual(r103.getTagId(), "101") == false) goto L8;
        return r103;
    L23:
        return null;
    L22:
        return null;
    L14:
        return null;
    }

    public final int getHotAtmosphereSaleNum() {
        ECHotAtmosphere r100 = this.hotAtmosphere;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getNumInt();
    }

    public final String getHotSaleTypeStr() {
        ECHotAtmosphere r100 = this.hotAtmosphere;
        if (r100 == null) goto L5;
        String r101 = r100.getTypeStr();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final String getInventoryStatus() {
        int r100 = this.status;
        if (r100 != 1) goto L6;
        return "0";
    L6:
        if (r100 != 2) goto L9;
        return "1";
    L9:
        if (r100 != 5) goto L12;
        return "2";
    L12:
        if (r100 != 4) goto L14;
    L23:
        return "3";
    L14:
        if (r100 == 3) goto L23;
        if (r100 != 7000) goto L19;
    L22:
        return "4";
    L19:
        if (r100 == 8000) goto L22;
        return "-1";
    }

    public final String getLiveProductType() {
        int r100 = this.flashType;
        if (r100 != 1) goto L6;
        return "buynow_all";
    L6:
        if (r100 != 2) goto L8;
        return "buynow_part";
    L8:
        return null;
    }

    public final Map<String, String> getNewUserActivity() {
        HashMap r100 = new HashMap();
        Map<String, String> r101 = this.eventParams;
        if (r101 == null) goto L8;
        String r102 = r101.get("new_user_activity");
        String r103 = r101.get("new_user_activity_id");
        if (r102 == null) goto L8;
        if (r103 == null) goto L8;
        r100.put("new_user_activity", r102);
        r100.put("new_user_activity_id", r103);
    L8:
        return r100;
    }

    public final String getTrackLabelName() {
        StringBuilder r100 = new StringBuilder();
        Map<String, ? extends List<ECRitTag>> r101 = this.ritTag;
        if (r101 == null) goto L21;
        List<ECRitTag> r102 = null;
        if (r101 == null) goto L7;
        List<ECRitTag> r103 = r101.get("live_room_product_title_before");
    L8:
        if (r103 == null) goto L21;
        Map<String, ? extends List<ECRitTag>> r104 = this.ritTag;
        if (r104 == null) goto L12;
        r102 = r104.get("live_room_product_title_before");
    L12:
        if (r102 != null) goto L14;
        r102 = CollectionsKt.emptyList();
    L14:
        Iterator<ECRitTag> r105 = r102.iterator();
    L16:
        if (r105.hasNext() == false) goto L21;
        String r106 = r105.next().component7();
        if (TextUtils.isEmpty(r106) == true) goto L16;
        r100.append(r106);
        r100.append(",");
        goto L16
    L7:
        r103 = null;
    L21:
        if (r100.length() <= 0) goto L23;
        boolean r107 = true;
    L24:
        if (r107 == false) goto L27;
        r100.delete(r100.length() - 1, r100.length());
    L27:
        return r100.toString();
    L23:
        r107 = false;
        goto L24
    }

    public final String getUniTag() {
        return this.promotionId + this.explainType;
    }

    public final boolean isDiscountPrice() {
        String r100 = this.hasDiscountPrice;
        if (r100 == null) goto L11;
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.intValue() != 1) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    public final boolean isDynamicRecommended() {
        if (this.dynamicRecommendIndex <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isOnExplaining() {
        int r100 = this.explainType;
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public final boolean isOnSale() {
        if (this.status == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isOnTopExplaining() {
        if (this.explainType != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final void processEventParams() {
        Map<String, String> r100 = this.eventParams;
        if (r100 == null) goto L6;
        this.liveLabelNameFromEventParams = r100.remove(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE);
        r100.remove("v3_events_additions");
        r100.remove(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        return;
    }

    public final boolean shouldShowFindSimilar() {
        int r100 = this.status;
        if (r100 == 2) goto L9;
        if (r100 == 5) goto L9;
        if (r100 == 3) goto L9;
    L16:
        return false;
    L9:
        if (isOnExplaining() == true) goto L16;
        ECUIPromotionLiveListConfig r101 = this.clientData.f533698g;
        if (r101 == null) goto L16;
        if (r101 == null) goto L16;
        if (r101.getShouldShowFindSimilar() != true) goto L16;
        return true;
    }

    public a() {
        this.promotionId = "";
        this.productId = "";
        this.shopId = "";
        this.clientData = new b();
        this.trackExtra = SliceInitService.DEFAULT_SWITCH;
        this.currentLabel = "";
    }

    public final boolean canShowHotAtmosphere() {
        if (isOnTopExplaining() == false) goto L16;
        if (isFlash() == false) goto L9;
        if (this.isPopCard == false) goto L16;
    L9:
        if (isOnSale() == false) goto L16;
        ECHotAtmosphere r100 = this.hotAtmosphere;
        if (r100 == null) goto L16;
        if (r100 != null) goto L14;
    L17:
        return true;
    L14:
        if (r100.type != 0) goto L17;
    L16:
        if (isAuction() == true) goto L17;
        return false;
    }

    public final boolean canShowOtherAtmosphere() {
        if (isOnTopExplaining() == false) goto L23;
        if (isFlash() == false) goto L9;
        if (this.isPopCard == false) goto L23;
    L9:
        if (isOnSale() == false) goto L23;
        ECAtmosphere r100 = this.atmosphere;
        if (r100 == null) goto L13;
        List<ECAtmosphereItem> r101 = r100.getAtmosphereItems();
    L14:
        List<ECAtmosphereItem> r102 = r101;
        if (r102 != null) goto L17;
    L20:
        boolean r103 = true;
    L21:
        if (r103 == true) goto L23;
    L24:
        return true;
    L17:
        if (r102.isEmpty() == true) goto L20;
        r103 = false;
        goto L21
    L13:
        r101 = null;
    L23:
        if (isAuction() == true) goto L24;
        return false;
    }

    public final String getBaseVerifiedCategory() {
        ECRitTag r100 = getBaseSelection();
        if (r100 == null) goto L5;
        String r101 = r100.getTrackTag();
    L6:
        if (r101 != null) goto L8;
        return "";
    L8:
        return r100.getTrackTag();
    L5:
        r101 = null;
        goto L6
    }

    public final String getGroupId() {
        ECUICampaign r100 = getCampaign();
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.isGroup().booleanValue() == true) goto L7;
        return null;
    L7:
        return r100.groupData.getGroupId();
    }

    public final String getIsGroupBuying() {
        ECUICampaign r100 = getCampaign();
        if (r100 != null) goto L5;
        return "0";
    L5:
        if (r100.isGroup().booleanValue() == true) goto L7;
        return "0";
    L7:
        if (r100.inCampaignTime() == false) goto L13;
        return "1";
    L13:
        return "0";
    }

    public final boolean shouldShowStepper() {
        if (getStepperInfo() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final ECUIActivity getActivity() {
        return this.activity;
    }

    public final int getApplyCoupon() {
        return this.applyCoupon;
    }

    public final ECUIAskExplainInfo getAskExplainInfo() {
        return this.askExplainInfo;
    }

    public final ECAtmosphere getAtmosphere() {
        return this.atmosphere;
    }

    public final ECUIPromotion.AtmosphereTopState getAtmosphereHeaderState() {
        return this.atmosphereHeaderState;
    }

    public final ECPromotionAuctionInfo getAuctionInfo() {
        return this.auctionInfo;
    }

    public final ECCurrentPromotion.PopBackground getBackground() {
        return this.background;
    }

    public final List<PromotionBenefitLabel> getBenefitLabels() {
        return this.benefitLabels;
    }

    public final String getBizIdentity() {
        return this.bizIdentity;
    }

    public final boolean getCanAddShopCart() {
        return this.canAddShopCart;
    }

    public final ECCategoryData getCategoryData() {
        return this.categoryData;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final Integer getChannelType() {
        return this.channelType;
    }

    public final String getCheckCallback() {
        return this.checkCallback;
    }

    public final b getClientData() {
        return this.clientData;
    }

    public final ECCombination getCombination() {
        return this.combination;
    }

    public final String getCostPrice() {
        return this.costPrice;
    }

    public final String getCouponMinPrice() {
        return this.couponMinPrice;
    }

    public final String getCurrentLabel() {
        return this.currentLabel;
    }

    public final ECUrlModel getDetailCover() {
        return this.detailCover;
    }

    public final int getDynamicRecommendIndex() {
        return this.dynamicRecommendIndex;
    }

    public final rl.a getDynamicSlot() {
        return this.dynamicSlot;
    }

    public final String getEcomGroupType() {
        return this.ecomGroupType;
    }

    public final String getEventItemType() {
        return this.eventItemType;
    }

    public final String getEventLabel() {
        return this.eventLabel;
    }

    public final Map<String, String> getEventParams() {
        return this.eventParams;
    }

    public final int getExplainType() {
        return this.explainType;
    }

    public final Map<String, String> getExtraEventParams() {
        return this.extraEventParams;
    }

    public final JSONObject getExtraTransmissibleLogParams() {
        return this.extraTransmissibleLogParams;
    }

    public final int getFlashType() {
        return this.flashType;
    }

    public final boolean getForcePriceModule() {
        return this.forcePriceModule;
    }

    public final String getHasDiscountPrice() {
        return this.hasDiscountPrice;
    }

    public final boolean getHasFlagShopTag() {
        return this.hasFlagShopTag;
    }

    public final boolean getHasPreferredCouponEffect() {
        return this.hasPreferredCouponEffect;
    }

    public final boolean getHasPriceModule() {
        return this.hasPriceModule;
    }

    public final ECHotAtmosphere getHotAtmosphere() {
        return this.hotAtmosphere;
    }

    public final int getIronIndex() {
        return this.ironIndex;
    }

    public final ECJumpDestination getJumpDestination() {
        return this.jumpDestination;
    }

    public final String getLeafCategory() {
        return this.leafCategory;
    }

    public final String getLiveLabelNameFromEventParams() {
        return this.liveLabelNameFromEventParams;
    }

    public final int getLocalNum() {
        return this.localNum;
    }

    public final String getLogid() {
        return this.logid;
    }

    public final ECUILotteryInfo getLotteryInfo() {
        return this.lotteryInfo;
    }

    public final String getOriginId() {
        return this.originId;
    }

    public final String getOriginType() {
        return this.originType;
    }

    public final PrefetchOrder getPrefetchOrder() {
        return this.prefetchOrder;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final ll.a getPromotionBottom() {
        return this.promotionBottom;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final List<String> getPromotionListHeaderLabelNames() {
        return this.promotionListHeaderLabelNames;
    }

    public final int getRealIndex() {
        return this.realIndex;
    }

    public final String getRealPrice() {
        return this.realPrice;
    }

    public final Map<String, List<ECRitTag>> getRitTag() {
        return this.ritTag;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final String getShowNotice() {
        return this.showNotice;
    }

    public final boolean getSingleSku() {
        return this.singleSku;
    }

    public final StandardEventTrack getStandardEventTrack() {
        return this.standardEventTrack;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getTrackExtra() {
        return this.trackExtra;
    }

    public final int getUltimateBuyType() {
        return this.ultimateBuyType;
    }

    public final RitTagTrack getUpIconTagTrack() {
        return this.upIconTagTrack;
    }

    public final boolean isInsuranceProduct() {
        return this.isInsuranceProduct;
    }

    public final boolean isMultiGroupBuy() {
        return this.isMultiGroupBuy;
    }

    public final boolean isPopCard() {
        return this.isPopCard;
    }

    public final boolean isRelatedInfo() {
        return this.isRelatedInfo;
    }

    public final boolean isShowCombination() {
        return this.isShowCombination;
    }

    public final boolean isWithinFirstScreenLimit() {
        return this.isWithinFirstScreenLimit;
    }

    public final synchronized void appendExtraEventParams(Map<String, String> r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "map");     // Catch: Throwable -> L9
        LinkedHashMap r101 = new LinkedHashMap();     // Catch: Throwable -> L9
        Map<String, String> r102 = this.extraEventParams;     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        r101.putAll(r102);     // Catch: Throwable -> L9
    L6:
        r101.putAll(r100);     // Catch: Throwable -> L9
        this.extraEventParams = r101;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final JSONObject getTransmissibleJson(boolean r100) {
        JSONObject r101 = new JSONObject();
        JSONObject r102 = this.extraTransmissibleLogParams;     // Catch: JSONException -> L56
        if (r102 == null) goto L9;
        Iterator<String> r103 = r102.keys();     // Catch: JSONException -> L56
    L7:
        if (r103.hasNext() == false) goto L9;
        String r104 = r103.next();     // Catch: JSONException -> L56
        r101.putOpt(r104, r102.opt(r104));     // Catch: JSONException -> L56
    L9:
        Iterator<Map.Entry<String, String>> r105 = getNewUserActivity().entrySet().iterator();     // Catch: JSONException -> L56
    L11:
        if (r105.hasNext() == false) goto L13;
        Map.Entry<String, String> r106 = r105.next();     // Catch: JSONException -> L56
        r101.put(r106.getKey(), r106.getValue());     // Catch: JSONException -> L56
        goto L11
    L13:
        r101.put("inventory_status", getInventoryStatus());     // Catch: JSONException -> L56
        r101.put(com.bytedance.android.ec.core.event.a.KEY_REAL_PRICE, this.realPrice);     // Catch: JSONException -> L56
        r101.put(com.bytedance.android.ec.core.event.a.KEY_COST_PRICE, this.costPrice);     // Catch: JSONException -> L56
        r101.put("list_num", this.ironIndex);     // Catch: JSONException -> L56
        r101.put("promotion_id", this.promotionId);     // Catch: JSONException -> L56
        if (this.isShowCombination == false) goto L16;
        String r107 = "1";
    L17:
        r101.put("is_exist_matching_button", r107);     // Catch: JSONException -> L56
        if (isLottery() == false) goto L31;
        ECUILotteryInfo r108 = this.lotteryInfo;     // Catch: JSONException -> L56
        Integer r109 = null;
        if (r108 == null) goto L22;
        Integer r110 = Integer.valueOf(r108.getLotteryType());     // Catch: JSONException -> L56
    L23:
        r101.put("lottery_type", r110);     // Catch: JSONException -> L56
        ECUILotteryInfo r111 = this.lotteryInfo;     // Catch: JSONException -> L56
        if (r111 == null) goto L26;
        String r112 = r111.getActivityId();     // Catch: JSONException -> L56
    L27:
        r101.put("lottery_activity_id", r112);     // Catch: JSONException -> L56
        ECUILotteryInfo r113 = this.lotteryInfo;     // Catch: JSONException -> L56
        if (r113 == null) goto L30;
        r109 = Integer.valueOf(r113.getUserActivityStatus());     // Catch: JSONException -> L56
    L30:
        r101.put("lottery_status", r109);     // Catch: JSONException -> L56
        goto L31
    L26:
        r112 = null;
        goto L27
    L22:
        r110 = null;
    L31:
        Map<String, String> r114 = this.eventParams;     // Catch: JSONException -> L56
        if (r114 == null) goto L38;
        Iterator<Map.Entry<String, String>> r115 = r114.entrySet().iterator();     // Catch: JSONException -> L56
    L35:
        if (r115.hasNext() == false) goto L38;
        Map.Entry<String, String> r116 = r115.next();     // Catch: JSONException -> L56
        r101.put(r116.getKey(), r116.getValue());     // Catch: JSONException -> L56
    L38:
        if (canShowHotAtmosphere() == false) goto L40;
        int r117 = 1;
    L41:
        r101.put("is_hot_sale", r117);     // Catch: JSONException -> L56
        if (r100 == false) goto L44;
        r101.put("hot_sale_num", getHotAtmosphereSaleNum());     // Catch: JSONException -> L56
    L44:
        r101.put("hot_sale_type", getHotSaleTypeStr());     // Catch: JSONException -> L56
        d r118 = this.clientData.f533697f;     // Catch: JSONException -> L56
        if (r118 == null) goto L58;
        String r119 = r118.f533701a;     // Catch: JSONException -> L56
        if (r119 == null) goto L49;
        r101.put("live_tab_id", r119);     // Catch: JSONException -> L56
    L49:
        String r120 = r118.f533702b;     // Catch: JSONException -> L56
        if (r120 == null) goto L52;
        r101.put("tab_type", r120);     // Catch: JSONException -> L56
    L52:
        String r121 = r118.f533703c;     // Catch: JSONException -> L56
        if (r121 == null) goto L58;
        r101.put(com.bytedance.android.ec.core.event.a.KEY_HEAD_TAB_RANK, r121);     // Catch: JSONException -> L56
    L58:
        return r101;
    L40:
        r117 = 0;
        goto L41
    L16:
        r107 = "0";
    L56:
        e = move-exception;
        e.printStackTrace();
        goto L58
    }

    public final void setActivity(ECUIActivity r100) {
        this.activity = r100;
    }

    public final void setApplyCoupon(int r100) {
        this.applyCoupon = r100;
    }

    public final void setAskExplainInfo(ECUIAskExplainInfo r100) {
        this.askExplainInfo = r100;
    }

    public final void setAtmosphere(ECAtmosphere r100) {
        this.atmosphere = r100;
    }

    public final void setAtmosphereHeaderState(ECUIPromotion.AtmosphereTopState r100) {
        this.atmosphereHeaderState = r100;
    }

    public final void setAuctionInfo(ECPromotionAuctionInfo r100) {
        this.auctionInfo = r100;
    }

    public final void setBackground(ECCurrentPromotion.PopBackground r100) {
        this.background = r100;
    }

    public final void setBenefitLabels(List<PromotionBenefitLabel> r100) {
        this.benefitLabels = r100;
    }

    public final void setBizIdentity(String r100) {
        this.bizIdentity = r100;
    }

    public final void setCanAddShopCart(boolean r100) {
        this.canAddShopCart = r100;
    }

    public final void setCategoryData(ECCategoryData r100) {
        this.categoryData = r100;
    }

    public final void setChannelId(String r100) {
        this.channelId = r100;
    }

    public final void setChannelType(Integer r100) {
        this.channelType = r100;
    }

    public final void setCheckCallback(String r100) {
        this.checkCallback = r100;
    }

    public final void setCombination(ECCombination r100) {
        this.combination = r100;
    }

    public final void setCostPrice(String r100) {
        this.costPrice = r100;
    }

    public final void setCouponMinPrice(String r100) {
        this.couponMinPrice = r100;
    }

    public final void setCurrentLabel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.currentLabel = r100;
    }

    public final void setDetailCover(ECUrlModel r100) {
        this.detailCover = r100;
    }

    public final void setDynamicRecommendIndex(int r100) {
        this.dynamicRecommendIndex = r100;
    }

    public final void setDynamicSlot(rl.a r100) {
        this.dynamicSlot = r100;
    }

    public final void setEcomGroupType(String r100) {
        this.ecomGroupType = r100;
    }

    public final void setEventItemType(String r100) {
        this.eventItemType = r100;
    }

    public final void setEventLabel(String r100) {
        this.eventLabel = r100;
    }

    public final void setEventParams(Map<String, String> r100) {
        this.eventParams = r100;
    }

    public final void setExplainType(int r100) {
        this.explainType = r100;
    }

    public final void setExtraEventParams(Map<String, String> r100) {
        this.extraEventParams = r100;
    }

    public final void setExtraTransmissibleLogParams(JSONObject r100) {
        this.extraTransmissibleLogParams = r100;
    }

    public final void setFlashType(int r100) {
        this.flashType = r100;
    }

    public final void setForcePriceModule(boolean r100) {
        this.forcePriceModule = r100;
    }

    public final void setHasDiscountPrice(String r100) {
        this.hasDiscountPrice = r100;
    }

    public final void setHasFlagShopTag(boolean r100) {
        this.hasFlagShopTag = r100;
    }

    public final void setHasPreferredCouponEffect(boolean r100) {
        this.hasPreferredCouponEffect = r100;
    }

    public final void setHasPriceModule(boolean r100) {
        this.hasPriceModule = r100;
    }

    public final void setHotAtmosphere(ECHotAtmosphere r100) {
        this.hotAtmosphere = r100;
    }

    public final void setInsuranceProduct(boolean r100) {
        this.isInsuranceProduct = r100;
    }

    public final void setIronIndex(int r100) {
        this.ironIndex = r100;
    }

    public final void setJumpDestination(ECJumpDestination r100) {
        this.jumpDestination = r100;
    }

    public final void setLeafCategory(String r100) {
        this.leafCategory = r100;
    }

    public final void setLiveLabelNameFromEventParams(String r100) {
        this.liveLabelNameFromEventParams = r100;
    }

    public final void setLocalNum(int r100) {
        this.localNum = r100;
    }

    public final void setLogid(String r100) {
        this.logid = r100;
    }

    public final void setLotteryInfo(ECUILotteryInfo r100) {
        this.lotteryInfo = r100;
    }

    public final void setMultiGroupBuy(boolean r100) {
        this.isMultiGroupBuy = r100;
    }

    public final void setOriginId(String r100) {
        this.originId = r100;
    }

    public final void setOriginType(String r100) {
        this.originType = r100;
    }

    public final void setPopCard(boolean r100) {
        this.isPopCard = r100;
    }

    public final void setPrefetchOrder(PrefetchOrder r100) {
        this.prefetchOrder = r100;
    }

    public final void setProductId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.productId = r100;
    }

    public final void setPromotionBottom(ll.a r100) {
        this.promotionBottom = r100;
    }

    public final void setPromotionId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.promotionId = r100;
    }

    public final void setPromotionListHeaderLabelNames(List<String> r100) {
        this.promotionListHeaderLabelNames = r100;
    }

    public final void setRealIndex(int r100) {
        this.realIndex = r100;
    }

    public final void setRealPrice(String r100) {
        this.realPrice = r100;
    }

    public final void setRelatedInfo(boolean r100) {
        this.isRelatedInfo = r100;
    }

    public final void setRitTag(Map<String, ? extends List<ECRitTag>> r100) {
        this.ritTag = r100;
    }

    public final void setScheme(String r100) {
        this.scheme = r100;
    }

    public final void setShopId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.shopId = r100;
    }

    public final void setShowCombination(boolean r100) {
        this.isShowCombination = r100;
    }

    public final void setShowNotice(String r100) {
        this.showNotice = r100;
    }

    public final void setSingleSku(boolean r100) {
        this.singleSku = r100;
    }

    public final void setStandardEventTrack(StandardEventTrack r100) {
        this.standardEventTrack = r100;
    }

    public final void setStatus(int r100) {
        this.status = r100;
    }

    public final void setTrackExtra(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.trackExtra = r100;
    }

    public final void setUltimateBuyType(int r100) {
        this.ultimateBuyType = r100;
    }

    public final void setUpIconTagTrack(RitTagTrack r100) {
        this.upIconTagTrack = r100;
    }

    public final void setWithinFirstScreenLimit(boolean r100) {
        this.isWithinFirstScreenLimit = r100;
    }

    public final String tagSetToString(Set<String> r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100 == null) goto L12;
        Iterator<String> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();
        if (r101.length() <= 0) goto L10;
        r101.append(",");
    L10:
        r101.append(r103);
    L12:
        return r101.toString();
    }

    public final void addTagToSet(Set<String> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "set");
        Intrinsics.checkNotNullParameter(r101, "tagStr");
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        int r102 = 0;
        Object[] r103 = StringsKt.split$default(r101, new String[]{","}, false, 0, 6, null).toArray(new String[0]);
        if (r103 == null) goto L15;
        String[] r104 = (String[]) r103;
        int r105 = r104.length;
    L8:
        if (r102 >= r105) goto L13;
        String r106 = r104[r102];
        if (TextUtils.isEmpty(r106) == true) goto L12;
        r100.add(r106);
    L12:
        r102 = r102 + 1;
        goto L8
    L13:
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final synchronized void appendExtraEventParams(String r100, String r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r101, "value");     // Catch: Throwable -> L9
        HashMap r102 = new HashMap();     // Catch: Throwable -> L9
        Map<String, String> r103 = this.extraEventParams;     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        r102.putAll(r103);     // Catch: Throwable -> L9
    L6:
        r102.put(r100, r101);     // Catch: Throwable -> L9
        this.extraEventParams = r102;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
