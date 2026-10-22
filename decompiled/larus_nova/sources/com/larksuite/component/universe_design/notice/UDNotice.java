package com.larksuite.component.universe_design.notice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.notice.databinding.UdLayoutNoticeBinding;
import com.larksuite.component.universe_design.radius.UDRadius;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001:\u0004qrstB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\"\u0010/\u001a\u0002002\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u00101\u001a\u00020\nH\u0002J\b\u00102\u001a\u000200H\u0002J\"\u00103\u001a\u0002002\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u00101\u001a\u00020\nH\u0002J\u0010\u00104\u001a\u0002002\b\b\u0001\u00105\u001a\u00020\nJ\u0010\u00106\u001a\u0002002\b\b\u0001\u00107\u001a\u00020\nJ\u000e\u00106\u001a\u0002002\u0006\u00108\u001a\u00020\u000fJ\u0006\u00109\u001a\u00020\u000fJ\u0010\u0010:\u001a\u0002002\b\b\u0001\u0010;\u001a\u00020\nJ\b\u0010<\u001a\u00020\nH\u0007J\u001e\u0010=\u001a\u0002002\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020\u001eJ\u0006\u0010A\u001a\u000200J\u0010\u0010B\u001a\u0002002\b\b\u0001\u0010;\u001a\u00020\nJ\b\u0010C\u001a\u00020\nH\u0007J\u000e\u0010D\u001a\u0002002\u0006\u0010E\u001a\u00020\u0019J\u0006\u0010F\u001a\u00020\u0019J\u0010\u0010G\u001a\u0002002\b\b\u0001\u00107\u001a\u00020\nJ\b\u0010H\u001a\u0004\u0018\u00010\u0016J\u0010\u0010I\u001a\u0002002\b\b\u0001\u0010;\u001a\u00020\nJ\u000e\u0010J\u001a\u0002002\u0006\u0010K\u001a\u00020\u0019J\u0006\u0010L\u001a\u00020\u0019J\b\u0010M\u001a\u00020\nH\u0007J\u000e\u0010N\u001a\u0002002\u0006\u0010E\u001a\u00020\u0019J\u0006\u0010O\u001a\u00020\u0019J\u0010\u0010P\u001a\u0002002\b\b\u0001\u00107\u001a\u00020\nJ\b\u0010Q\u001a\u0004\u0018\u00010\u0016J\u0010\u0010R\u001a\u0002002\b\b\u0001\u0010;\u001a\u00020\nJ\b\u0010S\u001a\u00020\nH\u0007J\u000e\u0010T\u001a\u0002002\u0006\u0010U\u001a\u00020\u001eJ\u000e\u0010V\u001a\u0002002\u0006\u0010E\u001a\u00020\u0019J\u0006\u0010W\u001a\u00020\u0019J\u000e\u0010X\u001a\u0002002\u0006\u00108\u001a\u00020\u001bJ\b\u0010Y\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010Z\u001a\u0002002\b\b\u0001\u0010;\u001a\u00020\nJ\b\u0010[\u001a\u00020\nH\u0007J\u000e\u0010\\\u001a\u0002002\u0006\u0010U\u001a\u00020\u001eJ\u000e\u0010]\u001a\u0002002\u0006\u0010^\u001a\u00020 J\u0006\u0010_\u001a\u00020 J\u000e\u0010`\u001a\u0002002\u0006\u0010a\u001a\u00020bJ\u000e\u0010c\u001a\u0002002\u0006\u0010d\u001a\u00020,J\u0006\u0010e\u001a\u00020,J\u0010\u0010f\u001a\u0002002\b\b\u0001\u0010;\u001a\u00020\nJ\u000e\u0010g\u001a\u0002002\u0006\u0010h\u001a\u00020iJ\u000e\u0010j\u001a\u0002002\u0006\u0010.\u001a\u00020\u0019J\u0006\u0010.\u001a\u00020\u0019J\u0018\u0010k\u001a\u0002002\u0006\u0010l\u001a\u00020m2\u0006\u0010E\u001a\u00020\u0019H\u0002J\b\u0010n\u001a\u000200H\u0002J\b\u0010o\u001a\u000200H\u0002J\b\u0010p\u001a\u000200H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Lcom/larksuite/component/universe_design/notice/UDNotice;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewBinding", "Lcom/larksuite/component/universe_design/notice/databinding/UdLayoutNoticeBinding;", "mText", "", "mTextColor", "mTextActions", "", "Lcom/larksuite/component/universe_design/notice/UDNotice$TextAction;", "mTextActionColor", "mIcon", "Landroid/graphics/drawable/Drawable;", "mIconColor", "mIconColorful", "", "mButtonText", "", "mButtonTextColor", "mTextButtonListener", "Landroid/view/View$OnClickListener;", "mTextButtonPosition", "Lcom/larksuite/component/universe_design/notice/UDNotice$TextButtonPosition;", "mButtonIcon", "mButtonIconColor", "mIconButtonListener", "mBackgroundColor", "mShowIcon", "mShowTextButton", "mShowIconButton", "mRadius", "mBackgroundDrawable", "Lcom/larksuite/component/universe_design/drawable/UDRoundDrawable;", "mGravity", "Lcom/larksuite/component/universe_design/notice/UDNotice$Gravity;", "isGlobalLayoutListenerAdded", "isMarquee", "init", "", "defStyleRes", "setupViews", "applyAttrs", "applyStyle", "styleRes", "setText", "resId", "text", "getText", "setTextColor", "color", "getTextColor", "addTextAction", "start", "end", "listener", "clearTextActions", "setTextActionColor", "getTextActionColor", "showIcon", "isShow", "isIconShow", "setIcon", "getIcon", "setIconColor", "setIconColorful", "isColorful", "isIconColorful", "getIconColor", "showIconButton", "isIconButtonShow", "setIconButton", "getButtonIcon", "setIconButtonColor", "getButtonIconColor", "setIconButtonListener", "onClickListener", "showTextButton", "isTextButtonShow", "setTextButton", "getButtonText", "setTextButtonColor", "getButtonTextColor", "setTextButtonListener", "setTextButtonPosition", "position", "getTextButtonPosition", "setType", "type", "Lcom/larksuite/component/universe_design/notice/UDNotice$Type;", "setGravity", GXTemplateKey.GAIAX_LAYER_GRAVITY, "getGravity", "setBackground", "setRadius", "radius", "Lcom/larksuite/component/universe_design/radius/UDRadius;", "setMarquee", "showView", "view", "Landroid/view/View;", "buildSpans", "applyBackground", "addGlobalLayoutListenerIfNeed", "Type", "TextButtonPosition", "Gravity", "TextAction", "universe-ui-notice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class UDNotice extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UdLayoutNoticeBinding f285145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f285146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f285147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<a> f285148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f285149e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f285150f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f285151g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f285152h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f285153i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f285154j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View.OnClickListener f285155k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextButtonPosition f285156l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Drawable f285157m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f285158n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View.OnClickListener f285159o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f285160p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f285161q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f285162r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f285163s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f285164t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final t08.a f285165u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Gravity f285166v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f285167w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f285168x;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007j\u0002\b\u0004j\u0002\b\u0005¨\u0006\t"}, d2 = {"Lcom/larksuite/component/universe_design/notice/UDNotice$Gravity;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "CENTER", "value", "", "Companion", "universe-ui-notice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Gravity extends Enum<Gravity> {
        public static final Gravity CENTER = null;
        public static final a Companion = null;
        public static final Gravity LEFT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Gravity[] f285169a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f285170b = null;

        public static final class a {
            public a() {
            }
        }

        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f285171a = null;

            static {
                int[] r100 = new int[Gravity.values().length];
                r100[Gravity.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[Gravity.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f285171a = r100;
            }
        }

        public static EnumEntries<Gravity> getEntries() {
            return f285170b;
        }

        static {
            Gravity r100 = new Gravity("LEFT", 0);
            LEFT = r100;
            Gravity r101 = new Gravity("CENTER", 1);
            CENTER = r101;
            Gravity[] r102 = {r100, r101};
            f285169a = r102;
            f285170b = EnumEntriesKt.enumEntries(r102);
            Companion = new a();
        }

        public static Gravity[] values() {
            return (Gravity[]) f285169a.clone();
        }

        public final int value() {
            int r100 = b.f285171a[ordinal()];
            if (r100 != 1) goto L5;
            return 0;
        L5:
            if (r100 != 2) goto L8;
            return 1;
        L8:
            throw new NoWhenBranchMatchedException();
        }

        public static Gravity valueOf(String r100) {
            return (Gravity) r27.a.a(Gravity.class, r100);
        }

        public Gravity(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\n"}, d2 = {"Lcom/larksuite/component/universe_design/notice/UDNotice$TextButtonPosition;", "", "<init>", "(Ljava/lang/String;I)V", "RIGHT", "BOTTOM", "AUTO", "value", "", "Companion", "universe-ui-notice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TextButtonPosition extends Enum<TextButtonPosition> {
        public static final TextButtonPosition AUTO = null;
        public static final TextButtonPosition BOTTOM = null;
        public static final a Companion = null;
        public static final TextButtonPosition RIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TextButtonPosition[] f285172a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f285173b = null;

        public static final class a {
            public a() {
            }
        }

        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f285174a = null;

            static {
                int[] r100 = new int[TextButtonPosition.values().length];
                r100[TextButtonPosition.RIGHT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[TextButtonPosition.BOTTOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[TextButtonPosition.AUTO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f285174a = r100;
            }
        }

        public static EnumEntries<TextButtonPosition> getEntries() {
            return f285173b;
        }

        static {
            TextButtonPosition r100 = new TextButtonPosition("RIGHT", 0);
            RIGHT = r100;
            TextButtonPosition r101 = new TextButtonPosition("BOTTOM", 1);
            BOTTOM = r101;
            TextButtonPosition r102 = new TextButtonPosition("AUTO", 2);
            AUTO = r102;
            TextButtonPosition[] r103 = {r100, r101, r102};
            f285172a = r103;
            f285173b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static TextButtonPosition[] values() {
            return (TextButtonPosition[]) f285172a.clone();
        }

        public final int value() {
            int r100 = b.f285174a[ordinal()];
            if (r100 != 1) goto L5;
            return 0;
        L5:
            if (r100 != 2) goto L7;
            return 1;
        L7:
            if (r100 != 3) goto L10;
            return 2;
        L10:
            throw new NoWhenBranchMatchedException();
        }

        public static TextButtonPosition valueOf(String r100) {
            return (TextButtonPosition) r27.a.a(TextButtonPosition.class, r100);
        }

        public TextButtonPosition(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larksuite/component/universe_design/notice/UDNotice$Type;", "", "styleRes", "", "<init>", "(Ljava/lang/String;II)V", "getStyleRes$universe_ui_notice_release", "()I", "INFO", "SUCCESS", "WARNING", "ERROR", "universe-ui-notice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final Type ERROR = null;
        public static final Type INFO = null;
        public static final Type SUCCESS = null;
        public static final Type WARNING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f285175a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f285176b = null;
        private final int styleRes;

        public static EnumEntries<Type> getEntries() {
            return f285176b;
        }

        static {
            Type r100 = new Type("INFO", 0, R.style.UDNotice_Info);
            INFO = r100;
            Type r101 = new Type("SUCCESS", 1, R.style.UDNotice_Success);
            SUCCESS = r101;
            Type r102 = new Type("WARNING", 2, R.style.UDNotice_Warning);
            WARNING = r102;
            Type r103 = new Type("ERROR", 3, R.style.UDNotice_Error);
            ERROR = r103;
            Type[] r104 = {r100, r101, r102, r103};
            f285175a = r104;
            f285176b = EnumEntriesKt.enumEntries(r104);
        }

        public static Type[] values() {
            return (Type[]) f285175a.clone();
        }

        public final int getStyleRes$universe_ui_notice_release() {
            return this.styleRes;
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.styleRes = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f285177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f285178b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View.OnClickListener f285179c;

        public a(int r100, int r101, View.OnClickListener r102) {
            Intrinsics.checkNotNullParameter(r102, "listener");
            this.f285177a = r100;
            this.f285178b = r101;
            this.f285179c = r102;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f285180a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f285181b = null;

        static {
            int[] r100 = new int[Gravity.values().length];
            r100[Gravity.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[Gravity.LEFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            f285180a = r100;
            int[] r101 = new int[TextButtonPosition.values().length];
            r101[TextButtonPosition.RIGHT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r101[TextButtonPosition.BOTTOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L21:
            r101[TextButtonPosition.AUTO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            f285181b = r101;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UDNotice f285182a;

        public c(UDNotice r100) {
            this.f285182a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            View.OnClickListener r101 = this.f285182a.f285159o;
            if (r101 == null) goto L6;
            r101.onClick(r100);
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UDNotice f285183a;

        public d(UDNotice r100) {
            this.f285183a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            View.OnClickListener r101 = this.f285183a.f285155k;
            if (r101 == null) goto L6;
            r101.onClick(r100);
            return;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UDNotice f285184a;

        public e(UDNotice r100) {
            this.f285184a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            View.OnClickListener r101 = this.f285184a.f285155k;
            if (r101 == null) goto L6;
            r101.onClick(r100);
            return;
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UDNotice f285185a;

        public f(UDNotice r100) {
            this.f285185a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            View.OnClickListener r101 = this.f285185a.f285155k;
            if (r101 == null) goto L6;
            r101.onClick(r100);
            return;
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UDNotice f285186a;

        public g(UDNotice r100) {
            this.f285186a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            View.OnClickListener r101 = this.f285186a.f285155k;
            if (r101 == null) goto L6;
            r101.onClick(r100);
            return;
        }
    }

    private final void U5() {
        t08.a r100 = this.f285165u;
        r100.setColor(this.f285160p);
        if (this.f285164t >= 0) goto L5;
        this.f285164t = 0;
    L5:
        r100.setCornerRadius(this.f285164t);
        setBackground(r100);
    }

    private final void Y5() {
        SpannableStringBuilder r100 = new SpannableStringBuilder(this.f285146b);
        Iterator<a> r101 = this.f285148d.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        a r102 = r101.next();
        r100.setSpan(new b18.a(this.f285149e, r102.f285179c), r102.f285177a, r102.f285178b, 34);
        goto L4
    L6:
        this.f285145a.f285212d.setText(r100, TextView.BufferType.SPANNABLE);
        this.f285145a.f285212d.setMovementMethod(LinkMovementMethod.getInstance());
        this.f285145a.f285212d.setHighlightColor(0);
    }

    private final void c6() {
        TextView r100 = this.f285145a.f285212d;
        if (((ArrayList) this.f285148d).isEmpty() == false) goto L5;
        r100.setText(this.f285146b);
    L6:
        r100.setTextColor(this.f285147c);
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r101;
    L10:
        if (r102 == null) goto L20;
        int r103 = b.f285180a[this.f285166v.ordinal()];
        if (r103 != 1) goto L14;
        r102.matchConstraintDefaultWidth = 1;
    L19:
        r100.setLayoutParams(r102);
        goto L20
    L14:
        if (r103 != 2) goto L17;
        ((ViewGroup.MarginLayoutParams) r102).width = 0;
        r102.matchConstraintDefaultWidth = 0;
        goto L19
    L17:
        throw new NoWhenBranchMatchedException();
    L20:
        ImageView r104 = this.f285145a.f285210b;
        Drawable r105 = this.f285150f;
        if (r105 != null) goto L23;
    L26:
        r104.setImageDrawable(this.f285150f);
        ImageView r106 = this.f285145a.f285211c;
        Drawable r107 = this.f285157m;
        if (r107 == null) goto L29;
        r107.mutate();
        r107.setTint(this.f285158n);
    L29:
        r106.setImageDrawable(this.f285157m);
        TextView r108 = this.f285145a.f285214f;
        r108.setText(this.f285153i);
        r108.setTextColor(this.f285154j);
        r108.setOnClickListener(new f(this));
        TextView r109 = this.f285145a.f285213e;
        r109.setText(this.f285153i);
        r109.setTextColor(this.f285154j);
        r109.setOnClickListener(new g(this));
        k6(this.f285162r);
        i6(this.f285163s);
        boolean r110 = this.f285161q;
        this.f285161q = r110;
        n6(this.f285145a.f285210b, r110);
        setMarquee(this.f285168x);
        U5();
        return;
    L23:
        if (this.f285152h == false) goto L25;
        r105.setTintList(null);
        goto L26
    L25:
        r105.mutate();
        r105.setTint(this.f285151g);
        goto L26
    L9:
        r102 = null;
        goto L10
    L5:
        Y5();
        goto L6
    }

    public final void Z5() {
        this.f285145a.f285212d.setText(this.f285146b);
        ((ArrayList) this.f285148d).clear();
    }

    public final Drawable getButtonIcon() {
        return this.f285157m;
    }

    public final int getButtonIconColor() {
        return this.f285158n;
    }

    public final String getButtonText() {
        return this.f285153i;
    }

    public final int getButtonTextColor() {
        return this.f285154j;
    }

    public final Gravity getGravity() {
        return this.f285166v;
    }

    public final Drawable getIcon() {
        return this.f285150f;
    }

    public final int getIconColor() {
        return this.f285151g;
    }

    public final CharSequence getText() {
        return this.f285146b;
    }

    public final int getTextActionColor() {
        return this.f285149e;
    }

    public final TextButtonPosition getTextButtonPosition() {
        return this.f285156l;
    }

    public final int getTextColor() {
        return this.f285147c;
    }

    public UDNotice(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void V5(int r100) {
        T5(null, 0, R.style.UDNotice_Warning);
        c6();
    }

    public final void i6(boolean r100) {
        this.f285163s = r100;
        n6(this.f285145a.f285211c, r100);
    }

    public final void k6(boolean r100) {
        this.f285162r = r100;
        TextButtonPosition r101 = this.f285156l;
        int r102 = b.f285181b[r101.ordinal()];
        if (r102 != 1) goto L5;
        n6(this.f285145a.f285214f, this.f285162r);
        n6(this.f285145a.f285213e, false);
        return;
    L5:
        if (r102 != 2) goto L7;
        n6(this.f285145a.f285214f, false);
        n6(this.f285145a.f285213e, this.f285162r);
        return;
    L7:
        if (r102 != 3) goto L13;
        n6(this.f285145a.f285214f, this.f285162r);
        n6(this.f285145a.f285213e, false);
        if (this.f285167w == true) goto L19;
        this.f285167w = true;
        getViewTreeObserver().addOnGlobalLayoutListener(new y08.a(this));
        return;
    L19:
        return;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final void setBackground(int r100) {
        this.f285160p = r100;
        U5();
    }

    public final void setGravity(Gravity r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER_GRAVITY);
        if (r100 == this.f285166v) goto L6;
        this.f285166v = r100;
        c6();
        return;
    }

    public final void setIcon(int r100) {
        this.f285161q = true;
        n6(this.f285145a.f285210b, true);
        Drawable r101 = UDIconUtils.getIconDrawable(getContext(), r100);
        if (this.f285152h == true) goto L5;
        r101.mutate();
        r101.setTint(this.f285151g);
    L5:
        this.f285150f = r101;
        this.f285145a.f285210b.setImageDrawable(r101);
    }

    public final void setIconButton(int r100) {
        i6(true);
        Drawable r101 = UDIconUtils.getIconDrawable(getContext(), r100);
        r101.mutate();
        r101.setTint(this.f285158n);
        this.f285157m = r101;
        this.f285145a.f285211c.setImageDrawable(r101);
    }

    public final void setIconButtonColor(int r100) {
        this.f285158n = r100;
        Drawable r101 = this.f285157m;
        if (r101 == null) goto L6;
        r101.mutate();
        r101.setTint(this.f285158n);
        return;
    }

    public final void setIconButtonListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "onClickListener");
        this.f285159o = r100;
        this.f285145a.f285211c.setOnClickListener(new c(this));
    }

    public final void setIconColor(int r100) {
        this.f285151g = r100;
        Drawable r101 = this.f285150f;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.f285152h == true) goto L9;
        r101.mutate();
        r101.setTint(this.f285151g);
        return;
    }

    public final void setIconColorful(boolean r100) {
        this.f285152h = r100;
        Drawable r101 = this.f285150f;
        if (r101 == null) goto L8;
        if (r100 == false) goto L6;
        r101.setTintList(null);
        return;
    L6:
        r101.mutate();
        r101.setTint(this.f285151g);
        return;
    }

    public final void setMarquee(boolean r100) {
        if (((ArrayList) this.f285148d).isEmpty() == false) goto L5;
        this.f285168x = r100;
    L7:
        if (this.f285168x == false) goto L9;
        TextView r101 = this.f285145a.f285212d;
        r101.setSingleLine(true);
        r101.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        r101.setMarqueeRepeatLimit(-1);
        r101.setSelected(true);
        return;
    L9:
        TextView r102 = this.f285145a.f285212d;
        r102.setSingleLine(false);
        r102.setEllipsize(null);
        r102.setSelected(false);
        return;
    L5:
        this.f285168x = false;
        goto L7
    }

    public final void setRadius(UDRadius r100) {
        Intrinsics.checkNotNullParameter(r100, "radius");
        this.f285164t = r100.getRadiusSize(getContext());
        U5();
    }

    public final void setText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f285146b = r100;
        this.f285145a.f285212d.setText(r100);
    }

    public final void setTextActionColor(int r100) {
        this.f285149e = r100;
        Y5();
    }

    public final void setTextButton(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        k6(true);
        this.f285153i = r100;
        this.f285145a.f285214f.setText(r100);
        this.f285145a.f285213e.setText(this.f285153i);
    }

    public final void setTextButtonColor(int r100) {
        this.f285154j = r100;
        this.f285145a.f285214f.setTextColor(r100);
        this.f285145a.f285213e.setTextColor(this.f285154j);
    }

    public final void setTextButtonListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "onClickListener");
        this.f285155k = r100;
        this.f285145a.f285214f.setOnClickListener(new d(this));
        this.f285145a.f285213e.setOnClickListener(new e(this));
    }

    public final void setTextButtonPosition(TextButtonPosition r100) {
        Intrinsics.checkNotNullParameter(r100, "position");
        this.f285156l = r100;
        k6(this.f285162r);
    }

    public final void setTextColor(int r100) {
        this.f285147c = r100;
        this.f285145a.f285212d.setTextColor(r100);
    }

    public final void setType(Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        T5(null, 0, r100.getStyleRes$universe_ui_notice_release());
        c6();
    }

    public final void setText(int r100) {
        setText(getContext().getText(r100));
    }

    public UDNotice(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    private final void b6(AttributeSet r100, int r101) {
        T5(r100, r101, R.style.UDNotice_Info);
        c6();
    }

    private static void n6(View r100, boolean r101) {
        if (r101 == false) goto L4;
        int r102 = 0;
    L5:
        r100.setVisibility(r102);
        return;
    L4:
        r102 = 8;
        goto L5
    }

    public UDNotice(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        View r113 = LayoutInflater.from(getContext()).inflate(R.layout.ud_layout_notice, this, false);
        addView(r113);
        int r100 = R.id.ud_notice_icon;
        ImageView r101 = (ImageView) ViewBindings.findChildViewById(r113, R.id.ud_notice_icon);
        if (r101 == null) goto L15;
        r100 = R.id.ud_notice_icon_btn;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(r113, R.id.ud_notice_icon_btn);
        if (r102 == null) goto L15;
        r100 = R.id.ud_notice_text;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r113, R.id.ud_notice_text);
        if (r103 == null) goto L15;
        r100 = R.id.ud_notice_text_btn_bottom;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r113, R.id.ud_notice_text_btn_bottom);
        if (r104 == null) goto L15;
        r100 = R.id.ud_notice_text_btn_right;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r113, R.id.ud_notice_text_btn_right);
        if (r105 == null) goto L15;
        this.f285145a = new UdLayoutNoticeBinding((ConstraintLayout) r113, r101, r102, r103, r104, r105);
        this.f285146b = "";
        this.f285148d = new ArrayList(2);
        this.f285156l = TextButtonPosition.RIGHT;
        this.f285165u = new t08.a();
        this.f285166v = Gravity.LEFT;
        b6(r111, r112);
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r100)));
    }

    public static final /* synthetic */ void R5(UDNotice r100, View r101, boolean r102) {
        r100.getClass();
        n6(r101, r102);
    }

    private final void T5(AttributeSet r100, int r101, int r102) {
        TypedArray r103 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.ud_notice_backgroundColor, R.attr.ud_notice_gravity, R.attr.ud_notice_icon, R.attr.ud_notice_iconBtn, R.attr.ud_notice_iconBtnColor, R.attr.ud_notice_iconColor, R.attr.ud_notice_iconColorful, R.attr.ud_notice_marquee, R.attr.ud_notice_text, R.attr.ud_notice_textActionColor, R.attr.ud_notice_textBtn, R.attr.ud_notice_textBtnColor, R.attr.ud_notice_textBtnPosition, R.attr.ud_notice_textColor, R.attr.ud_radius}, r101, r102);
        CharSequence r104 = r103.getString(8);
        if (r104 != null) goto L6;
        r104 = this.f285146b;
    L6:
        this.f285146b = r104;
        this.f285147c = r103.getColor(13, this.f285147c);
        Drawable r105 = r103.getDrawable(2);
        if (r105 != null) goto L9;
        r105 = this.f285150f;
    L9:
        this.f285150f = r105;
        this.f285151g = r103.getColor(5, this.f285151g);
        this.f285152h = r103.getBoolean(6, this.f285152h);
        if (this.f285150f == null) goto L12;
        boolean r106 = true;
    L13:
        this.f285161q = r106;
        Drawable r107 = r103.getDrawable(3);
        if (r107 != null) goto L16;
        r107 = this.f285157m;
    L16:
        this.f285157m = r107;
        this.f285158n = r103.getColor(4, this.f285158n);
        if (this.f285157m == null) goto L19;
        boolean r108 = true;
    L20:
        this.f285163s = r108;
        String r109 = r103.getString(10);
        if (r109 != null) goto L23;
        r109 = this.f285153i;
    L23:
        this.f285153i = r109;
        this.f285154j = r103.getColor(11, this.f285154j);
        if (this.f285153i == null) goto L26;
        boolean r110 = true;
    L27:
        this.f285162r = r110;
        TextButtonPosition.a r111 = TextButtonPosition.Companion;
        int r112 = r103.getInt(12, this.f285156l.value());
        r111.getClass();
        if (r112 == 0) goto L34;
        if (r112 == 1) goto L33;
        if (r112 == 2) goto L32;
        TextButtonPosition r113 = TextButtonPosition.RIGHT;
    L35:
        this.f285156l = r113;
        this.f285149e = r103.getColor(9, this.f285149e);
        this.f285160p = r103.getColor(0, this.f285160p);
        int r114 = r103.getInt(14, -1);
        if (r114 < 0) goto L38;
        UDRadius.Companion.getClass();
        this.f285164t = UDRadius.a.a(r114).getRadiusSize(getContext());
    L38:
        Gravity.a r115 = Gravity.Companion;
        int r116 = r103.getInt(1, this.f285166v.value());
        r115.getClass();
        if (r116 == 0) goto L43;
        if (r116 == 1) goto L42;
        Gravity r117 = Gravity.LEFT;
    L44:
        this.f285166v = r117;
        this.f285168x = r103.getBoolean(7, this.f285168x);
        r103.recycle();
        return;
    L42:
        r117 = Gravity.CENTER;
        goto L44
    L43:
        r117 = Gravity.LEFT;
        goto L44
    L32:
        r113 = TextButtonPosition.AUTO;
        goto L35
    L33:
        r113 = TextButtonPosition.BOTTOM;
        goto L35
    L34:
        r113 = TextButtonPosition.RIGHT;
        goto L35
    L26:
        r110 = false;
        goto L27
    L19:
        r108 = false;
        goto L20
    L12:
        r106 = false;
        goto L13
    }

    public final void S5(int r100, int r101, View.OnClickListener r102) {
        Intrinsics.checkNotNullParameter(r102, "listener");
        List<a> r103 = this.f285148d;
        ArrayList r104 = (ArrayList) r103;
        r104.add(new a(r100, r101, r102));
        Y5();
        if (this.f285168x == false) goto L6;
        setMarquee(false);
        return;
    }
}
