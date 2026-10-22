package com.lark.kmp.pb.basic.v1;

import com.lark.kmp.pb.office_sdk.basic.DoubaoContent;
import com.lark.kmp.pb.vote.v1.VoteContent;
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
@Metadata(d1 = {"\u0000 \u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 ¿\u00022\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001: ¾\u0002¿\u0002À\u0002Á\u0002Â\u0002Ã\u0002Ä\u0002Å\u0002Æ\u0002Ç\u0002È\u0002É\u0002Ê\u0002Ë\u0002Ì\u0002Í\u0002B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010¼\u0002\u001a\u00020\u0002H\u0016J\t\u0010½\u0002\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0012\u0010\u0014R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000bR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000bR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000bR\u0015\u0010!\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\"\u0010\u0019R\u0013\u0010#\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u000bR\u0013\u0010%\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000bR\u0013\u0010'\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000bR\u001d\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0015\u0010-\u001a\u0004\u0018\u00010.¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u0013\u00102\u001a\u0004\u0018\u000103¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u00106\u001a\u0004\u0018\u000107¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010:\u001a\u0004\u0018\u00010;¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u001d\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020?0*¢\u0006\b\n\u0000\u001a\u0004\b@\u0010,R\u0015\u0010A\u001a\u0004\u0018\u00010.¢\u0006\n\n\u0002\u00101\u001a\u0004\bB\u00100R\u0013\u0010C\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u000bR\u001d\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020F0*¢\u0006\b\n\u0000\u001a\u0004\bG\u0010,R\u001d\u0010H\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020I0*¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010,R\u0015\u0010K\u001a\u0004\u0018\u00010.¢\u0006\n\n\u0002\u00101\u001a\u0004\bL\u00100R\u0013\u0010M\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\u000bR\u0015\u0010O\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\bP\u0010\u0014R\u0015\u0010Q\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\bR\u0010\u0019R\u0013\u0010S\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\u000bR\u0013\u0010U\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bV\u0010\u000bR\u0013\u0010W\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bX\u0010\u000bR\u0015\u0010Y\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\bY\u0010\u0014R\u0013\u0010Z\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\u000bR\u0015\u0010\\\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\\\u0010\u0014R\u0015\u0010]\u001a\u0004\u0018\u00010.¢\u0006\n\n\u0002\u00101\u001a\u0004\b^\u00100R\u0015\u0010_\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b_\u0010\u0014R\u001d\u0010`\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020a0*¢\u0006\b\n\u0000\u001a\u0004\bb\u0010,R\u0015\u0010c\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\bc\u0010\u0014R\u0013\u0010d\u001a\u0004\u0018\u00010e¢\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u0013\u0010h\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bi\u0010\u000bR\u0013\u0010j\u001a\u0004\u0018\u00010k¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0013\u0010n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bo\u0010\u000bR\u0015\u0010p\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\bp\u0010\u0014R\u0013\u0010q\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\br\u0010\u000bR\u0013\u0010s\u001a\u0004\u0018\u00010t¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR\u0013\u0010w\u001a\u0004\u0018\u00010x¢\u0006\b\n\u0000\u001a\u0004\by\u0010zR\u0013\u0010{\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b|\u0010\u000bR\u0013\u0010}\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b~\u0010\u000bR\u0014\u0010\u007f\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010\u000bR\u0017\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0013¢\u0006\u000b\n\u0002\u0010\u0015\u001a\u0005\b\u0081\u0001\u0010\u0014R\u0017\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0013¢\u0006\u000b\n\u0002\u0010\u0015\u001a\u0005\b\u0082\u0001\u0010\u0014R\u0015\u0010\u0083\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010\u000bR\u0017\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0013¢\u0006\u000b\n\u0002\u0010\u0015\u001a\u0005\b\u0085\u0001\u0010\u0014R\u001b\u0010\u0086\u0001\u001a\t\u0012\u0004\u0012\u00020\t0\u0087\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0017\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0017\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0017\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0017¢\u0006\u000b\n\u0002\u0010\u001a\u001a\u0005\b\u0093\u0001\u0010\u0019R\u0017\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0017¢\u0006\u000b\n\u0002\u0010\u001a\u001a\u0005\b\u0095\u0001\u0010\u0019R\u0017\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0017\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001c\u0010\u009e\u0001\u001a\n\u0012\u0005\u0012\u00030\u009f\u00010\u0087\u0001¢\u0006\n\n\u0000\u001a\u0006\b \u0001\u0010\u0089\u0001R\u001c\u0010¡\u0001\u001a\n\u0012\u0005\u0012\u00030\u009f\u00010\u0087\u0001¢\u0006\n\n\u0000\u001a\u0006\b¢\u0001\u0010\u0089\u0001R\u0015\u0010£\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b¤\u0001\u0010\u000bR\u0015\u0010¥\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b¦\u0001\u0010\u000bR\u0017\u0010§\u0001\u001a\u0004\u0018\u00010\u0017¢\u0006\u000b\n\u0002\u0010\u001a\u001a\u0005\b¨\u0001\u0010\u0019R\u0017\u0010©\u0001\u001a\u0004\u0018\u00010.¢\u0006\u000b\n\u0002\u00101\u001a\u0005\bª\u0001\u00100R\u0017\u0010«\u0001\u001a\u0004\u0018\u00010.¢\u0006\u000b\n\u0002\u00101\u001a\u0005\b¬\u0001\u00100R\u0017\u0010\u00ad\u0001\u001a\u0004\u0018\u00010.¢\u0006\u000b\n\u0002\u00101\u001a\u0005\b®\u0001\u00100R\u0015\u0010¯\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b°\u0001\u0010\u000bR\u0017\u0010±\u0001\u001a\u0005\u0018\u00010²\u0001¢\u0006\n\n\u0000\u001a\u0006\b³\u0001\u0010´\u0001R\u0017\u0010µ\u0001\u001a\u0005\u0018\u00010¶\u0001¢\u0006\n\n\u0000\u001a\u0006\b·\u0001\u0010¸\u0001R\u001c\u0010¹\u0001\u001a\n\u0012\u0005\u0012\u00030º\u00010\u0087\u0001¢\u0006\n\n\u0000\u001a\u0006\b»\u0001\u0010\u0089\u0001R\u0017\u0010¼\u0001\u001a\u0005\u0018\u00010½\u0001¢\u0006\n\n\u0000\u001a\u0006\b¾\u0001\u0010¿\u0001R\u0017\u0010À\u0001\u001a\u0005\u0018\u00010Á\u0001¢\u0006\n\n\u0000\u001a\u0006\bÂ\u0001\u0010Ã\u0001R\u0017\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u0001¢\u0006\n\n\u0000\u001a\u0006\bÆ\u0001\u0010Ç\u0001R\u0017\u0010È\u0001\u001a\u0005\u0018\u00010É\u0001¢\u0006\n\n\u0000\u001a\u0006\bÊ\u0001\u0010Ë\u0001R\u001c\u0010Ì\u0001\u001a\n\u0012\u0005\u0012\u00030Í\u00010\u0087\u0001¢\u0006\n\n\u0000\u001a\u0006\bÎ\u0001\u0010\u0089\u0001R\u0017\u0010Ï\u0001\u001a\u0005\u0018\u00010Ð\u0001¢\u0006\n\n\u0000\u001a\u0006\bÑ\u0001\u0010Ò\u0001R\u0017\u0010Ó\u0001\u001a\u0005\u0018\u00010Ô\u0001¢\u0006\n\n\u0000\u001a\u0006\bÕ\u0001\u0010Ö\u0001R\u0015\u0010×\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bØ\u0001\u0010\u000bR\u0015\u0010Ù\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bÚ\u0001\u0010\u000bR\u0015\u0010Û\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bÜ\u0001\u0010\u000bR\u0015\u0010Ý\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bÞ\u0001\u0010\u000bR\u0015\u0010ß\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bà\u0001\u0010\u000bR\u0015\u0010á\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bâ\u0001\u0010\u000bR\u0015\u0010ã\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bä\u0001\u0010\u000bR\u0015\u0010å\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bæ\u0001\u0010\u000bR\u0015\u0010ç\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bè\u0001\u0010\u000bR\u0015\u0010é\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bê\u0001\u0010\u000bR\u0015\u0010ë\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\bì\u0001\u0010\u000bR\u0017\u0010í\u0001\u001a\u0004\u0018\u00010\u0013¢\u0006\u000b\n\u0002\u0010\u0015\u001a\u0005\bí\u0001\u0010\u0014R\u0017\u0010î\u0001\u001a\u0005\u0018\u00010ï\u0001¢\u0006\n\n\u0000\u001a\u0006\bð\u0001\u0010ñ\u0001R\u0017\u0010ò\u0001\u001a\u0005\u0018\u00010ó\u0001¢\u0006\n\n\u0000\u001a\u0006\bô\u0001\u0010õ\u0001R\u0017\u0010ö\u0001\u001a\u0005\u0018\u00010÷\u0001¢\u0006\n\n\u0000\u001a\u0006\bø\u0001\u0010ù\u0001R\u0017\u0010ú\u0001\u001a\u0005\u0018\u00010û\u0001¢\u0006\n\n\u0000\u001a\u0006\bü\u0001\u0010ý\u0001R\u0017\u0010þ\u0001\u001a\u0005\u0018\u00010ÿ\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0080\u0002\u0010\u0081\u0002R\u001b\u0010\u0082\u0002\u001a\t\u0012\u0004\u0012\u00020\t0\u0087\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0083\u0002\u0010\u0089\u0001R\u0015\u0010\u0084\u0002\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b\u0085\u0002\u0010\u000bR\u0017\u0010\u0086\u0002\u001a\u0005\u0018\u00010\u0087\u0002¢\u0006\n\n\u0000\u001a\u0006\b\u0088\u0002\u0010\u0089\u0002R\u0015\u0010\u008a\u0002\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b\u008b\u0002\u0010\u000bR\u0015\u0010\u008c\u0002\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b\u008d\u0002\u0010\u000bR\u0017\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u008f\u0002¢\u0006\n\n\u0000\u001a\u0006\b\u0090\u0002\u0010\u0091\u0002R\u0015\u0010\u0092\u0002\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b\u0093\u0002\u0010\u000bR\u0017\u0010\u0094\u0002\u001a\u0005\u0018\u00010\u0095\u0002¢\u0006\n\n\u0000\u001a\u0006\b\u0096\u0002\u0010\u0097\u0002R \u0010\u0098\u0002\u001a\u000f\u0012\u0004\u0012\u00020\t\u0012\u0005\u0012\u00030\u0099\u00020*¢\u0006\t\n\u0000\u001a\u0005\b\u009a\u0002\u0010,R\u0017\u0010\u009b\u0002\u001a\u0005\u0018\u00010\u009c\u0002¢\u0006\n\n\u0000\u001a\u0006\b\u009d\u0002\u0010\u009e\u0002R\u0017\u0010\u009f\u0002\u001a\u0005\u0018\u00010 \u0002¢\u0006\n\n\u0000\u001a\u0006\b¡\u0002\u0010¢\u0002R\u0017\u0010£\u0002\u001a\u0005\u0018\u00010¤\u0002¢\u0006\n\n\u0000\u001a\u0006\b¥\u0002\u0010¦\u0002R\u0015\u0010§\u0002\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b¨\u0002\u0010\u000bR\u001c\u0010©\u0002\u001a\n\u0012\u0005\u0012\u00030ª\u00020\u0087\u0001¢\u0006\n\n\u0000\u001a\u0006\b«\u0002\u0010\u0089\u0001R$\u0010¬\u0002\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u0013\n\u0002\u0010\u0015\u0012\u0006\b\u00ad\u0002\u0010®\u0002\u001a\u0005\b¯\u0002\u0010\u0014R \u0010°\u0002\u001a\u000f\u0012\u0004\u0012\u00020\t\u0012\u0005\u0012\u00030±\u00020*¢\u0006\t\n\u0000\u001a\u0005\b²\u0002\u0010,R\u0017\u0010³\u0002\u001a\u0005\u0018\u00010´\u0002¢\u0006\n\n\u0000\u001a\u0006\bµ\u0002\u0010¶\u0002R\u0017\u0010·\u0002\u001a\u0004\u0018\u00010\u0013¢\u0006\u000b\n\u0002\u0010\u0015\u001a\u0005\b·\u0002\u0010\u0014R\u0017\u0010¸\u0002\u001a\u0005\u0018\u00010¹\u0002¢\u0006\n\n\u0000\u001a\u0006\bº\u0002\u0010»\u0002¨\u0006Î\u0002"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Content;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Content$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Content$Builder;Lokio/ByteString;)V", "title", "", "getTitle", "()Ljava/lang/String;", "text", "getText", "image", "Lcom/lark/kmp/pb/basic/v1/ImageSet;", "getImage", "()Lcom/lark/kmp/pb/basic/v1/ImageSet;", "is_origin_source", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "origin_size", "", "getOrigin_size", "()Ljava/lang/Long;", "Ljava/lang/Long;", "image_upload_id", "getImage_upload_id", "key", "getKey", "name", "getName", "size", "getSize", "mime", "getMime", "file_upload_id", "getFile_upload_id", "template", "getTemplate", "values", "", "getValues", "()Ljava/util/Map;", "duration", "", "getDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "deprecated", "Lcom/lark/kmp/pb/basic/v1/FileType;", "getDeprecated", "()Lcom/lark/kmp/pb/basic/v1/FileType;", "system_type", "Lcom/lark/kmp/pb/basic/v1/Content$SystemType;", "getSystem_type", "()Lcom/lark/kmp/pb/basic/v1/Content$SystemType;", "event", "Lcom/lark/kmp/pb/basic/v1/EmailSystemEvent;", "getEvent", "()Lcom/lark/kmp/pb/basic/v1/EmailSystemEvent;", "content_values", "Lcom/lark/kmp/pb/basic/v1/Content$ContentValue;", "getContent_values", "system_type_value", "getSystem_type_value", "i18n_title_key", "getI18n_title_key", "system_content_values", "Lcom/lark/kmp/pb/basic/v1/Content$SystemContentValue;", "getSystem_content_values", "item_actions", "Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction;", "getItem_actions", "system_message_version", "getSystem_message_version", "voice2text", "getVoice2text", "hide_voice2text", "getHide_voice2text", "origin_sender_id", "getOrigin_sender_id", "local_upload_id", "getLocal_upload_id", "origin_tos_key", "getOrigin_tos_key", "origin_sender_name", "getOrigin_sender_name", "is_friend", "origin_sender_id_str", "getOrigin_sender_id_str", "is_audio_recognize_finish", "audio2text_start_time", "getAudio2text_start_time", "is_audio_with_text", "url_preview_hang_point_map", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewHangPoint;", "getUrl_preview_hang_point_map", "is_group_announcement", "doc_entity", "Lcom/lark/kmp/pb/basic/v1/DocEntity;", "getDoc_entity", "()Lcom/lark/kmp/pb/basic/v1/DocEntity;", "file_path", "getFile_path", "file_source", "Lcom/lark/kmp/pb/basic/v1/File$Source;", "getFile_source", "()Lcom/lark/kmp/pb/basic/v1/File$Source;", "namespace", "getNamespace", "is_in_my_nut_store", "cache_file_path", "getCache_file_path", "lan_trans_status", "Lcom/lark/kmp/pb/basic/v1/TransStatus;", "getLan_trans_status", "()Lcom/lark/kmp/pb/basic/v1/TransStatus;", "trans_identity", "Lcom/lark/kmp/pb/basic/v1/TransIdentity;", "getTrans_identity", "()Lcom/lark/kmp/pb/basic/v1/TransIdentity;", "lan_trans_status_text", "getLan_trans_status_text", "lan_sender_device_id", "getLan_sender_device_id", "lan_receiver_device_id", "getLan_receiver_device_id", "is_try_use_lan_trans", "is_able_lan_trans", "file_uri", "getFile_uri", "is_encrypted", "risk_object_keys", "", "getRisk_object_keys", "()Ljava/util/List;", "file_ability", "Lcom/lark/kmp/pb/basic/v1/Content$FileAbility;", "getFile_ability", "()Lcom/lark/kmp/pb/basic/v1/Content$FileAbility;", "file_permission", "Lcom/lark/kmp/pb/basic/v1/Content$FilePermission;", "getFile_permission", "()Lcom/lark/kmp/pb/basic/v1/Content$FilePermission;", "file_last_update_user_id", "getFile_last_update_user_id", "file_last_update_time_ms", "getFile_last_update_time_ms", "local_status", "Lcom/lark/kmp/pb/basic/v1/Content$LocalStatus;", "getLocal_status", "()Lcom/lark/kmp/pb/basic/v1/Content$LocalStatus;", "file_preview_stage", "Lcom/lark/kmp/pb/basic/v1/FilePreviewStage;", "getFile_preview_stage", "()Lcom/lark/kmp/pb/basic/v1/FilePreviewStage;", "attachments", "Lcom/lark/kmp/pb/basic/v1/File;", "getAttachments", "file_attachments", "getFile_attachments", "share_chat_id", "getShare_chat_id", "join_token", "getJoin_token", "expire_time", "getExpire_time", "share_chat_last_state", "getShare_chat_last_state", "width", "getWidth", "height", "getHeight", "crypto_token", "getCrypto_token", "merge_forward_content", "Lcom/lark/kmp/pb/basic/v1/MergeForwardContent;", "getMerge_forward_content", "()Lcom/lark/kmp/pb/basic/v1/MergeForwardContent;", "transmit_info", "Lcom/lark/kmp/pb/basic/v1/Content$TransmitInfo;", "getTransmit_info", "()Lcom/lark/kmp/pb/basic/v1/Content$TransmitInfo;", "preview_urls", "Lcom/lark/kmp/pb/basic/v1/PreviewUrlContent;", "getPreview_urls", "rich_text", "Lcom/lark/kmp/pb/basic/v1/RichText;", "getRich_text", "()Lcom/lark/kmp/pb/basic/v1/RichText;", "calendar_content", "Lcom/lark/kmp/pb/basic/v1/CalendarContent;", "getCalendar_content", "()Lcom/lark/kmp/pb/basic/v1/CalendarContent;", "share_calendar_event_content", "Lcom/lark/kmp/pb/basic/v1/ShareCalendarEventContent;", "getShare_calendar_event_content", "()Lcom/lark/kmp/pb/basic/v1/ShareCalendarEventContent;", "general_calendar_content", "Lcom/lark/kmp/pb/basic/v1/GeneralCalendarContent;", "getGeneral_calendar_content", "()Lcom/lark/kmp/pb/basic/v1/GeneralCalendarContent;", "text_url_contents", "Lcom/lark/kmp/pb/basic/v1/TextUrlContent;", "getText_url_contents", "card_content", "Lcom/lark/kmp/pb/basic/v1/CardContent;", "getCard_content", "()Lcom/lark/kmp/pb/basic/v1/CardContent;", "location_content", "Lcom/lark/kmp/pb/basic/v1/LocationContent;", "getLocation_content", "()Lcom/lark/kmp/pb/basic/v1/LocationContent;", "e2ee_from_id", "getE2ee_from_id", "e2ee_to_id", "getE2ee_to_id", "trigger_id", "getTrigger_id", "vc_from_id", "getVc_from_id", "vc_to_id", "getVc_to_id", "vc_duration_time", "getVc_duration_time", "vc_meeting_id", "getVc_meeting_id", "vc_passcode", "getVc_passcode", "vc_feedback_status", "getVc_feedback_status", "vc_from_feedback_status", "getVc_from_feedback_status", "vc_to_feedback_status", "getVc_to_feedback_status", "is_voice_call", "media_content", "Lcom/lark/kmp/pb/basic/v1/MediaContent;", "getMedia_content", "()Lcom/lark/kmp/pb/basic/v1/MediaContent;", "hongbao_content", "Lcom/lark/kmp/pb/basic/v1/HongbaoContent;", "getHongbao_content", "()Lcom/lark/kmp/pb/basic/v1/HongbaoContent;", "hongbao_system_content", "Lcom/lark/kmp/pb/basic/v1/HongbaoSystemContent;", "getHongbao_system_content", "()Lcom/lark/kmp/pb/basic/v1/HongbaoSystemContent;", "system_extra_content", "Lcom/lark/kmp/pb/basic/v1/Content$SystemExtraContent;", "getSystem_extra_content", "()Lcom/lark/kmp/pb/basic/v1/Content$SystemExtraContent;", "videochat_content", "Lcom/lark/kmp/pb/basic/v1/VideoChatContent;", "getVideochat_content", "()Lcom/lark/kmp/pb/basic/v1/VideoChatContent;", "resource_urls", "getResource_urls", "fs_unit", "getFs_unit", "sticker_info", "Lcom/lark/kmp/pb/basic/v1/Content$StickerInfo;", "getSticker_info", "()Lcom/lark/kmp/pb/basic/v1/Content$StickerInfo;", "sticker_id", "getSticker_id", "sticker_set_id", "getSticker_set_id", "share_user_card_info", "Lcom/lark/kmp/pb/basic/v1/Content$ShareUserCardInfo;", "getShare_user_card_info", "()Lcom/lark/kmp/pb/basic/v1/Content$ShareUserCardInfo;", "share_chatter_id", "getShare_chatter_id", "abbreviation", "Lcom/lark/kmp/pb/basic/v1/Abbreviation;", "getAbbreviation", "()Lcom/lark/kmp/pb/basic/v1/Abbreviation;", "typed_element_refs", "Lcom/lark/kmp/pb/basic/v1/ElementRefs;", "getTyped_element_refs", "todo_operation_content", "Lcom/lark/kmp/pb/basic/v1/TodoOperationContent;", "getTodo_operation_content", "()Lcom/lark/kmp/pb/basic/v1/TodoOperationContent;", "lingo_option", "Lcom/lark/kmp/pb/basic/v1/LingoOption;", "getLingo_option", "()Lcom/lark/kmp/pb/basic/v1/LingoOption;", "vote_content", "Lcom/lark/kmp/pb/vote/v1/VoteContent;", "getVote_content", "()Lcom/lark/kmp/pb/vote/v1/VoteContent;", "folder_archive_key", "getFolder_archive_key", "content_references", "Lcom/lark/kmp/pb/basic/v1/Content$Reference;", "getContent_references", "include_cleaned_resources", "getInclude_cleaned_resources$annotations", "()V", "getInclude_cleaned_resources", "clean_resource_key_scene", "Lcom/lark/kmp/pb/basic/v1/ResourceCleanScene;", "getClean_resource_key_scene", "doubao_content", "Lcom/lark/kmp/pb/office_sdk/basic/DoubaoContent;", "getDoubao_content", "()Lcom/lark/kmp/pb/office_sdk/basic/DoubaoContent;", "is_unknown_doubao_content", "doubao_resource", "Lcom/lark/kmp/pb/basic/v1/DoubaoResource;", "getDoubao_resource", "()Lcom/lark/kmp/pb/basic/v1/DoubaoResource;", "newBuilder", "toString", "Builder", "Companion", "SystemType", "ContentValueType", "SystemMessageAction", "ContentValue", "SystemContentValue", "FileAbility", "FilePermission", "LocalStatus", "TransmitInfo", "SystemExtraContent", "NewTopicSystemMessageExtraContent", "StickerInfo", "ShareUserCardInfo", "Reference", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class Content extends com.lark.wire.Message<Content, a> {
    public static final ProtoAdapter<Content> ADAPTER = null;
    public static final b Companion = null;
    public static final String DEFAULT_CRYPTO_TOKEN = "";
    public static final File.Source DEFAULT_FILE_SOURCE = null;
    public static final boolean DEFAULT_HIDE_VOICE2TEXT = true;
    public static final boolean DEFAULT_IS_FRIEND = false;
    public static final boolean DEFAULT_IS_GROUP_ANNOUNCEMENT = false;
    public static final boolean DEFAULT_IS_IN_MY_NUT_STORE = false;
    public static final boolean DEFAULT_IS_ORIGIN_SOURCE = false;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_MIME = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_NAMESPACE = "";
    public static final String DEFAULT_SHARE_CHAT_ID = "";
    public static final int DEFAULT_SHARE_CHAT_LAST_STATE = 0;
    public static final long DEFAULT_SIZE = 0;
    public static final String DEFAULT_TEMPLATE = "";
    public static final String DEFAULT_TEXT = "";
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    private final Abbreviation abbreviation;
    private final List<File> attachments;
    private final Integer audio2text_start_time;
    private final String cache_file_path;
    private final CalendarContent calendar_content;
    private final CardContent card_content;
    private final Map<String, ResourceCleanScene> clean_resource_key_scene;
    private final List<Reference> content_references;
    private final Map<String, ContentValue> content_values;
    private final String crypto_token;
    private final FileType deprecated;
    private final DocEntity doc_entity;
    private final DoubaoContent doubao_content;
    private final DoubaoResource doubao_resource;
    private final Integer duration;
    private final String e2ee_from_id;
    private final String e2ee_to_id;
    private final EmailSystemEvent event;
    private final Long expire_time;
    private final FileAbility file_ability;
    private final List<File> file_attachments;
    private final Long file_last_update_time_ms;
    private final Long file_last_update_user_id;
    private final String file_path;
    private final FilePermission file_permission;
    private final FilePreviewStage file_preview_stage;
    private final File.Source file_source;
    private final String file_upload_id;
    private final String file_uri;
    private final String folder_archive_key;
    private final String fs_unit;
    private final GeneralCalendarContent general_calendar_content;
    private final Integer height;
    private final Boolean hide_voice2text;
    private final HongbaoContent hongbao_content;
    private final HongbaoSystemContent hongbao_system_content;
    private final String i18n_title_key;
    private final ImageSet image;
    private final String image_upload_id;
    private final Boolean include_cleaned_resources;
    private final Boolean is_able_lan_trans;
    private final Boolean is_audio_recognize_finish;
    private final Boolean is_audio_with_text;
    private final Boolean is_encrypted;
    private final Boolean is_friend;
    private final Boolean is_group_announcement;
    private final Boolean is_in_my_nut_store;
    private final Boolean is_origin_source;
    private final Boolean is_try_use_lan_trans;
    private final Boolean is_unknown_doubao_content;
    private final Boolean is_voice_call;
    private final Map<Integer, SystemMessageItemAction> item_actions;
    private final String join_token;
    private final String key;
    private final String lan_receiver_device_id;
    private final String lan_sender_device_id;
    private final TransStatus lan_trans_status;
    private final String lan_trans_status_text;
    private final LingoOption lingo_option;
    private final LocalStatus local_status;
    private final String local_upload_id;
    private final LocationContent location_content;
    private final MediaContent media_content;
    private final MergeForwardContent merge_forward_content;
    private final String mime;
    private final String name;
    private final String namespace;
    private final Long origin_sender_id;
    private final String origin_sender_id_str;
    private final String origin_sender_name;
    private final Long origin_size;
    private final String origin_tos_key;
    private final List<PreviewUrlContent> preview_urls;
    private final List<String> resource_urls;
    private final RichText rich_text;
    private final List<String> risk_object_keys;
    private final ShareCalendarEventContent share_calendar_event_content;
    private final String share_chat_id;
    private final Integer share_chat_last_state;
    private final String share_chatter_id;
    private final ShareUserCardInfo share_user_card_info;
    private final Long size;
    private final String sticker_id;
    private final StickerInfo sticker_info;
    private final String sticker_set_id;
    private final Map<String, SystemContentValue> system_content_values;
    private final SystemExtraContent system_extra_content;
    private final Integer system_message_version;
    private final SystemType system_type;
    private final Integer system_type_value;
    private final String template;
    private final String text;
    private final List<TextUrlContent> text_url_contents;
    private final String title;
    private final TodoOperationContent todo_operation_content;
    private final TransIdentity trans_identity;
    private final TransmitInfo transmit_info;
    private final String trigger_id;
    private final Map<String, ElementRefs> typed_element_refs;
    private final Map<String, UrlPreviewHangPoint> url_preview_hang_point_map;
    private final Map<String, String> values;
    private final String vc_duration_time;
    private final String vc_feedback_status;
    private final String vc_from_feedback_status;
    private final String vc_from_id;
    private final String vc_meeting_id;
    private final String vc_passcode;
    private final String vc_to_feedback_status;
    private final String vc_to_id;
    private final VideoChatContent videochat_content;
    private final String voice2text;
    private final VoteContent vote_content;
    private final Integer width;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003!\"#B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013¨\u0006$"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Content$ContentValue;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Content$ContentValue$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Content$ContentValue$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "type", "Lcom/lark/kmp/pb/basic/v1/Content$ContentValueType;", "getType", "()Lcom/lark/kmp/pb/basic/v1/Content$ContentValueType;", "ids", "", "getIds", "()Ljava/util/List;", "text", "getText", "link", "getLink", "action", "Lcom/lark/kmp/pb/basic/v1/Content$SystemMessageAction;", "getAction", "()Lcom/lark/kmp/pb/basic/v1/Content$SystemMessageAction;", "items", "Lcom/lark/kmp/pb/basic/v1/Content$ContentValue$Item;", "getItems", "newBuilder", "toString", "Builder", "Companion", "Item", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ContentValue extends com.lark.wire.Message<ContentValue, a> {
        public static final ProtoAdapter<ContentValue> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final SystemMessageAction action;
        private final String id;
        private final List<String> ids;
        private final List<Item> items;
        private final String link;
        private final String text;
        private final ContentValueType type;

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002#$B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010!\u001a\u00020\u0002H\u0016J\b\u0010\"\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001d\u0010\u001f¨\u0006%"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Content$ContentValue$Item;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Content$ContentValue$Item$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Content$ContentValue$Item$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "text", "getText", "i18n_text", "", "getI18n_text", "()Ljava/util/Map;", "type", "Lcom/lark/kmp/pb/basic/v1/Content$ContentValueType;", "getType", "()Lcom/lark/kmp/pb/basic/v1/Content$ContentValueType;", "link", "getLink", CardActionService.ACTION_ID, "", "getAction_id", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "is_clickable", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class Item extends com.lark.wire.Message<Item, a> {
            public static final ProtoAdapter<Item> ADAPTER = null;
            public static final b Companion = null;
            private static final long serialVersionUID = 0;
            private final Integer action_id;
            private final Map<String, String> i18n_text;
            private final String id;
            private final Boolean is_clickable;
            private final String link;
            private final String text;
            private final ContentValueType type;

            public static final class a extends com.lark.wire.Message.a<Item, a> {
                public String d;
                public String e;
                public Map<String, String> f;
                public ContentValueType g;
                public String h;
                public Integer i;
                public Boolean j;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new Item(this, c(), null);
                }

                public a() {
                    this.f = MapsKt.emptyMap();
                }
            }

            public static final class b {
                public b() {
                }
            }

            public /* synthetic */ Item(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new b();
                final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
                final KClass r1 = Reflection.getOrCreateKotlinClass(Item.class);
                final Syntax r2 = Syntax.PROTO_2;
                ADAPTER = new Content$ContentValue$Item$Companion$ADAPTER$1(r0, r1, r2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.id;
                r0.e = this.text;
                r0.f = this.i18n_text;
                r0.g = this.type;
                r0.h = this.link;
                r0.i = this.action_id;
                r0.j = this.is_clickable;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(Item.class).getSimpleName() + '@' + hashCode();
            }

            public final Integer getAction_id() {
                return this.action_id;
            }

            public final Map<String, String> getI18n_text() {
                return this.i18n_text;
            }

            public final String getId() {
                return this.id;
            }

            public final String getLink() {
                return this.link;
            }

            public final String getText() {
                return this.text;
            }

            public final ContentValueType getType() {
                return this.type;
            }

            public final Boolean is_clickable() {
                return this.is_clickable;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public Item(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.id = r2.d;
                this.text = r2.e;
                this.i18n_text = com.lark.wire.internal.a.d("i18n_text", r2.f);
                this.type = r2.g;
                this.link = r2.h;
                this.action_id = r2.i;
                this.is_clickable = r2.j;
            }

            public /* synthetic */ Item(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        public static final class a extends com.lark.wire.Message.a<ContentValue, a> {
            public String d;
            public ContentValueType e;
            public List<String> f;
            public String g;
            public String h;
            public SystemMessageAction i;
            public List<Item> j;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ContentValue(this, c(), null);
            }

            public a() {
                this.f = CollectionsKt.emptyList();
                this.j = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<ContentValue> {
            @Override // com.lark.wire.ProtoAdapter
            public final ContentValue c(g0 r12) {
                Intrinsics.checkNotNullParameter(r12, "reader");
                a r1 = new a();
                ArrayList r2 = new ArrayList();
                ArrayList r3 = new ArrayList();
                long r4 = r12.c();
            L3:
                int r6 = r12.e();
                if (r6 == (-1)) goto L17;
                switch(r6) {
                    case 1: goto L16;
                    case 2: goto L19;
                    case 3: goto L11;
                    case 4: goto L10;
                    case 5: goto L9;
                    case 6: goto L8;
                    case 7: goto L7;
                    default: goto L6;
                };
            L19:
                r1.e = ContentValueType.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r7 = Unit.INSTANCE;
                goto L3
            L7:
                r3.add(Item.ADAPTER.c(r12));
                goto L3
            L8:
                r1.i = SystemMessageAction.ADAPTER.c(r12);
                goto L3
            L9:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r12, "reader");
                r1.h = r12.i();
                goto L3
            L10:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r12, "reader");
                r1.g = r12.i();
                goto L3
            L11:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r12, "reader");
                r2.add(r12.i());
                goto L3
            L16:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r12, "reader");
                r1.d = r12.i();
                goto L3
            L6:
                r12.j(r6);
                Unit r8 = Unit.INSTANCE;
                goto L3
            L17:
                ByteString r13 = r12.d(r4);
                Intrinsics.checkNotNullParameter(r2, "ids");
                com.lark.wire.internal.a.a(r2);
                r1.f = r2;
                Intrinsics.checkNotNullParameter(r3, "items");
                com.lark.wire.internal.a.a(r3);
                r1.j = r3;
                return new ContentValue(r1, r13, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ContentValue r6) {
                ContentValue r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return ((((((r0 + r1.l(1, r7.getId())) + ContentValueType.ADAPTER.l(2, r7.getType())) + r1.a().l(3, r7.getIds())) + r1.l(4, r7.getText())) + r1.l(5, r7.getLink())) + SystemMessageAction.ADAPTER.l(6, r7.getAction())) + Item.ADAPTER.a().l(7, r7.getItems());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, ContentValue r6) {
                ContentValue r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r5, 1, r7.getId());
                ContentValueType.ADAPTER.i(r5, 2, r7.getType());
                r0.a().i(r5, 3, r7.getIds());
                r0.i(r5, 4, r7.getText());
                r0.i(r5, 5, r7.getLink());
                SystemMessageAction.ADAPTER.i(r5, 6, r7.getAction());
                Item.ADAPTER.a().i(r5, 7, r7.getItems());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, ContentValue r6) {
                ContentValue r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                Item.ADAPTER.a().j(r5, 7, r7.getItems());
                SystemMessageAction.ADAPTER.j(r5, 6, r7.getAction());
                w r0 = ProtoAdapter.q;
                r0.j(r5, 5, r7.getLink());
                r0.j(r5, 4, r7.getText());
                r0.a().j(r5, 3, r7.getIds());
                ContentValueType.ADAPTER.j(r5, 2, r7.getType());
                r0.j(r5, 1, r7.getId());
            }

            public b(FieldEncoding r7, KClass<ContentValue> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Content.ContentValue", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ContentValue(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ContentValue.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.id;
            r0.e = this.type;
            r0.f = this.ids;
            r0.g = this.text;
            r0.h = this.link;
            r0.i = this.action;
            r0.j = this.items;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ContentValue.class).getSimpleName() + '@' + hashCode();
        }

        public final SystemMessageAction getAction() {
            return this.action;
        }

        public final String getId() {
            return this.id;
        }

        public final List<String> getIds() {
            return this.ids;
        }

        public final List<Item> getItems() {
            return this.items;
        }

        public final String getLink() {
            return this.link;
        }

        public final String getText() {
            return this.text;
        }

        public final ContentValueType getType() {
            return this.type;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ContentValue(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.id = r2.d;
            this.type = r2.e;
            this.ids = com.lark.wire.internal.a.c("ids", r2.f);
            this.text = r2.g;
            this.link = r2.h;
            this.action = r2.i;
            this.items = com.lark.wire.internal.a.c("items", r2.j);
        }

        public /* synthetic */ ContentValue(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00122\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Content$ContentValueType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CONTENT_VALUE_TYPE_UNKNOWN", "USER", "BOT", "TEXT", "CHAT", "CHATTER", "URL", "ACTION", "DEPARTMENT", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum ContentValueType extends Enum<ContentValueType> implements o0 {
        public static final ContentValueType ACTION = null;
        public static final ProtoAdapter<ContentValueType> ADAPTER = null;
        public static final ContentValueType BOT = null;
        public static final ContentValueType CHAT = null;
        public static final ContentValueType CHATTER = null;
        public static final ContentValueType CONTENT_VALUE_TYPE_UNKNOWN = null;
        public static final b Companion = null;
        public static final ContentValueType DEPARTMENT = null;
        public static final ContentValueType TEXT = null;
        public static final ContentValueType URL = null;
        public static final ContentValueType USER = null;
        public static final /* synthetic */ ContentValueType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<ContentValueType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                ContentValueType.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<ContentValueType> r1, Syntax r2, ContentValueType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static ContentValueType a(int r0) {
                switch(r0) {
                    case 0: goto L13;
                    case 1: goto L22;
                    case 2: goto L21;
                    case 3: goto L20;
                    case 4: goto L19;
                    case 5: goto L18;
                    case 6: goto L17;
                    case 7: goto L16;
                    case 8: goto L15;
                    default: goto L3;
                };
            L3:
                return null;
            L15:
                return ContentValueType.DEPARTMENT;
            L16:
                return ContentValueType.ACTION;
            L17:
                return ContentValueType.URL;
            L18:
                return ContentValueType.CHATTER;
            L19:
                return ContentValueType.CHAT;
            L20:
                return ContentValueType.TEXT;
            L21:
                return ContentValueType.BOT;
            L22:
                return ContentValueType.USER;
            L13:
                return ContentValueType.CONTENT_VALUE_TYPE_UNKNOWN;
            }
        }

        @JvmStatic
        public static final ContentValueType fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<ContentValueType> getEntries() {
            return b;
        }

        static {
            ContentValueType r0 = new ContentValueType("CONTENT_VALUE_TYPE_UNKNOWN", 0, 0);
            CONTENT_VALUE_TYPE_UNKNOWN = r0;
            ContentValueType r1 = new ContentValueType("USER", 1, 1);
            USER = r1;
            ContentValueType r3 = new ContentValueType("BOT", 2, 2);
            BOT = r3;
            ContentValueType r5 = new ContentValueType("TEXT", 3, 3);
            TEXT = r5;
            ContentValueType r7 = new ContentValueType("CHAT", 4, 4);
            CHAT = r7;
            ContentValueType r9 = new ContentValueType("CHATTER", 5, 5);
            CHATTER = r9;
            ContentValueType r11 = new ContentValueType("URL", 6, 6);
            URL = r11;
            ContentValueType r13 = new ContentValueType("ACTION", 7, 7);
            ACTION = r13;
            ContentValueType r15 = new ContentValueType("DEPARTMENT", 8, 8);
            DEPARTMENT = r15;
            ContentValueType[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r15};
            a = r14;
            b = EnumEntriesKt.enumEntries(r14);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(ContentValueType.class), Syntax.PROTO_2, r0);
        }

        public static ContentValueType[] values() {
            return (ContentValueType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static ContentValueType valueOf(String r1) {
            return (ContentValueType) r27.a.a(ContentValueType.class, r1);
        }

        public ContentValueType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Content$FileAbility;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_SUPPORT_STATE", "SUPPORT_EDIT", "SUPPORT_PREVIEW", "NOT_SUPPORT_PREVIEW", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum FileAbility extends Enum<FileAbility> implements o0 {
        public static final ProtoAdapter<FileAbility> ADAPTER = null;
        public static final b Companion = null;
        public static final FileAbility NOT_SUPPORT_PREVIEW = null;
        public static final FileAbility SUPPORT_EDIT = null;
        public static final FileAbility SUPPORT_PREVIEW = null;
        public static final FileAbility UNKNOWN_SUPPORT_STATE = null;
        public static final /* synthetic */ FileAbility[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<FileAbility> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                FileAbility.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L17;
                return null;
            L17:
                return FileAbility.NOT_SUPPORT_PREVIEW;
            L18:
                return FileAbility.SUPPORT_PREVIEW;
            L19:
                return FileAbility.SUPPORT_EDIT;
            L15:
                return FileAbility.UNKNOWN_SUPPORT_STATE;
            }

            public a(KClass<FileAbility> r1, Syntax r2, FileAbility r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<FileAbility> getEntries() {
            return b;
        }

        static {
            FileAbility r0 = new FileAbility("UNKNOWN_SUPPORT_STATE", 0, 0);
            UNKNOWN_SUPPORT_STATE = r0;
            FileAbility r1 = new FileAbility("SUPPORT_EDIT", 1, 1);
            SUPPORT_EDIT = r1;
            FileAbility r3 = new FileAbility("SUPPORT_PREVIEW", 2, 2);
            SUPPORT_PREVIEW = r3;
            FileAbility r5 = new FileAbility("NOT_SUPPORT_PREVIEW", 3, 3);
            NOT_SUPPORT_PREVIEW = r5;
            FileAbility[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(FileAbility.class), Syntax.PROTO_2, r0);
        }

        public static FileAbility[] values() {
            return (FileAbility[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final FileAbility fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L17;
            return null;
        L17:
            return NOT_SUPPORT_PREVIEW;
        L18:
            return SUPPORT_PREVIEW;
        L19:
            return SUPPORT_EDIT;
        L15:
            return UNKNOWN_SUPPORT_STATE;
        }

        public static FileAbility valueOf(String r1) {
            return (FileAbility) r27.a.a(FileAbility.class, r1);
        }

        public FileAbility(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Content$FilePermission;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_CAN_STATE", "CAN_EDIT", "CAN_PREVIEW", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum FilePermission extends Enum<FilePermission> implements o0 {
        public static final ProtoAdapter<FilePermission> ADAPTER = null;
        public static final FilePermission CAN_EDIT = null;
        public static final FilePermission CAN_PREVIEW = null;
        public static final b Companion = null;
        public static final FilePermission UNKNOWN_CAN_STATE = null;
        public static final /* synthetic */ FilePermission[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<FilePermission> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                FilePermission.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return FilePermission.CAN_PREVIEW;
            L15:
                return FilePermission.CAN_EDIT;
            L12:
                return FilePermission.UNKNOWN_CAN_STATE;
            }

            public a(KClass<FilePermission> r1, Syntax r2, FilePermission r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<FilePermission> getEntries() {
            return b;
        }

        static {
            FilePermission r0 = new FilePermission("UNKNOWN_CAN_STATE", 0, 0);
            UNKNOWN_CAN_STATE = r0;
            FilePermission r1 = new FilePermission("CAN_EDIT", 1, 1);
            CAN_EDIT = r1;
            FilePermission r3 = new FilePermission("CAN_PREVIEW", 2, 2);
            CAN_PREVIEW = r3;
            FilePermission[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(FilePermission.class), Syntax.PROTO_2, r0);
        }

        public static FilePermission[] values() {
            return (FilePermission[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final FilePermission fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return CAN_PREVIEW;
        L15:
            return CAN_EDIT;
        L12:
            return UNKNOWN_CAN_STATE;
        }

        public static FilePermission valueOf(String r1) {
            return (FilePermission) r27.a.a(FilePermission.class, r1);
        }

        public FilePermission(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Content$LocalStatus;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Content$LocalStatus$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Content$LocalStatus$Builder;Lokio/ByteString;)V", "file_last_update_user_id", "", "getFile_last_update_user_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "file_last_update_time_ms", "getFile_last_update_time_ms", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class LocalStatus extends com.lark.wire.Message<LocalStatus, a> {
        public static final ProtoAdapter<LocalStatus> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Long file_last_update_time_ms;
        private final Long file_last_update_user_id;

        public static final class a extends com.lark.wire.Message.a<LocalStatus, a> {
            public Long d;
            public Long e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new LocalStatus(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<LocalStatus> {
            @Override // com.lark.wire.ProtoAdapter
            public final LocalStatus c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L13;
                if (r3 != 1) goto L8;
                r0.d = (Long) ProtoAdapter.k.c(r6);
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
                return new LocalStatus(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(LocalStatus r5) {
                LocalStatus r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                t r1 = ProtoAdapter.k;
                return (r0 + r1.l(1, r6.getFile_last_update_user_id())) + r1.l(2, r6.getFile_last_update_time_ms());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, LocalStatus r5) {
                LocalStatus r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                t r0 = ProtoAdapter.k;
                r0.i(r4, 1, r6.getFile_last_update_user_id());
                r0.i(r4, 2, r6.getFile_last_update_time_ms());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, LocalStatus r5) {
                LocalStatus r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                t r0 = ProtoAdapter.k;
                r0.j(r4, 2, r6.getFile_last_update_time_ms());
                r0.j(r4, 1, r6.getFile_last_update_user_id());
            }

            public b(FieldEncoding r7, KClass<LocalStatus> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Content.LocalStatus", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ LocalStatus(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(LocalStatus.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.file_last_update_user_id;
            r0.e = this.file_last_update_time_ms;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(LocalStatus.class).getSimpleName() + '@' + hashCode();
        }

        public final Long getFile_last_update_time_ms() {
            return this.file_last_update_time_ms;
        }

        public final Long getFile_last_update_user_id() {
            return this.file_last_update_user_id;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public LocalStatus(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.file_last_update_user_id = r2.d;
            this.file_last_update_time_ms = r2.e;
        }

        public /* synthetic */ LocalStatus(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Content$NewTopicSystemMessageExtraContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Content$NewTopicSystemMessageExtraContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Content$NewTopicSystemMessageExtraContent$Builder;Lokio/ByteString;)V", "tool_ids", "", "", "getTool_ids", "()Ljava/util/List;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class NewTopicSystemMessageExtraContent extends com.lark.wire.Message<NewTopicSystemMessageExtraContent, a> {
        public static final ProtoAdapter<NewTopicSystemMessageExtraContent> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final List<String> tool_ids;

        public static final class a extends com.lark.wire.Message.a<NewTopicSystemMessageExtraContent, a> {
            public List<String> d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new NewTopicSystemMessageExtraContent(this, c(), null);
            }

            public a() {
                this.d = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<NewTopicSystemMessageExtraContent> {
            @Override // com.lark.wire.ProtoAdapter
            public final NewTopicSystemMessageExtraContent c(g0 r8) {
                Intrinsics.checkNotNullParameter(r8, "reader");
                a r1 = new a();
                ArrayList r2 = new ArrayList();
                long r3 = r8.c();
            L3:
                int r5 = r8.e();
                if (r5 == (-1)) goto L9;
                if (r5 == 1) goto L7;
                r8.j(r5);
                goto L3
            L7:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r2.add(r8.i());
                goto L3
            L9:
                ByteString r9 = r8.d(r3);
                Intrinsics.checkNotNullParameter(r2, "tool_ids");
                com.lark.wire.internal.a.a(r2);
                r1.d = r2;
                return new NewTopicSystemMessageExtraContent(r1, r9, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(NewTopicSystemMessageExtraContent r4) {
                NewTopicSystemMessageExtraContent r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ProtoAdapter.q.a().l(1, r5.getTool_ids());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, NewTopicSystemMessageExtraContent r5) {
                NewTopicSystemMessageExtraContent r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.a().i(r4, 1, r6.getTool_ids());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, NewTopicSystemMessageExtraContent r4) {
                NewTopicSystemMessageExtraContent r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ProtoAdapter.q.a().j(r3, 1, r5.getTool_ids());
            }

            public b(FieldEncoding r7, KClass<NewTopicSystemMessageExtraContent> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Content.NewTopicSystemMessageExtraContent", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ NewTopicSystemMessageExtraContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(NewTopicSystemMessageExtraContent.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.tool_ids;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(NewTopicSystemMessageExtraContent.class).getSimpleName() + '@' + hashCode();
        }

        public final List<String> getTool_ids() {
            return this.tool_ids;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public NewTopicSystemMessageExtraContent(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.tool_ids = com.lark.wire.internal.a.c("tool_ids", r2.d);
        }

        public /* synthetic */ NewTopicSystemMessageExtraContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Content$Reference;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Content$Reference$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Content$Reference$Builder;Lokio/ByteString;)V", "url", "", "getUrl", "()Ljava/lang/String;", "title", "getTitle", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Reference extends com.lark.wire.Message<Reference, a> {
        public static final ProtoAdapter<Reference> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String title;
        private final String url;

        public static final class a extends com.lark.wire.Message.a<Reference, a> {
            public String d;
            public String e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Reference(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Reference> {
            @Override // com.lark.wire.ProtoAdapter
            public final Reference c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L13;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.i();
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
                return new Reference(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Reference r5) {
                Reference r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return (r0 + r1.l(1, r6.getUrl())) + r1.l(2, r6.getTitle());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Reference r5) {
                Reference r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getUrl());
                r0.i(r4, 2, r6.getTitle());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, Reference r5) {
                Reference r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 2, r6.getTitle());
                r0.j(r4, 1, r6.getUrl());
            }

            public b(FieldEncoding r7, KClass<Reference> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Content.Reference", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Reference(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Reference.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.url;
            r0.e = this.title;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Reference.class).getSimpleName() + '@' + hashCode();
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getUrl() {
            return this.url;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Reference(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.url = r2.d;
            this.title = r2.e;
        }

        public /* synthetic */ Reference(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0007\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Content$ShareUserCardInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Content$ShareUserCardInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Content$ShareUserCardInfo$Builder;Lokio/ByteString;)V", "chatter_id", "", "getChatter_id", "()Ljava/lang/String;", "avatar_image", "Lcom/lark/kmp/pb/basic/v1/Image;", "getAvatar_image", "()Lcom/lark/kmp/pb/basic/v1/Image;", "name", "getName", "en_us_name", "getEn_us_name", "international_name", "", "getInternational_name", "()Ljava/util/Map;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ShareUserCardInfo extends com.lark.wire.Message<ShareUserCardInfo, a> {
        public static final ProtoAdapter<ShareUserCardInfo> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final Image avatar_image;
        private final String chatter_id;
        private final String en_us_name;
        private final Map<String, String> international_name;
        private final String name;

        public static final class a extends com.lark.wire.Message.a<ShareUserCardInfo, a> {
            public String d;
            public Image e;
            public String f;
            public String g;
            public Map<String, String> h;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ShareUserCardInfo(this, c(), null);
            }

            public a() {
                this.h = MapsKt.emptyMap();
            }
        }

        public static final class b {
            public b() {
            }
        }

        public /* synthetic */ ShareUserCardInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new b();
            final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
            final KClass r1 = Reflection.getOrCreateKotlinClass(ShareUserCardInfo.class);
            final Syntax r2 = Syntax.PROTO_2;
            ADAPTER = new Content$ShareUserCardInfo$Companion$ADAPTER$1(r0, r1, r2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.chatter_id;
            r0.e = this.avatar_image;
            r0.f = this.name;
            r0.g = this.en_us_name;
            r0.h = this.international_name;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ShareUserCardInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final Image getAvatar_image() {
            return this.avatar_image;
        }

        public final String getChatter_id() {
            return this.chatter_id;
        }

        public final String getEn_us_name() {
            return this.en_us_name;
        }

        public final Map<String, String> getInternational_name() {
            return this.international_name;
        }

        public final String getName() {
            return this.name;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ShareUserCardInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.chatter_id = r2.d;
            this.avatar_image = r2.e;
            this.name = r2.f;
            this.en_us_name = r2.g;
            this.international_name = com.lark.wire.internal.a.d("international_name", r2.h);
        }

        public /* synthetic */ ShareUserCardInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Content$StickerInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Content$StickerInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Content$StickerInfo$Builder;Lokio/ByteString;)V", "title", "", "getTitle", "()Ljava/lang/String;", "description", "getDescription", "is_paid", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class StickerInfo extends com.lark.wire.Message<StickerInfo, a> {
        public static final ProtoAdapter<StickerInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String description;
        private final Boolean is_paid;
        private final String title;

        public static final class a extends com.lark.wire.Message.a<StickerInfo, a> {
            public String d;
            public String e;
            public Boolean f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new StickerInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<StickerInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final StickerInfo c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L16;
                if (r4 != 2) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.i();
                goto L3
            L8:
                if (r4 != 3) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L10:
                if (r4 != 4) goto L11;
                r1.f = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L11:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L16:
                return new StickerInfo(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(StickerInfo r5) {
                StickerInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return ((r0 + r1.l(2, r6.getTitle())) + r1.l(3, r6.getDescription())) + ProtoAdapter.g.l(4, r6.is_paid());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, StickerInfo r5) {
                StickerInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 2, r6.getTitle());
                r0.i(r4, 3, r6.getDescription());
                ProtoAdapter.g.i(r4, 4, r6.is_paid());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, StickerInfo r5) {
                StickerInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.g.j(r4, 4, r6.is_paid());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 3, r6.getDescription());
                r0.j(r4, 2, r6.getTitle());
            }

            public b(FieldEncoding r7, KClass<StickerInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Content.StickerInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ StickerInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(StickerInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.title;
            r0.e = this.description;
            r0.f = this.is_paid;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(StickerInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getTitle() {
            return this.title;
        }

        public final Boolean is_paid() {
            return this.is_paid;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public StickerInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.title = r2.d;
            this.description = r2.e;
            this.is_paid = r2.f;
        }

        public /* synthetic */ StickerInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0014\u0015\u0016B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Content$SystemContentValue;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Content$SystemContentValue$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Content$SystemContentValue$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/Content$ContentValueType;", "getType", "()Lcom/lark/kmp/pb/basic/v1/Content$ContentValueType;", "content_values", "", "Lcom/lark/kmp/pb/basic/v1/Content$SystemContentValue$ContentValue;", "getContent_values", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "ContentValue", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class SystemContentValue extends com.lark.wire.Message<SystemContentValue, a> {
        public static final ProtoAdapter<SystemContentValue> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final List<ContentValue> content_values;
        private final ContentValueType type;

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002$%B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\"\u001a\u00020\u0002H\u0016J\b\u0010#\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0018\u0010\u001aR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010!\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b!\u0010\u001a¨\u0006&"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Content$SystemContentValue$ContentValue;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Content$SystemContentValue$ContentValue$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Content$SystemContentValue$ContentValue$Builder;Lokio/ByteString;)V", "value", "", "getValue", "()Ljava/lang/String;", "id", "getId", "link", "getLink", "type", "Lcom/lark/kmp/pb/basic/v1/Content$ContentValueType;", "getType", "()Lcom/lark/kmp/pb/basic/v1/Content$ContentValueType;", "action_type", "Lcom/lark/kmp/pb/basic/v1/Content$SystemMessageAction$ActType;", "getAction_type", "()Lcom/lark/kmp/pb/basic/v1/Content$SystemMessageAction$ActType;", "is_anonymous", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", CardActionService.ACTION_ID, "", "getAction_id", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "is_clickable", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class ContentValue extends com.lark.wire.Message<ContentValue, a> {
            public static final ProtoAdapter<ContentValue> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final Integer action_id;
            private final SystemMessageAction.ActType action_type;
            private final String id;
            private final Boolean is_anonymous;
            private final Boolean is_clickable;
            private final String link;
            private final ContentValueType type;
            private final String value;

            public static final class a extends com.lark.wire.Message.a<ContentValue, a> {
                public String d;
                public String e;
                public String f;
                public ContentValueType g;
                public SystemMessageAction.ActType h;
                public Boolean i;
                public Integer j;
                public Boolean k;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new ContentValue(this, c(), null);
                }

                public a() {
                }
            }

            public static final class b extends ProtoAdapter<ContentValue> {
                @Override // com.lark.wire.ProtoAdapter
                public final ContentValue c(g0 r10) {
                    Intrinsics.checkNotNullParameter(r10, "reader");
                    a r1 = new a();
                    long r2 = r10.c();
                L3:
                    int r4 = r10.e();
                    if (r4 == (-1)) goto L22;
                    switch(r4) {
                        case 1: goto L20;
                        case 2: goto L19;
                        case 3: goto L18;
                        case 4: goto L23;
                        case 5: goto L25;
                        case 6: goto L9;
                        case 7: goto L8;
                        case 8: goto L7;
                        default: goto L6;
                    };
                L23:
                    r1.g = ContentValueType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
                L16:
                    e = move-exception;
                    r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                    Unit r5 = Unit.INSTANCE;
                    goto L3
                L25:
                    r1.h = SystemMessageAction.ActType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
                L12:
                    e = move-exception;
                    r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                    Unit r6 = Unit.INSTANCE;
                    goto L3
                L7:
                    r1.k = (Boolean) ProtoAdapter.g.c(r10);
                    goto L3
                L8:
                    r1.j = (Integer) ProtoAdapter.h.c(r10);
                    goto L3
                L9:
                    r1.i = (Boolean) ProtoAdapter.g.c(r10);
                    goto L3
                L18:
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r10, "reader");
                    r1.f = r10.i();
                    goto L3
                L19:
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r10, "reader");
                    r1.e = r10.i();
                    goto L3
                L20:
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r10, "reader");
                    r1.d = r10.i();
                    goto L3
                L6:
                    r10.j(r4);
                    Unit r7 = Unit.INSTANCE;
                    goto L3
                L22:
                    return new ContentValue(r1, r10.d(r2), null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(ContentValue r6) {
                    ContentValue r7 = r6;
                    Intrinsics.checkNotNullParameter(r7, "value");
                    int r0 = r7.unknownFields().size();
                    w r1 = ProtoAdapter.q;
                    int r2 = ((((r0 + r1.l(1, r7.getValue())) + r1.l(2, r7.getId())) + r1.l(3, r7.getLink())) + ContentValueType.ADAPTER.l(4, r7.getType())) + SystemMessageAction.ActType.ADAPTER.l(5, r7.getAction_type());
                    l r3 = ProtoAdapter.g;
                    return ((r2 + r3.l(6, r7.is_anonymous())) + ProtoAdapter.h.l(7, r7.getAction_id())) + r3.l(8, r7.is_clickable());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r5, ContentValue r6) {
                    ContentValue r7 = r6;
                    Intrinsics.checkNotNullParameter(r5, "writer");
                    Intrinsics.checkNotNullParameter(r7, "value");
                    w r0 = ProtoAdapter.q;
                    r0.i(r5, 1, r7.getValue());
                    r0.i(r5, 2, r7.getId());
                    r0.i(r5, 3, r7.getLink());
                    ContentValueType.ADAPTER.i(r5, 4, r7.getType());
                    SystemMessageAction.ActType.ADAPTER.i(r5, 5, r7.getAction_type());
                    l r1 = ProtoAdapter.g;
                    r1.i(r5, 6, r7.is_anonymous());
                    ProtoAdapter.h.i(r5, 7, r7.getAction_id());
                    r1.i(r5, 8, r7.is_clickable());
                    r5.a(r7.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r5, ContentValue r6) {
                    ContentValue r7 = r6;
                    Intrinsics.checkNotNullParameter(r5, "writer");
                    Intrinsics.checkNotNullParameter(r7, "value");
                    r5.d(r7.unknownFields());
                    l r0 = ProtoAdapter.g;
                    r0.j(r5, 8, r7.is_clickable());
                    ProtoAdapter.h.j(r5, 7, r7.getAction_id());
                    r0.j(r5, 6, r7.is_anonymous());
                    SystemMessageAction.ActType.ADAPTER.j(r5, 5, r7.getAction_type());
                    ContentValueType.ADAPTER.j(r5, 4, r7.getType());
                    w r1 = ProtoAdapter.q;
                    r1.j(r5, 3, r7.getLink());
                    r1.j(r5, 2, r7.getId());
                    r1.j(r5, 1, r7.getValue());
                }

                public b(FieldEncoding r7, KClass<ContentValue> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.Content.SystemContentValue.ContentValue", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ ContentValue(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ContentValue.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.value;
                r0.e = this.id;
                r0.f = this.link;
                r0.g = this.type;
                r0.h = this.action_type;
                r0.i = this.is_anonymous;
                r0.j = this.action_id;
                r0.k = this.is_clickable;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(ContentValue.class).getSimpleName() + '@' + hashCode();
            }

            public final Integer getAction_id() {
                return this.action_id;
            }

            public final SystemMessageAction.ActType getAction_type() {
                return this.action_type;
            }

            public final String getId() {
                return this.id;
            }

            public final String getLink() {
                return this.link;
            }

            public final ContentValueType getType() {
                return this.type;
            }

            public final String getValue() {
                return this.value;
            }

            public final Boolean is_anonymous() {
                return this.is_anonymous;
            }

            public final Boolean is_clickable() {
                return this.is_clickable;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public ContentValue(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.value = r2.d;
                this.id = r2.e;
                this.link = r2.f;
                this.type = r2.g;
                this.action_type = r2.h;
                this.is_anonymous = r2.i;
                this.action_id = r2.j;
                this.is_clickable = r2.k;
            }

            public /* synthetic */ ContentValue(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        public static final class a extends com.lark.wire.Message.a<SystemContentValue, a> {
            public ContentValueType d;
            public List<ContentValue> e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new SystemContentValue(this, c(), null);
            }

            public a() {
                this.e = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<SystemContentValue> {
            @Override // com.lark.wire.ProtoAdapter
            public final SystemContentValue c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r0 = new a();
                ArrayList r1 = new ArrayList();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L15;
                if (r4 != 1) goto L8;
                r0.d = ContentValueType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L8:
                if (r4 != 2) goto L9;
                r1.add(ContentValue.ADAPTER.c(r10));
                goto L3
            L9:
                r10.j(r4);
                goto L3
            L15:
                ByteString r11 = r10.d(r2);
                Intrinsics.checkNotNullParameter(r1, "content_values");
                com.lark.wire.internal.a.a(r1);
                r0.e = r1;
                return new SystemContentValue(r0, r11, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(SystemContentValue r5) {
                SystemContentValue r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + ContentValueType.ADAPTER.l(1, r6.getType())) + ContentValue.ADAPTER.a().l(2, r6.getContent_values());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, SystemContentValue r5) {
                SystemContentValue r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ContentValueType.ADAPTER.i(r4, 1, r6.getType());
                ContentValue.ADAPTER.a().i(r4, 2, r6.getContent_values());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, SystemContentValue r5) {
                SystemContentValue r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ContentValue.ADAPTER.a().j(r4, 2, r6.getContent_values());
                ContentValueType.ADAPTER.j(r4, 1, r6.getType());
            }

            public b(FieldEncoding r7, KClass<SystemContentValue> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Content.SystemContentValue", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ SystemContentValue(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(SystemContentValue.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.type;
            r0.e = this.content_values;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(SystemContentValue.class).getSimpleName() + '@' + hashCode();
        }

        public final List<ContentValue> getContent_values() {
            return this.content_values;
        }

        public final ContentValueType getType() {
            return this.type;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public SystemContentValue(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.type = r2.d;
            this.content_values = com.lark.wire.internal.a.c("content_values", r2.e);
        }

        public /* synthetic */ SystemContentValue(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Content$SystemExtraContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Content$SystemExtraContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Content$SystemExtraContent$Builder;Lokio/ByteString;)V", "guide_content", "Lcom/lark/kmp/pb/basic/v1/SystemGuideContent;", "getGuide_content", "()Lcom/lark/kmp/pb/basic/v1/SystemGuideContent;", "new_topic_system_message_extra_content", "Lcom/lark/kmp/pb/basic/v1/Content$NewTopicSystemMessageExtraContent;", "getNew_topic_system_message_extra_content", "()Lcom/lark/kmp/pb/basic/v1/Content$NewTopicSystemMessageExtraContent;", "clear_screen", "", "getClear_screen", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class SystemExtraContent extends com.lark.wire.Message<SystemExtraContent, a> {
        public static final ProtoAdapter<SystemExtraContent> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Boolean clear_screen;
        private final SystemGuideContent guide_content;
        private final NewTopicSystemMessageExtraContent new_topic_system_message_extra_content;

        public static final class a extends com.lark.wire.Message.a<SystemExtraContent, a> {
            public SystemGuideContent d;
            public NewTopicSystemMessageExtraContent e;
            public Boolean f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new SystemExtraContent(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<SystemExtraContent> {
            @Override // com.lark.wire.ProtoAdapter
            public final SystemExtraContent c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L16;
                if (r3 != 1) goto L8;
                r0.d = SystemGuideContent.ADAPTER.c(r6);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.e = NewTopicSystemMessageExtraContent.ADAPTER.c(r6);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.f = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L11:
                r6.j(r3);
                Unit r4 = Unit.INSTANCE;
                goto L3
            L16:
                return new SystemExtraContent(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(SystemExtraContent r5) {
                SystemExtraContent r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return ((r6.unknownFields().size() + SystemGuideContent.ADAPTER.l(1, r6.getGuide_content())) + NewTopicSystemMessageExtraContent.ADAPTER.l(2, r6.getNew_topic_system_message_extra_content())) + ProtoAdapter.g.l(3, r6.getClear_screen());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, SystemExtraContent r5) {
                SystemExtraContent r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                SystemGuideContent.ADAPTER.i(r4, 1, r6.getGuide_content());
                NewTopicSystemMessageExtraContent.ADAPTER.i(r4, 2, r6.getNew_topic_system_message_extra_content());
                ProtoAdapter.g.i(r4, 3, r6.getClear_screen());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, SystemExtraContent r5) {
                SystemExtraContent r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.g.j(r4, 3, r6.getClear_screen());
                NewTopicSystemMessageExtraContent.ADAPTER.j(r4, 2, r6.getNew_topic_system_message_extra_content());
                SystemGuideContent.ADAPTER.j(r4, 1, r6.getGuide_content());
            }

            public b(FieldEncoding r7, KClass<SystemExtraContent> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Content.SystemExtraContent", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ SystemExtraContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(SystemExtraContent.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.guide_content;
            r0.e = this.new_topic_system_message_extra_content;
            r0.f = this.clear_screen;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(SystemExtraContent.class).getSimpleName() + '@' + hashCode();
        }

        public final Boolean getClear_screen() {
            return this.clear_screen;
        }

        public final SystemGuideContent getGuide_content() {
            return this.guide_content;
        }

        public final NewTopicSystemMessageExtraContent getNew_topic_system_message_extra_content() {
            return this.new_topic_system_message_extra_content;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public SystemExtraContent(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.guide_content = r2.d;
            this.new_topic_system_message_extra_content = r2.e;
            this.clear_screen = r2.f;
        }

        public /* synthetic */ SystemExtraContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\u0017\u0018\u0019\u001a\u001bB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Content$SystemMessageAction;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Content$SystemMessageAction$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Content$SystemMessageAction$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/Content$SystemMessageAction$ActType;", "getType", "()Lcom/lark/kmp/pb/basic/v1/Content$SystemMessageAction$ActType;", "type_num", "", "getType_num", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "payload", "getPayload", "()Lokio/ByteString;", "newBuilder", "toString", "", "Builder", "Companion", "ActType", "InviteAtChatters", "Url", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class SystemMessageAction extends com.lark.wire.Message<SystemMessageAction, a> {
        public static final ProtoAdapter<SystemMessageAction> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final ByteString payload;
        private final ActType type;
        private final Integer type_num;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Content$SystemMessageAction$ActType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_ACT_TYPE", "INVITE_AT_CHATTERS", "URL", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum ActType extends Enum<ActType> implements o0 {
            public static final ProtoAdapter<ActType> ADAPTER = null;
            public static final b Companion = null;
            public static final ActType INVITE_AT_CHATTERS = null;
            public static final ActType UNKNOWN_ACT_TYPE = null;
            public static final ActType URL = null;
            public static final /* synthetic */ ActType[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<ActType> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    ActType.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return ActType.URL;
                L15:
                    return ActType.INVITE_AT_CHATTERS;
                L12:
                    return ActType.UNKNOWN_ACT_TYPE;
                }

                public a(KClass<ActType> r1, Syntax r2, ActType r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<ActType> getEntries() {
                return b;
            }

            static {
                ActType r0 = new ActType("UNKNOWN_ACT_TYPE", 0, 0);
                UNKNOWN_ACT_TYPE = r0;
                ActType r1 = new ActType("INVITE_AT_CHATTERS", 1, 1);
                INVITE_AT_CHATTERS = r1;
                ActType r3 = new ActType("URL", 2, 2);
                URL = r3;
                ActType[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(ActType.class), Syntax.PROTO_2, r0);
            }

            public static ActType[] values() {
                return (ActType[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final ActType fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return URL;
            L15:
                return INVITE_AT_CHATTERS;
            L12:
                return UNKNOWN_ACT_TYPE;
            }

            public static ActType valueOf(String r1) {
                return (ActType) r27.a.a(ActType.class, r1);
            }

            public ActType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Content$SystemMessageAction$InviteAtChatters;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Content$SystemMessageAction$InviteAtChatters$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Content$SystemMessageAction$InviteAtChatters$Builder;Lokio/ByteString;)V", "at_chatter_ids", "", "", "getAt_chatter_ids", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class InviteAtChatters extends com.lark.wire.Message<InviteAtChatters, a> {
            public static final ProtoAdapter<InviteAtChatters> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final List<Long> at_chatter_ids;

            public static final class a extends com.lark.wire.Message.a<InviteAtChatters, a> {
                public List<Long> d;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new InviteAtChatters(this, c(), null);
                }

                public a() {
                    this.d = CollectionsKt.emptyList();
                }
            }

            public static final class b extends ProtoAdapter<InviteAtChatters> {
                @Override // com.lark.wire.ProtoAdapter
                public final InviteAtChatters c(g0 r7) {
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    a r0 = new a();
                    ArrayList r1 = new ArrayList();
                    long r2 = r7.c();
                L3:
                    int r4 = r7.e();
                    if (r4 == (-1)) goto L9;
                    if (r4 == 1) goto L7;
                    r7.j(r4);
                    goto L3
                L7:
                    r1.add(ProtoAdapter.k.c(r7));
                    goto L3
                L9:
                    ByteString r8 = r7.d(r2);
                    Intrinsics.checkNotNullParameter(r1, "at_chatter_ids");
                    com.lark.wire.internal.a.a(r1);
                    r0.d = r1;
                    return new InviteAtChatters(r0, r8, null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(InviteAtChatters r4) {
                    InviteAtChatters r5 = r4;
                    Intrinsics.checkNotNullParameter(r5, "value");
                    return r5.unknownFields().size() + ProtoAdapter.k.a().l(1, r5.getAt_chatter_ids());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r4, InviteAtChatters r5) {
                    InviteAtChatters r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    ProtoAdapter.k.a().i(r4, 1, r6.getAt_chatter_ids());
                    r4.a(r6.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r3, InviteAtChatters r4) {
                    InviteAtChatters r5 = r4;
                    Intrinsics.checkNotNullParameter(r3, "writer");
                    Intrinsics.checkNotNullParameter(r5, "value");
                    r3.d(r5.unknownFields());
                    ProtoAdapter.k.a().j(r3, 1, r5.getAt_chatter_ids());
                }

                public b(FieldEncoding r7, KClass<InviteAtChatters> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.Content.SystemMessageAction.InviteAtChatters", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ InviteAtChatters(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(InviteAtChatters.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.at_chatter_ids;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(InviteAtChatters.class).getSimpleName() + '@' + hashCode();
            }

            public final List<Long> getAt_chatter_ids() {
                return this.at_chatter_ids;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public InviteAtChatters(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.at_chatter_ids = com.lark.wire.internal.a.c("at_chatter_ids", r2.d);
            }

            public /* synthetic */ InviteAtChatters(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0012\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Content$SystemMessageAction$Url;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Content$SystemMessageAction$Url$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Content$SystemMessageAction$Url$Builder;Lokio/ByteString;)V", "ios", "", "getIos", "()Ljava/lang/String;", "android", "getAndroid", "pc", "getPc", "web", "getWeb", "common", "getCommon", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class Url extends com.lark.wire.Message<Url, a> {
            public static final ProtoAdapter<Url> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final String android;
            private final String common;
            private final String ios;
            private final String pc;
            private final String web;

            public static final class a extends com.lark.wire.Message.a<Url, a> {
                public String d;
                public String e;
                public String f;
                public String g;
                public String h;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new Url(this, c(), null);
                }

                public a() {
                }
            }

            public static final class b extends ProtoAdapter<Url> {
                @Override // com.lark.wire.ProtoAdapter
                public final Url c(g0 r7) {
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    a r1 = new a();
                    long r2 = r7.c();
                L3:
                    int r4 = r7.e();
                    if (r4 == (-1)) goto L22;
                    if (r4 != 1) goto L8;
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    r1.d = r7.i();
                    goto L3
                L8:
                    if (r4 != 2) goto L10;
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    r1.e = r7.i();
                    goto L3
                L10:
                    if (r4 != 3) goto L12;
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    r1.f = r7.i();
                    goto L3
                L12:
                    if (r4 != 4) goto L14;
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    r1.g = r7.i();
                    goto L3
                L14:
                    if (r4 != 100) goto L15;
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    String r5 = r7.i();
                    Intrinsics.checkNotNullParameter(r5, "common");
                    r1.h = r5;
                    goto L3
                L15:
                    r7.j(r4);
                    Unit r6 = Unit.INSTANCE;
                    goto L3
                L22:
                    return new Url(r1, r7.d(r2), null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(Url r5) {
                    Url r6 = r5;
                    Intrinsics.checkNotNullParameter(r6, "value");
                    int r0 = r6.unknownFields().size();
                    w r1 = ProtoAdapter.q;
                    return ((((r0 + r1.l(1, r6.getIos())) + r1.l(2, r6.getAndroid())) + r1.l(3, r6.getPc())) + r1.l(4, r6.getWeb())) + r1.l(100, r6.getCommon());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r4, Url r5) {
                    Url r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    w r0 = ProtoAdapter.q;
                    r0.i(r4, 1, r6.getIos());
                    r0.i(r4, 2, r6.getAndroid());
                    r0.i(r4, 3, r6.getPc());
                    r0.i(r4, 4, r6.getWeb());
                    r0.i(r4, 100, r6.getCommon());
                    r4.a(r6.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r4, Url r5) {
                    Url r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    r4.d(r6.unknownFields());
                    w r0 = ProtoAdapter.q;
                    r0.j(r4, 100, r6.getCommon());
                    r0.j(r4, 4, r6.getWeb());
                    r0.j(r4, 3, r6.getPc());
                    r0.j(r4, 2, r6.getAndroid());
                    r0.j(r4, 1, r6.getIos());
                }

                public b(FieldEncoding r7, KClass<Url> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.Content.SystemMessageAction.Url", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ Url(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Url.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.ios;
                r0.e = this.android;
                r0.f = this.pc;
                r0.g = this.web;
                r0.h = this.common;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(Url.class).getSimpleName() + '@' + hashCode();
            }

            public final String getAndroid() {
                return this.android;
            }

            public final String getCommon() {
                return this.common;
            }

            public final String getIos() {
                return this.ios;
            }

            public final String getPc() {
                return this.pc;
            }

            public final String getWeb() {
                return this.web;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public Url(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.ios = r2.d;
                this.android = r2.e;
                this.pc = r2.f;
                this.web = r2.g;
                String r4 = r2.h;
                Intrinsics.checkNotNull(r4);
                this.common = r4;
            }

            public /* synthetic */ Url(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        public static final class a extends com.lark.wire.Message.a<SystemMessageAction, a> {
            public ActType d;
            public Integer e;
            public ByteString f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new SystemMessageAction(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<SystemMessageAction> {
            @Override // com.lark.wire.ProtoAdapter
            public final SystemMessageAction c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L19;
                if (r4 != 1) goto L8;
                r1.d = ActType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L8:
                if (r4 != 2) goto L10;
                r1.e = (Integer) ProtoAdapter.h.c(r10);
                goto L3
            L10:
                if (r4 != 3) goto L11;
                ProtoAdapter.p.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.f = r10.f();
                goto L3
            L11:
                r10.j(r4);
                goto L3
            L19:
                return new SystemMessageAction(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(SystemMessageAction r5) {
                SystemMessageAction r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return ((r6.unknownFields().size() + ActType.ADAPTER.l(1, r6.getType())) + ProtoAdapter.h.l(2, r6.getType_num())) + ProtoAdapter.p.l(3, r6.getPayload());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, SystemMessageAction r5) {
                SystemMessageAction r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ActType.ADAPTER.i(r4, 1, r6.getType());
                ProtoAdapter.h.i(r4, 2, r6.getType_num());
                ProtoAdapter.p.i(r4, 3, r6.getPayload());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, SystemMessageAction r5) {
                SystemMessageAction r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.p.j(r4, 3, r6.getPayload());
                ProtoAdapter.h.j(r4, 2, r6.getType_num());
                ActType.ADAPTER.j(r4, 1, r6.getType());
            }

            public b(FieldEncoding r7, KClass<SystemMessageAction> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Content.SystemMessageAction", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ SystemMessageAction(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(SystemMessageAction.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.type;
            r0.e = this.type_num;
            r0.f = this.payload;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(SystemMessageAction.class).getSimpleName() + '@' + hashCode();
        }

        public final ByteString getPayload() {
            return this.payload;
        }

        public final ActType getType() {
            return this.type;
        }

        public final Integer getType_num() {
            return this.type_num;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public SystemMessageAction(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.type = r2.d;
            this.type_num = r2.e;
            this.payload = r2.f;
        }

        public /* synthetic */ SystemMessageAction(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0003\bï\u0002\b\u0086\u0081\u0002\u0018\u0000 ò\u00022\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0002ò\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bMj\u0002\bNj\u0002\bOj\u0002\bPj\u0002\bQj\u0002\bRj\u0002\bSj\u0002\bTj\u0002\bUj\u0002\bVj\u0002\bWj\u0002\bXj\u0002\bYj\u0002\bZj\u0002\b[j\u0002\b\\j\u0002\b]j\u0002\b^j\u0002\b_j\u0002\b`j\u0002\baj\u0002\bbj\u0002\bcj\u0002\bdj\u0002\bej\u0002\bfj\u0002\bgj\u0002\bhj\u0002\bij\u0002\bjj\u0002\bkj\u0002\blj\u0002\bmj\u0002\bnj\u0002\boj\u0002\bpj\u0002\bqj\u0002\brj\u0002\bsj\u0002\btj\u0002\buj\u0002\bvj\u0002\bwj\u0002\bxj\u0002\byj\u0002\bzj\u0002\b{j\u0002\b|j\u0002\b}j\u0002\b~j\u0002\b\u007fj\u0003\b\u0080\u0001j\u0003\b\u0081\u0001j\u0003\b\u0082\u0001j\u0003\b\u0083\u0001j\u0003\b\u0084\u0001j\u0003\b\u0085\u0001j\u0003\b\u0086\u0001j\u0003\b\u0087\u0001j\u0003\b\u0088\u0001j\u0003\b\u0089\u0001j\u0003\b\u008a\u0001j\u0003\b\u008b\u0001j\u0003\b\u008c\u0001j\u0003\b\u008d\u0001j\u0003\b\u008e\u0001j\u0003\b\u008f\u0001j\u0003\b\u0090\u0001j\u0003\b\u0091\u0001j\u0003\b\u0092\u0001j\u0003\b\u0093\u0001j\u0003\b\u0094\u0001j\u0003\b\u0095\u0001j\u0003\b\u0096\u0001j\u0003\b\u0097\u0001j\u0003\b\u0098\u0001j\u0003\b\u0099\u0001j\u0003\b\u009a\u0001j\u0003\b\u009b\u0001j\u0003\b\u009c\u0001j\u0003\b\u009d\u0001j\u0003\b\u009e\u0001j\u0003\b\u009f\u0001j\u0003\b \u0001j\u0003\b¡\u0001j\u0003\b¢\u0001j\u0003\b£\u0001j\u0003\b¤\u0001j\u0003\b¥\u0001j\u0003\b¦\u0001j\u0003\b§\u0001j\u0003\b¨\u0001j\u0003\b©\u0001j\u0003\bª\u0001j\u0003\b«\u0001j\u0003\b¬\u0001j\u0003\b\u00ad\u0001j\u0003\b®\u0001j\u0003\b¯\u0001j\u0003\b°\u0001j\u0003\b±\u0001j\u0003\b²\u0001j\u0003\b³\u0001j\u0003\b´\u0001j\u0003\bµ\u0001j\u0003\b¶\u0001j\u0003\b·\u0001j\u0003\b¸\u0001j\u0003\b¹\u0001j\u0003\bº\u0001j\u0003\b»\u0001j\u0003\b¼\u0001j\u0003\b½\u0001j\u0003\b¾\u0001j\u0003\b¿\u0001j\u0003\bÀ\u0001j\u0003\bÁ\u0001j\u0003\bÂ\u0001j\u0003\bÃ\u0001j\u0003\bÄ\u0001j\u0003\bÅ\u0001j\u0003\bÆ\u0001j\u0003\bÇ\u0001j\u0003\bÈ\u0001j\u0003\bÉ\u0001j\u0003\bÊ\u0001j\u0003\bË\u0001j\u0003\bÌ\u0001j\u0003\bÍ\u0001j\u0003\bÎ\u0001j\u0003\bÏ\u0001j\u0003\bÐ\u0001j\u0003\bÑ\u0001j\u0003\bÒ\u0001j\u0003\bÓ\u0001j\u0003\bÔ\u0001j\u0003\bÕ\u0001j\u0003\bÖ\u0001j\u0003\b×\u0001j\u0003\bØ\u0001j\u0003\bÙ\u0001j\u0003\bÚ\u0001j\u0003\bÛ\u0001j\u0003\bÜ\u0001j\u0003\bÝ\u0001j\u0003\bÞ\u0001j\u0003\bß\u0001j\u0003\bà\u0001j\u0003\bá\u0001j\u0003\bâ\u0001j\u0003\bã\u0001j\u0003\bä\u0001j\u0003\bå\u0001j\u0003\bæ\u0001j\u0003\bç\u0001j\u0003\bè\u0001j\u0003\bé\u0001j\u0003\bê\u0001j\u0003\bë\u0001j\u0003\bì\u0001j\u0003\bí\u0001j\u0003\bî\u0001j\u0003\bï\u0001j\u0003\bð\u0001j\u0003\bñ\u0001j\u0003\bò\u0001j\u0003\bó\u0001j\u0003\bô\u0001j\u0003\bõ\u0001j\u0003\bö\u0001j\u0003\b÷\u0001j\u0003\bø\u0001j\u0003\bù\u0001j\u0003\bú\u0001j\u0003\bû\u0001j\u0003\bü\u0001j\u0003\bý\u0001j\u0003\bþ\u0001j\u0003\bÿ\u0001j\u0003\b\u0080\u0002j\u0003\b\u0081\u0002j\u0003\b\u0082\u0002j\u0003\b\u0083\u0002j\u0003\b\u0084\u0002j\u0003\b\u0085\u0002j\u0003\b\u0086\u0002j\u0003\b\u0087\u0002j\u0003\b\u0088\u0002j\u0003\b\u0089\u0002j\u0003\b\u008a\u0002j\u0003\b\u008b\u0002j\u0003\b\u008c\u0002j\u0003\b\u008d\u0002j\u0003\b\u008e\u0002j\u0003\b\u008f\u0002j\u0003\b\u0090\u0002j\u0003\b\u0091\u0002j\u0003\b\u0092\u0002j\u0003\b\u0093\u0002j\u0003\b\u0094\u0002j\u0003\b\u0095\u0002j\u0003\b\u0096\u0002j\u0003\b\u0097\u0002j\u0003\b\u0098\u0002j\u0003\b\u0099\u0002j\u0003\b\u009a\u0002j\u0003\b\u009b\u0002j\u0003\b\u009c\u0002j\u0003\b\u009d\u0002j\u0003\b\u009e\u0002j\u0003\b\u009f\u0002j\u0003\b \u0002j\u0003\b¡\u0002j\u0003\b¢\u0002j\u0003\b£\u0002j\u0003\b¤\u0002j\u0003\b¥\u0002j\u0003\b¦\u0002j\u0003\b§\u0002j\u0003\b¨\u0002j\u0003\b©\u0002j\u0003\bª\u0002j\u0003\b«\u0002j\u0003\b¬\u0002j\u0003\b\u00ad\u0002j\u0003\b®\u0002j\u0003\b¯\u0002j\u0003\b°\u0002j\u0003\b±\u0002j\u0003\b²\u0002j\u0003\b³\u0002j\u0003\b´\u0002j\u0003\bµ\u0002j\u0003\b¶\u0002j\u0003\b·\u0002j\u0003\b¸\u0002j\u0003\b¹\u0002j\u0003\bº\u0002j\u0003\b»\u0002j\u0003\b¼\u0002j\u0003\b½\u0002j\u0003\b¾\u0002j\u0003\b¿\u0002j\u0003\bÀ\u0002j\u0003\bÁ\u0002j\u0003\bÂ\u0002j\u0003\bÃ\u0002j\u0003\bÄ\u0002j\u0003\bÅ\u0002j\u0003\bÆ\u0002j\u0003\bÇ\u0002j\u0003\bÈ\u0002j\u0003\bÉ\u0002j\u0003\bÊ\u0002j\u0003\bË\u0002j\u0003\bÌ\u0002j\u0003\bÍ\u0002j\u0003\bÎ\u0002j\u0003\bÏ\u0002j\u0003\bÐ\u0002j\u0003\bÑ\u0002j\u0003\bÒ\u0002j\u0003\bÓ\u0002j\u0003\bÔ\u0002j\u0003\bÕ\u0002j\u0003\bÖ\u0002j\u0003\b×\u0002j\u0003\bØ\u0002j\u0003\bÙ\u0002j\u0003\bÚ\u0002j\u0003\bÛ\u0002j\u0003\bÜ\u0002j\u0003\bÝ\u0002j\u0003\bÞ\u0002j\u0003\bß\u0002j\u0003\bà\u0002j\u0003\bá\u0002j\u0003\bâ\u0002j\u0003\bã\u0002j\u0003\bä\u0002j\u0003\bå\u0002j\u0003\bæ\u0002j\u0003\bç\u0002j\u0003\bè\u0002j\u0003\bé\u0002j\u0003\bê\u0002j\u0003\bë\u0002j\u0003\bì\u0002j\u0003\bí\u0002j\u0003\bî\u0002j\u0003\bï\u0002j\u0003\bð\u0002j\u0003\bñ\u0002¨\u0006ó\u0002"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Content$SystemType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "USER_MODIFY_GROUP_NAME", "USER_MODIFY_GROUP_AVATAR", "USER_MODIFY_GROUP_DESCRIPTION", "USER_MODIFY_GROUP_SETTINGS", "USER_START_GROUP_AND_INVITE", "SYSTEM_WELCOME_USER", "USER_INVITE_OTHERS_JOIN", "USER_QUIT_GROUP", "USER_REMOVE_OTHERS", "USER_REMOVE_GROUP_DESCRIPTION", "USER_CHECK_OTHERS_TELEPHONE", "DERIVE_FROM_P2P_CHAT", "USER_JOIN_VIA_SHARE", "TRANSFER_GROUP_CHAT_OWNER", "TRANSFER_GROUP_CHAT_OWNER_AND_QUIT", "WIPE_ANNOUNCEMENT", "ADD_EMAIL_MEMBERS", "REMOVE_EMAIL_MEMBERS", "MODIFY_EMAIL_MEMBERS", "USER_MODIFY_EMAIL_SUBJECT", "USER_SYNC_MESSAGE", "USER_MODIFY_THREAD_TOPIC", "USER_INVITE_OTHERS_JOIN_CRYPTO_CHAT", "USER_START_CRYPTO_GROUP_AND_INVITE", "USER_CALL_E2EE_VOICE_ON_CANCELL", "USER_CALL_E2EE_VOICE_ON_MISSING", "USER_CALL_E2EE_VOICE_DURATION", "VC_CALL_HOST_CANCEL", "VC_CALL_PARTI_NO_ANSWER", "VC_CALL_PARTI_CANCEL", "VC_CALL_HOST_BUSY", "VC_CALL_PARTI_BUSY", "VC_CALL_FINISH_NOTICE", "VC_CALL_DURATION", "USER_START_MEETING_GROUP_AND_INVITE", "USER_INVITE_OTHERS_JOIN_MEETING", "USER_QUIT_MEETING_CHAT", "USER_DISMISSED_MEETING_CHAT", "USER_START_GROUP", "USER_REMOVE_OTHERS_FROM_MEETING", "USER_ADD_MEETING_CHAT", "JOIN_DEPARTMENT_GROUP", "BUILD_FRIENDSHIP", "NON_FRIENDS_NOTICE", "DECLINE_INVITATION", "DECLINE_SPEC_INVITATION", "USER_JOIN_VIA_QR_CODE", "VC_CALL_CONNECT_FAIL", "VC_CALL_DISCONNECT", "USER_CALL_E2EE_VOICE_WHEN_REFUSED", "USER_CALL_E2EE_VOICE_WHEN_OCCUPY", "GRAB_OTHER_HONGBAO", "OTHER_GRAB_MY_HONGBAO", "LAST_HONGBAO_IS_GRABBED", "SEND_HONGBAO_MESSAGE_FAILED", "USER_SYNC_MESSAGE_V2", "USER_SHARE_DOC_PERMISSION", "USER_CHANGE_DOC_PERMISSION", "USER_SHARE_DOC_FOLDER", "USER_OPEN_ONLY_ADMIN_POST", "USER_SEPECIFY_MEMBERS_POST", "USER_LOW_VERSION_HINT", "USER_THREAD_CLEAR_TITLE", "USER_OPEN_ANYONE_POST", "CRYPTO_MESSAGE_NOTICE_NO_TRANSMIT", "CRYPTO_MESSAGE_NOTICE_SEVEN_DAYS", "CRYPTO_MESSAGE_NOTICE_BURN_AFTER_READING", "USER_SET_CRYPTO_MESSAGE_BURN_LIFE", "USER_TOOK_SCREENSHOT_IN_CRYPTO_CHAT", "CRYPTO_LOW_VERSION_HINT", "INVITE_CHAT_MEMBER_2_OUT_CHAT", "CREATE_CHAT_AND_INVITE_FROM_CHAT_MEMBER", "AUTO_TRANSLATE_GUIDANCE", "WITHDRAW_ADDED_USER", "SAIPAN_REMIND_ONCALL_REPLY", "SAIPAN_REMIND_ONCALL_DONE", "SAIPAN_REMIND_ONCALL_AUTO_DONE", "SAIPAN_ADD_ONCALL", "VC_MEETING_STARTED", "USER_OPEN_ONLY_ADMIN_POST_THREAD", "USER_SPECIFY_MEMBERS_POST_THREAD", "USER_OPEN_ANYONE_POST_THREAD", "VC_MEETING_ENDED_OVER_ONE_HOUR", "INVITE_AT_CHATTERS", "VC_MEETING_ENDED_LESS_ONE_HOUR", "VC_MEETING_ENDED_LESS_ONE_MIN", "VC_DEFAULT_MEETING_ENDED_OVER_ONE_HOUR", "VC_DEFAULT_MEETING_ENDED_LESS_ONE_HOUR", "VC_DEFAULT_MEETING_ENDED_LESS_ONE_MIN", "VC_VIDEO_CHAT_STARTED", "VC_CALL_ENDED_OVER_ONE_HOUR", "VC_CALL_ENDED_LESS_ONE_HOUR", "VC_CALL_ENDED_LESS_ONE_MIN", "VC_CALL_DISCONNECTED_ENDED_OVER_ONE_HOUR", "VC_CALL_DISCONNECTED_ENDED_LESS_ONE_HOUR", "VC_CALL_DISCONNECTED_ENDED_LESS_ONE_MIN", "VC_CALL_INTERVIEWEE_NO_ANSWER", "VC_CALL_INTERVIEWEE_REFUSE", "VC_CALL_INTERVIEWER_CANCEL", "VC_CALL_INTERVIEWEE_BUSY", "VOIP_ENDED_OVER_ONE_HOUR", "VOIP_ENDED_LESS_ONE_HOUR", "VOIP_ENDED_LESS_ONE_MIN", "VOIP_DISCONNECTED_ENDED_OVER_ONE_HOUR", "VOIP_DISCONNECTED_ENDED_LESS_ONE_HOUR", "VOIP_DISCONNECTED_ENDED_LESS_ONE_MIN", "VOIP_INTERVIEWEE_NO_ANSWER", "VOIP_INTERVIEWEE_REFUSE", "VOIP_INTERVIEWER_CANCEL", "VOIP_INTERVIEWEE_BUSY", "SAIPAN_SELECT_CARD_CONTENT", "SAIPAN_USER_QUEUEING", "SAIPAN_NOTIFY_AGENT_QUEUEING", "SAIPAN_RESERVED_3", "SAIPAN_RESERVED_4", "SAIPAN_RESERVED_5", "CANCEL_EMERGENCY_CALL", "HANGUP_EMERGENCY_CALL", "START_EMERGENCY_CALL", "MEETING_TRANSFER_TO_CHAT", "MEETING_TRANSFER_TO_CHAT_WITH_DOC_URL", "VC_CALL_INTERVIEWEE_NOT_ONLINE", "VOIP_INTERVIEWEE_NOT_ONLINE", "USER_JOIN_CHAT_AUTO_MUTE", "EMERGENCY_CALL_NOTANSWER", "INVITE_CHATTERS_TO_CHAT_NO_PERMISSION_LESS_THRESHOLD", "INVITE_CHATTERS_TO_CHAT_NO_PERMISSION_OVER_THRESHOLD", "CHAT_ROOM_START", "USER_TURN_ON_GROUP_MAIL", "USER_TURN_OFF_GROUP_MAIL", "USER_CHANGE_GROUP_MAIL_PERMISSION_OWNER", "USER_CHANGE_GROUP_MAIL_PERMISSION_MEMBERS", "USER_CHANGE_GROUP_MAIL_PERMISSION_TENANT", "USER_CHANGE_GROUP_MAIL_PERMISSION_EVERYONE", "USER_JOIN_VIA_GROUP_LINK", "CHAT_ROOM_END", "CHAT_ROOM_START_V2", "SYSTEM_EPHEMERAL_NOTIFY", "BUILD_ONEWAY_RELATION", "INVITE_FRIENDS_SUCCESS", "CREATE_P2P_SOURCE", "SEND_MESSAGE_COLLABORATION_AUTH_FAILED", "NOT_COLLABORATION_AUTH_SEND_MSG_LIMIT_NOTIFY", "NOT_COLLABORATION_AUTH_SEND_MSG_REACH_LIMIT", "USER_INVITE_BOT_JOIN", "DOC_TEMPLATE_GROUP_SHARE", "SHEET_TEMPLATE_GROUP_SHARE", "MIND_NOTE_TEMPLATE_GROUP_SHARE", "CantChatUserPrivacySettings", "CREATE_CIRCLE_AND_INVITE_OTHERS_FROM_CHAT", "MENTIONED_PERSON_NOT_IN_CIRCLE", "INVITE_MEMBERS_TO_JOIN_EXTERNAL_CIRCLE", "CIRCLE_CANT_ADD_MEMBERS_DUE_TO_ADMIN_SETTINGS", "CIRCLE_CANT_ADD_MANY_MEMBERS_DUE_TO_ADMIN_SETTINGS", "JOIN_CIRCLE_VIA_HELP_DESK_MSG_CARD", "CIRCLE_WELCOME_NEW_MEMBERS", "TRANSFER_CIRCLE_OWNER", "TRANSFER_CIRCLE_OWNER_AND_LEAVE", "CIRCLE_USER_CHANGE_DOC_PERMISSION", "USER_INVITE_BOT_JOIN_CIRCLE", "USER_INVITE_OTHERS_JOIN_CIRCLE", "USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK", "CIRCLE_TOO_MANY_MEMBERS_NOTIFICATION_MUTED", "USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE", "USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD", "USER_MODIFY_CIRCLE_AVATAR", "USER_MODIFY_CIRCLE_DESCRIPTION", "USER_MODIFY_CIRCLE_NAME", "USER_MODIFY_CIRCLE_OWNER", "USER_MODIFY_CIRCLE_SETTINGS", "USER_SET_ONLY_CIRCLE_OWNER_CAN_POST", "USER_SET_ONLY_CIRCLE_OWNER_CAN_CREATE_NEW_TOPICS", "USER_LEAVE_CIRCLE", "USER_REMOVE_CIRCLE_DESCRIPTION", "USER_REMOVE_CIRCLE_MEMBERS", "USER_CREATE_CIRCLE", "USER_CREATE_CIRCLE_AND_INVITE", "USER_SYNC_MESSAGE_TO_CIRCLE", "USER_CLEAR_CIRCLE_ANNOUNCEMENT", "USER_WITHDRAW_CIRCLE_INVITATION", "CIRCLE_ANONYMOUS_ON", "CIRCLE_ANONYMOUS_OFF", "Lark_IM_CreateGroup_UserAndGroup_OwnerInvite", "Lark_IM_CreateGroup_UserAndGroup_MemberInvite", "Lark_IM_CreateGroup_UserAndDepartment_OwnerInvite", "Lark_IM_CreateGroup_UserAndDepartment_MemberInivite", "Lark_IM_CreateGroup_GroupAndDepartment_OwnerInvite", "Lark_IM_CreateGroup_GroupAndDepartment_MemberInvite", "Lark_IM_CreateGroup_UserAndGroupAndDepartment_OwnerInvite", "Lark_IM_CreateGroup_UserAndGroupAndDepartment_MemberInvite", "Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_Inviter", "Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_Inviter", "Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_Invitee", "Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_Invitee", "Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_OtherMembers", "Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_OtherMembers", "Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_Inviter", "Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_Inviter", "Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_Invitee", "Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_Invitee", "Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_OtherMembers", "Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_OtherMembers", "Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_Inviter", "Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_Inviter", "Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_Invitee", "Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_Invitee", "Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_OtherMembers", "Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_OtherMembers", "Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_Inviter", "Lark_IM_EnterGroup_Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_Inviter", "Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_Invitee", "Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_Invitee", "Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_OtherMembers", "Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_OtherMembers", "Lark_IM_EnterGroup_User_ChatHistoryYes_FromTeam", "Lark_IM_Server_WelcomeTo_Text", "INVITE_CHAT_MEMBER_2_CHAT", "WILL_REACH_CHAT_CHATTER_COUNT_LIMIT", "ALREADY_REACH_CHAT_CHATTER_COUNT_LIMIT", "USER_CREATE_FACE_TO_FACE_CHAT", "USER_JOIN_FACE_TO_FACE_CHAT", "WELCOME_USER_JOIN_FACE_TO_FACE_CHAT", "USER_CREATED_GROUP_AND_INVITED_OTHER_CHATTER_CHAT_DEPARTMENT", "USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN", "CREATE_CHAT_AND_INVITE_FROM_CHAT_DEPARTMENT_MEMBER", "USER_OPEN_ONLY_SEPECIFY_MEMBERS_POST", "USER_OPEN_ONLY_SEPECIFY_MEMBERS_POST_THREAD", "USER_REMOVE_SEPECIFY_MEMBERS_POST", "USER_REMOVE_SEPECIFY_MEMBERS_POST_THREAD", "ADD_MEMBER_TO_ADMIN_LIST", "REMOVE_MEMBER_FROM_ADMIN_LIST", "USER_OPEN_ONLY_OWNER_AND_ADMIN_POST", "USER_OPEN_ONLY_OWNER_AND_ADMIN_POST_THREAD", "ADMIN_OPEN_ANYONE_POST", "ADMIN_OPEN_ANYONE_POST_THREAD", "USER_CHANGE_GROUP_MAIL_PERMISSION_OWNER_OR_ADMIN", "GROUP_NEW_MEMBERS_VIEW_CHAT_HISTORY_ON", "GROUP_NEW_MEMBERS_VIEW_CHAT_HISTORY_OFF", "GROUP_NEW_MEMBERS_CAN_VIEW_HISTORY_MESSAGES", "CIRCLE_WELCOME_NEW_MEMBERS_NO_HISTORY", "JOIN_CIRCLE_VIA_HELP_DESK_MSG_CARD_NO_HISTORY", "USER_INVITE_OTHERS_JOIN_CIRCLE_NO_HISTORY", "USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD_NO_HISTORY", "USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK_NO_HISTORY", "USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE_NO_HISTORY", "USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN_NEW", "USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN_NO_HISTORY", "USER_JOIN_VIA_QR_NEW", "USER_JOIN_VIA_QR_CODE_NO_HISTORY", "USER_JOIN_CHAT_WELCOME_MESSAGE", "USER_JOIN_CHAT_WELCOME_MESSAGE_NO_HISTORY", "USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE", "USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE_NO_HISTORY", "USER_JOIN_VIA_SHARE_NEW", "USER_JOIN_VIA_SHARE_NO_HISTORY", "USER_JOIN_CHAT_BY_LINK", "USER_JOIN_CHAT_BY_LINK_NO_HISTORY", "HELP_DESK_USER_JOIN_CHAT", "HELP_DESK_USER_JOIN_CHAT_NO_HISTORY", "UPGRADE_SUPER_CHAT", "CREATE_URGENT_ONLY_OWNER_AND_ADMIN_ON", "CREATE_URGENT_ONLY_OWNER_AND_ADMIN_OFF", "AUTO_OPEN_TYPING_TRANSLATE", "ONLY_ADMIN_CAN_MANAGE_CHAT_TAB", "ALL_MEMBERS_CAN_MANAGE_CHAT_TAB", "ALL_MEMBERS_CAN_MANAGE_TabsMenuWidgets", "ONLY_ADMIN_CAN_MANAGE_TabsMenuWidgets", "ALL_MEMBERS_CAN_MANAGE_TabsMenuWidgetsV1", "ONLY_ADMIN_CAN_MANAGE_TabsMenuWidgetsV1", "ALL_MEMBERS_CHAT_URL_TOP_NOTICE_HIGH_V_NORMAL", "CAN_MANAGER_CHAT_URL_TOP_NOTICE_HIGH_V_NORMAL", "ALL_MEMBERS_CHAT_URL_TOP_NOTICE_HIGH_V_THREAD", "CAN_MANAGER_CHAT_URL_TOP_NOTICE_HIGH_V_THREAD", "ALL_MEMBERS_CHAT_URL_TOP_NOTICE_LOW_V_NORMAL", "CAN_MANAGER_CHAT_URL_TOP_NOTICE_LOW_V_NORMAL", "ALL_MEMBERS_CHAT_URL_TOP_NOTICE_LOW_V_THREAD", "CAN_MANAGER_CHAT_URL_TOP_NOTICE_LOW_V_THREAD", "EXTERNAL_COORDINATE_CTL", "TARGET_EXTERNAL_COORDINATE_CTL", "CHAT_OPEN_CAN_SEARCH_SYSTEM_MESSAGE", "CHAT_CLOSED_CAN_SEARCH_SYSTEM_MESSAGE", "BITABLE_TEMPLATE_GROUP_SHARE_SYSTEM_MESSAGE", "MANUAL_OPEN_TYPING_TRANSLATE", "AUTO_OPEN_TYPING_TRANSLATE_V1", "CREATE_TEAM_AND_INVITE_MEMBERS", "UPDATE_CHAT_TO_TEAM", "INVITE_MEMBERS_JOIN_TEAM", "MEMBERS_JOIN_TEAM_FAIL", "KICK_MEMBERS_OUT_TEAM", "MEMBER_LEAVE_TEAM", "TRANSFER_TEAM_OWNER", "MODIFY_TEAM_NAME", "ENABLE_TEAM_CREATE_CHAT_PERMISSION", "CLOSE_TEAM_CREATE_CHAT_PERMISSION", "ENABLE_TEAM_ADD_MEMBERS_PERMISSION", "CLOSE_TEAM_ADD_MEMBERS_PERMISSION", "DISSOLVE_TEAM_AND_UNBIND_CHAT", "CREATE_TEAM_CHAT", "BIND_CHAT_INTO_TEAM", "UNBIND_CHAT_WITH_TEAM", "MEMBERS_JOIN_TEAM_CHAT_SEE_HISTORICAL", "MEMBERS_JOIN_TEAM_CHAT_SEE_NEW_MESSAGES", "MEMBERS_JOIN_TEAM_CHAT_FAIL", "MEMBERS_LEAVE_AND_TRANSFER", "USER_CREATE_TEAM", "CHECK_USER_PHONE_NUMBER", "CHECK_USER_PHONE_USER_IN_WHITELIST", "CantBuzzEmptyPhoneNumber", "CantBuzzEmptyName", "BuzzLimit", "BuzzSystemError", "BuzzTimeOut", "CantBuzzMembers", "BuzzNotAnswer", "MultiItemSystemContent", "VC_ENTERPRISE_PHONE_CREATE", "MODIFY_TEAM_AVATAR", "MODIFY_TEAM_DESCRIPTION", "DELETE_TEAM_DESCRIPTION", "CREATE_TEAM_CHAT_V2_MANAGER", "BIND_CHAT_INTO_TEAM_MANAGER", "USER_JOIN_CHAT_FROM_TEAM", "TEAM_CHAT_TURN_OPEN_MESSAGE_TO_TEAM", "TEAM_CHAT_TURN_OPEN_MESSAGE", "SIMPLIFY_OTHER_GRAB_MY_HONGBAO", "SIMPLIFY_OTHER_GRAB_MY_HONGBAO_NOT_OVER_OUT_NUM", "SIMPLIFY_USER_INVITE_OTHERS_JOIN", "SIMPLIFY_USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE_NO_HISTORY", "SIMPLIFY_SYSTEM_WELCOME_USER", "SIMPLIFY_USER_JOIN_CHAT_WELCOME_MESSAGE", "SIMPLIFY_USER_JOIN_CHAT_WELCOME_MESSAGE_NO_HISTORY", "SIMPLIFY_CIRCLE_WELCOME_NEW_MEMBERS", "SIMPLIFY_USER_JOIN_VIA_SHARE", "SIMPLIFY_USER_JOIN_VIA_SHARE_NO_HISTORY", "SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD", "SIMPLIFY_USER_JOIN_VIA_QR_CODE", "SIMPLIFY_USER_JOIN_VIA_QR_CODE_NO_HISTORY", "SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE", "SIMPLIFY_USER_JOIN_VIA_GROUP_LINK", "SIMPLIFY_USER_JOIN_CHAT_BY_LINK_NO_HISTORY", "SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK", "SIMPLIFY_WELCOME_USER_JOIN_FACE_TO_FACE_CHAT", "SIMPLIFY_USER_JOIN_CHAT_FROM_TEAM", "SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE", "HIGHLIGHT_MESSAGES_FROM_CONTACT_TO_STAY_INFORMED", "MyAI_NewTopicTip", "MyAI_SceneTopicDynamicTip", "Lark_IM_BotCustomization", "MANUAL_OPEN_TYPING_TRANSLATE_PROMPTS", "CHAT_USER_LARGE_CHAT_AUTO_MUTE", "CHAT_USER_BOT_AUTO_MUTE", "CHAT_USER_BOT_AUTO_MUTE_S", "CHAT_USER_P2P_BOT_AUTO_MUTE", "DOUBAO_SHOW_NEW_CONTACT", "DOUBAO_SHOW_READ_TIP", "DOUBAO_SHOW_JOIN_CHAT", "DOUBAO_SHOW_JOIN_CHAT_STRANGER", "DOUBAO_SHOW_NEW_CONTACT_NO_GREETING", "DOUBAO_SHOW_NEW_CONTACT_NO_GREETING_READ_STATUS", "LOCAL_MENTION_BOTS_NOT_IN_CHAT", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum SystemType extends Enum<SystemType> implements o0 {
        public static final ProtoAdapter<SystemType> ADAPTER = null;
        public static final SystemType ADD_EMAIL_MEMBERS = null;
        public static final SystemType ADD_MEMBER_TO_ADMIN_LIST = null;
        public static final SystemType ADMIN_OPEN_ANYONE_POST = null;
        public static final SystemType ADMIN_OPEN_ANYONE_POST_THREAD = null;
        public static final SystemType ALL_MEMBERS_CAN_MANAGE_CHAT_TAB = null;
        public static final SystemType ALL_MEMBERS_CAN_MANAGE_TabsMenuWidgets = null;
        public static final SystemType ALL_MEMBERS_CAN_MANAGE_TabsMenuWidgetsV1 = null;
        public static final SystemType ALL_MEMBERS_CHAT_URL_TOP_NOTICE_HIGH_V_NORMAL = null;
        public static final SystemType ALL_MEMBERS_CHAT_URL_TOP_NOTICE_HIGH_V_THREAD = null;
        public static final SystemType ALL_MEMBERS_CHAT_URL_TOP_NOTICE_LOW_V_NORMAL = null;
        public static final SystemType ALL_MEMBERS_CHAT_URL_TOP_NOTICE_LOW_V_THREAD = null;
        public static final SystemType ALREADY_REACH_CHAT_CHATTER_COUNT_LIMIT = null;
        public static final SystemType AUTO_OPEN_TYPING_TRANSLATE = null;
        public static final SystemType AUTO_OPEN_TYPING_TRANSLATE_V1 = null;
        public static final SystemType AUTO_TRANSLATE_GUIDANCE = null;
        public static final SystemType BIND_CHAT_INTO_TEAM = null;
        public static final SystemType BIND_CHAT_INTO_TEAM_MANAGER = null;
        public static final SystemType BITABLE_TEMPLATE_GROUP_SHARE_SYSTEM_MESSAGE = null;
        public static final SystemType BUILD_FRIENDSHIP = null;
        public static final SystemType BUILD_ONEWAY_RELATION = null;
        public static final SystemType BuzzLimit = null;
        public static final SystemType BuzzNotAnswer = null;
        public static final SystemType BuzzSystemError = null;
        public static final SystemType BuzzTimeOut = null;
        public static final SystemType CANCEL_EMERGENCY_CALL = null;
        public static final SystemType CAN_MANAGER_CHAT_URL_TOP_NOTICE_HIGH_V_NORMAL = null;
        public static final SystemType CAN_MANAGER_CHAT_URL_TOP_NOTICE_HIGH_V_THREAD = null;
        public static final SystemType CAN_MANAGER_CHAT_URL_TOP_NOTICE_LOW_V_NORMAL = null;
        public static final SystemType CAN_MANAGER_CHAT_URL_TOP_NOTICE_LOW_V_THREAD = null;
        public static final SystemType CHAT_CLOSED_CAN_SEARCH_SYSTEM_MESSAGE = null;
        public static final SystemType CHAT_OPEN_CAN_SEARCH_SYSTEM_MESSAGE = null;
        public static final SystemType CHAT_ROOM_END = null;
        public static final SystemType CHAT_ROOM_START = null;
        public static final SystemType CHAT_ROOM_START_V2 = null;
        public static final SystemType CHAT_USER_BOT_AUTO_MUTE = null;
        public static final SystemType CHAT_USER_BOT_AUTO_MUTE_S = null;
        public static final SystemType CHAT_USER_LARGE_CHAT_AUTO_MUTE = null;
        public static final SystemType CHAT_USER_P2P_BOT_AUTO_MUTE = null;
        public static final SystemType CHECK_USER_PHONE_NUMBER = null;
        public static final SystemType CHECK_USER_PHONE_USER_IN_WHITELIST = null;
        public static final SystemType CIRCLE_ANONYMOUS_OFF = null;
        public static final SystemType CIRCLE_ANONYMOUS_ON = null;
        public static final SystemType CIRCLE_CANT_ADD_MANY_MEMBERS_DUE_TO_ADMIN_SETTINGS = null;
        public static final SystemType CIRCLE_CANT_ADD_MEMBERS_DUE_TO_ADMIN_SETTINGS = null;
        public static final SystemType CIRCLE_TOO_MANY_MEMBERS_NOTIFICATION_MUTED = null;
        public static final SystemType CIRCLE_USER_CHANGE_DOC_PERMISSION = null;
        public static final SystemType CIRCLE_WELCOME_NEW_MEMBERS = null;
        public static final SystemType CIRCLE_WELCOME_NEW_MEMBERS_NO_HISTORY = null;
        public static final SystemType CLOSE_TEAM_ADD_MEMBERS_PERMISSION = null;
        public static final SystemType CLOSE_TEAM_CREATE_CHAT_PERMISSION = null;
        public static final SystemType CREATE_CHAT_AND_INVITE_FROM_CHAT_DEPARTMENT_MEMBER = null;
        public static final SystemType CREATE_CHAT_AND_INVITE_FROM_CHAT_MEMBER = null;
        public static final SystemType CREATE_CIRCLE_AND_INVITE_OTHERS_FROM_CHAT = null;
        public static final SystemType CREATE_P2P_SOURCE = null;
        public static final SystemType CREATE_TEAM_AND_INVITE_MEMBERS = null;
        public static final SystemType CREATE_TEAM_CHAT = null;
        public static final SystemType CREATE_TEAM_CHAT_V2_MANAGER = null;
        public static final SystemType CREATE_URGENT_ONLY_OWNER_AND_ADMIN_OFF = null;
        public static final SystemType CREATE_URGENT_ONLY_OWNER_AND_ADMIN_ON = null;
        public static final SystemType CRYPTO_LOW_VERSION_HINT = null;
        public static final SystemType CRYPTO_MESSAGE_NOTICE_BURN_AFTER_READING = null;
        public static final SystemType CRYPTO_MESSAGE_NOTICE_NO_TRANSMIT = null;
        public static final SystemType CRYPTO_MESSAGE_NOTICE_SEVEN_DAYS = null;
        public static final SystemType CantBuzzEmptyName = null;
        public static final SystemType CantBuzzEmptyPhoneNumber = null;
        public static final SystemType CantBuzzMembers = null;
        public static final SystemType CantChatUserPrivacySettings = null;
        public static final b Companion = null;
        public static final SystemType DECLINE_INVITATION = null;
        public static final SystemType DECLINE_SPEC_INVITATION = null;
        public static final SystemType DELETE_TEAM_DESCRIPTION = null;
        public static final SystemType DERIVE_FROM_P2P_CHAT = null;
        public static final SystemType DISSOLVE_TEAM_AND_UNBIND_CHAT = null;
        public static final SystemType DOC_TEMPLATE_GROUP_SHARE = null;
        public static final SystemType DOUBAO_SHOW_JOIN_CHAT = null;
        public static final SystemType DOUBAO_SHOW_JOIN_CHAT_STRANGER = null;
        public static final SystemType DOUBAO_SHOW_NEW_CONTACT = null;
        public static final SystemType DOUBAO_SHOW_NEW_CONTACT_NO_GREETING = null;
        public static final SystemType DOUBAO_SHOW_NEW_CONTACT_NO_GREETING_READ_STATUS = null;
        public static final SystemType DOUBAO_SHOW_READ_TIP = null;
        public static final SystemType EMERGENCY_CALL_NOTANSWER = null;
        public static final SystemType ENABLE_TEAM_ADD_MEMBERS_PERMISSION = null;
        public static final SystemType ENABLE_TEAM_CREATE_CHAT_PERMISSION = null;
        public static final SystemType EXTERNAL_COORDINATE_CTL = null;
        public static final SystemType GRAB_OTHER_HONGBAO = null;
        public static final SystemType GROUP_NEW_MEMBERS_CAN_VIEW_HISTORY_MESSAGES = null;
        public static final SystemType GROUP_NEW_MEMBERS_VIEW_CHAT_HISTORY_OFF = null;
        public static final SystemType GROUP_NEW_MEMBERS_VIEW_CHAT_HISTORY_ON = null;
        public static final SystemType HANGUP_EMERGENCY_CALL = null;
        public static final SystemType HELP_DESK_USER_JOIN_CHAT = null;
        public static final SystemType HELP_DESK_USER_JOIN_CHAT_NO_HISTORY = null;
        public static final SystemType HIGHLIGHT_MESSAGES_FROM_CONTACT_TO_STAY_INFORMED = null;
        public static final SystemType INVITE_AT_CHATTERS = null;
        public static final SystemType INVITE_CHATTERS_TO_CHAT_NO_PERMISSION_LESS_THRESHOLD = null;
        public static final SystemType INVITE_CHATTERS_TO_CHAT_NO_PERMISSION_OVER_THRESHOLD = null;
        public static final SystemType INVITE_CHAT_MEMBER_2_CHAT = null;
        public static final SystemType INVITE_CHAT_MEMBER_2_OUT_CHAT = null;
        public static final SystemType INVITE_FRIENDS_SUCCESS = null;
        public static final SystemType INVITE_MEMBERS_JOIN_TEAM = null;
        public static final SystemType INVITE_MEMBERS_TO_JOIN_EXTERNAL_CIRCLE = null;
        public static final SystemType JOIN_CIRCLE_VIA_HELP_DESK_MSG_CARD = null;
        public static final SystemType JOIN_CIRCLE_VIA_HELP_DESK_MSG_CARD_NO_HISTORY = null;
        public static final SystemType JOIN_DEPARTMENT_GROUP = null;
        public static final SystemType KICK_MEMBERS_OUT_TEAM = null;
        public static final SystemType LAST_HONGBAO_IS_GRABBED = null;
        public static final SystemType LOCAL_MENTION_BOTS_NOT_IN_CHAT = null;
        public static final SystemType Lark_IM_BotCustomization = null;
        public static final SystemType Lark_IM_CreateGroup_GroupAndDepartment_MemberInvite = null;
        public static final SystemType Lark_IM_CreateGroup_GroupAndDepartment_OwnerInvite = null;
        public static final SystemType Lark_IM_CreateGroup_UserAndDepartment_MemberInivite = null;
        public static final SystemType Lark_IM_CreateGroup_UserAndDepartment_OwnerInvite = null;
        public static final SystemType Lark_IM_CreateGroup_UserAndGroupAndDepartment_MemberInvite = null;
        public static final SystemType Lark_IM_CreateGroup_UserAndGroupAndDepartment_OwnerInvite = null;
        public static final SystemType Lark_IM_CreateGroup_UserAndGroup_MemberInvite = null;
        public static final SystemType Lark_IM_CreateGroup_UserAndGroup_OwnerInvite = null;
        public static final SystemType Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_Invitee = null;
        public static final SystemType Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_Inviter = null;
        public static final SystemType Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_OtherMembers = null;
        public static final SystemType Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_Invitee = null;
        public static final SystemType Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_Inviter = null;
        public static final SystemType Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_OtherMembers = null;
        public static final SystemType Lark_IM_EnterGroup_Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_Inviter = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_Invitee = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_Inviter = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_OtherMembers = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_Invitee = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_Inviter = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_OtherMembers = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_Invitee = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_OtherMembers = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_Invitee = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_Inviter = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_OtherMembers = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_Invitee = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_Inviter = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_OtherMembers = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_Invitee = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_Inviter = null;
        public static final SystemType Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_OtherMembers = null;
        public static final SystemType Lark_IM_EnterGroup_User_ChatHistoryYes_FromTeam = null;
        public static final SystemType Lark_IM_Server_WelcomeTo_Text = null;
        public static final SystemType MANUAL_OPEN_TYPING_TRANSLATE = null;
        public static final SystemType MANUAL_OPEN_TYPING_TRANSLATE_PROMPTS = null;
        public static final SystemType MEETING_TRANSFER_TO_CHAT = null;
        public static final SystemType MEETING_TRANSFER_TO_CHAT_WITH_DOC_URL = null;
        public static final SystemType MEMBERS_JOIN_TEAM_CHAT_FAIL = null;
        public static final SystemType MEMBERS_JOIN_TEAM_CHAT_SEE_HISTORICAL = null;
        public static final SystemType MEMBERS_JOIN_TEAM_CHAT_SEE_NEW_MESSAGES = null;
        public static final SystemType MEMBERS_JOIN_TEAM_FAIL = null;
        public static final SystemType MEMBERS_LEAVE_AND_TRANSFER = null;
        public static final SystemType MEMBER_LEAVE_TEAM = null;
        public static final SystemType MENTIONED_PERSON_NOT_IN_CIRCLE = null;
        public static final SystemType MIND_NOTE_TEMPLATE_GROUP_SHARE = null;
        public static final SystemType MODIFY_EMAIL_MEMBERS = null;
        public static final SystemType MODIFY_TEAM_AVATAR = null;
        public static final SystemType MODIFY_TEAM_DESCRIPTION = null;
        public static final SystemType MODIFY_TEAM_NAME = null;
        public static final SystemType MultiItemSystemContent = null;
        public static final SystemType MyAI_NewTopicTip = null;
        public static final SystemType MyAI_SceneTopicDynamicTip = null;
        public static final SystemType NON_FRIENDS_NOTICE = null;
        public static final SystemType NOT_COLLABORATION_AUTH_SEND_MSG_LIMIT_NOTIFY = null;
        public static final SystemType NOT_COLLABORATION_AUTH_SEND_MSG_REACH_LIMIT = null;
        public static final SystemType ONLY_ADMIN_CAN_MANAGE_CHAT_TAB = null;
        public static final SystemType ONLY_ADMIN_CAN_MANAGE_TabsMenuWidgets = null;
        public static final SystemType ONLY_ADMIN_CAN_MANAGE_TabsMenuWidgetsV1 = null;
        public static final SystemType OTHER_GRAB_MY_HONGBAO = null;
        public static final SystemType REMOVE_EMAIL_MEMBERS = null;
        public static final SystemType REMOVE_MEMBER_FROM_ADMIN_LIST = null;
        public static final SystemType SAIPAN_ADD_ONCALL = null;
        public static final SystemType SAIPAN_NOTIFY_AGENT_QUEUEING = null;
        public static final SystemType SAIPAN_REMIND_ONCALL_AUTO_DONE = null;
        public static final SystemType SAIPAN_REMIND_ONCALL_DONE = null;
        public static final SystemType SAIPAN_REMIND_ONCALL_REPLY = null;
        public static final SystemType SAIPAN_RESERVED_3 = null;
        public static final SystemType SAIPAN_RESERVED_4 = null;
        public static final SystemType SAIPAN_RESERVED_5 = null;
        public static final SystemType SAIPAN_SELECT_CARD_CONTENT = null;
        public static final SystemType SAIPAN_USER_QUEUEING = null;
        public static final SystemType SEND_HONGBAO_MESSAGE_FAILED = null;
        public static final SystemType SEND_MESSAGE_COLLABORATION_AUTH_FAILED = null;
        public static final SystemType SHEET_TEMPLATE_GROUP_SHARE = null;
        public static final SystemType SIMPLIFY_CIRCLE_WELCOME_NEW_MEMBERS = null;
        public static final SystemType SIMPLIFY_OTHER_GRAB_MY_HONGBAO = null;
        public static final SystemType SIMPLIFY_OTHER_GRAB_MY_HONGBAO_NOT_OVER_OUT_NUM = null;
        public static final SystemType SIMPLIFY_SYSTEM_WELCOME_USER = null;
        public static final SystemType SIMPLIFY_USER_INVITE_OTHERS_JOIN = null;
        public static final SystemType SIMPLIFY_USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE_NO_HISTORY = null;
        public static final SystemType SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE = null;
        public static final SystemType SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD = null;
        public static final SystemType SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK = null;
        public static final SystemType SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE = null;
        public static final SystemType SIMPLIFY_USER_JOIN_CHAT_BY_LINK_NO_HISTORY = null;
        public static final SystemType SIMPLIFY_USER_JOIN_CHAT_FROM_TEAM = null;
        public static final SystemType SIMPLIFY_USER_JOIN_CHAT_WELCOME_MESSAGE = null;
        public static final SystemType SIMPLIFY_USER_JOIN_CHAT_WELCOME_MESSAGE_NO_HISTORY = null;
        public static final SystemType SIMPLIFY_USER_JOIN_VIA_GROUP_LINK = null;
        public static final SystemType SIMPLIFY_USER_JOIN_VIA_QR_CODE = null;
        public static final SystemType SIMPLIFY_USER_JOIN_VIA_QR_CODE_NO_HISTORY = null;
        public static final SystemType SIMPLIFY_USER_JOIN_VIA_SHARE = null;
        public static final SystemType SIMPLIFY_USER_JOIN_VIA_SHARE_NO_HISTORY = null;
        public static final SystemType SIMPLIFY_WELCOME_USER_JOIN_FACE_TO_FACE_CHAT = null;
        public static final SystemType START_EMERGENCY_CALL = null;
        public static final SystemType SYSTEM_EPHEMERAL_NOTIFY = null;
        public static final SystemType SYSTEM_WELCOME_USER = null;
        public static final SystemType TARGET_EXTERNAL_COORDINATE_CTL = null;
        public static final SystemType TEAM_CHAT_TURN_OPEN_MESSAGE = null;
        public static final SystemType TEAM_CHAT_TURN_OPEN_MESSAGE_TO_TEAM = null;
        public static final SystemType TRANSFER_CIRCLE_OWNER = null;
        public static final SystemType TRANSFER_CIRCLE_OWNER_AND_LEAVE = null;
        public static final SystemType TRANSFER_GROUP_CHAT_OWNER = null;
        public static final SystemType TRANSFER_GROUP_CHAT_OWNER_AND_QUIT = null;
        public static final SystemType TRANSFER_TEAM_OWNER = null;
        public static final SystemType UNBIND_CHAT_WITH_TEAM = null;
        public static final SystemType UNKNOWN = null;
        public static final SystemType UPDATE_CHAT_TO_TEAM = null;
        public static final SystemType UPGRADE_SUPER_CHAT = null;
        public static final SystemType USER_ADD_MEETING_CHAT = null;
        public static final SystemType USER_CALL_E2EE_VOICE_DURATION = null;
        public static final SystemType USER_CALL_E2EE_VOICE_ON_CANCELL = null;
        public static final SystemType USER_CALL_E2EE_VOICE_ON_MISSING = null;
        public static final SystemType USER_CALL_E2EE_VOICE_WHEN_OCCUPY = null;
        public static final SystemType USER_CALL_E2EE_VOICE_WHEN_REFUSED = null;
        public static final SystemType USER_CHANGE_DOC_PERMISSION = null;
        public static final SystemType USER_CHANGE_GROUP_MAIL_PERMISSION_EVERYONE = null;
        public static final SystemType USER_CHANGE_GROUP_MAIL_PERMISSION_MEMBERS = null;
        public static final SystemType USER_CHANGE_GROUP_MAIL_PERMISSION_OWNER = null;
        public static final SystemType USER_CHANGE_GROUP_MAIL_PERMISSION_OWNER_OR_ADMIN = null;
        public static final SystemType USER_CHANGE_GROUP_MAIL_PERMISSION_TENANT = null;
        public static final SystemType USER_CHECK_OTHERS_TELEPHONE = null;
        public static final SystemType USER_CLEAR_CIRCLE_ANNOUNCEMENT = null;
        public static final SystemType USER_CREATED_GROUP_AND_INVITED_OTHER_CHATTER_CHAT_DEPARTMENT = null;
        public static final SystemType USER_CREATE_CIRCLE = null;
        public static final SystemType USER_CREATE_CIRCLE_AND_INVITE = null;
        public static final SystemType USER_CREATE_FACE_TO_FACE_CHAT = null;
        public static final SystemType USER_CREATE_TEAM = null;
        public static final SystemType USER_DISMISSED_MEETING_CHAT = null;
        public static final SystemType USER_INVITE_BOT_JOIN = null;
        public static final SystemType USER_INVITE_BOT_JOIN_CIRCLE = null;
        public static final SystemType USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN = null;
        public static final SystemType USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN_NEW = null;
        public static final SystemType USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN_NO_HISTORY = null;
        public static final SystemType USER_INVITE_OTHERS_JOIN = null;
        public static final SystemType USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE = null;
        public static final SystemType USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE_NO_HISTORY = null;
        public static final SystemType USER_INVITE_OTHERS_JOIN_CIRCLE = null;
        public static final SystemType USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD = null;
        public static final SystemType USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD_NO_HISTORY = null;
        public static final SystemType USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK = null;
        public static final SystemType USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK_NO_HISTORY = null;
        public static final SystemType USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE = null;
        public static final SystemType USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE_NO_HISTORY = null;
        public static final SystemType USER_INVITE_OTHERS_JOIN_CIRCLE_NO_HISTORY = null;
        public static final SystemType USER_INVITE_OTHERS_JOIN_CRYPTO_CHAT = null;
        public static final SystemType USER_INVITE_OTHERS_JOIN_MEETING = null;
        public static final SystemType USER_JOIN_CHAT_AUTO_MUTE = null;
        public static final SystemType USER_JOIN_CHAT_BY_LINK = null;
        public static final SystemType USER_JOIN_CHAT_BY_LINK_NO_HISTORY = null;
        public static final SystemType USER_JOIN_CHAT_FROM_TEAM = null;
        public static final SystemType USER_JOIN_CHAT_WELCOME_MESSAGE = null;
        public static final SystemType USER_JOIN_CHAT_WELCOME_MESSAGE_NO_HISTORY = null;
        public static final SystemType USER_JOIN_FACE_TO_FACE_CHAT = null;
        public static final SystemType USER_JOIN_VIA_GROUP_LINK = null;
        public static final SystemType USER_JOIN_VIA_QR_CODE = null;
        public static final SystemType USER_JOIN_VIA_QR_CODE_NO_HISTORY = null;
        public static final SystemType USER_JOIN_VIA_QR_NEW = null;
        public static final SystemType USER_JOIN_VIA_SHARE = null;
        public static final SystemType USER_JOIN_VIA_SHARE_NEW = null;
        public static final SystemType USER_JOIN_VIA_SHARE_NO_HISTORY = null;
        public static final SystemType USER_LEAVE_CIRCLE = null;
        public static final SystemType USER_LOW_VERSION_HINT = null;
        public static final SystemType USER_MODIFY_CIRCLE_AVATAR = null;
        public static final SystemType USER_MODIFY_CIRCLE_DESCRIPTION = null;
        public static final SystemType USER_MODIFY_CIRCLE_NAME = null;
        public static final SystemType USER_MODIFY_CIRCLE_OWNER = null;
        public static final SystemType USER_MODIFY_CIRCLE_SETTINGS = null;
        public static final SystemType USER_MODIFY_EMAIL_SUBJECT = null;
        public static final SystemType USER_MODIFY_GROUP_AVATAR = null;
        public static final SystemType USER_MODIFY_GROUP_DESCRIPTION = null;
        public static final SystemType USER_MODIFY_GROUP_NAME = null;
        public static final SystemType USER_MODIFY_GROUP_SETTINGS = null;
        public static final SystemType USER_MODIFY_THREAD_TOPIC = null;
        public static final SystemType USER_OPEN_ANYONE_POST = null;
        public static final SystemType USER_OPEN_ANYONE_POST_THREAD = null;
        public static final SystemType USER_OPEN_ONLY_ADMIN_POST = null;
        public static final SystemType USER_OPEN_ONLY_ADMIN_POST_THREAD = null;
        public static final SystemType USER_OPEN_ONLY_OWNER_AND_ADMIN_POST = null;
        public static final SystemType USER_OPEN_ONLY_OWNER_AND_ADMIN_POST_THREAD = null;
        public static final SystemType USER_OPEN_ONLY_SEPECIFY_MEMBERS_POST = null;
        public static final SystemType USER_OPEN_ONLY_SEPECIFY_MEMBERS_POST_THREAD = null;
        public static final SystemType USER_QUIT_GROUP = null;
        public static final SystemType USER_QUIT_MEETING_CHAT = null;
        public static final SystemType USER_REMOVE_CIRCLE_DESCRIPTION = null;
        public static final SystemType USER_REMOVE_CIRCLE_MEMBERS = null;
        public static final SystemType USER_REMOVE_GROUP_DESCRIPTION = null;
        public static final SystemType USER_REMOVE_OTHERS = null;
        public static final SystemType USER_REMOVE_OTHERS_FROM_MEETING = null;
        public static final SystemType USER_REMOVE_SEPECIFY_MEMBERS_POST = null;
        public static final SystemType USER_REMOVE_SEPECIFY_MEMBERS_POST_THREAD = null;
        public static final SystemType USER_SEPECIFY_MEMBERS_POST = null;
        public static final SystemType USER_SET_CRYPTO_MESSAGE_BURN_LIFE = null;
        public static final SystemType USER_SET_ONLY_CIRCLE_OWNER_CAN_CREATE_NEW_TOPICS = null;
        public static final SystemType USER_SET_ONLY_CIRCLE_OWNER_CAN_POST = null;
        public static final SystemType USER_SHARE_DOC_FOLDER = null;
        public static final SystemType USER_SHARE_DOC_PERMISSION = null;
        public static final SystemType USER_SPECIFY_MEMBERS_POST_THREAD = null;
        public static final SystemType USER_START_CRYPTO_GROUP_AND_INVITE = null;
        public static final SystemType USER_START_GROUP = null;
        public static final SystemType USER_START_GROUP_AND_INVITE = null;
        public static final SystemType USER_START_MEETING_GROUP_AND_INVITE = null;
        public static final SystemType USER_SYNC_MESSAGE = null;
        public static final SystemType USER_SYNC_MESSAGE_TO_CIRCLE = null;
        public static final SystemType USER_SYNC_MESSAGE_V2 = null;
        public static final SystemType USER_THREAD_CLEAR_TITLE = null;
        public static final SystemType USER_TOOK_SCREENSHOT_IN_CRYPTO_CHAT = null;
        public static final SystemType USER_TURN_OFF_GROUP_MAIL = null;
        public static final SystemType USER_TURN_ON_GROUP_MAIL = null;
        public static final SystemType USER_WITHDRAW_CIRCLE_INVITATION = null;
        public static final SystemType VC_CALL_CONNECT_FAIL = null;
        public static final SystemType VC_CALL_DISCONNECT = null;
        public static final SystemType VC_CALL_DISCONNECTED_ENDED_LESS_ONE_HOUR = null;
        public static final SystemType VC_CALL_DISCONNECTED_ENDED_LESS_ONE_MIN = null;
        public static final SystemType VC_CALL_DISCONNECTED_ENDED_OVER_ONE_HOUR = null;
        public static final SystemType VC_CALL_DURATION = null;
        public static final SystemType VC_CALL_ENDED_LESS_ONE_HOUR = null;
        public static final SystemType VC_CALL_ENDED_LESS_ONE_MIN = null;
        public static final SystemType VC_CALL_ENDED_OVER_ONE_HOUR = null;
        public static final SystemType VC_CALL_FINISH_NOTICE = null;
        public static final SystemType VC_CALL_HOST_BUSY = null;
        public static final SystemType VC_CALL_HOST_CANCEL = null;
        public static final SystemType VC_CALL_INTERVIEWEE_BUSY = null;
        public static final SystemType VC_CALL_INTERVIEWEE_NOT_ONLINE = null;
        public static final SystemType VC_CALL_INTERVIEWEE_NO_ANSWER = null;
        public static final SystemType VC_CALL_INTERVIEWEE_REFUSE = null;
        public static final SystemType VC_CALL_INTERVIEWER_CANCEL = null;
        public static final SystemType VC_CALL_PARTI_BUSY = null;
        public static final SystemType VC_CALL_PARTI_CANCEL = null;
        public static final SystemType VC_CALL_PARTI_NO_ANSWER = null;
        public static final SystemType VC_DEFAULT_MEETING_ENDED_LESS_ONE_HOUR = null;
        public static final SystemType VC_DEFAULT_MEETING_ENDED_LESS_ONE_MIN = null;
        public static final SystemType VC_DEFAULT_MEETING_ENDED_OVER_ONE_HOUR = null;
        public static final SystemType VC_ENTERPRISE_PHONE_CREATE = null;
        public static final SystemType VC_MEETING_ENDED_LESS_ONE_HOUR = null;
        public static final SystemType VC_MEETING_ENDED_LESS_ONE_MIN = null;
        public static final SystemType VC_MEETING_ENDED_OVER_ONE_HOUR = null;
        public static final SystemType VC_MEETING_STARTED = null;
        public static final SystemType VC_VIDEO_CHAT_STARTED = null;
        public static final SystemType VOIP_DISCONNECTED_ENDED_LESS_ONE_HOUR = null;
        public static final SystemType VOIP_DISCONNECTED_ENDED_LESS_ONE_MIN = null;
        public static final SystemType VOIP_DISCONNECTED_ENDED_OVER_ONE_HOUR = null;
        public static final SystemType VOIP_ENDED_LESS_ONE_HOUR = null;
        public static final SystemType VOIP_ENDED_LESS_ONE_MIN = null;
        public static final SystemType VOIP_ENDED_OVER_ONE_HOUR = null;
        public static final SystemType VOIP_INTERVIEWEE_BUSY = null;
        public static final SystemType VOIP_INTERVIEWEE_NOT_ONLINE = null;
        public static final SystemType VOIP_INTERVIEWEE_NO_ANSWER = null;
        public static final SystemType VOIP_INTERVIEWEE_REFUSE = null;
        public static final SystemType VOIP_INTERVIEWER_CANCEL = null;
        public static final SystemType WELCOME_USER_JOIN_FACE_TO_FACE_CHAT = null;
        public static final SystemType WILL_REACH_CHAT_CHATTER_COUNT_LIMIT = null;
        public static final SystemType WIPE_ANNOUNCEMENT = null;
        public static final SystemType WITHDRAW_ADDED_USER = null;
        public static final /* synthetic */ SystemType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<SystemType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                SystemType.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<SystemType> r1, Syntax r2, SystemType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static SystemType a(int r1) {
                if (r1 == 0) goto L410;
                if (r1 == 1) goto L771;
                if (r1 == 2) goto L770;
                if (r1 == 3) goto L769;
                if (r1 == 4) goto L768;
                if (r1 == 5) goto L767;
                if (r1 == 6) goto L766;
                if (r1 == 7) goto L765;
                if (r1 == 131) goto L764;
                if (r1 == 132) goto L763;
                if (r1 == 379) goto L762;
                if (r1 == 380) goto L761;
                if (r1 == 385) goto L760;
                if (r1 == 386) goto L759;
                if (r1 == 428) goto L758;
                if (r1 == 429) goto L757;
                switch(r1) {
                    case 7: goto L765;
                    case 8: goto L756;
                    case 9: goto L755;
                    case 10: goto L754;
                    case 11: goto L753;
                    case 12: goto L752;
                    case 13: goto L751;
                    case 14: goto L750;
                    case 15: goto L749;
                    case 16: goto L748;
                    case 17: goto L747;
                    case 18: goto L746;
                    case 19: goto L745;
                    case 20: goto L744;
                    case 21: goto L743;
                    case 22: goto L742;
                    case 23: goto L741;
                    case 24: goto L740;
                    case 25: goto L739;
                    case 26: goto L738;
                    case 27: goto L737;
                    case 28: goto L736;
                    case 29: goto L735;
                    case 30: goto L734;
                    case 31: goto L733;
                    case 32: goto L732;
                    case 33: goto L731;
                    case 34: goto L730;
                    case 35: goto L729;
                    case 36: goto L728;
                    case 37: goto L727;
                    case 38: goto L726;
                    case 39: goto L725;
                    case 40: goto L724;
                    case 41: goto L723;
                    case 42: goto L722;
                    case 43: goto L721;
                    case 44: goto L720;
                    case 45: goto L719;
                    case 46: goto L718;
                    case 47: goto L717;
                    case 48: goto L716;
                    case 49: goto L715;
                    case 143: goto L714;
                    case 175: goto L713;
                    case 268: goto L712;
                    case 541: goto L711;
                    case 542: goto L710;
                    case 543: goto L709;
                    case 544: goto L708;
                    case 545: goto L707;
                    case 615: goto L706;
                    case 616: goto L705;
                    case 617: goto L704;
                    case 618: goto L703;
                    case 619: goto L702;
                    case 620: goto L701;
                    case 621: goto L700;
                    case 622: goto L699;
                    case 623: goto L698;
                    case 624: goto L697;
                    case 625: goto L696;
                    case 626: goto L695;
                    case 627: goto L694;
                    case 628: goto L693;
                    case 629: goto L692;
                    case 630: goto L691;
                    case 631: goto L690;
                    case 632: goto L689;
                    case 633: goto L688;
                    case 634: goto L687;
                    case 702: goto L686;
                    case 1100: goto L685;
                    case 1110: goto L684;
                    case 1203: goto L683;
                    case 1301: goto L682;
                    case 1500: goto L681;
                    case 1501: goto L680;
                    case 1502: goto L679;
                    case 1503: goto L678;
                    case 1504: goto L677;
                    case 1505: goto L676;
                    case 1506: goto L675;
                    case 1507: goto L674;
                    case 1510: goto L673;
                    case 1511: goto L672;
                    case 10000: goto L671;
                    default: goto L34;
                };
            L34:
                switch(r1) {
                    case 317: goto L670;
                    case 318: goto L669;
                    case 319: goto L668;
                    case 320: goto L667;
                    default: goto L35;
                };
            L35:
                switch(r1) {
                    case 322: goto L666;
                    case 323: goto L665;
                    case 324: goto L664;
                    case 325: goto L663;
                    case 326: goto L662;
                    case 327: goto L661;
                    case 328: goto L660;
                    case 329: goto L659;
                    case 330: goto L658;
                    case 331: goto L657;
                    case 332: goto L656;
                    case 333: goto L655;
                    case 334: goto L654;
                    case 335: goto L653;
                    case 336: goto L652;
                    case 337: goto L651;
                    case 338: goto L650;
                    case 339: goto L649;
                    case 340: goto L648;
                    case 341: goto L647;
                    case 342: goto L646;
                    case 343: goto L645;
                    case 344: goto L644;
                    case 345: goto L643;
                    case 346: goto L642;
                    case 347: goto L641;
                    case 348: goto L640;
                    default: goto L36;
                };
            L36:
                switch(r1) {
                    case 363: goto L639;
                    case 364: goto L638;
                    case 365: goto L637;
                    default: goto L37;
                };
            L37:
                switch(r1) {
                    case 392: goto L636;
                    case 393: goto L635;
                    case 394: goto L634;
                    case 395: goto L633;
                    case 396: goto L632;
                    case 397: goto L631;
                    case 398: goto L630;
                    case 399: goto L629;
                    default: goto L38;
                };
            L38:
                switch(r1) {
                    case 401: goto L628;
                    case 402: goto L627;
                    case 403: goto L626;
                    case 404: goto L625;
                    case 405: goto L624;
                    default: goto L39;
                };
            L39:
                switch(r1) {
                    case 501: goto L623;
                    case 502: goto L622;
                    case 503: goto L621;
                    case 504: goto L620;
                    case 505: goto L619;
                    case 506: goto L618;
                    case 507: goto L617;
                    case 508: goto L616;
                    case 509: goto L615;
                    case 510: goto L614;
                    case 511: goto L613;
                    case 512: goto L612;
                    case 513: goto L611;
                    case 514: goto L610;
                    case 515: goto L609;
                    case 516: goto L608;
                    case 517: goto L607;
                    case 518: goto L606;
                    case 519: goto L605;
                    case 520: goto L604;
                    case 521: goto L603;
                    case 522: goto L602;
                    case 523: goto L601;
                    case 524: goto L600;
                    case 525: goto L599;
                    case 526: goto L598;
                    case 527: goto L597;
                    case 528: goto L596;
                    case 529: goto L595;
                    case 530: goto L594;
                    case 531: goto L593;
                    case 532: goto L592;
                    case 533: goto L591;
                    case 534: goto L590;
                    case 535: goto L589;
                    default: goto L40;
                };
            L40:
                switch(r1) {
                    case 52: goto L440;
                    case 53: goto L439;
                    case 54: goto L438;
                    case 55: goto L437;
                    case 56: goto L436;
                    case 57: goto L435;
                    case 58: goto L434;
                    case 59: goto L433;
                    case 60: goto L432;
                    case 61: goto L431;
                    case 62: goto L430;
                    case 63: goto L429;
                    case 64: goto L428;
                    case 65: goto L427;
                    case 66: goto L426;
                    case 67: goto L425;
                    case 68: goto L424;
                    case 69: goto L423;
                    case 70: goto L422;
                    case 71: goto L421;
                    case 72: goto L420;
                    case 73: goto L419;
                    case 74: goto L418;
                    case 75: goto L417;
                    case 76: goto L416;
                    case 77: goto L415;
                    case 78: goto L414;
                    case 79: goto L413;
                    case 80: goto L412;
                    default: goto L41;
                };
            L41:
                switch(r1) {
                    case 83: goto L483;
                    case 84: goto L482;
                    case 85: goto L481;
                    case 86: goto L480;
                    case 87: goto L479;
                    case 88: goto L478;
                    case 89: goto L477;
                    case 90: goto L476;
                    case 91: goto L475;
                    case 92: goto L474;
                    case 93: goto L473;
                    case 94: goto L472;
                    case 95: goto L471;
                    case 96: goto L470;
                    case 97: goto L469;
                    case 98: goto L468;
                    case 99: goto L467;
                    case 100: goto L466;
                    case 101: goto L465;
                    case 102: goto L464;
                    case 103: goto L463;
                    case 104: goto L462;
                    case 105: goto L461;
                    case 106: goto L460;
                    case 107: goto L459;
                    case 108: goto L458;
                    case 109: goto L457;
                    case 110: goto L456;
                    case 111: goto L455;
                    case 112: goto L454;
                    case 113: goto L453;
                    case 114: goto L452;
                    case 115: goto L451;
                    case 116: goto L450;
                    case 117: goto L449;
                    case 118: goto L448;
                    case 119: goto L447;
                    case 120: goto L446;
                    case 121: goto L445;
                    case 122: goto L444;
                    case 123: goto L443;
                    case 124: goto L442;
                    case 125: goto L441;
                    default: goto L42;
                };
            L42:
                switch(r1) {
                    case 138: goto L487;
                    case 139: goto L486;
                    case 140: goto L485;
                    case 141: goto L484;
                    default: goto L43;
                };
            L43:
                switch(r1) {
                    case 148: goto L503;
                    case 149: goto L502;
                    case 150: goto L501;
                    case 151: goto L500;
                    case 152: goto L499;
                    case 153: goto L498;
                    case 154: goto L497;
                    case 155: goto L496;
                    case 156: goto L495;
                    case 157: goto L494;
                    case 158: goto L493;
                    case 159: goto L492;
                    case 160: goto L491;
                    case 161: goto L490;
                    case 162: goto L489;
                    case 163: goto L488;
                    default: goto L44;
                };
            L44:
                switch(r1) {
                    case 169: goto L507;
                    case 170: goto L506;
                    case 171: goto L505;
                    case 172: goto L504;
                    default: goto L45;
                };
            L45:
                switch(r1) {
                    case 185: goto L540;
                    case 186: goto L539;
                    case 187: goto L538;
                    case 188: goto L537;
                    case 189: goto L536;
                    case 190: goto L535;
                    case 191: goto L534;
                    case 192: goto L533;
                    case 193: goto L532;
                    case 194: goto L531;
                    case 195: goto L530;
                    case 196: goto L529;
                    case 197: goto L528;
                    case 198: goto L527;
                    case 199: goto L526;
                    case 200: goto L525;
                    case 201: goto L524;
                    case 202: goto L523;
                    case 203: goto L522;
                    case 204: goto L521;
                    case 205: goto L520;
                    case 206: goto L519;
                    case 207: goto L518;
                    case 208: goto L517;
                    case 209: goto L516;
                    case 210: goto L515;
                    case 211: goto L514;
                    case 212: goto L513;
                    case 213: goto L512;
                    case 214: goto L511;
                    case 215: goto L510;
                    case 216: goto L509;
                    case 217: goto L508;
                    default: goto L46;
                };
            L46:
                switch(r1) {
                    case 225: goto L573;
                    case 226: goto L572;
                    case 227: goto L571;
                    case 228: goto L570;
                    case 229: goto L569;
                    case 230: goto L568;
                    case 231: goto L567;
                    case 232: goto L566;
                    case 233: goto L565;
                    case 234: goto L564;
                    case 235: goto L563;
                    case 236: goto L562;
                    case 237: goto L561;
                    case 238: goto L560;
                    case 239: goto L559;
                    case 240: goto L558;
                    case 241: goto L557;
                    case 242: goto L556;
                    case 243: goto L555;
                    case 244: goto L554;
                    case 245: goto L553;
                    case 246: goto L552;
                    case 247: goto L551;
                    case 248: goto L550;
                    case 249: goto L549;
                    case 250: goto L548;
                    case 251: goto L547;
                    case 252: goto L546;
                    case 253: goto L545;
                    case 254: goto L544;
                    case 255: goto L543;
                    case 256: goto L542;
                    case 257: goto L541;
                    default: goto L47;
                };
            L47:
                switch(r1) {
                    case 300: goto L588;
                    case 301: goto L587;
                    case 302: goto L586;
                    case 303: goto L585;
                    case 304: goto L584;
                    case 305: goto L583;
                    case 306: goto L582;
                    case 307: goto L581;
                    case 308: goto L580;
                    case 309: goto L579;
                    case 310: goto L578;
                    case 311: goto L577;
                    case 312: goto L576;
                    case 313: goto L575;
                    case 314: goto L574;
                    default: goto L48;
                };
            L48:
                return null;
            L574:
                return SystemType.REMOVE_MEMBER_FROM_ADMIN_LIST;
            L575:
                return SystemType.ADD_MEMBER_TO_ADMIN_LIST;
            L576:
                return SystemType.USER_REMOVE_SEPECIFY_MEMBERS_POST_THREAD;
            L577:
                return SystemType.USER_REMOVE_SEPECIFY_MEMBERS_POST;
            L578:
                return SystemType.USER_OPEN_ONLY_SEPECIFY_MEMBERS_POST_THREAD;
            L579:
                return SystemType.USER_OPEN_ONLY_SEPECIFY_MEMBERS_POST;
            L580:
                return SystemType.CREATE_CHAT_AND_INVITE_FROM_CHAT_DEPARTMENT_MEMBER;
            L581:
                return SystemType.USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN;
            L582:
                return SystemType.USER_CREATED_GROUP_AND_INVITED_OTHER_CHATTER_CHAT_DEPARTMENT;
            L583:
                return SystemType.WELCOME_USER_JOIN_FACE_TO_FACE_CHAT;
            L584:
                return SystemType.USER_JOIN_FACE_TO_FACE_CHAT;
            L585:
                return SystemType.USER_CREATE_FACE_TO_FACE_CHAT;
            L586:
                return SystemType.ALREADY_REACH_CHAT_CHATTER_COUNT_LIMIT;
            L587:
                return SystemType.WILL_REACH_CHAT_CHATTER_COUNT_LIMIT;
            L588:
                return SystemType.INVITE_CHAT_MEMBER_2_CHAT;
            L541:
                return SystemType.Lark_IM_EnterGroup_User_ChatHistoryYes_FromTeam;
            L542:
                return SystemType.Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_OtherMembers;
            L543:
                return SystemType.Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_OtherMembers;
            L544:
                return SystemType.Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_Invitee;
            L545:
                return SystemType.Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_Invitee;
            L546:
                return SystemType.Lark_IM_EnterGroup_Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_Inviter;
            L547:
                return SystemType.Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_Inviter;
            L548:
                return SystemType.Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_OtherMembers;
            L549:
                return SystemType.Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_OtherMembers;
            L550:
                return SystemType.Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_Invitee;
            L551:
                return SystemType.Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_Invitee;
            L552:
                return SystemType.Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_Inviter;
            L553:
                return SystemType.Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_Inviter;
            L554:
                return SystemType.Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_OtherMembers;
            L555:
                return SystemType.Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_OtherMembers;
            L556:
                return SystemType.Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_Invitee;
            L557:
                return SystemType.Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_Invitee;
            L558:
                return SystemType.Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_Inviter;
            L559:
                return SystemType.Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_Inviter;
            L560:
                return SystemType.Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_OtherMembers;
            L561:
                return SystemType.Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_OtherMembers;
            L562:
                return SystemType.Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_Invitee;
            L563:
                return SystemType.Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_Invitee;
            L564:
                return SystemType.Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_Inviter;
            L565:
                return SystemType.Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_Inviter;
            L566:
                return SystemType.Lark_IM_CreateGroup_UserAndGroupAndDepartment_MemberInvite;
            L567:
                return SystemType.Lark_IM_CreateGroup_UserAndGroupAndDepartment_OwnerInvite;
            L568:
                return SystemType.Lark_IM_CreateGroup_GroupAndDepartment_MemberInvite;
            L569:
                return SystemType.Lark_IM_CreateGroup_GroupAndDepartment_OwnerInvite;
            L570:
                return SystemType.Lark_IM_CreateGroup_UserAndDepartment_MemberInivite;
            L571:
                return SystemType.Lark_IM_CreateGroup_UserAndDepartment_OwnerInvite;
            L572:
                return SystemType.Lark_IM_CreateGroup_UserAndGroup_MemberInvite;
            L573:
                return SystemType.Lark_IM_CreateGroup_UserAndGroup_OwnerInvite;
            L508:
                return SystemType.CIRCLE_ANONYMOUS_OFF;
            L509:
                return SystemType.CIRCLE_ANONYMOUS_ON;
            L510:
                return SystemType.USER_WITHDRAW_CIRCLE_INVITATION;
            L511:
                return SystemType.USER_CLEAR_CIRCLE_ANNOUNCEMENT;
            L512:
                return SystemType.USER_SYNC_MESSAGE_TO_CIRCLE;
            L513:
                return SystemType.USER_CREATE_CIRCLE_AND_INVITE;
            L514:
                return SystemType.USER_CREATE_CIRCLE;
            L515:
                return SystemType.USER_REMOVE_CIRCLE_MEMBERS;
            L516:
                return SystemType.USER_REMOVE_CIRCLE_DESCRIPTION;
            L517:
                return SystemType.USER_LEAVE_CIRCLE;
            L518:
                return SystemType.USER_SET_ONLY_CIRCLE_OWNER_CAN_CREATE_NEW_TOPICS;
            L519:
                return SystemType.USER_SET_ONLY_CIRCLE_OWNER_CAN_POST;
            L520:
                return SystemType.USER_MODIFY_CIRCLE_SETTINGS;
            L521:
                return SystemType.USER_MODIFY_CIRCLE_OWNER;
            L522:
                return SystemType.USER_MODIFY_CIRCLE_NAME;
            L523:
                return SystemType.USER_MODIFY_CIRCLE_DESCRIPTION;
            L524:
                return SystemType.USER_MODIFY_CIRCLE_AVATAR;
            L525:
                return SystemType.USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD;
            L526:
                return SystemType.USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE;
            L527:
                return SystemType.CIRCLE_TOO_MANY_MEMBERS_NOTIFICATION_MUTED;
            L528:
                return SystemType.USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK;
            L529:
                return SystemType.USER_INVITE_OTHERS_JOIN_CIRCLE;
            L530:
                return SystemType.USER_INVITE_BOT_JOIN_CIRCLE;
            L531:
                return SystemType.CIRCLE_USER_CHANGE_DOC_PERMISSION;
            L532:
                return SystemType.TRANSFER_CIRCLE_OWNER_AND_LEAVE;
            L533:
                return SystemType.TRANSFER_CIRCLE_OWNER;
            L534:
                return SystemType.CIRCLE_WELCOME_NEW_MEMBERS;
            L535:
                return SystemType.JOIN_CIRCLE_VIA_HELP_DESK_MSG_CARD;
            L536:
                return SystemType.CIRCLE_CANT_ADD_MANY_MEMBERS_DUE_TO_ADMIN_SETTINGS;
            L537:
                return SystemType.CIRCLE_CANT_ADD_MEMBERS_DUE_TO_ADMIN_SETTINGS;
            L538:
                return SystemType.INVITE_MEMBERS_TO_JOIN_EXTERNAL_CIRCLE;
            L539:
                return SystemType.MENTIONED_PERSON_NOT_IN_CIRCLE;
            L540:
                return SystemType.CREATE_CIRCLE_AND_INVITE_OTHERS_FROM_CHAT;
            L504:
                return SystemType.MIND_NOTE_TEMPLATE_GROUP_SHARE;
            L505:
                return SystemType.SHEET_TEMPLATE_GROUP_SHARE;
            L506:
                return SystemType.DOC_TEMPLATE_GROUP_SHARE;
            L507:
                return SystemType.USER_INVITE_BOT_JOIN;
            L488:
                return SystemType.NOT_COLLABORATION_AUTH_SEND_MSG_REACH_LIMIT;
            L489:
                return SystemType.NOT_COLLABORATION_AUTH_SEND_MSG_LIMIT_NOTIFY;
            L490:
                return SystemType.SEND_MESSAGE_COLLABORATION_AUTH_FAILED;
            L491:
                return SystemType.CREATE_P2P_SOURCE;
            L492:
                return SystemType.INVITE_FRIENDS_SUCCESS;
            L493:
                return SystemType.BUILD_ONEWAY_RELATION;
            L494:
                return SystemType.SYSTEM_EPHEMERAL_NOTIFY;
            L495:
                return SystemType.CHAT_ROOM_START_V2;
            L496:
                return SystemType.CHAT_ROOM_END;
            L497:
                return SystemType.USER_JOIN_VIA_GROUP_LINK;
            L498:
                return SystemType.USER_CHANGE_GROUP_MAIL_PERMISSION_EVERYONE;
            L499:
                return SystemType.USER_CHANGE_GROUP_MAIL_PERMISSION_TENANT;
            L500:
                return SystemType.USER_CHANGE_GROUP_MAIL_PERMISSION_MEMBERS;
            L501:
                return SystemType.USER_CHANGE_GROUP_MAIL_PERMISSION_OWNER;
            L502:
                return SystemType.USER_TURN_OFF_GROUP_MAIL;
            L503:
                return SystemType.USER_TURN_ON_GROUP_MAIL;
            L484:
                return SystemType.INVITE_CHATTERS_TO_CHAT_NO_PERMISSION_OVER_THRESHOLD;
            L485:
                return SystemType.INVITE_CHATTERS_TO_CHAT_NO_PERMISSION_LESS_THRESHOLD;
            L486:
                return SystemType.EMERGENCY_CALL_NOTANSWER;
            L487:
                return SystemType.USER_JOIN_CHAT_AUTO_MUTE;
            L441:
                return SystemType.MEETING_TRANSFER_TO_CHAT_WITH_DOC_URL;
            L442:
                return SystemType.MEETING_TRANSFER_TO_CHAT;
            L443:
                return SystemType.START_EMERGENCY_CALL;
            L444:
                return SystemType.HANGUP_EMERGENCY_CALL;
            L445:
                return SystemType.CANCEL_EMERGENCY_CALL;
            L446:
                return SystemType.SAIPAN_RESERVED_5;
            L447:
                return SystemType.SAIPAN_RESERVED_4;
            L448:
                return SystemType.SAIPAN_RESERVED_3;
            L449:
                return SystemType.SAIPAN_NOTIFY_AGENT_QUEUEING;
            L450:
                return SystemType.SAIPAN_USER_QUEUEING;
            L451:
                return SystemType.SAIPAN_SELECT_CARD_CONTENT;
            L452:
                return SystemType.VOIP_INTERVIEWEE_BUSY;
            L453:
                return SystemType.VOIP_INTERVIEWER_CANCEL;
            L454:
                return SystemType.VOIP_INTERVIEWEE_REFUSE;
            L455:
                return SystemType.VOIP_INTERVIEWEE_NO_ANSWER;
            L456:
                return SystemType.VOIP_DISCONNECTED_ENDED_LESS_ONE_MIN;
            L457:
                return SystemType.VOIP_DISCONNECTED_ENDED_LESS_ONE_HOUR;
            L458:
                return SystemType.VOIP_DISCONNECTED_ENDED_OVER_ONE_HOUR;
            L459:
                return SystemType.VOIP_ENDED_LESS_ONE_MIN;
            L460:
                return SystemType.VOIP_ENDED_LESS_ONE_HOUR;
            L461:
                return SystemType.VOIP_ENDED_OVER_ONE_HOUR;
            L462:
                return SystemType.VC_CALL_INTERVIEWEE_BUSY;
            L463:
                return SystemType.VC_CALL_INTERVIEWER_CANCEL;
            L464:
                return SystemType.VC_CALL_INTERVIEWEE_REFUSE;
            L465:
                return SystemType.VC_CALL_INTERVIEWEE_NO_ANSWER;
            L466:
                return SystemType.VC_CALL_DISCONNECTED_ENDED_LESS_ONE_MIN;
            L467:
                return SystemType.VC_CALL_DISCONNECTED_ENDED_LESS_ONE_HOUR;
            L468:
                return SystemType.VC_CALL_DISCONNECTED_ENDED_OVER_ONE_HOUR;
            L469:
                return SystemType.VC_CALL_ENDED_LESS_ONE_MIN;
            L470:
                return SystemType.VC_CALL_ENDED_LESS_ONE_HOUR;
            L471:
                return SystemType.VC_CALL_ENDED_OVER_ONE_HOUR;
            L472:
                return SystemType.VC_VIDEO_CHAT_STARTED;
            L473:
                return SystemType.VC_DEFAULT_MEETING_ENDED_LESS_ONE_MIN;
            L474:
                return SystemType.VC_DEFAULT_MEETING_ENDED_LESS_ONE_HOUR;
            L475:
                return SystemType.VC_DEFAULT_MEETING_ENDED_OVER_ONE_HOUR;
            L476:
                return SystemType.VC_MEETING_ENDED_LESS_ONE_MIN;
            L477:
                return SystemType.VC_MEETING_ENDED_LESS_ONE_HOUR;
            L478:
                return SystemType.INVITE_AT_CHATTERS;
            L479:
                return SystemType.VC_MEETING_ENDED_OVER_ONE_HOUR;
            L480:
                return SystemType.USER_OPEN_ANYONE_POST_THREAD;
            L481:
                return SystemType.USER_SPECIFY_MEMBERS_POST_THREAD;
            L482:
                return SystemType.USER_OPEN_ONLY_ADMIN_POST_THREAD;
            L483:
                return SystemType.VC_MEETING_STARTED;
            L412:
                return SystemType.SAIPAN_ADD_ONCALL;
            L413:
                return SystemType.SAIPAN_REMIND_ONCALL_AUTO_DONE;
            L414:
                return SystemType.SAIPAN_REMIND_ONCALL_DONE;
            L415:
                return SystemType.SAIPAN_REMIND_ONCALL_REPLY;
            L416:
                return SystemType.WITHDRAW_ADDED_USER;
            L417:
                return SystemType.AUTO_TRANSLATE_GUIDANCE;
            L418:
                return SystemType.CREATE_CHAT_AND_INVITE_FROM_CHAT_MEMBER;
            L419:
                return SystemType.INVITE_CHAT_MEMBER_2_OUT_CHAT;
            L420:
                return SystemType.CRYPTO_LOW_VERSION_HINT;
            L421:
                return SystemType.USER_TOOK_SCREENSHOT_IN_CRYPTO_CHAT;
            L422:
                return SystemType.USER_SET_CRYPTO_MESSAGE_BURN_LIFE;
            L423:
                return SystemType.CRYPTO_MESSAGE_NOTICE_BURN_AFTER_READING;
            L424:
                return SystemType.CRYPTO_MESSAGE_NOTICE_SEVEN_DAYS;
            L425:
                return SystemType.CRYPTO_MESSAGE_NOTICE_NO_TRANSMIT;
            L426:
                return SystemType.USER_OPEN_ANYONE_POST;
            L427:
                return SystemType.USER_THREAD_CLEAR_TITLE;
            L428:
                return SystemType.USER_LOW_VERSION_HINT;
            L429:
                return SystemType.USER_SEPECIFY_MEMBERS_POST;
            L430:
                return SystemType.USER_OPEN_ONLY_ADMIN_POST;
            L431:
                return SystemType.USER_SHARE_DOC_FOLDER;
            L432:
                return SystemType.USER_CHANGE_DOC_PERMISSION;
            L433:
                return SystemType.USER_SHARE_DOC_PERMISSION;
            L434:
                return SystemType.USER_SYNC_MESSAGE_V2;
            L435:
                return SystemType.SEND_HONGBAO_MESSAGE_FAILED;
            L436:
                return SystemType.LAST_HONGBAO_IS_GRABBED;
            L437:
                return SystemType.OTHER_GRAB_MY_HONGBAO;
            L438:
                return SystemType.GRAB_OTHER_HONGBAO;
            L439:
                return SystemType.USER_CALL_E2EE_VOICE_WHEN_OCCUPY;
            L440:
                return SystemType.USER_CALL_E2EE_VOICE_WHEN_REFUSED;
            L589:
                return SystemType.DELETE_TEAM_DESCRIPTION;
            L590:
                return SystemType.MODIFY_TEAM_DESCRIPTION;
            L591:
                return SystemType.MODIFY_TEAM_AVATAR;
            L592:
                return SystemType.VC_ENTERPRISE_PHONE_CREATE;
            L593:
                return SystemType.MultiItemSystemContent;
            L594:
                return SystemType.BuzzNotAnswer;
            L595:
                return SystemType.CantBuzzMembers;
            L596:
                return SystemType.BuzzTimeOut;
            L597:
                return SystemType.BuzzSystemError;
            L598:
                return SystemType.BuzzLimit;
            L599:
                return SystemType.CantBuzzEmptyName;
            L600:
                return SystemType.CantBuzzEmptyPhoneNumber;
            L601:
                return SystemType.CHECK_USER_PHONE_USER_IN_WHITELIST;
            L602:
                return SystemType.CHECK_USER_PHONE_NUMBER;
            L603:
                return SystemType.USER_CREATE_TEAM;
            L604:
                return SystemType.MEMBERS_LEAVE_AND_TRANSFER;
            L605:
                return SystemType.MEMBERS_JOIN_TEAM_CHAT_FAIL;
            L606:
                return SystemType.MEMBERS_JOIN_TEAM_CHAT_SEE_NEW_MESSAGES;
            L607:
                return SystemType.MEMBERS_JOIN_TEAM_CHAT_SEE_HISTORICAL;
            L608:
                return SystemType.UNBIND_CHAT_WITH_TEAM;
            L609:
                return SystemType.BIND_CHAT_INTO_TEAM;
            L610:
                return SystemType.CREATE_TEAM_CHAT;
            L611:
                return SystemType.DISSOLVE_TEAM_AND_UNBIND_CHAT;
            L612:
                return SystemType.CLOSE_TEAM_ADD_MEMBERS_PERMISSION;
            L613:
                return SystemType.ENABLE_TEAM_ADD_MEMBERS_PERMISSION;
            L614:
                return SystemType.CLOSE_TEAM_CREATE_CHAT_PERMISSION;
            L615:
                return SystemType.ENABLE_TEAM_CREATE_CHAT_PERMISSION;
            L616:
                return SystemType.MODIFY_TEAM_NAME;
            L617:
                return SystemType.TRANSFER_TEAM_OWNER;
            L618:
                return SystemType.MEMBER_LEAVE_TEAM;
            L619:
                return SystemType.KICK_MEMBERS_OUT_TEAM;
            L620:
                return SystemType.MEMBERS_JOIN_TEAM_FAIL;
            L621:
                return SystemType.INVITE_MEMBERS_JOIN_TEAM;
            L622:
                return SystemType.UPDATE_CHAT_TO_TEAM;
            L623:
                return SystemType.CREATE_TEAM_AND_INVITE_MEMBERS;
            L624:
                return SystemType.BITABLE_TEMPLATE_GROUP_SHARE_SYSTEM_MESSAGE;
            L625:
                return SystemType.CHAT_CLOSED_CAN_SEARCH_SYSTEM_MESSAGE;
            L626:
                return SystemType.CHAT_OPEN_CAN_SEARCH_SYSTEM_MESSAGE;
            L627:
                return SystemType.TARGET_EXTERNAL_COORDINATE_CTL;
            L628:
                return SystemType.EXTERNAL_COORDINATE_CTL;
            L629:
                return SystemType.CAN_MANAGER_CHAT_URL_TOP_NOTICE_LOW_V_THREAD;
            L630:
                return SystemType.ALL_MEMBERS_CHAT_URL_TOP_NOTICE_LOW_V_THREAD;
            L631:
                return SystemType.CAN_MANAGER_CHAT_URL_TOP_NOTICE_LOW_V_NORMAL;
            L632:
                return SystemType.ALL_MEMBERS_CHAT_URL_TOP_NOTICE_LOW_V_NORMAL;
            L633:
                return SystemType.CAN_MANAGER_CHAT_URL_TOP_NOTICE_HIGH_V_THREAD;
            L634:
                return SystemType.ALL_MEMBERS_CHAT_URL_TOP_NOTICE_HIGH_V_THREAD;
            L635:
                return SystemType.CAN_MANAGER_CHAT_URL_TOP_NOTICE_HIGH_V_NORMAL;
            L636:
                return SystemType.ALL_MEMBERS_CHAT_URL_TOP_NOTICE_HIGH_V_NORMAL;
            L637:
                return SystemType.ALL_MEMBERS_CAN_MANAGE_CHAT_TAB;
            L638:
                return SystemType.ONLY_ADMIN_CAN_MANAGE_CHAT_TAB;
            L639:
                return SystemType.AUTO_OPEN_TYPING_TRANSLATE;
            L640:
                return SystemType.UPGRADE_SUPER_CHAT;
            L641:
                return SystemType.CREATE_URGENT_ONLY_OWNER_AND_ADMIN_OFF;
            L642:
                return SystemType.CREATE_URGENT_ONLY_OWNER_AND_ADMIN_ON;
            L643:
                return SystemType.HELP_DESK_USER_JOIN_CHAT_NO_HISTORY;
            L644:
                return SystemType.HELP_DESK_USER_JOIN_CHAT;
            L645:
                return SystemType.USER_JOIN_CHAT_BY_LINK_NO_HISTORY;
            L646:
                return SystemType.USER_JOIN_CHAT_BY_LINK;
            L647:
                return SystemType.USER_JOIN_VIA_SHARE_NO_HISTORY;
            L648:
                return SystemType.USER_JOIN_VIA_SHARE_NEW;
            L649:
                return SystemType.USER_JOIN_VIA_QR_NEW;
            L650:
                return SystemType.USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN_NEW;
            L651:
                return SystemType.USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE_NO_HISTORY;
            L652:
                return SystemType.USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE;
            L653:
                return SystemType.USER_JOIN_CHAT_WELCOME_MESSAGE_NO_HISTORY;
            L654:
                return SystemType.USER_JOIN_CHAT_WELCOME_MESSAGE;
            L655:
                return SystemType.USER_JOIN_VIA_QR_CODE_NO_HISTORY;
            L656:
                return SystemType.USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN_NO_HISTORY;
            L657:
                return SystemType.USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE_NO_HISTORY;
            L658:
                return SystemType.USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK_NO_HISTORY;
            L659:
                return SystemType.USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD_NO_HISTORY;
            L660:
                return SystemType.USER_INVITE_OTHERS_JOIN_CIRCLE_NO_HISTORY;
            L661:
                return SystemType.JOIN_CIRCLE_VIA_HELP_DESK_MSG_CARD_NO_HISTORY;
            L662:
                return SystemType.CIRCLE_WELCOME_NEW_MEMBERS_NO_HISTORY;
            L663:
                return SystemType.GROUP_NEW_MEMBERS_CAN_VIEW_HISTORY_MESSAGES;
            L664:
                return SystemType.GROUP_NEW_MEMBERS_VIEW_CHAT_HISTORY_OFF;
            L665:
                return SystemType.GROUP_NEW_MEMBERS_VIEW_CHAT_HISTORY_ON;
            L666:
                return SystemType.USER_CHANGE_GROUP_MAIL_PERMISSION_OWNER_OR_ADMIN;
            L667:
                return SystemType.ADMIN_OPEN_ANYONE_POST_THREAD;
            L668:
                return SystemType.ADMIN_OPEN_ANYONE_POST;
            L669:
                return SystemType.USER_OPEN_ONLY_OWNER_AND_ADMIN_POST_THREAD;
            L670:
                return SystemType.USER_OPEN_ONLY_OWNER_AND_ADMIN_POST;
            L671:
                return SystemType.LOCAL_MENTION_BOTS_NOT_IN_CHAT;
            L672:
                return SystemType.DOUBAO_SHOW_NEW_CONTACT_NO_GREETING_READ_STATUS;
            L673:
                return SystemType.DOUBAO_SHOW_NEW_CONTACT_NO_GREETING;
            L674:
                return SystemType.DOUBAO_SHOW_JOIN_CHAT_STRANGER;
            L675:
                return SystemType.DOUBAO_SHOW_JOIN_CHAT;
            L676:
                return SystemType.DOUBAO_SHOW_READ_TIP;
            L677:
                return SystemType.DOUBAO_SHOW_NEW_CONTACT;
            L678:
                return SystemType.CHAT_USER_P2P_BOT_AUTO_MUTE;
            L679:
                return SystemType.CHAT_USER_BOT_AUTO_MUTE_S;
            L680:
                return SystemType.CHAT_USER_BOT_AUTO_MUTE;
            L681:
                return SystemType.CHAT_USER_LARGE_CHAT_AUTO_MUTE;
            L682:
                return SystemType.MANUAL_OPEN_TYPING_TRANSLATE_PROMPTS;
            L683:
                return SystemType.Lark_IM_BotCustomization;
            L684:
                return SystemType.MyAI_SceneTopicDynamicTip;
            L685:
                return SystemType.MyAI_NewTopicTip;
            L686:
                return SystemType.HIGHLIGHT_MESSAGES_FROM_CONTACT_TO_STAY_INFORMED;
            L687:
                return SystemType.SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE;
            L688:
                return SystemType.SIMPLIFY_OTHER_GRAB_MY_HONGBAO_NOT_OVER_OUT_NUM;
            L689:
                return SystemType.SIMPLIFY_USER_JOIN_CHAT_FROM_TEAM;
            L690:
                return SystemType.SIMPLIFY_WELCOME_USER_JOIN_FACE_TO_FACE_CHAT;
            L691:
                return SystemType.SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK;
            L692:
                return SystemType.SIMPLIFY_USER_JOIN_CHAT_BY_LINK_NO_HISTORY;
            L693:
                return SystemType.SIMPLIFY_USER_JOIN_VIA_GROUP_LINK;
            L694:
                return SystemType.SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE;
            L695:
                return SystemType.SIMPLIFY_USER_JOIN_VIA_QR_CODE_NO_HISTORY;
            L696:
                return SystemType.SIMPLIFY_USER_JOIN_VIA_QR_CODE;
            L697:
                return SystemType.SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD;
            L698:
                return SystemType.SIMPLIFY_USER_JOIN_VIA_SHARE_NO_HISTORY;
            L699:
                return SystemType.SIMPLIFY_USER_JOIN_VIA_SHARE;
            L700:
                return SystemType.SIMPLIFY_CIRCLE_WELCOME_NEW_MEMBERS;
            L701:
                return SystemType.SIMPLIFY_USER_JOIN_CHAT_WELCOME_MESSAGE_NO_HISTORY;
            L702:
                return SystemType.SIMPLIFY_USER_JOIN_CHAT_WELCOME_MESSAGE;
            L703:
                return SystemType.SIMPLIFY_SYSTEM_WELCOME_USER;
            L704:
                return SystemType.SIMPLIFY_USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE_NO_HISTORY;
            L705:
                return SystemType.SIMPLIFY_USER_INVITE_OTHERS_JOIN;
            L706:
                return SystemType.SIMPLIFY_OTHER_GRAB_MY_HONGBAO;
            L707:
                return SystemType.TEAM_CHAT_TURN_OPEN_MESSAGE;
            L708:
                return SystemType.TEAM_CHAT_TURN_OPEN_MESSAGE_TO_TEAM;
            L709:
                return SystemType.USER_JOIN_CHAT_FROM_TEAM;
            L710:
                return SystemType.BIND_CHAT_INTO_TEAM_MANAGER;
            L711:
                return SystemType.CREATE_TEAM_CHAT_V2_MANAGER;
            L712:
                return SystemType.Lark_IM_Server_WelcomeTo_Text;
            L713:
                return SystemType.CantChatUserPrivacySettings;
            L714:
                return SystemType.CHAT_ROOM_START;
            L715:
                return SystemType.VC_CALL_DISCONNECT;
            L716:
                return SystemType.VC_CALL_CONNECT_FAIL;
            L717:
                return SystemType.USER_JOIN_VIA_QR_CODE;
            L718:
                return SystemType.DECLINE_SPEC_INVITATION;
            L719:
                return SystemType.DECLINE_INVITATION;
            L720:
                return SystemType.NON_FRIENDS_NOTICE;
            L721:
                return SystemType.BUILD_FRIENDSHIP;
            L722:
                return SystemType.JOIN_DEPARTMENT_GROUP;
            L723:
                return SystemType.USER_ADD_MEETING_CHAT;
            L724:
                return SystemType.USER_REMOVE_OTHERS_FROM_MEETING;
            L725:
                return SystemType.USER_START_GROUP;
            L726:
                return SystemType.USER_DISMISSED_MEETING_CHAT;
            L727:
                return SystemType.USER_QUIT_MEETING_CHAT;
            L728:
                return SystemType.USER_INVITE_OTHERS_JOIN_MEETING;
            L729:
                return SystemType.USER_START_MEETING_GROUP_AND_INVITE;
            L730:
                return SystemType.VC_CALL_DURATION;
            L731:
                return SystemType.VC_CALL_FINISH_NOTICE;
            L732:
                return SystemType.VC_CALL_PARTI_BUSY;
            L733:
                return SystemType.VC_CALL_HOST_BUSY;
            L734:
                return SystemType.VC_CALL_PARTI_CANCEL;
            L735:
                return SystemType.VC_CALL_PARTI_NO_ANSWER;
            L736:
                return SystemType.VC_CALL_HOST_CANCEL;
            L737:
                return SystemType.USER_CALL_E2EE_VOICE_DURATION;
            L738:
                return SystemType.USER_CALL_E2EE_VOICE_ON_MISSING;
            L739:
                return SystemType.USER_CALL_E2EE_VOICE_ON_CANCELL;
            L740:
                return SystemType.USER_START_CRYPTO_GROUP_AND_INVITE;
            L741:
                return SystemType.USER_INVITE_OTHERS_JOIN_CRYPTO_CHAT;
            L742:
                return SystemType.USER_MODIFY_THREAD_TOPIC;
            L743:
                return SystemType.USER_SYNC_MESSAGE;
            L744:
                return SystemType.USER_MODIFY_EMAIL_SUBJECT;
            L745:
                return SystemType.MODIFY_EMAIL_MEMBERS;
            L746:
                return SystemType.REMOVE_EMAIL_MEMBERS;
            L747:
                return SystemType.ADD_EMAIL_MEMBERS;
            L748:
                return SystemType.WIPE_ANNOUNCEMENT;
            L749:
                return SystemType.TRANSFER_GROUP_CHAT_OWNER_AND_QUIT;
            L750:
                return SystemType.TRANSFER_GROUP_CHAT_OWNER;
            L751:
                return SystemType.USER_JOIN_VIA_SHARE;
            L752:
                return SystemType.DERIVE_FROM_P2P_CHAT;
            L753:
                return SystemType.USER_CHECK_OTHERS_TELEPHONE;
            L754:
                return SystemType.USER_REMOVE_GROUP_DESCRIPTION;
            L755:
                return SystemType.USER_REMOVE_OTHERS;
            L756:
                return SystemType.USER_QUIT_GROUP;
            L757:
                return SystemType.AUTO_OPEN_TYPING_TRANSLATE_V1;
            L758:
                return SystemType.MANUAL_OPEN_TYPING_TRANSLATE;
            L759:
                return SystemType.ONLY_ADMIN_CAN_MANAGE_TabsMenuWidgetsV1;
            L760:
                return SystemType.ALL_MEMBERS_CAN_MANAGE_TabsMenuWidgetsV1;
            L761:
                return SystemType.ONLY_ADMIN_CAN_MANAGE_TabsMenuWidgets;
            L762:
                return SystemType.ALL_MEMBERS_CAN_MANAGE_TabsMenuWidgets;
            L763:
                return SystemType.VOIP_INTERVIEWEE_NOT_ONLINE;
            L764:
                return SystemType.VC_CALL_INTERVIEWEE_NOT_ONLINE;
            L765:
                return SystemType.USER_INVITE_OTHERS_JOIN;
            L766:
                return SystemType.SYSTEM_WELCOME_USER;
            L767:
                return SystemType.USER_START_GROUP_AND_INVITE;
            L768:
                return SystemType.USER_MODIFY_GROUP_SETTINGS;
            L769:
                return SystemType.USER_MODIFY_GROUP_DESCRIPTION;
            L770:
                return SystemType.USER_MODIFY_GROUP_AVATAR;
            L771:
                return SystemType.USER_MODIFY_GROUP_NAME;
            L410:
                return SystemType.UNKNOWN;
            }
        }

        public static final /* synthetic */ SystemType[] a() {
            return new SystemType[]{UNKNOWN, USER_MODIFY_GROUP_NAME, USER_MODIFY_GROUP_AVATAR, USER_MODIFY_GROUP_DESCRIPTION, USER_MODIFY_GROUP_SETTINGS, USER_START_GROUP_AND_INVITE, SYSTEM_WELCOME_USER, USER_INVITE_OTHERS_JOIN, USER_QUIT_GROUP, USER_REMOVE_OTHERS, USER_REMOVE_GROUP_DESCRIPTION, USER_CHECK_OTHERS_TELEPHONE, DERIVE_FROM_P2P_CHAT, USER_JOIN_VIA_SHARE, TRANSFER_GROUP_CHAT_OWNER, TRANSFER_GROUP_CHAT_OWNER_AND_QUIT, WIPE_ANNOUNCEMENT, ADD_EMAIL_MEMBERS, REMOVE_EMAIL_MEMBERS, MODIFY_EMAIL_MEMBERS, USER_MODIFY_EMAIL_SUBJECT, USER_SYNC_MESSAGE, USER_MODIFY_THREAD_TOPIC, USER_INVITE_OTHERS_JOIN_CRYPTO_CHAT, USER_START_CRYPTO_GROUP_AND_INVITE, USER_CALL_E2EE_VOICE_ON_CANCELL, USER_CALL_E2EE_VOICE_ON_MISSING, USER_CALL_E2EE_VOICE_DURATION, VC_CALL_HOST_CANCEL, VC_CALL_PARTI_NO_ANSWER, VC_CALL_PARTI_CANCEL, VC_CALL_HOST_BUSY, VC_CALL_PARTI_BUSY, VC_CALL_FINISH_NOTICE, VC_CALL_DURATION, USER_START_MEETING_GROUP_AND_INVITE, USER_INVITE_OTHERS_JOIN_MEETING, USER_QUIT_MEETING_CHAT, USER_DISMISSED_MEETING_CHAT, USER_START_GROUP, USER_REMOVE_OTHERS_FROM_MEETING, USER_ADD_MEETING_CHAT, JOIN_DEPARTMENT_GROUP, BUILD_FRIENDSHIP, NON_FRIENDS_NOTICE, DECLINE_INVITATION, DECLINE_SPEC_INVITATION, USER_JOIN_VIA_QR_CODE, VC_CALL_CONNECT_FAIL, VC_CALL_DISCONNECT, USER_CALL_E2EE_VOICE_WHEN_REFUSED, USER_CALL_E2EE_VOICE_WHEN_OCCUPY, GRAB_OTHER_HONGBAO, OTHER_GRAB_MY_HONGBAO, LAST_HONGBAO_IS_GRABBED, SEND_HONGBAO_MESSAGE_FAILED, USER_SYNC_MESSAGE_V2, USER_SHARE_DOC_PERMISSION, USER_CHANGE_DOC_PERMISSION, USER_SHARE_DOC_FOLDER, USER_OPEN_ONLY_ADMIN_POST, USER_SEPECIFY_MEMBERS_POST, USER_LOW_VERSION_HINT, USER_THREAD_CLEAR_TITLE, USER_OPEN_ANYONE_POST, CRYPTO_MESSAGE_NOTICE_NO_TRANSMIT, CRYPTO_MESSAGE_NOTICE_SEVEN_DAYS, CRYPTO_MESSAGE_NOTICE_BURN_AFTER_READING, USER_SET_CRYPTO_MESSAGE_BURN_LIFE, USER_TOOK_SCREENSHOT_IN_CRYPTO_CHAT, CRYPTO_LOW_VERSION_HINT, INVITE_CHAT_MEMBER_2_OUT_CHAT, CREATE_CHAT_AND_INVITE_FROM_CHAT_MEMBER, AUTO_TRANSLATE_GUIDANCE, WITHDRAW_ADDED_USER, SAIPAN_REMIND_ONCALL_REPLY, SAIPAN_REMIND_ONCALL_DONE, SAIPAN_REMIND_ONCALL_AUTO_DONE, SAIPAN_ADD_ONCALL, VC_MEETING_STARTED, USER_OPEN_ONLY_ADMIN_POST_THREAD, USER_SPECIFY_MEMBERS_POST_THREAD, USER_OPEN_ANYONE_POST_THREAD, VC_MEETING_ENDED_OVER_ONE_HOUR, INVITE_AT_CHATTERS, VC_MEETING_ENDED_LESS_ONE_HOUR, VC_MEETING_ENDED_LESS_ONE_MIN, VC_DEFAULT_MEETING_ENDED_OVER_ONE_HOUR, VC_DEFAULT_MEETING_ENDED_LESS_ONE_HOUR, VC_DEFAULT_MEETING_ENDED_LESS_ONE_MIN, VC_VIDEO_CHAT_STARTED, VC_CALL_ENDED_OVER_ONE_HOUR, VC_CALL_ENDED_LESS_ONE_HOUR, VC_CALL_ENDED_LESS_ONE_MIN, VC_CALL_DISCONNECTED_ENDED_OVER_ONE_HOUR, VC_CALL_DISCONNECTED_ENDED_LESS_ONE_HOUR, VC_CALL_DISCONNECTED_ENDED_LESS_ONE_MIN, VC_CALL_INTERVIEWEE_NO_ANSWER, VC_CALL_INTERVIEWEE_REFUSE, VC_CALL_INTERVIEWER_CANCEL, VC_CALL_INTERVIEWEE_BUSY, VOIP_ENDED_OVER_ONE_HOUR, VOIP_ENDED_LESS_ONE_HOUR, VOIP_ENDED_LESS_ONE_MIN, VOIP_DISCONNECTED_ENDED_OVER_ONE_HOUR, VOIP_DISCONNECTED_ENDED_LESS_ONE_HOUR, VOIP_DISCONNECTED_ENDED_LESS_ONE_MIN, VOIP_INTERVIEWEE_NO_ANSWER, VOIP_INTERVIEWEE_REFUSE, VOIP_INTERVIEWER_CANCEL, VOIP_INTERVIEWEE_BUSY, SAIPAN_SELECT_CARD_CONTENT, SAIPAN_USER_QUEUEING, SAIPAN_NOTIFY_AGENT_QUEUEING, SAIPAN_RESERVED_3, SAIPAN_RESERVED_4, SAIPAN_RESERVED_5, CANCEL_EMERGENCY_CALL, HANGUP_EMERGENCY_CALL, START_EMERGENCY_CALL, MEETING_TRANSFER_TO_CHAT, MEETING_TRANSFER_TO_CHAT_WITH_DOC_URL, VC_CALL_INTERVIEWEE_NOT_ONLINE, VOIP_INTERVIEWEE_NOT_ONLINE, USER_JOIN_CHAT_AUTO_MUTE, EMERGENCY_CALL_NOTANSWER, INVITE_CHATTERS_TO_CHAT_NO_PERMISSION_LESS_THRESHOLD, INVITE_CHATTERS_TO_CHAT_NO_PERMISSION_OVER_THRESHOLD, CHAT_ROOM_START, USER_TURN_ON_GROUP_MAIL, USER_TURN_OFF_GROUP_MAIL, USER_CHANGE_GROUP_MAIL_PERMISSION_OWNER, USER_CHANGE_GROUP_MAIL_PERMISSION_MEMBERS, USER_CHANGE_GROUP_MAIL_PERMISSION_TENANT, USER_CHANGE_GROUP_MAIL_PERMISSION_EVERYONE, USER_JOIN_VIA_GROUP_LINK, CHAT_ROOM_END, CHAT_ROOM_START_V2, SYSTEM_EPHEMERAL_NOTIFY, BUILD_ONEWAY_RELATION, INVITE_FRIENDS_SUCCESS, CREATE_P2P_SOURCE, SEND_MESSAGE_COLLABORATION_AUTH_FAILED, NOT_COLLABORATION_AUTH_SEND_MSG_LIMIT_NOTIFY, NOT_COLLABORATION_AUTH_SEND_MSG_REACH_LIMIT, USER_INVITE_BOT_JOIN, DOC_TEMPLATE_GROUP_SHARE, SHEET_TEMPLATE_GROUP_SHARE, MIND_NOTE_TEMPLATE_GROUP_SHARE, CantChatUserPrivacySettings, CREATE_CIRCLE_AND_INVITE_OTHERS_FROM_CHAT, MENTIONED_PERSON_NOT_IN_CIRCLE, INVITE_MEMBERS_TO_JOIN_EXTERNAL_CIRCLE, CIRCLE_CANT_ADD_MEMBERS_DUE_TO_ADMIN_SETTINGS, CIRCLE_CANT_ADD_MANY_MEMBERS_DUE_TO_ADMIN_SETTINGS, JOIN_CIRCLE_VIA_HELP_DESK_MSG_CARD, CIRCLE_WELCOME_NEW_MEMBERS, TRANSFER_CIRCLE_OWNER, TRANSFER_CIRCLE_OWNER_AND_LEAVE, CIRCLE_USER_CHANGE_DOC_PERMISSION, USER_INVITE_BOT_JOIN_CIRCLE, USER_INVITE_OTHERS_JOIN_CIRCLE, USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK, CIRCLE_TOO_MANY_MEMBERS_NOTIFICATION_MUTED, USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE, USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD, USER_MODIFY_CIRCLE_AVATAR, USER_MODIFY_CIRCLE_DESCRIPTION, USER_MODIFY_CIRCLE_NAME, USER_MODIFY_CIRCLE_OWNER, USER_MODIFY_CIRCLE_SETTINGS, USER_SET_ONLY_CIRCLE_OWNER_CAN_POST, USER_SET_ONLY_CIRCLE_OWNER_CAN_CREATE_NEW_TOPICS, USER_LEAVE_CIRCLE, USER_REMOVE_CIRCLE_DESCRIPTION, USER_REMOVE_CIRCLE_MEMBERS, USER_CREATE_CIRCLE, USER_CREATE_CIRCLE_AND_INVITE, USER_SYNC_MESSAGE_TO_CIRCLE, USER_CLEAR_CIRCLE_ANNOUNCEMENT, USER_WITHDRAW_CIRCLE_INVITATION, CIRCLE_ANONYMOUS_ON, CIRCLE_ANONYMOUS_OFF, Lark_IM_CreateGroup_UserAndGroup_OwnerInvite, Lark_IM_CreateGroup_UserAndGroup_MemberInvite, Lark_IM_CreateGroup_UserAndDepartment_OwnerInvite, Lark_IM_CreateGroup_UserAndDepartment_MemberInivite, Lark_IM_CreateGroup_GroupAndDepartment_OwnerInvite, Lark_IM_CreateGroup_GroupAndDepartment_MemberInvite, Lark_IM_CreateGroup_UserAndGroupAndDepartment_OwnerInvite, Lark_IM_CreateGroup_UserAndGroupAndDepartment_MemberInvite, Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_Inviter, Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_Inviter, Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_Invitee, Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_Invitee, Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_OtherMembers, Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_OtherMembers, Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_Inviter, Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_Inviter, Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_Invitee, Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_Invitee, Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_OtherMembers, Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_OtherMembers, Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_Inviter, Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_Inviter, Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_Invitee, Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_Invitee, Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_OtherMembers, Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_OtherMembers, Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_Inviter, Lark_IM_EnterGroup_Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_Inviter, Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_Invitee, Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_Invitee, Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_OtherMembers, Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_OtherMembers, Lark_IM_EnterGroup_User_ChatHistoryYes_FromTeam, Lark_IM_Server_WelcomeTo_Text, INVITE_CHAT_MEMBER_2_CHAT, WILL_REACH_CHAT_CHATTER_COUNT_LIMIT, ALREADY_REACH_CHAT_CHATTER_COUNT_LIMIT, USER_CREATE_FACE_TO_FACE_CHAT, USER_JOIN_FACE_TO_FACE_CHAT, WELCOME_USER_JOIN_FACE_TO_FACE_CHAT, USER_CREATED_GROUP_AND_INVITED_OTHER_CHATTER_CHAT_DEPARTMENT, USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN, CREATE_CHAT_AND_INVITE_FROM_CHAT_DEPARTMENT_MEMBER, USER_OPEN_ONLY_SEPECIFY_MEMBERS_POST, USER_OPEN_ONLY_SEPECIFY_MEMBERS_POST_THREAD, USER_REMOVE_SEPECIFY_MEMBERS_POST, USER_REMOVE_SEPECIFY_MEMBERS_POST_THREAD, ADD_MEMBER_TO_ADMIN_LIST, REMOVE_MEMBER_FROM_ADMIN_LIST, USER_OPEN_ONLY_OWNER_AND_ADMIN_POST, USER_OPEN_ONLY_OWNER_AND_ADMIN_POST_THREAD, ADMIN_OPEN_ANYONE_POST, ADMIN_OPEN_ANYONE_POST_THREAD, USER_CHANGE_GROUP_MAIL_PERMISSION_OWNER_OR_ADMIN, GROUP_NEW_MEMBERS_VIEW_CHAT_HISTORY_ON, GROUP_NEW_MEMBERS_VIEW_CHAT_HISTORY_OFF, GROUP_NEW_MEMBERS_CAN_VIEW_HISTORY_MESSAGES, CIRCLE_WELCOME_NEW_MEMBERS_NO_HISTORY, JOIN_CIRCLE_VIA_HELP_DESK_MSG_CARD_NO_HISTORY, USER_INVITE_OTHERS_JOIN_CIRCLE_NO_HISTORY, USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD_NO_HISTORY, USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK_NO_HISTORY, USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE_NO_HISTORY, USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN_NEW, USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN_NO_HISTORY, USER_JOIN_VIA_QR_NEW, USER_JOIN_VIA_QR_CODE_NO_HISTORY, USER_JOIN_CHAT_WELCOME_MESSAGE, USER_JOIN_CHAT_WELCOME_MESSAGE_NO_HISTORY, USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE, USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE_NO_HISTORY, USER_JOIN_VIA_SHARE_NEW, USER_JOIN_VIA_SHARE_NO_HISTORY, USER_JOIN_CHAT_BY_LINK, USER_JOIN_CHAT_BY_LINK_NO_HISTORY, HELP_DESK_USER_JOIN_CHAT, HELP_DESK_USER_JOIN_CHAT_NO_HISTORY, UPGRADE_SUPER_CHAT, CREATE_URGENT_ONLY_OWNER_AND_ADMIN_ON, CREATE_URGENT_ONLY_OWNER_AND_ADMIN_OFF, AUTO_OPEN_TYPING_TRANSLATE, ONLY_ADMIN_CAN_MANAGE_CHAT_TAB, ALL_MEMBERS_CAN_MANAGE_CHAT_TAB, ALL_MEMBERS_CAN_MANAGE_TabsMenuWidgets, ONLY_ADMIN_CAN_MANAGE_TabsMenuWidgets, ALL_MEMBERS_CAN_MANAGE_TabsMenuWidgetsV1, ONLY_ADMIN_CAN_MANAGE_TabsMenuWidgetsV1, ALL_MEMBERS_CHAT_URL_TOP_NOTICE_HIGH_V_NORMAL, CAN_MANAGER_CHAT_URL_TOP_NOTICE_HIGH_V_NORMAL, ALL_MEMBERS_CHAT_URL_TOP_NOTICE_HIGH_V_THREAD, CAN_MANAGER_CHAT_URL_TOP_NOTICE_HIGH_V_THREAD, ALL_MEMBERS_CHAT_URL_TOP_NOTICE_LOW_V_NORMAL, CAN_MANAGER_CHAT_URL_TOP_NOTICE_LOW_V_NORMAL, ALL_MEMBERS_CHAT_URL_TOP_NOTICE_LOW_V_THREAD, CAN_MANAGER_CHAT_URL_TOP_NOTICE_LOW_V_THREAD, EXTERNAL_COORDINATE_CTL, TARGET_EXTERNAL_COORDINATE_CTL, CHAT_OPEN_CAN_SEARCH_SYSTEM_MESSAGE, CHAT_CLOSED_CAN_SEARCH_SYSTEM_MESSAGE, BITABLE_TEMPLATE_GROUP_SHARE_SYSTEM_MESSAGE, MANUAL_OPEN_TYPING_TRANSLATE, AUTO_OPEN_TYPING_TRANSLATE_V1, CREATE_TEAM_AND_INVITE_MEMBERS, UPDATE_CHAT_TO_TEAM, INVITE_MEMBERS_JOIN_TEAM, MEMBERS_JOIN_TEAM_FAIL, KICK_MEMBERS_OUT_TEAM, MEMBER_LEAVE_TEAM, TRANSFER_TEAM_OWNER, MODIFY_TEAM_NAME, ENABLE_TEAM_CREATE_CHAT_PERMISSION, CLOSE_TEAM_CREATE_CHAT_PERMISSION, ENABLE_TEAM_ADD_MEMBERS_PERMISSION, CLOSE_TEAM_ADD_MEMBERS_PERMISSION, DISSOLVE_TEAM_AND_UNBIND_CHAT, CREATE_TEAM_CHAT, BIND_CHAT_INTO_TEAM, UNBIND_CHAT_WITH_TEAM, MEMBERS_JOIN_TEAM_CHAT_SEE_HISTORICAL, MEMBERS_JOIN_TEAM_CHAT_SEE_NEW_MESSAGES, MEMBERS_JOIN_TEAM_CHAT_FAIL, MEMBERS_LEAVE_AND_TRANSFER, USER_CREATE_TEAM, CHECK_USER_PHONE_NUMBER, CHECK_USER_PHONE_USER_IN_WHITELIST, CantBuzzEmptyPhoneNumber, CantBuzzEmptyName, BuzzLimit, BuzzSystemError, BuzzTimeOut, CantBuzzMembers, BuzzNotAnswer, MultiItemSystemContent, VC_ENTERPRISE_PHONE_CREATE, MODIFY_TEAM_AVATAR, MODIFY_TEAM_DESCRIPTION, DELETE_TEAM_DESCRIPTION, CREATE_TEAM_CHAT_V2_MANAGER, BIND_CHAT_INTO_TEAM_MANAGER, USER_JOIN_CHAT_FROM_TEAM, TEAM_CHAT_TURN_OPEN_MESSAGE_TO_TEAM, TEAM_CHAT_TURN_OPEN_MESSAGE, SIMPLIFY_OTHER_GRAB_MY_HONGBAO, SIMPLIFY_OTHER_GRAB_MY_HONGBAO_NOT_OVER_OUT_NUM, SIMPLIFY_USER_INVITE_OTHERS_JOIN, SIMPLIFY_USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE_NO_HISTORY, SIMPLIFY_SYSTEM_WELCOME_USER, SIMPLIFY_USER_JOIN_CHAT_WELCOME_MESSAGE, SIMPLIFY_USER_JOIN_CHAT_WELCOME_MESSAGE_NO_HISTORY, SIMPLIFY_CIRCLE_WELCOME_NEW_MEMBERS, SIMPLIFY_USER_JOIN_VIA_SHARE, SIMPLIFY_USER_JOIN_VIA_SHARE_NO_HISTORY, SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD, SIMPLIFY_USER_JOIN_VIA_QR_CODE, SIMPLIFY_USER_JOIN_VIA_QR_CODE_NO_HISTORY, SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE, SIMPLIFY_USER_JOIN_VIA_GROUP_LINK, SIMPLIFY_USER_JOIN_CHAT_BY_LINK_NO_HISTORY, SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK, SIMPLIFY_WELCOME_USER_JOIN_FACE_TO_FACE_CHAT, SIMPLIFY_USER_JOIN_CHAT_FROM_TEAM, SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE, HIGHLIGHT_MESSAGES_FROM_CONTACT_TO_STAY_INFORMED, MyAI_NewTopicTip, MyAI_SceneTopicDynamicTip, Lark_IM_BotCustomization, MANUAL_OPEN_TYPING_TRANSLATE_PROMPTS, CHAT_USER_LARGE_CHAT_AUTO_MUTE, CHAT_USER_BOT_AUTO_MUTE, CHAT_USER_BOT_AUTO_MUTE_S, CHAT_USER_P2P_BOT_AUTO_MUTE, DOUBAO_SHOW_NEW_CONTACT, DOUBAO_SHOW_READ_TIP, DOUBAO_SHOW_JOIN_CHAT, DOUBAO_SHOW_JOIN_CHAT_STRANGER, DOUBAO_SHOW_NEW_CONTACT_NO_GREETING, DOUBAO_SHOW_NEW_CONTACT_NO_GREETING_READ_STATUS, LOCAL_MENTION_BOTS_NOT_IN_CHAT};
        }

        @JvmStatic
        public static final SystemType fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<SystemType> getEntries() {
            return b;
        }

        public static SystemType[] values() {
            return (SystemType[]) a.clone();
        }

        static {
            SystemType r0 = new SystemType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            USER_MODIFY_GROUP_NAME = new SystemType("USER_MODIFY_GROUP_NAME", 1, 1);
            USER_MODIFY_GROUP_AVATAR = new SystemType("USER_MODIFY_GROUP_AVATAR", 2, 2);
            USER_MODIFY_GROUP_DESCRIPTION = new SystemType("USER_MODIFY_GROUP_DESCRIPTION", 3, 3);
            USER_MODIFY_GROUP_SETTINGS = new SystemType("USER_MODIFY_GROUP_SETTINGS", 4, 4);
            USER_START_GROUP_AND_INVITE = new SystemType("USER_START_GROUP_AND_INVITE", 5, 5);
            SYSTEM_WELCOME_USER = new SystemType("SYSTEM_WELCOME_USER", 6, 6);
            USER_INVITE_OTHERS_JOIN = new SystemType("USER_INVITE_OTHERS_JOIN", 7, 7);
            USER_QUIT_GROUP = new SystemType("USER_QUIT_GROUP", 8, 8);
            USER_REMOVE_OTHERS = new SystemType("USER_REMOVE_OTHERS", 9, 9);
            USER_REMOVE_GROUP_DESCRIPTION = new SystemType("USER_REMOVE_GROUP_DESCRIPTION", 10, 10);
            USER_CHECK_OTHERS_TELEPHONE = new SystemType("USER_CHECK_OTHERS_TELEPHONE", 11, 11);
            DERIVE_FROM_P2P_CHAT = new SystemType("DERIVE_FROM_P2P_CHAT", 12, 12);
            USER_JOIN_VIA_SHARE = new SystemType("USER_JOIN_VIA_SHARE", 13, 13);
            TRANSFER_GROUP_CHAT_OWNER = new SystemType("TRANSFER_GROUP_CHAT_OWNER", 14, 14);
            TRANSFER_GROUP_CHAT_OWNER_AND_QUIT = new SystemType("TRANSFER_GROUP_CHAT_OWNER_AND_QUIT", 15, 15);
            WIPE_ANNOUNCEMENT = new SystemType("WIPE_ANNOUNCEMENT", 16, 16);
            ADD_EMAIL_MEMBERS = new SystemType("ADD_EMAIL_MEMBERS", 17, 17);
            REMOVE_EMAIL_MEMBERS = new SystemType("REMOVE_EMAIL_MEMBERS", 18, 18);
            MODIFY_EMAIL_MEMBERS = new SystemType("MODIFY_EMAIL_MEMBERS", 19, 19);
            USER_MODIFY_EMAIL_SUBJECT = new SystemType("USER_MODIFY_EMAIL_SUBJECT", 20, 20);
            USER_SYNC_MESSAGE = new SystemType("USER_SYNC_MESSAGE", 21, 21);
            USER_MODIFY_THREAD_TOPIC = new SystemType("USER_MODIFY_THREAD_TOPIC", 22, 22);
            USER_INVITE_OTHERS_JOIN_CRYPTO_CHAT = new SystemType("USER_INVITE_OTHERS_JOIN_CRYPTO_CHAT", 23, 23);
            USER_START_CRYPTO_GROUP_AND_INVITE = new SystemType("USER_START_CRYPTO_GROUP_AND_INVITE", 24, 24);
            USER_CALL_E2EE_VOICE_ON_CANCELL = new SystemType("USER_CALL_E2EE_VOICE_ON_CANCELL", 25, 25);
            USER_CALL_E2EE_VOICE_ON_MISSING = new SystemType("USER_CALL_E2EE_VOICE_ON_MISSING", 26, 26);
            USER_CALL_E2EE_VOICE_DURATION = new SystemType("USER_CALL_E2EE_VOICE_DURATION", 27, 27);
            VC_CALL_HOST_CANCEL = new SystemType("VC_CALL_HOST_CANCEL", 28, 28);
            VC_CALL_PARTI_NO_ANSWER = new SystemType("VC_CALL_PARTI_NO_ANSWER", 29, 29);
            VC_CALL_PARTI_CANCEL = new SystemType("VC_CALL_PARTI_CANCEL", 30, 30);
            VC_CALL_HOST_BUSY = new SystemType("VC_CALL_HOST_BUSY", 31, 31);
            VC_CALL_PARTI_BUSY = new SystemType("VC_CALL_PARTI_BUSY", 32, 32);
            VC_CALL_FINISH_NOTICE = new SystemType("VC_CALL_FINISH_NOTICE", 33, 33);
            VC_CALL_DURATION = new SystemType("VC_CALL_DURATION", 34, 34);
            USER_START_MEETING_GROUP_AND_INVITE = new SystemType("USER_START_MEETING_GROUP_AND_INVITE", 35, 35);
            USER_INVITE_OTHERS_JOIN_MEETING = new SystemType("USER_INVITE_OTHERS_JOIN_MEETING", 36, 36);
            USER_QUIT_MEETING_CHAT = new SystemType("USER_QUIT_MEETING_CHAT", 37, 37);
            USER_DISMISSED_MEETING_CHAT = new SystemType("USER_DISMISSED_MEETING_CHAT", 38, 38);
            USER_START_GROUP = new SystemType("USER_START_GROUP", 39, 39);
            USER_REMOVE_OTHERS_FROM_MEETING = new SystemType("USER_REMOVE_OTHERS_FROM_MEETING", 40, 40);
            USER_ADD_MEETING_CHAT = new SystemType("USER_ADD_MEETING_CHAT", 41, 41);
            JOIN_DEPARTMENT_GROUP = new SystemType("JOIN_DEPARTMENT_GROUP", 42, 42);
            BUILD_FRIENDSHIP = new SystemType("BUILD_FRIENDSHIP", 43, 43);
            NON_FRIENDS_NOTICE = new SystemType("NON_FRIENDS_NOTICE", 44, 44);
            DECLINE_INVITATION = new SystemType("DECLINE_INVITATION", 45, 45);
            DECLINE_SPEC_INVITATION = new SystemType("DECLINE_SPEC_INVITATION", 46, 46);
            USER_JOIN_VIA_QR_CODE = new SystemType("USER_JOIN_VIA_QR_CODE", 47, 47);
            VC_CALL_CONNECT_FAIL = new SystemType("VC_CALL_CONNECT_FAIL", 48, 48);
            VC_CALL_DISCONNECT = new SystemType("VC_CALL_DISCONNECT", 49, 49);
            USER_CALL_E2EE_VOICE_WHEN_REFUSED = new SystemType("USER_CALL_E2EE_VOICE_WHEN_REFUSED", 50, 52);
            USER_CALL_E2EE_VOICE_WHEN_OCCUPY = new SystemType("USER_CALL_E2EE_VOICE_WHEN_OCCUPY", 51, 53);
            GRAB_OTHER_HONGBAO = new SystemType("GRAB_OTHER_HONGBAO", 52, 54);
            OTHER_GRAB_MY_HONGBAO = new SystemType("OTHER_GRAB_MY_HONGBAO", 53, 55);
            LAST_HONGBAO_IS_GRABBED = new SystemType("LAST_HONGBAO_IS_GRABBED", 54, 56);
            SEND_HONGBAO_MESSAGE_FAILED = new SystemType("SEND_HONGBAO_MESSAGE_FAILED", 55, 57);
            USER_SYNC_MESSAGE_V2 = new SystemType("USER_SYNC_MESSAGE_V2", 56, 58);
            USER_SHARE_DOC_PERMISSION = new SystemType("USER_SHARE_DOC_PERMISSION", 57, 59);
            USER_CHANGE_DOC_PERMISSION = new SystemType("USER_CHANGE_DOC_PERMISSION", 58, 60);
            USER_SHARE_DOC_FOLDER = new SystemType("USER_SHARE_DOC_FOLDER", 59, 61);
            USER_OPEN_ONLY_ADMIN_POST = new SystemType("USER_OPEN_ONLY_ADMIN_POST", 60, 62);
            USER_SEPECIFY_MEMBERS_POST = new SystemType("USER_SEPECIFY_MEMBERS_POST", 61, 63);
            USER_LOW_VERSION_HINT = new SystemType("USER_LOW_VERSION_HINT", 62, 64);
            USER_THREAD_CLEAR_TITLE = new SystemType("USER_THREAD_CLEAR_TITLE", 63, 65);
            USER_OPEN_ANYONE_POST = new SystemType("USER_OPEN_ANYONE_POST", 64, 66);
            CRYPTO_MESSAGE_NOTICE_NO_TRANSMIT = new SystemType("CRYPTO_MESSAGE_NOTICE_NO_TRANSMIT", 65, 67);
            CRYPTO_MESSAGE_NOTICE_SEVEN_DAYS = new SystemType("CRYPTO_MESSAGE_NOTICE_SEVEN_DAYS", 66, 68);
            CRYPTO_MESSAGE_NOTICE_BURN_AFTER_READING = new SystemType("CRYPTO_MESSAGE_NOTICE_BURN_AFTER_READING", 67, 69);
            USER_SET_CRYPTO_MESSAGE_BURN_LIFE = new SystemType("USER_SET_CRYPTO_MESSAGE_BURN_LIFE", 68, 70);
            USER_TOOK_SCREENSHOT_IN_CRYPTO_CHAT = new SystemType("USER_TOOK_SCREENSHOT_IN_CRYPTO_CHAT", 69, 71);
            CRYPTO_LOW_VERSION_HINT = new SystemType("CRYPTO_LOW_VERSION_HINT", 70, 72);
            INVITE_CHAT_MEMBER_2_OUT_CHAT = new SystemType("INVITE_CHAT_MEMBER_2_OUT_CHAT", 71, 73);
            CREATE_CHAT_AND_INVITE_FROM_CHAT_MEMBER = new SystemType("CREATE_CHAT_AND_INVITE_FROM_CHAT_MEMBER", 72, 74);
            AUTO_TRANSLATE_GUIDANCE = new SystemType("AUTO_TRANSLATE_GUIDANCE", 73, 75);
            WITHDRAW_ADDED_USER = new SystemType("WITHDRAW_ADDED_USER", 74, 76);
            SAIPAN_REMIND_ONCALL_REPLY = new SystemType("SAIPAN_REMIND_ONCALL_REPLY", 75, 77);
            SAIPAN_REMIND_ONCALL_DONE = new SystemType("SAIPAN_REMIND_ONCALL_DONE", 76, 78);
            SAIPAN_REMIND_ONCALL_AUTO_DONE = new SystemType("SAIPAN_REMIND_ONCALL_AUTO_DONE", 77, 79);
            SAIPAN_ADD_ONCALL = new SystemType("SAIPAN_ADD_ONCALL", 78, 80);
            VC_MEETING_STARTED = new SystemType("VC_MEETING_STARTED", 79, 83);
            USER_OPEN_ONLY_ADMIN_POST_THREAD = new SystemType("USER_OPEN_ONLY_ADMIN_POST_THREAD", 80, 84);
            USER_SPECIFY_MEMBERS_POST_THREAD = new SystemType("USER_SPECIFY_MEMBERS_POST_THREAD", 81, 85);
            USER_OPEN_ANYONE_POST_THREAD = new SystemType("USER_OPEN_ANYONE_POST_THREAD", 82, 86);
            VC_MEETING_ENDED_OVER_ONE_HOUR = new SystemType("VC_MEETING_ENDED_OVER_ONE_HOUR", 83, 87);
            INVITE_AT_CHATTERS = new SystemType("INVITE_AT_CHATTERS", 84, 88);
            VC_MEETING_ENDED_LESS_ONE_HOUR = new SystemType("VC_MEETING_ENDED_LESS_ONE_HOUR", 85, 89);
            VC_MEETING_ENDED_LESS_ONE_MIN = new SystemType("VC_MEETING_ENDED_LESS_ONE_MIN", 86, 90);
            VC_DEFAULT_MEETING_ENDED_OVER_ONE_HOUR = new SystemType("VC_DEFAULT_MEETING_ENDED_OVER_ONE_HOUR", 87, 91);
            VC_DEFAULT_MEETING_ENDED_LESS_ONE_HOUR = new SystemType("VC_DEFAULT_MEETING_ENDED_LESS_ONE_HOUR", 88, 92);
            VC_DEFAULT_MEETING_ENDED_LESS_ONE_MIN = new SystemType("VC_DEFAULT_MEETING_ENDED_LESS_ONE_MIN", 89, 93);
            VC_VIDEO_CHAT_STARTED = new SystemType("VC_VIDEO_CHAT_STARTED", 90, 94);
            VC_CALL_ENDED_OVER_ONE_HOUR = new SystemType("VC_CALL_ENDED_OVER_ONE_HOUR", 91, 95);
            VC_CALL_ENDED_LESS_ONE_HOUR = new SystemType("VC_CALL_ENDED_LESS_ONE_HOUR", 92, 96);
            VC_CALL_ENDED_LESS_ONE_MIN = new SystemType("VC_CALL_ENDED_LESS_ONE_MIN", 93, 97);
            VC_CALL_DISCONNECTED_ENDED_OVER_ONE_HOUR = new SystemType("VC_CALL_DISCONNECTED_ENDED_OVER_ONE_HOUR", 94, 98);
            VC_CALL_DISCONNECTED_ENDED_LESS_ONE_HOUR = new SystemType("VC_CALL_DISCONNECTED_ENDED_LESS_ONE_HOUR", 95, 99);
            VC_CALL_DISCONNECTED_ENDED_LESS_ONE_MIN = new SystemType("VC_CALL_DISCONNECTED_ENDED_LESS_ONE_MIN", 96, 100);
            VC_CALL_INTERVIEWEE_NO_ANSWER = new SystemType("VC_CALL_INTERVIEWEE_NO_ANSWER", 97, 101);
            VC_CALL_INTERVIEWEE_REFUSE = new SystemType("VC_CALL_INTERVIEWEE_REFUSE", 98, 102);
            VC_CALL_INTERVIEWER_CANCEL = new SystemType("VC_CALL_INTERVIEWER_CANCEL", 99, 103);
            VC_CALL_INTERVIEWEE_BUSY = new SystemType("VC_CALL_INTERVIEWEE_BUSY", 100, 104);
            VOIP_ENDED_OVER_ONE_HOUR = new SystemType("VOIP_ENDED_OVER_ONE_HOUR", 101, 105);
            VOIP_ENDED_LESS_ONE_HOUR = new SystemType("VOIP_ENDED_LESS_ONE_HOUR", 102, 106);
            VOIP_ENDED_LESS_ONE_MIN = new SystemType("VOIP_ENDED_LESS_ONE_MIN", 103, 107);
            VOIP_DISCONNECTED_ENDED_OVER_ONE_HOUR = new SystemType("VOIP_DISCONNECTED_ENDED_OVER_ONE_HOUR", 104, 108);
            VOIP_DISCONNECTED_ENDED_LESS_ONE_HOUR = new SystemType("VOIP_DISCONNECTED_ENDED_LESS_ONE_HOUR", 105, 109);
            VOIP_DISCONNECTED_ENDED_LESS_ONE_MIN = new SystemType("VOIP_DISCONNECTED_ENDED_LESS_ONE_MIN", 106, 110);
            VOIP_INTERVIEWEE_NO_ANSWER = new SystemType("VOIP_INTERVIEWEE_NO_ANSWER", 107, 111);
            VOIP_INTERVIEWEE_REFUSE = new SystemType("VOIP_INTERVIEWEE_REFUSE", 108, 112);
            VOIP_INTERVIEWER_CANCEL = new SystemType("VOIP_INTERVIEWER_CANCEL", 109, 113);
            VOIP_INTERVIEWEE_BUSY = new SystemType("VOIP_INTERVIEWEE_BUSY", 110, 114);
            SAIPAN_SELECT_CARD_CONTENT = new SystemType("SAIPAN_SELECT_CARD_CONTENT", 111, 115);
            SAIPAN_USER_QUEUEING = new SystemType("SAIPAN_USER_QUEUEING", 112, 116);
            SAIPAN_NOTIFY_AGENT_QUEUEING = new SystemType("SAIPAN_NOTIFY_AGENT_QUEUEING", 113, 117);
            SAIPAN_RESERVED_3 = new SystemType("SAIPAN_RESERVED_3", 114, 118);
            SAIPAN_RESERVED_4 = new SystemType("SAIPAN_RESERVED_4", 115, 119);
            SAIPAN_RESERVED_5 = new SystemType("SAIPAN_RESERVED_5", 116, 120);
            CANCEL_EMERGENCY_CALL = new SystemType("CANCEL_EMERGENCY_CALL", 117, 121);
            HANGUP_EMERGENCY_CALL = new SystemType("HANGUP_EMERGENCY_CALL", 118, 122);
            START_EMERGENCY_CALL = new SystemType("START_EMERGENCY_CALL", 119, 123);
            MEETING_TRANSFER_TO_CHAT = new SystemType("MEETING_TRANSFER_TO_CHAT", 120, 124);
            MEETING_TRANSFER_TO_CHAT_WITH_DOC_URL = new SystemType("MEETING_TRANSFER_TO_CHAT_WITH_DOC_URL", 121, 125);
            VC_CALL_INTERVIEWEE_NOT_ONLINE = new SystemType("VC_CALL_INTERVIEWEE_NOT_ONLINE", 122, 131);
            VOIP_INTERVIEWEE_NOT_ONLINE = new SystemType("VOIP_INTERVIEWEE_NOT_ONLINE", 123, 132);
            USER_JOIN_CHAT_AUTO_MUTE = new SystemType("USER_JOIN_CHAT_AUTO_MUTE", 124, 138);
            EMERGENCY_CALL_NOTANSWER = new SystemType("EMERGENCY_CALL_NOTANSWER", 125, 139);
            INVITE_CHATTERS_TO_CHAT_NO_PERMISSION_LESS_THRESHOLD = new SystemType("INVITE_CHATTERS_TO_CHAT_NO_PERMISSION_LESS_THRESHOLD", 126, 140);
            INVITE_CHATTERS_TO_CHAT_NO_PERMISSION_OVER_THRESHOLD = new SystemType("INVITE_CHATTERS_TO_CHAT_NO_PERMISSION_OVER_THRESHOLD", 127, 141);
            CHAT_ROOM_START = new SystemType("CHAT_ROOM_START", 128, 143);
            USER_TURN_ON_GROUP_MAIL = new SystemType("USER_TURN_ON_GROUP_MAIL", 129, 148);
            USER_TURN_OFF_GROUP_MAIL = new SystemType("USER_TURN_OFF_GROUP_MAIL", 130, 149);
            USER_CHANGE_GROUP_MAIL_PERMISSION_OWNER = new SystemType("USER_CHANGE_GROUP_MAIL_PERMISSION_OWNER", 131, 150);
            USER_CHANGE_GROUP_MAIL_PERMISSION_MEMBERS = new SystemType("USER_CHANGE_GROUP_MAIL_PERMISSION_MEMBERS", 132, 151);
            USER_CHANGE_GROUP_MAIL_PERMISSION_TENANT = new SystemType("USER_CHANGE_GROUP_MAIL_PERMISSION_TENANT", 133, 152);
            USER_CHANGE_GROUP_MAIL_PERMISSION_EVERYONE = new SystemType("USER_CHANGE_GROUP_MAIL_PERMISSION_EVERYONE", 134, 153);
            USER_JOIN_VIA_GROUP_LINK = new SystemType("USER_JOIN_VIA_GROUP_LINK", 135, 154);
            CHAT_ROOM_END = new SystemType("CHAT_ROOM_END", 136, 155);
            CHAT_ROOM_START_V2 = new SystemType("CHAT_ROOM_START_V2", 137, 156);
            SYSTEM_EPHEMERAL_NOTIFY = new SystemType("SYSTEM_EPHEMERAL_NOTIFY", 138, 157);
            BUILD_ONEWAY_RELATION = new SystemType("BUILD_ONEWAY_RELATION", 139, 158);
            INVITE_FRIENDS_SUCCESS = new SystemType("INVITE_FRIENDS_SUCCESS", 140, 159);
            CREATE_P2P_SOURCE = new SystemType("CREATE_P2P_SOURCE", 141, 160);
            SEND_MESSAGE_COLLABORATION_AUTH_FAILED = new SystemType("SEND_MESSAGE_COLLABORATION_AUTH_FAILED", 142, 161);
            NOT_COLLABORATION_AUTH_SEND_MSG_LIMIT_NOTIFY = new SystemType("NOT_COLLABORATION_AUTH_SEND_MSG_LIMIT_NOTIFY", 143, 162);
            NOT_COLLABORATION_AUTH_SEND_MSG_REACH_LIMIT = new SystemType("NOT_COLLABORATION_AUTH_SEND_MSG_REACH_LIMIT", 144, 163);
            USER_INVITE_BOT_JOIN = new SystemType("USER_INVITE_BOT_JOIN", 145, 169);
            DOC_TEMPLATE_GROUP_SHARE = new SystemType("DOC_TEMPLATE_GROUP_SHARE", 146, 170);
            SHEET_TEMPLATE_GROUP_SHARE = new SystemType("SHEET_TEMPLATE_GROUP_SHARE", 147, 171);
            MIND_NOTE_TEMPLATE_GROUP_SHARE = new SystemType("MIND_NOTE_TEMPLATE_GROUP_SHARE", 148, 172);
            CantChatUserPrivacySettings = new SystemType("CantChatUserPrivacySettings", 149, 175);
            CREATE_CIRCLE_AND_INVITE_OTHERS_FROM_CHAT = new SystemType("CREATE_CIRCLE_AND_INVITE_OTHERS_FROM_CHAT", 150, 185);
            MENTIONED_PERSON_NOT_IN_CIRCLE = new SystemType("MENTIONED_PERSON_NOT_IN_CIRCLE", 151, 186);
            INVITE_MEMBERS_TO_JOIN_EXTERNAL_CIRCLE = new SystemType("INVITE_MEMBERS_TO_JOIN_EXTERNAL_CIRCLE", 152, 187);
            CIRCLE_CANT_ADD_MEMBERS_DUE_TO_ADMIN_SETTINGS = new SystemType("CIRCLE_CANT_ADD_MEMBERS_DUE_TO_ADMIN_SETTINGS", 153, 188);
            CIRCLE_CANT_ADD_MANY_MEMBERS_DUE_TO_ADMIN_SETTINGS = new SystemType("CIRCLE_CANT_ADD_MANY_MEMBERS_DUE_TO_ADMIN_SETTINGS", 154, 189);
            JOIN_CIRCLE_VIA_HELP_DESK_MSG_CARD = new SystemType("JOIN_CIRCLE_VIA_HELP_DESK_MSG_CARD", 155, 190);
            CIRCLE_WELCOME_NEW_MEMBERS = new SystemType("CIRCLE_WELCOME_NEW_MEMBERS", 156, 191);
            TRANSFER_CIRCLE_OWNER = new SystemType("TRANSFER_CIRCLE_OWNER", 157, 192);
            TRANSFER_CIRCLE_OWNER_AND_LEAVE = new SystemType("TRANSFER_CIRCLE_OWNER_AND_LEAVE", 158, 193);
            CIRCLE_USER_CHANGE_DOC_PERMISSION = new SystemType("CIRCLE_USER_CHANGE_DOC_PERMISSION", 159, 194);
            USER_INVITE_BOT_JOIN_CIRCLE = new SystemType("USER_INVITE_BOT_JOIN_CIRCLE", 160, 195);
            USER_INVITE_OTHERS_JOIN_CIRCLE = new SystemType("USER_INVITE_OTHERS_JOIN_CIRCLE", 161, 196);
            USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK = new SystemType("USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK", 162, 197);
            CIRCLE_TOO_MANY_MEMBERS_NOTIFICATION_MUTED = new SystemType("CIRCLE_TOO_MANY_MEMBERS_NOTIFICATION_MUTED", 163, 198);
            USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE = new SystemType("USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE", 164, 199);
            USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD = new SystemType("USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD", 165, com.lark.kmp.server.pb.improto.Packet.DEFAULT_STATUS);
            USER_MODIFY_CIRCLE_AVATAR = new SystemType("USER_MODIFY_CIRCLE_AVATAR", 166, 201);
            USER_MODIFY_CIRCLE_DESCRIPTION = new SystemType("USER_MODIFY_CIRCLE_DESCRIPTION", 167, 202);
            USER_MODIFY_CIRCLE_NAME = new SystemType("USER_MODIFY_CIRCLE_NAME", 168, 203);
            USER_MODIFY_CIRCLE_OWNER = new SystemType("USER_MODIFY_CIRCLE_OWNER", 169, 204);
            USER_MODIFY_CIRCLE_SETTINGS = new SystemType("USER_MODIFY_CIRCLE_SETTINGS", 170, 205);
            USER_SET_ONLY_CIRCLE_OWNER_CAN_POST = new SystemType("USER_SET_ONLY_CIRCLE_OWNER_CAN_POST", 171, 206);
            USER_SET_ONLY_CIRCLE_OWNER_CAN_CREATE_NEW_TOPICS = new SystemType("USER_SET_ONLY_CIRCLE_OWNER_CAN_CREATE_NEW_TOPICS", 172, 207);
            USER_LEAVE_CIRCLE = new SystemType("USER_LEAVE_CIRCLE", 173, 208);
            USER_REMOVE_CIRCLE_DESCRIPTION = new SystemType("USER_REMOVE_CIRCLE_DESCRIPTION", 174, 209);
            USER_REMOVE_CIRCLE_MEMBERS = new SystemType("USER_REMOVE_CIRCLE_MEMBERS", 175, 210);
            USER_CREATE_CIRCLE = new SystemType("USER_CREATE_CIRCLE", 176, 211);
            USER_CREATE_CIRCLE_AND_INVITE = new SystemType("USER_CREATE_CIRCLE_AND_INVITE", 177, 212);
            USER_SYNC_MESSAGE_TO_CIRCLE = new SystemType("USER_SYNC_MESSAGE_TO_CIRCLE", 178, 213);
            USER_CLEAR_CIRCLE_ANNOUNCEMENT = new SystemType("USER_CLEAR_CIRCLE_ANNOUNCEMENT", 179, 214);
            USER_WITHDRAW_CIRCLE_INVITATION = new SystemType("USER_WITHDRAW_CIRCLE_INVITATION", 180, 215);
            CIRCLE_ANONYMOUS_ON = new SystemType("CIRCLE_ANONYMOUS_ON", 181, 216);
            CIRCLE_ANONYMOUS_OFF = new SystemType("CIRCLE_ANONYMOUS_OFF", 182, 217);
            Lark_IM_CreateGroup_UserAndGroup_OwnerInvite = new SystemType("Lark_IM_CreateGroup_UserAndGroup_OwnerInvite", 183, 225);
            Lark_IM_CreateGroup_UserAndGroup_MemberInvite = new SystemType("Lark_IM_CreateGroup_UserAndGroup_MemberInvite", 184, 226);
            Lark_IM_CreateGroup_UserAndDepartment_OwnerInvite = new SystemType("Lark_IM_CreateGroup_UserAndDepartment_OwnerInvite", 185, 227);
            Lark_IM_CreateGroup_UserAndDepartment_MemberInivite = new SystemType("Lark_IM_CreateGroup_UserAndDepartment_MemberInivite", 186, 228);
            Lark_IM_CreateGroup_GroupAndDepartment_OwnerInvite = new SystemType("Lark_IM_CreateGroup_GroupAndDepartment_OwnerInvite", 187, 229);
            Lark_IM_CreateGroup_GroupAndDepartment_MemberInvite = new SystemType("Lark_IM_CreateGroup_GroupAndDepartment_MemberInvite", 188, 230);
            Lark_IM_CreateGroup_UserAndGroupAndDepartment_OwnerInvite = new SystemType("Lark_IM_CreateGroup_UserAndGroupAndDepartment_OwnerInvite", 189, 231);
            Lark_IM_CreateGroup_UserAndGroupAndDepartment_MemberInvite = new SystemType("Lark_IM_CreateGroup_UserAndGroupAndDepartment_MemberInvite", 190, 232);
            Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_Inviter = new SystemType("Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_Inviter", 191, 233);
            Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_Inviter = new SystemType("Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_Inviter", 192, 234);
            Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_Invitee = new SystemType("Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_Invitee", 193, 235);
            Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_Invitee = new SystemType("Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_Invitee", 194, 236);
            Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_OtherMembers = new SystemType("Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_OtherMembers", 195, 237);
            Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_OtherMembers = new SystemType("Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_OtherMembers", 196, 238);
            Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_Inviter = new SystemType("Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_Inviter", 197, 239);
            Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_Inviter = new SystemType("Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_Inviter", 198, 240);
            Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_Invitee = new SystemType("Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_Invitee", 199, 241);
            Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_Invitee = new SystemType("Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_Invitee", com.lark.kmp.server.pb.improto.Packet.DEFAULT_STATUS, 242);
            Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_OtherMembers = new SystemType("Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_OtherMembers", 201, 243);
            Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_OtherMembers = new SystemType("Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_OtherMembers", 202, 244);
            Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_Inviter = new SystemType("Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_Inviter", 203, 245);
            Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_Inviter = new SystemType("Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_Inviter", 204, 246);
            Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_Invitee = new SystemType("Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_Invitee", 205, 247);
            Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_Invitee = new SystemType("Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_Invitee", 206, 248);
            Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_OtherMembers = new SystemType("Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_OtherMembers", 207, 249);
            Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_OtherMembers = new SystemType("Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_OtherMembers", 208, 250);
            Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_Inviter = new SystemType("Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_Inviter", 209, 251);
            Lark_IM_EnterGroup_Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_Inviter = new SystemType("Lark_IM_EnterGroup_Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_Inviter", 210, 252);
            Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_Invitee = new SystemType("Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_Invitee", 211, 253);
            Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_Invitee = new SystemType("Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_Invitee", 212, 254);
            Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_OtherMembers = new SystemType("Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_OtherMembers", 213, 255);
            Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_OtherMembers = new SystemType("Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_OtherMembers", 214, 256);
            Lark_IM_EnterGroup_User_ChatHistoryYes_FromTeam = new SystemType("Lark_IM_EnterGroup_User_ChatHistoryYes_FromTeam", 215, 257);
            Lark_IM_Server_WelcomeTo_Text = new SystemType("Lark_IM_Server_WelcomeTo_Text", 216, 268);
            INVITE_CHAT_MEMBER_2_CHAT = new SystemType("INVITE_CHAT_MEMBER_2_CHAT", 217, 300);
            WILL_REACH_CHAT_CHATTER_COUNT_LIMIT = new SystemType("WILL_REACH_CHAT_CHATTER_COUNT_LIMIT", 218, 301);
            ALREADY_REACH_CHAT_CHATTER_COUNT_LIMIT = new SystemType("ALREADY_REACH_CHAT_CHATTER_COUNT_LIMIT", 219, 302);
            USER_CREATE_FACE_TO_FACE_CHAT = new SystemType("USER_CREATE_FACE_TO_FACE_CHAT", 220, 303);
            USER_JOIN_FACE_TO_FACE_CHAT = new SystemType("USER_JOIN_FACE_TO_FACE_CHAT", 221, 304);
            WELCOME_USER_JOIN_FACE_TO_FACE_CHAT = new SystemType("WELCOME_USER_JOIN_FACE_TO_FACE_CHAT", 222, 305);
            USER_CREATED_GROUP_AND_INVITED_OTHER_CHATTER_CHAT_DEPARTMENT = new SystemType("USER_CREATED_GROUP_AND_INVITED_OTHER_CHATTER_CHAT_DEPARTMENT", 223, 306);
            USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN = new SystemType("USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN", 224, 307);
            CREATE_CHAT_AND_INVITE_FROM_CHAT_DEPARTMENT_MEMBER = new SystemType("CREATE_CHAT_AND_INVITE_FROM_CHAT_DEPARTMENT_MEMBER", 225, 308);
            USER_OPEN_ONLY_SEPECIFY_MEMBERS_POST = new SystemType("USER_OPEN_ONLY_SEPECIFY_MEMBERS_POST", 226, 309);
            USER_OPEN_ONLY_SEPECIFY_MEMBERS_POST_THREAD = new SystemType("USER_OPEN_ONLY_SEPECIFY_MEMBERS_POST_THREAD", 227, 310);
            USER_REMOVE_SEPECIFY_MEMBERS_POST = new SystemType("USER_REMOVE_SEPECIFY_MEMBERS_POST", 228, 311);
            USER_REMOVE_SEPECIFY_MEMBERS_POST_THREAD = new SystemType("USER_REMOVE_SEPECIFY_MEMBERS_POST_THREAD", 229, 312);
            ADD_MEMBER_TO_ADMIN_LIST = new SystemType("ADD_MEMBER_TO_ADMIN_LIST", 230, 313);
            REMOVE_MEMBER_FROM_ADMIN_LIST = new SystemType("REMOVE_MEMBER_FROM_ADMIN_LIST", 231, 314);
            USER_OPEN_ONLY_OWNER_AND_ADMIN_POST = new SystemType("USER_OPEN_ONLY_OWNER_AND_ADMIN_POST", 232, 317);
            USER_OPEN_ONLY_OWNER_AND_ADMIN_POST_THREAD = new SystemType("USER_OPEN_ONLY_OWNER_AND_ADMIN_POST_THREAD", 233, 318);
            ADMIN_OPEN_ANYONE_POST = new SystemType("ADMIN_OPEN_ANYONE_POST", 234, 319);
            ADMIN_OPEN_ANYONE_POST_THREAD = new SystemType("ADMIN_OPEN_ANYONE_POST_THREAD", 235, 320);
            USER_CHANGE_GROUP_MAIL_PERMISSION_OWNER_OR_ADMIN = new SystemType("USER_CHANGE_GROUP_MAIL_PERMISSION_OWNER_OR_ADMIN", 236, 322);
            GROUP_NEW_MEMBERS_VIEW_CHAT_HISTORY_ON = new SystemType("GROUP_NEW_MEMBERS_VIEW_CHAT_HISTORY_ON", 237, 323);
            GROUP_NEW_MEMBERS_VIEW_CHAT_HISTORY_OFF = new SystemType("GROUP_NEW_MEMBERS_VIEW_CHAT_HISTORY_OFF", 238, 324);
            GROUP_NEW_MEMBERS_CAN_VIEW_HISTORY_MESSAGES = new SystemType("GROUP_NEW_MEMBERS_CAN_VIEW_HISTORY_MESSAGES", 239, 325);
            CIRCLE_WELCOME_NEW_MEMBERS_NO_HISTORY = new SystemType("CIRCLE_WELCOME_NEW_MEMBERS_NO_HISTORY", 240, 326);
            JOIN_CIRCLE_VIA_HELP_DESK_MSG_CARD_NO_HISTORY = new SystemType("JOIN_CIRCLE_VIA_HELP_DESK_MSG_CARD_NO_HISTORY", 241, 327);
            USER_INVITE_OTHERS_JOIN_CIRCLE_NO_HISTORY = new SystemType("USER_INVITE_OTHERS_JOIN_CIRCLE_NO_HISTORY", 242, 328);
            USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD_NO_HISTORY = new SystemType("USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD_NO_HISTORY", 243, 329);
            USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK_NO_HISTORY = new SystemType("USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK_NO_HISTORY", 244, 330);
            USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE_NO_HISTORY = new SystemType("USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE_NO_HISTORY", 245, 331);
            USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN_NEW = new SystemType("USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN_NEW", 246, 338);
            USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN_NO_HISTORY = new SystemType("USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN_NO_HISTORY", 247, 332);
            USER_JOIN_VIA_QR_NEW = new SystemType("USER_JOIN_VIA_QR_NEW", 248, 339);
            USER_JOIN_VIA_QR_CODE_NO_HISTORY = new SystemType("USER_JOIN_VIA_QR_CODE_NO_HISTORY", 249, 333);
            USER_JOIN_CHAT_WELCOME_MESSAGE = new SystemType("USER_JOIN_CHAT_WELCOME_MESSAGE", 250, 334);
            USER_JOIN_CHAT_WELCOME_MESSAGE_NO_HISTORY = new SystemType("USER_JOIN_CHAT_WELCOME_MESSAGE_NO_HISTORY", 251, 335);
            USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE = new SystemType("USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE", 252, 336);
            USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE_NO_HISTORY = new SystemType("USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE_NO_HISTORY", 253, 337);
            USER_JOIN_VIA_SHARE_NEW = new SystemType("USER_JOIN_VIA_SHARE_NEW", 254, 340);
            USER_JOIN_VIA_SHARE_NO_HISTORY = new SystemType("USER_JOIN_VIA_SHARE_NO_HISTORY", 255, 341);
            USER_JOIN_CHAT_BY_LINK = new SystemType("USER_JOIN_CHAT_BY_LINK", 256, 342);
            USER_JOIN_CHAT_BY_LINK_NO_HISTORY = new SystemType("USER_JOIN_CHAT_BY_LINK_NO_HISTORY", 257, 343);
            HELP_DESK_USER_JOIN_CHAT = new SystemType("HELP_DESK_USER_JOIN_CHAT", 258, 344);
            HELP_DESK_USER_JOIN_CHAT_NO_HISTORY = new SystemType("HELP_DESK_USER_JOIN_CHAT_NO_HISTORY", 259, 345);
            UPGRADE_SUPER_CHAT = new SystemType("UPGRADE_SUPER_CHAT", 260, 348);
            CREATE_URGENT_ONLY_OWNER_AND_ADMIN_ON = new SystemType("CREATE_URGENT_ONLY_OWNER_AND_ADMIN_ON", 261, 346);
            CREATE_URGENT_ONLY_OWNER_AND_ADMIN_OFF = new SystemType("CREATE_URGENT_ONLY_OWNER_AND_ADMIN_OFF", 262, 347);
            AUTO_OPEN_TYPING_TRANSLATE = new SystemType("AUTO_OPEN_TYPING_TRANSLATE", 263, 363);
            ONLY_ADMIN_CAN_MANAGE_CHAT_TAB = new SystemType("ONLY_ADMIN_CAN_MANAGE_CHAT_TAB", 264, 364);
            ALL_MEMBERS_CAN_MANAGE_CHAT_TAB = new SystemType("ALL_MEMBERS_CAN_MANAGE_CHAT_TAB", 265, 365);
            ALL_MEMBERS_CAN_MANAGE_TabsMenuWidgets = new SystemType("ALL_MEMBERS_CAN_MANAGE_TabsMenuWidgets", 266, 379);
            ONLY_ADMIN_CAN_MANAGE_TabsMenuWidgets = new SystemType("ONLY_ADMIN_CAN_MANAGE_TabsMenuWidgets", 267, 380);
            ALL_MEMBERS_CAN_MANAGE_TabsMenuWidgetsV1 = new SystemType("ALL_MEMBERS_CAN_MANAGE_TabsMenuWidgetsV1", 268, 385);
            ONLY_ADMIN_CAN_MANAGE_TabsMenuWidgetsV1 = new SystemType("ONLY_ADMIN_CAN_MANAGE_TabsMenuWidgetsV1", 269, 386);
            ALL_MEMBERS_CHAT_URL_TOP_NOTICE_HIGH_V_NORMAL = new SystemType("ALL_MEMBERS_CHAT_URL_TOP_NOTICE_HIGH_V_NORMAL", 270, 392);
            CAN_MANAGER_CHAT_URL_TOP_NOTICE_HIGH_V_NORMAL = new SystemType("CAN_MANAGER_CHAT_URL_TOP_NOTICE_HIGH_V_NORMAL", 271, 393);
            ALL_MEMBERS_CHAT_URL_TOP_NOTICE_HIGH_V_THREAD = new SystemType("ALL_MEMBERS_CHAT_URL_TOP_NOTICE_HIGH_V_THREAD", 272, 394);
            CAN_MANAGER_CHAT_URL_TOP_NOTICE_HIGH_V_THREAD = new SystemType("CAN_MANAGER_CHAT_URL_TOP_NOTICE_HIGH_V_THREAD", 273, 395);
            ALL_MEMBERS_CHAT_URL_TOP_NOTICE_LOW_V_NORMAL = new SystemType("ALL_MEMBERS_CHAT_URL_TOP_NOTICE_LOW_V_NORMAL", 274, 396);
            CAN_MANAGER_CHAT_URL_TOP_NOTICE_LOW_V_NORMAL = new SystemType("CAN_MANAGER_CHAT_URL_TOP_NOTICE_LOW_V_NORMAL", 275, 397);
            ALL_MEMBERS_CHAT_URL_TOP_NOTICE_LOW_V_THREAD = new SystemType("ALL_MEMBERS_CHAT_URL_TOP_NOTICE_LOW_V_THREAD", 276, 398);
            CAN_MANAGER_CHAT_URL_TOP_NOTICE_LOW_V_THREAD = new SystemType("CAN_MANAGER_CHAT_URL_TOP_NOTICE_LOW_V_THREAD", 277, 399);
            EXTERNAL_COORDINATE_CTL = new SystemType("EXTERNAL_COORDINATE_CTL", 278, 401);
            TARGET_EXTERNAL_COORDINATE_CTL = new SystemType("TARGET_EXTERNAL_COORDINATE_CTL", 279, 402);
            CHAT_OPEN_CAN_SEARCH_SYSTEM_MESSAGE = new SystemType("CHAT_OPEN_CAN_SEARCH_SYSTEM_MESSAGE", 280, 403);
            CHAT_CLOSED_CAN_SEARCH_SYSTEM_MESSAGE = new SystemType("CHAT_CLOSED_CAN_SEARCH_SYSTEM_MESSAGE", 281, 404);
            BITABLE_TEMPLATE_GROUP_SHARE_SYSTEM_MESSAGE = new SystemType("BITABLE_TEMPLATE_GROUP_SHARE_SYSTEM_MESSAGE", 282, 405);
            MANUAL_OPEN_TYPING_TRANSLATE = new SystemType("MANUAL_OPEN_TYPING_TRANSLATE", 283, 428);
            AUTO_OPEN_TYPING_TRANSLATE_V1 = new SystemType("AUTO_OPEN_TYPING_TRANSLATE_V1", 284, 429);
            CREATE_TEAM_AND_INVITE_MEMBERS = new SystemType("CREATE_TEAM_AND_INVITE_MEMBERS", 285, 501);
            UPDATE_CHAT_TO_TEAM = new SystemType("UPDATE_CHAT_TO_TEAM", 286, 502);
            INVITE_MEMBERS_JOIN_TEAM = new SystemType("INVITE_MEMBERS_JOIN_TEAM", 287, 503);
            MEMBERS_JOIN_TEAM_FAIL = new SystemType("MEMBERS_JOIN_TEAM_FAIL", 288, 504);
            KICK_MEMBERS_OUT_TEAM = new SystemType("KICK_MEMBERS_OUT_TEAM", 289, 505);
            MEMBER_LEAVE_TEAM = new SystemType("MEMBER_LEAVE_TEAM", 290, 506);
            TRANSFER_TEAM_OWNER = new SystemType("TRANSFER_TEAM_OWNER", 291, 507);
            MODIFY_TEAM_NAME = new SystemType("MODIFY_TEAM_NAME", 292, 508);
            ENABLE_TEAM_CREATE_CHAT_PERMISSION = new SystemType("ENABLE_TEAM_CREATE_CHAT_PERMISSION", 293, 509);
            CLOSE_TEAM_CREATE_CHAT_PERMISSION = new SystemType("CLOSE_TEAM_CREATE_CHAT_PERMISSION", 294, 510);
            ENABLE_TEAM_ADD_MEMBERS_PERMISSION = new SystemType("ENABLE_TEAM_ADD_MEMBERS_PERMISSION", 295, 511);
            CLOSE_TEAM_ADD_MEMBERS_PERMISSION = new SystemType("CLOSE_TEAM_ADD_MEMBERS_PERMISSION", 296, 512);
            DISSOLVE_TEAM_AND_UNBIND_CHAT = new SystemType("DISSOLVE_TEAM_AND_UNBIND_CHAT", 297, 513);
            CREATE_TEAM_CHAT = new SystemType("CREATE_TEAM_CHAT", 298, 514);
            BIND_CHAT_INTO_TEAM = new SystemType("BIND_CHAT_INTO_TEAM", 299, 515);
            UNBIND_CHAT_WITH_TEAM = new SystemType("UNBIND_CHAT_WITH_TEAM", 300, 516);
            MEMBERS_JOIN_TEAM_CHAT_SEE_HISTORICAL = new SystemType("MEMBERS_JOIN_TEAM_CHAT_SEE_HISTORICAL", 301, 517);
            MEMBERS_JOIN_TEAM_CHAT_SEE_NEW_MESSAGES = new SystemType("MEMBERS_JOIN_TEAM_CHAT_SEE_NEW_MESSAGES", 302, 518);
            MEMBERS_JOIN_TEAM_CHAT_FAIL = new SystemType("MEMBERS_JOIN_TEAM_CHAT_FAIL", 303, 519);
            MEMBERS_LEAVE_AND_TRANSFER = new SystemType("MEMBERS_LEAVE_AND_TRANSFER", 304, 520);
            USER_CREATE_TEAM = new SystemType("USER_CREATE_TEAM", 305, 521);
            CHECK_USER_PHONE_NUMBER = new SystemType("CHECK_USER_PHONE_NUMBER", 306, 522);
            CHECK_USER_PHONE_USER_IN_WHITELIST = new SystemType("CHECK_USER_PHONE_USER_IN_WHITELIST", 307, 523);
            CantBuzzEmptyPhoneNumber = new SystemType("CantBuzzEmptyPhoneNumber", 308, 524);
            CantBuzzEmptyName = new SystemType("CantBuzzEmptyName", 309, 525);
            BuzzLimit = new SystemType("BuzzLimit", 310, 526);
            BuzzSystemError = new SystemType("BuzzSystemError", 311, 527);
            BuzzTimeOut = new SystemType("BuzzTimeOut", 312, 528);
            CantBuzzMembers = new SystemType("CantBuzzMembers", 313, 529);
            BuzzNotAnswer = new SystemType("BuzzNotAnswer", 314, 530);
            MultiItemSystemContent = new SystemType("MultiItemSystemContent", 315, 531);
            VC_ENTERPRISE_PHONE_CREATE = new SystemType("VC_ENTERPRISE_PHONE_CREATE", 316, 532);
            MODIFY_TEAM_AVATAR = new SystemType("MODIFY_TEAM_AVATAR", 317, 533);
            MODIFY_TEAM_DESCRIPTION = new SystemType("MODIFY_TEAM_DESCRIPTION", 318, 534);
            DELETE_TEAM_DESCRIPTION = new SystemType("DELETE_TEAM_DESCRIPTION", 319, 535);
            CREATE_TEAM_CHAT_V2_MANAGER = new SystemType("CREATE_TEAM_CHAT_V2_MANAGER", 320, 541);
            BIND_CHAT_INTO_TEAM_MANAGER = new SystemType("BIND_CHAT_INTO_TEAM_MANAGER", 321, 542);
            USER_JOIN_CHAT_FROM_TEAM = new SystemType("USER_JOIN_CHAT_FROM_TEAM", 322, 543);
            TEAM_CHAT_TURN_OPEN_MESSAGE_TO_TEAM = new SystemType("TEAM_CHAT_TURN_OPEN_MESSAGE_TO_TEAM", 323, 544);
            TEAM_CHAT_TURN_OPEN_MESSAGE = new SystemType("TEAM_CHAT_TURN_OPEN_MESSAGE", 324, 545);
            SIMPLIFY_OTHER_GRAB_MY_HONGBAO = new SystemType("SIMPLIFY_OTHER_GRAB_MY_HONGBAO", 325, 615);
            SIMPLIFY_OTHER_GRAB_MY_HONGBAO_NOT_OVER_OUT_NUM = new SystemType("SIMPLIFY_OTHER_GRAB_MY_HONGBAO_NOT_OVER_OUT_NUM", 326, 633);
            SIMPLIFY_USER_INVITE_OTHERS_JOIN = new SystemType("SIMPLIFY_USER_INVITE_OTHERS_JOIN", 327, 616);
            SIMPLIFY_USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE_NO_HISTORY = new SystemType("SIMPLIFY_USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE_NO_HISTORY", 328, 617);
            SIMPLIFY_SYSTEM_WELCOME_USER = new SystemType("SIMPLIFY_SYSTEM_WELCOME_USER", 329, 618);
            SIMPLIFY_USER_JOIN_CHAT_WELCOME_MESSAGE = new SystemType("SIMPLIFY_USER_JOIN_CHAT_WELCOME_MESSAGE", 330, 619);
            SIMPLIFY_USER_JOIN_CHAT_WELCOME_MESSAGE_NO_HISTORY = new SystemType("SIMPLIFY_USER_JOIN_CHAT_WELCOME_MESSAGE_NO_HISTORY", 331, 620);
            SIMPLIFY_CIRCLE_WELCOME_NEW_MEMBERS = new SystemType("SIMPLIFY_CIRCLE_WELCOME_NEW_MEMBERS", 332, 621);
            SIMPLIFY_USER_JOIN_VIA_SHARE = new SystemType("SIMPLIFY_USER_JOIN_VIA_SHARE", 333, 622);
            SIMPLIFY_USER_JOIN_VIA_SHARE_NO_HISTORY = new SystemType("SIMPLIFY_USER_JOIN_VIA_SHARE_NO_HISTORY", 334, 623);
            SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD = new SystemType("SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD", 335, 624);
            SIMPLIFY_USER_JOIN_VIA_QR_CODE = new SystemType("SIMPLIFY_USER_JOIN_VIA_QR_CODE", 336, 625);
            SIMPLIFY_USER_JOIN_VIA_QR_CODE_NO_HISTORY = new SystemType("SIMPLIFY_USER_JOIN_VIA_QR_CODE_NO_HISTORY", 337, 626);
            SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE = new SystemType("SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE", 338, 627);
            SIMPLIFY_USER_JOIN_VIA_GROUP_LINK = new SystemType("SIMPLIFY_USER_JOIN_VIA_GROUP_LINK", 339, 628);
            SIMPLIFY_USER_JOIN_CHAT_BY_LINK_NO_HISTORY = new SystemType("SIMPLIFY_USER_JOIN_CHAT_BY_LINK_NO_HISTORY", 340, 629);
            SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK = new SystemType("SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK", 341, 630);
            SIMPLIFY_WELCOME_USER_JOIN_FACE_TO_FACE_CHAT = new SystemType("SIMPLIFY_WELCOME_USER_JOIN_FACE_TO_FACE_CHAT", 342, 631);
            SIMPLIFY_USER_JOIN_CHAT_FROM_TEAM = new SystemType("SIMPLIFY_USER_JOIN_CHAT_FROM_TEAM", 343, 632);
            SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE = new SystemType("SIMPLIFY_USER_INVITE_OTHERS_JOIN_CIRCLE", 344, 634);
            HIGHLIGHT_MESSAGES_FROM_CONTACT_TO_STAY_INFORMED = new SystemType("HIGHLIGHT_MESSAGES_FROM_CONTACT_TO_STAY_INFORMED", 345, 702);
            MyAI_NewTopicTip = new SystemType("MyAI_NewTopicTip", 346, 1100);
            MyAI_SceneTopicDynamicTip = new SystemType("MyAI_SceneTopicDynamicTip", 347, 1110);
            Lark_IM_BotCustomization = new SystemType("Lark_IM_BotCustomization", 348, 1203);
            MANUAL_OPEN_TYPING_TRANSLATE_PROMPTS = new SystemType("MANUAL_OPEN_TYPING_TRANSLATE_PROMPTS", 349, 1301);
            CHAT_USER_LARGE_CHAT_AUTO_MUTE = new SystemType("CHAT_USER_LARGE_CHAT_AUTO_MUTE", 350, 1500);
            CHAT_USER_BOT_AUTO_MUTE = new SystemType("CHAT_USER_BOT_AUTO_MUTE", 351, 1501);
            CHAT_USER_BOT_AUTO_MUTE_S = new SystemType("CHAT_USER_BOT_AUTO_MUTE_S", 352, 1502);
            CHAT_USER_P2P_BOT_AUTO_MUTE = new SystemType("CHAT_USER_P2P_BOT_AUTO_MUTE", 353, 1503);
            DOUBAO_SHOW_NEW_CONTACT = new SystemType("DOUBAO_SHOW_NEW_CONTACT", 354, 1504);
            DOUBAO_SHOW_READ_TIP = new SystemType("DOUBAO_SHOW_READ_TIP", 355, 1505);
            DOUBAO_SHOW_JOIN_CHAT = new SystemType("DOUBAO_SHOW_JOIN_CHAT", 356, 1506);
            DOUBAO_SHOW_JOIN_CHAT_STRANGER = new SystemType("DOUBAO_SHOW_JOIN_CHAT_STRANGER", 357, 1507);
            DOUBAO_SHOW_NEW_CONTACT_NO_GREETING = new SystemType("DOUBAO_SHOW_NEW_CONTACT_NO_GREETING", 358, 1510);
            DOUBAO_SHOW_NEW_CONTACT_NO_GREETING_READ_STATUS = new SystemType("DOUBAO_SHOW_NEW_CONTACT_NO_GREETING_READ_STATUS", 359, 1511);
            LOCAL_MENTION_BOTS_NOT_IN_CHAT = new SystemType("LOCAL_MENTION_BOTS_NOT_IN_CHAT", 360, 10000);
            SystemType[] r1 = a();
            a = r1;
            b = EnumEntriesKt.enumEntries(r1);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(SystemType.class), Syntax.PROTO_2, r0);
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static SystemType valueOf(String r1) {
            return (SystemType) r27.a.a(SystemType.class, r1);
        }

        public SystemType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Content$TransmitInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Content$TransmitInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Content$TransmitInfo$Builder;Lokio/ByteString;)V", "origin_merge_forward_id", "", "getOrigin_merge_forward_id", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class TransmitInfo extends com.lark.wire.Message<TransmitInfo, a> {
        public static final ProtoAdapter<TransmitInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String origin_merge_forward_id;

        public static final class a extends com.lark.wire.Message.a<TransmitInfo, a> {
            public String d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new TransmitInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<TransmitInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final TransmitInfo c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L10;
                if (r4 == 1) goto L7;
                r7.j(r4);
                goto L3
            L7:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.i();
                goto L3
            L10:
                return new TransmitInfo(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TransmitInfo r4) {
                TransmitInfo r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ProtoAdapter.q.l(1, r5.getOrigin_merge_forward_id());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, TransmitInfo r5) {
                TransmitInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.i(r4, 1, r6.getOrigin_merge_forward_id());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, TransmitInfo r4) {
                TransmitInfo r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ProtoAdapter.q.j(r3, 1, r5.getOrigin_merge_forward_id());
            }

            public b(FieldEncoding r7, KClass<TransmitInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Content.TransmitInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ TransmitInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TransmitInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.origin_merge_forward_id;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(TransmitInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final String getOrigin_merge_forward_id() {
            return this.origin_merge_forward_id;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public TransmitInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.origin_merge_forward_id = r2.d;
        }

        public /* synthetic */ TransmitInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<Content, a> {
        public String A;
        public CardContent A0;
        public Boolean B;
        public LocationContent B0;
        public Long C;
        public String C0;
        public String D;
        public String D0;
        public String E;
        public String E0;
        public String F;
        public String F0;
        public Boolean G;
        public String G0;
        public String H;
        public String H0;
        public Boolean I;
        public String I0;
        public Integer J;
        public String J0;
        public Boolean K;
        public String K0;
        public Map<String, UrlPreviewHangPoint> L;
        public String L0;
        public Boolean M;
        public String M0;
        public DocEntity N;
        public Boolean N0;
        public String O;
        public MediaContent O0;
        public File.Source P;
        public HongbaoContent P0;
        public String Q;
        public HongbaoSystemContent Q0;
        public Boolean R;
        public SystemExtraContent R0;
        public String S;
        public VideoChatContent S0;
        public TransStatus T;
        public List<String> T0;
        public TransIdentity U;
        public String U0;
        public String V;
        public StickerInfo V0;
        public String W;
        public String W0;
        public String X;
        public String X0;
        public Boolean Y;
        public ShareUserCardInfo Y0;
        public Boolean Z;
        public String Z0;
        public String a0;
        public Abbreviation a1;
        public Boolean b0;
        public Map<String, ElementRefs> b1;
        public List<String> c0;
        public TodoOperationContent c1;
        public String d;
        public FileAbility d0;
        public LingoOption d1;
        public String e;
        public FilePermission e0;
        public VoteContent e1;
        public ImageSet f;
        public Long f0;
        public String f1;
        public Boolean g;
        public Long g0;
        public List<Reference> g1;
        public Long h;
        public LocalStatus h0;
        public Boolean h1;
        public String i;
        public FilePreviewStage i0;
        public Map<String, ResourceCleanScene> i1;
        public String j;
        public List<File> j0;
        public DoubaoContent j1;
        public String k;
        public List<File> k0;
        public Boolean k1;
        public Long l;
        public String l0;
        public DoubaoResource l1;
        public String m;
        public String m0;
        public String n;
        public Long n0;
        public String o;
        public Integer o0;
        public Map<String, String> p;
        public Integer p0;
        public Integer q;
        public Integer q0;
        public FileType r;
        public String r0;
        public SystemType s;
        public MergeForwardContent s0;
        public EmailSystemEvent t;
        public TransmitInfo t0;
        public Map<String, ContentValue> u;
        public List<PreviewUrlContent> u0;
        public Integer v;
        public RichText v0;
        public String w;
        public CalendarContent w0;
        public Map<String, SystemContentValue> x;
        public ShareCalendarEventContent x0;
        public Map<Integer, SystemMessageItemAction> y;
        public GeneralCalendarContent y0;
        public Integer z;
        public List<TextUrlContent> z0;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new Content(this, c(), null);
        }

        public a() {
            this.p = MapsKt.emptyMap();
            this.u = MapsKt.emptyMap();
            this.x = MapsKt.emptyMap();
            this.y = MapsKt.emptyMap();
            this.L = MapsKt.emptyMap();
            this.c0 = CollectionsKt.emptyList();
            this.j0 = CollectionsKt.emptyList();
            this.k0 = CollectionsKt.emptyList();
            this.u0 = CollectionsKt.emptyList();
            this.z0 = CollectionsKt.emptyList();
            this.T0 = CollectionsKt.emptyList();
            this.b1 = MapsKt.emptyMap();
            this.g1 = CollectionsKt.emptyList();
            this.i1 = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ Content(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Deprecated(message = "include_cleaned_resources is deprecated")
    public static /* synthetic */ void getInclude_cleaned_resources$annotations() {
    }

    static {
        Companion = new b();
        DEFAULT_FILE_SOURCE = File.Source.LARK_SERVER;
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(Content.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new Content$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.title;
        r0.e = this.text;
        r0.f = this.image;
        r0.g = this.is_origin_source;
        r0.h = this.origin_size;
        r0.i = this.image_upload_id;
        r0.j = this.key;
        r0.k = this.name;
        r0.l = this.size;
        r0.m = this.mime;
        r0.n = this.file_upload_id;
        r0.o = this.template;
        r0.p = this.values;
        r0.q = this.duration;
        r0.r = this.deprecated;
        r0.s = this.system_type;
        r0.t = this.event;
        r0.u = this.content_values;
        r0.v = this.system_type_value;
        r0.w = this.i18n_title_key;
        r0.x = this.system_content_values;
        r0.y = this.item_actions;
        r0.z = this.system_message_version;
        r0.A = this.voice2text;
        r0.B = this.hide_voice2text;
        r0.C = this.origin_sender_id;
        r0.D = this.local_upload_id;
        r0.E = this.origin_tos_key;
        r0.F = this.origin_sender_name;
        r0.G = this.is_friend;
        r0.H = this.origin_sender_id_str;
        r0.I = this.is_audio_recognize_finish;
        r0.J = this.audio2text_start_time;
        r0.K = this.is_audio_with_text;
        r0.L = this.url_preview_hang_point_map;
        r0.M = this.is_group_announcement;
        r0.N = this.doc_entity;
        r0.O = this.file_path;
        r0.P = this.file_source;
        r0.Q = this.namespace;
        r0.R = this.is_in_my_nut_store;
        r0.S = this.cache_file_path;
        r0.T = this.lan_trans_status;
        r0.U = this.trans_identity;
        r0.V = this.lan_trans_status_text;
        r0.W = this.lan_sender_device_id;
        r0.X = this.lan_receiver_device_id;
        r0.Y = this.is_try_use_lan_trans;
        r0.Z = this.is_able_lan_trans;
        r0.a0 = this.file_uri;
        r0.b0 = this.is_encrypted;
        r0.c0 = this.risk_object_keys;
        r0.d0 = this.file_ability;
        r0.e0 = this.file_permission;
        r0.f0 = this.file_last_update_user_id;
        r0.g0 = this.file_last_update_time_ms;
        r0.h0 = this.local_status;
        r0.i0 = this.file_preview_stage;
        r0.j0 = this.attachments;
        r0.k0 = this.file_attachments;
        r0.l0 = this.share_chat_id;
        r0.m0 = this.join_token;
        r0.n0 = this.expire_time;
        r0.o0 = this.share_chat_last_state;
        r0.p0 = this.width;
        r0.q0 = this.height;
        r0.r0 = this.crypto_token;
        r0.s0 = this.merge_forward_content;
        r0.t0 = this.transmit_info;
        r0.u0 = this.preview_urls;
        r0.v0 = this.rich_text;
        r0.w0 = this.calendar_content;
        r0.x0 = this.share_calendar_event_content;
        r0.y0 = this.general_calendar_content;
        r0.z0 = this.text_url_contents;
        r0.A0 = this.card_content;
        r0.B0 = this.location_content;
        r0.C0 = this.e2ee_from_id;
        r0.D0 = this.e2ee_to_id;
        r0.E0 = this.trigger_id;
        r0.F0 = this.vc_from_id;
        r0.G0 = this.vc_to_id;
        r0.H0 = this.vc_duration_time;
        r0.I0 = this.vc_meeting_id;
        r0.J0 = this.vc_passcode;
        r0.K0 = this.vc_feedback_status;
        r0.L0 = this.vc_from_feedback_status;
        r0.M0 = this.vc_to_feedback_status;
        r0.N0 = this.is_voice_call;
        r0.O0 = this.media_content;
        r0.P0 = this.hongbao_content;
        r0.Q0 = this.hongbao_system_content;
        r0.R0 = this.system_extra_content;
        r0.S0 = this.videochat_content;
        r0.T0 = this.resource_urls;
        r0.U0 = this.fs_unit;
        r0.V0 = this.sticker_info;
        r0.W0 = this.sticker_id;
        r0.X0 = this.sticker_set_id;
        r0.Y0 = this.share_user_card_info;
        r0.Z0 = this.share_chatter_id;
        r0.a1 = this.abbreviation;
        r0.b1 = this.typed_element_refs;
        r0.c1 = this.todo_operation_content;
        r0.d1 = this.lingo_option;
        r0.e1 = this.vote_content;
        r0.f1 = this.folder_archive_key;
        r0.g1 = this.content_references;
        r0.h1 = this.include_cleaned_resources;
        r0.i1 = this.clean_resource_key_scene;
        r0.j1 = this.doubao_content;
        r0.k1 = this.is_unknown_doubao_content;
        r0.l1 = this.doubao_resource;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(Content.class).getSimpleName() + '@' + hashCode();
    }

    public final Abbreviation getAbbreviation() {
        return this.abbreviation;
    }

    public final List<File> getAttachments() {
        return this.attachments;
    }

    public final Integer getAudio2text_start_time() {
        return this.audio2text_start_time;
    }

    public final String getCache_file_path() {
        return this.cache_file_path;
    }

    public final CalendarContent getCalendar_content() {
        return this.calendar_content;
    }

    public final CardContent getCard_content() {
        return this.card_content;
    }

    public final Map<String, ResourceCleanScene> getClean_resource_key_scene() {
        return this.clean_resource_key_scene;
    }

    public final List<Reference> getContent_references() {
        return this.content_references;
    }

    public final Map<String, ContentValue> getContent_values() {
        return this.content_values;
    }

    public final String getCrypto_token() {
        return this.crypto_token;
    }

    public final FileType getDeprecated() {
        return this.deprecated;
    }

    public final DocEntity getDoc_entity() {
        return this.doc_entity;
    }

    public final DoubaoContent getDoubao_content() {
        return this.doubao_content;
    }

    public final DoubaoResource getDoubao_resource() {
        return this.doubao_resource;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final String getE2ee_from_id() {
        return this.e2ee_from_id;
    }

    public final String getE2ee_to_id() {
        return this.e2ee_to_id;
    }

    public final EmailSystemEvent getEvent() {
        return this.event;
    }

    public final Long getExpire_time() {
        return this.expire_time;
    }

    public final FileAbility getFile_ability() {
        return this.file_ability;
    }

    public final List<File> getFile_attachments() {
        return this.file_attachments;
    }

    public final Long getFile_last_update_time_ms() {
        return this.file_last_update_time_ms;
    }

    public final Long getFile_last_update_user_id() {
        return this.file_last_update_user_id;
    }

    public final String getFile_path() {
        return this.file_path;
    }

    public final FilePermission getFile_permission() {
        return this.file_permission;
    }

    public final FilePreviewStage getFile_preview_stage() {
        return this.file_preview_stage;
    }

    public final File.Source getFile_source() {
        return this.file_source;
    }

    public final String getFile_upload_id() {
        return this.file_upload_id;
    }

    public final String getFile_uri() {
        return this.file_uri;
    }

    public final String getFolder_archive_key() {
        return this.folder_archive_key;
    }

    public final String getFs_unit() {
        return this.fs_unit;
    }

    public final GeneralCalendarContent getGeneral_calendar_content() {
        return this.general_calendar_content;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Boolean getHide_voice2text() {
        return this.hide_voice2text;
    }

    public final HongbaoContent getHongbao_content() {
        return this.hongbao_content;
    }

    public final HongbaoSystemContent getHongbao_system_content() {
        return this.hongbao_system_content;
    }

    public final String getI18n_title_key() {
        return this.i18n_title_key;
    }

    public final ImageSet getImage() {
        return this.image;
    }

    public final String getImage_upload_id() {
        return this.image_upload_id;
    }

    public final Boolean getInclude_cleaned_resources() {
        return this.include_cleaned_resources;
    }

    public final Map<Integer, SystemMessageItemAction> getItem_actions() {
        return this.item_actions;
    }

    public final String getJoin_token() {
        return this.join_token;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getLan_receiver_device_id() {
        return this.lan_receiver_device_id;
    }

    public final String getLan_sender_device_id() {
        return this.lan_sender_device_id;
    }

    public final TransStatus getLan_trans_status() {
        return this.lan_trans_status;
    }

    public final String getLan_trans_status_text() {
        return this.lan_trans_status_text;
    }

    public final LingoOption getLingo_option() {
        return this.lingo_option;
    }

    public final LocalStatus getLocal_status() {
        return this.local_status;
    }

    public final String getLocal_upload_id() {
        return this.local_upload_id;
    }

    public final LocationContent getLocation_content() {
        return this.location_content;
    }

    public final MediaContent getMedia_content() {
        return this.media_content;
    }

    public final MergeForwardContent getMerge_forward_content() {
        return this.merge_forward_content;
    }

    public final String getMime() {
        return this.mime;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNamespace() {
        return this.namespace;
    }

    public final Long getOrigin_sender_id() {
        return this.origin_sender_id;
    }

    public final String getOrigin_sender_id_str() {
        return this.origin_sender_id_str;
    }

    public final String getOrigin_sender_name() {
        return this.origin_sender_name;
    }

    public final Long getOrigin_size() {
        return this.origin_size;
    }

    public final String getOrigin_tos_key() {
        return this.origin_tos_key;
    }

    public final List<PreviewUrlContent> getPreview_urls() {
        return this.preview_urls;
    }

    public final List<String> getResource_urls() {
        return this.resource_urls;
    }

    public final RichText getRich_text() {
        return this.rich_text;
    }

    public final List<String> getRisk_object_keys() {
        return this.risk_object_keys;
    }

    public final ShareCalendarEventContent getShare_calendar_event_content() {
        return this.share_calendar_event_content;
    }

    public final String getShare_chat_id() {
        return this.share_chat_id;
    }

    public final Integer getShare_chat_last_state() {
        return this.share_chat_last_state;
    }

    public final String getShare_chatter_id() {
        return this.share_chatter_id;
    }

    public final ShareUserCardInfo getShare_user_card_info() {
        return this.share_user_card_info;
    }

    public final Long getSize() {
        return this.size;
    }

    public final String getSticker_id() {
        return this.sticker_id;
    }

    public final StickerInfo getSticker_info() {
        return this.sticker_info;
    }

    public final String getSticker_set_id() {
        return this.sticker_set_id;
    }

    public final Map<String, SystemContentValue> getSystem_content_values() {
        return this.system_content_values;
    }

    public final SystemExtraContent getSystem_extra_content() {
        return this.system_extra_content;
    }

    public final Integer getSystem_message_version() {
        return this.system_message_version;
    }

    public final SystemType getSystem_type() {
        return this.system_type;
    }

    public final Integer getSystem_type_value() {
        return this.system_type_value;
    }

    public final String getTemplate() {
        return this.template;
    }

    public final String getText() {
        return this.text;
    }

    public final List<TextUrlContent> getText_url_contents() {
        return this.text_url_contents;
    }

    public final String getTitle() {
        return this.title;
    }

    public final TodoOperationContent getTodo_operation_content() {
        return this.todo_operation_content;
    }

    public final TransIdentity getTrans_identity() {
        return this.trans_identity;
    }

    public final TransmitInfo getTransmit_info() {
        return this.transmit_info;
    }

    public final String getTrigger_id() {
        return this.trigger_id;
    }

    public final Map<String, ElementRefs> getTyped_element_refs() {
        return this.typed_element_refs;
    }

    public final Map<String, UrlPreviewHangPoint> getUrl_preview_hang_point_map() {
        return this.url_preview_hang_point_map;
    }

    public final Map<String, String> getValues() {
        return this.values;
    }

    public final String getVc_duration_time() {
        return this.vc_duration_time;
    }

    public final String getVc_feedback_status() {
        return this.vc_feedback_status;
    }

    public final String getVc_from_feedback_status() {
        return this.vc_from_feedback_status;
    }

    public final String getVc_from_id() {
        return this.vc_from_id;
    }

    public final String getVc_meeting_id() {
        return this.vc_meeting_id;
    }

    public final String getVc_passcode() {
        return this.vc_passcode;
    }

    public final String getVc_to_feedback_status() {
        return this.vc_to_feedback_status;
    }

    public final String getVc_to_id() {
        return this.vc_to_id;
    }

    public final VideoChatContent getVideochat_content() {
        return this.videochat_content;
    }

    public final String getVoice2text() {
        return this.voice2text;
    }

    public final VoteContent getVote_content() {
        return this.vote_content;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final Boolean is_able_lan_trans() {
        return this.is_able_lan_trans;
    }

    public final Boolean is_audio_recognize_finish() {
        return this.is_audio_recognize_finish;
    }

    public final Boolean is_audio_with_text() {
        return this.is_audio_with_text;
    }

    public final Boolean is_encrypted() {
        return this.is_encrypted;
    }

    public final Boolean is_friend() {
        return this.is_friend;
    }

    public final Boolean is_group_announcement() {
        return this.is_group_announcement;
    }

    public final Boolean is_in_my_nut_store() {
        return this.is_in_my_nut_store;
    }

    public final Boolean is_origin_source() {
        return this.is_origin_source;
    }

    public final Boolean is_try_use_lan_trans() {
        return this.is_try_use_lan_trans;
    }

    public final Boolean is_unknown_doubao_content() {
        return this.is_unknown_doubao_content;
    }

    public final Boolean is_voice_call() {
        return this.is_voice_call;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public Content(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.title = r2.d;
        this.text = r2.e;
        this.image = r2.f;
        this.is_origin_source = r2.g;
        this.origin_size = r2.h;
        this.image_upload_id = r2.i;
        this.key = r2.j;
        this.name = r2.k;
        this.size = r2.l;
        this.mime = r2.m;
        this.file_upload_id = r2.n;
        this.template = r2.o;
        this.values = com.lark.wire.internal.a.d("values", r2.p);
        this.duration = r2.q;
        this.deprecated = r2.r;
        this.system_type = r2.s;
        this.event = r2.t;
        this.content_values = com.lark.wire.internal.a.d("content_values", r2.u);
        this.system_type_value = r2.v;
        this.i18n_title_key = r2.w;
        this.system_content_values = com.lark.wire.internal.a.d("system_content_values", r2.x);
        this.item_actions = com.lark.wire.internal.a.d("item_actions", r2.y);
        this.system_message_version = r2.z;
        this.voice2text = r2.A;
        this.hide_voice2text = r2.B;
        this.origin_sender_id = r2.C;
        this.local_upload_id = r2.D;
        this.origin_tos_key = r2.E;
        this.origin_sender_name = r2.F;
        this.is_friend = r2.G;
        this.origin_sender_id_str = r2.H;
        this.is_audio_recognize_finish = r2.I;
        this.audio2text_start_time = r2.J;
        this.is_audio_with_text = r2.K;
        this.url_preview_hang_point_map = com.lark.wire.internal.a.d("url_preview_hang_point_map", r2.L);
        this.is_group_announcement = r2.M;
        this.doc_entity = r2.N;
        this.file_path = r2.O;
        this.file_source = r2.P;
        this.namespace = r2.Q;
        this.is_in_my_nut_store = r2.R;
        this.cache_file_path = r2.S;
        this.lan_trans_status = r2.T;
        this.trans_identity = r2.U;
        this.lan_trans_status_text = r2.V;
        this.lan_sender_device_id = r2.W;
        this.lan_receiver_device_id = r2.X;
        this.is_try_use_lan_trans = r2.Y;
        this.is_able_lan_trans = r2.Z;
        this.file_uri = r2.a0;
        this.is_encrypted = r2.b0;
        this.risk_object_keys = com.lark.wire.internal.a.c("risk_object_keys", r2.c0);
        this.file_ability = r2.d0;
        this.file_permission = r2.e0;
        this.file_last_update_user_id = r2.f0;
        this.file_last_update_time_ms = r2.g0;
        this.local_status = r2.h0;
        this.file_preview_stage = r2.i0;
        this.attachments = com.lark.wire.internal.a.c("attachments", r2.j0);
        this.file_attachments = com.lark.wire.internal.a.c("file_attachments", r2.k0);
        this.share_chat_id = r2.l0;
        this.join_token = r2.m0;
        this.expire_time = r2.n0;
        this.share_chat_last_state = r2.o0;
        this.width = r2.p0;
        this.height = r2.q0;
        this.crypto_token = r2.r0;
        this.merge_forward_content = r2.s0;
        this.transmit_info = r2.t0;
        this.preview_urls = com.lark.wire.internal.a.c("preview_urls", r2.u0);
        this.rich_text = r2.v0;
        this.calendar_content = r2.w0;
        this.share_calendar_event_content = r2.x0;
        this.general_calendar_content = r2.y0;
        this.text_url_contents = com.lark.wire.internal.a.c("text_url_contents", r2.z0);
        this.card_content = r2.A0;
        this.location_content = r2.B0;
        this.e2ee_from_id = r2.C0;
        this.e2ee_to_id = r2.D0;
        this.trigger_id = r2.E0;
        this.vc_from_id = r2.F0;
        this.vc_to_id = r2.G0;
        this.vc_duration_time = r2.H0;
        this.vc_meeting_id = r2.I0;
        this.vc_passcode = r2.J0;
        this.vc_feedback_status = r2.K0;
        this.vc_from_feedback_status = r2.L0;
        this.vc_to_feedback_status = r2.M0;
        this.is_voice_call = r2.N0;
        this.media_content = r2.O0;
        this.hongbao_content = r2.P0;
        this.hongbao_system_content = r2.Q0;
        this.system_extra_content = r2.R0;
        this.videochat_content = r2.S0;
        this.resource_urls = com.lark.wire.internal.a.c("resource_urls", r2.T0);
        this.fs_unit = r2.U0;
        this.sticker_info = r2.V0;
        this.sticker_id = r2.W0;
        this.sticker_set_id = r2.X0;
        this.share_user_card_info = r2.Y0;
        this.share_chatter_id = r2.Z0;
        this.abbreviation = r2.a1;
        this.typed_element_refs = com.lark.wire.internal.a.d("typed_element_refs", r2.b1);
        this.todo_operation_content = r2.c1;
        this.lingo_option = r2.d1;
        this.vote_content = r2.e1;
        this.folder_archive_key = r2.f1;
        this.content_references = com.lark.wire.internal.a.c("content_references", r2.g1);
        this.include_cleaned_resources = r2.h1;
        this.clean_resource_key_scene = com.lark.wire.internal.a.d("clean_resource_key_scene", r2.i1);
        this.doubao_content = r2.j1;
        this.is_unknown_doubao_content = r2.k1;
        this.doubao_resource = r2.l1;
    }

    public /* synthetic */ Content(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
