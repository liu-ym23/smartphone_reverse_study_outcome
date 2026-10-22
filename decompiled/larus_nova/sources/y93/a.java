package y93;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0003\bõ\u0001\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\rR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\rR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\rR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\rR\u001c\u0010!\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u000b\u001a\u0004\b\"\u0010\rR\u001c\u0010$\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u000b\u001a\u0004\b)\u0010\rR\u001c\u0010*\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u000b\u001a\u0004\b+\u0010\rR\u001c\u0010,\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\u000b\u001a\u0004\b-\u0010\rR\u001c\u0010.\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b/\u0010\rR\u001c\u00100\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010\u000b\u001a\u0004\b1\u0010\rR\u001c\u00102\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010\u000b\u001a\u0004\b3\u0010\rR\u001c\u00104\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010\u0016\u001a\u0004\b5\u0010\u0018R\u001c\u00106\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010\u000b\u001a\u0004\b7\u0010\rR\u001c\u00108\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010\u000b\u001a\u0004\b9\u0010\rR\u001c\u0010:\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010\u000b\u001a\u0004\b;\u0010\rR\u001c\u0010<\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010\u0004\u001a\u0004\b=\u0010\u0006R\u001c\u0010>\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010\u000b\u001a\u0004\b?\u0010\rR\u001c\u0010@\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010\u000b\u001a\u0004\bA\u0010\rR\u001c\u0010B\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bB\u0010\u000b\u001a\u0004\bC\u0010\rR\u001c\u0010D\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bD\u0010\u000b\u001a\u0004\bE\u0010\rR\u001c\u0010F\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bF\u0010\u0004\u001a\u0004\bG\u0010\u0006R\u001c\u0010H\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bH\u0010\u0004\u001a\u0004\bI\u0010\u0006R\u001c\u0010J\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bJ\u0010\u0004\u001a\u0004\bK\u0010\u0006R\u001c\u0010L\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\bL\u0010\u0016\u001a\u0004\bM\u0010\u0018R\u001c\u0010N\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bN\u0010\u0004\u001a\u0004\bO\u0010\u0006R\u001c\u0010P\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bP\u0010\u0004\u001a\u0004\bQ\u0010\u0006R\u001c\u0010R\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bR\u0010\u000b\u001a\u0004\bS\u0010\rR\u001c\u0010T\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bT\u0010\u000b\u001a\u0004\bU\u0010\rR\u001c\u0010V\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bV\u0010\u000b\u001a\u0004\bW\u0010\rR\u001c\u0010X\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bX\u0010\u0004\u001a\u0004\bY\u0010\u0006R\u001c\u0010Z\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bZ\u0010\u000b\u001a\u0004\b[\u0010\rR\u001c\u0010\\\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\\\u0010\u000b\u001a\u0004\b]\u0010\rR\u001c\u0010^\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b^\u0010\u0004\u001a\u0004\b_\u0010\u0006R\u001c\u0010`\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b`\u0010\u0004\u001a\u0004\ba\u0010\u0006R\u001c\u0010b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bb\u0010\u000b\u001a\u0004\bc\u0010\rR\u001c\u0010d\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bd\u0010\u000b\u001a\u0004\be\u0010\rR\u001c\u0010f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bf\u0010\u0004\u001a\u0004\bg\u0010\u0006R\u001c\u0010h\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bh\u0010\u0004\u001a\u0004\bi\u0010\u0006R\u001c\u0010j\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bj\u0010\u000b\u001a\u0004\bk\u0010\rR\u001c\u0010l\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bl\u0010\u000b\u001a\u0004\bm\u0010\rR\u001c\u0010n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bn\u0010\u0004\u001a\u0004\bo\u0010\u0006R\u001c\u0010p\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bp\u0010\u0004\u001a\u0004\bq\u0010\u0006R\u001a\u0010r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010uR\u001c\u0010v\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bv\u0010\u000b\u001a\u0004\bw\u0010\rR\u001c\u0010x\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bx\u0010\u000b\u001a\u0004\by\u0010\rR\u001c\u0010z\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bz\u0010\u000b\u001a\u0004\b{\u0010\rR\u001c\u0010|\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b|\u0010\u000b\u001a\u0004\b}\u0010\rR\u001c\u0010~\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b~\u0010\u000b\u001a\u0004\b\u007f\u0010\rR\u001f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0080\u0001\u0010\u000b\u001a\u0005\b\u0081\u0001\u0010\rR\u001f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0082\u0001\u0010\u000b\u001a\u0005\b\u0083\u0001\u0010\rR\u001f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0084\u0001\u0010\u000b\u001a\u0005\b\u0085\u0001\u0010\rR\u001f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0086\u0001\u0010\u000b\u001a\u0005\b\u0087\u0001\u0010\rR\u001f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0088\u0001\u0010\u0016\u001a\u0005\b\u0089\u0001\u0010\u0018R\u001f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u008a\u0001\u0010\u000b\u001a\u0005\b\u008b\u0001\u0010\rR\u001f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u008c\u0001\u0010\u000b\u001a\u0005\b\u008d\u0001\u0010\rR\u001f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u008e\u0001\u0010\u000b\u001a\u0005\b\u008f\u0001\u0010\rR\u001f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0090\u0001\u0010\u0016\u001a\u0005\b\u0091\u0001\u0010\u0018R\u001f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0092\u0001\u0010\u000b\u001a\u0005\b\u0093\u0001\u0010\rR\u001f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0094\u0001\u0010\u000b\u001a\u0005\b\u0095\u0001\u0010\rR\u001f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0096\u0001\u0010\u000b\u001a\u0005\b\u0097\u0001\u0010\rR\u001f\u0010\u0098\u0001\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0098\u0001\u0010%\u001a\u0005\b\u0099\u0001\u0010'R\u001f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u009a\u0001\u0010\u000b\u001a\u0005\b\u009b\u0001\u0010\rR\u001f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u009c\u0001\u0010\u000b\u001a\u0005\b\u009d\u0001\u0010\rR\u001f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u009e\u0001\u0010\u0004\u001a\u0005\b\u009f\u0001\u0010\u0006R\u001f\u0010 \u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b \u0001\u0010\u000b\u001a\u0005\b¡\u0001\u0010\rR\u001f\u0010¢\u0001\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¢\u0001\u0010\u0016\u001a\u0005\b£\u0001\u0010\u0018R\u001f\u0010¤\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¤\u0001\u0010\u0004\u001a\u0005\b¥\u0001\u0010\u0006R\u001f\u0010¦\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¦\u0001\u0010\u0004\u001a\u0005\b§\u0001\u0010\u0006R\u001f\u0010¨\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¨\u0001\u0010\u000b\u001a\u0005\b©\u0001\u0010\rR\u001f\u0010ª\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bª\u0001\u0010\u000b\u001a\u0005\b«\u0001\u0010\rR\u001f\u0010¬\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¬\u0001\u0010\u000b\u001a\u0005\b\u00ad\u0001\u0010\rR\u001f\u0010®\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b®\u0001\u0010\u000b\u001a\u0005\b¯\u0001\u0010\rR\u001f\u0010°\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b°\u0001\u0010\u000b\u001a\u0005\b±\u0001\u0010\rR\u001f\u0010²\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b²\u0001\u0010\u000b\u001a\u0005\b³\u0001\u0010\rR\u001f\u0010´\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b´\u0001\u0010\u000b\u001a\u0005\bµ\u0001\u0010\rR\u001f\u0010¶\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¶\u0001\u0010\u000b\u001a\u0005\b·\u0001\u0010\rR\u001f\u0010¸\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¸\u0001\u0010\u000b\u001a\u0005\b¹\u0001\u0010\rR\u001f\u0010º\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bº\u0001\u0010\u000b\u001a\u0005\b»\u0001\u0010\rR\u001f\u0010¼\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¼\u0001\u0010\u000b\u001a\u0005\b½\u0001\u0010\rR\u001f\u0010¾\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¾\u0001\u0010\u000b\u001a\u0005\b¿\u0001\u0010\rR\u001f\u0010À\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÀ\u0001\u0010\u000b\u001a\u0005\bÁ\u0001\u0010\rR\u001f\u0010Â\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÂ\u0001\u0010\u000b\u001a\u0005\bÃ\u0001\u0010\rR\u001f\u0010Ä\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÄ\u0001\u0010\u000b\u001a\u0005\bÅ\u0001\u0010\rR\u001f\u0010Æ\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÆ\u0001\u0010\u000b\u001a\u0005\bÇ\u0001\u0010\rR\u001f\u0010È\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÈ\u0001\u0010\u000b\u001a\u0005\bÉ\u0001\u0010\rR\u001f\u0010Ê\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÊ\u0001\u0010\u000b\u001a\u0005\bË\u0001\u0010\rR\u001f\u0010Ì\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÌ\u0001\u0010\u000b\u001a\u0005\bÍ\u0001\u0010\rR\u001f\u0010Î\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÎ\u0001\u0010\u000b\u001a\u0005\bÏ\u0001\u0010\rR\u001f\u0010Ð\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÐ\u0001\u0010\u000b\u001a\u0005\bÑ\u0001\u0010\rR\u001f\u0010Ò\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÒ\u0001\u0010\u000b\u001a\u0005\bÓ\u0001\u0010\rR\u001f\u0010Ô\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÔ\u0001\u0010\u000b\u001a\u0005\bÕ\u0001\u0010\rR\u001f\u0010Ö\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÖ\u0001\u0010\u000b\u001a\u0005\b×\u0001\u0010\rR\u001f\u0010Ø\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bØ\u0001\u0010\u000b\u001a\u0005\bÙ\u0001\u0010\rR\u001f\u0010Ú\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÚ\u0001\u0010\u000b\u001a\u0005\bÛ\u0001\u0010\rR\u001f\u0010Ü\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÜ\u0001\u0010\u000b\u001a\u0005\bÝ\u0001\u0010\rR\u001f\u0010Þ\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÞ\u0001\u0010\u000b\u001a\u0005\bß\u0001\u0010\rR\u001f\u0010à\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bà\u0001\u0010\u000b\u001a\u0005\bá\u0001\u0010\rR\u001f\u0010â\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bâ\u0001\u0010\u000b\u001a\u0005\bã\u0001\u0010\rR\u001f\u0010ä\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bä\u0001\u0010\u000b\u001a\u0005\bå\u0001\u0010\rR\u001f\u0010æ\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bæ\u0001\u0010\u000b\u001a\u0005\bç\u0001\u0010\rR\u001f\u0010è\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bè\u0001\u0010\u000b\u001a\u0005\bé\u0001\u0010\rR\u001f\u0010ê\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bê\u0001\u0010\u000b\u001a\u0005\bë\u0001\u0010\rR\u001f\u0010ì\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bì\u0001\u0010\u000b\u001a\u0005\bí\u0001\u0010\rR\u001f\u0010î\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bî\u0001\u0010\u000b\u001a\u0005\bï\u0001\u0010\rR\u001f\u0010ð\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bð\u0001\u0010\u000b\u001a\u0005\bñ\u0001\u0010\rR\u001f\u0010ò\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bò\u0001\u0010\u0004\u001a\u0005\bó\u0001\u0010\u0006R\u001f\u0010ô\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bô\u0001\u0010\u000b\u001a\u0005\bõ\u0001\u0010\rR\u001f\u0010ö\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bö\u0001\u0010\u000b\u001a\u0005\b÷\u0001\u0010\rR\u001f\u0010ø\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bø\u0001\u0010\u000b\u001a\u0005\bù\u0001\u0010\rR\u001f\u0010ú\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bú\u0001\u0010\u000b\u001a\u0005\bû\u0001\u0010\rR\u001f\u0010ü\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bü\u0001\u0010\u000b\u001a\u0005\bý\u0001\u0010\rR\u001f\u0010þ\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bþ\u0001\u0010\u000b\u001a\u0005\bÿ\u0001\u0010\rR\u001f\u0010\u0080\u0002\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0080\u0002\u0010\u000b\u001a\u0005\b\u0081\u0002\u0010\rR\u001f\u0010\u0082\u0002\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0082\u0002\u0010\u000b\u001a\u0005\b\u0083\u0002\u0010\rR\u001f\u0010\u0084\u0002\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0084\u0002\u0010\u000b\u001a\u0005\b\u0085\u0002\u0010\rR\u001f\u0010\u0086\u0002\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0086\u0002\u0010\u000b\u001a\u0005\b\u0087\u0002\u0010\rR\u001f\u0010\u0088\u0002\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0088\u0002\u0010\u000b\u001a\u0005\b\u0089\u0002\u0010\rR\u001f\u0010\u008a\u0002\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u008a\u0002\u0010\u000b\u001a\u0005\b\u008b\u0002\u0010\rR\u001f\u0010\u008c\u0002\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u008c\u0002\u0010\u0004\u001a\u0005\b\u008d\u0002\u0010\u0006R\u001f\u0010\u008e\u0002\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u008e\u0002\u0010\u0004\u001a\u0005\b\u008f\u0002\u0010\u0006R\u001f\u0010\u0090\u0002\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0090\u0002\u0010\u0004\u001a\u0005\b\u0091\u0002\u0010\u0006R\u001f\u0010\u0092\u0002\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0092\u0002\u0010\u0016\u001a\u0005\b\u0093\u0002\u0010\u0018R\u001f\u0010\u0094\u0002\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0094\u0002\u0010\u0004\u001a\u0005\b\u0095\u0002\u0010\u0006R\u001f\u0010\u0096\u0002\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0096\u0002\u0010\u0016\u001a\u0005\b\u0097\u0002\u0010\u0018¨\u0006\u0098\u0002"}, d2 = {"Ly93/a;", "", "", "serverLoginStatus", "Ljava/lang/Integer;", "getServerLoginStatus", "()Ljava/lang/Integer;", "clientLoginStatus", "b", "", "preloadStartTimestamp", "Ljava/lang/Long;", BaseSwitches.V, "()Ljava/lang/Long;", "preloadEndTimestamp", "u", "preloadConfigStart", "getPreloadConfigStart", "preloadConfigEnd", "getPreloadConfigEnd", "", "preloadConfigResult", "Ljava/lang/String;", "getPreloadConfigResult", "()Ljava/lang/String;", "prefetchStart", "getPrefetchStart", "prefetchEnd", "getPrefetchEnd", "openTime", "q", "entranceFragmentCreateViewStart", "getEntranceFragmentCreateViewStart", "entranceFragmentCreateViewEnd", "getEntranceFragmentCreateViewEnd", "", "popupPageStraightOut", "Ljava/lang/Boolean;", "s", "()Ljava/lang/Boolean;", "initLynxStart", "getInitLynxStart", "initLynxEnd", "getInitLynxEnd", "fragmentCreateViewStart", "getFragmentCreateViewStart", "fragmentCreateViewEnd", "getFragmentCreateViewEnd", "loadBundleStart", "getLoadBundleStart", "loadBundleEnd", "getLoadBundleEnd", "loadBundleWay", "l", "netStart", "p", "netEnd", OfficeSDKRequestTag.KEY_NEW_USER, "netEndClient", "o", "catchNoBind", "getCatchNoBind", "handlePrefetchedDataTime", RXScreenCaptureService.KEY_INDEX, "listLoadStart", ce.f26396k, "listFirstScreen", ce.f26395j, "listLoadEnd", "getListLoadEnd", "halfPageOpen", "h", "status", "y", "errCode", "getErrCode", "errMsg", "c", "leaveType", "getLeaveType", "retryStatus", "getRetryStatus", "leaveTime", "getLeaveTime", "geckoStart", "f", "geckoEnd", "e", "geckoStatus", "getGeckoStatus", "depPluginInstallStart", "getDepPluginInstallStart", "depPluginInstallEnd", "getDepPluginInstallEnd", "depPluginStatus", "getDepPluginStatus", "ecPluginStatus", "getEcPluginStatus", "tPrepareCachedDataStart", ExifInterface.LONGITUDE_EAST, "tPrepareCachedDataEnd", "D", "cachedDataPreparedStatus", "getCachedDataPreparedStatus", "dataReuseStatus", "getDataReuseStatus", "tPrepareFirstScreenDataStart", "G", "tPrepareFirstScreenDataEnd", FaceService.girlLabel, "firstScreenDataPreparedStatus", "getFirstScreenDataPreparedStatus", "rebuildScene", "w", "straightOutFlag", "I", "getStraightOutFlag", "()I", "tFirstScreenStraightOutStart", "C", "tFirstScreenStraightOutEnd", "B", "tNAContainerReady", "getTNAContainerReady", "tStraightOutLoadTime", "getTStraightOutLoadTime", "tStraightOutCreateViewTime", "getTStraightOutCreateViewTime", "tDialogFirstScreenStart", "getTDialogFirstScreenStart", "tDialogFirstScreenEnd", "getTDialogFirstScreenEnd", "tDialogPreprocessStartTime", "getTDialogPreprocessStartTime", "tDialogPreprocessEndTime", "getTDialogPreprocessEndTime", "firstChunkName", "getFirstChunkName", "firstChunkReceived", "getFirstChunkReceived", "firstChunkRenderStart", "getFirstChunkRenderStart", "firstChunkRenderEnd", "getFirstChunkRenderEnd", "secondChunkName", "getSecondChunkName", "secondChunkReceived", "getSecondChunkReceived", "secondChunkRenderStart", "x", "secondChunkRenderEnd", "getSecondChunkRenderEnd", "skipRenderWithFullData", "getSkipRenderWithFullData", "tabClickTime", "getTabClickTime", "multiMallFrameTime", "getMultiMallFrameTime", "gylNumOfFirstScreen", ce.f26391f, "immerseBindRealDataTime", "getImmerseBindRealDataTime", "immerseBindRealDataReason", "getImmerseBindRealDataReason", "straightOutHeaderCardType", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "firstScreenHeaderCardType", "d", "tFirstScreenEnd", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "mallCategoryTabFragmentOnCreateStart", "getMallCategoryTabFragmentOnCreateStart", "mallCategoryTabFragmentOnCreateEnd", "getMallCategoryTabFragmentOnCreateEnd", "mallCategoryTabFragmentOnCreateViewStart", "getMallCategoryTabFragmentOnCreateViewStart", "mallCategoryTabFragmentOnCreateViewEnd", "getMallCategoryTabFragmentOnCreateViewEnd", "mallCategoryTabFragmentViewCreatedStart", "getMallCategoryTabFragmentViewCreatedStart", "mallCategoryTabFragmentViewCreatedEnd", "getMallCategoryTabFragmentViewCreatedEnd", "mallCategoryTabFragmentOnResumeStart", "getMallCategoryTabFragmentOnResumeStart", "mallCategoryTabFragmentOnResumeEnd", "getMallCategoryTabFragmentOnResumeEnd", "mallHomeFragmentOnCreateStart", "getMallHomeFragmentOnCreateStart", "mallHomeFragmentOnCreateEnd", "getMallHomeFragmentOnCreateEnd", "mallHomeFragmentOnCreateViewStart", "getMallHomeFragmentOnCreateViewStart", "mallHomeFragmentOnCreateViewEnd", "getMallHomeFragmentOnCreateViewEnd", "mallHomeFragmentViewCreatedStart", "getMallHomeFragmentViewCreatedStart", "mallHomeFragmentViewCreatedEnd", "getMallHomeFragmentViewCreatedEnd", "mallHomeFragmentOnResumeStart", "getMallHomeFragmentOnResumeStart", "mallHomeFragmentOnResumeEnd", "getMallHomeFragmentOnResumeEnd", "mainPageFragmentOnCreateStart", "getMainPageFragmentOnCreateStart", "mainPageFragmentOnCreateEnd", "getMainPageFragmentOnCreateEnd", "mainPageFragmentOnCreateViewStart", "getMainPageFragmentOnCreateViewStart", "mainPageFragmentOnCreateViewEnd", "getMainPageFragmentOnCreateViewEnd", "mainPageFragmentViewCreatedStart", "getMainPageFragmentViewCreatedStart", "mainPageFragmentViewCreatedEnd", "getMainPageFragmentViewCreatedEnd", "mainPageFragmentOnResumeStart", "getMainPageFragmentOnResumeStart", "mainPageFragmentOnResumeEnd", "getMainPageFragmentOnResumeEnd", "ecHybridRecycleViewLayoutStart", "getEcHybridRecycleViewLayoutStart", "ecHybridRecycleViewLayoutEnd", "getEcHybridRecycleViewLayoutEnd", "ecHybridRecycleViewRealDataLayoutStart", "getEcHybridRecycleViewRealDataLayoutStart", "ecHybridRecycleViewRealDataLayoutEnd", "getEcHybridRecycleViewRealDataLayoutEnd", "ecHybridRecycleViewDrawStart", "getEcHybridRecycleViewDrawStart", "ecHybridRecycleViewDrawEnd", "getEcHybridRecycleViewDrawEnd", "ecHybridRecycleViewRealDataDrawStart", "getEcHybridRecycleViewRealDataDrawStart", "ecHybridRecycleViewRealDataDrawEnd", "getEcHybridRecycleViewRealDataDrawEnd", "mallInitTopBarStart", "m", "mallInitTopBarEnd", "getMallInitTopBarEnd", "firstScreenDataMainHandleStart", "getFirstScreenDataMainHandleStart", "firstScreenDataMainHandleEnd", "getFirstScreenDataMainHandleEnd", "prefetchMainSuccessWhenCreate", "t", "mallStartHandleInitData", "getMallStartHandleInitData", "preloadDataEngineStart", "getPreloadDataEngineStart", "preloadDataEngineEnd", "getPreloadDataEngineEnd", "mallPreInitLynxStart", "getMallPreInitLynxStart", "mallPreInitLynxEnd", "getMallPreInitLynxEnd", "mallPostFirstScreenDataRunnableStart", "getMallPostFirstScreenDataRunnableStart", "mallPostFirstScreenDataRunnableEnd", "getMallPostFirstScreenDataRunnableEnd", "optimizeConfigCenterEnd", "getOptimizeConfigCenterEnd", "mallHandlePopupStart", "getMallHandlePopupStart", "mallHandlePopupEnd", "getMallHandlePopupEnd", "waitTTNetInitDuration", "getWaitTTNetInitDuration", "TTNetInitEnd", "getTTNetInitEnd", "prefetchMessageMainQueueIndex", "getPrefetchMessageMainQueueIndex", "tDataFromNetInterceptor", "getTDataFromNetInterceptor", "parseNetworkPerfParamsStatus", "r", "cachedCategoryTabType", "getCachedCategoryTabType", "cachedCategoryTabConvertFlag", "getCachedCategoryTabConvertFlag", "categoryTabType", "getCategoryTabType", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("t_tt_net_init_end")
    private final Long TTNetInitEnd;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f566967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f566968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f566969c;

    @SerializedName("cached_category_tab_convert_flag")
    private final Integer cachedCategoryTabConvertFlag;

    @SerializedName("cached_category_tab_type")
    private final String cachedCategoryTabType;

    @SerializedName("cached_data_prepared_status")
    private final Integer cachedDataPreparedStatus;

    @SerializedName("catch_no_bind")
    private final Integer catchNoBind;

    @SerializedName("category_tab_type")
    private final String categoryTabType;

    @SerializedName("client_login_status")
    private final Integer clientLoginStatus;

    @SerializedName("data_reuse_status")
    private final Integer dataReuseStatus;

    @SerializedName("t_dep_plugin_install_end")
    private final Long depPluginInstallEnd;

    @SerializedName("t_dep_plugin_install_start")
    private final Long depPluginInstallStart;

    @SerializedName("check_dep_plugin_status")
    private final Integer depPluginStatus;

    @SerializedName("ec_hybrid_recycle_view_draw_end")
    private final Long ecHybridRecycleViewDrawEnd;

    @SerializedName("ec_hybrid_recycle_view_draw_start")
    private final Long ecHybridRecycleViewDrawStart;

    @SerializedName("ec_hybrid_recycle_view_layout_end")
    private final Long ecHybridRecycleViewLayoutEnd;

    @SerializedName("ec_hybrid_recycle_view_layout_start")
    private final Long ecHybridRecycleViewLayoutStart;

    @SerializedName("ec_hybrid_recycle_view_real_data_draw_end")
    private final Long ecHybridRecycleViewRealDataDrawEnd;

    @SerializedName("ec_hybrid_recycle_view_real_data_draw_start")
    private final Long ecHybridRecycleViewRealDataDrawStart;

    @SerializedName("ec_hybrid_recycle_view_real_data_layout_end")
    private final Long ecHybridRecycleViewRealDataLayoutEnd;

    @SerializedName("ec_hybrid_recycle_view_real_data_layout_start")
    private final Long ecHybridRecycleViewRealDataLayoutStart;

    @SerializedName("check_ec_plugin_status")
    private final Integer ecPluginStatus;

    @SerializedName("t_entrance_fragment_create_view_end")
    private final Long entranceFragmentCreateViewEnd;

    @SerializedName("t_entrance_fragment_create_view_start")
    private final Long entranceFragmentCreateViewStart;

    @SerializedName("error_code")
    private final Integer errCode;

    @SerializedName("error_msg")
    private final String errMsg;

    @SerializedName("first_chunk_name")
    private final String firstChunkName;

    @SerializedName("t_first_chunk_received")
    private final Long firstChunkReceived;

    @SerializedName("t_first_chunk_render_end")
    private final Long firstChunkRenderEnd;

    @SerializedName("t_first_chunk_render_start")
    private final Long firstChunkRenderStart;

    @SerializedName("t_first_screen_data_main_handle_end")
    private final Long firstScreenDataMainHandleEnd;

    @SerializedName("t_first_screen_data_main_handle_start")
    private final Long firstScreenDataMainHandleStart;

    @SerializedName("first_screen_data_prepared_status")
    private final Integer firstScreenDataPreparedStatus;

    @SerializedName("first_screen_header_card_type")
    private final Integer firstScreenHeaderCardType;

    @SerializedName("t_fragment_create_view_end")
    private final Long fragmentCreateViewEnd;

    @SerializedName("t_fragment_create_view_start")
    private final Long fragmentCreateViewStart;

    @SerializedName("t_check_gecko_end")
    private final Long geckoEnd;

    @SerializedName("t_check_gecko_start")
    private final Long geckoStart;

    @SerializedName("check_gecko_status")
    private final Integer geckoStatus;

    @SerializedName("gyl_num_of_first_screen")
    private final Integer gylNumOfFirstScreen;

    @SerializedName("half_page_open")
    private final Integer halfPageOpen;

    @SerializedName("t_handle_prefetched_data")
    private final Long handlePrefetchedDataTime;

    @SerializedName("t_immerse_mall_bind_real_data_reason")
    private final String immerseBindRealDataReason;

    @SerializedName("t_immerse_mall_bind_real_data_time")
    private final Long immerseBindRealDataTime;

    @SerializedName("t_init_lynx_end")
    private final Long initLynxEnd;

    @SerializedName("t_init_lynx_start")
    private final Long initLynxStart;

    @SerializedName("t_leave_time")
    private final Long leaveTime;

    @SerializedName("leave_type")
    private final Integer leaveType;

    @SerializedName("t_list_first_screen")
    private final Long listFirstScreen;

    @SerializedName("t_list_load_end")
    private final Long listLoadEnd;

    @SerializedName("t_list_load_start")
    private final Long listLoadStart;

    @SerializedName("t_load_bundle_end")
    private final Long loadBundleEnd;

    @SerializedName("t_load_bundle_start")
    private final Long loadBundleStart;

    @SerializedName("fetch_bundle_config_way")
    private final String loadBundleWay;

    @SerializedName("main_page_fragment_on_create_end")
    private final Long mainPageFragmentOnCreateEnd;

    @SerializedName("main_page_fragment_on_create_start")
    private final Long mainPageFragmentOnCreateStart;

    @SerializedName("main_page_fragment_on_create_view_end")
    private final Long mainPageFragmentOnCreateViewEnd;

    @SerializedName("main_page_fragment_on_create_view_start")
    private final Long mainPageFragmentOnCreateViewStart;

    @SerializedName("main_page_fragment_on_resume_end")
    private final Long mainPageFragmentOnResumeEnd;

    @SerializedName("main_page_fragment_on_resume_start")
    private final Long mainPageFragmentOnResumeStart;

    @SerializedName("main_page_fragment_view_created_end")
    private final Long mainPageFragmentViewCreatedEnd;

    @SerializedName("main_page_fragment_view_created_start")
    private final Long mainPageFragmentViewCreatedStart;

    @SerializedName("t_mall_category_tab_fragment_on_create_end")
    private final Long mallCategoryTabFragmentOnCreateEnd;

    @SerializedName("t_mall_category_tab_fragment_on_create_start")
    private final Long mallCategoryTabFragmentOnCreateStart;

    @SerializedName("t_mall_category_tab_fragment_on_create_view_end")
    private final Long mallCategoryTabFragmentOnCreateViewEnd;

    @SerializedName("t_mall_category_tab_fragment_on_create_view_start")
    private final Long mallCategoryTabFragmentOnCreateViewStart;

    @SerializedName("t_mall_category_tab_fragment_on_resume_end")
    private final Long mallCategoryTabFragmentOnResumeEnd;

    @SerializedName("t_mall_category_tab_fragment_on_resume_start")
    private final Long mallCategoryTabFragmentOnResumeStart;

    @SerializedName("t_mall_category_tab_fragment_view_created_end")
    private final Long mallCategoryTabFragmentViewCreatedEnd;

    @SerializedName("t_mall_category_tab_fragment_view_created_start")
    private final Long mallCategoryTabFragmentViewCreatedStart;

    @SerializedName("t_handle_pop_up_end")
    private final Long mallHandlePopupEnd;

    @SerializedName("t_handle_pop_up_start")
    private final Long mallHandlePopupStart;

    @SerializedName("t_mall_home_fragment_on_create_end")
    private final Long mallHomeFragmentOnCreateEnd;

    @SerializedName("t_mall_home_fragment_on_create_start")
    private final Long mallHomeFragmentOnCreateStart;

    @SerializedName("t_mall_home_fragment_on_create_view_end")
    private final Long mallHomeFragmentOnCreateViewEnd;

    @SerializedName("t_mall_home_fragment_on_create_view_start")
    private final Long mallHomeFragmentOnCreateViewStart;

    @SerializedName("t_mall_home_fragment_on_resume_end")
    private final Long mallHomeFragmentOnResumeEnd;

    @SerializedName("t_mall_home_fragment_on_resume_start")
    private final Long mallHomeFragmentOnResumeStart;

    @SerializedName("t_mall_home_fragment_view_created_end")
    private final Long mallHomeFragmentViewCreatedEnd;

    @SerializedName("t_mall_home_fragment_view_created_start")
    private final Long mallHomeFragmentViewCreatedStart;

    @SerializedName("t_init_top_bar_end")
    private final Long mallInitTopBarEnd;

    @SerializedName("t_init_top_bar_start")
    private final Long mallInitTopBarStart;

    @SerializedName("t_mall_post_first_screen_data_runnable_end")
    private final Long mallPostFirstScreenDataRunnableEnd;

    @SerializedName("t_mall_post_first_screen_data_runnable_start")
    private final Long mallPostFirstScreenDataRunnableStart;

    @SerializedName("t_mall_pre_init_lynx_end")
    private final Long mallPreInitLynxEnd;

    @SerializedName("t_mall_pre_init_lynx_start")
    private final Long mallPreInitLynxStart;

    @SerializedName("t_mall_start_handle_init_data")
    private final Long mallStartHandleInitData;

    @SerializedName("t_mall_frame_time")
    private final Long multiMallFrameTime;

    @SerializedName("t_net_end")
    private final Long netEnd;

    @SerializedName("t_net_end_client")
    private final Long netEndClient;

    @SerializedName("t_net_start")
    private final Long netStart;

    @SerializedName("t_open_time")
    private final Long openTime;

    @SerializedName("t_optimize_config_center_end")
    private final Long optimizeConfigCenterEnd;

    @SerializedName("parse_network_perf_params_status")
    private final Integer parseNetworkPerfParamsStatus;

    @SerializedName("popup_page_straight_out")
    private final Boolean popupPageStraightOut;

    @SerializedName("t_prefetch_end")
    private final Long prefetchEnd;

    @SerializedName("t_prefetch_main_success_when_create")
    private final Integer prefetchMainSuccessWhenCreate;

    @SerializedName("prefetch_message_main_queue_index")
    private final Integer prefetchMessageMainQueueIndex;

    @SerializedName("t_prefetch_start")
    private final Long prefetchStart;

    @SerializedName("t_preload_config_end")
    private final Long preloadConfigEnd;

    @SerializedName("preload_config_result")
    private final String preloadConfigResult;

    @SerializedName("t_preload_config_start")
    private final Long preloadConfigStart;

    @SerializedName("t_preload_data_engine_end")
    private final Long preloadDataEngineEnd;

    @SerializedName("t_preload_data_engine_start")
    private final Long preloadDataEngineStart;

    @SerializedName("t_preload_end")
    private final Long preloadEndTimestamp;

    @SerializedName("t_preload_start")
    private final Long preloadStartTimestamp;

    @SerializedName("t_rebuild_scene")
    private final Integer rebuildScene;

    @SerializedName("retry_status")
    private final Integer retryStatus;

    @SerializedName("second_chunk_name")
    private final String secondChunkName;

    @SerializedName("t_second_chunk_received")
    private final Long secondChunkReceived;

    @SerializedName("t_second_chunk_render_end")
    private final Long secondChunkRenderEnd;

    @SerializedName("t_second_chunk_render_start")
    private final Long secondChunkRenderStart;

    @SerializedName("server_login_status")
    private final Integer serverLoginStatus;

    @SerializedName("skip_render_with_full_data")
    private final Boolean skipRenderWithFullData;

    @SerializedName("status")
    private final Integer status;

    @SerializedName("straight_out_flag")
    private final int straightOutFlag;

    @SerializedName("straight_out_header_card_type")
    private final Integer straightOutHeaderCardType;

    @SerializedName("t_data_from_net_interceptor")
    private final Integer tDataFromNetInterceptor;

    @SerializedName("t_dialog_first_screen_end")
    private final Long tDialogFirstScreenEnd;

    @SerializedName("t_dialog_first_screen_start")
    private final Long tDialogFirstScreenStart;

    @SerializedName("t_dialog_preprocess_end_time")
    private final Long tDialogPreprocessEndTime;

    @SerializedName("t_dialog_preprocess_start_time")
    private final Long tDialogPreprocessStartTime;

    @SerializedName("t_first_screen_end")
    private final Long tFirstScreenEnd;

    @SerializedName("t_first_screen_straight_out_end")
    private final Long tFirstScreenStraightOutEnd;

    @SerializedName("t_first_screen_straight_out_start")
    private final Long tFirstScreenStraightOutStart;

    @SerializedName("t_view_did_setup")
    private final Long tNAContainerReady;

    @SerializedName("t_prepare_cached_data_end")
    private final Long tPrepareCachedDataEnd;

    @SerializedName("t_prepare_cached_data_start")
    private final Long tPrepareCachedDataStart;

    @SerializedName("t_prepare_first_screen_data_end")
    private final Long tPrepareFirstScreenDataEnd;

    @SerializedName("t_prepare_first_screen_data_start")
    private final Long tPrepareFirstScreenDataStart;

    @SerializedName("t_straight_out_create_view_time")
    private final Long tStraightOutCreateViewTime;

    @SerializedName("t_straight_out_load_time")
    private final Long tStraightOutLoadTime;

    @SerializedName("t_tab_click_time")
    private final Long tabClickTime;

    @SerializedName("t_wait_tt_net_init_duration")
    private final Long waitTTNetInitDuration;

    public a(Integer r100, Integer r101, Long r102, Long r103, Long r104, Long r105, String r106, Long r110, Long r111, Long r112, Long r113, Long r114, Boolean r115, Long r116, Long r117, Long r118, Long r119, Long r210, Long r211, String r212, Long r213, Long r214, Long r215, Integer r216, Long r217, Long r218, Long r219, Long r310, Integer r311, Integer r312, Integer r313, String r314, Integer r315, Integer r316, Long r317, Long r318, Long r319, Integer r410, Long r411, Long r412, Integer r413, Integer r414, Long r415, Long r416, Integer r417, Integer r418, Long r419, Long r510, Integer r511, Integer r512, int r513, Long r514, Long r515, Long r516, Long r517, Long r518, Long r519, Long r610, Long r611, Long r612, String r613, Long r614, Long r615, Long r616, String r617, Long r618, Long r619, Long r710, Boolean r711, Long r712, Long r713, Integer r714, Long r715, String r716, Integer r717, Integer r718, Long r719, Long r810, Long r811, Long r812, Long r813, Long r814, Long r815, Long r816, Long r817, Long r818, Long r819, Long r910, Long r911, Long r912, Long r913, Long r914, Long r915, Long r916, Long r917, Long r918, Long r919, Long r107, Long r108, Long r109, Long r1010, Long r1011, Long r1012, Long r1013, Long r1014, Long r1015, Long r1016, Long r1110, Long r1111, Long r1112, Long r1113, Long r1114, Long r1115, Integer r1116, Long r1117, Long r1118, Long r1119, Long r120, Long r121, Long r122, Long r123, Long r124, Long r125, Long r126, Long r127, Long r128, Integer r129, Integer r130, Integer r131, String r132, Integer r133, String r134, Map<String, ? extends Object> r135, JSONObject r136, boolean r137) {
        this.serverLoginStatus = r100;
        this.clientLoginStatus = r101;
        this.preloadStartTimestamp = r102;
        this.preloadEndTimestamp = r103;
        this.preloadConfigStart = r104;
        this.preloadConfigEnd = r105;
        this.preloadConfigResult = r106;
        this.prefetchStart = r110;
        this.prefetchEnd = r111;
        this.openTime = r112;
        this.entranceFragmentCreateViewStart = r113;
        this.entranceFragmentCreateViewEnd = r114;
        this.popupPageStraightOut = r115;
        this.initLynxStart = r116;
        this.initLynxEnd = r117;
        this.fragmentCreateViewStart = r118;
        this.fragmentCreateViewEnd = r119;
        this.loadBundleStart = r210;
        this.loadBundleEnd = r211;
        this.loadBundleWay = r212;
        this.netStart = r213;
        this.netEnd = r214;
        this.netEndClient = r215;
        this.catchNoBind = r216;
        this.handlePrefetchedDataTime = r217;
        this.listLoadStart = r218;
        this.listFirstScreen = r219;
        this.listLoadEnd = r310;
        this.halfPageOpen = r311;
        this.status = r312;
        this.errCode = r313;
        this.errMsg = r314;
        this.leaveType = r315;
        this.retryStatus = r316;
        this.leaveTime = r317;
        this.geckoStart = r318;
        this.geckoEnd = r319;
        this.geckoStatus = r410;
        this.depPluginInstallStart = r411;
        this.depPluginInstallEnd = r412;
        this.depPluginStatus = r413;
        this.ecPluginStatus = r414;
        this.tPrepareCachedDataStart = r415;
        this.tPrepareCachedDataEnd = r416;
        this.cachedDataPreparedStatus = r417;
        this.dataReuseStatus = r418;
        this.tPrepareFirstScreenDataStart = r419;
        this.tPrepareFirstScreenDataEnd = r510;
        this.firstScreenDataPreparedStatus = r511;
        this.rebuildScene = r512;
        this.straightOutFlag = r513;
        this.tFirstScreenStraightOutStart = r514;
        this.tFirstScreenStraightOutEnd = r515;
        this.tNAContainerReady = r516;
        this.tStraightOutLoadTime = r517;
        this.tStraightOutCreateViewTime = r518;
        this.tDialogFirstScreenStart = r519;
        this.tDialogFirstScreenEnd = r610;
        this.tDialogPreprocessStartTime = r611;
        this.tDialogPreprocessEndTime = r612;
        this.firstChunkName = r613;
        this.firstChunkReceived = r614;
        this.firstChunkRenderStart = r615;
        this.firstChunkRenderEnd = r616;
        this.secondChunkName = r617;
        this.secondChunkReceived = r618;
        this.secondChunkRenderStart = r619;
        this.secondChunkRenderEnd = r710;
        this.skipRenderWithFullData = r711;
        this.tabClickTime = r712;
        this.multiMallFrameTime = r713;
        this.gylNumOfFirstScreen = r714;
        this.immerseBindRealDataTime = r715;
        this.immerseBindRealDataReason = r716;
        this.straightOutHeaderCardType = r717;
        this.firstScreenHeaderCardType = r718;
        this.tFirstScreenEnd = r719;
        this.mallCategoryTabFragmentOnCreateStart = r810;
        this.mallCategoryTabFragmentOnCreateEnd = r811;
        this.mallCategoryTabFragmentOnCreateViewStart = r812;
        this.mallCategoryTabFragmentOnCreateViewEnd = r813;
        this.mallCategoryTabFragmentViewCreatedStart = r814;
        this.mallCategoryTabFragmentViewCreatedEnd = r815;
        this.mallCategoryTabFragmentOnResumeStart = r816;
        this.mallCategoryTabFragmentOnResumeEnd = r817;
        this.mallHomeFragmentOnCreateStart = r818;
        this.mallHomeFragmentOnCreateEnd = r819;
        this.mallHomeFragmentOnCreateViewStart = r910;
        this.mallHomeFragmentOnCreateViewEnd = r911;
        this.mallHomeFragmentViewCreatedStart = r912;
        this.mallHomeFragmentViewCreatedEnd = r913;
        this.mallHomeFragmentOnResumeStart = r914;
        this.mallHomeFragmentOnResumeEnd = r915;
        this.mainPageFragmentOnCreateStart = r916;
        this.mainPageFragmentOnCreateEnd = r917;
        this.mainPageFragmentOnCreateViewStart = r918;
        this.mainPageFragmentOnCreateViewEnd = r919;
        this.mainPageFragmentViewCreatedStart = r107;
        this.mainPageFragmentViewCreatedEnd = r108;
        this.mainPageFragmentOnResumeStart = r109;
        this.mainPageFragmentOnResumeEnd = r1010;
        this.ecHybridRecycleViewLayoutStart = r1011;
        this.ecHybridRecycleViewLayoutEnd = r1012;
        this.ecHybridRecycleViewRealDataLayoutStart = r1013;
        this.ecHybridRecycleViewRealDataLayoutEnd = r1014;
        this.ecHybridRecycleViewDrawStart = r1015;
        this.ecHybridRecycleViewDrawEnd = r1016;
        this.ecHybridRecycleViewRealDataDrawStart = r1110;
        this.ecHybridRecycleViewRealDataDrawEnd = r1111;
        this.mallInitTopBarStart = r1112;
        this.mallInitTopBarEnd = r1113;
        this.firstScreenDataMainHandleStart = r1114;
        this.firstScreenDataMainHandleEnd = r1115;
        this.prefetchMainSuccessWhenCreate = r1116;
        this.mallStartHandleInitData = r1117;
        this.preloadDataEngineStart = r1118;
        this.preloadDataEngineEnd = r1119;
        this.mallPreInitLynxStart = r120;
        this.mallPreInitLynxEnd = r121;
        this.mallPostFirstScreenDataRunnableStart = r122;
        this.mallPostFirstScreenDataRunnableEnd = r123;
        this.optimizeConfigCenterEnd = r124;
        this.mallHandlePopupStart = r125;
        this.mallHandlePopupEnd = r126;
        this.waitTTNetInitDuration = r127;
        this.TTNetInitEnd = r128;
        this.prefetchMessageMainQueueIndex = r129;
        this.tDataFromNetInterceptor = r130;
        this.parseNetworkPerfParamsStatus = r131;
        this.cachedCategoryTabType = r132;
        this.cachedCategoryTabConvertFlag = r133;
        this.categoryTabType = r134;
        this.f566967a = r135;
        this.f566968b = r136;
        this.f566969c = r137;
    }

    public a() {
        this(null, -1);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L276;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.serverLoginStatus, r101.serverLoginStatus) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.clientLoginStatus, r101.clientLoginStatus) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.preloadStartTimestamp, r101.preloadStartTimestamp) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.preloadEndTimestamp, r101.preloadEndTimestamp) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.preloadConfigStart, r101.preloadConfigStart) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.preloadConfigEnd, r101.preloadConfigEnd) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.preloadConfigResult, r101.preloadConfigResult) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.prefetchStart, r101.prefetchStart) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.prefetchEnd, r101.prefetchEnd) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.openTime, r101.openTime) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.entranceFragmentCreateViewStart, r101.entranceFragmentCreateViewStart) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.entranceFragmentCreateViewEnd, r101.entranceFragmentCreateViewEnd) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.popupPageStraightOut, r101.popupPageStraightOut) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.initLynxStart, r101.initLynxStart) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.initLynxEnd, r101.initLynxEnd) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.fragmentCreateViewStart, r101.fragmentCreateViewStart) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.fragmentCreateViewEnd, r101.fragmentCreateViewEnd) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.loadBundleStart, r101.loadBundleStart) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.loadBundleEnd, r101.loadBundleEnd) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.loadBundleWay, r101.loadBundleWay) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.netStart, r101.netStart) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.netEnd, r101.netEnd) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.netEndClient, r101.netEndClient) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.catchNoBind, r101.catchNoBind) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.handlePrefetchedDataTime, r101.handlePrefetchedDataTime) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.listLoadStart, r101.listLoadStart) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.listFirstScreen, r101.listFirstScreen) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.listLoadEnd, r101.listLoadEnd) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.halfPageOpen, r101.halfPageOpen) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.errCode, r101.errCode) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.errMsg, r101.errMsg) == true) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(this.leaveType, r101.leaveType) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.retryStatus, r101.retryStatus) == true) goto L74;
        return false;
    L74:
        if (Intrinsics.areEqual(this.leaveTime, r101.leaveTime) == true) goto L76;
        return false;
    L76:
        if (Intrinsics.areEqual(this.geckoStart, r101.geckoStart) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.geckoEnd, r101.geckoEnd) == true) goto L80;
        return false;
    L80:
        if (Intrinsics.areEqual(this.geckoStatus, r101.geckoStatus) == true) goto L82;
        return false;
    L82:
        if (Intrinsics.areEqual(this.depPluginInstallStart, r101.depPluginInstallStart) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.depPluginInstallEnd, r101.depPluginInstallEnd) == true) goto L86;
        return false;
    L86:
        if (Intrinsics.areEqual(this.depPluginStatus, r101.depPluginStatus) == true) goto L88;
        return false;
    L88:
        if (Intrinsics.areEqual(this.ecPluginStatus, r101.ecPluginStatus) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.tPrepareCachedDataStart, r101.tPrepareCachedDataStart) == true) goto L92;
        return false;
    L92:
        if (Intrinsics.areEqual(this.tPrepareCachedDataEnd, r101.tPrepareCachedDataEnd) == true) goto L94;
        return false;
    L94:
        if (Intrinsics.areEqual(this.cachedDataPreparedStatus, r101.cachedDataPreparedStatus) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.dataReuseStatus, r101.dataReuseStatus) == true) goto L98;
        return false;
    L98:
        if (Intrinsics.areEqual(this.tPrepareFirstScreenDataStart, r101.tPrepareFirstScreenDataStart) == true) goto L100;
        return false;
    L100:
        if (Intrinsics.areEqual(this.tPrepareFirstScreenDataEnd, r101.tPrepareFirstScreenDataEnd) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.firstScreenDataPreparedStatus, r101.firstScreenDataPreparedStatus) == true) goto L104;
        return false;
    L104:
        if (Intrinsics.areEqual(this.rebuildScene, r101.rebuildScene) == true) goto L106;
        return false;
    L106:
        if (this.straightOutFlag == r101.straightOutFlag) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.tFirstScreenStraightOutStart, r101.tFirstScreenStraightOutStart) == true) goto L110;
        return false;
    L110:
        if (Intrinsics.areEqual(this.tFirstScreenStraightOutEnd, r101.tFirstScreenStraightOutEnd) == true) goto L112;
        return false;
    L112:
        if (Intrinsics.areEqual(this.tNAContainerReady, r101.tNAContainerReady) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.tStraightOutLoadTime, r101.tStraightOutLoadTime) == true) goto L116;
        return false;
    L116:
        if (Intrinsics.areEqual(this.tStraightOutCreateViewTime, r101.tStraightOutCreateViewTime) == true) goto L118;
        return false;
    L118:
        if (Intrinsics.areEqual(this.tDialogFirstScreenStart, r101.tDialogFirstScreenStart) == true) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.tDialogFirstScreenEnd, r101.tDialogFirstScreenEnd) == true) goto L122;
        return false;
    L122:
        if (Intrinsics.areEqual(this.tDialogPreprocessStartTime, r101.tDialogPreprocessStartTime) == true) goto L124;
        return false;
    L124:
        if (Intrinsics.areEqual(this.tDialogPreprocessEndTime, r101.tDialogPreprocessEndTime) == true) goto L126;
        return false;
    L126:
        if (Intrinsics.areEqual(this.firstChunkName, r101.firstChunkName) == true) goto L128;
        return false;
    L128:
        if (Intrinsics.areEqual(this.firstChunkReceived, r101.firstChunkReceived) == true) goto L130;
        return false;
    L130:
        if (Intrinsics.areEqual(this.firstChunkRenderStart, r101.firstChunkRenderStart) == true) goto L132;
        return false;
    L132:
        if (Intrinsics.areEqual(this.firstChunkRenderEnd, r101.firstChunkRenderEnd) == true) goto L134;
        return false;
    L134:
        if (Intrinsics.areEqual(this.secondChunkName, r101.secondChunkName) == true) goto L136;
        return false;
    L136:
        if (Intrinsics.areEqual(this.secondChunkReceived, r101.secondChunkReceived) == true) goto L138;
        return false;
    L138:
        if (Intrinsics.areEqual(this.secondChunkRenderStart, r101.secondChunkRenderStart) == true) goto L140;
        return false;
    L140:
        if (Intrinsics.areEqual(this.secondChunkRenderEnd, r101.secondChunkRenderEnd) == true) goto L142;
        return false;
    L142:
        if (Intrinsics.areEqual(this.skipRenderWithFullData, r101.skipRenderWithFullData) == true) goto L144;
        return false;
    L144:
        if (Intrinsics.areEqual(this.tabClickTime, r101.tabClickTime) == true) goto L146;
        return false;
    L146:
        if (Intrinsics.areEqual(this.multiMallFrameTime, r101.multiMallFrameTime) == true) goto L148;
        return false;
    L148:
        if (Intrinsics.areEqual(this.gylNumOfFirstScreen, r101.gylNumOfFirstScreen) == true) goto L150;
        return false;
    L150:
        if (Intrinsics.areEqual(this.immerseBindRealDataTime, r101.immerseBindRealDataTime) == true) goto L152;
        return false;
    L152:
        if (Intrinsics.areEqual(this.immerseBindRealDataReason, r101.immerseBindRealDataReason) == true) goto L154;
        return false;
    L154:
        if (Intrinsics.areEqual(this.straightOutHeaderCardType, r101.straightOutHeaderCardType) == true) goto L156;
        return false;
    L156:
        if (Intrinsics.areEqual(this.firstScreenHeaderCardType, r101.firstScreenHeaderCardType) == true) goto L158;
        return false;
    L158:
        if (Intrinsics.areEqual(this.tFirstScreenEnd, r101.tFirstScreenEnd) == true) goto L160;
        return false;
    L160:
        if (Intrinsics.areEqual(this.mallCategoryTabFragmentOnCreateStart, r101.mallCategoryTabFragmentOnCreateStart) == true) goto L162;
        return false;
    L162:
        if (Intrinsics.areEqual(this.mallCategoryTabFragmentOnCreateEnd, r101.mallCategoryTabFragmentOnCreateEnd) == true) goto L164;
        return false;
    L164:
        if (Intrinsics.areEqual(this.mallCategoryTabFragmentOnCreateViewStart, r101.mallCategoryTabFragmentOnCreateViewStart) == true) goto L166;
        return false;
    L166:
        if (Intrinsics.areEqual(this.mallCategoryTabFragmentOnCreateViewEnd, r101.mallCategoryTabFragmentOnCreateViewEnd) == true) goto L168;
        return false;
    L168:
        if (Intrinsics.areEqual(this.mallCategoryTabFragmentViewCreatedStart, r101.mallCategoryTabFragmentViewCreatedStart) == true) goto L170;
        return false;
    L170:
        if (Intrinsics.areEqual(this.mallCategoryTabFragmentViewCreatedEnd, r101.mallCategoryTabFragmentViewCreatedEnd) == true) goto L172;
        return false;
    L172:
        if (Intrinsics.areEqual(this.mallCategoryTabFragmentOnResumeStart, r101.mallCategoryTabFragmentOnResumeStart) == true) goto L174;
        return false;
    L174:
        if (Intrinsics.areEqual(this.mallCategoryTabFragmentOnResumeEnd, r101.mallCategoryTabFragmentOnResumeEnd) == true) goto L176;
        return false;
    L176:
        if (Intrinsics.areEqual(this.mallHomeFragmentOnCreateStart, r101.mallHomeFragmentOnCreateStart) == true) goto L178;
        return false;
    L178:
        if (Intrinsics.areEqual(this.mallHomeFragmentOnCreateEnd, r101.mallHomeFragmentOnCreateEnd) == true) goto L180;
        return false;
    L180:
        if (Intrinsics.areEqual(this.mallHomeFragmentOnCreateViewStart, r101.mallHomeFragmentOnCreateViewStart) == true) goto L182;
        return false;
    L182:
        if (Intrinsics.areEqual(this.mallHomeFragmentOnCreateViewEnd, r101.mallHomeFragmentOnCreateViewEnd) == true) goto L184;
        return false;
    L184:
        if (Intrinsics.areEqual(this.mallHomeFragmentViewCreatedStart, r101.mallHomeFragmentViewCreatedStart) == true) goto L186;
        return false;
    L186:
        if (Intrinsics.areEqual(this.mallHomeFragmentViewCreatedEnd, r101.mallHomeFragmentViewCreatedEnd) == true) goto L188;
        return false;
    L188:
        if (Intrinsics.areEqual(this.mallHomeFragmentOnResumeStart, r101.mallHomeFragmentOnResumeStart) == true) goto L190;
        return false;
    L190:
        if (Intrinsics.areEqual(this.mallHomeFragmentOnResumeEnd, r101.mallHomeFragmentOnResumeEnd) == true) goto L192;
        return false;
    L192:
        if (Intrinsics.areEqual(this.mainPageFragmentOnCreateStart, r101.mainPageFragmentOnCreateStart) == true) goto L194;
        return false;
    L194:
        if (Intrinsics.areEqual(this.mainPageFragmentOnCreateEnd, r101.mainPageFragmentOnCreateEnd) == true) goto L196;
        return false;
    L196:
        if (Intrinsics.areEqual(this.mainPageFragmentOnCreateViewStart, r101.mainPageFragmentOnCreateViewStart) == true) goto L198;
        return false;
    L198:
        if (Intrinsics.areEqual(this.mainPageFragmentOnCreateViewEnd, r101.mainPageFragmentOnCreateViewEnd) == true) goto L200;
        return false;
    L200:
        if (Intrinsics.areEqual(this.mainPageFragmentViewCreatedStart, r101.mainPageFragmentViewCreatedStart) == true) goto L202;
        return false;
    L202:
        if (Intrinsics.areEqual(this.mainPageFragmentViewCreatedEnd, r101.mainPageFragmentViewCreatedEnd) == true) goto L204;
        return false;
    L204:
        if (Intrinsics.areEqual(this.mainPageFragmentOnResumeStart, r101.mainPageFragmentOnResumeStart) == true) goto L206;
        return false;
    L206:
        if (Intrinsics.areEqual(this.mainPageFragmentOnResumeEnd, r101.mainPageFragmentOnResumeEnd) == true) goto L208;
        return false;
    L208:
        if (Intrinsics.areEqual(this.ecHybridRecycleViewLayoutStart, r101.ecHybridRecycleViewLayoutStart) == true) goto L210;
        return false;
    L210:
        if (Intrinsics.areEqual(this.ecHybridRecycleViewLayoutEnd, r101.ecHybridRecycleViewLayoutEnd) == true) goto L212;
        return false;
    L212:
        if (Intrinsics.areEqual(this.ecHybridRecycleViewRealDataLayoutStart, r101.ecHybridRecycleViewRealDataLayoutStart) == true) goto L214;
        return false;
    L214:
        if (Intrinsics.areEqual(this.ecHybridRecycleViewRealDataLayoutEnd, r101.ecHybridRecycleViewRealDataLayoutEnd) == true) goto L216;
        return false;
    L216:
        if (Intrinsics.areEqual(this.ecHybridRecycleViewDrawStart, r101.ecHybridRecycleViewDrawStart) == true) goto L218;
        return false;
    L218:
        if (Intrinsics.areEqual(this.ecHybridRecycleViewDrawEnd, r101.ecHybridRecycleViewDrawEnd) == true) goto L220;
        return false;
    L220:
        if (Intrinsics.areEqual(this.ecHybridRecycleViewRealDataDrawStart, r101.ecHybridRecycleViewRealDataDrawStart) == true) goto L222;
        return false;
    L222:
        if (Intrinsics.areEqual(this.ecHybridRecycleViewRealDataDrawEnd, r101.ecHybridRecycleViewRealDataDrawEnd) == true) goto L224;
        return false;
    L224:
        if (Intrinsics.areEqual(this.mallInitTopBarStart, r101.mallInitTopBarStart) == true) goto L226;
        return false;
    L226:
        if (Intrinsics.areEqual(this.mallInitTopBarEnd, r101.mallInitTopBarEnd) == true) goto L228;
        return false;
    L228:
        if (Intrinsics.areEqual(this.firstScreenDataMainHandleStart, r101.firstScreenDataMainHandleStart) == true) goto L230;
        return false;
    L230:
        if (Intrinsics.areEqual(this.firstScreenDataMainHandleEnd, r101.firstScreenDataMainHandleEnd) == true) goto L232;
        return false;
    L232:
        if (Intrinsics.areEqual(this.prefetchMainSuccessWhenCreate, r101.prefetchMainSuccessWhenCreate) == true) goto L234;
        return false;
    L234:
        if (Intrinsics.areEqual(this.mallStartHandleInitData, r101.mallStartHandleInitData) == true) goto L236;
        return false;
    L236:
        if (Intrinsics.areEqual(this.preloadDataEngineStart, r101.preloadDataEngineStart) == true) goto L238;
        return false;
    L238:
        if (Intrinsics.areEqual(this.preloadDataEngineEnd, r101.preloadDataEngineEnd) == true) goto L240;
        return false;
    L240:
        if (Intrinsics.areEqual(this.mallPreInitLynxStart, r101.mallPreInitLynxStart) == true) goto L242;
        return false;
    L242:
        if (Intrinsics.areEqual(this.mallPreInitLynxEnd, r101.mallPreInitLynxEnd) == true) goto L244;
        return false;
    L244:
        if (Intrinsics.areEqual(this.mallPostFirstScreenDataRunnableStart, r101.mallPostFirstScreenDataRunnableStart) == true) goto L246;
        return false;
    L246:
        if (Intrinsics.areEqual(this.mallPostFirstScreenDataRunnableEnd, r101.mallPostFirstScreenDataRunnableEnd) == true) goto L248;
        return false;
    L248:
        if (Intrinsics.areEqual(this.optimizeConfigCenterEnd, r101.optimizeConfigCenterEnd) == true) goto L250;
        return false;
    L250:
        if (Intrinsics.areEqual(this.mallHandlePopupStart, r101.mallHandlePopupStart) == true) goto L252;
        return false;
    L252:
        if (Intrinsics.areEqual(this.mallHandlePopupEnd, r101.mallHandlePopupEnd) == true) goto L254;
        return false;
    L254:
        if (Intrinsics.areEqual(this.waitTTNetInitDuration, r101.waitTTNetInitDuration) == true) goto L256;
        return false;
    L256:
        if (Intrinsics.areEqual(this.TTNetInitEnd, r101.TTNetInitEnd) == true) goto L258;
        return false;
    L258:
        if (Intrinsics.areEqual(this.prefetchMessageMainQueueIndex, r101.prefetchMessageMainQueueIndex) == true) goto L260;
        return false;
    L260:
        if (Intrinsics.areEqual(this.tDataFromNetInterceptor, r101.tDataFromNetInterceptor) == true) goto L262;
        return false;
    L262:
        if (Intrinsics.areEqual(this.parseNetworkPerfParamsStatus, r101.parseNetworkPerfParamsStatus) == true) goto L264;
        return false;
    L264:
        if (Intrinsics.areEqual(this.cachedCategoryTabType, r101.cachedCategoryTabType) == true) goto L266;
        return false;
    L266:
        if (Intrinsics.areEqual(this.cachedCategoryTabConvertFlag, r101.cachedCategoryTabConvertFlag) == true) goto L268;
        return false;
    L268:
        if (Intrinsics.areEqual(this.categoryTabType, r101.categoryTabType) == true) goto L270;
        return false;
    L270:
        if (Intrinsics.areEqual(this.f566967a, r101.f566967a) == true) goto L272;
        return false;
    L272:
        if (Intrinsics.areEqual(this.f566968b, r101.f566968b) == true) goto L274;
        return false;
    L274:
        if (this.f566969c == r101.f566969c) goto L415;
        return false;
    L415:
        return true;
    L276:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v270, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        Integer r100 = this.serverLoginStatus;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.clientLoginStatus;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.preloadStartTimestamp;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.preloadEndTimestamp;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.preloadConfigStart;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.preloadConfigEnd;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.preloadConfigResult;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.prefetchStart;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.prefetchEnd;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Long r128 = this.openTime;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Long r131 = this.entranceFragmentCreateViewStart;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        Long r134 = this.entranceFragmentCreateViewEnd;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        Boolean r137 = this.popupPageStraightOut;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        Long r140 = this.initLynxStart;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        Long r143 = this.initLynxEnd;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        Long r146 = this.fragmentCreateViewStart;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        Long r149 = this.fragmentCreateViewEnd;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        Long r152 = this.loadBundleStart;
        if (r152 == null) goto L73;
        int r153 = r152.hashCode();
    L74:
        int r154 = (r151 + r153) * 31;
        Long r155 = this.loadBundleEnd;
        if (r155 == null) goto L77;
        int r156 = r155.hashCode();
    L78:
        int r157 = (r154 + r156) * 31;
        String r158 = this.loadBundleWay;
        if (r158 == null) goto L81;
        int r159 = r158.hashCode();
    L82:
        int r160 = (r157 + r159) * 31;
        Long r161 = this.netStart;
        if (r161 == null) goto L85;
        int r162 = r161.hashCode();
    L86:
        int r163 = (r160 + r162) * 31;
        Long r164 = this.netEnd;
        if (r164 == null) goto L89;
        int r165 = r164.hashCode();
    L90:
        int r166 = (r163 + r165) * 31;
        Long r167 = this.netEndClient;
        if (r167 == null) goto L93;
        int r168 = r167.hashCode();
    L94:
        int r169 = (r166 + r168) * 31;
        Integer r170 = this.catchNoBind;
        if (r170 == null) goto L97;
        int r171 = r170.hashCode();
    L98:
        int r172 = (r169 + r171) * 31;
        Long r173 = this.handlePrefetchedDataTime;
        if (r173 == null) goto L101;
        int r174 = r173.hashCode();
    L102:
        int r175 = (r172 + r174) * 31;
        Long r176 = this.listLoadStart;
        if (r176 == null) goto L105;
        int r177 = r176.hashCode();
    L106:
        int r178 = (r175 + r177) * 31;
        Long r179 = this.listFirstScreen;
        if (r179 == null) goto L109;
        int r180 = r179.hashCode();
    L110:
        int r181 = (r178 + r180) * 31;
        Long r182 = this.listLoadEnd;
        if (r182 == null) goto L113;
        int r183 = r182.hashCode();
    L114:
        int r184 = (r181 + r183) * 31;
        Integer r185 = this.halfPageOpen;
        if (r185 == null) goto L117;
        int r186 = r185.hashCode();
    L118:
        int r187 = (r184 + r186) * 31;
        Integer r188 = this.status;
        if (r188 == null) goto L121;
        int r189 = r188.hashCode();
    L122:
        int r190 = (r187 + r189) * 31;
        Integer r191 = this.errCode;
        if (r191 == null) goto L125;
        int r192 = r191.hashCode();
    L126:
        int r193 = (r190 + r192) * 31;
        String r194 = this.errMsg;
        if (r194 == null) goto L129;
        int r195 = r194.hashCode();
    L130:
        int r196 = (r193 + r195) * 31;
        Integer r197 = this.leaveType;
        if (r197 == null) goto L133;
        int r198 = r197.hashCode();
    L134:
        int r199 = (r196 + r198) * 31;
        Integer r200 = this.retryStatus;
        if (r200 == null) goto L137;
        int r201 = r200.hashCode();
    L138:
        int r202 = (r199 + r201) * 31;
        Long r203 = this.leaveTime;
        if (r203 == null) goto L141;
        int r204 = r203.hashCode();
    L142:
        int r205 = (r202 + r204) * 31;
        Long r206 = this.geckoStart;
        if (r206 == null) goto L145;
        int r207 = r206.hashCode();
    L146:
        int r208 = (r205 + r207) * 31;
        Long r209 = this.geckoEnd;
        if (r209 == null) goto L149;
        int r210 = r209.hashCode();
    L150:
        int r211 = (r208 + r210) * 31;
        Integer r212 = this.geckoStatus;
        if (r212 == null) goto L153;
        int r213 = r212.hashCode();
    L154:
        int r214 = (r211 + r213) * 31;
        Long r215 = this.depPluginInstallStart;
        if (r215 == null) goto L157;
        int r216 = r215.hashCode();
    L158:
        int r217 = (r214 + r216) * 31;
        Long r218 = this.depPluginInstallEnd;
        if (r218 == null) goto L161;
        int r219 = r218.hashCode();
    L162:
        int r220 = (r217 + r219) * 31;
        Integer r221 = this.depPluginStatus;
        if (r221 == null) goto L165;
        int r222 = r221.hashCode();
    L166:
        int r223 = (r220 + r222) * 31;
        Integer r224 = this.ecPluginStatus;
        if (r224 == null) goto L169;
        int r225 = r224.hashCode();
    L170:
        int r226 = (r223 + r225) * 31;
        Long r227 = this.tPrepareCachedDataStart;
        if (r227 == null) goto L173;
        int r228 = r227.hashCode();
    L174:
        int r229 = (r226 + r228) * 31;
        Long r230 = this.tPrepareCachedDataEnd;
        if (r230 == null) goto L177;
        int r231 = r230.hashCode();
    L178:
        int r232 = (r229 + r231) * 31;
        Integer r233 = this.cachedDataPreparedStatus;
        if (r233 == null) goto L181;
        int r234 = r233.hashCode();
    L182:
        int r235 = (r232 + r234) * 31;
        Integer r236 = this.dataReuseStatus;
        if (r236 == null) goto L185;
        int r237 = r236.hashCode();
    L186:
        int r238 = (r235 + r237) * 31;
        Long r239 = this.tPrepareFirstScreenDataStart;
        if (r239 == null) goto L189;
        int r240 = r239.hashCode();
    L190:
        int r241 = (r238 + r240) * 31;
        Long r242 = this.tPrepareFirstScreenDataEnd;
        if (r242 == null) goto L193;
        int r243 = r242.hashCode();
    L194:
        int r244 = (r241 + r243) * 31;
        Integer r245 = this.firstScreenDataPreparedStatus;
        if (r245 == null) goto L197;
        int r246 = r245.hashCode();
    L198:
        int r247 = (r244 + r246) * 31;
        Integer r248 = this.rebuildScene;
        if (r248 == null) goto L201;
        int r249 = r248.hashCode();
    L202:
        int r250 = (((r247 + r249) * 31) + this.straightOutFlag) * 31;
        Long r251 = this.tFirstScreenStraightOutStart;
        if (r251 == null) goto L205;
        int r252 = r251.hashCode();
    L206:
        int r253 = (r250 + r252) * 31;
        Long r254 = this.tFirstScreenStraightOutEnd;
        if (r254 == null) goto L209;
        int r255 = r254.hashCode();
    L210:
        int r256 = (r253 + r255) * 31;
        Long r257 = this.tNAContainerReady;
        if (r257 == null) goto L213;
        int r258 = r257.hashCode();
    L214:
        int r259 = (r256 + r258) * 31;
        Long r260 = this.tStraightOutLoadTime;
        if (r260 == null) goto L217;
        int r261 = r260.hashCode();
    L218:
        int r262 = (r259 + r261) * 31;
        Long r263 = this.tStraightOutCreateViewTime;
        if (r263 == null) goto L221;
        int r264 = r263.hashCode();
    L222:
        int r265 = (r262 + r264) * 31;
        Long r266 = this.tDialogFirstScreenStart;
        if (r266 == null) goto L225;
        int r267 = r266.hashCode();
    L226:
        int r268 = (r265 + r267) * 31;
        Long r269 = this.tDialogFirstScreenEnd;
        if (r269 == null) goto L229;
        int r270 = r269.hashCode();
    L230:
        int r271 = (r268 + r270) * 31;
        Long r272 = this.tDialogPreprocessStartTime;
        if (r272 == null) goto L233;
        int r273 = r272.hashCode();
    L234:
        int r274 = (r271 + r273) * 31;
        Long r275 = this.tDialogPreprocessEndTime;
        if (r275 == null) goto L237;
        int r276 = r275.hashCode();
    L238:
        int r277 = (r274 + r276) * 31;
        String r278 = this.firstChunkName;
        if (r278 == null) goto L241;
        int r279 = r278.hashCode();
    L242:
        int r280 = (r277 + r279) * 31;
        Long r281 = this.firstChunkReceived;
        if (r281 == null) goto L245;
        int r282 = r281.hashCode();
    L246:
        int r283 = (r280 + r282) * 31;
        Long r284 = this.firstChunkRenderStart;
        if (r284 == null) goto L249;
        int r285 = r284.hashCode();
    L250:
        int r286 = (r283 + r285) * 31;
        Long r287 = this.firstChunkRenderEnd;
        if (r287 == null) goto L253;
        int r288 = r287.hashCode();
    L254:
        int r289 = (r286 + r288) * 31;
        String r290 = this.secondChunkName;
        if (r290 == null) goto L257;
        int r291 = r290.hashCode();
    L258:
        int r292 = (r289 + r291) * 31;
        Long r293 = this.secondChunkReceived;
        if (r293 == null) goto L261;
        int r294 = r293.hashCode();
    L262:
        int r295 = (r292 + r294) * 31;
        Long r296 = this.secondChunkRenderStart;
        if (r296 == null) goto L265;
        int r297 = r296.hashCode();
    L266:
        int r298 = (r295 + r297) * 31;
        Long r299 = this.secondChunkRenderEnd;
        if (r299 == null) goto L269;
        int r300 = r299.hashCode();
    L270:
        int r301 = (r298 + r300) * 31;
        Boolean r302 = this.skipRenderWithFullData;
        if (r302 == null) goto L273;
        int r303 = r302.hashCode();
    L274:
        int r304 = (r301 + r303) * 31;
        Long r305 = this.tabClickTime;
        if (r305 == null) goto L277;
        int r306 = r305.hashCode();
    L278:
        int r307 = (r304 + r306) * 31;
        Long r308 = this.multiMallFrameTime;
        if (r308 == null) goto L281;
        int r309 = r308.hashCode();
    L282:
        int r310 = (r307 + r309) * 31;
        Integer r311 = this.gylNumOfFirstScreen;
        if (r311 == null) goto L285;
        int r312 = r311.hashCode();
    L286:
        int r313 = (r310 + r312) * 31;
        Long r314 = this.immerseBindRealDataTime;
        if (r314 == null) goto L289;
        int r315 = r314.hashCode();
    L290:
        int r316 = (r313 + r315) * 31;
        String r317 = this.immerseBindRealDataReason;
        if (r317 == null) goto L293;
        int r318 = r317.hashCode();
    L294:
        int r319 = (r316 + r318) * 31;
        Integer r320 = this.straightOutHeaderCardType;
        if (r320 == null) goto L297;
        int r321 = r320.hashCode();
    L298:
        int r322 = (r319 + r321) * 31;
        Integer r323 = this.firstScreenHeaderCardType;
        if (r323 == null) goto L301;
        int r324 = r323.hashCode();
    L302:
        int r325 = (r322 + r324) * 31;
        Long r326 = this.tFirstScreenEnd;
        if (r326 == null) goto L305;
        int r327 = r326.hashCode();
    L306:
        int r328 = (r325 + r327) * 31;
        Long r329 = this.mallCategoryTabFragmentOnCreateStart;
        if (r329 == null) goto L309;
        int r330 = r329.hashCode();
    L310:
        int r331 = (r328 + r330) * 31;
        Long r332 = this.mallCategoryTabFragmentOnCreateEnd;
        if (r332 == null) goto L313;
        int r333 = r332.hashCode();
    L314:
        int r334 = (r331 + r333) * 31;
        Long r335 = this.mallCategoryTabFragmentOnCreateViewStart;
        if (r335 == null) goto L317;
        int r336 = r335.hashCode();
    L318:
        int r337 = (r334 + r336) * 31;
        Long r338 = this.mallCategoryTabFragmentOnCreateViewEnd;
        if (r338 == null) goto L321;
        int r339 = r338.hashCode();
    L322:
        int r340 = (r337 + r339) * 31;
        Long r341 = this.mallCategoryTabFragmentViewCreatedStart;
        if (r341 == null) goto L325;
        int r342 = r341.hashCode();
    L326:
        int r343 = (r340 + r342) * 31;
        Long r344 = this.mallCategoryTabFragmentViewCreatedEnd;
        if (r344 == null) goto L329;
        int r345 = r344.hashCode();
    L330:
        int r346 = (r343 + r345) * 31;
        Long r347 = this.mallCategoryTabFragmentOnResumeStart;
        if (r347 == null) goto L333;
        int r348 = r347.hashCode();
    L334:
        int r349 = (r346 + r348) * 31;
        Long r350 = this.mallCategoryTabFragmentOnResumeEnd;
        if (r350 == null) goto L337;
        int r351 = r350.hashCode();
    L338:
        int r352 = (r349 + r351) * 31;
        Long r353 = this.mallHomeFragmentOnCreateStart;
        if (r353 == null) goto L341;
        int r354 = r353.hashCode();
    L342:
        int r355 = (r352 + r354) * 31;
        Long r356 = this.mallHomeFragmentOnCreateEnd;
        if (r356 == null) goto L345;
        int r357 = r356.hashCode();
    L346:
        int r358 = (r355 + r357) * 31;
        Long r359 = this.mallHomeFragmentOnCreateViewStart;
        if (r359 == null) goto L349;
        int r360 = r359.hashCode();
    L350:
        int r361 = (r358 + r360) * 31;
        Long r362 = this.mallHomeFragmentOnCreateViewEnd;
        if (r362 == null) goto L353;
        int r363 = r362.hashCode();
    L354:
        int r364 = (r361 + r363) * 31;
        Long r365 = this.mallHomeFragmentViewCreatedStart;
        if (r365 == null) goto L357;
        int r366 = r365.hashCode();
    L358:
        int r367 = (r364 + r366) * 31;
        Long r368 = this.mallHomeFragmentViewCreatedEnd;
        if (r368 == null) goto L361;
        int r369 = r368.hashCode();
    L362:
        int r370 = (r367 + r369) * 31;
        Long r371 = this.mallHomeFragmentOnResumeStart;
        if (r371 == null) goto L365;
        int r372 = r371.hashCode();
    L366:
        int r373 = (r370 + r372) * 31;
        Long r374 = this.mallHomeFragmentOnResumeEnd;
        if (r374 == null) goto L369;
        int r375 = r374.hashCode();
    L370:
        int r376 = (r373 + r375) * 31;
        Long r377 = this.mainPageFragmentOnCreateStart;
        if (r377 == null) goto L373;
        int r378 = r377.hashCode();
    L374:
        int r379 = (r376 + r378) * 31;
        Long r380 = this.mainPageFragmentOnCreateEnd;
        if (r380 == null) goto L377;
        int r381 = r380.hashCode();
    L378:
        int r382 = (r379 + r381) * 31;
        Long r383 = this.mainPageFragmentOnCreateViewStart;
        if (r383 == null) goto L381;
        int r384 = r383.hashCode();
    L382:
        int r385 = (r382 + r384) * 31;
        Long r386 = this.mainPageFragmentOnCreateViewEnd;
        if (r386 == null) goto L385;
        int r387 = r386.hashCode();
    L386:
        int r388 = (r385 + r387) * 31;
        Long r389 = this.mainPageFragmentViewCreatedStart;
        if (r389 == null) goto L389;
        int r390 = r389.hashCode();
    L390:
        int r391 = (r388 + r390) * 31;
        Long r392 = this.mainPageFragmentViewCreatedEnd;
        if (r392 == null) goto L393;
        int r393 = r392.hashCode();
    L394:
        int r394 = (r391 + r393) * 31;
        Long r395 = this.mainPageFragmentOnResumeStart;
        if (r395 == null) goto L397;
        int r396 = r395.hashCode();
    L398:
        int r397 = (r394 + r396) * 31;
        Long r398 = this.mainPageFragmentOnResumeEnd;
        if (r398 == null) goto L401;
        int r399 = r398.hashCode();
    L402:
        int r400 = (r397 + r399) * 31;
        Long r401 = this.ecHybridRecycleViewLayoutStart;
        if (r401 == null) goto L405;
        int r402 = r401.hashCode();
    L406:
        int r403 = (r400 + r402) * 31;
        Long r404 = this.ecHybridRecycleViewLayoutEnd;
        if (r404 == null) goto L409;
        int r405 = r404.hashCode();
    L410:
        int r406 = (r403 + r405) * 31;
        Long r407 = this.ecHybridRecycleViewRealDataLayoutStart;
        if (r407 == null) goto L413;
        int r408 = r407.hashCode();
    L414:
        int r409 = (r406 + r408) * 31;
        Long r410 = this.ecHybridRecycleViewRealDataLayoutEnd;
        if (r410 == null) goto L417;
        int r411 = r410.hashCode();
    L418:
        int r412 = (r409 + r411) * 31;
        Long r413 = this.ecHybridRecycleViewDrawStart;
        if (r413 == null) goto L421;
        int r414 = r413.hashCode();
    L422:
        int r415 = (r412 + r414) * 31;
        Long r416 = this.ecHybridRecycleViewDrawEnd;
        if (r416 == null) goto L425;
        int r417 = r416.hashCode();
    L426:
        int r418 = (r415 + r417) * 31;
        Long r419 = this.ecHybridRecycleViewRealDataDrawStart;
        if (r419 == null) goto L429;
        int r420 = r419.hashCode();
    L430:
        int r421 = (r418 + r420) * 31;
        Long r422 = this.ecHybridRecycleViewRealDataDrawEnd;
        if (r422 == null) goto L433;
        int r423 = r422.hashCode();
    L434:
        int r424 = (r421 + r423) * 31;
        Long r425 = this.mallInitTopBarStart;
        if (r425 == null) goto L437;
        int r426 = r425.hashCode();
    L438:
        int r427 = (r424 + r426) * 31;
        Long r428 = this.mallInitTopBarEnd;
        if (r428 == null) goto L441;
        int r429 = r428.hashCode();
    L442:
        int r430 = (r427 + r429) * 31;
        Long r431 = this.firstScreenDataMainHandleStart;
        if (r431 == null) goto L445;
        int r432 = r431.hashCode();
    L446:
        int r433 = (r430 + r432) * 31;
        Long r434 = this.firstScreenDataMainHandleEnd;
        if (r434 == null) goto L449;
        int r435 = r434.hashCode();
    L450:
        int r436 = (r433 + r435) * 31;
        Integer r437 = this.prefetchMainSuccessWhenCreate;
        if (r437 == null) goto L453;
        int r438 = r437.hashCode();
    L454:
        int r439 = (r436 + r438) * 31;
        Long r440 = this.mallStartHandleInitData;
        if (r440 == null) goto L457;
        int r441 = r440.hashCode();
    L458:
        int r442 = (r439 + r441) * 31;
        Long r443 = this.preloadDataEngineStart;
        if (r443 == null) goto L461;
        int r444 = r443.hashCode();
    L462:
        int r445 = (r442 + r444) * 31;
        Long r446 = this.preloadDataEngineEnd;
        if (r446 == null) goto L465;
        int r447 = r446.hashCode();
    L466:
        int r448 = (r445 + r447) * 31;
        Long r449 = this.mallPreInitLynxStart;
        if (r449 == null) goto L469;
        int r450 = r449.hashCode();
    L470:
        int r451 = (r448 + r450) * 31;
        Long r452 = this.mallPreInitLynxEnd;
        if (r452 == null) goto L473;
        int r453 = r452.hashCode();
    L474:
        int r454 = (r451 + r453) * 31;
        Long r455 = this.mallPostFirstScreenDataRunnableStart;
        if (r455 == null) goto L477;
        int r456 = r455.hashCode();
    L478:
        int r457 = (r454 + r456) * 31;
        Long r458 = this.mallPostFirstScreenDataRunnableEnd;
        if (r458 == null) goto L481;
        int r459 = r458.hashCode();
    L482:
        int r460 = (r457 + r459) * 31;
        Long r461 = this.optimizeConfigCenterEnd;
        if (r461 == null) goto L485;
        int r462 = r461.hashCode();
    L486:
        int r463 = (r460 + r462) * 31;
        Long r464 = this.mallHandlePopupStart;
        if (r464 == null) goto L489;
        int r465 = r464.hashCode();
    L490:
        int r466 = (r463 + r465) * 31;
        Long r467 = this.mallHandlePopupEnd;
        if (r467 == null) goto L493;
        int r468 = r467.hashCode();
    L494:
        int r469 = (r466 + r468) * 31;
        Long r470 = this.waitTTNetInitDuration;
        if (r470 == null) goto L497;
        int r471 = r470.hashCode();
    L498:
        int r472 = (r469 + r471) * 31;
        Long r473 = this.TTNetInitEnd;
        if (r473 == null) goto L501;
        int r474 = r473.hashCode();
    L502:
        int r475 = (r472 + r474) * 31;
        Integer r476 = this.prefetchMessageMainQueueIndex;
        if (r476 == null) goto L505;
        int r477 = r476.hashCode();
    L506:
        int r478 = (r475 + r477) * 31;
        Integer r479 = this.tDataFromNetInterceptor;
        if (r479 == null) goto L509;
        int r480 = r479.hashCode();
    L510:
        int r481 = (r478 + r480) * 31;
        Integer r482 = this.parseNetworkPerfParamsStatus;
        if (r482 == null) goto L513;
        int r483 = r482.hashCode();
    L514:
        int r484 = (r481 + r483) * 31;
        String r485 = this.cachedCategoryTabType;
        if (r485 == null) goto L517;
        int r486 = r485.hashCode();
    L518:
        int r487 = (r484 + r486) * 31;
        Integer r488 = this.cachedCategoryTabConvertFlag;
        if (r488 == null) goto L521;
        int r489 = r488.hashCode();
    L522:
        int r490 = (r487 + r489) * 31;
        String r491 = this.categoryTabType;
        if (r491 == null) goto L525;
        int r492 = r491.hashCode();
    L526:
        int r493 = (r490 + r492) * 31;
        Map<String, Object> r494 = this.f566967a;
        if (r494 == null) goto L529;
        int r495 = r494.hashCode();
    L530:
        int r496 = (r493 + r495) * 31;
        JSONObject r497 = this.f566968b;
        if (r497 == null) goto L533;
        r101 = r497.hashCode();
    L533:
        int r498 = (r496 + r101) * 31;
        boolean r499 = this.f566969c;
        ?? r500 = r499;
        if (r499 == false) goto L537;
        r500 = 1;
    L537:
        return r498 + r500;
    L529:
        r495 = 0;
        goto L530
    L525:
        r492 = 0;
        goto L526
    L521:
        r489 = 0;
        goto L522
    L517:
        r486 = 0;
        goto L518
    L513:
        r483 = 0;
        goto L514
    L509:
        r480 = 0;
        goto L510
    L505:
        r477 = 0;
        goto L506
    L501:
        r474 = 0;
        goto L502
    L497:
        r471 = 0;
        goto L498
    L493:
        r468 = 0;
        goto L494
    L489:
        r465 = 0;
        goto L490
    L485:
        r462 = 0;
        goto L486
    L481:
        r459 = 0;
        goto L482
    L477:
        r456 = 0;
        goto L478
    L473:
        r453 = 0;
        goto L474
    L469:
        r450 = 0;
        goto L470
    L465:
        r447 = 0;
        goto L466
    L461:
        r444 = 0;
        goto L462
    L457:
        r441 = 0;
        goto L458
    L453:
        r438 = 0;
        goto L454
    L449:
        r435 = 0;
        goto L450
    L445:
        r432 = 0;
        goto L446
    L441:
        r429 = 0;
        goto L442
    L437:
        r426 = 0;
        goto L438
    L433:
        r423 = 0;
        goto L434
    L429:
        r420 = 0;
        goto L430
    L425:
        r417 = 0;
        goto L426
    L421:
        r414 = 0;
        goto L422
    L417:
        r411 = 0;
        goto L418
    L413:
        r408 = 0;
        goto L414
    L409:
        r405 = 0;
        goto L410
    L405:
        r402 = 0;
        goto L406
    L401:
        r399 = 0;
        goto L402
    L397:
        r396 = 0;
        goto L398
    L393:
        r393 = 0;
        goto L394
    L389:
        r390 = 0;
        goto L390
    L385:
        r387 = 0;
        goto L386
    L381:
        r384 = 0;
        goto L382
    L377:
        r381 = 0;
        goto L378
    L373:
        r378 = 0;
        goto L374
    L369:
        r375 = 0;
        goto L370
    L365:
        r372 = 0;
        goto L366
    L361:
        r369 = 0;
        goto L362
    L357:
        r366 = 0;
        goto L358
    L353:
        r363 = 0;
        goto L354
    L349:
        r360 = 0;
        goto L350
    L345:
        r357 = 0;
        goto L346
    L341:
        r354 = 0;
        goto L342
    L337:
        r351 = 0;
        goto L338
    L333:
        r348 = 0;
        goto L334
    L329:
        r345 = 0;
        goto L330
    L325:
        r342 = 0;
        goto L326
    L321:
        r339 = 0;
        goto L322
    L317:
        r336 = 0;
        goto L318
    L313:
        r333 = 0;
        goto L314
    L309:
        r330 = 0;
        goto L310
    L305:
        r327 = 0;
        goto L306
    L301:
        r324 = 0;
        goto L302
    L297:
        r321 = 0;
        goto L298
    L293:
        r318 = 0;
        goto L294
    L289:
        r315 = 0;
        goto L290
    L285:
        r312 = 0;
        goto L286
    L281:
        r309 = 0;
        goto L282
    L277:
        r306 = 0;
        goto L278
    L273:
        r303 = 0;
        goto L274
    L269:
        r300 = 0;
        goto L270
    L265:
        r297 = 0;
        goto L266
    L261:
        r294 = 0;
        goto L262
    L257:
        r291 = 0;
        goto L258
    L253:
        r288 = 0;
        goto L254
    L249:
        r285 = 0;
        goto L250
    L245:
        r282 = 0;
        goto L246
    L241:
        r279 = 0;
        goto L242
    L237:
        r276 = 0;
        goto L238
    L233:
        r273 = 0;
        goto L234
    L229:
        r270 = 0;
        goto L230
    L225:
        r267 = 0;
        goto L226
    L221:
        r264 = 0;
        goto L222
    L217:
        r261 = 0;
        goto L218
    L213:
        r258 = 0;
        goto L214
    L209:
        r255 = 0;
        goto L210
    L205:
        r252 = 0;
        goto L206
    L201:
        r249 = 0;
        goto L202
    L197:
        r246 = 0;
        goto L198
    L193:
        r243 = 0;
        goto L194
    L189:
        r240 = 0;
        goto L190
    L185:
        r237 = 0;
        goto L186
    L181:
        r234 = 0;
        goto L182
    L177:
        r231 = 0;
        goto L178
    L173:
        r228 = 0;
        goto L174
    L169:
        r225 = 0;
        goto L170
    L165:
        r222 = 0;
        goto L166
    L161:
        r219 = 0;
        goto L162
    L157:
        r216 = 0;
        goto L158
    L153:
        r213 = 0;
        goto L154
    L149:
        r210 = 0;
        goto L150
    L145:
        r207 = 0;
        goto L146
    L141:
        r204 = 0;
        goto L142
    L137:
        r201 = 0;
        goto L138
    L133:
        r198 = 0;
        goto L134
    L129:
        r195 = 0;
        goto L130
    L125:
        r192 = 0;
        goto L126
    L121:
        r189 = 0;
        goto L122
    L117:
        r186 = 0;
        goto L118
    L113:
        r183 = 0;
        goto L114
    L109:
        r180 = 0;
        goto L110
    L105:
        r177 = 0;
        goto L106
    L101:
        r174 = 0;
        goto L102
    L97:
        r171 = 0;
        goto L98
    L93:
        r168 = 0;
        goto L94
    L89:
        r165 = 0;
        goto L90
    L85:
        r162 = 0;
        goto L86
    L81:
        r159 = 0;
        goto L82
    L77:
        r156 = 0;
        goto L78
    L73:
        r153 = 0;
        goto L74
    L69:
        r150 = 0;
        goto L70
    L65:
        r147 = 0;
        goto L66
    L61:
        r144 = 0;
        goto L62
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
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
        return "FirstScreenAnalyseBean(serverLoginStatus=" + this.serverLoginStatus + ", clientLoginStatus=" + this.clientLoginStatus + ", preloadStartTimestamp=" + this.preloadStartTimestamp + ", preloadEndTimestamp=" + this.preloadEndTimestamp + ", preloadConfigStart=" + this.preloadConfigStart + ", preloadConfigEnd=" + this.preloadConfigEnd + ", preloadConfigResult=" + this.preloadConfigResult + ", prefetchStart=" + this.prefetchStart + ", prefetchEnd=" + this.prefetchEnd + ", openTime=" + this.openTime + ", entranceFragmentCreateViewStart=" + this.entranceFragmentCreateViewStart + ", entranceFragmentCreateViewEnd=" + this.entranceFragmentCreateViewEnd + ", popupPageStraightOut=" + this.popupPageStraightOut + ", initLynxStart=" + this.initLynxStart + ", initLynxEnd=" + this.initLynxEnd + ", fragmentCreateViewStart=" + this.fragmentCreateViewStart + ", fragmentCreateViewEnd=" + this.fragmentCreateViewEnd + ", loadBundleStart=" + this.loadBundleStart + ", loadBundleEnd=" + this.loadBundleEnd + ", loadBundleWay=" + this.loadBundleWay + ", netStart=" + this.netStart + ", netEnd=" + this.netEnd + ", netEndClient=" + this.netEndClient + ", catchNoBind=" + this.catchNoBind + ", handlePrefetchedDataTime=" + this.handlePrefetchedDataTime + ", listLoadStart=" + this.listLoadStart + ", listFirstScreen=" + this.listFirstScreen + ", listLoadEnd=" + this.listLoadEnd + ", halfPageOpen=" + this.halfPageOpen + ", status=" + this.status + ", errCode=" + this.errCode + ", errMsg=" + this.errMsg + ", leaveType=" + this.leaveType + ", retryStatus=" + this.retryStatus + ", leaveTime=" + this.leaveTime + ", geckoStart=" + this.geckoStart + ", geckoEnd=" + this.geckoEnd + ", geckoStatus=" + this.geckoStatus + ", depPluginInstallStart=" + this.depPluginInstallStart + ", depPluginInstallEnd=" + this.depPluginInstallEnd + ", depPluginStatus=" + this.depPluginStatus + ", ecPluginStatus=" + this.ecPluginStatus + ", tPrepareCachedDataStart=" + this.tPrepareCachedDataStart + ", tPrepareCachedDataEnd=" + this.tPrepareCachedDataEnd + ", cachedDataPreparedStatus=" + this.cachedDataPreparedStatus + ", dataReuseStatus=" + this.dataReuseStatus + ", tPrepareFirstScreenDataStart=" + this.tPrepareFirstScreenDataStart + ", tPrepareFirstScreenDataEnd=" + this.tPrepareFirstScreenDataEnd + ", firstScreenDataPreparedStatus=" + this.firstScreenDataPreparedStatus + ", rebuildScene=" + this.rebuildScene + ", straightOutFlag=" + this.straightOutFlag + ", tFirstScreenStraightOutStart=" + this.tFirstScreenStraightOutStart + ", tFirstScreenStraightOutEnd=" + this.tFirstScreenStraightOutEnd + ", tNAContainerReady=" + this.tNAContainerReady + ", tStraightOutLoadTime=" + this.tStraightOutLoadTime + ", tStraightOutCreateViewTime=" + this.tStraightOutCreateViewTime + ", tDialogFirstScreenStart=" + this.tDialogFirstScreenStart + ", tDialogFirstScreenEnd=" + this.tDialogFirstScreenEnd + ", tDialogPreprocessStartTime=" + this.tDialogPreprocessStartTime + ", tDialogPreprocessEndTime=" + this.tDialogPreprocessEndTime + ", firstChunkName=" + this.firstChunkName + ", firstChunkReceived=" + this.firstChunkReceived + ", firstChunkRenderStart=" + this.firstChunkRenderStart + ", firstChunkRenderEnd=" + this.firstChunkRenderEnd + ", secondChunkName=" + this.secondChunkName + ", secondChunkReceived=" + this.secondChunkReceived + ", secondChunkRenderStart=" + this.secondChunkRenderStart + ", secondChunkRenderEnd=" + this.secondChunkRenderEnd + ", skipRenderWithFullData=" + this.skipRenderWithFullData + ", tabClickTime=" + this.tabClickTime + ", multiMallFrameTime=" + this.multiMallFrameTime + ", gylNumOfFirstScreen=" + this.gylNumOfFirstScreen + ", immerseBindRealDataTime=" + this.immerseBindRealDataTime + ", immerseBindRealDataReason=" + this.immerseBindRealDataReason + ", straightOutHeaderCardType=" + this.straightOutHeaderCardType + ", firstScreenHeaderCardType=" + this.firstScreenHeaderCardType + ", tFirstScreenEnd=" + this.tFirstScreenEnd + ", mallCategoryTabFragmentOnCreateStart=" + this.mallCategoryTabFragmentOnCreateStart + ", mallCategoryTabFragmentOnCreateEnd=" + this.mallCategoryTabFragmentOnCreateEnd + ", mallCategoryTabFragmentOnCreateViewStart=" + this.mallCategoryTabFragmentOnCreateViewStart + ", mallCategoryTabFragmentOnCreateViewEnd=" + this.mallCategoryTabFragmentOnCreateViewEnd + ", mallCategoryTabFragmentViewCreatedStart=" + this.mallCategoryTabFragmentViewCreatedStart + ", mallCategoryTabFragmentViewCreatedEnd=" + this.mallCategoryTabFragmentViewCreatedEnd + ", mallCategoryTabFragmentOnResumeStart=" + this.mallCategoryTabFragmentOnResumeStart + ", mallCategoryTabFragmentOnResumeEnd=" + this.mallCategoryTabFragmentOnResumeEnd + ", mallHomeFragmentOnCreateStart=" + this.mallHomeFragmentOnCreateStart + ", mallHomeFragmentOnCreateEnd=" + this.mallHomeFragmentOnCreateEnd + ", mallHomeFragmentOnCreateViewStart=" + this.mallHomeFragmentOnCreateViewStart + ", mallHomeFragmentOnCreateViewEnd=" + this.mallHomeFragmentOnCreateViewEnd + ", mallHomeFragmentViewCreatedStart=" + this.mallHomeFragmentViewCreatedStart + ", mallHomeFragmentViewCreatedEnd=" + this.mallHomeFragmentViewCreatedEnd + ", mallHomeFragmentOnResumeStart=" + this.mallHomeFragmentOnResumeStart + ", mallHomeFragmentOnResumeEnd=" + this.mallHomeFragmentOnResumeEnd + ", mainPageFragmentOnCreateStart=" + this.mainPageFragmentOnCreateStart + ", mainPageFragmentOnCreateEnd=" + this.mainPageFragmentOnCreateEnd + ", mainPageFragmentOnCreateViewStart=" + this.mainPageFragmentOnCreateViewStart + ", mainPageFragmentOnCreateViewEnd=" + this.mainPageFragmentOnCreateViewEnd + ", mainPageFragmentViewCreatedStart=" + this.mainPageFragmentViewCreatedStart + ", mainPageFragmentViewCreatedEnd=" + this.mainPageFragmentViewCreatedEnd + ", mainPageFragmentOnResumeStart=" + this.mainPageFragmentOnResumeStart + ", mainPageFragmentOnResumeEnd=" + this.mainPageFragmentOnResumeEnd + ", ecHybridRecycleViewLayoutStart=" + this.ecHybridRecycleViewLayoutStart + ", ecHybridRecycleViewLayoutEnd=" + this.ecHybridRecycleViewLayoutEnd + ", ecHybridRecycleViewRealDataLayoutStart=" + this.ecHybridRecycleViewRealDataLayoutStart + ", ecHybridRecycleViewRealDataLayoutEnd=" + this.ecHybridRecycleViewRealDataLayoutEnd + ", ecHybridRecycleViewDrawStart=" + this.ecHybridRecycleViewDrawStart + ", ecHybridRecycleViewDrawEnd=" + this.ecHybridRecycleViewDrawEnd + ", ecHybridRecycleViewRealDataDrawStart=" + this.ecHybridRecycleViewRealDataDrawStart + ", ecHybridRecycleViewRealDataDrawEnd=" + this.ecHybridRecycleViewRealDataDrawEnd + ", mallInitTopBarStart=" + this.mallInitTopBarStart + ", mallInitTopBarEnd=" + this.mallInitTopBarEnd + ", firstScreenDataMainHandleStart=" + this.firstScreenDataMainHandleStart + ", firstScreenDataMainHandleEnd=" + this.firstScreenDataMainHandleEnd + ", prefetchMainSuccessWhenCreate=" + this.prefetchMainSuccessWhenCreate + ", mallStartHandleInitData=" + this.mallStartHandleInitData + ", preloadDataEngineStart=" + this.preloadDataEngineStart + ", preloadDataEngineEnd=" + this.preloadDataEngineEnd + ", mallPreInitLynxStart=" + this.mallPreInitLynxStart + ", mallPreInitLynxEnd=" + this.mallPreInitLynxEnd + ", mallPostFirstScreenDataRunnableStart=" + this.mallPostFirstScreenDataRunnableStart + ", mallPostFirstScreenDataRunnableEnd=" + this.mallPostFirstScreenDataRunnableEnd + ", optimizeConfigCenterEnd=" + this.optimizeConfigCenterEnd + ", mallHandlePopupStart=" + this.mallHandlePopupStart + ", mallHandlePopupEnd=" + this.mallHandlePopupEnd + ", waitTTNetInitDuration=" + this.waitTTNetInitDuration + ", TTNetInitEnd=" + this.TTNetInitEnd + ", prefetchMessageMainQueueIndex=" + this.prefetchMessageMainQueueIndex + ", tDataFromNetInterceptor=" + this.tDataFromNetInterceptor + ", parseNetworkPerfParamsStatus=" + this.parseNetworkPerfParamsStatus + ", cachedCategoryTabType=" + this.cachedCategoryTabType + ", cachedCategoryTabConvertFlag=" + this.cachedCategoryTabConvertFlag + ", categoryTabType=" + this.categoryTabType + ", serverMonitorTiming=" + this.f566967a + ", requestMonitorInfo=" + this.f566968b + ", _reported=" + this.f566969c + ")";
    }

    public final Long A() {
        return this.tFirstScreenEnd;
    }

    public final Long B() {
        return this.tFirstScreenStraightOutEnd;
    }

    public final Long C() {
        return this.tFirstScreenStraightOutStart;
    }

    public final Long D() {
        return this.tPrepareCachedDataEnd;
    }

    public final Long E() {
        return this.tPrepareCachedDataStart;
    }

    public final Long F() {
        return this.tPrepareFirstScreenDataEnd;
    }

    public final Long G() {
        return this.tPrepareFirstScreenDataStart;
    }

    public final Integer b() {
        return this.clientLoginStatus;
    }

    public final String c() {
        return this.errMsg;
    }

    public final Integer d() {
        return this.firstScreenHeaderCardType;
    }

    public final Long e() {
        return this.geckoEnd;
    }

    public final Long f() {
        return this.geckoStart;
    }

    public final Integer g() {
        return this.gylNumOfFirstScreen;
    }

    public final Integer h() {
        return this.halfPageOpen;
    }

    public final Long i() {
        return this.handlePrefetchedDataTime;
    }

    public final Long j() {
        return this.listFirstScreen;
    }

    public final Long k() {
        return this.listLoadStart;
    }

    public final String l() {
        return this.loadBundleWay;
    }

    public final Long m() {
        return this.mallInitTopBarStart;
    }

    public final Long n() {
        return this.netEnd;
    }

    public final Long o() {
        return this.netEndClient;
    }

    public final Long p() {
        return this.netStart;
    }

    public final Long q() {
        return this.openTime;
    }

    public final Integer r() {
        return this.parseNetworkPerfParamsStatus;
    }

    public final Boolean s() {
        return this.popupPageStraightOut;
    }

    public final Integer t() {
        return this.prefetchMainSuccessWhenCreate;
    }

    public final Long u() {
        return this.preloadEndTimestamp;
    }

    public final Long v() {
        return this.preloadStartTimestamp;
    }

    public final Integer w() {
        return this.rebuildScene;
    }

    public final Long x() {
        return this.secondChunkRenderStart;
    }

    public final Integer y() {
        return this.status;
    }

    public final Integer z() {
        return this.straightOutHeaderCardType;
    }

    public /* synthetic */ a(Integer r137, int r138) {
        Boolean r110 = Boolean.FALSE;
        if ((r138 & 131072) == 0) goto L5;
        Integer r510 = null;
    L6:
        this(null, null, null, null, null, null, null, null, null, null, null, null, r110, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r510, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false);
        return;
    L5:
        r510 = r137;
        goto L6
    }

    public static a a(a r142, Integer r143, Integer r144, Long r145, Long r146, Long r147, Long r148, Long r149, String r150, Long r151, Long r152, Long r153, Integer r154, Long r155, Long r156, Long r157, Long r158, Integer r159, Integer r160, Integer r161, String r162, Integer r163, Long r164, Long r165, Integer r166, Long r167, Long r168, Integer r169, Integer r170, Long r171, Long r172, Integer r173, int r174, Long r175, Long r176, Long r177, Long r178, Long r179, Long r180, Long r181, String r182, Long r183, String r184, Long r185, Long r186, Boolean r187, Integer r188, Long r189, Integer r190, Integer r191, Long r192, Long r193, Long r194, Long r195, Long r196, Integer r197, Long r198, Long r199, Long r200, Long r201, Long r202, Integer r203, Integer r204, String r205, Integer r206, String r207, Map r208, JSONObject r209, boolean r210, int r211, int r212, int r213, int r214, int r215) {
        if ((r211 & 1) == 0) goto L5;
        Integer r100 = r142.serverLoginStatus;
    L7:
        if ((r211 & 2) == 0) goto L9;
        Integer r101 = r142.clientLoginStatus;
    L11:
        if ((r211 & 4) == 0) goto L13;
        Long r102 = r142.preloadStartTimestamp;
    L15:
        if ((r211 & 8) == 0) goto L17;
        Long r110 = r142.preloadEndTimestamp;
    L19:
        if ((r211 & 16) == 0) goto L21;
        Long r111 = r142.preloadConfigStart;
    L23:
        if ((r211 & 32) == 0) goto L25;
        Long r112 = r142.preloadConfigEnd;
    L27:
        if ((r211 & 64) == 0) goto L29;
        String r113 = r142.preloadConfigResult;
    L31:
        if ((r211 & 128) == 0) goto L33;
        Long r114 = r142.prefetchStart;
    L35:
        if ((r211 & 256) == 0) goto L37;
        Long r115 = r142.prefetchEnd;
    L39:
        if ((r211 & 512) == 0) goto L41;
        Long r116 = r142.openTime;
    L43:
        if ((r211 & 1024) == 0) goto L45;
        Long r117 = r142.entranceFragmentCreateViewStart;
    L47:
        if ((r211 & 2048) == 0) goto L49;
        Long r118 = r142.entranceFragmentCreateViewEnd;
    L51:
        if ((r211 & 4096) == 0) goto L53;
        Boolean r119 = r142.popupPageStraightOut;
    L55:
        if ((r211 & 8192) == 0) goto L57;
        Long r216 = r142.initLynxStart;
    L59:
        if ((r211 & 16384) == 0) goto L61;
        Long r217 = r142.initLynxEnd;
    L63:
        if ((r211 & 32768) == 0) goto L65;
        Long r218 = r142.fragmentCreateViewStart;
    L67:
        if ((r211 & 65536) == 0) goto L69;
        Long r219 = r142.fragmentCreateViewEnd;
    L71:
        if ((r211 & 131072) == 0) goto L73;
        Long r220 = r142.loadBundleStart;
    L75:
        if ((r211 & 262144) == 0) goto L77;
        Long r221 = r142.loadBundleEnd;
    L79:
        if ((r211 & 524288) == 0) goto L81;
        String r222 = r142.loadBundleWay;
    L83:
        if ((r211 & 1048576) == 0) goto L85;
        Long r223 = r142.netStart;
    L87:
        if ((r211 & 2097152) == 0) goto L89;
        Long r224 = r142.netEnd;
    L91:
        if ((r211 & 4194304) == 0) goto L93;
        Long r225 = r142.netEndClient;
    L95:
        if ((r211 & 8388608) == 0) goto L97;
        Integer r310 = r142.catchNoBind;
    L99:
        if ((r211 & 16777216) == 0) goto L101;
        Long r311 = r142.handlePrefetchedDataTime;
    L103:
        if ((r211 & 33554432) == 0) goto L105;
        Long r312 = r142.listLoadStart;
    L107:
        if ((r211 & 67108864) == 0) goto L109;
        Long r313 = r142.listFirstScreen;
    L111:
        if ((r211 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        Long r314 = r142.listLoadEnd;
    L115:
        if ((268435456 & r211) == 0) goto L117;
        Integer r315 = r142.halfPageOpen;
    L119:
        if ((536870912 & r211) == 0) goto L121;
        Integer r316 = r142.status;
    L123:
        if ((1073741824 & r211) == 0) goto L125;
        Integer r317 = r142.errCode;
    L127:
        if ((r211 & Integer.MIN_VALUE) == 0) goto L129;
        String r318 = r142.errMsg;
    L131:
        if ((r212 & 1) == 0) goto L133;
        Integer r319 = r142.leaveType;
    L135:
        if ((r212 & 2) == 0) goto L137;
        Integer r410 = r142.retryStatus;
    L139:
        if ((r212 & 4) == 0) goto L141;
        Long r411 = r142.leaveTime;
    L143:
        if ((r212 & 8) == 0) goto L145;
        Long r412 = r142.geckoStart;
    L147:
        if ((r212 & 16) == 0) goto L149;
        Long r413 = r142.geckoEnd;
    L151:
        if ((r212 & 32) == 0) goto L153;
        Integer r414 = r142.geckoStatus;
    L155:
        if ((r212 & 64) == 0) goto L157;
        Long r415 = r142.depPluginInstallStart;
    L159:
        if ((r212 & 128) == 0) goto L161;
        Long r416 = r142.depPluginInstallEnd;
    L163:
        if ((r212 & 256) == 0) goto L165;
        Integer r417 = r142.depPluginStatus;
    L167:
        if ((r212 & 512) == 0) goto L169;
        Integer r418 = r142.ecPluginStatus;
    L171:
        if ((r212 & 1024) == 0) goto L173;
        Long r419 = r142.tPrepareCachedDataStart;
    L175:
        if ((r212 & 2048) == 0) goto L177;
        Long r510 = r142.tPrepareCachedDataEnd;
    L179:
        if ((r212 & 4096) == 0) goto L181;
        Integer r511 = r142.cachedDataPreparedStatus;
    L183:
        if ((r212 & 8192) == 0) goto L185;
        Integer r512 = r142.dataReuseStatus;
    L187:
        if ((r212 & 16384) == 0) goto L189;
        Long r513 = r142.tPrepareFirstScreenDataStart;
    L191:
        if ((r212 & 32768) == 0) goto L193;
        Long r514 = r142.tPrepareFirstScreenDataEnd;
    L195:
        if ((r212 & 65536) == 0) goto L197;
        Integer r515 = r142.firstScreenDataPreparedStatus;
    L199:
        if ((r212 & 131072) == 0) goto L201;
        Integer r516 = r142.rebuildScene;
        int r103 = 262144;
    L203:
        if ((r212 & r103) == 0) goto L205;
        int r517 = r142.straightOutFlag;
    L207:
        if ((r212 & 524288) == 0) goto L209;
        Long r518 = r142.tFirstScreenStraightOutStart;
    L211:
        if ((r212 & 1048576) == 0) goto L213;
        Long r519 = r142.tFirstScreenStraightOutEnd;
    L215:
        if ((r212 & 2097152) == 0) goto L217;
        Long r610 = r142.tNAContainerReady;
    L219:
        if ((r212 & 4194304) == 0) goto L221;
        Long r611 = r142.tStraightOutLoadTime;
    L223:
        if ((r212 & 8388608) == 0) goto L225;
        Long r612 = r142.tStraightOutCreateViewTime;
    L227:
        if ((r212 & 16777216) == 0) goto L229;
        Long r613 = r142.tDialogFirstScreenStart;
        int r104 = 33554432;
    L231:
        if ((r212 & r104) == 0) goto L233;
        Long r614 = r142.tDialogFirstScreenEnd;
        int r105 = 67108864;
    L235:
        if ((r212 & r105) == 0) goto L237;
        Long r615 = r142.tDialogPreprocessStartTime;
    L239:
        if ((r212 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L241;
        Long r616 = r142.tDialogPreprocessEndTime;
    L243:
        if ((268435456 & r212) == 0) goto L245;
        String r617 = r142.firstChunkName;
    L247:
        if ((536870912 & r212) == 0) goto L249;
        Long r618 = r142.firstChunkReceived;
    L251:
        if ((1073741824 & r212) == 0) goto L253;
        Long r619 = r142.firstChunkRenderStart;
    L255:
        if ((Integer.MIN_VALUE & r212) == 0) goto L257;
        Long r710 = r142.firstChunkRenderEnd;
    L259:
        if ((r213 & 1) == 0) goto L261;
        String r711 = r142.secondChunkName;
    L263:
        if ((r213 & 2) == 0) goto L265;
        Long r712 = r142.secondChunkReceived;
    L267:
        if ((r213 & 4) == 0) goto L269;
        Long r713 = r142.secondChunkRenderStart;
    L271:
        if ((r213 & 8) == 0) goto L273;
        Long r714 = r142.secondChunkRenderEnd;
    L275:
        if ((r213 & 16) == 0) goto L277;
        Boolean r715 = r142.skipRenderWithFullData;
    L279:
        if ((r213 & 32) == 0) goto L281;
        Long r716 = r142.tabClickTime;
    L283:
        if ((r213 & 64) == 0) goto L285;
        Long r717 = r142.multiMallFrameTime;
    L287:
        if ((r213 & 128) == 0) goto L289;
        Integer r718 = r142.gylNumOfFirstScreen;
    L291:
        if ((r213 & 256) == 0) goto L293;
        Long r719 = r142.immerseBindRealDataTime;
    L295:
        if ((r213 & 512) == 0) goto L297;
        String r810 = r142.immerseBindRealDataReason;
    L299:
        if ((r213 & 1024) == 0) goto L301;
        Integer r811 = r142.straightOutHeaderCardType;
    L303:
        if ((r213 & 2048) == 0) goto L305;
        Integer r812 = r142.firstScreenHeaderCardType;
    L307:
        if ((r213 & 4096) == 0) goto L309;
        Long r813 = r142.tFirstScreenEnd;
    L311:
        if ((r213 & 8192) == 0) goto L313;
        Long r814 = r142.mallCategoryTabFragmentOnCreateStart;
    L315:
        if ((r213 & 16384) == 0) goto L317;
        Long r815 = r142.mallCategoryTabFragmentOnCreateEnd;
    L319:
        if ((r213 & 32768) == 0) goto L321;
        Long r816 = r142.mallCategoryTabFragmentOnCreateViewStart;
        int r106 = 65536;
    L323:
        if ((r213 & r106) == 0) goto L325;
        Long r817 = r142.mallCategoryTabFragmentOnCreateViewEnd;
        int r107 = 131072;
    L327:
        if ((r213 & r107) == 0) goto L329;
        Long r818 = r142.mallCategoryTabFragmentViewCreatedStart;
        int r108 = 262144;
    L331:
        if ((r213 & r108) == 0) goto L333;
        Long r819 = r142.mallCategoryTabFragmentViewCreatedEnd;
        int r109 = 524288;
    L335:
        if ((r213 & r109) == 0) goto L337;
        Long r910 = r142.mallCategoryTabFragmentOnResumeStart;
        int r120 = 1048576;
    L339:
        if ((r213 & r120) == 0) goto L341;
        Long r911 = r142.mallCategoryTabFragmentOnResumeEnd;
        int r121 = 2097152;
    L343:
        if ((r213 & r121) == 0) goto L345;
        Long r912 = r142.mallHomeFragmentOnCreateStart;
        int r122 = 4194304;
    L347:
        if ((r213 & r122) == 0) goto L349;
        Long r913 = r142.mallHomeFragmentOnCreateEnd;
        int r123 = 8388608;
    L351:
        if ((r213 & r123) == 0) goto L353;
        Long r914 = r142.mallHomeFragmentOnCreateViewStart;
        int r124 = 16777216;
    L355:
        if ((r213 & r124) == 0) goto L357;
        Long r915 = r142.mallHomeFragmentOnCreateViewEnd;
        int r125 = 33554432;
    L359:
        if ((r213 & r125) == 0) goto L361;
        Long r916 = r142.mallHomeFragmentViewCreatedStart;
        int r126 = 67108864;
    L363:
        if ((r213 & r126) == 0) goto L365;
        Long r917 = r142.mallHomeFragmentViewCreatedEnd;
        int r127 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
    L367:
        if ((r213 & r127) == 0) goto L369;
        Long r918 = r142.mallHomeFragmentOnResumeStart;
    L371:
        if ((268435456 & r213) == 0) goto L373;
        Long r919 = r142.mallHomeFragmentOnResumeEnd;
    L375:
        if ((536870912 & r213) == 0) goto L377;
        Long r1010 = r142.mainPageFragmentOnCreateStart;
    L379:
        if ((1073741824 & r213) == 0) goto L381;
        Long r1011 = r142.mainPageFragmentOnCreateEnd;
    L383:
        if ((Integer.MIN_VALUE & r213) == 0) goto L385;
        Long r1012 = r142.mainPageFragmentOnCreateViewStart;
    L387:
        if ((r214 & 1) == 0) goto L389;
        Long r1013 = r142.mainPageFragmentOnCreateViewEnd;
    L391:
        if ((r214 & 2) == 0) goto L393;
        Long r1014 = r142.mainPageFragmentViewCreatedStart;
    L395:
        if ((r214 & 4) == 0) goto L397;
        Long r1015 = r142.mainPageFragmentViewCreatedEnd;
    L399:
        if ((r214 & 8) == 0) goto L401;
        Long r1016 = r142.mainPageFragmentOnResumeStart;
    L403:
        if ((r214 & 16) == 0) goto L405;
        Long r1017 = r142.mainPageFragmentOnResumeEnd;
    L407:
        if ((r214 & 32) == 0) goto L409;
        Long r1018 = r142.ecHybridRecycleViewLayoutStart;
    L411:
        if ((r214 & 64) == 0) goto L413;
        Long r1019 = r142.ecHybridRecycleViewLayoutEnd;
    L415:
        if ((r214 & 128) == 0) goto L417;
        Long r1110 = r142.ecHybridRecycleViewRealDataLayoutStart;
    L419:
        if ((r214 & 256) == 0) goto L421;
        Long r1111 = r142.ecHybridRecycleViewRealDataLayoutEnd;
    L423:
        if ((r214 & 512) == 0) goto L425;
        Long r1112 = r142.ecHybridRecycleViewDrawStart;
    L427:
        if ((r214 & 1024) == 0) goto L429;
        Long r1113 = r142.ecHybridRecycleViewDrawEnd;
    L431:
        if ((r214 & 2048) == 0) goto L433;
        Long r1114 = r142.ecHybridRecycleViewRealDataDrawStart;
    L435:
        if ((r214 & 4096) == 0) goto L437;
        Long r1115 = r142.ecHybridRecycleViewRealDataDrawEnd;
    L439:
        if ((r214 & 8192) == 0) goto L441;
        Long r1116 = r142.mallInitTopBarStart;
    L443:
        if ((r214 & 16384) == 0) goto L445;
        Long r1117 = r142.mallInitTopBarEnd;
    L447:
        if ((r214 & 32768) == 0) goto L449;
        Long r1118 = r142.firstScreenDataMainHandleStart;
    L451:
        if ((65536 & r214) == 0) goto L453;
        Long r1119 = r142.firstScreenDataMainHandleEnd;
    L455:
        if ((131072 & r214) == 0) goto L457;
        Integer r128 = r142.prefetchMainSuccessWhenCreate;
    L459:
        if ((262144 & r214) == 0) goto L461;
        Long r129 = r142.mallStartHandleInitData;
    L463:
        if ((524288 & r214) == 0) goto L465;
        Long r1210 = r142.preloadDataEngineStart;
        int r130 = 1048576;
    L467:
        if ((r130 & r214) == 0) goto L469;
        Long r1211 = r142.preloadDataEngineEnd;
        int r131 = 2097152;
    L471:
        if ((r131 & r214) == 0) goto L473;
        Long r1212 = r142.mallPreInitLynxStart;
        int r132 = 4194304;
    L475:
        if ((r132 & r214) == 0) goto L477;
        Long r1213 = r142.mallPreInitLynxEnd;
        int r133 = 8388608;
    L479:
        if ((r133 & r214) == 0) goto L481;
        Long r1214 = r142.mallPostFirstScreenDataRunnableStart;
    L483:
        if ((16777216 & r214) == 0) goto L485;
        Long r1215 = r142.mallPostFirstScreenDataRunnableEnd;
    L487:
        if ((33554432 & r214) == 0) goto L489;
        Long r1216 = r142.optimizeConfigCenterEnd;
        int r134 = 67108864;
    L491:
        if ((r134 & r214) == 0) goto L493;
        Long r1217 = r142.mallHandlePopupStart;
    L495:
        if ((134217728 & r214) == 0) goto L497;
        Long r135 = r142.mallHandlePopupEnd;
    L499:
        if ((268435456 & r214) == 0) goto L501;
        Long r136 = r142.waitTTNetInitDuration;
    L503:
        if ((536870912 & r214) == 0) goto L505;
        Long r137 = r142.TTNetInitEnd;
    L507:
        if ((1073741824 & r214) == 0) goto L509;
        Integer r138 = r142.prefetchMessageMainQueueIndex;
    L511:
        if ((Integer.MIN_VALUE & r214) == 0) goto L513;
        Integer r139 = r142.tDataFromNetInterceptor;
    L515:
        if ((r215 & 1) == 0) goto L517;
        Integer r1310 = r142.parseNetworkPerfParamsStatus;
    L519:
        if ((r215 & 2) == 0) goto L521;
        String r1311 = r142.cachedCategoryTabType;
    L523:
        if ((r215 & 4) == 0) goto L525;
        Integer r1312 = r142.cachedCategoryTabConvertFlag;
    L527:
        if ((r215 & 8) == 0) goto L529;
        String r1313 = r142.categoryTabType;
    L531:
        if ((r215 & 16) == 0) goto L533;
        Map r1314 = r142.f566967a;
    L535:
        if ((r215 & 32) == 0) goto L537;
        JSONObject r140 = r142.f566968b;
    L539:
        if ((r215 & 64) == 0) goto L541;
        boolean r141 = r142.f566969c;
    L542:
        r142.getClass();
        return new a(r100, r101, r102, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r216, r217, r218, r219, r220, r221, r222, r223, r224, r225, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, r813, r814, r815, r816, r817, r818, r819, r910, r911, r912, r913, r914, r915, r916, r917, r918, r919, r1010, r1011, r1012, r1013, r1014, r1015, r1016, r1017, r1018, r1019, r1110, r1111, r1112, r1113, r1114, r1115, r1116, r1117, r1118, r1119, r128, r129, r1210, r1211, r1212, r1213, r1214, r1215, r1216, r1217, r135, r136, r137, r138, r139, r1310, r1311, r1312, r1313, r1314, r140, r141);
    L541:
        r141 = r210;
        goto L542
    L537:
        r140 = r209;
        goto L539
    L533:
        r1314 = r208;
        goto L535
    L529:
        r1313 = r207;
        goto L531
    L525:
        r1312 = r206;
        goto L527
    L521:
        r1311 = r205;
        goto L523
    L517:
        r1310 = r204;
        goto L519
    L513:
        r139 = r203;
        goto L515
    L509:
        r138 = null;
        goto L511
    L505:
        r137 = null;
        goto L507
    L501:
        r136 = null;
        goto L503
    L497:
        r135 = r202;
        goto L499
    L493:
        r1217 = r201;
        goto L495
    L489:
        r134 = 67108864;
        r1216 = null;
        goto L491
    L485:
        r1215 = r200;
        goto L487
    L481:
        r1214 = r199;
        goto L483
    L477:
        r133 = 8388608;
        r1213 = null;
        goto L479
    L473:
        r132 = 4194304;
        r1212 = null;
        goto L475
    L469:
        r131 = 2097152;
        r1211 = null;
        goto L471
    L465:
        r130 = 1048576;
        r1210 = null;
        goto L467
    L461:
        r129 = r198;
        goto L463
    L457:
        r128 = r197;
        goto L459
    L453:
        r1119 = r196;
        goto L455
    L449:
        r1118 = r195;
        goto L451
    L445:
        r1117 = r194;
        goto L447
    L441:
        r1116 = r193;
        goto L443
    L437:
        r1115 = null;
        goto L439
    L433:
        r1114 = null;
        goto L435
    L429:
        r1113 = null;
        goto L431
    L425:
        r1112 = null;
        goto L427
    L421:
        r1111 = null;
        goto L423
    L417:
        r1110 = null;
        goto L419
    L413:
        r1019 = null;
        goto L415
    L409:
        r1018 = null;
        goto L411
    L405:
        r1017 = null;
        goto L407
    L401:
        r1016 = null;
        goto L403
    L397:
        r1015 = null;
        goto L399
    L393:
        r1014 = null;
        goto L395
    L389:
        r1013 = null;
        goto L391
    L385:
        r1012 = null;
        goto L387
    L381:
        r1011 = null;
        goto L383
    L377:
        r1010 = null;
        goto L379
    L373:
        r919 = null;
        goto L375
    L369:
        r918 = null;
        goto L371
    L365:
        r127 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
        r917 = null;
        goto L367
    L361:
        r126 = 67108864;
        r916 = null;
        goto L363
    L357:
        r125 = 33554432;
        r915 = null;
        goto L359
    L353:
        r124 = 16777216;
        r914 = null;
        goto L355
    L349:
        r123 = 8388608;
        r913 = null;
        goto L351
    L345:
        r122 = 4194304;
        r912 = null;
        goto L347
    L341:
        r121 = 2097152;
        r911 = null;
        goto L343
    L337:
        r120 = 1048576;
        r910 = null;
        goto L339
    L333:
        r109 = 524288;
        r819 = null;
        goto L335
    L329:
        r108 = 262144;
        r818 = null;
        goto L331
    L325:
        r107 = 131072;
        r817 = null;
        goto L327
    L321:
        r106 = 65536;
        r816 = null;
        goto L323
    L317:
        r815 = null;
        goto L319
    L313:
        r814 = null;
        goto L315
    L309:
        r813 = r192;
        goto L311
    L305:
        r812 = r191;
        goto L307
    L301:
        r811 = r190;
        goto L303
    L297:
        r810 = null;
        goto L299
    L293:
        r719 = r189;
        goto L295
    L289:
        r718 = r188;
        goto L291
    L285:
        r717 = null;
        goto L287
    L281:
        r716 = null;
        goto L283
    L277:
        r715 = r187;
        goto L279
    L273:
        r714 = r186;
        goto L275
    L269:
        r713 = null;
        goto L271
    L265:
        r712 = r185;
        goto L267
    L261:
        r711 = r184;
        goto L263
    L257:
        r710 = null;
        goto L259
    L253:
        r619 = null;
        goto L255
    L249:
        r618 = r183;
        goto L251
    L245:
        r617 = r182;
        goto L247
    L241:
        r616 = r181;
        goto L243
    L237:
        r615 = r180;
        goto L239
    L233:
        r105 = 67108864;
        r614 = null;
        goto L235
    L229:
        r104 = 33554432;
        r613 = null;
        goto L231
    L225:
        r612 = r179;
        goto L227
    L221:
        r611 = r178;
        goto L223
    L217:
        r610 = r177;
        goto L219
    L213:
        r519 = r176;
        goto L215
    L209:
        r518 = r175;
        goto L211
    L205:
        r517 = r174;
        goto L207
    L201:
        r103 = 262144;
        r516 = null;
        goto L203
    L197:
        r515 = r173;
        goto L199
    L193:
        r514 = r172;
        goto L195
    L189:
        r513 = r171;
        goto L191
    L185:
        r512 = r170;
        goto L187
    L181:
        r511 = r169;
        goto L183
    L177:
        r510 = r168;
        goto L179
    L173:
        r419 = r167;
        goto L175
    L169:
        r418 = null;
        goto L171
    L165:
        r417 = null;
        goto L167
    L161:
        r416 = null;
        goto L163
    L157:
        r415 = null;
        goto L159
    L153:
        r414 = r166;
        goto L155
    L149:
        r413 = r165;
        goto L151
    L145:
        r412 = r164;
        goto L147
    L141:
        r411 = null;
        goto L143
    L137:
        r410 = r163;
        goto L139
    L133:
        r319 = null;
        goto L135
    L129:
        r318 = r162;
        goto L131
    L125:
        r317 = r161;
        goto L127
    L121:
        r316 = r160;
        goto L123
    L117:
        r315 = r159;
        goto L119
    L113:
        r314 = r158;
        goto L115
    L109:
        r313 = r157;
        goto L111
    L105:
        r312 = r156;
        goto L107
    L101:
        r311 = r155;
        goto L103
    L97:
        r310 = r154;
        goto L99
    L93:
        r225 = r153;
        goto L95
    L89:
        r224 = r152;
        goto L91
    L85:
        r223 = r151;
        goto L87
    L81:
        r222 = r150;
        goto L83
    L77:
        r221 = r149;
        goto L79
    L73:
        r220 = r148;
        goto L75
    L69:
        r219 = r147;
        goto L71
    L65:
        r218 = r146;
        goto L67
    L61:
        r217 = null;
        goto L63
    L57:
        r216 = null;
        goto L59
    L53:
        r119 = null;
        goto L55
    L49:
        r118 = null;
        goto L51
    L45:
        r117 = null;
        goto L47
    L41:
        r116 = r145;
        goto L43
    L37:
        r115 = null;
        goto L39
    L33:
        r114 = null;
        goto L35
    L29:
        r113 = null;
        goto L31
    L25:
        r112 = null;
        goto L27
    L21:
        r111 = null;
        goto L23
    L17:
        r110 = null;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = r144;
        goto L11
    L5:
        r100 = r143;
        goto L7
    }
}
