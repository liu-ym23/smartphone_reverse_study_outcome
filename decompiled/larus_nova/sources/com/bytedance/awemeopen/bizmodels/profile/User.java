package com.bytedance.awemeopen.bizmodels.profile;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.amap.api.services.district.DistrictSearchQuery;
import com.android.ttcjpaysdk.integrated.counter.outerpay.CJOuterPayManager;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.awemeopen.infra.base.live.AoLive;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.tencent.connect.common.Constants;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import r14.a0;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b_\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b.\u0018\u00002\u00020\u0001:\u0002´\u0002B\t¢\u0006\u0006\b²\u0002\u0010³\u0002R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u001a\u0010\u0012R$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R$\u0010%\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R$\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b,\u0010.\"\u0004\b/\u00100R\"\u00101\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u000e\u001a\u0004\b2\u0010\u0010\"\u0004\b3\u0010\u0012R\"\u00104\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u000e\u001a\u0004\b5\u0010\u0010\"\u0004\b6\u0010\u0012R\"\u00107\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010\u000e\u001a\u0004\b8\u0010\u0010\"\u0004\b9\u0010\u0012R$\u0010:\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0004\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u0010\bR\"\u0010=\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u000e\u001a\u0004\b>\u0010\u0010\"\u0004\b?\u0010\u0012R\"\u0010@\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010\u000e\u001a\u0004\bA\u0010\u0010\"\u0004\bB\u0010\u0012R\"\u0010D\u001a\u00020C8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010J\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bJ\u0010\u000e\u001a\u0004\bK\u0010\u0010\"\u0004\bL\u0010\u0012R\"\u0010M\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bM\u0010\u000e\u001a\u0004\bN\u0010\u0010\"\u0004\bO\u0010\u0012R\"\u0010P\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bP\u0010\u000e\u001a\u0004\bQ\u0010\u0010\"\u0004\bR\u0010\u0012R$\u0010S\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bS\u0010\u0004\u001a\u0004\bT\u0010\u0006\"\u0004\bU\u0010\bR\"\u0010V\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bV\u0010-\u001a\u0004\bW\u0010.\"\u0004\bX\u00100R\"\u0010Y\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bY\u0010\u000e\u001a\u0004\bZ\u0010\u0010\"\u0004\b[\u0010\u0012R\"\u0010\\\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\\\u0010\u000e\u001a\u0004\b]\u0010\u0010\"\u0004\b^\u0010\u0012R$\u0010_\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b_\u0010\u0004\u001a\u0004\b`\u0010\u0006\"\u0004\ba\u0010\bR$\u0010b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bb\u0010\u0004\u001a\u0004\bc\u0010\u0006\"\u0004\bd\u0010\bR$\u0010e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\be\u0010\u0004\u001a\u0004\bf\u0010\u0006\"\u0004\bg\u0010\bR$\u0010h\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bh\u0010\u0004\u001a\u0004\bi\u0010\u0006\"\u0004\bj\u0010\bR$\u0010k\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bk\u0010\u0004\u001a\u0004\bl\u0010\u0006\"\u0004\bm\u0010\bR$\u0010n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bn\u0010\u0004\u001a\u0004\bo\u0010\u0006\"\u0004\bp\u0010\bR$\u0010q\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bq\u0010\u0004\u001a\u0004\br\u0010\u0006\"\u0004\bs\u0010\bR$\u0010t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bt\u0010\u0004\u001a\u0004\bu\u0010\u0006\"\u0004\bv\u0010\bR$\u0010w\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bw\u0010\u0004\u001a\u0004\bx\u0010\u0006\"\u0004\by\u0010\bR\"\u0010z\u001a\u00020C8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bz\u0010E\u001a\u0004\b{\u0010G\"\u0004\b|\u0010IR\"\u0010}\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b}\u0010\u000e\u001a\u0004\b~\u0010\u0010\"\u0004\b\u007f\u0010\u0012R&\u0010\u0080\u0001\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0080\u0001\u0010-\u001a\u0005\b\u0081\u0001\u0010.\"\u0005\b\u0082\u0001\u00100R(\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0083\u0001\u0010\u0004\u001a\u0005\b\u0084\u0001\u0010\u0006\"\u0005\b\u0085\u0001\u0010\bR&\u0010\u0086\u0001\u001a\u00020C8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0086\u0001\u0010E\u001a\u0005\b\u0087\u0001\u0010G\"\u0005\b\u0088\u0001\u0010IR&\u0010\u0089\u0001\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0089\u0001\u0010\u000e\u001a\u0005\b\u008a\u0001\u0010\u0010\"\u0005\b\u008b\u0001\u0010\u0012R&\u0010\u008c\u0001\u001a\u00020C8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008c\u0001\u0010E\u001a\u0005\b\u008d\u0001\u0010G\"\u0005\b\u008e\u0001\u0010IR(\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008f\u0001\u0010\u0004\u001a\u0005\b\u0090\u0001\u0010\u0006\"\u0005\b\u0091\u0001\u0010\bR&\u0010\u0092\u0001\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0092\u0001\u0010-\u001a\u0005\b\u0093\u0001\u0010.\"\u0005\b\u0094\u0001\u00100R&\u0010\u0095\u0001\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0095\u0001\u0010-\u001a\u0005\b\u0096\u0001\u0010.\"\u0005\b\u0097\u0001\u00100R&\u0010\u0098\u0001\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0098\u0001\u0010-\u001a\u0005\b\u0099\u0001\u0010.\"\u0005\b\u009a\u0001\u00100R(\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009b\u0001\u0010\u0004\u001a\u0005\b\u009c\u0001\u0010\u0006\"\u0005\b\u009d\u0001\u0010\bR&\u0010\u009e\u0001\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009e\u0001\u0010-\u001a\u0005\b\u009e\u0001\u0010.\"\u0005\b\u009f\u0001\u00100R&\u0010 \u0001\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b \u0001\u0010\u000e\u001a\u0005\b¡\u0001\u0010\u0010\"\u0005\b¢\u0001\u0010\u0012R3\u0010¥\u0001\u001a\f\u0012\u0005\u0012\u00030¤\u0001\u0018\u00010£\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b¥\u0001\u0010¦\u0001\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001R&\u0010«\u0001\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b«\u0001\u0010\u000e\u001a\u0005\b«\u0001\u0010\u0010\"\u0005\b¬\u0001\u0010\u0012R(\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u00ad\u0001\u0010\u0004\u001a\u0005\b®\u0001\u0010\u0006\"\u0005\b¯\u0001\u0010\bR&\u0010°\u0001\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b°\u0001\u0010-\u001a\u0005\b±\u0001\u0010.\"\u0005\b²\u0001\u00100R(\u0010³\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b³\u0001\u0010\u0004\u001a\u0005\b´\u0001\u0010\u0006\"\u0005\bµ\u0001\u0010\bR&\u0010¶\u0001\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¶\u0001\u0010\u000e\u001a\u0005\b·\u0001\u0010\u0010\"\u0005\b¸\u0001\u0010\u0012R\u001c\u0010º\u0001\u001a\u0005\u0018\u00010¹\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R&\u0010¼\u0001\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¼\u0001\u0010-\u001a\u0005\b½\u0001\u0010.\"\u0005\b¾\u0001\u00100R&\u0010¿\u0001\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¿\u0001\u0010-\u001a\u0005\b¿\u0001\u0010.\"\u0005\bÀ\u0001\u00100R(\u0010Á\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÁ\u0001\u0010\u0004\u001a\u0005\bÂ\u0001\u0010\u0006\"\u0005\bÃ\u0001\u0010\bR&\u0010Ä\u0001\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÄ\u0001\u0010-\u001a\u0005\bÄ\u0001\u0010.\"\u0005\bÅ\u0001\u00100R(\u0010Æ\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÆ\u0001\u0010\u0004\u001a\u0005\bÇ\u0001\u0010\u0006\"\u0005\bÈ\u0001\u0010\bR(\u0010É\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÉ\u0001\u0010\u0004\u001a\u0005\bÊ\u0001\u0010\u0006\"\u0005\bË\u0001\u0010\bR(\u0010Ì\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÌ\u0001\u0010\u0004\u001a\u0005\bÍ\u0001\u0010\u0006\"\u0005\bÎ\u0001\u0010\bR(\u0010Ï\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÏ\u0001\u0010\u0004\u001a\u0005\bÐ\u0001\u0010\u0006\"\u0005\bÑ\u0001\u0010\bR&\u0010Ò\u0001\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÒ\u0001\u0010\u000e\u001a\u0005\bÓ\u0001\u0010\u0010\"\u0005\bÔ\u0001\u0010\u0012R&\u0010Õ\u0001\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÕ\u0001\u0010-\u001a\u0005\bÖ\u0001\u0010.\"\u0005\b×\u0001\u00100R,\u0010Ù\u0001\u001a\u0005\u0018\u00010Ø\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÙ\u0001\u0010Ú\u0001\u001a\u0006\bÛ\u0001\u0010Ü\u0001\"\u0006\bÝ\u0001\u0010Þ\u0001R,\u0010à\u0001\u001a\u0005\u0018\u00010ß\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bà\u0001\u0010á\u0001\u001a\u0006\bâ\u0001\u0010ã\u0001\"\u0006\bä\u0001\u0010å\u0001R3\u0010ç\u0001\u001a\f\u0012\u0005\u0012\u00030æ\u0001\u0018\u00010£\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bç\u0001\u0010¦\u0001\u001a\u0006\bè\u0001\u0010¨\u0001\"\u0006\bé\u0001\u0010ª\u0001R3\u0010ë\u0001\u001a\f\u0012\u0005\u0012\u00030ê\u0001\u0018\u00010£\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bë\u0001\u0010¦\u0001\u001a\u0006\bì\u0001\u0010¨\u0001\"\u0006\bí\u0001\u0010ª\u0001R&\u0010î\u0001\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bî\u0001\u0010-\u001a\u0005\bï\u0001\u0010.\"\u0005\bð\u0001\u00100R&\u0010ñ\u0001\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bñ\u0001\u0010-\u001a\u0005\bò\u0001\u0010.\"\u0005\bó\u0001\u00100R&\u0010ô\u0001\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bô\u0001\u0010-\u001a\u0005\bõ\u0001\u0010.\"\u0005\bö\u0001\u00100R(\u0010÷\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b÷\u0001\u0010\u0004\u001a\u0005\bø\u0001\u0010\u0006\"\u0005\bù\u0001\u0010\bR(\u0010ú\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bú\u0001\u0010\u0004\u001a\u0005\bû\u0001\u0010\u0006\"\u0005\bü\u0001\u0010\bR(\u0010ý\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bý\u0001\u0010\u0004\u001a\u0005\bþ\u0001\u0010\u0006\"\u0005\bÿ\u0001\u0010\bR,\u0010\u0081\u0002\u001a\u0005\u0018\u00010\u0080\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0081\u0002\u0010\u0082\u0002\u001a\u0006\b\u0083\u0002\u0010\u0084\u0002\"\u0006\b\u0085\u0002\u0010\u0086\u0002R,\u0010\u0088\u0002\u001a\u0005\u0018\u00010\u0087\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0088\u0002\u0010\u0089\u0002\u001a\u0006\b\u008a\u0002\u0010\u008b\u0002\"\u0006\b\u008c\u0002\u0010\u008d\u0002R&\u0010\u008e\u0002\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008e\u0002\u0010-\u001a\u0005\b\u008f\u0002\u0010.\"\u0005\b\u0090\u0002\u00100R&\u0010\u0091\u0002\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0091\u0002\u0010-\u001a\u0005\b\u0092\u0002\u0010.\"\u0005\b\u0093\u0002\u00100R&\u0010\u0094\u0002\u001a\u00020C8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0094\u0002\u0010E\u001a\u0005\b\u0095\u0002\u0010G\"\u0005\b\u0096\u0002\u0010IR&\u0010\u0097\u0002\u001a\u00020C8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0097\u0002\u0010E\u001a\u0005\b\u0098\u0002\u0010G\"\u0005\b\u0099\u0002\u0010IR&\u0010\u009a\u0002\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009a\u0002\u0010-\u001a\u0005\b\u009b\u0002\u0010.\"\u0005\b\u009c\u0002\u00100R&\u0010\u009d\u0002\u001a\u00020C8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009d\u0002\u0010E\u001a\u0005\b\u009e\u0002\u0010G\"\u0005\b\u009f\u0002\u0010IR&\u0010 \u0002\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b \u0002\u0010\u000e\u001a\u0005\b¡\u0002\u0010\u0010\"\u0005\b¢\u0002\u0010\u0012R&\u0010£\u0002\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b£\u0002\u0010\u000e\u001a\u0005\b¤\u0002\u0010\u0010\"\u0005\b¥\u0002\u0010\u0012R&\u0010¦\u0002\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¦\u0002\u0010\u000e\u001a\u0005\b§\u0002\u0010\u0010\"\u0005\b¨\u0002\u0010\u0012R&\u0010©\u0002\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b©\u0002\u0010\u000e\u001a\u0005\bª\u0002\u0010\u0010\"\u0005\b«\u0002\u0010\u0012R&\u0010¬\u0002\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¬\u0002\u0010-\u001a\u0005\b\u00ad\u0002\u0010.\"\u0005\b®\u0002\u00100R&\u0010¯\u0002\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¯\u0002\u0010\u000e\u001a\u0005\b°\u0002\u0010\u0010\"\u0005\b±\u0002\u0010\u0012¨\u0006µ\u0002"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/profile/User;", "", "", "openId", "Ljava/lang/String;", "u", "()Ljava/lang/String;", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;)V", InstantPlayContext.NICKNAME, "t", "setNickname", "", "gender", "I", "q", "()I", "setGender", "(I)V", "showGenderStrategy", "C", "setShowGenderStrategy", "signature", FaceService.girlLabel, "setSignature", "userAge", "setUserAge", "Lt14/a;", "avatarLarger", "Lt14/a;", "getAvatarLarger", "()Lt14/a;", "setAvatarLarger", "(Lt14/a;)V", "avatarThumb", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAvatarThumb", "avatarMedium", "getAvatarMedium", "setAvatarMedium", "roomData", "y", "setRoomData", "", "isVerified", "Z", "()Z", "setVerified", "(Z)V", "allowStatus", "getAllowStatus", "setAllowStatus", "followStatus", "m", "setFollowStatus", "awemeCount", "b", "setAwemeCount", "recommendReason", "getRecommendReason", "setRecommendReason", "followingCount", "p", "setFollowingCount", "followerCount", OfficeSDKRequestTag.KEY_NEW_USER, "setFollowerCount", "", "totalFavorited", "J", FaceService.neutralLabel, "()J", "setTotalFavorited", "(J)V", "favoritingCount", "l", "setFavoritingCount", "storyCount", "getStoryCount", "setStoryCount", "registerStatus", "getRegisterStatus", "setRegisterStatus", "thirdName", "getThirdName", "setThirdName", "hideSearch", "getHideSearch", "setHideSearch", "verificationType", "getVerificationType", "setVerificationType", "constellation", "getConstellation", "setConstellation", "city", "d", "setCity", DistrictSearchQuery.KEYWORDS_COUNTRY, ce.f26391f, "setCountry", "province", BaseSwitches.V, "setProvince", "cityName", "getCityName", "setCityName", DistrictSearchQuery.KEYWORDS_DISTRICT, RXScreenCaptureService.KEY_INDEX, "setDistrict", "weiboVerify", "L", "setWeiboVerify", "customVerify", "getCustomVerify", "setCustomVerify", "uniqueId", "getUniqueId", "setUniqueId", CJOuterPayManager.KEY_BINDPHONE, "getBindPhone", "setBindPhone", "createTime", "getCreateTime", "setCreateTime", "needRecommend", "getNeedRecommend", "setNeedRecommend", "storyOpen", "getStoryOpen", "setStoryOpen", "requestId", "getRequestId", "setRequestId", "roomId", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "setRoomId", "verifyStatus", "getVerifyStatus", "setVerifyStatus", "authorityStatus", "getAuthorityStatus", "setAuthorityStatus", "verifyInfo", "getVerifyInfo", "setVerifyInfo", "withCommerceEntry", "getWithCommerceEntry", "setWithCommerceEntry", "hasMedal", "getHasMedal", "setHasMedal", "starUseNewDownload", "getStarUseNewDownload", "setStarUseNewDownload", "enterpriseVerifyReason", ce.f26395j, "setEnterpriseVerifyReason", "isAdFake", "setAdFake", "fansCount", "getFansCount", "setFansCount", "", "Lcom/bytedance/awemeopen/bizmodels/profile/h;", "followerDetailList", "Ljava/util/List;", "getFollowerDetailList", "()Ljava/util/List;", "setFollowerDetailList", "(Ljava/util/List;)V", "isSyncToutiao", "setSyncToutiao", "relationLabel", "x", "setRelationLabel", "mIsGovMediaVip", "getMIsGovMediaVip", "setMIsGovMediaVip", "accountRegion", "getAccountRegion", "setAccountRegion", "commerceUserLevel", "f", "setCommerceUserLevel", "Lcom/bytedance/awemeopen/bizmodels/profile/j;", "userHonor", "Lcom/bytedance/awemeopen/bizmodels/profile/j;", "isBlock", "M", "setBlock", "isBlocked", "setBlocked", "weiboNickname", "getWeiboNickname", "setWeiboNickname", "isBindedWeibo", "setBindedWeibo", "weiboUrl", "getWeiboUrl", "setWeiboUrl", "weiboSchema", "getWeiboSchema", "setWeiboSchema", "schoolName", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setSchoolName", "schoolPoiId", "getSchoolPoiId", "setSchoolPoiId", "schoolType", "getSchoolType", "setSchoolType", "hideCity", "r", "setHideCity", "Lcom/bytedance/awemeopen/bizmodels/profile/CoverAndHeadImageInfo;", "coverInfo", "Lcom/bytedance/awemeopen/bizmodels/profile/CoverAndHeadImageInfo;", "h", "()Lcom/bytedance/awemeopen/bizmodels/profile/CoverAndHeadImageInfo;", "setCoverInfo", "(Lcom/bytedance/awemeopen/bizmodels/profile/CoverAndHeadImageInfo;)V", "Lcom/bytedance/awemeopen/bizmodels/profile/i;", "publishRemindInfo", "Lcom/bytedance/awemeopen/bizmodels/profile/i;", "w", "()Lcom/bytedance/awemeopen/bizmodels/profile/i;", "setPublishRemindInfo", "(Lcom/bytedance/awemeopen/bizmodels/profile/i;)V", "Lcom/bytedance/awemeopen/bizmodels/profile/k;", "userPermissionStructList", "getUserPermissionStructList", "setUserPermissionStructList", "Lcom/bytedance/awemeopen/bizmodels/profile/c;", "cardEntries", "c", "setCardEntries", "showImEntry", "D", "setShowImEntry", "isFansCountLimit", "N", "setFansCountLimit", "hideTotalFavorite", "s", "setHideTotalFavorite", "totalFavoriteInCharge", "G", "setTotalFavoriteInCharge", "fanCountInCharge", ce.f26396k, "setFanCountInCharge", "followerCountStrDesc", "o", "setFollowerCountStrDesc", "Lcom/bytedance/awemeopen/bizmodels/profile/f;", "commercePermission", "Lcom/bytedance/awemeopen/bizmodels/profile/f;", "e", "()Lcom/bytedance/awemeopen/bizmodels/profile/f;", "setCommercePermission", "(Lcom/bytedance/awemeopen/bizmodels/profile/f;)V", "Lcom/bytedance/awemeopen/bizmodels/profile/UserProfileShowStruct;", "userProfileShowStruct", "Lcom/bytedance/awemeopen/bizmodels/profile/UserProfileShowStruct;", "K", "()Lcom/bytedance/awemeopen/bizmodels/profile/UserProfileShowStruct;", "setUserProfileShowStruct", "(Lcom/bytedance/awemeopen/bizmodels/profile/UserProfileShowStruct;)V", "hasFacebookToken", "getHasFacebookToken", "setHasFacebookToken", "hasTwitterToken", "getHasTwitterToken", "setHasTwitterToken", "fbExpireTime", "getFbExpireTime", "setFbExpireTime", "twExpireTime", "getTwExpireTime", "setTwExpireTime", "hasYoutubeToken", "getHasYoutubeToken", "setHasYoutubeToken", "youtubeExpireTime", "getYoutubeExpireTime", "setYoutubeExpireTime", "shieldFollowNotice", "getShieldFollowNotice", "setShieldFollowNotice", "shieldDiggNotice", "getShieldDiggNotice", "setShieldDiggNotice", "shieldCommentNotice", "getShieldCommentNotice", "setShieldCommentNotice", "followerStatus", "getFollowerStatus", "setFollowerStatus", "showFavoriteList", "B", "setShowFavoriteList", "secret", "getSecret", "setSecret", "<init>", "()V", "Companion", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class User implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, k> f198201a;

    @SerializedName("account_region")
    private String accountRegion;

    @SerializedName("allowStatus")
    private int allowStatus;

    @SerializedName("authority_status")
    private long authorityStatus;

    @SerializedName("avatar_larger")
    private t14.a avatarLarger;

    @SerializedName("avatar_medium")
    private t14.a avatarMedium;

    @SerializedName("avatar_thumb")
    private t14.a avatarThumb;

    @SerializedName("aweme_count")
    private int awemeCount;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a0 f198202b;

    @SerializedName("bind_phone")
    private String bindPhone;

    @SerializedName("card_entries")
    private List<c> cardEntries;

    @SerializedName("location")
    private String city;

    @SerializedName("city")
    private String cityName;

    @SerializedName("commerce_permissions")
    private f commercePermission;

    @SerializedName("commerce_user_level")
    private int commerceUserLevel;

    @SerializedName("constellation")
    private int constellation;

    @SerializedName(DistrictSearchQuery.KEYWORDS_COUNTRY)
    private String country;

    @SerializedName("cover_and_head_image_info")
    private CoverAndHeadImageInfo coverInfo;

    @SerializedName("create_time")
    private long createTime;

    @SerializedName("custom_verify")
    private String customVerify;

    @SerializedName(DistrictSearchQuery.KEYWORDS_DISTRICT)
    private String district;

    @SerializedName("enterprise_verify_reason")
    private String enterpriseVerifyReason;

    @SerializedName("fan_count_str")
    private String fanCountInCharge;

    @SerializedName("mplatform_followers_count")
    private int fansCount;

    @SerializedName("favoriting_count")
    private int favoritingCount;

    @SerializedName("fb_expire_time")
    private long fbExpireTime;

    @SerializedName("follow_status")
    private int followStatus;

    @SerializedName("fan_count")
    private int followerCount;

    @SerializedName("follower_count_str_desc")
    private String followerCountStrDesc;

    @SerializedName("followers_detail")
    private List<h> followerDetailList;

    @SerializedName("follower_status")
    private int followerStatus;

    @SerializedName("following_count")
    private int followingCount;

    @SerializedName("gender")
    private int gender;

    @SerializedName("has_facebook_token")
    private boolean hasFacebookToken;

    @SerializedName("has_activity_medal")
    private boolean hasMedal;

    @SerializedName("has_twitter_token")
    private boolean hasTwitterToken;

    @SerializedName("has_youtube_token")
    private boolean hasYoutubeToken;

    @SerializedName("hide_location")
    private boolean hideCity;

    @SerializedName("hide_search")
    private boolean hideSearch;

    @SerializedName("hide_total_favorited")
    private boolean hideTotalFavorite;

    @SerializedName("is_ad_fake")
    private boolean isAdFake;

    @SerializedName("is_binded_weibo")
    private boolean isBindedWeibo;

    @SerializedName("is_block")
    private boolean isBlock;

    @SerializedName("is_blocked")
    private boolean isBlocked;

    @SerializedName("fans_count_limit")
    private boolean isFansCountLimit;

    @SerializedName("sync_to_toutiao")
    private int isSyncToutiao;

    @SerializedName("is_verified")
    private boolean isVerified;

    @SerializedName("is_gov_media_vip")
    private boolean mIsGovMediaVip;

    @SerializedName("need_recommend")
    private int needRecommend;

    @SerializedName(InstantPlayContext.NICKNAME)
    private String nickname;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    private String openId;

    @SerializedName("province")
    private String province;

    @SerializedName("punish_remind_info")
    private i publishRemindInfo;

    @SerializedName("recommend_reason")
    private String recommendReason;

    @SerializedName("registerStatus")
    private int registerStatus;

    @SerializedName("relation_label")
    private String relationLabel;

    @SerializedName("rid")
    private String requestId;

    @SerializedName("room_data")
    private String roomData;

    @SerializedName("room_id")
    private long roomId;

    @SerializedName("school_name")
    private String schoolName;

    @SerializedName("school_poi_id")
    private String schoolPoiId;

    @SerializedName("school_type")
    private int schoolType;

    @SerializedName("secret")
    private int secret;

    @SerializedName("shield_comment_notice")
    private int shieldCommentNotice;

    @SerializedName("shield_digg_notice")
    private int shieldDiggNotice;

    @SerializedName("shield_follow_notice")
    private int shieldFollowNotice;

    @SerializedName("show_favorite_list")
    private boolean showFavoriteList;

    @SerializedName("show_gender_strategy")
    private int showGenderStrategy;

    @SerializedName("show_im_entry")
    private boolean showImEntry;

    @SerializedName("signature")
    private String signature;

    @SerializedName("star_use_new_download")
    private boolean starUseNewDownload;

    @SerializedName("story_count")
    private int storyCount;

    @SerializedName("story_open")
    private boolean storyOpen;

    @SerializedName("third_name")
    private String thirdName;

    @SerializedName("total_favorited_str")
    private String totalFavoriteInCharge;

    @SerializedName("total_favorited")
    private long totalFavorited;

    @SerializedName("tw_expire_time")
    private long twExpireTime;

    @SerializedName(BdpAppEventConstant.PARAMS_UNIQUEID)
    private String uniqueId;

    @SerializedName("user_age")
    private int userAge;

    @SerializedName("pay_grade")
    private j userHonor;

    @SerializedName("user_permissions")
    private List<k> userPermissionStructList;

    @SerializedName("profile_show")
    private UserProfileShowStruct userProfileShowStruct;

    @SerializedName("verification_type")
    private int verificationType;

    @SerializedName("verify_info")
    private String verifyInfo;

    @SerializedName("live_verify")
    private int verifyStatus;

    @SerializedName("weibo_name")
    private String weiboNickname;

    @SerializedName("weibo_schema")
    private String weiboSchema;

    @SerializedName("weibo_url")
    private String weiboUrl;

    @SerializedName("weibo_verify")
    private String weiboVerify;

    @SerializedName("with_commerce_entry")
    private boolean withCommerceEntry;

    @SerializedName("youtube_expire_time")
    private long youtubeExpireTime;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/profile/User$Companion$BirthdayHideLevel;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface BirthdayHideLevel {
            public static final a Companion = null;
            public static final int DEFAULT = 0;
            public static final int HIDE = 1;

            public static final class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ a f198203a = null;

                static {
                    f198203a = new a();
                }

                public a() {
                }
            }

            static {
                Companion = a.f198203a;
            }
        }
    }

    static {
    }

    public final Map<String, k> J() {
        if (this.f198201a != null) goto L16;
        if (this.userPermissionStructList == null) goto L16;
        this.f198201a = new HashMap();
        List<k> r100 = this.userPermissionStructList;
        Intrinsics.checkNotNull(r100);
        Iterator<k> r101 = r100.iterator();
    L8:
        if (r101.hasNext() == false) goto L16;
        k r102 = r101.next();
        Map<String, k> r103 = this.f198201a;
        if (r103 == null) goto L8;
        String r104 = r102.a();
        if (r104 != null) goto L14;
        r104 = "";
    L14:
        k r105 = r103.put(r104, r102);
    L16:
        return this.f198201a;
    }

    public final boolean O() {
        int r100 = this.followerStatus;
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public final boolean Q() {
        if (this.roomId == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean S() {
        if (this.secret == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final int hashCode() {
        String r100 = this.openId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.nickname;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((((r103 + r105) * 31) + this.gender) * 31) + this.userAge) * 31;
        String r107 = this.signature;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        t14.a r110 = this.avatarLarger;
        if (r110 == null) goto L18;
        if (r110 == null) goto L18;
        int r111 = r110.hashCode();
    L19:
        int r112 = (r109 + r111) * 31;
        t14.a r113 = this.avatarThumb;
        if (r113 == null) goto L23;
        if (r113 == null) goto L23;
        int r114 = r113.hashCode();
    L24:
        int r115 = (r112 + r114) * 31;
        t14.a r116 = this.avatarMedium;
        if (r116 == null) goto L28;
        if (r116 == null) goto L28;
        int r117 = r116.hashCode();
    L29:
        int r118 = (((((((((((((((((r115 + r117) * 31) + (this.isVerified ? 1 : 0)) * 31) + this.allowStatus) * 31) + this.followStatus) * 31) + this.awemeCount) * 31) + this.followingCount) * 31) + this.followerCount) * 31) + this.favoritingCount) * 31) + this.registerStatus) * 31;
        String r119 = this.thirdName;
        if (r119 == null) goto L33;
        if (r119 == null) goto L33;
        int r120 = r119.hashCode();
    L34:
        int r121 = (((((((r118 + r120) * 31) + (this.hideSearch ? 1 : 0)) * 31) + 0) * 31) + this.constellation) * 31;
        String r122 = this.city;
        if (r122 == null) goto L38;
        if (r122 == null) goto L38;
        int r123 = r122.hashCode();
    L39:
        int r124 = (r121 + r123) * 31;
        String r125 = this.weiboVerify;
        if (r125 == null) goto L43;
        if (r125 == null) goto L43;
        int r126 = r125.hashCode();
    L44:
        int r127 = (r124 + r126) * 31;
        String r128 = this.customVerify;
        if (r128 == null) goto L48;
        if (r128 == null) goto L48;
        int r129 = r128.hashCode();
    L49:
        int r130 = (r127 + r129) * 31;
        String r131 = this.bindPhone;
        if (r131 == null) goto L53;
        if (r131 == null) goto L53;
        r101 = r131.hashCode();
    L53:
        int r132 = (r130 + r101) * 31;
        long r133 = this.createTime;
        return ((((r132 + ((int) (r133 ^ (r133 >>> 32)))) * 31) + this.needRecommend) * 31) + (this.hideCity ? 1 : 0);
    L48:
        r129 = 0;
    L43:
        r126 = 0;
    L38:
        r123 = 0;
    L33:
        r120 = 0;
    L28:
        r117 = 0;
    L23:
        r114 = 0;
    L18:
        r111 = 0;
        goto L19
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

    public User() {
        this.openId = "";
        this.nickname = "";
        this.signature = "";
    }

    public final boolean R() {
        if (Q() == true) goto L5;
    L7:
        return false;
    L5:
        if (AoLive.b() == false) goto L7;
        return true;
    }

    public final Object clone() {
        Object r100 = super.clone();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.awemeopen.bizmodels.profile.User");
        return (User) r100;
    }

    public final String A() {
        return this.schoolName;
    }

    public final boolean B() {
        return this.showFavoriteList;
    }

    public final int C() {
        return this.showGenderStrategy;
    }

    public final boolean D() {
        return this.showImEntry;
    }

    public final String F() {
        return this.signature;
    }

    public final String G() {
        return this.totalFavoriteInCharge;
    }

    public final long H() {
        return this.totalFavorited;
    }

    public final int I() {
        return this.userAge;
    }

    public final UserProfileShowStruct K() {
        return this.userProfileShowStruct;
    }

    public final String L() {
        return this.weiboVerify;
    }

    public final boolean M() {
        return this.isBlock;
    }

    public final boolean N() {
        return this.isFansCountLimit;
    }

    public final boolean P() {
        return this.mIsGovMediaVip;
    }

    public final t14.a a() {
        return this.avatarThumb;
    }

    public final int b() {
        return this.awemeCount;
    }

    public final List<c> c() {
        return this.cardEntries;
    }

    public final String d() {
        return this.city;
    }

    public final f e() {
        return this.commercePermission;
    }

    public final int f() {
        return this.commerceUserLevel;
    }

    public final String g() {
        return this.country;
    }

    public final CoverAndHeadImageInfo h() {
        return this.coverInfo;
    }

    public final String i() {
        return this.district;
    }

    public final String j() {
        return this.enterpriseVerifyReason;
    }

    public final String k() {
        return this.fanCountInCharge;
    }

    public final int l() {
        return this.favoritingCount;
    }

    public final int m() {
        return this.followStatus;
    }

    public final int n() {
        return this.followerCount;
    }

    public final String o() {
        return this.followerCountStrDesc;
    }

    public final int p() {
        return this.followingCount;
    }

    public final int q() {
        return this.gender;
    }

    public final boolean r() {
        return this.hideCity;
    }

    public final boolean s() {
        return this.hideTotalFavorite;
    }

    public final String t() {
        return this.nickname;
    }

    public final String u() {
        return this.openId;
    }

    public final String v() {
        return this.province;
    }

    public final i w() {
        return this.publishRemindInfo;
    }

    public final String x() {
        return this.relationLabel;
    }

    public final String y() {
        return this.roomData;
    }

    public final long z() {
        return this.roomId;
    }

    public final void T(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.openId = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof User) == true) goto L8;
        return false;
    L8:
        User r101 = (User) r100;
        if (this.gender == r101.gender) goto L12;
        return false;
    L12:
        if (this.isVerified == r101.isVerified) goto L15;
        return false;
    L15:
        if (this.allowStatus == r101.allowStatus) goto L18;
        return false;
    L18:
        if (this.followStatus == r101.followStatus) goto L21;
        return false;
    L21:
        if (this.awemeCount == r101.awemeCount) goto L24;
        return false;
    L24:
        if (this.followingCount == r101.followingCount) goto L27;
        return false;
    L27:
        if (this.followerCount == r101.followerCount) goto L30;
        return false;
    L30:
        if (this.totalFavorited == r101.totalFavorited) goto L33;
        return false;
    L33:
        if (this.favoritingCount == r101.favoritingCount) goto L36;
        return false;
    L36:
        if (this.registerStatus == r101.registerStatus) goto L39;
        return false;
    L39:
        if (this.hideSearch == r101.hideSearch) goto L41;
        return false;
    L41:
        r101.getClass();
        if (this.constellation == r101.constellation) goto L45;
        return false;
    L45:
        if (this.needRecommend == r101.needRecommend) goto L48;
        return false;
    L48:
        if (this.hideCity == r101.hideCity) goto L50;
        return false;
    L50:
        String r102 = this.nickname;
        if (r102 == null) goto L56;
        if (Intrinsics.areEqual(r102, r101.nickname) == false) goto L57;
    L58:
        boolean r103 = false;
    L59:
        if (r103 == false) goto L61;
        return false;
    L61:
        String r104 = this.signature;
        if (r104 == null) goto L67;
        if (Intrinsics.areEqual(r104, r101.signature) == false) goto L68;
    L69:
        boolean r105 = false;
    L70:
        if (r105 == false) goto L73;
        return false;
    L73:
        if (this.userAge == r101.userAge) goto L75;
        return false;
    L75:
        t14.a r106 = this.avatarLarger;
        if (r106 == null) goto L81;
        if (Intrinsics.areEqual(r106, r101.avatarLarger) == false) goto L82;
    L83:
        boolean r107 = false;
    L84:
        if (r107 == false) goto L86;
        return false;
    L86:
        t14.a r108 = this.avatarThumb;
        if (r108 == null) goto L92;
        if (Intrinsics.areEqual(r108, r101.avatarThumb) == false) goto L93;
    L94:
        boolean r109 = false;
    L95:
        if (r109 == false) goto L97;
        return false;
    L97:
        t14.a r110 = this.avatarMedium;
        if (r110 == null) goto L103;
        if (Intrinsics.areEqual(r110, r101.avatarMedium) == false) goto L104;
    L105:
        boolean r111 = false;
    L106:
        if (r111 == false) goto L108;
        return false;
    L108:
        String r112 = this.thirdName;
        if (r112 == null) goto L114;
        if (Intrinsics.areEqual(r112, r101.thirdName) == false) goto L115;
    L116:
        boolean r113 = false;
    L117:
        if (r113 == false) goto L119;
        return false;
    L119:
        String r114 = this.city;
        if (r114 == null) goto L125;
        if (Intrinsics.areEqual(r114, r101.city) == false) goto L126;
    L127:
        boolean r115 = false;
    L128:
        if (r115 == false) goto L130;
        return false;
    L130:
        String r116 = this.weiboVerify;
        if (r116 == null) goto L136;
        if (Intrinsics.areEqual(r116, r101.weiboVerify) == false) goto L137;
    L138:
        boolean r117 = false;
    L139:
        if (r117 == false) goto L141;
        return false;
    L141:
        String r118 = this.customVerify;
        if (r118 == null) goto L147;
        if (Intrinsics.areEqual(r118, r101.customVerify) == false) goto L148;
    L149:
        boolean r119 = false;
    L150:
        if (r119 == false) goto L153;
        return false;
    L153:
        if (this.createTime == r101.createTime) goto L155;
        boolean r120 = true;
    L156:
        if (r120 == false) goto L159;
        return false;
    L159:
        if (this.starUseNewDownload == r101.starUseNewDownload) goto L161;
        return false;
    L161:
        String r121 = this.bindPhone;
        String r122 = r101.bindPhone;
        if (r121 != null) goto L168;
        if (r122 == null) goto L169;
        return false;
    L169:
        return true;
    L168:
        return Intrinsics.areEqual(r121, r122);
    L155:
        r120 = false;
    L148:
        r119 = true;
        goto L150
    L147:
        if (r101.customVerify == null) goto L149;
    L137:
        r117 = true;
        goto L139
    L136:
        if (r101.weiboVerify == null) goto L138;
    L126:
        r115 = true;
        goto L128
    L125:
        if (r101.city == null) goto L127;
    L115:
        r113 = true;
        goto L117
    L114:
        if (r101.thirdName == null) goto L116;
    L104:
        r111 = true;
        goto L106
    L103:
        if (r101.avatarMedium == null) goto L105;
    L93:
        r109 = true;
        goto L95
    L92:
        if (r101.avatarThumb == null) goto L94;
    L82:
        r107 = true;
        goto L84
    L81:
        if (r101.avatarLarger == null) goto L83;
    L68:
        r105 = true;
        goto L70
    L67:
        if (r101.signature == null) goto L69;
    L57:
        r103 = true;
        goto L59
    L56:
        if (r101.nickname == null) goto L58;
        goto L57
    }
}
