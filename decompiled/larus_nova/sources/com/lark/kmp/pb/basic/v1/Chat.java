package com.lark.kmp.pb.basic.v1;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.t;
import com.lark.wire.w;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0084\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b$\u0018\u0000 ù\u00022\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:>ø\u0002ù\u0002ú\u0002û\u0002ü\u0002ý\u0002þ\u0002ÿ\u0002\u0080\u0003\u0081\u0003\u0082\u0003\u0083\u0003\u0084\u0003\u0085\u0003\u0086\u0003\u0087\u0003\u0088\u0003\u0089\u0003\u008a\u0003\u008b\u0003\u008c\u0003\u008d\u0003\u008e\u0003\u008f\u0003\u0090\u0003\u0091\u0003\u0092\u0003\u0093\u0003\u0094\u0003\u0095\u0003\u0096\u0003B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010ö\u0002\u001a\u00020\u0002H\u0016J\t\u0010÷\u0002\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0019\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0018\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0017R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0013\u0010\"\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u000bR\u0013\u0010$\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u000bR\u0015\u0010&\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010!\u001a\u0004\b'\u0010 R\u0013\u0010(\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u000bR\u001e\u0010*\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u001b\u001a\u0004\b-\u0010.R\u0013\u0010/\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u000bR\u0015\u00101\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b2\u0010\u0017R\u0015\u00103\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b4\u0010\u0017R\u0015\u00105\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\b5\u00107R \u00109\u001a\u0004\u0018\u0001068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00108\u0012\u0004\b:\u0010\u001b\u001a\u0004\b9\u00107R\u0015\u0010;\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\b;\u00107R\u0015\u0010<\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\b<\u00107R\u0015\u0010=\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\b=\u00107R\u0013\u0010>\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u000bR\u0013\u0010@\u001a\u0004\u0018\u00010A¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0015\u0010D\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\bD\u00107R\u0013\u0010E\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u000bR\u0013\u0010G\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u000bR \u0010I\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0018\u0012\u0004\bJ\u0010\u001b\u001a\u0004\bK\u0010\u0017R\u0015\u0010L\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\bL\u00107R\u0013\u0010M\u001a\u0004\u0018\u00010N¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0015\u0010Q\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\bR\u00107R\u0013\u0010S\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\u000bR\u0015\u0010U\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\bU\u00107R\u0015\u0010V\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\bV\u00107R\u0013\u0010W\u001a\u0004\u0018\u00010X¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0013\u0010[\u001a\u0004\u0018\u00010\\¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u0013\u0010_\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b`\u0010\u000bR\u0015\u0010a\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\bb\u0010\u0017R\u0015\u0010c\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\bc\u00107R\u0015\u0010d\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\bd\u00107R\u0015\u0010e\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\be\u00107R\u0015\u0010f\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\bf\u00107R\u0015\u0010g\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\bh\u0010\u0017R\u0013\u0010i\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bj\u0010\u000bR\u0015\u0010k\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\bl\u0010\u0017R\u0015\u0010m\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\bn\u0010\u0017R\u0015\u0010o\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\bp\u0010\u0017R\u0015\u0010q\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\br\u0010\u0017R\u0015\u0010s\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\bs\u00107R\u0015\u0010t\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\bu\u00107R\u0013\u0010v\u001a\u0004\u0018\u00010w¢\u0006\b\n\u0000\u001a\u0004\bx\u0010yR\u0013\u0010z\u001a\u0004\u0018\u00010{¢\u0006\b\n\u0000\u001a\u0004\b|\u0010}R\u0013\u0010~\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010\u000bR\u0017\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u000b\n\u0002\u0010\u0018\u001a\u0005\b\u0081\u0001\u0010\u0017R#\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u0012\n\u0002\u0010\u0018\u0012\u0005\b\u0083\u0001\u0010\u001b\u001a\u0005\b\u0084\u0001\u0010\u0017R#\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u0012\n\u0002\u0010\u0018\u0012\u0005\b\u0086\u0001\u0010\u001b\u001a\u0005\b\u0087\u0001\u0010\u0017R\u0017\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u000b\n\u0002\u0010\u0018\u001a\u0005\b\u0089\u0001\u0010\u0017R\u0017\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u000b\n\u0002\u0010\u0018\u001a\u0005\b\u008b\u0001\u0010\u0017R\u0017\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u000b\n\u0002\u0010\u0018\u001a\u0005\b\u008d\u0001\u0010\u0017R\u0017\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u000b\n\u0002\u0010\u0018\u001a\u0005\b\u008f\u0001\u0010\u0017R\u0015\u0010\u0090\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b\u0091\u0001\u0010\u000bR\u0017\u0010\u0092\u0001\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b\u0093\u0001\u00107R\u0015\u0010\u0094\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b\u0095\u0001\u0010\u000bR\u0017\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u000b\n\u0002\u0010\u0018\u001a\u0005\b\u0097\u0001\u0010\u0017R\u001a\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u0001¢\u0006\r\n\u0003\u0010\u009c\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0017\u0010\u009d\u0001\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b\u009d\u0001\u00107R\u0017\u0010\u009e\u0001\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b\u009e\u0001\u00107R\u0017\u0010\u009f\u0001\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b\u009f\u0001\u00107R\u0017\u0010 \u0001\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b \u0001\u00107R\u0017\u0010¡\u0001\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b¡\u0001\u00107R\u0017\u0010¢\u0001\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b¢\u0001\u00107R\u0017\u0010£\u0001\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b£\u0001\u00107R\u0017\u0010¤\u0001\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b¤\u0001\u00107R\u0017\u0010¥\u0001\u001a\u0005\u0018\u00010¦\u0001¢\u0006\n\n\u0000\u001a\u0006\b§\u0001\u0010¨\u0001R\u0017\u0010©\u0001\u001a\u0005\u0018\u00010ª\u0001¢\u0006\n\n\u0000\u001a\u0006\b«\u0001\u0010¬\u0001R\u0017\u0010\u00ad\u0001\u001a\u0005\u0018\u00010®\u0001¢\u0006\n\n\u0000\u001a\u0006\b¯\u0001\u0010°\u0001R\u0017\u0010±\u0001\u001a\u0005\u0018\u00010®\u0001¢\u0006\n\n\u0000\u001a\u0006\b²\u0001\u0010°\u0001R\u0017\u0010³\u0001\u001a\u0005\u0018\u00010´\u0001¢\u0006\n\n\u0000\u001a\u0006\bµ\u0001\u0010¶\u0001R\u0017\u0010·\u0001\u001a\u0005\u0018\u00010¸\u0001¢\u0006\n\n\u0000\u001a\u0006\b¹\u0001\u0010º\u0001R\u0017\u0010»\u0001\u001a\u0005\u0018\u00010¼\u0001¢\u0006\n\n\u0000\u001a\u0006\b½\u0001\u0010¾\u0001R\u0017\u0010¿\u0001\u001a\u0005\u0018\u00010À\u0001¢\u0006\n\n\u0000\u001a\u0006\bÁ\u0001\u0010Â\u0001R\u0017\u0010Ã\u0001\u001a\u0005\u0018\u00010Ä\u0001¢\u0006\n\n\u0000\u001a\u0006\bÅ\u0001\u0010Æ\u0001R\u0017\u0010Ç\u0001\u001a\u0005\u0018\u00010È\u0001¢\u0006\n\n\u0000\u001a\u0006\bÉ\u0001\u0010Ê\u0001R\u0017\u0010Ë\u0001\u001a\u0005\u0018\u00010Ì\u0001¢\u0006\n\n\u0000\u001a\u0006\bÍ\u0001\u0010Î\u0001R\u0017\u0010Ï\u0001\u001a\u0005\u0018\u00010Ð\u0001¢\u0006\n\n\u0000\u001a\u0006\bÑ\u0001\u0010Ò\u0001R\u0017\u0010Ó\u0001\u001a\u0005\u0018\u00010Ô\u0001¢\u0006\n\n\u0000\u001a\u0006\bÕ\u0001\u0010Ö\u0001R\u0017\u0010×\u0001\u001a\u0005\u0018\u00010Ø\u0001¢\u0006\n\n\u0000\u001a\u0006\bÙ\u0001\u0010Ú\u0001R\u0017\u0010Û\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u000b\n\u0002\u0010\u0018\u001a\u0005\bÜ\u0001\u0010\u0017R\u0017\u0010Ý\u0001\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\bÞ\u0001\u00107R\u0015\u0010ß\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bà\u0001\u0010\u000bR\u0015\u0010á\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bâ\u0001\u0010\u000bR\u001c\u0010ã\u0001\u001a\n\u0012\u0005\u0012\u00030å\u00010ä\u0001¢\u0006\n\n\u0000\u001a\u0006\bæ\u0001\u0010ç\u0001R\u0017\u0010è\u0001\u001a\u0004\u0018\u00010\u001e¢\u0006\u000b\n\u0002\u0010!\u001a\u0005\bé\u0001\u0010 R\u0017\u0010ê\u0001\u001a\u0004\u0018\u00010\u001e¢\u0006\u000b\n\u0002\u0010!\u001a\u0005\bë\u0001\u0010 R\u0017\u0010ì\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u000b\n\u0002\u0010\u0018\u001a\u0005\bí\u0001\u0010\u0017R\u0015\u0010î\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bï\u0001\u0010\u000bR\u0017\u0010ð\u0001\u001a\u0005\u0018\u00010ñ\u0001¢\u0006\n\n\u0000\u001a\u0006\bò\u0001\u0010ó\u0001R\u0017\u0010ô\u0001\u001a\u0004\u0018\u00010\u001e¢\u0006\u000b\n\u0002\u0010!\u001a\u0005\bõ\u0001\u0010 R\u0017\u0010ö\u0001\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\bö\u0001\u00107R\u0015\u0010÷\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bø\u0001\u0010\u000bR\u0017\u0010ù\u0001\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\bù\u0001\u00107R\u0017\u0010ú\u0001\u001a\u0004\u0018\u00010\u001e¢\u0006\u000b\n\u0002\u0010!\u001a\u0005\bû\u0001\u0010 R\u0015\u0010ü\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bý\u0001\u0010\u000bR\u0017\u0010þ\u0001\u001a\u0005\u0018\u00010ÿ\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0080\u0002\u0010\u0081\u0002R!\u0010\u0082\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0083\u0002¢\u0006\n\n\u0000\u001a\u0006\b\u0084\u0002\u0010\u0085\u0002R\u001c\u0010\u0086\u0002\u001a\n\u0012\u0005\u0012\u00030\u0087\u00020ä\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0088\u0002\u0010ç\u0001R\"\u0010\u0089\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0005\u0012\u00030\u008a\u00020\u0083\u0002¢\u0006\n\n\u0000\u001a\u0006\b\u008b\u0002\u0010\u0085\u0002R\u001c\u0010\u008c\u0002\u001a\n\u0012\u0005\u0012\u00030\u0087\u00020ä\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u008d\u0002\u0010ç\u0001R\u0017\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u008f\u0002¢\u0006\n\n\u0000\u001a\u0006\b\u0090\u0002\u0010\u0091\u0002R\u0017\u0010\u0092\u0002\u001a\u0004\u0018\u00010\u001e¢\u0006\u000b\n\u0002\u0010!\u001a\u0005\b\u0093\u0002\u0010 R\u0017\u0010\u0094\u0002\u001a\u0004\u0018\u00010\u001e¢\u0006\u000b\n\u0002\u0010!\u001a\u0005\b\u0095\u0002\u0010 R\u0017\u0010\u0096\u0002\u001a\u0005\u0018\u00010\u0097\u0002¢\u0006\n\n\u0000\u001a\u0006\b\u0098\u0002\u0010\u0099\u0002R\u0017\u0010\u009a\u0002\u001a\u0004\u0018\u00010\u0015¢\u0006\u000b\n\u0002\u0010\u0018\u001a\u0005\b\u009b\u0002\u0010\u0017R\u0015\u0010\u009c\u0002\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b\u009d\u0002\u0010\u000bR\u0017\u0010\u009e\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b\u009f\u0002\u00107R\u0017\u0010 \u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b¡\u0002\u00107R\u0017\u0010¢\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b¢\u0002\u00107R\u0017\u0010£\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b£\u0002\u00107R\u0017\u0010¤\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b¤\u0002\u00107R\u0017\u0010¥\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b¥\u0002\u00107R\u0015\u0010¦\u0002\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b§\u0002\u0010\u000bR\u0017\u0010¨\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b¨\u0002\u00107R\u0017\u0010©\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b©\u0002\u00107R\u0017\u0010ª\u0002\u001a\u0005\u0018\u00010«\u0002¢\u0006\n\n\u0000\u001a\u0006\b¬\u0002\u0010\u00ad\u0002R\u001c\u0010®\u0002\u001a\n\u0012\u0005\u0012\u00030¯\u00020ä\u0001¢\u0006\n\n\u0000\u001a\u0006\b°\u0002\u0010ç\u0001R\u0017\u0010±\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b±\u0002\u00107R\u0017\u0010²\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b³\u0002\u00107R\u0015\u0010´\u0002\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bµ\u0002\u0010\u000bR\u001b\u0010¶\u0002\u001a\t\u0012\u0004\u0012\u00020\t0ä\u0001¢\u0006\n\n\u0000\u001a\u0006\b·\u0002\u0010ç\u0001R\u0017\u0010¸\u0002\u001a\u0004\u0018\u00010\u0015¢\u0006\u000b\n\u0002\u0010\u0018\u001a\u0005\b¹\u0002\u0010\u0017R\u0017\u0010º\u0002\u001a\u0005\u0018\u00010»\u0002¢\u0006\n\n\u0000\u001a\u0006\b¼\u0002\u0010½\u0002R\u0017\u0010¾\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b¾\u0002\u00107R\u0017\u0010¿\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\bÀ\u0002\u00107R\u0017\u0010Á\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\bÁ\u0002\u00107R\u0017\u0010Â\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\bÂ\u0002\u00107R\u0017\u0010Ã\u0002\u001a\u0005\u0018\u00010Ä\u0002¢\u0006\n\n\u0000\u001a\u0006\bÅ\u0002\u0010Æ\u0002R\u0017\u0010Ç\u0002\u001a\u0005\u0018\u00010È\u0002¢\u0006\n\n\u0000\u001a\u0006\bÉ\u0002\u0010Ê\u0002R\u0015\u0010Ë\u0002\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bÌ\u0002\u0010\u000bR\u0017\u0010Í\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\bÎ\u0002\u00107R\u0017\u0010Ï\u0002\u001a\u0005\u0018\u00010Ð\u0002¢\u0006\n\n\u0000\u001a\u0006\bÑ\u0002\u0010Ò\u0002R\u0017\u0010Ó\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\bÔ\u0002\u00107R\u0017\u0010Õ\u0002\u001a\u0005\u0018\u00010Ö\u0002¢\u0006\n\n\u0000\u001a\u0006\b×\u0002\u0010Ø\u0002R\u0017\u0010Ù\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\bÙ\u0002\u00107R\u0017\u0010Ú\u0002\u001a\u0005\u0018\u00010Û\u0002¢\u0006\n\n\u0000\u001a\u0006\bÜ\u0002\u0010Ý\u0002R\u001c\u0010Þ\u0002\u001a\n\u0012\u0005\u0012\u00030ß\u00020ä\u0001¢\u0006\n\n\u0000\u001a\u0006\bà\u0002\u0010ç\u0001R\u0017\u0010á\u0002\u001a\u0004\u0018\u00010\u001e¢\u0006\u000b\n\u0002\u0010!\u001a\u0005\bâ\u0002\u0010 R\u0017\u0010ã\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\bã\u0002\u00107R\u0017\u0010ä\u0002\u001a\u0005\u0018\u00010å\u0002¢\u0006\n\n\u0000\u001a\u0006\bæ\u0002\u0010ç\u0002R\u0017\u0010è\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\bé\u0002\u00107R\u0017\u0010ê\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\bë\u0002\u00107R\u0015\u0010ì\u0002\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bí\u0002\u0010\u000bR\u0015\u0010î\u0002\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bï\u0002\u0010\u000bR\u0015\u0010ð\u0002\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bñ\u0002\u0010\u000bR\u0017\u0010ò\u0002\u001a\u0005\u0018\u00010ó\u0002¢\u0006\n\n\u0000\u001a\u0006\bô\u0002\u0010õ\u0002¨\u0006\u0097\u0003"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "type", "Lcom/lark/kmp/pb/basic/v1/Chat$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/Chat$Type;", "name", "getName", "last_message_id", "getLast_message_id", "last_message_position", "", "getLast_message_position", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "new_message_count", "getNew_message_count$annotations", "()V", "getNew_message_count", "update_time", "", "getUpdate_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "avatar_key", "getAvatar_key", "chatter_id", "getChatter_id", "create_time", "getCreate_time", "description", "getDescription", "avatar", "Lcom/lark/kmp/pb/basic/v1/Image;", "getAvatar$annotations", "getAvatar", "()Lcom/lark/kmp/pb/basic/v1/Image;", "owner_id", "getOwner_id", "chatter_count", "getChatter_count", "user_count", "getUser_count", "is_department", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_public", "is_public$annotations", "is_archived", "is_deleted", "is_remind", "name_pinyin", "getName_pinyin", "role", "Lcom/lark/kmp/pb/basic/v1/Chat$Role;", "getRole", "()Lcom/lark/kmp/pb/basic/v1/Chat$Role;", "is_customer_service", "text_draft_id", "getText_draft_id", "post_draft_id", "getPost_draft_id", "no_badged_new_message_count", "getNo_badged_new_message_count$annotations", "getNo_badged_new_message_count", "is_shortcut", "announcement", "Lcom/lark/kmp/pb/basic/v1/Chat$Announcement;", "getAnnouncement", "()Lcom/lark/kmp/pb/basic/v1/Chat$Announcement;", "off_edit_group_chat_info", "getOff_edit_group_chat_info", "tenant_id", "getTenant_id", "is_custom_icon", "is_dissolved", "message_position", "Lcom/lark/kmp/pb/basic/v1/Chat$MessagePosition$Enum;", "getMessage_position", "()Lcom/lark/kmp/pb/basic/v1/Chat$MessagePosition$Enum;", "feed_type", "Lcom/lark/kmp/pb/basic/v1/FeedCard$FeedType;", "getFeed_type", "()Lcom/lark/kmp/pb/basic/v1/FeedCard$FeedType;", "last_visible_message_id", "getLast_visible_message_id", "burn_life", "getBurn_life", "is_crypto", "is_meeting", "is_cross_tenant", "is_support_view", "first_message_position", "getFirst_message_position", "oncall_id", "getOncall_id", "last_visible_message_position", "getLast_visible_message_position", "read_position", "getRead_position", "read_position_badge_count", "getRead_position_badge_count", "last_message_position_badge_count", "getLast_message_position_badge_count", "is_public_v2", "allow_post", "getAllow_post", "post_type", "Lcom/lark/kmp/pb/basic/v1/Chat$PostType;", "getPost_type", "()Lcom/lark/kmp/pb/basic/v1/Chat$PostType;", "chat_mode", "Lcom/lark/kmp/pb/basic/v1/Chat$ChatMode;", "getChat_mode", "()Lcom/lark/kmp/pb/basic/v1/Chat$ChatMode;", "last_thread_id", "getLast_thread_id", "last_thread_position", "getLast_thread_position", "new_thread_count", "getNew_thread_count$annotations", "getNew_thread_count", "no_badged_new_thread_count", "getNo_badged_new_thread_count$annotations", "getNo_badged_new_thread_count", "last_thread_position_badge_count", "getLast_thread_position_badge_count", "read_thread_position", "getRead_thread_position", "read_thread_position_badge_count", "getRead_thread_position_badge_count", "last_visible_thread_position", "getLast_visible_thread_position", "last_visible_thread_id", "getLast_visible_thread_id", "show_nickname", "getShow_nickname", "last_draft_id", "getLast_draft_id", "last_read_position", "getLast_read_position", "last_read_offset", "", "getLast_read_offset", "()Ljava/lang/Float;", "Ljava/lang/Float;", "is_edu", "is_admin", "is_mute_at_all", "is_delayed", "is_p2p_ai", "is_ocic_customer_service", "is_p2p_official_bot_ai", "is_temp_top_feed", "add_member_permission", "Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberPermission$Enum;", "getAdd_member_permission", "()Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberPermission$Enum;", "at_all_permission", "Lcom/lark/kmp/pb/basic/v1/Chat$AtAllPermission$Enum;", "getAt_all_permission", "()Lcom/lark/kmp/pb/basic/v1/Chat$AtAllPermission$Enum;", "join_message_visible", "Lcom/lark/kmp/pb/basic/v1/Chat$SystemMessageVisible$Enum;", "getJoin_message_visible", "()Lcom/lark/kmp/pb/basic/v1/Chat$SystemMessageVisible$Enum;", "quit_message_visible", "getQuit_message_visible", "share_card_permission", "Lcom/lark/kmp/pb/basic/v1/Chat$ShareCardPermission$Enum;", "getShare_card_permission", "()Lcom/lark/kmp/pb/basic/v1/Chat$ShareCardPermission$Enum;", "add_member_apply", "Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberApply$Enum;", "getAdd_member_apply", "()Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberApply$Enum;", "message_visibility_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$MessageVisibilitySetting$Enum;", "getMessage_visibility_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$MessageVisibilitySetting$Enum;", "create_urgent_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$CreateUrgentSetting$Enum;", "getCreate_urgent_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$CreateUrgentSetting$Enum;", "create_video_conference_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$CreateVideoConferenceSetting$Enum;", "getCreate_video_conference_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$CreateVideoConferenceSetting$Enum;", "pin_permission_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$PinPermissionSetting$Enum;", "getPin_permission_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$PinPermissionSetting$Enum;", "top_notice_permission_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$TopNoticePermissionSetting$Enum;", "getTop_notice_permission_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$TopNoticePermissionSetting$Enum;", "chat_tab_permission_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$ChatTabPermissionSetting$Enum;", "getChat_tab_permission_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$ChatTabPermissionSetting$Enum;", "chat_display_mode_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$ChatDisplayModeSetting$Enum;", "getChat_display_mode_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$ChatDisplayModeSetting$Enum;", "chat_pin_permission_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$ChatPinPermissionSetting$Enum;", "getChat_pin_permission_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$ChatPinPermissionSetting$Enum;", "put_chatter_apply_count", "getPut_chatter_apply_count", "show_banner", "getShow_banner", "mini_avatar_key", "getMini_avatar_key", "sidebar_id", "getSidebar_id", "sidebar_buttons", "", "Lcom/lark/kmp/pb/basic/v1/SideBarButton;", "getSidebar_buttons", "()Ljava/util/List;", "my_threads_read_timestamp", "getMy_threads_read_timestamp", "my_threads_last_timestamp", "getMy_threads_last_timestamp", "my_threads_unread_count", "getMy_threads_unread_count", "my_threads_last_display_message_id", "getMy_threads_last_display_message_id", "anonymous_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$AnonymousSetting$Enum;", "getAnonymous_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$AnonymousSetting$Enum;", "anonymous_total_quota", "getAnonymous_total_quota", "is_cross_with_ka", "anonymous_id", "getAnonymous_id", "is_team", "team_id", "getTeam_id", "team_name", "getTeam_name", "team_chat_type", "Lcom/lark/kmp/pb/basic/v1/TeamChatType;", "getTeam_chat_type", "()Lcom/lark/kmp/pb/basic/v1/TeamChatType;", "chatter_extra_states", "", "getChatter_extra_states", "()Ljava/util/Map;", "joined_team_infos", "Lcom/lark/kmp/pb/basic/v1/ChatTeamInfo;", "getJoined_team_infos", "joined_teams", "Lcom/lark/kmp/pb/basic/v1/Team;", "getJoined_teams", "bound_team_infos", "getBound_team_infos", "user_auto_mute", "Lcom/lark/kmp/pb/basic/v1/ChatUserAutoMuteSetting;", "getUser_auto_mute", "()Lcom/lark/kmp/pb/basic/v1/ChatUserAutoMuteSetting;", "ai_knowledge_query_id", "getAi_knowledge_query_id", "query_create_time", "getQuery_create_time", "query_status", "Lcom/lark/kmp/pb/basic/v1/CommonAIReply$Status;", "getQuery_status", "()Lcom/lark/kmp/pb/basic/v1/CommonAIReply$Status;", "query_seq_id", "getQuery_seq_id", "edit_message_draft_id", "getEdit_message_draft_id", "chatable", "getChatable", "muteable", "getMuteable", "is_super", "is_private_mode", "is_tenant", "is_in_box", "box_id", "getBox_id", "is_auto_translate", "is_auto_typing_translate", "typing_translate_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$TypingTranslateSetting;", "getTyping_translate_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$TypingTranslateSetting;", "feed_tag", "Lcom/lark/kmp/pb/basic/v1/FeedTag;", "getFeed_tag", "is_flag", "has_water_mark", "getHas_water_mark", "avatar_path", "getAvatar_path", "avatar_urls", "getAvatar_urls", "first_chat_message_position", "getFirst_chat_message_position", "tag_info", "Lcom/lark/kmp/pb/basic/v1/TagData;", "getTag_info", "()Lcom/lark/kmp/pb/basic/v1/TagData;", "is_fake", "typing_translate_has_auto_opened", "getTyping_translate_has_auto_opened", "is_official_oncall", "is_offline_oncall", "restricted_mode_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting;", "getRestricted_mode_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting;", "def_display_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$DefDisplaySetting$Enum;", "getDef_display_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$DefDisplaySetting$Enum;", "schedule_message_draft_id", "getSchedule_message_draft_id", "has_vc_chat_permission", "getHas_vc_chat_permission", "admin_post_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$AdminPostSetting$Enum;", "getAdmin_post_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$AdminPostSetting$Enum;", "can_be_sorted_alphabetically", "getCan_be_sorted_alphabetically", "user_count_visible_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$UserCountVisibleSetting$Enum;", "getUser_count_visible_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$UserCountVisibleSetting$Enum;", "is_user_count_visible", "doubao_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$DoubaoSetting;", "getDoubao_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$DoubaoSetting;", PromotionProductPrivilegesStruct.TAGS, "Lcom/lark/kmp/pb/basic/v1/Tag;", "getTags", "theme_id", "getTheme_id", "is_frozen", "banner_setting", "Lcom/lark/kmp/pb/basic/v1/BannerSetting;", "getBanner_setting", "()Lcom/lark/kmp/pb/basic/v1/BannerSetting;", "can_translate_name", "getCan_translate_name", "should_display_translated_name", "getShould_display_translated_name", "translated_name", "getTranslated_name", "name_major_language", "getName_major_language", "name_translate_language", "getName_translate_language", "tns_info", "Lcom/lark/kmp/pb/basic/v1/Chat$TnsInfo;", "getTns_info", "()Lcom/lark/kmp/pb/basic/v1/Chat$TnsInfo;", "newBuilder", "toString", "Builder", "Companion", "Type", "Role", "Announcement", "MessagePosition", "PostType", "ChatMode", "AddMemberPermission", "AtAllPermission", "AddMemberApply", "SystemMessageVisible", "ShareCardPermission", "AnonymousSetting", "MessageVisibilitySetting", "CreateUrgentSetting", "CreateVideoConferenceSetting", "PinPermissionSetting", "TopNoticePermissionSetting", "ChatTabPermissionSetting", "ChatDisplayModeSetting", "TypingTranslateSetting", "WidgetState", "WhiteListSetting", "RestrictedModeSetting", "DefDisplaySetting", "AdminPostSetting", "ChatPinPermissionSetting", "UserCountVisibleSetting", "DoubaoSetting", "TnsInfo", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Chat extends com.lark.wire.Message<Chat, a> {
    public static final ProtoAdapter<Chat> ADAPTER = null;
    public static final b Companion = null;
    public static final AddMemberApply.Enum DEFAULT_ADD_MEMBER_APPLY = null;
    public static final AddMemberPermission.Enum DEFAULT_ADD_MEMBER_PERMISSION = null;
    public static final AdminPostSetting.Enum DEFAULT_ADMIN_POST_SETTING = null;
    public static final boolean DEFAULT_ALLOW_POST = true;
    public static final AnonymousSetting.Enum DEFAULT_ANONYMOUS_SETTING = null;
    public static final AtAllPermission.Enum DEFAULT_AT_ALL_PERMISSION = null;
    public static final String DEFAULT_BOX_ID = "";
    public static final int DEFAULT_BURN_LIFE = 0;
    public static final boolean DEFAULT_CHATABLE = true;
    public static final int DEFAULT_CHATTER_COUNT = 0;
    public static final String DEFAULT_CHATTER_ID = "";
    public static final ChatMode DEFAULT_CHAT_MODE = null;
    public static final ChatTabPermissionSetting.Enum DEFAULT_CHAT_TAB_PERMISSION_SETTING = null;
    public static final CreateUrgentSetting.Enum DEFAULT_CREATE_URGENT_SETTING = null;
    public static final CreateVideoConferenceSetting.Enum DEFAULT_CREATE_VIDEO_CONFERENCE_SETTING = null;
    public static final DefDisplaySetting.Enum DEFAULT_DEF_DISPLAY_SETTING = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_EDIT_MESSAGE_DRAFT_ID = "";
    public static final FeedCard.FeedType DEFAULT_FEED_TYPE = null;
    public static final int DEFAULT_FIRST_CHAT_MESSAGE_POSITION = -1;
    public static final int DEFAULT_FIRST_MESSAGE_POSITION = -1;
    public static final boolean DEFAULT_HAS_WATER_MARK = false;
    public static final boolean DEFAULT_IS_ADMIN = false;
    public static final boolean DEFAULT_IS_ARCHIVED = false;
    public static final boolean DEFAULT_IS_AUTO_TRANSLATE = false;
    public static final boolean DEFAULT_IS_AUTO_TYPING_TRANSLATE = true;
    public static final boolean DEFAULT_IS_CROSS_TENANT = false;
    public static final boolean DEFAULT_IS_CRYPTO = false;
    public static final boolean DEFAULT_IS_CUSTOMER_SERVICE = false;
    public static final boolean DEFAULT_IS_CUSTOM_ICON = false;
    public static final boolean DEFAULT_IS_DELETED = false;
    public static final boolean DEFAULT_IS_DEPARTMENT = false;
    public static final boolean DEFAULT_IS_DISSOLVED = false;
    public static final boolean DEFAULT_IS_EDU = false;
    public static final boolean DEFAULT_IS_FLAG = false;
    public static final boolean DEFAULT_IS_IN_BOX = false;
    public static final boolean DEFAULT_IS_MEETING = false;
    public static final boolean DEFAULT_IS_OCIC_CUSTOMER_SERVICE = false;
    public static final boolean DEFAULT_IS_OFFICIAL_ONCALL = false;
    public static final boolean DEFAULT_IS_OFFLINE_ONCALL = false;
    public static final boolean DEFAULT_IS_REMIND = true;
    public static final boolean DEFAULT_IS_SHORTCUT = false;
    public static final boolean DEFAULT_IS_TENANT = false;
    public static final boolean DEFAULT_IS_USER_COUNT_VISIBLE = true;
    public static final SystemMessageVisible.Enum DEFAULT_JOIN_MESSAGE_VISIBLE = null;
    public static final String DEFAULT_LAST_MESSAGE_ID = "";
    public static final int DEFAULT_LAST_MESSAGE_POSITION = 0;
    public static final int DEFAULT_LAST_READ_POSITION = -1;
    public static final MessagePosition.Enum DEFAULT_MESSAGE_POSITION = null;
    public static final MessageVisibilitySetting.Enum DEFAULT_MESSAGE_VISIBILITY_SETTING = null;
    public static final boolean DEFAULT_MUTEABLE = true;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_NAME_PINYIN = "";
    public static final boolean DEFAULT_OFF_EDIT_GROUP_CHAT_INFO = false;
    public static final String DEFAULT_OWNER_ID = "";
    public static final PinPermissionSetting.Enum DEFAULT_PIN_PERMISSION_SETTING = null;
    public static final String DEFAULT_POST_DRAFT_ID = "";
    public static final SystemMessageVisible.Enum DEFAULT_QUIT_MESSAGE_VISIBLE = null;
    public static final Role DEFAULT_ROLE = null;
    public static final ShareCardPermission.Enum DEFAULT_SHARE_CARD_PERMISSION = null;
    public static final String DEFAULT_TENANT_ID = "";
    public static final String DEFAULT_TEXT_DRAFT_ID = "";
    public static final TopNoticePermissionSetting.Enum DEFAULT_TOP_NOTICE_PERMISSION_SETTING = null;
    public static final Type DEFAULT_TYPE = null;
    public static final long DEFAULT_UPDATE_TIME = 0;
    public static final int DEFAULT_USER_COUNT = 0;
    private static final long serialVersionUID = 0;
    private final AddMemberApply.Enum add_member_apply;
    private final AddMemberPermission.Enum add_member_permission;
    private final AdminPostSetting.Enum admin_post_setting;
    private final Long ai_knowledge_query_id;
    private final Boolean allow_post;
    private final Announcement announcement;
    private final String anonymous_id;
    private final AnonymousSetting.Enum anonymous_setting;
    private final Long anonymous_total_quota;
    private final AtAllPermission.Enum at_all_permission;
    private final Image avatar;
    private final String avatar_key;
    private final String avatar_path;
    private final List<String> avatar_urls;
    private final BannerSetting banner_setting;
    private final List<ChatTeamInfo> bound_team_infos;
    private final String box_id;
    private final Integer burn_life;
    private final Boolean can_be_sorted_alphabetically;
    private final Boolean can_translate_name;
    private final ChatDisplayModeSetting.Enum chat_display_mode_setting;
    private final ChatMode chat_mode;
    private final ChatPinPermissionSetting.Enum chat_pin_permission_setting;
    private final ChatTabPermissionSetting.Enum chat_tab_permission_setting;
    private final Boolean chatable;
    private final Integer chatter_count;
    private final Map<Integer, Integer> chatter_extra_states;
    private final String chatter_id;
    private final Long create_time;
    private final CreateUrgentSetting.Enum create_urgent_setting;
    private final CreateVideoConferenceSetting.Enum create_video_conference_setting;
    private final DefDisplaySetting.Enum def_display_setting;
    private final String description;
    private final DoubaoSetting doubao_setting;
    private final String edit_message_draft_id;
    private final List<FeedTag> feed_tag;
    private final FeedCard.FeedType feed_type;
    private final Integer first_chat_message_position;
    private final Integer first_message_position;
    private final Boolean has_vc_chat_permission;
    private final Boolean has_water_mark;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f278992id;
    private final Boolean is_admin;
    private final Boolean is_archived;
    private final Boolean is_auto_translate;
    private final Boolean is_auto_typing_translate;
    private final Boolean is_cross_tenant;
    private final Boolean is_cross_with_ka;
    private final Boolean is_crypto;
    private final Boolean is_custom_icon;
    private final Boolean is_customer_service;
    private final Boolean is_delayed;
    private final Boolean is_deleted;
    private final Boolean is_department;
    private final Boolean is_dissolved;
    private final Boolean is_edu;
    private final Boolean is_fake;
    private final Boolean is_flag;
    private final Boolean is_frozen;
    private final Boolean is_in_box;
    private final Boolean is_meeting;
    private final Boolean is_mute_at_all;
    private final Boolean is_ocic_customer_service;
    private final Boolean is_official_oncall;
    private final Boolean is_offline_oncall;
    private final Boolean is_p2p_ai;
    private final Boolean is_p2p_official_bot_ai;
    private final Boolean is_private_mode;
    private final Boolean is_public;
    private final Boolean is_public_v2;
    private final Boolean is_remind;
    private final Boolean is_shortcut;
    private final Boolean is_super;
    private final Boolean is_support_view;
    private final Boolean is_team;
    private final Boolean is_temp_top_feed;
    private final Boolean is_tenant;
    private final Boolean is_user_count_visible;
    private final SystemMessageVisible.Enum join_message_visible;
    private final List<ChatTeamInfo> joined_team_infos;
    private final Map<Long, Team> joined_teams;
    private final String last_draft_id;
    private final String last_message_id;
    private final Integer last_message_position;
    private final Integer last_message_position_badge_count;
    private final Float last_read_offset;
    private final Integer last_read_position;
    private final String last_thread_id;
    private final Integer last_thread_position;
    private final Integer last_thread_position_badge_count;
    private final String last_visible_message_id;
    private final Integer last_visible_message_position;
    private final String last_visible_thread_id;
    private final Integer last_visible_thread_position;
    private final MessagePosition.Enum message_position;
    private final MessageVisibilitySetting.Enum message_visibility_setting;
    private final String mini_avatar_key;
    private final Boolean muteable;
    private final String my_threads_last_display_message_id;
    private final Long my_threads_last_timestamp;
    private final Long my_threads_read_timestamp;
    private final Integer my_threads_unread_count;
    private final String name;
    private final String name_major_language;
    private final String name_pinyin;
    private final String name_translate_language;
    private final Integer new_message_count;
    private final Integer new_thread_count;
    private final Integer no_badged_new_message_count;
    private final Integer no_badged_new_thread_count;
    private final Boolean off_edit_group_chat_info;
    private final String oncall_id;
    private final String owner_id;
    private final PinPermissionSetting.Enum pin_permission_setting;
    private final String post_draft_id;
    private final PostType post_type;
    private final Integer put_chatter_apply_count;
    private final Long query_create_time;
    private final Integer query_seq_id;
    private final CommonAIReply.Status query_status;
    private final SystemMessageVisible.Enum quit_message_visible;
    private final Integer read_position;
    private final Integer read_position_badge_count;
    private final Integer read_thread_position;
    private final Integer read_thread_position_badge_count;
    private final RestrictedModeSetting restricted_mode_setting;
    private final Role role;
    private final String schedule_message_draft_id;
    private final ShareCardPermission.Enum share_card_permission;
    private final Boolean should_display_translated_name;
    private final Boolean show_banner;
    private final Boolean show_nickname;
    private final List<SideBarButton> sidebar_buttons;
    private final String sidebar_id;
    private final TagData tag_info;
    private final List<Tag> tags;
    private final TeamChatType team_chat_type;
    private final Long team_id;
    private final String team_name;
    private final String tenant_id;
    private final String text_draft_id;
    private final Long theme_id;
    private final TnsInfo tns_info;
    private final TopNoticePermissionSetting.Enum top_notice_permission_setting;
    private final String translated_name;
    private final Type type;
    private final Boolean typing_translate_has_auto_opened;
    private final TypingTranslateSetting typing_translate_setting;
    private final Long update_time;
    private final ChatUserAutoMuteSetting user_auto_mute;
    private final Integer user_count;
    private final UserCountVisibleSetting.Enum user_count_visible_setting;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberApply;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberApply$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberApply$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AddMemberApply extends com.lark.wire.Message<AddMemberApply, a> {
        public static final ProtoAdapter<AddMemberApply> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberApply$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "NO_APPLY", "NEED_APPLY", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final b Companion = null;
            public static final Enum NEED_APPLY = null;
            public static final Enum NO_APPLY = null;
            public static final Enum UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Enum[] f278993a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f278994b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r100) {
                    Enum.Companion.getClass();
                    if (r100 == 0) goto L12;
                    if (r100 == 1) goto L15;
                    if (r100 == 2) goto L14;
                    return null;
                L14:
                    return Enum.NEED_APPLY;
                L15:
                    return Enum.NO_APPLY;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r100, Syntax r101, Enum r102) {
                    super(r100, r101, r102);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return f278994b;
            }

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("NO_APPLY", 1, 1);
                NO_APPLY = r101;
                Enum r102 = new Enum("NEED_APPLY", 2, 2);
                NEED_APPLY = r102;
                Enum[] r103 = {r100, r101, r102};
                f278993a = r103;
                f278994b = EnumEntriesKt.enumEntries(r103);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r100);
            }

            public static Enum[] values() {
                return (Enum[]) f278993a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r100) {
                Companion.getClass();
                if (r100 == 0) goto L12;
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L14;
                return null;
            L14:
                return NEED_APPLY;
            L15:
                return NO_APPLY;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) r27.a.a(Enum.class, r100);
            }

            public Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class a extends com.lark.wire.Message.a<AddMemberApply, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new AddMemberApply(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<AddMemberApply> {
            @Override // com.lark.wire.ProtoAdapter
            public final AddMemberApply c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                long r102 = r100.c();
            L3:
                int r103 = r100.e();
                if (r103 == (-1)) goto L7;
                r100.j(r103);
                goto L3
            L7:
                return new AddMemberApply(r101, r100.d(r102), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(AddMemberApply r100) {
                AddMemberApply r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                return r101.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, AddMemberApply r101) {
                AddMemberApply r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, AddMemberApply r101) {
                AddMemberApply r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
            }

            public b(FieldEncoding r100, KClass<AddMemberApply> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chat.AddMemberApply", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ AddMemberApply(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AddMemberApply.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.a(unknownFields());
            return r100;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(AddMemberApply.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public AddMemberApply(ByteString r100) {
            super(ADAPTER, r100);
        }

        public /* synthetic */ AddMemberApply(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r101);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberPermission;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberPermission$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberPermission$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AddMemberPermission extends com.lark.wire.Message<AddMemberPermission, a> {
        public static final ProtoAdapter<AddMemberPermission> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberPermission$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "ONLY_OWNER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final b Companion = null;
            public static final Enum ONLY_OWNER = null;
            public static final Enum UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Enum[] f278995a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f278996b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r100) {
                    Enum.Companion.getClass();
                    if (r100 == 0) goto L12;
                    if (r100 == 1) goto L15;
                    if (r100 == 2) goto L14;
                    return null;
                L14:
                    return Enum.ONLY_OWNER;
                L15:
                    return Enum.ALL_MEMBERS;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r100, Syntax r101, Enum r102) {
                    super(r100, r101, r102);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return f278996b;
            }

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Enum r102 = new Enum("ONLY_OWNER", 2, 2);
                ONLY_OWNER = r102;
                Enum[] r103 = {r100, r101, r102};
                f278995a = r103;
                f278996b = EnumEntriesKt.enumEntries(r103);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r100);
            }

            public static Enum[] values() {
                return (Enum[]) f278995a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r100) {
                Companion.getClass();
                if (r100 == 0) goto L12;
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L14;
                return null;
            L14:
                return ONLY_OWNER;
            L15:
                return ALL_MEMBERS;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) r27.a.a(Enum.class, r100);
            }

            public Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class a extends com.lark.wire.Message.a<AddMemberPermission, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new AddMemberPermission(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<AddMemberPermission> {
            @Override // com.lark.wire.ProtoAdapter
            public final AddMemberPermission c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                long r102 = r100.c();
            L3:
                int r103 = r100.e();
                if (r103 == (-1)) goto L7;
                r100.j(r103);
                goto L3
            L7:
                return new AddMemberPermission(r101, r100.d(r102), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(AddMemberPermission r100) {
                AddMemberPermission r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                return r101.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, AddMemberPermission r101) {
                AddMemberPermission r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, AddMemberPermission r101) {
                AddMemberPermission r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
            }

            public b(FieldEncoding r100, KClass<AddMemberPermission> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chat.AddMemberPermission", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ AddMemberPermission(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AddMemberPermission.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.a(unknownFields());
            return r100;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(AddMemberPermission.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public AddMemberPermission(ByteString r100) {
            super(ADAPTER, r100);
        }

        public /* synthetic */ AddMemberPermission(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r101);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$AdminPostSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$AdminPostSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$AdminPostSetting$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AdminPostSetting extends com.lark.wire.Message<AdminPostSetting, a> {
        public static final ProtoAdapter<AdminPostSetting> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$AdminPostSetting$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALLOW_POST", "BANNED_POST", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALLOW_POST = null;
            public static final Enum BANNED_POST = null;
            public static final b Companion = null;
            public static final Enum UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Enum[] f278997a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f278998b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r100) {
                    Enum.Companion.getClass();
                    if (r100 == 0) goto L12;
                    if (r100 == 1) goto L15;
                    if (r100 == 2) goto L14;
                    return null;
                L14:
                    return Enum.BANNED_POST;
                L15:
                    return Enum.ALLOW_POST;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r100, Syntax r101, Enum r102) {
                    super(r100, r101, r102);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return f278998b;
            }

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALLOW_POST", 1, 1);
                ALLOW_POST = r101;
                Enum r102 = new Enum("BANNED_POST", 2, 2);
                BANNED_POST = r102;
                Enum[] r103 = {r100, r101, r102};
                f278997a = r103;
                f278998b = EnumEntriesKt.enumEntries(r103);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r100);
            }

            public static Enum[] values() {
                return (Enum[]) f278997a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r100) {
                Companion.getClass();
                if (r100 == 0) goto L12;
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L14;
                return null;
            L14:
                return BANNED_POST;
            L15:
                return ALLOW_POST;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) r27.a.a(Enum.class, r100);
            }

            public Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class a extends com.lark.wire.Message.a<AdminPostSetting, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new AdminPostSetting(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<AdminPostSetting> {
            @Override // com.lark.wire.ProtoAdapter
            public final AdminPostSetting c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                long r102 = r100.c();
            L3:
                int r103 = r100.e();
                if (r103 == (-1)) goto L7;
                r100.j(r103);
                goto L3
            L7:
                return new AdminPostSetting(r101, r100.d(r102), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(AdminPostSetting r100) {
                AdminPostSetting r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                return r101.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, AdminPostSetting r101) {
                AdminPostSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, AdminPostSetting r101) {
                AdminPostSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
            }

            public b(FieldEncoding r100, KClass<AdminPostSetting> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chat.AdminPostSetting", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ AdminPostSetting(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AdminPostSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.a(unknownFields());
            return r100;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(AdminPostSetting.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public AdminPostSetting(ByteString r100) {
            super(ADAPTER, r100);
        }

        public /* synthetic */ AdminPostSetting(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r101);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001e\u001fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000bR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018¨\u0006 "}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$Announcement;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$Announcement$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$Announcement$Builder;Lokio/ByteString;)V", "content", "", "getContent", "()Ljava/lang/String;", "update_time", "", "getUpdate_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "last_editor_id", "getLast_editor_id", "doc_url", "getDoc_url", "enable_open_doc", "", "getEnable_open_doc", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "use_opendoc", "getUse_opendoc", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Announcement extends com.lark.wire.Message<Announcement, a> {
        public static final ProtoAdapter<Announcement> ADAPTER = null;
        public static final c Companion = null;
        public static final boolean DEFAULT_ENABLE_OPEN_DOC = false;
        public static final boolean DEFAULT_USE_OPENDOC = true;
        private static final long serialVersionUID = 0;
        private final String content;
        private final String doc_url;
        private final Boolean enable_open_doc;
        private final String last_editor_id;
        private final Long update_time;
        private final Boolean use_opendoc;

        public static final class a extends com.lark.wire.Message.a<Announcement, a> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f278999d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Long f279000e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public String f279001f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public String f279002g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public Boolean f279003h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public Boolean f279004i;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Announcement(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Announcement> {
            @Override // com.lark.wire.ProtoAdapter
            public final Announcement c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                long r102 = r100.c();
            L3:
                int r103 = r100.e();
                if (r103 == (-1)) goto L14;
                switch(r103) {
                    case 1: goto L12;
                    case 2: goto L11;
                    case 3: goto L10;
                    case 4: goto L9;
                    case 5: goto L8;
                    case 6: goto L7;
                    default: goto L6;
                };
            L7:
                r101.f279004i = (Boolean) ProtoAdapter.f282718g.c(r100);
                goto L3
            L8:
                r101.f279003h = (Boolean) ProtoAdapter.f282718g.c(r100);
                goto L3
            L9:
                ProtoAdapter.f282728q.getClass();
                Intrinsics.checkNotNullParameter(r100, "reader");
                r101.f279002g = r100.i();
                goto L3
            L10:
                ProtoAdapter.f282728q.getClass();
                Intrinsics.checkNotNullParameter(r100, "reader");
                r101.f279001f = r100.i();
                goto L3
            L11:
                r101.f279000e = (Long) ProtoAdapter.f282722k.c(r100);
                goto L3
            L12:
                ProtoAdapter.f282728q.getClass();
                Intrinsics.checkNotNullParameter(r100, "reader");
                r101.f278999d = r100.i();
                goto L3
            L6:
                r100.j(r103);
                Unit r104 = Unit.INSTANCE;
                goto L3
            L14:
                return new Announcement(r101, r100.d(r102), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Announcement r100) {
                Announcement r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                int r102 = r101.unknownFields().size();
                w r103 = ProtoAdapter.f282728q;
                int r104 = (((r102 + r103.l(1, r101.getContent())) + ProtoAdapter.f282722k.l(2, r101.getUpdate_time())) + r103.l(3, r101.getLast_editor_id())) + r103.l(4, r101.getDoc_url());
                l r105 = ProtoAdapter.f282718g;
                return (r104 + r105.l(5, r101.getEnable_open_doc())) + r105.l(6, r101.getUse_opendoc());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, Announcement r101) {
                Announcement r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                w r103 = ProtoAdapter.f282728q;
                r103.i(r100, 1, r102.getContent());
                ProtoAdapter.f282722k.i(r100, 2, r102.getUpdate_time());
                r103.i(r100, 3, r102.getLast_editor_id());
                r103.i(r100, 4, r102.getDoc_url());
                l r104 = ProtoAdapter.f282718g;
                r104.i(r100, 5, r102.getEnable_open_doc());
                r104.i(r100, 6, r102.getUse_opendoc());
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, Announcement r101) {
                Announcement r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
                l r103 = ProtoAdapter.f282718g;
                r103.j(r100, 6, r102.getUse_opendoc());
                r103.j(r100, 5, r102.getEnable_open_doc());
                w r104 = ProtoAdapter.f282728q;
                r104.j(r100, 4, r102.getDoc_url());
                r104.j(r100, 3, r102.getLast_editor_id());
                ProtoAdapter.f282722k.j(r100, 2, r102.getUpdate_time());
                r104.j(r100, 1, r102.getContent());
            }

            public b(FieldEncoding r100, KClass<Announcement> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chat.Announcement", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Announcement(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r100, r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Announcement.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.f278999d = this.content;
            r100.f279000e = this.update_time;
            r100.f279001f = this.last_editor_id;
            r100.f279002g = this.doc_url;
            r100.f279003h = this.enable_open_doc;
            r100.f279004i = this.use_opendoc;
            r100.a(unknownFields());
            return r100;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Announcement.class).getSimpleName() + '@' + hashCode();
        }

        public final String getContent() {
            return this.content;
        }

        public final String getDoc_url() {
            return this.doc_url;
        }

        public final Boolean getEnable_open_doc() {
            return this.enable_open_doc;
        }

        public final String getLast_editor_id() {
            return this.last_editor_id;
        }

        public final Long getUpdate_time() {
            return this.update_time;
        }

        public final Boolean getUse_opendoc() {
            return this.use_opendoc;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Announcement(a r100, ByteString r101) {
            super(ADAPTER, r101);
            this.content = r100.f278999d;
            this.update_time = r100.f279000e;
            this.last_editor_id = r100.f279001f;
            this.doc_url = r100.f279002g;
            this.enable_open_doc = r100.f279003h;
            this.use_opendoc = r100.f279004i;
        }

        public /* synthetic */ Announcement(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$AnonymousSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$AnonymousSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$AnonymousSetting$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousSetting extends com.lark.wire.Message<AnonymousSetting, a> {
        public static final ProtoAdapter<AnonymousSetting> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$AnonymousSetting$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "INVISIBLE", "NOT_ALLOWED", "ALLOWED", "INVISIBLE_ALLOWED", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALLOWED = null;
            public static final b Companion = null;
            public static final Enum INVISIBLE = null;
            public static final Enum INVISIBLE_ALLOWED = null;
            public static final Enum NOT_ALLOWED = null;
            public static final Enum UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Enum[] f279005a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f279006b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r100) {
                    Enum.Companion.getClass();
                    return b.a(r100);
                }

                public a(KClass<Enum> r100, Syntax r101, Enum r102) {
                    super(r100, r101, r102);
                }
            }

            public static final class b {
                public b() {
                }

                @JvmStatic
                public static Enum a(int r100) {
                    if (r100 == 0) goto L17;
                    if (r100 == 1) goto L22;
                    if (r100 == 2) goto L21;
                    if (r100 == 3) goto L20;
                    if (r100 == 100) goto L19;
                    return null;
                L19:
                    return Enum.INVISIBLE_ALLOWED;
                L20:
                    return Enum.ALLOWED;
                L21:
                    return Enum.NOT_ALLOWED;
                L22:
                    return Enum.INVISIBLE;
                L17:
                    return Enum.UNKNOWN;
                }
            }

            @JvmStatic
            public static final Enum fromValue(int r100) {
                Companion.getClass();
                return b.a(r100);
            }

            public static EnumEntries<Enum> getEntries() {
                return f279006b;
            }

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("INVISIBLE", 1, 1);
                INVISIBLE = r101;
                Enum r102 = new Enum("NOT_ALLOWED", 2, 2);
                NOT_ALLOWED = r102;
                Enum r103 = new Enum("ALLOWED", 3, 3);
                ALLOWED = r103;
                Enum r104 = new Enum("INVISIBLE_ALLOWED", 4, 100);
                INVISIBLE_ALLOWED = r104;
                Enum[] r105 = {r100, r101, r102, r103, r104};
                f279005a = r105;
                f279006b = EnumEntriesKt.enumEntries(r105);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r100);
            }

            public static Enum[] values() {
                return (Enum[]) f279005a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            public static Enum valueOf(String r100) {
                return (Enum) r27.a.a(Enum.class, r100);
            }

            public Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class a extends com.lark.wire.Message.a<AnonymousSetting, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new AnonymousSetting(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<AnonymousSetting> {
            @Override // com.lark.wire.ProtoAdapter
            public final AnonymousSetting c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                long r102 = r100.c();
            L3:
                int r103 = r100.e();
                if (r103 == (-1)) goto L7;
                r100.j(r103);
                goto L3
            L7:
                return new AnonymousSetting(r101, r100.d(r102), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(AnonymousSetting r100) {
                AnonymousSetting r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                return r101.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, AnonymousSetting r101) {
                AnonymousSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, AnonymousSetting r101) {
                AnonymousSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
            }

            public b(FieldEncoding r100, KClass<AnonymousSetting> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chat.AnonymousSetting", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ AnonymousSetting(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AnonymousSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.a(unknownFields());
            return r100;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(AnonymousSetting.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public AnonymousSetting(ByteString r100) {
            super(ADAPTER, r100);
        }

        public /* synthetic */ AnonymousSetting(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r101);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$AtAllPermission;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$AtAllPermission$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$AtAllPermission$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AtAllPermission extends com.lark.wire.Message<AtAllPermission, a> {
        public static final ProtoAdapter<AtAllPermission> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$AtAllPermission$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "ONLY_OWNER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final b Companion = null;
            public static final Enum ONLY_OWNER = null;
            public static final Enum UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Enum[] f279007a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f279008b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r100) {
                    Enum.Companion.getClass();
                    if (r100 == 0) goto L12;
                    if (r100 == 1) goto L15;
                    if (r100 == 2) goto L14;
                    return null;
                L14:
                    return Enum.ONLY_OWNER;
                L15:
                    return Enum.ALL_MEMBERS;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r100, Syntax r101, Enum r102) {
                    super(r100, r101, r102);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return f279008b;
            }

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Enum r102 = new Enum("ONLY_OWNER", 2, 2);
                ONLY_OWNER = r102;
                Enum[] r103 = {r100, r101, r102};
                f279007a = r103;
                f279008b = EnumEntriesKt.enumEntries(r103);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r100);
            }

            public static Enum[] values() {
                return (Enum[]) f279007a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r100) {
                Companion.getClass();
                if (r100 == 0) goto L12;
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L14;
                return null;
            L14:
                return ONLY_OWNER;
            L15:
                return ALL_MEMBERS;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) r27.a.a(Enum.class, r100);
            }

            public Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class a extends com.lark.wire.Message.a<AtAllPermission, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new AtAllPermission(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<AtAllPermission> {
            @Override // com.lark.wire.ProtoAdapter
            public final AtAllPermission c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                long r102 = r100.c();
            L3:
                int r103 = r100.e();
                if (r103 == (-1)) goto L7;
                r100.j(r103);
                goto L3
            L7:
                return new AtAllPermission(r101, r100.d(r102), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(AtAllPermission r100) {
                AtAllPermission r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                return r101.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, AtAllPermission r101) {
                AtAllPermission r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, AtAllPermission r101) {
                AtAllPermission r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
            }

            public b(FieldEncoding r100, KClass<AtAllPermission> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chat.AtAllPermission", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ AtAllPermission(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AtAllPermission.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.a(unknownFields());
            return r100;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(AtAllPermission.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public AtAllPermission(ByteString r100) {
            super(ADAPTER, r100);
        }

        public /* synthetic */ AtAllPermission(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r101);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$ChatDisplayModeSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$ChatDisplayModeSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$ChatDisplayModeSetting$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ChatDisplayModeSetting extends com.lark.wire.Message<ChatDisplayModeSetting, a> {
        public static final ProtoAdapter<ChatDisplayModeSetting> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$ChatDisplayModeSetting$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DEFAULT", "THREAD", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final b Companion = null;
            public static final Enum DEFAULT = null;
            public static final Enum THREAD = null;
            public static final Enum UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Enum[] f279009a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f279010b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r100) {
                    Enum.Companion.getClass();
                    if (r100 == 0) goto L12;
                    if (r100 == 1) goto L15;
                    if (r100 == 2) goto L14;
                    return null;
                L14:
                    return Enum.THREAD;
                L15:
                    return Enum.DEFAULT;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r100, Syntax r101, Enum r102) {
                    super(r100, r101, r102);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return f279010b;
            }

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("DEFAULT", 1, 1);
                DEFAULT = r101;
                Enum r102 = new Enum("THREAD", 2, 2);
                THREAD = r102;
                Enum[] r103 = {r100, r101, r102};
                f279009a = r103;
                f279010b = EnumEntriesKt.enumEntries(r103);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r100);
            }

            public static Enum[] values() {
                return (Enum[]) f279009a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r100) {
                Companion.getClass();
                if (r100 == 0) goto L12;
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L14;
                return null;
            L14:
                return THREAD;
            L15:
                return DEFAULT;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) r27.a.a(Enum.class, r100);
            }

            public Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class a extends com.lark.wire.Message.a<ChatDisplayModeSetting, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ChatDisplayModeSetting(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ChatDisplayModeSetting> {
            @Override // com.lark.wire.ProtoAdapter
            public final ChatDisplayModeSetting c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                long r102 = r100.c();
            L3:
                int r103 = r100.e();
                if (r103 == (-1)) goto L7;
                r100.j(r103);
                goto L3
            L7:
                return new ChatDisplayModeSetting(r101, r100.d(r102), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ChatDisplayModeSetting r100) {
                ChatDisplayModeSetting r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                return r101.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, ChatDisplayModeSetting r101) {
                ChatDisplayModeSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, ChatDisplayModeSetting r101) {
                ChatDisplayModeSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
            }

            public b(FieldEncoding r100, KClass<ChatDisplayModeSetting> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chat.ChatDisplayModeSetting", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ChatDisplayModeSetting(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ChatDisplayModeSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.a(unknownFields());
            return r100;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ChatDisplayModeSetting.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ChatDisplayModeSetting(ByteString r100) {
            super(ADAPTER, r100);
        }

        public /* synthetic */ ChatDisplayModeSetting(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$ChatMode;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DEFAULT", "THREAD", "THREAD_V2", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ChatMode extends Enum<ChatMode> implements o0 {
        public static final ProtoAdapter<ChatMode> ADAPTER = null;
        public static final b Companion = null;
        public static final ChatMode DEFAULT = null;

        @Deprecated(message = "THREAD is deprecated")
        public static final ChatMode THREAD = null;
        public static final ChatMode THREAD_V2 = null;
        public static final ChatMode UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChatMode[] f279011a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f279012b = null;
        private final int value;

        public static final class a extends d<ChatMode> {
            @Override // com.lark.wire.d
            public final o0 n(int r100) {
                ChatMode.Companion.getClass();
                if (r100 == 0) goto L15;
                if (r100 == 1) goto L19;
                if (r100 == 2) goto L18;
                if (r100 == 3) goto L17;
                return null;
            L17:
                return ChatMode.THREAD_V2;
            L18:
                return ChatMode.THREAD;
            L19:
                return ChatMode.DEFAULT;
            L15:
                return ChatMode.UNKNOWN;
            }

            public a(KClass<ChatMode> r100, Syntax r101, ChatMode r102) {
                super(r100, r101, r102);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<ChatMode> getEntries() {
            return f279012b;
        }

        static {
            ChatMode r100 = new ChatMode("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ChatMode r101 = new ChatMode("DEFAULT", 1, 1);
            DEFAULT = r101;
            ChatMode r102 = new ChatMode("THREAD", 2, 2);
            THREAD = r102;
            ChatMode r103 = new ChatMode("THREAD_V2", 3, 3);
            THREAD_V2 = r103;
            ChatMode[] r104 = {r100, r101, r102, r103};
            f279011a = r104;
            f279012b = EnumEntriesKt.enumEntries(r104);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(ChatMode.class), Syntax.PROTO_2, r100);
        }

        public static ChatMode[] values() {
            return (ChatMode[]) f279011a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final ChatMode fromValue(int r100) {
            Companion.getClass();
            if (r100 == 0) goto L15;
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L17;
            return null;
        L17:
            return THREAD_V2;
        L18:
            return THREAD;
        L19:
            return DEFAULT;
        L15:
            return UNKNOWN;
        }

        public static ChatMode valueOf(String r100) {
            return (ChatMode) r27.a.a(ChatMode.class, r100);
        }

        public ChatMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$ChatPinPermissionSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$ChatPinPermissionSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$ChatPinPermissionSetting$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ChatPinPermissionSetting extends com.lark.wire.Message<ChatPinPermissionSetting, a> {
        public static final ProtoAdapter<ChatPinPermissionSetting> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$ChatPinPermissionSetting$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "ONLY_MANAGER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final b Companion = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Enum[] f279013a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f279014b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r100) {
                    Enum.Companion.getClass();
                    if (r100 == 0) goto L12;
                    if (r100 == 1) goto L15;
                    if (r100 == 2) goto L14;
                    return null;
                L14:
                    return Enum.ONLY_MANAGER;
                L15:
                    return Enum.ALL_MEMBERS;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r100, Syntax r101, Enum r102) {
                    super(r100, r101, r102);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return f279014b;
            }

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Enum r102 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r102;
                Enum[] r103 = {r100, r101, r102};
                f279013a = r103;
                f279014b = EnumEntriesKt.enumEntries(r103);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r100);
            }

            public static Enum[] values() {
                return (Enum[]) f279013a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r100) {
                Companion.getClass();
                if (r100 == 0) goto L12;
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L14;
                return null;
            L14:
                return ONLY_MANAGER;
            L15:
                return ALL_MEMBERS;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) r27.a.a(Enum.class, r100);
            }

            public Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class a extends com.lark.wire.Message.a<ChatPinPermissionSetting, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ChatPinPermissionSetting(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ChatPinPermissionSetting> {
            @Override // com.lark.wire.ProtoAdapter
            public final ChatPinPermissionSetting c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                long r102 = r100.c();
            L3:
                int r103 = r100.e();
                if (r103 == (-1)) goto L7;
                r100.j(r103);
                goto L3
            L7:
                return new ChatPinPermissionSetting(r101, r100.d(r102), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ChatPinPermissionSetting r100) {
                ChatPinPermissionSetting r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                return r101.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, ChatPinPermissionSetting r101) {
                ChatPinPermissionSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, ChatPinPermissionSetting r101) {
                ChatPinPermissionSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
            }

            public b(FieldEncoding r100, KClass<ChatPinPermissionSetting> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chat.ChatPinPermissionSetting", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ChatPinPermissionSetting(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ChatPinPermissionSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.a(unknownFields());
            return r100;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ChatPinPermissionSetting.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ChatPinPermissionSetting(ByteString r100) {
            super(ADAPTER, r100);
        }

        public /* synthetic */ ChatPinPermissionSetting(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r101);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$ChatTabPermissionSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$ChatTabPermissionSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$ChatTabPermissionSetting$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ChatTabPermissionSetting extends com.lark.wire.Message<ChatTabPermissionSetting, a> {
        public static final ProtoAdapter<ChatTabPermissionSetting> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$ChatTabPermissionSetting$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "ONLY_MANAGER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final b Companion = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Enum[] f279015a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f279016b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r100) {
                    Enum.Companion.getClass();
                    if (r100 == 0) goto L12;
                    if (r100 == 1) goto L15;
                    if (r100 == 2) goto L14;
                    return null;
                L14:
                    return Enum.ONLY_MANAGER;
                L15:
                    return Enum.ALL_MEMBERS;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r100, Syntax r101, Enum r102) {
                    super(r100, r101, r102);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return f279016b;
            }

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Enum r102 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r102;
                Enum[] r103 = {r100, r101, r102};
                f279015a = r103;
                f279016b = EnumEntriesKt.enumEntries(r103);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r100);
            }

            public static Enum[] values() {
                return (Enum[]) f279015a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r100) {
                Companion.getClass();
                if (r100 == 0) goto L12;
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L14;
                return null;
            L14:
                return ONLY_MANAGER;
            L15:
                return ALL_MEMBERS;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) r27.a.a(Enum.class, r100);
            }

            public Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class a extends com.lark.wire.Message.a<ChatTabPermissionSetting, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ChatTabPermissionSetting(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ChatTabPermissionSetting> {
            @Override // com.lark.wire.ProtoAdapter
            public final ChatTabPermissionSetting c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                long r102 = r100.c();
            L3:
                int r103 = r100.e();
                if (r103 == (-1)) goto L7;
                r100.j(r103);
                goto L3
            L7:
                return new ChatTabPermissionSetting(r101, r100.d(r102), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ChatTabPermissionSetting r100) {
                ChatTabPermissionSetting r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                return r101.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, ChatTabPermissionSetting r101) {
                ChatTabPermissionSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, ChatTabPermissionSetting r101) {
                ChatTabPermissionSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
            }

            public b(FieldEncoding r100, KClass<ChatTabPermissionSetting> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chat.ChatTabPermissionSetting", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ChatTabPermissionSetting(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ChatTabPermissionSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.a(unknownFields());
            return r100;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ChatTabPermissionSetting.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ChatTabPermissionSetting(ByteString r100) {
            super(ADAPTER, r100);
        }

        public /* synthetic */ ChatTabPermissionSetting(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r101);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$CreateUrgentSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$CreateUrgentSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$CreateUrgentSetting$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CreateUrgentSetting extends com.lark.wire.Message<CreateUrgentSetting, a> {
        public static final ProtoAdapter<CreateUrgentSetting> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$CreateUrgentSetting$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "ONLY_MANAGER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final b Companion = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Enum[] f279019a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f279020b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r100) {
                    Enum.Companion.getClass();
                    if (r100 == 0) goto L12;
                    if (r100 == 1) goto L15;
                    if (r100 == 2) goto L14;
                    return null;
                L14:
                    return Enum.ONLY_MANAGER;
                L15:
                    return Enum.ALL_MEMBERS;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r100, Syntax r101, Enum r102) {
                    super(r100, r101, r102);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return f279020b;
            }

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Enum r102 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r102;
                Enum[] r103 = {r100, r101, r102};
                f279019a = r103;
                f279020b = EnumEntriesKt.enumEntries(r103);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r100);
            }

            public static Enum[] values() {
                return (Enum[]) f279019a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r100) {
                Companion.getClass();
                if (r100 == 0) goto L12;
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L14;
                return null;
            L14:
                return ONLY_MANAGER;
            L15:
                return ALL_MEMBERS;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) r27.a.a(Enum.class, r100);
            }

            public Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class a extends com.lark.wire.Message.a<CreateUrgentSetting, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new CreateUrgentSetting(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<CreateUrgentSetting> {
            @Override // com.lark.wire.ProtoAdapter
            public final CreateUrgentSetting c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                long r102 = r100.c();
            L3:
                int r103 = r100.e();
                if (r103 == (-1)) goto L7;
                r100.j(r103);
                goto L3
            L7:
                return new CreateUrgentSetting(r101, r100.d(r102), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(CreateUrgentSetting r100) {
                CreateUrgentSetting r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                return r101.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, CreateUrgentSetting r101) {
                CreateUrgentSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, CreateUrgentSetting r101) {
                CreateUrgentSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
            }

            public b(FieldEncoding r100, KClass<CreateUrgentSetting> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chat.CreateUrgentSetting", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ CreateUrgentSetting(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CreateUrgentSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.a(unknownFields());
            return r100;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(CreateUrgentSetting.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public CreateUrgentSetting(ByteString r100) {
            super(ADAPTER, r100);
        }

        public /* synthetic */ CreateUrgentSetting(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r101);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$CreateVideoConferenceSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$CreateVideoConferenceSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$CreateVideoConferenceSetting$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CreateVideoConferenceSetting extends com.lark.wire.Message<CreateVideoConferenceSetting, a> {
        public static final ProtoAdapter<CreateVideoConferenceSetting> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$CreateVideoConferenceSetting$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "ONLY_MANAGER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final b Companion = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Enum[] f279021a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f279022b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r100) {
                    Enum.Companion.getClass();
                    if (r100 == 0) goto L12;
                    if (r100 == 1) goto L15;
                    if (r100 == 2) goto L14;
                    return null;
                L14:
                    return Enum.ONLY_MANAGER;
                L15:
                    return Enum.ALL_MEMBERS;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r100, Syntax r101, Enum r102) {
                    super(r100, r101, r102);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return f279022b;
            }

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Enum r102 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r102;
                Enum[] r103 = {r100, r101, r102};
                f279021a = r103;
                f279022b = EnumEntriesKt.enumEntries(r103);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r100);
            }

            public static Enum[] values() {
                return (Enum[]) f279021a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r100) {
                Companion.getClass();
                if (r100 == 0) goto L12;
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L14;
                return null;
            L14:
                return ONLY_MANAGER;
            L15:
                return ALL_MEMBERS;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) r27.a.a(Enum.class, r100);
            }

            public Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class a extends com.lark.wire.Message.a<CreateVideoConferenceSetting, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new CreateVideoConferenceSetting(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<CreateVideoConferenceSetting> {
            @Override // com.lark.wire.ProtoAdapter
            public final CreateVideoConferenceSetting c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                long r102 = r100.c();
            L3:
                int r103 = r100.e();
                if (r103 == (-1)) goto L7;
                r100.j(r103);
                goto L3
            L7:
                return new CreateVideoConferenceSetting(r101, r100.d(r102), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(CreateVideoConferenceSetting r100) {
                CreateVideoConferenceSetting r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                return r101.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, CreateVideoConferenceSetting r101) {
                CreateVideoConferenceSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, CreateVideoConferenceSetting r101) {
                CreateVideoConferenceSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
            }

            public b(FieldEncoding r100, KClass<CreateVideoConferenceSetting> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chat.CreateVideoConferenceSetting", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ CreateVideoConferenceSetting(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CreateVideoConferenceSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.a(unknownFields());
            return r100;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(CreateVideoConferenceSetting.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public CreateVideoConferenceSetting(ByteString r100) {
            super(ADAPTER, r100);
        }

        public /* synthetic */ CreateVideoConferenceSetting(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r101);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$DefDisplaySetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$DefDisplaySetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$DefDisplaySetting$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DefDisplaySetting extends com.lark.wire.Message<DefDisplaySetting, a> {
        public static final ProtoAdapter<DefDisplaySetting> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$DefDisplaySetting$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "INPUT_BOX", "CHAT_MENU", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum CHAT_MENU = null;
            public static final b Companion = null;
            public static final Enum INPUT_BOX = null;
            public static final Enum UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Enum[] f279023a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f279024b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r100) {
                    Enum.Companion.getClass();
                    if (r100 == 0) goto L12;
                    if (r100 == 1) goto L15;
                    if (r100 == 2) goto L14;
                    return null;
                L14:
                    return Enum.CHAT_MENU;
                L15:
                    return Enum.INPUT_BOX;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r100, Syntax r101, Enum r102) {
                    super(r100, r101, r102);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return f279024b;
            }

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("INPUT_BOX", 1, 1);
                INPUT_BOX = r101;
                Enum r102 = new Enum("CHAT_MENU", 2, 2);
                CHAT_MENU = r102;
                Enum[] r103 = {r100, r101, r102};
                f279023a = r103;
                f279024b = EnumEntriesKt.enumEntries(r103);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r100);
            }

            public static Enum[] values() {
                return (Enum[]) f279023a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r100) {
                Companion.getClass();
                if (r100 == 0) goto L12;
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L14;
                return null;
            L14:
                return CHAT_MENU;
            L15:
                return INPUT_BOX;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) r27.a.a(Enum.class, r100);
            }

            public Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class a extends com.lark.wire.Message.a<DefDisplaySetting, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new DefDisplaySetting(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<DefDisplaySetting> {
            @Override // com.lark.wire.ProtoAdapter
            public final DefDisplaySetting c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                long r102 = r100.c();
            L3:
                int r103 = r100.e();
                if (r103 == (-1)) goto L7;
                r100.j(r103);
                goto L3
            L7:
                return new DefDisplaySetting(r101, r100.d(r102), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(DefDisplaySetting r100) {
                DefDisplaySetting r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                return r101.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, DefDisplaySetting r101) {
                DefDisplaySetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, DefDisplaySetting r101) {
                DefDisplaySetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
            }

            public b(FieldEncoding r100, KClass<DefDisplaySetting> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chat.DefDisplaySetting", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ DefDisplaySetting(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(DefDisplaySetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.a(unknownFields());
            return r100;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(DefDisplaySetting.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public DefDisplaySetting(ByteString r100) {
            super(ADAPTER, r100);
        }

        public /* synthetic */ DefDisplaySetting(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r101);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$DoubaoSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$DoubaoSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$DoubaoSetting$Builder;Lokio/ByteString;)V", "doubao_using_enabled", "", "getDoubao_using_enabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "doubao_proactive_reply_enabled", "getDoubao_proactive_reply_enabled", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DoubaoSetting extends com.lark.wire.Message<DoubaoSetting, a> {
        public static final ProtoAdapter<DoubaoSetting> ADAPTER = null;
        public static final c Companion = null;
        public static final boolean DEFAULT_DOUBAO_PROACTIVE_REPLY_ENABLED = false;
        public static final boolean DEFAULT_DOUBAO_USING_ENABLED = true;
        private static final long serialVersionUID = 0;
        private final Boolean doubao_proactive_reply_enabled;
        private final Boolean doubao_using_enabled;

        public static final class a extends com.lark.wire.Message.a<DoubaoSetting, a> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Boolean f279025d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Boolean f279026e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new DoubaoSetting(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<DoubaoSetting> {
            @Override // com.lark.wire.ProtoAdapter
            public final DoubaoSetting c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                long r102 = r100.c();
            L3:
                int r103 = r100.e();
                if (r103 == (-1)) goto L13;
                if (r103 != 1) goto L8;
                r101.f279025d = (Boolean) ProtoAdapter.f282718g.c(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.f279026e = (Boolean) ProtoAdapter.f282718g.c(r100);
                goto L3
            L9:
                r100.j(r103);
                Unit r104 = Unit.INSTANCE;
                goto L3
            L13:
                return new DoubaoSetting(r101, r100.d(r102), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(DoubaoSetting r100) {
                DoubaoSetting r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                int r102 = r101.unknownFields().size();
                l r103 = ProtoAdapter.f282718g;
                return (r102 + r103.l(1, r101.getDoubao_using_enabled())) + r103.l(2, r101.getDoubao_proactive_reply_enabled());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, DoubaoSetting r101) {
                DoubaoSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                l r103 = ProtoAdapter.f282718g;
                r103.i(r100, 1, r102.getDoubao_using_enabled());
                r103.i(r100, 2, r102.getDoubao_proactive_reply_enabled());
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, DoubaoSetting r101) {
                DoubaoSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
                l r103 = ProtoAdapter.f282718g;
                r103.j(r100, 2, r102.getDoubao_proactive_reply_enabled());
                r103.j(r100, 1, r102.getDoubao_using_enabled());
            }

            public b(FieldEncoding r100, KClass<DoubaoSetting> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chat.DoubaoSetting", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ DoubaoSetting(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r100, r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(DoubaoSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.f279025d = this.doubao_using_enabled;
            r100.f279026e = this.doubao_proactive_reply_enabled;
            r100.a(unknownFields());
            return r100;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(DoubaoSetting.class).getSimpleName() + '@' + hashCode();
        }

        public final Boolean getDoubao_proactive_reply_enabled() {
            return this.doubao_proactive_reply_enabled;
        }

        public final Boolean getDoubao_using_enabled() {
            return this.doubao_using_enabled;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public DoubaoSetting(a r100, ByteString r101) {
            super(ADAPTER, r101);
            this.doubao_using_enabled = r100.f279025d;
            this.doubao_proactive_reply_enabled = r100.f279026e;
        }

        public /* synthetic */ DoubaoSetting(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$MessagePosition;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$MessagePosition$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$MessagePosition$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MessagePosition extends com.lark.wire.Message<MessagePosition, a> {
        public static final ProtoAdapter<MessagePosition> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$MessagePosition$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "RECENT_LEFT", "NEWEST_UNREAD", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final b Companion = null;
            public static final Enum NEWEST_UNREAD = null;
            public static final Enum RECENT_LEFT = null;
            public static final Enum UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Enum[] f279027a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f279028b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r100) {
                    Enum.Companion.getClass();
                    if (r100 == 0) goto L12;
                    if (r100 == 1) goto L15;
                    if (r100 == 2) goto L14;
                    return null;
                L14:
                    return Enum.NEWEST_UNREAD;
                L15:
                    return Enum.RECENT_LEFT;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r100, Syntax r101, Enum r102) {
                    super(r100, r101, r102);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return f279028b;
            }

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("RECENT_LEFT", 1, 1);
                RECENT_LEFT = r101;
                Enum r102 = new Enum("NEWEST_UNREAD", 2, 2);
                NEWEST_UNREAD = r102;
                Enum[] r103 = {r100, r101, r102};
                f279027a = r103;
                f279028b = EnumEntriesKt.enumEntries(r103);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r100);
            }

            public static Enum[] values() {
                return (Enum[]) f279027a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r100) {
                Companion.getClass();
                if (r100 == 0) goto L12;
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L14;
                return null;
            L14:
                return NEWEST_UNREAD;
            L15:
                return RECENT_LEFT;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) r27.a.a(Enum.class, r100);
            }

            public Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class a extends com.lark.wire.Message.a<MessagePosition, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new MessagePosition(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<MessagePosition> {
            @Override // com.lark.wire.ProtoAdapter
            public final MessagePosition c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                long r102 = r100.c();
            L3:
                int r103 = r100.e();
                if (r103 == (-1)) goto L7;
                r100.j(r103);
                goto L3
            L7:
                return new MessagePosition(r101, r100.d(r102), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(MessagePosition r100) {
                MessagePosition r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                return r101.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, MessagePosition r101) {
                MessagePosition r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, MessagePosition r101) {
                MessagePosition r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
            }

            public b(FieldEncoding r100, KClass<MessagePosition> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chat.MessagePosition", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ MessagePosition(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MessagePosition.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.a(unknownFields());
            return r100;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(MessagePosition.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public MessagePosition(ByteString r100) {
            super(ADAPTER, r100);
        }

        public /* synthetic */ MessagePosition(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r101);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$MessageVisibilitySetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$MessageVisibilitySetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$MessageVisibilitySetting$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MessageVisibilitySetting extends com.lark.wire.Message<MessageVisibilitySetting, a> {
        public static final ProtoAdapter<MessageVisibilitySetting> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$MessageVisibilitySetting$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MESSAGES", "ONLY_NEW_MESSAGES", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MESSAGES = null;
            public static final b Companion = null;
            public static final Enum ONLY_NEW_MESSAGES = null;
            public static final Enum UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Enum[] f279029a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f279030b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r100) {
                    Enum.Companion.getClass();
                    if (r100 == 0) goto L12;
                    if (r100 == 1) goto L15;
                    if (r100 == 2) goto L14;
                    return null;
                L14:
                    return Enum.ONLY_NEW_MESSAGES;
                L15:
                    return Enum.ALL_MESSAGES;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r100, Syntax r101, Enum r102) {
                    super(r100, r101, r102);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return f279030b;
            }

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALL_MESSAGES", 1, 1);
                ALL_MESSAGES = r101;
                Enum r102 = new Enum("ONLY_NEW_MESSAGES", 2, 2);
                ONLY_NEW_MESSAGES = r102;
                Enum[] r103 = {r100, r101, r102};
                f279029a = r103;
                f279030b = EnumEntriesKt.enumEntries(r103);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r100);
            }

            public static Enum[] values() {
                return (Enum[]) f279029a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r100) {
                Companion.getClass();
                if (r100 == 0) goto L12;
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L14;
                return null;
            L14:
                return ONLY_NEW_MESSAGES;
            L15:
                return ALL_MESSAGES;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) r27.a.a(Enum.class, r100);
            }

            public Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class a extends com.lark.wire.Message.a<MessageVisibilitySetting, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new MessageVisibilitySetting(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<MessageVisibilitySetting> {
            @Override // com.lark.wire.ProtoAdapter
            public final MessageVisibilitySetting c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                long r102 = r100.c();
            L3:
                int r103 = r100.e();
                if (r103 == (-1)) goto L7;
                r100.j(r103);
                goto L3
            L7:
                return new MessageVisibilitySetting(r101, r100.d(r102), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(MessageVisibilitySetting r100) {
                MessageVisibilitySetting r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                return r101.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, MessageVisibilitySetting r101) {
                MessageVisibilitySetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, MessageVisibilitySetting r101) {
                MessageVisibilitySetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
            }

            public b(FieldEncoding r100, KClass<MessageVisibilitySetting> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chat.MessageVisibilitySetting", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ MessageVisibilitySetting(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MessageVisibilitySetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.a(unknownFields());
            return r100;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(MessageVisibilitySetting.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public MessageVisibilitySetting(ByteString r100) {
            super(ADAPTER, r100);
        }

        public /* synthetic */ MessageVisibilitySetting(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r101);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$PinPermissionSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$PinPermissionSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$PinPermissionSetting$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PinPermissionSetting extends com.lark.wire.Message<PinPermissionSetting, a> {
        public static final ProtoAdapter<PinPermissionSetting> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$PinPermissionSetting$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "ONLY_MANAGER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final b Companion = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Enum[] f279031a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f279032b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r100) {
                    Enum.Companion.getClass();
                    if (r100 == 0) goto L12;
                    if (r100 == 1) goto L15;
                    if (r100 == 2) goto L14;
                    return null;
                L14:
                    return Enum.ONLY_MANAGER;
                L15:
                    return Enum.ALL_MEMBERS;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r100, Syntax r101, Enum r102) {
                    super(r100, r101, r102);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return f279032b;
            }

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Enum r102 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r102;
                Enum[] r103 = {r100, r101, r102};
                f279031a = r103;
                f279032b = EnumEntriesKt.enumEntries(r103);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r100);
            }

            public static Enum[] values() {
                return (Enum[]) f279031a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r100) {
                Companion.getClass();
                if (r100 == 0) goto L12;
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L14;
                return null;
            L14:
                return ONLY_MANAGER;
            L15:
                return ALL_MEMBERS;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) r27.a.a(Enum.class, r100);
            }

            public Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class a extends com.lark.wire.Message.a<PinPermissionSetting, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new PinPermissionSetting(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<PinPermissionSetting> {
            @Override // com.lark.wire.ProtoAdapter
            public final PinPermissionSetting c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                long r102 = r100.c();
            L3:
                int r103 = r100.e();
                if (r103 == (-1)) goto L7;
                r100.j(r103);
                goto L3
            L7:
                return new PinPermissionSetting(r101, r100.d(r102), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(PinPermissionSetting r100) {
                PinPermissionSetting r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                return r101.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, PinPermissionSetting r101) {
                PinPermissionSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, PinPermissionSetting r101) {
                PinPermissionSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
            }

            public b(FieldEncoding r100, KClass<PinPermissionSetting> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chat.PinPermissionSetting", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ PinPermissionSetting(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PinPermissionSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.a(unknownFields());
            return r100;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(PinPermissionSetting.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public PinPermissionSetting(ByteString r100) {
            super(ADAPTER, r100);
        }

        public /* synthetic */ PinPermissionSetting(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$PostType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_POST_TYPE", "ANYONE", "ONLY_ADMIN", "WHITE_LIST", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PostType extends Enum<PostType> implements o0 {
        public static final ProtoAdapter<PostType> ADAPTER = null;
        public static final PostType ANYONE = null;
        public static final b Companion = null;
        public static final PostType ONLY_ADMIN = null;
        public static final PostType UNKNOWN_POST_TYPE = null;
        public static final PostType WHITE_LIST = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PostType[] f279033a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f279034b = null;
        private final int value;

        public static final class a extends d<PostType> {
            @Override // com.lark.wire.d
            public final o0 n(int r100) {
                PostType.Companion.getClass();
                if (r100 == 0) goto L15;
                if (r100 == 1) goto L19;
                if (r100 == 2) goto L18;
                if (r100 == 3) goto L17;
                return null;
            L17:
                return PostType.WHITE_LIST;
            L18:
                return PostType.ONLY_ADMIN;
            L19:
                return PostType.ANYONE;
            L15:
                return PostType.UNKNOWN_POST_TYPE;
            }

            public a(KClass<PostType> r100, Syntax r101, PostType r102) {
                super(r100, r101, r102);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<PostType> getEntries() {
            return f279034b;
        }

        static {
            PostType r100 = new PostType("UNKNOWN_POST_TYPE", 0, 0);
            UNKNOWN_POST_TYPE = r100;
            PostType r101 = new PostType("ANYONE", 1, 1);
            ANYONE = r101;
            PostType r102 = new PostType("ONLY_ADMIN", 2, 2);
            ONLY_ADMIN = r102;
            PostType r103 = new PostType("WHITE_LIST", 3, 3);
            WHITE_LIST = r103;
            PostType[] r104 = {r100, r101, r102, r103};
            f279033a = r104;
            f279034b = EnumEntriesKt.enumEntries(r104);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(PostType.class), Syntax.PROTO_2, r100);
        }

        public static PostType[] values() {
            return (PostType[]) f279033a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final PostType fromValue(int r100) {
            Companion.getClass();
            if (r100 == 0) goto L15;
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L17;
            return null;
        L17:
            return WHITE_LIST;
        L18:
            return ONLY_ADMIN;
        L19:
            return ANYONE;
        L15:
            return UNKNOWN_POST_TYPE;
        }

        public static PostType valueOf(String r100) {
            return (PostType) r27.a.a(PostType.class, r100);
        }

        public PostType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\"#$%B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020!H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006&"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting$Builder;Lokio/ByteString;)V", "switch", "", "getSwitch", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "copy", "Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting$Participant;", "getCopy", "()Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting$Participant;", "forward", "getForward", "download", "getDownload", IHostShare.ShareType.SCREENSHOT, "getScreenshot", "on_time_del_msg_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting$OnTimeDelMsgSetting;", "getOn_time_del_msg_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting$OnTimeDelMsgSetting;", "white_list_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$WhiteListSetting;", "getWhite_list_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$WhiteListSetting;", "newBuilder", "toString", "", "Builder", "Companion", "Participant", "OnTimeDelMsgSetting", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RestrictedModeSetting extends com.lark.wire.Message<RestrictedModeSetting, a> {
        public static final ProtoAdapter<RestrictedModeSetting> ADAPTER = null;
        public static final c Companion = null;
        public static final Participant DEFAULT_COPY = null;
        public static final Participant DEFAULT_DOWNLOAD = null;
        public static final Participant DEFAULT_FORWARD = null;
        public static final Participant DEFAULT_SCREENSHOT = null;
        public static final boolean DEFAULT_SWITCH = false;
        private static final long serialVersionUID = 0;
        private final Participant copy;
        private final Participant download;
        private final Participant forward;
        private final OnTimeDelMsgSetting on_time_del_msg_setting;
        private final Participant screenshot;

        /* JADX INFO: renamed from: switch, reason: not valid java name */
        private final Boolean f105switch;
        private final WhiteListSetting white_list_setting;

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting$OnTimeDelMsgSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting$OnTimeDelMsgSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting$OnTimeDelMsgSetting$Builder;Lokio/ByteString;)V", "status", "", "getStatus", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "alive_time", "", "getAlive_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class OnTimeDelMsgSetting extends com.lark.wire.Message<OnTimeDelMsgSetting, a> {
            public static final ProtoAdapter<OnTimeDelMsgSetting> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final Long alive_time;
            private final Boolean status;

            public static final class a extends com.lark.wire.Message.a<OnTimeDelMsgSetting, a> {

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public Boolean f279035d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                public Long f279036e;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new OnTimeDelMsgSetting(this, c(), null);
                }

                public a() {
                }
            }

            public static final class b extends ProtoAdapter<OnTimeDelMsgSetting> {
                @Override // com.lark.wire.ProtoAdapter
                public final OnTimeDelMsgSetting c(g0 r100) {
                    Intrinsics.checkNotNullParameter(r100, "reader");
                    a r101 = new a();
                    long r102 = r100.c();
                L3:
                    int r103 = r100.e();
                    if (r103 == (-1)) goto L13;
                    if (r103 != 1) goto L8;
                    r101.f279035d = (Boolean) ProtoAdapter.f282718g.c(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L9;
                    r101.f279036e = (Long) ProtoAdapter.f282722k.c(r100);
                    goto L3
                L9:
                    r100.j(r103);
                    Unit r104 = Unit.INSTANCE;
                    goto L3
                L13:
                    return new OnTimeDelMsgSetting(r101, r100.d(r102), null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(OnTimeDelMsgSetting r100) {
                    OnTimeDelMsgSetting r101 = r100;
                    Intrinsics.checkNotNullParameter(r101, "value");
                    return (r101.unknownFields().size() + ProtoAdapter.f282718g.l(1, r101.getStatus())) + ProtoAdapter.f282722k.l(2, r101.getAlive_time());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r100, OnTimeDelMsgSetting r101) {
                    OnTimeDelMsgSetting r102 = r101;
                    Intrinsics.checkNotNullParameter(r100, "writer");
                    Intrinsics.checkNotNullParameter(r102, "value");
                    ProtoAdapter.f282718g.i(r100, 1, r102.getStatus());
                    ProtoAdapter.f282722k.i(r100, 2, r102.getAlive_time());
                    r100.a(r102.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r100, OnTimeDelMsgSetting r101) {
                    OnTimeDelMsgSetting r102 = r101;
                    Intrinsics.checkNotNullParameter(r100, "writer");
                    Intrinsics.checkNotNullParameter(r102, "value");
                    r100.d(r102.unknownFields());
                    ProtoAdapter.f282722k.j(r100, 2, r102.getAlive_time());
                    ProtoAdapter.f282718g.j(r100, 1, r102.getStatus());
                }

                public b(FieldEncoding r100, KClass<OnTimeDelMsgSetting> r101, Syntax r102) {
                    super(r100, r101, "type.googleapis.com/basic.v1.Chat.RestrictedModeSetting.OnTimeDelMsgSetting", r102, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ OnTimeDelMsgSetting(a r100, ByteString r101, DefaultConstructorMarker r102) {
                this(r100, r101);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(OnTimeDelMsgSetting.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r100 = new a();
                r100.f279035d = this.status;
                r100.f279036e = this.alive_time;
                r100.a(unknownFields());
                return r100;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(OnTimeDelMsgSetting.class).getSimpleName() + '@' + hashCode();
            }

            public final Long getAlive_time() {
                return this.alive_time;
            }

            public final Boolean getStatus() {
                return this.status;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public OnTimeDelMsgSetting(a r100, ByteString r101) {
                super(ADAPTER, r101);
                this.status = r100.f279035d;
                this.alive_time = r100.f279036e;
            }

            public /* synthetic */ OnTimeDelMsgSetting(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
                if ((r102 & 2) == 0) goto L5;
                r101 = ByteString.EMPTY;
            L5:
                this(r100, r101);
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting$Participant;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "NO_MEMBER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Participant extends Enum<Participant> implements o0 {
            public static final ProtoAdapter<Participant> ADAPTER = null;
            public static final Participant ALL_MEMBERS = null;
            public static final b Companion = null;
            public static final Participant NO_MEMBER = null;
            public static final Participant UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Participant[] f279037a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f279038b = null;
            private final int value;

            public static final class a extends d<Participant> {
                @Override // com.lark.wire.d
                public final o0 n(int r100) {
                    Participant.Companion.getClass();
                    if (r100 == 0) goto L12;
                    if (r100 == 1) goto L15;
                    if (r100 == 2) goto L14;
                    return null;
                L14:
                    return Participant.NO_MEMBER;
                L15:
                    return Participant.ALL_MEMBERS;
                L12:
                    return Participant.UNKNOWN;
                }

                public a(KClass<Participant> r100, Syntax r101, Participant r102) {
                    super(r100, r101, r102);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Participant> getEntries() {
                return f279038b;
            }

            static {
                Participant r100 = new Participant("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Participant r101 = new Participant("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Participant r102 = new Participant("NO_MEMBER", 2, 2);
                NO_MEMBER = r102;
                Participant[] r103 = {r100, r101, r102};
                f279037a = r103;
                f279038b = EnumEntriesKt.enumEntries(r103);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Participant.class), Syntax.PROTO_2, r100);
            }

            public static Participant[] values() {
                return (Participant[]) f279037a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Participant fromValue(int r100) {
                Companion.getClass();
                if (r100 == 0) goto L12;
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L14;
                return null;
            L14:
                return NO_MEMBER;
            L15:
                return ALL_MEMBERS;
            L12:
                return UNKNOWN;
            }

            public static Participant valueOf(String r100) {
                return (Participant) r27.a.a(Participant.class, r100);
            }

            public Participant(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class a extends com.lark.wire.Message.a<RestrictedModeSetting, a> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Boolean f279039d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Participant f279040e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public Participant f279041f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public Participant f279042g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public Participant f279043h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public OnTimeDelMsgSetting f279044i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public WhiteListSetting f279045j;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new RestrictedModeSetting(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<RestrictedModeSetting> {
            @Override // com.lark.wire.ProtoAdapter
            public final RestrictedModeSetting c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                long r102 = r100.c();
            L3:
                int r103 = r100.e();
                if (r103 == (-1)) goto L27;
                switch(r103) {
                    case 1: goto L25;
                    case 2: goto L34;
                    case 3: goto L28;
                    case 4: goto L30;
                    case 5: goto L32;
                    case 6: goto L8;
                    case 7: goto L7;
                    default: goto L6;
                };
            L28:
                r101.f279041f = Participant.ADAPTER.c(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r100.a(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r104 = Unit.INSTANCE;
                goto L3
            L30:
                r101.f279042g = Participant.ADAPTER.c(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r100.a(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r105 = Unit.INSTANCE;
                goto L3
            L32:
                r101.f279043h = Participant.ADAPTER.c(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
            L11:
                e = move-exception;
                r100.a(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r106 = Unit.INSTANCE;
                goto L3
            L34:
                r101.f279040e = Participant.ADAPTER.c(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
            L23:
                e = move-exception;
                r100.a(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r107 = Unit.INSTANCE;
                goto L3
            L7:
                r101.f279045j = WhiteListSetting.ADAPTER.c(r100);
                goto L3
            L8:
                r101.f279044i = OnTimeDelMsgSetting.ADAPTER.c(r100);
                goto L3
            L25:
                r101.f279039d = (Boolean) ProtoAdapter.f282718g.c(r100);
                goto L3
            L6:
                r100.j(r103);
                goto L3
            L27:
                return new RestrictedModeSetting(r101, r100.d(r102), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(RestrictedModeSetting r100) {
                RestrictedModeSetting r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                int r102 = r101.unknownFields().size() + ProtoAdapter.f282718g.l(1, r101.getSwitch());
                ProtoAdapter<Participant> r103 = Participant.ADAPTER;
                return (((((r102 + r103.l(2, r101.getCopy())) + r103.l(3, r101.getForward())) + r103.l(4, r101.getDownload())) + r103.l(5, r101.getScreenshot())) + OnTimeDelMsgSetting.ADAPTER.l(6, r101.getOn_time_del_msg_setting())) + WhiteListSetting.ADAPTER.l(7, r101.getWhite_list_setting());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, RestrictedModeSetting r101) {
                RestrictedModeSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                ProtoAdapter.f282718g.i(r100, 1, r102.getSwitch());
                ProtoAdapter<Participant> r103 = Participant.ADAPTER;
                r103.i(r100, 2, r102.getCopy());
                r103.i(r100, 3, r102.getForward());
                r103.i(r100, 4, r102.getDownload());
                r103.i(r100, 5, r102.getScreenshot());
                OnTimeDelMsgSetting.ADAPTER.i(r100, 6, r102.getOn_time_del_msg_setting());
                WhiteListSetting.ADAPTER.i(r100, 7, r102.getWhite_list_setting());
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, RestrictedModeSetting r101) {
                RestrictedModeSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
                WhiteListSetting.ADAPTER.j(r100, 7, r102.getWhite_list_setting());
                OnTimeDelMsgSetting.ADAPTER.j(r100, 6, r102.getOn_time_del_msg_setting());
                ProtoAdapter<Participant> r103 = Participant.ADAPTER;
                r103.j(r100, 5, r102.getScreenshot());
                r103.j(r100, 4, r102.getDownload());
                r103.j(r100, 3, r102.getForward());
                r103.j(r100, 2, r102.getCopy());
                ProtoAdapter.f282718g.j(r100, 1, r102.getSwitch());
            }

            public b(FieldEncoding r100, KClass<RestrictedModeSetting> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chat.RestrictedModeSetting", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ RestrictedModeSetting(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r100, r101);
        }

        static {
            Companion = new c();
            Participant r100 = Participant.NO_MEMBER;
            DEFAULT_COPY = r100;
            DEFAULT_FORWARD = r100;
            DEFAULT_DOWNLOAD = r100;
            DEFAULT_SCREENSHOT = r100;
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(RestrictedModeSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.f279039d = this.f105switch;
            r100.f279040e = this.copy;
            r100.f279041f = this.forward;
            r100.f279042g = this.download;
            r100.f279043h = this.screenshot;
            r100.f279044i = this.on_time_del_msg_setting;
            r100.f279045j = this.white_list_setting;
            r100.a(unknownFields());
            return r100;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(RestrictedModeSetting.class).getSimpleName() + '@' + hashCode();
        }

        public final Participant getCopy() {
            return this.copy;
        }

        public final Participant getDownload() {
            return this.download;
        }

        public final Participant getForward() {
            return this.forward;
        }

        public final OnTimeDelMsgSetting getOn_time_del_msg_setting() {
            return this.on_time_del_msg_setting;
        }

        public final Participant getScreenshot() {
            return this.screenshot;
        }

        public final Boolean getSwitch() {
            return this.f105switch;
        }

        public final WhiteListSetting getWhite_list_setting() {
            return this.white_list_setting;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public RestrictedModeSetting(a r100, ByteString r101) {
            super(ADAPTER, r101);
            this.f105switch = r100.f279039d;
            this.copy = r100.f279040e;
            this.forward = r100.f279041f;
            this.download = r100.f279042g;
            this.screenshot = r100.f279043h;
            this.on_time_del_msg_setting = r100.f279044i;
            this.white_list_setting = r100.f279045j;
        }

        public /* synthetic */ RestrictedModeSetting(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$Role;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "IGNORE", "MEMBER", "VISITOR", "THREAD_FOLLOWER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Role extends Enum<Role> implements o0 {
        public static final ProtoAdapter<Role> ADAPTER = null;
        public static final b Companion = null;
        public static final Role IGNORE = null;
        public static final Role MEMBER = null;
        public static final Role THREAD_FOLLOWER = null;
        public static final Role VISITOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Role[] f279046a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f279047b = null;
        private final int value;

        public static final class a extends d<Role> {
            @Override // com.lark.wire.d
            public final o0 n(int r100) {
                Role.Companion.getClass();
                if (r100 == 0) goto L15;
                if (r100 == 1) goto L19;
                if (r100 == 2) goto L18;
                if (r100 == 3) goto L17;
                return null;
            L17:
                return Role.THREAD_FOLLOWER;
            L18:
                return Role.VISITOR;
            L19:
                return Role.MEMBER;
            L15:
                return Role.IGNORE;
            }

            public a(KClass<Role> r100, Syntax r101, Role r102) {
                super(r100, r101, r102);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Role> getEntries() {
            return f279047b;
        }

        static {
            Role r100 = new Role("IGNORE", 0, 0);
            IGNORE = r100;
            Role r101 = new Role("MEMBER", 1, 1);
            MEMBER = r101;
            Role r102 = new Role("VISITOR", 2, 2);
            VISITOR = r102;
            Role r103 = new Role("THREAD_FOLLOWER", 3, 3);
            THREAD_FOLLOWER = r103;
            Role[] r104 = {r100, r101, r102, r103};
            f279046a = r104;
            f279047b = EnumEntriesKt.enumEntries(r104);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Role.class), Syntax.PROTO_2, r100);
        }

        public static Role[] values() {
            return (Role[]) f279046a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Role fromValue(int r100) {
            Companion.getClass();
            if (r100 == 0) goto L15;
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L17;
            return null;
        L17:
            return THREAD_FOLLOWER;
        L18:
            return VISITOR;
        L19:
            return MEMBER;
        L15:
            return IGNORE;
        }

        public static Role valueOf(String r100) {
            return (Role) r27.a.a(Role.class, r100);
        }

        public Role(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$ShareCardPermission;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$ShareCardPermission$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$ShareCardPermission$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ShareCardPermission extends com.lark.wire.Message<ShareCardPermission, a> {
        public static final ProtoAdapter<ShareCardPermission> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$ShareCardPermission$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALLOWED", "NOT_ALLOWED", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALLOWED = null;
            public static final b Companion = null;
            public static final Enum NOT_ALLOWED = null;
            public static final Enum UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Enum[] f279048a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f279049b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r100) {
                    Enum.Companion.getClass();
                    if (r100 == 0) goto L12;
                    if (r100 == 1) goto L15;
                    if (r100 == 2) goto L14;
                    return null;
                L14:
                    return Enum.NOT_ALLOWED;
                L15:
                    return Enum.ALLOWED;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r100, Syntax r101, Enum r102) {
                    super(r100, r101, r102);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return f279049b;
            }

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALLOWED", 1, 1);
                ALLOWED = r101;
                Enum r102 = new Enum("NOT_ALLOWED", 2, 2);
                NOT_ALLOWED = r102;
                Enum[] r103 = {r100, r101, r102};
                f279048a = r103;
                f279049b = EnumEntriesKt.enumEntries(r103);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r100);
            }

            public static Enum[] values() {
                return (Enum[]) f279048a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r100) {
                Companion.getClass();
                if (r100 == 0) goto L12;
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L14;
                return null;
            L14:
                return NOT_ALLOWED;
            L15:
                return ALLOWED;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) r27.a.a(Enum.class, r100);
            }

            public Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class a extends com.lark.wire.Message.a<ShareCardPermission, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ShareCardPermission(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ShareCardPermission> {
            @Override // com.lark.wire.ProtoAdapter
            public final ShareCardPermission c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                long r102 = r100.c();
            L3:
                int r103 = r100.e();
                if (r103 == (-1)) goto L7;
                r100.j(r103);
                goto L3
            L7:
                return new ShareCardPermission(r101, r100.d(r102), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ShareCardPermission r100) {
                ShareCardPermission r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                return r101.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, ShareCardPermission r101) {
                ShareCardPermission r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, ShareCardPermission r101) {
                ShareCardPermission r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
            }

            public b(FieldEncoding r100, KClass<ShareCardPermission> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chat.ShareCardPermission", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ShareCardPermission(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ShareCardPermission.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.a(unknownFields());
            return r100;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ShareCardPermission.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ShareCardPermission(ByteString r100) {
            super(ADAPTER, r100);
        }

        public /* synthetic */ ShareCardPermission(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r101);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$SystemMessageVisible;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$SystemMessageVisible$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$SystemMessageVisible$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SystemMessageVisible extends com.lark.wire.Message<SystemMessageVisible, a> {
        public static final ProtoAdapter<SystemMessageVisible> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$SystemMessageVisible$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ONLY_OWNER", "ALL_MEMBERS", "NOT_ANYONE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final b Companion = null;
            public static final Enum NOT_ANYONE = null;
            public static final Enum ONLY_OWNER = null;
            public static final Enum UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Enum[] f279050a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f279051b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r100) {
                    Enum.Companion.getClass();
                    if (r100 == 0) goto L15;
                    if (r100 == 1) goto L19;
                    if (r100 == 2) goto L18;
                    if (r100 == 3) goto L17;
                    return null;
                L17:
                    return Enum.NOT_ANYONE;
                L18:
                    return Enum.ALL_MEMBERS;
                L19:
                    return Enum.ONLY_OWNER;
                L15:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r100, Syntax r101, Enum r102) {
                    super(r100, r101, r102);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return f279051b;
            }

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ONLY_OWNER", 1, 1);
                ONLY_OWNER = r101;
                Enum r102 = new Enum("ALL_MEMBERS", 2, 2);
                ALL_MEMBERS = r102;
                Enum r103 = new Enum("NOT_ANYONE", 3, 3);
                NOT_ANYONE = r103;
                Enum[] r104 = {r100, r101, r102, r103};
                f279050a = r104;
                f279051b = EnumEntriesKt.enumEntries(r104);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r100);
            }

            public static Enum[] values() {
                return (Enum[]) f279050a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r100) {
                Companion.getClass();
                if (r100 == 0) goto L15;
                if (r100 == 1) goto L19;
                if (r100 == 2) goto L18;
                if (r100 == 3) goto L17;
                return null;
            L17:
                return NOT_ANYONE;
            L18:
                return ALL_MEMBERS;
            L19:
                return ONLY_OWNER;
            L15:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) r27.a.a(Enum.class, r100);
            }

            public Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class a extends com.lark.wire.Message.a<SystemMessageVisible, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new SystemMessageVisible(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<SystemMessageVisible> {
            @Override // com.lark.wire.ProtoAdapter
            public final SystemMessageVisible c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                long r102 = r100.c();
            L3:
                int r103 = r100.e();
                if (r103 == (-1)) goto L7;
                r100.j(r103);
                goto L3
            L7:
                return new SystemMessageVisible(r101, r100.d(r102), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(SystemMessageVisible r100) {
                SystemMessageVisible r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                return r101.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, SystemMessageVisible r101) {
                SystemMessageVisible r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, SystemMessageVisible r101) {
                SystemMessageVisible r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
            }

            public b(FieldEncoding r100, KClass<SystemMessageVisible> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chat.SystemMessageVisible", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ SystemMessageVisible(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(SystemMessageVisible.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.a(unknownFields());
            return r100;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(SystemMessageVisible.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public SystemMessageVisible(ByteString r100) {
            super(ADAPTER, r100);
        }

        public /* synthetic */ SystemMessageVisible(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r101);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$TnsInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$TnsInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$TnsInfo$Builder;Lokio/ByteString;)V", "op_kind", "Lcom/lark/kmp/pb/basic/v1/TnsOpKind;", "getOp_kind", "()Lcom/lark/kmp/pb/basic/v1/TnsOpKind;", "system_banned_info", "Lcom/lark/kmp/pb/basic/v1/TnsSystemBannedInfo;", "getSystem_banned_info", "()Lcom/lark/kmp/pb/basic/v1/TnsSystemBannedInfo;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TnsInfo extends com.lark.wire.Message<TnsInfo, a> {
        public static final ProtoAdapter<TnsInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final TnsOpKind op_kind;
        private final TnsSystemBannedInfo system_banned_info;

        public static final class a extends com.lark.wire.Message.a<TnsInfo, a> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public TnsOpKind f279052d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public TnsSystemBannedInfo f279053e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new TnsInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<TnsInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final TnsInfo c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                long r102 = r100.c();
            L3:
                int r103 = r100.e();
                if (r103 == (-1)) goto L16;
                if (r103 != 1) goto L8;
                r101.f279052d = TnsOpKind.ADAPTER.c(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r100.a(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r104 = Unit.INSTANCE;
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.f279053e = TnsSystemBannedInfo.ADAPTER.c(r100);
                goto L3
            L9:
                r100.j(r103);
                goto L3
            L16:
                return new TnsInfo(r101, r100.d(r102), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TnsInfo r100) {
                TnsInfo r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                return (r101.unknownFields().size() + TnsOpKind.ADAPTER.l(1, r101.getOp_kind())) + TnsSystemBannedInfo.ADAPTER.l(2, r101.getSystem_banned_info());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, TnsInfo r101) {
                TnsInfo r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                TnsOpKind.ADAPTER.i(r100, 1, r102.getOp_kind());
                TnsSystemBannedInfo.ADAPTER.i(r100, 2, r102.getSystem_banned_info());
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, TnsInfo r101) {
                TnsInfo r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
                TnsSystemBannedInfo.ADAPTER.j(r100, 2, r102.getSystem_banned_info());
                TnsOpKind.ADAPTER.j(r100, 1, r102.getOp_kind());
            }

            public b(FieldEncoding r100, KClass<TnsInfo> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chat.TnsInfo", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ TnsInfo(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r100, r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TnsInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.f279052d = this.op_kind;
            r100.f279053e = this.system_banned_info;
            r100.a(unknownFields());
            return r100;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(TnsInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final TnsOpKind getOp_kind() {
            return this.op_kind;
        }

        public final TnsSystemBannedInfo getSystem_banned_info() {
            return this.system_banned_info;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public TnsInfo(a r100, ByteString r101) {
            super(ADAPTER, r101);
            this.op_kind = r100.f279052d;
            this.system_banned_info = r100.f279053e;
        }

        public /* synthetic */ TnsInfo(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$TopNoticePermissionSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$TopNoticePermissionSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$TopNoticePermissionSetting$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TopNoticePermissionSetting extends com.lark.wire.Message<TopNoticePermissionSetting, a> {
        public static final ProtoAdapter<TopNoticePermissionSetting> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$TopNoticePermissionSetting$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "ONLY_MANAGER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final b Companion = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Enum[] f279054a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f279055b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r100) {
                    Enum.Companion.getClass();
                    if (r100 == 0) goto L12;
                    if (r100 == 1) goto L15;
                    if (r100 == 2) goto L14;
                    return null;
                L14:
                    return Enum.ONLY_MANAGER;
                L15:
                    return Enum.ALL_MEMBERS;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r100, Syntax r101, Enum r102) {
                    super(r100, r101, r102);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return f279055b;
            }

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Enum r102 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r102;
                Enum[] r103 = {r100, r101, r102};
                f279054a = r103;
                f279055b = EnumEntriesKt.enumEntries(r103);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r100);
            }

            public static Enum[] values() {
                return (Enum[]) f279054a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r100) {
                Companion.getClass();
                if (r100 == 0) goto L12;
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L14;
                return null;
            L14:
                return ONLY_MANAGER;
            L15:
                return ALL_MEMBERS;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) r27.a.a(Enum.class, r100);
            }

            public Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class a extends com.lark.wire.Message.a<TopNoticePermissionSetting, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new TopNoticePermissionSetting(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<TopNoticePermissionSetting> {
            @Override // com.lark.wire.ProtoAdapter
            public final TopNoticePermissionSetting c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                long r102 = r100.c();
            L3:
                int r103 = r100.e();
                if (r103 == (-1)) goto L7;
                r100.j(r103);
                goto L3
            L7:
                return new TopNoticePermissionSetting(r101, r100.d(r102), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TopNoticePermissionSetting r100) {
                TopNoticePermissionSetting r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                return r101.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, TopNoticePermissionSetting r101) {
                TopNoticePermissionSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, TopNoticePermissionSetting r101) {
                TopNoticePermissionSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
            }

            public b(FieldEncoding r100, KClass<TopNoticePermissionSetting> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chat.TopNoticePermissionSetting", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ TopNoticePermissionSetting(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TopNoticePermissionSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.a(unknownFields());
            return r100;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(TopNoticePermissionSetting.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public TopNoticePermissionSetting(ByteString r100) {
            super(ADAPTER, r100);
        }

        public /* synthetic */ TopNoticePermissionSetting(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "P2P", "GROUP", "TOPIC_GROUP", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final b Companion = null;
        public static final Type GROUP = null;
        public static final Type P2P = null;
        public static final Type TOPIC_GROUP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f279056a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f279057b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r100) {
                Type.Companion.getClass();
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L15;
                if (r100 == 3) goto L14;
                return null;
            L14:
                return Type.TOPIC_GROUP;
            L15:
                return Type.GROUP;
            L12:
                return Type.P2P;
            }

            public a(KClass<Type> r100, Syntax r101) {
                super(r100, r101, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Type> getEntries() {
            return f279057b;
        }

        static {
            Type r100 = new Type("P2P", 0, 1);
            P2P = r100;
            Type r101 = new Type("GROUP", 1, 2);
            GROUP = r101;
            Type r102 = new Type("TOPIC_GROUP", 2, 3);
            TOPIC_GROUP = r102;
            Type[] r103 = {r100, r101, r102};
            f279056a = r103;
            f279057b = EnumEntriesKt.enumEntries(r103);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2);
        }

        public static Type[] values() {
            return (Type[]) f279056a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Type fromValue(int r100) {
            Companion.getClass();
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L15;
            if (r100 == 3) goto L14;
            return null;
        L14:
            return TOPIC_GROUP;
        L15:
            return GROUP;
        L12:
            return P2P;
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004#$%&B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010!\u001a\u00020\u0002H\u0016J\b\u0010\"\u001a\u00020\rH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\b\u0010\nR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0011\u0010\nR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u001c\u0010\nR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006'"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$TypingTranslateSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$TypingTranslateSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$TypingTranslateSetting$Builder;Lokio/ByteString;)V", "is_open", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "target_language", "", "getTarget_language", "()Ljava/lang/String;", "enable_use_translated_original", "getEnable_use_translated_original", "update_time_ns", "", "getUpdate_time_ns", "()Ljava/lang/Long;", "Ljava/lang/Long;", "open_mode", "Lcom/lark/kmp/pb/basic/v1/Chat$TypingTranslateSetting$OpenMode;", "getOpen_mode", "()Lcom/lark/kmp/pb/basic/v1/Chat$TypingTranslateSetting$OpenMode;", "can_auto_open_v3", "getCan_auto_open_v3", "close_mode", "Lcom/lark/kmp/pb/basic/v1/Chat$TypingTranslateSetting$AutoOpenCloseMode;", "getClose_mode", "()Lcom/lark/kmp/pb/basic/v1/Chat$TypingTranslateSetting$AutoOpenCloseMode;", "newBuilder", "toString", "Builder", "Companion", "OpenMode", "AutoOpenCloseMode", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TypingTranslateSetting extends com.lark.wire.Message<TypingTranslateSetting, a> {
        public static final ProtoAdapter<TypingTranslateSetting> ADAPTER = null;
        public static final c Companion = null;
        public static final boolean DEFAULT_IS_OPEN = false;
        private static final long serialVersionUID = 0;
        private final Boolean can_auto_open_v3;
        private final AutoOpenCloseMode close_mode;
        private final Boolean enable_use_translated_original;
        private final Boolean is_open;
        private final OpenMode open_mode;
        private final String target_language;
        private final Long update_time_ns;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$TypingTranslateSetting$AutoOpenCloseMode;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CLOSE_UNKNOWN", "CLOSE_DIRECTLY", "CLOSE_POPUP", "CLOSE_NO_LONGER_OPEN", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum AutoOpenCloseMode extends Enum<AutoOpenCloseMode> implements o0 {
            public static final ProtoAdapter<AutoOpenCloseMode> ADAPTER = null;
            public static final AutoOpenCloseMode CLOSE_DIRECTLY = null;
            public static final AutoOpenCloseMode CLOSE_NO_LONGER_OPEN = null;
            public static final AutoOpenCloseMode CLOSE_POPUP = null;
            public static final AutoOpenCloseMode CLOSE_UNKNOWN = null;
            public static final b Companion = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ AutoOpenCloseMode[] f279058a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f279059b = null;
            private final int value;

            public static final class a extends d<AutoOpenCloseMode> {
                @Override // com.lark.wire.d
                public final o0 n(int r100) {
                    AutoOpenCloseMode.Companion.getClass();
                    if (r100 == 0) goto L15;
                    if (r100 == 1) goto L19;
                    if (r100 == 2) goto L18;
                    if (r100 == 3) goto L17;
                    return null;
                L17:
                    return AutoOpenCloseMode.CLOSE_NO_LONGER_OPEN;
                L18:
                    return AutoOpenCloseMode.CLOSE_POPUP;
                L19:
                    return AutoOpenCloseMode.CLOSE_DIRECTLY;
                L15:
                    return AutoOpenCloseMode.CLOSE_UNKNOWN;
                }

                public a(KClass<AutoOpenCloseMode> r100, Syntax r101, AutoOpenCloseMode r102) {
                    super(r100, r101, r102);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<AutoOpenCloseMode> getEntries() {
                return f279059b;
            }

            static {
                AutoOpenCloseMode r100 = new AutoOpenCloseMode("CLOSE_UNKNOWN", 0, 0);
                CLOSE_UNKNOWN = r100;
                AutoOpenCloseMode r101 = new AutoOpenCloseMode("CLOSE_DIRECTLY", 1, 1);
                CLOSE_DIRECTLY = r101;
                AutoOpenCloseMode r102 = new AutoOpenCloseMode("CLOSE_POPUP", 2, 2);
                CLOSE_POPUP = r102;
                AutoOpenCloseMode r103 = new AutoOpenCloseMode("CLOSE_NO_LONGER_OPEN", 3, 3);
                CLOSE_NO_LONGER_OPEN = r103;
                AutoOpenCloseMode[] r104 = {r100, r101, r102, r103};
                f279058a = r104;
                f279059b = EnumEntriesKt.enumEntries(r104);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(AutoOpenCloseMode.class), Syntax.PROTO_2, r100);
            }

            public static AutoOpenCloseMode[] values() {
                return (AutoOpenCloseMode[]) f279058a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final AutoOpenCloseMode fromValue(int r100) {
                Companion.getClass();
                if (r100 == 0) goto L15;
                if (r100 == 1) goto L19;
                if (r100 == 2) goto L18;
                if (r100 == 3) goto L17;
                return null;
            L17:
                return CLOSE_NO_LONGER_OPEN;
            L18:
                return CLOSE_POPUP;
            L19:
                return CLOSE_DIRECTLY;
            L15:
                return CLOSE_UNKNOWN;
            }

            public static AutoOpenCloseMode valueOf(String r100) {
                return (AutoOpenCloseMode) r27.a.a(AutoOpenCloseMode.class, r100);
            }

            public AutoOpenCloseMode(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$TypingTranslateSetting$OpenMode;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "MANUAL", "AUTO", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum OpenMode extends Enum<OpenMode> implements o0 {
            public static final ProtoAdapter<OpenMode> ADAPTER = null;
            public static final OpenMode AUTO = null;
            public static final b Companion = null;
            public static final OpenMode MANUAL = null;
            public static final OpenMode UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ OpenMode[] f279060a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f279061b = null;
            private final int value;

            public static final class a extends d<OpenMode> {
                @Override // com.lark.wire.d
                public final o0 n(int r100) {
                    OpenMode.Companion.getClass();
                    if (r100 == 0) goto L12;
                    if (r100 == 1) goto L15;
                    if (r100 == 2) goto L14;
                    return null;
                L14:
                    return OpenMode.AUTO;
                L15:
                    return OpenMode.MANUAL;
                L12:
                    return OpenMode.UNKNOWN;
                }

                public a(KClass<OpenMode> r100, Syntax r101, OpenMode r102) {
                    super(r100, r101, r102);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<OpenMode> getEntries() {
                return f279061b;
            }

            static {
                OpenMode r100 = new OpenMode("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                OpenMode r101 = new OpenMode("MANUAL", 1, 1);
                MANUAL = r101;
                OpenMode r102 = new OpenMode("AUTO", 2, 2);
                AUTO = r102;
                OpenMode[] r103 = {r100, r101, r102};
                f279060a = r103;
                f279061b = EnumEntriesKt.enumEntries(r103);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(OpenMode.class), Syntax.PROTO_2, r100);
            }

            public static OpenMode[] values() {
                return (OpenMode[]) f279060a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final OpenMode fromValue(int r100) {
                Companion.getClass();
                if (r100 == 0) goto L12;
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L14;
                return null;
            L14:
                return AUTO;
            L15:
                return MANUAL;
            L12:
                return UNKNOWN;
            }

            public static OpenMode valueOf(String r100) {
                return (OpenMode) r27.a.a(OpenMode.class, r100);
            }

            public OpenMode(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class a extends com.lark.wire.Message.a<TypingTranslateSetting, a> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Boolean f279062d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f279063e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public Boolean f279064f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public Long f279065g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public OpenMode f279066h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public Boolean f279067i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public AutoOpenCloseMode f279068j;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new TypingTranslateSetting(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<TypingTranslateSetting> {
            @Override // com.lark.wire.ProtoAdapter
            public final TypingTranslateSetting c(g0 r110) {
                Intrinsics.checkNotNullParameter(r110, "reader");
                a r100 = new a();
                long r101 = r110.c();
            L3:
                int r102 = r110.e();
                if (r102 == (-1)) goto L21;
                switch(r102) {
                    case 1: goto L19;
                    case 2: goto L18;
                    case 3: goto L17;
                    case 4: goto L16;
                    case 5: goto L24;
                    case 6: goto L11;
                    case 7: goto L6;
                    case 8: goto L22;
                    default: goto L6;
                };
            L22:
                r100.f279068j = AutoOpenCloseMode.ADAPTER.c(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r110.a(r102, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r103 = Unit.INSTANCE;
                goto L3
            L24:
                r100.f279066h = OpenMode.ADAPTER.c(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r110.a(r102, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r104 = Unit.INSTANCE;
                goto L3
            L11:
                r100.f279067i = (Boolean) ProtoAdapter.f282718g.c(r110);
                goto L3
            L16:
                r100.f279065g = (Long) ProtoAdapter.f282722k.c(r110);
                goto L3
            L17:
                r100.f279064f = (Boolean) ProtoAdapter.f282718g.c(r110);
                goto L3
            L18:
                ProtoAdapter.f282728q.getClass();
                Intrinsics.checkNotNullParameter(r110, "reader");
                r100.f279063e = r110.i();
                goto L3
            L19:
                r100.f279062d = (Boolean) ProtoAdapter.f282718g.c(r110);
                goto L3
            L6:
                r110.j(r102);
                Unit r105 = Unit.INSTANCE;
                goto L3
            L21:
                return new TypingTranslateSetting(r100, r110.d(r101), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TypingTranslateSetting r100) {
                TypingTranslateSetting r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                int r102 = r101.unknownFields().size();
                l r103 = ProtoAdapter.f282718g;
                return ((((((r102 + r103.l(1, r101.is_open())) + ProtoAdapter.f282728q.l(2, r101.getTarget_language())) + r103.l(3, r101.getEnable_use_translated_original())) + ProtoAdapter.f282722k.l(4, r101.getUpdate_time_ns())) + OpenMode.ADAPTER.l(5, r101.getOpen_mode())) + r103.l(6, r101.getCan_auto_open_v3())) + AutoOpenCloseMode.ADAPTER.l(8, r101.getClose_mode());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, TypingTranslateSetting r101) {
                TypingTranslateSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                l r103 = ProtoAdapter.f282718g;
                r103.i(r100, 1, r102.is_open());
                ProtoAdapter.f282728q.i(r100, 2, r102.getTarget_language());
                r103.i(r100, 3, r102.getEnable_use_translated_original());
                ProtoAdapter.f282722k.i(r100, 4, r102.getUpdate_time_ns());
                OpenMode.ADAPTER.i(r100, 5, r102.getOpen_mode());
                r103.i(r100, 6, r102.getCan_auto_open_v3());
                AutoOpenCloseMode.ADAPTER.i(r100, 8, r102.getClose_mode());
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, TypingTranslateSetting r101) {
                TypingTranslateSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
                AutoOpenCloseMode.ADAPTER.j(r100, 8, r102.getClose_mode());
                l r103 = ProtoAdapter.f282718g;
                r103.j(r100, 6, r102.getCan_auto_open_v3());
                OpenMode.ADAPTER.j(r100, 5, r102.getOpen_mode());
                ProtoAdapter.f282722k.j(r100, 4, r102.getUpdate_time_ns());
                r103.j(r100, 3, r102.getEnable_use_translated_original());
                ProtoAdapter.f282728q.j(r100, 2, r102.getTarget_language());
                r103.j(r100, 1, r102.is_open());
            }

            public b(FieldEncoding r100, KClass<TypingTranslateSetting> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chat.TypingTranslateSetting", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ TypingTranslateSetting(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r100, r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TypingTranslateSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.f279062d = this.is_open;
            r100.f279063e = this.target_language;
            r100.f279064f = this.enable_use_translated_original;
            r100.f279065g = this.update_time_ns;
            r100.f279066h = this.open_mode;
            r100.f279067i = this.can_auto_open_v3;
            r100.f279068j = this.close_mode;
            r100.a(unknownFields());
            return r100;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(TypingTranslateSetting.class).getSimpleName() + '@' + hashCode();
        }

        public final Boolean getCan_auto_open_v3() {
            return this.can_auto_open_v3;
        }

        public final AutoOpenCloseMode getClose_mode() {
            return this.close_mode;
        }

        public final Boolean getEnable_use_translated_original() {
            return this.enable_use_translated_original;
        }

        public final OpenMode getOpen_mode() {
            return this.open_mode;
        }

        public final String getTarget_language() {
            return this.target_language;
        }

        public final Long getUpdate_time_ns() {
            return this.update_time_ns;
        }

        public final Boolean is_open() {
            return this.is_open;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public TypingTranslateSetting(a r100, ByteString r101) {
            super(ADAPTER, r101);
            this.is_open = r100.f279062d;
            this.target_language = r100.f279063e;
            this.enable_use_translated_original = r100.f279064f;
            this.update_time_ns = r100.f279065g;
            this.open_mode = r100.f279066h;
            this.can_auto_open_v3 = r100.f279067i;
            this.close_mode = r100.f279068j;
        }

        public /* synthetic */ TypingTranslateSetting(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$UserCountVisibleSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$UserCountVisibleSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$UserCountVisibleSetting$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UserCountVisibleSetting extends com.lark.wire.Message<UserCountVisibleSetting, a> {
        public static final ProtoAdapter<UserCountVisibleSetting> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$UserCountVisibleSetting$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "ONLY_MANAGER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final b Companion = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Enum[] f279069a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f279070b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r100) {
                    Enum.Companion.getClass();
                    if (r100 == 0) goto L12;
                    if (r100 == 1) goto L15;
                    if (r100 == 2) goto L14;
                    return null;
                L14:
                    return Enum.ONLY_MANAGER;
                L15:
                    return Enum.ALL_MEMBERS;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r100, Syntax r101, Enum r102) {
                    super(r100, r101, r102);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return f279070b;
            }

            static {
                Enum r100 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Enum r101 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Enum r102 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r102;
                Enum[] r103 = {r100, r101, r102};
                f279069a = r103;
                f279070b = EnumEntriesKt.enumEntries(r103);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r100);
            }

            public static Enum[] values() {
                return (Enum[]) f279069a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r100) {
                Companion.getClass();
                if (r100 == 0) goto L12;
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L14;
                return null;
            L14:
                return ONLY_MANAGER;
            L15:
                return ALL_MEMBERS;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r100) {
                return (Enum) r27.a.a(Enum.class, r100);
            }

            public Enum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class a extends com.lark.wire.Message.a<UserCountVisibleSetting, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new UserCountVisibleSetting(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<UserCountVisibleSetting> {
            @Override // com.lark.wire.ProtoAdapter
            public final UserCountVisibleSetting c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                long r102 = r100.c();
            L3:
                int r103 = r100.e();
                if (r103 == (-1)) goto L7;
                r100.j(r103);
                goto L3
            L7:
                return new UserCountVisibleSetting(r101, r100.d(r102), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(UserCountVisibleSetting r100) {
                UserCountVisibleSetting r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                return r101.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, UserCountVisibleSetting r101) {
                UserCountVisibleSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, UserCountVisibleSetting r101) {
                UserCountVisibleSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
            }

            public b(FieldEncoding r100, KClass<UserCountVisibleSetting> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chat.UserCountVisibleSetting", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ UserCountVisibleSetting(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(UserCountVisibleSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.a(unknownFields());
            return r100;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(UserCountVisibleSetting.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public UserCountVisibleSetting(ByteString r100) {
            super(ADAPTER, r100);
        }

        public /* synthetic */ UserCountVisibleSetting(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r101);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001d\u001e\u001fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006 "}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$WhiteListSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$WhiteListSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$WhiteListSetting$Builder;Lokio/ByteString;)V", "level", "Lcom/lark/kmp/pb/basic/v1/Chat$WhiteListSetting$LevelEnum;", "getLevel", "()Lcom/lark/kmp/pb/basic/v1/Chat$WhiteListSetting$LevelEnum;", "add_user_ids", "", "", "getAdd_user_ids", "()Ljava/util/List;", "del_user_ids", "getDel_user_ids", "member_list_user_ids", "getMember_list_user_ids", "hit_whitelist", "", "getHit_whitelist", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "", "Builder", "Companion", "LevelEnum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WhiteListSetting extends com.lark.wire.Message<WhiteListSetting, a> {
        public static final ProtoAdapter<WhiteListSetting> ADAPTER = null;
        public static final c Companion = null;
        public static final boolean DEFAULT_HIT_WHITELIST = false;
        public static final LevelEnum DEFAULT_LEVEL = null;
        private static final long serialVersionUID = 0;
        private final List<Long> add_user_ids;
        private final List<Long> del_user_ids;
        private final Boolean hit_whitelist;
        private final LevelEnum level;
        private final List<Long> member_list_user_ids;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$WhiteListSetting$LevelEnum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "NO_MEMBER", "ONLY_ADMIN_AND_OWNER", "MEMBER_LIST", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum LevelEnum extends Enum<LevelEnum> implements o0 {
            public static final ProtoAdapter<LevelEnum> ADAPTER = null;
            public static final b Companion = null;
            public static final LevelEnum MEMBER_LIST = null;
            public static final LevelEnum NO_MEMBER = null;
            public static final LevelEnum ONLY_ADMIN_AND_OWNER = null;
            public static final LevelEnum UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ LevelEnum[] f279071a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f279072b = null;
            private final int value;

            public static final class a extends d<LevelEnum> {
                @Override // com.lark.wire.d
                public final o0 n(int r100) {
                    LevelEnum.Companion.getClass();
                    if (r100 == 0) goto L15;
                    if (r100 == 1) goto L19;
                    if (r100 == 2) goto L18;
                    if (r100 == 3) goto L17;
                    return null;
                L17:
                    return LevelEnum.MEMBER_LIST;
                L18:
                    return LevelEnum.ONLY_ADMIN_AND_OWNER;
                L19:
                    return LevelEnum.NO_MEMBER;
                L15:
                    return LevelEnum.UNKNOWN;
                }

                public a(KClass<LevelEnum> r100, Syntax r101, LevelEnum r102) {
                    super(r100, r101, r102);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<LevelEnum> getEntries() {
                return f279072b;
            }

            static {
                LevelEnum r100 = new LevelEnum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                LevelEnum r101 = new LevelEnum("NO_MEMBER", 1, 1);
                NO_MEMBER = r101;
                LevelEnum r102 = new LevelEnum("ONLY_ADMIN_AND_OWNER", 2, 2);
                ONLY_ADMIN_AND_OWNER = r102;
                LevelEnum r103 = new LevelEnum("MEMBER_LIST", 3, 3);
                MEMBER_LIST = r103;
                LevelEnum[] r104 = {r100, r101, r102, r103};
                f279071a = r104;
                f279072b = EnumEntriesKt.enumEntries(r104);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(LevelEnum.class), Syntax.PROTO_2, r100);
            }

            public static LevelEnum[] values() {
                return (LevelEnum[]) f279071a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final LevelEnum fromValue(int r100) {
                Companion.getClass();
                if (r100 == 0) goto L15;
                if (r100 == 1) goto L19;
                if (r100 == 2) goto L18;
                if (r100 == 3) goto L17;
                return null;
            L17:
                return MEMBER_LIST;
            L18:
                return ONLY_ADMIN_AND_OWNER;
            L19:
                return NO_MEMBER;
            L15:
                return UNKNOWN;
            }

            public static LevelEnum valueOf(String r100) {
                return (LevelEnum) r27.a.a(LevelEnum.class, r100);
            }

            public LevelEnum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class a extends com.lark.wire.Message.a<WhiteListSetting, a> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public LevelEnum f279073d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public List<Long> f279074e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public List<Long> f279075f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public List<Long> f279076g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public Boolean f279077h;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new WhiteListSetting(this, c(), null);
            }

            public a() {
                this.f279074e = CollectionsKt.emptyList();
                this.f279075f = CollectionsKt.emptyList();
                this.f279076g = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<WhiteListSetting> {
            @Override // com.lark.wire.ProtoAdapter
            public final WhiteListSetting c(g0 r110) {
                Intrinsics.checkNotNullParameter(r110, "reader");
                a r100 = new a();
                ArrayList r101 = new ArrayList();
                ArrayList r102 = new ArrayList();
                ArrayList r103 = new ArrayList();
                long r104 = r110.c();
            L3:
                int r105 = r110.e();
                if (r105 == (-1)) goto L24;
                if (r105 != 1) goto L8;
                r100.f279073d = LevelEnum.ADAPTER.c(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r110.a(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r106 = Unit.INSTANCE;
                goto L3
            L8:
                if (r105 != 2) goto L10;
                r101.add(ProtoAdapter.f282722k.c(r110));
                goto L3
            L10:
                if (r105 != 3) goto L12;
                r102.add(ProtoAdapter.f282722k.c(r110));
                goto L3
            L12:
                if (r105 != 4) goto L14;
                r103.add(ProtoAdapter.f282722k.c(r110));
                goto L3
            L14:
                if (r105 != 5) goto L15;
                r100.f279077h = (Boolean) ProtoAdapter.f282718g.c(r110);
                goto L3
            L15:
                r110.j(r105);
                goto L3
            L24:
                ByteString r111 = r110.d(r104);
                Intrinsics.checkNotNullParameter(r101, "add_user_ids");
                com.lark.wire.internal.a.a(r101);
                r100.f279074e = r101;
                Intrinsics.checkNotNullParameter(r102, "del_user_ids");
                com.lark.wire.internal.a.a(r102);
                r100.f279075f = r102;
                Intrinsics.checkNotNullParameter(r103, "member_list_user_ids");
                com.lark.wire.internal.a.a(r103);
                r100.f279076g = r103;
                return new WhiteListSetting(r100, r111, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(WhiteListSetting r100) {
                WhiteListSetting r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                int r102 = r101.unknownFields().size() + LevelEnum.ADAPTER.l(1, r101.getLevel());
                t r103 = ProtoAdapter.f282722k;
                return (((r102 + r103.a().l(2, r101.getAdd_user_ids())) + r103.a().l(3, r101.getDel_user_ids())) + r103.a().l(4, r101.getMember_list_user_ids())) + ProtoAdapter.f282718g.l(5, r101.getHit_whitelist());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, WhiteListSetting r101) {
                WhiteListSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                LevelEnum.ADAPTER.i(r100, 1, r102.getLevel());
                t r103 = ProtoAdapter.f282722k;
                r103.a().i(r100, 2, r102.getAdd_user_ids());
                r103.a().i(r100, 3, r102.getDel_user_ids());
                r103.a().i(r100, 4, r102.getMember_list_user_ids());
                ProtoAdapter.f282718g.i(r100, 5, r102.getHit_whitelist());
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, WhiteListSetting r101) {
                WhiteListSetting r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
                ProtoAdapter.f282718g.j(r100, 5, r102.getHit_whitelist());
                t r103 = ProtoAdapter.f282722k;
                r103.a().j(r100, 4, r102.getMember_list_user_ids());
                r103.a().j(r100, 3, r102.getDel_user_ids());
                r103.a().j(r100, 2, r102.getAdd_user_ids());
                LevelEnum.ADAPTER.j(r100, 1, r102.getLevel());
            }

            public b(FieldEncoding r100, KClass<WhiteListSetting> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chat.WhiteListSetting", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ WhiteListSetting(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r100, r101);
        }

        static {
            Companion = new c();
            DEFAULT_LEVEL = LevelEnum.NO_MEMBER;
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(WhiteListSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.f279073d = this.level;
            r100.f279074e = this.add_user_ids;
            r100.f279075f = this.del_user_ids;
            r100.f279076g = this.member_list_user_ids;
            r100.f279077h = this.hit_whitelist;
            r100.a(unknownFields());
            return r100;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(WhiteListSetting.class).getSimpleName() + '@' + hashCode();
        }

        public final List<Long> getAdd_user_ids() {
            return this.add_user_ids;
        }

        public final List<Long> getDel_user_ids() {
            return this.del_user_ids;
        }

        public final Boolean getHit_whitelist() {
            return this.hit_whitelist;
        }

        public final LevelEnum getLevel() {
            return this.level;
        }

        public final List<Long> getMember_list_user_ids() {
            return this.member_list_user_ids;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public WhiteListSetting(a r100, ByteString r101) {
            super(ADAPTER, r101);
            this.level = r100.f279073d;
            this.add_user_ids = com.lark.wire.internal.a.c("add_user_ids", r100.f279074e);
            this.del_user_ids = com.lark.wire.internal.a.c("del_user_ids", r100.f279075f);
            this.member_list_user_ids = com.lark.wire.internal.a.c("member_list_user_ids", r100.f279076g);
            this.hit_whitelist = r100.f279077h;
        }

        public /* synthetic */ WhiteListSetting(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$WidgetState;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "EXPAND", "FOLD", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum WidgetState extends Enum<WidgetState> implements o0 {
        public static final ProtoAdapter<WidgetState> ADAPTER = null;
        public static final b Companion = null;
        public static final WidgetState EXPAND = null;
        public static final WidgetState FOLD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ WidgetState[] f279078a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f279079b = null;
        private final int value;

        public static final class a extends d<WidgetState> {
            @Override // com.lark.wire.d
            public final o0 n(int r100) {
                WidgetState.Companion.getClass();
                if (r100 == 0) goto L9;
                if (r100 == 1) goto L11;
                return null;
            L11:
                return WidgetState.FOLD;
            L9:
                return WidgetState.EXPAND;
            }

            public a(KClass<WidgetState> r100, Syntax r101, WidgetState r102) {
                super(r100, r101, r102);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<WidgetState> getEntries() {
            return f279079b;
        }

        static {
            WidgetState r100 = new WidgetState("EXPAND", 0, 0);
            EXPAND = r100;
            WidgetState r101 = new WidgetState("FOLD", 1, 1);
            FOLD = r101;
            WidgetState[] r102 = {r100, r101};
            f279078a = r102;
            f279079b = EnumEntriesKt.enumEntries(r102);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(WidgetState.class), Syntax.PROTO_2, r100);
        }

        public static WidgetState[] values() {
            return (WidgetState[]) f279078a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final WidgetState fromValue(int r100) {
            Companion.getClass();
            if (r100 == 0) goto L9;
            if (r100 == 1) goto L11;
            return null;
        L11:
            return FOLD;
        L9:
            return EXPAND;
        }

        public static WidgetState valueOf(String r100) {
            return (WidgetState) r27.a.a(WidgetState.class, r100);
        }

        public WidgetState(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a extends com.lark.wire.Message.a<Chat, a> {
        public String A;
        public ShareCardPermission.Enum A0;
        public Integer A1;
        public String B;
        public AddMemberApply.Enum B0;
        public TagData B1;
        public Integer C;
        public MessageVisibilitySetting.Enum C0;
        public Boolean C1;
        public Boolean D;
        public CreateUrgentSetting.Enum D0;
        public Boolean D1;
        public Announcement E;
        public CreateVideoConferenceSetting.Enum E0;
        public Boolean E1;
        public Boolean F;
        public PinPermissionSetting.Enum F0;
        public Boolean F1;
        public String G;
        public TopNoticePermissionSetting.Enum G0;
        public RestrictedModeSetting G1;
        public Boolean H;
        public ChatTabPermissionSetting.Enum H0;
        public DefDisplaySetting.Enum H1;
        public Boolean I;
        public ChatDisplayModeSetting.Enum I0;
        public String I1;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public MessagePosition.Enum f279080J;
        public ChatPinPermissionSetting.Enum J0;
        public Boolean J1;
        public FeedCard.FeedType K;
        public Integer K0;
        public AdminPostSetting.Enum K1;
        public String L;
        public Boolean L0;
        public Boolean L1;
        public Integer M;
        public String M0;
        public UserCountVisibleSetting.Enum M1;
        public Boolean N;
        public String N0;
        public Boolean N1;
        public Boolean O;
        public List<SideBarButton> O0;
        public DoubaoSetting O1;
        public Boolean P;
        public Long P0;
        public List<? extends Tag> P1;
        public Boolean Q;
        public Long Q0;
        public Long Q1;
        public Integer R;
        public Integer R0;
        public Boolean R1;
        public String S;
        public String S0;
        public BannerSetting S1;
        public Integer T;
        public AnonymousSetting.Enum T0;
        public Boolean T1;
        public Integer U;
        public Long U0;
        public Boolean U1;
        public Integer V;
        public Boolean V0;
        public String V1;
        public Integer W;
        public String W0;
        public String W1;
        public Boolean X;
        public Boolean X0;
        public String X1;
        public Boolean Y;
        public Long Y0;
        public TnsInfo Y1;
        public PostType Z;
        public String Z0;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public ChatMode f279081a0;

        /* JADX INFO: renamed from: a1, reason: collision with root package name */
        public TeamChatType f279082a1;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public String f279083b0;

        /* JADX INFO: renamed from: b1, reason: collision with root package name */
        public Map<Integer, Integer> f279084b1;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public Integer f279085c0;

        /* JADX INFO: renamed from: c1, reason: collision with root package name */
        public List<ChatTeamInfo> f279086c1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f279087d;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public Integer f279088d0;

        /* JADX INFO: renamed from: d1, reason: collision with root package name */
        public Map<Long, Team> f279089d1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Type f279090e;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public Integer f279091e0;

        /* JADX INFO: renamed from: e1, reason: collision with root package name */
        public List<ChatTeamInfo> f279092e1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f279093f;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public Integer f279094f0;

        /* JADX INFO: renamed from: f1, reason: collision with root package name */
        public ChatUserAutoMuteSetting f279095f1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f279096g;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public Integer f279097g0;

        /* JADX INFO: renamed from: g1, reason: collision with root package name */
        public Long f279098g1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Integer f279099h;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public Integer f279100h0;

        /* JADX INFO: renamed from: h1, reason: collision with root package name */
        public Long f279101h1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Integer f279102i;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public Integer f279103i0;

        /* JADX INFO: renamed from: i1, reason: collision with root package name */
        public CommonAIReply.Status f279104i1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Long f279105j;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public String f279106j0;

        /* JADX INFO: renamed from: j1, reason: collision with root package name */
        public Integer f279107j1;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f279108k;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public Boolean f279109k0;

        /* JADX INFO: renamed from: k1, reason: collision with root package name */
        public String f279110k1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f279111l;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public String f279112l0;

        /* JADX INFO: renamed from: l1, reason: collision with root package name */
        public Boolean f279113l1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Long f279114m;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public Integer f279115m0;

        /* JADX INFO: renamed from: m1, reason: collision with root package name */
        public Boolean f279116m1;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f279117n;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public Float f279118n0;

        /* JADX INFO: renamed from: n1, reason: collision with root package name */
        public Boolean f279119n1;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Image f279120o;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public Boolean f279121o0;

        /* JADX INFO: renamed from: o1, reason: collision with root package name */
        public Boolean f279122o1;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f279123p;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public Boolean f279124p0;

        /* JADX INFO: renamed from: p1, reason: collision with root package name */
        public Boolean f279125p1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Integer f279126q;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public Boolean f279127q0;

        /* JADX INFO: renamed from: q1, reason: collision with root package name */
        public Boolean f279128q1;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Integer f279129r;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        public Boolean f279130r0;

        /* JADX INFO: renamed from: r1, reason: collision with root package name */
        public String f279131r1;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public Boolean f279132s;

        /* JADX INFO: renamed from: s0, reason: collision with root package name */
        public Boolean f279133s0;

        /* JADX INFO: renamed from: s1, reason: collision with root package name */
        public Boolean f279134s1;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public Boolean f279135t;

        /* JADX INFO: renamed from: t0, reason: collision with root package name */
        public Boolean f279136t0;

        /* JADX INFO: renamed from: t1, reason: collision with root package name */
        public Boolean f279137t1;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public Boolean f279138u;

        /* JADX INFO: renamed from: u0, reason: collision with root package name */
        public Boolean f279139u0;

        /* JADX INFO: renamed from: u1, reason: collision with root package name */
        public TypingTranslateSetting f279140u1;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public Boolean f279141v;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        public Boolean f279142v0;

        /* JADX INFO: renamed from: v1, reason: collision with root package name */
        public List<FeedTag> f279143v1;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public Boolean f279144w;

        /* JADX INFO: renamed from: w0, reason: collision with root package name */
        public AddMemberPermission.Enum f279145w0;

        /* JADX INFO: renamed from: w1, reason: collision with root package name */
        public Boolean f279146w1;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f279147x;

        /* JADX INFO: renamed from: x0, reason: collision with root package name */
        public AtAllPermission.Enum f279148x0;

        /* JADX INFO: renamed from: x1, reason: collision with root package name */
        public Boolean f279149x1;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public Role f279150y;

        /* JADX INFO: renamed from: y0, reason: collision with root package name */
        public SystemMessageVisible.Enum f279151y0;

        /* JADX INFO: renamed from: y1, reason: collision with root package name */
        public String f279152y1;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public Boolean f279153z;

        /* JADX INFO: renamed from: z0, reason: collision with root package name */
        public SystemMessageVisible.Enum f279154z0;

        /* JADX INFO: renamed from: z1, reason: collision with root package name */
        public List<String> f279155z1;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new Chat(this, c(), null);
        }

        public a() {
            this.O0 = CollectionsKt.emptyList();
            this.f279084b1 = MapsKt.emptyMap();
            this.f279086c1 = CollectionsKt.emptyList();
            this.f279089d1 = MapsKt.emptyMap();
            this.f279092e1 = CollectionsKt.emptyList();
            this.f279143v1 = CollectionsKt.emptyList();
            this.f279155z1 = CollectionsKt.emptyList();
            this.P1 = CollectionsKt.emptyList();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ Chat(a r100, ByteString r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    @Deprecated(message = "avatar is deprecated")
    public static /* synthetic */ void getAvatar$annotations() {
    }

    @Deprecated(message = "new_message_count is deprecated")
    public static /* synthetic */ void getNew_message_count$annotations() {
    }

    @Deprecated(message = "new_thread_count is deprecated")
    public static /* synthetic */ void getNew_thread_count$annotations() {
    }

    @Deprecated(message = "no_badged_new_message_count is deprecated")
    public static /* synthetic */ void getNo_badged_new_message_count$annotations() {
    }

    @Deprecated(message = "no_badged_new_thread_count is deprecated")
    public static /* synthetic */ void getNo_badged_new_thread_count$annotations() {
    }

    @Deprecated(message = "is_public is deprecated")
    public static /* synthetic */ void is_public$annotations() {
    }

    static {
        Companion = new b();
        DEFAULT_TYPE = Type.P2P;
        DEFAULT_ROLE = Role.IGNORE;
        DEFAULT_MESSAGE_POSITION = MessagePosition.Enum.RECENT_LEFT;
        DEFAULT_FEED_TYPE = FeedCard.FeedType.INBOX;
        DEFAULT_CHAT_MODE = ChatMode.DEFAULT;
        DEFAULT_ADD_MEMBER_PERMISSION = AddMemberPermission.Enum.ALL_MEMBERS;
        DEFAULT_AT_ALL_PERMISSION = AtAllPermission.Enum.ALL_MEMBERS;
        SystemMessageVisible.Enum r100 = SystemMessageVisible.Enum.ONLY_OWNER;
        DEFAULT_JOIN_MESSAGE_VISIBLE = r100;
        DEFAULT_QUIT_MESSAGE_VISIBLE = r100;
        DEFAULT_SHARE_CARD_PERMISSION = ShareCardPermission.Enum.ALLOWED;
        DEFAULT_ADD_MEMBER_APPLY = AddMemberApply.Enum.NO_APPLY;
        DEFAULT_MESSAGE_VISIBILITY_SETTING = MessageVisibilitySetting.Enum.ALL_MESSAGES;
        DEFAULT_CREATE_URGENT_SETTING = CreateUrgentSetting.Enum.ALL_MEMBERS;
        DEFAULT_CREATE_VIDEO_CONFERENCE_SETTING = CreateVideoConferenceSetting.Enum.ALL_MEMBERS;
        DEFAULT_PIN_PERMISSION_SETTING = PinPermissionSetting.Enum.ALL_MEMBERS;
        DEFAULT_TOP_NOTICE_PERMISSION_SETTING = TopNoticePermissionSetting.Enum.ALL_MEMBERS;
        DEFAULT_CHAT_TAB_PERMISSION_SETTING = ChatTabPermissionSetting.Enum.ALL_MEMBERS;
        DEFAULT_ANONYMOUS_SETTING = AnonymousSetting.Enum.INVISIBLE;
        DEFAULT_DEF_DISPLAY_SETTING = DefDisplaySetting.Enum.INPUT_BOX;
        DEFAULT_ADMIN_POST_SETTING = AdminPostSetting.Enum.ALLOW_POST;
        final FieldEncoding r101 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r102 = Reflection.getOrCreateKotlinClass(Chat.class);
        final Syntax r103 = Syntax.PROTO_2;
        ADAPTER = new Chat$Companion$ADAPTER$1(r101, r102, r103);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r100 = new a();
        r100.f279087d = this.f278992id;
        r100.f279090e = this.type;
        r100.f279093f = this.name;
        r100.f279096g = this.last_message_id;
        r100.f279099h = this.last_message_position;
        r100.f279102i = this.new_message_count;
        r100.f279105j = this.update_time;
        r100.f279108k = this.avatar_key;
        r100.f279111l = this.chatter_id;
        r100.f279114m = this.create_time;
        r100.f279117n = this.description;
        r100.f279120o = this.avatar;
        r100.f279123p = this.owner_id;
        r100.f279126q = this.chatter_count;
        r100.f279129r = this.user_count;
        r100.f279132s = this.is_department;
        r100.f279135t = this.is_public;
        r100.f279138u = this.is_archived;
        r100.f279141v = this.is_deleted;
        r100.f279144w = this.is_remind;
        r100.f279147x = this.name_pinyin;
        r100.f279150y = this.role;
        r100.f279153z = this.is_customer_service;
        r100.A = this.text_draft_id;
        r100.B = this.post_draft_id;
        r100.C = this.no_badged_new_message_count;
        r100.D = this.is_shortcut;
        r100.E = this.announcement;
        r100.F = this.off_edit_group_chat_info;
        r100.G = this.tenant_id;
        r100.H = this.is_custom_icon;
        r100.I = this.is_dissolved;
        r100.f279080J = this.message_position;
        r100.K = this.feed_type;
        r100.L = this.last_visible_message_id;
        r100.M = this.burn_life;
        r100.N = this.is_crypto;
        r100.O = this.is_meeting;
        r100.P = this.is_cross_tenant;
        r100.Q = this.is_support_view;
        r100.R = this.first_message_position;
        r100.S = this.oncall_id;
        r100.T = this.last_visible_message_position;
        r100.U = this.read_position;
        r100.V = this.read_position_badge_count;
        r100.W = this.last_message_position_badge_count;
        r100.X = this.is_public_v2;
        r100.Y = this.allow_post;
        r100.Z = this.post_type;
        r100.f279081a0 = this.chat_mode;
        r100.f279083b0 = this.last_thread_id;
        r100.f279085c0 = this.last_thread_position;
        r100.f279088d0 = this.new_thread_count;
        r100.f279091e0 = this.no_badged_new_thread_count;
        r100.f279094f0 = this.last_thread_position_badge_count;
        r100.f279097g0 = this.read_thread_position;
        r100.f279100h0 = this.read_thread_position_badge_count;
        r100.f279103i0 = this.last_visible_thread_position;
        r100.f279106j0 = this.last_visible_thread_id;
        r100.f279109k0 = this.show_nickname;
        r100.f279112l0 = this.last_draft_id;
        r100.f279115m0 = this.last_read_position;
        r100.f279118n0 = this.last_read_offset;
        r100.f279121o0 = this.is_edu;
        r100.f279124p0 = this.is_admin;
        r100.f279127q0 = this.is_mute_at_all;
        r100.f279130r0 = this.is_delayed;
        r100.f279133s0 = this.is_p2p_ai;
        r100.f279136t0 = this.is_ocic_customer_service;
        r100.f279139u0 = this.is_p2p_official_bot_ai;
        r100.f279142v0 = this.is_temp_top_feed;
        r100.f279145w0 = this.add_member_permission;
        r100.f279148x0 = this.at_all_permission;
        r100.f279151y0 = this.join_message_visible;
        r100.f279154z0 = this.quit_message_visible;
        r100.A0 = this.share_card_permission;
        r100.B0 = this.add_member_apply;
        r100.C0 = this.message_visibility_setting;
        r100.D0 = this.create_urgent_setting;
        r100.E0 = this.create_video_conference_setting;
        r100.F0 = this.pin_permission_setting;
        r100.G0 = this.top_notice_permission_setting;
        r100.H0 = this.chat_tab_permission_setting;
        r100.I0 = this.chat_display_mode_setting;
        r100.J0 = this.chat_pin_permission_setting;
        r100.K0 = this.put_chatter_apply_count;
        r100.L0 = this.show_banner;
        r100.M0 = this.mini_avatar_key;
        r100.N0 = this.sidebar_id;
        r100.O0 = this.sidebar_buttons;
        r100.P0 = this.my_threads_read_timestamp;
        r100.Q0 = this.my_threads_last_timestamp;
        r100.R0 = this.my_threads_unread_count;
        r100.S0 = this.my_threads_last_display_message_id;
        r100.T0 = this.anonymous_setting;
        r100.U0 = this.anonymous_total_quota;
        r100.V0 = this.is_cross_with_ka;
        r100.W0 = this.anonymous_id;
        r100.X0 = this.is_team;
        r100.Y0 = this.team_id;
        r100.Z0 = this.team_name;
        r100.f279082a1 = this.team_chat_type;
        r100.f279084b1 = this.chatter_extra_states;
        r100.f279086c1 = this.joined_team_infos;
        r100.f279089d1 = this.joined_teams;
        r100.f279092e1 = this.bound_team_infos;
        r100.f279095f1 = this.user_auto_mute;
        r100.f279098g1 = this.ai_knowledge_query_id;
        r100.f279101h1 = this.query_create_time;
        r100.f279104i1 = this.query_status;
        r100.f279107j1 = this.query_seq_id;
        r100.f279110k1 = this.edit_message_draft_id;
        r100.f279113l1 = this.chatable;
        r100.f279116m1 = this.muteable;
        r100.f279119n1 = this.is_super;
        r100.f279122o1 = this.is_private_mode;
        r100.f279125p1 = this.is_tenant;
        r100.f279128q1 = this.is_in_box;
        r100.f279131r1 = this.box_id;
        r100.f279134s1 = this.is_auto_translate;
        r100.f279137t1 = this.is_auto_typing_translate;
        r100.f279140u1 = this.typing_translate_setting;
        r100.f279143v1 = this.feed_tag;
        r100.f279146w1 = this.is_flag;
        r100.f279149x1 = this.has_water_mark;
        r100.f279152y1 = this.avatar_path;
        r100.f279155z1 = this.avatar_urls;
        r100.A1 = this.first_chat_message_position;
        r100.B1 = this.tag_info;
        r100.C1 = this.is_fake;
        r100.D1 = this.typing_translate_has_auto_opened;
        r100.E1 = this.is_official_oncall;
        r100.F1 = this.is_offline_oncall;
        r100.G1 = this.restricted_mode_setting;
        r100.H1 = this.def_display_setting;
        r100.I1 = this.schedule_message_draft_id;
        r100.J1 = this.has_vc_chat_permission;
        r100.K1 = this.admin_post_setting;
        r100.L1 = this.can_be_sorted_alphabetically;
        r100.M1 = this.user_count_visible_setting;
        r100.N1 = this.is_user_count_visible;
        r100.O1 = this.doubao_setting;
        r100.P1 = this.tags;
        r100.Q1 = this.theme_id;
        r100.R1 = this.is_frozen;
        r100.S1 = this.banner_setting;
        r100.T1 = this.can_translate_name;
        r100.U1 = this.should_display_translated_name;
        r100.V1 = this.translated_name;
        r100.W1 = this.name_major_language;
        r100.X1 = this.name_translate_language;
        r100.Y1 = this.tns_info;
        r100.a(unknownFields());
        return r100;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(Chat.class).getSimpleName() + '@' + hashCode();
    }

    public final AddMemberApply.Enum getAdd_member_apply() {
        return this.add_member_apply;
    }

    public final AddMemberPermission.Enum getAdd_member_permission() {
        return this.add_member_permission;
    }

    public final AdminPostSetting.Enum getAdmin_post_setting() {
        return this.admin_post_setting;
    }

    public final Long getAi_knowledge_query_id() {
        return this.ai_knowledge_query_id;
    }

    public final Boolean getAllow_post() {
        return this.allow_post;
    }

    public final Announcement getAnnouncement() {
        return this.announcement;
    }

    public final String getAnonymous_id() {
        return this.anonymous_id;
    }

    public final AnonymousSetting.Enum getAnonymous_setting() {
        return this.anonymous_setting;
    }

    public final Long getAnonymous_total_quota() {
        return this.anonymous_total_quota;
    }

    public final AtAllPermission.Enum getAt_all_permission() {
        return this.at_all_permission;
    }

    public final Image getAvatar() {
        return this.avatar;
    }

    public final String getAvatar_key() {
        return this.avatar_key;
    }

    public final String getAvatar_path() {
        return this.avatar_path;
    }

    public final List<String> getAvatar_urls() {
        return this.avatar_urls;
    }

    public final BannerSetting getBanner_setting() {
        return this.banner_setting;
    }

    public final List<ChatTeamInfo> getBound_team_infos() {
        return this.bound_team_infos;
    }

    public final String getBox_id() {
        return this.box_id;
    }

    public final Integer getBurn_life() {
        return this.burn_life;
    }

    public final Boolean getCan_be_sorted_alphabetically() {
        return this.can_be_sorted_alphabetically;
    }

    public final Boolean getCan_translate_name() {
        return this.can_translate_name;
    }

    public final ChatDisplayModeSetting.Enum getChat_display_mode_setting() {
        return this.chat_display_mode_setting;
    }

    public final ChatMode getChat_mode() {
        return this.chat_mode;
    }

    public final ChatPinPermissionSetting.Enum getChat_pin_permission_setting() {
        return this.chat_pin_permission_setting;
    }

    public final ChatTabPermissionSetting.Enum getChat_tab_permission_setting() {
        return this.chat_tab_permission_setting;
    }

    public final Boolean getChatable() {
        return this.chatable;
    }

    public final Integer getChatter_count() {
        return this.chatter_count;
    }

    public final Map<Integer, Integer> getChatter_extra_states() {
        return this.chatter_extra_states;
    }

    public final String getChatter_id() {
        return this.chatter_id;
    }

    public final Long getCreate_time() {
        return this.create_time;
    }

    public final CreateUrgentSetting.Enum getCreate_urgent_setting() {
        return this.create_urgent_setting;
    }

    public final CreateVideoConferenceSetting.Enum getCreate_video_conference_setting() {
        return this.create_video_conference_setting;
    }

    public final DefDisplaySetting.Enum getDef_display_setting() {
        return this.def_display_setting;
    }

    public final String getDescription() {
        return this.description;
    }

    public final DoubaoSetting getDoubao_setting() {
        return this.doubao_setting;
    }

    public final String getEdit_message_draft_id() {
        return this.edit_message_draft_id;
    }

    public final List<FeedTag> getFeed_tag() {
        return this.feed_tag;
    }

    public final FeedCard.FeedType getFeed_type() {
        return this.feed_type;
    }

    public final Integer getFirst_chat_message_position() {
        return this.first_chat_message_position;
    }

    public final Integer getFirst_message_position() {
        return this.first_message_position;
    }

    public final Boolean getHas_vc_chat_permission() {
        return this.has_vc_chat_permission;
    }

    public final Boolean getHas_water_mark() {
        return this.has_water_mark;
    }

    public final String getId() {
        return this.f278992id;
    }

    public final SystemMessageVisible.Enum getJoin_message_visible() {
        return this.join_message_visible;
    }

    public final List<ChatTeamInfo> getJoined_team_infos() {
        return this.joined_team_infos;
    }

    public final Map<Long, Team> getJoined_teams() {
        return this.joined_teams;
    }

    public final String getLast_draft_id() {
        return this.last_draft_id;
    }

    public final String getLast_message_id() {
        return this.last_message_id;
    }

    public final Integer getLast_message_position() {
        return this.last_message_position;
    }

    public final Integer getLast_message_position_badge_count() {
        return this.last_message_position_badge_count;
    }

    public final Float getLast_read_offset() {
        return this.last_read_offset;
    }

    public final Integer getLast_read_position() {
        return this.last_read_position;
    }

    public final String getLast_thread_id() {
        return this.last_thread_id;
    }

    public final Integer getLast_thread_position() {
        return this.last_thread_position;
    }

    public final Integer getLast_thread_position_badge_count() {
        return this.last_thread_position_badge_count;
    }

    public final String getLast_visible_message_id() {
        return this.last_visible_message_id;
    }

    public final Integer getLast_visible_message_position() {
        return this.last_visible_message_position;
    }

    public final String getLast_visible_thread_id() {
        return this.last_visible_thread_id;
    }

    public final Integer getLast_visible_thread_position() {
        return this.last_visible_thread_position;
    }

    public final MessagePosition.Enum getMessage_position() {
        return this.message_position;
    }

    public final MessageVisibilitySetting.Enum getMessage_visibility_setting() {
        return this.message_visibility_setting;
    }

    public final String getMini_avatar_key() {
        return this.mini_avatar_key;
    }

    public final Boolean getMuteable() {
        return this.muteable;
    }

    public final String getMy_threads_last_display_message_id() {
        return this.my_threads_last_display_message_id;
    }

    public final Long getMy_threads_last_timestamp() {
        return this.my_threads_last_timestamp;
    }

    public final Long getMy_threads_read_timestamp() {
        return this.my_threads_read_timestamp;
    }

    public final Integer getMy_threads_unread_count() {
        return this.my_threads_unread_count;
    }

    public final String getName() {
        return this.name;
    }

    public final String getName_major_language() {
        return this.name_major_language;
    }

    public final String getName_pinyin() {
        return this.name_pinyin;
    }

    public final String getName_translate_language() {
        return this.name_translate_language;
    }

    public final Integer getNew_message_count() {
        return this.new_message_count;
    }

    public final Integer getNew_thread_count() {
        return this.new_thread_count;
    }

    public final Integer getNo_badged_new_message_count() {
        return this.no_badged_new_message_count;
    }

    public final Integer getNo_badged_new_thread_count() {
        return this.no_badged_new_thread_count;
    }

    public final Boolean getOff_edit_group_chat_info() {
        return this.off_edit_group_chat_info;
    }

    public final String getOncall_id() {
        return this.oncall_id;
    }

    public final String getOwner_id() {
        return this.owner_id;
    }

    public final PinPermissionSetting.Enum getPin_permission_setting() {
        return this.pin_permission_setting;
    }

    public final String getPost_draft_id() {
        return this.post_draft_id;
    }

    public final PostType getPost_type() {
        return this.post_type;
    }

    public final Integer getPut_chatter_apply_count() {
        return this.put_chatter_apply_count;
    }

    public final Long getQuery_create_time() {
        return this.query_create_time;
    }

    public final Integer getQuery_seq_id() {
        return this.query_seq_id;
    }

    public final CommonAIReply.Status getQuery_status() {
        return this.query_status;
    }

    public final SystemMessageVisible.Enum getQuit_message_visible() {
        return this.quit_message_visible;
    }

    public final Integer getRead_position() {
        return this.read_position;
    }

    public final Integer getRead_position_badge_count() {
        return this.read_position_badge_count;
    }

    public final Integer getRead_thread_position() {
        return this.read_thread_position;
    }

    public final Integer getRead_thread_position_badge_count() {
        return this.read_thread_position_badge_count;
    }

    public final RestrictedModeSetting getRestricted_mode_setting() {
        return this.restricted_mode_setting;
    }

    public final Role getRole() {
        return this.role;
    }

    public final String getSchedule_message_draft_id() {
        return this.schedule_message_draft_id;
    }

    public final ShareCardPermission.Enum getShare_card_permission() {
        return this.share_card_permission;
    }

    public final Boolean getShould_display_translated_name() {
        return this.should_display_translated_name;
    }

    public final Boolean getShow_banner() {
        return this.show_banner;
    }

    public final Boolean getShow_nickname() {
        return this.show_nickname;
    }

    public final List<SideBarButton> getSidebar_buttons() {
        return this.sidebar_buttons;
    }

    public final String getSidebar_id() {
        return this.sidebar_id;
    }

    public final TagData getTag_info() {
        return this.tag_info;
    }

    public final List<Tag> getTags() {
        return this.tags;
    }

    public final TeamChatType getTeam_chat_type() {
        return this.team_chat_type;
    }

    public final Long getTeam_id() {
        return this.team_id;
    }

    public final String getTeam_name() {
        return this.team_name;
    }

    public final String getTenant_id() {
        return this.tenant_id;
    }

    public final String getText_draft_id() {
        return this.text_draft_id;
    }

    public final Long getTheme_id() {
        return this.theme_id;
    }

    public final TnsInfo getTns_info() {
        return this.tns_info;
    }

    public final TopNoticePermissionSetting.Enum getTop_notice_permission_setting() {
        return this.top_notice_permission_setting;
    }

    public final String getTranslated_name() {
        return this.translated_name;
    }

    public final Type getType() {
        return this.type;
    }

    public final Boolean getTyping_translate_has_auto_opened() {
        return this.typing_translate_has_auto_opened;
    }

    public final TypingTranslateSetting getTyping_translate_setting() {
        return this.typing_translate_setting;
    }

    public final Long getUpdate_time() {
        return this.update_time;
    }

    public final ChatUserAutoMuteSetting getUser_auto_mute() {
        return this.user_auto_mute;
    }

    public final Integer getUser_count() {
        return this.user_count;
    }

    public final UserCountVisibleSetting.Enum getUser_count_visible_setting() {
        return this.user_count_visible_setting;
    }

    public final Boolean is_admin() {
        return this.is_admin;
    }

    public final Boolean is_archived() {
        return this.is_archived;
    }

    public final Boolean is_auto_translate() {
        return this.is_auto_translate;
    }

    public final Boolean is_auto_typing_translate() {
        return this.is_auto_typing_translate;
    }

    public final Boolean is_cross_tenant() {
        return this.is_cross_tenant;
    }

    public final Boolean is_cross_with_ka() {
        return this.is_cross_with_ka;
    }

    public final Boolean is_crypto() {
        return this.is_crypto;
    }

    public final Boolean is_custom_icon() {
        return this.is_custom_icon;
    }

    public final Boolean is_customer_service() {
        return this.is_customer_service;
    }

    public final Boolean is_delayed() {
        return this.is_delayed;
    }

    public final Boolean is_deleted() {
        return this.is_deleted;
    }

    public final Boolean is_department() {
        return this.is_department;
    }

    public final Boolean is_dissolved() {
        return this.is_dissolved;
    }

    public final Boolean is_edu() {
        return this.is_edu;
    }

    public final Boolean is_fake() {
        return this.is_fake;
    }

    public final Boolean is_flag() {
        return this.is_flag;
    }

    public final Boolean is_frozen() {
        return this.is_frozen;
    }

    public final Boolean is_in_box() {
        return this.is_in_box;
    }

    public final Boolean is_meeting() {
        return this.is_meeting;
    }

    public final Boolean is_mute_at_all() {
        return this.is_mute_at_all;
    }

    public final Boolean is_ocic_customer_service() {
        return this.is_ocic_customer_service;
    }

    public final Boolean is_official_oncall() {
        return this.is_official_oncall;
    }

    public final Boolean is_offline_oncall() {
        return this.is_offline_oncall;
    }

    public final Boolean is_p2p_ai() {
        return this.is_p2p_ai;
    }

    public final Boolean is_p2p_official_bot_ai() {
        return this.is_p2p_official_bot_ai;
    }

    public final Boolean is_private_mode() {
        return this.is_private_mode;
    }

    public final Boolean is_public() {
        return this.is_public;
    }

    public final Boolean is_public_v2() {
        return this.is_public_v2;
    }

    public final Boolean is_remind() {
        return this.is_remind;
    }

    public final Boolean is_shortcut() {
        return this.is_shortcut;
    }

    public final Boolean is_super() {
        return this.is_super;
    }

    public final Boolean is_support_view() {
        return this.is_support_view;
    }

    public final Boolean is_team() {
        return this.is_team;
    }

    public final Boolean is_temp_top_feed() {
        return this.is_temp_top_feed;
    }

    public final Boolean is_tenant() {
        return this.is_tenant;
    }

    public final Boolean is_user_count_visible() {
        return this.is_user_count_visible;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public Chat(a r100, ByteString r101) {
        super(ADAPTER, r101);
        String r102 = r100.f279087d;
        Intrinsics.checkNotNull(r102);
        this.f278992id = r102;
        this.type = r100.f279090e;
        this.name = r100.f279093f;
        this.last_message_id = r100.f279096g;
        this.last_message_position = r100.f279099h;
        this.new_message_count = r100.f279102i;
        this.update_time = r100.f279105j;
        this.avatar_key = r100.f279108k;
        this.chatter_id = r100.f279111l;
        this.create_time = r100.f279114m;
        this.description = r100.f279117n;
        this.avatar = r100.f279120o;
        this.owner_id = r100.f279123p;
        this.chatter_count = r100.f279126q;
        this.user_count = r100.f279129r;
        this.is_department = r100.f279132s;
        this.is_public = r100.f279135t;
        this.is_archived = r100.f279138u;
        this.is_deleted = r100.f279141v;
        this.is_remind = r100.f279144w;
        this.name_pinyin = r100.f279147x;
        this.role = r100.f279150y;
        this.is_customer_service = r100.f279153z;
        this.text_draft_id = r100.A;
        this.post_draft_id = r100.B;
        this.no_badged_new_message_count = r100.C;
        this.is_shortcut = r100.D;
        this.announcement = r100.E;
        this.off_edit_group_chat_info = r100.F;
        this.tenant_id = r100.G;
        this.is_custom_icon = r100.H;
        this.is_dissolved = r100.I;
        this.message_position = r100.f279080J;
        this.feed_type = r100.K;
        this.last_visible_message_id = r100.L;
        this.burn_life = r100.M;
        this.is_crypto = r100.N;
        this.is_meeting = r100.O;
        this.is_cross_tenant = r100.P;
        this.is_support_view = r100.Q;
        this.first_message_position = r100.R;
        this.oncall_id = r100.S;
        this.last_visible_message_position = r100.T;
        this.read_position = r100.U;
        this.read_position_badge_count = r100.V;
        this.last_message_position_badge_count = r100.W;
        this.is_public_v2 = r100.X;
        this.allow_post = r100.Y;
        this.post_type = r100.Z;
        this.chat_mode = r100.f279081a0;
        this.last_thread_id = r100.f279083b0;
        this.last_thread_position = r100.f279085c0;
        this.new_thread_count = r100.f279088d0;
        this.no_badged_new_thread_count = r100.f279091e0;
        this.last_thread_position_badge_count = r100.f279094f0;
        this.read_thread_position = r100.f279097g0;
        this.read_thread_position_badge_count = r100.f279100h0;
        this.last_visible_thread_position = r100.f279103i0;
        this.last_visible_thread_id = r100.f279106j0;
        this.show_nickname = r100.f279109k0;
        this.last_draft_id = r100.f279112l0;
        this.last_read_position = r100.f279115m0;
        this.last_read_offset = r100.f279118n0;
        this.is_edu = r100.f279121o0;
        this.is_admin = r100.f279124p0;
        this.is_mute_at_all = r100.f279127q0;
        this.is_delayed = r100.f279130r0;
        this.is_p2p_ai = r100.f279133s0;
        this.is_ocic_customer_service = r100.f279136t0;
        this.is_p2p_official_bot_ai = r100.f279139u0;
        this.is_temp_top_feed = r100.f279142v0;
        this.add_member_permission = r100.f279145w0;
        this.at_all_permission = r100.f279148x0;
        this.join_message_visible = r100.f279151y0;
        this.quit_message_visible = r100.f279154z0;
        this.share_card_permission = r100.A0;
        this.add_member_apply = r100.B0;
        this.message_visibility_setting = r100.C0;
        this.create_urgent_setting = r100.D0;
        this.create_video_conference_setting = r100.E0;
        this.pin_permission_setting = r100.F0;
        this.top_notice_permission_setting = r100.G0;
        this.chat_tab_permission_setting = r100.H0;
        this.chat_display_mode_setting = r100.I0;
        this.chat_pin_permission_setting = r100.J0;
        this.put_chatter_apply_count = r100.K0;
        this.show_banner = r100.L0;
        this.mini_avatar_key = r100.M0;
        this.sidebar_id = r100.N0;
        this.sidebar_buttons = com.lark.wire.internal.a.c("sidebar_buttons", r100.O0);
        this.my_threads_read_timestamp = r100.P0;
        this.my_threads_last_timestamp = r100.Q0;
        this.my_threads_unread_count = r100.R0;
        this.my_threads_last_display_message_id = r100.S0;
        this.anonymous_setting = r100.T0;
        this.anonymous_total_quota = r100.U0;
        this.is_cross_with_ka = r100.V0;
        this.anonymous_id = r100.W0;
        this.is_team = r100.X0;
        this.team_id = r100.Y0;
        this.team_name = r100.Z0;
        this.team_chat_type = r100.f279082a1;
        this.chatter_extra_states = com.lark.wire.internal.a.d("chatter_extra_states", r100.f279084b1);
        this.joined_team_infos = com.lark.wire.internal.a.c("joined_team_infos", r100.f279086c1);
        this.joined_teams = com.lark.wire.internal.a.d("joined_teams", r100.f279089d1);
        this.bound_team_infos = com.lark.wire.internal.a.c("bound_team_infos", r100.f279092e1);
        this.user_auto_mute = r100.f279095f1;
        this.ai_knowledge_query_id = r100.f279098g1;
        this.query_create_time = r100.f279101h1;
        this.query_status = r100.f279104i1;
        this.query_seq_id = r100.f279107j1;
        this.edit_message_draft_id = r100.f279110k1;
        this.chatable = r100.f279113l1;
        this.muteable = r100.f279116m1;
        this.is_super = r100.f279119n1;
        this.is_private_mode = r100.f279122o1;
        this.is_tenant = r100.f279125p1;
        this.is_in_box = r100.f279128q1;
        this.box_id = r100.f279131r1;
        this.is_auto_translate = r100.f279134s1;
        this.is_auto_typing_translate = r100.f279137t1;
        this.typing_translate_setting = r100.f279140u1;
        this.feed_tag = com.lark.wire.internal.a.c("feed_tag", r100.f279143v1);
        this.is_flag = r100.f279146w1;
        this.has_water_mark = r100.f279149x1;
        this.avatar_path = r100.f279152y1;
        this.avatar_urls = com.lark.wire.internal.a.c("avatar_urls", r100.f279155z1);
        this.first_chat_message_position = r100.A1;
        this.tag_info = r100.B1;
        this.is_fake = r100.C1;
        this.typing_translate_has_auto_opened = r100.D1;
        this.is_official_oncall = r100.E1;
        this.is_offline_oncall = r100.F1;
        this.restricted_mode_setting = r100.G1;
        this.def_display_setting = r100.H1;
        this.schedule_message_draft_id = r100.I1;
        this.has_vc_chat_permission = r100.J1;
        this.admin_post_setting = r100.K1;
        this.can_be_sorted_alphabetically = r100.L1;
        this.user_count_visible_setting = r100.M1;
        this.is_user_count_visible = r100.N1;
        this.doubao_setting = r100.O1;
        this.tags = com.lark.wire.internal.a.c(PromotionProductPrivilegesStruct.TAGS, r100.P1);
        this.theme_id = r100.Q1;
        this.is_frozen = r100.R1;
        this.banner_setting = r100.S1;
        this.can_translate_name = r100.T1;
        this.should_display_translated_name = r100.U1;
        this.translated_name = r100.V1;
        this.name_major_language = r100.W1;
        this.name_translate_language = r100.X1;
        this.tns_info = r100.Y1;
    }

    public /* synthetic */ Chat(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = ByteString.EMPTY;
    L5:
        this(r100, r101);
    }
}
