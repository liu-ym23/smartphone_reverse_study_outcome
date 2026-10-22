package com.lark.kmp.pb.basic.v1;

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
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0084\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b$\u0018\u0000 ù\u00022\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:>ø\u0002ù\u0002ú\u0002û\u0002ü\u0002ý\u0002þ\u0002ÿ\u0002\u0080\u0003\u0081\u0003\u0082\u0003\u0083\u0003\u0084\u0003\u0085\u0003\u0086\u0003\u0087\u0003\u0088\u0003\u0089\u0003\u008a\u0003\u008b\u0003\u008c\u0003\u008d\u0003\u008e\u0003\u008f\u0003\u0090\u0003\u0091\u0003\u0092\u0003\u0093\u0003\u0094\u0003\u0095\u0003\u0096\u0003B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010ö\u0002\u001a\u00020\u0002H\u0016J\t\u0010÷\u0002\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0019\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0018\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0017R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0013\u0010\"\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u000bR\u0013\u0010$\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u000bR\u0015\u0010&\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010!\u001a\u0004\b'\u0010 R\u0013\u0010(\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u000bR\u001e\u0010*\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u001b\u001a\u0004\b-\u0010.R\u0013\u0010/\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u000bR\u0015\u00101\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b2\u0010\u0017R\u0015\u00103\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b4\u0010\u0017R\u0015\u00105\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\b5\u00107R \u00109\u001a\u0004\u0018\u0001068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00108\u0012\u0004\b:\u0010\u001b\u001a\u0004\b9\u00107R\u0015\u0010;\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\b;\u00107R\u0015\u0010<\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\b<\u00107R\u0015\u0010=\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\b=\u00107R\u0013\u0010>\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u000bR\u0013\u0010@\u001a\u0004\u0018\u00010A¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0015\u0010D\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\bD\u00107R\u0013\u0010E\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u000bR\u0013\u0010G\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u000bR \u0010I\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0018\u0012\u0004\bJ\u0010\u001b\u001a\u0004\bK\u0010\u0017R\u0015\u0010L\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\bL\u00107R\u0013\u0010M\u001a\u0004\u0018\u00010N¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0015\u0010Q\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\bR\u00107R\u0013\u0010S\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\u000bR\u0015\u0010U\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\bU\u00107R\u0015\u0010V\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\bV\u00107R\u0013\u0010W\u001a\u0004\u0018\u00010X¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0013\u0010[\u001a\u0004\u0018\u00010\\¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u0013\u0010_\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b`\u0010\u000bR\u0015\u0010a\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\bb\u0010\u0017R\u0015\u0010c\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\bc\u00107R\u0015\u0010d\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\bd\u00107R\u0015\u0010e\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\be\u00107R\u0015\u0010f\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\bf\u00107R\u0015\u0010g\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\bh\u0010\u0017R\u0013\u0010i\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bj\u0010\u000bR\u0015\u0010k\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\bl\u0010\u0017R\u0015\u0010m\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\bn\u0010\u0017R\u0015\u0010o\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\bp\u0010\u0017R\u0015\u0010q\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\br\u0010\u0017R\u0015\u0010s\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\bs\u00107R\u0015\u0010t\u001a\u0004\u0018\u000106¢\u0006\n\n\u0002\u00108\u001a\u0004\bu\u00107R\u0013\u0010v\u001a\u0004\u0018\u00010w¢\u0006\b\n\u0000\u001a\u0004\bx\u0010yR\u0013\u0010z\u001a\u0004\u0018\u00010{¢\u0006\b\n\u0000\u001a\u0004\b|\u0010}R\u0013\u0010~\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010\u000bR\u0017\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u000b\n\u0002\u0010\u0018\u001a\u0005\b\u0081\u0001\u0010\u0017R#\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u0012\n\u0002\u0010\u0018\u0012\u0005\b\u0083\u0001\u0010\u001b\u001a\u0005\b\u0084\u0001\u0010\u0017R#\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u0012\n\u0002\u0010\u0018\u0012\u0005\b\u0086\u0001\u0010\u001b\u001a\u0005\b\u0087\u0001\u0010\u0017R\u0017\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u000b\n\u0002\u0010\u0018\u001a\u0005\b\u0089\u0001\u0010\u0017R\u0017\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u000b\n\u0002\u0010\u0018\u001a\u0005\b\u008b\u0001\u0010\u0017R\u0017\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u000b\n\u0002\u0010\u0018\u001a\u0005\b\u008d\u0001\u0010\u0017R\u0017\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u000b\n\u0002\u0010\u0018\u001a\u0005\b\u008f\u0001\u0010\u0017R\u0015\u0010\u0090\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b\u0091\u0001\u0010\u000bR\u0017\u0010\u0092\u0001\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b\u0093\u0001\u00107R\u0015\u0010\u0094\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b\u0095\u0001\u0010\u000bR\u0017\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u000b\n\u0002\u0010\u0018\u001a\u0005\b\u0097\u0001\u0010\u0017R\u001a\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u0001¢\u0006\r\n\u0003\u0010\u009c\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0017\u0010\u009d\u0001\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b\u009d\u0001\u00107R\u0017\u0010\u009e\u0001\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b\u009e\u0001\u00107R\u0017\u0010\u009f\u0001\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b\u009f\u0001\u00107R\u0017\u0010 \u0001\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b \u0001\u00107R\u0017\u0010¡\u0001\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b¡\u0001\u00107R\u0017\u0010¢\u0001\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b¢\u0001\u00107R\u0017\u0010£\u0001\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b£\u0001\u00107R\u0017\u0010¤\u0001\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b¤\u0001\u00107R\u0017\u0010¥\u0001\u001a\u0005\u0018\u00010¦\u0001¢\u0006\n\n\u0000\u001a\u0006\b§\u0001\u0010¨\u0001R\u0017\u0010©\u0001\u001a\u0005\u0018\u00010ª\u0001¢\u0006\n\n\u0000\u001a\u0006\b«\u0001\u0010¬\u0001R\u0017\u0010\u00ad\u0001\u001a\u0005\u0018\u00010®\u0001¢\u0006\n\n\u0000\u001a\u0006\b¯\u0001\u0010°\u0001R\u0017\u0010±\u0001\u001a\u0005\u0018\u00010®\u0001¢\u0006\n\n\u0000\u001a\u0006\b²\u0001\u0010°\u0001R\u0017\u0010³\u0001\u001a\u0005\u0018\u00010´\u0001¢\u0006\n\n\u0000\u001a\u0006\bµ\u0001\u0010¶\u0001R\u0017\u0010·\u0001\u001a\u0005\u0018\u00010¸\u0001¢\u0006\n\n\u0000\u001a\u0006\b¹\u0001\u0010º\u0001R\u0017\u0010»\u0001\u001a\u0005\u0018\u00010¼\u0001¢\u0006\n\n\u0000\u001a\u0006\b½\u0001\u0010¾\u0001R\u0017\u0010¿\u0001\u001a\u0005\u0018\u00010À\u0001¢\u0006\n\n\u0000\u001a\u0006\bÁ\u0001\u0010Â\u0001R\u0017\u0010Ã\u0001\u001a\u0005\u0018\u00010Ä\u0001¢\u0006\n\n\u0000\u001a\u0006\bÅ\u0001\u0010Æ\u0001R\u0017\u0010Ç\u0001\u001a\u0005\u0018\u00010È\u0001¢\u0006\n\n\u0000\u001a\u0006\bÉ\u0001\u0010Ê\u0001R\u0017\u0010Ë\u0001\u001a\u0005\u0018\u00010Ì\u0001¢\u0006\n\n\u0000\u001a\u0006\bÍ\u0001\u0010Î\u0001R\u0017\u0010Ï\u0001\u001a\u0005\u0018\u00010Ð\u0001¢\u0006\n\n\u0000\u001a\u0006\bÑ\u0001\u0010Ò\u0001R\u0017\u0010Ó\u0001\u001a\u0005\u0018\u00010Ô\u0001¢\u0006\n\n\u0000\u001a\u0006\bÕ\u0001\u0010Ö\u0001R\u0017\u0010×\u0001\u001a\u0005\u0018\u00010Ø\u0001¢\u0006\n\n\u0000\u001a\u0006\bÙ\u0001\u0010Ú\u0001R\u0017\u0010Û\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u000b\n\u0002\u0010\u0018\u001a\u0005\bÜ\u0001\u0010\u0017R\u0017\u0010Ý\u0001\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\bÞ\u0001\u00107R\u0015\u0010ß\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bà\u0001\u0010\u000bR\u0015\u0010á\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bâ\u0001\u0010\u000bR\u001c\u0010ã\u0001\u001a\n\u0012\u0005\u0012\u00030å\u00010ä\u0001¢\u0006\n\n\u0000\u001a\u0006\bæ\u0001\u0010ç\u0001R\u0017\u0010è\u0001\u001a\u0004\u0018\u00010\u001e¢\u0006\u000b\n\u0002\u0010!\u001a\u0005\bé\u0001\u0010 R\u0017\u0010ê\u0001\u001a\u0004\u0018\u00010\u001e¢\u0006\u000b\n\u0002\u0010!\u001a\u0005\bë\u0001\u0010 R\u0017\u0010ì\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u000b\n\u0002\u0010\u0018\u001a\u0005\bí\u0001\u0010\u0017R\u0015\u0010î\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bï\u0001\u0010\u000bR\u0017\u0010ð\u0001\u001a\u0005\u0018\u00010ñ\u0001¢\u0006\n\n\u0000\u001a\u0006\bò\u0001\u0010ó\u0001R\u0017\u0010ô\u0001\u001a\u0004\u0018\u00010\u001e¢\u0006\u000b\n\u0002\u0010!\u001a\u0005\bõ\u0001\u0010 R\u0017\u0010ö\u0001\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\bö\u0001\u00107R\u0015\u0010÷\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bø\u0001\u0010\u000bR\u0017\u0010ù\u0001\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\bù\u0001\u00107R\u0017\u0010ú\u0001\u001a\u0004\u0018\u00010\u001e¢\u0006\u000b\n\u0002\u0010!\u001a\u0005\bû\u0001\u0010 R\u0015\u0010ü\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bý\u0001\u0010\u000bR\u0017\u0010þ\u0001\u001a\u0005\u0018\u00010ÿ\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0080\u0002\u0010\u0081\u0002R!\u0010\u0082\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0083\u0002¢\u0006\n\n\u0000\u001a\u0006\b\u0084\u0002\u0010\u0085\u0002R\u001c\u0010\u0086\u0002\u001a\n\u0012\u0005\u0012\u00030\u0087\u00020ä\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0088\u0002\u0010ç\u0001R\"\u0010\u0089\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0005\u0012\u00030\u008a\u00020\u0083\u0002¢\u0006\n\n\u0000\u001a\u0006\b\u008b\u0002\u0010\u0085\u0002R\u001c\u0010\u008c\u0002\u001a\n\u0012\u0005\u0012\u00030\u0087\u00020ä\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u008d\u0002\u0010ç\u0001R\u0017\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u008f\u0002¢\u0006\n\n\u0000\u001a\u0006\b\u0090\u0002\u0010\u0091\u0002R\u0017\u0010\u0092\u0002\u001a\u0004\u0018\u00010\u001e¢\u0006\u000b\n\u0002\u0010!\u001a\u0005\b\u0093\u0002\u0010 R\u0017\u0010\u0094\u0002\u001a\u0004\u0018\u00010\u001e¢\u0006\u000b\n\u0002\u0010!\u001a\u0005\b\u0095\u0002\u0010 R\u0017\u0010\u0096\u0002\u001a\u0005\u0018\u00010\u0097\u0002¢\u0006\n\n\u0000\u001a\u0006\b\u0098\u0002\u0010\u0099\u0002R\u0017\u0010\u009a\u0002\u001a\u0004\u0018\u00010\u0015¢\u0006\u000b\n\u0002\u0010\u0018\u001a\u0005\b\u009b\u0002\u0010\u0017R\u0015\u0010\u009c\u0002\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b\u009d\u0002\u0010\u000bR\u0017\u0010\u009e\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b\u009f\u0002\u00107R\u0017\u0010 \u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b¡\u0002\u00107R\u0017\u0010¢\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b¢\u0002\u00107R\u0017\u0010£\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b£\u0002\u00107R\u0017\u0010¤\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b¤\u0002\u00107R\u0017\u0010¥\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b¥\u0002\u00107R\u0015\u0010¦\u0002\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b§\u0002\u0010\u000bR\u0017\u0010¨\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b¨\u0002\u00107R\u0017\u0010©\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b©\u0002\u00107R\u0017\u0010ª\u0002\u001a\u0005\u0018\u00010«\u0002¢\u0006\n\n\u0000\u001a\u0006\b¬\u0002\u0010\u00ad\u0002R\u001c\u0010®\u0002\u001a\n\u0012\u0005\u0012\u00030¯\u00020ä\u0001¢\u0006\n\n\u0000\u001a\u0006\b°\u0002\u0010ç\u0001R\u0017\u0010±\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b±\u0002\u00107R\u0017\u0010²\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b³\u0002\u00107R\u0015\u0010´\u0002\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bµ\u0002\u0010\u000bR\u001b\u0010¶\u0002\u001a\t\u0012\u0004\u0012\u00020\t0ä\u0001¢\u0006\n\n\u0000\u001a\u0006\b·\u0002\u0010ç\u0001R\u0017\u0010¸\u0002\u001a\u0004\u0018\u00010\u0015¢\u0006\u000b\n\u0002\u0010\u0018\u001a\u0005\b¹\u0002\u0010\u0017R\u0017\u0010º\u0002\u001a\u0005\u0018\u00010»\u0002¢\u0006\n\n\u0000\u001a\u0006\b¼\u0002\u0010½\u0002R\u0017\u0010¾\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\b¾\u0002\u00107R\u0017\u0010¿\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\bÀ\u0002\u00107R\u0017\u0010Á\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\bÁ\u0002\u00107R\u0017\u0010Â\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\bÂ\u0002\u00107R\u0017\u0010Ã\u0002\u001a\u0005\u0018\u00010Ä\u0002¢\u0006\n\n\u0000\u001a\u0006\bÅ\u0002\u0010Æ\u0002R\u0017\u0010Ç\u0002\u001a\u0005\u0018\u00010È\u0002¢\u0006\n\n\u0000\u001a\u0006\bÉ\u0002\u0010Ê\u0002R\u0015\u0010Ë\u0002\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bÌ\u0002\u0010\u000bR\u0017\u0010Í\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\bÎ\u0002\u00107R\u0017\u0010Ï\u0002\u001a\u0005\u0018\u00010Ð\u0002¢\u0006\n\n\u0000\u001a\u0006\bÑ\u0002\u0010Ò\u0002R\u0017\u0010Ó\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\bÔ\u0002\u00107R\u0017\u0010Õ\u0002\u001a\u0005\u0018\u00010Ö\u0002¢\u0006\n\n\u0000\u001a\u0006\b×\u0002\u0010Ø\u0002R\u0017\u0010Ù\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\bÙ\u0002\u00107R\u0017\u0010Ú\u0002\u001a\u0005\u0018\u00010Û\u0002¢\u0006\n\n\u0000\u001a\u0006\bÜ\u0002\u0010Ý\u0002R\u001c\u0010Þ\u0002\u001a\n\u0012\u0005\u0012\u00030ß\u00020ä\u0001¢\u0006\n\n\u0000\u001a\u0006\bà\u0002\u0010ç\u0001R\u0017\u0010á\u0002\u001a\u0004\u0018\u00010\u001e¢\u0006\u000b\n\u0002\u0010!\u001a\u0005\bâ\u0002\u0010 R\u0017\u0010ã\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\bã\u0002\u00107R\u0017\u0010ä\u0002\u001a\u0005\u0018\u00010å\u0002¢\u0006\n\n\u0000\u001a\u0006\bæ\u0002\u0010ç\u0002R\u0017\u0010è\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\bé\u0002\u00107R\u0017\u0010ê\u0002\u001a\u0004\u0018\u000106¢\u0006\u000b\n\u0002\u00108\u001a\u0005\bë\u0002\u00107R\u0015\u0010ì\u0002\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bí\u0002\u0010\u000bR\u0015\u0010î\u0002\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bï\u0002\u0010\u000bR\u0015\u0010ð\u0002\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bñ\u0002\u0010\u000bR\u0017\u0010ò\u0002\u001a\u0005\u0018\u00010ó\u0002¢\u0006\n\n\u0000\u001a\u0006\bô\u0002\u0010õ\u0002¨\u0006\u0097\u0003"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "type", "Lcom/lark/kmp/pb/basic/v1/Chat$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/Chat$Type;", "name", "getName", "last_message_id", "getLast_message_id", "last_message_position", "", "getLast_message_position", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "new_message_count", "getNew_message_count$annotations", "()V", "getNew_message_count", "update_time", "", "getUpdate_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "avatar_key", "getAvatar_key", "chatter_id", "getChatter_id", "create_time", "getCreate_time", "description", "getDescription", "avatar", "Lcom/lark/kmp/pb/basic/v1/Image;", "getAvatar$annotations", "getAvatar", "()Lcom/lark/kmp/pb/basic/v1/Image;", "owner_id", "getOwner_id", "chatter_count", "getChatter_count", "user_count", "getUser_count", "is_department", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_public", "is_public$annotations", "is_archived", "is_deleted", "is_remind", "name_pinyin", "getName_pinyin", "role", "Lcom/lark/kmp/pb/basic/v1/Chat$Role;", "getRole", "()Lcom/lark/kmp/pb/basic/v1/Chat$Role;", "is_customer_service", "text_draft_id", "getText_draft_id", "post_draft_id", "getPost_draft_id", "no_badged_new_message_count", "getNo_badged_new_message_count$annotations", "getNo_badged_new_message_count", "is_shortcut", "announcement", "Lcom/lark/kmp/pb/basic/v1/Chat$Announcement;", "getAnnouncement", "()Lcom/lark/kmp/pb/basic/v1/Chat$Announcement;", "off_edit_group_chat_info", "getOff_edit_group_chat_info", "tenant_id", "getTenant_id", "is_custom_icon", "is_dissolved", "message_position", "Lcom/lark/kmp/pb/basic/v1/Chat$MessagePosition$Enum;", "getMessage_position", "()Lcom/lark/kmp/pb/basic/v1/Chat$MessagePosition$Enum;", "feed_type", "Lcom/lark/kmp/pb/basic/v1/FeedCard$FeedType;", "getFeed_type", "()Lcom/lark/kmp/pb/basic/v1/FeedCard$FeedType;", "last_visible_message_id", "getLast_visible_message_id", "burn_life", "getBurn_life", "is_crypto", "is_meeting", "is_cross_tenant", "is_support_view", "first_message_position", "getFirst_message_position", "oncall_id", "getOncall_id", "last_visible_message_position", "getLast_visible_message_position", "read_position", "getRead_position", "read_position_badge_count", "getRead_position_badge_count", "last_message_position_badge_count", "getLast_message_position_badge_count", "is_public_v2", "allow_post", "getAllow_post", "post_type", "Lcom/lark/kmp/pb/basic/v1/Chat$PostType;", "getPost_type", "()Lcom/lark/kmp/pb/basic/v1/Chat$PostType;", "chat_mode", "Lcom/lark/kmp/pb/basic/v1/Chat$ChatMode;", "getChat_mode", "()Lcom/lark/kmp/pb/basic/v1/Chat$ChatMode;", "last_thread_id", "getLast_thread_id", "last_thread_position", "getLast_thread_position", "new_thread_count", "getNew_thread_count$annotations", "getNew_thread_count", "no_badged_new_thread_count", "getNo_badged_new_thread_count$annotations", "getNo_badged_new_thread_count", "last_thread_position_badge_count", "getLast_thread_position_badge_count", "read_thread_position", "getRead_thread_position", "read_thread_position_badge_count", "getRead_thread_position_badge_count", "last_visible_thread_position", "getLast_visible_thread_position", "last_visible_thread_id", "getLast_visible_thread_id", "show_nickname", "getShow_nickname", "last_draft_id", "getLast_draft_id", "last_read_position", "getLast_read_position", "last_read_offset", "", "getLast_read_offset", "()Ljava/lang/Float;", "Ljava/lang/Float;", "is_edu", "is_admin", "is_mute_at_all", "is_delayed", "is_p2p_ai", "is_ocic_customer_service", "is_p2p_official_bot_ai", "is_temp_top_feed", "add_member_permission", "Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberPermission$Enum;", "getAdd_member_permission", "()Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberPermission$Enum;", "at_all_permission", "Lcom/lark/kmp/pb/basic/v1/Chat$AtAllPermission$Enum;", "getAt_all_permission", "()Lcom/lark/kmp/pb/basic/v1/Chat$AtAllPermission$Enum;", "join_message_visible", "Lcom/lark/kmp/pb/basic/v1/Chat$SystemMessageVisible$Enum;", "getJoin_message_visible", "()Lcom/lark/kmp/pb/basic/v1/Chat$SystemMessageVisible$Enum;", "quit_message_visible", "getQuit_message_visible", "share_card_permission", "Lcom/lark/kmp/pb/basic/v1/Chat$ShareCardPermission$Enum;", "getShare_card_permission", "()Lcom/lark/kmp/pb/basic/v1/Chat$ShareCardPermission$Enum;", "add_member_apply", "Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberApply$Enum;", "getAdd_member_apply", "()Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberApply$Enum;", "message_visibility_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$MessageVisibilitySetting$Enum;", "getMessage_visibility_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$MessageVisibilitySetting$Enum;", "create_urgent_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$CreateUrgentSetting$Enum;", "getCreate_urgent_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$CreateUrgentSetting$Enum;", "create_video_conference_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$CreateVideoConferenceSetting$Enum;", "getCreate_video_conference_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$CreateVideoConferenceSetting$Enum;", "pin_permission_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$PinPermissionSetting$Enum;", "getPin_permission_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$PinPermissionSetting$Enum;", "top_notice_permission_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$TopNoticePermissionSetting$Enum;", "getTop_notice_permission_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$TopNoticePermissionSetting$Enum;", "chat_tab_permission_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$ChatTabPermissionSetting$Enum;", "getChat_tab_permission_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$ChatTabPermissionSetting$Enum;", "chat_display_mode_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$ChatDisplayModeSetting$Enum;", "getChat_display_mode_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$ChatDisplayModeSetting$Enum;", "chat_pin_permission_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$ChatPinPermissionSetting$Enum;", "getChat_pin_permission_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$ChatPinPermissionSetting$Enum;", "put_chatter_apply_count", "getPut_chatter_apply_count", "show_banner", "getShow_banner", "mini_avatar_key", "getMini_avatar_key", "sidebar_id", "getSidebar_id", "sidebar_buttons", "", "Lcom/lark/kmp/pb/basic/v1/SideBarButton;", "getSidebar_buttons", "()Ljava/util/List;", "my_threads_read_timestamp", "getMy_threads_read_timestamp", "my_threads_last_timestamp", "getMy_threads_last_timestamp", "my_threads_unread_count", "getMy_threads_unread_count", "my_threads_last_display_message_id", "getMy_threads_last_display_message_id", "anonymous_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$AnonymousSetting$Enum;", "getAnonymous_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$AnonymousSetting$Enum;", "anonymous_total_quota", "getAnonymous_total_quota", "is_cross_with_ka", "anonymous_id", "getAnonymous_id", "is_team", "team_id", "getTeam_id", "team_name", "getTeam_name", "team_chat_type", "Lcom/lark/kmp/pb/basic/v1/TeamChatType;", "getTeam_chat_type", "()Lcom/lark/kmp/pb/basic/v1/TeamChatType;", "chatter_extra_states", "", "getChatter_extra_states", "()Ljava/util/Map;", "joined_team_infos", "Lcom/lark/kmp/pb/basic/v1/ChatTeamInfo;", "getJoined_team_infos", "joined_teams", "Lcom/lark/kmp/pb/basic/v1/Team;", "getJoined_teams", "bound_team_infos", "getBound_team_infos", "user_auto_mute", "Lcom/lark/kmp/pb/basic/v1/ChatUserAutoMuteSetting;", "getUser_auto_mute", "()Lcom/lark/kmp/pb/basic/v1/ChatUserAutoMuteSetting;", "ai_knowledge_query_id", "getAi_knowledge_query_id", "query_create_time", "getQuery_create_time", "query_status", "Lcom/lark/kmp/pb/basic/v1/CommonAIReply$Status;", "getQuery_status", "()Lcom/lark/kmp/pb/basic/v1/CommonAIReply$Status;", "query_seq_id", "getQuery_seq_id", "edit_message_draft_id", "getEdit_message_draft_id", "chatable", "getChatable", "muteable", "getMuteable", "is_super", "is_private_mode", "is_tenant", "is_in_box", "box_id", "getBox_id", "is_auto_translate", "is_auto_typing_translate", "typing_translate_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$TypingTranslateSetting;", "getTyping_translate_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$TypingTranslateSetting;", "feed_tag", "Lcom/lark/kmp/pb/basic/v1/FeedTag;", "getFeed_tag", "is_flag", "has_water_mark", "getHas_water_mark", "avatar_path", "getAvatar_path", "avatar_urls", "getAvatar_urls", "first_chat_message_position", "getFirst_chat_message_position", "tag_info", "Lcom/lark/kmp/pb/basic/v1/TagData;", "getTag_info", "()Lcom/lark/kmp/pb/basic/v1/TagData;", "is_fake", "typing_translate_has_auto_opened", "getTyping_translate_has_auto_opened", "is_official_oncall", "is_offline_oncall", "restricted_mode_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting;", "getRestricted_mode_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting;", "def_display_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$DefDisplaySetting$Enum;", "getDef_display_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$DefDisplaySetting$Enum;", "schedule_message_draft_id", "getSchedule_message_draft_id", "has_vc_chat_permission", "getHas_vc_chat_permission", "admin_post_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$AdminPostSetting$Enum;", "getAdmin_post_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$AdminPostSetting$Enum;", "can_be_sorted_alphabetically", "getCan_be_sorted_alphabetically", "user_count_visible_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$UserCountVisibleSetting$Enum;", "getUser_count_visible_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$UserCountVisibleSetting$Enum;", "is_user_count_visible", "doubao_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$DoubaoSetting;", "getDoubao_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$DoubaoSetting;", "tags", "Lcom/lark/kmp/pb/basic/v1/Tag;", "getTags", "theme_id", "getTheme_id", "is_frozen", "banner_setting", "Lcom/lark/kmp/pb/basic/v1/BannerSetting;", "getBanner_setting", "()Lcom/lark/kmp/pb/basic/v1/BannerSetting;", "can_translate_name", "getCan_translate_name", "should_display_translated_name", "getShould_display_translated_name", "translated_name", "getTranslated_name", "name_major_language", "getName_major_language", "name_translate_language", "getName_translate_language", "tns_info", "Lcom/lark/kmp/pb/basic/v1/Chat$TnsInfo;", "getTns_info", "()Lcom/lark/kmp/pb/basic/v1/Chat$TnsInfo;", "newBuilder", "toString", "Builder", "Companion", "Type", "Role", "Announcement", "MessagePosition", "PostType", "ChatMode", "AddMemberPermission", "AtAllPermission", "AddMemberApply", "SystemMessageVisible", "ShareCardPermission", "AnonymousSetting", "MessageVisibilitySetting", "CreateUrgentSetting", "CreateVideoConferenceSetting", "PinPermissionSetting", "TopNoticePermissionSetting", "ChatTabPermissionSetting", "ChatDisplayModeSetting", "TypingTranslateSetting", "WidgetState", "WhiteListSetting", "RestrictedModeSetting", "DefDisplaySetting", "AdminPostSetting", "ChatPinPermissionSetting", "UserCountVisibleSetting", "DoubaoSetting", "TnsInfo", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
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
    private final String id;
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

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberApply;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberApply$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberApply$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class AddMemberApply extends com.lark.wire.Message<AddMemberApply, a> {
        public static final ProtoAdapter<AddMemberApply> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberApply$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "NO_APPLY", "NEED_APPLY", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final b Companion = null;
            public static final Enum NEED_APPLY = null;
            public static final Enum NO_APPLY = null;
            public static final Enum UNKNOWN = null;
            public static final /* synthetic */ Enum[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Enum.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return Enum.NEED_APPLY;
                L15:
                    return Enum.NO_APPLY;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r1, Syntax r2, Enum r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return b;
            }

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("NO_APPLY", 1, 1);
                NO_APPLY = r1;
                Enum r3 = new Enum("NEED_APPLY", 2, 2);
                NEED_APPLY = r3;
                Enum[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r0);
            }

            public static Enum[] values() {
                return (Enum[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return NEED_APPLY;
            L15:
                return NO_APPLY;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) r27.a.a(Enum.class, r1);
            }

            public Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
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
            public final AddMemberApply c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new AddMemberApply(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(AddMemberApply r2) {
                AddMemberApply r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, AddMemberApply r3) {
                AddMemberApply r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, AddMemberApply r3) {
                AddMemberApply r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<AddMemberApply> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chat.AddMemberApply", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ AddMemberApply(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AddMemberApply.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(AddMemberApply.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public AddMemberApply(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ AddMemberApply(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberPermission;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberPermission$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberPermission$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class AddMemberPermission extends com.lark.wire.Message<AddMemberPermission, a> {
        public static final ProtoAdapter<AddMemberPermission> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$AddMemberPermission$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "ONLY_OWNER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final b Companion = null;
            public static final Enum ONLY_OWNER = null;
            public static final Enum UNKNOWN = null;
            public static final /* synthetic */ Enum[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Enum.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return Enum.ONLY_OWNER;
                L15:
                    return Enum.ALL_MEMBERS;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r1, Syntax r2, Enum r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return b;
            }

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Enum r3 = new Enum("ONLY_OWNER", 2, 2);
                ONLY_OWNER = r3;
                Enum[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r0);
            }

            public static Enum[] values() {
                return (Enum[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return ONLY_OWNER;
            L15:
                return ALL_MEMBERS;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) r27.a.a(Enum.class, r1);
            }

            public Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
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
            public final AddMemberPermission c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new AddMemberPermission(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(AddMemberPermission r2) {
                AddMemberPermission r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, AddMemberPermission r3) {
                AddMemberPermission r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, AddMemberPermission r3) {
                AddMemberPermission r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<AddMemberPermission> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chat.AddMemberPermission", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ AddMemberPermission(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AddMemberPermission.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(AddMemberPermission.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public AddMemberPermission(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ AddMemberPermission(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$AdminPostSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$AdminPostSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$AdminPostSetting$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class AdminPostSetting extends com.lark.wire.Message<AdminPostSetting, a> {
        public static final ProtoAdapter<AdminPostSetting> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$AdminPostSetting$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALLOW_POST", "BANNED_POST", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALLOW_POST = null;
            public static final Enum BANNED_POST = null;
            public static final b Companion = null;
            public static final Enum UNKNOWN = null;
            public static final /* synthetic */ Enum[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Enum.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return Enum.BANNED_POST;
                L15:
                    return Enum.ALLOW_POST;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r1, Syntax r2, Enum r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return b;
            }

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALLOW_POST", 1, 1);
                ALLOW_POST = r1;
                Enum r3 = new Enum("BANNED_POST", 2, 2);
                BANNED_POST = r3;
                Enum[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r0);
            }

            public static Enum[] values() {
                return (Enum[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return BANNED_POST;
            L15:
                return ALLOW_POST;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) r27.a.a(Enum.class, r1);
            }

            public Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
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
            public final AdminPostSetting c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new AdminPostSetting(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(AdminPostSetting r2) {
                AdminPostSetting r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, AdminPostSetting r3) {
                AdminPostSetting r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, AdminPostSetting r3) {
                AdminPostSetting r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<AdminPostSetting> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chat.AdminPostSetting", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ AdminPostSetting(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AdminPostSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(AdminPostSetting.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public AdminPostSetting(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ AdminPostSetting(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001e\u001fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000bR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018¨\u0006 "}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$Announcement;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$Announcement$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$Announcement$Builder;Lokio/ByteString;)V", "content", "", "getContent", "()Ljava/lang/String;", "update_time", "", "getUpdate_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "last_editor_id", "getLast_editor_id", "doc_url", "getDoc_url", "enable_open_doc", "", "getEnable_open_doc", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "use_opendoc", "getUse_opendoc", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
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
            public String d;
            public Long e;
            public String f;
            public String g;
            public Boolean h;
            public Boolean i;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Announcement(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Announcement> {
            @Override // com.lark.wire.ProtoAdapter
            public final Announcement c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L14;
                switch(r4) {
                    case 1: goto L12;
                    case 2: goto L11;
                    case 3: goto L10;
                    case 4: goto L9;
                    case 5: goto L8;
                    case 6: goto L7;
                    default: goto L6;
                };
            L7:
                r1.i = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L8:
                r1.h = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L9:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.g = r7.i();
                goto L3
            L10:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.f = r7.i();
                goto L3
            L11:
                r1.e = (Long) ProtoAdapter.k.c(r7);
                goto L3
            L12:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.i();
                goto L3
            L6:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L14:
                return new Announcement(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Announcement r6) {
                Announcement r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size();
                w r1 = ProtoAdapter.q;
                int r2 = (((r0 + r1.l(1, r7.getContent())) + ProtoAdapter.k.l(2, r7.getUpdate_time())) + r1.l(3, r7.getLast_editor_id())) + r1.l(4, r7.getDoc_url());
                l r3 = ProtoAdapter.g;
                return (r2 + r3.l(5, r7.getEnable_open_doc())) + r3.l(6, r7.getUse_opendoc());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, Announcement r6) {
                Announcement r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r5, 1, r7.getContent());
                ProtoAdapter.k.i(r5, 2, r7.getUpdate_time());
                r0.i(r5, 3, r7.getLast_editor_id());
                r0.i(r5, 4, r7.getDoc_url());
                l r1 = ProtoAdapter.g;
                r1.i(r5, 5, r7.getEnable_open_doc());
                r1.i(r5, 6, r7.getUse_opendoc());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, Announcement r6) {
                Announcement r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                l r0 = ProtoAdapter.g;
                r0.j(r5, 6, r7.getUse_opendoc());
                r0.j(r5, 5, r7.getEnable_open_doc());
                w r1 = ProtoAdapter.q;
                r1.j(r5, 4, r7.getDoc_url());
                r1.j(r5, 3, r7.getLast_editor_id());
                ProtoAdapter.k.j(r5, 2, r7.getUpdate_time());
                r1.j(r5, 1, r7.getContent());
            }

            public b(FieldEncoding r7, KClass<Announcement> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chat.Announcement", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Announcement(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Announcement.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.content;
            r0.e = this.update_time;
            r0.f = this.last_editor_id;
            r0.g = this.doc_url;
            r0.h = this.enable_open_doc;
            r0.i = this.use_opendoc;
            r0.a(unknownFields());
            return r0;
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

        public Announcement(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.content = r2.d;
            this.update_time = r2.e;
            this.last_editor_id = r2.f;
            this.doc_url = r2.g;
            this.enable_open_doc = r2.h;
            this.use_opendoc = r2.i;
        }

        public /* synthetic */ Announcement(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$AnonymousSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$AnonymousSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$AnonymousSetting$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class AnonymousSetting extends com.lark.wire.Message<AnonymousSetting, a> {
        public static final ProtoAdapter<AnonymousSetting> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$AnonymousSetting$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "INVISIBLE", "NOT_ALLOWED", "ALLOWED", "INVISIBLE_ALLOWED", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALLOWED = null;
            public static final b Companion = null;
            public static final Enum INVISIBLE = null;
            public static final Enum INVISIBLE_ALLOWED = null;
            public static final Enum NOT_ALLOWED = null;
            public static final Enum UNKNOWN = null;
            public static final /* synthetic */ Enum[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Enum.Companion.getClass();
                    return b.a(r2);
                }

                public a(KClass<Enum> r1, Syntax r2, Enum r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }

                @JvmStatic
                public static Enum a(int r1) {
                    if (r1 == 0) goto L17;
                    if (r1 == 1) goto L22;
                    if (r1 == 2) goto L21;
                    if (r1 == 3) goto L20;
                    if (r1 == 100) goto L19;
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
            public static final Enum fromValue(int r1) {
                Companion.getClass();
                return b.a(r1);
            }

            public static EnumEntries<Enum> getEntries() {
                return b;
            }

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("INVISIBLE", 1, 1);
                INVISIBLE = r1;
                Enum r3 = new Enum("NOT_ALLOWED", 2, 2);
                NOT_ALLOWED = r3;
                Enum r5 = new Enum("ALLOWED", 3, 3);
                ALLOWED = r5;
                Enum r7 = new Enum("INVISIBLE_ALLOWED", 4, 100);
                INVISIBLE_ALLOWED = r7;
                Enum[] r9 = {r0, r1, r3, r5, r7};
                a = r9;
                b = EnumEntriesKt.enumEntries(r9);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r0);
            }

            public static Enum[] values() {
                return (Enum[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            public static Enum valueOf(String r1) {
                return (Enum) r27.a.a(Enum.class, r1);
            }

            public Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
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
            public final AnonymousSetting c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new AnonymousSetting(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(AnonymousSetting r2) {
                AnonymousSetting r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, AnonymousSetting r3) {
                AnonymousSetting r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, AnonymousSetting r3) {
                AnonymousSetting r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<AnonymousSetting> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chat.AnonymousSetting", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ AnonymousSetting(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AnonymousSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(AnonymousSetting.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public AnonymousSetting(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ AnonymousSetting(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$AtAllPermission;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$AtAllPermission$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$AtAllPermission$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class AtAllPermission extends com.lark.wire.Message<AtAllPermission, a> {
        public static final ProtoAdapter<AtAllPermission> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$AtAllPermission$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "ONLY_OWNER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final b Companion = null;
            public static final Enum ONLY_OWNER = null;
            public static final Enum UNKNOWN = null;
            public static final /* synthetic */ Enum[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Enum.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return Enum.ONLY_OWNER;
                L15:
                    return Enum.ALL_MEMBERS;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r1, Syntax r2, Enum r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return b;
            }

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Enum r3 = new Enum("ONLY_OWNER", 2, 2);
                ONLY_OWNER = r3;
                Enum[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r0);
            }

            public static Enum[] values() {
                return (Enum[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return ONLY_OWNER;
            L15:
                return ALL_MEMBERS;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) r27.a.a(Enum.class, r1);
            }

            public Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
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
            public final AtAllPermission c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new AtAllPermission(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(AtAllPermission r2) {
                AtAllPermission r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, AtAllPermission r3) {
                AtAllPermission r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, AtAllPermission r3) {
                AtAllPermission r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<AtAllPermission> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chat.AtAllPermission", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ AtAllPermission(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AtAllPermission.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(AtAllPermission.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public AtAllPermission(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ AtAllPermission(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$ChatDisplayModeSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$ChatDisplayModeSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$ChatDisplayModeSetting$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ChatDisplayModeSetting extends com.lark.wire.Message<ChatDisplayModeSetting, a> {
        public static final ProtoAdapter<ChatDisplayModeSetting> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$ChatDisplayModeSetting$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DEFAULT", "THREAD", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final b Companion = null;
            public static final Enum DEFAULT = null;
            public static final Enum THREAD = null;
            public static final Enum UNKNOWN = null;
            public static final /* synthetic */ Enum[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Enum.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return Enum.THREAD;
                L15:
                    return Enum.DEFAULT;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r1, Syntax r2, Enum r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return b;
            }

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("DEFAULT", 1, 1);
                DEFAULT = r1;
                Enum r3 = new Enum("THREAD", 2, 2);
                THREAD = r3;
                Enum[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r0);
            }

            public static Enum[] values() {
                return (Enum[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return THREAD;
            L15:
                return DEFAULT;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) r27.a.a(Enum.class, r1);
            }

            public Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
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
            public final ChatDisplayModeSetting c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new ChatDisplayModeSetting(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ChatDisplayModeSetting r2) {
                ChatDisplayModeSetting r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, ChatDisplayModeSetting r3) {
                ChatDisplayModeSetting r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, ChatDisplayModeSetting r3) {
                ChatDisplayModeSetting r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<ChatDisplayModeSetting> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chat.ChatDisplayModeSetting", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ChatDisplayModeSetting(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ChatDisplayModeSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ChatDisplayModeSetting.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ChatDisplayModeSetting(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ ChatDisplayModeSetting(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$ChatMode;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DEFAULT", "THREAD", "THREAD_V2", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum ChatMode extends Enum<ChatMode> implements o0 {
        public static final ProtoAdapter<ChatMode> ADAPTER = null;
        public static final b Companion = null;
        public static final ChatMode DEFAULT = null;

        @Deprecated(message = "THREAD is deprecated")
        public static final ChatMode THREAD = null;
        public static final ChatMode THREAD_V2 = null;
        public static final ChatMode UNKNOWN = null;
        public static final /* synthetic */ ChatMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<ChatMode> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                ChatMode.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L17;
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

            public a(KClass<ChatMode> r1, Syntax r2, ChatMode r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<ChatMode> getEntries() {
            return b;
        }

        static {
            ChatMode r0 = new ChatMode("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ChatMode r1 = new ChatMode("DEFAULT", 1, 1);
            DEFAULT = r1;
            ChatMode r3 = new ChatMode("THREAD", 2, 2);
            THREAD = r3;
            ChatMode r5 = new ChatMode("THREAD_V2", 3, 3);
            THREAD_V2 = r5;
            ChatMode[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(ChatMode.class), Syntax.PROTO_2, r0);
        }

        public static ChatMode[] values() {
            return (ChatMode[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final ChatMode fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L17;
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

        public static ChatMode valueOf(String r1) {
            return (ChatMode) r27.a.a(ChatMode.class, r1);
        }

        public ChatMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$ChatPinPermissionSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$ChatPinPermissionSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$ChatPinPermissionSetting$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ChatPinPermissionSetting extends com.lark.wire.Message<ChatPinPermissionSetting, a> {
        public static final ProtoAdapter<ChatPinPermissionSetting> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$ChatPinPermissionSetting$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "ONLY_MANAGER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final b Companion = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;
            public static final /* synthetic */ Enum[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Enum.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return Enum.ONLY_MANAGER;
                L15:
                    return Enum.ALL_MEMBERS;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r1, Syntax r2, Enum r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return b;
            }

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Enum r3 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r3;
                Enum[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r0);
            }

            public static Enum[] values() {
                return (Enum[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return ONLY_MANAGER;
            L15:
                return ALL_MEMBERS;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) r27.a.a(Enum.class, r1);
            }

            public Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
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
            public final ChatPinPermissionSetting c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new ChatPinPermissionSetting(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ChatPinPermissionSetting r2) {
                ChatPinPermissionSetting r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, ChatPinPermissionSetting r3) {
                ChatPinPermissionSetting r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, ChatPinPermissionSetting r3) {
                ChatPinPermissionSetting r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<ChatPinPermissionSetting> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chat.ChatPinPermissionSetting", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ChatPinPermissionSetting(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ChatPinPermissionSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ChatPinPermissionSetting.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ChatPinPermissionSetting(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ ChatPinPermissionSetting(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$ChatTabPermissionSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$ChatTabPermissionSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$ChatTabPermissionSetting$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ChatTabPermissionSetting extends com.lark.wire.Message<ChatTabPermissionSetting, a> {
        public static final ProtoAdapter<ChatTabPermissionSetting> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$ChatTabPermissionSetting$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "ONLY_MANAGER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final b Companion = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;
            public static final /* synthetic */ Enum[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Enum.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return Enum.ONLY_MANAGER;
                L15:
                    return Enum.ALL_MEMBERS;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r1, Syntax r2, Enum r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return b;
            }

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Enum r3 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r3;
                Enum[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r0);
            }

            public static Enum[] values() {
                return (Enum[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return ONLY_MANAGER;
            L15:
                return ALL_MEMBERS;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) r27.a.a(Enum.class, r1);
            }

            public Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
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
            public final ChatTabPermissionSetting c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new ChatTabPermissionSetting(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ChatTabPermissionSetting r2) {
                ChatTabPermissionSetting r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, ChatTabPermissionSetting r3) {
                ChatTabPermissionSetting r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, ChatTabPermissionSetting r3) {
                ChatTabPermissionSetting r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<ChatTabPermissionSetting> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chat.ChatTabPermissionSetting", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ChatTabPermissionSetting(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ChatTabPermissionSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ChatTabPermissionSetting.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ChatTabPermissionSetting(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ ChatTabPermissionSetting(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$CreateUrgentSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$CreateUrgentSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$CreateUrgentSetting$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CreateUrgentSetting extends com.lark.wire.Message<CreateUrgentSetting, a> {
        public static final ProtoAdapter<CreateUrgentSetting> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$CreateUrgentSetting$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "ONLY_MANAGER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final b Companion = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;
            public static final /* synthetic */ Enum[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Enum.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return Enum.ONLY_MANAGER;
                L15:
                    return Enum.ALL_MEMBERS;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r1, Syntax r2, Enum r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return b;
            }

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Enum r3 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r3;
                Enum[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r0);
            }

            public static Enum[] values() {
                return (Enum[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return ONLY_MANAGER;
            L15:
                return ALL_MEMBERS;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) r27.a.a(Enum.class, r1);
            }

            public Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
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
            public final CreateUrgentSetting c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new CreateUrgentSetting(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(CreateUrgentSetting r2) {
                CreateUrgentSetting r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, CreateUrgentSetting r3) {
                CreateUrgentSetting r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, CreateUrgentSetting r3) {
                CreateUrgentSetting r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<CreateUrgentSetting> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chat.CreateUrgentSetting", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ CreateUrgentSetting(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CreateUrgentSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(CreateUrgentSetting.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public CreateUrgentSetting(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ CreateUrgentSetting(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$CreateVideoConferenceSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$CreateVideoConferenceSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$CreateVideoConferenceSetting$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CreateVideoConferenceSetting extends com.lark.wire.Message<CreateVideoConferenceSetting, a> {
        public static final ProtoAdapter<CreateVideoConferenceSetting> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$CreateVideoConferenceSetting$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "ONLY_MANAGER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final b Companion = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;
            public static final /* synthetic */ Enum[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Enum.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return Enum.ONLY_MANAGER;
                L15:
                    return Enum.ALL_MEMBERS;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r1, Syntax r2, Enum r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return b;
            }

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Enum r3 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r3;
                Enum[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r0);
            }

            public static Enum[] values() {
                return (Enum[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return ONLY_MANAGER;
            L15:
                return ALL_MEMBERS;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) r27.a.a(Enum.class, r1);
            }

            public Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
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
            public final CreateVideoConferenceSetting c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new CreateVideoConferenceSetting(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(CreateVideoConferenceSetting r2) {
                CreateVideoConferenceSetting r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, CreateVideoConferenceSetting r3) {
                CreateVideoConferenceSetting r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, CreateVideoConferenceSetting r3) {
                CreateVideoConferenceSetting r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<CreateVideoConferenceSetting> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chat.CreateVideoConferenceSetting", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ CreateVideoConferenceSetting(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CreateVideoConferenceSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(CreateVideoConferenceSetting.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public CreateVideoConferenceSetting(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ CreateVideoConferenceSetting(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$DefDisplaySetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$DefDisplaySetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$DefDisplaySetting$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class DefDisplaySetting extends com.lark.wire.Message<DefDisplaySetting, a> {
        public static final ProtoAdapter<DefDisplaySetting> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$DefDisplaySetting$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "INPUT_BOX", "CHAT_MENU", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum CHAT_MENU = null;
            public static final b Companion = null;
            public static final Enum INPUT_BOX = null;
            public static final Enum UNKNOWN = null;
            public static final /* synthetic */ Enum[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Enum.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return Enum.CHAT_MENU;
                L15:
                    return Enum.INPUT_BOX;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r1, Syntax r2, Enum r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return b;
            }

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("INPUT_BOX", 1, 1);
                INPUT_BOX = r1;
                Enum r3 = new Enum("CHAT_MENU", 2, 2);
                CHAT_MENU = r3;
                Enum[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r0);
            }

            public static Enum[] values() {
                return (Enum[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return CHAT_MENU;
            L15:
                return INPUT_BOX;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) r27.a.a(Enum.class, r1);
            }

            public Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
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
            public final DefDisplaySetting c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new DefDisplaySetting(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(DefDisplaySetting r2) {
                DefDisplaySetting r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, DefDisplaySetting r3) {
                DefDisplaySetting r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, DefDisplaySetting r3) {
                DefDisplaySetting r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<DefDisplaySetting> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chat.DefDisplaySetting", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ DefDisplaySetting(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(DefDisplaySetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(DefDisplaySetting.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public DefDisplaySetting(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ DefDisplaySetting(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$DoubaoSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$DoubaoSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$DoubaoSetting$Builder;Lokio/ByteString;)V", "doubao_using_enabled", "", "getDoubao_using_enabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "doubao_proactive_reply_enabled", "getDoubao_proactive_reply_enabled", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class DoubaoSetting extends com.lark.wire.Message<DoubaoSetting, a> {
        public static final ProtoAdapter<DoubaoSetting> ADAPTER = null;
        public static final c Companion = null;
        public static final boolean DEFAULT_DOUBAO_PROACTIVE_REPLY_ENABLED = false;
        public static final boolean DEFAULT_DOUBAO_USING_ENABLED = true;
        private static final long serialVersionUID = 0;
        private final Boolean doubao_proactive_reply_enabled;
        private final Boolean doubao_using_enabled;

        public static final class a extends com.lark.wire.Message.a<DoubaoSetting, a> {
            public Boolean d;
            public Boolean e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new DoubaoSetting(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<DoubaoSetting> {
            @Override // com.lark.wire.ProtoAdapter
            public final DoubaoSetting c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L13;
                if (r3 != 1) goto L8;
                r0.d = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.e = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L9:
                r6.j(r3);
                Unit r4 = Unit.INSTANCE;
                goto L3
            L13:
                return new DoubaoSetting(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(DoubaoSetting r5) {
                DoubaoSetting r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                l r1 = ProtoAdapter.g;
                return (r0 + r1.l(1, r6.getDoubao_using_enabled())) + r1.l(2, r6.getDoubao_proactive_reply_enabled());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, DoubaoSetting r5) {
                DoubaoSetting r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                l r0 = ProtoAdapter.g;
                r0.i(r4, 1, r6.getDoubao_using_enabled());
                r0.i(r4, 2, r6.getDoubao_proactive_reply_enabled());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, DoubaoSetting r5) {
                DoubaoSetting r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                l r0 = ProtoAdapter.g;
                r0.j(r4, 2, r6.getDoubao_proactive_reply_enabled());
                r0.j(r4, 1, r6.getDoubao_using_enabled());
            }

            public b(FieldEncoding r7, KClass<DoubaoSetting> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chat.DoubaoSetting", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ DoubaoSetting(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(DoubaoSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.doubao_using_enabled;
            r0.e = this.doubao_proactive_reply_enabled;
            r0.a(unknownFields());
            return r0;
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

        public DoubaoSetting(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.doubao_using_enabled = r2.d;
            this.doubao_proactive_reply_enabled = r2.e;
        }

        public /* synthetic */ DoubaoSetting(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$MessagePosition;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$MessagePosition$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$MessagePosition$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class MessagePosition extends com.lark.wire.Message<MessagePosition, a> {
        public static final ProtoAdapter<MessagePosition> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$MessagePosition$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "RECENT_LEFT", "NEWEST_UNREAD", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final b Companion = null;
            public static final Enum NEWEST_UNREAD = null;
            public static final Enum RECENT_LEFT = null;
            public static final Enum UNKNOWN = null;
            public static final /* synthetic */ Enum[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Enum.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return Enum.NEWEST_UNREAD;
                L15:
                    return Enum.RECENT_LEFT;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r1, Syntax r2, Enum r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return b;
            }

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("RECENT_LEFT", 1, 1);
                RECENT_LEFT = r1;
                Enum r3 = new Enum("NEWEST_UNREAD", 2, 2);
                NEWEST_UNREAD = r3;
                Enum[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r0);
            }

            public static Enum[] values() {
                return (Enum[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return NEWEST_UNREAD;
            L15:
                return RECENT_LEFT;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) r27.a.a(Enum.class, r1);
            }

            public Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
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
            public final MessagePosition c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new MessagePosition(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(MessagePosition r2) {
                MessagePosition r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, MessagePosition r3) {
                MessagePosition r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, MessagePosition r3) {
                MessagePosition r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<MessagePosition> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chat.MessagePosition", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ MessagePosition(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MessagePosition.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(MessagePosition.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public MessagePosition(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ MessagePosition(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$MessageVisibilitySetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$MessageVisibilitySetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$MessageVisibilitySetting$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class MessageVisibilitySetting extends com.lark.wire.Message<MessageVisibilitySetting, a> {
        public static final ProtoAdapter<MessageVisibilitySetting> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$MessageVisibilitySetting$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MESSAGES", "ONLY_NEW_MESSAGES", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MESSAGES = null;
            public static final b Companion = null;
            public static final Enum ONLY_NEW_MESSAGES = null;
            public static final Enum UNKNOWN = null;
            public static final /* synthetic */ Enum[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Enum.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return Enum.ONLY_NEW_MESSAGES;
                L15:
                    return Enum.ALL_MESSAGES;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r1, Syntax r2, Enum r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return b;
            }

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALL_MESSAGES", 1, 1);
                ALL_MESSAGES = r1;
                Enum r3 = new Enum("ONLY_NEW_MESSAGES", 2, 2);
                ONLY_NEW_MESSAGES = r3;
                Enum[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r0);
            }

            public static Enum[] values() {
                return (Enum[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return ONLY_NEW_MESSAGES;
            L15:
                return ALL_MESSAGES;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) r27.a.a(Enum.class, r1);
            }

            public Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
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
            public final MessageVisibilitySetting c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new MessageVisibilitySetting(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(MessageVisibilitySetting r2) {
                MessageVisibilitySetting r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, MessageVisibilitySetting r3) {
                MessageVisibilitySetting r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, MessageVisibilitySetting r3) {
                MessageVisibilitySetting r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<MessageVisibilitySetting> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chat.MessageVisibilitySetting", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ MessageVisibilitySetting(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MessageVisibilitySetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(MessageVisibilitySetting.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public MessageVisibilitySetting(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ MessageVisibilitySetting(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$PinPermissionSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$PinPermissionSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$PinPermissionSetting$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class PinPermissionSetting extends com.lark.wire.Message<PinPermissionSetting, a> {
        public static final ProtoAdapter<PinPermissionSetting> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$PinPermissionSetting$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "ONLY_MANAGER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final b Companion = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;
            public static final /* synthetic */ Enum[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Enum.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return Enum.ONLY_MANAGER;
                L15:
                    return Enum.ALL_MEMBERS;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r1, Syntax r2, Enum r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return b;
            }

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Enum r3 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r3;
                Enum[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r0);
            }

            public static Enum[] values() {
                return (Enum[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return ONLY_MANAGER;
            L15:
                return ALL_MEMBERS;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) r27.a.a(Enum.class, r1);
            }

            public Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
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
            public final PinPermissionSetting c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new PinPermissionSetting(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(PinPermissionSetting r2) {
                PinPermissionSetting r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, PinPermissionSetting r3) {
                PinPermissionSetting r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, PinPermissionSetting r3) {
                PinPermissionSetting r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<PinPermissionSetting> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chat.PinPermissionSetting", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ PinPermissionSetting(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PinPermissionSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(PinPermissionSetting.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public PinPermissionSetting(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ PinPermissionSetting(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$PostType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_POST_TYPE", "ANYONE", "ONLY_ADMIN", "WHITE_LIST", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum PostType extends Enum<PostType> implements o0 {
        public static final ProtoAdapter<PostType> ADAPTER = null;
        public static final PostType ANYONE = null;
        public static final b Companion = null;
        public static final PostType ONLY_ADMIN = null;
        public static final PostType UNKNOWN_POST_TYPE = null;
        public static final PostType WHITE_LIST = null;
        public static final /* synthetic */ PostType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<PostType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                PostType.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L17;
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

            public a(KClass<PostType> r1, Syntax r2, PostType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<PostType> getEntries() {
            return b;
        }

        static {
            PostType r0 = new PostType("UNKNOWN_POST_TYPE", 0, 0);
            UNKNOWN_POST_TYPE = r0;
            PostType r1 = new PostType("ANYONE", 1, 1);
            ANYONE = r1;
            PostType r3 = new PostType("ONLY_ADMIN", 2, 2);
            ONLY_ADMIN = r3;
            PostType r5 = new PostType("WHITE_LIST", 3, 3);
            WHITE_LIST = r5;
            PostType[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(PostType.class), Syntax.PROTO_2, r0);
        }

        public static PostType[] values() {
            return (PostType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final PostType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L17;
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

        public static PostType valueOf(String r1) {
            return (PostType) r27.a.a(PostType.class, r1);
        }

        public PostType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\"#$%B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020!H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006&"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting$Builder;Lokio/ByteString;)V", "switch", "", "getSwitch", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "copy", "Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting$Participant;", "getCopy", "()Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting$Participant;", "forward", "getForward", "download", "getDownload", "screenshot", "getScreenshot", "on_time_del_msg_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting$OnTimeDelMsgSetting;", "getOn_time_del_msg_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting$OnTimeDelMsgSetting;", "white_list_setting", "Lcom/lark/kmp/pb/basic/v1/Chat$WhiteListSetting;", "getWhite_list_setting", "()Lcom/lark/kmp/pb/basic/v1/Chat$WhiteListSetting;", "newBuilder", "toString", "", "Builder", "Companion", "Participant", "OnTimeDelMsgSetting", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
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
        private final Boolean f0switch;
        private final WhiteListSetting white_list_setting;

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting$OnTimeDelMsgSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting$OnTimeDelMsgSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting$OnTimeDelMsgSetting$Builder;Lokio/ByteString;)V", "status", "", "getStatus", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "alive_time", "", "getAlive_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class OnTimeDelMsgSetting extends com.lark.wire.Message<OnTimeDelMsgSetting, a> {
            public static final ProtoAdapter<OnTimeDelMsgSetting> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final Long alive_time;
            private final Boolean status;

            public static final class a extends com.lark.wire.Message.a<OnTimeDelMsgSetting, a> {
                public Boolean d;
                public Long e;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new OnTimeDelMsgSetting(this, c(), null);
                }

                public a() {
                }
            }

            public static final class b extends ProtoAdapter<OnTimeDelMsgSetting> {
                @Override // com.lark.wire.ProtoAdapter
                public final OnTimeDelMsgSetting c(g0 r6) {
                    Intrinsics.checkNotNullParameter(r6, "reader");
                    a r0 = new a();
                    long r1 = r6.c();
                L3:
                    int r3 = r6.e();
                    if (r3 == (-1)) goto L13;
                    if (r3 != 1) goto L8;
                    r0.d = (Boolean) ProtoAdapter.g.c(r6);
                    goto L3
                L8:
                    if (r3 != 2) goto L9;
                    r0.e = (Long) ProtoAdapter.k.c(r6);
                    goto L3
                L9:
                    r6.j(r3);
                    Unit r4 = Unit.INSTANCE;
                    goto L3
                L13:
                    return new OnTimeDelMsgSetting(r0, r6.d(r1), null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(OnTimeDelMsgSetting r5) {
                    OnTimeDelMsgSetting r6 = r5;
                    Intrinsics.checkNotNullParameter(r6, "value");
                    return (r6.unknownFields().size() + ProtoAdapter.g.l(1, r6.getStatus())) + ProtoAdapter.k.l(2, r6.getAlive_time());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r4, OnTimeDelMsgSetting r5) {
                    OnTimeDelMsgSetting r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    ProtoAdapter.g.i(r4, 1, r6.getStatus());
                    ProtoAdapter.k.i(r4, 2, r6.getAlive_time());
                    r4.a(r6.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r4, OnTimeDelMsgSetting r5) {
                    OnTimeDelMsgSetting r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    r4.d(r6.unknownFields());
                    ProtoAdapter.k.j(r4, 2, r6.getAlive_time());
                    ProtoAdapter.g.j(r4, 1, r6.getStatus());
                }

                public b(FieldEncoding r7, KClass<OnTimeDelMsgSetting> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.Chat.RestrictedModeSetting.OnTimeDelMsgSetting", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ OnTimeDelMsgSetting(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(OnTimeDelMsgSetting.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.status;
                r0.e = this.alive_time;
                r0.a(unknownFields());
                return r0;
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

            public OnTimeDelMsgSetting(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.status = r2.d;
                this.alive_time = r2.e;
            }

            public /* synthetic */ OnTimeDelMsgSetting(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$RestrictedModeSetting$Participant;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "NO_MEMBER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Participant extends Enum<Participant> implements o0 {
            public static final ProtoAdapter<Participant> ADAPTER = null;
            public static final Participant ALL_MEMBERS = null;
            public static final b Companion = null;
            public static final Participant NO_MEMBER = null;
            public static final Participant UNKNOWN = null;
            public static final /* synthetic */ Participant[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Participant> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Participant.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return Participant.NO_MEMBER;
                L15:
                    return Participant.ALL_MEMBERS;
                L12:
                    return Participant.UNKNOWN;
                }

                public a(KClass<Participant> r1, Syntax r2, Participant r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Participant> getEntries() {
                return b;
            }

            static {
                Participant r0 = new Participant("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Participant r1 = new Participant("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Participant r3 = new Participant("NO_MEMBER", 2, 2);
                NO_MEMBER = r3;
                Participant[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Participant.class), Syntax.PROTO_2, r0);
            }

            public static Participant[] values() {
                return (Participant[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Participant fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return NO_MEMBER;
            L15:
                return ALL_MEMBERS;
            L12:
                return UNKNOWN;
            }

            public static Participant valueOf(String r1) {
                return (Participant) r27.a.a(Participant.class, r1);
            }

            public Participant(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<RestrictedModeSetting, a> {
            public Boolean d;
            public Participant e;
            public Participant f;
            public Participant g;
            public Participant h;
            public OnTimeDelMsgSetting i;
            public WhiteListSetting j;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new RestrictedModeSetting(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<RestrictedModeSetting> {
            @Override // com.lark.wire.ProtoAdapter
            public final RestrictedModeSetting c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L27;
                switch(r3) {
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
                r0.f = Participant.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L30:
                r0.g = Participant.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L32:
                r0.h = Participant.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
            L11:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r6 = Unit.INSTANCE;
                goto L3
            L34:
                r0.e = Participant.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
            L23:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r7 = Unit.INSTANCE;
                goto L3
            L7:
                r0.j = WhiteListSetting.ADAPTER.c(r9);
                goto L3
            L8:
                r0.i = OnTimeDelMsgSetting.ADAPTER.c(r9);
                goto L3
            L25:
                r0.d = (Boolean) ProtoAdapter.g.c(r9);
                goto L3
            L6:
                r9.j(r3);
                goto L3
            L27:
                return new RestrictedModeSetting(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(RestrictedModeSetting r5) {
                RestrictedModeSetting r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size() + ProtoAdapter.g.l(1, r6.getSwitch());
                ProtoAdapter<Participant> r1 = Participant.ADAPTER;
                return (((((r0 + r1.l(2, r6.getCopy())) + r1.l(3, r6.getForward())) + r1.l(4, r6.getDownload())) + r1.l(5, r6.getScreenshot())) + OnTimeDelMsgSetting.ADAPTER.l(6, r6.getOn_time_del_msg_setting())) + WhiteListSetting.ADAPTER.l(7, r6.getWhite_list_setting());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, RestrictedModeSetting r5) {
                RestrictedModeSetting r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.g.i(r4, 1, r6.getSwitch());
                ProtoAdapter<Participant> r0 = Participant.ADAPTER;
                r0.i(r4, 2, r6.getCopy());
                r0.i(r4, 3, r6.getForward());
                r0.i(r4, 4, r6.getDownload());
                r0.i(r4, 5, r6.getScreenshot());
                OnTimeDelMsgSetting.ADAPTER.i(r4, 6, r6.getOn_time_del_msg_setting());
                WhiteListSetting.ADAPTER.i(r4, 7, r6.getWhite_list_setting());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, RestrictedModeSetting r5) {
                RestrictedModeSetting r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                WhiteListSetting.ADAPTER.j(r4, 7, r6.getWhite_list_setting());
                OnTimeDelMsgSetting.ADAPTER.j(r4, 6, r6.getOn_time_del_msg_setting());
                ProtoAdapter<Participant> r0 = Participant.ADAPTER;
                r0.j(r4, 5, r6.getScreenshot());
                r0.j(r4, 4, r6.getDownload());
                r0.j(r4, 3, r6.getForward());
                r0.j(r4, 2, r6.getCopy());
                ProtoAdapter.g.j(r4, 1, r6.getSwitch());
            }

            public b(FieldEncoding r7, KClass<RestrictedModeSetting> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chat.RestrictedModeSetting", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ RestrictedModeSetting(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            Participant r0 = Participant.NO_MEMBER;
            DEFAULT_COPY = r0;
            DEFAULT_FORWARD = r0;
            DEFAULT_DOWNLOAD = r0;
            DEFAULT_SCREENSHOT = r0;
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(RestrictedModeSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.f0switch;
            r0.e = this.copy;
            r0.f = this.forward;
            r0.g = this.download;
            r0.h = this.screenshot;
            r0.i = this.on_time_del_msg_setting;
            r0.j = this.white_list_setting;
            r0.a(unknownFields());
            return r0;
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
            return this.f0switch;
        }

        public final WhiteListSetting getWhite_list_setting() {
            return this.white_list_setting;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public RestrictedModeSetting(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.f0switch = r2.d;
            this.copy = r2.e;
            this.forward = r2.f;
            this.download = r2.g;
            this.screenshot = r2.h;
            this.on_time_del_msg_setting = r2.i;
            this.white_list_setting = r2.j;
        }

        public /* synthetic */ RestrictedModeSetting(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$Role;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "IGNORE", "MEMBER", "VISITOR", "THREAD_FOLLOWER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Role extends Enum<Role> implements o0 {
        public static final ProtoAdapter<Role> ADAPTER = null;
        public static final b Companion = null;
        public static final Role IGNORE = null;
        public static final Role MEMBER = null;
        public static final Role THREAD_FOLLOWER = null;
        public static final Role VISITOR = null;
        public static final /* synthetic */ Role[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Role> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Role.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L17;
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

            public a(KClass<Role> r1, Syntax r2, Role r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Role> getEntries() {
            return b;
        }

        static {
            Role r0 = new Role("IGNORE", 0, 0);
            IGNORE = r0;
            Role r1 = new Role("MEMBER", 1, 1);
            MEMBER = r1;
            Role r3 = new Role("VISITOR", 2, 2);
            VISITOR = r3;
            Role r5 = new Role("THREAD_FOLLOWER", 3, 3);
            THREAD_FOLLOWER = r5;
            Role[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Role.class), Syntax.PROTO_2, r0);
        }

        public static Role[] values() {
            return (Role[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Role fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L17;
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

        public static Role valueOf(String r1) {
            return (Role) r27.a.a(Role.class, r1);
        }

        public Role(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$ShareCardPermission;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$ShareCardPermission$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$ShareCardPermission$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ShareCardPermission extends com.lark.wire.Message<ShareCardPermission, a> {
        public static final ProtoAdapter<ShareCardPermission> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$ShareCardPermission$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALLOWED", "NOT_ALLOWED", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALLOWED = null;
            public static final b Companion = null;
            public static final Enum NOT_ALLOWED = null;
            public static final Enum UNKNOWN = null;
            public static final /* synthetic */ Enum[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Enum.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return Enum.NOT_ALLOWED;
                L15:
                    return Enum.ALLOWED;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r1, Syntax r2, Enum r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return b;
            }

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALLOWED", 1, 1);
                ALLOWED = r1;
                Enum r3 = new Enum("NOT_ALLOWED", 2, 2);
                NOT_ALLOWED = r3;
                Enum[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r0);
            }

            public static Enum[] values() {
                return (Enum[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return NOT_ALLOWED;
            L15:
                return ALLOWED;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) r27.a.a(Enum.class, r1);
            }

            public Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
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
            public final ShareCardPermission c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new ShareCardPermission(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ShareCardPermission r2) {
                ShareCardPermission r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, ShareCardPermission r3) {
                ShareCardPermission r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, ShareCardPermission r3) {
                ShareCardPermission r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<ShareCardPermission> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chat.ShareCardPermission", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ShareCardPermission(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ShareCardPermission.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ShareCardPermission.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ShareCardPermission(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ ShareCardPermission(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$SystemMessageVisible;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$SystemMessageVisible$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$SystemMessageVisible$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class SystemMessageVisible extends com.lark.wire.Message<SystemMessageVisible, a> {
        public static final ProtoAdapter<SystemMessageVisible> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$SystemMessageVisible$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ONLY_OWNER", "ALL_MEMBERS", "NOT_ANYONE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final b Companion = null;
            public static final Enum NOT_ANYONE = null;
            public static final Enum ONLY_OWNER = null;
            public static final Enum UNKNOWN = null;
            public static final /* synthetic */ Enum[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Enum.Companion.getClass();
                    if (r2 == 0) goto L15;
                    if (r2 == 1) goto L19;
                    if (r2 == 2) goto L18;
                    if (r2 == 3) goto L17;
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

                public a(KClass<Enum> r1, Syntax r2, Enum r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return b;
            }

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ONLY_OWNER", 1, 1);
                ONLY_OWNER = r1;
                Enum r3 = new Enum("ALL_MEMBERS", 2, 2);
                ALL_MEMBERS = r3;
                Enum r5 = new Enum("NOT_ANYONE", 3, 3);
                NOT_ANYONE = r5;
                Enum[] r7 = {r0, r1, r3, r5};
                a = r7;
                b = EnumEntriesKt.enumEntries(r7);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r0);
            }

            public static Enum[] values() {
                return (Enum[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L15;
                if (r1 == 1) goto L19;
                if (r1 == 2) goto L18;
                if (r1 == 3) goto L17;
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

            public static Enum valueOf(String r1) {
                return (Enum) r27.a.a(Enum.class, r1);
            }

            public Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
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
            public final SystemMessageVisible c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new SystemMessageVisible(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(SystemMessageVisible r2) {
                SystemMessageVisible r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, SystemMessageVisible r3) {
                SystemMessageVisible r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, SystemMessageVisible r3) {
                SystemMessageVisible r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<SystemMessageVisible> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chat.SystemMessageVisible", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ SystemMessageVisible(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(SystemMessageVisible.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(SystemMessageVisible.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public SystemMessageVisible(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ SystemMessageVisible(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$TnsInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$TnsInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$TnsInfo$Builder;Lokio/ByteString;)V", "op_kind", "Lcom/lark/kmp/pb/basic/v1/TnsOpKind;", "getOp_kind", "()Lcom/lark/kmp/pb/basic/v1/TnsOpKind;", "system_banned_info", "Lcom/lark/kmp/pb/basic/v1/TnsSystemBannedInfo;", "getSystem_banned_info", "()Lcom/lark/kmp/pb/basic/v1/TnsSystemBannedInfo;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class TnsInfo extends com.lark.wire.Message<TnsInfo, a> {
        public static final ProtoAdapter<TnsInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final TnsOpKind op_kind;
        private final TnsSystemBannedInfo system_banned_info;

        public static final class a extends com.lark.wire.Message.a<TnsInfo, a> {
            public TnsOpKind d;
            public TnsSystemBannedInfo e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new TnsInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<TnsInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final TnsInfo c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L16;
                if (r3 != 1) goto L8;
                r0.d = TnsOpKind.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.e = TnsSystemBannedInfo.ADAPTER.c(r9);
                goto L3
            L9:
                r9.j(r3);
                goto L3
            L16:
                return new TnsInfo(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TnsInfo r5) {
                TnsInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + TnsOpKind.ADAPTER.l(1, r6.getOp_kind())) + TnsSystemBannedInfo.ADAPTER.l(2, r6.getSystem_banned_info());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, TnsInfo r5) {
                TnsInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                TnsOpKind.ADAPTER.i(r4, 1, r6.getOp_kind());
                TnsSystemBannedInfo.ADAPTER.i(r4, 2, r6.getSystem_banned_info());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, TnsInfo r5) {
                TnsInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                TnsSystemBannedInfo.ADAPTER.j(r4, 2, r6.getSystem_banned_info());
                TnsOpKind.ADAPTER.j(r4, 1, r6.getOp_kind());
            }

            public b(FieldEncoding r7, KClass<TnsInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chat.TnsInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ TnsInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TnsInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.op_kind;
            r0.e = this.system_banned_info;
            r0.a(unknownFields());
            return r0;
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

        public TnsInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.op_kind = r2.d;
            this.system_banned_info = r2.e;
        }

        public /* synthetic */ TnsInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$TopNoticePermissionSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$TopNoticePermissionSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$TopNoticePermissionSetting$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class TopNoticePermissionSetting extends com.lark.wire.Message<TopNoticePermissionSetting, a> {
        public static final ProtoAdapter<TopNoticePermissionSetting> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$TopNoticePermissionSetting$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "ONLY_MANAGER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final b Companion = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;
            public static final /* synthetic */ Enum[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Enum.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return Enum.ONLY_MANAGER;
                L15:
                    return Enum.ALL_MEMBERS;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r1, Syntax r2, Enum r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return b;
            }

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Enum r3 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r3;
                Enum[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r0);
            }

            public static Enum[] values() {
                return (Enum[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return ONLY_MANAGER;
            L15:
                return ALL_MEMBERS;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) r27.a.a(Enum.class, r1);
            }

            public Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
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
            public final TopNoticePermissionSetting c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new TopNoticePermissionSetting(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TopNoticePermissionSetting r2) {
                TopNoticePermissionSetting r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, TopNoticePermissionSetting r3) {
                TopNoticePermissionSetting r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, TopNoticePermissionSetting r3) {
                TopNoticePermissionSetting r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<TopNoticePermissionSetting> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chat.TopNoticePermissionSetting", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ TopNoticePermissionSetting(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TopNoticePermissionSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(TopNoticePermissionSetting.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public TopNoticePermissionSetting(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ TopNoticePermissionSetting(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "P2P", "GROUP", "TOPIC_GROUP", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final b Companion = null;
        public static final Type GROUP = null;
        public static final Type P2P = null;
        public static final Type TOPIC_GROUP = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Type.Companion.getClass();
                if (r2 == 1) goto L12;
                if (r2 == 2) goto L15;
                if (r2 == 3) goto L14;
                return null;
            L14:
                return Type.TOPIC_GROUP;
            L15:
                return Type.GROUP;
            L12:
                return Type.P2P;
            }

            public a(KClass<Type> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("P2P", 0, 1);
            P2P = r0;
            Type r1 = new Type("GROUP", 1, 2);
            GROUP = r1;
            Type r4 = new Type("TOPIC_GROUP", 2, 3);
            TOPIC_GROUP = r4;
            Type[] r6 = {r0, r1, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Type fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L15;
            if (r1 == 3) goto L14;
            return null;
        L14:
            return TOPIC_GROUP;
        L15:
            return GROUP;
        L12:
            return P2P;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004#$%&B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010!\u001a\u00020\u0002H\u0016J\b\u0010\"\u001a\u00020\rH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\b\u0010\nR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0011\u0010\nR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u001c\u0010\nR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006'"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$TypingTranslateSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$TypingTranslateSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$TypingTranslateSetting$Builder;Lokio/ByteString;)V", "is_open", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "target_language", "", "getTarget_language", "()Ljava/lang/String;", "enable_use_translated_original", "getEnable_use_translated_original", "update_time_ns", "", "getUpdate_time_ns", "()Ljava/lang/Long;", "Ljava/lang/Long;", "open_mode", "Lcom/lark/kmp/pb/basic/v1/Chat$TypingTranslateSetting$OpenMode;", "getOpen_mode", "()Lcom/lark/kmp/pb/basic/v1/Chat$TypingTranslateSetting$OpenMode;", "can_auto_open_v3", "getCan_auto_open_v3", "close_mode", "Lcom/lark/kmp/pb/basic/v1/Chat$TypingTranslateSetting$AutoOpenCloseMode;", "getClose_mode", "()Lcom/lark/kmp/pb/basic/v1/Chat$TypingTranslateSetting$AutoOpenCloseMode;", "newBuilder", "toString", "Builder", "Companion", "OpenMode", "AutoOpenCloseMode", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
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

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$TypingTranslateSetting$AutoOpenCloseMode;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CLOSE_UNKNOWN", "CLOSE_DIRECTLY", "CLOSE_POPUP", "CLOSE_NO_LONGER_OPEN", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum AutoOpenCloseMode extends Enum<AutoOpenCloseMode> implements o0 {
            public static final ProtoAdapter<AutoOpenCloseMode> ADAPTER = null;
            public static final AutoOpenCloseMode CLOSE_DIRECTLY = null;
            public static final AutoOpenCloseMode CLOSE_NO_LONGER_OPEN = null;
            public static final AutoOpenCloseMode CLOSE_POPUP = null;
            public static final AutoOpenCloseMode CLOSE_UNKNOWN = null;
            public static final b Companion = null;
            public static final /* synthetic */ AutoOpenCloseMode[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<AutoOpenCloseMode> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    AutoOpenCloseMode.Companion.getClass();
                    if (r2 == 0) goto L15;
                    if (r2 == 1) goto L19;
                    if (r2 == 2) goto L18;
                    if (r2 == 3) goto L17;
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

                public a(KClass<AutoOpenCloseMode> r1, Syntax r2, AutoOpenCloseMode r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<AutoOpenCloseMode> getEntries() {
                return b;
            }

            static {
                AutoOpenCloseMode r0 = new AutoOpenCloseMode("CLOSE_UNKNOWN", 0, 0);
                CLOSE_UNKNOWN = r0;
                AutoOpenCloseMode r1 = new AutoOpenCloseMode("CLOSE_DIRECTLY", 1, 1);
                CLOSE_DIRECTLY = r1;
                AutoOpenCloseMode r3 = new AutoOpenCloseMode("CLOSE_POPUP", 2, 2);
                CLOSE_POPUP = r3;
                AutoOpenCloseMode r5 = new AutoOpenCloseMode("CLOSE_NO_LONGER_OPEN", 3, 3);
                CLOSE_NO_LONGER_OPEN = r5;
                AutoOpenCloseMode[] r7 = {r0, r1, r3, r5};
                a = r7;
                b = EnumEntriesKt.enumEntries(r7);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(AutoOpenCloseMode.class), Syntax.PROTO_2, r0);
            }

            public static AutoOpenCloseMode[] values() {
                return (AutoOpenCloseMode[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final AutoOpenCloseMode fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L15;
                if (r1 == 1) goto L19;
                if (r1 == 2) goto L18;
                if (r1 == 3) goto L17;
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

            public static AutoOpenCloseMode valueOf(String r1) {
                return (AutoOpenCloseMode) r27.a.a(AutoOpenCloseMode.class, r1);
            }

            public AutoOpenCloseMode(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$TypingTranslateSetting$OpenMode;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "MANUAL", "AUTO", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum OpenMode extends Enum<OpenMode> implements o0 {
            public static final ProtoAdapter<OpenMode> ADAPTER = null;
            public static final OpenMode AUTO = null;
            public static final b Companion = null;
            public static final OpenMode MANUAL = null;
            public static final OpenMode UNKNOWN = null;
            public static final /* synthetic */ OpenMode[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<OpenMode> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    OpenMode.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return OpenMode.AUTO;
                L15:
                    return OpenMode.MANUAL;
                L12:
                    return OpenMode.UNKNOWN;
                }

                public a(KClass<OpenMode> r1, Syntax r2, OpenMode r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<OpenMode> getEntries() {
                return b;
            }

            static {
                OpenMode r0 = new OpenMode("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                OpenMode r1 = new OpenMode("MANUAL", 1, 1);
                MANUAL = r1;
                OpenMode r3 = new OpenMode("AUTO", 2, 2);
                AUTO = r3;
                OpenMode[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(OpenMode.class), Syntax.PROTO_2, r0);
            }

            public static OpenMode[] values() {
                return (OpenMode[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final OpenMode fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return AUTO;
            L15:
                return MANUAL;
            L12:
                return UNKNOWN;
            }

            public static OpenMode valueOf(String r1) {
                return (OpenMode) r27.a.a(OpenMode.class, r1);
            }

            public OpenMode(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<TypingTranslateSetting, a> {
            public Boolean d;
            public String e;
            public Boolean f;
            public Long g;
            public OpenMode h;
            public Boolean i;
            public AutoOpenCloseMode j;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new TypingTranslateSetting(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<TypingTranslateSetting> {
            @Override // com.lark.wire.ProtoAdapter
            public final TypingTranslateSetting c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L21;
                switch(r4) {
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
                r1.j = AutoOpenCloseMode.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L24:
                r1.h = OpenMode.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r6 = Unit.INSTANCE;
                goto L3
            L11:
                r1.i = (Boolean) ProtoAdapter.g.c(r10);
                goto L3
            L16:
                r1.g = (Long) ProtoAdapter.k.c(r10);
                goto L3
            L17:
                r1.f = (Boolean) ProtoAdapter.g.c(r10);
                goto L3
            L18:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.e = r10.i();
                goto L3
            L19:
                r1.d = (Boolean) ProtoAdapter.g.c(r10);
                goto L3
            L6:
                r10.j(r4);
                Unit r7 = Unit.INSTANCE;
                goto L3
            L21:
                return new TypingTranslateSetting(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TypingTranslateSetting r6) {
                TypingTranslateSetting r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size();
                l r1 = ProtoAdapter.g;
                return ((((((r0 + r1.l(1, r7.is_open())) + ProtoAdapter.q.l(2, r7.getTarget_language())) + r1.l(3, r7.getEnable_use_translated_original())) + ProtoAdapter.k.l(4, r7.getUpdate_time_ns())) + OpenMode.ADAPTER.l(5, r7.getOpen_mode())) + r1.l(6, r7.getCan_auto_open_v3())) + AutoOpenCloseMode.ADAPTER.l(8, r7.getClose_mode());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, TypingTranslateSetting r6) {
                TypingTranslateSetting r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                l r0 = ProtoAdapter.g;
                r0.i(r5, 1, r7.is_open());
                ProtoAdapter.q.i(r5, 2, r7.getTarget_language());
                r0.i(r5, 3, r7.getEnable_use_translated_original());
                ProtoAdapter.k.i(r5, 4, r7.getUpdate_time_ns());
                OpenMode.ADAPTER.i(r5, 5, r7.getOpen_mode());
                r0.i(r5, 6, r7.getCan_auto_open_v3());
                AutoOpenCloseMode.ADAPTER.i(r5, 8, r7.getClose_mode());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, TypingTranslateSetting r6) {
                TypingTranslateSetting r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                AutoOpenCloseMode.ADAPTER.j(r5, 8, r7.getClose_mode());
                l r0 = ProtoAdapter.g;
                r0.j(r5, 6, r7.getCan_auto_open_v3());
                OpenMode.ADAPTER.j(r5, 5, r7.getOpen_mode());
                ProtoAdapter.k.j(r5, 4, r7.getUpdate_time_ns());
                r0.j(r5, 3, r7.getEnable_use_translated_original());
                ProtoAdapter.q.j(r5, 2, r7.getTarget_language());
                r0.j(r5, 1, r7.is_open());
            }

            public b(FieldEncoding r7, KClass<TypingTranslateSetting> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chat.TypingTranslateSetting", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ TypingTranslateSetting(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TypingTranslateSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.is_open;
            r0.e = this.target_language;
            r0.f = this.enable_use_translated_original;
            r0.g = this.update_time_ns;
            r0.h = this.open_mode;
            r0.i = this.can_auto_open_v3;
            r0.j = this.close_mode;
            r0.a(unknownFields());
            return r0;
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

        public TypingTranslateSetting(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.is_open = r2.d;
            this.target_language = r2.e;
            this.enable_use_translated_original = r2.f;
            this.update_time_ns = r2.g;
            this.open_mode = r2.h;
            this.can_auto_open_v3 = r2.i;
            this.close_mode = r2.j;
        }

        public /* synthetic */ TypingTranslateSetting(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$UserCountVisibleSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$UserCountVisibleSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$UserCountVisibleSetting$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class UserCountVisibleSetting extends com.lark.wire.Message<UserCountVisibleSetting, a> {
        public static final ProtoAdapter<UserCountVisibleSetting> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$UserCountVisibleSetting$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "ONLY_MANAGER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final b Companion = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;
            public static final /* synthetic */ Enum[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Enum> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Enum.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return Enum.ONLY_MANAGER;
                L15:
                    return Enum.ALL_MEMBERS;
                L12:
                    return Enum.UNKNOWN;
                }

                public a(KClass<Enum> r1, Syntax r2, Enum r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Enum> getEntries() {
                return b;
            }

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Enum r3 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r3;
                Enum[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r0);
            }

            public static Enum[] values() {
                return (Enum[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Enum fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return ONLY_MANAGER;
            L15:
                return ALL_MEMBERS;
            L12:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) r27.a.a(Enum.class, r1);
            }

            public Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
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
            public final UserCountVisibleSetting c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new UserCountVisibleSetting(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(UserCountVisibleSetting r2) {
                UserCountVisibleSetting r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, UserCountVisibleSetting r3) {
                UserCountVisibleSetting r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, UserCountVisibleSetting r3) {
                UserCountVisibleSetting r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<UserCountVisibleSetting> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chat.UserCountVisibleSetting", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ UserCountVisibleSetting(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(UserCountVisibleSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(UserCountVisibleSetting.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public UserCountVisibleSetting(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ UserCountVisibleSetting(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001d\u001e\u001fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006 "}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$WhiteListSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chat$WhiteListSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chat$WhiteListSetting$Builder;Lokio/ByteString;)V", "level", "Lcom/lark/kmp/pb/basic/v1/Chat$WhiteListSetting$LevelEnum;", "getLevel", "()Lcom/lark/kmp/pb/basic/v1/Chat$WhiteListSetting$LevelEnum;", "add_user_ids", "", "", "getAdd_user_ids", "()Ljava/util/List;", "del_user_ids", "getDel_user_ids", "member_list_user_ids", "getMember_list_user_ids", "hit_whitelist", "", "getHit_whitelist", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "", "Builder", "Companion", "LevelEnum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
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

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$WhiteListSetting$LevelEnum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "NO_MEMBER", "ONLY_ADMIN_AND_OWNER", "MEMBER_LIST", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum LevelEnum extends Enum<LevelEnum> implements o0 {
            public static final ProtoAdapter<LevelEnum> ADAPTER = null;
            public static final b Companion = null;
            public static final LevelEnum MEMBER_LIST = null;
            public static final LevelEnum NO_MEMBER = null;
            public static final LevelEnum ONLY_ADMIN_AND_OWNER = null;
            public static final LevelEnum UNKNOWN = null;
            public static final /* synthetic */ LevelEnum[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<LevelEnum> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    LevelEnum.Companion.getClass();
                    if (r2 == 0) goto L15;
                    if (r2 == 1) goto L19;
                    if (r2 == 2) goto L18;
                    if (r2 == 3) goto L17;
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

                public a(KClass<LevelEnum> r1, Syntax r2, LevelEnum r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<LevelEnum> getEntries() {
                return b;
            }

            static {
                LevelEnum r0 = new LevelEnum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                LevelEnum r1 = new LevelEnum("NO_MEMBER", 1, 1);
                NO_MEMBER = r1;
                LevelEnum r3 = new LevelEnum("ONLY_ADMIN_AND_OWNER", 2, 2);
                ONLY_ADMIN_AND_OWNER = r3;
                LevelEnum r5 = new LevelEnum("MEMBER_LIST", 3, 3);
                MEMBER_LIST = r5;
                LevelEnum[] r7 = {r0, r1, r3, r5};
                a = r7;
                b = EnumEntriesKt.enumEntries(r7);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(LevelEnum.class), Syntax.PROTO_2, r0);
            }

            public static LevelEnum[] values() {
                return (LevelEnum[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final LevelEnum fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L15;
                if (r1 == 1) goto L19;
                if (r1 == 2) goto L18;
                if (r1 == 3) goto L17;
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

            public static LevelEnum valueOf(String r1) {
                return (LevelEnum) r27.a.a(LevelEnum.class, r1);
            }

            public LevelEnum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<WhiteListSetting, a> {
            public LevelEnum d;
            public List<Long> e;
            public List<Long> f;
            public List<Long> g;
            public Boolean h;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new WhiteListSetting(this, c(), null);
            }

            public a() {
                this.e = CollectionsKt.emptyList();
                this.f = CollectionsKt.emptyList();
                this.g = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<WhiteListSetting> {
            @Override // com.lark.wire.ProtoAdapter
            public final WhiteListSetting c(g0 r12) {
                Intrinsics.checkNotNullParameter(r12, "reader");
                a r0 = new a();
                ArrayList r1 = new ArrayList();
                ArrayList r2 = new ArrayList();
                ArrayList r3 = new ArrayList();
                long r4 = r12.c();
            L3:
                int r6 = r12.e();
                if (r6 == (-1)) goto L24;
                if (r6 != 1) goto L8;
                r0.d = LevelEnum.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r7 = Unit.INSTANCE;
                goto L3
            L8:
                if (r6 != 2) goto L10;
                r1.add(ProtoAdapter.k.c(r12));
                goto L3
            L10:
                if (r6 != 3) goto L12;
                r2.add(ProtoAdapter.k.c(r12));
                goto L3
            L12:
                if (r6 != 4) goto L14;
                r3.add(ProtoAdapter.k.c(r12));
                goto L3
            L14:
                if (r6 != 5) goto L15;
                r0.h = (Boolean) ProtoAdapter.g.c(r12);
                goto L3
            L15:
                r12.j(r6);
                goto L3
            L24:
                ByteString r13 = r12.d(r4);
                Intrinsics.checkNotNullParameter(r1, "add_user_ids");
                com.lark.wire.internal.a.a(r1);
                r0.e = r1;
                Intrinsics.checkNotNullParameter(r2, "del_user_ids");
                com.lark.wire.internal.a.a(r2);
                r0.f = r2;
                Intrinsics.checkNotNullParameter(r3, "member_list_user_ids");
                com.lark.wire.internal.a.a(r3);
                r0.g = r3;
                return new WhiteListSetting(r0, r13, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(WhiteListSetting r6) {
                WhiteListSetting r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size() + LevelEnum.ADAPTER.l(1, r7.getLevel());
                t r1 = ProtoAdapter.k;
                return (((r0 + r1.a().l(2, r7.getAdd_user_ids())) + r1.a().l(3, r7.getDel_user_ids())) + r1.a().l(4, r7.getMember_list_user_ids())) + ProtoAdapter.g.l(5, r7.getHit_whitelist());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, WhiteListSetting r6) {
                WhiteListSetting r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                LevelEnum.ADAPTER.i(r5, 1, r7.getLevel());
                t r0 = ProtoAdapter.k;
                r0.a().i(r5, 2, r7.getAdd_user_ids());
                r0.a().i(r5, 3, r7.getDel_user_ids());
                r0.a().i(r5, 4, r7.getMember_list_user_ids());
                ProtoAdapter.g.i(r5, 5, r7.getHit_whitelist());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, WhiteListSetting r6) {
                WhiteListSetting r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                ProtoAdapter.g.j(r5, 5, r7.getHit_whitelist());
                t r0 = ProtoAdapter.k;
                r0.a().j(r5, 4, r7.getMember_list_user_ids());
                r0.a().j(r5, 3, r7.getDel_user_ids());
                r0.a().j(r5, 2, r7.getAdd_user_ids());
                LevelEnum.ADAPTER.j(r5, 1, r7.getLevel());
            }

            public b(FieldEncoding r7, KClass<WhiteListSetting> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chat.WhiteListSetting", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ WhiteListSetting(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            DEFAULT_LEVEL = LevelEnum.NO_MEMBER;
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(WhiteListSetting.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.level;
            r0.e = this.add_user_ids;
            r0.f = this.del_user_ids;
            r0.g = this.member_list_user_ids;
            r0.h = this.hit_whitelist;
            r0.a(unknownFields());
            return r0;
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

        public WhiteListSetting(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.level = r2.d;
            this.add_user_ids = com.lark.wire.internal.a.c("add_user_ids", r2.e);
            this.del_user_ids = com.lark.wire.internal.a.c("del_user_ids", r2.f);
            this.member_list_user_ids = com.lark.wire.internal.a.c("member_list_user_ids", r2.g);
            this.hit_whitelist = r2.h;
        }

        public /* synthetic */ WhiteListSetting(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chat$WidgetState;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "EXPAND", "FOLD", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum WidgetState extends Enum<WidgetState> implements o0 {
        public static final ProtoAdapter<WidgetState> ADAPTER = null;
        public static final b Companion = null;
        public static final WidgetState EXPAND = null;
        public static final WidgetState FOLD = null;
        public static final /* synthetic */ WidgetState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<WidgetState> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                WidgetState.Companion.getClass();
                if (r2 == 0) goto L9;
                if (r2 == 1) goto L11;
                return null;
            L11:
                return WidgetState.FOLD;
            L9:
                return WidgetState.EXPAND;
            }

            public a(KClass<WidgetState> r1, Syntax r2, WidgetState r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<WidgetState> getEntries() {
            return b;
        }

        static {
            WidgetState r0 = new WidgetState("EXPAND", 0, 0);
            EXPAND = r0;
            WidgetState r1 = new WidgetState("FOLD", 1, 1);
            FOLD = r1;
            WidgetState[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(WidgetState.class), Syntax.PROTO_2, r0);
        }

        public static WidgetState[] values() {
            return (WidgetState[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final WidgetState fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L9;
            if (r1 == 1) goto L11;
            return null;
        L11:
            return FOLD;
        L9:
            return EXPAND;
        }

        public static WidgetState valueOf(String r1) {
            return (WidgetState) r27.a.a(WidgetState.class, r1);
        }

        public WidgetState(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
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
        public MessagePosition.Enum J;
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
        public ChatMode a0;
        public TeamChatType a1;
        public String b0;
        public Map<Integer, Integer> b1;
        public Integer c0;
        public List<ChatTeamInfo> c1;
        public String d;
        public Integer d0;
        public Map<Long, Team> d1;
        public Type e;
        public Integer e0;
        public List<ChatTeamInfo> e1;
        public String f;
        public Integer f0;
        public ChatUserAutoMuteSetting f1;
        public String g;
        public Integer g0;
        public Long g1;
        public Integer h;
        public Integer h0;
        public Long h1;
        public Integer i;
        public Integer i0;
        public CommonAIReply.Status i1;
        public Long j;
        public String j0;
        public Integer j1;
        public String k;
        public Boolean k0;
        public String k1;
        public String l;
        public String l0;
        public Boolean l1;
        public Long m;
        public Integer m0;
        public Boolean m1;
        public String n;
        public Float n0;
        public Boolean n1;
        public Image o;
        public Boolean o0;
        public Boolean o1;
        public String p;
        public Boolean p0;
        public Boolean p1;
        public Integer q;
        public Boolean q0;
        public Boolean q1;
        public Integer r;
        public Boolean r0;
        public String r1;
        public Boolean s;
        public Boolean s0;
        public Boolean s1;
        public Boolean t;
        public Boolean t0;
        public Boolean t1;
        public Boolean u;
        public Boolean u0;
        public TypingTranslateSetting u1;
        public Boolean v;
        public Boolean v0;
        public List<FeedTag> v1;
        public Boolean w;
        public AddMemberPermission.Enum w0;
        public Boolean w1;
        public String x;
        public AtAllPermission.Enum x0;
        public Boolean x1;
        public Role y;
        public SystemMessageVisible.Enum y0;
        public String y1;
        public Boolean z;
        public SystemMessageVisible.Enum z0;
        public List<String> z1;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new Chat(this, c(), null);
        }

        public a() {
            this.O0 = CollectionsKt.emptyList();
            this.b1 = MapsKt.emptyMap();
            this.c1 = CollectionsKt.emptyList();
            this.d1 = MapsKt.emptyMap();
            this.e1 = CollectionsKt.emptyList();
            this.v1 = CollectionsKt.emptyList();
            this.z1 = CollectionsKt.emptyList();
            this.P1 = CollectionsKt.emptyList();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ Chat(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
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
        SystemMessageVisible.Enum r0 = SystemMessageVisible.Enum.ONLY_OWNER;
        DEFAULT_JOIN_MESSAGE_VISIBLE = r0;
        DEFAULT_QUIT_MESSAGE_VISIBLE = r0;
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
        final FieldEncoding r1 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r2 = Reflection.getOrCreateKotlinClass(Chat.class);
        final Syntax r3 = Syntax.PROTO_2;
        ADAPTER = new Chat$Companion$ADAPTER$1(r1, r2, r3);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.type;
        r0.f = this.name;
        r0.g = this.last_message_id;
        r0.h = this.last_message_position;
        r0.i = this.new_message_count;
        r0.j = this.update_time;
        r0.k = this.avatar_key;
        r0.l = this.chatter_id;
        r0.m = this.create_time;
        r0.n = this.description;
        r0.o = this.avatar;
        r0.p = this.owner_id;
        r0.q = this.chatter_count;
        r0.r = this.user_count;
        r0.s = this.is_department;
        r0.t = this.is_public;
        r0.u = this.is_archived;
        r0.v = this.is_deleted;
        r0.w = this.is_remind;
        r0.x = this.name_pinyin;
        r0.y = this.role;
        r0.z = this.is_customer_service;
        r0.A = this.text_draft_id;
        r0.B = this.post_draft_id;
        r0.C = this.no_badged_new_message_count;
        r0.D = this.is_shortcut;
        r0.E = this.announcement;
        r0.F = this.off_edit_group_chat_info;
        r0.G = this.tenant_id;
        r0.H = this.is_custom_icon;
        r0.I = this.is_dissolved;
        r0.J = this.message_position;
        r0.K = this.feed_type;
        r0.L = this.last_visible_message_id;
        r0.M = this.burn_life;
        r0.N = this.is_crypto;
        r0.O = this.is_meeting;
        r0.P = this.is_cross_tenant;
        r0.Q = this.is_support_view;
        r0.R = this.first_message_position;
        r0.S = this.oncall_id;
        r0.T = this.last_visible_message_position;
        r0.U = this.read_position;
        r0.V = this.read_position_badge_count;
        r0.W = this.last_message_position_badge_count;
        r0.X = this.is_public_v2;
        r0.Y = this.allow_post;
        r0.Z = this.post_type;
        r0.a0 = this.chat_mode;
        r0.b0 = this.last_thread_id;
        r0.c0 = this.last_thread_position;
        r0.d0 = this.new_thread_count;
        r0.e0 = this.no_badged_new_thread_count;
        r0.f0 = this.last_thread_position_badge_count;
        r0.g0 = this.read_thread_position;
        r0.h0 = this.read_thread_position_badge_count;
        r0.i0 = this.last_visible_thread_position;
        r0.j0 = this.last_visible_thread_id;
        r0.k0 = this.show_nickname;
        r0.l0 = this.last_draft_id;
        r0.m0 = this.last_read_position;
        r0.n0 = this.last_read_offset;
        r0.o0 = this.is_edu;
        r0.p0 = this.is_admin;
        r0.q0 = this.is_mute_at_all;
        r0.r0 = this.is_delayed;
        r0.s0 = this.is_p2p_ai;
        r0.t0 = this.is_ocic_customer_service;
        r0.u0 = this.is_p2p_official_bot_ai;
        r0.v0 = this.is_temp_top_feed;
        r0.w0 = this.add_member_permission;
        r0.x0 = this.at_all_permission;
        r0.y0 = this.join_message_visible;
        r0.z0 = this.quit_message_visible;
        r0.A0 = this.share_card_permission;
        r0.B0 = this.add_member_apply;
        r0.C0 = this.message_visibility_setting;
        r0.D0 = this.create_urgent_setting;
        r0.E0 = this.create_video_conference_setting;
        r0.F0 = this.pin_permission_setting;
        r0.G0 = this.top_notice_permission_setting;
        r0.H0 = this.chat_tab_permission_setting;
        r0.I0 = this.chat_display_mode_setting;
        r0.J0 = this.chat_pin_permission_setting;
        r0.K0 = this.put_chatter_apply_count;
        r0.L0 = this.show_banner;
        r0.M0 = this.mini_avatar_key;
        r0.N0 = this.sidebar_id;
        r0.O0 = this.sidebar_buttons;
        r0.P0 = this.my_threads_read_timestamp;
        r0.Q0 = this.my_threads_last_timestamp;
        r0.R0 = this.my_threads_unread_count;
        r0.S0 = this.my_threads_last_display_message_id;
        r0.T0 = this.anonymous_setting;
        r0.U0 = this.anonymous_total_quota;
        r0.V0 = this.is_cross_with_ka;
        r0.W0 = this.anonymous_id;
        r0.X0 = this.is_team;
        r0.Y0 = this.team_id;
        r0.Z0 = this.team_name;
        r0.a1 = this.team_chat_type;
        r0.b1 = this.chatter_extra_states;
        r0.c1 = this.joined_team_infos;
        r0.d1 = this.joined_teams;
        r0.e1 = this.bound_team_infos;
        r0.f1 = this.user_auto_mute;
        r0.g1 = this.ai_knowledge_query_id;
        r0.h1 = this.query_create_time;
        r0.i1 = this.query_status;
        r0.j1 = this.query_seq_id;
        r0.k1 = this.edit_message_draft_id;
        r0.l1 = this.chatable;
        r0.m1 = this.muteable;
        r0.n1 = this.is_super;
        r0.o1 = this.is_private_mode;
        r0.p1 = this.is_tenant;
        r0.q1 = this.is_in_box;
        r0.r1 = this.box_id;
        r0.s1 = this.is_auto_translate;
        r0.t1 = this.is_auto_typing_translate;
        r0.u1 = this.typing_translate_setting;
        r0.v1 = this.feed_tag;
        r0.w1 = this.is_flag;
        r0.x1 = this.has_water_mark;
        r0.y1 = this.avatar_path;
        r0.z1 = this.avatar_urls;
        r0.A1 = this.first_chat_message_position;
        r0.B1 = this.tag_info;
        r0.C1 = this.is_fake;
        r0.D1 = this.typing_translate_has_auto_opened;
        r0.E1 = this.is_official_oncall;
        r0.F1 = this.is_offline_oncall;
        r0.G1 = this.restricted_mode_setting;
        r0.H1 = this.def_display_setting;
        r0.I1 = this.schedule_message_draft_id;
        r0.J1 = this.has_vc_chat_permission;
        r0.K1 = this.admin_post_setting;
        r0.L1 = this.can_be_sorted_alphabetically;
        r0.M1 = this.user_count_visible_setting;
        r0.N1 = this.is_user_count_visible;
        r0.O1 = this.doubao_setting;
        r0.P1 = this.tags;
        r0.Q1 = this.theme_id;
        r0.R1 = this.is_frozen;
        r0.S1 = this.banner_setting;
        r0.T1 = this.can_translate_name;
        r0.U1 = this.should_display_translated_name;
        r0.V1 = this.translated_name;
        r0.W1 = this.name_major_language;
        r0.X1 = this.name_translate_language;
        r0.Y1 = this.tns_info;
        r0.a(unknownFields());
        return r0;
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
        return this.id;
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

    public Chat(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.id = r4;
        this.type = r2.e;
        this.name = r2.f;
        this.last_message_id = r2.g;
        this.last_message_position = r2.h;
        this.new_message_count = r2.i;
        this.update_time = r2.j;
        this.avatar_key = r2.k;
        this.chatter_id = r2.l;
        this.create_time = r2.m;
        this.description = r2.n;
        this.avatar = r2.o;
        this.owner_id = r2.p;
        this.chatter_count = r2.q;
        this.user_count = r2.r;
        this.is_department = r2.s;
        this.is_public = r2.t;
        this.is_archived = r2.u;
        this.is_deleted = r2.v;
        this.is_remind = r2.w;
        this.name_pinyin = r2.x;
        this.role = r2.y;
        this.is_customer_service = r2.z;
        this.text_draft_id = r2.A;
        this.post_draft_id = r2.B;
        this.no_badged_new_message_count = r2.C;
        this.is_shortcut = r2.D;
        this.announcement = r2.E;
        this.off_edit_group_chat_info = r2.F;
        this.tenant_id = r2.G;
        this.is_custom_icon = r2.H;
        this.is_dissolved = r2.I;
        this.message_position = r2.J;
        this.feed_type = r2.K;
        this.last_visible_message_id = r2.L;
        this.burn_life = r2.M;
        this.is_crypto = r2.N;
        this.is_meeting = r2.O;
        this.is_cross_tenant = r2.P;
        this.is_support_view = r2.Q;
        this.first_message_position = r2.R;
        this.oncall_id = r2.S;
        this.last_visible_message_position = r2.T;
        this.read_position = r2.U;
        this.read_position_badge_count = r2.V;
        this.last_message_position_badge_count = r2.W;
        this.is_public_v2 = r2.X;
        this.allow_post = r2.Y;
        this.post_type = r2.Z;
        this.chat_mode = r2.a0;
        this.last_thread_id = r2.b0;
        this.last_thread_position = r2.c0;
        this.new_thread_count = r2.d0;
        this.no_badged_new_thread_count = r2.e0;
        this.last_thread_position_badge_count = r2.f0;
        this.read_thread_position = r2.g0;
        this.read_thread_position_badge_count = r2.h0;
        this.last_visible_thread_position = r2.i0;
        this.last_visible_thread_id = r2.j0;
        this.show_nickname = r2.k0;
        this.last_draft_id = r2.l0;
        this.last_read_position = r2.m0;
        this.last_read_offset = r2.n0;
        this.is_edu = r2.o0;
        this.is_admin = r2.p0;
        this.is_mute_at_all = r2.q0;
        this.is_delayed = r2.r0;
        this.is_p2p_ai = r2.s0;
        this.is_ocic_customer_service = r2.t0;
        this.is_p2p_official_bot_ai = r2.u0;
        this.is_temp_top_feed = r2.v0;
        this.add_member_permission = r2.w0;
        this.at_all_permission = r2.x0;
        this.join_message_visible = r2.y0;
        this.quit_message_visible = r2.z0;
        this.share_card_permission = r2.A0;
        this.add_member_apply = r2.B0;
        this.message_visibility_setting = r2.C0;
        this.create_urgent_setting = r2.D0;
        this.create_video_conference_setting = r2.E0;
        this.pin_permission_setting = r2.F0;
        this.top_notice_permission_setting = r2.G0;
        this.chat_tab_permission_setting = r2.H0;
        this.chat_display_mode_setting = r2.I0;
        this.chat_pin_permission_setting = r2.J0;
        this.put_chatter_apply_count = r2.K0;
        this.show_banner = r2.L0;
        this.mini_avatar_key = r2.M0;
        this.sidebar_id = r2.N0;
        this.sidebar_buttons = com.lark.wire.internal.a.c("sidebar_buttons", r2.O0);
        this.my_threads_read_timestamp = r2.P0;
        this.my_threads_last_timestamp = r2.Q0;
        this.my_threads_unread_count = r2.R0;
        this.my_threads_last_display_message_id = r2.S0;
        this.anonymous_setting = r2.T0;
        this.anonymous_total_quota = r2.U0;
        this.is_cross_with_ka = r2.V0;
        this.anonymous_id = r2.W0;
        this.is_team = r2.X0;
        this.team_id = r2.Y0;
        this.team_name = r2.Z0;
        this.team_chat_type = r2.a1;
        this.chatter_extra_states = com.lark.wire.internal.a.d("chatter_extra_states", r2.b1);
        this.joined_team_infos = com.lark.wire.internal.a.c("joined_team_infos", r2.c1);
        this.joined_teams = com.lark.wire.internal.a.d("joined_teams", r2.d1);
        this.bound_team_infos = com.lark.wire.internal.a.c("bound_team_infos", r2.e1);
        this.user_auto_mute = r2.f1;
        this.ai_knowledge_query_id = r2.g1;
        this.query_create_time = r2.h1;
        this.query_status = r2.i1;
        this.query_seq_id = r2.j1;
        this.edit_message_draft_id = r2.k1;
        this.chatable = r2.l1;
        this.muteable = r2.m1;
        this.is_super = r2.n1;
        this.is_private_mode = r2.o1;
        this.is_tenant = r2.p1;
        this.is_in_box = r2.q1;
        this.box_id = r2.r1;
        this.is_auto_translate = r2.s1;
        this.is_auto_typing_translate = r2.t1;
        this.typing_translate_setting = r2.u1;
        this.feed_tag = com.lark.wire.internal.a.c("feed_tag", r2.v1);
        this.is_flag = r2.w1;
        this.has_water_mark = r2.x1;
        this.avatar_path = r2.y1;
        this.avatar_urls = com.lark.wire.internal.a.c("avatar_urls", r2.z1);
        this.first_chat_message_position = r2.A1;
        this.tag_info = r2.B1;
        this.is_fake = r2.C1;
        this.typing_translate_has_auto_opened = r2.D1;
        this.is_official_oncall = r2.E1;
        this.is_offline_oncall = r2.F1;
        this.restricted_mode_setting = r2.G1;
        this.def_display_setting = r2.H1;
        this.schedule_message_draft_id = r2.I1;
        this.has_vc_chat_permission = r2.J1;
        this.admin_post_setting = r2.K1;
        this.can_be_sorted_alphabetically = r2.L1;
        this.user_count_visible_setting = r2.M1;
        this.is_user_count_visible = r2.N1;
        this.doubao_setting = r2.O1;
        this.tags = com.lark.wire.internal.a.c("tags", r2.P1);
        this.theme_id = r2.Q1;
        this.is_frozen = r2.R1;
        this.banner_setting = r2.S1;
        this.can_translate_name = r2.T1;
        this.should_display_translated_name = r2.U1;
        this.translated_name = r2.V1;
        this.name_major_language = r2.W1;
        this.name_translate_language = r2.X1;
        this.tns_info = r2.Y1;
    }

    public /* synthetic */ Chat(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
