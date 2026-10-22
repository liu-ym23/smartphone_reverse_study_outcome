package r14;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ai.api.navi.AppletNaviType;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.awemeopen.bizmodels.feed.AwemeHybridLabelModel;
import com.bytedance.awemeopen.bizmodels.feed.AwemeStatus;
import com.bytedance.awemeopen.bizmodels.feed.ModelRate;
import com.bytedance.awemeopen.bizmodels.feed.Video;
import com.bytedance.awemeopen.bizmodels.feed.mix.MixStruct;
import com.bytedance.awemeopen.bizmodels.feed.poi.PoiItemAnchorInfo;
import com.bytedance.awemeopen.bizmodels.feed.poi.PoiTradeGoodsLifeStruct;
import com.bytedance.awemeopen.bizmodels.feed.shopping.card.ShoppingCardInfo;
import com.bytedance.awemeopen.bizmodels.feed.shopping.cpscard.CpsShoppingCardInfo;
import com.bytedance.awemeopen.bizmodels.feed.shopping.cpscard.ProductDetail;
import com.bytedance.awemeopen.bizmodels.feed.video.TextExtraStruct;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bduploader.BDVideoUploaderBase;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.tencent.open.SocialConstants;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u009c\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002:\u0004\u008c\u0002\u008d\u0002B\t¢\u0006\u0006\b\u008a\u0002\u0010\u008b\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0000R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010/\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00106\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R*\u0010>\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020 8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bD\u0010\"R$\u0010F\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010M\u001a\u0004\u0018\u00010L8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR*\u0010R\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010<8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bR\u0010?\u001a\u0004\bS\u0010A\"\u0004\bT\u0010CR\"\u0010V\u001a\u00020U8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010\\\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\\\u0010\u0012\u001a\u0004\b]\u0010\u0014\"\u0004\b^\u0010\u0016R\"\u0010_\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b_\u0010\"\u001a\u0004\b`\u0010$\"\u0004\ba\u0010&R$\u0010c\u001a\u0004\u0018\u00010b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR$\u0010j\u001a\u0004\u0018\u00010i8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR$\u0010q\u001a\u0004\u0018\u00010p8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR*\u0010w\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010<8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bw\u0010?\u001a\u0004\bx\u0010A\"\u0004\by\u0010CR*\u0010{\u001a\n\u0012\u0004\u0012\u00020z\u0018\u00010<8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b{\u0010?\u001a\u0004\b|\u0010A\"\u0004\b}\u0010CR,\u0010\u007f\u001a\n\u0012\u0004\u0012\u00020~\u0018\u00010<8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b\u007f\u0010?\u001a\u0005\b\u0080\u0001\u0010A\"\u0005\b\u0081\u0001\u0010CR\u001a\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010\u0012R&\u0010\u0083\u0001\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0083\u0001\u0010\"\u001a\u0005\b\u0084\u0001\u0010$\"\u0005\b\u0085\u0001\u0010&R,\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R(\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008d\u0001\u0010\u0012\u001a\u0005\b\u008e\u0001\u0010\u0014\"\u0005\b\u008f\u0001\u0010\u0016R&\u0010\u0090\u0001\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0090\u0001\u0010\"\u001a\u0005\b\u0090\u0001\u0010$\"\u0005\b\u0091\u0001\u0010&R,\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R/\u0010\u009a\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0099\u0001\u0018\u00010<8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009a\u0001\u0010?\u001a\u0005\b\u009b\u0001\u0010A\"\u0005\b\u009c\u0001\u0010CR\u001c\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009d\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R,\u0010¡\u0001\u001a\u0005\u0018\u00010 \u00018F@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b¡\u0001\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R,\u0010¨\u0001\u001a\u0005\u0018\u00010§\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b¨\u0001\u0010©\u0001\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010\u00ad\u0001R(\u0010®\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b®\u0001\u0010\u0012\u001a\u0005\b¯\u0001\u0010\u0014\"\u0005\b°\u0001\u0010\u0016R&\u0010±\u0001\u001a\u00020U8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b±\u0001\u0010W\u001a\u0005\b±\u0001\u0010Y\"\u0005\b²\u0001\u0010[R+\u0010´\u0001\u001a\u0005\u0018\u00010³\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0006\b´\u0001\u0010µ\u0001\u001a\u0005\b)\u0010¶\u0001\"\u0006\b·\u0001\u0010¸\u0001R/\u0010º\u0001\u001a\u000b\u0012\u0005\u0012\u00030¹\u0001\u0018\u00010<8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bº\u0001\u0010?\u001a\u0005\b»\u0001\u0010A\"\u0005\b¼\u0001\u0010CR&\u0010½\u0001\u001a\u00020U8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b½\u0001\u0010W\u001a\u0005\b¾\u0001\u0010Y\"\u0005\b¿\u0001\u0010[R,\u0010Á\u0001\u001a\u0005\u0018\u00010À\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÁ\u0001\u0010Â\u0001\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001R,\u0010È\u0001\u001a\u0005\u0018\u00010Ç\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÈ\u0001\u0010É\u0001\u001a\u0006\bÊ\u0001\u0010Ë\u0001\"\u0006\bÌ\u0001\u0010Í\u0001R&\u0010Î\u0001\u001a\u00020U8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÎ\u0001\u0010W\u001a\u0005\bÏ\u0001\u0010Y\"\u0005\bÐ\u0001\u0010[R,\u0010Ò\u0001\u001a\u0005\u0018\u00010Ñ\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÒ\u0001\u0010Ó\u0001\u001a\u0006\bÔ\u0001\u0010Õ\u0001\"\u0006\bÖ\u0001\u0010×\u0001R,\u0010Ù\u0001\u001a\u0005\u0018\u00010Ø\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÙ\u0001\u0010Ú\u0001\u001a\u0006\bÛ\u0001\u0010Ü\u0001\"\u0006\bÝ\u0001\u0010Þ\u0001R(\u0010ß\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bß\u0001\u0010\u0012\u001a\u0005\bà\u0001\u0010\u0014\"\u0005\bá\u0001\u0010\u0016R0\u0010ä\u0001\u001a\f\u0012\u0005\u0012\u00030ã\u0001\u0018\u00010â\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bä\u0001\u0010?\u001a\u0005\bå\u0001\u0010A\"\u0005\bæ\u0001\u0010CR/\u0010è\u0001\u001a\u00020U2\u0007\u0010ç\u0001\u001a\u00020U8\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\bè\u0001\u0010W\u001a\u0005\bè\u0001\u0010Y\"\u0005\bé\u0001\u0010[R&\u0010ê\u0001\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bê\u0001\u0010\"\u001a\u0005\bë\u0001\u0010$\"\u0005\bì\u0001\u0010&R&\u0010í\u0001\u001a\u00020U8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bí\u0001\u0010W\u001a\u0005\bî\u0001\u0010Y\"\u0005\bï\u0001\u0010[R(\u0010ð\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bð\u0001\u0010\u0012\u001a\u0005\bñ\u0001\u0010\u0014\"\u0005\bò\u0001\u0010\u0016R&\u0010ó\u0001\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bó\u0001\u0010\"\u001a\u0005\bô\u0001\u0010$\"\u0005\bõ\u0001\u0010&R&\u0010ö\u0001\u001a\u00020U8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bö\u0001\u0010W\u001a\u0005\b÷\u0001\u0010Y\"\u0005\bø\u0001\u0010[R\u001c\u0010ú\u0001\u001a\u0005\u0018\u00010ù\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bú\u0001\u0010û\u0001R\u001f\u0010ü\u0001\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bü\u0001\u0010\u0012\u001a\u0005\bý\u0001\u0010\u0014R(\u0010þ\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bþ\u0001\u0010\u0012\u001a\u0005\bÿ\u0001\u0010\u0014\"\u0005\b\u0080\u0002\u0010\u0016R(\u0010\u0081\u0002\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0081\u0002\u0010\u0012\u001a\u0005\b\u0082\u0002\u0010\u0014\"\u0005\b\u0083\u0002\u0010\u0016R+\u0010\u0085\u0002\u001a\u0005\u0018\u00010\u0084\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0006\b\u0085\u0002\u0010\u0086\u0002\u001a\u0005\b\"\u0010\u0087\u0002\"\u0006\b\u0088\u0002\u0010\u0089\u0002¨\u0006\u008e\u0002"}, d2 = {"Lr14/c;", "", "", ShareChannel.DOUYIN, "", "update", "Lcom/bytedance/awemeopen/bizmodels/feed/mix/MixStruct;", "mixInfo", "Lcom/bytedance/awemeopen/bizmodels/feed/mix/MixStruct;", "y", "()Lcom/bytedance/awemeopen/bizmodels/feed/mix/MixStruct;", "setMixInfo", "(Lcom/bytedance/awemeopen/bizmodels/feed/mix/MixStruct;)V", "Lr14/s;", "extra", "Lr14/s;", "", "aid", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "d0", "(Ljava/lang/String;)V", "groupId", "t", "setGroupId", SocialConstants.PARAM_APP_DESC, "p", "f0", "previewTitle", FaceService.girlLabel, "setPreviewTitle", "", "duration", "I", "q", "()I", "setDuration", "(I)V", "", "createTime", "J", "o", "()J", "setCreateTime", "(J)V", "Lcom/bytedance/awemeopen/bizmodels/profile/User;", "author", "Lcom/bytedance/awemeopen/bizmodels/profile/User;", "f", "()Lcom/bytedance/awemeopen/bizmodels/profile/User;", "setAuthor", "(Lcom/bytedance/awemeopen/bizmodels/profile/User;)V", "Le24/b;", "music", "Le24/b;", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "()Le24/b;", "setMusic", "(Le24/b;)V", "", "Lr14/m;", "challengeList", "Ljava/util/List;", ce.f26396k, "()Ljava/util/List;", "setChallengeList", "(Ljava/util/List;)V", "isHashTag", "Lcom/bytedance/awemeopen/bizmodels/feed/Video;", "video", "Lcom/bytedance/awemeopen/bizmodels/feed/Video;", "P", "()Lcom/bytedance/awemeopen/bizmodels/feed/Video;", "setVideo", "(Lcom/bytedance/awemeopen/bizmodels/feed/Video;)V", "Lr14/t;", "fakeHorizontalInfo", "Lr14/t;", "s", "()Lr14/t;", "Lr14/y;", "images", BaseSwitches.V, "setImages", "", "isStory", "Z", "a0", "()Z", "setStory", "(Z)V", "shareUrl", "getShareUrl", "setShareUrl", "userDigg", "getUserDigg", "setUserDigg", "Lr14/j;", "statistics", "Lr14/j;", "L", "()Lr14/j;", "setStatistics", "(Lr14/j;)V", "Lcom/bytedance/awemeopen/bizmodels/feed/AwemeStatus;", "status", "Lcom/bytedance/awemeopen/bizmodels/feed/AwemeStatus;", "M", "()Lcom/bytedance/awemeopen/bizmodels/feed/AwemeStatus;", "setStatus", "(Lcom/bytedance/awemeopen/bizmodels/feed/AwemeStatus;)V", "Lr14/h0;", "videoControl", "Lr14/h0;", "getVideoControl", "()Lr14/h0;", "setVideoControl", "(Lr14/h0;)V", "geofencingRegions", "getGeofencingRegions", "setGeofencingRegions", "Lcom/bytedance/awemeopen/bizmodels/feed/AwemeHybridLabelModel;", "hybridLabels", "getHybridLabels", "setHybridLabels", "Lr14/g;", "videoLabels", "getVideoLabels", "setVideoLabels", "uploadMiscInfoStructStr", "commentSetting", "getCommentSetting", "setCommentSetting", "Lr14/d;", "awemeACLShareInfo", "Lr14/d;", "getAwemeACLShareInfo", "()Lr14/d;", "setAwemeACLShareInfo", "(Lr14/d;)V", "musicDisplayMappingTitle", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setMusicDisplayMappingTitle", "isMeteor", "setMeteor", "Ls14/a;", "anchor", "Ls14/a;", "getAnchor", "()Ls14/a;", "setAnchor", "(Ls14/a;)V", "Ls14/b;", "anchors", "getAnchors", "setAnchors", "Ls14/d;", "anchorInfo", "Ls14/d;", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/t;", "poiStruct", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/t;", "C", "()Lcom/bytedance/awemeopen/bizmodels/feed/poi/t;", "setPoiStruct", "(Lcom/bytedance/awemeopen/bizmodels/feed/poi/t;)V", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/p;", "poiPatchStruct", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/p;", "getPoiPatchStruct", "()Lcom/bytedance/awemeopen/bizmodels/feed/poi/p;", "setPoiPatchStruct", "(Lcom/bytedance/awemeopen/bizmodels/feed/poi/p;)V", "rawAdData", FaceService.neutralLabel, "setRawAdData", "isCanPlay", "setCanPlay", "Lx14/a;", "shareInfo", "Lx14/a;", "()Lx14/a;", "setShareInfo", "(Lx14/a;)V", "Lr14/k;", "textVideoLabels", "getTextVideoLabels", "setTextVideoLabels", "isAd", ExifInterface.LATITUDE_SOUTH, "setAd", "Lr14/i;", "awemeRiskModel", "Lr14/i;", "h", "()Lr14/i;", "setAwemeRiskModel", "(Lr14/i;)V", "Lcom/bytedance/awemeopen/bizmodels/feed/ModelRate;", "rate", "Lcom/bytedance/awemeopen/bizmodels/feed/ModelRate;", "G", "()Lcom/bytedance/awemeopen/bizmodels/feed/ModelRate;", "setRate", "(Lcom/bytedance/awemeopen/bizmodels/feed/ModelRate;)V", "cmtSwt", "l", "setCmtSwt", "Lr14/f;", "awemeControl", "Lr14/f;", "getAwemeControl", "()Lr14/f;", "setAwemeControl", "(Lr14/f;)V", "Lr14/e;", "commentPermissionInfo", "Lr14/e;", "m", "()Lr14/e;", "setCommentPermissionInfo", "(Lr14/e;)V", "title", "O", com.alipay.sdk.m.x.d.f25925o, "", "Lcom/bytedance/awemeopen/bizmodels/feed/video/TextExtraStruct;", "textExtra", "N", "i0", "value", "isVr", "setVr", "awemeType", RXScreenCaptureService.KEY_INDEX, "setAwemeType", "isHostVideo", ExifInterface.LONGITUDE_WEST, "h0", "userProfile", "getUserProfile", "setUserProfile", "collectStatus", "getCollectStatus", "setCollectStatus", "isFamiliar", "U", "setFamiliar", "Lv14/a;", "cellRoom", "Lv14/a;", "descLanguage", "getDescLanguage", "hostRawData", "u", "g0", "itemExpandStr", "x", "setItemExpandStr", "Lr14/f0;", "relationLabel", "Lr14/f0;", "()Lr14/f0;", "setRelationLabel", "(Lr14/f0;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class c implements Cloneable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final AtomicLong f535618u = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f535619a;

    @SerializedName(SimilarProductParam.AWEME_ID)
    private String aid;

    @SerializedName("anchor")
    private s14.a anchor;

    @SerializedName("anchor_info")
    private s14.d anchorInfo;

    @SerializedName("anchors")
    private List<s14.b> anchors;

    @SerializedName("author")
    private User author;

    @SerializedName("aweme_acl")
    private r14.d awemeACLShareInfo;

    @SerializedName("aweme_control")
    private f awemeControl;

    @SerializedName("risk_infos")
    private i awemeRiskModel;

    @SerializedName("aweme_type")
    private int awemeType;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f535620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f535621c;

    @SerializedName("cell_room")
    private v14.a cellRoom;

    @SerializedName("cha_list")
    private List<m> challengeList;

    @SerializedName("cmt_swt")
    private boolean cmtSwt;

    @SerializedName("collect_stat")
    private int collectStatus;

    @SerializedName("comment_permission_info")
    private e commentPermissionInfo;

    @SerializedName("item_comment_settings")
    private int commentSetting;

    @SerializedName("create_time")
    private long createTime;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a0 f535622d;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private String desc;

    @SerializedName("desc_language")
    private final String descLanguage;

    @SerializedName("duration")
    private int duration;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient boolean f535623e;

    @SerializedName("extra")
    private s extra;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient r14.b f535624f;

    @SerializedName("fake_horizontal_info")
    private final t fakeHorizontalInfo;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f535625g;

    @SerializedName("geofencing_regions")
    private List<String> geofencingRegions;

    @SerializedName("group_id")
    private String groupId;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.awemeopen.bizmodels.feed.poi.t f535626h;

    @SerializedName("host_raw_data")
    private String hostRawData;

    @SerializedName("hybrid_label")
    private List<AwemeHybridLabelModel> hybridLabels;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PoiTradeGoodsLifeStruct f535627i;

    @SerializedName("images")
    private List<y> images;

    @SerializedName("is_ads")
    private boolean isAd;

    @SerializedName("can_play")
    private boolean isCanPlay;

    @SerializedName("is_familiar")
    private boolean isFamiliar;

    @SerializedName("is_hash_tag")
    private int isHashTag;

    @SerializedName("is_host")
    private boolean isHostVideo;

    @SerializedName("is_meteor")
    private int isMeteor;

    @SerializedName("is_story")
    private boolean isStory;

    @SerializedName("is_vr")
    private boolean isVr;

    @SerializedName("item_expand_data")
    private String itemExpandStr;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public transient ArrayList<ShoppingCardInfo> f535628j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public transient CpsShoppingCardInfo f535629k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f535630l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f535631m;

    @SerializedName("mix_info")
    private MixStruct mixInfo;

    @SerializedName("music")
    private e24.b music;

    @SerializedName("music_display_mapping_title")
    private String musicDisplayMappingTitle;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f535632n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f535633o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f535634p;

    @SerializedName("poi_patch_info")
    private com.bytedance.awemeopen.bizmodels.feed.poi.p poiPatchStruct;

    @SerializedName("poi_info")
    private com.bytedance.awemeopen.bizmodels.feed.poi.t poiStruct;

    @SerializedName("preview_title")
    private String previewTitle;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f535635q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f535636r;

    @SerializedName("rate")
    private ModelRate rate;

    @SerializedName("raw_ad_data")
    private String rawAdData;

    @SerializedName("relation_label")
    private f0 relationLabel;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public transient Map<Integer, ? extends List<w>> f535637s;

    @SerializedName("share_info")
    private x14.a shareInfo;

    @SerializedName("share_url")
    private String shareUrl;

    @SerializedName("statistics")
    private j statistics;

    @SerializedName("status")
    private AwemeStatus status;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f535638t;

    @SerializedName("text_extra")
    private List<TextExtraStruct> textExtra;

    @SerializedName("video_text")
    private List<k> textVideoLabels;

    @SerializedName("title")
    private String title;

    @SerializedName("misc_info")
    private String uploadMiscInfoStructStr;

    @SerializedName("user_digged")
    private int userDigg;

    @SerializedName(BdpAppEventConstant.USER_PROFILE)
    private String userProfile;

    @SerializedName("video")
    private Video video;

    @SerializedName("video_control")
    private h0 videoControl;

    @SerializedName("video_labels")
    private List<g> videoLabels;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lr14/c$b;", "", "", "imprId", "Ljava/lang/String;", "getImprId", "()Ljava/lang/String;", "setImprId", "(Ljava/lang/String;)V", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
    public static final class b {

        @SerializedName("impr_id")
        private String imprId;

        public b() {
        }
    }

    /* JADX INFO: renamed from: r14.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002 \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004\u0018\u00010\u00020\u0001¨\u0006\u0006"}, d2 = {"r14/c$c", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "Lr14/w;", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
    public static final class C7419c extends TypeToken<Map<Integer, ? extends List<? extends w>>> {
        public C7419c() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002 \u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\u00040\u0001¨\u0006\u0005"}, d2 = {"r14/c$d", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/ShoppingCardInfo;", "Lkotlin/collections/ArrayList;", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
    public static final class d extends TypeToken<ArrayList<ShoppingCardInfo>> {
        public d() {
        }
    }

    public final void h0() {
        this.isHostVideo = true;
    }

    static {
        f535618u = new AtomicLong(System.currentTimeMillis());
    }

    public final d0 B() {
        r14.b r100 = this.f535624f;
        if (r100 != null) goto L12;
        int r101 = r14.b.f535617a;
        String r102 = this.uploadMiscInfoStructStr;
        r14.b r103 = new r14.b();
        if (TextUtils.isEmpty(r102) == false) goto L14;
    L11:
        r100 = r103;
        goto L12
    L14:
        r100 = (r14.b) new Gson().fromJson(r102, r14.b.class);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L12:
        this.f535624f = r100;
        return r100.a();
    }

    public final com.bytedance.awemeopen.bizmodels.feed.poi.t C() {
        if (this.f535625g == false) goto L39;
        com.bytedance.awemeopen.bizmodels.feed.poi.t r100 = this.f535626h;
        if (r100 == null) goto L7;
        return r100;
    L7:
        s14.d r101 = this.anchorInfo;
        if (r101 == null) goto L37;
        String r102 = null;
        if (r101 == null) goto L12;
        Integer r103 = r101.getType();
    L13:
        if (r103 == null) goto L37;
        s14.d r104 = this.anchorInfo;
        boolean r105 = false;
        if (r104 == null) goto L22;
        Integer r106 = r104.getType();
        if (r106 == null) goto L22;
        if (r106.intValue() != 2) goto L22;
        r105 = true;
    L22:
        if (r105 == false) goto L37;
        s14.d r107 = this.anchorInfo;
        if (r107 == null) goto L26;
        String r108 = r107.a();
    L28:
        if (TextUtils.isEmpty(r108) == true) goto L37;
        Gson r109 = new Gson();     // Catch: Exception -> L34
        s14.d r110 = this.anchorInfo;     // Catch: Exception -> L34
        if (r110 == null) goto L32;
        r102 = r110.a();     // Catch: Exception -> L34
    L32:
        this.f535626h = (com.bytedance.awemeopen.bizmodels.feed.poi.t) r109.fromJson(r102, com.bytedance.awemeopen.bizmodels.feed.poi.t.class);     // Catch: Exception -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
        goto L37
    L26:
        r108 = null;
        goto L28
    L12:
        r103 = null;
    L37:
        return this.f535626h;
    L39:
        return this.poiStruct;
    }

    public final PoiTradeGoodsLifeStruct D() {
        PoiTradeGoodsLifeStruct r100 = this.f535627i;
        if (r100 == null) goto L5;
        return r100;
    L5:
        s14.d r101 = this.anchorInfo;
        if (r101 == null) goto L43;
        String r102 = null;
        if (r101 == null) goto L10;
        Integer r103 = r101.getType();
    L11:
        if (r103 == null) goto L43;
        s14.d r104 = this.anchorInfo;
        boolean r105 = true;
        if (r104 == null) goto L20;
        Integer r106 = r104.getType();
        if (r106 == null) goto L20;
        if (r106.intValue() != 13010) goto L20;
        boolean r107 = true;
    L21:
        if (r107 == true) goto L32;
        s14.d r108 = this.anchorInfo;
        if (r108 == null) goto L30;
        Integer r109 = r108.getType();
        if (r109 == null) goto L30;
        if (r109.intValue() != 13012) goto L30;
    L31:
        if (r105 == false) goto L43;
    L30:
        r105 = false;
    L32:
        s14.d r110 = this.anchorInfo;
        if (r110 == null) goto L35;
        String r111 = r110.a();
    L37:
        if (TextUtils.isEmpty(r111) == true) goto L43;
        Gson r112 = new Gson();     // Catch: Exception -> L44
        s14.d r113 = this.anchorInfo;     // Catch: Exception -> L44
        if (r113 == null) goto L41;
        r102 = r113.a();     // Catch: Exception -> L44
    L41:
        this.f535627i = (PoiTradeGoodsLifeStruct) r112.fromJson(r102, PoiTradeGoodsLifeStruct.class);     // Catch: Exception -> L44
        goto L43
    L35:
        r111 = null;
    L20:
        r107 = false;
        goto L21
    L10:
        r103 = null;
    L43:
        return this.f535627i;
    }

    public final ArrayList<ShoppingCardInfo> K() {
        ArrayList<ShoppingCardInfo> r100 = this.f535628j;
        if (r100 == null) goto L5;
        return r100;
    L5:
        s14.d r101 = this.anchorInfo;
        if (r101 != null) goto L8;
    L13:
        ArrayList<ShoppingCardInfo> r102 = this.f535628j;
        if (r102 != null) goto L16;
        r102 = new ArrayList();
    L16:
        this.f535628j = r102;
        return r102;
    L8:
        if (com.bytedance.awemeopen.bizmodels.user.d.a(this) == false) goto L13;
        this.f535628j = (ArrayList) new Gson().fromJson(r101.a(), new d().getType());     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public final boolean R() {
        s14.d r100 = this.anchorInfo;
        String r101 = null;
        if (r100 == null) goto L5;
        Integer r102 = r100.getType();
    L7:
        if (r102 != null) goto L10;
    L19:
        if (r102 != null) goto L22;
    L24:
        if (r102 != null) goto L27;
    L29:
        boolean r103 = false;
    L30:
        if (r103 == true) goto L31;
    L18:
        return false;
    L31:
        s14.d r104 = this.anchorInfo;
        if (r104 == null) goto L41;
        String r105 = r104.e();
        if (r105 == null) goto L41;
        if (r105.length() <= 0) goto L38;
        boolean r106 = true;
    L39:
        if (r106 != true) goto L41;
        boolean r107 = true;
    L42:
        if (r107 == false) goto L18;
        s14.d r108 = this.anchorInfo;
        if (r108 == null) goto L46;
        String r109 = r108.g();
    L48:
        if (TextUtils.isEmpty(r109) == false) goto L55;
        s14.d r110 = this.anchorInfo;
        if (r110 == null) goto L53;
        r101 = r110.f();
    L53:
        if (TextUtils.isEmpty(r101) == true) goto L18;
        return true;
    L55:
        return true;
    L46:
        r109 = null;
        goto L48
    L38:
        r106 = false;
    L41:
        r107 = false;
        goto L42
    L27:
        if (r102.intValue() != 13012) goto L29;
    L23:
        r103 = true;
        goto L30
    L22:
        if (r102.intValue() != 13010) goto L24;
    L10:
        if (r102.intValue() != 2) goto L19;
        com.bytedance.awemeopen.bizmodels.feed.poi.t r111 = C();
        if (r111 == null) goto L18;
        String r112 = r111.d();
        if (r112 == null) goto L18;
        if (r112.length() <= 0) goto L18;
        return true;
    L5:
        r102 = null;
        goto L7
    }

    public final boolean T() {
        if (this.collectStatus == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean V() {
        if (this.isHashTag == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean X() {
        if (this.userDigg == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean Y() {
        if (this.isMeteor == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean Z() {
        AwemeStatus r100 = this.status;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.c();
    }

    public final boolean a() {
        if (this.cmtSwt == false) goto L5;
        return false;
    L5:
        f r100 = this.awemeControl;
        if (r100 == null) goto L14;
        if (r100 != null) goto L9;
    L11:
        boolean r101 = false;
    L12:
        if (r101 == false) goto L14;
        return false;
    L9:
        if (r100.a() == true) goto L11;
        r101 = true;
    L14:
        e r102 = this.commentPermissionInfo;
        if (r102 == null) goto L23;
        if (r102 != null) goto L18;
    L20:
        boolean r103 = false;
    L21:
        if (r103 == false) goto L23;
        return false;
    L18:
        if (r102.a() != 3) goto L20;
        r103 = true;
    L23:
        return true;
    }

    public final c b() {
        c r100 = new c();
        r100.aid = this.aid;
        r100.desc = this.desc;
        r100.createTime = this.createTime;
        r100.video = this.video;
        r100.shareUrl = this.shareUrl;
        r100.userDigg = this.userDigg;
        j r101 = this.statistics;
        AwemeStatus r102 = null;
        if (r101 != null) goto L5;
        j r103 = null;
    L6:
        r100.statistics = r103;
        AwemeStatus r104 = this.status;
        if (r104 == null) goto L10;
        r102 = r104.a();
    L10:
        r100.status = r102;
        r100.videoControl = this.videoControl;
        r100.textVideoLabels = this.textVideoLabels;
        r100.cmtSwt = this.cmtSwt;
        r100.title = this.title;
        r100.f535630l = this.f535630l;
        r100.geofencingRegions = this.geofencingRegions;
        boolean r105 = this.isVr;
        r100.isVr = r105;
        Video r106 = r100.video;
        if (r106 == null) goto L18;
        j0 r107 = r106.getPlayAddrH264();
        if (r107 == null) goto L15;
        r107.f535642c = r105;
    L15:
        j0 r108 = r106.getPlayAddrH265();
        if (r108 == null) goto L18;
        r108.f535642c = r105;
    L18:
        r100.collectStatus = this.collectStatus;
        r100.isAd = this.isAd;
        r100.awemeRiskModel = this.awemeRiskModel;
        r100.commentSetting = this.commentSetting;
        r100.awemeACLShareInfo = this.awemeACLShareInfo;
        r100.groupId = this.groupId;
        r100.author = this.author;
        r100.awemeType = this.awemeType;
        r100.f535622d = this.f535622d;
        return r100;
    L5:
        r103 = r101.a();
        goto L6
    }

    public final Map<String, String> b0() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L130
        s14.d r102 = this.anchorInfo;     // Catch: Throwable -> L130
        String r103 = SliceInitService.DEFAULT_SWITCH;
        if (r102 == null) goto L8;
        String r104 = r102.d();     // Catch: Throwable -> L130
        if (r104 == null) goto L8;
    L9:
        JSONObject r105 = new JSONObject(r104);     // Catch: Throwable -> L130
        HashMap r106 = new HashMap();     // Catch: Throwable -> L130
        int r107 = j64.b.f497514a;     // Catch: Throwable -> L130
        AoHostService r108 = (AoHostService) j64.b.a(AoHostService.class);     // Catch: Throwable -> L130
        if (r108 == null) goto L18;
        n48.d r109 = r108.z1();     // Catch: Throwable -> L130
        if (r109 == null) goto L18;
        String r110 = r109.a();     // Catch: Throwable -> L130
        if (r110 == null) goto L18;
        if ((!StringsKt.isBlank(r110)) == false) goto L18;
    L19:
        com.bytedance.awemeopen.bizmodels.feed.poi.t r111 = C();     // Catch: Throwable -> L130
        if (r111 == null) goto L24;
        String r112 = r111.b();     // Catch: Throwable -> L130
        if ((!StringsKt.isBlank(r112)) == false) goto L24;
    L25:
        Iterator<String> r113 = r105.keys();     // Catch: Throwable -> L130
    L27:
        if (r113.hasNext() == false) goto L34;
        String r114 = r113.next();     // Catch: Throwable -> L130
        String r115 = r105.optString(r114);     // Catch: Throwable -> L130
        if ((!StringsKt.isBlank(r115)) == true) goto L32;
        r115 = null;
    L32:
        if (r115 == null) goto L27;
        r106.put(r114, r115);     // Catch: Throwable -> L130
        goto L27
    L34:
        boolean r116 = false;
        if (r110 == null) goto L40;
        if (r112 == null) goto L40;
        if (StringsKt.equals(r110, r112, true) == false) goto L40;
        boolean r117 = true;
    L42:
        String r118 = "1";
        if (r117 == false) goto L45;
        Object r119 = "1";
    L46:
        r106.put("poi_device_samecity", r119);     // Catch: Throwable -> L130
        c0(r106, "recommend_log_id", (String) r106.get("request_id"));     // Catch: Throwable -> L130
        c0(r106, "life_anchor_product_id", (String) r106.get("product_id"));     // Catch: Throwable -> L130
        c0(r106, "life_anchor_product_id", (String) r106.get("spu_id"));     // Catch: Throwable -> L130
        c0(r106, "author_id", (String) r106.get("author_openid"));     // Catch: Throwable -> L130
        com.bytedance.awemeopen.bizmodels.feed.poi.t r120 = C();     // Catch: Throwable -> L130
        if (r120 == null) goto L49;
        c0(r106, "poi_id", r120.d());     // Catch: Throwable -> L130
        c0(r106, "poi_backend_type", r120.a());     // Catch: Throwable -> L130
        r106.put("backend_type_id", r120.a());     // Catch: Throwable -> L130
    L49:
        User r121 = this.author;     // Catch: Throwable -> L130
        if (r121 == null) goto L52;
        String r122 = r121.u();     // Catch: Throwable -> L130
    L53:
        c0(r106, "author_id", r122);     // Catch: Throwable -> L130
        s14.d r123 = this.anchorInfo;     // Catch: Throwable -> L130
        if (r123 == null) goto L62;
        Integer r124 = r123.getType();     // Catch: Throwable -> L130
        if (r124 == null) goto L62;
        if (r124.intValue() != 2) goto L62;
        boolean r125 = true;
    L64:
        if (r125 == false) goto L94;
        c0(r106, "life_anchor_type", AppletNaviType.POI);     // Catch: Throwable -> L130
        com.bytedance.awemeopen.bizmodels.feed.poi.t r126 = C();     // Catch: Throwable -> L130
        if (r126 == null) goto L125;
        com.bytedance.awemeopen.bizmodels.feed.poi.k r127 = r126.e();     // Catch: Throwable -> L130
        if (r127 == null) goto L125;
        com.bytedance.awemeopen.bizmodels.feed.poi.m r128 = r127.a();     // Catch: Throwable -> L130
        if (r128 == null) goto L125;
        PoiItemAnchorInfo r129 = r128.a();     // Catch: Throwable -> L130
        if (r129 == null) goto L125;
        Boolean r130 = Boolean.valueOf(r129.isCommerceIntention());     // Catch: Throwable -> L130
        CharSequence r131 = (CharSequence) r106.get("is_commerce_intention");     // Catch: Throwable -> L130
        if (r131 != null) goto L76;
    L77:
        r116 = true;
    L78:
        if (r116 == false) goto L85;
        if (r130 == null) goto L85;
        if (r130.booleanValue() == true) goto L84;
        r118 = "0";
    L84:
        r106.put("is_commerce_intention", r118);     // Catch: Throwable -> L130
    L85:
        c0(r106, "recommend_log_id", r129.getRequestId());     // Catch: Throwable -> L130
        if (r129.isCommerceIntention() == false) goto L88;
        String r132 = "promotion";
    L89:
        c0(r106, "life_publish_type", r132);     // Catch: Throwable -> L130
        c0(r106, LiveLocalLifeRoomInfo.SALE_CHANNEL, "online_recommend.poi_anchor.default");     // Catch: Throwable -> L130
        if (r129.getHasMpSpu() == false) goto L92;
        String r133 = "true";
    L93:
        c0(r106, "has_service", r133);     // Catch: Throwable -> L130
        goto L125
    L92:
        r133 = "false";
        goto L93
    L88:
        r132 = null;
        goto L89
    L76:
        if (StringsKt.isBlank(r131) == false) goto L78;
    L125:
        if ((!r106.isEmpty()) == true) goto L128;
        r106 = null;
    L128:
        Object r134 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L130
    L133:
        if (Result.m9455isFailureimpl(r134) == true) goto L137;
        r100 = r134;
    L137:
        return (Map) r100;
    L94:
        s14.d r135 = this.anchorInfo;     // Catch: Throwable -> L130
        if (r135 == null) goto L102;
        Integer r136 = r135.getType();     // Catch: Throwable -> L130
        if (r136 == null) goto L102;
        if (r136.intValue() != 13010) goto L102;
        boolean r137 = true;
    L103:
        if (r137 == true) goto L113;
        s14.d r138 = this.anchorInfo;     // Catch: Throwable -> L130
        if (r138 == null) goto L112;
        Integer r139 = r138.getType();     // Catch: Throwable -> L130
        if (r139 == null) goto L112;
        if (r139.intValue() != 13012) goto L112;
        r116 = true;
    L112:
        if (r116 == false) goto L125;
    L113:
        c0(r106, "life_anchor_type", "product_on");     // Catch: Throwable -> L130
        c0(r106, "life_publish_type", "product");     // Catch: Throwable -> L130
        c0(r106, LiveLocalLifeRoomInfo.SALE_CHANNEL, "online_recommend.product_anchor.default");     // Catch: Throwable -> L130
        PoiTradeGoodsLifeStruct r140 = D();     // Catch: Throwable -> L130
        if (r140 == null) goto L125;
        String r141 = r140.getLogExtra();     // Catch: Throwable -> L130
        if (r141 == null) goto L119;
        r103 = r141;
    L119:
        String r142 = new JSONObject(r103).optString("request_id");     // Catch: Throwable -> L130
        if ((!StringsKt.isBlank(r142)) == true) goto L123;
        r142 = null;
    L123:
        c0(r106, "recommend_log_id", r142);     // Catch: Throwable -> L130
        c0(r106, "life_anchor_product_id", r140.getSpuId());     // Catch: Throwable -> L130
    L102:
        r137 = false;
    L62:
        r125 = false;
        goto L64
    L52:
        r122 = null;
        goto L53
    L45:
        r119 = "0";
    L40:
        r117 = false;
    L24:
        r112 = null;
    L18:
        r110 = null;
    L8:
        r104 = SliceInitService.DEFAULT_SWITCH;
    L130:
        th = move-exception;
        Result.Companion r143 = Result.Companion;
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L133
    }

    public final String g() {
        User r100 = this.author;
        if (r100 == null) goto L6;
        String r101 = r100.u();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final int hashCode() {
        return this.aid.hashCode();
    }

    public final CpsShoppingCardInfo n() {
        CpsShoppingCardInfo r100 = this.f535629k;
        if (r100 == null) goto L5;
        return r100;
    L5:
        s14.d r101 = this.anchorInfo;
        Object r102 = null;
        String r103 = null;
        r102 = null;
        if (r101 != null) goto L8;
    L24:
        CpsShoppingCardInfo r104 = (CpsShoppingCardInfo) r102;
        if (r104 != null) goto L27;
        r104 = new CpsShoppingCardInfo();
    L27:
        this.f535629k = r104;
        return r104;
    L8:
        if (com.bytedance.awemeopen.bizmodels.user.d.a(this) == false) goto L24;
        Object r105 = new Gson().fromJson(r101.a(), CpsShoppingCardInfo.class);     // Catch: Exception -> L20
        CpsShoppingCardInfo r106 = (CpsShoppingCardInfo) r105;     // Catch: Exception -> L18
        if (r106 == null) goto L23;
        Gson r107 = new Gson();     // Catch: Exception -> L18
        CpsShoppingCardInfo r108 = (CpsShoppingCardInfo) r105;     // Catch: Exception -> L18
        if (r108 == null) goto L16;
        r103 = r108.getProductDetailStringType$ao_biz_models_release();     // Catch: Exception -> L18
    L16:
        r106.setProductDetail((ProductDetail) r107.fromJson(r103, ProductDetail.class));     // Catch: Exception -> L18
    L23:
        r102 = r105;
    L18:
        Exception e100 = e;
    L22:
        e100.printStackTrace();
    L20:
        e = move-exception;
        e100 = e;
        r105 = null;
        goto L22
    }

    public final s r() {
        s r100 = this.extra;
        if (r100 != null) goto L18;
        r100 = new s();
        if (this.awemeType != 68) goto L7;
        int r101 = 473;
    L17:
        r100.f535649a = Integer.valueOf(r101);
        this.extra = r100;
        goto L18
    L7:
        Video r102 = this.video;
        int r103 = 0;
        if (r102 == null) goto L10;
        int r104 = r102.getWidth();
    L11:
        Video r105 = this.video;
        if (r105 == null) goto L14;
        r103 = r105.getHeight();
    L14:
        if (r104 <= r103) goto L16;
        r101 = 450;
        goto L17
    L16:
        r101 = BDVideoUploaderBase.KeyIsDynamicSliceNormalSize;
        goto L17
    L10:
        r104 = 0;
    L18:
        return r100;
    }

    public final String toString() {
        return "Aweme{aid='" + this.aid + "', desc='" + this.desc + "', createTime=" + this.createTime + ", video=" + this.video + ", shareUrl='" + this.shareUrl + "', userDigg=" + this.userDigg + ", statistics=" + this.statistics + ", status=" + this.status + ", cmtSwt=" + this.cmtSwt + '}';
    }

    public final Map<Integer, List<w>> w() {
        Map r100 = this.f535637s;
        if (r100 == null) goto L11;
        return r100;
    L11:
        this.f535637s = (Map) new Gson().fromJson(this.itemExpandStr, new C7419c().getType());     // Catch: Exception -> L7
    L10:
        return this.f535637s;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public c() {
        this.f535621c = f535618u.getAndIncrement();
        this.aid = "";
        this.groupId = "";
        this.desc = "";
        this.shareUrl = "";
        this.f535625g = true;
        this.isCanPlay = true;
        this.awemeType = -1;
    }

    public final boolean Q() {
        ArrayList<ShoppingCardInfo> r100 = K();
        if (r100.isEmpty() == false) goto L5;
        ShoppingCardInfo r101 = null;
    L6:
        if (r101 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r101 = (ShoppingCardInfo) CollectionsKt.firstOrNull(r100);
        goto L6
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    public final String e() {
        Integer r100 = null;
        if (R() == false) goto L18;
        s14.d r101 = this.anchorInfo;
        if (r101 == null) goto L7;
        r100 = r101.getType();
    L7:
        if (r100 != null) goto L10;
    L12:
        if (r100 != null) goto L15;
    L17:
        return AppletNaviType.POI;
    L15:
        if (r100.intValue() != 13012) goto L17;
        return "poi_combo";
    L10:
        if (r100.intValue() != 13010) goto L12;
        return "poi_product";
    L18:
        AwemeStatus r102 = this.status;
        boolean r103 = false;
        if (r102 != null) goto L21;
    L23:
        if (r103 == false) goto L25;
    L26:
        return PriorityModule.SCENE_EC;
    L25:
        if (CollectionsKt.firstOrNull(K()) != null) goto L26;
        return null;
    L21:
        if (r102.d() != true) goto L23;
        r103 = true;
        goto L23
    }

    public final String A() {
        return this.musicDisplayMappingTitle;
    }

    public final String F() {
        return this.previewTitle;
    }

    public final ModelRate G() {
        return this.rate;
    }

    public final String H() {
        return this.rawAdData;
    }

    public final f0 I() {
        return this.relationLabel;
    }

    public final x14.a J() {
        return this.shareInfo;
    }

    public final j L() {
        return this.statistics;
    }

    public final AwemeStatus M() {
        return this.status;
    }

    public final List<TextExtraStruct> N() {
        return this.textExtra;
    }

    public final String O() {
        return this.title;
    }

    public final Video P() {
        return this.video;
    }

    public final boolean S() {
        return this.isAd;
    }

    public final boolean U() {
        return this.isFamiliar;
    }

    public final boolean W() {
        return this.isHostVideo;
    }

    public final boolean a0() {
        return this.isStory;
    }

    public final String c() {
        return this.aid;
    }

    public final s14.d d() {
        return this.anchorInfo;
    }

    public final User f() {
        return this.author;
    }

    public final i h() {
        return this.awemeRiskModel;
    }

    public final int i() {
        return this.awemeType;
    }

    public final v14.a j() {
        return this.cellRoom;
    }

    public final List<m> k() {
        return this.challengeList;
    }

    public final boolean l() {
        return this.cmtSwt;
    }

    public final e m() {
        return this.commentPermissionInfo;
    }

    public final long o() {
        return this.createTime;
    }

    public final String p() {
        return this.desc;
    }

    public final int q() {
        return this.duration;
    }

    public final t s() {
        return this.fakeHorizontalInfo;
    }

    public final String t() {
        return this.groupId;
    }

    public final String u() {
        return this.hostRawData;
    }

    public final List<y> v() {
        return this.images;
    }

    public final String x() {
        return this.itemExpandStr;
    }

    public final MixStruct y() {
        return this.mixInfo;
    }

    public final e24.b z() {
        return this.music;
    }

    public final void d0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.aid = r100;
    }

    public final void e0(s14.d r100) {
        this.anchorInfo = r100;
        this.f535626h = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (TextUtils.equals(this.aid, r101.aid) == true) goto L11;
    L13:
        return false;
    L11:
        if (this.userDigg != r101.userDigg) goto L13;
        return true;
    }

    public final void f0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.desc = r100;
    }

    public final void g0(String r100) {
        this.hostRawData = r100;
    }

    public final void i0(List<TextExtraStruct> r100) {
        this.textExtra = r100;
    }

    public final void update(c r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100.aid) == false) goto L7;
        String r101 = this.aid;
    L8:
        this.aid = r101;
        String r102 = r100.desc;
        if (r102 != null) goto L11;
        r102 = this.desc;
    L11:
        this.desc = r102;
        long r103 = r100.createTime;
        if (r103 != 0) goto L14;
        r103 = this.createTime;
    L14:
        this.createTime = r103;
        if (TextUtils.isEmpty(r100.shareUrl) == false) goto L17;
        String r104 = this.shareUrl;
    L18:
        this.shareUrl = r104;
        this.userDigg = r100.userDigg;
        this.statistics = r100.statistics;
        AwemeStatus r105 = r100.status;
        if (r105 != null) goto L21;
        r105 = this.status;
    L21:
        this.status = r105;
        Video r106 = r100.video;
        if (r106 != null) goto L24;
        r106 = this.video;
    L24:
        this.video = r106;
        this.isAd = r100.isAd;
        this.awemeRiskModel = r100.awemeRiskModel;
        this.commentSetting = r100.commentSetting;
        this.textVideoLabels = r100.textVideoLabels;
        this.cmtSwt = r100.cmtSwt;
        h0 r107 = r100.videoControl;
        if (r107 != null) goto L27;
        r107 = this.videoControl;
    L27:
        this.videoControl = r107;
        String r108 = r100.title;
        if (r108 != null) goto L30;
        r108 = this.title;
    L30:
        this.title = r108;
        List<String> r109 = r100.geofencingRegions;
        if (r109 == null) goto L33;
        this.geofencingRegions = r109;
    L33:
        this.isCanPlay = r100.isCanPlay;
        this.awemeACLShareInfo = r100.awemeACLShareInfo;
        return;
    L17:
        r104 = r100.shareUrl;
        goto L18
    L7:
        r101 = r100.aid;
        goto L8
    }

    public static final void c0(HashMap<String, String> r100, String r101, String r102) {
        String r103 = r100.get(r101);
        boolean r104 = true;
        if (r103 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L18;
        if (r102 != null) goto L12;
    L15:
        if (r104 == true) goto L19;
        r100.put(r101, r102);
        return;
    L19:
        return;
    L12:
        if (StringsKt.isBlank(r102) == true) goto L15;
        r104 = false;
        goto L15
    L18:
        return;
    L5:
        if (StringsKt.isBlank(r103) == true) goto L8;
        r105 = false;
        goto L9
    }
}
