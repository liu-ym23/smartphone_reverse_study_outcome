package com.larksuite.component.universe_design.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.radius.UDRadius;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b3\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000 \u009a\u0002*\u0010\b\u0000\u0010\u0001 \u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002:\n\u009a\u0002\u009b\u0002\u009c\u0002\u009d\u0002\u009e\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010Í\u0001\u001a\u00028\u00002\u0007\u0010Î\u0001\u001a\u00020\u0010H\u0016¢\u0006\u0003\u0010Ï\u0001J\u001a\u0010Í\u0001\u001a\u00028\u00002\t\b\u0001\u0010Î\u0001\u001a\u00020\u0016H\u0016¢\u0006\u0003\u0010Ð\u0001J\u0018\u0010Ñ\u0001\u001a\u00028\u00002\u0007\u0010Î\u0001\u001a\u00020\u0016H\u0016¢\u0006\u0003\u0010Ð\u0001J\u001a\u0010Ò\u0001\u001a\u00028\u00002\t\b\u0001\u0010Î\u0001\u001a\u00020\u0016H\u0016¢\u0006\u0003\u0010Ð\u0001J\u0018\u0010Ó\u0001\u001a\u00028\u00002\u0007\u0010Î\u0001\u001a\u00020\u0016H\u0016¢\u0006\u0003\u0010Ð\u0001J\u0018\u0010Ô\u0001\u001a\u00028\u00002\u0007\u0010Õ\u0001\u001a\u00020\u001fH\u0016¢\u0006\u0003\u0010Ö\u0001J\u0018\u0010×\u0001\u001a\u00028\u00002\u0007\u0010Î\u0001\u001a\u00020\u0016H\u0016¢\u0006\u0003\u0010Ð\u0001J\u0018\u0010Ø\u0001\u001a\u00028\u00002\u0007\u0010Î\u0001\u001a\u00020\u0016H\u0016¢\u0006\u0003\u0010Ð\u0001J3\u0010Ù\u0001\u001a\u00028\u00002\u0007\u0010Ú\u0001\u001a\u00020\u00162\u0007\u0010Û\u0001\u001a\u00020\u00162\u0007\u0010Ü\u0001\u001a\u00020\u00162\u0007\u0010Ý\u0001\u001a\u00020\u0016H\u0016¢\u0006\u0003\u0010Þ\u0001J\u0018\u0010ß\u0001\u001a\u00028\u00002\u0007\u0010Î\u0001\u001a\u00020\u0010H\u0016¢\u0006\u0003\u0010Ï\u0001J\u001a\u0010ß\u0001\u001a\u00028\u00002\t\b\u0001\u0010Î\u0001\u001a\u00020\u0016H\u0016¢\u0006\u0003\u0010Ð\u0001J\u0018\u0010à\u0001\u001a\u00028\u00002\u0007\u0010Î\u0001\u001a\u00020\u0016H\u0016¢\u0006\u0003\u0010Ð\u0001J\u001a\u0010á\u0001\u001a\u00028\u00002\t\b\u0001\u0010Î\u0001\u001a\u00020\u0016H\u0016¢\u0006\u0003\u0010Ð\u0001J3\u0010â\u0001\u001a\u00028\u00002\u0007\u0010Ú\u0001\u001a\u00020\u00162\u0007\u0010Û\u0001\u001a\u00020\u00162\u0007\u0010Ü\u0001\u001a\u00020\u00162\u0007\u0010Ý\u0001\u001a\u00020\u0016H\u0016¢\u0006\u0003\u0010Þ\u0001J\u0018\u0010ã\u0001\u001a\u00028\u00002\u0007\u0010Î\u0001\u001a\u00020\u0016H\u0016¢\u0006\u0003\u0010Ð\u0001J\u0018\u0010ä\u0001\u001a\u00028\u00002\u0007\u0010Î\u0001\u001a\u00020SH\u0016¢\u0006\u0003\u0010å\u0001J\u0018\u0010æ\u0001\u001a\u00028\u00002\u0007\u0010Î\u0001\u001a\u00020SH\u0016¢\u0006\u0003\u0010å\u0001J\u0018\u0010ç\u0001\u001a\u00028\u00002\u0007\u0010Î\u0001\u001a\u00020\u001fH\u0016¢\u0006\u0003\u0010Ö\u0001J\u0018\u0010è\u0001\u001a\u00028\u00002\u0007\u0010Î\u0001\u001a\u00020SH\u0016¢\u0006\u0003\u0010å\u0001J\u0018\u0010é\u0001\u001a\u00028\u00002\u0007\u0010Î\u0001\u001a\u00020YH\u0016¢\u0006\u0003\u0010ê\u0001J\u0018\u0010ë\u0001\u001a\u00028\u00002\u0007\u0010Î\u0001\u001a\u00020\u001fH\u0016¢\u0006\u0003\u0010Ö\u0001J\u0018\u0010ì\u0001\u001a\u00028\u00002\u0007\u0010Î\u0001\u001a\u00020\u001fH\u0016¢\u0006\u0003\u0010Ö\u0001J\u001a\u0010í\u0001\u001a\u00028\u00002\t\u0010Î\u0001\u001a\u0004\u0018\u00010pH\u0016¢\u0006\u0003\u0010î\u0001J\u001a\u0010ï\u0001\u001a\u00028\u00002\t\u0010Î\u0001\u001a\u0004\u0018\u00010vH\u0016¢\u0006\u0003\u0010ð\u0001J\u001b\u0010ñ\u0001\u001a\u00028\u00002\n\u0010Î\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0016¢\u0006\u0003\u0010ò\u0001J\u001a\u0010ó\u0001\u001a\u00028\u00002\t\b\u0001\u0010Î\u0001\u001a\u00020\u0016H\u0016¢\u0006\u0003\u0010Ð\u0001J\u001a\u0010ô\u0001\u001a\u00028\u00002\t\b\u0001\u0010Î\u0001\u001a\u00020\u0016H\u0016¢\u0006\u0003\u0010Ð\u0001J\u001b\u0010õ\u0001\u001a\u00028\u00002\n\u0010Î\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0016¢\u0006\u0003\u0010ò\u0001J\u001b\u0010ö\u0001\u001a\u00028\u00002\n\u0010Î\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0016¢\u0006\u0003\u0010ò\u0001J\u0018\u0010÷\u0001\u001a\u00028\u00002\u0007\u0010Î\u0001\u001a\u00020\u0016H\u0016¢\u0006\u0003\u0010Ð\u0001J\u001b\u0010ø\u0001\u001a\u00028\u00002\n\u0010Î\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0016¢\u0006\u0003\u0010ò\u0001J\u0018\u0010ù\u0001\u001a\u00028\u00002\u0007\u0010Î\u0001\u001a\u00020\u0016H\u0016¢\u0006\u0003\u0010Ð\u0001J\u0018\u0010ú\u0001\u001a\u00028\u00002\u0007\u0010Î\u0001\u001a\u00020\u001fH\u0016¢\u0006\u0003\u0010Ö\u0001J\u0018\u0010û\u0001\u001a\u00028\u00002\u0007\u0010Î\u0001\u001a\u00020\u0016H\u0016¢\u0006\u0003\u0010Ð\u0001J\u0018\u0010ü\u0001\u001a\u00028\u00002\u0007\u0010Î\u0001\u001a\u00020\u0016H\u0016¢\u0006\u0003\u0010Ð\u0001J3\u0010ý\u0001\u001a\u00028\u00002\u0007\u0010Ú\u0001\u001a\u00020\u00162\u0007\u0010Û\u0001\u001a\u00020\u00162\u0007\u0010Ü\u0001\u001a\u00020\u00162\u0007\u0010Ý\u0001\u001a\u00020\u0016H\u0016¢\u0006\u0003\u0010Þ\u0001J\u001a\u0010þ\u0001\u001a\u00028\u00002\t\b\u0001\u0010Î\u0001\u001a\u00020\u0016H\u0016¢\u0006\u0003\u0010Ð\u0001J\u001a\u0010ÿ\u0001\u001a\u00028\u00002\t\b\u0001\u0010Î\u0001\u001a\u00020\u0016H\u0016¢\u0006\u0003\u0010Ð\u0001J\u001a\u0010\u0080\u0002\u001a\u00028\u00002\t\b\u0001\u0010Î\u0001\u001a\u00020SH\u0016¢\u0006\u0003\u0010å\u0001J\u0019\u0010\u0081\u0002\u001a\u00028\u00002\b\u0010Î\u0001\u001a\u00030¹\u0001H\u0016¢\u0006\u0003\u0010\u0082\u0002J/\u0010\u0083\u0002\u001a\u00028\u00002\t\b\u0001\u0010\u0084\u0002\u001a\u00020\u00162\u0007\u0010\u0085\u0002\u001a\u00020\u00102\n\u0010\u0086\u0002\u001a\u0005\u0018\u00010Å\u0001H\u0016¢\u0006\u0003\u0010\u0087\u0002J1\u0010\u0083\u0002\u001a\u00028\u00002\t\b\u0001\u0010\u0084\u0002\u001a\u00020\u00162\t\b\u0001\u0010\u0088\u0002\u001a\u00020\u00162\n\u0010\u0086\u0002\u001a\u0005\u0018\u00010Å\u0001H\u0016¢\u0006\u0003\u0010\u0089\u0002J\u0019\u0010\u0083\u0002\u001a\u00028\u00002\b\u0010\u008a\u0002\u001a\u00030\u008b\u0002H\u0016¢\u0006\u0003\u0010\u008c\u0002J&\u0010\u008d\u0002\u001a\u00028\u00002\t\b\u0001\u0010\u0084\u0002\u001a\u00020\u00162\n\u0010\u008e\u0002\u001a\u0005\u0018\u00010Å\u0001H\u0016¢\u0006\u0003\u0010\u008f\u0002J\u001a\u0010\u0090\u0002\u001a\u00028\u00002\t\b\u0001\u0010\u0090\u0002\u001a\u00020\u0016H\u0016¢\u0006\u0003\u0010Ð\u0001J\u001a\u0010\u0091\u0002\u001a\u00028\u00002\t\b\u0001\u0010\u0090\u0002\u001a\u00020\u0016H\u0016¢\u0006\u0003\u0010Ð\u0001J\u001b\u0010\u0092\u0002\u001a\u00028\u00002\n\u0010\u0093\u0002\u001a\u0005\u0018\u00010È\u0001H\u0016¢\u0006\u0003\u0010\u0094\u0002J\u0016\u0010\u0095\u0002\u001a\u00028\u00002\u0007\u0010\u0095\u0002\u001a\u00020\n¢\u0006\u0003\u0010\u0096\u0002J\b\u0010\u0097\u0002\u001a\u00030\u0098\u0002J\b\u0010\u0099\u0002\u001a\u00030\u0098\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u00168\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0080\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010%\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0018\"\u0004\b'\u0010\u001aR\u001a\u0010(\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR\u001a\u0010+\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010\u001aR\u001a\u0010.\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0018\"\u0004\b0\u0010\u001aR\u001a\u00101\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0018\"\u0004\b3\u0010\u001aR\u001a\u00104\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0018\"\u0004\b6\u0010\u001aR\u001c\u00107\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0012\"\u0004\b9\u0010\u0014R\u001a\u0010:\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0018\"\u0004\b<\u0010\u001aR\u001e\u0010=\u001a\u00020\u00168\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0018\"\u0004\b?\u0010\u001aR\u001a\u0010@\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0018\"\u0004\bB\u0010\u001aR\u001a\u0010C\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0018\"\u0004\bE\u0010\u001aR\u001a\u0010F\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0018\"\u0004\bH\u0010\u001aR\u001a\u0010I\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0018\"\u0004\bK\u0010\u001aR\u001a\u0010L\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0018\"\u0004\bN\u0010\u001aR\u001a\u0010O\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0018\"\u0004\bQ\u0010\u001aR\u001a\u0010R\u001a\u00020SX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001a\u0010X\u001a\u00020YX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001a\u0010^\u001a\u00020SX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010U\"\u0004\b`\u0010WR\u001a\u0010a\u001a\u00020SX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010U\"\u0004\bc\u0010WR\u001a\u0010d\u001a\u00020\u001fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001e\u0010i\u001a\u0004\u0018\u00010\u001fX\u0080\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\bj\u0010!\"\u0004\bk\u0010#R\u001e\u0010l\u001a\u0004\u0018\u00010\u001fX\u0080\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\bm\u0010!\"\u0004\bn\u0010#R\u001c\u0010o\u001a\u0004\u0018\u00010pX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001c\u0010u\u001a\u0004\u0018\u00010vX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u001a\u0010{\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010\u0018\"\u0004\b}\u0010\u001aR\u001b\u0010~\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010\u0018\"\u0005\b\u0080\u0001\u0010\u001aR\u001d\u0010\u0081\u0001\u001a\u00020\u0016X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010\u0018\"\u0005\b\u0083\u0001\u0010\u001aR\u001d\u0010\u0084\u0001\u001a\u00020\u0016X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010\u0018\"\u0005\b\u0086\u0001\u0010\u001aR\"\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R\"\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u0088\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u008a\u0001\"\u0006\b\u008f\u0001\u0010\u008c\u0001R\"\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0088\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0091\u0001\u0010\u008a\u0001\"\u0006\b\u0092\u0001\u0010\u008c\u0001R\"\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0088\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0094\u0001\u0010\u008a\u0001\"\u0006\b\u0095\u0001\u0010\u008c\u0001R\u001d\u0010\u0096\u0001\u001a\u00020\u001fX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010f\"\u0005\b\u0098\u0001\u0010hR\u001d\u0010\u0099\u0001\u001a\u00020\u0016X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009a\u0001\u0010\u0018\"\u0005\b\u009b\u0001\u0010\u001aR\u001d\u0010\u009c\u0001\u001a\u00020\u0016X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009d\u0001\u0010\u0018\"\u0005\b\u009e\u0001\u0010\u001aR\u001d\u0010\u009f\u0001\u001a\u00020\u0016X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b \u0001\u0010\u0018\"\u0005\b¡\u0001\u0010\u001aR\u001d\u0010¢\u0001\u001a\u00020\u0016X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b£\u0001\u0010\u0018\"\u0005\b¤\u0001\u0010\u001aR\u001d\u0010¥\u0001\u001a\u00020\u0016X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¦\u0001\u0010\u0018\"\u0005\b§\u0001\u0010\u001aR\u001d\u0010¨\u0001\u001a\u00020\u0016X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b©\u0001\u0010\u0018\"\u0005\bª\u0001\u0010\u001aR\"\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R\u001d\u0010±\u0001\u001a\u00020SX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b²\u0001\u0010U\"\u0005\b³\u0001\u0010WR\u000f\u0010´\u0001\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010µ\u0001\u001a\u00020\u00168\u0000@\u0000X\u0081\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¶\u0001\u0010\u0018\"\u0005\b·\u0001\u0010\u001aR \u0010¸\u0001\u001a\u00030¹\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bº\u0001\u0010»\u0001\"\u0006\b¼\u0001\u0010½\u0001R\u001f\u0010¾\u0001\u001a\n\u0012\u0005\u0012\u00030À\u00010¿\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\bÁ\u0001\u0010Â\u0001R,\u0010Ã\u0001\u001a\u0017\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0005\u0012\u00030Å\u00010Ä\u00010¿\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\bÆ\u0001\u0010Â\u0001R\"\u0010Ç\u0001\u001a\u0005\u0018\u00010È\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÉ\u0001\u0010Ê\u0001\"\u0006\bË\u0001\u0010Ì\u0001¨\u0006\u009f\u0002"}, d2 = {"Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder;", ExifInterface.GPS_DIRECTION_TRUE, "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "mController", "Lcom/larksuite/component/universe_design/dialog/UDDialogController;", "getMController$universe_ui_dialog_release", "()Lcom/larksuite/component/universe_design/dialog/UDDialogController;", "setMController$universe_ui_dialog_release", "(Lcom/larksuite/component/universe_design/dialog/UDDialogController;)V", "mTitle", "", "getMTitle$universe_ui_dialog_release", "()Ljava/lang/CharSequence;", "setMTitle$universe_ui_dialog_release", "(Ljava/lang/CharSequence;)V", "mTitleSize", "", "getMTitleSize$universe_ui_dialog_release", "()I", "setMTitleSize$universe_ui_dialog_release", "(I)V", "mTitleTextColor", "getMTitleTextColor$universe_ui_dialog_release", "setMTitleTextColor$universe_ui_dialog_release", "mTitleTextStyleBold", "", "getMTitleTextStyleBold$universe_ui_dialog_release", "()Ljava/lang/Boolean;", "setMTitleTextStyleBold$universe_ui_dialog_release", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "mTitleLineCount", "getMTitleLineCount$universe_ui_dialog_release", "setMTitleLineCount$universe_ui_dialog_release", "mTitleGravity", "getMTitleGravity$universe_ui_dialog_release", "setMTitleGravity$universe_ui_dialog_release", "mTitlePaddingLeft", "getMTitlePaddingLeft$universe_ui_dialog_release", "setMTitlePaddingLeft$universe_ui_dialog_release", "mTitlePaddingTop", "getMTitlePaddingTop$universe_ui_dialog_release", "setMTitlePaddingTop$universe_ui_dialog_release", "mTitlePaddingRight", "getMTitlePaddingRight$universe_ui_dialog_release", "setMTitlePaddingRight$universe_ui_dialog_release", "mTitlePaddingBottom", "getMTitlePaddingBottom$universe_ui_dialog_release", "setMTitlePaddingBottom$universe_ui_dialog_release", "mMessage", "getMMessage$universe_ui_dialog_release", "setMMessage$universe_ui_dialog_release", "mMessageSize", "getMMessageSize$universe_ui_dialog_release", "setMMessageSize$universe_ui_dialog_release", "mMessageTextColor", "getMMessageTextColor$universe_ui_dialog_release", "setMMessageTextColor$universe_ui_dialog_release", "mMessagePaddingLeft", "getMMessagePaddingLeft$universe_ui_dialog_release", "setMMessagePaddingLeft$universe_ui_dialog_release", "mMessagePaddingTop", "getMMessagePaddingTop$universe_ui_dialog_release", "setMMessagePaddingTop$universe_ui_dialog_release", "mMessagePaddingRight", "getMMessagePaddingRight$universe_ui_dialog_release", "setMMessagePaddingRight$universe_ui_dialog_release", "mMessagePaddingBottom", "getMMessagePaddingBottom$universe_ui_dialog_release", "setMMessagePaddingBottom$universe_ui_dialog_release", "mMessageGravity", "getMMessageGravity$universe_ui_dialog_release", "setMMessageGravity$universe_ui_dialog_release", "mGravity", "getMGravity$universe_ui_dialog_release", "setMGravity$universe_ui_dialog_release", "mWidth", "", "getMWidth$universe_ui_dialog_release", "()F", "setMWidth$universe_ui_dialog_release", "(F)V", "mMaxWidth", "Lcom/larksuite/component/universe_design/dimension/UDDimension;", "getMMaxWidth$universe_ui_dialog_release", "()Lcom/larksuite/component/universe_design/dimension/UDDimension;", "setMMaxWidth$universe_ui_dialog_release", "(Lcom/larksuite/component/universe_design/dimension/UDDimension;)V", "mHeight", "getMHeight$universe_ui_dialog_release", "setMHeight$universe_ui_dialog_release", "mMaxHeight", "getMMaxHeight$universe_ui_dialog_release", "setMMaxHeight$universe_ui_dialog_release", "mAutoDismiss", "getMAutoDismiss$universe_ui_dialog_release", "()Z", "setMAutoDismiss$universe_ui_dialog_release", "(Z)V", "mCancelable", "getMCancelable$universe_ui_dialog_release", "setMCancelable$universe_ui_dialog_release", "mCanceledOnTouchOutside", "getMCanceledOnTouchOutside$universe_ui_dialog_release", "setMCanceledOnTouchOutside$universe_ui_dialog_release", "mOnCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "getMOnCancelListener$universe_ui_dialog_release", "()Landroid/content/DialogInterface$OnCancelListener;", "setMOnCancelListener$universe_ui_dialog_release", "(Landroid/content/DialogInterface$OnCancelListener;)V", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "getMOnDismissListener$universe_ui_dialog_release", "()Landroid/content/DialogInterface$OnDismissListener;", "setMOnDismissListener$universe_ui_dialog_release", "(Landroid/content/DialogInterface$OnDismissListener;)V", "mHeaderLayoutRes", "getMHeaderLayoutRes$universe_ui_dialog_release", "setMHeaderLayoutRes$universe_ui_dialog_release", "mContentLayoutRes", "getMContentLayoutRes$universe_ui_dialog_release", "setMContentLayoutRes$universe_ui_dialog_release", "mFooterLayoutRes", "getMFooterLayoutRes$universe_ui_dialog_release", "setMFooterLayoutRes$universe_ui_dialog_release", "mRootLayoutRes", "getMRootLayoutRes$universe_ui_dialog_release", "setMRootLayoutRes$universe_ui_dialog_release", "mHeaderLayout", "Landroid/view/View;", "getMHeaderLayout$universe_ui_dialog_release", "()Landroid/view/View;", "setMHeaderLayout$universe_ui_dialog_release", "(Landroid/view/View;)V", "mContentLayout", "getMContentLayout$universe_ui_dialog_release", "setMContentLayout$universe_ui_dialog_release", "mFooterLayout", "getMFooterLayout$universe_ui_dialog_release", "setMFooterLayout$universe_ui_dialog_release", "mRootLayout", "getMRootLayout$universe_ui_dialog_release", "setMRootLayout$universe_ui_dialog_release", "mAllowContentScroll", "getMAllowContentScroll$universe_ui_dialog_release", "setMAllowContentScroll$universe_ui_dialog_release", "mMarginInDp", "getMMarginInDp$universe_ui_dialog_release", "setMMarginInDp$universe_ui_dialog_release", "mTranslationOnY", "getMTranslationOnY$universe_ui_dialog_release", "setMTranslationOnY$universe_ui_dialog_release", "mPaddingLeftInDp", "getMPaddingLeftInDp$universe_ui_dialog_release", "setMPaddingLeftInDp$universe_ui_dialog_release", "mPaddingTopInDp", "getMPaddingTopInDp$universe_ui_dialog_release", "setMPaddingTopInDp$universe_ui_dialog_release", "mPaddingRightInDp", "getMPaddingRightInDp$universe_ui_dialog_release", "setMPaddingRightInDp$universe_ui_dialog_release", "mPaddingBottomInDp", "getMPaddingBottomInDp$universe_ui_dialog_release", "setMPaddingBottomInDp$universe_ui_dialog_release", "mBackground", "Landroid/graphics/drawable/Drawable;", "getMBackground$universe_ui_dialog_release", "()Landroid/graphics/drawable/Drawable;", "setMBackground$universe_ui_dialog_release", "(Landroid/graphics/drawable/Drawable;)V", "mMaskAlpha", "getMMaskAlpha$universe_ui_dialog_release", "setMMaskAlpha$universe_ui_dialog_release", "mStyle", "mAnimStyle", "getMAnimStyle$universe_ui_dialog_release", "setMAnimStyle$universe_ui_dialog_release", "mActionButtonsOrientation", "Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$ActionBottomOrientation;", "getMActionButtonsOrientation$universe_ui_dialog_release", "()Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$ActionBottomOrientation;", "setMActionButtonsOrientation$universe_ui_dialog_release", "(Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$ActionBottomOrientation;)V", "mActionButtons", "", "Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$ActionButtonInfo;", "getMActionButtons$universe_ui_dialog_release", "()Ljava/util/List;", "mViewClickInfos", "Landroid/util/Pair;", "Landroid/content/DialogInterface$OnClickListener;", "getMViewClickInfos$universe_ui_dialog_release", "mLifecycleCallback", "Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$LifecycleCallback;", "getMLifecycleCallback$universe_ui_dialog_release", "()Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$LifecycleCallback;", "setMLifecycleCallback$universe_ui_dialog_release", "(Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$LifecycleCallback;)V", "title", "value", "(Ljava/lang/CharSequence;)Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder;", "(I)Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder;", "titleSize", "titleColor", "titleLineCount", "titleBold", CommodityText.BOLD, "(Z)Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder;", "titleGravity", "messageGravity", "titlePadding", "left", "top", "right", "bottom", "(IIII)Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder;", "message", "messageTextSize", "messageTextColor", "messagePadding", GXTemplateKey.GAIAX_LAYER_GRAVITY, "width", "(F)Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder;", "height", "autoDismiss", "maxHeight", "maxWidth", "(Lcom/larksuite/component/universe_design/dimension/UDDimension;)Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder;", "cancelable", "cancelOnTouchOutside", "onCancelListener", "(Landroid/content/DialogInterface$OnCancelListener;)Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder;", "onDismissListener", "(Landroid/content/DialogInterface$OnDismissListener;)Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder;", "headerLayout", "(Landroid/view/View;)Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder;", "headerLayoutRes", "contentLayoutRes", "contentLayout", "footerLayout", "footerLayoutRes", "rootLayout", "rootLayoutRes", "allowContentScroll", "marginInDp", "translationOnY", "paddingInDp", "backgroundColor", "backgroundResource", "maskAlpha", "actionButtonOrientation", "(Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$ActionBottomOrientation;)Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder;", "addActionButton", "id", "text", "onClickListener", "(ILjava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder;", "textRes", "(IILandroid/content/DialogInterface$OnClickListener;)Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder;", "actionBuilder", "Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$ActionBuilder;", "(Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$ActionBuilder;)Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder;", "addViewClickListener", "listener", "(ILandroid/content/DialogInterface$OnClickListener;)Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder;", "style", "animStyle", "lifecycleCallback", "callback", "(Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$LifecycleCallback;)Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder;", "controller", "(Lcom/larksuite/component/universe_design/dialog/UDDialogController;)Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder;", "build", "Lcom/larksuite/component/universe_design/dialog/UDDialog;", "show", "Companion", "ActionBuilder", "ActionButtonInfo", "LifecycleCallback", "ActionBottomOrientation", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class UDBaseDialogBuilder<T extends UDBaseDialogBuilder<? extends T>> {
    public static final int $stable = 0;
    public static final b Companion = null;
    private static final int DialogMargin = 0;
    private static final UDDimension.Dp DialogMaxWidth = null;
    private final Context context;
    private final List<a> mActionButtons;
    private ActionBottomOrientation mActionButtonsOrientation;
    private boolean mAllowContentScroll;
    private int mAnimStyle;
    private boolean mAutoDismiss;
    private Drawable mBackground;
    private Boolean mCancelable;
    private Boolean mCanceledOnTouchOutside;
    private View mContentLayout;
    private int mContentLayoutRes;
    private UDDialogController mController;
    private View mFooterLayout;
    private int mFooterLayoutRes;
    private int mGravity;
    private View mHeaderLayout;
    private int mHeaderLayoutRes;
    private float mHeight;
    private c mLifecycleCallback;
    private int mMarginInDp;
    private float mMaskAlpha;
    private float mMaxHeight;
    private UDDimension mMaxWidth;
    private CharSequence mMessage;
    private int mMessageGravity;
    private int mMessagePaddingBottom;
    private int mMessagePaddingLeft;
    private int mMessagePaddingRight;
    private int mMessagePaddingTop;
    private int mMessageSize;
    private int mMessageTextColor;
    private DialogInterface.OnCancelListener mOnCancelListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private int mPaddingBottomInDp;
    private int mPaddingLeftInDp;
    private int mPaddingRightInDp;
    private int mPaddingTopInDp;
    private View mRootLayout;
    private int mRootLayoutRes;
    private int mStyle;
    private CharSequence mTitle;
    private int mTitleGravity;
    private int mTitleLineCount;
    private int mTitlePaddingBottom;
    private int mTitlePaddingLeft;
    private int mTitlePaddingRight;
    private int mTitlePaddingTop;
    private int mTitleSize;
    private int mTitleTextColor;
    private Boolean mTitleTextStyleBold;
    private int mTranslationOnY;
    private final List<Pair<Integer, DialogInterface.OnClickListener>> mViewClickInfos;
    private float mWidth;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$ActionBottomOrientation;", "", "<init>", "(Ljava/lang/String;I)V", "HORIZONTAL", "VERTICAL", "AUTO", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ActionBottomOrientation extends Enum<ActionBottomOrientation> {
        public static final ActionBottomOrientation AUTO = null;
        public static final ActionBottomOrientation HORIZONTAL = null;
        public static final ActionBottomOrientation VERTICAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ActionBottomOrientation[] f284831a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f284832b = null;

        public static EnumEntries<ActionBottomOrientation> getEntries() {
            return f284832b;
        }

        static {
            ActionBottomOrientation r100 = new ActionBottomOrientation("HORIZONTAL", 0);
            HORIZONTAL = r100;
            ActionBottomOrientation r101 = new ActionBottomOrientation("VERTICAL", 1);
            VERTICAL = r101;
            ActionBottomOrientation r102 = new ActionBottomOrientation("AUTO", 2);
            AUTO = r102;
            ActionBottomOrientation[] r103 = {r100, r101, r102};
            f284831a = r103;
            f284832b = EnumEntriesKt.enumEntries(r103);
        }

        public static ActionBottomOrientation[] values() {
            return (ActionBottomOrientation[]) f284831a.clone();
        }

        public static ActionBottomOrientation valueOf(String r100) {
            return (ActionBottomOrientation) r27.a.a(ActionBottomOrientation.class, r100);
        }

        public ActionBottomOrientation(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010(\u001a\u00020\u00002\b\b\u0001\u0010\u0004\u001a\u00020\u0005J\u0010\u0010\r\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\u0005J\u0010\u0010\r\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0005J\u0010\u0010\u0016\u001a\u00020\u00002\b\b\u0001\u0010)\u001a\u00020\u0005J\u0010\u0010\u0019\u001a\u00020\u00002\b\b\u0001\u0010)\u001a\u00020\u0005J\u0010\u0010\u001c\u001a\u00020\u00002\b\b\u0001\u0010)\u001a\u00020\u0005J\u0010\u0010\u001f\u001a\u00020\u00002\b\b\u0001\u0010)\u001a\u00020\u0005J\u0010\u0010\"\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010#J\u0006\u0010*\u001a\u00020+R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001e\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001e\u0010\u0019\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001e\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001e\u0010\u001f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$ActionBuilder;", "", "<init>", "()V", "actionLayoutId", "", "getActionLayoutId", "()I", "setActionLayoutId", "(I)V", "actionTextRes", "getActionTextRes", "setActionTextRes", "text", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textSize", "getTextSize", "setTextSize", "textColorRes", "getTextColorRes", "setTextColorRes", "textColor", "getTextColor", "setTextColor", "bgColorRes", "getBgColorRes", "setBgColorRes", "bgDrawableRes", "getBgDrawableRes", "setBgDrawableRes", "onClickListener", "Landroid/content/DialogInterface$OnClickListener;", "getOnClickListener", "()Landroid/content/DialogInterface$OnClickListener;", "setOnClickListener", "(Landroid/content/DialogInterface$OnClickListener;)V", "actionResId", "value", "build", "Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$ActionButtonInfo;", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class ActionBuilder {
        public static final int $stable = 8;
        private int actionLayoutId;
        private int actionTextRes;
        private int bgColorRes;
        private int bgDrawableRes;
        private DialogInterface.OnClickListener onClickListener;
        private CharSequence text;
        private int textColor;
        private int textColorRes;
        private int textSize;

        public ActionBuilder() {
        }

        public final a build() {
            return new a(this);
        }

        public final int getActionLayoutId() {
            return this.actionLayoutId;
        }

        public final int getActionTextRes() {
            return this.actionTextRes;
        }

        public final int getBgColorRes() {
            return this.bgColorRes;
        }

        public final int getBgDrawableRes() {
            return this.bgDrawableRes;
        }

        public final DialogInterface.OnClickListener getOnClickListener() {
            return this.onClickListener;
        }

        public final CharSequence getText() {
            return this.text;
        }

        public final int getTextColor() {
            return this.textColor;
        }

        public final int getTextColorRes() {
            return this.textColorRes;
        }

        public final int getTextSize() {
            return this.textSize;
        }

        public final ActionBuilder actionResId(int r100) {
            this.actionLayoutId = r100;
            return this;
        }

        public final ActionBuilder bgColorRes(int r100) {
            this.bgColorRes = r100;
            return this;
        }

        public final ActionBuilder bgDrawableRes(int r100) {
            this.bgDrawableRes = r100;
            return this;
        }

        public final ActionBuilder onClickListener(DialogInterface.OnClickListener r100) {
            this.onClickListener = r100;
            return this;
        }

        public final void setActionLayoutId(int r100) {
            this.actionLayoutId = r100;
        }

        public final void setActionTextRes(int r100) {
            this.actionTextRes = r100;
        }

        public final void setBgColorRes(int r100) {
            this.bgColorRes = r100;
        }

        public final void setBgDrawableRes(int r100) {
            this.bgDrawableRes = r100;
        }

        public final void setOnClickListener(DialogInterface.OnClickListener r100) {
            this.onClickListener = r100;
        }

        public final void setText(CharSequence r100) {
            this.text = r100;
        }

        public final void setTextColor(int r100) {
            this.textColor = r100;
        }

        public final void setTextColorRes(int r100) {
            this.textColorRes = r100;
        }

        public final void setTextSize(int r100) {
            this.textSize = r100;
        }

        public final ActionBuilder text(int r100) {
            this.actionTextRes = r100;
            return this;
        }

        public final ActionBuilder textColor(int r100) {
            this.textColor = r100;
            return this;
        }

        public final ActionBuilder textColorRes(int r100) {
            this.textColorRes = r100;
            return this;
        }

        public final ActionBuilder textSize(int r100) {
            this.textSize = r100;
            return this;
        }

        public final ActionBuilder text(CharSequence r100) {
            this.text = r100;
            return this;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f284833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f284834b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CharSequence f284835c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f284836d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f284837e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f284838f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f284839g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f284840h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final DialogInterface.OnClickListener f284841i;

        public a(ActionBuilder r100) {
            Intrinsics.checkNotNullParameter(r100, "actionBuilder");
            this.f284833a = r100.getActionLayoutId();
            this.f284834b = r100.getActionTextRes();
            this.f284835c = r100.getText();
            this.f284836d = r100.getTextSize();
            this.f284837e = r100.getTextColorRes();
            this.f284838f = r100.getTextColor();
            this.f284839g = r100.getBgColorRes();
            this.f284840h = r100.getBgDrawableRes();
            this.f284841i = r100.getOnClickListener();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public interface c {
        void a(UDDialog r100);

        void beforeCreate(UDDialog r100);
    }

    static {
        Companion = new b();
        $stable = 8;
        DialogMaxWidth = new UDDimension.Dp(303);
        DialogMargin = 36;
    }

    public final UDDialog build() {
        if (this.mStyle != 0) goto L14;
        float r100 = this.mHeight;
        if (r100 != 1.0f) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
    L13:
        UDDialog r102 = new UDDialog(this.context, R.style.UDDialog_NoFloating);
    L16:
        if (this.mController != null) goto L18;
        this.mController = new UDDialogController(this.context);
    L18:
        UDDialogController r103 = this.mController;
        if (r103 == null) goto L21;
        r103.apply(this, r102);
    L21:
        return r102;
    L10:
        if (((int) r100) == (-1)) goto L13;
        r102 = new UDDialog(this.context);
        goto L16
    L7:
        r101 = false;
        goto L8
    L14:
        r102 = new UDDialog(this.context, this.mStyle);
        goto L16
    }

    public final UDDialog show() {
        UDDialog r100 = build();
        INVOKEVIRTUAL_com_larksuite_component_universe_design_dialog_UDBaseDialogBuilder_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r100);
        return r100;
    }

    public static final /* synthetic */ int access$getDialogMargin$cp() {
        return DialogMargin;
    }

    public static final /* synthetic */ UDDimension.Dp access$getDialogMaxWidth$cp() {
        return DialogMaxWidth;
    }

    public final Context getContext() {
        return this.context;
    }

    public final List<a> getMActionButtons$universe_ui_dialog_release() {
        return this.mActionButtons;
    }

    public final ActionBottomOrientation getMActionButtonsOrientation$universe_ui_dialog_release() {
        return this.mActionButtonsOrientation;
    }

    public final boolean getMAllowContentScroll$universe_ui_dialog_release() {
        return this.mAllowContentScroll;
    }

    public final int getMAnimStyle$universe_ui_dialog_release() {
        return this.mAnimStyle;
    }

    public final boolean getMAutoDismiss$universe_ui_dialog_release() {
        return this.mAutoDismiss;
    }

    public final Drawable getMBackground$universe_ui_dialog_release() {
        return this.mBackground;
    }

    public final Boolean getMCancelable$universe_ui_dialog_release() {
        return this.mCancelable;
    }

    public final Boolean getMCanceledOnTouchOutside$universe_ui_dialog_release() {
        return this.mCanceledOnTouchOutside;
    }

    public final View getMContentLayout$universe_ui_dialog_release() {
        return this.mContentLayout;
    }

    public final int getMContentLayoutRes$universe_ui_dialog_release() {
        return this.mContentLayoutRes;
    }

    public final UDDialogController getMController$universe_ui_dialog_release() {
        return this.mController;
    }

    public final View getMFooterLayout$universe_ui_dialog_release() {
        return this.mFooterLayout;
    }

    public final int getMFooterLayoutRes$universe_ui_dialog_release() {
        return this.mFooterLayoutRes;
    }

    public final int getMGravity$universe_ui_dialog_release() {
        return this.mGravity;
    }

    public final View getMHeaderLayout$universe_ui_dialog_release() {
        return this.mHeaderLayout;
    }

    public final int getMHeaderLayoutRes$universe_ui_dialog_release() {
        return this.mHeaderLayoutRes;
    }

    public final float getMHeight$universe_ui_dialog_release() {
        return this.mHeight;
    }

    public final c getMLifecycleCallback$universe_ui_dialog_release() {
        return this.mLifecycleCallback;
    }

    public final int getMMarginInDp$universe_ui_dialog_release() {
        return this.mMarginInDp;
    }

    public final float getMMaskAlpha$universe_ui_dialog_release() {
        return this.mMaskAlpha;
    }

    public final float getMMaxHeight$universe_ui_dialog_release() {
        return this.mMaxHeight;
    }

    public final UDDimension getMMaxWidth$universe_ui_dialog_release() {
        return this.mMaxWidth;
    }

    public final CharSequence getMMessage$universe_ui_dialog_release() {
        return this.mMessage;
    }

    public final int getMMessageGravity$universe_ui_dialog_release() {
        return this.mMessageGravity;
    }

    public final int getMMessagePaddingBottom$universe_ui_dialog_release() {
        return this.mMessagePaddingBottom;
    }

    public final int getMMessagePaddingLeft$universe_ui_dialog_release() {
        return this.mMessagePaddingLeft;
    }

    public final int getMMessagePaddingRight$universe_ui_dialog_release() {
        return this.mMessagePaddingRight;
    }

    public final int getMMessagePaddingTop$universe_ui_dialog_release() {
        return this.mMessagePaddingTop;
    }

    public final int getMMessageSize$universe_ui_dialog_release() {
        return this.mMessageSize;
    }

    public final int getMMessageTextColor$universe_ui_dialog_release() {
        return this.mMessageTextColor;
    }

    public final DialogInterface.OnCancelListener getMOnCancelListener$universe_ui_dialog_release() {
        return this.mOnCancelListener;
    }

    public final DialogInterface.OnDismissListener getMOnDismissListener$universe_ui_dialog_release() {
        return this.mOnDismissListener;
    }

    public final int getMPaddingBottomInDp$universe_ui_dialog_release() {
        return this.mPaddingBottomInDp;
    }

    public final int getMPaddingLeftInDp$universe_ui_dialog_release() {
        return this.mPaddingLeftInDp;
    }

    public final int getMPaddingRightInDp$universe_ui_dialog_release() {
        return this.mPaddingRightInDp;
    }

    public final int getMPaddingTopInDp$universe_ui_dialog_release() {
        return this.mPaddingTopInDp;
    }

    public final View getMRootLayout$universe_ui_dialog_release() {
        return this.mRootLayout;
    }

    public final int getMRootLayoutRes$universe_ui_dialog_release() {
        return this.mRootLayoutRes;
    }

    public final CharSequence getMTitle$universe_ui_dialog_release() {
        return this.mTitle;
    }

    public final int getMTitleGravity$universe_ui_dialog_release() {
        return this.mTitleGravity;
    }

    public final int getMTitleLineCount$universe_ui_dialog_release() {
        return this.mTitleLineCount;
    }

    public final int getMTitlePaddingBottom$universe_ui_dialog_release() {
        return this.mTitlePaddingBottom;
    }

    public final int getMTitlePaddingLeft$universe_ui_dialog_release() {
        return this.mTitlePaddingLeft;
    }

    public final int getMTitlePaddingRight$universe_ui_dialog_release() {
        return this.mTitlePaddingRight;
    }

    public final int getMTitlePaddingTop$universe_ui_dialog_release() {
        return this.mTitlePaddingTop;
    }

    public final int getMTitleSize$universe_ui_dialog_release() {
        return this.mTitleSize;
    }

    public final int getMTitleTextColor$universe_ui_dialog_release() {
        return this.mTitleTextColor;
    }

    public final Boolean getMTitleTextStyleBold$universe_ui_dialog_release() {
        return this.mTitleTextStyleBold;
    }

    public final int getMTranslationOnY$universe_ui_dialog_release() {
        return this.mTranslationOnY;
    }

    public final List<Pair<Integer, DialogInterface.OnClickListener>> getMViewClickInfos$universe_ui_dialog_release() {
        return this.mViewClickInfos;
    }

    public final float getMWidth$universe_ui_dialog_release() {
        return this.mWidth;
    }

    public UDBaseDialogBuilder(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
        this.mTitleSize = -1;
        this.mTitleTextColor = -1;
        this.mTitleLineCount = 2;
        this.mTitleGravity = -1;
        this.mTitlePaddingLeft = -1;
        this.mTitlePaddingTop = -1;
        this.mTitlePaddingRight = -1;
        this.mTitlePaddingBottom = -1;
        this.mMessageSize = -1;
        this.mMessageTextColor = -1;
        this.mMessagePaddingLeft = -1;
        this.mMessagePaddingTop = -1;
        this.mMessagePaddingRight = -1;
        this.mMessagePaddingBottom = -1;
        this.mMessageGravity = -1;
        this.mGravity = 17;
        this.mWidth = 1.0f;
        this.mMaxWidth = new UDDimension.a(Integer.MAX_VALUE);
        this.mHeight = -2.0f;
        this.mMaxHeight = 1.0f;
        this.mAutoDismiss = true;
        this.mAllowContentScroll = true;
        this.mMaskAlpha = -1.0f;
        this.mActionButtonsOrientation = ActionBottomOrientation.AUTO;
        this.mActionButtons = new ArrayList();
        this.mViewClickInfos = new ArrayList();
    }

    public static void INVOKEVIRTUAL_com_larksuite_component_universe_design_dialog_UDBaseDialogBuilder_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(UDDialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T actionButtonOrientation(ActionBottomOrientation r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.mActionButtonsOrientation = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T addActionButton(ActionBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "actionBuilder");
        this.mActionButtons.add(r100.build());
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T allowContentScroll(boolean r100) {
        this.mAllowContentScroll = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T animStyle(int r100) {
        this.mAnimStyle = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T autoDismiss(boolean r100) {
        this.mAutoDismiss = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T backgroundColor(int r100) {
        if (r100 != 0) goto L4;
        t08.a r101 = null;
    L5:
        this.mBackground = r101;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    L4:
        t08.a r102 = new t08.a();
        r102.setColor(ContextCompat.getColor(this.context, r100));
        r102.setCornerRadius(UDRadius.L.getRadiusSize(this.context));
        r101 = r102;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T backgroundResource(int r100) {
        if (r100 != 0) goto L4;
        Drawable r101 = null;
    L5:
        this.mBackground = r101;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    L4:
        r101 = ContextCompat.getDrawable(this.context, r100);
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T cancelOnTouchOutside(boolean r100) {
        this.mCanceledOnTouchOutside = Boolean.valueOf(r100);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T cancelable(boolean r100) {
        this.mCancelable = Boolean.valueOf(r100);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T contentLayout(View r100) {
        this.mContentLayout = r100;
        this.mContentLayoutRes = 0;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T contentLayoutRes(int r100) {
        this.mContentLayoutRes = r100;
        this.mContentLayout = null;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T controller(UDDialogController r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        this.mController = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T footerLayout(View r100) {
        this.mFooterLayout = r100;
        this.mFooterLayoutRes = 0;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T footerLayoutRes(int r100) {
        this.mFooterLayoutRes = r100;
        this.mFooterLayout = null;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T gravity(int r100) {
        this.mGravity = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T headerLayout(View r100) {
        this.mHeaderLayout = r100;
        this.mHeaderLayoutRes = 0;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T headerLayoutRes(int r100) {
        this.mHeaderLayoutRes = r100;
        this.mHeaderLayout = null;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T height(float r100) {
        this.mHeight = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T lifecycleCallback(c r100) {
        this.mLifecycleCallback = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T marginInDp(int r100) {
        this.mMarginInDp = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T maskAlpha(float r100) {
        this.mMaskAlpha = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T maxHeight(float r100) {
        this.mMaxHeight = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T maxWidth(UDDimension r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.mMaxWidth = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T message(int r100) {
        this.mMessage = this.context.getString(r100);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T messageGravity(int r100) {
        this.mMessageGravity = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T messageTextColor(int r100) {
        this.mMessageTextColor = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T messageTextSize(int r100) {
        this.mMessageSize = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T onCancelListener(DialogInterface.OnCancelListener r100) {
        this.mOnCancelListener = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T onDismissListener(DialogInterface.OnDismissListener r100) {
        this.mOnDismissListener = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T rootLayout(View r100) {
        this.mRootLayout = r100;
        this.mRootLayoutRes = 0;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T rootLayoutRes(int r100) {
        this.mRootLayout = null;
        this.mRootLayoutRes = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    public final void setMActionButtonsOrientation$universe_ui_dialog_release(ActionBottomOrientation r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mActionButtonsOrientation = r100;
    }

    public final void setMAllowContentScroll$universe_ui_dialog_release(boolean r100) {
        this.mAllowContentScroll = r100;
    }

    public final void setMAnimStyle$universe_ui_dialog_release(int r100) {
        this.mAnimStyle = r100;
    }

    public final void setMAutoDismiss$universe_ui_dialog_release(boolean r100) {
        this.mAutoDismiss = r100;
    }

    public final void setMBackground$universe_ui_dialog_release(Drawable r100) {
        this.mBackground = r100;
    }

    public final void setMCancelable$universe_ui_dialog_release(Boolean r100) {
        this.mCancelable = r100;
    }

    public final void setMCanceledOnTouchOutside$universe_ui_dialog_release(Boolean r100) {
        this.mCanceledOnTouchOutside = r100;
    }

    public final void setMContentLayout$universe_ui_dialog_release(View r100) {
        this.mContentLayout = r100;
    }

    public final void setMContentLayoutRes$universe_ui_dialog_release(int r100) {
        this.mContentLayoutRes = r100;
    }

    public final void setMController$universe_ui_dialog_release(UDDialogController r100) {
        this.mController = r100;
    }

    public final void setMFooterLayout$universe_ui_dialog_release(View r100) {
        this.mFooterLayout = r100;
    }

    public final void setMFooterLayoutRes$universe_ui_dialog_release(int r100) {
        this.mFooterLayoutRes = r100;
    }

    public final void setMGravity$universe_ui_dialog_release(int r100) {
        this.mGravity = r100;
    }

    public final void setMHeaderLayout$universe_ui_dialog_release(View r100) {
        this.mHeaderLayout = r100;
    }

    public final void setMHeaderLayoutRes$universe_ui_dialog_release(int r100) {
        this.mHeaderLayoutRes = r100;
    }

    public final void setMHeight$universe_ui_dialog_release(float r100) {
        this.mHeight = r100;
    }

    public final void setMLifecycleCallback$universe_ui_dialog_release(c r100) {
        this.mLifecycleCallback = r100;
    }

    public final void setMMarginInDp$universe_ui_dialog_release(int r100) {
        this.mMarginInDp = r100;
    }

    public final void setMMaskAlpha$universe_ui_dialog_release(float r100) {
        this.mMaskAlpha = r100;
    }

    public final void setMMaxHeight$universe_ui_dialog_release(float r100) {
        this.mMaxHeight = r100;
    }

    public final void setMMaxWidth$universe_ui_dialog_release(UDDimension r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mMaxWidth = r100;
    }

    public final void setMMessage$universe_ui_dialog_release(CharSequence r100) {
        this.mMessage = r100;
    }

    public final void setMMessageGravity$universe_ui_dialog_release(int r100) {
        this.mMessageGravity = r100;
    }

    public final void setMMessagePaddingBottom$universe_ui_dialog_release(int r100) {
        this.mMessagePaddingBottom = r100;
    }

    public final void setMMessagePaddingLeft$universe_ui_dialog_release(int r100) {
        this.mMessagePaddingLeft = r100;
    }

    public final void setMMessagePaddingRight$universe_ui_dialog_release(int r100) {
        this.mMessagePaddingRight = r100;
    }

    public final void setMMessagePaddingTop$universe_ui_dialog_release(int r100) {
        this.mMessagePaddingTop = r100;
    }

    public final void setMMessageSize$universe_ui_dialog_release(int r100) {
        this.mMessageSize = r100;
    }

    public final void setMMessageTextColor$universe_ui_dialog_release(int r100) {
        this.mMessageTextColor = r100;
    }

    public final void setMOnCancelListener$universe_ui_dialog_release(DialogInterface.OnCancelListener r100) {
        this.mOnCancelListener = r100;
    }

    public final void setMOnDismissListener$universe_ui_dialog_release(DialogInterface.OnDismissListener r100) {
        this.mOnDismissListener = r100;
    }

    public final void setMPaddingBottomInDp$universe_ui_dialog_release(int r100) {
        this.mPaddingBottomInDp = r100;
    }

    public final void setMPaddingLeftInDp$universe_ui_dialog_release(int r100) {
        this.mPaddingLeftInDp = r100;
    }

    public final void setMPaddingRightInDp$universe_ui_dialog_release(int r100) {
        this.mPaddingRightInDp = r100;
    }

    public final void setMPaddingTopInDp$universe_ui_dialog_release(int r100) {
        this.mPaddingTopInDp = r100;
    }

    public final void setMRootLayout$universe_ui_dialog_release(View r100) {
        this.mRootLayout = r100;
    }

    public final void setMRootLayoutRes$universe_ui_dialog_release(int r100) {
        this.mRootLayoutRes = r100;
    }

    public final void setMTitle$universe_ui_dialog_release(CharSequence r100) {
        this.mTitle = r100;
    }

    public final void setMTitleGravity$universe_ui_dialog_release(int r100) {
        this.mTitleGravity = r100;
    }

    public final void setMTitleLineCount$universe_ui_dialog_release(int r100) {
        this.mTitleLineCount = r100;
    }

    public final void setMTitlePaddingBottom$universe_ui_dialog_release(int r100) {
        this.mTitlePaddingBottom = r100;
    }

    public final void setMTitlePaddingLeft$universe_ui_dialog_release(int r100) {
        this.mTitlePaddingLeft = r100;
    }

    public final void setMTitlePaddingRight$universe_ui_dialog_release(int r100) {
        this.mTitlePaddingRight = r100;
    }

    public final void setMTitlePaddingTop$universe_ui_dialog_release(int r100) {
        this.mTitlePaddingTop = r100;
    }

    public final void setMTitleSize$universe_ui_dialog_release(int r100) {
        this.mTitleSize = r100;
    }

    public final void setMTitleTextColor$universe_ui_dialog_release(int r100) {
        this.mTitleTextColor = r100;
    }

    public final void setMTitleTextStyleBold$universe_ui_dialog_release(Boolean r100) {
        this.mTitleTextStyleBold = r100;
    }

    public final void setMTranslationOnY$universe_ui_dialog_release(int r100) {
        this.mTranslationOnY = r100;
    }

    public final void setMWidth$universe_ui_dialog_release(float r100) {
        this.mWidth = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T style(int r100) {
        this.mStyle = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T title(int r100) {
        this.mTitle = this.context.getString(r100);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T titleBold(boolean r100) {
        this.mTitleTextStyleBold = Boolean.valueOf(r100);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T titleColor(int r100) {
        this.mTitleTextColor = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T titleGravity(int r100) {
        this.mTitleGravity = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T titleLineCount(int r100) {
        this.mTitleLineCount = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T titleSize(int r100) {
        this.mTitleSize = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T translationOnY(int r100) {
        this.mTranslationOnY = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T width(float r100) {
        this.mWidth = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T message(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.mMessage = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T title(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.mTitle = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T addViewClickListener(final int r100, DialogInterface.OnClickListener r101) {
        if (r101 != null) goto L4;
        CollectionsKt.removeAll(this.mViewClickInfos, new AnonymousClass1(r100));
    L5:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    L4:
        this.mViewClickInfos.add(new Pair(Integer.valueOf(r100), r101));
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T addActionButton(int r100, CharSequence r101, DialogInterface.OnClickListener r102) {
        Intrinsics.checkNotNullParameter(r101, "text");
        this.mActionButtons.add(new ActionBuilder().actionResId(r100).text(r101).onClickListener(r102).build());
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T addActionButton(int r100, int r101, DialogInterface.OnClickListener r102) {
        this.mActionButtons.add(new ActionBuilder().actionResId(r100).text(r101).onClickListener(r102).build());
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T messagePadding(int r100, int r101, int r102, int r103) {
        this.mMessagePaddingLeft = r100;
        this.mMessagePaddingTop = r101;
        this.mMessagePaddingRight = r102;
        this.mMessagePaddingBottom = r103;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T paddingInDp(int r100, int r101, int r102, int r103) {
        this.mPaddingLeftInDp = r100;
        this.mPaddingTopInDp = r101;
        this.mPaddingRightInDp = r102;
        this.mPaddingBottomInDp = r103;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T titlePadding(int r100, int r101, int r102, int r103) {
        this.mTitlePaddingLeft = r100;
        this.mTitlePaddingTop = r101;
        this.mTitlePaddingRight = r102;
        this.mTitlePaddingBottom = r103;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder");
        return this;
    }
}
