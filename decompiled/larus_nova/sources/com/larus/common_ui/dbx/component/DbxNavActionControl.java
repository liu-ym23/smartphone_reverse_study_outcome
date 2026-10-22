package com.larus.common_ui.dbx.component;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class DbxNavActionControl extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Appearance f326917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Integer> f326918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DbxButton f326919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f326920d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/common_ui/dbx/component/DbxNavActionControl$Appearance;", "", "<init>", "(Ljava/lang/String;I)V", "STANDARD", "MINI_PROGRAM", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Appearance extends Enum<Appearance> {
        public static final Appearance MINI_PROGRAM = null;
        public static final Appearance STANDARD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Appearance[] f326921a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f326922b = null;

        public static EnumEntries<Appearance> getEntries() {
            return f326922b;
        }

        static {
            Appearance r100 = new Appearance("STANDARD", 0);
            STANDARD = r100;
            Appearance r101 = new Appearance("MINI_PROGRAM", 1);
            MINI_PROGRAM = r101;
            Appearance[] r102 = {r100, r101};
            f326921a = r102;
            f326922b = EnumEntriesKt.enumEntries(r102);
        }

        public static Appearance[] values() {
            return (Appearance[]) f326921a.clone();
        }

        public static Appearance valueOf(String r100) {
            return (Appearance) r27.a.a(Appearance.class, r100);
        }

        public Appearance(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public final void a() {
        float r100 = 1.0f;
        if (this.f326917a == Appearance.MINI_PROGRAM) goto L5;
        setAlpha(1.0f);
        return;
    L5:
        if (isEnabled() == true) goto L8;
        r100 = 0.3f;
    L10:
        setAlpha(r100);
        return;
    L8:
        if (isPressed() == false) goto L10;
        r100 = 0.5f;
        goto L10
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // android.view.View
    public final boolean performClick() {
        Function0<Unit> r100 = this.f326920d;
        boolean r101 = super.performClick();
        if (r100 == null) goto L5;
        r100.invoke();
    L5:
        if (r101 == true) goto L9;
        if (r100 != null) goto L9;
        return false;
    L9:
        return true;
    }

    @Override // android.view.View
    public final void setEnabled(boolean r100) {
        super.setEnabled(r100);
        DbxButton r101 = this.f326919c;
        if (r101 == null) goto L5;
        r101.setEnabled(r100);
    L5:
        a();
    }

    @Override // android.view.View
    public final void setPressed(boolean r100) {
        super.setPressed(r100);
        DbxButton r101 = this.f326919c;
        if (r101 == null) goto L5;
        r101.setPressed(r100);
    L5:
        a();
    }

    public DbxNavActionControl(Context r100, Appearance r101, int r102, c r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "appearance");
        Intrinsics.checkNotNullParameter(r110, "defaultContentColor");
        super(r100);
        this.f326917a = r101;
        this.f326918b = r110;
        AttributeSet r103 = null;
        if (r101 != Appearance.STANDARD) goto L5;
        DbxButton r111 = new DbxButton(r100, r103, 6, 0);
        r111.b(DbxButton.Style.PLAIN, DbxButton.Size.L);
        r111.setClickable(false);
        r111.setFocusable(false);
        r111.setImportantForAccessibility(2);
    L6:
        this.f326919c = r111;
        Appearance r104 = Appearance.MINI_PROGRAM;
        if (r101 != r104) goto L9;
        ImageView r105 = new ImageView(r100);
        r105.setScaleType(ImageView.ScaleType.FIT_CENTER);
    L10:
        setVisibility(8);
        setClickable(true);
        setFocusable(true);
        float r106 = 44;
        Resources r107 = getResources();
        setMinimumHeight((int) ((WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()).density * r106) + 0.5f));
        if (r101 != r104) goto L14;
        Resources r108 = getResources();
        setMinimumWidth((int) ((r106 * WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics()).density) + 0.5f));
    L14:
        if (r111 == null) goto L16;
        addView(r111, new FrameLayout.LayoutParams(-2, -2, 17));
    L16:
        if (r105 == null) goto L18;
        addView(r105, new FrameLayout.LayoutParams(r102, r102, 17));
    L18:
        this.f326920d = null;
        setVisibility(8);
        setContentDescription(null);
        if (r111 == null) goto L21;
        r111.setTitle(null);
        r111.setLeadingIconDrawable(null);
        r111.setAccessibleLabel(null);
        r111.setContentColor(null);
    L21:
        if (r105 == null) goto L23;
        r105.setImageDrawable(null);
        r105.clearColorFilter();
    L23:
        requestLayout();
        return;
    L9:
        r105 = null;
        goto L10
    L5:
        r111 = null;
        goto L6
    }
}
