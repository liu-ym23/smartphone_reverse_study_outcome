package com.bytedance.ee.bear.middleground.permission.secret;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.larksuite.component.universe_design.radius.UDRadius;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 j2\u00020\u0001:\u0005jklmnB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\"\u0010.\u001a\u00020/2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u00100\u001a\u00020\nH\u0002J\b\u00101\u001a\u00020/H\u0002J\u0010\u00102\u001a\u00020/2\u0006\u00103\u001a\u00020+H\u0002J\b\u00104\u001a\u00020/H\u0002J\"\u00105\u001a\u00020/2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u00100\u001a\u00020\nH\u0002J\u0010\u00106\u001a\u00020/2\b\b\u0001\u00107\u001a\u00020\nJ\u0010\u00108\u001a\u00020/2\b\b\u0001\u00109\u001a\u00020\nJ\u000e\u00108\u001a\u00020/2\u0006\u0010:\u001a\u00020\rJ\u000e\u0010;\u001a\u00020/2\u0006\u0010:\u001a\u00020\rJ\u000e\u0010<\u001a\u00020/2\u0006\u0010:\u001a\u00020\rJ\u000e\u0010=\u001a\u00020/2\u0006\u0010>\u001a\u00020\u0019J\u000e\u0010?\u001a\u00020/2\u0006\u0010>\u001a\u00020\u0019J\u000e\u0010@\u001a\u00020/2\u0006\u0010>\u001a\u00020\u0019J\u0012\u0010A\u001a\u00020\r2\b\u0010:\u001a\u0004\u0018\u00010\u001bH\u0002J\u0006\u0010B\u001a\u00020\rJ\u0010\u0010C\u001a\u00020/2\b\b\u0001\u0010D\u001a\u00020\nJ\b\u0010E\u001a\u00020\nH\u0007J\u001e\u0010F\u001a\u00020/2\u0006\u0010G\u001a\u00020\n2\u0006\u0010H\u001a\u00020\n2\u0006\u0010I\u001a\u00020JJ\u0006\u0010K\u001a\u00020/J\u0010\u0010L\u001a\u00020/2\b\b\u0001\u0010D\u001a\u00020\nJ\b\u0010M\u001a\u00020\nH\u0007J\u000e\u0010N\u001a\u00020/2\u0006\u0010O\u001a\u00020\u0019J\u0006\u0010P\u001a\u00020\u0019J\u0010\u0010Q\u001a\u00020/2\b\b\u0001\u00109\u001a\u00020\nJ\b\u0010R\u001a\u0004\u0018\u00010\u0016J\u0010\u0010S\u001a\u00020/2\b\b\u0001\u0010D\u001a\u00020\nJ\u000e\u0010T\u001a\u00020/2\u0006\u0010U\u001a\u00020\u0019J\u0006\u0010V\u001a\u00020\u0019J\b\u0010W\u001a\u00020\nH\u0007J\u0006\u0010X\u001a\u00020\u0019J\u000e\u0010Y\u001a\u00020/2\u0006\u0010Z\u001a\u00020[J\u000e\u0010\\\u001a\u00020/2\u0006\u0010]\u001a\u00020&J\u0006\u0010^\u001a\u00020&J\u0010\u0010_\u001a\u00020/2\b\b\u0001\u0010D\u001a\u00020\nJ\u000e\u0010`\u001a\u00020/2\u0006\u0010a\u001a\u00020bJ\u000e\u0010c\u001a\u00020/2\u0006\u0010'\u001a\u00020\u0019J\u0006\u0010'\u001a\u00020\u0019J\u0018\u0010d\u001a\u00020/2\u0006\u0010e\u001a\u00020f2\u0006\u0010O\u001a\u00020\u0019H\u0002J\b\u0010g\u001a\u00020/H\u0002J\b\u0010h\u001a\u00020/H\u0002J\u0012\u0010i\u001a\u00020\r2\b\u0010:\u001a\u0004\u0018\u00010\u001bH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000¨\u0006o"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/secret/TipsNotice;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mText", "", "mTextV2", "mTextV3", "mTextColor", "mTextActions", "", "Lcom/bytedance/ee/bear/middleground/permission/secret/TipsNotice$TextAction;", "mTextActionColor", "mIcon", "Landroid/graphics/drawable/Drawable;", "mIconColor", "mIconColorful", "", "mButtonText", "", "mButtonTextColor", "mButtonIcon", "mBackgroundColor", "mShowIcon", "mShowTextButton", "mShowIconButton", "mRadius", "mBackgroundDrawable", "Lcom/larksuite/component/universe_design/drawable/UDRoundDrawable;", "mGravity", "Lcom/bytedance/ee/bear/middleground/permission/secret/TipsNotice$Gravity;", "isMarquee", "udNoticeIcon", "Landroid/widget/ImageView;", "udNoticeText", "Landroid/widget/TextView;", "udNoticeTextV2", "udNoticeTextV3", "init", "", "defStyleRes", "initView", "initTextView", "tvView", "setupViews", "applyAttrs", "applyStyle", "styleRes", "setTextV1", "resId", "text", "setTextV2", "setTextV3", "setVisibleV1", "isVisible", "setVisibleV2", "setVisibleV3", "processBoldText", "getText", "setTextColor", "color", "getTextColor", "addTextAction", "start", "end", "listener", "Landroid/view/View$OnClickListener;", "clearTextActions", "setTextActionColor", "getTextActionColor", "showIcon", "isShow", "isIconShow", "setIcon", "getIcon", "setIconColor", "setIconColorful", "isColorful", "isIconColorful", "getIconColor", "isTextButtonShow", "setType", ResourceData.KEY_TYPE, "Lcom/bytedance/ee/bear/middleground/permission/secret/TipsNotice$Type;", "setGravity", "gravity", "getGravity", "setBackground", "setRadius", "radius", "Lcom/larksuite/component/universe_design/radius/UDRadius;", "setMarquee", "showView", "view", "Landroid/view/View;", "buildSpans", "applyBackground", "processFormattedText", "Companion", "Type", "TextButtonPosition", "Gravity", "TextAction", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TipsNotice extends ConstraintLayout {
    public CharSequence a;
    public int b;
    public final List<Object> c;
    public int d;
    public Drawable e;
    public int f;
    public boolean g;
    public String h;
    public int i;
    public Drawable j;
    public int k;
    public boolean l;
    public int m;
    public final t08.a n;
    public Gravity o;
    public boolean p;
    public ImageView q;
    public TextView r;
    public TextView s;
    public TextView t;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007j\u0002\b\u0004j\u0002\b\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/secret/TipsNotice$Gravity;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "CENTER", "value", "", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Gravity extends Enum<Gravity> {
        public static final Gravity CENTER = null;
        public static final a Companion = null;
        public static final Gravity LEFT = null;
        public static final /* synthetic */ Gravity[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static final class a {
            public a() {
            }
        }

        public /* synthetic */ class b {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[Gravity.values().length];
                r0[Gravity.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[Gravity.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public static EnumEntries<Gravity> getEntries() {
            return b;
        }

        static {
            Gravity r0 = new Gravity("LEFT", 0);
            LEFT = r0;
            Gravity r1 = new Gravity("CENTER", 1);
            CENTER = r1;
            Gravity[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new a();
        }

        public static Gravity[] values() {
            return (Gravity[]) a.clone();
        }

        public final int value() {
            int r0 = b.a[ordinal()];
            if (r0 != 1) goto L5;
            return 0;
        L5:
            if (r0 != 2) goto L8;
            return 1;
        L8:
            throw new NoWhenBranchMatchedException();
        }

        public static Gravity valueOf(String r1) {
            return (Gravity) r27.a.a(Gravity.class, r1);
        }

        public Gravity(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/secret/TipsNotice$TextButtonPosition;", "", "<init>", "(Ljava/lang/String;I)V", "RIGHT", "BOTTOM", "AUTO", "value", "", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TextButtonPosition extends Enum<TextButtonPosition> {
        public static final TextButtonPosition AUTO = null;
        public static final TextButtonPosition BOTTOM = null;
        public static final a Companion = null;
        public static final TextButtonPosition RIGHT = null;
        public static final /* synthetic */ TextButtonPosition[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static final class a {
            public a() {
            }
        }

        public /* synthetic */ class b {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[TextButtonPosition.values().length];
                r0[TextButtonPosition.RIGHT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[TextButtonPosition.BOTTOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[TextButtonPosition.AUTO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public static EnumEntries<TextButtonPosition> getEntries() {
            return b;
        }

        static {
            TextButtonPosition r0 = new TextButtonPosition("RIGHT", 0);
            RIGHT = r0;
            TextButtonPosition r1 = new TextButtonPosition("BOTTOM", 1);
            BOTTOM = r1;
            TextButtonPosition r3 = new TextButtonPosition("AUTO", 2);
            AUTO = r3;
            TextButtonPosition[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new a();
        }

        public static TextButtonPosition[] values() {
            return (TextButtonPosition[]) a.clone();
        }

        public final int value() {
            int r0 = b.a[ordinal()];
            if (r0 != 1) goto L5;
            return 0;
        L5:
            if (r0 != 2) goto L7;
            return 1;
        L7:
            if (r0 != 3) goto L10;
            return 2;
        L10:
            throw new NoWhenBranchMatchedException();
        }

        public static TextButtonPosition valueOf(String r1) {
            return (TextButtonPosition) r27.a.a(TextButtonPosition.class, r1);
        }

        public TextButtonPosition(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/secret/TipsNotice$Type;", "", "styleRes", "", "<init>", "(Ljava/lang/String;II)V", "getStyleRes$middleground_permission_productionChinaRelease", "()I", "INFO", "SUCCESS", "WARNING", "ERROR", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final Type ERROR = null;
        public static final Type INFO = null;
        public static final Type SUCCESS = null;
        public static final Type WARNING = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int styleRes;

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("INFO", 0, 2131953853);
            INFO = r0;
            Type r1 = new Type("SUCCESS", 1, 2131953854);
            SUCCESS = r1;
            Type r2 = new Type("WARNING", 2, 2131953855);
            WARNING = r2;
            Type r4 = new Type("ERROR", 3, 2131953852);
            ERROR = r4;
            Type[] r6 = {r0, r1, r2, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public final int getStyleRes$middleground_permission_productionChinaRelease() {
            return this.styleRes;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.styleRes = r3;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Gravity.values().length];
            r0[Gravity.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Gravity.LEFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5() {
        t08.a r0 = this.n;
        r0.setColor(this.k);
        if (this.m >= 0) goto L5;
        this.m = 0;
    L5:
        r0.setCornerRadius(this.m);
        setBackground(r0);
    }

    public final void U5() {
        TextView r0 = this.r;
        ImageView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeText");
        r0 = null;
    L5:
        T5(r0);
        TextView r2 = this.s;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeTextV2");
        r2 = null;
    L8:
        T5(r2);
        TextView r3 = this.t;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeTextV3");
        r3 = null;
    L11:
        T5(r3);
        ImageView r4 = this.q;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeIcon");
        r4 = null;
    L14:
        Drawable r5 = this.e;
        if (r5 != null) goto L17;
    L20:
        r4.setImageDrawable(this.e);
        this.l = this.l;
        ImageView r6 = this.q;
        if (r6 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeIcon");
    L25:
        if (this.l == false) goto L27;
        int r7 = 0;
    L28:
        r1.setVisibility(r7);
        setMarquee(this.p);
        S5();
        return;
    L27:
        r7 = 8;
        goto L28
    L23:
        r1 = r6;
        goto L25
    L17:
        if (this.g == false) goto L19;
        r5.setTintList(null);
        goto L20
    L19:
        r5.mutate();
        r5.setTint(this.f);
        goto L20
    }

    public final Gravity getGravity() {
        return this.o;
    }

    public final Drawable getIcon() {
        return this.e;
    }

    public final int getIconColor() {
        return this.f;
    }

    public final CharSequence getText() {
        return this.a;
    }

    public final int getTextActionColor() {
        return this.d;
    }

    public final int getTextColor() {
        return this.b;
    }

    public TipsNotice(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void T5(TextView r4) {
        r4.setTextColor(this.b);
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if ((r0 instanceof ConstraintLayout.LayoutParams) == false) goto L5;
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) r0;
    L6:
        if (r1 == null) goto L17;
        Gravity r2 = this.o;
        int r3 = b.a[r2.ordinal()];
        if (r3 != 1) goto L10;
        r1.matchConstraintDefaultWidth = 1;
    L15:
        r4.setLayoutParams(r1);
        return;
    L10:
        if (r3 != 2) goto L13;
        ((ViewGroup.MarginLayoutParams) r1).width = 0;
        r1.matchConstraintDefaultWidth = 0;
        goto L15
    L13:
        throw new NoWhenBranchMatchedException();
    L17:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setBackground(int r1) {
        this.k = r1;
        S5();
    }

    public final void setGravity(Gravity r2) {
        Intrinsics.checkNotNullParameter(r2, "gravity");
        if (r2 == this.o) goto L6;
        this.o = r2;
        U5();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setIcon(int r5) {
        this.l = true;
        ImageView r0 = this.q;
        ImageView r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeIcon");
        r0 = null;
    L6:
        if (this.l == false) goto L8;
        int r3 = 0;
    L9:
        r0.setVisibility(r3);
        Drawable r6 = AppCompatResources.getDrawable(getContext(), kac.a.b(r5));
        if (r6 != null) goto L12;
        r6 = null;
    L15:
        this.e = r6;
        ImageView r7 = this.q;
        if (r7 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeIcon");
    L19:
        r1.setImageDrawable(this.e);
        return;
    L18:
        r1 = r7;
        goto L19
    L12:
        if (this.g == true) goto L15;
        r6.mutate();
        r6.setTint(this.f);
        goto L15
    L8:
        r3 = 8;
        goto L9
    }

    public final void setIconColor(int r2) {
        this.f = r2;
        Drawable r3 = this.e;
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.g == true) goto L9;
        r3.mutate();
        r3.setTint(this.f);
        return;
    }

    public final void setIconColorful(boolean r2) {
        this.g = r2;
        Drawable r0 = this.e;
        if (r0 == null) goto L8;
        if (r2 == false) goto L6;
        r0.setTintList(null);
        return;
    L6:
        r0.mutate();
        r0.setTint(this.f);
        return;
    }

    public final void setMarquee(boolean r4) {
        if (((ArrayList) this.c).isEmpty() == false) goto L5;
        this.p = r4;
    L6:
        TextView r2 = null;
        if (this.p == false) goto L13;
        TextView r5 = this.r;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeText");
    L12:
        r2.setSingleLine(true);
        r2.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        r2.setMarqueeRepeatLimit(-1);
        r2.setSelected(true);
        return;
    L11:
        r2 = r5;
        goto L12
    L13:
        TextView r6 = this.r;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeText");
        r6 = null;
    L16:
        r6.setSingleLine(false);
        r6.setEllipsize(null);
        r6.setSelected(false);
        return;
    L5:
        this.p = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setRadius(UDRadius r2) {
        Intrinsics.checkNotNullParameter(r2, "radius");
        this.m = r2.getRadiusSize(getContext());
        S5();
    }

    public final void setTextActionColor(int r5) {
        this.d = r5;
        SpannableStringBuilder r6 = new SpannableStringBuilder(this.a);
        TextView r0 = this.r;
        TextView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeText");
        r0 = null;
    L5:
        r0.setText(r6, TextView.BufferType.SPANNABLE);
        TextView r7 = this.r;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeText");
        r7 = null;
    L8:
        r7.setMovementMethod(LinkMovementMethod.getInstance());
        TextView r8 = this.r;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeText");
    L12:
        r1.setHighlightColor(0);
        return;
    L11:
        r1 = r8;
        goto L12
    }

    public final void setTextColor(int r2) {
        this.b = r2;
        TextView r3 = this.r;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeText");
        r3 = null;
    L5:
        r3.setTextColor(this.b);
    }

    public final void setTextV1(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "text");
        this.a = r10;
        TextView r0 = this.r;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeText");
        r0 = null;
    L5:
        String r11 = r10.toString();
        int r2 = 0;
        if (r11 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        CharSequence r4 = "";
        if (r3 == true) goto L26;
        SpannableStringBuilder r5 = new SpannableStringBuilder();
        Matcher r6 = PatternProtector.compile("\\*\\*(.*?)\\*\\*").matcher(r11);
    L17:
        if (r6.find(r2) == false) goto L23;
        r5.append(r11.substring(r2, r6.start()));
        String r7 = r6.group(1);
        if (r7 != null) goto L21;
        r7 = "";
    L21:
        int r8 = r5.length();
        r5.append(r7);
        r5.setSpan(new StyleSpan(1), r8, r5.length(), 33);
        r2 = r6.end();
        goto L17
    L23:
        if (r2 >= r11.length()) goto L25;
        r5.append(r11.substring(r2));
    L25:
        r4 = r5;
    L26:
        r0.setText(r4);
        return;
    L8:
        if (r11.length() == 0) goto L11;
        r3 = false;
        goto L12
    }

    public final void setTextV2(CharSequence r11) {
        Intrinsics.checkNotNullParameter(r11, "text");
        TextView r0 = this.s;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeTextV2");
        r0 = null;
    L5:
        String r1 = r11.toString();
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        CharSequence r12 = "";
    L34:
        r0.setText(r12);
        return;
    L14:
        SpannableStringBuilder r8 = new SpannableStringBuilder();
        Iterator r3 = StringsKt.split$default(r1, new String[]{"\n"}, false, 0, 6, null).iterator();
    L16:
        if (r3.hasNext() == false) goto L33;
        String r4 = (String) r3.next();
        if (r8.length() <= 0) goto L20;
        boolean r5 = true;
    L21:
        if (r5 == false) goto L24;
        r8.append("\n");
    L24:
        if (r4.length() <= 0) goto L26;
        boolean r6 = true;
    L28:
        if (r6 == false) goto L32;
        if (r4.charAt(0) != '-') goto L32;
        r8.append(" ");
        int r7 = r8.length();
        r8.append("•");
        r8.setSpan(new StyleSpan(1), r7, r7 + 1, 33);
        r8.append(r4.substring(1));
    L32:
        int r9 = r8.length();
        r8.append(r4);
        r8.setSpan(new StyleSpan(1), r9, r8.length(), 33);
        goto L16
    L26:
        r6 = false;
        goto L28
    L20:
        r5 = false;
        goto L21
    L33:
        r12 = r8;
        goto L34
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L12
    }

    public final void setTextV3(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        TextView r0 = this.t;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeTextV3");
        r0 = null;
    L5:
        r0.setText(r2);
    }

    public final void setType(Type r3) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TYPE);
        R5(null, 0, r3.getStyleRes$middleground_permission_productionChinaRelease());
        U5();
    }

    public final void setVisibleV1(boolean r2) {
        TextView r0 = this.r;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeText");
        r0 = null;
    L5:
        if (r2 == false) goto L7;
        int r3 = 0;
    L8:
        r0.setVisibility(r3);
        return;
    L7:
        r3 = 8;
        goto L8
    }

    public final void setVisibleV2(boolean r2) {
        TextView r0 = this.s;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeTextV2");
        r0 = null;
    L5:
        if (r2 == false) goto L7;
        int r3 = 0;
    L8:
        r0.setVisibility(r3);
        return;
    L7:
        r3 = 8;
        goto L8
    }

    public final void setVisibleV3(boolean r2) {
        TextView r0 = this.t;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeTextV3");
        r0 = null;
    L5:
        if (r2 == false) goto L7;
        int r3 = 0;
    L8:
        r0.setVisibility(r3);
        return;
    L7:
        r3 = 8;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setTextV1(int r2) {
        setTextV1(getContext().getText(r2));
    }

    public TipsNotice(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public TipsNotice(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = "";
        this.c = new ArrayList(2);
        this.n = new t08.a();
        this.o = Gravity.LEFT;
        init(r3, r4, 2131953853);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(AttributeSet r3, int r4, int r5) {
        TypedArray r6 = getContext().obtainStyledAttributes(r3, new int[]{2130974916, 2130974917, 2130974918, 2130974919, 2130974920, 2130974921, 2130974922, 2130974923, 2130974924, 2130974925, 2130974926, 2130974927, 2130974928, 2130974929, 2130974935}, r4, r5);
        CharSequence r7 = r6.getString(8);
        if (r7 != null) goto L6;
        r7 = this.a;
    L6:
        this.a = r7;
        this.b = r6.getColor(13, this.b);
        int r0 = r6.getResourceId(2, 0);
        if (r0 == 0) goto L9;
        Drawable r8 = AppCompatResources.getDrawable(getContext(), kac.a.b(r0));
    L12:
        this.e = r8;
        this.f = r6.getColor(5, this.f);
        this.g = r6.getBoolean(6, this.g);
        if (this.e == null) goto L15;
        boolean r9 = true;
    L16:
        this.l = r9;
        int r1 = r6.getResourceId(3, 0);
        if (r1 == 0) goto L19;
        Drawable r10 = AppCompatResources.getDrawable(getContext(), kac.a.b(r1));
    L22:
        this.j = r10;
        String r11 = r6.getString(10);
        if (r11 != null) goto L25;
        r11 = this.h;
    L25:
        this.h = r11;
        this.i = r6.getColor(11, this.i);
        this.d = r6.getColor(9, this.d);
        this.k = r6.getColor(0, this.k);
        int r12 = r6.getInt(14, -1);
        if (r12 < 0) goto L28;
        UDRadius.Companion.getClass();
        this.m = UDRadius.a.a(r12).getRadiusSize(getContext());
    L28:
        Gravity.a r13 = Gravity.Companion;
        int r14 = r6.getInt(1, this.o.value());
        r13.getClass();
        if (r14 == 0) goto L33;
        if (r14 == 1) goto L32;
        Gravity r15 = Gravity.LEFT;
    L34:
        this.o = r15;
        this.p = r6.getBoolean(7, this.p);
        r6.recycle();
        return;
    L32:
        r15 = Gravity.CENTER;
        goto L34
    L33:
        r15 = Gravity.LEFT;
        goto L34
    L19:
        r10 = r6.getDrawable(3);
        if (r10 != null) goto L22;
        r10 = this.j;
        goto L22
    L15:
        r9 = false;
        goto L16
    L9:
        r8 = r6.getDrawable(2);
        if (r8 != null) goto L12;
        r8 = this.e;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void init(AttributeSet r3, int r4, int r5) {
        LayoutInflater.from(getContext()).inflate(2131563372, this, true);
        this.q = (ImageView) findViewById(2131391811);
        this.r = (TextView) findViewById(2131391813);
        this.s = (TextView) findViewById(2131391816);
        this.t = (TextView) findViewById(2131391817);
        R5(r3, r4, 2131953853);
        U5();
    }
}
