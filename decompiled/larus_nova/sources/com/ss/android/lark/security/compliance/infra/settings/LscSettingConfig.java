package com.ss.android.lark.security.compliance.infra.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import w4c.a;
import w4c.b;
import w4c.d;

/* JADX INFO: loaded from: classes38.dex */
@AppConfig(key = "lark_security_compliance_config")
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b \n\u0002\u0010\b\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0010$\n\u0003\b§\u0001\n\u0002\u0010\u0007\n\u0002\b\u001d\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001e\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001e\u0010\u001f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001e\u0010\"\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001e\u0010%\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR\u001e\u0010(\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R\u001e\u0010+\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR\u001e\u0010.\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR\u001e\u00101\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR\u001e\u00104\u001a\u0002058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010:\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0007\"\u0004\b<\u0010\tR\u001e\u0010=\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0007\"\u0004\b?\u0010\tR\u001e\u0010@\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0016\"\u0004\bB\u0010\u0018R\u001e\u0010C\u001a\u0002058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u00107\"\u0004\bE\u00109R\u001e\u0010F\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0016\"\u0004\bH\u0010\u0018R\u001e\u0010I\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0007\"\u0004\bK\u0010\tR\u001e\u0010L\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0007\"\u0004\bN\u0010\tR\u001e\u0010O\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0007\"\u0004\bQ\u0010\tR\u001e\u0010R\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0007\"\u0004\bT\u0010\tR\u001e\u0010U\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0007\"\u0004\bW\u0010\tR\u001e\u0010X\u001a\u00020Y8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001e\u0010^\u001a\u00020_8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001e\u0010d\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u0007\"\u0004\bf\u0010\tR\u001e\u0010g\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u0007\"\u0004\bi\u0010\tR\u001e\u0010j\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u0007\"\u0004\bl\u0010\tR\u001e\u0010m\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\u0016\"\u0004\bo\u0010\u0018R\u001e\u0010p\u001a\u0002058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u00107\"\u0004\br\u00109R\u001e\u0010s\u001a\u0002058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u00107\"\u0004\bu\u00109R\u001e\u0010v\u001a\u0002058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u00107\"\u0004\bx\u00109R\u001e\u0010y\u001a\u0002058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u00107\"\u0004\b{\u00109R\u001e\u0010|\u001a\u0002058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u00107\"\u0004\b~\u00109R \u0010\u007f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010\u0007\"\u0005\b\u0081\u0001\u0010\tR!\u0010\u0082\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u0007\"\u0005\b\u0084\u0001\u0010\tR!\u0010\u0085\u0001\u001a\u0002058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u00107\"\u0005\b\u0087\u0001\u00109R!\u0010\u0088\u0001\u001a\u0002058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u00107\"\u0005\b\u008a\u0001\u00109R!\u0010\u008b\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010\u0007\"\u0005\b\u008d\u0001\u0010\tR!\u0010\u008e\u0001\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010\u0016\"\u0005\b\u0090\u0001\u0010\u0018R!\u0010\u0091\u0001\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010\u0016\"\u0005\b\u0093\u0001\u0010\u0018R!\u0010\u0094\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010\u0007\"\u0005\b\u0096\u0001\u0010\tR!\u0010\u0097\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010\u0007\"\u0005\b\u0099\u0001\u0010\tR$\u0010\u009a\u0001\u001a\u00030\u009b\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001R,\u0010 \u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¡\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¢\u0001\u0010£\u0001\"\u0006\b¤\u0001\u0010¥\u0001R-\u0010¦\u0001\u001a\f\u0012\u0005\u0012\u00030§\u0001\u0018\u00010¡\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¨\u0001\u0010£\u0001\"\u0006\b©\u0001\u0010¥\u0001R-\u0010ª\u0001\u001a\f\u0012\u0005\u0012\u00030§\u0001\u0018\u00010¡\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b«\u0001\u0010£\u0001\"\u0006\b¬\u0001\u0010¥\u0001R-\u0010\u00ad\u0001\u001a\f\u0012\u0005\u0012\u00030§\u0001\u0018\u00010¡\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b®\u0001\u0010£\u0001\"\u0006\b¯\u0001\u0010¥\u0001R!\u0010°\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0001\u0010\u0007\"\u0005\b²\u0001\u0010\tR-\u0010³\u0001\u001a\f\u0012\u0005\u0012\u00030§\u0001\u0018\u00010¡\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b´\u0001\u0010£\u0001\"\u0006\bµ\u0001\u0010¥\u0001R-\u0010¶\u0001\u001a\f\u0012\u0005\u0012\u00030§\u0001\u0018\u00010¡\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b·\u0001\u0010£\u0001\"\u0006\b¸\u0001\u0010¥\u0001R-\u0010¹\u0001\u001a\f\u0012\u0005\u0012\u00030§\u0001\u0018\u00010¡\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bº\u0001\u0010£\u0001\"\u0006\b»\u0001\u0010¥\u0001R-\u0010¼\u0001\u001a\f\u0012\u0005\u0012\u00030§\u0001\u0018\u00010¡\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b½\u0001\u0010£\u0001\"\u0006\b¾\u0001\u0010¥\u0001R-\u0010¿\u0001\u001a\f\u0012\u0005\u0012\u00030§\u0001\u0018\u00010¡\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÀ\u0001\u0010£\u0001\"\u0006\bÁ\u0001\u0010¥\u0001R!\u0010Â\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÃ\u0001\u0010\u0007\"\u0005\bÄ\u0001\u0010\tR$\u0010Å\u0001\u001a\u00030§\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÆ\u0001\u0010Ç\u0001\"\u0006\bÈ\u0001\u0010É\u0001R$\u0010Ê\u0001\u001a\u00030§\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bË\u0001\u0010Ç\u0001\"\u0006\bÌ\u0001\u0010É\u0001R2\u0010Í\u0001\u001a\u0011\u0012\u0005\u0012\u00030§\u0001\u0012\u0005\u0012\u00030§\u00010Î\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÏ\u0001\u0010Ð\u0001\"\u0006\bÑ\u0001\u0010Ò\u0001R!\u0010Ó\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÔ\u0001\u0010\u0007\"\u0005\bÕ\u0001\u0010\tR!\u0010Ö\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b×\u0001\u0010\u0007\"\u0005\bØ\u0001\u0010\tR!\u0010Ù\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÚ\u0001\u0010\u0007\"\u0005\bÛ\u0001\u0010\tR!\u0010Ü\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÝ\u0001\u0010\u0007\"\u0005\bÞ\u0001\u0010\tR!\u0010ß\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bà\u0001\u0010\u0007\"\u0005\bá\u0001\u0010\tR!\u0010â\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bã\u0001\u0010\u0007\"\u0005\bä\u0001\u0010\tR$\u0010å\u0001\u001a\u00030§\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bæ\u0001\u0010Ç\u0001\"\u0006\bç\u0001\u0010É\u0001R!\u0010è\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bé\u0001\u0010\u0007\"\u0005\bê\u0001\u0010\tR!\u0010ë\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bì\u0001\u0010\u0007\"\u0005\bí\u0001\u0010\tR+\u0010î\u0001\u001a\n\u0012\u0005\u0012\u00030§\u00010¡\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bï\u0001\u0010£\u0001\"\u0006\bð\u0001\u0010¥\u0001R!\u0010ñ\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bò\u0001\u0010\u0007\"\u0005\bó\u0001\u0010\tR!\u0010ô\u0001\u001a\u0002058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bõ\u0001\u00107\"\u0005\bö\u0001\u00109R!\u0010÷\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bø\u0001\u0010\u0007\"\u0005\bù\u0001\u0010\tR!\u0010ú\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bû\u0001\u0010\u0007\"\u0005\bü\u0001\u0010\tR!\u0010ý\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bþ\u0001\u0010\u0007\"\u0005\bÿ\u0001\u0010\tR!\u0010\u0080\u0002\u001a\u0002058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0002\u00107\"\u0005\b\u0082\u0002\u00109R!\u0010\u0083\u0002\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0002\u0010\u0016\"\u0005\b\u0085\u0002\u0010\u0018R!\u0010\u0086\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0002\u0010\u0007\"\u0005\b\u0088\u0002\u0010\tR!\u0010\u0089\u0002\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0002\u0010\u0016\"\u0005\b\u008b\u0002\u0010\u0018R!\u0010\u008c\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0002\u0010\u0007\"\u0005\b\u008e\u0002\u0010\tR!\u0010\u008f\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0002\u0010\u0007\"\u0005\b\u0091\u0002\u0010\tR!\u0010\u0092\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0002\u0010\u0007\"\u0005\b\u0094\u0002\u0010\tR!\u0010\u0095\u0002\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0002\u0010\u0016\"\u0005\b\u0097\u0002\u0010\u0018R!\u0010\u0098\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0002\u0010\u0007\"\u0005\b\u009a\u0002\u0010\tR!\u0010\u009b\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0002\u0010\u0007\"\u0005\b\u009d\u0002\u0010\tR!\u0010\u009e\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0002\u0010\u0007\"\u0005\b \u0002\u0010\tR!\u0010¡\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¢\u0002\u0010\u0007\"\u0005\b£\u0002\u0010\tR!\u0010¤\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0002\u0010\u0007\"\u0005\b¦\u0002\u0010\tR+\u0010§\u0002\u001a\n\u0012\u0005\u0012\u00030§\u00010¡\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¨\u0002\u0010£\u0001\"\u0006\b©\u0002\u0010¥\u0001R!\u0010ª\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b«\u0002\u0010\u0007\"\u0005\b¬\u0002\u0010\tR!\u0010\u00ad\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b®\u0002\u0010\u0007\"\u0005\b¯\u0002\u0010\tR!\u0010°\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0002\u0010\u0007\"\u0005\b²\u0002\u0010\tR!\u0010³\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b´\u0002\u0010\u0007\"\u0005\bµ\u0002\u0010\tR!\u0010¶\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b·\u0002\u0010\u0007\"\u0005\b¸\u0002\u0010\tR!\u0010¹\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bº\u0002\u0010\u0007\"\u0005\b»\u0002\u0010\tR+\u0010¼\u0002\u001a\n\u0012\u0005\u0012\u00030§\u00010¡\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b½\u0002\u0010£\u0001\"\u0006\b¾\u0002\u0010¥\u0001R+\u0010¿\u0002\u001a\n\u0012\u0005\u0012\u00030§\u00010¡\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÀ\u0002\u0010£\u0001\"\u0006\bÁ\u0002\u0010¥\u0001R+\u0010Â\u0002\u001a\n\u0012\u0005\u0012\u00030§\u00010¡\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÃ\u0002\u0010£\u0001\"\u0006\bÄ\u0002\u0010¥\u0001R!\u0010Å\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÆ\u0002\u0010\u0007\"\u0005\bÇ\u0002\u0010\tR!\u0010È\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÉ\u0002\u0010\u0007\"\u0005\bÊ\u0002\u0010\tR!\u0010Ë\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÌ\u0002\u0010\u0007\"\u0005\bÍ\u0002\u0010\tR$\u0010Î\u0002\u001a\u00030§\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÏ\u0002\u0010Ç\u0001\"\u0006\bÐ\u0002\u0010É\u0001R!\u0010Ñ\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÒ\u0002\u0010\u0007\"\u0005\bÓ\u0002\u0010\tR!\u0010Ô\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÕ\u0002\u0010\u0007\"\u0005\bÖ\u0002\u0010\tR!\u0010×\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bØ\u0002\u0010\u0007\"\u0005\bÙ\u0002\u0010\tR!\u0010Ú\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÛ\u0002\u0010\u0007\"\u0005\bÜ\u0002\u0010\tR!\u0010Ý\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÞ\u0002\u0010\u0007\"\u0005\bß\u0002\u0010\tR!\u0010à\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bá\u0002\u0010\u0007\"\u0005\bâ\u0002\u0010\tR!\u0010ã\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bä\u0002\u0010\u0007\"\u0005\bå\u0002\u0010\tR!\u0010æ\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bç\u0002\u0010\u0007\"\u0005\bè\u0002\u0010\tR!\u0010é\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bê\u0002\u0010\u0007\"\u0005\bë\u0002\u0010\tR!\u0010ì\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bí\u0002\u0010\u0007\"\u0005\bî\u0002\u0010\tR!\u0010ï\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bð\u0002\u0010\u0007\"\u0005\bñ\u0002\u0010\tR!\u0010ò\u0002\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bó\u0002\u0010\u0016\"\u0005\bô\u0002\u0010\u0018R$\u0010õ\u0002\u001a\u00030ö\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b÷\u0002\u0010ø\u0002\"\u0006\bù\u0002\u0010ú\u0002R!\u0010û\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bü\u0002\u0010\u0007\"\u0005\bý\u0002\u0010\tR!\u0010þ\u0002\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÿ\u0002\u0010\u0007\"\u0005\b\u0080\u0003\u0010\tR!\u0010\u0081\u0003\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0003\u0010\u0007\"\u0005\b\u0083\u0003\u0010\tR!\u0010\u0084\u0003\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0003\u0010\u0007\"\u0005\b\u0086\u0003\u0010\tR!\u0010\u0087\u0003\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0003\u0010\u0007\"\u0005\b\u0089\u0003\u0010\tR-\u0010\u008a\u0003\u001a\f\u0012\u0005\u0012\u00030§\u0001\u0018\u00010¡\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008b\u0003\u0010£\u0001\"\u0006\b\u008c\u0003\u0010¥\u0001R!\u0010\u008d\u0003\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0003\u0010\u0016\"\u0005\b\u008f\u0003\u0010\u0018R!\u0010\u0090\u0003\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0003\u0010\u0007\"\u0005\b\u0092\u0003\u0010\t¨\u0006\u0093\u0003"}, d2 = {"Lcom/ss/android/lark/security/compliance/infra/settings/LscSettingConfig;", "", "<init>", "()V", "conditionAccessDisabled", "", "getConditionAccessDisabled", "()Z", "setConditionAccessDisabled", "(Z)V", "skipDoubaoConditionalAccessHandler", "getSkipDoubaoConditionalAccessHandler", "setSkipDoubaoConditionalAccessHandler", "enableDoubaoActionHandle", "getEnableDoubaoActionHandle", "setEnableDoubaoActionHandle", "disableDoubaoPing", "getDisableDoubaoPing", "setDisableDoubaoPing", "doubaoPingDelayMs", "", "getDoubaoPingDelayMs", "()J", "setDoubaoPingDelayMs", "(J)V", "rootAndEmulatorDetectDisable", "getRootAndEmulatorDetectDisable", "setRootAndEmulatorDetectDisable", "rootAndEmulatorDetectKaEnable", "getRootAndEmulatorDetectKaEnable", "setRootAndEmulatorDetectKaEnable", "screenProtectionDisabled", "getScreenProtectionDisabled", "setScreenProtectionDisabled", "advancedLoginDynamicDisplayDisabled", "getAdvancedLoginDynamicDisplayDisabled", "setAdvancedLoginDynamicDisplayDisabled", "enablePolicyCenterSubRichText", "getEnablePolicyCenterSubRichText", "setEnablePolicyCenterSubRichText", "policyCenterSameDisplayIdCoolingSeconds", "getPolicyCenterSameDisplayIdCoolingSeconds", "setPolicyCenterSameDisplayIdCoolingSeconds", "disablePolicyCenterSameDisplayIdActionDedup", "getDisablePolicyCenterSameDisplayIdActionDedup", "setDisablePolicyCenterSameDisplayIdActionDedup", "enablePolicyCenterPlainHttpUrlParse", "getEnablePolicyCenterPlainHttpUrlParse", "setEnablePolicyCenterPlainHttpUrlParse", "scsMonitorEnable", "getScsMonitorEnable", "setScsMonitorEnable", "heartbeatInterval", "", "getHeartbeatInterval", "()I", "setHeartbeatInterval", "(I)V", "enablePolicyEngine", "getEnablePolicyEngine", "setEnablePolicyEngine", "disableStrategyEngineLocalValidate", "getDisableStrategyEngineLocalValidate", "setDisableStrategyEngineLocalValidate", "policyEngineFetchPolicyInterval", "getPolicyEngineFetchPolicyInterval", "setPolicyEngineFetchPolicyInterval", "policyEngineLocalValidateCountLimit", "getPolicyEngineLocalValidateCountLimit", "setPolicyEngineLocalValidateCountLimit", "policyEnginePointCutRetryDelay", "getPolicyEnginePointCutRetryDelay", "setPolicyEnginePointCutRetryDelay", "disable_file_operate", "getDisable_file_operate", "setDisable_file_operate", "disable_file_strategy", "getDisable_file_strategy", "setDisable_file_strategy", "file_strategy_fallback_result", "getFile_strategy_fallback_result", "setFile_strategy_fallback_result", "disable_file_strategy_share_cache", "getDisable_file_strategy_share_cache", "setDisable_file_strategy_share_cache", "disable_file_strategy_share", "getDisable_file_strategy_share", "setDisable_file_strategy_share", "dynamic_pointkey_max_cache_size", "Lcom/ss/android/lark/security/compliance/infra/settings/DynamicPointkeyMaxCache;", "getDynamic_pointkey_max_cache_size", "()Lcom/ss/android/lark/security/compliance/infra/settings/DynamicPointkeyMaxCache;", "setDynamic_pointkey_max_cache_size", "(Lcom/ss/android/lark/security/compliance/infra/settings/DynamicPointkeyMaxCache;)V", "dynamicPointKeyMaxCacheSizeV2", "Lcom/ss/android/lark/security/compliance/infra/settings/DynamicPointKeyMaxCacheV2;", "getDynamicPointKeyMaxCacheSizeV2", "()Lcom/ss/android/lark/security/compliance/infra/settings/DynamicPointKeyMaxCacheV2;", "setDynamicPointKeyMaxCacheSizeV2", "(Lcom/ss/android/lark/security/compliance/infra/settings/DynamicPointKeyMaxCacheV2;)V", "enableImReadPolicyCenter", "getEnableImReadPolicyCenter", "setEnableImReadPolicyCenter", "enableImReadInvalidDataOpt", "getEnableImReadInvalidDataOpt", "setEnableImReadInvalidDataOpt", "disableFileStrategyNoCacheRetryBatch", "getDisableFileStrategyNoCacheRetryBatch", "setDisableFileStrategyNoCacheRetryBatch", "imFileReadCacheExpiryTimeV2", "getImFileReadCacheExpiryTimeV2", "setImFileReadCacheExpiryTimeV2", "file_strategy_retry_delay_time", "getFile_strategy_retry_delay_time", "setFile_strategy_retry_delay_time", "file_strategy_retry_max_count", "getFile_strategy_retry_max_count", "setFile_strategy_retry_max_count", "file_strategy_delay_clean_time", "getFile_strategy_delay_clean_time", "setFile_strategy_delay_clean_time", "file_strategy_delay_clean_inaccuracy", "getFile_strategy_delay_clean_inaccuracy", "setFile_strategy_delay_clean_inaccuracy", "file_strategy_update_frequency_control", "getFile_strategy_update_frequency_control", "setFile_strategy_update_frequency_control", "appBackgroundShowToast", "getAppBackgroundShowToast", "setAppBackgroundShowToast", "disableHandleSecurityAction", "getDisableHandleSecurityAction", "setDisableHandleSecurityAction", "imFileReadLruCache", "getImFileReadLruCache", "setImFileReadLruCache", "lruCacheSize", "getLruCacheSize", "setLruCacheSize", "disableDynamicCache", "getDisableDynamicCache", "setDisableDynamicCache", "dlpMaxCheckTime", "getDlpMaxCheckTime", "setDlpMaxCheckTime", "dlpPeriodOfValidity", "getDlpPeriodOfValidity", "setDlpPeriodOfValidity", "disablePasteProtectMenu", "getDisablePasteProtectMenu", "setDisablePasteProtectMenu", "enableDIALControl", "getEnableDIALControl", "setEnableDIALControl", "exemptMIUIPageConfig", "Lcom/ss/android/lark/security/compliance/infra/settings/PasteProtectMIUIWhiteList;", "getExemptMIUIPageConfig", "()Lcom/ss/android/lark/security/compliance/infra/settings/PasteProtectMIUIWhiteList;", "setExemptMIUIPageConfig", "(Lcom/ss/android/lark/security/compliance/infra/settings/PasteProtectMIUIWhiteList;)V", "securityAuditDeprecatedPermType", "", "getSecurityAuditDeprecatedPermType", "()Ljava/util/List;", "setSecurityAuditDeprecatedPermType", "(Ljava/util/List;)V", "logReportFilterPolicySetKeys", "", "getLogReportFilterPolicySetKeys", "setLogReportFilterPolicySetKeys", "logDeleteFilterPolicySetKeys", "getLogDeleteFilterPolicySetKeys", "setLogDeleteFilterPolicySetKeys", "networkMonitorBlocklist", "getNetworkMonitorBlocklist", "setNetworkMonitorBlocklist", "supportPrimaryClipExtraMethod", "getSupportPrimaryClipExtraMethod", "setSupportPrimaryClipExtraMethod", "primaryClipSetExtraMethods", "getPrimaryClipSetExtraMethods", "setPrimaryClipSetExtraMethods", "primaryClipGetDescriptionExtraMethods", "getPrimaryClipGetDescriptionExtraMethods", "setPrimaryClipGetDescriptionExtraMethods", "primaryClipHasExtraMethods", "getPrimaryClipHasExtraMethods", "setPrimaryClipHasExtraMethods", "primaryClipClearExtraMethods", "getPrimaryClipClearExtraMethods", "setPrimaryClipClearExtraMethods", "primaryClipGetExtraMethods", "getPrimaryClipGetExtraMethods", "setPrimaryClipGetExtraMethods", "enableEncryptPreCheck", "getEnableEncryptPreCheck", "setEnableEncryptPreCheck", "fileWatermarkSceneType", "getFileWatermarkSceneType", "()Ljava/lang/String;", "setFileWatermarkSceneType", "(Ljava/lang/String;)V", "fileWatermarkPointKey", "getFileWatermarkPointKey", "setFileWatermarkPointKey", "fileWatermarkPointParam", "", "getFileWatermarkPointParam", "()Ljava/util/Map;", "setFileWatermarkPointParam", "(Ljava/util/Map;)V", "enableMeetingMinutesFileStrategy", "getEnableMeetingMinutesFileStrategy", "setEnableMeetingMinutesFileStrategy", "enableCalendarFileStrategy", "getEnableCalendarFileStrategy", "setEnableCalendarFileStrategy", "streamCipherMode", "getStreamCipherMode", "setStreamCipherMode", "enableFileBizDomainFilter", "getEnableFileBizDomainFilter", "setEnableFileBizDomainFilter", "enableLgwStorage", "getEnableLgwStorage", "setEnableLgwStorage", "lgwStorageAsync", "getLgwStorageAsync", "setLgwStorageAsync", "deviceHcArticle", "getDeviceHcArticle", "setDeviceHcArticle", "enableSdkPushNotification", "getEnableSdkPushNotification", "setEnableSdkPushNotification", "enableFilePolicyLogOpt", "getEnableFilePolicyLogOpt", "setEnableFilePolicyLogOpt", "securityPolicyIpFactors", "getSecurityPolicyIpFactors", "setSecurityPolicyIpFactors", "enableLocalKeyPair", "getEnableLocalKeyPair", "setEnableLocalKeyPair", "teeKeypairMaxFailureCount", "getTeeKeypairMaxFailureCount", "setTeeKeypairMaxFailureCount", "enableWatermarkOomOpt", "getEnableWatermarkOomOpt", "setEnableWatermarkOomOpt", "enableSecurityActionPlugin", "getEnableSecurityActionPlugin", "setEnableSecurityActionPlugin", "enableUrlSlashOpt", "getEnableUrlSlashOpt", "setEnableUrlSlashOpt", "fileProtectPeriodOfValidity", "getFileProtectPeriodOfValidity", "setFileProtectPeriodOfValidity", "customDisplayConfigExpirationTime", "getCustomDisplayConfigExpirationTime", "setCustomDisplayConfigExpirationTime", "enableCustomDialog", "getEnableCustomDialog", "setEnableCustomDialog", "customDisplayConfigLoadTimeout", "getCustomDisplayConfigLoadTimeout", "setCustomDisplayConfigLoadTimeout", "enableSecurityLabelControlCheck", "getEnableSecurityLabelControlCheck", "setEnableSecurityLabelControlCheck", "enableSecurityLabelCcmTimer", "getEnableSecurityLabelCcmTimer", "setEnableSecurityLabelCcmTimer", "fragmentBinderOpt", "getFragmentBinderOpt", "setFragmentBinderOpt", "securityPolicyMinimumPushInterval", "getSecurityPolicyMinimumPushInterval", "setSecurityPolicyMinimumPushInterval", "enableJudgeVirtualFile", "getEnableJudgeVirtualFile", "setEnableJudgeVirtualFile", "enableMimeJudgeOpt", "getEnableMimeJudgeOpt", "setEnableMimeJudgeOpt", "grantTokenSwitch", "getGrantTokenSwitch", "setGrantTokenSwitch", "enablePolicyCenterNewDialog", "getEnablePolicyCenterNewDialog", "setEnablePolicyCenterNewDialog", "enableWebInterceptor", "getEnableWebInterceptor", "setEnableWebInterceptor", "webInterceptorAppIdWhitelist", "getWebInterceptorAppIdWhitelist", "setWebInterceptorAppIdWhitelist", "enableMinutesDynamicCache", "getEnableMinutesDynamicCache", "setEnableMinutesDynamicCache", "enableMeetingMinutesCcmEntityDynamicCache", "getEnableMeetingMinutesCcmEntityDynamicCache", "setEnableMeetingMinutesCcmEntityDynamicCache", "enableMinutesFileTimer", "getEnableMinutesFileTimer", "setEnableMinutesFileTimer", "enableCalendarEntityDynamicCache", "getEnableCalendarEntityDynamicCache", "setEnableCalendarEntityDynamicCache", "disablePolicyCenterWiki", "getDisablePolicyCenterWiki", "setDisablePolicyCenterWiki", "androidUseNewTaskId", "getAndroidUseNewTaskId", "setAndroidUseNewTaskId", "policyCenterMobilePointkeys", "getPolicyCenterMobilePointkeys", "setPolicyCenterMobilePointkeys", "decisionCacheTTLPointKeys", "getDecisionCacheTTLPointKeys", "setDecisionCacheTTLPointKeys", "policyCenterClearCachePointKeys", "getPolicyCenterClearCachePointKeys", "setPolicyCenterClearCachePointKeys", "enableCertificateAuthentication", "getEnableCertificateAuthentication", "setEnableCertificateAuthentication", "enableDeviceMtlsByOkhttp", "getEnableDeviceMtlsByOkhttp", "setEnableDeviceMtlsByOkhttp", "enableDeviceMtlsByOkhttpHuawei", "getEnableDeviceMtlsByOkhttpHuawei", "setEnableDeviceMtlsByOkhttpHuawei", "deviceCertificateMtlsDomain", "getDeviceCertificateMtlsDomain", "setDeviceCertificateMtlsDomain", "enableAndroidUserscopeRustFetcher", "getEnableAndroidUserscopeRustFetcher", "setEnableAndroidUserscopeRustFetcher", "enableOpenUrlWithActivityContext", "getEnableOpenUrlWithActivityContext", "setEnableOpenUrlWithActivityContext", "androidTrafficSubthread", "getAndroidTrafficSubthread", "setAndroidTrafficSubthread", "enableMtlsLocale", "getEnableMtlsLocale", "setEnableMtlsLocale", "enableClearClientCertPreferences", "getEnableClearClientCertPreferences", "setEnableClearClientCertPreferences", "enableSkipSecurityDialogOnMdmAuth", "getEnableSkipSecurityDialogOnMdmAuth", "setEnableSkipSecurityDialogOnMdmAuth", "enableDoubaoWatermark", "getEnableDoubaoWatermark", "setEnableDoubaoWatermark", "enableDoubaoDialogWatermarkGlobalOnly", "getEnableDoubaoDialogWatermarkGlobalOnly", "setEnableDoubaoDialogWatermarkGlobalOnly", "enableDoubaoPolicyCenterPage", "getEnableDoubaoPolicyCenterPage", "setEnableDoubaoPolicyCenterPage", "enableGeoLocation", "getEnableGeoLocation", "setEnableGeoLocation", "enableEndpointLocationTimerMode", "getEnableEndpointLocationTimerMode", "setEnableEndpointLocationTimerMode", "endpointLocationIntervalMills", "getEndpointLocationIntervalMills", "setEndpointLocationIntervalMills", "emmGeoAccuracy", "", "getEmmGeoAccuracy", "()F", "setEmmGeoAccuracy", "(F)V", "enablePolicyCenterGeoButton", "getEnablePolicyCenterGeoButton", "setEnablePolicyCenterGeoButton", "enableGeoAuthFineGrainedToast", "getEnableGeoAuthFineGrainedToast", "setEnableGeoAuthFineGrainedToast", "enableGeoBackgroundLocation", "getEnableGeoBackgroundLocation", "setEnableGeoBackgroundLocation", "enableInterceptionRestoreOnLaunch", "getEnableInterceptionRestoreOnLaunch", "setEnableInterceptionRestoreOnLaunch", "enableGeoAuthRefreshUpload", "getEnableGeoAuthRefreshUpload", "setEnableGeoAuthRefreshUpload", "officeSDKNoPermissionCoverActivityWhitelist", "getOfficeSDKNoPermissionCoverActivityWhitelist", "setOfficeSDKNoPermissionCoverActivityWhitelist", "officeSDKScreenAuditDedupWindowMs", "getOfficeSDKScreenAuditDedupWindowMs", "setOfficeSDKScreenAuditDedupWindowMs", "androidDisablePsdaTokenFetch", "getAndroidDisablePsdaTokenFetch", "setAndroidDisablePsdaTokenFetch", "security-compliance-infra_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LscSettingConfig {

    @SerializedName("advanced_login_dynamic_display_disabled")
    private boolean advancedLoginDynamicDisplayDisabled;

    @SerializedName("android_disable_psda_token_fetch")
    private boolean androidDisablePsdaTokenFetch;

    @SerializedName("android_traffic_subthread")
    private boolean androidTrafficSubthread;

    @SerializedName("android_use_new_task_id")
    private boolean androidUseNewTaskId;

    @SerializedName("app_background_show_toast")
    private boolean appBackgroundShowToast;

    @SerializedName("condition_access_disabled")
    private boolean conditionAccessDisabled;

    @SerializedName("custom_display_config_expiration_time")
    private long customDisplayConfigExpirationTime;

    @SerializedName("custom_display_config_load_timeout")
    private long customDisplayConfigLoadTimeout;

    @SerializedName("decision_cache_ttl_point_keys")
    private List<String> decisionCacheTTLPointKeys;

    @SerializedName("device_certificate_mtls_domain")
    private String deviceCertificateMtlsDomain;

    @SerializedName("device_hc_article")
    private String deviceHcArticle;

    @SerializedName("disable_doubao_ping")
    private boolean disableDoubaoPing;

    @SerializedName("disable_dynamic_cache")
    private boolean disableDynamicCache;

    @SerializedName("disable_file_strategy_no_cache_retry_batch")
    private boolean disableFileStrategyNoCacheRetryBatch;

    @SerializedName("disable_handle_security_action")
    private boolean disableHandleSecurityAction;

    @SerializedName("disable_paste_protect_menu_opt")
    private boolean disablePasteProtectMenu;

    @SerializedName("disable_policy_center_same_display_id_action_dedup")
    private boolean disablePolicyCenterSameDisplayIdActionDedup;

    @SerializedName("disable_policy_center_wiki")
    private boolean disablePolicyCenterWiki;

    @SerializedName("policy_engine_disable_local_validate")
    private boolean disableStrategyEngineLocalValidate;

    @SerializedName("disable_file_operate")
    private boolean disable_file_operate;

    @SerializedName("disable_file_strategy")
    private boolean disable_file_strategy;

    @SerializedName("disable_file_strategy_share")
    private boolean disable_file_strategy_share;

    @SerializedName("disable_file_strategy_share_cache")
    private boolean disable_file_strategy_share_cache;

    @SerializedName("dlp_max_check_time")
    private long dlpMaxCheckTime;

    @SerializedName("dlp_period_of_validity")
    private long dlpPeriodOfValidity;

    @SerializedName("doubao_ping_delay_ms")
    private long doubaoPingDelayMs;

    @SerializedName("dynamic_pointkey_max_cache_size_v2")
    private a dynamicPointKeyMaxCacheSizeV2;

    @SerializedName("dynamic_pointkey_max_cache_size")
    private b dynamic_pointkey_max_cache_size;

    @SerializedName("emm_geo_accuracy")
    private float emmGeoAccuracy;

    @SerializedName("android_userscope_rust_fetcher")
    private boolean enableAndroidUserscopeRustFetcher;

    @SerializedName("enable_calendar_entity_dynamic_cache")
    private boolean enableCalendarEntityDynamicCache;

    @SerializedName("enable_calendar_file_strategy")
    private boolean enableCalendarFileStrategy;

    @SerializedName("enable_certificate_authentication")
    private boolean enableCertificateAuthentication;

    @SerializedName("enable_clear_client_cert_preferences")
    private boolean enableClearClientCertPreferences;

    @SerializedName("enable_custom_dialog")
    private boolean enableCustomDialog;

    @SerializedName("enable_miui_dial_control")
    private boolean enableDIALControl;

    @SerializedName("enable_device_mtls_by_okhttp")
    private boolean enableDeviceMtlsByOkhttp;

    @SerializedName("enable_device_mtls_by_okhttp_huawei")
    private boolean enableDeviceMtlsByOkhttpHuawei;

    @SerializedName("enable_doubao_action_handle")
    private boolean enableDoubaoActionHandle;

    @SerializedName("enable_doubao_dialog_watermark_global_only")
    private boolean enableDoubaoDialogWatermarkGlobalOnly;

    @SerializedName("enable_doubao_policy_center_page")
    private boolean enableDoubaoPolicyCenterPage;

    @SerializedName("enable_doubao_watermark")
    private boolean enableDoubaoWatermark;

    @SerializedName("enable_encrypt_pre_check")
    private boolean enableEncryptPreCheck;

    @SerializedName("enable_endpoint_location_timer_mode")
    private boolean enableEndpointLocationTimerMode;

    @SerializedName("enable_fileBizDomain_filter")
    private boolean enableFileBizDomainFilter;

    @SerializedName("enable_file_policy_log_opt")
    private boolean enableFilePolicyLogOpt;

    @SerializedName("enable_geo_auth_fine_grained_toast")
    private boolean enableGeoAuthFineGrainedToast;

    @SerializedName("enable_geo_auth_refresh_upload")
    private boolean enableGeoAuthRefreshUpload;

    @SerializedName("enable_geo_background_location")
    private boolean enableGeoBackgroundLocation;

    @SerializedName("enable_geo_location")
    private boolean enableGeoLocation;

    @SerializedName("enable_im_read_invalid_data_opt")
    private boolean enableImReadInvalidDataOpt;

    @SerializedName("enable_im_read_policy_center")
    private boolean enableImReadPolicyCenter;

    @SerializedName("enable_interception_restore_on_launch")
    private boolean enableInterceptionRestoreOnLaunch;

    @SerializedName("enable_judge_virtual_file")
    private boolean enableJudgeVirtualFile;

    @SerializedName("enable_lgw_storage")
    private boolean enableLgwStorage;

    @SerializedName("enable_local_keypair")
    private boolean enableLocalKeyPair;

    @SerializedName("enable_meeting_minutes_ccm_entity_dynamic_cache")
    private boolean enableMeetingMinutesCcmEntityDynamicCache;

    @SerializedName("enable_meeting_minutes_file_strategy")
    private boolean enableMeetingMinutesFileStrategy;

    @SerializedName("enable_mime_judge_opt")
    private boolean enableMimeJudgeOpt;

    @SerializedName("enable_minutes_dynamic_cache")
    private boolean enableMinutesDynamicCache;

    @SerializedName("enable_minutes_file_timer")
    private boolean enableMinutesFileTimer;

    @SerializedName("enable_mtls_locale")
    private boolean enableMtlsLocale;

    @SerializedName("enable_open_url_with_activity_context")
    private boolean enableOpenUrlWithActivityContext;

    @SerializedName("enable_policy_center_geo_button")
    private boolean enablePolicyCenterGeoButton;

    @SerializedName("enable_policy_center_new_dialog")
    private boolean enablePolicyCenterNewDialog;

    @SerializedName("enable_policy_center_plain_http_url_parse")
    private boolean enablePolicyCenterPlainHttpUrlParse;

    @SerializedName("enable_policy_center_sub_rich_text")
    private boolean enablePolicyCenterSubRichText;

    @SerializedName("enable_policy_engine")
    private boolean enablePolicyEngine;

    @SerializedName("enable_sdk_push_notification")
    private boolean enableSdkPushNotification;

    @SerializedName("enable_security_action_plugin")
    private boolean enableSecurityActionPlugin;

    @SerializedName("enable_security_label_ccm_timer")
    private boolean enableSecurityLabelCcmTimer;

    @SerializedName("enable_security_label_control_check")
    private boolean enableSecurityLabelControlCheck;

    @SerializedName("enable_skip_security_dialog_on_mdm_auth")
    private boolean enableSkipSecurityDialogOnMdmAuth;

    @SerializedName("enable_url_slash_opt")
    private boolean enableUrlSlashOpt;

    @SerializedName("enable_watermark_oom_opt")
    private boolean enableWatermarkOomOpt;

    @SerializedName("enable_web_interceptor")
    private boolean enableWebInterceptor;

    @SerializedName("endpoint_location_interval_mills")
    private long endpointLocationIntervalMills;

    @SerializedName("exempt_miui_menu_page_config")
    private d exemptMIUIPageConfig;

    @SerializedName("file_protect_period_of_validity")
    private int fileProtectPeriodOfValidity;

    @SerializedName("file_watermark_point_key")
    private String fileWatermarkPointKey;

    @SerializedName("file_watermark_point_param")
    private Map<String, String> fileWatermarkPointParam;

    @SerializedName("file_watermark_scene_type")
    private String fileWatermarkSceneType;

    @SerializedName("file_strategy_delay_clean_inaccuracy")
    private int file_strategy_delay_clean_inaccuracy;

    @SerializedName("file_strategy_delay_clean_time")
    private int file_strategy_delay_clean_time;

    @SerializedName("file_strategy_fallback_result")
    private boolean file_strategy_fallback_result;

    @SerializedName("file_strategy_retry_delay_time")
    private int file_strategy_retry_delay_time;

    @SerializedName("file_strategy_retry_max_count")
    private int file_strategy_retry_max_count;

    @SerializedName("file_strategy_update_frequency_control")
    private int file_strategy_update_frequency_control;

    @SerializedName("fragment_binder_opt")
    private boolean fragmentBinderOpt;

    @SerializedName("grant_token_switch")
    private boolean grantTokenSwitch;

    @SerializedName("login_restriction_heartbeat_interval")
    private int heartbeatInterval;

    @SerializedName("im_file_read_cache_expiry_time")
    private long imFileReadCacheExpiryTimeV2;

    @SerializedName("im_file_read_lruCache")
    private int imFileReadLruCache;

    @SerializedName("lgw_storage_async")
    private boolean lgwStorageAsync;

    @SerializedName("log_delete_filter_policy_set_keys")
    private List<String> logDeleteFilterPolicySetKeys;

    @SerializedName("log_report_filter_policy_set_keys")
    private List<String> logReportFilterPolicySetKeys;

    @SerializedName("lru_cache_size")
    private int lruCacheSize;

    @SerializedName("network_monitor_blocklist")
    private List<String> networkMonitorBlocklist;

    @SerializedName("office_sdk_no_permission_cover_activity_whitelist")
    private List<String> officeSDKNoPermissionCoverActivityWhitelist;

    @SerializedName("office_sdk_screen_audit_dedup_window_ms")
    private long officeSDKScreenAuditDedupWindowMs;

    @SerializedName("policy_center_clear_cache_point_keys")
    private List<String> policyCenterClearCachePointKeys;

    @SerializedName("policy_center_mobile_pointkeys")
    private List<String> policyCenterMobilePointkeys;

    @SerializedName("policy_center_same_display_id_cooling_seconds")
    private long policyCenterSameDisplayIdCoolingSeconds;

    @SerializedName("policy_engine_fetch_policy_interval")
    private long policyEngineFetchPolicyInterval;

    @SerializedName("policy_engine_local_validate_count_limit")
    private int policyEngineLocalValidateCountLimit;

    @SerializedName("policy_engine_pointcut_retry_delay")
    private long policyEnginePointCutRetryDelay;

    @SerializedName("primary_clip_clear_extra_methods")
    private List<String> primaryClipClearExtraMethods;

    @SerializedName("primary_clip_get_description_extra_methods")
    private List<String> primaryClipGetDescriptionExtraMethods;

    @SerializedName("primary_clip_get_extra_methods")
    private List<String> primaryClipGetExtraMethods;

    @SerializedName("primary_clip_has_extra_methods")
    private List<String> primaryClipHasExtraMethods;

    @SerializedName("primary_clip_set_extra_methods")
    private List<String> primaryClipSetExtraMethods;

    @SerializedName("root_and_emulator_detect_disable")
    private boolean rootAndEmulatorDetectDisable;

    @SerializedName("root_and_emulator_detect_ka_enable")
    private boolean rootAndEmulatorDetectKaEnable;

    @SerializedName("screen_protection_disabled")
    private boolean screenProtectionDisabled;

    @SerializedName("scs_monitor_enable")
    private boolean scsMonitorEnable;

    @SerializedName("security_audit_deprecated_perm_type")
    private List<Integer> securityAuditDeprecatedPermType;

    @SerializedName("security_policy_ip_factors")
    private List<String> securityPolicyIpFactors;

    @SerializedName("security_policy_minimum_push_interval")
    private long securityPolicyMinimumPushInterval;

    @SerializedName("skip_doubao_conditional_access_handler")
    private boolean skipDoubaoConditionalAccessHandler;

    @SerializedName("enable_stream_cipher_mode")
    private boolean streamCipherMode;

    @SerializedName("support_primary_clip_extra_method")
    private boolean supportPrimaryClipExtraMethod;

    @SerializedName("tee_keypair_max_failure_count")
    private int teeKeypairMaxFailureCount;

    @SerializedName("web_interceptor_app_id_whitelist")
    private List<String> webInterceptorAppIdWhitelist;

    public LscSettingConfig() {
        this.enableDoubaoActionHandle = true;
        this.doubaoPingDelayMs = 500;
        this.enablePolicyCenterSubRichText = true;
        this.policyCenterSameDisplayIdCoolingSeconds = 10;
        this.enablePolicyCenterPlainHttpUrlParse = true;
        this.heartbeatInterval = 900;
        this.enablePolicyEngine = true;
        this.policyEngineFetchPolicyInterval = 300;
        this.policyEngineLocalValidateCountLimit = 20;
        this.policyEnginePointCutRetryDelay = 5;
        this.dynamic_pointkey_max_cache_size = new b();
        this.dynamicPointKeyMaxCacheSizeV2 = new a();
        this.enableImReadPolicyCenter = true;
        this.enableImReadInvalidDataOpt = true;
        this.imFileReadCacheExpiryTimeV2 = 600;
        this.file_strategy_retry_delay_time = 5;
        this.file_strategy_retry_max_count = 2;
        this.file_strategy_delay_clean_time = 600;
        this.file_strategy_delay_clean_inaccuracy = 60;
        this.file_strategy_update_frequency_control = 2;
        this.imFileReadLruCache = 500;
        this.lruCacheSize = 100;
        this.dlpMaxCheckTime = 900;
        this.dlpPeriodOfValidity = 600;
        this.exemptMIUIPageConfig = new d();
        this.securityAuditDeprecatedPermType = CollectionsKt.listOf(16);
        this.logReportFilterPolicySetKeys = CollectionsKt.emptyList();
        this.logDeleteFilterPolicySetKeys = CollectionsKt.emptyList();
        this.networkMonitorBlocklist = CollectionsKt.emptyList();
        this.primaryClipSetExtraMethods = CollectionsKt.emptyList();
        this.primaryClipGetDescriptionExtraMethods = CollectionsKt.emptyList();
        this.primaryClipHasExtraMethods = CollectionsKt.emptyList();
        this.primaryClipClearExtraMethods = CollectionsKt.emptyList();
        this.primaryClipGetExtraMethods = CollectionsKt.emptyList();
        this.fileWatermarkSceneType = "SCS";
        this.fileWatermarkPointKey = "PointKey_FILE_WATERMARK";
        this.fileWatermarkPointParam = MapsKt.emptyMap();
        this.enableMeetingMinutesFileStrategy = true;
        this.enableCalendarFileStrategy = true;
        this.enableFileBizDomainFilter = true;
        this.deviceHcArticle = "";
        this.enableSdkPushNotification = true;
        this.securityPolicyIpFactors = CollectionsKt.listOf("SOURCE_IP_V4");
        this.teeKeypairMaxFailureCount = 5;
        this.enableWatermarkOomOpt = true;
        this.enableSecurityActionPlugin = true;
        this.enableUrlSlashOpt = true;
        this.fileProtectPeriodOfValidity = 600;
        this.customDisplayConfigExpirationTime = TimeUtils.SECONDS_PER_HOUR;
        this.customDisplayConfigLoadTimeout = 1500;
        this.enableSecurityLabelControlCheck = true;
        this.enableSecurityLabelCcmTimer = true;
        this.fragmentBinderOpt = true;
        this.securityPolicyMinimumPushInterval = 2000;
        this.enableJudgeVirtualFile = true;
        this.enableMimeJudgeOpt = true;
        this.enablePolicyCenterNewDialog = true;
        this.enableWebInterceptor = true;
        this.webInterceptorAppIdWhitelist = CollectionsKt.listOf(new String[]{"cli_a37fca91d26b500d", "cli_a92bdaf158381bdf"});
        this.enableMinutesDynamicCache = true;
        this.enableMeetingMinutesCcmEntityDynamicCache = true;
        this.enableMinutesFileTimer = true;
        this.enableCalendarEntityDynamicCache = true;
        this.androidUseNewTaskId = true;
        this.policyCenterMobilePointkeys = CollectionsKt.listOf(new String[]{"PointKey_CCM_CONTENT_COPY", "PointKey_CCM_FILE_PREVIEW", "PointKey_CCM_CONTENT_PREVIEW", "PointKey_CCM_CREATE_COPY", "PointKey_CCM_EXPORT", "PointKey_CCM_FILE_DOWNLOAD"});
        this.decisionCacheTTLPointKeys = CollectionsKt.listOf("PointKey_IM_MSG_FILE_READ");
        this.policyCenterClearCachePointKeys = CollectionsKt.listOf("PointKey_IM_MSG_FILE_READ");
        this.enableCertificateAuthentication = true;
        this.enableDeviceMtlsByOkhttpHuawei = true;
        this.deviceCertificateMtlsDomain = "";
        this.enableAndroidUserscopeRustFetcher = true;
        this.enableOpenUrlWithActivityContext = true;
        this.androidTrafficSubthread = true;
        this.enableMtlsLocale = true;
        this.enableClearClientCertPreferences = true;
        this.enableSkipSecurityDialogOnMdmAuth = true;
        this.enableDoubaoWatermark = true;
        this.enableDoubaoDialogWatermarkGlobalOnly = true;
        this.enableDoubaoPolicyCenterPage = true;
        this.enableGeoLocation = true;
        this.endpointLocationIntervalMills = 60000;
        this.emmGeoAccuracy = 100.0f;
        this.enablePolicyCenterGeoButton = true;
        this.enableGeoAuthFineGrainedToast = true;
        this.enableInterceptionRestoreOnLaunch = true;
        this.enableGeoAuthRefreshUpload = true;
        this.officeSDKNoPermissionCoverActivityWhitelist = CollectionsKt.listOf(new String[]{"com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonActivity", "com.bytedance.sdk.open.douyin.ui.DouYinWebAuthorizeActivity", "com.bytedance.bdturing.BdTuringVerifyActivity"});
        this.officeSDKScreenAuditDedupWindowMs = 1500;
        this.androidDisablePsdaTokenFetch = true;
    }

    public final boolean A() {
        return this.enableCustomDialog;
    }

    public final boolean B() {
        return this.enableDoubaoActionHandle;
    }

    public final boolean C() {
        return this.enableDoubaoPolicyCenterPage;
    }

    public final boolean D() {
        return this.enableFileBizDomainFilter;
    }

    public final boolean E() {
        return this.enableFilePolicyLogOpt;
    }

    public final boolean F() {
        return this.enableGeoAuthFineGrainedToast;
    }

    public final boolean G() {
        return this.enableGeoAuthRefreshUpload;
    }

    public final boolean H() {
        return this.enableImReadInvalidDataOpt;
    }

    public final boolean I() {
        return this.enableImReadPolicyCenter;
    }

    public final boolean J() {
        return this.enableInterceptionRestoreOnLaunch;
    }

    public final boolean K() {
        return this.enableMeetingMinutesCcmEntityDynamicCache;
    }

    public final boolean L() {
        return this.enableMeetingMinutesFileStrategy;
    }

    public final boolean M() {
        return this.enableMinutesDynamicCache;
    }

    public final boolean N() {
        return this.enableMinutesFileTimer;
    }

    public final boolean O() {
        return this.enableOpenUrlWithActivityContext;
    }

    public final boolean P() {
        return this.enablePolicyCenterGeoButton;
    }

    public final boolean Q() {
        return this.enablePolicyCenterNewDialog;
    }

    public final boolean R() {
        return this.enablePolicyCenterPlainHttpUrlParse;
    }

    public final boolean S() {
        return this.enablePolicyCenterSubRichText;
    }

    public final boolean T() {
        return this.enableSdkPushNotification;
    }

    public final boolean U() {
        return this.enableSecurityActionPlugin;
    }

    public final boolean V() {
        return this.enableSecurityLabelCcmTimer;
    }

    public final boolean W() {
        return this.enableSecurityLabelControlCheck;
    }

    public final boolean X() {
        return this.enableSkipSecurityDialogOnMdmAuth;
    }

    public final boolean Y() {
        return this.enableWebInterceptor;
    }

    public final int Z() {
        return this.fileProtectPeriodOfValidity;
    }

    public final boolean a() {
        return this.advancedLoginDynamicDisplayDisabled;
    }

    public final int a0() {
        return this.file_strategy_delay_clean_inaccuracy;
    }

    public final boolean b() {
        return this.androidTrafficSubthread;
    }

    public final int b0() {
        return this.file_strategy_delay_clean_time;
    }

    public final boolean c() {
        return this.androidUseNewTaskId;
    }

    public final boolean c0() {
        return this.file_strategy_fallback_result;
    }

    public final boolean d() {
        return this.appBackgroundShowToast;
    }

    public final int d0() {
        return this.file_strategy_retry_delay_time;
    }

    public final boolean e() {
        return this.conditionAccessDisabled;
    }

    public final int e0() {
        return this.file_strategy_retry_max_count;
    }

    public final long f() {
        return this.customDisplayConfigExpirationTime;
    }

    public final int f0() {
        return this.file_strategy_update_frequency_control;
    }

    public final long g() {
        return this.customDisplayConfigLoadTimeout;
    }

    public final boolean g0() {
        return this.grantTokenSwitch;
    }

    public final List<String> h() {
        return this.decisionCacheTTLPointKeys;
    }

    public final long h0() {
        return this.imFileReadCacheExpiryTimeV2;
    }

    public final boolean i() {
        return this.disableDoubaoPing;
    }

    public final int i0() {
        return this.imFileReadLruCache;
    }

    public final boolean j() {
        return this.disableDynamicCache;
    }

    public final List<String> j0() {
        return this.logDeleteFilterPolicySetKeys;
    }

    public final boolean k() {
        return this.disableFileStrategyNoCacheRetryBatch;
    }

    public final List<String> k0() {
        return this.logReportFilterPolicySetKeys;
    }

    public final boolean l() {
        return this.disableHandleSecurityAction;
    }

    public final int l0() {
        return this.lruCacheSize;
    }

    public final boolean m() {
        return this.disablePolicyCenterSameDisplayIdActionDedup;
    }

    public final List<String> m0() {
        return this.networkMonitorBlocklist;
    }

    public final boolean n() {
        return this.disablePolicyCenterWiki;
    }

    public final List<String> n0() {
        return this.officeSDKNoPermissionCoverActivityWhitelist;
    }

    public final boolean o() {
        return this.disable_file_operate;
    }

    public final long o0() {
        return this.officeSDKScreenAuditDedupWindowMs;
    }

    public final boolean p() {
        return this.disable_file_strategy;
    }

    public final List<String> p0() {
        return this.policyCenterClearCachePointKeys;
    }

    public final boolean q() {
        return this.disable_file_strategy_share;
    }

    public final List<String> q0() {
        return this.policyCenterMobilePointkeys;
    }

    public final boolean r() {
        return this.disable_file_strategy_share_cache;
    }

    public final long r0() {
        return this.policyCenterSameDisplayIdCoolingSeconds;
    }

    public final long s() {
        return this.dlpMaxCheckTime;
    }

    public final boolean s0() {
        return this.screenProtectionDisabled;
    }

    public final long t() {
        return this.dlpPeriodOfValidity;
    }

    public final List<String> t0() {
        return this.securityPolicyIpFactors;
    }

    public final long u() {
        return this.doubaoPingDelayMs;
    }

    public final long u0() {
        return this.securityPolicyMinimumPushInterval;
    }

    public final a v() {
        return this.dynamicPointKeyMaxCacheSizeV2;
    }

    public final boolean v0() {
        return this.skipDoubaoConditionalAccessHandler;
    }

    public final b w() {
        return this.dynamic_pointkey_max_cache_size;
    }

    public final List<String> w0() {
        return this.webInterceptorAppIdWhitelist;
    }

    public final boolean x() {
        return this.enableAndroidUserscopeRustFetcher;
    }

    public final boolean y() {
        return this.enableCalendarEntityDynamicCache;
    }

    public final boolean z() {
        return this.enableCalendarFileStrategy;
    }
}
