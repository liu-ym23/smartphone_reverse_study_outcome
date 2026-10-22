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
import com.larksuite.component.card.protocol.context.action.CardActionService;
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
@Metadata(d1 = {"\u0000¸\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \u0018\u0000 ²\u00022\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:6±\u0002²\u0002³\u0002´\u0002µ\u0002¶\u0002·\u0002¸\u0002¹\u0002º\u0002»\u0002¼\u0002½\u0002¾\u0002¿\u0002À\u0002Á\u0002Â\u0002Ã\u0002Ä\u0002Å\u0002Æ\u0002Ç\u0002È\u0002É\u0002Ê\u0002Ë\u0002B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010¯\u0002\u001a\u00020\u0002H\u0016J\t\u0010°\u0002\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010)\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u000bR\u0015\u0010+\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R\u0015\u00100\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010/\u001a\u0004\b0\u0010.R\u0015\u00101\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010/\u001a\u0004\b1\u0010.R\u0015\u00102\u001a\u0004\u0018\u00010&¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u0015\u00106\u001a\u0004\u0018\u00010&¢\u0006\n\n\u0002\u00105\u001a\u0004\b7\u00104R\u0013\u00108\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u000bR\u0015\u0010:\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010/\u001a\u0004\b;\u0010.R\u0013\u0010<\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u000bR\u0013\u0010>\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u000bR\u0013\u0010@\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u000bR\u0015\u0010B\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010/\u001a\u0004\bB\u0010.R\u0013\u0010C\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u000bR\u0013\u0010E\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u000bR\u0015\u0010G\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010/\u001a\u0004\bG\u0010.R\u0015\u0010H\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010/\u001a\u0004\bH\u0010.R\u0015\u0010I\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010/\u001a\u0004\bI\u0010.R\u0015\u0010J\u001a\u0004\u0018\u00010&¢\u0006\n\n\u0002\u00105\u001a\u0004\bK\u00104R\"\u0010L\u001a\b\u0012\u0004\u0012\u00020\t0!8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bM\u0010N\u001a\u0004\bO\u0010$R\u0013\u0010P\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u000bR\u0013\u0010R\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u000bR\u0015\u0010T\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010/\u001a\u0004\bT\u0010.R\u0015\u0010U\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010/\u001a\u0004\bU\u0010.R\u0015\u0010V\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010/\u001a\u0004\bV\u0010.R\u0013\u0010W\u001a\u0004\u0018\u00010X¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0013\u0010[\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010\u000bR\u0017\u0010]\u001a\b\u0012\u0004\u0012\u00020\t0!¢\u0006\b\n\u0000\u001a\u0004\b^\u0010$R\u0017\u0010_\u001a\b\u0012\u0004\u0012\u00020\t0!¢\u0006\b\n\u0000\u001a\u0004\b`\u0010$R\u0013\u0010a\u001a\u0004\u0018\u00010b¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u0015\u0010e\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010/\u001a\u0004\be\u0010.R\u0015\u0010f\u001a\u0004\u0018\u00010&¢\u0006\n\n\u0002\u00105\u001a\u0004\bg\u00104R\u0015\u0010h\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010k\u001a\u0004\bi\u0010jR\u0015\u0010l\u001a\u0004\u0018\u00010&¢\u0006\n\n\u0002\u00105\u001a\u0004\bm\u00104R\u0013\u0010n\u001a\u0004\u0018\u00010o¢\u0006\b\n\u0000\u001a\u0004\bp\u0010qR\u0013\u0010r\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bs\u0010\u000bR\u0013\u0010t\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bu\u0010\u000bR\u0013\u0010v\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bw\u0010\u000bR\u0013\u0010x\u001a\u0004\u0018\u00010y¢\u0006\b\n\u0000\u001a\u0004\bz\u0010{R\u0013\u0010|\u001a\u0004\u0018\u00010}¢\u0006\b\n\u0000\u001a\u0004\b~\u0010\u007fR\u0017\u0010\u0080\u0001\u001a\u0004\u0018\u00010&¢\u0006\u000b\n\u0002\u00105\u001a\u0005\b\u0081\u0001\u00104R\u0017\u0010\u0082\u0001\u001a\u0004\u0018\u00010,¢\u0006\u000b\n\u0002\u0010/\u001a\u0005\b\u0082\u0001\u0010.R\u0017\u0010\u0083\u0001\u001a\u0004\u0018\u00010,¢\u0006\u000b\n\u0002\u0010/\u001a\u0005\b\u0083\u0001\u0010.R\u0017\u0010\u0084\u0001\u001a\u0004\u0018\u00010,¢\u0006\u000b\n\u0002\u0010/\u001a\u0005\b\u0084\u0001\u0010.R\u0019\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\t0!¢\u0006\t\n\u0000\u001a\u0005\b\u0086\u0001\u0010$R\u0017\u0010\u0087\u0001\u001a\u0004\u0018\u00010&¢\u0006\u000b\n\u0002\u00105\u001a\u0005\b\u0088\u0001\u00104R\u0017\u0010\u0089\u0001\u001a\u0004\u0018\u00010&¢\u0006\u000b\n\u0002\u00105\u001a\u0005\b\u008a\u0001\u00104R\u0019\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020\t0!¢\u0006\t\n\u0000\u001a\u0005\b\u008c\u0001\u0010$R\u0017\u0010\u008d\u0001\u001a\u0004\u0018\u00010,¢\u0006\u000b\n\u0002\u0010/\u001a\u0005\b\u008d\u0001\u0010.R\u0015\u0010\u008e\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b\u008f\u0001\u0010\u000bR\u0017\u0010\u0090\u0001\u001a\u0004\u0018\u00010,¢\u0006\u000b\n\u0002\u0010/\u001a\u0005\b\u0090\u0001\u0010.R\u0017\u0010\u0091\u0001\u001a\u0004\u0018\u00010,¢\u0006\u000b\n\u0002\u0010/\u001a\u0005\b\u0091\u0001\u0010.R\u0017\u0010\u0092\u0001\u001a\u0004\u0018\u00010&¢\u0006\u000b\n\u0002\u00105\u001a\u0005\b\u0093\u0001\u00104R\u0017\u0010\u0094\u0001\u001a\u0004\u0018\u00010&¢\u0006\u000b\n\u0002\u00105\u001a\u0005\b\u0095\u0001\u00104R\u0017\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0015\u0010\u009a\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b\u009b\u0001\u0010\u000bR\u0017\u0010\u009c\u0001\u001a\u0004\u0018\u00010,¢\u0006\u000b\n\u0002\u0010/\u001a\u0005\b\u009c\u0001\u0010.R\u0017\u0010\u009d\u0001\u001a\u0004\u0018\u00010,¢\u0006\u000b\n\u0002\u0010/\u001a\u0005\b\u009d\u0001\u0010.R\u0017\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u0001¢\u0006\n\n\u0000\u001a\u0006\b \u0001\u0010¡\u0001R\u0017\u0010¢\u0001\u001a\u0004\u0018\u00010,¢\u0006\u000b\n\u0002\u0010/\u001a\u0005\b¢\u0001\u0010.R\u0015\u0010£\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b¤\u0001\u0010\u000bR\u0017\u0010¥\u0001\u001a\u0004\u0018\u00010,¢\u0006\u000b\n\u0002\u0010/\u001a\u0005\b¦\u0001\u0010.R#\u0010§\u0001\u001a\u0004\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\u0012\n\u0002\u0010/\u0012\u0005\b¨\u0001\u0010N\u001a\u0005\b©\u0001\u0010.R\u0017\u0010ª\u0001\u001a\u0004\u0018\u00010,¢\u0006\u000b\n\u0002\u0010/\u001a\u0005\bª\u0001\u0010.R\"\u0010«\u0001\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0005\u0012\u00030\u00ad\u00010¬\u0001¢\u0006\n\n\u0000\u001a\u0006\b®\u0001\u0010¯\u0001R\u0017\u0010°\u0001\u001a\u0004\u0018\u00010,¢\u0006\u000b\n\u0002\u0010/\u001a\u0005\b°\u0001\u0010.R\u0017\u0010±\u0001\u001a\u0004\u0018\u00010,¢\u0006\u000b\n\u0002\u0010/\u001a\u0005\b±\u0001\u0010.R\u0017\u0010²\u0001\u001a\u0005\u0018\u00010³\u0001¢\u0006\n\n\u0000\u001a\u0006\b´\u0001\u0010µ\u0001R\u0017\u0010¶\u0001\u001a\u0004\u0018\u00010&¢\u0006\u000b\n\u0002\u00105\u001a\u0005\b·\u0001\u00104R\u0015\u0010¸\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b¹\u0001\u0010\u000bR\u0017\u0010º\u0001\u001a\u0004\u0018\u00010,¢\u0006\u000b\n\u0002\u0010/\u001a\u0005\b»\u0001\u0010.R\u0017\u0010¼\u0001\u001a\u0005\u0018\u00010½\u0001¢\u0006\n\n\u0000\u001a\u0006\b¾\u0001\u0010¿\u0001R\u0017\u0010À\u0001\u001a\u0004\u0018\u00010,¢\u0006\u000b\n\u0002\u0010/\u001a\u0005\bÀ\u0001\u0010.R\u0017\u0010Á\u0001\u001a\u0005\u0018\u00010Â\u0001¢\u0006\n\n\u0000\u001a\u0006\bÃ\u0001\u0010Ä\u0001R\u0017\u0010Å\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u000b\n\u0002\u0010k\u001a\u0005\bÆ\u0001\u0010jR!\u0010Ç\u0001\u001a\u000f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0¬\u0001¢\u0006\n\n\u0000\u001a\u0006\bÈ\u0001\u0010¯\u0001R\u0017\u0010É\u0001\u001a\u0004\u0018\u00010,¢\u0006\u000b\n\u0002\u0010/\u001a\u0005\bÊ\u0001\u0010.R\u0017\u0010Ë\u0001\u001a\u0004\u0018\u00010&¢\u0006\u000b\n\u0002\u00105\u001a\u0005\bÌ\u0001\u00104R\u0017\u0010Í\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u000b\n\u0002\u0010k\u001a\u0005\bÎ\u0001\u0010jR\u0015\u0010Ï\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bÐ\u0001\u0010\u000bR\u0017\u0010Ñ\u0001\u001a\u0005\u0018\u00010Ò\u0001¢\u0006\n\n\u0000\u001a\u0006\bÓ\u0001\u0010Ô\u0001R\u0019\u0010Õ\u0001\u001a\b\u0012\u0004\u0012\u00020\t0!¢\u0006\t\n\u0000\u001a\u0005\bÖ\u0001\u0010$R\u0017\u0010×\u0001\u001a\u0005\u0018\u00010Ø\u0001¢\u0006\n\n\u0000\u001a\u0006\bÙ\u0001\u0010Ú\u0001R\u0017\u0010Û\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u000b\n\u0002\u0010k\u001a\u0005\bÜ\u0001\u0010jR\u0017\u0010Ý\u0001\u001a\u0005\u0018\u00010Þ\u0001¢\u0006\n\n\u0000\u001a\u0006\bß\u0001\u0010à\u0001R\u0015\u0010á\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bâ\u0001\u0010\u000bR\u0017\u0010ã\u0001\u001a\u0005\u0018\u00010ä\u0001¢\u0006\n\n\u0000\u001a\u0006\bå\u0001\u0010æ\u0001R\u0017\u0010ç\u0001\u001a\u0004\u0018\u00010,¢\u0006\u000b\n\u0002\u0010/\u001a\u0005\bç\u0001\u0010.R\u0017\u0010è\u0001\u001a\u0004\u0018\u00010,¢\u0006\u000b\n\u0002\u0010/\u001a\u0005\bé\u0001\u0010.R\u0017\u0010ê\u0001\u001a\u0005\u0018\u00010ë\u0001¢\u0006\n\n\u0000\u001a\u0006\bì\u0001\u0010í\u0001R\u0017\u0010î\u0001\u001a\u0004\u0018\u00010,¢\u0006\u000b\n\u0002\u0010/\u001a\u0005\bî\u0001\u0010.R\u0017\u0010ï\u0001\u001a\u0004\u0018\u00010,¢\u0006\u000b\n\u0002\u0010/\u001a\u0005\bï\u0001\u0010.R\u0017\u0010ð\u0001\u001a\u0005\u0018\u00010ñ\u0001¢\u0006\n\n\u0000\u001a\u0006\bò\u0001\u0010ó\u0001R\u0017\u0010ô\u0001\u001a\u0005\u0018\u00010õ\u0001¢\u0006\n\n\u0000\u001a\u0006\bö\u0001\u0010÷\u0001R\u0017\u0010ø\u0001\u001a\u0004\u0018\u00010&¢\u0006\u000b\n\u0002\u00105\u001a\u0005\bù\u0001\u00104R\u0017\u0010ú\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u000b\n\u0002\u0010k\u001a\u0005\bû\u0001\u0010jR\u0015\u0010ü\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bý\u0001\u0010\u000bR\u0017\u0010þ\u0001\u001a\u0005\u0018\u00010ÿ\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0080\u0002\u0010\u0081\u0002R\u0017\u0010\u0082\u0002\u001a\u0005\u0018\u00010\u0083\u0002¢\u0006\n\n\u0000\u001a\u0006\b\u0084\u0002\u0010\u0085\u0002R\u0017\u0010\u0086\u0002\u001a\u0004\u0018\u00010\u0015¢\u0006\u000b\n\u0002\u0010k\u001a\u0005\b\u0087\u0002\u0010jR\u0017\u0010\u0088\u0002\u001a\u0005\u0018\u00010\u0089\u0002¢\u0006\n\n\u0000\u001a\u0006\b\u008a\u0002\u0010\u008b\u0002R\u0017\u0010\u008c\u0002\u001a\u0004\u0018\u00010\u0015¢\u0006\u000b\n\u0002\u0010k\u001a\u0005\b\u008d\u0002\u0010jR\u0017\u0010\u008e\u0002\u001a\u0004\u0018\u00010,¢\u0006\u000b\n\u0002\u0010/\u001a\u0005\b\u008f\u0002\u0010.R\u0017\u0010\u0090\u0002\u001a\u0005\u0018\u00010\u0091\u0002¢\u0006\n\n\u0000\u001a\u0006\b\u0092\u0002\u0010\u0093\u0002R\u0017\u0010\u0094\u0002\u001a\u0004\u0018\u00010,¢\u0006\u000b\n\u0002\u0010/\u001a\u0005\b\u0094\u0002\u0010.R\u0017\u0010\u0095\u0002\u001a\u0005\u0018\u00010\u0096\u0002¢\u0006\n\n\u0000\u001a\u0006\b\u0097\u0002\u0010\u0098\u0002R\u0017\u0010\u0099\u0002\u001a\u0004\u0018\u00010,¢\u0006\u000b\n\u0002\u0010/\u001a\u0005\b\u009a\u0002\u0010.R\u0017\u0010\u009b\u0002\u001a\u0005\u0018\u00010\u009c\u0002¢\u0006\n\n\u0000\u001a\u0006\b\u009d\u0002\u0010\u009e\u0002R\u0017\u0010\u009f\u0002\u001a\u0005\u0018\u00010 \u0002¢\u0006\n\n\u0000\u001a\u0006\b¡\u0002\u0010¢\u0002R\u0017\u0010£\u0002\u001a\u0005\u0018\u00010¤\u0002¢\u0006\n\n\u0000\u001a\u0006\b¥\u0002\u0010¦\u0002R\u0017\u0010§\u0002\u001a\u0005\u0018\u00010¨\u0002¢\u0006\n\n\u0000\u001a\u0006\b©\u0002\u0010ª\u0002R\u0017\u0010«\u0002\u001a\u0005\u0018\u00010¬\u0002¢\u0006\n\n\u0000\u001a\u0006\b\u00ad\u0002\u0010®\u0002¨\u0006Ì\u0002"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Message$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Message$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "type", "Lcom/lark/kmp/pb/basic/v1/Message$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/Message$Type;", "chat_id", "getChat_id", "thread_id", "getThread_id", "create_time", "", "getCreate_time", "()J", "update_time", "getUpdate_time", "root_id", "getRoot_id", "content", "Lcom/lark/kmp/pb/basic/v1/Content;", "getContent", "()Lcom/lark/kmp/pb/basic/v1/Content;", "reactions", "", "Lcom/lark/kmp/pb/basic/v1/Message$Reaction;", "getReactions", "()Ljava/util/List;", "unread_count", "", "getUnread_count", "()I", "from_id", "getFrom_id", "should_notify", "", "getShould_notify", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_recalled", "is_edited", "reply_count", "getReply_count", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "position", "getPosition", "cid", "getCid", "me_read", "getMe_read", "reminder_id", "getReminder_id", "parent_source_id", "getParent_source_id", "root_source_id", "getRoot_source_id", "is_urgent", "urgent_id", "getUrgent_id", "parent_id", "getParent_id", "is_at_me", "is_at_all", "is_truncated", "read_count", "getRead_count", "unread_chatter_ids", "getUnread_chatter_ids$annotations", "()V", "getUnread_chatter_ids", "text_draft_id", "getText_draft_id", "post_draft_id", "getPost_draft_id", "is_file_deleted", "is_deleted", "is_abnormal", "from_type", "Lcom/lark/kmp/pb/basic/v1/Message$FromType;", "getFrom_type", "()Lcom/lark/kmp/pb/basic/v1/Message$FromType;", "doc_key", "getDoc_key", "unack_urgent_chatter_ids", "getUnack_urgent_chatter_ids", "ack_urgent_chatter_ids", "getAck_urgent_chatter_ids", "channel", "Lcom/lark/kmp/pb/basic/v1/Channel;", "getChannel", "()Lcom/lark/kmp/pb/basic/v1/Channel;", "is_visible", "burn_life", "getBurn_life", "burn_time", "getBurn_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "thread_position", "getThread_position", "source_type", "Lcom/lark/kmp/pb/basic/v1/Message$SourceType;", "getSource_type", "()Lcom/lark/kmp/pb/basic/v1/Message$SourceType;", "source_id", "getSource_id", "translate_language", "getTranslate_language", "recaller_id", "getRecaller_id", "recaller_identity", "Lcom/lark/kmp/pb/basic/v1/Message$RecallerIdentity;", "getRecaller_identity", "()Lcom/lark/kmp/pb/basic/v1/Message$RecallerIdentity;", "pin", "Lcom/lark/kmp/pb/basic/v1/Message$Pin;", "getPin", "()Lcom/lark/kmp/pb/basic/v1/Message$Pin;", "badge_count", "getBadge_count", "is_reeditable", "is_badged", "is_untranslateable", "read_at_chatter_ids", "getRead_at_chatter_ids", "thread_badge_count", "getThread_badge_count", "thread_reply_count", "getThread_reply_count", "at_out_chatter_ids", "getAt_out_chatter_ids", "is_burned", "message_language", "getMessage_language", "is_auto_translated_by_receiver", "is_no_trace_deleted", "origin_badge_count", "getOrigin_badge_count", "origin_thread_badge_count", "getOrigin_thread_badge_count", "sensitivity", "Lcom/lark/kmp/pb/basic/v1/Message$MessageSensitivity;", "getSensitivity", "()Lcom/lark/kmp/pb/basic/v1/Message$MessageSensitivity;", "crypto_token", "getCrypto_token", "is_decrypto_fail", "is_secret_chat_decrypted_failed", "translate_message_display_rule", "Lcom/lark/kmp/pb/basic/v1/TranslateMessageDisplayRule;", "getTranslate_message_display_rule", "()Lcom/lark/kmp/pb/basic/v1/TranslateMessageDisplayRule;", "is_manual_translated", "original_sender_id", "getOriginal_sender_id", "forward_from_friend", "getForward_from_friend", "static_resource_message_recalled", "getStatic_resource_message_recalled$annotations", "getStatic_resource_message_recalled", "is_crypto_intermediate", "image_translation_ability", "", "Lcom/lark/kmp/pb/basic/v1/ImageTranslationAbility;", "getImage_translation_ability", "()Ljava/util/Map;", "is_special_focus", "is_include_doc_url", "file_deleted_status", "Lcom/lark/kmp/pb/basic/v1/Message$FileDeletedStatus;", "getFile_deleted_status", "()Lcom/lark/kmp/pb/basic/v1/Message$FileDeletedStatus;", "character_length", "getCharacter_length", "msg_thread_draft_id", "getMsg_thread_draft_id", "sync_dependency", "getSync_dependency", "anonymous_info", "Lcom/lark/kmp/pb/basic/v1/Message$AnonymousInfo;", "getAnonymous_info", "()Lcom/lark/kmp/pb/basic/v1/Message$AnonymousInfo;", "is_flag", "thread_message_type", "Lcom/lark/kmp/pb/basic/v1/Message$ThreadMessageType;", "getThread_message_type", "()Lcom/lark/kmp/pb/basic/v1/Message$ThreadMessageType;", "create_time_ms", "getCreate_time_ms", "i18n_content_language", "getI18n_content_language", "disable_search", "getDisable_search", "edit_version", "getEdit_version", "edit_time_ms", "getEdit_time_ms", "edit_draft_id", "getEdit_draft_id", "dlp_state", "Lcom/lark/kmp/pb/basic/v1/MessageDLPState;", "getDlp_state", "()Lcom/lark/kmp/pb/basic/v1/MessageDLPState;", "message_languages", "getMessage_languages", "i18n_info", "Lcom/lark/kmp/pb/basic/v1/I18nInfo;", "getI18n_info", "()Lcom/lark/kmp/pb/basic/v1/I18nInfo;", "fold_id", "getFold_id", "version", "Lcom/lark/kmp/pb/basic/v1/Message$Version;", "getVersion", "()Lcom/lark/kmp/pb/basic/v1/Message$Version;", "schedule_message_draft_id", "getSchedule_message_draft_id", "in_chat_display_mode", "Lcom/lark/kmp/pb/basic/v1/Message$ChatDisplayModeSetting;", "getIn_chat_display_mode", "()Lcom/lark/kmp/pb/basic/v1/Message$ChatDisplayModeSetting;", "is_restricted", "set_grey", "getSet_grey", "disabled_action", "Lcom/lark/kmp/pb/basic/v1/Message$DisabledAction;", "getDisabled_action", "()Lcom/lark/kmp/pb/basic/v1/Message$DisabledAction;", "is_on_time_del", "is_cleaned", "security_extra", "Lcom/lark/kmp/pb/basic/v1/SecurityESCReviewExtra;", "getSecurity_extra", "()Lcom/lark/kmp/pb/basic/v1/SecurityESCReviewExtra;", "stream_status", "Lcom/lark/kmp/pb/basic/v1/Message$StreamStatus;", "getStream_status", "()Lcom/lark/kmp/pb/basic/v1/Message$StreamStatus;", "stream_sequence_id", "getStream_sequence_id", "ai_chat_mode_id", "getAi_chat_mode_id", "ai_answer_raw_data", "getAi_answer_raw_data", "ai_message_like_feedback_status", "Lcom/lark/kmp/pb/basic/v1/Message$AIMessageLikeFeedbackStatus;", "getAi_message_like_feedback_status", "()Lcom/lark/kmp/pb/basic/v1/Message$AIMessageLikeFeedbackStatus;", "ai_message_type", "Lcom/lark/kmp/pb/basic/v1/Message$AIMessageType;", "getAi_message_type", "()Lcom/lark/kmp/pb/basic/v1/Message$AIMessageType;", "sync_to_chat_thread_root_id", "getSync_to_chat_thread_root_id", "sync_to_chat_message_type", "Lcom/lark/kmp/pb/basic/v1/Message$SyncToChatMessageType;", "getSync_to_chat_message_type", "()Lcom/lark/kmp/pb/basic/v1/Message$SyncToChatMessageType;", "sync_to_chat_related_message_id", "getSync_to_chat_related_message_id", "can_show_ai_progress", "getCan_show_ai_progress", "partial_reply_info", "Lcom/lark/kmp/pb/basic/v1/Message$PartialReplyInfo;", "getPartial_reply_info", "()Lcom/lark/kmp/pb/basic/v1/Message$PartialReplyInfo;", "is_ai_session_first_msg", "authorized_source", "Lcom/lark/kmp/pb/basic/v1/Message$AuthorizedSource;", "getAuthorized_source", "()Lcom/lark/kmp/pb/basic/v1/Message$AuthorizedSource;", "has_follow_up", "getHas_follow_up", "ai_info", "Lcom/lark/kmp/pb/basic/v1/Message$AIInfo;", "getAi_info", "()Lcom/lark/kmp/pb/basic/v1/Message$AIInfo;", "ai_reply_entry_info", "Lcom/lark/kmp/pb/basic/v1/Message$AIReplyEntryInfo;", "getAi_reply_entry_info", "()Lcom/lark/kmp/pb/basic/v1/Message$AIReplyEntryInfo;", "card_info", "Lcom/lark/kmp/pb/basic/v1/Message$CardInfo;", "getCard_info", "()Lcom/lark/kmp/pb/basic/v1/Message$CardInfo;", "smart_ai_reply", "Lcom/lark/kmp/pb/basic/v1/AIReply;", "getSmart_ai_reply", "()Lcom/lark/kmp/pb/basic/v1/AIReply;", "cot_content", "Lcom/lark/kmp/pb/basic/v1/COTContent;", "getCot_content", "()Lcom/lark/kmp/pb/basic/v1/COTContent;", "newBuilder", "toString", "Builder", "Companion", "Type", "MessageAttachmentType", "Reaction", "MessageSensitivity", "FromType", "SourceType", "RecallerIdentity", "Pin", "FileDeletedStatus", "AnonymousInfo", "ThreadMessageType", "Version", "ChatDisplayModeSetting", "DisabledAction", "StreamStatus", "AIMessageLikeFeedbackStatus", "AIMessageType", "SyncToChatMessageType", "PartialReplyInfo", "AuthorizedSourceType", "AgentSendMessageSourceDisplayPolicy", "AuthorizedSource", "AIInfo", "AIReplyEntryInfo", "CardInfo", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class Message extends com.lark.wire.Message<Message, a> {
    public static final ProtoAdapter<Message> ADAPTER = null;
    public static final b Companion = null;
    public static final int DEFAULT_BADGE_COUNT = 0;
    public static final String DEFAULT_CID = "";
    public static final String DEFAULT_DOC_KEY = "";
    public static final boolean DEFAULT_FORWARD_FROM_FRIEND = false;
    public static final String DEFAULT_FROM_ID = "";
    public static final FromType DEFAULT_FROM_TYPE = null;
    public static final boolean DEFAULT_IS_AT_ALL = false;
    public static final boolean DEFAULT_IS_AT_ME = false;
    public static final boolean DEFAULT_IS_CRYPTO_INTERMEDIATE = false;
    public static final boolean DEFAULT_IS_DELETED = false;
    public static final boolean DEFAULT_IS_EDITED = false;
    public static final boolean DEFAULT_IS_FILE_DELETED = false;
    public static final boolean DEFAULT_IS_MANUAL_TRANSLATED = false;
    public static final boolean DEFAULT_IS_NO_TRACE_DELETED = false;
    public static final boolean DEFAULT_IS_RECALLED = false;
    public static final boolean DEFAULT_IS_REEDITABLE = false;
    public static final boolean DEFAULT_IS_TRUNCATED = false;
    public static final boolean DEFAULT_IS_UNTRANSLATEABLE = false;
    public static final boolean DEFAULT_IS_URGENT = false;
    public static final boolean DEFAULT_IS_VISIBLE = true;
    public static final boolean DEFAULT_ME_READ = false;
    public static final String DEFAULT_PARENT_ID = "";
    public static final String DEFAULT_PARENT_SOURCE_ID = "";
    public static final int DEFAULT_POSITION = 0;
    public static final String DEFAULT_POST_DRAFT_ID = "";
    public static final int DEFAULT_READ_COUNT = 0;
    public static final String DEFAULT_REMINDER_ID = "";
    public static final int DEFAULT_REPLY_COUNT = 0;
    public static final String DEFAULT_ROOT_SOURCE_ID = "";
    public static final boolean DEFAULT_SHOULD_NOTIFY = true;
    public static final boolean DEFAULT_SYNC_DEPENDENCY = false;
    public static final String DEFAULT_TEXT_DRAFT_ID = "";
    public static final int DEFAULT_THREAD_POSITION = 0;
    public static final String DEFAULT_URGENT_ID = "";
    private static final long serialVersionUID = 0;
    private final List<String> ack_urgent_chatter_ids;
    private final String ai_answer_raw_data;
    private final Long ai_chat_mode_id;
    private final AIInfo ai_info;
    private final AIMessageLikeFeedbackStatus ai_message_like_feedback_status;
    private final AIMessageType ai_message_type;
    private final AIReplyEntryInfo ai_reply_entry_info;
    private final AnonymousInfo anonymous_info;
    private final List<String> at_out_chatter_ids;
    private final AuthorizedSource authorized_source;
    private final Integer badge_count;
    private final Integer burn_life;
    private final Long burn_time;
    private final Boolean can_show_ai_progress;
    private final CardInfo card_info;
    private final Channel channel;
    private final Integer character_length;
    private final String chat_id;
    private final String cid;
    private final Content content;
    private final COTContent cot_content;
    private final long create_time;
    private final Long create_time_ms;
    private final String crypto_token;
    private final Boolean disable_search;
    private final DisabledAction disabled_action;
    private final MessageDLPState dlp_state;
    private final String doc_key;
    private final String edit_draft_id;
    private final Long edit_time_ms;
    private final Integer edit_version;
    private final FileDeletedStatus file_deleted_status;
    private final Long fold_id;
    private final Boolean forward_from_friend;
    private final String from_id;
    private final FromType from_type;
    private final Boolean has_follow_up;
    private final Map<String, String> i18n_content_language;
    private final I18nInfo i18n_info;
    private final String id;
    private final Map<String, ImageTranslationAbility> image_translation_ability;
    private final ChatDisplayModeSetting in_chat_display_mode;
    private final Boolean is_abnormal;
    private final Boolean is_ai_session_first_msg;
    private final Boolean is_at_all;
    private final Boolean is_at_me;
    private final Boolean is_auto_translated_by_receiver;
    private final Boolean is_badged;
    private final Boolean is_burned;
    private final Boolean is_cleaned;
    private final Boolean is_crypto_intermediate;
    private final Boolean is_decrypto_fail;
    private final Boolean is_deleted;
    private final Boolean is_edited;
    private final Boolean is_file_deleted;
    private final Boolean is_flag;
    private final Boolean is_include_doc_url;
    private final Boolean is_manual_translated;
    private final Boolean is_no_trace_deleted;
    private final Boolean is_on_time_del;
    private final Boolean is_recalled;
    private final Boolean is_reeditable;
    private final Boolean is_restricted;
    private final Boolean is_secret_chat_decrypted_failed;
    private final Boolean is_special_focus;
    private final Boolean is_truncated;
    private final Boolean is_untranslateable;
    private final Boolean is_urgent;
    private final Boolean is_visible;
    private final Boolean me_read;
    private final String message_language;
    private final List<String> message_languages;
    private final String msg_thread_draft_id;
    private final Integer origin_badge_count;
    private final Integer origin_thread_badge_count;
    private final String original_sender_id;
    private final String parent_id;
    private final String parent_source_id;
    private final PartialReplyInfo partial_reply_info;
    private final Pin pin;
    private final Integer position;
    private final String post_draft_id;
    private final List<Reaction> reactions;
    private final List<String> read_at_chatter_ids;
    private final Integer read_count;
    private final String recaller_id;
    private final RecallerIdentity recaller_identity;
    private final String reminder_id;
    private final Integer reply_count;
    private final String root_id;
    private final String root_source_id;
    private final String schedule_message_draft_id;
    private final SecurityESCReviewExtra security_extra;
    private final MessageSensitivity sensitivity;
    private final Boolean set_grey;
    private final Boolean should_notify;
    private final AIReply smart_ai_reply;
    private final String source_id;
    private final SourceType source_type;
    private final Boolean static_resource_message_recalled;
    private final Integer stream_sequence_id;
    private final StreamStatus stream_status;
    private final Boolean sync_dependency;
    private final SyncToChatMessageType sync_to_chat_message_type;
    private final Long sync_to_chat_related_message_id;
    private final Long sync_to_chat_thread_root_id;
    private final String text_draft_id;
    private final Integer thread_badge_count;
    private final String thread_id;
    private final ThreadMessageType thread_message_type;
    private final Integer thread_position;
    private final Integer thread_reply_count;
    private final String translate_language;
    private final TranslateMessageDisplayRule translate_message_display_rule;
    private final Type type;
    private final List<String> unack_urgent_chatter_ids;
    private final List<String> unread_chatter_ids;
    private final int unread_count;
    private final long update_time;
    private final String urgent_id;
    private final Version version;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0019\u001a\u001bB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\u000bR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$AIInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Message$AIInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Message$AIInfo$Builder;Lokio/ByteString;)V", "round_id", "", "getRound_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "button_config", "Lcom/lark/kmp/pb/basic/v1/Message$AIInfo$ButtonConfig;", "getButton_config", "()Lcom/lark/kmp/pb/basic/v1/Message$AIInfo$ButtonConfig;", "root_round_id", "getRoot_round_id", "enterprise_qa_general_info", "", "getEnterprise_qa_general_info", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "ButtonConfig", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class AIInfo extends com.lark.wire.Message<AIInfo, a> {
        public static final ProtoAdapter<AIInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final ButtonConfig button_config;
        private final String enterprise_qa_general_info;
        private final Long root_round_id;
        private final Long round_id;

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0019\u001a\u001b\u001cB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$AIInfo$ButtonConfig;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Message$AIInfo$ButtonConfig$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Message$AIInfo$ButtonConfig$Builder;Lokio/ByteString;)V", "strategy", "Lcom/lark/kmp/pb/basic/v1/Message$AIInfo$ButtonConfig$Strategy;", "getStrategy", "()Lcom/lark/kmp/pb/basic/v1/Message$AIInfo$ButtonConfig$Strategy;", "customize_buttons", "", "Lcom/lark/kmp/pb/basic/v1/Message$AIInfo$ButtonConfig$Button;", "getCustomize_buttons", "()Ljava/util/List;", "ai_answer_markdown_data", "", "getAi_answer_markdown_data", "()Ljava/lang/String;", "button_list_json", "getButton_list_json", "newBuilder", "toString", "Builder", "Companion", "Strategy", "Button", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class ButtonConfig extends com.lark.wire.Message<ButtonConfig, a> {
            public static final ProtoAdapter<ButtonConfig> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final String ai_answer_markdown_data;
            private final String button_list_json;
            private final List<Button> customize_buttons;
            private final Strategy strategy;

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$AIInfo$ButtonConfig$Button;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "LIKE", "DISLIKE", "REGENERATE", "SHARE", "COPY", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
            public static final enum Button extends Enum<Button> implements o0 {
                public static final ProtoAdapter<Button> ADAPTER = null;
                public static final Button COPY = null;
                public static final b Companion = null;
                public static final Button DISLIKE = null;
                public static final Button LIKE = null;
                public static final Button REGENERATE = null;
                public static final Button SHARE = null;
                public static final Button UNKNOWN = null;
                public static final /* synthetic */ Button[] a = null;
                public static final /* synthetic */ EnumEntries b = null;
                private final int value;

                public static final class a extends d<Button> {
                    @Override // com.lark.wire.d
                    public final o0 n(int r2) {
                        Button.Companion.getClass();
                        return b.a(r2);
                    }

                    public a(KClass<Button> r1, Syntax r2, Button r3) {
                        super(r1, r2, r3);
                    }
                }

                public static final class b {
                    public b() {
                    }

                    @JvmStatic
                    public static Button a(int r1) {
                        if (r1 == 0) goto L20;
                        if (r1 == 1) goto L26;
                        if (r1 == 2) goto L25;
                        if (r1 == 3) goto L24;
                        if (r1 == 4) goto L23;
                        if (r1 == 5) goto L22;
                        return null;
                    L22:
                        return Button.COPY;
                    L23:
                        return Button.SHARE;
                    L24:
                        return Button.REGENERATE;
                    L25:
                        return Button.DISLIKE;
                    L26:
                        return Button.LIKE;
                    L20:
                        return Button.UNKNOWN;
                    }
                }

                @JvmStatic
                public static final Button fromValue(int r1) {
                    Companion.getClass();
                    return b.a(r1);
                }

                public static EnumEntries<Button> getEntries() {
                    return b;
                }

                static {
                    Button r0 = new Button("UNKNOWN", 0, 0);
                    UNKNOWN = r0;
                    Button r1 = new Button("LIKE", 1, 1);
                    LIKE = r1;
                    Button r3 = new Button("DISLIKE", 2, 2);
                    DISLIKE = r3;
                    Button r5 = new Button("REGENERATE", 3, 3);
                    REGENERATE = r5;
                    Button r7 = new Button("SHARE", 4, 4);
                    SHARE = r7;
                    Button r9 = new Button("COPY", 5, 5);
                    COPY = r9;
                    Button[] r11 = {r0, r1, r3, r5, r7, r9};
                    a = r11;
                    b = EnumEntriesKt.enumEntries(r11);
                    Companion = new b();
                    ADAPTER = new a(Reflection.getOrCreateKotlinClass(Button.class), Syntax.PROTO_2, r0);
                }

                public static Button[] values() {
                    return (Button[]) a.clone();
                }

                @Override // com.lark.wire.o0
                public int getValue() {
                    return this.value;
                }

                public static Button valueOf(String r1) {
                    return (Button) r27.a.a(Button.class, r1);
                }

                public Button(String r1, int r2, int r3) {
                    super(r1, r2);
                    this.value = r3;
                }
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$AIInfo$ButtonConfig$Strategy;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "CUSTOMIZE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
            public static final enum Strategy extends Enum<Strategy> implements o0 {
                public static final ProtoAdapter<Strategy> ADAPTER = null;
                public static final Strategy CUSTOMIZE = null;
                public static final b Companion = null;
                public static final Strategy DEFAULT = null;
                public static final /* synthetic */ Strategy[] a = null;
                public static final /* synthetic */ EnumEntries b = null;
                private final int value;

                public static final class a extends d<Strategy> {
                    @Override // com.lark.wire.d
                    public final o0 n(int r2) {
                        Strategy.Companion.getClass();
                        if (r2 == 0) goto L9;
                        if (r2 == 1) goto L11;
                        return null;
                    L11:
                        return Strategy.CUSTOMIZE;
                    L9:
                        return Strategy.DEFAULT;
                    }

                    public a(KClass<Strategy> r1, Syntax r2, Strategy r3) {
                        super(r1, r2, r3);
                    }
                }

                public static final class b {
                    public b() {
                    }
                }

                public static EnumEntries<Strategy> getEntries() {
                    return b;
                }

                static {
                    Strategy r0 = new Strategy("DEFAULT", 0, 0);
                    DEFAULT = r0;
                    Strategy r1 = new Strategy("CUSTOMIZE", 1, 1);
                    CUSTOMIZE = r1;
                    Strategy[] r3 = {r0, r1};
                    a = r3;
                    b = EnumEntriesKt.enumEntries(r3);
                    Companion = new b();
                    ADAPTER = new a(Reflection.getOrCreateKotlinClass(Strategy.class), Syntax.PROTO_2, r0);
                }

                public static Strategy[] values() {
                    return (Strategy[]) a.clone();
                }

                @Override // com.lark.wire.o0
                public int getValue() {
                    return this.value;
                }

                @JvmStatic
                public static final Strategy fromValue(int r1) {
                    Companion.getClass();
                    if (r1 == 0) goto L9;
                    if (r1 == 1) goto L11;
                    return null;
                L11:
                    return CUSTOMIZE;
                L9:
                    return DEFAULT;
                }

                public static Strategy valueOf(String r1) {
                    return (Strategy) r27.a.a(Strategy.class, r1);
                }

                public Strategy(String r1, int r2, int r3) {
                    super(r1, r2);
                    this.value = r3;
                }
            }

            public static final class a extends com.lark.wire.Message.a<ButtonConfig, a> {
                public Strategy d;
                public List<? extends Button> e;
                public String f;
                public String g;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new ButtonConfig(this, c(), null);
                }

                public a() {
                    this.e = CollectionsKt.emptyList();
                }
            }

            public static final class b extends ProtoAdapter<ButtonConfig> {
                @Override // com.lark.wire.ProtoAdapter
                public final ButtonConfig c(g0 r11) {
                    Intrinsics.checkNotNullParameter(r11, "reader");
                    a r1 = new a();
                    ArrayList r2 = new ArrayList();
                    long r3 = r11.c();
                L3:
                    int r5 = r11.e();
                    if (r5 == (-1)) goto L24;
                    if (r5 != 1) goto L8;
                    r1.d = Strategy.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
                L22:
                    e = move-exception;
                    r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
                    Unit r6 = Unit.INSTANCE;
                    goto L3
                L8:
                    if (r5 != 2) goto L10;
                    Button.ADAPTER.m(r11, r2);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
                L18:
                    e = move-exception;
                    r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L10:
                    if (r5 != 3) goto L12;
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r11, "reader");
                    r1.f = r11.i();
                    goto L3
                L12:
                    if (r5 != 4) goto L13;
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r11, "reader");
                    r1.g = r11.i();
                    goto L3
                L13:
                    r11.j(r5);
                    goto L3
                L24:
                    ByteString r12 = r11.d(r3);
                    Intrinsics.checkNotNullParameter(r2, "customize_buttons");
                    com.lark.wire.internal.a.a(r2);
                    r1.e = r2;
                    return new ButtonConfig(r1, r12, null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(ButtonConfig r5) {
                    ButtonConfig r6 = r5;
                    Intrinsics.checkNotNullParameter(r6, "value");
                    int r0 = (r6.unknownFields().size() + Strategy.ADAPTER.l(1, r6.getStrategy())) + Button.ADAPTER.a().l(2, r6.getCustomize_buttons());
                    w r1 = ProtoAdapter.q;
                    return (r0 + r1.l(3, r6.getAi_answer_markdown_data())) + r1.l(4, r6.getButton_list_json());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r4, ButtonConfig r5) {
                    ButtonConfig r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    Strategy.ADAPTER.i(r4, 1, r6.getStrategy());
                    Button.ADAPTER.a().i(r4, 2, r6.getCustomize_buttons());
                    w r0 = ProtoAdapter.q;
                    r0.i(r4, 3, r6.getAi_answer_markdown_data());
                    r0.i(r4, 4, r6.getButton_list_json());
                    r4.a(r6.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r4, ButtonConfig r5) {
                    ButtonConfig r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    r4.d(r6.unknownFields());
                    w r0 = ProtoAdapter.q;
                    r0.j(r4, 4, r6.getButton_list_json());
                    r0.j(r4, 3, r6.getAi_answer_markdown_data());
                    Button.ADAPTER.a().j(r4, 2, r6.getCustomize_buttons());
                    Strategy.ADAPTER.j(r4, 1, r6.getStrategy());
                }

                public b(FieldEncoding r7, KClass<ButtonConfig> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.Message.AIInfo.ButtonConfig", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ ButtonConfig(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ButtonConfig.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.strategy;
                r0.e = this.customize_buttons;
                r0.f = this.ai_answer_markdown_data;
                r0.g = this.button_list_json;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(ButtonConfig.class).getSimpleName() + '@' + hashCode();
            }

            public final String getAi_answer_markdown_data() {
                return this.ai_answer_markdown_data;
            }

            public final String getButton_list_json() {
                return this.button_list_json;
            }

            public final List<Button> getCustomize_buttons() {
                return this.customize_buttons;
            }

            public final Strategy getStrategy() {
                return this.strategy;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public ButtonConfig(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.strategy = r2.d;
                this.customize_buttons = com.lark.wire.internal.a.c("customize_buttons", r2.e);
                this.ai_answer_markdown_data = r2.f;
                this.button_list_json = r2.g;
            }

            public /* synthetic */ ButtonConfig(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        public static final class a extends com.lark.wire.Message.a<AIInfo, a> {
            public Long d;
            public ButtonConfig e;
            public Long f;
            public String g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new AIInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<AIInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final AIInfo c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L19;
                if (r4 != 1) goto L8;
                r1.d = (Long) ProtoAdapter.k.c(r7);
                goto L3
            L8:
                if (r4 != 2) goto L10;
                r1.e = ButtonConfig.ADAPTER.c(r7);
                goto L3
            L10:
                if (r4 != 3) goto L12;
                r1.f = (Long) ProtoAdapter.k.c(r7);
                goto L3
            L12:
                if (r4 != 4) goto L13;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.g = r7.i();
                goto L3
            L13:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L19:
                return new AIInfo(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(AIInfo r6) {
                AIInfo r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size();
                t r1 = ProtoAdapter.k;
                return (((r0 + r1.l(1, r7.getRound_id())) + ButtonConfig.ADAPTER.l(2, r7.getButton_config())) + r1.l(3, r7.getRoot_round_id())) + ProtoAdapter.q.l(4, r7.getEnterprise_qa_general_info());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, AIInfo r6) {
                AIInfo r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                t r0 = ProtoAdapter.k;
                r0.i(r5, 1, r7.getRound_id());
                ButtonConfig.ADAPTER.i(r5, 2, r7.getButton_config());
                r0.i(r5, 3, r7.getRoot_round_id());
                ProtoAdapter.q.i(r5, 4, r7.getEnterprise_qa_general_info());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, AIInfo r6) {
                AIInfo r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                ProtoAdapter.q.j(r5, 4, r7.getEnterprise_qa_general_info());
                t r0 = ProtoAdapter.k;
                r0.j(r5, 3, r7.getRoot_round_id());
                ButtonConfig.ADAPTER.j(r5, 2, r7.getButton_config());
                r0.j(r5, 1, r7.getRound_id());
            }

            public b(FieldEncoding r7, KClass<AIInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Message.AIInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ AIInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AIInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.round_id;
            r0.e = this.button_config;
            r0.f = this.root_round_id;
            r0.g = this.enterprise_qa_general_info;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(AIInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final ButtonConfig getButton_config() {
            return this.button_config;
        }

        public final String getEnterprise_qa_general_info() {
            return this.enterprise_qa_general_info;
        }

        public final Long getRoot_round_id() {
            return this.root_round_id;
        }

        public final Long getRound_id() {
            return this.round_id;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public AIInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.round_id = r2.d;
            this.button_config = r2.e;
            this.root_round_id = r2.f;
            this.enterprise_qa_general_info = r2.g;
        }

        public /* synthetic */ AIInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$AIMessageLikeFeedbackStatus;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_STATUS", "LIKE", "DISLIKE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum AIMessageLikeFeedbackStatus extends Enum<AIMessageLikeFeedbackStatus> implements o0 {
        public static final ProtoAdapter<AIMessageLikeFeedbackStatus> ADAPTER = null;
        public static final b Companion = null;
        public static final AIMessageLikeFeedbackStatus DISLIKE = null;
        public static final AIMessageLikeFeedbackStatus LIKE = null;
        public static final AIMessageLikeFeedbackStatus UNKNOWN_STATUS = null;
        public static final /* synthetic */ AIMessageLikeFeedbackStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<AIMessageLikeFeedbackStatus> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                AIMessageLikeFeedbackStatus.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return AIMessageLikeFeedbackStatus.DISLIKE;
            L15:
                return AIMessageLikeFeedbackStatus.LIKE;
            L12:
                return AIMessageLikeFeedbackStatus.UNKNOWN_STATUS;
            }

            public a(KClass<AIMessageLikeFeedbackStatus> r1, Syntax r2, AIMessageLikeFeedbackStatus r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<AIMessageLikeFeedbackStatus> getEntries() {
            return b;
        }

        static {
            AIMessageLikeFeedbackStatus r0 = new AIMessageLikeFeedbackStatus("UNKNOWN_STATUS", 0, 0);
            UNKNOWN_STATUS = r0;
            AIMessageLikeFeedbackStatus r1 = new AIMessageLikeFeedbackStatus("LIKE", 1, 1);
            LIKE = r1;
            AIMessageLikeFeedbackStatus r3 = new AIMessageLikeFeedbackStatus("DISLIKE", 2, 2);
            DISLIKE = r3;
            AIMessageLikeFeedbackStatus[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(AIMessageLikeFeedbackStatus.class), Syntax.PROTO_2, r0);
        }

        public static AIMessageLikeFeedbackStatus[] values() {
            return (AIMessageLikeFeedbackStatus[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final AIMessageLikeFeedbackStatus fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return DISLIKE;
        L15:
            return LIKE;
        L12:
            return UNKNOWN_STATUS;
        }

        public static AIMessageLikeFeedbackStatus valueOf(String r1) {
            return (AIMessageLikeFeedbackStatus) r27.a.a(AIMessageLikeFeedbackStatus.class, r1);
        }

        public AIMessageLikeFeedbackStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$AIMessageType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "OTHER", "QUESTION", "STREAM_ANSWER", "NOT_STREAM_ANSWER", "SYSTEM_MESSAGE", "GUIDE_MESSAGE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum AIMessageType extends Enum<AIMessageType> implements o0 {
        public static final ProtoAdapter<AIMessageType> ADAPTER = null;
        public static final b Companion = null;
        public static final AIMessageType GUIDE_MESSAGE = null;
        public static final AIMessageType NOT_STREAM_ANSWER = null;
        public static final AIMessageType OTHER = null;
        public static final AIMessageType QUESTION = null;
        public static final AIMessageType STREAM_ANSWER = null;
        public static final AIMessageType SYSTEM_MESSAGE = null;
        public static final /* synthetic */ AIMessageType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<AIMessageType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                AIMessageType.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<AIMessageType> r1, Syntax r2, AIMessageType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static AIMessageType a(int r1) {
                if (r1 == 0) goto L20;
                if (r1 == 1) goto L26;
                if (r1 == 2) goto L25;
                if (r1 == 3) goto L24;
                if (r1 == 4) goto L23;
                if (r1 == 5) goto L22;
                return null;
            L22:
                return AIMessageType.GUIDE_MESSAGE;
            L23:
                return AIMessageType.SYSTEM_MESSAGE;
            L24:
                return AIMessageType.NOT_STREAM_ANSWER;
            L25:
                return AIMessageType.STREAM_ANSWER;
            L26:
                return AIMessageType.QUESTION;
            L20:
                return AIMessageType.OTHER;
            }
        }

        @JvmStatic
        public static final AIMessageType fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<AIMessageType> getEntries() {
            return b;
        }

        static {
            AIMessageType r0 = new AIMessageType("OTHER", 0, 0);
            OTHER = r0;
            AIMessageType r1 = new AIMessageType("QUESTION", 1, 1);
            QUESTION = r1;
            AIMessageType r3 = new AIMessageType("STREAM_ANSWER", 2, 2);
            STREAM_ANSWER = r3;
            AIMessageType r5 = new AIMessageType("NOT_STREAM_ANSWER", 3, 3);
            NOT_STREAM_ANSWER = r5;
            AIMessageType r7 = new AIMessageType("SYSTEM_MESSAGE", 4, 4);
            SYSTEM_MESSAGE = r7;
            AIMessageType r9 = new AIMessageType("GUIDE_MESSAGE", 5, 5);
            GUIDE_MESSAGE = r9;
            AIMessageType[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(AIMessageType.class), Syntax.PROTO_2, r0);
        }

        public static AIMessageType[] values() {
            return (AIMessageType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static AIMessageType valueOf(String r1) {
            return (AIMessageType) r27.a.a(AIMessageType.class, r1);
        }

        public AIMessageType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$AIReplyEntryInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Message$AIReplyEntryInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Message$AIReplyEntryInfo$Builder;Lokio/ByteString;)V", "has_pre_generation", "", "getHas_pre_generation", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "ai_reply_id", "", "getAi_reply_id", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class AIReplyEntryInfo extends com.lark.wire.Message<AIReplyEntryInfo, a> {
        public static final ProtoAdapter<AIReplyEntryInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String ai_reply_id;
        private final Boolean has_pre_generation;

        public static final class a extends com.lark.wire.Message.a<AIReplyEntryInfo, a> {
            public Boolean d;
            public String e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new AIReplyEntryInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<AIReplyEntryInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final AIReplyEntryInfo c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L13;
                if (r4 != 1) goto L8;
                r1.d = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L8:
                if (r4 != 2) goto L9;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L9:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L13:
                return new AIReplyEntryInfo(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(AIReplyEntryInfo r5) {
                AIReplyEntryInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + ProtoAdapter.g.l(1, r6.getHas_pre_generation())) + ProtoAdapter.q.l(2, r6.getAi_reply_id());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, AIReplyEntryInfo r5) {
                AIReplyEntryInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.g.i(r4, 1, r6.getHas_pre_generation());
                ProtoAdapter.q.i(r4, 2, r6.getAi_reply_id());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, AIReplyEntryInfo r5) {
                AIReplyEntryInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.q.j(r4, 2, r6.getAi_reply_id());
                ProtoAdapter.g.j(r4, 1, r6.getHas_pre_generation());
            }

            public b(FieldEncoding r7, KClass<AIReplyEntryInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Message.AIReplyEntryInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ AIReplyEntryInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AIReplyEntryInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.has_pre_generation;
            r0.e = this.ai_reply_id;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(AIReplyEntryInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final String getAi_reply_id() {
            return this.ai_reply_id;
        }

        public final Boolean getHas_pre_generation() {
            return this.has_pre_generation;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public AIReplyEntryInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.has_pre_generation = r2.d;
            this.ai_reply_id = r2.e;
        }

        public /* synthetic */ AIReplyEntryInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$AgentSendMessageSourceDisplayPolicy;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY", "MENU", "INLINE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum AgentSendMessageSourceDisplayPolicy extends Enum<AgentSendMessageSourceDisplayPolicy> implements o0 {
        public static final ProtoAdapter<AgentSendMessageSourceDisplayPolicy> ADAPTER = null;
        public static final b Companion = null;
        public static final AgentSendMessageSourceDisplayPolicy INLINE = null;
        public static final AgentSendMessageSourceDisplayPolicy MENU = null;
        public static final AgentSendMessageSourceDisplayPolicy UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY = null;
        public static final /* synthetic */ AgentSendMessageSourceDisplayPolicy[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<AgentSendMessageSourceDisplayPolicy> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                AgentSendMessageSourceDisplayPolicy.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return AgentSendMessageSourceDisplayPolicy.INLINE;
            L15:
                return AgentSendMessageSourceDisplayPolicy.MENU;
            L12:
                return AgentSendMessageSourceDisplayPolicy.UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY;
            }

            public a(KClass<AgentSendMessageSourceDisplayPolicy> r1, Syntax r2, AgentSendMessageSourceDisplayPolicy r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<AgentSendMessageSourceDisplayPolicy> getEntries() {
            return b;
        }

        static {
            AgentSendMessageSourceDisplayPolicy r0 = new AgentSendMessageSourceDisplayPolicy("UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY", 0, 0);
            UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY = r0;
            AgentSendMessageSourceDisplayPolicy r1 = new AgentSendMessageSourceDisplayPolicy("MENU", 1, 1);
            MENU = r1;
            AgentSendMessageSourceDisplayPolicy r3 = new AgentSendMessageSourceDisplayPolicy("INLINE", 2, 2);
            INLINE = r3;
            AgentSendMessageSourceDisplayPolicy[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(AgentSendMessageSourceDisplayPolicy.class), Syntax.PROTO_2, r0);
        }

        public static AgentSendMessageSourceDisplayPolicy[] values() {
            return (AgentSendMessageSourceDisplayPolicy[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final AgentSendMessageSourceDisplayPolicy fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return INLINE;
        L15:
            return MENU;
        L12:
            return UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY;
        }

        public static AgentSendMessageSourceDisplayPolicy valueOf(String r1) {
            return (AgentSendMessageSourceDisplayPolicy) r27.a.a(AgentSendMessageSourceDisplayPolicy.class, r1);
        }

        public AgentSendMessageSourceDisplayPolicy(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0011\u0012B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$AnonymousInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Message$AnonymousInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Message$AnonymousInfo$Builder;Lokio/ByteString;)V", "is_anonymous", "", "()Z", "is_sender", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class AnonymousInfo extends com.lark.wire.Message<AnonymousInfo, a> {
        public static final ProtoAdapter<AnonymousInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final boolean is_anonymous;
        private final Boolean is_sender;

        public static final class a extends com.lark.wire.Message.a<AnonymousInfo, a> {
            public Boolean d;
            public Boolean e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new AnonymousInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<AnonymousInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final AnonymousInfo c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L13;
                if (r3 != 1) goto L8;
                r0.d = Boolean.valueOf(((Boolean) ProtoAdapter.g.c(r6)).booleanValue());
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
                return new AnonymousInfo(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(AnonymousInfo r5) {
                AnonymousInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                l r1 = ProtoAdapter.g;
                return (r0 + r1.l(1, Boolean.valueOf(r6.is_anonymous()))) + r1.l(2, r6.is_sender());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, AnonymousInfo r5) {
                AnonymousInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                l r0 = ProtoAdapter.g;
                r0.i(r4, 1, Boolean.valueOf(r6.is_anonymous()));
                r0.i(r4, 2, r6.is_sender());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, AnonymousInfo r5) {
                AnonymousInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                l r0 = ProtoAdapter.g;
                r0.j(r4, 2, r6.is_sender());
                r0.j(r4, 1, Boolean.valueOf(r6.is_anonymous()));
            }

            public b(FieldEncoding r7, KClass<AnonymousInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Message.AnonymousInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ AnonymousInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AnonymousInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = Boolean.valueOf(this.is_anonymous);
            r0.e = this.is_sender;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(AnonymousInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final boolean is_anonymous() {
            return this.is_anonymous;
        }

        public final Boolean is_sender() {
            return this.is_sender;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public AnonymousInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            Boolean r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.is_anonymous = r4.booleanValue();
            this.is_sender = r2.e;
        }

        public /* synthetic */ AnonymousInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$AuthorizedSource;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Message$AuthorizedSource$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Message$AuthorizedSource$Builder;Lokio/ByteString;)V", "source_id", "", "getSource_id", "()J", "authorized_source_type", "Lcom/lark/kmp/pb/basic/v1/Message$AuthorizedSourceType;", "getAuthorized_source_type", "()Lcom/lark/kmp/pb/basic/v1/Message$AuthorizedSourceType;", "display_policy", "Lcom/lark/kmp/pb/basic/v1/Message$AgentSendMessageSourceDisplayPolicy;", "getDisplay_policy", "()Lcom/lark/kmp/pb/basic/v1/Message$AgentSendMessageSourceDisplayPolicy;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class AuthorizedSource extends com.lark.wire.Message<AuthorizedSource, a> {
        public static final ProtoAdapter<AuthorizedSource> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final AuthorizedSourceType authorized_source_type;
        private final AgentSendMessageSourceDisplayPolicy display_policy;
        private final long source_id;

        public static final class a extends com.lark.wire.Message.a<AuthorizedSource, a> {
            public Long d;
            public AuthorizedSourceType e;
            public AgentSendMessageSourceDisplayPolicy f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new AuthorizedSource(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<AuthorizedSource> {
            @Override // com.lark.wire.ProtoAdapter
            public final AuthorizedSource c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L22;
                if (r3 != 1) goto L8;
                r0.d = Long.valueOf(((Number) ProtoAdapter.k.c(r9)).longValue());
                goto L3
            L8:
                if (r3 != 2) goto L10;
                AuthorizedSourceType r4 = AuthorizedSourceType.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
                Intrinsics.checkNotNullParameter(r4, "authorized_source_type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
                r0.e = r4;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            L18:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.f = AgentSendMessageSourceDisplayPolicy.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r6 = Unit.INSTANCE;
                goto L3
            L11:
                r9.j(r3);
                goto L3
            L22:
                return new AuthorizedSource(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(AuthorizedSource r5) {
                AuthorizedSource r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return ((r6.unknownFields().size() + ProtoAdapter.k.l(1, Long.valueOf(r6.getSource_id()))) + AuthorizedSourceType.ADAPTER.l(2, r6.getAuthorized_source_type())) + AgentSendMessageSourceDisplayPolicy.ADAPTER.l(3, r6.getDisplay_policy());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, AuthorizedSource r5) {
                AuthorizedSource r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.k.i(r4, 1, Long.valueOf(r6.getSource_id()));
                AuthorizedSourceType.ADAPTER.i(r4, 2, r6.getAuthorized_source_type());
                AgentSendMessageSourceDisplayPolicy.ADAPTER.i(r4, 3, r6.getDisplay_policy());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, AuthorizedSource r5) {
                AuthorizedSource r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                AgentSendMessageSourceDisplayPolicy.ADAPTER.j(r4, 3, r6.getDisplay_policy());
                AuthorizedSourceType.ADAPTER.j(r4, 2, r6.getAuthorized_source_type());
                ProtoAdapter.k.j(r4, 1, Long.valueOf(r6.getSource_id()));
            }

            public b(FieldEncoding r7, KClass<AuthorizedSource> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Message.AuthorizedSource", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ AuthorizedSource(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AuthorizedSource.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = Long.valueOf(this.source_id);
            r0.e = this.authorized_source_type;
            r0.f = this.display_policy;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(AuthorizedSource.class).getSimpleName() + '@' + hashCode();
        }

        public final AuthorizedSourceType getAuthorized_source_type() {
            return this.authorized_source_type;
        }

        public final AgentSendMessageSourceDisplayPolicy getDisplay_policy() {
            return this.display_policy;
        }

        public final long getSource_id() {
            return this.source_id;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public AuthorizedSource(a r3, ByteString r4) {
            super(ADAPTER, r4);
            Long r5 = r3.d;
            Intrinsics.checkNotNull(r5);
            this.source_id = r5.longValue();
            AuthorizedSourceType r6 = r3.e;
            Intrinsics.checkNotNull(r6);
            this.authorized_source_type = r6;
            this.display_policy = r3.f;
        }

        public /* synthetic */ AuthorizedSource(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$AuthorizedSourceType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_AUTHORIZED_SOURCE_TYPE", "APP", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum AuthorizedSourceType extends Enum<AuthorizedSourceType> implements o0 {
        public static final ProtoAdapter<AuthorizedSourceType> ADAPTER = null;
        public static final AuthorizedSourceType APP = null;
        public static final b Companion = null;
        public static final AuthorizedSourceType UNKNOWN_AUTHORIZED_SOURCE_TYPE = null;
        public static final /* synthetic */ AuthorizedSourceType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<AuthorizedSourceType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                AuthorizedSourceType.Companion.getClass();
                if (r2 == 0) goto L9;
                if (r2 == 1) goto L11;
                return null;
            L11:
                return AuthorizedSourceType.APP;
            L9:
                return AuthorizedSourceType.UNKNOWN_AUTHORIZED_SOURCE_TYPE;
            }

            public a(KClass<AuthorizedSourceType> r1, Syntax r2, AuthorizedSourceType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<AuthorizedSourceType> getEntries() {
            return b;
        }

        static {
            AuthorizedSourceType r0 = new AuthorizedSourceType("UNKNOWN_AUTHORIZED_SOURCE_TYPE", 0, 0);
            UNKNOWN_AUTHORIZED_SOURCE_TYPE = r0;
            AuthorizedSourceType r1 = new AuthorizedSourceType("APP", 1, 1);
            APP = r1;
            AuthorizedSourceType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(AuthorizedSourceType.class), Syntax.PROTO_2, r0);
        }

        public static AuthorizedSourceType[] values() {
            return (AuthorizedSourceType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final AuthorizedSourceType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L9;
            if (r1 == 1) goto L11;
            return null;
        L11:
            return APP;
        L9:
            return UNKNOWN_AUTHORIZED_SOURCE_TYPE;
        }

        public static AuthorizedSourceType valueOf(String r1) {
            return (AuthorizedSourceType) r27.a.a(AuthorizedSourceType.class, r1);
        }

        public AuthorizedSourceType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$CardInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Message$CardInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Message$CardInfo$Builder;Lokio/ByteString;)V", "update_time", "", "getUpdate_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CardInfo extends com.lark.wire.Message<CardInfo, a> {
        public static final ProtoAdapter<CardInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Long update_time;

        public static final class a extends com.lark.wire.Message.a<CardInfo, a> {
            public Long d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new CardInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<CardInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final CardInfo c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L10;
                if (r3 == 3) goto L7;
                r6.j(r3);
                goto L3
            L7:
                r0.d = (Long) ProtoAdapter.k.c(r6);
                goto L3
            L10:
                return new CardInfo(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(CardInfo r4) {
                CardInfo r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ProtoAdapter.k.l(3, r5.getUpdate_time());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, CardInfo r5) {
                CardInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.k.i(r4, 3, r6.getUpdate_time());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, CardInfo r4) {
                CardInfo r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ProtoAdapter.k.j(r3, 3, r5.getUpdate_time());
            }

            public b(FieldEncoding r7, KClass<CardInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Message.CardInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ CardInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CardInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.update_time;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(CardInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final Long getUpdate_time() {
            return this.update_time;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public CardInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.update_time = r2.d;
        }

        public /* synthetic */ CardInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$ChatDisplayModeSetting;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_DISPLAY_MODE", "DEFAULT", "THREAD", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum ChatDisplayModeSetting extends Enum<ChatDisplayModeSetting> implements o0 {
        public static final ProtoAdapter<ChatDisplayModeSetting> ADAPTER = null;
        public static final b Companion = null;
        public static final ChatDisplayModeSetting DEFAULT = null;
        public static final ChatDisplayModeSetting THREAD = null;
        public static final ChatDisplayModeSetting UNKNOWN_DISPLAY_MODE = null;
        public static final /* synthetic */ ChatDisplayModeSetting[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<ChatDisplayModeSetting> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                ChatDisplayModeSetting.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return ChatDisplayModeSetting.THREAD;
            L15:
                return ChatDisplayModeSetting.DEFAULT;
            L12:
                return ChatDisplayModeSetting.UNKNOWN_DISPLAY_MODE;
            }

            public a(KClass<ChatDisplayModeSetting> r1, Syntax r2, ChatDisplayModeSetting r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<ChatDisplayModeSetting> getEntries() {
            return b;
        }

        static {
            ChatDisplayModeSetting r0 = new ChatDisplayModeSetting("UNKNOWN_DISPLAY_MODE", 0, 0);
            UNKNOWN_DISPLAY_MODE = r0;
            ChatDisplayModeSetting r1 = new ChatDisplayModeSetting("DEFAULT", 1, 1);
            DEFAULT = r1;
            ChatDisplayModeSetting r3 = new ChatDisplayModeSetting("THREAD", 2, 2);
            THREAD = r3;
            ChatDisplayModeSetting[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(ChatDisplayModeSetting.class), Syntax.PROTO_2, r0);
        }

        public static ChatDisplayModeSetting[] values() {
            return (ChatDisplayModeSetting[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final ChatDisplayModeSetting fromValue(int r1) {
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
            return UNKNOWN_DISPLAY_MODE;
        }

        public static ChatDisplayModeSetting valueOf(String r1) {
            return (ChatDisplayModeSetting) r27.a.a(ChatDisplayModeSetting.class, r1);
        }

        public ChatDisplayModeSetting(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0011\u0012\u0013\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$DisabledAction;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Message$DisabledAction$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Message$DisabledAction$Builder;Lokio/ByteString;)V", "actions", "", "", "Lcom/lark/kmp/pb/basic/v1/Message$DisabledAction$Behavior;", "getActions", "()Ljava/util/Map;", "newBuilder", "toString", "", "Builder", "Companion", "Action", "Behavior", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class DisabledAction extends com.lark.wire.Message<DisabledAction, a> {
        public static final ProtoAdapter<DisabledAction> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final Map<Integer, Behavior> actions;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b \b\u0086\u0081\u0002\u0018\u0000 #2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001#B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006$"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$DisabledAction$Action;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ACTION_UNSPECIFIED", "ALL_ACTION", "REACTION", "REPLY", "TRANSMIT", "REPLY_IN_THREAD", "SEND_URGENT", "RECALL", "EDIT_MESSAGE", "MULTI_SELECT", "FLAG", "FAVORITE", "PIN", "CLIP_TO_TOP", "ADD_TASK", "TRANSLATE", "DELETE", "SAVE_TO_LOCAL", "SAVE_TO_SPACE", "ADD_STICKER", "DOWNLOAD", "COPY", "COPY_MESSAGE_LINK", "Widgets", "CHAT_PIN", "DERIVE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Action extends Enum<Action> implements o0 {
            public static final Action ACTION_UNSPECIFIED = null;
            public static final ProtoAdapter<Action> ADAPTER = null;
            public static final Action ADD_STICKER = null;
            public static final Action ADD_TASK = null;
            public static final Action ALL_ACTION = null;
            public static final Action CHAT_PIN = null;
            public static final Action CLIP_TO_TOP = null;
            public static final Action COPY = null;
            public static final Action COPY_MESSAGE_LINK = null;
            public static final b Companion = null;
            public static final Action DELETE = null;
            public static final Action DERIVE = null;
            public static final Action DOWNLOAD = null;
            public static final Action EDIT_MESSAGE = null;
            public static final Action FAVORITE = null;
            public static final Action FLAG = null;
            public static final Action MULTI_SELECT = null;
            public static final Action PIN = null;
            public static final Action REACTION = null;
            public static final Action RECALL = null;
            public static final Action REPLY = null;
            public static final Action REPLY_IN_THREAD = null;
            public static final Action SAVE_TO_LOCAL = null;
            public static final Action SAVE_TO_SPACE = null;
            public static final Action SEND_URGENT = null;
            public static final Action TRANSLATE = null;
            public static final Action TRANSMIT = null;
            public static final Action Widgets = null;
            public static final /* synthetic */ Action[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Action> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Action.Companion.getClass();
                    return b.a(r2);
                }

                public a(KClass<Action> r1, Syntax r2, Action r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }

                @JvmStatic
                public static Action a(int r0) {
                    switch(r0) {
                        case 0: goto L30;
                        case 1: goto L56;
                        case 2: goto L55;
                        case 3: goto L54;
                        case 4: goto L53;
                        case 5: goto L52;
                        case 6: goto L51;
                        case 7: goto L50;
                        case 8: goto L49;
                        case 9: goto L48;
                        case 10: goto L47;
                        case 11: goto L46;
                        case 12: goto L45;
                        case 13: goto L44;
                        case 14: goto L43;
                        case 15: goto L42;
                        case 16: goto L41;
                        case 17: goto L40;
                        case 18: goto L39;
                        case 19: goto L38;
                        case 20: goto L37;
                        case 21: goto L36;
                        case 22: goto L35;
                        case 23: goto L34;
                        case 24: goto L33;
                        case 25: goto L32;
                        default: goto L3;
                    };
                L3:
                    return null;
                L32:
                    return Action.DERIVE;
                L33:
                    return Action.CHAT_PIN;
                L34:
                    return Action.Widgets;
                L35:
                    return Action.COPY_MESSAGE_LINK;
                L36:
                    return Action.COPY;
                L37:
                    return Action.DOWNLOAD;
                L38:
                    return Action.ADD_STICKER;
                L39:
                    return Action.SAVE_TO_SPACE;
                L40:
                    return Action.SAVE_TO_LOCAL;
                L41:
                    return Action.DELETE;
                L42:
                    return Action.TRANSLATE;
                L43:
                    return Action.ADD_TASK;
                L44:
                    return Action.CLIP_TO_TOP;
                L45:
                    return Action.PIN;
                L46:
                    return Action.FAVORITE;
                L47:
                    return Action.FLAG;
                L48:
                    return Action.MULTI_SELECT;
                L49:
                    return Action.EDIT_MESSAGE;
                L50:
                    return Action.RECALL;
                L51:
                    return Action.SEND_URGENT;
                L52:
                    return Action.REPLY_IN_THREAD;
                L53:
                    return Action.TRANSMIT;
                L54:
                    return Action.REPLY;
                L55:
                    return Action.REACTION;
                L56:
                    return Action.ALL_ACTION;
                L30:
                    return Action.ACTION_UNSPECIFIED;
                }
            }

            @JvmStatic
            public static final Action fromValue(int r1) {
                Companion.getClass();
                return b.a(r1);
            }

            public static EnumEntries<Action> getEntries() {
                return b;
            }

            static {
                Action r0 = new Action("ACTION_UNSPECIFIED", 0, 0);
                ACTION_UNSPECIFIED = r0;
                Action r1 = new Action("ALL_ACTION", 1, 1);
                ALL_ACTION = r1;
                Action r3 = new Action("REACTION", 2, 2);
                REACTION = r3;
                Action r5 = new Action("REPLY", 3, 3);
                REPLY = r5;
                Action r7 = new Action("TRANSMIT", 4, 4);
                TRANSMIT = r7;
                Action r9 = new Action("REPLY_IN_THREAD", 5, 5);
                REPLY_IN_THREAD = r9;
                Action r11 = new Action("SEND_URGENT", 6, 6);
                SEND_URGENT = r11;
                Action r13 = new Action("RECALL", 7, 7);
                RECALL = r13;
                Action r15 = new Action("EDIT_MESSAGE", 8, 8);
                EDIT_MESSAGE = r15;
                Action r14 = new Action("MULTI_SELECT", 9, 9);
                MULTI_SELECT = r14;
                Action r12 = new Action("FLAG", 10, 10);
                FLAG = r12;
                Action r10 = new Action("FAVORITE", 11, 11);
                FAVORITE = r10;
                Action r8 = new Action("PIN", 12, 12);
                PIN = r8;
                Action r6 = new Action("CLIP_TO_TOP", 13, 13);
                CLIP_TO_TOP = r6;
                Action r4 = new Action("ADD_TASK", 14, 14);
                ADD_TASK = r4;
                Action r2 = new Action("TRANSLATE", 15, 15);
                TRANSLATE = r2;
                Action r16 = new Action("DELETE", 16, 16);
                DELETE = r16;
                Action r17 = new Action("SAVE_TO_LOCAL", 17, 17);
                SAVE_TO_LOCAL = r17;
                Action r19 = new Action("SAVE_TO_SPACE", 18, 18);
                SAVE_TO_SPACE = r19;
                Action r20 = new Action("ADD_STICKER", 19, 19);
                ADD_STICKER = r20;
                Action r21 = new Action("DOWNLOAD", 20, 20);
                DOWNLOAD = r21;
                Action r22 = new Action("COPY", 21, 21);
                COPY = r22;
                Action r23 = new Action("COPY_MESSAGE_LINK", 22, 22);
                COPY_MESSAGE_LINK = r23;
                Action r24 = new Action("Widgets", 23, 23);
                Widgets = r24;
                Action r25 = new Action("CHAT_PIN", 24, 24);
                CHAT_PIN = r25;
                Action r26 = new Action("DERIVE", 25, 25);
                DERIVE = r26;
                Action[] r27 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r19, r20, r21, r22, r23, r24, r25, r26};
                a = r27;
                b = EnumEntriesKt.enumEntries(r27);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Action.class), Syntax.PROTO_2, r0);
            }

            public static Action[] values() {
                return (Action[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            public static Action valueOf(String r1) {
                return (Action) r27.a.a(Action.class, r1);
            }

            public Action(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0014\u0015\u0016B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$DisabledAction$Behavior;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Message$DisabledAction$Behavior$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Message$DisabledAction$Behavior$Builder;Lokio/ByteString;)V", "display_mode", "Lcom/lark/kmp/pb/basic/v1/Message$DisabledAction$Behavior$DisplayMode;", "getDisplay_mode", "()Lcom/lark/kmp/pb/basic/v1/Message$DisabledAction$Behavior$DisplayMode;", "code", "", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "newBuilder", "toString", "", "Builder", "Companion", "DisplayMode", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class Behavior extends com.lark.wire.Message<Behavior, a> {
            public static final ProtoAdapter<Behavior> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final Integer code;
            private final DisplayMode display_mode;

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$DisabledAction$Behavior$DisplayMode;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "MODE_UNSPECIFIED", "DISABLE", "INVISIBLE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
            public static final enum DisplayMode extends Enum<DisplayMode> implements o0 {
                public static final ProtoAdapter<DisplayMode> ADAPTER = null;
                public static final b Companion = null;
                public static final DisplayMode DISABLE = null;
                public static final DisplayMode INVISIBLE = null;
                public static final DisplayMode MODE_UNSPECIFIED = null;
                public static final /* synthetic */ DisplayMode[] a = null;
                public static final /* synthetic */ EnumEntries b = null;
                private final int value;

                public static final class a extends d<DisplayMode> {
                    @Override // com.lark.wire.d
                    public final o0 n(int r2) {
                        DisplayMode.Companion.getClass();
                        if (r2 == 0) goto L12;
                        if (r2 == 1) goto L15;
                        if (r2 == 2) goto L14;
                        return null;
                    L14:
                        return DisplayMode.INVISIBLE;
                    L15:
                        return DisplayMode.DISABLE;
                    L12:
                        return DisplayMode.MODE_UNSPECIFIED;
                    }

                    public a(KClass<DisplayMode> r1, Syntax r2, DisplayMode r3) {
                        super(r1, r2, r3);
                    }
                }

                public static final class b {
                    public b() {
                    }
                }

                public static EnumEntries<DisplayMode> getEntries() {
                    return b;
                }

                static {
                    DisplayMode r0 = new DisplayMode("MODE_UNSPECIFIED", 0, 0);
                    MODE_UNSPECIFIED = r0;
                    DisplayMode r1 = new DisplayMode("DISABLE", 1, 1);
                    DISABLE = r1;
                    DisplayMode r3 = new DisplayMode("INVISIBLE", 2, 2);
                    INVISIBLE = r3;
                    DisplayMode[] r5 = {r0, r1, r3};
                    a = r5;
                    b = EnumEntriesKt.enumEntries(r5);
                    Companion = new b();
                    ADAPTER = new a(Reflection.getOrCreateKotlinClass(DisplayMode.class), Syntax.PROTO_2, r0);
                }

                public static DisplayMode[] values() {
                    return (DisplayMode[]) a.clone();
                }

                @Override // com.lark.wire.o0
                public int getValue() {
                    return this.value;
                }

                @JvmStatic
                public static final DisplayMode fromValue(int r1) {
                    Companion.getClass();
                    if (r1 == 0) goto L12;
                    if (r1 == 1) goto L15;
                    if (r1 == 2) goto L14;
                    return null;
                L14:
                    return INVISIBLE;
                L15:
                    return DISABLE;
                L12:
                    return MODE_UNSPECIFIED;
                }

                public static DisplayMode valueOf(String r1) {
                    return (DisplayMode) r27.a.a(DisplayMode.class, r1);
                }

                public DisplayMode(String r1, int r2, int r3) {
                    super(r1, r2);
                    this.value = r3;
                }
            }

            public static final class a extends com.lark.wire.Message.a<Behavior, a> {
                public DisplayMode d;
                public Integer e;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new Behavior(this, c(), null);
                }

                public a() {
                }
            }

            public static final class b extends ProtoAdapter<Behavior> {
                @Override // com.lark.wire.ProtoAdapter
                public final Behavior c(g0 r9) {
                    Intrinsics.checkNotNullParameter(r9, "reader");
                    a r0 = new a();
                    long r1 = r9.c();
                L3:
                    int r3 = r9.e();
                    if (r3 == (-1)) goto L16;
                    if (r3 != 1) goto L8;
                    r0.d = DisplayMode.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
                L13:
                    e = move-exception;
                    r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                    Unit r4 = Unit.INSTANCE;
                    goto L3
                L8:
                    if (r3 != 2) goto L9;
                    r0.e = (Integer) ProtoAdapter.h.c(r9);
                    goto L3
                L9:
                    r9.j(r3);
                    goto L3
                L16:
                    return new Behavior(r0, r9.d(r1), null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(Behavior r5) {
                    Behavior r6 = r5;
                    Intrinsics.checkNotNullParameter(r6, "value");
                    return (r6.unknownFields().size() + DisplayMode.ADAPTER.l(1, r6.getDisplay_mode())) + ProtoAdapter.h.l(2, r6.getCode());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r4, Behavior r5) {
                    Behavior r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    DisplayMode.ADAPTER.i(r4, 1, r6.getDisplay_mode());
                    ProtoAdapter.h.i(r4, 2, r6.getCode());
                    r4.a(r6.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r4, Behavior r5) {
                    Behavior r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    r4.d(r6.unknownFields());
                    ProtoAdapter.h.j(r4, 2, r6.getCode());
                    DisplayMode.ADAPTER.j(r4, 1, r6.getDisplay_mode());
                }

                public b(FieldEncoding r7, KClass<Behavior> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.Message.DisabledAction.Behavior", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ Behavior(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Behavior.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.display_mode;
                r0.e = this.code;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(Behavior.class).getSimpleName() + '@' + hashCode();
            }

            public final Integer getCode() {
                return this.code;
            }

            public final DisplayMode getDisplay_mode() {
                return this.display_mode;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public Behavior(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.display_mode = r2.d;
                this.code = r2.e;
            }

            public /* synthetic */ Behavior(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        public static final class a extends com.lark.wire.Message.a<DisabledAction, a> {
            public Map<Integer, Behavior> d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new DisabledAction(this, c(), null);
            }

            public a() {
                this.d = MapsKt.emptyMap();
            }
        }

        public static final class b {
            public b() {
            }
        }

        public /* synthetic */ DisabledAction(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new b();
            final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
            final KClass r1 = Reflection.getOrCreateKotlinClass(DisabledAction.class);
            final Syntax r2 = Syntax.PROTO_2;
            ADAPTER = new Message$DisabledAction$Companion$ADAPTER$1(r0, r1, r2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.actions;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(DisabledAction.class).getSimpleName() + '@' + hashCode();
        }

        public final Map<Integer, Behavior> getActions() {
            return this.actions;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public DisabledAction(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.actions = com.lark.wire.internal.a.d("actions", r2.d);
        }

        public /* synthetic */ DisabledAction(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$FileDeletedStatus;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NORMAL", "RECOVERABLE", "UNRECOVERABLE", "RECALLED", "FREED_UP", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum FileDeletedStatus extends Enum<FileDeletedStatus> implements o0 {
        public static final ProtoAdapter<FileDeletedStatus> ADAPTER = null;
        public static final b Companion = null;
        public static final FileDeletedStatus FREED_UP = null;
        public static final FileDeletedStatus NORMAL = null;
        public static final FileDeletedStatus RECALLED = null;
        public static final FileDeletedStatus RECOVERABLE = null;
        public static final FileDeletedStatus UNRECOVERABLE = null;
        public static final /* synthetic */ FileDeletedStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<FileDeletedStatus> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                FileDeletedStatus.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<FileDeletedStatus> r1, Syntax r2, FileDeletedStatus r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static FileDeletedStatus a(int r1) {
                if (r1 == 0) goto L17;
                if (r1 == 1) goto L22;
                if (r1 == 2) goto L21;
                if (r1 == 3) goto L20;
                if (r1 == 4) goto L19;
                return null;
            L19:
                return FileDeletedStatus.FREED_UP;
            L20:
                return FileDeletedStatus.RECALLED;
            L21:
                return FileDeletedStatus.UNRECOVERABLE;
            L22:
                return FileDeletedStatus.RECOVERABLE;
            L17:
                return FileDeletedStatus.NORMAL;
            }
        }

        @JvmStatic
        public static final FileDeletedStatus fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<FileDeletedStatus> getEntries() {
            return b;
        }

        static {
            FileDeletedStatus r0 = new FileDeletedStatus("NORMAL", 0, 0);
            NORMAL = r0;
            FileDeletedStatus r1 = new FileDeletedStatus("RECOVERABLE", 1, 1);
            RECOVERABLE = r1;
            FileDeletedStatus r3 = new FileDeletedStatus("UNRECOVERABLE", 2, 2);
            UNRECOVERABLE = r3;
            FileDeletedStatus r5 = new FileDeletedStatus("RECALLED", 3, 3);
            RECALLED = r5;
            FileDeletedStatus r7 = new FileDeletedStatus("FREED_UP", 4, 4);
            FREED_UP = r7;
            FileDeletedStatus[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(FileDeletedStatus.class), Syntax.PROTO_2, r0);
        }

        public static FileDeletedStatus[] values() {
            return (FileDeletedStatus[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static FileDeletedStatus valueOf(String r1) {
            return (FileDeletedStatus) r27.a.a(FileDeletedStatus.class, r1);
        }

        public FileDeletedStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$FromType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_FROM_TYPE", "USER", "BOT", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum FromType extends Enum<FromType> implements o0 {
        public static final ProtoAdapter<FromType> ADAPTER = null;
        public static final FromType BOT = null;
        public static final b Companion = null;
        public static final FromType UNKNOWN_FROM_TYPE = null;
        public static final FromType USER = null;
        public static final /* synthetic */ FromType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<FromType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                FromType.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return FromType.BOT;
            L15:
                return FromType.USER;
            L12:
                return FromType.UNKNOWN_FROM_TYPE;
            }

            public a(KClass<FromType> r1, Syntax r2, FromType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<FromType> getEntries() {
            return b;
        }

        static {
            FromType r0 = new FromType("UNKNOWN_FROM_TYPE", 0, 0);
            UNKNOWN_FROM_TYPE = r0;
            FromType r1 = new FromType("USER", 1, 1);
            USER = r1;
            FromType r3 = new FromType("BOT", 2, 2);
            BOT = r3;
            FromType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(FromType.class), Syntax.PROTO_2, r0);
        }

        public static FromType[] values() {
            return (FromType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final FromType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return BOT;
        L15:
            return USER;
        L12:
            return UNKNOWN_FROM_TYPE;
        }

        public static FromType valueOf(String r1) {
            return (FromType) r27.a.a(FromType.class, r1);
        }

        public FromType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$MessageAttachmentType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_ATTACHMENT_TYPE", "ATTACHMENT_IMAGE", "ATTACHMENT_VIDEO", "ATTACHMENT_FILE", "ATTACHMENT_LINK", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum MessageAttachmentType extends Enum<MessageAttachmentType> implements o0 {
        public static final ProtoAdapter<MessageAttachmentType> ADAPTER = null;
        public static final MessageAttachmentType ATTACHMENT_FILE = null;
        public static final MessageAttachmentType ATTACHMENT_IMAGE = null;
        public static final MessageAttachmentType ATTACHMENT_LINK = null;
        public static final MessageAttachmentType ATTACHMENT_VIDEO = null;
        public static final b Companion = null;
        public static final MessageAttachmentType UNKNOWN_ATTACHMENT_TYPE = null;
        public static final /* synthetic */ MessageAttachmentType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<MessageAttachmentType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                MessageAttachmentType.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<MessageAttachmentType> r1, Syntax r2, MessageAttachmentType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static MessageAttachmentType a(int r1) {
                if (r1 == 0) goto L17;
                if (r1 == 1) goto L22;
                if (r1 == 2) goto L21;
                if (r1 == 3) goto L20;
                if (r1 == 4) goto L19;
                return null;
            L19:
                return MessageAttachmentType.ATTACHMENT_LINK;
            L20:
                return MessageAttachmentType.ATTACHMENT_FILE;
            L21:
                return MessageAttachmentType.ATTACHMENT_VIDEO;
            L22:
                return MessageAttachmentType.ATTACHMENT_IMAGE;
            L17:
                return MessageAttachmentType.UNKNOWN_ATTACHMENT_TYPE;
            }
        }

        @JvmStatic
        public static final MessageAttachmentType fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<MessageAttachmentType> getEntries() {
            return b;
        }

        static {
            MessageAttachmentType r0 = new MessageAttachmentType("UNKNOWN_ATTACHMENT_TYPE", 0, 0);
            UNKNOWN_ATTACHMENT_TYPE = r0;
            MessageAttachmentType r1 = new MessageAttachmentType("ATTACHMENT_IMAGE", 1, 1);
            ATTACHMENT_IMAGE = r1;
            MessageAttachmentType r3 = new MessageAttachmentType("ATTACHMENT_VIDEO", 2, 2);
            ATTACHMENT_VIDEO = r3;
            MessageAttachmentType r5 = new MessageAttachmentType("ATTACHMENT_FILE", 3, 3);
            ATTACHMENT_FILE = r5;
            MessageAttachmentType r7 = new MessageAttachmentType("ATTACHMENT_LINK", 4, 4);
            ATTACHMENT_LINK = r7;
            MessageAttachmentType[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(MessageAttachmentType.class), Syntax.PROTO_2, r0);
        }

        public static MessageAttachmentType[] values() {
            return (MessageAttachmentType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static MessageAttachmentType valueOf(String r1) {
            return (MessageAttachmentType) r27.a.a(MessageAttachmentType.class, r1);
        }

        public MessageAttachmentType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$MessageSensitivity;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_SENSITIVITY", "SAFE", "DANGEROUS", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum MessageSensitivity extends Enum<MessageSensitivity> implements o0 {
        public static final ProtoAdapter<MessageSensitivity> ADAPTER = null;
        public static final b Companion = null;
        public static final MessageSensitivity DANGEROUS = null;
        public static final MessageSensitivity SAFE = null;
        public static final MessageSensitivity UNKNOWN_SENSITIVITY = null;
        public static final /* synthetic */ MessageSensitivity[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<MessageSensitivity> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                MessageSensitivity.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return MessageSensitivity.DANGEROUS;
            L15:
                return MessageSensitivity.SAFE;
            L12:
                return MessageSensitivity.UNKNOWN_SENSITIVITY;
            }

            public a(KClass<MessageSensitivity> r1, Syntax r2, MessageSensitivity r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<MessageSensitivity> getEntries() {
            return b;
        }

        static {
            MessageSensitivity r0 = new MessageSensitivity("UNKNOWN_SENSITIVITY", 0, 0);
            UNKNOWN_SENSITIVITY = r0;
            MessageSensitivity r1 = new MessageSensitivity("SAFE", 1, 1);
            SAFE = r1;
            MessageSensitivity r3 = new MessageSensitivity("DANGEROUS", 2, 2);
            DANGEROUS = r3;
            MessageSensitivity[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(MessageSensitivity.class), Syntax.PROTO_2, r0);
        }

        public static MessageSensitivity[] values() {
            return (MessageSensitivity[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final MessageSensitivity fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return DANGEROUS;
        L15:
            return SAFE;
        L12:
            return UNKNOWN_SENSITIVITY;
        }

        public static MessageSensitivity valueOf(String r1) {
            return (MessageSensitivity) r27.a.a(MessageSensitivity.class, r1);
        }

        public MessageSensitivity(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0013\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$PartialReplyInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Message$PartialReplyInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Message$PartialReplyInfo$Builder;Lokio/ByteString;)V", "content", "Lcom/lark/kmp/pb/basic/v1/RichText;", "getContent", "()Lcom/lark/kmp/pb/basic/v1/RichText;", "position", "Lcom/lark/kmp/pb/basic/v1/Message$PartialReplyInfo$PartialContentRelativePosition;", "getPosition", "()Lcom/lark/kmp/pb/basic/v1/Message$PartialReplyInfo$PartialContentRelativePosition;", "newBuilder", "toString", "", "Builder", "Companion", "PartialContentRelativePosition", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class PartialReplyInfo extends com.lark.wire.Message<PartialReplyInfo, a> {
        public static final ProtoAdapter<PartialReplyInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final RichText content;
        private final PartialContentRelativePosition position;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$PartialReplyInfo$PartialContentRelativePosition;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "HEAD", "MIDDLE", "TAIL", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum PartialContentRelativePosition extends Enum<PartialContentRelativePosition> implements o0 {
            public static final ProtoAdapter<PartialContentRelativePosition> ADAPTER = null;
            public static final b Companion = null;
            public static final PartialContentRelativePosition HEAD = null;
            public static final PartialContentRelativePosition MIDDLE = null;
            public static final PartialContentRelativePosition TAIL = null;
            public static final PartialContentRelativePosition UNKNOWN = null;
            public static final /* synthetic */ PartialContentRelativePosition[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<PartialContentRelativePosition> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    PartialContentRelativePosition.Companion.getClass();
                    if (r2 == 0) goto L15;
                    if (r2 == 1) goto L19;
                    if (r2 == 2) goto L18;
                    if (r2 == 3) goto L17;
                    return null;
                L17:
                    return PartialContentRelativePosition.TAIL;
                L18:
                    return PartialContentRelativePosition.MIDDLE;
                L19:
                    return PartialContentRelativePosition.HEAD;
                L15:
                    return PartialContentRelativePosition.UNKNOWN;
                }

                public a(KClass<PartialContentRelativePosition> r1, Syntax r2, PartialContentRelativePosition r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<PartialContentRelativePosition> getEntries() {
                return b;
            }

            static {
                PartialContentRelativePosition r0 = new PartialContentRelativePosition("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                PartialContentRelativePosition r1 = new PartialContentRelativePosition("HEAD", 1, 1);
                HEAD = r1;
                PartialContentRelativePosition r3 = new PartialContentRelativePosition("MIDDLE", 2, 2);
                MIDDLE = r3;
                PartialContentRelativePosition r5 = new PartialContentRelativePosition("TAIL", 3, 3);
                TAIL = r5;
                PartialContentRelativePosition[] r7 = {r0, r1, r3, r5};
                a = r7;
                b = EnumEntriesKt.enumEntries(r7);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(PartialContentRelativePosition.class), Syntax.PROTO_2, r0);
            }

            public static PartialContentRelativePosition[] values() {
                return (PartialContentRelativePosition[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final PartialContentRelativePosition fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L15;
                if (r1 == 1) goto L19;
                if (r1 == 2) goto L18;
                if (r1 == 3) goto L17;
                return null;
            L17:
                return TAIL;
            L18:
                return MIDDLE;
            L19:
                return HEAD;
            L15:
                return UNKNOWN;
            }

            public static PartialContentRelativePosition valueOf(String r1) {
                return (PartialContentRelativePosition) r27.a.a(PartialContentRelativePosition.class, r1);
            }

            public PartialContentRelativePosition(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<PartialReplyInfo, a> {
            public RichText d;
            public PartialContentRelativePosition e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new PartialReplyInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<PartialReplyInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final PartialReplyInfo c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L16;
                if (r3 != 1) goto L8;
                r0.d = RichText.ADAPTER.c(r9);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.e = PartialContentRelativePosition.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L9:
                r9.j(r3);
                goto L3
            L16:
                return new PartialReplyInfo(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(PartialReplyInfo r5) {
                PartialReplyInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + RichText.ADAPTER.l(1, r6.getContent())) + PartialContentRelativePosition.ADAPTER.l(2, r6.getPosition());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, PartialReplyInfo r5) {
                PartialReplyInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                RichText.ADAPTER.i(r4, 1, r6.getContent());
                PartialContentRelativePosition.ADAPTER.i(r4, 2, r6.getPosition());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, PartialReplyInfo r5) {
                PartialReplyInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                PartialContentRelativePosition.ADAPTER.j(r4, 2, r6.getPosition());
                RichText.ADAPTER.j(r4, 1, r6.getContent());
            }

            public b(FieldEncoding r7, KClass<PartialReplyInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Message.PartialReplyInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ PartialReplyInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PartialReplyInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.content;
            r0.e = this.position;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(PartialReplyInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final RichText getContent() {
            return this.content;
        }

        public final PartialContentRelativePosition getPosition() {
            return this.position;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public PartialReplyInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.content = r2.d;
            this.position = r2.e;
        }

        public /* synthetic */ PartialReplyInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$Pin;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Message$Pin$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Message$Pin$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "operator_id", "getOperator_id", "timestamp", "", "getTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Pin extends com.lark.wire.Message<Pin, a> {
        public static final ProtoAdapter<Pin> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String id;
        private final String operator_id;
        private final Long timestamp;

        public static final class a extends com.lark.wire.Message.a<Pin, a> {
            public String d;
            public String e;
            public Long f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Pin(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Pin> {
            @Override // com.lark.wire.ProtoAdapter
            public final Pin c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L16;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                String r5 = r7.i();
                Intrinsics.checkNotNullParameter(r5, "id");
                r1.d = r5;
                goto L3
            L8:
                if (r4 != 2) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                String r6 = r7.i();
                Intrinsics.checkNotNullParameter(r6, "operator_id");
                r1.e = r6;
                goto L3
            L10:
                if (r4 != 3) goto L11;
                r1.f = (Long) ProtoAdapter.k.c(r7);
                goto L3
            L11:
                r7.j(r4);
                Unit r8 = Unit.INSTANCE;
                goto L3
            L16:
                return new Pin(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Pin r5) {
                Pin r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return ((r0 + r1.l(1, r6.getId())) + r1.l(2, r6.getOperator_id())) + ProtoAdapter.k.l(3, r6.getTimestamp());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Pin r5) {
                Pin r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getId());
                r0.i(r4, 2, r6.getOperator_id());
                ProtoAdapter.k.i(r4, 3, r6.getTimestamp());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, Pin r5) {
                Pin r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.k.j(r4, 3, r6.getTimestamp());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 2, r6.getOperator_id());
                r0.j(r4, 1, r6.getId());
            }

            public b(FieldEncoding r7, KClass<Pin> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Message.Pin", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Pin(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Pin.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.id;
            r0.e = this.operator_id;
            r0.f = this.timestamp;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Pin.class).getSimpleName() + '@' + hashCode();
        }

        public final String getId() {
            return this.id;
        }

        public final String getOperator_id() {
            return this.operator_id;
        }

        public final Long getTimestamp() {
            return this.timestamp;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Pin(a r2, ByteString r3) {
            super(ADAPTER, r3);
            String r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.id = r4;
            String r5 = r2.e;
            Intrinsics.checkNotNull(r5);
            this.operator_id = r5;
            this.timestamp = r2.f;
        }

        public /* synthetic */ Pin(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$Reaction;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Message$Reaction$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Message$Reaction$Builder;Lokio/ByteString;)V", "type", "", "getType", "()Ljava/lang/String;", "chatter_ids", "", "getChatter_ids", "()Ljava/util/List;", "chatter_count", "", "getChatter_count", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Reaction extends com.lark.wire.Message<Reaction, a> {
        public static final ProtoAdapter<Reaction> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Integer chatter_count;
        private final List<String> chatter_ids;
        private final String type;

        public static final class a extends com.lark.wire.Message.a<Reaction, a> {
            public String d;
            public List<String> e;
            public Integer f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Reaction(this, c(), null);
            }

            public a() {
                this.e = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<Reaction> {
            @Override // com.lark.wire.ProtoAdapter
            public final Reaction c(g0 r8) {
                Intrinsics.checkNotNullParameter(r8, "reader");
                a r1 = new a();
                ArrayList r2 = new ArrayList();
                long r3 = r8.c();
            L3:
                int r5 = r8.e();
                if (r5 == (-1)) goto L15;
                if (r5 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                String r6 = r8.i();
                Intrinsics.checkNotNullParameter(r6, "type");
                r1.d = r6;
                goto L3
            L8:
                if (r5 != 2) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r2.add(r8.i());
                goto L3
            L10:
                if (r5 != 3) goto L11;
                r1.f = (Integer) ProtoAdapter.h.c(r8);
                goto L3
            L11:
                r8.j(r5);
                Unit r7 = Unit.INSTANCE;
                goto L3
            L15:
                ByteString r9 = r8.d(r3);
                Intrinsics.checkNotNullParameter(r2, "chatter_ids");
                com.lark.wire.internal.a.a(r2);
                r1.e = r2;
                return new Reaction(r1, r9, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Reaction r5) {
                Reaction r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return ((r0 + r1.l(1, r6.getType())) + r1.a().l(2, r6.getChatter_ids())) + ProtoAdapter.h.l(3, r6.getChatter_count());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Reaction r5) {
                Reaction r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getType());
                r0.a().i(r4, 2, r6.getChatter_ids());
                ProtoAdapter.h.i(r4, 3, r6.getChatter_count());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, Reaction r6) {
                Reaction r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                ProtoAdapter.h.j(r5, 3, r7.getChatter_count());
                w r0 = ProtoAdapter.q;
                r0.a().j(r5, 2, r7.getChatter_ids());
                r0.j(r5, 1, r7.getType());
            }

            public b(FieldEncoding r7, KClass<Reaction> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Message.Reaction", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Reaction(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Reaction.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.type;
            r0.e = this.chatter_ids;
            r0.f = this.chatter_count;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Reaction.class).getSimpleName() + '@' + hashCode();
        }

        public final Integer getChatter_count() {
            return this.chatter_count;
        }

        public final List<String> getChatter_ids() {
            return this.chatter_ids;
        }

        public final String getType() {
            return this.type;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Reaction(a r2, ByteString r3) {
            super(ADAPTER, r3);
            String r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.type = r4;
            this.chatter_ids = com.lark.wire.internal.a.c("chatter_ids", r2.e);
            this.chatter_count = r2.f;
        }

        public /* synthetic */ Reaction(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$RecallerIdentity;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_IDENTITY", "OWNER", "ADMINISTRATOR", "GROUP_ADMIN", "ENTERPRISE_ADMINISTRATOR", "DOUBAO_QUERY_OWNER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum RecallerIdentity extends Enum<RecallerIdentity> implements o0 {
        public static final ProtoAdapter<RecallerIdentity> ADAPTER = null;
        public static final RecallerIdentity ADMINISTRATOR = null;
        public static final b Companion = null;
        public static final RecallerIdentity DOUBAO_QUERY_OWNER = null;
        public static final RecallerIdentity ENTERPRISE_ADMINISTRATOR = null;
        public static final RecallerIdentity GROUP_ADMIN = null;
        public static final RecallerIdentity OWNER = null;
        public static final RecallerIdentity UNKNOWN_IDENTITY = null;
        public static final /* synthetic */ RecallerIdentity[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<RecallerIdentity> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                RecallerIdentity.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<RecallerIdentity> r1, Syntax r2, RecallerIdentity r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static RecallerIdentity a(int r1) {
                if (r1 == 0) goto L20;
                if (r1 == 1) goto L26;
                if (r1 == 2) goto L25;
                if (r1 == 3) goto L24;
                if (r1 == 4) goto L23;
                if (r1 == 5) goto L22;
                return null;
            L22:
                return RecallerIdentity.DOUBAO_QUERY_OWNER;
            L23:
                return RecallerIdentity.ENTERPRISE_ADMINISTRATOR;
            L24:
                return RecallerIdentity.GROUP_ADMIN;
            L25:
                return RecallerIdentity.ADMINISTRATOR;
            L26:
                return RecallerIdentity.OWNER;
            L20:
                return RecallerIdentity.UNKNOWN_IDENTITY;
            }
        }

        @JvmStatic
        public static final RecallerIdentity fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<RecallerIdentity> getEntries() {
            return b;
        }

        static {
            RecallerIdentity r0 = new RecallerIdentity("UNKNOWN_IDENTITY", 0, 0);
            UNKNOWN_IDENTITY = r0;
            RecallerIdentity r1 = new RecallerIdentity("OWNER", 1, 1);
            OWNER = r1;
            RecallerIdentity r3 = new RecallerIdentity("ADMINISTRATOR", 2, 2);
            ADMINISTRATOR = r3;
            RecallerIdentity r5 = new RecallerIdentity("GROUP_ADMIN", 3, 3);
            GROUP_ADMIN = r5;
            RecallerIdentity r7 = new RecallerIdentity("ENTERPRISE_ADMINISTRATOR", 4, 4);
            ENTERPRISE_ADMINISTRATOR = r7;
            RecallerIdentity r9 = new RecallerIdentity("DOUBAO_QUERY_OWNER", 5, 5);
            DOUBAO_QUERY_OWNER = r9;
            RecallerIdentity[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(RecallerIdentity.class), Syntax.PROTO_2, r0);
        }

        public static RecallerIdentity[] values() {
            return (RecallerIdentity[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static RecallerIdentity valueOf(String r1) {
            return (RecallerIdentity) r27.a.a(RecallerIdentity.class, r1);
        }

        public RecallerIdentity(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$SourceType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TYPE_FROM_UNKONWN", "TYPE_FROM_MESSAGE", "TYPE_FROM_MERGEFORWARD", "TYPE_FROM_FAVORITE", "TYPE_FROM_TODO_REFER_RESOURCE", "TYPE_FROM_FLAG", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum SourceType extends Enum<SourceType> implements o0 {
        public static final ProtoAdapter<SourceType> ADAPTER = null;
        public static final b Companion = null;
        public static final SourceType TYPE_FROM_FAVORITE = null;
        public static final SourceType TYPE_FROM_FLAG = null;
        public static final SourceType TYPE_FROM_MERGEFORWARD = null;
        public static final SourceType TYPE_FROM_MESSAGE = null;
        public static final SourceType TYPE_FROM_TODO_REFER_RESOURCE = null;
        public static final SourceType TYPE_FROM_UNKONWN = null;
        public static final /* synthetic */ SourceType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<SourceType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                SourceType.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<SourceType> r1, Syntax r2, SourceType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static SourceType a(int r1) {
                if (r1 == 0) goto L20;
                if (r1 == 1) goto L26;
                if (r1 == 2) goto L25;
                if (r1 == 3) goto L24;
                if (r1 == 4) goto L23;
                if (r1 == 7) goto L22;
                return null;
            L22:
                return SourceType.TYPE_FROM_FLAG;
            L23:
                return SourceType.TYPE_FROM_TODO_REFER_RESOURCE;
            L24:
                return SourceType.TYPE_FROM_FAVORITE;
            L25:
                return SourceType.TYPE_FROM_MERGEFORWARD;
            L26:
                return SourceType.TYPE_FROM_MESSAGE;
            L20:
                return SourceType.TYPE_FROM_UNKONWN;
            }
        }

        @JvmStatic
        public static final SourceType fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<SourceType> getEntries() {
            return b;
        }

        static {
            SourceType r0 = new SourceType("TYPE_FROM_UNKONWN", 0, 0);
            TYPE_FROM_UNKONWN = r0;
            SourceType r1 = new SourceType("TYPE_FROM_MESSAGE", 1, 1);
            TYPE_FROM_MESSAGE = r1;
            SourceType r3 = new SourceType("TYPE_FROM_MERGEFORWARD", 2, 2);
            TYPE_FROM_MERGEFORWARD = r3;
            SourceType r5 = new SourceType("TYPE_FROM_FAVORITE", 3, 3);
            TYPE_FROM_FAVORITE = r5;
            SourceType r7 = new SourceType("TYPE_FROM_TODO_REFER_RESOURCE", 4, 4);
            TYPE_FROM_TODO_REFER_RESOURCE = r7;
            SourceType r9 = new SourceType("TYPE_FROM_FLAG", 5, 7);
            TYPE_FROM_FLAG = r9;
            SourceType[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(SourceType.class), Syntax.PROTO_2, r0);
        }

        public static SourceType[] values() {
            return (SourceType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static SourceType valueOf(String r1) {
            return (SourceType) r27.a.a(SourceType.class, r1);
        }

        public SourceType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$StreamStatus;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "STREAM_UNKNOWN", "STREAM_TRANSPORT", "STREAM_OVER", "STREAM_ERROR", "STREAM_BREAK", "STREAM_PREPARE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum StreamStatus extends Enum<StreamStatus> implements o0 {
        public static final ProtoAdapter<StreamStatus> ADAPTER = null;
        public static final b Companion = null;
        public static final StreamStatus STREAM_BREAK = null;
        public static final StreamStatus STREAM_ERROR = null;
        public static final StreamStatus STREAM_OVER = null;
        public static final StreamStatus STREAM_PREPARE = null;
        public static final StreamStatus STREAM_TRANSPORT = null;
        public static final StreamStatus STREAM_UNKNOWN = null;
        public static final /* synthetic */ StreamStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<StreamStatus> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                StreamStatus.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<StreamStatus> r1, Syntax r2, StreamStatus r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static StreamStatus a(int r1) {
                if (r1 == 0) goto L20;
                if (r1 == 1) goto L26;
                if (r1 == 2) goto L25;
                if (r1 == 3) goto L24;
                if (r1 == 4) goto L23;
                if (r1 == 5) goto L22;
                return null;
            L22:
                return StreamStatus.STREAM_PREPARE;
            L23:
                return StreamStatus.STREAM_BREAK;
            L24:
                return StreamStatus.STREAM_ERROR;
            L25:
                return StreamStatus.STREAM_OVER;
            L26:
                return StreamStatus.STREAM_TRANSPORT;
            L20:
                return StreamStatus.STREAM_UNKNOWN;
            }
        }

        @JvmStatic
        public static final StreamStatus fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<StreamStatus> getEntries() {
            return b;
        }

        static {
            StreamStatus r0 = new StreamStatus("STREAM_UNKNOWN", 0, 0);
            STREAM_UNKNOWN = r0;
            StreamStatus r1 = new StreamStatus("STREAM_TRANSPORT", 1, 1);
            STREAM_TRANSPORT = r1;
            StreamStatus r3 = new StreamStatus("STREAM_OVER", 2, 2);
            STREAM_OVER = r3;
            StreamStatus r5 = new StreamStatus("STREAM_ERROR", 3, 3);
            STREAM_ERROR = r5;
            StreamStatus r7 = new StreamStatus("STREAM_BREAK", 4, 4);
            STREAM_BREAK = r7;
            StreamStatus r9 = new StreamStatus("STREAM_PREPARE", 5, 5);
            STREAM_PREPARE = r9;
            StreamStatus[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(StreamStatus.class), Syntax.PROTO_2, r0);
        }

        public static StreamStatus[] values() {
            return (StreamStatus[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static StreamStatus valueOf(String r1) {
            return (StreamStatus) r27.a.a(StreamStatus.class, r1);
        }

        public StreamStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$SyncToChatMessageType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_SYNC_TO_CHAT_MESSAGE_TYPE", "SYNC_TO_CHAT_TARGET_MESSAGE", "SYNC_TO_CHAT_SOURCE_MESSAGE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum SyncToChatMessageType extends Enum<SyncToChatMessageType> implements o0 {
        public static final ProtoAdapter<SyncToChatMessageType> ADAPTER = null;
        public static final b Companion = null;
        public static final SyncToChatMessageType SYNC_TO_CHAT_SOURCE_MESSAGE = null;
        public static final SyncToChatMessageType SYNC_TO_CHAT_TARGET_MESSAGE = null;
        public static final SyncToChatMessageType UNKNOWN_SYNC_TO_CHAT_MESSAGE_TYPE = null;
        public static final /* synthetic */ SyncToChatMessageType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<SyncToChatMessageType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                SyncToChatMessageType.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return SyncToChatMessageType.SYNC_TO_CHAT_SOURCE_MESSAGE;
            L15:
                return SyncToChatMessageType.SYNC_TO_CHAT_TARGET_MESSAGE;
            L12:
                return SyncToChatMessageType.UNKNOWN_SYNC_TO_CHAT_MESSAGE_TYPE;
            }

            public a(KClass<SyncToChatMessageType> r1, Syntax r2, SyncToChatMessageType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<SyncToChatMessageType> getEntries() {
            return b;
        }

        static {
            SyncToChatMessageType r0 = new SyncToChatMessageType("UNKNOWN_SYNC_TO_CHAT_MESSAGE_TYPE", 0, 0);
            UNKNOWN_SYNC_TO_CHAT_MESSAGE_TYPE = r0;
            SyncToChatMessageType r1 = new SyncToChatMessageType("SYNC_TO_CHAT_TARGET_MESSAGE", 1, 1);
            SYNC_TO_CHAT_TARGET_MESSAGE = r1;
            SyncToChatMessageType r3 = new SyncToChatMessageType("SYNC_TO_CHAT_SOURCE_MESSAGE", 2, 2);
            SYNC_TO_CHAT_SOURCE_MESSAGE = r3;
            SyncToChatMessageType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(SyncToChatMessageType.class), Syntax.PROTO_2, r0);
        }

        public static SyncToChatMessageType[] values() {
            return (SyncToChatMessageType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final SyncToChatMessageType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return SYNC_TO_CHAT_SOURCE_MESSAGE;
        L15:
            return SYNC_TO_CHAT_TARGET_MESSAGE;
        L12:
            return UNKNOWN_SYNC_TO_CHAT_MESSAGE_TYPE;
        }

        public static SyncToChatMessageType valueOf(String r1) {
            return (SyncToChatMessageType) r27.a.a(SyncToChatMessageType.class, r1);
        }

        public SyncToChatMessageType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$ThreadMessageType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_THREAD_MESSAGE", "THREAD_ROOT_MESSAGE", "THREAD_REPLY_MESSAGE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum ThreadMessageType extends Enum<ThreadMessageType> implements o0 {
        public static final ProtoAdapter<ThreadMessageType> ADAPTER = null;
        public static final b Companion = null;
        public static final ThreadMessageType THREAD_REPLY_MESSAGE = null;
        public static final ThreadMessageType THREAD_ROOT_MESSAGE = null;
        public static final ThreadMessageType UNKNOWN_THREAD_MESSAGE = null;
        public static final /* synthetic */ ThreadMessageType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<ThreadMessageType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                ThreadMessageType.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return ThreadMessageType.THREAD_REPLY_MESSAGE;
            L15:
                return ThreadMessageType.THREAD_ROOT_MESSAGE;
            L12:
                return ThreadMessageType.UNKNOWN_THREAD_MESSAGE;
            }

            public a(KClass<ThreadMessageType> r1, Syntax r2, ThreadMessageType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<ThreadMessageType> getEntries() {
            return b;
        }

        static {
            ThreadMessageType r0 = new ThreadMessageType("UNKNOWN_THREAD_MESSAGE", 0, 0);
            UNKNOWN_THREAD_MESSAGE = r0;
            ThreadMessageType r1 = new ThreadMessageType("THREAD_ROOT_MESSAGE", 1, 1);
            THREAD_ROOT_MESSAGE = r1;
            ThreadMessageType r3 = new ThreadMessageType("THREAD_REPLY_MESSAGE", 2, 2);
            THREAD_REPLY_MESSAGE = r3;
            ThreadMessageType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(ThreadMessageType.class), Syntax.PROTO_2, r0);
        }

        public static ThreadMessageType[] values() {
            return (ThreadMessageType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final ThreadMessageType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return THREAD_REPLY_MESSAGE;
        L15:
            return THREAD_ROOT_MESSAGE;
        L12:
            return UNKNOWN_THREAD_MESSAGE;
        }

        public static ThreadMessageType valueOf(String r1) {
            return (ThreadMessageType) r27.a.a(ThreadMessageType.class, r1);
        }

        public ThreadMessageType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b \b\u0086\u0081\u0002\u0018\u0000 #2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001#B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006$"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "POST", "FILE", "TEXT", "IMAGE", "SYSTEM", "AUDIO", "EMAIL", "SHARE_GROUP_CHAT", "STICKER", "MERGE_FORWARD", "CALENDAR", "CARD", "MEDIA", "SHARE_CALENDAR_EVENT", "HONGBAO", "GENERAL_CALENDAR", "VIDEO_CHAT", "LOCATION", "COMMERCIALIZED_HONGBAO", "SHARE_USER_CARD", "TODO", "FOLDER", "DIAGNOSE", "VOTE", "DOUBAO", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type AUDIO = null;
        public static final Type CALENDAR = null;
        public static final Type CARD = null;
        public static final Type COMMERCIALIZED_HONGBAO = null;
        public static final b Companion = null;
        public static final Type DIAGNOSE = null;
        public static final Type DOUBAO = null;
        public static final Type EMAIL = null;
        public static final Type FILE = null;
        public static final Type FOLDER = null;
        public static final Type GENERAL_CALENDAR = null;
        public static final Type HONGBAO = null;
        public static final Type IMAGE = null;
        public static final Type LOCATION = null;
        public static final Type MEDIA = null;
        public static final Type MERGE_FORWARD = null;
        public static final Type POST = null;
        public static final Type SHARE_CALENDAR_EVENT = null;
        public static final Type SHARE_GROUP_CHAT = null;
        public static final Type SHARE_USER_CARD = null;
        public static final Type STICKER = null;
        public static final Type SYSTEM = null;
        public static final Type TEXT = null;
        public static final Type TODO = null;
        public static final Type UNKNOWN = null;
        public static final Type VIDEO_CHAT = null;
        public static final Type VOTE = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Type.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Type> r1, Syntax r2, Type r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Type a(int r0) {
                switch(r0) {
                    case 0: goto L30;
                    case 1: goto L3;
                    case 2: goto L56;
                    case 3: goto L55;
                    case 4: goto L54;
                    case 5: goto L53;
                    case 6: goto L52;
                    case 7: goto L51;
                    case 8: goto L50;
                    case 9: goto L49;
                    case 10: goto L48;
                    case 11: goto L47;
                    case 12: goto L46;
                    case 13: goto L45;
                    case 14: goto L3;
                    case 15: goto L44;
                    case 16: goto L43;
                    case 17: goto L42;
                    case 18: goto L41;
                    case 19: goto L40;
                    case 20: goto L39;
                    case 21: goto L3;
                    case 22: goto L38;
                    case 23: goto L37;
                    case 24: goto L36;
                    case 25: goto L35;
                    case 26: goto L34;
                    case 27: goto L33;
                    case 28: goto L3;
                    case 29: goto L32;
                    default: goto L3;
                };
            L3:
                return null;
            L32:
                return Type.DOUBAO;
            L33:
                return Type.VOTE;
            L34:
                return Type.DIAGNOSE;
            L35:
                return Type.FOLDER;
            L36:
                return Type.TODO;
            L37:
                return Type.SHARE_USER_CARD;
            L38:
                return Type.COMMERCIALIZED_HONGBAO;
            L39:
                return Type.LOCATION;
            L40:
                return Type.VIDEO_CHAT;
            L41:
                return Type.GENERAL_CALENDAR;
            L42:
                return Type.HONGBAO;
            L43:
                return Type.SHARE_CALENDAR_EVENT;
            L44:
                return Type.MEDIA;
            L45:
                return Type.CARD;
            L46:
                return Type.CALENDAR;
            L47:
                return Type.MERGE_FORWARD;
            L48:
                return Type.STICKER;
            L49:
                return Type.SHARE_GROUP_CHAT;
            L50:
                return Type.EMAIL;
            L51:
                return Type.AUDIO;
            L52:
                return Type.SYSTEM;
            L53:
                return Type.IMAGE;
            L54:
                return Type.TEXT;
            L55:
                return Type.FILE;
            L56:
                return Type.POST;
            L30:
                return Type.UNKNOWN;
            }
        }

        @JvmStatic
        public static final Type fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("POST", 1, 2);
            POST = r1;
            Type r3 = new Type("FILE", 2, 3);
            FILE = r3;
            Type r6 = new Type("TEXT", 3, 4);
            TEXT = r6;
            Type r8 = new Type("IMAGE", 4, 5);
            IMAGE = r8;
            Type r10 = new Type("SYSTEM", 5, 6);
            SYSTEM = r10;
            Type r12 = new Type("AUDIO", 6, 7);
            AUDIO = r12;
            Type r14 = new Type("EMAIL", 7, 8);
            EMAIL = r14;
            Type r13 = new Type("SHARE_GROUP_CHAT", 8, 9);
            SHARE_GROUP_CHAT = r13;
            Type r15 = new Type("STICKER", 9, 10);
            STICKER = r15;
            Type r11 = new Type("MERGE_FORWARD", 10, 11);
            MERGE_FORWARD = r11;
            Type r9 = new Type("CALENDAR", 11, 12);
            CALENDAR = r9;
            Type r7 = new Type("CARD", 12, 13);
            CARD = r7;
            Type r4 = new Type("MEDIA", 13, 15);
            MEDIA = r4;
            Type r2 = new Type("SHARE_CALENDAR_EVENT", 14, 16);
            SHARE_CALENDAR_EVENT = r2;
            Type r5 = new Type("HONGBAO", 15, 17);
            HONGBAO = r5;
            Type r16 = new Type("GENERAL_CALENDAR", 16, 18);
            GENERAL_CALENDAR = r16;
            Type r17 = new Type("VIDEO_CHAT", 17, 19);
            VIDEO_CHAT = r17;
            Type r19 = new Type("LOCATION", 18, 20);
            LOCATION = r19;
            Type r20 = new Type("COMMERCIALIZED_HONGBAO", 19, 22);
            COMMERCIALIZED_HONGBAO = r20;
            Type r21 = new Type("SHARE_USER_CARD", 20, 23);
            SHARE_USER_CARD = r21;
            Type r22 = new Type("TODO", 21, 24);
            TODO = r22;
            Type r23 = new Type("FOLDER", 22, 25);
            FOLDER = r23;
            Type r24 = new Type("DIAGNOSE", 23, 26);
            DIAGNOSE = r24;
            Type r25 = new Type("VOTE", 24, 27);
            VOTE = r25;
            Type r26 = new Type("DOUBAO", 25, 29);
            DOUBAO = r26;
            Type[] r27 = {r0, r1, r3, r6, r8, r10, r12, r14, r13, r15, r11, r9, r7, r4, r2, r5, r16, r17, r19, r20, r21, r22, r23, r24, r25, r26};
            a = r27;
            b = EnumEntriesKt.enumEntries(r27);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2, r0);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Message$Version;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Message$Version$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Message$Version$Builder;Lokio/ByteString;)V", CardActionService.CONTENT_VERSION, "", "getContent_version", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Version extends com.lark.wire.Message<Version, a> {
        public static final ProtoAdapter<Version> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Integer content_version;

        public static final class a extends com.lark.wire.Message.a<Version, a> {
            public Integer d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Version(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Version> {
            @Override // com.lark.wire.ProtoAdapter
            public final Version c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L10;
                if (r3 == 1) goto L7;
                r6.j(r3);
                goto L3
            L7:
                r0.d = (Integer) ProtoAdapter.h.c(r6);
                goto L3
            L10:
                return new Version(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Version r4) {
                Version r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ProtoAdapter.h.l(1, r5.getContent_version());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Version r5) {
                Version r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.h.i(r4, 1, r6.getContent_version());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, Version r4) {
                Version r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ProtoAdapter.h.j(r3, 1, r5.getContent_version());
            }

            public b(FieldEncoding r7, KClass<Version> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Message.Version", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Version(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Version.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.content_version;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Version.class).getSimpleName() + '@' + hashCode();
        }

        public final Integer getContent_version() {
            return this.content_version;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Version(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.content_version = r2.d;
        }

        public /* synthetic */ Version(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<Message, a> {
        public String A;
        public Boolean A0;
        public Boolean B;
        public FileDeletedStatus B0;
        public Boolean C;
        public Integer C0;
        public Boolean D;
        public String D0;
        public Integer E;
        public Boolean E0;
        public List<String> F;
        public AnonymousInfo F0;
        public String G;
        public Boolean G0;
        public String H;
        public ThreadMessageType H0;
        public Boolean I;
        public Long I0;
        public Boolean J;
        public Map<String, String> J0;
        public Boolean K;
        public Boolean K0;
        public FromType L;
        public Integer L0;
        public String M;
        public Long M0;
        public List<String> N;
        public String N0;
        public List<String> O;
        public MessageDLPState O0;
        public Channel P;
        public List<String> P0;
        public Boolean Q;
        public I18nInfo Q0;
        public Integer R;
        public Long R0;
        public Long S;
        public Version S0;
        public Integer T;
        public String T0;
        public SourceType U;
        public ChatDisplayModeSetting U0;
        public String V;
        public Boolean V0;
        public String W;
        public Boolean W0;
        public String X;
        public DisabledAction X0;
        public RecallerIdentity Y;
        public Boolean Y0;
        public Pin Z;
        public Boolean Z0;
        public Integer a0;
        public SecurityESCReviewExtra a1;
        public Boolean b0;
        public StreamStatus b1;
        public Boolean c0;
        public Integer c1;
        public String d;
        public Boolean d0;
        public Long d1;
        public Type e;
        public List<String> e0;
        public String e1;
        public String f;
        public Integer f0;
        public AIMessageLikeFeedbackStatus f1;
        public String g;
        public Integer g0;
        public AIMessageType g1;
        public Long h;
        public List<String> h0;
        public Long h1;
        public Long i;
        public Boolean i0;
        public SyncToChatMessageType i1;
        public String j;
        public String j0;
        public Long j1;
        public Content k;
        public Boolean k0;
        public Boolean k1;
        public List<Reaction> l;
        public Boolean l0;
        public PartialReplyInfo l1;
        public Integer m;
        public Integer m0;
        public Boolean m1;
        public String n;
        public Integer n0;
        public AuthorizedSource n1;
        public Boolean o;
        public MessageSensitivity o0;
        public Boolean o1;
        public Boolean p;
        public String p0;
        public AIInfo p1;
        public Boolean q;
        public Boolean q0;
        public AIReplyEntryInfo q1;
        public Integer r;
        public Boolean r0;
        public CardInfo r1;
        public Integer s;
        public TranslateMessageDisplayRule s0;
        public AIReply s1;
        public String t;
        public Boolean t0;
        public COTContent t1;
        public Boolean u;
        public String u0;
        public String v;
        public Boolean v0;
        public String w;
        public Boolean w0;
        public String x;
        public Boolean x0;
        public Boolean y;
        public Map<String, ImageTranslationAbility> y0;
        public String z;
        public Boolean z0;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new Message(this, c(), null);
        }

        public a() {
            this.l = CollectionsKt.emptyList();
            this.F = CollectionsKt.emptyList();
            this.N = CollectionsKt.emptyList();
            this.O = CollectionsKt.emptyList();
            this.e0 = CollectionsKt.emptyList();
            this.h0 = CollectionsKt.emptyList();
            this.y0 = MapsKt.emptyMap();
            this.J0 = MapsKt.emptyMap();
            this.P0 = CollectionsKt.emptyList();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ Message(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Deprecated(message = "static_resource_message_recalled is deprecated")
    public static /* synthetic */ void getStatic_resource_message_recalled$annotations() {
    }

    @Deprecated(message = "unread_chatter_ids is deprecated")
    public static /* synthetic */ void getUnread_chatter_ids$annotations() {
    }

    static {
        Companion = new b();
        DEFAULT_FROM_TYPE = FromType.UNKNOWN_FROM_TYPE;
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(Message.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new Message$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.type;
        r0.f = this.chat_id;
        r0.g = this.thread_id;
        r0.h = Long.valueOf(this.create_time);
        r0.i = Long.valueOf(this.update_time);
        r0.j = this.root_id;
        r0.k = this.content;
        r0.l = this.reactions;
        r0.m = Integer.valueOf(this.unread_count);
        r0.n = this.from_id;
        r0.o = this.should_notify;
        r0.p = this.is_recalled;
        r0.q = this.is_edited;
        r0.r = this.reply_count;
        r0.s = this.position;
        r0.t = this.cid;
        r0.u = this.me_read;
        r0.v = this.reminder_id;
        r0.w = this.parent_source_id;
        r0.x = this.root_source_id;
        r0.y = this.is_urgent;
        r0.z = this.urgent_id;
        r0.A = this.parent_id;
        r0.B = this.is_at_me;
        r0.C = this.is_at_all;
        r0.D = this.is_truncated;
        r0.E = this.read_count;
        r0.F = this.unread_chatter_ids;
        r0.G = this.text_draft_id;
        r0.H = this.post_draft_id;
        r0.I = this.is_file_deleted;
        r0.J = this.is_deleted;
        r0.K = this.is_abnormal;
        r0.L = this.from_type;
        r0.M = this.doc_key;
        r0.N = this.unack_urgent_chatter_ids;
        r0.O = this.ack_urgent_chatter_ids;
        r0.P = this.channel;
        r0.Q = this.is_visible;
        r0.R = this.burn_life;
        r0.S = this.burn_time;
        r0.T = this.thread_position;
        r0.U = this.source_type;
        r0.V = this.source_id;
        r0.W = this.translate_language;
        r0.X = this.recaller_id;
        r0.Y = this.recaller_identity;
        r0.Z = this.pin;
        r0.a0 = this.badge_count;
        r0.b0 = this.is_reeditable;
        r0.c0 = this.is_badged;
        r0.d0 = this.is_untranslateable;
        r0.e0 = this.read_at_chatter_ids;
        r0.f0 = this.thread_badge_count;
        r0.g0 = this.thread_reply_count;
        r0.h0 = this.at_out_chatter_ids;
        r0.i0 = this.is_burned;
        r0.j0 = this.message_language;
        r0.k0 = this.is_auto_translated_by_receiver;
        r0.l0 = this.is_no_trace_deleted;
        r0.m0 = this.origin_badge_count;
        r0.n0 = this.origin_thread_badge_count;
        r0.o0 = this.sensitivity;
        r0.p0 = this.crypto_token;
        r0.q0 = this.is_decrypto_fail;
        r0.r0 = this.is_secret_chat_decrypted_failed;
        r0.s0 = this.translate_message_display_rule;
        r0.t0 = this.is_manual_translated;
        r0.u0 = this.original_sender_id;
        r0.v0 = this.forward_from_friend;
        r0.w0 = this.static_resource_message_recalled;
        r0.x0 = this.is_crypto_intermediate;
        r0.y0 = this.image_translation_ability;
        r0.z0 = this.is_special_focus;
        r0.A0 = this.is_include_doc_url;
        r0.B0 = this.file_deleted_status;
        r0.C0 = this.character_length;
        r0.D0 = this.msg_thread_draft_id;
        r0.E0 = this.sync_dependency;
        r0.F0 = this.anonymous_info;
        r0.G0 = this.is_flag;
        r0.H0 = this.thread_message_type;
        r0.I0 = this.create_time_ms;
        r0.J0 = this.i18n_content_language;
        r0.K0 = this.disable_search;
        r0.L0 = this.edit_version;
        r0.M0 = this.edit_time_ms;
        r0.N0 = this.edit_draft_id;
        r0.O0 = this.dlp_state;
        r0.P0 = this.message_languages;
        r0.Q0 = this.i18n_info;
        r0.R0 = this.fold_id;
        r0.S0 = this.version;
        r0.T0 = this.schedule_message_draft_id;
        r0.U0 = this.in_chat_display_mode;
        r0.V0 = this.is_restricted;
        r0.W0 = this.set_grey;
        r0.X0 = this.disabled_action;
        r0.Y0 = this.is_on_time_del;
        r0.Z0 = this.is_cleaned;
        r0.a1 = this.security_extra;
        r0.b1 = this.stream_status;
        r0.c1 = this.stream_sequence_id;
        r0.d1 = this.ai_chat_mode_id;
        r0.e1 = this.ai_answer_raw_data;
        r0.f1 = this.ai_message_like_feedback_status;
        r0.g1 = this.ai_message_type;
        r0.h1 = this.sync_to_chat_thread_root_id;
        r0.i1 = this.sync_to_chat_message_type;
        r0.j1 = this.sync_to_chat_related_message_id;
        r0.k1 = this.can_show_ai_progress;
        r0.l1 = this.partial_reply_info;
        r0.m1 = this.is_ai_session_first_msg;
        r0.n1 = this.authorized_source;
        r0.o1 = this.has_follow_up;
        r0.p1 = this.ai_info;
        r0.q1 = this.ai_reply_entry_info;
        r0.r1 = this.card_info;
        r0.s1 = this.smart_ai_reply;
        r0.t1 = this.cot_content;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(Message.class).getSimpleName() + '@' + hashCode();
    }

    public final List<String> getAck_urgent_chatter_ids() {
        return this.ack_urgent_chatter_ids;
    }

    public final String getAi_answer_raw_data() {
        return this.ai_answer_raw_data;
    }

    public final Long getAi_chat_mode_id() {
        return this.ai_chat_mode_id;
    }

    public final AIInfo getAi_info() {
        return this.ai_info;
    }

    public final AIMessageLikeFeedbackStatus getAi_message_like_feedback_status() {
        return this.ai_message_like_feedback_status;
    }

    public final AIMessageType getAi_message_type() {
        return this.ai_message_type;
    }

    public final AIReplyEntryInfo getAi_reply_entry_info() {
        return this.ai_reply_entry_info;
    }

    public final AnonymousInfo getAnonymous_info() {
        return this.anonymous_info;
    }

    public final List<String> getAt_out_chatter_ids() {
        return this.at_out_chatter_ids;
    }

    public final AuthorizedSource getAuthorized_source() {
        return this.authorized_source;
    }

    public final Integer getBadge_count() {
        return this.badge_count;
    }

    public final Integer getBurn_life() {
        return this.burn_life;
    }

    public final Long getBurn_time() {
        return this.burn_time;
    }

    public final Boolean getCan_show_ai_progress() {
        return this.can_show_ai_progress;
    }

    public final CardInfo getCard_info() {
        return this.card_info;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Integer getCharacter_length() {
        return this.character_length;
    }

    public final String getChat_id() {
        return this.chat_id;
    }

    public final String getCid() {
        return this.cid;
    }

    public final Content getContent() {
        return this.content;
    }

    public final COTContent getCot_content() {
        return this.cot_content;
    }

    public final long getCreate_time() {
        return this.create_time;
    }

    public final Long getCreate_time_ms() {
        return this.create_time_ms;
    }

    public final String getCrypto_token() {
        return this.crypto_token;
    }

    public final Boolean getDisable_search() {
        return this.disable_search;
    }

    public final DisabledAction getDisabled_action() {
        return this.disabled_action;
    }

    public final MessageDLPState getDlp_state() {
        return this.dlp_state;
    }

    public final String getDoc_key() {
        return this.doc_key;
    }

    public final String getEdit_draft_id() {
        return this.edit_draft_id;
    }

    public final Long getEdit_time_ms() {
        return this.edit_time_ms;
    }

    public final Integer getEdit_version() {
        return this.edit_version;
    }

    public final FileDeletedStatus getFile_deleted_status() {
        return this.file_deleted_status;
    }

    public final Long getFold_id() {
        return this.fold_id;
    }

    public final Boolean getForward_from_friend() {
        return this.forward_from_friend;
    }

    public final String getFrom_id() {
        return this.from_id;
    }

    public final FromType getFrom_type() {
        return this.from_type;
    }

    public final Boolean getHas_follow_up() {
        return this.has_follow_up;
    }

    public final Map<String, String> getI18n_content_language() {
        return this.i18n_content_language;
    }

    public final I18nInfo getI18n_info() {
        return this.i18n_info;
    }

    public final String getId() {
        return this.id;
    }

    public final Map<String, ImageTranslationAbility> getImage_translation_ability() {
        return this.image_translation_ability;
    }

    public final ChatDisplayModeSetting getIn_chat_display_mode() {
        return this.in_chat_display_mode;
    }

    public final Boolean getMe_read() {
        return this.me_read;
    }

    public final String getMessage_language() {
        return this.message_language;
    }

    public final List<String> getMessage_languages() {
        return this.message_languages;
    }

    public final String getMsg_thread_draft_id() {
        return this.msg_thread_draft_id;
    }

    public final Integer getOrigin_badge_count() {
        return this.origin_badge_count;
    }

    public final Integer getOrigin_thread_badge_count() {
        return this.origin_thread_badge_count;
    }

    public final String getOriginal_sender_id() {
        return this.original_sender_id;
    }

    public final String getParent_id() {
        return this.parent_id;
    }

    public final String getParent_source_id() {
        return this.parent_source_id;
    }

    public final PartialReplyInfo getPartial_reply_info() {
        return this.partial_reply_info;
    }

    public final Pin getPin() {
        return this.pin;
    }

    public final Integer getPosition() {
        return this.position;
    }

    public final String getPost_draft_id() {
        return this.post_draft_id;
    }

    public final List<Reaction> getReactions() {
        return this.reactions;
    }

    public final List<String> getRead_at_chatter_ids() {
        return this.read_at_chatter_ids;
    }

    public final Integer getRead_count() {
        return this.read_count;
    }

    public final String getRecaller_id() {
        return this.recaller_id;
    }

    public final RecallerIdentity getRecaller_identity() {
        return this.recaller_identity;
    }

    public final String getReminder_id() {
        return this.reminder_id;
    }

    public final Integer getReply_count() {
        return this.reply_count;
    }

    public final String getRoot_id() {
        return this.root_id;
    }

    public final String getRoot_source_id() {
        return this.root_source_id;
    }

    public final String getSchedule_message_draft_id() {
        return this.schedule_message_draft_id;
    }

    public final SecurityESCReviewExtra getSecurity_extra() {
        return this.security_extra;
    }

    public final MessageSensitivity getSensitivity() {
        return this.sensitivity;
    }

    public final Boolean getSet_grey() {
        return this.set_grey;
    }

    public final Boolean getShould_notify() {
        return this.should_notify;
    }

    public final AIReply getSmart_ai_reply() {
        return this.smart_ai_reply;
    }

    public final String getSource_id() {
        return this.source_id;
    }

    public final SourceType getSource_type() {
        return this.source_type;
    }

    public final Boolean getStatic_resource_message_recalled() {
        return this.static_resource_message_recalled;
    }

    public final Integer getStream_sequence_id() {
        return this.stream_sequence_id;
    }

    public final StreamStatus getStream_status() {
        return this.stream_status;
    }

    public final Boolean getSync_dependency() {
        return this.sync_dependency;
    }

    public final SyncToChatMessageType getSync_to_chat_message_type() {
        return this.sync_to_chat_message_type;
    }

    public final Long getSync_to_chat_related_message_id() {
        return this.sync_to_chat_related_message_id;
    }

    public final Long getSync_to_chat_thread_root_id() {
        return this.sync_to_chat_thread_root_id;
    }

    public final String getText_draft_id() {
        return this.text_draft_id;
    }

    public final Integer getThread_badge_count() {
        return this.thread_badge_count;
    }

    public final String getThread_id() {
        return this.thread_id;
    }

    public final ThreadMessageType getThread_message_type() {
        return this.thread_message_type;
    }

    public final Integer getThread_position() {
        return this.thread_position;
    }

    public final Integer getThread_reply_count() {
        return this.thread_reply_count;
    }

    public final String getTranslate_language() {
        return this.translate_language;
    }

    public final TranslateMessageDisplayRule getTranslate_message_display_rule() {
        return this.translate_message_display_rule;
    }

    public final Type getType() {
        return this.type;
    }

    public final List<String> getUnack_urgent_chatter_ids() {
        return this.unack_urgent_chatter_ids;
    }

    public final List<String> getUnread_chatter_ids() {
        return this.unread_chatter_ids;
    }

    public final int getUnread_count() {
        return this.unread_count;
    }

    public final long getUpdate_time() {
        return this.update_time;
    }

    public final String getUrgent_id() {
        return this.urgent_id;
    }

    public final Version getVersion() {
        return this.version;
    }

    public final Boolean is_abnormal() {
        return this.is_abnormal;
    }

    public final Boolean is_ai_session_first_msg() {
        return this.is_ai_session_first_msg;
    }

    public final Boolean is_at_all() {
        return this.is_at_all;
    }

    public final Boolean is_at_me() {
        return this.is_at_me;
    }

    public final Boolean is_auto_translated_by_receiver() {
        return this.is_auto_translated_by_receiver;
    }

    public final Boolean is_badged() {
        return this.is_badged;
    }

    public final Boolean is_burned() {
        return this.is_burned;
    }

    public final Boolean is_cleaned() {
        return this.is_cleaned;
    }

    public final Boolean is_crypto_intermediate() {
        return this.is_crypto_intermediate;
    }

    public final Boolean is_decrypto_fail() {
        return this.is_decrypto_fail;
    }

    public final Boolean is_deleted() {
        return this.is_deleted;
    }

    public final Boolean is_edited() {
        return this.is_edited;
    }

    public final Boolean is_file_deleted() {
        return this.is_file_deleted;
    }

    public final Boolean is_flag() {
        return this.is_flag;
    }

    public final Boolean is_include_doc_url() {
        return this.is_include_doc_url;
    }

    public final Boolean is_manual_translated() {
        return this.is_manual_translated;
    }

    public final Boolean is_no_trace_deleted() {
        return this.is_no_trace_deleted;
    }

    public final Boolean is_on_time_del() {
        return this.is_on_time_del;
    }

    public final Boolean is_recalled() {
        return this.is_recalled;
    }

    public final Boolean is_reeditable() {
        return this.is_reeditable;
    }

    public final Boolean is_restricted() {
        return this.is_restricted;
    }

    public final Boolean is_secret_chat_decrypted_failed() {
        return this.is_secret_chat_decrypted_failed;
    }

    public final Boolean is_special_focus() {
        return this.is_special_focus;
    }

    public final Boolean is_truncated() {
        return this.is_truncated;
    }

    public final Boolean is_untranslateable() {
        return this.is_untranslateable;
    }

    public final Boolean is_urgent() {
        return this.is_urgent;
    }

    public final Boolean is_visible() {
        return this.is_visible;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public Message(a r3, ByteString r4) {
        super(ADAPTER, r4);
        String r5 = r3.d;
        Intrinsics.checkNotNull(r5);
        this.id = r5;
        Type r6 = r3.e;
        Intrinsics.checkNotNull(r6);
        this.type = r6;
        String r7 = r3.f;
        Intrinsics.checkNotNull(r7);
        this.chat_id = r7;
        this.thread_id = r3.g;
        Long r8 = r3.h;
        Intrinsics.checkNotNull(r8);
        this.create_time = r8.longValue();
        Long r9 = r3.i;
        Intrinsics.checkNotNull(r9);
        this.update_time = r9.longValue();
        String r10 = r3.j;
        Intrinsics.checkNotNull(r10);
        this.root_id = r10;
        Content r11 = r3.k;
        Intrinsics.checkNotNull(r11);
        this.content = r11;
        this.reactions = com.lark.wire.internal.a.c("reactions", r3.l);
        Integer r12 = r3.m;
        Intrinsics.checkNotNull(r12);
        this.unread_count = r12.intValue();
        this.from_id = r3.n;
        this.should_notify = r3.o;
        this.is_recalled = r3.p;
        this.is_edited = r3.q;
        this.reply_count = r3.r;
        this.position = r3.s;
        this.cid = r3.t;
        this.me_read = r3.u;
        this.reminder_id = r3.v;
        this.parent_source_id = r3.w;
        this.root_source_id = r3.x;
        this.is_urgent = r3.y;
        this.urgent_id = r3.z;
        this.parent_id = r3.A;
        this.is_at_me = r3.B;
        this.is_at_all = r3.C;
        this.is_truncated = r3.D;
        this.read_count = r3.E;
        this.unread_chatter_ids = com.lark.wire.internal.a.c("unread_chatter_ids", r3.F);
        this.text_draft_id = r3.G;
        this.post_draft_id = r3.H;
        this.is_file_deleted = r3.I;
        this.is_deleted = r3.J;
        this.is_abnormal = r3.K;
        this.from_type = r3.L;
        this.doc_key = r3.M;
        this.unack_urgent_chatter_ids = com.lark.wire.internal.a.c("unack_urgent_chatter_ids", r3.N);
        this.ack_urgent_chatter_ids = com.lark.wire.internal.a.c("ack_urgent_chatter_ids", r3.O);
        this.channel = r3.P;
        this.is_visible = r3.Q;
        this.burn_life = r3.R;
        this.burn_time = r3.S;
        this.thread_position = r3.T;
        this.source_type = r3.U;
        this.source_id = r3.V;
        this.translate_language = r3.W;
        this.recaller_id = r3.X;
        this.recaller_identity = r3.Y;
        this.pin = r3.Z;
        this.badge_count = r3.a0;
        this.is_reeditable = r3.b0;
        this.is_badged = r3.c0;
        this.is_untranslateable = r3.d0;
        this.read_at_chatter_ids = com.lark.wire.internal.a.c("read_at_chatter_ids", r3.e0);
        this.thread_badge_count = r3.f0;
        this.thread_reply_count = r3.g0;
        this.at_out_chatter_ids = com.lark.wire.internal.a.c("at_out_chatter_ids", r3.h0);
        this.is_burned = r3.i0;
        this.message_language = r3.j0;
        this.is_auto_translated_by_receiver = r3.k0;
        this.is_no_trace_deleted = r3.l0;
        this.origin_badge_count = r3.m0;
        this.origin_thread_badge_count = r3.n0;
        this.sensitivity = r3.o0;
        this.crypto_token = r3.p0;
        this.is_decrypto_fail = r3.q0;
        this.is_secret_chat_decrypted_failed = r3.r0;
        this.translate_message_display_rule = r3.s0;
        this.is_manual_translated = r3.t0;
        this.original_sender_id = r3.u0;
        this.forward_from_friend = r3.v0;
        this.static_resource_message_recalled = r3.w0;
        this.is_crypto_intermediate = r3.x0;
        this.image_translation_ability = com.lark.wire.internal.a.d("image_translation_ability", r3.y0);
        this.is_special_focus = r3.z0;
        this.is_include_doc_url = r3.A0;
        this.file_deleted_status = r3.B0;
        this.character_length = r3.C0;
        this.msg_thread_draft_id = r3.D0;
        this.sync_dependency = r3.E0;
        this.anonymous_info = r3.F0;
        this.is_flag = r3.G0;
        this.thread_message_type = r3.H0;
        this.create_time_ms = r3.I0;
        this.i18n_content_language = com.lark.wire.internal.a.d("i18n_content_language", r3.J0);
        this.disable_search = r3.K0;
        this.edit_version = r3.L0;
        this.edit_time_ms = r3.M0;
        this.edit_draft_id = r3.N0;
        this.dlp_state = r3.O0;
        this.message_languages = com.lark.wire.internal.a.c("message_languages", r3.P0);
        this.i18n_info = r3.Q0;
        this.fold_id = r3.R0;
        this.version = r3.S0;
        this.schedule_message_draft_id = r3.T0;
        this.in_chat_display_mode = r3.U0;
        this.is_restricted = r3.V0;
        this.set_grey = r3.W0;
        this.disabled_action = r3.X0;
        this.is_on_time_del = r3.Y0;
        this.is_cleaned = r3.Z0;
        this.security_extra = r3.a1;
        this.stream_status = r3.b1;
        this.stream_sequence_id = r3.c1;
        this.ai_chat_mode_id = r3.d1;
        this.ai_answer_raw_data = r3.e1;
        this.ai_message_like_feedback_status = r3.f1;
        this.ai_message_type = r3.g1;
        this.sync_to_chat_thread_root_id = r3.h1;
        this.sync_to_chat_message_type = r3.i1;
        this.sync_to_chat_related_message_id = r3.j1;
        this.can_show_ai_progress = r3.k1;
        this.partial_reply_info = r3.l1;
        this.is_ai_session_first_msg = r3.m1;
        this.authorized_source = r3.n1;
        this.has_follow_up = r3.o1;
        this.ai_info = r3.p1;
        this.ai_reply_entry_info = r3.q1;
        this.card_info = r3.r1;
        this.smart_ai_reply = r3.s1;
        this.cot_content = r3.t1;
    }

    public /* synthetic */ Message(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
