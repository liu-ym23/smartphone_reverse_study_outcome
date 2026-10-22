package com.bytedance.android.ui.ec.widget.switchbutton;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.core.widget.TextViewCompat;
import com.bytedance.android.shopping.yata.business.function.ScrollPosition;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\bE\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0017\u0018\u0000 Ô\u00012\u00020\u0001:\u0002Ô\u0001B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u0090\u0001\u001a\u00030\u0091\u00012\u0007\u0010\u0092\u0001\u001a\u00020\nH\u0002J\n\u0010\u0093\u0001\u001a\u00030\u0091\u0001H\u0002J\n\u0010\u0094\u0001\u001a\u00030\u0091\u0001H\u0002J\n\u0010\u0095\u0001\u001a\u00030\u0091\u0001H\u0002J\u0014\u0010\u0096\u0001\u001a\u00030\u0091\u00012\b\u0010\u0097\u0001\u001a\u00030\u0098\u0001H\u0002J\u0014\u0010\u0099\u0001\u001a\u00030\u0091\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001H\u0016J\u001c\u0010\u009c\u0001\u001a\u00030\u0091\u00012\u0007\u0010\u009d\u0001\u001a\u0002052\u0007\u0010\u009e\u0001\u001a\u000205H\u0016J\n\u0010\u009f\u0001\u001a\u00030\u0091\u0001H\u0014J\t\u0010 \u0001\u001a\u00020\u0007H\u0016J\t\u0010¡\u0001\u001a\u00020\u0007H\u0016J\u001b\u0010¢\u0001\u001a\u00020\n2\u0007\u0010\u009d\u0001\u001a\u0002052\u0007\u0010\u009e\u0001\u001a\u000205H\u0002J\n\u0010£\u0001\u001a\u00030\u0091\u0001H\u0016J\u0016\u0010¤\u0001\u001a\u0004\u0018\u00010\u00152\t\u0010¥\u0001\u001a\u0004\u0018\u00010.H\u0002J\u0013\u0010¦\u0001\u001a\u00030§\u00012\u0007\u0010¨\u0001\u001a\u00020\u0007H\u0014J\u0014\u0010©\u0001\u001a\u00030\u0091\u00012\b\u0010ª\u0001\u001a\u00030\u009b\u0001H\u0014J\u0014\u0010«\u0001\u001a\u00030\u0091\u00012\b\u0010¬\u0001\u001a\u00030\u00ad\u0001H\u0016J\u0014\u0010®\u0001\u001a\u00030\u0091\u00012\b\u0010¯\u0001\u001a\u00030°\u0001H\u0016J7\u0010±\u0001\u001a\u00030\u0091\u00012\u0007\u0010²\u0001\u001a\u00020\n2\u0007\u0010³\u0001\u001a\u00020\u00072\u0007\u0010´\u0001\u001a\u00020\u00072\u0007\u0010µ\u0001\u001a\u00020\u00072\u0007\u0010¶\u0001\u001a\u00020\u0007H\u0014J\u001c\u0010·\u0001\u001a\u00030\u0091\u00012\u0007\u0010¸\u0001\u001a\u00020\u00072\u0007\u0010¹\u0001\u001a\u00020\u0007H\u0016J\u0014\u0010º\u0001\u001a\u00030\u0091\u00012\b\u0010¬\u0001\u001a\u00030\u00ad\u0001H\u0016J\u0013\u0010»\u0001\u001a\u00020\n2\b\u0010\u0097\u0001\u001a\u00030\u0098\u0001H\u0016J\u0013\u0010¼\u0001\u001a\u00030\u0091\u00012\u0007\u0010½\u0001\u001a\u00020\nH\u0016J\u0014\u0010¾\u0001\u001a\u00030\u0091\u00012\b\u0010¿\u0001\u001a\u00030À\u0001H\u0016J\u001b\u0010Á\u0001\u001a\u00030\u0091\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0007\u0010Â\u0001\u001a\u00020\u0007J\u0014\u0010Ã\u0001\u001a\u00030\u0091\u00012\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u0001J\u001d\u0010Ã\u0001\u001a\u00030\u0091\u00012\n\u0010Æ\u0001\u001a\u0005\u0018\u00010Å\u00012\u0007\u0010Ç\u0001\u001a\u00020\u0007J\u001c\u0010È\u0001\u001a\u00030\u0091\u00012\u0007\u0010É\u0001\u001a\u00020\u00072\u0007\u0010Ê\u0001\u001a\u00020\u0007H\u0002J\u0011\u0010Ë\u0001\u001a\u00030\u0091\u00012\u0007\u0010Ì\u0001\u001a\u000205J\u0011\u0010Í\u0001\u001a\u00030\u0091\u00012\u0007\u0010Î\u0001\u001a\u00020\u0007J\u0011\u0010Ï\u0001\u001a\u00030\u0091\u00012\u0007\u0010Î\u0001\u001a\u00020\u0007J\u0014\u0010Ð\u0001\u001a\u00030\u0091\u00012\b\u0010\u0097\u0001\u001a\u00030\u0098\u0001H\u0002J\n\u0010Ñ\u0001\u001a\u00030\u0091\u0001H\u0016J\u0012\u0010Ò\u0001\u001a\u00020\n2\u0007\u0010Ó\u0001\u001a\u000207H\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010J\u001a\n L*\u0004\u0018\u00010K0KX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010M\u001a\u00020\n2\u0006\u0010M\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bN\u0010\f\"\u0004\bO\u0010\u000eR$\u0010P\u001a\u00020\n2\u0006\u0010P\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bQ\u0010\f\"\u0004\bR\u0010\u000eR$\u0010T\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010Y\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bZ\u0010V\"\u0004\b[\u0010XR\u0014\u0010\\\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b]\u0010\fR(\u0010^\u001a\u0004\u0018\u00010.2\b\u0010^\u001a\u0004\u0018\u00010.8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR(\u0010c\u001a\u0004\u0018\u00010.2\b\u0010c\u001a\u0004\u0018\u00010.8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bd\u0010`\"\u0004\be\u0010bR$\u0010g\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bh\u0010V\"\u0004\bi\u0010XR$\u0010j\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bk\u0010V\"\u0004\bl\u0010XR(\u0010n\u001a\u0004\u0018\u0001072\b\u0010m\u001a\u0004\u0018\u0001078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u0014\u0010s\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bt\u0010VR\u0014\u0010u\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bv\u0010VR$\u0010w\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bx\u0010V\"\u0004\by\u0010XR(\u0010{\u001a\u0004\u0018\u00010,2\b\u0010z\u001a\u0004\u0018\u00010,8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR.\u0010\u0081\u0001\u001a\u0004\u0018\u00010A2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010A8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R,\u0010\u0087\u0001\u001a\u0004\u0018\u0001072\t\u0010\u0086\u0001\u001a\u0004\u0018\u0001078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0088\u0001\u0010p\"\u0005\b\u0089\u0001\u0010rR+\u0010\u008a\u0001\u001a\u0004\u0018\u00010,2\b\u0010z\u001a\u0004\u0018\u00010,8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008b\u0001\u0010}\"\u0005\b\u008c\u0001\u0010\u007fR.\u0010\u008d\u0001\u001a\u0004\u0018\u00010A2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010A8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u008e\u0001\u0010\u0083\u0001\"\u0006\b\u008f\u0001\u0010\u0085\u0001¨\u0006Õ\u0001"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/switchbutton/CustomSwitchCompat;", "Landroid/widget/CompoundButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "autoCheck", "", "getAutoCheck", "()Z", "setAutoCheck", "(Z)V", "mHasThumbTint", "mHasThumbTintMode", "mHasTrackTint", "mHasTrackTintMode", "mMinFlingVelocity", "mOffLayout", "Landroid/text/Layout;", "mOnLayout", "mPositionAnimator", "Landroid/animation/ObjectAnimator;", "getMPositionAnimator", "()Landroid/animation/ObjectAnimator;", "setMPositionAnimator", "(Landroid/animation/ObjectAnimator;)V", "mShowText", "mSplitTrack", "mSwitchBottom", "mSwitchHeight", "mSwitchLeft", "mSwitchMinWidth", "mSwitchPadding", "mSwitchRight", "mSwitchTop", "mSwitchTransformationMethod", "Landroid/text/method/TransformationMethod;", "mSwitchWidth", "mTempRect", "Landroid/graphics/Rect;", "mTextColors", "Landroid/content/res/ColorStateList;", "mTextOff", "", "mTextOn", "mTextPaint", "Landroid/text/TextPaint;", "mThumbConstraintLeft", "mThumbConstraintRight", "mThumbDragPosition", "", "mThumbDrawable", "Landroid/graphics/drawable/Drawable;", "mThumbHeight", "mThumbPosition", "getMThumbPosition", "()F", "setMThumbPosition", "(F)V", "mThumbTextPadding", "mThumbTintList", "mThumbTintMode", "Landroid/graphics/PorterDuff$Mode;", "mThumbWidth", "mTouchMode", "mTouchSlop", "mTouchX", "mTouchY", "mTrackDrawable", "mTrackTintList", "mTrackTintMode", "mVelocityTracker", "Landroid/view/VelocityTracker;", "kotlin.jvm.PlatformType", "showText", "getShowText", "setShowText", "splitTrack", "getSplitTrack", "setSplitTrack", "pixels", "switchMinWidth", "getSwitchMinWidth", "()I", "setSwitchMinWidth", "(I)V", "switchPadding", "getSwitchPadding", "setSwitchPadding", "targetCheckedState", "getTargetCheckedState", "textOff", "getTextOff", "()Ljava/lang/CharSequence;", "setTextOff", "(Ljava/lang/CharSequence;)V", "textOn", "getTextOn", "setTextOn", "value", "thumbConstraintLeft", "getThumbConstraintLeft", "setThumbConstraintLeft", "thumbConstraintRight", "getThumbConstraintRight", "setThumbConstraintRight", "thumb", "thumbDrawable", "getThumbDrawable", "()Landroid/graphics/drawable/Drawable;", "setThumbDrawable", "(Landroid/graphics/drawable/Drawable;)V", "thumbOffset", "getThumbOffset", "thumbScrollRange", "getThumbScrollRange", "thumbTextPadding", "getThumbTextPadding", "setThumbTextPadding", "tint", "thumbTintList", "getThumbTintList", "()Landroid/content/res/ColorStateList;", "setThumbTintList", "(Landroid/content/res/ColorStateList;)V", "tintMode", "thumbTintMode", "getThumbTintMode", "()Landroid/graphics/PorterDuff$Mode;", "setThumbTintMode", "(Landroid/graphics/PorterDuff$Mode;)V", "track", "trackDrawable", "getTrackDrawable", "setTrackDrawable", "trackTintList", "getTrackTintList", "setTrackTintList", "trackTintMode", "getTrackTintMode", "setTrackTintMode", "animateThumbToCheckedState", "", "newCheckedState", "applyThumbTint", "applyTrackTint", "cancelPositionAnimator", "cancelSuperTouch", "ev", "Landroid/view/MotionEvent;", "draw", "c", "Landroid/graphics/Canvas;", "drawableHotspotChanged", "x", "y", "drawableStateChanged", "getCompoundPaddingLeft", "getCompoundPaddingRight", "hitThumb", "jumpDrawablesToCurrentState", "makeLayout", "text", "onCreateDrawableState", "", "extraSpace", "onDraw", "canvas", "onInitializeAccessibilityEvent", "event", "Landroid/view/accessibility/AccessibilityEvent;", "onInitializeAccessibilityNodeInfo", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "onLayout", "changed", ScrollPosition.POSITION_LEFT, ScrollPosition.POSITION_TOP, ScrollPosition.POSITION_RIGHT, ScrollPosition.POSITION_BOTTOM, "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPopulateAccessibilityEvent", "onTouchEvent", "setChecked", "checked", "setCustomSelectionActionModeCallback", "actionModeCallback", "Landroid/view/ActionMode$Callback;", "setSwitchTextAppearance", "resid", "setSwitchTypeface", "typeface", "Landroid/graphics/Typeface;", "tf", "style", "setSwitchTypefaceByIndex", "typefaceIndex", "styleIndex", "setThumbPosition", "position", "setThumbResource", "resId", "setTrackResource", "stopDrag", "toggle", "verifyDrawable", "who", "Companion", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public class CustomSwitchCompat extends CompoundButton {
    private static final String ACCESSIBILITY_EVENT_CLASS_NAME = "android.widget.Switch";
    private static final int[] CHECKED_STATE_SET = null;
    public static final Companion Companion = null;
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int THUMB_ANIMATION_DURATION = 260;
    private static final Property<CustomSwitchCompat, Float> THUMB_POS = null;
    private static final int TOUCH_MODE_DOWN = 1;
    private static final int TOUCH_MODE_DRAGGING = 2;
    private static final int TOUCH_MODE_IDLE = 0;
    private boolean autoCheck;
    private boolean mHasThumbTint;
    private boolean mHasThumbTintMode;
    private boolean mHasTrackTint;
    private boolean mHasTrackTintMode;
    private final int mMinFlingVelocity;
    private Layout mOffLayout;
    private Layout mOnLayout;
    private ObjectAnimator mPositionAnimator;
    private boolean mShowText;
    private boolean mSplitTrack;
    private int mSwitchBottom;
    private int mSwitchHeight;
    private int mSwitchLeft;
    private int mSwitchMinWidth;
    private int mSwitchPadding;
    private int mSwitchRight;
    private int mSwitchTop;
    private TransformationMethod mSwitchTransformationMethod;
    private int mSwitchWidth;
    private final Rect mTempRect;
    private ColorStateList mTextColors;
    private CharSequence mTextOff;
    private CharSequence mTextOn;
    private final TextPaint mTextPaint;
    private int mThumbConstraintLeft;
    private int mThumbConstraintRight;
    private float mThumbDragPosition;
    private Drawable mThumbDrawable;
    private int mThumbHeight;
    private float mThumbPosition;
    private int mThumbTextPadding;
    private ColorStateList mThumbTintList;
    private PorterDuff.Mode mThumbTintMode;
    private int mThumbWidth;
    private int mTouchMode;
    private final int mTouchSlop;
    private float mTouchX;
    private float mTouchY;
    private Drawable mTrackDrawable;
    private ColorStateList mTrackTintList;
    private PorterDuff.Mode mTrackTintMode;
    private final VelocityTracker mVelocityTracker;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/switchbutton/CustomSwitchCompat$Companion;", "", "()V", "ACCESSIBILITY_EVENT_CLASS_NAME", "", "CHECKED_STATE_SET", "", "MONOSPACE", "", "SANS", "SERIF", "THUMB_ANIMATION_DURATION", "THUMB_POS", "Landroid/util/Property;", "Lcom/bytedance/android/ui/ec/widget/switchbutton/CustomSwitchCompat;", "", "TOUCH_MODE_DOWN", "TOUCH_MODE_DRAGGING", "TOUCH_MODE_IDLE", "constrain", "amount", "low", "high", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        private final float constrain(float r2, float r3, float r4) {
            if (r2 >= r3) goto L6;
            return r3;
        L6:
            if (r2 > r4) goto L8;
            return r2;
        L8:
            return r4;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static final /* synthetic */ float access$constrain(Companion r0, float r1, float r2, float r3) {
            return r0.constrain(r1, r2, r3);
        }
    }

    public CustomSwitchCompat(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public CustomSwitchCompat(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    static {
        Companion = new Companion(null);
        final Class r1 = Float.TYPE;
        final String r2 = "thumbPos";
        THUMB_POS = new CustomSwitchCompat$Companion$THUMB_POS$1(r1, r2);
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
    }

    private final void applyThumbTint() {
        Drawable r0 = this.mThumbDrawable;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mHasThumbTint == false) goto L7;
    L8:
        if (r0 == null) goto L10;
        Drawable r1 = r0.mutate();
    L11:
        this.mThumbDrawable = r1;
        if (this.mHasThumbTint == false) goto L16;
        if (r1 == null) goto L16;
        DrawableCompat.setTintList(r1, this.mThumbTintList);
    L16:
        if (this.mHasThumbTintMode == false) goto L21;
        Drawable r2 = this.mThumbDrawable;
        PorterDuff.Mode r3 = this.mThumbTintMode;
        if (r2 == null) goto L21;
        if (r3 == null) goto L21;
        DrawableCompat.setTintMode(r2, r3);
    L21:
        Drawable r4 = this.mThumbDrawable;
        if (r4 != null) goto L24;
        return;
    L24:
        if (r4.isStateful() != true) goto L32;
        Drawable r5 = this.mThumbDrawable;
        if (r5 == null) goto L33;
        r5.setState(getDrawableState());
        return;
    L33:
        return;
    L32:
        return;
    L10:
        r1 = null;
        goto L11
    L7:
        if (this.mHasThumbTintMode == true) goto L8;
    }

    private final void applyTrackTint() {
        Drawable r0 = this.mTrackDrawable;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mHasTrackTint == false) goto L7;
    L8:
        Drawable r1 = r0.mutate();
        this.mTrackDrawable = r1;
        if (this.mHasTrackTint == false) goto L13;
        if (r1 == null) goto L13;
        DrawableCompat.setTintList(r1, this.mTrackTintList);
    L13:
        if (this.mHasTrackTintMode == false) goto L18;
        Drawable r2 = this.mTrackDrawable;
        PorterDuff.Mode r3 = this.mTrackTintMode;
        if (r2 == null) goto L18;
        if (r3 == null) goto L18;
        DrawableCompat.setTintMode(r2, r3);
    L18:
        Drawable r4 = this.mTrackDrawable;
        if (r4 != null) goto L21;
        return;
    L21:
        if (r4.isStateful() != true) goto L29;
        Drawable r5 = this.mTrackDrawable;
        if (r5 == null) goto L30;
        r5.setState(getDrawableState());
        return;
    L30:
        return;
    L29:
        return;
    L7:
        if (this.mHasTrackTintMode == true) goto L8;
    }

    private final void cancelPositionAnimator() {
        ObjectAnimator r0 = this.mPositionAnimator;
        if (r0 == null) goto L7;
        if (r0 == null) goto L8;
        r0.cancel();
        return;
    L8:
        return;
    }

    private final boolean getTargetCheckedState() {
        if (this.mThumbDragPosition <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private final int getThumbScrollRange() {
        Drawable r0 = this.mTrackDrawable;
        if (r0 == null) goto L12;
        Rect r1 = this.mTempRect;
        if (r0 == null) goto L7;
        r0.getPadding(r1);
    L7:
        Drawable r2 = this.mThumbDrawable;
        if (r2 == null) goto L10;
        Rect r3 = DrawableUtils.getOpticalBounds(r2);
    L14:
        return ((((((this.mSwitchWidth - this.mThumbWidth) - r1.left) - r1.right) - r3.left) - r3.right) - this.mThumbConstraintRight) - this.mThumbConstraintLeft;
    L10:
        r3 = DrawableUtils.INSETS_NONE;
        goto L14
    L12:
        return 0;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        if (this.autoCheck == false) goto L6;
        setChecked(!isChecked());
        return;
    }

    private final int getThumbOffset() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L5;
        float r0 = 1 - this.mThumbPosition;
    L7:
        return (int) ((r0 * getThumbScrollRange()) + 0.5f);
    L5:
        r0 = this.mThumbPosition;
        goto L7
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r0 = getDrawableState();
        Drawable r1 = this.mThumbDrawable;
        boolean r2 = false;
        if (r1 != null) goto L5;
    L7:
        Drawable r3 = this.mTrackDrawable;
        if (r3 != null) goto L10;
    L12:
        if (r2 == false) goto L15;
        invalidate();
        return;
    L15:
        return;
    L10:
        if (r3.isStateful() == false) goto L12;
        r2 = r2 | r3.setState(r0);
        goto L12
    L5:
        if (r1.isStateful() == false) goto L7;
        r2 = false | r1.setState(r0);
        goto L7
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L5;
        int r0 = super.getCompoundPaddingLeft() + this.mSwitchWidth;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r0;
    L9:
        return r0 + this.mSwitchPadding;
    L5:
        return super.getCompoundPaddingLeft();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (ViewUtils.isLayoutRtl(this) == true) goto L5;
        int r0 = super.getCompoundPaddingRight() + this.mSwitchWidth;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r0;
    L9:
        return r0 + this.mSwitchPadding;
    L5:
        return super.getCompoundPaddingRight();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r0 = this.mThumbDrawable;
        if (r0 == null) goto L6;
        if (r0 == null) goto L6;
        r0.jumpToCurrentState();
    L6:
        Drawable r1 = this.mTrackDrawable;
        if (r1 == null) goto L10;
        if (r1 == null) goto L10;
        r1.jumpToCurrentState();
    L10:
        ObjectAnimator r2 = this.mPositionAnimator;
        if (r2 == null) goto L20;
        if (r2 != null) goto L14;
        return;
    L14:
        if (r2.isStarted() != true) goto L22;
        ObjectAnimator r3 = this.mPositionAnimator;
        if (r3 == null) goto L18;
        r3.end();
    L18:
        this.mPositionAnimator = null;
        return;
    L22:
        return;
    }

    public final boolean getAutoCheck() {
        return this.autoCheck;
    }

    public final ObjectAnimator getMPositionAnimator() {
        return this.mPositionAnimator;
    }

    public final float getMThumbPosition() {
        return this.mThumbPosition;
    }

    public final boolean getShowText() {
        return this.mShowText;
    }

    public final boolean getSplitTrack() {
        return this.mSplitTrack;
    }

    public final int getSwitchMinWidth() {
        return this.mSwitchMinWidth;
    }

    public final int getSwitchPadding() {
        return this.mSwitchPadding;
    }

    public final CharSequence getTextOff() {
        return this.mTextOff;
    }

    public final CharSequence getTextOn() {
        return this.mTextOn;
    }

    public final int getThumbConstraintLeft() {
        return this.mThumbConstraintLeft;
    }

    public final int getThumbConstraintRight() {
        return this.mThumbConstraintRight;
    }

    public final Drawable getThumbDrawable() {
        return this.mThumbDrawable;
    }

    public final int getThumbTextPadding() {
        return this.mThumbTextPadding;
    }

    public final ColorStateList getThumbTintList() {
        return this.mThumbTintList;
    }

    public final PorterDuff.Mode getThumbTintMode() {
        return this.mThumbTintMode;
    }

    public final Drawable getTrackDrawable() {
        return this.mTrackDrawable;
    }

    public final ColorStateList getTrackTintList() {
        return this.mTrackTintList;
    }

    public final PorterDuff.Mode getTrackTintMode() {
        return this.mTrackTintMode;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_CustomSwitchCompat_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    private final void animateThumbToCheckedState(boolean r5) {
        if (r5 == false) goto L5;
        float r6 = 1.0f;
    L6:
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this, THUMB_POS, new float[]{r6});
        this.mPositionAnimator = r7;
        if (r7 == null) goto L9;
        r7.setDuration(THUMB_ANIMATION_DURATION);
    L9:
        ObjectAnimator r8 = this.mPositionAnimator;
        if (r8 == null) goto L12;
        r8.setAutoCancel(true);
    L12:
        ObjectAnimator r9 = this.mPositionAnimator;
        if (r9 == null) goto L15;
        r9.setInterpolator(PathInterpolatorCompat.create(0.46f, 0.81f));
    L15:
        ObjectAnimator r10 = this.mPositionAnimator;
        if (r10 == null) goto L19;
        r10.start();
        return;
    L19:
        return;
    L5:
        r6 = 0;
        goto L6
    }

    private final void cancelSuperTouch(MotionEvent r2) {
        MotionEvent r3 = MotionEvent.obtain(r2);
        r3.setAction(3);
        super.onTouchEvent(r3);
        r3.recycle();
    }

    private final Layout makeLayout(CharSequence r9) {
        if (r9 != null) goto L5;
        return null;
    L5:
        TransformationMethod r1 = this.mSwitchTransformationMethod;
        if (r1 == null) goto L10;
        if (r1 == null) goto L9;
        r9 = r1.getTransformation(r9, this);
        goto L10
    L9:
        CharSequence r2 = null;
    L11:
        TextPaint r3 = this.mTextPaint;
        if (r2 == null) goto L14;
        int r4 = (int) Math.ceil(Layout.getDesiredWidth(r2, r3));
    L16:
        return new StaticLayout(r2, r3, r4, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    L14:
        r4 = 0;
    L10:
        r2 = r9;
        goto L11
    }

    private final void stopDrag(MotionEvent r7) {
        this.mTouchMode = 0;
        boolean r2 = true;
        if (r7.getAction() == 1) goto L5;
    L7:
        boolean r1 = false;
    L8:
        boolean r3 = isChecked();
        if (r1 == false) goto L22;
        this.mVelocityTracker.computeCurrentVelocity(ECDraweeView.SQUARE);
        float r4 = this.mVelocityTracker.getXVelocity();
        if (Math.abs(r4) > this.mMinFlingVelocity) goto L13;
        r2 = getTargetCheckedState();
    L23:
        if (r2 == r3) goto L25;
        playSoundEffect(0);
    L25:
        setChecked(r2);
        cancelSuperTouch(r7);
        return;
    L13:
        if (ViewUtils.isLayoutRtl(this) == false) goto L18;
        if (r4 < 0) goto L23;
    L20:
        r2 = false;
        goto L23
    L18:
        if (r4 <= 0) goto L20;
    L22:
        r2 = r3;
        goto L23
    L5:
        if (isEnabled() == false) goto L7;
        r1 = true;
        goto L8
    }

    @Override // android.view.View
    public void draw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "c");
        Rect r0 = this.mTempRect;
        int r1 = this.mSwitchLeft;
        int r2 = this.mSwitchTop;
        int r3 = this.mSwitchRight;
        int r4 = this.mSwitchBottom;
        int r5 = getThumbOffset() + r1;
        Drawable r6 = this.mThumbDrawable;
        if (r6 == null) goto L5;
        Rect r7 = DrawableUtils.getOpticalBounds(r6);
    L6:
        Drawable r8 = this.mTrackDrawable;
        if (r8 == null) goto L30;
        if (r8 == null) goto L10;
        r8.getPadding(r0);
    L10:
        int r9 = r0.left;
        r5 = r5 + r9;
        if (r7 == null) goto L25;
        int r10 = r7.left;
        if (r10 <= r9) goto L15;
        r1 = r1 + (r10 - r9);
    L15:
        int r12 = r7.top;
        int r13 = r0.top;
        if (r12 <= r13) goto L18;
        int r14 = (r12 - r13) + r2;
    L19:
        int r15 = r7.right;
        int r16 = r0.right;
        if (r15 <= r16) goto L22;
        r3 = r3 - (r15 - r16);
    L22:
        int r17 = r7.bottom;
        int r18 = r0.bottom;
        if (r17 <= r18) goto L26;
        int r19 = r4 - (r17 - r18);
    L27:
        Drawable r20 = this.mTrackDrawable;
        if (r20 == null) goto L30;
        r20.setBounds(r1, r14, r3, r19);
    L26:
        r19 = r4;
        goto L27
    L18:
        r14 = r2;
        goto L19
    L25:
        r14 = r2;
    L30:
        Drawable r21 = this.mThumbDrawable;
        if (r21 == null) goto L40;
        if (r21 == null) goto L34;
        r21.getPadding(r0);
    L34:
        int r22 = r5 - r0.left;
        int r23 = this.mThumbConstraintLeft;
        int r24 = r22 + r23;
        int r25 = ((r5 + this.mThumbWidth) + r0.right) + r23;
        int r26 = this.mThumbHeight;
        int r27 = ((r4 - r2) - r26) / 2;
        Drawable r28 = this.mThumbDrawable;
        if (r28 == null) goto L37;
        r28.setBounds(r24, r27, r25, r26 + r27);
    L37:
        Drawable r29 = getBackground();
        if (r29 == null) goto L40;
        DrawableCompat.setHotspotBounds(r29, r24, r2, r25, r4);
    L40:
        super.draw(r11);
        return;
    L5:
        r7 = DrawableUtils.INSETS_NONE;
        goto L6
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int r2) {
        int[] r3 = super.onCreateDrawableState(r2 + 1);
        if (isChecked() == false) goto L5;
        access$mergeDrawableStates$s2666181(r3, CHECKED_STATE_SET);
    L5:
        return r3;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.onDraw(r10);
        Rect r0 = this.mTempRect;
        Drawable r1 = this.mTrackDrawable;
        if (r1 == null) goto L5;
        r1.getPadding(r0);
    L6:
        int r2 = this.mSwitchTop;
        int r3 = this.mSwitchBottom;
        int r4 = r2 + r0.top;
        int r5 = r3 - r0.bottom;
        Drawable r6 = this.mThumbDrawable;
        if (r1 != null) goto L9;
    L13:
        int r7 = r10.save();
        if (r6 == null) goto L17;
        r6.draw(r10);
    L17:
        if (getTargetCheckedState() == false) goto L19;
        Layout r8 = this.mOnLayout;
    L20:
        if (r8 == null) goto L29;
        int[] r9 = getDrawableState();
        ColorStateList r11 = this.mTextColors;
        if (r11 == null) goto L24;
        this.mTextPaint.setColor(r11.getColorForState(r9, 0));
    L24:
        this.mTextPaint.drawableState = r9;
        if (r6 == null) goto L27;
        Rect r12 = r6.getBounds();
        int r13 = r12.left + r12.right;
    L28:
        r10.translate((r13 / 2) - (r8.getWidth() / 2), ((r4 + r5) / 2) - (r8.getHeight() / 2));
        r8.draw(r10);
        goto L29
    L27:
        r13 = getWidth();
    L29:
        r10.restoreToCount(r7);
        return;
    L19:
        r8 = this.mOffLayout;
        goto L20
    L9:
        if (this.mSplitTrack == false) goto L12;
        if (r6 == null) goto L12;
        Rect r14 = DrawableUtils.getOpticalBounds(r6);
        r6.copyBounds(r0);
        r0.left += r14.left;
        r0.right -= r14.right;
        int r15 = r10.save();
        r10.clipRect(r0, Region.Op.DIFFERENCE);
        r1.draw(r10);
        r10.restoreToCount(r15);
    L12:
        r1.draw(r10);
        goto L13
    L5:
        r0.setEmpty();
        goto L6
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        super.onInitializeAccessibilityEvent(r2);
        r2.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r4) {
        Intrinsics.checkNotNullParameter(r4, "info");
        super.onInitializeAccessibilityNodeInfo(r4);
        r4.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
        if (isChecked() == false) goto L5;
        CharSequence r0 = this.mTextOn;
    L7:
        if (TextUtils.isEmpty(r0) == true) goto L13;
        CharSequence r1 = r4.getText();
        if (TextUtils.isEmpty(r1) == false) goto L11;
        r4.setText(r0);
        return;
    L11:
        StringBuilder r2 = new StringBuilder();
        r2.append(r1);
        r2.append(' ');
        r2.append(r0);
        r4.setText(r2);
        return;
    L13:
        return;
    L5:
        r0 = this.mTextOff;
        goto L7
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        super.onPopulateAccessibilityEvent(r2);
        if (isChecked() == false) goto L5;
        CharSequence r0 = this.mTextOn;
    L6:
        if (r0 == null) goto L9;
        r2.getText().add(r0);
        return;
    L9:
        return;
    L5:
        r0 = this.mTextOff;
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "ev");
        this.mVelocityTracker.addMovement(r7);
        int r0 = r7.getActionMasked();
        if (r0 != 0) goto L5;
        float r1 = r7.getX();
        float r2 = r7.getY();
        if (isEnabled() == true) goto L42;
    L45:
        return super.onTouchEvent(r7);
    L42:
        if (hitThumb(r1, r2) == false) goto L45;
        this.mTouchMode = 1;
        this.mTouchX = r1;
        this.mTouchY = r2;
        goto L45
    L5:
        if (r0 == 1) goto L35;
        if (r0 != 2) goto L8;
        int r3 = this.mTouchMode;
        if (r3 == 1) goto L28;
        if (r3 != 2) goto L45;
        float r8 = r7.getX();
        int r4 = getThumbScrollRange();
        float r5 = r8 - this.mTouchX;
        if (r4 == 0) goto L18;
        float r6 = r5 / r4;
    L22:
        if (ViewUtils.isLayoutRtl(this) == false) goto L24;
        r6 = -r6;
    L24:
        float r9 = Companion.access$constrain(Companion, this.mThumbDragPosition + r6, 0.0f, 1.0f);
        if (r9 == this.mThumbDragPosition) goto L27;
        this.mTouchX = r8;
        this.mThumbDragPosition = r9;
    L27:
        return true;
    L18:
        if (r5 <= 0) goto L20;
        r6 = 1.0f;
        goto L22
    L20:
        r6 = -1.0f;
        goto L22
    L28:
        float r10 = r7.getX();
        float r11 = r7.getY();
        if (Math.abs(r10 - this.mTouchX) <= this.mTouchSlop) goto L31;
    L32:
        this.mTouchMode = 2;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.mTouchX = r10;
        this.mTouchY = r11;
        return true;
    L31:
        if (Math.abs(r11 - this.mTouchY) <= this.mTouchSlop) goto L45;
    L8:
        if (r0 != 3) goto L45;
    L35:
        if (this.mTouchMode != 2) goto L38;
        stopDrag(r7);
        super.onTouchEvent(r7);
        return true;
    L38:
        this.mTouchMode = 0;
        this.mVelocityTracker.clear();
        goto L45
    }

    public final void setAutoCheck(boolean r1) {
        this.autoCheck = r1;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r2) {
        super.setChecked(r2);
        boolean r3 = isChecked();
        if (getWindowToken() != null) goto L5;
    L7:
        cancelPositionAnimator();
        if (r3 == false) goto L10;
        float r4 = 1.0f;
    L11:
        setThumbPosition(r4);
        return;
    L10:
        r4 = 0;
        goto L11
    L5:
        if (ViewCompat.isLaidOut(this) == false) goto L7;
        animateThumbToCheckedState(r3);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r2) {
        Intrinsics.checkNotNullParameter(r2, "actionModeCallback");
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, r2));
    }

    public final void setMPositionAnimator(ObjectAnimator r1) {
        this.mPositionAnimator = r1;
    }

    public final void setMThumbPosition(float r1) {
        this.mThumbPosition = r1;
    }

    public final void setShowText(boolean r2) {
        if (this.mShowText == r2) goto L6;
        this.mShowText = r2;
        requestLayout();
        return;
    }

    public final void setSplitTrack(boolean r1) {
        this.mSplitTrack = r1;
        invalidate();
    }

    public final void setSwitchMinWidth(int r1) {
        this.mSwitchMinWidth = r1;
        requestLayout();
    }

    public final void setSwitchPadding(int r1) {
        this.mSwitchPadding = r1;
        requestLayout();
    }

    public final void setSwitchTypeface(Typeface r2) {
        if (this.mTextPaint.getTypeface() == null) goto L7;
        if ((!Intrinsics.areEqual(this.mTextPaint.getTypeface(), r2)) == false) goto L7;
    L9:
        this.mTextPaint.setTypeface(r2);
        requestLayout();
        invalidate();
        return;
    L7:
        if (this.mTextPaint.getTypeface() != null) goto L11;
        if (r2 != null) goto L9;
        return;
    }

    public final void setTextOff(CharSequence r1) {
        this.mTextOff = r1;
        requestLayout();
    }

    public final void setTextOn(CharSequence r1) {
        this.mTextOn = r1;
        requestLayout();
    }

    public final void setThumbConstraintLeft(int r1) {
        this.mThumbConstraintLeft = r1;
    }

    public final void setThumbConstraintRight(int r1) {
        this.mThumbConstraintRight = r1;
    }

    public final void setThumbDrawable(Drawable r3) {
        Drawable r0 = this.mThumbDrawable;
        if (r0 == null) goto L6;
        if (r0 == null) goto L6;
        r0.setCallback(null);
    L6:
        this.mThumbDrawable = r3;
        if (r3 == null) goto L9;
        r3.setCallback(this);
    L9:
        requestLayout();
    }

    public final void setThumbPosition(float r1) {
        this.mThumbPosition = r1;
        invalidate();
    }

    public final void setThumbResource(int r2) {
        setThumbDrawable(AppCompatResources.getDrawable(getContext(), r2));
    }

    public final void setThumbTextPadding(int r1) {
        this.mThumbTextPadding = r1;
        requestLayout();
    }

    public final void setThumbTintList(ColorStateList r1) {
        this.mThumbTintList = r1;
        this.mHasThumbTint = true;
        applyThumbTint();
    }

    public final void setThumbTintMode(PorterDuff.Mode r1) {
        this.mThumbTintMode = r1;
        this.mHasThumbTintMode = true;
        applyThumbTint();
    }

    public final void setTrackDrawable(Drawable r3) {
        Drawable r0 = this.mTrackDrawable;
        if (r0 == null) goto L6;
        if (r0 == null) goto L6;
        r0.setCallback(null);
    L6:
        this.mTrackDrawable = r3;
        if (r3 == null) goto L9;
        r3.setCallback(this);
    L9:
        requestLayout();
    }

    public final void setTrackResource(int r2) {
        setTrackDrawable(AppCompatResources.getDrawable(getContext(), r2));
    }

    public final void setTrackTintList(ColorStateList r1) {
        this.mTrackTintList = r1;
        this.mHasTrackTint = true;
        applyTrackTint();
    }

    public final void setTrackTintMode(PorterDuff.Mode r1) {
        this.mTrackTintMode = r1;
        this.mHasTrackTintMode = true;
        applyTrackTint();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "who");
        if (super.verifyDrawable(r2) == false) goto L5;
    L10:
        return true;
    L5:
        if (r2 == this.mThumbDrawable) goto L10;
        if (r2 == this.mTrackDrawable) goto L10;
        return false;
    }

    public static final /* synthetic */ int[] access$mergeDrawableStates$s2666181(int[] r0, int[] r1) {
        return View.mergeDrawableStates(r0, r1);
    }

    private final boolean hitThumb(float r8, float r9) {
        if (this.mThumbDrawable != null) goto L5;
        return false;
    L5:
        int r0 = getThumbOffset();
        Drawable r2 = this.mThumbDrawable;
        if (r2 == null) goto L8;
        r2.getPadding(this.mTempRect);
    L8:
        int r3 = this.mSwitchTop;
        int r4 = this.mTouchSlop;
        int r5 = r3 - r4;
        int r6 = (this.mSwitchLeft + r0) - r4;
        int r1 = this.mThumbWidth + r6;
        Rect r7 = this.mTempRect;
        int r10 = ((r1 + r7.left) + r7.right) + r4;
        int r11 = this.mSwitchBottom + r4;
        if (r8 > r6) goto L11;
        return false;
    L11:
        if (r8 < r10) goto L13;
        return false;
    L13:
        if (r9 > r5) goto L15;
        return false;
    L15:
        if (r9 >= r11) goto L21;
        return true;
    L21:
        return false;
    }

    private final void setSwitchTypefaceByIndex(int r2, int r3) {
        if (r2 != 1) goto L5;
        Typeface r4 = Typeface.SANS_SERIF;
    L12:
        setSwitchTypeface(r4, r3);
        return;
    L5:
        if (r2 != 2) goto L7;
        r4 = Typeface.SERIF;
        goto L12
    L7:
        if (r2 == 3) goto L9;
        r4 = null;
        goto L12
    L9:
        r4 = Typeface.MONOSPACE;
        goto L12
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float r2, float r3) {
        super.drawableHotspotChanged(r2, r3);
        Drawable r0 = this.mThumbDrawable;
        if (r0 == null) goto L5;
        DrawableCompat.setHotspot(r0, r2, r3);
    L5:
        Drawable r1 = this.mTrackDrawable;
        if (r1 == null) goto L9;
        DrawableCompat.setHotspot(r1, r2, r3);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r7, int r8) {
        if (this.mShowText == true) goto L5;
    L10:
        Rect r0 = this.mTempRect;
        Drawable r1 = this.mThumbDrawable;
        int r2 = 0;
        if (r1 == null) goto L21;
        if (r1 == null) goto L14;
        r1.getPadding(r0);
    L14:
        Drawable r3 = this.mThumbDrawable;
        if (r3 == null) goto L17;
        int r4 = r3.getIntrinsicWidth();
    L18:
        Drawable r5 = this.mThumbDrawable;
        if (r5 == null) goto L22;
        int r6 = r5.getIntrinsicHeight();
    L24:
        if (this.mShowText == false) goto L34;
        Layout r9 = this.mOnLayout;
        if (r9 == null) goto L28;
        int r10 = r9.getWidth();
    L29:
        Layout r11 = this.mOffLayout;
        if (r11 == null) goto L32;
        int r12 = r11.getWidth();
    L33:
        int r13 = Math.max(r10, r12) + (this.mThumbTextPadding * 2);
    L35:
        this.mThumbWidth = Math.max(r13, r4);
        this.mThumbHeight = r6;
        Drawable r14 = this.mTrackDrawable;
        if (r14 == null) goto L42;
        if (r14 == null) goto L39;
        r14.getPadding(r0);
    L39:
        Drawable r15 = this.mTrackDrawable;
        if (r15 == null) goto L43;
        r2 = r15.getIntrinsicHeight();
    L43:
        int r16 = r0.left;
        int r17 = r0.right;
        Drawable r18 = this.mThumbDrawable;
        if (r18 == null) goto L46;
        Rect r19 = DrawableUtils.getOpticalBounds(r18);
        r16 = Math.max(r16, r19.left);
        r17 = Math.max(r17, r19.right);
    L46:
        int r20 = Math.max(this.mSwitchMinWidth, ((this.mThumbWidth * 2) + r16) + r17);
        int r21 = Math.max(r2, r6);
        this.mSwitchWidth = r20;
        this.mSwitchHeight = r21;
        super.onMeasure(r7, r8);
        if (getMeasuredHeight() >= r21) goto L50;
        setMeasuredDimension(getMeasuredWidthAndState(), r21);
        return;
    L50:
        return;
    L42:
        r0.setEmpty();
        goto L43
    L32:
        r12 = 0;
        goto L33
    L28:
        r10 = 0;
        goto L29
    L34:
        r13 = 0;
    L22:
        r6 = 0;
        goto L24
    L17:
        r4 = (0 - r0.left) - r0.right;
        goto L18
    L21:
        r4 = 0;
        goto L22
    L5:
        if (this.mOnLayout != null) goto L8;
        this.mOnLayout = makeLayout(this.mTextOn);
    L8:
        if (this.mOffLayout != null) goto L10;
        this.mOffLayout = makeLayout(this.mTextOff);
        goto L10
    }

    public final void setSwitchTextAppearance(Context r4, int r5) {
        TintTypedArray r6 = TintTypedArray.obtainStyledAttributes(r4, r5, new int[]{R.attr.textSize, R.attr.typeface, R.attr.textStyle, R.attr.textColor, R.attr.textColorHint, R.attr.textColorLink, R.attr.shadowColor, R.attr.shadowDx, R.attr.shadowDy, R.attr.shadowRadius, R.attr.fontFamily, R.attr.textFontWeight, 2130970118, 2130970129, 2130974497, 2130974532});
        ColorStateList r7 = r6.getColorStateList(3);
        if (r7 != null) goto L5;
        r7 = getTextColors();
    L5:
        this.mTextColors = r7;
        int r0 = r6.getDimensionPixelSize(0, 0);
        if (r0 == 0) goto L10;
        float r1 = r0;
        if (r1 == this.mTextPaint.getTextSize()) goto L10;
        this.mTextPaint.setTextSize(r1);
        requestLayout();
    L10:
        setSwitchTypefaceByIndex(r6.getInt(1, -1), r6.getInt(2, -1));
        if (r6.getBoolean(14, false) == false) goto L13;
        AllCapsTransformationMethod r8 = new AllCapsTransformationMethod(getContext());
    L14:
        this.mSwitchTransformationMethod = r8;
        r6.recycle();
        return;
    L13:
        r8 = null;
        goto L14
    }

    public final void setSwitchTypeface(Typeface r4, int r5) {
        float r0 = 0.0f;
        boolean r1 = false;
        if (r5 <= 0) goto L18;
        if (r4 != null) goto L6;
        Typeface r6 = Typeface.defaultFromStyle(r5);
    L7:
        setSwitchTypeface(r6);
        if (r6 == null) goto L10;
        int r7 = r6.getStyle();
    L11:
        int r8 = (~r7) & r5;
        TextPaint r9 = this.mTextPaint;
        if ((r8 & 1) == 0) goto L14;
        r1 = true;
    L14:
        r9.setFakeBoldText(r1);
        TextPaint r10 = this.mTextPaint;
        if ((r8 & 2) == 0) goto L17;
        r0 = -0.25f;
    L17:
        r10.setTextSkewX(r0);
        return;
    L10:
        r7 = 0;
        goto L11
    L6:
        r6 = Typeface.create(r4, r5);
        goto L7
    L18:
        this.mTextPaint.setFakeBoldText(false);
        this.mTextPaint.setTextSkewX(0.0f);
        setSwitchTypeface(r4);
    }

    public CustomSwitchCompat(Context r6, AttributeSet r7, int r8) {
        super(r6, r7, r8);
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mTempRect = new Rect();
        this.autoCheck = true;
        TextPaint r1 = new TextPaint(1);
        this.mTextPaint = r1;
        r1.density = INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_CustomSwitchCompat_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources()).density;
        TintTypedArray r9 = TintTypedArray.obtainStyledAttributes(r6, r7, new int[]{R.attr.textOn, R.attr.textOff, R.attr.thumb, 2130974077, 2130974131, 2130974348, 2130974349, 2130974351, 2130974558, 2130974559, 2130974560, 2130974637, 2130974638, 2130974639}, r8, 0);
        Drawable r10 = r9.getDrawable(2);
        this.mThumbDrawable = r10;
        if (r10 == null) goto L6;
        if (r10 == null) goto L6;
        r10.setCallback(this);
    L6:
        Drawable r11 = r9.getDrawable(11);
        this.mTrackDrawable = r11;
        if (r11 == null) goto L10;
        if (r11 == null) goto L10;
        r11.setCallback(this);
    L10:
        this.mTextOn = r9.getText(0);
        this.mTextOff = r9.getText(1);
        this.mShowText = r9.getBoolean(3, true);
        this.mThumbTextPadding = r9.getDimensionPixelSize(8, 0);
        this.mSwitchMinWidth = r9.getDimensionPixelSize(5, 0);
        this.mSwitchPadding = r9.getDimensionPixelSize(6, 0);
        this.mSplitTrack = r9.getBoolean(4, false);
        ColorStateList r12 = r9.getColorStateList(9);
        if (r12 == null) goto L13;
        this.mThumbTintList = r12;
        this.mHasThumbTint = true;
    L13:
        PorterDuff.Mode r13 = DrawableUtils.parseTintMode(r9.getInt(10, -1), null);
        if (this.mThumbTintMode == r13) goto L17;
        this.mThumbTintMode = r13;
        this.mHasThumbTintMode = true;
    L17:
        if (this.mHasThumbTint == false) goto L19;
    L20:
        applyThumbTint();
    L21:
        ColorStateList r14 = r9.getColorStateList(12);
        if (r14 == null) goto L24;
        this.mTrackTintList = r14;
        this.mHasTrackTint = true;
    L24:
        PorterDuff.Mode r15 = DrawableUtils.parseTintMode(r9.getInt(13, -1), null);
        if (this.mTrackTintMode == r15) goto L28;
        this.mTrackTintMode = r15;
        this.mHasTrackTintMode = true;
    L28:
        if (this.mHasTrackTint == false) goto L30;
    L31:
        applyTrackTint();
    L32:
        int r16 = r9.getResourceId(7, 0);
        if (r16 == 0) goto L35;
        setSwitchTextAppearance(r6, r16);
    L35:
        r9.recycle();
        Intrinsics.checkNotNull(r6);
        ViewConfiguration r17 = ViewConfiguration.get(r6);
        this.mTouchSlop = r17.getScaledTouchSlop();
        this.mMinFlingVelocity = r17.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
        return;
    L30:
        if (this.mHasTrackTintMode == false) goto L32;
    L19:
        if (this.mHasThumbTintMode == false) goto L21;
        goto L20
    }

    public /* synthetic */ CustomSwitchCompat(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 2130974350;
    L8:
        this(r1, r2, r3);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        int r6 = 0;
        if (this.mThumbDrawable == null) goto L10;
        Rect r7 = this.mTempRect;
        Drawable r8 = this.mTrackDrawable;
        if (r8 == null) goto L8;
        if (r8 == null) goto L9;
        r8.getPadding(r7);
    L9:
        Rect r9 = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
        int r10 = Math.max(0, r9.left - r7.left);
        r6 = Math.max(0, r9.right - r7.right);
    L12:
        if (ViewUtils.isLayoutRtl(this) == false) goto L14;
        int r11 = getPaddingLeft() + r10;
        int r12 = ((this.mSwitchWidth + r11) - r10) - r6;
    L15:
        int r13 = getGravity() & 112;
        if (r13 != 16) goto L18;
        int r14 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
        int r15 = this.mSwitchHeight;
        int r16 = r14 - (r15 / 2);
    L25:
        int r17 = r15 + r16;
    L26:
        this.mSwitchLeft = r11;
        this.mSwitchTop = r16;
        this.mSwitchBottom = r17;
        this.mSwitchRight = r12;
        return;
    L18:
        if (r13 != 48) goto L20;
        r16 = getPaddingTop();
        r15 = this.mSwitchHeight;
        goto L25
    L20:
        if (r13 == 80) goto L22;
        r16 = getPaddingTop();
        r15 = this.mSwitchHeight;
        goto L25
    L22:
        r17 = getHeight() - getPaddingBottom();
        r16 = r17 - this.mSwitchHeight;
        goto L26
    L14:
        r12 = (getWidth() - getPaddingRight()) - r6;
        r11 = ((r12 - this.mSwitchWidth) + r10) + r6;
        goto L15
    L8:
        r7.setEmpty();
        goto L9
    L10:
        r10 = 0;
        goto L12
    }
}
