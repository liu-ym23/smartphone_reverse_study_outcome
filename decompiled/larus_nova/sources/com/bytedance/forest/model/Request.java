package com.bytedance.forest.model;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import com.bytedance.forest.Forest;
import com.bytedance.forest.pollyfill.NetWorker;
import com.bytedance.forest.pollyfill.ttnet.ForestNetAPI;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\"\n\u0002\b\u001f\b\u0017\u0018\u00002\u00020\u0001Bä\u0003\u0012\u0006\u0010L\u001a\u00020\u0002\u0012\u0006\u0010O\u001a\u00020N\u0012\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010S\u0012\b\b\u0002\u0010[\u001a\u00020Z\u0012\b\b\u0002\u0010_\u001a\u00020\u0004\u0012\b\b\u0002\u0010b\u001a\u00020\u0004\u0012\b\b\u0002\u0010e\u001a\u00020\u0004\u0012\b\b\u0002\u0010h\u001a\u00020\u0004\u0012\b\b\u0002\u0010k\u001a\u00020\u0004\u0012\b\b\u0002\u0010n\u001a\u00020\u0004\u0012\b\b\u0002\u0010q\u001a\u00020\u0004\u0012\b\b\u0002\u0010t\u001a\u00020\u0004\u0012\b\b\u0002\u0010w\u001a\u00020\u0004\u0012\b\b\u0002\u0010z\u001a\u00020\u0004\u0012\b\b\u0002\u0010}\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0081\u0001\u001a\u00030\u0080\u0001\u0012\n\b\u0002\u0010\u0088\u0001\u001a\u00030\u0087\u0001\u0012\t\b\u0002\u0010\u008e\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010\u0090\u0001\u001a\u00020\u0002\u0012\t\b\u0002\u0010\u0093\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010\u0096\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010\u0099\u0001\u001a\u00020\u0004\u0012\u0011\b\u0002\u0010\u009e\u0001\u001a\n\u0012\u0005\u0012\u00030\u009d\u00010\u009c\u0001\u0012\t\b\u0002\u0010¡\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010£\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010¦\u0001\u001a\u00020\u0004\u0012\u000b\b\u0002\u0010©\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010¬\u0001\u001a\u0004\u0018\u00010\u0001\u0012\t\b\u0002\u0010²\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010µ\u0001\u001a\u00020\u0004\u0012\n\b\u0002\u0010¸\u0001\u001a\u00030\u0080\u0001\u0012\t\b\u0002\u0010»\u0001\u001a\u00020\u0004\u0012\u0015\b\u0002\u0010¾\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020S\u0012\u0012\b\u0002\u0010Á\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010À\u0001\u0012\t\b\u0002\u0010Å\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010È\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010Ê\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010Ì\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010Ï\u0001\u001a\u00020\u0004\u0012\u0011\b\u0002\u0010Ò\u0001\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010)¢\u0006\u0006\bÛ\u0001\u0010Ü\u0001B\u0014\b\u0016\u0012\u0007\u0010Ý\u0001\u001a\u00020\u0000¢\u0006\u0006\bÛ\u0001\u0010Þ\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001c\u001a\u00020\u001b8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R(\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00100\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0013\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017R(\u00104\u001a\b\u0012\u0004\u0012\u00020\u0002038\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R*\u0010;\u001a\u00020\u00022\u0006\u0010:\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010A\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bA\u0010\b\u001a\u0004\bB\u0010\n\"\u0004\bC\u0010DR$\u0010F\u001a\u0004\u0018\u00010E8@@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0017\u0010L\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\bL\u0010<\u001a\u0004\bM\u0010>R\u0017\u0010O\u001a\u00020N8\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR.\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010S8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0017\u0010[\u001a\u00020Z8\u0006¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\"\u0010_\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010\u0013\u001a\u0004\b`\u0010\u0015\"\u0004\ba\u0010\u0017R\"\u0010b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010\u0013\u001a\u0004\bc\u0010\u0015\"\u0004\bd\u0010\u0017R\"\u0010e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010\u0013\u001a\u0004\bf\u0010\u0015\"\u0004\bg\u0010\u0017R\"\u0010h\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bh\u0010\u0013\u001a\u0004\bi\u0010\u0015\"\u0004\bj\u0010\u0017R\"\u0010k\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bk\u0010\u0013\u001a\u0004\bl\u0010\u0015\"\u0004\bm\u0010\u0017R\"\u0010n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010\u0013\u001a\u0004\bo\u0010\u0015\"\u0004\bp\u0010\u0017R\"\u0010q\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010\u0013\u001a\u0004\br\u0010\u0015\"\u0004\bs\u0010\u0017R\"\u0010t\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010\u0013\u001a\u0004\bu\u0010\u0015\"\u0004\bv\u0010\u0017R\"\u0010w\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010\u0013\u001a\u0004\bx\u0010\u0015\"\u0004\by\u0010\u0017R\"\u0010z\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010\u0013\u001a\u0004\b{\u0010\u0015\"\u0004\b|\u0010\u0017R\"\u0010}\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b}\u0010\u0013\u001a\u0004\b~\u0010\u0015\"\u0004\b\u007f\u0010\u0017R*\u0010\u0081\u0001\u001a\u00030\u0080\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R*\u0010\u0088\u0001\u001a\u00030\u0087\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R&\u0010\u008e\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008e\u0001\u0010\u0013\u001a\u0005\b\u008e\u0001\u0010\u0015\"\u0005\b\u008f\u0001\u0010\u0017R&\u0010\u0090\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0090\u0001\u0010<\u001a\u0005\b\u0091\u0001\u0010>\"\u0005\b\u0092\u0001\u0010@R&\u0010\u0093\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0093\u0001\u0010\u0013\u001a\u0005\b\u0094\u0001\u0010\u0015\"\u0005\b\u0095\u0001\u0010\u0017R&\u0010\u0096\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0096\u0001\u0010\u0013\u001a\u0005\b\u0097\u0001\u0010\u0015\"\u0005\b\u0098\u0001\u0010\u0017R&\u0010\u0099\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0099\u0001\u0010\u0013\u001a\u0005\b\u009a\u0001\u0010\u0015\"\u0005\b\u009b\u0001\u0010\u0017R.\u0010\u009e\u0001\u001a\n\u0012\u0005\u0012\u00030\u009d\u00010\u009c\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009e\u0001\u0010+\u001a\u0005\b\u009f\u0001\u0010-\"\u0005\b \u0001\u0010/R&\u0010¡\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¡\u0001\u0010\u0013\u001a\u0005\b¡\u0001\u0010\u0015\"\u0005\b¢\u0001\u0010\u0017R&\u0010£\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b£\u0001\u0010\u0013\u001a\u0005\b¤\u0001\u0010\u0015\"\u0005\b¥\u0001\u0010\u0017R&\u0010¦\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¦\u0001\u0010\u0013\u001a\u0005\b§\u0001\u0010\u0015\"\u0005\b¨\u0001\u0010\u0017R(\u0010©\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b©\u0001\u0010<\u001a\u0005\bª\u0001\u0010>\"\u0005\b«\u0001\u0010@R+\u0010¬\u0001\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¬\u0001\u0010\u00ad\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R&\u0010²\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b²\u0001\u0010\u0013\u001a\u0005\b³\u0001\u0010\u0015\"\u0005\b´\u0001\u0010\u0017R&\u0010µ\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bµ\u0001\u0010\u0013\u001a\u0005\b¶\u0001\u0010\u0015\"\u0005\b·\u0001\u0010\u0017R*\u0010¸\u0001\u001a\u00030\u0080\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¸\u0001\u0010\u0082\u0001\u001a\u0006\b¹\u0001\u0010\u0084\u0001\"\u0006\bº\u0001\u0010\u0086\u0001R&\u0010»\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b»\u0001\u0010\u0013\u001a\u0005\b¼\u0001\u0010\u0015\"\u0005\b½\u0001\u0010\u0017R&\u0010¾\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020S8\u0006¢\u0006\u000e\n\u0005\b¾\u0001\u0010U\u001a\u0005\b¿\u0001\u0010WR(\u0010Á\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010À\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\bÁ\u0001\u0010Â\u0001\u001a\u0006\bÃ\u0001\u0010Ä\u0001R&\u0010Å\u0001\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0005\bÅ\u0001\u0010\u0013\u001a\u0005\bÆ\u0001\u0010\u0015\"\u0005\bÇ\u0001\u0010\u0017R\u001d\u0010È\u0001\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\bÈ\u0001\u0010\u0013\u001a\u0005\bÉ\u0001\u0010\u0015R\u001d\u0010Ê\u0001\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\bÊ\u0001\u0010\u0013\u001a\u0005\bË\u0001\u0010\u0015R&\u0010Ì\u0001\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0005\bÌ\u0001\u0010\u0013\u001a\u0005\bÍ\u0001\u0010\u0015\"\u0005\bÎ\u0001\u0010\u0017R&\u0010Ï\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÏ\u0001\u0010\u0013\u001a\u0005\bÐ\u0001\u0010\u0015\"\u0005\bÑ\u0001\u0010\u0017R.\u0010Ò\u0001\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010)8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÒ\u0001\u0010+\u001a\u0005\bÓ\u0001\u0010-\"\u0005\bÔ\u0001\u0010/R+\u0010×\u0001\u001a\u0004\u0018\u00010\u00022\b\u0010:\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÕ\u0001\u0010>\"\u0005\bÖ\u0001\u0010@R+\u0010Ú\u0001\u001a\u0004\u0018\u00010\u00022\b\u0010:\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bØ\u0001\u0010>\"\u0005\bÙ\u0001\u0010@¨\u0006ß\u0001"}, d2 = {"Lcom/bytedance/forest/model/Request;", "", "", "toString", "", "isWebRequest", "Landroid/net/Uri;", "originUri", "Landroid/net/Uri;", "getOriginUri", "()Landroid/net/Uri;", "Lcom/bytedance/forest/model/GeckoSource;", "geckoSource", "Lcom/bytedance/forest/model/GeckoSource;", "getGeckoSource", "()Lcom/bytedance/forest/model/GeckoSource;", "setGeckoSource", "(Lcom/bytedance/forest/model/GeckoSource;)V", "useInteraction", "Z", "getUseInteraction", "()Z", "setUseInteraction", "(Z)V", "onlyOnline", "getOnlyOnline", "setOnlyOnline", "Lcom/bytedance/forest/pollyfill/c;", "netDepender", "Lcom/bytedance/forest/pollyfill/c;", "getNetDepender$forest_release", "()Lcom/bytedance/forest/pollyfill/c;", "setNetDepender$forest_release", "(Lcom/bytedance/forest/pollyfill/c;)V", "Lcom/bytedance/forest/pollyfill/ttnet/ForestNetAPI$a;", "httpRequest", "Lcom/bytedance/forest/pollyfill/ttnet/ForestNetAPI$a;", "getHttpRequest$forest_release", "()Lcom/bytedance/forest/pollyfill/ttnet/ForestNetAPI$a;", "setHttpRequest$forest_release", "(Lcom/bytedance/forest/pollyfill/ttnet/ForestNetAPI$a;)V", "", "fallbackDomains", "Ljava/util/List;", "getFallbackDomains", "()Ljava/util/List;", "setFallbackDomains", "(Ljava/util/List;)V", "supportShuffle", "getSupportShuffle", "setSupportShuffle", "Ljava/util/LinkedList;", "remainedFallbackDomains", "Ljava/util/LinkedList;", "getRemainedFallbackDomains$forest_release", "()Ljava/util/LinkedList;", "setRemainedFallbackDomains$forest_release", "(Ljava/util/LinkedList;)V", "value", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "uri", "getUri$forest_release", "setUri$forest_release", "(Landroid/net/Uri;)V", "Lcom/bytedance/forest/utils/a;", "cacheKey", "Lcom/bytedance/forest/utils/a;", "getCacheKey$forest_release", "()Lcom/bytedance/forest/utils/a;", "setCacheKey$forest_release", "(Lcom/bytedance/forest/utils/a;)V", "originUrl", "getOriginUrl", "Lcom/bytedance/forest/Forest;", "forest", "Lcom/bytedance/forest/Forest;", "getForest", "()Lcom/bytedance/forest/Forest;", "", "customParams", "Ljava/util/Map;", "getCustomParams", "()Ljava/util/Map;", "setCustomParams", "(Ljava/util/Map;)V", "Lcom/bytedance/forest/model/j;", "geckoModel", "Lcom/bytedance/forest/model/j;", "getGeckoModel", "()Lcom/bytedance/forest/model/j;", "waitGeckoUpdate", "getWaitGeckoUpdate", "setWaitGeckoUpdate", "onlyLocal", "getOnlyLocal", "setOnlyLocal", "onlyMemory", "getOnlyMemory", "setOnlyMemory", "disableCdn", "getDisableCdn", "setDisableCdn", "disableBuiltin", "getDisableBuiltin", "setDisableBuiltin", "disableOffline", "getDisableOffline", "setDisableOffline", "disableGeckoUpdate", "getDisableGeckoUpdate", "setDisableGeckoUpdate", "loadToMemory", "getLoadToMemory", "setLoadToMemory", "useConcurrentBuffer", "getUseConcurrentBuffer", "setUseConcurrentBuffer", "allowIOOnMainThread", "getAllowIOOnMainThread", "setAllowIOOnMainThread", "checkGeckoFileAvailable", "getCheckGeckoFileAvailable", "setCheckGeckoFileAvailable", "", "loadRetryTimes", "I", "getLoadRetryTimes", "()I", "setLoadRetryTimes", "(I)V", "Lcom/bytedance/forest/model/Scene;", "scene", "Lcom/bytedance/forest/model/Scene;", "getScene", "()Lcom/bytedance/forest/model/Scene;", "setScene", "(Lcom/bytedance/forest/model/Scene;)V", "isASync", "setASync", "groupId", "getGroupId", "setGroupId", "enableNegotiation", "getEnableNegotiation", "setEnableNegotiation", "enableMemoryCache", "getEnableMemoryCache", "setEnableMemoryCache", "enableCDNCache", "getEnableCDNCache", "setEnableCDNCache", "", "Lcom/bytedance/forest/model/FetcherType;", "fetcherSequence", "getFetcherSequence", "setFetcherSequence", "isPreload", "setPreload", "enableRequestReuse", "getEnableRequestReuse", "setEnableRequestReuse", "ignoreWaitReusedRequest", "getIgnoreWaitReusedRequest", "setIgnoreWaitReusedRequest", "sessionId", "getSessionId", "setSessionId", "webResourceRequest", "Ljava/lang/Object;", "getWebResourceRequest", "()Ljava/lang/Object;", "setWebResourceRequest", "(Ljava/lang/Object;)V", "needLocalFile", "getNeedLocalFile", "setNeedLocalFile", "streamingLoad", "getStreamingLoad", "setStreamingLoad", "customHttpMaxAge", "getCustomHttpMaxAge", "setCustomHttpMaxAge", "useGeckoNewlyBuiltin", "getUseGeckoNewlyBuiltin", "setUseGeckoNewlyBuiltin", "injectedHttpHeaders", "getInjectedHttpHeaders", "", "cacheKeySensitiveQueries", "Ljava/util/Set;", "getCacheKeySensitiveQueries$forest_release", "()Ljava/util/Set;", "cacheKeyUASensitive", "getCacheKeyUASensitive$forest_release", "setCacheKeyUASensitive$forest_release", "enableTTWebViewDelegate", "getEnableTTWebViewDelegate$forest_release", "followRedirectInternal", "getFollowRedirectInternal$forest_release", "useDirectBuffer", "getUseDirectBuffer$forest_release", "setUseDirectBuffer$forest_release", "cdnRegionRedirect", "getCdnRegionRedirect", "setCdnRegionRedirect", "redirectRegions", "getRedirectRegions", "setRedirectRegions", "getPreloadFrom", "setPreloadFrom", "preloadFrom", "getInjectedUserAgent", "setInjectedUserAgent", "injectedUserAgent", "<init>", "(Ljava/lang/String;Lcom/bytedance/forest/Forest;Ljava/util/Map;Lcom/bytedance/forest/model/j;ZZZZZZZZZZZILcom/bytedance/forest/model/Scene;ZLjava/lang/String;ZZZLjava/util/List;ZZZLjava/lang/String;Ljava/lang/Object;ZZIZLjava/util/Map;Ljava/util/Set;ZZZZZLjava/util/List;)V", "request", "(Lcom/bytedance/forest/model/Request;)V", "forest_release"}, k = 1, mv = {1, 4, 0})
public class Request {
    private boolean allowIOOnMainThread;
    private com.bytedance.forest.utils.a cacheKey;
    private final Set<String> cacheKeySensitiveQueries;
    private boolean cacheKeyUASensitive;
    private boolean cdnRegionRedirect;
    private boolean checkGeckoFileAvailable;
    private int customHttpMaxAge;
    private Map<String, Object> customParams;
    private boolean disableBuiltin;
    private boolean disableCdn;
    private boolean disableGeckoUpdate;
    private boolean disableOffline;
    private boolean enableCDNCache;
    private boolean enableMemoryCache;
    private boolean enableNegotiation;
    private boolean enableRequestReuse;
    private final boolean enableTTWebViewDelegate;
    private List<String> fallbackDomains;
    private List<FetcherType> fetcherSequence;
    private final boolean followRedirectInternal;
    private final Forest forest;
    private final j geckoModel;
    private GeckoSource geckoSource;
    private String groupId;
    private ForestNetAPI.a httpRequest;
    private boolean ignoreWaitReusedRequest;
    private final Map<String, String> injectedHttpHeaders;
    private boolean isASync;
    private boolean isPreload;
    private int loadRetryTimes;
    private boolean loadToMemory;
    private boolean needLocalFile;
    public com.bytedance.forest.pollyfill.c netDepender;
    private boolean onlyLocal;
    private boolean onlyMemory;
    private boolean onlyOnline;
    private final Uri originUri;
    private final String originUrl;
    private List<String> redirectRegions;
    private LinkedList<String> remainedFallbackDomains;
    private Scene scene;
    private String sessionId;
    private boolean streamingLoad;
    private boolean supportShuffle;
    private Uri uri;
    private String url;
    private boolean useConcurrentBuffer;
    private boolean useDirectBuffer;
    private boolean useGeckoNewlyBuiltin;
    private boolean useInteraction;
    private boolean waitGeckoUpdate;
    private Object webResourceRequest;

    public final com.bytedance.forest.utils.a getCacheKey$forest_release() {
        com.bytedance.forest.utils.a r100 = this.cacheKey;
        if (r100 == null) goto L5;
        return r100;
    L5:
        com.bytedance.forest.utils.a.f244506d.getClass();
        String r101 = getOriginUrl();
        if (StringsKt.isBlank(r101) == false) goto L8;
        j r102 = getGeckoModel();
        r101 = "https://gecko.offline.resource/" + r102.f244348a + '/' + r102.f244349b + '/' + r102.f244350c;
    L8:
        String r103 = "";
        if (getCacheKeyUASensitive$forest_release() == false) goto L20;
        Object r104 = getWebResourceRequest();
        String r105 = getInjectedUserAgent();
        boolean r106 = r104 instanceof WebResourceRequest;
        if (r106 == false) goto L21;
        if (r106 == true) goto L14;
        r104 = null;
    L14:
        WebResourceRequest r107 = (WebResourceRequest) r104;
        if (r107 == null) goto L19;
        Map<String, String> r108 = r107.getRequestHeaders();
        if (r108 == null) goto L19;
        r105 = r108.get("user-agent");
    L19:
        r105 = null;
    L21:
        Set<String> r109 = getCacheKeySensitiveQueries$forest_release();
        if (r105 == null) goto L24;
        r103 = r105;
    L24:
        com.bytedance.forest.utils.a r110 = com.bytedance.forest.utils.a.C3497a.b(r101, r109, r103);
        if (r110 == null) goto L28;
        this.cacheKey = r110;
        return r110;
    L28:
        return null;
    L20:
        r105 = "";
        goto L21
    }

    public final String getInjectedUserAgent() {
        Object r100 = this.customParams.get("x-forest-injected-ua");
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final com.bytedance.forest.pollyfill.c getNetDepender$forest_release() {
        com.bytedance.forest.pollyfill.c r100 = this.netDepender;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("netDepender");
    L5:
        return r100;
    }

    public final String getPreloadFrom() {
        Object r100 = this.customParams.get("x-forest-preload-from");
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final boolean isWebRequest() {
        if (this.webResourceRequest != null) goto L10;
        Scene r100 = this.scene;
        if (r100 == Scene.WEB_CHILD_RESOURCE) goto L10;
        if (r100 == Scene.WEB_MAIN_DOCUMENT) goto L10;
        return false;
    L10:
        return true;
    }

    public String toString() {
        return super.toString() + "(geckoModel=" + this.geckoModel + ", waitGeckoUpdate=" + this.waitGeckoUpdate + ", disableGeckoUpdate=" + this.disableGeckoUpdate + ",  onlyLocal=" + this.onlyLocal + ", onlyMemory=" + this.onlyMemory + ", disableCdn=" + this.disableCdn + ", disableBuiltin=" + this.disableBuiltin + ", disableOffline=" + this.disableOffline + ", loadToMemory=" + this.loadToMemory + ", ioConcurrency=" + this.useConcurrentBuffer + ", allowIOOnMainThread=" + this.allowIOOnMainThread + ", checkGeckoFileAvailable=" + this.checkGeckoFileAvailable + ", loadRetryTimes=" + this.loadRetryTimes + ", scene=" + this.scene + ", isASync=" + this.isASync + ", groupId='" + this.groupId + "', enableNegotiation=" + this.enableNegotiation + ", enableMemoryCache=" + this.enableMemoryCache + ", enableCDNCache=" + this.enableCDNCache + ", fetcherSequence=[" + CollectionsKt.joinToString$default(this.fetcherSequence, ",", null, null, 0, null, AnonymousClass1.INSTANCE, 30, null) + "], isPreload=" + this.isPreload + ", enableRequestReuse=" + this.enableRequestReuse + ", ignoreWaitReusedRequest=" + this.ignoreWaitReusedRequest + ",sessionId=" + this.sessionId + ", geckoSource=" + this.geckoSource + ", useInteraction=" + this.useInteraction + ", onlyOnline=" + this.onlyOnline + ", customHttpMaxAge=" + this.customHttpMaxAge + ", useGeckoNewlyBuiltin=" + this.useGeckoNewlyBuiltin + ", requestHeaders=" + this.injectedHttpHeaders + ", followRedirectInternal=" + this.followRedirectInternal + ", useDirectBuffer=" + this.useDirectBuffer + ", enableTTWebViewDelegate=" + this.enableTTWebViewDelegate + ", cacheKeyUASensitive=" + this.cacheKeyUASensitive + ", cacheKeySensitiveQueries=" + this.cacheKeySensitiveQueries + " originUrl='" + this.originUrl + "', customParams=" + this.customParams + ')';
    }

    public final boolean getAllowIOOnMainThread() {
        return this.allowIOOnMainThread;
    }

    public final Set<String> getCacheKeySensitiveQueries$forest_release() {
        return this.cacheKeySensitiveQueries;
    }

    public final boolean getCacheKeyUASensitive$forest_release() {
        return this.cacheKeyUASensitive;
    }

    public final boolean getCdnRegionRedirect() {
        return this.cdnRegionRedirect;
    }

    public final boolean getCheckGeckoFileAvailable() {
        return this.checkGeckoFileAvailable;
    }

    public final int getCustomHttpMaxAge() {
        return this.customHttpMaxAge;
    }

    public final Map<String, Object> getCustomParams() {
        return this.customParams;
    }

    public final boolean getDisableBuiltin() {
        return this.disableBuiltin;
    }

    public final boolean getDisableCdn() {
        return this.disableCdn;
    }

    public final boolean getDisableGeckoUpdate() {
        return this.disableGeckoUpdate;
    }

    public final boolean getDisableOffline() {
        return this.disableOffline;
    }

    public final boolean getEnableCDNCache() {
        return this.enableCDNCache;
    }

    public final boolean getEnableMemoryCache() {
        return this.enableMemoryCache;
    }

    public final boolean getEnableNegotiation() {
        return this.enableNegotiation;
    }

    public final boolean getEnableRequestReuse() {
        return this.enableRequestReuse;
    }

    public final boolean getEnableTTWebViewDelegate$forest_release() {
        return this.enableTTWebViewDelegate;
    }

    public final List<String> getFallbackDomains() {
        return this.fallbackDomains;
    }

    public final List<FetcherType> getFetcherSequence() {
        return this.fetcherSequence;
    }

    public final boolean getFollowRedirectInternal$forest_release() {
        return this.followRedirectInternal;
    }

    public final Forest getForest() {
        return this.forest;
    }

    public final j getGeckoModel() {
        return this.geckoModel;
    }

    public final GeckoSource getGeckoSource() {
        return this.geckoSource;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final ForestNetAPI.a getHttpRequest$forest_release() {
        return this.httpRequest;
    }

    public final boolean getIgnoreWaitReusedRequest() {
        return this.ignoreWaitReusedRequest;
    }

    public final Map<String, String> getInjectedHttpHeaders() {
        return this.injectedHttpHeaders;
    }

    public final int getLoadRetryTimes() {
        return this.loadRetryTimes;
    }

    public final boolean getLoadToMemory() {
        return this.loadToMemory;
    }

    public final boolean getNeedLocalFile() {
        return this.needLocalFile;
    }

    public final boolean getOnlyLocal() {
        return this.onlyLocal;
    }

    public final boolean getOnlyMemory() {
        return this.onlyMemory;
    }

    public final boolean getOnlyOnline() {
        return this.onlyOnline;
    }

    public final Uri getOriginUri() {
        return this.originUri;
    }

    public final String getOriginUrl() {
        return this.originUrl;
    }

    public final List<String> getRedirectRegions() {
        return this.redirectRegions;
    }

    public final LinkedList<String> getRemainedFallbackDomains$forest_release() {
        return this.remainedFallbackDomains;
    }

    public final Scene getScene() {
        return this.scene;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final boolean getStreamingLoad() {
        return this.streamingLoad;
    }

    public final boolean getSupportShuffle() {
        return this.supportShuffle;
    }

    public final Uri getUri$forest_release() {
        return this.uri;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean getUseConcurrentBuffer() {
        return this.useConcurrentBuffer;
    }

    public final boolean getUseDirectBuffer$forest_release() {
        return this.useDirectBuffer;
    }

    public final boolean getUseGeckoNewlyBuiltin() {
        return this.useGeckoNewlyBuiltin;
    }

    public final boolean getUseInteraction() {
        return this.useInteraction;
    }

    public final boolean getWaitGeckoUpdate() {
        return this.waitGeckoUpdate;
    }

    public final Object getWebResourceRequest() {
        return this.webResourceRequest;
    }

    public final boolean isASync() {
        return this.isASync;
    }

    public final boolean isPreload() {
        return this.isPreload;
    }

    public Request(Request r410) {
        this(r410.originUrl, r410.forest, r410.customParams, r410.geckoModel, r410.waitGeckoUpdate, r410.onlyLocal, r410.onlyMemory, r410.disableCdn, r410.disableBuiltin, r410.disableOffline, r410.disableGeckoUpdate, r410.loadToMemory, r410.useConcurrentBuffer, r410.allowIOOnMainThread, r410.checkGeckoFileAvailable, r410.loadRetryTimes, r410.scene, r410.isASync, r410.groupId, r410.enableNegotiation, r410.enableMemoryCache, r410.enableCDNCache, r410.fetcherSequence, r410.isPreload, r410.enableRequestReuse, r410.ignoreWaitReusedRequest, r410.sessionId, r410.webResourceRequest, r410.needLocalFile, r410.streamingLoad, r410.customHttpMaxAge, r410.useGeckoNewlyBuiltin, r410.injectedHttpHeaders, r410.cacheKeySensitiveQueries, r410.cacheKeyUASensitive, r410.enableTTWebViewDelegate, r410.followRedirectInternal, r410.useDirectBuffer, r410.cdnRegionRedirect, r410.redirectRegions);
        this.geckoSource = r410.geckoSource;
        this.useInteraction = r410.useInteraction;
        this.onlyOnline = r410.onlyOnline;
        com.bytedance.forest.pollyfill.c r100 = r410.netDepender;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("netDepender");
    L5:
        this.netDepender = r100;
        this.httpRequest = r410.httpRequest;
        this.fallbackDomains = r410.fallbackDomains;
        this.supportShuffle = r410.supportShuffle;
        this.remainedFallbackDomains.addAll(r410.remainedFallbackDomains);
    }

    public final void setASync(boolean r100) {
        this.isASync = r100;
    }

    public final void setAllowIOOnMainThread(boolean r100) {
        this.allowIOOnMainThread = r100;
    }

    public final void setCacheKey$forest_release(com.bytedance.forest.utils.a r100) {
        this.cacheKey = r100;
    }

    public final void setCacheKeyUASensitive$forest_release(boolean r100) {
        this.cacheKeyUASensitive = r100;
    }

    public final void setCdnRegionRedirect(boolean r100) {
        this.cdnRegionRedirect = r100;
    }

    public final void setCheckGeckoFileAvailable(boolean r100) {
        this.checkGeckoFileAvailable = r100;
    }

    public final void setCustomHttpMaxAge(int r100) {
        this.customHttpMaxAge = r100;
    }

    public final void setCustomParams(Map<String, Object> r100) {
        this.customParams = r100;
    }

    public final void setDisableBuiltin(boolean r100) {
        this.disableBuiltin = r100;
    }

    public final void setDisableCdn(boolean r100) {
        this.disableCdn = r100;
    }

    public final void setDisableGeckoUpdate(boolean r100) {
        this.disableGeckoUpdate = r100;
    }

    public final void setDisableOffline(boolean r100) {
        this.disableOffline = r100;
    }

    public final void setEnableCDNCache(boolean r100) {
        this.enableCDNCache = r100;
    }

    public final void setEnableMemoryCache(boolean r100) {
        this.enableMemoryCache = r100;
    }

    public final void setEnableNegotiation(boolean r100) {
        this.enableNegotiation = r100;
    }

    public final void setEnableRequestReuse(boolean r100) {
        this.enableRequestReuse = r100;
    }

    public final void setFallbackDomains(List<String> r100) {
        this.fallbackDomains = r100;
    }

    public final void setFetcherSequence(List<FetcherType> r100) {
        this.fetcherSequence = r100;
    }

    public final void setGeckoSource(GeckoSource r100) {
        this.geckoSource = r100;
    }

    public final void setGroupId(String r100) {
        this.groupId = r100;
    }

    public final void setHttpRequest$forest_release(ForestNetAPI.a r100) {
        this.httpRequest = r100;
    }

    public final void setIgnoreWaitReusedRequest(boolean r100) {
        this.ignoreWaitReusedRequest = r100;
    }

    public final void setInjectedUserAgent(String r100) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        this.customParams.put("x-forest-injected-ua", r100);
    }

    public final void setLoadRetryTimes(int r100) {
        this.loadRetryTimes = r100;
    }

    public final void setLoadToMemory(boolean r100) {
        this.loadToMemory = r100;
    }

    public final void setNeedLocalFile(boolean r100) {
        this.needLocalFile = r100;
    }

    public final void setNetDepender$forest_release(com.bytedance.forest.pollyfill.c r100) {
        this.netDepender = r100;
    }

    public final void setOnlyLocal(boolean r100) {
        this.onlyLocal = r100;
    }

    public final void setOnlyMemory(boolean r100) {
        this.onlyMemory = r100;
    }

    public final void setOnlyOnline(boolean r100) {
        this.onlyOnline = r100;
    }

    public final void setPreload(boolean r100) {
        this.isPreload = r100;
    }

    public final void setPreloadFrom(String r100) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        this.customParams.put("x-forest-preload-from", r100);
    }

    public final void setRedirectRegions(List<String> r100) {
        this.redirectRegions = r100;
    }

    public final void setRemainedFallbackDomains$forest_release(LinkedList<String> r100) {
        this.remainedFallbackDomains = r100;
    }

    public final void setScene(Scene r100) {
        this.scene = r100;
    }

    public final void setSessionId(String r100) {
        this.sessionId = r100;
    }

    public final void setStreamingLoad(boolean r100) {
        this.streamingLoad = r100;
    }

    public final void setSupportShuffle(boolean r100) {
        this.supportShuffle = r100;
    }

    public final void setUri$forest_release(Uri r100) {
        this.uri = r100;
    }

    public final void setUrl(String r100) {
        if (Intrinsics.areEqual(this.url, r100) == false) goto L5;
        return;
    L5:
        this.url = r100;
        this.uri = UriProtector.parse(r100);
    }

    public final void setUseConcurrentBuffer(boolean r100) {
        this.useConcurrentBuffer = r100;
    }

    public final void setUseDirectBuffer$forest_release(boolean r100) {
        this.useDirectBuffer = r100;
    }

    public final void setUseGeckoNewlyBuiltin(boolean r100) {
        this.useGeckoNewlyBuiltin = r100;
    }

    public final void setUseInteraction(boolean r100) {
        this.useInteraction = r100;
    }

    public final void setWaitGeckoUpdate(boolean r100) {
        this.waitGeckoUpdate = r100;
    }

    public final void setWebResourceRequest(Object r100) {
        this.webResourceRequest = r100;
    }

    public Request(String r100, Forest r101, Map<String, Object> r102, j r103, boolean r104, boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117, boolean r118, boolean r119, int r210, Scene r211, boolean r212, String r213, boolean r214, boolean r215, boolean r216, List<FetcherType> r217, boolean r218, boolean r219, boolean r310, String r311, Object r312, boolean r313, boolean r314, int r315, boolean r316, Map<String, String> r317, Set<String> r318, boolean r319, boolean r410, boolean r411, boolean r412, boolean r413, List<String> r414) {
        this.originUrl = r100;
        this.forest = r101;
        this.customParams = r102;
        this.geckoModel = r103;
        this.waitGeckoUpdate = r104;
        this.onlyLocal = r110;
        this.onlyMemory = r111;
        this.disableCdn = r112;
        this.disableBuiltin = r113;
        this.disableOffline = r114;
        this.disableGeckoUpdate = r115;
        this.loadToMemory = r116;
        this.useConcurrentBuffer = r117;
        this.allowIOOnMainThread = r118;
        this.checkGeckoFileAvailable = r119;
        this.loadRetryTimes = r210;
        this.scene = r211;
        this.isASync = r212;
        this.groupId = r213;
        this.enableNegotiation = r214;
        this.enableMemoryCache = r215;
        this.enableCDNCache = r216;
        this.fetcherSequence = r217;
        this.isPreload = r218;
        this.enableRequestReuse = r219;
        this.ignoreWaitReusedRequest = r310;
        this.sessionId = r311;
        this.webResourceRequest = r312;
        this.needLocalFile = r313;
        this.streamingLoad = r314;
        this.customHttpMaxAge = r315;
        this.useGeckoNewlyBuiltin = r316;
        this.injectedHttpHeaders = r317;
        this.cacheKeySensitiveQueries = r318;
        this.cacheKeyUASensitive = r319;
        this.enableTTWebViewDelegate = r410;
        this.followRedirectInternal = r411;
        this.useDirectBuffer = r412;
        this.cdnRegionRedirect = r413;
        this.redirectRegions = r414;
        Uri r105 = UriProtector.parse(r100);
        this.originUri = r105;
        this.geckoSource = GeckoSource.CLIENT_CONFIG;
        this.fallbackDomains = CollectionsKt.emptyList();
        this.remainedFallbackDomains = new LinkedList();
        this.url = r100;
        this.uri = r105;
    }

    public Request(String r410, Forest r411, Map r412, j r413, boolean r510, boolean r511, boolean r512, boolean r513, boolean r514, boolean r515, boolean r516, boolean r517, boolean r518, boolean r519, boolean r610, int r611, Scene r612, boolean r613, String r614, boolean r615, boolean r616, boolean r617, List r618, boolean r619, boolean r710, boolean r711, String r712, Object r713, boolean r714, boolean r715, int r716, boolean r717, Map r718, Set r719, boolean r810, boolean r811, boolean r812, boolean r813, boolean r814, List r815, int r816, int r817, DefaultConstructorMarker r818) {
        if ((r816 & 8) == 0) goto L5;
        j r100 = new j("", "", "");
    L7:
        if ((r816 & 16) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r816 & 32) == 0) goto L13;
        boolean r110 = false;
    L15:
        if ((r816 & 64) == 0) goto L17;
        boolean r111 = false;
    L19:
        if ((r816 & 128) == 0) goto L21;
        boolean r112 = false;
    L23:
        if ((r816 & 256) == 0) goto L25;
        boolean r113 = false;
    L27:
        if ((r816 & 512) == 0) goto L29;
        boolean r114 = false;
    L31:
        if ((r816 & 1024) == 0) goto L33;
        boolean r115 = false;
    L35:
        if ((r816 & 2048) == 0) goto L37;
        boolean r116 = false;
    L39:
        if ((r816 & 4096) == 0) goto L41;
        boolean r117 = false;
    L43:
        if ((r816 & 8192) == 0) goto L45;
        boolean r118 = false;
    L47:
        if ((r816 & 16384) == 0) goto L49;
        boolean r119 = true;
    L51:
        if ((32768 & r816) == 0) goto L53;
        int r210 = 0;
    L55:
        if ((65536 & r816) == 0) goto L57;
        Scene r211 = Scene.OTHER;
    L59:
        if ((131072 & r816) == 0) goto L61;
        boolean r212 = false;
    L63:
        if ((262144 & r816) == 0) goto L65;
        String r213 = "";
    L67:
        if ((524288 & r816) == 0) goto L69;
        boolean r214 = false;
    L71:
        if ((1048576 & r816) == 0) goto L73;
        NetWorker r102 = d.f244330a;
        boolean r215 = false;
    L75:
        if ((2097152 & r816) == 0) goto L77;
        NetWorker r103 = d.f244330a;
        boolean r216 = d.f244331b;
    L79:
        if ((4194304 & r816) == 0) goto L81;
        List r217 = new ArrayList();
    L83:
        if ((8388608 & r816) == 0) goto L85;
        boolean r218 = false;
    L87:
        if ((16777216 & r816) == 0) goto L89;
        boolean r219 = false;
    L91:
        if ((33554432 & r816) == 0) goto L93;
        boolean r310 = false;
    L95:
        if ((67108864 & r816) == 0) goto L97;
        String r311 = null;
    L99:
        if ((134217728 & r816) == 0) goto L101;
        Object r312 = null;
    L103:
        if ((268435456 & r816) == 0) goto L105;
        boolean r313 = false;
    L107:
        if ((536870912 & r816) == 0) goto L109;
        boolean r314 = false;
    L111:
        if ((1073741824 & r816) == 0) goto L113;
        int r315 = 0;
    L115:
        if ((r816 & Integer.MIN_VALUE) == 0) goto L117;
        boolean r316 = false;
    L119:
        if ((r817 & 1) == 0) goto L121;
        Map r317 = new LinkedHashMap();
    L123:
        if ((r817 & 2) == 0) goto L125;
        Set r318 = null;
    L127:
        if ((r817 & 4) == 0) goto L129;
        boolean r319 = false;
    L131:
        if ((r817 & 8) == 0) goto L133;
        boolean r414 = false;
    L135:
        if ((r817 & 16) == 0) goto L137;
        boolean r415 = true;
    L139:
        if ((r817 & 32) == 0) goto L141;
        boolean r416 = false;
    L143:
        if ((r817 & 64) == 0) goto L145;
        boolean r417 = false;
    L147:
        if ((r817 & 128) == 0) goto L149;
        List r418 = null;
    L150:
        this(r410, r411, r412, r100, r101, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r414, r415, r416, r417, r418);
        return;
    L149:
        r418 = r815;
        goto L150
    L145:
        r417 = r814;
        goto L147
    L141:
        r416 = r813;
        goto L143
    L137:
        r415 = r812;
        goto L139
    L133:
        r414 = r811;
        goto L135
    L129:
        r319 = r810;
        goto L131
    L125:
        r318 = r719;
        goto L127
    L121:
        r317 = r718;
        goto L123
    L117:
        r316 = r717;
        goto L119
    L113:
        r315 = r716;
        goto L115
    L109:
        r314 = r715;
        goto L111
    L105:
        r313 = r714;
        goto L107
    L101:
        r312 = r713;
        goto L103
    L97:
        r311 = r712;
        goto L99
    L93:
        r310 = r711;
        goto L95
    L89:
        r219 = r710;
        goto L91
    L85:
        r218 = r619;
        goto L87
    L81:
        r217 = r618;
        goto L83
    L77:
        r216 = r617;
        goto L79
    L73:
        r215 = r616;
        goto L75
    L69:
        r214 = r615;
        goto L71
    L65:
        r213 = r614;
        goto L67
    L61:
        r212 = r613;
        goto L63
    L57:
        r211 = r612;
        goto L59
    L53:
        r210 = r611;
        goto L55
    L49:
        r119 = r610;
        goto L51
    L45:
        r118 = r519;
        goto L47
    L41:
        r117 = r518;
        goto L43
    L37:
        r116 = r517;
        goto L39
    L33:
        r115 = r516;
        goto L35
    L29:
        r114 = r515;
        goto L31
    L25:
        r113 = r514;
        goto L27
    L21:
        r112 = r513;
        goto L23
    L17:
        r111 = r512;
        goto L19
    L13:
        r110 = r511;
        goto L15
    L9:
        r101 = r510;
        goto L11
    L5:
        r100 = r413;
        goto L7
    }
}
