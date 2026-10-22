package com.larksuite.component.universe_design.edittext;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatEditText;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.radius.UDRadius;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.d;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b&\b\u0016\u0018\u0000 \u00ad\u00012\u00020\u0001:\u0004\u00ad\u0001®\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010P\u001a\u00020Q2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010R\u001a\u00020Q2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010S\u001a\u00020QH\u0002J\b\u0010T\u001a\u00020QH\u0002J\u0010\u0010X\u001a\u00020\u001d2\u0006\u0010Y\u001a\u00020ZH\u0016J\u0010\u0010[\u001a\u00020\u001d2\u0006\u0010Y\u001a\u00020ZH\u0002J\b\u0010\\\u001a\u00020QH\u0002J\u0010\u0010]\u001a\u00020\u001d2\u0006\u0010Y\u001a\u00020ZH\u0002J\u0010\u0010^\u001a\u00020\u001d2\u0006\u0010Y\u001a\u00020ZH\u0002J\u0010\u0010_\u001a\u00020\u001d2\u0006\u0010Y\u001a\u00020ZH\u0002J\b\u0010`\u001a\u00020QH\u0002J\b\u0010a\u001a\u00020QH\u0002J\b\u0010b\u001a\u00020QH\u0002J$\u0010c\u001a\u0004\u0018\u00010d2\b\u0010e\u001a\u0004\u0018\u00010d2\u0006\u0010f\u001a\u00020\u00072\u0006\u0010g\u001a\u00020\u0007H\u0002J \u0010h\u001a\u00020d2\u0006\u0010e\u001a\u00020d2\u0006\u0010f\u001a\u00020\u00072\u0006\u0010g\u001a\u00020\u0007H\u0002J\u0010\u0010i\u001a\u00020Q2\u0006\u0010j\u001a\u00020kH\u0014J0\u0010l\u001a\u00020Q2\u0006\u0010j\u001a\u00020k2\u0006\u0010m\u001a\u00020\u00072\u0006\u0010n\u001a\u00020\u00072\u0006\u0010o\u001a\u00020\u00072\u0006\u0010p\u001a\u00020\u0007H\u0002J*\u0010q\u001a\u00020Q2\u0006\u0010j\u001a\u00020k2\u0006\u0010r\u001a\u00020\u00072\u0006\u0010s\u001a\u00020\u00072\b\u0010t\u001a\u0004\u0018\u00010\u001aH\u0002J0\u0010u\u001a\u00020Q2\u0006\u0010j\u001a\u00020k2\u0006\u0010m\u001a\u00020\u00072\u0006\u0010n\u001a\u00020\u00072\u0006\u0010o\u001a\u00020\u00072\u0006\u0010p\u001a\u00020\u0007H\u0002J\b\u0010v\u001a\u00020QH\u0002J\u0018\u0010w\u001a\u00020\u00072\u0006\u0010x\u001a\u00020B2\u0006\u0010y\u001a\u00020zH\u0002J\b\u0010{\u001a\u00020BH\u0002J\u0012\u0010|\u001a\u00020\u00072\b\u0010}\u001a\u0004\u0018\u00010~H\u0002J\b\u0010\u007f\u001a\u00020\u001dH\u0002J1\u0010\u0080\u0001\u001a\u00020Q2\u0006\u0010j\u001a\u00020k2\u0006\u0010m\u001a\u00020\u00072\u0006\u0010n\u001a\u00020\u00072\u0006\u0010o\u001a\u00020\u00072\u0006\u0010p\u001a\u00020\u0007H\u0002J\u001b\u0010\u0081\u0001\u001a\u00020\u001d2\u0007\u0010\u0082\u0001\u001a\u00020%2\u0007\u0010\u0083\u0001\u001a\u00020\u001dH\u0002J1\u0010\u0084\u0001\u001a\u00020Q2\u0006\u0010j\u001a\u00020k2\u0006\u0010m\u001a\u00020\u00072\u0006\u0010n\u001a\u00020\u00072\u0006\u0010o\u001a\u00020\u00072\u0006\u0010p\u001a\u00020\u0007H\u0002J\u001a\u0010\u0085\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00020\u001a2\u0006\u0010g\u001a\u00020\u0007H\u0002J\t\u0010\u0087\u0001\u001a\u00020\u0007H\u0002J\u0016\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u00012\b\u0010}\u001a\u0004\u0018\u00010BH\u0002J\u0007\u0010\u008a\u0001\u001a\u00020QJ\u0010\u0010\u008a\u0001\u001a\u00020Q2\u0007\u0010\u008b\u0001\u001a\u00020\u001aJ\u0012\u0010\u008c\u0001\u001a\u00020Q2\u0007\u0010\u008b\u0001\u001a\u00020\u001aH\u0002J\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u001aJ\u0007\u0010\u008e\u0001\u001a\u00020QJ\u0010\u0010\u008e\u0001\u001a\u00020Q2\u0007\u0010\u008f\u0001\u001a\u00020\u001aJ\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u001aJ\u0007\u0010\u0091\u0001\u001a\u00020\u001dJ\u0007\u0010\u0092\u0001\u001a\u00020\u001dJ\u0010\u0010\u0093\u0001\u001a\u00020\u00002\u0007\u0010\u0083\u0001\u001a\u00020\u001dJ\u0010\u0010\u0094\u0001\u001a\u00020\u00002\u0007\u0010\u0083\u0001\u001a\u00020\u001dJ\u0010\u0010\u0095\u0001\u001a\u00020Q2\u0007\u0010\u0082\u0001\u001a\u00020%J\u0007\u0010\u0096\u0001\u001a\u00020%J\u0010\u0010\u0097\u0001\u001a\u00020Q2\u0007\u0010\u0082\u0001\u001a\u00020%J\u0007\u0010\u0098\u0001\u001a\u00020%J\u0010\u0010\u0099\u0001\u001a\u00020Q2\u0007\u0010\u0082\u0001\u001a\u00020%J\u0007\u0010\u009a\u0001\u001a\u00020%J\u0012\u0010\u009b\u0001\u001a\u00020\u00002\t\b\u0001\u0010\u009c\u0001\u001a\u00020\u0007J\u0012\u0010\u009b\u0001\u001a\u00020\u00002\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u001aJ\u0012\u0010\u009d\u0001\u001a\u00020\u00002\t\b\u0001\u0010\u009c\u0001\u001a\u00020\u0007J\u0012\u0010\u009d\u0001\u001a\u00020\u00002\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010\u009e\u0001\u001a\u00020\u00002\u0007\u0010\u009f\u0001\u001a\u00020@J\u0010\u0010 \u0001\u001a\u00020\u00002\u0007\u0010¡\u0001\u001a\u00020\u0007J\u0007\u0010¢\u0001\u001a\u00020\u0007J\u0010\u0010£\u0001\u001a\u00020\u00002\u0007\u0010¤\u0001\u001a\u00020\u001dJ\u0007\u0010¥\u0001\u001a\u00020\u001dJ\u0010\u0010¦\u0001\u001a\u00020\u00002\u0007\u0010§\u0001\u001a\u00020BJ-\u0010¨\u0001\u001a\u00020Q2\u0007\u0010©\u0001\u001a\u00020\u00072\u0007\u0010ª\u0001\u001a\u00020\u00072\u0007\u0010«\u0001\u001a\u00020\u00072\u0007\u0010¬\u0001\u001a\u00020\u0007H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00100\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u00102\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u00103\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010C\u001a\u0004\u0018\u00010B2\b\u0010A\u001a\u0004\u0018\u00010B@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bD\u0010ER\u0010\u0010F\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010G\u001a\u0004\u0018\u00010B2\b\u0010A\u001a\u0004\u0018\u00010B@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bH\u0010ER\u0010\u0010I\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¯\u0001"}, d2 = {"Lcom/larksuite/component/universe_design/edittext/UDEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mBgColor", "Landroid/content/res/ColorStateList;", "mStrokeColor", "mStrokeWidth", "mStrokeRadius", "mErrorStrokeColor", "mInnerPaddingTop", "mInnerPaddingBottom", "mInnerPaddingLeft", "mInnerPaddingRight", "mExtraPaddingTop", "mExtraPaddingBottom", "mExtraPaddingLeft", "mExtraPaddingRight", "mNormalDrawable", "Landroid/graphics/drawable/Drawable;", "mErrorDrawable", "mIsErrorState", "", "errorStateFromUser", "mClearBtnEnabled", "mClearIconDrawable", "mPasswordToggleEnabled", "mShowPasswordDrawable", "mHidePasswordDrawable", "mActionBtnShownMode", "Lcom/larksuite/component/universe_design/edittext/UDEditText$ActionButtonShownMode;", "mClearBtnShownMode", "mPasswordToggleBtnShownMode", "mPasswordIsVisible", "mIconPadding", "mIconWidth", "mIconHeight", "mActionButtonWidth", "mActionButtonHeight", "mRightIconMargin", "mLeftIconMargin", "mLeftIconTint", "mRightIconTint", "mClearIconTint", "mPasswordToggleIconTint", "mLeftIconDrawable", "mRightIconDrawable", "mMinCharacterCount", "mCounterMaxLength", "mCounterEnabled", "mBottomTextMargin", "mBottomTextHeight", "mTextPaint", "Landroid/text/TextPaint;", "mIconBgPaint", "mCharactersCountIsValid", "mLengthChecker", "Lcom/larksuite/component/universe_design/edittext/ILengthChecker;", "value", "", "mRightTagText", "setMRightTagText", "(Ljava/lang/String;)V", "rightTagDrawable", "mBottomTagText", "setMBottomTagText", "bottomTagDrawable", "mTextTagHeight", "mTextTagHorizontalPadding", "mIconShowPress", "mCornerRadius", "mTransformationMethod", "Landroid/text/method/TransformationMethod;", "initView", "", "initInnerPadding", "initEditText", "initBackground", "mActionIconTouched", "mActionIconClicking", "mIconViewClicking", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "insideIconView", "togglePasswordIconVisibility", "insideActionIcon", "insideClearActionIcon", "insideShowPasswordActionIcon", "handleSwitchPasswordInputVisibility", "initTextWatcher", "initPadding", "generateIconBitmap", "Landroid/graphics/Bitmap;", PlayerResolution.SDKKEY.ORIGIN, "iconWidth", "iconHeight", "scaleIcon", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawTextTag", "startX", "endX", "startY", "endY", "drawTagDrawable", "dx", "dy", "tagDrawable", "drawCharacterCounter", "checkCharactersCount", "getTextWidth", "content", "textSizeDp", "", "getCharacterCounterText", "getCharacterLength", "text", "Landroid/text/Editable;", "showCharacterCount", "drawIcons", "isShowActionButton", "mode", "enable", "drawActionButton", "getIconTop", "drawable", "getRightTagTop", "buildTagDrawable", "Lcom/larksuite/component/universe_design/tag/UDTagsDrawable;", "showErrorBg", "errorDrawable", "showErrorBgInner", "getErrorBg", "showNormalBg", "normalDrawable", "getNormalBg", "isClearBtnEnabled", "isPasswordToggleEnabled", "setClearBtnEnabled", "setPasswordToggleEnabled", "setActionButtonShownMode", "getActionButtonShownMode", "setClearButtonShownMode", "getClearButtonShownMode", "setPasswordToggleButtonShownMode", "getPasswordToggleButtonShownMode", "setIconLeft", "res", "setIconRight", "setLengthChecker", "lengthChecker", "setCounterMaxLength", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "getCounterMaxLength", "setCounterEnabled", "counterEnabled", "isCounterEnabled", "setRightTagText", "rightTagText", "setPadding", "left", "top", "right", "bottom", "Companion", "ActionButtonShownMode", "universe-ui-edittext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class UDEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final /* synthetic */ int f284963k0 = 0;
    public final int A;
    public final int B;
    public Drawable C;
    public final Drawable D;
    public final int E;
    public final boolean F;
    public int G;
    public int H;
    public final TextPaint I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final TextPaint f284964J;
    public boolean K;
    public String L;
    public UDTagsDrawable M;
    public String N;
    public UDTagsDrawable O;
    public int P;
    public int Q;
    public final boolean R;
    public final int S;
    public TransformationMethod T;
    public boolean U;
    public boolean V;
    public boolean W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f284965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f284966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f284967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f284968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f284969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f284970f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f284971g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f284972h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Drawable f284973i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable f284974j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f284975k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f284976l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Drawable f284977m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f284978n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f284979o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Drawable f284980p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ActionButtonShownMode f284981q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ActionButtonShownMode f284982r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ActionButtonShownMode f284983s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f284984t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f284985u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f284986v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f284987w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f284988x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f284989y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f284990z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larksuite/component/universe_design/edittext/UDEditText$ActionButtonShownMode;", "", "<init>", "(Ljava/lang/String;I)V", "SHOW_WHEN_HAS_FOCUS_AND_NOT_EMPTY", "SHOW_WHEN_NOT_EMPTY", "SHOW_WHEN_HAS_FOCUS", "ALWAYS_SHOW", "universe-ui-edittext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ActionButtonShownMode extends Enum<ActionButtonShownMode> {
        public static final ActionButtonShownMode ALWAYS_SHOW = null;
        public static final ActionButtonShownMode SHOW_WHEN_HAS_FOCUS = null;
        public static final ActionButtonShownMode SHOW_WHEN_HAS_FOCUS_AND_NOT_EMPTY = null;
        public static final ActionButtonShownMode SHOW_WHEN_NOT_EMPTY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ActionButtonShownMode[] f284991a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f284992b = null;

        public static EnumEntries<ActionButtonShownMode> getEntries() {
            return f284992b;
        }

        static {
            ActionButtonShownMode r100 = new ActionButtonShownMode("SHOW_WHEN_HAS_FOCUS_AND_NOT_EMPTY", 0);
            SHOW_WHEN_HAS_FOCUS_AND_NOT_EMPTY = r100;
            ActionButtonShownMode r101 = new ActionButtonShownMode("SHOW_WHEN_NOT_EMPTY", 1);
            SHOW_WHEN_NOT_EMPTY = r101;
            ActionButtonShownMode r102 = new ActionButtonShownMode("SHOW_WHEN_HAS_FOCUS", 2);
            SHOW_WHEN_HAS_FOCUS = r102;
            ActionButtonShownMode r103 = new ActionButtonShownMode("ALWAYS_SHOW", 3);
            ALWAYS_SHOW = r103;
            ActionButtonShownMode[] r104 = {r100, r101, r102, r103};
            f284991a = r104;
            f284992b = EnumEntriesKt.enumEntries(r104);
        }

        public static ActionButtonShownMode[] values() {
            return (ActionButtonShownMode[]) f284991a.clone();
        }

        public static ActionButtonShownMode valueOf(String r100) {
            return (ActionButtonShownMode) r27.a.a(ActionButtonShownMode.class, r100);
        }

        public ActionButtonShownMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public UDEditText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14, 0);
    }

    public UDEditText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12, 0);
    }

    public UDEditText(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r110, 8, 0);
    }

    private final void h() {
        this.f284970f = 0;
        this.f284972h = 0;
        this.f284971g = 0;
        if (this.f284976l == false) goto L6;
        this.f284972h = (this.f284990z + this.f284988x) + 0;
    L6:
        if (this.f284978n == false) goto L9;
        this.f284972h += this.f284990z + this.f284988x;
    L9:
        if (this.D == null) goto L11;
        this.f284972h += this.f284990z + this.f284986v;
    L11:
        String r100 = this.L;
        if (r100 == null) goto L15;
        this.f284972h += (this.f284990z + f(r100)) + this.Q;
    L15:
        if (this.C == null) goto L18;
        this.f284971g = this.f284986v + this.A;
    L18:
        if (u() == false) goto L21;
        this.f284970f += this.H + this.G;
    L21:
        if (TextUtils.isEmpty(this.N) == true) goto L23;
        this.f284970f += this.P + this.G;
    L23:
        super.setPaddingRelative(this.f284968d + this.f284971g, this.f284966b, this.f284969e + this.f284972h, this.f284967c + this.f284970f);
    }

    public final void o() {
        this.C = null;
        h();
    }

    private final String getCharacterCounterText() {
        if (this.E <= 0) goto L9;
        StringBuilder r100 = new StringBuilder();
        Editable r101 = getText();
        if (r101 != null) goto L7;
        int r102 = 0;
    L8:
        r100.append(r102);
        r100.append(" / ");
        r100.append(this.E);
        return r100.toString();
    L7:
        r102 = r101.length();
        goto L8
    L9:
        return "";
    }

    private final int getRightTagTop() {
        if (TextUtils.isEmpty(this.N) == false) goto L9;
        if (u() == true) goto L9;
        return (((getHeight() - this.f284966b) - this.f284967c) - this.P) / 2;
    L9:
        return (((((getHeight() - this.f284966b) - this.f284967c) - this.P) - this.H) - this.G) / 2;
    }

    public final boolean u() {
        if (this.E > 0) goto L5;
    L7:
        return false;
    L5:
        if (this.F == false) goto L7;
        return true;
    }

    public final void v() {
        Drawable r100 = this.f284974j;
        if (r100 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "errorDrawable");
        this.f284975k = true;
        this.f284974j = r100;
        setBackground(r100);
        return;
    }

    public final void w() {
        Drawable r100 = this.f284973i;
        if (r100 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "normalDrawable");
        this.f284973i = r100;
        setBackground(r100);
        this.f284975k = false;
        return;
    }

    public final void d() {
        if (u() == false) goto L13;
        Editable r100 = getText();
        boolean r101 = false;
        if (r100 != null) goto L8;
        int r102 = 0;
    L9:
        if (r102 < 0) goto L14;
        int r103 = this.E;
        if (r103 <= 0) goto L13;
        if (r102 <= r103) goto L13;
    L14:
        this.K = r101;
        return;
    L8:
        r102 = r100.length();
    L13:
        r101 = true;
        goto L14
    }

    public final void g() {
        int r100 = getSelectionStart();
        int r101 = getSelectionEnd();
        if (this.f284984t == false) goto L5;
        TransformationMethod r102 = this.T;
    L6:
        setTransformationMethod(r102);
        setSelection(r100, r101);
        return;
    L5:
        this.T = getTransformationMethod();
        r102 = PasswordTransformationMethod.getInstance();
        goto L6
    }

    public final void n() {
        this.C = UDIconUtils.getIconDrawable(getContext(), R.drawable.ud_icon_loading_outlined, this.B);
        h();
    }

    public final ActionButtonShownMode getActionButtonShownMode() {
        return this.f284981q;
    }

    public final ActionButtonShownMode getClearButtonShownMode() {
        return this.f284982r;
    }

    public final int getCounterMaxLength() {
        return this.E;
    }

    public final Drawable getErrorBg() {
        return this.f284974j;
    }

    public final Drawable getNormalBg() {
        return this.f284973i;
    }

    public final ActionButtonShownMode getPasswordToggleButtonShownMode() {
        return this.f284983s;
    }

    private final void setMBottomTagText(String r100) {
        if (Intrinsics.areEqual(this.N, r100) == true) goto L6;
        this.N = r100;
        this.O = c(r100);
        return;
    }

    private final void setMRightTagText(String r100) {
        if (Intrinsics.areEqual(this.L, r100) == true) goto L6;
        this.L = r100;
        this.M = c(r100);
        return;
    }

    public final UDTagsDrawable c(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        UDTagsDrawable.a r101 = new UDTagsDrawable.a(getContext());
        r101.f285330d = this.P;
        UDTagsDrawable.d.a r102 = new UDTagsDrawable.d.a(getContext());
        r102.f285353c = r100;
        r102.c(UDTagsDrawable.TagColorSet.GRAY);
        r101.a(r102.b());
        return r101.b();
    }

    public final int e(int r100) {
        if (TextUtils.isEmpty(this.N) == false) goto L9;
        if (u() == true) goto L9;
        return (((getHeight() - this.f284966b) - this.f284967c) - r100) / 2;
    L9:
        return (((((getHeight() - this.f284966b) - this.f284967c) - r100) - this.H) - this.G) / 2;
    }

    public final int f(String r100) {
        this.I.setTextSize(d.a(getContext(), 12.0f));
        return (int) this.I.measureText(r100);
    }

    public final boolean i(MotionEvent r100) {
        if (k(r100) == false) goto L5;
        return true;
    L5:
        if (this.f284978n == false) goto L22;
        float r101 = r100.getX();
        float r102 = r100.getY();
        int r103 = getWidth();
        int r104 = getHeight();
        int r105 = r103 - this.f284969e;
        int r106 = this.f284990z;
        int r107 = (r105 - r106) - this.f284988x;
        if (this.D == null) goto L10;
        int r108 = r106 + this.f284986v;
        r107 = r107 - r108;
        r103 = r103 - r108;
    L10:
        String r109 = this.L;
        if (r109 == null) goto L13;
        int r110 = (f(r109) + this.Q) + this.f284990z;
        r107 = r107 - r110;
        r103 = r103 - r110;
    L13:
        int r111 = getScrollY();
        if (r101 < r107) goto L22;
        if (r101 >= r103) goto L22;
        if (r102 < r111) goto L22;
        if (r102 >= r104) goto L22;
        boolean r112 = true;
    L23:
        if (r112 == true) goto L28;
        return false;
    L28:
        return true;
    L22:
        r112 = false;
        goto L23
    }

    public final boolean k(MotionEvent r100) {
        if (this.f284976l == true) goto L5;
        return false;
    L5:
        float r101 = r100.getX();
        float r102 = r100.getY();
        int r103 = getWidth();
        int r104 = getHeight();
        int r105 = r103 - this.f284969e;
        int r106 = this.f284990z;
        int r107 = this.f284988x;
        int r108 = (r105 - r106) - r107;
        if (this.f284978n == false) goto L9;
        r108 = r108 - (r106 + r107);
        r103 = r103 - ((r106 / 2) + r107);
    L9:
        if (this.D == null) goto L11;
        int r109 = r106 + this.f284986v;
        r108 = r108 - r109;
        r103 = r103 - r109;
    L11:
        String r110 = this.L;
        if (r110 == null) goto L14;
        int r111 = (f(r110) + this.Q) + this.f284990z;
        r108 = r108 - r111;
        r103 = r103 - r111;
    L14:
        int r112 = getScrollY();
        if (r101 >= r108) goto L17;
        return false;
    L17:
        if (r101 < r103) goto L19;
        return false;
    L19:
        if (r102 >= r112) goto L21;
        return false;
    L21:
        if (r102 >= r104) goto L27;
        return true;
    L27:
        return false;
    }

    public final void m(boolean r100) {
        this.f284976l = r100;
        h();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        int r100 = getScrollX();
        int r101 = getScrollX() + getWidth();
        int r102 = getScrollY();
        int r111 = getScrollY() + getHeight();
        Drawable r103 = this.C;
        if (r103 == null) goto L6;
        int r104 = this.f284968d + r100;
        int r105 = (this.f284966b + r102) + e(this.f284987w);
        r103.setBounds(r104, r105, this.f284986v + r104, this.f284987w + r105);
        r103.draw(r110);
    L6:
        if (this.W == false) goto L8;
        int r106 = r101 - this.f284969e;
        int r107 = r106 - this.f284986v;
        int r108 = this.f284985u * 2;
        int r109 = this.f284966b + r102;
        int r112 = (this.f284987w + r109) + r108;
        this.f284964J.setColor(getContext().getResources().getColor(R.color.udtoken_btn_text_bg_neutral_hover));
        float r113 = this.S;
        r110.drawRoundRect(r107 - r108, r109, r106, r112, r113, r113, this.f284964J);
    L8:
        Drawable r114 = this.D;
        if (r114 == null) goto L12;
        int r115 = ((r101 - this.f284969e) - this.f284986v) - this.f284985u;
        int r116 = (this.f284966b + r102) + e(this.f284987w);
        r114.setBounds(r115, r116, this.f284986v + r115, this.f284987w + r116);
        r114.draw(r110);
    L12:
        if (this.L == null) goto L22;
        UDTagsDrawable r117 = this.M;
        if (r117 == null) goto L22;
        int r118 = r117.getIntrinsicWidth();
        r117.getIntrinsicHeight();
        if (this.D == null) goto L19;
        int r119 = ((r101 - this.f284969e) - r118) - this.f284986v;
        r118 = this.f284990z;
    L20:
        int r120 = r119 - r118;
        int r121 = (this.f284966b + r102) + getRightTagTop();
        r110.save();
        r110.translate(r120, r121);
        r117.draw(r110);
        r110.restore();
        goto L22
    L19:
        r119 = r101 - this.f284969e;
    L22:
        if (this.N == null) goto L31;
        UDTagsDrawable r122 = this.O;
        if (r122 == null) goto L31;
        int r123 = r122.getIntrinsicWidth();
        r122.getIntrinsicHeight();
        if (u() == false) goto L29;
        int r124 = (r101 - this.f284969e) - f(getCharacterCounterText());
        int r125 = this.f284990z;
    L30:
        int r126 = (r124 - r125) - r123;
        int r127 = (r111 - this.f284967c) - this.P;
        r110.save();
        r110.translate(r126, r127);
        r122.draw(r110);
        r110.restore();
        goto L31
    L29:
        r125 = this.f284969e;
        r124 = r101;
    L31:
        boolean r128 = l(this.f284982r, this.f284976l);
        boolean r129 = l(this.f284983s, this.f284978n);
        if (isEnabled() == false) goto L36;
        if (r128 == true) goto L35;
        if (r129 == false) goto L36;
    L35:
        boolean r130 = true;
    L37:
        if (r130 == false) goto L65;
        if (r128 == false) goto L51;
        int r131 = (r101 - this.f284969e) - this.f284988x;
        Drawable r132 = this.f284977m;
        if (r132 == null) goto L51;
        if (this.D == null) goto L44;
        r131 = r131 - (this.f284986v + this.f284990z);
    L44:
        String r133 = this.L;
        if (r133 == null) goto L48;
        r131 = r131 - ((f(r133) + this.Q) + this.f284990z);
    L48:
        if (this.f284978n == false) goto L50;
        r131 = r131 - (this.f284988x + this.f284990z);
    L50:
        int r134 = (this.f284966b + r102) + e(this.f284989y);
        r132.setBounds(r131, r134, this.f284988x + r131, this.f284989y + r134);
        r132.draw(r110);
    L51:
        if (r129 == false) goto L65;
        int r135 = (r101 - this.f284969e) - this.f284988x;
        if (this.f284984t == false) goto L55;
        Drawable r136 = this.f284979o;
    L56:
        if (r136 == null) goto L65;
        if (this.D == null) goto L60;
        r135 = r135 - (this.f284986v + this.f284990z);
    L60:
        String r137 = this.L;
        if (r137 == null) goto L63;
        r135 = r135 - ((f(r137) + this.Q) + this.f284990z);
    L63:
        int r138 = (r102 + this.f284966b) + e(this.f284989y);
        r136.setBounds(r135, r138, this.f284988x + r135, this.f284989y + r138);
        r136.draw(r110);
        goto L65
    L55:
        r136 = this.f284980p;
    L65:
        if (u() == false) goto L67;
    L68:
        String r139 = getCharacterCounterText();
        int r140 = f(r139);
        Paint.FontMetrics r141 = this.I.getFontMetrics();
        float r142 = (r141.ascent + r141.descent) / 2;
        float r143 = (r101 - this.f284969e) - (r140 / 2.0f);
        float r144 = ((r111 - this.f284967c) - (this.H / 2.0f)) - r142;
        if (this.K == false) goto L73;
        this.I.setColor(getResources().getColor(R.color.text_placeholder));
        if (this.f284975k == true) goto L78;
        w();
    L78:
        this.I.setTextAlign(Paint.Align.CENTER);
        r110.drawText(r139, r143, r144, this.I);
        this.I.setTextAlign(Paint.Align.LEFT);
    L79:
        super.onDraw(r110);
        return;
    L73:
        this.I.setColor(getResources().getColor(R.color.function_danger_fill_default));
        if (this.f284975k == true) goto L78;
        Drawable r145 = this.f284974j;
        if (r145 == null) goto L78;
        this.f284974j = r145;
        setBackground(r145);
        goto L78
    L67:
        if (this.K == true) goto L79;
    L36:
        r130 = false;
        goto L37
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (hasFocus() == false) goto L73;
        if (this.f284976l == true) goto L11;
        if (this.f284978n == true) goto L11;
        if (this.R == false) goto L73;
    L11:
        if (isEnabled() == false) goto L73;
        int r101 = r100.getAction();
        boolean r102 = false;
        if (r101 == 0) goto L46;
        if (r101 == 1) goto L30;
        if (r101 == 2) goto L22;
        if (r101 != 3) goto L73;
        this.U = false;
        this.V = false;
        this.W = false;
        goto L73
    L22:
        if (this.V == false) goto L27;
        if (i(r100) == true) goto L27;
        this.V = false;
    L27:
        if (this.U == false) goto L73;
        return true;
    L30:
        if (this.V == false) goto L39;
        if (k(r100) == true) goto L34;
        this.f284984t = !this.f284984t;
        g();
    L37:
        this.V = false;
        goto L39
    L34:
        if (TextUtils.isEmpty(getText()) == true) goto L37;
        setText(null);
    L39:
        if (this.U == false) goto L42;
        this.U = false;
        return true;
    L42:
        this.U = false;
        if (this.W == false) goto L73;
        this.W = false;
        invalidate();
        goto L73
    L46:
        if (i(r100) == false) goto L50;
        this.U = true;
        this.V = true;
        return true;
    L50:
        if (this.V == false) goto L55;
        if (i(r100) == true) goto L55;
        this.V = false;
    L55:
        if (this.U == false) goto L58;
        return true;
    L58:
        if (this.D == null) goto L69;
        float r103 = r100.getX();
        float r104 = r100.getY();
        int r105 = getWidth();
        int r106 = getHeight();
        int r107 = ((r105 - this.f284969e) - this.f284986v) - this.f284985u;
        int r108 = getScrollY();
        if (r103 < r107) goto L69;
        if (r103 >= r105) goto L69;
        if (r104 < r108) goto L69;
        if (r104 >= r106) goto L69;
        r102 = true;
    L69:
        if (r102 == false) goto L73;
        this.W = true;
        invalidate();
        return true;
    L73:
        return super.onTouchEvent(r100);
    }

    public final void setActionButtonShownMode(ActionButtonShownMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        this.f284981q = r100;
        invalidate();
    }

    public final void setClearButtonShownMode(ActionButtonShownMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        this.f284982r = r100;
        invalidate();
    }

    public final void setPasswordToggleButtonShownMode(ActionButtonShownMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        this.f284983s = r100;
        invalidate();
    }

    public final boolean l(ActionButtonShownMode r100, boolean r101) {
        if (r101 == true) goto L4;
    L16:
        return false;
    L4:
        if (hasFocus() == true) goto L10;
        if (r100 == ActionButtonShownMode.SHOW_WHEN_HAS_FOCUS_AND_NOT_EMPTY) goto L16;
        if (r100 == ActionButtonShownMode.SHOW_WHEN_HAS_FOCUS) goto L16;
    L10:
        if (TextUtils.isEmpty(getText()) == true) goto L12;
    L15:
        return true;
    L12:
        if (r100 == ActionButtonShownMode.SHOW_WHEN_HAS_FOCUS_AND_NOT_EMPTY) goto L16;
        if (r100 == ActionButtonShownMode.SHOW_WHEN_NOT_EMPTY) goto L16;
        goto L15
    }

    public UDEditText(Context r210, AttributeSet r211, int r212, int r213) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r210, r211, r212);
        ActionButtonShownMode r100 = ActionButtonShownMode.SHOW_WHEN_HAS_FOCUS_AND_NOT_EMPTY;
        this.f284981q = r100;
        this.f284982r = r100;
        this.f284983s = r100;
        this.I = new TextPaint(1);
        this.f284964J = new TextPaint(1);
        this.R = true;
        TypedArray r101 = r210.obtainStyledAttributes(r211, new int[]{R.attr.ud_backgroundColor, R.attr.ud_editText_actionButtonShownMode, R.attr.ud_editText_bottomTagText, R.attr.ud_editText_clearBtnEnabled, R.attr.ud_editText_clearButtonShownMode, R.attr.ud_editText_clearIconTint, R.attr.ud_editText_counterEnabled, R.attr.ud_editText_counterMaxLength, R.attr.ud_editText_errorStrokeColor, R.attr.ud_editText_iconHeight, R.attr.ud_editText_iconInputMargin, R.attr.ud_editText_iconShowPressStatus, R.attr.ud_editText_iconWidth, R.attr.ud_editText_leftIcon, R.attr.ud_editText_leftIconTint, R.attr.ud_editText_passwordToggleButtonShownMode, R.attr.ud_editText_passwordToggleEnabled, R.attr.ud_editText_passwordToggleIconTint, R.attr.ud_editText_rightIcon, R.attr.ud_editText_rightIconTint, R.attr.ud_editText_rightTagText, R.attr.ud_radius, R.attr.ud_strokeColor, R.attr.ud_strokeWidth}, r212, r213);
        ColorStateList r110 = r101.getColorStateList(0);
        ColorStateList r102 = r101.getColorStateList(22);
        int r111 = r101.getDimensionPixelSize(23, 0);
        int r103 = r101.getInt(21, 0);
        this.f284965a = r103;
        if (r103 <= 0) goto L5;
        UDRadius.Companion.getClass();
        this.f284965a = UDRadius.a.a(r103).getRadiusSize(r210);
    L5:
        int r112 = r101.getColor(8, UDColorUtils.getColor(r210, R.color.function_danger_fill_default));
        this.f284976l = r101.getBoolean(3, false);
        boolean r113 = r101.getBoolean(16, false);
        this.f284978n = r113;
        int r104 = r101.getInt(1, this.f284981q.ordinal());
        ActionButtonShownMode r105 = ActionButtonShownMode.values()[r104];
        this.f284981q = r105;
        int r106 = r101.getInt(4, r105.ordinal());
        this.f284982r = ActionButtonShownMode.values()[r106];
        int r107 = r101.getInt(15, this.f284981q.ordinal());
        this.f284983s = ActionButtonShownMode.values()[r107];
        this.A = r101.getDimensionPixelSize(10, (int) d.a(r210, 8.0f));
        this.f284990z = r101.getDimensionPixelSize(10, (int) d.a(r210, 12.0f));
        this.f284986v = r101.getDimensionPixelSize(12, (int) d.a(r210, 20.0f));
        this.f284987w = r101.getDimensionPixelSize(9, (int) d.a(r210, 20.0f));
        this.R = r101.getBoolean(11, true);
        this.f284985u = (int) d.a(r210, 2.0f);
        this.S = (int) d.a(r210, 4.0f);
        int r108 = r101.getColor(14, UDColorUtils.getColor(r210, R.color.icon_n3));
        this.B = r108;
        int r109 = r101.getColor(19, UDColorUtils.getColor(r210, R.color.icon_n2));
        int r114 = r101.getColor(5, r109);
        int r115 = r101.getColor(17, r109);
        int r116 = r101.getResourceId(13, -1);
        if (r116 == (-1)) goto L8;
        this.C = UDIconUtils.getIconDrawable(r210, r116, r108);
    L8:
        int r117 = r101.getResourceId(18, -1);
        if (r117 == (-1)) goto L11;
        this.D = UDIconUtils.getIconDrawable(r210, r117, r109);
    L11:
        setMRightTagText(r101.getString(20));
        setMBottomTagText(r101.getString(2));
        this.E = r101.getInt(7, 0);
        this.F = r101.getBoolean(6, false);
        r101.recycle();
        int r118 = t08.a.f544126e;
        t08.a r119 = t08.a.C7675a.a(r110, r111, r102, 0, 0, 0, 0, false, this.f284965a);
        this.f284973i = r119;
        setBackground(r119);
        this.f284974j = t08.a.C7675a.a(r110, r111, ColorStateList.valueOf(r112), 0, 0, 0, 0, false, this.f284965a);
        this.f284988x = (int) d.a(getContext(), 20.0f);
        this.f284989y = (int) d.a(getContext(), 20.0f);
        this.f284977m = UDIconUtils.getIconDrawable(getContext(), R.drawable.ud_icon_close_filled, r114);
        if (r113 == false) goto L14;
        g();
    L14:
        this.f284979o = UDIconUtils.getIconDrawable(getContext(), R.drawable.ic_ud_edittext_show_password, r115);
        this.f284980p = UDIconUtils.getIconDrawable(getContext(), R.drawable.ic_ud_edittext_hide_password, r115);
        this.G = (int) d.a(getContext(), 2.0f);
        this.H = (int) d.a(getContext(), 18.0f);
        this.P = (int) d.a(getContext(), 18.0f);
        this.Q = ((int) d.a(getContext(), 4.0f)) * 2;
        TypedArray r120 = r210.obtainStyledAttributes(r211, new int[]{android.R.attr.padding, android.R.attr.paddingLeft, android.R.attr.paddingTop, android.R.attr.paddingRight, android.R.attr.paddingBottom});
        int r121 = r120.getDimensionPixelSize(0, 0);
        this.f284968d = r120.getDimensionPixelSize(1, r121);
        this.f284966b = r120.getDimensionPixelSize(2, r121);
        this.f284969e = r120.getDimensionPixelSize(3, r121);
        this.f284967c = r120.getDimensionPixelSize(4, r121);
        r120.recycle();
        h();
        addTextChangedListener(new u08.a(this));
        d();
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int r100, int r101, int r102, int r103) {
        this.f284968d = r100;
        this.f284969e = r102;
        this.f284966b = r101;
        this.f284967c = r103;
        h();
        postInvalidate();
    }

    public /* synthetic */ UDEditText(Context r100, AttributeSet r101, int r102, int r103, int r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102, 0);
    }
}
