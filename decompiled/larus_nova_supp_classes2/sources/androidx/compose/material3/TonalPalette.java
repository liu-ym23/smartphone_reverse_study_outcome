package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0003\b²\u0001\b\u0001\u0018\u00002\u00020\u0001B¿\u0005\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u0010-\u001a\u00020\u0003\u0012\u0006\u0010.\u001a\u00020\u0003\u0012\u0006\u0010/\u001a\u00020\u0003\u0012\u0006\u00100\u001a\u00020\u0003\u0012\u0006\u00101\u001a\u00020\u0003\u0012\u0006\u00102\u001a\u00020\u0003\u0012\u0006\u00103\u001a\u00020\u0003\u0012\u0006\u00104\u001a\u00020\u0003\u0012\u0006\u00105\u001a\u00020\u0003\u0012\u0006\u00106\u001a\u00020\u0003\u0012\u0006\u00107\u001a\u00020\u0003\u0012\u0006\u00108\u001a\u00020\u0003\u0012\u0006\u00109\u001a\u00020\u0003\u0012\u0006\u0010:\u001a\u00020\u0003\u0012\u0006\u0010;\u001a\u00020\u0003\u0012\u0006\u0010<\u001a\u00020\u0003\u0012\u0006\u0010=\u001a\u00020\u0003\u0012\u0006\u0010>\u001a\u00020\u0003\u0012\u0006\u0010?\u001a\u00020\u0003\u0012\u0006\u0010@\u001a\u00020\u0003\u0012\u0006\u0010A\u001a\u00020\u0003\u0012\u0006\u0010B\u001a\u00020\u0003\u0012\u0006\u0010C\u001a\u00020\u0003\u0012\u0006\u0010D\u001a\u00020\u0003\u0012\u0006\u0010E\u001a\u00020\u0003\u0012\u0006\u0010F\u001a\u00020\u0003\u0012\u0006\u0010G\u001a\u00020\u0003\u0012\u0006\u0010H\u001a\u00020\u0003\u0012\u0006\u0010I\u001a\u00020\u0003\u0012\u0006\u0010J\u001a\u00020\u0003\u0012\u0006\u0010K\u001a\u00020\u0003\u0012\u0006\u0010L\u001a\u00020\u0003\u0012\u0006\u0010M\u001a\u00020\u0003\u0012\u0006\u0010N\u001a\u00020\u0003\u0012\u0006\u0010O\u001a\u00020\u0003\u0012\u0006\u0010P\u001a\u00020\u0003\u0012\u0006\u0010Q\u001a\u00020\u0003\u0012\u0006\u0010R\u001a\u00020\u0003\u0012\u0006\u0010S\u001a\u00020\u0003\u0012\u0006\u0010T\u001a\u00020\u0003\u0012\u0006\u0010U\u001a\u00020\u0003\u0012\u0006\u0010V\u001a\u00020\u0003\u0012\u0006\u0010W\u001a\u00020\u0003\u0012\u0006\u0010X\u001a\u00020\u0003\u0012\u0006\u0010Y\u001a\u00020\u0003¢\u0006\u0004\bZ\u0010[R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\b\\\u0010]R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\b_\u0010]R\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\b`\u0010]R\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\ba\u0010]R\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\bb\u0010]R\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\bc\u0010]R\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\bd\u0010]R\u0013\u0010\n\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\be\u0010]R\u0013\u0010\u000b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\bf\u0010]R\u0013\u0010\f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\bg\u0010]R\u0013\u0010\r\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\bh\u0010]R\u0013\u0010\u000e\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\bi\u0010]R\u0013\u0010\u000f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\bj\u0010]R\u0013\u0010\u0010\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\bk\u0010]R\u0013\u0010\u0011\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\bl\u0010]R\u0013\u0010\u0012\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\bm\u0010]R\u0013\u0010\u0013\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\bn\u0010]R\u0013\u0010\u0014\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\bo\u0010]R\u0013\u0010\u0015\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\bp\u0010]R\u0013\u0010\u0016\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\bq\u0010]R\u0013\u0010\u0017\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\br\u0010]R\u0013\u0010\u0018\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\bs\u0010]R\u0013\u0010\u0019\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\bt\u0010]R\u0013\u0010\u001a\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\bu\u0010]R\u0013\u0010\u001b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\bv\u0010]R\u0013\u0010\u001c\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\bw\u0010]R\u0013\u0010\u001d\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\bx\u0010]R\u0013\u0010\u001e\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\by\u0010]R\u0013\u0010\u001f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\bz\u0010]R\u0013\u0010 \u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\b{\u0010]R\u0013\u0010!\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\b|\u0010]R\u0013\u0010\"\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\b}\u0010]R\u0013\u0010#\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\b~\u0010]R\u0013\u0010$\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010^\u001a\u0004\b\u007f\u0010]R\u0014\u0010%\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u0080\u0001\u0010]R\u0014\u0010&\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u0081\u0001\u0010]R\u0014\u0010'\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u0082\u0001\u0010]R\u0014\u0010(\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u0083\u0001\u0010]R\u0014\u0010)\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u0084\u0001\u0010]R\u0014\u0010*\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u0085\u0001\u0010]R\u0014\u0010+\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u0086\u0001\u0010]R\u0014\u0010,\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u0087\u0001\u0010]R\u0014\u0010-\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u0088\u0001\u0010]R\u0014\u0010.\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u0089\u0001\u0010]R\u0014\u0010/\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u008a\u0001\u0010]R\u0014\u00100\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u008b\u0001\u0010]R\u0014\u00101\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u008c\u0001\u0010]R\u0014\u00102\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u008d\u0001\u0010]R\u0014\u00103\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u008e\u0001\u0010]R\u0014\u00104\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u008f\u0001\u0010]R\u0014\u00105\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u0090\u0001\u0010]R\u0014\u00106\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u0091\u0001\u0010]R\u0014\u00107\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u0092\u0001\u0010]R\u0014\u00108\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u0093\u0001\u0010]R\u0014\u00109\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u0094\u0001\u0010]R\u0014\u0010:\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u0095\u0001\u0010]R\u0014\u0010;\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u0096\u0001\u0010]R\u0014\u0010<\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u0097\u0001\u0010]R\u0014\u0010=\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u0098\u0001\u0010]R\u0014\u0010>\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u0099\u0001\u0010]R\u0014\u0010?\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u009a\u0001\u0010]R\u0014\u0010@\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u009b\u0001\u0010]R\u0014\u0010A\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u009c\u0001\u0010]R\u0014\u0010B\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u009d\u0001\u0010]R\u0014\u0010C\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u009e\u0001\u0010]R\u0014\u0010D\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u009f\u0001\u0010]R\u0014\u0010E\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b \u0001\u0010]R\u0014\u0010F\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b¡\u0001\u0010]R\u0014\u0010G\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b¢\u0001\u0010]R\u0014\u0010H\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b£\u0001\u0010]R\u0014\u0010I\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b¤\u0001\u0010]R\u0014\u0010J\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b¥\u0001\u0010]R\u0014\u0010K\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b¦\u0001\u0010]R\u0014\u0010L\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b§\u0001\u0010]R\u0014\u0010M\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b¨\u0001\u0010]R\u0014\u0010N\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b©\u0001\u0010]R\u0014\u0010O\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\bª\u0001\u0010]R\u0014\u0010P\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b«\u0001\u0010]R\u0014\u0010Q\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b¬\u0001\u0010]R\u0014\u0010R\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b\u00ad\u0001\u0010]R\u0014\u0010S\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b®\u0001\u0010]R\u0014\u0010T\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b¯\u0001\u0010]R\u0014\u0010U\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b°\u0001\u0010]R\u0014\u0010V\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b±\u0001\u0010]R\u0014\u0010W\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b²\u0001\u0010]R\u0014\u0010X\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b³\u0001\u0010]R\u0014\u0010Y\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010^\u001a\u0005\b´\u0001\u0010]¨\u0006µ\u0001"}, d2 = {"Landroidx/compose/material3/TonalPalette;", "", "neutral100", "Landroidx/compose/ui/graphics/Color;", "neutral99", "neutral98", "neutral96", "neutral95", "neutral94", "neutral92", "neutral90", "neutral87", "neutral80", "neutral70", "neutral60", "neutral50", "neutral40", "neutral30", "neutral24", "neutral22", "neutral20", "neutral17", "neutral12", "neutral10", "neutral6", "neutral4", "neutral0", "neutralVariant100", "neutralVariant99", "neutralVariant98", "neutralVariant96", "neutralVariant95", "neutralVariant94", "neutralVariant92", "neutralVariant90", "neutralVariant87", "neutralVariant80", "neutralVariant70", "neutralVariant60", "neutralVariant50", "neutralVariant40", "neutralVariant30", "neutralVariant24", "neutralVariant22", "neutralVariant20", "neutralVariant17", "neutralVariant12", "neutralVariant10", "neutralVariant6", "neutralVariant4", "neutralVariant0", "primary100", "primary99", "primary95", "primary90", "primary80", "primary70", "primary60", "primary50", "primary40", "primary30", "primary20", "primary10", "primary0", "secondary100", "secondary99", "secondary95", "secondary90", "secondary80", "secondary70", "secondary60", "secondary50", "secondary40", "secondary30", "secondary20", "secondary10", "secondary0", "tertiary100", "tertiary99", "tertiary95", "tertiary90", "tertiary80", "tertiary70", "tertiary60", "tertiary50", "tertiary40", "tertiary30", "tertiary20", "tertiary10", "tertiary0", "<init>", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getNeutral100-0d7_KjU", "()J", "J", "getNeutral99-0d7_KjU", "getNeutral98-0d7_KjU", "getNeutral96-0d7_KjU", "getNeutral95-0d7_KjU", "getNeutral94-0d7_KjU", "getNeutral92-0d7_KjU", "getNeutral90-0d7_KjU", "getNeutral87-0d7_KjU", "getNeutral80-0d7_KjU", "getNeutral70-0d7_KjU", "getNeutral60-0d7_KjU", "getNeutral50-0d7_KjU", "getNeutral40-0d7_KjU", "getNeutral30-0d7_KjU", "getNeutral24-0d7_KjU", "getNeutral22-0d7_KjU", "getNeutral20-0d7_KjU", "getNeutral17-0d7_KjU", "getNeutral12-0d7_KjU", "getNeutral10-0d7_KjU", "getNeutral6-0d7_KjU", "getNeutral4-0d7_KjU", "getNeutral0-0d7_KjU", "getNeutralVariant100-0d7_KjU", "getNeutralVariant99-0d7_KjU", "getNeutralVariant98-0d7_KjU", "getNeutralVariant96-0d7_KjU", "getNeutralVariant95-0d7_KjU", "getNeutralVariant94-0d7_KjU", "getNeutralVariant92-0d7_KjU", "getNeutralVariant90-0d7_KjU", "getNeutralVariant87-0d7_KjU", "getNeutralVariant80-0d7_KjU", "getNeutralVariant70-0d7_KjU", "getNeutralVariant60-0d7_KjU", "getNeutralVariant50-0d7_KjU", "getNeutralVariant40-0d7_KjU", "getNeutralVariant30-0d7_KjU", "getNeutralVariant24-0d7_KjU", "getNeutralVariant22-0d7_KjU", "getNeutralVariant20-0d7_KjU", "getNeutralVariant17-0d7_KjU", "getNeutralVariant12-0d7_KjU", "getNeutralVariant10-0d7_KjU", "getNeutralVariant6-0d7_KjU", "getNeutralVariant4-0d7_KjU", "getNeutralVariant0-0d7_KjU", "getPrimary100-0d7_KjU", "getPrimary99-0d7_KjU", "getPrimary95-0d7_KjU", "getPrimary90-0d7_KjU", "getPrimary80-0d7_KjU", "getPrimary70-0d7_KjU", "getPrimary60-0d7_KjU", "getPrimary50-0d7_KjU", "getPrimary40-0d7_KjU", "getPrimary30-0d7_KjU", "getPrimary20-0d7_KjU", "getPrimary10-0d7_KjU", "getPrimary0-0d7_KjU", "getSecondary100-0d7_KjU", "getSecondary99-0d7_KjU", "getSecondary95-0d7_KjU", "getSecondary90-0d7_KjU", "getSecondary80-0d7_KjU", "getSecondary70-0d7_KjU", "getSecondary60-0d7_KjU", "getSecondary50-0d7_KjU", "getSecondary40-0d7_KjU", "getSecondary30-0d7_KjU", "getSecondary20-0d7_KjU", "getSecondary10-0d7_KjU", "getSecondary0-0d7_KjU", "getTertiary100-0d7_KjU", "getTertiary99-0d7_KjU", "getTertiary95-0d7_KjU", "getTertiary90-0d7_KjU", "getTertiary80-0d7_KjU", "getTertiary70-0d7_KjU", "getTertiary60-0d7_KjU", "getTertiary50-0d7_KjU", "getTertiary40-0d7_KjU", "getTertiary30-0d7_KjU", "getTertiary20-0d7_KjU", "getTertiary10-0d7_KjU", "getTertiary0-0d7_KjU", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TonalPalette {
    public static final int $stable = 0;
    private final long neutral0;
    private final long neutral10;
    private final long neutral100;
    private final long neutral12;
    private final long neutral17;
    private final long neutral20;
    private final long neutral22;
    private final long neutral24;
    private final long neutral30;
    private final long neutral4;
    private final long neutral40;
    private final long neutral50;
    private final long neutral6;
    private final long neutral60;
    private final long neutral70;
    private final long neutral80;
    private final long neutral87;
    private final long neutral90;
    private final long neutral92;
    private final long neutral94;
    private final long neutral95;
    private final long neutral96;
    private final long neutral98;
    private final long neutral99;
    private final long neutralVariant0;
    private final long neutralVariant10;
    private final long neutralVariant100;
    private final long neutralVariant12;
    private final long neutralVariant17;
    private final long neutralVariant20;
    private final long neutralVariant22;
    private final long neutralVariant24;
    private final long neutralVariant30;
    private final long neutralVariant4;
    private final long neutralVariant40;
    private final long neutralVariant50;
    private final long neutralVariant6;
    private final long neutralVariant60;
    private final long neutralVariant70;
    private final long neutralVariant80;
    private final long neutralVariant87;
    private final long neutralVariant90;
    private final long neutralVariant92;
    private final long neutralVariant94;
    private final long neutralVariant95;
    private final long neutralVariant96;
    private final long neutralVariant98;
    private final long neutralVariant99;
    private final long primary0;
    private final long primary10;
    private final long primary100;
    private final long primary20;
    private final long primary30;
    private final long primary40;
    private final long primary50;
    private final long primary60;
    private final long primary70;
    private final long primary80;
    private final long primary90;
    private final long primary95;
    private final long primary99;
    private final long secondary0;
    private final long secondary10;
    private final long secondary100;
    private final long secondary20;
    private final long secondary30;
    private final long secondary40;
    private final long secondary50;
    private final long secondary60;
    private final long secondary70;
    private final long secondary80;
    private final long secondary90;
    private final long secondary95;
    private final long secondary99;
    private final long tertiary0;
    private final long tertiary10;
    private final long tertiary100;
    private final long tertiary20;
    private final long tertiary30;
    private final long tertiary40;
    private final long tertiary50;
    private final long tertiary60;
    private final long tertiary70;
    private final long tertiary80;
    private final long tertiary90;
    private final long tertiary95;
    private final long tertiary99;

    public /* synthetic */ TonalPalette(long r1, long r3, long r5, long r7, long r9, long r11, long r13, long r15, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, long r35, long r37, long r39, long r41, long r43, long r45, long r47, long r49, long r51, long r53, long r55, long r57, long r59, long r61, long r63, long r65, long r67, long r69, long r71, long r73, long r75, long r77, long r79, long r81, long r83, long r85, long r87, long r89, long r91, long r93, long r95, long r97, long r99, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155, long r157, long r159, long r161, long r163, long r165, long r167, long r169, long r171, long r173, DefaultConstructorMarker r175) {
        this(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r63, r65, r67, r69, r71, r73, r75, r77, r79, r81, r83, r85, r87, r89, r91, r93, r95, r97, r99, r101, r103, r105, r107, r109, r111, r113, r115, r117, r119, r121, r123, r125, r127, r129, r131, r133, r135, r137, r139, r141, r143, r145, r147, r149, r151, r153, r155, r157, r159, r161, r163, r165, r167, r169, r171, r173);
    }

    /* JADX INFO: renamed from: getNeutral0-0d7_KjU, reason: not valid java name */
    public final long m3441getNeutral00d7_KjU() {
        return this.neutral0;
    }

    /* JADX INFO: renamed from: getNeutral10-0d7_KjU, reason: not valid java name */
    public final long m3442getNeutral100d7_KjU() {
        return this.neutral10;
    }

    /* JADX INFO: renamed from: getNeutral100-0d7_KjU, reason: not valid java name */
    public final long m3443getNeutral1000d7_KjU() {
        return this.neutral100;
    }

    /* JADX INFO: renamed from: getNeutral12-0d7_KjU, reason: not valid java name */
    public final long m3444getNeutral120d7_KjU() {
        return this.neutral12;
    }

    /* JADX INFO: renamed from: getNeutral17-0d7_KjU, reason: not valid java name */
    public final long m3445getNeutral170d7_KjU() {
        return this.neutral17;
    }

    /* JADX INFO: renamed from: getNeutral20-0d7_KjU, reason: not valid java name */
    public final long m3446getNeutral200d7_KjU() {
        return this.neutral20;
    }

    /* JADX INFO: renamed from: getNeutral22-0d7_KjU, reason: not valid java name */
    public final long m3447getNeutral220d7_KjU() {
        return this.neutral22;
    }

    /* JADX INFO: renamed from: getNeutral24-0d7_KjU, reason: not valid java name */
    public final long m3448getNeutral240d7_KjU() {
        return this.neutral24;
    }

    /* JADX INFO: renamed from: getNeutral30-0d7_KjU, reason: not valid java name */
    public final long m3449getNeutral300d7_KjU() {
        return this.neutral30;
    }

    /* JADX INFO: renamed from: getNeutral4-0d7_KjU, reason: not valid java name */
    public final long m3450getNeutral40d7_KjU() {
        return this.neutral4;
    }

    /* JADX INFO: renamed from: getNeutral40-0d7_KjU, reason: not valid java name */
    public final long m3451getNeutral400d7_KjU() {
        return this.neutral40;
    }

    /* JADX INFO: renamed from: getNeutral50-0d7_KjU, reason: not valid java name */
    public final long m3452getNeutral500d7_KjU() {
        return this.neutral50;
    }

    /* JADX INFO: renamed from: getNeutral6-0d7_KjU, reason: not valid java name */
    public final long m3453getNeutral60d7_KjU() {
        return this.neutral6;
    }

    /* JADX INFO: renamed from: getNeutral60-0d7_KjU, reason: not valid java name */
    public final long m3454getNeutral600d7_KjU() {
        return this.neutral60;
    }

    /* JADX INFO: renamed from: getNeutral70-0d7_KjU, reason: not valid java name */
    public final long m3455getNeutral700d7_KjU() {
        return this.neutral70;
    }

    /* JADX INFO: renamed from: getNeutral80-0d7_KjU, reason: not valid java name */
    public final long m3456getNeutral800d7_KjU() {
        return this.neutral80;
    }

    /* JADX INFO: renamed from: getNeutral87-0d7_KjU, reason: not valid java name */
    public final long m3457getNeutral870d7_KjU() {
        return this.neutral87;
    }

    /* JADX INFO: renamed from: getNeutral90-0d7_KjU, reason: not valid java name */
    public final long m3458getNeutral900d7_KjU() {
        return this.neutral90;
    }

    /* JADX INFO: renamed from: getNeutral92-0d7_KjU, reason: not valid java name */
    public final long m3459getNeutral920d7_KjU() {
        return this.neutral92;
    }

    /* JADX INFO: renamed from: getNeutral94-0d7_KjU, reason: not valid java name */
    public final long m3460getNeutral940d7_KjU() {
        return this.neutral94;
    }

    /* JADX INFO: renamed from: getNeutral95-0d7_KjU, reason: not valid java name */
    public final long m3461getNeutral950d7_KjU() {
        return this.neutral95;
    }

    /* JADX INFO: renamed from: getNeutral96-0d7_KjU, reason: not valid java name */
    public final long m3462getNeutral960d7_KjU() {
        return this.neutral96;
    }

    /* JADX INFO: renamed from: getNeutral98-0d7_KjU, reason: not valid java name */
    public final long m3463getNeutral980d7_KjU() {
        return this.neutral98;
    }

    /* JADX INFO: renamed from: getNeutral99-0d7_KjU, reason: not valid java name */
    public final long m3464getNeutral990d7_KjU() {
        return this.neutral99;
    }

    /* JADX INFO: renamed from: getNeutralVariant0-0d7_KjU, reason: not valid java name */
    public final long m3465getNeutralVariant00d7_KjU() {
        return this.neutralVariant0;
    }

    /* JADX INFO: renamed from: getNeutralVariant10-0d7_KjU, reason: not valid java name */
    public final long m3466getNeutralVariant100d7_KjU() {
        return this.neutralVariant10;
    }

    /* JADX INFO: renamed from: getNeutralVariant100-0d7_KjU, reason: not valid java name */
    public final long m3467getNeutralVariant1000d7_KjU() {
        return this.neutralVariant100;
    }

    /* JADX INFO: renamed from: getNeutralVariant12-0d7_KjU, reason: not valid java name */
    public final long m3468getNeutralVariant120d7_KjU() {
        return this.neutralVariant12;
    }

    /* JADX INFO: renamed from: getNeutralVariant17-0d7_KjU, reason: not valid java name */
    public final long m3469getNeutralVariant170d7_KjU() {
        return this.neutralVariant17;
    }

    /* JADX INFO: renamed from: getNeutralVariant20-0d7_KjU, reason: not valid java name */
    public final long m3470getNeutralVariant200d7_KjU() {
        return this.neutralVariant20;
    }

    /* JADX INFO: renamed from: getNeutralVariant22-0d7_KjU, reason: not valid java name */
    public final long m3471getNeutralVariant220d7_KjU() {
        return this.neutralVariant22;
    }

    /* JADX INFO: renamed from: getNeutralVariant24-0d7_KjU, reason: not valid java name */
    public final long m3472getNeutralVariant240d7_KjU() {
        return this.neutralVariant24;
    }

    /* JADX INFO: renamed from: getNeutralVariant30-0d7_KjU, reason: not valid java name */
    public final long m3473getNeutralVariant300d7_KjU() {
        return this.neutralVariant30;
    }

    /* JADX INFO: renamed from: getNeutralVariant4-0d7_KjU, reason: not valid java name */
    public final long m3474getNeutralVariant40d7_KjU() {
        return this.neutralVariant4;
    }

    /* JADX INFO: renamed from: getNeutralVariant40-0d7_KjU, reason: not valid java name */
    public final long m3475getNeutralVariant400d7_KjU() {
        return this.neutralVariant40;
    }

    /* JADX INFO: renamed from: getNeutralVariant50-0d7_KjU, reason: not valid java name */
    public final long m3476getNeutralVariant500d7_KjU() {
        return this.neutralVariant50;
    }

    /* JADX INFO: renamed from: getNeutralVariant6-0d7_KjU, reason: not valid java name */
    public final long m3477getNeutralVariant60d7_KjU() {
        return this.neutralVariant6;
    }

    /* JADX INFO: renamed from: getNeutralVariant60-0d7_KjU, reason: not valid java name */
    public final long m3478getNeutralVariant600d7_KjU() {
        return this.neutralVariant60;
    }

    /* JADX INFO: renamed from: getNeutralVariant70-0d7_KjU, reason: not valid java name */
    public final long m3479getNeutralVariant700d7_KjU() {
        return this.neutralVariant70;
    }

    /* JADX INFO: renamed from: getNeutralVariant80-0d7_KjU, reason: not valid java name */
    public final long m3480getNeutralVariant800d7_KjU() {
        return this.neutralVariant80;
    }

    /* JADX INFO: renamed from: getNeutralVariant87-0d7_KjU, reason: not valid java name */
    public final long m3481getNeutralVariant870d7_KjU() {
        return this.neutralVariant87;
    }

    /* JADX INFO: renamed from: getNeutralVariant90-0d7_KjU, reason: not valid java name */
    public final long m3482getNeutralVariant900d7_KjU() {
        return this.neutralVariant90;
    }

    /* JADX INFO: renamed from: getNeutralVariant92-0d7_KjU, reason: not valid java name */
    public final long m3483getNeutralVariant920d7_KjU() {
        return this.neutralVariant92;
    }

    /* JADX INFO: renamed from: getNeutralVariant94-0d7_KjU, reason: not valid java name */
    public final long m3484getNeutralVariant940d7_KjU() {
        return this.neutralVariant94;
    }

    /* JADX INFO: renamed from: getNeutralVariant95-0d7_KjU, reason: not valid java name */
    public final long m3485getNeutralVariant950d7_KjU() {
        return this.neutralVariant95;
    }

    /* JADX INFO: renamed from: getNeutralVariant96-0d7_KjU, reason: not valid java name */
    public final long m3486getNeutralVariant960d7_KjU() {
        return this.neutralVariant96;
    }

    /* JADX INFO: renamed from: getNeutralVariant98-0d7_KjU, reason: not valid java name */
    public final long m3487getNeutralVariant980d7_KjU() {
        return this.neutralVariant98;
    }

    /* JADX INFO: renamed from: getNeutralVariant99-0d7_KjU, reason: not valid java name */
    public final long m3488getNeutralVariant990d7_KjU() {
        return this.neutralVariant99;
    }

    /* JADX INFO: renamed from: getPrimary0-0d7_KjU, reason: not valid java name */
    public final long m3489getPrimary00d7_KjU() {
        return this.primary0;
    }

    /* JADX INFO: renamed from: getPrimary10-0d7_KjU, reason: not valid java name */
    public final long m3490getPrimary100d7_KjU() {
        return this.primary10;
    }

    /* JADX INFO: renamed from: getPrimary100-0d7_KjU, reason: not valid java name */
    public final long m3491getPrimary1000d7_KjU() {
        return this.primary100;
    }

    /* JADX INFO: renamed from: getPrimary20-0d7_KjU, reason: not valid java name */
    public final long m3492getPrimary200d7_KjU() {
        return this.primary20;
    }

    /* JADX INFO: renamed from: getPrimary30-0d7_KjU, reason: not valid java name */
    public final long m3493getPrimary300d7_KjU() {
        return this.primary30;
    }

    /* JADX INFO: renamed from: getPrimary40-0d7_KjU, reason: not valid java name */
    public final long m3494getPrimary400d7_KjU() {
        return this.primary40;
    }

    /* JADX INFO: renamed from: getPrimary50-0d7_KjU, reason: not valid java name */
    public final long m3495getPrimary500d7_KjU() {
        return this.primary50;
    }

    /* JADX INFO: renamed from: getPrimary60-0d7_KjU, reason: not valid java name */
    public final long m3496getPrimary600d7_KjU() {
        return this.primary60;
    }

    /* JADX INFO: renamed from: getPrimary70-0d7_KjU, reason: not valid java name */
    public final long m3497getPrimary700d7_KjU() {
        return this.primary70;
    }

    /* JADX INFO: renamed from: getPrimary80-0d7_KjU, reason: not valid java name */
    public final long m3498getPrimary800d7_KjU() {
        return this.primary80;
    }

    /* JADX INFO: renamed from: getPrimary90-0d7_KjU, reason: not valid java name */
    public final long m3499getPrimary900d7_KjU() {
        return this.primary90;
    }

    /* JADX INFO: renamed from: getPrimary95-0d7_KjU, reason: not valid java name */
    public final long m3500getPrimary950d7_KjU() {
        return this.primary95;
    }

    /* JADX INFO: renamed from: getPrimary99-0d7_KjU, reason: not valid java name */
    public final long m3501getPrimary990d7_KjU() {
        return this.primary99;
    }

    /* JADX INFO: renamed from: getSecondary0-0d7_KjU, reason: not valid java name */
    public final long m3502getSecondary00d7_KjU() {
        return this.secondary0;
    }

    /* JADX INFO: renamed from: getSecondary10-0d7_KjU, reason: not valid java name */
    public final long m3503getSecondary100d7_KjU() {
        return this.secondary10;
    }

    /* JADX INFO: renamed from: getSecondary100-0d7_KjU, reason: not valid java name */
    public final long m3504getSecondary1000d7_KjU() {
        return this.secondary100;
    }

    /* JADX INFO: renamed from: getSecondary20-0d7_KjU, reason: not valid java name */
    public final long m3505getSecondary200d7_KjU() {
        return this.secondary20;
    }

    /* JADX INFO: renamed from: getSecondary30-0d7_KjU, reason: not valid java name */
    public final long m3506getSecondary300d7_KjU() {
        return this.secondary30;
    }

    /* JADX INFO: renamed from: getSecondary40-0d7_KjU, reason: not valid java name */
    public final long m3507getSecondary400d7_KjU() {
        return this.secondary40;
    }

    /* JADX INFO: renamed from: getSecondary50-0d7_KjU, reason: not valid java name */
    public final long m3508getSecondary500d7_KjU() {
        return this.secondary50;
    }

    /* JADX INFO: renamed from: getSecondary60-0d7_KjU, reason: not valid java name */
    public final long m3509getSecondary600d7_KjU() {
        return this.secondary60;
    }

    /* JADX INFO: renamed from: getSecondary70-0d7_KjU, reason: not valid java name */
    public final long m3510getSecondary700d7_KjU() {
        return this.secondary70;
    }

    /* JADX INFO: renamed from: getSecondary80-0d7_KjU, reason: not valid java name */
    public final long m3511getSecondary800d7_KjU() {
        return this.secondary80;
    }

    /* JADX INFO: renamed from: getSecondary90-0d7_KjU, reason: not valid java name */
    public final long m3512getSecondary900d7_KjU() {
        return this.secondary90;
    }

    /* JADX INFO: renamed from: getSecondary95-0d7_KjU, reason: not valid java name */
    public final long m3513getSecondary950d7_KjU() {
        return this.secondary95;
    }

    /* JADX INFO: renamed from: getSecondary99-0d7_KjU, reason: not valid java name */
    public final long m3514getSecondary990d7_KjU() {
        return this.secondary99;
    }

    /* JADX INFO: renamed from: getTertiary0-0d7_KjU, reason: not valid java name */
    public final long m3515getTertiary00d7_KjU() {
        return this.tertiary0;
    }

    /* JADX INFO: renamed from: getTertiary10-0d7_KjU, reason: not valid java name */
    public final long m3516getTertiary100d7_KjU() {
        return this.tertiary10;
    }

    /* JADX INFO: renamed from: getTertiary100-0d7_KjU, reason: not valid java name */
    public final long m3517getTertiary1000d7_KjU() {
        return this.tertiary100;
    }

    /* JADX INFO: renamed from: getTertiary20-0d7_KjU, reason: not valid java name */
    public final long m3518getTertiary200d7_KjU() {
        return this.tertiary20;
    }

    /* JADX INFO: renamed from: getTertiary30-0d7_KjU, reason: not valid java name */
    public final long m3519getTertiary300d7_KjU() {
        return this.tertiary30;
    }

    /* JADX INFO: renamed from: getTertiary40-0d7_KjU, reason: not valid java name */
    public final long m3520getTertiary400d7_KjU() {
        return this.tertiary40;
    }

    /* JADX INFO: renamed from: getTertiary50-0d7_KjU, reason: not valid java name */
    public final long m3521getTertiary500d7_KjU() {
        return this.tertiary50;
    }

    /* JADX INFO: renamed from: getTertiary60-0d7_KjU, reason: not valid java name */
    public final long m3522getTertiary600d7_KjU() {
        return this.tertiary60;
    }

    /* JADX INFO: renamed from: getTertiary70-0d7_KjU, reason: not valid java name */
    public final long m3523getTertiary700d7_KjU() {
        return this.tertiary70;
    }

    /* JADX INFO: renamed from: getTertiary80-0d7_KjU, reason: not valid java name */
    public final long m3524getTertiary800d7_KjU() {
        return this.tertiary80;
    }

    /* JADX INFO: renamed from: getTertiary90-0d7_KjU, reason: not valid java name */
    public final long m3525getTertiary900d7_KjU() {
        return this.tertiary90;
    }

    /* JADX INFO: renamed from: getTertiary95-0d7_KjU, reason: not valid java name */
    public final long m3526getTertiary950d7_KjU() {
        return this.tertiary95;
    }

    /* JADX INFO: renamed from: getTertiary99-0d7_KjU, reason: not valid java name */
    public final long m3527getTertiary990d7_KjU() {
        return this.tertiary99;
    }

    private TonalPalette(long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32, long r34, long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50, long r52, long r54, long r56, long r58, long r60, long r62, long r64, long r66, long r68, long r70, long r72, long r74, long r76, long r78, long r80, long r82, long r84, long r86, long r88, long r90, long r92, long r94, long r96, long r98, long r100, long r102, long r104, long r106, long r108, long r110, long r112, long r114, long r116, long r118, long r120, long r122, long r124, long r126, long r128, long r130, long r132, long r134, long r136, long r138, long r140, long r142, long r144, long r146, long r148, long r150, long r152, long r154, long r156, long r158, long r160, long r162, long r164, long r166, long r168, long r170, long r172, long r174, long r176) {
        this.neutral100 = r4;
        this.neutral99 = r6;
        this.neutral98 = r8;
        this.neutral96 = r10;
        this.neutral95 = r12;
        this.neutral94 = r14;
        this.neutral92 = r16;
        this.neutral90 = r18;
        this.neutral87 = r20;
        this.neutral80 = r22;
        this.neutral70 = r24;
        this.neutral60 = r26;
        this.neutral50 = r28;
        this.neutral40 = r30;
        this.neutral30 = r32;
        this.neutral24 = r34;
        this.neutral22 = r36;
        this.neutral20 = r38;
        this.neutral17 = r40;
        this.neutral12 = r42;
        this.neutral10 = r44;
        this.neutral6 = r46;
        this.neutral4 = r48;
        this.neutral0 = r50;
        this.neutralVariant100 = r52;
        this.neutralVariant99 = r54;
        this.neutralVariant98 = r56;
        this.neutralVariant96 = r58;
        this.neutralVariant95 = r60;
        this.neutralVariant94 = r62;
        this.neutralVariant92 = r64;
        this.neutralVariant90 = r66;
        this.neutralVariant87 = r68;
        this.neutralVariant80 = r70;
        this.neutralVariant70 = r72;
        this.neutralVariant60 = r74;
        this.neutralVariant50 = r76;
        this.neutralVariant40 = r78;
        this.neutralVariant30 = r80;
        this.neutralVariant24 = r82;
        this.neutralVariant22 = r84;
        this.neutralVariant20 = r86;
        this.neutralVariant17 = r88;
        this.neutralVariant12 = r90;
        this.neutralVariant10 = r92;
        this.neutralVariant6 = r94;
        this.neutralVariant4 = r96;
        this.neutralVariant0 = r98;
        this.primary100 = r100;
        this.primary99 = r102;
        this.primary95 = r104;
        this.primary90 = r106;
        this.primary80 = r108;
        this.primary70 = r110;
        this.primary60 = r112;
        this.primary50 = r114;
        this.primary40 = r116;
        this.primary30 = r118;
        this.primary20 = r120;
        this.primary10 = r122;
        this.primary0 = r124;
        this.secondary100 = r126;
        this.secondary99 = r128;
        this.secondary95 = r130;
        this.secondary90 = r132;
        this.secondary80 = r134;
        this.secondary70 = r136;
        this.secondary60 = r138;
        this.secondary50 = r140;
        this.secondary40 = r142;
        this.secondary30 = r144;
        this.secondary20 = r146;
        this.secondary10 = r148;
        this.secondary0 = r150;
        this.tertiary100 = r152;
        this.tertiary99 = r154;
        this.tertiary95 = r156;
        this.tertiary90 = r158;
        this.tertiary80 = r160;
        this.tertiary70 = r162;
        this.tertiary60 = r164;
        this.tertiary50 = r166;
        this.tertiary40 = r168;
        this.tertiary30 = r170;
        this.tertiary20 = r172;
        this.tertiary10 = r174;
        this.tertiary0 = r176;
    }
}
