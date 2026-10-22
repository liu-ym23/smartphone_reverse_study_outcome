package com.larus.common_ui.widget.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import android.widget.SeekBar;
import androidx.core.content.ContextCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ñ\u00012\u00020\u0001:\u0006ï\u0001ð\u0001ñ\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\n\u0010¸\u0001\u001a\u00030¹\u0001H\u0004J$\u0010º\u0001\u001a\u00030¹\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010»\u0001\u001a\u00030¹\u00012\b\u0010³\u0001\u001a\u00030\u0096\u0001J\u0019\u0010¼\u0001\u001a\u00030¹\u00012\t\u0010½\u0001\u001a\u0004\u0018\u00010\u0007¢\u0006\u0003\u0010¾\u0001J\n\u0010¿\u0001\u001a\u00030¹\u0001H\u0004J\n\u0010À\u0001\u001a\u00030¹\u0001H\u0004J\n\u0010Á\u0001\u001a\u00030¹\u0001H\u0002J\n\u0010Â\u0001\u001a\u00030¹\u0001H\u0002J\n\u0010Ã\u0001\u001a\u00030¹\u0001H\u0002J\u0014\u0010Ä\u0001\u001a\u00030¹\u00012\b\u0010Å\u0001\u001a\u00030Æ\u0001H\u0014J\n\u0010Ç\u0001\u001a\u00030¹\u0001H\u0004J\u001c\u0010È\u0001\u001a\u00030¹\u00012\u0007\u0010É\u0001\u001a\u00020\u00072\u0007\u0010Ê\u0001\u001a\u00020\u0007H\u0014J\n\u0010Ë\u0001\u001a\u00030¹\u0001H\u0004J\u0014\u0010Ì\u0001\u001a\u00030\u0096\u00012\b\u0010Í\u0001\u001a\u00030Î\u0001H\u0016J\n\u0010Ï\u0001\u001a\u00030¹\u0001H\u0016J\u0013\u0010Ð\u0001\u001a\u00030¹\u00012\u0007\u0010Ñ\u0001\u001a\u00020\u0007H\u0004J\u0013\u0010Ò\u0001\u001a\u00030¹\u00012\u0007\u0010Ó\u0001\u001a\u00020\u0007H\u0002J\u0010\u0010Ô\u0001\u001a\u00020\u00002\u0007\u0010Õ\u0001\u001a\u00020\u0007J\u0010\u0010Ö\u0001\u001a\u00020\u00002\u0007\u0010×\u0001\u001a\u00020\u0007J\u0007\u0010Ø\u0001\u001a\u00020\u0007J\u0007\u0010Ù\u0001\u001a\u00020\u0007J\u0010\u0010Ú\u0001\u001a\u00020\u00002\u0007\u0010Û\u0001\u001a\u00020\u0007J\u0007\u0010Ü\u0001\u001a\u00020\u0007J\u0010\u0010Ý\u0001\u001a\u00020\u00002\u0007\u0010Þ\u0001\u001a\u00020\u0007J\u0010\u0010ß\u0001\u001a\u00020\u00002\u0007\u0010à\u0001\u001a\u00020BJ\u0010\u0010á\u0001\u001a\u00020\u00002\u0007\u0010Þ\u0001\u001a\u00020\u0007J\u0013\u0010â\u0001\u001a\u00020\u00002\n\u0010ã\u0001\u001a\u0005\u0018\u00010\u009e\u0001J\u001e\u0010ä\u0001\u001a\u00020\u00002\u000f\u0010å\u0001\u001a\n\u0012\u0004\u0012\u00020Z\u0018\u00010+¢\u0006\u0003\u0010æ\u0001J\u0016\u0010ç\u0001\u001a\u00030¹\u00012\n\u0010è\u0001\u001a\u0005\u0018\u00010é\u0001H\u0016J\u001f\u0010ê\u0001\u001a\u00030\u0096\u00012\u0007\u0010ë\u0001\u001a\u00020\u00072\n\u0010ì\u0001\u001a\u0005\u0018\u00010í\u0001H\u0016J\t\u0010î\u0001\u001a\u00020ZH\u0002R\u001a\u0010\n\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R(\u0010*\u001a\u000e\u0012\n\u0012\b\u0018\u00010,R\u00020\u00000+X\u0084.¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00102\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\f\"\u0004\b4\u0010\u000eR\u001a\u00105\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\f\"\u0004\b7\u0010\u000eR\u001a\u00108\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\f\"\u0004\b:\u0010\u000eR\u001a\u0010;\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\f\"\u0004\b=\u0010\u000eR\u001a\u0010>\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\f\"\u0004\b@\u0010\u000eR\u001a\u0010A\u001a\u00020BX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\f\"\u0004\bI\u0010\u000eR\u001a\u0010J\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\f\"\u0004\bL\u0010\u000eR\u001a\u0010M\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\f\"\u0004\bO\u0010\u000eR\u001a\u0010P\u001a\u00020BX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010D\"\u0004\bR\u0010FR\u001a\u0010S\u001a\u00020BX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010D\"\u0004\bU\u0010FR\u001a\u0010V\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\f\"\u0004\bX\u0010\u000eR\u001c\u0010Y\u001a\u0004\u0018\u00010ZX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001a\u0010_\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\f\"\u0004\ba\u0010\u000eR\u001a\u0010b\u001a\u00020BX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010D\"\u0004\bd\u0010FR\u001a\u0010e\u001a\u00020fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001a\u0010k\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\f\"\u0004\bm\u0010\u000eR\u000e\u0010n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010o\u001a\u0004\u0018\u00010pX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001c\u0010u\u001a\u0004\u0018\u00010%X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010'\"\u0004\bw\u0010)R\u001a\u0010x\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010\f\"\u0004\bz\u0010\u000eR\u001d\u0010{\u001a\u0004\u0018\u00010|X\u0084\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R \u0010\u0081\u0001\u001a\u0004\u0018\u00010|X\u0084\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0082\u0001\u0010~\"\u0006\b\u0083\u0001\u0010\u0080\u0001R\u000f\u0010\u0084\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0085\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0086\u0001\u001a\u00020\u0007X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010\f\"\u0005\b\u0088\u0001\u0010\u000eR\u001d\u0010\u0089\u0001\u001a\u00020\u0007X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010\f\"\u0005\b\u008b\u0001\u0010\u000eR\u001d\u0010\u008c\u0001\u001a\u00020\u0007X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010\f\"\u0005\b\u008e\u0001\u0010\u000eR\u001d\u0010\u008f\u0001\u001a\u00020\u0007X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010\f\"\u0005\b\u0091\u0001\u0010\u000eR\u001d\u0010\u0092\u0001\u001a\u00020\u0007X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010\f\"\u0005\b\u0094\u0001\u0010\u000eR \u0010\u0095\u0001\u001a\u00030\u0096\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0012\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R&\u0010£\u0001\u001a\t\u0012\u0004\u0012\u00020Z0¤\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R\u001d\u0010©\u0001\u001a\u00020\u0007X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bª\u0001\u0010\f\"\u0005\b«\u0001\u0010\u000eR\u000f\u0010¬\u0001\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u00ad\u0001\u001a\n\u0012\u0004\u0012\u00020Z\u0018\u00010+X\u0086\u000e¢\u0006\u0015\n\u0003\u0010²\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R\u0010\u0010³\u0001\u001a\u00030\u0096\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010´\u0001\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bµ\u0001\u0010\f\"\u0005\b¶\u0001\u0010\u000eR\u0010\u0010·\u0001\u001a\u00030\u0096\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006ò\u0001"}, d2 = {"Lcom/larus/common_ui/widget/datepicker/NumberPicker;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mWidth", "getMWidth", "()I", "setMWidth", "(I)V", "mHeight", "getMHeight", "setMHeight", "mTextPaint", "Landroid/text/TextPaint;", "getMTextPaint", "()Landroid/text/TextPaint;", "setMTextPaint", "(Landroid/text/TextPaint;)V", "mFlagTextPaint", "getMFlagTextPaint", "setMFlagTextPaint", "mTextShadowPaint", "getMTextShadowPaint", "setMTextShadowPaint", "mDividerLinePaint", "Landroid/graphics/Paint;", "getMDividerLinePaint", "()Landroid/graphics/Paint;", "setMDividerLinePaint", "(Landroid/graphics/Paint;)V", "mTextBounds", "Landroid/graphics/Rect;", "getMTextBounds", "()Landroid/graphics/Rect;", "setMTextBounds", "(Landroid/graphics/Rect;)V", "mTextYAxisArray", "", "Lcom/larus/common_ui/widget/datepicker/NumberPicker$NumberHolder;", "getMTextYAxisArray", "()[Lcom/larus/common_ui/widget/datepicker/NumberPicker$NumberHolder;", "setMTextYAxisArray", "([Lcom/larus/common_ui/widget/datepicker/NumberPicker$NumberHolder;)V", "[Lcom/larus/common_ui/widget/datepicker/NumberPicker$NumberHolder;", "mStartYPos", "getMStartYPos", "setMStartYPos", "mEndYPos", "getMEndYPos", "setMEndYPos", "mTextColor", "getMTextColor", "setMTextColor", "mTextShadowColor", "getMTextShadowColor", "setMTextShadowColor", "mDividerColor", "getMDividerColor", "setMDividerColor", "mTextSize", "", "getMTextSize", "()F", "setMTextSize", "(F)V", "mStartNumber", "getMStartNumber", "setMStartNumber", "mEndNumber", "getMEndNumber", "setMEndNumber", "mCurrentNumber", "getMCurrentNumber", "setMCurrentNumber", "mDividerStroke", "getMDividerStroke", "setMDividerStroke", "mDividerLength", "getMDividerLength", "setMDividerLength", "mVerticalSpacing", "getMVerticalSpacing", "setMVerticalSpacing", "mFlagText", "", "getMFlagText", "()Ljava/lang/String;", "setMFlagText", "(Ljava/lang/String;)V", "mFlagTextColor", "getMFlagTextColor", "setMFlagTextColor", "mFlagTextSize", "getMFlagTextSize", "setMFlagTextSize", "mNumberArray", "", "getMNumberArray", "()[I", "setMNumberArray", "([I)V", "mCurrNumIndex", "getMCurrNumIndex", "setMCurrNumIndex", "mTouchSlop", "mHighLightRect", "Landroid/graphics/RectF;", "getMHighLightRect", "()Landroid/graphics/RectF;", "setMHighLightRect", "(Landroid/graphics/RectF;)V", "mTextBoundsFlag", "getMTextBoundsFlag", "setMTextBoundsFlag", "mTouchAction", "getMTouchAction", "setMTouchAction", "mFlingScroller", "Landroid/widget/Scroller;", "getMFlingScroller", "()Landroid/widget/Scroller;", "setMFlingScroller", "(Landroid/widget/Scroller;)V", "mAdjustScroller", "getMAdjustScroller", "setMAdjustScroller", "mMinimumFlingVelocity", "mMaximumFlingVelocity", "mBackgroundColor", "getMBackgroundColor", "setMBackgroundColor", "mStartY", "getMStartY", "setMStartY", "mCurrY", "getMCurrY", "setMCurrY", "mOffsetY", "getMOffsetY", "setMOffsetY", "mSpacing", "getMSpacing", "setMSpacing", "mCanScroll", "", "getMCanScroll", "()Z", "setMCanScroll", "(Z)V", "mVelocityTracker", "Landroid/view/VelocityTracker;", "mOnValueChangeListener", "Lcom/larus/common_ui/widget/datepicker/NumberPicker$OnValueChangeListener;", "getMOnValueChangeListener", "()Lcom/larus/common_ui/widget/datepicker/NumberPicker$OnValueChangeListener;", "setMOnValueChangeListener", "(Lcom/larus/common_ui/widget/datepicker/NumberPicker$OnValueChangeListener;)V", "mDrawedText", "", "getMDrawedText", "()Ljava/util/Set;", "setMDrawedText", "(Ljava/util/Set;)V", "mRowNumber", "getMRowNumber", "setMRowNumber", "mDensity", "mTextArray", "getMTextArray", "()[Ljava/lang/String;", "setMTextArray", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "isNonRecurrent", "mCurrTextYAxisIndex", "getMCurrTextYAxisIndex", "setMCurrTextYAxisIndex", "maximizeScrollableItems", "createTextYAxisArray", "", "readAttrs", "setNonRecurrent", "increaseMaxFlingVelocity", "scrollVelocityFactor", "(Ljava/lang/Integer;)V", "init", "verifyNumber", "initPaint", "initRects", "measureText", "onDraw", "canvas", "Landroid/graphics/Canvas;", "adjustYPosition", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "initTextYAxisArray", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "computeScroll", "computeYPos", "offsetY", "fling", "startYVelocity", "setStartNumber", "startNumber", "setEndNumber", "endNumber", "getStartNumber", "getEndNumber", "setCurrentNumber", "currentNumber", "getCurrentNumber", "setTextColor", "color", "setTextSize", "textSize", "setBackground", "setOnValueChangeListener", "l", "setCustomTextArray", "textArray", "([Ljava/lang/String;)Lcom/larus/common_ui/widget/datepicker/NumberPicker;", "onInitializeAccessibilityNodeInfo", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "performAccessibilityAction", "action", "arguments", "Landroid/os/Bundle;", "getCurrentText", "NumberHolder", "OnValueChangeListener", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NumberPicker extends View {
    public static final int W = 0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f328596k0 = 0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final int f328597p0 = 0;
    public RectF A;
    public Rect B;
    public int C;
    public Scroller D;
    public Scroller E;
    public int F;
    public int G;
    public int H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f328598J;
    public int K;
    public int L;
    public boolean M;
    public VelocityTracker N;
    public c O;
    public Set<String> P;
    public int Q;
    public final float R;
    public String[] S;
    public boolean T;
    public int U;
    public boolean V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f328599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f328600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextPaint f328601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextPaint f328602d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextPaint f328603e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f328604f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Rect f328605g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b[] f328606h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f328607i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f328608j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f328609k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f328610l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f328611m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f328612n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f328613o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f328614p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f328615q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f328616r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f328617s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f328618t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f328619u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f328620v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f328621w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int[] f328622x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f328623y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f328624z;

    public static final class a {
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f328625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f328626b;

        public b(int r100, int r101) {
            this.f328625a = r100;
            this.f328626b = r101;
        }
    }

    public interface c {
        void a(NumberPicker r100, int r101);
    }

    public NumberPicker(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public NumberPicker(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    static {
        W = Color.rgb(0, 150, 136);
        f328596k0 = Color.rgb(0, 150, 136);
        f328597p0 = Color.rgb(255, 255, 255);
    }

    private final String getCurrentText() {
        String[] r100 = this.S;
        if (r100 == null) goto L6;
        String r101 = r100[this.f328623y];
        if (r101 == null) goto L6;
        return r101;
    L6:
        Integer r102 = ArraysKt.getOrNull(getMNumberArray(), this.f328623y);
        if (r102 != null) goto L12;
        return "";
    L12:
        return r102.toString();
    }

    public final void a() {
        Scroller r100 = this.E;
        Intrinsics.checkNotNull(r100);
        if (r100.isFinished() == false) goto L8;
        this.I = 0;
        b r101 = getMTextYAxisArray()[0];
        Intrinsics.checkNotNull(r101);
        int r102 = this.f328607i + (Math.round((r101.f328626b - this.f328607i) / this.L) * this.L);
        b r103 = getMTextYAxisArray()[0];
        Intrinsics.checkNotNull(r103);
        int r104 = r102 - r103.f328626b;
        if (r104 == 0) goto L9;
        Scroller r105 = this.E;
        Intrinsics.checkNotNull(r105);
        r105.startScroll(0, 0, 0, r104, 300);
        return;
    L9:
        return;
    }

    public final void c() {
        int r100 = 0;
        if (this.T == false) goto L8;
        this.U = getMTextYAxisArray().length / 2;
        int r101 = getMTextYAxisArray().length;
    L5:
        if (r100 >= r101) goto L7;
        getMTextYAxisArray()[r100] = new b((this.f328623y - 3) + r100, this.f328607i + (this.L * r100));
        r100 = r100 + 1;
        goto L5
    L7:
        return;
    L8:
        int r102 = getMTextYAxisArray().length;
    L9:
        if (r100 >= r102) goto L17;
        b r103 = new b((this.f328623y - 3) + r100, this.f328607i + (this.L * r100));
        if (r103.f328625a <= (getMNumberArray().length - 1)) goto L13;
        r103.f328625a -= getMNumberArray().length;
    L16:
        getMTextYAxisArray()[r100] = r103;
        r100 = r100 + 1;
        goto L9
    L13:
        int r104 = r103.f328625a;
        if (r104 >= 0) goto L16;
        r103.f328625a = r104 + getMNumberArray().length;
        goto L16
    }

    @Override // android.view.View
    public final void computeScroll() {
        Scroller r100 = this.D;
        Intrinsics.checkNotNull(r100);
        if (r100.isFinished() == false) goto L7;
        r100 = this.E;
        Intrinsics.checkNotNull(r100);
        if (r100.isFinished() == false) goto L7;
        return;
    L7:
        r100.computeScrollOffset();
        int r101 = r100.getCurrY();
        this.f328598J = r101;
        int r102 = r101 - this.I;
        this.K = r102;
        b(r102);
        invalidate();
        this.I = this.f328598J;
    }

    public final void f() {
        int r100 = this.f328613o;
        int r101 = 0;
        if (r100 >= 0) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L24;
        if (r100 <= this.f328614p) goto L13;
        this.f328614p = r100;
    L13:
        if (this.f328615q >= r100) goto L15;
        this.f328615q = r100;
    L15:
        int r103 = this.f328615q;
        int r104 = this.f328614p;
        if (r103 <= r104) goto L18;
        this.f328615q = r104;
    L18:
        setMNumberArray(new int[(r104 - r100) + 1]);
        int r105 = getMNumberArray().length;
    L19:
        if (r101 >= r105) goto L21;
        getMNumberArray()[r101] = this.f328613o + r101;
        r101 = r101 + 1;
        goto L19
    L21:
        this.f328623y = this.f328615q - this.f328613o;
        return;
    L24:
        throw new IllegalArgumentException("number can not be negative".toString());
    L5:
        if (this.f328614p < 0) goto L7;
        r102 = true;
        goto L8
    }

    public final int[] getMNumberArray() {
        int[] r100 = this.f328622x;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mNumberArray");
        return null;
    }

    public final b[] getMTextYAxisArray() {
        b[] r100 = this.f328606h;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mTextYAxisArray");
        return null;
    }

    public final int getCurrentNumber() {
        return this.f328615q;
    }

    public final int getEndNumber() {
        return this.f328614p;
    }

    public final Scroller getMAdjustScroller() {
        return this.E;
    }

    public final int getMBackgroundColor() {
        return this.H;
    }

    public final boolean getMCanScroll() {
        return this.M;
    }

    public final int getMCurrNumIndex() {
        return this.f328623y;
    }

    public final int getMCurrTextYAxisIndex() {
        return this.U;
    }

    public final int getMCurrY() {
        return this.f328598J;
    }

    public final int getMCurrentNumber() {
        return this.f328615q;
    }

    public final int getMDividerColor() {
        return this.f328611m;
    }

    public final float getMDividerLength() {
        return this.f328617s;
    }

    public final Paint getMDividerLinePaint() {
        return this.f328604f;
    }

    public final float getMDividerStroke() {
        return this.f328616r;
    }

    public final Set<String> getMDrawedText() {
        return this.P;
    }

    public final int getMEndNumber() {
        return this.f328614p;
    }

    public final int getMEndYPos() {
        return this.f328608j;
    }

    public final String getMFlagText() {
        return this.f328619u;
    }

    public final int getMFlagTextColor() {
        return this.f328620v;
    }

    public final TextPaint getMFlagTextPaint() {
        return this.f328602d;
    }

    public final float getMFlagTextSize() {
        return this.f328621w;
    }

    public final Scroller getMFlingScroller() {
        return this.D;
    }

    public final int getMHeight() {
        return this.f328600b;
    }

    public final RectF getMHighLightRect() {
        return this.A;
    }

    public final int getMOffsetY() {
        return this.K;
    }

    public final c getMOnValueChangeListener() {
        return this.O;
    }

    public final int getMRowNumber() {
        return this.Q;
    }

    public final int getMSpacing() {
        return this.L;
    }

    public final int getMStartNumber() {
        return this.f328613o;
    }

    public final int getMStartY() {
        return this.I;
    }

    public final int getMStartYPos() {
        return this.f328607i;
    }

    public final String[] getMTextArray() {
        return this.S;
    }

    public final Rect getMTextBounds() {
        return this.f328605g;
    }

    public final Rect getMTextBoundsFlag() {
        return this.B;
    }

    public final int getMTextColor() {
        return this.f328609k;
    }

    public final TextPaint getMTextPaint() {
        return this.f328601c;
    }

    public final int getMTextShadowColor() {
        return this.f328610l;
    }

    public final TextPaint getMTextShadowPaint() {
        return this.f328603e;
    }

    public final float getMTextSize() {
        return this.f328612n;
    }

    public final int getMTouchAction() {
        return this.C;
    }

    public final int getMVerticalSpacing() {
        return this.f328618t;
    }

    public final int getMWidth() {
        return this.f328599a;
    }

    public final int getStartNumber() {
        return this.f328613o;
    }

    public final void b(int r100) {
        int r101 = 0;
        if (this.T == false) goto L51;
        b r102 = getMTextYAxisArray()[this.U];
        Intrinsics.checkNotNull(r102);
        if (r102.f328626b <= (this.f328600b + this.L)) goto L9;
        if (this.f328623y >= 10) goto L9;
    L13:
        b r103 = getMTextYAxisArray()[this.U];
        Intrinsics.checkNotNull(r103);
        int r104 = r103.f328626b + r100;
        int r105 = this.f328600b / 2;
        if (r104 <= r105) goto L16;
        b r106 = getMTextYAxisArray()[this.U];
        Intrinsics.checkNotNull(r106);
        int r107 = r106.f328626b;
    L28:
        r100 = r105 - r107;
    L29:
        int r108 = getMTextYAxisArray().length;
    L30:
        if (r101 >= r108) goto L50;
        b r109 = getMTextYAxisArray()[r101];
        Intrinsics.checkNotNull(r109);
        r109.f328626b += r100;
        b r110 = getMTextYAxisArray()[r101];
        Intrinsics.checkNotNull(r110);
        if (r110.f328626b < (this.f328608j + this.L)) goto L34;
        b r111 = getMTextYAxisArray()[r101];
        Intrinsics.checkNotNull(r111);
        r111.f328626b -= (this.Q + 2) * this.L;
        b r112 = getMTextYAxisArray()[r101];
        Intrinsics.checkNotNull(r112);
        r112.f328625a -= this.Q + 2;
    L34:
        b r113 = getMTextYAxisArray()[r101];
        Intrinsics.checkNotNull(r113);
        if (r113.f328626b > (this.f328607i - this.L)) goto L37;
        b r114 = getMTextYAxisArray()[r101];
        Intrinsics.checkNotNull(r114);
        r114.f328626b += (this.Q + 2) * this.L;
        b r115 = getMTextYAxisArray()[r101];
        Intrinsics.checkNotNull(r115);
        r115.f328625a += this.Q + 2;
    L37:
        b r116 = getMTextYAxisArray()[r101];
        Intrinsics.checkNotNull(r116);
        if (Math.abs(r116.f328626b - (this.f328600b / 2)) >= (this.L / 4)) goto L49;
        int r117 = this.f328615q;
        b r118 = getMTextYAxisArray()[r101];
        Intrinsics.checkNotNull(r118);
        if (r118.f328625a < 0) goto L45;
        b r119 = getMTextYAxisArray()[r101];
        Intrinsics.checkNotNull(r119);
        if (r119.f328625a >= getMNumberArray().length) goto L45;
        this.U = r101;
        b r120 = getMTextYAxisArray()[r101];
        Intrinsics.checkNotNull(r120);
        this.f328623y = r120.f328625a;
        this.f328615q = getMNumberArray()[this.f328623y];
    L45:
        if (r117 == this.f328615q) goto L49;
        c r121 = this.O;
        if (r121 == null) goto L49;
        Intrinsics.checkNotNull(r121);
        r121.a(this, this.f328615q);
    L49:
        r101 = r101 + 1;
        goto L30
    L50:
        return;
    L16:
        b r122 = getMTextYAxisArray()[this.U];
        Intrinsics.checkNotNull(r122);
        if (r122.f328626b >= 0) goto L21;
        if (this.f328623y <= (getMNumberArray().length - 10)) goto L21;
    L25:
        b r123 = getMTextYAxisArray()[this.U];
        Intrinsics.checkNotNull(r123);
        int r124 = r123.f328626b + r100;
        r105 = this.f328600b / 2;
        if (r124 >= r105) goto L29;
        b r125 = getMTextYAxisArray()[this.U];
        Intrinsics.checkNotNull(r125);
        r107 = r125.f328626b;
    L21:
        if (this.f328623y != (getMNumberArray().length - 1)) goto L23;
        if (r100 < 0) goto L25;
    L23:
        b r126 = getMTextYAxisArray()[this.U];
        Intrinsics.checkNotNull(r126);
        if (r126.f328625a < (getMNumberArray().length - 1)) goto L29;
    L9:
        if (this.f328623y != 0) goto L11;
        if (r100 > 0) goto L13;
    L11:
        b r127 = getMTextYAxisArray()[this.U];
        Intrinsics.checkNotNull(r127);
        if (r127.f328625a > 0) goto L16;
    L51:
        int r128 = getMTextYAxisArray().length;
    L52:
        if (r101 >= r128) goto L76;
        b r129 = getMTextYAxisArray()[r101];
        Intrinsics.checkNotNull(r129);
        r129.f328626b += r100;
        b r130 = getMTextYAxisArray()[r101];
        Intrinsics.checkNotNull(r130);
        if (r130.f328626b < (this.f328608j + this.L)) goto L59;
        b r131 = getMTextYAxisArray()[r101];
        Intrinsics.checkNotNull(r131);
        r131.f328626b -= (this.Q + 2) * this.L;
        b r132 = getMTextYAxisArray()[r101];
        Intrinsics.checkNotNull(r132);
        r132.f328625a -= this.Q + 2;
    L56:
        b r133 = getMTextYAxisArray()[r101];
        Intrinsics.checkNotNull(r133);
        if (r133.f328625a >= 0) goto L59;
        b r134 = getMTextYAxisArray()[r101];
        Intrinsics.checkNotNull(r134);
        r134.f328625a += getMNumberArray().length;
    L59:
        b r135 = getMTextYAxisArray()[r101];
        Intrinsics.checkNotNull(r135);
        if (r135.f328626b > (this.f328607i - this.L)) goto L65;
        b r136 = getMTextYAxisArray()[r101];
        Intrinsics.checkNotNull(r136);
        r136.f328626b += (this.Q + 2) * this.L;
        b r137 = getMTextYAxisArray()[r101];
        Intrinsics.checkNotNull(r137);
        r137.f328625a += this.Q + 2;
    L62:
        b r138 = getMTextYAxisArray()[r101];
        Intrinsics.checkNotNull(r138);
        if (r138.f328625a <= (getMNumberArray().length - 1)) goto L65;
        b r139 = getMTextYAxisArray()[r101];
        Intrinsics.checkNotNull(r139);
        r139.f328625a -= getMNumberArray().length;
    L65:
        b r140 = getMTextYAxisArray()[r101];
        Intrinsics.checkNotNull(r140);
        if (Math.abs(r140.f328626b - (this.f328600b / 2)) >= (this.L / 4)) goto L75;
        b r141 = getMTextYAxisArray()[r101];
        Intrinsics.checkNotNull(r141);
        int r142 = Math.min(r141.f328625a, getMNumberArray().length - 1);
        this.f328623y = r142;
        int r143 = this.f328615q;
        if (r142 < 0) goto L71;
        this.f328615q = getMNumberArray()[this.f328623y];
    L71:
        if (r143 == this.f328615q) goto L75;
        c r144 = this.O;
        if (r144 == null) goto L75;
        Intrinsics.checkNotNull(r144);
        r144.a(this, this.f328615q);
    L75:
        r101 = r101 + 1;
        goto L52
    }

    public final void d(int r100) {
        this.f328614p = r100;
        f();
        c();
        invalidate();
    }

    public final void e(int r100) {
        this.f328613o = r100;
        f();
        c();
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        r110.drawColor(this.H);
        int r100 = 0;
        if (this.f328617s != 0.0f) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        this.f328617s = this.f328599a;
    L8:
        float r102 = this.f328617s;
        int r103 = this.f328599a;
        if (r102 <= r103) goto L11;
        r102 = r103;
    L11:
        float r104 = r102 / 2;
        float r105 = (r103 / 2) - r104;
        float r106 = r104 + (r103 / 2);
        RectF r107 = this.A;
        Intrinsics.checkNotNull(r107);
        float r108 = r107.top;
        RectF r109 = this.A;
        Intrinsics.checkNotNull(r109);
        float r111 = r109.top;
        Paint r112 = this.f328604f;
        Intrinsics.checkNotNull(r112);
        r110.drawLine(r105, r108, r106, r111, r112);
        RectF r113 = this.A;
        Intrinsics.checkNotNull(r113);
        float r114 = r113.bottom;
        RectF r115 = this.A;
        Intrinsics.checkNotNull(r115);
        float r116 = r115.bottom;
        Paint r117 = this.f328604f;
        Intrinsics.checkNotNull(r117);
        r110.drawLine(r105, r114, r106, r116, r117);
        if (this.f328619u == null) goto L14;
        int r118 = this.f328599a;
        Rect r119 = this.f328605g;
        Intrinsics.checkNotNull(r119);
        int r120 = (int) (((r118 + r119.width()) / 2) + (this.R * 4));
        String r121 = this.f328619u;
        Intrinsics.checkNotNull(r121);
        int r122 = this.f328600b / 2;
        Rect r123 = this.f328605g;
        Intrinsics.checkNotNull(r123);
        float r124 = (r122 + (r123.height() / 2)) - 4;
        TextPaint r125 = this.f328602d;
        Intrinsics.checkNotNull(r125);
        r110.drawText(r121, r120, r124, r125);
    L14:
        int r126 = getMTextYAxisArray().length;
    L15:
        if (r100 >= r126) goto L35;
        b r127 = getMTextYAxisArray()[r100];
        Intrinsics.checkNotNull(r127);
        if (r127.f328625a < 0) goto L34;
        b r128 = getMTextYAxisArray()[r100];
        Intrinsics.checkNotNull(r128);
        if (r128.f328625a > (this.f328614p - this.f328613o)) goto L34;
        b r129 = getMTextYAxisArray()[r100];
        Intrinsics.checkNotNull(r129);
        if (r129.f328625a < 0) goto L28;
        b r130 = getMTextYAxisArray()[r100];
        Intrinsics.checkNotNull(r130);
        if (r130.f328625a >= getMNumberArray().length) goto L28;
        String[] r131 = this.S;
        if (r131 == null) goto L27;
        Intrinsics.checkNotNull(r131);
        int[] r132 = getMNumberArray();
        b r133 = getMTextYAxisArray()[r100];
        Intrinsics.checkNotNull(r133);
        String r134 = r131[r132[r133.f328625a] - 1];
    L29:
        this.P.contains(r134);
        float r135 = this.f328599a / 2;
        b r136 = getMTextYAxisArray()[r100];
        Intrinsics.checkNotNull(r136);
        int r137 = r136.f328626b;
        Rect r138 = this.f328605g;
        Intrinsics.checkNotNull(r138);
        float r139 = r137 + (r138.height() / 2);
        b r140 = getMTextYAxisArray()[r100];
        Intrinsics.checkNotNull(r140);
        if (r140.f328625a != this.f328623y) goto L32;
        TextPaint r141 = this.f328601c;
    L33:
        Intrinsics.checkNotNull(r141);
        r110.drawText(r134, r135, r139, r141);
        this.P.add(r134);
        goto L34
    L32:
        r141 = this.f328603e;
        goto L33
    L27:
        int[] r142 = getMNumberArray();
        b r143 = getMTextYAxisArray()[r100];
        Intrinsics.checkNotNull(r143);
        r134 = String.valueOf(r142[r143.f328625a]);
    L28:
        r134 = "";
    L34:
        r100 = r100 + 1;
        goto L15
    L35:
        this.P.clear();
        if (1 != this.C) goto L45;
        Scroller r144 = this.D;
        Intrinsics.checkNotNull(r144);
        if (r144.isFinished() == false) goto L46;
        a();
        return;
    L46:
        return;
    L45:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r100) {
        super.onInitializeAccessibilityNodeInfo(r100);
        if (r100 == null) goto L6;
        r100.setScrollable(true);
        r100.setClassName(SeekBar.class.getName());
        r100.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
        r100.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if (isEnabled() == true) goto L6;
        return false;
    L6:
        if (this.N != null) goto L8;
        this.N = VelocityTracker.obtain();
    L8:
        VelocityTracker r100 = this.N;
        Intrinsics.checkNotNull(r100);
        r100.addMovement(r110);
        int r101 = MotionEventCompat.getActionMasked(r110);
        this.C = r101;
        if (r101 != 0) goto L16;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.I = (int) r110.getY();
        Scroller r111 = this.D;
        Intrinsics.checkNotNull(r111);
        if (r111.isFinished() == false) goto L14;
        Scroller r112 = this.E;
        Intrinsics.checkNotNull(r112);
        if (r112.isFinished() == false) goto L14;
    L48:
        return true;
    L14:
        Scroller r113 = this.D;
        Intrinsics.checkNotNull(r113);
        r113.forceFinished(true);
        Scroller r114 = this.E;
        Intrinsics.checkNotNull(r114);
        r114.forceFinished(true);
        goto L48
    L16:
        if (2 != r101) goto L29;
        int r115 = (int) r110.getY();
        this.f328598J = r115;
        int r116 = r115 - this.I;
        this.K = r116;
        if (this.M == false) goto L20;
    L22:
        this.M = true;
        int r117 = this.K;
        int r102 = this.f328624z;
        if (r117 <= r102) goto L26;
        this.K = r117 - r102;
    L28:
        this.I = this.f328598J;
        b(this.K);
        invalidate();
        goto L48
    L26:
        if (r117 >= (-r102)) goto L28;
        this.K = r117 + r102;
        goto L28
    L20:
        if (Math.abs(r116) >= this.f328624z) goto L22;
        return false;
    L29:
        if (1 != r101) goto L48;
        this.M = false;
        VelocityTracker r118 = this.N;
        Intrinsics.checkNotNull(r118);
        r118.computeCurrentVelocity(1000, this.G);
        int r103 = (int) r118.getYVelocity();
        if (Math.abs(r103) > this.F) goto L33;
        a();
        invalidate();
    L47:
        VelocityTracker r119 = this.N;
        Intrinsics.checkNotNull(r119);
        r119.recycle();
        this.N = null;
        goto L48
    L33:
        if (r103 > 0) goto L35;
        if (r103 < 0) goto L41;
    L45:
        invalidate();
        goto L47
    L41:
        if (this.V == false) goto L43;
        int r120 = Integer.MAX_VALUE;
    L44:
        this.I = r120;
        Scroller r104 = this.D;
        Intrinsics.checkNotNull(r104);
        r104.fling(0, r120, 0, r103, 0, 0, 0, r120);
        goto L45
    L43:
        r120 = (int) (this.f328612n * 10);
        goto L44
    L35:
        if (this.V == false) goto L37;
        int r121 = Integer.MAX_VALUE;
    L38:
        this.I = 0;
        Scroller r105 = this.D;
        Intrinsics.checkNotNull(r105);
        r105.fling(0, 0, 0, r103, 0, 0, 0, r121);
        goto L45
    L37:
        r121 = (int) (this.f328612n * 10);
        goto L38
    }

    public final void setMAdjustScroller(Scroller r100) {
        this.E = r100;
    }

    public final void setMBackgroundColor(int r100) {
        this.H = r100;
    }

    public final void setMCanScroll(boolean r100) {
        this.M = r100;
    }

    public final void setMCurrNumIndex(int r100) {
        this.f328623y = r100;
    }

    public final void setMCurrTextYAxisIndex(int r100) {
        this.U = r100;
    }

    public final void setMCurrY(int r100) {
        this.f328598J = r100;
    }

    public final void setMCurrentNumber(int r100) {
        this.f328615q = r100;
    }

    public final void setMDividerColor(int r100) {
        this.f328611m = r100;
    }

    public final void setMDividerLength(float r100) {
        this.f328617s = r100;
    }

    public final void setMDividerLinePaint(Paint r100) {
        this.f328604f = r100;
    }

    public final void setMDividerStroke(float r100) {
        this.f328616r = r100;
    }

    public final void setMDrawedText(Set<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.P = r100;
    }

    public final void setMEndNumber(int r100) {
        this.f328614p = r100;
    }

    public final void setMEndYPos(int r100) {
        this.f328608j = r100;
    }

    public final void setMFlagText(String r100) {
        this.f328619u = r100;
    }

    public final void setMFlagTextColor(int r100) {
        this.f328620v = r100;
    }

    public final void setMFlagTextPaint(TextPaint r100) {
        this.f328602d = r100;
    }

    public final void setMFlagTextSize(float r100) {
        this.f328621w = r100;
    }

    public final void setMFlingScroller(Scroller r100) {
        this.D = r100;
    }

    public final void setMHeight(int r100) {
        this.f328600b = r100;
    }

    public final void setMHighLightRect(RectF r100) {
        this.A = r100;
    }

    public final void setMNumberArray(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f328622x = r100;
    }

    public final void setMOffsetY(int r100) {
        this.K = r100;
    }

    public final void setMOnValueChangeListener(c r100) {
        this.O = r100;
    }

    public final void setMRowNumber(int r100) {
        this.Q = r100;
    }

    public final void setMSpacing(int r100) {
        this.L = r100;
    }

    public final void setMStartNumber(int r100) {
        this.f328613o = r100;
    }

    public final void setMStartY(int r100) {
        this.I = r100;
    }

    public final void setMStartYPos(int r100) {
        this.f328607i = r100;
    }

    public final void setMTextArray(String[] r100) {
        this.S = r100;
    }

    public final void setMTextBounds(Rect r100) {
        this.f328605g = r100;
    }

    public final void setMTextBoundsFlag(Rect r100) {
        this.B = r100;
    }

    public final void setMTextColor(int r100) {
        this.f328609k = r100;
    }

    public final void setMTextPaint(TextPaint r100) {
        this.f328601c = r100;
    }

    public final void setMTextShadowColor(int r100) {
        this.f328610l = r100;
    }

    public final void setMTextShadowPaint(TextPaint r100) {
        this.f328603e = r100;
    }

    public final void setMTextSize(float r100) {
        this.f328612n = r100;
    }

    public final void setMTextYAxisArray(b[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f328606h = r100;
    }

    public final void setMTouchAction(int r100) {
        this.C = r100;
    }

    public final void setMVerticalSpacing(int r100) {
        this.f328618t = r100;
    }

    public final void setMWidth(int r100) {
        this.f328599a = r100;
    }

    public final void setNonRecurrent(boolean r100) {
        this.T = r100;
        c();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getMode(r101);
        int r104 = View.MeasureSpec.getSize(r100);
        int r105 = View.MeasureSpec.getSize(r101);
        if (r102 == 1073741824) goto L6;
        Rect r106 = this.f328605g;
        Intrinsics.checkNotNull(r106);
        int r107 = (r106.width() + getPaddingLeft()) + getPaddingRight();
        Rect r108 = this.B;
        Intrinsics.checkNotNull(r108);
        r104 = (r107 + r108.width()) + 6;
    L6:
        this.f328599a = r104;
        if (r103 == 1073741824) goto L10;
        int r109 = this.Q;
        Rect r110 = this.f328605g;
        Intrinsics.checkNotNull(r110);
        r105 = getPaddingBottom() + (((r109 * r110.height()) + ((this.Q - 1) * this.f328618t)) + getPaddingTop());
    L10:
        this.f328600b = r105;
        setMeasuredDimension(this.f328599a, r105);
        if (this.A != null) goto L14;
        RectF r111 = new RectF();
        this.A = r111;
        Intrinsics.checkNotNull(r111);
        r111.left = 0.0f;
        RectF r112 = this.A;
        Intrinsics.checkNotNull(r112);
        r112.right = this.f328599a;
        RectF r113 = this.A;
        Intrinsics.checkNotNull(r113);
        int r114 = this.f328600b;
        Rect r115 = this.f328605g;
        Intrinsics.checkNotNull(r115);
        r113.top = ((r114 - r115.height()) - this.f328618t) / 2;
        RectF r116 = this.A;
        Intrinsics.checkNotNull(r116);
        int r117 = this.f328600b;
        Rect r118 = this.f328605g;
        Intrinsics.checkNotNull(r118);
        int r119 = r117 + r118.height();
        int r120 = this.f328618t;
        r116.bottom = (r119 + r120) / 2;
        Rect r121 = this.f328605g;
        Intrinsics.checkNotNull(r121);
        int r122 = r120 + r121.height();
        this.L = r122;
        int r123 = this.f328600b;
        this.f328607i = (r123 / 2) - (r122 * 3);
        this.f328608j = (r123 / 2) + (r122 * 3);
        c();
        return;
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int r100, Bundle r101) {
        if (r100 != 64) goto L5;
        ViewCompat.setStateDescription(this, getCurrentText());
        return super.performAccessibilityAction(r100, r101);
    L5:
        if (r100 != 4096) goto L7;
        b(-this.L);
        a();
        announceForAccessibility(getCurrentText());
        invalidate();
        return true;
    L7:
        if (r100 != 8192) goto L13;
        b(this.L);
        a();
        announceForAccessibility(getCurrentText());
        invalidate();
        return true;
    L13:
        return super.performAccessibilityAction(r100, r101);
    }

    public NumberPicker(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        this.C = 3;
        this.P = new HashSet();
        Resources r102 = getResources();
        float r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
        this.R = r103;
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.larus_backgroundColor, R.attr.larus_currentNumber, R.attr.larus_dateTextColor, R.attr.larus_dateTextShadowColor, R.attr.larus_dateTextSize, R.attr.larus_dividerColor, R.attr.larus_dividerLength, R.attr.larus_dividerStroke, R.attr.larus_endNumber, R.attr.larus_flagText, R.attr.larus_flagTextColor, R.attr.larus_flagTextSize, R.attr.larus_isNonReCurrent, R.attr.larus_rowNumber, R.attr.larus_startNumber, R.attr.larus_verticalSpacing}, r110, 0);
        this.f328609k = r104.getColor(2, ContextCompat.getColor(r100, v19.c.b(R.attr.larus_neutral_100, r100, R.color.larus_neutral_100)));
        this.f328612n = r104.getDimension(4, 32.0f * r103);
        this.f328610l = r104.getColor(3, ContextCompat.getColor(r100, v19.c.b(R.attr.larus_neutral_30, r100, R.color.larus_neutral_30)));
        this.f328611m = r104.getColor(5, W);
        this.f328613o = r104.getInteger(14, 0);
        this.f328614p = r104.getInteger(8, 0);
        this.f328615q = r104.getInteger(1, 0);
        this.f328618t = (int) r104.getDimension(15, 16 * r103);
        this.f328619u = r104.getString(9);
        this.f328620v = r104.getColor(10, f328596k0);
        this.f328621w = r104.getDimension(11, 12.0f * r103);
        this.H = r104.getColor(0, f328597p0);
        this.Q = r104.getInteger(13, 5);
        this.f328616r = r104.getDimension(7, 2 * r103);
        this.f328617s = r104.getDimension(6, 0.0f);
        r104.recycle();
        f();
        TextPaint r105 = new TextPaint();
        this.f328601c = r105;
        Intrinsics.checkNotNull(r105);
        r105.setTextSize(this.f328612n);
        TextPaint r106 = this.f328601c;
        Intrinsics.checkNotNull(r106);
        r106.setColor(this.f328609k);
        TextPaint r107 = this.f328601c;
        Intrinsics.checkNotNull(r107);
        r107.setFlags(1);
        TextPaint r108 = this.f328601c;
        Intrinsics.checkNotNull(r108);
        r108.setTextAlign(Paint.Align.CENTER);
        TextPaint r109 = new TextPaint(this.f328601c);
        this.f328603e = r109;
        Intrinsics.checkNotNull(r109);
        r109.setColor(this.f328610l);
        TextPaint r111 = new TextPaint();
        this.f328602d = r111;
        Intrinsics.checkNotNull(r111);
        r111.setTextSize(this.f328621w);
        TextPaint r112 = this.f328602d;
        Intrinsics.checkNotNull(r112);
        r112.setColor(this.f328620v);
        TextPaint r113 = this.f328602d;
        Intrinsics.checkNotNull(r113);
        r113.setFlags(1);
        TextPaint r114 = this.f328602d;
        Intrinsics.checkNotNull(r114);
        r114.setTextAlign(Paint.Align.LEFT);
        Paint r115 = new Paint();
        this.f328604f = r115;
        Intrinsics.checkNotNull(r115);
        r115.setColor(this.f328611m);
        Paint r116 = this.f328604f;
        Intrinsics.checkNotNull(r116);
        r116.setStyle(Paint.Style.STROKE);
        Paint r117 = this.f328604f;
        Intrinsics.checkNotNull(r117);
        r117.setStrokeWidth(this.f328616r);
        this.f328605g = new Rect();
        this.B = new Rect();
        int r118 = String.valueOf(this.f328614p).length();
        StringBuilder r119 = new StringBuilder();
        int r120 = 0;
    L3:
        if (r120 >= r118) goto L5;
        r119.append("0");
        r120 = r120 + 1;
        goto L3
    L5:
        String r121 = r119.toString();
        TextPaint r122 = this.f328601c;
        Intrinsics.checkNotNull(r122);
        r122.getTextBounds(r121, 0, r121.length(), this.f328605g);
        if (this.f328619u == null) goto L8;
        TextPaint r123 = this.f328602d;
        Intrinsics.checkNotNull(r123);
        String r124 = this.f328619u;
        Intrinsics.checkNotNull(r124);
        r123.getTextBounds(r124, 0, r124.length(), this.B);
    L8:
        ViewConfiguration r125 = ViewConfiguration.get(getContext());
        this.f328624z = ViewConfigurationCompat.getScaledPagingTouchSlop(r125);
        this.F = r125.getScaledMinimumFlingVelocity();
        this.G = r125.getScaledMaximumFlingVelocity() / 8;
        this.D = new Scroller(getContext(), null);
        this.E = new Scroller(getContext(), new DecelerateInterpolator(2.5f));
        setFocusable(true);
        setFocusableInTouchMode(true);
        setImportantForAccessibility(1);
        setMTextYAxisArray(new b[this.Q + 4]);
    }

    public /* synthetic */ NumberPicker(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
