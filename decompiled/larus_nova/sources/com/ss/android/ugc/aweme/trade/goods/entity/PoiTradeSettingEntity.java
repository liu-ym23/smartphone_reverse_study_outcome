package com.ss.android.ugc.aweme.trade.goods.entity;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.tencent.qqmusic.third.api.contract.Keys;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b'\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R$\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R$\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\u0007R\u001c\u0010%\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0018R\u001c\u0010'\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010 \u001a\u0004\b(\u0010\"R\u001c\u0010)\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010 \u001a\u0004\b*\u0010\"R\u001c\u0010+\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\u0016\u001a\u0004\b,\u0010\u0018R\u001c\u0010-\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\u0016\u001a\u0004\b.\u0010\u0018R\u001c\u0010/\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010\u0016\u001a\u0004\b0\u0010\u0018R\u001c\u00101\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010 \u001a\u0004\b2\u0010\"R\u001c\u00103\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010 \u001a\u0004\b\u0011\u0010\"R\u001c\u00104\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010\u0016\u001a\u0004\b5\u0010\u0018R$\u00106\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010\f\u001a\u0004\b7\u0010\u000eR$\u00108\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010\f\u001a\u0004\b9\u0010\u000eR\u001c\u0010:\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010\u0016\u001a\u0004\b;\u0010\u0018R0\u0010=\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030<\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010\f\u001a\u0004\b>\u0010\u000eR\u001c\u0010?\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b?\u0010\u0016\u001a\u0004\b@\u0010\u0018R\u001c\u0010A\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010\u0016\u001a\u0004\bB\u0010\u0018R$\u0010C\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010\f\u001a\u0004\bD\u0010\u000eR\u001c\u0010E\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR$\u0010I\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bI\u0010\u0005\u001a\u0004\bJ\u0010\u0007R$\u0010K\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bK\u0010\u0005\u001a\u0004\bL\u0010\u0007R$\u0010M\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bM\u0010\u0005\u001a\u0004\bN\u0010\u0007R\u001c\u0010P\u001a\u0004\u0018\u00010O8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u001c\u0010T\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bT\u0010 \u001a\u0004\bU\u0010\"R\u001c\u0010V\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bV\u0010 \u001a\u0004\bW\u0010\"R\u001c\u0010X\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bX\u0010 \u001a\u0004\bY\u0010\"R\u001c\u0010Z\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bZ\u0010 \u001a\u0004\b[\u0010\"R\u001c\u0010\\\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\\\u0010\u0016\u001a\u0004\b]\u0010\u0018R$\u0010^\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b^\u0010\u0005\u001a\u0004\b_\u0010\u0007R\u001c\u0010`\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b`\u0010\u0016\u001a\u0004\ba\u0010\u0018R\u001c\u0010b\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bb\u0010 \u001a\u0004\bc\u0010\"R\u001c\u0010d\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bd\u0010 \u001a\u0004\be\u0010\"R\u001c\u0010f\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bf\u0010 \u001a\u0004\bg\u0010\"R\u001c\u0010h\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bh\u0010 \u001a\u0004\bi\u0010\"R\u001c\u0010j\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\bj\u0010\u0016\u001a\u0004\bk\u0010\u0018R$\u0010m\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010l\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bo\u0010pR\u001c\u0010q\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\bq\u0010\u0016\u001a\u0004\br\u0010\u0018R\u001c\u0010t\u001a\u0004\u0018\u00010s8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bt\u0010u\u001a\u0004\bv\u0010wR\u001c\u0010x\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bx\u0010 \u001a\u0004\by\u0010\"R\u001c\u0010z\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\bz\u0010F\u001a\u0004\b{\u0010HR\u001c\u0010|\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b|\u0010 \u001a\u0004\b}\u0010\"R\u001c\u0010~\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b~\u0010 \u001a\u0004\b\u007f\u0010\"R7\u0010\u0080\u0001\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n\u0018\u00010<8\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0084\u0001\u0010 \u001a\u0005\b\u0085\u0001\u0010\"R'\u0010\u0086\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0086\u0001\u0010\f\u001a\u0005\b\u0087\u0001\u0010\u000eR\u001f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0088\u0001\u0010 \u001a\u0005\b\u0089\u0001\u0010\"R\u001f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u008a\u0001\u0010 \u001a\u0005\b\u008b\u0001\u0010\"R\u001f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u008c\u0001\u0010F\u001a\u0005\b\u008d\u0001\u0010HR\u001f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u008e\u0001\u0010 \u001a\u0005\b\u008f\u0001\u0010\"R\u001f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0090\u0001\u0010 \u001a\u0005\b\u0091\u0001\u0010\"R\u001f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0092\u0001\u0010\u0016\u001a\u0005\b\u0093\u0001\u0010\u0018R'\u0010\u0094\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0094\u0001\u0010\f\u001a\u0005\b\u0095\u0001\u0010\u000eR\u001f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0096\u0001\u0010F\u001a\u0005\b\u0097\u0001\u0010HR\u001f\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0098\u0001\u0010\u0016\u001a\u0005\b\u0099\u0001\u0010\u0018R\u001f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u009a\u0001\u0010\u0016\u001a\u0005\b\u009b\u0001\u0010\u0018R\u001f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u009c\u0001\u0010\u0016\u001a\u0005\b\u009d\u0001\u0010\u0018R\u001f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u009e\u0001\u0010\u0016\u001a\u0005\b\u009f\u0001\u0010\u0018R\u001f\u0010 \u0001\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b \u0001\u0010\u0016\u001a\u0005\b¡\u0001\u0010\u0018R\u001f\u0010¢\u0001\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¢\u0001\u0010\u0016\u001a\u0005\b£\u0001\u0010\u0018R\"\u0010¥\u0001\u001a\u0005\u0018\u00010¤\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b¥\u0001\u0010¦\u0001\u001a\u0006\b§\u0001\u0010¨\u0001R\u001f\u0010©\u0001\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b©\u0001\u0010\u0016\u001a\u0005\bª\u0001\u0010\u0018R\u001f\u0010«\u0001\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b«\u0001\u0010\u0016\u001a\u0005\b¬\u0001\u0010\u0018R\"\u0010®\u0001\u001a\u0005\u0018\u00010\u00ad\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b®\u0001\u0010¯\u0001\u001a\u0006\b°\u0001\u0010±\u0001R\u001f\u0010²\u0001\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b²\u0001\u0010 \u001a\u0005\b³\u0001\u0010\"R\u001f\u0010´\u0001\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b´\u0001\u0010 \u001a\u0005\bµ\u0001\u0010\"R\u001f\u0010¶\u0001\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¶\u0001\u0010\u0016\u001a\u0005\b·\u0001\u0010\u0018R\u001f\u0010¸\u0001\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¸\u0001\u0010\u0016\u001a\u0005\b¹\u0001\u0010\u0018R\u001f\u0010»\u0001\u001a\u00030º\u00018\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b»\u0001\u0010e\u001a\u0006\b¼\u0001\u0010½\u0001R%\u0010¾\u0001\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¾\u0001\u0010\f\u001a\u0005\b¿\u0001\u0010\u000e¨\u0006À\u0001"}, d2 = {"Lcom/ss/android/ugc/aweme/trade/goods/entity/PoiTradeSettingEntity;", "", "", "", "goodsDetailPrefetchLynxSchemas", "[Ljava/lang/String;", "getGoodsDetailPrefetchLynxSchemas", "()[Ljava/lang/String;", "goodsDetailMobParamsBlackKeyList", "K", "", "presetSizeLynxCardBlackList", "Ljava/util/List;", "a0", "()Ljava/util/List;", "", "optimizations", "I", "U", "()I", "", "enableSlideToFullScreenWhenLoading", "Ljava/lang/Boolean;", "r", "()Ljava/lang/Boolean;", "enableInterceptTouchEventWhenSlideDown", "o", "goodsDetailDownloadInLaunch", "getGoodsDetailDownloadInLaunch", "goodsDetailLoadToMemInLaunch", "getGoodsDetailLoadToMemInLaunch", "foodCacheValidDurationInSeconds", "Ljava/lang/Integer;", "u", "()Ljava/lang/Integer;", "foodCacheKeyList", "s", "disableMobConflictDetect", "getDisableMobConflictDetect", "numberOfPriorityLoads", ExifInterface.GPS_DIRECTION_TRUE, "preCreateSize", ExifInterface.LONGITUDE_WEST, "disableApmReport", "f", "useLynxDisasterRecovery", "n0", "routerCostEnable", "d0", "goodsDetailLoadingTimeoutDurationInMillions", "J", "goodsDetailLoadingDelayInMillions", "disableFullPageWhenFixHeight", ce.f26391f, "requestParamInRouter", "c0", "h5RequestParamsInRouter", "O", "enableProjectDetailShowCheckParams", "p", "", "cacheBlockRulesList", "c", "mobShowInNative", "R", "needReportPreloadVerifyEvent", "getNeedReportPreloadVerifyEvent", "goodsDetailSwitchGoodsUpdateCards", "N", "goodsDetailErroView", "Ljava/lang/String;", FaceService.neutralLabel, "()Ljava/lang/String;", "goodsDetailPreloadLynxSchemas", "L", "foodV1PreloadSchemaList", BaseSwitches.V, "foodV2PreloadSchemaList", "w", "Lcom/ss/android/ugc/aweme/trade/goods/entity/DeliverGoodsDetailPreloadStrategy;", "deliverGoodsDetailPreloadStrategy", "Lcom/ss/android/ugc/aweme/trade/goods/entity/DeliverGoodsDetailPreloadStrategy;", "e", "()Lcom/ss/android/ugc/aweme/trade/goods/entity/DeliverGoodsDetailPreloadStrategy;", "userNestedRecyclerView", "getUserNestedRecyclerView", "validFooterHeightThreshold", "p0", "enableResetListPadding", "q", "useLinearLayoutManager", Keys.API_PARAM_KEY_M0, "renderCacheEnable", "b0", "foodCacheNodeWhiteList", "t", "preCacheEnable", "V", "useConsumePendingUpdateOperations", "k0", "getItemViewCacheSize", FaceService.girlLabel, "useLynxGapHandlingNone", "o0", "shouldRefreshData", "f0", "nativeCheckAgreementDisable", ExifInterface.LATITUDE_SOUTH, "Lcom/ss/android/ugc/aweme/trade/goods/entity/PreRequestProtocol;", "getPreRequestProtocol", "[Lcom/ss/android/ugc/aweme/trade/goods/entity/PreRequestProtocol;", "G", "()[Lcom/ss/android/ugc/aweme/trade/goods/entity/PreRequestProtocol;", "preRequestProtocolUseTypedOutput", "Y", "Lcom/ss/android/ugc/aweme/trade/goods/entity/GoodsDetailPreloadStrategy;", "goodsDetailPreloadStrategy", "Lcom/ss/android/ugc/aweme/trade/goods/entity/GoodsDetailPreloadStrategy;", "M", "()Lcom/ss/android/ugc/aweme/trade/goods/entity/GoodsDetailPreloadStrategy;", "useDoubleCheckForNestedScroller", "l0", "agreeLynxPopupView", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "trackerEffectiveGoodsDetail", "j0", "setOnePxHeight", "e0", "misTrackKeysChecker", "Ljava/util/Map;", "Q", "()Ljava/util/Map;", "enableGoodsDetailGeckoExemptionExpt", OfficeSDKRequestTag.KEY_NEW_USER, "urlsReplaceMatches", "getUrlsReplaceMatches", "showSkeletonView", "h0", "showNativeSkeletonView", "g0", "skeletonViewUrl", "i0", "lynxRenderFinishSkeleton", "P", "enableGoodsDetailDitoPageCache", "m", "cubeParserUrlParams", "d", "preloadNativeItemKey", "Z", "preRequestPath", "X", "forceShutDownSwitchLayout", "x", "disableGoodsDetailBtmParams", RXScreenCaptureService.KEY_INDEX, "disableGdErrorMonitorOpt", "h", "disableOneConfirmNativeAbility", ce.f26395j, "disableScrollMethodCompatible", ce.f26396k, "enableCloseBtnBackOpt", "l", "Lcom/ss/android/ugc/aweme/trade/goods/entity/GoodsDetailParamsValidatorStrategy;", "gdParamsValidatorStrategy", "Lcom/ss/android/ugc/aweme/trade/goods/entity/GoodsDetailParamsValidatorStrategy;", "D", "()Lcom/ss/android/ugc/aweme/trade/goods/entity/GoodsDetailParamsValidatorStrategy;", "gdRoomInfoOpt", ExifInterface.LONGITUDE_EAST, "gdEnableHalfScreenEmptyClickInterrupt", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/ss/android/ugc/aweme/trade/goods/entity/GoodsDetailLynxTimingReportConfig;", "gdLynxTimingReportConfig", "Lcom/ss/android/ugc/aweme/trade/goods/entity/GoodsDetailLynxTimingReportConfig;", "B", "()Lcom/ss/android/ugc/aweme/trade/goods/entity/GoodsDetailLynxTimingReportConfig;", "gdCJCacheDataValidTime", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "gdApiRequestPriority", "getGdApiRequestPriority", "aheadLoadGlobalPropsOptSwitch", "b", "gdAddLocationParams", "y", "", "globalReachSwitchRate", "getGlobalReachSwitchRate", "()F", "gdOfflineRenderBundlesArr", "C", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class PoiTradeSettingEntity {

    @SerializedName("agree_lynx_popup_view")
    private final String agreeLynxPopupView;

    @SerializedName("ahead_load_global_props_opt_switch")
    private final Boolean aheadLoadGlobalPropsOptSwitch;

    @SerializedName("gd_render_cache_black_filter_rule_android")
    private final List<Map<String, String>> cacheBlockRulesList;

    @SerializedName("cube_parser_url_params")
    private final Boolean cubeParserUrlParams;

    @SerializedName("delivery_lynx_preload")
    private final DeliverGoodsDetailPreloadStrategy deliverGoodsDetailPreloadStrategy;

    @SerializedName("trade_slardar_monitor_close")
    private final Boolean disableApmReport;

    @SerializedName("disable_full_page_when_fix_height")
    private final Boolean disableFullPageWhenFixHeight;

    @SerializedName("disable_gd_error_monitor_opt")
    private final Boolean disableGdErrorMonitorOpt;

    @SerializedName("disable_goods_detail_btm_params")
    private final Boolean disableGoodsDetailBtmParams;

    @SerializedName("gd_disable_mob_conflict_detect_food")
    private final Boolean disableMobConflictDetect;

    @SerializedName("disable_one_confirm_native_ability")
    private final Boolean disableOneConfirmNativeAbility;

    @SerializedName("disable_scroll_method_compatible")
    private final Boolean disableScrollMethodCompatible;

    @SerializedName("enable_close_btn_back_opt")
    private final Boolean enableCloseBtnBackOpt;

    @SerializedName("enable_goods_detail_dito_page_cache")
    private final Integer enableGoodsDetailDitoPageCache;

    @SerializedName("enable_goods_detail_gecko_exemption_expt")
    private final Integer enableGoodsDetailGeckoExemptionExpt;

    @SerializedName("gd_enable_intercept_touch_event_when_slide_down")
    private final Boolean enableInterceptTouchEventWhenSlideDown;

    @SerializedName("gd_project_detail_show_check_params")
    private final Boolean enableProjectDetailShowCheckParams;

    @SerializedName("enable_reset_list_padding")
    private final Integer enableResetListPadding;

    @SerializedName("gd_enable_slide_to_fullscreen_when_loading")
    private final Boolean enableSlideToFullScreenWhenLoading;

    @SerializedName("gd_render_cache_router_keys_food_android")
    private final String[] foodCacheKeyList;

    @SerializedName("gd_render_cache_allow_components_food_android")
    private final String[] foodCacheNodeWhiteList;

    @SerializedName("gd_render_cache_valid_time_food_android")
    private final Integer foodCacheValidDurationInSeconds;

    @SerializedName("goods_detail_food_v1_preload_lynx_schemas")
    private final String[] foodV1PreloadSchemaList;

    @SerializedName("goods_detail_food_v2_preload_lynx_schemas")
    private final String[] foodV2PreloadSchemaList;

    @SerializedName("goods_force_shut_down_switch_layout")
    private final Boolean forceShutDownSwitchLayout;

    @SerializedName("gd_add_location_params")
    private final Boolean gdAddLocationParams;

    @SerializedName("gd_api_request_priority")
    private final Integer gdApiRequestPriority;

    @SerializedName("gd_cj_cache_data_valid_time")
    private final Integer gdCJCacheDataValidTime;

    @SerializedName("gd_enable_half_screen_empty_click_interrupt")
    private final Boolean gdEnableHalfScreenEmptyClickInterrupt;

    @SerializedName("gd_lynx_timing_report_config")
    private final GoodsDetailLynxTimingReportConfig gdLynxTimingReportConfig;

    @SerializedName("gd_offline_render_bundles_arr")
    private final List<String> gdOfflineRenderBundlesArr;

    @SerializedName("gd_params_validator_strategy")
    private final GoodsDetailParamsValidatorStrategy gdParamsValidatorStrategy;

    @SerializedName("gd_room_info_opt")
    private final Boolean gdRoomInfoOpt;

    @SerializedName("get_item_view_cache_size")
    private final Integer getItemViewCacheSize;

    @SerializedName("goods_detail_pre_request")
    private final PreRequestProtocol[] getPreRequestProtocol;

    @SerializedName("global_reach_switch_rate")
    private final float globalReachSwitchRate;

    @SerializedName("gd_gecko_download_in_launch")
    private final Boolean goodsDetailDownloadInLaunch;

    @SerializedName("goods_detail_error_view")
    private final String goodsDetailErroView;

    @SerializedName("gd_gecko_load_to_mem_in_launch")
    private final Boolean goodsDetailLoadToMemInLaunch;

    @SerializedName("goods_detail_loading_delay_in_millions")
    private final Integer goodsDetailLoadingDelayInMillions;

    @SerializedName("goods_detail_loading_timeout_duration_in_millions")
    private final Integer goodsDetailLoadingTimeoutDurationInMillions;

    @SerializedName("gd_mob_params_session_black_key_list")
    private final String[] goodsDetailMobParamsBlackKeyList;

    @SerializedName("goods_detail_prefetch_lynx_schemas")
    private final String[] goodsDetailPrefetchLynxSchemas;

    @SerializedName("goods_detail_preload_lynx_schemas")
    private final String[] goodsDetailPreloadLynxSchemas;

    @SerializedName("goods_detail_preload_strategy")
    private final GoodsDetailPreloadStrategy goodsDetailPreloadStrategy;

    @SerializedName("goods_detail_switch_goods_update_cards")
    private final List<String> goodsDetailSwitchGoodsUpdateCards;

    @SerializedName("h5_downgrade_params_in_router")
    private final List<String> h5RequestParamsInRouter;

    @SerializedName("goods_detail_skeleton_lynx_render_finish")
    private final Integer lynxRenderFinishSkeleton;

    @SerializedName("mis_track_keys_checker")
    private final Map<String, List<String>> misTrackKeysChecker;

    @SerializedName("tracker_in_native")
    private final Boolean mobShowInNative;

    @SerializedName("native_check_agreement_disable")
    private final Boolean nativeCheckAgreementDisable;

    @SerializedName("goods_detail_preload_verify_event_report")
    private final Boolean needReportPreloadVerifyEvent;

    @SerializedName("number_of_priority_loads")
    private final Integer numberOfPriorityLoads;

    @SerializedName("optimizations")
    private final int optimizations;

    @SerializedName("gd_render_cache_pre_request_food_android")
    private final Boolean preCacheEnable;

    @SerializedName("pre_create_size")
    private final Integer preCreateSize;

    @SerializedName("gd_pre_request_path")
    private final String preRequestPath;

    @SerializedName("goods_detail_pre_request_use_typed_output")
    private final Boolean preRequestProtocolUseTypedOutput;

    @SerializedName("preload_native_item_key")
    private final List<String> preloadNativeItemKey;

    @SerializedName("preset_size_lynx_card_black_list")
    private final List<String> presetSizeLynxCardBlackList;

    @SerializedName("gd_render_cache_food_android")
    private final Boolean renderCacheEnable;

    @SerializedName("request_params_in_router")
    private final List<String> requestParamInRouter;

    @SerializedName("router_cost_enbale")
    private final Boolean routerCostEnable;

    @SerializedName("goods_detail_lynx_view_set_one_px_height")
    private final Integer setOnePxHeight;

    @SerializedName("should_refresh_data")
    private final Integer shouldRefreshData;

    @SerializedName("goods_detail_native_skeleton_open_android")
    private final Integer showNativeSkeletonView;

    @SerializedName("goods_detail_skeleton_open_android")
    private final Integer showSkeletonView;

    @SerializedName("goods_detail_skeleton_url")
    private final String skeletonViewUrl;

    @SerializedName("tracker_effective_goods_detail")
    private final Integer trackerEffectiveGoodsDetail;

    @SerializedName("goods_native_url_replace_matches")
    private final List<String> urlsReplaceMatches;

    @SerializedName("use_consume_pending_update_operation")
    private final Integer useConsumePendingUpdateOperations;

    @SerializedName("use_double_check_for_nested_scroller")
    private final Integer useDoubleCheckForNestedScroller;

    @SerializedName("use_linear_layout_manager")
    private final Integer useLinearLayoutManager;

    @SerializedName("use_lynx_page_for_goods_detail_disaster_recovery")
    private final Boolean useLynxDisasterRecovery;

    @SerializedName("use_lynx_gap_handling_none")
    private final Integer useLynxGapHandlingNone;

    @SerializedName("use_nested_recycler_view")
    private final Integer userNestedRecyclerView;

    @SerializedName("valid_footer_height_threshold")
    private final Integer validFooterHeightThreshold;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiTradeSettingEntity) == true) goto L8;
        return false;
    L8:
        PoiTradeSettingEntity r101 = (PoiTradeSettingEntity) r100;
        if (Intrinsics.areEqual(this.goodsDetailPrefetchLynxSchemas, r101.goodsDetailPrefetchLynxSchemas) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.goodsDetailMobParamsBlackKeyList, r101.goodsDetailMobParamsBlackKeyList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.presetSizeLynxCardBlackList, r101.presetSizeLynxCardBlackList) == true) goto L18;
        return false;
    L18:
        if (this.optimizations == r101.optimizations) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.enableSlideToFullScreenWhenLoading, r101.enableSlideToFullScreenWhenLoading) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.enableInterceptTouchEventWhenSlideDown, r101.enableInterceptTouchEventWhenSlideDown) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.goodsDetailDownloadInLaunch, r101.goodsDetailDownloadInLaunch) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.goodsDetailLoadToMemInLaunch, r101.goodsDetailLoadToMemInLaunch) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.foodCacheValidDurationInSeconds, r101.foodCacheValidDurationInSeconds) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.foodCacheKeyList, r101.foodCacheKeyList) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.disableMobConflictDetect, r101.disableMobConflictDetect) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.numberOfPriorityLoads, r101.numberOfPriorityLoads) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.preCreateSize, r101.preCreateSize) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.disableApmReport, r101.disableApmReport) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.useLynxDisasterRecovery, r101.useLynxDisasterRecovery) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.routerCostEnable, r101.routerCostEnable) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.goodsDetailLoadingTimeoutDurationInMillions, r101.goodsDetailLoadingTimeoutDurationInMillions) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.goodsDetailLoadingDelayInMillions, r101.goodsDetailLoadingDelayInMillions) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.disableFullPageWhenFixHeight, r101.disableFullPageWhenFixHeight) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.requestParamInRouter, r101.requestParamInRouter) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.h5RequestParamsInRouter, r101.h5RequestParamsInRouter) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.enableProjectDetailShowCheckParams, r101.enableProjectDetailShowCheckParams) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.cacheBlockRulesList, r101.cacheBlockRulesList) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.mobShowInNative, r101.mobShowInNative) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.needReportPreloadVerifyEvent, r101.needReportPreloadVerifyEvent) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.goodsDetailSwitchGoodsUpdateCards, r101.goodsDetailSwitchGoodsUpdateCards) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.goodsDetailErroView, r101.goodsDetailErroView) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.goodsDetailPreloadLynxSchemas, r101.goodsDetailPreloadLynxSchemas) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.foodV1PreloadSchemaList, r101.foodV1PreloadSchemaList) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.foodV2PreloadSchemaList, r101.foodV2PreloadSchemaList) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.deliverGoodsDetailPreloadStrategy, r101.deliverGoodsDetailPreloadStrategy) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.userNestedRecyclerView, r101.userNestedRecyclerView) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.validFooterHeightThreshold, r101.validFooterHeightThreshold) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.enableResetListPadding, r101.enableResetListPadding) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.useLinearLayoutManager, r101.useLinearLayoutManager) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.renderCacheEnable, r101.renderCacheEnable) == true) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.foodCacheNodeWhiteList, r101.foodCacheNodeWhiteList) == true) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.preCacheEnable, r101.preCacheEnable) == true) goto L123;
        return false;
    L123:
        if (Intrinsics.areEqual(this.useConsumePendingUpdateOperations, r101.useConsumePendingUpdateOperations) == true) goto L126;
        return false;
    L126:
        if (Intrinsics.areEqual(this.getItemViewCacheSize, r101.getItemViewCacheSize) == true) goto L129;
        return false;
    L129:
        if (Intrinsics.areEqual(this.useLynxGapHandlingNone, r101.useLynxGapHandlingNone) == true) goto L132;
        return false;
    L132:
        if (Intrinsics.areEqual(this.shouldRefreshData, r101.shouldRefreshData) == true) goto L135;
        return false;
    L135:
        if (Intrinsics.areEqual(this.nativeCheckAgreementDisable, r101.nativeCheckAgreementDisable) == true) goto L138;
        return false;
    L138:
        if (Intrinsics.areEqual(this.getPreRequestProtocol, r101.getPreRequestProtocol) == true) goto L141;
        return false;
    L141:
        if (Intrinsics.areEqual(this.preRequestProtocolUseTypedOutput, r101.preRequestProtocolUseTypedOutput) == true) goto L144;
        return false;
    L144:
        if (Intrinsics.areEqual(this.goodsDetailPreloadStrategy, r101.goodsDetailPreloadStrategy) == true) goto L147;
        return false;
    L147:
        if (Intrinsics.areEqual(this.useDoubleCheckForNestedScroller, r101.useDoubleCheckForNestedScroller) == true) goto L150;
        return false;
    L150:
        if (Intrinsics.areEqual(this.agreeLynxPopupView, r101.agreeLynxPopupView) == true) goto L153;
        return false;
    L153:
        if (Intrinsics.areEqual(this.trackerEffectiveGoodsDetail, r101.trackerEffectiveGoodsDetail) == true) goto L156;
        return false;
    L156:
        if (Intrinsics.areEqual(this.setOnePxHeight, r101.setOnePxHeight) == true) goto L159;
        return false;
    L159:
        if (Intrinsics.areEqual(this.misTrackKeysChecker, r101.misTrackKeysChecker) == true) goto L162;
        return false;
    L162:
        if (Intrinsics.areEqual(this.enableGoodsDetailGeckoExemptionExpt, r101.enableGoodsDetailGeckoExemptionExpt) == true) goto L165;
        return false;
    L165:
        if (Intrinsics.areEqual(this.urlsReplaceMatches, r101.urlsReplaceMatches) == true) goto L168;
        return false;
    L168:
        if (Intrinsics.areEqual(this.showSkeletonView, r101.showSkeletonView) == true) goto L171;
        return false;
    L171:
        if (Intrinsics.areEqual(this.showNativeSkeletonView, r101.showNativeSkeletonView) == true) goto L174;
        return false;
    L174:
        if (Intrinsics.areEqual(this.skeletonViewUrl, r101.skeletonViewUrl) == true) goto L177;
        return false;
    L177:
        if (Intrinsics.areEqual(this.lynxRenderFinishSkeleton, r101.lynxRenderFinishSkeleton) == true) goto L180;
        return false;
    L180:
        if (Intrinsics.areEqual(this.enableGoodsDetailDitoPageCache, r101.enableGoodsDetailDitoPageCache) == true) goto L183;
        return false;
    L183:
        if (Intrinsics.areEqual(this.cubeParserUrlParams, r101.cubeParserUrlParams) == true) goto L186;
        return false;
    L186:
        if (Intrinsics.areEqual(this.preloadNativeItemKey, r101.preloadNativeItemKey) == true) goto L189;
        return false;
    L189:
        if (Intrinsics.areEqual(this.preRequestPath, r101.preRequestPath) == true) goto L192;
        return false;
    L192:
        if (Intrinsics.areEqual(this.forceShutDownSwitchLayout, r101.forceShutDownSwitchLayout) == true) goto L195;
        return false;
    L195:
        if (Intrinsics.areEqual(this.disableGoodsDetailBtmParams, r101.disableGoodsDetailBtmParams) == true) goto L198;
        return false;
    L198:
        if (Intrinsics.areEqual(this.disableGdErrorMonitorOpt, r101.disableGdErrorMonitorOpt) == true) goto L201;
        return false;
    L201:
        if (Intrinsics.areEqual(this.disableOneConfirmNativeAbility, r101.disableOneConfirmNativeAbility) == true) goto L204;
        return false;
    L204:
        if (Intrinsics.areEqual(this.disableScrollMethodCompatible, r101.disableScrollMethodCompatible) == true) goto L207;
        return false;
    L207:
        if (Intrinsics.areEqual(this.enableCloseBtnBackOpt, r101.enableCloseBtnBackOpt) == true) goto L210;
        return false;
    L210:
        if (Intrinsics.areEqual(this.gdParamsValidatorStrategy, r101.gdParamsValidatorStrategy) == true) goto L213;
        return false;
    L213:
        if (Intrinsics.areEqual(this.gdRoomInfoOpt, r101.gdRoomInfoOpt) == true) goto L216;
        return false;
    L216:
        if (Intrinsics.areEqual(this.gdEnableHalfScreenEmptyClickInterrupt, r101.gdEnableHalfScreenEmptyClickInterrupt) == true) goto L219;
        return false;
    L219:
        if (Intrinsics.areEqual(this.gdLynxTimingReportConfig, r101.gdLynxTimingReportConfig) == true) goto L222;
        return false;
    L222:
        if (Intrinsics.areEqual(this.gdCJCacheDataValidTime, r101.gdCJCacheDataValidTime) == true) goto L225;
        return false;
    L225:
        if (Intrinsics.areEqual(this.gdApiRequestPriority, r101.gdApiRequestPriority) == true) goto L228;
        return false;
    L228:
        if (Intrinsics.areEqual(this.aheadLoadGlobalPropsOptSwitch, r101.aheadLoadGlobalPropsOptSwitch) == true) goto L231;
        return false;
    L231:
        if (Intrinsics.areEqual(this.gdAddLocationParams, r101.gdAddLocationParams) == true) goto L234;
        return false;
    L234:
        if (Float.compare(this.globalReachSwitchRate, r101.globalReachSwitchRate) == 0) goto L237;
        return false;
    L237:
        if (Intrinsics.areEqual(this.gdOfflineRenderBundlesArr, r101.gdOfflineRenderBundlesArr) == true) goto L239;
        return false;
    L239:
        return true;
    }

    public final int hashCode() {
        String[] r100 = this.goodsDetailPrefetchLynxSchemas;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String[] r104 = this.goodsDetailMobParamsBlackKeyList;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.presetSizeLynxCardBlackList;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.optimizations) * 31;
        Boolean r110 = this.enableSlideToFullScreenWhenLoading;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.enableInterceptTouchEventWhenSlideDown;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.goodsDetailDownloadInLaunch;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.goodsDetailLoadToMemInLaunch;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.foodCacheValidDurationInSeconds;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String[] r125 = this.foodCacheKeyList;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.disableMobConflictDetect;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.numberOfPriorityLoads;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.preCreateSize;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Boolean r137 = this.disableApmReport;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        Boolean r140 = this.useLynxDisasterRecovery;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        Boolean r143 = this.routerCostEnable;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        Integer r146 = this.goodsDetailLoadingTimeoutDurationInMillions;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        Integer r149 = this.goodsDetailLoadingDelayInMillions;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        Boolean r152 = this.disableFullPageWhenFixHeight;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        List<String> r155 = this.requestParamInRouter;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        List<String> r158 = this.h5RequestParamsInRouter;
        if (r158 != null) goto L81;
        int r159 = 0;
    L82:
        int r160 = (r157 + r159) * 31;
        Boolean r161 = this.enableProjectDetailShowCheckParams;
        if (r161 != null) goto L85;
        int r162 = 0;
    L86:
        int r163 = (r160 + r162) * 31;
        List<Map<String, String>> r164 = this.cacheBlockRulesList;
        if (r164 != null) goto L89;
        int r165 = 0;
    L90:
        int r166 = (r163 + r165) * 31;
        Boolean r167 = this.mobShowInNative;
        if (r167 != null) goto L93;
        int r168 = 0;
    L94:
        int r169 = (r166 + r168) * 31;
        Boolean r170 = this.needReportPreloadVerifyEvent;
        if (r170 != null) goto L97;
        int r171 = 0;
    L98:
        int r172 = (r169 + r171) * 31;
        List<String> r173 = this.goodsDetailSwitchGoodsUpdateCards;
        if (r173 != null) goto L101;
        int r174 = 0;
    L102:
        int r175 = (r172 + r174) * 31;
        String r176 = this.goodsDetailErroView;
        if (r176 != null) goto L105;
        int r177 = 0;
    L106:
        int r178 = (r175 + r177) * 31;
        String[] r179 = this.goodsDetailPreloadLynxSchemas;
        if (r179 != null) goto L109;
        int r180 = 0;
    L110:
        int r181 = (r178 + r180) * 31;
        String[] r182 = this.foodV1PreloadSchemaList;
        if (r182 != null) goto L113;
        int r183 = 0;
    L114:
        int r184 = (r181 + r183) * 31;
        String[] r185 = this.foodV2PreloadSchemaList;
        if (r185 != null) goto L117;
        int r186 = 0;
    L118:
        int r187 = (r184 + r186) * 31;
        DeliverGoodsDetailPreloadStrategy r188 = this.deliverGoodsDetailPreloadStrategy;
        if (r188 != null) goto L121;
        int r189 = 0;
    L122:
        int r190 = (r187 + r189) * 31;
        Integer r191 = this.userNestedRecyclerView;
        if (r191 != null) goto L125;
        int r192 = 0;
    L126:
        int r193 = (r190 + r192) * 31;
        Integer r194 = this.validFooterHeightThreshold;
        if (r194 != null) goto L129;
        int r195 = 0;
    L130:
        int r196 = (r193 + r195) * 31;
        Integer r197 = this.enableResetListPadding;
        if (r197 != null) goto L133;
        int r198 = 0;
    L134:
        int r199 = (r196 + r198) * 31;
        Integer r200 = this.useLinearLayoutManager;
        if (r200 != null) goto L137;
        int r201 = 0;
    L138:
        int r202 = (r199 + r201) * 31;
        Boolean r203 = this.renderCacheEnable;
        if (r203 != null) goto L141;
        int r204 = 0;
    L142:
        int r205 = (r202 + r204) * 31;
        String[] r206 = this.foodCacheNodeWhiteList;
        if (r206 != null) goto L145;
        int r207 = 0;
    L146:
        int r208 = (r205 + r207) * 31;
        Boolean r209 = this.preCacheEnable;
        if (r209 != null) goto L149;
        int r210 = 0;
    L150:
        int r211 = (r208 + r210) * 31;
        Integer r212 = this.useConsumePendingUpdateOperations;
        if (r212 != null) goto L153;
        int r213 = 0;
    L154:
        int r214 = (r211 + r213) * 31;
        Integer r215 = this.getItemViewCacheSize;
        if (r215 != null) goto L157;
        int r216 = 0;
    L158:
        int r217 = (r214 + r216) * 31;
        Integer r218 = this.useLynxGapHandlingNone;
        if (r218 != null) goto L161;
        int r219 = 0;
    L162:
        int r220 = (r217 + r219) * 31;
        Integer r221 = this.shouldRefreshData;
        if (r221 != null) goto L165;
        int r222 = 0;
    L166:
        int r223 = (r220 + r222) * 31;
        Boolean r224 = this.nativeCheckAgreementDisable;
        if (r224 != null) goto L169;
        int r225 = 0;
    L170:
        int r226 = (r223 + r225) * 31;
        PreRequestProtocol[] r227 = this.getPreRequestProtocol;
        if (r227 != null) goto L173;
        int r228 = 0;
    L174:
        int r229 = (r226 + r228) * 31;
        Boolean r230 = this.preRequestProtocolUseTypedOutput;
        if (r230 != null) goto L177;
        int r231 = 0;
    L178:
        int r232 = (r229 + r231) * 31;
        GoodsDetailPreloadStrategy r233 = this.goodsDetailPreloadStrategy;
        if (r233 != null) goto L181;
        int r234 = 0;
    L182:
        int r235 = (r232 + r234) * 31;
        Integer r236 = this.useDoubleCheckForNestedScroller;
        if (r236 != null) goto L185;
        int r237 = 0;
    L186:
        int r238 = (r235 + r237) * 31;
        String r239 = this.agreeLynxPopupView;
        if (r239 != null) goto L189;
        int r240 = 0;
    L190:
        int r241 = (r238 + r240) * 31;
        Integer r242 = this.trackerEffectiveGoodsDetail;
        if (r242 != null) goto L193;
        int r243 = 0;
    L194:
        int r244 = (r241 + r243) * 31;
        Integer r245 = this.setOnePxHeight;
        if (r245 != null) goto L197;
        int r246 = 0;
    L198:
        int r247 = (r244 + r246) * 31;
        Map<String, List<String>> r248 = this.misTrackKeysChecker;
        if (r248 != null) goto L201;
        int r249 = 0;
    L202:
        int r250 = (r247 + r249) * 31;
        Integer r251 = this.enableGoodsDetailGeckoExemptionExpt;
        if (r251 != null) goto L205;
        int r252 = 0;
    L206:
        int r253 = (r250 + r252) * 31;
        List<String> r254 = this.urlsReplaceMatches;
        if (r254 != null) goto L209;
        int r255 = 0;
    L210:
        int r256 = (r253 + r255) * 31;
        Integer r257 = this.showSkeletonView;
        if (r257 != null) goto L213;
        int r258 = 0;
    L214:
        int r259 = (r256 + r258) * 31;
        Integer r260 = this.showNativeSkeletonView;
        if (r260 != null) goto L217;
        int r261 = 0;
    L218:
        int r262 = (r259 + r261) * 31;
        String r263 = this.skeletonViewUrl;
        if (r263 != null) goto L221;
        int r264 = 0;
    L222:
        int r265 = (r262 + r264) * 31;
        Integer r266 = this.lynxRenderFinishSkeleton;
        if (r266 != null) goto L225;
        int r267 = 0;
    L226:
        int r268 = (r265 + r267) * 31;
        Integer r269 = this.enableGoodsDetailDitoPageCache;
        if (r269 != null) goto L229;
        int r270 = 0;
    L230:
        int r271 = (r268 + r270) * 31;
        Boolean r272 = this.cubeParserUrlParams;
        if (r272 != null) goto L233;
        int r273 = 0;
    L234:
        int r274 = (r271 + r273) * 31;
        List<String> r275 = this.preloadNativeItemKey;
        if (r275 != null) goto L237;
        int r276 = 0;
    L238:
        int r277 = (r274 + r276) * 31;
        String r278 = this.preRequestPath;
        if (r278 != null) goto L241;
        int r279 = 0;
    L242:
        int r280 = (r277 + r279) * 31;
        Boolean r281 = this.forceShutDownSwitchLayout;
        if (r281 != null) goto L245;
        int r282 = 0;
    L246:
        int r283 = (r280 + r282) * 31;
        Boolean r284 = this.disableGoodsDetailBtmParams;
        if (r284 != null) goto L249;
        int r285 = 0;
    L250:
        int r286 = (r283 + r285) * 31;
        Boolean r287 = this.disableGdErrorMonitorOpt;
        if (r287 != null) goto L253;
        int r288 = 0;
    L254:
        int r289 = (r286 + r288) * 31;
        Boolean r290 = this.disableOneConfirmNativeAbility;
        if (r290 != null) goto L257;
        int r291 = 0;
    L258:
        int r292 = (r289 + r291) * 31;
        Boolean r293 = this.disableScrollMethodCompatible;
        if (r293 != null) goto L261;
        int r294 = 0;
    L262:
        int r295 = (r292 + r294) * 31;
        Boolean r296 = this.enableCloseBtnBackOpt;
        if (r296 != null) goto L265;
        int r297 = 0;
    L266:
        int r298 = (r295 + r297) * 31;
        GoodsDetailParamsValidatorStrategy r299 = this.gdParamsValidatorStrategy;
        if (r299 != null) goto L269;
        int r300 = 0;
    L270:
        int r301 = (r298 + r300) * 31;
        Boolean r302 = this.gdRoomInfoOpt;
        if (r302 != null) goto L273;
        int r303 = 0;
    L274:
        int r304 = (r301 + r303) * 31;
        Boolean r305 = this.gdEnableHalfScreenEmptyClickInterrupt;
        if (r305 != null) goto L277;
        int r306 = 0;
    L278:
        int r307 = (r304 + r306) * 31;
        GoodsDetailLynxTimingReportConfig r308 = this.gdLynxTimingReportConfig;
        if (r308 != null) goto L281;
        int r309 = 0;
    L282:
        int r310 = (r307 + r309) * 31;
        Integer r311 = this.gdCJCacheDataValidTime;
        if (r311 != null) goto L285;
        int r312 = 0;
    L286:
        int r313 = (r310 + r312) * 31;
        Integer r314 = this.gdApiRequestPriority;
        if (r314 != null) goto L289;
        int r315 = 0;
    L290:
        int r316 = (r313 + r315) * 31;
        Boolean r317 = this.aheadLoadGlobalPropsOptSwitch;
        if (r317 != null) goto L293;
        int r318 = 0;
    L294:
        int r319 = (r316 + r318) * 31;
        Boolean r320 = this.gdAddLocationParams;
        if (r320 != null) goto L297;
        int r321 = 0;
    L298:
        int r322 = (((r319 + r321) * 31) + Float.floatToIntBits(this.globalReachSwitchRate)) * 31;
        List<String> r323 = this.gdOfflineRenderBundlesArr;
        if (r323 == null) goto L303;
        r101 = r323.hashCode();
    L303:
        return r322 + r101;
    L297:
        r321 = r320.hashCode();
        goto L298
    L293:
        r318 = r317.hashCode();
        goto L294
    L289:
        r315 = r314.hashCode();
        goto L290
    L285:
        r312 = r311.hashCode();
        goto L286
    L281:
        r309 = r308.hashCode();
        goto L282
    L277:
        r306 = r305.hashCode();
        goto L278
    L273:
        r303 = r302.hashCode();
        goto L274
    L269:
        r300 = r299.hashCode();
        goto L270
    L265:
        r297 = r296.hashCode();
        goto L266
    L261:
        r294 = r293.hashCode();
        goto L262
    L257:
        r291 = r290.hashCode();
        goto L258
    L253:
        r288 = r287.hashCode();
        goto L254
    L249:
        r285 = r284.hashCode();
        goto L250
    L245:
        r282 = r281.hashCode();
        goto L246
    L241:
        r279 = r278.hashCode();
        goto L242
    L237:
        r276 = r275.hashCode();
        goto L238
    L233:
        r273 = r272.hashCode();
        goto L234
    L229:
        r270 = r269.hashCode();
        goto L230
    L225:
        r267 = r266.hashCode();
        goto L226
    L221:
        r264 = r263.hashCode();
        goto L222
    L217:
        r261 = r260.hashCode();
        goto L218
    L213:
        r258 = r257.hashCode();
        goto L214
    L209:
        r255 = r254.hashCode();
        goto L210
    L205:
        r252 = r251.hashCode();
        goto L206
    L201:
        r249 = r248.hashCode();
        goto L202
    L197:
        r246 = r245.hashCode();
        goto L198
    L193:
        r243 = r242.hashCode();
        goto L194
    L189:
        r240 = r239.hashCode();
        goto L190
    L185:
        r237 = r236.hashCode();
        goto L186
    L181:
        r234 = r233.hashCode();
        goto L182
    L177:
        r231 = r230.hashCode();
        goto L178
    L173:
        r228 = Arrays.hashCode(r227);
        goto L174
    L169:
        r225 = r224.hashCode();
        goto L170
    L165:
        r222 = r221.hashCode();
        goto L166
    L161:
        r219 = r218.hashCode();
        goto L162
    L157:
        r216 = r215.hashCode();
        goto L158
    L153:
        r213 = r212.hashCode();
        goto L154
    L149:
        r210 = r209.hashCode();
        goto L150
    L145:
        r207 = Arrays.hashCode(r206);
        goto L146
    L141:
        r204 = r203.hashCode();
        goto L142
    L137:
        r201 = r200.hashCode();
        goto L138
    L133:
        r198 = r197.hashCode();
        goto L134
    L129:
        r195 = r194.hashCode();
        goto L130
    L125:
        r192 = r191.hashCode();
        goto L126
    L121:
        r189 = r188.hashCode();
        goto L122
    L117:
        r186 = Arrays.hashCode(r185);
        goto L118
    L113:
        r183 = Arrays.hashCode(r182);
        goto L114
    L109:
        r180 = Arrays.hashCode(r179);
        goto L110
    L105:
        r177 = r176.hashCode();
        goto L106
    L101:
        r174 = r173.hashCode();
        goto L102
    L97:
        r171 = r170.hashCode();
        goto L98
    L93:
        r168 = r167.hashCode();
        goto L94
    L89:
        r165 = r164.hashCode();
        goto L90
    L85:
        r162 = r161.hashCode();
        goto L86
    L81:
        r159 = r158.hashCode();
        goto L82
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = Arrays.hashCode(r125);
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = Arrays.hashCode(r104);
        goto L10
    L5:
        r102 = Arrays.hashCode(r100);
        goto L6
    }

    public final String toString() {
        return "PoiTradeSettingEntity(goodsDetailPrefetchLynxSchemas=" + Arrays.toString(this.goodsDetailPrefetchLynxSchemas) + ", goodsDetailMobParamsBlackKeyList=" + Arrays.toString(this.goodsDetailMobParamsBlackKeyList) + ", presetSizeLynxCardBlackList=" + this.presetSizeLynxCardBlackList + ", optimizations=" + this.optimizations + ", enableSlideToFullScreenWhenLoading=" + this.enableSlideToFullScreenWhenLoading + ", enableInterceptTouchEventWhenSlideDown=" + this.enableInterceptTouchEventWhenSlideDown + ", goodsDetailDownloadInLaunch=" + this.goodsDetailDownloadInLaunch + ", goodsDetailLoadToMemInLaunch=" + this.goodsDetailLoadToMemInLaunch + ", foodCacheValidDurationInSeconds=" + this.foodCacheValidDurationInSeconds + ", foodCacheKeyList=" + Arrays.toString(this.foodCacheKeyList) + ", disableMobConflictDetect=" + this.disableMobConflictDetect + ", numberOfPriorityLoads=" + this.numberOfPriorityLoads + ", preCreateSize=" + this.preCreateSize + ", disableApmReport=" + this.disableApmReport + ", useLynxDisasterRecovery=" + this.useLynxDisasterRecovery + ", routerCostEnable=" + this.routerCostEnable + ", goodsDetailLoadingTimeoutDurationInMillions=" + this.goodsDetailLoadingTimeoutDurationInMillions + ", goodsDetailLoadingDelayInMillions=" + this.goodsDetailLoadingDelayInMillions + ", disableFullPageWhenFixHeight=" + this.disableFullPageWhenFixHeight + ", requestParamInRouter=" + this.requestParamInRouter + ", h5RequestParamsInRouter=" + this.h5RequestParamsInRouter + ", enableProjectDetailShowCheckParams=" + this.enableProjectDetailShowCheckParams + ", cacheBlockRulesList=" + this.cacheBlockRulesList + ", mobShowInNative=" + this.mobShowInNative + ", needReportPreloadVerifyEvent=" + this.needReportPreloadVerifyEvent + ", goodsDetailSwitchGoodsUpdateCards=" + this.goodsDetailSwitchGoodsUpdateCards + ", goodsDetailErroView=" + this.goodsDetailErroView + ", goodsDetailPreloadLynxSchemas=" + Arrays.toString(this.goodsDetailPreloadLynxSchemas) + ", foodV1PreloadSchemaList=" + Arrays.toString(this.foodV1PreloadSchemaList) + ", foodV2PreloadSchemaList=" + Arrays.toString(this.foodV2PreloadSchemaList) + ", deliverGoodsDetailPreloadStrategy=" + this.deliverGoodsDetailPreloadStrategy + ", userNestedRecyclerView=" + this.userNestedRecyclerView + ", validFooterHeightThreshold=" + this.validFooterHeightThreshold + ", enableResetListPadding=" + this.enableResetListPadding + ", useLinearLayoutManager=" + this.useLinearLayoutManager + ", renderCacheEnable=" + this.renderCacheEnable + ", foodCacheNodeWhiteList=" + Arrays.toString(this.foodCacheNodeWhiteList) + ", preCacheEnable=" + this.preCacheEnable + ", useConsumePendingUpdateOperations=" + this.useConsumePendingUpdateOperations + ", getItemViewCacheSize=" + this.getItemViewCacheSize + ", useLynxGapHandlingNone=" + this.useLynxGapHandlingNone + ", shouldRefreshData=" + this.shouldRefreshData + ", nativeCheckAgreementDisable=" + this.nativeCheckAgreementDisable + ", getPreRequestProtocol=" + Arrays.toString(this.getPreRequestProtocol) + ", preRequestProtocolUseTypedOutput=" + this.preRequestProtocolUseTypedOutput + ", goodsDetailPreloadStrategy=" + this.goodsDetailPreloadStrategy + ", useDoubleCheckForNestedScroller=" + this.useDoubleCheckForNestedScroller + ", agreeLynxPopupView=" + this.agreeLynxPopupView + ", trackerEffectiveGoodsDetail=" + this.trackerEffectiveGoodsDetail + ", setOnePxHeight=" + this.setOnePxHeight + ", misTrackKeysChecker=" + this.misTrackKeysChecker + ", enableGoodsDetailGeckoExemptionExpt=" + this.enableGoodsDetailGeckoExemptionExpt + ", urlsReplaceMatches=" + this.urlsReplaceMatches + ", showSkeletonView=" + this.showSkeletonView + ", showNativeSkeletonView=" + this.showNativeSkeletonView + ", skeletonViewUrl=" + this.skeletonViewUrl + ", lynxRenderFinishSkeleton=" + this.lynxRenderFinishSkeleton + ", enableGoodsDetailDitoPageCache=" + this.enableGoodsDetailDitoPageCache + ", cubeParserUrlParams=" + this.cubeParserUrlParams + ", preloadNativeItemKey=" + this.preloadNativeItemKey + ", preRequestPath=" + this.preRequestPath + ", forceShutDownSwitchLayout=" + this.forceShutDownSwitchLayout + ", disableGoodsDetailBtmParams=" + this.disableGoodsDetailBtmParams + ", disableGdErrorMonitorOpt=" + this.disableGdErrorMonitorOpt + ", disableOneConfirmNativeAbility=" + this.disableOneConfirmNativeAbility + ", disableScrollMethodCompatible=" + this.disableScrollMethodCompatible + ", enableCloseBtnBackOpt=" + this.enableCloseBtnBackOpt + ", gdParamsValidatorStrategy=" + this.gdParamsValidatorStrategy + ", gdRoomInfoOpt=" + this.gdRoomInfoOpt + ", gdEnableHalfScreenEmptyClickInterrupt=" + this.gdEnableHalfScreenEmptyClickInterrupt + ", gdLynxTimingReportConfig=" + this.gdLynxTimingReportConfig + ", gdCJCacheDataValidTime=" + this.gdCJCacheDataValidTime + ", gdApiRequestPriority=" + this.gdApiRequestPriority + ", aheadLoadGlobalPropsOptSwitch=" + this.aheadLoadGlobalPropsOptSwitch + ", gdAddLocationParams=" + this.gdAddLocationParams + ", globalReachSwitchRate=" + this.globalReachSwitchRate + ", gdOfflineRenderBundlesArr=" + this.gdOfflineRenderBundlesArr + ')';
    }

    public PoiTradeSettingEntity() {
        Boolean r100 = Boolean.FALSE;
        Boolean r101 = Boolean.TRUE;
        List<String> r102 = CollectionsKt.listOf("detail_pay_footer");
        this.goodsDetailPrefetchLynxSchemas = null;
        this.goodsDetailMobParamsBlackKeyList = null;
        this.presetSizeLynxCardBlackList = null;
        this.optimizations = 55;
        this.enableSlideToFullScreenWhenLoading = r100;
        this.enableInterceptTouchEventWhenSlideDown = r101;
        this.goodsDetailDownloadInLaunch = r101;
        this.goodsDetailLoadToMemInLaunch = r100;
        this.foodCacheValidDurationInSeconds = null;
        this.foodCacheKeyList = null;
        this.disableMobConflictDetect = r100;
        this.numberOfPriorityLoads = null;
        this.preCreateSize = null;
        this.disableApmReport = r100;
        this.useLynxDisasterRecovery = r100;
        this.routerCostEnable = r100;
        this.goodsDetailLoadingTimeoutDurationInMillions = null;
        this.goodsDetailLoadingDelayInMillions = null;
        this.disableFullPageWhenFixHeight = r100;
        this.requestParamInRouter = null;
        this.h5RequestParamsInRouter = null;
        this.enableProjectDetailShowCheckParams = r101;
        this.cacheBlockRulesList = null;
        this.mobShowInNative = r101;
        this.needReportPreloadVerifyEvent = r100;
        this.goodsDetailSwitchGoodsUpdateCards = null;
        this.goodsDetailErroView = null;
        this.goodsDetailPreloadLynxSchemas = null;
        this.foodV1PreloadSchemaList = null;
        this.foodV2PreloadSchemaList = null;
        this.deliverGoodsDetailPreloadStrategy = null;
        this.userNestedRecyclerView = null;
        this.validFooterHeightThreshold = null;
        this.enableResetListPadding = null;
        this.useLinearLayoutManager = 0;
        this.renderCacheEnable = r101;
        this.foodCacheNodeWhiteList = null;
        this.preCacheEnable = r101;
        this.useConsumePendingUpdateOperations = null;
        this.getItemViewCacheSize = null;
        this.useLynxGapHandlingNone = null;
        this.shouldRefreshData = null;
        this.nativeCheckAgreementDisable = r100;
        this.getPreRequestProtocol = null;
        this.preRequestProtocolUseTypedOutput = r101;
        this.goodsDetailPreloadStrategy = null;
        this.useDoubleCheckForNestedScroller = null;
        this.agreeLynxPopupView = null;
        this.trackerEffectiveGoodsDetail = 1;
        this.setOnePxHeight = null;
        this.misTrackKeysChecker = null;
        this.enableGoodsDetailGeckoExemptionExpt = null;
        this.urlsReplaceMatches = null;
        this.showSkeletonView = null;
        this.showNativeSkeletonView = null;
        this.skeletonViewUrl = null;
        this.lynxRenderFinishSkeleton = null;
        this.enableGoodsDetailDitoPageCache = null;
        this.cubeParserUrlParams = r101;
        this.preloadNativeItemKey = null;
        this.preRequestPath = null;
        this.forceShutDownSwitchLayout = r100;
        this.disableGoodsDetailBtmParams = r100;
        this.disableGdErrorMonitorOpt = r100;
        this.disableOneConfirmNativeAbility = r100;
        this.disableScrollMethodCompatible = r100;
        this.enableCloseBtnBackOpt = r100;
        this.gdParamsValidatorStrategy = null;
        this.gdRoomInfoOpt = r100;
        this.gdEnableHalfScreenEmptyClickInterrupt = r101;
        this.gdLynxTimingReportConfig = null;
        this.gdCJCacheDataValidTime = 5;
        this.gdApiRequestPriority = -19;
        this.aheadLoadGlobalPropsOptSwitch = r101;
        this.gdAddLocationParams = r101;
        this.globalReachSwitchRate = 0.0f;
        this.gdOfflineRenderBundlesArr = r102;
    }

    public final Boolean A() {
        return this.gdEnableHalfScreenEmptyClickInterrupt;
    }

    public final GoodsDetailLynxTimingReportConfig B() {
        return this.gdLynxTimingReportConfig;
    }

    public final List<String> C() {
        return this.gdOfflineRenderBundlesArr;
    }

    public final GoodsDetailParamsValidatorStrategy D() {
        return this.gdParamsValidatorStrategy;
    }

    public final Boolean E() {
        return this.gdRoomInfoOpt;
    }

    public final Integer F() {
        return this.getItemViewCacheSize;
    }

    public final PreRequestProtocol[] G() {
        return this.getPreRequestProtocol;
    }

    public final String H() {
        return this.goodsDetailErroView;
    }

    public final Integer I() {
        return this.goodsDetailLoadingDelayInMillions;
    }

    public final Integer J() {
        return this.goodsDetailLoadingTimeoutDurationInMillions;
    }

    public final String[] K() {
        return this.goodsDetailMobParamsBlackKeyList;
    }

    public final String[] L() {
        return this.goodsDetailPreloadLynxSchemas;
    }

    public final GoodsDetailPreloadStrategy M() {
        return this.goodsDetailPreloadStrategy;
    }

    public final List<String> N() {
        return this.goodsDetailSwitchGoodsUpdateCards;
    }

    public final List<String> O() {
        return this.h5RequestParamsInRouter;
    }

    public final Integer P() {
        return this.lynxRenderFinishSkeleton;
    }

    public final Map<String, List<String>> Q() {
        return this.misTrackKeysChecker;
    }

    public final Boolean R() {
        return this.mobShowInNative;
    }

    public final Boolean S() {
        return this.nativeCheckAgreementDisable;
    }

    public final Integer T() {
        return this.numberOfPriorityLoads;
    }

    public final int U() {
        return this.optimizations;
    }

    public final Boolean V() {
        return this.preCacheEnable;
    }

    public final Integer W() {
        return this.preCreateSize;
    }

    public final String X() {
        return this.preRequestPath;
    }

    public final Boolean Y() {
        return this.preRequestProtocolUseTypedOutput;
    }

    public final List<String> Z() {
        return this.preloadNativeItemKey;
    }

    public final String a() {
        return this.agreeLynxPopupView;
    }

    public final List<String> a0() {
        return this.presetSizeLynxCardBlackList;
    }

    public final Boolean b() {
        return this.aheadLoadGlobalPropsOptSwitch;
    }

    public final Boolean b0() {
        return this.renderCacheEnable;
    }

    public final List<Map<String, String>> c() {
        return this.cacheBlockRulesList;
    }

    public final List<String> c0() {
        return this.requestParamInRouter;
    }

    public final Boolean d() {
        return this.cubeParserUrlParams;
    }

    public final Boolean d0() {
        return this.routerCostEnable;
    }

    public final DeliverGoodsDetailPreloadStrategy e() {
        return this.deliverGoodsDetailPreloadStrategy;
    }

    public final Integer e0() {
        return this.setOnePxHeight;
    }

    public final Boolean f() {
        return this.disableApmReport;
    }

    public final Integer f0() {
        return this.shouldRefreshData;
    }

    public final Boolean g() {
        return this.disableFullPageWhenFixHeight;
    }

    public final Integer g0() {
        return this.showNativeSkeletonView;
    }

    public final Boolean h() {
        return this.disableGdErrorMonitorOpt;
    }

    public final Integer h0() {
        return this.showSkeletonView;
    }

    public final Boolean i() {
        return this.disableGoodsDetailBtmParams;
    }

    public final String i0() {
        return this.skeletonViewUrl;
    }

    public final Boolean j() {
        return this.disableOneConfirmNativeAbility;
    }

    public final Integer j0() {
        return this.trackerEffectiveGoodsDetail;
    }

    public final Boolean k() {
        return this.disableScrollMethodCompatible;
    }

    public final Integer k0() {
        return this.useConsumePendingUpdateOperations;
    }

    public final Boolean l() {
        return this.enableCloseBtnBackOpt;
    }

    public final Integer l0() {
        return this.useDoubleCheckForNestedScroller;
    }

    public final Integer m() {
        return this.enableGoodsDetailDitoPageCache;
    }

    public final Integer m0() {
        return this.useLinearLayoutManager;
    }

    public final Integer n() {
        return this.enableGoodsDetailGeckoExemptionExpt;
    }

    public final Boolean n0() {
        return this.useLynxDisasterRecovery;
    }

    public final Boolean o() {
        return this.enableInterceptTouchEventWhenSlideDown;
    }

    public final Integer o0() {
        return this.useLynxGapHandlingNone;
    }

    public final Boolean p() {
        return this.enableProjectDetailShowCheckParams;
    }

    public final Integer p0() {
        return this.validFooterHeightThreshold;
    }

    public final Integer q() {
        return this.enableResetListPadding;
    }

    public final Boolean r() {
        return this.enableSlideToFullScreenWhenLoading;
    }

    public final String[] s() {
        return this.foodCacheKeyList;
    }

    public final String[] t() {
        return this.foodCacheNodeWhiteList;
    }

    public final Integer u() {
        return this.foodCacheValidDurationInSeconds;
    }

    public final String[] v() {
        return this.foodV1PreloadSchemaList;
    }

    public final String[] w() {
        return this.foodV2PreloadSchemaList;
    }

    public final Boolean x() {
        return this.forceShutDownSwitchLayout;
    }

    public final Boolean y() {
        return this.gdAddLocationParams;
    }

    public final Integer z() {
        return this.gdCJCacheDataValidTime;
    }
}
