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
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.larksuite.component.universe_design.radius.UDRadius;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
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

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 j2\u00020\u0001:\u0005jklmnB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\"\u0010.\u001a\u00020/2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u00100\u001a\u00020\nH\u0002J\b\u00101\u001a\u00020/H\u0002J\u0010\u00102\u001a\u00020/2\u0006\u00103\u001a\u00020+H\u0002J\b\u00104\u001a\u00020/H\u0002J\"\u00105\u001a\u00020/2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u00100\u001a\u00020\nH\u0002J\u0010\u00106\u001a\u00020/2\b\b\u0001\u00107\u001a\u00020\nJ\u0010\u00108\u001a\u00020/2\b\b\u0001\u00109\u001a\u00020\nJ\u000e\u00108\u001a\u00020/2\u0006\u0010:\u001a\u00020\rJ\u000e\u0010;\u001a\u00020/2\u0006\u0010:\u001a\u00020\rJ\u000e\u0010<\u001a\u00020/2\u0006\u0010:\u001a\u00020\rJ\u000e\u0010=\u001a\u00020/2\u0006\u0010>\u001a\u00020\u0019J\u000e\u0010?\u001a\u00020/2\u0006\u0010>\u001a\u00020\u0019J\u000e\u0010@\u001a\u00020/2\u0006\u0010>\u001a\u00020\u0019J\u0012\u0010A\u001a\u00020\r2\b\u0010:\u001a\u0004\u0018\u00010\u001bH\u0002J\u0006\u0010B\u001a\u00020\rJ\u0010\u0010C\u001a\u00020/2\b\b\u0001\u0010D\u001a\u00020\nJ\b\u0010E\u001a\u00020\nH\u0007J\u001e\u0010F\u001a\u00020/2\u0006\u0010G\u001a\u00020\n2\u0006\u0010H\u001a\u00020\n2\u0006\u0010I\u001a\u00020JJ\u0006\u0010K\u001a\u00020/J\u0010\u0010L\u001a\u00020/2\b\b\u0001\u0010D\u001a\u00020\nJ\b\u0010M\u001a\u00020\nH\u0007J\u000e\u0010N\u001a\u00020/2\u0006\u0010O\u001a\u00020\u0019J\u0006\u0010P\u001a\u00020\u0019J\u0010\u0010Q\u001a\u00020/2\b\b\u0001\u00109\u001a\u00020\nJ\b\u0010R\u001a\u0004\u0018\u00010\u0016J\u0010\u0010S\u001a\u00020/2\b\b\u0001\u0010D\u001a\u00020\nJ\u000e\u0010T\u001a\u00020/2\u0006\u0010U\u001a\u00020\u0019J\u0006\u0010V\u001a\u00020\u0019J\b\u0010W\u001a\u00020\nH\u0007J\u0006\u0010X\u001a\u00020\u0019J\u000e\u0010Y\u001a\u00020/2\u0006\u0010Z\u001a\u00020[J\u000e\u0010\\\u001a\u00020/2\u0006\u0010]\u001a\u00020&J\u0006\u0010^\u001a\u00020&J\u0010\u0010_\u001a\u00020/2\b\b\u0001\u0010D\u001a\u00020\nJ\u000e\u0010`\u001a\u00020/2\u0006\u0010a\u001a\u00020bJ\u000e\u0010c\u001a\u00020/2\u0006\u0010'\u001a\u00020\u0019J\u0006\u0010'\u001a\u00020\u0019J\u0018\u0010d\u001a\u00020/2\u0006\u0010e\u001a\u00020f2\u0006\u0010O\u001a\u00020\u0019H\u0002J\b\u0010g\u001a\u00020/H\u0002J\b\u0010h\u001a\u00020/H\u0002J\u0012\u0010i\u001a\u00020\r2\b\u0010:\u001a\u0004\u0018\u00010\u001bH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000¨\u0006o"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/secret/TipsNotice;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mText", "", "mTextV2", "mTextV3", "mTextColor", "mTextActions", "", "Lcom/bytedance/ee/bear/middleground/permission/secret/TipsNotice$TextAction;", "mTextActionColor", "mIcon", "Landroid/graphics/drawable/Drawable;", "mIconColor", "mIconColorful", "", "mButtonText", "", "mButtonTextColor", "mButtonIcon", "mBackgroundColor", "mShowIcon", "mShowTextButton", "mShowIconButton", "mRadius", "mBackgroundDrawable", "Lcom/larksuite/component/universe_design/drawable/UDRoundDrawable;", "mGravity", "Lcom/bytedance/ee/bear/middleground/permission/secret/TipsNotice$Gravity;", "isMarquee", "udNoticeIcon", "Landroid/widget/ImageView;", "udNoticeText", "Landroid/widget/TextView;", "udNoticeTextV2", "udNoticeTextV3", "init", "", "defStyleRes", "initView", "initTextView", "tvView", "setupViews", "applyAttrs", "applyStyle", "styleRes", "setTextV1", "resId", "text", "setTextV2", "setTextV3", "setVisibleV1", "isVisible", "setVisibleV2", "setVisibleV3", "processBoldText", "getText", "setTextColor", "color", "getTextColor", "addTextAction", "start", "end", "listener", "Landroid/view/View$OnClickListener;", "clearTextActions", "setTextActionColor", "getTextActionColor", "showIcon", "isShow", "isIconShow", "setIcon", "getIcon", "setIconColor", "setIconColorful", "isColorful", "isIconColorful", "getIconColor", "isTextButtonShow", "setType", "type", "Lcom/bytedance/ee/bear/middleground/permission/secret/TipsNotice$Type;", "setGravity", GXTemplateKey.GAIAX_LAYER_GRAVITY, "getGravity", "setBackground", "setRadius", "radius", "Lcom/larksuite/component/universe_design/radius/UDRadius;", "setMarquee", "showView", "view", "Landroid/view/View;", "buildSpans", "applyBackground", "processFormattedText", "Companion", "Type", "TextButtonPosition", "Gravity", "TextAction", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TipsNotice extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f233992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f233993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Object> f233994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f233995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f233996e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f233997f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f233998g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f233999h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f234000i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable f234001j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f234002k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f234003l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f234004m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final t08.a f234005n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Gravity f234006o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f234007p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ImageView f234008q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f234009r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f234010s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f234011t;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007j\u0002\b\u0004j\u0002\b\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/secret/TipsNotice$Gravity;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "CENTER", "value", "", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Gravity extends Enum<Gravity> {
        public static final Gravity CENTER = null;
        public static final a Companion = null;
        public static final Gravity LEFT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Gravity[] f234012a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f234013b = null;

        public static final class a {
            public a() {
            }
        }

        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f234014a = null;

            static {
                int[] r100 = new int[Gravity.values().length];
                r100[Gravity.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[Gravity.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f234014a = r100;
            }
        }

        public static EnumEntries<Gravity> getEntries() {
            return f234013b;
        }

        static {
            Gravity r100 = new Gravity("LEFT", 0);
            LEFT = r100;
            Gravity r101 = new Gravity("CENTER", 1);
            CENTER = r101;
            Gravity[] r102 = {r100, r101};
            f234012a = r102;
            f234013b = EnumEntriesKt.enumEntries(r102);
            Companion = new a();
        }

        public static Gravity[] values() {
            return (Gravity[]) f234012a.clone();
        }

        public final int value() {
            int r100 = b.f234014a[ordinal()];
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

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/secret/TipsNotice$TextButtonPosition;", "", "<init>", "(Ljava/lang/String;I)V", "RIGHT", "BOTTOM", "AUTO", "value", "", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TextButtonPosition extends Enum<TextButtonPosition> {
        public static final TextButtonPosition AUTO = null;
        public static final TextButtonPosition BOTTOM = null;
        public static final a Companion = null;
        public static final TextButtonPosition RIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TextButtonPosition[] f234015a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f234016b = null;

        public static final class a {
            public a() {
            }
        }

        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f234017a = null;

            static {
                int[] r100 = new int[TextButtonPosition.values().length];
                r100[TextButtonPosition.RIGHT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[TextButtonPosition.BOTTOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[TextButtonPosition.AUTO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f234017a = r100;
            }
        }

        public static EnumEntries<TextButtonPosition> getEntries() {
            return f234016b;
        }

        static {
            TextButtonPosition r100 = new TextButtonPosition("RIGHT", 0);
            RIGHT = r100;
            TextButtonPosition r101 = new TextButtonPosition("BOTTOM", 1);
            BOTTOM = r101;
            TextButtonPosition r102 = new TextButtonPosition("AUTO", 2);
            AUTO = r102;
            TextButtonPosition[] r103 = {r100, r101, r102};
            f234015a = r103;
            f234016b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static TextButtonPosition[] values() {
            return (TextButtonPosition[]) f234015a.clone();
        }

        public final int value() {
            int r100 = b.f234017a[ordinal()];
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

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/secret/TipsNotice$Type;", "", "styleRes", "", "<init>", "(Ljava/lang/String;II)V", "getStyleRes$middleground_permission_productionChinaRelease", "()I", "INFO", "SUCCESS", "WARNING", "ERROR", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final Type ERROR = null;
        public static final Type INFO = null;
        public static final Type SUCCESS = null;
        public static final Type WARNING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f234018a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f234019b = null;
        private final int styleRes;

        public static EnumEntries<Type> getEntries() {
            return f234019b;
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
            f234018a = r104;
            f234019b = EnumEntriesKt.enumEntries(r104);
        }

        public static Type[] values() {
            return (Type[]) f234018a.clone();
        }

        public final int getStyleRes$middleground_permission_productionChinaRelease() {
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
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f234020a = null;

        static {
            int[] r100 = new int[Gravity.values().length];
            r100[Gravity.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Gravity.LEFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f234020a = r100;
        }
    }

    static {
    }

    public final void S5() {
        t08.a r100 = this.f234005n;
        r100.setColor(this.f234002k);
        if (this.f234004m >= 0) goto L5;
        this.f234004m = 0;
    L5:
        r100.setCornerRadius(this.f234004m);
        setBackground(r100);
    }

    public final void U5() {
        TextView r100 = this.f234009r;
        ImageView r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeText");
        r100 = null;
    L5:
        T5(r100);
        TextView r102 = this.f234010s;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeTextV2");
        r102 = null;
    L8:
        T5(r102);
        TextView r103 = this.f234011t;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeTextV3");
        r103 = null;
    L11:
        T5(r103);
        ImageView r104 = this.f234008q;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeIcon");
        r104 = null;
    L14:
        Drawable r105 = this.f233996e;
        if (r105 != null) goto L17;
    L20:
        r104.setImageDrawable(this.f233996e);
        this.f234003l = this.f234003l;
        ImageView r106 = this.f234008q;
        if (r106 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeIcon");
    L25:
        if (this.f234003l == false) goto L27;
        int r107 = 0;
    L28:
        r101.setVisibility(r107);
        setMarquee(this.f234007p);
        S5();
        return;
    L27:
        r107 = 8;
        goto L28
    L23:
        r101 = r106;
        goto L25
    L17:
        if (this.f233998g == false) goto L19;
        r105.setTintList(null);
        goto L20
    L19:
        r105.mutate();
        r105.setTint(this.f233997f);
        goto L20
    }

    public final Gravity getGravity() {
        return this.f234006o;
    }

    public final Drawable getIcon() {
        return this.f233996e;
    }

    public final int getIconColor() {
        return this.f233997f;
    }

    public final CharSequence getText() {
        return this.f233992a;
    }

    public final int getTextActionColor() {
        return this.f233995d;
    }

    public final int getTextColor() {
        return this.f233993b;
    }

    public TipsNotice(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void T5(TextView r100) {
        r100.setTextColor(this.f233993b);
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ConstraintLayout.LayoutParams) == false) goto L5;
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r101;
    L6:
        if (r102 == null) goto L17;
        Gravity r103 = this.f234006o;
        int r104 = b.f234020a[r103.ordinal()];
        if (r104 != 1) goto L10;
        r102.matchConstraintDefaultWidth = 1;
    L15:
        r100.setLayoutParams(r102);
        return;
    L10:
        if (r104 != 2) goto L13;
        ((ViewGroup.MarginLayoutParams) r102).width = 0;
        r102.matchConstraintDefaultWidth = 0;
        goto L15
    L13:
        throw new NoWhenBranchMatchedException();
    L17:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setBackground(int r100) {
        this.f234002k = r100;
        S5();
    }

    public final void setGravity(Gravity r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER_GRAVITY);
        if (r100 == this.f234006o) goto L6;
        this.f234006o = r100;
        U5();
        return;
    }

    public final void setIcon(int r100) {
        this.f234003l = true;
        ImageView r101 = this.f234008q;
        ImageView r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeIcon");
        r101 = null;
    L6:
        if (this.f234003l == false) goto L8;
        int r103 = 0;
    L9:
        r101.setVisibility(r103);
        Drawable r104 = AppCompatResources.getDrawable(getContext(), kac.a.b(r100));
        if (r104 != null) goto L12;
        r104 = null;
    L15:
        this.f233996e = r104;
        ImageView r105 = this.f234008q;
        if (r105 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeIcon");
    L19:
        r102.setImageDrawable(this.f233996e);
        return;
    L18:
        r102 = r105;
        goto L19
    L12:
        if (this.f233998g == true) goto L15;
        r104.mutate();
        r104.setTint(this.f233997f);
        goto L15
    L8:
        r103 = 8;
        goto L9
    }

    public final void setIconColor(int r100) {
        this.f233997f = r100;
        Drawable r101 = this.f233996e;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.f233998g == true) goto L9;
        r101.mutate();
        r101.setTint(this.f233997f);
        return;
    }

    public final void setIconColorful(boolean r100) {
        this.f233998g = r100;
        Drawable r101 = this.f233996e;
        if (r101 == null) goto L8;
        if (r100 == false) goto L6;
        r101.setTintList(null);
        return;
    L6:
        r101.mutate();
        r101.setTint(this.f233997f);
        return;
    }

    public final void setMarquee(boolean r100) {
        if (((ArrayList) this.f233994c).isEmpty() == false) goto L5;
        this.f234007p = r100;
    L6:
        TextView r101 = null;
        if (this.f234007p == false) goto L13;
        TextView r102 = this.f234009r;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeText");
    L12:
        r101.setSingleLine(true);
        r101.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        r101.setMarqueeRepeatLimit(-1);
        r101.setSelected(true);
        return;
    L11:
        r101 = r102;
        goto L12
    L13:
        TextView r103 = this.f234009r;
        if (r103 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeText");
        r103 = null;
    L16:
        r103.setSingleLine(false);
        r103.setEllipsize(null);
        r103.setSelected(false);
        return;
    L5:
        this.f234007p = false;
        goto L6
    }

    public final void setRadius(UDRadius r100) {
        Intrinsics.checkNotNullParameter(r100, "radius");
        this.f234004m = r100.getRadiusSize(getContext());
        S5();
    }

    public final void setTextActionColor(int r100) {
        this.f233995d = r100;
        SpannableStringBuilder r101 = new SpannableStringBuilder(this.f233992a);
        TextView r102 = this.f234009r;
        TextView r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeText");
        r102 = null;
    L5:
        r102.setText(r101, TextView.BufferType.SPANNABLE);
        TextView r104 = this.f234009r;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeText");
        r104 = null;
    L8:
        r104.setMovementMethod(LinkMovementMethod.getInstance());
        TextView r105 = this.f234009r;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeText");
    L12:
        r103.setHighlightColor(0);
        return;
    L11:
        r103 = r105;
        goto L12
    }

    public final void setTextColor(int r100) {
        this.f233993b = r100;
        TextView r101 = this.f234009r;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeText");
        r101 = null;
    L5:
        r101.setTextColor(this.f233993b);
    }

    public final void setTextV1(CharSequence r110) {
        Intrinsics.checkNotNullParameter(r110, "text");
        this.f233992a = r110;
        TextView r100 = this.f234009r;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeText");
        r100 = null;
    L5:
        String r111 = r110.toString();
        int r101 = 0;
        if (r111 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        CharSequence r103 = "";
        if (r102 == true) goto L26;
        SpannableStringBuilder r104 = new SpannableStringBuilder();
        Matcher r105 = PatternProtector.compile("\\*\\*(.*?)\\*\\*").matcher(r111);
    L17:
        if (r105.find(r101) == false) goto L23;
        r104.append(r111.substring(r101, r105.start()));
        String r106 = r105.group(1);
        if (r106 != null) goto L21;
        r106 = "";
    L21:
        int r107 = r104.length();
        r104.append(r106);
        r104.setSpan(new StyleSpan(1), r107, r104.length(), 33);
        r101 = r105.end();
        goto L17
    L23:
        if (r101 >= r111.length()) goto L25;
        r104.append(r111.substring(r101));
    L25:
        r103 = r104;
    L26:
        r100.setText(r103);
        return;
    L8:
        if (r111.length() == 0) goto L11;
        r102 = false;
        goto L12
    }

    public final void setTextV2(CharSequence r110) {
        Intrinsics.checkNotNullParameter(r110, "text");
        TextView r100 = this.f234010s;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeTextV2");
        r100 = null;
    L5:
        String r101 = r110.toString();
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        CharSequence r111 = "";
    L34:
        r100.setText(r111);
        return;
    L14:
        SpannableStringBuilder r103 = new SpannableStringBuilder();
        Iterator r104 = StringsKt.split$default(r101, new String[]{"\n"}, false, 0, 6, null).iterator();
    L16:
        if (r104.hasNext() == false) goto L33;
        String r105 = (String) r104.next();
        if (r103.length() <= 0) goto L20;
        boolean r106 = true;
    L21:
        if (r106 == false) goto L24;
        r103.append("\n");
    L24:
        if (r105.length() <= 0) goto L26;
        boolean r107 = true;
    L28:
        if (r107 == false) goto L32;
        if (r105.charAt(0) != '-') goto L32;
        r103.append(" ");
        int r108 = r103.length();
        r103.append("•");
        r103.setSpan(new StyleSpan(1), r108, r108 + 1, 33);
        r103.append(r105.substring(1));
    L32:
        int r109 = r103.length();
        r103.append(r105);
        r103.setSpan(new StyleSpan(1), r109, r103.length(), 33);
        goto L16
    L26:
        r107 = false;
        goto L28
    L20:
        r106 = false;
        goto L21
    L33:
        r111 = r103;
        goto L34
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
        goto L12
    }

    public final void setTextV3(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        TextView r101 = this.f234011t;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeTextV3");
        r101 = null;
    L5:
        r101.setText(r100);
    }

    public final void setType(Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        R5(null, 0, r100.getStyleRes$middleground_permission_productionChinaRelease());
        U5();
    }

    public final void setVisibleV1(boolean r100) {
        TextView r101 = this.f234009r;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeText");
        r101 = null;
    L5:
        if (r100 == false) goto L7;
        int r102 = 0;
    L8:
        r101.setVisibility(r102);
        return;
    L7:
        r102 = 8;
        goto L8
    }

    public final void setVisibleV2(boolean r100) {
        TextView r101 = this.f234010s;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeTextV2");
        r101 = null;
    L5:
        if (r100 == false) goto L7;
        int r102 = 0;
    L8:
        r101.setVisibility(r102);
        return;
    L7:
        r102 = 8;
        goto L8
    }

    public final void setVisibleV3(boolean r100) {
        TextView r101 = this.f234011t;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("udNoticeTextV3");
        r101 = null;
    L5:
        if (r100 == false) goto L7;
        int r102 = 0;
    L8:
        r101.setVisibility(r102);
        return;
    L7:
        r102 = 8;
        goto L8
    }

    public final void setTextV1(int r100) {
        setTextV1(getContext().getText(r100));
    }

    public TipsNotice(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public TipsNotice(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f233992a = "";
        this.f233994c = new ArrayList(2);
        this.f234005n = new t08.a();
        this.f234006o = Gravity.LEFT;
        init(r101, r102, R.style.UDNotice_Info);
    }

    public final void R5(AttributeSet r100, int r101, int r102) {
        TypedArray r103 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.ud_notice_backgroundColor, R.attr.ud_notice_gravity, R.attr.ud_notice_icon, R.attr.ud_notice_iconBtn, R.attr.ud_notice_iconBtnColor, R.attr.ud_notice_iconColor, R.attr.ud_notice_iconColorful, R.attr.ud_notice_marquee, R.attr.ud_notice_text, R.attr.ud_notice_textActionColor, R.attr.ud_notice_textBtn, R.attr.ud_notice_textBtnColor, R.attr.ud_notice_textBtnPosition, R.attr.ud_notice_textColor, R.attr.ud_radius}, r101, r102);
        CharSequence r104 = r103.getString(8);
        if (r104 != null) goto L6;
        r104 = this.f233992a;
    L6:
        this.f233992a = r104;
        this.f233993b = r103.getColor(13, this.f233993b);
        int r105 = r103.getResourceId(2, 0);
        if (r105 == 0) goto L9;
        Drawable r106 = AppCompatResources.getDrawable(getContext(), kac.a.b(r105));
    L12:
        this.f233996e = r106;
        this.f233997f = r103.getColor(5, this.f233997f);
        this.f233998g = r103.getBoolean(6, this.f233998g);
        if (this.f233996e == null) goto L15;
        boolean r107 = true;
    L16:
        this.f234003l = r107;
        int r108 = r103.getResourceId(3, 0);
        if (r108 == 0) goto L19;
        Drawable r109 = AppCompatResources.getDrawable(getContext(), kac.a.b(r108));
    L22:
        this.f234001j = r109;
        String r110 = r103.getString(10);
        if (r110 != null) goto L25;
        r110 = this.f233999h;
    L25:
        this.f233999h = r110;
        this.f234000i = r103.getColor(11, this.f234000i);
        this.f233995d = r103.getColor(9, this.f233995d);
        this.f234002k = r103.getColor(0, this.f234002k);
        int r111 = r103.getInt(14, -1);
        if (r111 < 0) goto L28;
        UDRadius.Companion.getClass();
        this.f234004m = UDRadius.a.a(r111).getRadiusSize(getContext());
    L28:
        Gravity.a r112 = Gravity.Companion;
        int r113 = r103.getInt(1, this.f234006o.value());
        r112.getClass();
        if (r113 == 0) goto L33;
        if (r113 == 1) goto L32;
        Gravity r114 = Gravity.LEFT;
    L34:
        this.f234006o = r114;
        this.f234007p = r103.getBoolean(7, this.f234007p);
        r103.recycle();
        return;
    L32:
        r114 = Gravity.CENTER;
        goto L34
    L33:
        r114 = Gravity.LEFT;
        goto L34
    L19:
        r109 = r103.getDrawable(3);
        if (r109 != null) goto L22;
        r109 = this.f234001j;
        goto L22
    L15:
        r107 = false;
        goto L16
    L9:
        r106 = r103.getDrawable(2);
        if (r106 != null) goto L12;
        r106 = this.f233996e;
        goto L12
    }

    public final void init(AttributeSet r100, int r101, int r102) {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_notice_tips, this, true);
        this.f234008q = (ImageView) findViewById(R.id.ud_notice_icon);
        this.f234009r = (TextView) findViewById(R.id.ud_notice_text);
        this.f234010s = (TextView) findViewById(R.id.ud_notice_text_v2);
        this.f234011t = (TextView) findViewById(R.id.ud_notice_text_v3);
        R5(r100, r101, R.style.UDNotice_Info);
        U5();
    }
}
