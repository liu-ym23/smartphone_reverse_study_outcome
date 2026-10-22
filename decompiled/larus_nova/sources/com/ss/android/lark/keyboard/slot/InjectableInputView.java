package com.ss.android.lark.keyboard.slot;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001eB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001d\u001a\u00020\u0017H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/keyboard/slot/InjectableInputView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", RootDescription.ROOT_ELEMENT, "Landroidx/constraintlayout/widget/ConstraintLayout;", "etInput", "Landroid/widget/EditText;", "slotInnerStart", "slotInnerTop", "slotInnerEnd", "slotInnerBottom", "slotTop", "slotTopExtend", "basePaddingPx", "slotSpacingPx", "setSlotView", "", "slot", "Lcom/ss/android/lark/keyboard/slot/InjectableInputView$Slot;", "view", "Landroid/view/View;", "clearSlot", "updateEditTextPadding", "Slot", "keyboard-assembler_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InjectableInputView extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f430931j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f430932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f430933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f430934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f430935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f430936e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f430937f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FrameLayout f430938g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f430939h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f430940i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/keyboard/slot/InjectableInputView$Slot;", "", "<init>", "(Ljava/lang/String;I)V", "InnerStart", "InnerTop", "InnerEnd", "InnerBottom", "Top", "TopExtend", "keyboard-assembler_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Slot extends Enum<Slot> {
        public static final Slot InnerBottom = null;
        public static final Slot InnerEnd = null;
        public static final Slot InnerStart = null;
        public static final Slot InnerTop = null;
        public static final Slot Top = null;
        public static final Slot TopExtend = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Slot[] f430941a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f430942b = null;

        public static EnumEntries<Slot> getEntries() {
            return f430942b;
        }

        static {
            Slot r100 = new Slot("InnerStart", 0);
            InnerStart = r100;
            Slot r101 = new Slot("InnerTop", 1);
            InnerTop = r101;
            Slot r102 = new Slot("InnerEnd", 2);
            InnerEnd = r102;
            Slot r103 = new Slot("InnerBottom", 3);
            InnerBottom = r103;
            Slot r104 = new Slot("Top", 4);
            Top = r104;
            Slot r105 = new Slot("TopExtend", 5);
            TopExtend = r105;
            Slot[] r110 = {r100, r101, r102, r103, r104, r105};
            f430941a = r110;
            f430942b = EnumEntriesKt.enumEntries(r110);
        }

        public static Slot[] values() {
            return (Slot[]) f430941a.clone();
        }

        public static Slot valueOf(String r100) {
            return (Slot) r27.a.a(Slot.class, r100);
        }

        public Slot(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InjectableInputView f430943a;

        public a(InjectableInputView r100) {
            this.f430943a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            InjectableInputView r100 = this.f430943a;
            int r101 = InjectableInputView.f430931j;
            r100.getClass();
            r100.post(new wob.a(r100));
        }
    }

    public InjectableInputView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public InjectableInputView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public InjectableInputView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f430939h = UIUtils.dp2px(r100, 12.0f);
        this.f430940i = UIUtils.dp2px(r100, 4.0f);
        LayoutInflater.from(r100).inflate(R.layout.include_injectable_input, this, true);
        ConstraintLayout r103 = (ConstraintLayout) findViewById(R.id.injectable_root);
        this.f430932a = (EditText) findViewById(R.id.etInput);
        this.f430933b = (FrameLayout) findViewById(R.id.slotInnerStart);
        this.f430934c = (FrameLayout) findViewById(R.id.slotInnerTop);
        this.f430935d = (FrameLayout) findViewById(R.id.slotInnerEnd);
        this.f430936e = (FrameLayout) findViewById(R.id.slotInnerBottom);
        this.f430937f = (FrameLayout) findViewById(R.id.slotTop);
        this.f430938g = (FrameLayout) findViewById(R.id.slotTopExtend);
        r103.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public /* synthetic */ InjectableInputView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
