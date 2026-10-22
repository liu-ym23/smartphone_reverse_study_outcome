package kotlin.text;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010\u0011\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001f\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0086\u0002\u001a\u001f\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0086\u0002\u001a\u0015\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0087\n\u001a\u0018\u0010\u0017\u001a\u00020\u0010*\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u0018\u0010\u0018\u001a\u00020\u0010*\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u001c\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a:\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001aE\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010H\u0002¢\u0006\u0002\b!\u001a:\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010#\u001a\u00020\u0010*\u00020\u00022\u0006\u0010$\u001a\u00020\u0006\u001aD\u0010%\u001a\u0002H&\"\f\b\u0000\u0010'*\u00020\u0002*\u0002H&\"\u0004\b\u0001\u0010&*\u0002H'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010*\u001aD\u0010+\u001a\u0002H&\"\f\b\u0000\u0010'*\u00020\u0002*\u0002H&\"\u0004\b\u0001\u0010&*\u0002H'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010*\u001a&\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a;\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010 \u001a\u00020\u0010H\u0002¢\u0006\u0002\b.\u001a&\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010/\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u00100\u001a\u00020\u0006*\u00020\u00022\u0006\u00101\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a,\u00100\u001a\u00020\u0006*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\n\u00103\u001a\u00020\u0010*\u00020\u0002\u001a\r\u00104\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a\r\u00105\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a\r\u00106\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a \u00107\u001a\u00020\u0010*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a \u00108\u001a\u00020\u0010*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u00109\u001a\u00020:*\u00020\u0002H\u0086\u0002\u001a&\u0010;\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u0010;\u001a\u00020\u0006*\u00020\u00022\u0006\u0010/\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u0010<\u001a\u00020\u0006*\u00020\u00022\u0006\u00101\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a,\u0010<\u001a\u00020\u0006*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0010\u0010=\u001a\b\u0012\u0004\u0012\u00020\r0>*\u00020\u0002\u001a\u0010\u0010?\u001a\b\u0012\u0004\u0012\u00020\r0@*\u00020\u0002\u001a\u0015\u0010A\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0087\f\u001a\u000f\u0010B\u001a\u00020\r*\u0004\u0018\u00010\rH\u0087\b\u001a\u001c\u0010C\u001a\u00020\u0002*\u00020\u00022\u0006\u0010D\u001a\u00020\u00062\b\b\u0002\u0010E\u001a\u00020\u0014\u001a\u001c\u0010C\u001a\u00020\r*\u00020\r2\u0006\u0010D\u001a\u00020\u00062\b\b\u0002\u0010E\u001a\u00020\u0014\u001a\u001c\u0010F\u001a\u00020\u0002*\u00020\u00022\u0006\u0010D\u001a\u00020\u00062\b\b\u0002\u0010E\u001a\u00020\u0014\u001a\u001c\u0010F\u001a\u00020\r*\u00020\r2\u0006\u0010D\u001a\u00020\u00062\b\b\u0002\u0010E\u001a\u00020\u0014\u001aG\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00010>*\u00020\u00022\u000e\u0010H\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0I2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\bJ\u0010K\u001a=\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00010>*\u00020\u00022\u0006\u0010H\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0002\bJ\u001a4\u0010L\u001a\u00020\u0010*\u00020\u00022\u0006\u0010M\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010N\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u0012\u0010O\u001a\u00020\u0002*\u00020\u00022\u0006\u0010P\u001a\u00020\u0002\u001a\u0012\u0010O\u001a\u00020\r*\u00020\r2\u0006\u0010P\u001a\u00020\u0002\u001a\u001a\u0010Q\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006\u001a\u0012\u0010Q\u001a\u00020\u0002*\u00020\u00022\u0006\u0010R\u001a\u00020\u0001\u001a\u001d\u0010Q\u001a\u00020\r*\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010Q\u001a\u00020\r*\u00020\r2\u0006\u0010R\u001a\u00020\u0001H\u0087\b\u001a\u0012\u0010S\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010S\u001a\u00020\r*\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010T\u001a\u00020\u0002*\u00020\u00022\u0006\u0010U\u001a\u00020\u0002\u001a\u001a\u0010T\u001a\u00020\u0002*\u00020\u00022\u0006\u0010P\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010T\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u0002\u001a\u001a\u0010T\u001a\u00020\r*\u00020\r2\u0006\u0010P\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a.\u0010V\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0014\b\b\u0010W\u001a\u000e\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020\u00020XH\u0087\bø\u0001\u0000\u001a\u001d\u0010V\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Z\u001a\u00020\rH\u0087\b\u001a$\u0010[\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a$\u0010[\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0006\u0010Z\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a$\u0010]\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a$\u0010]\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0006\u0010Z\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a$\u0010^\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a$\u0010^\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0006\u0010Z\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a$\u0010_\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a$\u0010_\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0006\u0010Z\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a\u001d\u0010`\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Z\u001a\u00020\rH\u0087\b\u001a)\u0010a\u001a\u00020\r*\u00020\r2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140XH\u0087\bø\u0001\u0000¢\u0006\u0002\bb\u001a)\u0010a\u001a\u00020\r*\u00020\r2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00020XH\u0087\bø\u0001\u0000¢\u0006\u0002\bc\u001a\"\u0010d\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u0002\u001a\u001a\u0010d\u001a\u00020\u0002*\u00020\u00022\u0006\u0010R\u001a\u00020\u00012\u0006\u0010Z\u001a\u00020\u0002\u001a%\u0010d\u001a\u00020\r*\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u0002H\u0087\b\u001a\u001d\u0010d\u001a\u00020\r*\u00020\r2\u0006\u0010R\u001a\u00020\u00012\u0006\u0010Z\u001a\u00020\u0002H\u0087\b\u001a=\u0010e\u001a\b\u0012\u0004\u0012\u00020\r0@*\u00020\u00022\u0012\u0010H\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0I\"\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010f\u001a0\u0010e\u001a\b\u0012\u0004\u0012\u00020\r0@*\u00020\u00022\n\u0010H\u001a\u000202\"\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u001a/\u0010e\u001a\b\u0012\u0004\u0012\u00020\r0@*\u00020\u00022\u0006\u0010U\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0002\bg\u001a%\u0010e\u001a\b\u0012\u0004\u0012\u00020\r0@*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0087\b\u001a=\u0010h\u001a\b\u0012\u0004\u0012\u00020\r0>*\u00020\u00022\u0012\u0010H\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0I\"\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010i\u001a0\u0010h\u001a\b\u0012\u0004\u0012\u00020\r0>*\u00020\u00022\n\u0010H\u001a\u000202\"\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u001a%\u0010h\u001a\b\u0012\u0004\u0012\u00020\r0>*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0087\b\u001a\u001c\u0010j\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010j\u001a\u00020\u0010*\u00020\u00022\u0006\u0010P\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a$\u0010j\u001a\u00020\u0010*\u00020\u00022\u0006\u0010P\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010k\u001a\u00020\u0002*\u00020\u00022\u0006\u0010R\u001a\u00020\u0001\u001a\u001d\u0010k\u001a\u00020\u0002*\u00020\r2\u0006\u0010l\u001a\u00020\u00062\u0006\u0010m\u001a\u00020\u0006H\u0087\b\u001a\u001f\u0010n\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010-\u001a\u00020\u0006H\u0087\b\u001a\u0012\u0010n\u001a\u00020\r*\u00020\u00022\u0006\u0010R\u001a\u00020\u0001\u001a\u0012\u0010n\u001a\u00020\r*\u00020\r2\u0006\u0010R\u001a\u00020\u0001\u001a\u001c\u0010o\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\b\b\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010o\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010p\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\b\b\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010p\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010q\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\b\b\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010q\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010r\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\b\b\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010r\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a\f\u0010s\u001a\u00020\u0010*\u00020\rH\u0007\u001a\u0013\u0010t\u001a\u0004\u0018\u00010\u0010*\u00020\rH\u0007¢\u0006\u0002\u0010u\u001a\n\u0010v\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010v\u001a\u00020\u0002*\u00020\u00022\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100XH\u0086\bø\u0001\u0000\u001a\u0016\u0010v\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010v\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010v\u001a\u00020\r*\u00020\r2\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100XH\u0086\bø\u0001\u0000\u001a\u0016\u0010v\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\u001a\n\u0010x\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010x\u001a\u00020\u0002*\u00020\u00022\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100XH\u0086\bø\u0001\u0000\u001a\u0016\u0010x\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010x\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010x\u001a\u00020\r*\u00020\r2\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100XH\u0086\bø\u0001\u0000\u001a\u0016\u0010x\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\u001a\n\u0010y\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010y\u001a\u00020\u0002*\u00020\u00022\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100XH\u0086\bø\u0001\u0000\u001a\u0016\u0010y\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010y\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010y\u001a\u00020\r*\u00020\r2\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100XH\u0086\bø\u0001\u0000\u001a\u0016\u0010y\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006z"}, d2 = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "requireNonNegativeLimit", "", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "contentEqualsIgnoreCaseImpl", "contentEqualsImpl", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "ifBlank", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "chars", "", "isBlank", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", GXTemplateKey.STYLE_FONT_LINES, "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", FilterData.FilterOptionItem.Type.RANGE, "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceFirstChar", "replaceFirstCharWithChar", "replaceFirstCharWithCharSequence", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "toBooleanStrict", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    public StringsKt__StringsKt() {
    }

    private static final String orEmpty(String r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100;
    }

    public static IntRange getIndices(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new IntRange(0, r100.length() - 1);
    }

    public static int getLastIndex(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.length() - 1;
    }

    public static boolean isBlank(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = 0;
    L4:
        if (r101 >= r100.length()) goto L9;
        if (CharsKt.isWhitespace(r100.charAt(r101)) == false) goto L13;
        r101 = r101 + 1;
        goto L4
    L13:
        return false;
    L9:
        return true;
    }

    private static final boolean isEmpty(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.length() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean isNotBlank(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return !StringsKt.isBlank(r100);
    }

    private static final boolean isNotEmpty(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean isNullOrBlank(CharSequence r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        return false;
    }

    private static final boolean isNullOrEmpty(CharSequence r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.length() == 0) goto L7;
        return false;
    }

    public static final CharIterator iterator(final CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new AnonymousClass1(r100);
    }

    public static Sequence<String> lineSequence(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return StringsKt.splitToSequence$default(r100, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static List<String> lines(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return SequencesKt.toList(StringsKt.lineSequence(r100));
    }

    public static final void requireNonNegativeLimit(int r100) {
        if (r100 < 0) goto L4;
        boolean r101 = true;
    L5:
        if (r101 == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + r100).toString());
    L4:
        r101 = false;
        goto L5
    }

    public static final boolean toBooleanStrict(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (Intrinsics.areEqual(r100, "true") == false) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(r100, "false") == false) goto L10;
        return false;
    L10:
        throw new IllegalArgumentException("The string doesn't represent a boolean value: " + r100);
    }

    public static Boolean toBooleanStrictOrNull(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (Intrinsics.areEqual(r100, "true") == false) goto L6;
        return Boolean.TRUE;
    L6:
        if (Intrinsics.areEqual(r100, "false") == true) goto L11;
        return null;
    L11:
        return Boolean.FALSE;
    }

    public static CharSequence trim(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.length() - 1;
        int r102 = 0;
        boolean r103 = false;
    L3:
        if (r102 > r101) goto L16;
        if (r103 == true) goto L6;
        int r104 = r102;
    L7:
        boolean r105 = CharsKt.isWhitespace(r100.charAt(r104));
        if (r103 == false) goto L9;
        if (r105 == false) goto L16;
        r101 = r101 - 1;
        goto L3
    L9:
        if (r105 == false) goto L10;
        r102 = r102 + 1;
        goto L3
    L10:
        r103 = true;
        goto L3
    L6:
        r104 = r101;
    L16:
        return r100.subSequence(r102, r101 + 1);
    }

    public static CharSequence trimEnd(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.length() - 1;
        if (r101 < 0) goto L10;
    L4:
        int r102 = r101 - 1;
        if (CharsKt.isWhitespace(r100.charAt(r101)) == false) goto L14;
        if (r102 < 0) goto L10;
        r101 = r102;
        goto L4
    L14:
        return r100.subSequence(0, r101 + 1);
    L10:
        return "";
    }

    public static CharSequence trimStart(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.length();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        if (CharsKt.isWhitespace(r100.charAt(r102)) == false) goto L12;
        r102 = r102 + 1;
        goto L3
    L12:
        return r100.subSequence(r102, r100.length());
    L8:
        return "";
    }

    private static final String trim(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return StringsKt.trim(r100).toString();
    }

    private static final String trimEnd(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return StringsKt.trimEnd(r100).toString();
    }

    private static final String trimStart(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return StringsKt.trimStart(r100).toString();
    }

    private static final boolean contains(CharSequence r100, Regex r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "regex");
        return r101.containsMatchIn(r100);
    }

    public static final boolean contentEqualsIgnoreCaseImpl(CharSequence r100, CharSequence r101) {
        if ((r100 instanceof String) == true) goto L5;
    L8:
        if (r100 != r101) goto L11;
        return true;
    L11:
        if (r100 == null) goto L23;
        if (r101 == null) goto L23;
        if (r100.length() != r101.length()) goto L23;
        int r102 = r100.length();
        int r103 = 0;
    L17:
        if (r103 >= r102) goto L22;
        if (CharsKt.equals(r100.charAt(r103), r101.charAt(r103), true) == false) goto L20;
        r103 = r103 + 1;
        goto L17
    L20:
        return false;
    L22:
        return true;
    L23:
        return false;
    L5:
        if ((r101 instanceof String) == false) goto L8;
        return StringsKt.equals((String) r100, (String) r101, true);
    }

    public static final boolean contentEqualsImpl(CharSequence r100, CharSequence r101) {
        if ((r100 instanceof String) == false) goto L9;
        if ((r101 instanceof String) == false) goto L9;
        return Intrinsics.areEqual(r100, r101);
    L9:
        if (r100 != r101) goto L12;
        return true;
    L12:
        if (r100 == null) goto L24;
        if (r101 == null) goto L24;
        if (r100.length() != r101.length()) goto L24;
        int r102 = r100.length();
        int r103 = 0;
    L18:
        if (r103 >= r102) goto L23;
        if (r100.charAt(r103) != r101.charAt(r103)) goto L21;
        r103 = r103 + 1;
        goto L18
    L21:
        return false;
    L23:
        return true;
    L24:
        return false;
    }

    public static final boolean hasSurrogatePairAt(CharSequence r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 >= 0) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
    L14:
        return false;
    L10:
        if (Character.isHighSurrogate(r100.charAt(r101)) == false) goto L14;
        if (Character.isLowSurrogate(r100.charAt(r101 + 1)) == false) goto L14;
        return true;
    L5:
        if (r101 > (r100.length() - 2)) goto L7;
        r102 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <C extends CharSequence & R, R> R ifBlank(C r100, Function0<? extends R> r101) {
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        if (StringsKt.isBlank(r100) == true) goto L5;
        return r100;
    L5:
        return r101.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <C extends CharSequence & R, R> R ifEmpty(C r100, Function0<? extends R> r101) {
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        return r100;
    L8:
        return r101.invoke();
    L5:
        r102 = false;
        goto L6
    }

    private static final boolean matches(CharSequence r100, Regex r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "regex");
        return r101.matches(r100);
    }

    public static final CharSequence removePrefix(CharSequence r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "prefix");
        if (StringsKt.startsWith$default(r100, r101, false, 2, null) == false) goto L7;
        return r100.subSequence(r101.length(), r100.length());
    L7:
        return r100.subSequence(0, r100.length());
    }

    public static CharSequence removeRange(CharSequence r100, IntRange r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, FilterData.FilterOptionItem.Type.RANGE);
        return StringsKt.removeRange(r100, r101.getStart().intValue(), r101.getEndInclusive().intValue() + 1);
    }

    public static CharSequence removeSuffix(CharSequence r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "suffix");
        if (StringsKt.endsWith$default(r100, r101, false, 2, null) == false) goto L7;
        return r100.subSequence(0, r100.length() - r101.length());
    L7:
        return r100.subSequence(0, r100.length());
    }

    public static final CharSequence removeSurrounding(CharSequence r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "delimiter");
        return removeSurrounding(r100, r101, r101);
    }

    private static final String replaceFirstCharWithChar(String r100, Function1<? super Character, Character> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "transform");
        if (r100.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        return r100;
    L8:
        return r101.invoke(Character.valueOf(r100.charAt(0))).charValue() + r100.substring(1);
    L5:
        r102 = false;
        goto L6
    }

    private static final String replaceFirstCharWithCharSequence(String r100, Function1<? super Character, ? extends CharSequence> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "transform");
        if (r100.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        return r100;
    L8:
        return r101.invoke(Character.valueOf(r100.charAt(0))) + r100.substring(1);
    L5:
        r102 = false;
        goto L6
    }

    public static CharSequence subSequence(CharSequence r100, IntRange r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, FilterData.FilterOptionItem.Type.RANGE);
        return r100.subSequence(r101.getStart().intValue(), r101.getEndInclusive().intValue() + 1);
    }

    public static String substring(CharSequence r100, IntRange r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, FilterData.FilterOptionItem.Type.RANGE);
        return r100.subSequence(r101.getStart().intValue(), r101.getEndInclusive().intValue() + 1).toString();
    }

    public static final String trim(String r100, Function1<? super Character, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "predicate");
        int r102 = r100.length() - 1;
        int r103 = 0;
        boolean r104 = false;
    L3:
        if (r103 > r102) goto L16;
        if (r104 == true) goto L6;
        int r105 = r103;
    L7:
        boolean r106 = r101.invoke(Character.valueOf(r100.charAt(r105))).booleanValue();
        if (r104 == false) goto L9;
        if (r106 == false) goto L16;
        r102 = r102 - 1;
        goto L3
    L9:
        if (r106 == false) goto L10;
        r103 = r103 + 1;
        goto L3
    L10:
        r104 = true;
        goto L3
    L6:
        r105 = r102;
    L16:
        return r100.subSequence(r103, r102 + 1).toString();
    }

    public static String trimEnd(String r100, Function1<? super Character, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "predicate");
        int r102 = r100.length() - 1;
        if (r102 < 0) goto L10;
    L4:
        int r103 = r102 - 1;
        if (r101.invoke(Character.valueOf(r100.charAt(r102))).booleanValue() == false) goto L6;
        if (r103 < 0) goto L10;
        r102 = r103;
        goto L4
    L6:
        CharSequence r104 = r100.subSequence(0, r102 + 1);
    L12:
        return r104.toString();
    L10:
        r104 = "";
        goto L12
    }

    public static final String trimStart(String r100, Function1<? super Character, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "predicate");
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if (r101.invoke(Character.valueOf(r100.charAt(r103))).booleanValue() == false) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        CharSequence r104 = r100.subSequence(r103, r100.length());
    L10:
        return r104.toString();
    L8:
        r104 = "";
        goto L10
    }

    public static String removePrefix(String r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "prefix");
        if (StringsKt.startsWith$default(r100, r101, false, 2, null) == true) goto L5;
        return r100;
    L5:
        return r100.substring(r101.length());
    }

    private static final String removeRange(String r100, IntRange r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, FilterData.FilterOptionItem.Type.RANGE);
        return StringsKt.removeRange(r100, r101).toString();
    }

    public static String removeSuffix(String r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "suffix");
        if (StringsKt.endsWith$default(r100, r101, false, 2, null) == true) goto L5;
        return r100;
    L5:
        return r100.substring(0, r100.length() - r101.length());
    }

    public static String removeSurrounding(String r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "delimiter");
        return StringsKt.removeSurrounding(r100, r101, r101);
    }

    public static String substring(String r100, IntRange r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, FilterData.FilterOptionItem.Type.RANGE);
        return r100.substring(r101.getStart().intValue(), r101.getEndInclusive().intValue() + 1);
    }

    public static final CharSequence trim(CharSequence r100, Function1<? super Character, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "predicate");
        int r102 = r100.length() - 1;
        int r103 = 0;
        boolean r104 = false;
    L3:
        if (r103 > r102) goto L16;
        if (r104 == true) goto L6;
        int r105 = r103;
    L7:
        boolean r106 = r101.invoke(Character.valueOf(r100.charAt(r105))).booleanValue();
        if (r104 == false) goto L9;
        if (r106 == false) goto L16;
        r102 = r102 - 1;
        goto L3
    L9:
        if (r106 == false) goto L10;
        r103 = r103 + 1;
        goto L3
    L10:
        r104 = true;
        goto L3
    L6:
        r105 = r102;
    L16:
        return r100.subSequence(r103, r102 + 1);
    }

    public static final CharSequence trimEnd(CharSequence r100, Function1<? super Character, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "predicate");
        int r102 = r100.length() - 1;
        if (r102 < 0) goto L11;
    L4:
        int r103 = r102 - 1;
        if (r101.invoke(Character.valueOf(r100.charAt(r102))).booleanValue() == false) goto L7;
        if (r103 < 0) goto L15;
        r102 = r103;
        goto L4
    L15:
        return "";
    L7:
        return r100.subSequence(0, r102 + 1);
    L11:
        return "";
    }

    public static final CharSequence trimStart(CharSequence r100, Function1<? super Character, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "predicate");
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (r101.invoke(Character.valueOf(r100.charAt(r103))).booleanValue() == false) goto L7;
        r103 = r103 + 1;
        goto L3
    L7:
        return r100.subSequence(r103, r100.length());
    L9:
        return "";
    }

    public static String trim(String r100, char... r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "chars");
        int r102 = r100.length() - 1;
        int r103 = 0;
        boolean r104 = false;
    L3:
        if (r103 > r102) goto L16;
        if (r104 == true) goto L6;
        int r105 = r103;
    L7:
        boolean r106 = ArraysKt.contains(r101, r100.charAt(r105));
        if (r104 == false) goto L9;
        if (r106 == false) goto L16;
        r102 = r102 - 1;
        goto L3
    L9:
        if (r106 == false) goto L10;
        r103 = r103 + 1;
        goto L3
    L10:
        r104 = true;
        goto L3
    L6:
        r105 = r102;
    L16:
        return r100.subSequence(r103, r102 + 1).toString();
    }

    public static String trimEnd(String r100, char... r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "chars");
        int r102 = r100.length() - 1;
        if (r102 < 0) goto L10;
    L4:
        int r103 = r102 - 1;
        if (ArraysKt.contains(r101, r100.charAt(r102)) == false) goto L6;
        if (r103 < 0) goto L10;
        r102 = r103;
        goto L4
    L6:
        CharSequence r104 = r100.subSequence(0, r102 + 1);
    L12:
        return r104.toString();
    L10:
        r104 = "";
        goto L12
    }

    public static String trimStart(String r100, char... r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "chars");
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if (ArraysKt.contains(r101, r100.charAt(r103)) == false) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        CharSequence r104 = r100.subSequence(r103, r100.length());
    L10:
        return r104.toString();
    L8:
        r104 = "";
        goto L10
    }

    public static CharSequence trim(CharSequence r100, char... r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "chars");
        int r102 = r100.length() - 1;
        int r103 = 0;
        boolean r104 = false;
    L3:
        if (r103 > r102) goto L16;
        if (r104 == true) goto L6;
        int r105 = r103;
    L7:
        boolean r106 = ArraysKt.contains(r101, r100.charAt(r105));
        if (r104 == false) goto L9;
        if (r106 == false) goto L16;
        r102 = r102 - 1;
        goto L3
    L9:
        if (r106 == false) goto L10;
        r103 = r103 + 1;
        goto L3
    L10:
        r104 = true;
        goto L3
    L6:
        r105 = r102;
    L16:
        return r100.subSequence(r103, r102 + 1);
    }

    public static final CharSequence trimEnd(CharSequence r100, char... r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "chars");
        int r102 = r100.length() - 1;
        if (r102 < 0) goto L10;
    L4:
        int r103 = r102 - 1;
        if (ArraysKt.contains(r101, r100.charAt(r102)) == false) goto L14;
        if (r103 < 0) goto L10;
        r102 = r103;
        goto L4
    L14:
        return r100.subSequence(0, r102 + 1);
    L10:
        return "";
    }

    public static final CharSequence trimStart(CharSequence r100, char... r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "chars");
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if (ArraysKt.contains(r101, r100.charAt(r103)) == false) goto L12;
        r103 = r103 + 1;
        goto L3
    L12:
        return r100.subSequence(r103, r100.length());
    L8:
        return "";
    }

    public static final String commonPrefixWith(CharSequence r100, CharSequence r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        int r103 = Math.min(r100.length(), r101.length());
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L7;
        if (CharsKt.equals(r100.charAt(r104), r101.charAt(r104), r102) == false) goto L7;
        r104 = r104 + 1;
    L7:
        int r105 = r104 - 1;
        if (hasSurrogatePairAt(r100, r105) == false) goto L10;
    L11:
        r104 = r104 - 1;
    L13:
        return r100.subSequence(0, r104).toString();
    L10:
        if (hasSurrogatePairAt(r101, r105) == false) goto L13;
        goto L11
    }

    public static final String commonSuffixWith(CharSequence r100, CharSequence r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        int r103 = r100.length();
        int r104 = r101.length();
        int r105 = Math.min(r103, r104);
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L8;
        if (CharsKt.equals(r100.charAt((r103 - r106) - 1), r101.charAt((r104 - r106) - 1), r102) == false) goto L8;
        r106 = r106 + 1;
    L8:
        if (hasSurrogatePairAt(r100, (r103 - r106) - 1) == false) goto L10;
    L11:
        r106 = r106 - 1;
    L13:
        return r100.subSequence(r103 - r106, r103).toString();
    L10:
        if (hasSurrogatePairAt(r101, (r104 - r106) - 1) == false) goto L13;
        goto L11
    }

    public static boolean contains(CharSequence r110, CharSequence r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "other");
        if ((r111 instanceof String) == false) goto L8;
        if (StringsKt.indexOf$default(r110, (String) r111, 0, r112, 2, null) >= 0) goto L12;
    L10:
        return false;
    L12:
        return true;
    L8:
        if (indexOf$StringsKt__StringsKt$default(r110, r111, 0, r110.length(), r112, false, 16, null) < 0) goto L10;
        return true;
    }

    public static final boolean endsWith(CharSequence r100, CharSequence r101, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "suffix");
        if (r110 == true) goto L11;
        if ((r100 instanceof String) == false) goto L11;
        if ((r101 instanceof String) == false) goto L11;
        return StringsKt.endsWith$default((String) r100, (String) r101, false, 2, null);
    L11:
        return regionMatchesImpl(r100, r100.length() - r101.length(), r101, 0, r101.length(), r110);
    }

    public static final CharSequence padEnd(CharSequence r100, int r101, char r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 < 0) goto L15;
        if (r101 <= r100.length()) goto L7;
        StringBuilder r103 = new StringBuilder(r101);
        r103.append(r100);
        int r104 = r101 - r100.length();
        int r105 = 1;
        if (1 > r104) goto L13;
    L10:
        r103.append(r102);
        if (r105 == r104) goto L13;
        r105 = r105 + 1;
    L13:
        return r103;
    L7:
        return r100.subSequence(0, r100.length());
    L15:
        throw new IllegalArgumentException("Desired length " + r101 + " is less than zero.");
    }

    public static final CharSequence padStart(CharSequence r100, int r101, char r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 < 0) goto L16;
        if (r101 <= r100.length()) goto L7;
        StringBuilder r103 = new StringBuilder(r101);
        int r104 = r101 - r100.length();
        int r105 = 1;
        if (1 > r104) goto L13;
    L10:
        r103.append(r102);
        if (r105 == r104) goto L13;
        r105 = r105 + 1;
    L13:
        r103.append(r100);
        return r103;
    L7:
        return r100.subSequence(0, r100.length());
    L16:
        throw new IllegalArgumentException("Desired length " + r101 + " is less than zero.");
    }

    public static CharSequence removeRange(CharSequence r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r102 < r101) goto L11;
        if (r102 == r101) goto L7;
        StringBuilder r103 = new StringBuilder(r100.length() - (r102 - r101));
        r103.append(r100, 0, r101);
        r103.append(r100, r102, r100.length());
        return r103;
    L7:
        return r100.subSequence(0, r100.length());
    L11:
        throw new IndexOutOfBoundsException("End index (" + r102 + ") is less than start index (" + r101 + ").");
    }

    public static final CharSequence removeSurrounding(CharSequence r100, CharSequence r101, CharSequence r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "prefix");
        Intrinsics.checkNotNullParameter(r102, "suffix");
        if (r100.length() < (r101.length() + r102.length())) goto L11;
        if (StringsKt.startsWith$default(r100, r101, false, 2, null) == false) goto L11;
        if (StringsKt.endsWith$default(r100, r102, false, 2, null) == false) goto L11;
        return r100.subSequence(r101.length(), r100.length() - r102.length());
    L11:
        return r100.subSequence(0, r100.length());
    }

    private static final String replace(CharSequence r100, Regex r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "regex");
        Intrinsics.checkNotNullParameter(r102, "replacement");
        return r101.replace(r100, r102);
    }

    private static final String replaceFirst(CharSequence r100, Regex r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "regex");
        Intrinsics.checkNotNullParameter(r102, "replacement");
        return r101.replaceFirst(r100, r102);
    }

    public static CharSequence replaceRange(CharSequence r100, IntRange r101, CharSequence r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, FilterData.FilterOptionItem.Type.RANGE);
        Intrinsics.checkNotNullParameter(r102, "replacement");
        return StringsKt.replaceRange(r100, r101.getStart().intValue(), r101.getEndInclusive().intValue() + 1, r102);
    }

    private static final List<String> split(CharSequence r100, Regex r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "regex");
        return r101.split(r100, r102);
    }

    private static final Sequence<String> splitToSequence(CharSequence r100, Regex r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "regex");
        return r101.splitToSequence(r100, r102);
    }

    public static final boolean startsWith(CharSequence r100, CharSequence r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "prefix");
        if (r102 == true) goto L11;
        if ((r100 instanceof String) == false) goto L11;
        if ((r101 instanceof String) == false) goto L11;
        return StringsKt.startsWith$default((String) r100, (String) r101, false, 2, null);
    L11:
        return regionMatchesImpl(r100, 0, r101, 0, r101.length(), r102);
    }

    @Deprecated(message = "Use parameters named startIndex and endIndex.", replaceWith = @ReplaceWith(expression = "subSequence(startIndex = start, endIndex = end)", imports = {}))
    private static final CharSequence subSequence(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.subSequence(r101, r102);
    }

    private static final String substring(CharSequence r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.subSequence(r101, r102).toString();
    }

    public static String substringAfter(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "delimiter");
        Intrinsics.checkNotNullParameter(r102, "missingDelimiterValue");
        int r103 = StringsKt.indexOf$default(r100, r101, 0, false, 6, null);
        if (r103 != (-1)) goto L6;
        return r102;
    L6:
        return r100.substring(r103 + r101.length(), r100.length());
    }

    public static String substringAfterLast(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "delimiter");
        Intrinsics.checkNotNullParameter(r102, "missingDelimiterValue");
        int r103 = StringsKt.lastIndexOf$default(r100, r101, 0, false, 6, null);
        if (r103 != (-1)) goto L6;
        return r102;
    L6:
        return r100.substring(r103 + r101.length(), r100.length());
    }

    public static String substringBefore(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "delimiter");
        Intrinsics.checkNotNullParameter(r102, "missingDelimiterValue");
        int r103 = StringsKt.indexOf$default(r100, r101, 0, false, 6, null);
        if (r103 != (-1)) goto L6;
        return r102;
    L6:
        return r100.substring(0, r103);
    }

    public static String substringBeforeLast(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "delimiter");
        Intrinsics.checkNotNullParameter(r102, "missingDelimiterValue");
        int r103 = StringsKt.lastIndexOf$default(r100, r101, 0, false, 6, null);
        if (r103 != (-1)) goto L6;
        return r102;
    L6:
        return r100.substring(0, r103);
    }

    public static boolean contains(CharSequence r100, char r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (StringsKt.indexOf$default(r100, r101, 0, r102, 2, null) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean endsWith(CharSequence r100, char r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.length() > 0) goto L5;
    L7:
        return false;
    L5:
        if (CharsKt.equals(r100.charAt(StringsKt.getLastIndex(r100)), r101, r102) == false) goto L7;
        return true;
    }

    public static String padEnd(String r100, int r101, char r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return padEnd(r100, r101, r102).toString();
    }

    public static String padStart(String r100, int r101, char r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return padStart(r100, r101, r102).toString();
    }

    private static final String removeRange(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return StringsKt.removeRange(r100, r101, r102).toString();
    }

    public static String removeSurrounding(String r100, CharSequence r101, CharSequence r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "prefix");
        Intrinsics.checkNotNullParameter(r102, "suffix");
        if (r100.length() >= (r101.length() + r102.length())) goto L5;
        return r100;
    L5:
        if (StringsKt.startsWith$default(r100, r101, false, 2, null) == true) goto L7;
        return r100;
    L7:
        if (StringsKt.endsWith$default(r100, r102, false, 2, null) == true) goto L9;
        return r100;
    L9:
        return r100.substring(r101.length(), r100.length() - r102.length());
    }

    private static final String replace(CharSequence r100, Regex r101, Function1<? super MatchResult, ? extends CharSequence> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "regex");
        Intrinsics.checkNotNullParameter(r102, "transform");
        return r101.replace(r100, r102);
    }

    private static final String replaceRange(String r100, IntRange r101, CharSequence r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, FilterData.FilterOptionItem.Type.RANGE);
        Intrinsics.checkNotNullParameter(r102, "replacement");
        return StringsKt.replaceRange(r100, r101, r102).toString();
    }

    public static final boolean startsWith(CharSequence r100, char r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.length() > 0) goto L5;
        return false;
    L5:
        if (CharsKt.equals(r100.charAt(0), r101, r102) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static String substringAfter(String r100, char r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "missingDelimiterValue");
        int r103 = StringsKt.indexOf$default(r100, r101, 0, false, 6, null);
        if (r103 != (-1)) goto L6;
        return r102;
    L6:
        return r100.substring(r103 + 1, r100.length());
    }

    public static String substringAfterLast(String r100, char r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "missingDelimiterValue");
        int r103 = StringsKt.lastIndexOf$default(r100, r101, 0, false, 6, null);
        if (r103 != (-1)) goto L6;
        return r102;
    L6:
        return r100.substring(r103 + 1, r100.length());
    }

    public static String substringBefore(String r100, char r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "missingDelimiterValue");
        int r103 = StringsKt.indexOf$default(r100, r101, 0, false, 6, null);
        if (r103 != (-1)) goto L6;
        return r102;
    L6:
        return r100.substring(0, r103);
    }

    public static String substringBeforeLast(String r100, char r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "missingDelimiterValue");
        int r103 = StringsKt.lastIndexOf$default(r100, r101, 0, false, 6, null);
        if (r103 != (-1)) goto L6;
        return r102;
    L6:
        return r100.substring(0, r103);
    }

    public static final Pair<Integer, String> findAnyOf(CharSequence r100, Collection<String> r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "strings");
        return findAnyOf$StringsKt__StringsKt(r100, r101, r102, r103, false);
    }

    public static final Pair<Integer, String> findLastAnyOf(CharSequence r100, Collection<String> r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "strings");
        return findAnyOf$StringsKt__StringsKt(r100, r101, r102, r103, true);
    }

    public static int indexOf(CharSequence r100, String r101, int r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "string");
        if (r111 == true) goto L9;
        if ((r100 instanceof String) == false) goto L9;
        return ((String) r100).indexOf(r101, r110);
    L9:
        return indexOf$StringsKt__StringsKt$default(r100, r101, r110, r100.length(), r111, false, 16, null);
    }

    public static final int indexOfAny(CharSequence r100, char[] r101, int r102, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "chars");
        if (r110 == false) goto L5;
    L10:
        int r103 = RangesKt.coerceAtLeast(r102, 0);
        int r104 = StringsKt.getLastIndex(r100);
        if (r103 > r104) goto L23;
    L12:
        char r105 = r100.charAt(r103);
        int r106 = r101.length;
        int r107 = 0;
    L13:
        if (r107 >= r106) goto L18;
        if (CharsKt.equals(r101[r107], r105, r110) == true) goto L16;
        r107 = r107 + 1;
        goto L13
    L16:
        boolean r108 = true;
    L19:
        if (r108 == true) goto L20;
        if (r103 == r104) goto L29;
        r103 = r103 + 1;
        goto L12
    L29:
        return -1;
    L20:
        return r103;
    L18:
        r108 = false;
        goto L19
    L23:
        return -1;
    L5:
        if (r101.length != 1) goto L10;
        if ((r100 instanceof String) == false) goto L10;
        String r109 = (String) r100;
        return r109.indexOf(ArraysKt.single(r101), r102);
    }

    public static int lastIndexOf(CharSequence r100, String r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "string");
        if (r103 == true) goto L9;
        if ((r100 instanceof String) == false) goto L9;
        return ((String) r100).lastIndexOf(r101, r102);
    L9:
        return indexOf$StringsKt__StringsKt(r100, r101, r102, 0, r103, true);
    }

    public static final int lastIndexOfAny(CharSequence r100, char[] r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "chars");
        if (r103 == false) goto L5;
    L10:
        int r104 = RangesKt.coerceAtMost(r102, StringsKt.getLastIndex(r100));
    L12:
        if ((-1) >= r104) goto L22;
        char r105 = r100.charAt(r104);
        int r106 = r101.length;
        boolean r107 = false;
        int r108 = 0;
    L14:
        if (r108 >= r106) goto L19;
        if (CharsKt.equals(r101[r108], r105, r103) == true) goto L17;
        r108 = r108 + 1;
        goto L14
    L17:
        r107 = true;
    L19:
        if (r107 == true) goto L20;
        r104 = r104 - 1;
        goto L12
    L20:
        return r104;
    L22:
        return -1;
    L5:
        if (r101.length != 1) goto L10;
        if ((r100 instanceof String) == false) goto L10;
        return ((String) r100).lastIndexOf(ArraysKt.single(r101), r102);
    }

    public static final String replaceAfter(String r100, String r101, String r102, String r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "delimiter");
        Intrinsics.checkNotNullParameter(r102, "replacement");
        Intrinsics.checkNotNullParameter(r110, "missingDelimiterValue");
        int r103 = StringsKt.indexOf$default(r100, r101, 0, false, 6, null);
        if (r103 != (-1)) goto L6;
        return r110;
    L6:
        return StringsKt.replaceRange(r100, r103 + r101.length(), r100.length(), r102).toString();
    }

    public static final String replaceAfterLast(String r100, String r101, String r102, String r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "delimiter");
        Intrinsics.checkNotNullParameter(r102, "replacement");
        Intrinsics.checkNotNullParameter(r110, "missingDelimiterValue");
        int r103 = StringsKt.lastIndexOf$default(r100, r101, 0, false, 6, null);
        if (r103 != (-1)) goto L6;
        return r110;
    L6:
        return StringsKt.replaceRange(r100, r103 + r101.length(), r100.length(), r102).toString();
    }

    public static final String replaceBefore(String r100, String r101, String r102, String r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "delimiter");
        Intrinsics.checkNotNullParameter(r102, "replacement");
        Intrinsics.checkNotNullParameter(r110, "missingDelimiterValue");
        int r103 = StringsKt.indexOf$default(r100, r101, 0, false, 6, null);
        if (r103 != (-1)) goto L6;
        return r110;
    L6:
        return StringsKt.replaceRange(r100, 0, r103, r102).toString();
    }

    public static final String replaceBeforeLast(String r100, String r101, String r102, String r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "delimiter");
        Intrinsics.checkNotNullParameter(r102, "replacement");
        Intrinsics.checkNotNullParameter(r110, "missingDelimiterValue");
        int r103 = StringsKt.lastIndexOf$default(r100, r101, 0, false, 6, null);
        if (r103 != (-1)) goto L6;
        return r110;
    L6:
        return StringsKt.replaceRange(r100, 0, r103, r102).toString();
    }

    public static CharSequence replaceRange(CharSequence r100, int r101, int r102, CharSequence r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r103, "replacement");
        if (r102 < r101) goto L7;
        StringBuilder r104 = new StringBuilder();
        r104.append(r100, 0, r101);
        r104.append(r103);
        r104.append(r100, r102, r100.length());
        return r104;
    L7:
        throw new IndexOutOfBoundsException("End index (" + r102 + ") is less than start index (" + r101 + ").");
    }

    public static final List<String> split(CharSequence r100, String[] r101, boolean r102, int r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "delimiters");
        boolean r103 = true;
        if (r101.length != 1) goto L11;
        String r104 = r101[0];
        if (r104.length() == 0) goto L8;
        r103 = false;
    L8:
        if (r103 == true) goto L11;
        return split$StringsKt__StringsKt(r100, r104, r102, r110);
    L11:
        Iterable r105 = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(r100, r101, 0, r102, r110, 2, null));
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L13:
        if (r107.hasNext() == false) goto L15;
        r106.add(StringsKt.substring(r100, (IntRange) r107.next()));
        goto L13
    L15:
        return r106;
    }

    private static final List<String> split$StringsKt__StringsKt(CharSequence r100, String r101, boolean r102, int r110) {
        requireNonNegativeLimit(r110);
        int r103 = 0;
        int r104 = StringsKt.indexOf(r100, r101, 0, r102);
        if (r104 == (-1)) goto L23;
        if (r110 == 1) goto L23;
        if (r110 <= 0) goto L9;
        boolean r105 = true;
    L10:
        int r106 = 10;
        if (r105 == false) goto L13;
        r106 = RangesKt.coerceAtMost(r110, 10);
    L13:
        ArrayList r107 = new ArrayList(r106);
    L14:
        r107.add(r100.subSequence(r103, r104).toString());
        r103 = r101.length() + r104;
        if (r105 == true) goto L17;
    L18:
        r104 = StringsKt.indexOf(r100, r101, r103, r102);
        if (r104 != (-1)) goto L14;
    L20:
        r107.add(r100.subSequence(r103, r100.length()).toString());
        return r107;
    L17:
        if (r107.size() == (r110 - 1)) goto L20;
    L9:
        r105 = false;
    L23:
        return CollectionsKt.listOf(r100.toString());
    }

    public static final Sequence<String> splitToSequence(final CharSequence r100, char[] r101, boolean r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "delimiters");
        return SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(r100, r101, 0, r110, r111, 2, null), new AnonymousClass2(r100));
    }

    public static final boolean startsWith(CharSequence r100, CharSequence r101, int r102, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "prefix");
        if (r110 == true) goto L11;
        if ((r100 instanceof String) == false) goto L11;
        if ((r101 instanceof String) == false) goto L11;
        return StringsKt__StringsJVMKt.startsWith$default((String) r100, (String) r101, r102, false, 4, null);
    L11:
        return regionMatchesImpl(r100, r102, r101, 0, r101.length(), r110);
    }

    public static final int indexOf(CharSequence r100, char r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r103 == true) goto L9;
        if ((r100 instanceof String) == false) goto L9;
        return ((String) r100).indexOf(r101, r102);
    L9:
        return indexOfAny(r100, new char[]{r101}, r102, r103);
    }

    public static final int indexOfAny(CharSequence r100, Collection<String> r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "strings");
        Pair<Integer, String> r104 = findAnyOf$StringsKt__StringsKt(r100, r101, r102, r103, false);
        if (r104 != null) goto L7;
        return -1;
    L7:
        return r104.getFirst().intValue();
    }

    public static final int lastIndexOf(CharSequence r100, char r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r103 == true) goto L9;
        if ((r100 instanceof String) == false) goto L9;
        return ((String) r100).lastIndexOf(r101, r102);
    L9:
        return lastIndexOfAny(r100, new char[]{r101}, r102, r103);
    }

    public static final int lastIndexOfAny(CharSequence r100, Collection<String> r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "strings");
        Pair<Integer, String> r104 = findAnyOf$StringsKt__StringsKt(r100, r101, r102, r103, true);
        if (r104 != null) goto L7;
        return -1;
    L7:
        return r104.getFirst().intValue();
    }

    public static final String replaceAfter(String r100, char r101, String r102, String r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "replacement");
        Intrinsics.checkNotNullParameter(r110, "missingDelimiterValue");
        int r103 = StringsKt.indexOf$default(r100, r101, 0, false, 6, null);
        if (r103 != (-1)) goto L6;
        return r110;
    L6:
        return StringsKt.replaceRange(r100, r103 + 1, r100.length(), r102).toString();
    }

    public static final String replaceAfterLast(String r100, char r101, String r102, String r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "replacement");
        Intrinsics.checkNotNullParameter(r110, "missingDelimiterValue");
        int r103 = StringsKt.lastIndexOf$default(r100, r101, 0, false, 6, null);
        if (r103 != (-1)) goto L6;
        return r110;
    L6:
        return StringsKt.replaceRange(r100, r103 + 1, r100.length(), r102).toString();
    }

    public static final String replaceBefore(String r100, char r101, String r102, String r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "replacement");
        Intrinsics.checkNotNullParameter(r110, "missingDelimiterValue");
        int r103 = StringsKt.indexOf$default(r100, r101, 0, false, 6, null);
        if (r103 != (-1)) goto L6;
        return r110;
    L6:
        return StringsKt.replaceRange(r100, 0, r103, r102).toString();
    }

    public static final String replaceBeforeLast(String r100, char r101, String r102, String r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "replacement");
        Intrinsics.checkNotNullParameter(r110, "missingDelimiterValue");
        int r103 = StringsKt.lastIndexOf$default(r100, r101, 0, false, 6, null);
        if (r103 != (-1)) goto L6;
        return r110;
    L6:
        return StringsKt.replaceRange(r100, 0, r103, r102).toString();
    }

    private static final String replaceRange(String r100, int r101, int r102, CharSequence r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r103, "replacement");
        return StringsKt.replaceRange(r100, r101, r102, r103).toString();
    }

    public static final List<String> split(CharSequence r100, char[] r101, boolean r102, int r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "delimiters");
        if (r101.length == 1) goto L5;
        Iterable r103 = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(r100, r101, 0, r102, r110, 2, null));
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L8:
        if (r105.hasNext() == false) goto L10;
        r104.add(StringsKt.substring(r100, (IntRange) r105.next()));
        goto L8
    L10:
        return r104;
    L5:
        return split$StringsKt__StringsKt(r100, String.valueOf(r101[0]), r102, r110);
    }

    public static final Sequence<String> splitToSequence(final CharSequence r100, String[] r101, boolean r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "delimiters");
        return SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(r100, r101, 0, r110, r111, 2, null), new C123681(r100));
    }

    public static final /* synthetic */ Pair access$findAnyOf(CharSequence r100, Collection r101, int r102, boolean r103, boolean r104) {
        return findAnyOf$StringsKt__StringsKt(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ String commonPrefixWith$default(CharSequence r100, CharSequence r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return commonPrefixWith(r100, r101, r102);
    }

    public static /* synthetic */ String commonSuffixWith$default(CharSequence r100, CharSequence r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return commonSuffixWith(r100, r101, r102);
    }

    public static /* synthetic */ boolean contains$default(CharSequence r100, char r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return StringsKt.contains(r100, r101, r102);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence r100, char r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return StringsKt.endsWith(r100, r101, r102);
    }

    private static final Pair<Integer, String> findAnyOf$StringsKt__StringsKt(CharSequence r110, Collection<String> r111, int r112, boolean r113, boolean r114) {
        if (r113 == true) goto L15;
        if (r111.size() != 1) goto L15;
        String r115 = (String) CollectionsKt.single(r111);
        if (r114 == true) goto L9;
        int r116 = StringsKt.indexOf$default(r110, r115, r112, false, 4, null);
    L10:
        if (r116 >= 0) goto L13;
        return null;
    L13:
        return TuplesKt.to(Integer.valueOf(r116), r115);
    L9:
        r116 = StringsKt.lastIndexOf$default(r110, r115, r112, false, 4, null);
    L15:
        if (r114 == true) goto L17;
        IntProgression r117 = new IntRange(RangesKt.coerceAtLeast(r112, 0), r110.length());
    L19:
        if ((r110 instanceof String) == false) goto L38;
        int r118 = r117.getFirst();
        int r100 = r117.getLast();
        int r119 = r117.getStep();
        if (r119 <= 0) goto L23;
        if (r118 > r100) goto L23;
    L25:
        Iterator<T> r101 = r111.iterator();
    L27:
        if (r101.hasNext() == false) goto L31;
        Object r102 = r101.next();
        String r103 = (String) r102;
        if (StringsKt.regionMatches(r103, 0, (String) r110, r118, r103.length(), r113) == false) goto L27;
    L32:
        String r104 = (String) r102;
        if (r104 != null) goto L35;
        if (r118 == r100) goto L56;
        r118 = r118 + r119;
    L56:
        return null;
    L35:
        return TuplesKt.to(Integer.valueOf(r118), r104);
    L31:
        r102 = null;
    L23:
        if (r119 >= 0) goto L56;
        if (r100 > r118) goto L56;
    L38:
        int r120 = r117.getFirst();
        int r105 = r117.getLast();
        int r121 = r117.getStep();
        if (r121 <= 0) goto L41;
        if (r120 > r105) goto L41;
    L43:
        Iterator<T> r106 = r111.iterator();
    L45:
        if (r106.hasNext() == false) goto L49;
        Object r107 = r106.next();
        String r108 = (String) r107;
        if (regionMatchesImpl(r108, 0, r110, r120, r108.length(), r113) == false) goto L45;
    L50:
        String r109 = (String) r107;
        if (r109 != null) goto L53;
        if (r120 == r105) goto L56;
        r120 = r120 + r121;
        goto L43
    L53:
        return TuplesKt.to(Integer.valueOf(r120), r109);
    L49:
        r107 = null;
    L41:
        if (r121 >= 0) goto L56;
        if (r105 > r120) goto L56;
    L17:
        r117 = RangesKt.downTo(RangesKt.coerceAtMost(r112, StringsKt.getLastIndex(r110)), 0);
        goto L19
    }

    public static /* synthetic */ CharSequence padEnd$default(CharSequence r100, int r101, char r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = ' ';
    L6:
        return padEnd(r100, r101, r102);
    }

    public static /* synthetic */ CharSequence padStart$default(CharSequence r100, int r101, char r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = ' ';
    L6:
        return padStart(r100, r101, r102);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence r100, String[] r101, int r102, final boolean r103, int r104) {
        requireNonNegativeLimit(r104);
        final List r105 = ArraysKt.asList(r101);
        return new DelimitedRangesSequence(r100, r102, r104, new StringsKt__StringsKt$rangesDelimitedBy$2(r105, r103));
    }

    public static /* synthetic */ List split$default(CharSequence r100, Regex r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = 0;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "regex");
        return r101.split(r100, r102);
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence r100, Regex r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = 0;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "regex");
        return r101.splitToSequence(r100, r102);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence r100, char r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return startsWith(r100, r101, r102);
    }

    public static /* synthetic */ String substring$default(CharSequence r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = r100.length();
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.subSequence(r101, r102).toString();
    }

    public static /* synthetic */ String substringAfter$default(String r100, char r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = r100;
    L6:
        return StringsKt.substringAfter(r100, r101, r102);
    }

    public static /* synthetic */ String substringAfterLast$default(String r100, char r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = r100;
    L6:
        return StringsKt.substringAfterLast(r100, r101, r102);
    }

    public static /* synthetic */ String substringBefore$default(String r100, char r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = r100;
    L6:
        return StringsKt.substringBefore(r100, r101, r102);
    }

    public static /* synthetic */ String substringBeforeLast$default(String r100, char r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = r100;
    L6:
        return StringsKt.substringBeforeLast(r100, r101, r102);
    }

    public static /* synthetic */ boolean contains$default(CharSequence r100, CharSequence r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return StringsKt.contains(r100, r101, r102);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence r100, CharSequence r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return endsWith(r100, r101, r102);
    }

    public static /* synthetic */ String padEnd$default(String r100, int r101, char r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = ' ';
    L6:
        return StringsKt.padEnd(r100, r101, r102);
    }

    public static /* synthetic */ String padStart$default(String r100, int r101, char r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = ' ';
    L6:
        return StringsKt.padStart(r100, r101, r102);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence r100, final char[] r101, int r102, final boolean r103, int r104) {
        requireNonNegativeLimit(r104);
        return new DelimitedRangesSequence(r100, r102, r104, new StringsKt__StringsKt$rangesDelimitedBy$1(r101, r103));
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence r100, CharSequence r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return startsWith(r100, r101, r102);
    }

    public static /* synthetic */ String substringAfter$default(String r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = r100;
    L6:
        return StringsKt.substringAfter(r100, r101, r102);
    }

    public static /* synthetic */ String substringAfterLast$default(String r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = r100;
    L6:
        return StringsKt.substringAfterLast(r100, r101, r102);
    }

    public static /* synthetic */ String substringBefore$default(String r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = r100;
    L6:
        return StringsKt.substringBefore(r100, r101, r102);
    }

    public static /* synthetic */ String substringBeforeLast$default(String r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = r100;
    L6:
        return StringsKt.substringBeforeLast(r100, r101, r102);
    }

    public static /* synthetic */ Pair findAnyOf$default(CharSequence r100, Collection r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = false;
    L9:
        return findAnyOf(r100, r101, r102, r103);
    }

    public static /* synthetic */ Pair findLastAnyOf$default(CharSequence r100, Collection r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = StringsKt.getLastIndex(r100);
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = false;
    L9:
        return findLastAnyOf(r100, r101, r102, r103);
    }

    private static final int indexOf$StringsKt__StringsKt(CharSequence r100, CharSequence r101, int r102, int r103, boolean r110, boolean r111) {
        if (r111 == true) goto L5;
        IntProgression r112 = new IntRange(RangesKt.coerceAtLeast(r102, 0), RangesKt.coerceAtMost(r103, r100.length()));
    L7:
        if ((r100 instanceof String) == true) goto L9;
    L20:
        int r104 = r112.getFirst();
        int r105 = r112.getLast();
        int r113 = r112.getStep();
        if (r113 <= 0) goto L23;
        if (r104 > r105) goto L23;
    L25:
        int r106 = r104;
        if (regionMatchesImpl(r101, 0, r100, r106, r101.length(), r110) == true) goto L27;
        if (r104 == r105) goto L42;
        r104 = r104 + r113;
        goto L25
    L42:
        return -1;
    L27:
        return r104;
    L23:
        if (r113 >= 0) goto L39;
        if (r105 <= r104) goto L25;
        return -1;
    L39:
        return -1;
    L9:
        if ((r101 instanceof String) == false) goto L20;
        int r107 = r112.getFirst();
        int r108 = r112.getLast();
        int r114 = r112.getStep();
        if (r114 <= 0) goto L13;
        if (r107 > r108) goto L13;
    L15:
        int r109 = r107;
        if (StringsKt.regionMatches((String) r101, 0, (String) r100, r109, r101.length(), r110) == true) goto L17;
        if (r107 == r108) goto L41;
        r107 = r107 + r114;
        goto L15
    L41:
        return -1;
    L17:
        return r107;
    L13:
        if (r114 >= 0) goto L30;
        if (r108 <= r107) goto L15;
        return -1;
    L30:
        return -1;
    L5:
        r112 = RangesKt.downTo(RangesKt.coerceAtMost(r102, StringsKt.getLastIndex(r100)), RangesKt.coerceAtLeast(r103, 0));
        goto L7
    }

    public static /* synthetic */ int indexOf$default(CharSequence r100, char r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = false;
    L9:
        return indexOf(r100, r101, r102, r103);
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence r100, Collection r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = false;
    L9:
        return indexOfAny(r100, r101, r102, r103);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence r100, char r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = StringsKt.getLastIndex(r100);
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = false;
    L9:
        return lastIndexOf(r100, r101, r102, r103);
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence r100, Collection r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = StringsKt.getLastIndex(r100);
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = false;
    L9:
        return lastIndexOfAny(r100, r101, r102, r103);
    }

    public static final boolean regionMatchesImpl(CharSequence r100, int r101, CharSequence r102, int r103, int r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "other");
        if (r103 < 0) goto L18;
        if (r101 < 0) goto L18;
        if (r101 > (r100.length() - r104)) goto L18;
        if (r103 > (r102.length() - r104)) goto L18;
        int r106 = 0;
    L11:
        if (r106 >= r104) goto L16;
        if (CharsKt.equals(r100.charAt(r101 + r106), r102.charAt(r103 + r106), r105) == false) goto L14;
        r106 = r106 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    L18:
        return false;
    }

    public static /* synthetic */ String replaceAfter$default(String r100, char r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = r100;
    L6:
        return replaceAfter(r100, r101, r102, r103);
    }

    public static /* synthetic */ String replaceAfterLast$default(String r100, char r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = r100;
    L6:
        return replaceAfterLast(r100, r101, r102, r103);
    }

    public static /* synthetic */ String replaceBefore$default(String r100, char r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = r100;
    L6:
        return replaceBefore(r100, r101, r102, r103);
    }

    public static /* synthetic */ String replaceBeforeLast$default(String r100, char r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = r100;
    L6:
        return replaceBeforeLast(r100, r101, r102, r103);
    }

    public static /* synthetic */ List split$default(CharSequence r100, char[] r101, boolean r102, int r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = 0;
    L9:
        return split(r100, r101, r102, r103);
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence r100, char[] r101, boolean r102, int r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = 0;
    L9:
        return splitToSequence(r100, r101, r102, r103);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence r100, CharSequence r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = false;
    L6:
        return startsWith(r100, r101, r102, r103);
    }

    public static /* synthetic */ int indexOf$default(CharSequence r100, String r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = false;
    L9:
        return StringsKt.indexOf(r100, r101, r102, r103);
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence r100, char[] r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = false;
    L9:
        return indexOfAny(r100, r101, r102, r103);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence r100, String r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = StringsKt.getLastIndex(r100);
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = false;
    L9:
        return StringsKt.lastIndexOf(r100, r101, r102, r103);
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence r100, char[] r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = StringsKt.getLastIndex(r100);
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = false;
    L9:
        return lastIndexOfAny(r100, r101, r102, r103);
    }

    public static /* synthetic */ String replaceAfter$default(String r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = r100;
    L6:
        return replaceAfter(r100, r101, r102, r103);
    }

    public static /* synthetic */ String replaceAfterLast$default(String r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = r100;
    L6:
        return replaceAfterLast(r100, r101, r102, r103);
    }

    public static /* synthetic */ String replaceBefore$default(String r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = r100;
    L6:
        return replaceBefore(r100, r101, r102, r103);
    }

    public static /* synthetic */ String replaceBeforeLast$default(String r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = r100;
    L6:
        return replaceBeforeLast(r100, r101, r102, r103);
    }

    public static /* synthetic */ List split$default(CharSequence r100, String[] r101, boolean r102, int r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = 0;
    L9:
        return split(r100, r101, r102, r103);
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence r100, String[] r101, boolean r102, int r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = 0;
    L9:
        return splitToSequence(r100, r101, r102, r103);
    }

    public static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence r100, char[] r101, int r102, boolean r103, int r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = false;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r104 = 0;
    L12:
        return rangesDelimitedBy$StringsKt__StringsKt(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence r100, String[] r101, int r102, boolean r103, int r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = false;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r104 = 0;
    L12:
        return rangesDelimitedBy$StringsKt__StringsKt(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ int indexOf$StringsKt__StringsKt$default(CharSequence r100, CharSequence r101, int r102, int r103, boolean r110, boolean r111, int r112, Object r113) {
        if ((r112 & 16) == 0) goto L5;
        boolean r104 = false;
    L7:
        return indexOf$StringsKt__StringsKt(r100, r101, r102, r103, r110, r104);
    L5:
        r104 = r111;
        goto L7
    }
}
