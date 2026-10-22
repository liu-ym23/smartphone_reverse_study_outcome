package y93;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0003\bõ\u0001\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\rR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\rR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\rR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\rR\u001c\u0010!\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u000b\u001a\u0004\b\"\u0010\rR\u001c\u0010$\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u000b\u001a\u0004\b)\u0010\rR\u001c\u0010*\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u000b\u001a\u0004\b+\u0010\rR\u001c\u0010,\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\u000b\u001a\u0004\b-\u0010\rR\u001c\u0010.\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b/\u0010\rR\u001c\u00100\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010\u000b\u001a\u0004\b1\u0010\rR\u001c\u00102\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010\u000b\u001a\u0004\b3\u0010\rR\u001c\u00104\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010\u0016\u001a\u0004\b5\u0010\u0018R\u001c\u00106\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010\u000b\u001a\u0004\b7\u0010\rR\u001c\u00108\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010\u000b\u001a\u0004\b9\u0010\rR\u001c\u0010:\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010\u000b\u001a\u0004\b;\u0010\rR\u001c\u0010<\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010\u0004\u001a\u0004\b=\u0010\u0006R\u001c\u0010>\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010\u000b\u001a\u0004\b?\u0010\rR\u001c\u0010@\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010\u000b\u001a\u0004\bA\u0010\rR\u001c\u0010B\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bB\u0010\u000b\u001a\u0004\bC\u0010\rR\u001c\u0010D\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bD\u0010\u000b\u001a\u0004\bE\u0010\rR\u001c\u0010F\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bF\u0010\u0004\u001a\u0004\bG\u0010\u0006R\u001c\u0010H\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bH\u0010\u0004\u001a\u0004\bI\u0010\u0006R\u001c\u0010J\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bJ\u0010\u0004\u001a\u0004\bK\u0010\u0006R\u001c\u0010L\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\bL\u0010\u0016\u001a\u0004\bM\u0010\u0018R\u001c\u0010N\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bN\u0010\u0004\u001a\u0004\bO\u0010\u0006R\u001c\u0010P\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bP\u0010\u0004\u001a\u0004\bQ\u0010\u0006R\u001c\u0010R\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bR\u0010\u000b\u001a\u0004\bS\u0010\rR\u001c\u0010T\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bT\u0010\u000b\u001a\u0004\bU\u0010\rR\u001c\u0010V\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bV\u0010\u000b\u001a\u0004\bW\u0010\rR\u001c\u0010X\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bX\u0010\u0004\u001a\u0004\bY\u0010\u0006R\u001c\u0010Z\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bZ\u0010\u000b\u001a\u0004\b[\u0010\rR\u001c\u0010\\\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\\\u0010\u000b\u001a\u0004\b]\u0010\rR\u001c\u0010^\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b^\u0010\u0004\u001a\u0004\b_\u0010\u0006R\u001c\u0010`\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b`\u0010\u0004\u001a\u0004\ba\u0010\u0006R\u001c\u0010b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bb\u0010\u000b\u001a\u0004\bc\u0010\rR\u001c\u0010d\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bd\u0010\u000b\u001a\u0004\be\u0010\rR\u001c\u0010f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bf\u0010\u0004\u001a\u0004\bg\u0010\u0006R\u001c\u0010h\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bh\u0010\u0004\u001a\u0004\bi\u0010\u0006R\u001c\u0010j\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bj\u0010\u000b\u001a\u0004\bk\u0010\rR\u001c\u0010l\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bl\u0010\u000b\u001a\u0004\bm\u0010\rR\u001c\u0010n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bn\u0010\u0004\u001a\u0004\bo\u0010\u0006R\u001c\u0010p\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bp\u0010\u0004\u001a\u0004\bq\u0010\u0006R\u001a\u0010r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010uR\u001c\u0010v\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bv\u0010\u000b\u001a\u0004\bw\u0010\rR\u001c\u0010x\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bx\u0010\u000b\u001a\u0004\by\u0010\rR\u001c\u0010z\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bz\u0010\u000b\u001a\u0004\b{\u0010\rR\u001c\u0010|\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b|\u0010\u000b\u001a\u0004\b}\u0010\rR\u001c\u0010~\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b~\u0010\u000b\u001a\u0004\b\u007f\u0010\rR\u001f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0080\u0001\u0010\u000b\u001a\u0005\b\u0081\u0001\u0010\rR\u001f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0082\u0001\u0010\u000b\u001a\u0005\b\u0083\u0001\u0010\rR\u001f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0084\u0001\u0010\u000b\u001a\u0005\b\u0085\u0001\u0010\rR\u001f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0086\u0001\u0010\u000b\u001a\u0005\b\u0087\u0001\u0010\rR\u001f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0088\u0001\u0010\u0016\u001a\u0005\b\u0089\u0001\u0010\u0018R\u001f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u008a\u0001\u0010\u000b\u001a\u0005\b\u008b\u0001\u0010\rR\u001f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u008c\u0001\u0010\u000b\u001a\u0005\b\u008d\u0001\u0010\rR\u001f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u008e\u0001\u0010\u000b\u001a\u0005\b\u008f\u0001\u0010\rR\u001f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0090\u0001\u0010\u0016\u001a\u0005\b\u0091\u0001\u0010\u0018R\u001f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0092\u0001\u0010\u000b\u001a\u0005\b\u0093\u0001\u0010\rR\u001f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0094\u0001\u0010\u000b\u001a\u0005\b\u0095\u0001\u0010\rR\u001f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0096\u0001\u0010\u000b\u001a\u0005\b\u0097\u0001\u0010\rR\u001f\u0010\u0098\u0001\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0098\u0001\u0010%\u001a\u0005\b\u0099\u0001\u0010'R\u001f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u009a\u0001\u0010\u000b\u001a\u0005\b\u009b\u0001\u0010\rR\u001f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u009c\u0001\u0010\u000b\u001a\u0005\b\u009d\u0001\u0010\rR\u001f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u009e\u0001\u0010\u0004\u001a\u0005\b\u009f\u0001\u0010\u0006R\u001f\u0010 \u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b \u0001\u0010\u000b\u001a\u0005\b¡\u0001\u0010\rR\u001f\u0010¢\u0001\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¢\u0001\u0010\u0016\u001a\u0005\b£\u0001\u0010\u0018R\u001f\u0010¤\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¤\u0001\u0010\u0004\u001a\u0005\b¥\u0001\u0010\u0006R\u001f\u0010¦\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¦\u0001\u0010\u0004\u001a\u0005\b§\u0001\u0010\u0006R\u001f\u0010¨\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¨\u0001\u0010\u000b\u001a\u0005\b©\u0001\u0010\rR\u001f\u0010ª\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bª\u0001\u0010\u000b\u001a\u0005\b«\u0001\u0010\rR\u001f\u0010¬\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¬\u0001\u0010\u000b\u001a\u0005\b\u00ad\u0001\u0010\rR\u001f\u0010®\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b®\u0001\u0010\u000b\u001a\u0005\b¯\u0001\u0010\rR\u001f\u0010°\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b°\u0001\u0010\u000b\u001a\u0005\b±\u0001\u0010\rR\u001f\u0010²\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b²\u0001\u0010\u000b\u001a\u0005\b³\u0001\u0010\rR\u001f\u0010´\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b´\u0001\u0010\u000b\u001a\u0005\bµ\u0001\u0010\rR\u001f\u0010¶\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¶\u0001\u0010\u000b\u001a\u0005\b·\u0001\u0010\rR\u001f\u0010¸\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¸\u0001\u0010\u000b\u001a\u0005\b¹\u0001\u0010\rR\u001f\u0010º\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bº\u0001\u0010\u000b\u001a\u0005\b»\u0001\u0010\rR\u001f\u0010¼\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¼\u0001\u0010\u000b\u001a\u0005\b½\u0001\u0010\rR\u001f\u0010¾\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¾\u0001\u0010\u000b\u001a\u0005\b¿\u0001\u0010\rR\u001f\u0010À\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÀ\u0001\u0010\u000b\u001a\u0005\bÁ\u0001\u0010\rR\u001f\u0010Â\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÂ\u0001\u0010\u000b\u001a\u0005\bÃ\u0001\u0010\rR\u001f\u0010Ä\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÄ\u0001\u0010\u000b\u001a\u0005\bÅ\u0001\u0010\rR\u001f\u0010Æ\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÆ\u0001\u0010\u000b\u001a\u0005\bÇ\u0001\u0010\rR\u001f\u0010È\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÈ\u0001\u0010\u000b\u001a\u0005\bÉ\u0001\u0010\rR\u001f\u0010Ê\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÊ\u0001\u0010\u000b\u001a\u0005\bË\u0001\u0010\rR\u001f\u0010Ì\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÌ\u0001\u0010\u000b\u001a\u0005\bÍ\u0001\u0010\rR\u001f\u0010Î\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÎ\u0001\u0010\u000b\u001a\u0005\bÏ\u0001\u0010\rR\u001f\u0010Ð\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÐ\u0001\u0010\u000b\u001a\u0005\bÑ\u0001\u0010\rR\u001f\u0010Ò\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÒ\u0001\u0010\u000b\u001a\u0005\bÓ\u0001\u0010\rR\u001f\u0010Ô\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÔ\u0001\u0010\u000b\u001a\u0005\bÕ\u0001\u0010\rR\u001f\u0010Ö\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÖ\u0001\u0010\u000b\u001a\u0005\b×\u0001\u0010\rR\u001f\u0010Ø\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bØ\u0001\u0010\u000b\u001a\u0005\bÙ\u0001\u0010\rR\u001f\u0010Ú\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÚ\u0001\u0010\u000b\u001a\u0005\bÛ\u0001\u0010\rR\u001f\u0010Ü\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÜ\u0001\u0010\u000b\u001a\u0005\bÝ\u0001\u0010\rR\u001f\u0010Þ\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÞ\u0001\u0010\u000b\u001a\u0005\bß\u0001\u0010\rR\u001f\u0010à\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bà\u0001\u0010\u000b\u001a\u0005\bá\u0001\u0010\rR\u001f\u0010â\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bâ\u0001\u0010\u000b\u001a\u0005\bã\u0001\u0010\rR\u001f\u0010ä\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bä\u0001\u0010\u000b\u001a\u0005\bå\u0001\u0010\rR\u001f\u0010æ\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bæ\u0001\u0010\u000b\u001a\u0005\bç\u0001\u0010\rR\u001f\u0010è\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bè\u0001\u0010\u000b\u001a\u0005\bé\u0001\u0010\rR\u001f\u0010ê\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bê\u0001\u0010\u000b\u001a\u0005\bë\u0001\u0010\rR\u001f\u0010ì\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bì\u0001\u0010\u000b\u001a\u0005\bí\u0001\u0010\rR\u001f\u0010î\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bî\u0001\u0010\u000b\u001a\u0005\bï\u0001\u0010\rR\u001f\u0010ð\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bð\u0001\u0010\u000b\u001a\u0005\bñ\u0001\u0010\rR\u001f\u0010ò\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bò\u0001\u0010\u0004\u001a\u0005\bó\u0001\u0010\u0006R\u001f\u0010ô\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bô\u0001\u0010\u000b\u001a\u0005\bõ\u0001\u0010\rR\u001f\u0010ö\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bö\u0001\u0010\u000b\u001a\u0005\b÷\u0001\u0010\rR\u001f\u0010ø\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bø\u0001\u0010\u000b\u001a\u0005\bù\u0001\u0010\rR\u001f\u0010ú\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bú\u0001\u0010\u000b\u001a\u0005\bû\u0001\u0010\rR\u001f\u0010ü\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bü\u0001\u0010\u000b\u001a\u0005\bý\u0001\u0010\rR\u001f\u0010þ\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bþ\u0001\u0010\u000b\u001a\u0005\bÿ\u0001\u0010\rR\u001f\u0010\u0080\u0002\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0080\u0002\u0010\u000b\u001a\u0005\b\u0081\u0002\u0010\rR\u001f\u0010\u0082\u0002\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0082\u0002\u0010\u000b\u001a\u0005\b\u0083\u0002\u0010\rR\u001f\u0010\u0084\u0002\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0084\u0002\u0010\u000b\u001a\u0005\b\u0085\u0002\u0010\rR\u001f\u0010\u0086\u0002\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0086\u0002\u0010\u000b\u001a\u0005\b\u0087\u0002\u0010\rR\u001f\u0010\u0088\u0002\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0088\u0002\u0010\u000b\u001a\u0005\b\u0089\u0002\u0010\rR\u001f\u0010\u008a\u0002\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u008a\u0002\u0010\u000b\u001a\u0005\b\u008b\u0002\u0010\rR\u001f\u0010\u008c\u0002\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u008c\u0002\u0010\u0004\u001a\u0005\b\u008d\u0002\u0010\u0006R\u001f\u0010\u008e\u0002\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u008e\u0002\u0010\u0004\u001a\u0005\b\u008f\u0002\u0010\u0006R\u001f\u0010\u0090\u0002\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0090\u0002\u0010\u0004\u001a\u0005\b\u0091\u0002\u0010\u0006R\u001f\u0010\u0092\u0002\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0092\u0002\u0010\u0016\u001a\u0005\b\u0093\u0002\u0010\u0018R\u001f\u0010\u0094\u0002\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0094\u0002\u0010\u0004\u001a\u0005\b\u0095\u0002\u0010\u0006R\u001f\u0010\u0096\u0002\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0096\u0002\u0010\u0016\u001a\u0005\b\u0097\u0002\u0010\u0018¨\u0006\u0098\u0002"}, d2 = {"Ly93/a;", "", "", "serverLoginStatus", "Ljava/lang/Integer;", "getServerLoginStatus", "()Ljava/lang/Integer;", "clientLoginStatus", "b", "", "preloadStartTimestamp", "Ljava/lang/Long;", "v", "()Ljava/lang/Long;", "preloadEndTimestamp", "u", "preloadConfigStart", "getPreloadConfigStart", "preloadConfigEnd", "getPreloadConfigEnd", "", "preloadConfigResult", "Ljava/lang/String;", "getPreloadConfigResult", "()Ljava/lang/String;", "prefetchStart", "getPrefetchStart", "prefetchEnd", "getPrefetchEnd", "openTime", "q", "entranceFragmentCreateViewStart", "getEntranceFragmentCreateViewStart", "entranceFragmentCreateViewEnd", "getEntranceFragmentCreateViewEnd", "", "popupPageStraightOut", "Ljava/lang/Boolean;", "s", "()Ljava/lang/Boolean;", "initLynxStart", "getInitLynxStart", "initLynxEnd", "getInitLynxEnd", "fragmentCreateViewStart", "getFragmentCreateViewStart", "fragmentCreateViewEnd", "getFragmentCreateViewEnd", "loadBundleStart", "getLoadBundleStart", "loadBundleEnd", "getLoadBundleEnd", "loadBundleWay", "l", "netStart", "p", "netEnd", "n", "netEndClient", "o", "catchNoBind", "getCatchNoBind", "handlePrefetchedDataTime", "i", "listLoadStart", "k", "listFirstScreen", "j", "listLoadEnd", "getListLoadEnd", "halfPageOpen", "h", "status", "y", "errCode", "getErrCode", "errMsg", "c", "leaveType", "getLeaveType", "retryStatus", "getRetryStatus", "leaveTime", "getLeaveTime", "geckoStart", "f", "geckoEnd", "e", "geckoStatus", "getGeckoStatus", "depPluginInstallStart", "getDepPluginInstallStart", "depPluginInstallEnd", "getDepPluginInstallEnd", "depPluginStatus", "getDepPluginStatus", "ecPluginStatus", "getEcPluginStatus", "tPrepareCachedDataStart", "E", "tPrepareCachedDataEnd", "D", "cachedDataPreparedStatus", "getCachedDataPreparedStatus", "dataReuseStatus", "getDataReuseStatus", "tPrepareFirstScreenDataStart", "G", "tPrepareFirstScreenDataEnd", "F", "firstScreenDataPreparedStatus", "getFirstScreenDataPreparedStatus", "rebuildScene", "w", "straightOutFlag", "I", "getStraightOutFlag", "()I", "tFirstScreenStraightOutStart", "C", "tFirstScreenStraightOutEnd", "B", "tNAContainerReady", "getTNAContainerReady", "tStraightOutLoadTime", "getTStraightOutLoadTime", "tStraightOutCreateViewTime", "getTStraightOutCreateViewTime", "tDialogFirstScreenStart", "getTDialogFirstScreenStart", "tDialogFirstScreenEnd", "getTDialogFirstScreenEnd", "tDialogPreprocessStartTime", "getTDialogPreprocessStartTime", "tDialogPreprocessEndTime", "getTDialogPreprocessEndTime", "firstChunkName", "getFirstChunkName", "firstChunkReceived", "getFirstChunkReceived", "firstChunkRenderStart", "getFirstChunkRenderStart", "firstChunkRenderEnd", "getFirstChunkRenderEnd", "secondChunkName", "getSecondChunkName", "secondChunkReceived", "getSecondChunkReceived", "secondChunkRenderStart", "x", "secondChunkRenderEnd", "getSecondChunkRenderEnd", "skipRenderWithFullData", "getSkipRenderWithFullData", "tabClickTime", "getTabClickTime", "multiMallFrameTime", "getMultiMallFrameTime", "gylNumOfFirstScreen", "g", "immerseBindRealDataTime", "getImmerseBindRealDataTime", "immerseBindRealDataReason", "getImmerseBindRealDataReason", "straightOutHeaderCardType", "z", "firstScreenHeaderCardType", "d", "tFirstScreenEnd", "A", "mallCategoryTabFragmentOnCreateStart", "getMallCategoryTabFragmentOnCreateStart", "mallCategoryTabFragmentOnCreateEnd", "getMallCategoryTabFragmentOnCreateEnd", "mallCategoryTabFragmentOnCreateViewStart", "getMallCategoryTabFragmentOnCreateViewStart", "mallCategoryTabFragmentOnCreateViewEnd", "getMallCategoryTabFragmentOnCreateViewEnd", "mallCategoryTabFragmentViewCreatedStart", "getMallCategoryTabFragmentViewCreatedStart", "mallCategoryTabFragmentViewCreatedEnd", "getMallCategoryTabFragmentViewCreatedEnd", "mallCategoryTabFragmentOnResumeStart", "getMallCategoryTabFragmentOnResumeStart", "mallCategoryTabFragmentOnResumeEnd", "getMallCategoryTabFragmentOnResumeEnd", "mallHomeFragmentOnCreateStart", "getMallHomeFragmentOnCreateStart", "mallHomeFragmentOnCreateEnd", "getMallHomeFragmentOnCreateEnd", "mallHomeFragmentOnCreateViewStart", "getMallHomeFragmentOnCreateViewStart", "mallHomeFragmentOnCreateViewEnd", "getMallHomeFragmentOnCreateViewEnd", "mallHomeFragmentViewCreatedStart", "getMallHomeFragmentViewCreatedStart", "mallHomeFragmentViewCreatedEnd", "getMallHomeFragmentViewCreatedEnd", "mallHomeFragmentOnResumeStart", "getMallHomeFragmentOnResumeStart", "mallHomeFragmentOnResumeEnd", "getMallHomeFragmentOnResumeEnd", "mainPageFragmentOnCreateStart", "getMainPageFragmentOnCreateStart", "mainPageFragmentOnCreateEnd", "getMainPageFragmentOnCreateEnd", "mainPageFragmentOnCreateViewStart", "getMainPageFragmentOnCreateViewStart", "mainPageFragmentOnCreateViewEnd", "getMainPageFragmentOnCreateViewEnd", "mainPageFragmentViewCreatedStart", "getMainPageFragmentViewCreatedStart", "mainPageFragmentViewCreatedEnd", "getMainPageFragmentViewCreatedEnd", "mainPageFragmentOnResumeStart", "getMainPageFragmentOnResumeStart", "mainPageFragmentOnResumeEnd", "getMainPageFragmentOnResumeEnd", "ecHybridRecycleViewLayoutStart", "getEcHybridRecycleViewLayoutStart", "ecHybridRecycleViewLayoutEnd", "getEcHybridRecycleViewLayoutEnd", "ecHybridRecycleViewRealDataLayoutStart", "getEcHybridRecycleViewRealDataLayoutStart", "ecHybridRecycleViewRealDataLayoutEnd", "getEcHybridRecycleViewRealDataLayoutEnd", "ecHybridRecycleViewDrawStart", "getEcHybridRecycleViewDrawStart", "ecHybridRecycleViewDrawEnd", "getEcHybridRecycleViewDrawEnd", "ecHybridRecycleViewRealDataDrawStart", "getEcHybridRecycleViewRealDataDrawStart", "ecHybridRecycleViewRealDataDrawEnd", "getEcHybridRecycleViewRealDataDrawEnd", "mallInitTopBarStart", "m", "mallInitTopBarEnd", "getMallInitTopBarEnd", "firstScreenDataMainHandleStart", "getFirstScreenDataMainHandleStart", "firstScreenDataMainHandleEnd", "getFirstScreenDataMainHandleEnd", "prefetchMainSuccessWhenCreate", "t", "mallStartHandleInitData", "getMallStartHandleInitData", "preloadDataEngineStart", "getPreloadDataEngineStart", "preloadDataEngineEnd", "getPreloadDataEngineEnd", "mallPreInitLynxStart", "getMallPreInitLynxStart", "mallPreInitLynxEnd", "getMallPreInitLynxEnd", "mallPostFirstScreenDataRunnableStart", "getMallPostFirstScreenDataRunnableStart", "mallPostFirstScreenDataRunnableEnd", "getMallPostFirstScreenDataRunnableEnd", "optimizeConfigCenterEnd", "getOptimizeConfigCenterEnd", "mallHandlePopupStart", "getMallHandlePopupStart", "mallHandlePopupEnd", "getMallHandlePopupEnd", "waitTTNetInitDuration", "getWaitTTNetInitDuration", "TTNetInitEnd", "getTTNetInitEnd", "prefetchMessageMainQueueIndex", "getPrefetchMessageMainQueueIndex", "tDataFromNetInterceptor", "getTDataFromNetInterceptor", "parseNetworkPerfParamsStatus", "r", "cachedCategoryTabType", "getCachedCategoryTabType", "cachedCategoryTabConvertFlag", "getCachedCategoryTabConvertFlag", "categoryTabType", "getCategoryTabType", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("t_tt_net_init_end")
    private final Long TTNetInitEnd;
    public final Map<String, Object> a;
    public final JSONObject b;
    public final boolean c;

    @SerializedName("cached_category_tab_convert_flag")
    private final Integer cachedCategoryTabConvertFlag;

    @SerializedName("cached_category_tab_type")
    private final String cachedCategoryTabType;

    @SerializedName("cached_data_prepared_status")
    private final Integer cachedDataPreparedStatus;

    @SerializedName("catch_no_bind")
    private final Integer catchNoBind;

    @SerializedName("category_tab_type")
    private final String categoryTabType;

    @SerializedName("client_login_status")
    private final Integer clientLoginStatus;

    @SerializedName("data_reuse_status")
    private final Integer dataReuseStatus;

    @SerializedName("t_dep_plugin_install_end")
    private final Long depPluginInstallEnd;

    @SerializedName("t_dep_plugin_install_start")
    private final Long depPluginInstallStart;

    @SerializedName("check_dep_plugin_status")
    private final Integer depPluginStatus;

    @SerializedName("ec_hybrid_recycle_view_draw_end")
    private final Long ecHybridRecycleViewDrawEnd;

    @SerializedName("ec_hybrid_recycle_view_draw_start")
    private final Long ecHybridRecycleViewDrawStart;

    @SerializedName("ec_hybrid_recycle_view_layout_end")
    private final Long ecHybridRecycleViewLayoutEnd;

    @SerializedName("ec_hybrid_recycle_view_layout_start")
    private final Long ecHybridRecycleViewLayoutStart;

    @SerializedName("ec_hybrid_recycle_view_real_data_draw_end")
    private final Long ecHybridRecycleViewRealDataDrawEnd;

    @SerializedName("ec_hybrid_recycle_view_real_data_draw_start")
    private final Long ecHybridRecycleViewRealDataDrawStart;

    @SerializedName("ec_hybrid_recycle_view_real_data_layout_end")
    private final Long ecHybridRecycleViewRealDataLayoutEnd;

    @SerializedName("ec_hybrid_recycle_view_real_data_layout_start")
    private final Long ecHybridRecycleViewRealDataLayoutStart;

    @SerializedName("check_ec_plugin_status")
    private final Integer ecPluginStatus;

    @SerializedName("t_entrance_fragment_create_view_end")
    private final Long entranceFragmentCreateViewEnd;

    @SerializedName("t_entrance_fragment_create_view_start")
    private final Long entranceFragmentCreateViewStart;

    @SerializedName("error_code")
    private final Integer errCode;

    @SerializedName("error_msg")
    private final String errMsg;

    @SerializedName("first_chunk_name")
    private final String firstChunkName;

    @SerializedName("t_first_chunk_received")
    private final Long firstChunkReceived;

    @SerializedName("t_first_chunk_render_end")
    private final Long firstChunkRenderEnd;

    @SerializedName("t_first_chunk_render_start")
    private final Long firstChunkRenderStart;

    @SerializedName("t_first_screen_data_main_handle_end")
    private final Long firstScreenDataMainHandleEnd;

    @SerializedName("t_first_screen_data_main_handle_start")
    private final Long firstScreenDataMainHandleStart;

    @SerializedName("first_screen_data_prepared_status")
    private final Integer firstScreenDataPreparedStatus;

    @SerializedName("first_screen_header_card_type")
    private final Integer firstScreenHeaderCardType;

    @SerializedName("t_fragment_create_view_end")
    private final Long fragmentCreateViewEnd;

    @SerializedName("t_fragment_create_view_start")
    private final Long fragmentCreateViewStart;

    @SerializedName("t_check_gecko_end")
    private final Long geckoEnd;

    @SerializedName("t_check_gecko_start")
    private final Long geckoStart;

    @SerializedName("check_gecko_status")
    private final Integer geckoStatus;

    @SerializedName("gyl_num_of_first_screen")
    private final Integer gylNumOfFirstScreen;

    @SerializedName("half_page_open")
    private final Integer halfPageOpen;

    @SerializedName("t_handle_prefetched_data")
    private final Long handlePrefetchedDataTime;

    @SerializedName("t_immerse_mall_bind_real_data_reason")
    private final String immerseBindRealDataReason;

    @SerializedName("t_immerse_mall_bind_real_data_time")
    private final Long immerseBindRealDataTime;

    @SerializedName("t_init_lynx_end")
    private final Long initLynxEnd;

    @SerializedName("t_init_lynx_start")
    private final Long initLynxStart;

    @SerializedName("t_leave_time")
    private final Long leaveTime;

    @SerializedName("leave_type")
    private final Integer leaveType;

    @SerializedName("t_list_first_screen")
    private final Long listFirstScreen;

    @SerializedName("t_list_load_end")
    private final Long listLoadEnd;

    @SerializedName("t_list_load_start")
    private final Long listLoadStart;

    @SerializedName("t_load_bundle_end")
    private final Long loadBundleEnd;

    @SerializedName("t_load_bundle_start")
    private final Long loadBundleStart;

    @SerializedName("fetch_bundle_config_way")
    private final String loadBundleWay;

    @SerializedName("main_page_fragment_on_create_end")
    private final Long mainPageFragmentOnCreateEnd;

    @SerializedName("main_page_fragment_on_create_start")
    private final Long mainPageFragmentOnCreateStart;

    @SerializedName("main_page_fragment_on_create_view_end")
    private final Long mainPageFragmentOnCreateViewEnd;

    @SerializedName("main_page_fragment_on_create_view_start")
    private final Long mainPageFragmentOnCreateViewStart;

    @SerializedName("main_page_fragment_on_resume_end")
    private final Long mainPageFragmentOnResumeEnd;

    @SerializedName("main_page_fragment_on_resume_start")
    private final Long mainPageFragmentOnResumeStart;

    @SerializedName("main_page_fragment_view_created_end")
    private final Long mainPageFragmentViewCreatedEnd;

    @SerializedName("main_page_fragment_view_created_start")
    private final Long mainPageFragmentViewCreatedStart;

    @SerializedName("t_mall_category_tab_fragment_on_create_end")
    private final Long mallCategoryTabFragmentOnCreateEnd;

    @SerializedName("t_mall_category_tab_fragment_on_create_start")
    private final Long mallCategoryTabFragmentOnCreateStart;

    @SerializedName("t_mall_category_tab_fragment_on_create_view_end")
    private final Long mallCategoryTabFragmentOnCreateViewEnd;

    @SerializedName("t_mall_category_tab_fragment_on_create_view_start")
    private final Long mallCategoryTabFragmentOnCreateViewStart;

    @SerializedName("t_mall_category_tab_fragment_on_resume_end")
    private final Long mallCategoryTabFragmentOnResumeEnd;

    @SerializedName("t_mall_category_tab_fragment_on_resume_start")
    private final Long mallCategoryTabFragmentOnResumeStart;

    @SerializedName("t_mall_category_tab_fragment_view_created_end")
    private final Long mallCategoryTabFragmentViewCreatedEnd;

    @SerializedName("t_mall_category_tab_fragment_view_created_start")
    private final Long mallCategoryTabFragmentViewCreatedStart;

    @SerializedName("t_handle_pop_up_end")
    private final Long mallHandlePopupEnd;

    @SerializedName("t_handle_pop_up_start")
    private final Long mallHandlePopupStart;

    @SerializedName("t_mall_home_fragment_on_create_end")
    private final Long mallHomeFragmentOnCreateEnd;

    @SerializedName("t_mall_home_fragment_on_create_start")
    private final Long mallHomeFragmentOnCreateStart;

    @SerializedName("t_mall_home_fragment_on_create_view_end")
    private final Long mallHomeFragmentOnCreateViewEnd;

    @SerializedName("t_mall_home_fragment_on_create_view_start")
    private final Long mallHomeFragmentOnCreateViewStart;

    @SerializedName("t_mall_home_fragment_on_resume_end")
    private final Long mallHomeFragmentOnResumeEnd;

    @SerializedName("t_mall_home_fragment_on_resume_start")
    private final Long mallHomeFragmentOnResumeStart;

    @SerializedName("t_mall_home_fragment_view_created_end")
    private final Long mallHomeFragmentViewCreatedEnd;

    @SerializedName("t_mall_home_fragment_view_created_start")
    private final Long mallHomeFragmentViewCreatedStart;

    @SerializedName("t_init_top_bar_end")
    private final Long mallInitTopBarEnd;

    @SerializedName("t_init_top_bar_start")
    private final Long mallInitTopBarStart;

    @SerializedName("t_mall_post_first_screen_data_runnable_end")
    private final Long mallPostFirstScreenDataRunnableEnd;

    @SerializedName("t_mall_post_first_screen_data_runnable_start")
    private final Long mallPostFirstScreenDataRunnableStart;

    @SerializedName("t_mall_pre_init_lynx_end")
    private final Long mallPreInitLynxEnd;

    @SerializedName("t_mall_pre_init_lynx_start")
    private final Long mallPreInitLynxStart;

    @SerializedName("t_mall_start_handle_init_data")
    private final Long mallStartHandleInitData;

    @SerializedName("t_mall_frame_time")
    private final Long multiMallFrameTime;

    @SerializedName("t_net_end")
    private final Long netEnd;

    @SerializedName("t_net_end_client")
    private final Long netEndClient;

    @SerializedName("t_net_start")
    private final Long netStart;

    @SerializedName("t_open_time")
    private final Long openTime;

    @SerializedName("t_optimize_config_center_end")
    private final Long optimizeConfigCenterEnd;

    @SerializedName("parse_network_perf_params_status")
    private final Integer parseNetworkPerfParamsStatus;

    @SerializedName("popup_page_straight_out")
    private final Boolean popupPageStraightOut;

    @SerializedName("t_prefetch_end")
    private final Long prefetchEnd;

    @SerializedName("t_prefetch_main_success_when_create")
    private final Integer prefetchMainSuccessWhenCreate;

    @SerializedName("prefetch_message_main_queue_index")
    private final Integer prefetchMessageMainQueueIndex;

    @SerializedName("t_prefetch_start")
    private final Long prefetchStart;

    @SerializedName("t_preload_config_end")
    private final Long preloadConfigEnd;

    @SerializedName("preload_config_result")
    private final String preloadConfigResult;

    @SerializedName("t_preload_config_start")
    private final Long preloadConfigStart;

    @SerializedName("t_preload_data_engine_end")
    private final Long preloadDataEngineEnd;

    @SerializedName("t_preload_data_engine_start")
    private final Long preloadDataEngineStart;

    @SerializedName("t_preload_end")
    private final Long preloadEndTimestamp;

    @SerializedName("t_preload_start")
    private final Long preloadStartTimestamp;

    @SerializedName("t_rebuild_scene")
    private final Integer rebuildScene;

    @SerializedName("retry_status")
    private final Integer retryStatus;

    @SerializedName("second_chunk_name")
    private final String secondChunkName;

    @SerializedName("t_second_chunk_received")
    private final Long secondChunkReceived;

    @SerializedName("t_second_chunk_render_end")
    private final Long secondChunkRenderEnd;

    @SerializedName("t_second_chunk_render_start")
    private final Long secondChunkRenderStart;

    @SerializedName("server_login_status")
    private final Integer serverLoginStatus;

    @SerializedName("skip_render_with_full_data")
    private final Boolean skipRenderWithFullData;

    @SerializedName("status")
    private final Integer status;

    @SerializedName("straight_out_flag")
    private final int straightOutFlag;

    @SerializedName("straight_out_header_card_type")
    private final Integer straightOutHeaderCardType;

    @SerializedName("t_data_from_net_interceptor")
    private final Integer tDataFromNetInterceptor;

    @SerializedName("t_dialog_first_screen_end")
    private final Long tDialogFirstScreenEnd;

    @SerializedName("t_dialog_first_screen_start")
    private final Long tDialogFirstScreenStart;

    @SerializedName("t_dialog_preprocess_end_time")
    private final Long tDialogPreprocessEndTime;

    @SerializedName("t_dialog_preprocess_start_time")
    private final Long tDialogPreprocessStartTime;

    @SerializedName("t_first_screen_end")
    private final Long tFirstScreenEnd;

    @SerializedName("t_first_screen_straight_out_end")
    private final Long tFirstScreenStraightOutEnd;

    @SerializedName("t_first_screen_straight_out_start")
    private final Long tFirstScreenStraightOutStart;

    @SerializedName("t_view_did_setup")
    private final Long tNAContainerReady;

    @SerializedName("t_prepare_cached_data_end")
    private final Long tPrepareCachedDataEnd;

    @SerializedName("t_prepare_cached_data_start")
    private final Long tPrepareCachedDataStart;

    @SerializedName("t_prepare_first_screen_data_end")
    private final Long tPrepareFirstScreenDataEnd;

    @SerializedName("t_prepare_first_screen_data_start")
    private final Long tPrepareFirstScreenDataStart;

    @SerializedName("t_straight_out_create_view_time")
    private final Long tStraightOutCreateViewTime;

    @SerializedName("t_straight_out_load_time")
    private final Long tStraightOutLoadTime;

    @SerializedName("t_tab_click_time")
    private final Long tabClickTime;

    @SerializedName("t_wait_tt_net_init_duration")
    private final Long waitTTNetInitDuration;

    public a(Integer r3, Integer r4, Long r5, Long r6, Long r7, Long r8, String r9, Long r10, Long r11, Long r12, Long r13, Long r14, Boolean r15, Long r16, Long r17, Long r18, Long r19, Long r20, Long r21, String r22, Long r23, Long r24, Long r25, Integer r26, Long r27, Long r28, Long r29, Long r30, Integer r31, Integer r32, Integer r33, String r34, Integer r35, Integer r36, Long r37, Long r38, Long r39, Integer r40, Long r41, Long r42, Integer r43, Integer r44, Long r45, Long r46, Integer r47, Integer r48, Long r49, Long r50, Integer r51, Integer r52, int r53, Long r54, Long r55, Long r56, Long r57, Long r58, Long r59, Long r60, Long r61, Long r62, String r63, Long r64, Long r65, Long r66, String r67, Long r68, Long r69, Long r70, Boolean r71, Long r72, Long r73, Integer r74, Long r75, String r76, Integer r77, Integer r78, Long r79, Long r80, Long r81, Long r82, Long r84, Long r85, Long r86, Long r87, Long r88, Long r89, Long r810, Long r90, Long r91, Long r92, Long r94, Long r95, Long r96, Long r97, Long r98, Long r99, Long r910, Long r100, Long r101, Long r102, Long r103, Long r104, Long r105, Long r106, Long r107, Long r108, Long r109, Long r110, Long r111, Long r112, Long r113, Long r114, Long r115, Integer r116, Long r117, Long r118, Long r119, Long r120, Long r121, Long r122, Long r123, Long r124, Long r125, Long r126, Long r127, Long r128, Integer r129, Integer r130, Integer r131, String r132, Integer r133, String r134, Map<String, ? extends Object> r135, JSONObject r136, boolean r137) {
        this.serverLoginStatus = r3;
        this.clientLoginStatus = r4;
        this.preloadStartTimestamp = r5;
        this.preloadEndTimestamp = r6;
        this.preloadConfigStart = r7;
        this.preloadConfigEnd = r8;
        this.preloadConfigResult = r9;
        this.prefetchStart = r10;
        this.prefetchEnd = r11;
        this.openTime = r12;
        this.entranceFragmentCreateViewStart = r13;
        this.entranceFragmentCreateViewEnd = r14;
        this.popupPageStraightOut = r15;
        this.initLynxStart = r16;
        this.initLynxEnd = r17;
        this.fragmentCreateViewStart = r18;
        this.fragmentCreateViewEnd = r19;
        this.loadBundleStart = r20;
        this.loadBundleEnd = r21;
        this.loadBundleWay = r22;
        this.netStart = r23;
        this.netEnd = r24;
        this.netEndClient = r25;
        this.catchNoBind = r26;
        this.handlePrefetchedDataTime = r27;
        this.listLoadStart = r28;
        this.listFirstScreen = r29;
        this.listLoadEnd = r30;
        this.halfPageOpen = r31;
        this.status = r32;
        this.errCode = r33;
        this.errMsg = r34;
        this.leaveType = r35;
        this.retryStatus = r36;
        this.leaveTime = r37;
        this.geckoStart = r38;
        this.geckoEnd = r39;
        this.geckoStatus = r40;
        this.depPluginInstallStart = r41;
        this.depPluginInstallEnd = r42;
        this.depPluginStatus = r43;
        this.ecPluginStatus = r44;
        this.tPrepareCachedDataStart = r45;
        this.tPrepareCachedDataEnd = r46;
        this.cachedDataPreparedStatus = r47;
        this.dataReuseStatus = r48;
        this.tPrepareFirstScreenDataStart = r49;
        this.tPrepareFirstScreenDataEnd = r50;
        this.firstScreenDataPreparedStatus = r51;
        this.rebuildScene = r52;
        this.straightOutFlag = r53;
        this.tFirstScreenStraightOutStart = r54;
        this.tFirstScreenStraightOutEnd = r55;
        this.tNAContainerReady = r56;
        this.tStraightOutLoadTime = r57;
        this.tStraightOutCreateViewTime = r58;
        this.tDialogFirstScreenStart = r59;
        this.tDialogFirstScreenEnd = r60;
        this.tDialogPreprocessStartTime = r61;
        this.tDialogPreprocessEndTime = r62;
        this.firstChunkName = r63;
        this.firstChunkReceived = r64;
        this.firstChunkRenderStart = r65;
        this.firstChunkRenderEnd = r66;
        this.secondChunkName = r67;
        this.secondChunkReceived = r68;
        this.secondChunkRenderStart = r69;
        this.secondChunkRenderEnd = r70;
        this.skipRenderWithFullData = r71;
        this.tabClickTime = r72;
        this.multiMallFrameTime = r73;
        this.gylNumOfFirstScreen = r74;
        this.immerseBindRealDataTime = r75;
        this.immerseBindRealDataReason = r76;
        this.straightOutHeaderCardType = r77;
        this.firstScreenHeaderCardType = r78;
        this.tFirstScreenEnd = r79;
        this.mallCategoryTabFragmentOnCreateStart = r80;
        this.mallCategoryTabFragmentOnCreateEnd = r81;
        this.mallCategoryTabFragmentOnCreateViewStart = r82;
        this.mallCategoryTabFragmentOnCreateViewEnd = r84;
        this.mallCategoryTabFragmentViewCreatedStart = r85;
        this.mallCategoryTabFragmentViewCreatedEnd = r86;
        this.mallCategoryTabFragmentOnResumeStart = r87;
        this.mallCategoryTabFragmentOnResumeEnd = r88;
        this.mallHomeFragmentOnCreateStart = r89;
        this.mallHomeFragmentOnCreateEnd = r810;
        this.mallHomeFragmentOnCreateViewStart = r90;
        this.mallHomeFragmentOnCreateViewEnd = r91;
        this.mallHomeFragmentViewCreatedStart = r92;
        this.mallHomeFragmentViewCreatedEnd = r94;
        this.mallHomeFragmentOnResumeStart = r95;
        this.mallHomeFragmentOnResumeEnd = r96;
        this.mainPageFragmentOnCreateStart = r97;
        this.mainPageFragmentOnCreateEnd = r98;
        this.mainPageFragmentOnCreateViewStart = r99;
        this.mainPageFragmentOnCreateViewEnd = r910;
        this.mainPageFragmentViewCreatedStart = r100;
        this.mainPageFragmentViewCreatedEnd = r101;
        this.mainPageFragmentOnResumeStart = r102;
        this.mainPageFragmentOnResumeEnd = r103;
        this.ecHybridRecycleViewLayoutStart = r104;
        this.ecHybridRecycleViewLayoutEnd = r105;
        this.ecHybridRecycleViewRealDataLayoutStart = r106;
        this.ecHybridRecycleViewRealDataLayoutEnd = r107;
        this.ecHybridRecycleViewDrawStart = r108;
        this.ecHybridRecycleViewDrawEnd = r109;
        this.ecHybridRecycleViewRealDataDrawStart = r110;
        this.ecHybridRecycleViewRealDataDrawEnd = r111;
        this.mallInitTopBarStart = r112;
        this.mallInitTopBarEnd = r113;
        this.firstScreenDataMainHandleStart = r114;
        this.firstScreenDataMainHandleEnd = r115;
        this.prefetchMainSuccessWhenCreate = r116;
        this.mallStartHandleInitData = r117;
        this.preloadDataEngineStart = r118;
        this.preloadDataEngineEnd = r119;
        this.mallPreInitLynxStart = r120;
        this.mallPreInitLynxEnd = r121;
        this.mallPostFirstScreenDataRunnableStart = r122;
        this.mallPostFirstScreenDataRunnableEnd = r123;
        this.optimizeConfigCenterEnd = r124;
        this.mallHandlePopupStart = r125;
        this.mallHandlePopupEnd = r126;
        this.waitTTNetInitDuration = r127;
        this.TTNetInitEnd = r128;
        this.prefetchMessageMainQueueIndex = r129;
        this.tDataFromNetInterceptor = r130;
        this.parseNetworkPerfParamsStatus = r131;
        this.cachedCategoryTabType = r132;
        this.cachedCategoryTabConvertFlag = r133;
        this.categoryTabType = r134;
        this.a = r135;
        this.b = r136;
        this.c = r137;
    }

    public a() {
        this(null, -1);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L276;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.serverLoginStatus, r4.serverLoginStatus) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.clientLoginStatus, r4.clientLoginStatus) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.preloadStartTimestamp, r4.preloadStartTimestamp) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.preloadEndTimestamp, r4.preloadEndTimestamp) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.preloadConfigStart, r4.preloadConfigStart) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.preloadConfigEnd, r4.preloadConfigEnd) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.preloadConfigResult, r4.preloadConfigResult) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.prefetchStart, r4.prefetchStart) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.prefetchEnd, r4.prefetchEnd) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.openTime, r4.openTime) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.entranceFragmentCreateViewStart, r4.entranceFragmentCreateViewStart) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.entranceFragmentCreateViewEnd, r4.entranceFragmentCreateViewEnd) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.popupPageStraightOut, r4.popupPageStraightOut) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.initLynxStart, r4.initLynxStart) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.initLynxEnd, r4.initLynxEnd) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.fragmentCreateViewStart, r4.fragmentCreateViewStart) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.fragmentCreateViewEnd, r4.fragmentCreateViewEnd) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.loadBundleStart, r4.loadBundleStart) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.loadBundleEnd, r4.loadBundleEnd) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.loadBundleWay, r4.loadBundleWay) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.netStart, r4.netStart) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.netEnd, r4.netEnd) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.netEndClient, r4.netEndClient) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.catchNoBind, r4.catchNoBind) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.handlePrefetchedDataTime, r4.handlePrefetchedDataTime) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.listLoadStart, r4.listLoadStart) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.listFirstScreen, r4.listFirstScreen) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.listLoadEnd, r4.listLoadEnd) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.halfPageOpen, r4.halfPageOpen) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.status, r4.status) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.errCode, r4.errCode) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.errMsg, r4.errMsg) == true) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(this.leaveType, r4.leaveType) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.retryStatus, r4.retryStatus) == true) goto L74;
        return false;
    L74:
        if (Intrinsics.areEqual(this.leaveTime, r4.leaveTime) == true) goto L76;
        return false;
    L76:
        if (Intrinsics.areEqual(this.geckoStart, r4.geckoStart) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.geckoEnd, r4.geckoEnd) == true) goto L80;
        return false;
    L80:
        if (Intrinsics.areEqual(this.geckoStatus, r4.geckoStatus) == true) goto L82;
        return false;
    L82:
        if (Intrinsics.areEqual(this.depPluginInstallStart, r4.depPluginInstallStart) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.depPluginInstallEnd, r4.depPluginInstallEnd) == true) goto L86;
        return false;
    L86:
        if (Intrinsics.areEqual(this.depPluginStatus, r4.depPluginStatus) == true) goto L88;
        return false;
    L88:
        if (Intrinsics.areEqual(this.ecPluginStatus, r4.ecPluginStatus) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.tPrepareCachedDataStart, r4.tPrepareCachedDataStart) == true) goto L92;
        return false;
    L92:
        if (Intrinsics.areEqual(this.tPrepareCachedDataEnd, r4.tPrepareCachedDataEnd) == true) goto L94;
        return false;
    L94:
        if (Intrinsics.areEqual(this.cachedDataPreparedStatus, r4.cachedDataPreparedStatus) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.dataReuseStatus, r4.dataReuseStatus) == true) goto L98;
        return false;
    L98:
        if (Intrinsics.areEqual(this.tPrepareFirstScreenDataStart, r4.tPrepareFirstScreenDataStart) == true) goto L100;
        return false;
    L100:
        if (Intrinsics.areEqual(this.tPrepareFirstScreenDataEnd, r4.tPrepareFirstScreenDataEnd) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.firstScreenDataPreparedStatus, r4.firstScreenDataPreparedStatus) == true) goto L104;
        return false;
    L104:
        if (Intrinsics.areEqual(this.rebuildScene, r4.rebuildScene) == true) goto L106;
        return false;
    L106:
        if (this.straightOutFlag == r4.straightOutFlag) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.tFirstScreenStraightOutStart, r4.tFirstScreenStraightOutStart) == true) goto L110;
        return false;
    L110:
        if (Intrinsics.areEqual(this.tFirstScreenStraightOutEnd, r4.tFirstScreenStraightOutEnd) == true) goto L112;
        return false;
    L112:
        if (Intrinsics.areEqual(this.tNAContainerReady, r4.tNAContainerReady) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.tStraightOutLoadTime, r4.tStraightOutLoadTime) == true) goto L116;
        return false;
    L116:
        if (Intrinsics.areEqual(this.tStraightOutCreateViewTime, r4.tStraightOutCreateViewTime) == true) goto L118;
        return false;
    L118:
        if (Intrinsics.areEqual(this.tDialogFirstScreenStart, r4.tDialogFirstScreenStart) == true) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.tDialogFirstScreenEnd, r4.tDialogFirstScreenEnd) == true) goto L122;
        return false;
    L122:
        if (Intrinsics.areEqual(this.tDialogPreprocessStartTime, r4.tDialogPreprocessStartTime) == true) goto L124;
        return false;
    L124:
        if (Intrinsics.areEqual(this.tDialogPreprocessEndTime, r4.tDialogPreprocessEndTime) == true) goto L126;
        return false;
    L126:
        if (Intrinsics.areEqual(this.firstChunkName, r4.firstChunkName) == true) goto L128;
        return false;
    L128:
        if (Intrinsics.areEqual(this.firstChunkReceived, r4.firstChunkReceived) == true) goto L130;
        return false;
    L130:
        if (Intrinsics.areEqual(this.firstChunkRenderStart, r4.firstChunkRenderStart) == true) goto L132;
        return false;
    L132:
        if (Intrinsics.areEqual(this.firstChunkRenderEnd, r4.firstChunkRenderEnd) == true) goto L134;
        return false;
    L134:
        if (Intrinsics.areEqual(this.secondChunkName, r4.secondChunkName) == true) goto L136;
        return false;
    L136:
        if (Intrinsics.areEqual(this.secondChunkReceived, r4.secondChunkReceived) == true) goto L138;
        return false;
    L138:
        if (Intrinsics.areEqual(this.secondChunkRenderStart, r4.secondChunkRenderStart) == true) goto L140;
        return false;
    L140:
        if (Intrinsics.areEqual(this.secondChunkRenderEnd, r4.secondChunkRenderEnd) == true) goto L142;
        return false;
    L142:
        if (Intrinsics.areEqual(this.skipRenderWithFullData, r4.skipRenderWithFullData) == true) goto L144;
        return false;
    L144:
        if (Intrinsics.areEqual(this.tabClickTime, r4.tabClickTime) == true) goto L146;
        return false;
    L146:
        if (Intrinsics.areEqual(this.multiMallFrameTime, r4.multiMallFrameTime) == true) goto L148;
        return false;
    L148:
        if (Intrinsics.areEqual(this.gylNumOfFirstScreen, r4.gylNumOfFirstScreen) == true) goto L150;
        return false;
    L150:
        if (Intrinsics.areEqual(this.immerseBindRealDataTime, r4.immerseBindRealDataTime) == true) goto L152;
        return false;
    L152:
        if (Intrinsics.areEqual(this.immerseBindRealDataReason, r4.immerseBindRealDataReason) == true) goto L154;
        return false;
    L154:
        if (Intrinsics.areEqual(this.straightOutHeaderCardType, r4.straightOutHeaderCardType) == true) goto L156;
        return false;
    L156:
        if (Intrinsics.areEqual(this.firstScreenHeaderCardType, r4.firstScreenHeaderCardType) == true) goto L158;
        return false;
    L158:
        if (Intrinsics.areEqual(this.tFirstScreenEnd, r4.tFirstScreenEnd) == true) goto L160;
        return false;
    L160:
        if (Intrinsics.areEqual(this.mallCategoryTabFragmentOnCreateStart, r4.mallCategoryTabFragmentOnCreateStart) == true) goto L162;
        return false;
    L162:
        if (Intrinsics.areEqual(this.mallCategoryTabFragmentOnCreateEnd, r4.mallCategoryTabFragmentOnCreateEnd) == true) goto L164;
        return false;
    L164:
        if (Intrinsics.areEqual(this.mallCategoryTabFragmentOnCreateViewStart, r4.mallCategoryTabFragmentOnCreateViewStart) == true) goto L166;
        return false;
    L166:
        if (Intrinsics.areEqual(this.mallCategoryTabFragmentOnCreateViewEnd, r4.mallCategoryTabFragmentOnCreateViewEnd) == true) goto L168;
        return false;
    L168:
        if (Intrinsics.areEqual(this.mallCategoryTabFragmentViewCreatedStart, r4.mallCategoryTabFragmentViewCreatedStart) == true) goto L170;
        return false;
    L170:
        if (Intrinsics.areEqual(this.mallCategoryTabFragmentViewCreatedEnd, r4.mallCategoryTabFragmentViewCreatedEnd) == true) goto L172;
        return false;
    L172:
        if (Intrinsics.areEqual(this.mallCategoryTabFragmentOnResumeStart, r4.mallCategoryTabFragmentOnResumeStart) == true) goto L174;
        return false;
    L174:
        if (Intrinsics.areEqual(this.mallCategoryTabFragmentOnResumeEnd, r4.mallCategoryTabFragmentOnResumeEnd) == true) goto L176;
        return false;
    L176:
        if (Intrinsics.areEqual(this.mallHomeFragmentOnCreateStart, r4.mallHomeFragmentOnCreateStart) == true) goto L178;
        return false;
    L178:
        if (Intrinsics.areEqual(this.mallHomeFragmentOnCreateEnd, r4.mallHomeFragmentOnCreateEnd) == true) goto L180;
        return false;
    L180:
        if (Intrinsics.areEqual(this.mallHomeFragmentOnCreateViewStart, r4.mallHomeFragmentOnCreateViewStart) == true) goto L182;
        return false;
    L182:
        if (Intrinsics.areEqual(this.mallHomeFragmentOnCreateViewEnd, r4.mallHomeFragmentOnCreateViewEnd) == true) goto L184;
        return false;
    L184:
        if (Intrinsics.areEqual(this.mallHomeFragmentViewCreatedStart, r4.mallHomeFragmentViewCreatedStart) == true) goto L186;
        return false;
    L186:
        if (Intrinsics.areEqual(this.mallHomeFragmentViewCreatedEnd, r4.mallHomeFragmentViewCreatedEnd) == true) goto L188;
        return false;
    L188:
        if (Intrinsics.areEqual(this.mallHomeFragmentOnResumeStart, r4.mallHomeFragmentOnResumeStart) == true) goto L190;
        return false;
    L190:
        if (Intrinsics.areEqual(this.mallHomeFragmentOnResumeEnd, r4.mallHomeFragmentOnResumeEnd) == true) goto L192;
        return false;
    L192:
        if (Intrinsics.areEqual(this.mainPageFragmentOnCreateStart, r4.mainPageFragmentOnCreateStart) == true) goto L194;
        return false;
    L194:
        if (Intrinsics.areEqual(this.mainPageFragmentOnCreateEnd, r4.mainPageFragmentOnCreateEnd) == true) goto L196;
        return false;
    L196:
        if (Intrinsics.areEqual(this.mainPageFragmentOnCreateViewStart, r4.mainPageFragmentOnCreateViewStart) == true) goto L198;
        return false;
    L198:
        if (Intrinsics.areEqual(this.mainPageFragmentOnCreateViewEnd, r4.mainPageFragmentOnCreateViewEnd) == true) goto L200;
        return false;
    L200:
        if (Intrinsics.areEqual(this.mainPageFragmentViewCreatedStart, r4.mainPageFragmentViewCreatedStart) == true) goto L202;
        return false;
    L202:
        if (Intrinsics.areEqual(this.mainPageFragmentViewCreatedEnd, r4.mainPageFragmentViewCreatedEnd) == true) goto L204;
        return false;
    L204:
        if (Intrinsics.areEqual(this.mainPageFragmentOnResumeStart, r4.mainPageFragmentOnResumeStart) == true) goto L206;
        return false;
    L206:
        if (Intrinsics.areEqual(this.mainPageFragmentOnResumeEnd, r4.mainPageFragmentOnResumeEnd) == true) goto L208;
        return false;
    L208:
        if (Intrinsics.areEqual(this.ecHybridRecycleViewLayoutStart, r4.ecHybridRecycleViewLayoutStart) == true) goto L210;
        return false;
    L210:
        if (Intrinsics.areEqual(this.ecHybridRecycleViewLayoutEnd, r4.ecHybridRecycleViewLayoutEnd) == true) goto L212;
        return false;
    L212:
        if (Intrinsics.areEqual(this.ecHybridRecycleViewRealDataLayoutStart, r4.ecHybridRecycleViewRealDataLayoutStart) == true) goto L214;
        return false;
    L214:
        if (Intrinsics.areEqual(this.ecHybridRecycleViewRealDataLayoutEnd, r4.ecHybridRecycleViewRealDataLayoutEnd) == true) goto L216;
        return false;
    L216:
        if (Intrinsics.areEqual(this.ecHybridRecycleViewDrawStart, r4.ecHybridRecycleViewDrawStart) == true) goto L218;
        return false;
    L218:
        if (Intrinsics.areEqual(this.ecHybridRecycleViewDrawEnd, r4.ecHybridRecycleViewDrawEnd) == true) goto L220;
        return false;
    L220:
        if (Intrinsics.areEqual(this.ecHybridRecycleViewRealDataDrawStart, r4.ecHybridRecycleViewRealDataDrawStart) == true) goto L222;
        return false;
    L222:
        if (Intrinsics.areEqual(this.ecHybridRecycleViewRealDataDrawEnd, r4.ecHybridRecycleViewRealDataDrawEnd) == true) goto L224;
        return false;
    L224:
        if (Intrinsics.areEqual(this.mallInitTopBarStart, r4.mallInitTopBarStart) == true) goto L226;
        return false;
    L226:
        if (Intrinsics.areEqual(this.mallInitTopBarEnd, r4.mallInitTopBarEnd) == true) goto L228;
        return false;
    L228:
        if (Intrinsics.areEqual(this.firstScreenDataMainHandleStart, r4.firstScreenDataMainHandleStart) == true) goto L230;
        return false;
    L230:
        if (Intrinsics.areEqual(this.firstScreenDataMainHandleEnd, r4.firstScreenDataMainHandleEnd) == true) goto L232;
        return false;
    L232:
        if (Intrinsics.areEqual(this.prefetchMainSuccessWhenCreate, r4.prefetchMainSuccessWhenCreate) == true) goto L234;
        return false;
    L234:
        if (Intrinsics.areEqual(this.mallStartHandleInitData, r4.mallStartHandleInitData) == true) goto L236;
        return false;
    L236:
        if (Intrinsics.areEqual(this.preloadDataEngineStart, r4.preloadDataEngineStart) == true) goto L238;
        return false;
    L238:
        if (Intrinsics.areEqual(this.preloadDataEngineEnd, r4.preloadDataEngineEnd) == true) goto L240;
        return false;
    L240:
        if (Intrinsics.areEqual(this.mallPreInitLynxStart, r4.mallPreInitLynxStart) == true) goto L242;
        return false;
    L242:
        if (Intrinsics.areEqual(this.mallPreInitLynxEnd, r4.mallPreInitLynxEnd) == true) goto L244;
        return false;
    L244:
        if (Intrinsics.areEqual(this.mallPostFirstScreenDataRunnableStart, r4.mallPostFirstScreenDataRunnableStart) == true) goto L246;
        return false;
    L246:
        if (Intrinsics.areEqual(this.mallPostFirstScreenDataRunnableEnd, r4.mallPostFirstScreenDataRunnableEnd) == true) goto L248;
        return false;
    L248:
        if (Intrinsics.areEqual(this.optimizeConfigCenterEnd, r4.optimizeConfigCenterEnd) == true) goto L250;
        return false;
    L250:
        if (Intrinsics.areEqual(this.mallHandlePopupStart, r4.mallHandlePopupStart) == true) goto L252;
        return false;
    L252:
        if (Intrinsics.areEqual(this.mallHandlePopupEnd, r4.mallHandlePopupEnd) == true) goto L254;
        return false;
    L254:
        if (Intrinsics.areEqual(this.waitTTNetInitDuration, r4.waitTTNetInitDuration) == true) goto L256;
        return false;
    L256:
        if (Intrinsics.areEqual(this.TTNetInitEnd, r4.TTNetInitEnd) == true) goto L258;
        return false;
    L258:
        if (Intrinsics.areEqual(this.prefetchMessageMainQueueIndex, r4.prefetchMessageMainQueueIndex) == true) goto L260;
        return false;
    L260:
        if (Intrinsics.areEqual(this.tDataFromNetInterceptor, r4.tDataFromNetInterceptor) == true) goto L262;
        return false;
    L262:
        if (Intrinsics.areEqual(this.parseNetworkPerfParamsStatus, r4.parseNetworkPerfParamsStatus) == true) goto L264;
        return false;
    L264:
        if (Intrinsics.areEqual(this.cachedCategoryTabType, r4.cachedCategoryTabType) == true) goto L266;
        return false;
    L266:
        if (Intrinsics.areEqual(this.cachedCategoryTabConvertFlag, r4.cachedCategoryTabConvertFlag) == true) goto L268;
        return false;
    L268:
        if (Intrinsics.areEqual(this.categoryTabType, r4.categoryTabType) == true) goto L270;
        return false;
    L270:
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L272;
        return false;
    L272:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L274;
        return false;
    L274:
        if (this.c == r4.c) goto L415;
        return false;
    L415:
        return true;
    L276:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v270, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        Integer r0 = this.serverLoginStatus;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.clientLoginStatus;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.preloadStartTimestamp;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.preloadEndTimestamp;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.preloadConfigStart;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Long r16 = this.preloadConfigEnd;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.preloadConfigResult;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Long r22 = this.prefetchStart;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        Long r25 = this.prefetchEnd;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        Long r28 = this.openTime;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        Long r31 = this.entranceFragmentCreateViewStart;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        Long r34 = this.entranceFragmentCreateViewEnd;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        Boolean r37 = this.popupPageStraightOut;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        Long r40 = this.initLynxStart;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        Long r43 = this.initLynxEnd;
        if (r43 == null) goto L61;
        int r44 = r43.hashCode();
    L62:
        int r45 = (r42 + r44) * 31;
        Long r46 = this.fragmentCreateViewStart;
        if (r46 == null) goto L65;
        int r47 = r46.hashCode();
    L66:
        int r48 = (r45 + r47) * 31;
        Long r49 = this.fragmentCreateViewEnd;
        if (r49 == null) goto L69;
        int r50 = r49.hashCode();
    L70:
        int r51 = (r48 + r50) * 31;
        Long r52 = this.loadBundleStart;
        if (r52 == null) goto L73;
        int r53 = r52.hashCode();
    L74:
        int r54 = (r51 + r53) * 31;
        Long r55 = this.loadBundleEnd;
        if (r55 == null) goto L77;
        int r56 = r55.hashCode();
    L78:
        int r57 = (r54 + r56) * 31;
        String r58 = this.loadBundleWay;
        if (r58 == null) goto L81;
        int r59 = r58.hashCode();
    L82:
        int r60 = (r57 + r59) * 31;
        Long r61 = this.netStart;
        if (r61 == null) goto L85;
        int r62 = r61.hashCode();
    L86:
        int r63 = (r60 + r62) * 31;
        Long r64 = this.netEnd;
        if (r64 == null) goto L89;
        int r65 = r64.hashCode();
    L90:
        int r66 = (r63 + r65) * 31;
        Long r67 = this.netEndClient;
        if (r67 == null) goto L93;
        int r68 = r67.hashCode();
    L94:
        int r69 = (r66 + r68) * 31;
        Integer r70 = this.catchNoBind;
        if (r70 == null) goto L97;
        int r71 = r70.hashCode();
    L98:
        int r72 = (r69 + r71) * 31;
        Long r73 = this.handlePrefetchedDataTime;
        if (r73 == null) goto L101;
        int r74 = r73.hashCode();
    L102:
        int r75 = (r72 + r74) * 31;
        Long r76 = this.listLoadStart;
        if (r76 == null) goto L105;
        int r77 = r76.hashCode();
    L106:
        int r78 = (r75 + r77) * 31;
        Long r79 = this.listFirstScreen;
        if (r79 == null) goto L109;
        int r80 = r79.hashCode();
    L110:
        int r81 = (r78 + r80) * 31;
        Long r82 = this.listLoadEnd;
        if (r82 == null) goto L113;
        int r84 = r82.hashCode();
    L114:
        int r85 = (r81 + r84) * 31;
        Integer r86 = this.halfPageOpen;
        if (r86 == null) goto L117;
        int r87 = r86.hashCode();
    L118:
        int r88 = (r85 + r87) * 31;
        Integer r89 = this.status;
        if (r89 == null) goto L121;
        int r90 = r89.hashCode();
    L122:
        int r91 = (r88 + r90) * 31;
        Integer r92 = this.errCode;
        if (r92 == null) goto L125;
        int r94 = r92.hashCode();
    L126:
        int r95 = (r91 + r94) * 31;
        String r96 = this.errMsg;
        if (r96 == null) goto L129;
        int r97 = r96.hashCode();
    L130:
        int r98 = (r95 + r97) * 31;
        Integer r99 = this.leaveType;
        if (r99 == null) goto L133;
        int r100 = r99.hashCode();
    L134:
        int r101 = (r98 + r100) * 31;
        Integer r102 = this.retryStatus;
        if (r102 == null) goto L137;
        int r103 = r102.hashCode();
    L138:
        int r104 = (r101 + r103) * 31;
        Long r105 = this.leaveTime;
        if (r105 == null) goto L141;
        int r106 = r105.hashCode();
    L142:
        int r107 = (r104 + r106) * 31;
        Long r108 = this.geckoStart;
        if (r108 == null) goto L145;
        int r109 = r108.hashCode();
    L146:
        int r110 = (r107 + r109) * 31;
        Long r111 = this.geckoEnd;
        if (r111 == null) goto L149;
        int r112 = r111.hashCode();
    L150:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.geckoStatus;
        if (r114 == null) goto L153;
        int r115 = r114.hashCode();
    L154:
        int r116 = (r113 + r115) * 31;
        Long r117 = this.depPluginInstallStart;
        if (r117 == null) goto L157;
        int r118 = r117.hashCode();
    L158:
        int r119 = (r116 + r118) * 31;
        Long r120 = this.depPluginInstallEnd;
        if (r120 == null) goto L161;
        int r121 = r120.hashCode();
    L162:
        int r122 = (r119 + r121) * 31;
        Integer r123 = this.depPluginStatus;
        if (r123 == null) goto L165;
        int r124 = r123.hashCode();
    L166:
        int r125 = (r122 + r124) * 31;
        Integer r126 = this.ecPluginStatus;
        if (r126 == null) goto L169;
        int r127 = r126.hashCode();
    L170:
        int r128 = (r125 + r127) * 31;
        Long r129 = this.tPrepareCachedDataStart;
        if (r129 == null) goto L173;
        int r130 = r129.hashCode();
    L174:
        int r131 = (r128 + r130) * 31;
        Long r132 = this.tPrepareCachedDataEnd;
        if (r132 == null) goto L177;
        int r133 = r132.hashCode();
    L178:
        int r134 = (r131 + r133) * 31;
        Integer r135 = this.cachedDataPreparedStatus;
        if (r135 == null) goto L181;
        int r136 = r135.hashCode();
    L182:
        int r137 = (r134 + r136) * 31;
        Integer r138 = this.dataReuseStatus;
        if (r138 == null) goto L185;
        int r139 = r138.hashCode();
    L186:
        int r140 = (r137 + r139) * 31;
        Long r141 = this.tPrepareFirstScreenDataStart;
        if (r141 == null) goto L189;
        int r142 = r141.hashCode();
    L190:
        int r143 = (r140 + r142) * 31;
        Long r144 = this.tPrepareFirstScreenDataEnd;
        if (r144 == null) goto L193;
        int r145 = r144.hashCode();
    L194:
        int r146 = (r143 + r145) * 31;
        Integer r147 = this.firstScreenDataPreparedStatus;
        if (r147 == null) goto L197;
        int r148 = r147.hashCode();
    L198:
        int r149 = (r146 + r148) * 31;
        Integer r150 = this.rebuildScene;
        if (r150 == null) goto L201;
        int r151 = r150.hashCode();
    L202:
        int r152 = (((r149 + r151) * 31) + this.straightOutFlag) * 31;
        Long r153 = this.tFirstScreenStraightOutStart;
        if (r153 == null) goto L205;
        int r154 = r153.hashCode();
    L206:
        int r155 = (r152 + r154) * 31;
        Long r156 = this.tFirstScreenStraightOutEnd;
        if (r156 == null) goto L209;
        int r157 = r156.hashCode();
    L210:
        int r158 = (r155 + r157) * 31;
        Long r159 = this.tNAContainerReady;
        if (r159 == null) goto L213;
        int r160 = r159.hashCode();
    L214:
        int r161 = (r158 + r160) * 31;
        Long r162 = this.tStraightOutLoadTime;
        if (r162 == null) goto L217;
        int r163 = r162.hashCode();
    L218:
        int r164 = (r161 + r163) * 31;
        Long r165 = this.tStraightOutCreateViewTime;
        if (r165 == null) goto L221;
        int r166 = r165.hashCode();
    L222:
        int r167 = (r164 + r166) * 31;
        Long r168 = this.tDialogFirstScreenStart;
        if (r168 == null) goto L225;
        int r169 = r168.hashCode();
    L226:
        int r170 = (r167 + r169) * 31;
        Long r171 = this.tDialogFirstScreenEnd;
        if (r171 == null) goto L229;
        int r172 = r171.hashCode();
    L230:
        int r173 = (r170 + r172) * 31;
        Long r174 = this.tDialogPreprocessStartTime;
        if (r174 == null) goto L233;
        int r175 = r174.hashCode();
    L234:
        int r176 = (r173 + r175) * 31;
        Long r177 = this.tDialogPreprocessEndTime;
        if (r177 == null) goto L237;
        int r178 = r177.hashCode();
    L238:
        int r179 = (r176 + r178) * 31;
        String r180 = this.firstChunkName;
        if (r180 == null) goto L241;
        int r181 = r180.hashCode();
    L242:
        int r182 = (r179 + r181) * 31;
        Long r183 = this.firstChunkReceived;
        if (r183 == null) goto L245;
        int r184 = r183.hashCode();
    L246:
        int r185 = (r182 + r184) * 31;
        Long r186 = this.firstChunkRenderStart;
        if (r186 == null) goto L249;
        int r187 = r186.hashCode();
    L250:
        int r188 = (r185 + r187) * 31;
        Long r189 = this.firstChunkRenderEnd;
        if (r189 == null) goto L253;
        int r190 = r189.hashCode();
    L254:
        int r191 = (r188 + r190) * 31;
        String r192 = this.secondChunkName;
        if (r192 == null) goto L257;
        int r193 = r192.hashCode();
    L258:
        int r194 = (r191 + r193) * 31;
        Long r195 = this.secondChunkReceived;
        if (r195 == null) goto L261;
        int r196 = r195.hashCode();
    L262:
        int r197 = (r194 + r196) * 31;
        Long r198 = this.secondChunkRenderStart;
        if (r198 == null) goto L265;
        int r199 = r198.hashCode();
    L266:
        int r200 = (r197 + r199) * 31;
        Long r201 = this.secondChunkRenderEnd;
        if (r201 == null) goto L269;
        int r202 = r201.hashCode();
    L270:
        int r203 = (r200 + r202) * 31;
        Boolean r204 = this.skipRenderWithFullData;
        if (r204 == null) goto L273;
        int r205 = r204.hashCode();
    L274:
        int r206 = (r203 + r205) * 31;
        Long r207 = this.tabClickTime;
        if (r207 == null) goto L277;
        int r208 = r207.hashCode();
    L278:
        int r209 = (r206 + r208) * 31;
        Long r210 = this.multiMallFrameTime;
        if (r210 == null) goto L281;
        int r211 = r210.hashCode();
    L282:
        int r212 = (r209 + r211) * 31;
        Integer r213 = this.gylNumOfFirstScreen;
        if (r213 == null) goto L285;
        int r214 = r213.hashCode();
    L286:
        int r215 = (r212 + r214) * 31;
        Long r216 = this.immerseBindRealDataTime;
        if (r216 == null) goto L289;
        int r217 = r216.hashCode();
    L290:
        int r218 = (r215 + r217) * 31;
        String r219 = this.immerseBindRealDataReason;
        if (r219 == null) goto L293;
        int r220 = r219.hashCode();
    L294:
        int r221 = (r218 + r220) * 31;
        Integer r222 = this.straightOutHeaderCardType;
        if (r222 == null) goto L297;
        int r223 = r222.hashCode();
    L298:
        int r224 = (r221 + r223) * 31;
        Integer r225 = this.firstScreenHeaderCardType;
        if (r225 == null) goto L301;
        int r226 = r225.hashCode();
    L302:
        int r227 = (r224 + r226) * 31;
        Long r228 = this.tFirstScreenEnd;
        if (r228 == null) goto L305;
        int r229 = r228.hashCode();
    L306:
        int r230 = (r227 + r229) * 31;
        Long r231 = this.mallCategoryTabFragmentOnCreateStart;
        if (r231 == null) goto L309;
        int r232 = r231.hashCode();
    L310:
        int r233 = (r230 + r232) * 31;
        Long r234 = this.mallCategoryTabFragmentOnCreateEnd;
        if (r234 == null) goto L313;
        int r235 = r234.hashCode();
    L314:
        int r236 = (r233 + r235) * 31;
        Long r237 = this.mallCategoryTabFragmentOnCreateViewStart;
        if (r237 == null) goto L317;
        int r238 = r237.hashCode();
    L318:
        int r239 = (r236 + r238) * 31;
        Long r240 = this.mallCategoryTabFragmentOnCreateViewEnd;
        if (r240 == null) goto L321;
        int r241 = r240.hashCode();
    L322:
        int r242 = (r239 + r241) * 31;
        Long r243 = this.mallCategoryTabFragmentViewCreatedStart;
        if (r243 == null) goto L325;
        int r244 = r243.hashCode();
    L326:
        int r245 = (r242 + r244) * 31;
        Long r246 = this.mallCategoryTabFragmentViewCreatedEnd;
        if (r246 == null) goto L329;
        int r247 = r246.hashCode();
    L330:
        int r248 = (r245 + r247) * 31;
        Long r249 = this.mallCategoryTabFragmentOnResumeStart;
        if (r249 == null) goto L333;
        int r250 = r249.hashCode();
    L334:
        int r251 = (r248 + r250) * 31;
        Long r252 = this.mallCategoryTabFragmentOnResumeEnd;
        if (r252 == null) goto L337;
        int r253 = r252.hashCode();
    L338:
        int r254 = (r251 + r253) * 31;
        Long r255 = this.mallHomeFragmentOnCreateStart;
        if (r255 == null) goto L341;
        int r256 = r255.hashCode();
    L342:
        int r257 = (r254 + r256) * 31;
        Long r258 = this.mallHomeFragmentOnCreateEnd;
        if (r258 == null) goto L345;
        int r259 = r258.hashCode();
    L346:
        int r260 = (r257 + r259) * 31;
        Long r261 = this.mallHomeFragmentOnCreateViewStart;
        if (r261 == null) goto L349;
        int r262 = r261.hashCode();
    L350:
        int r263 = (r260 + r262) * 31;
        Long r264 = this.mallHomeFragmentOnCreateViewEnd;
        if (r264 == null) goto L353;
        int r265 = r264.hashCode();
    L354:
        int r266 = (r263 + r265) * 31;
        Long r267 = this.mallHomeFragmentViewCreatedStart;
        if (r267 == null) goto L357;
        int r268 = r267.hashCode();
    L358:
        int r269 = (r266 + r268) * 31;
        Long r270 = this.mallHomeFragmentViewCreatedEnd;
        if (r270 == null) goto L361;
        int r271 = r270.hashCode();
    L362:
        int r272 = (r269 + r271) * 31;
        Long r273 = this.mallHomeFragmentOnResumeStart;
        if (r273 == null) goto L365;
        int r274 = r273.hashCode();
    L366:
        int r275 = (r272 + r274) * 31;
        Long r276 = this.mallHomeFragmentOnResumeEnd;
        if (r276 == null) goto L369;
        int r277 = r276.hashCode();
    L370:
        int r278 = (r275 + r277) * 31;
        Long r279 = this.mainPageFragmentOnCreateStart;
        if (r279 == null) goto L373;
        int r280 = r279.hashCode();
    L374:
        int r281 = (r278 + r280) * 31;
        Long r282 = this.mainPageFragmentOnCreateEnd;
        if (r282 == null) goto L377;
        int r283 = r282.hashCode();
    L378:
        int r284 = (r281 + r283) * 31;
        Long r285 = this.mainPageFragmentOnCreateViewStart;
        if (r285 == null) goto L381;
        int r286 = r285.hashCode();
    L382:
        int r287 = (r284 + r286) * 31;
        Long r288 = this.mainPageFragmentOnCreateViewEnd;
        if (r288 == null) goto L385;
        int r289 = r288.hashCode();
    L386:
        int r290 = (r287 + r289) * 31;
        Long r291 = this.mainPageFragmentViewCreatedStart;
        if (r291 == null) goto L389;
        int r292 = r291.hashCode();
    L390:
        int r293 = (r290 + r292) * 31;
        Long r294 = this.mainPageFragmentViewCreatedEnd;
        if (r294 == null) goto L393;
        int r295 = r294.hashCode();
    L394:
        int r296 = (r293 + r295) * 31;
        Long r297 = this.mainPageFragmentOnResumeStart;
        if (r297 == null) goto L397;
        int r298 = r297.hashCode();
    L398:
        int r299 = (r296 + r298) * 31;
        Long r300 = this.mainPageFragmentOnResumeEnd;
        if (r300 == null) goto L401;
        int r301 = r300.hashCode();
    L402:
        int r302 = (r299 + r301) * 31;
        Long r303 = this.ecHybridRecycleViewLayoutStart;
        if (r303 == null) goto L405;
        int r304 = r303.hashCode();
    L406:
        int r305 = (r302 + r304) * 31;
        Long r306 = this.ecHybridRecycleViewLayoutEnd;
        if (r306 == null) goto L409;
        int r307 = r306.hashCode();
    L410:
        int r308 = (r305 + r307) * 31;
        Long r309 = this.ecHybridRecycleViewRealDataLayoutStart;
        if (r309 == null) goto L413;
        int r310 = r309.hashCode();
    L414:
        int r311 = (r308 + r310) * 31;
        Long r312 = this.ecHybridRecycleViewRealDataLayoutEnd;
        if (r312 == null) goto L417;
        int r313 = r312.hashCode();
    L418:
        int r314 = (r311 + r313) * 31;
        Long r315 = this.ecHybridRecycleViewDrawStart;
        if (r315 == null) goto L421;
        int r316 = r315.hashCode();
    L422:
        int r317 = (r314 + r316) * 31;
        Long r318 = this.ecHybridRecycleViewDrawEnd;
        if (r318 == null) goto L425;
        int r319 = r318.hashCode();
    L426:
        int r320 = (r317 + r319) * 31;
        Long r321 = this.ecHybridRecycleViewRealDataDrawStart;
        if (r321 == null) goto L429;
        int r322 = r321.hashCode();
    L430:
        int r323 = (r320 + r322) * 31;
        Long r324 = this.ecHybridRecycleViewRealDataDrawEnd;
        if (r324 == null) goto L433;
        int r325 = r324.hashCode();
    L434:
        int r326 = (r323 + r325) * 31;
        Long r327 = this.mallInitTopBarStart;
        if (r327 == null) goto L437;
        int r328 = r327.hashCode();
    L438:
        int r329 = (r326 + r328) * 31;
        Long r330 = this.mallInitTopBarEnd;
        if (r330 == null) goto L441;
        int r331 = r330.hashCode();
    L442:
        int r332 = (r329 + r331) * 31;
        Long r333 = this.firstScreenDataMainHandleStart;
        if (r333 == null) goto L445;
        int r334 = r333.hashCode();
    L446:
        int r335 = (r332 + r334) * 31;
        Long r336 = this.firstScreenDataMainHandleEnd;
        if (r336 == null) goto L449;
        int r337 = r336.hashCode();
    L450:
        int r338 = (r335 + r337) * 31;
        Integer r339 = this.prefetchMainSuccessWhenCreate;
        if (r339 == null) goto L453;
        int r340 = r339.hashCode();
    L454:
        int r341 = (r338 + r340) * 31;
        Long r342 = this.mallStartHandleInitData;
        if (r342 == null) goto L457;
        int r343 = r342.hashCode();
    L458:
        int r344 = (r341 + r343) * 31;
        Long r345 = this.preloadDataEngineStart;
        if (r345 == null) goto L461;
        int r346 = r345.hashCode();
    L462:
        int r347 = (r344 + r346) * 31;
        Long r348 = this.preloadDataEngineEnd;
        if (r348 == null) goto L465;
        int r349 = r348.hashCode();
    L466:
        int r350 = (r347 + r349) * 31;
        Long r351 = this.mallPreInitLynxStart;
        if (r351 == null) goto L469;
        int r352 = r351.hashCode();
    L470:
        int r353 = (r350 + r352) * 31;
        Long r354 = this.mallPreInitLynxEnd;
        if (r354 == null) goto L473;
        int r355 = r354.hashCode();
    L474:
        int r356 = (r353 + r355) * 31;
        Long r357 = this.mallPostFirstScreenDataRunnableStart;
        if (r357 == null) goto L477;
        int r358 = r357.hashCode();
    L478:
        int r359 = (r356 + r358) * 31;
        Long r360 = this.mallPostFirstScreenDataRunnableEnd;
        if (r360 == null) goto L481;
        int r361 = r360.hashCode();
    L482:
        int r362 = (r359 + r361) * 31;
        Long r363 = this.optimizeConfigCenterEnd;
        if (r363 == null) goto L485;
        int r364 = r363.hashCode();
    L486:
        int r365 = (r362 + r364) * 31;
        Long r366 = this.mallHandlePopupStart;
        if (r366 == null) goto L489;
        int r367 = r366.hashCode();
    L490:
        int r368 = (r365 + r367) * 31;
        Long r369 = this.mallHandlePopupEnd;
        if (r369 == null) goto L493;
        int r370 = r369.hashCode();
    L494:
        int r371 = (r368 + r370) * 31;
        Long r372 = this.waitTTNetInitDuration;
        if (r372 == null) goto L497;
        int r373 = r372.hashCode();
    L498:
        int r374 = (r371 + r373) * 31;
        Long r375 = this.TTNetInitEnd;
        if (r375 == null) goto L501;
        int r376 = r375.hashCode();
    L502:
        int r377 = (r374 + r376) * 31;
        Integer r378 = this.prefetchMessageMainQueueIndex;
        if (r378 == null) goto L505;
        int r379 = r378.hashCode();
    L506:
        int r380 = (r377 + r379) * 31;
        Integer r381 = this.tDataFromNetInterceptor;
        if (r381 == null) goto L509;
        int r382 = r381.hashCode();
    L510:
        int r383 = (r380 + r382) * 31;
        Integer r384 = this.parseNetworkPerfParamsStatus;
        if (r384 == null) goto L513;
        int r385 = r384.hashCode();
    L514:
        int r386 = (r383 + r385) * 31;
        String r387 = this.cachedCategoryTabType;
        if (r387 == null) goto L517;
        int r388 = r387.hashCode();
    L518:
        int r389 = (r386 + r388) * 31;
        Integer r390 = this.cachedCategoryTabConvertFlag;
        if (r390 == null) goto L521;
        int r391 = r390.hashCode();
    L522:
        int r392 = (r389 + r391) * 31;
        String r393 = this.categoryTabType;
        if (r393 == null) goto L525;
        int r394 = r393.hashCode();
    L526:
        int r395 = (r392 + r394) * 31;
        Map<String, Object> r396 = this.a;
        if (r396 == null) goto L529;
        int r397 = r396.hashCode();
    L530:
        int r398 = (r395 + r397) * 31;
        JSONObject r399 = this.b;
        if (r399 == null) goto L533;
        r1 = r399.hashCode();
    L533:
        int r400 = (r398 + r1) * 31;
        boolean r401 = this.c;
        ?? r402 = r401;
        if (r401 == false) goto L537;
        r402 = 1;
    L537:
        return r400 + r402;
    L529:
        r397 = 0;
        goto L530
    L525:
        r394 = 0;
        goto L526
    L521:
        r391 = 0;
        goto L522
    L517:
        r388 = 0;
        goto L518
    L513:
        r385 = 0;
        goto L514
    L509:
        r382 = 0;
        goto L510
    L505:
        r379 = 0;
        goto L506
    L501:
        r376 = 0;
        goto L502
    L497:
        r373 = 0;
        goto L498
    L493:
        r370 = 0;
        goto L494
    L489:
        r367 = 0;
        goto L490
    L485:
        r364 = 0;
        goto L486
    L481:
        r361 = 0;
        goto L482
    L477:
        r358 = 0;
        goto L478
    L473:
        r355 = 0;
        goto L474
    L469:
        r352 = 0;
        goto L470
    L465:
        r349 = 0;
        goto L466
    L461:
        r346 = 0;
        goto L462
    L457:
        r343 = 0;
        goto L458
    L453:
        r340 = 0;
        goto L454
    L449:
        r337 = 0;
        goto L450
    L445:
        r334 = 0;
        goto L446
    L441:
        r331 = 0;
        goto L442
    L437:
        r328 = 0;
        goto L438
    L433:
        r325 = 0;
        goto L434
    L429:
        r322 = 0;
        goto L430
    L425:
        r319 = 0;
        goto L426
    L421:
        r316 = 0;
        goto L422
    L417:
        r313 = 0;
        goto L418
    L413:
        r310 = 0;
        goto L414
    L409:
        r307 = 0;
        goto L410
    L405:
        r304 = 0;
        goto L406
    L401:
        r301 = 0;
        goto L402
    L397:
        r298 = 0;
        goto L398
    L393:
        r295 = 0;
        goto L394
    L389:
        r292 = 0;
        goto L390
    L385:
        r289 = 0;
        goto L386
    L381:
        r286 = 0;
        goto L382
    L377:
        r283 = 0;
        goto L378
    L373:
        r280 = 0;
        goto L374
    L369:
        r277 = 0;
        goto L370
    L365:
        r274 = 0;
        goto L366
    L361:
        r271 = 0;
        goto L362
    L357:
        r268 = 0;
        goto L358
    L353:
        r265 = 0;
        goto L354
    L349:
        r262 = 0;
        goto L350
    L345:
        r259 = 0;
        goto L346
    L341:
        r256 = 0;
        goto L342
    L337:
        r253 = 0;
        goto L338
    L333:
        r250 = 0;
        goto L334
    L329:
        r247 = 0;
        goto L330
    L325:
        r244 = 0;
        goto L326
    L321:
        r241 = 0;
        goto L322
    L317:
        r238 = 0;
        goto L318
    L313:
        r235 = 0;
        goto L314
    L309:
        r232 = 0;
        goto L310
    L305:
        r229 = 0;
        goto L306
    L301:
        r226 = 0;
        goto L302
    L297:
        r223 = 0;
        goto L298
    L293:
        r220 = 0;
        goto L294
    L289:
        r217 = 0;
        goto L290
    L285:
        r214 = 0;
        goto L286
    L281:
        r211 = 0;
        goto L282
    L277:
        r208 = 0;
        goto L278
    L273:
        r205 = 0;
        goto L274
    L269:
        r202 = 0;
        goto L270
    L265:
        r199 = 0;
        goto L266
    L261:
        r196 = 0;
        goto L262
    L257:
        r193 = 0;
        goto L258
    L253:
        r190 = 0;
        goto L254
    L249:
        r187 = 0;
        goto L250
    L245:
        r184 = 0;
        goto L246
    L241:
        r181 = 0;
        goto L242
    L237:
        r178 = 0;
        goto L238
    L233:
        r175 = 0;
        goto L234
    L229:
        r172 = 0;
        goto L230
    L225:
        r169 = 0;
        goto L226
    L221:
        r166 = 0;
        goto L222
    L217:
        r163 = 0;
        goto L218
    L213:
        r160 = 0;
        goto L214
    L209:
        r157 = 0;
        goto L210
    L205:
        r154 = 0;
        goto L206
    L201:
        r151 = 0;
        goto L202
    L197:
        r148 = 0;
        goto L198
    L193:
        r145 = 0;
        goto L194
    L189:
        r142 = 0;
        goto L190
    L185:
        r139 = 0;
        goto L186
    L181:
        r136 = 0;
        goto L182
    L177:
        r133 = 0;
        goto L178
    L173:
        r130 = 0;
        goto L174
    L169:
        r127 = 0;
        goto L170
    L165:
        r124 = 0;
        goto L166
    L161:
        r121 = 0;
        goto L162
    L157:
        r118 = 0;
        goto L158
    L153:
        r115 = 0;
        goto L154
    L149:
        r112 = 0;
        goto L150
    L145:
        r109 = 0;
        goto L146
    L141:
        r106 = 0;
        goto L142
    L137:
        r103 = 0;
        goto L138
    L133:
        r100 = 0;
        goto L134
    L129:
        r97 = 0;
        goto L130
    L125:
        r94 = 0;
        goto L126
    L121:
        r90 = 0;
        goto L122
    L117:
        r87 = 0;
        goto L118
    L113:
        r84 = 0;
        goto L114
    L109:
        r80 = 0;
        goto L110
    L105:
        r77 = 0;
        goto L106
    L101:
        r74 = 0;
        goto L102
    L97:
        r71 = 0;
        goto L98
    L93:
        r68 = 0;
        goto L94
    L89:
        r65 = 0;
        goto L90
    L85:
        r62 = 0;
        goto L86
    L81:
        r59 = 0;
        goto L82
    L77:
        r56 = 0;
        goto L78
    L73:
        r53 = 0;
        goto L74
    L69:
        r50 = 0;
        goto L70
    L65:
        r47 = 0;
        goto L66
    L61:
        r44 = 0;
        goto L62
    L57:
        r41 = 0;
        goto L58
    L53:
        r38 = 0;
        goto L54
    L49:
        r35 = 0;
        goto L50
    L45:
        r32 = 0;
        goto L46
    L41:
        r29 = 0;
        goto L42
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
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

    public final String toString() {
        return "FirstScreenAnalyseBean(serverLoginStatus=" + this.serverLoginStatus + ", clientLoginStatus=" + this.clientLoginStatus + ", preloadStartTimestamp=" + this.preloadStartTimestamp + ", preloadEndTimestamp=" + this.preloadEndTimestamp + ", preloadConfigStart=" + this.preloadConfigStart + ", preloadConfigEnd=" + this.preloadConfigEnd + ", preloadConfigResult=" + this.preloadConfigResult + ", prefetchStart=" + this.prefetchStart + ", prefetchEnd=" + this.prefetchEnd + ", openTime=" + this.openTime + ", entranceFragmentCreateViewStart=" + this.entranceFragmentCreateViewStart + ", entranceFragmentCreateViewEnd=" + this.entranceFragmentCreateViewEnd + ", popupPageStraightOut=" + this.popupPageStraightOut + ", initLynxStart=" + this.initLynxStart + ", initLynxEnd=" + this.initLynxEnd + ", fragmentCreateViewStart=" + this.fragmentCreateViewStart + ", fragmentCreateViewEnd=" + this.fragmentCreateViewEnd + ", loadBundleStart=" + this.loadBundleStart + ", loadBundleEnd=" + this.loadBundleEnd + ", loadBundleWay=" + this.loadBundleWay + ", netStart=" + this.netStart + ", netEnd=" + this.netEnd + ", netEndClient=" + this.netEndClient + ", catchNoBind=" + this.catchNoBind + ", handlePrefetchedDataTime=" + this.handlePrefetchedDataTime + ", listLoadStart=" + this.listLoadStart + ", listFirstScreen=" + this.listFirstScreen + ", listLoadEnd=" + this.listLoadEnd + ", halfPageOpen=" + this.halfPageOpen + ", status=" + this.status + ", errCode=" + this.errCode + ", errMsg=" + this.errMsg + ", leaveType=" + this.leaveType + ", retryStatus=" + this.retryStatus + ", leaveTime=" + this.leaveTime + ", geckoStart=" + this.geckoStart + ", geckoEnd=" + this.geckoEnd + ", geckoStatus=" + this.geckoStatus + ", depPluginInstallStart=" + this.depPluginInstallStart + ", depPluginInstallEnd=" + this.depPluginInstallEnd + ", depPluginStatus=" + this.depPluginStatus + ", ecPluginStatus=" + this.ecPluginStatus + ", tPrepareCachedDataStart=" + this.tPrepareCachedDataStart + ", tPrepareCachedDataEnd=" + this.tPrepareCachedDataEnd + ", cachedDataPreparedStatus=" + this.cachedDataPreparedStatus + ", dataReuseStatus=" + this.dataReuseStatus + ", tPrepareFirstScreenDataStart=" + this.tPrepareFirstScreenDataStart + ", tPrepareFirstScreenDataEnd=" + this.tPrepareFirstScreenDataEnd + ", firstScreenDataPreparedStatus=" + this.firstScreenDataPreparedStatus + ", rebuildScene=" + this.rebuildScene + ", straightOutFlag=" + this.straightOutFlag + ", tFirstScreenStraightOutStart=" + this.tFirstScreenStraightOutStart + ", tFirstScreenStraightOutEnd=" + this.tFirstScreenStraightOutEnd + ", tNAContainerReady=" + this.tNAContainerReady + ", tStraightOutLoadTime=" + this.tStraightOutLoadTime + ", tStraightOutCreateViewTime=" + this.tStraightOutCreateViewTime + ", tDialogFirstScreenStart=" + this.tDialogFirstScreenStart + ", tDialogFirstScreenEnd=" + this.tDialogFirstScreenEnd + ", tDialogPreprocessStartTime=" + this.tDialogPreprocessStartTime + ", tDialogPreprocessEndTime=" + this.tDialogPreprocessEndTime + ", firstChunkName=" + this.firstChunkName + ", firstChunkReceived=" + this.firstChunkReceived + ", firstChunkRenderStart=" + this.firstChunkRenderStart + ", firstChunkRenderEnd=" + this.firstChunkRenderEnd + ", secondChunkName=" + this.secondChunkName + ", secondChunkReceived=" + this.secondChunkReceived + ", secondChunkRenderStart=" + this.secondChunkRenderStart + ", secondChunkRenderEnd=" + this.secondChunkRenderEnd + ", skipRenderWithFullData=" + this.skipRenderWithFullData + ", tabClickTime=" + this.tabClickTime + ", multiMallFrameTime=" + this.multiMallFrameTime + ", gylNumOfFirstScreen=" + this.gylNumOfFirstScreen + ", immerseBindRealDataTime=" + this.immerseBindRealDataTime + ", immerseBindRealDataReason=" + this.immerseBindRealDataReason + ", straightOutHeaderCardType=" + this.straightOutHeaderCardType + ", firstScreenHeaderCardType=" + this.firstScreenHeaderCardType + ", tFirstScreenEnd=" + this.tFirstScreenEnd + ", mallCategoryTabFragmentOnCreateStart=" + this.mallCategoryTabFragmentOnCreateStart + ", mallCategoryTabFragmentOnCreateEnd=" + this.mallCategoryTabFragmentOnCreateEnd + ", mallCategoryTabFragmentOnCreateViewStart=" + this.mallCategoryTabFragmentOnCreateViewStart + ", mallCategoryTabFragmentOnCreateViewEnd=" + this.mallCategoryTabFragmentOnCreateViewEnd + ", mallCategoryTabFragmentViewCreatedStart=" + this.mallCategoryTabFragmentViewCreatedStart + ", mallCategoryTabFragmentViewCreatedEnd=" + this.mallCategoryTabFragmentViewCreatedEnd + ", mallCategoryTabFragmentOnResumeStart=" + this.mallCategoryTabFragmentOnResumeStart + ", mallCategoryTabFragmentOnResumeEnd=" + this.mallCategoryTabFragmentOnResumeEnd + ", mallHomeFragmentOnCreateStart=" + this.mallHomeFragmentOnCreateStart + ", mallHomeFragmentOnCreateEnd=" + this.mallHomeFragmentOnCreateEnd + ", mallHomeFragmentOnCreateViewStart=" + this.mallHomeFragmentOnCreateViewStart + ", mallHomeFragmentOnCreateViewEnd=" + this.mallHomeFragmentOnCreateViewEnd + ", mallHomeFragmentViewCreatedStart=" + this.mallHomeFragmentViewCreatedStart + ", mallHomeFragmentViewCreatedEnd=" + this.mallHomeFragmentViewCreatedEnd + ", mallHomeFragmentOnResumeStart=" + this.mallHomeFragmentOnResumeStart + ", mallHomeFragmentOnResumeEnd=" + this.mallHomeFragmentOnResumeEnd + ", mainPageFragmentOnCreateStart=" + this.mainPageFragmentOnCreateStart + ", mainPageFragmentOnCreateEnd=" + this.mainPageFragmentOnCreateEnd + ", mainPageFragmentOnCreateViewStart=" + this.mainPageFragmentOnCreateViewStart + ", mainPageFragmentOnCreateViewEnd=" + this.mainPageFragmentOnCreateViewEnd + ", mainPageFragmentViewCreatedStart=" + this.mainPageFragmentViewCreatedStart + ", mainPageFragmentViewCreatedEnd=" + this.mainPageFragmentViewCreatedEnd + ", mainPageFragmentOnResumeStart=" + this.mainPageFragmentOnResumeStart + ", mainPageFragmentOnResumeEnd=" + this.mainPageFragmentOnResumeEnd + ", ecHybridRecycleViewLayoutStart=" + this.ecHybridRecycleViewLayoutStart + ", ecHybridRecycleViewLayoutEnd=" + this.ecHybridRecycleViewLayoutEnd + ", ecHybridRecycleViewRealDataLayoutStart=" + this.ecHybridRecycleViewRealDataLayoutStart + ", ecHybridRecycleViewRealDataLayoutEnd=" + this.ecHybridRecycleViewRealDataLayoutEnd + ", ecHybridRecycleViewDrawStart=" + this.ecHybridRecycleViewDrawStart + ", ecHybridRecycleViewDrawEnd=" + this.ecHybridRecycleViewDrawEnd + ", ecHybridRecycleViewRealDataDrawStart=" + this.ecHybridRecycleViewRealDataDrawStart + ", ecHybridRecycleViewRealDataDrawEnd=" + this.ecHybridRecycleViewRealDataDrawEnd + ", mallInitTopBarStart=" + this.mallInitTopBarStart + ", mallInitTopBarEnd=" + this.mallInitTopBarEnd + ", firstScreenDataMainHandleStart=" + this.firstScreenDataMainHandleStart + ", firstScreenDataMainHandleEnd=" + this.firstScreenDataMainHandleEnd + ", prefetchMainSuccessWhenCreate=" + this.prefetchMainSuccessWhenCreate + ", mallStartHandleInitData=" + this.mallStartHandleInitData + ", preloadDataEngineStart=" + this.preloadDataEngineStart + ", preloadDataEngineEnd=" + this.preloadDataEngineEnd + ", mallPreInitLynxStart=" + this.mallPreInitLynxStart + ", mallPreInitLynxEnd=" + this.mallPreInitLynxEnd + ", mallPostFirstScreenDataRunnableStart=" + this.mallPostFirstScreenDataRunnableStart + ", mallPostFirstScreenDataRunnableEnd=" + this.mallPostFirstScreenDataRunnableEnd + ", optimizeConfigCenterEnd=" + this.optimizeConfigCenterEnd + ", mallHandlePopupStart=" + this.mallHandlePopupStart + ", mallHandlePopupEnd=" + this.mallHandlePopupEnd + ", waitTTNetInitDuration=" + this.waitTTNetInitDuration + ", TTNetInitEnd=" + this.TTNetInitEnd + ", prefetchMessageMainQueueIndex=" + this.prefetchMessageMainQueueIndex + ", tDataFromNetInterceptor=" + this.tDataFromNetInterceptor + ", parseNetworkPerfParamsStatus=" + this.parseNetworkPerfParamsStatus + ", cachedCategoryTabType=" + this.cachedCategoryTabType + ", cachedCategoryTabConvertFlag=" + this.cachedCategoryTabConvertFlag + ", categoryTabType=" + this.categoryTabType + ", serverMonitorTiming=" + this.a + ", requestMonitorInfo=" + this.b + ", _reported=" + this.c + ")";
    }

    public final Long A() {
        return this.tFirstScreenEnd;
    }

    public final Long B() {
        return this.tFirstScreenStraightOutEnd;
    }

    public final Long C() {
        return this.tFirstScreenStraightOutStart;
    }

    public final Long D() {
        return this.tPrepareCachedDataEnd;
    }

    public final Long E() {
        return this.tPrepareCachedDataStart;
    }

    public final Long F() {
        return this.tPrepareFirstScreenDataEnd;
    }

    public final Long G() {
        return this.tPrepareFirstScreenDataStart;
    }

    public final Integer b() {
        return this.clientLoginStatus;
    }

    public final String c() {
        return this.errMsg;
    }

    public final Integer d() {
        return this.firstScreenHeaderCardType;
    }

    public final Long e() {
        return this.geckoEnd;
    }

    public final Long f() {
        return this.geckoStart;
    }

    public final Integer g() {
        return this.gylNumOfFirstScreen;
    }

    public final Integer h() {
        return this.halfPageOpen;
    }

    public final Long i() {
        return this.handlePrefetchedDataTime;
    }

    public final Long j() {
        return this.listFirstScreen;
    }

    public final Long k() {
        return this.listLoadStart;
    }

    public final String l() {
        return this.loadBundleWay;
    }

    public final Long m() {
        return this.mallInitTopBarStart;
    }

    public final Long n() {
        return this.netEnd;
    }

    public final Long o() {
        return this.netEndClient;
    }

    public final Long p() {
        return this.netStart;
    }

    public final Long q() {
        return this.openTime;
    }

    public final Integer r() {
        return this.parseNetworkPerfParamsStatus;
    }

    public final Boolean s() {
        return this.popupPageStraightOut;
    }

    public final Integer t() {
        return this.prefetchMainSuccessWhenCreate;
    }

    public final Long u() {
        return this.preloadEndTimestamp;
    }

    public final Long v() {
        return this.preloadStartTimestamp;
    }

    public final Integer w() {
        return this.rebuildScene;
    }

    public final Long x() {
        return this.secondChunkRenderStart;
    }

    public final Integer y() {
        return this.status;
    }

    public final Integer z() {
        return this.straightOutHeaderCardType;
    }

    public /* synthetic */ a(Integer r137, int r138) {
        Boolean r13 = Boolean.FALSE;
        if ((r138 & 131072) == 0) goto L5;
        Integer r50 = null;
    L6:
        this(null, null, null, null, null, null, null, null, null, null, null, null, r13, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r50, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false);
        return;
    L5:
        r50 = r137;
        goto L6
    }

    public static a a(a r142, Integer r143, Integer r144, Long r145, Long r146, Long r147, Long r148, Long r149, String r150, Long r151, Long r152, Long r153, Integer r154, Long r155, Long r156, Long r157, Long r158, Integer r159, Integer r160, Integer r161, String r162, Integer r163, Long r164, Long r165, Integer r166, Long r167, Long r168, Integer r169, Integer r170, Long r171, Long r172, Integer r173, int r174, Long r175, Long r176, Long r177, Long r178, Long r179, Long r180, Long r181, String r182, Long r183, String r184, Long r185, Long r186, Boolean r187, Integer r188, Long r189, Integer r190, Integer r191, Long r192, Long r193, Long r194, Long r195, Long r196, Integer r197, Long r198, Long r199, Long r200, Long r201, Long r202, Integer r203, Integer r204, String r205, Integer r206, String r207, Map r208, JSONObject r209, boolean r210, int r211, int r212, int r213, int r214, int r215) {
        if ((r211 & 1) == 0) goto L5;
        Integer r7 = r142.serverLoginStatus;
    L7:
        if ((r211 & 2) == 0) goto L9;
        Integer r8 = r142.clientLoginStatus;
    L11:
        if ((r211 & 4) == 0) goto L13;
        Long r9 = r142.preloadStartTimestamp;
    L15:
        if ((r211 & 8) == 0) goto L17;
        Long r10 = r142.preloadEndTimestamp;
    L19:
        if ((r211 & 16) == 0) goto L21;
        Long r11 = r142.preloadConfigStart;
    L23:
        if ((r211 & 32) == 0) goto L25;
        Long r12 = r142.preloadConfigEnd;
    L27:
        if ((r211 & 64) == 0) goto L29;
        String r13 = r142.preloadConfigResult;
    L31:
        if ((r211 & 128) == 0) goto L33;
        Long r14 = r142.prefetchStart;
    L35:
        if ((r211 & 256) == 0) goto L37;
        Long r15 = r142.prefetchEnd;
    L39:
        if ((r211 & 512) == 0) goto L41;
        Long r16 = r142.openTime;
    L43:
        if ((r211 & 1024) == 0) goto L45;
        Long r17 = r142.entranceFragmentCreateViewStart;
    L47:
        if ((r211 & 2048) == 0) goto L49;
        Long r18 = r142.entranceFragmentCreateViewEnd;
    L51:
        if ((r211 & 4096) == 0) goto L53;
        Boolean r19 = r142.popupPageStraightOut;
    L55:
        if ((r211 & 8192) == 0) goto L57;
        Long r20 = r142.initLynxStart;
    L59:
        if ((r211 & 16384) == 0) goto L61;
        Long r21 = r142.initLynxEnd;
    L63:
        if ((r211 & 32768) == 0) goto L65;
        Long r22 = r142.fragmentCreateViewStart;
    L67:
        if ((r211 & 65536) == 0) goto L69;
        Long r23 = r142.fragmentCreateViewEnd;
    L71:
        if ((r211 & 131072) == 0) goto L73;
        Long r24 = r142.loadBundleStart;
    L75:
        if ((r211 & 262144) == 0) goto L77;
        Long r25 = r142.loadBundleEnd;
    L79:
        if ((r211 & 524288) == 0) goto L81;
        String r26 = r142.loadBundleWay;
    L83:
        if ((r211 & 1048576) == 0) goto L85;
        Long r27 = r142.netStart;
    L87:
        if ((r211 & 2097152) == 0) goto L89;
        Long r28 = r142.netEnd;
    L91:
        if ((r211 & 4194304) == 0) goto L93;
        Long r29 = r142.netEndClient;
    L95:
        if ((r211 & 8388608) == 0) goto L97;
        Integer r30 = r142.catchNoBind;
    L99:
        if ((r211 & 16777216) == 0) goto L101;
        Long r31 = r142.handlePrefetchedDataTime;
    L103:
        if ((r211 & 33554432) == 0) goto L105;
        Long r32 = r142.listLoadStart;
    L107:
        if ((r211 & 67108864) == 0) goto L109;
        Long r33 = r142.listFirstScreen;
    L111:
        if ((r211 & 134217728) == 0) goto L113;
        Long r34 = r142.listLoadEnd;
    L115:
        if ((268435456 & r211) == 0) goto L117;
        Integer r35 = r142.halfPageOpen;
    L119:
        if ((536870912 & r211) == 0) goto L121;
        Integer r36 = r142.status;
    L123:
        if ((1073741824 & r211) == 0) goto L125;
        Integer r37 = r142.errCode;
    L127:
        if ((r211 & Integer.MIN_VALUE) == 0) goto L129;
        String r38 = r142.errMsg;
    L131:
        if ((r212 & 1) == 0) goto L133;
        Integer r39 = r142.leaveType;
    L135:
        if ((r212 & 2) == 0) goto L137;
        Integer r40 = r142.retryStatus;
    L139:
        if ((r212 & 4) == 0) goto L141;
        Long r41 = r142.leaveTime;
    L143:
        if ((r212 & 8) == 0) goto L145;
        Long r42 = r142.geckoStart;
    L147:
        if ((r212 & 16) == 0) goto L149;
        Long r43 = r142.geckoEnd;
    L151:
        if ((r212 & 32) == 0) goto L153;
        Integer r44 = r142.geckoStatus;
    L155:
        if ((r212 & 64) == 0) goto L157;
        Long r45 = r142.depPluginInstallStart;
    L159:
        if ((r212 & 128) == 0) goto L161;
        Long r46 = r142.depPluginInstallEnd;
    L163:
        if ((r212 & 256) == 0) goto L165;
        Integer r47 = r142.depPluginStatus;
    L167:
        if ((r212 & 512) == 0) goto L169;
        Integer r48 = r142.ecPluginStatus;
    L171:
        if ((r212 & 1024) == 0) goto L173;
        Long r49 = r142.tPrepareCachedDataStart;
    L175:
        if ((r212 & 2048) == 0) goto L177;
        Long r50 = r142.tPrepareCachedDataEnd;
    L179:
        if ((r212 & 4096) == 0) goto L181;
        Integer r51 = r142.cachedDataPreparedStatus;
    L183:
        if ((r212 & 8192) == 0) goto L185;
        Integer r52 = r142.dataReuseStatus;
    L187:
        if ((r212 & 16384) == 0) goto L189;
        Long r53 = r142.tPrepareFirstScreenDataStart;
    L191:
        if ((r212 & 32768) == 0) goto L193;
        Long r54 = r142.tPrepareFirstScreenDataEnd;
    L195:
        if ((r212 & 65536) == 0) goto L197;
        Integer r55 = r142.firstScreenDataPreparedStatus;
    L199:
        if ((r212 & 131072) == 0) goto L201;
        Integer r56 = r142.rebuildScene;
        int r1 = 262144;
    L203:
        if ((r212 & r1) == 0) goto L205;
        int r57 = r142.straightOutFlag;
    L207:
        if ((r212 & 524288) == 0) goto L209;
        Long r58 = r142.tFirstScreenStraightOutStart;
    L211:
        if ((r212 & 1048576) == 0) goto L213;
        Long r59 = r142.tFirstScreenStraightOutEnd;
    L215:
        if ((r212 & 2097152) == 0) goto L217;
        Long r60 = r142.tNAContainerReady;
    L219:
        if ((r212 & 4194304) == 0) goto L221;
        Long r61 = r142.tStraightOutLoadTime;
    L223:
        if ((r212 & 8388608) == 0) goto L225;
        Long r62 = r142.tStraightOutCreateViewTime;
    L227:
        if ((r212 & 16777216) == 0) goto L229;
        Long r63 = r142.tDialogFirstScreenStart;
        int r2 = 33554432;
    L231:
        if ((r212 & r2) == 0) goto L233;
        Long r64 = r142.tDialogFirstScreenEnd;
        int r3 = 67108864;
    L235:
        if ((r212 & r3) == 0) goto L237;
        Long r65 = r142.tDialogPreprocessStartTime;
    L239:
        if ((r212 & 134217728) == 0) goto L241;
        Long r66 = r142.tDialogPreprocessEndTime;
    L243:
        if ((268435456 & r212) == 0) goto L245;
        String r67 = r142.firstChunkName;
    L247:
        if ((536870912 & r212) == 0) goto L249;
        Long r68 = r142.firstChunkReceived;
    L251:
        if ((1073741824 & r212) == 0) goto L253;
        Long r69 = r142.firstChunkRenderStart;
    L255:
        if ((Integer.MIN_VALUE & r212) == 0) goto L257;
        Long r70 = r142.firstChunkRenderEnd;
    L259:
        if ((r213 & 1) == 0) goto L261;
        String r71 = r142.secondChunkName;
    L263:
        if ((r213 & 2) == 0) goto L265;
        Long r72 = r142.secondChunkReceived;
    L267:
        if ((r213 & 4) == 0) goto L269;
        Long r73 = r142.secondChunkRenderStart;
    L271:
        if ((r213 & 8) == 0) goto L273;
        Long r74 = r142.secondChunkRenderEnd;
    L275:
        if ((r213 & 16) == 0) goto L277;
        Boolean r75 = r142.skipRenderWithFullData;
    L279:
        if ((r213 & 32) == 0) goto L281;
        Long r76 = r142.tabClickTime;
    L283:
        if ((r213 & 64) == 0) goto L285;
        Long r77 = r142.multiMallFrameTime;
    L287:
        if ((r213 & 128) == 0) goto L289;
        Integer r78 = r142.gylNumOfFirstScreen;
    L291:
        if ((r213 & 256) == 0) goto L293;
        Long r79 = r142.immerseBindRealDataTime;
    L295:
        if ((r213 & 512) == 0) goto L297;
        String r80 = r142.immerseBindRealDataReason;
    L299:
        if ((r213 & 1024) == 0) goto L301;
        Integer r81 = r142.straightOutHeaderCardType;
    L303:
        if ((r213 & 2048) == 0) goto L305;
        Integer r82 = r142.firstScreenHeaderCardType;
    L307:
        if ((r213 & 4096) == 0) goto L309;
        Long r84 = r142.tFirstScreenEnd;
    L311:
        if ((r213 & 8192) == 0) goto L313;
        Long r85 = r142.mallCategoryTabFragmentOnCreateStart;
    L315:
        if ((r213 & 16384) == 0) goto L317;
        Long r86 = r142.mallCategoryTabFragmentOnCreateEnd;
    L319:
        if ((r213 & 32768) == 0) goto L321;
        Long r87 = r142.mallCategoryTabFragmentOnCreateViewStart;
        int r4 = 65536;
    L323:
        if ((r213 & r4) == 0) goto L325;
        Long r88 = r142.mallCategoryTabFragmentOnCreateViewEnd;
        int r5 = 131072;
    L327:
        if ((r213 & r5) == 0) goto L329;
        Long r89 = r142.mallCategoryTabFragmentViewCreatedStart;
        int r6 = 262144;
    L331:
        if ((r213 & r6) == 0) goto L333;
        Long r810 = r142.mallCategoryTabFragmentViewCreatedEnd;
        int r90 = 524288;
    L335:
        if ((r213 & r90) == 0) goto L337;
        Long r91 = r142.mallCategoryTabFragmentOnResumeStart;
        int r92 = 1048576;
    L339:
        if ((r213 & r92) == 0) goto L341;
        Long r94 = r142.mallCategoryTabFragmentOnResumeEnd;
        int r95 = 2097152;
    L343:
        if ((r213 & r95) == 0) goto L345;
        Long r96 = r142.mallHomeFragmentOnCreateStart;
        int r97 = 4194304;
    L347:
        if ((r213 & r97) == 0) goto L349;
        Long r98 = r142.mallHomeFragmentOnCreateEnd;
        int r99 = 8388608;
    L351:
        if ((r213 & r99) == 0) goto L353;
        Long r910 = r142.mallHomeFragmentOnCreateViewStart;
        int r100 = 16777216;
    L355:
        if ((r213 & r100) == 0) goto L357;
        Long r911 = r142.mallHomeFragmentOnCreateViewEnd;
        int r101 = 33554432;
    L359:
        if ((r213 & r101) == 0) goto L361;
        Long r912 = r142.mallHomeFragmentViewCreatedStart;
        int r102 = 67108864;
    L363:
        if ((r213 & r102) == 0) goto L365;
        Long r913 = r142.mallHomeFragmentViewCreatedEnd;
        int r103 = 134217728;
    L367:
        if ((r213 & r103) == 0) goto L369;
        Long r914 = r142.mallHomeFragmentOnResumeStart;
    L371:
        if ((268435456 & r213) == 0) goto L373;
        Long r915 = r142.mallHomeFragmentOnResumeEnd;
    L375:
        if ((536870912 & r213) == 0) goto L377;
        Long r104 = r142.mainPageFragmentOnCreateStart;
    L379:
        if ((1073741824 & r213) == 0) goto L381;
        Long r105 = r142.mainPageFragmentOnCreateEnd;
    L383:
        if ((Integer.MIN_VALUE & r213) == 0) goto L385;
        Long r106 = r142.mainPageFragmentOnCreateViewStart;
    L387:
        if ((r214 & 1) == 0) goto L389;
        Long r107 = r142.mainPageFragmentOnCreateViewEnd;
    L391:
        if ((r214 & 2) == 0) goto L393;
        Long r108 = r142.mainPageFragmentViewCreatedStart;
    L395:
        if ((r214 & 4) == 0) goto L397;
        Long r109 = r142.mainPageFragmentViewCreatedEnd;
    L399:
        if ((r214 & 8) == 0) goto L401;
        Long r1010 = r142.mainPageFragmentOnResumeStart;
    L403:
        if ((r214 & 16) == 0) goto L405;
        Long r1011 = r142.mainPageFragmentOnResumeEnd;
    L407:
        if ((r214 & 32) == 0) goto L409;
        Long r1012 = r142.ecHybridRecycleViewLayoutStart;
    L411:
        if ((r214 & 64) == 0) goto L413;
        Long r1013 = r142.ecHybridRecycleViewLayoutEnd;
    L415:
        if ((r214 & 128) == 0) goto L417;
        Long r110 = r142.ecHybridRecycleViewRealDataLayoutStart;
    L419:
        if ((r214 & 256) == 0) goto L421;
        Long r111 = r142.ecHybridRecycleViewRealDataLayoutEnd;
    L423:
        if ((r214 & 512) == 0) goto L425;
        Long r112 = r142.ecHybridRecycleViewDrawStart;
    L427:
        if ((r214 & 1024) == 0) goto L429;
        Long r113 = r142.ecHybridRecycleViewDrawEnd;
    L431:
        if ((r214 & 2048) == 0) goto L433;
        Long r114 = r142.ecHybridRecycleViewRealDataDrawStart;
    L435:
        if ((r214 & 4096) == 0) goto L437;
        Long r115 = r142.ecHybridRecycleViewRealDataDrawEnd;
    L439:
        if ((r214 & 8192) == 0) goto L441;
        Long r116 = r142.mallInitTopBarStart;
    L443:
        if ((r214 & 16384) == 0) goto L445;
        Long r117 = r142.mallInitTopBarEnd;
    L447:
        if ((r214 & 32768) == 0) goto L449;
        Long r118 = r142.firstScreenDataMainHandleStart;
    L451:
        if ((65536 & r214) == 0) goto L453;
        Long r119 = r142.firstScreenDataMainHandleEnd;
    L455:
        if ((131072 & r214) == 0) goto L457;
        Integer r120 = r142.prefetchMainSuccessWhenCreate;
    L459:
        if ((262144 & r214) == 0) goto L461;
        Long r121 = r142.mallStartHandleInitData;
    L463:
        if ((524288 & r214) == 0) goto L465;
        Long r122 = r142.preloadDataEngineStart;
        int r123 = 1048576;
    L467:
        if ((r123 & r214) == 0) goto L469;
        Long r124 = r142.preloadDataEngineEnd;
        int r125 = 2097152;
    L471:
        if ((r125 & r214) == 0) goto L473;
        Long r126 = r142.mallPreInitLynxStart;
        int r127 = 4194304;
    L475:
        if ((r127 & r214) == 0) goto L477;
        Long r128 = r142.mallPreInitLynxEnd;
        int r129 = 8388608;
    L479:
        if ((r129 & r214) == 0) goto L481;
        Long r1210 = r142.mallPostFirstScreenDataRunnableStart;
    L483:
        if ((16777216 & r214) == 0) goto L485;
        Long r1211 = r142.mallPostFirstScreenDataRunnableEnd;
    L487:
        if ((33554432 & r214) == 0) goto L489;
        Long r1212 = r142.optimizeConfigCenterEnd;
        int r130 = 67108864;
    L491:
        if ((r130 & r214) == 0) goto L493;
        Long r1213 = r142.mallHandlePopupStart;
    L495:
        if ((134217728 & r214) == 0) goto L497;
        Long r131 = r142.mallHandlePopupEnd;
    L499:
        if ((268435456 & r214) == 0) goto L501;
        Long r132 = r142.waitTTNetInitDuration;
    L503:
        if ((536870912 & r214) == 0) goto L505;
        Long r133 = r142.TTNetInitEnd;
    L507:
        if ((1073741824 & r214) == 0) goto L509;
        Integer r134 = r142.prefetchMessageMainQueueIndex;
    L511:
        if ((Integer.MIN_VALUE & r214) == 0) goto L513;
        Integer r135 = r142.tDataFromNetInterceptor;
    L515:
        if ((r215 & 1) == 0) goto L517;
        Integer r136 = r142.parseNetworkPerfParamsStatus;
    L519:
        if ((r215 & 2) == 0) goto L521;
        String r137 = r142.cachedCategoryTabType;
    L523:
        if ((r215 & 4) == 0) goto L525;
        Integer r138 = r142.cachedCategoryTabConvertFlag;
    L527:
        if ((r215 & 8) == 0) goto L529;
        String r139 = r142.categoryTabType;
    L531:
        if ((r215 & 16) == 0) goto L533;
        Map r1310 = r142.a;
    L535:
        if ((r215 & 32) == 0) goto L537;
        JSONObject r140 = r142.b;
    L539:
        if ((r215 & 64) == 0) goto L541;
        boolean r141 = r142.c;
    L542:
        r142.getClass();
        return new a(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r84, r85, r86, r87, r88, r89, r810, r91, r94, r96, r98, r910, r911, r912, r913, r914, r915, r104, r105, r106, r107, r108, r109, r1010, r1011, r1012, r1013, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r124, r126, r128, r1210, r1211, r1212, r1213, r131, r132, r133, r134, r135, r136, r137, r138, r139, r1310, r140, r141);
    L541:
        r141 = r210;
        goto L542
    L537:
        r140 = r209;
        goto L539
    L533:
        r1310 = r208;
        goto L535
    L529:
        r139 = r207;
        goto L531
    L525:
        r138 = r206;
        goto L527
    L521:
        r137 = r205;
        goto L523
    L517:
        r136 = r204;
        goto L519
    L513:
        r135 = r203;
        goto L515
    L509:
        r134 = null;
        goto L511
    L505:
        r133 = null;
        goto L507
    L501:
        r132 = null;
        goto L503
    L497:
        r131 = r202;
        goto L499
    L493:
        r1213 = r201;
        goto L495
    L489:
        r130 = 67108864;
        r1212 = null;
        goto L491
    L485:
        r1211 = r200;
        goto L487
    L481:
        r1210 = r199;
        goto L483
    L477:
        r129 = 8388608;
        r128 = null;
        goto L479
    L473:
        r127 = 4194304;
        r126 = null;
        goto L475
    L469:
        r125 = 2097152;
        r124 = null;
        goto L471
    L465:
        r123 = 1048576;
        r122 = null;
        goto L467
    L461:
        r121 = r198;
        goto L463
    L457:
        r120 = r197;
        goto L459
    L453:
        r119 = r196;
        goto L455
    L449:
        r118 = r195;
        goto L451
    L445:
        r117 = r194;
        goto L447
    L441:
        r116 = r193;
        goto L443
    L437:
        r115 = null;
        goto L439
    L433:
        r114 = null;
        goto L435
    L429:
        r113 = null;
        goto L431
    L425:
        r112 = null;
        goto L427
    L421:
        r111 = null;
        goto L423
    L417:
        r110 = null;
        goto L419
    L413:
        r1013 = null;
        goto L415
    L409:
        r1012 = null;
        goto L411
    L405:
        r1011 = null;
        goto L407
    L401:
        r1010 = null;
        goto L403
    L397:
        r109 = null;
        goto L399
    L393:
        r108 = null;
        goto L395
    L389:
        r107 = null;
        goto L391
    L385:
        r106 = null;
        goto L387
    L381:
        r105 = null;
        goto L383
    L377:
        r104 = null;
        goto L379
    L373:
        r915 = null;
        goto L375
    L369:
        r914 = null;
        goto L371
    L365:
        r103 = 134217728;
        r913 = null;
        goto L367
    L361:
        r102 = 67108864;
        r912 = null;
        goto L363
    L357:
        r101 = 33554432;
        r911 = null;
        goto L359
    L353:
        r100 = 16777216;
        r910 = null;
        goto L355
    L349:
        r99 = 8388608;
        r98 = null;
        goto L351
    L345:
        r97 = 4194304;
        r96 = null;
        goto L347
    L341:
        r95 = 2097152;
        r94 = null;
        goto L343
    L337:
        r92 = 1048576;
        r91 = null;
        goto L339
    L333:
        r90 = 524288;
        r810 = null;
        goto L335
    L329:
        r6 = 262144;
        r89 = null;
        goto L331
    L325:
        r5 = 131072;
        r88 = null;
        goto L327
    L321:
        r4 = 65536;
        r87 = null;
        goto L323
    L317:
        r86 = null;
        goto L319
    L313:
        r85 = null;
        goto L315
    L309:
        r84 = r192;
        goto L311
    L305:
        r82 = r191;
        goto L307
    L301:
        r81 = r190;
        goto L303
    L297:
        r80 = null;
        goto L299
    L293:
        r79 = r189;
        goto L295
    L289:
        r78 = r188;
        goto L291
    L285:
        r77 = null;
        goto L287
    L281:
        r76 = null;
        goto L283
    L277:
        r75 = r187;
        goto L279
    L273:
        r74 = r186;
        goto L275
    L269:
        r73 = null;
        goto L271
    L265:
        r72 = r185;
        goto L267
    L261:
        r71 = r184;
        goto L263
    L257:
        r70 = null;
        goto L259
    L253:
        r69 = null;
        goto L255
    L249:
        r68 = r183;
        goto L251
    L245:
        r67 = r182;
        goto L247
    L241:
        r66 = r181;
        goto L243
    L237:
        r65 = r180;
        goto L239
    L233:
        r3 = 67108864;
        r64 = null;
        goto L235
    L229:
        r2 = 33554432;
        r63 = null;
        goto L231
    L225:
        r62 = r179;
        goto L227
    L221:
        r61 = r178;
        goto L223
    L217:
        r60 = r177;
        goto L219
    L213:
        r59 = r176;
        goto L215
    L209:
        r58 = r175;
        goto L211
    L205:
        r57 = r174;
        goto L207
    L201:
        r1 = 262144;
        r56 = null;
        goto L203
    L197:
        r55 = r173;
        goto L199
    L193:
        r54 = r172;
        goto L195
    L189:
        r53 = r171;
        goto L191
    L185:
        r52 = r170;
        goto L187
    L181:
        r51 = r169;
        goto L183
    L177:
        r50 = r168;
        goto L179
    L173:
        r49 = r167;
        goto L175
    L169:
        r48 = null;
        goto L171
    L165:
        r47 = null;
        goto L167
    L161:
        r46 = null;
        goto L163
    L157:
        r45 = null;
        goto L159
    L153:
        r44 = r166;
        goto L155
    L149:
        r43 = r165;
        goto L151
    L145:
        r42 = r164;
        goto L147
    L141:
        r41 = null;
        goto L143
    L137:
        r40 = r163;
        goto L139
    L133:
        r39 = null;
        goto L135
    L129:
        r38 = r162;
        goto L131
    L125:
        r37 = r161;
        goto L127
    L121:
        r36 = r160;
        goto L123
    L117:
        r35 = r159;
        goto L119
    L113:
        r34 = r158;
        goto L115
    L109:
        r33 = r157;
        goto L111
    L105:
        r32 = r156;
        goto L107
    L101:
        r31 = r155;
        goto L103
    L97:
        r30 = r154;
        goto L99
    L93:
        r29 = r153;
        goto L95
    L89:
        r28 = r152;
        goto L91
    L85:
        r27 = r151;
        goto L87
    L81:
        r26 = r150;
        goto L83
    L77:
        r25 = r149;
        goto L79
    L73:
        r24 = r148;
        goto L75
    L69:
        r23 = r147;
        goto L71
    L65:
        r22 = r146;
        goto L67
    L61:
        r21 = null;
        goto L63
    L57:
        r20 = null;
        goto L59
    L53:
        r19 = null;
        goto L55
    L49:
        r18 = null;
        goto L51
    L45:
        r17 = null;
        goto L47
    L41:
        r16 = r145;
        goto L43
    L37:
        r15 = null;
        goto L39
    L33:
        r14 = null;
        goto L35
    L29:
        r13 = null;
        goto L31
    L25:
        r12 = null;
        goto L27
    L21:
        r11 = null;
        goto L23
    L17:
        r10 = null;
        goto L19
    L13:
        r9 = null;
        goto L15
    L9:
        r8 = r144;
        goto L11
    L5:
        r7 = r143;
        goto L7
    }
}
