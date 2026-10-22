package com.bytedance.android.shopping.api.mall;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010$\n\u0002\by\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u008f\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u0007\u0012\b\b\u0002\u0010\"\u001a\u00020\u0005\u0012\b\b\u0002\u0010#\u001a\u00020\u0005\u0012\b\b\u0002\u0010$\u001a\u00020\u0007\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010&\u001a\u00020\u0007\u0012\b\b\u0002\u0010'\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010)\u0012\b\b\u0002\u0010*\u001a\u00020\u0005\u0012\b\b\u0002\u0010+\u001a\u00020\u0005\u0012\b\b\u0002\u0010,\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010)\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010/\u001a\u00020\u0007\u0012\b\b\u0002\u00100\u001a\u00020\u0007\u0012\b\b\u0002\u00101\u001a\u00020\u0007\u0012\b\b\u0002\u00102\u001a\u00020\u0007\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u00105J\u000b\u0010p\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010q\u001a\u00020\u0005HÆ\u0003J\t\u0010r\u001a\u00020\u0005HÆ\u0003J\u0010\u0010s\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010<J\t\u0010t\u001a\u00020\u0007HÆ\u0003J\t\u0010u\u001a\u00020\u0007HÆ\u0003J\t\u0010v\u001a\u00020\u0007HÆ\u0003J\t\u0010w\u001a\u00020\u0003HÆ\u0003J\t\u0010x\u001a\u00020\fHÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010{\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00107J\u0010\u0010|\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00107J\t\u0010}\u001a\u00020\u0005HÆ\u0003J\t\u0010~\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u007f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010<J\u0011\u0010\u0080\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010PJ\u0011\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010<J\u0011\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00107J\n\u0010\u0083\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010<J\n\u0010\u0087\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0007HÆ\u0003J\u0011\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00107J\n\u0010\u008a\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0007HÆ\u0003J\u0018\u0010\u008c\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010)HÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0007HÆ\u0003J\u0018\u0010\u0090\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010)HÆ\u0003J\u0011\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010<J\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0094\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0095\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0007HÆ\u0003J\f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0098\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010PJ\u0011\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010<J\n\u0010\u009a\u0001\u001a\u00020\u0007HÆ\u0003J\u0011\u0010\u009b\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010PJ\u0011\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010<J\n\u0010\u009d\u0001\u001a\u00020\u0007HÆ\u0003J\u009e\u0004\u0010\u009e\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00072\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00072\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010&\u001a\u00020\u00072\b\b\u0002\u0010'\u001a\u00020\u00072\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010)2\b\b\u0002\u0010*\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020\u00052\b\b\u0002\u0010,\u001a\u00020\u00072\u0016\b\u0002\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010)2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010/\u001a\u00020\u00072\b\b\u0002\u00100\u001a\u00020\u00072\b\b\u0002\u00101\u001a\u00020\u00072\b\b\u0002\u00102\u001a\u00020\u00072\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0003\u0010\u009f\u0001J\n\u0010 \u0001\u001a\u00020\u0005HÖ\u0001J\u0016\u0010¡\u0001\u001a\u00020\u00072\n\u0010¢\u0001\u001a\u0005\u0018\u00010£\u0001HÖ\u0003J\n\u0010¤\u0001\u001a\u00020\u0005HÖ\u0001J\n\u0010¥\u0001\u001a\u00020\u0003HÖ\u0001J\u001e\u0010¦\u0001\u001a\u00030§\u00012\b\u0010¨\u0001\u001a\u00030©\u00012\u0007\u0010ª\u0001\u001a\u00020\u0005HÖ\u0001R\u0015\u0010%\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00108\u001a\u0004\b6\u00107R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010=\u001a\u0004\b;\u0010<R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010:R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0011\u00100\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bA\u0010@R\u0011\u0010\u0014\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bB\u0010@R\u0011\u0010\u001b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bC\u0010@R\u0011\u0010\u0013\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bD\u0010@R\u0011\u00102\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bE\u0010@R\u0011\u0010'\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bF\u0010@R\u0011\u0010/\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bG\u0010@R\u0011\u0010,\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bH\u0010@R\u0013\u0010.\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u0010:R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010=\u001a\u0004\bJ\u0010<R\u001f\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010@R\u001f\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\bM\u0010LR\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00108\u001a\u0004\bN\u00107R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010Q\u001a\u0004\bO\u0010PR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010=\u001a\u0004\bR\u0010<R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00108\u001a\u0004\bS\u00107R\u0011\u0010&\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bT\u0010@R\u0011\u0010\"\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0011\u0010#\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bW\u0010VR\u0011\u0010$\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bX\u0010@R\u0011\u0010+\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bY\u0010VR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010Q\u001a\u0004\bZ\u0010PR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010=\u001a\u0004\b[\u0010<R\u0011\u0010!\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010@R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010=\u001a\u0004\b]\u0010<R\u0013\u00103\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b^\u0010:R\u0011\u0010*\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b_\u0010VR\u0011\u0010\u0016\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bb\u0010:R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bc\u0010VR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010:\"\u0004\be\u0010fR\u0015\u00104\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010Q\u001a\u0004\bg\u0010PR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010=\u001a\u0004\bh\u0010<R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bi\u0010VR\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00108\u001a\u0004\bj\u00107R\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bk\u0010:R\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bl\u0010@R\u0011\u00101\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bm\u0010@R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bn\u0010VR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010=\u001a\u0004\bo\u0010<¨\u0006«\u0001"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/IECNativeHomeArgument;", "Landroid/os/Parcelable;", "bundleConfigUrl", "", "loadMoreRangeSize", "", "videoSmoothEnter", "", "liveSmoothEnter", "bundlePreloaded", "disableBuiltin", "naOfflineVersion", "", "geckoExist", "isTopTabPage", "panelTopOffset", "topBarPreloadStrategy", "refreshEnable", "shouldCheckECPlugin", "enableFirstScreenStraightOut", "enableCorrectShowReport", "dataEngineTag", "pageCardDynamicParamTimeout", "pageCardSchema", "preloadTemplateConfig", "reportSlardar", "renderThreadStrategy", "enableEngineParentControl", "needLeaveRefresh", "leaveTimeout", "needReportLastAction", "lastActionLen", "sceneID", "needRefreshPage", "mallScrollTimeInterval", "mallStraightOutSync", "mallUpdateSuggestWorldByLynxCard", "bottomTabHeight", "mallFPSMonitorAfterFirstScreen", "enableMallFpsOpt", "grassParams", "", "pageCardDelayInit", "naMallPreloadStrategy", "exposureEventAsyncReport", "landingInfo", "geckoChannel", "enableTopBar", "enableBackground", "showHalfMallBar", "enableLoadGeckoInThread", "optForRebuildId", "rebuildTime", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;ZLjava/lang/Long;Ljava/lang/Boolean;ZIILjava/lang/Boolean;ZZZLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;IZLjava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;ZIIZLjava/lang/Integer;ZZLjava/util/Map;IIZLjava/util/Map;Ljava/lang/String;ZZZZLjava/lang/String;Ljava/lang/Long;)V", "getBottomTabHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBundleConfigUrl", "()Ljava/lang/String;", "getBundlePreloaded", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDataEngineTag", "getDisableBuiltin", "()Z", "getEnableBackground", "getEnableCorrectShowReport", "getEnableEngineParentControl", "getEnableFirstScreenStraightOut", "getEnableLoadGeckoInThread", "getEnableMallFpsOpt", "getEnableTopBar", "getExposureEventAsyncReport", "getGeckoChannel", "getGeckoExist", "getGrassParams", "()Ljava/util/Map;", "getLandingInfo", "getLastActionLen", "getLeaveTimeout", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLiveSmoothEnter", "getLoadMoreRangeSize", "getMallFPSMonitorAfterFirstScreen", "getMallScrollTimeInterval", "()I", "getMallStraightOutSync", "getMallUpdateSuggestWorldByLynxCard", "getNaMallPreloadStrategy", "getNaOfflineVersion", "getNeedLeaveRefresh", "getNeedRefreshPage", "getNeedReportLastAction", "getOptForRebuildId", "getPageCardDelayInit", "getPageCardDynamicParamTimeout", "()J", "getPageCardSchema", "getPanelTopOffset", "getPreloadTemplateConfig", "setPreloadTemplateConfig", "(Ljava/lang/String;)V", "getRebuildTime", "getRefreshEnable", "getRenderThreadStrategy", "getReportSlardar", "getSceneID", "getShouldCheckECPlugin", "getShowHalfMallBar", "getTopBarPreloadStrategy", "getVideoSmoothEnter", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;ZLjava/lang/Long;Ljava/lang/Boolean;ZIILjava/lang/Boolean;ZZZLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;IZLjava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;ZIIZLjava/lang/Integer;ZZLjava/util/Map;IIZLjava/util/Map;Ljava/lang/String;ZZZZLjava/lang/String;Ljava/lang/Long;)Lcom/bytedance/android/shopping/api/mall/IECNativeHomeArgument;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IECNativeHomeArgument implements Parcelable {
    public static final Parcelable.Creator<IECNativeHomeArgument> CREATOR = null;
    private final Integer bottomTabHeight;
    private final String bundleConfigUrl;
    private final Boolean bundlePreloaded;
    private final String dataEngineTag;
    private final boolean disableBuiltin;
    private final boolean enableBackground;
    private final boolean enableCorrectShowReport;
    private final boolean enableEngineParentControl;
    private final boolean enableFirstScreenStraightOut;
    private final boolean enableLoadGeckoInThread;
    private final boolean enableMallFpsOpt;
    private final boolean enableTopBar;
    private final boolean exposureEventAsyncReport;
    private final String geckoChannel;
    private final Boolean geckoExist;
    private final Map<String, String> grassParams;
    private final boolean isTopTabPage;
    private final Map<String, String> landingInfo;
    private final Integer lastActionLen;
    private final Long leaveTimeout;
    private final Boolean liveSmoothEnter;
    private final Integer loadMoreRangeSize;
    private final boolean mallFPSMonitorAfterFirstScreen;
    private final int mallScrollTimeInterval;
    private final int mallStraightOutSync;
    private final boolean mallUpdateSuggestWorldByLynxCard;
    private final int naMallPreloadStrategy;
    private final Long naOfflineVersion;
    private final Boolean needLeaveRefresh;
    private final boolean needRefreshPage;
    private final Boolean needReportLastAction;
    private final String optForRebuildId;
    private final int pageCardDelayInit;
    private final long pageCardDynamicParamTimeout;
    private final String pageCardSchema;
    private final int panelTopOffset;
    private String preloadTemplateConfig;
    private final Long rebuildTime;
    private final Boolean refreshEnable;
    private final int renderThreadStrategy;
    private final Integer reportSlardar;
    private final String sceneID;
    private final boolean shouldCheckECPlugin;
    private final boolean showHalfMallBar;
    private final int topBarPreloadStrategy;
    private final Boolean videoSmoothEnter;

    public static class a implements Parcelable.Creator<IECNativeHomeArgument> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final IECNativeHomeArgument createFromParcel(Parcel r56) {
            Intrinsics.checkNotNullParameter(r56, "in");
            String r2 = r56.readString();
            if (r56.readInt() == 0) goto L5;
            Integer r3 = Integer.valueOf(r56.readInt());
        L7:
            if (r56.readInt() != 0) goto L9;
            Boolean r5 = null;
        L15:
            if (r56.readInt() != 0) goto L17;
            Boolean r8 = null;
        L23:
            if (r56.readInt() != 0) goto L25;
            Boolean r9 = null;
        L31:
            if (r56.readInt() == 0) goto L33;
            boolean r10 = true;
        L35:
            if (r56.readInt() == 0) goto L37;
            Long r11 = Long.valueOf(r56.readLong());
        L39:
            if (r56.readInt() != 0) goto L41;
            Boolean r12 = null;
        L47:
            if (r56.readInt() == 0) goto L49;
            boolean r13 = true;
        L50:
            int r14 = r56.readInt();
            int r15 = r56.readInt();
            if (r56.readInt() != 0) goto L53;
            Boolean r16 = null;
        L59:
            if (r56.readInt() == 0) goto L61;
            boolean r17 = true;
        L63:
            if (r56.readInt() == 0) goto L65;
            boolean r18 = true;
        L67:
            if (r56.readInt() == 0) goto L69;
            boolean r19 = true;
        L70:
            String r20 = r56.readString();
            long r21 = r56.readLong();
            String r23 = r56.readString();
            String r24 = r56.readString();
            if (r56.readInt() == 0) goto L73;
            Integer r25 = Integer.valueOf(r56.readInt());
        L74:
            int r26 = r56.readInt();
            if (r56.readInt() == 0) goto L77;
            boolean r27 = true;
        L79:
            if (r56.readInt() != 0) goto L81;
            Boolean r28 = null;
        L87:
            if (r56.readInt() == 0) goto L89;
            Long r29 = Long.valueOf(r56.readLong());
        L91:
            if (r56.readInt() != 0) goto L93;
            Boolean r30 = null;
        L99:
            if (r56.readInt() == 0) goto L101;
            Integer r31 = Integer.valueOf(r56.readInt());
        L102:
            String r32 = r56.readString();
            if (r56.readInt() == 0) goto L105;
            boolean r33 = true;
        L106:
            int r34 = r56.readInt();
            int r35 = r56.readInt();
            if (r56.readInt() == 0) goto L109;
            boolean r36 = true;
        L111:
            if (r56.readInt() == 0) goto L113;
            Integer r37 = Integer.valueOf(r56.readInt());
        L115:
            if (r56.readInt() == 0) goto L117;
            boolean r38 = true;
        L119:
            if (r56.readInt() == 0) goto L121;
            boolean r39 = true;
        L123:
            if (r56.readInt() == 0) goto L128;
            int r4 = r56.readInt();
            LinkedHashMap r6 = new LinkedHashMap(r4);
        L125:
            if (r4 == 0) goto L127;
            r6.put(r56.readString(), r56.readString());
            r4 = r4 - 1;
            goto L125
        L127:
            LinkedHashMap r43 = r6;
        L129:
            int r44 = r56.readInt();
            int r45 = r56.readInt();
            if (r56.readInt() == 0) goto L132;
            boolean r46 = true;
        L134:
            if (r56.readInt() == 0) goto L139;
            int r1 = r56.readInt();
            LinkedHashMap r7 = new LinkedHashMap(r1);
        L136:
            if (r1 == 0) goto L138;
            r7.put(r56.readString(), r56.readString());
            r1 = r1 - 1;
            goto L136
        L138:
            LinkedHashMap r47 = r7;
        L140:
            String r48 = r56.readString();
            if (r56.readInt() == 0) goto L143;
            boolean r49 = true;
        L145:
            if (r56.readInt() == 0) goto L147;
            boolean r50 = true;
        L149:
            if (r56.readInt() == 0) goto L151;
            boolean r51 = true;
        L153:
            if (r56.readInt() == 0) goto L155;
            boolean r52 = true;
        L156:
            String r53 = r56.readString();
            if (r56.readInt() == 0) goto L159;
            Long r54 = Long.valueOf(r56.readLong());
        L161:
            return new IECNativeHomeArgument(r2, r3, r5, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54);
        L159:
            r54 = null;
            goto L161
        L155:
            r52 = false;
            goto L156
        L151:
            r51 = false;
            goto L153
        L147:
            r50 = false;
            goto L149
        L143:
            r49 = false;
            goto L145
        L139:
            r47 = null;
            goto L140
        L132:
            r46 = false;
            goto L134
        L128:
            r43 = null;
            goto L129
        L121:
            r39 = false;
            goto L123
        L117:
            r38 = false;
            goto L119
        L113:
            r37 = null;
            goto L115
        L109:
            r36 = false;
            goto L111
        L105:
            r33 = false;
            goto L106
        L101:
            r31 = null;
            goto L102
        L93:
            if (r56.readInt() == 0) goto L95;
            boolean r310 = true;
        L96:
            r30 = Boolean.valueOf(r310);
            goto L99
        L95:
            r310 = false;
            goto L96
        L89:
            r29 = null;
            goto L91
        L81:
            if (r56.readInt() == 0) goto L83;
            boolean r210 = true;
        L84:
            r28 = Boolean.valueOf(r210);
            goto L87
        L83:
            r210 = false;
            goto L84
        L77:
            r27 = false;
            goto L79
        L73:
            r25 = null;
            goto L74
        L69:
            r19 = false;
            goto L70
        L65:
            r18 = false;
            goto L67
        L61:
            r17 = false;
            goto L63
        L53:
            if (r56.readInt() == 0) goto L55;
            boolean r110 = true;
        L56:
            r16 = Boolean.valueOf(r110);
            goto L59
        L55:
            r110 = false;
            goto L56
        L49:
            r13 = false;
            goto L50
        L41:
            if (r56.readInt() == 0) goto L43;
            boolean r111 = true;
        L44:
            r12 = Boolean.valueOf(r111);
            goto L47
        L43:
            r111 = false;
            goto L44
        L37:
            r11 = null;
            goto L39
        L33:
            r10 = false;
            goto L35
        L25:
            if (r56.readInt() == 0) goto L27;
            boolean r22 = true;
        L28:
            r9 = Boolean.valueOf(r22);
            goto L31
        L27:
            r22 = false;
            goto L28
        L17:
            if (r56.readInt() == 0) goto L19;
            boolean r40 = true;
        L20:
            r8 = Boolean.valueOf(r40);
            goto L23
        L19:
            r40 = false;
            goto L20
        L9:
            if (r56.readInt() == 0) goto L11;
            boolean r41 = true;
        L12:
            r5 = Boolean.valueOf(r41);
            goto L15
        L11:
            r41 = false;
            goto L12
        L5:
            r3 = null;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final IECNativeHomeArgument[] newArray(int r1) {
            return new IECNativeHomeArgument[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IECNativeHomeArgument copy$default(IECNativeHomeArgument r17, String r18, Integer r19, Boolean r20, Boolean r21, Boolean r22, boolean r23, Long r24, Boolean r25, boolean r26, int r27, int r28, Boolean r29, boolean r30, boolean r31, boolean r32, String r33, long r34, String r36, String r37, Integer r38, int r39, boolean r40, Boolean r41, Long r42, Boolean r43, Integer r44, String r45, boolean r46, int r47, int r48, boolean r49, Integer r50, boolean r51, boolean r52, Map r53, int r54, int r55, boolean r56, Map r57, String r58, boolean r59, boolean r60, boolean r61, boolean r62, String r63, Long r64, int r65, int r66, Object r67) {
        if ((r65 & 1) == 0) goto L5;
        String r3 = r17.bundleConfigUrl;
    L7:
        if ((r65 & 2) == 0) goto L9;
        Integer r4 = r17.loadMoreRangeSize;
    L11:
        if ((r65 & 4) == 0) goto L13;
        Boolean r5 = r17.videoSmoothEnter;
    L15:
        if ((r65 & 8) == 0) goto L17;
        Boolean r6 = r17.liveSmoothEnter;
    L19:
        if ((r65 & 16) == 0) goto L21;
        Boolean r7 = r17.bundlePreloaded;
    L23:
        if ((r65 & 32) == 0) goto L25;
        boolean r8 = r17.disableBuiltin;
    L27:
        if ((r65 & 64) == 0) goto L29;
        Long r9 = r17.naOfflineVersion;
    L31:
        if ((r65 & 128) == 0) goto L33;
        Boolean r10 = r17.geckoExist;
    L35:
        if ((r65 & 256) == 0) goto L37;
        boolean r11 = r17.isTopTabPage;
    L39:
        if ((r65 & 512) == 0) goto L41;
        int r12 = r17.panelTopOffset;
    L43:
        if ((r65 & 1024) == 0) goto L45;
        int r13 = r17.topBarPreloadStrategy;
    L47:
        if ((r65 & 2048) == 0) goto L49;
        Boolean r14 = r17.refreshEnable;
    L51:
        if ((r65 & 4096) == 0) goto L53;
        boolean r15 = r17.shouldCheckECPlugin;
    L54:
        boolean r35 = r15;
        if ((r65 & 8192) == 0) goto L57;
        boolean r16 = r17.enableFirstScreenStraightOut;
    L58:
        boolean r310 = r16;
        if ((r65 & 16384) == 0) goto L61;
        boolean r110 = r17.enableCorrectShowReport;
    L62:
        boolean r311 = r110;
        if ((r65 & 32768) == 0) goto L65;
        String r111 = r17.dataEngineTag;
    L66:
        Boolean r210 = r14;
        String r312 = r111;
        if ((r65 & 65536) == 0) goto L69;
        long r112 = r17.pageCardDynamicParamTimeout;
    L70:
        long r313 = r112;
        if ((r65 & 131072) == 0) goto L73;
        String r113 = r17.pageCardSchema;
    L75:
        if ((262144 & r65) == 0) goto L77;
        String r114 = r17.preloadTemplateConfig;
    L78:
        String r314 = r114;
        if ((r65 & 524288) == 0) goto L81;
        Integer r115 = r17.reportSlardar;
    L82:
        Integer r315 = r115;
        if ((r65 & 1048576) == 0) goto L85;
        int r116 = r17.renderThreadStrategy;
    L86:
        int r316 = r116;
        if ((r65 & 2097152) == 0) goto L89;
        boolean r117 = r17.enableEngineParentControl;
    L90:
        boolean r410 = r117;
        if ((r65 & 4194304) == 0) goto L93;
        Boolean r118 = r17.needLeaveRefresh;
    L94:
        Boolean r411 = r118;
        if ((r65 & 8388608) == 0) goto L97;
        Long r119 = r17.leaveTimeout;
    L98:
        Long r412 = r119;
        if ((r65 & 16777216) == 0) goto L101;
        Boolean r120 = r17.needReportLastAction;
    L102:
        Boolean r413 = r120;
        if ((r65 & 33554432) == 0) goto L105;
        Integer r121 = r17.lastActionLen;
    L106:
        Integer r414 = r121;
        if ((r65 & 67108864) == 0) goto L109;
        String r122 = r17.sceneID;
    L110:
        String r415 = r122;
        if ((r65 & 134217728) == 0) goto L113;
        boolean r123 = r17.needRefreshPage;
    L114:
        boolean r416 = r123;
        if ((r65 & 268435456) == 0) goto L117;
        int r124 = r17.mallScrollTimeInterval;
    L118:
        int r417 = r124;
        if ((r65 & 536870912) == 0) goto L121;
        int r125 = r17.mallStraightOutSync;
    L122:
        int r418 = r125;
        if ((r65 & 1073741824) == 0) goto L125;
        boolean r126 = r17.mallUpdateSuggestWorldByLynxCard;
    L127:
        if ((r65 & Integer.MIN_VALUE) == 0) goto L129;
        Integer r1 = r17.bottomTabHeight;
    L130:
        Integer r510 = r1;
        if ((r66 & 1) == 0) goto L133;
        boolean r2 = r17.mallFPSMonitorAfterFirstScreen;
    L134:
        boolean r511 = r2;
        if ((r66 & 2) == 0) goto L137;
        boolean r68 = r17.enableMallFpsOpt;
    L138:
        boolean r512 = r68;
        if ((r66 & 4) == 0) goto L141;
        Map r69 = r17.grassParams;
    L142:
        Map r513 = r69;
        if ((r66 & 8) == 0) goto L145;
        int r70 = r17.pageCardDelayInit;
    L146:
        int r514 = r70;
        if ((r66 & 16) == 0) goto L149;
        int r71 = r17.naMallPreloadStrategy;
    L150:
        int r515 = r71;
        if ((r66 & 32) == 0) goto L153;
        boolean r72 = r17.exposureEventAsyncReport;
    L154:
        boolean r516 = r72;
        if ((r66 & 64) == 0) goto L157;
        Map r73 = r17.landingInfo;
    L158:
        Map r517 = r73;
        if ((r66 & 128) == 0) goto L161;
        String r74 = r17.geckoChannel;
    L162:
        String r518 = r74;
        if ((r66 & 256) == 0) goto L165;
        boolean r75 = r17.enableTopBar;
    L166:
        boolean r519 = r75;
        if ((r66 & 512) == 0) goto L169;
        boolean r76 = r17.enableBackground;
    L170:
        boolean r610 = r76;
        if ((r66 & 1024) == 0) goto L173;
        boolean r77 = r17.showHalfMallBar;
    L174:
        boolean r611 = r77;
        if ((r66 & 2048) == 0) goto L177;
        boolean r78 = r17.enableLoadGeckoInThread;
    L178:
        boolean r612 = r78;
        if ((r66 & 4096) == 0) goto L181;
        String r79 = r17.optForRebuildId;
    L183:
        if ((r66 & 8192) == 0) goto L185;
        Long r80 = r17.rebuildTime;
    L187:
        return r17.copy(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r210, r35, r310, r311, r312, r313, r113, r314, r315, r316, r410, r411, r412, r413, r414, r415, r416, r417, r418, r126, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r79, r80);
    L185:
        r80 = r64;
        goto L187
    L181:
        r79 = r63;
        goto L183
    L177:
        r78 = r62;
        goto L178
    L173:
        r77 = r61;
        goto L174
    L169:
        r76 = r60;
        goto L170
    L165:
        r75 = r59;
        goto L166
    L161:
        r74 = r58;
        goto L162
    L157:
        r73 = r57;
        goto L158
    L153:
        r72 = r56;
        goto L154
    L149:
        r71 = r55;
        goto L150
    L145:
        r70 = r54;
        goto L146
    L141:
        r69 = r53;
        goto L142
    L137:
        r68 = r52;
        goto L138
    L133:
        r2 = r51;
        goto L134
    L129:
        r1 = r50;
        goto L130
    L125:
        r126 = r49;
        goto L127
    L121:
        r125 = r48;
        goto L122
    L117:
        r124 = r47;
        goto L118
    L113:
        r123 = r46;
        goto L114
    L109:
        r122 = r45;
        goto L110
    L105:
        r121 = r44;
        goto L106
    L101:
        r120 = r43;
        goto L102
    L97:
        r119 = r42;
        goto L98
    L93:
        r118 = r41;
        goto L94
    L89:
        r117 = r40;
        goto L90
    L85:
        r116 = r39;
        goto L86
    L81:
        r115 = r38;
        goto L82
    L77:
        r114 = r37;
        goto L78
    L73:
        r113 = r36;
        goto L75
    L69:
        r112 = r34;
        goto L70
    L65:
        r111 = r33;
        goto L66
    L61:
        r110 = r32;
        goto L62
    L57:
        r16 = r31;
        goto L58
    L53:
        r15 = r30;
        goto L54
    L49:
        r14 = r29;
        goto L51
    L45:
        r13 = r28;
        goto L47
    L41:
        r12 = r27;
        goto L43
    L37:
        r11 = r26;
        goto L39
    L33:
        r10 = r25;
        goto L35
    L29:
        r9 = r24;
        goto L31
    L25:
        r8 = r23;
        goto L27
    L21:
        r7 = r22;
        goto L23
    L17:
        r6 = r21;
        goto L19
    L13:
        r5 = r20;
        goto L15
    L9:
        r4 = r19;
        goto L11
    L5:
        r3 = r18;
        goto L7
    }

    public final String component1() {
        return this.bundleConfigUrl;
    }

    public final int component10() {
        return this.panelTopOffset;
    }

    public final int component11() {
        return this.topBarPreloadStrategy;
    }

    public final Boolean component12() {
        return this.refreshEnable;
    }

    public final boolean component13() {
        return this.shouldCheckECPlugin;
    }

    public final boolean component14() {
        return this.enableFirstScreenStraightOut;
    }

    public final boolean component15() {
        return this.enableCorrectShowReport;
    }

    public final String component16() {
        return this.dataEngineTag;
    }

    public final long component17() {
        return this.pageCardDynamicParamTimeout;
    }

    public final String component18() {
        return this.pageCardSchema;
    }

    public final String component19() {
        return this.preloadTemplateConfig;
    }

    public final Integer component2() {
        return this.loadMoreRangeSize;
    }

    public final Integer component20() {
        return this.reportSlardar;
    }

    public final int component21() {
        return this.renderThreadStrategy;
    }

    public final boolean component22() {
        return this.enableEngineParentControl;
    }

    public final Boolean component23() {
        return this.needLeaveRefresh;
    }

    public final Long component24() {
        return this.leaveTimeout;
    }

    public final Boolean component25() {
        return this.needReportLastAction;
    }

    public final Integer component26() {
        return this.lastActionLen;
    }

    public final String component27() {
        return this.sceneID;
    }

    public final boolean component28() {
        return this.needRefreshPage;
    }

    public final int component29() {
        return this.mallScrollTimeInterval;
    }

    public final Boolean component3() {
        return this.videoSmoothEnter;
    }

    public final int component30() {
        return this.mallStraightOutSync;
    }

    public final boolean component31() {
        return this.mallUpdateSuggestWorldByLynxCard;
    }

    public final Integer component32() {
        return this.bottomTabHeight;
    }

    public final boolean component33() {
        return this.mallFPSMonitorAfterFirstScreen;
    }

    public final boolean component34() {
        return this.enableMallFpsOpt;
    }

    public final Map<String, String> component35() {
        return this.grassParams;
    }

    public final int component36() {
        return this.pageCardDelayInit;
    }

    public final int component37() {
        return this.naMallPreloadStrategy;
    }

    public final boolean component38() {
        return this.exposureEventAsyncReport;
    }

    public final Map<String, String> component39() {
        return this.landingInfo;
    }

    public final Boolean component4() {
        return this.liveSmoothEnter;
    }

    public final String component40() {
        return this.geckoChannel;
    }

    public final boolean component41() {
        return this.enableTopBar;
    }

    public final boolean component42() {
        return this.enableBackground;
    }

    public final boolean component43() {
        return this.showHalfMallBar;
    }

    public final boolean component44() {
        return this.enableLoadGeckoInThread;
    }

    public final String component45() {
        return this.optForRebuildId;
    }

    public final Long component46() {
        return this.rebuildTime;
    }

    public final Boolean component5() {
        return this.bundlePreloaded;
    }

    public final boolean component6() {
        return this.disableBuiltin;
    }

    public final Long component7() {
        return this.naOfflineVersion;
    }

    public final Boolean component8() {
        return this.geckoExist;
    }

    public final boolean component9() {
        return this.isTopTabPage;
    }

    public final IECNativeHomeArgument copy(String r50, Integer r51, Boolean r52, Boolean r53, Boolean r54, boolean r55, Long r56, Boolean r57, boolean r58, int r59, int r60, Boolean r61, boolean r62, boolean r63, boolean r64, String r65, long r66, String r68, String r69, Integer r70, int r71, boolean r72, Boolean r73, Long r74, Boolean r75, Integer r76, String r77, boolean r78, int r79, int r80, boolean r81, Integer r82, boolean r84, boolean r85, Map<String, String> r86, int r87, int r88, boolean r89, Map<String, String> r810, String r90, boolean r91, boolean r92, boolean r94, boolean r95, String r96, Long r97) {
        Intrinsics.checkNotNullParameter(r65, "dataEngineTag");
        Intrinsics.checkNotNullParameter(r77, "sceneID");
        return new IECNativeHomeArgument(r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r84, r85, r86, r87, r88, r89, r810, r90, r91, r92, r94, r95, r96, r97);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof IECNativeHomeArgument) == false) goto L98;
        IECNativeHomeArgument r7 = (IECNativeHomeArgument) r6;
        if (Intrinsics.areEqual(this.bundleConfigUrl, r7.bundleConfigUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.loadMoreRangeSize, r7.loadMoreRangeSize) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.videoSmoothEnter, r7.videoSmoothEnter) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.liveSmoothEnter, r7.liveSmoothEnter) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.bundlePreloaded, r7.bundlePreloaded) == true) goto L16;
        return false;
    L16:
        if (this.disableBuiltin == r7.disableBuiltin) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.naOfflineVersion, r7.naOfflineVersion) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.geckoExist, r7.geckoExist) == true) goto L22;
        return false;
    L22:
        if (this.isTopTabPage == r7.isTopTabPage) goto L24;
        return false;
    L24:
        if (this.panelTopOffset == r7.panelTopOffset) goto L26;
        return false;
    L26:
        if (this.topBarPreloadStrategy == r7.topBarPreloadStrategy) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.refreshEnable, r7.refreshEnable) == true) goto L30;
        return false;
    L30:
        if (this.shouldCheckECPlugin == r7.shouldCheckECPlugin) goto L32;
        return false;
    L32:
        if (this.enableFirstScreenStraightOut == r7.enableFirstScreenStraightOut) goto L34;
        return false;
    L34:
        if (this.enableCorrectShowReport == r7.enableCorrectShowReport) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.dataEngineTag, r7.dataEngineTag) == true) goto L38;
        return false;
    L38:
        if (this.pageCardDynamicParamTimeout == r7.pageCardDynamicParamTimeout) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.pageCardSchema, r7.pageCardSchema) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.preloadTemplateConfig, r7.preloadTemplateConfig) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.reportSlardar, r7.reportSlardar) == true) goto L46;
        return false;
    L46:
        if (this.renderThreadStrategy == r7.renderThreadStrategy) goto L48;
        return false;
    L48:
        if (this.enableEngineParentControl == r7.enableEngineParentControl) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.needLeaveRefresh, r7.needLeaveRefresh) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.leaveTimeout, r7.leaveTimeout) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.needReportLastAction, r7.needReportLastAction) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.lastActionLen, r7.lastActionLen) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.sceneID, r7.sceneID) == true) goto L60;
        return false;
    L60:
        if (this.needRefreshPage == r7.needRefreshPage) goto L62;
        return false;
    L62:
        if (this.mallScrollTimeInterval == r7.mallScrollTimeInterval) goto L64;
        return false;
    L64:
        if (this.mallStraightOutSync == r7.mallStraightOutSync) goto L66;
        return false;
    L66:
        if (this.mallUpdateSuggestWorldByLynxCard == r7.mallUpdateSuggestWorldByLynxCard) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.bottomTabHeight, r7.bottomTabHeight) == true) goto L70;
        return false;
    L70:
        if (this.mallFPSMonitorAfterFirstScreen == r7.mallFPSMonitorAfterFirstScreen) goto L72;
        return false;
    L72:
        if (this.enableMallFpsOpt == r7.enableMallFpsOpt) goto L74;
        return false;
    L74:
        if (Intrinsics.areEqual(this.grassParams, r7.grassParams) == true) goto L76;
        return false;
    L76:
        if (this.pageCardDelayInit == r7.pageCardDelayInit) goto L78;
        return false;
    L78:
        if (this.naMallPreloadStrategy == r7.naMallPreloadStrategy) goto L80;
        return false;
    L80:
        if (this.exposureEventAsyncReport == r7.exposureEventAsyncReport) goto L82;
        return false;
    L82:
        if (Intrinsics.areEqual(this.landingInfo, r7.landingInfo) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.geckoChannel, r7.geckoChannel) == true) goto L86;
        return false;
    L86:
        if (this.enableTopBar == r7.enableTopBar) goto L88;
        return false;
    L88:
        if (this.enableBackground == r7.enableBackground) goto L90;
        return false;
    L90:
        if (this.showHalfMallBar == r7.showHalfMallBar) goto L92;
        return false;
    L92:
        if (this.enableLoadGeckoInThread == r7.enableLoadGeckoInThread) goto L94;
        return false;
    L94:
        if (Intrinsics.areEqual(this.optForRebuildId, r7.optForRebuildId) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.rebuildTime, r7.rebuildTime) == true) goto L148;
        return false;
    L148:
        return true;
    L98:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v103 */
    /* JADX WARN: Type inference failed for: r2v104 */
    /* JADX WARN: Type inference failed for: r2v105 */
    /* JADX WARN: Type inference failed for: r2v108 */
    /* JADX WARN: Type inference failed for: r2v110 */
    /* JADX WARN: Type inference failed for: r2v111 */
    /* JADX WARN: Type inference failed for: r2v113 */
    /* JADX WARN: Type inference failed for: r2v114 */
    /* JADX WARN: Type inference failed for: r2v120 */
    /* JADX WARN: Type inference failed for: r2v125 */
    /* JADX WARN: Type inference failed for: r2v126 */
    /* JADX WARN: Type inference failed for: r2v127 */
    /* JADX WARN: Type inference failed for: r2v129 */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v132 */
    /* JADX WARN: Type inference failed for: r2v137 */
    /* JADX WARN: Type inference failed for: r2v138 */
    /* JADX WARN: Type inference failed for: r2v139 */
    /* JADX WARN: Type inference failed for: r2v140 */
    /* JADX WARN: Type inference failed for: r2v141 */
    /* JADX WARN: Type inference failed for: r2v142 */
    /* JADX WARN: Type inference failed for: r2v143 */
    /* JADX WARN: Type inference failed for: r2v144 */
    /* JADX WARN: Type inference failed for: r2v145 */
    /* JADX WARN: Type inference failed for: r2v146 */
    /* JADX WARN: Type inference failed for: r2v147 */
    /* JADX WARN: Type inference failed for: r2v148 */
    /* JADX WARN: Type inference failed for: r2v149 */
    /* JADX WARN: Type inference failed for: r2v150 */
    /* JADX WARN: Type inference failed for: r2v21, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28, types: [int] */
    /* JADX WARN: Type inference failed for: r2v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v32, types: [int] */
    /* JADX WARN: Type inference failed for: r2v49, types: [int] */
    /* JADX WARN: Type inference failed for: r2v66, types: [int] */
    /* JADX WARN: Type inference failed for: r2v70, types: [int] */
    /* JADX WARN: Type inference failed for: r2v75, types: [int] */
    /* JADX WARN: Type inference failed for: r2v77, types: [int] */
    /* JADX WARN: Type inference failed for: r2v84, types: [int] */
    /* JADX WARN: Type inference failed for: r2v92, types: [int] */
    /* JADX WARN: Type inference failed for: r2v94, types: [int] */
    /* JADX WARN: Type inference failed for: r2v96, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String r0 = this.bundleConfigUrl;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.loadMoreRangeSize;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.videoSmoothEnter;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.liveSmoothEnter;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.bundlePreloaded;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        boolean r16 = this.disableBuiltin;
        ?? r17 = 1;
        ?? r18 = r16;
        if (r16 == false) goto L25;
        r18 = 1;
    L25:
        int r19 = (r15 + r18) * 31;
        Long r20 = this.naOfflineVersion;
        if (r20 == null) goto L28;
        int r21 = r20.hashCode();
    L29:
        int r22 = (r19 + r21) * 31;
        Boolean r23 = this.geckoExist;
        if (r23 == null) goto L32;
        int r24 = r23.hashCode();
    L33:
        int r25 = (r22 + r24) * 31;
        boolean r26 = this.isTopTabPage;
        ?? r27 = r26;
        if (r26 == false) goto L36;
        r27 = 1;
    L36:
        int r28 = (((((r25 + r27) * 31) + this.panelTopOffset) * 31) + this.topBarPreloadStrategy) * 31;
        Boolean r29 = this.refreshEnable;
        if (r29 == null) goto L39;
        int r30 = r29.hashCode();
    L40:
        int r31 = (r28 + r30) * 31;
        boolean r32 = this.shouldCheckECPlugin;
        ?? r33 = r32;
        if (r32 == false) goto L43;
        r33 = 1;
    L43:
        int r34 = (r31 + r33) * 31;
        boolean r35 = this.enableFirstScreenStraightOut;
        ?? r36 = r35;
        if (r35 == false) goto L46;
        r36 = 1;
    L46:
        int r37 = (r34 + r36) * 31;
        boolean r38 = this.enableCorrectShowReport;
        ?? r39 = r38;
        if (r38 == false) goto L49;
        r39 = 1;
    L49:
        int r40 = (r37 + r39) * 31;
        String r41 = this.dataEngineTag;
        if (r41 == null) goto L52;
        int r42 = r41.hashCode();
    L53:
        long r43 = this.pageCardDynamicParamTimeout;
        int r44 = (((r40 + r42) * 31) + ((int) (r43 ^ (r43 >>> 32)))) * 31;
        String r45 = this.pageCardSchema;
        if (r45 == null) goto L56;
        int r46 = r45.hashCode();
    L57:
        int r47 = (r44 + r46) * 31;
        String r48 = this.preloadTemplateConfig;
        if (r48 == null) goto L60;
        int r49 = r48.hashCode();
    L61:
        int r50 = (r47 + r49) * 31;
        Integer r51 = this.reportSlardar;
        if (r51 == null) goto L64;
        int r52 = r51.hashCode();
    L65:
        int r53 = (((r50 + r52) * 31) + this.renderThreadStrategy) * 31;
        boolean r54 = this.enableEngineParentControl;
        ?? r55 = r54;
        if (r54 == false) goto L68;
        r55 = 1;
    L68:
        int r56 = (r53 + r55) * 31;
        Boolean r57 = this.needLeaveRefresh;
        if (r57 == null) goto L71;
        int r58 = r57.hashCode();
    L72:
        int r59 = (r56 + r58) * 31;
        Long r60 = this.leaveTimeout;
        if (r60 == null) goto L75;
        int r61 = r60.hashCode();
    L76:
        int r62 = (r59 + r61) * 31;
        Boolean r63 = this.needReportLastAction;
        if (r63 == null) goto L79;
        int r64 = r63.hashCode();
    L80:
        int r65 = (r62 + r64) * 31;
        Integer r66 = this.lastActionLen;
        if (r66 == null) goto L83;
        int r67 = r66.hashCode();
    L84:
        int r68 = (r65 + r67) * 31;
        String r69 = this.sceneID;
        if (r69 == null) goto L87;
        int r70 = r69.hashCode();
    L88:
        int r71 = (r68 + r70) * 31;
        boolean r72 = this.needRefreshPage;
        ?? r73 = r72;
        if (r72 == false) goto L91;
        r73 = 1;
    L91:
        int r74 = (((((r71 + r73) * 31) + this.mallScrollTimeInterval) * 31) + this.mallStraightOutSync) * 31;
        boolean r75 = this.mallUpdateSuggestWorldByLynxCard;
        ?? r76 = r75;
        if (r75 == false) goto L94;
        r76 = 1;
    L94:
        int r77 = (r74 + r76) * 31;
        Integer r78 = this.bottomTabHeight;
        if (r78 == null) goto L97;
        int r79 = r78.hashCode();
    L98:
        int r80 = (r77 + r79) * 31;
        boolean r81 = this.mallFPSMonitorAfterFirstScreen;
        ?? r82 = r81;
        if (r81 == false) goto L101;
        r82 = 1;
    L101:
        int r84 = (r80 + r82) * 31;
        boolean r85 = this.enableMallFpsOpt;
        ?? r86 = r85;
        if (r85 == false) goto L104;
        r86 = 1;
    L104:
        int r87 = (r84 + r86) * 31;
        Map<String, String> r88 = this.grassParams;
        if (r88 == null) goto L107;
        int r89 = r88.hashCode();
    L108:
        int r90 = (((((r87 + r89) * 31) + this.pageCardDelayInit) * 31) + this.naMallPreloadStrategy) * 31;
        boolean r91 = this.exposureEventAsyncReport;
        ?? r92 = r91;
        if (r91 == false) goto L111;
        r92 = 1;
    L111:
        int r94 = (r90 + r92) * 31;
        Map<String, String> r95 = this.landingInfo;
        if (r95 == null) goto L114;
        int r96 = r95.hashCode();
    L115:
        int r97 = (r94 + r96) * 31;
        String r98 = this.geckoChannel;
        if (r98 == null) goto L118;
        int r99 = r98.hashCode();
    L119:
        int r100 = (r97 + r99) * 31;
        boolean r101 = this.enableTopBar;
        ?? r102 = r101;
        if (r101 == false) goto L122;
        r102 = 1;
    L122:
        int r103 = (r100 + r102) * 31;
        boolean r104 = this.enableBackground;
        ?? r105 = r104;
        if (r104 == false) goto L125;
        r105 = 1;
    L125:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.showHalfMallBar;
        ?? r108 = r107;
        if (r107 == false) goto L128;
        r108 = 1;
    L128:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.enableLoadGeckoInThread;
        if (r110 == true) goto L132;
        r17 = r110;
    L132:
        int r111 = (r109 + r17) * 31;
        String r112 = this.optForRebuildId;
        if (r112 == null) goto L135;
        int r113 = r112.hashCode();
    L136:
        int r114 = (r111 + r113) * 31;
        Long r115 = this.rebuildTime;
        if (r115 == null) goto L140;
        r1 = r115.hashCode();
    L140:
        return r114 + r1;
    L135:
        r113 = 0;
        goto L136
    L118:
        r99 = 0;
        goto L119
    L114:
        r96 = 0;
        goto L115
    L107:
        r89 = 0;
        goto L108
    L97:
        r79 = 0;
        goto L98
    L87:
        r70 = 0;
        goto L88
    L83:
        r67 = 0;
        goto L84
    L79:
        r64 = 0;
        goto L80
    L75:
        r61 = 0;
        goto L76
    L71:
        r58 = 0;
        goto L72
    L64:
        r52 = 0;
        goto L65
    L60:
        r49 = 0;
        goto L61
    L56:
        r46 = 0;
        goto L57
    L52:
        r42 = 0;
        goto L53
    L39:
        r30 = 0;
        goto L40
    L32:
        r24 = 0;
        goto L33
    L28:
        r21 = 0;
        goto L29
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "IECNativeHomeArgument(bundleConfigUrl=" + this.bundleConfigUrl + ", loadMoreRangeSize=" + this.loadMoreRangeSize + ", videoSmoothEnter=" + this.videoSmoothEnter + ", liveSmoothEnter=" + this.liveSmoothEnter + ", bundlePreloaded=" + this.bundlePreloaded + ", disableBuiltin=" + this.disableBuiltin + ", naOfflineVersion=" + this.naOfflineVersion + ", geckoExist=" + this.geckoExist + ", isTopTabPage=" + this.isTopTabPage + ", panelTopOffset=" + this.panelTopOffset + ", topBarPreloadStrategy=" + this.topBarPreloadStrategy + ", refreshEnable=" + this.refreshEnable + ", shouldCheckECPlugin=" + this.shouldCheckECPlugin + ", enableFirstScreenStraightOut=" + this.enableFirstScreenStraightOut + ", enableCorrectShowReport=" + this.enableCorrectShowReport + ", dataEngineTag=" + this.dataEngineTag + ", pageCardDynamicParamTimeout=" + this.pageCardDynamicParamTimeout + ", pageCardSchema=" + this.pageCardSchema + ", preloadTemplateConfig=" + this.preloadTemplateConfig + ", reportSlardar=" + this.reportSlardar + ", renderThreadStrategy=" + this.renderThreadStrategy + ", enableEngineParentControl=" + this.enableEngineParentControl + ", needLeaveRefresh=" + this.needLeaveRefresh + ", leaveTimeout=" + this.leaveTimeout + ", needReportLastAction=" + this.needReportLastAction + ", lastActionLen=" + this.lastActionLen + ", sceneID=" + this.sceneID + ", needRefreshPage=" + this.needRefreshPage + ", mallScrollTimeInterval=" + this.mallScrollTimeInterval + ", mallStraightOutSync=" + this.mallStraightOutSync + ", mallUpdateSuggestWorldByLynxCard=" + this.mallUpdateSuggestWorldByLynxCard + ", bottomTabHeight=" + this.bottomTabHeight + ", mallFPSMonitorAfterFirstScreen=" + this.mallFPSMonitorAfterFirstScreen + ", enableMallFpsOpt=" + this.enableMallFpsOpt + ", grassParams=" + this.grassParams + ", pageCardDelayInit=" + this.pageCardDelayInit + ", naMallPreloadStrategy=" + this.naMallPreloadStrategy + ", exposureEventAsyncReport=" + this.exposureEventAsyncReport + ", landingInfo=" + this.landingInfo + ", geckoChannel=" + this.geckoChannel + ", enableTopBar=" + this.enableTopBar + ", enableBackground=" + this.enableBackground + ", showHalfMallBar=" + this.showHalfMallBar + ", enableLoadGeckoInThread=" + this.enableLoadGeckoInThread + ", optForRebuildId=" + this.optForRebuildId + ", rebuildTime=" + this.rebuildTime + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        r5.writeString(this.bundleConfigUrl);
        Integer r7 = this.loadMoreRangeSize;
        if (r7 == null) goto L5;
        r5.writeInt(1);
        r5.writeInt(r7.intValue());
    L6:
        Boolean r8 = this.videoSmoothEnter;
        if (r8 == null) goto L9;
        r5.writeInt(1);
        r5.writeInt(r8.booleanValue() ? 1 : 0);
    L10:
        Boolean r9 = this.liveSmoothEnter;
        if (r9 == null) goto L13;
        r5.writeInt(1);
        r5.writeInt(r9.booleanValue() ? 1 : 0);
    L14:
        Boolean r10 = this.bundlePreloaded;
        if (r10 == null) goto L17;
        r5.writeInt(1);
        r5.writeInt(r10.booleanValue() ? 1 : 0);
    L18:
        r5.writeInt(this.disableBuiltin ? 1 : 0);
        Long r11 = this.naOfflineVersion;
        if (r11 == null) goto L21;
        r5.writeInt(1);
        r5.writeLong(r11.longValue());
    L22:
        Boolean r12 = this.geckoExist;
        if (r12 == null) goto L25;
        r5.writeInt(1);
        r5.writeInt(r12.booleanValue() ? 1 : 0);
    L26:
        r5.writeInt(this.isTopTabPage ? 1 : 0);
        r5.writeInt(this.panelTopOffset);
        r5.writeInt(this.topBarPreloadStrategy);
        Boolean r13 = this.refreshEnable;
        if (r13 == null) goto L29;
        r5.writeInt(1);
        r5.writeInt(r13.booleanValue() ? 1 : 0);
    L30:
        r5.writeInt(this.shouldCheckECPlugin ? 1 : 0);
        r5.writeInt(this.enableFirstScreenStraightOut ? 1 : 0);
        r5.writeInt(this.enableCorrectShowReport ? 1 : 0);
        r5.writeString(this.dataEngineTag);
        r5.writeLong(this.pageCardDynamicParamTimeout);
        r5.writeString(this.pageCardSchema);
        r5.writeString(this.preloadTemplateConfig);
        Integer r14 = this.reportSlardar;
        if (r14 == null) goto L33;
        r5.writeInt(1);
        r5.writeInt(r14.intValue());
    L34:
        r5.writeInt(this.renderThreadStrategy);
        r5.writeInt(this.enableEngineParentControl ? 1 : 0);
        Boolean r15 = this.needLeaveRefresh;
        if (r15 == null) goto L37;
        r5.writeInt(1);
        r5.writeInt(r15.booleanValue() ? 1 : 0);
    L38:
        Long r16 = this.leaveTimeout;
        if (r16 == null) goto L41;
        r5.writeInt(1);
        r5.writeLong(r16.longValue());
    L42:
        Boolean r17 = this.needReportLastAction;
        if (r17 == null) goto L45;
        r5.writeInt(1);
        r5.writeInt(r17.booleanValue() ? 1 : 0);
    L46:
        Integer r18 = this.lastActionLen;
        if (r18 == null) goto L49;
        r5.writeInt(1);
        r5.writeInt(r18.intValue());
    L50:
        r5.writeString(this.sceneID);
        r5.writeInt(this.needRefreshPage ? 1 : 0);
        r5.writeInt(this.mallScrollTimeInterval);
        r5.writeInt(this.mallStraightOutSync);
        r5.writeInt(this.mallUpdateSuggestWorldByLynxCard ? 1 : 0);
        Integer r19 = this.bottomTabHeight;
        if (r19 == null) goto L53;
        r5.writeInt(1);
        r5.writeInt(r19.intValue());
    L54:
        r5.writeInt(this.mallFPSMonitorAfterFirstScreen ? 1 : 0);
        r5.writeInt(this.enableMallFpsOpt ? 1 : 0);
        Map<String, String> r20 = this.grassParams;
        if (r20 == null) goto L60;
        r5.writeInt(1);
        r5.writeInt(r20.size());
        Iterator<Map.Entry<String, String>> r21 = r20.entrySet().iterator();
    L58:
        if (r21.hasNext() == false) goto L61;
        Map.Entry<String, String> r2 = r21.next();
        r5.writeString(r2.getKey());
        r5.writeString(r2.getValue());
    L61:
        r5.writeInt(this.pageCardDelayInit);
        r5.writeInt(this.naMallPreloadStrategy);
        r5.writeInt(this.exposureEventAsyncReport ? 1 : 0);
        Map<String, String> r22 = this.landingInfo;
        if (r22 == null) goto L67;
        r5.writeInt(1);
        r5.writeInt(r22.size());
        Iterator<Map.Entry<String, String>> r23 = r22.entrySet().iterator();
    L65:
        if (r23.hasNext() == false) goto L68;
        Map.Entry<String, String> r3 = r23.next();
        r5.writeString(r3.getKey());
        r5.writeString(r3.getValue());
    L68:
        r5.writeString(this.geckoChannel);
        r5.writeInt(this.enableTopBar ? 1 : 0);
        r5.writeInt(this.enableBackground ? 1 : 0);
        r5.writeInt(this.showHalfMallBar ? 1 : 0);
        r5.writeInt(this.enableLoadGeckoInThread ? 1 : 0);
        r5.writeString(this.optForRebuildId);
        Long r24 = this.rebuildTime;
        if (r24 == null) goto L71;
        r5.writeInt(1);
        r5.writeLong(r24.longValue());
        return;
    L71:
        r5.writeInt(0);
        return;
    L67:
        r5.writeInt(0);
        goto L68
    L60:
        r5.writeInt(0);
        goto L61
    L53:
        r5.writeInt(0);
        goto L54
    L49:
        r5.writeInt(0);
        goto L50
    L45:
        r5.writeInt(0);
        goto L46
    L41:
        r5.writeInt(0);
        goto L42
    L37:
        r5.writeInt(0);
        goto L38
    L33:
        r5.writeInt(0);
        goto L34
    L29:
        r5.writeInt(0);
        goto L30
    L25:
        r5.writeInt(0);
        goto L26
    L21:
        r5.writeInt(0);
        goto L22
    L17:
        r5.writeInt(0);
        goto L18
    L13:
        r5.writeInt(0);
        goto L14
    L9:
        r5.writeInt(0);
        goto L10
    L5:
        r5.writeInt(0);
        goto L6
    }

    public final Integer getBottomTabHeight() {
        return this.bottomTabHeight;
    }

    public final String getBundleConfigUrl() {
        return this.bundleConfigUrl;
    }

    public final Boolean getBundlePreloaded() {
        return this.bundlePreloaded;
    }

    public final String getDataEngineTag() {
        return this.dataEngineTag;
    }

    public final boolean getDisableBuiltin() {
        return this.disableBuiltin;
    }

    public final boolean getEnableBackground() {
        return this.enableBackground;
    }

    public final boolean getEnableCorrectShowReport() {
        return this.enableCorrectShowReport;
    }

    public final boolean getEnableEngineParentControl() {
        return this.enableEngineParentControl;
    }

    public final boolean getEnableFirstScreenStraightOut() {
        return this.enableFirstScreenStraightOut;
    }

    public final boolean getEnableLoadGeckoInThread() {
        return this.enableLoadGeckoInThread;
    }

    public final boolean getEnableMallFpsOpt() {
        return this.enableMallFpsOpt;
    }

    public final boolean getEnableTopBar() {
        return this.enableTopBar;
    }

    public final boolean getExposureEventAsyncReport() {
        return this.exposureEventAsyncReport;
    }

    public final String getGeckoChannel() {
        return this.geckoChannel;
    }

    public final Boolean getGeckoExist() {
        return this.geckoExist;
    }

    public final Map<String, String> getGrassParams() {
        return this.grassParams;
    }

    public final Map<String, String> getLandingInfo() {
        return this.landingInfo;
    }

    public final Integer getLastActionLen() {
        return this.lastActionLen;
    }

    public final Long getLeaveTimeout() {
        return this.leaveTimeout;
    }

    public final Boolean getLiveSmoothEnter() {
        return this.liveSmoothEnter;
    }

    public final Integer getLoadMoreRangeSize() {
        return this.loadMoreRangeSize;
    }

    public final boolean getMallFPSMonitorAfterFirstScreen() {
        return this.mallFPSMonitorAfterFirstScreen;
    }

    public final int getMallScrollTimeInterval() {
        return this.mallScrollTimeInterval;
    }

    public final int getMallStraightOutSync() {
        return this.mallStraightOutSync;
    }

    public final boolean getMallUpdateSuggestWorldByLynxCard() {
        return this.mallUpdateSuggestWorldByLynxCard;
    }

    public final int getNaMallPreloadStrategy() {
        return this.naMallPreloadStrategy;
    }

    public final Long getNaOfflineVersion() {
        return this.naOfflineVersion;
    }

    public final Boolean getNeedLeaveRefresh() {
        return this.needLeaveRefresh;
    }

    public final boolean getNeedRefreshPage() {
        return this.needRefreshPage;
    }

    public final Boolean getNeedReportLastAction() {
        return this.needReportLastAction;
    }

    public final String getOptForRebuildId() {
        return this.optForRebuildId;
    }

    public final int getPageCardDelayInit() {
        return this.pageCardDelayInit;
    }

    public final long getPageCardDynamicParamTimeout() {
        return this.pageCardDynamicParamTimeout;
    }

    public final String getPageCardSchema() {
        return this.pageCardSchema;
    }

    public final int getPanelTopOffset() {
        return this.panelTopOffset;
    }

    public final String getPreloadTemplateConfig() {
        return this.preloadTemplateConfig;
    }

    public final Long getRebuildTime() {
        return this.rebuildTime;
    }

    public final Boolean getRefreshEnable() {
        return this.refreshEnable;
    }

    public final int getRenderThreadStrategy() {
        return this.renderThreadStrategy;
    }

    public final Integer getReportSlardar() {
        return this.reportSlardar;
    }

    public final String getSceneID() {
        return this.sceneID;
    }

    public final boolean getShouldCheckECPlugin() {
        return this.shouldCheckECPlugin;
    }

    public final boolean getShowHalfMallBar() {
        return this.showHalfMallBar;
    }

    public final int getTopBarPreloadStrategy() {
        return this.topBarPreloadStrategy;
    }

    public final Boolean getVideoSmoothEnter() {
        return this.videoSmoothEnter;
    }

    public final boolean isTopTabPage() {
        return this.isTopTabPage;
    }

    public final void setPreloadTemplateConfig(String r1) {
        this.preloadTemplateConfig = r1;
    }

    public IECNativeHomeArgument(String r6, Integer r7, Boolean r8, Boolean r9, Boolean r10, boolean r11, Long r12, Boolean r13, boolean r14, int r15, int r16, Boolean r17, boolean r18, boolean r19, boolean r20, String r21, long r22, String r24, String r25, Integer r26, int r27, boolean r28, Boolean r29, Long r30, Boolean r31, Integer r32, String r33, boolean r34, int r35, int r36, boolean r37, Integer r38, boolean r39, boolean r40, Map<String, String> r41, int r42, int r43, boolean r44, Map<String, String> r45, String r46, boolean r47, boolean r48, boolean r49, boolean r50, String r51, Long r52) {
        Intrinsics.checkNotNullParameter(r21, "dataEngineTag");
        Intrinsics.checkNotNullParameter(r33, "sceneID");
        this.bundleConfigUrl = r6;
        this.loadMoreRangeSize = r7;
        this.videoSmoothEnter = r8;
        this.liveSmoothEnter = r9;
        this.bundlePreloaded = r10;
        this.disableBuiltin = r11;
        this.naOfflineVersion = r12;
        this.geckoExist = r13;
        this.isTopTabPage = r14;
        this.panelTopOffset = r15;
        this.topBarPreloadStrategy = r16;
        this.refreshEnable = r17;
        this.shouldCheckECPlugin = r18;
        this.enableFirstScreenStraightOut = r19;
        this.enableCorrectShowReport = r20;
        this.dataEngineTag = r21;
        this.pageCardDynamicParamTimeout = r22;
        this.pageCardSchema = r24;
        this.preloadTemplateConfig = r25;
        this.reportSlardar = r26;
        this.renderThreadStrategy = r27;
        this.enableEngineParentControl = r28;
        this.needLeaveRefresh = r29;
        this.leaveTimeout = r30;
        this.needReportLastAction = r31;
        this.lastActionLen = r32;
        this.sceneID = r33;
        this.needRefreshPage = r34;
        this.mallScrollTimeInterval = r35;
        this.mallStraightOutSync = r36;
        this.mallUpdateSuggestWorldByLynxCard = r37;
        this.bottomTabHeight = r38;
        this.mallFPSMonitorAfterFirstScreen = r39;
        this.enableMallFpsOpt = r40;
        this.grassParams = r41;
        this.pageCardDelayInit = r42;
        this.naMallPreloadStrategy = r43;
        this.exposureEventAsyncReport = r44;
        this.landingInfo = r45;
        this.geckoChannel = r46;
        this.enableTopBar = r47;
        this.enableBackground = r48;
        this.showHalfMallBar = r49;
        this.enableLoadGeckoInThread = r50;
        this.optForRebuildId = r51;
        this.rebuildTime = r52;
    }

    public /* synthetic */ IECNativeHomeArgument(String r53, Integer r54, Boolean r55, Boolean r56, Boolean r57, boolean r58, Long r59, Boolean r60, boolean r61, int r62, int r63, Boolean r64, boolean r65, boolean r66, boolean r67, String r68, long r69, String r71, String r72, Integer r73, int r74, boolean r75, Boolean r76, Long r77, Boolean r78, Integer r79, String r80, boolean r81, int r82, int r84, boolean r85, Integer r86, boolean r87, boolean r88, Map r89, int r810, int r90, boolean r91, Map r92, String r94, boolean r95, boolean r96, boolean r97, boolean r98, String r99, Long r910, int r100, int r101, DefaultConstructorMarker r102) {
        if ((r100 & 1) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r100 & 2) == 0) goto L9;
        Integer r6 = null;
    L11:
        if ((r100 & 4) == 0) goto L13;
        Boolean r7 = null;
    L15:
        if ((r100 & 8) == 0) goto L17;
        Boolean r8 = null;
    L19:
        if ((r100 & 16) == 0) goto L21;
        Boolean r9 = null;
    L23:
        if ((r100 & 32) == 0) goto L25;
        boolean r10 = false;
    L27:
        if ((r100 & 64) == 0) goto L29;
        Long r11 = null;
    L31:
        if ((r100 & 128) == 0) goto L33;
        Boolean r12 = null;
    L35:
        if ((r100 & 512) == 0) goto L37;
        int r14 = 0;
    L39:
        if ((r100 & 1024) == 0) goto L41;
        int r15 = 0;
    L43:
        if ((r100 & 2048) == 0) goto L45;
        Boolean r16 = null;
    L47:
        if ((r100 & 4096) == 0) goto L49;
        boolean r17 = false;
    L51:
        if ((r100 & 8192) == 0) goto L53;
        boolean r18 = false;
    L55:
        if ((r100 & 16384) == 0) goto L57;
        boolean r19 = false;
    L59:
        if ((65536 & r100) == 0) goto L61;
        long r21 = 200;
    L63:
        if ((131072 & r100) == 0) goto L65;
        String r23 = null;
    L67:
        if ((262144 & r100) == 0) goto L69;
        String r24 = null;
    L71:
        if ((524288 & r100) == 0) goto L73;
        Integer r25 = null;
    L75:
        if ((1048576 & r100) == 0) goto L77;
        int r26 = 0;
    L79:
        if ((2097152 & r100) == 0) goto L81;
        boolean r27 = true;
    L83:
        if ((4194304 & r100) == 0) goto L85;
        Boolean r28 = Boolean.FALSE;
    L87:
        if ((8388608 & r100) == 0) goto L89;
        Long r29 = Long.MAX_VALUE;
    L91:
        if ((16777216 & r100) == 0) goto L93;
        Boolean r30 = Boolean.FALSE;
    L95:
        if ((33554432 & r100) == 0) goto L97;
        Integer r31 = 0;
    L99:
        if ((67108864 & r100) == 0) goto L101;
        String r32 = UUID.randomUUID().toString();
    L103:
        if ((134217728 & r100) == 0) goto L105;
        boolean r33 = false;
    L107:
        if ((268435456 & r100) == 0) goto L109;
        int r34 = 150;
    L111:
        if ((536870912 & r100) == 0) goto L113;
        int r35 = 0;
    L115:
        if ((1073741824 & r100) == 0) goto L117;
        boolean r36 = false;
    L119:
        if ((r100 & Integer.MIN_VALUE) == 0) goto L121;
        Integer r37 = 0;
    L123:
        if ((r101 & 1) == 0) goto L125;
        boolean r38 = false;
    L127:
        if ((r101 & 2) == 0) goto L129;
        boolean r39 = false;
    L131:
        if ((r101 & 4) == 0) goto L133;
        Map r40 = null;
    L135:
        if ((r101 & 8) == 0) goto L137;
        int r41 = 0;
    L139:
        if ((r101 & 16) == 0) goto L141;
        int r42 = 0;
    L143:
        if ((r101 & 32) == 0) goto L145;
        boolean r43 = false;
    L147:
        if ((r101 & 64) == 0) goto L149;
        Map r44 = null;
    L151:
        if ((r101 & 128) == 0) goto L153;
        String r45 = null;
    L155:
        if ((r101 & 256) == 0) goto L157;
        boolean r46 = true;
    L159:
        if ((r101 & 512) == 0) goto L161;
        boolean r47 = true;
    L163:
        if ((r101 & 1024) == 0) goto L165;
        boolean r48 = false;
    L167:
        if ((r101 & 2048) == 0) goto L169;
        boolean r49 = false;
    L171:
        if ((r101 & 4096) == 0) goto L173;
        String r50 = null;
    L175:
        if ((r101 & 8192) == 0) goto L177;
        Long r51 = null;
    L178:
        this(r5, r6, r7, r8, r9, r10, r11, r12, r61, r14, r15, r16, r17, r18, r19, r68, r21, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51);
        return;
    L177:
        r51 = r910;
        goto L178
    L173:
        r50 = r99;
        goto L175
    L169:
        r49 = r98;
        goto L171
    L165:
        r48 = r97;
        goto L167
    L161:
        r47 = r96;
        goto L163
    L157:
        r46 = r95;
        goto L159
    L153:
        r45 = r94;
        goto L155
    L149:
        r44 = r92;
        goto L151
    L145:
        r43 = r91;
        goto L147
    L141:
        r42 = r90;
        goto L143
    L137:
        r41 = r810;
        goto L139
    L133:
        r40 = r89;
        goto L135
    L129:
        r39 = r88;
        goto L131
    L125:
        r38 = r87;
        goto L127
    L121:
        r37 = r86;
        goto L123
    L117:
        r36 = r85;
        goto L119
    L113:
        r35 = r84;
        goto L115
    L109:
        r34 = r82;
        goto L111
    L105:
        r33 = r81;
        goto L107
    L101:
        r32 = r80;
        goto L103
    L97:
        r31 = r79;
        goto L99
    L93:
        r30 = r78;
        goto L95
    L89:
        r29 = r77;
        goto L91
    L85:
        r28 = r76;
        goto L87
    L81:
        r27 = r75;
        goto L83
    L77:
        r26 = r74;
        goto L79
    L73:
        r25 = r73;
        goto L75
    L69:
        r24 = r72;
        goto L71
    L65:
        r23 = r71;
        goto L67
    L61:
        r21 = r69;
        goto L63
    L57:
        r19 = r67;
        goto L59
    L53:
        r18 = r66;
        goto L55
    L49:
        r17 = r65;
        goto L51
    L45:
        r16 = r64;
        goto L47
    L41:
        r15 = r63;
        goto L43
    L37:
        r14 = r62;
        goto L39
    L33:
        r12 = r60;
        goto L35
    L29:
        r11 = r59;
        goto L31
    L25:
        r10 = r58;
        goto L27
    L21:
        r9 = r57;
        goto L23
    L17:
        r8 = r56;
        goto L19
    L13:
        r7 = r55;
        goto L15
    L9:
        r6 = r54;
        goto L11
    L5:
        r5 = r53;
        goto L7
    }
}
