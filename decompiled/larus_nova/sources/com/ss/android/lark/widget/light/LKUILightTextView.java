package com.ss.android.lark.widget.light;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.autofill.HintConstants;
import androidx.core.view.ViewGroupKt;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.common.CastMonitor;
import com.larksuite.framework.thread.ThreadUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.codeblock.preview.CodeBlockV2Info;
import com.ss.android.lark.widget.columns.entity.ColumnsInfo;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import com.ss.android.lark.widget.light.touch.TouchConsumeView;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiHandler;
import com.ss.android.lark.widget.select.SelectableView;
import com.ss.android.lark.widget.span.AbbreviationInfo;
import com.ss.android.lark.widget.span.AtUserGroupInfo;
import com.ss.android.lark.widget.span.MediaInfo;
import com.ss.android.lark.widget.span.RemoteMediaSpan;
import com.ss.android.lark.widget.span.UrlInfo;
import com.ss.android.lark.widget.span.d0;
import com.ss.android.lark.widget.span.u;
import com.ss.android.lark.widget.span.v;
import com.ss.android.lark.widget.table.entity.TableInfo;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import mcc.h;
import mcc.i;
import mcc.j;
import mcc.k;
import mcc.l;
import mcc.m;
import mcc.n;
import mcc.o;
import mcc.p;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0096\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 ¯\u00022\u00020\u00012\u00020\u00022\u00020\u0003:\b¬\u0002\u00ad\u0002®\u0002¯\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\rJ\u001c\u0010\u0091\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u0093\u0001\u001a\u00020\f2\u0007\u0010\u0094\u0001\u001a\u00020\fH\u0014J7\u0010\u0095\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u0096\u0001\u001a\u0002012\u0007\u0010\u0097\u0001\u001a\u00020\f2\u0007\u0010\u0098\u0001\u001a\u00020\f2\u0007\u0010\u0099\u0001\u001a\u00020\f2\u0007\u0010\u009a\u0001\u001a\u00020\fH\u0014J\n\u0010\u009b\u0001\u001a\u00030\u0092\u0001H\u0002J\u001b\u0010\u009c\u0001\u001a\u00020}2\u0007\u0010\u009d\u0001\u001a\u00020}2\u0007\u0010\u009e\u0001\u001a\u00020\u001cH\u0002J\u001d\u0010\u009f\u0001\u001a\u0004\u0018\u00010{2\u0007\u0010\u009d\u0001\u001a\u00020}2\u0007\u0010 \u0001\u001a\u00020\fH\u0002J\u0014\u0010¡\u0001\u001a\u00030\u0092\u00012\b\u0010¢\u0001\u001a\u00030£\u0001H\u0014J6\u0010©\u0001\u001a\u00030\u0092\u00012\b\u0010¢\u0001\u001a\u00030£\u00012\u0007\u0010ª\u0001\u001a\u00020{2\u0007\u0010«\u0001\u001a\u00020\f2\u0007\u0010¬\u0001\u001a\u00020\u001c2\u0007\u0010\u00ad\u0001\u001a\u00020\u001cJ\u000f\u0010®\u0001\u001a\u00020\u001cH\u0000¢\u0006\u0003\b¯\u0001J\u0007\u0010°\u0001\u001a\u00020\u001cJ\f\u0010±\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0002J9\u0010²\u0001\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0´\u00010³\u00012\b\u0010\u009d\u0001\u001a\u00030µ\u00012\u0007\u0010¶\u0001\u001a\u00020\f2\u0007\u0010·\u0001\u001a\u00020\fH\u0002JL\u0010¸\u0001\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0´\u00010³\u00012\u0007\u0010¶\u0001\u001a\u00020\f2\u0007\u0010·\u0001\u001a\u00020\f2\u001b\u0010¹\u0001\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0´\u00010³\u0001H\u0002Jf\u0010º\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u009d\u0001\u001a\u00020}2\u0007\u0010»\u0001\u001a\u00020\f2\u0007\u0010¼\u0001\u001a\u00020\f2?\u0010½\u0001\u001a:\u0012\u0016\u0012\u00140\f¢\u0006\u000f\b¿\u0001\u0012\n\bÀ\u0001\u0012\u0005\b\b(»\u0001\u0012\u0016\u0012\u00140\f¢\u0006\u000f\b¿\u0001\u0012\n\bÀ\u0001\u0012\u0005\b\b(¼\u0001\u0012\u0005\u0012\u00030\u0092\u00010¾\u0001H\u0002J\u0013\u0010Á\u0001\u001a\u0002012\b\u0010Â\u0001\u001a\u00030Ã\u0001H\u0016J\u0016\u0010Ä\u0001\u001a\u00030\u0092\u00012\n\u0010Å\u0001\u001a\u0005\u0018\u00010Æ\u0001H\u0016J#\u0010Ç\u0001\u001a\u0002012\t\u0010È\u0001\u001a\u0004\u0018\u00010\f2\t\u0010É\u0001\u001a\u0004\u0018\u00010\f¢\u0006\u0003\u0010Ê\u0001J\u001c\u0010Î\u0001\u001a\u00030\u0092\u00012\u0007\u0010Ï\u0001\u001a\u00020}2\t\b\u0002\u0010Ð\u0001\u001a\u000201J\u0013\u0010Î\u0001\u001a\u00030\u0092\u00012\u0007\u0010Ï\u0001\u001a\u00020}H\u0016J\t\u0010Ñ\u0001\u001a\u0004\u0018\u00010}J\u0011\u0010Ò\u0001\u001a\u00030\u0092\u00012\u0007\u0010ª\u0001\u001a\u00020{J\n\u0010Ó\u0001\u001a\u00030\u0092\u0001H\u0002J\n\u0010Ô\u0001\u001a\u00030\u0092\u0001H\u0014J\u000b\u0010Õ\u0001\u001a\u0004\u0018\u00010{H\u0016J\u000b\u0010Ö\u0001\u001a\u0004\u0018\u00010}H\u0016J\n\u0010×\u0001\u001a\u00030\u0092\u0001H\u0016J\u0013\u0010Ø\u0001\u001a\u00030\u0092\u00012\u0007\u0010«\u0001\u001a\u00020\fH\u0016J\u0013\u0010Ù\u0001\u001a\u00030\u0092\u00012\u0007\u0010«\u0001\u001a\u00020\fH\u0016J\u0011\u0010Ú\u0001\u001a\u00030\u0092\u00012\u0007\u0010Û\u0001\u001a\u000201J\u0011\u0010Ü\u0001\u001a\u00030\u0092\u00012\u0007\u0010Ý\u0001\u001a\u00020XJ\u0011\u0010Þ\u0001\u001a\u00030\u0092\u00012\u0007\u0010Ý\u0001\u001a\u00020qJ\u0011\u0010ß\u0001\u001a\u00030\u0092\u00012\u0007\u0010Ý\u0001\u001a\u00020ZJ\u0011\u0010à\u0001\u001a\u00030\u0092\u00012\u0007\u0010Ý\u0001\u001a\u00020\\J\u0011\u0010á\u0001\u001a\u00030\u0092\u00012\u0007\u0010Ý\u0001\u001a\u00020^J\u0011\u0010â\u0001\u001a\u00030\u0092\u00012\u0007\u0010Ý\u0001\u001a\u00020`J\u0011\u0010ã\u0001\u001a\u00030\u0092\u00012\u0007\u0010Ý\u0001\u001a\u00020bJ\u0011\u0010ä\u0001\u001a\u00030\u0092\u00012\u0007\u0010Ý\u0001\u001a\u00020dJ\u0011\u0010å\u0001\u001a\u00030\u0092\u00012\u0007\u0010Ý\u0001\u001a\u00020fJ\u0011\u0010æ\u0001\u001a\u00030\u0092\u00012\u0007\u0010Ý\u0001\u001a\u00020\u0003J\u0011\u0010ç\u0001\u001a\u00030\u0092\u00012\u0007\u0010Ý\u0001\u001a\u00020iJ\u0011\u0010è\u0001\u001a\u00030\u0092\u00012\u0007\u0010Ý\u0001\u001a\u00020kJ\u0013\u0010é\u0001\u001a\u00030\u0092\u00012\t\u0010Ý\u0001\u001a\u0004\u0018\u00010uJ\u0011\u0010ê\u0001\u001a\u00030\u0092\u00012\u0007\u0010Ý\u0001\u001a\u00020mJ\u0011\u0010ë\u0001\u001a\u00030\u0092\u00012\u0007\u0010Ý\u0001\u001a\u00020oJ\u0016\u0010ì\u0001\u001a\u00030\u0092\u00012\n\u0010Ý\u0001\u001a\u0005\u0018\u00010í\u0001H\u0016J\u0015\u0010î\u0001\u001a\u00030\u0092\u00012\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010}H\u0002J0\u0010ï\u0001\u001a\u00030\u0092\u00012\b\u0010ð\u0001\u001a\u00030ñ\u00012\b\u0010ò\u0001\u001a\u00030ó\u00012\u0007\u0010ô\u0001\u001a\u00020\u001c2\u0007\u0010õ\u0001\u001a\u00020\u001cH\u0016J\t\u0010ö\u0001\u001a\u00020\fH\u0016J\t\u0010÷\u0001\u001a\u00020\fH\u0016J(\u0010ø\u0001\u001a\u00030\u0092\u00012\b\u0010ð\u0001\u001a\u00030ñ\u00012\b\u0010Ï\u0001\u001a\u00030ù\u00012\b\u0010ú\u0001\u001a\u00030ù\u0001H\u0016J'\u0010û\u0001\u001a\u0002012\b\u0010ð\u0001\u001a\u00030ñ\u00012\b\u0010Ï\u0001\u001a\u00030ù\u00012\b\u0010ú\u0001\u001a\u00030ù\u0001H\u0016J\u001e\u0010ü\u0001\u001a\u00030\u0092\u00012\b\u0010ð\u0001\u001a\u00030ñ\u00012\b\u0010ý\u0001\u001a\u00030þ\u0001H\u0016J\u001e\u0010ÿ\u0001\u001a\u00030\u0092\u00012\b\u0010ð\u0001\u001a\u00030ñ\u00012\b\u0010\u0080\u0002\u001a\u00030ù\u0001H\u0016J\u001e\u0010\u0081\u0002\u001a\u00030\u0092\u00012\b\u0010ð\u0001\u001a\u00030ñ\u00012\b\u0010\u0080\u0002\u001a\u00030ù\u0001H\u0016J\u001e\u0010\u0082\u0002\u001a\u00030\u0092\u00012\b\u0010ð\u0001\u001a\u00030ñ\u00012\b\u0010\u0083\u0002\u001a\u00030\u0084\u0002H\u0016J\u001d\u0010\u0085\u0002\u001a\u0002012\b\u0010ð\u0001\u001a\u00030ñ\u00012\b\u0010\u0083\u0002\u001a\u00030\u0084\u0002H\u0016J\u001e\u0010\u0086\u0002\u001a\u00030\u0092\u00012\b\u0010ð\u0001\u001a\u00030ñ\u00012\b\u0010\u0087\u0002\u001a\u00030\u0088\u0002H\u0016J=\u0010\u0089\u0002\u001a\u00030\u0092\u00012\b\u0010ð\u0001\u001a\u00030ñ\u00012\b\u0010\u008a\u0002\u001a\u00030ù\u00012\b\u0010À\u0001\u001a\u00030ù\u00012\u0007\u0010\u008b\u0002\u001a\u0002012\n\u0010\u008c\u0002\u001a\u0005\u0018\u00010ù\u0001H\u0016J0\u0010\u008d\u0002\u001a\u0002012\b\u0010ð\u0001\u001a\u00030ñ\u00012\b\u0010\u008a\u0002\u001a\u00030ù\u00012\b\u0010À\u0001\u001a\u00030ù\u00012\u0007\u0010\u008b\u0002\u001a\u000201H\u0016J(\u0010\u008e\u0002\u001a\u00030\u0092\u00012\b\u0010ð\u0001\u001a\u00030ñ\u00012\b\u0010\u008a\u0002\u001a\u00030ù\u00012\b\u0010À\u0001\u001a\u00030ù\u0001H\u0016J'\u0010\u008f\u0002\u001a\u0002012\b\u0010ð\u0001\u001a\u00030ñ\u00012\b\u0010\u008a\u0002\u001a\u00030ù\u00012\b\u0010À\u0001\u001a\u00030ù\u0001H\u0016J\u001e\u0010\u0090\u0002\u001a\u00030\u0092\u00012\b\u0010ð\u0001\u001a\u00030ñ\u00012\b\u0010\u0091\u0002\u001a\u00030\u0092\u0002H\u0016J\u001e\u0010\u0093\u0002\u001a\u00030\u0092\u00012\b\u0010ð\u0001\u001a\u00030ñ\u00012\b\u0010\u0094\u0002\u001a\u00030\u0095\u0002H\u0016J\u001e\u0010\u0096\u0002\u001a\u00030\u0092\u00012\b\u0010ð\u0001\u001a\u00030ñ\u00012\b\u0010\u0097\u0002\u001a\u00030\u0098\u0002H\u0016J\u001e\u0010\u0099\u0002\u001a\u00030\u0092\u00012\b\u0010ð\u0001\u001a\u00030ñ\u00012\b\u0010\u009a\u0002\u001a\u00030\u009b\u0002H\u0016J \u0010\u009c\u0002\u001a\u00030\u0092\u00012\b\u0010ð\u0001\u001a\u00030ñ\u00012\n\u0010ú\u0001\u001a\u0005\u0018\u00010ù\u0001H\u0016J\u001e\u0010\u009d\u0002\u001a\u00030\u0092\u00012\b\u0010ð\u0001\u001a\u00030ñ\u00012\b\u0010\u009e\u0002\u001a\u00030\u009f\u0002H\u0016J\b\u0010 \u0002\u001a\u00030¡\u0002J\u0016\u0010¢\u0002\u001a\u00030\u0092\u00012\n\u0010£\u0002\u001a\u0005\u0018\u00010¤\u0002H\u0014J\u0015\u0010¥\u0002\u001a\u00030\u0092\u00012\t\u0010ª\u0001\u001a\u0004\u0018\u00010{H\u0002J\u0012\u0010¦\u0002\u001a\u00030\u0092\u00012\b\u0010Ý\u0001\u001a\u00030\u008d\u0001J\u0012\u0010§\u0002\u001a\u00030\u0092\u00012\b\u0010Ý\u0001\u001a\u00030\u008d\u0001J\n\u0010¨\u0002\u001a\u00030\u0092\u0001H\u0016J\b\u0010©\u0002\u001a\u00030\u0092\u0001J\n\u0010ª\u0002\u001a\u00030\u008a\u0001H\u0002J\n\u0010«\u0002\u001a\u00030\u0092\u0001H\u0016R\u001a\u0010\u000e\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u0012\u0010\u0016\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00103\"\u0004\b8\u00105R\u001a\u00109\u001a\u00020:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0010\"\u0004\bA\u0010\u0012R\u001a\u0010B\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u00103\"\u0004\bD\u00105R\u001a\u0010E\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0010\"\u0004\bG\u0010\u0012R\u001a\u0010H\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u00103\"\u0004\bJ\u00105R\u001a\u0010K\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u00103\"\u0004\bM\u00105R\u001a\u0010N\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0010\"\u0004\bP\u0010\u0012R\u001a\u0010Q\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u001e\"\u0004\bS\u0010 R\u001a\u0010T\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u001e\"\u0004\bV\u0010 R\u0010\u0010W\u001a\u0004\u0018\u00010XX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010ZX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010]\u001a\u0004\u0018\u00010^X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u0004\u0018\u00010`X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u0004\u0018\u00010bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u00010dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u0004\u0018\u00010fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010g\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010h\u001a\u0004\u0018\u00010iX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010j\u001a\u0004\u0018\u00010kX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010l\u001a\u0004\u0018\u00010mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010n\u001a\u0004\u0018\u00010oX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010p\u001a\u0004\u0018\u00010qX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010r\u001a\u0004\u0018\u00010sX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010t\u001a\u0004\u0018\u00010uX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010w\u001a\u00020s8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bx\u0010yR\u0010\u0010z\u001a\u0004\u0018\u00010{X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010|\u001a\u0004\u0018\u00010}X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020\u007fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0082\u0001\u001a\u00030\u0081\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0085\u0001\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0086\u0001\u001a\n\u0012\u0005\u0012\u00030\u0088\u00010\u0087\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0089\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u008b\u0001\u001a\n\u0012\u0005\u0012\u00030\u008d\u00010\u008c\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u008e\u0001\u001a\u000201X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u00103\"\u0005\b\u0090\u0001\u00105R!\u0010¤\u0001\u001a\u00030\u0084\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b§\u0001\u0010¨\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001R\u001f\u0010Ë\u0001\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0006\bÍ\u0001\u0010¨\u0001\u001a\u0005\bÌ\u0001\u00103¨\u0006°\u0002"}, d2 = {"Lcom/ss/android/lark/widget/light/LKUILightTextView;", "Lcom/ss/android/lark/widget/light/touch/TouchConsumeView;", "Lcom/ss/android/lark/widget/light/listener/ISpanClickListener;", "Lcom/ss/android/lark/widget/light/listener/ICodeBlockV2SpanClickListener;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "textSize", "getTextSize", "()I", "setTextSize", "(I)V", "textColor", "getTextColor", "setTextColor", "selectedColorInt", "highlightedColorInt", "maxLines", "getMaxLines", "setMaxLines", "spacingMulti", "", "getSpacingMulti", "()F", "setSpacingMulti", "(F)V", "spacingExtra", "getSpacingExtra", "setSpacingExtra", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "getEllipsize", "()Landroid/text/TextUtils$TruncateAt;", "setEllipsize", "(Landroid/text/TextUtils$TruncateAt;)V", "alignment", "Landroid/text/Layout$Alignment;", "getAlignment", "()Landroid/text/Layout$Alignment;", "setAlignment", "(Landroid/text/Layout$Alignment;)V", "singleLine", "", "getSingleLine", "()Z", "setSingleLine", "(Z)V", "includeFontPadding", "getIncludeFontPadding", "setIncludeFontPadding", "typeface", "Landroid/graphics/Typeface;", "getTypeface", "()Landroid/graphics/Typeface;", "setTypeface", "(Landroid/graphics/Typeface;)V", GXTemplateKey.GAIAX_LAYER_GRAVITY, "getGravity", "setGravity", "shouldLayoutZeroLengthText", "getShouldLayoutZeroLengthText", "setShouldLayoutZeroLengthText", "TEXT_ITALIC_PADDING", "getTEXT_ITALIC_PADDING", "setTEXT_ITALIC_PADDING", "useOuterLayout", "getUseOuterLayout", "setUseOuterLayout", "enableUnderline", "getEnableUnderline", "setEnableUnderline", "underlineColor", "getUnderlineColor", "setUnderlineColor", "underlineWidth", "getUnderlineWidth", "setUnderlineWidth", "underlineOffsetY", "getUnderlineOffsetY", "setUnderlineOffsetY", "mAtSpanClickListener", "Lcom/ss/android/lark/widget/light/listener/IAtSpanClickListener;", "mMentionSpanClickListener", "Lcom/ss/android/lark/widget/light/listener/IMentionSpanClickListener;", "mHashTagSpanClickListener", "Lcom/ss/android/lark/widget/light/listener/IMomentsHashTagSpanClickListener;", "mUrlSpanClickListener", "Lcom/ss/android/lark/widget/light/listener/IUrlSpanClickListener;", "mPhoneSpanClickListener", "Lcom/ss/android/lark/widget/light/listener/IPhoneSpanClickListener;", "mAbbreviationClickListener", "Lcom/ss/android/lark/widget/light/listener/IAbbreviationClickListener;", "mImageSpanClickListener", "Lcom/ss/android/lark/widget/light/listener/IImageSpanClickListener;", "mMediaSpanClickListener", "Lcom/ss/android/lark/widget/light/listener/IMediaSpanClickListener;", "mCodeBlockV2SpanClickListener", "mTableSpanClickListener", "Lcom/ss/android/lark/widget/light/listener/ITableSpanClickListener;", "mColumnsSpanClickListener", "Lcom/ss/android/lark/widget/light/listener/IColumnsSpanClickListener;", "mPersonSpanClickListener", "Lcom/ss/android/lark/widget/light/listener/IPersonSpanClickListener;", "mCardSpanClickListener", "Lcom/ss/android/lark/widget/light/listener/ICardSpanClickListener;", "mAtUserGroupSpanClickListener", "Lcom/ss/android/lark/widget/light/listener/IAtUserGroupSpanClickListener;", "mRemoteDrawableLoadListener", "Lcom/ss/android/lark/widget/span/RemoteDrawableLoadListener;", "mEllipsizeListener", "Lcom/ss/android/lark/widget/light/LKUILightTextView$OnEllipsizeListener;", "mNeedCountLine", "imageLoadListener", "getImageLoadListener", "()Lcom/ss/android/lark/widget/span/RemoteDrawableLoadListener;", "mLayout", "Landroid/text/Layout;", "mCharSequence", "", "mMovementMethod", "Lcom/ss/android/lark/widget/light/touch/TouchConsumeView$TouchConsumeMovementMethod;", "mHighlightPath", "Landroid/graphics/Path;", "reusablePath", "mHighlightPaint", "Landroid/graphics/Paint;", "forceUpdate", "emojiLoadListenerList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/ss/android/lark/widget/linked_emojicon/base/EmojiconSpan$OnEmojiReadyListener;", "lightTextCoordinator", "Lcom/ss/android/lark/widget/light/LKUILightTextView$LightTextCoordinator;", "textLayoutChangeListeners", "", "Lcom/ss/android/lark/widget/light/LKUILightTextView$OnTextLayoutChangeListener;", "canHandleLongClick", "getCanHandleLongClick", "setCanHandleLongClick", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "notifyEllipsize", "ellipsizeIfNeed", "content", "width", "makeNewLayout", "wantWidth", "onDraw", "canvas", "Landroid/graphics/Canvas;", "underLinePaint", "getUnderLinePaint", "()Landroid/graphics/Paint;", "underLinePaint$delegate", "Lkotlin/Lazy;", "drawLayoutWithUnderline", "layout", "color", "thicknessPx", "offsetY", "getTotalPaddingTop", "getTotalPaddingTop$linked_emoji_release", "getTotalPaddingLeft", "getUpdatedHighlightPath", "getSpanSelectionExclusionRanges", "", "Lkotlin/Pair;", "Landroid/text/Spannable;", "selStart", "selEnd", "splitSelection", "excludedRanges", "slitLines", "start", "end", "lineHandler", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setOnLongClickListener", "l", "Landroid/view/View$OnLongClickListener;", "currentLocationIsProcess", "x", "y", "(Ljava/lang/Integer;Ljava/lang/Integer;)Z", "detachSkipRequestLayoutFg", "getDetachSkipRequestLayoutFg", "detachSkipRequestLayoutFg$delegate", "setContentText", "text", "detach", "getContentText", "setContentLayout", "cancelCursorLoadingAnimationIfNeed", "onDetachedFromWindow", "getLayout", "getContent", "updateSelection", "setSelectedColor", "setHighlightedColor", "setFakeBoldText", "fakeBoldText", "setAtSpanClickListener", "listener", "setAtUserGroupSpanClickListener", "setMentionSpanClickListener", "setHashTagSpanClickListener", "setUrlSpanClickListener", "setPhoneSpanClickListener", "setAbbreviationClickListener", "setImageSpanClickListener", "setMediaSpanClickListener", "setCodeBlockV2SpanCLickListener", "setTableSpanClickListener", "setColumnsSpanClickListener", "setOnEllipsizeListener", "setPersonSpanClickListener", "setCardSpanClickListener", "setOnClickListener", "Landroid/view/View$OnClickListener;", "bindDrawableCallback", "onAbbreviationClick", "view", "Landroid/view/View;", "abbreviationInfo", "Lcom/ss/android/lark/widget/span/AbbreviationInfo;", "actionUpX", "actionUpY", "getAcitonUpX", "getActionUpY", "onAtClick", "", "userId", "onAtLongClick", "onAtUserGroupSpanClicked", "info", "Lcom/ss/android/lark/widget/span/AtUserGroupInfo;", "onPhoneClick", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "onPhoneLongClick", "onURLClick", "urlInfo", "Lcom/ss/android/lark/widget/span/UrlInfo;", "onURLLongClick", "onImageClick", "imageClickInfo", "Lcom/ss/android/lark/widget/light/listener/ImageClickInfo;", "onMentionClick", "id", "authorized", "url", "onMentionLongClick", "onHashTagClick", "onHashTagLongClick", "onVideoClick", Keys.API_PARAM_KEY_MEDIA_INFO, "Lcom/ss/android/lark/widget/span/MediaInfo;", "onCodeBlockClick", "codeBlockV2Info", "Lcom/ss/android/lark/widget/codeblock/preview/CodeBlockV2Info;", "onTableClick", "tableInfo", "Lcom/ss/android/lark/widget/table/entity/TableInfo;", "onColumnsClick", "columnsInfo", "Lcom/ss/android/lark/widget/columns/entity/ColumnsInfo;", "onPersonClick", "onCardSpanClick", "clickInfo", "Lcom/ss/android/lark/widget/light/listener/ICardSpanClickListener$CardClickInfo;", "getFirstAtSpanLoc", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "setLayoutInner", "addOnTextLayoutChangeListener", "removeOnTextLayoutChangeListener", "requestLayout", "detachTextLayout", "prepareBlockContainer", "invalidate", "OnEllipsizeListener", "LightTextCoordinator", "OnTextLayoutChangeListener", "Companion", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class LKUILightTextView extends TouchConsumeView implements m, mcc.e {

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public static final /* synthetic */ int f445942p1 = 0;
    public boolean A;
    public boolean B;
    public int C;
    public float D;
    public float E;
    public mcc.b F;
    public i G;
    public j H;
    public Paint H0;
    public o I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public l f445943J;
    public mcc.a K;
    public mcc.g L;
    public boolean L0;
    public h M;
    public mcc.e N;
    public n O;
    public mcc.f P;
    public final CopyOnWriteArrayList<com.ss.android.lark.widget.linked_emojicon.base.a.InterfaceC5401a> P0;
    public k Q;
    public mcc.d R;
    public mcc.c S;
    public u T;
    public Layout U;
    public CharSequence V;
    public final com.ss.android.lark.widget.light.c V0;
    public final TouchConsumeView.c W;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public final List<c> f445944b1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public boolean f445945g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public final Lazy f445946h1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public Path f445947k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public final Lazy f445948k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f445949l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f445950m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f445951n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f445952o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f445953p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final Path f445954p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f445955q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f445956r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextUtils.TruncateAt f445957s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Layout.Alignment f445958t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f445959u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f445960v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Typeface f445961w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f445962x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f445963y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f445964z;

    public static final class a {
    }

    public interface b {
    }

    public interface c {
        void a(Layout r100, Layout r101);
    }

    public static final class d implements d0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LKUILightTextView f445965a;

        @Override // com.ss.android.lark.widget.span.d0.a
        public final void a() {
            this.f445965a.invalidate();
        }

        public d(LKUILightTextView r100) {
            this.f445965a = r100;
        }
    }

    public static final class e implements d0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LKUILightTextView f445966a;

        @Override // com.ss.android.lark.widget.span.d0.a
        public final void a() {
            this.f445966a.invalidate();
        }

        public e(LKUILightTextView r100) {
            this.f445966a = r100;
        }
    }

    public static final class f implements com.ss.android.lark.widget.linked_emojicon.base.a.InterfaceC5401a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.widget.linked_emojicon.base.a f445967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LKUILightTextView f445968b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.ss.android.lark.widget.linked_emojicon.base.a f445969a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ LKUILightTextView f445970b;

            public a(com.ss.android.lark.widget.linked_emojicon.base.a r100, LKUILightTextView r101) {
                this.f445969a = r100;
                this.f445970b = r101;
            }

            public final void a() {
                com.ss.android.lark.widget.linked_emojicon.base.a r100 = this.f445969a;
                r100.f446378g = EmojiHandler.c(r100.f446381j, null, null);
                LKUILightTextView r101 = this.f445970b;
                r101.L0 = true;
                r101.requestLayout();
                this.f445970b.invalidate();
                Log.i("LKUILightTextView", "emojikey: " + this.f445969a.f446381j + " callback, request layout");
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.ss.android.lark.widget.linked_emojicon.base.a.InterfaceC5401a
        public final void a() {
        }

        @Override // com.ss.android.lark.widget.linked_emojicon.base.a.InterfaceC5401a
        public final void b() {
            Log.i("LKUILightTextView", "onEmojiResourceReady callback");
            ThreadUtils.runOnUIThread(new a(this.f445967a, this.f445968b));
        }

        public f(com.ss.android.lark.widget.linked_emojicon.base.a r100, LKUILightTextView r101) {
            this.f445967a = r100;
            this.f445968b = r101;
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LKUILightTextView f445971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f445972b;

        public g(LKUILightTextView r100, View.OnClickListener r101) {
            this.f445971a = r100;
            this.f445972b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LKUILightTextView r101 = this.f445971a;
            int r102 = LKUILightTextView.f445942p1;
            if (r101.getMConsumedSpanEvent() == true) goto L6;
            this.f445972b.onClick(this.f445971a);
            return;
        }
    }

    static {
    }

    public final int[] getFirstAtSpanLoc() {
        int[] r100 = {-1, -1};
        Layout r101 = getLayout();
        if (r101 != null) goto L5;
        return r100;
    L5:
        CharSequence r102 = r101.getText();
        if ((r102 instanceof Spanned) == true) goto L8;
        return r100;
    L8:
        Spanned r103 = (Spanned) r102;
        ncc.f[] r104 = (ncc.f[]) r103.getSpans(0, r103.length(), ncc.f.class);
        Intrinsics.checkNotNull(r104);
        if (r104.length != 0) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L14;
        return r100;
    L14:
        int r106 = r103.getSpanEnd(r104[0]);
        int r107 = r101.getLineForOffset(r106);
        Rect r108 = new Rect();
        r101.getLineBounds(r107, r108);     // Catch: IndexOutOfBoundsException -> L21
        int r109 = this.f445953p;     // Catch: IndexOutOfBoundsException -> L21
        if (r109 != Integer.MAX_VALUE) goto L18;
    L19:
        return new int[]{(int) r101.getSecondaryHorizontal(r106), r108.top};
    L18:
        if (r107 < (r109 - 1)) goto L19;
    L23:
        return r100;
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L11:
        r105 = false;
        goto L12
    }

    public final void setOnEllipsizeListener(b r100) {
    }

    private final boolean getDetachSkipRequestLayoutFg() {
        return ((Boolean) this.f445948k1.getValue()).booleanValue();
    }

    private final u getImageLoadListener() {
        if (this.T != null) goto L5;
        this.T = new u(this);
    L5:
        u r100 = this.T;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.widget.span.RemoteDrawableLoadListener");
        return r100;
    }

    private final Paint getUnderLinePaint() {
        return (Paint) this.f445946h1.getValue();
    }

    private final Path getUpdatedHighlightPath() {
        CharSequence r100 = this.V;
        if ((r100 instanceof Spannable) == true) goto L5;
        return null;
    L5:
        int r101 = Selection.getSelectionStart(r100);
        final int r102 = Selection.getSelectionEnd(r100);
        if (r101 >= 0) goto L8;
        return null;
    L8:
        if (this.f445947k0 != null) goto L10;
        this.f445947k0 = new Path();
    L10:
        Path r103 = this.f445947k0;
        if (r103 == null) goto L14;
        r103.reset();
    L14:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("messenger.thread.read_receipt") == false) goto L35;
        Spannable r104 = (Spannable) r100;
        ArrayList r105 = new ArrayList();
        com.ss.android.lark.widget.light.viewstub.b[] r106 = (com.ss.android.lark.widget.light.viewstub.b[]) r104.getSpans(r101, r102, com.ss.android.lark.widget.light.viewstub.b.class);
        Intrinsics.checkNotNull(r106);
        int r107 = r106.length;
        int r108 = 0;
    L16:
        if (r108 >= r107) goto L18;
        com.ss.android.lark.widget.light.viewstub.b r109 = r106[r108];
        int r110 = r104.getSpanStart(r109);
        int r111 = r104.getSpanEnd(r109);
        r105.add(new Pair(Integer.valueOf(r110), Integer.valueOf(r111)));
        r108 = r108 + 1;
        goto L16
    L18:
        List r112 = CollectionsKt.sortedWith(r105, new com.ss.android.lark.widget.light.a());
        if (r112.isEmpty() == false) goto L21;
        List r113 = CollectionsKt.listOf(new Pair(Integer.valueOf(r101), Integer.valueOf(r102)));
    L31:
        Iterator r114 = r113.iterator();
    L33:
        if (r114.hasNext() == false) goto L37;
        Pair r115 = (Pair) r114.next();
        int r116 = ((Number) r115.component1()).intValue();
        final int r117 = ((Number) r115.component2()).intValue();
        A(r100, r116, r117, new LKUILightTextView$getUpdatedHighlightPath$1$1(this, r117));
    L37:
        if (this.H0 != null) goto L42;
        Paint r118 = new Paint(1);
        this.H0 = r118;
        r118.setColor(this.f445951n);
        Paint r119 = this.H0;
        if (r119 == null) goto L42;
        r119.setStyle(Paint.Style.FILL);
    L42:
        return this.f445947k0;
    L21:
        ArrayList r120 = new ArrayList();
        Iterator r121 = r112.iterator();
    L23:
        if (r121.hasNext() == false) goto L28;
        Pair r122 = (Pair) r121.next();
        int r123 = ((Number) r122.component1()).intValue();
        int r124 = ((Number) r122.component2()).intValue();
        if (r101 >= r123) goto L27;
        r120.add(new Pair(Integer.valueOf(r101), Integer.valueOf(r123)));
    L27:
        r101 = Math.max(r101, r124);
        goto L23
    L28:
        if (r101 >= r102) goto L30;
        r120.add(new Pair(Integer.valueOf(r101), Integer.valueOf(r102)));
    L30:
        r113 = r120;
        goto L31
    L35:
        A(r100, r101, r102, new AnonymousClass2(this, r102));
        goto L37
    }

    @Override // mcc.a.InterfaceC6801a
    public int getAcitonUpX() {
        TouchConsumeView.c r100 = TouchConsumeView.c.f446297c;
        return TouchConsumeView.c.a.a().f446298a;
    }

    @Override // mcc.a.InterfaceC6801a
    public int getActionUpY() {
        TouchConsumeView.c r100 = TouchConsumeView.c.f446297c;
        return TouchConsumeView.c.a.a().f446299b;
    }

    @Override // com.ss.android.lark.widget.select.SelectableView
    public CharSequence getContent() {
        Layout r100 = this.U;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getText();
    }

    public final float getTotalPaddingLeft() {
        int r100 = this.f445962x & 7;
        if (r100 == 1) goto L10;
        if (r100 == 5) goto L7;
        int r101 = getPaddingLeft();
    L11:
        return r101;
    L7:
        r101 = (getMeasuredWidth() - getPaddingRight()) - com.ss.android.lark.widget.light.layout.e.b(this.U);
        goto L11
    L10:
        return (getMeasuredWidth() - com.ss.android.lark.widget.light.layout.e.b(this.U)) / 2;
    }

    public final float getTotalPaddingTop$linked_emoji_release() {
        int r100 = this.f445962x & 112;
        if (r100 == 16) goto L10;
        if (r100 == 80) goto L7;
        int r101 = getPaddingTop();
    L11:
        return r101;
    L7:
        r101 = (getMeasuredHeight() - getPaddingBottom()) - com.ss.android.lark.widget.light.layout.e.a(this.U);
        goto L11
    L10:
        return (getMeasuredHeight() - com.ss.android.lark.widget.light.layout.e.a(this.U)) / 2;
    }

    public final void v() {
        CharSequence r100 = this.V;
        if ((r100 instanceof Spanned) == true) goto L5;
        return;
    L5:
        Spanned r101 = (Spanned) r100;
        int r102 = 0;
        d0[] r103 = (d0[]) r101.getSpans(0, r101.length(), d0.class);
        Intrinsics.checkNotNull(r103);
        int r104 = r103.length;
    L6:
        if (r102 >= r104) goto L13;
        ValueAnimator r105 = r103[r102].f448658a.f448656g;
        if (r105 == null) goto L12;
        r105.removeAllListeners();
        if (r105.isRunning() == false) goto L12;
        r105.end();
    L12:
        r102 = r102 + 1;
        goto L6
    }

    public final void w() {
        Log.i("LKUILightTextView", "detachTextLayout method called");
        z("", true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        v();
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
        invalidate();
    }

    public final Layout.Alignment getAlignment() {
        return this.f445958t;
    }

    public final boolean getCanHandleLongClick() {
        return this.f445945g1;
    }

    public final CharSequence getContentText() {
        return this.V;
    }

    public final TextUtils.TruncateAt getEllipsize() {
        return this.f445957s;
    }

    public final boolean getEnableUnderline() {
        return this.B;
    }

    public final int getGravity() {
        return this.f445962x;
    }

    public final boolean getIncludeFontPadding() {
        return this.f445960v;
    }

    @Override // com.ss.android.lark.widget.select.SelectableView
    public Layout getLayout() {
        return this.U;
    }

    public final int getMaxLines() {
        return this.f445953p;
    }

    public final boolean getShouldLayoutZeroLengthText() {
        return this.f445963y;
    }

    public final boolean getSingleLine() {
        return this.f445959u;
    }

    public final float getSpacingExtra() {
        return this.f445956r;
    }

    public final float getSpacingMulti() {
        return this.f445955q;
    }

    public final int getTEXT_ITALIC_PADDING() {
        return this.f445964z;
    }

    public final int getTextColor() {
        return this.f445950m;
    }

    public final int getTextSize() {
        return this.f445949l;
    }

    public final Typeface getTypeface() {
        return this.f445961w;
    }

    public final int getUnderlineColor() {
        return this.C;
    }

    public final float getUnderlineOffsetY() {
        return this.E;
    }

    public final float getUnderlineWidth() {
        return this.D;
    }

    public final boolean getUseOuterLayout() {
        return this.A;
    }

    @Override // android.view.View
    public final void invalidate() {
        super.invalidate();
    }

    public LKUILightTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 6, 0);
        this.f445949l = (int) UIHelper.sp2px(17.0f);
        this.f445950m = UIUtils.getColor(getContext(), R.color.text_title);
        this.f445951n = UIUtils.getColor(getContext(), R.color.udtoken_btn_text_bg_pri_pressed);
        this.f445952o = j08.b.c(getContext(), R.color.primary_fill_default, 0.2f);
        this.f445953p = Integer.MAX_VALUE;
        this.f445955q = 1.0f;
        this.f445956r = UIHelper.dp2px(2.5f);
        this.f445958t = Layout.Alignment.ALIGN_NORMAL;
        this.f445960v = true;
        int r101 = h18.e.f483540a;
        this.f445961w = h18.e.b(getContext(), 0);
        this.f445962x = 51;
        this.f445964z = UIHelper.dp2px(2.0f);
        TouchConsumeView.c r102 = TouchConsumeView.c.f446297c;
        this.W = TouchConsumeView.c.a.a();
        this.f445954p0 = new Path();
        this.P0 = new CopyOnWriteArrayList();
        this.f445944b1 = new ArrayList();
        this.f445946h1 = LazyKt.lazy(LKUILightTextView$underLinePaint$2.INSTANCE);
        this.f445948k1 = LazyKt.lazy(LKUILightTextView$detachSkipRequestLayoutFg$2.INSTANCE);
        com.ss.android.lark.widget.light.c r103 = new com.ss.android.lark.widget.light.c(getContext(), this);
        this.V0 = r103;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.View");
        addView(r103);
        setWillNotDraw(false);
        bab.b.b(this);
    }

    private final void setLayoutInner(Layout r100) {
        this.V0.b(this.U);
        Layout r101 = this.U;
        this.U = r100;
        this.V0.a(r100);
        Iterator<T> r102 = this.f445944b1.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((c) r102.next()).a(r101, r100);
        goto L4
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        this.L0 = true;
        requestLayout();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        r110.save();
        if (this.U == null) goto L24;
        r110.translate(getTotalPaddingLeft(), getTotalPaddingTop$linked_emoji_release());
        Path r100 = getUpdatedHighlightPath();
        SelectableView.State r101 = this.f448398a;
        if (r101 != SelectableView.State.SELECTED) goto L10;
        Paint r102 = this.H0;
        if (r102 == null) goto L14;
        r102.setColor(this.f445951n);
    L14:
        Layout r103 = this.U;
        if (r103 == null) goto L18;
        int r104 = com.ss.android.lark.widget.light.b.f445973a;
        com.ss.android.lark.widget.light.b.a(r110, r103, r100, this.H0, this.f448398a);
    L18:
        if (this.B == false) goto L24;
        Layout r105 = this.U;
        if (r105 == null) goto L24;
        int r106 = this.C;
        float r107 = this.D;
        float r108 = this.E;
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r105, "layout");
        getUnderLinePaint().setColor(r106);
        getUnderLinePaint().setStrokeWidth(r107);
        getUnderLinePaint().setStyle(Paint.Style.STROKE);
        int r109 = r105.getLineCount();
        int r111 = 0;
    L22:
        if (r111 >= r109) goto L24;
        float r112 = r105.getLineLeft(r111);
        float r113 = r105.getLineRight(r111);
        float r114 = (r105.getLineBaseline(r111) + getUnderLinePaint().getFontMetricsInt().descent) + r108;
        r110.drawLine(r112, r114, r113, r114, getUnderLinePaint());
        r111 = r111 + 1;
        goto L22
    L10:
        if (r101 != SelectableView.State.HIGHLIGHTED) goto L14;
        Paint r115 = this.H0;
        if (r115 == null) goto L14;
        r115.setColor(this.f445952o);
    L24:
        r110.restore();
    }

    @Override // com.ss.android.lark.widget.light.touch.TouchConsumeView, android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        Layout r100 = this.U;
        if (r100 != null) goto L5;
    L70:
        boolean r101 = false;
    L71:
        boolean r111 = super.onTouchEvent(r110);
        if (r101 == true) goto L77;
        if (r111 == true) goto L78;
        return false;
    L78:
        return true;
    L77:
        return true;
    L5:
        if ((r100.getText() instanceof Spanned) == false) goto L70;
        TouchConsumeView.c r102 = this.W;
        CharSequence r103 = r100.getText();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.text.Spanned");
        Spanned r112 = (Spanned) r103;
        r102.getClass();
        Intrinsics.checkNotNullParameter(this, "widget");
        Intrinsics.checkNotNullParameter(r100, "layout");
        Intrinsics.checkNotNullParameter(r112, "buffer");
        Intrinsics.checkNotNullParameter(r110, "event");
        int r104 = r110.getAction();
        if (r104 != 3) goto L10;
        this.f446293f = true;
    L69:
        r101 = true;
        goto L71
    L10:
        if (r104 != 2) goto L20;
        int r105 = this.f446294g;
        if (r105 != 0) goto L16;
        if (this.f446295h == 0) goto L69;
    L16:
        if (Math.abs(r105 - ((int) r110.getX())) < 10) goto L18;
    L19:
        this.f446293f = true;
        goto L69
    L18:
        if (Math.abs(this.f446295h - ((int) r110.getY())) < 10) goto L69;
    L20:
        if (r104 == 0) goto L23;
        if (r104 != 1) goto L70;
    L23:
        int r106 = (int) r110.getX();
        int r113 = (int) r110.getY();
        if (r104 == 0) goto L28;
        if (r104 != 1) goto L29;
        this.f446294g = 0;
        this.f446295h = 0;
    L29:
        int r114 = TouchConsumeView.c.b(this, r100, r106, r113);
        if (StringsKt.getOrNull(r112, r114) == null) goto L41;
        ClickableSpan[] r107 = (ClickableSpan[]) r112.getSpans(r114, r114, ClickableSpan.class);
        if (r107.length != 0) goto L35;
        boolean r108 = true;
    L36:
        if (r108 == true) goto L41;
        ClickableSpan r115 = r107[0];
        if (TouchConsumeView.c.a(r114, r115, r112) == false) goto L42;
        Log.d("TouchConsumeView", "click span edge, offset is " + r114);
        goto L41
    L42:
        com.ss.android.lark.widget.light.touch.a r109 = new com.ss.android.lark.widget.light.touch.a(r107, this, r115, r112, r114);
    L43:
        if (r109 == null) goto L70;
        this.f446291d = false;
        if (r104 == 0) goto L64;
        if (r104 == 1) goto L50;
    L68:
        setLinkHit$linked_emoji_release(true);
        goto L69
    L50:
        if (this.f446292e == false) goto L68;
        this.f446291d = true;
        r102.f446298a = r106;
        r102.f446299b = r113;
        Intrinsics.checkNotNullParameter(this, "widget");
        ClickableSpan[] r116 = r109.f446300a;
        if (r116.length != 1) goto L55;
        r109.f446301b.setMConsumedSpanEvent(true);
        r109.f446302c.onClick(this);
        goto L68
    L55:
        if (r116.length <= 1) goto L68;
        r109.f446301b.setMConsumedSpanEvent(true);
        Spanned r117 = r109.f446303d;
        int r118 = r109.f446304e;
        ReplacementSpan[] r119 = (ReplacementSpan[]) r117.getSpans(r118, r118, ReplacementSpan.class);
        Intrinsics.checkNotNull(r119);
        if (r119.length != 0) goto L59;
        boolean r120 = true;
    L61:
        if ((!r120) == false) goto L63;
        ClickableSpan[] r121 = r109.f446300a;
        r121[r121.length - 1].onClick(this);
        goto L68
    L63:
        r109.f446302c.onClick(this);
        goto L68
    L59:
        r120 = false;
        goto L61
    L64:
        this.f446293f = false;
        if (this.f446292e == true) goto L67;
        this.f446292e = true;
        new PthreadTimer("TouchConsumeView$TouchConsumeMovementMethod").schedule(new com.ss.android.lark.widget.light.touch.b(this, r109), TouchConsumeView.f446287j);
        goto L68
    L67:
        this.f446291d = true;
        goto L68
    L35:
        r108 = false;
    L41:
        r109 = null;
        goto L43
    L28:
        this.f446294g = r106;
        this.f446295h = r113;
        setMConsumedSpanEvent(false);
        goto L29
    }

    public final void setAbbreviationClickListener(mcc.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.K = r100;
    }

    public final void setAlignment(Layout.Alignment r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f445958t = r100;
    }

    public final void setAtSpanClickListener(mcc.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.F = r100;
    }

    public final void setAtUserGroupSpanClickListener(mcc.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.S = r100;
    }

    public final void setCanHandleLongClick(boolean r100) {
        this.f445945g1 = r100;
    }

    public final void setCardSpanClickListener(mcc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.R = r100;
    }

    public final void setCodeBlockV2SpanCLickListener(mcc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.N = r100;
    }

    public final void setColumnsSpanClickListener(mcc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.P = r100;
    }

    public final void setContentLayout(Layout r100) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        if (Objects.equals(r100, this.U) == false) goto L5;
        return;
    L5:
        v();
        setLayoutInner(r100);
        this.V = r100.getText();
        Layout r101 = this.U;
        if (r101 == null) goto L8;
        CharSequence r102 = r101.getText();
    L9:
        u(r102);
        requestLayout();
        return;
    L8:
        r102 = null;
        goto L9
    }

    @Override // com.ss.android.lark.widget.select.SelectableView
    public void setContentText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        z(r100, false);
    }

    public final void setEllipsize(TextUtils.TruncateAt r100) {
        this.f445957s = r100;
    }

    public final void setEnableUnderline(boolean r100) {
        this.B = r100;
    }

    public final void setFakeBoldText(boolean r100) {
        if (r100 == false) goto L5;
        int r101 = h18.e.f483540a;
        this.f445961w = h18.e.b(getContext(), 1);
        return;
    }

    public final void setGravity(int r100) {
        this.f445962x = r100;
    }

    public final void setHashTagSpanClickListener(j r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.H = r100;
    }

    @Override // com.ss.android.lark.widget.select.SelectableView
    public void setHighlightedColor(int r100) {
        this.f445952o = r100;
        invalidate();
    }

    public final void setImageSpanClickListener(mcc.g r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.L = r100;
    }

    public final void setIncludeFontPadding(boolean r100) {
        this.f445960v = r100;
    }

    public final void setMaxLines(int r100) {
        this.f445953p = r100;
    }

    public final void setMediaSpanClickListener(h r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.M = r100;
    }

    public final void setMentionSpanClickListener(i r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.G = r100;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        if (r100 != null) goto L5;
        super.setOnClickListener(null);
        return;
    L5:
        super.setOnClickListener(new g(this, r100));
    }

    @Override // com.ss.android.lark.widget.light.touch.TouchConsumeView, android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r100) {
        super.setOnLongClickListener(r100);
        if (r100 == null) goto L5;
        boolean r101 = true;
    L6:
        this.f445945g1 = r101;
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setPersonSpanClickListener(k r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.Q = r100;
    }

    public final void setPhoneSpanClickListener(l r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f445943J = r100;
    }

    @Override // com.ss.android.lark.widget.select.SelectableView
    public void setSelectedColor(int r100) {
        this.f445951n = r100;
        invalidate();
    }

    public final void setShouldLayoutZeroLengthText(boolean r100) {
        this.f445963y = r100;
    }

    public final void setSingleLine(boolean r100) {
        this.f445959u = r100;
    }

    public final void setSpacingExtra(float r100) {
        this.f445956r = r100;
    }

    public final void setSpacingMulti(float r100) {
        this.f445955q = r100;
    }

    public final void setTEXT_ITALIC_PADDING(int r100) {
        this.f445964z = r100;
    }

    public final void setTableSpanClickListener(n r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.O = r100;
    }

    public final void setTextColor(int r100) {
        this.f445950m = r100;
    }

    public final void setTextSize(int r100) {
        this.f445949l = r100;
    }

    public final void setTypeface(Typeface r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f445961w = r100;
    }

    public final void setUnderlineColor(int r100) {
        this.C = r100;
    }

    public final void setUnderlineOffsetY(float r100) {
        this.E = r100;
    }

    public final void setUnderlineWidth(float r100) {
        this.D = r100;
    }

    public final void setUrlSpanClickListener(o r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.I = r100;
    }

    public final void setUseOuterLayout(boolean r100) {
        this.A = r100;
    }

    public final void u(CharSequence r100) {
        if ((r100 instanceof Spannable) == true) goto L5;
        return;
    L5:
        Spannable r101 = (Spannable) r100;
        int r102 = 0;
        ncc.e[] r103 = (ncc.e[]) r101.getSpans(0, r101.length(), ncc.e.class);
        boolean r104 = true;
        if (r103 != null) goto L8;
    L17:
        v[] r105 = (v[]) r101.getSpans(0, r101.length(), v.class);
        if (r105 != null) goto L20;
    L29:
        RemoteMediaSpan[] r106 = (RemoteMediaSpan[]) r101.getSpans(0, r101.length(), RemoteMediaSpan.class);
        if (r106 != null) goto L32;
    L41:
        d0[] r107 = (d0[]) r101.getSpans(0, r101.length(), d0.class);
        Intrinsics.checkNotNull(r107);
        int r108 = r107.length;
        int r109 = 0;
    L42:
        if (r109 >= r108) goto L44;
        r107[r109].f448661d = new d(this);
        r109 = r109 + 1;
        goto L42
    L44:
        tcc.b[] r110 = (tcc.b[]) r101.getSpans(0, r101.length(), tcc.b.class);
        Intrinsics.checkNotNull(r110);
        int r111 = r110.length;
        int r112 = 0;
    L45:
        if (r112 >= r111) goto L47;
        r110[r112].f545497d = new e(this);
        r112 = r112 + 1;
        goto L45
    L47:
        com.ss.android.lark.widget.linked_emojicon.base.a[] r113 = (com.ss.android.lark.widget.linked_emojicon.base.a[]) r101.getSpans(0, r101.length(), com.ss.android.lark.widget.linked_emojicon.base.a.class);
        this.P0.clear();
        if (r113 != null) goto L50;
    L56:
        if (r104 == true) goto L66;
        int r114 = r113.length;
    L58:
        if (r102 >= r114) goto L76;
        com.ss.android.lark.widget.linked_emojicon.base.a r115 = r113[r102];
        if (EmojiHandler.c(r115.f446381j, null, null) != null) goto L63;
        f r116 = new f(r115, this);
        this.P0.add(r116);
        r115.b(r116);
        Log.i("LKUILightTextView", "emoji: " + r115.f446381j + " setEmojiResourceListener");
    L65:
        r102 = r102 + 1;
        goto L58
    L63:
        if (r115.getDrawable() != null) goto L65;
        r115.f446378g = EmojiHandler.c(r115.f446381j, null, null);
        goto L65
    L76:
        return;
    L66:
        return;
    L50:
        if (r113.length != 0) goto L52;
        boolean r117 = true;
    L53:
        if (r117 == true) goto L56;
        r104 = false;
        goto L56
    L52:
        r117 = false;
        goto L53
    L32:
        if (r106.length != 0) goto L34;
        boolean r118 = true;
    L36:
        if ((!r118) == false) goto L41;
        Iterator r119 = ArrayIteratorKt.iterator(r106);
    L39:
        if (r119.hasNext() == false) goto L41;
        ((RemoteMediaSpan) r119.next()).f448607n = getImageLoadListener();
        goto L39
    L34:
        r118 = false;
        goto L36
    L20:
        if (r105.length != 0) goto L22;
        boolean r120 = true;
    L24:
        if ((!r120) == false) goto L29;
        Iterator r121 = ArrayIteratorKt.iterator(r105);
    L27:
        if (r121.hasNext() == false) goto L29;
        ((v) r121.next()).f448797u = getImageLoadListener();
        goto L27
    L22:
        r120 = false;
        goto L24
    L8:
        if (r103.length != 0) goto L10;
        boolean r122 = true;
    L12:
        if ((!r122) == false) goto L17;
        Iterator r123 = ArrayIteratorKt.iterator(r103);
    L15:
        if (r123.hasNext() == false) goto L17;
        ((ncc.e) r123.next()).a(new ncc.d(this));
        goto L15
    L10:
        r122 = false;
        goto L12
    }

    public LKUILightTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, 4, 0);
        this.f445949l = (int) UIHelper.sp2px(17.0f);
        this.f445950m = UIUtils.getColor(getContext(), R.color.text_title);
        this.f445951n = UIUtils.getColor(getContext(), R.color.udtoken_btn_text_bg_pri_pressed);
        this.f445952o = j08.b.c(getContext(), R.color.primary_fill_default, 0.2f);
        this.f445953p = Integer.MAX_VALUE;
        this.f445955q = 1.0f;
        this.f445956r = UIHelper.dp2px(2.5f);
        this.f445958t = Layout.Alignment.ALIGN_NORMAL;
        this.f445960v = true;
        int r102 = h18.e.f483540a;
        this.f445961w = h18.e.b(getContext(), 0);
        this.f445962x = 51;
        this.f445964z = UIHelper.dp2px(2.0f);
        TouchConsumeView.c r103 = TouchConsumeView.c.f446297c;
        this.W = TouchConsumeView.c.a.a();
        this.f445954p0 = new Path();
        this.P0 = new CopyOnWriteArrayList();
        this.f445944b1 = new ArrayList();
        this.f445946h1 = LazyKt.lazy(LKUILightTextView$underLinePaint$2.INSTANCE);
        this.f445948k1 = LazyKt.lazy(LKUILightTextView$detachSkipRequestLayoutFg$2.INSTANCE);
        com.ss.android.lark.widget.light.c r104 = new com.ss.android.lark.widget.light.c(getContext(), this);
        this.V0 = r104;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.view.View");
        addView(r104);
        setWillNotDraw(false);
        bab.b.b(this);
    }

    @Override // mcc.l
    public final void a(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        l r102 = this.f445943J;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }

    @Override // mcc.l
    public final void b(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        l r102 = this.f445943J;
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }

    @Override // mcc.d
    public final void e(View r100, mcc.d.a r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "clickInfo");
        mcc.d r102 = this.R;
        if (r102 == null) goto L6;
        r102.e(r100, r101);
        return;
    }

    @Override // mcc.n
    public final void g(LKUILightTextView r100, TableInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "tableInfo");
        n r102 = this.O;
        if (r102 == null) goto L6;
        r102.g(r100, r101);
        return;
    }

    @Override // mcc.c
    public final void i(View r100, AtUserGroupInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "info");
        mcc.c r102 = this.S;
        if (r102 == null) goto L6;
        r102.i(r100, r101);
        return;
    }

    @Override // mcc.g
    public final void j(View r100, p r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "imageClickInfo");
        mcc.g r102 = this.L;
        if (r102 == null) goto L6;
        r102.j(r100, r101);
        return;
    }

    @Override // mcc.k
    public final void l(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        k r102 = this.Q;
        if (r102 == null) goto L6;
        r102.l(r100, r101);
        return;
    }

    @Override // mcc.h
    public final void m(View r100, MediaInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, Keys.API_PARAM_KEY_MEDIA_INFO);
        h r102 = this.M;
        if (r102 == null) goto L6;
        r102.m(r100, r101);
        return;
    }

    @Override // mcc.e
    public final void n(View r100, CodeBlockV2Info r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "codeBlockV2Info");
        mcc.e r102 = this.N;
        if (r102 == null) goto L6;
        r102.n(r100, r101);
        return;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        Log.d("LKUILightTextView", "onMeasure: lightTextCoordinator: notify pre measure");
        this.V0.getClass();
        if (this.U == null) goto L5;
    L8:
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = View.MeasureSpec.getSize(r101);
        Layout r104 = this.U;
        if (r104 != null) goto L12;
        CharSequence r105 = this.V;
        Intrinsics.checkNotNull(r105);
        setLayoutInner(y(x(r105, ((r102 - getPaddingRight()) - getPaddingLeft()) - this.f445964z), (r102 - getPaddingRight()) - getPaddingLeft()));
    L22:
        if (View.MeasureSpec.getMode(r100) == 1073741824) goto L27;
        Layout r106 = this.U;
        if (r106 == null) goto L27;
        Intrinsics.checkNotNull(r106);
        r102 = getPaddingRight() + (r106.getWidth() + getPaddingLeft());
    L27:
        if (View.MeasureSpec.getMode(r101) == 1073741824) goto L32;
        Layout r107 = this.U;
        if (r107 == null) goto L32;
        r103 = Math.max((com.ss.android.lark.widget.light.layout.e.a(r107) + getPaddingTop()) + getPaddingBottom(), getMinimumHeight());
    L32:
        if (this.U != null) goto L34;
        Log.d("LKUILightTextView", "layout is null");
        r102 = getPaddingLeft() + getPaddingRight();
        r103 = getPaddingTop() + getPaddingBottom();
    L34:
        setMeasuredDimension(r102, r103);
        com.ss.android.lark.widget.light.c r108 = this.V0;
        r108.getClass();
        r108.measure(View.MeasureSpec.makeMeasureSpec(r102, 1073741824), View.MeasureSpec.makeMeasureSpec(r103, 1073741824));
        this.L0 = false;
        return;
    L12:
        if (this.A == true) goto L22;
        if (((r104.getWidth() + getPaddingLeft()) + getPaddingRight()) <= r102) goto L16;
    L17:
        Log.e("LKUILightTextView", "Layout.width(" + (((r104.getWidth() + getPaddingLeft()) + getPaddingRight()) + this.f445964z) + ") > view max width({" + r102 + "})，rebuildLayout");
        CharSequence r109 = this.V;
        if (r109 != null) goto L20;
        r109 = "";
    L20:
        setLayoutInner(y(x(r109, (r102 - getPaddingRight()) - getPaddingLeft()), (r102 - getPaddingLeft()) - getPaddingRight()));
        goto L22
    L16:
        if (this.L0 == false) goto L22;
    L5:
        if (this.V != null) goto L8;
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // mcc.f
    public final void q(View r100, ColumnsInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "columnsInfo");
        mcc.f r102 = this.P;
        if (r102 == null) goto L6;
        r102.q(r100, r101);
        return;
    }

    @Override // mcc.o
    public final void r(View r100, UrlInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "urlInfo");
        o r102 = this.I;
        if (r102 == null) goto L6;
        r102.r(r100, r101);
        return;
    }

    @Override // mcc.o
    public final boolean t(View r100, UrlInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "urlInfo");
        o r102 = this.I;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.t(r100, r101);
    }

    public final CharSequence x(CharSequence r100, float r101) {
        boolean r102 = this.f445959u;
        if (r102 == false) goto L5;
    L6:
        TextUtils.TruncateAt r103 = this.f445957s;
        if (r103 == null) goto L14;
        if (r102 == false) goto L10;
        int r104 = 1;
    L11:
        TextPaint r105 = lcc.a.f508641a;
        float r106 = r101 * r104;
        float r107 = this.f445949l;
        Intrinsics.checkNotNull(r103);
        return lcc.a.C6677a.a(r100, r106, r107, r103);
    L10:
        r104 = this.f445953p;
        goto L11
    L14:
        return r100;
    L5:
        if (this.f445953p != Integer.MAX_VALUE) goto L6;
        return r100;
    }

    public final Layout y(CharSequence r100, int r101) {
        boolean r102 = r100 instanceof Spanned;
        int r103 = 0;
        if (r102 == false) goto L9;
        com.ss.android.lark.widget.light.span.k[] r104 = (com.ss.android.lark.widget.light.span.k[]) ((Spanned) r100).getSpans(0, r100.length(), com.ss.android.lark.widget.light.span.k.class);
        if (r104 == null) goto L9;
        int r105 = r104.length;
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L9;
        r104[r106].b(r101);
        r106 = r106 + 1;
    L9:
        TextLayoutBuilder r107 = new TextLayoutBuilder();
        r107.h(r100);
        r107.j(this.f445949l);
        r107.i(this.f445950m);
        r107.e(this.f445953p);
        r107.d(this.f445957s);
        r107.l(this.f445955q);
        r107.k(this.f445956r);
        r107.f(r101);
        r107.c(this.f445958t);
        boolean r108 = this.f445959u;
        TextLayoutBuilder.a r109 = r107.f446127c;
        Spanned r110 = null;
        if (r109.f446144m == r108) goto L12;
        r109.f446144m = r108;
        r107.f446128d = null;
    L12:
        r107.m(this.f445961w);
        boolean r111 = this.f445960v;
        TextLayoutBuilder.a r112 = r107.f446127c;
        if (r112.f446139h == r111) goto L15;
        r112.f446139h = r111;
        r107.f446128d = null;
    L15:
        r107.f446130f = false;
        r112.f446134c = this.f445964z;
        r107.g(this.f445963y);
        com.ss.android.lark.widget.light.viewstub.f.a r113 = com.ss.android.lark.widget.light.viewstub.f.f446339a;
        Context r114 = getContext();
        r113.getClass();
        Intrinsics.checkNotNullParameter(r114, PerfLog.PARAM_KEY_CONTEXT_ID);
        r107.f446127c.f446150s = new com.ss.android.lark.widget.light.viewstub.e(r114);
        Layout r115 = r107.a();
        if (r115 == null) goto L25;
        if (r102 == false) goto L19;
        r110 = (Spanned) r100;
    L19:
        if (r110 == null) goto L25;
        com.ss.android.lark.widget.light.span.j[] r116 = (com.ss.android.lark.widget.light.span.j[]) r110.getSpans(0, r100.length(), com.ss.android.lark.widget.light.span.j.class);
        if (r116 == null) goto L25;
        int r117 = r116.length;
    L23:
        if (r103 >= r117) goto L25;
        r116[r103].d(r115.getWidth(), r115.getHeight());
        r103 = r103 + 1;
    L25:
        return r115;
    }

    public final void z(CharSequence r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        if (Objects.equals(r100, this.V) == false) goto L5;
        return;
    L5:
        v();
        this.V = r100;
        setLayoutInner(null);
        u(this.V);
        if (getDetachSkipRequestLayoutFg() == false) goto L8;
        if (r101 == false) goto L8;
        return;
    L8:
        requestLayout();
    }

    public LKUILightTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        this.f445949l = (int) UIHelper.sp2px(17.0f);
        this.f445950m = UIUtils.getColor(getContext(), R.color.text_title);
        this.f445951n = UIUtils.getColor(getContext(), R.color.udtoken_btn_text_bg_pri_pressed);
        this.f445952o = j08.b.c(getContext(), R.color.primary_fill_default, 0.2f);
        this.f445953p = Integer.MAX_VALUE;
        this.f445955q = 1.0f;
        this.f445956r = UIHelper.dp2px(2.5f);
        this.f445958t = Layout.Alignment.ALIGN_NORMAL;
        this.f445960v = true;
        int r103 = h18.e.f483540a;
        this.f445961w = h18.e.b(getContext(), 0);
        this.f445962x = 51;
        this.f445964z = UIHelper.dp2px(2.0f);
        TouchConsumeView.c r104 = TouchConsumeView.c.f446297c;
        this.W = TouchConsumeView.c.a.a();
        this.f445954p0 = new Path();
        this.P0 = new CopyOnWriteArrayList();
        this.f445944b1 = new ArrayList();
        this.f445946h1 = LazyKt.lazy(LKUILightTextView$underLinePaint$2.INSTANCE);
        this.f445948k1 = LazyKt.lazy(LKUILightTextView$detachSkipRequestLayoutFg$2.INSTANCE);
        com.ss.android.lark.widget.light.c r105 = new com.ss.android.lark.widget.light.c(getContext(), this);
        this.V0 = r105;
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.view.View");
        addView(r105);
        setWillNotDraw(false);
        bab.b.b(this);
    }

    @Override // mcc.b
    public final boolean c(View r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "userId");
        mcc.b r103 = this.F;
        if (r103 == null) goto L5;
        Intrinsics.checkNotNull(r103);
        return r103.c(r100, r101, r102);
    L5:
        return false;
    }

    @Override // mcc.b
    public final void d(View r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "userId");
        mcc.b r103 = this.F;
        if (r103 == null) goto L6;
        r103.d(r100, r101, r102);
        return;
    }

    @Override // mcc.j
    public final boolean f(View r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "name");
        j r103 = this.H;
        if (r103 != null) goto L7;
        return false;
    L7:
        return r103.f(r100, r101, r102);
    }

    @Override // mcc.j
    public final void k(View r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "name");
        j r103 = this.H;
        if (r103 == null) goto L6;
        r103.k(r100, r101, r102);
        return;
    }

    public static void A(CharSequence r100, int r101, int r102, Function2 r103) {
    L2:
        if (r101 >= r102) goto L16;
        int r104 = r101;
    L5:
        if (r101 >= r102) goto L10;
        if (r104 != r101) goto L10;
        if (r100.charAt(r101) != '\n') goto L10;
        r104 = r104 + 1;
        r101 = r101 + 1;
    L10:
        if (r101 >= r102) goto L14;
        if (r100.charAt(r101) == '\n') goto L14;
        r101 = r101 + 1;
    L14:
        if (r101 <= r104) goto L2;
        r103.invoke(Integer.valueOf(r104), Integer.valueOf(r101));
        goto L2
    }

    @Override // mcc.i
    public final boolean o(View r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "name");
        i r104 = this.G;
        if (r104 == null) goto L5;
        Intrinsics.checkNotNull(r104);
        return r104.o(r100, r101, r102, r103);
    L5:
        return false;
    }

    @Override // mcc.a
    public final void s(View r100, AbbreviationInfo r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "abbreviationInfo");
        mcc.a r104 = this.K;
        if (r104 == null) goto L6;
        r104.s(r100, r101, r102, r103);
        return;
    }

    @Override // com.ss.android.lark.widget.select.SelectableView, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        Iterator<View> r105 = ViewGroupKt.getChildren(this).iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        View r106 = r105.next();
        int r107 = MathKt.roundToInt(getTotalPaddingLeft());
        int r108 = MathKt.roundToInt(getTotalPaddingTop$linked_emoji_release());
        int r109 = r106.getMeasuredWidth();
        r106.layout(r107, r108, r109 + r107, r106.getMeasuredHeight() + r108);
        goto L4
    }

    @Override // mcc.i
    public final void p(View r100, String r101, String r110, boolean r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r110, "name");
        i r102 = this.G;
        if (r102 == null) goto L6;
        r102.p(r100, r101, r110, r111, r112);
        return;
    }
}
