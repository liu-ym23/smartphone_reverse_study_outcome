package com.ss.android.ugc.aweme.discover.model.commodity.select;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b9\n\u0002\u0010 \n\u0002\b&\n\u0002\u0010\u0007\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b%\u0018\u0000 Õ\u00022\u00020\u00012\u00020\u0002:\nÖ\u0002Õ\u0002×\u0002Ø\u0002Ù\u0002B\t¢\u0006\u0006\bÒ\u0002\u0010Ó\u0002B\u0013\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0006\bÒ\u0002\u0010Ô\u0002J\u0006\u0010\u0004\u001a\u00020\u0003J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0006\u0010\t\u001a\u00020\bJ\b\u0010\n\u001a\u0004\u0018\u00010\u0000J\u0010\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016R$\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R$\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R$\u0010&\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R$\u0010)\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0015\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R$\u0010,\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0015\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u0019R$\u0010/\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0015\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u0019R$\u00102\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0015\u001a\u0004\b3\u0010\u0017\"\u0004\b4\u0010\u0019R$\u00105\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0015\u001a\u0004\b6\u0010\u0017\"\u0004\b7\u0010\u0019R$\u00108\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0015\u001a\u0004\b9\u0010\u0017\"\u0004\b:\u0010\u0019R$\u0010;\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\u0015\u001a\u0004\b<\u0010\u0017\"\u0004\b=\u0010\u0019R$\u0010>\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u0015\u001a\u0004\b?\u0010\u0017\"\u0004\b@\u0010\u0019R$\u0010A\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010\u0015\u001a\u0004\bB\u0010\u0017\"\u0004\bC\u0010\u0019R$\u0010D\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010\u0015\u001a\u0004\bE\u0010\u0017\"\u0004\bF\u0010\u0019R$\u0010G\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bG\u0010\u0015\u001a\u0004\bH\u0010\u0017\"\u0004\bI\u0010\u0019R*\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010J8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010Q\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bQ\u0010\u0015\u001a\u0004\bR\u0010\u0017\"\u0004\bS\u0010\u0019R$\u0010T\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bT\u0010V\"\u0004\bW\u0010XR\"\u0010Y\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R$\u0010_\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b_\u0010U\u001a\u0004\b`\u0010V\"\u0004\ba\u0010XR$\u0010b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bb\u0010U\u001a\u0004\bc\u0010V\"\u0004\bd\u0010XR$\u0010e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\be\u0010U\u001a\u0004\bf\u0010V\"\u0004\bg\u0010XR$\u0010h\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bh\u0010U\u001a\u0004\bi\u0010V\"\u0004\bj\u0010XR$\u0010k\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bk\u0010U\u001a\u0004\bl\u0010V\"\u0004\bm\u0010XR$\u0010n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bn\u0010U\u001a\u0004\bo\u0010V\"\u0004\bp\u0010XR$\u0010r\u001a\u0004\u0018\u00010q8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR$\u0010x\u001a\u0004\u0018\u00010q8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bx\u0010s\u001a\u0004\by\u0010u\"\u0004\bz\u0010wR$\u0010{\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b{\u0010\u001e\u001a\u0004\b|\u0010 \"\u0004\b}\u0010\"R%\u0010~\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0013\n\u0004\b~\u0010\u001e\u001a\u0004\b\u007f\u0010 \"\u0005\b\u0080\u0001\u0010\"R(\u0010\u0081\u0001\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0081\u0001\u0010\u0015\u001a\u0005\b\u0082\u0001\u0010\u0017\"\u0005\b\u0083\u0001\u0010\u0019R(\u0010\u0084\u0001\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010\u0015\u001a\u0005\b\u0085\u0001\u0010\u0017\"\u0005\b\u0086\u0001\u0010\u0019R(\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010\u001e\u001a\u0005\b\u0088\u0001\u0010 \"\u0005\b\u0089\u0001\u0010\"R(\u0010\u008a\u0001\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008a\u0001\u0010\u0015\u001a\u0005\b\u008b\u0001\u0010\u0017\"\u0005\b\u008c\u0001\u0010\u0019R/\u0010\u008e\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u008d\u0001\u0018\u00010J8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008e\u0001\u0010L\u001a\u0005\b\u008f\u0001\u0010N\"\u0005\b\u0090\u0001\u0010PR)\u0010\u0091\u0001\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R&\u0010\u0097\u0001\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0097\u0001\u0010Z\u001a\u0005\b\u0098\u0001\u0010\\\"\u0005\b\u0099\u0001\u0010^R&\u0010\u009a\u0001\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009a\u0001\u0010Z\u001a\u0005\b\u009b\u0001\u0010\\\"\u0005\b\u009c\u0001\u0010^R&\u0010\u009d\u0001\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009d\u0001\u0010Z\u001a\u0005\b\u009e\u0001\u0010\\\"\u0005\b\u009f\u0001\u0010^R&\u0010 \u0001\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b \u0001\u0010Z\u001a\u0005\b¡\u0001\u0010\\\"\u0005\b¢\u0001\u0010^R(\u0010£\u0001\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b£\u0001\u0010\u0015\u001a\u0005\b¤\u0001\u0010\u0017\"\u0005\b¥\u0001\u0010\u0019R(\u0010¦\u0001\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¦\u0001\u0010\u0015\u001a\u0005\b§\u0001\u0010\u0017\"\u0005\b¨\u0001\u0010\u0019R&\u0010©\u0001\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b©\u0001\u0010Z\u001a\u0005\bª\u0001\u0010\\\"\u0005\b«\u0001\u0010^R(\u0010¬\u0001\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¬\u0001\u0010\u0015\u001a\u0005\b\u00ad\u0001\u0010\u0017\"\u0005\b®\u0001\u0010\u0019R(\u0010¯\u0001\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¯\u0001\u0010\u0015\u001a\u0005\b°\u0001\u0010\u0017\"\u0005\b±\u0001\u0010\u0019R,\u0010³\u0001\u001a\u0005\u0018\u00010²\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b³\u0001\u0010´\u0001\u001a\u0006\bµ\u0001\u0010¶\u0001\"\u0006\b·\u0001\u0010¸\u0001R)\u0010¹\u0001\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b¹\u0001\u0010\u0092\u0001\u001a\u0006\bº\u0001\u0010\u0094\u0001\"\u0006\b»\u0001\u0010\u0096\u0001R)\u0010¼\u0001\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b¼\u0001\u0010\u0092\u0001\u001a\u0006\b½\u0001\u0010\u0094\u0001\"\u0006\b¾\u0001\u0010\u0096\u0001R&\u0010¿\u0001\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¿\u0001\u0010Z\u001a\u0005\bÀ\u0001\u0010\\\"\u0005\bÁ\u0001\u0010^R)\u0010Â\u0001\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÂ\u0001\u0010\u0092\u0001\u001a\u0006\bÃ\u0001\u0010\u0094\u0001\"\u0006\bÄ\u0001\u0010\u0096\u0001R(\u0010Å\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÅ\u0001\u0010\u001e\u001a\u0005\bÆ\u0001\u0010 \"\u0005\bÇ\u0001\u0010\"R*\u0010É\u0001\u001a\u00030È\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÉ\u0001\u0010Ê\u0001\u001a\u0006\bË\u0001\u0010Ì\u0001\"\u0006\bÍ\u0001\u0010Î\u0001R(\u0010Ï\u0001\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÏ\u0001\u0010\u0015\u001a\u0005\bÐ\u0001\u0010\u0017\"\u0005\bÑ\u0001\u0010\u0019R(\u0010Ò\u0001\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÒ\u0001\u0010\u0015\u001a\u0005\bÓ\u0001\u0010\u0017\"\u0005\bÔ\u0001\u0010\u0019R&\u0010Õ\u0001\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÕ\u0001\u0010Z\u001a\u0005\bÖ\u0001\u0010\\\"\u0005\b×\u0001\u0010^R)\u0010Ø\u0001\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bØ\u0001\u0010\u0092\u0001\u001a\u0006\bÙ\u0001\u0010\u0094\u0001\"\u0006\bÚ\u0001\u0010\u0096\u0001R(\u0010Û\u0001\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÛ\u0001\u0010\u0015\u001a\u0005\bÜ\u0001\u0010\u0017\"\u0005\bÝ\u0001\u0010\u0019R,\u0010ß\u0001\u001a\u0005\u0018\u00010Þ\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bß\u0001\u0010à\u0001\u001a\u0006\bá\u0001\u0010â\u0001\"\u0006\bã\u0001\u0010ä\u0001R&\u0010å\u0001\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bå\u0001\u0010Z\u001a\u0005\bæ\u0001\u0010\\\"\u0005\bç\u0001\u0010^R,\u0010é\u0001\u001a\u0005\u0018\u00010è\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bé\u0001\u0010ê\u0001\u001a\u0006\bë\u0001\u0010ì\u0001\"\u0006\bí\u0001\u0010î\u0001R,\u0010ö\u0001\u001a\u0005\u0018\u00010ï\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bð\u0001\u0010ñ\u0001\u001a\u0006\bò\u0001\u0010ó\u0001\"\u0006\bô\u0001\u0010õ\u0001R,\u0010þ\u0001\u001a\u0005\u0018\u00010÷\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bø\u0001\u0010ù\u0001\u001a\u0006\bú\u0001\u0010û\u0001\"\u0006\bü\u0001\u0010ý\u0001R+\u0010\u0085\u0002\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÿ\u0001\u0010\u0080\u0002\u001a\u0006\b\u0081\u0002\u0010\u0082\u0002\"\u0006\b\u0083\u0002\u0010\u0084\u0002R,\u0010\u008d\u0002\u001a\u0005\u0018\u00010\u0086\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0087\u0002\u0010\u0088\u0002\u001a\u0006\b\u0089\u0002\u0010\u008a\u0002\"\u0006\b\u008b\u0002\u0010\u008c\u0002R&\u0010\u0091\u0002\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008e\u0002\u0010\u0015\u001a\u0005\b\u008f\u0002\u0010\u0017\"\u0005\b\u0090\u0002\u0010\u0019R,\u0010\u0099\u0002\u001a\u0005\u0018\u00010\u0092\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0093\u0002\u0010\u0094\u0002\u001a\u0006\b\u0095\u0002\u0010\u0096\u0002\"\u0006\b\u0097\u0002\u0010\u0098\u0002R(\u0010\u009d\u0002\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009a\u0002\u0010\u0015\u001a\u0005\b\u009b\u0002\u0010\u0017\"\u0005\b\u009c\u0002\u0010\u0019R(\u0010¡\u0002\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009e\u0002\u0010\u0015\u001a\u0005\b\u009f\u0002\u0010\u0017\"\u0005\b \u0002\u0010\u0019R(\u0010¥\u0002\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¢\u0002\u0010\u0015\u001a\u0005\b£\u0002\u0010\u0017\"\u0005\b¤\u0002\u0010\u0019R)\u0010©\u0002\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¦\u0002\u0010\u0092\u0001\u001a\u0006\b§\u0002\u0010\u0094\u0001\"\u0006\b¨\u0002\u0010\u0096\u0001R+\u0010°\u0002\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bª\u0002\u0010«\u0002\u001a\u0006\b¬\u0002\u0010\u00ad\u0002\"\u0006\b®\u0002\u0010¯\u0002R(\u0010´\u0002\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b±\u0002\u0010\u001e\u001a\u0005\b²\u0002\u0010 \"\u0005\b³\u0002\u0010\"R*\u0010¼\u0002\u001a\u00030µ\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¶\u0002\u0010·\u0002\u001a\u0006\b¸\u0002\u0010¹\u0002\"\u0006\bº\u0002\u0010»\u0002R)\u0010¾\u0002\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b½\u0002\u0010\u0092\u0001\u001a\u0006\b¾\u0002\u0010\u0094\u0001\"\u0006\b¿\u0002\u0010\u0096\u0001R)\u0010Á\u0002\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÀ\u0002\u0010\u0092\u0001\u001a\u0006\bÁ\u0002\u0010\u0094\u0001\"\u0006\bÂ\u0002\u0010\u0096\u0001R(\u0010Æ\u0002\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÃ\u0002\u0010\u0015\u001a\u0005\bÄ\u0002\u0010\u0017\"\u0005\bÅ\u0002\u0010\u0019R(\u0010Ê\u0002\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÇ\u0002\u0010\u0015\u001a\u0005\bÈ\u0002\u0010\u0017\"\u0005\bÉ\u0002\u0010\u0019R)\u0010Î\u0002\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bË\u0002\u0010\u0092\u0001\u001a\u0006\bÌ\u0002\u0010\u0094\u0001\"\u0006\bÍ\u0002\u0010\u0096\u0001R(\u0010Ï\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÏ\u0002\u0010U\u001a\u0005\bÐ\u0002\u0010V\"\u0005\bÑ\u0002\u0010X¨\u0006Ú\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "", "childrenIsClick", "", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/SelectItemStatus;", "getSubSelectStatus", "", "getSelectTagText", "getSelectChildrenComponent", "status", "", "updateStatusOfRenderTree", "Landroid/os/Parcel;", "parcel", "", "flags", "writeToParcel", "describeContents", "uniqueId", "Ljava/lang/String;", "getUniqueId", "()Ljava/lang/String;", "setUniqueId", "(Ljava/lang/String;)V", "componentId", "getComponentId", "setComponentId", "pinToTop", "Ljava/lang/Integer;", "getPinToTop", "()Ljava/lang/Integer;", "setPinToTop", "(Ljava/lang/Integer;)V", "customOrder", "getCustomOrder", "setCustomOrder", "dataId", "getDataId", "setDataId", "styleId", "getStyleId", "setStyleId", "text", "getText", "setText", "leftText", "getLeftText", "setLeftText", "leftPostscriptText", "getLeftPostscriptText", "setLeftPostscriptText", "rightText", "getRightText", "setRightText", "rightPostscriptText", "getRightPostscriptText", "setRightPostscriptText", "selectedHeadText", "getSelectedHeadText", "setSelectedHeadText", "headText", "getHeadText", "setHeadText", "tailText", "getTailText", "setTailText", "postscriptText", "getPostscriptText", "setPostscriptText", "englishText", "getEnglishText", "setEnglishText", "", "childrenComponent", "Ljava/util/List;", "getChildrenComponent", "()Ljava/util/List;", "setChildrenComponent", "(Ljava/util/List;)V", "needMutex", "getNeedMutex", "setNeedMutex", "isDefaultSelect", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setDefaultSelect", "(Ljava/lang/Boolean;)V", "priceSortType", "I", "getPriceSortType", "()I", "setPriceSortType", "(I)V", "disableSelected", "getDisableSelected", "setDisableSelected", "counterElection", "getCounterElection", "setCounterElection", "disableCounter", "getDisableCounter", "setDisableCounter", "gradualChangeEnable", "getGradualChangeEnable", "setGradualChangeEnable", "shouldShowAsManualSelectWhenDefaultSelect", "getShouldShowAsManualSelectWhenDefaultSelect", "setShouldShowAsManualSelectWhenDefaultSelect", "useTextWhenDefaultSelect", "getUseTextWhenDefaultSelect", "setUseTextWhenDefaultSelect", "", "width", "Ljava/lang/Float;", "getWidth", "()Ljava/lang/Float;", "setWidth", "(Ljava/lang/Float;)V", "height", "getHeight", "setHeight", "columnCount", "getColumnCount", "setColumnCount", "defaultShowCount", "getDefaultShowCount", "setDefaultShowCount", "componentType", "getComponentType", "setComponentType", "endTime", "getEndTime", "setEndTime", "listLevelNum", "getListLevelNum", "setListLevelNum", "textType", "getTextType", "setTextType", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/FilterBarConfig;", "barConfigs", "getBarConfigs", "setBarConfigs", "needCombineWithSpecify", "Z", "getNeedCombineWithSpecify", "()Z", "setNeedCombineWithSpecify", "(Z)V", "innerLeftPadding", "getInnerLeftPadding", "setInnerLeftPadding", "innerRightPadding", "getInnerRightPadding", "setInnerRightPadding", "innerTopPadding", "getInnerTopPadding", "setInnerTopPadding", "innerBottomPadding", "getInnerBottomPadding", "setInnerBottomPadding", "groupId", "getGroupId", "setGroupId", n.KEY_SUB_TEXT, "getSubText", "setSubText", "panelItemWidthStrategy", "getPanelItemWidthStrategy", "setPanelItemWidthStrategy", "tabType", "getTabType", "setTabType", "countTabType", "getCountTabType", "setCountTabType", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$ClickToastInfo;", "clickToastInfo", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$ClickToastInfo;", "getClickToastInfo", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$ClickToastInfo;", "setClickToastInfo", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$ClickToastInfo;)V", "filterBoardNewStyle", "getFilterBoardNewStyle", "setFilterBoardNewStyle", "filterBoardSidebarShow", "getFilterBoardSidebarShow", "setFilterBoardSidebarShow", "fixedPosition", "getFixedPosition", "setFixedPosition", "newStyleWithTab", "getNewStyleWithTab", "setNewStyleWithTab", "boardExtraTranslation", "getBoardExtraTranslation", "setBoardExtraTranslation", "", "expiredTime", "J", "getExpiredTime", "()J", "setExpiredTime", "(J)V", "invalidText", "getInvalidText", "setInvalidText", "validText", "getValidText", "setValidText", "subBoardWidth", "getSubBoardWidth", "setSubBoardWidth", "hideParentItem", "getHideParentItem", "setHideParentItem", "selectedParentText", "getSelectedParentText", "setSelectedParentText", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$AnimationConfig;", "animationConfig", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$AnimationConfig;", "getAnimationConfig", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$AnimationConfig;", "setAnimationConfig", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$AnimationConfig;)V", "requestType", "getRequestType", "setRequestType", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$TipConfig;", "tipConfig", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$TipConfig;", "getTipConfig", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$TipConfig;", "setTipConfig", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$TipConfig;)V", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/BusinessItem;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/BusinessItem;", "getBusinessItem", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/select/BusinessItem;", "setBusinessItem", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/select/BusinessItem;)V", "businessItem", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/StyleItem;", "b", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/StyleItem;", "getStyleItem", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/select/StyleItem;", "setStyleItem", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/select/StyleItem;)V", "styleItem", "c", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem;", "getParentRenderItem", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem;", "setParentRenderItem", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem;)V", "parentRenderItem", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderLine;", "d", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderLine;", "getRenderLine", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderLine;", "setRenderLine", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderLine;)V", "renderLine", "e", "getSelectInfoDataType", "setSelectInfoDataType", "selectInfoDataType", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/BaseSelectItemView;", "f", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/BaseSelectItemView;", "getRenderView", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/select/BaseSelectItemView;", "setRenderView", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/select/BaseSelectItemView;)V", "renderView", ce.f26391f, "getFilterOptionRow", "setFilterOptionRow", "filterOptionRow", "h", "getFilterOptionRank", "setFilterOptionRank", "filterOptionRank", RXScreenCaptureService.KEY_INDEX, "getStatusPath", "setStatusPath", "statusPath", ce.f26395j, "getAvoidBoardBottomPadding", "setAvoidBoardBottomPadding", "avoidBoardBottomPadding", ce.f26396k, "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/SelectItemStatus;", "getCurrentStatus", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/select/SelectItemStatus;", "setCurrentStatus", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/select/SelectItemStatus;)V", "currentStatus", "l", "getUiMode", "setUiMode", "uiMode", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$FilterLogParams;", "m", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$FilterLogParams;", "getFilterLogParams", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$FilterLogParams;", "setFilterLogParams", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$FilterLogParams;)V", "filterLogParams", OfficeSDKRequestTag.KEY_NEW_USER, "isCurSelected", "setCurSelected", "o", "isManualSelected", "setManualSelected", "p", "getQueryId", "setQueryId", "queryId", "q", "getImprId", "setImprId", "imprId", "r", "getShouldUseGSUpdateInfo", "setShouldUseGSUpdateInfo", "shouldUseGSUpdateInfo", "mHasClickChildren", "getMHasClickChildren", "setMHasClickChildren", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "AnimationConfig", "ClickToastInfo", "FilterLogParams", "TipConfig", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RenderItem implements Serializable, Parcelable {
    public static final CREATOR CREATOR = null;
    public static final int LEFT_FIXED = 1;
    public static final int PANEL_ITEM_WIDTH_STRATEGY_AUTO_CHANGE = 1;
    public static final int PANEL_ITEM_WIDTH_STRATEGY_DEFAULT = 0;
    public static final int PRICE_SORT_ASC = 1;
    public static final int PRICE_SORT_DEFAULT = 0;
    public static final int PRICE_SORT_DESC = 2;
    public static final int RIGHT_FIXED = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient BusinessItem f450515a;

    @SerializedName("animation_config")
    private AnimationConfig animationConfig;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient StyleItem f450516b;

    @SerializedName("bar_config")
    private List<FilterBarConfig> barConfigs;

    @SerializedName("board_extra_translation")
    private Integer boardExtraTranslation;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient RenderItem f450517c;

    @SerializedName("children_component")
    private List<RenderItem> childrenComponent;

    @SerializedName("click_toast_info")
    private ClickToastInfo clickToastInfo;

    @SerializedName("column_count")
    private Integer columnCount;

    @SerializedName("component_id")
    private String componentId;

    @SerializedName("component_type")
    private String componentType;

    @SerializedName("counter_tab_type")
    private String countTabType;

    @SerializedName("counter_election")
    private Boolean counterElection;

    @SerializedName("custom_order")
    private Integer customOrder;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient RenderLine f450518d;

    @SerializedName("data_id")
    private String dataId;

    @SerializedName("default_show_count")
    private Integer defaultShowCount;

    @SerializedName("disable_counter")
    private Boolean disableCounter;

    @SerializedName("disable_selected")
    private Boolean disableSelected;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient String f450519e;

    @SerializedName("end_time")
    private String endTime;

    @SerializedName("english_text")
    private String englishText;

    @SerializedName("expired_time")
    private long expiredTime;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient BaseSelectItemView f450520f;

    @SerializedName("filter_board_new_style")
    private boolean filterBoardNewStyle;

    @SerializedName("filter_board_sidebar_show")
    private boolean filterBoardSidebarShow;

    @SerializedName("fixed_position")
    private int fixedPosition;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public transient String f450521g;

    @SerializedName("gradual_change_enabled")
    private Boolean gradualChangeEnable;

    @SerializedName("group_id")
    private String groupId;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient String f450522h;

    @SerializedName("head_text")
    private String headText;

    @SerializedName("height")
    private Float height;

    @SerializedName("hide_parent_item")
    private boolean hideParentItem;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public transient String f450523i;

    @SerializedName("item_inner_bottom_padding")
    private int innerBottomPadding;

    @SerializedName("item_inner_left_padding")
    private int innerLeftPadding;

    @SerializedName("item_inner_right_padding")
    private int innerRightPadding;

    @SerializedName("item_inner_top_padding")
    private int innerTopPadding;

    @SerializedName("invalid_text")
    private String invalidText;

    @SerializedName("is_default_select")
    private Boolean isDefaultSelect;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public transient boolean f450524j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public transient SelectItemStatus f450525k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public transient Integer f450526l;

    @SerializedName("left_postscript_text")
    private String leftPostscriptText;

    @SerializedName("left_text")
    private String leftText;

    @SerializedName("list_level_num")
    private Integer listLevelNum;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public transient FilterLogParams f450527m;
    private Boolean mHasClickChildren;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public transient boolean f450528n;

    @SerializedName("need_combine_with_specify_address")
    private boolean needCombineWithSpecify;

    @SerializedName("need_mutex")
    private String needMutex;

    @SerializedName("new_style_with_tab")
    private boolean newStyleWithTab;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public transient boolean f450529o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public transient String f450530p;

    @SerializedName("panel_item_width_strategy")
    private int panelItemWidthStrategy;

    @SerializedName("pin_to_top")
    private Integer pinToTop;

    @SerializedName("postscript_text")
    private String postscriptText;

    @SerializedName("price_sort_type")
    private int priceSortType;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public transient String f450531q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public transient boolean f450532r;

    @SerializedName("request_type")
    private int requestType;

    @SerializedName("right_postscript_text")
    private String rightPostscriptText;

    @SerializedName("right_text")
    private String rightText;

    @SerializedName("selected_head_text")
    private String selectedHeadText;

    @SerializedName("selected_parent_text")
    private String selectedParentText;

    @SerializedName("should_show_as_manual_select")
    private Boolean shouldShowAsManualSelectWhenDefaultSelect;

    @SerializedName("style_id")
    private String styleId;

    @SerializedName("sub_board_width")
    private int subBoardWidth;

    @SerializedName("sub_text")
    private String subText;

    @SerializedName("tab_type")
    private String tabType;

    @SerializedName("tail_text")
    private String tailText;

    @SerializedName("text")
    private String text;

    @SerializedName(a.KEY_TEXT_TYPE)
    private String textType;

    @SerializedName("tip_config")
    private TipConfig tipConfig;

    @SerializedName(BdpAppEventConstant.PARAMS_UNIQUEID)
    private String uniqueId;

    @SerializedName("use_text_when_default_select")
    private Boolean useTextWhenDefaultSelect;

    @SerializedName("valid_text")
    private String validText;

    @SerializedName("width")
    private Float width;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0014H\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR \u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$AnimationConfig;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "headIcon", "", "getHeadIcon", "()Ljava/lang/String;", "setHeadIcon", "(Ljava/lang/String;)V", "tailIcon", "getTailIcon", "setTailIcon", "text", "getText", "setText", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AnimationConfig implements Serializable, Parcelable {
        public static final CREATOR CREATOR = null;

        @SerializedName("head_icon")
        private String headIcon;

        @SerializedName("tail_icon")
        private String tailIcon;

        @SerializedName("text")
        private String text;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$AnimationConfig$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$AnimationConfig;", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class CREATOR implements Parcelable.Creator<AnimationConfig> {
            private CREATOR() {
            }

            public /* synthetic */ CREATOR(int r100) {
                this();
            }

            @Override // android.os.Parcelable.Creator
            public final AnimationConfig createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "parcel");
                return new AnimationConfig(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final AnimationConfig[] newArray(int r100) {
                return new AnimationConfig[r100];
            }
        }

        static {
            CREATOR = new CREATOR(0);
        }

        public AnimationConfig() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final String getHeadIcon() {
            return this.headIcon;
        }

        public final String getTailIcon() {
            return this.tailIcon;
        }

        public final String getText() {
            return this.text;
        }

        public AnimationConfig(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            this();
            this.headIcon = r100.readString();
            this.tailIcon = r100.readString();
            this.text = r100.readString();
        }

        public final void setHeadIcon(String r100) {
            this.headIcon = r100;
        }

        public final void setTailIcon(String r100) {
            this.tailIcon = r100;
        }

        public final void setText(String r100) {
            this.text = r100;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            r100.writeString(this.headIcon);
            r100.writeString(this.tailIcon);
            r100.writeString(this.text);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0005R\u0014\u0010\u000b\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem;", "", "LEFT_FIXED", "I", "PANEL_ITEM_WIDTH_STRATEGY_AUTO_CHANGE", "PANEL_ITEM_WIDTH_STRATEGY_DEFAULT", "PRICE_SORT_ASC", "PRICE_SORT_DEFAULT", "PRICE_SORT_DESC", "RIGHT_FIXED", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CREATOR implements Parcelable.Creator<RenderItem> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(int r100) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public final RenderItem createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new RenderItem(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final RenderItem[] newArray(int r100) {
            return new RenderItem[r100];
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000eH\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$ClickToastInfo;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "selectToastKey", "", "getSelectToastKey", "()Ljava/lang/String;", "setSelectToastKey", "(Ljava/lang/String;)V", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ClickToastInfo implements Serializable, Parcelable {
        public static final CREATOR CREATOR = null;

        @SerializedName("select_toast_key")
        private String selectToastKey;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$ClickToastInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$ClickToastInfo;", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class CREATOR implements Parcelable.Creator<ClickToastInfo> {
            private CREATOR() {
            }

            public /* synthetic */ CREATOR(int r100) {
                this();
            }

            @Override // android.os.Parcelable.Creator
            public final ClickToastInfo createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "parcel");
                return new ClickToastInfo(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final ClickToastInfo[] newArray(int r100) {
                return new ClickToastInfo[r100];
            }
        }

        static {
            CREATOR = new CREATOR(0);
        }

        public ClickToastInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final String getSelectToastKey() {
            return this.selectToastKey;
        }

        public ClickToastInfo(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            this();
            this.selectToastKey = r100.readString();
        }

        public final void setSelectToastKey(String r100) {
            this.selectToastKey = r100;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            r100.writeString(this.selectToastKey);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$FilterLogParams;", "", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FilterLogParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f450533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f450534b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f450535c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f450536d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f450537e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f450538f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f450539g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f450540h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f450541i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Long f450542j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Long f450543k;

        public FilterLogParams() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u000eH\u0016R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$TipConfig;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "autoDismiss", "", "getAutoDismiss", "()Z", "setAutoDismiss", "(Z)V", "dismissDelay", "", "getDismissDelay", "()I", "setDismissDelay", "(I)V", "tipText", "", "getTipText", "()Ljava/lang/String;", "setTipText", "(Ljava/lang/String;)V", "describeContents", "writeToParcel", "", "flags", "CREATOR", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TipConfig implements Serializable, Parcelable {
        public static final CREATOR CREATOR = null;

        @SerializedName("auto_dismiss")
        private boolean autoDismiss;

        @SerializedName("dismiss_delay")
        private int dismissDelay;

        @SerializedName("tip_text")
        private String tipText;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$TipConfig$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem$TipConfig;", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class CREATOR implements Parcelable.Creator<TipConfig> {
            private CREATOR() {
            }

            public /* synthetic */ CREATOR(int r100) {
                this();
            }

            @Override // android.os.Parcelable.Creator
            public final TipConfig createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "parcel");
                return new TipConfig(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final TipConfig[] newArray(int r100) {
                return new TipConfig[r100];
            }
        }

        static {
            CREATOR = new CREATOR(0);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public TipConfig() {
            this.dismissDelay = 3000;
        }

        public final boolean getAutoDismiss() {
            return this.autoDismiss;
        }

        public final int getDismissDelay() {
            return this.dismissDelay;
        }

        public final String getTipText() {
            return this.tipText;
        }

        public TipConfig(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            this();
            this.tipText = r100.readString();
            this.autoDismiss = r100.readBoolean();
            this.dismissDelay = r100.readInt();
        }

        public final void setAutoDismiss(boolean r100) {
            this.autoDismiss = r100;
        }

        public final void setDismissDelay(int r100) {
            this.dismissDelay = r100;
        }

        public final void setTipText(String r100) {
            this.tipText = r100;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            r100.writeString(this.tipText);
            r100.writeBoolean(this.autoDismiss);
            r100.writeInt(this.dismissDelay);
        }
    }

    static {
        CREATOR = new CREATOR(0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean childrenIsClick() {
        List<RenderItem> r100 = this.childrenComponent;
        if (r100 == null) goto L20;
        Iterator<T> r101 = r100.iterator();
        boolean r102 = false;
    L6:
        if (r101.hasNext() == false) goto L14;
        Boolean r103 = ((RenderItem) r101.next()).mHasClickChildren;
        if (r103 == null) goto L10;
        boolean r104 = r103.booleanValue();
    L11:
        if (r104 == false) goto L6;
        r102 = true;
        goto L6
    L10:
        r104 = false;
        goto L11
    L14:
        return r102;
    L20:
        return false;
    }

    public final RenderItem getSelectChildrenComponent() {
        List<RenderItem> r100 = this.childrenComponent;
        RenderItem r101 = null;
        if (r100 == null) goto L13;
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L13;
        RenderItem r103 = (RenderItem) r102.next();
        Boolean r104 = r103.isDefaultSelect;
        if (r104 == null) goto L10;
        boolean r105 = r104.booleanValue();
    L11:
        if (r105 == false) goto L6;
        r101 = r103;
        goto L6
    L10:
        r105 = false;
    L13:
        return r101;
    }

    public final String getSelectTagText() {
        String r100 = this.text;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        List<RenderItem> r101 = this.childrenComponent;
        if (r101 == null) goto L18;
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L18;
        RenderItem r103 = (RenderItem) r102.next();
        Boolean r104 = r103.isDefaultSelect;
        if (r104 == null) goto L13;
        boolean r105 = r104.booleanValue();
    L14:
        if (r105 == false) goto L9;
        r100 = r103.text;
        if (r100 != null) goto L9;
        r100 = "";
        goto L9
    L13:
        r105 = false;
    L18:
        return r100;
    }

    public final List<SelectItemStatus> getSubSelectStatus() {
        if (this.dataId == null) goto L13;
        SelectItemStatus r100 = this.f450525k;
        if ((r100 instanceof SelectListStatus) == true) goto L7;
        r100 = null;
    L7:
        SelectListStatus r101 = (SelectListStatus) r100;
        if (r101 == null) goto L12;
        List<SelectItemStatus> r102 = r101.getSubSelectItemList();
        if (r102 == null) goto L12;
        return r102;
    L12:
        return new ArrayList();
    L13:
        ArrayList r103 = new ArrayList();
        List<RenderItem> r104 = this.childrenComponent;
        if (r104 == null) goto L21;
        Iterator<T> r105 = r104.iterator();
    L17:
        if (r105.hasNext() == false) goto L21;
        SelectItemStatus r106 = ((RenderItem) r105.next()).f450525k;
        if (r106 == null) goto L17;
        r103.add(r106);
    L21:
        return r103;
    }

    public RenderItem() {
        Boolean r100 = Boolean.FALSE;
        this.isDefaultSelect = r100;
        this.disableSelected = r100;
        this.counterElection = r100;
        this.disableCounter = r100;
        this.gradualChangeEnable = r100;
        this.shouldShowAsManualSelectWhenDefaultSelect = r100;
        this.useTextWhenDefaultSelect = r100;
        this.innerLeftPadding = -1;
        this.innerRightPadding = -1;
        this.innerTopPadding = -1;
        this.innerBottomPadding = -1;
        this.f450519e = "all";
        this.f450527m = new FilterLogParams();
    }

    public final AnimationConfig getAnimationConfig() {
        return this.animationConfig;
    }

    public final boolean getAvoidBoardBottomPadding() {
        return this.f450524j;
    }

    public final List<FilterBarConfig> getBarConfigs() {
        return this.barConfigs;
    }

    public final Integer getBoardExtraTranslation() {
        return this.boardExtraTranslation;
    }

    public final BusinessItem getBusinessItem() {
        return this.f450515a;
    }

    public final List<RenderItem> getChildrenComponent() {
        return this.childrenComponent;
    }

    public final ClickToastInfo getClickToastInfo() {
        return this.clickToastInfo;
    }

    public final Integer getColumnCount() {
        return this.columnCount;
    }

    public final String getComponentId() {
        return this.componentId;
    }

    public final String getComponentType() {
        return this.componentType;
    }

    public final String getCountTabType() {
        return this.countTabType;
    }

    public final Boolean getCounterElection() {
        return this.counterElection;
    }

    public final SelectItemStatus getCurrentStatus() {
        return this.f450525k;
    }

    public final Integer getCustomOrder() {
        return this.customOrder;
    }

    public final String getDataId() {
        return this.dataId;
    }

    public final Integer getDefaultShowCount() {
        return this.defaultShowCount;
    }

    public final Boolean getDisableCounter() {
        return this.disableCounter;
    }

    public final Boolean getDisableSelected() {
        return this.disableSelected;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getEnglishText() {
        return this.englishText;
    }

    public final long getExpiredTime() {
        return this.expiredTime;
    }

    public final boolean getFilterBoardNewStyle() {
        return this.filterBoardNewStyle;
    }

    public final boolean getFilterBoardSidebarShow() {
        return this.filterBoardSidebarShow;
    }

    public final FilterLogParams getFilterLogParams() {
        return this.f450527m;
    }

    public final String getFilterOptionRank() {
        return this.f450522h;
    }

    public final String getFilterOptionRow() {
        return this.f450521g;
    }

    public final int getFixedPosition() {
        return this.fixedPosition;
    }

    public final Boolean getGradualChangeEnable() {
        return this.gradualChangeEnable;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getHeadText() {
        return this.headText;
    }

    public final Float getHeight() {
        return this.height;
    }

    public final boolean getHideParentItem() {
        return this.hideParentItem;
    }

    public final String getImprId() {
        return this.f450531q;
    }

    public final int getInnerBottomPadding() {
        return this.innerBottomPadding;
    }

    public final int getInnerLeftPadding() {
        return this.innerLeftPadding;
    }

    public final int getInnerRightPadding() {
        return this.innerRightPadding;
    }

    public final int getInnerTopPadding() {
        return this.innerTopPadding;
    }

    public final String getInvalidText() {
        return this.invalidText;
    }

    public final String getLeftPostscriptText() {
        return this.leftPostscriptText;
    }

    public final String getLeftText() {
        return this.leftText;
    }

    public final Integer getListLevelNum() {
        return this.listLevelNum;
    }

    public final Boolean getMHasClickChildren() {
        return this.mHasClickChildren;
    }

    public final boolean getNeedCombineWithSpecify() {
        return this.needCombineWithSpecify;
    }

    public final String getNeedMutex() {
        return this.needMutex;
    }

    public final boolean getNewStyleWithTab() {
        return this.newStyleWithTab;
    }

    public final int getPanelItemWidthStrategy() {
        return this.panelItemWidthStrategy;
    }

    public final RenderItem getParentRenderItem() {
        return this.f450517c;
    }

    public final Integer getPinToTop() {
        return this.pinToTop;
    }

    public final String getPostscriptText() {
        return this.postscriptText;
    }

    public final int getPriceSortType() {
        return this.priceSortType;
    }

    public final String getQueryId() {
        return this.f450530p;
    }

    public final RenderLine getRenderLine() {
        return this.f450518d;
    }

    public final BaseSelectItemView getRenderView() {
        return this.f450520f;
    }

    public final int getRequestType() {
        return this.requestType;
    }

    public final String getRightPostscriptText() {
        return this.rightPostscriptText;
    }

    public final String getRightText() {
        return this.rightText;
    }

    public final String getSelectInfoDataType() {
        return this.f450519e;
    }

    public final String getSelectedHeadText() {
        return this.selectedHeadText;
    }

    public final String getSelectedParentText() {
        return this.selectedParentText;
    }

    public final Boolean getShouldShowAsManualSelectWhenDefaultSelect() {
        return this.shouldShowAsManualSelectWhenDefaultSelect;
    }

    public final boolean getShouldUseGSUpdateInfo() {
        return this.f450532r;
    }

    public final String getStatusPath() {
        return this.f450523i;
    }

    public final String getStyleId() {
        return this.styleId;
    }

    public final StyleItem getStyleItem() {
        return this.f450516b;
    }

    public final int getSubBoardWidth() {
        return this.subBoardWidth;
    }

    public final String getSubText() {
        return this.subText;
    }

    public final String getTabType() {
        return this.tabType;
    }

    public final String getTailText() {
        return this.tailText;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextType() {
        return this.textType;
    }

    public final TipConfig getTipConfig() {
        return this.tipConfig;
    }

    public final Integer getUiMode() {
        return this.f450526l;
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public final Boolean getUseTextWhenDefaultSelect() {
        return this.useTextWhenDefaultSelect;
    }

    public final String getValidText() {
        return this.validText;
    }

    public final Float getWidth() {
        return this.width;
    }

    public final boolean isCurSelected() {
        return this.f450528n;
    }

    public final Boolean isDefaultSelect() {
        return this.isDefaultSelect;
    }

    public final boolean isManualSelected() {
        return this.f450529o;
    }

    public RenderItem(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        this.uniqueId = r100.readString();
        this.componentId = r100.readString();
        this.dataId = r100.readString();
        this.styleId = r100.readString();
        this.text = r100.readString();
        this.leftText = r100.readString();
        this.leftPostscriptText = r100.readString();
        this.rightText = r100.readString();
        this.rightPostscriptText = r100.readString();
        this.selectedHeadText = r100.readString();
        this.headText = r100.readString();
        this.tailText = r100.readString();
        this.postscriptText = r100.readString();
        this.englishText = r100.readString();
        this.childrenComponent = r100.createTypedArrayList(CREATOR);
        this.needMutex = r100.readString();
        Class r101 = Boolean.TYPE;
        Object r102 = r100.readValue(r101.getClassLoader());
        Object r103 = null;
        if ((r102 instanceof Boolean) == true) goto L5;
        r102 = null;
    L5:
        this.isDefaultSelect = (Boolean) r102;
        this.priceSortType = r100.readInt();
        Object r104 = r100.readValue(r101.getClassLoader());
        if ((r104 instanceof Boolean) == true) goto L8;
        r104 = null;
    L8:
        this.disableSelected = (Boolean) r104;
        Object r105 = r100.readValue(r101.getClassLoader());
        if ((r105 instanceof Boolean) == true) goto L11;
        r105 = null;
    L11:
        this.counterElection = (Boolean) r105;
        Object r106 = r100.readValue(r101.getClassLoader());
        if ((r106 instanceof Boolean) == true) goto L14;
        r106 = null;
    L14:
        this.gradualChangeEnable = (Boolean) r106;
        Object r107 = r100.readValue(r101.getClassLoader());
        if ((r107 instanceof Boolean) == true) goto L17;
        r107 = null;
    L17:
        this.shouldShowAsManualSelectWhenDefaultSelect = (Boolean) r107;
        Object r108 = r100.readValue(r101.getClassLoader());
        if ((r108 instanceof Boolean) == true) goto L20;
        r108 = null;
    L20:
        this.useTextWhenDefaultSelect = (Boolean) r108;
        Class r109 = Float.TYPE;
        Object r110 = r100.readValue(r109.getClassLoader());
        if ((r110 instanceof Float) == true) goto L23;
        r110 = null;
    L23:
        this.width = (Float) r110;
        Object r111 = r100.readValue(r109.getClassLoader());
        if ((r111 instanceof Float) == true) goto L26;
        r111 = null;
    L26:
        this.height = (Float) r111;
        Class r112 = Integer.TYPE;
        Object r113 = r100.readValue(r112.getClassLoader());
        if ((r113 instanceof Integer) == true) goto L29;
        r113 = null;
    L29:
        this.columnCount = (Integer) r113;
        Object r114 = r100.readValue(r112.getClassLoader());
        if ((r114 instanceof Integer) == true) goto L32;
        r114 = null;
    L32:
        this.defaultShowCount = (Integer) r114;
        this.componentType = r100.readString();
        this.endTime = r100.readString();
        Object r115 = r100.readValue(r112.getClassLoader());
        if ((r115 instanceof Integer) == true) goto L35;
        r115 = null;
    L35:
        this.listLevelNum = (Integer) r115;
        this.textType = r100.readString();
        this.barConfigs = r100.createTypedArrayList(FilterBarConfig.CREATOR);
        this.innerLeftPadding = r100.readInt();
        this.innerRightPadding = r100.readInt();
        this.innerTopPadding = r100.readInt();
        this.innerBottomPadding = r100.readInt();
        this.groupId = r100.readString();
        this.subText = r100.readString();
        this.panelItemWidthStrategy = r100.readInt();
        this.tabType = r100.readString();
        this.countTabType = r100.readString();
        this.clickToastInfo = (ClickToastInfo) r100.readParcelable(ClickToastInfo.class.getClassLoader());
        boolean r116 = false;
        byte r117 = (byte) 0;
        if (r100.readByte() == r117) goto L38;
        boolean r118 = true;
    L39:
        this.filterBoardNewStyle = r118;
        if (r100.readByte() == r117) goto L42;
        boolean r119 = true;
    L43:
        this.filterBoardSidebarShow = r119;
        this.fixedPosition = r100.readInt();
        if (r100.readByte() == r117) goto L46;
        boolean r120 = true;
    L47:
        this.newStyleWithTab = r120;
        Object r121 = r100.readValue(r101.getClassLoader());
        if ((r121 instanceof Boolean) == false) goto L51;
        r103 = r121;
    L51:
        this.mHasClickChildren = (Boolean) r103;
        this.subBoardWidth = r100.readInt();
        this.animationConfig = (AnimationConfig) r100.readParcelable(AnimationConfig.class.getClassLoader());
        if (r100.readByte() == r117) goto L54;
        r116 = true;
    L54:
        this.needCombineWithSpecify = r116;
        this.tipConfig = (TipConfig) r100.readParcelable(TipConfig.class.getClassLoader());
        return;
    L46:
        r120 = false;
        goto L47
    L42:
        r119 = false;
        goto L43
    L38:
        r118 = false;
        goto L39
    }

    public final void setAnimationConfig(AnimationConfig r100) {
        this.animationConfig = r100;
    }

    public final void setAvoidBoardBottomPadding(boolean r100) {
        this.f450524j = r100;
    }

    public final void setBarConfigs(List<FilterBarConfig> r100) {
        this.barConfigs = r100;
    }

    public final void setBoardExtraTranslation(Integer r100) {
        this.boardExtraTranslation = r100;
    }

    public final void setBusinessItem(BusinessItem r100) {
        this.f450515a = r100;
    }

    public final void setChildrenComponent(List<RenderItem> r100) {
        this.childrenComponent = r100;
    }

    public final void setClickToastInfo(ClickToastInfo r100) {
        this.clickToastInfo = r100;
    }

    public final void setColumnCount(Integer r100) {
        this.columnCount = r100;
    }

    public final void setComponentId(String r100) {
        this.componentId = r100;
    }

    public final void setComponentType(String r100) {
        this.componentType = r100;
    }

    public final void setCountTabType(String r100) {
        this.countTabType = r100;
    }

    public final void setCounterElection(Boolean r100) {
        this.counterElection = r100;
    }

    public final void setCurSelected(boolean r100) {
        this.f450528n = r100;
    }

    public final void setCurrentStatus(SelectItemStatus r100) {
        this.f450525k = r100;
    }

    public final void setCustomOrder(Integer r100) {
        this.customOrder = r100;
    }

    public final void setDataId(String r100) {
        this.dataId = r100;
    }

    public final void setDefaultSelect(Boolean r100) {
        this.isDefaultSelect = r100;
    }

    public final void setDefaultShowCount(Integer r100) {
        this.defaultShowCount = r100;
    }

    public final void setDisableCounter(Boolean r100) {
        this.disableCounter = r100;
    }

    public final void setDisableSelected(Boolean r100) {
        this.disableSelected = r100;
    }

    public final void setEndTime(String r100) {
        this.endTime = r100;
    }

    public final void setEnglishText(String r100) {
        this.englishText = r100;
    }

    public final void setExpiredTime(long r100) {
        this.expiredTime = r100;
    }

    public final void setFilterBoardNewStyle(boolean r100) {
        this.filterBoardNewStyle = r100;
    }

    public final void setFilterBoardSidebarShow(boolean r100) {
        this.filterBoardSidebarShow = r100;
    }

    public final void setFilterLogParams(FilterLogParams r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f450527m = r100;
    }

    public final void setFilterOptionRank(String r100) {
        this.f450522h = r100;
    }

    public final void setFilterOptionRow(String r100) {
        this.f450521g = r100;
    }

    public final void setFixedPosition(int r100) {
        this.fixedPosition = r100;
    }

    public final void setGradualChangeEnable(Boolean r100) {
        this.gradualChangeEnable = r100;
    }

    public final void setGroupId(String r100) {
        this.groupId = r100;
    }

    public final void setHeadText(String r100) {
        this.headText = r100;
    }

    public final void setHeight(Float r100) {
        this.height = r100;
    }

    public final void setHideParentItem(boolean r100) {
        this.hideParentItem = r100;
    }

    public final void setImprId(String r100) {
        this.f450531q = r100;
    }

    public final void setInnerBottomPadding(int r100) {
        this.innerBottomPadding = r100;
    }

    public final void setInnerLeftPadding(int r100) {
        this.innerLeftPadding = r100;
    }

    public final void setInnerRightPadding(int r100) {
        this.innerRightPadding = r100;
    }

    public final void setInnerTopPadding(int r100) {
        this.innerTopPadding = r100;
    }

    public final void setInvalidText(String r100) {
        this.invalidText = r100;
    }

    public final void setLeftPostscriptText(String r100) {
        this.leftPostscriptText = r100;
    }

    public final void setLeftText(String r100) {
        this.leftText = r100;
    }

    public final void setListLevelNum(Integer r100) {
        this.listLevelNum = r100;
    }

    public final void setMHasClickChildren(Boolean r100) {
        this.mHasClickChildren = r100;
    }

    public final void setManualSelected(boolean r100) {
        this.f450529o = r100;
    }

    public final void setNeedCombineWithSpecify(boolean r100) {
        this.needCombineWithSpecify = r100;
    }

    public final void setNeedMutex(String r100) {
        this.needMutex = r100;
    }

    public final void setNewStyleWithTab(boolean r100) {
        this.newStyleWithTab = r100;
    }

    public final void setPanelItemWidthStrategy(int r100) {
        this.panelItemWidthStrategy = r100;
    }

    public final void setParentRenderItem(RenderItem r100) {
        this.f450517c = r100;
    }

    public final void setPinToTop(Integer r100) {
        this.pinToTop = r100;
    }

    public final void setPostscriptText(String r100) {
        this.postscriptText = r100;
    }

    public final void setPriceSortType(int r100) {
        this.priceSortType = r100;
    }

    public final void setQueryId(String r100) {
        this.f450530p = r100;
    }

    public final void setRenderLine(RenderLine r100) {
        this.f450518d = r100;
    }

    public final void setRenderView(BaseSelectItemView r100) {
        this.f450520f = r100;
    }

    public final void setRequestType(int r100) {
        this.requestType = r100;
    }

    public final void setRightPostscriptText(String r100) {
        this.rightPostscriptText = r100;
    }

    public final void setRightText(String r100) {
        this.rightText = r100;
    }

    public final void setSelectInfoDataType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f450519e = r100;
    }

    public final void setSelectedHeadText(String r100) {
        this.selectedHeadText = r100;
    }

    public final void setSelectedParentText(String r100) {
        this.selectedParentText = r100;
    }

    public final void setShouldShowAsManualSelectWhenDefaultSelect(Boolean r100) {
        this.shouldShowAsManualSelectWhenDefaultSelect = r100;
    }

    public final void setShouldUseGSUpdateInfo(boolean r100) {
        this.f450532r = r100;
    }

    public final void setStatusPath(String r100) {
        this.f450523i = r100;
    }

    public final void setStyleId(String r100) {
        this.styleId = r100;
    }

    public final void setStyleItem(StyleItem r100) {
        this.f450516b = r100;
    }

    public final void setSubBoardWidth(int r100) {
        this.subBoardWidth = r100;
    }

    public final void setSubText(String r100) {
        this.subText = r100;
    }

    public final void setTabType(String r100) {
        this.tabType = r100;
    }

    public final void setTailText(String r100) {
        this.tailText = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setTextType(String r100) {
        this.textType = r100;
    }

    public final void setTipConfig(TipConfig r100) {
        this.tipConfig = r100;
    }

    public final void setUiMode(Integer r100) {
        this.f450526l = r100;
    }

    public final void setUniqueId(String r100) {
        this.uniqueId = r100;
    }

    public final void setUseTextWhenDefaultSelect(Boolean r100) {
        this.useTextWhenDefaultSelect = r100;
    }

    public final void setValidText(String r100) {
        this.validText = r100;
    }

    public final void setWidth(Float r100) {
        this.width = r100;
    }

    public final void updateStatusOfRenderTree(SelectItemStatus r100) {
        this.f450525k = r100;
        BaseSelectItemView r101 = this.f450520f;
        if (r101 == null) goto L8;
        if (r100 == null) goto L6;
        boolean r102 = true;
    L7:
        r101.h(r102);
        goto L8
    L6:
        r102 = false;
    L8:
        BaseSelectItemView r103 = this.f450520f;
        if (r103 == null) goto L11;
        r103.f(this);
    L11:
        RenderItem r104 = this.f450517c;
        if (r104 == null) goto L14;
        String r105 = r104.dataId;
    L15:
        if (r105 != null) goto L20;
        if (r104 == null) goto L20;
        BaseSelectItemView r106 = r104.f450520f;
        if (r106 == null) goto L20;
        r106.e(r104.getSubSelectStatus());
    L20:
        RenderItem r107 = this.f450517c;
        if (r107 == null) goto L26;
        if (r107 == null) goto L30;
        BaseSelectItemView r108 = r107.f450520f;
        if (r108 == null) goto L31;
        r108.d(r100);
        return;
    L31:
        return;
    L30:
        return;
    L26:
        BaseSelectItemView r109 = this.f450520f;
        if (r109 == null) goto L33;
        r109.d(r100);
        return;
    L33:
        return;
    L14:
        r105 = null;
        goto L15
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.uniqueId);
        r100.writeString(this.componentId);
        r100.writeString(this.dataId);
        r100.writeString(this.styleId);
        r100.writeString(this.text);
        r100.writeString(this.leftText);
        r100.writeString(this.leftPostscriptText);
        r100.writeString(this.rightText);
        r100.writeString(this.rightPostscriptText);
        r100.writeString(this.selectedHeadText);
        r100.writeString(this.headText);
        r100.writeString(this.tailText);
        r100.writeString(this.postscriptText);
        r100.writeString(this.englishText);
        r100.writeTypedList(this.childrenComponent);
        r100.writeString(this.needMutex);
        r100.writeValue(this.isDefaultSelect);
        r100.writeInt(this.priceSortType);
        r100.writeValue(this.disableSelected);
        r100.writeValue(this.counterElection);
        r100.writeValue(this.gradualChangeEnable);
        r100.writeValue(this.shouldShowAsManualSelectWhenDefaultSelect);
        r100.writeValue(this.useTextWhenDefaultSelect);
        r100.writeValue(this.width);
        r100.writeValue(this.height);
        r100.writeValue(this.columnCount);
        r100.writeValue(this.defaultShowCount);
        r100.writeString(this.componentType);
        r100.writeString(this.endTime);
        r100.writeValue(this.listLevelNum);
        r100.writeString(this.textType);
        r100.writeTypedList(this.barConfigs);
        r100.writeInt(this.innerLeftPadding);
        r100.writeInt(this.innerRightPadding);
        r100.writeInt(this.innerTopPadding);
        r100.writeInt(this.innerBottomPadding);
        r100.writeString(this.groupId);
        r100.writeString(this.subText);
        r100.writeInt(this.panelItemWidthStrategy);
        r100.writeString(this.tabType);
        r100.writeString(this.countTabType);
        r100.writeParcelable(this.clickToastInfo, r101);
        r100.writeByte(this.filterBoardNewStyle ? 1 : 0);
        r100.writeByte(this.filterBoardSidebarShow ? 1 : 0);
        r100.writeInt(this.fixedPosition);
        r100.writeByte(this.newStyleWithTab ? 1 : 0);
        r100.writeValue(this.mHasClickChildren);
        r100.writeInt(this.subBoardWidth);
        r100.writeParcelable(this.animationConfig, r101);
        r100.writeByte(this.needCombineWithSpecify ? 1 : 0);
        r100.writeParcelable(this.tipConfig, r101);
    }
}
